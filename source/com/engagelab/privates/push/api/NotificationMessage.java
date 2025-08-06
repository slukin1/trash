package com.engagelab.privates.push.api;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.engagelab.privates.common.log.MTCommonLog;
import java.util.Arrays;

public class NotificationMessage implements Parcelable {
    public static final Parcelable.Creator<NotificationMessage> CREATOR = new a();
    public static final int NOTIFICATION_STYLE_BIG_PICTURE = 3;
    public static final int NOTIFICATION_STYLE_BIG_TEXT = 1;
    public static final int NOTIFICATION_STYLE_INBOX = 2;
    private int badge = 0;
    private String bigPicture = "";
    private String bigText = "";
    private int builderId;
    private String category;
    private String channelId = "";
    private String content = "";
    private int defaults = -1;
    private Bundle extras = null;
    private String[] inbox = null;
    private String intentSsl = "";
    private String intentUri = "";
    private String largeIcon = "";
    private String messageId = "";
    private int notificationId = 0;
    private String overrideMessageId = "";
    private byte platform = 0;
    private String platformMessageId = "";
    private int priority = 0;
    private String smallIcon = "";
    private String sound = "";
    private int style = 0;
    private String title = "";

    public static class a implements Parcelable.Creator<NotificationMessage> {
        /* renamed from: a */
        public NotificationMessage createFromParcel(Parcel parcel) {
            return new NotificationMessage(parcel);
        }

        /* renamed from: a */
        public NotificationMessage[] newArray(int i11) {
            return new NotificationMessage[i11];
        }
    }

    public NotificationMessage() {
    }

    public int describeContents() {
        return 0;
    }

    public int getBadge() {
        return this.badge;
    }

    public String getBigPicture() {
        return this.bigPicture;
    }

    public String getBigText() {
        return this.bigText;
    }

    public int getBuilderId() {
        return this.builderId;
    }

    public String getCategory() {
        return this.category;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getContent() {
        return this.content;
    }

    public int getDefaults() {
        return this.defaults;
    }

    public Bundle getExtras() {
        return this.extras;
    }

    public String[] getInbox() {
        return this.inbox;
    }

    public String getIntentSsl() {
        return this.intentSsl;
    }

    public String getIntentUri() {
        return this.intentUri;
    }

    public String getLargeIcon() {
        return this.largeIcon;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getNotificationId() {
        return this.notificationId;
    }

    public String getOverrideMessageId() {
        return this.overrideMessageId;
    }

    public byte getPlatform() {
        return this.platform;
    }

    public String getPlatformMessageId() {
        return this.platformMessageId;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getSmallIcon() {
        return this.smallIcon;
    }

    public String getSound() {
        return this.sound;
    }

    public int getStyle() {
        return this.style;
    }

    public String getTitle() {
        return this.title;
    }

    public NotificationMessage setBadge(int i11) {
        this.badge = i11;
        return this;
    }

    public NotificationMessage setBigPicture(String str) {
        this.bigPicture = str;
        return this;
    }

    public NotificationMessage setBigText(String str) {
        this.bigText = str;
        return this;
    }

    public NotificationMessage setBuilderId(int i11) {
        this.builderId = i11;
        return this;
    }

    public NotificationMessage setCategory(String str) {
        this.category = str;
        return this;
    }

    public NotificationMessage setChannelId(String str) {
        this.channelId = str;
        return this;
    }

    public NotificationMessage setContent(String str) {
        this.content = str;
        return this;
    }

    public NotificationMessage setDefaults(int i11) {
        this.defaults = i11;
        return this;
    }

    public NotificationMessage setExtras(Bundle bundle) {
        this.extras = bundle;
        return this;
    }

    public NotificationMessage setInbox(String[] strArr) {
        this.inbox = strArr;
        return this;
    }

    public NotificationMessage setIntentSsl(String str) {
        this.intentSsl = str;
        return this;
    }

    public NotificationMessage setIntentUri(String str) {
        this.intentUri = str;
        return this;
    }

    public NotificationMessage setLargeIcon(String str) {
        this.largeIcon = str;
        return this;
    }

    public NotificationMessage setMessageId(String str) {
        this.messageId = str;
        return this;
    }

    public NotificationMessage setNotificationId(int i11) {
        this.notificationId = i11;
        return this;
    }

    public NotificationMessage setOverrideMessageId(String str) {
        this.overrideMessageId = str;
        return this;
    }

    public NotificationMessage setPlatform(byte b11) {
        this.platform = b11;
        return this;
    }

    public NotificationMessage setPlatformMessageId(String str) {
        this.platformMessageId = str;
        return this;
    }

    public NotificationMessage setPriority(int i11) {
        this.priority = i11;
        return this;
    }

    public NotificationMessage setSmallIcon(String str) {
        this.smallIcon = str;
        return this;
    }

    public NotificationMessage setSound(String str) {
        this.sound = str;
        return this;
    }

    public NotificationMessage setStyle(int i11) {
        this.style = i11;
        return this;
    }

    public NotificationMessage setTitle(String str) {
        this.title = str;
        return this;
    }

    public String toString() {
        return "\n{\n  messageId=" + this.messageId + ",\n  overrideMessageId=" + this.overrideMessageId + ",\n  platform=" + this.platform + ",\n  platformMessageId='" + this.platformMessageId + ",\n  notificationId=" + this.notificationId + ",\n  smallIcon=" + this.smallIcon + ",\n  largeIcon=" + this.largeIcon + ",\n  title=" + this.title + ",\n  content=" + this.content + ",\n  extras=" + MTCommonLog.toLogString(this.extras) + ",\n  layoutId=" + this.builderId + ",\n  style=" + this.style + ",\n  bigText=" + this.bigText + ",\n  inbox=" + Arrays.toString(this.inbox) + ",\n  bigPicture=" + this.bigPicture + ",\n  priority=" + this.priority + ",\n  defaults=" + this.defaults + ",\n  category=" + this.category + ",\n  sound=" + this.sound + ",\n  channelId=" + this.channelId + ",\n  intentUri=" + this.intentUri + ",\n  badge=" + this.badge + ",\n}";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.messageId);
        parcel.writeString(this.overrideMessageId);
        parcel.writeByte(this.platform);
        parcel.writeString(this.platformMessageId);
        parcel.writeInt(this.notificationId);
        parcel.writeString(this.smallIcon);
        parcel.writeString(this.largeIcon);
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeBundle(this.extras);
        parcel.writeInt(this.builderId);
        parcel.writeInt(this.style);
        parcel.writeString(this.bigText);
        parcel.writeStringArray(this.inbox);
        parcel.writeString(this.bigPicture);
        parcel.writeInt(this.priority);
        parcel.writeInt(this.defaults);
        parcel.writeString(this.category);
        parcel.writeString(this.sound);
        parcel.writeString(this.channelId);
        parcel.writeString(this.intentUri);
        parcel.writeInt(this.badge);
    }

    public NotificationMessage(Parcel parcel) {
        this.messageId = parcel.readString();
        this.overrideMessageId = parcel.readString();
        this.platform = parcel.readByte();
        this.platformMessageId = parcel.readString();
        this.notificationId = parcel.readInt();
        this.smallIcon = parcel.readString();
        this.largeIcon = parcel.readString();
        this.title = parcel.readString();
        this.content = parcel.readString();
        this.extras = parcel.readBundle();
        this.builderId = parcel.readInt();
        this.style = parcel.readInt();
        this.bigText = parcel.readString();
        this.inbox = parcel.createStringArray();
        this.bigPicture = parcel.readString();
        this.priority = parcel.readInt();
        this.defaults = parcel.readInt();
        this.category = parcel.readString();
        this.sound = parcel.readString();
        this.channelId = parcel.readString();
        this.intentUri = parcel.readString();
        this.badge = parcel.readInt();
    }
}
