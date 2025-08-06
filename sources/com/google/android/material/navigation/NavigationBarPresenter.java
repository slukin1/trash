package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.l;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ParcelableSparseArray;

public class NavigationBarPresenter implements i {

    /* renamed from: id  reason: collision with root package name */
    private int f66761id;
    private e menu;
    private NavigationBarMenuView menuView;
    private boolean updateSuspended = false;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        };
        public ParcelableSparseArray badgeSavedStates;
        public int selectedItemId;

        public SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.selectedItemId);
            parcel.writeParcelable(this.badgeSavedStates, 0);
        }

        public SavedState(Parcel parcel) {
            this.selectedItemId = parcel.readInt();
            this.badgeSavedStates = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
        }
    }

    public boolean collapseItemActionView(e eVar, g gVar) {
        return false;
    }

    public boolean expandItemActionView(e eVar, g gVar) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getId() {
        return this.f66761id;
    }

    public j getMenuView(ViewGroup viewGroup) {
        return this.menuView;
    }

    public void initForMenu(Context context, e eVar) {
        this.menu = eVar;
        this.menuView.initialize(eVar);
    }

    public void onCloseMenu(e eVar, boolean z11) {
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.menuView.tryRestoreSelectedItemId(savedState.selectedItemId);
            this.menuView.setBadgeDrawables(BadgeUtils.createBadgeDrawablesFromSavedStates(this.menuView.getContext(), savedState.badgeSavedStates));
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.selectedItemId = this.menuView.getSelectedItemId();
        savedState.badgeSavedStates = BadgeUtils.createParcelableBadgeStates(this.menuView.getBadgeDrawables());
        return savedState;
    }

    public boolean onSubMenuSelected(l lVar) {
        return false;
    }

    public void setCallback(i.a aVar) {
    }

    public void setId(int i11) {
        this.f66761id = i11;
    }

    public void setMenuView(NavigationBarMenuView navigationBarMenuView) {
        this.menuView = navigationBarMenuView;
    }

    public void setUpdateSuspended(boolean z11) {
        this.updateSuspended = z11;
    }

    public void updateMenuView(boolean z11) {
        if (!this.updateSuspended) {
            if (z11) {
                this.menuView.buildMenuView();
            } else {
                this.menuView.updateMenuView();
            }
        }
    }
}
