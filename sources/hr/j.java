package hr;

import android.text.TextUtils;
import com.huobi.setting.viewhandler.TradingSettingTitleHandler;
import s9.a;

public class j implements a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f84216b = false;

    /* renamed from: c  reason: collision with root package name */
    public String f84217c;

    public j(boolean z11, String str) {
        this.f84216b = z11;
        this.f84217c = str;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f84217c)) {
            return "";
        }
        return this.f84217c;
    }

    public boolean c() {
        return this.f84216b;
    }

    public String getViewHandlerName() {
        return TradingSettingTitleHandler.class.getName();
    }
}
