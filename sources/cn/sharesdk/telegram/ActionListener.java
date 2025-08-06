package cn.sharesdk.telegram;

import java.util.HashMap;

public interface ActionListener {
    void onComplete(HashMap<String, Object> hashMap);

    void onError(Throwable th2);

    void onStart(HashMap<String, Object> hashMap);
}
