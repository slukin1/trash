package com.huobi.index.viewhandler;

import com.hbg.lib.core.util.NightHelper;
import pro.huobi.R;
import s9.c;

public abstract class IndexLiveBaseHandler implements c {
    public int b() {
        return NightHelper.e().g() ? R.drawable.icon_image_default_n : R.drawable.icon_image_default;
    }

    public int c() {
        return NightHelper.e().g() ? R.drawable.icon_image_default_big_n : R.drawable.icon_image_default_big;
    }

    public int d() {
        return NightHelper.e().g() ? R.drawable.icon_user_default_n : R.drawable.icon_user_default;
    }
}
