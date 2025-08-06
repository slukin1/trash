package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.d;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import java.lang.reflect.Method;

public class MenuPopupWindow extends ListPopupWindow implements u {
    public static Method L;
    public u K;

    public static class MenuDropDownListView extends DropDownListView {

        /* renamed from: o  reason: collision with root package name */
        public final int f4456o;

        /* renamed from: p  reason: collision with root package name */
        public final int f4457p;

        /* renamed from: q  reason: collision with root package name */
        public u f4458q;

        /* renamed from: r  reason: collision with root package name */
        public MenuItem f4459r;

        public static class a {
            public static int a(Configuration configuration) {
                return configuration.getLayoutDirection();
            }
        }

        public MenuDropDownListView(Context context, boolean z11) {
            super(context, z11);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT < 17 || 1 != a.a(configuration)) {
                this.f4456o = 22;
                this.f4457p = 21;
                return;
            }
            this.f4456o = 21;
            this.f4457p = 22;
        }

        public /* bridge */ /* synthetic */ int d(int i11, int i12, int i13, int i14, int i15) {
            return super.d(i11, i12, i13, i14, i15);
        }

        public /* bridge */ /* synthetic */ boolean e(MotionEvent motionEvent, int i11) {
            return super.e(motionEvent, i11);
        }

        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i11;
            d dVar;
            int pointToPosition;
            int i12;
            if (this.f4458q != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i11 = headerViewListAdapter.getHeadersCount();
                    dVar = (d) headerViewListAdapter.getWrappedAdapter();
                } else {
                    i11 = 0;
                    dVar = (d) adapter;
                }
                g gVar = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i12 = pointToPosition - i11) >= 0 && i12 < dVar.getCount()) {
                    gVar = dVar.getItem(i12);
                }
                MenuItem menuItem = this.f4459r;
                if (menuItem != gVar) {
                    e b11 = dVar.b();
                    if (menuItem != null) {
                        this.f4458q.g(b11, menuItem);
                    }
                    this.f4459r = gVar;
                    if (gVar != null) {
                        this.f4458q.a(b11, gVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onKeyDown(int i11, KeyEvent keyEvent) {
            d dVar;
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i11 == this.f4456o) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i11 != this.f4457p) {
                return super.onKeyDown(i11, keyEvent);
            } else {
                setSelection(-1);
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    dVar = (d) ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                } else {
                    dVar = (d) adapter;
                }
                dVar.b().close(false);
                return true;
            }
        }

        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(u uVar) {
            this.f4458q = uVar;
        }

        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    public static class a {
        public static void a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        public static void b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    public static class b {
        public static void a(PopupWindow popupWindow, boolean z11) {
            popupWindow.setTouchModal(z11);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                L = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public MenuPopupWindow(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
    }

    public void O(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.a(this.G, (Transition) obj);
        }
    }

    public void P(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            a.b(this.G, (Transition) obj);
        }
    }

    public void Q(u uVar) {
        this.K = uVar;
    }

    public void R(boolean z11) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = L;
            if (method != null) {
                try {
                    method.invoke(this.G, new Object[]{Boolean.valueOf(z11)});
                } catch (Exception unused) {
                    Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                }
            }
        } else {
            b.a(this.G, z11);
        }
    }

    public void a(e eVar, MenuItem menuItem) {
        u uVar = this.K;
        if (uVar != null) {
            uVar.a(eVar, menuItem);
        }
    }

    public void g(e eVar, MenuItem menuItem) {
        u uVar = this.K;
        if (uVar != null) {
            uVar.g(eVar, menuItem);
        }
    }

    public DropDownListView p(Context context, boolean z11) {
        MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z11);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }
}
