package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public final class ActivityResult implements Parcelable {
    public static final Parcelable.Creator<ActivityResult> CREATOR = new a();
    private final Intent mData;
    private final int mResultCode;

    public class a implements Parcelable.Creator<ActivityResult> {
        /* renamed from: a */
        public ActivityResult createFromParcel(Parcel parcel) {
            return new ActivityResult(parcel);
        }

        /* renamed from: b */
        public ActivityResult[] newArray(int i11) {
            return new ActivityResult[i11];
        }
    }

    public ActivityResult(int i11, Intent intent) {
        this.mResultCode = i11;
        this.mData = intent;
    }

    public static String resultCodeToString(int i11) {
        if (i11 != -1) {
            return i11 != 0 ? String.valueOf(i11) : "RESULT_CANCELED";
        }
        return "RESULT_OK";
    }

    public int describeContents() {
        return 0;
    }

    public Intent getData() {
        return this.mData;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + resultCodeToString(this.mResultCode) + ", data=" + this.mData + '}';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.mResultCode);
        parcel.writeInt(this.mData == null ? 0 : 1);
        Intent intent = this.mData;
        if (intent != null) {
            intent.writeToParcel(parcel, i11);
        }
    }

    public ActivityResult(Parcel parcel) {
        this.mResultCode = parcel.readInt();
        this.mData = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
