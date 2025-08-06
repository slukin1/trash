package com.huobi.tradenew.helper;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.tradenew.helper.a;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;

public class LeverTooLargeHintDialogFragment extends BaseDialogFragment implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f82863b;

    /* renamed from: c  reason: collision with root package name */
    public CheckBox f82864c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f82865d;

    /* renamed from: e  reason: collision with root package name */
    public a.C0857a f82866e;

    public static LeverTooLargeHintDialogFragment sh(String str) {
        LeverTooLargeHintDialogFragment leverTooLargeHintDialogFragment = new LeverTooLargeHintDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.LEVEL, str);
        leverTooLargeHintDialogFragment.setArguments(bundle);
        return leverTooLargeHintDialogFragment;
    }

    public void addEvent(r rVar) {
        this.f82863b.setOnClickListener(this);
        this.f82865d.setOnClickListener(this);
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R.layout.dialog_level_too_large_hint;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        TextView textView = (TextView) rVar.b(R.id.tv_content);
        this.f82864c = (CheckBox) rVar.b(R.id.cb_hint_no_more);
        this.f82863b = (TextView) rVar.b(R.id.tv_confirm);
        this.f82865d = (TextView) rVar.b(R.id.tv_cancel);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(FirebaseAnalytics.Param.LEVEL);
            textView.setText(getResources().getString(R.string.n_contract_high_lever_warning, new Object[]{string}));
        }
    }

    public boolean isTransparent() {
        return false;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        a.C0857a aVar;
        int id2 = view.getId();
        dismiss();
        if (this.f82864c.isChecked()) {
            a.a().b();
        }
        if (id2 == R.id.tv_confirm) {
            a.C0857a aVar2 = this.f82866e;
            if (aVar2 != null) {
                aVar2.b();
            }
        } else if (id2 == R.id.tv_cancel && (aVar = this.f82866e) != null) {
            aVar.a();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void th(a.C0857a aVar) {
        this.f82866e = aVar;
    }
}
