package pw;

import android.view.View;
import androidx.appcompat.widget.SearchView;
import com.jumio.defaultui.view.CountrySelectionFragment;

public final /* synthetic */ class d implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchView f53279b;

    public /* synthetic */ d(SearchView searchView) {
        this.f53279b = searchView;
    }

    public final void onFocusChange(View view, boolean z11) {
        CountrySelectionFragment.initSearchView$lambda$1(this.f53279b, view, z11);
    }
}
