package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

public final /* synthetic */ class b implements CrashlyticsReportJsonTransform.ObjectParser {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ b f67070a = new b();

    public final Object parse(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseBuildIdMappingForArch(jsonReader);
    }
}
