package com.zopim.android.sdk.chatlog;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.api.ZopimChatApi;
import com.zopim.android.sdk.data.observers.ConnectionObserver;
import com.zopim.android.sdk.model.Connection;

public class ConnectionFragment extends Fragment {
    private static final String LOG_TAG = "ConnectionFragment";
    public ConnectionObserver mConnectionObserver = new ConnectionObserver() {
        public void update(final Connection connection) {
            ConnectionFragment.this.mHandler.post(new Runnable() {
                public void run() {
                    ConnectionFragment.this.updateConnection(connection);
                }
            });
        }
    };
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper());
    private ConnectionListener mListener;

    /* renamed from: com.zopim.android.sdk.chatlog.ConnectionFragment$2  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.zopim.android.sdk.chatlog.ConnectionFragment.AnonymousClass2.<clinit>():void");
        }
    }

    public interface ConnectionListener {
        void onConnected();

        void onDisconnected();
    }

    /* access modifiers changed from: private */
    public void updateConnection(Connection connection) {
        ConnectionListener connectionListener;
        if (connection == null) {
            Logger.l(LOG_TAG, "Connection must not be null. Can not update visibility.", new Object[0]);
            return;
        }
        int i11 = AnonymousClass2.$SwitchMap$com$zopim$android$sdk$model$Connection$Status[connection.getStatus().ordinal()];
        if (i11 == 1 || i11 == 2 || i11 == 3) {
            ConnectionListener connectionListener2 = this.mListener;
            if (connectionListener2 != null) {
                connectionListener2.onDisconnected();
            }
        } else if (i11 == 4 && (connectionListener = this.mListener) != null) {
            connectionListener.onConnected();
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ConnectionListener) {
            this.mListener = (ConnectionListener) activity;
        }
        if (getParentFragment() instanceof ConnectionListener) {
            this.mListener = (ConnectionListener) getParentFragment();
        }
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
        updateConnection(ZopimChatApi.getDataSource().getConnection());
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
