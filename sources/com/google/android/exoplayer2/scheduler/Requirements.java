package com.google.android.exoplayer2.scheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Requirements implements Parcelable {
    public static final Parcelable.Creator<Requirements> CREATOR = new Parcelable.Creator<Requirements>() {
        public Requirements createFromParcel(Parcel parcel) {
            return new Requirements(parcel.readInt());
        }

        public Requirements[] newArray(int i11) {
            return new Requirements[i11];
        }
    };
    public static final int DEVICE_CHARGING = 8;
    public static final int DEVICE_IDLE = 4;
    public static final int DEVICE_STORAGE_NOT_LOW = 16;
    public static final int NETWORK = 1;
    public static final int NETWORK_UNMETERED = 2;
    private final int requirements;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface RequirementFlags {
    }

    public Requirements(int i11) {
        this.requirements = (i11 & 2) != 0 ? i11 | 1 : i11;
    }

    private int getNotMetNetworkRequirements(Context context) {
        if (!isNetworkRequired()) {
            return 0;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) Assertions.checkNotNull(context.getSystemService("connectivity"));
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected() || !isInternetConnectivityValidated(connectivityManager)) {
            return this.requirements & 3;
        }
        if (!isUnmeteredNetworkRequired() || !connectivityManager.isActiveNetworkMetered()) {
            return 0;
        }
        return 2;
    }

    private boolean isDeviceCharging(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        if (intExtra == 2 || intExtra == 5) {
            return true;
        }
        return false;
    }

    private boolean isDeviceIdle(Context context) {
        PowerManager powerManager = (PowerManager) Assertions.checkNotNull(context.getSystemService("power"));
        int i11 = Util.SDK_INT;
        if (i11 >= 23) {
            return powerManager.isDeviceIdleMode();
        }
        if (i11 >= 20) {
            if (!powerManager.isInteractive()) {
                return true;
            }
        } else if (!powerManager.isScreenOn()) {
            return true;
        }
        return false;
    }

    private static boolean isInternetConnectivityValidated(ConnectivityManager connectivityManager) {
        if (Util.SDK_INT < 24) {
            return true;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            return false;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        if (networkCapabilities == null || !networkCapabilities.hasCapability(16)) {
            return false;
        }
        return true;
    }

    private boolean isStorageNotLow(Context context) {
        return context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW")) == null;
    }

    public boolean checkRequirements(Context context) {
        return getNotMetRequirements(context) == 0;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Requirements.class != obj.getClass()) {
            return false;
        }
        if (this.requirements == ((Requirements) obj).requirements) {
            return true;
        }
        return false;
    }

    public Requirements filterRequirements(int i11) {
        int i12 = this.requirements;
        int i13 = i11 & i12;
        if (i13 == i12) {
            return this;
        }
        return new Requirements(i13);
    }

    public int getNotMetRequirements(Context context) {
        int notMetNetworkRequirements = getNotMetNetworkRequirements(context);
        if (isChargingRequired() && !isDeviceCharging(context)) {
            notMetNetworkRequirements |= 8;
        }
        if (isIdleRequired() && !isDeviceIdle(context)) {
            notMetNetworkRequirements |= 4;
        }
        return (!isStorageNotLowRequired() || isStorageNotLow(context)) ? notMetNetworkRequirements : notMetNetworkRequirements | 16;
    }

    public int getRequirements() {
        return this.requirements;
    }

    public int hashCode() {
        return this.requirements;
    }

    public boolean isChargingRequired() {
        return (this.requirements & 8) != 0;
    }

    public boolean isIdleRequired() {
        return (this.requirements & 4) != 0;
    }

    public boolean isNetworkRequired() {
        return (this.requirements & 1) != 0;
    }

    public boolean isStorageNotLowRequired() {
        return (this.requirements & 16) != 0;
    }

    public boolean isUnmeteredNetworkRequired() {
        return (this.requirements & 2) != 0;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.requirements);
    }
}
