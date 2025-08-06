package com.mob.commons.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.IBinder;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.C0891r;
import com.mob.commons.b.h;
import com.mob.tools.c;
import com.mob.tools.utils.DH;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class m extends h {

    /* renamed from: c  reason: collision with root package name */
    public String f27094c = C0891r.b("025b;cjceckMge3dbEhci(ckcjBied.chcbckddfg'iedIddek");

    /* renamed from: d  reason: collision with root package name */
    private String f27095d;

    public m(Context context) {
        super(context);
    }

    public Intent a() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(C0891r.b("017bGcjceckKge:dbPhci+ckcjLied chcb"), C0891r.b("033b:cjceck1ge)db1hciIckcjIied<chcbckddcb1edh^chdedbdkAe>ciccchUbe")));
        intent.setAction(C0891r.b("040cbh-chcjZdXckAb_cjceck%geWdbNhci3ckcj9ied@chcbckfgfkfhdfcgddekcgdkfhfifjdddcfh"));
        return intent;
    }

    public h.b a(IBinder iBinder) {
        h.b bVar = new h.b();
        bVar.f27087a = a(iBinder, C0891r.b("004Qfgdjddek"));
        return bVar;
    }

    private final String a(IBinder iBinder, String str) {
        if (TextUtils.isEmpty(this.f27095d)) {
            Signature[] signatureArr = null;
            try {
                final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
                DH.requester(MobSDK.getContext()).getMpfo(this.f27080b, 64).request(new DH.DHResponder() {
                    public void onResponse(DH.DHResponse dHResponse) {
                        if (dHResponse.getMpfo(new int[0]) != null) {
                            linkedBlockingQueue.offer(dHResponse.getMpfo(new int[0]));
                        } else {
                            linkedBlockingQueue.offer(Boolean.FALSE);
                        }
                    }
                });
                Object poll = linkedBlockingQueue.poll(300, TimeUnit.MILLISECONDS);
                if (!(poll instanceof Boolean)) {
                    signatureArr = c.b(poll, this.f27080b);
                }
                if (signatureArr != null && signatureArr.length > 0) {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    MessageDigest instance = MessageDigest.getInstance(C0891r.b("004Bdkejecge"));
                    if (instance != null) {
                        byte[] digest = instance.digest(byteArray);
                        StringBuilder sb2 = new StringBuilder();
                        for (byte b11 : digest) {
                            sb2.append(Integer.toHexString((b11 & 255) | 256).substring(1, 3));
                        }
                        this.f27095d = sb2.toString();
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return a(str, iBinder, this.f27094c, 1, this.f27080b, this.f27095d, str);
    }
}
