package h;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.ContextCompat;
import v0.b;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final int f15841a;

    /* renamed from: b  reason: collision with root package name */
    public final int f15842b;

    /* renamed from: c  reason: collision with root package name */
    public final int f15843c;

    /* renamed from: d  reason: collision with root package name */
    public CharSequence f15844d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f15845e;

    /* renamed from: f  reason: collision with root package name */
    public Intent f15846f;

    /* renamed from: g  reason: collision with root package name */
    public char f15847g;

    /* renamed from: h  reason: collision with root package name */
    public int f15848h = 4096;

    /* renamed from: i  reason: collision with root package name */
    public char f15849i;

    /* renamed from: j  reason: collision with root package name */
    public int f15850j = 4096;

    /* renamed from: k  reason: collision with root package name */
    public Drawable f15851k;

    /* renamed from: l  reason: collision with root package name */
    public Context f15852l;

    /* renamed from: m  reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f15853m;

    /* renamed from: n  reason: collision with root package name */
    public CharSequence f15854n;

    /* renamed from: o  reason: collision with root package name */
    public CharSequence f15855o;

    /* renamed from: p  reason: collision with root package name */
    public ColorStateList f15856p = null;

    /* renamed from: q  reason: collision with root package name */
    public PorterDuff.Mode f15857q = null;

    /* renamed from: r  reason: collision with root package name */
    public boolean f15858r = false;

    /* renamed from: s  reason: collision with root package name */
    public boolean f15859s = false;

    /* renamed from: t  reason: collision with root package name */
    public int f15860t = 16;

    public a(Context context, int i11, int i12, int i13, int i14, CharSequence charSequence) {
        this.f15852l = context;
        this.f15841a = i12;
        this.f15842b = i11;
        this.f15843c = i14;
        this.f15844d = charSequence;
    }

    public androidx.core.view.a a() {
        return null;
    }

    public b b(androidx.core.view.a aVar) {
        throw new UnsupportedOperationException();
    }

    public final void c() {
        Drawable drawable = this.f15851k;
        if (drawable == null) {
            return;
        }
        if (this.f15858r || this.f15859s) {
            Drawable r11 = u0.a.r(drawable);
            this.f15851k = r11;
            Drawable mutate = r11.mutate();
            this.f15851k = mutate;
            if (this.f15858r) {
                u0.a.o(mutate, this.f15856p);
            }
            if (this.f15859s) {
                u0.a.p(this.f15851k, this.f15857q);
            }
        }
    }

    public boolean collapseActionView() {
        return false;
    }

    /* renamed from: d */
    public b setActionView(int i11) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: e */
    public b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public boolean expandActionView() {
        return false;
    }

    /* renamed from: f */
    public b setShowAsActionFlags(int i11) {
        setShowAsAction(i11);
        return this;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public int getAlphabeticModifiers() {
        return this.f15850j;
    }

    public char getAlphabeticShortcut() {
        return this.f15849i;
    }

    public CharSequence getContentDescription() {
        return this.f15854n;
    }

    public int getGroupId() {
        return this.f15842b;
    }

    public Drawable getIcon() {
        return this.f15851k;
    }

    public ColorStateList getIconTintList() {
        return this.f15856p;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f15857q;
    }

    public Intent getIntent() {
        return this.f15846f;
    }

    public int getItemId() {
        return this.f15841a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public int getNumericModifiers() {
        return this.f15848h;
    }

    public char getNumericShortcut() {
        return this.f15847g;
    }

    public int getOrder() {
        return this.f15843c;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f15844d;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f15845e;
        return charSequence != null ? charSequence : this.f15844d;
    }

    public CharSequence getTooltipText() {
        return this.f15855o;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f15860t & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f15860t & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f15860t & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f15860t & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c11) {
        this.f15849i = Character.toLowerCase(c11);
        return this;
    }

    public MenuItem setCheckable(boolean z11) {
        this.f15860t = z11 | (this.f15860t & true) ? 1 : 0;
        return this;
    }

    public MenuItem setChecked(boolean z11) {
        this.f15860t = (z11 ? 2 : 0) | (this.f15860t & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z11) {
        this.f15860t = (z11 ? 16 : 0) | (this.f15860t & -17);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f15851k = drawable;
        c();
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f15856p = colorStateList;
        this.f15858r = true;
        c();
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f15857q = mode;
        this.f15859s = true;
        c();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f15846f = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c11) {
        this.f15847g = c11;
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f15853m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c11, char c12) {
        this.f15847g = c11;
        this.f15849i = Character.toLowerCase(c12);
        return this;
    }

    public void setShowAsAction(int i11) {
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f15844d = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f15845e = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z11) {
        int i11 = 8;
        int i12 = this.f15860t & 8;
        if (z11) {
            i11 = 0;
        }
        this.f15860t = i12 | i11;
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c11, int i11) {
        this.f15849i = Character.toLowerCase(c11);
        this.f15850j = KeyEvent.normalizeMetaState(i11);
        return this;
    }

    public b setContentDescription(CharSequence charSequence) {
        this.f15854n = charSequence;
        return this;
    }

    public MenuItem setNumericShortcut(char c11, int i11) {
        this.f15847g = c11;
        this.f15848h = KeyEvent.normalizeMetaState(i11);
        return this;
    }

    public MenuItem setTitle(int i11) {
        this.f15844d = this.f15852l.getResources().getString(i11);
        return this;
    }

    public b setTooltipText(CharSequence charSequence) {
        this.f15855o = charSequence;
        return this;
    }

    public MenuItem setIcon(int i11) {
        this.f15851k = ContextCompat.getDrawable(this.f15852l, i11);
        c();
        return this;
    }

    public MenuItem setShortcut(char c11, char c12, int i11, int i12) {
        this.f15847g = c11;
        this.f15848h = KeyEvent.normalizeMetaState(i11);
        this.f15849i = Character.toLowerCase(c12);
        this.f15850j = KeyEvent.normalizeMetaState(i12);
        return this;
    }
}
