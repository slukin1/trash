package com.tencent.qcloud.tuikit.tuichat.util;

import androidx.datastore.preferences.core.Preferences;
import j00.h;

public final /* synthetic */ class a implements h {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Preferences.a f48597b;

    public /* synthetic */ a(Preferences.a aVar) {
        this.f48597b = aVar;
    }

    public final Object apply(Object obj) {
        return DataStoreUtil.lambda$getValue$0(this.f48597b, (Preferences) obj);
    }
}
