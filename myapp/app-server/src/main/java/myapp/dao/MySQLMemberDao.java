package myapp.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import myapp.vo.Member;


public class MySQLMemberDao implements MemberDao{

  SqlSessionFactory sqlSessionFactory;

  public MySQLMemberDao(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void insert(Member member) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    sqlSession.insert("myapp.dao.MemberDao.insert",member);
  }

  /*
   *
   */

  @Override
  public List<Member> findAll() {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    return sqlSession.selectList("myapp.dao.MemberDao.findAll");
  }

  @Override
  public Member findBy(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    return sqlSession.selectOne("myapp.dao.MemberDao.findBy",no);
  }



  @Override
  public int update(Member member) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    return sqlSession.update("myapp.dao.MemberDao.update",member);

  }

  @Override
  public int delete(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession(false);
    int k = sqlSession.delete("myapp.dao.MemberDao.delete", no);

    return k;
  }

  @Override
  public Member findByEmailAndPassword(Member param) {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    return sqlSession.selectOne("myapp.dao.MemberDao.findByEmailAndPassword", param);
  }

}
