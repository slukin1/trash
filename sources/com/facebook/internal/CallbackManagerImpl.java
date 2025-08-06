package com.facebook.internal;

import android.content.Intent;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.HashMap;
import java.util.Map;

public final class CallbackManagerImpl implements CallbackManager {
    private static final String TAG = "CallbackManagerImpl";
    private static Map<Integer, Callback> staticCallbacks = new HashMap();
    private Map<Integer, Callback> callbacks = new HashMap();

    public interface Callback {
        boolean onActivityResult(int i11, Intent intent);
    }

    public enum RequestCodeOffset {
        Login(0),
        Share(1),
        Message(2),
        Like(3),
        GameRequest(4),
        AppGroupCreate(5),
        AppGroupJoin(6),
        AppInvite(7),
        DeviceShare(8);
        
        private final int offset;

        private RequestCodeOffset(int i11) {
            this.offset = i11;
        }

        public int toRequestCode() {
            return FacebookSdk.getCallbackRequestCodeOffset() + this.offset;
        }
    }

    private static synchronized Callback getStaticCallback(Integer num) {
        Callback callback;
        synchronized (CallbackManagerImpl.class) {
            callback = staticCallbacks.get(num);
        }
        return callback;
    }

    public static synchronized void registerStaticCallback(int i11, Callback callback) {
        synchronized (CallbackManagerImpl.class) {
            Validate.notNull(callback, TUIConstants.TUIChat.CALL_BACK);
            if (!staticCallbacks.containsKey(Integer.valueOf(i11))) {
                staticCallbacks.put(Integer.valueOf(i11), callback);
            }
        }
    }

    private static boolean runStaticCallback(int i11, int i12, Intent intent) {
        Callback staticCallback = getStaticCallback(Integer.valueOf(i11));
        if (staticCallback != null) {
            return staticCallback.onActivityResult(i12, intent);
        }
        return false;
    }

    public boolean onActivityResult(int i11, int i12, Intent intent) {
        Callback callback = this.callbacks.get(Integer.valueOf(i11));
        if (callback != null) {
            return callback.onActivityResult(i12, intent);
        }
        return runStaticCallback(i11, i12, intent);
    }

    public void registerCallback(int i11, Callback callback) {
        Validate.notNull(callback, TUIConstants.TUIChat.CALL_BACK);
        this.callbacks.put(Integer.valueOf(i11), callback);
    }

    public void unregisterCallback(int i11) {
        this.callbacks.remove(Integer.valueOf(i11));
    }
}
