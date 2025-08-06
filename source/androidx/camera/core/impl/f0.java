package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;
import java.util.Comparator;

public final /* synthetic */ class f0 implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ f0 f5565b = new f0();

    public final int compare(Object obj, Object obj2) {
        return ((Config.Option) obj).getId().compareTo(((Config.Option) obj2).getId());
    }
}
