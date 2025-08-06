package hr;

import com.huobi.setting.viewhandler.SettingCheckItemHandler;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public int f84192b;

    /* renamed from: c  reason: collision with root package name */
    public C0866a f84193c;

    /* renamed from: hr.a$a  reason: collision with other inner class name */
    public interface C0866a {
        String a(int i11);

        void b(int i11);

        int c(int i11);

        void d(int i11, boolean z11);
    }

    public a(int i11, C0866a aVar) {
        this.f84192b = i11;
        this.f84193c = aVar;
    }

    public C0866a a() {
        return this.f84193c;
    }

    public int c() {
        return this.f84192b;
    }

    public String getViewHandlerName() {
        return SettingCheckItemHandler.class.getName();
    }
}
