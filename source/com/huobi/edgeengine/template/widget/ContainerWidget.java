package com.huobi.edgeengine.template.widget;

import java.util.ArrayList;
import java.util.List;

public abstract class ContainerWidget extends Widget {

    /* renamed from: h0  reason: collision with root package name */
    public List<Widget> f44069h0 = new ArrayList();

    public void O() {
        super.O();
        for (Widget O : this.f44069h0) {
            O.O();
        }
    }

    public void X(Widget widget) {
        this.f44069h0.add(widget);
    }
}
