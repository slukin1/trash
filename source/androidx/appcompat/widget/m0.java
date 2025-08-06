package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;

public class m0 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4624a;

    /* renamed from: b  reason: collision with root package name */
    public final View f4625b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f4626c;

    /* renamed from: d  reason: collision with root package name */
    public final WindowManager.LayoutParams f4627d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f4628e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    public final int[] f4629f = new int[2];

    /* renamed from: g  reason: collision with root package name */
    public final int[] f4630g = new int[2];

    public m0(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f4627d = layoutParams;
        this.f4624a = context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.abc_tooltip, (ViewGroup) null);
        this.f4625b = inflate;
        this.f4626c = (TextView) inflate.findViewById(R$id.message);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R$style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    public static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    public final void a(View view, int i11, int i12, boolean z11, WindowManager.LayoutParams layoutParams) {
        int i13;
        int i14;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f4624a.getResources().getDimensionPixelOffset(R$dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i11 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f4624a.getResources().getDimensionPixelOffset(R$dimen.tooltip_precise_anchor_extra_offset);
            i14 = i12 + dimensionPixelOffset2;
            i13 = i12 - dimensionPixelOffset2;
        } else {
            i14 = view.getHeight();
            i13 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f4624a.getResources().getDimensionPixelOffset(z11 ? R$dimen.tooltip_y_offset_touch : R$dimen.tooltip_y_offset_non_touch);
        View b11 = b(view);
        if (b11 == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        b11.getWindowVisibleDisplayFrame(this.f4628e);
        Rect rect = this.f4628e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f4624a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f4628e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        b11.getLocationOnScreen(this.f4630g);
        view.getLocationOnScreen(this.f4629f);
        int[] iArr = this.f4629f;
        int i15 = iArr[0];
        int[] iArr2 = this.f4630g;
        iArr[0] = i15 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i11) - (b11.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f4625b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f4625b.getMeasuredHeight();
        int[] iArr3 = this.f4629f;
        int i16 = ((iArr3[1] + i13) - dimensionPixelOffset3) - measuredHeight;
        int i17 = iArr3[1] + i14 + dimensionPixelOffset3;
        if (z11) {
            if (i16 >= 0) {
                layoutParams.y = i16;
            } else {
                layoutParams.y = i17;
            }
        } else if (measuredHeight + i17 <= this.f4628e.height()) {
            layoutParams.y = i17;
        } else {
            layoutParams.y = i16;
        }
    }

    public void c() {
        if (d()) {
            ((WindowManager) this.f4624a.getSystemService("window")).removeView(this.f4625b);
        }
    }

    public boolean d() {
        return this.f4625b.getParent() != null;
    }

    public void e(View view, int i11, int i12, boolean z11, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f4626c.setText(charSequence);
        a(view, i11, i12, z11, this.f4627d);
        ((WindowManager) this.f4624a.getSystemService("window")).addView(this.f4625b, this.f4627d);
    }
}
