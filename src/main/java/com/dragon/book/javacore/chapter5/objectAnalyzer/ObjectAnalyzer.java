package com.dragon.book.javacore.chapter5.objectAnalyzer;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * User: dengshenyan
 * Time: 2018-04-27 16:42
 */
public class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();

    public String toString(Object object) {
        if (object == null) {
            return "null";
        }
        if (visited.contains(object)) {
            return "...";
        }
        visited.add(object);
        if (object.getClass() == String.class) {
            return (String) object;
        }

        Class cl = object.getClass();
        if (cl.isArray()) {
            String r = cl.getComponentType() + "[]{";
            StringBuilder stringBuilder = new StringBuilder(r);
            for (int i = 0; i < Array.getLength(object); i++) {
                if (i > 0) {
                    stringBuilder.append(", ");
                }
                Object val = Array.get(object, i);
                if (cl.getComponentType().isPrimitive()) {
                    stringBuilder.append(val);
                }
            }

            return stringBuilder.append("}").toString();
        } else {
            String r = cl.getName();
            StringBuilder stringBuilder = new StringBuilder(r);
            do {
                stringBuilder.append("[");
                Field[] fields = cl.getFields();
                for (Field field : fields) {
                    if (!Modifier.isStatic(field.getModifiers())) {
                        if (!stringBuilder.toString().endsWith("[")) {
                            stringBuilder.append(",");
                        }
                        stringBuilder.append(field.getName() + "=");
                        try {
                            Class t = field.getType();
                            Object val = field.get(object);
                            if (t.isPrimitive()) {
                                stringBuilder.append(val);
                            } else {
                                stringBuilder.append(toString(val));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                stringBuilder.append("]");
                cl = cl.getSuperclass();
            } while (cl != null);

            return stringBuilder.toString();
        }
    }
}
