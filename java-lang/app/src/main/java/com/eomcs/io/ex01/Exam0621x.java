// 디렉토리에 들어있는 파일(디렉토리) 목록을 꺼낼 때 필터 적용하기 II
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0621x {


  public static void main(String[] args) throws Exception {
    //        FileFilter javaFilter = new FileFilter() {
    //          @Override
    //          public boolean accept(File file) {
    //            if (file.isFile() && file.getName().endsWith(".java"))
    //              return true;
    //            return false;
    //          }
    //        };

    File dir = new File(".");
    File[] files = dir.listFiles(
        file  -> file.isFile() && file.getName().endsWith(".java"));
    for (File file : files) {
      System.out.printf("%s %12d %s\n",
          file.isDirectory() ? "d" : "-",
              file.length(),
              file.getName());
    }

  }

}


