package org.bouncycastle.math.ec;

public abstract class AbstractECLookupTable implements ECLookupTable {
    public ECPoint lookupVar(int i11) {
        return lookup(i11);
    }
}
