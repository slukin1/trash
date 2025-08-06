package com.huobi.domain;

import android.text.TextUtils;
import android.util.Base64;
import bh.j;
import cl.c;
import com.blankj.utilcode.util.t;
import com.google.gson.Gson;
import com.hbg.lib.common.utils.FileUtil;
import com.hbg.lib.common.utils.SystemUtils;
import com.hbg.lib.common.utils.crypt.SHA256Util;
import com.hbg.lib.core.config.AliyunConfig;
import com.hbg.lib.core.config.OtherConfig;
import com.hbg.lib.core.util.o;
import com.hbg.lib.network.hbg.core.bean.SmartDomainData;
import com.hbg.lib.router.HbgRouter;
import com.huobi.domain.data.DomainInfo;
import com.huobi.domain.data.source.remote.bean.RemoteDomain;
import com.huobi.domain.data.source.remote.bean.RemoteDomainInfo;
import com.huobi.domain.data.source.remote.bean.ShareUrlInfo;
import com.huobi.domain.data.source.remote.bean.config.RemindAppInfo;
import com.huobi.domain.data.source.remote.bean.config.RemoteModuleConfig;
import com.huobi.domain.data.source.remote.bean.config.RemoteModuleConfigInfo;
import com.huobi.domain.data.source.remote.bean.config.SmartRemoteDefaultConfig;
import com.huobi.utils.x;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import i6.i;
import i6.k;
import j6.a;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import pro.huobi.R;

public class AppDomainConfigUtils {

    /* renamed from: a  reason: collision with root package name */
    public static File f43773a = new File(j.c().getCacheDir(), "app_smart.cfg");

    /* renamed from: b  reason: collision with root package name */
    public static File f43774b = new File(j.c().getCacheDir(), "app_smart.cfg.download");

    public static boolean c(RemoteDomainInfo remoteDomainInfo) {
        return remoteDomainInfo != null && !x.e(remoteDomainInfo.getList());
    }

    public static String d(File file) {
        try {
            String k11 = FileUtil.k(new FileInputStream(file));
            String substring = k11.substring(0, 64);
            String substring2 = k11.substring(64, k11.length());
            String a11 = SHA256Util.a(substring2);
            if (TextUtils.isEmpty(a11) || !a11.equals(substring)) {
                return "";
            }
            return new String(a.b().a(Base64.decode(substring2, 0)), "utf-8");
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static String e() {
        return "https://huobicfg.s3.ap-northeast-1.amazonaws.com/bit/app.cfg";
    }

    public static String f() {
        return "https://htxcfg-1306115679.cos.ap-beijing.myqcloud.com/bit/app.cfg";
    }

    public static /* synthetic */ void g(RemoteModuleConfig remoteModuleConfig) {
        SensorsDataAPI.sharedInstance().setServerUrl(SystemUtils.c() ? remoteModuleConfig.getSaDataReportUrl() : "https://report.huobi.be/sa?project=default");
    }

    public static void i() {
        try {
            String string = j.c().getResources().getString(R.string.app_d_k);
            a b11 = a.b();
            b11.c((String) null, "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKB2cnXdnoV3/VgmlgbLv2+oDZoLKwK7JA3pGdfBQTjUdA33Uubi6LA1fhLXngDJsBxIMnvQDyqBBN9O6WQM5JVj7iXpcWJsxP7cwaiMof9lUvV5NZWnhHkD3EJR3O1kSWbtmVdBGyuuBowhsJWRFMfhAiojqZ4DaVug7LoiZG7VAgMBAAECgYA9ME2/cm5DmRjrp3MoTkPG8T+WkVGqbfB2uX/YTWJwqFtFBB4B21896ngT+VLQHBjjAAj4O8O8wow4F2BafawgTLp257FVnv91UlFdlhEE3LH+S7/tLDtx/Kgm5vedbnZNwebA8+aCkM6MFbrgpxrzYTskkWJW5aSMhba3hqR4NQJBANXFtQdukcjmQBorGtXrZvt4TPgl7dneF4HWzHkhiopeVG3Jx1s9SONgR3tQzLHvnFp33BkHZ51L1fiBBl1rgDcCQQDAKOp5TC1U87CypFJzFqayNO" + string, true);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static DomainInfo j(String str, SmartDomainData smartDomainData) {
        boolean d11 = x.d();
        DomainInfo domainInfo = null;
        try {
            RemoteDomain remoteDomain = (RemoteDomain) new Gson().fromJson(new JSONObject(str).optString("android_domain"), RemoteDomain.class);
            if (remoteDomain == null) {
                return null;
            }
            DomainInfo domainInfo2 = new DomainInfo();
            try {
                RemoteDomainInfo otcWeb = remoteDomain.getOtcWeb();
                ShareUrlInfo inviteInfo = remoteDomain.getInviteInfo();
                OtherConfig otherConfig = remoteDomain.getOtherConfig();
                AliyunConfig aliyunConfig = remoteDomain.getAliyunConfig();
                if (c(otcWeb)) {
                    domainInfo2.v(d11 ? otcWeb.getPriorityCn() : otcWeb.getPriorityOverseas());
                }
                domainInfo2.G(remoteDomain.getDomainVersion());
                RemoteModuleConfig moduleConfig = remoteDomain.getModuleConfig();
                if (moduleConfig != null) {
                    RemoteModuleConfigInfo inviteConfig = moduleConfig.getInviteConfig();
                    if (!(inviteConfig == null || inviteConfig.getFlutterFeatureConfig() == null)) {
                        c.c().e(inviteConfig.getFlutterFeatureConfig());
                    }
                    RemoteModuleConfigInfo primeConfig = moduleConfig.getPrimeConfig();
                    if (!(primeConfig == null || primeConfig.getFlutterFeatureConfig() == null)) {
                        c.c().f(primeConfig.getFlutterFeatureConfig());
                    }
                    RemoteModuleConfigInfo vulcanConfig = moduleConfig.getVulcanConfig();
                    if (!(vulcanConfig == null || vulcanConfig.getFlutterFeatureConfig() == null)) {
                        c.c().g(vulcanConfig.getFlutterFeatureConfig());
                    }
                    List<RemindAppInfo> marketReminderConfig = moduleConfig.getMarketReminderConfig();
                    if (marketReminderConfig != null) {
                        Iterator<RemindAppInfo> it2 = marketReminderConfig.iterator();
                        while (it2.hasNext() && ((r10 = it2.next()) == null || !"pro.huobi".equalsIgnoreCase(r10.getPackageName()) || 105400 < r10.getVersionCode())) {
                        }
                    }
                    List<String> h5JumpUrl = moduleConfig.getH5JumpUrl();
                    if (h5JumpUrl != null) {
                        HbgRouter.l(h5JumpUrl);
                        HashSet hashSet = new HashSet();
                        hashSet.addAll(h5JumpUrl);
                        t.a("h5_huobi_url_whitelist").g("h5_huobi_url_whitelist", hashSet);
                    }
                    o.k(moduleConfig.getOtcAuthHost());
                    try {
                        k.f("DOMAIN_TEST", "SA server url " + moduleConfig.getSaDataReportUrl());
                        if (!TextUtils.isEmpty(moduleConfig.getSaDataReportUrl())) {
                            i.b().f(new b(moduleConfig));
                        }
                    } catch (Exception e11) {
                        k.g("DOMAIN_TEST", "SA server url ", e11);
                    }
                    try {
                        k.f("DOMAIN_TEST", "WoodPecker url " + moduleConfig.getWoodPeckerHost());
                        if (!TextUtils.isEmpty(moduleConfig.getWoodPeckerHost())) {
                            i.b().f(new a(moduleConfig));
                        }
                    } catch (Exception e12) {
                        k.g("DOMAIN_TEST", "WoodPecker url ", e12);
                    }
                    k.f("DOMAIN_TEST", "getHbgAnalyticsUrl " + moduleConfig.getHbgAnalyticsUrl());
                    c.c().i(moduleConfig.getHbgAnalyticsUrl());
                }
                if (inviteInfo != null) {
                    if (!TextUtils.isEmpty(inviteInfo.getShareCnUrl())) {
                        domainInfo2.q(inviteInfo.getShareCnUrl());
                    }
                    if (!TextUtils.isEmpty(inviteInfo.getShareEnUrl())) {
                        domainInfo2.r(inviteInfo.getShareEnUrl());
                    }
                    if (!TextUtils.isEmpty(inviteInfo.getShareOverseaCnUrl())) {
                        domainInfo2.s(inviteInfo.getShareOverseaCnUrl());
                    }
                    if (!TextUtils.isEmpty(inviteInfo.getShareOverseaEnUrl())) {
                        domainInfo2.t(inviteInfo.getShareOverseaEnUrl());
                    }
                }
                if (inviteInfo != null) {
                    if (!TextUtils.isEmpty(inviteInfo.getShareCnUrl())) {
                        domainInfo2.q(inviteInfo.getShareCnUrl());
                    }
                    if (!TextUtils.isEmpty(inviteInfo.getShareEnUrl())) {
                        domainInfo2.r(inviteInfo.getShareEnUrl());
                    }
                    if (!TextUtils.isEmpty(inviteInfo.getShareOverseaCnUrl())) {
                        domainInfo2.s(inviteInfo.getShareOverseaCnUrl());
                    }
                    if (!TextUtils.isEmpty(inviteInfo.getShareOverseaEnUrl())) {
                        domainInfo2.t(inviteInfo.getShareOverseaEnUrl());
                    }
                }
                if (otherConfig != null) {
                    o.j(otherConfig);
                }
                if (aliyunConfig != null) {
                    o.i(aliyunConfig);
                }
                k(domainInfo2, smartDomainData);
                domainInfo2.z(remoteDomain.getSmartDomain());
                return domainInfo2;
            } catch (Exception e13) {
                e = e13;
                domainInfo = domainInfo2;
                e.printStackTrace();
                return domainInfo;
            }
        } catch (Exception e14) {
            e = e14;
            e.printStackTrace();
            return domainInfo;
        }
    }

    public static DomainInfo k(DomainInfo domainInfo, SmartDomainData smartDomainData) {
        x.d();
        SmartRemoteDefaultConfig smartRemoteDefaultConfig = new SmartRemoteDefaultConfig();
        if (domainInfo == null) {
            return domainInfo;
        }
        if (smartDomainData != null) {
            if (!x.e(smartDomainData.getSpot())) {
                domainInfo.F(smartDomainData.getUrlList(smartDomainData.getSpot()));
                smartRemoteDefaultConfig.setSpotDefault(smartDomainData.getUrlList(smartDomainData.getSpot()).get(0));
            }
            if (!x.e(smartDomainData.getOtc())) {
                domainInfo.E(smartDomainData.getUrlList(smartDomainData.getOtc()));
                smartRemoteDefaultConfig.setOtcDefault(smartDomainData.getUrlList(smartDomainData.getOtc()).get(0));
            }
            if (!x.e(smartDomainData.getIndex())) {
                domainInfo.C(smartDomainData.getUrlList(smartDomainData.getIndex()));
                smartRemoteDefaultConfig.setDmIndexDefault(smartDomainData.getUrlList(smartDomainData.getIndex()).get(0));
            }
            if (!x.e(smartDomainData.getContract())) {
                domainInfo.x(smartDomainData.getUrlList(smartDomainData.getContract()));
                smartRemoteDefaultConfig.setContractDefault(smartDomainData.getUrlList(smartDomainData.getContract()).get(0));
            }
            if (!x.e(smartDomainData.getGlobalMobile())) {
                domainInfo.A(smartDomainData.getUrlList(smartDomainData.getGlobalMobile()));
                smartRemoteDefaultConfig.setGlobalMobileDefault(smartDomainData.getUrlList(smartDomainData.getGlobalMobile()).get(0));
            }
            if (!x.e(smartDomainData.getGlobalWeb())) {
                domainInfo.B(smartDomainData.getUrlList(smartDomainData.getGlobalWeb()));
                smartRemoteDefaultConfig.setGlobalWebDefault(smartDomainData.getUrlList(smartDomainData.getGlobalWeb()).get(0));
            }
            if (!x.e(smartDomainData.getKycWeb())) {
                domainInfo.D(smartDomainData.getUrlList(smartDomainData.getKycWeb()));
                smartRemoteDefaultConfig.setKycWebDefault(smartDomainData.getUrlList(smartDomainData.getKycWeb()).get(0));
            }
            if (!x.e(smartDomainData.getDmH5())) {
                domainInfo.y(smartDomainData.getUrlList(smartDomainData.getDmH5()));
                smartRemoteDefaultConfig.setContractH5Default(smartDomainData.getUrlList(smartDomainData.getDmH5()).get(0));
            }
            if (!x.e(smartDomainData.getInstitution())) {
                domainInfo.p(smartDomainData.getUrlList(smartDomainData.getInstitution()));
                smartRemoteDefaultConfig.setInstitutionDefault(smartDomainData.getUrlList(smartDomainData.getInstitution()).get(0));
            }
            if (!x.e(smartDomainData.getOtc())) {
                domainInfo.E(smartDomainData.getUrlList(smartDomainData.getOtc()));
                smartRemoteDefaultConfig.setOtcDefault(smartDomainData.getUrlList(smartDomainData.getOtc()).get(0));
            }
        }
        domainInfo.w(smartRemoteDefaultConfig);
        return domainInfo;
    }
}
