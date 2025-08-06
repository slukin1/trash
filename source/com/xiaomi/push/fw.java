package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class fw {

    /* renamed from: a  reason: collision with root package name */
    private static fw f51872a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, Object> f2885a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Object> f51873b = new ConcurrentHashMap();

    private fw() {
        a();
    }

    public static synchronized fw a() {
        fw fwVar;
        synchronized (fw.class) {
            if (f51872a == null) {
                f51872a = new fw();
            }
            fwVar = f51872a;
        }
        return fwVar;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x0108 */
    /* renamed from: a  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m2704a() {
        /*
            r10 = this;
            java.lang.ClassLoader[] r0 = r10.a()     // Catch:{ Exception -> 0x010d }
            int r1 = r0.length     // Catch:{ Exception -> 0x010d }
            r2 = 0
        L_0x0006:
            if (r2 >= r1) goto L_0x0111
            r3 = r0[r2]     // Catch:{ Exception -> 0x010d }
            java.lang.String r4 = "META-INF/smack.providers"
            java.util.Enumeration r3 = r3.getResources(r4)     // Catch:{ Exception -> 0x010d }
        L_0x0010:
            boolean r4 = r3.hasMoreElements()     // Catch:{ Exception -> 0x010d }
            if (r4 == 0) goto L_0x0109
            java.lang.Object r4 = r3.nextElement()     // Catch:{ Exception -> 0x010d }
            java.net.URL r4 = (java.net.URL) r4     // Catch:{ Exception -> 0x010d }
            r5 = 0
            java.io.InputStream r5 = r4.openStream()     // Catch:{ all -> 0x0104 }
            org.xmlpull.v1.XmlPullParserFactory r4 = org.xmlpull.v1.XmlPullParserFactory.newInstance()     // Catch:{ all -> 0x0104 }
            org.xmlpull.v1.XmlPullParser r4 = r4.newPullParser()     // Catch:{ all -> 0x0104 }
            java.lang.String r6 = "http://xmlpull.org/v1/doc/features.html#process-namespaces"
            r7 = 1
            r4.setFeature(r6, r7)     // Catch:{ all -> 0x0104 }
            java.lang.String r6 = "UTF-8"
            r4.setInput(r5, r6)     // Catch:{ all -> 0x0104 }
            int r6 = r4.getEventType()     // Catch:{ all -> 0x0104 }
        L_0x0038:
            r8 = 2
            if (r6 != r8) goto L_0x00f9
            java.lang.String r6 = r4.getName()     // Catch:{ all -> 0x0104 }
            java.lang.String r8 = "iqProvider"
            boolean r6 = r6.equals(r8)     // Catch:{ all -> 0x0104 }
            if (r6 == 0) goto L_0x009b
            r4.next()     // Catch:{ all -> 0x0104 }
            r4.next()     // Catch:{ all -> 0x0104 }
            java.lang.String r6 = r4.nextText()     // Catch:{ all -> 0x0104 }
            r4.next()     // Catch:{ all -> 0x0104 }
            r4.next()     // Catch:{ all -> 0x0104 }
            java.lang.String r8 = r4.nextText()     // Catch:{ all -> 0x0104 }
            r4.next()     // Catch:{ all -> 0x0104 }
            r4.next()     // Catch:{ all -> 0x0104 }
            java.lang.String r9 = r4.nextText()     // Catch:{ all -> 0x0104 }
            java.lang.String r6 = r10.a((java.lang.String) r6, (java.lang.String) r8)     // Catch:{ all -> 0x0104 }
            java.util.Map<java.lang.String, java.lang.Object> r8 = r10.f51873b     // Catch:{ all -> 0x0104 }
            boolean r8 = r8.containsKey(r6)     // Catch:{ all -> 0x0104 }
            if (r8 != 0) goto L_0x00f9
            java.lang.Class r8 = java.lang.Class.forName(r9)     // Catch:{ ClassNotFoundException -> 0x0096 }
            java.lang.Class<com.xiaomi.push.fu> r9 = com.xiaomi.push.fu.class
            boolean r9 = r9.isAssignableFrom(r8)     // Catch:{ ClassNotFoundException -> 0x0096 }
            if (r9 == 0) goto L_0x0088
            java.util.Map<java.lang.String, java.lang.Object> r9 = r10.f51873b     // Catch:{ ClassNotFoundException -> 0x0096 }
            java.lang.Object r8 = r8.newInstance()     // Catch:{ ClassNotFoundException -> 0x0096 }
            r9.put(r6, r8)     // Catch:{ ClassNotFoundException -> 0x0096 }
            goto L_0x00f9
        L_0x0088:
            java.lang.Class<com.xiaomi.push.fn> r9 = com.xiaomi.push.fn.class
            boolean r9 = r9.isAssignableFrom(r8)     // Catch:{ ClassNotFoundException -> 0x0096 }
            if (r9 == 0) goto L_0x00f9
            java.util.Map<java.lang.String, java.lang.Object> r9 = r10.f51873b     // Catch:{ ClassNotFoundException -> 0x0096 }
            r9.put(r6, r8)     // Catch:{ ClassNotFoundException -> 0x0096 }
            goto L_0x00f9
        L_0x0096:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x0104 }
            goto L_0x00f9
        L_0x009b:
            java.lang.String r6 = r4.getName()     // Catch:{ all -> 0x0104 }
            java.lang.String r8 = "extensionProvider"
            boolean r6 = r6.equals(r8)     // Catch:{ all -> 0x0104 }
            if (r6 == 0) goto L_0x00f9
            r4.next()     // Catch:{ all -> 0x0104 }
            r4.next()     // Catch:{ all -> 0x0104 }
            java.lang.String r6 = r4.nextText()     // Catch:{ all -> 0x0104 }
            r4.next()     // Catch:{ all -> 0x0104 }
            r4.next()     // Catch:{ all -> 0x0104 }
            java.lang.String r8 = r4.nextText()     // Catch:{ all -> 0x0104 }
            r4.next()     // Catch:{ all -> 0x0104 }
            r4.next()     // Catch:{ all -> 0x0104 }
            java.lang.String r9 = r4.nextText()     // Catch:{ all -> 0x0104 }
            java.lang.String r6 = r10.a((java.lang.String) r6, (java.lang.String) r8)     // Catch:{ all -> 0x0104 }
            java.util.Map<java.lang.String, java.lang.Object> r8 = r10.f2885a     // Catch:{ all -> 0x0104 }
            boolean r8 = r8.containsKey(r6)     // Catch:{ all -> 0x0104 }
            if (r8 != 0) goto L_0x00f9
            java.lang.Class r8 = java.lang.Class.forName(r9)     // Catch:{ ClassNotFoundException -> 0x00f5 }
            java.lang.Class<com.xiaomi.push.fv> r9 = com.xiaomi.push.fv.class
            boolean r9 = r9.isAssignableFrom(r8)     // Catch:{ ClassNotFoundException -> 0x00f5 }
            if (r9 == 0) goto L_0x00e7
            java.util.Map<java.lang.String, java.lang.Object> r9 = r10.f2885a     // Catch:{ ClassNotFoundException -> 0x00f5 }
            java.lang.Object r8 = r8.newInstance()     // Catch:{ ClassNotFoundException -> 0x00f5 }
            r9.put(r6, r8)     // Catch:{ ClassNotFoundException -> 0x00f5 }
            goto L_0x00f9
        L_0x00e7:
            java.lang.Class<com.xiaomi.push.fq> r9 = com.xiaomi.push.fq.class
            boolean r9 = r9.isAssignableFrom(r8)     // Catch:{ ClassNotFoundException -> 0x00f5 }
            if (r9 == 0) goto L_0x00f9
            java.util.Map<java.lang.String, java.lang.Object> r9 = r10.f2885a     // Catch:{ ClassNotFoundException -> 0x00f5 }
            r9.put(r6, r8)     // Catch:{ ClassNotFoundException -> 0x00f5 }
            goto L_0x00f9
        L_0x00f5:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x0104 }
        L_0x00f9:
            int r6 = r4.next()     // Catch:{ all -> 0x0104 }
            if (r6 != r7) goto L_0x0038
            r5.close()     // Catch:{ Exception -> 0x0010 }
            goto L_0x0010
        L_0x0104:
            r0 = move-exception
            r5.close()     // Catch:{ Exception -> 0x0108 }
        L_0x0108:
            throw r0     // Catch:{ Exception -> 0x010d }
        L_0x0109:
            int r2 = r2 + 1
            goto L_0x0006
        L_0x010d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0111:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.fw.m2704a():void");
    }

    /* renamed from: a  reason: collision with other method in class */
    public Object m2703a(String str, String str2) {
        return this.f2885a.get(a(str, str2));
    }

    public void a(String str, String str2, Object obj) {
        if ((obj instanceof fv) || (obj instanceof Class)) {
            this.f2885a.put(a(str, str2), obj);
            return;
        }
        throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
    }

    private String a(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<");
        sb2.append(str);
        sb2.append("/>");
        if (str != null) {
            sb2.append("<");
            sb2.append(str2);
            sb2.append("/>");
        }
        return sb2.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    private ClassLoader[] m2702a() {
        ClassLoader[] classLoaderArr = {fw.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < 2; i11++) {
            ClassLoader classLoader = classLoaderArr[i11];
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }
}
