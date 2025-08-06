package cn.sharesdk.framework.loopshare;

@Deprecated
public interface LoopSharePasswordListener<T> {
    void onError(Throwable th2);

    void onResult(T t11);
}
