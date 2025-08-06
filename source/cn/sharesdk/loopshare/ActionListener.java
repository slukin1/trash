package cn.sharesdk.loopshare;

import com.mob.tools.proguard.EverythingKeeper;

public interface ActionListener<T> extends EverythingKeeper {
    void onError(Throwable th2);

    void onResult(T t11);
}
