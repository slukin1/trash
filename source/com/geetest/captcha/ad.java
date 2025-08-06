package com.geetest.captcha;

import android.content.Context;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\""}, d2 = {"Lcom/geetest/captcha/utils/ErrorMessage;", "", "()V", "DEVICE_NOT_SUPPORTED", "", "getDEVICE_NOT_SUPPORTED", "()Ljava/lang/String;", "setDEVICE_NOT_SUPPORTED", "(Ljava/lang/String;)V", "PARAMETER_CONFIG_ERROR", "getPARAMETER_CONFIG_ERROR", "setPARAMETER_CONFIG_ERROR", "USER_CANCEL", "getUSER_CANCEL", "setUSER_CANCEL", "WEB_CALLBACK_ERROR", "getWEB_CALLBACK_ERROR", "setWEB_CALLBACK_ERROR", "WEB_VIEW_LOAD_ERROR", "getWEB_VIEW_LOAD_ERROR", "setWEB_VIEW_LOAD_ERROR", "WEB_VIEW_LOAD_TIMEOUT", "getWEB_VIEW_LOAD_TIMEOUT", "setWEB_VIEW_LOAD_TIMEOUT", "WEB_VIEW_SSL_ERROR", "getWEB_VIEW_SSL_ERROR", "setWEB_VIEW_SSL_ERROR", "WEB_VIEW_SSL_EXPIRED", "getWEB_VIEW_SSL_EXPIRED", "setWEB_VIEW_SSL_EXPIRED", "init", "", "context", "Landroid/content/Context;", "captcha_release"}, k = 1, mv = {1, 1, 16})
public final class ad {

    /* renamed from: a  reason: collision with root package name */
    public static final ad f65162a = new ad();

    /* renamed from: b  reason: collision with root package name */
    private static String f65163b = "加载遇到一点麻烦";

    /* renamed from: c  reason: collision with root package name */
    private static String f65164c = "网络错误";

    /* renamed from: d  reason: collision with root package name */
    private static String f65165d = "网络链接超时";

    /* renamed from: e  reason: collision with root package name */
    private static String f65166e = "证书错误";

    /* renamed from: f  reason: collision with root package name */
    private static String f65167f = "证书过期";

    /* renamed from: g  reason: collision with root package name */
    private static String f65168g = "参数不合法";

    /* renamed from: h  reason: collision with root package name */
    private static String f65169h = "验证会话已取消";

    /* renamed from: i  reason: collision with root package name */
    private static String f65170i = "不支持的 WebView 组件";

    private ad() {
    }

    public static String a() {
        return f65163b;
    }

    public static String b() {
        return f65166e;
    }

    public static String c() {
        return f65168g;
    }

    public static String d() {
        return f65169h;
    }

    public static String e() {
        return f65170i;
    }

    public static void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        af afVar = af.f65176a;
        f65163b = applicationContext.getString(af.a(context, "gt4_web_callback_error"));
        f65164c = context.getApplicationContext().getString(af.a(context, "gt4_web_view_load_error"));
        f65166e = context.getApplicationContext().getString(af.a(context, "gt4_web_view_ssl_error"));
        f65168g = context.getApplicationContext().getString(af.a(context, "gt4_parameter_config_error"));
        f65169h = context.getApplicationContext().getString(af.a(context, "gt4_user_cancel"));
        f65170i = context.getApplicationContext().getString(af.a(context, "gt4_device_not_supported"));
    }
}
