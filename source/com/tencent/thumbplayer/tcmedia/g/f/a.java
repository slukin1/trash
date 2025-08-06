package com.tencent.thumbplayer.tcmedia.g.f;

import android.media.MediaFormat;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.MimeTypes;
import com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo;
import com.tencent.thumbplayer.tcmedia.g.b.e;
import com.tencent.thumbplayer.tcmedia.g.b.f;
import com.tencent.thumbplayer.tcmedia.g.b.g;
import com.tencent.thumbplayer.tcmedia.g.h.c;

public final class a {

    /* renamed from: com.tencent.thumbplayer.tcmedia.g.f.a$a  reason: collision with other inner class name */
    public enum C0625a {
        ADAPTATION_WORKAROUND_MODE_NEVER,
        ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION,
        ADAPTATION_WORKAROUND_MODE_ALWAYS
    }

    public enum b {
        KEEP_CODEC_RESULT_NO,
        KEEP_CODEC_RESULT_YES_WITH_FLUSH,
        KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION,
        KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION
    }

    public static C0625a a(String str) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (TPSystemInfo.getDeviceName().startsWith("SM-T585") || TPSystemInfo.getDeviceName().startsWith("SM-A510") || TPSystemInfo.getDeviceName().startsWith("SM-A520") || TPSystemInfo.getDeviceName().startsWith("SM-J700"))) {
            return C0625a.ADAPTATION_WORKAROUND_MODE_ALWAYS;
        }
        if (i11 < 24 && ("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str))) {
            String str2 = Build.DEVICE;
            if ("flounder".equals(str2) || "flounder_lte".equals(str2) || "grouper".equals(str2) || "tilapia".equals(str2)) {
                return C0625a.ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION;
            }
        }
        return C0625a.ADAPTATION_WORKAROUND_MODE_NEVER;
    }

    public static void a(e eVar, MediaFormat mediaFormat) {
        b d11 = com.tencent.thumbplayer.tcmedia.g.a.a().d();
        int max = Math.max(d11.f49327b, eVar.f49232b);
        int max2 = Math.max(d11.f49328c, eVar.f49233c);
        if (d11.f49326a) {
            d11.f49327b = max;
            d11.f49328c = max2;
        }
        int max3 = Math.max(0, c.a(eVar.f49240j, max, max2, false));
        if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
            com.tencent.thumbplayer.tcmedia.g.h.b.b("ReuseHelper", "initFormatWrapper initWidth:" + max + " initHeight:" + max2 + " initMaxInputSize:" + max3 + ' ' + "reusePolicy:" + d11);
        }
        eVar.f49237g = max;
        eVar.f49238h = max2;
        eVar.f49239i = max3;
        mediaFormat.setInteger("max-input-size", Math.max(max3, 0));
        if (eVar.a() && Build.VERSION.SDK_INT >= 19) {
            mediaFormat.setInteger("max-width", max);
            mediaFormat.setInteger("max-height", max2);
        }
    }

    public static boolean a(f fVar, e eVar) {
        return a(fVar, eVar, false);
    }

    public static boolean a(f fVar, e eVar, boolean z11) {
        e eVar2 = fVar.f49248e;
        if (fVar instanceof g) {
            return TextUtils.equals(eVar2.f49240j, eVar.f49240j) && eVar2.f49234d == eVar.f49234d && (fVar.f49246c || (eVar2.f49232b == eVar.f49232b && eVar2.f49233c == eVar.f49233c));
        }
        if (!(fVar instanceof com.tencent.thumbplayer.tcmedia.g.b.a)) {
            return true;
        }
        if (TextUtils.equals(MimeTypes.AUDIO_AAC, eVar2.f49240j)) {
            TextUtils.equals(eVar2.f49240j, eVar.f49240j);
        }
        return false;
    }
}
