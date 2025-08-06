package com.tencent.thumbplayer.tcmedia.api.composition;

import com.tencent.thumbplayer.tcmedia.api.TPCommonEnum;
import com.tencent.thumbplayer.tcmedia.b.a;
import com.tencent.thumbplayer.tcmedia.b.b;
import com.tencent.thumbplayer.tcmedia.b.c;
import com.tencent.thumbplayer.tcmedia.b.e;
import com.tencent.thumbplayer.tcmedia.b.g;
import com.tencent.thumbplayer.tcmedia.b.h;
import com.tencent.thumbplayer.tcmedia.b.j;
import com.tencent.thumbplayer.tcmedia.b.k;
import com.tencent.thumbplayer.tcmedia.b.l;
import java.util.List;

public class TPMediaCompositionFactory {
    public static ITPMediaTrackClip createEmptyTrackClip(int i11, long j11, long j12) {
        a aVar = new a(i11);
        aVar.setCutTimeRange(j11, j12);
        return aVar;
    }

    public static ITPMediaAssetExtraParam createMediaAssetExtraParam() {
        return new b();
    }

    public static ITPMediaAssetOrderedMap createMediaAssetOrderedMap() {
        return new c();
    }

    public static ITPMediaComposition createMediaComposition() {
        return new e();
    }

    public static ITPMediaDRMAsset createMediaDRMAsset(@TPCommonEnum.TP_DRM_TYPE int i11, String str) {
        return new j(i11, str);
    }

    public static ITPMediaAsset createMediaRTCAsset(String str, String str2) {
        return new k(str, str2);
    }

    public static ITPMediaAsset createMediaRTCAsset(String str, String str2, int i11) {
        return new k(str, str2, i11);
    }

    public static ITPMediaTrack createMediaTrack(int i11) {
        return new g(i11);
    }

    public static ITPMediaTrack createMediaTrack(int i11, List<ITPMediaTrackClip> list) {
        g gVar = new g(i11);
        for (ITPMediaTrackClip addTrackClip : list) {
            gVar.addTrackClip(addTrackClip);
        }
        return gVar;
    }

    public static ITPMediaTrack createMediaTrack(int i11, ITPMediaTrackClip... iTPMediaTrackClipArr) {
        g gVar = new g(i11);
        for (ITPMediaTrackClip addTrackClip : iTPMediaTrackClipArr) {
            gVar.addTrackClip(addTrackClip);
        }
        return gVar;
    }

    public static ITPMediaTrackClip createMediaTrackClip(String str, int i11) {
        return new h(str, i11);
    }

    public static ITPMediaTrackClip createMediaTrackClip(String str, int i11, long j11, long j12) {
        return new h(str, i11, j11, j12);
    }

    public static ITPMediaUrlAsset createMediaUrlAsset(String str) {
        return new l(str);
    }
}
