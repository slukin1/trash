package com.hbg.lib.widgets.expandable;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class TextLinkSpan extends URLSpan {
    private int linkColor = 0;
    private a onLinkSpanClickListener;

    public interface a {
        void onClick(String str);
    }

    public TextLinkSpan(String str) {
        super(str);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        a aVar = this.onLinkSpanClickListener;
        if (aVar != null) {
            aVar.onClick(getURL());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        super.onClick(view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setLinkColor(int i11) {
        this.linkColor = i11;
    }

    public void setOnLinkClick(a aVar) {
        this.onLinkSpanClickListener = aVar;
    }

    public void updateDrawState(TextPaint textPaint) {
        if (textPaint != null) {
            int i11 = this.linkColor;
            if (i11 == 0) {
                i11 = textPaint.linkColor;
            }
            textPaint.setColor(i11);
            textPaint.setUnderlineText(false);
        }
    }

    public TextLinkSpan(String str, a aVar) {
        super(str);
        this.onLinkSpanClickListener = aVar;
    }
}
