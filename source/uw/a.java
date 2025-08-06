package uw;

import android.net.Uri;
import android.os.Build;
import com.adjust.sdk.Constants;
import com.kakao.common.IConfiguration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qw.b;

public abstract class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public String f26260a;

    /* renamed from: b  reason: collision with root package name */
    public String f26261b;

    /* renamed from: c  reason: collision with root package name */
    public String f26262c;

    /* renamed from: d  reason: collision with root package name */
    public String f26263d;

    public a(b bVar, IConfiguration iConfiguration) {
        this.f26262c = bVar.b();
        this.f26260a = iConfiguration.b();
        this.f26261b = iConfiguration.c().toString();
        this.f26263d = iConfiguration.a();
    }

    public String b() {
        return "UTF-8";
    }

    public List<vw.b> c() {
        return new ArrayList();
    }

    public String d() {
        return this.f26262c;
    }

    public String e() {
        return "os/android-" + Build.VERSION.SDK_INT;
    }

    public Uri.Builder f() {
        return new Uri.Builder().scheme(Constants.SCHEME);
    }

    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put("KA", this.f26260a);
        if (!hashMap.containsKey("Content-Type")) {
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        }
        if (!hashMap.containsKey("Accept")) {
            hashMap.put("Accept", "*/*");
        }
        if (!hashMap.containsKey("User-Agent")) {
            hashMap.put("User-Agent", e());
        }
        hashMap.put("Authorization", "KakaoAK " + d());
        return hashMap;
    }

    public Map<String, String> getParams() {
        return new HashMap();
    }

    public String getUrl() {
        Uri.Builder f11 = f();
        return f11 != null ? f11.build().toString() : "";
    }
}
