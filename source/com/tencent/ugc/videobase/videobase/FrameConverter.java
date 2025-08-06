package com.tencent.ugc.videobase.videobase;

import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.videobase.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrameConverter {
    private static final String TAG = "FrameConverter";
    private GLTexturePool mGLTexturePool;
    private final Map<ConvertParams, a> mSameParamsConverts = new HashMap();

    public interface FrameConvertListener {
        void onFrameConverted(int i11, PixelFrame pixelFrame);
    }

    public void addListener(ConvertParams convertParams, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType, int i11, FrameConvertListener frameConvertListener) {
        a aVar = this.mSameParamsConverts.get(convertParams);
        if (aVar == null) {
            aVar = new a(convertParams);
            GLTexturePool gLTexturePool = this.mGLTexturePool;
            if (gLTexturePool != null) {
                aVar.a(gLTexturePool);
            }
            this.mSameParamsConverts.put(convertParams, aVar);
        }
        List<a.C0638a> list = aVar.f50877e.get(pixelFormatType);
        if (list == null) {
            list = new ArrayList<>();
            aVar.f50877e.put(pixelFormatType, list);
        }
        for (a.C0638a aVar2 : list) {
            if (aVar2.f50886b == i11 && aVar2.f50887c == frameConvertListener) {
                return;
            }
        }
        list.add(new a.C0638a(pixelBufferType, i11, frameConvertListener));
    }

    public void initialize(GLTexturePool gLTexturePool) {
        this.mGLTexturePool = gLTexturePool;
        for (a a11 : this.mSameParamsConverts.values()) {
            a11.a(gLTexturePool);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0109 A[EDGE_INSN: B:97:0x0109->B:43:0x0109 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processFrame(long r25, com.tencent.ugc.videobase.frame.GLTexture r27) {
        /*
            r24 = this;
            r0 = r24
            r7 = r25
            java.util.Map<com.tencent.ugc.videobase.videobase.ConvertParams, com.tencent.ugc.videobase.videobase.a> r1 = r0.mSameParamsConverts
            int r1 = r1.size()
            if (r1 > 0) goto L_0x0013
            java.lang.String r1 = "FrameConverter"
            java.lang.String r2 = "process frame without SameParamsConverter."
            com.tencent.liteav.base.util.LiteavLog.w(r1, r2)
        L_0x0013:
            java.util.Map<com.tencent.ugc.videobase.videobase.ConvertParams, com.tencent.ugc.videobase.videobase.a> r1 = r0.mSameParamsConverts
            java.util.Collection r1 = r1.values()
            java.util.Iterator r9 = r1.iterator()
        L_0x001d:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L_0x0253
            java.lang.Object r1 = r9.next()
            r10 = r1
            com.tencent.ugc.videobase.videobase.a r10 = (com.tencent.ugc.videobase.videobase.a) r10
            boolean r1 = r10.f50880h
            if (r1 == 0) goto L_0x0249
            com.tencent.ugc.videobase.videobase.ConvertParams r1 = r10.f50876d
            int r1 = r1.width
            if (r1 == 0) goto L_0x0035
            goto L_0x0039
        L_0x0035:
            int r1 = r27.getWidth()
        L_0x0039:
            com.tencent.ugc.videobase.videobase.ConvertParams r2 = r10.f50876d
            int r2 = r2.height
            if (r2 == 0) goto L_0x0040
            goto L_0x0044
        L_0x0040:
            int r2 = r27.getHeight()
        L_0x0044:
            int r3 = r27.getWidth()
            if (r3 != r1) goto L_0x0063
            int r3 = r27.getHeight()
            if (r3 != r2) goto L_0x0063
            com.tencent.ugc.videobase.videobase.ConvertParams r3 = r10.f50876d
            com.tencent.liteav.base.util.k r4 = r3.rotation
            com.tencent.liteav.base.util.k r5 = com.tencent.liteav.base.util.k.NORMAL
            if (r4 != r5) goto L_0x0063
            boolean r3 = r3.mirror
            if (r3 != 0) goto L_0x0063
            r27.retain()
            r11 = r27
            r12 = r11
            goto L_0x00d3
        L_0x0063:
            com.tencent.ugc.videobase.frame.PixelFrameRenderer r3 = r10.f50879g
            if (r3 != 0) goto L_0x006e
            com.tencent.ugc.videobase.frame.PixelFrameRenderer r3 = new com.tencent.ugc.videobase.frame.PixelFrameRenderer
            r3.<init>(r1, r2)
            r10.f50879g = r3
        L_0x006e:
            java.lang.Object r3 = com.tencent.ugc.videobase.utils.OpenGlUtils.getCurrentContext()
            r11 = r27
            com.tencent.ugc.videobase.frame.PixelFrame r3 = r11.wrap(r3)
            com.tencent.ugc.videobase.videobase.ConvertParams r4 = r10.f50876d
            com.tencent.liteav.base.util.k r4 = r4.rotation
            com.tencent.liteav.base.util.k r5 = com.tencent.liteav.base.util.k.ROTATION_90
            if (r4 == r5) goto L_0x0094
            com.tencent.liteav.base.util.k r5 = com.tencent.liteav.base.util.k.ROTATION_270
            if (r4 != r5) goto L_0x0085
            goto L_0x0094
        L_0x0085:
            int r4 = r27.getWidth()
            r3.setWidth(r4)
            int r4 = r27.getHeight()
            r3.setHeight(r4)
            goto L_0x00a2
        L_0x0094:
            int r4 = r27.getHeight()
            r3.setWidth(r4)
            int r4 = r27.getWidth()
            r3.setHeight(r4)
        L_0x00a2:
            com.tencent.ugc.videobase.videobase.ConvertParams r4 = r10.f50876d
            com.tencent.liteav.base.util.k r4 = r4.rotation
            r3.setRotation(r4)
            com.tencent.ugc.videobase.videobase.ConvertParams r4 = r10.f50876d
            boolean r4 = r4.mirror
            r3.setMirrorHorizontal(r4)
            com.tencent.ugc.videobase.frame.GLTexturePool r4 = r10.f50882j
            com.tencent.ugc.videobase.frame.GLTexture r1 = r4.obtain(r1, r2)
            com.tencent.ugc.videobase.base.GLConstants$ColorRange r2 = r3.getColorRange()
            com.tencent.ugc.videobase.base.GLConstants$ColorSpace r4 = r3.getColorSpace()
            r1.setColorFormat(r2, r4)
            com.tencent.ugc.videobase.frame.FrameMetaData r2 = r27.getMetaData()
            r1.setMetaData(r2)
            com.tencent.ugc.videobase.frame.PixelFrameRenderer r2 = r10.f50879g
            com.tencent.ugc.videobase.base.GLConstants$GLScaleType r4 = com.tencent.ugc.videobase.base.GLConstants.GLScaleType.CENTER_CROP
            r2.renderFrame(r3, r4, r1)
            r3.release()
            r12 = r1
        L_0x00d3:
            java.lang.Object r1 = com.tencent.ugc.videobase.utils.OpenGlUtils.getCurrentContext()
            com.tencent.ugc.videobase.frame.PixelFrame r1 = r12.wrap(r1)
            com.tencent.ugc.videobase.frame.FrameMetaData r2 = r12.getMetaData()
            r1.setMetaData(r2)
            r10.a((com.tencent.ugc.videobase.frame.PixelFrame) r1, (long) r7)
            r1.release()
            com.tencent.ugc.videobase.base.GLConstants$PixelFormatType r1 = com.tencent.ugc.videobase.base.GLConstants.PixelFormatType.RGBA
            com.tencent.ugc.videobase.frame.PixelFrame r1 = r10.a((long) r7, (com.tencent.ugc.videobase.frame.GLTexture) r12, (com.tencent.ugc.videobase.base.GLConstants.PixelFormatType) r1)
            if (r1 == 0) goto L_0x00f3
            r1.release()
        L_0x00f3:
            r1 = -1
            r3 = 0
        L_0x00f5:
            com.tencent.ugc.videobase.base.GLConstants$PixelFormatType[] r4 = com.tencent.ugc.videobase.videobase.a.f50873a
            int r5 = r4.length
            if (r3 >= r5) goto L_0x0109
            java.util.Map<com.tencent.ugc.videobase.base.GLConstants$PixelFormatType, java.util.List<com.tencent.ugc.videobase.videobase.a$a>> r5 = r10.f50877e
            r6 = r4[r3]
            boolean r5 = r5.containsKey(r6)
            if (r5 == 0) goto L_0x0106
            r1 = r3
            goto L_0x0109
        L_0x0106:
            int r3 = r3 + 1
            goto L_0x00f5
        L_0x0109:
            if (r1 < 0) goto L_0x0243
            int r6 = r12.getWidth()
            int r5 = r12.getHeight()
            com.tencent.ugc.videobase.base.GLConstants$ColorRange r3 = r12.getColorRange()
            com.tencent.ugc.videobase.base.GLConstants$ColorSpace r15 = r12.getColorSpace()
            com.tencent.ugc.videobase.frame.GLTexturePool r13 = r10.f50882j
            com.tencent.ugc.videobase.frame.GLTexture r13 = r13.obtain(r6, r5)
            r13.setColorFormat(r3, r15)
            r14 = r4[r1]
            if (r14 != 0) goto L_0x012c
        L_0x0128:
            r20 = r9
            r2 = 0
            goto L_0x0180
        L_0x012c:
            java.util.Map<com.tencent.ugc.videobase.base.GLConstants$PixelFormatType, com.tencent.ugc.videobase.chain.TXCGPUImageFilter> r2 = r10.f50878f
            java.lang.Object r2 = r2.get(r14)
            com.tencent.ugc.videobase.chain.TXCGPUImageFilter r2 = (com.tencent.ugc.videobase.chain.TXCGPUImageFilter) r2
            if (r2 != 0) goto L_0x017e
            int[] r2 = com.tencent.ugc.videobase.videobase.a.AnonymousClass1.f50884a
            int r17 = r14.ordinal()
            r2 = r2[r17]
            r0 = 1
            if (r2 == r0) goto L_0x0156
            r0 = 2
            if (r2 == r0) goto L_0x014e
            r0 = 3
            if (r2 == r0) goto L_0x0148
            goto L_0x0128
        L_0x0148:
            com.tencent.ugc.videobase.yuv.TXCGPUImageRGBAToNV21Filter r0 = new com.tencent.ugc.videobase.yuv.TXCGPUImageRGBAToNV21Filter
            r0.<init>()
            goto L_0x0153
        L_0x014e:
            com.tencent.ugc.videobase.yuv.TXCGPUImageRGBAToNV12Filter r0 = new com.tencent.ugc.videobase.yuv.TXCGPUImageRGBAToNV12Filter
            r0.<init>()
        L_0x0153:
            r2 = r0
            r0 = 0
            goto L_0x016a
        L_0x0156:
            com.tencent.ugc.videobase.videobase.ConvertParams r0 = r10.f50876d
            int r0 = r0.height
            int r0 = r0 % 16
            if (r0 != 0) goto L_0x0164
            com.tencent.ugc.videobase.yuv.TXCGPUImageRGBAToI420Filter r0 = new com.tencent.ugc.videobase.yuv.TXCGPUImageRGBAToI420Filter
            r0.<init>()
            goto L_0x0153
        L_0x0164:
            com.tencent.ugc.videobase.yuv.TXCGPUImageRGBAToI420NoDiv16Filter r0 = new com.tencent.ugc.videobase.yuv.TXCGPUImageRGBAToI420NoDiv16Filter
            r0.<init>()
            goto L_0x0153
        L_0x016a:
            r2.initialize(r0)
            com.tencent.ugc.videobase.videobase.ConvertParams r0 = r10.f50876d
            r20 = r9
            int r9 = r0.width
            int r0 = r0.height
            r2.onOutputSizeChanged(r9, r0)
            java.util.Map<com.tencent.ugc.videobase.base.GLConstants$PixelFormatType, com.tencent.ugc.videobase.chain.TXCGPUImageFilter> r0 = r10.f50878f
            r0.put(r14, r2)
            goto L_0x0180
        L_0x017e:
            r20 = r9
        L_0x0180:
            if (r2 == 0) goto L_0x0245
            r0 = 0
            com.tencent.ugc.videobase.utils.OpenGlUtils.glViewport(r0, r0, r6, r5)
            r2.setColorFormat(r3, r15)
            int r0 = r12.getId()
            java.nio.FloatBuffer r9 = r10.f50874b
            java.nio.FloatBuffer r14 = r10.f50875c
            r2.onDraw(r0, r13, r9, r14)
            com.tencent.ugc.videobase.frame.FrameMetaData r0 = r12.getMetaData()
            r13.setMetaData(r0)
            r0 = r4[r1]
            com.tencent.ugc.videobase.frame.PixelFrame r0 = r10.a((long) r7, (com.tencent.ugc.videobase.frame.GLTexture) r13, (com.tencent.ugc.videobase.base.GLConstants.PixelFormatType) r0)
            if (r0 == 0) goto L_0x0245
            r13.release()
            com.tencent.ugc.videobase.base.GLConstants$PixelBufferType r2 = r0.getPixelBufferType()
            com.tencent.ugc.videobase.base.GLConstants$PixelBufferType r4 = com.tencent.ugc.videobase.base.GLConstants.PixelBufferType.BYTE_BUFFER
            if (r2 != r4) goto L_0x01b3
            java.nio.ByteBuffer r2 = r0.getBuffer()
            goto L_0x01b7
        L_0x01b3:
            byte[] r2 = r0.getData()
        L_0x01b7:
            r9 = r2
            int r1 = r1 + 1
            r4 = r1
        L_0x01bb:
            com.tencent.ugc.videobase.base.GLConstants$PixelFormatType[] r1 = com.tencent.ugc.videobase.videobase.a.f50873a
            int r2 = r1.length
            if (r4 >= r2) goto L_0x023f
            r2 = r1[r4]
            com.tencent.ugc.videobase.base.GLConstants$PixelBufferType r13 = com.tencent.ugc.videobase.base.GLConstants.PixelBufferType.BYTE_BUFFER
            int r21 = r10.a((com.tencent.ugc.videobase.base.GLConstants.PixelFormatType) r2, (com.tencent.ugc.videobase.base.GLConstants.PixelBufferType) r13)
            r2 = r1[r4]
            com.tencent.ugc.videobase.base.GLConstants$PixelBufferType r14 = com.tencent.ugc.videobase.base.GLConstants.PixelBufferType.BYTE_ARRAY
            int r22 = r10.a((com.tencent.ugc.videobase.base.GLConstants.PixelFormatType) r2, (com.tencent.ugc.videobase.base.GLConstants.PixelBufferType) r14)
            if (r21 == 0) goto L_0x01dc
            com.tencent.ugc.videobase.frame.PixelFramePool r2 = r10.f50881i
            r1 = r1[r4]
            com.tencent.ugc.videobase.frame.PixelFrame r1 = r2.obtain(r6, r5, r13, r1)
        L_0x01da:
            r2 = r1
            goto L_0x01e8
        L_0x01dc:
            if (r22 == 0) goto L_0x01e7
            com.tencent.ugc.videobase.frame.PixelFramePool r2 = r10.f50881i
            r1 = r1[r4]
            com.tencent.ugc.videobase.frame.PixelFrame r1 = r2.obtain(r6, r5, r14, r1)
            goto L_0x01da
        L_0x01e7:
            r2 = 0
        L_0x01e8:
            if (r2 == 0) goto L_0x022b
            boolean r1 = r2.isFrameDataValid()
            if (r1 == 0) goto L_0x022b
            r2.setColorFormat(r3, r15)
            com.tencent.ugc.videobase.base.GLConstants$PixelFormatType r13 = r0.getPixelFormatType()
            com.tencent.ugc.videobase.base.GLConstants$PixelFormatType r1 = r2.getPixelFormatType()
            java.nio.ByteBuffer r16 = r2.getBuffer()
            r14 = r9
            r23 = r15
            r15 = r1
            r17 = r6
            r18 = r5
            com.tencent.ugc.videobase.utils.OpenGlUtils.convertYuvFormat(r13, r14, r15, r16, r17, r18)
            com.tencent.ugc.videobase.frame.FrameMetaData r1 = r12.getMetaData()
            r2.setMetaData(r1)
            r10.a((com.tencent.ugc.videobase.frame.PixelFrame) r2, (long) r7)
            r1 = r10
            r19 = r2
            r13 = r3
            r14 = 0
            r2 = r25
            r15 = r4
            r4 = r19
            r16 = r5
            r5 = r21
            r6 = r22
            r1.a(r2, r4, r5, r6)
            r19.release()
            goto L_0x0234
        L_0x022b:
            r13 = r3
            r16 = r5
            r17 = r6
            r23 = r15
            r14 = 0
            r15 = r4
        L_0x0234:
            int r4 = r15 + 1
            r3 = r13
            r5 = r16
            r6 = r17
            r15 = r23
            goto L_0x01bb
        L_0x023f:
            r0.release()
            goto L_0x0245
        L_0x0243:
            r20 = r9
        L_0x0245:
            r12.release()
            goto L_0x024d
        L_0x0249:
            r11 = r27
            r20 = r9
        L_0x024d:
            r0 = r24
            r9 = r20
            goto L_0x001d
        L_0x0253:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.videobase.videobase.FrameConverter.processFrame(long, com.tencent.ugc.videobase.frame.GLTexture):void");
    }

    public void removeListener(int i11, FrameConvertListener frameConvertListener) {
        ArrayList<ConvertParams> arrayList = new ArrayList<>();
        for (Map.Entry next : this.mSameParamsConverts.entrySet()) {
            ((a) next.getValue()).a(i11, frameConvertListener);
            if (!(!((a) next.getValue()).f50877e.isEmpty())) {
                arrayList.add(next.getKey());
            }
        }
        for (ConvertParams convertParams : arrayList) {
            a aVar = this.mSameParamsConverts.get(convertParams);
            if (aVar != null) {
                aVar.a();
            }
            this.mSameParamsConverts.remove(convertParams);
        }
    }

    public void uninitialize() {
        for (a a11 : this.mSameParamsConverts.values()) {
            a11.a();
        }
    }
}
