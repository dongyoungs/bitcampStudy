package myapp.handler;

import myapp.dao.MemberDao;
import util.ActionListener;
import util.BreadcrumbPrompt;

public class MemberDeleteListener implements ActionListener{

  MemberDao memberDao;

  public MemberDeleteListener(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    if (memberDao.delete(prompt.inputInt("번호 ?")) == 0) {
      System.out.println("해당 회원이 없습니다!");
      return;
    }
    System.out.println("삭제완료");
  }
}










