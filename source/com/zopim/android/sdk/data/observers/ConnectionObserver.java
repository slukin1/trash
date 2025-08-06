package com.zopim.android.sdk.data.observers;

import com.zendesk.logger.Logger;
import com.zopim.android.sdk.data.ConnectionPath;
import com.zopim.android.sdk.model.Connection;
import java.util.Observable;
import java.util.Observer;

public abstract class ConnectionObserver implements Observer {
    private static final String LOG_TAG = "ConnectionObserver";

    public abstract void update(Connection connection);

    public final void update(Observable observable, Object obj) {
        if (!(observable instanceof ConnectionPath)) {
            Logger.g(LOG_TAG, "Unexpected broadcast observable " + observable + " Observable should be of type " + ConnectionPath.class, new Object[0]);
        } else if (obj instanceof Connection) {
            update((Connection) obj);
        } else {
            Logger.g(LOG_TAG, "Unexpected broadcast object " + obj + " Broadcast object should be of type " + Connection.class, new Object[0]);
        }
    }
}
