package com.engagelab.privates.core.api;

import android.os.Parcel;
import android.os.Parcelable;

public class MTProtocol implements Parcelable {
    public static final Parcelable.Creator<MTProtocol> CREATOR = new a();
    private byte[] body;
    private int command;
    private long rid = 0;
    private String threadName;
    private int version;

    public static class a implements Parcelable.Creator<MTProtocol> {
        /* renamed from: a */
        public MTProtocol createFromParcel(Parcel parcel) {
            return new MTProtocol(parcel);
        }

        /* renamed from: a */
        public MTProtocol[] newArray(int i11) {
            return new MTProtocol[i11];
        }
    }

    public MTProtocol() {
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getBody() {
        return this.body;
    }

    public int getCommand() {
        return this.command;
    }

    public long getRid() {
        return this.rid;
    }

    public String getThreadName() {
        return this.threadName;
    }

    public int getVersion() {
        return this.version;
    }

    public MTProtocol setBody(byte[] bArr) {
        this.body = bArr;
        return this;
    }

    public MTProtocol setCommand(int i11) {
        this.command = i11;
        return this;
    }

    public MTProtocol setRid(long j11) {
        this.rid = j11;
        return this;
    }

    public MTProtocol setThreadName(String str) {
        this.threadName = str;
        return this;
    }

    public MTProtocol setVersion(int i11) {
        this.version = i11;
        return this;
    }

    public String toString() {
        return "\n{\n  rid=" + this.rid + ",\n  command=" + this.command + ",\n  version=" + this.version + ",\n  body=" + this.body + ",\n  threadName=" + this.threadName + "\n}";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.rid);
        parcel.writeInt(this.command);
        parcel.writeInt(this.version);
        parcel.writeByteArray(this.body);
        parcel.writeString(this.threadName);
    }

    public MTProtocol(Parcel parcel) {
        this.rid = (long) parcel.readInt();
        this.command = parcel.readInt();
        this.version = parcel.readInt();
        this.body = parcel.createByteArray();
        this.threadName = parcel.readString();
    }
}
