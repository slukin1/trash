package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.Comparator;

public final /* synthetic */ class j implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaCodecUtil.ScoreProvider f65942b;

    public /* synthetic */ j(MediaCodecUtil.ScoreProvider scoreProvider) {
        this.f65942b = scoreProvider;
    }

    public final int compare(Object obj, Object obj2) {
        return MediaCodecUtil.lambda$sortByScore$3(this.f65942b, obj, obj2);
    }
}
