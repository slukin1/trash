package com.jumio.sdk.views;

import android.content.Context;
import android.util.AttributeSet;
import jumio.core.h2;
import jumio.core.t;
import kotlin.jvm.internal.r;

public final class JumioRejectView extends t<h2> {
    public JumioRejectView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    public JumioRejectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public JumioRejectView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JumioRejectView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
    }

    public JumioRejectView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11);
        setCornerRadius(i12);
    }
}
