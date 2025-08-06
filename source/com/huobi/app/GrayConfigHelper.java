package com.huobi.app;

import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.m0;
import com.huobi.account.bean.GrayWhiteListBean;
import com.huobi.network.HttpConfig;
import i6.k;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import okhttp3.CacheControl;
import okhttp3.Request;
import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class GrayConfigHelper {

    /* renamed from: a  reason: collision with root package name */
    public static String[] f42133a = {"https://app-static-1306115679.file.myqcloud.com/hbapp-directory/dynamic/grayScaleConfig/release/config.json?version=" + System.currentTimeMillis(), "https://hbg-prod-fed-public.hbfile.net/hbapp-directory/dynamic/grayScaleConfig/release/config.json?version=" + System.currentTimeMillis()};

    /* renamed from: b  reason: collision with root package name */
    public static String[] f42134b = {"https://app-static-1306115679.file.myqcloud.com/hbapp-directory/dynamic/grayScaleConfig/test/config.json?version=" + System.currentTimeMillis(), "https://hbg-prod-fed-public.hbfile.net/hbapp-directory/dynamic/grayScaleConfig/test/config.json?version=" + System.currentTimeMillis()};

    /* renamed from: c  reason: collision with root package name */
    public static List<GrayWhiteListBean> f42135c;

    public class a extends TypeToken<List<GrayWhiteListBean>> {
    }

    public class b implements Action1<String> {
        /* renamed from: a */
        public void call(String str) {
            String[] a11 = GrayConfigHelper.f42133a;
            List b11 = GrayConfigHelper.e(a11[0]);
            if (b11 == null) {
                b11 = GrayConfigHelper.e(a11[1]);
            }
            if (b11 != null) {
                List unused = GrayConfigHelper.f42135c = b11;
                ConfigPreferences.m("user_config", "app_gray_config_list", new Gson().toJson((Object) b11));
            }
        }
    }

    public class c extends TypeToken<List<GrayWhiteListBean>> {
    }

    public class d extends TypeToken<List<GrayWhiteListBean>> {
    }

    public static boolean d(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && BaseModuleConfig.a() != null) {
            if (f42135c == null) {
                String d11 = ConfigPreferences.d("user_config", "app_gray_config_list");
                try {
                    if (!TextUtils.isEmpty(d11) && d11.trim().startsWith("[")) {
                        f42135c = (List) new Gson().fromJson(d11, new d().getType());
                    }
                } catch (Exception e11) {
                    Log.e("GrayConfigHelper", "updateGrayUser: ", e11);
                }
            }
            List<GrayWhiteListBean> list = f42135c;
            if (list != null && !list.isEmpty()) {
                for (GrayWhiteListBean next : f42135c) {
                    if (next.type.equals(str2) && next.minVersionAndroid <= 105400) {
                        if ((TextUtils.isEmpty(next.bundleIDAndroid) || next.bundleIDAndroid.equals("pro.huobi")) && !next.pathRegulars.isEmpty()) {
                            if (!next.uids.isEmpty() || !next.devices.isEmpty()) {
                                for (String next2 : next.pathRegulars) {
                                    if (!TextUtils.isEmpty(next2) && Pattern.compile(next2).matcher(str).find()) {
                                        if (!BaseModuleConfig.a().a()) {
                                            return next.devices.contains(m0.a());
                                        }
                                        if (next.uids.contains(BaseModuleConfig.a().getUid()) || next.devices.contains(m0.a())) {
                                            return true;
                                        }
                                        return false;
                                    }
                                }
                                continue;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static List<GrayWhiteListBean> e(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            String string = HttpConfig.a(false).build().newCall(new Request.Builder().url(str).cacheControl(CacheControl.FORCE_NETWORK).get().build()).execute().body().string();
            k.d("GrayConfigHelper", "请求名单成功：" + string);
            return (List) new Gson().fromJson(string, new c().getType());
        } catch (Exception e11) {
            k.d("GrayConfigHelper", "请求名单失败：" + e11.getMessage());
            e11.printStackTrace();
            return arrayList;
        }
    }

    public static void f() {
        try {
            String d11 = ConfigPreferences.d("user_config", "app_gray_config_list");
            try {
                if (!TextUtils.isEmpty(d11) && d11.trim().startsWith("[")) {
                    f42135c = (List) new Gson().fromJson(d11, new a().getType());
                }
            } catch (Exception e11) {
                Log.e("GrayConfigHelper", "updateGrayUser: ", e11);
            }
            Observable.just("gray").observeOn(Schedulers.io()).subscribe(new b());
        } catch (Exception e12) {
            k.e("更新灰度开关失败，发生异常：" + e12.getMessage());
            e12.printStackTrace();
        }
    }
}
