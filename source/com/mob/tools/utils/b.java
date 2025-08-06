package com.mob.tools.utils;

import android.text.TextUtils;
import com.mob.commons.s;

public class b {

    public static class a {
        public static boolean a(Object obj) {
            return ((Boolean) ReflectHelper.invokeInstanceMethodNoThrow(obj, "isRegistered", Boolean.FALSE, new Object[0])).booleanValue();
        }

        public static boolean b(Object obj) {
            return b.a(obj, s.a("029de$dcdjdkdidcdlVifgfjhCdk2e[ecdledVfggDee-e?efdkidfidf"));
        }

        public static boolean c(Object obj) {
            return b.a(obj, s.a("030de3dcdjdkdidcdl>ifgfjh<dkWe6ecdled2fgg?ee>eMefdkeddcdf d"));
        }

        public static boolean d(Object obj) {
            return b.a(obj, s.a("031deKdcdjdkdidcdlHifgfjh dk:eQecdledKfgg0eeMeOefdkgfCc*dcdf5d"));
        }

        public static boolean e(Object obj) {
            return b.a(obj, s.a("029deBdcdjdkdidcdl,ifgfjh4dk^e!ecdled'fggQee)e[efdkfeVif"));
        }

        public static boolean f(Object obj) {
            return b.a(obj, s.a("028deVdcdjdkdidcdl9ifgfjhZdkQe0ecdledEfggDeeVe6efdkegdj"));
        }

        public static Object g(Object obj) {
            return ReflectHelper.invokeInstanceMethodNoThrow(obj, s.a("015YejFfiDed+fgg@eedc]fei7di;i>ec"), null, new Object[0]);
        }

        public static int h(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, s.a("006Xej%fi5hc6cc"), -1, new Object[0])).intValue();
        }

        public static int i(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, s.a("006)ejAfi>hcLec"), -1, new Object[0])).intValue();
        }

        public static int j(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, s.a("006NejQfi feUdc"), -1, new Object[0])).intValue();
        }

        public static int k(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, s.a("006JejEfi(eddidc"), -1, new Object[0])).intValue();
        }

        public static int l(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, s.a("0063ejPfi@glfiWc"), -1, new Object[0])).intValue();
        }

        public static int m(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, s.a("0110ej'fi'elecfiKif6dfeedc"), -1, new Object[0])).intValue();
        }

        public static int n(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, s.a("012TejRfiPeg;fi6fgdkdjeheedc"), -1, new Object[0])).intValue();
        }

        public static int o(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, s.a("011_ejAfiKfe2di>di]i8dgdcQf"), -1, new Object[0])).intValue();
        }

        public static int p(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, s.a("012WejQfi3fedkKe ejdiBi^dgdc%f"), -1, new Object[0])).intValue();
        }

        public static int q(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, "getBasestationId", -1, new Object[0])).intValue();
        }

        public static int r(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, s.a("006<ej>fi$fcOdc"), -1, new Object[0])).intValue();
        }

        public static int s(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, s.a("005;ej[fi.eddi"), -1, new Object[0])).intValue();
        }

        public static int t(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, s.a("006Eej9fi!glMc'di"), -1, new Object[0])).intValue();
        }

        public static int u(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, s.a("009GejDfi6gi2d)djefHce"), -1, new Object[0])).intValue();
        }

        public static String v(Object obj) {
            return (String) ReflectHelper.invokeInstanceMethodNoThrow(obj, s.a("012Lej fi>hc[cc[el7iGdjdiOe5ej"), null, new Object[0]);
        }

        public static String w(Object obj) {
            return (String) ReflectHelper.invokeInstanceMethodNoThrow(obj, s.a("0127ej=fi4hc*ec+elCiOdjdiFe4ej"), null, new Object[0]);
        }

        public static long x(Object obj) {
            return ((Long) ReflectHelper.invokeInstanceMethodNoThrow(obj, s.a("0067ej'fiReg]c0di"), -1L, new Object[0])).longValue();
        }

        public static int y(Object obj) {
            return ((Integer) ReflectHelper.invokeInstanceMethodNoThrow(obj, s.a("0107ejVfiXegdj1dQdjefMce"), -1, new Object[0])).intValue();
        }
    }

    public static boolean a(Object obj, String str) {
        if (obj == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(obj.getClass().getName());
    }
}
