package com.zopim.android.sdk.chatlog;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.snackbar.Snackbar;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.R;
import com.zopim.android.sdk.api.ZopimChatApi;
import com.zopim.android.sdk.chatlog.view.SnackbarAdapter;
import com.zopim.android.sdk.data.observers.ConnectionObserver;
import com.zopim.android.sdk.model.Connection;

public class ConnectionToastFragment extends Fragment {
    private static final String LOG_TAG = "ConnectionToastFragment";
    public ConnectionObserver mConnectionObserver = new ConnectionObserver() {
        public void update(final Connection connection) {
            ConnectionToastFragment.this.mHandler.post(new Runnable() {
                public void run() {
                    ConnectionToastFragment.this.updateToastView(connection);
                }
            });
        }
    };
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper());
    private Snackbar mSnackbar;
    private ToastListener mToastListener;

    /* renamed from: com.zopim.android.sdk.chatlog.ConnectionToastFragment$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$zopim$android$sdk$model$Connection$Status;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.zopim.android.sdk.model.Connection$Status[] r0 = com.zopim.android.sdk.model.Connection.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$zopim$android$sdk$model$Connection$Status = r0
                com.zopim.android.sdk.model.Connection$Status r1 = com.zopim.android.sdk.model.Connection.Status.NO_CONNECTION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$Connection$Status     // Catch:{ NoSuchFieldError -> 0x001d }
                com.zopim.android.sdk.model.Connection$Status r1 = com.zopim.android.sdk.model.Connection.Status.CONNECTING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$Connection$Status     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.zopim.android.sdk.model.Connection$Status r1 = com.zopim.android.sdk.model.Connection.Status.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$Connection$Status     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.zopim.android.sdk.model.Connection$Status r1 = com.zopim.android.sdk.model.Connection.Status.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zopim.android.sdk.chatlog.ConnectionToastFragment.AnonymousClass2.<clinit>():void");
        }
    }

    public interface ToastListener {
        void onHideToast();

        void onShowToast();
    }

    /* access modifiers changed from: private */
    public void updateToastView(Connection connection) {
        Snackbar snackbar;
        if (connection == null) {
            Logger.l(LOG_TAG, "Connection must not be null. Can not update visibility.", new Object[0]);
        } else if (getParentFragment() == null || getParentFragment().getView() != null) {
            int i11 = AnonymousClass2.$SwitchMap$com$zopim$android$sdk$model$Connection$Status[connection.getStatus().ordinal()];
            if (i11 == 1) {
                Snackbar snackbar2 = this.mSnackbar;
                if (snackbar2 == null) {
                    Snackbar make = SnackbarAdapter.make(getParentFragment().getView(), R.string.no_connectivity_toast_message, -2);
                    this.mSnackbar = make;
                    make.show();
                } else {
                    snackbar2.setText(R.string.no_connectivity_toast_message);
                }
                ToastListener toastListener = this.mToastListener;
                if (toastListener != null) {
                    toastListener.onShowToast();
                }
            } else if (i11 == 2) {
                Snackbar snackbar3 = this.mSnackbar;
                if (snackbar3 == null) {
                    Snackbar make2 = SnackbarAdapter.make(getParentFragment().getView(), R.string.reconnecting_toast_message, -2);
                    this.mSnackbar = make2;
                    make2.show();
                } else {
                    snackbar3.setText(R.string.reconnecting_toast_message);
                }
                ToastListener toastListener2 = this.mToastListener;
                if (toastListener2 != null) {
                    toastListener2.onShowToast();
                }
            } else if (i11 == 3) {
                Snackbar snackbar4 = this.mSnackbar;
                if (snackbar4 == null) {
                    Snackbar make3 = SnackbarAdapter.make(getParentFragment().getView(), R.string.no_connectivity_toast_message, -2);
                    this.mSnackbar = make3;
                    make3.show();
                } else {
                    snackbar4.setText(R.string.no_connectivity_toast_message);
                }
                ToastListener toastListener3 = this.mToastListener;
                if (toastListener3 != null) {
                    toastListener3.onShowToast();
                }
            } else if (i11 == 4 && (snackbar = this.mSnackbar) != null) {
                snackbar.dismiss();
                this.mSnackbar = null;
            }
        } else {
            Logger.l(LOG_TAG, "Can not show connection toast", new Object[0]);
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ToastListener) {
            this.mToastListener = (ToastListener) activity;
        }
        if (getParentFragment() instanceof ToastListener) {
            this.mToastListener = (ToastListener) getParentFragment();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            FragmentTransaction q11 = getChildFragmentManager().q();
            q11.e(new ConnectionFragment(), ConnectionFragment.class.getName());
            q11.j();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    public void onStart() {
        super.onStart();
        updateToastView(ZopimChatApi.getDataSource().getConnection());
        ZopimChatApi.getDataSource().addConnectionObserver(this.mConnectionObserver);
    }

    public void onStop() {
        super.onStop();
        ZopimChatApi.getDataSource().deleteConnectionObserver(this.mConnectionObserver);
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
