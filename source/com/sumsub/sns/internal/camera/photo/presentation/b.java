package com.sumsub.sns.internal.camera.photo.presentation;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.c;
import com.sumsub.sns.internal.core.a;
import com.sumsub.sns.internal.core.domain.d;
import com.sumsub.sns.internal.core.domain.g;
import kotlin.jvm.internal.r;

public final class b extends AbstractSavedStateViewModelFactory {

    /* renamed from: a  reason: collision with root package name */
    public final String f31484a;

    /* renamed from: b  reason: collision with root package name */
    public final a f31485b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(c cVar, String str, a aVar, Bundle bundle, int i11, r rVar) {
        this(cVar, str, aVar, (i11 & 8) != 0 ? null : bundle);
    }

    public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
        return new a(this.f31484a, this.f31485b.q(), new d(this.f31485b.n(), this.f31485b.p()), new g(this.f31485b), this.f31485b.n(), this.f31485b.p());
    }

    public b(c cVar, String str, a aVar, Bundle bundle) {
        super(cVar, bundle);
        this.f31484a = str;
        this.f31485b = aVar;
    }
}
