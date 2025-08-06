package org.bouncycastle.crypto.params;

public class GOST3410ValidationParameters {

    /* renamed from: c  reason: collision with root package name */
    private int f59289c;
    private long cL;

    /* renamed from: x0  reason: collision with root package name */
    private int f59290x0;
    private long x0L;

    public GOST3410ValidationParameters(int i11, int i12) {
        this.f59290x0 = i11;
        this.f59289c = i12;
    }

    public GOST3410ValidationParameters(long j11, long j12) {
        this.x0L = j11;
        this.cL = j12;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410ValidationParameters)) {
            return false;
        }
        GOST3410ValidationParameters gOST3410ValidationParameters = (GOST3410ValidationParameters) obj;
        return gOST3410ValidationParameters.f59289c == this.f59289c && gOST3410ValidationParameters.f59290x0 == this.f59290x0 && gOST3410ValidationParameters.cL == this.cL && gOST3410ValidationParameters.x0L == this.x0L;
    }

    public int getC() {
        return this.f59289c;
    }

    public long getCL() {
        return this.cL;
    }

    public int getX0() {
        return this.f59290x0;
    }

    public long getX0L() {
        return this.x0L;
    }

    public int hashCode() {
        int i11 = this.f59290x0 ^ this.f59289c;
        long j11 = this.x0L;
        int i12 = (i11 ^ ((int) j11)) ^ ((int) (j11 >> 32));
        long j12 = this.cL;
        return (i12 ^ ((int) j12)) ^ ((int) (j12 >> 32));
    }
}
