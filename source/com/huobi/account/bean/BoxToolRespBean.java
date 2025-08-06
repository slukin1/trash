package com.huobi.account.bean;

import android.text.TextUtils;
import com.hbg.lib.network.hbg.core.bean.SubscribeBox;
import com.huobi.account.viewhandler.BoxToolHandler;
import java.util.ArrayList;
import java.util.List;
import s9.a;

public class BoxToolRespBean {

    /* renamed from: a  reason: collision with root package name */
    public SubscribeBox.MyToolRespBean f40952a;

    /* renamed from: b  reason: collision with root package name */
    public List<ToolBean> f40953b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public String f40954c;

    /* renamed from: d  reason: collision with root package name */
    public int f40955d;

    /* renamed from: e  reason: collision with root package name */
    public String f40956e;

    public static class ToolBean implements a {

        /* renamed from: b  reason: collision with root package name */
        public String f40957b;

        /* renamed from: c  reason: collision with root package name */
        public String f40958c;

        /* renamed from: d  reason: collision with root package name */
        public String f40959d;

        /* renamed from: e  reason: collision with root package name */
        public String f40960e;

        /* renamed from: f  reason: collision with root package name */
        public String f40961f;

        public String a() {
            if (!TextUtils.isEmpty(this.f40958c)) {
                return this.f40958c;
            }
            return this.f40957b;
        }

        public String c() {
            return this.f40960e;
        }

        public String d() {
            return this.f40959d;
        }

        public String e() {
            return this.f40961f;
        }

        public String f() {
            return this.f40957b;
        }

        public void g(String str) {
            this.f40960e = str;
        }

        public String getViewHandlerName() {
            return BoxToolHandler.class.getName();
        }

        public void h(String str) {
            this.f40959d = str;
        }

        public void i(String str) {
            this.f40961f = str;
        }

        public void j(String str) {
            this.f40957b = str;
        }

        public void k(String str) {
            this.f40958c = str;
        }
    }

    public List<ToolBean> a() {
        return this.f40953b;
    }

    public String b() {
        return this.f40954c;
    }

    public void c(SubscribeBox.MyToolRespBean myToolRespBean) {
        this.f40952a = myToolRespBean;
        if (!(myToolRespBean == null || myToolRespBean.getList() == null)) {
            for (SubscribeBox.ToolBean next : myToolRespBean.getList()) {
                ToolBean toolBean = new ToolBean();
                toolBean.j(next.getTitle());
                toolBean.k(next.getTitleMd());
                toolBean.h(next.getImgUrl());
                toolBean.g(next.getImgNightUrl());
                toolBean.i(next.getJumpUrl());
                this.f40953b.add(toolBean);
            }
            this.f40954c = myToolRespBean.getTitle();
            this.f40955d = myToolRespBean.getSort();
            this.f40956e = myToolRespBean.getImgUrl();
        }
        if (this.f40953b.size() % 4 != 0) {
            for (int i11 = 0; i11 < this.f40953b.size() % 4; i11++) {
                this.f40953b.add(new ToolBean());
            }
        }
    }
}
