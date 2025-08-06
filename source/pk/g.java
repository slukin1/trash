package pk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.contract.entity.ContractPositionLimit;
import java.util.List;
import pro.huobi.R;

public class g extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f47725a;

    /* renamed from: b  reason: collision with root package name */
    public List<ContractPositionLimit.ContractItemLimit> f47726b;

    public class a extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f47727a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f47728b;

        /* renamed from: c  reason: collision with root package name */
        public View f47729c;

        public a(View view) {
            super(view);
            this.f47727a = (LinearLayout) view.findViewById(R.id.ll_parent);
            this.f47728b = (TextView) view.findViewById(R.id.tv_symbol);
            this.f47729c = view.findViewById(R.id.divide_line);
        }
    }

    public g(Context context, List<ContractPositionLimit.ContractItemLimit> list) {
        this.f47725a = context;
        this.f47726b = list;
    }

    public int getItemCount() {
        List<ContractPositionLimit.ContractItemLimit> list = this.f47726b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        ContractPositionLimit.ContractItemLimit contractItemLimit = this.f47726b.get(i11);
        a aVar = (a) viewHolder;
        aVar.f47728b.setText(contractItemLimit.product_id);
        aVar.f47729c.setVisibility(i11 != this.f47726b.size() - 1 ? 0 : 4);
        LinearLayout c11 = aVar.f47727a;
        c11.removeAllViews();
        for (int i12 = 0; i12 < contractItemLimit.data.size(); i12++) {
            ContractPositionLimit.ContractLeverageItem contractLeverageItem = contractItemLimit.data.get(i12);
            View inflate = LayoutInflater.from(this.f47725a).inflate(R.layout.item_contract_up_position_item, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tv_leverage_range)).setText(contractLeverageItem.leverage_range);
            ((TextView) inflate.findViewById(R.id.tv_adjustment_multiple)).setText(contractLeverageItem.adjustment_multiple);
            c11.addView(inflate, new LinearLayout.LayoutParams(-1, PixelUtils.a(40.0f)));
            if (contractItemLimit.data.size() > 1 && i12 < contractItemLimit.data.size() - 1) {
                View view = new View(this.f47725a);
                view.setBackgroundColor(this.f47725a.getResources().getColor(R.color.baseColorPrimarySeparator));
                c11.addView(view, new LinearLayout.LayoutParams(-1, PixelUtils.a(0.5f)));
            }
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new a(LayoutInflater.from(this.f47725a).inflate(R.layout.item_contract_up_position_parent, viewGroup, false));
    }
}
