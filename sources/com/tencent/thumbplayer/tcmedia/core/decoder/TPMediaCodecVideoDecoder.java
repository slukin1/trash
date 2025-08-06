package com.tencent.thumbplayer.tcmedia.core.decoder;

import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.thumbplayer.tcmedia.core.common.TPCodecUtils;
import com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog;
import com.tencent.thumbplayer.tcmedia.core.common.TPPixelFormat;
import com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo;
import com.tencent.thumbplayer.tcmedia.g.b;
import com.tencent.ugc.beauty.decoder.MediaUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class TPMediaCodecVideoDecoder extends TPBaseMediaCodecDecoder {
    private static final String DEVICE_NAME_VIVO_X5L = "vivo X5L";
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int PIXEL_STRIDE_CONTINUOUS = 1;
    private static final String TAG = "TPMediaCodecVideoDecode";
    private static final int YUV420P_PLANAR_COUNT = 3;
    private int mCropBottom = 0;
    private int mCropLeft = 0;
    private int mCropRight = 0;
    private int mCropTop = 0;
    private byte[] mCsd0Data = null;
    private byte[] mCsd1Data = null;
    private byte[] mCsd2Data = null;
    private boolean mDisableDolbyVisionComponent = false;
    private int mDolbyVisionLevel = 0;
    private int mDolbyVisionProfile = 0;
    private boolean mEnableMediaCodecOutputData = false;
    private ArrayList<String> mMimeCandidates = new ArrayList<>();
    private int mRotation = 0;
    private int mVideoHeight = 0;
    private int mVideoWidth = 0;

    public TPMediaCodecVideoDecoder(int i11) {
        super(i11);
    }

    private void copyVideoDataFromImage(Image image, TPFrameInfo tPFrameInfo) {
        if (image.getFormat() != 35) {
            tPFrameInfo.format = -1;
            tPFrameInfo.errCode = 3;
            TPNativeLog.printLog(4, TAG, "copyVideoDataFromImage: image format not support!");
            return;
        }
        tPFrameInfo.format = 0;
        int width = image.getWidth();
        int height = image.getHeight();
        Image.Plane[] planes = image.getPlanes();
        int[] iArr = tPFrameInfo.lineSize;
        if (iArr == null || iArr.length < 3) {
            tPFrameInfo.lineSize = new int[3];
        }
        byte[][] bArr = tPFrameInfo.videoData;
        if (bArr == null || bArr.length < 3) {
            tPFrameInfo.videoData = new byte[3][];
        }
        int i11 = 0;
        while (i11 < 3) {
            int i12 = i11 == 0 ? 0 : 1;
            copyVideoDataFromPlane(planes[i11], width >> i12, height >> i12, i11, tPFrameInfo);
            i11++;
        }
    }

    private void copyVideoDataFromPlane(Image.Plane plane, int i11, int i12, int i13, TPFrameInfo tPFrameInfo) {
        ByteBuffer buffer = plane.getBuffer();
        tPFrameInfo.lineSize[i13] = i11;
        int i14 = i11 * i12;
        byte[][] bArr = tPFrameInfo.videoData;
        if (bArr[i13] == null || bArr[i13].length < i14) {
            bArr[i13] = new byte[i14];
        }
        if (plane.getPixelStride() == 1) {
            buffer.get(tPFrameInfo.videoData[i13], 0, i14);
            return;
        }
        for (int i15 = 0; i15 < i14; i15++) {
            tPFrameInfo.videoData[i13][i15] = buffer.get(plane.getPixelStride() * i15);
        }
    }

    private void processOutputData(b bVar, int i11, MediaCodec.BufferInfo bufferInfo, TPFrameInfo tPFrameInfo) {
        if (bufferInfo.flags != 4 || bufferInfo.size > 0) {
            Image b11 = bVar.b(i11);
            if (b11 == null) {
                tPFrameInfo.format = -1;
                tPFrameInfo.errCode = 3;
                bVar.a(i11, false);
                TPNativeLog.printLog(4, TAG, "processOutputBuffer: getOutputImage return null");
                return;
            }
            copyVideoDataFromImage(b11, tPFrameInfo);
            bVar.a(i11, false);
            return;
        }
        TPNativeLog.printLog(2, TAG, "processOutputBuffer: bufferInfo.flags is BUFFER_FLAG_END_OF_STREAM, return EOS!");
        tPFrameInfo.format = -1;
        tPFrameInfo.errCode = 2;
        bVar.a(i11, false);
    }

    public void configCodec(b bVar, String str) {
        Surface surface;
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, this.mVideoWidth, this.mVideoHeight);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 > 22) {
            createVideoFormat.setInteger(MediaUtils.KEY_ROTATION, this.mRotation);
        }
        if (TPSystemInfo.getDeviceName().equalsIgnoreCase(DEVICE_NAME_VIVO_X5L)) {
            createVideoFormat.setInteger("max-input-size", this.mVideoWidth * this.mVideoHeight);
        }
        byte[] bArr = this.mCsd0Data;
        if (bArr != null) {
            createVideoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(bArr));
        }
        byte[] bArr2 = this.mCsd1Data;
        if (bArr2 != null) {
            createVideoFormat.setByteBuffer("csd-1", ByteBuffer.wrap(bArr2));
        }
        byte[] bArr3 = this.mCsd2Data;
        if (bArr3 != null) {
            createVideoFormat.setByteBuffer("csd-2", ByteBuffer.wrap(bArr3));
        }
        if ("video/dolby-vision".equals(str)) {
            createVideoFormat.setInteger(Scopes.PROFILE, TPCodecUtils.convertDolbyVisionToOmxProfile(this.mDolbyVisionProfile));
            createVideoFormat.setInteger(FirebaseAnalytics.Param.LEVEL, TPCodecUtils.convertDolbyVisionToOmxLevel(this.mDolbyVisionLevel));
        }
        if (!this.mEnableMediaCodecOutputData || i11 < 21) {
            surface = this.mSurface;
        } else {
            createVideoFormat.setInteger("color-format", 2135033992);
            surface = null;
        }
        bVar.a(createVideoFormat, surface, this.mMediaCrypto, 0);
        bVar.d(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = com.tencent.thumbplayer.tcmedia.core.common.TPCodecUtils.getDolbyVisionDecoderName(r3, r0, r2.mDolbyVisionLevel, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getCodecName(java.lang.String r3, boolean r4) {
        /*
            r2 = this;
            int r0 = r2.mDolbyVisionProfile
            if (r0 <= 0) goto L_0x0010
            boolean r1 = r2.mDisableDolbyVisionComponent
            if (r1 != 0) goto L_0x0010
            int r1 = r2.mDolbyVisionLevel
            java.lang.String r0 = com.tencent.thumbplayer.tcmedia.core.common.TPCodecUtils.getDolbyVisionDecoderName(r3, r0, r1, r4)
            if (r0 != 0) goto L_0x0014
        L_0x0010:
            java.lang.String r0 = com.tencent.thumbplayer.tcmedia.core.common.TPCodecUtils.getDecoderName(r3, r4)
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.decoder.TPMediaCodecVideoDecoder.getCodecName(java.lang.String, boolean):java.lang.String");
    }

    public String getLogTag() {
        return TAG;
    }

    public ArrayList<String> getMimeCandidates() {
        return this.mMimeCandidates;
    }

    public boolean initDecoder(String str, int i11, int i12, int i13, int i14) {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x007a, code lost:
        if (r7 != false) goto L_0x006f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean initDecoder(java.lang.String r4, int r5, int r6, int r7, android.view.Surface r8, int r9, int r10, int r11) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "initDecoder, mimeType:"
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r1 = " width:"
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = " height:"
            r0.append(r1)
            r0.append(r6)
            java.lang.String r1 = " rotation:"
            r0.append(r1)
            r0.append(r7)
            java.lang.String r1 = " dvProfile:"
            r0.append(r1)
            r0.append(r10)
            java.lang.String r1 = " dvLevel:"
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            r1 = 2
            java.lang.String r2 = "TPMediaCodecVideoDecode"
            com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r1, r2, r0)
            r3.mVideoWidth = r5
            r3.mVideoHeight = r6
            r3.mRotation = r7
            r3.mSurface = r8
            r3.mDrmType = r9
            r3.mDolbyVisionProfile = r10
            r3.mDolbyVisionLevel = r11
            java.util.ArrayList<java.lang.String> r5 = r3.mMimeCandidates
            r5.clear()
            java.lang.String r5 = "video/dolby-vision"
            boolean r5 = r5.equals(r4)
            r6 = 1
            if (r5 == 0) goto L_0x007d
            int r5 = r3.mDolbyVisionProfile
            int r5 = com.tencent.thumbplayer.tcmedia.core.common.TPCodecUtils.convertDolbyVisionToOmxProfile(r5)
            r7 = 0
            r8 = 4
            if (r5 < r8) goto L_0x0067
            r8 = 256(0x100, float:3.59E-43)
            if (r5 > r8) goto L_0x0067
            r7 = r6
        L_0x0067:
            boolean r5 = r3.mDisableDolbyVisionComponent
            java.lang.String r8 = "video/hevc"
            if (r5 == 0) goto L_0x0075
            if (r7 == 0) goto L_0x0075
        L_0x006f:
            java.util.ArrayList<java.lang.String> r4 = r3.mMimeCandidates
            r4.add(r8)
            goto L_0x0082
        L_0x0075:
            java.util.ArrayList<java.lang.String> r5 = r3.mMimeCandidates
            r5.add(r4)
            if (r7 == 0) goto L_0x0082
            goto L_0x006f
        L_0x007d:
            java.util.ArrayList<java.lang.String> r5 = r3.mMimeCandidates
            r5.add(r4)
        L_0x0082:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.decoder.TPMediaCodecVideoDecoder.initDecoder(java.lang.String, int, int, int, android.view.Surface, int, int, int):boolean");
    }

    public void processMediaCodecException(Exception exc) {
    }

    public void processOutputBuffer(b bVar, int i11, MediaCodec.BufferInfo bufferInfo, TPFrameInfo tPFrameInfo) {
        tPFrameInfo.width = this.mVideoWidth;
        tPFrameInfo.height = this.mVideoHeight;
        tPFrameInfo.cropLeft = this.mCropLeft;
        tPFrameInfo.cropRight = this.mCropRight;
        tPFrameInfo.cropTop = this.mCropTop;
        tPFrameInfo.cropBottom = this.mCropBottom;
        tPFrameInfo.format = TPPixelFormat.TP_PIX_FMT_MEDIACODEC;
        if (this.mEnableMediaCodecOutputData) {
            processOutputData(bVar, i11, bufferInfo, tPFrameInfo);
        }
    }

    public void processOutputConfigData(b bVar, int i11, MediaCodec.BufferInfo bufferInfo, TPFrameInfo tPFrameInfo) {
        tPFrameInfo.errCode = 0;
        processOutputBuffer(bVar, i11, bufferInfo, tPFrameInfo);
    }

    public void processOutputFormatChanged(MediaFormat mediaFormat) {
        boolean z11 = mediaFormat.containsKey(KEY_CROP_RIGHT) && mediaFormat.containsKey(KEY_CROP_LEFT) && mediaFormat.containsKey(KEY_CROP_BOTTOM) && mediaFormat.containsKey(KEY_CROP_TOP);
        this.mVideoWidth = mediaFormat.getInteger("width");
        this.mVideoHeight = mediaFormat.getInteger("height");
        if (z11) {
            this.mCropLeft = mediaFormat.getInteger(KEY_CROP_LEFT);
            this.mCropRight = mediaFormat.getInteger(KEY_CROP_RIGHT);
            this.mCropTop = mediaFormat.getInteger(KEY_CROP_TOP);
            this.mCropBottom = mediaFormat.getInteger(KEY_CROP_BOTTOM);
        }
        TPNativeLog.printLog(2, TAG, "processOutputFormatChanged: mVideoWidth: " + this.mVideoWidth + ", mVideoHeight: " + this.mVideoHeight + ", mCropLeft: " + this.mCropLeft + ", mCropRight: " + this.mCropRight + ", mCropTop: " + this.mCropTop + ", mCropBottom: " + this.mCropBottom);
    }

    public int setOperateRate(float f11) {
        return super.setOperateRate(f11);
    }

    public int setOutputSurface(Surface surface) {
        if (this.mEnableMediaCodecOutputData) {
            return 3;
        }
        return super.setOutputSurface(surface);
    }

    public boolean setParamBool(int i11, boolean z11) {
        String logTag;
        StringBuilder sb2;
        if (5 != i11) {
            if (6 == i11) {
                if (!this.mStarted) {
                    this.mDisableDolbyVisionComponent = z11;
                } else {
                    logTag = getLogTag();
                    sb2 = new StringBuilder("BOOL_FORCE_DOLBY_VISION_USE_HEVC_CODEC failed. need set before start, mStart=");
                    sb2.append(this.mStarted);
                }
            }
            return super.setParamBool(i11, z11);
        } else if (this.mStarted || Build.VERSION.SDK_INT < 21) {
            logTag = getLogTag();
            sb2 = new StringBuilder("BOOL_ENABLE_MEDIACODEC_OUTPUT_DATA failed. need set before start, mStart=");
            sb2.append(this.mStarted);
            sb2.append(", api level is ");
            sb2.append(Build.VERSION.SDK_INT);
            sb2.append(", support api level = 21");
        } else {
            this.mEnableMediaCodecOutputData = z11;
            return super.setParamBool(i11, z11);
        }
        TPNativeLog.printLog(3, logTag, sb2.toString());
        return super.setParamBool(i11, z11);
    }

    public boolean setParamBytes(int i11, byte[] bArr) {
        if (i11 == 200) {
            this.mCsd0Data = bArr;
        } else if (i11 == 201) {
            this.mCsd1Data = bArr;
        } else if (i11 == 202) {
            this.mCsd2Data = bArr;
        }
        return super.setParamBytes(i11, bArr);
    }

    public boolean setParamObject(int i11, Object obj) {
        return super.setParamObject(i11, obj);
    }
}
