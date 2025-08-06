package com.sumsub.sns.internal.core.presentation.form.model;

import com.sumsub.sns.internal.core.data.source.applicant.remote.k;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import com.twitter.sdk.android.core.internal.TwitterApiConstants;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;

public final class e {
    public static final FormItem a(FormItem formItem, CharSequence charSequence) {
        boolean z11;
        boolean z12;
        boolean z13;
        if (formItem instanceof FormItem.d) {
            return FormItem.d.a((FormItem.d) formItem, (k) null, (String) null, false, (String) null, charSequence, 15, (Object) null);
        }
        if (formItem instanceof FormItem.e) {
            return FormItem.e.a((FormItem.e) formItem, (k) null, (String) null, (String) null, charSequence, 7, (Object) null);
        }
        if (formItem instanceof FormItem.j) {
            return FormItem.j.a((FormItem.j) formItem, (k) null, (String) null, (List) null, charSequence, false, 23, (Object) null);
        }
        if (formItem instanceof FormItem.m) {
            return FormItem.m.a((FormItem.m) formItem, (k) null, (String) null, (String) null, charSequence, 7, (Object) null);
        }
        if (formItem instanceof FormItem.p) {
            return FormItem.p.a((FormItem.p) formItem, (k) null, (String) null, (String) null, false, charSequence, (List) null, 47, (Object) null);
        }
        if (formItem instanceof FormItem.q) {
            return FormItem.q.a((FormItem.q) formItem, (k) null, (String) null, (String) null, charSequence, 7, (Object) null);
        }
        if (formItem instanceof FormItem.a) {
            return FormItem.a.a((FormItem.a) formItem, (k) null, (String) null, (String) null, charSequence, 7, (Object) null);
        }
        if (formItem instanceof FormItem.g) {
            return FormItem.g.a((FormItem.g) formItem, (k) null, (String) null, (String) null, (String) null, charSequence, (FormItem.ItemState) null, (FormItem.ItemState) null, (String) null, TwitterApiConstants.Errors.GUEST_AUTH_ERROR_CODE, (Object) null);
        }
        if (formItem instanceof FormItem.i) {
            return FormItem.i.a((FormItem.i) formItem, (k) null, (String) null, (List) null, (String) null, charSequence, false, (List) null, (FormItem.ItemState) null, (Map) null, 495, (Object) null);
        }
        if (formItem instanceof FormItem.k) {
            return FormItem.k.a((FormItem.k) formItem, (String) null, (k) null, (Map) null, (Map) null, (String) null, false, (String) null, charSequence, 127, (Object) null);
        }
        if (formItem instanceof FormItem.n) {
            return FormItem.n.a((FormItem.n) formItem, (k) null, (String) null, (String) null, false, charSequence, 15, (Object) null);
        }
        if (formItem instanceof FormItem.c) {
            return FormItem.c.a((FormItem.c) formItem, (String) null, (k) null, (Map) null, (String) null, false, charSequence, 31, (Object) null);
        }
        boolean z14 = true;
        if (formItem instanceof FormItem.f) {
            z11 = true;
        } else {
            z11 = formItem instanceof FormItem.h;
        }
        if (z11) {
            z12 = true;
        } else {
            z12 = formItem instanceof FormItem.l;
        }
        if (z12) {
            z13 = true;
        } else {
            z13 = formItem instanceof FormItem.o;
        }
        if (!z13) {
            z14 = formItem instanceof FormItem.r;
        }
        if (z14) {
            return formItem;
        }
        throw new NoWhenBranchMatchedException();
    }
}
