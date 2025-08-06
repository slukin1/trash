package com.sumsub.sns.internal.presentation.screen.preview.photo.identity;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.c;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.domain.d;
import com.sumsub.sns.internal.domain.o;
import kotlin.jvm.internal.r;

public final class a extends AbstractSavedStateViewModelFactory {

    /* renamed from: a  reason: collision with root package name */
    public final Document f36133a;

    /* renamed from: b  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.a f36134b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Document document, c cVar, com.sumsub.sns.internal.core.a aVar, Bundle bundle, int i11, r rVar) {
        this(document, cVar, aVar, (i11 & 8) != 0 ? null : bundle);
    }

    public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
        return new SNSPreviewIdentityDocumentViewModel(this.f36133a, savedStateHandle, new o(this.f36134b), this.f36134b.n(), this.f36134b.p(), this.f36134b.q(), this.f36134b.D(), com.sumsub.sns.internal.ml.badphotos.a.f34946p.a(this.f36134b.j(), this.f36134b.l(), this.f36134b.E().getUrl(), com.sumsub.sns.internal.ff.a.f34215a.C().g(), this.f36133a.getType()), new d(this.f36134b.n(), this.f36134b.p()));
    }

    public a(Document document, c cVar, com.sumsub.sns.internal.core.a aVar, Bundle bundle) {
        super(cVar, bundle);
        this.f36133a = document;
        this.f36134b = aVar;
    }
}
