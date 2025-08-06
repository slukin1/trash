package com.huobi.view;

import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$dimen;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.hbg.module.otc.R$style;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.List;

public final class OtcDialogUtils {
    private OtcDialogUtils() {
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$showAbandonOrderDialog$0(Dialog dialog, View view) {
        dialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$showAbandonOrderDialog$1(DialogUtils.b.f fVar, Dialog dialog, View view) {
        fVar.a((HBDialogFragment) null);
        dialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$showAbandonOrderDialog$2(DialogUtils.b.f fVar, Dialog dialog, View view) {
        fVar.a((HBDialogFragment) null);
        dialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$showOtcAreaOrder$5(DialogUtils.b.f fVar, View view) {
        if (fVar != null) {
            fVar.a((HBDialogFragment) null);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$showOtcAreaOrder$6(Dialog dialog, View view) {
        dialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$showOtcOrderWithdrawDialog$3(Dialog dialog, View view) {
        dialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$showOtcOrderWithdrawDialog$4(Dialog dialog, DialogUtils.b.f fVar, View view) {
        dialog.dismiss();
        fVar.a((HBDialogFragment) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static void showAbandonOrderDialog(Context context, String str, String str2, DialogUtils.b.f fVar, DialogUtils.b.f fVar2) {
        AlertDialog.a aVar = new AlertDialog.a(context, R$style.CommonDialogStyle);
        View inflate = LayoutInflater.from(context).inflate(R$layout.dialog_layout_otc_muti_text, (ViewGroup) null);
        aVar.setView(inflate);
        TextView textView = (TextView) inflate.findViewById(R$id.dialog_message_tv);
        TextView textView2 = (TextView) inflate.findViewById(R$id.dialog_message_sub_tv);
        textView2.setTextColor(ContextCompat.getColor(context, R$color.baseColorMajorTheme100));
        textView2.setTextSize(0, (float) context.getResources().getDimensionPixelSize(R$dimen.global_text_size_16));
        ((TextView) inflate.findViewById(R$id.dialog_title_tv)).setText(context.getString(R$string.otc_lite_order_detail_btn_abandon_buy));
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(str2);
        }
        Button button = (Button) inflate.findViewById(R$id.dialog_cancel_btn);
        Button button2 = (Button) inflate.findViewById(R$id.dialog_confirm_btn);
        AlertDialog create = aVar.create();
        button.setText(context.getString(R$string.otc_dialog_cancel));
        button.setOnClickListener(new a1(create));
        button2.setText(context.getString(R$string.otc_order_dialog_cancle_btnok_text));
        button2.setOnClickListener(new g1(fVar, create));
        create.setCancelable(false);
        textView2.setOnClickListener(new f1(fVar2, create));
        create.show();
    }

    public static void showOtcAreaOrder(Context context, List<Pair<Boolean, String>> list, DialogUtils.b.f fVar) {
        int i11;
        if (context != null) {
            AlertDialog.a aVar = new AlertDialog.a(context, R$style.CommonDialogStyle);
            View inflate = LayoutInflater.from(context).inflate(R$layout.dialog_layout_otc_order_area_switch_dialog, (ViewGroup) null);
            aVar.setView(inflate);
            Button button = (Button) inflate.findViewById(R$id.dialog_confirm_btn);
            TextView textView = (TextView) inflate.findViewById(R$id.dialog_cancel_btn);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.content_root_ll);
            ((TextView) inflate.findViewById(R$id.dialog_title_tv)).setText(context.getString(R$string.n_otc_switch_alert_no_authority_normal_title));
            button.setBackgroundResource(R$drawable.common_blue_5_radius_selector);
            ((TextView) inflate.findViewById(R$id.sub_content_tv)).setText(context.getString(R$string.n_otc_switch_alert_no_authority_sub_content_one) + "\n" + context.getString(R$string.n_otc_switch_alert_no_authority_sub_content_two));
            textView.setText(context.getString(R$string.n_otc_switch_alert_no_authority_to_safe_button));
            if (!CollectionsUtils.b(list)) {
                linearLayout.setVisibility(0);
                for (int i12 = 0; i12 < list.size(); i12++) {
                    Pair pair = list.get(i12);
                    View inflate2 = LayoutInflater.from(context).inflate(R$layout.dialog_layout_otc_order_content, (ViewGroup) null);
                    ImageView imageView = (ImageView) inflate2.findViewById(R$id.is_pass_iv);
                    TextView textView2 = (TextView) inflate2.findViewById(R$id.content_tv);
                    Object obj = pair.first;
                    if (obj != null) {
                        if (((Boolean) obj).booleanValue()) {
                            i11 = R$drawable.new_area_order_true;
                        } else {
                            i11 = R$drawable.new_area_order_false;
                        }
                        imageView.setImageResource(i11);
                    }
                    textView2.setText((CharSequence) pair.second);
                    linearLayout.addView(inflate2);
                }
            } else {
                linearLayout.setVisibility(8);
            }
            AlertDialog create = aVar.create();
            textView.setOnClickListener(new e1(fVar));
            button.setOnClickListener(new b1(create));
            create.setCanceledOnTouchOutside(false);
            create.show();
        }
    }

    public static void showOtcOrderWithdrawDialog(Context context, String str, String str2, String str3, String str4, DialogUtils.b.f fVar) {
        AlertDialog.a aVar = new AlertDialog.a(context, R$style.CommonDialogStyle);
        View inflate = LayoutInflater.from(context).inflate(R$layout.dialog_layout_otc_order_withdraw, (ViewGroup) null);
        aVar.setView(inflate);
        TextView textView = (TextView) inflate.findViewById(R$id.dialog_title_tv);
        TextView textView2 = (TextView) inflate.findViewById(R$id.dialog_message_tv);
        Button button = (Button) inflate.findViewById(R$id.dialog_cancel_btn);
        Button button2 = (Button) inflate.findViewById(R$id.dialog_confirm_btn);
        ViewUtil.m(button2, !TextUtils.isEmpty(str4));
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            textView2.setText(Html.fromHtml(str2));
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
        }
        if (!TextUtils.isEmpty(str3)) {
            button.setText(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            button2.setText(str4);
        }
        AlertDialog create = aVar.create();
        button.setOnClickListener(new c1(create));
        button2.setOnClickListener(new d1(create, fVar));
        create.setCanceledOnTouchOutside(false);
        create.show();
    }
}
