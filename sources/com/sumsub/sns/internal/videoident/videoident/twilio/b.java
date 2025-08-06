package com.sumsub.sns.internal.videoident.videoident.twilio;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Build;
import com.sumsub.sns.internal.videoident.videoident.SNSVideoIdent;
import com.sumsub.sns.internal.videoident.videoident.a;
import com.twilio.video.TwilioException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import tvi.webrtc.Camera2Enumerator;
import tvi.webrtc.VideoFrame;
import tvi.webrtc.YuvConverter;

public final class b {
    public static final String a(TwilioException twilioException) {
        return "code=" + twilioException.getCode() + ", expl=" + twilioException.getExplanation();
    }

    public static final String b(Camera2Enumerator camera2Enumerator) {
        for (String str : camera2Enumerator.getDeviceNames()) {
            if (camera2Enumerator.isFrontFacing(str)) {
                return str;
            }
        }
        return null;
    }

    public static final String a(Camera2Enumerator camera2Enumerator) {
        for (String str : camera2Enumerator.getDeviceNames()) {
            if (camera2Enumerator.isBackFacing(str)) {
                return str;
            }
        }
        return null;
    }

    public static final Bitmap a(VideoFrame videoFrame) {
        VideoFrame.I420Buffer i420Buffer;
        Bitmap bitmap;
        if (videoFrame.getBuffer() instanceof VideoFrame.TextureBuffer) {
            YuvConverter yuvConverter = new YuvConverter();
            i420Buffer = yuvConverter.convert(videoFrame.getBuffer());
            yuvConverter.release();
        } else {
            i420Buffer = videoFrame.getBuffer().toI420();
        }
        if (i420Buffer == null) {
            return null;
        }
        YuvImage a11 = a(i420Buffer, videoFrame.getBuffer().getWidth(), videoFrame.getBuffer().getHeight());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a11.compressToJpeg(new Rect(0, 0, a11.getWidth(), a11.getHeight()), 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                bitmap = ImageDecoder.decodeBitmap(ImageDecoder.createSource(ByteBuffer.wrap(byteArray)));
            } catch (IOException e11) {
                a.a(SNSVideoIdent.logTag, "error converting video frame " + e11, (Throwable) null, 4, (Object) null);
                return null;
            }
        } else {
            bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        }
        Bitmap bitmap2 = bitmap;
        Matrix matrix = new Matrix();
        matrix.postRotate((float) videoFrame.getRotation());
        return Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix, true);
    }

    public static final YuvImage a(VideoFrame.I420Buffer i420Buffer, int i11, int i12) {
        int i13 = i11;
        int i14 = i12;
        ByteBuffer[] byteBufferArr = {i420Buffer.getDataY(), i420Buffer.getDataU(), i420Buffer.getDataV()};
        int strideV = i420Buffer.getStrideV();
        int[] iArr = {i420Buffer.getStrideY(), i420Buffer.getStrideU(), strideV};
        int i15 = iArr[0];
        if (i15 != i13) {
            return a(byteBufferArr, iArr, i13, i14);
        }
        int i16 = iArr[1];
        int i17 = i13 / 2;
        if (i16 != i17) {
            return a(byteBufferArr, iArr, i13, i14);
        }
        if (strideV != i17) {
            return a(byteBufferArr, iArr, i13, i14);
        }
        byte[] bArr = new byte[((i15 * i14) + ((i16 * i14) / 2) + ((strideV * i14) / 2))];
        int i18 = i13 * i14;
        a(byteBufferArr[0], ByteBuffer.wrap(bArr, 0, i18));
        int i19 = (i17 * i14) / 2;
        byte[] bArr2 = new byte[i19];
        ByteBuffer wrap = ByteBuffer.wrap(bArr2, 0, i19);
        a(byteBufferArr[2], wrap);
        int i21 = i14 / 2;
        for (int i22 = 0; i22 < i21; i22++) {
            for (int i23 = 0; i23 < i17; i23++) {
                int i24 = i22 * i13;
                bArr[i18 + i24 + (i23 * 2)] = bArr2[(i24 / 2) + i23];
            }
        }
        a(byteBufferArr[1], wrap);
        for (int i25 = 0; i25 < i21; i25++) {
            for (int i26 = 0; i26 < i17; i26++) {
                int i27 = i25 * i13;
                bArr[i18 + i27 + (i26 * 2) + 1] = bArr2[(i27 / 2) + i26];
            }
        }
        return new YuvImage(bArr, 17, i11, i12, (int[]) null);
    }

    public static final YuvImage a(ByteBuffer[] byteBufferArr, int[] iArr, int i11, int i12) {
        byte[] bArr = new byte[(((i11 * i12) * 3) / 2)];
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            int i15 = 0;
            while (i15 < i11) {
                bArr[i13] = byteBufferArr[0].get((iArr[0] * i14) + i15);
                i15++;
                i13++;
            }
        }
        int i16 = i12 / 2;
        for (int i17 = 0; i17 < i16; i17++) {
            int i18 = i11 / 2;
            for (int i19 = 0; i19 < i18; i19++) {
                int i21 = i13 + 1;
                bArr[i13] = byteBufferArr[2].get((iArr[2] * i17) + i19);
                i13 = i21 + 1;
                bArr[i21] = byteBufferArr[1].get((iArr[1] * i17) + i19);
            }
        }
        return new YuvImage(bArr, 17, i11, i12, (int[]) null);
    }

    public static final void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byteBuffer.position(0).limit(byteBuffer.capacity());
        byteBuffer2.put(byteBuffer);
        byteBuffer2.position(0).limit(byteBuffer2.capacity());
    }
}
