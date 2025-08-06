package com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid;

import com.sumsub.sns.core.data.model.SNSGeneralException;
import kotlin.jvm.internal.r;

public class f extends SNSGeneralException {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f35638a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(boolean z11, String str, String str2, int i11, r rVar) {
        this(z11, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : str2);
    }

    public final boolean a() {
        return this.f35638a;
    }

    public f(boolean z11, String str, String str2) {
        super(str, str2);
        this.f35638a = z11;
    }
}
