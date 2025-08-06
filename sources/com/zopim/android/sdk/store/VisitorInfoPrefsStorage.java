package com.zopim.android.sdk.store;

import android.content.Context;
import android.content.SharedPreferences;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.model.VisitorInfo;

public final class VisitorInfoPrefsStorage extends PrefsStorage implements VisitorInfoStorage {
    private static final String EMAIL_KEY = "email_key";
    private static final String LOG_TAG = "VisitorInfoPrefsStorage";
    private static final String NAME_KEY = "name_key";
    private static final String PHONE_NUMBER_KEY = "phone_number_key";
    private static final String PREFS_NAME = "visitor_info";

    public VisitorInfoPrefsStorage(Context context) {
        super(context, PREFS_NAME);
    }

    public /* bridge */ /* synthetic */ void delete() {
        super.delete();
    }

    public /* bridge */ /* synthetic */ void disable() {
        super.disable();
    }

    public VisitorInfo getVisitorInfo() {
        if (this.mDisabled) {
            return null;
        }
        String string = this.mStoragePreferences.getString(EMAIL_KEY, (String) null);
        String string2 = this.mStoragePreferences.getString(NAME_KEY, (String) null);
        String string3 = this.mStoragePreferences.getString(PHONE_NUMBER_KEY, (String) null);
        if (string == null && string2 == null && string3 == null) {
            return null;
        }
        return new VisitorInfo.Builder().email(string).name(string2).phoneNumber(string3).build();
    }

    public void setVisitorInfo(VisitorInfo visitorInfo) {
        if (visitorInfo == null) {
            Logger.l(LOG_TAG, "Visitor info must not be null. Skipping storing visitor info.", new Object[0]);
        } else if (this.mDisabled) {
            Logger.g(LOG_TAG, "Storage is disabled, will abort storing visitor info", new Object[0]);
        } else {
            SharedPreferences.Editor edit = this.mStoragePreferences.edit();
            String email = visitorInfo.getEmail();
            String name = visitorInfo.getName();
            String phoneNumber = visitorInfo.getPhoneNumber();
            if (email != null && !email.isEmpty()) {
                edit.putString(EMAIL_KEY, email);
            }
            if (name != null && !name.isEmpty()) {
                edit.putString(NAME_KEY, name);
            }
            if (phoneNumber != null && !phoneNumber.isEmpty()) {
                edit.putString(PHONE_NUMBER_KEY, phoneNumber);
            }
            edit.apply();
        }
    }
}
