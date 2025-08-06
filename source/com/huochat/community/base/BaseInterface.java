package com.huochat.community.base;

import android.os.Bundle;
import android.view.View;

public interface BaseInterface {
    int getLayoutId();

    void initData(Bundle bundle);

    void initView(View view);
}
