package com.qihoo.stat;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.InnerShareParams;
import com.twitter.sdk.android.core.identity.AuthHandler;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URLEncoder;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f28704a = "QPlayer";

    /* renamed from: b  reason: collision with root package name */
    public static m f28705b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f28706c = false;

    public static int a(Context context, String str) {
        String g11 = c0.g(context, "playlist", "");
        if (!g11.contains(String.valueOf(str) + Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            g11 = g11 + str + Constants.ACCEPT_TIME_SEPARATOR_SP;
            c0.c(context, "playlist", g11);
        }
        return g11.split(Constants.ACCEPT_TIME_SEPARATOR_SP).length;
    }

    public static void b() {
        f28706c = false;
    }

    public static void c(Context context) {
        m mVar = f28705b;
        if (mVar != null && !TextUtils.isEmpty(mVar.f28804a)) {
            c0.b(context, URLEncoder.encode(f28705b.f28804a), c0.e(context, URLEncoder.encode(f28705b.f28804a), 1) + 1);
        }
    }

    public static JSONObject d(Context context) {
        JSONObject jSONObject = null;
        try {
            if (f28705b == null) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (!TextUtils.isEmpty(f28705b.f28804a)) {
                    jSONObject2.put("id", f28705b.f28804a);
                    long e11 = c0.e(context, URLEncoder.encode(f28705b.f28804a), 1);
                    jSONObject2.put("ttimes", e11);
                    if (1 == e11) {
                        jSONObject2.put("accNum", a(context, URLEncoder.encode(f28705b.f28804a)));
                    }
                }
                Set<Object> set = f28705b.f28806c;
                if (set != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (Object put : set) {
                        jSONArray.put(put);
                    }
                    jSONObject2.put("role", jSONArray);
                }
                int i11 = f28705b.f28807d;
                if (i11 != 0) {
                    jSONObject2.put("age", i11);
                }
                int i12 = f28705b.f28808e;
                if (i12 != 0) {
                    jSONObject2.put("gender", i12);
                }
                if (!TextUtils.isEmpty(f28705b.f28809f)) {
                    jSONObject2.put("source", f28705b.f28809f);
                }
                if (!TextUtils.isEmpty(f28705b.f28810g)) {
                    jSONObject2.put("rank", f28705b.f28810g);
                }
                if (!TextUtils.isEmpty(f28705b.f28811h)) {
                    jSONObject2.put("server", f28705b.f28811h);
                }
                if (!TextUtils.isEmpty(f28705b.f28812i)) {
                    jSONObject2.put(InnerShareParams.COMMENT, f28705b.f28812i);
                }
                jSONObject2.put(AuthHandler.EXTRA_TOKEN_SECRET, f28705b.f28813j);
                return jSONObject2;
            } catch (Exception e12) {
                e = e12;
                jSONObject = jSONObject2;
                g0.b(f28704a, e);
                return jSONObject;
            } catch (Error e13) {
                e = e13;
                jSONObject = jSONObject2;
                g0.a(f28704a, e);
                return jSONObject;
            }
        } catch (Exception e14) {
            e = e14;
            g0.b(f28704a, e);
            return jSONObject;
        } catch (Error e15) {
            e = e15;
            g0.a(f28704a, e);
            return jSONObject;
        }
    }
}
