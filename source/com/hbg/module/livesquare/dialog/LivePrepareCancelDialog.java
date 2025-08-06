package com.hbg.module.livesquare.dialog;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;

public class LivePrepareCancelDialog extends BaseDialogFragment implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f26496b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26497c;

    /* renamed from: d  reason: collision with root package name */
    public b f26498d;

    public class a implements View.OnTouchListener {
        public a() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public interface b {
        void a();
    }

    public void addEvent(r rVar) {
        this.f26497c.setOnClickListener(this);
        this.f26496b.setOnClickListener(this);
        rVar.b(R$id.root_view).setOnClickListener(this);
        rVar.b(R$id.rl_content).setOnTouchListener(new a());
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R$layout.dialog_live_cancel_prepare;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        setCanceledOnTouchOutside(true);
        this.f26496b = (TextView) rVar.b(R$id.tv_cancel);
        this.f26497c = (TextView) rVar.b(R$id.tv_confirm);
    }

    public boolean isTransparent() {
        return false;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R$id.tv_cancel) {
            dismiss();
        } else if (view.getId() == R$id.root_view) {
            dismiss();
        } else if (view.getId() == R$id.tv_confirm) {
            b bVar = this.f26498d;
            if (bVar != null) {
                bVar.a();
            }
            dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
