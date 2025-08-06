package com.google.android.exoplayer2;

import com.google.android.exoplayer2.AudioFocusManager;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioFocusManager.AudioFocusListener f65681b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f65682c;

    public /* synthetic */ a(AudioFocusManager.AudioFocusListener audioFocusListener, int i11) {
        this.f65681b = audioFocusListener;
        this.f65682c = i11;
    }

    public final void run() {
        this.f65681b.lambda$onAudioFocusChange$0(this.f65682c);
    }
}
