package myapp.handler;

import myapp.dao.MemberDao;
import myapp.vo.Member;
import util.BreadcrumbPrompt;

public class MemberUpdateListener implements MemberActionsListener {

  MemberDao memberDao;

  public MemberUpdateListener(MemberDao memberDao) {
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
    m.setName(prompt.inputString("이름:(%s) ", m.getName()));
    m.setEmail(prompt.inputString("이메일:(%s) ", m.getEmail()));
    m.setPassword(prompt.inputString("새암호? "));
    //System.out.printf("성별: %s\n", toGenderString(m.getGender()));
    m.setGender(MemberActionsListener.inputGender(m.getGender(),prompt));

    memberDao.update(m);
  }
}










