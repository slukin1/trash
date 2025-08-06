package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.d0;
import androidx.core.view.h0;

public class ListMenuItemView extends LinearLayout implements j.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: b  reason: collision with root package name */
    public g f4047b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f4048c;

    /* renamed from: d  reason: collision with root package name */
    public RadioButton f4049d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4050e;

    /* renamed from: f  reason: collision with root package name */
    public CheckBox f4051f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f4052g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f4053h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f4054i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f4055j;

    /* renamed from: k  reason: collision with root package name */
    public Drawable f4056k;

    /* renamed from: l  reason: collision with root package name */
    public int f4057l;

    /* renamed from: m  reason: collision with root package name */
    public Context f4058m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f4059n;

    /* renamed from: o  reason: collision with root package name */
    public Drawable f4060o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f4061p;

    /* renamed from: q  reason: collision with root package name */
    public LayoutInflater f4062q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f4063r;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.listMenuViewStyle);
    }

    private LayoutInflater getInflater() {
        if (this.f4062q == null) {
            this.f4062q = LayoutInflater.from(getContext());
        }
        return this.f4062q;
    }

    private void setSubMenuArrowVisible(boolean z11) {
        ImageView imageView = this.f4053h;
        if (imageView != null) {
            imageView.setVisibility(z11 ? 0 : 8);
        }
    }

    public final void a(View view) {
        b(view, -1);
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f4054i;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f4054i.getLayoutParams();
            rect.top += this.f4054i.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    public final void b(View view, int i11) {
        LinearLayout linearLayout = this.f4055j;
        if (linearLayout != null) {
            linearLayout.addView(view, i11);
        } else {
            addView(view, i11);
        }
    }

    public final void c() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R$layout.abc_list_menu_item_checkbox, this, false);
        this.f4051f = checkBox;
        a(checkBox);
    }

    public final void d() {
        ImageView imageView = (ImageView) getInflater().inflate(R$layout.abc_list_menu_item_icon, this, false);
        this.f4048c = imageView;
        b(imageView, 0);
    }

    public final void e() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R$layout.abc_list_menu_item_radio, this, false);
        this.f4049d = radioButton;
        a(radioButton);
    }

    public void f(boolean z11, char c11) {
        int i11 = (!z11 || !this.f4047b.A()) ? 8 : 0;
        if (i11 == 0) {
            this.f4052g.setText(this.f4047b.h());
        }
        if (this.f4052g.getVisibility() != i11) {
            this.f4052g.setVisibility(i11);
        }
    }

    public g getItemData() {
        return this.f4047b;
    }

    public void initialize(g gVar, int i11) {
        this.f4047b = gVar;
        setVisibility(gVar.isVisible() ? 0 : 8);
        setTitle(gVar.i(this));
        setCheckable(gVar.isCheckable());
        f(gVar.A(), gVar.g());
        setIcon(gVar.getIcon());
        setEnabled(gVar.isEnabled());
        setSubMenuArrowVisible(gVar.hasSubMenu());
        setContentDescription(gVar.getContentDescription());
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        h0.B0(this, this.f4056k);
        TextView textView = (TextView) findViewById(R$id.title);
        this.f4050e = textView;
        int i11 = this.f4057l;
        if (i11 != -1) {
            textView.setTextAppearance(this.f4058m, i11);
        }
        this.f4052g = (TextView) findViewById(R$id.shortcut);
        ImageView imageView = (ImageView) findViewById(R$id.submenuarrow);
        this.f4053h = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f4060o);
        }
        this.f4054i = (ImageView) findViewById(R$id.group_divider);
        this.f4055j = (LinearLayout) findViewById(R$id.content);
    }

    public void onMeasure(int i11, int i12) {
        if (this.f4048c != null && this.f4059n) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f4048c.getLayoutParams();
            int i13 = layoutParams.height;
            if (i13 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i13;
            }
        }
        super.onMeasure(i11, i12);
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean z11) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z11 || this.f4049d != null || this.f4051f != null) {
            if (this.f4047b.m()) {
                if (this.f4049d == null) {
                    e();
                }
                compoundButton2 = this.f4049d;
                compoundButton = this.f4051f;
            } else {
                if (this.f4051f == null) {
                    c();
                }
                compoundButton2 = this.f4051f;
                compoundButton = this.f4049d;
            }
            if (z11) {
                compoundButton2.setChecked(this.f4047b.isChecked());
                if (compoundButton2.getVisibility() != 0) {
                    compoundButton2.setVisibility(0);
                }
                if (compoundButton != null && compoundButton.getVisibility() != 8) {
                    compoundButton.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.f4051f;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.f4049d;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z11) {
        CompoundButton compoundButton;
        if (this.f4047b.m()) {
            if (this.f4049d == null) {
                e();
            }
            compoundButton = this.f4049d;
        } else {
            if (this.f4051f == null) {
                c();
            }
            compoundButton = this.f4051f;
        }
        compoundButton.setChecked(z11);
    }

    public void setForceShowIcon(boolean z11) {
        this.f4063r = z11;
        this.f4059n = z11;
    }

    public void setGroupDividerEnabled(boolean z11) {
        ImageView imageView = this.f4054i;
        if (imageView != null) {
            imageView.setVisibility((this.f4061p || !z11) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z11 = this.f4047b.z() || this.f4063r;
        if (z11 || this.f4059n) {
            ImageView imageView = this.f4048c;
            if (imageView != null || drawable != null || this.f4059n) {
                if (imageView == null) {
                    d();
                }
                if (drawable != null || this.f4059n) {
                    ImageView imageView2 = this.f4048c;
                    if (!z11) {
                        drawable = null;
                    }
                    imageView2.setImageDrawable(drawable);
                    if (this.f4048c.getVisibility() != 0) {
                        this.f4048c.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.f4048c.setVisibility(8);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f4050e.setText(charSequence);
            if (this.f4050e.getVisibility() != 0) {
                this.f4050e.setVisibility(0);
            }
        } else if (this.f4050e.getVisibility() != 8) {
            this.f4050e.setVisibility(8);
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet);
        d0 v11 = d0.v(getContext(), attributeSet, R$styleable.MenuView, i11, 0);
        this.f4056k = v11.g(R$styleable.MenuView_android_itemBackground);
        this.f4057l = v11.n(R$styleable.MenuView_android_itemTextAppearance, -1);
        this.f4059n = v11.a(R$styleable.MenuView_preserveIconSpacing, false);
        this.f4058m = context;
        this.f4060o = v11.g(R$styleable.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, new int[]{16843049}, R$attr.dropDownListViewStyle, 0);
        this.f4061p = obtainStyledAttributes.hasValue(0);
        v11.w();
        obtainStyledAttributes.recycle();
    }
}
