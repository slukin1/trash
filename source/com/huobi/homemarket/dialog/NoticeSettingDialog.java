package com.huobi.homemarket.dialog;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.market.R$color;
import com.hbg.module.market.R$drawable;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.d;
import i6.n;
import i6.r;
import ol.c;

public class NoticeSettingDialog extends BaseDialogFragment implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f72682b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f72683c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f72684d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f72685e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f72686f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f72687g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f72688h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f72689i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f72690j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f72691k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f72692l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f72693m;

    /* renamed from: n  reason: collision with root package name */
    public ImageView f72694n;

    /* renamed from: o  reason: collision with root package name */
    public ImageView f72695o;

    /* renamed from: p  reason: collision with root package name */
    public ImageView f72696p;

    /* renamed from: q  reason: collision with root package name */
    public ImageView f72697q;

    /* renamed from: r  reason: collision with root package name */
    public ImageView f72698r;

    /* renamed from: s  reason: collision with root package name */
    public LinearLayout f72699s;

    /* renamed from: t  reason: collision with root package name */
    public Rect f72700t;

    public static /* synthetic */ boolean lambda$addEvent$0(View view, MotionEvent motionEvent) {
        return true;
    }

    public void addEvent(r rVar) {
        this.f72682b.setOnClickListener(this);
        this.f72683c.setOnClickListener(this);
        this.f72684d.setOnClickListener(this);
        this.f72685e.setOnClickListener(this);
        this.f72686f.setOnClickListener(this);
        this.f72692l.setOnClickListener(this);
        this.f72693m.setOnClickListener(this);
        rVar.b(R$id.root_view).setOnClickListener(this);
        this.f72699s.setOnTouchListener(c.f58876b);
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R$layout.dialog_notice_setting;
    }

    public int getGravity() {
        return 8388611;
    }

    public void initView(r rVar) {
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.f72682b = (RelativeLayout) rVar.b(R$id.rl_new_coin);
        this.f72683c = (RelativeLayout) rVar.b(R$id.rl_project);
        this.f72684d = (RelativeLayout) rVar.b(R$id.rl_new_event);
        this.f72685e = (RelativeLayout) rVar.b(R$id.rl_live);
        this.f72686f = (RelativeLayout) rVar.b(R$id.rl_fast_news);
        this.f72687g = (TextView) rVar.b(R$id.tv_new_coin);
        this.f72688h = (TextView) rVar.b(R$id.tv_project);
        this.f72689i = (TextView) rVar.b(R$id.tv_new_event);
        this.f72690j = (TextView) rVar.b(R$id.tv_live);
        this.f72691k = (TextView) rVar.b(R$id.tv_fast_news);
        this.f72692l = (TextView) rVar.b(R$id.tv_reset);
        this.f72693m = (TextView) rVar.b(R$id.tv_confirm);
        this.f72694n = (ImageView) rVar.b(R$id.iv_select_new_coin);
        this.f72695o = (ImageView) rVar.b(R$id.iv_select_project);
        this.f72696p = (ImageView) rVar.b(R$id.iv_select_new_event);
        this.f72697q = (ImageView) rVar.b(R$id.iv_select_live);
        this.f72698r = (ImageView) rVar.b(R$id.iv_select_fase_news);
        this.f72699s = (LinearLayout) rVar.b(R$id.ll_content);
    }

    public boolean isFullScreen() {
        return true;
    }

    public boolean isTransparent() {
        return true;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R$id.rl_new_coin) {
            RelativeLayout relativeLayout = this.f72682b;
            relativeLayout.setSelected(!relativeLayout.isSelected());
            th(this.f72682b.isSelected(), this.f72682b, this.f72694n, this.f72687g);
        } else if (view.getId() == R$id.rl_project) {
            RelativeLayout relativeLayout2 = this.f72683c;
            relativeLayout2.setSelected(!relativeLayout2.isSelected());
            th(this.f72683c.isSelected(), this.f72683c, this.f72695o, this.f72688h);
        } else if (view.getId() == R$id.rl_new_event) {
            RelativeLayout relativeLayout3 = this.f72684d;
            relativeLayout3.setSelected(!relativeLayout3.isSelected());
            th(this.f72684d.isSelected(), this.f72684d, this.f72696p, this.f72689i);
        } else if (view.getId() == R$id.rl_live) {
            RelativeLayout relativeLayout4 = this.f72685e;
            relativeLayout4.setSelected(!relativeLayout4.isSelected());
            th(this.f72685e.isSelected(), this.f72685e, this.f72697q, this.f72690j);
        } else if (view.getId() == R$id.rl_fast_news) {
            RelativeLayout relativeLayout5 = this.f72686f;
            relativeLayout5.setSelected(!relativeLayout5.isSelected());
            th(this.f72686f.isSelected(), this.f72686f, this.f72698r, this.f72691k);
        } else if (view.getId() == R$id.tv_reset) {
            reset();
        } else if (view.getId() == R$id.tv_confirm) {
            Toast.makeText(getActivity(), "稍后添加~~~", 0).show();
        } else if (view.getId() == R$id.root_view) {
            dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onResume() {
        super.onResume();
        if (this.f72700t != null) {
            d.i("testnotice:     bottom:" + this.f72700t.bottom);
            ((FrameLayout.LayoutParams) this.viewFinder.b(R$id.parent_view).getLayoutParams()).topMargin = this.f72700t.bottom - n.h(getContext());
        }
    }

    public void onStart() {
        super.onStart();
        setStatusBarColorIfPossible(0);
    }

    public final void reset() {
        Drawable drawable = ContextCompat.getDrawable(getContext(), R$drawable.bg_notice_dialog_item_unselect);
        this.f72682b.setBackground(drawable);
        this.f72683c.setBackground(drawable);
        this.f72684d.setBackground(drawable);
        this.f72685e.setBackground(drawable);
        this.f72682b.setBackground(drawable);
        this.f72694n.setVisibility(8);
        this.f72695o.setVisibility(8);
        this.f72696p.setVisibility(8);
        this.f72697q.setVisibility(8);
        this.f72698r.setVisibility(8);
    }

    public final void th(boolean z11, RelativeLayout relativeLayout, ImageView imageView, TextView textView) {
        if (z11) {
            relativeLayout.setBackground(ContextCompat.getDrawable(getContext(), R$drawable.bg_notice_dialog_item_select));
            imageView.setVisibility(0);
            textView.setTextColor(ContextCompat.getColor(getContext(), R$color.color_0066ed));
            return;
        }
        relativeLayout.setBackground(ContextCompat.getDrawable(getContext(), R$drawable.bg_notice_dialog_item_unselect));
        imageView.setVisibility(8);
        textView.setTextColor(ContextCompat.getColor(getContext(), R$color.baseColorPrimaryText));
    }

    public void uh(Rect rect) {
        this.f72700t = rect;
        d.i("testnotice:   top: " + rect.top + "  bottom: " + rect.bottom + "  right:" + rect.right);
    }
}
