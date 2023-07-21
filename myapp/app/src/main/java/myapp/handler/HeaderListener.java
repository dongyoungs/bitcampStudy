package myapp.handler;

import util.ActionListener;
import util.BreadcrumbPrompt;

public class HeaderListener implements ActionListener{

  @Override
  public void service (BreadcrumbPrompt prompt) {
    System.out.printf("====================[bitCamp!]==");
  }

}
