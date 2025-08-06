package com.tencent.qcloud.tuikit.tuicallengine.k;

import com.tencent.imsdk.BaseConstants;
import com.tencent.liteav.TXLiteAVCode;
import java.util.HashSet;
import java.util.Set;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f48519a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f48520b = 17;

    /* renamed from: c  reason: collision with root package name */
    public static int f48521c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f48522d = false;

    /* renamed from: e  reason: collision with root package name */
    public static final Set<Integer> f48523e;

    /* renamed from: com.tencent.qcloud.tuikit.tuicallengine.k.a$a  reason: collision with other inner class name */
    public enum C0607a {
        Unknown,
        Normal,
        Reject,
        Ignore,
        Timeout,
        Cancel,
        BusyLine,
        Fail
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add(8001);
        hashSet.add(8002);
        hashSet.add(8003);
        hashSet.add(Integer.valueOf(TXLiteAVCode.WARNING_VIRTUAL_BACKGROUND_PERFORMANCE_INSUFFICIENT));
        hashSet.add(Integer.valueOf(BaseConstants.ERR_MERGER_MSG_LAYERS_OVER_LIMIT));
        hashSet.add(8007);
        f48523e = hashSet;
    }
}
