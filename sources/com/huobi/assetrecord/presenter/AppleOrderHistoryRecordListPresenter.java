package com.huobi.assetrecord.presenter;

import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.AppleHistoryRecordBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.assetrecord.item.AppleOrderHistoryItemData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ji.c;
import ji.d;
import u6.g;
import v7.b;

public class AppleOrderHistoryRecordListPresenter extends ActivityPresenter<a> {

    /* renamed from: a  reason: collision with root package name */
    public List<AppleOrderHistoryItemData> f42821a = new ArrayList();

    public interface a extends g {
        void Ug(int i11);

        void finishRefresh();

        void u5(List<s9.a> list);
    }

    public static /* synthetic */ List U(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            AppleHistoryRecordBean appleHistoryRecordBean = (AppleHistoryRecordBean) it2.next();
            AppleOrderHistoryItemData appleOrderHistoryItemData = new AppleOrderHistoryItemData();
            appleOrderHistoryItemData.h(appleHistoryRecordBean.getApplyDate());
            appleOrderHistoryItemData.i(appleHistoryRecordBean.getRecordBeginDate());
            appleOrderHistoryItemData.j(appleHistoryRecordBean.getRecordEndDate());
            appleOrderHistoryItemData.g(appleHistoryRecordBean.getUserEmail());
            appleOrderHistoryItemData.k(appleHistoryRecordBean.getStatus());
            arrayList.add(appleOrderHistoryItemData);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V(List list) {
        if (CollectionsUtils.b(list)) {
            ((a) getUI()).Ug(3);
            return;
        }
        ((a) getUI()).u5(list);
        ((a) getUI()).finishRefresh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W(APIStatusErrorException aPIStatusErrorException) {
        ((a) getUI()).Ug(2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X(Throwable th2) {
        ((a) getUI()).Ug(2);
    }

    public void Y() {
        b.a().getAppleHistoryList().b().compose(RxJavaHelper.t((g) getUI())).map(d.f55947b).subscribe(EasySubscriber.create(new c(this), new ji.a(this), new ji.b(this)));
    }

    /* renamed from: Z */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        Y();
    }
}
