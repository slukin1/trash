package com.kakao.kakaolink.v2.network;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import ax.b;
import com.kakao.util.exception.KakaoException;
import java.util.Map;
import org.json.JSONObject;
import sw.a;
import tw.f;
import uw.e;

public interface KakaoLinkCore {

    public static class Factory {

        /* renamed from: a  reason: collision with root package name */
        public static KakaoLinkCore f25033a = new a(com.kakao.common.a.b(), b.a.a());

        public static KakaoLinkCore a() {
            return f25033a;
        }
    }

    Intent a(Context context, String str, JSONObject jSONObject, Map<String, String> map) throws KakaoException;

    Uri b(Context context, String str, String str2, Map<String, String> map, Map<String, String> map2);

    Uri c(Context context, f fVar, Map<String, String> map);

    boolean d(Context context);

    e e(Context context, String str, f fVar);

    e f(Context context, String str, String str2, Map<String, String> map);

    e g(Context context, String str, String str2, String str3, Map<String, String> map);

    Uri h(Context context, String str, Map<String, String> map, Map<String, String> map2);
}
