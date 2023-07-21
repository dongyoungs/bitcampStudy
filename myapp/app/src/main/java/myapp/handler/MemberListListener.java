package myapp.handler;

import java.util.List;
import myapp.dao.MemberDao;
import myapp.vo.Member;
import util.ActionListener;
import util.BreadcrumbPrompt;

public class MemberListListener implements ActionListener {

  MemberDao memberDao;

  public MemberListListener(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("------------------------------");
    System.out.println("번호, 이름, 이메일, 성별");
    System.out.println("------------------------------");

    List<Member> list = memberDao.list();
    for(Member m : list) {
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(),
          m.getGender() ==  'M' ? "MALE" : "FEMALE");
    }
  }
}










