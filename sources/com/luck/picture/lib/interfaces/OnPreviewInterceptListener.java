package com.luck.picture.lib.interfaces;

import android.content.Context;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.ArrayList;

public interface OnPreviewInterceptListener {
    void onPreview(Context context, int i11, int i12, int i13, long j11, String str, boolean z11, ArrayList<LocalMedia> arrayList, boolean z12);
}
