package com.tencent.qcloud.tuikit.timcommon.component.interfaces;

import com.tencent.qcloud.tuikit.timcommon.component.TitleBarLayout;

public interface ILayout {
    TitleBarLayout getTitleBar();

    void setParentLayout(Object obj);
}
