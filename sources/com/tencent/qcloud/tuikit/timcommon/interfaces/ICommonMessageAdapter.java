package com.tencent.qcloud.tuikit.timcommon.interfaces;

import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;

public interface ICommonMessageAdapter {
    TUIMessageBean getItem(int i11);

    void notifyItemChanged(int i11);
}
