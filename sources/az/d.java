package az;

import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.a;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f12249b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12250c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TUICallDefine.MediaType f12251d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TUICallDefine.CallParams f12252e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ TUICommonDefine.Callback f12253f;

    public /* synthetic */ d(a aVar, String str, TUICallDefine.MediaType mediaType, TUICallDefine.CallParams callParams, TUICommonDefine.Callback callback) {
        this.f12249b = aVar;
        this.f12250c = str;
        this.f12251d = mediaType;
        this.f12252e = callParams;
        this.f12253f = callback;
    }

    public final void run() {
        this.f12249b.a(this.f12250c, this.f12251d, this.f12252e, this.f12253f);
    }
}
