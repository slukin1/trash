package com.zopim.android.sdk.data.observers;

import com.zendesk.logger.Logger;
import com.zopim.android.sdk.data.LivechatFileSendingPath;
import com.zopim.android.sdk.model.FileSending;
import java.util.Observable;
import java.util.Observer;

public abstract class FileSendingObserver implements Observer {
    private static final String LOG_TAG = "FileSendingObserver";

    public abstract void update(FileSending fileSending);

    public final void update(Observable observable, Object obj) {
        if (!(observable instanceof LivechatFileSendingPath)) {
            Logger.g(LOG_TAG, "Unexpected broadcast observable " + observable + " Observable should be of type " + LivechatFileSendingPath.class, new Object[0]);
        } else if (obj instanceof FileSending) {
            update((FileSending) obj);
        } else {
            Logger.g(LOG_TAG, "Unexpected broadcast object " + obj + " Broadcast object should be of type " + FileSending.class, new Object[0]);
        }
    }
}
