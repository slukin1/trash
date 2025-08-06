package com.tencent.android.tpush;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

public class XGPushTextMessage implements Parcelable {
    public static final Parcelable.Creator<XGPushTextMessage> CREATOR = new Parcelable.Creator<XGPushTextMessage>() {
        /* renamed from: a */
        public XGPushTextMessage createFromParcel(Parcel parcel) {
            return new XGPushTextMessage(parcel);
        }

        /* renamed from: a */
        public XGPushTextMessage[] newArray(int i11) {
            return new XGPushTextMessage[i11];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public long f68080a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f68081b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f68082c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f68083d = "";

    /* renamed from: e  reason: collision with root package name */
    public int f68084e = 100;

    /* renamed from: f  reason: collision with root package name */
    public String f68085f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f68086g = "";

    /* renamed from: h  reason: collision with root package name */
    private Intent f68087h = null;

    public XGPushTextMessage() {
    }

    public void a(Intent intent) {
        this.f68087h = intent;
        if (intent != null) {
            intent.removeExtra("content");
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getContent() {
        return this.f68082c;
    }

    public String getCustomContent() {
        return this.f68083d;
    }

    public long getMsgId() {
        return this.f68080a;
    }

    public int getPushChannel() {
        return this.f68084e;
    }

    public String getTemplateId() {
        return this.f68085f;
    }

    public String getTitle() {
        return this.f68081b;
    }

    public String getTraceId() {
        return this.f68086g;
    }

    public String toString() {
        return "XGPushTextMessage [msgId = " + this.f68080a + ", title=" + this.f68081b + ", content=" + this.f68082c + ", customContent=" + this.f68083d + ", pushChannel = " + this.f68084e + ", templateId = " + this.f68085f + ", traceId = " + this.f68086g + "]";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.f68080a);
        parcel.writeString(this.f68081b);
        parcel.writeString(this.f68082c);
        parcel.writeString(this.f68083d);
        parcel.writeInt(this.f68084e);
        parcel.writeParcelable(this.f68087h, 1);
        parcel.writeString(this.f68085f);
        parcel.writeString(this.f68086g);
    }

    public Intent a() {
        return this.f68087h;
    }

    public XGPushTextMessage(Parcel parcel) {
        this.f68080a = parcel.readLong();
        this.f68081b = parcel.readString();
        this.f68082c = parcel.readString();
        this.f68083d = parcel.readString();
        this.f68084e = parcel.readInt();
        this.f68087h = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f68085f = parcel.readString();
        this.f68086g = parcel.readString();
    }
}
