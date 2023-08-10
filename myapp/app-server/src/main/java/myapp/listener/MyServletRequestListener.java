package myapp.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import myapp.handler.InitServlet;
import util.SqlSessionFactoryProxy;

// 요청이나 응답을 수행했을 때 서블릿 컨테이너로 부터 알림을 받는 옵저버 객체
@WebListener // 서블릿 컨테이너에게 이 클래스가 리스너임을 알린다.
public class MyServletRequestListener implements ServletRequestListener {

  public MyServletRequestListener() {
    System.out.println("리스너 객체 생성");
  }
  @Override
  public void requestDestroyed(ServletRequestEvent sre) {
    ((SqlSessionFactoryProxy) InitServlet.sqlSessionFactory).clean();
  }
}
