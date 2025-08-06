package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class fp {

    /* renamed from: a  reason: collision with root package name */
    public static final String f51819a = Locale.getDefault().getLanguage().toLowerCase();

    /* renamed from: a  reason: collision with other field name */
    public static final DateFormat f2872a;

    /* renamed from: b  reason: collision with root package name */
    private static long f51820b = 0;

    /* renamed from: b  reason: collision with other field name */
    private static String f2873b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f51821c = (fy.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);

    /* renamed from: a  reason: collision with other field name */
    public long f2874a;

    /* renamed from: a  reason: collision with other field name */
    private ft f2875a = null;

    /* renamed from: a  reason: collision with other field name */
    private List<fm> f2876a = new CopyOnWriteArrayList();

    /* renamed from: a  reason: collision with other field name */
    private final Map<String, Object> f2877a = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private String f51822d = f2873b;

    /* renamed from: e  reason: collision with root package name */
    private String f51823e = null;

    /* renamed from: f  reason: collision with root package name */
    private String f51824f = null;

    /* renamed from: g  reason: collision with root package name */
    private String f51825g = null;

    /* renamed from: h  reason: collision with root package name */
    private String f51826h = null;

    /* renamed from: i  reason: collision with root package name */
    private String f51827i = null;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f2872a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
    }

    public fp() {
    }

    public static synchronized String i() {
        String sb2;
        synchronized (fp.class) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(f51821c);
            long j11 = f51820b;
            f51820b = 1 + j11;
            sb3.append(Long.toString(j11));
            sb2 = sb3.toString();
        }
        return sb2;
    }

    public static String q() {
        return f51819a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ft m2695a() {
        return this.f2875a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public abstract String m2697a();

    public synchronized Collection<String> b() {
        if (this.f2877a == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.f2877a.keySet()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        fp fpVar = (fp) obj;
        ft ftVar = this.f2875a;
        if (ftVar == null ? fpVar.f2875a != null : !ftVar.equals(fpVar.f2875a)) {
            return false;
        }
        String str = this.f51825g;
        if (str == null ? fpVar.f51825g != null : !str.equals(fpVar.f51825g)) {
            return false;
        }
        if (!this.f2876a.equals(fpVar.f2876a)) {
            return false;
        }
        String str2 = this.f51823e;
        if (str2 == null ? fpVar.f51823e != null : !str2.equals(fpVar.f51823e)) {
            return false;
        }
        String str3 = this.f51826h;
        if (str3 == null ? fpVar.f51826h != null : !str3.equals(fpVar.f51826h)) {
            return false;
        }
        Map<String, Object> map = this.f2877a;
        if (map == null ? fpVar.f2877a != null : !map.equals(fpVar.f2877a)) {
            return false;
        }
        String str4 = this.f51824f;
        if (str4 == null ? fpVar.f51824f != null : !str4.equals(fpVar.f51824f)) {
            return false;
        }
        String str5 = this.f51822d;
        String str6 = fpVar.f51822d;
        if (str5 != null) {
            if (str5.equals(str6)) {
                return true;
            }
        } else if (str6 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f51822d;
        int i11 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f51823e;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f51824f;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f51825g;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f51826h;
        int hashCode5 = (((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f2876a.hashCode()) * 31) + this.f2877a.hashCode()) * 31;
        ft ftVar = this.f2875a;
        if (ftVar != null) {
            i11 = ftVar.hashCode();
        }
        return hashCode5 + i11;
    }

    public String j() {
        if ("ID_NOT_AVAILABLE".equals(this.f51823e)) {
            return null;
        }
        if (this.f51823e == null) {
            this.f51823e = i();
        }
        return this.f51823e;
    }

    public void k(String str) {
        this.f51823e = str;
    }

    public void l(String str) {
        this.f51826h = str;
    }

    public void m(String str) {
        this.f51824f = str;
    }

    public void n(String str) {
        this.f51825g = str;
    }

    public void o(String str) {
        this.f51827i = str;
    }

    public String p() {
        return this.f51822d;
    }

    public void a(ft ftVar) {
        this.f2875a = ftVar;
    }

    public String k() {
        return this.f51826h;
    }

    public String l() {
        return this.f51824f;
    }

    public String m() {
        return this.f51825g;
    }

    public String n() {
        return this.f51827i;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:31|32|33|34|35|36|37|38|39|40|41) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:62|63|(0)|(0)|71|72) */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x011e, code lost:
        if (r4 == null) goto L_0x0121;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x0104 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x0134 */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x011b A[SYNTHETIC, Splitter:B:54:0x011b] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x012c A[SYNTHETIC, Splitter:B:65:0x012c] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0131 A[SYNTHETIC, Splitter:B:69:0x0131] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String o() {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0140 }
            r0.<init>()     // Catch:{ all -> 0x0140 }
            java.util.Collection r1 = r6.a()     // Catch:{ all -> 0x0140 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0140 }
        L_0x000e:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0140 }
            if (r2 == 0) goto L_0x0022
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0140 }
            com.xiaomi.push.fq r2 = (com.xiaomi.push.fq) r2     // Catch:{ all -> 0x0140 }
            java.lang.String r2 = r2.d()     // Catch:{ all -> 0x0140 }
            r0.append(r2)     // Catch:{ all -> 0x0140 }
            goto L_0x000e
        L_0x0022:
            java.util.Map<java.lang.String, java.lang.Object> r1 = r6.f2877a     // Catch:{ all -> 0x0140 }
            if (r1 == 0) goto L_0x013a
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0140 }
            if (r1 != 0) goto L_0x013a
            java.lang.String r1 = "PHByb3BlcnRpZXMgeG1sbnM9Imh0dHA6Ly93d3cuaml2ZXNvZnR3YXJlLmNvbS94bWxucy94bXBwL3Byb3BlcnRpZXMiPg=="
            java.lang.String r1 = com.xiaomi.push.az.b(r1)     // Catch:{ all -> 0x0140 }
            r0.append(r1)     // Catch:{ all -> 0x0140 }
            java.util.Collection r1 = r6.b()     // Catch:{ all -> 0x0140 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0140 }
        L_0x003d:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0140 }
            if (r2 == 0) goto L_0x0135
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0140 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0140 }
            java.lang.Object r3 = r6.a((java.lang.String) r2)     // Catch:{ all -> 0x0140 }
            java.lang.String r4 = "<property>"
            r0.append(r4)     // Catch:{ all -> 0x0140 }
            java.lang.String r4 = "<name>"
            r0.append(r4)     // Catch:{ all -> 0x0140 }
            java.lang.String r2 = com.xiaomi.push.fy.a((java.lang.String) r2)     // Catch:{ all -> 0x0140 }
            r0.append(r2)     // Catch:{ all -> 0x0140 }
            java.lang.String r2 = "</name>"
            r0.append(r2)     // Catch:{ all -> 0x0140 }
            java.lang.String r2 = "<value type=\""
            r0.append(r2)     // Catch:{ all -> 0x0140 }
            boolean r2 = r3 instanceof java.lang.Integer     // Catch:{ all -> 0x0140 }
            if (r2 == 0) goto L_0x007b
            java.lang.String r2 = "integer\">"
            r0.append(r2)     // Catch:{ all -> 0x0140 }
            r0.append(r3)     // Catch:{ all -> 0x0140 }
            java.lang.String r2 = "</value>"
            r0.append(r2)     // Catch:{ all -> 0x0140 }
            goto L_0x0121
        L_0x007b:
            boolean r2 = r3 instanceof java.lang.Long     // Catch:{ all -> 0x0140 }
            if (r2 == 0) goto L_0x008e
            java.lang.String r2 = "long\">"
            r0.append(r2)     // Catch:{ all -> 0x0140 }
            r0.append(r3)     // Catch:{ all -> 0x0140 }
            java.lang.String r2 = "</value>"
            r0.append(r2)     // Catch:{ all -> 0x0140 }
            goto L_0x0121
        L_0x008e:
            boolean r2 = r3 instanceof java.lang.Float     // Catch:{ all -> 0x0140 }
            if (r2 == 0) goto L_0x00a1
            java.lang.String r2 = "float\">"
            r0.append(r2)     // Catch:{ all -> 0x0140 }
            r0.append(r3)     // Catch:{ all -> 0x0140 }
            java.lang.String r2 = "</value>"
            r0.append(r2)     // Catch:{ all -> 0x0140 }
            goto L_0x0121
        L_0x00a1:
            boolean r2 = r3 instanceof java.lang.Double     // Catch:{ all -> 0x0140 }
            if (r2 == 0) goto L_0x00b4
            java.lang.String r2 = "double\">"
            r0.append(r2)     // Catch:{ all -> 0x0140 }
            r0.append(r3)     // Catch:{ all -> 0x0140 }
            java.lang.String r2 = "</value>"
            r0.append(r2)     // Catch:{ all -> 0x0140 }
            goto L_0x0121
        L_0x00b4:
            boolean r2 = r3 instanceof java.lang.Boolean     // Catch:{ all -> 0x0140 }
            if (r2 == 0) goto L_0x00c6
            java.lang.String r2 = "boolean\">"
            r0.append(r2)     // Catch:{ all -> 0x0140 }
            r0.append(r3)     // Catch:{ all -> 0x0140 }
            java.lang.String r2 = "</value>"
            r0.append(r2)     // Catch:{ all -> 0x0140 }
            goto L_0x0121
        L_0x00c6:
            boolean r2 = r3 instanceof java.lang.String     // Catch:{ all -> 0x0140 }
            if (r2 == 0) goto L_0x00de
            java.lang.String r2 = "string\">"
            r0.append(r2)     // Catch:{ all -> 0x0140 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0140 }
            java.lang.String r2 = com.xiaomi.push.fy.a((java.lang.String) r3)     // Catch:{ all -> 0x0140 }
            r0.append(r2)     // Catch:{ all -> 0x0140 }
            java.lang.String r2 = "</value>"
            r0.append(r2)     // Catch:{ all -> 0x0140 }
            goto L_0x0121
        L_0x00de:
            r2 = 0
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0112, all -> 0x010f }
            r4.<init>()     // Catch:{ Exception -> 0x0112, all -> 0x010f }
            java.io.ObjectOutputStream r5 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x010c, all -> 0x010a }
            r5.<init>(r4)     // Catch:{ Exception -> 0x010c, all -> 0x010a }
            r5.writeObject(r3)     // Catch:{ Exception -> 0x0108 }
            java.lang.String r2 = "java-object\">"
            r0.append(r2)     // Catch:{ Exception -> 0x0108 }
            byte[] r2 = r4.toByteArray()     // Catch:{ Exception -> 0x0108 }
            java.lang.String r2 = com.xiaomi.push.fy.a((byte[]) r2)     // Catch:{ Exception -> 0x0108 }
            r0.append(r2)     // Catch:{ Exception -> 0x0108 }
            java.lang.String r2 = "</value>"
            r0.append(r2)     // Catch:{ Exception -> 0x0108 }
            r5.close()     // Catch:{ Exception -> 0x0104 }
        L_0x0104:
            r4.close()     // Catch:{ Exception -> 0x0121 }
            goto L_0x0121
        L_0x0108:
            r2 = move-exception
            goto L_0x0116
        L_0x010a:
            r0 = move-exception
            goto L_0x012a
        L_0x010c:
            r3 = move-exception
            r5 = r2
            goto L_0x0115
        L_0x010f:
            r0 = move-exception
            r4 = r2
            goto L_0x012a
        L_0x0112:
            r3 = move-exception
            r4 = r2
            r5 = r4
        L_0x0115:
            r2 = r3
        L_0x0116:
            r2.printStackTrace()     // Catch:{ all -> 0x0128 }
            if (r5 == 0) goto L_0x011e
            r5.close()     // Catch:{ Exception -> 0x011e }
        L_0x011e:
            if (r4 == 0) goto L_0x0121
            goto L_0x0104
        L_0x0121:
            java.lang.String r2 = "</property>"
            r0.append(r2)     // Catch:{ all -> 0x0140 }
            goto L_0x003d
        L_0x0128:
            r0 = move-exception
            r2 = r5
        L_0x012a:
            if (r2 == 0) goto L_0x012f
            r2.close()     // Catch:{ Exception -> 0x012f }
        L_0x012f:
            if (r4 == 0) goto L_0x0134
            r4.close()     // Catch:{ Exception -> 0x0134 }
        L_0x0134:
            throw r0     // Catch:{ all -> 0x0140 }
        L_0x0135:
            java.lang.String r1 = "</properties>"
            r0.append(r1)     // Catch:{ all -> 0x0140 }
        L_0x013a:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0140 }
            monitor-exit(r6)
            return r0
        L_0x0140:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.fp.o():java.lang.String");
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<fm> m2698a() {
        if (this.f2876a == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.f2876a));
    }

    public fm a(String str) {
        return a(str, (String) null);
    }

    public fm a(String str, String str2) {
        for (fm next : this.f2876a) {
            if ((str2 == null || str2.equals(next.b())) && str.equals(next.a())) {
                return next;
            }
        }
        return null;
    }

    public void a(fm fmVar) {
        this.f2876a.add(fmVar);
    }

    public fp(Bundle bundle) {
        this.f51824f = bundle.getString("ext_to");
        this.f51825g = bundle.getString("ext_from");
        this.f51826h = bundle.getString("ext_chid");
        this.f51823e = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f2876a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                fm a11 = fm.a((Bundle) parcelable);
                if (a11 != null) {
                    this.f2876a.add(a11);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f2875a = new ft(bundle2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Object m2696a(String str) {
        Map<String, Object> map = this.f2877a;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.f51822d)) {
            bundle.putString("ext_ns", this.f51822d);
        }
        if (!TextUtils.isEmpty(this.f51825g)) {
            bundle.putString("ext_from", this.f51825g);
        }
        if (!TextUtils.isEmpty(this.f51824f)) {
            bundle.putString("ext_to", this.f51824f);
        }
        if (!TextUtils.isEmpty(this.f51823e)) {
            bundle.putString("ext_pkt_id", this.f51823e);
        }
        if (!TextUtils.isEmpty(this.f51826h)) {
            bundle.putString("ext_chid", this.f51826h);
        }
        ft ftVar = this.f2875a;
        if (ftVar != null) {
            bundle.putBundle("ext_ERROR", ftVar.a());
        }
        List<fm> list = this.f2876a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i11 = 0;
            for (fm a11 : this.f2876a) {
                Bundle a12 = a11.a();
                if (a12 != null) {
                    bundleArr[i11] = a12;
                    i11++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }
}
