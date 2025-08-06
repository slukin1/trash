package ml;

import com.huobi.homemarket.handler.MarketHeaderViewHolderHandler;
import s9.a;

public class c implements a {

    /* renamed from: b  reason: collision with root package name */
    public String f76293b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f76294c;

    public c(String str, boolean z11) {
        this.f76293b = str;
        this.f76294c = z11;
    }

    public String a() {
        return this.f76293b;
    }

    public boolean c() {
        return this.f76294c;
    }

    public String getViewHandlerName() {
        return MarketHeaderViewHolderHandler.class.getName();
    }
}
