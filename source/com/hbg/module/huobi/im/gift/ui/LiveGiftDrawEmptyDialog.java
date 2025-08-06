package com.hbg.module.huobi.im.gift.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.huobi.im.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import id.f;
import id.g;

public final class LiveGiftDrawEmptyDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public TextView f19765b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f19766c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19767d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19768e;

    /* renamed from: f  reason: collision with root package name */
    public a f19769f;

    public interface a {
        void a();
    }

    @SensorsDataInstrumented
    public static final void uh(LiveGiftDrawEmptyDialog liveGiftDrawEmptyDialog, View view) {
        liveGiftDrawEmptyDialog.dismiss();
        a aVar = liveGiftDrawEmptyDialog.f19769f;
        if (aVar != null) {
            aVar.a();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void vh(LiveGiftDrawEmptyDialog liveGiftDrawEmptyDialog, View view) {
        liveGiftDrawEmptyDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
        TextView textView = this.f19765b;
        if (textView != null) {
            textView.setOnClickListener(new g(this));
        }
        ImageView imageView = this.f19766c;
        if (imageView != null) {
            imageView.setOnClickListener(new f(this));
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

    /* JADX WARNING: type inference failed for: r3v1, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView(i6.r r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L_0x000c
            int r1 = com.hbg.module.huobi.im.R$id.tvLiveGiftBoxEmptyBtn
            android.view.View r1 = r3.b(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x000d
        L_0x000c:
            r1 = r0
        L_0x000d:
            r2.f19765b = r1
            if (r3 == 0) goto L_0x001a
            int r1 = com.hbg.module.huobi.im.R$id.ivLiveGiftEmptyClose
            android.view.View r1 = r3.b(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            goto L_0x001b
        L_0x001a:
            r1 = r0
        L_0x001b:
            r2.f19766c = r1
            if (r3 == 0) goto L_0x0028
            int r1 = com.hbg.module.huobi.im.R$id.tvLiveGiftEmptyTitle
            android.view.View r1 = r3.b(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x0029
        L_0x0028:
            r1 = r0
        L_0x0029:
            r2.f19767d = r1
            if (r3 == 0) goto L_0x0036
            int r0 = com.hbg.module.huobi.im.R$id.tvLiveGiftEmptyMsg
            android.view.View r3 = r3.b(r0)
            r0 = r3
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x0036:
            r2.f19768e = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.gift.ui.LiveGiftDrawEmptyDialog.initView(i6.r):void");
    }

    public boolean isTransparent() {
        return true;
    }

    public final void wh(a aVar) {
        this.f19769f = aVar;
    }
}
