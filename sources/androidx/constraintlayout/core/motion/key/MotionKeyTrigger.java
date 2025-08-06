package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.utils.FloatRect;
import java.lang.reflect.Method;
import java.util.HashMap;

public class MotionKeyTrigger extends MotionKey {

    /* renamed from: g  reason: collision with root package name */
    public int f6824g = -1;

    /* renamed from: h  reason: collision with root package name */
    public String f6825h = null;

    /* renamed from: i  reason: collision with root package name */
    public int f6826i;

    /* renamed from: j  reason: collision with root package name */
    public String f6827j;

    /* renamed from: k  reason: collision with root package name */
    public String f6828k;

    /* renamed from: l  reason: collision with root package name */
    public int f6829l;

    /* renamed from: m  reason: collision with root package name */
    public int f6830m;

    /* renamed from: n  reason: collision with root package name */
    public float f6831n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f6832o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f6833p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f6834q;

    /* renamed from: r  reason: collision with root package name */
    public float f6835r;

    /* renamed from: s  reason: collision with root package name */
    public float f6836s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f6837t;

    /* renamed from: u  reason: collision with root package name */
    public int f6838u;

    /* renamed from: v  reason: collision with root package name */
    public int f6839v;

    /* renamed from: w  reason: collision with root package name */
    public int f6840w;

    /* renamed from: x  reason: collision with root package name */
    public FloatRect f6841x;

    /* renamed from: y  reason: collision with root package name */
    public FloatRect f6842y;

    /* renamed from: z  reason: collision with root package name */
    public HashMap<String, Method> f6843z;

    public MotionKeyTrigger() {
        int i11 = MotionKey.f6752f;
        this.f6826i = i11;
        this.f6827j = null;
        this.f6828k = null;
        this.f6829l = i11;
        this.f6830m = i11;
        this.f6831n = 0.1f;
        this.f6832o = true;
        this.f6833p = true;
        this.f6834q = true;
        this.f6835r = Float.NaN;
        this.f6837t = false;
        this.f6838u = i11;
        this.f6839v = i11;
        this.f6840w = i11;
        this.f6841x = new FloatRect();
        this.f6842y = new FloatRect();
        this.f6843z = new HashMap<>();
        this.f6756d = 5;
        this.f6757e = new HashMap<>();
    }

    /* renamed from: a */
    public MotionKey clone() {
        return new MotionKeyTrigger().c(this);
    }

    public MotionKeyTrigger c(MotionKey motionKey) {
        super.b(motionKey);
        MotionKeyTrigger motionKeyTrigger = (MotionKeyTrigger) motionKey;
        this.f6824g = motionKeyTrigger.f6824g;
        this.f6825h = motionKeyTrigger.f6825h;
        this.f6826i = motionKeyTrigger.f6826i;
        this.f6827j = motionKeyTrigger.f6827j;
        this.f6828k = motionKeyTrigger.f6828k;
        this.f6829l = motionKeyTrigger.f6829l;
        this.f6830m = motionKeyTrigger.f6830m;
        this.f6831n = motionKeyTrigger.f6831n;
        this.f6832o = motionKeyTrigger.f6832o;
        this.f6833p = motionKeyTrigger.f6833p;
        this.f6834q = motionKeyTrigger.f6834q;
        this.f6835r = motionKeyTrigger.f6835r;
        this.f6836s = motionKeyTrigger.f6836s;
        this.f6837t = motionKeyTrigger.f6837t;
        this.f6841x = motionKeyTrigger.f6841x;
        this.f6842y = motionKeyTrigger.f6842y;
        this.f6843z = motionKeyTrigger.f6843z;
        return this;
    }
}
