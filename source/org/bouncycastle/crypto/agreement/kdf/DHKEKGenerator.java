package org.bouncycastle.crypto.agreement.kdf;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.util.Pack;

public class DHKEKGenerator implements DerivationFunction {
    private ASN1ObjectIdentifier algorithm;
    private final Digest digest;
    private int keySize;
    private byte[] partyAInfo;

    /* renamed from: z  reason: collision with root package name */
    private byte[] f59110z;

    public DHKEKGenerator(Digest digest2) {
        this.digest = digest2;
    }

    public int generateBytes(byte[] bArr, int i11, int i12) throws DataLengthException, IllegalArgumentException {
        boolean z11;
        byte[] bArr2 = bArr;
        int i13 = i12;
        int i14 = i11;
        if (bArr2.length - i13 >= i14) {
            long j11 = (long) i13;
            int digestSize = this.digest.getDigestSize();
            if (j11 <= 8589934591L) {
                long j12 = (long) digestSize;
                int i15 = (int) (((j11 + j12) - 1) / j12);
                byte[] bArr3 = new byte[this.digest.getDigestSize()];
                int i16 = 0;
                int i17 = 0;
                int i18 = 1;
                while (i17 < i15) {
                    Digest digest2 = this.digest;
                    byte[] bArr4 = this.f59110z;
                    digest2.update(bArr4, i16, bArr4.length);
                    ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                    ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                    aSN1EncodableVector2.add(this.algorithm);
                    aSN1EncodableVector2.add(new DEROctetString(Pack.intToBigEndian(i18)));
                    aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
                    if (this.partyAInfo != null) {
                        z11 = true;
                        aSN1EncodableVector.add(new DERTaggedObject(true, i16, (ASN1Encodable) new DEROctetString(this.partyAInfo)));
                    } else {
                        z11 = true;
                    }
                    aSN1EncodableVector.add(new DERTaggedObject(z11, 2, (ASN1Encodable) new DEROctetString(Pack.intToBigEndian(this.keySize))));
                    try {
                        byte[] encoded = new DERSequence(aSN1EncodableVector).getEncoded(ASN1Encoding.DER);
                        this.digest.update(encoded, 0, encoded.length);
                        this.digest.doFinal(bArr3, 0);
                        if (i13 > digestSize) {
                            System.arraycopy(bArr3, 0, bArr2, i14, digestSize);
                            i14 += digestSize;
                            i13 -= digestSize;
                        } else {
                            System.arraycopy(bArr3, 0, bArr2, i14, i13);
                        }
                        i18++;
                        i17++;
                        i16 = 0;
                    } catch (IOException e11) {
                        throw new IllegalArgumentException("unable to encode parameter info: " + e11.getMessage());
                    }
                }
                this.digest.reset();
                return (int) j11;
            }
            throw new IllegalArgumentException("Output length too large");
        }
        throw new OutputLengthException("output buffer too small");
    }

    public Digest getDigest() {
        return this.digest;
    }

    public void init(DerivationParameters derivationParameters) {
        DHKDFParameters dHKDFParameters = (DHKDFParameters) derivationParameters;
        this.algorithm = dHKDFParameters.getAlgorithm();
        this.keySize = dHKDFParameters.getKeySize();
        this.f59110z = dHKDFParameters.getZ();
        this.partyAInfo = dHKDFParameters.getExtraInfo();
    }
}
