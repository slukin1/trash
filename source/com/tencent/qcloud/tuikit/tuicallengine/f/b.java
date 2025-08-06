package com.tencent.qcloud.tuikit.tuicallengine.f;

import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallObserver;

public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TUICallObserver f48392a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TUICommonDefine.RoomId f48393b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TUICallDefine.MediaType f48394c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TUICallDefine.Role f48395d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f48396e;

    public b(j jVar, TUICallObserver tUICallObserver, TUICommonDefine.RoomId roomId, TUICallDefine.MediaType mediaType, TUICallDefine.Role role, long j11) {
        this.f48392a = tUICallObserver;
        this.f48393b = roomId;
        this.f48394c = mediaType;
        this.f48395d = role;
        this.f48396e = j11;
    }

    public void run() {
        TUICallObserver tUICallObserver = this.f48392a;
        if (tUICallObserver != null) {
            tUICallObserver.onCallEnd(this.f48393b, this.f48394c, this.f48395d, this.f48396e);
        }
    }
}
