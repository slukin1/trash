package com.huobi.account.ui;

import java.io.File;
import java.util.Comparator;

public final /* synthetic */ class r implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ r f41798b = new r();

    public final int compare(Object obj, Object obj2) {
        return Long.compare(Long.parseLong(((File) obj2).getName().replace(".log", "")), Long.parseLong(((File) obj).getName().replace(".log", "")));
    }
}
