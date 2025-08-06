package org.bouncycastle.math.ec;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.math.BigInteger;

class SimpleBigDecimal {
    private static final long serialVersionUID = 1;
    private final BigInteger bigInt;
    private final int scale;

    public SimpleBigDecimal(BigInteger bigInteger, int i11) {
        if (i11 >= 0) {
            this.bigInt = bigInteger;
            this.scale = i11;
            return;
        }
        throw new IllegalArgumentException("scale may not be negative");
    }

    private void checkScale(SimpleBigDecimal simpleBigDecimal) {
        if (this.scale != simpleBigDecimal.scale) {
            throw new IllegalArgumentException("Only SimpleBigDecimal of same scale allowed in arithmetic operations");
        }
    }

    public static SimpleBigDecimal getInstance(BigInteger bigInteger, int i11) {
        return new SimpleBigDecimal(bigInteger.shiftLeft(i11), i11);
    }

    public SimpleBigDecimal add(BigInteger bigInteger) {
        return new SimpleBigDecimal(this.bigInt.add(bigInteger.shiftLeft(this.scale)), this.scale);
    }

    public SimpleBigDecimal add(SimpleBigDecimal simpleBigDecimal) {
        checkScale(simpleBigDecimal);
        return new SimpleBigDecimal(this.bigInt.add(simpleBigDecimal.bigInt), this.scale);
    }

    public SimpleBigDecimal adjustScale(int i11) {
        if (i11 >= 0) {
            int i12 = this.scale;
            return i11 == i12 ? this : new SimpleBigDecimal(this.bigInt.shiftLeft(i11 - i12), i11);
        }
        throw new IllegalArgumentException("scale may not be negative");
    }

    public int compareTo(BigInteger bigInteger) {
        return this.bigInt.compareTo(bigInteger.shiftLeft(this.scale));
    }

    public int compareTo(SimpleBigDecimal simpleBigDecimal) {
        checkScale(simpleBigDecimal);
        return this.bigInt.compareTo(simpleBigDecimal.bigInt);
    }

    public SimpleBigDecimal divide(BigInteger bigInteger) {
        return new SimpleBigDecimal(this.bigInt.divide(bigInteger), this.scale);
    }

    public SimpleBigDecimal divide(SimpleBigDecimal simpleBigDecimal) {
        checkScale(simpleBigDecimal);
        return new SimpleBigDecimal(this.bigInt.shiftLeft(this.scale).divide(simpleBigDecimal.bigInt), this.scale);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleBigDecimal)) {
            return false;
        }
        SimpleBigDecimal simpleBigDecimal = (SimpleBigDecimal) obj;
        return this.bigInt.equals(simpleBigDecimal.bigInt) && this.scale == simpleBigDecimal.scale;
    }

    public BigInteger floor() {
        return this.bigInt.shiftRight(this.scale);
    }

    public int getScale() {
        return this.scale;
    }

    public int hashCode() {
        return this.bigInt.hashCode() ^ this.scale;
    }

    public int intValue() {
        return floor().intValue();
    }

    public long longValue() {
        return floor().longValue();
    }

    public SimpleBigDecimal multiply(BigInteger bigInteger) {
        return new SimpleBigDecimal(this.bigInt.multiply(bigInteger), this.scale);
    }

    public SimpleBigDecimal multiply(SimpleBigDecimal simpleBigDecimal) {
        checkScale(simpleBigDecimal);
        BigInteger multiply = this.bigInt.multiply(simpleBigDecimal.bigInt);
        int i11 = this.scale;
        return new SimpleBigDecimal(multiply, i11 + i11);
    }

    public SimpleBigDecimal negate() {
        return new SimpleBigDecimal(this.bigInt.negate(), this.scale);
    }

    public BigInteger round() {
        return add(new SimpleBigDecimal(ECConstants.ONE, 1).adjustScale(this.scale)).floor();
    }

    public SimpleBigDecimal shiftLeft(int i11) {
        return new SimpleBigDecimal(this.bigInt.shiftLeft(i11), this.scale);
    }

    public SimpleBigDecimal subtract(BigInteger bigInteger) {
        return new SimpleBigDecimal(this.bigInt.subtract(bigInteger.shiftLeft(this.scale)), this.scale);
    }

    public SimpleBigDecimal subtract(SimpleBigDecimal simpleBigDecimal) {
        return add(simpleBigDecimal.negate());
    }

    public String toString() {
        if (this.scale == 0) {
            return this.bigInt.toString();
        }
        BigInteger floor = floor();
        BigInteger subtract = this.bigInt.subtract(floor.shiftLeft(this.scale));
        if (this.bigInt.signum() == -1) {
            subtract = ECConstants.ONE.shiftLeft(this.scale).subtract(subtract);
        }
        if (floor.signum() == -1 && !subtract.equals(ECConstants.ZERO)) {
            floor = floor.add(ECConstants.ONE);
        }
        String bigInteger = floor.toString();
        char[] cArr = new char[this.scale];
        String bigInteger2 = subtract.toString(2);
        int length = bigInteger2.length();
        int i11 = this.scale - length;
        for (int i12 = 0; i12 < i11; i12++) {
            cArr[i12] = '0';
        }
        for (int i13 = 0; i13 < length; i13++) {
            cArr[i11 + i13] = bigInteger2.charAt(i13);
        }
        String str = new String(cArr);
        StringBuffer stringBuffer = new StringBuffer(bigInteger);
        stringBuffer.append(InstructionFileId.DOT);
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
