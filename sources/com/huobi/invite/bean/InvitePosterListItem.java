package com.huobi.invite.bean;

import com.huobi.invite.viewhandler.InvitePosterItemHandler;
import s9.a;

public class InvitePosterListItem implements a {

    /* renamed from: b  reason: collision with root package name */
    public InvitePosterItem f74506b;

    /* renamed from: c  reason: collision with root package name */
    public InvitePosterItemHandler.a f74507c;

    public boolean a(Object obj) {
        return obj instanceof InvitePosterListItem;
    }

    public InvitePosterItemHandler.a c() {
        return this.f74507c;
    }

    public InvitePosterItem d() {
        return this.f74506b;
    }

    public void e(InvitePosterItemHandler.a aVar) {
        this.f74507c = aVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InvitePosterListItem)) {
            return false;
        }
        InvitePosterListItem invitePosterListItem = (InvitePosterListItem) obj;
        if (!invitePosterListItem.a(this)) {
            return false;
        }
        InvitePosterItem d11 = d();
        InvitePosterItem d12 = invitePosterListItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        InvitePosterItemHandler.a c11 = c();
        InvitePosterItemHandler.a c12 = invitePosterListItem.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public void f(InvitePosterItem invitePosterItem) {
        this.f74506b = invitePosterItem;
    }

    public String getViewHandlerName() {
        return InvitePosterItemHandler.class.getName();
    }

    public int hashCode() {
        InvitePosterItem d11 = d();
        int i11 = 43;
        int hashCode = d11 == null ? 43 : d11.hashCode();
        InvitePosterItemHandler.a c11 = c();
        int i12 = (hashCode + 59) * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "InvitePosterListItem(item=" + d() + ", callback=" + c() + ")";
    }
}
