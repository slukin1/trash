package com.geetest.captcha;

import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/geetest/captcha/utils/ErrorCode;", "", "()V", "CANCEL_DIALOG_BACK", "", "CANCEL_DIALOG_OUTSIDE", "CANCEL_WEB_VIEW", "NET_ERROR", "PARAM_CONFIG_GT_NULL", "PARAM_CONFIG_NULL", "PARAM_CONFIG_URL_ERROR", "PARAM_CONTEXT_NOT_ACTIVITY", "PARAM_CONTEXT_NULL", "PARAM_RESPONSE_NULL", "SUCCESS", "WEB_CALLBACK_JSON_ABSENT", "WEB_CALLBACK_JSON_ERROR", "WEB_CALLBACK_JSON_NULL", "WEB_VIEW_ERROR", "WEB_VIEW_HTTP_ERROR_20", "WEB_VIEW_HTTP_ERROR_21", "toCode", "status", "code", "COMPONENT", "captcha_release"}, k = 1, mv = {1, 1, 16})
public final class ac {

    /* renamed from: a  reason: collision with root package name */
    public static final ac f65160a = new ac();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/geetest/captcha/utils/ErrorCode$COMPONENT;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "WEB_VIEW_NEW", "PARAM", "WEB_VIEW_HTTP", "WEB_VIEW_SSL", "USER_ERROR", "WEB_CALLBACK_ERROR", "NET", "captcha_release"}, k = 1, mv = {1, 1, 16})
    public enum a {
        WEB_VIEW_NEW("0"),
        PARAM("1"),
        WEB_VIEW_HTTP("2"),
        WEB_VIEW_SSL("3"),
        USER_ERROR("4"),
        WEB_CALLBACK_ERROR(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC),
        NET(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL);
        
        private String type;

        private a(String str) {
            this.type = str;
        }

        public final String getType() {
            return this.type;
        }

        public final void setType(String str) {
            this.type = str;
        }
    }

    private ac() {
    }

    public static String a(String str, String str2) {
        return x.i(str, str2);
    }
}
