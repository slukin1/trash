package com.sumsub.sns.presentation.screen;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.c;
import com.sumsub.sns.internal.core.a;
import com.sumsub.sns.internal.core.domain.p;
import com.sumsub.sns.internal.domain.g;
import kotlin.jvm.internal.r;

public final class e extends AbstractSavedStateViewModelFactory {

    /* renamed from: a  reason: collision with root package name */
    public final a f39768a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(c cVar, a aVar, Bundle bundle, int i11, r rVar) {
        this(cVar, aVar, (i11 & 4) != 0 ? null : bundle);
    }

    public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
        return new d(savedStateHandle, new g(this.f39768a), new com.sumsub.sns.internal.domain.e(this.f39768a.n(), this.f39768a.p(), d.P), new p(this.f39768a), this.f39768a.n(), this.f39768a.F(), this.f39768a.p(), this.f39768a.g());
    }

    public e(c cVar, a aVar, Bundle bundle) {
        super(cVar, bundle);
        this.f39768a = aVar;
    }
}
