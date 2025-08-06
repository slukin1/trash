package com.sumsub.sns.internal.presentation.screen.preview.photo.common;

import android.graphics.Bitmap;
import androidx.lifecycle.SavedStateHandle;
import com.sumsub.sns.internal.core.common.o0;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import com.sumsub.sns.internal.domain.o;
import com.sumsub.sns.internal.ml.core.e;
import com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModel;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

public final class a extends SNSPreviewPhotoDocumentViewModel {

    @d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.common.SNSPreviewCommonDocumentViewModel", f = "SNSPreviewCommonDocumentViewModel.kt", l = {53}, m = "onPrepare")
    /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.photo.common.a$a  reason: collision with other inner class name */
    public static final class C0477a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36094a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36095b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f36096c;

        /* renamed from: d  reason: collision with root package name */
        public int f36097d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0477a(a aVar, c<? super C0477a> cVar) {
            super(cVar);
            this.f36096c = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36095b = obj;
            this.f36097d |= Integer.MIN_VALUE;
            return this.f36096c.d(this);
        }
    }

    public a(Document document, SavedStateHandle savedStateHandle, o oVar, com.sumsub.sns.internal.core.data.source.common.a aVar, b bVar, com.sumsub.sns.internal.core.data.source.extensions.a aVar2, o0 o0Var, e<Bitmap, com.sumsub.sns.internal.ml.badphotos.models.a> eVar, com.sumsub.sns.internal.core.domain.d dVar) {
        super(document, savedStateHandle, aVar, bVar, aVar2, oVar, o0Var, eVar, dVar);
        com.sumsub.log.logger.a.c(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(this), "Preview Common Document is created", (Throwable) null, 4, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object d(kotlin.coroutines.c<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.common.a.C0477a
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.sumsub.sns.internal.presentation.screen.preview.photo.common.a$a r0 = (com.sumsub.sns.internal.presentation.screen.preview.photo.common.a.C0477a) r0
            int r1 = r0.f36097d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36097d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.preview.photo.common.a$a r0 = new com.sumsub.sns.internal.presentation.screen.preview.photo.common.a$a
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f36095b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36097d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f36094a
            com.sumsub.sns.internal.presentation.screen.preview.photo.common.a r0 = (com.sumsub.sns.internal.presentation.screen.preview.photo.common.a) r0
            kotlin.k.b(r5)
            goto L_0x0044
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            kotlin.k.b(r5)
            r0.f36094a = r4
            r0.f36097d = r3
            java.lang.Object r5 = super.d((kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            r0 = r4
        L_0x0044:
            r0.m()
            kotlin.Unit r5 = kotlin.Unit.f56620a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.common.a.d(kotlin.coroutines.c):java.lang.Object");
    }
}
