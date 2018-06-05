package org.demo.web.controller;

public class TestController {
    
    public TestController() {
        System.out.println("TestController constructor");
        func();
    }
    
    static {
        System.out.println("TestController static code");
    }
    
    public void func() {
        System.out.println("fatherClass func print");
    }
  
}
