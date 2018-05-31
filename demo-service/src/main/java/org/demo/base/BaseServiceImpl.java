package org.demo.base;

import java.io.Serializable;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseServiceImpl<T extends Serializable> {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 用于获取新对象时生成Id
	 * @return
	 */
	public String getId() {
		return System.currentTimeMillis() + getRandomString(5);
	}
	
	private String getRandomString(int length) { // length表示生成字符串的长度
		String base = "0123456789";

		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

}
