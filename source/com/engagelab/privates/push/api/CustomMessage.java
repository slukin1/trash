package com.engagelab.privates.push.api;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.engagelab.privates.common.log.MTCommonLog;

public class CustomMessage implements Parcelable {
    public static final Parcelable.Creator<CustomMessage> CREATOR = new a();
    private String content = null;
    private String contentType = null;
    private Bundle extras = null;
    private String messageId = null;
    private byte platform = 0;
    private String platformMessageId = null;
    private String title = null;

    public static class a implements Parcelable.Creator<CustomMessage> {
        /* renamed from: a */
        public CustomMessage createFromParcel(Parcel parcel) {
            return new CustomMessage(parcel);
        }

        /* renamed from: a */
        public CustomMessage[] newArray(int i11) {
            return new CustomMessage[i11];
        }
    }

    public CustomMessage() {
    }

    public int describeContents() {
        return 0;
    }

    public String getContent() {
        return this.content;
    }

    public String getContentType() {
        return this.contentType;
    }

    public Bundle getExtras() {
        return this.extras;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public byte getPlatform() {
        return this.platform;
    }

    public String getPlatformMessageId() {
        return this.platformMessageId;
    }

    public String getTitle() {
        return this.title;
    }

    public CustomMessage setContent(String str) {
        this.content = str;
        return this;
    }

    public CustomMessage setContentType(String str) {
        this.contentType = str;
        return this;
    }

    public CustomMessage setExtras(Bundle bundle) {
        this.extras = bundle;
        return this;
    }

    public CustomMessage setMessageId(String str) {
        this.messageId = str;
        return this;
    }

    public CustomMessage setPlatform(byte b11) {
        this.platform = b11;
        return this;
    }

    public CustomMessage setPlatformMessageId(String str) {
        this.platformMessageId = str;
        return this;
    }

    public CustomMessage setTitle(String str) {
        this.title = str;
        return this;
    }

    public String toString() {
        return "\n{\n  messageId=" + this.messageId + ",\n  platform=" + this.platform + ",\n  platformMessageId=" + this.platformMessageId + ",\n  title=" + this.title + ",\n  content=" + this.content + ",\n  contentType=" + this.contentType + ",\n  extras=" + MTCommonLog.toLogString(this.extras) + "\n}";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.messageId);
        parcel.writeByte(this.platform);
        parcel.writeString(this.platformMessageId);
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeString(this.contentType);
        parcel.writeBundle(this.extras);
    }

    public CustomMessage(Parcel parcel) {
        this.messageId = parcel.readString();
        this.platform = parcel.readByte();
        this.platformMessageId = parcel.readString();
        this.title = parcel.readString();
        this.content = parcel.readString();
        this.contentType = parcel.readString();
        this.extras = parcel.readBundle();
    }
}
