package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditConstants;
import java.util.Comparator;

final /* synthetic */ class en implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    private static final en f50417a = new en();

    private en() {
    }

    public static Comparator a() {
        return f50417a;
    }

    public final int compare(Object obj, Object obj2) {
        return UGCMediaListSource.lambda$updateSpeedInfoToClips$2((TXVideoEditConstants.TXSpeed) obj, (TXVideoEditConstants.TXSpeed) obj2);
    }
}
