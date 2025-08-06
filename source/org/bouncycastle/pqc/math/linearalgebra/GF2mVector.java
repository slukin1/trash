package org.bouncycastle.pqc.math.linearalgebra;

import org.bouncycastle.util.Arrays;

public class GF2mVector extends Vector {
    private GF2mField field;
    private int[] vector;

    public GF2mVector(GF2mField gF2mField, byte[] bArr) {
        this.field = new GF2mField(gF2mField);
        int i11 = 8;
        int i12 = 1;
        while (gF2mField.getDegree() > i11) {
            i12++;
            i11 += 8;
        }
        if (bArr.length % i12 == 0) {
            int length = bArr.length / i12;
            this.length = length;
            this.vector = new int[length];
            int i13 = 0;
            int i14 = 0;
            while (i13 < this.vector.length) {
                int i15 = 0;
                while (i15 < i11) {
                    int[] iArr = this.vector;
                    iArr[i13] = ((bArr[i14] & 255) << i15) | iArr[i13];
                    i15 += 8;
                    i14++;
                }
                if (gF2mField.isElementOfThisField(this.vector[i13])) {
                    i13++;
                } else {
                    throw new IllegalArgumentException("Byte array is not an encoded vector over the given finite field.");
                }
            }
            return;
        }
        throw new IllegalArgumentException("Byte array is not an encoded vector over the given finite field.");
    }

    public GF2mVector(GF2mField gF2mField, int[] iArr) {
        this.field = gF2mField;
        this.length = iArr.length;
        int length = iArr.length - 1;
        while (length >= 0) {
            if (gF2mField.isElementOfThisField(iArr[length])) {
                length--;
            } else {
                throw new ArithmeticException("Element array is not specified over the given finite field.");
            }
        }
        this.vector = IntUtils.clone(iArr);
    }

    public GF2mVector(GF2mVector gF2mVector) {
        this.field = new GF2mField(gF2mVector.field);
        this.length = gF2mVector.length;
        this.vector = IntUtils.clone(gF2mVector.vector);
    }

    public Vector add(Vector vector2) {
        throw new RuntimeException("not implemented");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GF2mVector)) {
            return false;
        }
        GF2mVector gF2mVector = (GF2mVector) obj;
        if (!this.field.equals(gF2mVector.field)) {
            return false;
        }
        return IntUtils.equals(this.vector, gF2mVector.vector);
    }

    public byte[] getEncoded() {
        int i11 = 8;
        int i12 = 1;
        while (this.field.getDegree() > i11) {
            i12++;
            i11 += 8;
        }
        byte[] bArr = new byte[(this.vector.length * i12)];
        int i13 = 0;
        for (int i14 = 0; i14 < this.vector.length; i14++) {
            int i15 = 0;
            while (i15 < i11) {
                bArr[i13] = (byte) (this.vector[i14] >>> i15);
                i15 += 8;
                i13++;
            }
        }
        return bArr;
    }

    public GF2mField getField() {
        return this.field;
    }

    public int[] getIntArrayForm() {
        return IntUtils.clone(this.vector);
    }

    public int hashCode() {
        return (this.field.hashCode() * 31) + Arrays.hashCode(this.vector);
    }

    public boolean isZero() {
        for (int length = this.vector.length - 1; length >= 0; length--) {
            if (this.vector[length] != 0) {
                return false;
            }
        }
        return true;
    }

    public Vector multiply(Permutation permutation) {
        int[] vector2 = permutation.getVector();
        int i11 = this.length;
        if (i11 == vector2.length) {
            int[] iArr = new int[i11];
            for (int i12 = 0; i12 < vector2.length; i12++) {
                iArr[i12] = this.vector[vector2[i12]];
            }
            return new GF2mVector(this.field, iArr);
        }
        throw new ArithmeticException("permutation size and vector size mismatch");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < this.vector.length; i11++) {
            for (int i12 = 0; i12 < this.field.getDegree(); i12++) {
                stringBuffer.append(((1 << (i12 & 31)) & this.vector[i11]) != 0 ? '1' : '0');
            }
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }
}
