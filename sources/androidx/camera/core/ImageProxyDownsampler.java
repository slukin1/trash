package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.ImageProxy;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.nio.ByteBuffer;

final class ImageProxyDownsampler {

    /* renamed from: androidx.camera.core.ImageProxyDownsampler$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.camera.core.ImageProxyDownsampler$DownsamplingMethod[] r0 = androidx.camera.core.ImageProxyDownsampler.DownsamplingMethod.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod = r0
                androidx.camera.core.ImageProxyDownsampler$DownsamplingMethod r1 = androidx.camera.core.ImageProxyDownsampler.DownsamplingMethod.NEAREST_NEIGHBOR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.core.ImageProxyDownsampler$DownsamplingMethod r1 = androidx.camera.core.ImageProxyDownsampler.DownsamplingMethod.AVERAGING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageProxyDownsampler.AnonymousClass2.<clinit>():void");
        }
    }

    public enum DownsamplingMethod {
        NEAREST_NEIGHBOR,
        AVERAGING
    }

    public static final class ForwardingImageProxyImpl extends ForwardingImageProxy {
        private final int mDownsampledHeight;
        private final ImageProxy.PlaneProxy[] mDownsampledPlanes;
        private final int mDownsampledWidth;

        public ForwardingImageProxyImpl(ImageProxy imageProxy, ImageProxy.PlaneProxy[] planeProxyArr, int i11, int i12) {
            super(imageProxy);
            this.mDownsampledPlanes = planeProxyArr;
            this.mDownsampledWidth = i11;
            this.mDownsampledHeight = i12;
        }

        public int getHeight() {
            return this.mDownsampledHeight;
        }

        public ImageProxy.PlaneProxy[] getPlanes() {
            return this.mDownsampledPlanes;
        }

        public int getWidth() {
            return this.mDownsampledWidth;
        }
    }

    private ImageProxyDownsampler() {
    }

    private static ImageProxy.PlaneProxy createPlaneProxy(int i11, int i12, byte[] bArr) {
        return new ImageProxy.PlaneProxy(bArr, i11, i12) {
            public final ByteBuffer mBuffer;
            public final /* synthetic */ byte[] val$data;
            public final /* synthetic */ int val$pixelStride;
            public final /* synthetic */ int val$rowStride;

            {
                this.val$data = r1;
                this.val$rowStride = r2;
                this.val$pixelStride = r3;
                this.mBuffer = ByteBuffer.wrap(r1);
            }

            public ByteBuffer getBuffer() {
                return this.mBuffer;
            }

            public int getPixelStride() {
                return this.val$pixelStride;
            }

            public int getRowStride() {
                return this.val$rowStride;
            }
        };
    }

    public static ForwardingImageProxy downsample(ImageProxy imageProxy, int i11, int i12, DownsamplingMethod downsamplingMethod) {
        byte[] bArr;
        ImageProxy imageProxy2 = imageProxy;
        int i13 = i11;
        int i14 = i12;
        if (imageProxy.getFormat() != 35) {
            throw new UnsupportedOperationException("Only YUV_420_888 format is currently supported.");
        } else if (imageProxy.getWidth() < i13 || imageProxy.getHeight() < i14) {
            throw new IllegalArgumentException("Downsampled dimension " + new Size(i13, i14) + " is not <= original dimension " + new Size(imageProxy.getWidth(), imageProxy.getHeight()) + InstructionFileId.DOT);
        } else if (imageProxy.getWidth() == i13 && imageProxy.getHeight() == i14) {
            return new ForwardingImageProxyImpl(imageProxy2, imageProxy.getPlanes(), i13, i14);
        } else {
            int[] iArr = {imageProxy.getWidth(), imageProxy.getWidth() / 2, imageProxy.getWidth() / 2};
            int[] iArr2 = {imageProxy.getHeight(), imageProxy.getHeight() / 2, imageProxy.getHeight() / 2};
            int i15 = i13 / 2;
            int[] iArr3 = {i13, i15, i15};
            int i16 = i14 / 2;
            int[] iArr4 = {i14, i16, i16};
            ImageProxy.PlaneProxy[] planeProxyArr = new ImageProxy.PlaneProxy[3];
            for (int i17 = 0; i17 < 3; i17++) {
                ImageProxy.PlaneProxy planeProxy = imageProxy.getPlanes()[i17];
                ByteBuffer buffer = planeProxy.getBuffer();
                byte[] bArr2 = new byte[(iArr3[i17] * iArr4[i17])];
                int i18 = AnonymousClass2.$SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod[downsamplingMethod.ordinal()];
                if (i18 == 1) {
                    bArr = bArr2;
                    resizeNearestNeighbor(buffer, iArr[i17], planeProxy.getPixelStride(), planeProxy.getRowStride(), iArr2[i17], bArr, iArr3[i17], iArr4[i17]);
                } else if (i18 != 2) {
                    bArr = bArr2;
                } else {
                    int i19 = iArr[i17];
                    int pixelStride = planeProxy.getPixelStride();
                    bArr = bArr2;
                    resizeAveraging(buffer, i19, pixelStride, planeProxy.getRowStride(), iArr2[i17], bArr, iArr3[i17], iArr4[i17]);
                }
                planeProxyArr[i17] = createPlaneProxy(iArr3[i17], 1, bArr);
            }
            return new ForwardingImageProxyImpl(imageProxy2, planeProxyArr, i13, i14);
        }
    }

    private static void resizeAveraging(ByteBuffer byteBuffer, int i11, int i12, int i13, int i14, byte[] bArr, int i15, int i16) {
        ByteBuffer byteBuffer2 = byteBuffer;
        int i17 = i13;
        int i18 = i14;
        int i19 = i15;
        int i21 = i16;
        float f11 = ((float) i11) / ((float) i19);
        float f12 = ((float) i18) / ((float) i21);
        byte[] bArr2 = new byte[i17];
        byte[] bArr3 = new byte[i17];
        int[] iArr = new int[i19];
        int i22 = 0;
        for (int i23 = 0; i23 < i19; i23++) {
            iArr[i23] = ((int) (((float) i23) * f11)) * i12;
        }
        synchronized (byteBuffer) {
            byteBuffer.rewind();
            int i24 = 0;
            while (i24 < i21) {
                int i25 = (int) (((float) i24) * f12);
                int i26 = i18 - 1;
                int i27 = i24 * i19;
                byteBuffer2.position(Math.min(i25, i26) * i17);
                byteBuffer2.get(bArr2, i22, Math.min(i17, byteBuffer.remaining()));
                byteBuffer2.position(Math.min(i25 + 1, i26) * i17);
                byteBuffer2.get(bArr3, i22, Math.min(i17, byteBuffer.remaining()));
                for (int i28 = i22; i28 < i19; i28++) {
                    bArr[i27 + i28] = (byte) ((((((bArr2[iArr[i28]] & 255) + (bArr2[iArr[i28] + i12] & 255)) + (bArr3[iArr[i28]] & 255)) + (bArr3[iArr[i28] + i12] & 255)) / 4) & 255);
                }
                i24++;
                i22 = 0;
            }
        }
    }

    private static void resizeNearestNeighbor(ByteBuffer byteBuffer, int i11, int i12, int i13, int i14, byte[] bArr, int i15, int i16) {
        float f11 = ((float) i11) / ((float) i15);
        float f12 = ((float) i14) / ((float) i16);
        byte[] bArr2 = new byte[i13];
        int[] iArr = new int[i15];
        for (int i17 = 0; i17 < i15; i17++) {
            iArr[i17] = ((int) (((float) i17) * f11)) * i12;
        }
        synchronized (byteBuffer) {
            byteBuffer.rewind();
            for (int i18 = 0; i18 < i16; i18++) {
                int i19 = i18 * i15;
                byteBuffer.position(Math.min((int) (((float) i18) * f12), i14 - 1) * i13);
                byteBuffer.get(bArr2, 0, Math.min(i13, byteBuffer.remaining()));
                for (int i21 = 0; i21 < i15; i21++) {
                    bArr[i19 + i21] = bArr2[iArr[i21]];
                }
            }
        }
    }
}
