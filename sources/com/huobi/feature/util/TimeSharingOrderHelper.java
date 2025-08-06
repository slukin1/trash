package com.huobi.feature.util;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import bj.p0;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapOrderTimeSharingRspInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.entity.ContractOrderTimingRequestData;
import com.huobi.feature.ui.dialog.TimeSharingOrderConfirmDialog;
import pro.huobi.R;
import u6.g;

public class TimeSharingOrderHelper {

    public class a extends EasySubscriber<LinearSwapOrderTimeSharingRspInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f45174b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f45175c;

        public a(Context context, b bVar) {
            this.f45174b = context;
            this.f45175c = bVar;
        }

        /* renamed from: a */
        public void onNext(LinearSwapOrderTimeSharingRspInfo linearSwapOrderTimeSharingRspInfo) {
            super.onNext(linearSwapOrderTimeSharingRspInfo);
            Context context = this.f45174b;
            HuobiToastUtil.u(context, context.getResources().getString(R.string.n_exchange_timing_order_success));
            b bVar = this.f45175c;
            if (bVar != null) {
                bVar.v4();
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            aPIStatusErrorException.printStackTrace();
            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
            b bVar = this.f45175c;
            if (bVar != null) {
                bVar.Af();
            }
        }
    }

    public interface b {
        void Af();

        void v4();
    }

    public static void b(Context context, ContractOrderTimingRequestData contractOrderTimingRequestData, b bVar) {
        String contractCode = contractOrderTimingRequestData.getContractCode();
        String contractType = contractOrderTimingRequestData.getContractType();
        String marginMode = contractOrderTimingRequestData.getMarginMode();
        String direction = contractOrderTimingRequestData.getDirection();
        int levelRate = contractOrderTimingRequestData.getLevelRate();
        Context context2 = context;
        h8.a.a().h0(contractCode, contractType, marginMode, direction, contractOrderTimingRequestData.getOffset(), levelRate, contractOrderTimingRequestData.getPriceInterval(), contractOrderTimingRequestData.getPriceIntervalMode(), contractOrderTimingRequestData.getPriceLimit(), contractOrderTimingRequestData.getTimeInterval(), contractOrderTimingRequestData.getUnitVolume(), contractOrderTimingRequestData.getVolume()).b().compose(RxJavaHelper.t((g) null)).subscribe(new a(context, bVar));
    }

    public void a(Context context, ContractOrderTimingRequestData contractOrderTimingRequestData) {
        if (p0.d()) {
            TimeSharingOrderConfirmDialog.vh(contractOrderTimingRequestData).show(((FragmentActivity) context).getSupportFragmentManager(), "TimeSharingOrderConfirmDialog");
        } else {
            b(context, contractOrderTimingRequestData, (b) null);
        }
    }
}
