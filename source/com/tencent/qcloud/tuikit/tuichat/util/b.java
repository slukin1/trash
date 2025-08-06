package com.tencent.qcloud.tuikit.tuichat.util;

import androidx.datastore.preferences.core.Preferences;
import j00.h;

public final /* synthetic */ class b implements h {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Preferences.a f48598b;

    public /* synthetic */ b(Preferences.a aVar) {
        this.f48598b = aVar;
    }

    public final Object apply(Object obj) {
        return DataStoreUtil.lambda$getValueAsync$1(this.f48598b, (Preferences) obj);
    }
}
