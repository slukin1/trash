package com.huobi.staring.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.core.ui.EmptyMVPFragment;
import com.hbg.lib.network.contract.core.util.RemindBusinessType;
import com.hbg.lib.network.contract.core.util.RemindContractType;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.CommonStatusView;
import com.hbg.lib.widgets.recycler.CommonRecyclerView;
import com.huobi.staring.bean.RemindSearchListItem;
import com.huobi.staring.bean.RuleConfigResult;
import com.huobi.staring.helper.StaringRemindHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import cs.n;
import cs.p;
import d7.a1;
import ds.x0;
import ds.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pro.huobi.R;

public class RemindSearchListFragment extends EmptyMVPFragment {

    /* renamed from: l  reason: collision with root package name */
    public EditText f81250l;

    /* renamed from: m  reason: collision with root package name */
    public View f81251m;

    /* renamed from: n  reason: collision with root package name */
    public CommonRecyclerView<RemindSearchListItem> f81252n;

    /* renamed from: o  reason: collision with root package name */
    public CommonStatusView f81253o;

    /* renamed from: p  reason: collision with root package name */
    public ArrayList<RemindSearchListItem> f81254p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f81255q;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            if (obj.equals("")) {
                RemindSearchListFragment.this.f81251m.setVisibility(8);
                EditText editText = RemindSearchListFragment.this.f81250l;
                editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_medium));
            } else {
                RemindSearchListFragment.this.f81251m.setVisibility(0);
                EditText editText2 = RemindSearchListFragment.this.f81250l;
                editText2.setTypeface(ResourcesCompat.h(editText2.getContext(), R.font.din_bold));
            }
            RemindSearchListFragment.this.Uh(RemindSearchListFragment.this.Lh(obj));
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class b extends BaseSubscriber<RuleConfigResult> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(RuleConfigResult ruleConfigResult) {
            super.onNext(ruleConfigResult);
            RemindSearchListFragment.this.Rh(ruleConfigResult);
        }

        public void onAfter() {
            super.onAfter();
            RemindSearchListFragment.this.dismissProgressDialog();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            th2.printStackTrace();
            RemindSearchListFragment.this.m0();
        }
    }

    public class c extends BaseSubscriber<RuleConfigResult> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(RuleConfigResult ruleConfigResult) {
            super.onNext(ruleConfigResult);
            RemindSearchListFragment.this.Sh(ruleConfigResult);
        }

        public void onAfter() {
            super.onAfter();
            RemindSearchListFragment.this.dismissProgressDialog();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            th2.printStackTrace();
            RemindSearchListFragment.this.m0();
        }
    }

    public RemindSearchListFragment() {
        this.f81255q = false;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Oh(View view) {
        this.f81250l.setText("");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ph(int i11, CommonStatusView.b bVar) {
        Qh(i11);
    }

    public void Ah() {
        super.Ah();
    }

    public final List<RemindSearchListItem> Lh(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.f81254p;
        }
        ArrayList<RemindSearchListItem> arrayList = this.f81254p;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        String lowerCase = str.toLowerCase();
        ArrayList arrayList2 = new ArrayList();
        Iterator<RemindSearchListItem> it2 = this.f81254p.iterator();
        while (it2.hasNext()) {
            RemindSearchListItem next = it2.next();
            if (next != null) {
                String lowerCase2 = next.getSymbol().toLowerCase();
                String lowerCase3 = next.getShowTitle().toLowerCase();
                if (lowerCase2.contains(lowerCase) || lowerCase3.contains(lowerCase)) {
                    arrayList2.add(next);
                }
            }
        }
        return arrayList2;
    }

    public final void Mh() {
        this.f81250l = (EditText) this.f67460i.b(R.id.search_symbol_input);
        this.f81251m = this.f67460i.b(R.id.search_symbol_input_clear);
        this.f81250l.addTextChangedListener(new a());
        this.f81251m.setOnClickListener(new x0(this));
    }

    public boolean Nh() {
        return this.f81255q;
    }

    public final void Qh(int i11) {
        if (i11 == -3 || i11 == -2) {
            this.f81253o.b();
            Th();
        }
    }

    public final void Rh(RuleConfigResult ruleConfigResult) {
        List<String> symbols = ruleConfigResult.getCustom().getPrice().getSymbols();
        this.f81254p = new ArrayList<>();
        for (String next : symbols) {
            if (!TextUtils.isEmpty(next)) {
                RemindBusinessType d11 = p.c().d(next);
                RemindContractType e11 = p.c().e(next);
                if (!(e11 == null || d11 == null)) {
                    String f11 = p.c().f(getContext(), Nh(), d11, next);
                    if (!TextUtils.isEmpty(f11)) {
                        RemindSearchListItem remindSearchListItem = new RemindSearchListItem();
                        remindSearchListItem.setSymbol(next);
                        remindSearchListItem.setShowTitle(f11);
                        remindSearchListItem.setContract(Nh());
                        remindSearchListItem.setBusinessType(d11);
                        remindSearchListItem.setContractType(e11);
                        this.f81254p.add(remindSearchListItem);
                    }
                }
            }
        }
        Uh(this.f81254p);
    }

    public final void Sh(RuleConfigResult ruleConfigResult) {
        List<String> symbols = ruleConfigResult.getCustom().getPrice().getSymbols();
        this.f81254p = new ArrayList<>();
        for (String next : symbols) {
            if (!TextUtils.isEmpty(next)) {
                String p11 = a1.v().p(next);
                String F = a1.v().F(next);
                if (!TextUtils.isEmpty(p11) && !TextUtils.isEmpty(F)) {
                    RemindSearchListItem remindSearchListItem = new RemindSearchListItem();
                    remindSearchListItem.setSymbol(next);
                    remindSearchListItem.setShowTitle(p11);
                    remindSearchListItem.setShowSubTitle(F);
                    this.f81254p.add(remindSearchListItem);
                }
            }
        }
        Uh(this.f81254p);
    }

    public final void Th() {
        if (Nh()) {
            if (n.k()) {
                Rh(n.j());
                return;
            }
            showProgressDialog();
            n.w(new b());
        } else if (StaringRemindHelper.g()) {
            Sh(StaringRemindHelper.e());
        } else {
            showProgressDialog();
            StaringRemindHelper.o(new c());
        }
    }

    public final void Uh(List<RemindSearchListItem> list) {
        if (list == null || list.isEmpty()) {
            this.f81253o.n();
            return;
        }
        this.f81252n.setData(list);
        this.f81253o.b();
    }

    public void afterInit() {
        super.afterInit();
        this.f81253o.setRelatedView(this.f81252n);
        Th();
    }

    public void initViews() {
        super.initViews();
        this.f81252n = (CommonRecyclerView) this.f67460i.b(R.id.id_reminder_recyclerView);
        CommonStatusView commonStatusView = (CommonStatusView) this.f67460i.b(R.id.id_reminder_commonStatusView);
        this.f81253o = commonStatusView;
        commonStatusView.setCallback(new y0(this));
        Mh();
    }

    public final void m0() {
        this.f81253o.p();
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_remind_coin_list, viewGroup, false);
    }

    public RemindSearchListFragment(boolean z11) {
        this.f81255q = z11;
    }
}
