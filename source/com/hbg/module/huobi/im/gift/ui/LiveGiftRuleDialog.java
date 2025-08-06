package com.hbg.module.huobi.im.gift.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.huobi.im.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import id.q;

public final class LiveGiftRuleDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f19798b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f19799c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19800d;

    /* renamed from: e  reason: collision with root package name */
    public a f19801e;

    public interface a {
        void a();

        void c();
    }

    @SensorsDataInstrumented
    public static final void uh(LiveGiftRuleDialog liveGiftRuleDialog, View view) {
        a aVar = liveGiftRuleDialog.f19801e;
        if (aVar != null) {
            aVar.a();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void vh(LiveGiftRuleDialog liveGiftRuleDialog, View view) {
        liveGiftRuleDialog.dismiss();
        a aVar = liveGiftRuleDialog.f19801e;
        if (aVar != null) {
            aVar.c();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
        ImageView imageView = this.f19798b;
        if (imageView != null) {
            imageView.setOnClickListener(new q(this));
        }
        ImageView imageView2 = this.f19799c;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new id.r(this));
        }
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R$layout.im_layout_live_gift_rule_pop;
    }

    public int getGravity() {
        return 80;
    }

    /* JADX WARNING: type inference failed for: r4v2, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView(i6.r r4) {
        /*
            r3 = this;
            android.os.Bundle r0 = r3.getArguments()
            r1 = 0
            if (r0 == 0) goto L_0x000e
            java.lang.String r2 = "live_gift_rule_text"
            java.lang.String r0 = r0.getString(r2)
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            if (r4 == 0) goto L_0x001a
            int r2 = com.hbg.module.huobi.im.R$id.ivLiveGiftRuleBack
            android.view.View r2 = r4.b(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            goto L_0x001b
        L_0x001a:
            r2 = r1
        L_0x001b:
            r3.f19798b = r2
            if (r4 == 0) goto L_0x0028
            int r2 = com.hbg.module.huobi.im.R$id.tvLiveGiftRuleContent
            android.view.View r2 = r4.b(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            goto L_0x0029
        L_0x0028:
            r2 = r1
        L_0x0029:
            r3.f19800d = r2
            if (r4 == 0) goto L_0x0036
            int r1 = com.hbg.module.huobi.im.R$id.ivLiveGiftRuleClose
            android.view.View r4 = r4.b(r1)
            r1 = r4
            android.widget.ImageView r1 = (android.widget.ImageView) r1
        L_0x0036:
            r3.f19799c = r1
            android.widget.TextView r4 = r3.f19800d
            if (r4 != 0) goto L_0x003d
            goto L_0x0040
        L_0x003d:
            r4.setText(r0)
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.gift.ui.LiveGiftRuleDialog.initView(i6.r):void");
    }

    public boolean isTransparent() {
        return true;
    }

    public final void wh(a aVar) {
        this.f19801e = aVar;
    }
}
