package com.sumsub.sns.internal.presentation.screen.preview.applicantdata;

import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.g;
import java.util.Iterator;
import kotlin.jvm.internal.x;

public final class d {
    public static final g.c.a b(g gVar, DocumentType documentType) {
        T t11;
        Iterator<T> it2 = gVar.I().g().iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            if (x.b(((g.c.a) t11).m(), documentType)) {
                break;
            }
        }
        return (g.c.a) t11;
    }
}
