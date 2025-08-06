package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Parcelable;

public interface i {

    public interface a {
        boolean a(e eVar);

        void onCloseMenu(e eVar, boolean z11);
    }

    boolean collapseItemActionView(e eVar, g gVar);

    boolean expandItemActionView(e eVar, g gVar);

    boolean flagActionItems();

    int getId();

    void initForMenu(Context context, e eVar);

    void onCloseMenu(e eVar, boolean z11);

    void onRestoreInstanceState(Parcelable parcelable);

    Parcelable onSaveInstanceState();

    boolean onSubMenuSelected(l lVar);

    void setCallback(a aVar);

    void updateMenuView(boolean z11);
}
