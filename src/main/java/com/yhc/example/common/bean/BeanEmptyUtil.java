package com.yhc.example.common.bean;

import java.lang.reflect.Field;

public class BeanEmptyUtil {

    public static <T> T setNullValue(T source) throws IllegalArgumentException, IllegalAccessException, SecurityException {
        Field[] fields = source.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getGenericType().toString().equals(
                    "class java.lang.String")) {
                field.setAccessible(true);
                Object obj = field.get(source);
                if (obj != null && obj.equals("")) {
                    field.set(source, null);
                }
            }
        }
        return source;
    }
}
