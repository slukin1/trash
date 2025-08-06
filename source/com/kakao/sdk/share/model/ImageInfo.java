package com.kakao.sdk.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006#"}, d2 = {"Lcom/kakao/sdk/share/model/ImageInfo;", "Landroid/os/Parcelable;", "url", "", "contentType", "length", "", "width", "height", "(Ljava/lang/String;Ljava/lang/String;III)V", "getContentType", "()Ljava/lang/String;", "getHeight", "()I", "getLength", "getUrl", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "share_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageInfo implements Parcelable {
    public static final Parcelable.Creator<ImageInfo> CREATOR = new Creator();
    private final String contentType;
    private final int height;
    private final int length;
    private final String url;
    private final int width;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ImageInfo> {
        /* renamed from: a */
        public final ImageInfo createFromParcel(Parcel parcel) {
            return new ImageInfo(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* renamed from: b */
        public final ImageInfo[] newArray(int i11) {
            return new ImageInfo[i11];
        }
    }

    public ImageInfo(String str, String str2, int i11, int i12, int i13) {
        this.url = str;
        this.contentType = str2;
        this.length = i11;
        this.width = i12;
        this.height = i13;
    }

    public static /* synthetic */ ImageInfo copy$default(ImageInfo imageInfo, String str, String str2, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            str = imageInfo.url;
        }
        if ((i14 & 2) != 0) {
            str2 = imageInfo.contentType;
        }
        String str3 = str2;
        if ((i14 & 4) != 0) {
            i11 = imageInfo.length;
        }
        int i15 = i11;
        if ((i14 & 8) != 0) {
            i12 = imageInfo.width;
        }
        int i16 = i12;
        if ((i14 & 16) != 0) {
            i13 = imageInfo.height;
        }
        return imageInfo.copy(str, str3, i15, i16, i13);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.contentType;
    }

    public final int component3() {
        return this.length;
    }

    public final int component4() {
        return this.width;
    }

    public final int component5() {
        return this.height;
    }

    public final ImageInfo copy(String str, String str2, int i11, int i12, int i13) {
        return new ImageInfo(str, str2, i11, i12, i13);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageInfo)) {
            return false;
        }
        ImageInfo imageInfo = (ImageInfo) obj;
        return x.b(this.url, imageInfo.url) && x.b(this.contentType, imageInfo.contentType) && this.length == imageInfo.length && this.width == imageInfo.width && this.height == imageInfo.height;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getLength() {
        return this.length;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((((this.url.hashCode() * 31) + this.contentType.hashCode()) * 31) + this.length) * 31) + this.width) * 31) + this.height;
    }

    public String toString() {
        return "ImageInfo(url=" + this.url + ", contentType=" + this.contentType + ", length=" + this.length + ", width=" + this.width + ", height=" + this.height + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.url);
        parcel.writeString(this.contentType);
        parcel.writeInt(this.length);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }
}
