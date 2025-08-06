package com.tencent.ugc.videobase.videobase;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.k;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.frame.PixelFramePool;
import com.tencent.ugc.videobase.frame.PixelFrameRenderer;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import com.tencent.ugc.videobase.utils.YUVReadTools;
import com.tencent.ugc.videobase.videobase.FrameConverter;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final GLConstants.PixelFormatType[] f50873a = {GLConstants.PixelFormatType.I420, GLConstants.PixelFormatType.NV21, GLConstants.PixelFormatType.NV12};

    /* renamed from: b  reason: collision with root package name */
    public final FloatBuffer f50874b = OpenGlUtils.createNormalCubeVerticesBuffer();

    /* renamed from: c  reason: collision with root package name */
    public final FloatBuffer f50875c = OpenGlUtils.createTextureCoordsBuffer(k.NORMAL, false, false);

    /* renamed from: d  reason: collision with root package name */
    public final ConvertParams f50876d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<GLConstants.PixelFormatType, List<C0638a>> f50877e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<GLConstants.PixelFormatType, TXCGPUImageFilter> f50878f;

    /* renamed from: g  reason: collision with root package name */
    public PixelFrameRenderer f50879g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f50880h = false;

    /* renamed from: i  reason: collision with root package name */
    public PixelFramePool f50881i;

    /* renamed from: j  reason: collision with root package name */
    public GLTexturePool f50882j;

    /* renamed from: k  reason: collision with root package name */
    private int f50883k = -1;

    /* renamed from: com.tencent.ugc.videobase.videobase.a$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f50884a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.tencent.ugc.videobase.base.GLConstants$PixelFormatType[] r0 = com.tencent.ugc.videobase.base.GLConstants.PixelFormatType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f50884a = r0
                com.tencent.ugc.videobase.base.GLConstants$PixelFormatType r1 = com.tencent.ugc.videobase.base.GLConstants.PixelFormatType.I420     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f50884a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.ugc.videobase.base.GLConstants$PixelFormatType r1 = com.tencent.ugc.videobase.base.GLConstants.PixelFormatType.NV12     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f50884a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.ugc.videobase.base.GLConstants$PixelFormatType r1 = com.tencent.ugc.videobase.base.GLConstants.PixelFormatType.NV21     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.videobase.videobase.a.AnonymousClass1.<clinit>():void");
        }
    }

    /* renamed from: com.tencent.ugc.videobase.videobase.a$a  reason: collision with other inner class name */
    public static class C0638a {

        /* renamed from: a  reason: collision with root package name */
        public final GLConstants.PixelBufferType f50885a;

        /* renamed from: b  reason: collision with root package name */
        public final int f50886b;

        /* renamed from: c  reason: collision with root package name */
        public final FrameConverter.FrameConvertListener f50887c;

        public C0638a(GLConstants.PixelBufferType pixelBufferType, int i11, FrameConverter.FrameConvertListener frameConvertListener) {
            this.f50885a = pixelBufferType;
            this.f50886b = i11;
            this.f50887c = frameConvertListener;
        }
    }

    public a(ConvertParams convertParams) {
        this.f50876d = convertParams;
        this.f50877e = new HashMap();
        this.f50878f = new HashMap();
    }

    public final void a(GLTexturePool gLTexturePool) {
        if (this.f50880h || gLTexturePool == null) {
            LiteavLog.i("SameParamsConverter", "SameParamsConverter mIsInitialized " + this.f50880h + " , texturePool " + gLTexturePool);
            return;
        }
        this.f50880h = true;
        this.f50881i = new PixelFramePool();
        this.f50882j = gLTexturePool;
    }

    public final void a() {
        for (TXCGPUImageFilter uninitialize : this.f50878f.values()) {
            uninitialize.uninitialize();
        }
        this.f50878f.clear();
        PixelFrameRenderer pixelFrameRenderer = this.f50879g;
        if (pixelFrameRenderer != null) {
            pixelFrameRenderer.uninitialize();
            this.f50879g = null;
        }
        PixelFramePool pixelFramePool = this.f50881i;
        if (pixelFramePool != null) {
            pixelFramePool.destroy();
            this.f50881i = null;
        }
        OpenGlUtils.deleteFrameBuffer(this.f50883k);
        this.f50883k = -1;
        this.f50880h = false;
    }

    public final PixelFrame a(long j11, GLTexture gLTexture, GLConstants.PixelFormatType pixelFormatType) {
        GLConstants.PixelBufferType pixelBufferType = GLConstants.PixelBufferType.BYTE_BUFFER;
        int a11 = a(pixelFormatType, pixelBufferType);
        GLConstants.PixelBufferType pixelBufferType2 = GLConstants.PixelBufferType.BYTE_ARRAY;
        int a12 = a(pixelFormatType, pixelBufferType2);
        if (a11 == 0 && a12 == 0) {
            return null;
        }
        boolean z11 = a11 != 0;
        PixelFramePool pixelFramePool = this.f50881i;
        int width = gLTexture.getWidth();
        int height = gLTexture.getHeight();
        if (!z11) {
            pixelBufferType = pixelBufferType2;
        }
        PixelFrame obtain = pixelFramePool.obtain(width, height, pixelBufferType, pixelFormatType);
        obtain.setColorFormat(gLTexture.getColorRange(), gLTexture.getColorSpace());
        if (!obtain.isFrameDataValid()) {
            obtain.release();
            return null;
        }
        a(pixelFormatType, gLTexture, z11 ? obtain.getBuffer() : obtain.getData());
        obtain.setMetaData(gLTexture.getMetaData());
        a(obtain, j11);
        a(j11, obtain, a11, a12);
        return obtain;
    }

    public final void a(long j11, PixelFrame pixelFrame, int i11, int i12) {
        GLConstants.PixelBufferType pixelBufferType = pixelFrame.getPixelBufferType();
        GLConstants.PixelBufferType pixelBufferType2 = GLConstants.PixelBufferType.BYTE_BUFFER;
        boolean z11 = true;
        boolean z12 = pixelBufferType == pixelBufferType2 && i12 != 0;
        GLConstants.PixelBufferType pixelBufferType3 = pixelFrame.getPixelBufferType();
        GLConstants.PixelBufferType pixelBufferType4 = GLConstants.PixelBufferType.BYTE_ARRAY;
        if (pixelBufferType3 != pixelBufferType4 || i11 == 0) {
            z11 = false;
        }
        if (z12 || z11) {
            PixelFramePool pixelFramePool = this.f50881i;
            int width = pixelFrame.getWidth();
            int height = pixelFrame.getHeight();
            if (z12) {
                pixelBufferType2 = pixelBufferType4;
            }
            PixelFrame obtain = pixelFramePool.obtain(width, height, pixelBufferType2, pixelFrame.getPixelFormatType());
            obtain.setColorFormat(pixelFrame.getColorRange(), pixelFrame.getColorSpace());
            if (!obtain.isFrameDataValid()) {
                obtain.release();
                return;
            }
            if (z12) {
                OpenGlUtils.nativeCopyDataFromByteBufferToByteArray(pixelFrame.getBuffer(), obtain.getData(), obtain.getData().length);
            } else {
                OpenGlUtils.nativeCopyDataFromByteArrayToByteBuffer(pixelFrame.getData(), obtain.getBuffer(), pixelFrame.getData().length);
            }
            a(obtain, j11);
            obtain.release();
        }
    }

    private void a(GLConstants.PixelFormatType pixelFormatType, GLTexture gLTexture, Object obj) {
        ConvertParams convertParams = this.f50876d;
        int i11 = convertParams.width;
        int i12 = convertParams.height;
        if (this.f50883k == -1) {
            this.f50883k = OpenGlUtils.generateFrameBufferId();
        }
        OpenGlUtils.attachTextureToFrameBuffer(gLTexture.getId(), this.f50883k);
        GLES20.glBindFramebuffer(36160, this.f50883k);
        if (pixelFormatType == GLConstants.PixelFormatType.RGBA) {
            OpenGlUtils.readPixels(0, 0, i11, i12, obj);
            OpenGlUtils.detachTextureFromFrameBuffer(this.f50883k);
            return;
        }
        if (i12 % 16 == 0) {
            OpenGlUtils.readPixels(0, 0, i11, (i12 * 3) / 8, obj);
        } else if (obj instanceof ByteBuffer) {
            YUVReadTools.nativeReadYUVPlanesForByteBuffer(i11, i12, (ByteBuffer) obj);
        } else {
            YUVReadTools.nativeReadYUVPlanesForByteArray(i11, i12, (byte[]) obj);
        }
        OpenGlUtils.detachTextureFromFrameBuffer(this.f50883k);
    }

    public final void a(PixelFrame pixelFrame, long j11) {
        List list = this.f50877e.get(pixelFrame.getPixelFormatType());
        if (list != null && !list.isEmpty()) {
            pixelFrame.setTimestamp(j11);
            for (C0638a aVar : new ArrayList(list)) {
                if (aVar.f50885a == pixelFrame.getPixelBufferType()) {
                    aVar.f50887c.onFrameConverted(aVar.f50886b, pixelFrame);
                }
            }
        }
    }

    public final int a(GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType) {
        List<C0638a> list = this.f50877e.get(pixelFormatType);
        int i11 = 0;
        if (list != null) {
            for (C0638a aVar : list) {
                if (aVar.f50885a == pixelBufferType) {
                    i11++;
                }
            }
        }
        return i11;
    }

    public final void a(int i11, FrameConverter.FrameConvertListener frameConvertListener) {
        for (Map.Entry next : this.f50877e.entrySet()) {
            Iterator it2 = ((List) next.getValue()).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                C0638a aVar = (C0638a) it2.next();
                if (aVar.f50886b == i11 && aVar.f50887c == frameConvertListener) {
                    ((List) next.getValue()).remove(aVar);
                    break;
                }
            }
            if (((List) next.getValue()).isEmpty()) {
                this.f50877e.remove(next.getKey());
                return;
            }
        }
    }
}
