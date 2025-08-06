package cn.sharesdk.framework.a.a;

import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.tools.utils.SharePrefrenceHelper;
import com.sumsub.sns.internal.core.analytics.d;

public class e {

    /* renamed from: b  reason: collision with root package name */
    private static e f13323b;

    /* renamed from: a  reason: collision with root package name */
    private SharePrefrenceHelper f13324a;

    private e() {
        SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(MobSDK.getContext());
        this.f13324a = sharePrefrenceHelper;
        sharePrefrenceHelper.open("share_sdk", 1);
    }

    public static e a() {
        if (f13323b == null) {
            f13323b = new e();
        }
        return f13323b;
    }

    public long b() {
        return this.f13324a.getLong("service_time");
    }

    public boolean c() {
        String string = this.f13324a.getString("upload_device_info");
        if (TextUtils.isEmpty(string)) {
            return true;
        }
        return Boolean.parseBoolean(string);
    }

    public boolean d() {
        String string = this.f13324a.getString("upload_user_info");
        if (TextUtils.isEmpty(string)) {
            return true;
        }
        return Boolean.parseBoolean(string);
    }

    public boolean e() {
        String string = this.f13324a.getString("trans_short_link");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        return Boolean.parseBoolean(string);
    }

    public int f() {
        String string = this.f13324a.getString("upload_share_content");
        if ("true".equals(string)) {
            return 1;
        }
        return d.f31895b.equals(string) ? -1 : 0;
    }

    public void g(String str) {
        SharePrefrenceHelper sharePrefrenceHelper = this.f13324a;
        sharePrefrenceHelper.putString("buffered_snsconf_" + MobSDK.getAppkey(), str);
    }

    public Long h() {
        return Long.valueOf(this.f13324a.getLong("device_time"));
    }

    public boolean i() {
        return this.f13324a.getBoolean("connect_server");
    }

    public Long j() {
        return Long.valueOf(this.f13324a.getLong("connect_server_time"));
    }

    public boolean k() {
        return this.f13324a.getBoolean("sns_info_buffered");
    }

    public Object l(String str) {
        return this.f13324a.get(str);
    }

    public void b(String str) {
        this.f13324a.putString("upload_device_info", str);
    }

    public String g() {
        SharePrefrenceHelper sharePrefrenceHelper = this.f13324a;
        return sharePrefrenceHelper.getString("buffered_snsconf_" + MobSDK.getAppkey());
    }

    public String h(String str) {
        return this.f13324a.getString(str);
    }

    public boolean i(String str) {
        return this.f13324a.getBoolean(str);
    }

    public long j(String str) {
        return this.f13324a.getLong(str);
    }

    public int k(String str) {
        return this.f13324a.getInt(str);
    }

    public void b(boolean z11) {
        this.f13324a.putBoolean("no_use_gpp", Boolean.valueOf(z11));
    }

    public void a(String str) {
        this.f13324a.putString("trans_short_link", str);
    }

    public void b(long j11) {
        this.f13324a.putLong("connect_server_time", Long.valueOf(j11));
    }

    public void c(String str) {
        this.f13324a.putString("upload_user_info", str);
    }

    public void d(String str) {
        this.f13324a.putString("upload_share_content", str);
    }

    public void e(String str) {
        this.f13324a.putString("open_login_plus", str);
    }

    public void f(String str) {
        this.f13324a.putString("open_sina_link_card", str);
    }

    public void a(boolean z11) {
        this.f13324a.putBoolean("gpp_ver_sent", Boolean.valueOf(z11));
    }

    public void c(boolean z11) {
        this.f13324a.putBoolean("connect_server", Boolean.valueOf(z11));
    }

    public void d(boolean z11) {
        this.f13324a.putBoolean("sns_info_buffered", Boolean.valueOf(z11));
    }

    public void a(long j11) {
        this.f13324a.putLong("device_time", Long.valueOf(j11));
    }

    public void a(String str, String str2) {
        this.f13324a.putString(str, str2);
    }

    public void a(String str, Long l11) {
        this.f13324a.putLong(str, l11);
    }

    public void a(String str, int i11) {
        this.f13324a.putInt(str, Integer.valueOf(i11));
    }

    public void a(String str, Object obj) {
        this.f13324a.put(str, obj);
    }
}
