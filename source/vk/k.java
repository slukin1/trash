package vk;

import com.huobi.finance.viewhandler.AssetSortPopItemViewHandler;

public class k implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f47993b = false;

    /* renamed from: c  reason: collision with root package name */
    public String f47994c;

    /* renamed from: d  reason: collision with root package name */
    public int f47995d;

    /* renamed from: e  reason: collision with root package name */
    public a f47996e;

    public interface a {
        void a(int i11);
    }

    public k(boolean z11, String str, int i11, a aVar) {
        this.f47993b = z11;
        this.f47994c = str;
        this.f47995d = i11;
        this.f47996e = aVar;
    }

    public String a() {
        return this.f47994c;
    }

    public int c() {
        return this.f47995d;
    }

    public boolean d() {
        return this.f47993b;
    }

    public void e() {
        a aVar = this.f47996e;
        if (aVar != null) {
            aVar.a(this.f47995d);
        }
    }

    public void f(boolean z11) {
        this.f47993b = z11;
    }

    public String getViewHandlerName() {
        return AssetSortPopItemViewHandler.class.getName();
    }
}
