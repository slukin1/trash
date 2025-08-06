package com.luck.picture.lib.engine;

import android.content.Context;
import com.luck.picture.lib.interfaces.OnKeyValueResultCallbackListener;

public interface UriToFileTransformEngine {
    void onUriToFileAsyncTransform(Context context, String str, String str2, OnKeyValueResultCallbackListener onKeyValueResultCallbackListener);
}
