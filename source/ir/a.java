package ir;

import com.huobi.setting.pricing.viewhandler.PricingMethodItemHandler;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public C0869a f84296b;

    /* renamed from: c  reason: collision with root package name */
    public String f84297c;

    /* renamed from: ir.a$a  reason: collision with other inner class name */
    public interface C0869a {
        Object G9(String str);

        boolean Vg(String str);

        void j(String str);

        String nc(String str);
    }

    public a(String str, C0869a aVar) {
        this.f84297c = str;
        this.f84296b = aVar;
    }

    public String getViewHandlerName() {
        return PricingMethodItemHandler.class.getName();
    }
}
