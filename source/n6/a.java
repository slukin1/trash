package n6;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.lang.DynamicLang;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.huobi.store.AppConfigManager;

public final class a {
    public static boolean a() {
        return AppConfigManager.g(MgtConfigNumber.DYNAMIC_LANGS.number, "isOpen");
    }

    public static void b() {
        SP.y("DYNAMIC_LANG_OFFLINE", true);
    }

    public static void c(DynamicLang dynamicLang) {
        SP.y("DYNAMIC_LANG_OFFLINE", false);
        if (dynamicLang == null) {
            SP.s("DYNAMIC_LANG", (String) null);
            return;
        }
        String json = new Gson().toJson((Object) dynamicLang);
        if (!TextUtils.isEmpty(json)) {
            SP.s("DYNAMIC_LANG", json);
        }
    }
}
