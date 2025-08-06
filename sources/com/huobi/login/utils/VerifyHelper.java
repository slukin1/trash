package com.huobi.login.utils;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import cn.sharesdk.framework.InnerShareParams;
import com.alibaba.verificationsdk.ui.IActivityCallback;
import com.geetest.captcha.GTCaptcha4Client;
import com.geetest.captcha.GTCaptcha4Config;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.recaptcha.Recaptcha;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.android.recaptcha.RecaptchaTasksClient;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.NightHelper;
import com.huobi.compliance.ComplianceUtil;
import com.huobi.login.bean.CaptchaVerifyBean;
import com.huobi.login.bean.GoogleVerifyTokenBean;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import com.huobi.webview2.ui.VerifyWebActivity;
import i6.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import sn.a0;
import sn.b0;
import sn.c0;
import sn.x;
import sn.y;
import sn.z;

public class VerifyHelper {

    /* renamed from: a  reason: collision with root package name */
    public IActivityCallback f75716a;

    /* renamed from: b  reason: collision with root package name */
    public d f75717b;

    public class a implements ComplianceUtil.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f75718a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f75719b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f75720c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ RiskControl f75721d;

        public a(Activity activity, String str, String str2, RiskControl riskControl) {
            this.f75718a = activity;
            this.f75719b = str;
            this.f75720c = str2;
            this.f75721d = riskControl;
        }

        public void a() {
            VerifyWebActivity.zh(this.f75718a, this.f75719b, this.f75720c, this.f75721d);
        }

        public void onSuccess(String str) {
            VerifyWebActivity.zh(this.f75718a, this.f75719b, this.f75720c, this.f75721d);
        }
    }

    public class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RiskControl.ItemsBean f75723a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f75724b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f75725c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f75726d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RiskControl f75727e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f75728f;

        public b(RiskControl.ItemsBean itemsBean, Activity activity, String str, String str2, RiskControl riskControl, boolean z11) {
            this.f75723a = itemsBean;
            this.f75724b = activity;
            this.f75725c = str;
            this.f75726d = str2;
            this.f75727e = riskControl;
            this.f75728f = z11;
        }

        public void a(String str) {
            VerifyHelper.this.B(this.f75723a.getType());
            VerifyHelper verifyHelper = VerifyHelper.this;
            verifyHelper.z(verifyHelper.n(this.f75723a.getType(), str));
        }

        public void onFailure(String str) {
            k.e("GoogleVerify Failure:::");
            VerifyHelper.this.C(this.f75724b, this.f75725c, this.f75726d, this.f75727e, this.f75728f);
        }
    }

    public interface c {
        void a(String str);

        void onFailure(String str);
    }

    public interface d {
        void a(int i11, int i12, Intent intent);

        void b(int i11, HashMap<String, Object> hashMap);
    }

    public static void A(HashMap<String, Object> hashMap, JsonObject jsonObject) {
        for (Map.Entry next : jsonObject.entrySet()) {
            String str = (String) next.getKey();
            JsonElement jsonElement = (JsonElement) next.getValue();
            if (jsonElement.isJsonNull()) {
                hashMap.put(str, (Object) null);
            } else if (jsonElement.isJsonObject()) {
                HashMap hashMap2 = new HashMap();
                hashMap.put(str, hashMap2);
                A(hashMap2, jsonElement.getAsJsonObject());
            } else if (jsonElement.isJsonPrimitive()) {
                try {
                    JsonElement parse = new JsonParser().parse(jsonElement.getAsString());
                    if (parse.isJsonNull()) {
                        hashMap.put(str, jsonElement.getAsString());
                    } else if (parse.isJsonObject()) {
                        HashMap hashMap3 = new HashMap();
                        hashMap.put(str, hashMap3);
                        A(hashMap3, parse.getAsJsonObject());
                    } else if (parse.isJsonPrimitive()) {
                        hashMap.put(str, parse.getAsJsonPrimitive().getAsString());
                    }
                } catch (Exception unused) {
                    hashMap.put(str, jsonElement.getAsString());
                }
            }
        }
    }

    public static void k(Map<String, Object> map, HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            map.putAll(hashMap);
        }
    }

    public static void l(Map<String, Object> map, Map<String, String> map2) {
        if (map2 == null) {
            return;
        }
        if (map2.containsKey("recaptcha")) {
            map.put("recaptcha", map2.get("recaptcha"));
            return;
        }
        HashMap hashMap = new HashMap();
        if (map2.containsKey("platform")) {
            hashMap.put("platform", map2.get("platform"));
        } else {
            hashMap.put("platform", "1");
        }
        if (map2.containsKey("sessionID")) {
            hashMap.put(SettingsJsonConstants.SESSION_KEY, map2.get("sessionID"));
        }
        if (map2.containsKey("sig")) {
            hashMap.put("sig", map2.get("sig"));
        }
        if (map2.containsKey("token")) {
            hashMap.put("token", map2.get("token"));
        }
        if (map2.containsKey(InnerShareParams.SCENCE)) {
            hashMap.put(InnerShareParams.SCENCE, map2.get(InnerShareParams.SCENCE));
        }
        map.put("afs", hashMap);
    }

    public static /* synthetic */ void r(String str, c cVar, String str2) {
        GoogleVerifyTokenBean googleVerifyTokenBean = new GoogleVerifyTokenBean();
        googleVerifyTokenBean.setRecaptcha(str2);
        googleVerifyTokenBean.setCaptcha_id(str);
        cVar.a(new Gson().toJson((Object) googleVerifyTokenBean));
    }

    public static /* synthetic */ void t(Activity activity, String str, c cVar, RecaptchaTasksClient recaptchaTasksClient) {
        if (recaptchaTasksClient != null) {
            recaptchaTasksClient.executeTask(RecaptchaAction.LOGIN).addOnSuccessListener(activity, new c0(str, cVar)).addOnFailureListener(activity, (OnFailureListener) new a0(cVar));
        } else {
            cVar.onFailure((String) null);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v(RiskControl.ItemsBean itemsBean, boolean z11, String str) {
        if (z11) {
            B(itemsBean.getType());
            z(n(itemsBean.getType(), q(str, itemsBean.getProperties().getCaptchaId())));
            return;
        }
        z((String) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w(Activity activity, String str, String str2, RiskControl riskControl, boolean z11, String str3) {
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (!jSONObject.has("code") || !jSONObject.getString("code").equals("-14460")) {
                C(activity, str, str2, riskControl, z11);
            } else {
                z((String) null);
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    public final void B(int i11) {
        SP.q("native_verify_succeed_type", i11);
    }

    public final void C(Activity activity, String str, String str2, RiskControl riskControl, boolean z11) {
        if (z11) {
            E(activity, str, str2, riskControl, o(riskControl.getLowItems()), false);
            return;
        }
        x(activity, str, str2, riskControl);
    }

    public void D(Activity activity, String str, c cVar) {
        if (cVar != null) {
            Recaptcha.getTasksClient(activity.getApplication(), str).addOnSuccessListener(activity, new b0(activity, str, cVar)).addOnFailureListener(activity, (OnFailureListener) new z(cVar));
        }
    }

    public final void E(Activity activity, String str, String str2, RiskControl riskControl, RiskControl.ItemsBean itemsBean, boolean z11) {
        RiskControl.ItemsBean itemsBean2 = itemsBean;
        if (itemsBean2 == null) {
            x(activity, str, str2, riskControl);
            return;
        }
        int i11 = 2;
        if (itemsBean.getType() == 2) {
            D(activity, itemsBean.getProperties().getCaptchaId(), new b(itemsBean, activity, str, str2, riskControl, z11));
            return;
        }
        Activity activity2 = activity;
        if (itemsBean.getType() == 3) {
            GTCaptcha4Config.Builder canceledOnTouchOutside = new GTCaptcha4Config.Builder().setTimeOut(5000).setCanceledOnTouchOutside(true);
            HashMap hashMap = new HashMap();
            if (!NightHelper.e().g()) {
                i11 = 1;
            }
            hashMap.put("displayMode", Integer.valueOf(i11));
            if (z11) {
                hashMap.put("hideSuccess", Boolean.TRUE);
                canceledOnTouchOutside.setDialogStyle("gt4_captcha_low_risk_dialog_style");
            }
            canceledOnTouchOutside.setParams(hashMap);
            GTCaptcha4Client.getClient(activity).init(itemsBean.getProperties().getCaptchaId(), canceledOnTouchOutside.build()).addOnSuccessListener(new y(this, itemsBean2)).addOnFailureListener(new x(this, activity, str, str2, riskControl, z11)).verifyWithCaptcha();
            return;
        }
        x(activity, str, str2, riskControl);
    }

    public final void F(Activity activity, String str, String str2, RiskControl riskControl) {
        RiskControl.ItemsBean o11 = o(riskControl.getItems());
        if (o11 != null) {
            E(activity, str, str2, riskControl, o11, riskControl.getRisk() == 3);
        } else {
            x(activity, str, str2, riskControl);
        }
    }

    public void m(Activity activity, String str, String str2, RiskControl riskControl, d dVar) {
        this.f75717b = dVar;
        F(activity, str, str2, riskControl);
    }

    public final String n(int i11, String str) {
        CaptchaVerifyBean captchaVerifyBean = new CaptchaVerifyBean();
        CaptchaVerifyBean.CaptchaParam captchaParam = new CaptchaVerifyBean.CaptchaParam();
        captchaParam.setType(i11);
        captchaParam.setParams(new Gson().fromJson(str, Object.class));
        captchaVerifyBean.setCaptcha_param(captchaParam);
        return new Gson().toJson((Object) captchaVerifyBean);
    }

    public final RiskControl.ItemsBean o(List<RiskControl.ItemsBean> list) {
        RiskControl.ItemsBean itemsBean = null;
        if (CollectionsUtils.b(list)) {
            return null;
        }
        int p11 = p();
        if (p11 != -1) {
            Iterator<RiskControl.ItemsBean> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                RiskControl.ItemsBean next = it2.next();
                if (next.getType() == p11) {
                    itemsBean = next;
                    break;
                }
            }
        }
        return itemsBean == null ? list.get(0) : itemsBean;
    }

    public final int p() {
        return SP.e("native_verify_succeed_type", -1);
    }

    public final String q(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("captcha_id")) {
                jSONObject.put("captcha_id", str2);
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public final void x(Activity activity, String str, String str2, RiskControl riskControl) {
        ComplianceUtil.g(new a(activity, str, str2, riskControl));
    }

    public boolean y(int i11, int i12, Intent intent) {
        if (i12 != 200) {
            return false;
        }
        String stringExtra = intent.getStringExtra("extra_result");
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        try {
            A(hashMap2, (JsonObject) new Gson().fromJson(stringExtra, JsonObject.class));
            JSONObject jSONObject = new JSONObject(stringExtra);
            if (jSONObject.has("afs")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("afs");
                if (jSONObject2 != null) {
                    hashMap.put("sessionID", jSONObject2.getString(SettingsJsonConstants.SESSION_KEY));
                    hashMap.put("sig", jSONObject2.getString("sig"));
                    hashMap.put("token", jSONObject2.getString("token"));
                    hashMap.put(InnerShareParams.SCENCE, jSONObject2.getString(InnerShareParams.SCENCE));
                    hashMap.put("platform", "3");
                }
            } else if (jSONObject.has("recaptcha")) {
                hashMap.put("recaptcha", jSONObject.getString("recaptcha"));
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        IActivityCallback iActivityCallback = this.f75716a;
        if (iActivityCallback != null) {
            iActivityCallback.onResult(1, hashMap);
        }
        d dVar = this.f75717b;
        if (dVar != null) {
            dVar.b(1, hashMap2);
        }
        return true;
    }

    public final void z(String str) {
        int i11;
        Intent intent;
        if (!TextUtils.isEmpty(str)) {
            intent = new Intent();
            intent.putExtra("extra_result", str);
            i11 = 200;
        } else {
            intent = null;
            i11 = 0;
        }
        d dVar = this.f75717b;
        if (dVar != null) {
            dVar.a(100, i11, intent);
        }
    }
}
