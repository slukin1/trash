package com.huobi.view.chart.renderer;

import com.huobi.view.chart.utils.ViewPortHandler;

public abstract class Renderer {
    public ViewPortHandler mViewPortHandler;

    public Renderer(ViewPortHandler viewPortHandler) {
        this.mViewPortHandler = viewPortHandler;
    }
}
