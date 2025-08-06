package com.tencent.qcloud.tuikit.timcommon.component.face;

import com.davemorrissey.labs.subscaleview.ImageSource;

public class CustomFace extends ChatFace {
    public void setAssetPath(String str) {
        this.faceUrl = ImageSource.ASSET_SCHEME + str;
    }
}
