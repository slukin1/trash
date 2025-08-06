package com.google.android.exoplayer2.metadata.dvbsi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.a;
import com.google.android.exoplayer2.util.Assertions;

public final class AppInfoTable implements Metadata.Entry {
    public static final int CONTROL_CODE_AUTOSTART = 1;
    public static final int CONTROL_CODE_PRESENT = 2;
    public static final Parcelable.Creator<AppInfoTable> CREATOR = new Parcelable.Creator<AppInfoTable>() {
        public AppInfoTable createFromParcel(Parcel parcel) {
            return new AppInfoTable(parcel.readInt(), (String) Assertions.checkNotNull(parcel.readString()));
        }

        public AppInfoTable[] newArray(int i11) {
            return new AppInfoTable[i11];
        }
    };
    public final int controlCode;
    public final String url;

    public AppInfoTable(int i11, String str) {
        this.controlCode = i11;
        this.url = str;
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return a.a(this);
    }

    public /* synthetic */ Format getWrappedMetadataFormat() {
        return a.b(this);
    }

    public /* synthetic */ void populateMediaMetadata(MediaMetadata.Builder builder) {
        a.c(this, builder);
    }

    public String toString() {
        int i11 = this.controlCode;
        String str = this.url;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 33);
        sb2.append("Ait(controlCode=");
        sb2.append(i11);
        sb2.append(",url=");
        sb2.append(str);
        sb2.append(")");
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.url);
        parcel.writeInt(this.controlCode);
    }
}
