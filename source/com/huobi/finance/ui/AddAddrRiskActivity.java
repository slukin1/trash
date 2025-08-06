package com.huobi.finance.ui;

import android.content.Context;
import android.content.Intent;
import com.huobi.finance.presenter.AddAddrRiskPresenter;
import com.huobi.finance.presenter.UnifyRiskPresenter;
import pro.huobi.R;

public class AddAddrRiskActivity extends UnifyRiskActivity {
    public static void Gh(Context context, String str) {
        Intent intent = new Intent(context, AddAddrRiskActivity.class);
        intent.putExtra("address-id", str);
        context.startActivity(intent);
    }

    /* renamed from: sh */
    public UnifyRiskPresenter createPresenter() {
        return new AddAddrRiskPresenter();
    }

    public void th(int i11) {
        if (i11 == -1) {
            this.f46847e.setText(R.string.wait_check);
            this.f46849g.setImageResource(R.drawable.withdraw_risk_wait);
            this.f46850h.setText(R.string.wait_check_tip);
            this.f46851i.setVisibility(8);
        } else if (i11 == 1) {
            this.f46847e.setText(R.string.title_email);
            this.f46849g.setImageResource(R.drawable.withdraw_risk_mail);
            this.f46850h.setText(getResources().getString(R.string.n_risk_email_hint));
            this.f46851i.setText(R.string.mail_check_retry);
            this.f46851i.setVisibility(0);
        } else if (i11 == 2) {
            this.f46847e.setText(R.string.title_sms);
            this.f46849g.setImageResource(R.drawable.withdraw_risk_sms);
            this.f46850h.setText(getResources().getString(R.string.n_risk_sms_hint));
            this.f46851i.setText(R.string.sms_check_retry);
            this.f46851i.setVisibility(0);
        } else if (i11 == 3) {
            this.f46847e.setText(R.string.face_check_title);
            this.f46849g.setImageResource(R.drawable.withdraw_risk_face);
            this.f46850h.setText(getResources().getString(R.string.n_risk_face_hint));
            this.f46851i.setVisibility(8);
        }
        this.f46848f.setText(R.string.n_risk_add_withdraw_addr);
        this.f46852j.setVisibility(8);
        if (i11 == 0) {
            this.f46847e.setText(R.string.verify_finish);
            this.f46848f.setVisibility(8);
            this.f46849g.setImageResource(R.drawable.withdraw_risk_pass);
            this.f46850h.setText(R.string.n_risk_add_withdraw_addr_success_subtitle);
            this.f46851i.setVisibility(8);
        }
    }

    public int uh() {
        return R.string.n_risk_add_withdraw_addr_fail_subtitle;
    }
}
