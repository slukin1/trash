package com.huobi.otc.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.enums.OtcTradeAreaEnum;
import java.util.concurrent.TimeUnit;
import vp.o0;

public class OtcTradeBottomTab extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public String[] f80089b = {getResources().getString(R$string.n_otc_p2p), getResources().getString(R$string.n_otc_advert_opt_tabbar_order_tip), getResources().getString(R$string.n_otc_advert_opt_tabbar_ad_tip), getResources().getString(R$string.n_tab_me)};

    /* renamed from: c  reason: collision with root package name */
    public Drawable[] f80090c;

    /* renamed from: d  reason: collision with root package name */
    public a f80091d;

    /* renamed from: e  reason: collision with root package name */
    public int f80092e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f80093f = -1;

    public interface a {
        void m9(OtcTradeAreaEnum otcTradeAreaEnum);
    }

    public OtcTradeBottomTab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(int i11, Void voidR) {
        if (this.f80091d != null) {
            this.f80091d.m9(b(i11));
        }
    }

    private Drawable[] getDrawables() {
        if (NightHelper.e().g()) {
            return new Drawable[]{ResourcesCompat.f(getResources(), R$drawable.select_otc_bottom_exchange_bg_night, getContext().getTheme()), ResourcesCompat.f(getResources(), R$drawable.select_otc_bottom_order_bg_night, getContext().getTheme()), ResourcesCompat.f(getResources(), R$drawable.select_otc_bottom_ad_bg_night, getContext().getTheme()), ResourcesCompat.f(getResources(), R$drawable.select_otc_bottom_mine_bg_night, getContext().getTheme())};
        }
        return new Drawable[]{ResourcesCompat.f(getResources(), R$drawable.select_otc_bottom_exchange_bg, getContext().getTheme()), ResourcesCompat.f(getResources(), R$drawable.select_otc_bottom_order_bg, getContext().getTheme()), ResourcesCompat.f(getResources(), R$drawable.select_otc_bottom_ad_bg, getContext().getTheme()), ResourcesCompat.f(getResources(), R$drawable.select_otc_bottom_mine_bg, getContext().getTheme())};
    }

    public final OtcTradeAreaEnum b(int i11) {
        if (i11 == 0) {
            return OtcTradeAreaEnum.P2P_TRAD_AREA;
        }
        if (i11 == 1) {
            return OtcTradeAreaEnum.ORDER_AREA;
        }
        if (i11 == 2) {
            return OtcTradeAreaEnum.AD_AREA;
        }
        return OtcTradeAreaEnum.MINE;
    }

    public void c(Context context) {
        View.inflate(context, R$layout.otc_trade_bottom_tab_layout, this);
        this.f80090c = getDrawables();
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.ll_root);
        for (int i11 = 0; i11 < linearLayout.getChildCount(); i11++) {
            RelativeLayout relativeLayout = (RelativeLayout) linearLayout.getChildAt(i11);
            Drawable[] drawableArr = this.f80090c;
            TransitionDrawable transitionDrawable = (TransitionDrawable) drawableArr[i11 % drawableArr.length];
            transitionDrawable.setCrossFadeEnabled(true);
            ((ImageView) relativeLayout.findViewById(R$id.f29450iv)).setImageDrawable(transitionDrawable);
            String[] strArr = this.f80089b;
            ((TextView) relativeLayout.findViewById(R$id.f29452tv)).setText(strArr[i11 % strArr.length]);
            dw.a.a(relativeLayout).throttleFirst(1, TimeUnit.SECONDS).subscribe(new o0(this, i11));
        }
        e(0, 0);
    }

    public final void e(int i11, int i12) {
        int i13 = this.f80092e;
        if (i13 != i11) {
            this.f80093f = i13;
            this.f80092e = i11;
            LinearLayout linearLayout = (LinearLayout) findViewById(R$id.ll_root);
            int i14 = 0;
            while (i14 < linearLayout.getChildCount()) {
                RelativeLayout relativeLayout = (RelativeLayout) linearLayout.getChildAt(i14);
                TextView textView = (TextView) relativeLayout.findViewById(R$id.f29452tv);
                Drawable drawable = ((ImageView) relativeLayout.findViewById(R$id.f29450iv)).getDrawable();
                if (drawable instanceof TransitionDrawable) {
                    if (i11 == i14) {
                        TransitionDrawable transitionDrawable = (TransitionDrawable) drawable;
                        transitionDrawable.resetTransition();
                        transitionDrawable.startTransition(i12);
                    } else if (this.f80093f == i14) {
                        TransitionDrawable transitionDrawable2 = (TransitionDrawable) drawable;
                        transitionDrawable2.resetTransition();
                        transitionDrawable2.reverseTransition(i12);
                    }
                }
                textView.setSelected(i11 == i14);
                i14++;
            }
        }
    }

    public int getAdViewX() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.ll_root);
        View childAt = linearLayout.getChildAt(linearLayout.getChildCount() - 1);
        int measuredWidth = linearLayout.getMeasuredWidth();
        if (measuredWidth == 0) {
            return 0;
        }
        return ((measuredWidth - linearLayout.getPaddingLeft()) - ((((measuredWidth - linearLayout.getPaddingLeft()) - linearLayout.getPaddingRight()) / 3) * 2)) + (childAt.getMeasuredWidth() / 2);
    }

    public void setChatUnReadNum(int i11) {
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.ll_root);
        if (linearLayout.getChildCount() > 1) {
            View findViewById = ((RelativeLayout) linearLayout.getChildAt(1)).findViewById(R$id.tv_bottom_trade_order_num);
            if (i11 > 0) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
        }
    }

    public void setOnBottomTabClickListener(a aVar) {
        this.f80091d = aVar;
    }

    public void setTabSelected(OtcTradeAreaEnum otcTradeAreaEnum) {
        e(otcTradeAreaEnum.getCode(), 200);
    }
}
