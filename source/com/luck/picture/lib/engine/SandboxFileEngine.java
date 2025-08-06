package com.luck.picture.lib.engine;

import android.content.Context;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnCallbackIndexListener;

@Deprecated
public interface SandboxFileEngine {
    void onStartSandboxFileTransform(Context context, boolean z11, int i11, LocalMedia localMedia, OnCallbackIndexListener<LocalMedia> onCallbackIndexListener);
}
