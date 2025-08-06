package com.sumsub.sns.core.widget.autocompletePhone;

import d10.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "countryIsoCode", "", "invoke", "(Ljava/lang/String;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class PhoneNumberViewController$detectFormat$2$1 extends Lambda implements l<String, Boolean> {
    public final /* synthetic */ String $excludeCountry;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneNumberViewController$detectFormat$2$1(String str) {
        super(1);
        this.$excludeCountry = str;
    }

    public final Boolean invoke(String str) {
        return Boolean.valueOf(x.b(str, this.$excludeCountry));
    }
}
