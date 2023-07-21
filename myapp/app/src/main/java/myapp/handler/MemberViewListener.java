package myapp.handler;

import myapp.dao.MemberDao;
import myapp.vo.Member;
import util.ActionListener;
import util.BreadcrumbPrompt;

public class MemberViewListener implements ActionListener {

  MemberDao memberDao;

  public MemberViewListener(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    String memberNo = prompt.inputString("번호 ? ");
    int num = Integer.parseInt(memberNo.replaceAll("[^0-9]", ""));
    Member m = memberDao.findBy(num);
    if ( m == null) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }
    System.out.printf("이름: %s\n", m.getName());
    System.out.printf("이메일: %s\n", m.getEmail());
    System.out.printf("성별: %s\n", m.getGender() ==  'M' ? "MALE" : "FEMALE");
  }

}










