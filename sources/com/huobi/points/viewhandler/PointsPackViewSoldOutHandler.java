package com.huobi.points.viewhandler;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.points.entity.PointsPack;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.Locale;
import pro.huobi.R;
import s9.c;

public class PointsPackViewSoldOutHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, PointsPack pointsPack, ViewGroup viewGroup) {
        r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        ((TextView) e11.b(R.id.item_points_pack_title_tv)).setText(pointsPack.getName());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(context.getString(R.string.points_pack_contains));
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableStringBuilder.length(), 33);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(String.valueOf(pointsPack.getPoints()));
        spannableStringBuilder2.setSpan(new AbsoluteSizeSpan(20, true), 0, spannableStringBuilder2.length(), 33);
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(context.getString(R.string.points_pack_points));
        spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableStringBuilder3.length(), 33);
        ((TextView) e11.b(R.id.item_points_pack_points_tv)).setText(spannableStringBuilder.append(spannableStringBuilder2).append(spannableStringBuilder3));
        SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(context.getString(R.string.points_pack_only_sell));
        spannableStringBuilder4.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableStringBuilder4.length(), 33);
        SpannableStringBuilder spannableStringBuilder5 = new SpannableStringBuilder(m.m(pointsPack.getPrice(), PrecisionUtil.n()));
        spannableStringBuilder5.setSpan(new AbsoluteSizeSpan(20, true), 0, spannableStringBuilder5.length(), 33);
        SpannableStringBuilder spannableStringBuilder6 = new SpannableStringBuilder(context.getString(R.string.points_pack_usdt));
        spannableStringBuilder6.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableStringBuilder6.length(), 33);
        ((TextView) e11.b(R.id.item_points_pack_price_tv)).setText(spannableStringBuilder4.append(spannableStringBuilder5).append(spannableStringBuilder6));
        String plainString = m.a(String.valueOf(pointsPack.getLimit())).multiply(m.a(String.valueOf(pointsPack.getPoints()))).toPlainString();
        ((TextView) e11.b(R.id.item_points_pack_limit_hint_tv)).setText(String.format(context.getString(R.string.points_pack_limit_points), new Object[]{plainString}));
        ((TextView) e11.b(R.id.item_points_pack_price_hint_tv)).setText(String.format(context.getString(R.string.points_pack_deductible_fee), new Object[]{String.valueOf(pointsPack.getPoints())}));
        TextView textView = (TextView) e11.b(R.id.item_points_pack_gift_tv);
        textView.setText(String.format(context.getString(R.string.points_pack_gift), new Object[]{m.m(pointsPack.getGiftAmount(), PrecisionUtil.a(TradeType.PRO, pointsPack.getGiftCurrency())), pointsPack.getGiftCurrency().toUpperCase(Locale.US)}));
        if (TextUtils.isEmpty(pointsPack.getGiftAmount()) || new BigDecimal(pointsPack.getGiftAmount()).compareTo(BigDecimal.ZERO) == 0) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    public int getResId() {
        return R.layout.item_points_pack_sold_out;
    }
}
