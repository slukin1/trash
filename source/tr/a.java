package tr;

import com.huobi.sharev2.bean.JsToNativeBean;
import com.huobi.sharev2.manager.CallBack;
import com.huobi.sharev2.manager.ShareManager;
import java.util.ArrayList;
import java.util.Map;

public final /* synthetic */ class a implements CallBack {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ShareManager f37354a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JsToNativeBean f37355b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f37356c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Map f37357d;

    public /* synthetic */ a(ShareManager shareManager, JsToNativeBean jsToNativeBean, String str, Map map) {
        this.f37354a = shareManager;
        this.f37355b = jsToNativeBean;
        this.f37356c = str;
        this.f37357d = map;
    }

    public final void result(Object obj) {
        this.f37354a.lambda$doShare$1(this.f37355b, this.f37356c, this.f37357d, (ArrayList) obj);
    }
}
