package y;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.text.TextUtils;
import androidx.camera.core.Logger;
import androidx.core.util.h;
import com.iproov.sdk.bridge.OptionsBridge;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import z.f;

public final class d {
    public static void a(StringBuilder sb2, MediaCodecInfo.AudioCapabilities audioCapabilities, MediaFormat mediaFormat) {
        h(sb2, "[AudioCaps] getBitrateRange = " + audioCapabilities.getBitrateRange());
        h(sb2, "[AudioCaps] getMaxInputChannelCount = " + audioCapabilities.getMaxInputChannelCount());
        if (Build.VERSION.SDK_INT >= 31) {
            h(sb2, "[AudioCaps] getMinInputChannelCount = " + f.b(audioCapabilities));
            h(sb2, "[AudioCaps] getInputChannelCountRanges = " + Arrays.toString(f.a(audioCapabilities)));
        }
        h(sb2, "[AudioCaps] getSupportedSampleRateRanges = " + Arrays.toString(audioCapabilities.getSupportedSampleRateRanges()));
        h(sb2, "[AudioCaps] getSupportedSampleRates = " + Arrays.toString(audioCapabilities.getSupportedSampleRates()));
        try {
            int integer = mediaFormat.getInteger("sample-rate");
            h(sb2, "[AudioCaps] isSampleRateSupported for " + integer + " = " + audioCapabilities.isSampleRateSupported(integer));
        } catch (IllegalArgumentException | NullPointerException unused) {
            h(sb2, "[AudioCaps] mediaFormat does not contain sample rate");
        }
    }

    public static String b(String str, MediaCodec mediaCodec, MediaFormat mediaFormat) {
        StringBuilder sb2 = new StringBuilder();
        try {
            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodec.getCodecInfo().getCapabilitiesForType(str);
            h.a(capabilitiesForType != null);
            c(sb2, capabilitiesForType, mediaFormat);
        } catch (IllegalArgumentException unused) {
            h(sb2, "[" + mediaCodec.getName() + "] does not support mime " + str);
        }
        return sb2.toString();
    }

    public static void c(StringBuilder sb2, MediaCodecInfo.CodecCapabilities codecCapabilities, MediaFormat mediaFormat) {
        try {
            h(sb2, "[CodecCaps] isFormatSupported = " + codecCapabilities.isFormatSupported(mediaFormat));
        } catch (ClassCastException unused) {
            h(sb2, "[CodecCaps] isFormatSupported=false");
        }
        h(sb2, "[CodecCaps] getDefaultFormat = " + codecCapabilities.getDefaultFormat());
        if (codecCapabilities.profileLevels != null) {
            StringBuilder sb3 = new StringBuilder("[");
            ArrayList arrayList = new ArrayList();
            for (MediaCodecInfo.CodecProfileLevel l11 : codecCapabilities.profileLevels) {
                arrayList.add(l(l11));
            }
            sb3.append(TextUtils.join(", ", arrayList));
            sb3.append("]");
            h(sb2, "[CodecCaps] profileLevels = " + sb3);
        }
        if (codecCapabilities.colorFormats != null) {
            h(sb2, "[CodecCaps] colorFormats = " + Arrays.toString(codecCapabilities.colorFormats));
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities != null) {
            f(sb2, videoCapabilities, mediaFormat);
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities != null) {
            a(sb2, audioCapabilities, mediaFormat);
        }
        MediaCodecInfo.EncoderCapabilities encoderCapabilities = codecCapabilities.getEncoderCapabilities();
        if (encoderCapabilities != null) {
            d(sb2, encoderCapabilities, mediaFormat);
        }
    }

    public static void d(StringBuilder sb2, MediaCodecInfo.EncoderCapabilities encoderCapabilities, MediaFormat mediaFormat) {
        h(sb2, "[EncoderCaps] getComplexityRange = " + encoderCapabilities.getComplexityRange());
        if (Build.VERSION.SDK_INT >= 28) {
            h(sb2, "[EncoderCaps] getQualityRange = " + z.d.a(encoderCapabilities));
        }
        try {
            int integer = mediaFormat.getInteger("bitrate-mode");
            h(sb2, "[EncoderCaps] isBitrateModeSupported = " + encoderCapabilities.isBitrateModeSupported(integer));
        } catch (IllegalArgumentException | NullPointerException unused) {
            h(sb2, "[EncoderCaps] mediaFormat does not contain bitrate mode");
        }
    }

    public static String e(MediaCodecList mediaCodecList, MediaFormat mediaFormat) {
        StringBuilder sb2 = new StringBuilder();
        h(sb2, "[Start] Dump MediaCodecList for mediaFormat " + mediaFormat);
        String string = mediaFormat.getString("mime");
        for (MediaCodecInfo mediaCodecInfo : mediaCodecList.getCodecInfos()) {
            if (mediaCodecInfo.isEncoder()) {
                boolean z11 = true;
                try {
                    h.a(string != null);
                    MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(string);
                    if (capabilitiesForType == null) {
                        z11 = false;
                    }
                    h.a(z11);
                    h(sb2, "[Start] [" + mediaCodecInfo.getName() + "]");
                    c(sb2, capabilitiesForType, mediaFormat);
                    h(sb2, "[End] [" + mediaCodecInfo.getName() + "]");
                } catch (IllegalArgumentException unused) {
                    h(sb2, "[" + mediaCodecInfo.getName() + "] does not support mime " + string);
                }
            }
        }
        h(sb2, "[End] Dump MediaCodecList");
        String sb3 = sb2.toString();
        k(sb3);
        return sb3;
    }

    public static void f(StringBuilder sb2, MediaCodecInfo.VideoCapabilities videoCapabilities, MediaFormat mediaFormat) {
        boolean z11;
        int i11;
        int i12;
        h(sb2, "[VideoCaps] getBitrateRange = " + videoCapabilities.getBitrateRange());
        h(sb2, "[VideoCaps] getSupportedWidths = " + videoCapabilities.getSupportedWidths() + ", getWidthAlignment = " + videoCapabilities.getWidthAlignment());
        h(sb2, "[VideoCaps] getSupportedHeights = " + videoCapabilities.getSupportedHeights() + ", getHeightAlignment = " + videoCapabilities.getHeightAlignment());
        boolean z12 = true;
        int i13 = 0;
        try {
            i12 = mediaFormat.getInteger("width");
            i11 = mediaFormat.getInteger("height");
            h.a(i12 > 0 && i11 > 0);
            z11 = true;
        } catch (IllegalArgumentException | NullPointerException unused) {
            h(sb2, "[VideoCaps] mediaFormat does not contain valid width and height");
            i12 = 0;
            i11 = 0;
            z11 = false;
        }
        if (z11) {
            try {
                h(sb2, "[VideoCaps] getSupportedHeightsFor " + i12 + " = " + videoCapabilities.getSupportedHeightsFor(i12));
            } catch (IllegalArgumentException unused2) {
                h(sb2, "[VideoCaps] could not getSupportedHeightsFor " + i12);
            }
            try {
                h(sb2, "[VideoCaps] getSupportedWidthsFor " + i11 + " = " + videoCapabilities.getSupportedWidthsFor(i11));
            } catch (IllegalArgumentException unused3) {
                h(sb2, "[VideoCaps] could not getSupportedWidthsFor " + i11);
            }
            h(sb2, "[VideoCaps] isSizeSupported for " + i12 + "x" + i11 + " = " + videoCapabilities.isSizeSupported(i12, i11));
        }
        h(sb2, "[VideoCaps] getSupportedFrameRates = " + videoCapabilities.getSupportedFrameRates());
        try {
            int integer = mediaFormat.getInteger("frame-rate");
            if (integer <= 0) {
                z12 = false;
            }
            h.a(z12);
            i13 = integer;
        } catch (IllegalArgumentException | NullPointerException unused4) {
            h(sb2, "[VideoCaps] mediaFormat does not contain frame rate");
        }
        if (z11) {
            h(sb2, "[VideoCaps] getSupportedFrameRatesFor " + i12 + "x" + i11 + " = " + videoCapabilities.getSupportedFrameRatesFor(i12, i11));
        }
        if (z11 && i13 > 0) {
            h(sb2, "[VideoCaps] areSizeAndRateSupported for " + i12 + "x" + i11 + ", " + i13 + " = " + videoCapabilities.areSizeAndRateSupported(i12, i11, (double) i13));
        }
    }

    public static String g(long j11) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long hours = timeUnit.toHours(j11);
        TimeUnit timeUnit2 = TimeUnit.HOURS;
        long minutes = timeUnit.toMinutes(j11 - timeUnit2.toMillis(hours));
        TimeUnit timeUnit3 = TimeUnit.MINUTES;
        long seconds = timeUnit.toSeconds((j11 - timeUnit2.toMillis(hours)) - timeUnit3.toMillis(minutes));
        return String.format(Locale.US, "%02d:%02d:%02d.%03d", new Object[]{Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds), Long.valueOf(((j11 - timeUnit2.toMillis(hours)) - timeUnit3.toMillis(minutes)) - TimeUnit.SECONDS.toMillis(seconds))});
    }

    public static void h(StringBuilder sb2, String str) {
        sb2.append(str);
        sb2.append("\n");
    }

    public static String i(long j11) {
        return g(j11);
    }

    public static String j(long j11) {
        return i(TimeUnit.MICROSECONDS.toMillis(j11));
    }

    public static void k(String str) {
        if (Logger.isInfoEnabled("DebugUtils")) {
            Scanner scanner = new Scanner(str);
            while (scanner.hasNextLine()) {
                Logger.i("DebugUtils", scanner.nextLine());
            }
        }
    }

    public static String l(MediaCodecInfo.CodecProfileLevel codecProfileLevel) {
        if (codecProfileLevel == null) {
            return OptionsBridge.NULL_VALUE;
        }
        return String.format("{level=%d, profile=%d}", new Object[]{Integer.valueOf(codecProfileLevel.level), Integer.valueOf(codecProfileLevel.profile)});
    }
}
