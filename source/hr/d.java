package hr;

import android.view.View;
import com.huobi.setting.viewhandler.SettingItemHandler;

public class d implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public int f84200b;

    /* renamed from: c  reason: collision with root package name */
    public a f84201c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f84202d = true;

    public interface a {
        String D(int i11);

        boolean E8(int i11, View view);

        String a(int i11);

        void onItemClick(int i11);

        boolean v8(int i11);
    }

    public d(int i11, a aVar) {
        this.f84200b = i11;
        this.f84201c = aVar;
    }

    public boolean a() {
        return this.f84202d;
    }

    public String getViewHandlerName() {
        return SettingItemHandler.class.getName();
    }

    public d(int i11, a aVar, boolean z11) {
        this.f84200b = i11;
        this.f84201c = aVar;
        this.f84202d = z11;
    }
}
