package com.sumsub.sns.internal.camera.photo.presentation.document;

import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class DocCapture {

    /* renamed from: a  reason: collision with root package name */
    public static final DocCapture f31490a = new DocCapture();

    /* renamed from: b  reason: collision with root package name */
    public static final String f31491b = "IDENTITY_VIDEO";

    /* renamed from: c  reason: collision with root package name */
    public static final String f31492c = "DocCapture";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/sumsub/sns/internal/camera/photo/presentation/document/DocCapture$PreferredMode;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "MANUAL", "AUTO", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public enum PreferredMode {
        MANUAL("m"),
        AUTO("a");
        
        public static final a Companion = null;
        private final String value;

        public static final class a {
            public /* synthetic */ a(r rVar) {
                this();
            }

            public final PreferredMode a(String str) {
                for (PreferredMode preferredMode : PreferredMode.values()) {
                    if (x.b(preferredMode.getValue(), str)) {
                        return preferredMode;
                    }
                }
                return null;
            }

            public a() {
            }
        }

        /* access modifiers changed from: public */
        static {
            Companion = new a((r) null);
        }

        private PreferredMode(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }
}
