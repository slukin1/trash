package com.sumsub.sns.internal.camera.photo.presentation.document;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.c;
import com.sumsub.sns.internal.core.a;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import com.sumsub.sns.internal.ml.autocapture.SeamlessDocaptureMobileConfig;
import com.sumsub.sns.internal.ml.autocapture.a;
import com.sumsub.sns.internal.ml.core.e;
import kotlin.Unit;
import kotlin.jvm.internal.r;

public final class d extends AbstractSavedStateViewModelFactory {

    /* renamed from: a  reason: collision with root package name */
    public final a f31753a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(c cVar, a aVar, Bundle bundle, int i11, r rVar) {
        this(cVar, aVar, (i11 & 4) != 0 ? null : bundle);
    }

    public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
        SavedStateHandle savedStateHandle2 = savedStateHandle;
        a.b bVar = com.sumsub.sns.internal.ml.autocapture.a.f34920m;
        com.sumsub.sns.internal.ml.autocapture.a a11 = bVar.a();
        a.C0405a m11 = a11.m();
        DocumentType a12 = DocumentType.Companion.a((String) savedStateHandle2.f(com.sumsub.sns.internal.camera.a.f31319c));
        String str2 = (String) savedStateHandle2.f(com.sumsub.sns.internal.camera.a.f31321e);
        com.sumsub.sns.internal.core.data.source.common.a n11 = this.f31753a.n();
        b p11 = this.f31753a.p();
        e<Bitmap, com.sumsub.sns.internal.ml.badphotos.models.a> a13 = com.sumsub.sns.internal.ml.badphotos.a.f34946p.a(this.f31753a.j(), this.f31753a.l(), this.f31753a.E().getUrl(), true, a12);
        com.sumsub.sns.internal.ml.badphotos.a aVar = a13 instanceof com.sumsub.sns.internal.ml.badphotos.a ? (com.sumsub.sns.internal.ml.badphotos.a) a13 : null;
        Context j11 = this.f31753a.j();
        com.sumsub.sns.internal.ml.docdetector.b bVar2 = new com.sumsub.sns.internal.ml.docdetector.b(j11, this.f31753a.l(), this.f31753a.E().getUrl() + "resources/embeddedModels/" + a11.m().b(), m11);
        b bVar3 = b.f31751a;
        b.b(bVar3, DocCapture.f31492c, "autocap config: inputSize=" + m11.i() + ", outputSize=" + m11.j(), (Throwable) null, 4, (Object) null);
        Unit unit = Unit.f56620a;
        com.sumsub.sns.internal.ml.badphotos.c a14 = com.sumsub.sns.internal.ml.badphotos.c.f34958h.a();
        com.sumsub.sns.internal.ml.autocapture.a a15 = bVar.a();
        SeamlessDocaptureMobileConfig a16 = SeamlessDocaptureMobileConfig.f34911f.a();
        Boolean bool = (Boolean) savedStateHandle2.f(com.sumsub.sns.internal.camera.a.f31323g);
        return new SNSPhotoDocumentPickerViewModel(a12, str2, n11, p11, aVar, bVar2, a14, a15, a16, savedStateHandle, bool != null ? bool.booleanValue() : false);
    }

    public d(c cVar, com.sumsub.sns.internal.core.a aVar, Bundle bundle) {
        super(cVar, bundle);
        this.f31753a = aVar;
    }
}
