package com.huobi.otc.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.network.otc.core.bean.QuickTradeConfigBean;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.enums.OtcCurrencySelectType;
import com.huobi.otc.enums.TradeBusinessEnum;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dp.l;
import dp.m;
import i6.i;
import ip.b;
import java.util.ArrayList;
import java.util.List;
import jp.c1;

public class OtcCryptoSelectDialogFragment extends BaseFullBottomSheetFragment implements b.a {

    /* renamed from: b  reason: collision with root package name */
    public EditText f78298b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f78299c;

    /* renamed from: d  reason: collision with root package name */
    public EasyRecyclerView<ip.b> f78300d;

    /* renamed from: e  reason: collision with root package name */
    public EasyRecyclerView<ip.b> f78301e;

    /* renamed from: f  reason: collision with root package name */
    public List<ip.b> f78302f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public b f78303g;

    /* renamed from: h  reason: collision with root package name */
    public LoadingLayout f78304h;

    /* renamed from: i  reason: collision with root package name */
    public String f78305i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f78306j;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                OtcCryptoSelectDialogFragment.this.f78304h.g();
                OtcCryptoSelectDialogFragment.this.f78300d.setVisibility(0);
                OtcCryptoSelectDialogFragment.this.f78301e.setVisibility(8);
                OtcCryptoSelectDialogFragment.this.f78298b.setTextSize(1, 12.0f);
                return;
            }
            OtcCryptoSelectDialogFragment.this.f78298b.setTextSize(1, 14.0f);
            OtcCryptoSelectDialogFragment.this.xh(editable.toString());
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public interface b {
        void a(QuickTradeConfigBean.Asset asset);

        TradeBusinessEnum b();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        if (this.mBehavior != null) {
            dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zh() {
        EasyRecyclerView<ip.b> easyRecyclerView = this.f78300d;
        if (easyRecyclerView != null) {
            easyRecyclerView.scrollToPosition(0);
        }
    }

    public void Ah() {
        List<QuickTradeConfigBean.Asset> virtualAsset = c1.h().f(this.f78303g.b()).getVirtualAsset();
        if (!CollectionsUtils.b(virtualAsset)) {
            yh(virtualAsset);
            this.f78300d.setData(this.f78302f);
            i.b().g(new m(this), 30);
        }
    }

    public void Ra(QuickTradeConfigBean.Asset asset) {
        if (asset != null) {
            dismiss();
            b bVar = this.f78303g;
            if (bVar != null) {
                bVar.a(asset);
            }
        }
    }

    public int getPeekHeight() {
        return PixelUtils.f() - PixelUtils.a(50.0f);
    }

    public final void initView(View view) {
        LoadingLayout loadingLayout = (LoadingLayout) view.findViewById(R$id.id_trade_order_loading_layout);
        this.f78304h = loadingLayout;
        loadingLayout.g();
        this.f78298b = (EditText) view.findViewById(R$id.search_currency_input);
        this.f78299c = (TextView) view.findViewById(R$id.search_currency_cancel);
        this.f78300d = (EasyRecyclerView) view.findViewById(R$id.id_otc_trade_currency_rv);
        this.f78301e = (EasyRecyclerView) view.findViewById(R$id.id_otc_trade_currency_search_result_rv);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f78305i = arguments.getString("key_crypto", (String) null);
            this.f78306j = arguments.getBoolean("key_is_buy", false);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R$layout.fragment_crypto_select_layout, viewGroup, false);
        initView(inflate);
        wh();
        Ah();
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.f78298b.setText("");
    }

    public final void wh() {
        this.f78299c.setOnClickListener(new l(this));
        this.f78298b.addTextChangedListener(new a());
    }

    public final void xh(String str) {
        ArrayList arrayList = new ArrayList();
        for (ip.b next : this.f78302f) {
            if (!(next == null || next.d() == null)) {
                String name = next.d().getName();
                if (!TextUtils.isEmpty(name) && name.toUpperCase().contains(str.toUpperCase()) && next.i() != OtcCurrencySelectType.COMMONLY) {
                    ip.b bVar = new ip.b(OtcCurrencySelectType.SEARCH, next.d(), next.g(), this, true);
                    bVar.n(TextUtils.equals(name.toUpperCase(), this.f78305i));
                    arrayList.add(bVar);
                }
            }
        }
        this.f78300d.setVisibility(8);
        if (!arrayList.isEmpty()) {
            this.f78304h.g();
            this.f78301e.setVisibility(0);
            this.f78301e.setData(arrayList);
            return;
        }
        this.f78304h.i();
    }

    public final void yh(List<QuickTradeConfigBean.Asset> list) {
        OtcCurrencySelectType otcCurrencySelectType;
        this.f78302f.clear();
        String str = "";
        for (QuickTradeConfigBean.Asset next : list) {
            if (next != null) {
                String name = next.getName();
                if (!TextUtils.isEmpty(name)) {
                    String substring = name.substring(0, 1);
                    if (TextUtils.equals(str, substring)) {
                        otcCurrencySelectType = OtcCurrencySelectType.SEARCH;
                    } else {
                        otcCurrencySelectType = OtcCurrencySelectType.ALL;
                    }
                    ip.b bVar = new ip.b(otcCurrencySelectType, next, substring, this, true);
                    bVar.n(TextUtils.equals(name.toUpperCase(), this.f78305i));
                    this.f78302f.add(bVar);
                    str = substring;
                }
            }
        }
    }
}
