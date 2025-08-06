package com.sumsub.sns.core.presentation.support;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.o0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.sumsub.sns.internal.core.a;

public final class c implements ViewModelProvider.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final a f31201a;

    public c(a aVar) {
        this.f31201a = aVar;
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        return new b(this.f31201a.q(), this.f31201a.n(), this.f31201a.p());
    }

    public /* bridge */ /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return o0.b(this, cls, creationExtras);
    }
}
