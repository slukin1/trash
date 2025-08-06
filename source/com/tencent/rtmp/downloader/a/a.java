package com.tencent.rtmp.downloader.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.rtmp.TXPlayerAuthBuilder;
import com.tencent.rtmp.downloader.TXVodDownloadDataSource;

public class a extends TXVodDownloadDataSource implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
            return new a[i11];
        }
    };

    public a(int i11, String str, int i12, String str2, String str3) {
        super(i11, str, i12, str2, str3);
    }

    public static int a(int i11) {
        if (i11 != 1000) {
            switch (i11) {
                case 0:
                    break;
                case 1:
                    return 360;
                case 2:
                    return TXVodDownloadDataSource.QUALITY_540P;
                case 3:
                    return 720;
                case 4:
                    return 1080;
                case 5:
                    return 1800;
                case 6:
                    return 3112;
                default:
                    return i11;
            }
        }
        return 0;
    }

    public static String b(int i11) {
        return i11 == 1 ? "FLU" : i11 == 2 ? "SD" : i11 == 3 ? "HD" : i11 == 4 ? "FHD" : i11 == 5 ? "2K" : i11 == 6 ? "4K" : "";
    }

    public final void a(String str) {
        this.overlayKey = str;
    }

    public final void b(String str) {
        this.overlayIv = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.appId);
        parcel.writeString(this.fileId);
        parcel.writeString(this.pSign);
        parcel.writeInt(this.quality);
        parcel.writeString(this.userName);
        if (!TextUtils.isEmpty(this.pSign)) {
            parcel.writeString(this.overlayKey);
            parcel.writeString(this.overlayIv);
        }
    }

    public a(TXPlayerAuthBuilder tXPlayerAuthBuilder, int i11) {
        super(tXPlayerAuthBuilder, i11);
    }

    public a(TXPlayerAuthBuilder tXPlayerAuthBuilder, String str) {
        super(tXPlayerAuthBuilder, str);
    }

    public a(Parcel parcel) {
        this.appId = parcel.readInt();
        this.fileId = parcel.readString();
        this.pSign = parcel.readString();
        this.quality = parcel.readInt();
        this.userName = parcel.readString();
        if (!TextUtils.isEmpty(this.pSign)) {
            this.overlayKey = parcel.readString();
            this.overlayIv = parcel.readString();
        }
    }
}
