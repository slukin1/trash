package zendesk.core;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import com.zendesk.logger.Logger;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mz.a;

class ZendeskNetworkInfoProvider implements NetworkInfoProvider, NetworkAware {
    private static final String LOG_TAG = "ZendeskNetworkInfoProvider";
    private final ConnectivityManager connectivityManager;
    private CurrentState currentState = null;
    private final Map<Integer, WeakReference<NetworkAware>> listeners = new HashMap();
    private ConnectivityManager.NetworkCallback networkCallback;
    private final Map<Integer, WeakReference<RetryAction>> retryActions = new HashMap();

    public enum CurrentState {
        CONNECTED,
        DISCONNECTED
    }

    public ZendeskNetworkInfoProvider(ConnectivityManager connectivityManager2) {
        this.connectivityManager = connectivityManager2;
    }

    private static boolean isConnectedOrConnecting(ConnectivityManager connectivityManager2) {
        NetworkInfo activeNetworkInfo = connectivityManager2.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    private void registerForNetworkCallbacks() {
        Logger.b(LOG_TAG, "Adding Lollipop network callbacks...", new Object[0]);
        final Handler handler = new Handler(Looper.getMainLooper());
        this.networkCallback = new ConnectivityManager.NetworkCallback() {
            public void onAvailable(Network network) {
                handler.post(new Runnable() {
                    public void run() {
                        ZendeskNetworkInfoProvider.this.onNetworkAvailable();
                    }
                });
            }

            public void onLost(Network network) {
                handler.post(new Runnable() {
                    public void run() {
                        ZendeskNetworkInfoProvider.this.onNetworkUnavailable();
                    }
                });
            }
        };
        this.connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), this.networkCallback);
    }

    private void unregisterForNetworkCallbacks() {
        ConnectivityManager.NetworkCallback networkCallback2 = this.networkCallback;
        if (networkCallback2 != null) {
            this.connectivityManager.unregisterNetworkCallback(networkCallback2);
            this.networkCallback = null;
        }
    }

    public void addNetworkAwareListener(Integer num, NetworkAware networkAware) {
        if (num != null && networkAware != null) {
            this.listeners.put(num, new WeakReference(networkAware));
        }
    }

    public void addRetryAction(Integer num, RetryAction retryAction) {
        if (num != null && retryAction != null) {
            this.retryActions.put(num, new WeakReference(retryAction));
        }
    }

    public void clearNetworkAwareListeners() {
        this.listeners.clear();
    }

    public void clearRetryActions() {
        this.retryActions.clear();
    }

    public boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void onNetworkAvailable() {
        CurrentState currentState2 = CurrentState.CONNECTED;
        if (currentState2 != this.currentState && isConnectedOrConnecting(this.connectivityManager)) {
            this.currentState = currentState2;
            Map<KeyT, ValueT> d11 = a.d(this.listeners);
            Map<KeyT, ValueT> d12 = a.d(this.retryActions);
            for (ValueT valuet : d11.values()) {
                if (valuet.get() != null) {
                    ((NetworkAware) valuet.get()).onNetworkAvailable();
                }
            }
            for (ValueT valuet2 : d12.values()) {
                if (valuet2.get() != null) {
                    ((RetryAction) valuet2.get()).onRetry();
                }
            }
            this.retryActions.clear();
        }
    }

    public void onNetworkUnavailable() {
        CurrentState currentState2 = CurrentState.DISCONNECTED;
        if (currentState2 != this.currentState && !isConnectedOrConnecting(this.connectivityManager)) {
            this.currentState = currentState2;
            for (ValueT valuet : a.d(this.listeners).values()) {
                if (valuet.get() != null) {
                    ((NetworkAware) valuet.get()).onNetworkUnavailable();
                }
            }
        }
    }

    public void register() {
        registerForNetworkCallbacks();
    }

    public void removeNetworkAwareListener(Integer num) {
        this.listeners.remove(num);
    }

    public void removeRetryAction(Integer num) {
        this.retryActions.remove(num);
    }

    public void unregister() {
        unregisterForNetworkCallbacks();
    }
}
