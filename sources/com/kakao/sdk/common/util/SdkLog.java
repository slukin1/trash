package com.kakao.sdk.common.util;

import com.kakao.sdk.common.KakaoSdk;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.i;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\bB\u0011\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0002R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/kakao/sdk/common/util/SdkLog;", "", "logged", "Lcom/kakao/sdk/common/util/SdkLogLevel;", "logLevel", "", "d", "", "a", "Z", "enabled", "Ljava/util/LinkedList;", "", "b", "Ljava/util/LinkedList;", "logs", "Ljava/text/SimpleDateFormat;", "c", "Lkotlin/i;", "()Ljava/text/SimpleDateFormat;", "dateFormat", "<init>", "(Z)V", "common_release"}, k = 1, mv = {1, 6, 0})
public final class SdkLog {

    /* renamed from: d  reason: collision with root package name */
    public static final a f25100d = new a((r) null);

    /* renamed from: e  reason: collision with root package name */
    public static final i<SdkLog> f25101e = LazyKt__LazyJVMKt.a(SdkLog$Companion$instance$2.INSTANCE);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f25102a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedList<String> f25103b;

    /* renamed from: c  reason: collision with root package name */
    public final i f25104c;

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0005\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0006\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001R!\u0010\u000e\u001a\u00020\u00078FX\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/kakao/sdk/common/util/SdkLog$a;", "", "logged", "", "a", "d", "b", "Lcom/kakao/sdk/common/util/SdkLog;", "instance$delegate", "Lkotlin/i;", "c", "()Lcom/kakao/sdk/common/util/SdkLog;", "getInstance$annotations", "()V", "instance", "", "MAX_SIZE", "I", "<init>", "common_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final void a(Object obj) {
            c().d(obj, SdkLogLevel.D);
        }

        public final void b(Object obj) {
            c().d(obj, SdkLogLevel.E);
        }

        public final SdkLog c() {
            return (SdkLog) SdkLog.f25101e.getValue();
        }

        public final void d(Object obj) {
            c().d(obj, SdkLogLevel.I);
        }
    }

    public SdkLog() {
        this(false, 1, (r) null);
    }

    public SdkLog(boolean z11) {
        this.f25102a = z11;
        this.f25103b = new LinkedList<>();
        this.f25104c = LazyKt__LazyJVMKt.a(SdkLog$dateFormat$2.INSTANCE);
    }

    public final SimpleDateFormat c() {
        return (SimpleDateFormat) this.f25104c.getValue();
    }

    public final void d(Object obj, SdkLogLevel sdkLogLevel) {
        String str = sdkLogLevel.getSymbol() + ' ' + obj;
        if (this.f25102a && sdkLogLevel.compareTo(SdkLogLevel.I) >= 0) {
            this.f25103b.add(c().format(new Date()) + ' ' + str);
            if (this.f25103b.size() > 100) {
                this.f25103b.poll();
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SdkLog(boolean z11, int i11, r rVar) {
        this((i11 & 1) != 0 ? KakaoSdk.f25078a.c() : z11);
    }
}
