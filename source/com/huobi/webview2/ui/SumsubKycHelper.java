package com.huobi.webview2.ui;

import com.hbg.lib.core.util.AppLanguageHelper;
import com.sumsub.sns.core.SNSMobileSDK;
import com.sumsub.sns.core.data.listener.SNSCompleteHandler;
import com.sumsub.sns.core.data.listener.SNSErrorHandler;
import com.sumsub.sns.core.data.listener.TokenExpirationHandler;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.core.data.model.SNSException;
import com.sumsub.sns.core.data.model.SNSSDKState;
import d10.l;
import i6.k;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.i;
import kotlin.jvm.internal.r;

public final class SumsubKycHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final a f20900a = new a((r) null);

    /* renamed from: b  reason: collision with root package name */
    public static final i<SumsubKycHelper> f20901b = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.SYNCHRONIZED, SumsubKycHelper$Companion$instance$2.INSTANCE);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final SumsubKycHelper a() {
            return (SumsubKycHelper) SumsubKycHelper.f20901b.getValue();
        }
    }

    public static final class b implements TokenExpirationHandler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SumsubKycHelper f20902a;

        public b(SumsubKycHelper sumsubKycHelper) {
            this.f20902a = sumsubKycHelper;
        }

        public String onTokenExpired() {
            this.f20902a.d("token异常");
            return null;
        }
    }

    public static final class c implements SNSCompleteHandler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SumsubKycHelper f20903a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l<String, Unit> f20904b;

        public c(SumsubKycHelper sumsubKycHelper, l<? super String, Unit> lVar) {
            this.f20903a = sumsubKycHelper;
            this.f20904b = lVar;
        }

        public void onComplete(SNSCompletionResult sNSCompletionResult, SNSSDKState sNSSDKState) {
            String str;
            if (sNSCompletionResult instanceof SNSCompletionResult.SuccessTermination) {
                SumsubKycHelper sumsubKycHelper = this.f20903a;
                sumsubKycHelper.d("withCompleteHandler -->" + sNSSDKState.getName());
                if (sNSSDKState instanceof SNSSDKState.Pending) {
                    this.f20904b.invoke("");
                } else {
                    this.f20904b.invoke(sNSSDKState.getMessage());
                }
            } else if (sNSCompletionResult instanceof SNSCompletionResult.AbnormalTermination) {
                l<String, Unit> lVar = this.f20904b;
                SNSCompletionResult.AbnormalTermination abnormalTermination = (SNSCompletionResult.AbnormalTermination) sNSCompletionResult;
                Throwable exception = abnormalTermination.getException();
                if (exception == null || (str = exception.getMessage()) == null) {
                    str = "未知错误";
                }
                lVar.invoke(str);
                SumsubKycHelper sumsubKycHelper2 = this.f20903a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("AbnormalTermination --> ");
                Throwable exception2 = abnormalTermination.getException();
                sb2.append(exception2 != null ? exception2.getMessage() : null);
                sumsubKycHelper2.d(sb2.toString());
            } else {
                this.f20904b.invoke(sNSSDKState.getName());
            }
        }
    }

    public static final class d implements SNSErrorHandler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l<String, Unit> f20905a;

        public d(l<? super String, Unit> lVar) {
            this.f20905a = lVar;
        }

        public void onError(SNSException sNSException) {
            l<String, Unit> lVar = this.f20905a;
            String message = sNSException.getMessage();
            if (message == null) {
                message = "未知错误";
            }
            lVar.invoke(message);
        }
    }

    public SumsubKycHelper() {
    }

    public /* synthetic */ SumsubKycHelper(r rVar) {
        this();
    }

    public final void c(String str, l<? super String, Unit> lVar) {
        new SNSMobileSDK.Builder(com.blankj.utilcode.util.a.c()).withAccessToken(str, new b(this)).withCompleteHandler(new c(this, lVar)).withErrorHandler(new d(lVar)).withLocale(AppLanguageHelper.getInstance().getCurAppLocale()).withAnalyticsEnabled(false).build().launch();
    }

    public final void d(Object obj) {
        k.d("SumsubKycHelper", String.valueOf(obj));
    }
}
