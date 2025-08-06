package com.luck.picture.lib.interfaces;

import android.content.Context;
import com.luck.picture.lib.entity.LocalMedia;

public interface OnExternalPreviewEventListener {
    boolean onLongPressDownload(Context context, LocalMedia localMedia);

    void onPreviewDelete(int i11);
}
