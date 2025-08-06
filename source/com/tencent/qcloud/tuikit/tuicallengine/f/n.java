package com.tencent.qcloud.tuikit.tuicallengine.f;

import com.tencent.imsdk.v2.V2TIMManager;

public class n {

    /* renamed from: a  reason: collision with root package name */
    public int f48449a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f48450b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final n f48451a = new n();
    }

    public static String a() {
        return V2TIMManager.getInstance().getLoginUser();
    }

    public static boolean b() {
        return V2TIMManager.getInstance().getLoginStatus() == 1;
    }
}
