package com.sumsub.sns.internal.camera.photo.presentation.document;

import android.graphics.Rect;
import android.graphics.RectF;
import com.sumsub.sns.internal.camera.photo.presentation.document.CheckDetectionResult;
import java.math.BigDecimal;
import java.math.RoundingMode;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final com.sumsub.sns.internal.ml.autocapture.a f31749a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f31750b;

    public a(com.sumsub.sns.internal.ml.autocapture.a aVar) {
        this.f31749a = aVar;
    }

    public final boolean a(float f11, float f12, com.sumsub.sns.internal.ml.docdetector.a aVar) {
        int i11 = (int) (((float) (aVar.i() - (aVar.o() / 2))) * f11);
        int j11 = (int) (((float) (aVar.j() - (aVar.k() / 2))) * f12);
        Rect rect = new Rect(i11, j11, ((int) (((float) aVar.o()) * f11)) + i11, ((int) (((float) aVar.k()) * f12)) + j11);
        BigDecimal bigDecimal = new BigDecimal((double) (((float) rect.width()) / ((float) rect.height())));
        bigDecimal.setScale(2, RoundingMode.FLOOR);
        BigDecimal bigDecimal2 = new BigDecimal((double) this.f31749a.q());
        BigDecimal bigDecimal3 = new BigDecimal(0.2d);
        return bigDecimal.compareTo(bigDecimal2.subtract(bigDecimal2.multiply(bigDecimal3)).setScale(2, RoundingMode.FLOOR)) >= 0 && bigDecimal.compareTo(bigDecimal2.add(bigDecimal2.multiply(bigDecimal3)).setScale(2, RoundingMode.FLOOR)) <= 0;
    }

    public final CheckDetectionResult.SizeCheckResult b(float f11, float f12, Rect rect, com.sumsub.sns.internal.ml.docdetector.a aVar) {
        Rect a11 = c.a(aVar.m(), f11, f12);
        boolean z11 = true;
        boolean z12 = ((float) (a11.width() * a11.height())) / ((float) (rect.width() * rect.height())) >= this.f31749a.u();
        RectF rectF = new RectF(a11);
        RectF rectF2 = new RectF(rect);
        boolean z13 = rectF.width() < rectF2.width() && 1.0f - RangesKt___RangesKt.f(rectF.width() / rectF2.width(), 1.0f) <= this.f31749a.v();
        if (rectF.width() < rectF2.width() && rectF.height() > rectF2.height()) {
            return CheckDetectionResult.SizeCheckResult.BIG;
        }
        boolean z14 = rectF.height() < rectF2.height() && RangesKt___RangesKt.f(1.0f - (rectF.height() / rectF2.height()), 1.0f) <= this.f31749a.v();
        if (a11.height() > a11.width()) {
            z13 = z14;
        }
        if (rectF.height() < rectF2.height() && rectF.width() > rectF2.width()) {
            return CheckDetectionResult.SizeCheckResult.BIG;
        }
        CheckDetectionResult.SizeCheckResult sizeCheckResult = CheckDetectionResult.SizeCheckResult.OK;
        if (!z12 || !z13) {
            z11 = false;
        }
        if (!z11) {
            sizeCheckResult = null;
        }
        return sizeCheckResult == null ? CheckDetectionResult.SizeCheckResult.SMALL : sizeCheckResult;
    }

    public final CheckDetectionResult c(float f11, float f12, Rect rect, com.sumsub.sns.internal.ml.docdetector.a aVar) {
        CheckDetectionResult checkDetectionResult = new CheckDetectionResult(a(f11, f12, rect, aVar), b(f11, f12, rect, aVar), a(f11, f12, aVar));
        b bVar = b.f31751a;
        b.b(bVar, DocCapture.f31492c, "processor result -> " + checkDetectionResult, (Throwable) null, 4, (Object) null);
        return checkDetectionResult;
    }

    public final boolean a(float f11, float f12, Rect rect, com.sumsub.sns.internal.ml.docdetector.a aVar) {
        boolean contains = rect.contains(c.a(aVar.m(), f11, f12));
        if (contains && !this.f31750b) {
            b.b(b.f31751a, DocCapture.f31492c, "Documents hits the frame", (Throwable) null, 4, (Object) null);
        }
        if (!contains && this.f31750b) {
            b.b(b.f31751a, DocCapture.f31492c, "Documents is NOT in the frame", (Throwable) null, 4, (Object) null);
        }
        this.f31750b = contains;
        return contains;
    }

    public final void a() {
        this.f31750b = false;
    }
}
