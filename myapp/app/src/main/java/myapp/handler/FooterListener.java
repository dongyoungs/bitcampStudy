package myapp.handler;

import util.ActionListener;
import util.BreadcrumbPrompt;

public class FooterListener implements ActionListener{

  @Override
  public void service (BreadcrumbPrompt prompt) {
    System.out.printf("Copyright \u00A9 by 네클7기----------엄-------");
  }

}
