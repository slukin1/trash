package com.mob.apc.a;

import android.os.Parcel;
import com.mob.apc.APCException;
import com.mob.apc.a;
import com.mob.apc.b;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public a f26878a;

    /* renamed from: b  reason: collision with root package name */
    public String f26879b;

    /* renamed from: c  reason: collision with root package name */
    public String f26880c;

    /* renamed from: d  reason: collision with root package name */
    public APCException f26881d = null;

    /* renamed from: e  reason: collision with root package name */
    public long f26882e = -1;

    public e(a aVar, String str, long j11) {
        this.f26878a = aVar;
        this.f26879b = str;
        this.f26880c = b.a().getPackageName();
        this.f26882e = j11;
    }

    public void a(Parcel parcel, int i11) {
        parcel.writeLong(this.f26882e);
        if (this.f26878a != null) {
            parcel.writeInt(1);
            this.f26878a.a(parcel, i11);
        }
        if (this.f26879b != null) {
            parcel.writeInt(2);
            parcel.writeString(this.f26879b);
        }
        this.f26880c = b.a().getPackageName();
        parcel.writeInt(3);
        parcel.writeString(this.f26880c);
    }

    public String toString() {
        return "InnerMessage{apcMessage=" + this.f26878a + ", businessID='" + this.f26879b + '\'' + ", pkg='" + this.f26880c + '\'' + '}';
    }

    public static e a(Parcel parcel) {
        e eVar = new e((a) null, (String) null, parcel.readLong());
        int readInt = parcel.readInt();
        if (readInt == 1) {
            eVar.f26878a = new a().a(parcel);
            readInt = parcel.readInt();
        }
        if (readInt == 2) {
            eVar.f26879b = parcel.readString();
            readInt = parcel.readInt();
        }
        if (readInt == 3) {
            eVar.f26880c = parcel.readString();
        }
        return eVar;
    }
}
