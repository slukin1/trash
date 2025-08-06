package com.hbg.module.kline.handler;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.module.kline.R$attr;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.R$string;
import com.hbg.module.kline.bean.EtpChangeConditionListItem;
import i6.r;
import java.util.Locale;
import s9.c;

public class EtpChangeConditionListItemHandler implements c {
    public int b(Context context, int i11) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.data;
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, EtpChangeConditionListItem etpChangeConditionListItem, ViewGroup viewGroup) {
        v9.c cVar2 = cVar;
        EtpChangeConditionListItem etpChangeConditionListItem2 = etpChangeConditionListItem;
        Resources resources = cVar2.itemView.getResources();
        Context context = cVar2.itemView.getContext();
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R$id.id_market_info_etp_condition_title1);
        TextView textView2 = (TextView) e11.b(R$id.id_market_info_etp_condition_title2);
        TextView textView3 = (TextView) e11.b(R$id.id_market_info_etp_condition_desc);
        String str = "--";
        if (TextUtils.isEmpty(etpChangeConditionListItem.d())) {
            etpChangeConditionListItem2.g(str);
        }
        if (TextUtils.isEmpty(etpChangeConditionListItem.e())) {
            etpChangeConditionListItem2.h(str);
        }
        String a11 = etpChangeConditionListItem.c().a();
        if (!TextUtils.isEmpty(a11)) {
            str = a11;
        }
        Locale locale = Locale.US;
        String format = String.format(locale, resources.getString(R$string.n_kline_etp_adjust_condition1), new Object[]{etpChangeConditionListItem.d()});
        SpannableString spannableString = new SpannableString(format);
        int indexOf = format.indexOf(etpChangeConditionListItem.d());
        int i12 = R$attr.kline_index_setting_text_color;
        spannableString.setSpan(new ForegroundColorSpan(b(context, i12)), indexOf, etpChangeConditionListItem.d().length() + indexOf, 17);
        textView.setText(spannableString);
        String format2 = String.format(locale, resources.getString(R$string.n_kline_etp_adjust_condition2), new Object[]{etpChangeConditionListItem.e()});
        SpannableString spannableString2 = new SpannableString(format2);
        int indexOf2 = format2.indexOf(etpChangeConditionListItem.e());
        spannableString2.setSpan(new ForegroundColorSpan(b(context, i12)), indexOf2, etpChangeConditionListItem.e().length() + indexOf2, 17);
        textView2.setText(spannableString2);
        textView3.setText(String.format(locale, resources.getString(R$string.n_kline_etp_current_netvalue), new Object[]{str}));
    }

    public int getResId() {
        return R$layout.layout_market_info_etp_change_condition_list_item;
    }
}
