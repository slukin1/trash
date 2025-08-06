package androidx.camera.video.internal.workaround;

import a0.a;
import android.media.MediaCodec;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.text.TextUtils;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.compat.quirk.MediaCodecInfoReportIncorrectInfoQuirk;
import androidx.camera.video.internal.compat.quirk.MediaFormatMustNotUseFrameRateToFindEncoderQuirk;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import java.io.IOException;
import y.d;

public class EncoderFinder {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f6293a;

    public EncoderFinder() {
        this.f6293a = ((MediaFormatMustNotUseFrameRateToFindEncoderQuirk) a.a(MediaFormatMustNotUseFrameRateToFindEncoderQuirk.class)) != null;
    }

    public MediaCodec a(MediaFormat mediaFormat) throws InvalidConfigException {
        MediaCodecList mediaCodecList = new MediaCodecList(1);
        String b11 = b(mediaFormat, mediaCodecList);
        try {
            if (!TextUtils.isEmpty(b11)) {
                return MediaCodec.createByCodecName(b11);
            }
            String string = mediaFormat.getString("mime");
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType(string);
            Logger.w("EncoderFinder", String.format("No encoder found that supports requested MediaFormat %s. Create encoder by MIME type. Dump codec info:\n%s", new Object[]{mediaFormat, d.b(string, createEncoderByType, mediaFormat)}));
            return createEncoderByType;
        } catch (IOException | IllegalArgumentException | NullPointerException e11) {
            boolean d11 = d(mediaFormat);
            String e12 = d.e(mediaCodecList, mediaFormat);
            throw new InvalidConfigException("Encoder cannot created: " + b11 + ", isMediaFormatInQuirk: " + d11 + "\n" + e12, e11);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String b(android.media.MediaFormat r7, android.media.MediaCodecList r8) {
        /*
            r6 = this;
            java.lang.String r0 = "aac-profile"
            java.lang.String r1 = "frame-rate"
            r2 = 0
            boolean r3 = r6.f6293a     // Catch:{ all -> 0x005c }
            if (r3 == 0) goto L_0x001b
            boolean r3 = r7.containsKey(r1)     // Catch:{ all -> 0x005c }
            if (r3 == 0) goto L_0x001b
            int r3 = r7.getInteger(r1)     // Catch:{ all -> 0x005c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x005c }
            r7.setString(r1, r2)     // Catch:{ all -> 0x0058 }
            goto L_0x001c
        L_0x001b:
            r3 = r2
        L_0x001c:
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0058 }
            r5 = 23
            if (r4 > r5) goto L_0x0037
            boolean r4 = r7.containsKey(r0)     // Catch:{ all -> 0x0058 }
            if (r4 == 0) goto L_0x0037
            int r4 = r7.getInteger(r0)     // Catch:{ all -> 0x0058 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0058 }
            r7.setString(r0, r2)     // Catch:{ all -> 0x0035 }
            r2 = r4
            goto L_0x0037
        L_0x0035:
            r8 = move-exception
            goto L_0x005a
        L_0x0037:
            java.lang.String r4 = r8.findEncoderForFormat(r7)     // Catch:{ all -> 0x0058 }
            if (r4 != 0) goto L_0x0045
            android.media.MediaCodecInfo[] r8 = r8.getCodecInfos()     // Catch:{ all -> 0x0058 }
            java.lang.String r4 = r6.c(r7, r8)     // Catch:{ all -> 0x0058 }
        L_0x0045:
            if (r3 == 0) goto L_0x004e
            int r8 = r3.intValue()
            r7.setInteger(r1, r8)
        L_0x004e:
            if (r2 == 0) goto L_0x0057
            int r8 = r2.intValue()
            r7.setInteger(r0, r8)
        L_0x0057:
            return r4
        L_0x0058:
            r8 = move-exception
            r4 = r2
        L_0x005a:
            r2 = r3
            goto L_0x005e
        L_0x005c:
            r8 = move-exception
            r4 = r2
        L_0x005e:
            if (r2 == 0) goto L_0x0067
            int r2 = r2.intValue()
            r7.setInteger(r1, r2)
        L_0x0067:
            if (r4 == 0) goto L_0x0070
            int r1 = r4.intValue()
            r7.setInteger(r0, r1)
        L_0x0070:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.workaround.EncoderFinder.b(android.media.MediaFormat, android.media.MediaCodecList):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a4 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String c(android.media.MediaFormat r14, android.media.MediaCodecInfo[] r15) {
        /*
            r13 = this;
            java.lang.String r0 = "bitrate"
            java.lang.String r1 = "mime"
            java.lang.String r1 = r14.getString(r1)
            java.lang.String r2 = "EncoderFinder"
            r3 = 0
            if (r1 != 0) goto L_0x0013
            java.lang.String r14 = "MediaFormat does not contain mime info."
            androidx.camera.core.Logger.w(r2, r14)
            return r3
        L_0x0013:
            int r4 = r15.length
            r5 = 0
            r6 = r5
        L_0x0016:
            if (r6 >= r4) goto L_0x00a8
            r7 = r15[r6]
            boolean r8 = r7.isEncoder()
            if (r8 != 0) goto L_0x0022
            goto L_0x00a4
        L_0x0022:
            android.media.MediaCodecInfo$CodecCapabilities r8 = r7.getCapabilitiesForType(r1)     // Catch:{ IllegalArgumentException -> 0x009a, all -> 0x008f }
            r9 = 1
            if (r8 == 0) goto L_0x002b
            r10 = r9
            goto L_0x002c
        L_0x002b:
            r10 = r5
        L_0x002c:
            java.lang.String r11 = "MIME type is not supported"
            androidx.core.util.h.b(r10, r11)     // Catch:{ IllegalArgumentException -> 0x009a, all -> 0x008f }
            r10 = -1
            boolean r11 = r14.containsKey(r0)     // Catch:{ IllegalArgumentException -> 0x009a, all -> 0x008f }
            if (r11 == 0) goto L_0x0060
            android.media.MediaCodecInfo$VideoCapabilities r10 = r8.getVideoCapabilities()     // Catch:{ IllegalArgumentException -> 0x009a, all -> 0x008f }
            if (r10 == 0) goto L_0x0040
            r11 = r9
            goto L_0x0041
        L_0x0040:
            r11 = r5
        L_0x0041:
            java.lang.String r12 = "Not video codec"
            androidx.core.util.h.b(r11, r12)     // Catch:{ IllegalArgumentException -> 0x009a, all -> 0x008f }
            int r11 = r14.getInteger(r0)     // Catch:{ IllegalArgumentException -> 0x009a, all -> 0x008f }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ IllegalArgumentException -> 0x009a, all -> 0x008f }
            android.util.Range r10 = r10.getBitrateRange()     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            java.lang.Comparable r10 = r10.clamp(r11)     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            int r10 = r10.intValue()     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            r14.setInteger(r0, r10)     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            goto L_0x0061
        L_0x0060:
            r11 = r3
        L_0x0061:
            boolean r8 = r8.isFormatSupported(r14)     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            if (r8 == 0) goto L_0x0089
            java.lang.String r8 = "No encoder found that supports requested bitrate. Adjusting bitrate to nearest supported bitrate [requested: %dbps, nearest: %dbps]"
            r12 = 2
            java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            r12[r5] = r11     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            r12[r9] = r10     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            java.lang.String r8 = java.lang.String.format(r8, r12)     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            androidx.camera.core.Logger.w(r2, r8)     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            java.lang.String r15 = r7.getName()     // Catch:{ IllegalArgumentException -> 0x009b, all -> 0x008c }
            if (r11 == 0) goto L_0x0088
            int r1 = r11.intValue()
            r14.setInteger(r0, r1)
        L_0x0088:
            return r15
        L_0x0089:
            if (r11 == 0) goto L_0x00a4
            goto L_0x009d
        L_0x008c:
            r15 = move-exception
            r3 = r11
            goto L_0x0090
        L_0x008f:
            r15 = move-exception
        L_0x0090:
            if (r3 == 0) goto L_0x0099
            int r1 = r3.intValue()
            r14.setInteger(r0, r1)
        L_0x0099:
            throw r15
        L_0x009a:
            r11 = r3
        L_0x009b:
            if (r11 == 0) goto L_0x00a4
        L_0x009d:
            int r7 = r11.intValue()
            r14.setInteger(r0, r7)
        L_0x00a4:
            int r6 = r6 + 1
            goto L_0x0016
        L_0x00a8:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.workaround.EncoderFinder.c(android.media.MediaFormat, android.media.MediaCodecInfo[]):java.lang.String");
    }

    public final boolean d(MediaFormat mediaFormat) {
        MediaCodecInfoReportIncorrectInfoQuirk mediaCodecInfoReportIncorrectInfoQuirk = (MediaCodecInfoReportIncorrectInfoQuirk) a.a(MediaCodecInfoReportIncorrectInfoQuirk.class);
        if (mediaCodecInfoReportIncorrectInfoQuirk == null) {
            return false;
        }
        return mediaCodecInfoReportIncorrectInfoQuirk.j(mediaFormat);
    }
}
