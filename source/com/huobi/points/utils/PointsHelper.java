package com.huobi.points.utils;

import android.content.Context;
import android.content.Intent;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.points.activity.PointsDetailListActivity;
import com.huobi.points.activity.PointsTransferActivity;
import com.huobi.points.activity.TransferOrderListActivity;
import com.huobi.points.entity.PointsAction;

public class PointsHelper {
    public static void a(Context context, String str) {
        if (str != null && !ViewUtil.c(1000)) {
            char c11 = 65535;
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 50:
                    if (str.equals("2")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 51:
                    if (str.equals("3")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 52:
                    if (str.equals("4")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 53:
                    if (str.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC)) {
                        c11 = 4;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    context.startActivity(new Intent(context, PointsTransferActivity.class));
                    return;
                case 1:
                    context.startActivity(new Intent(context, PointsDetailListActivity.class));
                    return;
                case 2:
                    TransferOrderListActivity.vh(context, PointsAction.TYPE_TRANSFER_IN, 0);
                    return;
                case 3:
                    TransferOrderListActivity.vh(context, PointsAction.TYPE_TRANSFER_OUT, 0);
                    return;
                case 4:
                    TransferOrderListActivity.vh(context, PointsAction.TYPE_TRANSFER_IN, 1);
                    return;
                default:
                    return;
            }
        }
    }
}
