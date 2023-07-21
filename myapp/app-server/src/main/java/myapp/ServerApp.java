


package myapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import myapp.dao.BoardListDao;
import myapp.dao.MemberListDao;
import net.RequestEntity;
import net.ResponseEntity;


public class ServerApp {

  int port;
  ServerSocket serverSocket;

  HashMap<String,Object> daoMap = new HashMap<>();

  //스레드를 리턴해 줄 스레드풀 준비
  ExecutorService threadPool = Executors.newFixedThreadPool(10);

  public ServerApp( int port) throws Exception {
    this.port = port;
    // DAO 객체 생성 및 보관
    daoMap.put("member", new MemberListDao("Member.json"));
    daoMap.put("board", new BoardListDao("Board.json"));
    daoMap.put("reading", new BoardListDao("Reading.json"));
  }

  public static void main(String[] args) throws Exception {
    if (args.length <1) {
      System.out.println("실행 예) java... bitcamp.... 포트번포");
    }
    ServerApp app = new ServerApp(Integer.parseInt(args[0]));
    app.execute();
    app.close();

  }
  public void execute() throws Exception{

    System.out.println("[MYList 서버 어플리케이션]");

    this.serverSocket = new ServerSocket(port);
    System.out.println("서버 실행중...");
    while (true) {
      Socket socket = serverSocket.accept();
      threadPool.execute(() -> processRequest(socket));

    }
  }

  public static Method findMethod (Object obj, String methodName) {
    Method[] methods = obj.getClass().getDeclaredMethods();
    Method method = null;
    for (int i = 0; i < methods.length;i++) {
      if (methods[i].getName().equals(methodName)) {
        method = methods[i];
        break;
      }
    }
    return method;
  }

  //메서드 호출하기
  public static Object call(Object obj, Method method, RequestEntity request) throws Exception {
    Parameter[] params = method.getParameters();
    if (params.length > 0) {
      return method.invoke(obj, request.getObject(params[0].getType()));
    } else {
      return method.invoke(obj);
    }
  }

  // 클라이언트와 접속이 이루어지면 클라이언트의 요청 처리
  public void processRequest(Socket socket ) {

    try(Socket s = socket;
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream())){

      InetSocketAddress socketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
      System.out.printf("[%s] %s:%s 클라이언트가 접속했음!\n",
          Thread.currentThread().getName(),
          socketAddress.getHostString(),
          socketAddress.getPort());

      // 클라이언트 요청을 반복해서 처리하지 않는다.
      // 접속 -> 요청 -> 실행 -> 응답 -> 연결 끊기
      RequestEntity  request= RequestEntity.fromJson(in.readUTF());

      String command = request.getCommand();
      System.out.println(command);

      String[] values = command.split("/");
      String dataName = values[0];
      // 데이터 이름으로 DAO 객체를 꺼낸다.
      Object dao = daoMap.get(dataName);
      if (dao == null) {
        // 만약 데이터를 처리할 DAO를 찾지 못한다면 오류 정보를 클라이언트에게 보낸다.
        out.writeUTF(new ResponseEntity()
            .status(ResponseEntity.ERROR)
            .result("데이터를 찾을 수 없습니다.")
            .toJson());
        return;
      }
      // DAO에 해당 메서드가 있는지 알아낸다.
      dataName = values[1];
      Method method = findMethod(dao,dataName);
      if (method == null) {
        // 만약 클라이언트가 요청한 메서드를 찾지 못한다면 오류 정보를 클라이언트에게 보낸다.
        out.writeUTF(new ResponseEntity()
            .status(ResponseEntity.ERROR)
            .result("데이터를 찾을 수 없습니다.")
            .toJson());
        return;
      }
      try {
        Object result = call(dao, method, request);

        ResponseEntity response = new ResponseEntity();
        response.status(ResponseEntity.SUCCESS);
        response.result(result);
        out.writeUTF(response.toJson());
        Thread.sleep(10000);

      } catch (Exception e) {
        System.out.printf("%s\n", e.getMessage());
      }






    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }


  public void close() throws IOException {
    serverSocket.close();
  }


}






















