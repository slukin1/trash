package com.sumsub.sns.videoident.presentation;

import androidx.activity.result.ActivityResultCallback;
import java.util.Map;

public final /* synthetic */ class e implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SNSVideoIdentFragment f40335a;

    public /* synthetic */ e(SNSVideoIdentFragment sNSVideoIdentFragment) {
        this.f40335a = sNSVideoIdentFragment;
    }

    public final void onActivityResult(Object obj) {
        SNSVideoIdentFragment.m2294onViewCreated$lambda13(this.f40335a, (Map) obj);
    }
}
