package com.huobi.otc.dialog;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import i6.r;

public class CommitConsultCancelDialogFragment extends BaseOtcOrderCancelDialogFragment {

    /* renamed from: h  reason: collision with root package name */
    public a f78276h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f78277i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f78278j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f78279k;

    public interface a {
        void a0();

        String d9();

        void g0();

        SpannableString i0();

        SpannableString l7();
    }

    public void Dh() {
        dismiss();
        a aVar = this.f78276h;
        if (aVar != null) {
            aVar.g0();
        }
    }

    public void Eh() {
    }

    public void Fh() {
        dismiss();
        a aVar = this.f78276h;
        if (aVar != null) {
            aVar.a0();
        }
    }

    public View getContentView() {
        if (getContext() != null) {
            return View.inflate(getContext(), R$layout.dialog_commit_consult_cancel_layout, (ViewGroup) null);
        }
        return null;
    }

    public String wh() {
        return getString(R$string.n_otc_order_detail_just_cancel);
    }

    public String xh() {
        return getString(R$string.n_otc_order_detail_start_consult);
    }

    public String yh() {
        return getString(R$string.n_login_tip);
    }

    public void zh(r rVar) {
        this.f78277i = (TextView) rVar.b(R$id.id_fist_desc_tv);
        this.f78278j = (TextView) rVar.b(R$id.id_second_desc_tv);
        this.f78279k = (TextView) rVar.b(R$id.id_reason_tv);
        FragmentActivity activity = getActivity();
        if (activity instanceof a) {
            this.f78276h = (a) activity;
        }
        a aVar = this.f78276h;
        if (aVar != null) {
            this.f78277i.setText(aVar.i0());
            this.f78278j.setText(this.f78276h.l7());
            this.f78279k.setText(this.f78276h.d9());
        }
    }
}
