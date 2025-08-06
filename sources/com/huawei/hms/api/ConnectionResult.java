package com.huawei.hms.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;

public final class ConnectionResult implements Parcelable {
    public static final int API_UNAVAILABLE = 1000;
    public static final int BINDFAIL_RESOLUTION_BACKGROUND = 7;
    public static final int BINDFAIL_RESOLUTION_REQUIRED = 6;
    public static final int CANCELED = 13;
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new a();
    public static final int DEVELOPER_ERROR = 10;
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 9002;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 15;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 9000;
    public static final int RESOLUTION_REQUIRED = 9001;
    public static final int RESTRICTED_PROFILE = 9003;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_MISSING_PERMISSION = 19;
    public static final int SERVICE_UNSUPPORTED = 21;
    public static final int SERVICE_UPDATING = 9004;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_FAILED = 9005;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 14;
    private int apiVersion;
    private int connectionErrorCode;
    private String connectionErrorMessage;
    private PendingIntent pendingIntent;

    public class a implements Parcelable.Creator<ConnectionResult> {
        /* renamed from: a */
        public ConnectionResult createFromParcel(Parcel parcel) {
            return new ConnectionResult(parcel, (a) null);
        }

        /* renamed from: a */
        public ConnectionResult[] newArray(int i11) {
            return new ConnectionResult[i11];
        }
    }

    public /* synthetic */ ConnectionResult(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static String getErrorString(int i11) {
        if (i11 == -1) {
            return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
        if (i11 == 0) {
            return "SUCCESS";
        }
        if (i11 == 1) {
            return "SERVICE_MISSING";
        }
        if (i11 == 2) {
            return "SERVICE_VERSION_UPDATE_REQUIRED";
        }
        if (i11 == 3) {
            return "SERVICE_DISABLED";
        }
        if (i11 == 13) {
            return "CANCELED";
        }
        if (i11 == 14) {
            return "TIMEOUT";
        }
        if (i11 == 19) {
            return "SERVICE_MISSING_PERMISSION";
        }
        if (i11 == 21) {
            return "API_VERSION_UPDATE_REQUIRED";
        }
        switch (i11) {
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                return "UNKNOWN_ERROR_CODE(" + i11 + ")";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (!(obj instanceof ConnectionResult) || this.apiVersion != ((ConnectionResult) obj).apiVersion || this.connectionErrorCode != ((ConnectionResult) obj).connectionErrorCode || !this.connectionErrorMessage.equals(((ConnectionResult) obj).connectionErrorMessage) || !this.pendingIntent.equals(((ConnectionResult) obj).pendingIntent)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public int getErrorCode() {
        return this.connectionErrorCode;
    }

    public final String getErrorMessage() {
        return this.connectionErrorMessage;
    }

    public final PendingIntent getResolution() {
        return this.pendingIntent;
    }

    public final boolean hasResolution() {
        return HuaweiApiAvailability.getInstance().isUserResolvableError(this.connectionErrorCode, this.pendingIntent);
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf((long) this.apiVersion), Long.valueOf((long) getErrorCode()), getErrorMessage(), this.pendingIntent);
    }

    public final boolean isSuccess() {
        return this.connectionErrorCode == 0;
    }

    public final void startResolutionForResult(Activity activity, int i11) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            HuaweiApiAvailability.getInstance().resolveError(activity, this.connectionErrorCode, i11, this.pendingIntent);
        }
    }

    public void writeToParcel(Parcel parcel, int i11) {
        if (parcel != null) {
            parcel.writeInt(this.apiVersion);
            parcel.writeInt(this.connectionErrorCode);
            parcel.writeString(this.connectionErrorMessage);
            this.pendingIntent.writeToParcel(parcel, i11);
        }
    }

    public ConnectionResult(int i11, int i12, PendingIntent pendingIntent2, String str) {
        this.apiVersion = i11;
        this.connectionErrorCode = i12;
        this.pendingIntent = pendingIntent2;
        this.connectionErrorMessage = str;
    }

    public ConnectionResult(int i11) {
        this(i11, (PendingIntent) null);
    }

    public ConnectionResult(int i11, PendingIntent pendingIntent2) {
        this(i11, pendingIntent2, (String) null);
    }

    public ConnectionResult(int i11, PendingIntent pendingIntent2, String str) {
        this(1, i11, pendingIntent2, str);
    }

    private ConnectionResult(Parcel parcel) {
        this.apiVersion = 1;
        this.pendingIntent = null;
        this.connectionErrorMessage = null;
        this.apiVersion = parcel.readInt();
        this.connectionErrorCode = parcel.readInt();
        this.connectionErrorMessage = parcel.readString();
        Parcelable parcelable = (Parcelable) PendingIntent.CREATOR.createFromParcel(parcel);
        if (parcelable != null) {
            this.pendingIntent = (PendingIntent) parcelable;
        }
    }
}
