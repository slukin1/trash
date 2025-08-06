package com.alibaba.fastjson.serializer;

import f2.a;
import g2.l;
import java.lang.reflect.Type;

public class CharArrayCodec implements l {
    /* JADX WARNING: type inference failed for: r0v6, types: [char[], T] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T c(f2.a r5) {
        /*
            f2.b r0 = r5.f15701g
            int r1 = r0.J()
            r2 = 16
            r3 = 4
            if (r1 != r3) goto L_0x0017
            java.lang.String r5 = r0.H()
            r0.f(r2)
            char[] r5 = r5.toCharArray()
            return r5
        L_0x0017:
            int r1 = r0.J()
            r3 = 2
            if (r1 != r3) goto L_0x002e
            java.lang.Number r5 = r0.I()
            r0.f(r2)
            java.lang.String r5 = r5.toString()
            char[] r5 = r5.toCharArray()
            return r5
        L_0x002e:
            java.lang.Object r5 = r5.z()
            boolean r0 = r5 instanceof java.lang.String
            if (r0 == 0) goto L_0x003d
            java.lang.String r5 = (java.lang.String) r5
            char[] r5 = r5.toCharArray()
            return r5
        L_0x003d:
            boolean r0 = r5 instanceof java.util.Collection
            if (r0 == 0) goto L_0x008c
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r0 = r5.iterator()
        L_0x0047:
            boolean r1 = r0.hasNext()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0060
            java.lang.Object r1 = r0.next()
            boolean r4 = r1 instanceof java.lang.String
            if (r4 == 0) goto L_0x0047
            java.lang.String r1 = (java.lang.String) r1
            int r1 = r1.length()
            if (r1 == r3) goto L_0x0047
            r3 = r2
        L_0x0060:
            if (r3 == 0) goto L_0x0084
            int r0 = r5.size()
            char[] r0 = new char[r0]
            java.util.Iterator r5 = r5.iterator()
            r1 = r2
        L_0x006d:
            boolean r3 = r5.hasNext()
            if (r3 == 0) goto L_0x0083
            java.lang.Object r3 = r5.next()
            int r4 = r1 + 1
            java.lang.String r3 = (java.lang.String) r3
            char r3 = r3.charAt(r2)
            r0[r1] = r3
            r1 = r4
            goto L_0x006d
        L_0x0083:
            return r0
        L_0x0084:
            com.alibaba.fastjson.JSONException r5 = new com.alibaba.fastjson.JSONException
            java.lang.String r0 = "can not cast to char[]"
            r5.<init>(r0)
            throw r5
        L_0x008c:
            if (r5 != 0) goto L_0x0090
            r5 = 0
            goto L_0x0098
        L_0x0090:
            java.lang.String r5 = com.alibaba.fastjson.JSON.toJSONString(r5)
            char[] r5 = r5.toCharArray()
        L_0x0098:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.CharArrayCodec.c(f2.a):java.lang.Object");
    }

    public int b() {
        return 4;
    }

    public <T> T e(a aVar, Type type, Object obj) {
        return c(aVar);
    }
}
