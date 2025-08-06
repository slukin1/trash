package com.huobi.invite.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class InvitePosterItem implements Serializable, Parcelable {
    public static final Parcelable.Creator<InvitePosterItem> CREATOR = new a();
    private static final long serialVersionUID = -3800881258958104279L;
    private String adName;
    private String adOrder;
    private byte[] bytesFloatBitmap;
    private byte[] bytesFromBitmap;
    private String img;
    private String inviteCode;
    private String mainTitle;
    private String qrUrl;
    private String showNativeQr;
    private String subTitle;
    private String title;

    public class a implements Parcelable.Creator<InvitePosterItem> {
        /* renamed from: a */
        public InvitePosterItem createFromParcel(Parcel parcel) {
            return new InvitePosterItem(parcel);
        }

        /* renamed from: b */
        public InvitePosterItem[] newArray(int i11) {
            return new InvitePosterItem[i11];
        }
    }

    public InvitePosterItem() {
    }

    public int describeContents() {
        return 0;
    }

    public String getAdName() {
        return this.adName;
    }

    public String getAdOrder() {
        return this.adOrder;
    }

    public byte[] getBytesFloatBitmap() {
        return this.bytesFloatBitmap;
    }

    public byte[] getBytesFromBitmap() {
        return this.bytesFromBitmap;
    }

    public String getImg() {
        return this.img;
    }

    public String getInviteCode() {
        return this.inviteCode;
    }

    public String getMainTitle() {
        return this.mainTitle;
    }

    public String getQrUrl() {
        return this.qrUrl;
    }

    public String getShowNativeQr() {
        return this.showNativeQr;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAdName(String str) {
        this.adName = str;
    }

    public void setAdOrder(String str) {
        this.adOrder = str;
    }

    public void setBytesFloatBitmap(byte[] bArr) {
        this.bytesFloatBitmap = bArr;
    }

    public void setBytesFromBitmap(byte[] bArr) {
        this.bytesFromBitmap = bArr;
    }

    public void setImg(String str) {
        this.img = str;
    }

    public void setInviteCode(String str) {
        this.inviteCode = str;
    }

    public void setMainTitle(String str) {
        this.mainTitle = str;
    }

    public void setQrUrl(String str) {
        this.qrUrl = str;
    }

    public void setShowNativeQr(String str) {
        this.showNativeQr = str;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.adName);
        parcel.writeString(this.adOrder);
        parcel.writeString(this.title);
        parcel.writeString(this.img);
        parcel.writeByteArray(this.bytesFromBitmap);
        parcel.writeByteArray(this.bytesFloatBitmap);
        parcel.writeString(this.showNativeQr);
        parcel.writeString(this.qrUrl);
        parcel.writeString(this.mainTitle);
        parcel.writeString(this.subTitle);
        parcel.writeString(this.inviteCode);
    }

    public InvitePosterItem(Parcel parcel) {
        this.adName = parcel.readString();
        this.adOrder = parcel.readString();
        this.title = parcel.readString();
        this.img = parcel.readString();
        this.bytesFromBitmap = parcel.createByteArray();
        this.bytesFloatBitmap = parcel.createByteArray();
        this.showNativeQr = parcel.readString();
        this.qrUrl = parcel.readString();
        this.mainTitle = parcel.readString();
        this.subTitle = parcel.readString();
        this.inviteCode = parcel.readString();
    }
}
