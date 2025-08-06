package com.huobi.order.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.huobi.order.ui.TradeOrderHistoryDetailActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import pro.huobi.R;

public class FeeFragmentListDialog extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public FragmentManager f78153b = null;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<TradeOrderHistoryDetailActivity.FeedData> f78154c = null;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void qh(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static FeeFragmentListDialog rh(FragmentManager fragmentManager, ArrayList<TradeOrderHistoryDetailActivity.FeedData> arrayList) {
        Fragment fragment;
        if (!(fragmentManager == null || arrayList == null || arrayList.size() == 0)) {
            try {
                FragmentTransaction q11 = fragmentManager.q();
                try {
                    fragment = fragmentManager.m0("FeeFragmentListDialog");
                } catch (NullPointerException e11) {
                    e11.printStackTrace();
                    fragment = null;
                }
                if (fragment != null) {
                    q11.s(fragment);
                }
                FeeFragmentListDialog feeFragmentListDialog = new FeeFragmentListDialog();
                feeFragmentListDialog.f78153b = fragmentManager;
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", arrayList);
                feeFragmentListDialog.setArguments(bundle);
                q11.e(feeFragmentListDialog, "FeeFragmentListDialog");
                q11.k();
                return feeFragmentListDialog;
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
        return null;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        String str;
        LayoutInflater from = LayoutInflater.from(requireActivity());
        ViewGroup viewGroup = null;
        View inflate = from.inflate(R.layout.dialog_fee_fragment_list, (ViewGroup) null);
        Dialog dialog = new Dialog(requireActivity());
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);
        dialog.requestWindowFeature(1);
        dialog.setContentView(inflate);
        Window window = dialog.getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = -1;
        attributes.width = -1;
        window.setAttributes(attributes);
        window.setBackgroundDrawableResource(R.color.transparent);
        window.setWindowAnimations(R.style.bottom_dialog_animation);
        inflate.findViewById(R.id.ivClose).setOnClickListener(new k(this));
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.llDataContainer);
        ArrayList<TradeOrderHistoryDetailActivity.FeedData> arrayList = this.f78154c;
        if (arrayList != null) {
            Iterator<TradeOrderHistoryDetailActivity.FeedData> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                TradeOrderHistoryDetailActivity.FeedData next = it2.next();
                View inflate2 = from.inflate(R.layout.item_fee, viewGroup);
                TextView textView = (TextView) inflate2.findViewById(R.id.tvName);
                TextView textView2 = (TextView) inflate2.findViewById(R.id.tvValue);
                textView.setText(getString(R.string.n_deduction_of_handling_fees));
                String str2 = "TRX";
                if (next.f78216c.equalsIgnoreCase("ht")) {
                    textView.setText(getString(R.string.n_exchange_order_detail_ht_deduction));
                    str2 = "HT";
                } else if (next.f78216c.equalsIgnoreCase("trx")) {
                    textView.setText(getString(R.string.n_exchange_order_detail_deduction, str2));
                } else if (next.f78216c.equalsIgnoreCase("htx")) {
                    textView.setText(getString(R.string.n_exchange_order_detail_htx_deduction));
                    str2 = "HTX";
                } else if ("hbpoint".equals(next.f78216c) || "pts".equals(next.f78216c)) {
                    textView.setText(getString(R.string.n_exchange_order_detail_point_deduction));
                    str2 = "pts";
                } else {
                    str2 = next.f78215b.toUpperCase();
                    textView.setText(str2);
                }
                if ("hbpoint".equals(next.f78216c) || "pts".equals(next.f78216c)) {
                    textView2.setText(String.format("-%1$s %2$s", new Object[]{m.m(next.f78217d, PrecisionUtil.c(next.f78214a)), str2}));
                } else {
                    if (next.f78216c.equals("")) {
                        str = m.m(next.f78218e, PrecisionUtil.c(next.f78214a));
                    } else {
                        str = m.m(next.f78217d, PrecisionUtil.c(next.f78214a));
                    }
                    if (!TextUtils.isEmpty(str)) {
                        str = m.a(str).multiply(m.a("-1")).toPlainString();
                        if (m.a(str).compareTo(BigDecimal.ZERO) == 1) {
                            str = "+" + str;
                        }
                    }
                    String m11 = m.m(str, PrecisionUtil.c(next.f78214a));
                    if (m.a(m11).compareTo(BigDecimal.ZERO) == 1) {
                        m11 = "+" + m11;
                    }
                    textView2.setText(String.format(getContext().getString(R.string.detail_order_key_value), new Object[]{m11, str2}));
                }
                linearLayout.addView(inflate2);
                viewGroup = null;
            }
        }
        return dialog;
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
        this.f78154c = (ArrayList) bundle.getSerializable("data");
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }
}
