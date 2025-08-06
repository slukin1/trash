package com.sumsub.sns.internal.core.domain;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.media.FaceDetector;
import android.util.Size;
import com.sumsub.sns.internal.core.common.e;
import com.sumsub.sns.internal.core.domain.o;
import d10.l;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.r;

public final class m implements o {

    /* renamed from: f  reason: collision with root package name */
    public static final a f33628f = new a((r) null);

    /* renamed from: g  reason: collision with root package name */
    public static final String f33629g = "NativeFaceDetector";

    /* renamed from: h  reason: collision with root package name */
    public static final float f33630h = 0.3f;

    /* renamed from: i  reason: collision with root package name */
    public static final int f33631i = 1;

    /* renamed from: a  reason: collision with root package name */
    public FaceDetector f33632a;

    /* renamed from: b  reason: collision with root package name */
    public int f33633b;

    /* renamed from: c  reason: collision with root package name */
    public int f33634c;

    /* renamed from: d  reason: collision with root package name */
    public final e f33635d = new e(Bitmap.Config.RGB_565);

    /* renamed from: e  reason: collision with root package name */
    public final String f33636e = "Native";

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    public final Pair<Bitmap, FaceDetector> a(Bitmap bitmap) {
        i iVar = i.f33611a;
        i.a(iVar, f33629g, "@prepareDetector()", (Throwable) null, 4, (Object) null);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        i.a(iVar, f33629g, "@prepareDetector(), got bitmap of size " + width + 'x' + height, (Throwable) null, 4, (Object) null);
        FaceDetector faceDetector = this.f33632a;
        if (faceDetector != null && this.f33633b == width && this.f33634c == height) {
            i.a(iVar, f33629g, "@prepareDetector(), reuse old FaceDetector", (Throwable) null, 4, (Object) null);
        } else {
            i.a(iVar, f33629g, "@prepareDetector(), create FaceDetector", (Throwable) null, 4, (Object) null);
            this.f33633b = width;
            this.f33634c = height;
            faceDetector = new FaceDetector(width, height, 1);
        }
        this.f33632a = faceDetector;
        i.a(iVar, f33629g, "@prepareDetector(), making RGB565 copy of Bitmap", (Throwable) null, 4, (Object) null);
        Bitmap a11 = this.f33635d.a(width, height);
        new Canvas(a11).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        i.a(iVar, f33629g, "@prepareDetector(), RGB565 copy made", (Throwable) null, 4, (Object) null);
        return new Pair<>(a11, faceDetector);
    }

    public String getName() {
        return this.f33636e;
    }

    public void start() {
        i.a(i.f33611a, f33629g, "@start()", (Throwable) null, 4, (Object) null);
    }

    public void stop() {
        i.a(i.f33611a, f33629g, "@stop()", (Throwable) null, 4, (Object) null);
        this.f33632a = null;
        this.f33633b = 0;
        this.f33634c = 0;
        this.f33635d.a();
    }

    @SuppressLint({"UnsafeOptInUsageError"})
    public void a(Bitmap bitmap, RectF rectF, l<? super o.a, Unit> lVar) {
        Object obj;
        try {
            i iVar = i.f33611a;
            i.a(iVar, f33629g, "@processImage(), got " + bitmap.getWidth() + 'x' + bitmap.getHeight() + " frame", (Throwable) null, 4, (Object) null);
            boolean z11 = true;
            FaceDetector.Face[] faceArr = new FaceDetector.Face[1];
            Pair<Bitmap, FaceDetector> a11 = a(bitmap);
            i.a(iVar, f33629g, "@processImage(), detector prepared, trying to find faces", (Throwable) null, 4, (Object) null);
            a11.getSecond().findFaces(a11.getFirst(), faceArr);
            int size = ArraysKt___ArraysKt.F(faceArr).size();
            i.a(iVar, f33629g, "@processImage(), " + size + " found", (Throwable) null, 4, (Object) null);
            if (size == 0) {
                obj = new o.a.e(bitmap);
            } else if (size != 1) {
                obj = new o.a.g(bitmap);
            } else {
                FaceDetector.Face face = faceArr[0];
                if (face == null) {
                    z11 = false;
                }
                if (z11) {
                    obj = a(rectF, face, bitmap, new Size(bitmap.getWidth(), bitmap.getHeight()));
                } else {
                    throw new NoSuchElementException("Array contains no element matching the predicate.");
                }
            }
        } catch (Throwable th2) {
            i iVar2 = i.f33611a;
            String message = th2.getMessage();
            if (message == null) {
                message = "";
            }
            iVar2.a(f33629g, message, th2);
            obj = new o.a.e(bitmap);
        }
        lVar.invoke(obj);
    }

    public final o.a a(RectF rectF, FaceDetector.Face face, Bitmap bitmap, Size size) {
        if (face.confidence() < 0.3f) {
            i iVar = i.f33611a;
            i.a(iVar, f33629g, "@processFace(), face confidence is too low (" + face.confidence() + ')', (Throwable) null, 4, (Object) null);
            return new o.a.e(bitmap);
        }
        PointF pointF = new PointF();
        face.getMidPoint(pointF);
        RectF rectF2 = new RectF(pointF.x - face.eyesDistance(), ((float) ((int) pointF.y)) - (face.eyesDistance() * 1.5f), ((float) ((int) pointF.x)) + face.eyesDistance(), ((float) ((int) pointF.y)) + (face.eyesDistance() * 1.5f));
        RectF rectF3 = new RectF((((float) size.getWidth()) - rectF2.right) / ((float) size.getWidth()), rectF2.top / ((float) size.getHeight()), (((float) size.getWidth()) - rectF2.left) / ((float) size.getWidth()), rectF2.bottom / ((float) size.getHeight()));
        if (rectF.contains(rectF3)) {
            i.a(i.f33611a, f33629g, "@processFace(), face is in capture box", (Throwable) null, 4, (Object) null);
            return new o.a.d(bitmap, size, rectF3);
        }
        i.a(i.f33611a, f33629g, "@processFace(), face is NOT in capture box", (Throwable) null, 4, (Object) null);
        return new o.a.f(bitmap, rectF3);
    }
}
