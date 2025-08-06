package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import net.lucode.hackware.magicindicator.buildins.UIUtil;

public class OtcOrderProgressView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f80020b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f80021c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f80022d;

    /* renamed from: e  reason: collision with root package name */
    public View f80023e;

    /* renamed from: f  reason: collision with root package name */
    public View f80024f;

    /* renamed from: g  reason: collision with root package name */
    public View f80025g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f80026h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f80027i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f80028j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f80029k;

    public OtcOrderProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void setPointSelected(int i11) {
        int a11 = UIUtil.a(getContext(), 9.0d);
        int a12 = UIUtil.a(getContext(), 7.0d);
        if (i11 == 0) {
            b(this.f80026h, a11);
            this.f80026h.setSelected(true);
            b(this.f80027i, a12);
            this.f80027i.setSelected(false);
            b(this.f80028j, a12);
            this.f80028j.setSelected(false);
            b(this.f80029k, a12);
            this.f80029k.setSelected(false);
            this.f80029k.setImageResource(R$drawable.select_otc_point_bg);
        } else if (i11 == 1) {
            b(this.f80026h, a12);
            this.f80026h.setSelected(true);
            b(this.f80027i, a11);
            this.f80027i.setSelected(true);
            b(this.f80028j, a12);
            this.f80028j.setSelected(false);
            b(this.f80029k, a12);
            this.f80029k.setSelected(false);
            this.f80029k.setImageResource(R$drawable.select_otc_point_bg);
        } else if (i11 == 2) {
            b(this.f80026h, a12);
            this.f80026h.setSelected(true);
            b(this.f80027i, a12);
            this.f80027i.setSelected(true);
            b(this.f80028j, a11);
            this.f80028j.setSelected(true);
            b(this.f80029k, a12);
            this.f80029k.setSelected(false);
            this.f80029k.setImageResource(R$drawable.select_otc_point_bg);
        } else if (i11 == 3) {
            b(this.f80026h, a12);
            this.f80026h.setSelected(true);
            b(this.f80027i, a12);
            this.f80027i.setSelected(true);
            b(this.f80028j, a12);
            this.f80028j.setSelected(true);
            b(this.f80029k, UIUtil.a(getContext(), 16.0d));
            this.f80029k.setSelected(true);
            this.f80029k.setImageResource(R$drawable.otc_trade_progress_finish_icon);
        }
    }

    private void setProgressSelected(int i11) {
        if (i11 == 0) {
            this.f80023e.setSelected(false);
            this.f80024f.setSelected(false);
            this.f80025g.setSelected(false);
        } else if (i11 == 1) {
            this.f80023e.setSelected(true);
            this.f80024f.setSelected(false);
            this.f80025g.setSelected(false);
        } else if (i11 == 2) {
            this.f80023e.setSelected(true);
            this.f80024f.setSelected(true);
            this.f80025g.setSelected(false);
        } else if (i11 == 3) {
            this.f80023e.setSelected(true);
            this.f80024f.setSelected(true);
            this.f80025g.setSelected(true);
        }
    }

    private void setTvSelected(int i11) {
        if (i11 == 0) {
            this.f80020b.setSelected(true);
            this.f80021c.setSelected(false);
            this.f80022d.setSelected(false);
        } else if (i11 == 1) {
            this.f80020b.setSelected(true);
            this.f80021c.setSelected(true);
            this.f80022d.setSelected(false);
        } else if (i11 == 2) {
            this.f80020b.setSelected(true);
            this.f80021c.setSelected(true);
            this.f80022d.setSelected(true);
        } else if (i11 == 3) {
            this.f80020b.setSelected(true);
            this.f80021c.setSelected(true);
            this.f80022d.setSelected(true);
        }
    }

    public void a(Context context) {
        View.inflate(context, R$layout.otc_order_progress_view, this);
        this.f80020b = (TextView) findViewById(R$id.tv_one);
        this.f80021c = (TextView) findViewById(R$id.tv_tow);
        this.f80022d = (TextView) findViewById(R$id.tv_three);
        this.f80023e = findViewById(R$id.view_progress_one);
        this.f80024f = findViewById(R$id.view_progress_tow);
        this.f80025g = findViewById(R$id.view_progress_three);
        this.f80026h = (ImageView) findViewById(R$id.view_point_one);
        this.f80027i = (ImageView) findViewById(R$id.view_point_tow);
        this.f80028j = (ImageView) findViewById(R$id.view_point_three);
        this.f80029k = (ImageView) findViewById(R$id.view_point_four);
    }

    public final void b(View view, int i11) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams.width != i11 || layoutParams.height != i11) {
            layoutParams.width = i11;
            layoutParams.height = i11;
            view.setLayoutParams(layoutParams);
        }
    }

    public void setCurrentProgress(int i11) {
        if (i11 == 0) {
            setTvSelected(0);
            setProgressSelected(0);
            setPointSelected(0);
        } else if (i11 == 1) {
            setTvSelected(1);
            setProgressSelected(1);
            setPointSelected(1);
        } else if (i11 == 2) {
            setTvSelected(2);
            setProgressSelected(2);
            setPointSelected(2);
        } else if (i11 == 3) {
            setTvSelected(3);
            setProgressSelected(3);
            setPointSelected(3);
        }
    }
}
