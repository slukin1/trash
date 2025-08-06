package androidx.constraintlayout.core.state;

public class Dimension {

    /* renamed from: i  reason: collision with root package name */
    public static final Object f7023i = new Object();

    /* renamed from: j  reason: collision with root package name */
    public static final Object f7024j = new Object();

    /* renamed from: k  reason: collision with root package name */
    public static final Object f7025k = new Object();

    /* renamed from: l  reason: collision with root package name */
    public static final Object f7026l = new Object();

    /* renamed from: m  reason: collision with root package name */
    public static final Object f7027m = new Object();

    /* renamed from: n  reason: collision with root package name */
    public static final Object f7028n = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final int f7029a = -2;

    /* renamed from: b  reason: collision with root package name */
    public int f7030b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f7031c = Integer.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public float f7032d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    public int f7033e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f7034f = null;

    /* renamed from: g  reason: collision with root package name */
    public Object f7035g = f7024j;

    /* renamed from: h  reason: collision with root package name */
    public boolean f7036h = false;

    public enum Type {
        FIXED,
        WRAP,
        MATCH_PARENT,
        MATCH_CONSTRAINT
    }

    public Dimension(Object obj) {
        this.f7035g = obj;
    }

    public static Dimension a(Object obj) {
        Dimension dimension = new Dimension(f7023i);
        dimension.b(obj);
        return dimension;
    }

    public Dimension b(Object obj) {
        this.f7035g = obj;
        if (obj instanceof Integer) {
            this.f7033e = ((Integer) obj).intValue();
            this.f7035g = null;
        }
        return this;
    }
}
