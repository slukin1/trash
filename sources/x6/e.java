package x6;

import android.webkit.ValueCallback;
import com.hbg.lib.core.webview.util.MetaUtils;

public final /* synthetic */ class e implements ValueCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MetaUtils.a f61509a;

    public /* synthetic */ e(MetaUtils.a aVar) {
        this.f61509a = aVar;
    }

    public final void onReceiveValue(Object obj) {
        MetaUtils.b(this.f61509a, (String) obj);
    }
}
