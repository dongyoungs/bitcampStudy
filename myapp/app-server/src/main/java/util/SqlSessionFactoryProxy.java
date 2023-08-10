package util;

import java.sql.Connection;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.TransactionIsolationLevel;

public class SqlSessionFactoryProxy implements SqlSessionFactory{

  SqlSessionFactory original;
  ThreadLocal<SqlSession> sqlSessionBox = new ThreadLocal<>();

  public SqlSessionFactoryProxy(SqlSessionFactory original) {
    this.original = original;
  }

  @Override
  public SqlSession openSession() {
    return openSession(true);
  }
  public void clean() {
    SqlSession sqlSession = sqlSessionBox.get();
    if (sqlSession != null) {
      sqlSession.close();
      sqlSession.rollback();
      sqlSessionBox.remove();
      System.out.println("스레드에서 SqlSession 제거!");
    }

  }

  @Override
  public SqlSession openSession(boolean autoCommit) {
    if (!autoCommit) {
      SqlSession sqlSession = sqlSessionBox.get();
      if (sqlSession == null) {
        sqlSession = original.openSession(false);
        sqlSessionBox.set(sqlSession);
      }
      return sqlSession;
    }
    return original.openSession(autoCommit);
  }

  @Override
  public SqlSession openSession(Connection connection) {
    // TODO Auto-generated method stub
    return original.openSession(connection);
  }

  @Override
  public SqlSession openSession(TransactionIsolationLevel level) {
    // TODO Auto-generated method stub
    return original.openSession(level);
  }

  @Override
  public SqlSession openSession(ExecutorType execType) {
    // TODO Auto-generated method stub
    return original.openSession(execType);
  }

  @Override
  public SqlSession openSession(ExecutorType execType, boolean autoCommit) {
    // TODO Auto-generated method stub
    return  original.openSession(execType,autoCommit);
  }

  @Override
  public SqlSession openSession(ExecutorType execType, TransactionIsolationLevel level) {
    // TODO Auto-generated method stub
    return original.openSession(execType,level);
  }

  @Override
  public SqlSession openSession(ExecutorType execType, Connection connection) {
    // TODO Auto-generated method stub
    return original.openSession(execType,connection);
  }

  @Override
  public Configuration getConfiguration() {
    // TODO Auto-generated method stub
    return original.getConfiguration();
  }



}
