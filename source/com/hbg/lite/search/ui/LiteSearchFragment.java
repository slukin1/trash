package com.hbg.lite.search.ui;

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
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.search.bean.LiteChooseCurrencyItem;
import com.huobi.view.indexlist.EntityWrapper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import mb.g;
import mb.h;

public class LiteSearchFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f77460b;

    /* renamed from: c  reason: collision with root package name */
    public View f77461c;

    /* renamed from: d  reason: collision with root package name */
    public a f77462d;

    /* renamed from: e  reason: collision with root package name */
    public List<LiteChooseCurrencyItem> f77463e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public String f77464f;

    /* renamed from: g  reason: collision with root package name */
    public a.d f77465g;

    public static class a extends RecyclerView.Adapter<e> implements Filterable {

        /* renamed from: b  reason: collision with root package name */
        public List<LiteChooseCurrencyItem> f77466b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public List<LiteChooseCurrencyItem> f77467c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        public d f77468d;

        /* renamed from: e  reason: collision with root package name */
        public c f77469e;

        /* renamed from: f  reason: collision with root package name */
        public LayoutInflater f77470f;

        /* renamed from: g  reason: collision with root package name */
        public Comparator<LiteChooseCurrencyItem> f77471g;

        /* renamed from: com.hbg.lite.search.ui.LiteSearchFragment$a$a  reason: collision with other inner class name */
        public class C0830a extends Filter {
            public C0830a() {
            }

            public Filter.FilterResults performFiltering(CharSequence charSequence) {
                ArrayList arrayList = new ArrayList();
                for (LiteChooseCurrencyItem liteChooseCurrencyItem : a.this.f77467c) {
                    if (StringUtils.g(liteChooseCurrencyItem.getSearchKey()).startsWith(StringUtils.g(charSequence.toString())) || StringUtils.g(liteChooseCurrencyItem.getSearchKey()).contains(StringUtils.g(charSequence.toString()))) {
                        arrayList.add(liteChooseCurrencyItem);
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
                a.this.f77466b.clear();
                if (arrayList != null && arrayList.size() > 0) {
                    a.this.f77466b.addAll(arrayList);
                }
                if (a.this.f77469e != null) {
                    a.this.f77469e.a(arrayList);
                }
                a.this.notifyDataSetChanged();
            }
        }

        public class b implements Comparator<LiteChooseCurrencyItem> {

            /* renamed from: b  reason: collision with root package name */
            public int f77473b;

            /* renamed from: c  reason: collision with root package name */
            public int f77474c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f77475d;

            public b(String str) {
                this.f77475d = str;
            }

            /* renamed from: a */
            public int compare(LiteChooseCurrencyItem liteChooseCurrencyItem, LiteChooseCurrencyItem liteChooseCurrencyItem2) {
                if (liteChooseCurrencyItem.getName().equalsIgnoreCase(this.f77475d)) {
                    this.f77473b = Integer.MAX_VALUE;
                } else if (liteChooseCurrencyItem.getName().startsWith(this.f77475d)) {
                    this.f77473b = EntityWrapper.TYPE_TITLE;
                } else {
                    this.f77473b = 2147483645;
                }
                if (liteChooseCurrencyItem2.getName().equalsIgnoreCase(this.f77475d)) {
                    this.f77474c = Integer.MAX_VALUE;
                } else if (liteChooseCurrencyItem2.getName().startsWith(this.f77475d)) {
                    this.f77474c = EntityWrapper.TYPE_TITLE;
                } else {
                    this.f77474c = 2147483645;
                }
                return this.f77474c - this.f77473b;
            }
        }

        public interface c {
            void a(List<LiteChooseCurrencyItem> list);
        }

        public interface d {
            void a(LiteChooseCurrencyItem liteChooseCurrencyItem, int i11);
        }

        public class e extends RecyclerView.ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            public TextView f77477a;

            public e(View view) {
                super(view);
                this.f77477a = (TextView) view.findViewById(R$id.tv_name);
            }
        }

        public a(List<LiteChooseCurrencyItem> list) {
            if (list != null && !list.isEmpty()) {
                this.f77466b.clear();
                this.f77466b.addAll(list);
                this.f77467c.clear();
                this.f77467c.addAll(list);
            }
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void h(int i11, View view) {
            if (this.f77468d != null && i11 < this.f77466b.size()) {
                this.f77468d.a(this.f77466b.get(i11), i11);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public final Comparator<LiteChooseCurrencyItem> g(String str) {
            if (str == null) {
                return null;
            }
            b bVar = new b(str);
            this.f77471g = bVar;
            return bVar;
        }

        public Filter getFilter() {
            return new C0830a();
        }

        public int getItemCount() {
            return this.f77466b.size();
        }

        /* renamed from: i */
        public void onBindViewHolder(e eVar, int i11) {
            eVar.f77477a.setText((this.f77466b.get(i11) == null ? "" : this.f77466b.get(i11).getName()).toUpperCase(Locale.US));
            eVar.f77477a.setOnClickListener(new h(this, i11));
        }

        /* renamed from: j */
        public e onCreateViewHolder(ViewGroup viewGroup, int i11) {
            if (this.f77470f == null) {
                this.f77470f = LayoutInflater.from(viewGroup.getContext());
            }
            return new e(this.f77470f.inflate(R$layout.lite_item_currency_choose, viewGroup, false));
        }

        public void k(c cVar) {
            this.f77469e = cVar;
        }

        public void l(d dVar) {
            this.f77468d = dVar;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void sh(List list) {
        if (list == null || list.isEmpty()) {
            this.f77461c.setVisibility(0);
        } else {
            this.f77461c.setVisibility(8);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R$layout.fragment_lite_search, viewGroup, false);
        View findViewById = inflate.findViewById(R$id.no_result);
        this.f77461c = findViewById;
        findViewById.setVisibility(8);
        this.f77460b = (RecyclerView) inflate.findViewById(R$id.result_list);
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

    public void qh(List<LiteChooseCurrencyItem> list) {
        if (list != null) {
            this.f77463e.clear();
            this.f77463e.addAll(list);
            a aVar = this.f77462d;
            if (aVar == null) {
                a aVar2 = new a(this.f77463e);
                this.f77462d = aVar2;
                aVar2.k(new g(this));
                a.d dVar = this.f77465g;
                if (dVar != null) {
                    this.f77462d.l(dVar);
                }
                this.f77460b.setLayoutManager(new LinearLayoutManager(getActivity()));
                this.f77460b.setHasFixedSize(true);
                this.f77460b.setAdapter(this.f77462d);
            } else {
                aVar.notifyDataSetChanged();
            }
            if (this.f77464f != null) {
                this.f77462d.getFilter().filter(this.f77464f);
            }
        }
    }

    public void rh(String str) {
        a aVar;
        if (this.f77463e == null) {
            this.f77464f = str.toLowerCase(Locale.US);
        } else if (!TextUtils.isEmpty(str) && (aVar = this.f77462d) != null && aVar.getFilter() != null) {
            this.f77462d.getFilter().filter(str.toLowerCase(Locale.US));
        }
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public void th(a.d dVar) {
        this.f77465g = dVar;
    }
}
