package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditConstants;
import java.util.Comparator;

final /* synthetic */ class em implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    private static final em f50416a = new em();

    private em() {
    }

    public static Comparator a() {
        return f50416a;
    }

    public final int compare(Object obj, Object obj2) {
        return UGCMediaListSource.lambda$cutSingleVideoFileToClips$1((TXVideoEditConstants.TXRepeat) obj, (TXVideoEditConstants.TXRepeat) obj2);
    }
}
