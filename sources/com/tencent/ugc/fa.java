package com.tencent.ugc;

import com.tencent.ugc.TXRecordCommon;

final /* synthetic */ class fa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final int f50500a;

    /* renamed from: b  reason: collision with root package name */
    private final String f50501b;

    /* renamed from: c  reason: collision with root package name */
    private final String f50502c;

    /* renamed from: d  reason: collision with root package name */
    private final String f50503d;

    /* renamed from: e  reason: collision with root package name */
    private final TXRecordCommon.ITXVideoRecordListener f50504e;

    private fa(int i11, String str, String str2, String str3, TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        this.f50500a = i11;
        this.f50501b = str;
        this.f50502c = str2;
        this.f50503d = str3;
        this.f50504e = iTXVideoRecordListener;
    }

    public static Runnable a(int i11, String str, String str2, String str3, TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        return new fa(i11, str, str2, str3, iTXVideoRecordListener);
    }

    public final void run() {
        UGCRecorderJni.lambda$onRecordComplete$1(this.f50500a, this.f50501b, this.f50502c, this.f50503d, this.f50504e);
    }
}
