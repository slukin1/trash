package com.hbg.lib.widgets.ticker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LevenshteinUtils {
    public static void a(List<Integer> list, char[] cArr, char[] cArr2, int i11, int i12, int i13, int i14) {
        List<Integer> list2 = list;
        int i15 = i12 - i11;
        int i16 = i14 - i13;
        int max = Math.max(i15, i16);
        if (i15 == i16) {
            c(list2, max, 0);
            return;
        }
        int i17 = i15 + 1;
        int i18 = i16 + 1;
        int[] iArr = new int[2];
        iArr[1] = i18;
        iArr[0] = i17;
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
        for (int i19 = 0; i19 < i17; i19++) {
            iArr2[i19][0] = i19;
        }
        for (int i21 = 0; i21 < i18; i21++) {
            iArr2[0][i21] = i21;
        }
        for (int i22 = 1; i22 < i17; i22++) {
            for (int i23 = 1; i23 < i18; i23++) {
                int i24 = i22 - 1;
                int i25 = i23 - 1;
                iArr2[i22][i23] = e(iArr2[i24][i23] + 1, iArr2[i22][i25] + 1, iArr2[i24][i25] + (cArr[i24 + i11] == cArr2[i25 + i13] ? 0 : 1));
            }
        }
        ArrayList arrayList = new ArrayList(max * 2);
        int i26 = i17 - 1;
        int i27 = i18 - 1;
        while (true) {
            if (i26 <= 0 && i27 <= 0) {
                break;
            }
            if (i26 == 0) {
                arrayList.add(1);
            } else {
                if (i27 == 0) {
                    arrayList.add(2);
                } else {
                    int i28 = i27 - 1;
                    int i29 = iArr2[i26][i28];
                    int i30 = i26 - 1;
                    int i31 = iArr2[i30][i27];
                    int i32 = iArr2[i30][i28];
                    if (i29 < i31 && i29 < i32) {
                        arrayList.add(1);
                    } else if (i31 < i32) {
                        arrayList.add(2);
                    } else {
                        arrayList.add(0);
                        i26--;
                    }
                }
                i26--;
            }
            i27--;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            list2.add((Integer) arrayList.get(size));
        }
    }

    public static int[] b(char[] cArr, char[] cArr2, Set<Character> set) {
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            boolean z11 = i11 == cArr.length;
            boolean z12 = i12 == cArr2.length;
            if (z11 && z12) {
                break;
            } else if (z11) {
                c(arrayList, cArr2.length - i12, 1);
                break;
            } else if (z12) {
                c(arrayList, cArr.length - i11, 2);
                break;
            } else {
                boolean contains = set.contains(Character.valueOf(cArr[i11]));
                boolean contains2 = set.contains(Character.valueOf(cArr2[i12]));
                if (!contains || !contains2) {
                    if (contains) {
                        arrayList.add(1);
                    } else if (contains2) {
                        arrayList.add(2);
                        i11++;
                    } else {
                        arrayList.add(0);
                        i11++;
                    }
                    i12++;
                } else {
                    int d11 = d(cArr, i11 + 1, set);
                    int d12 = d(cArr2, i12 + 1, set);
                    a(arrayList, cArr, cArr2, i11, d11, i12, d12);
                    i11 = d11;
                    i12 = d12;
                }
            }
        }
        int[] iArr = new int[arrayList.size()];
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            iArr[i13] = ((Integer) arrayList.get(i13)).intValue();
        }
        return iArr;
    }

    public static void c(List<Integer> list, int i11, int i12) {
        for (int i13 = 0; i13 < i11; i13++) {
            list.add(Integer.valueOf(i12));
        }
    }

    public static int d(char[] cArr, int i11, Set<Character> set) {
        while (i11 < cArr.length) {
            if (!set.contains(Character.valueOf(cArr[i11]))) {
                return i11;
            }
            i11++;
        }
        return cArr.length;
    }

    public static int e(int i11, int i12, int i13) {
        return Math.min(i11, Math.min(i12, i13));
    }
}
