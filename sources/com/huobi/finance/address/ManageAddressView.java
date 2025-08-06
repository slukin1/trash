package com.huobi.finance.address;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.network.pro.core.bean.DefiChainInfo;
import com.hbg.lib.network.pro.core.bean.UserAddrInfo;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.asset.R$dimen;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.defibox.DefiChainListProvider;
import com.huobi.finance.bean.ManageAddressListItem;
import com.huobi.finance.bean.ManageTabListItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import uk.k;

public class ManageAddressView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public EasyRecyclerView<ManageTabListItem> f45238b;

    /* renamed from: c  reason: collision with root package name */
    public EasyRecyclerView<ManageAddressListItem> f45239c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f45240d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f45241e;

    /* renamed from: f  reason: collision with root package name */
    public View f45242f;

    /* renamed from: g  reason: collision with root package name */
    public c f45243g;

    /* renamed from: h  reason: collision with root package name */
    public final List<ManageTabListItem> f45244h;

    /* renamed from: i  reason: collision with root package name */
    public ManageTabListItem f45245i;

    /* renamed from: j  reason: collision with root package name */
    public UserAddrInfo f45246j;

    /* renamed from: k  reason: collision with root package name */
    public final Map<String, ManageTabListItem> f45247k;

    /* renamed from: l  reason: collision with root package name */
    public final Map<String, ManageAddressListItem> f45248l;

    /* renamed from: m  reason: collision with root package name */
    public ManageTabListItem.a f45249m;

    /* renamed from: n  reason: collision with root package name */
    public ManageAddressListItem.a f45250n;

    public class a implements ManageTabListItem.a {
        public a() {
        }

        public boolean a(ManageTabListItem manageTabListItem) {
            return ManageAddressView.this.f45245i != null && manageTabListItem.d().getChain().equals(ManageAddressView.this.f45245i.d().getChain());
        }

        public void b(ManageTabListItem manageTabListItem) {
            ManageTabListItem unused = ManageAddressView.this.f45245i = manageTabListItem;
            ManageAddressView.this.f45238b.c();
            ManageAddressView.this.f45239c.setData(ManageAddressView.this.f45245i.e());
            ViewUtil.m(ManageAddressView.this.f45242f, ManageAddressView.this.f45245i.e().isEmpty());
            ManageAddressView.this.q();
        }
    }

    public class b implements ManageAddressListItem.a {
        public b() {
        }

        public void a(ManageAddressListItem manageAddressListItem) {
            if (ManageAddressView.this.f45243g != null) {
                ManageAddressView.this.f45243g.b((ManageTabListItem) ManageAddressView.this.f45247k.get(manageAddressListItem.c().getChain()), manageAddressListItem);
            }
        }

        public void b(ManageAddressListItem manageAddressListItem) {
            String address = manageAddressListItem.c().getAddress();
            ClipboardManager clipboardManager = (ClipboardManager) ManageAddressView.this.getContext().getSystemService("clipboard");
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(ClipData.newPlainText(address, address));
                HuobiToastUtil.t(ManageAddressView.this.getContext(), R$string.currency_deposit_copied);
            }
        }

        public void c(ManageAddressListItem manageAddressListItem) {
            UserAddrInfo unused = ManageAddressView.this.f45246j = manageAddressListItem.c();
            ManageAddressView.this.f45239c.c();
        }

        public boolean d(ManageAddressListItem manageAddressListItem) {
            if (ManageAddressView.this.f45246j == null) {
                return false;
            }
            String str = ManageAddressView.this.f45246j.getChain() + "_" + ManageAddressView.this.f45246j.getAddress();
            UserAddrInfo c11 = manageAddressListItem.c();
            return str.equals(c11.getChain() + "_" + c11.getAddress());
        }
    }

    public interface c {
        void a();

        void b(ManageTabListItem manageTabListItem, ManageAddressListItem manageAddressListItem);
    }

    public ManageAddressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void o(View view) {
        c cVar = this.f45243g;
        if (cVar != null) {
            cVar.a();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int getAllAddressItemSize() {
        return this.f45248l.size();
    }

    public UserAddrInfo getCurrentAddressInfo() {
        return this.f45246j;
    }

    public int getRealHeight() {
        return (getResources().getDisplayMetrics().heightPixels - ViewUtil.g()) - getResources().getDimensionPixelOffset(R$dimen.dimen_150);
    }

    public final void l() {
        findViewById(R$id.id_on_chain_address_manage_btn).setOnClickListener(new k(this));
    }

    public final void m() {
    }

    public final void n() {
        this.f45238b = (EasyRecyclerView) findViewById(R$id.id_on_chain_address_tab_recyclerView);
        this.f45239c = (EasyRecyclerView) findViewById(R$id.id_on_chain_address_manage_recyclerView);
        this.f45240d = (TextView) findViewById(R$id.id_on_chain_address_title_tv);
        this.f45241e = (ImageView) findViewById(R$id.id_on_chain_address_title_iv);
        this.f45242f = findViewById(R$id.id_on_chain_address_manage_emptyView);
    }

    public UserAddrInfo p(String str, String str2) {
        List<ManageAddressListItem> e11;
        ManageTabListItem manageTabListItem = this.f45247k.get(str);
        if (!(manageTabListItem == null || (e11 = manageTabListItem.e()) == null)) {
            ManageAddressListItem remove = this.f45248l.remove(str + "_" + str2);
            if (remove != null) {
                e11.remove(remove);
                UserAddrInfo c11 = remove.c();
                if ((this.f45246j.getChain() + "_" + this.f45246j.getAddress()).equals(c11.getChain() + "_" + c11.getAddress())) {
                    this.f45246j = null;
                    Iterator<ManageTabListItem> it2 = this.f45244h.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            List<ManageAddressListItem> e12 = it2.next().e();
                            if (e12 != null && !e12.isEmpty()) {
                                this.f45246j = e12.get(0).c();
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                this.f45238b.c();
                this.f45239c.setData(this.f45245i.e());
                ViewUtil.m(this.f45242f, e11.isEmpty());
                q();
                return this.f45246j;
            }
        }
        return null;
    }

    public final void q() {
        DefiChainInfo d11;
        ManageTabListItem manageTabListItem = this.f45245i;
        if (manageTabListItem != null && (d11 = manageTabListItem.d()) != null) {
            List<ManageAddressListItem> e11 = this.f45245i.e();
            this.f45240d.setText(String.format(Locale.US, getResources().getString(R$string.n_on_chain_asset_address_management_chain_title), new Object[]{StringUtils.i(d11.getChain()), String.valueOf(e11.size())}));
            g6.b.c().h(this.f45241e, d11.getSelectIcon());
        }
    }

    public void setCallback(c cVar) {
        this.f45243g = cVar;
    }

    public void setCurrentUserAddressInfo(UserAddrInfo userAddrInfo) {
        this.f45246j = userAddrInfo;
    }

    public void setDataList(List<UserAddrInfo> list) {
        DefiChainInfo d11;
        String chain;
        ManageTabListItem manageTabListItem;
        d.b("ManageAddressView-->setDataList-->" + list);
        if (list != null && !list.isEmpty()) {
            this.f45244h.clear();
            this.f45247k.clear();
            this.f45248l.clear();
            for (DefiChainInfo next : DefiChainListProvider.b()) {
                ManageTabListItem manageTabListItem2 = new ManageTabListItem();
                manageTabListItem2.g(next);
                manageTabListItem2.f(this.f45249m);
                this.f45247k.put(next.getChain(), manageTabListItem2);
                this.f45244h.add(manageTabListItem2);
            }
            for (UserAddrInfo next2 : list) {
                if (!(next2 == null || (manageTabListItem = this.f45247k.get(chain)) == null)) {
                    List e11 = manageTabListItem.e();
                    if (e11 == null) {
                        e11 = new ArrayList();
                        manageTabListItem.h(e11);
                    }
                    ManageAddressListItem manageAddressListItem = new ManageAddressListItem();
                    e11.add(manageAddressListItem);
                    manageAddressListItem.f(next2);
                    manageAddressListItem.g(this.f45250n);
                    DefiChainInfo c11 = DefiChainListProvider.c((chain = next2.getChain()));
                    manageAddressListItem.h(c11);
                    manageTabListItem.g(c11);
                    manageTabListItem.f(this.f45249m);
                    Map<String, ManageAddressListItem> map = this.f45248l;
                    map.put(next2.getChain() + "_" + next2.getAddress(), manageAddressListItem);
                }
            }
            if (this.f45245i != null || this.f45244h.isEmpty()) {
                ManageTabListItem manageTabListItem3 = this.f45245i;
                if (!(manageTabListItem3 == null || (d11 = manageTabListItem3.d()) == null)) {
                    this.f45245i = this.f45247k.get(d11.getChain());
                }
            } else {
                this.f45245i = this.f45247k.get(this.f45246j.getChain());
            }
            this.f45238b.setData(this.f45244h);
            ManageTabListItem manageTabListItem4 = this.f45245i;
            if (manageTabListItem4 != null) {
                this.f45239c.setData(manageTabListItem4.e());
            }
            View view = this.f45242f;
            ManageTabListItem manageTabListItem5 = this.f45245i;
            ViewUtil.m(view, manageTabListItem5 != null && manageTabListItem5.e().isEmpty());
            q();
        }
    }

    public ManageAddressView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f45244h = new ArrayList();
        this.f45247k = new HashMap();
        this.f45248l = new HashMap();
        this.f45249m = new a();
        this.f45250n = new b();
        FrameLayout.inflate(context, R$layout.layout_on_chain_address_manage, this);
        n();
        l();
        m();
    }
}
