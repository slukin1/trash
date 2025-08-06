package com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.sumsub.sns.internal.core.a;
import com.sumsub.sns.internal.domain.h;
import kotlin.jvm.internal.r;

public final class c extends AbstractSavedStateViewModelFactory {

    /* renamed from: a  reason: collision with root package name */
    public final a f36204a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(androidx.savedstate.c cVar, a aVar, Bundle bundle, int i11, r rVar) {
        this(cVar, aVar, (i11 & 4) != 0 ? null : bundle);
    }

    public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
        return new b(savedStateHandle, new h(this.f36204a.h(), this.f36204a.n()), this.f36204a.n(), this.f36204a.p());
    }

    public c(androidx.savedstate.c cVar, a aVar, Bundle bundle) {
        super(cVar, bundle);
        this.f36204a = aVar;
    }
}
