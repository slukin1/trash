package az;

import com.tencent.qcloud.tuikit.TUICommonDefine;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.tencent.qcloud.tuikit.tuicallengine.a f12237b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12238c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TUICommonDefine.Callback f12239d;

    public /* synthetic */ a(com.tencent.qcloud.tuikit.tuicallengine.a aVar, int i11, TUICommonDefine.Callback callback) {
        this.f12237b = aVar;
        this.f12238c = i11;
        this.f12239d = callback;
    }

    public final void run() {
        this.f12237b.a(this.f12238c, this.f12239d);
    }
}
