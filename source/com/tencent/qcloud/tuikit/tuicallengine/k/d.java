package com.tencent.qcloud.tuikit.tuicallengine.k;

import com.tencent.qcloud.tuikit.TUICommonDefine;

public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f48545a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f48546b;

    public d(b bVar, String str) {
        this.f48546b = bVar;
        this.f48545a = str;
    }

    public void run() {
        TUICommonDefine.PlayCallback playCallback = this.f48546b.f48535c;
        if (playCallback != null) {
            playCallback.onLoading(this.f48545a);
        }
    }
}
