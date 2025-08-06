package com.tencent.qcloud.tuikit.tuicallengine.k;

import com.tencent.qcloud.tuikit.TUICommonDefine;

public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f48547a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f48548b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f48549c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b f48550d;

    public e(b bVar, String str, int i11, String str2) {
        this.f48550d = bVar;
        this.f48547a = str;
        this.f48548b = i11;
        this.f48549c = str2;
    }

    public void run() {
        TUICommonDefine.PlayCallback playCallback = this.f48550d.f48535c;
        if (playCallback != null) {
            playCallback.onError(this.f48547a, this.f48548b, this.f48549c);
        }
    }
}
