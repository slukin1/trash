package com.engagelab.privates.push.api;

import android.os.Parcel;
import android.os.Parcelable;

public class MobileNumberMessage implements Parcelable {
    public static final Parcelable.Creator<MobileNumberMessage> CREATOR = new a();
    private int code = -1;
    private String mobileNumber = "";
    private int sequence = 0;

    public static class a implements Parcelable.Creator<MobileNumberMessage> {
        /* renamed from: a */
        public MobileNumberMessage createFromParcel(Parcel parcel) {
            return new MobileNumberMessage(parcel);
        }

        /* renamed from: a */
        public MobileNumberMessage[] newArray(int i11) {
            return new MobileNumberMessage[i11];
        }
    }

    public MobileNumberMessage() {
    }

    public int describeContents() {
        return 0;
    }

    public int getCode() {
        return this.code;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public int getSequence() {
        return this.sequence;
    }

    public MobileNumberMessage setCode(int i11) {
        this.code = i11;
        return this;
    }

    public MobileNumberMessage setMobileNumber(String str) {
        this.mobileNumber = str;
        return this;
    }

    public MobileNumberMessage setSequence(int i11) {
        this.sequence = i11;
        return this;
    }

    public String toString() {
        return "\n{\n  sequence=" + this.sequence + ",\n  code=" + this.code + ",\n  mobileNumber=" + this.mobileNumber + "\n}";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.sequence);
        parcel.writeInt(this.code);
        parcel.writeString(this.mobileNumber);
    }

    public MobileNumberMessage(Parcel parcel) {
        this.sequence = parcel.readInt();
        this.code = parcel.readInt();
        this.mobileNumber = parcel.readString();
    }
}
