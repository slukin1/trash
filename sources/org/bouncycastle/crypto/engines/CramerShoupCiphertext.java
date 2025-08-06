package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class CramerShoupCiphertext {

    /* renamed from: e  reason: collision with root package name */
    public BigInteger f59163e;

    /* renamed from: u1  reason: collision with root package name */
    public BigInteger f59164u1;

    /* renamed from: u2  reason: collision with root package name */
    public BigInteger f59165u2;

    /* renamed from: v  reason: collision with root package name */
    public BigInteger f59166v;

    public CramerShoupCiphertext() {
    }

    public CramerShoupCiphertext(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f59164u1 = bigInteger;
        this.f59165u2 = bigInteger2;
        this.f59163e = bigInteger3;
        this.f59166v = bigInteger4;
    }

    public CramerShoupCiphertext(byte[] bArr) {
        int bigEndianToInt = Pack.bigEndianToInt(bArr, 0) + 4;
        this.f59164u1 = new BigInteger(Arrays.copyOfRange(bArr, 4, bigEndianToInt));
        int bigEndianToInt2 = Pack.bigEndianToInt(bArr, bigEndianToInt);
        int i11 = bigEndianToInt + 4;
        int i12 = bigEndianToInt2 + i11;
        this.f59165u2 = new BigInteger(Arrays.copyOfRange(bArr, i11, i12));
        int bigEndianToInt3 = Pack.bigEndianToInt(bArr, i12);
        int i13 = i12 + 4;
        int i14 = bigEndianToInt3 + i13;
        this.f59163e = new BigInteger(Arrays.copyOfRange(bArr, i13, i14));
        int bigEndianToInt4 = Pack.bigEndianToInt(bArr, i14);
        int i15 = i14 + 4;
        this.f59166v = new BigInteger(Arrays.copyOfRange(bArr, i15, bigEndianToInt4 + i15));
    }

    public BigInteger getE() {
        return this.f59163e;
    }

    public BigInteger getU1() {
        return this.f59164u1;
    }

    public BigInteger getU2() {
        return this.f59165u2;
    }

    public BigInteger getV() {
        return this.f59166v;
    }

    public void setE(BigInteger bigInteger) {
        this.f59163e = bigInteger;
    }

    public void setU1(BigInteger bigInteger) {
        this.f59164u1 = bigInteger;
    }

    public void setU2(BigInteger bigInteger) {
        this.f59165u2 = bigInteger;
    }

    public void setV(BigInteger bigInteger) {
        this.f59166v = bigInteger;
    }

    public byte[] toByteArray() {
        byte[] byteArray = this.f59164u1.toByteArray();
        int length = byteArray.length;
        byte[] byteArray2 = this.f59165u2.toByteArray();
        int length2 = byteArray2.length;
        byte[] byteArray3 = this.f59163e.toByteArray();
        int length3 = byteArray3.length;
        byte[] byteArray4 = this.f59166v.toByteArray();
        int length4 = byteArray4.length;
        byte[] bArr = new byte[(length + length2 + length3 + length4 + 16)];
        Pack.intToBigEndian(length, bArr, 0);
        System.arraycopy(byteArray, 0, bArr, 4, length);
        int i11 = length + 4;
        Pack.intToBigEndian(length2, bArr, i11);
        int i12 = i11 + 4;
        System.arraycopy(byteArray2, 0, bArr, i12, length2);
        int i13 = i12 + length2;
        Pack.intToBigEndian(length3, bArr, i13);
        int i14 = i13 + 4;
        System.arraycopy(byteArray3, 0, bArr, i14, length3);
        int i15 = i14 + length3;
        Pack.intToBigEndian(length4, bArr, i15);
        System.arraycopy(byteArray4, 0, bArr, i15 + 4, length4);
        return bArr;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("u1: " + this.f59164u1.toString());
        stringBuffer.append("\nu2: " + this.f59165u2.toString());
        stringBuffer.append("\ne: " + this.f59163e.toString());
        stringBuffer.append("\nv: " + this.f59166v.toString());
        return stringBuffer.toString();
    }
}
