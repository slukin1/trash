package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.core.view.h0;
import androidx.core.view.j;
import androidx.customview.view.AbsSavedState;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Toolbar extends ViewGroup implements j {
    private static final String TAG = "Toolbar";
    private i.a mActionMenuPresenterCallback;
    private OnBackInvokedCallback mBackInvokedCallback;
    private boolean mBackInvokedCallbackEnabled;
    private OnBackInvokedDispatcher mBackInvokedDispatcher;
    public int mButtonGravity;
    public ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private x mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    public View mExpandedActionView;
    private f mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList<View> mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    public e.a mMenuBuilderCallback;
    public final MenuHostHelper mMenuHostHelper;
    public ActionMenuView mMenuView;
    private final ActionMenuView.d mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    public g mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private ArrayList<MenuItem> mProvidedMenuItems;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private ColorStateList mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private ColorStateList mTitleTextColor;
    private TextView mTitleTextView;
    private h0 mWrapper;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int expandedMenuItemId;
        public boolean isOverflowOpen;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.expandedMenuItemId);
            parcel.writeInt(this.isOverflowOpen ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.expandedMenuItemId = parcel.readInt();
            this.isOverflowOpen = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public class a implements ActionMenuView.d {
        public a() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.mMenuHostHelper.j(menuItem)) {
                return true;
            }
            g gVar = Toolbar.this.mOnMenuItemClickListener;
            if (gVar != null) {
                return gVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            Toolbar.this.showOverflowMenu();
        }
    }

    public class c implements e.a {
        public c() {
        }

        public boolean onMenuItemSelected(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            e.a aVar = Toolbar.this.mMenuBuilderCallback;
            return aVar != null && aVar.onMenuItemSelected(eVar, menuItem);
        }

        public void onMenuModeChange(androidx.appcompat.view.menu.e eVar) {
            if (!Toolbar.this.mMenuView.j()) {
                Toolbar.this.mMenuHostHelper.k(eVar);
            }
            e.a aVar = Toolbar.this.mMenuBuilderCallback;
            if (aVar != null) {
                aVar.onMenuModeChange(eVar);
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            Toolbar.this.collapseActionView();
        }
    }

    public static class e {
        public static OnBackInvokedDispatcher a(View view) {
            return view.findOnBackInvokedDispatcher();
        }

        public static OnBackInvokedCallback b(Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new g0(runnable);
        }

        public static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        public static void d(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    public class f implements i {

        /* renamed from: b  reason: collision with root package name */
        public androidx.appcompat.view.menu.e f4529b;

        /* renamed from: c  reason: collision with root package name */
        public androidx.appcompat.view.menu.g f4530c;

        public f() {
        }

        public boolean collapseItemActionView(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            View view = Toolbar.this.mExpandedActionView;
            if (view instanceof g.b) {
                ((g.b) view).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.mExpandedActionView);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.mCollapseButtonView);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.mExpandedActionView = null;
            toolbar3.addChildrenForExpandedActionView();
            this.f4530c = null;
            Toolbar.this.requestLayout();
            gVar.r(false);
            Toolbar.this.updateBackInvokedCallbackState();
            return true;
        }

        public boolean expandItemActionView(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            Toolbar.this.ensureCollapseButtonView();
            ViewParent parent = Toolbar.this.mCollapseButtonView.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.mCollapseButtonView);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.mCollapseButtonView);
            }
            Toolbar.this.mExpandedActionView = gVar.getActionView();
            this.f4530c = gVar;
            ViewParent parent2 = Toolbar.this.mExpandedActionView.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.mExpandedActionView);
                }
                LayoutParams generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                generateDefaultLayoutParams.f3729a = 8388611 | (toolbar4.mButtonGravity & 112);
                generateDefaultLayoutParams.f4524b = 2;
                toolbar4.mExpandedActionView.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.mExpandedActionView);
            }
            Toolbar.this.removeChildrenForExpandedActionView();
            Toolbar.this.requestLayout();
            gVar.r(true);
            View view = Toolbar.this.mExpandedActionView;
            if (view instanceof g.b) {
                ((g.b) view).onActionViewExpanded();
            }
            Toolbar.this.updateBackInvokedCallbackState();
            return true;
        }

        public boolean flagActionItems() {
            return false;
        }

        public int getId() {
            return 0;
        }

        public void initForMenu(Context context, androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.g gVar;
            androidx.appcompat.view.menu.e eVar2 = this.f4529b;
            if (!(eVar2 == null || (gVar = this.f4530c) == null)) {
                eVar2.collapseItemActionView(gVar);
            }
            this.f4529b = eVar;
        }

        public void onCloseMenu(androidx.appcompat.view.menu.e eVar, boolean z11) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public boolean onSubMenuSelected(l lVar) {
            return false;
        }

        public void updateMenuView(boolean z11) {
            if (this.f4530c != null) {
                androidx.appcompat.view.menu.e eVar = this.f4529b;
                boolean z12 = false;
                if (eVar != null) {
                    int size = eVar.size();
                    int i11 = 0;
                    while (true) {
                        if (i11 >= size) {
                            break;
                        } else if (this.f4529b.getItem(i11) == this.f4530c) {
                            z12 = true;
                            break;
                        } else {
                            i11++;
                        }
                    }
                }
                if (!z12) {
                    collapseItemActionView(this.f4529b, this.f4530c);
                }
            }
        }
    }

    public interface g {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, (AttributeSet) null);
    }

    private void addCustomViewsWithGravity(List<View> list, int i11) {
        boolean z11 = h0.F(this) == 1;
        int childCount = getChildCount();
        int b11 = androidx.core.view.f.b(i11, h0.F(this));
        list.clear();
        if (z11) {
            for (int i12 = childCount - 1; i12 >= 0; i12--) {
                View childAt = getChildAt(i12);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f4524b == 0 && shouldLayout(childAt) && getChildHorizontalGravity(layoutParams.f3729a) == b11) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt2 = getChildAt(i13);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.f4524b == 0 && shouldLayout(childAt2) && getChildHorizontalGravity(layoutParams2.f3729a) == b11) {
                list.add(childAt2);
            }
        }
    }

    private void addSystemView(View view, boolean z11) {
        LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams2)) {
            layoutParams = generateLayoutParams(layoutParams2);
        } else {
            layoutParams = (LayoutParams) layoutParams2;
        }
        layoutParams.f4524b = 1;
        if (!z11 || this.mExpandedActionView == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.mHiddenViews.add(view);
    }

    private void ensureContentInsets() {
        if (this.mContentInsets == null) {
            this.mContentInsets = new x();
        }
    }

    private void ensureLogoView() {
        if (this.mLogoView == null) {
            this.mLogoView = new AppCompatImageView(getContext());
        }
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.n() == null) {
            androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) this.mMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new f();
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            eVar.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
            updateBackInvokedCallbackState();
        }
    }

    private void ensureMenuView() {
        if (this.mMenuView == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.mMenuView = actionMenuView;
            actionMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            this.mMenuView.o(this.mActionMenuPresenterCallback, new c());
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f3729a = 8388613 | (this.mButtonGravity & 112);
            this.mMenuView.setLayoutParams(generateDefaultLayoutParams);
            addSystemView(this.mMenuView, false);
        }
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new AppCompatImageButton(getContext(), (AttributeSet) null, R$attr.toolbarNavigationButtonStyle);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f3729a = 8388611 | (this.mButtonGravity & 112);
            this.mNavButtonView.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    private int getChildHorizontalGravity(int i11) {
        int F = h0.F(this);
        int b11 = androidx.core.view.f.b(i11, F) & 7;
        if (b11 == 1 || b11 == 3 || b11 == 5) {
            return b11;
        }
        return F == 1 ? 5 : 3;
    }

    private int getChildTop(View view, int i11) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i12 = i11 > 0 ? (measuredHeight - i11) / 2 : 0;
        int childVerticalGravity = getChildVerticalGravity(layoutParams.f3729a);
        if (childVerticalGravity == 48) {
            return getPaddingTop() - i12;
        }
        if (childVerticalGravity == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i12;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i13 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i14 = layoutParams.topMargin;
        if (i13 < i14) {
            i13 = i14;
        } else {
            int i15 = (((height - paddingBottom) - measuredHeight) - i13) - paddingTop;
            int i16 = layoutParams.bottomMargin;
            if (i15 < i16) {
                i13 = Math.max(0, i13 - (i16 - i15));
            }
        }
        return paddingTop + i13;
    }

    private int getChildVerticalGravity(int i11) {
        int i12 = i11 & 112;
        return (i12 == 16 || i12 == 48 || i12 == 80) ? i12 : this.mGravity & 112;
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i11 = 0; i11 < menu.size(); i11++) {
            arrayList.add(menu.getItem(i11));
        }
        return arrayList;
    }

    private int getHorizontalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return androidx.core.view.i.b(marginLayoutParams) + androidx.core.view.i.a(marginLayoutParams);
    }

    private MenuInflater getMenuInflater() {
        return new g.c(getContext());
    }

    private int getVerticalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int getViewListMeasuredWidth(List<View> list, int[] iArr) {
        int i11 = iArr[0];
        int i12 = iArr[1];
        int size = list.size();
        int i13 = 0;
        int i14 = 0;
        while (i13 < size) {
            View view = list.get(i13);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i15 = layoutParams.leftMargin - i11;
            int i16 = layoutParams.rightMargin - i12;
            int max = Math.max(0, i15);
            int max2 = Math.max(0, i16);
            int max3 = Math.max(0, -i15);
            int max4 = Math.max(0, -i16);
            i14 += max + view.getMeasuredWidth() + max2;
            i13++;
            i12 = max4;
            i11 = max3;
        }
        return i14;
    }

    private boolean isChildOrHidden(View view) {
        return view.getParent() == this || this.mHiddenViews.contains(view);
    }

    private int layoutChildLeft(View view, int i11, int[] iArr, int i12) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i13 = layoutParams.leftMargin - iArr[0];
        int max = i11 + Math.max(0, i13);
        iArr[0] = Math.max(0, -i13);
        int childTop = getChildTop(view, i12);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, childTop, max + measuredWidth, view.getMeasuredHeight() + childTop);
        return max + measuredWidth + layoutParams.rightMargin;
    }

    private int layoutChildRight(View view, int i11, int[] iArr, int i12) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i13 = layoutParams.rightMargin - iArr[1];
        int max = i11 - Math.max(0, i13);
        iArr[1] = Math.max(0, -i13);
        int childTop = getChildTop(view, i12);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, childTop, max, view.getMeasuredHeight() + childTop);
        return max - (measuredWidth + layoutParams.leftMargin);
    }

    private int measureChildCollapseMargins(View view, int i11, int i12, int i13, int i14, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i15 = marginLayoutParams.leftMargin - iArr[0];
        int i16 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i15) + Math.max(0, i16);
        iArr[0] = Math.max(0, -i15);
        iArr[1] = Math.max(0, -i16);
        view.measure(ViewGroup.getChildMeasureSpec(i11, getPaddingLeft() + getPaddingRight() + max + i12, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i13, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i14, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private void measureChildConstrained(View view, int i11, int i12, int i13, int i14, int i15) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i12, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i13, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i14, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i15 >= 0) {
            if (mode != 0) {
                i15 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i15);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void onCreateMenu() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.mMenuHostHelper.h(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.mProvidedMenuItems = currentMenuItems2;
    }

    private void postShowOverflowMenu() {
        removeCallbacks(this.mShowOverflowMenuRunnable);
        post(this.mShowOverflowMenuRunnable);
    }

    private boolean shouldCollapse() {
        if (!this.mCollapsible) {
            return false;
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (shouldLayout(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean shouldLayout(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public void addChildrenForExpandedActionView() {
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            addView(this.mHiddenViews.get(size));
        }
        this.mHiddenViews.clear();
    }

    public void addMenuProvider(MenuProvider menuProvider) {
        this.mMenuHostHelper.c(menuProvider);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.mMenuView;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean canShowOverflowMenu() {
        /*
            r1 = this;
            int r0 = r1.getVisibility()
            if (r0 != 0) goto L_0x0012
            androidx.appcompat.widget.ActionMenuView r0 = r1.mMenuView
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.k()
            if (r0 == 0) goto L_0x0012
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.canShowOverflowMenu():boolean");
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public void collapseActionView() {
        androidx.appcompat.view.menu.g gVar;
        f fVar = this.mExpandedMenuPresenter;
        if (fVar == null) {
            gVar = null;
        } else {
            gVar = fVar.f4530c;
        }
        if (gVar != null) {
            gVar.collapseActionView();
        }
    }

    public void dismissPopupMenus() {
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.b();
        }
    }

    public void ensureCollapseButtonView() {
        if (this.mCollapseButtonView == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), (AttributeSet) null, R$attr.toolbarNavigationButtonStyle);
            this.mCollapseButtonView = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.f3729a = 8388611 | (this.mButtonGravity & 112);
            generateDefaultLayoutParams.f4524b = 2;
            this.mCollapseButtonView.setLayoutParams(generateDefaultLayoutParams);
            this.mCollapseButtonView.setOnClickListener(new d());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        x xVar = this.mContentInsets;
        if (xVar != null) {
            return xVar.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i11 = this.mContentInsetEndWithActions;
        return i11 != Integer.MIN_VALUE ? i11 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        x xVar = this.mContentInsets;
        if (xVar != null) {
            return xVar.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        x xVar = this.mContentInsets;
        if (xVar != null) {
            return xVar.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        x xVar = this.mContentInsets;
        if (xVar != null) {
            return xVar.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i11 = this.mContentInsetStartWithNavigation;
        return i11 != Integer.MIN_VALUE ? i11 : getContentInsetStart();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.n();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getCurrentContentInsetEnd() {
        /*
            r3 = this;
            androidx.appcompat.widget.ActionMenuView r0 = r3.mMenuView
            r1 = 0
            if (r0 == 0) goto L_0x0013
            androidx.appcompat.view.menu.e r0 = r0.n()
            if (r0 == 0) goto L_0x0013
            boolean r0 = r0.hasVisibleItems()
            if (r0 == 0) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = r1
        L_0x0014:
            if (r0 == 0) goto L_0x0025
            int r0 = r3.getContentInsetEnd()
            int r2 = r3.mContentInsetEndWithActions
            int r1 = java.lang.Math.max(r2, r1)
            int r0 = java.lang.Math.max(r0, r1)
            goto L_0x0029
        L_0x0025:
            int r0 = r3.getContentInsetEnd()
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.getCurrentContentInsetEnd():int");
    }

    public int getCurrentContentInsetLeft() {
        if (h0.F(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (h0.F(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
        }
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    public View getNavButtonView() {
        return this.mNavButtonView;
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    /* access modifiers changed from: package-private */
    public Context getPopupContext() {
        return this.mPopupContext;
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    public final TextView getSubtitleTextView() {
        return this.mSubtitleTextView;
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    public final TextView getTitleTextView() {
        return this.mTitleTextView;
    }

    public q getWrapper() {
        if (this.mWrapper == null) {
            this.mWrapper = new h0(this, true);
        }
        return this.mWrapper;
    }

    public boolean hasExpandedActionView() {
        f fVar = this.mExpandedMenuPresenter;
        return (fVar == null || fVar.f4530c == null) ? false : true;
    }

    public boolean hideOverflowMenu() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.h();
    }

    public void inflateMenu(int i11) {
        getMenuInflater().inflate(i11, getMenu());
    }

    public void invalidateMenu() {
        Iterator<MenuItem> it2 = this.mProvidedMenuItems.iterator();
        while (it2.hasNext()) {
            getMenu().removeItem(it2.next().getItemId());
        }
        onCreateMenu();
    }

    public boolean isBackInvokedCallbackEnabled() {
        return this.mBackInvokedCallbackEnabled;
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.i();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.j();
    }

    public boolean isTitleTruncated() {
        Layout layout;
        TextView textView = this.mTitleTextView;
        if (textView == null || (layout = textView.getLayout()) == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i11 = 0; i11 < lineCount; i11++) {
            if (layout.getEllipsisCount(i11) > 0) {
                return true;
            }
        }
        return false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateBackInvokedCallbackState();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
        updateBackInvokedCallbackState();
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.mEatingHover = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.mEatingHover = false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x029f A[LOOP:0: B:101:0x029d->B:102:0x029f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02c1 A[LOOP:1: B:104:0x02bf->B:105:0x02c1, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02fa A[LOOP:2: B:112:0x02f8->B:113:0x02fa, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0227  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            r19 = this;
            r0 = r19
            int r1 = androidx.core.view.h0.F(r19)
            r2 = 1
            r3 = 0
            if (r1 != r2) goto L_0x000c
            r1 = r2
            goto L_0x000d
        L_0x000c:
            r1 = r3
        L_0x000d:
            int r4 = r19.getWidth()
            int r5 = r19.getHeight()
            int r6 = r19.getPaddingLeft()
            int r7 = r19.getPaddingRight()
            int r8 = r19.getPaddingTop()
            int r9 = r19.getPaddingBottom()
            int r10 = r4 - r7
            int[] r11 = r0.mTempMargins
            r11[r2] = r3
            r11[r3] = r3
            int r12 = androidx.core.view.h0.G(r19)
            if (r12 < 0) goto L_0x003a
            int r13 = r24 - r22
            int r12 = java.lang.Math.min(r12, r13)
            goto L_0x003b
        L_0x003a:
            r12 = r3
        L_0x003b:
            android.widget.ImageButton r13 = r0.mNavButtonView
            boolean r13 = r0.shouldLayout(r13)
            if (r13 == 0) goto L_0x0055
            if (r1 == 0) goto L_0x004e
            android.widget.ImageButton r13 = r0.mNavButtonView
            int r13 = r0.layoutChildRight(r13, r10, r11, r12)
            r14 = r13
            r13 = r6
            goto L_0x0057
        L_0x004e:
            android.widget.ImageButton r13 = r0.mNavButtonView
            int r13 = r0.layoutChildLeft(r13, r6, r11, r12)
            goto L_0x0056
        L_0x0055:
            r13 = r6
        L_0x0056:
            r14 = r10
        L_0x0057:
            android.widget.ImageButton r15 = r0.mCollapseButtonView
            boolean r15 = r0.shouldLayout(r15)
            if (r15 == 0) goto L_0x006e
            if (r1 == 0) goto L_0x0068
            android.widget.ImageButton r15 = r0.mCollapseButtonView
            int r14 = r0.layoutChildRight(r15, r14, r11, r12)
            goto L_0x006e
        L_0x0068:
            android.widget.ImageButton r15 = r0.mCollapseButtonView
            int r13 = r0.layoutChildLeft(r15, r13, r11, r12)
        L_0x006e:
            androidx.appcompat.widget.ActionMenuView r15 = r0.mMenuView
            boolean r15 = r0.shouldLayout(r15)
            if (r15 == 0) goto L_0x0085
            if (r1 == 0) goto L_0x007f
            androidx.appcompat.widget.ActionMenuView r15 = r0.mMenuView
            int r13 = r0.layoutChildLeft(r15, r13, r11, r12)
            goto L_0x0085
        L_0x007f:
            androidx.appcompat.widget.ActionMenuView r15 = r0.mMenuView
            int r14 = r0.layoutChildRight(r15, r14, r11, r12)
        L_0x0085:
            int r15 = r19.getCurrentContentInsetLeft()
            int r16 = r19.getCurrentContentInsetRight()
            int r2 = r15 - r13
            int r2 = java.lang.Math.max(r3, r2)
            r11[r3] = r2
            int r2 = r10 - r14
            int r2 = r16 - r2
            int r2 = java.lang.Math.max(r3, r2)
            r17 = 1
            r11[r17] = r2
            int r2 = java.lang.Math.max(r13, r15)
            int r10 = r10 - r16
            int r10 = java.lang.Math.min(r14, r10)
            android.view.View r13 = r0.mExpandedActionView
            boolean r13 = r0.shouldLayout(r13)
            if (r13 == 0) goto L_0x00c2
            if (r1 == 0) goto L_0x00bc
            android.view.View r13 = r0.mExpandedActionView
            int r10 = r0.layoutChildRight(r13, r10, r11, r12)
            goto L_0x00c2
        L_0x00bc:
            android.view.View r13 = r0.mExpandedActionView
            int r2 = r0.layoutChildLeft(r13, r2, r11, r12)
        L_0x00c2:
            android.widget.ImageView r13 = r0.mLogoView
            boolean r13 = r0.shouldLayout(r13)
            if (r13 == 0) goto L_0x00d9
            if (r1 == 0) goto L_0x00d3
            android.widget.ImageView r13 = r0.mLogoView
            int r10 = r0.layoutChildRight(r13, r10, r11, r12)
            goto L_0x00d9
        L_0x00d3:
            android.widget.ImageView r13 = r0.mLogoView
            int r2 = r0.layoutChildLeft(r13, r2, r11, r12)
        L_0x00d9:
            android.widget.TextView r13 = r0.mTitleTextView
            boolean r13 = r0.shouldLayout(r13)
            android.widget.TextView r14 = r0.mSubtitleTextView
            boolean r14 = r0.shouldLayout(r14)
            if (r13 == 0) goto L_0x0100
            android.widget.TextView r15 = r0.mTitleTextView
            android.view.ViewGroup$LayoutParams r15 = r15.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r15 = (androidx.appcompat.widget.Toolbar.LayoutParams) r15
            int r3 = r15.topMargin
            r23 = r7
            android.widget.TextView r7 = r0.mTitleTextView
            int r7 = r7.getMeasuredHeight()
            int r3 = r3 + r7
            int r7 = r15.bottomMargin
            int r3 = r3 + r7
            r7 = 0
            int r3 = r3 + r7
            goto L_0x0103
        L_0x0100:
            r23 = r7
            r3 = 0
        L_0x0103:
            if (r14 == 0) goto L_0x011d
            android.widget.TextView r7 = r0.mSubtitleTextView
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r7 = (androidx.appcompat.widget.Toolbar.LayoutParams) r7
            int r15 = r7.topMargin
            r16 = r4
            android.widget.TextView r4 = r0.mSubtitleTextView
            int r4 = r4.getMeasuredHeight()
            int r15 = r15 + r4
            int r4 = r7.bottomMargin
            int r15 = r15 + r4
            int r3 = r3 + r15
            goto L_0x011f
        L_0x011d:
            r16 = r4
        L_0x011f:
            if (r13 != 0) goto L_0x012b
            if (r14 == 0) goto L_0x0124
            goto L_0x012b
        L_0x0124:
            r18 = r6
            r22 = r12
        L_0x0128:
            r1 = 0
            goto L_0x0290
        L_0x012b:
            if (r13 == 0) goto L_0x0130
            android.widget.TextView r4 = r0.mTitleTextView
            goto L_0x0132
        L_0x0130:
            android.widget.TextView r4 = r0.mSubtitleTextView
        L_0x0132:
            if (r14 == 0) goto L_0x0137
            android.widget.TextView r7 = r0.mSubtitleTextView
            goto L_0x0139
        L_0x0137:
            android.widget.TextView r7 = r0.mTitleTextView
        L_0x0139:
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r4 = (androidx.appcompat.widget.Toolbar.LayoutParams) r4
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r7 = (androidx.appcompat.widget.Toolbar.LayoutParams) r7
            if (r13 == 0) goto L_0x014f
            android.widget.TextView r15 = r0.mTitleTextView
            int r15 = r15.getMeasuredWidth()
            if (r15 > 0) goto L_0x0159
        L_0x014f:
            if (r14 == 0) goto L_0x015c
            android.widget.TextView r15 = r0.mSubtitleTextView
            int r15 = r15.getMeasuredWidth()
            if (r15 <= 0) goto L_0x015c
        L_0x0159:
            r17 = 1
            goto L_0x015e
        L_0x015c:
            r17 = 0
        L_0x015e:
            int r15 = r0.mGravity
            r15 = r15 & 112(0x70, float:1.57E-43)
            r18 = r6
            r6 = 48
            if (r15 == r6) goto L_0x01a6
            r6 = 80
            if (r15 == r6) goto L_0x0198
            int r6 = r5 - r8
            int r6 = r6 - r9
            int r6 = r6 - r3
            int r6 = r6 / 2
            int r15 = r4.topMargin
            r22 = r12
            int r12 = r0.mTitleMarginTop
            r24 = r2
            int r2 = r15 + r12
            if (r6 >= r2) goto L_0x0181
            int r6 = r15 + r12
            goto L_0x0196
        L_0x0181:
            int r5 = r5 - r9
            int r5 = r5 - r3
            int r5 = r5 - r6
            int r5 = r5 - r8
            int r2 = r4.bottomMargin
            int r3 = r0.mTitleMarginBottom
            int r2 = r2 + r3
            if (r5 >= r2) goto L_0x0196
            int r2 = r7.bottomMargin
            int r2 = r2 + r3
            int r2 = r2 - r5
            int r6 = r6 - r2
            r2 = 0
            int r6 = java.lang.Math.max(r2, r6)
        L_0x0196:
            int r8 = r8 + r6
            goto L_0x01b5
        L_0x0198:
            r24 = r2
            r22 = r12
            int r5 = r5 - r9
            int r2 = r7.bottomMargin
            int r5 = r5 - r2
            int r2 = r0.mTitleMarginBottom
            int r5 = r5 - r2
            int r8 = r5 - r3
            goto L_0x01b5
        L_0x01a6:
            r24 = r2
            r22 = r12
            int r2 = r19.getPaddingTop()
            int r3 = r4.topMargin
            int r2 = r2 + r3
            int r3 = r0.mTitleMarginTop
            int r8 = r2 + r3
        L_0x01b5:
            if (r1 == 0) goto L_0x0227
            if (r17 == 0) goto L_0x01bc
            int r1 = r0.mTitleMarginStart
            goto L_0x01bd
        L_0x01bc:
            r1 = 0
        L_0x01bd:
            r2 = 1
            r3 = r11[r2]
            int r1 = r1 - r3
            r3 = 0
            int r4 = java.lang.Math.max(r3, r1)
            int r10 = r10 - r4
            int r1 = -r1
            int r1 = java.lang.Math.max(r3, r1)
            r11[r2] = r1
            if (r13 == 0) goto L_0x01f4
            android.widget.TextView r1 = r0.mTitleTextView
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r1 = (androidx.appcompat.widget.Toolbar.LayoutParams) r1
            android.widget.TextView r2 = r0.mTitleTextView
            int r2 = r2.getMeasuredWidth()
            int r2 = r10 - r2
            android.widget.TextView r3 = r0.mTitleTextView
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.TextView r4 = r0.mTitleTextView
            r4.layout(r2, r8, r10, r3)
            int r4 = r0.mTitleMarginEnd
            int r2 = r2 - r4
            int r1 = r1.bottomMargin
            int r8 = r3 + r1
            goto L_0x01f5
        L_0x01f4:
            r2 = r10
        L_0x01f5:
            if (r14 == 0) goto L_0x021b
            android.widget.TextView r1 = r0.mSubtitleTextView
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r1 = (androidx.appcompat.widget.Toolbar.LayoutParams) r1
            int r1 = r1.topMargin
            int r8 = r8 + r1
            android.widget.TextView r1 = r0.mSubtitleTextView
            int r1 = r1.getMeasuredWidth()
            int r1 = r10 - r1
            android.widget.TextView r3 = r0.mSubtitleTextView
            int r3 = r3.getMeasuredHeight()
            int r3 = r3 + r8
            android.widget.TextView r4 = r0.mSubtitleTextView
            r4.layout(r1, r8, r10, r3)
            int r1 = r0.mTitleMarginEnd
            int r1 = r10 - r1
            goto L_0x021c
        L_0x021b:
            r1 = r10
        L_0x021c:
            if (r17 == 0) goto L_0x0223
            int r1 = java.lang.Math.min(r2, r1)
            r10 = r1
        L_0x0223:
            r2 = r24
            goto L_0x0128
        L_0x0227:
            if (r17 == 0) goto L_0x022d
            int r7 = r0.mTitleMarginStart
            r1 = 0
            goto L_0x022f
        L_0x022d:
            r1 = 0
            r7 = 0
        L_0x022f:
            r2 = r11[r1]
            int r7 = r7 - r2
            int r2 = java.lang.Math.max(r1, r7)
            int r2 = r24 + r2
            int r3 = -r7
            int r3 = java.lang.Math.max(r1, r3)
            r11[r1] = r3
            if (r13 == 0) goto L_0x0264
            android.widget.TextView r3 = r0.mTitleTextView
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r3 = (androidx.appcompat.widget.Toolbar.LayoutParams) r3
            android.widget.TextView r4 = r0.mTitleTextView
            int r4 = r4.getMeasuredWidth()
            int r4 = r4 + r2
            android.widget.TextView r5 = r0.mTitleTextView
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r8
            android.widget.TextView r6 = r0.mTitleTextView
            r6.layout(r2, r8, r4, r5)
            int r6 = r0.mTitleMarginEnd
            int r4 = r4 + r6
            int r3 = r3.bottomMargin
            int r8 = r5 + r3
            goto L_0x0265
        L_0x0264:
            r4 = r2
        L_0x0265:
            if (r14 == 0) goto L_0x0289
            android.widget.TextView r3 = r0.mSubtitleTextView
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.Toolbar$LayoutParams r3 = (androidx.appcompat.widget.Toolbar.LayoutParams) r3
            int r3 = r3.topMargin
            int r8 = r8 + r3
            android.widget.TextView r3 = r0.mSubtitleTextView
            int r3 = r3.getMeasuredWidth()
            int r3 = r3 + r2
            android.widget.TextView r5 = r0.mSubtitleTextView
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r8
            android.widget.TextView r6 = r0.mSubtitleTextView
            r6.layout(r2, r8, r3, r5)
            int r5 = r0.mTitleMarginEnd
            int r3 = r3 + r5
            goto L_0x028a
        L_0x0289:
            r3 = r2
        L_0x028a:
            if (r17 == 0) goto L_0x0290
            int r2 = java.lang.Math.max(r4, r3)
        L_0x0290:
            java.util.ArrayList<android.view.View> r3 = r0.mTempViews
            r4 = 3
            r0.addCustomViewsWithGravity(r3, r4)
            java.util.ArrayList<android.view.View> r3 = r0.mTempViews
            int r3 = r3.size()
            r7 = r1
        L_0x029d:
            if (r7 >= r3) goto L_0x02b0
            java.util.ArrayList<android.view.View> r4 = r0.mTempViews
            java.lang.Object r4 = r4.get(r7)
            android.view.View r4 = (android.view.View) r4
            r12 = r22
            int r2 = r0.layoutChildLeft(r4, r2, r11, r12)
            int r7 = r7 + 1
            goto L_0x029d
        L_0x02b0:
            r12 = r22
            java.util.ArrayList<android.view.View> r3 = r0.mTempViews
            r4 = 5
            r0.addCustomViewsWithGravity(r3, r4)
            java.util.ArrayList<android.view.View> r3 = r0.mTempViews
            int r3 = r3.size()
            r7 = r1
        L_0x02bf:
            if (r7 >= r3) goto L_0x02d0
            java.util.ArrayList<android.view.View> r4 = r0.mTempViews
            java.lang.Object r4 = r4.get(r7)
            android.view.View r4 = (android.view.View) r4
            int r10 = r0.layoutChildRight(r4, r10, r11, r12)
            int r7 = r7 + 1
            goto L_0x02bf
        L_0x02d0:
            java.util.ArrayList<android.view.View> r3 = r0.mTempViews
            r4 = 1
            r0.addCustomViewsWithGravity(r3, r4)
            java.util.ArrayList<android.view.View> r3 = r0.mTempViews
            int r3 = r0.getViewListMeasuredWidth(r3, r11)
            int r4 = r16 - r18
            int r4 = r4 - r23
            int r4 = r4 / 2
            int r6 = r18 + r4
            int r4 = r3 / 2
            int r6 = r6 - r4
            int r3 = r3 + r6
            if (r6 >= r2) goto L_0x02eb
            goto L_0x02f2
        L_0x02eb:
            if (r3 <= r10) goto L_0x02f1
            int r3 = r3 - r10
            int r2 = r6 - r3
            goto L_0x02f2
        L_0x02f1:
            r2 = r6
        L_0x02f2:
            java.util.ArrayList<android.view.View> r3 = r0.mTempViews
            int r3 = r3.size()
        L_0x02f8:
            if (r1 >= r3) goto L_0x0309
            java.util.ArrayList<android.view.View> r4 = r0.mTempViews
            java.lang.Object r4 = r4.get(r1)
            android.view.View r4 = (android.view.View) r4
            int r2 = r0.layoutChildLeft(r4, r2, r11, r12)
            int r1 = r1 + 1
            goto L_0x02f8
        L_0x0309:
            java.util.ArrayList<android.view.View> r1 = r0.mTempViews
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int[] iArr = this.mTempMargins;
        char b11 = o0.b(this);
        int i21 = 0;
        char c11 = b11 ^ 1;
        if (shouldLayout(this.mNavButtonView)) {
            measureChildConstrained(this.mNavButtonView, i11, 0, i12, 0, this.mMaxButtonHeight);
            i15 = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
            i14 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
            i13 = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
        } else {
            i15 = 0;
            i14 = 0;
            i13 = 0;
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            measureChildConstrained(this.mCollapseButtonView, i11, 0, i12, 0, this.mMaxButtonHeight);
            i15 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
            i14 = Math.max(i14, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
            i13 = View.combineMeasuredStates(i13, this.mCollapseButtonView.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i15);
        iArr[b11] = Math.max(0, currentContentInsetStart - i15);
        if (shouldLayout(this.mMenuView)) {
            measureChildConstrained(this.mMenuView, i11, max, i12, 0, this.mMaxButtonHeight);
            i16 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
            i14 = Math.max(i14, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
            i13 = View.combineMeasuredStates(i13, this.mMenuView.getMeasuredState());
        } else {
            i16 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i16);
        iArr[c11] = Math.max(0, currentContentInsetEnd - i16);
        if (shouldLayout(this.mExpandedActionView)) {
            max2 += measureChildCollapseMargins(this.mExpandedActionView, i11, max2, i12, 0, iArr);
            i14 = Math.max(i14, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
            i13 = View.combineMeasuredStates(i13, this.mExpandedActionView.getMeasuredState());
        }
        if (shouldLayout(this.mLogoView)) {
            max2 += measureChildCollapseMargins(this.mLogoView, i11, max2, i12, 0, iArr);
            i14 = Math.max(i14, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
            i13 = View.combineMeasuredStates(i13, this.mLogoView.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i22 = 0; i22 < childCount; i22++) {
            View childAt = getChildAt(i22);
            if (((LayoutParams) childAt.getLayoutParams()).f4524b == 0 && shouldLayout(childAt)) {
                max2 += measureChildCollapseMargins(childAt, i11, max2, i12, 0, iArr);
                i14 = Math.max(i14, childAt.getMeasuredHeight() + getVerticalMargins(childAt));
                i13 = View.combineMeasuredStates(i13, childAt.getMeasuredState());
            }
        }
        int i23 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int i24 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView)) {
            measureChildCollapseMargins(this.mTitleTextView, i11, max2 + i24, i12, i23, iArr);
            int measuredWidth = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
            i17 = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
            i19 = View.combineMeasuredStates(i13, this.mTitleTextView.getMeasuredState());
            i18 = measuredWidth;
        } else {
            i17 = 0;
            i19 = i13;
            i18 = 0;
        }
        if (shouldLayout(this.mSubtitleTextView)) {
            i18 = Math.max(i18, measureChildCollapseMargins(this.mSubtitleTextView, i11, max2 + i24, i12, i17 + i23, iArr));
            i17 += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView);
            i19 = View.combineMeasuredStates(i19, this.mSubtitleTextView.getMeasuredState());
        } else {
            int i25 = i19;
        }
        int max3 = Math.max(i14, i17);
        int paddingLeft = max2 + i18 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i11, -16777216 & i19);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i12, i19 << 16);
        if (!shouldCollapse()) {
            i21 = resolveSizeAndState2;
        }
        setMeasuredDimension(resolveSizeAndState, i21);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ActionMenuView actionMenuView = this.mMenuView;
        androidx.appcompat.view.menu.e n11 = actionMenuView != null ? actionMenuView.n() : null;
        int i11 = savedState.expandedMenuItemId;
        if (!(i11 == 0 || this.mExpandedMenuPresenter == null || n11 == null || (findItem = n11.findItem(i11)) == null)) {
            findItem.expandActionView();
        }
        if (savedState.isOverflowOpen) {
            postShowOverflowMenu();
        }
    }

    public void onRtlPropertiesChanged(int i11) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i11);
        }
        ensureContentInsets();
        x xVar = this.mContentInsets;
        boolean z11 = true;
        if (i11 != 1) {
            z11 = false;
        }
        xVar.f(z11);
    }

    public Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.g gVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        f fVar = this.mExpandedMenuPresenter;
        if (!(fVar == null || (gVar = fVar.f4530c) == null)) {
            savedState.expandedMenuItemId = gVar.getItemId();
        }
        savedState.isOverflowOpen = isOverflowMenuShowing();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.mEatingTouch = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    public void removeChildrenForExpandedActionView() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((LayoutParams) childAt.getLayoutParams()).f4524b == 2 || childAt == this.mMenuView)) {
                removeViewAt(childCount);
                this.mHiddenViews.add(childAt);
            }
        }
    }

    public void removeMenuProvider(MenuProvider menuProvider) {
        this.mMenuHostHelper.l(menuProvider);
    }

    public void setBackInvokedCallbackEnabled(boolean z11) {
        if (this.mBackInvokedCallbackEnabled != z11) {
            this.mBackInvokedCallbackEnabled = z11;
            updateBackInvokedCallbackState();
        }
    }

    public void setCollapseContentDescription(int i11) {
        setCollapseContentDescription(i11 != 0 ? getContext().getText(i11) : null);
    }

    public void setCollapseIcon(int i11) {
        setCollapseIcon(c.a.b(getContext(), i11));
    }

    public void setCollapsible(boolean z11) {
        this.mCollapsible = z11;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i11) {
        if (i11 < 0) {
            i11 = Integer.MIN_VALUE;
        }
        if (i11 != this.mContentInsetEndWithActions) {
            this.mContentInsetEndWithActions = i11;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i11) {
        if (i11 < 0) {
            i11 = Integer.MIN_VALUE;
        }
        if (i11 != this.mContentInsetStartWithNavigation) {
            this.mContentInsetStartWithNavigation = i11;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetsAbsolute(int i11, int i12) {
        ensureContentInsets();
        this.mContentInsets.e(i11, i12);
    }

    public void setContentInsetsRelative(int i11, int i12) {
        ensureContentInsets();
        this.mContentInsets.g(i11, i12);
    }

    public void setLogo(int i11) {
        setLogo(c.a.b(getContext(), i11));
    }

    public void setLogoDescription(int i11) {
        setLogoDescription(getContext().getText(i11));
    }

    public void setMenu(androidx.appcompat.view.menu.e eVar, ActionMenuPresenter actionMenuPresenter) {
        if (eVar != null || this.mMenuView != null) {
            ensureMenuView();
            androidx.appcompat.view.menu.e n11 = this.mMenuView.n();
            if (n11 != eVar) {
                if (n11 != null) {
                    n11.removeMenuPresenter(this.mOuterActionMenuPresenter);
                    n11.removeMenuPresenter(this.mExpandedMenuPresenter);
                }
                if (this.mExpandedMenuPresenter == null) {
                    this.mExpandedMenuPresenter = new f();
                }
                actionMenuPresenter.z(true);
                if (eVar != null) {
                    eVar.addMenuPresenter(actionMenuPresenter, this.mPopupContext);
                    eVar.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
                } else {
                    actionMenuPresenter.initForMenu(this.mPopupContext, (androidx.appcompat.view.menu.e) null);
                    this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, (androidx.appcompat.view.menu.e) null);
                    actionMenuPresenter.updateMenuView(true);
                    this.mExpandedMenuPresenter.updateMenuView(true);
                }
                this.mMenuView.setPopupTheme(this.mPopupTheme);
                this.mMenuView.setPresenter(actionMenuPresenter);
                this.mOuterActionMenuPresenter = actionMenuPresenter;
                updateBackInvokedCallbackState();
            }
        }
    }

    public void setMenuCallbacks(i.a aVar, e.a aVar2) {
        this.mActionMenuPresenterCallback = aVar;
        this.mMenuBuilderCallback = aVar2;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.o(aVar, aVar2);
        }
    }

    public void setNavigationContentDescription(int i11) {
        setNavigationContentDescription(i11 != 0 ? getContext().getText(i11) : null);
    }

    public void setNavigationIcon(int i11) {
        setNavigationIcon(c.a.b(getContext(), i11));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(g gVar) {
        this.mOnMenuItemClickListener = gVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i11) {
        if (this.mPopupTheme != i11) {
            this.mPopupTheme = i11;
            if (i11 == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i11);
            }
        }
    }

    public void setSubtitle(int i11) {
        setSubtitle(getContext().getText(i11));
    }

    public void setSubtitleTextAppearance(Context context, int i11) {
        this.mSubtitleTextAppearance = i11;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i11);
        }
    }

    public void setSubtitleTextColor(int i11) {
        setSubtitleTextColor(ColorStateList.valueOf(i11));
    }

    public void setTitle(int i11) {
        setTitle(getContext().getText(i11));
    }

    public void setTitleMargin(int i11, int i12, int i13, int i14) {
        this.mTitleMarginStart = i11;
        this.mTitleMarginTop = i12;
        this.mTitleMarginEnd = i13;
        this.mTitleMarginBottom = i14;
        requestLayout();
    }

    public void setTitleMarginBottom(int i11) {
        this.mTitleMarginBottom = i11;
        requestLayout();
    }

    public void setTitleMarginEnd(int i11) {
        this.mTitleMarginEnd = i11;
        requestLayout();
    }

    public void setTitleMarginStart(int i11) {
        this.mTitleMarginStart = i11;
        requestLayout();
    }

    public void setTitleMarginTop(int i11) {
        this.mTitleMarginTop = i11;
        requestLayout();
    }

    public void setTitleTextAppearance(Context context, int i11) {
        this.mTitleTextAppearance = i11;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i11);
        }
    }

    public void setTitleTextColor(int i11) {
        setTitleTextColor(ColorStateList.valueOf(i11));
    }

    public boolean showOverflowMenu() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.p();
    }

    /* access modifiers changed from: package-private */
    public void updateBackInvokedCallbackState() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher a11 = e.a(this);
            boolean z11 = hasExpandedActionView() && a11 != null && h0.Z(this) && this.mBackInvokedCallbackEnabled;
            if (z11 && this.mBackInvokedDispatcher == null) {
                if (this.mBackInvokedCallback == null) {
                    this.mBackInvokedCallback = e.b(new e0(this));
                }
                e.c(a11, this.mBackInvokedCallback);
                this.mBackInvokedDispatcher = a11;
            } else if (!z11 && (onBackInvokedDispatcher = this.mBackInvokedDispatcher) != null) {
                e.d(onBackInvokedDispatcher, this.mBackInvokedCallback);
                this.mBackInvokedDispatcher = null;
            }
        }
    }

    public static class LayoutParams extends ActionBar.LayoutParams {

        /* renamed from: b  reason: collision with root package name */
        public int f4524b = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
            this.f3729a = 8388627;
        }

        public LayoutParams(int i11, int i12, int i13) {
            super(i11, i12);
            this.f3729a = i13;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            this.f4524b = layoutParams.f4524b;
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super((ViewGroup.LayoutParams) marginLayoutParams);
            a(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner) {
        this.mMenuHostHelper.d(menuProvider, lifecycleOwner);
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureCollapseButtonView();
        }
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            ensureCollapseButtonView();
            this.mCollapseButtonView.setImageDrawable(drawable);
            return;
        }
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            imageButton.setImageDrawable(this.mCollapseIcon);
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            ensureLogoView();
            if (!isChildOrHidden(this.mLogoView)) {
                addSystemView(this.mLogoView, true);
            }
        } else {
            ImageView imageView = this.mLogoView;
            if (imageView != null && isChildOrHidden(imageView)) {
                removeView(this.mLogoView);
                this.mHiddenViews.remove(this.mLogoView);
            }
        }
        ImageView imageView2 = this.mLogoView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureLogoView();
        }
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureNavButtonView();
        }
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            i0.a(this.mNavButtonView, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            ensureNavButtonView();
            if (!isChildOrHidden(this.mNavButtonView)) {
                addSystemView(this.mNavButtonView, true);
            }
        } else {
            ImageButton imageButton = this.mNavButtonView;
            if (imageButton != null && isChildOrHidden(imageButton)) {
                removeView(this.mNavButtonView);
                this.mHiddenViews.remove(this.mNavButtonView);
            }
        }
        ImageButton imageButton2 = this.mNavButtonView;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mSubtitleTextView == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.mSubtitleTextView = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int i11 = this.mSubtitleTextAppearance;
                if (i11 != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, i11);
                }
                ColorStateList colorStateList = this.mSubtitleTextColor;
                if (colorStateList != null) {
                    this.mSubtitleTextView.setTextColor(colorStateList);
                }
            }
            if (!isChildOrHidden(this.mSubtitleTextView)) {
                addSystemView(this.mSubtitleTextView, true);
            }
        } else {
            TextView textView = this.mSubtitleTextView;
            if (textView != null && isChildOrHidden(textView)) {
                removeView(this.mSubtitleTextView);
                this.mHiddenViews.remove(this.mSubtitleTextView);
            }
        }
        TextView textView2 = this.mSubtitleTextView;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.mSubtitleTextColor = colorStateList;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mTitleTextView == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.mTitleTextView = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int i11 = this.mTitleTextAppearance;
                if (i11 != 0) {
                    this.mTitleTextView.setTextAppearance(context, i11);
                }
                ColorStateList colorStateList = this.mTitleTextColor;
                if (colorStateList != null) {
                    this.mTitleTextView.setTextColor(colorStateList);
                }
            }
            if (!isChildOrHidden(this.mTitleTextView)) {
                addSystemView(this.mTitleTextView, true);
            }
        } else {
            TextView textView = this.mTitleTextView;
            if (textView != null && isChildOrHidden(textView)) {
                removeView(this.mTitleTextView);
                this.mHiddenViews.remove(this.mTitleTextView);
            }
        }
        TextView textView2 = this.mTitleTextView;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.mTitleText = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.mTitleTextColor = colorStateList;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList<>();
        this.mHiddenViews = new ArrayList<>();
        this.mTempMargins = new int[2];
        this.mMenuHostHelper = new MenuHostHelper(new f0(this));
        this.mProvidedMenuItems = new ArrayList<>();
        this.mMenuViewItemClickListener = new a();
        this.mShowOverflowMenuRunnable = new b();
        Context context2 = getContext();
        int[] iArr = R$styleable.Toolbar;
        d0 v11 = d0.v(context2, attributeSet, iArr, i11, 0);
        h0.v0(this, context, iArr, attributeSet, v11.r(), i11, 0);
        this.mTitleTextAppearance = v11.n(R$styleable.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = v11.n(R$styleable.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = v11.l(R$styleable.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = v11.l(R$styleable.Toolbar_buttonGravity, 48);
        int e11 = v11.e(R$styleable.Toolbar_titleMargin, 0);
        int i12 = R$styleable.Toolbar_titleMargins;
        e11 = v11.s(i12) ? v11.e(i12, e11) : e11;
        this.mTitleMarginBottom = e11;
        this.mTitleMarginTop = e11;
        this.mTitleMarginEnd = e11;
        this.mTitleMarginStart = e11;
        int e12 = v11.e(R$styleable.Toolbar_titleMarginStart, -1);
        if (e12 >= 0) {
            this.mTitleMarginStart = e12;
        }
        int e13 = v11.e(R$styleable.Toolbar_titleMarginEnd, -1);
        if (e13 >= 0) {
            this.mTitleMarginEnd = e13;
        }
        int e14 = v11.e(R$styleable.Toolbar_titleMarginTop, -1);
        if (e14 >= 0) {
            this.mTitleMarginTop = e14;
        }
        int e15 = v11.e(R$styleable.Toolbar_titleMarginBottom, -1);
        if (e15 >= 0) {
            this.mTitleMarginBottom = e15;
        }
        this.mMaxButtonHeight = v11.f(R$styleable.Toolbar_maxButtonHeight, -1);
        int e16 = v11.e(R$styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int e17 = v11.e(R$styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int f11 = v11.f(R$styleable.Toolbar_contentInsetLeft, 0);
        int f12 = v11.f(R$styleable.Toolbar_contentInsetRight, 0);
        ensureContentInsets();
        this.mContentInsets.e(f11, f12);
        if (!(e16 == Integer.MIN_VALUE && e17 == Integer.MIN_VALUE)) {
            this.mContentInsets.g(e16, e17);
        }
        this.mContentInsetStartWithNavigation = v11.e(R$styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.mContentInsetEndWithActions = v11.e(R$styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.mCollapseIcon = v11.g(R$styleable.Toolbar_collapseIcon);
        this.mCollapseDescription = v11.p(R$styleable.Toolbar_collapseContentDescription);
        CharSequence p11 = v11.p(R$styleable.Toolbar_title);
        if (!TextUtils.isEmpty(p11)) {
            setTitle(p11);
        }
        CharSequence p12 = v11.p(R$styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(p12)) {
            setSubtitle(p12);
        }
        this.mPopupContext = getContext();
        setPopupTheme(v11.n(R$styleable.Toolbar_popupTheme, 0));
        Drawable g11 = v11.g(R$styleable.Toolbar_navigationIcon);
        if (g11 != null) {
            setNavigationIcon(g11);
        }
        CharSequence p13 = v11.p(R$styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(p13)) {
            setNavigationContentDescription(p13);
        }
        Drawable g12 = v11.g(R$styleable.Toolbar_logo);
        if (g12 != null) {
            setLogo(g12);
        }
        CharSequence p14 = v11.p(R$styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(p14)) {
            setLogoDescription(p14);
        }
        int i13 = R$styleable.Toolbar_titleTextColor;
        if (v11.s(i13)) {
            setTitleTextColor(v11.c(i13));
        }
        int i14 = R$styleable.Toolbar_subtitleTextColor;
        if (v11.s(i14)) {
            setSubtitleTextColor(v11.c(i14));
        }
        int i15 = R$styleable.Toolbar_menu;
        if (v11.s(i15)) {
            inflateMenu(v11.n(i15, 0));
        }
        v11.w();
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.State state) {
        this.mMenuHostHelper.e(menuProvider, lifecycleOwner, state);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ActionBar.LayoutParams) {
            return new LayoutParams((ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }
}
