package com.huobi.trade.helper;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.R$color;
import com.hbg.lib.core.R$drawable;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.w;
import com.huobi.view.HeavyBubbleDialog;
import com.huobi.view.HighLightPopup;
import com.huobi.view.drawable.BgColorDrawable;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f82034a;

    /* renamed from: b  reason: collision with root package name */
    public static HeavyBubbleDialog f82035b;

    /* renamed from: c  reason: collision with root package name */
    public static List<HighLightPopup> f82036c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public static List<View> f82037d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public static List<HeavyBubbleDialog> f82038e = new ArrayList();

    public class a implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f82039b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f82040c;

        public a(ViewGroup viewGroup, View view) {
            this.f82039b = viewGroup;
            this.f82040c = view;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f82039b.removeView(this.f82040c);
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public static void c(Activity activity) {
        f82034a = false;
        for (HeavyBubbleDialog dismiss : f82038e) {
            dismiss.dismiss();
        }
        if (activity != null) {
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            for (View removeView : f82037d) {
                viewGroup.removeView(removeView);
            }
        }
        for (HighLightPopup dismiss2 : f82036c) {
            dismiss2.dismiss();
        }
    }

    public static String d(Context context, String str, String str2) {
        String plainString = m.a(str2).abs().toPlainString();
        if ("1".equals(str)) {
            return String.format(Locale.US, context.getString(R$string.n_trade_etp_n_long), new Object[]{plainString});
        } else if (!"2".equals(str)) {
            return "";
        } else {
            return String.format(Locale.US, context.getString(R$string.n_trade_etp_n_short), new Object[]{plainString});
        }
    }

    public static int e(boolean z11, String str) {
        if (!z11) {
            return R$drawable.shape_trade_leverage_bg;
        }
        if ("1".equals(str)) {
            if (w.l()) {
                return R$drawable.shape_trade_etp_leverage_short_bg;
            }
            return R$drawable.shape_trade_etp_leverage_long_bg;
        } else if (w.l()) {
            return R$drawable.shape_trade_etp_leverage_long_bg;
        } else {
            return R$drawable.shape_trade_etp_leverage_short_bg;
        }
    }

    public static int f(boolean z11, boolean z12, String str) {
        if (z12) {
            if ("1".equals(str)) {
                if (w.l()) {
                    return R$drawable.shape_trade_etp_leverage_short_bg;
                }
                return R$drawable.shape_trade_etp_leverage_long_bg;
            } else if (w.l()) {
                return R$drawable.shape_trade_etp_leverage_long_bg;
            } else {
                return R$drawable.shape_trade_etp_leverage_short_bg;
            }
        } else if (z11) {
            return R$drawable.shape_trade_leverage_night_bg;
        } else {
            return R$drawable.shape_trade_leverage_light_bg;
        }
    }

    public static int g(Context context, boolean z11, String str) {
        if (!z11) {
            return ContextCompat.getColor(context, R$color.baseColorMajorTheme100);
        }
        if ("1".equals(str)) {
            if (w.l()) {
                return ContextCompat.getColor(context, R$color.kLineDownColor);
            }
            return ContextCompat.getColor(context, R$color.kLineRaiseColor);
        } else if (w.l()) {
            return ContextCompat.getColor(context, R$color.kLineRaiseColor);
        } else {
            return ContextCompat.getColor(context, R$color.kLineDownColor);
        }
    }

    public static int h(Context context, boolean z11) {
        if (z11) {
            if (w.l()) {
                return ContextCompat.getColor(context, R$color.home_rank_new_symbol_percent_red_color);
            }
            return ContextCompat.getColor(context, R$color.home_rank_new_symbol_percent_green_color);
        } else if (w.l()) {
            return ContextCompat.getColor(context, R$color.home_rank_new_symbol_percent_green_color);
        } else {
            return ContextCompat.getColor(context, R$color.home_rank_new_symbol_percent_red_color);
        }
    }

    public static BigDecimal i(BigDecimal bigDecimal, boolean z11, int i11) {
        if (bigDecimal == null) {
            return bigDecimal;
        }
        if (z11) {
            return bigDecimal.setScale(i11, 0);
        }
        return bigDecimal.setScale(i11, 3);
    }

    public static /* synthetic */ void j(int i11, HighLightPopup highLightPopup, View view, View.OnClickListener onClickListener, DialogFragment dialogFragment, View view2) {
        dialogFragment.dismiss();
        if (i11 == 2) {
            ConfigPreferences.n("user_config", "bubble_nav_guide", true);
        }
        l(highLightPopup, view);
        if (onClickListener != null) {
            onClickListener.onClick(view2);
        }
    }

    public static /* synthetic */ void k(HighLightPopup highLightPopup, View view, DialogFragment dialogFragment, View view2) {
        dialogFragment.dismiss();
        ConfigPreferences.n("user_config", "bubble_nav_guide", true);
        l(highLightPopup, view);
    }

    public static void l(HighLightPopup highLightPopup, View view) {
        f82034a = false;
        highLightPopup.dismiss();
        f82038e.remove(f82035b);
        if (view.getContext() instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) view.getContext()).getWindow().getDecorView();
            View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(childAt, View.ALPHA, new float[]{1.0f, 0.0f});
            ofFloat.setDuration(270).setInterpolator(new AccelerateInterpolator());
            ofFloat.addListener(new a(viewGroup, childAt));
            ofFloat.start();
        }
    }

    public static void m(View view, String str, String str2, View.OnClickListener onClickListener, int i11) {
        String str3;
        if (view != null && view.getWindowToken() != null && !f82034a && !ConfigPreferences.c("user_config", "bubble_nav_guide", false)) {
            f82034a = true;
            HighLightPopup highLightPopup = new HighLightPopup(view);
            highLightPopup.setContainerBg(new BgColorDrawable(ContextCompat.getColor(view.getContext(), R$color.app_bg), (float) 0));
            highLightPopup.setContainerPadding(PixelUtils.a(3.0f), PixelUtils.a(2.0f), PixelUtils.a(3.0f), PixelUtils.a(2.0f));
            highLightPopup.show();
            f82036c.add(highLightPopup);
            if (i11 == 1) {
                str3 = view.getResources().getString(R$string.showcase_next);
            } else {
                str3 = view.getResources().getString(R$string.showcase_know);
            }
            HeavyBubbleDialog.Builder positiveBtnListener = new HeavyBubbleDialog.Builder((FragmentActivity) view.getContext(), view).content(str).negativeBtnText(str2).positiveBtnText(str3).setNotExecuteHideAnim(true).positiveBtnListener(new d0(i11, highLightPopup, view, onClickListener));
            if (i11 == 1) {
                positiveBtnListener.negativeBtnListener(new e0(highLightPopup, view));
            }
            HeavyBubbleDialog build = positiveBtnListener.build();
            f82035b = build;
            build.show();
            f82038e.add(f82035b);
            if (view.getContext() instanceof Activity) {
                View view2 = new View(view.getContext());
                view2.setTag("POPUP_WINDOW_VIEW_TAG");
                view2.setBackgroundColor(ContextCompat.getColor(view.getContext(), R$color.bubble_popup_cover));
                ((ViewGroup) ((Activity) view.getContext()).getWindow().getDecorView()).addView(view2);
                f82037d.add(view2);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, View.ALPHA, new float[]{0.0f, 1.0f});
                ofFloat.setDuration(500).setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat.start();
            }
        }
    }
}
