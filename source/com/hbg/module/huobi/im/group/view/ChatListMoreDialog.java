package com.hbg.module.huobi.im.group.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.group.ui.ChatBlockListActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import rd.s;

public final class ChatListMoreDialog extends BaseDialogFragment implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f20500b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f20501c;

    public void addEvent(r rVar) {
        s sVar = s.f23381a;
        s.l(sVar, sh(), this, 0, 2, (Object) null);
        s.l(sVar, th(), this, 0, 2, (Object) null);
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R$layout.dialog_message_more;
    }

    public int getGravity() {
        return 8388611;
    }

    public void initView(r rVar) {
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        uh((LinearLayout) rVar.b(R$id.ll_block_item));
        vh((FrameLayout) rVar.b(R$id.root_view));
    }

    public boolean isTransparent() {
        return true;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R$id.ll_block_item) {
            dismiss();
            Intent intent = new Intent(getContext(), ChatBlockListActivity.class);
            Context context = getContext();
            if (context != null) {
                context.startActivity(intent);
            }
        } else if (view.getId() == R$id.root_view) {
            dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final LinearLayout sh() {
        LinearLayout linearLayout = this.f20500b;
        if (linearLayout != null) {
            return linearLayout;
        }
        return null;
    }

    public final FrameLayout th() {
        FrameLayout frameLayout = this.f20501c;
        if (frameLayout != null) {
            return frameLayout;
        }
        return null;
    }

    public final void uh(LinearLayout linearLayout) {
        this.f20500b = linearLayout;
    }

    public final void vh(FrameLayout frameLayout) {
        this.f20501c = frameLayout;
    }
}
