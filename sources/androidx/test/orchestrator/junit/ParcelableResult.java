package androidx.test.orchestrator.junit;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public final class ParcelableResult implements Parcelable {
    public static final Parcelable.Creator<ParcelableResult> CREATOR = new Parcelable.Creator<ParcelableResult>() {
        /* renamed from: a */
        public ParcelableResult createFromParcel(Parcel parcel) {
            return new ParcelableResult(parcel);
        }

        /* renamed from: b */
        public ParcelableResult[] newArray(int i11) {
            return new ParcelableResult[i11];
        }
    };
    private final List<ParcelableFailure> failures;

    public int describeContents() {
        return 0;
    }

    public int getFailureCount() {
        return this.failures.size();
    }

    public List<ParcelableFailure> getFailures() {
        return this.failures;
    }

    public boolean wasSuccessful() {
        return this.failures.isEmpty();
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeArray(this.failures.toArray());
    }

    public ParcelableResult(Result result) {
        this.failures = new ArrayList();
        for (Failure parcelableFailure : result.getFailures()) {
            this.failures.add(new ParcelableFailure(parcelableFailure));
        }
    }

    private ParcelableResult(Parcel parcel) {
        this.failures = new ArrayList();
        for (Object obj : parcel.readArray(ParcelableFailure[].class.getClassLoader())) {
            this.failures.add((ParcelableFailure) obj);
        }
    }
}
