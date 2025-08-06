package com.huobi.tradenew.helper;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.util.ConfigPreferences;

public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f82867b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f82868a = ConfigPreferences.c("contract_config", "config_app_contract_level_too_large", true);

    /* renamed from: com.huobi.tradenew.helper.a$a  reason: collision with other inner class name */
    public interface C0857a {
        void a();

        void b();
    }

    public static a a() {
        if (f82867b == null) {
            f82867b = new a();
        }
        return f82867b;
    }

    public void b() {
        this.f82868a = false;
        ConfigPreferences.n("contract_config", "config_app_contract_level_too_large", false);
    }

    public void c(Context context, String str, C0857a aVar) {
        LeverTooLargeHintDialogFragment sh2 = LeverTooLargeHintDialogFragment.sh(str);
        sh2.th(aVar);
        sh2.show(((FragmentActivity) context).getSupportFragmentManager(), "LeverTooLargeHIntDialogFragment");
    }

    public boolean d() {
        return this.f82868a;
    }
}
