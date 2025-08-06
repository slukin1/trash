package g2;

import com.alibaba.fastjson.parser.ParserConfig;
import java.lang.reflect.Constructor;

public class q extends k {
    public q(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    public int b() {
        return 12;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (java.lang.Throwable.class.isAssignableFrom(r14) != false) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T e(f2.a r13, java.lang.reflect.Type r14, java.lang.Object r15) {
        /*
            r12 = this;
            f2.b r15 = r13.f15701g
            int r0 = r15.J()
            r1 = 8
            r2 = 0
            if (r0 != r1) goto L_0x000f
            r15.nextToken()
            return r2
        L_0x000f:
            int r0 = r13.v()
            r3 = 2
            java.lang.String r4 = "syntax error"
            if (r0 != r3) goto L_0x001d
            r0 = 0
            r13.V(r0)
            goto L_0x0025
        L_0x001d:
            int r0 = r15.J()
            r3 = 12
            if (r0 != r3) goto L_0x0152
        L_0x0025:
            if (r14 == 0) goto L_0x0036
            boolean r0 = r14 instanceof java.lang.Class
            if (r0 == 0) goto L_0x0036
            java.lang.Class r14 = (java.lang.Class) r14
            java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
            boolean r0 = r0.isAssignableFrom(r14)
            if (r0 == 0) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            r14 = r2
        L_0x0037:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r3 = r2
            r5 = r3
            r6 = r5
        L_0x003f:
            f2.g r7 = r13.w()
            java.lang.String r7 = r15.L(r7)
            r8 = 13
            r9 = 16
            if (r7 != 0) goto L_0x0067
            int r10 = r15.J()
            if (r10 != r8) goto L_0x0058
            r15.f(r9)
            goto L_0x00e5
        L_0x0058:
            int r10 = r15.J()
            if (r10 != r9) goto L_0x0067
            com.alibaba.fastjson.parser.Feature r10 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas
            boolean r10 = r15.a(r10)
            if (r10 == 0) goto L_0x0067
            goto L_0x003f
        L_0x0067:
            r10 = 4
            r15.y(r10)
            java.lang.String r11 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY
            boolean r11 = r11.equals(r7)
            if (r11 == 0) goto L_0x0091
            int r14 = r15.J()
            if (r14 != r10) goto L_0x008b
            java.lang.String r14 = r15.H()
            com.alibaba.fastjson.parser.ParserConfig r7 = r13.k()
            java.lang.Class<java.lang.Throwable> r10 = java.lang.Throwable.class
            java.lang.Class r14 = r7.e(r14, r10)
            r15.f(r9)
            goto L_0x00dc
        L_0x008b:
            com.alibaba.fastjson.JSONException r13 = new com.alibaba.fastjson.JSONException
            r13.<init>(r4)
            throw r13
        L_0x0091:
            java.lang.String r11 = "message"
            boolean r11 = r11.equals(r7)
            if (r11 == 0) goto L_0x00b5
            int r5 = r15.J()
            if (r5 != r1) goto L_0x00a1
            r5 = r2
            goto L_0x00ab
        L_0x00a1:
            int r5 = r15.J()
            if (r5 != r10) goto L_0x00af
            java.lang.String r5 = r15.H()
        L_0x00ab:
            r15.nextToken()
            goto L_0x00dc
        L_0x00af:
            com.alibaba.fastjson.JSONException r13 = new com.alibaba.fastjson.JSONException
            r13.<init>(r4)
            throw r13
        L_0x00b5:
            java.lang.String r10 = "cause"
            boolean r11 = r10.equals(r7)
            if (r11 == 0) goto L_0x00c4
            java.lang.Object r3 = r12.e(r13, r2, r10)
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            goto L_0x00dc
        L_0x00c4:
            java.lang.String r10 = "stackTrace"
            boolean r10 = r10.equals(r7)
            if (r10 == 0) goto L_0x00d5
            java.lang.Class<java.lang.StackTraceElement[]> r6 = java.lang.StackTraceElement[].class
            java.lang.Object r6 = r13.K(r6)
            java.lang.StackTraceElement[] r6 = (java.lang.StackTraceElement[]) r6
            goto L_0x00dc
        L_0x00d5:
            java.lang.Object r10 = r13.z()
            r0.put(r7, r10)
        L_0x00dc:
            int r7 = r15.J()
            if (r7 != r8) goto L_0x003f
            r15.f(r9)
        L_0x00e5:
            if (r14 != 0) goto L_0x00ed
            java.lang.Exception r13 = new java.lang.Exception
            r13.<init>(r5, r3)
            goto L_0x0100
        L_0x00ed:
            java.lang.Class<java.lang.Throwable> r13 = java.lang.Throwable.class
            boolean r13 = r13.isAssignableFrom(r14)
            if (r13 == 0) goto L_0x0137
            java.lang.Throwable r13 = r12.s(r5, r3, r14)     // Catch:{ Exception -> 0x012e }
            if (r13 != 0) goto L_0x0100
            java.lang.Exception r13 = new java.lang.Exception     // Catch:{ Exception -> 0x012e }
            r13.<init>(r5, r3)     // Catch:{ Exception -> 0x012e }
        L_0x0100:
            if (r6 == 0) goto L_0x0105
            r13.setStackTrace(r6)
        L_0x0105:
            java.util.Set r14 = r0.entrySet()
            java.util.Iterator r14 = r14.iterator()
        L_0x010d:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x012d
            java.lang.Object r15 = r14.next()
            java.util.Map$Entry r15 = (java.util.Map.Entry) r15
            java.lang.Object r0 = r15.getKey()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r15 = r15.getValue()
            g2.i r0 = r12.j(r0)
            if (r0 == 0) goto L_0x010d
            r0.e(r13, r15)
            goto L_0x010d
        L_0x012d:
            return r13
        L_0x012e:
            r13 = move-exception
            com.alibaba.fastjson.JSONException r14 = new com.alibaba.fastjson.JSONException
            java.lang.String r15 = "create instance error"
            r14.<init>(r15, r13)
            throw r14
        L_0x0137:
            com.alibaba.fastjson.JSONException r13 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r0 = "type not match, not Throwable. "
            r15.append(r0)
            java.lang.String r14 = r14.getName()
            r15.append(r14)
            java.lang.String r14 = r15.toString()
            r13.<init>(r14)
            throw r13
        L_0x0152:
            com.alibaba.fastjson.JSONException r13 = new com.alibaba.fastjson.JSONException
            r13.<init>(r4)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.q.e(f2.a, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }

    public final Throwable s(String str, Throwable th2, Class<?> cls) throws Exception {
        Class<String> cls2 = String.class;
        Constructor constructor = null;
        Constructor constructor2 = null;
        Constructor constructor3 = null;
        for (Constructor constructor4 : cls.getConstructors()) {
            Class<Throwable>[] parameterTypes = constructor4.getParameterTypes();
            if (parameterTypes.length == 0) {
                constructor3 = constructor4;
            } else if (parameterTypes.length == 1 && parameterTypes[0] == cls2) {
                constructor2 = constructor4;
            } else if (parameterTypes.length == 2 && parameterTypes[0] == cls2 && parameterTypes[1] == Throwable.class) {
                constructor = constructor4;
            }
        }
        if (constructor != null) {
            return (Throwable) constructor.newInstance(new Object[]{str, th2});
        } else if (constructor2 != null) {
            return (Throwable) constructor2.newInstance(new Object[]{str});
        } else if (constructor3 != null) {
            return (Throwable) constructor3.newInstance(new Object[0]);
        } else {
            return null;
        }
    }
}
