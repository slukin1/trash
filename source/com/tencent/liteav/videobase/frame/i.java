package com.tencent.liteav.videobase.frame;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.videobase.a.a;
import com.tencent.liteav.videobase.b.d;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.c.c;
import com.tencent.liteav.videobase.c.e;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static final float[] f22215a = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: b  reason: collision with root package name */
    private static final float[] f22216b = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: c  reason: collision with root package name */
    private static final float[] f22217c = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};

    /* renamed from: d  reason: collision with root package name */
    private static final float[] f22218d = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: e  reason: collision with root package name */
    private int f22219e;

    /* renamed from: f  reason: collision with root package name */
    private int f22220f;

    /* renamed from: g  reason: collision with root package name */
    private final FloatBuffer f22221g;

    /* renamed from: h  reason: collision with root package name */
    private final FloatBuffer f22222h;

    /* renamed from: i  reason: collision with root package name */
    private final a[] f22223i = new a[GLConstants.PixelFormatType.values().length];

    /* renamed from: j  reason: collision with root package name */
    private GLConstants.GLScaleType f22224j;

    /* renamed from: k  reason: collision with root package name */
    private PixelFrame f22225k = null;

    /* renamed from: l  reason: collision with root package name */
    private com.tencent.liteav.videobase.b.a f22226l = null;

    /* renamed from: m  reason: collision with root package name */
    private a f22227m = null;

    /* renamed from: n  reason: collision with root package name */
    private c f22228n;

    /* renamed from: com.tencent.liteav.videobase.frame.i$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22229a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.tencent.liteav.base.util.k[] r0 = com.tencent.liteav.base.util.k.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22229a = r0
                com.tencent.liteav.base.util.k r1 = com.tencent.liteav.base.util.k.ROTATION_90     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22229a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.liteav.base.util.k r1 = com.tencent.liteav.base.util.k.ROTATION_180     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f22229a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.liteav.base.util.k r1 = com.tencent.liteav.base.util.k.ROTATION_270     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f22229a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tencent.liteav.base.util.k r1 = com.tencent.liteav.base.util.k.NORMAL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videobase.frame.i.AnonymousClass1.<clinit>():void");
        }
    }

    public i(int i11, int i12) {
        this.f22219e = i11;
        this.f22220f = i12;
        float[] fArr = GLConstants.f22074d;
        this.f22221g = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr);
        this.f22222h = OpenGlUtils.createTextureCoordsBuffer(k.NORMAL, false, false);
    }

    private static float a(float f11) {
        return f11 == 0.0f ? 1.0f : 0.0f;
    }

    private static float a(float f11, float f12) {
        return f11 == 0.0f ? f12 : 1.0f - f12;
    }

    private void b() {
        PixelFrame pixelFrame = this.f22225k;
        if (pixelFrame != null) {
            boolean z11 = pixelFrame.getRotation() == k.ROTATION_90 || this.f22225k.getRotation() == k.ROTATION_270;
            float width = (float) this.f22225k.getWidth();
            float height = (float) this.f22225k.getHeight();
            float max = Math.max((((float) this.f22219e) * 1.0f) / width, (((float) this.f22220f) * 1.0f) / height);
            float round = (((float) Math.round(width * max)) * 1.0f) / ((float) this.f22219e);
            float round2 = (((float) Math.round(height * max)) * 1.0f) / ((float) this.f22220f);
            float[] fArr = GLConstants.f22074d;
            float[] fArr2 = new float[8];
            if (this.f22225k.getPixelBufferType() == GLConstants.a.TEXTURE_OES) {
                a(fArr2, this.f22225k.getRotation(), this.f22225k.isMirrorHorizontal(), this.f22225k.isMirrorVertical());
            } else {
                OpenGlUtils.initTextureCoordsBuffer(fArr2, this.f22225k.getRotation(), this.f22225k.isMirrorHorizontal(), this.f22225k.isMirrorVertical());
            }
            GLConstants.GLScaleType gLScaleType = this.f22224j;
            if (gLScaleType == GLConstants.GLScaleType.CENTER_CROP) {
                float f11 = (1.0f - (z11 ? 1.0f / round2 : 1.0f / round)) / 2.0f;
                float f12 = (1.0f - (z11 ? 1.0f / round : 1.0f / round2)) / 2.0f;
                fArr2[0] = a(fArr2[0], f11);
                fArr2[1] = a(fArr2[1], f12);
                fArr2[2] = a(fArr2[2], f11);
                fArr2[3] = a(fArr2[3], f12);
                fArr2[4] = a(fArr2[4], f11);
                fArr2[5] = a(fArr2[5], f12);
                fArr2[6] = a(fArr2[6], f11);
                fArr2[7] = a(fArr2[7], f12);
            } else if (gLScaleType == GLConstants.GLScaleType.FIT_CENTER) {
                fArr = new float[]{fArr[0] / round2, fArr[1] / round, fArr[2] / round2, fArr[3] / round, fArr[4] / round2, fArr[5] / round, fArr[6] / round2, fArr[7] / round};
            }
            this.f22221g.clear();
            this.f22221g.put(fArr).position(0);
            this.f22222h.clear();
            this.f22222h.put(fArr2).position(0);
        }
    }

    private void c() {
        if (this.f22227m == null) {
            a aVar = new a();
            this.f22227m = aVar;
            aVar.a((e) null);
        }
    }

    private void d() {
        com.tencent.liteav.videobase.b.a aVar = this.f22226l;
        if (aVar != null) {
            aVar.b();
            this.f22226l = null;
        }
        a aVar2 = this.f22227m;
        if (aVar2 != null) {
            aVar2.b();
            this.f22227m = null;
        }
        c cVar = this.f22228n;
        if (cVar != null) {
            cVar.d();
            this.f22228n = null;
        }
        int i11 = 0;
        while (true) {
            a[] aVarArr = this.f22223i;
            if (i11 < aVarArr.length) {
                if (aVarArr[i11] != null) {
                    aVarArr[i11].b();
                    this.f22223i[i11] = null;
                }
                i11++;
            } else {
                LiteavLog.i("PixelFrameRenderer", "uninitialize GL components");
                return;
            }
        }
    }

    public final void a(PixelFrame pixelFrame, GLConstants.GLScaleType gLScaleType, d dVar) {
        if (pixelFrame == null || !pixelFrame.isFrameDataValid()) {
            LiteavLog.w("PixelFrameRenderer", "renderFrame: pixelFrame is not valid");
            return;
        }
        if (this.f22225k == null || a(pixelFrame, gLScaleType)) {
            this.f22224j = gLScaleType;
            this.f22225k = new PixelFrame(pixelFrame);
            d();
            b();
        }
        if (gLScaleType == GLConstants.GLScaleType.FIT_CENTER) {
            a(dVar);
        }
        if (this.f22225k.getPixelBufferType() == GLConstants.a.BYTE_BUFFER) {
            if (this.f22225k.getPixelFormatType() != GLConstants.PixelFormatType.RGBA) {
                a(this.f22225k.getPixelFormatType(), dVar, pixelFrame.getBuffer(), pixelFrame.getColorRange(), pixelFrame.getColorSpace());
                return;
            }
            a(dVar, (Buffer) pixelFrame.getBuffer());
        } else if (this.f22225k.getPixelBufferType() == GLConstants.a.BYTE_ARRAY) {
            if (this.f22225k.getPixelFormatType() != GLConstants.PixelFormatType.RGBA) {
                a(this.f22225k.getPixelFormatType(), dVar, ByteBuffer.wrap(pixelFrame.getData()), pixelFrame.getColorRange(), pixelFrame.getColorSpace());
                return;
            }
            a(dVar, (Buffer) ByteBuffer.wrap(pixelFrame.getData()));
        } else if (this.f22225k.getPixelBufferType() == GLConstants.a.TEXTURE_OES) {
            a(dVar, pixelFrame.getTextureId(), pixelFrame.getMatrix());
        } else if (this.f22225k.getPixelBufferType() == GLConstants.a.TEXTURE_2D) {
            a(dVar, pixelFrame.getTextureId());
        }
    }

    public final void a(int i11, int i12) {
        if (this.f22219e != i11 || this.f22220f != i12) {
            this.f22219e = i11;
            this.f22220f = i12;
            b();
        }
    }

    public final void a() {
        this.f22225k = null;
        d();
    }

    private boolean a(PixelFrame pixelFrame, GLConstants.GLScaleType gLScaleType) {
        return (gLScaleType == this.f22224j && pixelFrame.getWidth() == this.f22225k.getWidth() && pixelFrame.getHeight() == this.f22225k.getHeight() && pixelFrame.getPixelBufferType() == this.f22225k.getPixelBufferType() && pixelFrame.getPixelFormatType() == this.f22225k.getPixelFormatType() && pixelFrame.isMirrorHorizontal() == this.f22225k.isMirrorHorizontal() && pixelFrame.isMirrorVertical() == this.f22225k.isMirrorVertical() && pixelFrame.getRotation() == this.f22225k.getRotation()) ? false : true;
    }

    private void a(d dVar, Buffer buffer) {
        int ordinal = GLConstants.PixelFormatType.RGBA.ordinal();
        a[] aVarArr = this.f22223i;
        if (aVarArr[ordinal] == null) {
            aVarArr[ordinal] = new d();
            this.f22223i[ordinal].a((e) null);
        }
        d dVar2 = (d) this.f22223i[ordinal];
        dVar2.a(this.f22219e, this.f22220f);
        OpenGlUtils.glViewport(0, 0, this.f22219e, this.f22220f);
        if (this.f22225k.getRotation() == k.ROTATION_90 || this.f22225k.getRotation() == k.ROTATION_270) {
            dVar2.a(buffer, this.f22225k.getHeight(), this.f22225k.getWidth());
        } else {
            dVar2.a(buffer, this.f22225k.getWidth(), this.f22225k.getHeight());
        }
        dVar2.a(-1, dVar, this.f22221g, this.f22222h);
    }

    private void a(GLConstants.PixelFormatType pixelFormatType, d dVar, ByteBuffer byteBuffer, GLConstants.ColorRange colorRange, GLConstants.ColorSpace colorSpace) {
        int ordinal = pixelFormatType.ordinal();
        a[] aVarArr = this.f22223i;
        if (aVarArr[ordinal] == null) {
            if (pixelFormatType == GLConstants.PixelFormatType.I420) {
                aVarArr[ordinal] = new com.tencent.liteav.videobase.c.a(colorRange, colorSpace);
            } else if (pixelFormatType == GLConstants.PixelFormatType.NV21) {
                aVarArr[ordinal] = new com.tencent.liteav.videobase.c.d();
            } else {
                aVarArr[ordinal] = new c();
            }
            this.f22223i[ordinal].a((e) null);
        }
        e eVar = (e) this.f22223i[ordinal];
        eVar.a(this.f22219e, this.f22220f);
        OpenGlUtils.glViewport(0, 0, this.f22219e, this.f22220f);
        if (this.f22225k.getRotation() == k.ROTATION_90 || this.f22225k.getRotation() == k.ROTATION_270) {
            eVar.a(byteBuffer, this.f22225k.getHeight(), this.f22225k.getWidth());
        } else {
            eVar.a(byteBuffer, this.f22225k.getWidth(), this.f22225k.getHeight());
        }
        eVar.a(-1, dVar, this.f22221g, this.f22222h);
    }

    private void a(d dVar, int i11, float[] fArr) {
        if (this.f22226l == null) {
            com.tencent.liteav.videobase.b.a aVar = new com.tencent.liteav.videobase.b.a();
            this.f22226l = aVar;
            aVar.a((e) null);
        }
        OpenGlUtils.glViewport(0, 0, this.f22219e, this.f22220f);
        com.tencent.liteav.videobase.b.a aVar2 = this.f22226l;
        aVar2.f22057g = fArr;
        aVar2.a(this.f22219e, this.f22220f);
        this.f22226l.a(i11, dVar, this.f22221g, this.f22222h);
    }

    private void a(d dVar, int i11) {
        c();
        OpenGlUtils.glViewport(0, 0, this.f22219e, this.f22220f);
        this.f22227m.a(this.f22219e, this.f22220f);
        this.f22227m.a(i11, dVar, this.f22221g, this.f22222h);
    }

    private void a(d dVar) {
        if (this.f22228n == null) {
            c cVar = new c();
            this.f22228n = cVar;
            cVar.a();
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        if (dVar == null) {
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glClear(16640);
            return;
        }
        this.f22228n.a(dVar.a());
        this.f22228n.b();
        GLES20.glClear(16640);
        OpenGlUtils.bindFramebuffer(36160, 0);
        this.f22228n.c();
    }

    private static void a(float[] fArr, k kVar, boolean z11, boolean z12) {
        float[] fArr2 = f22215a;
        if (kVar != null) {
            int i11 = AnonymousClass1.f22229a[kVar.ordinal()];
            if (i11 == 1) {
                fArr2 = f22216b;
            } else if (i11 == 2) {
                fArr2 = f22218d;
            } else if (i11 == 3) {
                fArr2 = f22217c;
            }
        }
        System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
        if (z11) {
            fArr[0] = a(fArr[0]);
            fArr[2] = a(fArr[2]);
            fArr[4] = a(fArr[4]);
            fArr[6] = a(fArr[6]);
        }
        if (z12) {
            fArr[1] = a(fArr[1]);
            fArr[3] = a(fArr[3]);
            fArr[5] = a(fArr[5]);
            fArr[7] = a(fArr[7]);
        }
    }
}
