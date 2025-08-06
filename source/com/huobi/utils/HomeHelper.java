package com.huobi.utils;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.donkingliang.consecutivescroller.ConsecutiveScrollerLayout;
import com.donkingliang.consecutivescroller.ConsecutiveViewPager;
import com.google.android.material.tabs.TabLayout;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.network.hbg.core.bean.HomeFlowConfig;
import com.hbg.lib.network.hbg.core.bean.NewFeed;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.module.livesquare.ui.LiveSquareHomeFragment;
import com.huobi.home.ui.BaseHomeFragment;
import com.huobi.homemarket.model.MarketRemindFlashItem;
import com.huobi.index.bean.HomeFeedInfoItem;
import com.huobi.index.bean.IndexAd;
import com.huobi.index.bean.IndexContract;
import com.huobi.index.bean.IndexDeep;
import com.huobi.index.bean.IndexLive;
import com.huobi.index.bean.IndexSpecial;
import com.huobi.index.ui.FeedFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ky.f;
import pro.huobi.R;
import tg.r;
import u6.g;

public class HomeHelper {

    public class a extends SimpleMultiPurposeListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ConsecutiveScrollerLayout f83694b;

        public a(ConsecutiveScrollerLayout consecutiveScrollerLayout) {
            this.f83694b = consecutiveScrollerLayout;
        }

        public void Cf(f fVar, float f11, int i11, int i12, int i13) {
            this.f83694b.setStickyOffset(i11);
        }

        public void de(f fVar, float f11, int i11, int i12, int i13) {
            this.f83694b.setStickyOffset(i11);
        }
    }

    public class b implements ViewPager.OnPageChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BaseHomeFragment f83695b;

        public b(BaseHomeFragment baseHomeFragment) {
            this.f83695b = baseHomeFragment;
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
            i6.d.i("indexFragment--onPageScrolled--postion=" + i11 + "--positionOffset=" + f11 + "--positionOffsetPixels=" + i12);
        }

        public void onPageSelected(int i11) {
            i6.d.i("indexFragment--addOnPageChangeListener--postion=" + i11);
            this.f83695b.Dh(0);
        }
    }

    public class c implements TabLayout.OnTabSelectedListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BaseHomeFragment f83696b;

        public c(BaseHomeFragment baseHomeFragment) {
            this.f83696b = baseHomeFragment;
        }

        public void onTabReselected(TabLayout.Tab tab) {
        }

        @SensorsDataInstrumented
        public void onTabSelected(TabLayout.Tab tab) {
            SensorsDataAutoTrackHelper.trackTabLayoutSelected(this, tab);
        }

        public void onTabUnselected(TabLayout.Tab tab) {
            i6.d.i("tabLayout--postion=" + tab.getPosition());
            this.f83696b.Ch(tab.getPosition());
        }
    }

    public class d extends BaseSubscriber<HomeFlowConfig> {
        /* renamed from: a */
        public void onNext(HomeFlowConfig homeFlowConfig) {
            int i11;
            int i12;
            super.onNext(homeFlowConfig);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("requestHomeFlowConfig data:");
            sb2.append(homeFlowConfig != null ? homeFlowConfig.toString() : " is null");
            Log.d("HomeHelper", sb2.toString());
            int i13 = 1;
            int i14 = 0;
            if (homeFlowConfig != null) {
                i14 = homeFlowConfig.getUserGuide();
                int porcelain = homeFlowConfig.getPorcelain();
                i12 = homeFlowConfig.getOperPosition();
                int i15 = porcelain;
                i13 = homeFlowConfig.getNewHome();
                i11 = i15;
            } else {
                i11 = 0;
                i12 = 0;
            }
            SP.q("sp_key_index_home_flow_config_user_guide", i14);
            SP.q("sp_key_index_home_flow_config_porcelain", i11);
            SP.q("sp_key_index_home_flow_config_operposition", i12);
            SP.q("sp_key_index_home_flow_config_newhome", i13);
        }

        public void onAfter() {
            super.onAfter();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("requestHomeFlowConfig error:");
            sb2.append(th2 != null ? th2.getMessage() : "");
            Log.e("HomeHelper", sb2.toString());
            SP.q("sp_key_index_home_flow_config_user_guide", 0);
            SP.q("sp_key_index_home_flow_config_porcelain", 0);
            SP.q("sp_key_index_home_flow_config_operposition", 0);
            SP.q("sp_key_index_home_flow_config_newhome", 1);
        }
    }

    public static void a(BaseHomeFragment baseHomeFragment, ConsecutiveScrollerLayout consecutiveScrollerLayout, SmartRefreshLayout smartRefreshLayout, ConsecutiveViewPager consecutiveViewPager, TabLayout tabLayout) {
        smartRefreshLayout.c0(new a(consecutiveScrollerLayout));
        consecutiveViewPager.addOnPageChangeListener(new b(baseHomeFragment));
        tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new c(baseHomeFragment));
    }

    public static Boolean b(View view) {
        return Boolean.valueOf(view.getLocalVisibleRect(new Rect()));
    }

    public static FeedFragment c(ConsecutiveViewPager consecutiveViewPager, List<Fragment> list) {
        int currentItem;
        if (!(consecutiveViewPager == null || list == null || (currentItem = consecutiveViewPager.getCurrentItem()) >= list.size())) {
            Fragment fragment = list.get(currentItem);
            if (fragment instanceof FeedFragment) {
                return (FeedFragment) fragment;
            }
        }
        return null;
    }

    public static int d(ConsecutiveViewPager consecutiveViewPager, List<Fragment> list) {
        FeedFragment c11 = c(consecutiveViewPager, list);
        if (c11 != null) {
            return c11.Oh();
        }
        return 5;
    }

    public static long e(s9.a aVar) {
        if (aVar instanceof HomeFeedInfoItem) {
            HomeFeedInfoItem homeFeedInfoItem = (HomeFeedInfoItem) aVar;
            if (homeFeedInfoItem.n() == 1) {
                return homeFeedInfoItem.p().getIssueTime();
            }
            if (homeFeedInfoItem.n() == 2) {
                return homeFeedInfoItem.g().getIssueTime();
            }
            if (homeFeedInfoItem.n() != 100) {
                if (homeFeedInfoItem.n() == 4) {
                    return homeFeedInfoItem.i().getCreatedTime().longValue();
                }
                if (homeFeedInfoItem.n() == 6) {
                    return homeFeedInfoItem.k().getCreateTime().longValue();
                }
                homeFeedInfoItem.n();
            }
        }
        return 0;
    }

    public static String f(int i11) {
        if (i11 < 1000) {
            return String.valueOf(i11);
        }
        float floatValue = new BigDecimal((double) (((float) i11) / 1000.0f)).setScale(1, 4).floatValue();
        return floatValue + "k";
    }

    public static void g() {
        Log.d("HomeHelper", "requestHomeFlowConfig ");
        HashMap hashMap = new HashMap();
        hashMap.put("HB-CTX-ID", ConfigPreferences.e("user_config", "config_current_uid", ""));
        v7.b.a().getHomeFlowConfig(hashMap).b().compose(RxJavaHelper.t((g) null)).subscribe(new d());
    }

    public static ArrayList<Fragment> h(Context context, ConsecutiveViewPager consecutiveViewPager, TabLayout tabLayout, FragmentManager fragmentManager) {
        ArrayList<Fragment> arrayList = new ArrayList<>();
        FeedFragment.a aVar = FeedFragment.H;
        arrayList.add(aVar.a(1));
        arrayList.add(aVar.a(4));
        arrayList.add(aVar.a(2));
        arrayList.add(aVar.a(3));
        arrayList.add(aVar.a(5));
        arrayList.add(LiveSquareHomeFragment.Wh(-100, ""));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(context.getString(R.string.n_home_feed_tab_recommend));
        arrayList2.add(context.getString(R.string.n_content_communityList_attention));
        arrayList2.add(context.getString(R.string.n_home_feed_tab_news));
        arrayList2.add(context.getString(R.string.n_home_feed_tab_hot));
        arrayList2.add(context.getString(R.string.n_content_deep_news));
        arrayList2.add(context.getString(R.string.n_live));
        consecutiveViewPager.setAdapter(new com.huobi.index.ui.d(fragmentManager, arrayList2, arrayList));
        tabLayout.setupWithViewPager(consecutiveViewPager);
        return arrayList;
    }

    public static boolean i(EasyRecyclerView easyRecyclerView) {
        return (easyRecyclerView == null || easyRecyclerView.getAdapter() == null || easyRecyclerView.getAdapter().c() == null || easyRecyclerView.getAdapter().c().size() <= 0) ? false : true;
    }

    public static boolean j() {
        return true;
    }

    public static List<s9.a> k(NewFeed newFeed, int i11) {
        return l(newFeed != null ? newFeed.getItems() : null, i11);
    }

    public static List<s9.a> l(List<NewFeed.FeedItem> list, int i11) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            try {
                int size = list.size();
                for (int i12 = 0; i12 < size; i12++) {
                    NewFeed.FeedItem feedItem = list.get(i12);
                    HomeFeedInfoItem homeFeedInfoItem = new HomeFeedInfoItem();
                    homeFeedInfoItem.D(i11);
                    homeFeedInfoItem.z(feedItem.getItemType());
                    rd.d dVar = rd.d.f23353a;
                    String a11 = dVar.a(feedItem.getItemContent());
                    if (feedItem.getItemType() == 1) {
                        homeFeedInfoItem.B((NewFlashInformation) dVar.b(a11, NewFlashInformation.class));
                        if (homeFeedInfoItem.p() != null) {
                            arrayList.add(homeFeedInfoItem);
                        }
                    } else if (feedItem.getItemType() == 2) {
                        homeFeedInfoItem.u((IndexDeep) dVar.b(a11, IndexDeep.class));
                        if (homeFeedInfoItem.g() != null) {
                            arrayList.add(homeFeedInfoItem);
                        }
                    }
                    if (feedItem.getItemType() == 100) {
                        if (a11.startsWith("\"")) {
                            a11 = a11.substring(0, a11.length() - 1).replaceFirst("\"", "").replaceAll("\\\\\"", "\"");
                        }
                        homeFeedInfoItem.w((IndexContract) dVar.b(a11, IndexContract.class));
                        if (homeFeedInfoItem.j() != null) {
                            arrayList.add(homeFeedInfoItem);
                        }
                    } else if (feedItem.getItemType() == 3) {
                        homeFeedInfoItem.A((MarketRemindFlashItem) dVar.b(a11, MarketRemindFlashItem.class));
                        if (homeFeedInfoItem.o() != null) {
                            arrayList.add(homeFeedInfoItem);
                        }
                    } else if (feedItem.getItemType() == 4) {
                        homeFeedInfoItem.v((CommunityFeedInfo.ListBean) dVar.b(a11, CommunityFeedInfo.ListBean.class));
                        if (homeFeedInfoItem.i() != null) {
                            arrayList.add(homeFeedInfoItem);
                        }
                    } else if (feedItem.getItemType() == 6) {
                        homeFeedInfoItem.x((IndexLive) dVar.b(a11, IndexLive.class));
                        if (homeFeedInfoItem.k() != null) {
                            arrayList.add(homeFeedInfoItem);
                        }
                    } else if (feedItem.getItemType() == 14) {
                        homeFeedInfoItem.y((IndexSpecial) dVar.b(a11, IndexSpecial.class));
                        if (homeFeedInfoItem.m() != null) {
                            arrayList.add(homeFeedInfoItem);
                        }
                    } else if (feedItem.getItemType() == 500) {
                        String replaceFirst = a11.replace("\\\"", "\"").replace("\\\\", "\\").replaceFirst("\"", "");
                        homeFeedInfoItem.C((IndexContract) dVar.b(replaceFirst.substring(0, replaceFirst.length() - 1), IndexContract.class));
                        if (homeFeedInfoItem.q() != null) {
                            arrayList.add(homeFeedInfoItem);
                        }
                    }
                    homeFeedInfoItem.t(feedItem.getRecomBaseInfo());
                }
            } catch (Exception e11) {
                i6.d.i("newFeedToHomeFeed e=+" + e11);
            }
        }
        return arrayList;
    }

    public static void m(EasyRecyclerView<s9.a> easyRecyclerView, int i11) {
        HomeFeedInfoItem homeFeedInfoItem;
        ArrayList<IndexContract.ElemsDTO> elems;
        if (easyRecyclerView != null) {
            try {
                if (easyRecyclerView.getAdapter() == null) {
                    return;
                }
                if (easyRecyclerView.getAdapter().c() != null) {
                    List c11 = easyRecyclerView.getAdapter().c();
                    if (c11 != null && i11 >= 0 && i11 < c11.size() && (homeFeedInfoItem = (HomeFeedInfoItem) c11.get(i11)) != null) {
                        int n11 = homeFeedInfoItem.n();
                        if (n11 == 1) {
                            NewFlashInformation p11 = homeFeedInfoItem.p();
                            if (p11 != null) {
                                gs.g.g("app_recome_content_show", HomeSensorsHelper.d(p11.getId(), homeFeedInfoItem.d(), p11.getTitle(), "huobiNews", homeFeedInfoItem.r(), (String) null, 1));
                            }
                        } else if (n11 == 2) {
                            IndexDeep g11 = homeFeedInfoItem.g();
                            if (g11 != null) {
                                gs.g.g("app_recome_content_show", HomeSensorsHelper.d(g11.getId(), homeFeedInfoItem.d(), g11.getTitle(), "article", homeFeedInfoItem.r(), (String) null, 2));
                            }
                        } else if (n11 != 4) {
                            String str = "";
                            if (n11 == 6) {
                                IndexLive k11 = homeFeedInfoItem.k();
                                if (k11 != null) {
                                    long intValue = (long) k11.getId().intValue();
                                    String d11 = homeFeedInfoItem.d();
                                    String title = k11.getTitle();
                                    int r11 = homeFeedInfoItem.r();
                                    if (k11.getStatus() != null) {
                                        str = k11.getStatus().toString();
                                    }
                                    gs.g.g("app_recome_content_show", HomeSensorsHelper.d(intValue, d11, title, "liveStreaming", r11, str, 6));
                                }
                            } else if (n11 == 14) {
                                IndexSpecial m11 = homeFeedInfoItem.m();
                                if (m11 != null) {
                                    gs.g.g("app_recome_content_show", HomeSensorsHelper.d((long) m11.getId(), homeFeedInfoItem.f73152c, m11.getTitle(), "topic", homeFeedInfoItem.r(), (String) null, 14));
                                }
                            } else if (n11 == 100) {
                                IndexContract j11 = homeFeedInfoItem.j();
                                if (j11 != null && (elems = j11.getElems()) != null) {
                                    for (int i12 = 0; i12 < elems.size(); i12++) {
                                        IndexContract.ElemsDTO elemsDTO = elems.get(i12);
                                        gs.g.i("app_recome_derivatives_show", HomeSensorsHelper.a(0, elemsDTO.b(), elemsDTO.a()));
                                    }
                                }
                            } else if (n11 == 500) {
                                IndexContract q11 = homeFeedInfoItem.q();
                                if (q11 != null && !com.hbg.module.libkt.base.ext.b.w(q11.getElems())) {
                                    for (IndexContract.ElemsDTO a11 : q11.getElems()) {
                                        gs.g.g("app_recome_content_show", HomeSensorsHelper.d(0, homeFeedInfoItem.d(), a11.a(), "tag", homeFeedInfoItem.r(), (String) null, 4));
                                    }
                                }
                            } else if (n11 == 999) {
                                IndexAd h11 = homeFeedInfoItem.h();
                                if (h11 != null) {
                                    HashMap hashMap = new HashMap();
                                    String J = r.x().J();
                                    if (J == null || J.equals(str)) {
                                        J = "0";
                                    }
                                    hashMap.put("uid", J);
                                    hashMap.put("location", String.valueOf(i11 + 1));
                                    hashMap.put("textId", String.valueOf(h11.advId));
                                    gs.g.i("app_feed_resource_show", hashMap);
                                }
                            }
                        } else {
                            CommunityFeedInfo.ListBean i13 = homeFeedInfoItem.i();
                            if (i13 != null) {
                                gs.g.g("app_recome_content_show", HomeSensorsHelper.e((long) i13.getId(), homeFeedInfoItem.d(), i13.getTitle(), "community", homeFeedInfoItem.r(), (String) null, i13.getShareType(), 4));
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
