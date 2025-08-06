package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Comparator;

public final /* synthetic */ class f implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ f f67055b = new f();

    public final int compare(Object obj, Object obj2) {
        return ((CrashlyticsReport.CustomAttribute) obj).getKey().compareTo(((CrashlyticsReport.CustomAttribute) obj2).getKey());
    }
}
