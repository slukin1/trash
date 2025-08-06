package com.tencent.qcloud.tuikit.tuichat.util;

import androidx.datastore.preferences.core.Preferences;
import j00.h;

public final /* synthetic */ class c implements h {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f48599b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Preferences.a f48600c;

    public /* synthetic */ c(Object obj, Preferences.a aVar) {
        this.f48599b = obj;
        this.f48600c = aVar;
    }

    public final Object apply(Object obj) {
        return DataStoreUtil.lambda$putValue$2(this.f48599b, this.f48600c, (Preferences) obj);
    }
}
