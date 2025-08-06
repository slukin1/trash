package com.sumsub.sns.core.widget.autocompletePhone;

import com.sumsub.sns.internal.core.data.model.remote.c;
import java.util.Comparator;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class PhoneNumberViewController$detectFormat$$inlined$sortedByDescending$1<T> implements Comparator {
    public final /* synthetic */ PhoneNumberViewController this$0;

    public PhoneNumberViewController$detectFormat$$inlined$sortedByDescending$1(PhoneNumberViewController phoneNumberViewController) {
        this.this$0 = phoneNumberViewController;
    }

    public final int compare(T t11, T t12) {
        Integer num;
        c cVar = this.this$0.getPhoneCountryCodeWithMasks().get((String) t12);
        Integer num2 = null;
        if (cVar != null) {
            String c11 = cVar.c();
            if (c11 != null) {
                num = Integer.valueOf(c11.length());
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        } else {
            num = null;
        }
        c cVar2 = this.this$0.getPhoneCountryCodeWithMasks().get((String) t11);
        if (cVar2 != null) {
            String c12 = cVar2.c();
            if (c12 != null) {
                num2 = Integer.valueOf(c12.length());
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        return ComparisonsKt__ComparisonsKt.a(num, num2);
    }
}
