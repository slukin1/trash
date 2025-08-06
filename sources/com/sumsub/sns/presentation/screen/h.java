package com.sumsub.sns.presentation.screen;

import android.os.Bundle;
import android.os.Parcelable;
import com.sumsub.sns.core.presentation.b;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.core.presentation.base.a.l;
import com.sumsub.sns.internal.core.common.k0;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.domain.model.c;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u001a\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J#\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/sumsub/sns/presentation/screen/h;", "Lcom/sumsub/sns/core/presentation/base/a$l;", "S", "Lcom/sumsub/sns/core/presentation/base/a;", "VM", "Lcom/sumsub/sns/core/presentation/b;", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewModelPrepared", "", "success", "Landroid/os/Parcelable;", "payload", "a", "Lcom/sumsub/sns/internal/core/domain/model/c;", "introParams", "(Lcom/sumsub/sns/internal/core/domain/model/c;Landroid/os/Parcelable;)Lkotlin/Unit;", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public abstract class h<S extends a.l, VM extends a<S>> extends b<S, VM> {
    public static final void a(h hVar, String str, Bundle bundle) {
        hVar.a(b.Companion.b(bundle), bundle.getParcelable("payload"));
    }

    public void a(boolean z11, Parcelable parcelable) {
    }

    public void onViewModelPrepared(Bundle bundle) {
        super.onViewModelPrepared(bundle);
        requireActivity().getSupportFragmentManager().H1(n0.f32116d, this, new k(this));
    }

    public static /* synthetic */ Unit a(h hVar, c cVar, Parcelable parcelable, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                parcelable = null;
            }
            return hVar.a(cVar, parcelable);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showInstructions");
    }

    public final Unit a(c cVar, Parcelable parcelable) {
        k0 appListener = getAppListener();
        if (appListener == null) {
            return null;
        }
        appListener.a(cVar, parcelable);
        return Unit.f56620a;
    }
}
