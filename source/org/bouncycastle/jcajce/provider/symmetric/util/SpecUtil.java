package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.AlgorithmParameters;
import java.security.spec.AlgorithmParameterSpec;

class SpecUtil {
    public static AlgorithmParameterSpec extractSpec(AlgorithmParameters algorithmParameters, Class[] clsArr) {
        try {
            return algorithmParameters.getParameterSpec(AlgorithmParameterSpec.class);
        } catch (Exception unused) {
            for (int i11 = 0; i11 != clsArr.length; i11++) {
                if (clsArr[i11] != null) {
                    try {
                        return algorithmParameters.getParameterSpec(clsArr[i11]);
                    } catch (Exception unused2) {
                    }
                }
            }
            return null;
        }
    }
}
