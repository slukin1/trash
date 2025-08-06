package com.sumsub.sns.internal.core.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\b\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/FieldType;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "text", "textArea", "phone", "date", "dateTime", "bool", "select", "selectDropdown", "multiSelect", "countrySelect", "fileAttachment", "multiFileAttachments", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public enum FieldType {
    text,
    textArea,
    phone,
    date,
    dateTime,
    bool,
    select,
    selectDropdown,
    multiSelect,
    countrySelect,
    fileAttachment,
    multiFileAttachments;
    
    public static final a Companion = null;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final FieldType a(String str) {
            for (FieldType fieldType : FieldType.values()) {
                if (x.b(fieldType.name(), str)) {
                    return fieldType;
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
}
