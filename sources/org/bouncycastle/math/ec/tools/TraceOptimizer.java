package org.bouncycastle.math.ec.tools;

import java.io.PrintStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.TreeSet;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X9ECParametersHolder;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.util.Integers;

public class TraceOptimizer {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final SecureRandom R = new SecureRandom();

    private static int calculateTrace(ECFieldElement eCFieldElement) {
        int fieldSize = eCFieldElement.getFieldSize();
        int numberOfLeadingZeros = 31 - Integers.numberOfLeadingZeros(fieldSize);
        ECFieldElement eCFieldElement2 = eCFieldElement;
        int i11 = 1;
        while (numberOfLeadingZeros > 0) {
            eCFieldElement2 = eCFieldElement2.squarePow(i11).add(eCFieldElement2);
            numberOfLeadingZeros--;
            i11 = fieldSize >>> numberOfLeadingZeros;
            if ((i11 & 1) != 0) {
                eCFieldElement2 = eCFieldElement2.square().add(eCFieldElement);
            }
        }
        if (eCFieldElement2.isZero()) {
            return 0;
        }
        if (eCFieldElement2.isOne()) {
            return 1;
        }
        throw new IllegalStateException("Internal error in trace calculation");
    }

    private static ArrayList enumToList(Enumeration enumeration) {
        ArrayList arrayList = new ArrayList();
        while (enumeration.hasMoreElements()) {
            arrayList.add(enumeration.nextElement());
        }
        return arrayList;
    }

    public static void implPrintNonZeroTraceBits(ECCurve eCCurve) {
        StringBuilder sb2;
        PrintStream printStream;
        int fieldSize = eCCurve.getFieldSize();
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < fieldSize; i11++) {
            if ((i11 & 1) != 0 || i11 == 0) {
                if (calculateTrace(eCCurve.fromBigInteger(ONE.shiftLeft(i11))) != 0) {
                    arrayList.add(Integers.valueOf(i11));
                    printStream = System.out;
                    sb2 = new StringBuilder();
                }
            } else if (arrayList.contains(Integers.valueOf(i11 >>> 1))) {
                arrayList.add(Integers.valueOf(i11));
                printStream = System.out;
                sb2 = new StringBuilder();
            }
            sb2.append(" ");
            sb2.append(i11);
            printStream.print(sb2.toString());
        }
        System.out.println();
        int i12 = 0;
        while (i12 < 1000) {
            BigInteger bigInteger = new BigInteger(fieldSize, R);
            int calculateTrace = calculateTrace(eCCurve.fromBigInteger(bigInteger));
            int i13 = 0;
            for (int i14 = 0; i14 < arrayList.size(); i14++) {
                if (bigInteger.testBit(((Integer) arrayList.get(i14)).intValue())) {
                    i13 ^= 1;
                }
            }
            if (calculateTrace == i13) {
                i12++;
            } else {
                throw new IllegalStateException("Optimized-trace sanity check failed");
            }
        }
    }

    public static void main(String[] strArr) {
        TreeSet<String> treeSet = new TreeSet<>(enumToList(ECNamedCurveTable.getNames()));
        treeSet.addAll(enumToList(CustomNamedCurves.getNames()));
        for (String str : treeSet) {
            X9ECParametersHolder byNameLazy = CustomNamedCurves.getByNameLazy(str);
            if (byNameLazy == null) {
                byNameLazy = ECNamedCurveTable.getByNameLazy(str);
            }
            if (byNameLazy != null) {
                ECCurve curve = byNameLazy.getCurve();
                if (ECAlgorithms.isF2mCurve(curve)) {
                    PrintStream printStream = System.out;
                    printStream.print(str + ":");
                    implPrintNonZeroTraceBits(curve);
                }
            }
        }
    }

    public static void printNonZeroTraceBits(ECCurve eCCurve) {
        if (ECAlgorithms.isF2mCurve(eCCurve)) {
            implPrintNonZeroTraceBits(eCCurve);
            return;
        }
        throw new IllegalArgumentException("Trace only defined over characteristic-2 fields");
    }
}
