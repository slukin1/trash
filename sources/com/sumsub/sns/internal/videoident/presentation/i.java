package com.sumsub.sns.internal.videoident.presentation;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.c;
import com.sumsub.sns.internal.core.a;
import com.sumsub.sns.internal.core.common.c1;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.domain.j;
import com.sumsub.sns.internal.videoident.videoident.domain.b;
import com.sumsub.sns.internal.videoident.videoident.domain.d;
import com.sumsub.sns.internal.videoident.videoident.domain.e;
import java.util.List;
import kotlin.jvm.internal.r;

public final class i extends AbstractSavedStateViewModelFactory {

    /* renamed from: a  reason: collision with root package name */
    public final List<Document> f36972a;

    /* renamed from: b  reason: collision with root package name */
    public final a f36973b;

    /* renamed from: c  reason: collision with root package name */
    public final g f36974c;

    /* renamed from: d  reason: collision with root package name */
    public final c1 f36975d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(List list, c cVar, a aVar, Bundle bundle, g gVar, c1 c1Var, int i11, r rVar) {
        this(list, cVar, aVar, (i11 & 8) != 0 ? null : bundle, gVar, c1Var);
    }

    public final List<Document> a() {
        return this.f36972a;
    }

    public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
        return new h(this.f36972a, this.f36973b.t(), this.f36973b.n(), this.f36973b.p(), savedStateHandle, new d(this.f36973b.F(), this.f36973b.n(), this.f36973b.h()), new e(this.f36973b.F(), this.f36973b.n(), this.f36973b.h()), new com.sumsub.sns.internal.videoident.videoident.domain.c(this.f36973b.n(), this.f36973b.h(), this.f36973b.p()), new b(this.f36973b.n(), this.f36973b.h(), this.f36973b.p()), new com.sumsub.sns.internal.videoident.videoident.domain.a(this.f36973b.n(), this.f36973b.h()), new j(this.f36973b.n()), this.f36974c, this.f36975d, this.f36973b.g());
    }

    public i(List<Document> list, c cVar, a aVar, Bundle bundle, g gVar, c1 c1Var) {
        super(cVar, bundle);
        this.f36972a = list;
        this.f36973b = aVar;
        this.f36974c = gVar;
        this.f36975d = c1Var;
    }
}
