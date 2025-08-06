package ks;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.b;
import com.huobi.view.HeavyBubbleDialog;
import com.huobi.view.HighLightPopup;
import com.huobi.view.drawable.BgColorDrawable;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f84428a;

    /* renamed from: b  reason: collision with root package name */
    public static HeavyBubbleDialog f84429b;

    /* renamed from: c  reason: collision with root package name */
    public static List<HeavyBubbleDialog> f84430c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public static int f84431d = a.a().b();

    /* renamed from: e  reason: collision with root package name */
    public static int f84432e = a.a().b();

    /* renamed from: f  reason: collision with root package name */
    public static int f84433f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static int f84434g = 1;

    public class a implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f84435b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f84436c;

        public a(ViewGroup viewGroup, View view) {
            this.f84435b = viewGroup;
            this.f84436c = view;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f84435b.removeView(this.f84436c);
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public static int c() {
        return f84433f;
    }

    public static int d() {
        return f84431d;
    }

    public static String e(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return String.format("%s %sX", new Object[]{str, str2});
    }

    public static int f() {
        return ConfigPreferences.g("user_config", "config_margin_loan_type", 2);
    }

    public static int g() {
        return f84434g;
    }

    public static int h() {
        return f84432e;
    }

    public static boolean i() {
        return true;
    }

    public static boolean j() {
        return f() == 1;
    }

    public static boolean k() {
        return true;
    }

    public static boolean l() {
        return f() == 0;
    }

    public static /* synthetic */ void m(HighLightPopup highLightPopup, View view, boolean z11, View.OnClickListener onClickListener, DialogFragment dialogFragment, View view2) {
        dialogFragment.dismiss();
        o(highLightPopup, view);
        if (z11) {
            ConfigPreferences.n("user_config", "bubble_auto_loan_guide", true);
        }
        if (onClickListener != null) {
            onClickListener.onClick(view2);
        }
    }

    public static /* synthetic */ void n(HighLightPopup highLightPopup, View view, DialogFragment dialogFragment, View view2) {
        dialogFragment.dismiss();
        ConfigPreferences.n("user_config", "bubble_auto_loan_guide", true);
        o(highLightPopup, view);
    }

    public static void o(HighLightPopup highLightPopup, View view) {
        f84428a = false;
        highLightPopup.dismiss();
        f84430c.remove(f84429b);
        if (view.getContext() instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) view.getContext()).getWindow().getDecorView();
            View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(childAt, View.ALPHA, new float[]{1.0f, 0.0f});
            ofFloat.setDuration(270).setInterpolator(new AccelerateInterpolator());
            ofFloat.addListener(new a(viewGroup, childAt));
            ofFloat.start();
        }
    }

    public static void p(boolean z11) {
        ConfigPreferences.n("user_config", "config_dialog_margin_loan", z11);
    }

    public static void q(int i11) {
        ConfigPreferences.k("user_config", "config_margin_loan_type", i11);
    }

    public static void r(int i11) {
        f84433f = i11;
    }

    public static void s(int i11) {
        f84431d = i11;
    }

    public static void t(int i11) {
        f84434g = i11;
    }

    public static void u(int i11) {
        f84432e = i11;
    }

    public static void v(View view, String str, String str2, boolean z11, View.OnClickListener onClickListener) {
        String str3;
        if (view != null && view.getWindowToken() != null && !f84428a && !i()) {
            f84428a = true;
            HighLightPopup highLightPopup = new HighLightPopup(view);
            int color = ContextCompat.getColor(view.getContext(), R.color.app_bg);
            if (z11) {
                highLightPopup.setContainerBg(new BgColorDrawable(color, (float) 0));
                str3 = view.getResources().getString(R.string.market_edit_collection_finish_text);
            } else {
                if (b.c().f()) {
                    float f11 = (float) 0;
                    highLightPopup.setContainerBg(new BgColorDrawable(color, new float[]{0.0f, 0.0f, f11, f11, f11, f11, 0.0f, 0.0f}));
                } else {
                    highLightPopup.setContainerBg(new BgColorDrawable(color, (float) 0));
                }
                str3 = view.getResources().getString(R.string.sign_up_next);
            }
            highLightPopup.show();
            HeavyBubbleDialog.Builder negativeBtnText = new HeavyBubbleDialog.Builder((FragmentActivity) view.getContext(), view).content(str).positiveBtnText(str3).positiveBtnListener(new f(highLightPopup, view, z11, onClickListener)).negativeBtnText(str2);
            if (!z11) {
                negativeBtnText.negativeBtnListener(new e(highLightPopup, view));
            }
            HeavyBubbleDialog build = negativeBtnText.build();
            f84429b = build;
            build.show();
            f84430c.add(f84429b);
            if (view.getContext() instanceof Activity) {
                View view2 = new View(view.getContext());
                view2.setTag("POPUP_WINDOW_VIEW_TAG");
                view2.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.bubble_popup_cover));
                ((ViewGroup) ((Activity) view.getContext()).getWindow().getDecorView()).addView(view2);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, View.ALPHA, new float[]{0.0f, 1.0f});
                ofFloat.setDuration(500).setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat.start();
            }
        }
    }
}
