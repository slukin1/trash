package com.sumsub.sns.prooface.presentation;

import androidx.activity.result.ActivityResultCallback;
import java.util.Map;

public final /* synthetic */ class e implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SNSLiveness3dFaceFragment f40329a;

    public /* synthetic */ e(SNSLiveness3dFaceFragment sNSLiveness3dFaceFragment) {
        this.f40329a = sNSLiveness3dFaceFragment;
    }

    public final void onActivityResult(Object obj) {
        SNSLiveness3dFaceFragment.a(this.f40329a, (Map) obj);
    }
}
