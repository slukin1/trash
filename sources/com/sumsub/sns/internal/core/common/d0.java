package com.sumsub.sns.internal.core.common;

import android.graphics.Bitmap;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetector;
import d10.l;
import java.util.List;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.k;

public final class d0 implements o0 {

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.common.MLKitDocumentRotationDetector", f = "DocumentRotationUtils.kt", l = {75}, m = "detectRotation")
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f32005a;

        /* renamed from: b  reason: collision with root package name */
        public Object f32006b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f32007c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d0 f32008d;

        /* renamed from: e  reason: collision with root package name */
        public int f32009e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d0 d0Var, kotlin.coroutines.c<? super a> cVar) {
            super(cVar);
            this.f32008d = d0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.f32007c = obj;
            this.f32009e |= Integer.MIN_VALUE;
            return this.f32008d.a((Bitmap) null, this);
        }
    }

    public static final class b implements OnCanceledListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FaceDetector f32010a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k<Integer> f32011b;

        public b(FaceDetector faceDetector, k<? super Integer> kVar) {
            this.f32010a = faceDetector;
            this.f32011b = kVar;
        }

        public final void onCanceled() {
            this.f32010a.close();
            this.f32011b.h(0, (l<? super Throwable, Unit>) null);
        }
    }

    public static final class c implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FaceDetector f32012a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k<Integer> f32013b;

        public c(FaceDetector faceDetector, k<? super Integer> kVar) {
            this.f32012a = faceDetector;
            this.f32013b = kVar;
        }

        public final void onFailure(Exception exc) {
            this.f32012a.close();
            k<Integer> kVar = this.f32013b;
            Result.a aVar = Result.Companion;
            kVar.resumeWith(Result.m3072constructorimpl(kotlin.k.a(exc)));
        }
    }

    public static final class d<TResult> implements OnSuccessListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FaceDetector f32014a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k<Integer> f32015b;

        public d(FaceDetector faceDetector, k<? super Integer> kVar) {
            this.f32014a = faceDetector;
            this.f32015b = kVar;
        }

        /* renamed from: a */
        public final void onSuccess(List<Face> list) {
            Face face = (Face) CollectionsKt___CollectionsKt.c0(list);
            this.f32014a.close();
            if (face == null) {
                this.f32015b.h(0, (l<? super Throwable, Unit>) null);
                this.f32014a.close();
                return;
            }
            this.f32015b.h(Integer.valueOf((int) face.getHeadEulerAngleZ()), (l<? super Throwable, Unit>) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(android.graphics.Bitmap r7, kotlin.coroutines.c<? super java.lang.Integer> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.sumsub.sns.internal.core.common.d0.a
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.sumsub.sns.internal.core.common.d0$a r0 = (com.sumsub.sns.internal.core.common.d0.a) r0
            int r1 = r0.f32009e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f32009e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.common.d0$a r0 = new com.sumsub.sns.internal.core.common.d0$a
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f32007c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f32009e
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r4) goto L_0x0032
            java.lang.Object r7 = r0.f32006b
            com.google.mlkit.vision.common.InputImage r7 = (com.google.mlkit.vision.common.InputImage) r7
            java.lang.Object r7 = r0.f32005a
            com.google.mlkit.vision.face.FaceDetector r7 = (com.google.mlkit.vision.face.FaceDetector) r7
            kotlin.k.b(r8)     // Catch:{ all -> 0x00a1 }
            goto L_0x009b
        L_0x0032:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003a:
            kotlin.k.b(r8)
            com.google.mlkit.vision.face.FaceDetectorOptions$Builder r8 = new com.google.mlkit.vision.face.FaceDetectorOptions$Builder     // Catch:{ all -> 0x00a1 }
            r8.<init>()     // Catch:{ all -> 0x00a1 }
            r2 = 2
            com.google.mlkit.vision.face.FaceDetectorOptions$Builder r8 = r8.setPerformanceMode(r2)     // Catch:{ all -> 0x00a1 }
            com.google.mlkit.vision.face.FaceDetectorOptions$Builder r8 = r8.setLandmarkMode(r2)     // Catch:{ all -> 0x00a1 }
            com.google.mlkit.vision.face.FaceDetectorOptions$Builder r8 = r8.setClassificationMode(r2)     // Catch:{ all -> 0x00a1 }
            com.google.mlkit.vision.face.FaceDetectorOptions r8 = r8.build()     // Catch:{ all -> 0x00a1 }
            com.google.mlkit.vision.face.FaceDetector r8 = com.google.mlkit.vision.face.FaceDetection.getClient(r8)     // Catch:{ all -> 0x00a1 }
            com.google.mlkit.vision.common.InputImage r7 = com.google.mlkit.vision.common.InputImage.fromBitmap(r7, r3)     // Catch:{ all -> 0x00a1 }
            r0.f32005a = r8     // Catch:{ all -> 0x00a1 }
            r0.f32006b = r7     // Catch:{ all -> 0x00a1 }
            r0.f32009e = r4     // Catch:{ all -> 0x00a1 }
            kotlinx.coroutines.l r2 = new kotlinx.coroutines.l     // Catch:{ all -> 0x00a1 }
            kotlin.coroutines.c r5 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.c(r0)     // Catch:{ all -> 0x00a1 }
            r2.<init>(r5, r4)     // Catch:{ all -> 0x00a1 }
            r2.A()     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.tasks.Task r7 = r8.process(r7)     // Catch:{ all -> 0x00a1 }
            com.sumsub.sns.internal.core.common.d0$b r4 = new com.sumsub.sns.internal.core.common.d0$b     // Catch:{ all -> 0x00a1 }
            r4.<init>(r8, r2)     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.tasks.Task r7 = r7.addOnCanceledListener(r4)     // Catch:{ all -> 0x00a1 }
            com.sumsub.sns.internal.core.common.d0$c r4 = new com.sumsub.sns.internal.core.common.d0$c     // Catch:{ all -> 0x00a1 }
            r4.<init>(r8, r2)     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.tasks.Task r7 = r7.addOnFailureListener(r4)     // Catch:{ all -> 0x00a1 }
            com.sumsub.sns.internal.core.common.d0$d r4 = new com.sumsub.sns.internal.core.common.d0$d     // Catch:{ all -> 0x00a1 }
            r4.<init>(r8, r2)     // Catch:{ all -> 0x00a1 }
            r7.addOnSuccessListener(r4)     // Catch:{ all -> 0x00a1 }
            java.lang.Object r8 = r2.v()     // Catch:{ all -> 0x00a1 }
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()     // Catch:{ all -> 0x00a1 }
            if (r8 != r7) goto L_0x0098
            kotlin.coroutines.jvm.internal.f.c(r0)     // Catch:{ all -> 0x00a1 }
        L_0x0098:
            if (r8 != r1) goto L_0x009b
            return r1
        L_0x009b:
            java.lang.Number r8 = (java.lang.Number) r8     // Catch:{ all -> 0x00a1 }
            int r3 = r8.intValue()     // Catch:{ all -> 0x00a1 }
        L_0x00a1:
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.a.c(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.common.d0.a(android.graphics.Bitmap, kotlin.coroutines.c):java.lang.Object");
    }
}
