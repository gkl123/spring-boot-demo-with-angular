package org.demo.web.controller;

public class ChildClass extends TestController {
  public static void main(String args[]) {
        ChildClass child = new ChildClass();
  }
  
  private static String a = "初始值";
  
  @Override
  public void func() {
      System.out.println("childclass func print");
  }
  
  public ChildClass() {
      this.a = "1";
      System.out.println("ChildClass default Constructor : a = " + a);
  }
  
}
