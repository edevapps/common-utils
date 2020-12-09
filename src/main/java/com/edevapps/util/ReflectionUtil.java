/*
 *     Copyright (c) 2018, The Eduard Burenkov. All rights reserved. http://edevapps.com
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.edevapps.util;

import static com.edevapps.util.ObjectsUtil.requireNonNull;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtil {

	@SuppressWarnings("unchecked")
	public static <T> T getFieldValue(String fieldName, Object object)
			throws NoSuchFieldException, IllegalAccessException, ClassCastException {
		Field field = findField(object.getClass(), fieldName);
		if(field == null) {
			throw new NoSuchFieldException();
		}

		boolean accessibility = field.isAccessible();
		field.setAccessible(true);
		T value = ((T) field.get(object));
		field.setAccessible(accessibility);
		return value;
	}

	public static Field findField(Class<?> target, String fieldName) {
		try {
			Field field = null;
			Class<?> superClass = target.getSuperclass();
			if(superClass != null) {
				field = findField(superClass, fieldName);
			}
			if(field == null) {
				field = target.getDeclaredField(fieldName);
			}
			return field;
		} catch (NoSuchFieldException ignore) {
			//Not find
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBeanProperty(String propertyName, Object object)
			throws NoSuchMethodException, IllegalAccessException, ClassCastException, InvocationTargetException {
		Method method = findBeanPropertyMethod(object.getClass(), propertyName);
		if(method == null) {
			throw new NoSuchMethodException();
		}

		return ((T) method.invoke(object));
	}

	public static Method findBeanPropertyMethod(Class<?> target, String propertyName) {
		try {
			Method method = null;
			Class<?> superClass = target.getSuperclass();
			String propertyMethodName = buildBeanPropertyMethodName(propertyName);
			if(superClass != null) {
				method = findBeanPropertyMethod(superClass, propertyMethodName);
			}
			if(method == null) {
				method = target.getMethod(propertyMethodName);
			}
			return method;
		} catch (NoSuchMethodException ignore) {
			//Not find
		} catch (SecurityException se) {
			throw new IllegalStateException(se);
		}
		return null;
	}

	public static String buildBeanPropertyMethodName(String propertyName) {
		return "get" +  propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
	}

	public static Method findMethod(Class<?> target, String methodName) {
		try {
			Method method = null;
			Class<?> superClass = target.getSuperclass();
			if(superClass != null) {
				method = findMethod(superClass, methodName);
			}
			if(method == null) {
				method = target.getDeclaredMethod(methodName);
			}
			return method;
		} catch (NoSuchMethodException ignore) {
			//Not find
		} catch (SecurityException se) {
			throw new IllegalStateException(se);
		}
		return null;
	}

	public static <T> T newInstance(Class<? extends T> clazz) throws IllegalStateException {
		try {
			return requireNonNull(clazz, "clazz").newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new IllegalStateException(e);
		}
	}
}
