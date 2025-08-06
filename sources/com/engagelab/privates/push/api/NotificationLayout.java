package com.engagelab.privates.push.api;

import android.os.Parcel;
import android.os.Parcelable;

public class NotificationLayout implements Parcelable {
    public static final Parcelable.Creator<NotificationLayout> CREATOR = new a();
    private int contentViewId = 0;
    private int iconResourceId = 0;
    private int iconViewId = 0;
    private int layoutId = 0;
    private int timeViewId = 0;
    private int titleViewId = 0;

    public static class a implements Parcelable.Creator<NotificationLayout> {
        /* renamed from: a */
        public NotificationLayout createFromParcel(Parcel parcel) {
            return new NotificationLayout(parcel);
        }

        /* renamed from: a */
        public NotificationLayout[] newArray(int i11) {
            return new NotificationLayout[i11];
        }
    }

    public NotificationLayout() {
    }

    public int describeContents() {
        return 0;
    }

    public int getContentViewId() {
        return this.contentViewId;
    }

    public int getIconResourceId() {
        return this.iconResourceId;
    }

    public int getIconViewId() {
        return this.iconViewId;
    }

    public int getLayoutId() {
        return this.layoutId;
    }

    public int getTimeViewId() {
        return this.timeViewId;
    }

    public int getTitleViewId() {
        return this.titleViewId;
    }

    public NotificationLayout setContentViewId(int i11) {
        this.contentViewId = i11;
        return this;
    }

    public NotificationLayout setIconResourceId(int i11) {
        this.iconResourceId = i11;
        return this;
    }

    public NotificationLayout setIconViewId(int i11) {
        this.iconViewId = i11;
        return this;
    }

    public NotificationLayout setLayoutId(int i11) {
        this.layoutId = i11;
        return this;
    }

    public NotificationLayout setTimeViewId(int i11) {
        this.timeViewId = i11;
        return this;
    }

    public NotificationLayout setTitleViewId(int i11) {
        this.titleViewId = i11;
        return this;
    }

    public String toString() {
        return "\n{\n  layoutId=" + this.layoutId + ",\n  iconViewId=" + this.iconViewId + ",\n  titleViewId=" + this.titleViewId + ",\n  contentViewId=" + this.contentViewId + ",\n  timeViewId=" + this.timeViewId + "\n}";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.layoutId);
        parcel.writeInt(this.iconViewId);
        parcel.writeInt(this.iconResourceId);
        parcel.writeInt(this.titleViewId);
        parcel.writeInt(this.contentViewId);
        parcel.writeInt(this.timeViewId);
    }

    public NotificationLayout(Parcel parcel) {
        this.layoutId = parcel.readInt();
        this.iconViewId = parcel.readInt();
        this.iconResourceId = parcel.readInt();
        this.titleViewId = parcel.readInt();
        this.contentViewId = parcel.readInt();
        this.timeViewId = parcel.readInt();
    }
}
