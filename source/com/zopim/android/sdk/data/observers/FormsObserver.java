package com.zopim.android.sdk.data.observers;

import com.zendesk.logger.Logger;
import com.zopim.android.sdk.data.LivechatFormsPath;
import com.zopim.android.sdk.model.Forms;
import java.util.Observable;
import java.util.Observer;

public abstract class FormsObserver implements Observer {
    private static final String LOG_TAG = "FormsObserver";

    public abstract void update(Forms forms);

    public final void update(Observable observable, Object obj) {
        if (!(observable instanceof LivechatFormsPath)) {
            Logger.g(LOG_TAG, "Unexpected broadcast observable " + observable + " Observable should be of type " + LivechatFormsPath.class, new Object[0]);
        } else if (obj instanceof Forms) {
            update((Forms) obj);
        } else {
            Logger.g(LOG_TAG, "Unexpected broadcast object " + obj + " Broadcast object should be of type " + Forms.class, new Object[0]);
        }
    }
}
