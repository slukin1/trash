package com.zendesk.belvedere;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;

public class BelvedereIntent implements Parcelable {
    public static final Parcelable.Creator<BelvedereIntent> CREATOR = new a();
    private final Intent intent;
    private final String permission;
    private final int requestCode;
    private final BelvedereSource source;

    public static class a implements Parcelable.Creator<BelvedereIntent> {
        /* renamed from: a */
        public BelvedereIntent createFromParcel(Parcel parcel) {
            return new BelvedereIntent(parcel, (a) null);
        }

        /* renamed from: b */
        public BelvedereIntent[] newArray(int i11) {
            return new BelvedereIntent[i11];
        }
    }

    public /* synthetic */ BelvedereIntent(Parcel parcel, a aVar) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public Intent getIntent() {
        return this.intent;
    }

    public String getPermission() {
        return this.permission;
    }

    public int getRequestCode() {
        return this.requestCode;
    }

    public BelvedereSource getSource() {
        return this.source;
    }

    public void open(Activity activity) {
        activity.startActivityForResult(this.intent, this.requestCode);
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.requestCode);
        parcel.writeParcelable(this.intent, i11);
        parcel.writeSerializable(this.source);
        parcel.writeString(this.permission);
    }

    public BelvedereIntent(Intent intent2, int i11, BelvedereSource belvedereSource, String str) {
        this.intent = intent2;
        this.requestCode = i11;
        this.source = belvedereSource;
        this.permission = str;
    }

    public void open(Fragment fragment) {
        fragment.startActivityForResult(this.intent, this.requestCode);
    }

    private BelvedereIntent(Parcel parcel) {
        this.requestCode = parcel.readInt();
        this.intent = (Intent) parcel.readParcelable(BelvedereIntent.class.getClassLoader());
        this.source = (BelvedereSource) parcel.readSerializable();
        this.permission = parcel.readString();
    }
}
