package com.tencent.qcloud.tuikit.tuicallkit.internal;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.tencent.qcloud.tuikit.tuicallkit.internal.TUICallingService;

public final /* synthetic */ class a implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TUICallingService.ResultTUIExtensionEventListener f48575a;

    public /* synthetic */ a(TUICallingService.ResultTUIExtensionEventListener resultTUIExtensionEventListener) {
        this.f48575a = resultTUIExtensionEventListener;
    }

    public final void onActivityResult(Object obj) {
        this.f48575a.lambda$onClicked$0((ActivityResult) obj);
    }
}
