package com.google.android.play.core.ktx;

import android.app.Activity;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import d10.a;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlin.k;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.m;
import kotlinx.coroutines.l;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a'\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\b\u001a\u00020\u0003*\u00020\u0000H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a7\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\rH@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0015\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/google/android/play/core/review/ReviewManager;", "Landroid/app/Activity;", "activity", "Lcom/google/android/play/core/review/ReviewInfo;", "reviewInfo", "", "launchReview", "(Lcom/google/android/play/core/review/ReviewManager;Landroid/app/Activity;Lcom/google/android/play/core/review/ReviewInfo;Lkotlin/coroutines/c;)Ljava/lang/Object;", "requestReview", "(Lcom/google/android/play/core/review/ReviewManager;Lkotlin/coroutines/c;)Ljava/lang/Object;", "T", "Lcom/google/android/gms/tasks/Task;", "task", "Lkotlin/Function0;", "onCanceled", "runTask", "(Lcom/google/android/gms/tasks/Task;Ld10/a;Lkotlin/coroutines/c;)Ljava/lang/Object;", "E", "Lkotlinx/coroutines/channels/m;", "element", "", "tryOffer", "(Lkotlinx/coroutines/channels/m;Ljava/lang/Object;)Z", "java.com.google.android.apps.play.store.sdk.playcore.ktx_playcore_review_ktx"}, k = 2, mv = {1, 7, 1})
public final class ReviewManagerKtxKt {
    public static final Object launchReview(ReviewManager reviewManager, Activity activity, ReviewInfo reviewInfo, c<? super Unit> cVar) {
        Object runTask$default = runTask$default(reviewManager.launchReviewFlow(activity, reviewInfo), (a) null, cVar, 2, (Object) null);
        return runTask$default == IntrinsicsKt__IntrinsicsKt.d() ? runTask$default : Unit.f56620a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object requestReview(com.google.android.play.core.review.ReviewManager r4, kotlin.coroutines.c<? super com.google.android.play.core.review.ReviewInfo> r5) {
        /*
            boolean r0 = r5 instanceof com.google.android.play.core.ktx.ReviewManagerKtxKt$requestReview$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.google.android.play.core.ktx.ReviewManagerKtxKt$requestReview$1 r0 = (com.google.android.play.core.ktx.ReviewManagerKtxKt$requestReview$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.play.core.ktx.ReviewManagerKtxKt$requestReview$1 r0 = new com.google.android.play.core.ktx.ReviewManagerKtxKt$requestReview$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r5)
            goto L_0x0043
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.k.b(r5)
            com.google.android.gms.tasks.Task r4 = r4.requestReviewFlow()
            r5 = 2
            r0.label = r3
            r2 = 0
            java.lang.Object r5 = runTask$default(r4, r2, r0, r5, r2)
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.ReviewManagerKtxKt.requestReview(com.google.android.play.core.review.ReviewManager, kotlin.coroutines.c):java.lang.Object");
    }

    public static final <T> Object runTask(Task<T> task, a<Unit> aVar, c<? super T> cVar) {
        l lVar = new l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        lVar.A();
        lVar.x(new ReviewManagerKtxKt$runTask$3$1(aVar));
        if (!task.isComplete()) {
            task.addOnSuccessListener(new ReviewManagerKtxKt$runTask$3$2(lVar));
            task.addOnFailureListener(new ReviewManagerKtxKt$runTask$3$3(lVar));
        } else if (task.isSuccessful()) {
            lVar.resumeWith(Result.m3072constructorimpl(task.getResult()));
        } else {
            lVar.resumeWith(Result.m3072constructorimpl(k.a(task.getException())));
        }
        Object v11 = lVar.v();
        if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
            f.c(cVar);
        }
        return v11;
    }

    public static /* synthetic */ Object runTask$default(Task task, a aVar, c cVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            aVar = ReviewManagerKtxKt$runTask$2.INSTANCE;
        }
        return runTask(task, aVar, cVar);
    }

    public static final <E> boolean tryOffer(m<? super E> mVar, E e11) {
        return ChannelResult.j(mVar.q(e11));
    }
}
