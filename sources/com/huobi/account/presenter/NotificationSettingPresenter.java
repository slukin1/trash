package com.huobi.account.presenter;

import android.text.TextUtils;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.NoticeManageResp;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import java.util.ArrayList;
import java.util.List;
import tg.r;
import u6.g;

public class NotificationSettingPresenter extends ActivityPresenter<c> {

    public class a extends BaseSubscriber<List<NoticeManageResp>> {
        public a() {
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            ((c) NotificationSettingPresenter.this.getUI()).H6((List<NoticeManageResp>) null);
        }

        public void onNext(List<NoticeManageResp> list) {
            super.onNext(list);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < list.size(); i11++) {
                    if ((!"1".equals(list.get(i11).getMessageType()) || !TextUtils.isEmpty(r.x().F())) && (!"2".equals(list.get(i11).getMessageType()) || !TextUtils.isEmpty(r.x().u()))) {
                        arrayList.add(list.get(i11));
                    }
                }
                ((c) NotificationSettingPresenter.this.getUI()).H6(arrayList);
            }
        }
    }

    public class b extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c6.b f41034b;

        public b(c6.b bVar) {
            this.f41034b = bVar;
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            this.f41034b.onCallback(Boolean.FALSE);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            this.f41034b.onCallback(Boolean.FALSE);
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            c6.b bVar = this.f41034b;
            if (bVar != null) {
                bVar.onCallback(Boolean.TRUE);
            }
        }
    }

    public interface c extends g {
        void H6(List<NoticeManageResp> list);
    }

    public void Q() {
        v7.b.a().B().b().compose(RxJavaHelper.t((g) null)).subscribe(new a());
    }

    /* renamed from: R */
    public void onUIReady(BaseCoreActivity baseCoreActivity, c cVar) {
        super.onUIReady(baseCoreActivity, cVar);
        Q();
    }

    public void S(List<Integer> list, Integer num, c6.b bVar) {
        v7.b.a().F0(list, num.intValue()).b().compose(RxJavaHelper.t((g) null)).subscribe(new b(bVar));
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
