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

public class b extends HbgPopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public final Context f47943a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f47944b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f47945c;

    /* renamed from: d  reason: collision with root package name */
    public C0585b f47946d;

    /* renamed from: e  reason: collision with root package name */
    public View f47947e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47948f;

    /* renamed from: g  reason: collision with root package name */
    public AnimatorSet f47949g;

    /* renamed from: h  reason: collision with root package name */
    public AnimatorSet f47950h;

    public class a implements Animator.AnimatorListener {
        public a() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (b.this.f47948f) {
                b.this.dismiss();
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    /* renamed from: vh.b$b  reason: collision with other inner class name */
    public interface C0585b {
        void onDismiss();
    }

    public b(Context context, String str) {
        this.f47943a = context;
        d(context, str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f47945c.getLayoutParams();
        marginLayoutParams.setMarginStart(i11 - PixelUtils.a(5.0f));
        this.f47945c.setLayoutParams(marginLayoutParams);
        View view = this.f47947e;
        if (view != null && this.f47949g != null) {
            view.setPivotX((float) (i11 - PixelUtils.a(5.0f)));
            this.f47947e.setPivotY(0.0f);
            this.f47949g.start();
        }
    }

    public final void d(Context context, String str) {
        View inflate = View.inflate(context, R$layout.popup_accept_order_flag_layout, (ViewGroup) null);
        this.f47947e = inflate;
        TextView textView = (TextView) inflate.findViewById(R$id.id_accept_popup_content_tv);
        this.f47944b = textView;
        textView.setText(str);
        this.f47945c = (TextView) this.f47947e.findViewById(R$id.id_otc_bubble_bg_center_tv);
        setContentView(this.f47947e);
        setWidth(-1);
        setHeight(-2);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setCancelOnTouchOutside(true);
    }

    public void dismiss() {
        if (this.f47950h == null) {
            this.f47950h = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f47947e, "alpha", new float[]{1.0f, 0.0f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f47947e, "scaleX", new float[]{1.0f, 0.7f});
            this.f47947e.setPivotX(this.f47945c.getX());
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f47947e, "scaleY", new float[]{1.0f, 0.7f});
            this.f47947e.setPivotY(0.0f);
            this.f47950h.addListener(new a());
            this.f47950h.setDuration(150);
            this.f47950h.setInterpolator(new FastOutSlowInInterpolator());
            this.f47950h.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        }
        if (!this.f47948f) {
            this.f47948f = true;
            this.f47950h.start();
            return;
        }
        C0585b bVar = this.f47946d;
        if (bVar != null) {
            bVar.onDismiss();
        }
        this.f47948f = false;
        super.dismiss();
    }

    public void f(View view, int i11) {
        TextView textView;
        super.showAsDropDown(view);
        this.f47948f = false;
        if (this.f47949g == null) {
            this.f47949g = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f47947e, "alpha", new float[]{0.0f, 1.0f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f47947e, "scaleX", new float[]{0.7f, 1.0f});
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f47947e, "scaleY", new float[]{0.7f, 1.0f});
            this.f47949g.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
            this.f47949g.setInterpolator(new FastOutSlowInInterpolator());
        }
        if (this.f47943a != null && this.f47944b != null && (textView = this.f47945c) != null) {
            textView.post(new a(this, i11));
        }
    }

    public void setCancelOnTouchOutside(boolean z11) {
        setOutsideTouchable(z11);
        setFocusable(z11);
    }
}
