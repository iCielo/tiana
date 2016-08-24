/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 上午9:49:06</p>
 */
package com.lezic.tiana.orm.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.lezic.tiana.exception.BaseException;
import com.lezic.tiana.util.ReflectionUtil;

/**
 * hibernate工具类
 * 
 * @author cielo
 *
 */
public class HibernateUtil {

	/**
	 * 将对象obj2不为null的值拷贝到obj1
	 * 
	 * @param obj1
	 *            数据持久化对象
	 * @param obj2
	 *            要更新的对象
	 * @author cielo
	 */
	public static void copyExcludeNull(Object obj1, Object obj2) {
		if (obj1 == null || obj2 == null) {
			return;
		}
		if (obj1.getClass().equals(obj2.getClass()) == false) {
			throw new BaseException("两个对象类型不匹配！");
		}
		Field[] fields = obj2.getClass().getDeclaredFields();
		int size = fields.length;
		for (int i = 0; i < size; i++) {
			Field field = fields[i];
			if (Modifier.isFinal(field.getModifiers()) == false) {
				Object value = ReflectionUtil.getFieldValue(obj2, field.getName());
				if (value != null) {
					ReflectionUtil.setFieldValue(obj1, field.getName(), value);
				}
			}
		}
	}

}
