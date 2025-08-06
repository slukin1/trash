package com.sumsub.sns.internal.geo.presentation;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.c;
import com.sumsub.sns.core.SNSCoreModule;
import com.sumsub.sns.core.SNSModule;
import com.sumsub.sns.internal.core.a;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import kotlin.jvm.internal.r;

public final class d extends AbstractSavedStateViewModelFactory {

    /* renamed from: a  reason: collision with root package name */
    public final a f34846a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(c cVar, a aVar, Bundle bundle, int i11, r rVar) {
        this(cVar, aVar, (i11 & 4) != 0 ? null : bundle);
    }

    public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
        com.sumsub.sns.internal.core.data.source.common.a n11 = this.f34846a.n();
        b p11 = this.f34846a.p();
        com.sumsub.sns.internal.geo.domain.b bVar = new com.sumsub.sns.internal.geo.domain.b(this.f34846a.h(), this.f34846a.n(), this.f34846a.p(), this.f34846a.t());
        com.sumsub.sns.internal.geo.domain.c cVar = new com.sumsub.sns.internal.geo.domain.c(this.f34846a.h(), this.f34846a.F(), this.f34846a.n());
        SNSModule pluggedModule = e0.f32018a.getPluggedModule(SNSCoreModule.class.getName());
        SNSCoreModule sNSCoreModule = pluggedModule instanceof SNSCoreModule ? (SNSCoreModule) pluggedModule : null;
        boolean z11 = sNSCoreModule != null && sNSCoreModule.isSkipGeolocationForm();
        com.sumsub.sns.internal.core.domain.d dVar = new com.sumsub.sns.internal.core.domain.d(this.f34846a.n(), this.f34846a.p());
        Object f11 = savedStateHandle.f("ARGS_DOCUMENT");
        if (f11 != null) {
            return new c(savedStateHandle, n11, p11, bVar, cVar, z11, dVar, (Document) f11);
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public d(c cVar, a aVar, Bundle bundle) {
        super(cVar, bundle);
        this.f34846a = aVar;
    }
}
