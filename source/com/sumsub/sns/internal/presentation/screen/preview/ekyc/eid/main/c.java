package com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main;

import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.e;
import com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a;
import com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b;
import de.authada.library.api.SecretWrong;
import kotlin.jvm.internal.r;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f35815a = new c();

    public final b.a a(b.c cVar, a.i iVar, a.C0436a aVar, boolean z11) {
        if (z11) {
            return new b.a(cVar.a(e.f35598c0), cVar.a(e.f35600d0), (CharSequence) null, cVar.a(e.f35602e0), SNSIconHandler.SNSEidIcons.CAN, iVar, aVar, 4, (r) null);
        }
        return new b.a(cVar.a(e.N), cVar.a(e.O), (CharSequence) null, cVar.a(e.P), SNSIconHandler.SNSEidIcons.CAN, iVar, aVar, 4, (r) null);
    }

    public final b.f b(b.c cVar, a.C0436a aVar) {
        return new b.f(true, cVar.a(e.H), cVar.a(e.I), SNSIconHandler.SNSEidIcons.DONE.getImageName(), cVar.a(e.J), a.i.f.f35697a, aVar);
    }

    public final b.d c(b.c cVar, a.C0436a aVar) {
        return new b.d(cVar.a(e.f35601e), cVar.a(e.f35603f), cVar.a(e.f35605g), cVar.a(e.f35609i), cVar.a(e.f35607h), a.i.f.f35697a, a.i.d.f35695a, a.i.l.f35705a, aVar);
    }

    public final b.f d(b.c cVar, a.C0436a aVar) {
        return new b.f(true, cVar.a(e.K), cVar.a(e.L), SNSIconHandler.SNSEidIcons.DONE.getImageName(), cVar.a(e.M), a.i.m.f35706a, aVar);
    }

    public final b.C0466b a(b.c cVar, a.C0436a aVar) {
        return new b.C0466b(cVar.a(e.f35613k), cVar.a(e.f35615l), cVar.a(e.f35619n), a.i.k.f35704a, cVar.a(e.f35617m), new a.i.C0446i((SecretWrong) null), aVar);
    }

    public final b.e a(b.c cVar, int i11, String str, a.C0436a aVar) {
        return new b.e(cVar.a(e.f35625q), cVar.a(e.f35627r), str, Integer.valueOf(i11), cVar.a("sns_alert_action_cancel"), a.i.c.f35694a, aVar);
    }

    public final b.e a(b.c cVar, String str, a.C0436a aVar) {
        return new b.e(cVar.a(e.f35625q), cVar.a(e.f35627r), str, (Integer) null, cVar.a("sns_alert_action_cancel"), a.i.C0437a.f35692a, aVar);
    }

    public final b.e a(b.c cVar, CharSequence charSequence, a.C0436a aVar) {
        return new b.e(cVar.a(e.f35625q), cVar.a(e.f35627r), charSequence, (Integer) null, cVar.a("sns_alert_action_cancel"), a.i.b.f35693a, aVar);
    }
}
