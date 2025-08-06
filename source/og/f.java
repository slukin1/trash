package og;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huobi.account.entity.ChooseCityEntity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;

public class f extends RecyclerView.Adapter<b> {

    /* renamed from: a  reason: collision with root package name */
    public List<ChooseCityEntity> f47670a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public a f47671b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f47672c;

    public interface a {
        void a(ChooseCityEntity chooseCityEntity, int i11);
    }

    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f47673a;

        public b(View view) {
            super(view);
            this.f47673a = (TextView) view.findViewById(R.id.tv_name);
        }
    }

    public f(List<ChooseCityEntity> list) {
        if (list != null && !list.isEmpty()) {
            this.f47670a.clear();
            this.f47670a.addAll(list);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void c(int i11, ChooseCityEntity chooseCityEntity, View view) {
        if (this.f47671b != null && i11 < this.f47670a.size()) {
            this.f47671b.a(chooseCityEntity, i11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: d */
    public void onBindViewHolder(b bVar, int i11) {
        String str;
        ChooseCityEntity chooseCityEntity = this.f47670a.get(i11);
        if (chooseCityEntity == null) {
            str = "";
        } else {
            str = chooseCityEntity.getName();
        }
        bVar.f47673a.setText(str);
        bVar.itemView.setSelected(chooseCityEntity != null && chooseCityEntity.isSelected());
        bVar.itemView.setOnClickListener(new e(this, i11, chooseCityEntity));
    }

    /* renamed from: e */
    public b onCreateViewHolder(ViewGroup viewGroup, int i11) {
        if (this.f47672c == null) {
            this.f47672c = LayoutInflater.from(viewGroup.getContext());
        }
        return new b(this.f47672c.inflate(R.layout.item_city_choose_search, viewGroup, false));
    }

    public void f(a aVar) {
        this.f47671b = aVar;
    }

    public int getItemCount() {
        return this.f47670a.size();
    }
}
