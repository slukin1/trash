package com.huobi.otc.dialog;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dp.e;
import i6.r;

public class CommonCancelOrderDialogFragment extends BaseOtcOrderCancelDialogFragment {

    /* renamed from: h  reason: collision with root package name */
    public TextView f78280h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f78281i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f78282j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f78283k;

    /* renamed from: l  reason: collision with root package name */
    public a f78284l;

    public interface a {
        void a();

        String b();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Kh(View view) {
        boolean z11 = !this.f78283k;
        this.f78283k = z11;
        Hh(z11);
        this.f78282j.setImageResource(this.f78283k ? R$drawable.marquee_selected : R$drawable.marquee_unselected);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Dh() {
        dismiss();
    }

    public void Eh() {
        this.f78281i.setOnClickListener(new e(this));
    }

    public void Fh() {
        dismiss();
        a aVar = this.f78284l;
        if (aVar != null) {
            aVar.a();
        }
    }

    public View getContentView() {
        if (getContext() == null) {
            return null;
        }
        return View.inflate(getContext(), R$layout.dialog_content_common_cancle_order_layout, (ViewGroup) null);
    }

    public String wh() {
        return "";
    }

    public String xh() {
        return getString(R$string.n_otc_receive_order_buyer_cancel_alert_confirm);
    }

    public String yh() {
        return getString(R$string.n_otc_order_detail_cancel_order);
    }

    public void zh(r rVar) {
        this.f78280h = (TextView) rVar.b(R$id.id_content_tv);
        this.f78281i = (LinearLayout) rVar.b(R$id.id_second_confirm_ll);
        this.f78282j = (ImageView) rVar.b(R$id.id_check_iv);
        this.f78283k = false;
        Hh(false);
        Gh(false);
        Ih(false);
        a aVar = this.f78284l;
        if (aVar != null) {
            this.f78280h.setText(aVar.b());
        }
    }
}
