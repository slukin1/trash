package com.huobi.edgeengine.ability;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import com.hbg.lib.network.inst.retrofit.InstRetrofit;
import com.hbg.lib.network.linear.swap.retrofit.LinearSwapRetrofit;
import com.hbg.lib.network.newkyc.retrofit.NewKycRetrofit;
import com.hbg.lib.network.otc.retrofit.OtcRetrofit;
import com.hbg.lib.network.pro.retrofit.ProRetrofit;
import com.hbg.lib.network.uc.retrofit.UcRetrofit;
import com.huobi.domain.DomainSwitcher;
import com.huobi.edgeengine.ability.AbilityFunction;
import com.huobi.network.HttpConfig;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import rj.b;

public class EngineNetworkAbility extends AbstractAbility {

    public class a implements Callback {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbilityFunction.a f43890b;

        public a(AbilityFunction.a aVar) {
            this.f43890b = aVar;
        }

        public void onFailure(Call call, IOException iOException) {
            this.f43890b.a(false, iOException.getMessage());
        }

        public void onResponse(Call call, Response response) throws IOException {
            if (response == null || response.body() == null) {
                this.f43890b.a(false, (Object) null);
            } else {
                this.f43890b.a(true, response.body().string());
            }
        }
    }

    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        JSONObject jSONObject;
        HashMap hashMap;
        if (aVar != null && (obj instanceof String)) {
            try {
                JSONObject jSONObject2 = new JSONObject((String) obj);
                String string = jSONObject2.getString("path");
                int i11 = jSONObject2.getInt("method");
                OkHttpClient okHttpClient = HbgRetrofit.d().getOkHttpClient();
                String str = "";
                int i12 = jSONObject2.getInt("hostType");
                if (i12 == 0) {
                    str = HbgRetrofit.d().getHost();
                    okHttpClient = HbgRetrofit.d().getOkHttpClient();
                } else if (i12 == 1) {
                    str = OtcRetrofit.g().getHost();
                    okHttpClient = OtcRetrofit.g().getOkHttpClient();
                    if (!TextUtils.isEmpty(str) && !"/".equalsIgnoreCase(str.substring(str.length() - 1))) {
                        str = str + "/";
                    }
                } else if (i12 == 2) {
                    str = InstRetrofit.d().getHost();
                    okHttpClient = InstRetrofit.d().getOkHttpClient();
                } else if (i12 == 4) {
                    str = ProRetrofit.g().getHost();
                    okHttpClient = ProRetrofit.g().getOkHttpClient();
                } else if (i12 == 3) {
                    str = NewKycRetrofit.d().getHost();
                    okHttpClient = NewKycRetrofit.d().getOkHttpClient();
                } else if (i12 == 5) {
                    str = UcRetrofit.d().getHost();
                    okHttpClient = UcRetrofit.d().getOkHttpClient();
                } else if (i12 == 6) {
                    str = UcRetrofit.d().getHost();
                    okHttpClient = UcRetrofit.d().getOkHttpClient();
                } else if (i12 == 7) {
                    str = c();
                    okHttpClient = HttpConfig.g();
                } else if (i12 == 8) {
                    str = LinearSwapRetrofit.g().getHost();
                    okHttpClient = LinearSwapRetrofit.g().getOkHttpClient();
                }
                if (!str.endsWith("/")) {
                    str = str + "/";
                }
                String str2 = str + string;
                new Gson();
                String string2 = jSONObject2.getString("params");
                Request.Builder builder = null;
                try {
                    jSONObject = new JSONObject(string2);
                } catch (Throwable unused) {
                    jSONObject = null;
                }
                try {
                    hashMap = (HashMap) JSON.parseObject(jSONObject2.getString("header"), HashMap.class);
                } catch (Throwable unused2) {
                    hashMap = null;
                }
                if (i11 == 0) {
                    Uri.Builder buildUpon = Uri.parse(str2).buildUpon();
                    if (jSONObject != null && jSONObject.length() > 0) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            buildUpon.appendQueryParameter(next, jSONObject.optString(next));
                        }
                    }
                    builder = new Request.Builder().url(buildUpon.build().toString());
                    builder.get().build();
                } else if (i11 == 1) {
                    builder = new Request.Builder().url(str2);
                    builder.get().build();
                    if (hashMap == null || TextUtils.isEmpty((String) hashMap.get("Content-Type"))) {
                        FormBody.Builder builder2 = new FormBody.Builder();
                        if (jSONObject != null && jSONObject.length() > 0) {
                            Iterator<String> keys2 = jSONObject.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                builder2.add(next2, jSONObject.optString(next2));
                            }
                        }
                        builder.post(builder2.build()).build();
                    } else {
                        builder.post(RequestBody.create(MediaType.parse((String) hashMap.get("Content-Type")), string2)).build();
                    }
                }
                if (hashMap != null) {
                    builder.headers(Headers.of((Map<String, String>) hashMap));
                }
                okHttpClient.newCall(builder.build()).enqueue(new a(aVar));
            } catch (JsonSyntaxException | JSONException e11) {
                e11.printStackTrace();
                aVar.a(false, e11.getMessage());
            }
        }
    }

    public boolean b() {
        return false;
    }

    public final String c() {
        String str = wi.b.f48037a;
        if (!SystemUtils.c()) {
            return str;
        }
        String N = DomainSwitcher.N();
        return !TextUtils.isEmpty(N) ? str.replace("l10n-www.huobi.cn/", N) : str;
    }
}
