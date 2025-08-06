package com.huobi.constants;

public enum Environment {
    DEV1("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
    DEV2("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
    DEV3("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
    DEV4("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
    DEV5("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
    DEV5_5("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
    DEV5_5_NEW("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
    DEV6("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
    DEV6_YD("http://www.test-6.huobiapps.com/", "account/login.php", "http://pro-web.test-6.huobiapps.com/", "ws://pro-web.test-6.huobiapps.com/-/s/pro/ws", "ws://hbg-c2c-np.test-6.huobiapps.com/ws", "http://pro-web.test-6.huobiapps.com", "http://bitex-uc-gateway.test-6.huobiapps.com/", "http://otc-api.base.tc-jp1.huobiapps.com/", "http://etf--test-6.huobiapps.com", "http://m.test-6.huobiapps.com", "http://test-6.dm.huobiapps.com/", "ws://test-6.dm.huobiapps.com/ws", "http://h5.test-6.dm.huobiapps.com", "ws://172.18.1.104:35240/wps", "http://pro-web.test-6.huobiapps.com/-/x/rca/", "http://test-6.dm.huobiapps.com/", "ws://test-6.dm.huobiapps.com/swap-ws", "http://h5.test-6.dm.huobiapps.com", "ws://test-6.dm.huobiapps.com/linear-swap-ws", "http://test-6.dm.huobiapps.com/", "ws://test-6.dm.huobiapps.com/option-ws", "http://h5.test-6.dm.huobiapps.com", "http://test-6.dm.huobiapps.com/", "ws://test-6.dm.huobiapps.com/ws_index", "http://huobi-woodpecker-app.test-6.huobiapps.com", "http://institution-onboard-ui.test-6.huobiapps.com", "http://fed-kyc.test-6.huobiapps.com"),
    DEV7("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
    DEV8("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
    DEV10("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
    DEV11("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
    DEV13("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
    DEV15("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
    DEV16("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
    DEV17("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
    DEV20("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
    DEV20_20("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
    DEV20_20_NEW("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""),
    RELEASE("https://l10n-www.huobi.cn/", "huobi.com/account/login.php", "https://l10n-api.huobi.cn/", "wss://l10n-api.huobi.cn/ws", "wss://l10n-api.huobi.cn/-/s/ws", "https://l10n-pro.huobi.cn/pro-hybird-html5", "https://l10n-uc.huobi.cn/", "https://l10n-otc-api.huobi.cn/", "https://l10n-api.huobi.cn/", "https://m.huobi.com", "https://l10n-dm.huobi.cn/", "wss://l10n-dm.huobi.cn/ws", "https://h.hbdm.com/", "wss://l10n-pro.dangpu.com/-/s/hbg/ws", "https://l10n-api.huobi.cn/", "https://l10n-dm.huobi.cn/", "wss://l10n-dm.huobi.cn/swap-ws", "https://h.hbdm.com/", "wss://l10n-dm.huobi.cn/linear-swap-ws", "https://l10n-dm.huobi.cn/", "wss://l10n-dm.huobi.cn/option-ws", "https://h.hbdm.com/", "https://l10n-dm-index.xfilecache.com/", "wss://l10n-dm-index.xfilecache.com/ws_index", "https://open.woodpeckerlog.com/-/x/woodpecker", "https://institution.trygofast.com/", "https://kyc.huobi.com");
    
    public String contractH5Base;
    public String contractSocketBase;
    public String contract_base;
    public String etf_base;
    public String hbg_socket;
    public String huobi_login_check;
    public String huobi_php;
    public String indexBase;
    public String indexSocketBase;
    public String institutionBase;
    public String kycWebBaseUrl;
    public String linearSwapSocketBase;
    public String m_base;
    public String optionBase;
    public String optionH5Base;
    public String optionSocketBase;
    public String otcOrderReminderSocket;
    public String otc_base;
    public String pro_base;
    public String pro_h5_base;
    public String pro_socket;
    public String riskBase;
    public String swapBase;
    public String swapH5Base;
    public String swapSocketBase;
    public String uc_base;
    public String woodPackerBase;

    private Environment(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27) {
        this.huobi_php = str;
        this.huobi_login_check = str2;
        this.pro_base = str3;
        this.pro_socket = str4;
        this.hbg_socket = str5;
        this.pro_h5_base = str6;
        this.uc_base = str7;
        this.otc_base = str8;
        this.etf_base = str9;
        this.m_base = str10;
        this.contract_base = str11;
        this.contractSocketBase = str12;
        this.contractH5Base = str13;
        this.otcOrderReminderSocket = str14;
        this.riskBase = str15;
        this.swapBase = str16;
        this.swapSocketBase = str17;
        this.swapH5Base = str18;
        this.linearSwapSocketBase = str19;
        this.optionBase = str20;
        this.optionSocketBase = str21;
        this.optionH5Base = str22;
        this.indexBase = str23;
        this.indexSocketBase = str24;
        this.woodPackerBase = str25;
        this.institutionBase = str26;
        this.kycWebBaseUrl = str27;
    }
}
