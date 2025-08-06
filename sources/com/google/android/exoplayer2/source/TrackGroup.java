package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.sumsub.sns.internal.videoident.presentation.a;
import java.util.Arrays;

public final class TrackGroup implements Parcelable {
    public static final Parcelable.Creator<TrackGroup> CREATOR = new Parcelable.Creator<TrackGroup>() {
        public TrackGroup createFromParcel(Parcel parcel) {
            return new TrackGroup(parcel);
        }

        public TrackGroup[] newArray(int i11) {
            return new TrackGroup[i11];
        }
    };
    private static final String TAG = "TrackGroup";
    private final Format[] formats;
    private int hashCode;
    public final int length;

    public TrackGroup(Format... formatArr) {
        Assertions.checkState(formatArr.length > 0);
        this.formats = formatArr;
        this.length = formatArr.length;
        verifyCorrectness();
    }

    private static void logErrorMessage(String str, String str2, String str3, int i11) {
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 78 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb2.append("Different ");
        sb2.append(str);
        sb2.append(" combined in one TrackGroup: '");
        sb2.append(str2);
        sb2.append("' (track 0) and '");
        sb2.append(str3);
        sb2.append("' (track ");
        sb2.append(i11);
        sb2.append(")");
        Log.e(TAG, "", new IllegalStateException(sb2.toString()));
    }

    private static String normalizeLanguage(String str) {
        return (str == null || str.equals(C.LANGUAGE_UNDETERMINED)) ? "" : str;
    }

    private static int normalizeRoleFlags(int i11) {
        return i11 | 16384;
    }

    private void verifyCorrectness() {
        String normalizeLanguage = normalizeLanguage(this.formats[0].language);
        int normalizeRoleFlags = normalizeRoleFlags(this.formats[0].roleFlags);
        int i11 = 1;
        while (true) {
            Format[] formatArr = this.formats;
            if (i11 >= formatArr.length) {
                return;
            }
            if (!normalizeLanguage.equals(normalizeLanguage(formatArr[i11].language))) {
                Format[] formatArr2 = this.formats;
                logErrorMessage(a.f36645t, formatArr2[0].language, formatArr2[i11].language, i11);
                return;
            } else if (normalizeRoleFlags != normalizeRoleFlags(this.formats[i11].roleFlags)) {
                logErrorMessage("role flags", Integer.toBinaryString(this.formats[0].roleFlags), Integer.toBinaryString(this.formats[i11].roleFlags), i11);
                return;
            } else {
                i11++;
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroup.class != obj.getClass()) {
            return false;
        }
        TrackGroup trackGroup = (TrackGroup) obj;
        if (this.length != trackGroup.length || !Arrays.equals(this.formats, trackGroup.formats)) {
            return false;
        }
        return true;
    }

    public Format getFormat(int i11) {
        return this.formats[i11];
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 527 + Arrays.hashCode(this.formats);
        }
        return this.hashCode;
    }

    public int indexOf(Format format) {
        int i11 = 0;
        while (true) {
            Format[] formatArr = this.formats;
            if (i11 >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i11]) {
                return i11;
            }
            i11++;
        }
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.length);
        for (int i12 = 0; i12 < this.length; i12++) {
            parcel.writeParcelable(this.formats[i12], 0);
        }
    }

    public TrackGroup(Parcel parcel) {
        int readInt = parcel.readInt();
        this.length = readInt;
        this.formats = new Format[readInt];
        for (int i11 = 0; i11 < this.length; i11++) {
            this.formats[i11] = (Format) parcel.readParcelable(Format.class.getClassLoader());
        }
    }
}
