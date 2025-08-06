package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class a implements FilenameFilter {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ a f67050b = new a();

    public final boolean accept(File file, String str) {
        return str.startsWith(CrashlyticsAppQualitySessionsStore.AQS_SESSION_ID_FILENAME_PREFIX);
    }
}
