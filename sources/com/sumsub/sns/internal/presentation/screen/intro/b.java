package com.sumsub.sns.internal.presentation.screen.intro;

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
    public final a f35278a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f35279b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(c cVar, a aVar, Bundle bundle, int i11, r rVar) {
        this(cVar, aVar, (i11 & 4) != 0 ? null : bundle);
    }

    public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
        String str2;
        String str3;
        String string;
        String string2;
        Bundle bundle = this.f35279b;
        if (bundle == null || (str2 = bundle.getString(a.f35264w)) == null) {
            str2 = DocumentType.f32355j;
        }
        String str4 = str2;
        Bundle bundle2 = this.f35279b;
        String string3 = bundle2 != null ? bundle2.getString(a.f35265x) : null;
        Bundle bundle3 = this.f35279b;
        String str5 = (bundle3 == null || (string2 = bundle3.getString(a.f35266y)) == null) ? "" : string2;
        com.sumsub.sns.internal.core.data.source.common.a n11 = this.f35278a.n();
        com.sumsub.sns.internal.core.data.source.dynamic.b p11 = this.f35278a.p();
        Bundle bundle4 = this.f35279b;
        if (bundle4 == null || (string = bundle4.getString(a.f35267z)) == null) {
            str3 = "";
        } else {
            str3 = string;
        }
        Bundle bundle5 = this.f35279b;
        return new a(str4, string3, str5, str3, bundle5 != null ? bundle5.getBoolean(a.A) : false, n11, p11);
    }

    public b(c cVar, a aVar, Bundle bundle) {
        super(cVar, bundle);
        this.f35278a = aVar;
        this.f35279b = bundle;
    }
}
