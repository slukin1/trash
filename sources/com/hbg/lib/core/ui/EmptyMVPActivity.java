package com.hbg.lib.core.ui;

import u6.g;

public abstract class EmptyMVPActivity extends BaseActivity<EmptyActPresenter, g> {
    public void addEvent() {
    }

    public g getUI() {
        return this;
    }

    public void initView() {
    }

    public EmptyActPresenter createPresenter() {
        return new EmptyActPresenter();
    }
}
