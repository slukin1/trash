package com.sumsub.sns.internal.presentation.screen.preview.photo.common;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.c;
import com.sumsub.sns.internal.core.a;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.domain.d;
import com.sumsub.sns.internal.domain.o;
import kotlin.jvm.internal.r;

public final class b extends AbstractSavedStateViewModelFactory {

    /* renamed from: a  reason: collision with root package name */
    public final Document f36098a;

    /* renamed from: b  reason: collision with root package name */
    public final a f36099b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Document document, c cVar, a aVar, Bundle bundle, int i11, r rVar) {
        this(document, cVar, aVar, (i11 & 8) != 0 ? null : bundle);
    }

    public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
        return new a(this.f36098a, savedStateHandle, new o(this.f36099b), this.f36099b.n(), this.f36099b.p(), this.f36099b.q(), this.f36099b.D(), com.sumsub.sns.internal.ml.badphotos.a.f34946p.a(this.f36099b.j(), this.f36099b.l(), this.f36099b.E().getUrl(), com.sumsub.sns.internal.ff.a.f34215a.C().g(), this.f36098a.getType()), new d(this.f36099b.n(), this.f36099b.p()));
    }

    public b(Document document, c cVar, a aVar, Bundle bundle) {
        super(cVar, bundle);
        this.f36098a = document;
        this.f36099b = aVar;
    }
}
