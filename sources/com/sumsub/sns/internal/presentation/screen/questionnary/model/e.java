package com.sumsub.sns.internal.presentation.screen.questionnary.model;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.c;
import com.sumsub.sns.internal.core.a;
import com.sumsub.sns.internal.core.data.source.applicant.b;
import com.sumsub.sns.internal.core.data.source.applicant.remote.w;
import com.sumsub.sns.internal.core.data.source.applicant.remote.y;
import com.sumsub.sns.internal.core.domain.d;
import com.sumsub.sns.internal.domain.i;
import com.sumsub.sns.internal.domain.k;
import com.sumsub.sns.internal.domain.o;
import kotlin.jvm.internal.r;

public final class e extends AbstractSavedStateViewModelFactory {

    /* renamed from: a  reason: collision with root package name */
    public final a f36333a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f36334b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(c cVar, a aVar, Bundle bundle, int i11, r rVar) {
        this(cVar, aVar, (i11 & 4) != 0 ? null : bundle);
    }

    public final Bundle a() {
        return this.f36334b;
    }

    public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
        i iVar = new i(this.f36333a);
        k kVar = new k();
        com.sumsub.sns.internal.core.data.source.common.a n11 = this.f36333a.n();
        b g11 = this.f36333a.g();
        com.sumsub.sns.internal.core.data.source.dynamic.b p11 = this.f36333a.p();
        d dVar = new d(this.f36333a.n(), this.f36333a.p());
        o oVar = new o(this.f36333a);
        com.sumsub.sns.internal.domain.d dVar2 = new com.sumsub.sns.internal.domain.d(this.f36333a.n(), this.f36333a.g());
        Bundle bundle = this.f36334b;
        w wVar = bundle != null ? (w) bundle.getParcelable("QUESTIONNAIRE") : null;
        Bundle bundle2 = this.f36334b;
        y yVar = bundle2 != null ? (y) bundle2.getParcelable(d.P) : null;
        Bundle bundle3 = this.f36334b;
        return new d(savedStateHandle, iVar, kVar, oVar, dVar2, n11, g11, p11, dVar, wVar, yVar, bundle3 != null ? (com.sumsub.sns.internal.core.presentation.form.model.d) bundle3.getParcelable(d.Q) : null);
    }

    public e(c cVar, a aVar, Bundle bundle) {
        super(cVar, bundle);
        this.f36333a = aVar;
        this.f36334b = bundle;
    }
}
