package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.common.R;
import com.facebook.login.LoginClient;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;

public class LoginFragment extends Fragment {
    public static final String EXTRA_REQUEST = "request";
    private static final String NULL_CALLING_PKG_ERROR_MSG = "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.";
    public static final String REQUEST_KEY = "com.facebook.LoginFragment:Request";
    public static final String RESULT_KEY = "com.facebook.LoginFragment:Result";
    private static final String SAVED_LOGIN_CLIENT = "loginClient";
    private static final String TAG = "LoginFragment";
    private String callingPackage;
    private LoginClient loginClient;
    private LoginClient.Request request;

    private void initializeCallingPackage(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity != null) {
            this.callingPackage = callingActivity.getPackageName();
        }
    }

    /* access modifiers changed from: private */
    public void onLoginClientCompleted(LoginClient.Result result) {
        this.request = null;
        int i11 = result.code == LoginClient.Result.Code.CANCEL ? 0 : -1;
        Bundle bundle = new Bundle();
        bundle.putParcelable(RESULT_KEY, result);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (isAdded()) {
            getActivity().setResult(i11, intent);
            getActivity().finish();
        }
    }

    public LoginClient createLoginClient() {
        return new LoginClient((Fragment) this);
    }

    public int getLayoutResId() {
        return R.layout.com_facebook_login_fragment;
    }

    public LoginClient getLoginClient() {
        return this.loginClient;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        this.loginClient.onActivityResult(i11, i12, intent);
    }

    public void onCreate(Bundle bundle) {
        Bundle bundleExtra;
        super.onCreate(bundle);
        if (bundle != null) {
            LoginClient loginClient2 = (LoginClient) bundle.getParcelable(SAVED_LOGIN_CLIENT);
            this.loginClient = loginClient2;
            loginClient2.setFragment(this);
        } else {
            this.loginClient = createLoginClient();
        }
        this.loginClient.setOnCompletedListener(new LoginClient.OnCompletedListener() {
            public void onCompleted(LoginClient.Result result) {
                LoginFragment.this.onLoginClientCompleted(result);
            }
        });
        FragmentActivity activity = getActivity();
        if (activity != null) {
            initializeCallingPackage(activity);
            Intent intent = activity.getIntent();
            if (intent != null && (bundleExtra = intent.getBundleExtra(REQUEST_KEY)) != null) {
                this.request = (LoginClient.Request) bundleExtra.getParcelable("request");
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(getLayoutResId(), viewGroup, false);
        final View findViewById = inflate.findViewById(R.id.com_facebook_login_fragment_progress_bar);
        this.loginClient.setBackgroundProcessingListener(new LoginClient.BackgroundProcessingListener() {
            public void onBackgroundProcessingStarted() {
                findViewById.setVisibility(0);
            }

            public void onBackgroundProcessingStopped() {
                findViewById.setVisibility(8);
            }
        });
        return inflate;
    }

    public void onDestroy() {
        this.loginClient.cancelCurrentHandler();
        super.onDestroy();
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        View view;
        super.onPause();
        if (getView() == null) {
            view = null;
        } else {
            view = getView().findViewById(R.id.com_facebook_login_fragment_progress_bar);
        }
        if (view != null) {
            view.setVisibility(8);
        }
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        if (this.callingPackage == null) {
            Log.e(TAG, NULL_CALLING_PKG_ERROR_MSG);
            getActivity().finish();
            FragmentTrackHelper.trackFragmentResume(this);
            return;
        }
        this.loginClient.startOrContinueAuth(this.request);
        FragmentTrackHelper.trackFragmentResume(this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(SAVED_LOGIN_CLIENT, this.loginClient);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }
}
