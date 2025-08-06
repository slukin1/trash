package h;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import v0.c;

public class f extends d implements SubMenu {

    /* renamed from: e  reason: collision with root package name */
    public final c f15866e;

    public f(Context context, c cVar) {
        super(context, cVar);
        this.f15866e = cVar;
    }

    public void clearHeader() {
        this.f15866e.clearHeader();
    }

    public MenuItem getItem() {
        return c(this.f15866e.getItem());
    }

    public SubMenu setHeaderIcon(int i11) {
        this.f15866e.setHeaderIcon(i11);
        return this;
    }

    public SubMenu setHeaderTitle(int i11) {
        this.f15866e.setHeaderTitle(i11);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        this.f15866e.setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i11) {
        this.f15866e.setIcon(i11);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f15866e.setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f15866e.setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f15866e.setIcon(drawable);
        return this;
    }
}
