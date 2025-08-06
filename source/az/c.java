package az;

import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.a;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f12246b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12247c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TUICommonDefine.Callback f12248d;

    public /* synthetic */ c(a aVar, String str, TUICommonDefine.Callback callback) {
        this.f12246b = aVar;
        this.f12247c = str;
        this.f12248d = callback;
    }

    public final void run() {
        this.f12246b.a(this.f12247c, this.f12248d);
    }
}
