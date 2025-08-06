package org.bouncycastle.math.ec;

public interface ECLookupTable {
    int getSize();

    ECPoint lookup(int i11);

    ECPoint lookupVar(int i11);
}
