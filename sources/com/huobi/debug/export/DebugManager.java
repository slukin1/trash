package com.huobi.debug.export;

import android.content.Context;
import com.alibaba.android.arouter.facade.template.IProvider;

public interface DebugManager extends IProvider {
    void openDebugPage(Context context);

    void setNetLogPage(NetLogPage netLogPage);
}
