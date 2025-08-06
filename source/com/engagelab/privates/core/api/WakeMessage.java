package com.engagelab.privates.core.api;

import android.os.Parcel;
import android.os.Parcelable;

public class WakeMessage implements Parcelable {
    public static final int ACTIVITY = 8;
    public static final int BIND_SERVICE = 2;
    public static final int CONTENT_PROVIDER = 4;
    public static final Parcelable.Creator<WakeMessage> CREATOR = new a();
    public static final int START_SERVICE = 1;
    private String packageName;
    private int type;

    public static class a implements Parcelable.Creator<WakeMessage> {
        /* renamed from: a */
        public WakeMessage createFromParcel(Parcel parcel) {
            return new WakeMessage(parcel);
        }

        /* renamed from: a */
        public WakeMessage[] newArray(int i11) {
            return new WakeMessage[i11];
        }
    }

    public WakeMessage() {
    }

    public int describeContents() {
        return 0;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getType() {
        return this.type;
    }

    public WakeMessage setPackageName(String str) {
        this.packageName = str;
        return this;
    }

    public WakeMessage setType(int i11) {
        this.type = i11;
        return this;
    }

    public String toString() {
        return "\n{\n  type=" + this.type + ",\n  packageName=" + this.packageName + "\n}";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.type);
        parcel.writeString(this.packageName);
    }

    public WakeMessage(Parcel parcel) {
        this.type = parcel.readInt();
        this.packageName = parcel.readString();
    }
}
