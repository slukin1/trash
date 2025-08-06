package com.tencent.ugc.decoder;

final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final DecodeAbilityProvider f50330a;

    private a(DecodeAbilityProvider decodeAbilityProvider) {
        this.f50330a = decodeAbilityProvider;
    }

    public static Runnable a(DecodeAbilityProvider decodeAbilityProvider) {
        return new a(decodeAbilityProvider);
    }

    public final void run() {
        this.f50330a.updateDecoderAbility();
    }
}
