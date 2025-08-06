package com.google.android.gms.appset;

import com.google.android.gms.tasks.Task;

public interface AppSetIdClient {
    Task<AppSetIdInfo> getAppSetIdInfo();
}
