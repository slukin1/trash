package com.huobi.otc.dialog;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import i6.r;
import java.util.HashMap;
import uf.c;

public class ConsultCancelDealDialogFragment extends BaseOtcOrderCancelDialogFragment {

    /* renamed from: h  reason: collision with root package name */
    public boolean f78285h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f78286i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f78287j;

    /* renamed from: k  reason: collision with root package name */
    public String f78288k;

    /* renamed from: l  reason: collision with root package name */
    public a f78289l;

    public interface a {
        void a();

        void b();
    }

    public void Dh() {
        dismiss();
        a aVar = this.f78289l;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void Eh() {
    }

    public void Fh() {
        a aVar;
        c.b().s("confirm_cancel", "otc.order.page.confirm_cancel", (HashMap) null);
        dismiss();
        if (this.f78285h && (aVar = this.f78289l) != null) {
            aVar.b();
        }
    }

    public View getContentView() {
        if (getContext() != null) {
            return View.inflate(getContext(), R$layout.dialog_consult_cancel_layout, (ViewGroup) null);
        }
        return null;
    }

    public String wh() {
        return getString(R$string.n_otc_order_detail_reject_tip);
    }

    public String xh() {
        int i11;
        if (this.f78285h) {
            i11 = R$string.n_otc_order_detail_agree_tip;
        } else {
            i11 = R$string.n_otc_receive_order_cancel_alert_cancel;
        }
        return getString(i11);
    }

    public String yh() {
        int i11;
        if (this.f78285h) {
            i11 = R$string.n_otc_order_detail_agree_consult_tip;
        } else {
            i11 = R$string.n_otc_order_detail_reject_consult;
        }
        return getString(i11);
    }

    public void zh(r rVar) {
        String str;
        this.f78286i = (TextView) rVar.b(R$id.id_tips_tv);
        this.f78287j = (TextView) rVar.b(R$id.id_consult_content_tv);
        Gh(!this.f78285h);
        TextView textView = this.f78287j;
        if (this.f78285h) {
            str = getString(R$string.n_otc_order_detail_agree_consult);
        } else {
            str = getString(R$string.n_otc_order_detail_reject_consult_content);
        }
        textView.setText(str);
        this.f78286i.setText(getString(R$string.n_otc_order_detail_buyer_cancel_reason, this.f78288k));
    }
}
