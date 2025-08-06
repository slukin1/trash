package rd;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class t extends ClickableSpan {

    /* renamed from: b  reason: collision with root package name */
    public Context f23382b;

    /* renamed from: c  reason: collision with root package name */
    public String f23383c;

    /* renamed from: d  reason: collision with root package name */
    public int f23384d;

    /* renamed from: e  reason: collision with root package name */
    public p f23385e;

    public t(Context context, String str, int i11) {
        this.f23382b = context;
        this.f23383c = str;
        this.f23384d = i11;
    }

    public String a() {
        return this.f23383c;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        p pVar = this.f23385e;
        if (pVar != null) {
            pVar.onClickUrl(this.f23383c);
        }
        if (view != null) {
            HBBaseWebActivity.showWebView(view.getContext(), this.f23383c, "", "", false);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void updateDrawState(TextPaint textPaint) {
        if (textPaint != null) {
            textPaint.setColor(this.f23384d);
            textPaint.setUnderlineText(true);
        }
    }
}
