package com.sumsub.sns.internal.presentation.screen.preview.photo;

import android.graphics.Bitmap;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.sumsub.sns.internal.core.common.o0;
import com.sumsub.sns.internal.core.data.model.n;
import com.sumsub.sns.internal.ml.badphotos.models.b;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f36091a = 90;

    @d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.SNSPreviewPhotoDocumentViewModelKt", f = "SNSPreviewPhotoDocumentViewModel.kt", l = {72}, m = "detectRotationDegree")
    /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.photo.a$a  reason: collision with other inner class name */
    public static final class C0476a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f36092a;

        /* renamed from: b  reason: collision with root package name */
        public int f36093b;

        public C0476a(c<? super C0476a> cVar) {
            super(cVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.f36092a = obj;
            this.f36093b |= Integer.MIN_VALUE;
            return a.b((o0) null, (Bitmap) null, this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(com.sumsub.sns.internal.core.common.o0 r6, android.graphics.Bitmap r7, kotlin.coroutines.c<? super java.lang.Integer> r8) {
        /*
            boolean r0 = r8 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.a.C0476a
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.sumsub.sns.internal.presentation.screen.preview.photo.a$a r0 = (com.sumsub.sns.internal.presentation.screen.preview.photo.a.C0476a) r0
            int r1 = r0.f36093b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36093b = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.preview.photo.a$a r0 = new com.sumsub.sns.internal.presentation.screen.preview.photo.a$a
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.f36092a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36093b
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r8)
            goto L_0x003d
        L_0x0029:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0031:
            kotlin.k.b(r8)
            r0.f36093b = r3
            java.lang.Object r8 = r6.a(r7, r0)
            if (r8 != r1) goto L_0x003d
            return r1
        L_0x003d:
            java.lang.Number r8 = (java.lang.Number) r8
            int r6 = r8.intValue()
            float r7 = (float) r6
            r8 = 90
            float r0 = (float) r8
            float r7 = r7 / r0
            int r7 = kotlin.math.MathKt__MathJVMKt.b(r7)
            int r7 = r7 * r8
            com.sumsub.sns.internal.camera.photo.presentation.document.b r0 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "Face rotation: "
            r8.append(r1)
            r8.append(r6)
            r6 = 32
            r8.append(r6)
            r8.append(r7)
            java.lang.String r2 = r8.toString()
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = "DocCapture"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r0, r1, r2, r3, r4, r5)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.a.c(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.a.b(com.sumsub.sns.internal.core.common.o0, android.graphics.Bitmap, kotlin.coroutines.c):java.lang.Object");
    }

    public static final String b(n nVar) {
        File m11 = nVar.m();
        if (m11 != null) {
            return m11.getAbsolutePath();
        }
        return null;
    }

    public static final Map<String, Object> b(n.b bVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(IBridgeMediaLoader.COLUMN_DURATION, Integer.valueOf(bVar.c()));
        linkedHashMap.put("fileSize", Long.valueOf(bVar.d()));
        return linkedHashMap;
    }

    public static final Map<String, Object> b(b bVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String m11 = bVar.m();
        if (m11 != null) {
            linkedHashMap.put("checkResult", m11);
        }
        String l11 = bVar.l();
        if (l11 != null) {
            linkedHashMap.put("checkModel", l11);
        }
        Float n11 = bVar.n();
        if (n11 != null) {
            linkedHashMap.put("checkScore", Float.valueOf(n11.floatValue()));
        }
        Long o11 = bVar.o();
        if (o11 != null) {
            linkedHashMap.put("checkTime", Long.valueOf(o11.longValue()));
        }
        Float q11 = bVar.q();
        if (q11 != null) {
            linkedHashMap.put("checkLowThreshold", Float.valueOf(q11.floatValue()));
        }
        Float p11 = bVar.p();
        if (p11 != null) {
            linkedHashMap.put("checkHighThreshold", Float.valueOf(p11.floatValue()));
        }
        Integer j11 = bVar.j();
        if (j11 != null) {
            linkedHashMap.put("checkBadAttempts", Integer.valueOf(j11.intValue()));
        }
        Integer k11 = bVar.k();
        if (k11 != null) {
            linkedHashMap.put("checkMaxBlockedAttempts", Integer.valueOf(k11.intValue()));
        }
        Boolean r11 = bVar.r();
        if (r11 != null) {
            linkedHashMap.put("isAutocaptured", Boolean.valueOf(r11.booleanValue()));
        }
        return linkedHashMap;
    }
}
