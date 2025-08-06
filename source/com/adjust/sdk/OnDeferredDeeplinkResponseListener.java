package com.adjust.sdk;

import android.net.Uri;

public interface OnDeferredDeeplinkResponseListener {
    boolean launchReceivedDeeplink(Uri uri);
}
