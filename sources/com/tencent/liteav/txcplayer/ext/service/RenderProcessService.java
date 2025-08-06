package com.tencent.liteav.txcplayer.ext.service;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.sdk.common.LicenseChecker;
import com.tencent.liteav.txcplayer.ITXVCubePlayer;
import com.tencent.liteav.txcplayer.common.c;
import com.tencent.liteav.txcplayer.ext.host.EngineConst;
import com.tencent.liteav.txcplayer.ext.host.HostEngine;
import java.util.HashMap;
import java.util.Map;

public class RenderProcessService {
    private static final String TAG = "HostEngine-RenderProcessService";
    private static RenderProcessService mInstance;
    private int mCurrentModel = 0;
    private boolean mEnableRenderProcess = true;

    private RenderProcessService() {
    }

    public static RenderProcessService getInstance() {
        if (mInstance == null) {
            synchronized (RenderProcessService.class) {
                if (mInstance == null) {
                    mInstance = new RenderProcessService();
                }
            }
        }
        return mInstance;
    }

    public boolean canRenderProcessWork() {
        if (!isEnableRenderProcess()) {
            LiteavLog.i(TAG, "[canRenderProcessWork],isEnableRenderProcess == false !!!");
            return false;
        } else if (!HostEngine.getInstance().checkAndLoadPlugin(2)) {
            LiteavLog.i(TAG, "[canRenderProcessWork],isEnableRenderProcess == false !!!");
            return false;
        } else {
            int i11 = this.mCurrentModel;
            if (i11 == 1 || i11 == 2) {
                HashMap hashMap = new HashMap();
                HostEngine.getInstance().sendSyncRequestToPlugin(2, 104, (Map<String, Object>) null, hashMap);
                Object obj = hashMap.get("KEY_RET_PARAM1");
                if (!((obj == null || !(obj instanceof Boolean)) ? false : ((Boolean) obj).booleanValue())) {
                    LiteavLog.i(TAG, "[canRenderProcessWork],IS_SUPPORT_RESOLUTION == false !!!");
                    return false;
                }
            }
            LiteavLog.i(TAG, "[canRenderProcessWork], finally return true");
            return true;
        }
    }

    public void checkInit(Context context) {
        HostEngine.getInstance().init(context);
    }

    public boolean connectPlayer(ITXVCubePlayer iTXVCubePlayer, Surface surface) {
        if (iTXVCubePlayer == null || surface == null) {
            LiteavLog.w(TAG, "connectPlayer invalid param player or surface is null !!!");
            return false;
        } else if (!canRenderProcessWork()) {
            LiteavLog.w(TAG, "connectPlayer，postProcessService does not need to work");
            return false;
        } else {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap.put(EngineConst.ArgsKey.KEY_PARAM1, iTXVCubePlayer);
            hashMap.put(EngineConst.ArgsKey.KEY_PARAM2, surface);
            HostEngine.getInstance().sendSyncRequestToPlugin(2, 100, hashMap, hashMap2);
            Boolean bool = Boolean.FALSE;
            Object obj = hashMap2.get("KEY_RET_PARAM1");
            if (obj != null && (obj instanceof Boolean)) {
                bool = (Boolean) obj;
            }
            return bool.booleanValue();
        }
    }

    public int getVodLicenseFeature() {
        if (HostEngine.getInstance().getAppContext() == null) {
            LiteavLog.w(TAG, "Host engine not init!!");
            return 0;
        }
        boolean z11 = c.b(LicenseChecker.a.PLAYER_MONET) == LicenseChecker.d.OK;
        LiteavLog.i("VodLicenseCheck", "checkValidForPlayerMonet = ".concat(String.valueOf(z11)));
        if (z11) {
            return 1;
        }
        return 0;
    }

    public boolean isEnableRenderProcess() {
        return this.mEnableRenderProcess;
    }

    public boolean onTouchEvent(ITXVCubePlayer iTXVCubePlayer, MotionEvent motionEvent) {
        if (!canRenderProcessWork()) {
            return false;
        }
        int i11 = this.mCurrentModel;
        if (i11 != 11 && i11 != 12) {
            return false;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put(EngineConst.ArgsKey.KEY_PARAM1, iTXVCubePlayer);
        hashMap.put(EngineConst.ArgsKey.KEY_PARAM2, motionEvent);
        HostEngine.getInstance().sendSyncRequestToPlugin(2, 105, hashMap, hashMap2);
        Object obj = hashMap2.get("KEY_RET_PARAM1");
        if (obj == null || !(obj instanceof Boolean)) {
            return false;
        }
        return ((Boolean) obj).booleanValue();
    }

    public void sendPlayerEventToPlugin(ITXVCubePlayer iTXVCubePlayer, int i11, Bundle bundle) {
        if (canRenderProcessWork()) {
            if (iTXVCubePlayer == null) {
                LiteavLog.w(TAG, "sendPlayerEventToPlugin invalid param player is null !!!");
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(EngineConst.ArgsKey.KEY_PARAM1, iTXVCubePlayer);
            hashMap.put(EngineConst.ArgsKey.KEY_PARAM2, Integer.valueOf(i11));
            hashMap.put(EngineConst.ArgsKey.KEY_PARAM3, bundle);
            HostEngine.getInstance().sendSyncRequestToPlugin(2, 106, hashMap, (Map<String, Object>) null);
        }
    }

    public void setEnableRenderProcess(boolean z11) {
        LiteavLog.d(TAG, "setEnableRenderProcess: ".concat(String.valueOf(z11)));
        this.mEnableRenderProcess = z11;
    }

    public boolean setSurfaceBufferSize(ITXVCubePlayer iTXVCubePlayer) {
        if (iTXVCubePlayer == null) {
            LiteavLog.w(TAG, "setSurfaceBufferSize invalid param player is null !!!");
            return false;
        } else if (!canRenderProcessWork()) {
            LiteavLog.w(TAG, "setSurfaceBufferSize，postProcessService does not need to work");
            return false;
        } else {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap.put(EngineConst.ArgsKey.KEY_PARAM1, iTXVCubePlayer);
            HostEngine.getInstance().sendSyncRequestToPlugin(2, 101, hashMap, hashMap2);
            Boolean bool = Boolean.FALSE;
            Object obj = hashMap2.get("KEY_RET_PARAM1");
            if (obj != null && (obj instanceof Boolean)) {
                bool = (Boolean) obj;
            }
            return bool.booleanValue();
        }
    }

    public void stopRenderProcess(ITXVCubePlayer iTXVCubePlayer) {
        if (canRenderProcessWork()) {
            if (iTXVCubePlayer == null) {
                LiteavLog.w(TAG, "stopRenderProcess invalid param player is null !!!");
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(EngineConst.ArgsKey.KEY_PARAM1, iTXVCubePlayer);
            HostEngine.getInstance().sendSyncRequestToPlugin(2, 103, hashMap, (Map<String, Object>) null);
        }
    }

    public void updateRenderProcessMode(ITXVCubePlayer iTXVCubePlayer, int i11) {
        this.mCurrentModel = i11;
        if (!canRenderProcessWork()) {
            LiteavLog.w(TAG, "updatePostProcessMode，postProcessService does not need to work");
        } else if (iTXVCubePlayer == null) {
            LiteavLog.w(TAG, "updatePostProcessMode invalid param player is null !!!");
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put(EngineConst.ArgsKey.KEY_PARAM1, iTXVCubePlayer);
            hashMap.put(EngineConst.ArgsKey.KEY_PARAM2, Integer.valueOf(i11));
            HostEngine.getInstance().sendSyncRequestToPlugin(2, 102, hashMap, (Map<String, Object>) null);
        }
    }
}
