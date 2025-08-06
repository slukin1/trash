package ej;

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
import bj.z2;
import com.hbg.lib.contract.R$color;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.core.util.ConfigPreferences;
import com.huobi.view.HeavyBubbleDialog;
import com.huobi.view.HighLightPopup;
import com.huobi.view.drawable.BgColorDrawable;
import java.util.ArrayList;
import java.util.List;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f47507a;

    /* renamed from: b  reason: collision with root package name */
    public static HeavyBubbleDialog f47508b;

    /* renamed from: c  reason: collision with root package name */
    public static List<HeavyBubbleDialog> f47509c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public static List<HighLightPopup> f47510d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public static List<View> f47511e = new ArrayList();

    public class a implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f47512b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f47513c;

        public a(ViewGroup viewGroup, View view) {
            this.f47512b = viewGroup;
            this.f47513c = view;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f47512b.removeView(this.f47513c);
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public static boolean c() {
        return ConfigPreferences.c("user_config", "config_future_tp_sl_guide_show", false);
    }

    public static /* synthetic */ void d(HighLightPopup highLightPopup, View view, HeavyBubbleDialog.Builder.OnDialogClickListener onDialogClickListener, DialogFragment dialogFragment, View view2) {
        dialogFragment.dismiss();
        f(highLightPopup, view);
        g();
        z2.c().b("TP_SL_GUIDE_NAME", 3);
        if (onDialogClickListener != null) {
            onDialogClickListener.onDialogClick(dialogFragment, view2);
        }
    }

    public static /* synthetic */ void e(HighLightPopup highLightPopup, View view, View.OnClickListener onClickListener, DialogFragment dialogFragment, View view2) {
        dialogFragment.dismiss();
        f(highLightPopup, view);
        g();
        z2.c().b("TP_SL_GUIDE_NAME", 3);
        if (onClickListener != null) {
            onClickListener.onClick(view2);
        }
    }

    public static void f(HighLightPopup highLightPopup, View view) {
        f47507a = false;
        highLightPopup.dismiss();
        f47509c.remove(f47508b);
        f47508b = null;
        if (view.getContext() instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) view.getContext()).getWindow().getDecorView();
            View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(childAt, View.ALPHA, new float[]{1.0f, 0.0f});
            ofFloat.setDuration(270).setInterpolator(new AccelerateInterpolator());
            ofFloat.addListener(new a(viewGroup, childAt));
            ofFloat.start();
        }
    }

    public static void g() {
        ConfigPreferences.n("user_config", "config_future_tp_sl_guide_show", true);
    }

    public static void h(View view, String str, View.OnClickListener onClickListener, HeavyBubbleDialog.Builder.OnDialogClickListener onDialogClickListener) {
        if (view != null && view.getWindowToken() != null && view.getHeight() != 0 && view.getWidth() != 0 && !f47507a && !c() && z2.c().e("TP_SL_GUIDE_NAME")) {
            f47507a = true;
            z2.c().b("TP_SL_GUIDE_NAME", 2);
            HighLightPopup highLightPopup = new HighLightPopup(view);
            highLightPopup.setContainerBg(new BgColorDrawable(ContextCompat.getColor(view.getContext(), R$color.app_bg), (float) 0));
            String string = view.getResources().getString(R$string.market_edit_collection_finish_text);
            highLightPopup.show();
            f47510d.add(highLightPopup);
            HeavyBubbleDialog build = new HeavyBubbleDialog.Builder((FragmentActivity) view.getContext(), view).content(str).positiveBtnText(string).more(view.getResources().getString(R$string.n_trade_observation_warning_more)).moreBtnListener(new i(highLightPopup, view, onDialogClickListener)).positiveBtnListener(new h(highLightPopup, view, onClickListener)).build();
            f47508b = build;
            build.show();
            f47509c.add(f47508b);
            if (view.getContext() instanceof Activity) {
                View view2 = new View(view.getContext());
                view2.setTag("POPUP_WINDOW_VIEW_TAG");
                view2.setBackgroundColor(ContextCompat.getColor(view.getContext(), R$color.bubble_popup_cover));
                ((ViewGroup) ((Activity) view.getContext()).getWindow().getDecorView()).addView(view2);
                f47511e.add(view2);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, View.ALPHA, new float[]{0.0f, 1.0f});
                ofFloat.setDuration(500).setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat.start();
            }
        }
    }
}
