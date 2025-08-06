package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import androidx.appcompat.R$string;
import androidx.appcompat.view.menu.j;
import androidx.core.view.a;
import v0.b;

public final class g implements b {
    public View A;
    public androidx.core.view.a B;
    public MenuItem.OnActionExpandListener C;
    public boolean D = false;
    public ContextMenu.ContextMenuInfo E;

    /* renamed from: a  reason: collision with root package name */
    public final int f4141a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4142b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4143c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4144d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f4145e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f4146f;

    /* renamed from: g  reason: collision with root package name */
    public Intent f4147g;

    /* renamed from: h  reason: collision with root package name */
    public char f4148h;

    /* renamed from: i  reason: collision with root package name */
    public int f4149i = 4096;

    /* renamed from: j  reason: collision with root package name */
    public char f4150j;

    /* renamed from: k  reason: collision with root package name */
    public int f4151k = 4096;

    /* renamed from: l  reason: collision with root package name */
    public Drawable f4152l;

    /* renamed from: m  reason: collision with root package name */
    public int f4153m = 0;

    /* renamed from: n  reason: collision with root package name */
    public e f4154n;

    /* renamed from: o  reason: collision with root package name */
    public l f4155o;

    /* renamed from: p  reason: collision with root package name */
    public Runnable f4156p;

    /* renamed from: q  reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f4157q;

    /* renamed from: r  reason: collision with root package name */
    public CharSequence f4158r;

    /* renamed from: s  reason: collision with root package name */
    public CharSequence f4159s;

    /* renamed from: t  reason: collision with root package name */
    public ColorStateList f4160t = null;

    /* renamed from: u  reason: collision with root package name */
    public PorterDuff.Mode f4161u = null;

    /* renamed from: v  reason: collision with root package name */
    public boolean f4162v = false;

    /* renamed from: w  reason: collision with root package name */
    public boolean f4163w = false;

    /* renamed from: x  reason: collision with root package name */
    public boolean f4164x = false;

    /* renamed from: y  reason: collision with root package name */
    public int f4165y = 16;

    /* renamed from: z  reason: collision with root package name */
    public int f4166z = 0;

    public class a implements a.b {
        public a() {
        }

        public void onActionProviderVisibilityChanged(boolean z11) {
            g gVar = g.this;
            gVar.f4154n.onItemVisibleChanged(gVar);
        }
    }

    public g(e eVar, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15) {
        this.f4154n = eVar;
        this.f4141a = i12;
        this.f4142b = i11;
        this.f4143c = i13;
        this.f4144d = i14;
        this.f4145e = charSequence;
        this.f4166z = i15;
    }

    public static void d(StringBuilder sb2, int i11, int i12, String str) {
        if ((i11 & i12) == i12) {
            sb2.append(str);
        }
    }

    public boolean A() {
        return this.f4154n.isShortcutsVisible() && g() != 0;
    }

    public boolean B() {
        return (this.f4166z & 4) == 4;
    }

    public androidx.core.view.a a() {
        return this.B;
    }

    public b b(androidx.core.view.a aVar) {
        androidx.core.view.a aVar2 = this.B;
        if (aVar2 != null) {
            aVar2.h();
        }
        this.A = null;
        this.B = aVar;
        this.f4154n.onItemsChanged(true);
        androidx.core.view.a aVar3 = this.B;
        if (aVar3 != null) {
            aVar3.j(new a());
        }
        return this;
    }

    public void c() {
        this.f4154n.onItemActionRequestChanged(this);
    }

    public boolean collapseActionView() {
        if ((this.f4166z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f4154n.collapseItemActionView(this);
        }
        return false;
    }

    public final Drawable e(Drawable drawable) {
        if (drawable != null && this.f4164x && (this.f4162v || this.f4163w)) {
            drawable = u0.a.r(drawable).mutate();
            if (this.f4162v) {
                u0.a.o(drawable, this.f4160t);
            }
            if (this.f4163w) {
                u0.a.p(drawable, this.f4161u);
            }
            this.f4164x = false;
        }
        return drawable;
    }

    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f4154n.expandItemActionView(this);
        }
        return false;
    }

    public int f() {
        return this.f4144d;
    }

    public char g() {
        return this.f4154n.isQwertyMode() ? this.f4150j : this.f4148h;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        androidx.core.view.a aVar = this.B;
        if (aVar == null) {
            return null;
        }
        View d11 = aVar.d(this);
        this.A = d11;
        return d11;
    }

    public int getAlphabeticModifiers() {
        return this.f4151k;
    }

    public char getAlphabeticShortcut() {
        return this.f4150j;
    }

    public CharSequence getContentDescription() {
        return this.f4158r;
    }

    public int getGroupId() {
        return this.f4142b;
    }

    public Drawable getIcon() {
        Drawable drawable = this.f4152l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f4153m == 0) {
            return null;
        }
        Drawable b11 = c.a.b(this.f4154n.getContext(), this.f4153m);
        this.f4153m = 0;
        this.f4152l = b11;
        return e(b11);
    }

    public ColorStateList getIconTintList() {
        return this.f4160t;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f4161u;
    }

    public Intent getIntent() {
        return this.f4147g;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f4141a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    public int getNumericModifiers() {
        return this.f4149i;
    }

    public char getNumericShortcut() {
        return this.f4148h;
    }

    public int getOrder() {
        return this.f4143c;
    }

    public SubMenu getSubMenu() {
        return this.f4155o;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f4145e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f4146f;
        if (charSequence == null) {
            charSequence = this.f4145e;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public CharSequence getTooltipText() {
        return this.f4159s;
    }

    public String h() {
        char g11 = g();
        if (g11 == 0) {
            return "";
        }
        Resources resources = this.f4154n.getContext().getResources();
        StringBuilder sb2 = new StringBuilder();
        if (ViewConfiguration.get(this.f4154n.getContext()).hasPermanentMenuKey()) {
            sb2.append(resources.getString(R$string.abc_prepend_shortcut_label));
        }
        int i11 = this.f4154n.isQwertyMode() ? this.f4151k : this.f4149i;
        d(sb2, i11, 65536, resources.getString(R$string.abc_menu_meta_shortcut_label));
        d(sb2, i11, 4096, resources.getString(R$string.abc_menu_ctrl_shortcut_label));
        d(sb2, i11, 2, resources.getString(R$string.abc_menu_alt_shortcut_label));
        d(sb2, i11, 1, resources.getString(R$string.abc_menu_shift_shortcut_label));
        d(sb2, i11, 4, resources.getString(R$string.abc_menu_sym_shortcut_label));
        d(sb2, i11, 8, resources.getString(R$string.abc_menu_function_shortcut_label));
        if (g11 == 8) {
            sb2.append(resources.getString(R$string.abc_menu_delete_shortcut_label));
        } else if (g11 == 10) {
            sb2.append(resources.getString(R$string.abc_menu_enter_shortcut_label));
        } else if (g11 != ' ') {
            sb2.append(g11);
        } else {
            sb2.append(resources.getString(R$string.abc_menu_space_shortcut_label));
        }
        return sb2.toString();
    }

    public boolean hasSubMenu() {
        return this.f4155o != null;
    }

    public CharSequence i(j.a aVar) {
        if (aVar == null || !aVar.prefersCondensedTitle()) {
            return getTitle();
        }
        return getTitleCondensed();
    }

    public boolean isActionViewExpanded() {
        return this.D;
    }

    public boolean isCheckable() {
        return (this.f4165y & 1) == 1;
    }

    public boolean isChecked() {
        return (this.f4165y & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.f4165y & 16) != 0;
    }

    public boolean isVisible() {
        androidx.core.view.a aVar = this.B;
        if (aVar == null || !aVar.g()) {
            if ((this.f4165y & 8) == 0) {
                return true;
            }
            return false;
        } else if ((this.f4165y & 8) != 0 || !this.B.b()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean j() {
        androidx.core.view.a aVar;
        if ((this.f4166z & 8) == 0) {
            return false;
        }
        if (this.A == null && (aVar = this.B) != null) {
            this.A = aVar.d(this);
        }
        if (this.A != null) {
            return true;
        }
        return false;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f4157q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        e eVar = this.f4154n;
        if (eVar.dispatchMenuItemSelected(eVar, this)) {
            return true;
        }
        Runnable runnable = this.f4156p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f4147g != null) {
            try {
                this.f4154n.getContext().startActivity(this.f4147g);
                return true;
            } catch (ActivityNotFoundException e11) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e11);
            }
        }
        androidx.core.view.a aVar = this.B;
        if (aVar == null || !aVar.e()) {
            return false;
        }
        return true;
    }

    public boolean l() {
        return (this.f4165y & 32) == 32;
    }

    public boolean m() {
        return (this.f4165y & 4) != 0;
    }

    public boolean n() {
        return (this.f4166z & 1) == 1;
    }

    public boolean o() {
        return (this.f4166z & 2) == 2;
    }

    /* renamed from: p */
    public b setActionView(int i11) {
        Context context = this.f4154n.getContext();
        setActionView(LayoutInflater.from(context).inflate(i11, new LinearLayout(context), false));
        return this;
    }

    /* renamed from: q */
    public b setActionView(View view) {
        int i11;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i11 = this.f4141a) > 0) {
            view.setId(i11);
        }
        this.f4154n.onItemActionRequestChanged(this);
        return this;
    }

    public void r(boolean z11) {
        this.D = z11;
        this.f4154n.onItemsChanged(false);
    }

    public void s(boolean z11) {
        int i11 = this.f4165y;
        int i12 = (z11 ? 2 : 0) | (i11 & -3);
        this.f4165y = i12;
        if (i11 != i12) {
            this.f4154n.onItemsChanged(false);
        }
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public MenuItem setAlphabeticShortcut(char c11) {
        if (this.f4150j == c11) {
            return this;
        }
        this.f4150j = Character.toLowerCase(c11);
        this.f4154n.onItemsChanged(false);
        return this;
    }

    public MenuItem setCheckable(boolean z11) {
        int i11 = this.f4165y;
        boolean z12 = z11 | (i11 & true);
        this.f4165y = z12 ? 1 : 0;
        if (i11 != z12) {
            this.f4154n.onItemsChanged(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z11) {
        if ((this.f4165y & 4) != 0) {
            this.f4154n.setExclusiveItemChecked(this);
        } else {
            s(z11);
        }
        return this;
    }

    public MenuItem setEnabled(boolean z11) {
        if (z11) {
            this.f4165y |= 16;
        } else {
            this.f4165y &= -17;
        }
        this.f4154n.onItemsChanged(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f4153m = 0;
        this.f4152l = drawable;
        this.f4164x = true;
        this.f4154n.onItemsChanged(false);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f4160t = colorStateList;
        this.f4162v = true;
        this.f4164x = true;
        this.f4154n.onItemsChanged(false);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f4161u = mode;
        this.f4163w = true;
        this.f4164x = true;
        this.f4154n.onItemsChanged(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f4147g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c11) {
        if (this.f4148h == c11) {
            return this;
        }
        this.f4148h = c11;
        this.f4154n.onItemsChanged(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f4157q = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c11, char c12) {
        this.f4148h = c11;
        this.f4150j = Character.toLowerCase(c12);
        this.f4154n.onItemsChanged(false);
        return this;
    }

    public void setShowAsAction(int i11) {
        int i12 = i11 & 3;
        if (i12 == 0 || i12 == 1 || i12 == 2) {
            this.f4166z = i11;
            this.f4154n.onItemActionRequestChanged(this);
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f4145e = charSequence;
        this.f4154n.onItemsChanged(false);
        l lVar = this.f4155o;
        if (lVar != null) {
            lVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f4146f = charSequence;
        this.f4154n.onItemsChanged(false);
        return this;
    }

    public MenuItem setVisible(boolean z11) {
        if (y(z11)) {
            this.f4154n.onItemVisibleChanged(this);
        }
        return this;
    }

    public void t(boolean z11) {
        this.f4165y = (z11 ? 4 : 0) | (this.f4165y & -5);
    }

    public String toString() {
        CharSequence charSequence = this.f4145e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z11) {
        if (z11) {
            this.f4165y |= 32;
        } else {
            this.f4165y &= -33;
        }
    }

    public void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    /* renamed from: w */
    public b setShowAsActionFlags(int i11) {
        setShowAsAction(i11);
        return this;
    }

    public void x(l lVar) {
        this.f4155o = lVar;
        lVar.setHeaderTitle(getTitle());
    }

    public boolean y(boolean z11) {
        int i11 = this.f4165y;
        int i12 = (z11 ? 0 : 8) | (i11 & -9);
        this.f4165y = i12;
        if (i11 != i12) {
            return true;
        }
        return false;
    }

    public boolean z() {
        return this.f4154n.getOptionalIconsVisible();
    }

    public b setContentDescription(CharSequence charSequence) {
        this.f4158r = charSequence;
        this.f4154n.onItemsChanged(false);
        return this;
    }

    public b setTooltipText(CharSequence charSequence) {
        this.f4159s = charSequence;
        this.f4154n.onItemsChanged(false);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c11, int i11) {
        if (this.f4150j == c11 && this.f4151k == i11) {
            return this;
        }
        this.f4150j = Character.toLowerCase(c11);
        this.f4151k = KeyEvent.normalizeMetaState(i11);
        this.f4154n.onItemsChanged(false);
        return this;
    }

    public MenuItem setNumericShortcut(char c11, int i11) {
        if (this.f4148h == c11 && this.f4149i == i11) {
            return this;
        }
        this.f4148h = c11;
        this.f4149i = KeyEvent.normalizeMetaState(i11);
        this.f4154n.onItemsChanged(false);
        return this;
    }

    public MenuItem setShortcut(char c11, char c12, int i11, int i12) {
        this.f4148h = c11;
        this.f4149i = KeyEvent.normalizeMetaState(i11);
        this.f4150j = Character.toLowerCase(c12);
        this.f4151k = KeyEvent.normalizeMetaState(i12);
        this.f4154n.onItemsChanged(false);
        return this;
    }

    public MenuItem setIcon(int i11) {
        this.f4152l = null;
        this.f4153m = i11;
        this.f4164x = true;
        this.f4154n.onItemsChanged(false);
        return this;
    }

    public MenuItem setTitle(int i11) {
        return setTitle((CharSequence) this.f4154n.getContext().getString(i11));
    }
}
