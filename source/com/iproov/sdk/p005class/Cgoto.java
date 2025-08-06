package com.iproov.sdk.p005class;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Size;
import com.google.android.gms.common.Scopes;
import com.iproov.sdk.p025public.Cif;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/* renamed from: com.iproov.sdk.class.goto  reason: invalid class name and invalid package */
public class Cgoto {

    /* renamed from: do  reason: not valid java name */
    public static final String f198do = "video/avc";

    /* renamed from: for  reason: not valid java name */
    public static final String f199for = "video/x-vnd.on2.vp9";

    /* renamed from: if  reason: not valid java name */
    public static final String f200if = "video/hevc";

    /* renamed from: new  reason: not valid java name */
    public static final String f201new = "video/x-vnd.on2.vp8";

    /* renamed from: do  reason: not valid java name */
    public static MediaFormat m280do(Size size, Cnew newR) {
        Integer num;
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(newR.f206try.m246do().f192if, size.getWidth(), size.getHeight());
        createVideoFormat.setInteger("max-input-size", 0);
        createVideoFormat.setInteger("frame-rate", newR.f206try.m247if().m276if().intValue());
        createVideoFormat.setInteger("color-format", newR.f205new);
        createVideoFormat.setInteger("i-frame-interval", newR.f206try.m247if().m278try().intValue());
        if (newR.f206try.m247if().m273do() != null) {
            createVideoFormat.setInteger("bitrate", newR.f206try.m247if().m273do().intValue());
        }
        if (newR.f206try.m247if().m277new() != null && Build.VERSION.SDK_INT >= 28) {
            createVideoFormat.setFloat("quality", newR.f206try.m247if().m277new().floatValue());
        }
        if (!(newR.f206try.m247if().m275for() == null || Build.VERSION.SDK_INT < 28 || (num = Cthis.m287do(newR.f206try.m246do(), newR.f206try.m247if().m275for())) == null)) {
            createVideoFormat.setInteger(Scopes.PROFILE, num.intValue());
        }
        return createVideoFormat;
    }

    /* renamed from: do  reason: not valid java name */
    public static String[] m282do(Cif ifVar) {
        TreeSet treeSet = new TreeSet(e.f38760b);
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
            m281do(mediaCodecInfo, treeSet, ifVar.m1301new());
        }
        return (String[]) Arrays.copyOf(treeSet.toArray(), treeSet.size(), String[].class);
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public static /* synthetic */ int m279do(String str, String str2) {
        return Celse.m270do(str).f191for - Celse.m270do(str2).f191for;
    }

    /* renamed from: do  reason: not valid java name */
    private static void m281do(MediaCodecInfo mediaCodecInfo, Set<String> set, Celse elseR) {
        if (mediaCodecInfo.isEncoder() && !mediaCodecInfo.getName().startsWith("OMX.google.")) {
            for (String str : mediaCodecInfo.getSupportedTypes()) {
                if (elseR != null) {
                    if (str.equals(elseR.f192if)) {
                        set.add(elseR.f190do);
                    }
                } else if (Celse.m271for(str)) {
                    set.add(Celse.m272if(str).f190do);
                }
            }
        }
    }
}
