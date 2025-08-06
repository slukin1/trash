package oo;

import android.text.TextUtils;
import com.hbg.lib.common.utils.SystemUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huobi.domain.DomainSwitcher;
import com.huobi.network.listener.HbContractInterceptorListener;

public class a extends HbContractInterceptorListener {

    /* renamed from: a  reason: collision with root package name */
    public String f84519a;

    public a(String str) {
        this.f84519a = str;
    }

    public String getWebSocketHost() {
        String str = "l10n-dm.huobi.cn";
        if (SystemUtils.c()) {
            String x11 = DomainSwitcher.x();
            if (!TextUtils.isEmpty(x11)) {
                str = x11;
            }
        } else if (this.f84519a.equals("linear-swap-notification")) {
            str = "quotation-linear-swap-new-notification.global-base.tc-jp1.huobiapps.com";
        } else if (this.f84519a.equals("swap-notification")) {
            str = "swap-trade-new-notification.global-base.tc-jp1.huobiapps.com";
        } else if (this.f84519a.equals(RemoteMessageConst.NOTIFICATION)) {
            str = "contract-trade-new-notification.global-base.tc-jp1.huobiapps.com";
        } else if (this.f84519a.equals("ws/v5/notification")) {
            str = "v5-user-data-push.global-base.tc-jp1.huobiapps.com";
        }
        return "wss://" + str + "/" + this.f84519a;
    }
}
