package com.sensorsdata.analytics.android.sdk.encrypt;

import com.sumsub.sns.internal.core.common.k;
import com.sumsub.sns.prooface.network.b;

enum SymmetricEncryptMode {
    AES(b.f40261d, k.f32093a),
    SM4("SM4", "SM4/CBC/PKCS5Padding");
    
    public String algorithm;
    public String transformation;

    private SymmetricEncryptMode(String str, String str2) {
        this.algorithm = str;
        this.transformation = str2;
    }
}
