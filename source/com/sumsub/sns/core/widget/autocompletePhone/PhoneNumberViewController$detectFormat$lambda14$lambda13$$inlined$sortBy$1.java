package com.sumsub.sns.core.widget.autocompletePhone;

import java.util.Comparator;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* renamed from: com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberViewController$detectFormat$lambda-14$lambda-13$$inlined$sortBy$1  reason: invalid class name */
public final class PhoneNumberViewController$detectFormat$lambda14$lambda13$$inlined$sortBy$1<T> implements Comparator {
    public final int compare(T t11, T t12) {
        return ComparisonsKt__ComparisonsKt.a(Integer.valueOf(((DetectFormatResult) t11).getMaskLength()), Integer.valueOf(((DetectFormatResult) t12).getMaskLength()));
    }
}
