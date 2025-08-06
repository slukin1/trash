package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Rational;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.audio.AudioSource;
import androidx.core.util.j;
import b0.d;
import b0.e;
import java.util.ArrayList;
import java.util.Collections;

public final class a {
    public static /* synthetic */ int b(int i11, Integer num, Integer num2) {
        float signum;
        int abs = Math.abs(num.intValue() - i11) - Math.abs(num2.intValue() - i11);
        if (abs == 0) {
            signum = Math.signum((float) (num.intValue() - num2.intValue()));
        } else {
            signum = Math.signum((float) abs);
        }
        return (int) signum;
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [androidx.core.util.j] */
    /* JADX WARNING: type inference failed for: r8v1, types: [b0.c] */
    /* JADX WARNING: type inference failed for: r0v3, types: [b0.b] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.camera.video.internal.encoder.a c(androidx.camera.video.internal.config.AudioMimeInfo r14, androidx.camera.core.impl.Timebase r15, androidx.camera.video.internal.audio.a r16, androidx.camera.video.a r17) {
        /*
            androidx.camera.core.impl.EncoderProfilesProxy$AudioProfileProxy r6 = r14.d()
            if (r6 == 0) goto L_0x001a
            b0.b r7 = new b0.b
            java.lang.String r1 = r14.a()
            int r2 = r14.b()
            r0 = r7
            r3 = r15
            r4 = r17
            r5 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6)
            goto L_0x002d
        L_0x001a:
            b0.c r7 = new b0.c
            java.lang.String r9 = r14.a()
            int r10 = r14.b()
            r8 = r7
            r11 = r15
            r12 = r17
            r13 = r16
            r8.<init>(r9, r10, r11, r12, r13)
        L_0x002d:
            java.lang.Object r0 = r7.get()
            androidx.camera.video.internal.encoder.a r0 = (androidx.camera.video.internal.encoder.a) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.config.a.c(androidx.camera.video.internal.config.AudioMimeInfo, androidx.camera.core.impl.Timebase, androidx.camera.video.internal.audio.a, androidx.camera.video.a):androidx.camera.video.internal.encoder.a");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.camera.video.internal.config.AudioMimeInfo d(androidx.camera.video.r r8, androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy r9) {
        /*
            int r0 = r8.c()
            java.lang.String r0 = androidx.camera.video.r.e(r0)
            int r1 = r8.c()
            int r1 = androidx.camera.video.r.f(r1)
            if (r9 == 0) goto L_0x00ca
            androidx.camera.core.impl.EncoderProfilesProxy$AudioProfileProxy r2 = r9.c()
            if (r2 == 0) goto L_0x00ca
            androidx.camera.core.impl.EncoderProfilesProxy$AudioProfileProxy r9 = r9.c()
            java.lang.String r2 = r9.getMediaType()
            int r3 = r9.getProfile()
            java.lang.String r4 = "audio/none"
            boolean r4 = java.util.Objects.equals(r2, r4)
            java.lang.String r5 = ")]"
            java.lang.String r6 = "AudioConfigUtil"
            java.lang.String r7 = "(profile: "
            if (r4 == 0) goto L_0x0051
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "EncoderProfiles contains undefined AUDIO mime type so cannot be used. May rely on fallback defaults to derive settings [chosen mime type: "
            r8.append(r9)
            r8.append(r0)
            r8.append(r7)
            r8.append(r1)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            androidx.camera.core.Logger.d(r6, r8)
            goto L_0x00ca
        L_0x0051:
            int r8 = r8.c()
            r4 = -1
            if (r8 != r4) goto L_0x0078
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "MediaSpec contains OUTPUT_FORMAT_AUTO. Using EncoderProfiles to derive AUDIO settings [mime type: "
            r8.append(r0)
            r8.append(r2)
            r8.append(r7)
            r8.append(r3)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            androidx.camera.core.Logger.d(r6, r8)
            r0 = r2
            r1 = r3
            goto L_0x00cb
        L_0x0078:
            boolean r8 = java.util.Objects.equals(r0, r2)
            if (r8 == 0) goto L_0x009f
            if (r1 != r3) goto L_0x009f
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "MediaSpec audio mime/profile matches EncoderProfiles. Using EncoderProfiles to derive AUDIO settings [mime type: "
            r8.append(r0)
            r8.append(r2)
            r8.append(r7)
            r8.append(r1)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            androidx.camera.core.Logger.d(r6, r8)
            r0 = r2
            goto L_0x00cb
        L_0x009f:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "MediaSpec audio mime or profile does not match EncoderProfiles, so EncoderProfiles settings cannot be used. May rely on fallback defaults to derive AUDIO settings [EncoderProfiles mime type: "
            r8.append(r9)
            r8.append(r2)
            r8.append(r7)
            r8.append(r3)
            java.lang.String r9 = "), chosen mime type: "
            r8.append(r9)
            r8.append(r0)
            r8.append(r7)
            r8.append(r1)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            androidx.camera.core.Logger.d(r6, r8)
        L_0x00ca:
            r9 = 0
        L_0x00cb:
            androidx.camera.video.internal.config.AudioMimeInfo$Builder r8 = androidx.camera.video.internal.config.AudioMimeInfo.c(r0)
            java.lang.Object r8 = r8.a(r1)
            androidx.camera.video.internal.config.AudioMimeInfo$Builder r8 = (androidx.camera.video.internal.config.AudioMimeInfo.Builder) r8
            if (r9 == 0) goto L_0x00da
            r8.c(r9)
        L_0x00da:
            androidx.camera.video.internal.config.AudioMimeInfo r8 = r8.b()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.config.a.d(androidx.camera.video.r, androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy):androidx.camera.video.internal.config.AudioMimeInfo");
    }

    public static androidx.camera.video.internal.audio.a e(AudioMimeInfo audioMimeInfo, androidx.camera.video.a aVar) {
        j jVar;
        EncoderProfilesProxy.AudioProfileProxy d11 = audioMimeInfo.d();
        if (d11 != null) {
            jVar = new d(aVar, d11);
        } else {
            jVar = new e(aVar);
        }
        return (androidx.camera.video.internal.audio.a) jVar.get();
    }

    public static int f(androidx.camera.video.a aVar) {
        int e11 = aVar.e();
        if (e11 == -1) {
            Logger.d("AudioConfigUtil", "Using default AUDIO source: " + 5);
            return 5;
        }
        Logger.d("AudioConfigUtil", "Using provided AUDIO source: " + e11);
        return e11;
    }

    public static int g(androidx.camera.video.a aVar) {
        int f11 = aVar.f();
        if (f11 == -1) {
            Logger.d("AudioConfigUtil", "Using default AUDIO source format: " + 2);
            return 2;
        }
        Logger.d("AudioConfigUtil", "Using provided AUDIO source format: " + f11);
        return f11;
    }

    public static int h(int i11, int i12, int i13, int i14, int i15, Range<Integer> range) {
        String str;
        int doubleValue = (int) (((double) i11) * new Rational(i12, i13).doubleValue() * new Rational(i14, i15).doubleValue());
        if (Logger.isDebugEnabled("AudioConfigUtil")) {
            str = String.format("Base Bitrate(%dbps) * Channel Count Ratio(%d / %d) * Sample Rate Ratio(%d / %d) = %d", new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15), Integer.valueOf(doubleValue)});
        } else {
            str = "";
        }
        if (!androidx.camera.video.a.f5902a.equals(range)) {
            doubleValue = range.clamp(Integer.valueOf(doubleValue)).intValue();
            if (Logger.isDebugEnabled("AudioConfigUtil")) {
                str = str + String.format("\nClamped to range %s -> %dbps", new Object[]{range, Integer.valueOf(doubleValue)});
            }
        }
        Logger.d("AudioConfigUtil", str);
        return doubleValue;
    }

    public static int i(Range<Integer> range, int i11, int i12, int i13) {
        ArrayList arrayList = null;
        int i14 = 0;
        int i15 = i13;
        while (true) {
            if (!range.contains(Integer.valueOf(i15))) {
                Logger.d("AudioConfigUtil", "Sample rate " + i15 + "Hz is not in target range " + range);
            } else if (AudioSource.o(i15, i11, i12)) {
                return i15;
            } else {
                Logger.d("AudioConfigUtil", "Sample rate " + i15 + "Hz is not supported by audio source with channel count " + i11 + " and source format " + i12);
            }
            if (arrayList == null) {
                Logger.d("AudioConfigUtil", "Trying common sample rates in proximity order to target " + i13 + "Hz");
                arrayList = new ArrayList(androidx.camera.video.internal.audio.a.f6004a);
                Collections.sort(arrayList, new b0.a(i13));
            }
            if (i14 < arrayList.size()) {
                int i16 = i14 + 1;
                i15 = ((Integer) arrayList.get(i14)).intValue();
                i14 = i16;
            } else {
                Logger.d("AudioConfigUtil", "No sample rate found in target range or supported by audio source. Falling back to default sample rate of 44100Hz");
                return 44100;
            }
        }
    }
}
