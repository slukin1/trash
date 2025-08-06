package com.tencent.tpns.mqttchannel.core.common.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.tpns.baseapi.base.util.Md5;
import com.tencent.tpns.mqttchannel.core.common.a.a;
import com.tencent.tpns.mqttchannel.core.common.a.b;
import org.json.JSONObject;

public class Request implements Parcelable {
    public static final Parcelable.Creator<Request> CREATOR = new Parcelable.Creator<Request>() {
        /* renamed from: a */
        public Request createFromParcel(Parcel parcel) {
            return new Request(parcel);
        }

        /* renamed from: a */
        public Request[] newArray(int i11) {
            return new Request[i11];
        }
    };
    public static final int TYPE_EXPAND = 4;
    public static final int TYPE_PUBLISH = 2;
    public static final int TYPE_SEND_PUBLISH_DATA = 5;
    public static final int TYPE_SEND_REQUST = 6;
    public static final int TYPE_SUBSCRIBE = 1;
    public static final int TYPE_UNSUBSCRIBE = 3;

    /* renamed from: a  reason: collision with root package name */
    private long f49968a;

    /* renamed from: b  reason: collision with root package name */
    private String f49969b;

    /* renamed from: c  reason: collision with root package name */
    private String f49970c;

    /* renamed from: d  reason: collision with root package name */
    private String f49971d = "";

    /* renamed from: e  reason: collision with root package name */
    private int f49972e = 0;
    public volatile boolean isSent = false;
    public int type;

    public Request(Parcel parcel) {
        this.f49968a = parcel.readLong();
        this.f49969b = parcel.readString();
        this.f49970c = parcel.readString();
    }

    public void addRetryCount() {
        this.f49972e++;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Request request = (Request) obj;
        if (this.type == request.type && this.f49968a == request.f49968a) {
            return true;
        }
        return false;
    }

    public String getContent() {
        return this.f49970c;
    }

    public long getId() {
        return this.f49968a;
    }

    public String getParamsMd5() {
        return this.f49971d;
    }

    public int getRetryCount() {
        return this.f49972e;
    }

    public String getTopic() {
        return this.f49969b;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void setContent(String str) {
        this.f49970c = str;
    }

    public void setId(long j11) {
        this.f49968a = j11;
    }

    public void setToken(String str) {
        if (!b.a(str)) {
            try {
                if (!b.a(this.f49970c)) {
                    JSONObject jSONObject = new JSONObject(this.f49970c);
                    a.b("Request", "Update token to: " + str);
                    jSONObject.put("token", str);
                    String jSONObject2 = jSONObject.toString();
                    this.f49970c = jSONObject2;
                    this.f49971d = Md5.md5(jSONObject2);
                    return;
                }
                a.d("Request", "request content null");
            } catch (Throwable th2) {
                a.a("Request", "setCurrentToken", th2);
            }
        }
    }

    public void setTopic(String str) {
        this.f49969b = str;
    }

    public String toString() {
        return "Request{type=" + this.type + ", id=" + this.f49968a + ", topic='" + this.f49969b + '\'' + ", content='" + this.f49970c + '\'' + ", retryCount=" + this.f49972e + '}';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.f49968a);
        parcel.writeString(this.f49969b);
        parcel.writeString(this.f49970c);
    }

    public Request(long j11, String str, String str2) {
        this.f49968a = j11;
        this.f49969b = str;
        this.f49970c = str2;
    }
}
