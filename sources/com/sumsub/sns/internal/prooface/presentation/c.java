package com.sumsub.sns.internal.prooface.presentation;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.sumsub.sns.internal.core.a;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.q;
import com.sumsub.sns.internal.core.domain.o;
import com.sumsub.sns.prooface.network.Liveness3dFaceRepository;
import com.sumsub.sns.prooface.network.b;
import kotlin.jvm.internal.r;
import okhttp3.OkHttpClient;

public final class c extends AbstractSavedStateViewModelFactory {

    /* renamed from: a  reason: collision with root package name */
    public final a f36605a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(androidx.savedstate.c cVar, a aVar, Bundle bundle, int i11, r rVar) {
        this(cVar, aVar, (i11 & 4) != 0 ? null : bundle);
    }

    public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
        o r11 = this.f36605a.r();
        String str2 = (String) savedStateHandle.f("EXTRA_ID_DOC_SET_TYPE");
        if (str2 == null) {
            str2 = DocumentType.f32355j;
        }
        DocumentType documentType = new DocumentType(str2);
        kotlinx.serialization.json.a t11 = this.f36605a.t();
        b bVar = new b();
        OkHttpClient w11 = this.f36605a.w();
        String str3 = (String) savedStateHandle.f("EXTRA_ID_DOC_SET_TYPE");
        if (str3 == null) {
            str3 = q.g.f32693f.b();
        }
        return new b(r11, documentType, t11, bVar, new Liveness3dFaceRepository(w11, str3, this.f36605a.E(), this.f36605a.t(), this.f36605a.G()), this.f36605a.F(), this.f36605a.n(), this.f36605a.p(), this.f36605a.s());
    }

    public c(androidx.savedstate.c cVar, a aVar, Bundle bundle) {
        super(cVar, bundle);
        this.f36605a = aVar;
    }
}
