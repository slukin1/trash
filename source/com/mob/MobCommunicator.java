package com.mob;

import com.mob.tools.network.NetCommunicator;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;

@Deprecated
public final class MobCommunicator implements PublicMemberKeeper {

    /* renamed from: a  reason: collision with root package name */
    private NetCommunicator f26829a;

    public static class Callback<T> implements PublicMemberKeeper {
        public void onResultError(Throwable th2) {
        }

        public void onResultOk(T t11) {
        }
    }

    public static class NetworkError extends Exception implements PublicMemberKeeper {
        private static final long serialVersionUID = -8447657431687664787L;

        public NetworkError(String str) {
            super(str);
        }
    }

    public MobCommunicator(int i11, String str, String str2) {
        this.f26829a = new NetCommunicator(i11, str, str2);
    }

    public static HashMap<String, String> getCommonDefaultHeaders() throws Throwable {
        return NetCommunicator.getCommonDefaultHeaders();
    }

    public <T> void request(HashMap<String, Object> hashMap, String str, boolean z11, Callback<T> callback) {
        request(true, (HashMap<String, String>) null, hashMap, str, z11, callback);
    }

    public <T> T requestSynchronized(HashMap<String, Object> hashMap, String str, boolean z11) throws Throwable {
        return requestSynchronized((HashMap<String, String>) null, hashMap, str, z11);
    }

    public void setThreadPool(ThreadPoolExecutor threadPoolExecutor) {
        this.f26829a.setThreadPool(threadPoolExecutor);
    }

    public <T> void request(HashMap<String, String> hashMap, HashMap<String, Object> hashMap2, String str, boolean z11, Callback<T> callback) {
        request(true, hashMap, hashMap2, str, z11, callback);
    }

    public <T> T requestSynchronized(HashMap<String, String> hashMap, HashMap<String, Object> hashMap2, String str, boolean z11) throws Throwable {
        return requestSynchronized(true, hashMap, hashMap2, str, z11);
    }

    public <T> void request(boolean z11, HashMap<String, String> hashMap, HashMap<String, Object> hashMap2, String str, boolean z12, Callback<T> callback) {
        final Callback<T> callback2 = callback;
        if (callback2 == null) {
            this.f26829a.request(z11, hashMap, hashMap2, str, z12, (NetCommunicator.Callback) null);
            return;
        }
        this.f26829a.request(z11, hashMap, hashMap2, str, z12, new NetCommunicator.Callback<T>() {
            public void onResultError(Throwable th2) {
                callback2.onResultError(th2);
            }

            public void onResultOk(T t11) {
                callback2.onResultOk(t11);
            }
        });
    }

    public <T> T requestSynchronized(String str, String str2, boolean z11) throws Throwable {
        return requestSynchronized((HashMap<String, String>) null, str, str2, z11);
    }

    public <T> T requestSynchronized(HashMap<String, String> hashMap, String str, String str2, boolean z11) throws Throwable {
        return requestSynchronized(true, hashMap, str, str2, z11);
    }

    public <T> T requestSynchronized(boolean z11, HashMap<String, String> hashMap, HashMap<String, Object> hashMap2, String str, boolean z12) throws Throwable {
        return this.f26829a.requestSynchronized(z11, hashMap, hashMap2, str, z12);
    }

    public <T> T requestSynchronized(boolean z11, HashMap<String, String> hashMap, String str, String str2, boolean z12) throws Throwable {
        return this.f26829a.requestSynchronized(z11, hashMap, str, str2, z12);
    }
}
