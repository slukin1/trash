package com.tencent.qcloud.tuikit.tuichat.interfaces;

import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import java.util.List;

public interface IMessageAdapter {
    void onDataSourceChanged(List<TUIMessageBean> list);

    void onScrollToEnd();

    void onViewNeedRefresh(int i11, int i12);

    void onViewNeedRefresh(int i11, TUIMessageBean tUIMessageBean);
}
