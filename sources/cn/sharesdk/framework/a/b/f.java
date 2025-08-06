package cn.sharesdk.framework.a.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.utils.SSDKLog;
import com.jumio.commons.log.LogUtils;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;

public class f extends c {

    /* renamed from: o  reason: collision with root package name */
    private static int f13354o;

    /* renamed from: p  reason: collision with root package name */
    private static long f13355p;

    /* renamed from: a  reason: collision with root package name */
    public int f13356a;

    /* renamed from: b  reason: collision with root package name */
    public String f13357b;

    /* renamed from: c  reason: collision with root package name */
    public String f13358c;

    /* renamed from: d  reason: collision with root package name */
    public a f13359d = new a();

    /* renamed from: m  reason: collision with root package name */
    public String f13360m;

    /* renamed from: n  reason: collision with root package name */
    public String[] f13361n;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f13362a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f13363b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<String> f13364c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<String> f13365d = new ArrayList<>();

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<String> f13366e = new ArrayList<>();

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<Bitmap> f13367f = new ArrayList<>();

        /* renamed from: g  reason: collision with root package name */
        public HashMap<String, Object> f13368g;

        public String toString() {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.f13363b)) {
                String replaceAll = this.f13363b.trim().replaceAll("\r", "");
                this.f13363b = replaceAll;
                String replaceAll2 = replaceAll.trim().replaceAll("\n", "");
                this.f13363b = replaceAll2;
                this.f13363b = replaceAll2.trim().replaceAll(LogUtils.NEW_LINE, "");
            }
            hashMap.put("text", this.f13363b);
            hashMap.put("url", this.f13364c);
            ArrayList<String> arrayList = this.f13365d;
            if (arrayList != null && arrayList.size() > 0) {
                hashMap.put("imgs", this.f13365d);
            }
            if (this.f13368g != null) {
                hashMap.put("attch", new Hashon().fromHashMap(this.f13368g));
            }
            return new Hashon().fromHashMap(hashMap);
        }
    }

    public String a() {
        return "[SHR]";
    }

    public void a(long j11) {
        f13355p = j11;
    }

    public int b() {
        return 5000;
    }

    public int c() {
        return 30;
    }

    public long d() {
        return (long) f13354o;
    }

    public long e() {
        return f13355p;
    }

    public void f() {
        f13354o++;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder(super.toString());
        sb2.append('|');
        sb2.append(this.f13356a);
        sb2.append('|');
        sb2.append(this.f13357b);
        sb2.append('|');
        sb2.append(TextUtils.isEmpty(this.f13358c) ? "" : this.f13358c);
        String[] strArr = this.f13361n;
        if (strArr == null || strArr.length <= 0) {
            str = "";
        } else {
            str = "[\"" + TextUtils.join("\",\"", this.f13361n) + "\"]";
        }
        sb2.append('|');
        sb2.append(str);
        sb2.append('|');
        a aVar = this.f13359d;
        if (aVar != null) {
            try {
                String encodeToString = Base64.encodeToString(Data.AES128Encode(this.f13339f.substring(0, 16), aVar.toString()), 0);
                if (encodeToString.contains("\n")) {
                    encodeToString = encodeToString.replace("\n", "");
                }
                sb2.append(encodeToString);
            } catch (Throwable th2) {
                SSDKLog.b().a(th2);
            }
        }
        sb2.append('|');
        if (!TextUtils.isEmpty(this.f13345l)) {
            sb2.append(this.f13345l);
        }
        sb2.append('|');
        if (!TextUtils.isEmpty(this.f13360m)) {
            try {
                String encodeToString2 = Base64.encodeToString(Data.AES128Encode(this.f13339f.substring(0, 16), this.f13360m), 0);
                if (!TextUtils.isEmpty(encodeToString2) && encodeToString2.contains("\n")) {
                    encodeToString2 = encodeToString2.replace("\n", "");
                }
                sb2.append(encodeToString2);
            } catch (Throwable th3) {
                SSDKLog.b().b(th3);
            }
        }
        return sb2.toString();
    }
}
