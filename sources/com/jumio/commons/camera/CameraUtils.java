package com.jumio.commons.camera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.common.base.Ascii;
import com.huobi.view.roundimg.RoundedDrawable;
import com.jumio.commons.camera.Frame;
import com.jumio.commons.log.Log;
import com.jumio.core.models.AuthorizationModel;
import com.jumio.jvision.jvcorejava.swig.Image;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import com.jumio.jvision.jvcorejava.swig.Rect2i;
import com.jumio.jvision.jvcorejava.swig.Size2i;
import d10.l;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.x;

public final class CameraUtils {
    public static final float CENTER_CROP_RATIO_1_TO_1 = 1.0f;
    public static final int FULL_SIZE = -1;
    public static final CameraUtils INSTANCE = new CameraUtils();

    public enum ImageOrientation {
        Portrait,
        Landscape,
        InvertedPortrait,
        InvertedLandscape,
        Unknown;

        public final String getImageOrientationName() {
            return name();
        }
    }

    public static final class a extends Lambda implements l<Matrix, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Frame.MetaData f38961a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Frame.MetaData metaData) {
            super(1);
            this.f38961a = metaData;
        }

        public final Object invoke(Object obj) {
            Matrix matrix = (Matrix) obj;
            matrix.postRotate(((float) 360) - ((float) this.f38961a.getOrientation()), 0.0f, 0.0f);
            int orientation = 360 - this.f38961a.getOrientation();
            if (orientation == 90) {
                matrix.postTranslate((float) this.f38961a.getSize().getWidth(), 0.0f);
            } else if (orientation == 180) {
                matrix.postTranslate((float) this.f38961a.getSize().getWidth(), (float) this.f38961a.getSize().getHeight());
            } else if (orientation == 270) {
                matrix.postTranslate(0.0f, (float) this.f38961a.getSize().getHeight());
            }
            return Unit.f56620a;
        }
    }

    private CameraUtils() {
    }

    private final ImageSource cropRotateScale(ImageSource imageSource, PreviewProperties previewProperties, Frame.MetaData metaData, int i11, int i12, int i13, int i14, int i15, int i16) {
        try {
            return ImageSource.CropRotateScale(imageSource, new Rect2i(i13, i14, i11, i12), getImageRotation(metaData.getOrientation(), previewProperties.getFrontFacing()), new Size2i(i15, i16));
        } catch (Exception e11) {
            Log.printStackTrace(e11);
            return null;
        }
    }

    public static /* synthetic */ Rect determineCropRect$default(CameraUtils cameraUtils, Rect rect, float f11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            f11 = 1.0f;
        }
        return cameraUtils.determineCropRect(rect, f11);
    }

    public static /* synthetic */ Bitmap readBitmap$default(CameraUtils cameraUtils, String str, AuthorizationModel.SessionKey sessionKey, BitmapFactory.Options options, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            options = null;
        }
        return cameraUtils.readBitmap(str, sessionKey, options);
    }

    public static final Bitmap rgb2bitmap(ImageSource imageSource) {
        Image rgb = imageSource.getRGB();
        int width = rgb.width();
        int height = rgb.height();
        byte[] bytes = rgb.toBytes();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int[] iArr = new int[width];
        for (int i11 = 0; i11 < height; i11++) {
            for (int i12 = 0; i12 < width; i12++) {
                int i13 = (i12 * 3) + (i11 * width * 3);
                iArr[i12] = ((bytes[i13] & 255) << 16) + RoundedDrawable.DEFAULT_BORDER_COLOR + ((bytes[i13 + 1] & 255) << 8) + (bytes[i13 + 2] & 255);
            }
            createBitmap.setPixels(iArr, 0, width, 0, i11, width, 1);
        }
        return createBitmap;
    }

    private final Bitmap rotateBitmap(Bitmap bitmap, int i11, boolean z11, boolean z12) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i11);
        float f11 = -1.0f;
        float f12 = z11 ? -1.0f : 1.0f;
        if (!z12) {
            f11 = 1.0f;
        }
        matrix.postScale(f12, f11);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (!x.b(createBitmap, bitmap)) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static /* synthetic */ RectF surfaceToPreview$default(CameraUtils cameraUtils, PreviewProperties previewProperties, Rect rect, l lVar, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        return cameraUtils.surfaceToPreview(previewProperties, rect, lVar);
    }

    public final Bitmap bitmapFromRgba(int i11, int i12, byte[] bArr) {
        Bitmap createBitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
        int[] iArr = new int[i11];
        for (int i13 = 0; i13 < i12; i13++) {
            for (int i14 = 0; i14 < i11; i14++) {
                int i15 = (i14 * 4) + (i13 * i11 * 4);
                iArr[i14] = ((bArr[i15] & 255) << Ascii.CAN) + ((bArr[i15 + 1] & 255) << 16) + ((bArr[i15 + 2] & 255) << 8) + (bArr[i15 + 3] & 255);
            }
            createBitmap.setPixels(iArr, 0, i11, 0, i13, i11, 1);
        }
        return createBitmap;
    }

    public final ImageSource centerCropImageSource(ImageSource imageSource, PreviewProperties previewProperties, Frame.MetaData metaData, Rect rect, float f11, Size size) {
        RectF rectF;
        Rect rect2;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        Size size2 = size;
        if (rect == null) {
            rect2 = new Rect(0, 0, previewProperties.getPreview().getWidth(), previewProperties.getPreview().getHeight());
            rectF = new RectF(rect2);
        } else {
            rectF = surfaceToPreview$default(this, previewProperties, rect, (l) null, 4, (Object) null);
            rect2 = rect;
        }
        float height = ((float) rect2.height()) / ((float) rect2.width());
        if (metaData.isPortrait()) {
            i14 = (int) rectF.left;
            i13 = (int) rectF.top;
            int width = (int) rectF.width();
            int height2 = (int) rectF.height();
            if (height >= f11) {
                int i18 = (int) (((float) width) * f11);
                i13 += (height2 - i18) / 2;
                i12 = i18;
                i11 = width;
            } else {
                int i19 = (int) (((float) height2) / f11);
                i14 += (width - i19) / 2;
                i12 = height2;
                i11 = i19;
            }
        } else {
            i13 = (int) rectF.left;
            i14 = (int) rectF.top;
            int width2 = (int) rectF.width();
            int height3 = (int) rectF.height();
            if (height <= f11) {
                int i21 = (int) (((float) height3) / f11);
                i13 += (width2 - i21) / 2;
                i11 = height3;
                i12 = i21;
            } else {
                int i22 = (int) (((float) width2) * f11);
                i14 += (height3 - i22) / 2;
                i11 = i22;
                i12 = width2;
            }
        }
        if (size.getWidth() == -1) {
            size2.setWidth(metaData.isPortrait() ? i11 : i12);
        }
        if (size.getHeight() == -1) {
            size2.setHeight(metaData.isPortrait() ? i12 : i11);
        }
        int width3 = metaData.getSize().getWidth();
        int height4 = metaData.getSize().getHeight();
        int orientation = metaData.getOrientation() / 90;
        if ((previewProperties.getFrontFacing() || !(orientation == 2 || orientation == 4 || orientation == 3)) && (!previewProperties.getFrontFacing() || !(orientation == 1 || orientation == 2))) {
            i15 = i13;
        } else {
            i15 = (width3 - i12) - i13;
            i14 = (height4 - i11) - i14;
        }
        if (i15 < 0 || i15 > metaData.getSize().getWidth() || i14 < 0 || i14 > metaData.getSize().getHeight() || (i16 = i15 + i12) < 0 || i16 > metaData.getSize().getWidth() || (i17 = i14 + i11) < 0 || i17 > metaData.getSize().getHeight()) {
            d0 d0Var = d0.f56774a;
            Log.w("CameraUtils", String.format(Locale.ENGLISH, "Invalid parameters for cropping: holeLeft: %d ; holeTop: %d ; holeWidth: %d ; holeHeight %d ; previewProperties: %s", Arrays.copyOf(new Object[]{Integer.valueOf(i15), Integer.valueOf(i14), Integer.valueOf(i12), Integer.valueOf(i11), previewProperties}, 5)));
            return null;
        }
        return cropRotateScale(imageSource, previewProperties, metaData, i12, i11, i15, i14, size.getWidth(), size.getHeight());
    }

    public final Rect determineCropRect(Rect rect, float f11) {
        float f12;
        float f13;
        if (rect.isEmpty()) {
            return new Rect(0, 0, 0, 0);
        }
        float width = ((float) rect.width()) / ((float) rect.height());
        float f14 = (float) rect.left;
        float f15 = (float) rect.top;
        if (width <= f11) {
            f13 = ((float) rect.width()) / f11;
            f12 = (float) rect.width();
            f15 += (((float) rect.height()) - f13) / ((float) 2);
        } else {
            f12 = f11 * ((float) rect.height());
            f13 = (float) rect.height();
            f14 += (((float) rect.width()) - f12) / ((float) 2);
        }
        return new Rect((int) f14, (int) f15, (int) (f14 + f12), (int) (f15 + f13));
    }

    public final Bitmap dewarp(ImageSource imageSource, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4, float f11, float f12, Size size) {
        PointF pointF5 = pointF;
        PointF pointF6 = pointF2;
        PointF pointF7 = pointF3;
        PointF pointF8 = pointF4;
        return rgb2bitmap(ImageSource.Warp(imageSource, pointF5.x, pointF5.y, pointF6.x, pointF6.y, pointF7.x, pointF7.y, pointF8.x, pointF8.y, f11, f11, f12, f12, new Size2i(size.getWidth(), size.getHeight())));
    }

    public final Bitmap getBitmap(ImageSource imageSource, PreviewProperties previewProperties, Frame.MetaData metaData, Rect rect) {
        int imageFormat = metaData.getImageFormat();
        if (imageFormat == 17) {
            return yuv2bitmap(imageSource, previewProperties, metaData, rect, -1);
        }
        if (imageFormat == 42) {
            return bitmapFromRgba(imageSource.Width(), imageSource.Height(), imageSource.getImage().toBytes());
        }
        int imageFormat2 = metaData.getImageFormat();
        throw new IllegalArgumentException("Image format conversion for " + imageFormat2 + " is not implemented!");
    }

    public final int getImageRotation(int i11, boolean z11) {
        int i12 = i11 / 90;
        if (z11) {
            return (i12 == 1 || i12 == 3) ? (i12 + 2) % 4 : i12;
        }
        return i12;
    }

    public final ImageOrientation getOrientationName(Frame.MetaData metaData) {
        int orientation = metaData.getOrientation();
        if (orientation == 0) {
            return ImageOrientation.Landscape;
        }
        if (orientation == 90) {
            return ImageOrientation.Portrait;
        }
        if (orientation == 180) {
            return ImageOrientation.InvertedLandscape;
        }
        if (orientation != 270) {
            return ImageOrientation.Unknown;
        }
        return ImageOrientation.InvertedPortrait;
    }

    public final Size2i getRotatedSize(int i11, int i12, Frame.MetaData metaData) {
        return metaData.isPortrait() ? new Size2i(i12, i11) : new Size2i(i11, i12);
    }

    public final RectF previewToSurface(PreviewProperties previewProperties, RectF rectF) {
        Matrix matrix = new Matrix();
        float width = ((float) previewProperties.getScaledPreview().getWidth()) / ((float) previewProperties.getPreview().getWidth());
        float height = ((float) previewProperties.getScaledPreview().getHeight()) / ((float) previewProperties.getPreview().getHeight());
        if (previewProperties.getFrontFacing()) {
            matrix.setScale(width * ((float) -1), height);
            matrix.postTranslate((float) previewProperties.getScaledPreview().getWidth(), 0.0f);
        } else {
            matrix.setScale(width, height);
        }
        RectF rectF2 = new RectF(rectF);
        RectF rectF3 = new RectF();
        matrix.mapRect(rectF3, rectF2);
        rectF3.offset(((float) (previewProperties.getSurface().getWidth() - previewProperties.getScaledPreview().getWidth())) / 2.0f, ((float) (previewProperties.getSurface().getHeight() - previewProperties.getScaledPreview().getHeight())) / 2.0f);
        return rectF3;
    }

    public final Bitmap readBitmap(String str, AuthorizationModel.SessionKey sessionKey) {
        return readBitmap$default(this, str, sessionKey, (BitmapFactory.Options) null, 4, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: javax.crypto.CipherInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: javax.crypto.CipherInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: javax.crypto.CipherInputStream} */
    /* JADX WARNING: type inference failed for: r1v0, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.InputStream] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0024 A[SYNTHETIC, Splitter:B:15:0x0024] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0032 A[SYNTHETIC, Splitter:B:24:0x0032] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap readBitmap(java.lang.String r4, com.jumio.core.models.AuthorizationModel.SessionKey r5, android.graphics.BitmapFactory.Options r6) {
        /*
            r3 = this;
            r0 = 0
            javax.crypto.CipherInputStream r1 = new javax.crypto.CipherInputStream     // Catch:{ Exception -> 0x001d, all -> 0x001b }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x001d, all -> 0x001b }
            r2.<init>(r4)     // Catch:{ Exception -> 0x001d, all -> 0x001b }
            javax.crypto.Cipher r4 = r5.getDecryptCipher()     // Catch:{ Exception -> 0x001d, all -> 0x001b }
            r1.<init>(r2, r4)     // Catch:{ Exception -> 0x001d, all -> 0x001b }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r1, r0, r6)     // Catch:{ Exception -> 0x0019, all -> 0x0017 }
            r1.close()     // Catch:{ IOException -> 0x0028 }
            goto L_0x002c
        L_0x0017:
            r4 = move-exception
            goto L_0x0030
        L_0x0019:
            r4 = move-exception
            goto L_0x001f
        L_0x001b:
            r4 = move-exception
            goto L_0x002f
        L_0x001d:
            r4 = move-exception
            r1 = r0
        L_0x001f:
            com.jumio.commons.log.Log.printStackTrace(r4)     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x002c
            r1.close()     // Catch:{ IOException -> 0x0028 }
            goto L_0x002c
        L_0x0028:
            r4 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r4)
        L_0x002c:
            return r0
        L_0x002d:
            r4 = move-exception
            r0 = r1
        L_0x002f:
            r1 = r0
        L_0x0030:
            if (r1 == 0) goto L_0x003a
            r1.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r5 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r5)
        L_0x003a:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.camera.CameraUtils.readBitmap(java.lang.String, com.jumio.core.models.AuthorizationModel$SessionKey, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029 A[SYNTHETIC, Splitter:B:16:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0034 A[SYNTHETIC, Splitter:B:21:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void saveBitmap(android.graphics.Bitmap r5, java.io.File r6, android.graphics.Bitmap.CompressFormat r7, int r8, com.jumio.core.models.AuthorizationModel.SessionKey r9) {
        /*
            r4 = this;
            java.lang.String r0 = "CameraUtils"
            r1 = 0
            javax.crypto.CipherOutputStream r2 = new javax.crypto.CipherOutputStream     // Catch:{ Exception -> 0x0023 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0023 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0023 }
            javax.crypto.Cipher r6 = r9.getEncryptCipher()     // Catch:{ Exception -> 0x0023 }
            r2.<init>(r3, r6)     // Catch:{ Exception -> 0x0023 }
            r5.compress(r7, r8, r2)     // Catch:{ Exception -> 0x001e, all -> 0x001b }
            r2.flush()     // Catch:{ Exception -> 0x001e, all -> 0x001b }
            r2.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x0031
        L_0x001b:
            r5 = move-exception
            r1 = r2
            goto L_0x0032
        L_0x001e:
            r5 = move-exception
            r1 = r2
            goto L_0x0024
        L_0x0021:
            r5 = move-exception
            goto L_0x0032
        L_0x0023:
            r5 = move-exception
        L_0x0024:
            com.jumio.commons.log.Log.e((java.lang.String) r0, (java.lang.Throwable) r5)     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0031
            r1.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r5 = move-exception
            com.jumio.commons.log.Log.e((java.lang.String) r0, (java.lang.Throwable) r5)
        L_0x0031:
            return
        L_0x0032:
            if (r1 == 0) goto L_0x003c
            r1.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r6 = move-exception
            com.jumio.commons.log.Log.e((java.lang.String) r0, (java.lang.Throwable) r6)
        L_0x003c:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.camera.CameraUtils.saveBitmap(android.graphics.Bitmap, java.io.File, android.graphics.Bitmap$CompressFormat, int, com.jumio.core.models.AuthorizationModel$SessionKey):void");
    }

    public final RectF surfaceToCamera(PreviewProperties previewProperties, Frame.MetaData metaData, Rect rect) {
        return surfaceToPreview(previewProperties, rect, new a(metaData));
    }

    public final RectF surfaceToPreview(PreviewProperties previewProperties, Rect rect, l<? super Matrix, Unit> lVar) {
        Matrix matrix = new Matrix();
        matrix.setScale(((float) previewProperties.getPreview().getWidth()) / ((float) previewProperties.getScaledPreview().getWidth()), ((float) previewProperties.getPreview().getHeight()) / ((float) previewProperties.getScaledPreview().getHeight()));
        if (lVar != null) {
            lVar.invoke(matrix);
        }
        RectF rectF = new RectF(rect);
        rectF.offset(((float) (previewProperties.getScaledPreview().getWidth() - previewProperties.getSurface().getWidth())) / 2.0f, ((float) (previewProperties.getScaledPreview().getHeight() - previewProperties.getSurface().getHeight())) / 2.0f);
        RectF rectF2 = new RectF();
        matrix.mapRect(rectF2, rectF);
        return rectF2;
    }

    public final Bitmap yuv2bitmap(ImageSource imageSource, PreviewProperties previewProperties, Frame.MetaData metaData, Rect rect, int i11) {
        ImageSource yuv2rgb = yuv2rgb(imageSource, previewProperties, metaData, rect, new Size(-1, -1), i11);
        if (yuv2rgb == null) {
            return null;
        }
        Bitmap rgb2bitmap = rgb2bitmap(yuv2rgb);
        yuv2rgb.delete();
        return rgb2bitmap;
    }

    public final ImageSource yuv2rgb(ImageSource imageSource, PreviewProperties previewProperties, Frame.MetaData metaData, Rect rect, Size size, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        Size size2 = size;
        int i19 = i11;
        RectF surfaceToPreview$default = surfaceToPreview$default(this, previewProperties, rect, (l) null, 4, (Object) null);
        if (metaData.isPortrait()) {
            i17 = (int) surfaceToPreview$default.width();
            i16 = (int) surfaceToPreview$default.height();
            i13 = (int) surfaceToPreview$default.top;
            i14 = i17;
            i15 = i16;
            i12 = (int) surfaceToPreview$default.left;
        } else {
            int i21 = (int) surfaceToPreview$default.top;
            i14 = (int) surfaceToPreview$default.height();
            i13 = (int) surfaceToPreview$default.left;
            i17 = (int) surfaceToPreview$default.width();
            i15 = i17;
            i12 = i21;
            i16 = i14;
        }
        if (i19 == -1 || (i17 <= i19 && i16 <= i19)) {
            i19 = i16;
        } else if (i17 > i16) {
            i17 = i19;
            i19 = (int) (((float) i19) * (((float) i16) / ((float) i17)));
        } else {
            i17 = (int) (((float) i19) * (((float) i17) / ((float) i16)));
        }
        if (size2 != null) {
            if (size.getWidth() == -1) {
                size2.setWidth(i17);
            } else {
                i17 = size.getWidth();
            }
            if (size.getHeight() == -1) {
                size2.setHeight(i19);
            } else {
                i18 = size.getHeight();
                return cropRotateScale(imageSource, previewProperties, metaData, i15, i14, i13, i12, i17, i18);
            }
        }
        i18 = i19;
        return cropRotateScale(imageSource, previewProperties, metaData, i15, i14, i13, i12, i17, i18);
    }

    public final int getImageRotation(PreviewProperties previewProperties, Frame.MetaData metaData) {
        return getImageRotation(metaData.getOrientation(), previewProperties.getFrontFacing());
    }

    public final Bitmap rgb2bitmap(ImageSource imageSource, int i11, int i12, int i13) throws Exception {
        return rgb2bitmap(ImageSource.CropRotateScale(imageSource, new Rect2i(0, 0, imageSource.Width(), imageSource.Height()), i13, new Size2i(i11, i12)));
    }

    public final Bitmap rgb2bitmap(ImageSource imageSource, int i11) {
        Bitmap rgb2bitmap = rgb2bitmap(imageSource);
        Bitmap createBitmap = Bitmap.createBitmap(rgb2bitmap.getWidth(), rgb2bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, rgb2bitmap.getWidth(), rgb2bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        float f11 = (float) i11;
        canvas.drawRoundRect(rectF, f11, f11, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(rgb2bitmap, rect, rect, paint);
        return createBitmap;
    }
}
