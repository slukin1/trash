package com.huobi.trade.ui;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.hbg.lib.widgets.dialog.dialogfragment.BaseListDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import java.util.ArrayList;
import java.util.List;
import pro.huobi.R;
import ws.e;

public class TradeGuideDialogFragment extends BaseListDialogFragment<e> implements e.a, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public a f82397b;

    /* renamed from: c  reason: collision with root package name */
    public int f82398c;

    public interface a {
        void onItemClick(int i11);
    }

    public void N3(e eVar, int i11) {
        a aVar;
        if (this.f82398c == i11 && (aVar = this.f82397b) != null) {
            aVar.onItemClick(eVar.f());
        }
    }

    public int N6() {
        return this.f82398c;
    }

    public void addEvent(r rVar) {
        super.addEvent(rVar);
        rVar.b(R.id.id_trade_guide_dialog_close_btn).setOnClickListener(this);
    }

    public int getContentViewResId() {
        return R.layout.layout_trade_guide_list_dialog;
    }

    public List<e> getDataList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new e(0, getString(R.string.login_sign_up), "", this));
        arrayList.add(new e(1, getString(R.string.index_deal_guide_fiat), getString(R.string.trade_guide_dialog_item_desc_otc), this));
        arrayList.add(new e(2, getString(R.string.index_deal_guide_transter), getString(R.string.trade_guide_dialog_item_desc_transfer), this));
        arrayList.add(new e(3, getString(R.string.index_deal_guide_trade), "", this));
        return arrayList;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        super.initView(rVar);
        this.mRecyclerView.setBackgroundResource(R.drawable.shape_contract_trade_popwindow_corner_10);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R.id.id_trade_guide_dialog_close_btn) {
            dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void sh(a aVar) {
        this.f82397b = aVar;
    }

    public void th(FragmentManager fragmentManager, String str, int i11) {
        this.f82398c = i11;
        super.show(fragmentManager, str);
    }
}
