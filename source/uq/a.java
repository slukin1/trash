package uq;

import android.app.Activity;
import android.text.TextUtils;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.riskcontrol.bean.SecurityVerifyParam;
import com.huobi.riskcontrol.ui.RiskControlActivity;

public final class a {
    public static boolean a(Activity activity, APIStatusErrorException aPIStatusErrorException, SecurityVerifyParam.Scene scene, SecurityVerifyParam.RiskOperate riskOperate) {
        return b(activity, aPIStatusErrorException, scene, riskOperate, false);
    }

    public static boolean b(Activity activity, APIStatusErrorException aPIStatusErrorException, SecurityVerifyParam.Scene scene, SecurityVerifyParam.RiskOperate riskOperate, boolean z11) {
        SecurityVerifyParam.VerifyType verifyType;
        if (aPIStatusErrorException == null) {
            return false;
        }
        String errCode = aPIStatusErrorException.getErrCode();
        errCode.hashCode();
        char c11 = 65535;
        switch (errCode.hashCode()) {
            case 46761907:
                if (errCode.equals("11212")) {
                    c11 = 0;
                    break;
                }
                break;
            case 46761908:
                if (errCode.equals("11213")) {
                    c11 = 1;
                    break;
                }
                break;
            case 46761909:
                if (errCode.equals("11214")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        String str = null;
        switch (c11) {
            case 0:
                verifyType = SecurityVerifyParam.VerifyType.FACE;
                break;
            case 1:
                verifyType = SecurityVerifyParam.VerifyType.EMAIL;
                break;
            case 2:
                verifyType = SecurityVerifyParam.VerifyType.MOBILE;
                break;
            default:
                if (!TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                    HuobiToastUtil.l(BaseApplication.b(), aPIStatusErrorException.getErrMsg());
                }
                verifyType = null;
                break;
        }
        if (verifyType == null || activity == null || aPIStatusErrorException.getData() == null || !(aPIStatusErrorException.getData() instanceof p9.a)) {
            return false;
        }
        p9.a aVar = (p9.a) aPIStatusErrorException.getData();
        if (aVar != null) {
            str = aVar.getTsvToken();
        }
        SecurityVerifyParam securityVerifyParam = new SecurityVerifyParam(verifyType, scene, riskOperate, str);
        securityVerifyParam.setResetPassword(z11);
        securityVerifyParam.buildHint(activity);
        RiskControlActivity.sh(activity, securityVerifyParam);
        activity.finish();
        return true;
    }
}
