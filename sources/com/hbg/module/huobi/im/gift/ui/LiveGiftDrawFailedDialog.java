package com.hbg.module.huobi.im.gift.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.huobi.im.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import id.j;

public final class LiveGiftDrawFailedDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f19776b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f19777c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19778d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19779e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19780f;

    @SensorsDataInstrumented
    public static final void th(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
        TextView textView = this.f19780f;
        if (textView != null) {
            textView.setOnClickListener(j.f55053b);
        }
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R$layout.layout_live_gift_box_empty;
    }

    public int getGravity() {
        return 80;
    }

    /* JADX WARNING: type inference failed for: r4v1, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView(i6.r r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x000c
            int r1 = com.hbg.module.huobi.im.R$id.ivLiveGiftEmptyClose
            android.view.View r1 = r4.b(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            goto L_0x000d
        L_0x000c:
            r1 = r0
        L_0x000d:
            r3.f19776b = r1
            if (r4 == 0) goto L_0x001a
            int r1 = com.hbg.module.huobi.im.R$id.ivLiveGiftEmptyTop
            android.view.View r1 = r4.b(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            goto L_0x001b
        L_0x001a:
            r1 = r0
        L_0x001b:
            r3.f19777c = r1
            if (r1 == 0) goto L_0x0024
            int r2 = com.hbg.module.huobi.im.R$drawable.im_icon_gift_error
            r1.setImageResource(r2)
        L_0x0024:
            if (r4 == 0) goto L_0x002f
            int r1 = com.hbg.module.huobi.im.R$id.tvLiveGiftEmptyTitle
            android.view.View r1 = r4.b(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x0030
        L_0x002f:
            r1 = r0
        L_0x0030:
            r3.f19778d = r1
            if (r4 == 0) goto L_0x003d
            int r1 = com.hbg.module.huobi.im.R$id.tvLiveGiftEmptyMsg
            android.view.View r1 = r4.b(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x003e
        L_0x003d:
            r1 = r0
        L_0x003e:
            r3.f19779e = r1
            if (r4 == 0) goto L_0x004b
            int r0 = com.hbg.module.huobi.im.R$id.tvLiveGiftBoxEmptyBtn
            android.view.View r4 = r4.b(r0)
            r0 = r4
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x004b:
            r3.f19780f = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.gift.ui.LiveGiftDrawFailedDialog.initView(i6.r):void");
    }

    public boolean isTransparent() {
        return true;
    }
}
