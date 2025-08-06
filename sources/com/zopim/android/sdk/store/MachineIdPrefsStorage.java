package com.zopim.android.sdk.store;

import android.content.Context;
import com.zendesk.logger.Logger;

public final class MachineIdPrefsStorage extends PrefsStorage implements MachineIdStorage {
    private static final String LOG_TAG = "MachineIdPrefsStorage";
    private static final String MACHINE_ID_KEY = "stored_machine_id";
    private static final String PREFS_NAME = "machine_id";

    public MachineIdPrefsStorage(Context context) {
        super(context, PREFS_NAME);
    }

    public /* bridge */ /* synthetic */ void delete() {
        super.delete();
    }

    public /* bridge */ /* synthetic */ void disable() {
        super.disable();
    }

    public String getMachineId() {
        if (this.mDisabled) {
            return null;
        }
        return this.mStoragePreferences.getString(MACHINE_ID_KEY, (String) null);
    }

    public void setMachineId(String str) {
        if (str == null) {
            Logger.l(LOG_TAG, "Machine id must not be null. Skipping storing machine id.", new Object[0]);
        } else if (this.mDisabled) {
            Logger.g(LOG_TAG, "Storage is disabled, will abort storing machine id  ", new Object[0]);
        } else {
            this.mStoragePreferences.edit().putString(MACHINE_ID_KEY, str).apply();
        }
    }
}
