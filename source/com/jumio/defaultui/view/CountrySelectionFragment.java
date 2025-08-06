package com.jumio.defaultui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jumio.commons.log.Log;
import com.jumio.core.data.country.Country;
import com.jumio.defaultui.R;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.credentials.JumioIDCredential;
import d10.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jumio.dui.b;
import kotlin.Unit;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import pw.d;

public final class CountrySelectionFragment extends BaseFragment {
    public static final Companion Companion = new Companion((r) null);
    public CountrySelectionAdapter countySelectionAdapter;
    private final i jumioViewModel$delegate = FragmentViewModelLazyKt.c(this, Reflection.b(b.class), new CountrySelectionFragment$special$$inlined$activityViewModels$default$1(this), new CountrySelectionFragment$special$$inlined$activityViewModels$default$2((d10.a) null, this), new CountrySelectionFragment$special$$inlined$activityViewModels$default$3(this));
    private RecyclerView recyclerView;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final List<Country> getCountryList$jumio_defaultui_release(JumioIDCredential jumioIDCredential) {
            List<String> supportedCountries;
            List<Country> list = null;
            if (!(jumioIDCredential == null || (supportedCountries = jumioIDCredential.getSupportedCountries()) == null)) {
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(supportedCountries, 10));
                for (String country : supportedCountries) {
                    arrayList.add(new Country(country, false, 2, (r) null));
                }
                list = Collections.unmodifiableList(arrayList);
            }
            return list == null ? CollectionsKt__CollectionsKt.k() : list;
        }
    }

    public static final class a extends Lambda implements l<Country, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CountrySelectionFragment f70825a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CountrySelectionFragment countrySelectionFragment) {
            super(1);
            this.f70825a = countrySelectionFragment;
        }

        public final void a(Country country) {
            this.f70825a.getJumioViewModel().b(country.getIsoCode());
            b access$getJumioViewModel = this.f70825a.getJumioViewModel();
            Log.d("CountrySelectionFragment", "country " + access$getJumioViewModel + ".selectedCountry selected");
            this.f70825a.dismissKeyboard();
            JumioFragmentCallback callback = this.f70825a.getCallback();
            if (callback != null) {
                callback.countrySelected();
            }
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Country) obj);
            return Unit.f56620a;
        }
    }

    private final void decorateRecyclerView(RecyclerView recyclerView2) {
        new FastScrollerDecorator(recyclerView2);
    }

    /* access modifiers changed from: private */
    public final b getJumioViewModel() {
        return (b) this.jumioViewModel$delegate.getValue();
    }

    private final void initAdapter(RecyclerView recyclerView2, List<Country> list) {
        if (!list.isEmpty()) {
            setCountySelectionAdapter(new CountrySelectionAdapter(CollectionsKt___CollectionsKt.L0(list), new a(this), getJumioViewModel().k()));
            recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
            recyclerView2.setAdapter(getCountySelectionAdapter());
        }
    }

    private final void initSearchView(SearchView searchView, List<Country> list) {
        searchView.setOnQueryTextListener(new CountrySelectionFragment$initSearchView$1(this, list));
        searchView.setOnQueryTextFocusChangeListener(new d(searchView));
    }

    /* access modifiers changed from: private */
    public static final void initSearchView$lambda$1(SearchView searchView, View view, boolean z11) {
        searchView.setSelected(z11);
        searchView.setIconified(!z11);
    }

    public View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.jumio_fragment_country_selection, viewGroup, false);
        this.recyclerView = (RecyclerView) inflate.findViewById(R.id.rv_country_list);
        SearchView searchView = (SearchView) inflate.findViewById(R.id.sv_country_selection_search);
        Companion companion = Companion;
        JumioCredential jumioCredential = getJumioViewModel().f56358f;
        RecyclerView recyclerView2 = null;
        List<Country> countryList$jumio_defaultui_release = companion.getCountryList$jumio_defaultui_release(jumioCredential instanceof JumioIDCredential ? (JumioIDCredential) jumioCredential : null);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            recyclerView3 = null;
        }
        initAdapter(recyclerView3, countryList$jumio_defaultui_release);
        initSearchView(searchView, countryList$jumio_defaultui_release);
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 != null) {
            recyclerView2 = recyclerView4;
        }
        decorateRecyclerView(recyclerView2);
        return inflate;
    }

    public final CountrySelectionAdapter getCountySelectionAdapter() {
        CountrySelectionAdapter countrySelectionAdapter = this.countySelectionAdapter;
        if (countrySelectionAdapter != null) {
            return countrySelectionAdapter;
        }
        return null;
    }

    public final void setCountySelectionAdapter(CountrySelectionAdapter countrySelectionAdapter) {
        this.countySelectionAdapter = countrySelectionAdapter;
    }
}
