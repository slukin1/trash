package yl;

import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.huobi.index.ui.PromoteFeatureDialog;
import tg.r;

public final class s {
    public static boolean a() {
        if (PromoteFeatureDialog.uh() == null) {
            return false;
        }
        if (r.x().F0() && r.x().X()) {
            return false;
        }
        String n11 = DateTimeUtils.n(System.currentTimeMillis());
        return !ConfigPreferences.c("user_config", "promote_feature" + n11, false);
    }
}
