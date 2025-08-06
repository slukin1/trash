package com.jumio.defaultui.view;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.jumio.core.data.country.Country;
import com.jumio.defaultui.R;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;
import pw.c;

public final class CountrySelectionAdapter extends RecyclerView.Adapter<CountryViewHolder> {
    /* access modifiers changed from: private */
    public final List<Country> countries;
    /* access modifiers changed from: private */
    public final l<Country, Unit> onItemClick;
    private final String selectedCountry;

    public static final class CountryViewHolder extends RecyclerView.ViewHolder {
        private final LinearLayout background;
        private final TextView tvCountry;

        public CountryViewHolder(View view, l<? super Integer, Unit> lVar) {
            super(view);
            view.setOnClickListener(new c(lVar, this));
            this.tvCountry = (TextView) view.findViewById(R.id.tv_country);
            this.background = (LinearLayout) view.findViewById(R.id.holder_bg);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public static final void _init_$lambda$0(l lVar, CountryViewHolder countryViewHolder, View view) {
            lVar.invoke(Integer.valueOf(countryViewHolder.getAbsoluteAdapterPosition()));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public final LinearLayout getBackground() {
            return this.background;
        }

        public final TextView getTvCountry() {
            return this.tvCountry;
        }
    }

    public static final class a extends Lambda implements l<Integer, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CountrySelectionAdapter f70824a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CountrySelectionAdapter countrySelectionAdapter) {
            super(1);
            this.f70824a = countrySelectionAdapter;
        }

        public final Object invoke(Object obj) {
            this.f70824a.onItemClick.invoke(this.f70824a.countries.get(((Number) obj).intValue()));
            return Unit.f56620a;
        }
    }

    public CountrySelectionAdapter(List<Country> list, l<? super Country, Unit> lVar, String str) {
        this.countries = list;
        this.onItemClick = lVar;
        this.selectedCountry = str;
    }

    private final void checkIfSelected(CountryViewHolder countryViewHolder, String str) {
        countryViewHolder.getBackground().setSelected(x.b(str, this.selectedCountry));
    }

    public final List<Country> filterCountries$jumio_defaultui_release(String str, List<Country> list) {
        if (StringsKt__StringsKt.i1(str).toString().length() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Country next : list) {
            if (StringsKt__StringsKt.P(next.getName(), str, true)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public int getItemCount() {
        return this.countries.size();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void updateViewWithFiltering(String str, List<Country> list) {
        this.countries.clear();
        this.countries.addAll(filterCountries$jumio_defaultui_release(str, list));
        notifyDataSetChanged();
    }

    public void onBindViewHolder(CountryViewHolder countryViewHolder, int i11) {
        Country country = this.countries.get(i11);
        countryViewHolder.getTvCountry().setText(country.getName());
        checkIfSelected(countryViewHolder, country.getIsoCode());
    }

    public CountryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new CountryViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.jumio_fragment_country_selection_item, viewGroup, false), new a(this));
    }
}
