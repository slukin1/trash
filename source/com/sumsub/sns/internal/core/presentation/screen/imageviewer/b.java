package com.sumsub.sns.internal.core.presentation.screen.imageviewer;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.c;
import com.sumsub.sns.internal.core.a;
import kotlin.jvm.internal.r;

public final class b extends AbstractSavedStateViewModelFactory {

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f33906a;

    /* renamed from: b  reason: collision with root package name */
    public final a f33907b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(c cVar, Bundle bundle, a aVar, int i11, r rVar) {
        this(cVar, (i11 & 2) != 0 ? null : bundle, aVar);
    }

    public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
        return new a(this.f33906a, this.f33907b.n(), this.f33907b.p());
    }

    public b(c cVar, Bundle bundle, a aVar) {
        super(cVar, bundle);
        this.f33906a = bundle;
        this.f33907b = aVar;
    }
}
