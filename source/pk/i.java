package pk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.LoadingLayout;
import com.huobi.contract.entity.ContractPositionLimit;
import java.util.List;
import pro.huobi.R;

public class i extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    public List<ContractPositionLimit.ContractItemLimit> f47731a;

    /* renamed from: b  reason: collision with root package name */
    public List<ContractPositionLimit.ContractItemLimit> f47732b;

    public class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LoadingLayout f47733a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView f47734b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f47735c;

        public a(View view) {
            super(view);
            initView();
        }

        public final void b(int i11) {
            String str;
            i iVar = i.this;
            List a11 = i11 == 0 ? iVar.f47731a : iVar.f47732b;
            RecyclerView recyclerView = this.f47734b;
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            this.f47734b.setHasFixedSize(true);
            this.f47734b.setAdapter(new g(this.f47734b.getContext(), a11));
            if (a11 == null || a11.size() == 0) {
                this.f47733a.i();
                TextView textView = this.f47735c;
                if (i11 == 0) {
                    str = this.f47734b.getContext().getResources().getString(R.string.n_contract_position_limit_adjustable_empty);
                } else {
                    str = this.f47734b.getContext().getResources().getString(R.string.n_contract_position_limit_adjusted_empty);
                }
                textView.setText(str);
                return;
            }
            this.f47733a.g();
        }

        public final void initView() {
            LoadingLayout loadingLayout = (LoadingLayout) this.itemView.findViewById(R.id.loading_layout);
            this.f47733a = loadingLayout;
            this.f47735c = (TextView) loadingLayout.findViewById(R.id.tv_empty);
            this.f47734b = (RecyclerView) this.itemView.findViewById(R.id.rv_up_position);
        }
    }

    public i(Context context) {
    }

    /* renamed from: d */
    public void onBindViewHolder(a aVar, int i11) {
        aVar.b(i11);
    }

    /* renamed from: e */
    public a onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_contract_up_position, viewGroup, false));
    }

    public void f(List<ContractPositionLimit.ContractItemLimit> list, List<ContractPositionLimit.ContractItemLimit> list2) {
        this.f47731a = list;
        this.f47732b = list2;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return 2;
    }
}
