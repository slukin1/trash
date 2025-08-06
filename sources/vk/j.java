package vk;

import com.huobi.finance.viewhandler.AssetPriceMethodPopItemViewHandler;

public class j implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f47990b;

    /* renamed from: c  reason: collision with root package name */
    public String f47991c;

    /* renamed from: d  reason: collision with root package name */
    public a f47992d;

    public interface a {
        void a(String str);
    }

    public j(boolean z11, String str, a aVar) {
        this.f47990b = z11;
        this.f47991c = str;
        this.f47992d = aVar;
    }

    public String a() {
        return this.f47991c;
    }

    public boolean c() {
        return this.f47990b;
    }

    public void d() {
        a aVar = this.f47992d;
        if (aVar != null) {
            aVar.a(this.f47991c);
        }
    }

    public String getViewHandlerName() {
        return AssetPriceMethodPopItemViewHandler.class.getName();
    }
}
