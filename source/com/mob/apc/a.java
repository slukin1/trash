package com.mob.apc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f26847a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f26848b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f26849c = -1;

    /* renamed from: d  reason: collision with root package name */
    public Object f26850d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f26851e;

    /* renamed from: f  reason: collision with root package name */
    public int f26852f = -1;

    public void a(Parcel parcel, int i11) {
        parcel.writeInt(this.f26847a);
        parcel.writeInt(this.f26848b);
        parcel.writeInt(this.f26849c);
        Object obj = this.f26850d;
        if (obj != null) {
            if (obj instanceof Serializable) {
                parcel.writeInt(2);
                parcel.writeSerializable((Serializable) this.f26850d);
            } else if (obj instanceof Parcelable) {
                parcel.writeInt(3);
                parcel.writeParcelable((Parcelable) this.f26850d, i11);
            }
        }
        if (this.f26851e == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeBundle(this.f26851e);
    }

    public String toString() {
        return "APCMessage{what=" + this.f26847a + ", arg1=" + this.f26848b + ", arg2=" + this.f26849c + ", obj=" + this.f26850d + ", data=" + this.f26851e + '}';
    }

    public a a(Parcel parcel) {
        this.f26847a = parcel.readInt();
        this.f26848b = parcel.readInt();
        this.f26849c = parcel.readInt();
        int readInt = parcel.readInt();
        if (readInt == 2) {
            this.f26850d = parcel.readSerializable();
            readInt = parcel.readInt();
        } else if (readInt == 3) {
            this.f26850d = parcel.readParcelable(getClass().getClassLoader());
            readInt = parcel.readInt();
        }
        if (readInt == 1) {
            this.f26851e = parcel.readBundle();
        }
        return this;
    }
}
