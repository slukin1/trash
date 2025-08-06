package ws;

import com.huobi.trade.handler.AssetsEmptyViewHandler;
import java.lang.ref.WeakReference;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public String f85033b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<? extends xs.a> f85034c;

    public a(String str, WeakReference<? extends xs.a> weakReference) {
        this.f85033b = str;
        this.f85034c = weakReference;
    }

    public WeakReference<? extends xs.a> a() {
        return this.f85034c;
    }

    public String getViewHandlerName() {
        return AssetsEmptyViewHandler.class.getName();
    }
}
