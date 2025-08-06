package com.engagelab.privates.push.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public class TagMessage implements Parcelable {
    public static final Parcelable.Creator<TagMessage> CREATOR = new a();
    private int code = -1;
    private String queryTag = "";
    private boolean queryTagValid = false;
    private int sequence = 0;
    private String[] tags = new String[0];

    public static class a implements Parcelable.Creator<TagMessage> {
        /* renamed from: a */
        public TagMessage createFromParcel(Parcel parcel) {
            return new TagMessage(parcel);
        }

        /* renamed from: a */
        public TagMessage[] newArray(int i11) {
            return new TagMessage[i11];
        }
    }

    public TagMessage() {
    }

    public static Parcelable.Creator<TagMessage> getCREATOR() {
        return CREATOR;
    }

    public int describeContents() {
        return 0;
    }

    public int getCode() {
        return this.code;
    }

    public String getQueryTag() {
        return this.queryTag;
    }

    public int getSequence() {
        return this.sequence;
    }

    public String[] getTags() {
        return this.tags;
    }

    public boolean isQueryTagValid() {
        return this.queryTagValid;
    }

    public TagMessage setCode(int i11) {
        this.code = i11;
        return this;
    }

    public TagMessage setQueryTag(String str) {
        this.queryTag = str;
        return this;
    }

    public TagMessage setQueryTagValid(boolean z11) {
        this.queryTagValid = z11;
        return this;
    }

    public TagMessage setSequence(int i11) {
        this.sequence = i11;
        return this;
    }

    public TagMessage setTags(String[] strArr) {
        this.tags = strArr;
        return this;
    }

    public String toString() {
        return "\n{\n  sequence=" + this.sequence + ",\n  code=" + this.code + ",\n  tag=" + Arrays.toString(this.tags) + ",\n  queryTag=" + this.queryTag + ",\n  queryTagValid=" + this.queryTagValid + "\n}";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.sequence);
        parcel.writeInt(this.code);
        parcel.writeStringArray(this.tags);
        parcel.writeString(this.queryTag);
        parcel.writeByte(this.queryTagValid ? (byte) 1 : 0);
    }

    public TagMessage(Parcel parcel) {
        boolean z11 = false;
        this.sequence = parcel.readInt();
        this.code = parcel.readInt();
        this.tags = parcel.createStringArray();
        this.queryTag = parcel.readString();
        this.queryTagValid = parcel.readByte() != 0 ? true : z11;
    }
}
