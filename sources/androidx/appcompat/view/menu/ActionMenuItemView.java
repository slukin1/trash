package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.i0;
import androidx.appcompat.widget.t;

public class ActionMenuItemView extends AppCompatTextView implements j.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: b  reason: collision with root package name */
    public g f4032b;

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f4033c;

    /* renamed from: d  reason: collision with root package name */
    public Drawable f4034d;

    /* renamed from: e  reason: collision with root package name */
    public e.b f4035e;

    /* renamed from: f  reason: collision with root package name */
    public t f4036f;

    /* renamed from: g  reason: collision with root package name */
    public PopupCallback f4037g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4038h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4039i;

    /* renamed from: j  reason: collision with root package name */
    public int f4040j;

    /* renamed from: k  reason: collision with root package name */
    public int f4041k;

    /* renamed from: l  reason: collision with root package name */
    public int f4042l;

    public static abstract class PopupCallback {
        public abstract h.e a();
    }

    public class a extends t {
        public a() {
            super(ActionMenuItemView.this);
        }

        public h.e b() {
            PopupCallback popupCallback = ActionMenuItemView.this.f4037g;
            if (popupCallback != null) {
                return popupCallback.a();
            }
            return null;
        }

        public boolean c() {
            h.e b11;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            e.b bVar = actionMenuItemView.f4035e;
            if (bVar == null || !bVar.a(actionMenuItemView.f4032b) || (b11 = b()) == null || !b11.isShowing()) {
                return false;
            }
            return true;
        }
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean a() {
        return d();
    }

    public boolean b() {
        return d() && this.f4032b.getIcon() == null;
    }

    public boolean d() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i11 = configuration.screenWidthDp;
        return i11 >= 480 || (i11 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public final void f() {
        CharSequence charSequence;
        boolean z11 = true;
        boolean z12 = !TextUtils.isEmpty(this.f4033c);
        if (this.f4034d != null && (!this.f4032b.B() || (!this.f4038h && !this.f4039i))) {
            z11 = false;
        }
        boolean z13 = z12 & z11;
        CharSequence charSequence2 = null;
        setText(z13 ? this.f4033c : null);
        CharSequence contentDescription = this.f4032b.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            if (z13) {
                charSequence = null;
            } else {
                charSequence = this.f4032b.getTitle();
            }
            setContentDescription(charSequence);
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f4032b.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z13) {
                charSequence2 = this.f4032b.getTitle();
            }
            i0.a(this, charSequence2);
            return;
        }
        i0.a(this, tooltipText);
    }

    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    public g getItemData() {
        return this.f4032b;
    }

    public void initialize(g gVar, int i11) {
        this.f4032b = gVar;
        setIcon(gVar.getIcon());
        setTitle(gVar.i(this));
        setId(gVar.getItemId());
        setVisibility(gVar.isVisible() ? 0 : 8);
        setEnabled(gVar.isEnabled());
        if (gVar.hasSubMenu() && this.f4036f == null) {
            this.f4036f = new a();
        }
    }

    public void onClick(View view) {
        e.b bVar = this.f4035e;
        if (bVar != null) {
            bVar.a(this.f4032b);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f4038h = e();
        f();
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        boolean d11 = d();
        if (d11 && (i14 = this.f4041k) >= 0) {
            super.setPadding(i14, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i11, i12);
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int measuredWidth = getMeasuredWidth();
        if (mode == Integer.MIN_VALUE) {
            i13 = Math.min(size, this.f4040j);
        } else {
            i13 = this.f4040j;
        }
        if (mode != 1073741824 && this.f4040j > 0 && measuredWidth < i13) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i13, 1073741824), i12);
        }
        if (!d11 && this.f4034d != null) {
            super.setPadding((getMeasuredWidth() - this.f4034d.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState((Parcelable) null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        t tVar;
        if (!this.f4032b.hasSubMenu() || (tVar = this.f4036f) == null || !tVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean z11) {
    }

    public void setChecked(boolean z11) {
    }

    public void setExpandedFormat(boolean z11) {
        if (this.f4039i != z11) {
            this.f4039i = z11;
            g gVar = this.f4032b;
            if (gVar != null) {
                gVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f4034d = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i11 = this.f4042l;
            if (intrinsicWidth > i11) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i11) / ((float) intrinsicWidth)));
                intrinsicWidth = i11;
            }
            if (intrinsicHeight > i11) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i11) / ((float) intrinsicHeight)));
            } else {
                i11 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i11);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        f();
    }

    public void setItemInvoker(e.b bVar) {
        this.f4035e = bVar;
    }

    public void setPadding(int i11, int i12, int i13, int i14) {
        this.f4041k = i11;
        super.setPadding(i11, i12, i13, i14);
    }

    public void setPopupCallback(PopupCallback popupCallback) {
        this.f4037g = popupCallback;
    }

    public void setTitle(CharSequence charSequence) {
        this.f4033c = charSequence;
        f();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Resources resources = context.getResources();
        this.f4038h = e();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionMenuItemView, i11, 0);
        this.f4040j = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f4042l = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f4041k = -1;
        setSaveEnabled(false);
    }
}
