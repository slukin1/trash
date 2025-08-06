package com.mob;

import com.mob.tools.proguard.PublicMemberKeeper;

@Deprecated
public abstract class OperationCallback<T> implements PublicMemberKeeper {
    public abstract void onComplete(T t11);

    public abstract void onFailure(Throwable th2);
}
