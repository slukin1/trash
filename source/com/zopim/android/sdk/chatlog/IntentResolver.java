package com.zopim.android.sdk.chatlog;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import com.zendesk.logger.Logger;

class IntentResolver {
    private static final String LOG_TAG = "IntentResolver";

    public static boolean startActivity(Context context, Intent intent) {
        if (context == null) {
            Logger.l(LOG_TAG, "Could not start activity. Context must not be null", new Object[0]);
            return false;
        } else if (intent == null) {
            Logger.l(LOG_TAG, "Could not start activity. Intent must not be null", new Object[0]);
            return false;
        } else {
            ActivityInfo resolveActivityInfo = intent.resolveActivityInfo(context.getPackageManager(), 128);
            if (resolveActivityInfo == null || !resolveActivityInfo.exported) {
                Logger.g(LOG_TAG, "Can't open attachment. No application can handle this uri. " + intent.getData(), new Object[0]);
                return false;
            }
            try {
                context.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException unused) {
                Logger.g(LOG_TAG, "Unexpected attachment error. Receiving activity was resolved but attachment could not be opened.", new Object[0]);
                return false;
            }
        }
    }
}
