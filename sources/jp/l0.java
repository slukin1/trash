package jp;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huobi.otc.bean.OtcOrderDetailInfo;
import com.huobi.otc.ui.OtcLiteChatActivity;

public final class l0 {
    public static void a(Context context, OtcOrderDetailInfo otcOrderDetailInfo) {
        if (otcOrderDetailInfo != null && otcOrderDetailInfo.getOtcOrder() != null) {
            Intent intent = new Intent();
            intent.setClass(context, OtcLiteChatActivity.class);
            intent.putExtra("otcOrder", otcOrderDetailInfo);
            if (otcOrderDetailInfo.getOtherInfo() != null) {
                intent.putExtra("merchantLevel", otcOrderDetailInfo.getOtherInfo().getMerchantLevel());
            }
            context.startActivity(intent);
        }
    }

    public static void b(Context context, String str, boolean z11) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent();
            intent.setClass(context, OtcLiteChatActivity.class);
            intent.putExtra("orderId", str);
            intent.putExtra("needBackToDetailPage", z11);
            context.startActivity(intent);
        }
    }
}
