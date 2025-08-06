package com.tencent.android.tpush.data;

import android.os.Parcel;
import android.os.Parcelable;

public class StorageEntity implements Parcelable {
    public static final Parcelable.Creator<StorageEntity> CREATOR = new Parcelable.Creator<StorageEntity>() {
        /* renamed from: a */
        public StorageEntity createFromParcel(Parcel parcel) {
            return new StorageEntity(parcel);
        }

        /* renamed from: a */
        public StorageEntity[] newArray(int i11) {
            return new StorageEntity[i11];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f69317a = "";

    /* renamed from: b  reason: collision with root package name */
    public int f69318b = -1;

    /* renamed from: c  reason: collision with root package name */
    public boolean f69319c;

    /* renamed from: d  reason: collision with root package name */
    public String f69320d;

    /* renamed from: e  reason: collision with root package name */
    public int f69321e;

    /* renamed from: f  reason: collision with root package name */
    public float f69322f;

    /* renamed from: g  reason: collision with root package name */
    public long f69323g;

    public StorageEntity() {
    }

    private void a(Parcel parcel) {
        this.f69317a = parcel.readString();
        this.f69318b = parcel.readInt();
        boolean z11 = true;
        if (parcel.readByte() != 1) {
            z11 = false;
        }
        this.f69319c = z11;
        this.f69320d = parcel.readString();
        this.f69321e = parcel.readInt();
        this.f69322f = parcel.readFloat();
        this.f69323g = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "StorageEntity[key:" + this.f69317a + ",type:" + this.f69318b + ",strValue:" + this.f69320d + ",boolValue:" + this.f69319c + ",intValue" + this.f69321e + ",floatValue:" + this.f69322f + ",longValue:" + this.f69323g + "]";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f69317a);
        parcel.writeInt(this.f69318b);
        parcel.writeByte(this.f69319c ? (byte) 1 : 0);
        parcel.writeString(this.f69320d);
        parcel.writeInt(this.f69321e);
        parcel.writeFloat(this.f69322f);
        parcel.writeLong(this.f69323g);
    }

    public StorageEntity(Parcel parcel) {
        a(parcel);
    }
}
