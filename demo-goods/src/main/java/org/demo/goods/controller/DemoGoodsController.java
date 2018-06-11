package org.demo.goods.controller;

import org.demo.goods.service.DemoGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class DemoGoodsController {
    
    @Autowired
    private DemoGoodsService goodsService;
    
    @Value("${test.config.file}")
    private String testStr;
    
    @RequestMapping("test")
    @ResponseBody
    public void test() {
        System.out.println("hello, world + testStr :" + testStr);
    }

}
