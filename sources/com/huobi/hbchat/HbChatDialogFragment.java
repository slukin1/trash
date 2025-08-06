package com.huobi.hbchat;

import android.content.Context;
import android.view.View;
import com.hbg.lib.common.utils.PackageManagerUtil;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.util.IntentSafeUtils;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huochat.community.base.CommunityConstants;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;

public class HbChatDialogFragment extends BaseDialogFragment implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public int f72467b = -1;

    public void addEvent(r rVar) {
        rVar.b(R.id.id_hbchat_dialog_image_iv).setOnClickListener(this);
        rVar.b(R.id.id_hbchat_dialog_close_btn).setOnClickListener(this);
    }

    public void afterInit() {
        setCanDismissOnBackPress(false);
    }

    public int getContentViewResId() {
        return R.layout.dialog_fragment_hbchat;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
    }

    public boolean isFullScreen() {
        return true;
    }

    public boolean isTransparent() {
        return false;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.id_hbchat_dialog_image_iv) {
            sh(getActivity());
            dismiss();
        } else if (id2 == R.id.id_hbchat_dialog_close_btn) {
            dismiss();
        }
        int i11 = this.f72467b + 1;
        this.f72467b = i11;
        SP.q("sp_key_hbchat_show_times", i11);
        SP.r("sp_key_hbchat_last_show_time", System.currentTimeMillis());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void sh(Context context) {
        if (PackageManagerUtil.a(context, "com.huochat.im")) {
            IntentSafeUtils.c(context, CommunityConstants.HUOBICHAT_URL_SCHEME);
        } else {
            IntentSafeUtils.b(context, "https://h5.huotalk.com/dl/");
        }
    }
}
