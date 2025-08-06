package ks;

import com.hbg.lib.core.util.ConfigPreferences;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f84424a;

    public static a a() {
        if (f84424a == null) {
            synchronized (a.class) {
                if (f84424a == null) {
                    f84424a = new a();
                }
            }
        }
        return f84424a;
    }

    public int b() {
        return ConfigPreferences.g("user_config", "config_margin_loan_repay_type", 0);
    }

    public void c(int i11) {
        ConfigPreferences.k("user_config", "config_margin_loan_repay_type", i11);
    }
}
