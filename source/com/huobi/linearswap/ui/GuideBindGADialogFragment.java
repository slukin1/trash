package com.huobi.linearswap.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import cn.a;
import cn.b;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.account.ui.BrushGuideGAActivity;
import com.huobi.account.ui.SecurityLinkStatusActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;

public class GuideBindGADialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public View f75140b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f75141c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f75142d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f75143e;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        if (this.f75143e) {
            uh(getActivity());
        } else {
            Intent intent = new Intent(getActivity(), BrushGuideGAActivity.class);
            intent.putExtra("JUMP_LOGIN_GA_BIND_PAGE", true);
            getActivity().startActivity(intent);
        }
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
        this.f75140b.setOnClickListener(new b(this));
        this.f75141c.setOnClickListener(new a(this));
    }

    public void afterInit() {
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        if (this.f75143e) {
            this.f75142d.setText(R.string.n_login_open_google_auth);
            this.f75141c.setText(R.string.n_content_push_open_immediately);
            return;
        }
        this.f75142d.setText(R.string.n_login_bind_google_auth);
        this.f75141c.setText(R.string.n_ga_guide_go_to_bind);
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.dialog_guide_bind_ga;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f75140b = rVar.b(R.id.btn_next);
        this.f75141c = (TextView) rVar.b(R.id.btn_action);
        this.f75142d = (TextView) rVar.b(R.id.tv_bind);
    }

    public boolean isTransparent() {
        return false;
    }

    public final void uh(Context context) {
        Intent intent = new Intent(context, SecurityLinkStatusActivity.class);
        intent.putExtra("LINK_TYPE_KEY", 3);
        intent.putExtra("VERIFY_STATUS_KEY", 2);
        intent.putExtra("link_ga_open_dialog_type", true);
        context.startActivity(intent);
    }

    public void vh(boolean z11) {
        this.f75143e = z11;
    }
}
