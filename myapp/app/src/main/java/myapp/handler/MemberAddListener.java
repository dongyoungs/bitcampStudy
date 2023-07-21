package myapp.handler;

import myapp.dao.MemberDao;
import myapp.vo.Member;
import util.BreadcrumbPrompt;

public class MemberAddListener implements MemberActionsListener{

  MemberDao memberDao;

  public MemberAddListener(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {

    Member m = new Member();
    m.setName(prompt.inputString("이름? "));
    m.setEmail(prompt.inputString("이메일? "));
    m.setPassword(prompt.inputString("암호? "));
    m.setGender(MemberActionsListener.inputGender((char) 0, prompt));

    memberDao.insert(m);
  }
}










