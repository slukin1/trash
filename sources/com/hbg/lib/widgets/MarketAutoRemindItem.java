package com.hbg.lib.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.wtree.helper.Utils;
import f6.c;

public class MarketAutoRemindItem extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public View f71513b;

    /* renamed from: c  reason: collision with root package name */
    public View f71514c;

    /* renamed from: d  reason: collision with root package name */
    public View f71515d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f71516e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f71517f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f71518g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f71519h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f71520i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f71521j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f71522k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f71523l;

    /* renamed from: m  reason: collision with root package name */
    public View f71524m;

    public MarketAutoRemindItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public final void a(Context context) {
        LayoutInflater.from(context).inflate(R$layout.item_flash_news_item, this, true);
        this.f71513b = findViewById(R$id.linear_layout_market_remind_header);
        this.f71514c = findViewById(R$id.view_market_remind_top_line);
        this.f71515d = findViewById(R$id.view_market_remind_top_line_2);
        this.f71516e = (TextView) findViewById(R$id.text_view_market_remind_date);
        this.f71517f = (TextView) findViewById(R$id.text_view_market_remind_time);
        this.f71518g = (TextView) findViewById(R$id.text_view_market_remind_coin);
        this.f71519h = (TextView) findViewById(R$id.text_view_market_remind_info);
        this.f71520i = (TextView) findViewById(R$id.text_view_market_remind_title);
        this.f71521j = (TextView) findViewById(R$id.text_view_market_remind_content);
        this.f71522k = (ImageView) findViewById(R$id.image_view_market_remind_coin);
        this.f71523l = (TextView) findViewById(R$id.text_view_market_remind_protocol);
        this.f71524m = findViewById(R$id.view_market_remind_bottom_line);
    }

    public void b(boolean z11, String str, boolean z12, View.OnClickListener onClickListener) {
        ViewUtil.m(this.f71513b, z11);
        ViewUtil.m(this.f71524m, !z11);
        ViewUtil.n(this.f71514c, !z11);
        ViewUtil.m(this.f71515d, !z11);
        this.f71516e.setText(str);
        ViewUtil.m(this.f71523l, z12);
        if (z12) {
            this.f71523l.setOnClickListener(onClickListener);
        }
    }

    public void c(String str, int i11) {
        c.a().l(getContext(), str, this.f71522k, i11);
    }

    public void d(int i11, String str) {
        int i12;
        int i13;
        if (i11 == 2) {
            i12 = getResources().getColor(R$color.base_down_color);
            i13 = R$drawable.bg_newer_market_down;
        } else {
            i12 = getResources().getColor(R$color.base_up_color);
            i13 = R$drawable.bg_newer_market_up;
        }
        this.f71519h.setText(str);
        this.f71519h.setTextColor(i12);
        this.f71519h.setBackgroundResource(i13);
        TextView textView = this.f71519h;
        int i14 = R$dimen.dimen_5;
        textView.setPadding(Utils.b(i14), 0, Utils.b(i14), 0);
    }

    public void setCoin(String str) {
        this.f71518g.setText(str);
    }

    public void setContent(String str) {
        this.f71521j.setText(str);
    }

    public void setShowTime(String str) {
        this.f71517f.setText(str);
    }

    public void setTitle(String str) {
        this.f71520i.setText(str);
    }

    public MarketAutoRemindItem(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
