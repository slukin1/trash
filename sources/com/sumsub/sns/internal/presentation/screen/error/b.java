package com.sumsub.sns.internal.presentation.screen.error;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.savedstate.c;
import com.sumsub.sns.internal.core.a;
import kotlin.jvm.internal.r;

public final class b extends AbstractSavedStateViewModelFactory {

    /* renamed from: a  reason: collision with root package name */
    public final a f35261a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f35262b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(c cVar, a aVar, Bundle bundle, int i11, r rVar) {
        this(cVar, aVar, (i11 & 4) != 0 ? null : bundle);
    }

    /* JADX WARNING: type inference failed for: r9v6, types: [com.sumsub.sns.internal.core.data.model.o] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T extends androidx.lifecycle.ViewModel> T create(java.lang.String r7, java.lang.Class<T> r8, androidx.lifecycle.SavedStateHandle r9) {
        /*
            r6 = this;
            com.sumsub.sns.internal.presentation.screen.error.a r7 = new com.sumsub.sns.internal.presentation.screen.error.a
            android.os.Bundle r8 = r6.f35262b
            r9 = 0
            if (r8 == 0) goto L_0x000e
            java.lang.String r0 = "arg_error"
            java.io.Serializable r8 = r8.getSerializable(r0)
            goto L_0x000f
        L_0x000e:
            r8 = r9
        L_0x000f:
            boolean r0 = r8 instanceof com.sumsub.sns.internal.core.data.model.o
            if (r0 == 0) goto L_0x0016
            r9 = r8
            com.sumsub.sns.internal.core.data.model.o r9 = (com.sumsub.sns.internal.core.data.model.o) r9
        L_0x0016:
            if (r9 != 0) goto L_0x0023
            com.sumsub.sns.internal.core.data.model.o$c r9 = new com.sumsub.sns.internal.core.data.model.o$c
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 7
            r5 = 0
            r0 = r9
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x0023:
            com.sumsub.sns.internal.core.a r8 = r6.f35261a
            com.sumsub.sns.internal.core.data.source.extensions.a r8 = r8.q()
            com.sumsub.sns.internal.core.a r0 = r6.f35261a
            com.sumsub.sns.internal.core.data.source.common.a r0 = r0.n()
            com.sumsub.sns.internal.core.a r1 = r6.f35261a
            com.sumsub.sns.internal.core.data.source.dynamic.b r1 = r1.p()
            r7.<init>(r9, r8, r0, r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.error.b.create(java.lang.String, java.lang.Class, androidx.lifecycle.SavedStateHandle):androidx.lifecycle.ViewModel");
    }

    public b(c cVar, a aVar, Bundle bundle) {
        super(cVar, bundle);
        this.f35261a = aVar;
        this.f35262b = bundle;
    }
}
