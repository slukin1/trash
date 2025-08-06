package com.sumsub.sns.core.presentation;

import androidx.fragment.app.Fragment;
import com.sumsub.sns.internal.core.analytics.Screen;
import d10.l;
import java.util.ArrayList;
import java.util.List;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f30925a = new c();

    /* renamed from: b  reason: collision with root package name */
    public static final List<l<Fragment, Screen>> f30926b = new ArrayList();

    public final void a(l<? super Fragment, ? extends Screen> lVar) {
        f30926b.add(lVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        r4 = (com.sumsub.sns.internal.core.analytics.Screen) r1.invoke(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.sumsub.sns.internal.core.analytics.Screen a(androidx.fragment.app.Fragment r4) {
        /*
            r3 = this;
            java.util.List<d10.l<androidx.fragment.app.Fragment, com.sumsub.sns.internal.core.analytics.Screen>> r0 = f30926b
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x001f
            java.lang.Object r1 = r0.next()
            r2 = r1
            d10.l r2 = (d10.l) r2
            java.lang.Object r2 = r2.invoke(r4)
            if (r2 == 0) goto L_0x001b
            r2 = 1
            goto L_0x001c
        L_0x001b:
            r2 = 0
        L_0x001c:
            if (r2 == 0) goto L_0x0006
            goto L_0x0020
        L_0x001f:
            r1 = 0
        L_0x0020:
            d10.l r1 = (d10.l) r1
            if (r1 == 0) goto L_0x002d
            java.lang.Object r4 = r1.invoke(r4)
            com.sumsub.sns.internal.core.analytics.Screen r4 = (com.sumsub.sns.internal.core.analytics.Screen) r4
            if (r4 == 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            com.sumsub.sns.internal.core.analytics.Screen r4 = com.sumsub.sns.internal.core.analytics.Screen.Other
        L_0x002f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.c.a(androidx.fragment.app.Fragment):com.sumsub.sns.internal.core.analytics.Screen");
    }
}
