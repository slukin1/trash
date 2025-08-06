package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.a;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;

public class ActionMenuPresenter extends androidx.appcompat.view.menu.a implements a.C0026a {
    public a A;
    public c B;
    public b C;
    public final e D = new e();
    public int E;

    /* renamed from: l  reason: collision with root package name */
    public OverflowMenuButton f4267l;

    /* renamed from: m  reason: collision with root package name */
    public Drawable f4268m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f4269n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f4270o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f4271p;

    /* renamed from: q  reason: collision with root package name */
    public int f4272q;

    /* renamed from: r  reason: collision with root package name */
    public int f4273r;

    /* renamed from: s  reason: collision with root package name */
    public int f4274s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f4275t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f4276u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f4277v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f4278w;

    /* renamed from: x  reason: collision with root package name */
    public int f4279x;

    /* renamed from: y  reason: collision with root package name */
    public final SparseBooleanArray f4280y = new SparseBooleanArray();

    /* renamed from: z  reason: collision with root package name */
    public d f4281z;

    public class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.a {

        public class a extends t {

            /* renamed from: k  reason: collision with root package name */
            public final /* synthetic */ ActionMenuPresenter f4283k;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(View view, ActionMenuPresenter actionMenuPresenter) {
                super(view);
                this.f4283k = actionMenuPresenter;
            }

            public h.e b() {
                d dVar = ActionMenuPresenter.this.f4281z;
                if (dVar == null) {
                    return null;
                }
                return dVar.c();
            }

            public boolean c() {
                ActionMenuPresenter.this.D();
                return true;
            }

            public boolean d() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.B != null) {
                    return false;
                }
                actionMenuPresenter.u();
                return true;
            }
        }

        public OverflowMenuButton(Context context) {
            super(context, (AttributeSet) null, R$attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            i0.a(this, getContentDescription());
            setOnTouchListener(new a(this, ActionMenuPresenter.this));
        }

        public boolean a() {
            return false;
        }

        public boolean b() {
            return false;
        }

        @SensorsDataInstrumented
        public boolean performClick() {
            if (super.performClick()) {
                SensorsDataAutoTrackHelper.trackViewOnClick(this);
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.D();
            SensorsDataAutoTrackHelper.trackViewOnClick(this);
            return true;
        }

        public boolean setFrame(int i11, int i12, int i13, int i14) {
            boolean frame = super.setFrame(i11, i12, i13, i14);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                u0.a.l(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int openSubMenuId;

        public class a implements Parcelable.Creator<SavedState> {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.openSubMenuId);
        }

        public SavedState(Parcel parcel) {
            this.openSubMenuId = parcel.readInt();
        }
    }

    public class a extends h {
        public a(Context context, l lVar, View view) {
            super(context, lVar, view, false, R$attr.actionOverflowMenuStyle);
            if (!((g) lVar.getItem()).l()) {
                View view2 = ActionMenuPresenter.this.f4267l;
                f(view2 == null ? (View) ActionMenuPresenter.this.f4083j : view2);
            }
            j(ActionMenuPresenter.this.D);
        }

        public void e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.A = null;
            actionMenuPresenter.E = 0;
            super.e();
        }
    }

    public class b extends ActionMenuItemView.PopupCallback {
        public b() {
        }

        public h.e a() {
            a aVar = ActionMenuPresenter.this.A;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public d f4287b;

        public c(d dVar) {
            this.f4287b = dVar;
        }

        public void run() {
            if (ActionMenuPresenter.this.f4077d != null) {
                ActionMenuPresenter.this.f4077d.changeMenuMode();
            }
            View view = (View) ActionMenuPresenter.this.f4083j;
            if (!(view == null || view.getWindowToken() == null || !this.f4287b.m())) {
                ActionMenuPresenter.this.f4281z = this.f4287b;
            }
            ActionMenuPresenter.this.B = null;
        }
    }

    public class d extends h {
        public d(Context context, androidx.appcompat.view.menu.e eVar, View view, boolean z11) {
            super(context, eVar, view, z11, R$attr.actionOverflowMenuStyle);
            h(8388613);
            j(ActionMenuPresenter.this.D);
        }

        public void e() {
            if (ActionMenuPresenter.this.f4077d != null) {
                ActionMenuPresenter.this.f4077d.close();
            }
            ActionMenuPresenter.this.f4281z = null;
            super.e();
        }
    }

    public class e implements i.a {
        public e() {
        }

        public boolean a(androidx.appcompat.view.menu.e eVar) {
            if (eVar == ActionMenuPresenter.this.f4077d) {
                return false;
            }
            ActionMenuPresenter.this.E = ((l) eVar).getItem().getItemId();
            i.a f11 = ActionMenuPresenter.this.f();
            if (f11 != null) {
                return f11.a(eVar);
            }
            return false;
        }

        public void onCloseMenu(androidx.appcompat.view.menu.e eVar, boolean z11) {
            if (eVar instanceof l) {
                eVar.getRootMenu().close(false);
            }
            i.a f11 = ActionMenuPresenter.this.f();
            if (f11 != null) {
                f11.onCloseMenu(eVar, z11);
            }
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, R$layout.abc_action_menu_layout, R$layout.abc_action_menu_item_layout);
    }

    public void A(ActionMenuView actionMenuView) {
        this.f4083j = actionMenuView;
        actionMenuView.initialize(this.f4077d);
    }

    public void B(Drawable drawable) {
        OverflowMenuButton overflowMenuButton = this.f4267l;
        if (overflowMenuButton != null) {
            overflowMenuButton.setImageDrawable(drawable);
            return;
        }
        this.f4269n = true;
        this.f4268m = drawable;
    }

    public void C(boolean z11) {
        this.f4270o = z11;
        this.f4271p = true;
    }

    public boolean D() {
        androidx.appcompat.view.menu.e eVar;
        if (!this.f4270o || x() || (eVar = this.f4077d) == null || this.f4083j == null || this.B != null || eVar.getNonActionItems().isEmpty()) {
            return false;
        }
        c cVar = new c(new d(this.f4076c, this.f4077d, this.f4267l, true));
        this.B = cVar;
        ((View) this.f4083j).post(cVar);
        return true;
    }

    public void a(boolean z11) {
        if (z11) {
            super.onSubMenuSelected((l) null);
            return;
        }
        androidx.appcompat.view.menu.e eVar = this.f4077d;
        if (eVar != null) {
            eVar.close(false);
        }
    }

    public void c(g gVar, j.a aVar) {
        aVar.initialize(gVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f4083j);
        if (this.C == null) {
            this.C = new b();
        }
        actionMenuItemView.setPopupCallback(this.C);
    }

    public boolean e(ViewGroup viewGroup, int i11) {
        if (viewGroup.getChildAt(i11) == this.f4267l) {
            return false;
        }
        return super.e(viewGroup, i11);
    }

    public boolean flagActionItems() {
        int i11;
        ArrayList<g> arrayList;
        int i12;
        int i13;
        int i14;
        boolean z11;
        ActionMenuPresenter actionMenuPresenter = this;
        androidx.appcompat.view.menu.e eVar = actionMenuPresenter.f4077d;
        View view = null;
        boolean z12 = false;
        if (eVar != null) {
            arrayList = eVar.getVisibleItems();
            i11 = arrayList.size();
        } else {
            arrayList = null;
            i11 = 0;
        }
        int i15 = actionMenuPresenter.f4274s;
        int i16 = actionMenuPresenter.f4273r;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f4083j;
        boolean z13 = false;
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < i11; i19++) {
            g gVar = arrayList.get(i19);
            if (gVar.o()) {
                i17++;
            } else if (gVar.n()) {
                i18++;
            } else {
                z13 = true;
            }
            if (actionMenuPresenter.f4278w && gVar.isActionViewExpanded()) {
                i15 = 0;
            }
        }
        if (actionMenuPresenter.f4270o && (z13 || i18 + i17 > i15)) {
            i15--;
        }
        int i21 = i15 - i17;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.f4280y;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.f4276u) {
            int i22 = actionMenuPresenter.f4279x;
            i12 = i16 / i22;
            i13 = i22 + ((i16 % i22) / i12);
        } else {
            i13 = 0;
            i12 = 0;
        }
        int i23 = 0;
        int i24 = 0;
        while (i23 < i11) {
            g gVar2 = arrayList.get(i23);
            if (gVar2.o()) {
                View g11 = actionMenuPresenter.g(gVar2, view, viewGroup);
                if (actionMenuPresenter.f4276u) {
                    i12 -= ActionMenuView.l(g11, i13, i12, makeMeasureSpec, z12 ? 1 : 0);
                } else {
                    g11.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = g11.getMeasuredWidth();
                i16 -= measuredWidth;
                if (i24 == 0) {
                    i24 = measuredWidth;
                }
                int groupId = gVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                gVar2.u(true);
                z11 = z12;
                i14 = i11;
            } else if (gVar2.n()) {
                int groupId2 = gVar2.getGroupId();
                boolean z14 = sparseBooleanArray.get(groupId2);
                boolean z15 = (i21 > 0 || z14) && i16 > 0 && (!actionMenuPresenter.f4276u || i12 > 0);
                boolean z16 = z15;
                i14 = i11;
                if (z15) {
                    View g12 = actionMenuPresenter.g(gVar2, (View) null, viewGroup);
                    if (actionMenuPresenter.f4276u) {
                        int l11 = ActionMenuView.l(g12, i13, i12, makeMeasureSpec, 0);
                        i12 -= l11;
                        if (l11 == 0) {
                            z16 = false;
                        }
                    } else {
                        g12.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z17 = z16;
                    int measuredWidth2 = g12.getMeasuredWidth();
                    i16 -= measuredWidth2;
                    if (i24 == 0) {
                        i24 = measuredWidth2;
                    }
                    z15 = z17 & (!actionMenuPresenter.f4276u ? i16 + i24 > 0 : i16 >= 0);
                }
                if (z15 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z14) {
                    sparseBooleanArray.put(groupId2, false);
                    int i25 = 0;
                    while (i25 < i23) {
                        g gVar3 = arrayList.get(i25);
                        if (gVar3.getGroupId() == groupId2) {
                            if (gVar3.l()) {
                                i21++;
                            }
                            gVar3.u(false);
                        }
                        i25++;
                    }
                }
                if (z15) {
                    i21--;
                }
                gVar2.u(z15);
                z11 = false;
            } else {
                z11 = z12;
                i14 = i11;
                gVar2.u(z11);
            }
            i23++;
            z12 = z11;
            i11 = i14;
            view = null;
            actionMenuPresenter = this;
        }
        return true;
    }

    public View g(g gVar, View view, ViewGroup viewGroup) {
        View actionView = gVar.getActionView();
        if (actionView == null || gVar.j()) {
            actionView = super.g(gVar, view, viewGroup);
        }
        actionView.setVisibility(gVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    public j h(ViewGroup viewGroup) {
        j jVar = this.f4083j;
        j h11 = super.h(viewGroup);
        if (jVar != h11) {
            ((ActionMenuView) h11).setPresenter(this);
        }
        return h11;
    }

    public void initForMenu(Context context, androidx.appcompat.view.menu.e eVar) {
        super.initForMenu(context, eVar);
        Resources resources = context.getResources();
        g.a b11 = g.a.b(context);
        if (!this.f4271p) {
            this.f4270o = b11.h();
        }
        if (!this.f4277v) {
            this.f4272q = b11.c();
        }
        if (!this.f4275t) {
            this.f4274s = b11.d();
        }
        int i11 = this.f4272q;
        if (this.f4270o) {
            if (this.f4267l == null) {
                OverflowMenuButton overflowMenuButton = new OverflowMenuButton(this.f4075b);
                this.f4267l = overflowMenuButton;
                if (this.f4269n) {
                    overflowMenuButton.setImageDrawable(this.f4268m);
                    this.f4268m = null;
                    this.f4269n = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f4267l.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i11 -= this.f4267l.getMeasuredWidth();
        } else {
            this.f4267l = null;
        }
        this.f4273r = i11;
        this.f4279x = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public boolean j(int i11, g gVar) {
        return gVar.l();
    }

    public void onCloseMenu(androidx.appcompat.view.menu.e eVar, boolean z11) {
        r();
        super.onCloseMenu(eVar, z11);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        int i11;
        MenuItem findItem;
        if ((parcelable instanceof SavedState) && (i11 = ((SavedState) parcelable).openSubMenuId) > 0 && (findItem = this.f4077d.findItem(i11)) != null) {
            onSubMenuSelected((l) findItem.getSubMenu());
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.openSubMenuId = this.E;
        return savedState;
    }

    public boolean onSubMenuSelected(l lVar) {
        boolean z11 = false;
        if (!lVar.hasVisibleItems()) {
            return false;
        }
        l lVar2 = lVar;
        while (lVar2.getParentMenu() != this.f4077d) {
            lVar2 = (l) lVar2.getParentMenu();
        }
        View s11 = s(lVar2.getItem());
        if (s11 == null) {
            return false;
        }
        this.E = lVar.getItem().getItemId();
        int size = lVar.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                break;
            }
            MenuItem item = lVar.getItem(i11);
            if (item.isVisible() && item.getIcon() != null) {
                z11 = true;
                break;
            }
            i11++;
        }
        a aVar = new a(this.f4076c, lVar, s11);
        this.A = aVar;
        aVar.g(z11);
        this.A.k();
        super.onSubMenuSelected(lVar);
        return true;
    }

    public boolean r() {
        return u() | v();
    }

    public final View s(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f4083j;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if ((childAt instanceof j.a) && ((j.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public Drawable t() {
        OverflowMenuButton overflowMenuButton = this.f4267l;
        if (overflowMenuButton != null) {
            return overflowMenuButton.getDrawable();
        }
        if (this.f4269n) {
            return this.f4268m;
        }
        return null;
    }

    public boolean u() {
        j jVar;
        c cVar = this.B;
        if (cVar == null || (jVar = this.f4083j) == null) {
            d dVar = this.f4281z;
            if (dVar == null) {
                return false;
            }
            dVar.b();
            return true;
        }
        ((View) jVar).removeCallbacks(cVar);
        this.B = null;
        return true;
    }

    public void updateMenuView(boolean z11) {
        j jVar;
        super.updateMenuView(z11);
        ((View) this.f4083j).requestLayout();
        androidx.appcompat.view.menu.e eVar = this.f4077d;
        boolean z12 = false;
        if (eVar != null) {
            ArrayList<g> actionItems = eVar.getActionItems();
            int size = actionItems.size();
            for (int i11 = 0; i11 < size; i11++) {
                androidx.core.view.a a11 = actionItems.get(i11).a();
                if (a11 != null) {
                    a11.i(this);
                }
            }
        }
        androidx.appcompat.view.menu.e eVar2 = this.f4077d;
        ArrayList<g> nonActionItems = eVar2 != null ? eVar2.getNonActionItems() : null;
        if (this.f4270o && nonActionItems != null) {
            int size2 = nonActionItems.size();
            if (size2 == 1) {
                z12 = !nonActionItems.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z12 = true;
            }
        }
        if (z12) {
            if (this.f4267l == null) {
                this.f4267l = new OverflowMenuButton(this.f4075b);
            }
            ViewGroup viewGroup = (ViewGroup) this.f4267l.getParent();
            if (viewGroup != this.f4083j) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f4267l);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f4083j;
                actionMenuView.addView(this.f4267l, actionMenuView.f());
            }
        } else {
            OverflowMenuButton overflowMenuButton = this.f4267l;
            if (overflowMenuButton != null && overflowMenuButton.getParent() == (jVar = this.f4083j)) {
                ((ViewGroup) jVar).removeView(this.f4267l);
            }
        }
        ((ActionMenuView) this.f4083j).setOverflowReserved(this.f4270o);
    }

    public boolean v() {
        a aVar = this.A;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean w() {
        return this.B != null || x();
    }

    public boolean x() {
        d dVar = this.f4281z;
        return dVar != null && dVar.d();
    }

    public void y(Configuration configuration) {
        if (!this.f4275t) {
            this.f4274s = g.a.b(this.f4076c).d();
        }
        androidx.appcompat.view.menu.e eVar = this.f4077d;
        if (eVar != null) {
            eVar.onItemsChanged(true);
        }
    }

    public void z(boolean z11) {
        this.f4278w = z11;
    }
}
