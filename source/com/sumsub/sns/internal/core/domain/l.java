package com.sumsub.sns.internal.core.domain;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetection;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import com.sumsub.sns.internal.core.domain.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.r;

public final class l implements o {

    /* renamed from: c  reason: collision with root package name */
    public static final a f33624c = new a((r) null);
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final String f33625d = "MLKitFaceDetector";

    /* renamed from: a  reason: collision with root package name */
    public FaceDetector f33626a;

    /* renamed from: b  reason: collision with root package name */
    public final String f33627b = "MLKit";

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    @SuppressLint({"UnsafeOptInUsageError"})
    public void a(Bitmap bitmap, RectF rectF, d10.l<? super o.a, Unit> lVar) {
        Task process;
        Task addOnSuccessListener;
        Task addOnFailureListener;
        MlKitException exception;
        i iVar = i.f33611a;
        i.a(iVar, f33625d, "@processImage()", (Throwable) null, 4, (Object) null);
        if (this.f33626a == null) {
            i.a(iVar, f33625d, "@processImage(), detector is null", (Throwable) null, 4, (Object) null);
            lVar.invoke(new o.a.e(bitmap));
            return;
        }
        i.a(iVar, f33625d, "@processImage(), creating InputImage from Bitmap", (Throwable) null, 4, (Object) null);
        InputImage fromBitmap = InputImage.fromBitmap(bitmap, 0);
        i iVar2 = iVar;
        i.a(iVar2, f33625d, "@processImage(), InputImage created", (Throwable) null, 4, (Object) null);
        i.a(iVar2, f33625d, "@processImage(), starting analyzing frame", (Throwable) null, 4, (Object) null);
        FaceDetector faceDetector = this.f33626a;
        if (faceDetector != null && (process = faceDetector.process(fromBitmap)) != null && (addOnSuccessListener = process.addOnSuccessListener(new v(lVar, bitmap, this, rectF))) != null && (addOnFailureListener = addOnSuccessListener.addOnFailureListener(new u(lVar, bitmap))) != null && (exception = addOnFailureListener.getException()) != null) {
            iVar.a(f33625d, "@processImage(), task returned exception", exception);
            if (exception instanceof MlKitException) {
                i.a(iVar, f33625d, "MlKitException.errorCode=" + exception.getErrorCode(), (Throwable) null, 4, (Object) null);
            }
        }
    }

    public String getName() {
        return this.f33627b;
    }

    public void start() {
        i iVar = i.f33611a;
        i.a(iVar, f33625d, "@start()", (Throwable) null, 4, (Object) null);
        stop();
        this.f33626a = FaceDetection.getClient(new FaceDetectorOptions.Builder().setPerformanceMode(1).setLandmarkMode(1).setClassificationMode(1).setMinFaceSize(0.4f).build());
        i.a(iVar, f33625d, "@start(), started", (Throwable) null, 4, (Object) null);
    }

    public void stop() {
        i iVar = i.f33611a;
        i.a(iVar, f33625d, "@stop()", (Throwable) null, 4, (Object) null);
        FaceDetector faceDetector = this.f33626a;
        if (faceDetector != null) {
            faceDetector.close();
        }
        this.f33626a = null;
        i.a(iVar, f33625d, "@stop(), stopped", (Throwable) null, 4, (Object) null);
    }

    public static final void a(d10.l lVar, Bitmap bitmap, l lVar2, RectF rectF, List list) {
        Object obj;
        i iVar = i.f33611a;
        i.a(iVar, f33625d, "@processImage(), success", (Throwable) null, 4, (Object) null);
        if (list.isEmpty()) {
            i.a(iVar, f33625d, "@processImage(), no faces found", (Throwable) null, 4, (Object) null);
            obj = new o.a.e(bitmap);
        } else if (list.size() > 1) {
            i.a(iVar, f33625d, "@processImage(), more than 1 faces found", (Throwable) null, 4, (Object) null);
            obj = new o.a.g(bitmap);
        } else {
            obj = lVar2.a(rectF, (Face) CollectionsKt___CollectionsKt.a0(list), bitmap, new Size(bitmap.getWidth(), bitmap.getHeight()));
        }
        lVar.invoke(obj);
    }

    public static final void a(d10.l lVar, Bitmap bitmap, Exception exc) {
        i.f33611a.a(f33625d, "@processImage(), failed to analyze", exc);
        if (exc instanceof DynamiteModule.LoadingException) {
            lVar.invoke(new o.a.b(bitmap, exc));
        } else {
            lVar.invoke(new o.a.C0374a(bitmap, exc));
        }
    }

    public final o.a a(RectF rectF, Face face, Bitmap bitmap, Size size) {
        i iVar = i.f33611a;
        i.a(iVar, f33625d, "@processFace(), got " + bitmap.getWidth() + 'x' + bitmap.getHeight() + " frame", (Throwable) null, 4, (Object) null);
        Rect boundingBox = face.getBoundingBox();
        RectF rectF2 = new RectF((((float) size.getWidth()) - ((float) boundingBox.right)) / ((float) size.getWidth()), ((float) boundingBox.top) / ((float) size.getHeight()), (((float) size.getWidth()) - ((float) boundingBox.left)) / ((float) size.getWidth()), ((float) boundingBox.bottom) / ((float) size.getHeight()));
        if (rectF.contains(rectF2)) {
            i.a(iVar, f33625d, "@processFace(), face is in capture box", (Throwable) null, 4, (Object) null);
            return new o.a.d(bitmap, size, rectF2);
        }
        i.a(iVar, f33625d, "@processFace(), face is NOT in capture box", (Throwable) null, 4, (Object) null);
        return new o.a.f(bitmap, rectF2);
    }
}
