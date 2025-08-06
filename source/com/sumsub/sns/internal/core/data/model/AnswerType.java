package com.sumsub.sns.internal.core.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/AnswerType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "Ignored", "Red", "Yellow", "Green", "Error", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public enum AnswerType {
    Ignored("IGNORED"),
    Red("RED"),
    Yellow("YELLOW"),
    Green("GREEN"),
    Error("ERROR");
    
    public static final a Companion = null;
    private final String value;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final AnswerType a(String str) {
            AnswerType answerType;
            AnswerType[] values = AnswerType.values();
            int length = values.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    answerType = null;
                    break;
                }
                answerType = values[i11];
                if (x.b(answerType.getValue(), str)) {
                    break;
                }
                i11++;
            }
            return answerType == null ? AnswerType.Error : answerType;
        }

        public a() {
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new a((r) null);
    }

    private AnswerType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
