package com.sumsub.sns.internal.camera.photo.presentation.selfie;

import com.sumsub.sns.internal.camera.b;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.data.model.g;
import com.sumsub.sns.internal.core.presentation.intro.f;
import com.sumsub.sns.internal.log.c;
import java.util.List;
import kotlin.jvm.internal.r;

public final class a extends b {
    public a(DocumentType documentType, com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar, boolean z11) {
        super(documentType, (String) null, z11, aVar, bVar, 2, (r) null);
    }

    public com.sumsub.sns.internal.core.presentation.helper.camera.b a(g gVar, f fVar, String str) {
        com.sumsub.log.logger.a.c(com.sumsub.sns.internal.log.a.f34862a, c.a(this), "Selfie With Document Picker", (Throwable) null, 4, (Object) null);
        return com.sumsub.sns.internal.core.presentation.helper.camera.a.a(com.sumsub.sns.internal.core.presentation.helper.camera.a.f33847a, h(), u(), gVar.a(u()), fVar, str, (List) null, (IdentitySide) null, 96, (Object) null);
    }
}
