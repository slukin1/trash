package com.tencent.qcloud.tuikit.tuicallengine.e;

import com.tencent.qcloud.tuikit.tuicallengine.impl.base.Observer;

public class g implements Observer<m> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f48335a;

    public g(b bVar) {
        this.f48335a = bVar;
    }

    public void onChanged(Object obj) {
        l lVar;
        m mVar = (m) obj;
        b bVar = this.f48335a;
        bVar.getClass();
        if ((m.CancelCall.equals(mVar) || m.CallMissed.equals(mVar) || m.CallRejected.equals(mVar) || m.CallBusy.equals(mVar) || m.CallFailed.equals(mVar) || m.CallCanceled.equals(mVar) || m.RejectCall.equals(mVar) || m.NotAnswerCall.equals(mVar) || m.CallEnd.equals(mVar)) && (lVar = bVar.f48325e) != null) {
            lVar.c();
        }
        if (bVar.f48325e == null) {
            bVar.f48325e = new l(bVar.f48321a);
        }
        bVar.f48325e.a(bVar.f48325e.a(mVar, bVar.f48322b.f48374d), true);
    }
}
