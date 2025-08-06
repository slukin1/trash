package com.sumsub.sns.internal.camera.photo.presentation.selfie;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.c;
import com.sumsub.sns.internal.core.a;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import kotlin.jvm.internal.r;

public final class b extends AbstractSavedStateViewModelFactory {

    /* renamed from: a  reason: collision with root package name */
    public final a f31756a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(c cVar, a aVar, Bundle bundle, int i11, r rVar) {
        this(cVar, aVar, (i11 & 4) != 0 ? null : bundle);
    }

    public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
        DocumentType a11 = DocumentType.Companion.a((String) savedStateHandle.f(com.sumsub.sns.internal.camera.a.f31319c));
        com.sumsub.sns.internal.core.data.source.common.a n11 = this.f31756a.n();
        com.sumsub.sns.internal.core.data.source.dynamic.b p11 = this.f31756a.p();
        Boolean bool = (Boolean) savedStateHandle.f(com.sumsub.sns.internal.camera.a.f31323g);
        return new a(a11, n11, p11, bool != null ? bool.booleanValue() : false);
    }

    public b(c cVar, a aVar, Bundle bundle) {
        super(cVar, bundle);
        this.f31756a = aVar;
    }
}
