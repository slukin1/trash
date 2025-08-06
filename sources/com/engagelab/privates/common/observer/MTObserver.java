package com.engagelab.privates.common.observer;

import android.content.Context;
import android.os.Bundle;

public abstract class MTObserver {
    public abstract void dispatchMessage(Context context, int i11, Bundle bundle);

    public short getSdkFlag() {
        return 0;
    }

    public String getSdkName() {
        return null;
    }

    public int getSdkPriority() {
        return 0;
    }

    public String getSdkVersion() {
        return null;
    }

    public String[] getThreadName() {
        return new String[0];
    }

    public void handleDelayMessage(Context context, int i11, Bundle bundle) {
    }

    public void handleMessage(Context context, int i11, Bundle bundle) {
    }

    public boolean isSdk() {
        return false;
    }

    public abstract boolean isSupport(int i11);
}
