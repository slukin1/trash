package com.huobi.zeroswap.vm;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.o0;
import androidx.lifecycle.viewmodel.CreationExtras;
import java.lang.ref.WeakReference;

public final class b implements ViewModelProvider.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Context> f21244a;

    /* renamed from: b  reason: collision with root package name */
    public final Application f21245b;

    public b(WeakReference<Context> weakReference, Application application) {
        this.f21244a = weakReference;
        this.f21245b = application;
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        if (cls.isAssignableFrom(ZeroSwapViewModel.class)) {
            return new ZeroSwapViewModel(this.f21244a, this.f21245b);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return o0.b(this, cls, creationExtras);
    }
}
