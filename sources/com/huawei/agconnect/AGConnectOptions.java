package com.huawei.agconnect;

import android.content.Context;

public interface AGConnectOptions {
    boolean getBoolean(String str);

    boolean getBoolean(String str, boolean z11);

    Context getContext();

    String getIdentifier();

    int getInt(String str);

    int getInt(String str, int i11);

    String getPackageName();

    AGCRoutePolicy getRoutePolicy();

    String getString(String str);

    String getString(String str, String str2);
}
