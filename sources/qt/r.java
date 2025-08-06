package qt;

import com.hbg.lib.core.util.ConfigPreferences;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f84719a;

    public static boolean a() {
        return ConfigPreferences.b("user_config", "config_trade_margin_lever");
    }

    public static boolean b() {
        return f84719a;
    }

    public static void c(boolean z11) {
        ConfigPreferences.n("user_config", "config_trade_margin_lever", z11);
    }
}
