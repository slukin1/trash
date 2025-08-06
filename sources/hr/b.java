package hr;

import com.huobi.setting.viewhandler.SettingCommonItemHandler;

public class b implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public int f84194b;

    /* renamed from: c  reason: collision with root package name */
    public a f84195c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f84196d = true;

    public interface a {
        String a(int i11);

        void b(int i11);

        int c(int i11);

        void d(int i11, boolean z11);

        boolean s(int i11);
    }

    public b(int i11, a aVar) {
        this.f84194b = i11;
        this.f84195c = aVar;
    }

    public a a() {
        return this.f84195c;
    }

    public int c() {
        return this.f84194b;
    }

    public boolean d() {
        return this.f84196d;
    }

    public String getViewHandlerName() {
        return SettingCommonItemHandler.class.getName();
    }

    public b(int i11, a aVar, boolean z11) {
        this.f84194b = i11;
        this.f84195c = aVar;
        this.f84196d = z11;
    }
}
