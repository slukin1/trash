package com.huobi.finance.address;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.network.pro.core.bean.DefiChainInfo;
import com.hbg.lib.widgets.ProgressConfirmButton;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$dimen;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.defibox.DefiChainListProvider;
import com.huobi.finance.bean.AddAddrListItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import uk.g;
import uk.h;
import uk.i;
import uk.j;

public class BindAddressView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public EasyRecyclerView<AddAddrListItem> f45223b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f45224c;

    /* renamed from: d  reason: collision with root package name */
    public View f45225d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f45226e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f45227f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f45228g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressConfirmButton f45229h;

    /* renamed from: i  reason: collision with root package name */
    public final List<AddAddrListItem> f45230i;

    /* renamed from: j  reason: collision with root package name */
    public final Set<String> f45231j;

    /* renamed from: k  reason: collision with root package name */
    public int f45232k;

    /* renamed from: l  reason: collision with root package name */
    public d f45233l;

    /* renamed from: m  reason: collision with root package name */
    public AddAddrListItem.a f45234m;

    public class a implements AddAddrListItem.a {
        public a() {
        }

        public boolean a(int i11, AddAddrListItem addAddrListItem) {
            return BindAddressView.this.f45231j.contains(addAddrListItem.d().getChain());
        }

        public void b(int i11, AddAddrListItem addAddrListItem) {
            String chain = addAddrListItem.d().getChain();
            if (!BindAddressView.this.f45231j.contains(chain)) {
                BindAddressView.this.f45231j.add(chain);
                BindAddressView.this.f45223b.c();
            } else if (BindAddressView.this.f45231j.size() > 1) {
                BindAddressView.this.f45231j.remove(chain);
                BindAddressView.this.f45223b.c();
            }
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        public void afterTextChanged(Editable editable) {
            boolean z11 = !TextUtils.isEmpty(BindAddressView.this.f45224c.getText().toString());
            ViewUtil.m(BindAddressView.this.f45225d, z11);
            BindAddressView.this.f45229h.setEnabled(z11);
            if (z11) {
                BindAddressView.this.f45229h.getmConfirmTv().setTextColor(BindAddressView.this.getResources().getColor(R$color.baseTextColor));
                BindAddressView.this.f45229h.setBackgroundResource(R$drawable.selector_common_btn_corner_bg);
                return;
            }
            BindAddressView.this.f45229h.getmConfirmTv().setTextColor(BindAddressView.this.getResources().getColor(R$color.baseColorSecondaryText));
            BindAddressView.this.f45229h.setBackgroundResource(R$drawable.shape_common_btn_bg_disable);
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class c extends RecyclerView.ItemDecoration {
        public c() {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            rect.set(0, recyclerView.getChildAdapterPosition(view) > 1 ? BindAddressView.this.f45232k : 0, 0, 0);
        }
    }

    public interface d {
        void a(List<String> list, String str);
    }

    public BindAddressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int getListHeight() {
        int size = (this.f45230i.size() / 2) + (this.f45230i.size() % 2);
        if (size == 0) {
            return 0;
        }
        return (getResources().getDimensionPixelOffset(R$dimen.dimen_36) * size) + (getResources().getDimensionPixelOffset(R$dimen.dimen_10) * (size - 1));
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void q(View view) {
        this.f45224c.clearFocus();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r(View view, boolean z11) {
        if (z11) {
            this.f45224c.setBackgroundResource(R$drawable.shape_grid_trade_input_bg_focus);
        } else {
            this.f45224c.setBackgroundResource(R$drawable.shape_grid_trade_input_bg);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void s(View view) {
        d dVar = this.f45233l;
        if (dVar != null) {
            dVar.a(new ArrayList(this.f45231j), this.f45224c.getText().toString());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void t(View view) {
        m();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public EditText getEditText() {
        return this.f45224c;
    }

    public int getRealHeight() {
        int height = this.f45226e.getHeight();
        Resources resources = getResources();
        int i11 = R$dimen.dimen_20;
        int dimensionPixelOffset = height + resources.getDimensionPixelOffset(i11) + this.f45227f.getHeight();
        Resources resources2 = getResources();
        int i12 = R$dimen.dimen_8;
        return dimensionPixelOffset + resources2.getDimensionPixelOffset(i12) + getResources().getDimensionPixelOffset(R$dimen.dimen_44) + getResources().getDimensionPixelOffset(i11) + this.f45228g.getHeight() + getResources().getDimensionPixelOffset(i12) + getListHeight() + getResources().getDimensionPixelOffset(i11) + getResources().getDimensionPixelOffset(R$dimen.dimen_40) + getResources().getDimensionPixelOffset(i11);
    }

    public final void k() {
        setOnClickListener(new g(this));
        this.f45224c.setOnFocusChangeListener(new j(this));
        this.f45224c.addTextChangedListener(new b());
        this.f45229h.setOnClickListener(new i(this));
        this.f45225d.setOnClickListener(new h(this));
    }

    public final void l() {
        this.f45229h.setEnabled(false);
    }

    public void m() {
        this.f45224c.setText("");
    }

    public void n() {
        this.f45229h.c();
    }

    public final void o() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setOrientation(1);
        this.f45223b.setLayoutManager(gridLayoutManager);
        this.f45232k = getResources().getDimensionPixelOffset(R$dimen.dimen_10);
        this.f45223b.addItemDecoration(new c());
    }

    public final void p() {
        this.f45223b = (EasyRecyclerView) findViewById(R$id.id_on_chain_add_addr_recyclerView);
        this.f45224c = (EditText) findViewById(R$id.id_on_chain_add_addr_et);
        this.f45225d = findViewById(R$id.id_on_chain_add_addr_delete_input);
        this.f45226e = (TextView) findViewById(R$id.id_on_chain_add_addr_tips_tv);
        this.f45227f = (TextView) findViewById(R$id.id_on_chain_add_addr_input_title_tv);
        this.f45228g = (TextView) findViewById(R$id.id_on_chain_add_addr_list_title_tv);
        this.f45229h = (ProgressConfirmButton) findViewById(R$id.id_on_chain_add_addr_btn);
        o();
    }

    public void setCallback(d dVar) {
        this.f45233l = dVar;
    }

    public void u() {
        this.f45231j.clear();
        this.f45230i.clear();
        List<DefiChainInfo> b11 = DefiChainListProvider.b();
        for (int i11 = 0; i11 < b11.size(); i11++) {
            DefiChainInfo defiChainInfo = b11.get(i11);
            AddAddrListItem addAddrListItem = new AddAddrListItem();
            addAddrListItem.e(this.f45234m);
            addAddrListItem.f(defiChainInfo);
            this.f45230i.add(addAddrListItem);
            this.f45231j.add(defiChainInfo.getChain());
        }
        this.f45223b.setData(this.f45230i);
        m();
    }

    public void v() {
        this.f45229h.b();
    }

    public BindAddressView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f45230i = new ArrayList();
        this.f45231j = new HashSet();
        this.f45234m = new a();
        FrameLayout.inflate(context, R$layout.dialog_on_chain_add_addr, this);
        p();
        k();
        l();
    }
}
