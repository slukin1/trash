package com.kakao.sdk.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/kakao/sdk/share/model/ImageInfos;", "Landroid/os/Parcelable;", "original", "Lcom/kakao/sdk/share/model/ImageInfo;", "(Lcom/kakao/sdk/share/model/ImageInfo;)V", "getOriginal", "()Lcom/kakao/sdk/share/model/ImageInfo;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "share_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageInfos implements Parcelable {
    public static final Parcelable.Creator<ImageInfos> CREATOR = new Creator();
    private final ImageInfo original;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ImageInfos> {
        /* renamed from: a */
        public final ImageInfos createFromParcel(Parcel parcel) {
            return new ImageInfos(ImageInfo.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final ImageInfos[] newArray(int i11) {
            return new ImageInfos[i11];
        }
    }

    public ImageInfos(ImageInfo imageInfo) {
        this.original = imageInfo;
    }

    public static /* synthetic */ ImageInfos copy$default(ImageInfos imageInfos, ImageInfo imageInfo, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            imageInfo = imageInfos.original;
        }
        return imageInfos.copy(imageInfo);
    }

    public final ImageInfo component1() {
        return this.original;
    }

    public final ImageInfos copy(ImageInfo imageInfo) {
        return new ImageInfos(imageInfo);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ImageInfos) && x.b(this.original, ((ImageInfos) obj).original);
    }

    public final ImageInfo getOriginal() {
        return this.original;
    }

    public int hashCode() {
        return this.original.hashCode();
    }

    public String toString() {
        return "ImageInfos(original=" + this.original + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        this.original.writeToParcel(parcel, i11);
    }
}
