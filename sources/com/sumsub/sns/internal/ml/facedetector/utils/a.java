package com.sumsub.sns.internal.ml.facedetector.utils;

import com.sumsub.sns.internal.ml.facedetector.models.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f35129a = new a();

    public final double a(double d11, double d12, int i11, int i12) {
        return i12 == 1 ? (d11 + d12) * 0.5d : d11 + ((((d12 - d11) * 1.0d) * ((double) i11)) / ((double) (((float) i12) - 1.0f)));
    }

    public final List<com.sumsub.sns.internal.ml.facedetector.models.a> a(b bVar) {
        int i11;
        int i12;
        ArrayList arrayList;
        int i13;
        ArrayList arrayList2;
        double d11;
        double d12;
        boolean z11 = true;
        if (bVar.k() > 0) {
            int k11 = bVar.k();
            List<Integer> l11 = bVar.l();
            Objects.requireNonNull(l11);
            if (k11 == l11.size()) {
                ArrayList arrayList3 = new ArrayList();
                int i14 = 0;
                while (i14 < bVar.k()) {
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    ArrayList arrayList6 = new ArrayList();
                    ArrayList arrayList7 = new ArrayList();
                    int i15 = i14;
                    while (true) {
                        double d13 = 1.0d;
                        if (i15 >= bVar.l().size() || bVar.l().get(i15).intValue() != bVar.l().get(i14).intValue()) {
                            int size = arrayList6.size();
                        } else {
                            double a11 = a(bVar.j(), bVar.i(), i15, bVar.l().size());
                            if (i15 != 0 || !bVar.n()) {
                                int size2 = bVar.c().size();
                                for (int i16 = 0; i16 < size2; i16++) {
                                    arrayList6.add(bVar.c().get(i16));
                                    arrayList7.add(Double.valueOf(a11));
                                }
                                if (bVar.h() > 0.0d) {
                                    if (i15 != bVar.l().size() - (z11 ? 1 : 0)) {
                                        d13 = a(bVar.j(), bVar.i(), i15, bVar.l().size());
                                    }
                                    arrayList7.add(Double.valueOf(Math.sqrt(a11 * d13)));
                                    arrayList6.add(Double.valueOf(bVar.h()));
                                }
                            } else {
                                arrayList6.add(Double.valueOf(1.0d));
                                arrayList6.add(Double.valueOf(2.0d));
                                arrayList6.add(Double.valueOf(0.5d));
                                arrayList7.add(Double.valueOf(0.1d));
                                arrayList7.add(Double.valueOf(a11));
                                arrayList7.add(Double.valueOf(a11));
                            }
                            i15++;
                        }
                    }
                    int size3 = arrayList6.size();
                    for (int i17 = 0; i17 < size3; i17++) {
                        double sqrt = Math.sqrt(((Number) arrayList6.get(i17)).doubleValue());
                        arrayList4.add(Double.valueOf(((Number) arrayList7.get(i17)).doubleValue() / sqrt));
                        arrayList5.add(Double.valueOf(((Number) arrayList7.get(i17)).doubleValue() * sqrt));
                    }
                    if (bVar.d().isEmpty() ^ z11) {
                        i11 = bVar.d().get(i14).intValue();
                        i12 = bVar.e().get(i14).intValue();
                    } else {
                        double intValue = (double) bVar.l().get(i14).intValue();
                        i11 = (int) Math.ceil((((double) bVar.f()) * 1.0d) / intValue);
                        i12 = (int) Math.ceil((((double) bVar.g()) * 1.0d) / intValue);
                    }
                    int i18 = 0;
                    while (i18 < i11) {
                        for (int i19 = 0; i19 < i12; i19++) {
                            int size4 = arrayList4.size();
                            int i21 = 0;
                            while (i21 < size4) {
                                double a12 = ((((double) i19) + bVar.a()) * 1.0d) / ((double) i12);
                                double b11 = ((((double) i18) + bVar.b()) * 1.0d) / ((double) i11);
                                if (bVar.m()) {
                                    i13 = i12;
                                    arrayList2 = arrayList4;
                                    arrayList = arrayList5;
                                    d12 = 1.0d;
                                    d11 = 1.0d;
                                } else {
                                    d12 = ((Number) arrayList5.get(i21)).doubleValue();
                                    arrayList = arrayList5;
                                    i13 = i12;
                                    arrayList2 = arrayList4;
                                    d11 = ((Number) arrayList4.get(i21)).doubleValue();
                                }
                                arrayList3.add(new com.sumsub.sns.internal.ml.facedetector.models.a((float) a12, (float) b11, (float) d12, (float) d11));
                                i21++;
                                arrayList4 = arrayList2;
                                i12 = i13;
                                arrayList5 = arrayList;
                            }
                            int i22 = i12;
                            ArrayList arrayList8 = arrayList4;
                            ArrayList arrayList9 = arrayList5;
                        }
                        int i23 = i12;
                        ArrayList arrayList10 = arrayList4;
                        ArrayList arrayList11 = arrayList5;
                        i18++;
                        z11 = true;
                    }
                    i14 = i15;
                }
                return arrayList3;
            }
            throw new IllegalArgumentException("Strides size must equal to NumLayers".toString());
        }
        throw new IllegalArgumentException(("NumLayers must be greater than 0, numLayers: " + bVar.k()).toString());
    }
}
