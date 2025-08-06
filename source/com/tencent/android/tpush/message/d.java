package com.tencent.android.tpush.message;

import android.text.TextUtils;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.iproov.sdk.utils.Cif;
import com.sumsub.sentry.c;
import com.tencent.android.tpush.NotificationAction;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.logging.TLogger;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Field;
import org.json.JSONObject;

public class d extends a {
    private int A = 0;
    private String B = "";
    private int C = 0;
    private int D = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f69436d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f69437e = 1;

    /* renamed from: f  reason: collision with root package name */
    private int f69438f = 1;

    /* renamed from: g  reason: collision with root package name */
    private int f69439g = 1;

    /* renamed from: h  reason: collision with root package name */
    private int f69440h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f69441i = 0;

    /* renamed from: j  reason: collision with root package name */
    private String f69442j = "";

    /* renamed from: k  reason: collision with root package name */
    private int f69443k = 1;

    /* renamed from: l  reason: collision with root package name */
    private String f69444l = "";

    /* renamed from: m  reason: collision with root package name */
    private String f69445m = "";

    /* renamed from: n  reason: collision with root package name */
    private int f69446n = 0;

    /* renamed from: o  reason: collision with root package name */
    private int f69447o = 0;

    /* renamed from: p  reason: collision with root package name */
    private String f69448p = "";

    /* renamed from: q  reason: collision with root package name */
    private String f69449q = "";

    /* renamed from: r  reason: collision with root package name */
    private String f69450r = "";

    /* renamed from: s  reason: collision with root package name */
    private int f69451s = -1;

    /* renamed from: t  reason: collision with root package name */
    private String f69452t = "";

    /* renamed from: u  reason: collision with root package name */
    private int f69453u = 2;

    /* renamed from: v  reason: collision with root package name */
    private String f69454v = "";

    /* renamed from: w  reason: collision with root package name */
    private a f69455w = new a();

    /* renamed from: x  reason: collision with root package name */
    private int f69456x = -1;

    /* renamed from: y  reason: collision with root package name */
    private String f69457y = "";

    /* renamed from: z  reason: collision with root package name */
    private String f69458z = "";

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f69459a = NotificationAction.activity.getType();

        /* renamed from: b  reason: collision with root package name */
        public String f69460b = "";

        /* renamed from: c  reason: collision with root package name */
        public C0749a f69461c = new C0749a();

        /* renamed from: d  reason: collision with root package name */
        public String f69462d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f69463e = "";

        /* renamed from: f  reason: collision with root package name */
        public String f69464f = "";

        /* renamed from: g  reason: collision with root package name */
        public int f69465g = 0;

        /* renamed from: h  reason: collision with root package name */
        public String f69466h = "";

        /* renamed from: i  reason: collision with root package name */
        public String f69467i = "";

        /* renamed from: j  reason: collision with root package name */
        public String f69468j = "";

        /* renamed from: com.tencent.android.tpush.message.d$a$a  reason: collision with other inner class name */
        public static class C0749a {

            /* renamed from: a  reason: collision with root package name */
            public int f69469a = 0;

            /* renamed from: b  reason: collision with root package name */
            public int f69470b = 0;
        }

        public void a(String str) {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("action_type")) {
                this.f69459a = jSONObject.getInt("action_type");
            }
            if (!jSONObject.isNull("activity")) {
                this.f69460b = jSONObject.getString("activity");
            }
            if (!jSONObject.isNull("aty_attr")) {
                String optString = jSONObject.optString("aty_attr");
                if (!j.b(optString)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(optString);
                        this.f69461c.f69469a = jSONObject2.optInt(Cif.f2380do);
                        this.f69461c.f69470b = jSONObject2.optInt("pf");
                    } catch (Throwable th2) {
                        TLogger.e("PushMessageAction", "decode activityAttribute error", th2);
                    }
                }
            }
            if (!jSONObject.isNull(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK)) {
                this.f69462d = jSONObject.getString(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            }
            if (!jSONObject.isNull(c.f30298c)) {
                this.f69463e = jSONObject.getString(c.f30298c);
                JSONObject jSONObject3 = new JSONObject(this.f69463e);
                if (!jSONObject3.isNull("url")) {
                    this.f69464f = jSONObject3.getString("url");
                }
                if (!jSONObject3.isNull("confirm")) {
                    this.f69465g = jSONObject3.getInt("confirm");
                }
            }
            if (!jSONObject.isNull(Constants.PACKAGE_NAME)) {
                this.f69467i = jSONObject.getString(Constants.PACKAGE_NAME);
                JSONObject jSONObject4 = new JSONObject(this.f69467i);
                if (!jSONObject4.isNull(com.tencent.android.tpush.common.Constants.FLAG_PACKAGE_DOWNLOAD_URL)) {
                    this.f69468j = jSONObject4.getString(com.tencent.android.tpush.common.Constants.FLAG_PACKAGE_DOWNLOAD_URL);
                }
                if (!jSONObject4.isNull(com.tencent.android.tpush.common.Constants.FLAG_PACKAGE_NAME)) {
                    this.f69466h = jSONObject4.getString(com.tencent.android.tpush.common.Constants.FLAG_PACKAGE_NAME);
                }
                if (!jSONObject4.isNull("confirm")) {
                    this.f69465g = jSONObject4.getInt("confirm");
                }
            }
        }
    }

    public d(String str) {
        super(str);
    }

    private void H() {
        TLogger.d("NotificationMessage", " notificationCategory:" + this.f69450r + " , notificationImportance:" + this.f69451s);
        try {
            String str = this.f69450r;
            if (str == null || TextUtils.isEmpty(str.trim()) || this.f69450r.length() >= 30) {
                TLogger.w("NotificationMessage", "invalid notificationCategory " + this.f69450r + " reset to empty");
                this.f69450r = "";
            } else {
                Class<?> cls = Class.forName("android.app.Notification");
                Field field = cls.getField(this.f69450r);
                field.setAccessible(true);
                this.f69450r = (String) field.get(cls);
            }
        } catch (Throwable unused) {
            TLogger.w("NotificationMessage", "get notificationCategory failed, notificationCategory:" + this.f69450r);
        }
        int i11 = this.f69451s;
        if (i11 < 0 || i11 > 5) {
            TLogger.w("NotificationMessage", "invalid importace value：" + this.f69451s + " reset to default");
            this.f69451s = -1;
        }
    }

    public String A() {
        return this.f69458z;
    }

    public int B() {
        return this.A;
    }

    public String C() {
        return this.B;
    }

    public int D() {
        return this.C;
    }

    public int E() {
        return this.D;
    }

    public String F() {
        String str = this.f69450r;
        return (str == null || TextUtils.isEmpty(str.trim())) ? "" : this.f69450r;
    }

    public int G() {
        int i11 = this.f69451s;
        if (i11 < 0 || i11 > 5) {
            return -1;
        }
        return i11;
    }

    public int b() {
        return 1;
    }

    public void c() {
        this.f69436d = this.f69413a.optInt(MessageKey.MSG_BUILDER_ID);
        this.f69437e = this.f69413a.optInt(MessageKey.MSG_RING, 1);
        this.f69444l = this.f69413a.optString(MessageKey.MSG_RING_RAW);
        this.f69442j = this.f69413a.optString(MessageKey.MSG_ICON_RES);
        this.f69445m = this.f69413a.optString(MessageKey.MSG_SMALL_ICON);
        this.f69443k = this.f69413a.optInt(MessageKey.MSG_LIGHTS, 1);
        this.f69438f = this.f69413a.optInt(MessageKey.MSG_VIBRATE, 1);
        this.f69441i = this.f69413a.optInt("icon");
        this.f69446n = this.f69413a.optInt(MessageKey.MSG_ICON_TYPE, 0);
        this.f69440h = this.f69413a.optInt(MessageKey.MSG_NOTIFY_ID);
        this.f69447o = this.f69413a.optInt(MessageKey.MSG_STYLE_ID, 0);
        this.f69452t = this.f69413a.optString(MessageKey.MSG_RICH_URL, (String) null);
        this.f69454v = this.f69413a.optString(MessageKey.MSG_AUDIO_URL, (String) null);
        this.f69448p = this.f69413a.optString(MessageKey.MSG_NOTIFACTION_ID_CHANNEL_ID);
        this.f69449q = this.f69413a.optString(MessageKey.MSG_NOTIFACTION_ID_CHANNEL_NAME);
        this.f69450r = this.f69413a.optString(MessageKey.MSG_NOTIFACTION_CATEGORY, "");
        this.f69451s = this.f69413a.optInt(MessageKey.MSG_NOTIFACTION_IMPORTSNCE, -1);
        H();
        this.f69453u = this.f69413a.optInt(MessageKey.NOTIFICATION_DISPLAY_MODEL, 2);
        this.A = this.f69413a.optInt("color", 0);
        if (!this.f69413a.isNull(MessageKey.MSG_CLEARABLE)) {
            this.f69439g = this.f69413a.optInt(MessageKey.MSG_CLEARABLE);
        } else {
            this.f69439g = 1;
        }
        if (!this.f69413a.isNull("action")) {
            this.f69455w.a(this.f69413a.getString("action"));
        }
        this.f69456x = this.f69413a.optInt(MessageKey.MSG_BADGE_TYPE, -1);
        this.f69457y = this.f69413a.optString("thread_id");
        this.f69458z = this.f69413a.optString(MessageKey.MSG_THREAD_SUMTEXT);
        String optString = this.f69413a.optString(MessageKey.CUSTOM_LAYOUT_JSON_STR);
        this.B = optString;
        try {
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject = new JSONObject(this.B);
                this.C = jSONObject.optInt(MessageKey.CUSTOM_LAYOUT_LAYOUT_TYPE, 0);
                this.D = jSONObject.optInt(MessageKey.CUSTOM_LAYOUT_USE_STD_STYLE, 0);
            }
        } catch (Throwable th2) {
            TLogger.w("NotificationMessageHolder", "parse customLayoutJsonStr error: " + th2.toString());
        }
    }

    public int g() {
        return this.f69436d;
    }

    public int h() {
        return this.f69437e;
    }

    public int i() {
        return this.f69438f;
    }

    public int j() {
        return this.f69439g;
    }

    public int k() {
        return this.f69440h;
    }

    public a l() {
        return this.f69455w;
    }

    public int m() {
        return this.f69441i;
    }

    public String n() {
        return this.f69452t;
    }

    public String o() {
        return this.f69454v;
    }

    public int p() {
        return this.f69443k;
    }

    public String q() {
        return this.f69444l;
    }

    public String r() {
        return this.f69442j;
    }

    public String s() {
        return this.f69445m;
    }

    public int t() {
        return this.f69446n;
    }

    public int u() {
        return this.f69447o;
    }

    public String v() {
        return this.f69448p;
    }

    public String w() {
        return this.f69449q;
    }

    public int x() {
        return this.f69453u;
    }

    public int y() {
        return this.f69456x;
    }

    public String z() {
        return this.f69457y;
    }
}
