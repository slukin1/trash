package com.sumsub.sns.presentation.screen.preview;

import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.common.k0;
import com.sumsub.sns.internal.presentation.screen.preview.a;
import com.sumsub.sns.internal.presentation.screen.preview.a.d;
import com.sumsub.sns.presentation.screen.h;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0015¨\u0006\f"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/a;", "Lcom/sumsub/sns/internal/presentation/screen/preview/a$d;", "S", "Lcom/sumsub/sns/internal/presentation/screen/preview/a;", "VM", "Lcom/sumsub/sns/presentation/screen/h;", "Lcom/sumsub/sns/core/presentation/base/a$j;", "event", "", "handleEvent", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public abstract class a<S extends a.d, VM extends com.sumsub.sns.internal.presentation.screen.preview.a<S>> extends h<S, VM> {
    public void handleEvent(a.j jVar) {
        if (jVar instanceof a.b) {
            k0 appListener = getAppListener();
            if (appListener != null) {
                appListener.a(((a.b) jVar).b().getType());
                return;
            }
            return;
        }
        super.handleEvent(jVar);
    }
}
