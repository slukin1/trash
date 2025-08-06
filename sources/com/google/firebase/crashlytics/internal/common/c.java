package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class c implements FilenameFilter {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ c f67052b = new c();

    public final boolean accept(File file, String str) {
        return str.startsWith(CrashlyticsController.APP_EXCEPTION_MARKER_PREFIX);
    }
}
