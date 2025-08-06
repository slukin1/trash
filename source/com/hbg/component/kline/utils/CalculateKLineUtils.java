package com.hbg.component.kline.utils;

import com.hbg.component.kline.bean.DataSetIndex;
import com.hbg.lib.common.utils.UtilCollections;
import com.hbg.lib.network.pro.socket.bean.KlineFixInfo;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculateKLineUtils {
    public static double[] A(List<KlineInfo> list, int i11, int i12, String str) {
        char c11;
        double[] dArr = new double[2];
        double d11 = 9.223372036854776E18d;
        double d12 = -9.223372036854776E18d;
        double d13 = 0.0d;
        int i13 = i11;
        double d14 = 0.0d;
        while (i13 <= i12) {
            KlineInfo klineInfo = list.get(i13);
            str.hashCode();
            if (!str.equals("MACD")) {
                c11 = 2;
            } else {
                c11 = 2;
                d14 = C(false, klineInfo.getMacd(), klineInfo.getDea(), klineInfo.getDif());
                d13 = D(false, klineInfo.getMacd(), klineInfo.getDea(), klineInfo.getDif());
            }
            if (d12 < d14) {
                d12 = d14;
            }
            if (d11 > d13) {
                d11 = d13;
            }
            i13++;
            char c12 = c11;
        }
        dArr[0] = d12;
        dArr[1] = d11;
        return dArr;
    }

    public static double[] B(List<KlineInfo> list, int i11, int i12, Map<Long, KlineFixInfo> map) {
        Double d11;
        Double d12;
        Map<Long, KlineFixInfo> map2 = map;
        double[] dArr = new double[2];
        double d13 = 9.223372036854776E18d;
        double d14 = -9.223372036854776E18d;
        for (int i13 = i11; i13 <= i12; i13++) {
            KlineInfo klineInfo = list.get(i13);
            KlineFixInfo klineFixInfo = map2 != null ? map2.get(Long.valueOf(klineInfo.getId())) : null;
            double high = (klineFixInfo == null || (d12 = klineFixInfo.target_high) == null) ? klineInfo.getHigh() : d12.doubleValue();
            double low = (klineFixInfo == null || (d11 = klineFixInfo.target_low) == null) ? klineInfo.getLow() : d11.doubleValue();
            double C = C(high >= 0.0d && klineInfo.getBollHigh() >= 0.0d, high, klineInfo.getBollHigh());
            double D = D(low >= 0.0d && klineInfo.getBollLow() >= 0.0d, low, klineInfo.getBollLow());
            if (d14 < C) {
                d14 = C;
            }
            if (d13 > D) {
                d13 = D;
            }
        }
        dArr[0] = d14;
        dArr[1] = d13;
        return dArr;
    }

    public static double C(boolean z11, double... dArr) {
        double d11 = -9.223372036854776E18d;
        if (dArr != null) {
            for (double d12 : dArr) {
                if (z11) {
                    if (d12 > 0.0d) {
                        if (d12 <= d11) {
                        }
                    }
                } else if (d12 <= d11) {
                }
                d11 = d12;
            }
        }
        return d11;
    }

    public static double D(boolean z11, double... dArr) {
        double d11 = 9.223372036854776E18d;
        if (dArr != null) {
            for (double d12 : dArr) {
                if (z11) {
                    if (d12 > 0.0d) {
                        if (d12 >= d11) {
                        }
                    }
                } else if (d12 >= d11) {
                }
                d11 = d12;
            }
        }
        return d11;
    }

    public static double a(double d11, double d12, double d13) {
        if (d12 - d13 == 0.0d) {
            d12 += 1.0d;
        }
        return ((d11 - d13) * 100.0d) / (d12 - d13);
    }

    public static float b(List<KlineInfo> list, int i11, int i12) {
        int i13;
        float f11 = 0.0f;
        int i14 = i11;
        float f12 = 0.0f;
        while (true) {
            i13 = (i11 - i12) + 1;
            if (i14 < i13) {
                break;
            }
            f12 = (float) (((double) f12) + list.get(i14).getClose());
            i14--;
        }
        float f13 = (float) i12;
        float f14 = f12 / f13;
        while (i11 >= i13) {
            double d11 = (double) f14;
            f11 = (float) (((double) f11) + ((list.get(i11).getClose() - d11) * (list.get(i11).getClose() - d11)));
            i11--;
        }
        return (float) Math.sqrt((double) (f11 / f13));
    }

    public static void c(List<KlineInfo> list, int i11, int i12) {
        if (i11 != 0 && i12 != 0 && !UtilCollections.f(list) && list.size() >= i11) {
            for (int i13 = i11 - 1; i13 < list.size(); i13++) {
                float d11 = d(list, i13, i11);
                float f11 = (float) i12;
                float b11 = d11 - (f11 * b(list, i13, i11));
                list.get(i13).setBollHigh((double) ((b(list, i13, i11) * f11) + d11));
                list.get(i13).setBollMid((double) d11);
                list.get(i13).setBollLow((double) b11);
            }
        }
    }

    public static float d(List<KlineInfo> list, int i11, int i12) {
        float f11 = 0.0f;
        for (int i13 = i11; i13 >= (i11 - i12) + 1; i13--) {
            f11 = (float) (((double) f11) + list.get(i13).getClose());
        }
        return f11 / ((float) i12);
    }

    public static double e(List<KlineInfo> list, List<HashMap<String, Double>> list2, int i11, String str, int i12) {
        double d11 = 0.0d;
        for (int i13 = i11; i13 >= (i11 - i12) + 1; i13--) {
            d11 += ((Double) list2.get(i13).get(str)).doubleValue();
        }
        return d11 / ((double) i12);
    }

    public static float f(List<KlineInfo> list, int i11, int i12, int i13, float f11, boolean z11) {
        float f12 = 0.0f;
        if (z11) {
            int i14 = i11 - 1;
            while (i14 <= (i12 + i11) - 2) {
                try {
                    f12 = (float) (((double) f12) + list.get(i14).getDif());
                    i14++;
                } catch (Exception unused) {
                    return f12;
                }
            }
            return f12 / ((float) i12);
        }
        return (float) ((((double) (f11 * ((float) (i12 - 1)))) + (list.get(i13).getDif() * 2.0d)) / ((double) (i12 + 1)));
    }

    public static float g(List<KlineInfo> list, int i11, int i12, float f11) {
        int i13 = i12 + 1;
        float f12 = 0.0f;
        if (i13 < i11) {
            return 0.0f;
        }
        if (i13 == i11) {
            int i14 = 0;
            while (i14 < i11) {
                try {
                    f12 = (float) (((double) f12) + list.get(i14).getClose());
                    i14++;
                } catch (Exception unused) {
                    return f12;
                }
            }
            return f12 / ((float) i11);
        }
        return (float) ((((double) (f11 * ((float) (i11 - 1)))) + (list.get(i12).getClose() * 2.0d)) / ((double) (i11 + 1)));
    }

    public static void h(List<KlineInfo> list, List<HashMap<Integer, Double>> list2, int i11) {
        if (!UtilCollections.f(list) && list.size() >= i11 && i11 > 0) {
            double close = list.get(0).getClose();
            for (int i12 = 1; i12 < list.size(); i12++) {
                close = ((close * ((double) (i11 - 1))) + (list.get(i12).getClose() * 2.0d)) / ((double) (i11 + 1));
                if (i12 >= i11) {
                    list2.get(i12).put(Integer.valueOf(i11), Double.valueOf(close));
                }
            }
        }
    }

    public static float i(List<KlineInfo> list, List<HashMap<String, Double>> list2, int i11, int i12, int i13) {
        List<KlineInfo> list3 = list;
        int i14 = i13;
        double d11 = 0.0d;
        for (int i15 = 0; i15 < i14; i15++) {
            int i16 = i11 - i15;
            double d12 = 0.0d;
            double d13 = 0.0d;
            for (int i17 = i16; i17 >= (i16 - i12) + 1; i17--) {
                double high = list3.get(i17).getHigh();
                if (i17 == i16 || d12 < high) {
                    d12 = high;
                }
                double low = list3.get(i17).getLow();
                if (i17 == i16 || d13 > low) {
                    d13 = low;
                }
            }
            d11 += a(list3.get(i16).getClose(), d12, d13);
        }
        return (float) (d11 / ((double) i14));
    }

    public static void j(List<KlineInfo> list, List<HashMap<String, Double>> list2, DataSetIndex dataSetIndex, DataSetIndex dataSetIndex2, DataSetIndex dataSetIndex3) {
        int i11 = 0;
        int d11 = dataSetIndex != null ? dataSetIndex.d() : 0;
        int d12 = dataSetIndex2 != null ? dataSetIndex2.d() : 0;
        if (dataSetIndex3 != null) {
            i11 = dataSetIndex3.d();
        }
        if (d11 > 0 && d12 > 0 && i11 > 0 && !UtilCollections.f(list) && list.size() > d11) {
            int i12 = d11 + d12;
            int i13 = (i12 + i11) - 3;
            String str = dataSetIndex.c() + d11;
            String str2 = dataSetIndex2.c() + d12;
            String str3 = dataSetIndex3.c() + i11;
            for (int i14 = i12 - 2; i14 < list.size(); i14++) {
                Double d13 = (Double) list2.get(i14).get(Integer.valueOf(d11));
                if (d13 == null || d13.doubleValue() == 0.0d) {
                    list2.get(i14).put(str, Double.valueOf((double) i(list, list2, i14, d11, d12)));
                }
            }
            for (int i15 = i13; i15 < list.size(); i15++) {
                Double d14 = (Double) list2.get(i15).get(Integer.valueOf(d12));
                if (d14 == null || d14.doubleValue() == 0.0d) {
                    list2.get(i15).put(str2, Double.valueOf(e(list, list2, i15, str, i11)));
                }
            }
            while (i13 < list.size()) {
                Double d15 = (Double) list2.get(i13).get(Integer.valueOf(i11));
                if (d15 == null || d15.doubleValue() == 0.0d) {
                    list2.get(i13).put(str3, Double.valueOf((((Double) list2.get(i13).get(str)).doubleValue() * 3.0d) - (((Double) list2.get(i13).get(str2)).doubleValue() * 2.0d)));
                }
                i13++;
            }
        }
    }

    public static void k(List<KlineInfo> list, List<HashMap<Integer, Double>> list2, int i11, boolean z11, boolean z12) {
        double d11;
        double d12;
        HashMap hashMap;
        if (!UtilCollections.f(list) && list.size() >= i11 && i11 > 0) {
            int i12 = i11 - 1;
            Double d13 = (Double) list2.get(i12).get(Integer.valueOf(i11));
            int i13 = 0;
            double d14 = 0.0d;
            if (d13 == null || d13.doubleValue() == 0.0d) {
                while (i13 < list.size()) {
                    if (i13 < i11) {
                        d11 = t(list.get(i13), z11, z12);
                    } else {
                        d11 = t(list.get(i13), z11, z12) - t(list.get(i13 - i11), z11, z12);
                    }
                    d14 += d11;
                    if (i13 >= i12) {
                        list2.get(i13).put(Integer.valueOf(i11), Double.valueOf(d14 / ((double) i11)));
                    }
                    i13++;
                }
                return;
            }
            int s11 = s(list, list2, i11);
            Double d15 = null;
            int i14 = s11 - 1;
            if (i14 >= 0 && i14 < list2.size() && (hashMap = list2.get(i14)) != null) {
                d15 = (Double) hashMap.get(Integer.valueOf(i11));
            }
            if (d15 == null || d15.doubleValue() < 0.0d) {
                while (i13 < list.size()) {
                    if (i13 < i11) {
                        d12 = t(list.get(i13), z11, z12);
                    } else {
                        d12 = t(list.get(i13), z11, z12) - t(list.get(i13 - i11), z11, z12);
                    }
                    d14 += d12;
                    if (i13 >= i12) {
                        list2.get(i13).put(Integer.valueOf(i11), Double.valueOf(d14 / ((double) i11)));
                    }
                    i13++;
                }
                return;
            }
            double d16 = (double) i11;
            double doubleValue = d15.doubleValue() * d16;
            if (s11 < list.size()) {
                while (s11 < list.size()) {
                    doubleValue += t(list.get(s11), z11, z12) - t(list.get(s11 - i11), z11, z12);
                    if (s11 >= i12) {
                        list2.get(s11).put(Integer.valueOf(i11), Double.valueOf(doubleValue / d16));
                    }
                    s11++;
                }
            }
        }
    }

    public static void l(List<KlineInfo> list, int i11, int i12, int i13) {
        int i14;
        int i15;
        if (i11 > 0 && i12 > 0 && i13 > 0 && !UtilCollections.f(list) && list.size() >= (i13 + i12) - 2) {
            int i16 = 0;
            while (true) {
                i15 = i12 - 1;
                if (i16 >= i15) {
                    break;
                }
                list.get(i16).setDif(0.0d);
                i16++;
            }
            float f11 = 0.0f;
            float f12 = 0.0f;
            for (int i17 = 0; i17 < list.size(); i17++) {
                if (i17 >= i11 - 1) {
                    f11 = g(list, i11, i17, f11);
                    if (i17 >= i15) {
                        f12 = g(list, i12, i17, f12);
                        list.get(i17).setDif((double) (f11 - f12));
                    }
                }
            }
            for (int i18 = 0; i18 < i14; i18++) {
                list.get(i18).setDea(0.0d);
            }
            int i19 = 0;
            float f13 = 0.0f;
            while (i19 < list.size()) {
                if (i19 >= i14) {
                    float f14 = f(list, i12, i13, i19, f13, i19 == i14);
                    list.get(i19).setDea((double) f14);
                    f13 = f14;
                }
                i19++;
            }
            for (int i21 = 0; i21 < i14; i21++) {
                list.get(i21).setMacd(0.0d);
            }
            for (int i22 = 0; i22 < list.size(); i22++) {
                if (i22 >= i14) {
                    list.get(i22).setMacd(list.get(i22).getDif() - list.get(i22).getDea());
                }
            }
        }
    }

    public static double m(double d11, double d12) {
        if (d12 == 0.0d) {
            return 100.0d;
        }
        if (d11 == 0.0d) {
            return 0.0d;
        }
        return 100.0d - (100.0d / ((d11 / d12) + 1.0d));
    }

    public static void n(List<KlineInfo> list, List<HashMap<Integer, Double>> list2, int i11) {
        if (!UtilCollections.f(list) && list.size() > i11) {
            Double d11 = (Double) list2.get(i11 - 1).get(Integer.valueOf(i11));
            if (d11 == null || d11.doubleValue() == 0.0d) {
                o(list, list2, i11, 0, list.size());
            } else {
                o(list, list2, i11, s(list, list2, i11), list.size());
            }
        }
    }

    public static void o(List<KlineInfo> list, List<HashMap<Integer, Double>> list2, int i11, int i12, int i13) {
        double d11;
        List<HashMap<Integer, Double>> list3;
        double d12;
        List<KlineInfo> list4 = list;
        int i14 = i11;
        int i15 = i12;
        int i16 = i13;
        double d13 = 0.0d;
        double d14 = 0.0d;
        while (i15 < i16) {
            if (i15 == i14) {
                int i17 = 1;
                double d15 = 0.0d;
                double d16 = 0.0d;
                while (i17 <= i14) {
                    double close = list4.get(i17).getClose();
                    double close2 = list4.get(i17 - 1).getClose();
                    d15 += Math.max(close - close2, 0.0d);
                    d16 += Math.max(close2 - close, 0.0d);
                    i17++;
                    i15 = i15;
                    int i18 = i13;
                }
                int i19 = i15;
                double d17 = (double) i14;
                double d18 = d15 / d17;
                d14 = d16 / d17;
                d11 = d18;
                list3 = list2;
                d12 = m(d18, d14);
                i15 = i19;
            } else if (i15 > i14) {
                double close3 = list4.get(i15).getClose();
                double close4 = list4.get(i15 - 1).getClose();
                double max = Math.max(close3 - close4, 0.0d);
                double max2 = Math.max(close4 - close3, 0.0d);
                double d19 = (double) (i14 - 1);
                double d21 = (double) i14;
                d11 = (max + (d13 * d19)) / d21;
                d14 = (max2 + (d19 * d14)) / d21;
                d12 = m(d11, d14);
                list3 = list2;
            } else {
                d11 = d13;
                list3 = list2;
                d12 = 0.0d;
            }
            list3.get(i15).put(Integer.valueOf(i11), Double.valueOf(d12));
            i15++;
            i16 = i13;
            d13 = d11;
        }
    }

    public static float p(List<KlineInfo> list, int i11, int i12) {
        double d11 = 0.0d;
        double d12 = 0.0d;
        for (int i13 = i11; i13 >= (i11 - i12) + 1; i13--) {
            double high = list.get(i13).getHigh();
            if (i13 == i11 || d11 < high) {
                d11 = high;
            }
            double low = list.get(i13).getLow();
            if (i13 == i11 || d12 > low) {
                d12 = low;
            }
        }
        if (d11 == d12) {
            d11 += 1.0d;
        }
        return (float) (((d11 - list.get(i11).getClose()) * 100.0d) / (d11 - d12));
    }

    public static void q(List<KlineInfo> list, List<HashMap<Integer, Double>> list2, int i11) {
        if (!UtilCollections.f(list) && list.size() > i11) {
            Double d11 = (Double) list2.get(i11 - 1).get(Integer.valueOf(i11));
            int i12 = 0;
            if (d11 == null || d11.doubleValue() == 0.0d) {
                r(list, list2, i11, 0, list.size());
                return;
            }
            int s11 = s(list, list2, i11);
            if (s11 == list.size()) {
                i12 = 1;
            }
            r(list, list2, i11, s11 - i12, list.size());
        }
    }

    public static void r(List<KlineInfo> list, List<HashMap<Integer, Double>> list2, int i11, int i12, int i13) {
        while (i12 < i13) {
            double d11 = 0.0d;
            if (i12 >= i11 - 1) {
                d11 = (double) p(list, i12, i11);
            }
            list2.get(i12).put(Integer.valueOf(i11), Double.valueOf(d11));
            i12++;
        }
    }

    public static int s(List<KlineInfo> list, List<HashMap<Integer, Double>> list2, int i11) {
        int size = list.size() - 1;
        while (true) {
            if (size > 0) {
                Double d11 = (Double) list2.get(size).get(Integer.valueOf(i11));
                if (d11 != null && d11.doubleValue() != 0.0d) {
                    break;
                }
                size--;
            } else {
                size = 0;
                break;
            }
        }
        return size == list.size() ? size - 1 : size;
    }

    public static double t(KlineInfo klineInfo, boolean z11, boolean z12) {
        if (z11) {
            return klineInfo.getClose();
        }
        if (z12) {
            return klineInfo.getVol();
        }
        return klineInfo.getAmount();
    }

    public static double u(List<KlineInfo> list, int i11, int i12, boolean z11) {
        double d11 = -9.223372036854776E18d;
        while (i11 <= i12) {
            KlineInfo klineInfo = list.get(i11);
            double[] dArr = new double[2];
            dArr[0] = d11;
            dArr[1] = z11 ? klineInfo.getVol() : klineInfo.getAmount();
            d11 = C(true, dArr);
            i11++;
        }
        return d11;
    }

    public static double[] v(List<KlineInfo> list, List<HashMap<Integer, Double>> list2, int i11, int i12, Map<Long, KlineFixInfo> map) {
        Double d11;
        Double d12;
        List<HashMap<Integer, Double>> list3 = list2;
        Map<Long, KlineFixInfo> map2 = map;
        int i13 = 2;
        double[] dArr = new double[2];
        double d13 = 9.223372036854776E18d;
        double d14 = -9.223372036854776E18d;
        int i14 = i11;
        while (true) {
            char c11 = 0;
            if (i14 <= i12) {
                KlineInfo klineInfo = list.get(i14);
                KlineFixInfo klineFixInfo = map2 != null ? map2.get(Long.valueOf(klineInfo.getId())) : null;
                double high = (klineFixInfo == null || (d12 = klineFixInfo.target_high) == null) ? klineInfo.getHigh() : d12.doubleValue();
                double low = (klineFixInfo == null || (d11 = klineFixInfo.target_low) == null) ? klineInfo.getLow() : d11.doubleValue();
                if (list3 != null) {
                    HashMap hashMap = list3.get(i14);
                    if (hashMap.size() > 0) {
                        for (Map.Entry entry : hashMap.entrySet()) {
                            if (entry != null && entry.getValue() != null && ((Double) entry.getValue()).doubleValue() > 0.0d) {
                                double[] dArr2 = new double[3];
                                dArr2[c11] = ((Double) entry.getValue()).doubleValue();
                                dArr2[1] = d14;
                                dArr2[2] = high;
                                double C = C(true, dArr2);
                                i13 = 2;
                                d13 = D(true, ((Double) entry.getValue()).doubleValue(), d13, low);
                                d14 = C;
                            }
                            c11 = 0;
                        }
                    } else {
                        double[] dArr3 = new double[i13];
                        dArr3[0] = d14;
                        dArr3[1] = high;
                        d14 = C(true, dArr3);
                        double[] dArr4 = new double[i13];
                        dArr4[0] = d13;
                        dArr4[1] = low;
                        d13 = D(true, dArr4);
                    }
                } else {
                    double[] dArr5 = new double[i13];
                    dArr5[0] = d14;
                    dArr5[1] = high;
                    d14 = C(true, dArr5);
                    double[] dArr6 = new double[i13];
                    dArr6[0] = d13;
                    dArr6[1] = low;
                    d13 = D(true, dArr6);
                }
                i14++;
            } else {
                dArr[0] = d14;
                dArr[1] = d13;
                return dArr;
            }
        }
    }

    public static int[] w(List<KlineInfo> list, int i11, int i12) {
        int[] iArr = new int[2];
        double d11 = -9.223372036854776E18d;
        double d12 = 9.223372036854776E18d;
        while (i11 <= i12) {
            KlineInfo klineInfo = list.get(i11);
            if (klineInfo.getHigh() > d11) {
                d11 = klineInfo.getHigh();
                iArr[0] = i11;
            }
            if (klineInfo.getLow() < d12) {
                d12 = klineInfo.getLow();
                iArr[1] = i11;
            }
            i11++;
        }
        return iArr;
    }

    public static double[] x(List<KlineInfo> list, List<HashMap<Integer, Double>> list2, int i11, int i12, boolean z11) {
        List<HashMap<Integer, Double>> list3 = list2;
        int i13 = 2;
        double[] dArr = new double[2];
        double d11 = 9.223372036854776E18d;
        double d12 = -9.223372036854776E18d;
        for (int i14 = i11; i14 <= i12; i14++) {
            KlineInfo klineInfo = list.get(i14);
            if (list3 == null || list2.size() == 0) {
                double[] dArr2 = new double[i13];
                dArr2[0] = d12;
                dArr2[1] = z11 ? klineInfo.getVol() : klineInfo.getAmount();
                d12 = C(true, dArr2);
                double[] dArr3 = new double[i13];
                dArr3[0] = d11;
                dArr3[1] = z11 ? klineInfo.getVol() : klineInfo.getAmount();
                d11 = D(true, dArr3);
            } else {
                HashMap hashMap = list3.get(i14);
                if (hashMap.size() > 0) {
                    for (Map.Entry entry : hashMap.entrySet()) {
                        if (entry == null || entry.getValue() == null || ((Double) entry.getValue()).doubleValue() <= 0.0d) {
                            int i15 = i13;
                            double[] dArr4 = new double[i15];
                            dArr4[0] = d12;
                            dArr4[1] = z11 ? klineInfo.getVol() : klineInfo.getAmount();
                            d12 = C(true, dArr4);
                            double[] dArr5 = new double[i15];
                            dArr5[0] = d11;
                            dArr5[1] = z11 ? klineInfo.getVol() : klineInfo.getAmount();
                            d11 = D(true, dArr5);
                        } else {
                            double[] dArr6 = new double[3];
                            dArr6[0] = ((Double) entry.getValue()).doubleValue();
                            dArr6[1] = d12;
                            dArr6[2] = z11 ? klineInfo.getVol() : klineInfo.getAmount();
                            d12 = C(true, dArr6);
                            double[] dArr7 = new double[3];
                            dArr7[0] = ((Double) entry.getValue()).doubleValue();
                            dArr7[1] = d11;
                            dArr7[2] = z11 ? klineInfo.getVol() : klineInfo.getAmount();
                            d11 = D(true, dArr7);
                        }
                        i13 = 2;
                    }
                } else {
                    double[] dArr8 = new double[i13];
                    dArr8[0] = d12;
                    dArr8[1] = z11 ? klineInfo.getVol() : klineInfo.getAmount();
                    d12 = C(true, dArr8);
                    double[] dArr9 = new double[i13];
                    dArr9[0] = d11;
                    dArr9[1] = z11 ? klineInfo.getVol() : klineInfo.getAmount();
                    d11 = D(true, dArr9);
                }
                i13 = 2;
            }
        }
        dArr[0] = d12;
        dArr[1] = d11;
        return dArr;
    }

    public static double[] y(List<HashMap<Integer, Double>> list, int i11, int i12) {
        double[] dArr = new double[2];
        double d11 = -9.223372036854776E18d;
        double d12 = 9.223372036854776E18d;
        while (i11 <= i12) {
            for (Map.Entry entry : list.get(i11).entrySet()) {
                if (!(entry == null || entry.getValue() == null)) {
                    if (((Double) entry.getValue()).doubleValue() > d11) {
                        d11 = ((Double) entry.getValue()).doubleValue();
                    }
                    if (((Double) entry.getValue()).doubleValue() < d12) {
                        d12 = ((Double) entry.getValue()).doubleValue();
                    }
                }
            }
            i11++;
        }
        dArr[0] = d11;
        dArr[1] = d12;
        return dArr;
    }

    public static double[] z(List<HashMap<String, Double>> list, int i11, int i12) {
        double[] dArr = new double[2];
        double d11 = -9.223372036854776E18d;
        double d12 = 9.223372036854776E18d;
        while (i11 <= i12) {
            for (Map.Entry entry : list.get(i11).entrySet()) {
                if (!(entry == null || entry.getValue() == null)) {
                    if (((Double) entry.getValue()).doubleValue() > d11) {
                        d11 = ((Double) entry.getValue()).doubleValue();
                    }
                    if (((Double) entry.getValue()).doubleValue() < d12) {
                        d12 = ((Double) entry.getValue()).doubleValue();
                    }
                }
            }
            i11++;
        }
        dArr[0] = d11;
        dArr[1] = d12;
        return dArr;
    }
}
