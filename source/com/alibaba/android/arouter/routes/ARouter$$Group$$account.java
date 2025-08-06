package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huobi.account.ui.AccountOrderManageActivity;
import com.huobi.account.ui.DominicaKycPageActivity;
import com.huobi.account.ui.HelpCenterActivity;
import com.huobi.account.ui.KycAuthInfoActivity;
import com.huobi.account.ui.KycInstitutionAuthActivity;
import com.huobi.account.ui.MultipleAccountActivity;
import com.huobi.account.ui.SecuritySetActivity;
import com.huobi.account.ui.SubscribeAllActivity;
import com.huobi.account.ui.UserNftSettingActivity;
import com.huobi.fee.FeeRateActivity;
import com.huobi.integration.IntegrationActivity;
import com.huobi.invite.ui.InviteActivity;
import com.huobi.kyc.ui.KycCountryAreaSelectActivity;
import com.huobi.kyc.ui.KycQuickAuthDialogActivity;
import com.huobi.message.ui.MessageActivity;
import com.tencent.android.tpush.common.Constants;
import java.util.Map;

public class ARouter$$Group$$account implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/account/MessageCenter", RouteMeta.build(routeType, MessageActivity.class, "/account/messagecenter", Constants.FLAG_ACCOUNT, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/account/dominicaKyc", RouteMeta.build(routeType, DominicaKycPageActivity.class, "/account/dominicakyc", Constants.FLAG_ACCOUNT, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/account/fee", RouteMeta.build(routeType, FeeRateActivity.class, "/account/fee", Constants.FLAG_ACCOUNT, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/account/help", RouteMeta.build(routeType, HelpCenterActivity.class, "/account/help", Constants.FLAG_ACCOUNT, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/account/institutionKyc", RouteMeta.build(routeType, KycInstitutionAuthActivity.class, "/account/institutionkyc", Constants.FLAG_ACCOUNT, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/account/invite", RouteMeta.build(routeType, InviteActivity.class, "/account/invite", Constants.FLAG_ACCOUNT, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/account/kyc", RouteMeta.build(routeType, KycAuthInfoActivity.class, "/account/kyc", Constants.FLAG_ACCOUNT, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/account/kycCountryList", RouteMeta.build(routeType, KycCountryAreaSelectActivity.class, "/account/kyccountrylist", Constants.FLAG_ACCOUNT, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/account/kycQuickAuth", RouteMeta.build(routeType, KycQuickAuthDialogActivity.class, "/account/kycquickauth", Constants.FLAG_ACCOUNT, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/account/multiple", RouteMeta.build(routeType, MultipleAccountActivity.class, "/account/multiple", Constants.FLAG_ACCOUNT, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/account/mySubscribes", RouteMeta.build(routeType, SubscribeAllActivity.class, "/account/mysubscribes", Constants.FLAG_ACCOUNT, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/account/order", RouteMeta.build(routeType, AccountOrderManageActivity.class, "/account/order", Constants.FLAG_ACCOUNT, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/account/score", RouteMeta.build(routeType, IntegrationActivity.class, "/account/score", Constants.FLAG_ACCOUNT, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/account/security", RouteMeta.build(routeType, SecuritySetActivity.class, "/account/security", Constants.FLAG_ACCOUNT, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/account/userInfoPage", RouteMeta.build(routeType, UserNftSettingActivity.class, "/account/userinfopage", Constants.FLAG_ACCOUNT, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
