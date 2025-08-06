package com.sumsub.sns.internal.videoident.presentation;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.c;
import com.sumsub.sns.internal.core.a;
import kotlin.jvm.internal.r;

public final class b extends AbstractSavedStateViewModelFactory {

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f36679a;

    /* renamed from: b  reason: collision with root package name */
    public final a f36680b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(c cVar, Bundle bundle, a aVar, int i11, r rVar) {
        this(cVar, (i11 & 2) != 0 ? null : bundle, aVar);
    }

    public final Bundle a() {
        return this.f36679a;
    }

    public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
        Bundle bundle = this.f36679a;
        if (bundle != null) {
            return new a(bundle, this.f36680b.n(), this.f36680b.p());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public b(c cVar, Bundle bundle, a aVar) {
        super(cVar, bundle);
        this.f36679a = bundle;
        this.f36680b = aVar;
    }
}
