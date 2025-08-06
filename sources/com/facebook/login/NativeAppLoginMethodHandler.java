package com.facebook.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;

abstract class NativeAppLoginMethodHandler extends LoginMethodHandler {
    public NativeAppLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    private String getError(Bundle bundle) {
        String string = bundle.getString("error");
        return string == null ? bundle.getString("error_type") : string;
    }

    private String getErrorMessage(Bundle bundle) {
        String string = bundle.getString("error_message");
        return string == null ? bundle.getString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION) : string;
    }

    private LoginClient.Result handleResultCancel(LoginClient.Request request, Intent intent) {
        Bundle extras = intent.getExtras();
        String error = getError(extras);
        String obj = extras.get(NativeProtocol.BRIDGE_ARG_ERROR_CODE) != null ? extras.get(NativeProtocol.BRIDGE_ARG_ERROR_CODE).toString() : null;
        if (ServerProtocol.errorConnectionFailure.equals(obj)) {
            return LoginClient.Result.createErrorResult(request, error, getErrorMessage(extras), obj);
        }
        return LoginClient.Result.createCancelResult(request, error);
    }

    private LoginClient.Result handleResultOk(LoginClient.Request request, Intent intent) {
        Bundle extras = intent.getExtras();
        String error = getError(extras);
        String obj = extras.get(NativeProtocol.BRIDGE_ARG_ERROR_CODE) != null ? extras.get(NativeProtocol.BRIDGE_ARG_ERROR_CODE).toString() : null;
        String errorMessage = getErrorMessage(extras);
        String string = extras.getString("e2e");
        if (!Utility.isNullOrEmpty(string)) {
            logWebLoginCompleted(string);
        }
        if (error == null && obj == null && errorMessage == null) {
            try {
                return LoginClient.Result.createTokenResult(request, LoginMethodHandler.createAccessTokenFromWebBundle(request.getPermissions(), extras, AccessTokenSource.FACEBOOK_APPLICATION_WEB, request.getApplicationId()));
            } catch (FacebookException e11) {
                return LoginClient.Result.createErrorResult(request, (String) null, e11.getMessage());
            }
        } else if (ServerProtocol.errorsProxyAuthDisabled.contains(error)) {
            return null;
        } else {
            if (ServerProtocol.errorsUserCanceled.contains(error)) {
                return LoginClient.Result.createCancelResult(request, (String) null);
            }
            return LoginClient.Result.createErrorResult(request, error, errorMessage, obj);
        }
    }

    public boolean onActivityResult(int i11, int i12, Intent intent) {
        LoginClient.Result result;
        LoginClient.Request pendingRequest = this.loginClient.getPendingRequest();
        if (intent == null) {
            result = LoginClient.Result.createCancelResult(pendingRequest, "Operation canceled");
        } else if (i12 == 0) {
            result = handleResultCancel(pendingRequest, intent);
        } else if (i12 != -1) {
            result = LoginClient.Result.createErrorResult(pendingRequest, "Unexpected resultCode from authorization.", (String) null);
        } else {
            result = handleResultOk(pendingRequest, intent);
        }
        if (result != null) {
            this.loginClient.completeAndValidate(result);
            return true;
        }
        this.loginClient.tryNextHandler();
        return true;
    }

    public abstract boolean tryAuthorize(LoginClient.Request request);

    public boolean tryIntent(Intent intent, int i11) {
        if (intent == null) {
            return false;
        }
        try {
            this.loginClient.getFragment().startActivityForResult(intent, i11);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public NativeAppLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }
}
