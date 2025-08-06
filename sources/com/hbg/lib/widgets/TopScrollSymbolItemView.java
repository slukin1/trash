package com.hbg.lib.widgets;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.widgets.TopScrollSymbolData;
import i6.d;
import java.util.List;

public class TopScrollSymbolItemView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f71668b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f71669c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f71670d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f71671e;

    /* renamed from: f  reason: collision with root package name */
    public int f71672f;

    /* renamed from: g  reason: collision with root package name */
    public ObjectAnimator f71673g;

    /* renamed from: h  reason: collision with root package name */
    public final Interpolator f71674h;

    public TopScrollSymbolItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        if (this.f71672f == 1) {
            d.b("TopScrollSymbolItemView-->continueAnim-->-->-->滑出去了");
            this.f71672f = 2;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, LinearLayout.TRANSLATION_Y, new float[]{0.0f, (float) (-getHeight())});
            this.f71673g = ofFloat;
            ofFloat.setInterpolator(this.f71674h);
            this.f71673g.setDuration(500);
            this.f71673g.start();
            return;
        }
        d.b("TopScrollSymbolItemView-->continueAnim-->-->-->没动");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f() {
        this.f71672f = 1;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, LinearLayout.TRANSLATION_Y, new float[]{(float) getHeight(), 0.0f});
        this.f71673g = ofFloat;
        ofFloat.setInterpolator(this.f71674h);
        this.f71673g.setDuration(500);
        this.f71673g.start();
    }

    public void c() {
        post(new r1(this));
    }

    public final void d(Context context) {
        LinearLayout.inflate(context, R$layout.view_scroll_symbol_item_view, this);
        this.f71668b = (ViewGroup) findViewById(R$id.id_search_scroll_symbol_group_left);
        this.f71669c = (ViewGroup) findViewById(R$id.id_search_scroll_symbol_group_center);
        this.f71670d = (ViewGroup) findViewById(R$id.id_search_scroll_symbol_group_right);
        this.f71671e = (ImageView) findViewById(R$id.left_icon_iv);
    }

    public void g() {
        ObjectAnimator objectAnimator = this.f71673g;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f71673g.cancel();
        }
        for (int i11 = 0; i11 <= 3; i11++) {
            if (i11 == 0) {
                this.f71668b.setOnClickListener((View.OnClickListener) null);
                ((TextView) this.f71668b.findViewById(R$id.id_search_scroll_pair_text_left)).setVisibility(4);
                ((TextView) this.f71668b.findViewById(R$id.id_search_scroll_pair_text_slash)).setVisibility(4);
                ((TextView) this.f71668b.findViewById(R$id.id_search_scroll_pair_text_right)).setVisibility(4);
            } else if (1 == i11) {
                this.f71669c.setOnClickListener((View.OnClickListener) null);
                ((TextView) this.f71669c.findViewById(R$id.id_search_scroll_pair_text_left)).setVisibility(4);
                ((TextView) this.f71669c.findViewById(R$id.id_search_scroll_pair_text_slash)).setVisibility(4);
                ((TextView) this.f71669c.findViewById(R$id.id_search_scroll_pair_text_right)).setVisibility(4);
            } else if (2 == i11) {
                this.f71670d.setOnClickListener((View.OnClickListener) null);
                ((TextView) this.f71670d.findViewById(R$id.id_search_scroll_pair_text_left)).setVisibility(4);
                ((TextView) this.f71670d.findViewById(R$id.id_search_scroll_pair_text_slash)).setVisibility(4);
                ((TextView) this.f71670d.findViewById(R$id.id_search_scroll_pair_text_right)).setVisibility(4);
            }
        }
        this.f71672f = 0;
    }

    public void h(List<TopScrollSymbolData> list) {
        if (list == null || list.isEmpty()) {
            g();
            return;
        }
        setData(list);
        post(new s1(this));
    }

    public void setData(List<TopScrollSymbolData> list) {
        for (int i11 = 0; i11 < list.size() && list.size() <= 3; i11++) {
            if (list.get(i11).c() == TopScrollSymbolData.HEAD_TYPE.HOT_BUY) {
                this.f71671e.setImageResource(R$drawable.search_scroll_view_buy);
            } else if (list.get(i11).c() == TopScrollSymbolData.HEAD_TYPE.HOT_SEARCH) {
                this.f71671e.setImageResource(R$drawable.search_scroll_view_search);
            } else if (list.get(i11).c() == TopScrollSymbolData.HEAD_TYPE.HOT_CURRENCY) {
                this.f71671e.setImageResource(R$drawable.search_scroll_view_new);
            }
            int i12 = 4;
            if (i11 == 0) {
                TextView textView = (TextView) this.f71668b.findViewById(R$id.id_search_scroll_pair_text_left);
                TextView textView2 = (TextView) this.f71668b.findViewById(R$id.id_search_scroll_pair_text_right);
                TextView textView3 = (TextView) this.f71668b.findViewById(R$id.id_search_scroll_pair_text_slash);
                this.f71668b.setTag(list.get(i11));
                this.f71668b.setOnClickListener(list.get(i11).e());
                textView.setText(list.get(i11).g());
                textView2.setText(list.get(i11).h());
                textView.setVisibility(list.get(i11).g().isEmpty() ? 4 : 0);
                textView3.setVisibility(list.get(i11).h().isEmpty() ? 4 : 0);
                if (!list.get(i11).h().isEmpty()) {
                    i12 = 0;
                }
                textView2.setVisibility(i12);
            } else if (1 == i11) {
                TextView textView4 = (TextView) this.f71669c.findViewById(R$id.id_search_scroll_pair_text_left);
                TextView textView5 = (TextView) this.f71669c.findViewById(R$id.id_search_scroll_pair_text_right);
                TextView textView6 = (TextView) this.f71669c.findViewById(R$id.id_search_scroll_pair_text_slash);
                TextView textView7 = (TextView) this.f71669c.findViewById(R$id.id_search_scroll_pair_text_line);
                this.f71669c.setTag(list.get(i11));
                this.f71669c.setOnClickListener(list.get(i11).e());
                textView4.setText(list.get(i11).g());
                textView5.setText(list.get(i11).h());
                textView4.setVisibility(list.get(i11).g().isEmpty() ? 4 : 0);
                textView6.setVisibility(list.get(i11).h().isEmpty() ? 4 : 0);
                textView5.setVisibility(list.get(i11).h().isEmpty() ? 4 : 0);
                if (!list.get(i11).h().isEmpty()) {
                    i12 = 0;
                }
                textView7.setVisibility(i12);
            } else if (2 == i11) {
                TextView textView8 = (TextView) this.f71670d.findViewById(R$id.id_search_scroll_pair_text_left);
                TextView textView9 = (TextView) this.f71670d.findViewById(R$id.id_search_scroll_pair_text_right);
                TextView textView10 = (TextView) this.f71670d.findViewById(R$id.id_search_scroll_pair_text_slash);
                TextView textView11 = (TextView) this.f71670d.findViewById(R$id.id_search_scroll_pair_text_line);
                this.f71670d.setTag(list.get(i11));
                this.f71670d.setOnClickListener(list.get(i11).e());
                textView8.setText(list.get(i11).g());
                textView9.setText(list.get(i11).h());
                textView8.setVisibility(list.get(i11).g().isEmpty() ? 4 : 0);
                textView10.setVisibility(list.get(i11).h().isEmpty() ? 4 : 0);
                textView9.setVisibility(list.get(i11).h().isEmpty() ? 4 : 0);
                if (!list.get(i11).h().isEmpty()) {
                    i12 = 0;
                }
                textView11.setVisibility(i12);
            }
        }
    }

    public TopScrollSymbolItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71672f = 0;
        this.f71674h = new DecelerateInterpolator();
        d(context);
    }
}
