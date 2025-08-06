package com.hbg.module.livesquare.dialog;

import af.c;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import b2.a;
import com.alibaba.android.arouter.facade.Postcard;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.LiveAppointmentData;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.hbg.module.libkt.provider.HbgBaseShareProvider;
import com.hbg.module.livesquare.utils.LiveTrackUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dd.b;
import i6.r;

public class LivePrepareDialog extends BaseDialogFragment implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f26500b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26501c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f26502d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26503e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f26504f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f26505g;

    /* renamed from: h  reason: collision with root package name */
    public LiveAppointmentData f26506h;

    /* renamed from: i  reason: collision with root package name */
    public LiveDetailBean f26507i;

    /* renamed from: j  reason: collision with root package name */
    public HbgBaseShareProvider f26508j;

    public LivePrepareDialog() {
    }

    public static /* synthetic */ boolean lambda$addEvent$0(View view, MotionEvent motionEvent) {
        return true;
    }

    public void addEvent(r rVar) {
        this.f26501c.setOnClickListener(this);
        this.f26500b.setOnClickListener(this);
        this.f26502d.setOnClickListener(this);
        rVar.b(R$id.root_view).setOnClickListener(this);
        rVar.b(R$id.ll_content).setOnTouchListener(c.f3536b);
    }

    public void afterInit() {
        LiveAppointmentData liveAppointmentData = this.f26506h;
        if (liveAppointmentData != null && liveAppointmentData.getLiveGroup() != null) {
            String title = this.f26506h.getLiveGroup().getTitle();
            if (!TextUtils.isEmpty(title)) {
                this.f26503e.setText(title);
            }
            if (TextUtils.isEmpty(this.f26506h.getLiveGroup().getGroupId())) {
                this.f26505g.setVisibility(8);
            } else {
                this.f26505g.setVisibility(0);
            }
        }
    }

    public int getContentViewResId() {
        return R$layout.dialog_live_go_prepare;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        this.f26508j = (HbgBaseShareProvider) a.d().a("/provider/share/h5").navigation();
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.f26500b = (TextView) rVar.b(R$id.tv_into);
        this.f26501c = (TextView) rVar.b(R$id.tv_share);
        this.f26502d = (TextView) rVar.b(R$id.tv_cancel);
        this.f26503e = (TextView) rVar.b(R$id.tv_talk_title);
        this.f26504f = (ImageView) rVar.b(R$id.iv_icon);
        this.f26505g = (RelativeLayout) rVar.b(R$id.rl_into_group);
    }

    public boolean isTransparent() {
        return false;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R$id.tv_into) {
            LiveAppointmentData liveAppointmentData = this.f26506h;
            if (!(liveAppointmentData == null || liveAppointmentData.getLiveGroup() == null)) {
                if (this.f26506h.getLiveGroup().getType() == 1 || this.f26506h.getLiveGroup().getHasJion() == 1) {
                    b.f22740a.j(getContext(), this.f26506h.getLiveGroup().getGroupId(), this.f26506h.getLiveGroup().getTitle(), (String) null);
                    LiveTrackUtils.c("APP_LIVE_group_getinto", 1, Long.valueOf(this.f26506h.getLiveGroup().getId()), this.f26506h.getLiveGroup().getTitle(), Long.valueOf(this.f26506h.getLiveGroup().getLiveId()), 3);
                } else {
                    Postcard a11 = a.d().a("/webView/index");
                    BaseModuleConfig.a a12 = BaseModuleConfig.a();
                    a11.withString("url", a12.k("live/community/privateGroup?groupId=" + this.f26506h.getLiveGroup().getGroupId())).navigation(requireContext());
                }
            }
        } else if (view.getId() == R$id.tv_share) {
            LiveAppointmentData liveAppointmentData2 = this.f26506h;
            if (!(liveAppointmentData2 == null || liveAppointmentData2.getLiveGroup() == null)) {
                cf.a.f26395a.e(getActivity(), this.f26507i);
                LiveTrackUtils.d(1, Long.valueOf(this.f26506h.getLiveGroup().getId()), this.f26506h.getLiveGroup().getTitle(), Long.valueOf(this.f26506h.getLiveGroup().getLiveId()));
            }
        } else if (view.getId() == R$id.tv_cancel) {
            dismiss();
        } else if (view.getId() == R$id.root_view) {
            dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
        LiveAppointmentData liveAppointmentData = this.f26506h;
        if (liveAppointmentData != null && liveAppointmentData.getLiveGroup() != null) {
            LiveTrackUtils.h("APP_LIVE_notice_show", 1, Long.valueOf(this.f26506h.getLiveGroup().getId()), this.f26506h.getLiveGroup().getTitle(), Long.valueOf(this.f26506h.getLiveGroup().getLiveId()));
        }
    }

    public LivePrepareDialog(LiveAppointmentData liveAppointmentData, LiveDetailBean liveDetailBean) {
        this.f26506h = liveAppointmentData;
        this.f26507i = liveDetailBean;
    }
}
