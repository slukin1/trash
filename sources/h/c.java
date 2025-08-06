package h;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.d;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;

public abstract class c implements e, i, AdapterView.OnItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    public Rect f15864b;

    public static int d(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i11) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i12 = 0;
        int i13 = 0;
        View view = null;
        for (int i14 = 0; i14 < count; i14++) {
            int itemViewType = listAdapter.getItemViewType(i14);
            if (itemViewType != i13) {
                view = null;
                i13 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i14, view, viewGroup);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i11) {
                return i11;
            }
            if (measuredWidth > i12) {
                i12 = measuredWidth;
            }
        }
        return i12;
    }

    public static boolean n(e eVar) {
        int size = eVar.size();
        for (int i11 = 0; i11 < size; i11++) {
            MenuItem item = eVar.getItem(i11);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    public static d o(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (d) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (d) listAdapter;
    }

    public abstract void a(e eVar);

    public boolean b() {
        return true;
    }

    public Rect c() {
        return this.f15864b;
    }

    public boolean collapseItemActionView(e eVar, g gVar) {
        return false;
    }

    public abstract void e(View view);

    public boolean expandItemActionView(e eVar, g gVar) {
        return false;
    }

    public void f(Rect rect) {
        this.f15864b = rect;
    }

    public abstract void g(boolean z11);

    public int getId() {
        return 0;
    }

    public abstract void i(int i11);

    public void initForMenu(Context context, e eVar) {
    }

    public abstract void j(int i11);

    public abstract void k(PopupWindow.OnDismissListener onDismissListener);

    public abstract void l(boolean z11);

    public abstract void m(int i11);

    public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        o(listAdapter).f4131b.performItemAction((MenuItem) listAdapter.getItem(i11), this, b() ? 0 : 4);
    }
}
