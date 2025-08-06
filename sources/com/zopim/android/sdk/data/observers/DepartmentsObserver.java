package com.zopim.android.sdk.data.observers;

import com.zendesk.logger.Logger;
import com.zopim.android.sdk.data.LivechatDepartmentsPath;
import com.zopim.android.sdk.model.Department;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public abstract class DepartmentsObserver implements Observer {
    private static final String LOG_TAG = "DepartmentsObserver";

    public abstract void update(Map<String, Department> map);

    public final void update(Observable observable, Object obj) {
        if (!(observable instanceof LivechatDepartmentsPath)) {
            Logger.g(LOG_TAG, "Unexpected broadcast observable " + observable + " Observable should be of type " + LivechatDepartmentsPath.class, new Object[0]);
        } else if (obj instanceof Map) {
            update((Map) obj);
        } else {
            Logger.g(LOG_TAG, "Unexpected broadcast object " + obj + " Broadcast object should be of type " + Map.class, new Object[0]);
        }
    }
}
