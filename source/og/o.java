package og;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huobi.account.entity.ChooseCityEntity;
import com.huobi.view.indexlist.EntityWrapper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import pro.huobi.R;

public class o extends RecyclerView.Adapter<e> implements Filterable {

    /* renamed from: b  reason: collision with root package name */
    public List<ChooseCityEntity> f47675b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<ChooseCityEntity> f47676c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public d f47677d;

    /* renamed from: e  reason: collision with root package name */
    public c f47678e;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f47679f;

    public class a extends Filter {
        public a() {
        }

        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            ArrayList arrayList = new ArrayList();
            for (ChooseCityEntity chooseCityEntity : o.this.f47676c) {
                String upperCase = chooseCityEntity.getSearchKey().toUpperCase();
                String upperCase2 = charSequence.toString().toUpperCase();
                if (upperCase.startsWith(upperCase2) || upperCase.contains(upperCase2)) {
                    arrayList.add(chooseCityEntity);
                }
            }
            Collections.sort(arrayList, o.this.g(charSequence.toString()));
            Filter.FilterResults filterResults = new Filter.FilterResults();
            filterResults.count = arrayList.size();
            filterResults.values = arrayList;
            return filterResults;
        }

        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            ArrayList arrayList = (ArrayList) filterResults.values;
            o.this.f47675b.clear();
            if (arrayList != null && arrayList.size() > 0) {
                o.this.f47675b.addAll(arrayList);
            }
            if (o.this.f47678e != null) {
                o.this.f47678e.a(arrayList);
            }
            o.this.notifyDataSetChanged();
        }
    }

    public class b implements Comparator<ChooseCityEntity> {

        /* renamed from: b  reason: collision with root package name */
        public int f47681b;

        /* renamed from: c  reason: collision with root package name */
        public int f47682c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f47683d;

        public b(String str) {
            this.f47683d = str;
        }

        /* renamed from: a */
        public int compare(ChooseCityEntity chooseCityEntity, ChooseCityEntity chooseCityEntity2) {
            if (chooseCityEntity.getName().equalsIgnoreCase(this.f47683d)) {
                this.f47681b = Integer.MAX_VALUE;
            } else if (chooseCityEntity.getName().startsWith(this.f47683d)) {
                this.f47681b = EntityWrapper.TYPE_TITLE;
            } else {
                this.f47681b = 2147483645;
            }
            if (chooseCityEntity2.getName().equalsIgnoreCase(this.f47683d)) {
                this.f47682c = Integer.MAX_VALUE;
            } else if (chooseCityEntity2.getName().startsWith(this.f47683d)) {
                this.f47682c = EntityWrapper.TYPE_TITLE;
            } else {
                this.f47682c = 2147483645;
            }
            return this.f47682c - this.f47681b;
        }
    }

    public interface c {
        void a(List<ChooseCityEntity> list);
    }

    public interface d {
        void a(ChooseCityEntity chooseCityEntity, int i11);
    }

    public static class e extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f47685a;

        public e(View view) {
            super(view);
            this.f47685a = (TextView) view.findViewById(R.id.tv_name);
        }
    }

    public o(List<ChooseCityEntity> list) {
        if (list != null && !list.isEmpty()) {
            this.f47675b.clear();
            this.f47675b.addAll(list);
            this.f47676c.clear();
            this.f47676c.addAll(list);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void h(int i11, View view) {
        if (this.f47677d != null && i11 < this.f47675b.size()) {
            this.f47677d.a(this.f47675b.get(i11), i11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final Comparator<ChooseCityEntity> g(String str) {
        if (str == null) {
            return null;
        }
        return new b(str);
    }

    public Filter getFilter() {
        return new a();
    }

    public int getItemCount() {
        return this.f47675b.size();
    }

    /* renamed from: i */
    public void onBindViewHolder(e eVar, int i11) {
        eVar.f47685a.setText(this.f47675b.get(i11) == null ? "" : this.f47675b.get(i11).getName());
        eVar.itemView.setOnClickListener(new n(this, i11));
    }

    /* renamed from: j */
    public e onCreateViewHolder(ViewGroup viewGroup, int i11) {
        if (this.f47679f == null) {
            this.f47679f = LayoutInflater.from(viewGroup.getContext());
        }
        return new e(this.f47679f.inflate(R.layout.item_city_choose_search, viewGroup, false));
    }

    public void k(c cVar) {
        this.f47678e = cVar;
    }

    public void l(d dVar) {
        this.f47677d = dVar;
    }
}
