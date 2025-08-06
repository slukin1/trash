package com.hbg.component.kline.render;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.hbg.component.kline.render.CandleStickRender;
import java.util.LinkedHashSet;

public class TimeLineRender extends CandleStickRender {
    public boolean b(MotionEvent motionEvent) {
        return false;
    }

    public void j(View view, Context context, AttributeSet attributeSet, int i11) {
        super.j(view, context, attributeSet, i11);
        A4(0);
        G4("");
        H4((LinkedHashSet<String>) null);
        z4(CandleStickRender.KLineType.TIME_LINE);
    }
}
