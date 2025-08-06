package com.hbg.lib.router;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import b2.a;
import com.alibaba.android.arouter.facade.Postcard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HbgRouter {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f70793a = {".huobi.com", ".hbg.com", ".huobi.ae", ".huobi.pk", ".huobi.lv", ".hecoview.com", ".huobi.gr", ".huobi.uz", ".huobiapps.com", ".huobi.pr", ".huobi.hm", ".huobi.ag", ".huobi.ba", ".huobi.cg", ".huobi.gy", ".huobi.hu", ".huobi.je", ".huobi.ke", ".huobi.ly", ".huobi.mg", ".huobi.ng", ".huobi.no", ".huobi.rs", ".huobi.se", ".huobi.sg", ".huobi.si", ".huobi.sl", ".huobi.sm", ".huobi.ws", ".huobi.ug", ".huobi.sn"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f70794b = {"appotc.otcdev.top", "autodiscover.huobi.com", "mail.huobi.com", "huobi.tf", "huobi.lu", "huobi.com.bo", "huobi.pr"};

    /* renamed from: c  reason: collision with root package name */
    public static final List<String> f70795c = Collections.synchronizedList(new ArrayList());

    /* renamed from: d  reason: collision with root package name */
    public static List<String> f70796d = Collections.synchronizedList(new ArrayList());

    public static Bundle a(Uri uri) {
        Bundle bundle = new Bundle();
        if (uri.getQueryParameterNames() != null) {
            for (String next : uri.getQueryParameterNames()) {
                bundle.putString(next, uri.getQueryParameter(next));
            }
        }
        return bundle;
    }

    public static Postcard b(String str, Bundle bundle) {
        Uri c11 = c(str);
        Postcard postcard = null;
        try {
            postcard = a.d().a(c11.getPath());
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            if (c11.getQueryParameterNames() != null) {
                bundle2.putAll(a(c11));
            }
            if (bundle2.size() > 0) {
                postcard.with(bundle2);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return postcard;
    }

    public static Uri c(String str) {
        return Uri.parse(str);
    }

    public static boolean d(String str) {
        List<String> list = f70795c;
        if (list.isEmpty()) {
            list.addAll(Arrays.asList(f70794b));
        }
        String host = Uri.parse(str).getHost();
        if (TextUtils.isEmpty(host)) {
            return false;
        }
        for (String next : list) {
            if (!TextUtils.isEmpty(next) && host.endsWith(next)) {
                return true;
            }
        }
        return false;
    }

    public static boolean e(String str) {
        if (d(str) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (f70796d.isEmpty()) {
            f70796d.addAll(Arrays.asList(f70793a));
        }
        String host = Uri.parse(str).getHost();
        if (!TextUtils.isEmpty(host)) {
            for (String next : f70796d) {
                if (!TextUtils.isEmpty(next) && host.endsWith(next)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("ihuobiglobal") || str.startsWith("holigeit") || str.startsWith("hbotc")) {
            return true;
        }
        return false;
    }

    public static boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("huobicard");
    }

    public static Object h(Context context, String str) {
        return a.d().a(str).navigation(context);
    }

    public static Object i(Context context, String str, Bundle bundle) {
        return a.d().a(str).with(bundle).navigation(context);
    }

    public static void j(Context context, String str) {
        k(context, str, (Bundle) null);
    }

    public static void k(Context context, String str, Bundle bundle) {
        if (f(str)) {
            b(str, bundle).navigation(context);
        }
    }

    public static void l(List<String> list) {
        if (list != null && !list.isEmpty()) {
            f70796d.clear();
            f70796d.addAll(list);
        }
    }
}
