package org.bouncycastle.pqc.asn1;

import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.pqc.crypto.gmss.GMSSLeaf;
import org.bouncycastle.pqc.crypto.gmss.GMSSParameters;
import org.bouncycastle.pqc.crypto.gmss.GMSSRootCalc;
import org.bouncycastle.pqc.crypto.gmss.GMSSRootSig;
import org.bouncycastle.pqc.crypto.gmss.Treehash;

public class GMSSPrivateKey extends ASN1Object {
    private ASN1Primitive primitive;

    private GMSSPrivateKey(ASN1Sequence aSN1Sequence) {
        ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Sequence.getObjectAt(0);
        int[] iArr = new int[aSN1Sequence2.size()];
        for (int i11 = 0; i11 < aSN1Sequence2.size(); i11++) {
            iArr[i11] = checkBigIntegerInIntRange(aSN1Sequence2.getObjectAt(i11));
        }
        ASN1Sequence aSN1Sequence3 = (ASN1Sequence) aSN1Sequence.getObjectAt(1);
        int size = aSN1Sequence3.size();
        byte[][] bArr = new byte[size][];
        for (int i12 = 0; i12 < size; i12++) {
            bArr[i12] = ((DEROctetString) aSN1Sequence3.getObjectAt(i12)).getOctets();
        }
        ASN1Sequence aSN1Sequence4 = (ASN1Sequence) aSN1Sequence.getObjectAt(2);
        int size2 = aSN1Sequence4.size();
        byte[][] bArr2 = new byte[size2][];
        for (int i13 = 0; i13 < size2; i13++) {
            bArr2[i13] = ((DEROctetString) aSN1Sequence4.getObjectAt(i13)).getOctets();
        }
        ASN1Sequence aSN1Sequence5 = (ASN1Sequence) aSN1Sequence.getObjectAt(3);
        int size3 = aSN1Sequence5.size();
        byte[][][] bArr3 = new byte[size3][][];
        for (int i14 = 0; i14 < size3; i14++) {
            ASN1Sequence aSN1Sequence6 = (ASN1Sequence) aSN1Sequence5.getObjectAt(i14);
            bArr3[i14] = new byte[aSN1Sequence6.size()][];
            for (int i15 = 0; i15 < bArr3[i14].length; i15++) {
                bArr3[i14][i15] = ((DEROctetString) aSN1Sequence6.getObjectAt(i15)).getOctets();
            }
        }
        ASN1Sequence aSN1Sequence7 = (ASN1Sequence) aSN1Sequence.getObjectAt(4);
        int size4 = aSN1Sequence7.size();
        byte[][][] bArr4 = new byte[size4][][];
        for (int i16 = 0; i16 < size4; i16++) {
            ASN1Sequence aSN1Sequence8 = (ASN1Sequence) aSN1Sequence7.getObjectAt(i16);
            bArr4[i16] = new byte[aSN1Sequence8.size()][];
            for (int i17 = 0; i17 < bArr4[i16].length; i17++) {
                bArr4[i16][i17] = ((DEROctetString) aSN1Sequence8.getObjectAt(i17)).getOctets();
            }
        }
        Treehash[][] treehashArr = new Treehash[((ASN1Sequence) aSN1Sequence.getObjectAt(5)).size()][];
    }

    public GMSSPrivateKey(int[] iArr, byte[][] bArr, byte[][] bArr2, byte[][][] bArr3, byte[][][] bArr4, Treehash[][] treehashArr, Treehash[][] treehashArr2, Vector[] vectorArr, Vector[] vectorArr2, Vector[][] vectorArr3, Vector[][] vectorArr4, byte[][][] bArr5, GMSSLeaf[] gMSSLeafArr, GMSSLeaf[] gMSSLeafArr2, GMSSLeaf[] gMSSLeafArr3, int[] iArr2, byte[][] bArr6, GMSSRootCalc[] gMSSRootCalcArr, byte[][] bArr7, GMSSRootSig[] gMSSRootSigArr, GMSSParameters gMSSParameters, AlgorithmIdentifier algorithmIdentifier) {
        AlgorithmIdentifier[] algorithmIdentifierArr = new AlgorithmIdentifier[1];
        AlgorithmIdentifier[] algorithmIdentifierArr2 = algorithmIdentifierArr;
        algorithmIdentifierArr[0] = algorithmIdentifier;
        this.primitive = encode(iArr, bArr, bArr2, bArr3, bArr4, bArr5, treehashArr, treehashArr2, vectorArr, vectorArr2, vectorArr3, vectorArr4, gMSSLeafArr, gMSSLeafArr2, gMSSLeafArr3, iArr2, bArr6, gMSSRootCalcArr, bArr7, gMSSRootSigArr, gMSSParameters, algorithmIdentifierArr2);
    }

    private static int checkBigIntegerInIntRange(ASN1Encodable aSN1Encodable) {
        return ((ASN1Integer) aSN1Encodable).intValueExact();
    }

    private ASN1Primitive encode(int[] iArr, byte[][] bArr, byte[][] bArr2, byte[][][] bArr3, byte[][][] bArr4, byte[][][] bArr5, Treehash[][] treehashArr, Treehash[][] treehashArr2, Vector[] vectorArr, Vector[] vectorArr2, Vector[][] vectorArr3, Vector[][] vectorArr4, GMSSLeaf[] gMSSLeafArr, GMSSLeaf[] gMSSLeafArr2, GMSSLeaf[] gMSSLeafArr3, int[] iArr2, byte[][] bArr6, GMSSRootCalc[] gMSSRootCalcArr, byte[][] bArr7, GMSSRootSig[] gMSSRootSigArr, GMSSParameters gMSSParameters, AlgorithmIdentifier[] algorithmIdentifierArr) {
        int[] iArr3 = iArr;
        byte[][] bArr8 = bArr;
        byte[][] bArr9 = bArr2;
        byte[][][] bArr10 = bArr3;
        byte[][][] bArr11 = bArr4;
        byte[][][] bArr12 = bArr5;
        Treehash[][] treehashArr3 = treehashArr;
        Treehash[][] treehashArr4 = treehashArr2;
        Vector[] vectorArr5 = vectorArr;
        Vector[] vectorArr6 = vectorArr2;
        Vector[][] vectorArr7 = vectorArr3;
        Vector[][] vectorArr8 = vectorArr4;
        GMSSLeaf[] gMSSLeafArr4 = gMSSLeafArr;
        GMSSLeaf[] gMSSLeafArr5 = gMSSLeafArr2;
        GMSSLeaf[] gMSSLeafArr6 = gMSSLeafArr3;
        int[] iArr4 = iArr2;
        AlgorithmIdentifier[] algorithmIdentifierArr2 = algorithmIdentifierArr;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        int i11 = 0;
        while (i11 < iArr3.length) {
            aSN1EncodableVector2.add(new ASN1Integer((long) iArr3[i11]));
            i11++;
            Vector[] vectorArr9 = vectorArr2;
            Vector[][] vectorArr10 = vectorArr3;
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
        for (byte[] dEROctetString : bArr8) {
            aSN1EncodableVector3.add(new DEROctetString(dEROctetString));
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector3));
        ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
        for (byte[] dEROctetString2 : bArr9) {
            aSN1EncodableVector4.add(new DEROctetString(dEROctetString2));
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector4));
        ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
        for (int i12 = 0; i12 < bArr10.length; i12++) {
            for (byte[] dEROctetString3 : bArr10[i12]) {
                aSN1EncodableVector5.add(new DEROctetString(dEROctetString3));
            }
            aSN1EncodableVector6.add(new DERSequence(aSN1EncodableVector5));
            aSN1EncodableVector5 = new ASN1EncodableVector();
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector6));
        ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
        for (int i13 = 0; i13 < bArr11.length; i13++) {
            for (byte[] dEROctetString4 : bArr11[i13]) {
                aSN1EncodableVector7.add(new DEROctetString(dEROctetString4));
            }
            aSN1EncodableVector8.add(new DERSequence(aSN1EncodableVector7));
            aSN1EncodableVector7 = new ASN1EncodableVector();
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector8));
        ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector10 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector11 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector12 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector13 = new ASN1EncodableVector();
        int i14 = 0;
        while (i14 < treehashArr3.length) {
            int i15 = 0;
            while (i15 < treehashArr3[i14].length) {
                aSN1EncodableVector11.add(new DERSequence((ASN1Encodable) algorithmIdentifierArr2[0]));
                int i16 = treehashArr3[i14][i15].getStatInt()[1];
                aSN1EncodableVector12.add(new DEROctetString(treehashArr3[i14][i15].getStatByte()[0]));
                aSN1EncodableVector12.add(new DEROctetString(treehashArr3[i14][i15].getStatByte()[1]));
                aSN1EncodableVector12.add(new DEROctetString(treehashArr3[i14][i15].getStatByte()[2]));
                int i17 = 0;
                while (i17 < i16) {
                    aSN1EncodableVector12.add(new DEROctetString(treehashArr3[i14][i15].getStatByte()[i17 + 3]));
                    i17++;
                    Vector[] vectorArr11 = vectorArr;
                }
                aSN1EncodableVector11.add(new DERSequence(aSN1EncodableVector12));
                aSN1EncodableVector12 = new ASN1EncodableVector();
                aSN1EncodableVector13.add(new ASN1Integer((long) treehashArr3[i14][i15].getStatInt()[0]));
                aSN1EncodableVector13.add(new ASN1Integer((long) i16));
                aSN1EncodableVector13.add(new ASN1Integer((long) treehashArr3[i14][i15].getStatInt()[2]));
                aSN1EncodableVector13.add(new ASN1Integer((long) treehashArr3[i14][i15].getStatInt()[3]));
                aSN1EncodableVector13.add(new ASN1Integer((long) treehashArr3[i14][i15].getStatInt()[4]));
                aSN1EncodableVector13.add(new ASN1Integer((long) treehashArr3[i14][i15].getStatInt()[5]));
                int i18 = 0;
                while (i18 < i16) {
                    aSN1EncodableVector13.add(new ASN1Integer((long) treehashArr3[i14][i15].getStatInt()[i18 + 6]));
                    i18++;
                    byte[][][] bArr13 = bArr5;
                    treehashArr3 = treehashArr;
                }
                aSN1EncodableVector11.add(new DERSequence(aSN1EncodableVector13));
                aSN1EncodableVector13 = new ASN1EncodableVector();
                aSN1EncodableVector10.add(new DERSequence(aSN1EncodableVector11));
                aSN1EncodableVector11 = new ASN1EncodableVector();
                i15++;
                byte[][][] bArr14 = bArr5;
                treehashArr3 = treehashArr;
                Vector[] vectorArr12 = vectorArr;
            }
            aSN1EncodableVector9.add(new DERSequence(aSN1EncodableVector10));
            aSN1EncodableVector10 = new ASN1EncodableVector();
            i14++;
            byte[][][] bArr15 = bArr5;
            treehashArr3 = treehashArr;
            Vector[] vectorArr13 = vectorArr;
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector9));
        ASN1EncodableVector aSN1EncodableVector14 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector15 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector16 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector17 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector18 = new ASN1EncodableVector();
        for (int i19 = 0; i19 < treehashArr4.length; i19++) {
            for (int i21 = 0; i21 < treehashArr4[i19].length; i21++) {
                aSN1EncodableVector16.add(new DERSequence((ASN1Encodable) algorithmIdentifierArr2[0]));
                int i22 = treehashArr4[i19][i21].getStatInt()[1];
                aSN1EncodableVector17.add(new DEROctetString(treehashArr4[i19][i21].getStatByte()[0]));
                aSN1EncodableVector17.add(new DEROctetString(treehashArr4[i19][i21].getStatByte()[1]));
                aSN1EncodableVector17.add(new DEROctetString(treehashArr4[i19][i21].getStatByte()[2]));
                for (int i23 = 0; i23 < i22; i23++) {
                    aSN1EncodableVector17.add(new DEROctetString(treehashArr4[i19][i21].getStatByte()[i23 + 3]));
                }
                aSN1EncodableVector16.add(new DERSequence(aSN1EncodableVector17));
                aSN1EncodableVector17 = new ASN1EncodableVector();
                aSN1EncodableVector18.add(new ASN1Integer((long) treehashArr4[i19][i21].getStatInt()[0]));
                aSN1EncodableVector18.add(new ASN1Integer((long) i22));
                aSN1EncodableVector18.add(new ASN1Integer((long) treehashArr4[i19][i21].getStatInt()[2]));
                aSN1EncodableVector18.add(new ASN1Integer((long) treehashArr4[i19][i21].getStatInt()[3]));
                aSN1EncodableVector18.add(new ASN1Integer((long) treehashArr4[i19][i21].getStatInt()[4]));
                aSN1EncodableVector18.add(new ASN1Integer((long) treehashArr4[i19][i21].getStatInt()[5]));
                for (int i24 = 0; i24 < i22; i24++) {
                    aSN1EncodableVector18.add(new ASN1Integer((long) treehashArr4[i19][i21].getStatInt()[i24 + 6]));
                }
                aSN1EncodableVector16.add(new DERSequence(aSN1EncodableVector18));
                aSN1EncodableVector18 = new ASN1EncodableVector();
                aSN1EncodableVector15.add(new DERSequence(aSN1EncodableVector16));
                aSN1EncodableVector16 = new ASN1EncodableVector();
            }
            aSN1EncodableVector14.add(new DERSequence((ASN1Encodable) new DERSequence(aSN1EncodableVector15)));
            aSN1EncodableVector15 = new ASN1EncodableVector();
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector14));
        ASN1EncodableVector aSN1EncodableVector19 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector20 = new ASN1EncodableVector();
        byte[][][] bArr16 = bArr5;
        for (int i25 = 0; i25 < bArr16.length; i25++) {
            for (byte[] dEROctetString5 : bArr16[i25]) {
                aSN1EncodableVector19.add(new DEROctetString(dEROctetString5));
            }
            aSN1EncodableVector20.add(new DERSequence(aSN1EncodableVector19));
            aSN1EncodableVector19 = new ASN1EncodableVector();
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector20));
        ASN1EncodableVector aSN1EncodableVector21 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector22 = new ASN1EncodableVector();
        Vector[] vectorArr14 = vectorArr;
        for (int i26 = 0; i26 < vectorArr14.length; i26++) {
            for (int i27 = 0; i27 < vectorArr14[i26].size(); i27++) {
                aSN1EncodableVector21.add(new DEROctetString((byte[]) vectorArr14[i26].elementAt(i27)));
            }
            aSN1EncodableVector22.add(new DERSequence(aSN1EncodableVector21));
            aSN1EncodableVector21 = new ASN1EncodableVector();
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector22));
        ASN1EncodableVector aSN1EncodableVector23 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector24 = new ASN1EncodableVector();
        Vector[] vectorArr15 = vectorArr2;
        for (int i28 = 0; i28 < vectorArr15.length; i28++) {
            for (int i29 = 0; i29 < vectorArr15[i28].size(); i29++) {
                aSN1EncodableVector23.add(new DEROctetString((byte[]) vectorArr15[i28].elementAt(i29)));
            }
            aSN1EncodableVector24.add(new DERSequence(aSN1EncodableVector23));
            aSN1EncodableVector23 = new ASN1EncodableVector();
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector24));
        ASN1EncodableVector aSN1EncodableVector25 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector26 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector27 = new ASN1EncodableVector();
        Vector[][] vectorArr16 = vectorArr3;
        for (int i30 = 0; i30 < vectorArr16.length; i30++) {
            for (int i31 = 0; i31 < vectorArr16[i30].length; i31++) {
                for (int i32 = 0; i32 < vectorArr16[i30][i31].size(); i32++) {
                    aSN1EncodableVector25.add(new DEROctetString((byte[]) vectorArr16[i30][i31].elementAt(i32)));
                }
                aSN1EncodableVector26.add(new DERSequence(aSN1EncodableVector25));
                aSN1EncodableVector25 = new ASN1EncodableVector();
            }
            aSN1EncodableVector27.add(new DERSequence(aSN1EncodableVector26));
            aSN1EncodableVector26 = new ASN1EncodableVector();
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector27));
        ASN1EncodableVector aSN1EncodableVector28 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector29 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector30 = new ASN1EncodableVector();
        Vector[][] vectorArr17 = vectorArr4;
        for (int i33 = 0; i33 < vectorArr17.length; i33++) {
            for (int i34 = 0; i34 < vectorArr17[i33].length; i34++) {
                for (int i35 = 0; i35 < vectorArr17[i33][i34].size(); i35++) {
                    aSN1EncodableVector28.add(new DEROctetString((byte[]) vectorArr17[i33][i34].elementAt(i35)));
                }
                aSN1EncodableVector29.add(new DERSequence(aSN1EncodableVector28));
                aSN1EncodableVector28 = new ASN1EncodableVector();
            }
            aSN1EncodableVector30.add(new DERSequence(aSN1EncodableVector29));
            aSN1EncodableVector29 = new ASN1EncodableVector();
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector30));
        ASN1EncodableVector aSN1EncodableVector31 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector32 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector33 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector34 = new ASN1EncodableVector();
        GMSSLeaf[] gMSSLeafArr7 = gMSSLeafArr;
        for (int i36 = 0; i36 < gMSSLeafArr7.length; i36++) {
            aSN1EncodableVector32.add(new DERSequence((ASN1Encodable) algorithmIdentifierArr2[0]));
            byte[][] statByte = gMSSLeafArr7[i36].getStatByte();
            aSN1EncodableVector33.add(new DEROctetString(statByte[0]));
            aSN1EncodableVector33.add(new DEROctetString(statByte[1]));
            aSN1EncodableVector33.add(new DEROctetString(statByte[2]));
            aSN1EncodableVector33.add(new DEROctetString(statByte[3]));
            aSN1EncodableVector32.add(new DERSequence(aSN1EncodableVector33));
            aSN1EncodableVector33 = new ASN1EncodableVector();
            int[] statInt = gMSSLeafArr7[i36].getStatInt();
            aSN1EncodableVector34.add(new ASN1Integer((long) statInt[0]));
            aSN1EncodableVector34.add(new ASN1Integer((long) statInt[1]));
            aSN1EncodableVector34.add(new ASN1Integer((long) statInt[2]));
            aSN1EncodableVector34.add(new ASN1Integer((long) statInt[3]));
            aSN1EncodableVector32.add(new DERSequence(aSN1EncodableVector34));
            aSN1EncodableVector34 = new ASN1EncodableVector();
            aSN1EncodableVector31.add(new DERSequence(aSN1EncodableVector32));
            aSN1EncodableVector32 = new ASN1EncodableVector();
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector31));
        ASN1EncodableVector aSN1EncodableVector35 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector36 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector37 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector38 = new ASN1EncodableVector();
        GMSSLeaf[] gMSSLeafArr8 = gMSSLeafArr2;
        for (int i37 = 0; i37 < gMSSLeafArr8.length; i37++) {
            aSN1EncodableVector36.add(new DERSequence((ASN1Encodable) algorithmIdentifierArr2[0]));
            byte[][] statByte2 = gMSSLeafArr8[i37].getStatByte();
            aSN1EncodableVector37.add(new DEROctetString(statByte2[0]));
            aSN1EncodableVector37.add(new DEROctetString(statByte2[1]));
            aSN1EncodableVector37.add(new DEROctetString(statByte2[2]));
            aSN1EncodableVector37.add(new DEROctetString(statByte2[3]));
            aSN1EncodableVector36.add(new DERSequence(aSN1EncodableVector37));
            aSN1EncodableVector37 = new ASN1EncodableVector();
            int[] statInt2 = gMSSLeafArr8[i37].getStatInt();
            aSN1EncodableVector38.add(new ASN1Integer((long) statInt2[0]));
            aSN1EncodableVector38.add(new ASN1Integer((long) statInt2[1]));
            aSN1EncodableVector38.add(new ASN1Integer((long) statInt2[2]));
            aSN1EncodableVector38.add(new ASN1Integer((long) statInt2[3]));
            aSN1EncodableVector36.add(new DERSequence(aSN1EncodableVector38));
            aSN1EncodableVector38 = new ASN1EncodableVector();
            aSN1EncodableVector35.add(new DERSequence(aSN1EncodableVector36));
            aSN1EncodableVector36 = new ASN1EncodableVector();
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector35));
        ASN1EncodableVector aSN1EncodableVector39 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector40 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector41 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector42 = new ASN1EncodableVector();
        GMSSLeaf[] gMSSLeafArr9 = gMSSLeafArr3;
        ASN1EncodableVector aSN1EncodableVector43 = aSN1EncodableVector;
        for (int i38 = 0; i38 < gMSSLeafArr9.length; i38++) {
            aSN1EncodableVector40.add(new DERSequence((ASN1Encodable) algorithmIdentifierArr2[0]));
            byte[][] statByte3 = gMSSLeafArr9[i38].getStatByte();
            aSN1EncodableVector41.add(new DEROctetString(statByte3[0]));
            aSN1EncodableVector41.add(new DEROctetString(statByte3[1]));
            aSN1EncodableVector41.add(new DEROctetString(statByte3[2]));
            aSN1EncodableVector41.add(new DEROctetString(statByte3[3]));
            aSN1EncodableVector40.add(new DERSequence(aSN1EncodableVector41));
            aSN1EncodableVector41 = new ASN1EncodableVector();
            int[] statInt3 = gMSSLeafArr9[i38].getStatInt();
            aSN1EncodableVector42.add(new ASN1Integer((long) statInt3[0]));
            aSN1EncodableVector42.add(new ASN1Integer((long) statInt3[1]));
            aSN1EncodableVector42.add(new ASN1Integer((long) statInt3[2]));
            aSN1EncodableVector42.add(new ASN1Integer((long) statInt3[3]));
            aSN1EncodableVector40.add(new DERSequence(aSN1EncodableVector42));
            aSN1EncodableVector42 = new ASN1EncodableVector();
            aSN1EncodableVector39.add(new DERSequence(aSN1EncodableVector40));
            aSN1EncodableVector40 = new ASN1EncodableVector();
        }
        aSN1EncodableVector43.add(new DERSequence(aSN1EncodableVector39));
        ASN1EncodableVector aSN1EncodableVector44 = new ASN1EncodableVector();
        int[] iArr5 = iArr2;
        AlgorithmIdentifier[] algorithmIdentifierArr3 = algorithmIdentifierArr2;
        for (int i39 : iArr5) {
            aSN1EncodableVector44.add(new ASN1Integer((long) i39));
        }
        aSN1EncodableVector43.add(new DERSequence(aSN1EncodableVector44));
        ASN1EncodableVector aSN1EncodableVector45 = new ASN1EncodableVector();
        byte[][] bArr17 = bArr6;
        for (byte[] dEROctetString6 : bArr17) {
            aSN1EncodableVector45.add(new DEROctetString(dEROctetString6));
        }
        aSN1EncodableVector43.add(new DERSequence(aSN1EncodableVector45));
        ASN1EncodableVector aSN1EncodableVector46 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector47 = new ASN1EncodableVector();
        new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector48 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector49 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector50 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector51 = new ASN1EncodableVector();
        GMSSRootCalc[] gMSSRootCalcArr2 = gMSSRootCalcArr;
        int i40 = 0;
        while (i40 < gMSSRootCalcArr2.length) {
            aSN1EncodableVector47.add(new DERSequence((ASN1Encodable) algorithmIdentifierArr3[0]));
            new ASN1EncodableVector();
            int i41 = gMSSRootCalcArr2[i40].getStatInt()[0];
            int i42 = gMSSRootCalcArr2[i40].getStatInt()[7];
            aSN1EncodableVector48.add(new DEROctetString(gMSSRootCalcArr2[i40].getStatByte()[0]));
            int i43 = 0;
            while (i43 < i41) {
                i43++;
                aSN1EncodableVector48.add(new DEROctetString(gMSSRootCalcArr2[i40].getStatByte()[i43]));
            }
            for (int i44 = 0; i44 < i42; i44++) {
                aSN1EncodableVector48.add(new DEROctetString(gMSSRootCalcArr2[i40].getStatByte()[i41 + 1 + i44]));
            }
            aSN1EncodableVector47.add(new DERSequence(aSN1EncodableVector48));
            ASN1EncodableVector aSN1EncodableVector52 = new ASN1EncodableVector();
            aSN1EncodableVector49.add(new ASN1Integer((long) i41));
            aSN1EncodableVector49.add(new ASN1Integer((long) gMSSRootCalcArr2[i40].getStatInt()[1]));
            aSN1EncodableVector49.add(new ASN1Integer((long) gMSSRootCalcArr2[i40].getStatInt()[2]));
            aSN1EncodableVector49.add(new ASN1Integer((long) gMSSRootCalcArr2[i40].getStatInt()[3]));
            aSN1EncodableVector49.add(new ASN1Integer((long) gMSSRootCalcArr2[i40].getStatInt()[4]));
            aSN1EncodableVector49.add(new ASN1Integer((long) gMSSRootCalcArr2[i40].getStatInt()[5]));
            aSN1EncodableVector49.add(new ASN1Integer((long) gMSSRootCalcArr2[i40].getStatInt()[6]));
            aSN1EncodableVector49.add(new ASN1Integer((long) i42));
            for (int i45 = 0; i45 < i41; i45++) {
                aSN1EncodableVector49.add(new ASN1Integer((long) gMSSRootCalcArr2[i40].getStatInt()[i45 + 8]));
            }
            for (int i46 = 0; i46 < i42; i46++) {
                aSN1EncodableVector49.add(new ASN1Integer((long) gMSSRootCalcArr2[i40].getStatInt()[i41 + 8 + i46]));
            }
            aSN1EncodableVector47.add(new DERSequence(aSN1EncodableVector49));
            ASN1EncodableVector aSN1EncodableVector53 = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector54 = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector55 = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector56 = new ASN1EncodableVector();
            if (gMSSRootCalcArr2[i40].getTreehash() != null) {
                int i47 = 0;
                while (i47 < gMSSRootCalcArr2[i40].getTreehash().length) {
                    aSN1EncodableVector54.add(new DERSequence((ASN1Encodable) algorithmIdentifierArr3[0]));
                    int i48 = gMSSRootCalcArr2[i40].getTreehash()[i47].getStatInt()[1];
                    ASN1EncodableVector aSN1EncodableVector57 = aSN1EncodableVector52;
                    aSN1EncodableVector55.add(new DEROctetString(gMSSRootCalcArr2[i40].getTreehash()[i47].getStatByte()[0]));
                    aSN1EncodableVector55.add(new DEROctetString(gMSSRootCalcArr2[i40].getTreehash()[i47].getStatByte()[1]));
                    aSN1EncodableVector55.add(new DEROctetString(gMSSRootCalcArr2[i40].getTreehash()[i47].getStatByte()[2]));
                    int i49 = 0;
                    while (i49 < i48) {
                        aSN1EncodableVector55.add(new DEROctetString(gMSSRootCalcArr2[i40].getTreehash()[i47].getStatByte()[i49 + 3]));
                        i49++;
                        aSN1EncodableVector53 = aSN1EncodableVector53;
                    }
                    ASN1EncodableVector aSN1EncodableVector58 = aSN1EncodableVector53;
                    aSN1EncodableVector54.add(new DERSequence(aSN1EncodableVector55));
                    aSN1EncodableVector55 = new ASN1EncodableVector();
                    ASN1EncodableVector aSN1EncodableVector59 = aSN1EncodableVector43;
                    aSN1EncodableVector56.add(new ASN1Integer((long) gMSSRootCalcArr2[i40].getTreehash()[i47].getStatInt()[0]));
                    aSN1EncodableVector56.add(new ASN1Integer((long) i48));
                    aSN1EncodableVector56.add(new ASN1Integer((long) gMSSRootCalcArr2[i40].getTreehash()[i47].getStatInt()[2]));
                    aSN1EncodableVector56.add(new ASN1Integer((long) gMSSRootCalcArr2[i40].getTreehash()[i47].getStatInt()[3]));
                    aSN1EncodableVector56.add(new ASN1Integer((long) gMSSRootCalcArr2[i40].getTreehash()[i47].getStatInt()[4]));
                    aSN1EncodableVector56.add(new ASN1Integer((long) gMSSRootCalcArr2[i40].getTreehash()[i47].getStatInt()[5]));
                    int i50 = 0;
                    while (i50 < i48) {
                        aSN1EncodableVector56.add(new ASN1Integer((long) gMSSRootCalcArr2[i40].getTreehash()[i47].getStatInt()[i50 + 6]));
                        i50++;
                        i48 = i48;
                        aSN1EncodableVector59 = aSN1EncodableVector59;
                    }
                    aSN1EncodableVector54.add(new DERSequence(aSN1EncodableVector56));
                    aSN1EncodableVector56 = new ASN1EncodableVector();
                    aSN1EncodableVector50.add(new DERSequence(aSN1EncodableVector54));
                    aSN1EncodableVector54 = new ASN1EncodableVector();
                    i47++;
                    aSN1EncodableVector52 = aSN1EncodableVector57;
                    aSN1EncodableVector53 = aSN1EncodableVector58;
                    aSN1EncodableVector43 = aSN1EncodableVector59;
                }
            }
            ASN1EncodableVector aSN1EncodableVector60 = aSN1EncodableVector52;
            ASN1EncodableVector aSN1EncodableVector61 = aSN1EncodableVector53;
            ASN1EncodableVector aSN1EncodableVector62 = aSN1EncodableVector43;
            aSN1EncodableVector47.add(new DERSequence(aSN1EncodableVector50));
            aSN1EncodableVector50 = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector63 = new ASN1EncodableVector();
            if (gMSSRootCalcArr2[i40].getRetain() != null) {
                for (int i51 = 0; i51 < gMSSRootCalcArr2[i40].getRetain().length; i51++) {
                    for (int i52 = 0; i52 < gMSSRootCalcArr2[i40].getRetain()[i51].size(); i52++) {
                        aSN1EncodableVector63.add(new DEROctetString((byte[]) gMSSRootCalcArr2[i40].getRetain()[i51].elementAt(i52)));
                    }
                    aSN1EncodableVector51.add(new DERSequence(aSN1EncodableVector63));
                    aSN1EncodableVector63 = new ASN1EncodableVector();
                }
            }
            aSN1EncodableVector47.add(new DERSequence(aSN1EncodableVector51));
            aSN1EncodableVector51 = new ASN1EncodableVector();
            aSN1EncodableVector46.add(new DERSequence(aSN1EncodableVector47));
            aSN1EncodableVector47 = new ASN1EncodableVector();
            i40++;
            aSN1EncodableVector48 = aSN1EncodableVector60;
            aSN1EncodableVector49 = aSN1EncodableVector61;
            aSN1EncodableVector43 = aSN1EncodableVector62;
        }
        DERSequence dERSequence = new DERSequence(aSN1EncodableVector46);
        ASN1EncodableVector aSN1EncodableVector64 = aSN1EncodableVector43;
        aSN1EncodableVector64.add(dERSequence);
        ASN1EncodableVector aSN1EncodableVector65 = new ASN1EncodableVector();
        byte[][] bArr18 = bArr7;
        for (byte[] dEROctetString7 : bArr18) {
            aSN1EncodableVector65.add(new DEROctetString(dEROctetString7));
        }
        aSN1EncodableVector64.add(new DERSequence(aSN1EncodableVector65));
        ASN1EncodableVector aSN1EncodableVector66 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector67 = new ASN1EncodableVector();
        new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector68 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector69 = new ASN1EncodableVector();
        GMSSRootSig[] gMSSRootSigArr2 = gMSSRootSigArr;
        for (int i53 = 0; i53 < gMSSRootSigArr2.length; i53++) {
            aSN1EncodableVector67.add(new DERSequence((ASN1Encodable) algorithmIdentifierArr3[0]));
            new ASN1EncodableVector();
            aSN1EncodableVector68.add(new DEROctetString(gMSSRootSigArr2[i53].getStatByte()[0]));
            aSN1EncodableVector68.add(new DEROctetString(gMSSRootSigArr2[i53].getStatByte()[1]));
            aSN1EncodableVector68.add(new DEROctetString(gMSSRootSigArr2[i53].getStatByte()[2]));
            aSN1EncodableVector68.add(new DEROctetString(gMSSRootSigArr2[i53].getStatByte()[3]));
            aSN1EncodableVector68.add(new DEROctetString(gMSSRootSigArr2[i53].getStatByte()[4]));
            aSN1EncodableVector67.add(new DERSequence(aSN1EncodableVector68));
            aSN1EncodableVector68 = new ASN1EncodableVector();
            aSN1EncodableVector69.add(new ASN1Integer((long) gMSSRootSigArr2[i53].getStatInt()[0]));
            aSN1EncodableVector69.add(new ASN1Integer((long) gMSSRootSigArr2[i53].getStatInt()[1]));
            aSN1EncodableVector69.add(new ASN1Integer((long) gMSSRootSigArr2[i53].getStatInt()[2]));
            aSN1EncodableVector69.add(new ASN1Integer((long) gMSSRootSigArr2[i53].getStatInt()[3]));
            aSN1EncodableVector69.add(new ASN1Integer((long) gMSSRootSigArr2[i53].getStatInt()[4]));
            aSN1EncodableVector69.add(new ASN1Integer((long) gMSSRootSigArr2[i53].getStatInt()[5]));
            aSN1EncodableVector69.add(new ASN1Integer((long) gMSSRootSigArr2[i53].getStatInt()[6]));
            aSN1EncodableVector69.add(new ASN1Integer((long) gMSSRootSigArr2[i53].getStatInt()[7]));
            aSN1EncodableVector69.add(new ASN1Integer((long) gMSSRootSigArr2[i53].getStatInt()[8]));
            aSN1EncodableVector67.add(new DERSequence(aSN1EncodableVector69));
            aSN1EncodableVector69 = new ASN1EncodableVector();
            aSN1EncodableVector66.add(new DERSequence(aSN1EncodableVector67));
            aSN1EncodableVector67 = new ASN1EncodableVector();
        }
        aSN1EncodableVector64.add(new DERSequence(aSN1EncodableVector66));
        ASN1EncodableVector aSN1EncodableVector70 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector71 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector72 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector73 = new ASN1EncodableVector();
        for (int i54 = 0; i54 < gMSSParameters.getHeightOfTrees().length; i54++) {
            aSN1EncodableVector71.add(new ASN1Integer((long) gMSSParameters.getHeightOfTrees()[i54]));
            aSN1EncodableVector72.add(new ASN1Integer((long) gMSSParameters.getWinternitzParameter()[i54]));
            aSN1EncodableVector73.add(new ASN1Integer((long) gMSSParameters.getK()[i54]));
        }
        aSN1EncodableVector70.add(new ASN1Integer((long) gMSSParameters.getNumOfLayers()));
        aSN1EncodableVector70.add(new DERSequence(aSN1EncodableVector71));
        aSN1EncodableVector70.add(new DERSequence(aSN1EncodableVector72));
        aSN1EncodableVector70.add(new DERSequence(aSN1EncodableVector73));
        aSN1EncodableVector64.add(new DERSequence(aSN1EncodableVector70));
        ASN1EncodableVector aSN1EncodableVector74 = new ASN1EncodableVector();
        for (AlgorithmIdentifier add : algorithmIdentifierArr3) {
            aSN1EncodableVector74.add(add);
        }
        aSN1EncodableVector64.add(new DERSequence(aSN1EncodableVector74));
        return new DERSequence(aSN1EncodableVector64);
    }

    public ASN1Primitive toASN1Primitive() {
        return this.primitive;
    }
}
