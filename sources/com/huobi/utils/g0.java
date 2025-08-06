package com.huobi.utils;

import java.io.File;
import java.util.Comparator;

public final /* synthetic */ class g0 implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ g0 f83744b = new g0();

    public final int compare(Object obj, Object obj2) {
        return Long.compare(Long.parseLong(((File) obj2).getName().replace(".log", "")), Long.parseLong(((File) obj).getName().replace(".log", "")));
    }
}
