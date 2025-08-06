package com.sumsub.sns.internal.camera.video.presentation;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.c;
import com.sumsub.sns.internal.core.domain.f;
import com.sumsub.sns.internal.core.domain.k;
import kotlin.jvm.internal.r;

public final class a extends AbstractSavedStateViewModelFactory {

    /* renamed from: a  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.a f31821a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f31822b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(c cVar, com.sumsub.sns.internal.core.a aVar, Bundle bundle, int i11, r rVar) {
        this(cVar, aVar, (i11 & 4) != 0 ? null : bundle);
    }

    public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
        f fVar = new f(this.f31821a);
        k kVar = new k(this.f31821a);
        Bundle bundle = this.f31822b;
        String string = bundle != null ? bundle.getString("EXTRA_ID_DOC_SET_TYPE") : null;
        Bundle bundle2 = this.f31822b;
        return new SNSVideoSelfieViewModel(fVar, kVar, string, bundle2 != null ? bundle2.getString(SNSVideoSelfieViewModel.E) : null, this.f31821a.n(), this.f31821a.p());
    }

    public a(c cVar, com.sumsub.sns.internal.core.a aVar, Bundle bundle) {
        super(cVar, bundle);
        this.f31821a = aVar;
        this.f31822b = bundle;
    }
}
