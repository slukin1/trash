package com.alibaba.fastjson.parser.deserializer;

public class SqlDateDeserializer extends AbstractDateDeserializer {

    /* renamed from: b  reason: collision with root package name */
    public static final SqlDateDeserializer f14220b = new SqlDateDeserializer();

    /* renamed from: c  reason: collision with root package name */
    public static final SqlDateDeserializer f14221c = new SqlDateDeserializer(true);

    /* renamed from: a  reason: collision with root package name */
    public boolean f14222a;

    public SqlDateDeserializer() {
        this.f14222a = false;
    }

    public int b() {
        return 2;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:28|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r5 = java.lang.Long.parseLong(r6);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0063 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T g(f2.a r3, java.lang.reflect.Type r4, java.lang.Object r5, java.lang.Object r6) {
        /*
            r2 = this;
            boolean r0 = r2.f14222a
            if (r0 == 0) goto L_0x0009
            java.lang.Object r3 = r2.h(r3, r4, r5, r6)
            return r3
        L_0x0009:
            r4 = 0
            if (r6 != 0) goto L_0x000d
            return r4
        L_0x000d:
            boolean r5 = r6 instanceof java.util.Date
            if (r5 == 0) goto L_0x001d
            java.sql.Date r3 = new java.sql.Date
            java.util.Date r6 = (java.util.Date) r6
            long r4 = r6.getTime()
            r3.<init>(r4)
            goto L_0x002c
        L_0x001d:
            boolean r5 = r6 instanceof java.lang.Number
            if (r5 == 0) goto L_0x002d
            java.sql.Date r3 = new java.sql.Date
            java.lang.Number r6 = (java.lang.Number) r6
            long r4 = r6.longValue()
            r3.<init>(r4)
        L_0x002c:
            return r3
        L_0x002d:
            boolean r5 = r6 instanceof java.lang.String
            if (r5 == 0) goto L_0x0075
            java.lang.String r6 = (java.lang.String) r6
            int r5 = r6.length()
            if (r5 != 0) goto L_0x003a
            return r4
        L_0x003a:
            f2.e r4 = new f2.e
            r4.<init>(r6)
            boolean r5 = r4.C0()     // Catch:{ all -> 0x0070 }
            if (r5 == 0) goto L_0x004e
            java.util.Calendar r3 = r4.U()     // Catch:{ all -> 0x0070 }
            long r5 = r3.getTimeInMillis()     // Catch:{ all -> 0x0070 }
            goto L_0x0067
        L_0x004e:
            java.text.DateFormat r3 = r3.n()     // Catch:{ all -> 0x0070 }
            java.util.Date r3 = r3.parse(r6)     // Catch:{ ParseException -> 0x0063 }
            java.sql.Date r5 = new java.sql.Date     // Catch:{ ParseException -> 0x0063 }
            long r0 = r3.getTime()     // Catch:{ ParseException -> 0x0063 }
            r5.<init>(r0)     // Catch:{ ParseException -> 0x0063 }
            r4.close()
            return r5
        L_0x0063:
            long r5 = java.lang.Long.parseLong(r6)     // Catch:{ all -> 0x0070 }
        L_0x0067:
            r4.close()
            java.sql.Date r3 = new java.sql.Date
            r3.<init>(r5)
            return r3
        L_0x0070:
            r3 = move-exception
            r4.close()
            throw r3
        L_0x0075:
            com.alibaba.fastjson.JSONException r3 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "parse error : "
            r4.append(r5)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer.g(f2.a, java.lang.reflect.Type, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:26|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r5 = java.lang.Long.parseLong(r6);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x005a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T h(f2.a r3, java.lang.reflect.Type r4, java.lang.Object r5, java.lang.Object r6) {
        /*
            r2 = this;
            r4 = 0
            if (r6 != 0) goto L_0x0004
            return r4
        L_0x0004:
            boolean r5 = r6 instanceof java.util.Date
            if (r5 == 0) goto L_0x0014
            java.sql.Timestamp r3 = new java.sql.Timestamp
            java.util.Date r6 = (java.util.Date) r6
            long r4 = r6.getTime()
            r3.<init>(r4)
            return r3
        L_0x0014:
            boolean r5 = r6 instanceof java.lang.Number
            if (r5 == 0) goto L_0x0024
            java.sql.Timestamp r3 = new java.sql.Timestamp
            java.lang.Number r6 = (java.lang.Number) r6
            long r4 = r6.longValue()
            r3.<init>(r4)
            return r3
        L_0x0024:
            boolean r5 = r6 instanceof java.lang.String
            if (r5 == 0) goto L_0x006c
            java.lang.String r6 = (java.lang.String) r6
            int r5 = r6.length()
            if (r5 != 0) goto L_0x0031
            return r4
        L_0x0031:
            f2.e r4 = new f2.e
            r4.<init>(r6)
            boolean r5 = r4.C0()     // Catch:{ all -> 0x0067 }
            if (r5 == 0) goto L_0x0045
            java.util.Calendar r3 = r4.U()     // Catch:{ all -> 0x0067 }
            long r5 = r3.getTimeInMillis()     // Catch:{ all -> 0x0067 }
            goto L_0x005e
        L_0x0045:
            java.text.DateFormat r3 = r3.n()     // Catch:{ all -> 0x0067 }
            java.util.Date r3 = r3.parse(r6)     // Catch:{ ParseException -> 0x005a }
            java.sql.Timestamp r5 = new java.sql.Timestamp     // Catch:{ ParseException -> 0x005a }
            long r0 = r3.getTime()     // Catch:{ ParseException -> 0x005a }
            r5.<init>(r0)     // Catch:{ ParseException -> 0x005a }
            r4.close()
            return r5
        L_0x005a:
            long r5 = java.lang.Long.parseLong(r6)     // Catch:{ all -> 0x0067 }
        L_0x005e:
            r4.close()
            java.sql.Timestamp r3 = new java.sql.Timestamp
            r3.<init>(r5)
            return r3
        L_0x0067:
            r3 = move-exception
            r4.close()
            throw r3
        L_0x006c:
            com.alibaba.fastjson.JSONException r3 = new com.alibaba.fastjson.JSONException
            java.lang.String r4 = "parse error"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer.h(f2.a, java.lang.reflect.Type, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public SqlDateDeserializer(boolean z11) {
        this.f14222a = false;
        this.f14222a = true;
    }
}
