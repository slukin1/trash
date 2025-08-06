package com.sumsub.sns.internal.presentation.screen.preview.selfie;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.c;
import com.sumsub.sns.internal.core.a;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.domain.d;
import com.sumsub.sns.internal.domain.q;
import kotlin.jvm.internal.r;

public final class b extends AbstractSavedStateViewModelFactory {

    /* renamed from: a  reason: collision with root package name */
    public final Document f36234a;

    /* renamed from: b  reason: collision with root package name */
    public final a f36235b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Document document, c cVar, a aVar, Bundle bundle, int i11, r rVar) {
        this(document, cVar, aVar, (i11 & 8) != 0 ? null : bundle);
    }

    public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
        return new a(this.f36234a, savedStateHandle, this.f36235b.n(), this.f36235b.p(), new q(this.f36235b), new d(this.f36235b.n(), this.f36235b.p()));
    }

    public b(Document document, c cVar, a aVar, Bundle bundle) {
        super(cVar, bundle);
        this.f36234a = document;
        this.f36235b = aVar;
    }
}
