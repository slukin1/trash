package com.huobi.points.presenter;

import android.text.TextUtils;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.points.activity.MyTransferActivity;
import com.huobi.points.activity.PointsHistoryDetailsActivity;
import com.huobi.points.activity.TransferToMeActivity;
import com.huobi.points.entity.Points;
import com.huobi.points.entity.PointsAction;
import com.huobi.points.utils.PointsDataSource;
import gq.d;
import iq.c0;
import iq.d0;
import iq.e0;
import iq.f0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import u6.g;

public class TransferOrderListPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public long f80494a;

    /* renamed from: b  reason: collision with root package name */
    public final List<s9.a> f80495b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final Set<Long> f80496c = new HashSet();

    /* renamed from: d  reason: collision with root package name */
    public d.a f80497d = new a();

    public class a implements d.a {
        public a() {
        }

        public void a(d dVar) {
            String state = dVar.f84175c.getState();
            state.hashCode();
            if (!state.equals("submitted")) {
                PointsAction pointsAction = new PointsAction();
                pointsAction.setOrderId(dVar.f84175c.getId());
                pointsAction.setDirection(PointsAction.TYPE_TRANSFER_IN.equals(((b) TransferOrderListPresenter.this.getUI()).getType()) ? "in" : "out");
                pointsAction.setType(((b) TransferOrderListPresenter.this.getUI()).getType());
                PointsHistoryDetailsActivity.fg(TransferOrderListPresenter.this.getActivity(), pointsAction);
                return;
            }
            String type = ((b) TransferOrderListPresenter.this.getUI()).getType();
            type.hashCode();
            if (type.equals(PointsAction.TYPE_TRANSFER_OUT)) {
                MyTransferActivity.th(TransferOrderListPresenter.this.getActivity(), dVar.f84175c.getId());
            } else if (type.equals(PointsAction.TYPE_TRANSFER_IN)) {
                TransferToMeActivity.wh(TransferOrderListPresenter.this.getActivity(), dVar.f84175c.getId());
            }
        }

        public String getType() {
            return ((b) TransferOrderListPresenter.this.getUI()).getType();
        }
    }

    public interface b extends g {
        String C7();

        void G(List<s9.a> list);

        String getType();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List X(List list) {
        if (this.f80494a == 0) {
            this.f80495b.clear();
            this.f80496c.clear();
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Points points = (Points) it2.next();
                if (points != null) {
                    if (!this.f80496c.contains(Long.valueOf(points.getId()))) {
                        arrayList.add(new d(points, this.f80497d));
                    }
                    this.f80496c.add(Long.valueOf(points.getId()));
                }
            }
            if (!list.isEmpty()) {
                this.f80494a = ((Points) list.get(list.size() - 1)).getId();
            }
        }
        this.f80495b.addAll(arrayList);
        return this.f80495b;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y(List list) {
        ((b) getUI()).G(list);
    }

    public static /* synthetic */ void Z(APIStatusErrorException aPIStatusErrorException) {
    }

    public static /* synthetic */ void a0(Throwable th2) {
    }

    /* renamed from: b0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
    }

    public void c0() {
        Map<String, Object> b11 = MapParamsBuilder.c().b();
        b11.put("size", 10);
        b11.put("type", ((b) getUI()).getType());
        long j11 = this.f80494a;
        if (j11 > 0) {
            b11.put("from", Long.valueOf(j11));
        }
        if (!TextUtils.isEmpty(((b) getUI()).C7())) {
            b11.put("states", ((b) getUI()).C7());
        }
        PointsDataSource.d(b11).compose(RxJavaHelper.t((g) getUI())).map(new f0(this)).subscribe(q6.d.d((g) getUI(), new c0(this), d0.f55800b, e0.f55802b));
    }

    public void d0() {
        this.f80494a = 0;
    }

    public void onResume() {
        super.onResume();
        d0();
        c0();
    }
}
