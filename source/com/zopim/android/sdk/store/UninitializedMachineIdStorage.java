package com.zopim.android.sdk.store;

import com.zendesk.logger.Logger;

final class UninitializedMachineIdStorage implements MachineIdStorage {
    private static final String LOG_TAG = "UninitializedMachineIdStorage";

    public void delete() {
        Logger.l(LOG_TAG, "Storage is not initialized. Skipping operation.", new Object[0]);
    }

    public void disable() {
        Logger.l(LOG_TAG, "Storage is not initialized. Skipping operation.", new Object[0]);
    }

    public String getMachineId() {
        Logger.l(LOG_TAG, "Storage is not initialized. Skipping operation. Will return empty string", new Object[0]);
        return "";
    }

    public void setMachineId(String str) {
        Logger.l(LOG_TAG, "Storage is not initialized. Skipping operation.", new Object[0]);
    }
}
