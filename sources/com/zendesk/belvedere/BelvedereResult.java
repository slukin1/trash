package com.zendesk.belvedere;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;

public class BelvedereResult implements Parcelable {
    public static final Parcelable.Creator<BelvedereResult> CREATOR = new a();
    private final File file;
    private final Uri uri;

    public static class a implements Parcelable.Creator<BelvedereResult> {
        /* renamed from: a */
        public BelvedereResult createFromParcel(Parcel parcel) {
            return new BelvedereResult(parcel, (a) null);
        }

        /* renamed from: b */
        public BelvedereResult[] newArray(int i11) {
            return new BelvedereResult[i11];
        }
    }

    public /* synthetic */ BelvedereResult(Parcel parcel, a aVar) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public File getFile() {
        return this.file;
    }

    public Uri getUri() {
        return this.uri;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeSerializable(this.file);
        parcel.writeParcelable(this.uri, i11);
    }

    public BelvedereResult(File file2, Uri uri2) {
        this.file = file2;
        this.uri = uri2;
    }

    private BelvedereResult(Parcel parcel) {
        this.file = (File) parcel.readSerializable();
        this.uri = (Uri) parcel.readParcelable(BelvedereResult.class.getClassLoader());
    }
}
