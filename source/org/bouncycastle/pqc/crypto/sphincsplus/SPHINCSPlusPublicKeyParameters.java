package org.bouncycastle.pqc.crypto.sphincsplus;

import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class SPHINCSPlusPublicKeyParameters extends SPHINCSPlusKeyParameters {

    /* renamed from: pk  reason: collision with root package name */
    private final PK f59612pk;

    public SPHINCSPlusPublicKeyParameters(SPHINCSPlusParameters sPHINCSPlusParameters, PK pk2) {
        super(false, sPHINCSPlusParameters);
        this.f59612pk = pk2;
    }

    public SPHINCSPlusPublicKeyParameters(SPHINCSPlusParameters sPHINCSPlusParameters, byte[] bArr) {
        super(false, sPHINCSPlusParameters);
        int i11 = sPHINCSPlusParameters.getEngine().N;
        int i12 = i11 * 2;
        if (bArr.length == i12) {
            this.f59612pk = new PK(Arrays.copyOfRange(bArr, 0, i11), Arrays.copyOfRange(bArr, i11, i12));
            return;
        }
        throw new IllegalArgumentException("public key encoding does not match parameters");
    }

    public byte[] getEncoded() {
        byte[] intToBigEndian = Pack.intToBigEndian(SPHINCSPlusParameters.getID(getParameters()).intValue());
        PK pk2 = this.f59612pk;
        return Arrays.concatenate(intToBigEndian, pk2.seed, pk2.root);
    }

    public byte[] getRoot() {
        return Arrays.clone(this.f59612pk.root);
    }

    public byte[] getSeed() {
        return Arrays.clone(this.f59612pk.seed);
    }
}
