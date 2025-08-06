package com.jumio.sdk.util;

import android.net.Uri;
import com.jumio.sdk.scanpart.JumioScanPart;
import jumio.core.r0;

public final class JumioDeepLinkHandler {
    public static final JumioDeepLinkHandler INSTANCE = new JumioDeepLinkHandler();

    public final boolean consumeForScanPart(Uri uri, JumioScanPart jumioScanPart) {
        if (jumioScanPart.getScanPart$jumio_core_release() instanceof r0) {
            return ((r0) jumioScanPart.getScanPart$jumio_core_release()).consume(uri);
        }
        return false;
    }
}
