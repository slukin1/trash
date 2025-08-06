package com.engagelab.privates.push.api;

import android.os.Parcel;
import android.os.Parcelable;

public class AliasMessage implements Parcelable {
    public static final Parcelable.Creator<AliasMessage> CREATOR = new a();
    private String alias = "";
    private int code = -1;
    private int sequence = 0;

    public static class a implements Parcelable.Creator<AliasMessage> {
        /* renamed from: a */
        public AliasMessage createFromParcel(Parcel parcel) {
            return new AliasMessage(parcel);
        }

        /* renamed from: a */
        public AliasMessage[] newArray(int i11) {
            return new AliasMessage[i11];
        }
    }

    public AliasMessage() {
    }

    public int describeContents() {
        return 0;
    }

    public String getAlias() {
        return this.alias;
    }

    public int getCode() {
        return this.code;
    }

    public int getSequence() {
        return this.sequence;
    }

    public AliasMessage setAlias(String str) {
        this.alias = str;
        return this;
    }

    public AliasMessage setCode(int i11) {
        this.code = i11;
        return this;
    }

    public AliasMessage setSequence(int i11) {
        this.sequence = i11;
        return this;
    }

    public String toString() {
        return "\n{\n  sequence=" + this.sequence + ",\n  code=" + this.code + ",\n  alias=" + this.alias + "\n}";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.sequence);
        parcel.writeInt(this.code);
        parcel.writeString(this.alias);
    }

    public AliasMessage(Parcel parcel) {
        this.sequence = parcel.readInt();
        this.code = parcel.readInt();
        this.alias = parcel.readString();
    }
}
