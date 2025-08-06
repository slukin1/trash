package cn.sharesdk.framework;

import java.util.HashMap;

public interface PlatformActionListener {
    void onCancel(Platform platform, int i11);

    void onComplete(Platform platform, int i11, HashMap<String, Object> hashMap);

    void onError(Platform platform, int i11, Throwable th2);
}
