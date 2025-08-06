package hr;

import android.text.TextUtils;
import com.huobi.setting.viewhandler.TradingSettingNotificationTitleHandler;
import s9.a;

public class i implements a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f84214b;

    /* renamed from: c  reason: collision with root package name */
    public String f84215c;

    public String a() {
        if (TextUtils.isEmpty(this.f84215c)) {
            return "";
        }
        return this.f84215c;
    }

    public boolean c() {
        return this.f84214b;
    }

    public String getViewHandlerName() {
        return TradingSettingNotificationTitleHandler.class.getName();
    }
}
