package com.iproov.sdk.p005class;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* renamed from: com.iproov.sdk.class.new  reason: invalid class name and invalid package */
public class Cnew {

    /* renamed from: do  reason: not valid java name */
    public final ArrayList<MediaCodecInfo> f202do;

    /* renamed from: for  reason: not valid java name */
    public final MediaCodecInfo f203for;

    /* renamed from: if  reason: not valid java name */
    public final MediaCodecInfo f204if;

    /* renamed from: new  reason: not valid java name */
    public final int f205new;

    /* renamed from: try  reason: not valid java name */
    public final Ccase f206try;

    /* renamed from: com.iproov.sdk.class.new$do  reason: invalid class name */
    public class Cdo implements Comparator<MediaCodecInfo> {
        /* renamed from: do  reason: not valid java name */
        public int compare(MediaCodecInfo mediaCodecInfo, MediaCodecInfo mediaCodecInfo2) {
            boolean startsWith = mediaCodecInfo.getName().toLowerCase().startsWith("omx");
            boolean startsWith2 = mediaCodecInfo2.getName().toLowerCase().startsWith("omx");
            if (!startsWith || startsWith2) {
                return (!startsWith2 || startsWith) ? 0 : 1;
            }
            return -1;
        }
    }

    public Cnew(Ccase caseR) {
        this.f206try = caseR;
        ArrayList<MediaCodecInfo> arrayList = m284do(caseR.m246do());
        this.f202do = arrayList;
        MediaCodecInfo mediaCodecInfo = arrayList.get(0);
        this.f204if = mediaCodecInfo;
        this.f203for = arrayList.get(Math.min(1, arrayList.size() - 1));
        this.f205new = m283do(mediaCodecInfo, caseR.m246do());
    }

    /* renamed from: do  reason: not valid java name */
    private static ArrayList<MediaCodecInfo> m284do(Celse elseR) {
        ArrayList<MediaCodecInfo> arrayList = new ArrayList<>();
        for (int i11 = 0; i11 < MediaCodecList.getCodecCount(); i11++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i11);
            if (m285if(codecInfoAt, elseR)) {
                arrayList.add(codecInfoAt);
            }
        }
        Collections.sort(arrayList, new Cdo());
        return arrayList;
    }

    /* renamed from: if  reason: not valid java name */
    private static boolean m285if(MediaCodecInfo mediaCodecInfo, Celse elseR) {
        if (!mediaCodecInfo.isEncoder()) {
            return false;
        }
        for (String equals : mediaCodecInfo.getSupportedTypes()) {
            if (equals.equals(elseR.f192if)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: do  reason: not valid java name */
    private static int m283do(MediaCodecInfo mediaCodecInfo, Celse elseR) {
        int i11;
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(elseR.f192if);
        int i12 = 0;
        while (true) {
            int[] iArr = capabilitiesForType.colorFormats;
            if (i12 >= iArr.length) {
                return -1;
            }
            i11 = iArr[i12];
            if (i11 == 19 || i11 == 21 || i11 == 2130706688) {
                return i11;
            }
            i12++;
        }
        return i11;
    }
}
