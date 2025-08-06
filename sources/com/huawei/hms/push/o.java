package com.huawei.hms.push;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import com.sumsub.sentry.a;
import com.tencent.android.tpush.common.Constants;
import com.tencent.imsdk.v2.V2TIMConversation;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

public class o {
    private String A = "";
    private int B;
    private String C = "";
    private String D;
    private String E = "";
    private String F = "";

    /* renamed from: a  reason: collision with root package name */
    private String f38404a = "";

    /* renamed from: b  reason: collision with root package name */
    private int f38405b;

    /* renamed from: c  reason: collision with root package name */
    private String f38406c;

    /* renamed from: d  reason: collision with root package name */
    private String f38407d;

    /* renamed from: e  reason: collision with root package name */
    private String f38408e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f38409f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f38410g = "";

    /* renamed from: h  reason: collision with root package name */
    private String f38411h = "";

    /* renamed from: i  reason: collision with root package name */
    private String f38412i = "";

    /* renamed from: j  reason: collision with root package name */
    private String f38413j = "";

    /* renamed from: k  reason: collision with root package name */
    private String f38414k = "";

    /* renamed from: l  reason: collision with root package name */
    private String f38415l;

    /* renamed from: m  reason: collision with root package name */
    private String f38416m;

    /* renamed from: n  reason: collision with root package name */
    private String f38417n;

    /* renamed from: o  reason: collision with root package name */
    private String f38418o;

    /* renamed from: p  reason: collision with root package name */
    private String f38419p;

    /* renamed from: q  reason: collision with root package name */
    private String f38420q = "";

    /* renamed from: r  reason: collision with root package name */
    private String f38421r;

    /* renamed from: s  reason: collision with root package name */
    private String f38422s;

    /* renamed from: t  reason: collision with root package name */
    private int f38423t = k.STYLE_DEFAULT.ordinal();

    /* renamed from: u  reason: collision with root package name */
    private String f38424u = "";

    /* renamed from: v  reason: collision with root package name */
    private String f38425v = "";

    /* renamed from: w  reason: collision with root package name */
    private String f38426w = "";

    /* renamed from: x  reason: collision with root package name */
    private int f38427x = 0;

    /* renamed from: y  reason: collision with root package name */
    private int f38428y = 0;

    /* renamed from: z  reason: collision with root package name */
    private String f38429z;

    public o(byte[] bArr, byte[] bArr2) {
        Charset charset = m.f38400a;
        this.f38421r = new String(bArr, charset);
        this.f38422s = new String(bArr2, charset);
    }

    private JSONObject a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject);
        jSONObject2.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, this.f38404a);
        jSONObject2.put("tag", this.A);
        jSONObject2.put(RemoteMessageConst.Notification.AUTO_CANCEL, this.f38427x);
        jSONObject2.put("visibility", this.f38428y);
        jSONObject2.put(RemoteMessageConst.Notification.WHEN, this.f38429z);
        return jSONObject2;
    }

    private JSONObject b(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(Constants.MQTT_STATISTISC_MSGTYPE_KEY, this.f38410g);
        jSONObject2.put("content", this.f38411h);
        jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_ICON, this.f38412i);
        jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_TITLE, this.f38413j);
        jSONObject2.put("notifySummary", this.f38414k);
        jSONObject2.put(RemoteMessageConst.MessageBody.PARAM, jSONObject);
        return jSONObject2;
    }

    private void c(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("ap")) {
            String string = jSONObject.getString("ap");
            StringBuilder sb2 = new StringBuilder();
            if (TextUtils.isEmpty(string) || string.length() >= 48) {
                this.f38407d = string.substring(0, 48);
                return;
            }
            int length = 48 - string.length();
            for (int i11 = 0; i11 < length; i11++) {
                sb2.append("0");
            }
            sb2.append(string);
            this.f38407d = sb2.toString();
        }
    }

    private boolean d(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has(RemoteMessageConst.Notification.CLICK_ACTION)) {
            this.f38416m = jSONObject.getString(RemoteMessageConst.Notification.CLICK_ACTION);
        }
        if (jSONObject.has(RemoteMessageConst.Notification.INTENT_URI)) {
            this.f38406c = jSONObject.getString(RemoteMessageConst.Notification.INTENT_URI);
        }
        if (jSONObject.has("appPackageName")) {
            this.f38415l = jSONObject.getString("appPackageName");
            return true;
        }
        HMSLog.d("PushSelfShowLog", "appPackageName is null");
        return false;
    }

    private boolean e(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("msgId")) {
            Object obj = jSONObject.get("msgId");
            if (obj instanceof String) {
                this.f38408e = (String) obj;
                return true;
            } else if (!(obj instanceof Integer)) {
                return true;
            } else {
                this.f38408e = String.valueOf(((Integer) obj).intValue());
                return true;
            }
        } else {
            HMSLog.i("PushSelfShowLog", "msgId == null");
            return false;
        }
    }

    private boolean f(JSONObject jSONObject) {
        HMSLog.d("PushSelfShowLog", "enter parseNotifyParam");
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
            if (jSONObject2.has("style")) {
                this.f38423t = jSONObject2.getInt("style");
            }
            this.f38424u = jSONObject2.optString("bigTitle");
            this.f38425v = jSONObject2.optString("bigContent");
            this.E = jSONObject2.optString("icon");
            return true;
        } catch (JSONException e11) {
            HMSLog.i("PushSelfShowLog", e11.toString());
            return false;
        }
    }

    private void g(JSONObject jSONObject) {
        this.f38404a = jSONObject.optString(V2TIMConversation.CONVERSATION_GROUP_TYPE);
        HMSLog.d("PushSelfShowLog", "NOTIFY_GROUP:" + this.f38404a);
        this.f38427x = jSONObject.optInt(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        HMSLog.d("PushSelfShowLog", "autoCancel: " + this.f38427x);
        this.f38428y = jSONObject.optInt("visibility", 0);
        this.f38429z = jSONObject.optString(RemoteMessageConst.Notification.WHEN);
        this.A = jSONObject.optString("tag");
    }

    private boolean h(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.PARAM);
            if (jSONObject2.has("autoClear")) {
                this.f38405b = jSONObject2.getInt("autoClear");
            } else {
                this.f38405b = 0;
            }
            if (!a.f30241h.equals(this.f38410g)) {
                if (!"cosa".equals(this.f38410g)) {
                    if ("url".equals(this.f38410g)) {
                        k(jSONObject2);
                        return true;
                    } else if (!"rp".equals(this.f38410g)) {
                        return true;
                    } else {
                        j(jSONObject2);
                        return true;
                    }
                }
            }
            d(jSONObject2);
            return true;
        } catch (Exception e11) {
            HMSLog.e("PushSelfShowLog", "ParseParam error ", (Throwable) e11);
            return false;
        }
    }

    private boolean i(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(RemoteMessageConst.MessageBody.PS_CONTENT)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
            this.f38410g = jSONObject2.getString(Constants.MQTT_STATISTISC_MSGTYPE_KEY);
            this.f38411h = jSONObject2.optString("content");
            this.f38412i = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.f38413j = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.f38414k = jSONObject2.optString("notifySummary");
            this.D = jSONObject2.optString(RemoteMessageConst.Notification.TICKER);
            if ((!jSONObject2.has(RemoteMessageConst.MessageBody.NOTIFY_DETAIL) || f(jSONObject2)) && jSONObject2.has(RemoteMessageConst.MessageBody.PARAM)) {
                return h(jSONObject2);
            }
        }
        return false;
    }

    private boolean j(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("appPackageName")) {
            this.f38415l = jSONObject.getString("appPackageName");
        }
        if (!jSONObject.has("rpt") || !jSONObject.has("rpl")) {
            HMSLog.d("PushSelfShowLog", "rpl or rpt is null");
            return false;
        }
        this.f38418o = jSONObject.getString("rpl");
        this.f38419p = jSONObject.getString("rpt");
        if (!jSONObject.has("rpct")) {
            return true;
        }
        this.f38420q = jSONObject.getString("rpct");
        return true;
    }

    private boolean k(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("url")) {
            this.f38417n = jSONObject.getString("url");
            if (jSONObject.has("appPackageName")) {
                this.f38415l = jSONObject.getString("appPackageName");
            }
            if (!jSONObject.has("rpt") || !jSONObject.has("rpl")) {
                return true;
            }
            this.f38418o = jSONObject.getString("rpl");
            this.f38419p = jSONObject.getString("rpt");
            if (!jSONObject.has("rpct")) {
                return true;
            }
            this.f38420q = jSONObject.getString("rpct");
            return true;
        }
        HMSLog.d("PushSelfShowLog", "url is null");
        return false;
    }

    private JSONObject q() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("style", this.f38423t);
        jSONObject.put("bigTitle", this.f38424u);
        jSONObject.put("bigContent", this.f38425v);
        jSONObject.put("bigPic", this.f38426w);
        return jSONObject;
    }

    private JSONObject u() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("autoClear", this.f38405b);
        jSONObject.put("url", this.f38417n);
        jSONObject.put("rpl", this.f38418o);
        jSONObject.put("rpt", this.f38419p);
        jSONObject.put("rpct", this.f38420q);
        jSONObject.put("appPackageName", this.f38415l);
        jSONObject.put(RemoteMessageConst.Notification.CLICK_ACTION, this.f38416m);
        jSONObject.put(RemoteMessageConst.Notification.INTENT_URI, this.f38406c);
        return jSONObject;
    }

    public String l() {
        return this.E;
    }

    public String m() {
        return this.f38406c;
    }

    public byte[] n() {
        try {
            return a(a(b(u()), q())).toString().getBytes(m.f38400a);
        } catch (JSONException e11) {
            HMSLog.e("PushSelfShowLog", "getMsgData failed JSONException:", (Throwable) e11);
            return new byte[0];
        }
    }

    public String o() {
        HMSLog.d("PushSelfShowLog", "msgId =" + this.f38408e);
        return this.f38408e;
    }

    public String p() {
        return this.A;
    }

    public int r() {
        return this.B;
    }

    public String s() {
        return this.f38414k;
    }

    public String t() {
        return this.f38413j;
    }

    public int v() {
        return this.f38423t;
    }

    public String w() {
        return this.D;
    }

    public byte[] x() {
        return this.f38422s.getBytes(m.f38400a);
    }

    public boolean y() {
        try {
            if (TextUtils.isEmpty(this.f38421r)) {
                HMSLog.d("PushSelfShowLog", "msg is null");
                return false;
            }
            JSONObject jSONObject = new JSONObject(this.f38421r);
            g(jSONObject);
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
            if (!e(jSONObject2)) {
                return false;
            }
            this.f38409f = jSONObject2.optString("dispPkgName");
            c(jSONObject2);
            this.B = jSONObject2.optInt(RemoteMessageConst.Notification.NOTIFY_ID, -1);
            this.C = jSONObject2.optString("data");
            this.F = jSONObject2.optString(RemoteMessageConst.ANALYTIC_INFO);
            return i(jSONObject2);
        } catch (JSONException unused) {
            HMSLog.d("PushSelfShowLog", "parse message exception.");
            return false;
        } catch (Exception e11) {
            HMSLog.d("PushSelfShowLog", e11.toString());
            return false;
        }
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("dispPkgName", this.f38409f);
        jSONObject3.put("msgId", this.f38408e);
        jSONObject3.put("ap", this.f38407d);
        jSONObject3.put(RemoteMessageConst.Notification.NOTIFY_ID, this.B);
        jSONObject3.put(RemoteMessageConst.MessageBody.PS_CONTENT, jSONObject);
        jSONObject3.put(RemoteMessageConst.MessageBody.NOTIFY_DETAIL, jSONObject2);
        jSONObject3.put(RemoteMessageConst.Notification.TICKER, this.D);
        jSONObject3.put("data", this.C);
        return jSONObject3;
    }

    public String b() {
        return this.F;
    }

    public int d() {
        return this.f38427x;
    }

    public String g() {
        return this.f38424u;
    }

    public int e() {
        return this.f38405b;
    }

    public String f() {
        return this.f38425v;
    }

    public String j() {
        return this.f38409f;
    }

    public String c() {
        return this.f38415l;
    }

    public String k() {
        return this.f38404a;
    }

    public String h() {
        return this.f38410g;
    }

    public String i() {
        return this.f38411h;
    }

    public String a() {
        return this.f38416m;
    }

    public void a(int i11) {
        this.B = i11;
    }
}
