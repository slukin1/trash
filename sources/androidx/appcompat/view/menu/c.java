package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import java.util.ArrayList;

public class c implements i, AdapterView.OnItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    public Context f4119b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f4120c;

    /* renamed from: d  reason: collision with root package name */
    public e f4121d;

    /* renamed from: e  reason: collision with root package name */
    public ExpandedMenuView f4122e;

    /* renamed from: f  reason: collision with root package name */
    public int f4123f;

    /* renamed from: g  reason: collision with root package name */
    public int f4124g;

    /* renamed from: h  reason: collision with root package name */
    public int f4125h;

    /* renamed from: i  reason: collision with root package name */
    public i.a f4126i;

    /* renamed from: j  reason: collision with root package name */
    public a f4127j;

    /* renamed from: k  reason: collision with root package name */
    public int f4128k;

    public class a extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        public int f4129b = -1;

        public a() {
            a();
        }

        public void a() {
            g expandedItem = c.this.f4121d.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<g> nonActionItems = c.this.f4121d.getNonActionItems();
                int size = nonActionItems.size();
                for (int i11 = 0; i11 < size; i11++) {
                    if (nonActionItems.get(i11) == expandedItem) {
                        this.f4129b = i11;
                        return;
                    }
                }
            }
            this.f4129b = -1;
        }

        /* renamed from: b */
        public g getItem(int i11) {
            ArrayList<g> nonActionItems = c.this.f4121d.getNonActionItems();
            int i12 = i11 + c.this.f4123f;
            int i13 = this.f4129b;
            if (i13 >= 0 && i12 >= i13) {
                i12++;
            }
            return nonActionItems.get(i12);
        }

        public int getCount() {
            int size = c.this.f4121d.getNonActionItems().size() - c.this.f4123f;
            return this.f4129b < 0 ? size : size - 1;
        }

        public long getItemId(int i11) {
            return (long) i11;
        }

        public View getView(int i11, View view, ViewGroup viewGroup) {
            if (view == null) {
                c cVar = c.this;
                view = cVar.f4120c.inflate(cVar.f4125h, viewGroup, false);
            }
            ((j.a) view).initialize(getItem(i11), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public c(Context context, int i11) {
        this(i11, 0);
        this.f4119b = context;
        this.f4120c = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.f4127j == null) {
            this.f4127j = new a();
        }
        return this.f4127j;
    }

    public j b(ViewGroup viewGroup) {
        if (this.f4122e == null) {
            this.f4122e = (ExpandedMenuView) this.f4120c.inflate(R$layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f4127j == null) {
                this.f4127j = new a();
            }
            this.f4122e.setAdapter(this.f4127j);
            this.f4122e.setOnItemClickListener(this);
        }
        return this.f4122e;
    }

    public void c(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f4122e.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public boolean collapseItemActionView(e eVar, g gVar) {
        return false;
    }

    public void d(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        ExpandedMenuView expandedMenuView = this.f4122e;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    public boolean expandItemActionView(e eVar, g gVar) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getId() {
        return this.f4128k;
    }

    public void initForMenu(Context context, e eVar) {
        if (this.f4124g != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f4124g);
            this.f4119b = contextThemeWrapper;
            this.f4120c = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f4119b != null) {
            this.f4119b = context;
            if (this.f4120c == null) {
                this.f4120c = LayoutInflater.from(context);
            }
        }
        this.f4121d = eVar;
        a aVar = this.f4127j;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void onCloseMenu(e eVar, boolean z11) {
        i.a aVar = this.f4126i;
        if (aVar != null) {
            aVar.onCloseMenu(eVar, z11);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
        this.f4121d.performItemAction(this.f4127j.getItem(i11), this, 0);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        c((Bundle) parcelable);
    }

    public Parcelable onSaveInstanceState() {
        if (this.f4122e == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        d(bundle);
        return bundle;
    }

    public boolean onSubMenuSelected(l lVar) {
        if (!lVar.hasVisibleItems()) {
            return false;
        }
        new f(lVar).c((IBinder) null);
        i.a aVar = this.f4126i;
        if (aVar == null) {
            return true;
        }
        aVar.a(lVar);
        return true;
    }

    public void setCallback(i.a aVar) {
        this.f4126i = aVar;
    }

    public void updateMenuView(boolean z11) {
        a aVar = this.f4127j;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public c(int i11, int i12) {
        this.f4125h = i11;
        this.f4124g = i12;
    }
}
