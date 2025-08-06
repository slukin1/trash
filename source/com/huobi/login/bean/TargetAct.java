package com.huobi.login.bean;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class TargetAct implements kn.a, Parcelable {
    public static final Parcelable.Creator<TargetAct> CREATOR = new a();
    private boolean allTrader;
    private Bundle bundle;
    private Class targetClass;

    public class a implements Parcelable.Creator<TargetAct> {
        /* renamed from: a */
        public TargetAct createFromParcel(Parcel parcel) {
            return new TargetAct(parcel);
        }

        /* renamed from: b */
        public TargetAct[] newArray(int i11) {
            return new TargetAct[i11];
        }
    }

    public TargetAct(Class cls, Bundle bundle2, boolean z11) {
        this.targetClass = cls;
        this.bundle = bundle2;
        this.allTrader = z11;
    }

    public boolean allowTrader() {
        return this.allTrader;
    }

    public int describeContents() {
        return 0;
    }

    public void show(Context context) {
        if (this.bundle == null) {
            context.startActivity(new Intent(context, this.targetClass));
        } else {
            context.startActivity(new Intent(context, this.targetClass).putExtras(this.bundle));
        }
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeBundle(this.bundle);
        parcel.writeSerializable(this.targetClass);
        parcel.writeInt(this.allTrader ? 1 : 0);
    }

    public TargetAct(Parcel parcel) {
        this.bundle = parcel.readBundle();
        this.targetClass = (Class) parcel.readSerializable();
        this.allTrader = parcel.readInt() > 0;
    }
}
