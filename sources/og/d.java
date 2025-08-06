package og;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huobi.account.entity.ChooseCityEntity;
import com.huobi.view.indexlist.IndexPartAdapter;
import pro.huobi.R;

public class d extends IndexPartAdapter<ChooseCityEntity> {

    /* renamed from: a  reason: collision with root package name */
    public LayoutInflater f47667a;

    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f47668a;

        public a(View view) {
            super(view);
            this.f47668a = (TextView) view.findViewById(R.id.tv_name);
        }
    }

    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f47669a;

        public b(View view) {
            super(view);
            this.f47669a = (TextView) view.findViewById(R.id.tv_index);
        }
    }

    public d(Context context) {
        this.f47667a = LayoutInflater.from(context);
    }

    /* renamed from: a */
    public void onBindContentViewHolder(RecyclerView.ViewHolder viewHolder, ChooseCityEntity chooseCityEntity) {
        a aVar = (a) viewHolder;
        aVar.f47668a.setText(chooseCityEntity == null ? "" : chooseCityEntity.getName());
        aVar.itemView.setSelected(chooseCityEntity != null && chooseCityEntity.isSelected());
    }

    public void onBindTitleViewHolder(RecyclerView.ViewHolder viewHolder, String str) {
        ((b) viewHolder).f47669a.setText(str);
    }

    public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup viewGroup) {
        return new a(this.f47667a.inflate(R.layout.item_city_choose, viewGroup, false));
    }

    public RecyclerView.ViewHolder onCreateTitleViewHolder(ViewGroup viewGroup) {
        return new b(this.f47667a.inflate(R.layout.item_index_city_choose, viewGroup, false));
    }
}
