package com.sumsub.sns.internal.presentation.screen.preview.applicantdata;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.sumsub.sns.internal.core.a;
import com.sumsub.sns.internal.core.common.a1;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.domain.d;
import com.sumsub.sns.internal.domain.m;
import kotlin.jvm.internal.r;

public final class c extends AbstractSavedStateViewModelFactory {

    /* renamed from: a  reason: collision with root package name */
    public final Document f35373a;

    /* renamed from: b  reason: collision with root package name */
    public final a f35374b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Document document, androidx.savedstate.c cVar, a aVar, Bundle bundle, int i11, r rVar) {
        this(document, cVar, aVar, (i11 & 8) != 0 ? null : bundle);
    }

    public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
        return new b(this.f35373a, savedStateHandle, this.f35374b.n(), this.f35374b.p(), new m(this.f35374b), new d(this.f35374b.n(), this.f35374b.p()), new a1());
    }

    public c(Document document, androidx.savedstate.c cVar, a aVar, Bundle bundle) {
        super(cVar, bundle);
        this.f35373a = document;
        this.f35374b = aVar;
    }
}
