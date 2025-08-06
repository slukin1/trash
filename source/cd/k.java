package cd;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.module.exchange.R$drawable;
import com.hbg.module.exchange.R$id;
import com.hbg.module.exchange.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class k extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public TextView f19426a;

    /* renamed from: b  reason: collision with root package name */
    public View f19427b;

    /* renamed from: c  reason: collision with root package name */
    public View f19428c;

    /* renamed from: d  reason: collision with root package name */
    public View f19429d;

    /* renamed from: e  reason: collision with root package name */
    public View f19430e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19431f;

    /* renamed from: g  reason: collision with root package name */
    public AnimatorSet f19432g;

    /* renamed from: h  reason: collision with root package name */
    public AnimatorSet f19433h;

    /* renamed from: i  reason: collision with root package name */
    public String f19434i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f19435j;

    /* renamed from: k  reason: collision with root package name */
    public int f19436k;

    public class a implements Animator.AnimatorListener {
        public a() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (k.this.f19431f) {
                k.this.dismiss();
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public k(Context context, boolean z11, String str) {
        this.f19435j = z11;
        this.f19434i = str;
        c(context);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void d(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void c(Context context) {
        View inflate = View.inflate(context, R$layout.grid_tips_popup_layout, (ViewGroup) null);
        this.f19430e = inflate;
        this.f19426a = (TextView) inflate.findViewById(R$id.id_accept_popup_content_tv);
        this.f19427b = this.f19430e.findViewById(R$id.id_otc_bubble_bg_right);
        this.f19428c = this.f19430e.findViewById(R$id.id_otc_bubble_bg_left);
        this.f19429d = this.f19430e.findViewById(R$id.id_otc_bubble_bg_center_tv);
        setContentView(this.f19430e);
        setWidth(-1);
        setHeight(-2);
        setBackgroundDrawable(new ColorDrawable(0));
        setOutsideTouchable(true);
        setFocusable(true);
        getContentView().setOnClickListener(new j(this));
        this.f19426a.setText(this.f19434i);
        if (!this.f19435j) {
            this.f19427b.setBackgroundResource(R$drawable.grid_tips_bubble_bg_left_down);
            this.f19428c.setBackgroundResource(R$drawable.grid_tips_bubble_bg_right_down);
            this.f19429d.setBackgroundResource(R$drawable.grid_tips_bubble_bg_center_down);
            this.f19426a.setPadding(PixelUtils.a(20.0f), PixelUtils.a(25.0f), PixelUtils.a(20.0f), PixelUtils.a(22.0f));
        }
    }

    public void dismiss() {
        if (this.f19433h == null) {
            this.f19433h = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f19430e, "alpha", new float[]{1.0f, 0.0f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f19430e, "scaleX", new float[]{1.0f, 0.7f});
            this.f19430e.setPivotX((float) (this.f19436k + (this.f19429d.getWidth() / 2)));
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f19430e, "scaleY", new float[]{1.0f, 0.7f});
            if (this.f19435j) {
                this.f19430e.setPivotY(0.0f);
            } else {
                this.f19430e.setPivotY((float) getHeight());
            }
            this.f19433h.addListener(new a());
            this.f19433h.setDuration(150);
            this.f19433h.setInterpolator(new FastOutSlowInInterpolator());
            this.f19433h.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        }
        if (!this.f19431f) {
            this.f19431f = true;
            this.f19433h.start();
            return;
        }
        this.f19431f = false;
        super.dismiss();
    }

    public void e(String str) {
        this.f19434i = str;
    }

    public final void f(View view, int i11) {
        super.showAsDropDown(view);
        i(i11);
    }

    public void g(View view, int i11) {
        this.f19436k = i11;
        if (this.f19435j) {
            f(view, i11);
        } else {
            h(view, i11);
        }
    }

    public final void h(View view, int i11) {
        int i12 = Resources.getSystem().getDisplayMetrics().widthPixels;
        int i13 = Resources.getSystem().getDisplayMetrics().heightPixels;
        if (view.getContext() instanceof Activity) {
            Rect rect = new Rect();
            ((Activity) view.getContext()).getWindow().getDecorView().getGlobalVisibleRect(rect);
            int i14 = rect.right - rect.left;
            i13 = rect.bottom - rect.top;
            i12 = i14;
        }
        this.f19430e.measure(View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i13, Integer.MIN_VALUE));
        int a11 = PixelUtils.a(52.0f) + (PixelUtils.a(14.0f) * this.f19426a.getLineCount());
        setHeight(a11);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        super.showAtLocation(view, 51, 0, iArr[1] - a11);
        i(i11);
    }

    public final void i(int i11) {
        this.f19431f = false;
        if (this.f19432g == null) {
            this.f19432g = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f19430e, "alpha", new float[]{0.0f, 1.0f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f19430e, "scaleX", new float[]{0.7f, 1.0f});
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f19430e, "scaleY", new float[]{0.7f, 1.0f});
            this.f19432g.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
            this.f19432g.setInterpolator(new FastOutSlowInInterpolator());
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f19429d.getLayoutParams();
        marginLayoutParams.setMarginStart(i11);
        this.f19429d.setLayoutParams(marginLayoutParams);
        this.f19426a.setText(this.f19434i);
        View view = this.f19430e;
        if (view != null && this.f19432g != null) {
            if (this.f19435j) {
                view.setPivotY(0.0f);
            } else {
                view.setPivotY((float) getHeight());
            }
            this.f19430e.setPivotX((float) (i11 + (this.f19429d.getWidth() / 2)));
            this.f19432g.start();
        }
    }
}
