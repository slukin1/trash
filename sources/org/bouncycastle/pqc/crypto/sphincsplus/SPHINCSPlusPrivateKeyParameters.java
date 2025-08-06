package org.bouncycastle.pqc.crypto.sphincsplus;

import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class SPHINCSPlusPrivateKeyParameters extends SPHINCSPlusKeyParameters {

    /* renamed from: pk  reason: collision with root package name */
    public final PK f59610pk;

    /* renamed from: sk  reason: collision with root package name */
    public final SK f59611sk;

    public SPHINCSPlusPrivateKeyParameters(SPHINCSPlusParameters sPHINCSPlusParameters, SK sk2, PK pk2) {
        super(true, sPHINCSPlusParameters);
        this.f59611sk = sk2;
        this.f59610pk = pk2;
    }

    public SPHINCSPlusPrivateKeyParameters(SPHINCSPlusParameters sPHINCSPlusParameters, byte[] bArr) {
        super(true, sPHINCSPlusParameters);
        int i11 = sPHINCSPlusParameters.getEngine().N;
        int i12 = i11 * 4;
        if (bArr.length == i12) {
            int i13 = i11 * 2;
            this.f59611sk = new SK(Arrays.copyOfRange(bArr, 0, i11), Arrays.copyOfRange(bArr, i11, i13));
            int i14 = i11 * 3;
            this.f59610pk = new PK(Arrays.copyOfRange(bArr, i13, i14), Arrays.copyOfRange(bArr, i14, i12));
            return;
        }
        throw new IllegalArgumentException("private key encoding does not match parameters");
    }

    public byte[] getEncoded() {
        byte[] intToBigEndian = Pack.intToBigEndian(SPHINCSPlusParameters.getID(getParameters()).intValue());
        SK sk2 = this.f59611sk;
        byte[] bArr = sk2.seed;
        byte[] bArr2 = sk2.prf;
        PK pk2 = this.f59610pk;
        return Arrays.concatenate(intToBigEndian, Arrays.concatenate(bArr, bArr2, pk2.seed, pk2.root));
    }

    public byte[] getEncodedPublicKey() {
        byte[] intToBigEndian = Pack.intToBigEndian(SPHINCSPlusParameters.getID(getParameters()).intValue());
        PK pk2 = this.f59610pk;
        return Arrays.concatenate(intToBigEndian, pk2.seed, pk2.root);
    }

    public byte[] getPrf() {
        return Arrays.clone(this.f59611sk.prf);
    }

    public byte[] getPublicKey() {
        PK pk2 = this.f59610pk;
        return Arrays.concatenate(pk2.seed, pk2.root);
    }

    public byte[] getPublicSeed() {
        return Arrays.clone(this.f59610pk.seed);
    }

    public byte[] getSeed() {
        return Arrays.clone(this.f59611sk.seed);
    }
}
