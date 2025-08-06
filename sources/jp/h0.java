package jp;

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
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$string;
import com.huobi.view.HighLightPopup;
import com.huobi.view.OtcHeavyBubbleDialog;

public final class h0 {

    /* renamed from: b  reason: collision with root package name */
    public static h0 f84331b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f84332c;

    /* renamed from: d  reason: collision with root package name */
    public static OtcHeavyBubbleDialog f84333d;

    /* renamed from: a  reason: collision with root package name */
    public HighLightPopup f84334a;

    public class a implements OtcHeavyBubbleDialog.Builder.OnDialogClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f84335a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f84336b;

        public a(Context context, c cVar) {
            this.f84335a = context;
            this.f84336b = cVar;
        }

        public void onDialogClick(DialogFragment dialogFragment, View view) {
            h0.this.g((Activity) this.f84335a, this.f84336b, dialogFragment, true);
        }
    }

    public class b implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f84338b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f84339c;

        public b(ViewGroup viewGroup, View view) {
            this.f84338b = viewGroup;
            this.f84339c = view;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f84338b.removeView(this.f84339c);
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public interface c {
        void a(boolean z11);
    }

    public static h0 c() {
        if (f84331b == null) {
            synchronized (h0.class) {
                f84331b = new h0();
            }
        }
        return f84331b;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(Context context, c cVar, DialogFragment dialogFragment, View view) {
        g((Activity) context, cVar, dialogFragment, false);
    }

    public HighLightPopup b() {
        return this.f84334a;
    }

    public boolean d() {
        return !ConfigPreferences.a("otc_config", "show_otc_fast_tab_guide");
    }

    public boolean e() {
        return !ConfigPreferences.a("otc_config", "show_new_user_trade_guide");
    }

    public void g(Activity activity, c cVar, DialogFragment dialogFragment, boolean z11) {
        dialogFragment.dismiss();
        h(f84333d, this.f84334a, activity);
        if (cVar != null) {
            cVar.a(z11);
        }
    }

    public final void h(OtcHeavyBubbleDialog otcHeavyBubbleDialog, HighLightPopup highLightPopup, Activity activity) {
        f84332c = false;
        highLightPopup.dismiss();
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(childAt, View.ALPHA, new float[]{1.0f, 0.0f});
        ofFloat.setDuration(270).setInterpolator(new AccelerateInterpolator());
        ofFloat.addListener(new b(viewGroup, childAt));
        ofFloat.start();
    }

    public OtcHeavyBubbleDialog i(Context context, View view, c cVar, int i11, boolean z11, int i12, int i13, String str, String str2, int i14) {
        String str3;
        if (context == null || view == null || view.getWindowToken() == null || f84332c || view.getWidth() == 0 || view.getHeight() == 0) {
            return null;
        }
        f84332c = true;
        if (i12 == i13) {
            str3 = view.getResources().getString(R$string.n_grid_user_guide_complete);
        } else {
            str3 = view.getResources().getString(R$string.n_grid_user_guide_next);
        }
        OtcHeavyBubbleDialog.Builder builder = new OtcHeavyBubbleDialog.Builder((FragmentActivity) context, view);
        builder.content(str).subContent(str2).currentStep(i12).negativeBtnText(context.getResources().getString(R$string.n_grid_user_guide_skip)).negativeBtnListener(new a(context, cVar)).allStep(i13).rightMargin(i11).setIsShowRight(z11).positiveBtnText(str3).positiveBtnColor(v1.b()).positiveBtnListener(new g0(this, context, cVar));
        OtcHeavyBubbleDialog build = builder.build(true);
        f84333d = build;
        build.show();
        HighLightPopup highLightPopup = new HighLightPopup(view);
        this.f84334a = highLightPopup;
        highLightPopup.setContainerBg(ContextCompat.getDrawable(context, R$drawable.express_guide_bg));
        int i15 = i14 / 2;
        this.f84334a.setContainerPadding(i14, i15, i14, i15);
        this.f84334a.show();
        if (context instanceof Activity) {
            View view2 = new View(context);
            view2.setBackgroundColor(ContextCompat.getColor(context, R$color.bubble_popup_cover));
            ((ViewGroup) ((Activity) context).getWindow().getDecorView()).addView(view2);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, View.ALPHA, new float[]{0.0f, 1.0f});
            ofFloat.setDuration(500).setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.start();
        }
        return f84333d;
    }
}
