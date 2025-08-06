package com.huobi.trade.helper;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.R$color;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.util.ConfigPreferences;
import com.huobi.view.HeavyBubbleDialog;
import com.huobi.view.HighLightPopup;
import com.huobi.view.drawable.BgColorDrawable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f82067a;

    /* renamed from: b  reason: collision with root package name */
    public static WeakReference<HeavyBubbleDialog> f82068b;

    /* renamed from: c  reason: collision with root package name */
    public static List<HighLightPopup> f82069c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public static List<View> f82070d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public static List<HeavyBubbleDialog> f82071e = new ArrayList();

    public class a implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f82072b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f82073c;

        public a(ViewGroup viewGroup, View view) {
            this.f82072b = viewGroup;
            this.f82073c = view;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f82072b.removeView(this.f82073c);
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public static boolean b() {
        return ConfigPreferences.c("user_config", "bubble_margin_lever_guide", false);
    }

    public static /* synthetic */ void c(HighLightPopup highLightPopup, View view, View.OnClickListener onClickListener, DialogFragment dialogFragment, View view2) {
        dialogFragment.dismiss();
        ConfigPreferences.n("user_config", "bubble_margin_lever_guide", true);
        d(highLightPopup, view);
        if (onClickListener != null) {
            onClickListener.onClick(view2);
        }
    }

    public static void d(HighLightPopup highLightPopup, View view) {
        f82067a = false;
        highLightPopup.dismiss();
        WeakReference<HeavyBubbleDialog> weakReference = f82068b;
        if (weakReference != null) {
            f82071e.remove(weakReference.get());
        }
        if (view.getContext() instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) view.getContext()).getWindow().getDecorView();
            View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(childAt, View.ALPHA, new float[]{1.0f, 0.0f});
            ofFloat.setDuration(270).setInterpolator(new AccelerateInterpolator());
            ofFloat.addListener(new a(viewGroup, childAt));
            ofFloat.start();
        }
    }

    public static void e(View view, View.OnClickListener onClickListener) {
        if (view != null && view.getWindowToken() != null && !f82067a && !b()) {
            f82067a = true;
            HighLightPopup highLightPopup = new HighLightPopup(view);
            highLightPopup.setContainerBg(new BgColorDrawable(ContextCompat.getColor(view.getContext(), R$color.app_bg), (float) 0));
            highLightPopup.setContainerPadding(PixelUtils.a(3.0f), PixelUtils.a(2.0f), PixelUtils.a(3.0f), PixelUtils.a(2.0f));
            highLightPopup.show();
            f82069c.add(highLightPopup);
            HeavyBubbleDialog build = new HeavyBubbleDialog.Builder((FragmentActivity) view.getContext(), view).content(view.getContext().getString(R$string.n_exchange_margin_guide_hint)).positiveBtnText(view.getResources().getString(R$string.n_known)).setNotExecuteHideAnim(true).positiveBtnListener(new n(highLightPopup, view, onClickListener)).build();
            f82068b = new WeakReference<>(build);
            build.show();
            f82071e.add(build);
            if (view.getContext() instanceof Activity) {
                View view2 = new View(view.getContext());
                view2.setTag("POPUP_WINDOW_VIEW_TAG");
                view2.setBackgroundColor(ContextCompat.getColor(view.getContext(), R$color.bubble_popup_cover));
                ((ViewGroup) ((Activity) view.getContext()).getWindow().getDecorView()).addView(view2);
                f82070d.add(view2);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, View.ALPHA, new float[]{0.0f, 1.0f});
                ofFloat.setDuration(500).setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat.start();
            }
        }
    }
}
