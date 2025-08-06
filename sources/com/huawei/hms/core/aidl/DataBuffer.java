package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class DataBuffer implements Parcelable {
    public static final Parcelable.Creator<DataBuffer> CREATOR = new a();
    public String URI;

    /* renamed from: a  reason: collision with root package name */
    private int f37962a;

    /* renamed from: b  reason: collision with root package name */
    private Bundle f37963b;
    public Bundle header;

    public class a implements Parcelable.Creator<DataBuffer> {
        /* renamed from: a */
        public DataBuffer createFromParcel(Parcel parcel) {
            return new DataBuffer(parcel, (a) null);
        }

        /* renamed from: a */
        public DataBuffer[] newArray(int i11) {
            return new DataBuffer[i11];
        }
    }

    public /* synthetic */ DataBuffer(Parcel parcel, a aVar) {
        this(parcel);
    }

    private static ClassLoader a(Class cls) {
        return cls.getClassLoader();
    }

    public DataBuffer addBody(Bundle bundle) {
        this.f37963b = bundle;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public Bundle getBody() {
        return this.f37963b;
    }

    public int getBodySize() {
        return this.f37963b == null ? 0 : 1;
    }

    public int getProtocol() {
        return this.f37962a;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        if (parcel != null) {
            parcel.writeInt(this.f37962a);
            parcel.writeString(this.URI);
            parcel.writeBundle(this.header);
            parcel.writeBundle(this.f37963b);
        }
    }

    private DataBuffer(Parcel parcel) {
        this.header = null;
        this.f37962a = 1;
        this.f37963b = null;
        a(parcel);
    }

    private void a(Parcel parcel) {
        this.f37962a = parcel.readInt();
        this.URI = parcel.readString();
        this.header = parcel.readBundle(a(Bundle.class));
        this.f37963b = parcel.readBundle(a(Bundle.class));
    }

    public DataBuffer() {
        this.header = null;
        this.f37962a = 1;
        this.f37963b = null;
    }

    public DataBuffer(String str) {
        this.header = null;
        this.f37962a = 1;
        this.f37963b = null;
        this.URI = str;
    }

    public DataBuffer(String str, int i11) {
        this.header = null;
        this.f37963b = null;
        this.URI = str;
        this.f37962a = i11;
    }
}
