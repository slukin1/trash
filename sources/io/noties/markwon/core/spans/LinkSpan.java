package io.noties.markwon.core.spans;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import rz.a;

public class LinkSpan extends URLSpan {
    private final String link;
    private final a resolver;
    private final sz.a theme;

    public LinkSpan(sz.a aVar, String str, a aVar2) {
        super(str);
        this.theme = aVar;
        this.link = str;
        this.resolver = aVar2;
    }

    public String getLink() {
        return this.link;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        this.resolver.resolve(view, this.link);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void updateDrawState(TextPaint textPaint) {
        this.theme.g(textPaint);
    }
}
