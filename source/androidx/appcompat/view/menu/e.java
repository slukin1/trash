package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.ContextCompat;
import androidx.core.view.j0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class e implements v0.a {
    private static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
    private static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
    private static final String PRESENTER_KEY = "android:menu:presenters";
    private static final String TAG = "MenuBuilder";
    private static final int[] sCategoryToOrder = {1, 4, 5, 3, 2, 0};
    private ArrayList<g> mActionItems;
    private a mCallback;
    private final Context mContext;
    private ContextMenu.ContextMenuInfo mCurrentMenuInfo;
    private int mDefaultShowAsAction = 0;
    private g mExpandedItem;
    private boolean mGroupDividerEnabled = false;
    public Drawable mHeaderIcon;
    public CharSequence mHeaderTitle;
    public View mHeaderView;
    private boolean mIsActionItemsStale;
    private boolean mIsClosing = false;
    private boolean mIsVisibleItemsStale;
    private ArrayList<g> mItems;
    private boolean mItemsChangedWhileDispatchPrevented = false;
    private ArrayList<g> mNonActionItems;
    private boolean mOptionalIconsVisible = false;
    private boolean mOverrideVisibleItems;
    private CopyOnWriteArrayList<WeakReference<i>> mPresenters = new CopyOnWriteArrayList<>();
    private boolean mPreventDispatchingItemsChanged = false;
    private boolean mQwertyMode;
    private final Resources mResources;
    private boolean mShortcutsVisible;
    private boolean mStructureChangedWhileDispatchPrevented = false;
    private ArrayList<g> mTempShortcutItemList = new ArrayList<>();
    private ArrayList<g> mVisibleItems;

    public interface a {
        boolean onMenuItemSelected(e eVar, MenuItem menuItem);

        void onMenuModeChange(e eVar);
    }

    public interface b {
        boolean a(g gVar);
    }

    public e(Context context) {
        this.mContext = context;
        this.mResources = context.getResources();
        this.mItems = new ArrayList<>();
        this.mVisibleItems = new ArrayList<>();
        this.mIsVisibleItemsStale = true;
        this.mActionItems = new ArrayList<>();
        this.mNonActionItems = new ArrayList<>();
        this.mIsActionItemsStale = true;
        setShortcutsVisibleInner(true);
    }

    private g createNewMenuItem(int i11, int i12, int i13, int i14, CharSequence charSequence, int i15) {
        return new g(this, i11, i12, i13, i14, charSequence, i15);
    }

    private void dispatchPresenterUpdate(boolean z11) {
        if (!this.mPresenters.isEmpty()) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<i>> it2 = this.mPresenters.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                i iVar = (i) next.get();
                if (iVar == null) {
                    this.mPresenters.remove(next);
                } else {
                    iVar.updateMenuView(z11);
                }
            }
            startDispatchingItemsChanged();
        }
    }

    private void dispatchRestoreInstanceState(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(PRESENTER_KEY);
        if (sparseParcelableArray != null && !this.mPresenters.isEmpty()) {
            Iterator<WeakReference<i>> it2 = this.mPresenters.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                i iVar = (i) next.get();
                if (iVar == null) {
                    this.mPresenters.remove(next);
                } else {
                    int id2 = iVar.getId();
                    if (id2 > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id2)) != null) {
                        iVar.onRestoreInstanceState(parcelable);
                    }
                }
            }
        }
    }

    private void dispatchSaveInstanceState(Bundle bundle) {
        Parcelable onSaveInstanceState;
        if (!this.mPresenters.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator<WeakReference<i>> it2 = this.mPresenters.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                i iVar = (i) next.get();
                if (iVar == null) {
                    this.mPresenters.remove(next);
                } else {
                    int id2 = iVar.getId();
                    if (id2 > 0 && (onSaveInstanceState = iVar.onSaveInstanceState()) != null) {
                        sparseArray.put(id2, onSaveInstanceState);
                    }
                }
            }
            bundle.putSparseParcelableArray(PRESENTER_KEY, sparseArray);
        }
    }

    private boolean dispatchSubMenuSelected(l lVar, i iVar) {
        boolean z11 = false;
        if (this.mPresenters.isEmpty()) {
            return false;
        }
        if (iVar != null) {
            z11 = iVar.onSubMenuSelected(lVar);
        }
        Iterator<WeakReference<i>> it2 = this.mPresenters.iterator();
        while (it2.hasNext()) {
            WeakReference next = it2.next();
            i iVar2 = (i) next.get();
            if (iVar2 == null) {
                this.mPresenters.remove(next);
            } else if (!z11) {
                z11 = iVar2.onSubMenuSelected(lVar);
            }
        }
        return z11;
    }

    private static int findInsertIndex(ArrayList<g> arrayList, int i11) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f() <= i11) {
                return size + 1;
            }
        }
        return 0;
    }

    private static int getOrdering(int i11) {
        int i12 = (-65536 & i11) >> 16;
        if (i12 >= 0) {
            int[] iArr = sCategoryToOrder;
            if (i12 < iArr.length) {
                return (i11 & 65535) | (iArr[i12] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void removeItemAtInt(int i11, boolean z11) {
        if (i11 >= 0 && i11 < this.mItems.size()) {
            this.mItems.remove(i11);
            if (z11) {
                onItemsChanged(true);
            }
        }
    }

    private void setHeaderInternal(int i11, CharSequence charSequence, int i12, Drawable drawable, View view) {
        Resources resources = getResources();
        if (view != null) {
            this.mHeaderView = view;
            this.mHeaderTitle = null;
            this.mHeaderIcon = null;
        } else {
            if (i11 > 0) {
                this.mHeaderTitle = resources.getText(i11);
            } else if (charSequence != null) {
                this.mHeaderTitle = charSequence;
            }
            if (i12 > 0) {
                this.mHeaderIcon = ContextCompat.getDrawable(getContext(), i12);
            } else if (drawable != null) {
                this.mHeaderIcon = drawable;
            }
            this.mHeaderView = null;
        }
        onItemsChanged(false);
    }

    private void setShortcutsVisibleInner(boolean z11) {
        boolean z12 = true;
        if (!z11 || this.mResources.getConfiguration().keyboard == 1 || !j0.g(ViewConfiguration.get(this.mContext), this.mContext)) {
            z12 = false;
        }
        this.mShortcutsVisible = z12;
    }

    public MenuItem add(CharSequence charSequence) {
        return addInternal(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i11, int i12, int i13, ComponentName componentName, Intent[] intentArr, Intent intent, int i14, MenuItem[] menuItemArr) {
        int i15;
        PackageManager packageManager = this.mContext.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i14 & 1) == 0) {
            removeGroup(i11);
        }
        for (int i16 = 0; i16 < size; i16++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i16);
            int i17 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i17 < 0 ? intent : intentArr[i17]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i11, i12, i13, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i15 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i15] = intent3;
            }
        }
        return size;
    }

    public MenuItem addInternal(int i11, int i12, int i13, CharSequence charSequence) {
        int ordering = getOrdering(i13);
        g createNewMenuItem = createNewMenuItem(i11, i12, i13, ordering, charSequence, this.mDefaultShowAsAction);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.mCurrentMenuInfo;
        if (contextMenuInfo != null) {
            createNewMenuItem.v(contextMenuInfo);
        }
        ArrayList<g> arrayList = this.mItems;
        arrayList.add(findInsertIndex(arrayList, ordering), createNewMenuItem);
        onItemsChanged(true);
        return createNewMenuItem;
    }

    public void addMenuPresenter(i iVar) {
        addMenuPresenter(iVar, this.mContext);
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void changeMenuMode() {
        a aVar = this.mCallback;
        if (aVar != null) {
            aVar.onMenuModeChange(this);
        }
    }

    public void clear() {
        g gVar = this.mExpandedItem;
        if (gVar != null) {
            collapseItemActionView(gVar);
        }
        this.mItems.clear();
        onItemsChanged(true);
    }

    public void clearAll() {
        this.mPreventDispatchingItemsChanged = true;
        clear();
        clearHeader();
        this.mPresenters.clear();
        this.mPreventDispatchingItemsChanged = false;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        onItemsChanged(true);
    }

    public void clearHeader() {
        this.mHeaderIcon = null;
        this.mHeaderTitle = null;
        this.mHeaderView = null;
        onItemsChanged(false);
    }

    public final void close(boolean z11) {
        if (!this.mIsClosing) {
            this.mIsClosing = true;
            Iterator<WeakReference<i>> it2 = this.mPresenters.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                i iVar = (i) next.get();
                if (iVar == null) {
                    this.mPresenters.remove(next);
                } else {
                    iVar.onCloseMenu(this, z11);
                }
            }
            this.mIsClosing = false;
        }
    }

    public boolean collapseItemActionView(g gVar) {
        boolean z11 = false;
        if (!this.mPresenters.isEmpty() && this.mExpandedItem == gVar) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<i>> it2 = this.mPresenters.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                i iVar = (i) next.get();
                if (iVar == null) {
                    this.mPresenters.remove(next);
                } else {
                    z11 = iVar.collapseItemActionView(this, gVar);
                    if (z11) {
                        break;
                    }
                }
            }
            startDispatchingItemsChanged();
            if (z11) {
                this.mExpandedItem = null;
            }
        }
        return z11;
    }

    public boolean dispatchMenuItemSelected(e eVar, MenuItem menuItem) {
        a aVar = this.mCallback;
        return aVar != null && aVar.onMenuItemSelected(eVar, menuItem);
    }

    public boolean expandItemActionView(g gVar) {
        boolean z11 = false;
        if (this.mPresenters.isEmpty()) {
            return false;
        }
        stopDispatchingItemsChanged();
        Iterator<WeakReference<i>> it2 = this.mPresenters.iterator();
        while (it2.hasNext()) {
            WeakReference next = it2.next();
            i iVar = (i) next.get();
            if (iVar == null) {
                this.mPresenters.remove(next);
            } else {
                z11 = iVar.expandItemActionView(this, gVar);
                if (z11) {
                    break;
                }
            }
        }
        startDispatchingItemsChanged();
        if (z11) {
            this.mExpandedItem = gVar;
        }
        return z11;
    }

    public int findGroupIndex(int i11) {
        return findGroupIndex(i11, 0);
    }

    public MenuItem findItem(int i11) {
        MenuItem findItem;
        int size = size();
        for (int i12 = 0; i12 < size; i12++) {
            g gVar = this.mItems.get(i12);
            if (gVar.getItemId() == i11) {
                return gVar;
            }
            if (gVar.hasSubMenu() && (findItem = gVar.getSubMenu().findItem(i11)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public int findItemIndex(int i11) {
        int size = size();
        for (int i12 = 0; i12 < size; i12++) {
            if (this.mItems.get(i12).getItemId() == i11) {
                return i12;
            }
        }
        return -1;
    }

    public g findItemWithShortcutForKey(int i11, KeyEvent keyEvent) {
        char c11;
        ArrayList<g> arrayList = this.mTempShortcutItemList;
        arrayList.clear();
        findItemsWithShortcutForKey(arrayList, i11, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean isQwertyMode = isQwertyMode();
        for (int i12 = 0; i12 < size; i12++) {
            g gVar = arrayList.get(i12);
            if (isQwertyMode) {
                c11 = gVar.getAlphabeticShortcut();
            } else {
                c11 = gVar.getNumericShortcut();
            }
            char[] cArr = keyData.meta;
            if ((c11 == cArr[0] && (metaState & 2) == 0) || ((c11 == cArr[2] && (metaState & 2) != 0) || (isQwertyMode && c11 == 8 && i11 == 67))) {
                return gVar;
            }
        }
        return null;
    }

    public void findItemsWithShortcutForKey(List<g> list, int i11, KeyEvent keyEvent) {
        boolean isQwertyMode = isQwertyMode();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i11 == 67) {
            int size = this.mItems.size();
            for (int i12 = 0; i12 < size; i12++) {
                g gVar = this.mItems.get(i12);
                if (gVar.hasSubMenu()) {
                    ((e) gVar.getSubMenu()).findItemsWithShortcutForKey(list, i11, keyEvent);
                }
                char alphabeticShortcut = isQwertyMode ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
                if (((modifiers & 69647) == ((isQwertyMode ? gVar.getAlphabeticModifiers() : gVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (isQwertyMode && alphabeticShortcut == 8 && i11 == 67)) && gVar.isEnabled()) {
                        list.add(gVar);
                    }
                }
            }
        }
    }

    public void flagActionItems() {
        ArrayList<g> visibleItems = getVisibleItems();
        if (this.mIsActionItemsStale) {
            Iterator<WeakReference<i>> it2 = this.mPresenters.iterator();
            boolean z11 = false;
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                i iVar = (i) next.get();
                if (iVar == null) {
                    this.mPresenters.remove(next);
                } else {
                    z11 |= iVar.flagActionItems();
                }
            }
            if (z11) {
                this.mActionItems.clear();
                this.mNonActionItems.clear();
                int size = visibleItems.size();
                for (int i11 = 0; i11 < size; i11++) {
                    g gVar = visibleItems.get(i11);
                    if (gVar.l()) {
                        this.mActionItems.add(gVar);
                    } else {
                        this.mNonActionItems.add(gVar);
                    }
                }
            } else {
                this.mActionItems.clear();
                this.mNonActionItems.clear();
                this.mNonActionItems.addAll(getVisibleItems());
            }
            this.mIsActionItemsStale = false;
        }
    }

    public ArrayList<g> getActionItems() {
        flagActionItems();
        return this.mActionItems;
    }

    public String getActionViewStatesKey() {
        return ACTION_VIEW_STATES_KEY;
    }

    public Context getContext() {
        return this.mContext;
    }

    public g getExpandedItem() {
        return this.mExpandedItem;
    }

    public Drawable getHeaderIcon() {
        return this.mHeaderIcon;
    }

    public CharSequence getHeaderTitle() {
        return this.mHeaderTitle;
    }

    public View getHeaderView() {
        return this.mHeaderView;
    }

    public MenuItem getItem(int i11) {
        return this.mItems.get(i11);
    }

    public ArrayList<g> getNonActionItems() {
        flagActionItems();
        return this.mNonActionItems;
    }

    public boolean getOptionalIconsVisible() {
        return this.mOptionalIconsVisible;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public e getRootMenu() {
        return this;
    }

    public ArrayList<g> getVisibleItems() {
        if (!this.mIsVisibleItemsStale) {
            return this.mVisibleItems;
        }
        this.mVisibleItems.clear();
        int size = this.mItems.size();
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = this.mItems.get(i11);
            if (gVar.isVisible()) {
                this.mVisibleItems.add(gVar);
            }
        }
        this.mIsVisibleItemsStale = false;
        this.mIsActionItemsStale = true;
        return this.mVisibleItems;
    }

    public boolean hasVisibleItems() {
        if (this.mOverrideVisibleItems) {
            return true;
        }
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.mItems.get(i11).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean isGroupDividerEnabled() {
        return this.mGroupDividerEnabled;
    }

    public boolean isQwertyMode() {
        return this.mQwertyMode;
    }

    public boolean isShortcutKey(int i11, KeyEvent keyEvent) {
        return findItemWithShortcutForKey(i11, keyEvent) != null;
    }

    public boolean isShortcutsVisible() {
        return this.mShortcutsVisible;
    }

    public void onItemActionRequestChanged(g gVar) {
        this.mIsActionItemsStale = true;
        onItemsChanged(true);
    }

    public void onItemVisibleChanged(g gVar) {
        this.mIsVisibleItemsStale = true;
        onItemsChanged(true);
    }

    public void onItemsChanged(boolean z11) {
        if (!this.mPreventDispatchingItemsChanged) {
            if (z11) {
                this.mIsVisibleItemsStale = true;
                this.mIsActionItemsStale = true;
            }
            dispatchPresenterUpdate(z11);
            return;
        }
        this.mItemsChangedWhileDispatchPrevented = true;
        if (z11) {
            this.mStructureChangedWhileDispatchPrevented = true;
        }
    }

    public boolean performIdentifierAction(int i11, int i12) {
        return performItemAction(findItem(i11), i12);
    }

    public boolean performItemAction(MenuItem menuItem, int i11) {
        return performItemAction(menuItem, (i) null, i11);
    }

    public boolean performShortcut(int i11, KeyEvent keyEvent, int i12) {
        g findItemWithShortcutForKey = findItemWithShortcutForKey(i11, keyEvent);
        boolean performItemAction = findItemWithShortcutForKey != null ? performItemAction(findItemWithShortcutForKey, i12) : false;
        if ((i12 & 2) != 0) {
            close(true);
        }
        return performItemAction;
    }

    public void removeGroup(int i11) {
        int findGroupIndex = findGroupIndex(i11);
        if (findGroupIndex >= 0) {
            int size = this.mItems.size() - findGroupIndex;
            int i12 = 0;
            while (true) {
                int i13 = i12 + 1;
                if (i12 >= size || this.mItems.get(findGroupIndex).getGroupId() != i11) {
                    onItemsChanged(true);
                } else {
                    removeItemAtInt(findGroupIndex, false);
                    i12 = i13;
                }
            }
            onItemsChanged(true);
        }
    }

    public void removeItem(int i11) {
        removeItemAtInt(findItemIndex(i11), true);
    }

    public void removeItemAt(int i11) {
        removeItemAtInt(i11, true);
    }

    public void removeMenuPresenter(i iVar) {
        Iterator<WeakReference<i>> it2 = this.mPresenters.iterator();
        while (it2.hasNext()) {
            WeakReference next = it2.next();
            i iVar2 = (i) next.get();
            if (iVar2 == null || iVar2 == iVar) {
                this.mPresenters.remove(next);
            }
        }
    }

    public void restoreActionViewStates(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(getActionViewStatesKey());
            int size = size();
            for (int i11 = 0; i11 < size; i11++) {
                MenuItem item = getItem(i11);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((l) item.getSubMenu()).restoreActionViewStates(bundle);
                }
            }
            int i12 = bundle.getInt(EXPANDED_ACTION_VIEW_ID);
            if (i12 > 0 && (findItem = findItem(i12)) != null) {
                findItem.expandActionView();
            }
        }
    }

    public void restorePresenterStates(Bundle bundle) {
        dispatchRestoreInstanceState(bundle);
    }

    public void saveActionViewStates(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i11 = 0; i11 < size; i11++) {
            MenuItem item = getItem(i11);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt(EXPANDED_ACTION_VIEW_ID, item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((l) item.getSubMenu()).saveActionViewStates(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(getActionViewStatesKey(), sparseArray);
        }
    }

    public void savePresenterStates(Bundle bundle) {
        dispatchSaveInstanceState(bundle);
    }

    public void setCallback(a aVar) {
        this.mCallback = aVar;
    }

    public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mCurrentMenuInfo = contextMenuInfo;
    }

    public e setDefaultShowAsAction(int i11) {
        this.mDefaultShowAsAction = i11;
        return this;
    }

    public void setExclusiveItemChecked(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.mItems.size();
        stopDispatchingItemsChanged();
        for (int i11 = 0; i11 < size; i11++) {
            g gVar = this.mItems.get(i11);
            if (gVar.getGroupId() == groupId && gVar.m() && gVar.isCheckable()) {
                gVar.s(gVar == menuItem);
            }
        }
        startDispatchingItemsChanged();
    }

    public void setGroupCheckable(int i11, boolean z11, boolean z12) {
        int size = this.mItems.size();
        for (int i12 = 0; i12 < size; i12++) {
            g gVar = this.mItems.get(i12);
            if (gVar.getGroupId() == i11) {
                gVar.t(z12);
                gVar.setCheckable(z11);
            }
        }
    }

    public void setGroupDividerEnabled(boolean z11) {
        this.mGroupDividerEnabled = z11;
    }

    public void setGroupEnabled(int i11, boolean z11) {
        int size = this.mItems.size();
        for (int i12 = 0; i12 < size; i12++) {
            g gVar = this.mItems.get(i12);
            if (gVar.getGroupId() == i11) {
                gVar.setEnabled(z11);
            }
        }
    }

    public void setGroupVisible(int i11, boolean z11) {
        int size = this.mItems.size();
        boolean z12 = false;
        for (int i12 = 0; i12 < size; i12++) {
            g gVar = this.mItems.get(i12);
            if (gVar.getGroupId() == i11 && gVar.y(z11)) {
                z12 = true;
            }
        }
        if (z12) {
            onItemsChanged(true);
        }
    }

    public e setHeaderIconInt(Drawable drawable) {
        setHeaderInternal(0, (CharSequence) null, 0, drawable, (View) null);
        return this;
    }

    public e setHeaderTitleInt(CharSequence charSequence) {
        setHeaderInternal(0, charSequence, 0, (Drawable) null, (View) null);
        return this;
    }

    public e setHeaderViewInt(View view) {
        setHeaderInternal(0, (CharSequence) null, 0, (Drawable) null, view);
        return this;
    }

    public void setOptionalIconsVisible(boolean z11) {
        this.mOptionalIconsVisible = z11;
    }

    public void setOverrideVisibleItems(boolean z11) {
        this.mOverrideVisibleItems = z11;
    }

    public void setQwertyMode(boolean z11) {
        this.mQwertyMode = z11;
        onItemsChanged(false);
    }

    public void setShortcutsVisible(boolean z11) {
        if (this.mShortcutsVisible != z11) {
            setShortcutsVisibleInner(z11);
            onItemsChanged(false);
        }
    }

    public int size() {
        return this.mItems.size();
    }

    public void startDispatchingItemsChanged() {
        this.mPreventDispatchingItemsChanged = false;
        if (this.mItemsChangedWhileDispatchPrevented) {
            this.mItemsChangedWhileDispatchPrevented = false;
            onItemsChanged(this.mStructureChangedWhileDispatchPrevented);
        }
    }

    public void stopDispatchingItemsChanged() {
        if (!this.mPreventDispatchingItemsChanged) {
            this.mPreventDispatchingItemsChanged = true;
            this.mItemsChangedWhileDispatchPrevented = false;
            this.mStructureChangedWhileDispatchPrevented = false;
        }
    }

    public MenuItem add(int i11) {
        return addInternal(0, 0, 0, this.mResources.getString(i11));
    }

    public void addMenuPresenter(i iVar, Context context) {
        this.mPresenters.add(new WeakReference(iVar));
        iVar.initForMenu(context, this);
        this.mIsActionItemsStale = true;
    }

    public SubMenu addSubMenu(int i11) {
        return addSubMenu(0, 0, 0, (CharSequence) this.mResources.getString(i11));
    }

    public int findGroupIndex(int i11, int i12) {
        int size = size();
        if (i12 < 0) {
            i12 = 0;
        }
        while (i12 < size) {
            if (this.mItems.get(i12).getGroupId() == i11) {
                return i12;
            }
            i12++;
        }
        return -1;
    }

    public boolean performItemAction(MenuItem menuItem, i iVar, int i11) {
        g gVar = (g) menuItem;
        if (gVar == null || !gVar.isEnabled()) {
            return false;
        }
        boolean k11 = gVar.k();
        androidx.core.view.a a11 = gVar.a();
        boolean z11 = a11 != null && a11.a();
        if (gVar.j()) {
            k11 |= gVar.expandActionView();
            if (k11) {
                close(true);
            }
        } else if (gVar.hasSubMenu() || z11) {
            if ((i11 & 4) == 0) {
                close(false);
            }
            if (!gVar.hasSubMenu()) {
                gVar.x(new l(getContext(), this, gVar));
            }
            l lVar = (l) gVar.getSubMenu();
            if (z11) {
                a11.f(lVar);
            }
            k11 |= dispatchSubMenuSelected(lVar, iVar);
            if (!k11) {
                close(true);
            }
        } else if ((i11 & 1) == 0) {
            close(true);
        }
        return k11;
    }

    public e setHeaderIconInt(int i11) {
        setHeaderInternal(0, (CharSequence) null, i11, (Drawable) null, (View) null);
        return this;
    }

    public e setHeaderTitleInt(int i11) {
        setHeaderInternal(i11, (CharSequence) null, 0, (Drawable) null, (View) null);
        return this;
    }

    public MenuItem add(int i11, int i12, int i13, CharSequence charSequence) {
        return addInternal(i11, i12, i13, charSequence);
    }

    public SubMenu addSubMenu(int i11, int i12, int i13, CharSequence charSequence) {
        g gVar = (g) addInternal(i11, i12, i13, charSequence);
        l lVar = new l(this.mContext, this, gVar);
        gVar.x(lVar);
        return lVar;
    }

    public MenuItem add(int i11, int i12, int i13, int i14) {
        return addInternal(i11, i12, i13, this.mResources.getString(i14));
    }

    public SubMenu addSubMenu(int i11, int i12, int i13, int i14) {
        return addSubMenu(i11, i12, i13, (CharSequence) this.mResources.getString(i14));
    }

    public void close() {
        close(true);
    }
}
