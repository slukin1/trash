package vh;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.view.HbgPopupWindow;

public class d extends HbgPopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public final Context f47952a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f47953b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f47954c;

    /* renamed from: d  reason: collision with root package name */
    public b f47955d;

    /* renamed from: e  reason: collision with root package name */
    public View f47956e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47957f;

    /* renamed from: g  reason: collision with root package name */
    public AnimatorSet f47958g;

    /* renamed from: h  reason: collision with root package name */
    public AnimatorSet f47959h;

    public class a implements Animator.AnimatorListener {
        public a() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (d.this.f47957f) {
                d.this.dismiss();
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public interface b {
        void onDismiss();
    }

    public d(Context context, String str) {
        this.f47952a = context;
        d(context, str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f47954c.getLayoutParams();
        marginLayoutParams.setMarginStart(i11 - PixelUtils.a(5.0f));
        this.f47954c.setLayoutParams(marginLayoutParams);
        View view = this.f47956e;
        if (view != null && this.f47958g != null) {
            view.setPivotX((float) (i11 - PixelUtils.a(5.0f)));
            this.f47956e.setPivotY(0.0f);
            this.f47958g.start();
        }
    }

    public final void d(Context context, String str) {
        View inflate = View.inflate(context, R$layout.popup_accept_order_flag_layout_new, (ViewGroup) null);
        this.f47956e = inflate;
        TextView textView = (TextView) inflate.findViewById(R$id.id_accept_popup_content_tv);
        this.f47953b = textView;
        textView.setText(str);
        this.f47954c = (TextView) this.f47956e.findViewById(R$id.id_otc_bubble_bg_center_tv);
        setContentView(this.f47956e);
        setWidth(-1);
        setHeight(-2);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setCancelOnTouchOutside(true);
    }

    public void dismiss() {
        if (this.f47959h == null) {
            this.f47959h = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f47956e, "alpha", new float[]{1.0f, 0.0f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f47956e, "scaleX", new float[]{1.0f, 0.7f});
            this.f47956e.setPivotX(this.f47954c.getX());
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f47956e, "scaleY", new float[]{1.0f, 0.7f});
            this.f47956e.setPivotY(0.0f);
            this.f47959h.addListener(new a());
            this.f47959h.setDuration(150);
            this.f47959h.setInterpolator(new FastOutSlowInInterpolator());
            this.f47959h.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        }
        if (!this.f47957f) {
            this.f47957f = true;
            this.f47959h.start();
            return;
        }
        b bVar = this.f47955d;
        if (bVar != null) {
            bVar.onDismiss();
        }
        this.f47957f = false;
        super.dismiss();
    }

    public void f(View view, int i11) {
        TextView textView;
        super.showAsDropDown(view);
        this.f47957f = false;
        if (this.f47958g == null) {
            this.f47958g = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f47956e, "alpha", new float[]{0.0f, 1.0f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f47956e, "scaleX", new float[]{0.7f, 1.0f});
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f47956e, "scaleY", new float[]{0.7f, 1.0f});
            this.f47958g.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
            this.f47958g.setInterpolator(new FastOutSlowInInterpolator());
        }
        if (this.f47952a != null && this.f47953b != null && (textView = this.f47954c) != null) {
            textView.post(new c(this, i11));
        }
    }

    public void setCancelOnTouchOutside(boolean z11) {
        setOutsideTouchable(z11);
        setFocusable(z11);
    }
}
