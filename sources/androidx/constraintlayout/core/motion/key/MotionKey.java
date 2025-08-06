package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.a;
import java.util.HashMap;

public abstract class MotionKey {

    /* renamed from: f  reason: collision with root package name */
    public static int f6752f = -1;

    /* renamed from: a  reason: collision with root package name */
    public int f6753a;

    /* renamed from: b  reason: collision with root package name */
    public int f6754b;

    /* renamed from: c  reason: collision with root package name */
    public String f6755c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f6756d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, a> f6757e;

    public MotionKey() {
        int i11 = f6752f;
        this.f6753a = i11;
        this.f6754b = i11;
    }

    /* renamed from: a */
    public abstract MotionKey clone();

    public MotionKey b(MotionKey motionKey) {
        this.f6753a = motionKey.f6753a;
        this.f6754b = motionKey.f6754b;
        this.f6755c = motionKey.f6755c;
        this.f6756d = motionKey.f6756d;
        return this;
    }
}
