package com.hbg.module.libkt.provider;

import android.content.Context;
import com.alibaba.android.arouter.facade.template.IProvider;

public interface BaseJumpPageProvider extends IProvider {
    void d(Context context, JumpPageScheme jumpPageScheme);

    void e(Context context, String str, String str2);
}
