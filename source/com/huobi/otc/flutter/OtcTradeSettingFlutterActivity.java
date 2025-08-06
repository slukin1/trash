package com.huobi.otc.flutter;

import android.content.Context;
import android.content.Intent;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.ui.UpdateOtcTradePwdActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import jp.l;
import nb.c;
import pro.huobi.R;
import q6.d;

public class OtcTradeSettingFlutterActivity extends AbsOtcTradeFlutterActivity {
    /* access modifiers changed from: private */
    public /* synthetic */ void Gi(UserVO userVO) {
        if (userVO == null) {
            HuobiToastUtil.j(R.string.string_network_disconnect);
        } else if (userVO.isIsTradeBind()) {
            startActivity(new Intent(this, UpdateOtcTradePwdActivity.class));
        } else {
            c.j(this, false);
        }
    }

    public static void Hi(Context context) {
        context.startActivity(new Intent(context, OtcTradeSettingFlutterActivity.class));
    }

    public void Di(MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = methodCall.method;
            char c11 = 65535;
            if (str.hashCode() == 1424364717) {
                if (str.equals("openSetUpdateTradePasswordPage")) {
                    c11 = 0;
                }
            }
            if (c11 != 0) {
                result.notImplemented();
                return;
            }
            l.q(false).compose(RxJavaHelper.t(this)).subscribe(d.c(this, new s0(this)));
            result.success("");
        } catch (Exception unused) {
            result.notImplemented();
        }
    }

    public String Nh() {
        return "otc_trade_setting";
    }
}
