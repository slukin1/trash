package com.huobi.account.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huobi.account.entity.ChooseCityEntity;
import com.huobi.account.entity.ChooseListData;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import og.o;
import pro.huobi.R;

public class SearchCityFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f41239b;

    /* renamed from: c  reason: collision with root package name */
    public View f41240c;

    /* renamed from: d  reason: collision with root package name */
    public o f41241d;

    /* renamed from: e  reason: collision with root package name */
    public List<ChooseCityEntity> f41242e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public String f41243f;

    /* renamed from: g  reason: collision with root package name */
    public o.d f41244g;

    /* renamed from: h  reason: collision with root package name */
    public ChooseListData f41245h;

    /* access modifiers changed from: private */
    public /* synthetic */ void sh(List list) {
        if (list == null || list.isEmpty()) {
            this.f41240c.setVisibility(0);
        } else {
            this.f41240c.setVisibility(8);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable("CHOOSE_LIST_DATA");
            if (serializable instanceof ChooseListData) {
                this.f41245h = (ChooseListData) serializable;
            }
        }
        ChooseListData chooseListData = this.f41245h;
        if (chooseListData != null) {
            qh(chooseListData.getList());
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_search_currency, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.no_result);
        this.f41240c = findViewById;
        findViewById.setVisibility(8);
        this.f41239b = (RecyclerView) inflate.findViewById(R.id.result_list);
        return inflate;
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

    public void qh(List<ChooseCityEntity> list) {
        if (list != null) {
            this.f41242e.clear();
            this.f41242e.addAll(list);
            o oVar = this.f41241d;
            if (oVar == null) {
                o oVar2 = new o(this.f41242e);
                this.f41241d = oVar2;
                oVar2.k(new p0(this));
                o.d dVar = this.f41244g;
                if (dVar != null) {
                    this.f41241d.l(dVar);
                }
                this.f41239b.setLayoutManager(new LinearLayoutManager(getActivity()));
                this.f41239b.setHasFixedSize(true);
                this.f41239b.setAdapter(this.f41241d);
            } else {
                oVar.notifyDataSetChanged();
            }
            if (this.f41243f != null) {
                this.f41241d.getFilter().filter(this.f41243f);
            }
        }
    }

    public void rh(String str) {
        o oVar;
        if (this.f41242e == null) {
            this.f41243f = str.toLowerCase(Locale.US);
        } else if (!TextUtils.isEmpty(str) && (oVar = this.f41241d) != null && oVar.getFilter() != null) {
            this.f41241d.getFilter().filter(str.toLowerCase(Locale.US));
        }
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public void th(o.d dVar) {
        this.f41244g = dVar;
    }
}
