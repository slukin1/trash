package com.tencent.thumbplayer.tcmedia.core.connection;

import android.content.Context;
import com.tencent.thumbplayer.tcmedia.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.tcmedia.core.player.TPNativePlayer;

public class TPNativePlayerConnectionMgr {
    private boolean mInited = false;
    private boolean mIsLibLoaded = false;
    private long mNativeContext = 0;

    public TPNativePlayerConnectionMgr() {
        try {
            TPNativeLibraryLoader.loadLibIfNeeded((Context) null);
            this.mIsLibLoaded = true;
        } catch (UnsupportedOperationException e11) {
            e11.printStackTrace();
            this.mIsLibLoaded = false;
        }
    }

    private native int _activeAllConnections();

    private native int _activeConnection(int i11);

    private native int _addConnection(Object obj, Object obj2, Object obj3, Object obj4);

    private native int _addConnectionWithAddr(long j11, Object obj, long j12, Object obj2);

    private native void _deactiveAllConnections();

    private native void _deactiveConnection(int i11);

    private native void _init();

    private native void _removeConnection(int i11);

    private native void _unInit();

    public int activeAllConnections() {
        if (!this.mIsLibLoaded) {
            throw new UnsupportedOperationException("Failed to load native library");
        } else if (this.mInited) {
            return _activeAllConnections();
        } else {
            throw new IllegalStateException("Failed to addConnection due to invalid state.");
        }
    }

    public int activeConnection(int i11) {
        if (!this.mIsLibLoaded) {
            throw new UnsupportedOperationException("Failed to load native library");
        } else if (this.mInited) {
            return _activeConnection(i11);
        } else {
            throw new IllegalStateException("Failed to addConnection due to invalid state.");
        }
    }

    public int addConnection(long j11, TPNativePlayerConnectionNode tPNativePlayerConnectionNode, long j12, TPNativePlayerConnectionNode tPNativePlayerConnectionNode2) {
        if (!this.mIsLibLoaded) {
            throw new UnsupportedOperationException("Failed to load native library");
        } else if (this.mInited) {
            return _addConnectionWithAddr(j11, tPNativePlayerConnectionNode, j12, tPNativePlayerConnectionNode2);
        } else {
            throw new IllegalStateException("Failed to addConnection due to invalid state.");
        }
    }

    public int addConnection(TPNativePlayer tPNativePlayer, TPNativePlayerConnectionNode tPNativePlayerConnectionNode, TPNativePlayer tPNativePlayer2, TPNativePlayerConnectionNode tPNativePlayerConnectionNode2) {
        if (!this.mIsLibLoaded) {
            throw new UnsupportedOperationException("Failed to load native library");
        } else if (this.mInited) {
            return _addConnection(tPNativePlayer, tPNativePlayerConnectionNode, tPNativePlayer2, tPNativePlayerConnectionNode2);
        } else {
            throw new IllegalStateException("Failed to addConnection due to invalid state.");
        }
    }

    public void deactiveAllConnections() {
        if (!this.mIsLibLoaded) {
            throw new UnsupportedOperationException("Failed to load native library");
        } else if (this.mInited) {
            _deactiveAllConnections();
        } else {
            throw new IllegalStateException("Failed to addConnection due to invalid state.");
        }
    }

    public void deactiveConnection(int i11) {
        if (!this.mIsLibLoaded) {
            throw new UnsupportedOperationException("Failed to load native library");
        } else if (this.mInited) {
            _deactiveConnection(i11);
        } else {
            throw new IllegalStateException("Failed to addConnection due to invalid state.");
        }
    }

    public void init() {
        if (!this.mIsLibLoaded) {
            throw new UnsupportedOperationException("Failed to load native library");
        } else if (!this.mInited) {
            this.mInited = true;
            _init();
        } else {
            throw new IllegalStateException("Failed to init due to invalid state.");
        }
    }

    public void removeConnection(int i11) {
        if (!this.mIsLibLoaded) {
            throw new UnsupportedOperationException("Failed to load native library");
        } else if (this.mInited) {
            _removeConnection(i11);
        } else {
            throw new IllegalStateException("Failed to addConnection due to invalid state.");
        }
    }

    public void unInit() {
        if (!this.mIsLibLoaded) {
            throw new UnsupportedOperationException("Failed to load native library");
        } else if (this.mInited) {
            this.mInited = false;
            _unInit();
        }
    }
}
