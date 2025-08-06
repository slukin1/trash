package androidx.constraintlayout.core;

import java.util.Arrays;
import java.util.HashSet;

public class SolverVariable implements Comparable<SolverVariable> {

    /* renamed from: s  reason: collision with root package name */
    public static int f6604s = 1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6605b;

    /* renamed from: c  reason: collision with root package name */
    public String f6606c;

    /* renamed from: d  reason: collision with root package name */
    public int f6607d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f6608e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f6609f = 0;

    /* renamed from: g  reason: collision with root package name */
    public float f6610g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6611h = false;

    /* renamed from: i  reason: collision with root package name */
    public float[] f6612i = new float[9];

    /* renamed from: j  reason: collision with root package name */
    public float[] f6613j = new float[9];

    /* renamed from: k  reason: collision with root package name */
    public Type f6614k;

    /* renamed from: l  reason: collision with root package name */
    public ArrayRow[] f6615l = new ArrayRow[16];

    /* renamed from: m  reason: collision with root package name */
    public int f6616m = 0;

    /* renamed from: n  reason: collision with root package name */
    public int f6617n = 0;

    /* renamed from: o  reason: collision with root package name */
    public boolean f6618o = false;

    /* renamed from: p  reason: collision with root package name */
    public int f6619p = -1;

    /* renamed from: q  reason: collision with root package name */
    public float f6620q = 0.0f;

    /* renamed from: r  reason: collision with root package name */
    public HashSet<ArrayRow> f6621r = null;

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type, String str) {
        this.f6614k = type;
    }

    public static void c() {
        f6604s++;
    }

    public final void a(ArrayRow arrayRow) {
        int i11 = 0;
        while (true) {
            int i12 = this.f6616m;
            if (i11 >= i12) {
                ArrayRow[] arrayRowArr = this.f6615l;
                if (i12 >= arrayRowArr.length) {
                    this.f6615l = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.f6615l;
                int i13 = this.f6616m;
                arrayRowArr2[i13] = arrayRow;
                this.f6616m = i13 + 1;
                return;
            } else if (this.f6615l[i11] != arrayRow) {
                i11++;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    public int compareTo(SolverVariable solverVariable) {
        return this.f6607d - solverVariable.f6607d;
    }

    public final void e(ArrayRow arrayRow) {
        int i11 = this.f6616m;
        int i12 = 0;
        while (i12 < i11) {
            if (this.f6615l[i12] == arrayRow) {
                while (i12 < i11 - 1) {
                    ArrayRow[] arrayRowArr = this.f6615l;
                    int i13 = i12 + 1;
                    arrayRowArr[i12] = arrayRowArr[i13];
                    i12 = i13;
                }
                this.f6616m--;
                return;
            }
            i12++;
        }
    }

    public void f() {
        this.f6606c = null;
        this.f6614k = Type.UNKNOWN;
        this.f6609f = 0;
        this.f6607d = -1;
        this.f6608e = -1;
        this.f6610g = 0.0f;
        this.f6611h = false;
        this.f6618o = false;
        this.f6619p = -1;
        this.f6620q = 0.0f;
        int i11 = this.f6616m;
        for (int i12 = 0; i12 < i11; i12++) {
            this.f6615l[i12] = null;
        }
        this.f6616m = 0;
        this.f6617n = 0;
        this.f6605b = false;
        Arrays.fill(this.f6613j, 0.0f);
    }

    public void g(LinearSystem linearSystem, float f11) {
        this.f6610g = f11;
        this.f6611h = true;
        this.f6618o = false;
        this.f6619p = -1;
        this.f6620q = 0.0f;
        int i11 = this.f6616m;
        this.f6608e = -1;
        for (int i12 = 0; i12 < i11; i12++) {
            this.f6615l[i12].A(linearSystem, this, false);
        }
        this.f6616m = 0;
    }

    public void h(Type type, String str) {
        this.f6614k = type;
    }

    public final void i(LinearSystem linearSystem, ArrayRow arrayRow) {
        int i11 = this.f6616m;
        for (int i12 = 0; i12 < i11; i12++) {
            this.f6615l[i12].B(linearSystem, arrayRow, false);
        }
        this.f6616m = 0;
    }

    public String toString() {
        if (this.f6606c != null) {
            return "" + this.f6606c;
        }
        return "" + this.f6607d;
    }
}
