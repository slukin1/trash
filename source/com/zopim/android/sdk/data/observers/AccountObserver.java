package com.zopim.android.sdk.data.observers;

import com.zendesk.logger.Logger;
import com.zopim.android.sdk.data.LivechatAccountPath;
import com.zopim.android.sdk.model.Account;
import java.util.Observable;
import java.util.Observer;

public abstract class AccountObserver implements Observer {
    private static final String LOG_TAG = "AccountObserver";

    public abstract void update(Account account);

    public final void update(Observable observable, Object obj) {
        if (!(observable instanceof LivechatAccountPath)) {
            Logger.g(LOG_TAG, "Unexpected broadcast observable " + observable + " Observable should be of type " + LivechatAccountPath.class, new Object[0]);
        } else if (obj instanceof Account) {
            update((Account) obj);
        } else {
            Logger.g(LOG_TAG, "Unexpected broadcast object " + obj + " Broadcast object should be of type " + Account.class, new Object[0]);
        }
    }
}
