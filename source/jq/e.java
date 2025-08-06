package jq;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;

public class e extends Dialog implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public a f84406b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f84407c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f84408d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f84409e;

    public interface a {
        void a0();

        void g0();
    }

    public e(Context context) {
        super(context, R.style.CustomDialog_DayTheme);
        setContentView(R.layout.dialog_points_transfer_confirm);
        setCanceledOnTouchOutside(false);
        b();
        a();
    }

    public final void a() {
        findViewById(R.id.dialog_cancel_btn).setOnClickListener(this);
        findViewById(R.id.dialog_confirm_btn).setOnClickListener(this);
    }

    public final void b() {
        this.f84407c = (TextView) findViewById(R.id.id_points_transfer_dialog_pts);
        this.f84408d = (TextView) findViewById(R.id.id_points_transfer_dialog_usdt);
        this.f84409e = (TextView) findViewById(R.id.id_points_transfer_dialog_title);
    }

    public void c(a aVar) {
        this.f84406b = aVar;
    }

    public void d(String str) {
        this.f84407c.setText(str);
    }

    public void e(String str) {
        this.f84409e.setText(str);
    }

    public void f(String str) {
        this.f84408d.setText(str);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        a aVar;
        int id2 = view.getId();
        if (id2 == R.id.dialog_cancel_btn) {
            a aVar2 = this.f84406b;
            if (aVar2 != null) {
                aVar2.g0();
            }
        } else if (id2 == R.id.dialog_confirm_btn && (aVar = this.f84406b) != null) {
            aVar.a0();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
