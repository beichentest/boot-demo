package com.alibaba.com.caucho.hessian.io;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Deserializing a JDK 1.2 Collection.
 */
public class CollectionDeserializer extends AbstractListDeserializer {

	private Class _type;

	public CollectionDeserializer(Class type) {
		_type = type;
	}

	public Class getType() {
		return _type;
	}

	public Object readList(AbstractHessianInput in, int length) throws IOException {
		Collection list = createList();

		in.addRef(list);

		/**
		 * 修改序列化过程中导致属性丢失的bug：对继承自Collection并扩展了新属性的类，对其新增属性反序列化。
		 *
		 * Added By HuQingmiao(443770574@qq.com) on 2017-03-25.
		 */
		/** begin **/
		Set<String> fieldNameSet = new HashSet<String>();
		try {
			Class clasz = list.getClass();
			for (; !clasz.getName().startsWith("java."); clasz = clasz.getSuperclass()) {
				Field[] fields = clasz.getDeclaredFields();
				for (Field field : fields) {				
					// 子类属性已被读取，不再读取同名父属性
					if (fieldNameSet.contains(field.getName())) {
						continue;
					}
					if (Modifier.isTransient(field.getModifiers()) || Modifier.isStatic(field.getModifiers())) {
						continue;
					}
					boolean isAccessible = field.isAccessible();
					if (!isAccessible) {
						field.setAccessible(true);
					}

					Object val = in.readObject();				

					field.set(list, val);
					field.setAccessible(isAccessible);

					// 记录已记取的属性
					fieldNameSet.add(field.getName());
				}
			}
		} catch (IllegalAccessException e) {
			throw new IOException(e.getMessage());
		}
		fieldNameSet.clear();
		/** end **/

		while (!in.isEnd())
			list.add(in.readObject());

		in.readEnd();

		return list;
	}

	public Object readLengthList(AbstractHessianInput in, int length) throws IOException {
		Collection list = createList();

		in.addRef(list);

		/**
		 * 修改序列化过程中导致属性丢失的bug：对继承自Collection并扩展了新属性的类，对其新增属性反序列化。
		 *
		 * Added By HuQingmiao(443770574@qq.com) on 2017-03-25.
		 */
		/** begin **/
		Set<String> fieldNameSet = new HashSet<String>();
		try {
			Class clasz = list.getClass();
			for (; !clasz.getName().startsWith("java."); clasz = clasz.getSuperclass()) {
				Field[] fields = clasz.getDeclaredFields();
				for (Field field : fields) {					
					// 子类属性已被读取，不再读取同名父属性
					if (fieldNameSet.contains(field.getName())) {
						continue;
					}
					if (Modifier.isTransient(field.getModifiers()) || Modifier.isStatic(field.getModifiers())) {
						continue;
					}
					boolean isAccessible = field.isAccessible();
					if (!isAccessible) {
						field.setAccessible(true);
					}

					Object val = in.readObject();					

					field.set(list, val);
					field.setAccessible(isAccessible);

					// 记录已记取的属性
					fieldNameSet.add(field.getName());
				}
			}
		} catch (IllegalAccessException e) {
			throw new IOException(e.getMessage());
		}
		fieldNameSet.clear();
		/** end **/

		for (; length > 0; length--)
			list.add(in.readObject());

		return list;
	}

	private Collection createList() throws IOException {
		Collection list = null;

		if (_type == null)
			list = new ArrayList();
		else if (!_type.isInterface()) {
			try {
				list = (Collection) _type.newInstance();
			} catch (Exception e) {
			}
		}

		if (list != null) {
		} else if (SortedSet.class.isAssignableFrom(_type))
			list = new TreeSet();
		else if (Set.class.isAssignableFrom(_type))
			list = new HashSet();
		else if (List.class.isAssignableFrom(_type))
			list = new ArrayList();
		else if (Collection.class.isAssignableFrom(_type))
			list = new ArrayList();
		else {
			try {
				list = (Collection) _type.newInstance();
			} catch (Exception e) {
				throw new IOExceptionWrapper(e);
			}
		}

		return list;
	}
}