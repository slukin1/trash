package com.sensorsdata.analytics.android.sdk.core.mediator.protocol;

import android.app.Activity;
import android.net.Uri;

public interface SAScanListener {
    boolean handlerScanUri(Activity activity, Uri uri);
}
