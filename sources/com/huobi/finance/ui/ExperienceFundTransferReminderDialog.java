package com.huobi.finance.ui;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dn.d;
import i6.m;
import i6.r;
import pro.huobi.R;

public class ExperienceFundTransferReminderDialog extends BaseDialogFragment implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public int f46541b = 0;

    /* renamed from: c  reason: collision with root package name */
    public a f46542c;

    public interface a {
        void a();

        void b();
    }

    public void addEvent(r rVar) {
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R.layout.dialog_experience_fund_transfer_reminder;
    }

    public int getGravity() {
        return 17;
    }

    @SuppressLint({"SetTextI18n"})
    public void initView(r rVar) {
        String str;
        String str2;
        TextView textView = (TextView) rVar.b(R.id.tv_content);
        rVar.b(R.id.tv_continue).setOnClickListener(this);
        rVar.b(R.id.tv_cancel).setOnClickListener(this);
        boolean m11 = d.f().m();
        String o02 = m.o0(m.s0(dn.a.d().c(), this.f46541b));
        if (m11) {
            str = getResources().getString(R.string.n_contract_u_transfer_tips_3);
            str2 = getResources().getString(R.string.n_contract_u_transfer_tips_4);
        } else {
            str = getResources().getString(R.string.n_contract_u_transfer_tips_1);
            str2 = getResources().getString(R.string.n_contract_u_transfer_tips_2);
        }
        textView.setText(String.format(str, new Object[]{o02}) + "\n\n" + str2);
    }

    public boolean isTransparent() {
        return false;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.tv_continue) {
            dismiss();
            a aVar = this.f46542c;
            if (aVar != null) {
                aVar.a();
            }
        } else if (id2 == R.id.tv_cancel) {
            dismiss();
            a aVar2 = this.f46542c;
            if (aVar2 != null) {
                aVar2.b();
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void sh(a aVar) {
        this.f46542c = aVar;
    }

    public void th(int i11) {
        this.f46541b = i11;
    }
}
