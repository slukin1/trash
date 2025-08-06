package com.sumsub.sns.presentation.screen;

import com.sumsub.sns.core.data.model.FlowActionType;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.g;
import com.sumsub.sns.presentation.screen.b;
import kotlin.jvm.internal.x;

public final class f {
    public static final b.d b(g gVar, Document document) {
        if (x.b(FlowActionType.Companion.get(gVar.L()), FlowActionType.FaceEnrollment.INSTANCE)) {
            return a.a(document, gVar, true);
        }
        return null;
    }
}
