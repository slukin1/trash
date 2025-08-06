package com.luck.picture.lib.utils;

import com.luck.picture.lib.entity.LocalMedia;
import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ a f26826b = new a();

    public final int compare(Object obj, Object obj2) {
        return Long.compare(((LocalMedia) obj2).getDateAddedTime(), ((LocalMedia) obj).getDateAddedTime());
    }
}
