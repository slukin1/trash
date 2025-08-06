package com.huawei.hms.push;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.DateUtil;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.api.push.PushException;
import com.huawei.hms.support.log.HMSLog;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class RemoteMessage implements Parcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new a();
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f38350c;

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f38351d;

    /* renamed from: e  reason: collision with root package name */
    private static final long[] f38352e;

    /* renamed from: f  reason: collision with root package name */
    private static final HashMap<String, Object> f38353f;

    /* renamed from: g  reason: collision with root package name */
    private static final HashMap<String, Object> f38354g;

    /* renamed from: h  reason: collision with root package name */
    private static final HashMap<String, Object> f38355h;

    /* renamed from: i  reason: collision with root package name */
    private static final HashMap<String, Object> f38356i;

    /* renamed from: j  reason: collision with root package name */
    private static final HashMap<String, Object> f38357j;

    /* renamed from: a  reason: collision with root package name */
    private Bundle f38358a;

    /* renamed from: b  reason: collision with root package name */
    private Notification f38359b;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final Bundle f38360a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, String> f38361b = new HashMap();

        public Builder(String str) {
            Bundle bundle = new Bundle();
            this.f38360a = bundle;
            bundle.putString("to", str);
        }

        public Builder addData(String str, String str2) {
            if (str != null) {
                this.f38361b.put(str, str2);
                return this;
            }
            throw new IllegalArgumentException("add data failed, key is null.");
        }

        public RemoteMessage build() {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry next : this.f38361b.entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
                try {
                    String jSONObject2 = jSONObject.toString();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(RemoteMessageConst.COLLAPSE_KEY, this.f38360a.getString(RemoteMessageConst.COLLAPSE_KEY));
                    jSONObject3.put("ttl", this.f38360a.getInt("ttl"));
                    jSONObject3.put(RemoteMessageConst.SEND_MODE, this.f38360a.getInt(RemoteMessageConst.SEND_MODE));
                    jSONObject3.put(RemoteMessageConst.RECEIPT_MODE, this.f38360a.getInt(RemoteMessageConst.RECEIPT_MODE));
                    JSONObject jSONObject4 = new JSONObject();
                    if (jSONObject.length() != 0) {
                        jSONObject4.put("data", jSONObject2);
                    }
                    jSONObject4.put("msgId", this.f38360a.getString("msgId"));
                    jSONObject3.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject4);
                    bundle.putByteArray(RemoteMessageConst.MSGBODY, jSONObject3.toString().getBytes(m.f38400a));
                    bundle.putString("to", this.f38360a.getString("to"));
                    bundle.putString("message_type", this.f38360a.getString("message_type"));
                    return new RemoteMessage(bundle);
                } catch (JSONException unused) {
                    HMSLog.w("RemoteMessage", "JSONException: parse message body failed.");
                    throw new PushException(PushException.EXCEPTION_SEND_FAILED);
                }
            } catch (JSONException unused2) {
                HMSLog.w("RemoteMessage", "JSONException: parse data to json failed.");
                throw new PushException(PushException.EXCEPTION_SEND_FAILED);
            }
        }

        public Builder clearData() {
            this.f38361b.clear();
            return this;
        }

        public Builder setCollapseKey(String str) {
            this.f38360a.putString(RemoteMessageConst.COLLAPSE_KEY, str);
            return this;
        }

        public Builder setData(Map<String, String> map) {
            this.f38361b.clear();
            for (Map.Entry next : map.entrySet()) {
                this.f38361b.put(next.getKey(), next.getValue());
            }
            return this;
        }

        public Builder setMessageId(String str) {
            this.f38360a.putString("msgId", str);
            return this;
        }

        public Builder setMessageType(String str) {
            this.f38360a.putString("message_type", str);
            return this;
        }

        public Builder setReceiptMode(int i11) {
            if (i11 == 1 || i11 == 0) {
                this.f38360a.putInt(RemoteMessageConst.RECEIPT_MODE, i11);
                return this;
            }
            throw new IllegalArgumentException("receipt mode can only be 0 or 1.");
        }

        public Builder setSendMode(int i11) {
            if (i11 == 0 || i11 == 1) {
                this.f38360a.putInt(RemoteMessageConst.SEND_MODE, i11);
                return this;
            }
            throw new IllegalArgumentException("send mode can only be 0 or 1.");
        }

        public Builder setTtl(int i11) {
            if (i11 < 1 || i11 > 1296000) {
                throw new IllegalArgumentException("ttl must be greater than or equal to 1 and less than or equal to 1296000");
            }
            this.f38360a.putInt("ttl", i11);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    public static class Notification implements Serializable {
        private final long[] A;
        private final String B;

        /* renamed from: a  reason: collision with root package name */
        private final String f38362a;

        /* renamed from: b  reason: collision with root package name */
        private final String f38363b;

        /* renamed from: c  reason: collision with root package name */
        private final String[] f38364c;

        /* renamed from: d  reason: collision with root package name */
        private final String f38365d;

        /* renamed from: e  reason: collision with root package name */
        private final String f38366e;

        /* renamed from: f  reason: collision with root package name */
        private final String[] f38367f;

        /* renamed from: g  reason: collision with root package name */
        private final String f38368g;

        /* renamed from: h  reason: collision with root package name */
        private final String f38369h;

        /* renamed from: i  reason: collision with root package name */
        private final String f38370i;

        /* renamed from: j  reason: collision with root package name */
        private final String f38371j;

        /* renamed from: k  reason: collision with root package name */
        private final String f38372k;

        /* renamed from: l  reason: collision with root package name */
        private final String f38373l;

        /* renamed from: m  reason: collision with root package name */
        private final String f38374m;

        /* renamed from: n  reason: collision with root package name */
        private final Uri f38375n;

        /* renamed from: o  reason: collision with root package name */
        private final int f38376o;

        /* renamed from: p  reason: collision with root package name */
        private final String f38377p;

        /* renamed from: q  reason: collision with root package name */
        private final int f38378q;

        /* renamed from: r  reason: collision with root package name */
        private final int f38379r;

        /* renamed from: s  reason: collision with root package name */
        private final int f38380s;

        /* renamed from: t  reason: collision with root package name */
        private final int[] f38381t;

        /* renamed from: u  reason: collision with root package name */
        private final String f38382u;

        /* renamed from: v  reason: collision with root package name */
        private final int f38383v;

        /* renamed from: w  reason: collision with root package name */
        private final String f38384w;

        /* renamed from: x  reason: collision with root package name */
        private final int f38385x;

        /* renamed from: y  reason: collision with root package name */
        private final String f38386y;

        /* renamed from: z  reason: collision with root package name */
        private final String f38387z;

        public /* synthetic */ Notification(Bundle bundle, a aVar) {
            this(bundle);
        }

        private Integer a(String str) {
            if (str != null) {
                try {
                    return Integer.valueOf(str);
                } catch (NumberFormatException unused) {
                    HMSLog.w("RemoteMessage", "NumberFormatException: get " + str + " failed.");
                }
            }
            return null;
        }

        public Integer getBadgeNumber() {
            return a(this.f38384w);
        }

        public String getBody() {
            return this.f38365d;
        }

        public String[] getBodyLocalizationArgs() {
            String[] strArr = this.f38367f;
            return strArr == null ? new String[0] : (String[]) strArr.clone();
        }

        public String getBodyLocalizationKey() {
            return this.f38366e;
        }

        public String getChannelId() {
            return this.f38374m;
        }

        public String getClickAction() {
            return this.f38372k;
        }

        public String getColor() {
            return this.f38371j;
        }

        public String getIcon() {
            return this.f38368g;
        }

        public Uri getImageUrl() {
            String str = this.f38377p;
            if (str == null) {
                return null;
            }
            return Uri.parse(str);
        }

        public Integer getImportance() {
            return a(this.f38386y);
        }

        public String getIntentUri() {
            return this.f38373l;
        }

        public int[] getLightSettings() {
            int[] iArr = this.f38381t;
            return iArr == null ? new int[0] : (int[]) iArr.clone();
        }

        public Uri getLink() {
            return this.f38375n;
        }

        public int getNotifyId() {
            return this.f38376o;
        }

        public String getSound() {
            return this.f38369h;
        }

        public String getTag() {
            return this.f38370i;
        }

        public String getTicker() {
            return this.f38387z;
        }

        public String getTitle() {
            return this.f38362a;
        }

        public String[] getTitleLocalizationArgs() {
            String[] strArr = this.f38364c;
            return strArr == null ? new String[0] : (String[]) strArr.clone();
        }

        public String getTitleLocalizationKey() {
            return this.f38363b;
        }

        public long[] getVibrateConfig() {
            long[] jArr = this.A;
            return jArr == null ? new long[0] : (long[]) jArr.clone();
        }

        public Integer getVisibility() {
            return a(this.B);
        }

        public Long getWhen() {
            if (!TextUtils.isEmpty(this.f38382u)) {
                try {
                    return Long.valueOf(DateUtil.parseUtcToMillisecond(this.f38382u));
                } catch (ParseException unused) {
                    HMSLog.w("RemoteMessage", "ParseException: parse when failed.");
                } catch (StringIndexOutOfBoundsException unused2) {
                    HMSLog.w("RemoteMessage", "StringIndexOutOfBoundsException: parse when failed.");
                }
            }
            return null;
        }

        public boolean isAutoCancel() {
            return this.f38385x == 1;
        }

        public boolean isDefaultLight() {
            return this.f38378q == 1;
        }

        public boolean isDefaultSound() {
            return this.f38379r == 1;
        }

        public boolean isDefaultVibrate() {
            return this.f38380s == 1;
        }

        public boolean isLocalOnly() {
            return this.f38383v == 1;
        }

        private Notification(Bundle bundle) {
            this.f38362a = bundle.getString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.f38365d = bundle.getString("content");
            this.f38363b = bundle.getString(RemoteMessageConst.Notification.TITLE_LOC_KEY);
            this.f38366e = bundle.getString(RemoteMessageConst.Notification.BODY_LOC_KEY);
            this.f38364c = bundle.getStringArray(RemoteMessageConst.Notification.TITLE_LOC_ARGS);
            this.f38367f = bundle.getStringArray(RemoteMessageConst.Notification.BODY_LOC_ARGS);
            this.f38368g = bundle.getString("icon");
            this.f38371j = bundle.getString("color");
            this.f38369h = bundle.getString(RemoteMessageConst.Notification.SOUND);
            this.f38370i = bundle.getString("tag");
            this.f38374m = bundle.getString(RemoteMessageConst.Notification.CHANNEL_ID);
            this.f38372k = bundle.getString(RemoteMessageConst.Notification.CLICK_ACTION);
            this.f38373l = bundle.getString(RemoteMessageConst.Notification.INTENT_URI);
            this.f38376o = bundle.getInt(RemoteMessageConst.Notification.NOTIFY_ID);
            String string = bundle.getString("url");
            this.f38375n = !TextUtils.isEmpty(string) ? Uri.parse(string) : null;
            this.f38377p = bundle.getString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.f38378q = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS);
            this.f38379r = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_SOUND);
            this.f38380s = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS);
            this.f38381t = bundle.getIntArray(RemoteMessageConst.Notification.LIGHT_SETTINGS);
            this.f38382u = bundle.getString(RemoteMessageConst.Notification.WHEN);
            this.f38383v = bundle.getInt(RemoteMessageConst.Notification.LOCAL_ONLY);
            this.f38384w = bundle.getString(RemoteMessageConst.Notification.BADGE_SET_NUM, (String) null);
            this.f38385x = bundle.getInt(RemoteMessageConst.Notification.AUTO_CANCEL);
            this.f38386y = bundle.getString("priority", (String) null);
            this.f38387z = bundle.getString(RemoteMessageConst.Notification.TICKER);
            this.A = bundle.getLongArray(RemoteMessageConst.Notification.VIBRATE_TIMINGS);
            this.B = bundle.getString("visibility", (String) null);
        }
    }

    public class a implements Parcelable.Creator<RemoteMessage> {
        /* renamed from: a */
        public RemoteMessage createFromParcel(Parcel parcel) {
            return new RemoteMessage(parcel);
        }

        /* renamed from: a */
        public RemoteMessage[] newArray(int i11) {
            return new RemoteMessage[i11];
        }
    }

    static {
        String[] strArr = new String[0];
        f38350c = strArr;
        int[] iArr = new int[0];
        f38351d = iArr;
        long[] jArr = new long[0];
        f38352e = jArr;
        HashMap<String, Object> hashMap = new HashMap<>(8);
        f38353f = hashMap;
        hashMap.put("from", "");
        hashMap.put(RemoteMessageConst.COLLAPSE_KEY, "");
        hashMap.put(RemoteMessageConst.SEND_TIME, "");
        hashMap.put("ttl", 86400);
        hashMap.put(RemoteMessageConst.URGENCY, 2);
        hashMap.put(RemoteMessageConst.ORI_URGENCY, 2);
        hashMap.put(RemoteMessageConst.SEND_MODE, 0);
        hashMap.put(RemoteMessageConst.RECEIPT_MODE, 0);
        HashMap<String, Object> hashMap2 = new HashMap<>(8);
        f38354g = hashMap2;
        hashMap2.put(RemoteMessageConst.Notification.TITLE_LOC_KEY, "");
        hashMap2.put(RemoteMessageConst.Notification.BODY_LOC_KEY, "");
        hashMap2.put(RemoteMessageConst.Notification.NOTIFY_ICON, "");
        hashMap2.put(RemoteMessageConst.Notification.TITLE_LOC_ARGS, strArr);
        hashMap2.put(RemoteMessageConst.Notification.BODY_LOC_ARGS, strArr);
        hashMap2.put(RemoteMessageConst.Notification.TICKER, "");
        hashMap2.put(RemoteMessageConst.Notification.NOTIFY_TITLE, "");
        hashMap2.put("content", "");
        HashMap<String, Object> hashMap3 = new HashMap<>(8);
        f38355h = hashMap3;
        hashMap3.put("icon", "");
        hashMap3.put("color", "");
        hashMap3.put(RemoteMessageConst.Notification.SOUND, "");
        hashMap3.put(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS, 1);
        hashMap3.put(RemoteMessageConst.Notification.LIGHT_SETTINGS, iArr);
        hashMap3.put(RemoteMessageConst.Notification.DEFAULT_SOUND, 1);
        hashMap3.put(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS, 1);
        hashMap3.put(RemoteMessageConst.Notification.VIBRATE_TIMINGS, jArr);
        HashMap<String, Object> hashMap4 = new HashMap<>(8);
        f38356i = hashMap4;
        hashMap4.put("tag", "");
        hashMap4.put(RemoteMessageConst.Notification.WHEN, "");
        hashMap4.put(RemoteMessageConst.Notification.LOCAL_ONLY, 1);
        hashMap4.put(RemoteMessageConst.Notification.BADGE_SET_NUM, "");
        hashMap4.put("priority", "");
        hashMap4.put(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        hashMap4.put("visibility", "");
        hashMap4.put(RemoteMessageConst.Notification.CHANNEL_ID, "");
        HashMap<String, Object> hashMap5 = new HashMap<>(3);
        f38357j = hashMap5;
        hashMap5.put(RemoteMessageConst.Notification.CLICK_ACTION, "");
        hashMap5.put(RemoteMessageConst.Notification.INTENT_URI, "");
        hashMap5.put("url", "");
    }

    public RemoteMessage(Bundle bundle) {
        this.f38358a = a(bundle);
    }

    private Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        JSONObject b11 = b(bundle);
        JSONObject a11 = a(b11);
        String string = JsonUtil.getString(a11, "data", (String) null);
        bundle2.putString(RemoteMessageConst.ANALYTIC_INFO, JsonUtil.getString(a11, RemoteMessageConst.ANALYTIC_INFO, (String) null));
        bundle2.putString(RemoteMessageConst.DEVICE_TOKEN, bundle.getString(RemoteMessageConst.DEVICE_TOKEN));
        JSONObject d11 = d(a11);
        JSONObject b12 = b(d11);
        JSONObject c11 = c(d11);
        if (bundle.getInt(RemoteMessageConst.INPUT_TYPE) != 1 || !d.a(a11, d11, string)) {
            String string2 = bundle.getString("to");
            String string3 = bundle.getString("message_type");
            String string4 = JsonUtil.getString(a11, "msgId", (String) null);
            bundle2.putString("to", string2);
            bundle2.putString("data", string);
            bundle2.putString("msgId", string4);
            bundle2.putString("message_type", string3);
            JsonUtil.transferJsonObjectToBundle(b11, bundle2, f38353f);
            bundle2.putBundle(RemoteMessageConst.NOTIFICATION, a(b11, a11, d11, b12, c11));
            return bundle2;
        }
        bundle2.putString("data", a.a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
        return bundle2;
    }

    private static JSONObject b(Bundle bundle) {
        try {
            return new JSONObject(a.a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
        } catch (JSONException unused) {
            HMSLog.w("RemoteMessage", "JSONException:parse message body failed.");
            return null;
        }
    }

    private static JSONObject c(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PARAM);
        }
        return null;
    }

    private static JSONObject d(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
        }
        return null;
    }

    public final int describeContents() {
        return 0;
    }

    public String getAnalyticInfo() {
        return this.f38358a.getString(RemoteMessageConst.ANALYTIC_INFO);
    }

    public Map<String, String> getAnalyticInfoMap() {
        HashMap hashMap = new HashMap();
        String string = this.f38358a.getString(RemoteMessageConst.ANALYTIC_INFO);
        if (string != null && !string.trim().isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    hashMap.put(valueOf, String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (JSONException unused) {
                HMSLog.w("RemoteMessage", "JSONException: get analyticInfo from map failed.");
            }
        }
        return hashMap;
    }

    public String getCollapseKey() {
        return this.f38358a.getString(RemoteMessageConst.COLLAPSE_KEY);
    }

    public String getData() {
        return this.f38358a.getString("data");
    }

    public Map<String, String> getDataOfMap() {
        HashMap hashMap = new HashMap();
        String string = this.f38358a.getString("data");
        if (string != null && !string.trim().isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    hashMap.put(valueOf, String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (JSONException unused) {
                HMSLog.w("RemoteMessage", "JSONException: get data from map failed");
            }
        }
        return hashMap;
    }

    public String getFrom() {
        return this.f38358a.getString("from");
    }

    public String getMessageId() {
        return this.f38358a.getString("msgId");
    }

    public String getMessageType() {
        return this.f38358a.getString("message_type");
    }

    public Notification getNotification() {
        Bundle bundle = this.f38358a.getBundle(RemoteMessageConst.NOTIFICATION);
        if (this.f38359b == null && bundle != null) {
            this.f38359b = new Notification(bundle, (a) null);
        }
        if (this.f38359b == null) {
            this.f38359b = new Notification(new Bundle(), (a) null);
        }
        return this.f38359b;
    }

    public int getOriginalUrgency() {
        int i11 = this.f38358a.getInt(RemoteMessageConst.ORI_URGENCY);
        if (i11 == 1 || i11 == 2) {
            return i11;
        }
        return 0;
    }

    public int getReceiptMode() {
        return this.f38358a.getInt(RemoteMessageConst.RECEIPT_MODE);
    }

    public int getSendMode() {
        return this.f38358a.getInt(RemoteMessageConst.SEND_MODE);
    }

    public long getSentTime() {
        try {
            String string = this.f38358a.getString(RemoteMessageConst.SEND_TIME);
            if (!TextUtils.isEmpty(string)) {
                return Long.parseLong(string);
            }
            return 0;
        } catch (NumberFormatException unused) {
            HMSLog.w("RemoteMessage", "NumberFormatException: get sendTime error.");
            return 0;
        }
    }

    public String getTo() {
        return this.f38358a.getString("to");
    }

    public String getToken() {
        return this.f38358a.getString(RemoteMessageConst.DEVICE_TOKEN);
    }

    public int getTtl() {
        return this.f38358a.getInt("ttl");
    }

    public int getUrgency() {
        int i11 = this.f38358a.getInt(RemoteMessageConst.URGENCY);
        if (i11 == 1 || i11 == 2) {
            return i11;
        }
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeBundle(this.f38358a);
        parcel.writeSerializable(this.f38359b);
    }

    public RemoteMessage(Parcel parcel) {
        this.f38358a = parcel.readBundle();
        this.f38359b = (Notification) parcel.readSerializable();
    }

    private static JSONObject b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
        }
        return null;
    }

    private Bundle a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        Bundle bundle = new Bundle();
        JsonUtil.transferJsonObjectToBundle(jSONObject3, bundle, f38354g);
        JsonUtil.transferJsonObjectToBundle(jSONObject4, bundle, f38355h);
        JsonUtil.transferJsonObjectToBundle(jSONObject, bundle, f38356i);
        JsonUtil.transferJsonObjectToBundle(jSONObject5, bundle, f38357j);
        bundle.putInt(RemoteMessageConst.Notification.NOTIFY_ID, JsonUtil.getInt(jSONObject2, RemoteMessageConst.Notification.NOTIFY_ID, 0));
        return bundle;
    }

    private static JSONObject a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
        }
        return null;
    }
}
