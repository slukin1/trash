package com.alibaba.fastjson.util;

import java.lang.reflect.Method;

public class ASMUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14382a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f14383b;

    static {
        String property = System.getProperty("java.vm.name");
        f14382a = property;
        f14383b = e(property);
    }

    public static boolean a(String str) {
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (charAt < 1 || charAt > 127 || charAt == '.') {
                return false;
            }
        }
        return true;
    }

    public static String b(Class<?> cls) {
        if (cls.isPrimitive()) {
            return d(cls);
        }
        if (cls.isArray()) {
            return "[" + b(cls.getComponentType());
        }
        return "L" + f(cls) + ";";
    }

    public static String c(Method method) {
        Class[] parameterTypes = method.getParameterTypes();
        StringBuilder sb2 = new StringBuilder((parameterTypes.length + 1) << 4);
        sb2.append('(');
        for (Class b11 : parameterTypes) {
            sb2.append(b(b11));
        }
        sb2.append(')');
        sb2.append(b(method.getReturnType()));
        return sb2.toString();
    }

    public static String d(Class<?> cls) {
        if (Integer.TYPE == cls) {
            return "I";
        }
        if (Void.TYPE == cls) {
            return "V";
        }
        if (Boolean.TYPE == cls) {
            return "Z";
        }
        if (Character.TYPE == cls) {
            return "C";
        }
        if (Byte.TYPE == cls) {
            return "B";
        }
        if (Short.TYPE == cls) {
            return "S";
        }
        if (Float.TYPE == cls) {
            return "F";
        }
        if (Long.TYPE == cls) {
            return "J";
        }
        if (Double.TYPE == cls) {
            return "D";
        }
        throw new IllegalStateException("Type: " + cls.getCanonicalName() + " is not a primitive type");
    }

    public static boolean e(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("dalvik") || lowerCase.contains("lemur")) {
            return true;
        }
        return false;
    }

    public static String f(Class<?> cls) {
        if (cls.isArray()) {
            return "[" + b(cls.getComponentType());
        } else if (!cls.isPrimitive()) {
            return cls.getName().replace('.', '/');
        } else {
            return d(cls);
        }
    }
}
