package com.huobi.otc.dialog;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.AutoSizeTextView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dp.a;
import dp.b;
import dp.c;
import dp.d;
import i6.r;
import java.util.concurrent.TimeUnit;
import rx.Observable;

public abstract class BaseOtcOrderCancelDialogFragment extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public TextView f78270b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f78271c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f78272d;

    /* renamed from: e  reason: collision with root package name */
    public AutoSizeTextView f78273e;

    /* renamed from: f  reason: collision with root package name */
    public AutoSizeTextView f78274f;

    /* renamed from: g  reason: collision with root package name */
    public View f78275g;

    /* access modifiers changed from: private */
    public /* synthetic */ void Ah(Void voidR) {
        dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Bh(Void voidR) {
        Fh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ch(Void voidR) {
        Dh();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public abstract void Dh();

    public abstract void Eh();

    public abstract void Fh();

    public void Gh(boolean z11) {
        ViewUtil.m(this.f78273e, z11);
    }

    public void Hh(boolean z11) {
        this.f78274f.setEnabled(z11);
    }

    public void Ih(boolean z11) {
        ViewUtil.n(this.f78275g, z11);
    }

    public void addEvent(r rVar) {
        this.f78271c.setOnClickListener(new a(this));
        Observable<Void> a11 = dw.a.a(this.f78271c);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(500, timeUnit).subscribe(new d(this));
        dw.a.a(this.f78274f).throttleFirst(500, timeUnit).subscribe(new c(this));
        dw.a.a(this.f78273e).throttleFirst(500, timeUnit).subscribe(new b(this));
    }

    public void afterInit() {
        this.f78270b.setText(yh());
        this.f78273e.setText(wh());
        this.f78274f.setText(xh());
    }

    public abstract View getContentView();

    public int getContentViewResId() {
        return R$layout.dialog_fragment_base_order_cancel_layout;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f78270b = (TextView) rVar.b(R$id.id_title_tv);
        this.f78271c = (ImageView) rVar.b(R$id.id_close_iv);
        this.f78272d = (FrameLayout) rVar.b(R$id.id_content_container_view);
        this.f78273e = (AutoSizeTextView) rVar.b(R$id.id_cancel_tv);
        this.f78274f = (AutoSizeTextView) rVar.b(R$id.id_confirm_tv);
        this.f78275g = rVar.b(R$id.id_top_line);
        View contentView = getContentView();
        if (contentView != null) {
            this.f78272d.addView(contentView);
        }
        zh(rVar);
        Eh();
    }

    public boolean isFullScreen() {
        return true;
    }

    public boolean isTransparent() {
        return true;
    }

    public boolean useWindowBg() {
        return false;
    }

    public abstract String wh();

    public abstract String xh();

    public abstract String yh();

    public abstract void zh(r rVar);
}
