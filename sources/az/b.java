package az;

import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.a;
import java.util.List;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f12240b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TUICommonDefine.Callback f12241c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f12242d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ List f12243e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ TUICallDefine.MediaType f12244f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TUICallDefine.CallParams f12245g;

    public /* synthetic */ b(a aVar, TUICommonDefine.Callback callback, String str, List list, TUICallDefine.MediaType mediaType, TUICallDefine.CallParams callParams) {
        this.f12240b = aVar;
        this.f12241c = callback;
        this.f12242d = str;
        this.f12243e = list;
        this.f12244f = mediaType;
        this.f12245g = callParams;
    }

    public final void run() {
        this.f12240b.a(this.f12241c, this.f12242d, this.f12243e, this.f12244f, this.f12245g);
    }
}
