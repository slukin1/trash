package com.sumsub.sns.core.widget.autocompletePhone;

import java.util.Comparator;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* renamed from: com.sumsub.sns.core.widget.autocompletePhone.PhoneNumberKitV2$_init_$lambda-8$$inlined$sortedBy$1  reason: invalid class name */
public final class PhoneNumberKitV2$_init_$lambda8$$inlined$sortedBy$1<T> implements Comparator {
    public final int compare(T t11, T t12) {
        String str = (String) t11;
        int i11 = 0;
        for (int i12 = 0; i12 < str.length(); i12++) {
            if (Character.isDigit(str.charAt(i12))) {
                i11++;
            }
        }
        Integer valueOf = Integer.valueOf(i11);
        String str2 = (String) t12;
        int i13 = 0;
        for (int i14 = 0; i14 < str2.length(); i14++) {
            if (Character.isDigit(str2.charAt(i14))) {
                i13++;
            }
        }
        return ComparisonsKt__ComparisonsKt.a(valueOf, Integer.valueOf(i13));
    }
}
