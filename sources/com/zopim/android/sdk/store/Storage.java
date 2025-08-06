package com.zopim.android.sdk.store;

import android.content.Context;
import com.zendesk.logger.Logger;

public enum Storage {
    INSTANCE;
    
    private static final String LOG_TAG = "Storage";
    private Context mAppContext;

    public static void init(Context context) {
        if (context == null) {
            Logger.d(LOG_TAG, "Can not initialize storage. Context must not be null.", new Object[0]);
            return;
        }
        INSTANCE.mAppContext = context.getApplicationContext();
    }

    private boolean isInitialized() {
        return this.mAppContext != null;
    }

    public static MachineIdStorage machineId() {
        Storage storage = INSTANCE;
        if (storage.isInitialized()) {
            return new MachineIdPrefsStorage(storage.mAppContext);
        }
        Logger.l(LOG_TAG, "Storage must be initialized first. Will return mocked storage implementation.", new Object[0]);
        return new UninitializedMachineIdStorage();
    }

    public static VisitorInfoStorage visitorInfo() {
        Storage storage = INSTANCE;
        if (storage.isInitialized()) {
            return new VisitorInfoPrefsStorage(storage.mAppContext);
        }
        Logger.l(LOG_TAG, "Storage must be initialized first. Will return dummy storage implementation.", new Object[0]);
        return new UninitializedVisitorInfoStorage();
    }

    public void clearAll() {
        machineId().delete();
        visitorInfo().delete();
    }
}
