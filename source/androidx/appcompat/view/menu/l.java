package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.e;

public class l extends e implements SubMenu {
    private g mItem;
    private e mParentMenu;

    public l(Context context, e eVar, g gVar) {
        super(context);
        this.mParentMenu = eVar;
        this.mItem = gVar;
    }

    public boolean collapseItemActionView(g gVar) {
        return this.mParentMenu.collapseItemActionView(gVar);
    }

    public boolean dispatchMenuItemSelected(e eVar, MenuItem menuItem) {
        return super.dispatchMenuItemSelected(eVar, menuItem) || this.mParentMenu.dispatchMenuItemSelected(eVar, menuItem);
    }

    public boolean expandItemActionView(g gVar) {
        return this.mParentMenu.expandItemActionView(gVar);
    }

    public String getActionViewStatesKey() {
        g gVar = this.mItem;
        int itemId = gVar != null ? gVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.getActionViewStatesKey() + ":" + itemId;
    }

    public MenuItem getItem() {
        return this.mItem;
    }

    public Menu getParentMenu() {
        return this.mParentMenu;
    }

    public e getRootMenu() {
        return this.mParentMenu.getRootMenu();
    }

    public boolean isGroupDividerEnabled() {
        return this.mParentMenu.isGroupDividerEnabled();
    }

    public boolean isQwertyMode() {
        return this.mParentMenu.isQwertyMode();
    }

    public boolean isShortcutsVisible() {
        return this.mParentMenu.isShortcutsVisible();
    }

    public void setCallback(e.a aVar) {
        this.mParentMenu.setCallback(aVar);
    }

    public void setGroupDividerEnabled(boolean z11) {
        this.mParentMenu.setGroupDividerEnabled(z11);
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.setHeaderIconInt(drawable);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.setHeaderTitleInt(charSequence);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.setHeaderViewInt(view);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.mItem.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z11) {
        this.mParentMenu.setQwertyMode(z11);
    }

    public void setShortcutsVisible(boolean z11) {
        this.mParentMenu.setShortcutsVisible(z11);
    }

    public SubMenu setHeaderIcon(int i11) {
        return (SubMenu) super.setHeaderIconInt(i11);
    }

    public SubMenu setHeaderTitle(int i11) {
        return (SubMenu) super.setHeaderTitleInt(i11);
    }

    public SubMenu setIcon(int i11) {
        this.mItem.setIcon(i11);
        return this;
    }
}
