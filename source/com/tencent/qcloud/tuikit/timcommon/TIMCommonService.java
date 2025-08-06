package com.tencent.qcloud.tuikit.timcommon;

import android.content.Context;
import com.tencent.qcloud.tuicore.ServiceInitializer;

public class TIMCommonService extends ServiceInitializer {
    public int getLightThemeResId() {
        return R.style.TIMCommonLightTheme;
    }

    public int getLivelyThemeResId() {
        return R.style.TIMCommonLivelyTheme;
    }

    public int getSeriousThemeResId() {
        return R.style.TIMCommonSeriousTheme;
    }

    public void init(Context context) {
        super.init(context);
    }
}
