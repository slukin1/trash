package com.huobi.home.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huobi.index.helper.data.HomePageModule;
import kotlin.jvm.internal.r;

public final class HomePageConfigDataModule extends HomePageModule<HomepageConfig> {

    /* renamed from: c  reason: collision with root package name */
    public static final a f72468c = new a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static String f72469d = "{\"structure\":{\"navigation\":[\"nav\"],\"fluent\":[\"banner\",\"guide\",\"market\",\"operation\",\"cube\",\"ranking\",\"earn\",\"invest\"]},\"modules\":{\"market\":{\"name\":\"market\",\"version\":[100000,-1],\"type\":\"engine\",\"isNeedLogin\":\"0\",\"isNeedAssets\":\"1\",\"params\":{\"engineName\":\"home\",\"yuguImage\":\"skeleton_home_market\",\"enterView\":\"market\"}},\"nav\":{\"name\":\"nav\",\"version\":[100000,-1],\"type\":\"engine\",\"isNeedLogin\":\"0\",\"isNeedAssets\":\"0\",\"params\":{\"engineName\":\"home\",\"yuguImage\":\"\",\"enterView\":\"nav\"}},\"invest\":{\"name\":\"invest\",\"version\":[100000,-1],\"type\":\"engine\",\"isNeedLogin\":\"0\",\"isNeedAssets\":\"0\",\"params\":{\"engineName\":\"home\",\"yuguImage\":\"skeleton_home_invest\",\"enterView\":\"invest\"}},\"earn\":{\"name\":\"earn\",\"version\":[100000,-1],\"type\":\"engine\",\"isNeedLogin\":\"0\",\"isNeedAssets\":\"0\",\"params\":{\"engineName\":\"home\",\"yuguImage\":\"skeleton_home_earn\",\"enterView\":\"earn\"}},\"banner\":{\"name\":\"banner\",\"version\":[100000,-1],\"type\":\"engine\",\"isNeedLogin\":\"0\",\"isNeedAssets\":\"1\",\"params\":{\"engineName\":\"home\",\"yuguImage\":\"skeleton_home_banner\",\"enterView\":\"banner\"}},\"ranking\":{\"name\":\"ranking\",\"version\":[100000,-1],\"type\":\"engine\",\"isNeedLogin\":\"0\",\"isNeedAssets\":\"0\",\"params\":{\"engineName\":\"home\",\"yuguImage\":\"skeleton_home_ranking\",\"enterView\":\"ranking\"}},\"cube\":{\"name\":\"cube\",\"version\":[100000,-1],\"type\":\"engine\",\"isNeedLogin\":\"0\",\"isNeedAssets\":\"1\",\"params\":{\"engineName\":\"home\",\"yuguImage\":\"skeleton_home_cube\",\"enterView\":\"cube\"}},\"operation\":{\"name\":\"operation\",\"version\":[100000,-1],\"type\":\"engine\",\"isNeedLogin\":\"0\",\"isNeedAssets\":\"0\",\"params\":{\"engineName\":\"home\",\"yuguImage\":\"skeleton_home_operation\",\"enterView\":\"operation\"}},\"guide\":{\"name\":\"guide\",\"version\":[100000,-1],\"type\":\"engine\",\"isNeedLogin\":\"0\",\"isNeedAssets\":\"0\",\"params\":{\"engineName\":\"home\",\"yuguImage\":\"\",\"enterView\":\"guide\"}}}}";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final class b extends TypeToken<HomepageConfig> {
    }

    public static final class c extends TypeToken<HomepageConfig> {
    }

    public static final class d extends TypeToken<HomepageConfig> {
    }

    public String e() {
        return "SP_TAG_HOME_PAGE_CONFIG_DATA_230417";
    }

    /* renamed from: k */
    public String b(HomepageConfig homepageConfig) {
        return new Gson().toJson((Object) homepageConfig, new b().getType());
    }

    /* renamed from: l */
    public HomepageConfig c(String str) {
        return (HomepageConfig) new Gson().fromJson(str, new c().getType());
    }

    public final void m() {
        j(new Gson().fromJson(f72469d, new d().getType()));
    }

    /* renamed from: n */
    public HomepageConfig i(HomepageConfig homepageConfig) {
        return homepageConfig;
    }
}
