package com.huobi.order.ui;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import bh.j;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.widgets.BaseOrderFilterDialogFragment;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.order.bean.OrderFilterQuoteItem;
import com.huobi.view.rv.GridDividerItemDecoration;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import d7.k;
import i6.m;
import i6.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import pro.huobi.R;

public class CurrentOrderFilterDialogFragment extends BaseOrderFilterDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public EditText f78142b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f78143c;

    /* renamed from: d  reason: collision with root package name */
    public EasyRecyclerView<OrderFilterQuoteItem> f78144d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f78145e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f78146f;

    /* renamed from: g  reason: collision with root package name */
    public b f78147g;

    /* renamed from: h  reason: collision with root package name */
    public List<OrderFilterQuoteItem> f78148h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f78149i = new e(this);

    /* renamed from: j  reason: collision with root package name */
    public String f78150j;

    /* renamed from: k  reason: collision with root package name */
    public String f78151k;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            SoftInputUtils.m(CurrentOrderFilterDialogFragment.this.getActivity(), CurrentOrderFilterDialogFragment.this.f78142b);
        }
    }

    public interface b {
        void W8(String str, boolean z11, String str2, String str3, String str4);

        void q6();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Bh(View view, boolean z11) {
        if (z11) {
            Fh();
        }
    }

    public static /* synthetic */ int Ch(String str, String str2) {
        return m.a(k.C().H(str2)).intValue() - m.a(k.C().H(str)).intValue();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Dh(View view) {
        int intValue = ((Integer) view.getTag(R.id.item_data1)).intValue();
        int size = this.f78148h.size();
        if (this.f78148h.get(intValue).d()) {
            for (int i11 = 0; i11 < size; i11++) {
                this.f78148h.get(i11).h(false);
            }
            this.f78144d.c();
            Gh("");
        } else {
            int i12 = 0;
            while (i12 < size) {
                this.f78148h.get(i12).h(i12 == intValue);
                i12++;
            }
            this.f78144d.c();
            Gh(this.f78148h.get(intValue).c());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        this.f78142b.clearFocus();
        SoftInputUtils.g(getActivity(), this.f78143c);
        if (this.f78144d.getVisibility() == 0) {
            Fh();
        } else {
            this.f78144d.setVisibility(0);
            this.f78143c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(getActivity(), R.drawable.trade_arrow_up), (Drawable) null);
            this.f78143c.setBackgroundResource(R.drawable.shape_common_focus_radius_4);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        String str;
        if (this.f78147g != null) {
            this.f78150j = this.f78142b.getText().toString().trim();
            this.f78151k = this.f78143c.getText().toString();
            if (TextUtils.isEmpty(this.f78150j)) {
                if (TextUtils.isEmpty(this.f78151k)) {
                    this.f78147g.W8("", true, "", this.f78150j, this.f78151k);
                    this.f78151k = null;
                } else {
                    HuobiToastUtil.m(j.c().getResources().getString(R.string.order_input_symbol));
                }
            } else if (TextUtils.isEmpty(this.f78151k)) {
                String lowerCase = a1.v().s(this.f78150j).toLowerCase(Locale.US);
                String D = a1.v().D(lowerCase);
                this.f78151k = D;
                this.f78147g.W8(lowerCase, false, "", this.f78150j, D);
            } else {
                CurrencyBean v11 = k.C().v(this.f78150j);
                CurrencyBean v12 = k.C().v(this.f78151k);
                if (v11 == null || v12 == null) {
                    str = "";
                } else {
                    str = v11.getName() + v12.getName();
                }
                this.f78147g.W8(str.toLowerCase(Locale.US), false, "", this.f78150j, this.f78151k);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$5(View view) {
        reset();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Eh(b bVar) {
        this.f78147g = bVar;
    }

    public void Fh() {
        this.f78144d.setVisibility(8);
        this.f78143c.setBackgroundResource(R.drawable.shape_common_normal_radius_4);
        this.f78143c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(getActivity(), R.drawable.trade_arrow_down), (Drawable) null);
    }

    public void Gh(String str) {
        this.f78143c.setText(str);
    }

    public void addEvent(r rVar) {
        super.addEvent(rVar);
        rVar.b(R.id.id_current_order_filter_parent_layout).setOnClickListener(new h(this));
        this.f78143c.setOnClickListener(new g(this));
        this.f78142b.setOnFocusChangeListener(new i(this));
        this.f78146f.setOnClickListener(new d(this));
        this.f78145e.setOnClickListener(new f(this));
    }

    public void afterInit() {
        List<String> j11 = a1.v().j();
        Collections.sort(j11, j.f78231b);
        ArrayList arrayList = new ArrayList();
        for (String next : j11) {
            OrderFilterQuoteItem orderFilterQuoteItem = new OrderFilterQuoteItem();
            orderFilterQuoteItem.h(false);
            orderFilterQuoteItem.e(this.f78149i);
            orderFilterQuoteItem.f(next);
            orderFilterQuoteItem.g(k.C().z(next));
            arrayList.add(orderFilterQuoteItem);
        }
        this.f78148h.clear();
        this.f78148h.addAll(arrayList);
        this.f78144d.setData(this.f78148h);
    }

    public void configCoverViewLayoutParams(View view, FrameLayout.LayoutParams layoutParams) {
    }

    public View getBackBtn() {
        return null;
    }

    public int getContentViewResId() {
        return R.layout.dialog_current_order_filter;
    }

    public View getFilterLayout() {
        return this.viewFinder.b(R.id.id_current_order_filter_layout);
    }

    public int getTranslateY() {
        return getFilterLayout().getHeight() == 0 ? getResources().getDimensionPixelOffset(R.dimen.dimen_143) : getFilterLayout().getHeight();
    }

    public void initView(r rVar) {
        EditText editText = (EditText) rVar.b(R.id.base_currency_et);
        this.f78142b = editText;
        editText.requestFocus();
        this.f78143c = (EditText) rVar.b(R.id.quote_currency_et);
        EasyRecyclerView<OrderFilterQuoteItem> easyRecyclerView = (EasyRecyclerView) rVar.b(R.id.quote_currency_rv);
        this.f78144d = easyRecyclerView;
        easyRecyclerView.addItemDecoration(new GridDividerItemDecoration(ContextCompat.getDrawable(getActivity(), R.color.global_item_bg), PixelUtils.a(10.0f)));
        this.f78144d.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        this.f78145e = (TextView) rVar.b(R.id.order_filter_reset_tv);
        this.f78146f = (TextView) rVar.b(R.id.order_filter_sure_tv);
    }

    public boolean isTransparent() {
        return true;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        b bVar = this.f78147g;
        if (bVar != null) {
            bVar.q6();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f78150j == null) {
            this.f78150j = "";
        }
        this.f78142b.setText(StringUtils.i(this.f78150j));
        if (this.f78151k == null) {
            this.f78151k = "";
        }
        this.f78143c.setText(StringUtils.i(this.f78151k));
        if (this.f78142b.hasFocus()) {
            this.f78142b.postDelayed(new a(), 100);
        }
    }

    public void reset() {
        int size = this.f78148h.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f78148h.get(i11).h(false);
        }
        EasyRecyclerView<OrderFilterQuoteItem> easyRecyclerView = this.f78144d;
        if (easyRecyclerView != null) {
            easyRecyclerView.c();
        }
        EditText editText = this.f78142b;
        if (editText != null) {
            editText.setText("");
        }
        EditText editText2 = this.f78143c;
        if (editText2 != null) {
            editText2.setText("");
        }
    }

    public boolean useWindowBg() {
        return true;
    }
}
