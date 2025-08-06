package com.sumsub.sns.internal.videoident.videoident.chat;

import android.media.AudioManager;

public final /* synthetic */ class i implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SNSVideoChatController f37083a;

    public /* synthetic */ i(SNSVideoChatController sNSVideoChatController) {
        this.f37083a = sNSVideoChatController;
    }

    public final void onAudioFocusChange(int i11) {
        SNSVideoChatController.a(this.f37083a, i11);
    }
}
