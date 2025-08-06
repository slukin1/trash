package androidx.test.orchestrator.junit;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import org.junit.runner.notification.Failure;

public final class ParcelableFailure implements Parcelable {
    public static final Parcelable.Creator<ParcelableFailure> CREATOR = new Parcelable.Creator<ParcelableFailure>() {
        /* renamed from: a */
        public ParcelableFailure createFromParcel(Parcel parcel) {
            return new ParcelableFailure(parcel);
        }

        /* renamed from: b */
        public ParcelableFailure[] newArray(int i11) {
            return new ParcelableFailure[i11];
        }
    };
    private static final int MAX_STREAM_LENGTH = 16384;
    private static final String TAG = "ParcelableFailure";
    private final ParcelableDescription description;
    private final String trace;

    private static String trimToLength(String str) {
        if (str.length() <= 16384) {
            return str.concat("\n");
        }
        Log.i(TAG, String.format("Stack trace too long, trimmed to first %s characters.", new Object[]{16384}));
        return String.valueOf(str.substring(0, 16384)).concat("\n");
    }

    public int describeContents() {
        return 0;
    }

    public ParcelableDescription getDescription() {
        return this.description;
    }

    public String getTrace() {
        return this.trace;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeParcelable(this.description, 0);
        parcel.writeString(this.trace);
    }

    public ParcelableFailure(Failure failure) {
        this.description = new ParcelableDescription(failure.getDescription());
        this.trace = failure.getTrace();
    }

    private ParcelableFailure(Parcel parcel) {
        this.description = (ParcelableDescription) parcel.readParcelable(ParcelableDescription.class.getClassLoader());
        this.trace = parcel.readString();
    }

    public ParcelableFailure(ParcelableDescription parcelableDescription, Throwable th2) {
        this.description = parcelableDescription;
        this.trace = trimToLength(th2.getMessage());
    }
}
