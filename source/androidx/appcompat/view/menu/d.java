package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.j;
import java.util.ArrayList;

public class d extends BaseAdapter {

    /* renamed from: b  reason: collision with root package name */
    public e f4131b;

    /* renamed from: c  reason: collision with root package name */
    public int f4132c = -1;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4133d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f4134e;

    /* renamed from: f  reason: collision with root package name */
    public final LayoutInflater f4135f;

    /* renamed from: g  reason: collision with root package name */
    public final int f4136g;

    public d(e eVar, LayoutInflater layoutInflater, boolean z11, int i11) {
        this.f4134e = z11;
        this.f4135f = layoutInflater;
        this.f4131b = eVar;
        this.f4136g = i11;
        a();
    }

    public void a() {
        g expandedItem = this.f4131b.getExpandedItem();
        if (expandedItem != null) {
            ArrayList<g> nonActionItems = this.f4131b.getNonActionItems();
            int size = nonActionItems.size();
            for (int i11 = 0; i11 < size; i11++) {
                if (nonActionItems.get(i11) == expandedItem) {
                    this.f4132c = i11;
                    return;
                }
            }
        }
        this.f4132c = -1;
    }

    public e b() {
        return this.f4131b;
    }

    /* renamed from: c */
    public g getItem(int i11) {
        ArrayList<g> nonActionItems = this.f4134e ? this.f4131b.getNonActionItems() : this.f4131b.getVisibleItems();
        int i12 = this.f4132c;
        if (i12 >= 0 && i11 >= i12) {
            i11++;
        }
        return nonActionItems.get(i11);
    }

    public void d(boolean z11) {
        this.f4133d = z11;
    }

    public int getCount() {
        ArrayList<g> nonActionItems = this.f4134e ? this.f4131b.getNonActionItems() : this.f4131b.getVisibleItems();
        if (this.f4132c < 0) {
            return nonActionItems.size();
        }
        return nonActionItems.size() - 1;
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    public View getView(int i11, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f4135f.inflate(this.f4136g, viewGroup, false);
        }
        int groupId = getItem(i11).getGroupId();
        int i12 = i11 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f4131b.isGroupDividerEnabled() && groupId != (i12 >= 0 ? getItem(i12).getGroupId() : groupId));
        j.a aVar = (j.a) view;
        if (this.f4133d) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.initialize(getItem(i11), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
