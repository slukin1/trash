package com.sumsub.sns.internal.core.domain.base;

import com.sumsub.sns.core.data.listener.SNSErrorHandler;
import com.sumsub.sns.core.data.model.SNSApplicantNotFoundException;
import com.sumsub.sns.core.data.model.SNSConfigNotFoundException;
import com.sumsub.sns.core.data.model.SNSException;
import com.sumsub.sns.core.data.model.SNSSDKState;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.data.source.common.a;
import com.sumsub.sns.internal.log.c;

public final class d {
    public static final Exception a(a aVar, Exception exc) {
        SNSSDKState sNSSDKState;
        if (exc instanceof SNSException) {
            SNSException sNSException = (SNSException) exc;
            if (sNSException instanceof SNSException.Api) {
                Integer code = ((SNSException.Api) exc).getCode();
                if (code != null && code.intValue() == 401) {
                    sNSSDKState = SNSSDKState.Failed.Unauthorized.INSTANCE;
                } else {
                    sNSSDKState = new SNSSDKState.Failed.Unknown(exc);
                }
                aVar.a(sNSSDKState);
            } else if (sNSException instanceof SNSException.Unknown) {
                aVar.a((SNSSDKState) new SNSSDKState.Failed.Unknown(exc));
            } else if (sNSException instanceof SNSException.Network) {
                aVar.a((SNSSDKState) new SNSSDKState.Failed.NetworkError(exc));
            }
            try {
                SNSErrorHandler errorHandler = e0.f32018a.getErrorHandler();
                if (errorHandler != null) {
                    errorHandler.onError((SNSException) exc);
                }
            } catch (Exception e11) {
                com.sumsub.sns.internal.log.a aVar2 = com.sumsub.sns.internal.log.a.f34862a;
                String a11 = c.a(aVar);
                String message = e11.getMessage();
                if (message == null) {
                    message = "";
                }
                aVar2.e(a11, message, e11);
            }
        } else if (exc instanceof SNSApplicantNotFoundException) {
            aVar.a((SNSSDKState) new SNSSDKState.Failed.ApplicantNotFound(exc));
        } else if (exc instanceof SNSConfigNotFoundException) {
            aVar.a((SNSSDKState) new SNSSDKState.Failed.InitialLoadingFailed(exc));
        }
        return exc;
    }
}
