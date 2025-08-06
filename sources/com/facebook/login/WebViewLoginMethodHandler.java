package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.WebDialog;
import com.facebook.login.LoginClient;

class WebViewLoginMethodHandler extends WebLoginMethodHandler {
    public static final Parcelable.Creator<WebViewLoginMethodHandler> CREATOR = new Parcelable.Creator<WebViewLoginMethodHandler>() {
        public WebViewLoginMethodHandler createFromParcel(Parcel parcel) {
            return new WebViewLoginMethodHandler(parcel);
        }

        public WebViewLoginMethodHandler[] newArray(int i11) {
            return new WebViewLoginMethodHandler[i11];
        }
    };
    private String e2e;
    private WebDialog loginDialog;

    public static class AuthDialogBuilder extends WebDialog.Builder {
        private static final String OAUTH_DIALOG = "oauth";
        private String authType;
        private String e2e;
        private String redirect_uri = ServerProtocol.DIALOG_REDIRECT_URI;

        public AuthDialogBuilder(Context context, String str, Bundle bundle) {
            super(context, str, OAUTH_DIALOG, bundle);
        }

        public WebDialog build() {
            Bundle parameters = getParameters();
            parameters.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, this.redirect_uri);
            parameters.putString("client_id", getApplicationId());
            parameters.putString("e2e", this.e2e);
            parameters.putString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST);
            parameters.putString(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, "true");
            parameters.putString(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, this.authType);
            return WebDialog.newInstance(getContext(), OAUTH_DIALOG, parameters, getTheme(), getListener());
        }

        public AuthDialogBuilder setAuthType(String str) {
            this.authType = str;
            return this;
        }

        public AuthDialogBuilder setE2E(String str) {
            this.e2e = str;
            return this;
        }

        public AuthDialogBuilder setIsChromeOS(boolean z11) {
            this.redirect_uri = z11 ? ServerProtocol.DIALOG_REDIRECT_CHROME_OS_URI : ServerProtocol.DIALOG_REDIRECT_URI;
            return this;
        }

        public AuthDialogBuilder setIsRerequest(boolean z11) {
            return this;
        }
    }

    public WebViewLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    public void cancel() {
        WebDialog webDialog = this.loginDialog;
        if (webDialog != null) {
            webDialog.cancel();
            this.loginDialog = null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getNameForLogging() {
        return "web_view";
    }

    public AccessTokenSource getTokenSource() {
        return AccessTokenSource.WEB_VIEW;
    }

    public boolean needsInternetPermission() {
        return true;
    }

    public void onWebDialogComplete(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        super.onComplete(request, bundle, facebookException);
    }

    public boolean tryAuthorize(final LoginClient.Request request) {
        Bundle parameters = getParameters(request);
        AnonymousClass1 r12 = new WebDialog.OnCompleteListener() {
            public void onComplete(Bundle bundle, FacebookException facebookException) {
                WebViewLoginMethodHandler.this.onWebDialogComplete(request, bundle, facebookException);
            }
        };
        String e2e2 = LoginClient.getE2E();
        this.e2e = e2e2;
        addLoggingExtra("e2e", e2e2);
        FragmentActivity activity = this.loginClient.getActivity();
        this.loginDialog = new AuthDialogBuilder(activity, request.getApplicationId(), parameters).setE2E(this.e2e).setIsChromeOS(Utility.isChromeOS(activity)).setAuthType(request.getAuthType()).setOnCompleteListener(r12).build();
        FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
        facebookDialogFragment.setRetainInstance(true);
        facebookDialogFragment.setDialog(this.loginDialog);
        facebookDialogFragment.show(activity.getSupportFragmentManager(), FacebookDialogFragment.TAG);
        return true;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        super.writeToParcel(parcel, i11);
        parcel.writeString(this.e2e);
    }

    public WebViewLoginMethodHandler(Parcel parcel) {
        super(parcel);
        this.e2e = parcel.readString();
    }
}
