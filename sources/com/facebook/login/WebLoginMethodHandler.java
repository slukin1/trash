package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;

abstract class WebLoginMethodHandler extends LoginMethodHandler {
    private static final String WEB_VIEW_AUTH_HANDLER_STORE = "com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY";
    private static final String WEB_VIEW_AUTH_HANDLER_TOKEN_KEY = "TOKEN";
    private String e2e;

    public WebLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    private String loadCookieToken() {
        return this.loginClient.getActivity().getSharedPreferences(WEB_VIEW_AUTH_HANDLER_STORE, 0).getString(WEB_VIEW_AUTH_HANDLER_TOKEN_KEY, "");
    }

    private void saveCookieToken(String str) {
        this.loginClient.getActivity().getSharedPreferences(WEB_VIEW_AUTH_HANDLER_STORE, 0).edit().putString(WEB_VIEW_AUTH_HANDLER_TOKEN_KEY, str).apply();
    }

    public Bundle addExtraParameters(Bundle bundle, LoginClient.Request request) {
        bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, getRedirectUrl());
        bundle.putString("client_id", request.getApplicationId());
        bundle.putString("e2e", LoginClient.getE2E());
        bundle.putString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST);
        bundle.putString(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, "true");
        bundle.putString(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, request.getAuthType());
        bundle.putString(ServerProtocol.DIALOG_PARAM_SDK_VERSION, String.format(Locale.ROOT, "android-%s", new Object[]{FacebookSdk.getSdkVersion()}));
        if (getSSODevice() != null) {
            bundle.putString(ServerProtocol.DIALOG_PARAM_SSO_DEVICE, getSSODevice());
        }
        return bundle;
    }

    public Bundle getParameters(LoginClient.Request request) {
        Bundle bundle = new Bundle();
        if (!Utility.isNullOrEmpty(request.getPermissions())) {
            String join = TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, request.getPermissions());
            bundle.putString("scope", join);
            addLoggingExtra("scope", join);
        }
        bundle.putString("default_audience", request.getDefaultAudience().getNativeProtocolAudience());
        bundle.putString("state", getClientState(request.getAuthId()));
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        String token = currentAccessToken != null ? currentAccessToken.getToken() : null;
        String str = "1";
        if (token == null || !token.equals(loadCookieToken())) {
            Utility.clearFacebookCookies(this.loginClient.getActivity());
            addLoggingExtra("access_token", "0");
        } else {
            bundle.putString("access_token", token);
            addLoggingExtra("access_token", str);
        }
        bundle.putString(ServerProtocol.DIALOG_PARAM_CBT, String.valueOf(System.currentTimeMillis()));
        if (!FacebookSdk.getAutoLogAppEventsEnabled()) {
            str = "0";
        }
        bundle.putString(ServerProtocol.DIALOG_PARAM_IES, str);
        return bundle;
    }

    public String getRedirectUrl() {
        return "fb" + FacebookSdk.getApplicationId() + "://authorize";
    }

    public String getSSODevice() {
        return null;
    }

    public abstract AccessTokenSource getTokenSource();

    public void onComplete(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        LoginClient.Result result;
        String str;
        this.e2e = null;
        if (bundle != null) {
            if (bundle.containsKey("e2e")) {
                this.e2e = bundle.getString("e2e");
            }
            try {
                AccessToken createAccessTokenFromWebBundle = LoginMethodHandler.createAccessTokenFromWebBundle(request.getPermissions(), bundle, getTokenSource(), request.getApplicationId());
                result = LoginClient.Result.createTokenResult(this.loginClient.getPendingRequest(), createAccessTokenFromWebBundle);
                CookieSyncManager.createInstance(this.loginClient.getActivity()).sync();
                saveCookieToken(createAccessTokenFromWebBundle.getToken());
            } catch (FacebookException e11) {
                result = LoginClient.Result.createErrorResult(this.loginClient.getPendingRequest(), (String) null, e11.getMessage());
            }
        } else if (facebookException instanceof FacebookOperationCanceledException) {
            result = LoginClient.Result.createCancelResult(this.loginClient.getPendingRequest(), "User canceled log in.");
        } else {
            this.e2e = null;
            String message = facebookException.getMessage();
            if (facebookException instanceof FacebookServiceException) {
                FacebookRequestError requestError = ((FacebookServiceException) facebookException).getRequestError();
                str = String.format(Locale.ROOT, TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(requestError.getErrorCode())});
                message = requestError.toString();
            } else {
                str = null;
            }
            result = LoginClient.Result.createErrorResult(this.loginClient.getPendingRequest(), (String) null, message, str);
        }
        if (!Utility.isNullOrEmpty(this.e2e)) {
            logWebLoginCompleted(this.e2e);
        }
        this.loginClient.completeAndValidate(result);
    }

    public WebLoginMethodHandler(Parcel parcel) {
        super(parcel);
    }
}
