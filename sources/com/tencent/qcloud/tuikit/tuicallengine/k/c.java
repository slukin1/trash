package com.tencent.qcloud.tuikit.tuicallengine.k;

import com.tencent.qcloud.tuikit.TUICommonDefine;

public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f48543a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f48544b;

    public c(b bVar, String str) {
        this.f48544b = bVar;
        this.f48543a = str;
    }

    public void run() {
        TUICommonDefine.PlayCallback playCallback = this.f48544b.f48535c;
        if (playCallback != null) {
            playCallback.onPlaying(this.f48543a);
        }
    }
}
