package com.zopim.android.sdk.data.observers;

import com.zendesk.logger.Logger;
import com.zopim.android.sdk.data.LivechatProfilePath;
import com.zopim.android.sdk.model.Profile;
import java.util.Observable;
import java.util.Observer;

public abstract class ProfileObserver implements Observer {
    private static final String LOG_TAG = "ProfileObserver";

    public abstract void update(Profile profile);

    public final void update(Observable observable, Object obj) {
        if (!(observable instanceof LivechatProfilePath)) {
            Logger.g(LOG_TAG, "Unexpected broadcast observable " + observable + " Observable should be of type " + LivechatProfilePath.class, new Object[0]);
        } else if (obj instanceof Profile) {
            update((Profile) obj);
        } else {
            Logger.g(LOG_TAG, "Unexpected broadcast object " + obj + " Broadcast object should be of type " + Profile.class, new Object[0]);
        }
    }
}
