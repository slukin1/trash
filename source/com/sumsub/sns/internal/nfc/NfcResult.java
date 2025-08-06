package com.sumsub.sns.internal.nfc;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public abstract class NfcResult {

    public static final class Failed extends NfcResult {

        /* renamed from: a  reason: collision with root package name */
        public final Reason f35132a;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/internal/nfc/NfcResult$Failed$Reason;", "", "(Ljava/lang/String;I)V", "AUTH_FAILED", "READ_FAILED", "TAG_WAS_LOST", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public enum Reason {
            AUTH_FAILED,
            READ_FAILED,
            TAG_WAS_LOST
        }

        public Failed(Reason reason) {
            super((r) null);
            this.f35132a = reason;
        }

        public final Reason a() {
            return this.f35132a;
        }

        public final Reason b() {
            return this.f35132a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failed) && this.f35132a == ((Failed) obj).f35132a;
        }

        public int hashCode() {
            return this.f35132a.hashCode();
        }

        public String toString() {
            return "Failed(reason=" + this.f35132a + ')';
        }

        public final Failed a(Reason reason) {
            return new Failed(reason);
        }

        public static /* synthetic */ Failed a(Failed failed, Reason reason, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                reason = failed.f35132a;
            }
            return failed.a(reason);
        }
    }

    public static final class a extends NfcResult {

        /* renamed from: a  reason: collision with root package name */
        public final List<byte[]> f35133a;

        public a(List<byte[]> list) {
            super((r) null);
            this.f35133a = list;
        }

        public final List<byte[]> a() {
            return this.f35133a;
        }

        public final List<byte[]> b() {
            return this.f35133a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && x.b(this.f35133a, ((a) obj).f35133a);
        }

        public int hashCode() {
            return this.f35133a.hashCode();
        }

        public String toString() {
            return "Success(files=" + this.f35133a + ')';
        }

        public final a a(List<byte[]> list) {
            return new a(list);
        }

        public static /* synthetic */ a a(a aVar, List<byte[]> list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                list = aVar.f35133a;
            }
            return aVar.a(list);
        }
    }

    public /* synthetic */ NfcResult(r rVar) {
        this();
    }

    public NfcResult() {
    }
}
