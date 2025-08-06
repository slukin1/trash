package com.zopim.android.sdk.store;

import com.zendesk.logger.Logger;
import com.zopim.android.sdk.model.VisitorInfo;

final class UninitializedVisitorInfoStorage implements VisitorInfoStorage {
    private static final String LOG_TAG = "UninitializedVisitorInfoStorage";

    public void delete() {
        Logger.l(LOG_TAG, "Storage is not initialized. Skipping operation.", new Object[0]);
    }

    public void disable() {
        Logger.l(LOG_TAG, "Storage is not initialized. Skipping operation.", new Object[0]);
    }

    public VisitorInfo getVisitorInfo() {
        Logger.l(LOG_TAG, "Storage is not initialized. Skipping operation.", new Object[0]);
        return new VisitorInfo.Builder().build();
    }

    public void setVisitorInfo(VisitorInfo visitorInfo) {
        Logger.l(LOG_TAG, "Storage is not initialized. Skipping operation.", new Object[0]);
    }
}
