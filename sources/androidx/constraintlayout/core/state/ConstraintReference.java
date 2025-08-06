package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.state.State;
import java.util.ArrayList;
import java.util.HashMap;
import k0.a;

public class ConstraintReference {
    public float A = Float.NaN;
    public float B = Float.NaN;
    public float C = Float.NaN;
    public float D = Float.NaN;
    public int E = 0;
    public Object F = null;
    public Object G = null;
    public Object H = null;
    public Object I = null;
    public Object J = null;
    public Object K = null;
    public Object L = null;
    public Object M = null;
    public Object N = null;
    public Object O = null;
    public Object P = null;
    public Object Q = null;
    public Object R = null;
    public Object S = null;
    public State.Constraint T = null;
    public Dimension U;
    public Dimension V;
    public HashMap<String, Integer> W;
    public HashMap<String, Float> X;

    /* renamed from: a  reason: collision with root package name */
    public final State f6997a;

    /* renamed from: b  reason: collision with root package name */
    public String f6998b = null;

    /* renamed from: c  reason: collision with root package name */
    public a f6999c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f7000d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f7001e = 0;

    /* renamed from: f  reason: collision with root package name */
    public float f7002f = 0.5f;

    /* renamed from: g  reason: collision with root package name */
    public float f7003g = 0.5f;

    /* renamed from: h  reason: collision with root package name */
    public int f7004h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f7005i = 0;

    /* renamed from: j  reason: collision with root package name */
    public int f7006j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f7007k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f7008l = 0;

    /* renamed from: m  reason: collision with root package name */
    public int f7009m = 0;

    /* renamed from: n  reason: collision with root package name */
    public int f7010n = 0;

    /* renamed from: o  reason: collision with root package name */
    public int f7011o = 0;

    /* renamed from: p  reason: collision with root package name */
    public int f7012p = 0;

    /* renamed from: q  reason: collision with root package name */
    public int f7013q = 0;

    /* renamed from: r  reason: collision with root package name */
    public int f7014r = 0;

    /* renamed from: s  reason: collision with root package name */
    public int f7015s = 0;

    /* renamed from: t  reason: collision with root package name */
    public float f7016t = Float.NaN;

    /* renamed from: u  reason: collision with root package name */
    public float f7017u = Float.NaN;

    /* renamed from: v  reason: collision with root package name */
    public float f7018v = Float.NaN;

    /* renamed from: w  reason: collision with root package name */
    public float f7019w = Float.NaN;

    /* renamed from: x  reason: collision with root package name */
    public float f7020x = Float.NaN;

    /* renamed from: y  reason: collision with root package name */
    public float f7021y = Float.NaN;

    /* renamed from: z  reason: collision with root package name */
    public float f7022z = Float.NaN;

    public static class IncorrectConstraintException extends Exception {
        private final ArrayList<String> mErrors;

        public IncorrectConstraintException(ArrayList<String> arrayList) {
            this.mErrors = arrayList;
        }

        public ArrayList<String> getErrors() {
            return this.mErrors;
        }

        public String toString() {
            return "IncorrectConstraintException: " + this.mErrors.toString();
        }
    }

    public ConstraintReference(State state) {
        Object obj = Dimension.f7024j;
        this.U = Dimension.a(obj);
        this.V = Dimension.a(obj);
        this.W = new HashMap<>();
        this.X = new HashMap<>();
        this.f6997a = state;
    }
}
