package cn.sharesdk.framework.loopshare;

@Deprecated
public interface LoopShareResultListener<T> {
    void onError(Throwable th2);

    void onResult(T t11);
}
