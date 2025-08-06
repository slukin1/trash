package com.huobi.edgeengine.template.widget.list;

import ak.g;
import android.view.View;

public class ExampleStickyView implements g {
    public boolean a(View view) {
        if (view.getTag() == null) {
            return false;
        }
        return ((Boolean) view.getTag()).booleanValue();
    }
}
