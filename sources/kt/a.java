package kt;

import android.content.Context;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.edgeengine.template.widget.Widget;
import java.util.List;
import pro.huobi.R;
import rj.b;

public class a extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    public List<CouponReturn> f84437a;

    /* renamed from: b  reason: collision with root package name */
    public b f84438b;

    public a(b bVar) {
        this.f84438b = bVar;
    }

    public final String a(Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, "color", context.getPackageName());
        return "#" + Integer.toHexString(ContextCompat.getColor(context, identifier));
    }

    public int getItemCount() {
        List<CouponReturn> list = this.f84437a;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.f84437a.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        b bVar;
        String str;
        List<CouponReturn> list = this.f84437a;
        if (list != null && i11 < list.size() && (viewHolder instanceof b) && (bVar = this.f84438b) != null && bVar.d() != null) {
            Context d11 = this.f84438b.d();
            CouponReturn couponReturn = this.f84437a.get(i11);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("couponId", (Object) Long.valueOf(couponReturn.getId()));
            boolean isSelected = couponReturn.isSelected();
            jSONObject.put("isSelected", (Object) Boolean.valueOf(isSelected));
            jSONObject.put("borderColor", (Object) a(d11, isSelected ? "kColorMajorTheme100" : "KBaseColorPrimarySeparator"));
            jSONObject.put("validAtTitle", (Object) String.format(d11.getResources().getString(R.string.n_coupon_time_dealine), new Object[]{DateTimeUtils.h(couponReturn.getValidAt(), "yyyy.MM.dd")}));
            jSONObject.put("amount", (Object) couponReturn.getAmount());
            jSONObject.put("maxLines", (Object) couponReturn.expanded ? "0" : "1");
            jSONObject.put("isExpand", (Object) Boolean.valueOf(couponReturn.expanded));
            jSONObject.put("arrowImageName", (Object) couponReturn.expanded ? "trade_margin_coupon_arrow_up" : "trade_margin_coupon_arrow_down");
            try {
                if (Integer.parseInt(couponReturn.getMeetCondition()) > 0) {
                    str = String.format(d11.getResources().getString(R.string.n_coupon_return_meet_condition), new Object[]{couponReturn.getMeetCondition(), couponReturn.getAmount()});
                } else {
                    str = d11.getString(R.string.n_exchange_coupon_nothreshold);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                str = d11.getString(R.string.n_exchange_coupon_nothreshold);
            }
            jSONObject.put("meetConditionTitle", (Object) str);
            jSONObject.put("selectedImage", (Object) isSelected ? "trade_margin_coupon_select" : "trade_margin_coupon_unselect");
            jSONObject.put("rules", (Object) couponReturn.getRules());
            ((b) viewHolder).f84439a.I(jSONObject);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        b bVar;
        Context context = viewGroup.getContext();
        if (context == null || (bVar = this.f84438b) == null) {
            return null;
        }
        Widget F = bVar.F("trade_margin_coupon_item.xml", context, true, (JSONObject) null);
        return new b(F.P(context), F.s());
    }

    public void setData(List<CouponReturn> list) {
        this.f84437a = list;
    }
}
