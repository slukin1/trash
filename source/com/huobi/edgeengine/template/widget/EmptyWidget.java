package com.huobi.edgeengine.template.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import rj.n;

public class EmptyWidget extends Widget {
    public View Q(Context context, n nVar) {
        View view = new View(context);
        view.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        return view;
    }

    public View q(Context context) {
        return new View(context);
    }
}
