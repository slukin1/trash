package com.sumsub.sns.internal.core.presentation.util;

import android.telephony.PhoneNumberUtils;
import android.text.InputFilter;
import android.text.TextUtils;
import android.widget.EditText;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.data.model.p;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import com.sumsub.sns.internal.core.presentation.screen.base.b;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.x;
import kotlin.text.Regex;

public final class a {
    public static final boolean a(p pVar, String str) {
        if (pVar != null) {
            if (!(str == null || StringsKt__StringsJVMKt.z(str))) {
                if (pVar instanceof p.a) {
                    return a(str);
                }
                if (pVar instanceof p.d) {
                    return ((p.d) pVar).a().a(StringsKt__StringNumberConversionsJVMKt.j(str));
                }
                if (pVar instanceof p.f) {
                    return b.f33883a.a(str);
                }
                double d11 = 0.0d;
                if (pVar instanceof p.h) {
                    Double j11 = StringsKt__StringNumberConversionsJVMKt.j(str);
                    if (j11 != null) {
                        d11 = j11.doubleValue();
                    }
                    if (d11 > ((p.h) pVar).a()) {
                        return false;
                    }
                } else if (pVar instanceof p.j) {
                    Double j12 = StringsKt__StringNumberConversionsJVMKt.j(str);
                    if (j12 != null) {
                        d11 = j12.doubleValue();
                    }
                    if (d11 < ((p.j) pVar).a()) {
                        return false;
                    }
                } else if (pVar instanceof p.k) {
                    return TextUtils.isDigitsOnly(str);
                } else {
                    if (pVar instanceof p.l) {
                        return new Regex(((p.l) pVar).a()).matches(str);
                    }
                    if (pVar instanceof p.m) {
                        return PhoneNumberUtils.isGlobalPhoneNumber(str);
                    }
                    if (pVar instanceof p.g) {
                        if (str.length() > ((p.g) pVar).a()) {
                            return false;
                        }
                    } else if (pVar instanceof p.i) {
                        if (str.length() < ((p.i) pVar).a()) {
                            return false;
                        }
                    } else if (!(pVar instanceof p.c)) {
                        if (pVar instanceof p.b) {
                            return b.f33883a.a(str);
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
        }
        return true;
    }

    public static final boolean a(String str) {
        for (char c11 : str.toCharArray()) {
            if (!Character.isLetter(c11) && !Character.isSpaceChar(c11)) {
                return false;
            }
        }
        return true;
    }

    public static final String a(p pVar, Map<String, String> map, String str, Boolean bool) {
        String str2;
        boolean z11 = false;
        if (x.b(bool, Boolean.TRUE)) {
            if (str != null && StringsKt__StringsJVMKt.z(str)) {
                z11 = true;
            }
        }
        if (z11) {
            str2 = map.get(n0.j.f32208h);
            if (str2 == null) {
                return "";
            }
        } else if (a(pVar, str) || (str2 = map.get(n0.j.f32207g)) == null) {
            return "";
        }
        return str2;
    }

    public static final String a(p pVar, b.c cVar, String str, Boolean bool) {
        return a(pVar, cVar.d(), str, bool);
    }

    public static final Unit a(p pVar, EditText editText) {
        if (pVar instanceof p.g) {
            InputFilter[] inputFilterArr = {new InputFilter.LengthFilter(((p.g) pVar).a())};
            if (editText != null) {
                editText.setFilters(inputFilterArr);
            }
            return Unit.f56620a;
        }
        if (editText != null) {
            editText.setFilters(new InputFilter[0]);
        }
        Integer a11 = a(pVar);
        if (a11 == null) {
            return null;
        }
        int intValue = a11.intValue();
        if (editText != null) {
            editText.setInputType(intValue);
        }
        return Unit.f56620a;
    }

    public static final Integer a(p pVar) {
        boolean z11;
        boolean z12 = true;
        if (pVar instanceof p.h) {
            z11 = true;
        } else {
            z11 = pVar instanceof p.j;
        }
        if (!z11) {
            z12 = pVar instanceof p.d;
        }
        if (z12) {
            return 8194;
        }
        if (pVar instanceof p.k) {
            return 2;
        }
        if (pVar instanceof p.f) {
            return 32;
        }
        if (pVar instanceof p.c) {
            return 8193;
        }
        return pVar instanceof p.b ? 32 : null;
    }
}
