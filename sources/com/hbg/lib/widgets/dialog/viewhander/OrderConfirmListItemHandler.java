package com.hbg.lib.widgets.dialog.viewhander;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.dialog.bean.OrderConfirmBean;
import da.f;
import i6.r;
import s9.c;

public class OrderConfirmListItemHandler implements c {
    public static /* synthetic */ void f(TextView textView, SpannableString spannableString, SpannableString spannableString2) {
        if (textView.getLineCount() > 1) {
            textView.setText(spannableString);
            textView.append("\n");
            textView.append(spannableString2);
        }
    }

    public final SpannableString c(Context context, String str, int i11) {
        if (str == null) {
            str = "";
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(i11)), 0, spannableString.length(), 33);
        return spannableString;
    }

    public final SpannableString d(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
        return spannableString;
    }

    /* renamed from: e */
    public void handleView(v9.c cVar, int i11, OrderConfirmBean.ListItem listItem, ViewGroup viewGroup) {
        if (cVar != null && listItem != null) {
            r e11 = cVar.e();
            TextView e12 = e11.e(R$id.tv_key);
            TextView e13 = e11.e(R$id.tv_value);
            e12.setText(listItem.getKey());
            SpannableString d11 = d(listItem.getValue());
            e13.setText(d11);
            if (!TextUtils.isEmpty(listItem.getValueExtra())) {
                SpannableString c11 = c(cVar.itemView.getContext(), listItem.getValueExtra(), listItem.getValueExtraColorRes());
                e13.append(c11);
                e13.post(new f(e13, d11, c11));
            }
        }
    }

    public int getResId() {
        return R$layout.item_order_confirm_dialog_list;
    }
}
