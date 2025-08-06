package com.huobi.index.ui.widget;

import am.d;
import am.e;
import am.f;
import am.g;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.finance.ui.UnifyDepositActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import jp.k0;
import pro.huobi.R;
import yl.o;

@Route(path = "/home/TransferAmount")
public class HomeTransferAmountFragment extends BaseDialogFragment {
    @Autowired(name = "title")

    /* renamed from: b  reason: collision with root package name */
    public String f74000b;
    @Autowired(name = "isTransfer")

    /* renamed from: c  reason: collision with root package name */
    public int f74001c;
    @Autowired(name = "desc")

    /* renamed from: d  reason: collision with root package name */
    public String f74002d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f74003e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f74004f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f74005g;

    /* renamed from: h  reason: collision with root package name */
    public ConstraintLayout f74006h;

    /* renamed from: i  reason: collision with root package name */
    public ConstraintLayout f74007i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f74008j;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void wh(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void xh(View view) {
        if (getActivity() != null) {
            k0.k(getActivity());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void yh(View view) {
        if (getActivity() != null) {
            UnifyDepositActivity.wh(getActivity(), "USDT");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void zh(View view) {
        if (getActivity() != null) {
            k0.k(getActivity());
        }
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Ah() {
        if (getDialog() != null) {
            Window window = getDialog().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.0f;
            window.setAttributes(attributes);
        }
    }

    public void addEvent(r rVar) {
    }

    public void afterInit() {
        this.f74003e.setOnClickListener(new e(this));
        this.f74006h.setOnClickListener(new d(this));
        this.f74007i.setOnClickListener(new f(this));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("title:");
        String str = this.f74000b;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        sb2.append(str);
        sb2.append(" desc:");
        String str3 = this.f74002d;
        if (str3 == null) {
            str3 = str2;
        }
        sb2.append(str3);
        Log.d("TransferAmountFragment", sb2.toString());
        if (getContext() == null || TextUtils.isEmpty(this.f74000b) || !this.f74000b.contains("{") || !this.f74000b.contains("}")) {
            this.f74004f.setText(TextUtils.isEmpty(this.f74000b) ? str2 : this.f74000b);
        } else {
            this.f74004f.setText(o.a(getContext(), this.f74000b, R.color.home_transfer_amount_page_title_color, R.color.home_transfer_amount_page_title_highlight_color, false));
        }
        TextView textView = this.f74005g;
        if (!TextUtils.isEmpty(this.f74002d)) {
            str2 = this.f74002d;
        }
        textView.setText(str2);
        this.f74008j.setOnClickListener(new g(this));
    }

    public boolean contentViewIsFullWidth() {
        return true;
    }

    public int getContentViewResId() {
        return R.layout.home_tranfer_amount_page;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f74003e = (ImageView) rVar.b(R.id.close_btn);
        this.f74004f = (TextView) rVar.b(R.id.title);
        this.f74005g = (TextView) rVar.b(R.id.sub_title);
        this.f74006h = (ConstraintLayout) rVar.b(R.id.card_top_layout);
        this.f74007i = (ConstraintLayout) rVar.b(R.id.card_bottom_layout);
        this.f74008j = (TextView) rVar.b(R.id.bottom_skip_btn);
    }

    public void initWindow(Window window) {
        super.initWindow(window);
    }

    public boolean isFullScreen() {
        return false;
    }

    public boolean isTransparent() {
        return false;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Log.d("TransferAmountFragment", "onActivityCreated");
        if (getDialog() != null) {
            getDialog().getWindow().setLayout(getDialog().getContext().getResources().getDisplayMetrics().widthPixels, -1);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("TransferAmountFragment", "onAttach");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f74001c = arguments.getInt("isTransfer");
            this.f74000b = arguments.getString("title");
            this.f74002d = arguments.getString("desc");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d("TransferAmountFragment", "onDestroy");
    }

    public void onResume() {
        super.onResume();
        Log.d("TransferAmountFragment", "onResume");
    }

    public void onStart() {
        super.onStart();
        Ah();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Log.d("TransferAmountFragment", "onViewCreated");
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
        Log.d("TransferAmountFragment", "show:" + str);
        SP.y("sp_key_index_transfer_amount_page_already_show", true);
    }

    public boolean useWindowBg() {
        return true;
    }
}
