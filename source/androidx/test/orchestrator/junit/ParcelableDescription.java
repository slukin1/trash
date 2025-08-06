package androidx.test.orchestrator.junit;

import android.os.Parcel;
import android.os.Parcelable;
import org.junit.runner.Description;

public final class ParcelableDescription implements Parcelable {
    public static final Parcelable.Creator<ParcelableDescription> CREATOR = new Parcelable.Creator<ParcelableDescription>() {
        /* renamed from: a */
        public ParcelableDescription createFromParcel(Parcel parcel) {
            return new ParcelableDescription(parcel);
        }

        /* renamed from: b */
        public ParcelableDescription[] newArray(int i11) {
            return new ParcelableDescription[i11];
        }
    };
    private final String className;
    private final String displayName;
    private final String methodName;

    private String getNonNullString(Parcel parcel) {
        String readString = parcel.readString();
        return readString == null ? "" : readString;
    }

    public int describeContents() {
        return 0;
    }

    public String getClassName() {
        return this.className;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.className);
        parcel.writeString(this.methodName);
        parcel.writeString(this.displayName);
    }

    public ParcelableDescription(Description description) {
        this.className = description.getClassName();
        this.methodName = description.getMethodName();
        this.displayName = description.getDisplayName();
    }

    public ParcelableDescription(String str) {
        String[] split = str.split("#");
        this.className = split[0];
        this.methodName = split.length > 1 ? split[1] : "";
        this.displayName = str;
    }

    private ParcelableDescription(Parcel parcel) {
        this.className = getNonNullString(parcel);
        this.methodName = getNonNullString(parcel);
        this.displayName = getNonNullString(parcel);
    }
}
