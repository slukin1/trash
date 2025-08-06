package com.hbg.module.huobi.im.utils;

import android.text.TextUtils;
import com.hbg.lib.network.hbg.core.bean.GroupUserItemData;
import com.hbg.lib.network.hbg.core.bean.GroupUserListData;
import com.hbg.module.huobi.im.group.bean.LiveGroupBean;
import java.util.List;
import ld.e;
import ld.f;

public class HbGroupUserManager {

    /* renamed from: d  reason: collision with root package name */
    public static HbGroupUserManager f20538d = new HbGroupUserManager();

    /* renamed from: a  reason: collision with root package name */
    public f f20539a = new f((e) null);

    /* renamed from: b  reason: collision with root package name */
    public GroupUserListData f20540b;

    /* renamed from: c  reason: collision with root package name */
    public LiveGroupBean f20541c;

    public class a implements kd.a<GroupUserListData> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kd.a f20542a;

        public a(kd.a aVar) {
            this.f20542a = aVar;
        }

        /* renamed from: a */
        public void onSuccess(GroupUserListData groupUserListData) {
            GroupUserListData unused = HbGroupUserManager.this.f20540b = groupUserListData;
            kd.a aVar = this.f20542a;
            if (aVar != null) {
                aVar.onSuccess(groupUserListData);
            }
        }

        public void onFailed(int i11, String str) {
            kd.a aVar = this.f20542a;
            if (aVar != null) {
                aVar.onFailed(i11, str);
            }
        }
    }

    public static HbGroupUserManager c() {
        return f20538d;
    }

    public void b(String str, kd.a<GroupUserListData> aVar) {
        GroupUserListData groupUserListData = this.f20540b;
        if (groupUserListData == null) {
            this.f20539a.h(str, new a(aVar));
        } else if (aVar != null) {
            aVar.onSuccess(groupUserListData);
        }
    }

    public boolean d(String str) {
        List<GroupUserItemData> listData;
        GroupUserListData groupUserListData = this.f20540b;
        if (groupUserListData == null || (listData = groupUserListData.getListData()) == null || listData.size() <= 0) {
            return false;
        }
        for (GroupUserItemData next : listData) {
            if (TextUtils.equals(str, next.getAccount()) && (next.getRole() == 2 || next.getRole() == 3)) {
                return true;
            }
        }
        return false;
    }

    public boolean e(String str) {
        List<GroupUserItemData> listData;
        GroupUserListData groupUserListData = this.f20540b;
        if (groupUserListData == null || (listData = groupUserListData.getListData()) == null || listData.size() <= 0) {
            return false;
        }
        for (GroupUserItemData next : listData) {
            if (TextUtils.equals(str, next.getAccount()) && next.getRole() == 3) {
                return true;
            }
        }
        return false;
    }

    public void f() {
        this.f20540b = null;
    }

    public void g() {
        this.f20540b = null;
        this.f20541c = null;
    }

    public void h(LiveGroupBean liveGroupBean) {
        this.f20541c = liveGroupBean;
    }
}
