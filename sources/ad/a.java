package ad;

import i6.d;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public static BigDecimal a(BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3, BigDecimal bigDecimal4, BigDecimal bigDecimal5, BigDecimal bigDecimal6, BigDecimal bigDecimal7) {
        BigDecimal divide = bigDecimal2.multiply(bigDecimal4).divide(bigDecimal3, 32, 1).add(bigDecimal.multiply(bigDecimal4).divide(bigDecimal3.multiply(BigDecimal.ONE.subtract(bigDecimal5)), 32, 1)).divide(BigDecimal.ONE.subtract(bigDecimal7.multiply(bigDecimal6)), 32, 1);
        d.b("-->\n sumBuy:" + bigDecimal.toPlainString() + " sumSell:" + bigDecimal2.toPlainString() + " minPrice:" + bigDecimal3.toPlainString() + " perAmount:" + bigDecimal4.toPlainString() + " userFeeRate:" + bigDecimal5.toPlainString() + " assetBuff:" + bigDecimal6.toPlainString() + " assetMulti:" + bigDecimal7.toPlainString() + " result:" + divide.toPlainString());
        return divide;
    }

    public static void b(List<BigDecimal> list, List<BigDecimal> list2, BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3, BigDecimal bigDecimal4, boolean z11) {
        ArrayList arrayList = new ArrayList();
        int intValue = bigDecimal4.intValue() - 1;
        arrayList.add(bigDecimal2);
        int i11 = 0;
        BigDecimal bigDecimal5 = bigDecimal2;
        for (int i12 = 0; i12 < intValue; i12++) {
            if (z11) {
                bigDecimal5 = bigDecimal5.add(i(bigDecimal3, bigDecimal2, bigDecimal4));
            } else {
                bigDecimal5 = bigDecimal5.multiply(BigDecimal.ONE.add(h(bigDecimal3, bigDecimal2, bigDecimal4)));
            }
            arrayList.add(bigDecimal5);
        }
        if (bigDecimal.compareTo(bigDecimal2) <= 0) {
            if (list2 != null) {
                for (int i13 = 1; i13 < arrayList.size(); i13++) {
                    list2.add((BigDecimal) arrayList.get(i13));
                }
            }
        } else if (bigDecimal.compareTo(bigDecimal3) < 0) {
            while (i11 < arrayList.size()) {
                BigDecimal bigDecimal6 = (BigDecimal) arrayList.get(i11);
                if (bigDecimal.compareTo(bigDecimal6) > 0) {
                    if (list != null) {
                        list.add(bigDecimal6);
                    }
                } else if (list2 != null) {
                    list2.add(bigDecimal6);
                }
                i11++;
            }
        } else if (list != null) {
            while (i11 < arrayList.size() - 1) {
                list.add((BigDecimal) arrayList.get(i11));
                i11++;
            }
        }
    }

    public static BigDecimal c(BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3) {
        return bigDecimal.multiply(bigDecimal2).divide(BigDecimal.ONE.subtract(bigDecimal3), 32, 1);
    }

    public static BigDecimal d(BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3, BigDecimal bigDecimal4, BigDecimal bigDecimal5) {
        return bigDecimal.multiply(bigDecimal3).divide(bigDecimal2.multiply(BigDecimal.ONE.subtract(bigDecimal4)), 32, 1).divide(BigDecimal.ONE.subtract(bigDecimal5), 32, 1);
    }

    public static BigDecimal e(BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3) {
        BigDecimal subtract = BigDecimal.ONE.subtract(bigDecimal3);
        return bigDecimal2.multiply(subtract).subtract(bigDecimal.divide(subtract, 32, 1)).divide(bigDecimal.divide(subtract, 32, 1), 32, 1);
    }

    public static BigDecimal f(BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3) {
        BigDecimal subtract = BigDecimal.ONE.subtract(bigDecimal3);
        return bigDecimal.multiply(subtract).subtract(bigDecimal2.divide(subtract, 32, 1)).divide(bigDecimal2.divide(subtract, 32, 1), 32, 1);
    }

    public static BigDecimal g(BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3) {
        return e(bigDecimal, bigDecimal2, bigDecimal3);
    }

    public static BigDecimal h(BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3) {
        return m.a(String.valueOf(Math.pow(bigDecimal.divide(bigDecimal2, 32, 1).doubleValue(), 1.0d / ((double) bigDecimal3.subtract(BigDecimal.ONE).intValue())))).subtract(BigDecimal.ONE);
    }

    public static BigDecimal i(BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3) {
        return bigDecimal.subtract(bigDecimal2).divide(bigDecimal3.subtract(m.a("1")), 32, 1);
    }
}
