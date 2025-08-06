package com.tencent.android.tpush.message;

import org.json.JSONObject;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f69413a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f69414b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f69415c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f69416d = null;

    /* renamed from: e  reason: collision with root package name */
    private String f69417e = null;

    /* renamed from: f  reason: collision with root package name */
    private String f69418f = null;

    /* renamed from: g  reason: collision with root package name */
    private String f69419g = null;

    public a(String str) {
        this.f69414b = str;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0051 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0034 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0042 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r12 = this;
            java.lang.String r0 = "accept_time"
            java.lang.String r1 = "custom_content"
            java.lang.String r2 = "content"
            java.lang.String r3 = "unexpected for decode"
            java.lang.String r4 = "BaseMessageHolder"
            java.lang.String r5 = "title"
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x0016 }
            java.lang.String r7 = r12.f69414b     // Catch:{ all -> 0x0016 }
            r6.<init>(r7)     // Catch:{ all -> 0x0016 }
            r12.f69413a = r6     // Catch:{ all -> 0x0016 }
            goto L_0x0063
        L_0x0016:
            r6 = 1
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ all -> 0x0034 }
            java.lang.String r8 = r12.f69414b     // Catch:{ all -> 0x0034 }
            java.lang.String r9 = "{"
            int r9 = r8.indexOf(r9)     // Catch:{ all -> 0x0034 }
            java.lang.String r10 = r12.f69414b     // Catch:{ all -> 0x0034 }
            java.lang.String r11 = "}"
            int r10 = r10.lastIndexOf(r11)     // Catch:{ all -> 0x0034 }
            int r10 = r10 + r6
            java.lang.String r8 = r8.substring(r9, r10)     // Catch:{ all -> 0x0034 }
            r7.<init>(r8)     // Catch:{ all -> 0x0034 }
            r12.f69413a = r7     // Catch:{ all -> 0x0034 }
            goto L_0x0063
        L_0x0034:
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ all -> 0x0042 }
            java.lang.String r8 = r12.f69414b     // Catch:{ all -> 0x0042 }
            java.lang.String r6 = r8.substring(r6)     // Catch:{ all -> 0x0042 }
            r7.<init>(r6)     // Catch:{ all -> 0x0042 }
            r12.f69413a = r7     // Catch:{ all -> 0x0042 }
            goto L_0x0063
        L_0x0042:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x0051 }
            java.lang.String r7 = r12.f69414b     // Catch:{ all -> 0x0051 }
            r8 = 2
            java.lang.String r7 = r7.substring(r8)     // Catch:{ all -> 0x0051 }
            r6.<init>(r7)     // Catch:{ all -> 0x0051 }
            r12.f69413a = r6     // Catch:{ all -> 0x0051 }
            goto L_0x0063
        L_0x0051:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x0060 }
            java.lang.String r7 = r12.f69414b     // Catch:{ all -> 0x0060 }
            r8 = 3
            java.lang.String r7 = r7.substring(r8)     // Catch:{ all -> 0x0060 }
            r6.<init>(r7)     // Catch:{ all -> 0x0060 }
            r12.f69413a = r6     // Catch:{ all -> 0x0060 }
            goto L_0x0063
        L_0x0060:
            com.tencent.android.tpush.logging.TLogger.d(r4, r3)
        L_0x0063:
            org.json.JSONObject r6 = r12.f69413a     // Catch:{ all -> 0x00b4 }
            boolean r6 = r6.isNull(r5)     // Catch:{ all -> 0x00b4 }
            if (r6 != 0) goto L_0x0073
            org.json.JSONObject r6 = r12.f69413a     // Catch:{ all -> 0x00b4 }
            java.lang.String r5 = r6.getString(r5)     // Catch:{ all -> 0x00b4 }
            r12.f69416d = r5     // Catch:{ all -> 0x00b4 }
        L_0x0073:
            org.json.JSONObject r5 = r12.f69413a     // Catch:{ all -> 0x00b4 }
            boolean r5 = r5.isNull(r2)     // Catch:{ all -> 0x00b4 }
            if (r5 != 0) goto L_0x0083
            org.json.JSONObject r5 = r12.f69413a     // Catch:{ all -> 0x00b4 }
            java.lang.String r2 = r5.getString(r2)     // Catch:{ all -> 0x00b4 }
            r12.f69417e = r2     // Catch:{ all -> 0x00b4 }
        L_0x0083:
            org.json.JSONObject r2 = r12.f69413a     // Catch:{ all -> 0x00b4 }
            boolean r2 = r2.isNull(r1)     // Catch:{ all -> 0x00b4 }
            java.lang.String r5 = ""
            if (r2 != 0) goto L_0x00a3
            org.json.JSONObject r2 = r12.f69413a     // Catch:{ all -> 0x00b4 }
            java.lang.String r1 = r2.optString(r1, r5)     // Catch:{ all -> 0x00b4 }
            if (r1 == 0) goto L_0x00a3
            java.lang.String r2 = r1.trim()     // Catch:{ all -> 0x00b4 }
            java.lang.String r6 = "{}"
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x00b4 }
            if (r2 != 0) goto L_0x00a3
            r12.f69418f = r1     // Catch:{ all -> 0x00b4 }
        L_0x00a3:
            org.json.JSONObject r1 = r12.f69413a     // Catch:{ all -> 0x00b4 }
            boolean r1 = r1.isNull(r0)     // Catch:{ all -> 0x00b4 }
            if (r1 != 0) goto L_0x00b7
            org.json.JSONObject r1 = r12.f69413a     // Catch:{ all -> 0x00b4 }
            java.lang.String r0 = r1.optString(r0, r5)     // Catch:{ all -> 0x00b4 }
            r12.f69419g = r0     // Catch:{ all -> 0x00b4 }
            goto L_0x00b7
        L_0x00b4:
            com.tencent.android.tpush.logging.TLogger.d(r4, r3)
        L_0x00b7:
            r12.c()
            java.lang.String r0 = r12.f69414b
            java.lang.String r0 = com.tencent.tpns.baseapi.base.util.Md5.md5(r0)
            java.lang.String r0 = r0.toUpperCase()
            r12.f69415c = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.message.a.a():void");
    }

    public abstract int b();

    public abstract void c();

    public String d() {
        return this.f69416d;
    }

    public String e() {
        return this.f69417e;
    }

    public String f() {
        return this.f69418f;
    }

    public String toString() {
        return "BaseMessageHolder [msgJson=" + this.f69413a + ", msgJsonStr=" + this.f69414b + ", title=" + this.f69416d + ", content=" + this.f69417e + ", customContent=" + this.f69418f + ", acceptTime=" + this.f69419g + "]";
    }
}
