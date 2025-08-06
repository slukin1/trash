package com.jumio.defaultui.view;

import androidx.appcompat.widget.SearchView;
import com.jumio.core.data.country.Country;
import java.util.List;

public final class CountrySelectionFragment$initSearchView$1 implements SearchView.m {
    public final /* synthetic */ List<Country> $countryList;
    public final /* synthetic */ CountrySelectionFragment this$0;

    public CountrySelectionFragment$initSearchView$1(CountrySelectionFragment countrySelectionFragment, List<Country> list) {
        this.this$0 = countrySelectionFragment;
        this.$countryList = list;
    }

    public boolean onQueryTextChange(String str) {
        this.this$0.getCountySelectionAdapter().updateViewWithFiltering(str, this.$countryList);
        return true;
    }

    public boolean onQueryTextSubmit(String str) {
        return false;
    }
}
