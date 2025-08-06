package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.a;
import java.lang.reflect.Method;

public class MenuItemWrapperICS extends h.b implements MenuItem {

    /* renamed from: d  reason: collision with root package name */
    public final v0.b f4064d;

    /* renamed from: e  reason: collision with root package name */
    public Method f4065e;

    public static class CollapsibleActionViewWrapper extends FrameLayout implements g.b {

        /* renamed from: b  reason: collision with root package name */
        public final CollapsibleActionView f4066b;

        public CollapsibleActionViewWrapper(View view) {
            super(view.getContext());
            this.f4066b = (CollapsibleActionView) view;
            addView(view);
        }

        public View a() {
            return (View) this.f4066b;
        }

        public void onActionViewCollapsed() {
            this.f4066b.onActionViewCollapsed();
        }

        public void onActionViewExpanded() {
            this.f4066b.onActionViewExpanded();
        }
    }

    public class a extends androidx.core.view.a {

        /* renamed from: d  reason: collision with root package name */
        public final ActionProvider f4067d;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f4067d = actionProvider;
        }

        public boolean a() {
            return this.f4067d.hasSubMenu();
        }

        public View c() {
            return this.f4067d.onCreateActionView();
        }

        public boolean e() {
            return this.f4067d.onPerformDefaultAction();
        }

        public void f(SubMenu subMenu) {
            this.f4067d.onPrepareSubMenu(MenuItemWrapperICS.this.d(subMenu));
        }
    }

    public class b extends a implements ActionProvider.VisibilityListener {

        /* renamed from: f  reason: collision with root package name */
        public a.b f4069f;

        public b(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public boolean b() {
            return this.f4067d.isVisible();
        }

        public View d(MenuItem menuItem) {
            return this.f4067d.onCreateActionView(menuItem);
        }

        public boolean g() {
            return this.f4067d.overridesItemVisibility();
        }

        public void j(a.b bVar) {
            this.f4069f = bVar;
            this.f4067d.setVisibilityListener(bVar != null ? this : null);
        }

        public void onActionProviderVisibilityChanged(boolean z11) {
            a.b bVar = this.f4069f;
            if (bVar != null) {
                bVar.onActionProviderVisibilityChanged(z11);
            }
        }
    }

    public class c implements MenuItem.OnActionExpandListener {

        /* renamed from: a  reason: collision with root package name */
        public final MenuItem.OnActionExpandListener f4071a;

        public c(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f4071a = onActionExpandListener;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f4071a.onMenuItemActionCollapse(MenuItemWrapperICS.this.c(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f4071a.onMenuItemActionExpand(MenuItemWrapperICS.this.c(menuItem));
        }
    }

    public class d implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final MenuItem.OnMenuItemClickListener f4073a;

        public d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f4073a = onMenuItemClickListener;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f4073a.onMenuItemClick(MenuItemWrapperICS.this.c(menuItem));
        }
    }

    public MenuItemWrapperICS(Context context, v0.b bVar) {
        super(context);
        if (bVar != null) {
            this.f4064d = bVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public boolean collapseActionView() {
        return this.f4064d.collapseActionView();
    }

    public boolean expandActionView() {
        return this.f4064d.expandActionView();
    }

    public ActionProvider getActionProvider() {
        androidx.core.view.a a11 = this.f4064d.a();
        if (a11 instanceof a) {
            return ((a) a11).f4067d;
        }
        return null;
    }

    public View getActionView() {
        View actionView = this.f4064d.getActionView();
        return actionView instanceof CollapsibleActionViewWrapper ? ((CollapsibleActionViewWrapper) actionView).a() : actionView;
    }

    public int getAlphabeticModifiers() {
        return this.f4064d.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.f4064d.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.f4064d.getContentDescription();
    }

    public int getGroupId() {
        return this.f4064d.getGroupId();
    }

    public Drawable getIcon() {
        return this.f4064d.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.f4064d.getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f4064d.getIconTintMode();
    }

    public Intent getIntent() {
        return this.f4064d.getIntent();
    }

    public int getItemId() {
        return this.f4064d.getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f4064d.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.f4064d.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.f4064d.getNumericShortcut();
    }

    public int getOrder() {
        return this.f4064d.getOrder();
    }

    public SubMenu getSubMenu() {
        return d(this.f4064d.getSubMenu());
    }

    public CharSequence getTitle() {
        return this.f4064d.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.f4064d.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.f4064d.getTooltipText();
    }

    public void h(boolean z11) {
        try {
            if (this.f4065e == null) {
                this.f4065e = this.f4064d.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f4065e.invoke(this.f4064d, new Object[]{Boolean.valueOf(z11)});
        } catch (Exception e11) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e11);
        }
    }

    public boolean hasSubMenu() {
        return this.f4064d.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.f4064d.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.f4064d.isCheckable();
    }

    public boolean isChecked() {
        return this.f4064d.isChecked();
    }

    public boolean isEnabled() {
        return this.f4064d.isEnabled();
    }

    public boolean isVisible() {
        return this.f4064d.isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        androidx.core.view.a aVar;
        if (Build.VERSION.SDK_INT >= 16) {
            aVar = new b(this.f15861a, actionProvider);
        } else {
            aVar = new a(this.f15861a, actionProvider);
        }
        v0.b bVar = this.f4064d;
        if (actionProvider == null) {
            aVar = null;
        }
        bVar.b(aVar);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new CollapsibleActionViewWrapper(view);
        }
        this.f4064d.setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c11) {
        this.f4064d.setAlphabeticShortcut(c11);
        return this;
    }

    public MenuItem setCheckable(boolean z11) {
        this.f4064d.setCheckable(z11);
        return this;
    }

    public MenuItem setChecked(boolean z11) {
        this.f4064d.setChecked(z11);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f4064d.setContentDescription(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z11) {
        this.f4064d.setEnabled(z11);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f4064d.setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f4064d.setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f4064d.setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f4064d.setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c11) {
        this.f4064d.setNumericShortcut(c11);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f4064d.setOnActionExpandListener(onActionExpandListener != null ? new c(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f4064d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c11, char c12) {
        this.f4064d.setShortcut(c11, c12);
        return this;
    }

    public void setShowAsAction(int i11) {
        this.f4064d.setShowAsAction(i11);
    }

    public MenuItem setShowAsActionFlags(int i11) {
        this.f4064d.setShowAsActionFlags(i11);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f4064d.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f4064d.setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f4064d.setTooltipText(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z11) {
        return this.f4064d.setVisible(z11);
    }

    public MenuItem setAlphabeticShortcut(char c11, int i11) {
        this.f4064d.setAlphabeticShortcut(c11, i11);
        return this;
    }

    public MenuItem setIcon(int i11) {
        this.f4064d.setIcon(i11);
        return this;
    }

    public MenuItem setNumericShortcut(char c11, int i11) {
        this.f4064d.setNumericShortcut(c11, i11);
        return this;
    }

    public MenuItem setShortcut(char c11, char c12, int i11, int i12) {
        this.f4064d.setShortcut(c11, c12, i11, i12);
        return this;
    }

    public MenuItem setTitle(int i11) {
        this.f4064d.setTitle(i11);
        return this;
    }

    public MenuItem setActionView(int i11) {
        this.f4064d.setActionView(i11);
        View actionView = this.f4064d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f4064d.setActionView((View) new CollapsibleActionViewWrapper(actionView));
        }
        return this;
    }
}
