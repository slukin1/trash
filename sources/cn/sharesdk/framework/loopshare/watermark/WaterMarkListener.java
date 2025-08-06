package cn.sharesdk.framework.loopshare.watermark;

@Deprecated
public interface WaterMarkListener {
    void onCancel();

    void onEnd(int i11);

    void onFailed(String str, int i11);

    void onProgress(int i11);

    void onStart();
}
