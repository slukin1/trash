package com.huobi.utils;

import android.content.Context;
import android.text.TextUtils;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.huobi.domain.DomainSwitcher;
import com.huochat.community.network.domain.DomainTool;
import i6.d;

public class v0 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f83781a;

    /* renamed from: b  reason: collision with root package name */
    public final String f83782b;

    public v0(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f83781a = context;
            this.f83782b = DomainTool.DOMAIN_PREFIX + DomainSwitcher.w() + "/support/" + a() + "/detail/" + str;
            return;
        }
        throw new IllegalArgumentException("The id of support document should not be null.");
    }

    public static String a() {
        return AppLanguageHelper.getInstance().getCurLanguageUrlLowerCase();
    }

    public static String b(String str) {
        return DomainTool.DOMAIN_PREFIX + DomainSwitcher.w() + "/support/" + a() + "/list/" + str;
    }

    public static String c(String str) {
        return DomainTool.DOMAIN_PREFIX + DomainSwitcher.w() + "/support/" + a() + "/detail/" + str;
    }

    public static void e(Context context, String str) {
        new v0(context, str).d();
    }

    public void d() {
        d.c("SupportDocLauncher", "url=" + this.f83782b);
        HBBaseWebActivity.showWebView(this.f83781a, this.f83782b, (String) null, (String) null, false);
    }
}
