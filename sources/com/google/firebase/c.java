package com.google.firebase;

import android.content.Context;
import com.google.firebase.platforminfo.LibraryVersionComponent;

public final /* synthetic */ class c implements LibraryVersionComponent.VersionExtractor {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ c f66961a = new c();

    public final String extract(Object obj) {
        return FirebaseCommonRegistrar.lambda$getComponents$3((Context) obj);
    }
}
