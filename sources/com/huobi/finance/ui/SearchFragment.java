package com.huobi.finance.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huobi.finance.bean.SymbolCurrencyEntity;
import com.huobi.view.indexlist.EntityWrapper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import pro.huobi.R;

public class SearchFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f46779b;

    /* renamed from: c  reason: collision with root package name */
    public View f46780c;

    /* renamed from: d  reason: collision with root package name */
    public a f46781d;

    /* renamed from: e  reason: collision with root package name */
    public List<SymbolCurrencyEntity> f46782e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public String f46783f;

    /* renamed from: g  reason: collision with root package name */
    public a.d f46784g;

    public static class a extends RecyclerView.Adapter<e> implements Filterable {

        /* renamed from: b  reason: collision with root package name */
        public List<SymbolCurrencyEntity> f46785b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public List<SymbolCurrencyEntity> f46786c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        public d f46787d;

        /* renamed from: e  reason: collision with root package name */
        public c f46788e;

        /* renamed from: f  reason: collision with root package name */
        public LayoutInflater f46789f;

        /* renamed from: g  reason: collision with root package name */
        public Comparator<SymbolCurrencyEntity> f46790g;

        /* renamed from: com.huobi.finance.ui.SearchFragment$a$a  reason: collision with other inner class name */
        public class C0573a extends Filter {
            public C0573a() {
            }

            public Filter.FilterResults performFiltering(CharSequence charSequence) {
                ArrayList arrayList = new ArrayList();
                for (SymbolCurrencyEntity symbolCurrencyEntity : a.this.f46786c) {
                    if (symbolCurrencyEntity.getSearchKey().startsWith(charSequence.toString()) || symbolCurrencyEntity.getSearchKey().contains(charSequence)) {
                        arrayList.add(symbolCurrencyEntity);
                    }
                }
                Collections.sort(arrayList, a.this.g(charSequence.toString()));
                Filter.FilterResults filterResults = new Filter.FilterResults();
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
                return filterResults;
            }

            public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                ArrayList arrayList = (ArrayList) filterResults.values;
                a.this.f46785b.clear();
                if (arrayList != null && arrayList.size() > 0) {
                    a.this.f46785b.addAll(arrayList);
                }
                if (a.this.f46788e != null) {
                    a.this.f46788e.a(arrayList);
                }
                a.this.notifyDataSetChanged();
            }
        }

        public class b implements Comparator<SymbolCurrencyEntity> {

            /* renamed from: b  reason: collision with root package name */
            public int f46792b;

            /* renamed from: c  reason: collision with root package name */
            public int f46793c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f46794d;

            public b(String str) {
                this.f46794d = str;
            }

            /* renamed from: a */
            public int compare(SymbolCurrencyEntity symbolCurrencyEntity, SymbolCurrencyEntity symbolCurrencyEntity2) {
                if (symbolCurrencyEntity.getName().equalsIgnoreCase(this.f46794d)) {
                    this.f46792b = Integer.MAX_VALUE;
                } else if (symbolCurrencyEntity.getName().startsWith(this.f46794d)) {
                    this.f46792b = EntityWrapper.TYPE_TITLE;
                } else {
                    this.f46792b = 2147483645;
                }
                if (symbolCurrencyEntity2.getName().equalsIgnoreCase(this.f46794d)) {
                    this.f46793c = Integer.MAX_VALUE;
                } else if (symbolCurrencyEntity2.getName().startsWith(this.f46794d)) {
                    this.f46793c = EntityWrapper.TYPE_TITLE;
                } else {
                    this.f46793c = 2147483645;
                }
                return this.f46793c - this.f46792b;
            }
        }

        public interface c {
            void a(List<SymbolCurrencyEntity> list);
        }

        public interface d {
            void a(SymbolCurrencyEntity symbolCurrencyEntity, int i11);
        }

        public class e extends RecyclerView.ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            public TextView f46796a;

            public e(View view) {
                super(view);
                this.f46796a = (TextView) view.findViewById(R.id.tv_name);
            }
        }

        public a(List<SymbolCurrencyEntity> list) {
            if (list != null && !list.isEmpty()) {
                this.f46785b.clear();
                this.f46785b.addAll(list);
                this.f46786c.clear();
                this.f46786c.addAll(list);
            }
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void h(int i11, View view) {
            if (this.f46787d != null && i11 < this.f46785b.size()) {
                this.f46787d.a(this.f46785b.get(i11), i11);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public final Comparator<SymbolCurrencyEntity> g(String str) {
            if (str == null) {
                return null;
            }
            b bVar = new b(str);
            this.f46790g = bVar;
            return bVar;
        }

        public Filter getFilter() {
            return new C0573a();
        }

        public int getItemCount() {
            return this.f46785b.size();
        }

        /* renamed from: i */
        public void onBindViewHolder(e eVar, int i11) {
            eVar.f46796a.setText((this.f46785b.get(i11) == null ? "" : this.f46785b.get(i11).getName()).toUpperCase(Locale.US));
            eVar.f46796a.setOnClickListener(new q7(this, i11));
        }

        /* renamed from: j */
        public e onCreateViewHolder(ViewGroup viewGroup, int i11) {
            if (this.f46789f == null) {
                this.f46789f = LayoutInflater.from(viewGroup.getContext());
            }
            return new e(this.f46789f.inflate(R.layout.item_currency_choose, viewGroup, false));
        }

        public void k(c cVar) {
            this.f46788e = cVar;
        }

        public void l(d dVar) {
            this.f46787d = dVar;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void sh(List list) {
        if (list == null || list.isEmpty()) {
            this.f46780c.setVisibility(0);
        } else {
            this.f46780c.setVisibility(8);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_search_currency, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.no_result);
        this.f46780c = findViewById;
        findViewById.setVisibility(8);
        this.f46779b = (RecyclerView) inflate.findViewById(R.id.result_list);
        return inflate;
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void qh(List<SymbolCurrencyEntity> list) {
        if (list != null) {
            this.f46782e.clear();
            this.f46782e.addAll(list);
            a aVar = this.f46781d;
            if (aVar == null) {
                a aVar2 = new a(this.f46782e);
                this.f46781d = aVar2;
                aVar2.k(new p7(this));
                a.d dVar = this.f46784g;
                if (dVar != null) {
                    this.f46781d.l(dVar);
                }
                this.f46779b.setLayoutManager(new LinearLayoutManager(getActivity()));
                this.f46779b.setHasFixedSize(true);
                this.f46779b.setAdapter(this.f46781d);
            } else {
                aVar.notifyDataSetChanged();
            }
            if (this.f46783f != null) {
                this.f46781d.getFilter().filter(this.f46783f);
            }
        }
    }

    public void rh(String str) {
        a aVar;
        if (this.f46782e == null) {
            this.f46783f = str.toLowerCase(Locale.US);
        } else if (!TextUtils.isEmpty(str) && (aVar = this.f46781d) != null && aVar.getFilter() != null) {
            this.f46781d.getFilter().filter(str.toLowerCase(Locale.US));
        }
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public void th(a.d dVar) {
        this.f46784g = dVar;
    }
}
