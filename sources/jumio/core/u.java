package jumio.core;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.jumio.commons.log.Log;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.io.Serializable;

public final class u extends ClickableSpan implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final String f56327a;

    /* renamed from: b  reason: collision with root package name */
    public final int f56328b;

    public u(String str, int i11) {
        this.f56327a = str;
        this.f56328b = i11;
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.putExtra("com.android.browser.application_id", context.getPackageName());
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Log.w("Activity was not found for intent, " + intent);
        }
    }

    @SensorsDataInstrumented
    public final void onClick(View view) {
        a(view.getContext(), this.f56327a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(true);
        int i11 = this.f56328b;
        if (i11 != 0) {
            textPaint.setColor(i11);
        }
    }
}
