package com.hbg.module.huobi.im.gift.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.huobi.im.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import id.h;
import id.i;

public final class LiveGiftDrawErrorDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public TextView f19770b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f19771c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19772d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19773e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f19774f;

    /* renamed from: g  reason: collision with root package name */
    public a f19775g;

    public interface a {
        void a();

        void onCloseClick();
    }

    @SensorsDataInstrumented
    public static final void uh(LiveGiftDrawErrorDialog liveGiftDrawErrorDialog, View view) {
        a aVar = liveGiftDrawErrorDialog.f19775g;
        if (aVar != null) {
            aVar.a();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void vh(LiveGiftDrawErrorDialog liveGiftDrawErrorDialog, View view) {
        a aVar = liveGiftDrawErrorDialog.f19775g;
        if (aVar != null) {
            aVar.onCloseClick();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
        TextView textView = this.f19770b;
        if (textView != null) {
            textView.setOnClickListener(new h(this));
        }
        ImageView imageView = this.f19771c;
        if (imageView != null) {
            imageView.setOnClickListener(new i(this));
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

    /* JADX WARNING: type inference failed for: r3v5, types: [android.view.View] */
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
            r2.f19770b = r1
            if (r3 == 0) goto L_0x001a
            int r1 = com.hbg.module.huobi.im.R$id.ivLiveGiftEmptyClose
            android.view.View r1 = r3.b(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            goto L_0x001b
        L_0x001a:
            r1 = r0
        L_0x001b:
            r2.f19771c = r1
            if (r3 == 0) goto L_0x0028
            int r1 = com.hbg.module.huobi.im.R$id.tvLiveGiftEmptyTitle
            android.view.View r1 = r3.b(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x0029
        L_0x0028:
            r1 = r0
        L_0x0029:
            r2.f19772d = r1
            if (r3 == 0) goto L_0x0036
            int r1 = com.hbg.module.huobi.im.R$id.tvLiveGiftEmptyMsg
            android.view.View r1 = r3.b(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x0037
        L_0x0036:
            r1 = r0
        L_0x0037:
            r2.f19773e = r1
            if (r3 == 0) goto L_0x0044
            int r0 = com.hbg.module.huobi.im.R$id.ivLiveGiftEmptyTop
            android.view.View r3 = r3.b(r0)
            r0 = r3
            android.widget.ImageView r0 = (android.widget.ImageView) r0
        L_0x0044:
            r2.f19774f = r0
            if (r0 == 0) goto L_0x004d
            int r3 = com.hbg.module.huobi.im.R$drawable.im_icon_gift_error
            r0.setImageResource(r3)
        L_0x004d:
            android.widget.TextView r3 = r2.f19772d
            if (r3 != 0) goto L_0x0052
            goto L_0x005f
        L_0x0052:
            androidx.fragment.app.FragmentActivity r0 = r2.requireActivity()
            int r1 = com.hbg.module.huobi.im.R$string.n_content_live_get_gift_error
            java.lang.String r0 = r0.getString(r1)
            r3.setText(r0)
        L_0x005f:
            android.widget.TextView r3 = r2.f19773e
            if (r3 != 0) goto L_0x0064
            goto L_0x0071
        L_0x0064:
            androidx.fragment.app.FragmentActivity r0 = r2.requireActivity()
            int r1 = com.hbg.module.huobi.im.R$string.n_content_live_get_gift_error_message
            java.lang.String r0 = r0.getString(r1)
            r3.setText(r0)
        L_0x0071:
            android.widget.TextView r3 = r2.f19770b
            if (r3 != 0) goto L_0x0076
            goto L_0x0083
        L_0x0076:
            androidx.fragment.app.FragmentActivity r0 = r2.requireActivity()
            int r1 = com.hbg.module.huobi.im.R$string.n_otc_go_try_again
            java.lang.String r0 = r0.getString(r1)
            r3.setText(r0)
        L_0x0083:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.gift.ui.LiveGiftDrawErrorDialog.initView(i6.r):void");
    }

    public boolean isTransparent() {
        return true;
    }

    public final void wh(a aVar) {
        this.f19775g = aVar;
    }
}
