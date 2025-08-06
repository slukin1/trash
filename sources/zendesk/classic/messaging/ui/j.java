package zendesk.classic.messaging.ui;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import zendesk.belvedere.BelvedereUi;
import zendesk.belvedere.ImageStream;
import zendesk.classic.messaging.BelvedereMediaHolder;
import zendesk.classic.messaging.R$id;

public class j implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final AppCompatActivity f62799b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageStream f62800c;

    /* renamed from: d  reason: collision with root package name */
    public final BelvedereMediaHolder f62801d;

    public j(AppCompatActivity appCompatActivity, ImageStream imageStream, BelvedereMediaHolder belvedereMediaHolder) {
        this.f62799b = appCompatActivity;
        this.f62800c = imageStream;
        this.f62801d = belvedereMediaHolder;
    }

    public void a() {
        BelvedereUi.b(this.f62799b).g().h("*/*", true).l(this.f62801d.c()).m(R$id.input_box_attachments_indicator, R$id.input_box_send_btn).j(true).f(this.f62799b);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (!this.f62800c.uh()) {
            a();
        } else {
            this.f62800c.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
