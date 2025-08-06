package com.huobi.linearswap.ui;

import android.os.Bundle;
import android.view.View;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;

public class ContractCloseAllDialog extends BaseDialogFragment implements View.OnClickListener, BaseDialogFragment.c {

    /* renamed from: b  reason: collision with root package name */
    public a f75139b;

    public interface a {
        void a(int i11);
    }

    public static ContractCloseAllDialog sh() {
        return new ContractCloseAllDialog();
    }

    public void addEvent(r rVar) {
    }

    public void afterInit() {
        setCanDismissOnBackPress(true);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void doDismiss() {
        super.doDismiss();
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.dialog_contract_close_all_layout;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        rVar.b(R.id.v_root).setOnClickListener(this);
        rVar.b(R.id.tvAll).setOnClickListener(this);
        rVar.b(R.id.tvLimit).setOnClickListener(this);
        rVar.b(R.id.tvTpsl).setOnClickListener(this);
        rVar.b(R.id.tvCancel).setOnClickListener(this);
    }

    public boolean isTransparent() {
        return false;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R.id.v_root || view.getId() == R.id.tvCancel) {
            doDismiss();
        } else if (view.getId() == R.id.tvAll) {
            doDismiss();
            a aVar = this.f75139b;
            if (aVar != null) {
                aVar.a(0);
            }
        } else if (view.getId() == R.id.tvLimit) {
            doDismiss();
            a aVar2 = this.f75139b;
            if (aVar2 != null) {
                aVar2.a(1);
            }
        } else if (view.getId() == R.id.tvTpsl) {
            doDismiss();
            a aVar3 = this.f75139b;
            if (aVar3 != null) {
                aVar3.a(2);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onDialogFragmentBackPressed() {
    }

    public void onDialogFragmentPause() {
    }

    public void onDialogFragmentResume() {
    }

    public ContractCloseAllDialog th(a aVar) {
        this.f75139b = aVar;
        return this;
    }
}
