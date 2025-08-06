package com.engagelab.privates.push.api;

import android.os.Parcel;
import android.os.Parcelable;

public class PlatformTokenMessage implements Parcelable {
    public static final Parcelable.Creator<PlatformTokenMessage> CREATOR = new a();
    private byte platform;
    private String region = "NULL";
    private String token;

    public static class a implements Parcelable.Creator<PlatformTokenMessage> {
        /* renamed from: a */
        public PlatformTokenMessage createFromParcel(Parcel parcel) {
            return new PlatformTokenMessage(parcel);
        }

        /* renamed from: a */
        public PlatformTokenMessage[] newArray(int i11) {
            return new PlatformTokenMessage[i11];
        }
    }

    public PlatformTokenMessage() {
    }

    public int describeContents() {
        return 0;
    }

    public byte getPlatform() {
        return this.platform;
    }

    public String getRegion() {
        return this.region;
    }

    public String getToken() {
        return this.token;
    }

    public PlatformTokenMessage setPlatform(byte b11) {
        this.platform = b11;
        return this;
    }

    public PlatformTokenMessage setRegion(String str) {
        this.region = str;
        return this;
    }

    public PlatformTokenMessage setToken(String str) {
        this.token = str;
        return this;
    }

    public String toString() {
        return "\n{\n  platform=" + this.platform + ",\n  token=" + this.token + "\n  region=" + this.region + "\n}";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeByte(this.platform);
        parcel.writeString(this.token);
        parcel.writeString(this.region);
    }

    public PlatformTokenMessage(Parcel parcel) {
        this.platform = parcel.readByte();
        this.token = parcel.readString();
        this.region = parcel.readString();
    }
}
