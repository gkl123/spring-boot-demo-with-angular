package org.demo.base;

import java.io.Serializable;


/**
 * 
 * @author kenny
 * 提供增删改查基础抽象方法的底层接口
 * @param <T>
 */
public interface BaseService<T extends Serializable> {

	/**
	 * 添加
	 * 
	 * @param store
	 */
	public void add(T obj);

	/**
	 * 更新
	 * 
	 * @param store
	 */
	public void update(T obj);

	/**
	 * 删除
	 * 
	 * @param store
	 */
	public void delete(String id);

	/**
	 * 查询
	 * 
	 * @param store
	 */
	public T get(String id);
	
	
	/**
	 *  获取10位Id随机值（不使用mybatis自增主键策略）
	 */
	public String getId();
}
