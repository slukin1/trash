package androidx.constraintlayout.core.motion.key;

public class MotionKeyPosition extends MotionKey {

    /* renamed from: g  reason: collision with root package name */
    public int f6793g;

    /* renamed from: h  reason: collision with root package name */
    public String f6794h = null;

    /* renamed from: i  reason: collision with root package name */
    public int f6795i;

    /* renamed from: j  reason: collision with root package name */
    public int f6796j;

    /* renamed from: k  reason: collision with root package name */
    public float f6797k;

    /* renamed from: l  reason: collision with root package name */
    public float f6798l;

    /* renamed from: m  reason: collision with root package name */
    public float f6799m;

    /* renamed from: n  reason: collision with root package name */
    public float f6800n;

    /* renamed from: o  reason: collision with root package name */
    public float f6801o;

    /* renamed from: p  reason: collision with root package name */
    public float f6802p;

    /* renamed from: q  reason: collision with root package name */
    public int f6803q;

    /* renamed from: r  reason: collision with root package name */
    public float f6804r;

    /* renamed from: s  reason: collision with root package name */
    public float f6805s;

    public MotionKeyPosition() {
        int i11 = MotionKey.f6752f;
        this.f6793g = i11;
        this.f6795i = i11;
        this.f6796j = 0;
        this.f6797k = Float.NaN;
        this.f6798l = Float.NaN;
        this.f6799m = Float.NaN;
        this.f6800n = Float.NaN;
        this.f6801o = Float.NaN;
        this.f6802p = Float.NaN;
        this.f6803q = 0;
        this.f6804r = Float.NaN;
        this.f6805s = Float.NaN;
        this.f6756d = 2;
    }

    /* renamed from: a */
    public MotionKey clone() {
        return new MotionKeyPosition().b(this);
    }

    public MotionKey b(MotionKey motionKey) {
        super.b(motionKey);
        MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
        this.f6794h = motionKeyPosition.f6794h;
        this.f6795i = motionKeyPosition.f6795i;
        this.f6796j = motionKeyPosition.f6796j;
        this.f6797k = motionKeyPosition.f6797k;
        this.f6798l = Float.NaN;
        this.f6799m = motionKeyPosition.f6799m;
        this.f6800n = motionKeyPosition.f6800n;
        this.f6801o = motionKeyPosition.f6801o;
        this.f6802p = motionKeyPosition.f6802p;
        this.f6804r = motionKeyPosition.f6804r;
        this.f6805s = motionKeyPosition.f6805s;
        return this;
    }
}
