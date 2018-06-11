package org.demo.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.demo.dao.repository.RedisRepository;
import org.demo.model.po.DemoOrder;
import org.demo.service.DemoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

@RestController
@RequestMapping("/order")
public class DemoOrderController {
	
	@Autowired
	private DemoOrderService demoOrderService;
	
	@Autowired
	private RedisRepository redisrepository;
	
	@RequestMapping("/addOrder")
	public DemoOrder addOrder(@RequestBody DemoOrder order) {
		demoOrderService.add(order);
		return order;
	}

	@RequestMapping("/delete")
	public void deleteOrder(@RequestBody DemoOrder order) {
		demoOrderService.delete(order.getId());
	}
	
	@RequestMapping("/listOrder")
	public List<DemoOrder> listOrder(@RequestBody DemoOrder order) {
		return demoOrderService.listOrder(order);
	}
	
	@RequestMapping(value = "/getOrder", method=RequestMethod.GET)
	public DemoOrder getDemoOrder(@RequestParam(value="id") String id) {
	    return demoOrderService.get(id);
	}
	
	@RequestMapping("/updateOrder")
	public void updateOrder(@RequestBody DemoOrder order) {
	    demoOrderService.update(order);
	}
	
	
	/**
	 * 上傳文件
	 * @param file
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/uploadfile")
	public String upload_img(MultipartFile file,HttpServletRequest request) throws Exception{
	    
	    String path="D:/upload/news";
	    
	    //创建文件 
	    File dir=new File(path);
	    if(!dir.exists()){
	        dir.mkdirs();
	    }
	    
	    String id = "1234567890123";
	    String fileName=file.getOriginalFilename();

	    String img=id+fileName.substring(fileName.lastIndexOf("."));//zhao.jpg
	    FileOutputStream imgOut=new FileOutputStream(new File(dir,img));//根据 dir 抽象路径名和 img 路径名字符串创建一个新 File 实例。
	   /* System.out.println(file.getBytes());*/
	    imgOut.write(file.getBytes());//返回一个字节数组文件的内容
	    imgOut.close();
	    Map<String, String> map=new HashMap<String, String>();
	    map.put("path",img);
	    return JSON.toJSONString(map);
	}
	
	
	/**
	 * redis操作測試
	 */
	@RequestMapping("redistest")
	public Object testRedis(String key, String value) {
	    redisrepository.set(key, value);
	    Object obj = redisrepository.get(key);
	    return obj;
	}
}
