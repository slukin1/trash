package com.jumio.core.extraction.liveness.extraction;

import android.content.Context;
import android.graphics.Rect;
import com.jumio.commons.camera.Frame;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.log.Log;
import com.jumio.core.environment.Environment;
import com.jumio.core.models.AuthorizationModel;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import java.io.File;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class FaceManualSequenceCache {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentLinkedQueue f39193a = new ConcurrentLinkedQueue();

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<ImageData> f39194b = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    public final int f39195c;

    /* renamed from: d  reason: collision with root package name */
    public final int f39196d;

    /* renamed from: e  reason: collision with root package name */
    public final File f39197e;

    /* renamed from: f  reason: collision with root package name */
    public long f39198f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f39199g;

    /* renamed from: h  reason: collision with root package name */
    public int f39200h;

    /* renamed from: i  reason: collision with root package name */
    public final AuthorizationModel.SessionKey f39201i;

    public FaceManualSequenceCache(Context context, AuthorizationModel.SessionKey sessionKey, int i11, int i12) {
        this.f39197e = Environment.INSTANCE.getDataDirectory(context);
        this.f39201i = sessionKey;
        this.f39195c = i11;
        this.f39196d = i12;
        reset();
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005d A[SYNTHETIC, Splitter:B:29:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.jumio.jvision.jvcorejava.swig.ImageSource r9, com.jumio.commons.camera.PreviewProperties r10, com.jumio.commons.camera.Frame.MetaData r11, android.graphics.Rect r12) {
        /*
            r8 = this;
            boolean r0 = r12.isEmpty()
            if (r0 != 0) goto L_0x00f8
            com.jumio.commons.camera.CameraUtils r0 = com.jumio.commons.camera.CameraUtils.INSTANCE
            android.graphics.RectF r1 = r0.surfaceToCamera(r10, r11, r12)
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            r1.roundOut(r2)
            int r1 = r9.Width()
            int r3 = r2.left
            r4 = 0
            r5 = 1
            if (r3 < 0) goto L_0x0022
            if (r3 > r1) goto L_0x0022
            r1 = r5
            goto L_0x0023
        L_0x0022:
            r1 = r4
        L_0x0023:
            if (r1 == 0) goto L_0x0058
            int r1 = r9.Height()
            int r3 = r2.top
            if (r3 < 0) goto L_0x0031
            if (r3 > r1) goto L_0x0031
            r1 = r5
            goto L_0x0032
        L_0x0031:
            r1 = r4
        L_0x0032:
            if (r1 == 0) goto L_0x0058
            int r1 = r9.Width()
            int r3 = r2.width()
            if (r3 < 0) goto L_0x0042
            if (r3 > r1) goto L_0x0042
            r1 = r5
            goto L_0x0043
        L_0x0042:
            r1 = r4
        L_0x0043:
            if (r1 == 0) goto L_0x0058
            int r1 = r9.Height()
            int r2 = r2.height()
            if (r2 < 0) goto L_0x0053
            if (r2 > r1) goto L_0x0053
            r1 = r5
            goto L_0x0054
        L_0x0053:
            r1 = r4
        L_0x0054:
            if (r1 == 0) goto L_0x0058
            r1 = r5
            goto L_0x0059
        L_0x0058:
            r1 = r4
        L_0x0059:
            if (r1 != 0) goto L_0x005d
            goto L_0x00f8
        L_0x005d:
            kotlin.jvm.internal.d0 r1 = kotlin.jvm.internal.d0.f56774a     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            java.util.Locale r1 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            java.lang.String r2 = "tmp_%04d"
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            int r6 = r8.f39200h     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            int r7 = r6 + 1
            r8.f39200h = r7     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            r3[r4] = r6     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r5)     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            java.lang.String r7 = java.lang.String.format(r1, r2, r3)     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            r6 = 640(0x280, float:8.97E-43)
            r1 = r0
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            android.graphics.Bitmap r9 = r1.yuv2bitmap(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            java.io.File r10 = new java.io.File     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            java.io.File r11 = r8.f39197e     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            r10.<init>(r11, r7)     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            if (r9 != 0) goto L_0x008e
            return
        L_0x008e:
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            r5 = 70
            com.jumio.core.models.AuthorizationModel$SessionKey r6 = r8.f39201i     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            r1 = r0
            r2 = r9
            r3 = r10
            r1.saveBitmap(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            com.jumio.commons.camera.ImageData r11 = new com.jumio.commons.camera.ImageData     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            r11.<init>()     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            java.lang.String r10 = r10.getAbsolutePath()     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            r11.setPath(r10)     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            com.jumio.commons.camera.Size r10 = r11.getSize()     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            int r12 = r9.getWidth()     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            r10.setWidth(r12)     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            com.jumio.commons.camera.Size r10 = r11.getSize()     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            int r9 = r9.getHeight()     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            r10.setHeight(r9)     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            java.lang.String r9 = "image/jpeg"
            r11.setMimeType(r9)     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            java.lang.String r9 = "JPG"
            r11.setFileType(r9)     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            java.util.LinkedList<com.jumio.commons.camera.ImageData> r9 = r8.f39194b     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            r9.addFirst(r11)     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            java.util.LinkedList<com.jumio.commons.camera.ImageData> r9 = r8.f39194b     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            int r9 = r9.size()     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            int r10 = r8.f39196d     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            if (r9 <= r10) goto L_0x00eb
            java.util.LinkedList<com.jumio.commons.camera.ImageData> r9 = r8.f39194b     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            java.lang.Object r9 = r9.removeLast()     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            com.jumio.commons.camera.ImageData r9 = (com.jumio.commons.camera.ImageData) r9     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            java.io.File r10 = new java.io.File     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            java.io.File r11 = r8.f39197e     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            java.lang.String r9 = r9.getPath()     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            r10.<init>(r11, r9)     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            r10.delete()     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
        L_0x00eb:
            java.lang.System.gc()     // Catch:{ Exception -> 0x00f4, OutOfMemoryError -> 0x00ef }
            goto L_0x00f8
        L_0x00ef:
            r9 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r9)
            goto L_0x00f8
        L_0x00f4:
            r9 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r9)
        L_0x00f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.extraction.liveness.extraction.FaceManualSequenceCache.a(com.jumio.jvision.jvcorejava.swig.ImageSource, com.jumio.commons.camera.PreviewProperties, com.jumio.commons.camera.Frame$MetaData, android.graphics.Rect):void");
    }

    public final void addSync(ImageSource imageSource, PreviewProperties previewProperties, Frame.MetaData metaData, Rect rect) {
        try {
            if (this.f39195c == 0) {
                return;
            }
            if (!rect.isEmpty()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f39198f < 500) {
                    return;
                }
                if (this.f39199g) {
                    this.f39198f = currentTimeMillis;
                    a(imageSource, previewProperties, metaData, rect);
                }
            }
        } catch (OutOfMemoryError e11) {
            Log.printStackTrace(e11);
            System.gc();
        }
    }

    public final ImageData[] finish() {
        this.f39199g = false;
        int size = this.f39194b.size();
        int i11 = this.f39195c;
        if (size <= i11) {
            return (ImageData[]) CollectionsKt___CollectionsKt.u0(this.f39194b).toArray(new ImageData[0]);
        }
        return (ImageData[]) CollectionsKt___CollectionsKt.u0(CollectionsKt___CollectionsKt.C0(this.f39194b, i11)).toArray(new ImageData[0]);
    }

    public final synchronized boolean isActive() {
        return this.f39199g;
    }

    public final void reset() {
        this.f39193a.clear();
        this.f39194b.clear();
        System.gc();
        this.f39200h = 0;
    }

    public final synchronized void setActive(boolean z11) {
        this.f39199g = z11;
    }
}
