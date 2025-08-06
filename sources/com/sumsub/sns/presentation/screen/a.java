package com.sumsub.sns.presentation.screen;

import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.VideoRequiredType;
import com.sumsub.sns.internal.core.data.model.g;
import com.sumsub.sns.internal.core.domain.model.c;
import com.sumsub.sns.presentation.screen.b;
import kotlin.jvm.internal.x;

public final class a {
    public static /* synthetic */ b.d a(Document document, g gVar, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return a(document, gVar, z11);
    }

    public static final b.d a(Document document, g gVar, boolean z11) {
        if (document.getType().g()) {
            return new b.d.i(document);
        }
        if (document.getType().f()) {
            return new b.d.C0524d(document);
        }
        if (document.getType().i()) {
            return new b.d.e(document);
        }
        c cVar = null;
        if (document.getType().j()) {
            b.d.n nVar = new b.d.n(document);
            c b11 = nVar.b();
            if (b11 != null) {
                cVar = c.a(b11, (String) null, (String) null, (String) null, z11, 7, (Object) null);
            }
            nVar.a(cVar);
            return nVar;
        } else if (document.getType().k()) {
            b.d a11 = a(gVar, document);
            c b12 = a11.b();
            if (b12 != null) {
                cVar = c.a(b12, (String) null, (String) null, (String) null, z11, 7, (Object) null);
            }
            a11.a(cVar);
            return a11;
        } else if (document.getType().d()) {
            return new b.d.C0523b(document);
        } else {
            if (document.getType().h()) {
                g.c.a a12 = gVar.a(document.getType());
                boolean z12 = true;
                if (a12 == null || !a12.t()) {
                    z12 = false;
                }
                if (z12) {
                    return new b.d.g(document);
                }
                return new b.d.m(document);
            } else if (document.getType().e()) {
                return new b.d.f(document);
            } else {
                return new b.d.j(document);
            }
        }
    }

    public static final b.d a(g gVar, Document document) {
        g.c.a a11 = gVar.a(document.getType());
        boolean z11 = false;
        if (a11 != null && a11.w()) {
            return new b.d.k(document);
        }
        if (a11 != null && a11.v()) {
            z11 = true;
        }
        if (z11) {
            return new b.d.j(document);
        }
        if (x.b(a11 != null ? a11.r() : null, VideoRequiredType.Enabled.getValue())) {
            return new b.d.l(document);
        }
        return new b.d.h(document);
    }
}
