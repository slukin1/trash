package com.luck.picture.lib.interfaces;

import android.content.Context;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.entity.LocalMedia;

public interface OnSelectLimitTipsListener {
    boolean onSelectLimitTips(Context context, LocalMedia localMedia, SelectorConfig selectorConfig, int i11);
}
