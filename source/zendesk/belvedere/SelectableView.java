package zendesk.belvedere;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.h0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import f30.i;
import zendesk.belvedere.ui.R$attr;
import zendesk.belvedere.ui.R$drawable;
import zendesk.belvedere.ui.R$id;

public class SelectableView extends FrameLayout implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public c f62254b;

    /* renamed from: c  reason: collision with root package name */
    public View f62255c;

    /* renamed from: d  reason: collision with root package name */
    public View f62256d;

    /* renamed from: e  reason: collision with root package name */
    public String f62257e;

    /* renamed from: f  reason: collision with root package name */
    public String f62258f;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SelectableView.this.g(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SelectableView.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public interface c {
        boolean a(boolean z11);
    }

    public SelectableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f();
    }

    private View getChild() {
        View view = this.f62255c;
        if (view != null) {
            return view;
        }
        if (getChildCount() == 2) {
            int i11 = 0;
            while (true) {
                if (i11 >= getChildCount()) {
                    break;
                }
                View childAt = getChildAt(i11);
                if (childAt.getId() != R$id.belvedere_selectable_view_checkbox) {
                    this.f62255c = childAt;
                    break;
                }
                i11++;
            }
            return this.f62255c;
        }
        throw new RuntimeException("More then one child added to SelectableView");
    }

    private void setContentDesc(boolean z11) {
        if (z11) {
            setContentDescription(this.f62257e);
        } else {
            setContentDescription(this.f62258f);
        }
    }

    public final void c(float f11) {
        getChild().setAlpha(f11);
    }

    public final void d(boolean z11) {
        if (z11) {
            this.f62256d.setVisibility(0);
            this.f62256d.bringToFront();
            h0.F0(this.f62256d, h0.z(this.f62255c) + 1.0f);
            return;
        }
        this.f62256d.setVisibility(8);
    }

    public final ImageView e(int i11) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        ImageView imageView = new ImageView(getContext());
        imageView.setId(R$id.belvedere_selectable_view_checkbox);
        imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R$drawable.belvedere_ic_check_circle));
        h0.B0(imageView, ContextCompat.getDrawable(getContext(), R$drawable.belvedere_ic_check_bg));
        imageView.setLayoutParams(layoutParams);
        imageView.setVisibility(8);
        i.b(imageView, i11);
        return imageView;
    }

    public final void f() {
        setClickable(true);
        setFocusable(true);
        setOnClickListener(this);
        ImageView e11 = e(i.a(getContext(), R$attr.colorPrimary));
        this.f62256d = e11;
        addView(e11);
    }

    public final void g(float f11) {
        getChild().setScaleX(f11);
        getChild().setScaleY(f11);
    }

    public void h(String str, String str2) {
        this.f62257e = str;
        this.f62258f = str2;
        setContentDesc(isSelected());
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        boolean z11 = true;
        boolean z12 = !isSelected();
        c cVar = this.f62254b;
        if (cVar != null) {
            z11 = cVar.a(z12);
        }
        if (z11) {
            setSelected(z12);
            if (z12) {
                valueAnimator2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.9f});
                valueAnimator = ValueAnimator.ofFloat(new float[]{1.0f, 0.8f});
            } else {
                valueAnimator2 = ValueAnimator.ofFloat(new float[]{0.9f, 1.0f});
                valueAnimator = ValueAnimator.ofFloat(new float[]{0.8f, 1.0f});
            }
            valueAnimator2.addUpdateListener(new a());
            valueAnimator.addUpdateListener(new b());
            valueAnimator.setDuration(75);
            valueAnimator2.setDuration(75);
            valueAnimator2.start();
            valueAnimator.start();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setSelected(boolean z11) {
        super.setSelected(z11);
        if (z11) {
            g(0.9f);
            c(0.8f);
            d(true);
            setContentDesc(true);
            return;
        }
        g(1.0f);
        c(1.0f);
        d(false);
        setContentDesc(false);
    }

    public void setSelectionListener(c cVar) {
        this.f62254b = cVar;
    }

    public SelectableView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        f();
    }
}
