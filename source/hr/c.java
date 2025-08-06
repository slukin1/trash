package hr;

import com.huobi.setting.viewhandler.SettingExpandItemHandler;

public class c implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public int f84197b;

    /* renamed from: c  reason: collision with root package name */
    public a f84198c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f84199d = true;

    public interface a {
        String D(int i11);

        void E(int i11, int i12);

        boolean F();

        String a(int i11);

        void b(int i11);
    }

    public c(int i11, a aVar) {
        this.f84197b = i11;
        this.f84198c = aVar;
    }

    public a a() {
        return this.f84198c;
    }

    public int c() {
        return this.f84197b;
    }

    public boolean d() {
        return this.f84199d;
    }

    public String getViewHandlerName() {
        return SettingExpandItemHandler.class.getName();
    }

    public c(int i11, a aVar, boolean z11) {
        this.f84197b = i11;
        this.f84198c = aVar;
        this.f84199d = z11;
    }
}
