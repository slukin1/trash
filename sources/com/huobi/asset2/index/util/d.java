package com.huobi.asset2.index.util;

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
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$string;
import com.huobi.view.AssetHeavyBubbleDialog;
import com.huobi.view.HighLightPopup;
import kotlin.Unit;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f42776a = new d();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f42777b;

    public static final class a implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f42778b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f42779c;

        public a(ViewGroup viewGroup, View view) {
            this.f42778b = viewGroup;
            this.f42779c = view;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f42778b.removeView(this.f42779c);
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public static final void e(FragmentActivity fragmentActivity, HighLightPopup highLightPopup, String str, d10.a aVar, DialogFragment dialogFragment, View view) {
        dialogFragment.dismiss();
        f42776a.c(fragmentActivity, highLightPopup);
        SP.y("earn_guide_key" + str, true);
        aVar.invoke();
    }

    public final boolean b() {
        String uid = BaseModuleConfig.a().getUid();
        return SP.l("earn_guide_key" + uid, false);
    }

    public final void c(Activity activity, HighLightPopup highLightPopup) {
        highLightPopup.dismiss();
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(childAt, View.ALPHA, new float[]{1.0f, 0.0f});
        ofFloat.setDuration(270).setInterpolator(new AccelerateInterpolator());
        ofFloat.addListener(new a(viewGroup, childAt));
        ofFloat.start();
    }

    public final void d(FragmentActivity fragmentActivity, View view, d10.a<Unit> aVar) {
        if (view.getWindowToken() != null) {
            String uid = BaseModuleConfig.a().getUid();
            if (!SP.l("earn_guide_key" + uid, false) && !f42777b) {
                f42777b = true;
                int a11 = PixelUtils.a(12.0f);
                HighLightPopup highLightPopup = new HighLightPopup(view);
                highLightPopup.setContainerBg(ContextCompat.getDrawable(view.getContext(), R$drawable.asset_guide_header_bg));
                int a12 = PixelUtils.a(4.0f);
                highLightPopup.setContainerPadding(a11, a12, a11, a12);
                highLightPopup.show();
                new AssetHeavyBubbleDialog.Builder(fragmentActivity, view).content(fragmentActivity.getString(R$string.n_asset_earn_guide_two)).positiveBtnText(fragmentActivity.getString(R$string.n_grid_user_guide_complete)).offsetX(a11).positiveBtnListener(new c(fragmentActivity, highLightPopup, uid, aVar)).build(true).show();
                View view2 = new View(fragmentActivity);
                view2.setTag("POPUP_WINDOW_VIEW_TAG");
                view2.setBackgroundColor(ContextCompat.getColor(view.getContext(), R$color.bubble_popup_cover));
                ((ViewGroup) fragmentActivity.getWindow().getDecorView()).addView(view2);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, View.ALPHA, new float[]{0.0f, 1.0f});
                ofFloat.setDuration(500).setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat.start();
            }
        }
    }
}
