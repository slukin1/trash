package com.google.android.play.core.ktx;

import com.google.android.play.core.review.ReviewManager;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.google.android.play.core.ktx.ReviewManagerKtxKt", f = "ReviewManagerKtx.kt", l = {22}, m = "requestReview")
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ReviewManagerKtxKt$requestReview$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;

    public ReviewManagerKtxKt$requestReview$1(c<? super ReviewManagerKtxKt$requestReview$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ReviewManagerKtxKt.requestReview((ReviewManager) null, this);
    }
}
