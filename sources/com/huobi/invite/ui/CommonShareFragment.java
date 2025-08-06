package com.huobi.invite.ui;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;
import cn.sharesdk.telegram.Telegram;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.p;
import com.hbg.lib.network.hbg.core.bean.ShareConfigInfo;
import com.hbg.lib.network.hbg.core.bean.ShareConfigList;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.domain.DomainSwitcher;
import com.huobi.invite.bean.InvitePosterItem;
import com.huobi.invite.bean.InvitePosterListItem;
import com.huobi.invite.bean.SharePlatformItem;
import com.huobi.invite.viewhandler.InvitePosterItemHandler;
import com.huobi.share.fragment.LineIndicator;
import com.huobi.share.fragment.PreviewFragment;
import com.huobi.social.share.HBShareHelper;
import com.huobi.store.AppConfigManager;
import com.huobi.utils.x;
import com.huochat.community.util.ClipManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import pro.huobi.R;
import tg.r;
import xr.i;

@Deprecated
public class CommonShareFragment extends BaseDialogFragment {

    /* renamed from: u  reason: collision with root package name */
    public static long f74520u = 1500;

    /* renamed from: b  reason: collision with root package name */
    public EasyRecyclerView<SharePlatformItem> f74521b;

    /* renamed from: c  reason: collision with root package name */
    public EasyRecyclerView<SharePlatformItem> f74522c;

    /* renamed from: d  reason: collision with root package name */
    public List<SharePlatformItem> f74523d;

    /* renamed from: e  reason: collision with root package name */
    public List<SharePlatformItem> f74524e;

    /* renamed from: f  reason: collision with root package name */
    public String f74525f;

    /* renamed from: g  reason: collision with root package name */
    public String f74526g;

    /* renamed from: h  reason: collision with root package name */
    public String f74527h;

    /* renamed from: i  reason: collision with root package name */
    public String f74528i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f74529j = false;

    /* renamed from: k  reason: collision with root package name */
    public View f74530k;

    /* renamed from: l  reason: collision with root package name */
    public ViewPager f74531l;

    /* renamed from: m  reason: collision with root package name */
    public LineIndicator f74532m;

    /* renamed from: n  reason: collision with root package name */
    public List<InvitePosterListItem> f74533n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public List<PreviewFragment> f74534o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    public InvitePosterListItem f74535p;

    /* renamed from: q  reason: collision with root package name */
    public DialogInterface.OnDismissListener f74536q;

    /* renamed from: r  reason: collision with root package name */
    public long f74537r = 0;

    /* renamed from: s  reason: collision with root package name */
    public SharePlatformItem.a f74538s = new b(this);

    /* renamed from: t  reason: collision with root package name */
    public InvitePosterItemHandler.a f74539t = new a();

    public class a implements InvitePosterItemHandler.a {
        public a() {
        }

        public void a(InvitePosterListItem invitePosterListItem) {
            if (b(invitePosterListItem)) {
                InvitePosterListItem unused = CommonShareFragment.this.f74535p = null;
            } else {
                InvitePosterListItem unused2 = CommonShareFragment.this.f74535p = invitePosterListItem;
            }
        }

        public boolean b(InvitePosterListItem invitePosterListItem) {
            return CommonShareFragment.this.f74535p != null && CommonShareFragment.this.f74535p == invitePosterListItem;
        }
    }

    public class b extends bp.d {
        public b(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public int a(Fragment fragment) {
            return 0;
        }

        public int getCount() {
            return CommonShareFragment.this.f74534o.size();
        }

        public Fragment getItem(int i11) {
            PreviewFragment previewFragment = (PreviewFragment) CommonShareFragment.this.f74534o.get(i11);
            previewFragment.xh((InvitePosterListItem) CommonShareFragment.this.f74533n.get(i11));
            return previewFragment;
        }
    }

    public class c implements ViewPager.OnPageChangeListener {
        public c() {
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            for (int i12 = 0; i12 < CommonShareFragment.this.f74534o.size(); i12++) {
                if (((PreviewFragment) CommonShareFragment.this.f74534o.get(i12)) != null) {
                    if (i12 == i11) {
                        ((PreviewFragment) CommonShareFragment.this.f74534o.get(i12)).vh(true);
                        ((PreviewFragment) CommonShareFragment.this.f74534o.get(i12)).wh(false);
                        CommonShareFragment commonShareFragment = CommonShareFragment.this;
                        InvitePosterListItem unused = commonShareFragment.f74535p = (InvitePosterListItem) commonShareFragment.f74533n.get(i11);
                    } else {
                        ((PreviewFragment) CommonShareFragment.this.f74534o.get(i12)).vh(false);
                        ((PreviewFragment) CommonShareFragment.this.f74534o.get(i12)).wh(true);
                    }
                }
            }
        }
    }

    public class d extends TypeToken<LinkedHashMap<String, ShareConfigList>> {
        public d() {
        }
    }

    public static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f74544a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huobi.social.share.HBShareHelper$HbPlatform[] r0 = com.huobi.social.share.HBShareHelper.HbPlatform.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f74544a = r0
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_FACEBOOK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f74544a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_TWITTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f74544a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_INSTAGRAM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f74544a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_TELEGRAM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f74544a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_COPY_TEXT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f74544a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_POSTER     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f74544a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_SAVE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f74544a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.huobi.social.share.HBShareHelper$HbPlatform r1 = com.huobi.social.share.HBShareHelper.HbPlatform.TYPE_MORE     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.invite.ui.CommonShareFragment.e.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ih(int i11, boolean z11, InvitePosterListItem invitePosterListItem) {
        for (int i12 = 0; i12 < this.f74534o.size(); i12++) {
            if (i12 != i11) {
                this.f74534o.get(i12).vh(false);
                this.f74535p = invitePosterListItem;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Jh() {
        if (this.f74534o.size() > 0 && this.f74533n.size() > 0) {
            this.f74531l.setCurrentItem(1);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Kh(HBShareHelper.HbPlatform hbPlatform) {
        if (Hh() && this.f74535p != null) {
            if (hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_SAVE)) {
                i.r().M(requireContext(), this.f74535p, Ah());
            } else if (hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_COPY_TEXT)) {
                ClipManager.copy(Ah());
            } else if (hbPlatform.equals(HBShareHelper.HbPlatform.TYPE_POSTER)) {
                Sh();
                boolean z11 = !this.f74529j;
                this.f74529j = z11;
                ViewUtil.n(this.f74530k, z11);
                HuobiToastUtil.r(requireContext().getString(R.string.n_replicated));
            } else {
                String str = this.f74527h;
                if (TextUtils.isEmpty(str)) {
                    str = getString(R.string.n_share_default_ten_year);
                }
                String str2 = str;
                if (this.f74529j) {
                    i.r().D(requireContext(), true, hbPlatform, this.f74535p, Ah());
                } else {
                    i.r().H(requireContext(), hbPlatform, this.f74527h, str2, Ah());
                }
            }
            Lh(hbPlatform);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final String Ah() {
        String str;
        if (TextUtils.isEmpty(this.f74526g)) {
            if (AppLanguageHelper.getInstance().isChineseLanguage()) {
                if (x.d()) {
                    str = DomainSwitcher.C();
                } else {
                    str = DomainSwitcher.E();
                }
            } else if (x.d()) {
                str = DomainSwitcher.D();
            } else {
                str = DomainSwitcher.F();
            }
            this.f74526g = str + this.f74525f;
        }
        return this.f74526g;
    }

    public final HBShareHelper.HbPlatform Bh(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 3260:
                if (str.equals("fb")) {
                    c11 = 0;
                    break;
                }
                break;
            case 3715:
                if (str.equals("tw")) {
                    c11 = 1;
                    break;
                }
                break;
            case 104430:
                if (str.equals("ins")) {
                    c11 = 2;
                    break;
                }
                break;
            case 114715:
                if (str.equals("tel")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return HBShareHelper.HbPlatform.TYPE_FACEBOOK;
            case 1:
                return HBShareHelper.HbPlatform.TYPE_TWITTER;
            case 2:
                return HBShareHelper.HbPlatform.TYPE_INSTAGRAM;
            case 3:
                return HBShareHelper.HbPlatform.TYPE_TELEGRAM;
            default:
                return HBShareHelper.HbPlatform.NONE;
        }
    }

    public List<ShareConfigInfo> Ch(String str) {
        ShareConfigList shareConfigList;
        Map map = (Map) AppConfigManager.d(MgtConfigNumber.SHAR_MGT_CONFIG.number, new d().getType());
        if (map == null || map.isEmpty() || TextUtils.isEmpty(str) || (shareConfigList = (ShareConfigList) map.get(str.toLowerCase())) == null || shareConfigList.getInfoList() == null || shareConfigList.getInfoList().isEmpty()) {
            return new ArrayList<ShareConfigInfo>(3) {
                {
                    add(new ShareConfigInfo("poster", true, "图片预览"));
                    add(new ShareConfigInfo("copy", true, "复制链接"));
                    add(new ShareConfigInfo("more", true, "系统分享"));
                }
            };
        }
        return shareConfigList.getInfoList();
    }

    public final int Dh(HBShareHelper.HbPlatform hbPlatform) {
        switch (e.f74544a[hbPlatform.ordinal()]) {
            case 1:
                return R.drawable.icon_new_share_facebook;
            case 2:
                return R.drawable.icon_new_share_twitter;
            case 3:
                return R.drawable.icon_new_share_ins;
            case 4:
                return R.drawable.icon_new_share_telegram;
            case 5:
                return R.drawable.icon_new_share_copy_link;
            case 6:
                return R.drawable.icon_new_share_poster;
            case 7:
                return R.drawable.icon_new_share_save;
            case 8:
                return R.drawable.icon_new_share_system;
            default:
                return -1;
        }
    }

    public final String Eh(HBShareHelper.HbPlatform hbPlatform) {
        switch (e.f74544a[hbPlatform.ordinal()]) {
            case 1:
                return "Facebook";
            case 2:
                return "X";
            case 3:
                return "Instagram";
            case 4:
                return Telegram.NAME;
            case 5:
                return getString(R.string.n_red_envelope_copy_url);
            case 6:
                return getString(R.string.n_share_poster_share);
            case 7:
                return getString(R.string.n_share_save_image);
            case 8:
                return getString(R.string.n_user_center_share_more);
            default:
                return "";
        }
    }

    public final String Fh(HBShareHelper.HbPlatform hbPlatform) {
        switch (e.f74544a[hbPlatform.ordinal()]) {
            case 1:
                return "Facebook";
            case 2:
                return "Twitter";
            case 3:
                return "Instagram";
            case 4:
                return Telegram.NAME;
            case 5:
                return "CopyLink";
            case 6:
                return "Poster";
            case 7:
                return "Save";
            case 8:
                return "More";
            default:
                return "";
        }
    }

    public final void Gh() {
        this.f74534o.clear();
        for (int i11 = 0; i11 < this.f74533n.size(); i11++) {
            PreviewFragment previewFragment = (PreviewFragment) getChildFragmentManager().m0(String.valueOf(i11));
            if (previewFragment == null) {
                previewFragment = PreviewFragment.th(i11);
            }
            previewFragment.xh(this.f74533n.get(i11));
            previewFragment.uh(new c(this));
            this.f74534o.add(previewFragment);
        }
    }

    public final boolean Hh() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f74537r <= f74520u) {
            return false;
        }
        this.f74537r = currentTimeMillis;
        return true;
    }

    public final void Lh(HBShareHelper.HbPlatform hbPlatform) {
        HashMap hashMap = new HashMap(3);
        hashMap.put("source_name", Fh(hbPlatform));
        hashMap.put("share_uid", r.x().J());
        hashMap.put("url_content", Ah());
        g.i("App_bussiness_detail_share_pop_share_souece_click", hashMap);
    }

    public void Mh(String str) {
        this.f74525f = str;
    }

    public void Nh(String str) {
        this.f74526g = str;
    }

    public void Oh(DialogInterface.OnDismissListener onDismissListener) {
        this.f74536q = onDismissListener;
    }

    public void Ph(String str) {
        this.f74528i = str;
    }

    public void Qh(List<InvitePosterItem> list) {
        if (list != null && !list.isEmpty()) {
            this.f74533n.clear();
            for (int i11 = 0; i11 < list.size(); i11++) {
                InvitePosterListItem invitePosterListItem = new InvitePosterListItem();
                invitePosterListItem.f(list.get(i11));
                invitePosterListItem.e(this.f74539t);
                if (i11 == 1) {
                    this.f74535p = invitePosterListItem;
                }
                this.f74533n.add(invitePosterListItem);
            }
        }
    }

    public void Rh(String str) {
        this.f74527h = str;
    }

    public final void Sh() {
        this.f74522c.setVisibility(8);
        List<SharePlatformItem> list = this.f74524e;
        if (list == null || list.isEmpty()) {
            Iterator<SharePlatformItem> it2 = this.f74523d.iterator();
            int i11 = -1;
            while (true) {
                if (!it2.hasNext()) {
                    break;
                } else if (HBShareHelper.HbPlatform.TYPE_POSTER.equals(it2.next().getPlatform())) {
                    i11++;
                    break;
                } else {
                    i11++;
                }
            }
            if (i11 != -1) {
                ArrayList<SharePlatformItem> arrayList = new ArrayList<>();
                arrayList.addAll(this.f74523d.subList(0, i11));
                SharePlatformItem sharePlatformItem = new SharePlatformItem();
                sharePlatformItem.setPlatform(HBShareHelper.HbPlatform.TYPE_SAVE);
                sharePlatformItem.setTitle(Eh(sharePlatformItem.getPlatform()));
                sharePlatformItem.setResourceId(Dh(sharePlatformItem.getPlatform()));
                sharePlatformItem.setMain(true);
                sharePlatformItem.setCallback(this.f74538s);
                arrayList.add(sharePlatformItem);
                SharePlatformItem sharePlatformItem2 = new SharePlatformItem();
                sharePlatformItem2.setPlatform(HBShareHelper.HbPlatform.TYPE_MORE);
                sharePlatformItem2.setTitle(Eh(sharePlatformItem2.getPlatform()));
                sharePlatformItem2.setResourceId(Dh(sharePlatformItem2.getPlatform()));
                sharePlatformItem2.setMain(true);
                sharePlatformItem2.setCallback(this.f74538s);
                arrayList.add(sharePlatformItem2);
                for (SharePlatformItem count : arrayList) {
                    count.setCount(arrayList.size());
                }
                this.f74523d = arrayList;
            }
        } else {
            SharePlatformItem sharePlatformItem3 = new SharePlatformItem();
            sharePlatformItem3.setPlatform(HBShareHelper.HbPlatform.TYPE_SAVE);
            sharePlatformItem3.setTitle(Eh(sharePlatformItem3.getPlatform()));
            sharePlatformItem3.setResourceId(Dh(sharePlatformItem3.getPlatform()));
            sharePlatformItem3.setMain(true);
            sharePlatformItem3.setCallback(this.f74538s);
            this.f74523d.add(sharePlatformItem3);
            SharePlatformItem sharePlatformItem4 = new SharePlatformItem();
            sharePlatformItem4.setPlatform(HBShareHelper.HbPlatform.TYPE_MORE);
            sharePlatformItem4.setTitle(Eh(sharePlatformItem4.getPlatform()));
            sharePlatformItem4.setResourceId(Dh(sharePlatformItem4.getPlatform()));
            sharePlatformItem4.setMain(true);
            sharePlatformItem4.setCallback(this.f74538s);
            this.f74523d.add(sharePlatformItem4);
            for (SharePlatformItem count2 : this.f74523d) {
                count2.setCount(this.f74523d.size());
            }
        }
        this.f74521b.setData(this.f74523d);
    }

    public void addEvent(i6.r rVar) {
        rVar.b(R.id.iv_share_close).setOnClickListener(new a(this));
    }

    public void afterInit() {
        List<ShareConfigInfo> Ch = Ch(p.a(getContext()));
        this.f74523d = new ArrayList(Ch.size());
        for (ShareConfigInfo next : Ch) {
            String name = next.getName();
            if (Bh(name) != HBShareHelper.HbPlatform.NONE && next.isOpen()) {
                SharePlatformItem sharePlatformItem = new SharePlatformItem();
                sharePlatformItem.setPlatform(Bh(name));
                sharePlatformItem.setTitle(Eh(sharePlatformItem.getPlatform()));
                sharePlatformItem.setResourceId(Dh(sharePlatformItem.getPlatform()));
                sharePlatformItem.setMain(true);
                sharePlatformItem.setCallback(this.f74538s);
                this.f74523d.add(sharePlatformItem);
            }
        }
        if (this.f74523d.size() <= 2) {
            SharePlatformItem sharePlatformItem2 = new SharePlatformItem();
            sharePlatformItem2.setPlatform(HBShareHelper.HbPlatform.TYPE_POSTER);
            sharePlatformItem2.setTitle(Eh(sharePlatformItem2.getPlatform()));
            sharePlatformItem2.setResourceId(Dh(sharePlatformItem2.getPlatform()));
            sharePlatformItem2.setMain(true);
            sharePlatformItem2.setCallback(this.f74538s);
            this.f74523d.add(sharePlatformItem2);
            SharePlatformItem sharePlatformItem3 = new SharePlatformItem();
            sharePlatformItem3.setPlatform(HBShareHelper.HbPlatform.TYPE_COPY_TEXT);
            sharePlatformItem3.setTitle(Eh(sharePlatformItem3.getPlatform()));
            sharePlatformItem3.setResourceId(Dh(sharePlatformItem3.getPlatform()));
            sharePlatformItem3.setMain(true);
            sharePlatformItem3.setCallback(this.f74538s);
            this.f74523d.add(sharePlatformItem3);
            SharePlatformItem sharePlatformItem4 = new SharePlatformItem();
            sharePlatformItem4.setPlatform(HBShareHelper.HbPlatform.TYPE_MORE);
            sharePlatformItem4.setTitle(Eh(sharePlatformItem4.getPlatform()));
            sharePlatformItem4.setResourceId(Dh(sharePlatformItem4.getPlatform()));
            sharePlatformItem4.setMain(true);
            sharePlatformItem4.setCallback(this.f74538s);
            this.f74523d.add(sharePlatformItem4);
            for (SharePlatformItem count : this.f74523d) {
                count.setCount(this.f74523d.size());
            }
        } else {
            for (SharePlatformItem count2 : this.f74523d) {
                count2.setCount(6);
            }
            this.f74524e = new ArrayList(3);
            SharePlatformItem sharePlatformItem5 = new SharePlatformItem();
            sharePlatformItem5.setPlatform(HBShareHelper.HbPlatform.TYPE_POSTER);
            sharePlatformItem5.setTitle(Eh(sharePlatformItem5.getPlatform()));
            sharePlatformItem5.setResourceId(Dh(sharePlatformItem5.getPlatform()));
            sharePlatformItem5.setMain(false);
            sharePlatformItem5.setCallback(this.f74538s);
            this.f74524e.add(sharePlatformItem5);
            SharePlatformItem sharePlatformItem6 = new SharePlatformItem();
            sharePlatformItem6.setPlatform(HBShareHelper.HbPlatform.TYPE_COPY_TEXT);
            sharePlatformItem6.setTitle(Eh(sharePlatformItem6.getPlatform()));
            sharePlatformItem6.setResourceId(Dh(sharePlatformItem6.getPlatform()));
            sharePlatformItem6.setMain(false);
            sharePlatformItem6.setCallback(this.f74538s);
            this.f74524e.add(sharePlatformItem6);
            SharePlatformItem sharePlatformItem7 = new SharePlatformItem();
            sharePlatformItem7.setPlatform(HBShareHelper.HbPlatform.TYPE_MORE);
            sharePlatformItem7.setTitle(Eh(sharePlatformItem7.getPlatform()));
            sharePlatformItem7.setResourceId(Dh(sharePlatformItem7.getPlatform()));
            sharePlatformItem7.setMain(false);
            sharePlatformItem7.setCallback(this.f74538s);
            this.f74524e.add(sharePlatformItem7);
        }
        this.f74521b.setData(this.f74523d);
        this.f74522c.setData(this.f74524e);
        List<SharePlatformItem> list = this.f74524e;
        if (list == null || list.isEmpty()) {
            this.f74522c.setVisibility(8);
        } else {
            this.f74522c.setVisibility(0);
        }
    }

    public boolean contentViewIsFullScreen() {
        return true;
    }

    public int getContentViewResId() {
        return R.layout.fragment_common_share;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(i6.r rVar) {
        EasyRecyclerView<SharePlatformItem> easyRecyclerView = (EasyRecyclerView) rVar.b(R.id.view_recycler_share_main);
        this.f74521b = easyRecyclerView;
        easyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.f74522c = (EasyRecyclerView) rVar.b(R.id.view_recycler_share_second);
        this.f74530k = rVar.b(R.id.viewpager_root);
        this.f74522c.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.f74531l = (ViewPager) this.viewFinder.b(R.id.id_invite_share_platform_viewpager);
        LineIndicator lineIndicator = (LineIndicator) this.viewFinder.b(R.id.share_hindicator);
        this.f74532m = lineIndicator;
        lineIndicator.setData(this.f74533n.size());
        ViewPager viewPager = this.f74531l;
        if (viewPager != null) {
            viewPager.setPageTransformer(false, new lr.g(getContext(), 0.38f));
        }
        ViewPagerHelper.a(this.f74532m, this.f74531l);
        initViewPager();
        ViewUtil.n(this.f74530k, this.f74529j);
    }

    public final void initViewPager() {
        Gh();
        ViewPager viewPager = this.f74531l;
        if (viewPager != null) {
            viewPager.setAdapter(new b(getChildFragmentManager()));
            this.f74531l.setOffscreenPageLimit(this.f74534o.size() - 1);
            this.f74531l.addOnPageChangeListener(new c());
            this.f74531l.postDelayed(new d(this), 200);
        }
    }

    public boolean isFullScreen() {
        return true;
    }

    public boolean isTransparent() {
        return true;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.f74536q;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    public boolean useWindowBg() {
        return false;
    }
}
