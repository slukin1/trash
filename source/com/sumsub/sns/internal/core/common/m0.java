package com.sumsub.sns.internal.core.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import com.luck.picture.lib.config.PictureMimeType;
import d10.p;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.k;
import kotlin.l;
import kotlinx.coroutines.g;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.v0;

public final class m0 {

    /* renamed from: a  reason: collision with root package name */
    public static final int f32098a = 75;

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.common.SNSBitmapExtensionsKt$asJpegInputStream$2", f = "SNSBitmapExtensions.kt", l = {}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super ByteArrayInputStream>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f32099a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bitmap f32100b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Bitmap bitmap, kotlin.coroutines.c<? super a> cVar) {
            super(2, cVar);
            this.f32100b = bitmap;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super ByteArrayInputStream> cVar) {
            return ((a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new a(this.f32100b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f32099a == 0) {
                k.b(obj);
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    if (!this.f32100b.compress(Bitmap.CompressFormat.JPEG, 75, byteArrayOutputStream)) {
                        return null;
                    }
                    byteArrayOutputStream.flush();
                    return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                } catch (IOException unused2) {
                    return null;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.common.SNSBitmapExtensionsKt$decodeImage$2", f = "SNSBitmapExtensions.kt", l = {}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Bitmap>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f32101a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f32102b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ File f32103c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f32104d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(File file, int i11, kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
            this.f32103c = file;
            this.f32104d = i11;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Bitmap> cVar) {
            return ((b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            b bVar = new b(this.f32103c, this.f32104d, cVar);
            bVar.f32102b = obj;
            return bVar;
        }

        public final Object invokeSuspend(Object obj) {
            Bitmap bitmap;
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f32101a == 0) {
                k.b(obj);
                h0 h0Var = (h0) this.f32102b;
                m1.a aVar = new m1.a(this.f32103c);
                try {
                    String absolutePath = this.f32103c.getAbsolutePath();
                    int i11 = this.f32104d;
                    bitmap = m0.b(absolutePath, i11, i11);
                } catch (Throwable th2) {
                    com.sumsub.sns.internal.log.b.b(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(h0Var), "Error while decoding image", th2);
                    bitmap = null;
                }
                if (bitmap == null) {
                    return null;
                }
                if (aVar.s() == 0) {
                    return bitmap;
                }
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                Matrix matrix = new Matrix();
                matrix.setRotate((float) aVar.s());
                Unit unit = Unit.f56620a;
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                bitmap.recycle();
                return createBitmap;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.common.SNSBitmapExtensionsKt$decodePdf$2", f = "SNSBitmapExtensions.kt", l = {}, m = "invokeSuspend")
    public static final class c extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Bitmap>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f32105a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f32106b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ File f32107c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f32108d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(File file, int i11, kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
            this.f32107c = file;
            this.f32108d = i11;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Bitmap> cVar) {
            return ((c) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            c cVar2 = new c(this.f32107c, this.f32108d, cVar);
            cVar2.f32106b = obj;
            return cVar2;
        }

        public final Object invokeSuspend(Object obj) {
            int i11;
            int i12;
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f32105a == 0) {
                k.b(obj);
                h0 h0Var = (h0) this.f32106b;
                try {
                    PdfRenderer pdfRenderer = new PdfRenderer(ParcelFileDescriptor.open(this.f32107c, 268435456));
                    PdfRenderer.Page openPage = pdfRenderer.openPage(0);
                    if (openPage.getWidth() < openPage.getHeight()) {
                        i11 = MathKt__MathJVMKt.b(((float) this.f32108d) * (((float) openPage.getWidth()) / ((float) openPage.getHeight())));
                    } else {
                        i11 = this.f32108d;
                    }
                    if (openPage.getHeight() < openPage.getWidth()) {
                        i12 = MathKt__MathJVMKt.b(((float) this.f32108d) * (((float) openPage.getHeight()) / ((float) openPage.getWidth())));
                    } else {
                        i12 = this.f32108d;
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
                    createBitmap.eraseColor(-1);
                    openPage.render(createBitmap, new Rect(0, 0, i11, i12), (Matrix) null, 1);
                    openPage.close();
                    pdfRenderer.close();
                    return createBitmap;
                } catch (Exception e11) {
                    com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                    String a11 = com.sumsub.sns.internal.log.c.a(h0Var);
                    String message = e11.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    aVar.e(a11, message, e11);
                    return null;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.common.SNSBitmapExtensionsKt$saveToTempJpgFile$2", f = "SNSBitmapExtensions.kt", l = {107}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super File>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f32109a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bitmap f32110b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f32111c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Context f32112d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Bitmap bitmap, String str, Context context, kotlin.coroutines.c<? super d> cVar) {
            super(2, cVar);
            this.f32110b = bitmap;
            this.f32111c = str;
            this.f32112d = context;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super File> cVar) {
            return ((d) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new d(this.f32110b, this.f32111c, this.f32112d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f32109a;
            if (i11 == 0) {
                k.b(obj);
                Bitmap bitmap = this.f32110b;
                this.f32109a = 1;
                obj = m0.a(bitmap, this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            InputStream inputStream = (InputStream) obj;
            if (inputStream == null) {
                return null;
            }
            try {
                File createTempFile = File.createTempFile(this.f32111c, PictureMimeType.JPG, this.f32112d.getCacheDir());
                if (r0.a(inputStream, new FileOutputStream(createTempFile))) {
                    return createTempFile;
                }
                return null;
            } catch (IOException unused) {
                return null;
            }
        }
    }

    public static final Bitmap b(String str, int i11, int i12) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = a(options, i11, i12);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static final Object a(File file, int i11, kotlin.coroutines.c<? super Bitmap> cVar) throws IOException {
        return g.g(v0.b(), new b(file, i11, (kotlin.coroutines.c<? super b>) null), cVar);
    }

    public static final int a(BitmapFactory.Options options, int i11, int i12) {
        Pair a11 = l.a(Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
        int intValue = ((Number) a11.component1()).intValue();
        int intValue2 = ((Number) a11.component2()).intValue();
        int i13 = 1;
        if (intValue > i12 || intValue2 > i11) {
            int i14 = intValue / 2;
            int i15 = intValue2 / 2;
            while (i14 / i13 >= i12 && i15 / i13 >= i11) {
                i13 *= 2;
            }
        }
        return i13;
    }

    public static final Object a(Bitmap bitmap, Context context, String str, kotlin.coroutines.c<? super File> cVar) {
        return g.g(v0.b(), new d(bitmap, str, context, (kotlin.coroutines.c<? super d>) null), cVar);
    }

    public static final Object b(File file, int i11, kotlin.coroutines.c<? super Bitmap> cVar) {
        return g.g(v0.b(), new c(file, i11, (kotlin.coroutines.c<? super c>) null), cVar);
    }

    public static final Object a(Bitmap bitmap, kotlin.coroutines.c<? super InputStream> cVar) {
        return g.g(v0.b(), new a(bitmap, (kotlin.coroutines.c<? super a>) null), cVar);
    }

    public static final String a(File file) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(file).toString());
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }
}
