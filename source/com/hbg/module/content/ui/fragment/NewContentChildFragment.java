package com.hbg.module.content.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.fastjson.JSONObject;
import com.hbg.module.libkt.base.ui.BaseFragment;
import kotlin.jvm.internal.r;
import lc.c2;
import rj.b;

public final class NewContentChildFragment extends BaseFragment<c2> {

    /* renamed from: t  reason: collision with root package name */
    public static final a f18762t = new a((r) null);

    /* renamed from: p  reason: collision with root package name */
    public b f18763p;

    /* renamed from: q  reason: collision with root package name */
    public int f18764q = -1;

    /* renamed from: r  reason: collision with root package name */
    public int f18765r = -1;

    /* renamed from: s  reason: collision with root package name */
    public boolean f18766s = true;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public void Ah() {
        super.Ah();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f18764q = arguments.getInt("tabType");
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            this.f18765r = arguments2.getInt("categoryId");
        }
    }

    public void Fh() {
        String str;
        super.Fh();
        if (this.f18766s) {
            this.f18766s = false;
            return;
        }
        b bVar = this.f18763p;
        if (bVar != null) {
            if (this.f18764q == 1) {
                str = "flashNews.onPageChange('" + this.f18765r + "')";
            } else {
                str = "deepNews.onPageChange('" + this.f18765r + "')";
            }
            bVar.I(str);
        }
    }

    /* renamed from: Rh */
    public c2 yh(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return c2.K(layoutInflater, viewGroup, false);
    }

    public void initView() {
        String str;
        if (this.f18764q == 1) {
            str = "flashNews.requestList('" + this.f18765r + "', false)";
        } else {
            str = "deepNews.requestList('" + this.f18765r + "', false)";
        }
        b bVar = this.f18763p;
        if (bVar != null) {
            bVar.I(str);
        }
        String str2 = this.f18764q == 1 ? "flash_news_list.xml" : "deep_news_list.xml";
        FrameLayout frameLayout = ((c2) uh()).B;
        b bVar2 = this.f18763p;
        View view = null;
        if (bVar2 != null) {
            view = bVar2.E(str2, getActivity(), false, (JSONObject) null);
        }
        frameLayout.addView(view, -1, -1);
    }
}
