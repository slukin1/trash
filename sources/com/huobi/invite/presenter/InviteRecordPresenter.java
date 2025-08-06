package com.huobi.invite.presenter;

import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.invite.bean.InviteReturnRecordListItem;
import com.huobi.invite.helper.InviteReturnHelper;
import com.tencent.android.tpush.common.Constants;
import em.b;
import em.c;
import em.e;
import em.f;
import em.h;
import i6.d;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import u6.g;

public class InviteRecordPresenter extends ActivityPresenter<a> {

    /* renamed from: a  reason: collision with root package name */
    public Set<Integer> f74510a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public int f74511b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f74512c;

    /* renamed from: d  reason: collision with root package name */
    public SimpleDateFormat f74513d = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    /* renamed from: e  reason: collision with root package name */
    public List<s9.a> f74514e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List<s9.a> f74515f = new ArrayList();

    public interface a extends g {
        void D6();

        void i4(List<s9.a> list);

        void jb();

        int re();

        void za(List<s9.a> list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z(List list) {
        d.b("InviteRecordPresenter-->requestInviteRecord-->list:" + list);
        this.f74514e.addAll(list);
        this.f74511b = this.f74514e.size();
        ((a) getUI()).za(this.f74514e);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a0(APIStatusErrorException aPIStatusErrorException) {
        d.b("InviteRecordPresenter-->requestInviteRecord-->e:" + aPIStatusErrorException.toString());
        this.f74514e.clear();
        ((a) getUI()).D6();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b0(Throwable th2) {
        d.b("InviteRecordPresenter-->requestInviteRecord-->throwable:" + th2.toString());
        this.f74514e.clear();
        ((a) getUI()).D6();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List c0(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            InviteReturnRecordListItem inviteReturnRecordListItem = (InviteReturnRecordListItem) it2.next();
            if (inviteReturnRecordListItem != null) {
                if (this.f74510a.contains(Integer.valueOf(inviteReturnRecordListItem.getId()))) {
                    arrayList.add(inviteReturnRecordListItem);
                }
                this.f74510a.add(Integer.valueOf(inviteReturnRecordListItem.getId()));
            }
        }
        list.removeAll(arrayList);
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d0(List list) {
        InviteReturnRecordListItem inviteReturnRecordListItem;
        d.b("InviteRecordPresenter-->requestReturnRecord-->list:");
        if (!(list == null || list.isEmpty() || (inviteReturnRecordListItem = (InviteReturnRecordListItem) list.get(list.size() - 1)) == null)) {
            this.f74512c = inviteReturnRecordListItem.getId();
        }
        this.f74515f.addAll(list);
        ((a) getUI()).i4(this.f74515f);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f0(APIStatusErrorException aPIStatusErrorException) {
        d.b("InviteRecordPresenter-->requestInviteRecord-->e:" + aPIStatusErrorException.toString());
        this.f74515f.clear();
        ((a) getUI()).jb();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g0(Throwable th2) {
        d.b("InviteRecordPresenter-->requestInviteRecord-->throwable:" + th2.toString());
        this.f74515f.clear();
        ((a) getUI()).jb();
    }

    public List<s9.a> X() {
        return new ArrayList(this.f74514e);
    }

    public List<s9.a> Y() {
        return new ArrayList(this.f74515f);
    }

    /* renamed from: h0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        i0();
    }

    public void i0() {
        Map<String, Object> map;
        d.b("InviteRecordPresenter-->requestInviteRecord-->");
        if (((a) getUI()).re() == -1) {
            map = MapParamsBuilder.c().a(Constants.FLAG_TAG_OFFSET, Integer.valueOf(this.f74511b)).a("limit", 20).a("version", 2).b();
        } else {
            map = MapParamsBuilder.c().a("state", Integer.valueOf(((a) getUI()).re())).a(Constants.FLAG_TAG_OFFSET, Integer.valueOf(this.f74511b)).a("limit", 20).a("version", 2).b();
        }
        InviteReturnHelper.b(map).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.d((g) getUI(), new f(this), new c(this), new e(this)));
    }

    public void j0(Date date) {
        d.b("InviteRecordPresenter-->requestReturnRecord-->");
        HashMap hashMap = new HashMap();
        hashMap.put("start-date", this.f74513d.format(DateTimeUtils.y(date)));
        hashMap.put("end-date", this.f74513d.format(DateTimeUtils.B(date)));
        if (this.f74512c != 0) {
            hashMap.put("from", "" + this.f74512c);
        }
        hashMap.put("size", String.valueOf(20));
        InviteReturnHelper.f(hashMap).compose(RxJavaHelper.t((g) getUI())).map(new h(this)).subscribe(q6.d.d((g) getUI(), new em.g(this), new b(this), new em.d(this)));
    }

    public void k0() {
        this.f74511b = 0;
        this.f74514e.clear();
    }

    public void l0() {
        this.f74512c = 0;
        this.f74510a.clear();
        this.f74515f.clear();
    }
}
