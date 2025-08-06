package com.sumsub.sns.internal.fingerprint.tools.threading.safe;

import d10.l;
import java.util.List;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.Lambda;

public final class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public final List<StackTraceElement> f34674a;

    /* renamed from: com.sumsub.sns.internal.fingerprint.tools.threading.safe.a$a  reason: collision with other inner class name */
    public static final class C0393a extends Lambda implements l<StackTraceElement, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public static final C0393a f34675a = new C0393a();

        public C0393a() {
            super(1);
        }

        /* renamed from: a */
        public final CharSequence invoke(StackTraceElement stackTraceElement) {
            return stackTraceElement.toString();
        }
    }

    public a(TimeoutException timeoutException, List<StackTraceElement> list) {
        super(timeoutException);
        this.f34674a = list;
    }

    public final List<StackTraceElement> a() {
        return this.f34674a;
    }

    public String getMessage() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("The execution took too long to complete. Original exception: ");
        sb2.append(getCause());
        sb2.append(", execution thread stacktrace: ");
        List<StackTraceElement> list = this.f34674a;
        sb2.append(list != null ? CollectionsKt___CollectionsKt.k0(list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, C0393a.f34675a, 31, (Object) null) : null);
        sb2.append('.');
        return sb2.toString();
    }
}
