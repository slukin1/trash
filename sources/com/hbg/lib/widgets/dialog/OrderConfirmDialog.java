package com.hbg.lib.widgets.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.R$style;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.bean.OrderConfirmBean;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import z9.o1;
import z9.p1;

public class OrderConfirmDialog {
    public static void c(View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View view, Dialog dialog) {
        view.findViewById(R$id.dialog_cancel_btn).setOnClickListener(new o1(dialog, onClickListener2));
        view.findViewById(R$id.dialog_confirm_btn).setOnClickListener(new p1(dialog, onClickListener));
    }

    public static Dialog d(Activity activity, OrderConfirmBean orderConfirmBean, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R$style.CommonDialogStyle);
        View inflate = LayoutInflater.from(activity).inflate(R$layout.dialog_order_confirm_two_btn, (ViewGroup) null);
        builder.setView(inflate);
        e(orderConfirmBean, inflate, activity);
        AlertDialog create = builder.create();
        create.setCancelable(false);
        create.setCanceledOnTouchOutside(false);
        c(onClickListener, onClickListener2, inflate, create);
        return create;
    }

    public static void e(OrderConfirmBean orderConfirmBean, View view, Context context) {
        TextView textView = (TextView) view.findViewById(R$id.dialog_title);
        Button button = (Button) view.findViewById(R$id.dialog_confirm_btn);
        TextView textView2 = (TextView) view.findViewById(R$id.dialog_top_hint_tv);
        String title = orderConfirmBean.getTitle();
        if (!TextUtils.isEmpty(title)) {
            textView.setText(title);
        }
        if (!TextUtils.isEmpty(orderConfirmBean.getTopHint())) {
            textView2.setText(orderConfirmBean.getTopHint());
            textView2.setVisibility(0);
        }
        if (!TextUtils.isEmpty(orderConfirmBean.getConfirmBtnText())) {
            button.setText(orderConfirmBean.getConfirmBtnText());
        }
        EasyRecyclerView easyRecyclerView = (EasyRecyclerView) view.findViewById(R$id.rcv_content);
        easyRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        if (orderConfirmBean.getList() == null || orderConfirmBean.getList().size() == 0) {
            easyRecyclerView.setVisibility(8);
        } else {
            easyRecyclerView.setVisibility(0);
            easyRecyclerView.setData(orderConfirmBean.getList());
        }
        TextView textView3 = (TextView) view.findViewById(R$id.tv_hint);
        if (TextUtils.isEmpty(orderConfirmBean.getHint())) {
            textView3.setVisibility(8);
            return;
        }
        textView3.setVisibility(0);
        textView3.setText(orderConfirmBean.getHint());
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void f(Dialog dialog, View.OnClickListener onClickListener, View view) {
        dialog.dismiss();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void g(Dialog dialog, View.OnClickListener onClickListener, View view) {
        dialog.dismiss();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
