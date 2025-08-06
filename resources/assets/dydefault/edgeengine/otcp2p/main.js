const SiteType = {
    BRAND: 0,
    NORMAL: 1
};

const tradePairs = {
    coinId: undefined,
    coinName: "",
    currency: undefined,
    currencyName: "",
    symbol: ""
};

const config = {
    tradeType: "buy",
    currentSiteType: undefined,
    isAdvertMode: undefined,
    normal: {
        ...tradePairs
    },
    brand: {
        ...tradePairs
    },
    get target() {
        if (this.currentSiteType === undefined) {
            return undefined;
        }
        return this.currentSiteType === SiteType.BRAND ? this.brand : this.normal;
    },
    updateConfigTradingPairs: function(param) {
        const {coinName: coinName, coinId: coinId, currency: currency, symbol: symbol, currencyName: currencyName, siteType: siteType} = param;
        var updateParams = {};
        var target = this.target;
        if (siteType !== undefined) {
            target = siteType == 0 ? this.brand : this.normal;
        }
        if (coinName && target.coinName != coinName && coinId !== undefined && target.coinId != coinId) {
            target.coinId = coinId;
            target.coinName = coinName;
            updateParams.coinId = coinId;
            updateParams.coinName = coinName;
        }
        if (currencyName && target.currencyName != currencyName && currency !== undefined && target.currency != currency && symbol && target.symbol != symbol) {
            target.currency = currency;
            target.currencyName = currencyName;
            target.symbol = symbol;
            updateParams.currency = currency;
            updateParams.currencyName = currencyName;
            updateParams.symbol = symbol;
        }
        return updateParams;
    }
};

Object.entries(tradePairs).forEach((([prop]) => {
    Object.defineProperty(config, prop, {
        enumerable: true,
        configurable: true,
        get() {
            return (config.target && config.target[prop]) ?? tradePairs[prop];
        },
        set(value) {
            if (config.target) {
                config.target[prop] = value;
            }
        }
    });
}));

var commanData = {
    iconURLHost: "",
    colorMode: 0,
    OS: "",
    appVersion: "",
    language: "",
    uid: "",
    pageBottomOffset: 0,
    screenWidth: 0,
    screenHeight: 0
};

async function sendRequest(path, params = {}, method = 0, hostType = 1, header = {}) {
    console.log(`request ${path}`);
    const param = {
        path: path,
        method: method,
        hostType: hostType,
        header: header,
        params: params
    };
    try {
        var responseString = responseString = await $nativeAPI.request(JSON.stringify(param));
        var response = JSON.parse(responseString);
        var {code: code} = response;
        if (code == 200) {
            console.log(`request ${path} done`);
            return response;
        } else {
            console.log(`request failed, code=${code}`);
            return response;
        }
    } catch (e) {
        console.log(`request error, error=${e}`);
        return null;
    }
}

function getIconURL(currency) {
    var coinName = currency.toLowerCase();
    const iconURL = `https://${commanData.iconURLHost}/-/x/hb/p/api/contents/currency/icon_png/${coinName}.png`;
    return iconURL;
}

let clickTimer = 0;

function clickThrottle(interval = 1e3) {
    let now = +new Date;
    let timer = clickTimer;
    if (now - timer < interval) {
        return false;
    } else {
        clickTimer = now;
        return true;
    }
}

async function openURL(url) {
    if (!clickThrottle()) return;
    $nativeAPI.openRoute(url);
}

async function save(module, key, data) {
    await $nativeAPI.storage({
        action: "save",
        name: module,
        key: key,
        data: JSON.stringify(data)
    });
}

async function read(module, key) {
    const data = await $nativeAPI.storage({
        action: "read",
        name: module,
        key: key
    });
    if (data && data != "") {
        return JSON.parse(data);
    }
    return null;
}

async function analytics(event = "", properties = {}) {
    const propertiesJson = JSON.stringify(properties);
    var map = {
        event: event,
        properties: propertiesJson
    };
    await $nativeAPI.analytics(map);
}

function parseCommonConfig(param) {
    commanData.colorMode = parseInt(param.colorMode);
    commanData.iconURLHost = param.iconURLHost;
    commanData.OS = parseInt(param.OS);
    commanData.appVersion = param.appVersion;
    commanData.language = param.language;
    commanData.uid = param.uid;
    commanData.pageBottomOffset = param.pageBottomOffset;
    commanData.screenWidth = param.screenWidth;
    commanData.screenHeight = param.screenHeight;
}

function moduleDefine(moduleName, startFunction, defaultDataFunction) {
    $data[moduleName] = defaultDataFunction();
    $event[moduleName] = {
        start: startFunction
    };
    return {
        moduleEvent: $event[moduleName],
        moduleData: $data[moduleName]
    };
}

function parseRequestParams(requestJson) {
    if (typeof requestJson === "string" || requestJson instanceof String) {
        return JSON.parse(requestJson);
    }
    return requestJson;
}

function thousandsFormatter(number) {
    let numberString = number.toString();
    if (numberString.includes(",")) {
        return numberString;
    }
    let [integerPart, decimalPart] = numberString.split(".");
    integerPart = integerPart.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    if (decimalPart) {
        return integerPart + "." + decimalPart;
    } else {
        return integerPart;
    }
}

const advertRequstCommonData = {
    coinId: 2,
    currency: undefined,
    tradeType: "sell",
    onlyTradable: false,
    currPage: 1,
    blockType: "general",
    amount: "",
    payMethod: ""
};

const normalAdvertParams = {
    isTraded: false,
    isThumbsUp: false,
    isFollowed: false,
    seaViewRoom: 0,
    labelId: "",
    isMerchant: false,
    makerCompleteRate: 0,
    merchantTags: "",
    ...advertRequstCommonData
};

const brandAdvertParams = {
    ...advertRequstCommonData,
    blockType: "brand",
    brandLabelIds: "",
    labelId: ""
};

const reqeust = {
    brand: {
        ...brandAdvertParams
    },
    normal: {
        ...normalAdvertParams
    },
    setParams(siteType, value) {
        if (value != config.tradeType || value.currPage == 0) {
            value.currPage = 1;
        }
        if (siteType == SiteType.BRAND) {
            this.brand = value;
        } else {
            this.normal = value;
        }
    },
    getParams(siteType) {
        return siteType == SiteType.BRAND ? this.brand : this.normal;
    },
    getEndPoint(siteType) {
        return siteType == SiteType.BRAND ? "v1/advertise/data/trade-market/brand" : "v1/data/trade-market";
    },
    reset() {
        this.brand = {
            ...brandAdvertParams
        };
        this.normal = {
            ...normalAdvertParams
        };
    },
    hasSelectedMore(siteType) {
        if (siteType == SiteType.BRAND) {
            return this.brand.brandLabelIds !== "" || this.brand.labelId !== "";
        } else {
            return this.normal.isFollowed || this.normal.isMerchant || this.normal.isTraded || this.normal.isThumbsUp || this.normal.merchantTags.length > 0 && this.normal.tradeType == "buy" || this.normal.makerCompleteRate > 0 || this.normal.labelId !== "" || this.normal.blockType === "block";
        }
    }
};

function getCurrentRequestParams(siteType) {
    return reqeust.getParams(siteType);
}

function resetParams() {
    reqeust.reset();
}

function resetLabelId(siteType) {
    reqeust.getParams(siteType).labelId = "";
}

function resetMerchantTags(siteType) {
    reqeust.getParams(siteType).merchantTags = "";
}

function hasSelectedMore(siteType) {
    return reqeust.hasSelectedMore(siteType);
}

function updateAdvertListWithFilterParams$1(siteType, json) {
    reqeust.setParams(siteType, {
        ...reqeust.getParams(siteType),
        ...json
    });
    return reqeust.hasSelectedMore(siteType);
}

async function refreshAdvertList$1(siteType) {
    reqeust.getParams(siteType).currPage = 1;
    return await loadAdvertListDatas(siteType);
}

async function loadMoreAdvertList$1(siteType) {
    reqeust.getParams(siteType).currPage++;
    return await loadAdvertListDatas(siteType);
}

async function loadAdvertListDatas(siteType) {
    const endpoint = reqeust.getEndPoint(siteType);
    const params = reqeust.getParams(siteType);
    console.log(JSON.stringify(params));
    const response = await sendRequest(endpoint, params);
    if (response) {
        if (response.success) {
            const {currPage: currPage, success: success, message: message, totalPage: totalPage, data: data, extend: extend} = response;
            console.log("updateTradingPairs P2P list data loaded successfully:", data);
            reqeust.getParams(siteType).currPage = currPage;
            var hasMore = currPage < totalPage;
            return {
                extend: extend,
                datas: data,
                hasMore: hasMore,
                siteType: siteType
            };
        } else if (response.message !== undefined) {
            console.error("updateTradingPairs Failed to load P2P list data:", response.message);
            return {};
        }
    } else {
        return null;
    }
}

async function loadSeaviewRoomDatasWithTopThree() {
    if (reqeust.getParams(SiteType.NORMAL).coinId != 2) {
        return {
            datas: []
        };
    }
    try {
        const response = await sendRequest("v1/data/trade-market", {
            ...reqeust.getParams(SiteType.NORMAL),
            seaViewRoom: 1,
            currPage: 1,
            pageSize: 3
        });
        const {success: success, message: message, data: data} = response;
        if (success) {
            console.log("updateTradingPairs P2P list data loaded successfully:", data);
            return {
                datas: data
            };
        } else {
            console.error("updateTradingPairs Failed to load P2P list data:", message);
            return {};
        }
    } catch (error) {
        console.error("updateTradingPairs error to load P2P list data:", error);
        return null;
    }
}

async function start() {
    console.log(`advertFilter.js start`);
}

const tradeLimit = {
    hasBindCard: false,
    hasAuthRealname: false,
    hasBindPhone: false,
    closeOfflineByManual: false,
    closeTradeTipsByManual: false
};

const propertyDefinitions = {
    tradable: false,
    tradableSwitchIcon: "@drawable/otc_advert_filter_switch_normal",
    cryptoCurrency: "USDT",
    cryptoIcon: "",
    amount: "",
    amountTextColor: "@color/kColorPrimaryText",
    payMethod: "",
    payMethodTextColor: "@color/kColorPrimaryText",
    moreCondition: "",
    moreIcon: "@drawable/trade_otc_optional_icon_filter_nol",
    direction: "buy",
    currencyName: "",
    buyTabStyle: {
        textColor: "@color/kColorPrimaryText"
    },
    sellTabStyle: {
        textColor: "@color/kColorSecondaryText"
    }
};

const {moduleData: moduleData$5, moduleEvent: moduleEvent$4} = moduleDefine("p2pFilter", start, defaultData$5);

const dataHelper$1 = {};

Object.entries(propertyDefinitions).forEach((([prop, defaultValue]) => {
    Object.defineProperty(dataHelper$1, prop, {
        enumerable: true,
        configurable: true,
        get() {
            const target = moduleData$5.siteType === SiteType.NORMAL ? moduleData$5.normal : moduleData$5.brand;
            return target[prop] ?? defaultValue;
        },
        set(value) {
            const target = moduleData$5.siteType === SiteType.NORMAL ? moduleData$5.normal : moduleData$5.brand;
            target[prop] = value;
        }
    });
}));

function defaultData$5() {
    return {
        siteType: SiteType.BRAND,
        normal: {
            ...propertyDefinitions
        },
        brand: {
            ...propertyDefinitions
        },
        offlineTips: "",
        offlineTipsVisible: "gone",
        tradeTipsVisible: "gone",
        buyTradeTips: "",
        sellTradeTips: "",
        buyTradeTipsVisible: "gone",
        sellTradeTipsVisible: "gone",
        updateTradeTips(type, tips = "") {
            if (type == 1) {
                this.buyTradeTipsVisible = tips.length > 0 ? "visible" : "gone";
                this.sellTradeTipsVisible = "gone";
                this.tradeTipsVisible = tips.length > 0 ? "visible" : "gone";
                if (this.buyTradeTips !== tips) {
                    this.buyTradeTips = tips;
                }
            } else if (type == 2) {
                this.buyTradeTipsVisible = "gone";
                this.sellTradeTipsVisible = tips.length > 0 ? "visible" : "gone";
                this.tradeTipsVisible = tips.length > 0 ? "visible" : "gone";
                if (this.sellTradeTips !== tips) {
                    this.sellTradeTips = tips;
                }
            } else {
                this.buyTradeTipsVisible = this.buyTradeTips.length > 0 ? "visible" : "gone";
                this.sellTradeTipsVisible = this.sellTradeTips.length > 0 ? "visible" : "gone";
                this.tradeTipsVisible = (this.buyTradeTips.length > 0 || this.sellTradeTips.length > 0) > 0 ? "visible" : "gone";
            }
        }
    };
}

moduleEvent$4.closeTipsWithMerchantOffline = () => {
    moduleData$5.offlineTipsVisible = "gone";
    tradeLimit.closeOfflineByManual = true;
};

moduleEvent$4.closeTipsWithTrade = () => {
    moduleData$5.tradeTipsVisible = "gone";
    tradeLimit.closeTradeTipsByManual = true;
    analytics(moduleData$5.siteType == SiteType.BRAND ? "otc_p2p_adlist_brand" : "otc_p2p_adlist", {
        otc_step: "otc_p2p_newUserTip_close_click",
        side: getTradeType()
    });
};

function updateStyleWithDirection(direction) {
    dataHelper$1.direction = direction;
    let normalStyle = {
        textColor: "@color/kColorSecondaryText"
    };
    let selectedStyle = {
        textColor: "@color/kColorPrimaryText"
    };
    if (direction == "buy") {
        dataHelper$1.buyTabStyle = selectedStyle;
        dataHelper$1.sellTabStyle = normalStyle;
    } else if (direction == "sell") {
        dataHelper$1.buyTabStyle = normalStyle;
        dataHelper$1.sellTabStyle = selectedStyle;
    }
    checkTradeLimit();
}

function resetDataServiceSelection() {
    resetLabelId(config.currentSiteType);
    if (config.currentSiteType == SiteType.NORMAL) {
        resetMerchantTags(SiteType.NORMAL);
    }
}

moduleEvent$4.clickFilterOptionWithDirection = async direction => {
    if (dataHelper$1.direction == direction) {
        return;
    }
    updateStyleWithDirection(direction);
    resetDataServiceSelection();
    $nativeAPI.p2pFilterBridge({
        action: "onFilterOptionWithDirection",
        params: direction
    });
    $event.refreshAdvertListWithTradeType(direction);
    updateMoreSelectionStyle(hasSelectedMore(config.currentSiteType));
    analytics(moduleData$5.siteType == SiteType.BRAND ? "otc_p2p_adlist_brand" : "otc_p2p_adlist", {
        otc_step: "click_buysell",
        spm: direction == "buy" ? "otc.adlist.page.change_buy" : "otc.adlist.page.change_sell",
        coin_name: config.target.coinName,
        side: direction
    });
};

moduleEvent$4.clickFilterOptionWithCryptoCurrency = () => {
    $nativeAPI.p2pFilterBridge({
        action: "onFilterOptionWithCryptoCurrency",
        params: ""
    });
};

moduleEvent$4.clickFilterOptionWithAmount = () => {
    $nativeAPI.p2pFilterBridge({
        action: "onFilterOptionWithAmount"
    });
};

moduleEvent$4.clickFilterOptionWithPayMehod = () => {
    $nativeAPI.p2pFilterBridge({
        action: "onFilterOptionWithPayMehod"
    });
};

moduleEvent$4.clickFilterOptionWithTradable = async () => {
    dataHelper$1.tradable = !dataHelper$1.tradable;
    dataHelper$1.tradableSwitchIcon = dataHelper$1.tradable ? "@drawable/otc_advert_filter_switch_select" : "@drawable/otc_advert_filter_switch_normal";
    $event.refreshAdvertListWithTradable(dataHelper$1.tradable);
    analytics(moduleData$5.siteType == SiteType.BRAND ? "otc_p2p_adlist_brand" : "otc_p2p_adlist", {
        otc_step: "otc_p2p_avaliableSwtch_click",
        open: dataHelper$1.tradable,
        side: getTradeType()
    });
};

moduleEvent$4.clickFilterOptionWithMore = () => {
    $nativeAPI.p2pFilterBridge({
        action: "onFilterOptionWithMore"
    });
    analytics(moduleData$5.siteType == SiteType.BRAND ? "otc_p2p_adlist_brand" : "otc_p2p_adlist", {
        otc_step: "otc_trade_merchant_filter_click",
        coin_name: config.target.coinName,
        side: getTradeType()
    });
};

function updateMoreSelectionStyle(hasSelectedMore) {
    dataHelper$1.moreIcon = hasSelectedMore ? "@drawable/trade_otc_optional_icon_filter_sel" : "@drawable/trade_otc_optional_icon_filter_nol";
}

function updateStyle(advertRequestParams, coinName) {
    this.updateStyleWithTradingPairs(coinName, advertRequestParams.currencyName);
    dataHelper$1.amount = advertRequestParams.amount != undefined ? advertRequestParams.amount : dataHelper$1.amount;
    dataHelper$1.amountTextColor = dataHelper$1.amount.trim().length === 0 ? "@color/kColorPrimaryText" : "@color/kColorMajorTheme100";
    updateMoreSelectionStyle(advertRequestParams.selectedMore);
    if (advertRequestParams.payMethod == undefined) {
        var selectedPaymethod = dataHelper$1.payMethod && dataHelper$1.payMethod !== "0" && advertRequestParams.payMethod !== 0;
        dataHelper$1.payMethodTextColor = selectedPaymethod ? "@color/kColorMajorTheme100" : "@color/kColorPrimaryText";
    } else {
        var selectedPaymethod = advertRequestParams.payMethod && advertRequestParams.payMethod !== "0";
        dataHelper$1.payMethod = selectedPaymethod ? advertRequestParams.payMethod : "0";
        dataHelper$1.payMethodTextColor = selectedPaymethod ? "@color/kColorMajorTheme100" : "@color/kColorPrimaryText";
    }
}

function updateStyleWithTradingPairs(coinName, currencyName, siteType) {
    const target = siteType != undefined ? siteType == SiteType.BRAND ? moduleData$5.brand : moduleData$5.normal : dataHelper$1;
    if (coinName != undefined) {
        target.cryptoCurrency = coinName.toUpperCase();
        target.cryptoIcon = getIconURL(coinName);
    }
    if (currencyName != undefined) {
        target.currencyName = currencyName;
    }
}

async function checkAdvertPushlishStatus() {
    if (tradeLimit.closeOfflineByManual) {
        return;
    }
    var repos = await Promise.all([ sendRequest("/v1/user/notice/switch"), sendRequest("/v1/data/trade-list/app", {
        currPage: 0,
        seaViewRoom: 0
    }) ]);
    var online = repos[0].data.app_advert;
    var hasAdvert = repos[1].data.length > 0;
    var showTips = !(online && hasAdvert);
    moduleData$5.offlineTipsVisible = showTips ? "visible" : "gone";
    if (showTips) {
        moduleData$5.offlineTips = getClickContent($i18n.n_otc_advert_opt_ad_maker_state_tip, $i18n.n_otc_advert_opt_button_text_to_advert, "@event.p2pFilter.onSwitchPage('toSetAdverts')");
    } else {
        moduleData$5.offlineTips = "";
    }
}

function getClickContent(content, clickText, actionDesc) {
    const color = commanData.colorMode == 0 ? "#000000" : "#E6E6E6";
    let desc = `<span style="font-size:12px; font-weight=200; color:${color};">${content}</span>`;
    let toSettingsText = `<span style="font-size:12px; font-weight=200; color:@color/baseColorMajorTheme100;">${clickText}</span>`;
    return `${desc}<a href=${actionDesc}>${toSettingsText}</a>`;
}

function onSwitchPage(target, params = "") {
    switch (target) {
      case "toSetAdverts":
        $nativeAPI.p2pFilterBridge({
            action: "onSwitchPage",
            params: {
                target: target,
                params: params
            }
        });
        break;

      default:
        openURL(target);
        break;
    }
}

moduleEvent$4.toKycAuthentication = function() {
    onSwitchPage("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/account/kyc?authBizCode=OTC");
    analytics(moduleData$5.siteType == SiteType.BRAND ? "otc_p2p_adlist_brand" : "otc_p2p_adlist", {
        otc_step: "otc_p2p_progress_kyc"
    });
};

moduleEvent$4.toBindPhone = function() {
    if (commanData.OS == 0) {
        openURL("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/securityCenter/bindPhone");
    } else {
        $nativeAPI.p2pFilterBridge({
            action: "onSwitchPage",
            params: {
                target: "toBindPhone"
            }
        });
    }
    analytics(moduleData$5.siteType == SiteType.BRAND ? "otc_p2p_adlist_brand" : "otc_p2p_adlist", {
        otc_step: "otc_p2p_progress_tradingsetting"
    });
};

moduleEvent$4.toAddPayment = async function() {
    var repos = await Promise.all([ sendRequest("/v1/user/info"), sendRequest("/v1/user/system/setting/key", {
        key: "downgradeFundPassword"
    }) ]);
    const {isTradeBind: isTradeBind, verifyWayHaveSet: verifyWayHaveSet} = repos[0].data;
    const {downgradeFundPassword: downgradeFundPassword} = repos[1].data;
    console.log(`downgradeFundPassword ========= ${downgrade}`);
    var downgrade = false;
    if (downgradeFundPassword instanceof Boolean) {
        downgrade = downgradeFundPassword;
    }
    if (downgrade) {
        if (isTradeBind) {
            onSwitchPage("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/otc/paymentList");
        } else {
            onSwitchPage("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/securityCenter/setFundPassword?willVerification=false");
        }
    } else {
        if (verifyWayHaveSet) {
            onSwitchPage("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/otc/paymentList");
        } else {
            onSwitchPage("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/otc/trade/p2PTradingLeading");
        }
    }
    analytics(moduleData$5.siteType == SiteType.BRAND ? "otc_p2p_adlist_brand" : "otc_p2p_adlist", {
        otc_step: "otc_p2p_progress_addpayment"
    });
};

moduleEvent$4.clickFilterOptionWithCurrency = function(siteType) {
    console.log(`clickFilterOptionWithCurrency === ${siteType}`);
    $nativeAPI.p2pFilterBridge({
        action: "onFilterOptionWithCurrency"
    });
};

async function checkTradeLimit() {
    if (tradeLimit.closeTradeTipsByManual) {
        return;
    }
    var getTradeLimitTipsWithRealname = async function() {
        if (!tradeLimit.hasAuthRealname) {
            var res = await sendRequest("/v1/user/kyc");
            tradeLimit.hasAuthRealname = res.data.authLevel >= 2;
            if (!tradeLimit.hasAuthRealname) {
                return getClickContent($i18n.n_otc_guide_tips_real_name, $i18n.n_otc_go_verification, "@event.p2pFilter.toKycAuthentication()");
            } else {
                return "";
            }
        } else {
            return "";
        }
    };
    if (dataHelper$1.direction == "buy") {
        var tips = await getTradeLimitTipsWithRealname();
        if (tips.length == 0) {
            if (!tradeLimit.hasBindPhone) {
                var verifyRes = await sendRequest("/v1/user/verify/ways");
                tradeLimit.hasBindPhone = verifyRes.data.ucPhoneStatus != 1;
                if (!tradeLimit.hasBindPhone) {
                    tips = getClickContent($i18n.n_otc_guide_tips_bind_phone, $i18n.n_otc_advert_trade_p2p_new_user_bind_phone, "@event.p2pFilter.toBindPhone()");
                }
            }
        }
        moduleData$5.updateTradeTips(1, tips);
    } else {
        var tips = "";
        if (!tradeLimit.hasBindCard) {
            var accountRes = await sendRequest("/v1/user/receipt-account");
            tradeLimit.hasBindCard = accountRes.data.length > 0;
            if (!tradeLimit.hasBindCard) {
                tips = getClickContent($i18n.n_otc_guide_tips_add_pay_method, $i18n.n_otc_advert_trade_p2p_new_user_go_add_payMethod, "@event.p2pFilter.toAddPayment()");
            } else {
                tips = await getTradeLimitTipsWithRealname();
            }
        } else {
            tips = await getTradeLimitTipsWithRealname();
        }
        moduleData$5.updateTradeTips(2, tips);
    }
    var showTips = moduleData$5.buyTradeTips.length > 0 || moduleData$5.sellTradeTips.length > 0;
    if (showTips) {
        analytics(moduleData$5.siteType == SiteType.BRAND ? "otc_p2p_adlist_brand" : "otc_p2p_adlist", {
            otc_step: dataHelper$1.direction == "buy" ? "otc_p2p_progress_buy" : "otc_p2p_progress_sell"
        });
    }
}

function loadTradeTipsInfo() {
    checkTradeLimit();
    if (config.isAdvertMode == true) {
        checkAdvertPushlishStatus();
    } else {
        moduleData$5.offlineTipsVisible = "gone";
    }
}

function changeSite(to) {
    moduleData$5.siteType = to;
    if (dataHelper$1.cryptoIcon == "") {
        dataHelper$1.cryptoIcon = getIconURL(dataHelper$1.cryptoCurrency);
    }
    loadTradeTipsInfo();
    analytics(moduleData$5.siteType == SiteType.BRAND ? "otc_p2p_adlist_brand" : "otc_p2p_adlist", {
        otc_step: "switch"
    });
}

function getTradeType() {
    return dataHelper$1.direction;
}

function getAmount() {
    return dataHelper$1.amount;
}

function getPayment() {
    return dataHelper$1.payMethod;
}

moduleEvent$4.onSwitchPage = onSwitchPage;

const {moduleData: moduleData$4} = moduleDefine("otcBanner", (() => {}), defaultData$4);

function defaultData$4() {
    const contentData = {
        datas: "",
        contentHeight: "0",
        bottomPadding: "0"
    };
    return {
        siteType: SiteType.BRAND,
        normal: {
            ...contentData
        },
        brand: {
            ...contentData
        },
        getDatas() {
            return this.siteType === SiteType.NORMAL ? this.normal.datas : this.brand.datas;
        },
        setDatas(value) {
            var target = this.siteType === SiteType.NORMAL ? this.normal : this.brand;
            target.datas = value;
            if (commanData.OS == 1) {
                target.contentHeight = value.length > 0 ? "70" : "0";
                target.bottomPadding = "0";
            } else {
                const bannerHeight = Math.ceil((commanData.screenWidth - 32) * 54 / 343);
                target.contentHeight = value.length > 0 ? `${bannerHeight}dp` : "0dp";
                target.bottomPadding = value.length > 0 ? "16" : "0";
            }
        },
        claerCache() {
            this.normal = {
                ...contentData
            };
            this.brand = {
                ...contentData
            };
        }
    };
}

async function refreshBanner(type, currencyName, clear = false) {
    if (type == undefined || currencyName.length == 0) {
        return;
    }
    moduleData$4.siteType = type;
    if (commanData.OS == 1) {
        var target = type === SiteType.NORMAL ? moduleData$4.brand : moduleData$4.normal;
        target.contentHeight = 0;
    }
    if (clear) {
        moduleData$4.claerCache();
    }
    var cacheDatas = moduleData$4.getDatas();
    if (cacheDatas.length == 0) {
        var datas = await loadP2pBannerDatas(type, currencyName);
        moduleData$4.setDatas(datas);
    } else {
        moduleData$4.setDatas(cacheDatas);
    }
}

async function loadP2pBannerDatas(type, currencyName) {
    var eventId = type == SiteType.NORMAL ? "502" : "503";
    var {data: data} = await sendRequest("/v1/trade/mktRule/run", {
        appPageId: 50,
        mgtRuleSceneCode: "page_init",
        eventId: eventId,
        currencyAssetName: currencyName
    });
    if (data && data.pageList) {
        var picKey = commanData.colorMode == 0 ? "day" : "night";
        var datas = data.pageList.filter((item => item.content.some((contentItem => contentItem.type === 10))));
        datas = datas.map((item => {
            const newContent = item.content.filter((contentItem => {
                if (contentItem.type === 4) {
                    return false;
                }
                if (contentItem.type === 10) {
                    contentItem.type = 4;
                    contentItem.value = contentItem.value[picKey] ?? contentItem.value;
                }
                return true;
            }));
            return {
                ...item,
                content: newContent
            };
        }));
        if (datas.length > 0) {
            return JSON.stringify(datas);
        }
    }
    return "";
}

const {moduleData: moduleData$3, moduleEvent: moduleEvent$3} = moduleDefine("p2pMainTab", (() => {}), defaultData$3);

function defaultData$3() {
    return {
        brand: {
            textColor: "@color/kColorContentBackground",
            backgroundColor: "#E4BB79",
            buySellBarVisible: "gone",
            filterBarTipVisible: "gone"
        },
        normal: {
            textColor: "@color/kColorWhiteText",
            backgroundColor: "@color/baseColorMajorTheme100",
            buySellBarVisible: "gone",
            filterBarTipVisible: "gone"
        },
        containerHeight: "0",
        marginBottom: "0",
        backgroundColor: "#2B2B2B",
        containerBgColor: "#0E0E0E"
    };
}

function updateBarStyle(tabIndex) {
    moduleData$3.brand.backgroundColor = tabIndex === 0 ? "#E4BB79" : "@color/kColorContentBackground";
    moduleData$3.normal.backgroundColor = tabIndex === 1 ? "@color/baseColorMajorTheme100" : "#2B2B2B";
    moduleData$3.backgroundColor = tabIndex === 0 ? "#2B2B2B" : "@color/kColorContentBackground";
    moduleData$3.containerBgColor = tabIndex === 0 ? "#0E0E0E" : "@color/KBaseColorDeepestBackground";
    moduleData$3.brand.textColor = tabIndex === 0 && commanData.colorMode == 1 ? "#000000" : "@color/kColorPrimaryText";
    if (commanData.OS == 1) {
        moduleData$3.normal.buySellBarVisible = tabIndex === 0 ? "gone" : "visible";
        moduleData$3.normal.filterBarTipVisible = tabIndex === 0 ? "gone" : "visible";
        moduleData$3.brand.buySellBarVisible = tabIndex === 0 ? "visible" : "gone";
        moduleData$3.brand.filterBarTipVisible = tabIndex === 0 ? "visible" : "gone";
    } else {
        moduleData$3.normal.buySellBarVisible = "visible";
        moduleData$3.normal.filterBarTipVisible = "visible";
        moduleData$3.brand.buySellBarVisible = "visible";
        moduleData$3.brand.filterBarTipVisible = "visible";
    }
}

async function onClickMainTab(index, uploadList = true) {
    try {
        if (moduleData$3.selectedMainTabIndex === index) return;
        moduleData$3.selectedMainTabIndex = index;
        updateBarStyle(index);
        $event.loadListContent(index, uploadList);
    } catch (err) {
        console.log(err);
    }
}

async function showMainTab(index) {
    moduleData$3.containerHeight = "28";
    moduleData$3.marginBottom = "16";
    onClickMainTab(index, false);
}

moduleEvent$3.onClickMainTab = onClickMainTab;

const {moduleData: moduleData$2, moduleEvent: moduleEvent$2} = moduleDefine("verifyCapital", (() => {}), defaultData$2);

function defaultData$2() {
    return {
        popState: {
            isShowing: "false",
            title: $i18n.n_otc_advert_verify_capital_title,
            content: "",
            buttonTitle: $i18n.n_otc_know
        },
        datas: [],
        isfetched: false
    };
}

async function fetchConfig() {
    if (moduleData$2.datas.length > 0) {
        return;
    }
    const response = await sendRequest("v1/data/trade/verify/capital/config");
    console.log("verify capital config loaded successfully:", response);
    if (response) {
        $data.verifyCapital.datas = response.data || [];
        $data.verifyCapital.isfetched = true;
    }
}

function configForCurrency(currency) {
    if (typeof currency !== "string") return null;
    var orderAmount = null;
    $data.verifyCapital.datas.forEach((item => {
        if (item.currency.toUpperCase() === currency.toUpperCase()) {
            orderAmount = item.orderAmount;
        }
    }));
    return orderAmount;
}

function popVerifyTip(currencyName) {
    if (orderAmount = configForCurrency(currencyName)) {
        $data.verifyCapital.popState.content = $i18n.n_otc_advert_verify_capital_subtitle.replace("{{0}}", orderAmount).replace("{{1}}", currencyName);
        $data.verifyCapital.popState.isShowing = "true";
        return true;
    }
    return false;
}

moduleEvent$2.popDismiss = function() {
    $data.verifyCapital.popState.isShowing = "false";
};

const {moduleData: moduleData$1, moduleEvent: moduleEvent$1} = moduleDefine("advertList", (function() {
    console.log("advertList loading....");
}), defaultData$1);

function defaultData$1() {
    return {
        brand: initalPageData(),
        normal: initalPageData()
    };
}

function initalPageData() {
    return {
        refreshStatus: 0,
        loadMoreStatus: 0,
        listVisible: "visible",
        loadingStatus: "play",
        loadingVisible: "visible",
        extend: null,
        datas: [],
        emptyVisible: "gone",
        emptybuttonVisible: "gone",
        noNetVisible: "gone",
        emptyTips: config.tradeType == "buy" ? $i18n.n_otc_advert_empty_title || "暂无广告，您可充值数字资产进行其他交易" : $i18n.otc_no_ad || "暂无广告",
        loadingTempDatas: [],
        bottomOffset: 0
    };
}

const dataHelper = {
    normalDatas: [],
    brandDatas: [],
    getDatas(siteType) {
        return siteType == SiteType.BRAND ? this.brandDatas : this.normalDatas;
    },
    setDatas(siteType, value) {
        if (siteType == SiteType.BRAND) {
            this.brandDatas = value;
        } else {
            this.normalDatas = value;
        }
    },
    refreshList(siteType) {
        if (siteType == SiteType.BRAND) {
            moduleData$1.brand.datas = [ ...this.brandDatas, ...[ {
                type: "footer"
            } ] ];
        } else {
            moduleData$1.normal.datas = [ ...this.normalDatas, ...[ {
                type: "footer"
            } ] ];
        }
    },
    updateDatasToList(siteType, datas) {
        if (siteType == SiteType.BRAND) {
            this.brandDatas = datas;
            moduleData$1.brand.datas = datas;
        } else {
            this.normalDatas = datas;
            moduleData$1.normal.datas = datas;
        }
    }
};

moduleEvent$1.updateContentHeight = contentHeight => {
    moduleData$1.contentHeight = contentHeight;
};

function updateBottomOffset(height) {
    moduleData$1.bottomOffset = height;
}

function refreshAdvertListIfNeeds(sitType, filterParams) {
    if (commanData.OS == 0) {
        const {coinId: coinId, currency: currency} = getCurrentRequestParams(sitType);
        if (!(coinId !== undefined && currency !== undefined)) {
            const {currencyName: currencyName, coinId: coinId} = filterParams;
            if (coinId !== undefined && currencyName !== undefined) {
                updateAdvertListWithFilterParams(filterParams, sitType);
            }
        } else {
            let datas = dataHelper.getDatas(sitType);
            if (datas.length == 0) {
                refreshAdvertList(sitType);
            }
        }
    }
}

function resetAdvertListRequest() {
    resetParams();
}

function updateAdvertListWithFilterParamsNoRequest(json) {
    updateAdvertListWithFilterParams$1(config.currentSiteType, json);
}

function updateAdvertListWithFilterParams(json, type = config.currentSiteType) {
    try {
        const {amount: newAmount} = json;
        const oldAmount = getAmount();
        if (newAmount && newAmount != oldAmount) {
            analytics(type == SiteType.BRAND ? "otc_p2p_adlist_brand" : "otc_p2p_adlist", {
                otc_step: "otc_trade_filter_amount",
                amount: newAmount,
                fiat: config.target.currencyName
            });
        }
        let selectedMore = updateAdvertListWithFilterParams$1(type, json);
        refreshAdvertList(type);
        return selectedMore;
    } catch (error) {
        console.log(`updateAdvertListWithFilterParams error  ===== ${error}`);
    }
}

async function updateListWithFollowStatusChanged(siteType, params) {
    const {type: type, relationStatus: relationStatus, uid: uid} = params;
    let status = relationStatus === "on";
    let isFollow = type === "follow" && status;
    let isShield = type === "shield" && status;
    let isUnshield = type === "shield" && !status;
    if (isUnshield) {
        refreshAdvertList(siteType);
    } else if (isShield) {
        var hasAddCell = false;
        var indexSeaViewRoomCell = -1;
        var newIndex = 0;
        var tempDatas = [];
        dataHelper.getDatas(siteType).forEach(((item, index) => {
            if (item.uid && `${item.uid}` !== `${uid}`) {
                item.index = newIndex;
                tempDatas.push(item);
                newIndex++;
            } else if (item.type == "seaViewRoomCell" && item.rooms) {
                var exist = item.rooms.some((item => `${item.uid}` === `${uid}`));
                if (exist) {
                    indexSeaViewRoomCell = index;
                } else {
                    item.index = newIndex;
                    tempDatas.push(item);
                    newIndex++;
                }
            } else if (item.type == "addAdvertCell") {
                hasAddCell = true;
            }
        }));
        dataHelper.setDatas(siteType, tempDatas);
        dataHelper.refreshList(siteType);
        if (indexSeaViewRoomCell > 0) {
            if (siteType == SiteType.NORMAL) {
                await loadSeaviewRoomDatas(uid);
            }
        }
        if (hasAddCell) {
            addGreateAdvertCellIfNeed();
        }
        if (filteredDatas.length === 0) {
            showListConent(true, siteType);
        }
    } else {
        var datas = dataHelper.getDatas(siteType);
        var followCurrentMerchatWithAdvert = item => {
            if (`${item.uid}` === `${uid}`) {
                item.isFollowed = isFollow;
                item.follow.idVisible = isFollow ? "visible" : "gone";
                item.follow.title = isFollow ? $i18n.n_title_followed_merchant : $i18n.n_title_follow_merchant;
                item.follow.icon = isFollow ? "@drawable/star_yellow_common" : "@drawable/advert_follow";
            }
        };
        datas.forEach((item => followCurrentMerchatWithAdvert(item)));
        if (siteType == SiteType.NORMAL) {
            var data = datas.find((obj => obj.type === "seaViewRoomCell" && obj.rooms != undefined));
            data.rooms.forEach((item => followCurrentMerchatWithAdvert(item)));
        }
        dataHelper.setDatas(siteType, datas);
        dataHelper.refreshList(siteType);
    }
}

function updateListWithAdvertPriceChanged(siteType, params) {
    const {advertId: advertId, price: price} = params;
    var datas = dataHelper.getDatas(siteType);
    var data = datas.find((obj => `${obj.id}` === `${advertId}`));
    if (data !== undefined) {
        data.price = price;
        data.showPrice = thousandsFormatter(price);
    }
    if (siteType == SiteType.NORMAL) {
        var subData = datas.find((obj => obj.type === "seaViewRoomCell" && obj.rooms != undefined));
        var room = subData.rooms.find((obj => `${obj.id}` === `${advertId}`));
        if (room !== undefined) {
            room.price = price;
            room.showPrice = thousandsFormatter(price);
        }
    }
    dataHelper.setDatas(siteType, datas);
    dataHelper.refreshList(siteType);
}

async function refreshAdvertList(siteType) {
    await fetchConfig();
    await loadAdvertListWithRefreshStatus(false, siteType);
    if (siteType == SiteType.NORMAL) {
        await loadSeaviewRoomDatas();
    }
    addGreateAdvertCellIfNeed();
    analytics(siteType == SiteType.BRAND ? "otc_p2p_adlist_brand" : "otc_p2p_adlist", {
        otc_step: "refresh",
        spm: "otc.adlist.page.pulltorefresh",
        side: getTradeType(),
        coin_name: config.target.coinName,
        payment: getPayment()
    });
}

async function loadMoreAdvertList(siteType) {
    await loadAdvertListWithRefreshStatus(true, siteType);
    addGreateAdvertCellIfNeed();
    analytics(siteType == SiteType.BRAND ? "otc_p2p_adlist_brand" : "otc_p2p_adlist", {
        otc_step: "loadmore",
        spm: "otc.adlist.page.loadmore",
        side: getTradeType(),
        coin_name: config.target.coinName,
        payment: getPayment()
    });
}

async function loadSeaviewRoomDatas(filterUid) {
    if (config.coinId == 2) {
        let normalDatas = dataHelper.getDatas(SiteType.NORMAL);
        if (normalDatas.length > 0) {
            try {
                let {datas: datas} = await loadSeaviewRoomDatasWithTopThree();
                if (datas !== undefined && datas.length > 0) {
                    if (filterUid) {
                        datas = datas.filter((item => `${item.uid}` !== `${filterUid}`));
                    }
                    let viewModels = datas.slice(0, 3);
                    while (viewModels.length < 3) {
                        viewModels.push({});
                    }
                    viewModels.forEach(((item, index) => {
                        item.cellType = "roomSubCell";
                        item.rankIcon = `@drawable/c2c_advert_sea_top${index + 1}`;
                        item.lineVisible = index > 1 ? "gone" : "visible";
                        var exist = item.uid && item.uid > 0;
                        item.visibility = exist ? "visible" : "gone";
                        item.emptyVisible = exist ? "gone" : "visible";
                        if (exist) {
                            item.totalTradeOrderCountText = $i18n.$intercept.n_otc_advert_ordercount(`${item.totalTradeOrderCount}`);
                            item.orderCompleteRateText = `${item.orderCompleteRate}%`;
                            item.symbol = config.symbol;
                            item.showPrice = thousandsFormatter(item.price);
                            formatUserIdLables(item);
                        }
                    }));
                    let index = normalDatas.length >= 2 ? 2 : normalDatas.length;
                    normalDatas.splice(index, 0, {
                        type: "seaViewRoomCell",
                        rooms: viewModels
                    });
                    updateNormalDatas(normalDatas);
                }
            } catch (error) {
                console.log(`loadSeaviewRoomDatas error  ===== ${error}`);
            }
        }
    }
}

function addGreateAdvertCellIfNeed() {
    if (config.currentSiteType == SiteType.NORMAL) {
        try {
            let normalDatas = dataHelper.getDatas(SiteType.NORMAL);
            if (normalDatas.length > 0) {
                const exists = normalDatas.some((obj => obj.type === "addAdvertCell"));
                if (!exists) {
                    var index = -1;
                    if (moduleData$1.normal.noMoreData == true) {
                        index = normalDatas.length > 14 ? 14 : normalDatas.length;
                    } else if (normalDatas.length > 14) {
                        index = 14;
                    }
                    if (index != -1) {
                        normalDatas.splice(index, 0, {
                            type: "addAdvertCell"
                        });
                        updateNormalDatas(normalDatas);
                    }
                }
            }
        } catch (e) {
            console.log(`addGreateAdvertCellIfNeed error  ===== ${e}`);
        }
    }
}

function updateNormalDatas(datas) {
    datas.forEach(((data, i) => data.index = i));
    dataHelper.setDatas(SiteType.NORMAL, datas);
    dataHelper.refreshList(SiteType.NORMAL);
}

async function loadAdvertListWithRefreshStatus(isMore = false, siteType) {
    const currentSiteType = siteType;
    const target = currentSiteType === SiteType.NORMAL ? moduleData$1.normal : moduleData$1.brand;
    const statusType = isMore ? "loadMoreStatus" : "refreshStatus";
    if (!isMore) {
        if (target.loadingTempDatas.length == 0) {
            var loadingCellType = commanData.colorMode == 0 ? "advertLoadCellDay" : "advertLoadCellNight";
            target.loadingTempDatas = Array.from({
                length: 10
            }, (() => ({
                type: loadingCellType
            })));
        }
        target["loadingStatus"] = "play";
        target["loadingVisible"] = "visible";
        target["noNetVisible"] = "gone";
        target["emptyVisible"] = "gone";
        target["listVisible"] = "gone";
    }
    try {
        var res = isMore ? await loadMoreAdvertList$1(siteType) : await refreshAdvertList$1(siteType);
    } finally {
        target[statusType] = "2";
    }
    try {
        var originDatas = dataHelper.getDatas(siteType);
        var showEmpty = !isMore;
        if (res && res.datas != undefined) {
            var {extend: extend, datas: datas, hasMore: hasMore} = res;
            var startIndex = isMore ? originDatas.length : 0;
            let viewModelsPromise = datas.map((async (data, i) => {
                var item = currentSiteType == SiteType.BRAND ? await formatBrandAdvert(data) : await formatNormalAdvert(data);
                item.index = i + startIndex;
                return item;
            }));
            var viewModels = await Promise.all(viewModelsPromise);
            const newDatas = isMore ? [ ...originDatas, ...viewModels ] : viewModels;
            dataHelper.updateDatasToList(currentSiteType, newDatas);
            const {labelId: labelId} = getCurrentRequestParams(siteType);
            if (!isMore && labelId == "") {
                target.extend = JSON.stringify(extend);
            }
            target["noMoreData"] = !hasMore;
            showEmpty = !isMore && viewModels.length == 0;
        }
        if (!isMore) {
            target["loadingStatus"] = "stop";
            target["loadingVisible"] = "gone";
        }
        showListConent(showEmpty, currentSiteType, res == null);
    } catch (error) {
        console.log(`loadAdvertListWithRefreshStatus error  ===== ${error}`);
    }
}

function showListConent(showEmpty, siteType, showNoNet = false) {
    const target = siteType === SiteType.NORMAL ? moduleData$1.normal : moduleData$1.brand;
    if (showNoNet) {
        if (showEmpty) {
            target["noNetVisible"] = "visible";
            target["emptyVisible"] = "gone";
            target["listVisible"] = "gone";
        } else {
            $nativeAPI.hbToast($i18n.n_check_network);
        }
    } else {
        target["noNetVisible"] = "gone";
        target["emptyVisible"] = showEmpty ? "visible" : "gone";
        target["listVisible"] = showEmpty ? "gone" : "visible";
        if (showEmpty) {
            const {currency: currency, coinId: coinId, tradeType: tradeType} = getCurrentRequestParams(siteType);
            if (currency == 0 || currency == undefined) {
                target["emptybuttonVisible"] = "gone";
                target["emptyTips"] = $i18n.n_otc_not_support_fiat || "暂不支持当前法币";
            } else if (coinId == 0 || coinId == undefined) {
                target["emptybuttonVisible"] = "gone";
                target["emptyTips"] = $i18n.n_asset_currency_invalid || "此币种暂不支持";
            } else {
                let isBuy = tradeType == "sell";
                target["emptybuttonVisible"] = isBuy ? "visible" : "gone";
                target["emptyTips"] = isBuy ? $i18n.n_otc_advert_empty_title || "暂无广告，您可充值数字资产进行其他交易" : $i18n.otc_no_ad || "暂无广告";
            }
        }
    }
}

function formatAdvert(item) {
    if (item.verifyCapitalStatus !== undefined) {
        item.verifyCapitalVisible = item.tradeType == 1 && configForCurrency(config.currencyName) && item.verifyCapitalStatus != 2 ? "visible" : "gone";
        item.verifyCapitalText = item.verifyCapitalStatus == 1 ? $i18n.n_otc_advert_verify_capital_title : item.verifyCapitalStatus == 0 ? $i18n.n_otc_advert_no_verify_capital_title : "";
        item.verifyCapitalYesVisible = item.verifyCapitalStatus == 1 ? "visible" : "gone";
        item.verifyCapitalNoVisible = item.verifyCapitalStatus == 0 ? "visible" : "gone";
    } else {
        item.verifyCapitalVisible = item.tradeType == 1 && configForCurrency(config.currencyName) ? "visible" : "gone";
        item.verifyCapitalText = item.isVerifyCapital ? $i18n.n_otc_advert_verify_capital_title : $i18n.n_otc_advert_no_verify_capital_title;
        item.verifyCapitalYesVisible = item.isVerifyCapital ? "visible" : "gone";
        item.verifyCapitalNoVisible = !item.isVerifyCapital ? "visible" : "gone";
    }
    item.labelVisible = item.labelName && item.labelName.length > 0 ? "visible" : "gone";
    item.symbol = config.symbol;
    item.showPrice = thousandsFormatter(item.price);
    item.numText = item.tradeCount + " " + config.coinName.toUpperCase();
    let minTradeLimit = item.minTradeLimit.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    let maxTradeLimit = item.maxTradeLimit.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    item.limitAmountText = item.symbol + minTradeLimit + " - " + item.symbol + maxTradeLimit;
    item.tradeDurationText = $i18n.$intercept.n_desc_minute(`${item.payTerm}`);
    item.expandAreaVisibility = "gone";
    item.follow = {
        title: item.isFollowed ? $i18n.n_title_followed_merchant : $i18n.n_title_follow_merchant,
        icon: item.isFollowed ? "@drawable/star_yellow_common" : "@drawable/advert_follow",
        idVisible: "gone",
        idIcon: ""
    }, item.follow.title = item.isFollowed ? $i18n.n_title_followed_merchant : $i18n.n_title_follow_merchant;
    item.follow.icon = item.isFollowed ? "@drawable/star_yellow_common" : "@drawable/advert_follow";
    var tradeButton = {};
    var transparent = false;
    if (item.takerLimit & 4) {
        tradeButton.title = $i18n.n_otc_advert_btn_kyc || "实名认证";
        transparent = true;
    } else if (item.takerLimit & 1) {
        tradeButton.title = $i18n.n_otc_advert_btn_bind_phone || "绑定手机号";
        transparent = true;
    } else if (item.takerLimit & 2 || item.takerLimit & 8) {
        tradeButton.title = $i18n.n_otc_taker_limit_new || "广告方已设限";
        transparent = true;
    } else {
        if (item.tradeType == 1) {
            tradeButton.title = $i18n.n_otc_buy || "购买";
        } else {
            tradeButton.title = $i18n.n_otc_sell || "出售";
        }
    }
    tradeButton.tipsVisibility = transparent ? "visible" : "gone";
    tradeButton.visibility = transparent ? "gone" : "visible";
    tradeButton.transparent = transparent;
    item.tradeButton = tradeButton;
    let methods = [];
    for (let method of item.payMethods) {
        method.type = "1";
        methods.push(method);
    }
    item.payMethods = methods;
}

function formatUserIdLables(item) {
    let hasBlueShield = false;
    if (item.merchantTags && Array.isArray(item.merchantTags)) {
        hasBlueShield = item.merchantTags.includes(1);
    }
    item.blueShield = item.blueShield || {};
    item.blueShield.idVisible = hasBlueShield ? "visible" : "gone";
    item.level = item.level || {};
    if (item.merchantLevel == 3) {
        item.level.idVisible = "visible";
        item.level.idIcon = "@drawable/otc_market_crown_icon";
    } else if (item.merchantLevel == 2) {
        item.level.idVisible = "visible";
        item.level.idIcon = "@drawable/otc_market_v_icon";
    } else {
        item.level.idVisible = "gone";
        item.level.idIcon = "";
    }
    item.thumbUpData = item.thumbUpData || {};
    item.thumbUpData.idVisible = item.thumbUp == 0 ? "gone" : "visible";
    item.thumbUpData.idIcon = "@drawable/otc_advert_thumb_up_icon";
    item.follow = item.follow || {};
    item.follow.idVisible = item.isFollowed ? "visible" : "gone";
    item.traded = item.traded || {};
    item.traded.idVisible = item.isTrade ? "visible" : "gone";
    if (commanData.language == "zh-cn") {
        item.blueShield.idIcon = hasBlueShield ? "@drawable/otc_blue_shield_zh_cn" : "";
        item.traded.idIcon = item.isTrade ? "@drawable/label_traded_zh_cn" : "";
    } else if (commanData.language == "zh-hk") {
        item.blueShield.idIcon = hasBlueShield ? "@drawable/otc_blue_shield_zh_hk" : "";
        item.traded.idIcon = item.isTrade ? "@drawable/label_traded_zh_hk" : "";
    } else {
        item.blueShield.idIcon = hasBlueShield ? "@drawable/otc_blue_shield_other" : "";
        item.traded.idIcon = item.isTrade ? "@drawable/label_traded_en" : "";
    }
}

async function formatNormalAdvert(item) {
    item.type = "advertCell";
    formatAdvert(item);
    formatUserIdLables(item);
    item.onlineColor = item.isOnline ? "#00A171" : "@color/kColorFourLevelText";
    item.totalTradeOrderCountText = `${$i18n.n_otc_ads_order_number} ${item.totalTradeOrderCount}`;
    item.orderCompleteRateText = `${item.orderCompleteRate}%`;
    if (item.tradeButton.transparent) {
        if (item.takerLimit & 1 || item.takerLimit & 4) {
            item.tradeButton.titleColor = "@color/kColorMajorTheme100";
            item.tradeButton.backgroundColor = "";
        } else {
            item.tradeButton.titleColor = "@color/kColorSecondaryText";
            item.tradeButton.backgroundColor = "";
        }
    } else {
        item.tradeButton.titleColor = "@color/kColorWhiteText";
        item.tradeButton.backgroundColor = item.tradeType == 1 ? "#00A171" : "#E94359";
    }
    item.merchantVisible = item.chargeType ? "gone" : "visible";
    item.sMerchantVisible = item.chargeType ? "visible" : "gone";
    if (item.chargeType) {
        item.sMerchantContentWidth = await _getStringWidth(item.userName, 14, 500) + 24;
    }
    return item;
}

async function formatBrandAdvert(item) {
    formatAdvert(item);
    var advert = item;
    console.log(`item: ${item}`);
    advert.tradedVisible = item.isTrade ?? false ? "visible" : "gone";
    if (item.tradeButton.transparent) {
        if (item.takerLimit & 1 || item.takerLimit & 4) {
            item.tradeButton.titleColor = "@color/kColorMajorTheme100";
            item.tradeButton.backgroundColor = "";
        } else {
            item.tradeButton.titleColor = "@color/kColorSecondaryText";
            item.tradeButton.backgroundColor = "";
        }
    } else {
        item.tradeButton.titleColor = "";
        item.tradeButton.backgroundColor = "";
    }
    advert.payMethodsJson = JSON.stringify(item.payMethods);
    if (advert.blockType == 5 && Array.isArray(item.specialBrandLabels) && item.specialBrandLabels.length > 0) {
        advert.specialLabelIcon = item.specialBrandLabels[0].url || (item.tradeType == 1 ? "@drawable/edge_engine_trading_buy_special_label" : "@drawable/edge_engine_trading_sell_special_label");
        advert.specialLabelText = item.specialBrandLabels[0].name || "";
        if (advert.specialLabelText.length > 0) {
            advert.specialLabelWidth = 16 + 6 + await _getStringWidth(advert.specialLabelText, 11, 500) + 6;
        }
        advert.specialLabelVisible = advert.specialLabelText.length > 0 ? "visible" : "gone";
    } else {
        advert.specialLabelVisible = "gone";
        advert.specialLabelWidth = 0;
        advert.specialLabelIcon = "";
        advert.specialLabelText = "";
    }
    if (Array.isArray(item.normalBrandLabels) && item.normalBrandLabels.length > 0) {
        var normalBrandLabels = [];
        for (let label of item.normalBrandLabels) {
            if (normalBrandLabels.length == 0) {
                normalBrandLabels.push({
                    type: "tag",
                    borderWidth: 0,
                    background: "@color/kOtcBrandTradeTagBgColor",
                    textSize: "11",
                    textColor: "@color/kOtcBrandTradeTagTextColor1",
                    ...label
                });
            } else {
                normalBrandLabels.push({
                    type: "tag",
                    borderWidth: .5,
                    background: "#00000000",
                    textSize: "10",
                    textColor: "@color/kOtcBrandTradeTagTextColor2",
                    ...label
                });
            }
        }
        advert.normalBrandLabels = normalBrandLabels;
        advert.normalLabelVisible = "visible";
        advert.normalBottomOffset = commanData.OS == 0 ? 6 : 0;
    } else {
        advert.normalLabelVisible = "gone";
        advert.normalBrandLabels = [];
        advert.normalBottomOffset = 0;
    }
    advert.type = "brand";
    return advert;
}

async function _getStringWidth(str, fontSize, fontWeight) {
    try {
        const sizeInfo = await $nativeAPI.p2pFilterBridge({
            action: "mesureSizeOfString",
            params: {
                text: str,
                fontSize: fontSize,
                fontWeight: fontWeight
            }
        });
        const obj = JSON.parse(sizeInfo);
        const {width: width, height: height} = obj;
        return width;
    } catch (e) {
        console.log(`mesureSizeOfString error: ${e}`);
        return 0;
    }
}

moduleEvent$1.onClickMerchantName = function(uid) {
    $nativeAPI.p2pFilterBridge({
        action: "goMerchantHome",
        params: `${uid}`
    });
};

moduleEvent$1.onClickVerifyCapital = function(index) {
    var item = dataHelper.getDatas(config.currentSiteType)[index];
    if (item && item.verifyCapitalStatus == 1) {
        popVerifyTip(config.currencyName);
    }
};

moduleEvent$1.onClickTradeOperation = function(index) {
    const sitType = config.currentSiteType;
    var item = dataHelper.getDatas(sitType)[index];
    if (item) {
        if (item.takerLimit & 2 || item.takerLimit & 4) {
            openURL("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/account/kyc?authBizCode=OTC");
        } else if (item.takerLimit & 1) {
            if (commanData.OS == 0) {
                openURL("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/securityCenter/bindPhone");
            } else {
                $nativeAPI.p2pFilterBridge({
                    action: "onSwitchPage",
                    params: {
                        target: "toBindPhone"
                    }
                });
            }
        } else {
            $nativeAPI.p2pFilterBridge({
                action: "onSwitchPage",
                params: {
                    target: "toCreateOrder",
                    params: JSON.stringify(item)
                }
            });
        }
        analytics(sitType == SiteType.BRAND ? "otc_p2p_adlist_brand" : "otc_p2p_adlist", {
            otc_step: "click_quote",
            spm: item.tradeType == 0 ? "otc.adlist.page.sell" : "otc.adlist.page.buy",
            side: getTradeType(),
            coin_name: config.target.coinName,
            payment: getPayment()
        });
    }
};

moduleEvent$1.onClickMore = index => {
    const sitType = config.currentSiteType;
    var item = dataHelper.getDatas(sitType)[index];
    item.expandAreaVisibility = item.expandAreaVisibility === "gone" ? "visible" : "gone";
    dataHelper.refreshList(sitType);
};

moduleEvent$1.onClickFollow = async index => {
    const sitType = config.currentSiteType;
    var item = dataHelper.getDatas(sitType)[index];
    if (item && !item.isFollowed) {
        var url = `v1/user/relation/change/${item.uid}?type=follow&relationStatus=on`;
        var {code: code, message: message} = await sendRequest(url, {}, 1, 1, {});
        if (code == 200) {
            item.isFollowed = true;
            item.follow.idVisible = item.isFollowed ? "visible" : "gone";
            item.follow.title = item.isFollowed ? $i18n.n_title_followed_merchant : $i18n.n_title_follow_merchant;
            item.follow.icon = item.isFollowed ? "@drawable/star_yellow_common" : "@drawable/advert_follow";
            dataHelper.refreshList(sitType);
            $nativeAPI.hbToast($i18n.n_title_operate_success);
        } else {
            $nativeAPI.hbToast(!message || message.length == 0 ? $i18n.n_check_network : message);
        }
    }
};

moduleEvent$1.onClickToDeposit = function() {
    if (commanData.OS == 0) {
        openURL("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/balance/depositSearch");
    } else {
        openURL("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/balance/depositSearch?extra_type=1&extra_from=0");
    }
};

moduleEvent$1.onClickToStrictSelection = function(index) {
    $nativeAPI.p2pFilterBridge({
        action: "toStrictSelection"
    });
};

moduleEvent$1.onClickSeaviewRoom = function() {
    let tradeType = getTradeType();
    $nativeAPI.p2pFilterBridge({
        action: "onSwitchPage",
        params: {
            target: "toSeaviewRoom",
            params: JSON.stringify({
                ...config.normal,
                tradeType: tradeType
            })
        }
    });
    analytics("otc_p2p_adlist", {
        otc_step: "otc_p2p_thumbsUp_click",
        side: tradeType,
        coin_name: config.target.coinName
    });
};

moduleEvent$1.onGreateAdvert = function() {
    $nativeAPI.p2pFilterBridge({
        action: "onSwitchPage",
        params: {
            target: "toGreateAdvert",
            params: ""
        }
    });
};

moduleEvent$1.refreshAdvertList = function(index) {
    refreshAdvertList(index == 0 ? SiteType.BRAND : SiteType.NORMAL);
};

moduleEvent$1.loadMoreAdvertList = function(index) {
    loadMoreAdvertList(index == 0 ? SiteType.BRAND : SiteType.NORMAL);
};

const {moduleData: moduleData, moduleEvent: moduleEvent} = moduleDefine("riskControl", (() => {}), defaultData);

const riskInfoModel = {
    title: "",
    content: "",
    tag: [],
    button: {
        name: ""
    }
};

function defaultData() {
    return {
        popState: {
            isShowing: "false",
            title: "",
            content: "",
            checkText: "",
            buttonTitle: $i18n.n_otc_know
        },
        canShowRisk: true,
        currencyName: "",
        showAlertCache: {}
    };
}

async function getRiskInfoByCurrencyName(currencyName) {
    const params = {
        factor: {
            appPageId: 50,
            eventId: 435593,
            currencyAssetName: currencyName.toUpperCase()
        }
    };
    const response = await sendRequest("v1/risk/page/element", params, 1, 1, {
        "Content-Type": "application/json"
    });
    console.log("riskControl loaded successfully:", response);
    return response && response.data ? {
        ...riskInfoModel,
        ...response.data
    } : null;
}

async function checkForCurrencyIfNeeded() {
    if (moduleData.canShowRisk && config.currencyName && config.currencyName != moduleData.currencyName) {
        handleCurencyChange(config.currencyName);
    } else {
        console.log("riskControl.checkForCurrencyIfNeeded:", config.currencyName, moduleData.currencyName);
    }
}

async function handleCurencyChange(currencyName) {
    if (moduleData.popState.isShowing == "true") {
        return;
    }
    moduleData.currencyName = currencyName;
    if (moduleData.showAlertCache[currencyName] == true) {
        return;
    }
    const riskInfo = await getRiskInfoByCurrencyName(currencyName);
    if (riskInfo != undefined && riskInfo.title.length && riskInfo.content.length) {
        moduleData.showAlertCache[currencyName] = true;
        moduleData.popState.content = riskInfo.content;
        moduleData.popState.buttonTitle = riskInfo.button.name.length ? riskInfo.button.name : $i18n.n_copy_trading_me_know;
        moduleData.popState.title = riskInfo.title;
        moduleData.popState.checkText = riskInfo.tag[0] || "";
        moduleData.popState.isShowing = "true";
    }
}

function setCanShowRisk(canShow) {
    moduleData.canShowRisk = canShow;
}

moduleEvent.popDismiss = function() {
    console.log("pop dismiss");
    $data.riskControl.popState.isShowing = "false";
};

const diversionHelper = {
    module: "p2p-config",
    get cacheKey() {
        return `com.p2p-diversion.${commanData.uid}`;
    },
    async getSite() {
        if (commanData.language.toLowerCase() == "zh-cn") {
            return SiteType.BRAND;
        }
        var content = await read(this.module, this.cacheKey);
        if (content == null) {
            var res = await sendRequest("v1/trade/side/diversion");
            if (res && res.data && res.data.showPage) {
                content = res.data.showPage;
                save(this.module, this.cacheKey, res.data.showPage).then((_ => {}));
            } else {
                content = "BRAND";
            }
        }
        var site = content == "NOMAL" ? SiteType.NORMAL : SiteType.BRAND;
        return site;
    },
    updateSite(type) {
        var diversion = type == SiteType.NORMAL ? "NOMAL" : "BRAND";
        save(this.module, this.cacheKey, diversion).then((_ => {}));
    }
};

$event.pageWillAppear = async function() {
    analytics(config.currentSiteType == SiteType.BRAND ? "otc_p2p_adlist_brand" : "otc_p2p_adlist", {
        otc_step: "view",
        spm: "otc.adlist.page.view",
        side: getTradeType(),
        coin_name: config.target.coinName,
        amount: getAmount()
    });
};

$event.pageWillDisappear = async function() {
    console.log("pageWillDisappear =========");
};

$event.moduleWillAppear = async function() {
    console.log("moduleWillAppear =========");
    setCanShowRisk(true);
    checkForCurrencyIfNeeded();
    if (config.currentSiteType !== undefined) {
        loadTradeTipsInfo();
    }
};

$event.moduleWillDisappear = async function() {
    console.log("moduleWillDisappear =========");
    setCanShowRisk(false);
};

$event.sendCommonConfig = function(param) {
    var vaildParams = parseRequestParams(param);
    console.log(JSON.stringify(vaildParams));
    parseCommonConfig(vaildParams);
};

$event.refreshAdvertListWithTradeType = async tradeType => {
    config.tradeType = tradeType;
    updateAdvertListWithFilterParamsNoRequest({
        tradeType: tradeType == "buy" ? "sell" : "buy"
    });
};

$event.refreshAdvertListWithTradable = onlyTradable => {
    updateAdvertListWithFilterParams({
        onlyTradable: onlyTradable
    });
};

$event.onMerchantAttentionChanged = function(requestJson) {
    var param = parseRequestParams(requestJson);
    updateListWithFollowStatusChanged(config.currentSiteType, param);
};

$event.onAdvertPriceChanged = function(requestJson) {
    var param = parseRequestParams(requestJson);
    updateListWithAdvertPriceChanged(config.currentSiteType, param);
};

$event.updateP2pList = function(requestJson) {
    try {
        console.log(`updateP2pList ========= ${JSON.stringify(requestJson)}`);
        const params = parseRequestParams(requestJson);
        if (params) {
            const {coinName: newCoinName = config.coinName, coinId: pCoin} = params;
            if (newCoinName) {
                config.coinName = newCoinName;
            }
            if (pCoin) {
                config.coinId = pCoin;
            }
            const selectedMore = updateAdvertListWithFilterParams(params);
            params.selectedMore = selectedMore;
            updateStyle(params, newCoinName);
        }
    } catch (error) {
        console.log("updateP2pList Failed to update P2P list:", error);
    }
};

$event.locateTo = async function(requestJson) {
    const param = parseRequestParams(requestJson);
    const {tradeType: tradeType, siteType: siteType, ...subParams} = param;
    var updateParams = subParams;
    if (siteType !== undefined && siteType !== config.currentSiteType) {
        config.currentSiteType = siteType;
        showMainTab(config.currentSiteType);
    }
    if (tradeType !== undefined) {
        config.tradeType = tradeType;
        updateStyleWithDirection(tradeType);
        updateParams.tradeType = tradeType == "buy" ? "sell" : "buy";
    }
    var updateParams = {
        ...updateParams,
        ...handleWithTradingPairs(param)
    };
    if (Object.keys(updateParams).length > 0) {
        if (commanData.OS == 0) {
            updateAdvertListWithFilterParams(updateParams);
        } else {
            updateAdvertListWithFilterParamsNoRequest(updateParams);
        }
    }
};

$event.updateTradingPairs = async function(requestJson) {
    const param = parseRequestParams(requestJson);
    if (param === "" || Object.keys(param).length == 0) {
        resetAdvertListRequest();
    } else {
        let updateParams = handleWithTradingPairs(param);
        if (Object.keys(updateParams).length > 0) {
            if (commanData.OS == 0) {
                updateAdvertListWithFilterParams(updateParams);
            } else {
                updateAdvertListWithFilterParamsNoRequest(updateParams);
            }
        }
    }
};

function handleWithTradingPairs(param) {
    const {siteType: siteType} = param;
    const {coinName: coinName, currencyName: currencyName} = config.updateConfigTradingPairs(param);
    updateStyleWithTradingPairs(coinName, currencyName, siteType);
    if (siteType !== undefined && siteType != config.currentSiteType) {
        return {};
    }
    if (coinName !== undefined) {
        analytics(config.currentSiteType == SiteType.BRAND ? "otc_p2p_adlist_brand" : "otc_p2p_adlist", {
            otc_step: "change_coin",
            spm: "otc.adlist.page.change_DC",
            side: getTradeType(),
            coin_name: coinName
        });
    }
    if (currencyName !== undefined) {
        refreshBanner(config.currentSiteType, currencyName, true);
        checkForCurrencyIfNeeded();
        analytics(config.currentSiteType == SiteType.BRAND ? "otc_p2p_adlist_brand" : "otc_p2p_adlist", {
            otc_step: "change_fiat",
            spm: "otc.adlist.page.change_LC",
            side: getTradeType(),
            coin_name: config.coinName
        });
    }
    if (config.coinId !== undefined && config.currency !== undefined) {
        return {
            coinId: config.coinId,
            currency: config.currency
        };
    } else if (config.currency !== undefined) {
        return {
            currency: config.currency
        };
    }
    return {};
}

$event.loadListContent = async function(type, updateList) {
    config.currentSiteType = type;
    changeSite(type);
    refreshBanner(type, config.currencyName);
    if (updateList) {
        refreshAdvertListIfNeeds(type, config.target);
    }
    diversionHelper.updateSite(type);
};

$event.changeTradeModel = function(mode) {
    var isAdvertMode = `${mode}` == "1";
    config.isAdvertMode = isAdvertMode;
    var offset = commanData.pageBottomOffset ?? 0;
    offset = isAdvertMode ? offset + 56 : offset;
    updateBottomOffset(offset);
    checkAdvertPushlishStatus();
};

$event.start = async function() {
    config.currentSiteType = await diversionHelper.getSite();
    showMainTab(config.currentSiteType);
};
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWFpbi5qcyIsInNvdXJjZXMiOlsiLi4vLi4vcmVwb3NpdG9yeS9zcmMvY29uZmlnLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvY29tbW9uLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvYWR2ZXJ0RGF0YVNlcnZpY2UuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9hZHZlcnRGaWx0ZXIuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9iYW5uZXIuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9tYWluVGFiLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvdmVyaWZ5Q2FwaXRhbC5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL2FkdmVydExpc3QuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9yaXNrQ29udHJvbC5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL21haW4uanMiXSwic291cmNlc0NvbnRlbnQiOlsiLy8vIOermeeCuVxuZXhwb3J0IGNvbnN0IFNpdGVUeXBlID0ge1xuICAgIEJSQU5EOiAwLCAgIC8vIOWTgeeJjOermVxuICAgIE5PUk1BTDogMSwgLy8g5pmu6YCa56uZXG59O1xuXG4vLy8gY29pbklkIOaVsOWtl+W4gWlkXG4vLy8gY29pbk5hbWUg5pWw5a2X5biB5ZCN56ewXG4vLy8gY3VycmVuY3kg5rOV5biBaWRcbi8vLyBjdXJyZW5jeU5hbWUg5rOV5biB5ZCN56ewXG4vLy8gc3ltYm9sIOazleW4geespuWPtyDvv6UsJFxuY29uc3QgdHJhZGVQYWlycyA9IHtcbiAgICBjb2luSWQ6IHVuZGVmaW5lZCxcbiAgICBjb2luTmFtZTogXCJcIixcbiAgICBjdXJyZW5jeTogdW5kZWZpbmVkLFxuICAgIGN1cnJlbmN5TmFtZTogXCJcIixcbiAgICBzeW1ib2w6IFwiXCIsXG59XG5cbi8qKlxuICog5YWo5bGA6YWN572u6aG5XG4gKi9cbmV4cG9ydCBjb25zdCBjb25maWcgPSB7XG4gICAgdHJhZGVUeXBlOiBcImJ1eVwiLFxuICAgIGN1cnJlbnRTaXRlVHlwZTogdW5kZWZpbmVkLCAvLyDlvZPliY3pgInmi6nnq5nngrlcbiAgICBpc0FkdmVydE1vZGU6IHVuZGVmaW5lZCxcblxuICAgIG5vcm1hbDogeyAuLi50cmFkZVBhaXJzICB9LFxuICAgIGJyYW5kOiB7IC4uLnRyYWRlUGFpcnMgIH0sXG4gICAgZ2V0IHRhcmdldCgpIHtcbiAgICAgICAgaWYgKHRoaXMuY3VycmVudFNpdGVUeXBlID09PSB1bmRlZmluZWQpIHtcbiAgICAgICAgICAgIHJldHVybiB1bmRlZmluZWQ7XG4gICAgICAgIH1cbiAgICAgICAgcmV0dXJuIHRoaXMuY3VycmVudFNpdGVUeXBlID09PSBTaXRlVHlwZS5CUkFORCA/IHRoaXMuYnJhbmQgOiB0aGlzLm5vcm1hbDtcbiAgICB9LFxuICAgIHVwZGF0ZUNvbmZpZ1RyYWRpbmdQYWlyczogZnVuY3Rpb24ocGFyYW0pIHtcbiAgICAgICAgY29uc3QgeyBjb2luTmFtZSwgY29pbklkLCBjdXJyZW5jeSwgc3ltYm9sLCBjdXJyZW5jeU5hbWUsIHNpdGVUeXBlIH0gPSBwYXJhbTtcbiAgICAgICAgdmFyIHVwZGF0ZVBhcmFtcyA9IHt9IC8vIOiusOW9leabtOaWsOeahOWPguaVsFxuICAgICAgICB2YXIgdGFyZ2V0ID0gdGhpcy50YXJnZXRcbiAgICAgICAgLy8g5aaC5p6c5oyH5a6a5LqGc2l0ZVR5cGXvvIzliJnmm7TmlrDmjIflrprnq5nngrnnmoTkuqTmmJPlr7lcbiAgICAgICAgaWYgKHNpdGVUeXBlICE9PSB1bmRlZmluZWQpIHtcbiAgICAgICAgICAgIHRhcmdldCA9IHNpdGVUeXBlID09IDAgPyB0aGlzLmJyYW5kIDogdGhpcy5ub3JtYWxcbiAgICAgICAgfVxuICAgICAgICAvLyDmm7TmlrDmlbDlrZfluIHkv6Hmga/vvIzpnIDopoHlkIzml7bmnIkgY29pbk5hbWUsIGNvaW5JZFxuICAgICAgICBpZiAoY29pbk5hbWUgJiYgdGFyZ2V0LmNvaW5OYW1lICE9IGNvaW5OYW1lIFxuICAgICAgICAgICAgJiYgY29pbklkICE9PSB1bmRlZmluZWQgJiYgdGFyZ2V0LmNvaW5JZCAhPSBjb2luSWQgKSB7XG4gICAgICAgICAgICB0YXJnZXQuY29pbklkID0gY29pbklkO1xuICAgICAgICAgICAgdGFyZ2V0LmNvaW5OYW1lID0gY29pbk5hbWU7XG4gICAgICAgICAgICB1cGRhdGVQYXJhbXMuY29pbklkID0gY29pbklkO1xuICAgICAgICAgICAgdXBkYXRlUGFyYW1zLmNvaW5OYW1lID0gY29pbk5hbWU7XG4gICAgICAgIH1cbiAgICAgICAgLy8g5pu05paw5rOV5biB5L+h5oGv77yM6ZyA6KaB5ZCM5pe25pyJIGN1cnJlbmN5TmFtZSwgY3VycmVuY3nvvIwgc3ltYm9sXG4gICAgICAgIGlmIChjdXJyZW5jeU5hbWUgJiYgdGFyZ2V0LmN1cnJlbmN5TmFtZSAhPSBjdXJyZW5jeU5hbWVcbiAgICAgICAgICAgICYmIGN1cnJlbmN5ICE9PSB1bmRlZmluZWQgJiYgdGFyZ2V0LmN1cnJlbmN5ICE9IGN1cnJlbmN5XG4gICAgICAgICAgICAmJiBzeW1ib2wgJiYgdGFyZ2V0LnN5bWJvbCAhPSBzeW1ib2xcbiAgICAgICAgKSB7XG4gICAgICAgICAgICB0YXJnZXQuY3VycmVuY3kgPSBjdXJyZW5jeVxuICAgICAgICAgICAgdGFyZ2V0LmN1cnJlbmN5TmFtZSA9IGN1cnJlbmN5TmFtZVxuICAgICAgICAgICAgdGFyZ2V0LnN5bWJvbCA9IHN5bWJvbFxuICAgICAgICAgICAgdXBkYXRlUGFyYW1zLmN1cnJlbmN5ID0gY3VycmVuY3lcbiAgICAgICAgICAgIHVwZGF0ZVBhcmFtcy5jdXJyZW5jeU5hbWUgPSBjdXJyZW5jeU5hbWVcbiAgICAgICAgICAgIHVwZGF0ZVBhcmFtcy5zeW1ib2wgPSBzeW1ib2xcbiAgICAgICAgfVxuICAgICAgICByZXR1cm4gdXBkYXRlUGFyYW1zO1xuICAgIH1cbn07XG5cbk9iamVjdC5lbnRyaWVzKHRyYWRlUGFpcnMpLmZvckVhY2goKFtwcm9wXSkgPT4ge1xuICAgIE9iamVjdC5kZWZpbmVQcm9wZXJ0eShjb25maWcsIHByb3AsIHtcbiAgICAgIGVudW1lcmFibGU6IHRydWUsXG4gICAgICBjb25maWd1cmFibGU6IHRydWUsXG4gICAgICBnZXQoKSB7XG4gICAgICAgIHJldHVybiAoY29uZmlnLnRhcmdldCAmJiBjb25maWcudGFyZ2V0W3Byb3BdKSA/PyB0cmFkZVBhaXJzW3Byb3BdO1xuICAgICAgfSxcbiAgICAgIHNldCh2YWx1ZSkge1xuICAgICAgICBpZiAoY29uZmlnLnRhcmdldCkge1xuICAgICAgICAgICAgY29uZmlnLnRhcmdldFtwcm9wXSA9IHZhbHVlXG4gICAgICAgIH1cbiAgICAgIH1cbiAgICB9KTtcbiAgfVxuKSIsIi8qKlxuICogQHR5cGVkZWYge09iamVjdH0gQ29tbWFuRGF0YSBcbiAqIEBwcm9wZXJ0eSB7c3RyaW5nfSBpY29uVVJMSG9zdCAgICAgICAtIOW4geenjeWbvuagh+Wfn+WQjVxuICogQHByb3BlcnR5IHtudW1iZXJ9IGNvbG9yTW9kZSAgICAgICAgIC0g55m95aSp6buR5aSc5qih5byPXG4gKiBAcHJvcGVydHkge3N0cmluZ30gbGFuZ3VhZ2UgICAgICAgICAgLSDor63np43phY3nva5cbiAqIEBwcm9wZXJ0eSB7c3RyaW5nfSBPUyAgICAgICAgICAgICAgICAtIOezu+e7n1xuICogQHByb3BlcnR5IHtzdHJpbmd9IHVpZCAgICAgICAgICAgICAgIC0g55So5oi3dWlkXG4gKiBAcHJvcGVydHkge3N0cmluZ30gYXBwVmVyc2lvbiAgICAgICAgLSDniYjmnKzlj7dcbiAqL1xuXG4vKiogQHR5cGUgQ29tbWFuRGF0YSAqL1xuZXhwb3J0IHZhciBjb21tYW5EYXRhID0ge1xuICAgIGljb25VUkxIb3N0OiBcIlwiLFxuICAgIGNvbG9yTW9kZTogMCwgLy8gMOeZveWkqe+8jDHpu5HlpJxcbiAgICBPUzogXCJcIiwgLy8gXCIwXCI6IGlvczsgXCIxXCI6IGFuZHJvaWRcbiAgICBhcHBWZXJzaW9uOiBcIlwiLFxuICAgIGxhbmd1YWdlOiBcIlwiLFxuICAgIHVpZDogXCJcIiwgLy8g5b2T5YmN55So5oi3dWlkXG4gICAgcGFnZUJvdHRvbU9mZnNldDogMCxcbiAgICBzY3JlZW5XaWR0aDogMCxcbiAgICBzY3JlZW5IZWlnaHQ6IDAsXG59O1xuXG4vL+WPkemAgeivt+axglxuLy9ob3N0VHlwZT0x6LWwT1RDX1VSTCAgbWV0aG9kOiAwIGdldO+8myAxIHBvc3RcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzZW5kUmVxdWVzdChwYXRoLCBwYXJhbXMgPSB7fSwgbWV0aG9kID0gMCwgaG9zdFR5cGUgPSAxLCBoZWFkZXIgPSB7fSkge1xuICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0ICR7cGF0aH1gKTtcbiAgICBjb25zdCBwYXJhbSA9IHtcbiAgICAgICAgcGF0aCxcbiAgICAgICAgbWV0aG9kLFxuICAgICAgICBob3N0VHlwZSxcbiAgICAgICAgaGVhZGVyLFxuICAgICAgICBwYXJhbXNcbiAgICB9O1xuICAgIHRyeSB7XG4gICAgICAgIHZhciByZXNwb25zZVN0cmluZyA9IHJlc3BvbnNlU3RyaW5nID0gYXdhaXQgJG5hdGl2ZUFQSS5yZXF1ZXN0KEpTT04uc3RyaW5naWZ5KHBhcmFtKSk7XG4gICAgICAgIHZhciByZXNwb25zZSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcpO1xuICAgICAgICB2YXIgeyBjb2RlIH0gPSByZXNwb25zZTtcbiAgICAgICAgaWYgKGNvZGUgPT0gMjAwKSB7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCAke3BhdGh9IGRvbmVgKTtcbiAgICAgICAgICAgIHJldHVybiByZXNwb25zZTtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0IGZhaWxlZCwgY29kZT0ke2NvZGV9YCk7XG4gICAgICAgICAgICByZXR1cm4gcmVzcG9uc2U7XG4gICAgICAgIH1cbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIC8vIG5ldHdvcmsgZXJyb3JcbiAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgZXJyb3IsIGVycm9yPSR7ZX1gKTtcbiAgICAgICAgcmV0dXJuIG51bGw7XG4gICAgfVxufVxuXG4vL+iOt+WPlmljb27lrozmlbR1cmxcbmV4cG9ydCBmdW5jdGlvbiBnZXRJY29uVVJMKGN1cnJlbmN5KSB7XG4gICAgdmFyIGNvaW5OYW1lID0gY3VycmVuY3kudG9Mb3dlckNhc2UoKTtcbiAgICBjb25zdCBpY29uVVJMID0gYGh0dHBzOi8vJHtjb21tYW5EYXRhLmljb25VUkxIb3N0fS8tL3gvaGIvcC9hcGkvY29udGVudHMvY3VycmVuY3kvaWNvbl9wbmcvJHtjb2luTmFtZX0ucG5nYDtcbiAgICByZXR1cm4gaWNvblVSTDtcbn1cblxuLyog6Ziy5q2i6YeN5aSN54K55Ye7ICovXG5sZXQgY2xpY2tUaW1lciA9IDBcblxuZnVuY3Rpb24gY2xpY2tUaHJvdHRsZShpbnRlcnZhbCA9IDEwMDApIHtcbiAgICBsZXQgbm93ID0gK25ldyBEYXRlKCk7IC8vIOiOt+WPluW9k+WJjeaXtumXtOeahOaXtumXtOaIs1xuICAgIGxldCB0aW1lciA9IGNsaWNrVGltZXI7IC8vIOiusOW9leinpuWPkeS6i+S7tueahOS6i+S7tuaIs1xuXG4gICAgaWYgKG5vdyAtIHRpbWVyIDwgaW50ZXJ2YWwpIHtcbiAgICAgICAgLy8g5aaC5p6c5b2T5YmN5pe26Ze0IC0g6Kem5Y+R5LqL5Lu25pe255qE5LqL5Lu2IDwgaW50ZXJWYWzvvIzpgqPkuYjkuI3nrKblkIjmnaHku7bvvIznm7TmjqVyZXR1cm4gZmFsc2XvvIxcbiAgICAgICAgLy8g5LiN6K6p5b2T5YmN5LqL5Lu257un57ut5omn6KGM5LiL5Y67XG4gICAgICAgIHJldHVybiBmYWxzZTtcbiAgICB9IGVsc2Uge1xuICAgICAgICAvLyDlj43kuYvvvIzorrDlvZXnrKblkIjmnaHku7bop6blj5Hkuobkuovku7bnmoTml7bpl7TmiLPvvIzlubYgcmV0dXJuIHRydWXvvIzkvb/kuovku7bnu6fnu63lvoDkuIvmiafooYxcbiAgICAgICAgY2xpY2tUaW1lciA9IG5vdztcbiAgICAgICAgcmV0dXJuIHRydWU7XG4gICAgfVxufVxuXG4vL+aJk+W8gFVSTFxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIG9wZW5VUkwodXJsKSB7XG4gICAgaWYgKCFjbGlja1Rocm90dGxlKCkpXG4gICAgICAgIHJldHVybjtcbiAgICAkbmF0aXZlQVBJLm9wZW5Sb3V0ZSh1cmwpXG59XG5cbi8v5L+d5a2Y5pWw5o2uXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc2F2ZShtb2R1bGUsIGtleSwgZGF0YSkge1xuICAgIGF3YWl0ICRuYXRpdmVBUEkuc3RvcmFnZSh7XG4gICAgICAgIGFjdGlvbjogXCJzYXZlXCIsXG4gICAgICAgIG5hbWU6IG1vZHVsZSxcbiAgICAgICAga2V5OiBrZXksXG4gICAgICAgIGRhdGE6IEpTT04uc3RyaW5naWZ5KGRhdGEpXG4gICAgfSk7XG59XG5cbi8v6K+75Y+W5pWw5o2uXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gcmVhZChtb2R1bGUsIGtleSkge1xuICAgIGNvbnN0IGRhdGEgPSBhd2FpdCAkbmF0aXZlQVBJLnN0b3JhZ2Uoe1xuICAgICAgICBhY3Rpb246IFwicmVhZFwiLFxuICAgICAgICBuYW1lOiBtb2R1bGUsXG4gICAgICAgIGtleToga2V5XG4gICAgfSk7XG4gICAgaWYgKGRhdGEgJiYgZGF0YSAhPSBcIlwiKSB7XG4gICAgICAgIHJldHVybiBKU09OLnBhcnNlKGRhdGEpO1xuICAgIH1cbiAgICByZXR1cm4gbnVsbDtcbn1cblxuLy/muIXnkIbmlbDmja5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBjbGVhcihtb2R1bGUsIGtleSkge1xuICAgIGF3YWl0ICRuYXRpdmVBUEkuc3RvcmFnZSh7XG4gICAgICAgIGFjdGlvbjogXCJjbGVhclwiLFxuICAgICAgICBuYW1lOiBtb2R1bGUsXG4gICAgICAgIGtleToga2V5XG4gICAgfSk7XG59XG5cbi8v5riF55CG5YWo6YOo5pWw5o2uXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gY2xlYXJBbGwobW9kdWxlKSB7XG4gICAgYXdhaXQgJG5hdGl2ZUFQSS5zdG9yYWdlKHtcbiAgICAgICAgYWN0aW9uOiBcImNsZWFyXCIsXG4gICAgICAgIG5hbWU6IG1vZHVsZVxuICAgIH0pO1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gdXBsb2FkTG9nKHRhZywgaW5mbyA9IFwiXCIpIHtcbiAgICBpZiAoY29tbWFuRGF0YS5PUyA9PSAwKSB7XG4gICAgICAgIHZhciBtYXAgPSB7XG4gICAgICAgICAgICB0YWc6IHRhZyxcbiAgICAgICAgICAgIGluZm86IGluZm9cbiAgICAgICAgfTtcbiAgICAgICAgYXdhaXQgJG5hdGl2ZUFQSS51cGxvYWRMb2cobWFwKTtcbiAgICB9XG5cbn1cblxuLy/ln4vngrlcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBhbmFseXRpY3MoZXZlbnQgPSBcIlwiLCBwcm9wZXJ0aWVzID0ge30pIHtcbiAgICBjb25zdCBwcm9wZXJ0aWVzSnNvbiA9IEpTT04uc3RyaW5naWZ5KHByb3BlcnRpZXMpO1xuICAgIC8vIGNvbnNvbGUubG9nKGBhbmFseXRpY3MgZXZlbnQ6ICR7ZXZlbnR9LCBwcm9wZXJ0aWVzSnNvbiA9ICR7cHJvcGVydGllc0pzb259YCk7XG4gICAgdmFyIG1hcCA9IHtcbiAgICAgICAgZXZlbnQ6IGV2ZW50LFxuICAgICAgICBwcm9wZXJ0aWVzOiBwcm9wZXJ0aWVzSnNvblxuICAgIH07XG4gICAgYXdhaXQgJG5hdGl2ZUFQSS5hbmFseXRpY3MobWFwKTtcbn1cblxuLy/orr7nva7pgJrnlKjphY3nva5cbmV4cG9ydCBmdW5jdGlvbiBwYXJzZUNvbW1vbkNvbmZpZyhwYXJhbSkge1xuICAgIGNvbW1hbkRhdGEuY29sb3JNb2RlID0gcGFyc2VJbnQocGFyYW0uY29sb3JNb2RlKTtcbiAgICBjb21tYW5EYXRhLmljb25VUkxIb3N0ID0gcGFyYW0uaWNvblVSTEhvc3Q7XG4gICAgY29tbWFuRGF0YS5PUyA9IHBhcnNlSW50KHBhcmFtLk9TKTtcbiAgICBjb21tYW5EYXRhLmFwcFZlcnNpb24gPSBwYXJhbS5hcHBWZXJzaW9uO1xuICAgIGNvbW1hbkRhdGEubGFuZ3VhZ2UgPSBwYXJhbS5sYW5ndWFnZTtcbiAgICBjb21tYW5EYXRhLnVpZCA9IHBhcmFtLnVpZFxuICAgIGNvbW1hbkRhdGEucGFnZUJvdHRvbU9mZnNldCA9IHBhcmFtLnBhZ2VCb3R0b21PZmZzZXRcbiAgICBjb21tYW5EYXRhLnNjcmVlbldpZHRoID0gcGFyYW0uc2NyZWVuV2lkdGhcbiAgICBjb21tYW5EYXRhLnNjcmVlbkhlaWdodCA9IHBhcmFtLnNjcmVlbkhlaWdodFxufVxuXG5leHBvcnQgZnVuY3Rpb24gbW9kdWxlRGVmaW5lKG1vZHVsZU5hbWUsIHN0YXJ0RnVuY3Rpb24sIGRlZmF1bHREYXRhRnVuY3Rpb24pIHtcbiAgICAkZGF0YVttb2R1bGVOYW1lXSA9IGRlZmF1bHREYXRhRnVuY3Rpb24oKTtcbiAgICAkZXZlbnRbbW9kdWxlTmFtZV0gPSB7IHN0YXJ0OiBzdGFydEZ1bmN0aW9uIH07XG4gICAgcmV0dXJuIHtcbiAgICAgICAgbW9kdWxlRXZlbnQ6ICRldmVudFttb2R1bGVOYW1lXSxcbiAgICAgICAgbW9kdWxlRGF0YTogJGRhdGFbbW9kdWxlTmFtZV1cbiAgICB9O1xufVxuXG4vKipcbiAqIOino+aekOivt+axguWPguaVsFxuICogQHBhcmFtIHtPYmplY3R8c3RyaW5nfSByZXF1ZXN0SnNvbiAtIOivt+axguWPguaVsO+8iOWvueixoeaIlkpTT07lrZfnrKbkuLLvvIlcbiAqIEByZXR1cm5zIHtPYmplY3R9IOino+aekOWQjueahOWPguaVsOWvueixoVxuICovXG5leHBvcnQgZnVuY3Rpb24gcGFyc2VSZXF1ZXN0UGFyYW1zKHJlcXVlc3RKc29uKSB7XG4gICAgaWYgKHR5cGVvZiByZXF1ZXN0SnNvbiA9PT0gXCJzdHJpbmdcIiB8fCByZXF1ZXN0SnNvbiBpbnN0YW5jZW9mIFN0cmluZykge1xuICAgICAgICByZXR1cm4gSlNPTi5wYXJzZShyZXF1ZXN0SnNvbik7XG4gICAgfVxuICAgIHJldHVybiByZXF1ZXN0SnNvbjtcbn1cblxuXG4vKipcbiAqIOagvOW8j+WMluaVsOWtl++8jOS9v+WFtuavj+S4ieS9jeeUqOmAl+WPt+WIhumalFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSBudW1iZXIgLSDpnIDopoHmoLzlvI/ljJbnmoTmlbDlrZdcbiAqIEByZXR1cm5zIHtzdHJpbmd9IOagvOW8j+WMluWQjueahOaVsOWtl+Wtl+espuS4slxuICovXG5leHBvcnQgZnVuY3Rpb24gdGhvdXNhbmRzRm9ybWF0dGVyKG51bWJlcikge1xuICAgIGxldCBudW1iZXJTdHJpbmcgPSBudW1iZXIudG9TdHJpbmcoKTtcbiAgICBpZiAobnVtYmVyU3RyaW5nLmluY2x1ZGVzKFwiLFwiKSkge1xuICAgICAgICByZXR1cm4gbnVtYmVyU3RyaW5nXG4gICAgfVxuICAgIGxldCBbaW50ZWdlclBhcnQsIGRlY2ltYWxQYXJ0XSA9IG51bWJlclN0cmluZy5zcGxpdChcIi5cIik7XG4gICAgaW50ZWdlclBhcnQgPSBpbnRlZ2VyUGFydC5yZXBsYWNlKC9cXEIoPz0oXFxkezN9KSsoPyFcXGQpKS9nLCBcIixcIik7XG4gICAgaWYgKGRlY2ltYWxQYXJ0KSB7XG4gICAgICAgIHJldHVybiBpbnRlZ2VyUGFydCArIFwiLlwiICsgZGVjaW1hbFBhcnQ7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgcmV0dXJuIGludGVnZXJQYXJ0O1xuICAgIH1cbn0iLCJpbXBvcnQgeyBjb25maWcsIFNpdGVUeXBlIH0gZnJvbSBcIi4vY29uZmlnXCI7XG5pbXBvcnQgKiBhcyBjb21tb24gZnJvbSBcIi4vY29tbW9uXCJcbi8qKlxuICog6buY6K6k5bm/5ZGK6K+35rGC5Y+C5pWwXG4gKi9cbmNvbnN0IGFkdmVydFJlcXVzdENvbW1vbkRhdGEgPSB7XG4gICAgLy8vIOW4geenjUlkXG4gICAgY29pbklkOiAyLFxuICAgIC8vLyDotKfluIFJRFxuICAgIGN1cnJlbmN5OiB1bmRlZmluZWQsXG4gICAgLy8vIOS6pOaYk+exu+Wei++8jGJ1eS3kubDlhaXlub/lkYrvvIxzZWxsLeWNluWHuuW5v+WRilxuICAgIHRyYWRlVHlwZTogXCJzZWxsXCIsXG4gICAgLy8vIOaYr+WQpuWPr+S6pOaYkyAo5Y+v5Lqk5piT5oyJ6ZKuKVxuICAgIG9ubHlUcmFkYWJsZTogZmFsc2UsXG4gICAgLy8vIOW9k+WJjemhteWPt1xuICAgIGN1cnJQYWdlOiAxLFxuICAgIC8vLyDlub/lkYrnsbvlnosgZ2VuZXJhbC3mma7pgJrlub/lkYrvvIxibG9jay3lpKflrpflub/lkYogIGJyYW5k5ZOB54mM56uZXG4gICAgYmxvY2tUeXBlOiBcImdlbmVyYWxcIixcbiAgICAvLy8g5LiL5Y2V5pyA5bCP6YeR6aKdXG4gICAgYW1vdW50OiBcIlwiLFxuICAgIC8vLyDmlK/ku5jmlrnlvI9JRCjlpJrkuKrpgJflj7fliIblibIpICAxLDIsM1xuICAgIHBheU1ldGhvZDogXCJcIixcbn1cblxuZXhwb3J0IGNvbnN0IG5vcm1hbEFkdmVydFBhcmFtcyA9IHtcbiAgICAvLy8g5oiR5Lqk5piT6L+H55qE5ZWG5a62XG4gICAgaXNUcmFkZWQ6IGZhbHNlLFxuICAgIC8vLyDmmK/lkKbmmK9NVlDllYblrrZcbiAgICBpc1RodW1ic1VwOiBmYWxzZSxcbiAgICAvLy8g5oiR5YWz5rOo6L+H55qE5ZWG5a62XG4gICAgaXNGb2xsb3dlZDogZmFsc2UsXG4gICAgLy8vIOS8oCAxIOafpeaJvua1t+aZr+aIv+W5v+WRilxuICAgIHNlYVZpZXdSb29tOiAwLFxuICAgIC8vLyDlub/lkYrmtLvliqjmoIfnrb5pZO+8jOeUqOS6juetm+mAiVxuICAgIGxhYmVsSWQ6IFwiXCIsXG4gICAgLy8vIOaYr+WQpuS4uuWVhuWutlxuICAgIGlzTWVyY2hhbnQ6IGZhbHNlLFxuICAgIC8vLyAzMOWkqeWujOaIkOeOh1xuICAgIG1ha2VyQ29tcGxldGVSYXRlOiAwLFxuICAgIC8vLyDllYblrrbmoIfnrb4gMS3ok53nm77mnI3liqFcbiAgICBtZXJjaGFudFRhZ3M6IFwiXCIsXG4gICAgLi4uYWR2ZXJ0UmVxdXN0Q29tbW9uRGF0YSxcbn07XG5cbmV4cG9ydCBjb25zdCBicmFuZEFkdmVydFBhcmFtcyA9IHtcbiAgICAuLi5hZHZlcnRSZXF1c3RDb21tb25EYXRhLFxuICAgIC8vLyDlk4HniYzmoIfnrb4sIOabtOWkmuetm+mAieagj+S4rVxuICAgIGJsb2NrVHlwZTogXCJicmFuZFwiLFxuICAgIGJyYW5kTGFiZWxJZHM6IFwiXCIsXG4gICAgbGFiZWxJZDogXCJcIixcbn1cblxuY29uc3QgcmVxZXVzdCA9IHtcbiAgICBicmFuZDogeyAuLi5icmFuZEFkdmVydFBhcmFtcyB9LFxuICAgIG5vcm1hbDogeyAuLi5ub3JtYWxBZHZlcnRQYXJhbXMgfSxcbiAgICBzZXRQYXJhbXMoc2l0ZVR5cGUsIHZhbHVlKSB7XG4gICAgICAgIC8vIOS6pOaYk+aWueWQkeWPmOmdqe+8jOmHjee9ruivt+axgumhteaVsFxuICAgICAgICBpZiAodmFsdWUgIT0gY29uZmlnLnRyYWRlVHlwZSB8fCB2YWx1ZS5jdXJyUGFnZSA9PSAwKSB7XG4gICAgICAgICAgICB2YWx1ZS5jdXJyUGFnZSA9IDFcbiAgICAgICAgfVxuICAgICAgICBpZiAoc2l0ZVR5cGUgPT0gU2l0ZVR5cGUuQlJBTkQpIHtcbiAgICAgICAgICAgIHRoaXMuYnJhbmQgPSB2YWx1ZTtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIHRoaXMubm9ybWFsID0gdmFsdWU7XG4gICAgICAgIH1cbiAgICB9LFxuICAgIGdldFBhcmFtcyhzaXRlVHlwZSkge1xuICAgICAgICByZXR1cm4gc2l0ZVR5cGUgPT0gU2l0ZVR5cGUuQlJBTkQgPyB0aGlzLmJyYW5kIDogdGhpcy5ub3JtYWxcbiAgICB9LFxuICAgIGdldEVuZFBvaW50KHNpdGVUeXBlKSB7XG4gICAgICAgIHJldHVybiBzaXRlVHlwZSA9PSBTaXRlVHlwZS5CUkFORCA/IFwidjEvYWR2ZXJ0aXNlL2RhdGEvdHJhZGUtbWFya2V0L2JyYW5kXCIgOiBcInYxL2RhdGEvdHJhZGUtbWFya2V0XCJcbiAgICB9LFxuICAgIHJlc2V0KCkge1xuICAgICAgICB0aGlzLmJyYW5kID0geyAuLi5icmFuZEFkdmVydFBhcmFtcyB9XG4gICAgICAgIHRoaXMubm9ybWFsID0geyAuLi5ub3JtYWxBZHZlcnRQYXJhbXMgfVxuICAgIH0sXG4gICAgaGFzU2VsZWN0ZWRNb3JlKHNpdGVUeXBlKSB7XG4gICAgICAgIGlmIChzaXRlVHlwZSA9PSBTaXRlVHlwZS5CUkFORCkge1xuICAgICAgICAgICAgcmV0dXJuIHRoaXMuYnJhbmQuYnJhbmRMYWJlbElkcyAhPT0gXCJcIiB8fCB0aGlzLmJyYW5kLmxhYmVsSWQgIT09IFwiXCJcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIHJldHVybiB0aGlzLm5vcm1hbC5pc0ZvbGxvd2VkIHx8IHRoaXMubm9ybWFsLmlzTWVyY2hhbnQgfHwgdGhpcy5ub3JtYWwuaXNUcmFkZWQgfHwgdGhpcy5ub3JtYWwuaXNUaHVtYnNVcCB8fFxuICAgICAgICAgICAgICAgICh0aGlzLm5vcm1hbC5tZXJjaGFudFRhZ3MubGVuZ3RoID4gMCAmJiB0aGlzLm5vcm1hbC50cmFkZVR5cGUgPT0gXCJidXlcIikgfHwgdGhpcy5ub3JtYWwubWFrZXJDb21wbGV0ZVJhdGUgPiAwIHx8XG4gICAgICAgICAgICAgICAgdGhpcy5ub3JtYWwubGFiZWxJZCAhPT0gXCJcIiB8fCB0aGlzLm5vcm1hbC5ibG9ja1R5cGUgPT09IFwiYmxvY2tcIjtcbiAgICAgICAgfVxuICAgIH1cblxufVxuXG5mdW5jdGlvbiBnZXRDdXJyZW50UmVxdWVzdFBhcmFtcyhzaXRlVHlwZSkge1xuICAgIHJldHVybiByZXFldXN0LmdldFBhcmFtcyhzaXRlVHlwZSlcbn1cblxuZnVuY3Rpb24gcmVzZXRQYXJhbXMoKSB7XG4gICAgcmVxZXVzdC5yZXNldCgpXG59XG5cbmZ1bmN0aW9uIHJlc2V0TGFiZWxJZChzaXRlVHlwZSkge1xuICAgIHJlcWV1c3QuZ2V0UGFyYW1zKHNpdGVUeXBlKS5sYWJlbElkID0gXCJcIlxufVxuXG5mdW5jdGlvbiByZXNldE1lcmNoYW50VGFncyhzaXRlVHlwZSkge1xuICAgIHJlcWV1c3QuZ2V0UGFyYW1zKHNpdGVUeXBlKS5tZXJjaGFudFRhZ3MgPSBcIlwiXG59XG5cbmZ1bmN0aW9uIGhhc1NlbGVjdGVkTW9yZShzaXRlVHlwZSkge1xuICAgIHJldHVybiByZXFldXN0Lmhhc1NlbGVjdGVkTW9yZShzaXRlVHlwZSlcbn1cblxuZnVuY3Rpb24gdXBkYXRlQWR2ZXJ0TGlzdFdpdGhGaWx0ZXJQYXJhbXMoc2l0ZVR5cGUsIGpzb24pIHtcbiAgICByZXFldXN0LnNldFBhcmFtcyhzaXRlVHlwZSwgeyAuLi5yZXFldXN0LmdldFBhcmFtcyhzaXRlVHlwZSksIC4uLmpzb24gfSlcbiAgICByZXR1cm4gcmVxZXVzdC5oYXNTZWxlY3RlZE1vcmUoc2l0ZVR5cGUpXG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlZnJlc2hBZHZlcnRMaXN0KHNpdGVUeXBlKSB7XG4gICAgcmVxZXVzdC5nZXRQYXJhbXMoc2l0ZVR5cGUpLmN1cnJQYWdlID0gMTtcbiAgICByZXR1cm4gYXdhaXQgbG9hZEFkdmVydExpc3REYXRhcyhzaXRlVHlwZSk7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIGxvYWRNb3JlQWR2ZXJ0TGlzdChzaXRlVHlwZSkge1xuICAgIHJlcWV1c3QuZ2V0UGFyYW1zKHNpdGVUeXBlKS5jdXJyUGFnZSsrO1xuICAgIHJldHVybiBhd2FpdCBsb2FkQWR2ZXJ0TGlzdERhdGFzKHNpdGVUeXBlKTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gbG9hZEFkdmVydExpc3REYXRhcyhzaXRlVHlwZSkge1xuICAgIGNvbnN0IGVuZHBvaW50ID0gcmVxZXVzdC5nZXRFbmRQb2ludChzaXRlVHlwZSlcbiAgICBjb25zdCBwYXJhbXMgPSByZXFldXN0LmdldFBhcmFtcyhzaXRlVHlwZSlcbiAgICBjb25zb2xlLmxvZyhKU09OLnN0cmluZ2lmeShwYXJhbXMpKVxuICAgIGNvbnN0IHJlc3BvbnNlID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KGVuZHBvaW50LCBwYXJhbXMpXG4gICAgaWYgKHJlc3BvbnNlKSB7XG4gICAgICAgIGlmIChyZXNwb25zZS5zdWNjZXNzKSB7XG4gICAgICAgICAgICBjb25zdCB7IGN1cnJQYWdlLCBzdWNjZXNzLCBtZXNzYWdlLCB0b3RhbFBhZ2UsIGRhdGEsIGV4dGVuZCB9ID0gcmVzcG9uc2VcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKFwidXBkYXRlVHJhZGluZ1BhaXJzIFAyUCBsaXN0IGRhdGEgbG9hZGVkIHN1Y2Nlc3NmdWxseTpcIiwgZGF0YSlcbiAgICAgICAgICAgIHJlcWV1c3QuZ2V0UGFyYW1zKHNpdGVUeXBlKS5jdXJyUGFnZSA9IGN1cnJQYWdlXG4gICAgICAgICAgICB2YXIgaGFzTW9yZSA9IGN1cnJQYWdlIDwgdG90YWxQYWdlXG4gICAgICAgICAgICByZXR1cm4ge1xuICAgICAgICAgICAgICAgIGV4dGVuZCxcbiAgICAgICAgICAgICAgICBkYXRhczogZGF0YSxcbiAgICAgICAgICAgICAgICBoYXNNb3JlLFxuICAgICAgICAgICAgICAgIHNpdGVUeXBlXG4gICAgICAgICAgICB9XG4gICAgICAgIH0gZWxzZSBpZiAocmVzcG9uc2UubWVzc2FnZSAhPT0gdW5kZWZpbmVkKSB7XG4gICAgICAgICAgICBjb25zb2xlLmVycm9yKFwidXBkYXRlVHJhZGluZ1BhaXJzIEZhaWxlZCB0byBsb2FkIFAyUCBsaXN0IGRhdGE6XCIsIHJlc3BvbnNlLm1lc3NhZ2UpXG4gICAgICAgICAgICByZXR1cm4ge31cbiAgICAgICAgfVxuICAgIH0gZWxzZSB7XG4gICAgICAgIC8vIOe9kee7nOWksei0pVxuICAgICAgICByZXR1cm4gbnVsbFxuICAgIH1cbn1cblxuLy8vIOa1t+aZr+aIv+aVsOaNruiOt+WPllxuYXN5bmMgZnVuY3Rpb24gbG9hZFNlYXZpZXdSb29tRGF0YXNXaXRoVG9wVGhyZWUoKSB7XG4gICAgLy8g5Y+q5pyJ5pmu6YCa56uZY29pbklk5Li6MuaXtuaJjeWKoOi9vVxuICAgIGlmIChyZXFldXN0LmdldFBhcmFtcyhTaXRlVHlwZS5OT1JNQUwpLmNvaW5JZCAhPSAyKSB7XG4gICAgICAgIHJldHVybiB7IGRhdGFzOiBbXSB9XG4gICAgfVxuICAgIHRyeSB7XG4gICAgICAgIGNvbnN0IHJlc3BvbnNlID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KFwidjEvZGF0YS90cmFkZS1tYXJrZXRcIiwgeyAuLi5yZXFldXN0LmdldFBhcmFtcyhTaXRlVHlwZS5OT1JNQUwpLCBzZWFWaWV3Um9vbTogMSwgY3VyclBhZ2U6IDEsIHBhZ2VTaXplOiAzIH0pXG4gICAgICAgIGNvbnN0IHsgc3VjY2VzcywgbWVzc2FnZSwgZGF0YSB9ID0gcmVzcG9uc2VcbiAgICAgICAgaWYgKHN1Y2Nlc3MpIHtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKFwidXBkYXRlVHJhZGluZ1BhaXJzIFAyUCBsaXN0IGRhdGEgbG9hZGVkIHN1Y2Nlc3NmdWxseTpcIiwgZGF0YSlcbiAgICAgICAgICAgIHJldHVybiB7XG4gICAgICAgICAgICAgICAgZGF0YXM6IGRhdGFcbiAgICAgICAgICAgIH1cbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGNvbnNvbGUuZXJyb3IoXCJ1cGRhdGVUcmFkaW5nUGFpcnMgRmFpbGVkIHRvIGxvYWQgUDJQIGxpc3QgZGF0YTpcIiwgbWVzc2FnZSlcbiAgICAgICAgICAgIHJldHVybiB7fVxuICAgICAgICB9XG4gICAgfSBjYXRjaCAoZXJyb3IpIHtcbiAgICAgICAgY29uc29sZS5lcnJvcihcInVwZGF0ZVRyYWRpbmdQYWlycyBlcnJvciB0byBsb2FkIFAyUCBsaXN0IGRhdGE6XCIsIGVycm9yKVxuICAgICAgICByZXR1cm4gbnVsbFxuICAgIH1cbn1cblxuZXhwb3J0IHtcbiAgICByZWZyZXNoQWR2ZXJ0TGlzdCxcbiAgICBsb2FkTW9yZUFkdmVydExpc3QsXG4gICAgcmVzZXRQYXJhbXMsXG4gICAgdXBkYXRlQWR2ZXJ0TGlzdFdpdGhGaWx0ZXJQYXJhbXMsXG4gICAgZ2V0Q3VycmVudFJlcXVlc3RQYXJhbXMsXG4gICAgbG9hZFNlYXZpZXdSb29tRGF0YXNXaXRoVG9wVGhyZWUsXG4gICAgcmVzZXRMYWJlbElkLFxuICAgIHJlc2V0TWVyY2hhbnRUYWdzLFxuICAgIGhhc1NlbGVjdGVkTW9yZVxufSIsImltcG9ydCAqIGFzIGNvbW1vbiBmcm9tIFwiLi9jb21tb25cIjtcbmltcG9ydCB7IGNvbmZpZywgU2l0ZVR5cGUgfSBmcm9tIFwiLi9jb25maWdcIlxuaW1wb3J0ICogYXMgZGF0YVNlcnZpY2UgZnJvbSAnLi9hZHZlcnREYXRhU2VydmljZS5qcydcblxuXG5hc3luYyBmdW5jdGlvbiBzdGFydCgpIHtcbiAgICBjb25zb2xlLmxvZyhgYWR2ZXJ0RmlsdGVyLmpzIHN0YXJ0YCk7XG59XG5cbi8vIOS6pOaYk+mZkOWItlxuY29uc3QgdHJhZGVMaW1pdCA9IHtcbiAgICBoYXNCaW5kQ2FyZDogZmFsc2UsXG4gICAgaGFzQXV0aFJlYWxuYW1lOiBmYWxzZSxcbiAgICBoYXNCaW5kUGhvbmU6IGZhbHNlLFxuICAgIC8vIOaJi+WKqOWFs+mXreagh+iusFxuICAgIGNsb3NlT2ZmbGluZUJ5TWFudWFsOiBmYWxzZSxcbiAgICBjbG9zZVRyYWRlVGlwc0J5TWFudWFsOiBmYWxzZVxufVxuXG5jb25zdCBwcm9wZXJ0eURlZmluaXRpb25zID0ge1xuICAgIHRyYWRhYmxlOiBmYWxzZSxcbiAgICB0cmFkYWJsZVN3aXRjaEljb246IFwiQGRyYXdhYmxlL290Y19hZHZlcnRfZmlsdGVyX3N3aXRjaF9ub3JtYWxcIixcbiAgICBjcnlwdG9DdXJyZW5jeTogXCJVU0RUXCIsIC8vIOS6pOaYk+WvueaVsOWtl+W4gVxuICAgIGNyeXB0b0ljb246IFwiXCIsXG4gICAgYW1vdW50OiBcIlwiLCAvLyDph5Hpop3pmZDliLZcbiAgICBhbW91bnRUZXh0Q29sb3I6IFwiQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0XCIsXG4gICAgcGF5TWV0aG9kOiBcIlwiLCAvLyDmlK/ku5jmlrnlvI9cbiAgICBwYXlNZXRob2RUZXh0Q29sb3I6IFwiQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0XCIsXG4gICAgbW9yZUNvbmRpdGlvbjogXCJcIiwgLy8g5pu05aSa562b6YCJ6aG5XG4gICAgbW9yZUljb246IFwiQGRyYXdhYmxlL3RyYWRlX290Y19vcHRpb25hbF9pY29uX2ZpbHRlcl9ub2xcIixcbiAgICBkaXJlY3Rpb246IFwiYnV5XCIsIC8vIGJ1eS9zZWxsXG4gICAgY3VycmVuY3lOYW1lOiBcIlwiLFxuICAgIGJ1eVRhYlN0eWxlOiB7XG4gICAgICAgIHRleHRDb2xvcjogXCJAY29sb3Iva0NvbG9yUHJpbWFyeVRleHRcIixcbiAgICB9LFxuICAgIHNlbGxUYWJTdHlsZToge1xuICAgICAgICB0ZXh0Q29sb3I6IFwiQGNvbG9yL2tDb2xvclNlY29uZGFyeVRleHRcIixcbiAgICB9LFxufVxuXG5jb25zdCB7IG1vZHVsZURhdGEsIG1vZHVsZUV2ZW50IH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFxuICAgIFwicDJwRmlsdGVyXCIsXG4gICAgc3RhcnQsXG4gICAgZGVmYXVsdERhdGFcbik7XG5cbmNvbnN0IGRhdGFIZWxwZXIgPSB7fTtcblxuT2JqZWN0LmVudHJpZXMocHJvcGVydHlEZWZpbml0aW9ucykuZm9yRWFjaCgoW3Byb3AsIGRlZmF1bHRWYWx1ZV0pID0+IHtcbiAgICBPYmplY3QuZGVmaW5lUHJvcGVydHkoZGF0YUhlbHBlciwgcHJvcCwge1xuICAgICAgICBlbnVtZXJhYmxlOiB0cnVlLFxuICAgICAgICBjb25maWd1cmFibGU6IHRydWUsXG4gICAgICAgIGdldCgpIHtcbiAgICAgICAgICAgIGNvbnN0IHRhcmdldCA9IG1vZHVsZURhdGEuc2l0ZVR5cGUgPT09IFNpdGVUeXBlLk5PUk1BTFxuICAgICAgICAgICAgICAgID8gbW9kdWxlRGF0YS5ub3JtYWxcbiAgICAgICAgICAgICAgICA6IG1vZHVsZURhdGEuYnJhbmQ7XG4gICAgICAgICAgICByZXR1cm4gdGFyZ2V0W3Byb3BdID8/IGRlZmF1bHRWYWx1ZTsgLy8g5L2/55SoID8/IOaPkOS+m+m7mOiupOWAvFxuICAgICAgICB9LFxuICAgICAgICBzZXQodmFsdWUpIHtcbiAgICAgICAgICAgIGNvbnN0IHRhcmdldCA9IG1vZHVsZURhdGEuc2l0ZVR5cGUgPT09IFNpdGVUeXBlLk5PUk1BTFxuICAgICAgICAgICAgICAgID8gbW9kdWxlRGF0YS5ub3JtYWxcbiAgICAgICAgICAgICAgICA6IG1vZHVsZURhdGEuYnJhbmQ7XG4gICAgICAgICAgICB0YXJnZXRbcHJvcF0gPSB2YWx1ZTtcbiAgICAgICAgfVxuICAgIH0pO1xufVxuKVxuXG5mdW5jdGlvbiBkZWZhdWx0RGF0YSgpIHtcbiAgICByZXR1cm4ge1xuICAgICAgICBzaXRlVHlwZTogU2l0ZVR5cGUuQlJBTkQsIC8vIDDlk4HniYznq5nvvIwx5pmu6YCa56uZXG4gICAgICAgIG5vcm1hbDogeyAuLi5wcm9wZXJ0eURlZmluaXRpb25zIH0sXG4gICAgICAgIGJyYW5kOiB7IC4uLnByb3BlcnR5RGVmaW5pdGlvbnMgfSxcbiAgICAgICAgLy8g5biD5bGA55u45YWz5pi+56S6XG4gICAgICAgIG9mZmxpbmVUaXBzOiBcIlwiLCAvLyDnprvnur/mj5DnpLpcbiAgICAgICAgb2ZmbGluZVRpcHNWaXNpYmxlOiBcImdvbmVcIiwgLy8gdmlzaWJsZe+8muaYvuekujsgZ29uZe+8mumakOiXjzsgaW52aXNpYmxlOiDpmpDol4/kvYbmmK/kvJrljaDkvY1cbiAgICAgICAgdHJhZGVUaXBzVmlzaWJsZTogXCJnb25lXCIsXG4gICAgICAgIGJ1eVRyYWRlVGlwczogXCJcIixcbiAgICAgICAgc2VsbFRyYWRlVGlwczogXCJcIixcbiAgICAgICAgYnV5VHJhZGVUaXBzVmlzaWJsZTogXCJnb25lXCIsXG4gICAgICAgIHNlbGxUcmFkZVRpcHNWaXNpYmxlOiBcImdvbmVcIixcbiAgICAgICAgLy8gMe+8jOS5sO+8jDLvvIzljZbvvIzlhbbku5bvvIzlj6rmm7TmlrDlsZXnpLrnirbmgIFcbiAgICAgICAgdXBkYXRlVHJhZGVUaXBzKHR5cGUsIHRpcHMgPSBcIlwiKSB7XG4gICAgICAgICAgICBpZiAodHlwZSA9PSAxKSB7XG4gICAgICAgICAgICAgICAgdGhpcy5idXlUcmFkZVRpcHNWaXNpYmxlID0gdGlwcy5sZW5ndGggPiAwID8gXCJ2aXNpYmxlXCIgOiBcImdvbmVcIlxuICAgICAgICAgICAgICAgIHRoaXMuc2VsbFRyYWRlVGlwc1Zpc2libGUgPSBcImdvbmVcIlxuICAgICAgICAgICAgICAgIHRoaXMudHJhZGVUaXBzVmlzaWJsZSA9IHRpcHMubGVuZ3RoID4gMCA/IFwidmlzaWJsZVwiIDogXCJnb25lXCJcbiAgICAgICAgICAgICAgICAvLyDlj5jljJbkuobmiY3mm7TmlrDvvIzpgb/lhY3lr4zmlofmnKzlpJrmrKHlvILmraXmuLLmn5NcbiAgICAgICAgICAgICAgICBpZiAodGhpcy5idXlUcmFkZVRpcHMgIT09IHRpcHMpIHtcbiAgICAgICAgICAgICAgICAgICAgdGhpcy5idXlUcmFkZVRpcHMgPSB0aXBzXG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgfSBlbHNlIGlmICh0eXBlID09IDIpIHtcbiAgICAgICAgICAgICAgICB0aGlzLmJ1eVRyYWRlVGlwc1Zpc2libGUgPSBcImdvbmVcIlxuICAgICAgICAgICAgICAgIHRoaXMuc2VsbFRyYWRlVGlwc1Zpc2libGUgPSB0aXBzLmxlbmd0aCA+IDAgPyBcInZpc2libGVcIiA6IFwiZ29uZVwiXG4gICAgICAgICAgICAgICAgdGhpcy50cmFkZVRpcHNWaXNpYmxlID0gdGlwcy5sZW5ndGggPiAwID8gXCJ2aXNpYmxlXCIgOiBcImdvbmVcIlxuICAgICAgICAgICAgICAgIGlmICh0aGlzLnNlbGxUcmFkZVRpcHMgIT09IHRpcHMpIHtcbiAgICAgICAgICAgICAgICAgICAgdGhpcy5zZWxsVHJhZGVUaXBzID0gdGlwc1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgdGhpcy5idXlUcmFkZVRpcHNWaXNpYmxlID0gdGhpcy5idXlUcmFkZVRpcHMubGVuZ3RoID4gMCA/IFwidmlzaWJsZVwiIDogXCJnb25lXCJcbiAgICAgICAgICAgICAgICB0aGlzLnNlbGxUcmFkZVRpcHNWaXNpYmxlID0gdGhpcy5zZWxsVHJhZGVUaXBzLmxlbmd0aCA+IDAgPyBcInZpc2libGVcIiA6IFwiZ29uZVwiXG4gICAgICAgICAgICAgICAgdGhpcy50cmFkZVRpcHNWaXNpYmxlID0gKHRoaXMuYnV5VHJhZGVUaXBzLmxlbmd0aCA+IDAgfHwgdGhpcy5zZWxsVHJhZGVUaXBzLmxlbmd0aCA+IDApID4gMCA/IFwidmlzaWJsZVwiIDogXCJnb25lXCJcbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgIH1cbn1cblxubW9kdWxlRXZlbnQuY2xvc2VUaXBzV2l0aE1lcmNoYW50T2ZmbGluZSA9ICgpID0+IHtcbiAgICBtb2R1bGVEYXRhLm9mZmxpbmVUaXBzVmlzaWJsZSA9IFwiZ29uZVwiXG4gICAgdHJhZGVMaW1pdC5jbG9zZU9mZmxpbmVCeU1hbnVhbCA9IHRydWVcbn1cblxubW9kdWxlRXZlbnQuY2xvc2VUaXBzV2l0aFRyYWRlID0gKCkgPT4ge1xuICAgIG1vZHVsZURhdGEudHJhZGVUaXBzVmlzaWJsZSA9IFwiZ29uZVwiXG4gICAgdHJhZGVMaW1pdC5jbG9zZVRyYWRlVGlwc0J5TWFudWFsID0gdHJ1ZVxuICAgIC8v5Z+L54K5IC0g5Lqk5piT5o+Q56S65p2h5YWz6ZetXG4gICAgY29tbW9uLmFuYWx5dGljcyhtb2R1bGVEYXRhLnNpdGVUeXBlID09IFNpdGVUeXBlLkJSQU5EID8gXCJvdGNfcDJwX2FkbGlzdF9icmFuZFwiIDogXCJvdGNfcDJwX2FkbGlzdFwiLCB7XG4gICAgICAgIFwib3RjX3N0ZXBcIjogXCJvdGNfcDJwX25ld1VzZXJUaXBfY2xvc2VfY2xpY2tcIixcbiAgICAgICAgXCJzaWRlXCI6IGdldFRyYWRlVHlwZSgpLFxuICAgIH0pXG59XG5cbmV4cG9ydCBmdW5jdGlvbiB1cGRhdGVTdHlsZVdpdGhEaXJlY3Rpb24oZGlyZWN0aW9uKSB7XG4gICAgZGF0YUhlbHBlci5kaXJlY3Rpb24gPSBkaXJlY3Rpb25cbiAgICBsZXQgbm9ybWFsU3R5bGUgPSB7XG4gICAgICAgIHRleHRDb2xvcjogXCJAY29sb3Iva0NvbG9yU2Vjb25kYXJ5VGV4dFwiLFxuICAgIH1cbiAgICBsZXQgc2VsZWN0ZWRTdHlsZSA9IHtcbiAgICAgICAgdGV4dENvbG9yOiBcIkBjb2xvci9rQ29sb3JQcmltYXJ5VGV4dFwiLFxuICAgIH1cbiAgICBpZiAoZGlyZWN0aW9uID09IFwiYnV5XCIpIHtcbiAgICAgICAgZGF0YUhlbHBlci5idXlUYWJTdHlsZSA9IHNlbGVjdGVkU3R5bGVcbiAgICAgICAgZGF0YUhlbHBlci5zZWxsVGFiU3R5bGUgPSBub3JtYWxTdHlsZVxuICAgIH0gZWxzZSBpZiAoZGlyZWN0aW9uID09IFwic2VsbFwiKSB7XG4gICAgICAgIGRhdGFIZWxwZXIuYnV5VGFiU3R5bGUgPSBub3JtYWxTdHlsZVxuICAgICAgICBkYXRhSGVscGVyLnNlbGxUYWJTdHlsZSA9IHNlbGVjdGVkU3R5bGVcbiAgICB9XG5cbiAgICBjaGVja1RyYWRlTGltaXQoKVxufVxuXG5mdW5jdGlvbiByZXNldERhdGFTZXJ2aWNlU2VsZWN0aW9uKCkge1xuICAgIGRhdGFTZXJ2aWNlLnJlc2V0TGFiZWxJZChjb25maWcuY3VycmVudFNpdGVUeXBlKVxuICAgIGlmIChjb25maWcuY3VycmVudFNpdGVUeXBlID09IFNpdGVUeXBlLk5PUk1BTCkge1xuICAgICAgICBkYXRhU2VydmljZS5yZXNldE1lcmNoYW50VGFncyhTaXRlVHlwZS5OT1JNQUwpXG4gICAgfVxufVxuXG5tb2R1bGVFdmVudC5jbGlja0ZpbHRlck9wdGlvbldpdGhEaXJlY3Rpb24gPSBhc3luYyAoZGlyZWN0aW9uKSA9PiB7XG4gICAgaWYgKGRhdGFIZWxwZXIuZGlyZWN0aW9uID09IGRpcmVjdGlvbikge1xuICAgICAgICByZXR1cm5cbiAgICB9XG4gICAgdXBkYXRlU3R5bGVXaXRoRGlyZWN0aW9uKGRpcmVjdGlvbilcbiAgICAvLyDliIfmjaLmlrnlkJHlkI7pnIDopoHph43nva7mtLvliqjmoIfnrb7pgInmi6npobnjgIHok53nm77lm77moIdcbiAgICByZXNldERhdGFTZXJ2aWNlU2VsZWN0aW9uKClcblxuICAgICRuYXRpdmVBUEkucDJwRmlsdGVyQnJpZGdlKHsgYWN0aW9uOiBcIm9uRmlsdGVyT3B0aW9uV2l0aERpcmVjdGlvblwiLCBwYXJhbXM6IGRpcmVjdGlvbiB9KVxuICAgIC8vIOabtOaWsOWIl+ihqFxuICAgICRldmVudC5yZWZyZXNoQWR2ZXJ0TGlzdFdpdGhUcmFkZVR5cGUoZGlyZWN0aW9uKVxuICAgIC8vIOetm+mAiemdouadv+abtOWkmuaMiemSrueKtuaAgeabtOaWsFxuICAgIHVwZGF0ZU1vcmVTZWxlY3Rpb25TdHlsZShkYXRhU2VydmljZS5oYXNTZWxlY3RlZE1vcmUoY29uZmlnLmN1cnJlbnRTaXRlVHlwZSkpXG5cbiAgICAvLyDln4vngrkt5YiH5o2i6LSt5Lmw5ZKM5Ye65ZSuXG4gICAgY29tbW9uLmFuYWx5dGljcyhtb2R1bGVEYXRhLnNpdGVUeXBlID09IFNpdGVUeXBlLkJSQU5EID8gXCJvdGNfcDJwX2FkbGlzdF9icmFuZFwiIDogXCJvdGNfcDJwX2FkbGlzdFwiLCB7XG4gICAgICAgIFwib3RjX3N0ZXBcIjogXCJjbGlja19idXlzZWxsXCIsXG4gICAgICAgIFwic3BtXCI6IGRpcmVjdGlvbiA9PSBcImJ1eVwiID8gXCJvdGMuYWRsaXN0LnBhZ2UuY2hhbmdlX2J1eVwiIDogXCJvdGMuYWRsaXN0LnBhZ2UuY2hhbmdlX3NlbGxcIixcbiAgICAgICAgXCJjb2luX25hbWVcIjogY29uZmlnLnRhcmdldC5jb2luTmFtZSxcbiAgICAgICAgXCJzaWRlXCI6IGRpcmVjdGlvbixcbiAgICB9KVxufVxuXG5tb2R1bGVFdmVudC5jbGlja0ZpbHRlck9wdGlvbldpdGhDcnlwdG9DdXJyZW5jeSA9ICgpID0+IHtcbiAgICAkbmF0aXZlQVBJLnAycEZpbHRlckJyaWRnZSh7XG4gICAgICAgIGFjdGlvbjogXCJvbkZpbHRlck9wdGlvbldpdGhDcnlwdG9DdXJyZW5jeVwiLFxuICAgICAgICBwYXJhbXM6IFwiXCJcbiAgICB9KVxufVxuXG5tb2R1bGVFdmVudC5jbGlja0ZpbHRlck9wdGlvbldpdGhBbW91bnQgPSAoKSA9PiB7XG4gICAgJG5hdGl2ZUFQSS5wMnBGaWx0ZXJCcmlkZ2Uoe1xuICAgICAgICBhY3Rpb246IFwib25GaWx0ZXJPcHRpb25XaXRoQW1vdW50XCIsXG4gICAgfSlcbn1cblxubW9kdWxlRXZlbnQuY2xpY2tGaWx0ZXJPcHRpb25XaXRoUGF5TWVob2QgPSAoKSA9PiB7XG4gICAgJG5hdGl2ZUFQSS5wMnBGaWx0ZXJCcmlkZ2Uoe1xuICAgICAgICBhY3Rpb246IFwib25GaWx0ZXJPcHRpb25XaXRoUGF5TWVob2RcIixcbiAgICB9KVxufVxuXG5tb2R1bGVFdmVudC5jbGlja0ZpbHRlck9wdGlvbldpdGhUcmFkYWJsZSA9IGFzeW5jICgpID0+IHtcbiAgICBkYXRhSGVscGVyLnRyYWRhYmxlID0gIWRhdGFIZWxwZXIudHJhZGFibGVcbiAgICBkYXRhSGVscGVyLnRyYWRhYmxlU3dpdGNoSWNvbiA9IGRhdGFIZWxwZXIudHJhZGFibGUgPyBcIkBkcmF3YWJsZS9vdGNfYWR2ZXJ0X2ZpbHRlcl9zd2l0Y2hfc2VsZWN0XCIgOiBcIkBkcmF3YWJsZS9vdGNfYWR2ZXJ0X2ZpbHRlcl9zd2l0Y2hfbm9ybWFsXCJcbiAgICAkZXZlbnQucmVmcmVzaEFkdmVydExpc3RXaXRoVHJhZGFibGUoZGF0YUhlbHBlci50cmFkYWJsZSlcblxuICAgIC8v5Z+L54K5IC0g5Y+v5Lqk5piTXG4gICAgY29tbW9uLmFuYWx5dGljcyhtb2R1bGVEYXRhLnNpdGVUeXBlID09IFNpdGVUeXBlLkJSQU5EID8gXCJvdGNfcDJwX2FkbGlzdF9icmFuZFwiIDogXCJvdGNfcDJwX2FkbGlzdFwiLCB7XG4gICAgICAgIFwib3RjX3N0ZXBcIjogXCJvdGNfcDJwX2F2YWxpYWJsZVN3dGNoX2NsaWNrXCIsXG4gICAgICAgIFwib3BlblwiOiBkYXRhSGVscGVyLnRyYWRhYmxlLFxuICAgICAgICBcInNpZGVcIjogZ2V0VHJhZGVUeXBlKCksXG4gICAgfSlcbn1cblxubW9kdWxlRXZlbnQuY2xpY2tGaWx0ZXJPcHRpb25XaXRoTW9yZSA9ICgpID0+IHtcbiAgICAkbmF0aXZlQVBJLnAycEZpbHRlckJyaWRnZSh7XG4gICAgICAgIGFjdGlvbjogXCJvbkZpbHRlck9wdGlvbldpdGhNb3JlXCIsXG4gICAgfSlcblxuICAgIC8v5Z+L54K5IC0g562b6YCJ5oyJ6ZKu54K55Ye7XG4gICAgY29tbW9uLmFuYWx5dGljcyhtb2R1bGVEYXRhLnNpdGVUeXBlID09IFNpdGVUeXBlLkJSQU5EID8gXCJvdGNfcDJwX2FkbGlzdF9icmFuZFwiIDogXCJvdGNfcDJwX2FkbGlzdFwiLCB7XG4gICAgICAgIFwib3RjX3N0ZXBcIjogXCJvdGNfdHJhZGVfbWVyY2hhbnRfZmlsdGVyX2NsaWNrXCIsXG4gICAgICAgIFwiY29pbl9uYW1lXCI6IGNvbmZpZy50YXJnZXQuY29pbk5hbWUsXG4gICAgICAgIFwic2lkZVwiOiBnZXRUcmFkZVR5cGUoKSxcbiAgICB9KVxufVxuXG5mdW5jdGlvbiB1cGRhdGVNb3JlU2VsZWN0aW9uU3R5bGUoaGFzU2VsZWN0ZWRNb3JlKSB7XG4gICAgZGF0YUhlbHBlci5tb3JlSWNvbiA9IGhhc1NlbGVjdGVkTW9yZSA/IFwiQGRyYXdhYmxlL3RyYWRlX290Y19vcHRpb25hbF9pY29uX2ZpbHRlcl9zZWxcIiA6IFwiQGRyYXdhYmxlL3RyYWRlX290Y19vcHRpb25hbF9pY29uX2ZpbHRlcl9ub2xcIlxufVxuXG5leHBvcnQgZnVuY3Rpb24gdXBkYXRlU3R5bGUoYWR2ZXJ0UmVxdWVzdFBhcmFtcywgY29pbk5hbWUpIHtcbiAgICB0aGlzLnVwZGF0ZVN0eWxlV2l0aFRyYWRpbmdQYWlycyhjb2luTmFtZSwgYWR2ZXJ0UmVxdWVzdFBhcmFtcy5jdXJyZW5jeU5hbWUpXG4gICAgZGF0YUhlbHBlci5hbW91bnQgPSBhZHZlcnRSZXF1ZXN0UGFyYW1zLmFtb3VudCAhPSB1bmRlZmluZWQgPyBhZHZlcnRSZXF1ZXN0UGFyYW1zLmFtb3VudCA6IGRhdGFIZWxwZXIuYW1vdW50XG4gICAgZGF0YUhlbHBlci5hbW91bnRUZXh0Q29sb3IgPSBkYXRhSGVscGVyLmFtb3VudC50cmltKCkubGVuZ3RoID09PSAwID8gXCJAY29sb3Iva0NvbG9yUHJpbWFyeVRleHRcIiA6IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIlxuICAgIHVwZGF0ZU1vcmVTZWxlY3Rpb25TdHlsZShhZHZlcnRSZXF1ZXN0UGFyYW1zLnNlbGVjdGVkTW9yZSlcbiAgICAvLyDmlK/ku5jmlrnlvI9cbiAgICBpZiAoYWR2ZXJ0UmVxdWVzdFBhcmFtcy5wYXlNZXRob2QgPT0gdW5kZWZpbmVkKSB7XG4gICAgICAgIHZhciBzZWxlY3RlZFBheW1ldGhvZCA9IGRhdGFIZWxwZXIucGF5TWV0aG9kICYmIGRhdGFIZWxwZXIucGF5TWV0aG9kICE9PSBcIjBcIiAmJiBhZHZlcnRSZXF1ZXN0UGFyYW1zLnBheU1ldGhvZCAhPT0gMFxuICAgICAgICBkYXRhSGVscGVyLnBheU1ldGhvZFRleHRDb2xvciA9IHNlbGVjdGVkUGF5bWV0aG9kID8gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiIDogXCJAY29sb3Iva0NvbG9yUHJpbWFyeVRleHRcIlxuICAgIH0gZWxzZSB7XG4gICAgICAgIHZhciBzZWxlY3RlZFBheW1ldGhvZCA9IGFkdmVydFJlcXVlc3RQYXJhbXMucGF5TWV0aG9kICYmIGFkdmVydFJlcXVlc3RQYXJhbXMucGF5TWV0aG9kICE9PSBcIjBcIlxuICAgICAgICBkYXRhSGVscGVyLnBheU1ldGhvZCA9IHNlbGVjdGVkUGF5bWV0aG9kID8gYWR2ZXJ0UmVxdWVzdFBhcmFtcy5wYXlNZXRob2QgOiBcIjBcIlxuICAgICAgICBkYXRhSGVscGVyLnBheU1ldGhvZFRleHRDb2xvciA9IHNlbGVjdGVkUGF5bWV0aG9kID8gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiIDogXCJAY29sb3Iva0NvbG9yUHJpbWFyeVRleHRcIlxuICAgIH1cblxufVxuXG5leHBvcnQgZnVuY3Rpb24gdXBkYXRlU3R5bGVXaXRoVHJhZGluZ1BhaXJzKGNvaW5OYW1lLCBjdXJyZW5jeU5hbWUsIHNpdGVUeXBlKSB7XG4gICAgY29uc3QgdGFyZ2V0ID0gc2l0ZVR5cGUgIT0gdW5kZWZpbmVkID8gKHNpdGVUeXBlID09IFNpdGVUeXBlLkJSQU5EID8gbW9kdWxlRGF0YS5icmFuZCA6IG1vZHVsZURhdGEubm9ybWFsKSA6IGRhdGFIZWxwZXJcbiAgICBpZiAoY29pbk5hbWUgIT0gdW5kZWZpbmVkKSB7XG4gICAgICAgIHRhcmdldC5jcnlwdG9DdXJyZW5jeSA9IGNvaW5OYW1lLnRvVXBwZXJDYXNlKClcbiAgICAgICAgLy8gZGF0YUhlbHBlci5jcnlwdG9JY29uID0gYGh0dHBzOi8vd3d3Lmdsb2JhbC1iYXNlLnRjLWpwMS5odW9iaWFwcHMuY29tLy0veC9oYi9wL2FwaS9jb250ZW50cy9jdXJyZW5jeS9pY29uX3BuZy8ke2RhdGFIZWxwZXIuY3J5cHRvQ3VycmVuY3kudG9Mb3dlckNhc2UoKX0ucG5nYFxuICAgICAgICB0YXJnZXQuY3J5cHRvSWNvbiA9IGNvbW1vbi5nZXRJY29uVVJMKGNvaW5OYW1lKVxuICAgIH1cbiAgICBpZiAoY3VycmVuY3lOYW1lICE9IHVuZGVmaW5lZCkge1xuICAgICAgICB0YXJnZXQuY3VycmVuY3lOYW1lID0gY3VycmVuY3lOYW1lXG4gICAgfVxufVxuXG4vLyDlj5HluIPlub/lkYrnprvnur/lsZXnpLpcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBjaGVja0FkdmVydFB1c2hsaXNoU3RhdHVzKCkge1xuICAgIGlmICh0cmFkZUxpbWl0LmNsb3NlT2ZmbGluZUJ5TWFudWFsKSB7XG4gICAgICAgIHJldHVyblxuICAgIH1cbiAgICB2YXIgcmVwb3MgPSBhd2FpdCBQcm9taXNlLmFsbChbXG4gICAgICAgIGNvbW1vbi5zZW5kUmVxdWVzdChcIi92MS91c2VyL25vdGljZS9zd2l0Y2hcIiksXG4gICAgICAgIGNvbW1vbi5zZW5kUmVxdWVzdChcIi92MS9kYXRhL3RyYWRlLWxpc3QvYXBwXCIsIHtcbiAgICAgICAgICAgIFwiY3VyclBhZ2VcIjogMCxcbiAgICAgICAgICAgIFwic2VhVmlld1Jvb21cIjogMFxuICAgICAgICB9KSxcbiAgICBdKVxuICAgIHZhciBvbmxpbmUgPSByZXBvc1swXS5kYXRhLmFwcF9hZHZlcnQ7XG4gICAgdmFyIGhhc0FkdmVydCA9IHJlcG9zWzFdLmRhdGEubGVuZ3RoID4gMDtcbiAgICB2YXIgc2hvd1RpcHMgPSAhKG9ubGluZSAmJiBoYXNBZHZlcnQpXG4gICAgbW9kdWxlRGF0YS5vZmZsaW5lVGlwc1Zpc2libGUgPSBzaG93VGlwcyA/IFwidmlzaWJsZVwiIDogXCJnb25lXCJcbiAgICBpZiAoc2hvd1RpcHMpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5vZmZsaW5lVGlwcyA9IGdldENsaWNrQ29udGVudCgkaTE4bi5uX290Y19hZHZlcnRfb3B0X2FkX21ha2VyX3N0YXRlX3RpcCwgJGkxOG4ubl9vdGNfYWR2ZXJ0X29wdF9idXR0b25fdGV4dF90b19hZHZlcnQsIFwiQGV2ZW50LnAycEZpbHRlci5vblN3aXRjaFBhZ2UoJ3RvU2V0QWR2ZXJ0cycpXCIpXG4gICAgfSBlbHNlIHtcbiAgICAgICAgbW9kdWxlRGF0YS5vZmZsaW5lVGlwcyA9ICcnXG4gICAgfVxufVxuXG5mdW5jdGlvbiBnZXRDbGlja0NvbnRlbnQoY29udGVudCwgY2xpY2tUZXh0LCBhY3Rpb25EZXNjKSB7XG4gICAgY29uc3QgY29sb3IgPSBjb21tb24uY29tbWFuRGF0YS5jb2xvck1vZGUgPT0gMCA/IFwiIzAwMDAwMFwiIDogXCIjRTZFNkU2XCI7XG4gICAgbGV0IGRlc2MgPSBgPHNwYW4gc3R5bGU9XCJmb250LXNpemU6MTJweDsgZm9udC13ZWlnaHQ9MjAwOyBjb2xvcjoke2NvbG9yfTtcIj4ke2NvbnRlbnR9PC9zcGFuPmA7IC8vXG4gICAgbGV0IHRvU2V0dGluZ3NUZXh0ID0gYDxzcGFuIHN0eWxlPVwiZm9udC1zaXplOjEycHg7IGZvbnQtd2VpZ2h0PTIwMDsgY29sb3I6QGNvbG9yL2Jhc2VDb2xvck1ham9yVGhlbWUxMDA7XCI+JHtjbGlja1RleHR9PC9zcGFuPmA7IC8vXG4gICAgcmV0dXJuIGAke2Rlc2N9PGEgaHJlZj0ke2FjdGlvbkRlc2N9PiR7dG9TZXR0aW5nc1RleHR9PC9hPmA7XG59XG5cbmZ1bmN0aW9uIG9uU3dpdGNoUGFnZSh0YXJnZXQsIHBhcmFtcyA9ICcnKSB7XG4gICAgc3dpdGNoICh0YXJnZXQpIHtcbiAgICAgICAgY2FzZSAndG9TZXRBZHZlcnRzJzpcbiAgICAgICAgICAgICRuYXRpdmVBUEkucDJwRmlsdGVyQnJpZGdlKHtcbiAgICAgICAgICAgICAgICBhY3Rpb246IFwib25Td2l0Y2hQYWdlXCIsXG4gICAgICAgICAgICAgICAgcGFyYW1zOiB7XG4gICAgICAgICAgICAgICAgICAgIHRhcmdldCxcbiAgICAgICAgICAgICAgICAgICAgcGFyYW1zXG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgfSlcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBkZWZhdWx0OlxuICAgICAgICAgICAgY29tbW9uLm9wZW5VUkwodGFyZ2V0KVxuICAgICAgICAgICAgYnJlYWs7XG4gICAgfVxufVxuXG5tb2R1bGVFdmVudC50b0t5Y0F1dGhlbnRpY2F0aW9uID0gZnVuY3Rpb24gKCkge1xuICAgIG9uU3dpdGNoUGFnZSgnaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9hY2NvdW50L2t5Yz9hdXRoQml6Q29kZT1PVEMnKVxuICAgIGNvbW1vbi5hbmFseXRpY3MobW9kdWxlRGF0YS5zaXRlVHlwZSA9PSBTaXRlVHlwZS5CUkFORCA/IFwib3RjX3AycF9hZGxpc3RfYnJhbmRcIiA6IFwib3RjX3AycF9hZGxpc3RcIiwge1xuICAgICAgICBcIm90Y19zdGVwXCI6IFwib3RjX3AycF9wcm9ncmVzc19reWNcIixcbiAgICB9KVxufVxuXG5tb2R1bGVFdmVudC50b0JpbmRQaG9uZSA9IGZ1bmN0aW9uICgpIHtcbiAgICAvLyDnu5HlrprmiYvmnLpcbiAgICBpZiAoY29tbW9uLmNvbW1hbkRhdGEuT1MgPT0gMCkge1xuICAgICAgICBjb21tb24ub3BlblVSTChcImhvbGlnZWl0Oi8vb3Blbi92MT9sb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vc2VjdXJpdHlDZW50ZXIvYmluZFBob25lXCIpXG4gICAgfSBlbHNlIHtcbiAgICAgICAgLy/nu5HlrprmiYvmnLpcbiAgICAgICAgJG5hdGl2ZUFQSS5wMnBGaWx0ZXJCcmlkZ2Uoe1xuICAgICAgICAgICAgYWN0aW9uOiBcIm9uU3dpdGNoUGFnZVwiLFxuICAgICAgICAgICAgcGFyYW1zOiB7XG4gICAgICAgICAgICAgICAgdGFyZ2V0OiBcInRvQmluZFBob25lXCIsXG4gICAgICAgICAgICB9XG4gICAgICAgIH0pXG4gICAgfVxuICAgIGNvbW1vbi5hbmFseXRpY3MobW9kdWxlRGF0YS5zaXRlVHlwZSA9PSBTaXRlVHlwZS5CUkFORCA/IFwib3RjX3AycF9hZGxpc3RfYnJhbmRcIiA6IFwib3RjX3AycF9hZGxpc3RcIiwge1xuICAgICAgICBcIm90Y19zdGVwXCI6IFwib3RjX3AycF9wcm9ncmVzc190cmFkaW5nc2V0dGluZ1wiLFxuICAgIH0pXG59XG5cbm1vZHVsZUV2ZW50LnRvQWRkUGF5bWVudCA9IGFzeW5jIGZ1bmN0aW9uICgpIHtcbiAgICB2YXIgcmVwb3MgPSBhd2FpdCBQcm9taXNlLmFsbChbXG4gICAgICAgIGNvbW1vbi5zZW5kUmVxdWVzdCgnL3YxL3VzZXIvaW5mbycpLFxuICAgICAgICBjb21tb24uc2VuZFJlcXVlc3QoJy92MS91c2VyL3N5c3RlbS9zZXR0aW5nL2tleScsIHsga2V5OiBcImRvd25ncmFkZUZ1bmRQYXNzd29yZFwiIH0pXG4gICAgXSlcbiAgICBjb25zdCB7IGlzVHJhZGVCaW5kLCB2ZXJpZnlXYXlIYXZlU2V0IH0gPSByZXBvc1swXS5kYXRhXG4gICAgY29uc3QgeyBkb3duZ3JhZGVGdW5kUGFzc3dvcmQgfSA9IHJlcG9zWzFdLmRhdGFcbiAgICBjb25zb2xlLmxvZyhgZG93bmdyYWRlRnVuZFBhc3N3b3JkID09PT09PT09PSAke2Rvd25ncmFkZX1gKVxuICAgIHZhciBkb3duZ3JhZGUgPSBmYWxzZTtcbiAgICBpZiAoZG93bmdyYWRlRnVuZFBhc3N3b3JkIGluc3RhbmNlb2YgQm9vbGVhbikge1xuICAgICAgICBkb3duZ3JhZGUgPSBkb3duZ3JhZGVGdW5kUGFzc3dvcmRcbiAgICB9XG4gICAgaWYgKGRvd25ncmFkZSkge1xuICAgICAgICBpZiAoaXNUcmFkZUJpbmQpIHtcbiAgICAgICAgICAgIC8vIOi3s+i9rOWIsOaUtuasvuaWueW8j+mhtemdolxuICAgICAgICAgICAgb25Td2l0Y2hQYWdlKFwiaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9vdGMvcGF5bWVudExpc3RcIilcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIC8vIOayoeaciee7keWumui1hOmHkeWvhuegge+8jOWFiOWOu+e7keWumui1hOmHkeWvhueggVxuICAgICAgICAgICAgb25Td2l0Y2hQYWdlKFwiaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9zZWN1cml0eUNlbnRlci9zZXRGdW5kUGFzc3dvcmQ/d2lsbFZlcmlmaWNhdGlvbj1mYWxzZVwiKVxuICAgICAgICB9XG4gICAgfSBlbHNlIHtcbiAgICAgICAgaWYgKHZlcmlmeVdheUhhdmVTZXQpIHtcbiAgICAgICAgICAgIC8vIOi3s+i9rOWIsOaUtuasvuaWueW8j+mhtemdolxuICAgICAgICAgICAgb25Td2l0Y2hQYWdlKFwiaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9vdGMvcGF5bWVudExpc3RcIilcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIC8v5YmN5b6A5Lqk5piT6K6+572uXG4gICAgICAgICAgICBvblN3aXRjaFBhZ2UoXCJob2xpZ2VpdDovL29wZW4vdjE/bG9naW49MSZ1cmw9aWh1b2JpZ2xvYmFsOi8vbS5oYmcuY29tL290Yy90cmFkZS9wMlBUcmFkaW5nTGVhZGluZ1wiKVxuICAgICAgICB9XG4gICAgfVxuXG4gICAgLy8g5Z+L54K5IC0g5re75Yqg5pSv5LuY5pa55byPXG4gICAgY29tbW9uLmFuYWx5dGljcyhtb2R1bGVEYXRhLnNpdGVUeXBlID09IFNpdGVUeXBlLkJSQU5EID8gXCJvdGNfcDJwX2FkbGlzdF9icmFuZFwiIDogXCJvdGNfcDJwX2FkbGlzdFwiLCB7XG4gICAgICAgIFwib3RjX3N0ZXBcIjogXCJvdGNfcDJwX3Byb2dyZXNzX2FkZHBheW1lbnRcIixcbiAgICB9KVxufVxuXG4vLyDnrZvpgInmnaHku7bms5XluIFcbm1vZHVsZUV2ZW50LmNsaWNrRmlsdGVyT3B0aW9uV2l0aEN1cnJlbmN5ID0gZnVuY3Rpb24gKHNpdGVUeXBlKSB7XG4gICAgY29uc29sZS5sb2coYGNsaWNrRmlsdGVyT3B0aW9uV2l0aEN1cnJlbmN5ID09PSAke3NpdGVUeXBlfWApXG4gICAgJG5hdGl2ZUFQSS5wMnBGaWx0ZXJCcmlkZ2Uoe1xuICAgICAgICBhY3Rpb246IFwib25GaWx0ZXJPcHRpb25XaXRoQ3VycmVuY3lcIixcbiAgICB9KVxufVxuXG5cbi8vIOS6pOaYk+mZkOWItuaPkOekulxuYXN5bmMgZnVuY3Rpb24gY2hlY2tUcmFkZUxpbWl0KCkge1xuICAgIGlmICh0cmFkZUxpbWl0LmNsb3NlVHJhZGVUaXBzQnlNYW51YWwpIHtcbiAgICAgICAgcmV0dXJuXG4gICAgfVxuICAgIHZhciBnZXRUcmFkZUxpbWl0VGlwc1dpdGhSZWFsbmFtZSA9IGFzeW5jIGZ1bmN0aW9uICgpIHtcbiAgICAgICAgaWYgKCF0cmFkZUxpbWl0Lmhhc0F1dGhSZWFsbmFtZSkge1xuICAgICAgICAgICAgdmFyIHJlcyA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdChcIi92MS91c2VyL2t5Y1wiKSAvL2F1dGhMZXZlbCA+PSAyXG4gICAgICAgICAgICB0cmFkZUxpbWl0Lmhhc0F1dGhSZWFsbmFtZSA9IHJlcy5kYXRhLmF1dGhMZXZlbCA+PSAyXG4gICAgICAgICAgICBpZiAoIXRyYWRlTGltaXQuaGFzQXV0aFJlYWxuYW1lKSB7XG4gICAgICAgICAgICAgICAgcmV0dXJuIGdldENsaWNrQ29udGVudCgkaTE4bi5uX290Y19ndWlkZV90aXBzX3JlYWxfbmFtZSwgJGkxOG4ubl9vdGNfZ29fdmVyaWZpY2F0aW9uLCBcIkBldmVudC5wMnBGaWx0ZXIudG9LeWNBdXRoZW50aWNhdGlvbigpXCIpXG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgIHJldHVybiBcIlwiXG4gICAgICAgICAgICB9XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICByZXR1cm4gXCJcIlxuICAgICAgICB9XG4gICAgfVxuICAgIC8vIOS5sOaWueWQkSDlhYjlrp7lkI3lkI7miYvmnLrlj7dcbiAgICBpZiAoZGF0YUhlbHBlci5kaXJlY3Rpb24gPT0gXCJidXlcIikge1xuICAgICAgICB2YXIgdGlwcyA9IGF3YWl0IGdldFRyYWRlTGltaXRUaXBzV2l0aFJlYWxuYW1lKClcbiAgICAgICAgaWYgKHRpcHMubGVuZ3RoID09IDApIHtcbiAgICAgICAgICAgIGlmICghdHJhZGVMaW1pdC5oYXNCaW5kUGhvbmUpIHtcbiAgICAgICAgICAgICAgICB2YXIgdmVyaWZ5UmVzID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KFwiL3YxL3VzZXIvdmVyaWZ5L3dheXNcIikgLy8gdWNQaG9uZVN0YXR1cyAhPSAxIFxuICAgICAgICAgICAgICAgIHRyYWRlTGltaXQuaGFzQmluZFBob25lID0gdmVyaWZ5UmVzLmRhdGEudWNQaG9uZVN0YXR1cyAhPSAxXG4gICAgICAgICAgICAgICAgaWYgKCF0cmFkZUxpbWl0Lmhhc0JpbmRQaG9uZSkge1xuICAgICAgICAgICAgICAgICAgICB0aXBzID0gZ2V0Q2xpY2tDb250ZW50KCRpMThuLm5fb3RjX2d1aWRlX3RpcHNfYmluZF9waG9uZSwgJGkxOG4ubl9vdGNfYWR2ZXJ0X3RyYWRlX3AycF9uZXdfdXNlcl9iaW5kX3Bob25lLCBcIkBldmVudC5wMnBGaWx0ZXIudG9CaW5kUGhvbmUoKVwiKVxuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgICAgICBtb2R1bGVEYXRhLnVwZGF0ZVRyYWRlVGlwcygxLCB0aXBzKVxuICAgIH0gZWxzZSB7XG4gICAgICAgIC8vIOWNluaWueWQkSDlhYjnu5HljaHlkI7lrp7lkI1cbiAgICAgICAgdmFyIHRpcHMgPSBcIlwiXG4gICAgICAgIGlmICghdHJhZGVMaW1pdC5oYXNCaW5kQ2FyZCkge1xuICAgICAgICAgICAgdmFyIGFjY291bnRSZXMgPSBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3QoXCIvdjEvdXNlci9yZWNlaXB0LWFjY291bnRcIikgLy8gZGF0YSA+IDBcbiAgICAgICAgICAgIHRyYWRlTGltaXQuaGFzQmluZENhcmQgPSBhY2NvdW50UmVzLmRhdGEubGVuZ3RoID4gMFxuICAgICAgICAgICAgaWYgKCF0cmFkZUxpbWl0Lmhhc0JpbmRDYXJkKSB7XG4gICAgICAgICAgICAgICAgdGlwcyA9IGdldENsaWNrQ29udGVudCgkaTE4bi5uX290Y19ndWlkZV90aXBzX2FkZF9wYXlfbWV0aG9kLCAkaTE4bi5uX290Y19hZHZlcnRfdHJhZGVfcDJwX25ld191c2VyX2dvX2FkZF9wYXlNZXRob2QsIFwiQGV2ZW50LnAycEZpbHRlci50b0FkZFBheW1lbnQoKVwiKVxuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICB0aXBzID0gYXdhaXQgZ2V0VHJhZGVMaW1pdFRpcHNXaXRoUmVhbG5hbWUoKVxuICAgICAgICAgICAgfVxuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgdGlwcyA9IGF3YWl0IGdldFRyYWRlTGltaXRUaXBzV2l0aFJlYWxuYW1lKClcbiAgICAgICAgfVxuICAgICAgICBtb2R1bGVEYXRhLnVwZGF0ZVRyYWRlVGlwcygyLCB0aXBzKVxuICAgIH1cbiAgICB2YXIgc2hvd1RpcHMgPSBtb2R1bGVEYXRhLmJ1eVRyYWRlVGlwcy5sZW5ndGggPiAwIHx8IG1vZHVsZURhdGEuc2VsbFRyYWRlVGlwcy5sZW5ndGggPiAwXG4gICAgLy8g5Z+L54K5IC0g5Lmw5Y2W5pa55ZCR5byV5a+85p2h5pud5YWJXG4gICAgaWYgKHNob3dUaXBzKSB7XG4gICAgICAgIGNvbW1vbi5hbmFseXRpY3MobW9kdWxlRGF0YS5zaXRlVHlwZSA9PSBTaXRlVHlwZS5CUkFORCA/IFwib3RjX3AycF9hZGxpc3RfYnJhbmRcIiA6IFwib3RjX3AycF9hZGxpc3RcIiwge1xuICAgICAgICAgICAgXCJvdGNfc3RlcFwiOiBkYXRhSGVscGVyLmRpcmVjdGlvbiA9PSBcImJ1eVwiID8gXCJvdGNfcDJwX3Byb2dyZXNzX2J1eVwiIDogXCJvdGNfcDJwX3Byb2dyZXNzX3NlbGxcIixcbiAgICAgICAgfSlcbiAgICB9XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBsb2FkVHJhZGVUaXBzSW5mbygpIHtcbiAgICBjaGVja1RyYWRlTGltaXQoKVxuICAgIGlmIChjb25maWcuaXNBZHZlcnRNb2RlID09IHRydWUpIHtcbiAgICAgICAgY2hlY2tBZHZlcnRQdXNobGlzaFN0YXR1cygpXG4gICAgfSBlbHNlIHtcbiAgICAgICAgbW9kdWxlRGF0YS5vZmZsaW5lVGlwc1Zpc2libGUgPSBcImdvbmVcIlxuICAgIH1cbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGNoYW5nZVNpdGUodG8pIHtcbiAgICBtb2R1bGVEYXRhLnNpdGVUeXBlID0gdG9cbiAgICAvLyDlpoLmnpzmnKrorr7nva7lm77niYdpY29uXG4gICAgaWYgKGRhdGFIZWxwZXIuY3J5cHRvSWNvbiA9PSBcIlwiKSB7XG4gICAgICAgIGRhdGFIZWxwZXIuY3J5cHRvSWNvbiA9IGNvbW1vbi5nZXRJY29uVVJMKGRhdGFIZWxwZXIuY3J5cHRvQ3VycmVuY3kpXG4gICAgfVxuICAgIGxvYWRUcmFkZVRpcHNJbmZvKCk7XG4gICAgLy/ln4vngrkgLSDnq5nngrnliIfmjaJcbiAgICBjb21tb24uYW5hbHl0aWNzKG1vZHVsZURhdGEuc2l0ZVR5cGUgPT0gU2l0ZVR5cGUuQlJBTkQgPyBcIm90Y19wMnBfYWRsaXN0X2JyYW5kXCIgOiBcIm90Y19wMnBfYWRsaXN0XCIsIHtcbiAgICAgICAgXCJvdGNfc3RlcFwiOiBcInN3aXRjaFwiLFxuICAgIH0pXG59XG5cbmV4cG9ydCBmdW5jdGlvbiBnZXRUcmFkZVR5cGUoKSB7XG4gICAgcmV0dXJuIGRhdGFIZWxwZXIuZGlyZWN0aW9uO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gZ2V0QW1vdW50KCkge1xuICAgIHJldHVybiBkYXRhSGVscGVyLmFtb3VudDtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGdldFBheW1lbnQoKSB7XG4gICAgcmV0dXJuIGRhdGFIZWxwZXIucGF5TWV0aG9kO1xufVxuXG5tb2R1bGVFdmVudC5vblN3aXRjaFBhZ2UgPSBvblN3aXRjaFBhZ2UiLCJpbXBvcnQgKiAgYXMgY29tbW9uIGZyb20gJy4vY29tbW9uLmpzJztcbmltcG9ydCB7IGNvbmZpZywgU2l0ZVR5cGUgfSBmcm9tICcuL2NvbmZpZy5qcyc7XG5cbmNvbnN0IHsgbW9kdWxlRGF0YSB9ID0gY29tbW9uLm1vZHVsZURlZmluZShcbiAgICBcIm90Y0Jhbm5lclwiLFxuICAgICgpPT57fSxcbiAgICBkZWZhdWx0RGF0YVxuKTtcblxuZnVuY3Rpb24gZGVmYXVsdERhdGEoKSB7XG4gICAgY29uc3QgY29udGVudERhdGEgPSB7XG4gICAgICAgIGRhdGFzOiBcIlwiLFxuICAgICAgICBjb250ZW50SGVpZ2h0OiBcIjBcIixcbiAgICAgICAgYm90dG9tUGFkZGluZzogXCIwXCJcbiAgICB9O1xuICAgIHJldHVybiB7XG4gICAgICAgIHNpdGVUeXBlOiBTaXRlVHlwZS5CUkFORCwgLy8gMOWTgeeJjOerme+8jDHmma7pgJrnq5lcbiAgICAgICAgbm9ybWFsOiB7IC4uLmNvbnRlbnREYXRhIH0sIC8vIOS9v+eUqOa1heaLt+i0nemBv+WFjeW8leeUqOmXrumimFxuICAgICAgICBicmFuZDogeyAuLi5jb250ZW50RGF0YSB9LCAvLyDkvb/nlKjmtYXmi7fotJ3pgb/lhY3lvJXnlKjpl67pophcbiAgICAgICAgLy8gZGF0YXMg55qEIGdldHRlciDlkowgc2V0dGVyXG4gICAgICAgIGdldERhdGFzKCkge1xuICAgICAgICAgICAgcmV0dXJuIHRoaXMuc2l0ZVR5cGUgPT09IFNpdGVUeXBlLk5PUk1BTCA/IHRoaXMubm9ybWFsLmRhdGFzIDogdGhpcy5icmFuZC5kYXRhcztcbiAgICAgICAgfSxcbiAgICAgICAgc2V0RGF0YXModmFsdWUpIHtcbiAgICAgICAgICAgIHZhciB0YXJnZXQgPSB0aGlzLnNpdGVUeXBlID09PSBTaXRlVHlwZS5OT1JNQUwgPyB0aGlzLm5vcm1hbCA6IHRoaXMuYnJhbmQ7XG4gICAgICAgICAgICB0YXJnZXQuZGF0YXMgPSB2YWx1ZTtcbiAgICAgICAgICAgIGlmIChjb21tb24uY29tbWFuRGF0YS5PUyA9PSAxKSB7XG4gICAgICAgICAgICAgICAgdGFyZ2V0LmNvbnRlbnRIZWlnaHQgPSB2YWx1ZS5sZW5ndGggPiAwID8gXCI3MFwiIDogXCIwXCJcbiAgICAgICAgICAgICAgICB0YXJnZXQuYm90dG9tUGFkZGluZyA9IFwiMFwiXG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgIGNvbnN0IGJhbm5lckhlaWdodCA9IE1hdGguY2VpbCgoY29tbW9uLmNvbW1hbkRhdGEuc2NyZWVuV2lkdGggLSAzMikqNTQvMzQzLjApXG4gICAgICAgICAgICAgICAgdGFyZ2V0LmNvbnRlbnRIZWlnaHQgPSB2YWx1ZS5sZW5ndGggPiAwID8gYCR7YmFubmVySGVpZ2h0fWRwYCA6IFwiMGRwXCJcbiAgICAgICAgICAgICAgICB0YXJnZXQuYm90dG9tUGFkZGluZyA9IHZhbHVlLmxlbmd0aCA+IDAgPyBcIjE2XCIgOiBcIjBcIlxuICAgICAgICAgICAgfVxuICAgICAgICB9LFxuICAgICAgICBjbGFlckNhY2hlKCkge1xuICAgICAgICAgICAgdGhpcy5ub3JtYWwgPSB7IC4uLmNvbnRlbnREYXRhIH1cbiAgICAgICAgICAgIHRoaXMuYnJhbmQgPSB7IC4uLmNvbnRlbnREYXRhIH1cbiAgICAgICAgfVxuICAgIH07XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiByZWZyZXNoQmFubmVyKHR5cGUsIGN1cnJlbmN5TmFtZSwgY2xlYXIgPSBmYWxzZSkge1xuICAgIC8vIOW8guW4uOaVsOaNrui/h+a7pFxuICAgIGlmICh0eXBlID09IHVuZGVmaW5lZCB8fCBjdXJyZW5jeU5hbWUubGVuZ3RoID09IDApIHtcbiAgICAgICAgcmV0dXJuXG4gICAgfVxuICAgIG1vZHVsZURhdGEuc2l0ZVR5cGUgPSB0eXBlXG4gICAgLy8gYW5kcm9pZOS4iueJueauiuWkhOeQhlxuICAgIGlmIChjb21tb24uY29tbWFuRGF0YS5PUyA9PSAxKSB7XG4gICAgICAgIHZhciB0YXJnZXQgPSB0eXBlID09PSBTaXRlVHlwZS5OT1JNQUwgPyBtb2R1bGVEYXRhLmJyYW5kIDogbW9kdWxlRGF0YS5ub3JtYWw7XG4gICAgICAgIHRhcmdldC5jb250ZW50SGVpZ2h0ID0gMFxuICAgIH1cbiAgICBpZiAoY2xlYXIpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5jbGFlckNhY2hlKClcbiAgICB9XG4gICAgLy8g5LiN6IO95a2Y5Zyo57yT5a2Y5pWw5o2u5pe277yM5YiZ6L+b6KGM5o6l5Y+j6I635Y+WXG4gICAgdmFyIGNhY2hlRGF0YXMgPSBtb2R1bGVEYXRhLmdldERhdGFzKCk7XG4gICAgaWYgKGNhY2hlRGF0YXMubGVuZ3RoID09IDAgKSB7XG4gICAgICAgIHZhciBkYXRhcyA9IGF3YWl0IGxvYWRQMnBCYW5uZXJEYXRhcyh0eXBlLCBjdXJyZW5jeU5hbWUpXG4gICAgICAgIG1vZHVsZURhdGEuc2V0RGF0YXMoZGF0YXMpO1xuICAgIH1lbHNle1xuICAgICAgICBtb2R1bGVEYXRhLnNldERhdGFzKGNhY2hlRGF0YXMpO1xuICAgIH1cbn1cblxuYXN5bmMgZnVuY3Rpb24gbG9hZFAycEJhbm5lckRhdGFzKHR5cGUsIGN1cnJlbmN5TmFtZSkge1xuICAgIC8vIHR5cGXvvJow5ZOB54mM56uZ44CBMeaZrumAmuermVxuICAgIC8vIHJldHVybiBgW3tcImNvZGVcIjpcIjEwMDIwMDFcIixcInJ1bGVcIjoxLFwiY29udGVudFwiOlt7XCJ0eXBlXCI6NCxcImluZGV4XCI6MixcInZhbHVlXCI6XCJodHRwczovL290Yy1odW9iaS13ZWIub3NzLWNuLWhhbmd6aG91LmFsaXl1bmNzLmNvbS9jb21tb24vaW1hZ2VzL29wZXJhdGlvbi1ydWxlcy90ZXN0Mi5wbmdcIn0se1widHlwZVwiOjgsXCJpbmRleFwiOjEsXCJ2YWx1ZVwiOntcImxpbmtcIjpcImhvbGlnZWl0Oi8vb3Blbi92MT9sb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vb3RjL3RyYWRlXCJ9fV0sXCJwcmlvcml0eVwiOjIwMDF9LHtcImNvZGVcIjpcIjEwMDEwMzNcIixcInJ1bGVcIjoxLFwiY29udGVudFwiOlt7XCJ0eXBlXCI6NCxcImluZGV4XCI6MSxcInZhbHVlXCI6XCJodHRwczovL290Yy1maWxlLmhiZmlsZS5uZXQvaHVvYmkvb3RjL21hbmFnZV9uZXcvMTQxNC9jMGJlNDUzNzY5NTc0ODI2YWM1ZTE5OTU4NDA0OGQzZC5wbmdcIn0se1widHlwZVwiOjgsXCJpbmRleFwiOjIsXCJ2YWx1ZVwiOntcImxpbmtcIjpcImh0dHBzOi8vd3d3Lmdsb2JhbC1iYXNlLnRjLWpwMS5odW9iaWFwcHMuY29tL3poLWNuL2ZpYXQtY3J5cHRvL29wZXJhdGlvbmFsLWFjdGl2aXR5L2JsaW5kLWJveC1tb2JpbGVcIn19XSxcInByaW9yaXR5XCI6MTAyMn0se1wiY29kZVwiOlwiVEd0ZXN0XCIsXCJydWxlXCI6MSxcImNvbnRlbnRcIjpbe1widHlwZVwiOjQsXCJpbmRleFwiOjEsXCJ2YWx1ZVwiOlwiaHR0cHM6Ly9vdGMtdGVzdC1kZXYtdXBsb2FkLWh1b2JpLXdlYi5zMy5hcC1ub3J0aGVhc3QtMS5hbWF6b25hd3MuY29tL2h1b2JpL290Yy9tYW5hZ2VfbmV3LzM4MC8wOGJmZDE1NzBmNTc0MDdhYTk4ZDRlNWNhYjk0OTg1Ny5wbmdcIn0se1widHlwZVwiOjgsXCJpbmRleFwiOjIsXCJ2YWx1ZVwiOntcImxpbmtcIjpcImh0dHBzOi8vdC5tZS8rajFSUjJlS3VSRzh5WVRjMT9oYk9wZW5UeXBlPTFcIn19XSxcInByaW9yaXR5XCI6MTExfSx7XCJjb2RlXCI6XCJQMlBfaW52aXRlX2Jhbm5lcl93ZWJcIixcInJ1bGVcIjoxLFwiY29udGVudFwiOlt7XCJ0eXBlXCI6NCxcImluZGV4XCI6MSxcInZhbHVlXCI6XCJodHRwczovL290Yy10ZXN0LWRldi11cGxvYWQtaHVvYmktd2ViLnMzLmFwLW5vcnRoZWFzdC0xLmFtYXpvbmF3cy5jb20vaHVvYmkvb3RjL21hbmFnZV9uZXcvMzc4L2MzMTA4NThiNDM1YjRlNmI5NWQ1MGQwNTNkY2Y1ZTRmLnBuZ1wifSx7XCJ0eXBlXCI6OCxcImluZGV4XCI6MixcInZhbHVlXCI6e1wibGlua1wiOlwiaHR0cHM6Ly93d3cuZ2xvYmFsLWJhc2UudGMtanAxLmh1b2JpYXBwcy5jb20vemgtY24vZmlhdC1jcnlwdG8vb3BlcmF0aW9uYWwtYWN0aXZpdHkvc2hhcmUtYWQtbW9iaWxlXCJ9fV0sXCJwcmlvcml0eVwiOjF9XWBcbiAgICB2YXIgZXZlbnRJZCA9IHR5cGUgPT0gU2l0ZVR5cGUuTk9STUFMID8gXCI1MDJcIiA6IFwiNTAzXCJcbiAgICB2YXIgeyBkYXRhIH0gPSBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3QoXCIvdjEvdHJhZGUvbWt0UnVsZS9ydW5cIiwge1xuICAgICAgICBcImFwcFBhZ2VJZFwiOiA1MCxcbiAgICAgICAgXCJtZ3RSdWxlU2NlbmVDb2RlXCI6IFwicGFnZV9pbml0XCIsXG4gICAgICAgIFwiZXZlbnRJZFwiOiBldmVudElkLFxuICAgICAgICBcImN1cnJlbmN5QXNzZXROYW1lXCI6IGN1cnJlbmN5TmFtZSxcbiAgICB9KVxuICAgIGlmIChkYXRhICYmIGRhdGEucGFnZUxpc3QpIHtcbiAgICAgICAgdmFyIHBpY0tleSA9IGNvbW1vbi5jb21tYW5EYXRhLmNvbG9yTW9kZSA9PSAwID8gXCJkYXlcIiA6IFwibmlnaHRcIlxuICAgICAgICAvLyDlsIZ0eXBlMTDnmoTmm7TkuLrkuLo077yMdHlwZTEw5Lit5qC55o2uY29sb3JNb2Rl5Y+W5a+55bqU55qE5Zu+54mHXG4gICAgICAgIHZhciBkYXRhcyA9IGRhdGEucGFnZUxpc3QuZmlsdGVyKGl0ZW0gPT4gaXRlbS5jb250ZW50LnNvbWUoY29udGVudEl0ZW0gPT4gY29udGVudEl0ZW0udHlwZSA9PT0gMTApKVxuICAgICAgICBkYXRhcyA9IGRhdGFzLm1hcChpdGVtID0+IHtcbiAgICAgICAgICAgIC8vIOi/h+a7pOaOiSB0eXBlIOS4uiA0IOeahOWvueixoe+8jOW5tnR5cGXkuLoxMOi9rOaNouaIkDTvvIzojrflj5blr7nlupTmqKHlvI8gdmFsdWVcbiAgICAgICAgICAgIGNvbnN0IG5ld0NvbnRlbnQgPSBpdGVtLmNvbnRlbnQuZmlsdGVyKGNvbnRlbnRJdGVtID0+IHtcbiAgICAgICAgICAgICAgICBpZiAoY29udGVudEl0ZW0udHlwZSA9PT0gNCkge1xuICAgICAgICAgICAgICAgICAgICByZXR1cm4gZmFsc2U7IC8vIOWIoOmZpCB0eXBlIOS4uiA0IOeahOWvueixoVxuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICBpZiAoY29udGVudEl0ZW0udHlwZSA9PT0gMTApIHtcbiAgICAgICAgICAgICAgICAgICAgY29udGVudEl0ZW0udHlwZSA9IDRcbiAgICAgICAgICAgICAgICAgICAgY29udGVudEl0ZW0udmFsdWUgPSBjb250ZW50SXRlbS52YWx1ZVtwaWNLZXldID8/IGNvbnRlbnRJdGVtLnZhbHVlXG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIHJldHVybiB0cnVlO1xuICAgICAgICAgICAgfSk7XG4gICAgICAgICAgICByZXR1cm4geyAuLi5pdGVtLCBjb250ZW50OiBuZXdDb250ZW50IH07ICAgXG4gICAgICAgIH0pXG4gICAgICAgIGlmIChkYXRhcy5sZW5ndGggPiAwKSB7XG4gICAgICAgICAgICByZXR1cm4gSlNPTi5zdHJpbmdpZnkoZGF0YXMpO1xuICAgICAgICB9XG4gICAgfVxuICAgIHJldHVybiBcIlwiXG59XG4iLCJpbXBvcnQgKiAgYXMgY29tbW9uIGZyb20gJy4vY29tbW9uLmpzJztcblxuY29uc3QgeyBtb2R1bGVEYXRhLCBtb2R1bGVFdmVudCB9ID0gY29tbW9uLm1vZHVsZURlZmluZShcbiAgICBcInAycE1haW5UYWJcIixcbiAgICAoKT0+e30sXG4gICAgZGVmYXVsdERhdGFcbik7XG5cbmZ1bmN0aW9uIGRlZmF1bHREYXRhKCkge1xuICAgIHJldHVybiB7XG4gICAgICAgIGJyYW5kOiB7XG4gICAgICAgICAgICB0ZXh0Q29sb3I6IFwiQGNvbG9yL2tDb2xvckNvbnRlbnRCYWNrZ3JvdW5kXCIsXG4gICAgICAgICAgICBiYWNrZ3JvdW5kQ29sb3I6IFwiI0U0QkI3OVwiLFxuICAgICAgICAgICAgYnV5U2VsbEJhclZpc2libGU6IFwiZ29uZVwiLCBcbiAgICAgICAgICAgIGZpbHRlckJhclRpcFZpc2libGU6IFwiZ29uZVwiLCBcbiAgICAgICAgfSxcbiAgICAgICAgbm9ybWFsOiB7XG4gICAgICAgICAgICB0ZXh0Q29sb3I6IFwiQGNvbG9yL2tDb2xvcldoaXRlVGV4dFwiLFxuICAgICAgICAgICAgYmFja2dyb3VuZENvbG9yOiBcIkBjb2xvci9iYXNlQ29sb3JNYWpvclRoZW1lMTAwXCIsXG4gICAgICAgICAgICBidXlTZWxsQmFyVmlzaWJsZTogXCJnb25lXCIsIFxuICAgICAgICAgICAgZmlsdGVyQmFyVGlwVmlzaWJsZTogXCJnb25lXCIsIFxuICAgICAgICB9LFxuICAgICAgICBjb250YWluZXJIZWlnaHQ6IFwiMFwiLFxuICAgICAgICBtYXJnaW5Cb3R0b206IFwiMFwiLFxuICAgICAgICBiYWNrZ3JvdW5kQ29sb3I6IFwiIzJCMkIyQlwiLFxuICAgICAgICBjb250YWluZXJCZ0NvbG9yOiBcIiMwRTBFMEVcIixcbiAgICB9XG59XG5cbi8qKlxuICog5pu05paw5qCH562+5qCP5qC35byPXG4gKiBAcGFyYW0ge251bWJlcn0gdGFiSW5kZXggLSDpgInkuK3nmoTmoIfnrb7ntKLlvJVcbiAqL1xuZnVuY3Rpb24gdXBkYXRlQmFyU3R5bGUodGFiSW5kZXgpIHtcbiAgICBtb2R1bGVEYXRhLmJyYW5kLmJhY2tncm91bmRDb2xvciA9IHRhYkluZGV4ID09PSAwID8gXCIjRTRCQjc5XCIgOiBcIkBjb2xvci9rQ29sb3JDb250ZW50QmFja2dyb3VuZFwiO1xuICAgIG1vZHVsZURhdGEubm9ybWFsLmJhY2tncm91bmRDb2xvciA9IHRhYkluZGV4ID09PSAxID8gXCJAY29sb3IvYmFzZUNvbG9yTWFqb3JUaGVtZTEwMFwiIDogXCIjMkIyQjJCXCI7XG4gICAgbW9kdWxlRGF0YS5iYWNrZ3JvdW5kQ29sb3IgPSB0YWJJbmRleCA9PT0gMCA/IFwiIzJCMkIyQlwiIDogXCJAY29sb3Iva0NvbG9yQ29udGVudEJhY2tncm91bmRcIjtcbiAgICBtb2R1bGVEYXRhLmNvbnRhaW5lckJnQ29sb3IgPSB0YWJJbmRleCA9PT0gMCA/IFwiIzBFMEUwRVwiIDogXCJAY29sb3IvS0Jhc2VDb2xvckRlZXBlc3RCYWNrZ3JvdW5kXCI7XG4gICAgbW9kdWxlRGF0YS5icmFuZC50ZXh0Q29sb3IgPSAodGFiSW5kZXggPT09IDAgJiYgY29tbW9uLmNvbW1hbkRhdGEuY29sb3JNb2RlID09IDEpID8gXCIjMDAwMDAwXCIgOiBcIkBjb2xvci9rQ29sb3JQcmltYXJ5VGV4dFwiXG4gICAgXG4gICAgaWYgKGNvbW1vbi5jb21tYW5EYXRhLk9TID09IDEpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5ub3JtYWwuYnV5U2VsbEJhclZpc2libGUgPSB0YWJJbmRleCA9PT0gMCA/IFwiZ29uZVwiIDogXCJ2aXNpYmxlXCI7XG4gICAgICAgIG1vZHVsZURhdGEubm9ybWFsLmZpbHRlckJhclRpcFZpc2libGUgPSB0YWJJbmRleCA9PT0gMCA/IFwiZ29uZVwiIDogXCJ2aXNpYmxlXCI7XG4gICAgICAgIG1vZHVsZURhdGEuYnJhbmQuYnV5U2VsbEJhclZpc2libGUgPSB0YWJJbmRleCA9PT0gMCA/IFwidmlzaWJsZVwiIDogXCJnb25lXCI7XG4gICAgICAgIG1vZHVsZURhdGEuYnJhbmQuZmlsdGVyQmFyVGlwVmlzaWJsZSA9IHRhYkluZGV4ID09PSAwID8gXCJ2aXNpYmxlXCIgOiBcImdvbmVcIjtcbiAgICB9IGVsc2Uge1xuICAgICAgICBtb2R1bGVEYXRhLm5vcm1hbC5idXlTZWxsQmFyVmlzaWJsZSA9IFwidmlzaWJsZVwiO1xuICAgICAgICBtb2R1bGVEYXRhLm5vcm1hbC5maWx0ZXJCYXJUaXBWaXNpYmxlID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgIG1vZHVsZURhdGEuYnJhbmQuYnV5U2VsbEJhclZpc2libGUgPSBcInZpc2libGVcIjtcbiAgICAgICAgbW9kdWxlRGF0YS5icmFuZC5maWx0ZXJCYXJUaXBWaXNpYmxlID0gXCJ2aXNpYmxlXCI7XG4gICAgfVxufVxuXG4vKipcbiAqIOeCueWHu+S4u+agh+etvuagj1xuICogQHBhcmFtIHtudW1iZXJ9IGluZGV4IC0g6YCJ5Lit55qE5qCH562+57Si5byVXG4gKi9cbmFzeW5jIGZ1bmN0aW9uIG9uQ2xpY2tNYWluVGFiKGluZGV4LCB1cGxvYWRMaXN0ID0gdHJ1ZSkge1xuICAgIHRyeSB7XG4gICAgICAgIGlmIChtb2R1bGVEYXRhLnNlbGVjdGVkTWFpblRhYkluZGV4ID09PSBpbmRleCkgcmV0dXJuO1xuICAgICAgICBtb2R1bGVEYXRhLnNlbGVjdGVkTWFpblRhYkluZGV4ID0gaW5kZXg7XG4gICAgICAgIHVwZGF0ZUJhclN0eWxlKGluZGV4KVxuICAgICAgICAkZXZlbnQubG9hZExpc3RDb250ZW50KGluZGV4LCB1cGxvYWRMaXN0KVxuICAgIH0gY2F0Y2ggKGVycikge1xuICAgICAgICBjb25zb2xlLmxvZyhlcnIpXG4gICAgfVxufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc2hvd01haW5UYWIoaW5kZXgpIHtcbiAgICBtb2R1bGVEYXRhLmNvbnRhaW5lckhlaWdodCA9IFwiMjhcIlxuICAgIG1vZHVsZURhdGEubWFyZ2luQm90dG9tID0gXCIxNlwiXG4gICAgb25DbGlja01haW5UYWIoaW5kZXgsIGZhbHNlKSBcbn1cblxubW9kdWxlRXZlbnQub25DbGlja01haW5UYWIgPSBvbkNsaWNrTWFpblRhYiIsImltcG9ydCAqIGFzIGNvbW1vbiBmcm9tIFwiLi9jb21tb25cIlxuXG5jb25zdCB7IG1vZHVsZURhdGEsIG1vZHVsZUV2ZW50IH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFxuICAgIFwidmVyaWZ5Q2FwaXRhbFwiLFxuICAgICgpPT57fSxcbiAgICBkZWZhdWx0RGF0YVxuKTtcblxuZnVuY3Rpb24gZGVmYXVsdERhdGEoKSB7XG4gICAgcmV0dXJuIHtcbiAgICAgICAgcG9wU3RhdGU6IHtcbiAgICAgICAgICAgIGlzU2hvd2luZzogXCJmYWxzZVwiLFxuICAgICAgICAgICAgdGl0bGU6ICRpMThuLm5fb3RjX2FkdmVydF92ZXJpZnlfY2FwaXRhbF90aXRsZSxcbiAgICAgICAgICAgIGNvbnRlbnQ6JycsXG4gICAgICAgICAgICBidXR0b25UaXRsZTogJGkxOG4ubl9vdGNfa25vdyxcbiAgICAgICAgfSxcbiAgICAgICAgZGF0YXM6W10sXG4gICAgICAgIGlzZmV0Y2hlZDpmYWxzZVxuICAgIH07XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBmZXRjaENvbmZpZygpIHtcbiAgICBpZiAobW9kdWxlRGF0YS5kYXRhcy5sZW5ndGggPiAwKSB7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgY29uc3QgcmVzcG9uc2UgPSBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3QoXCJ2MS9kYXRhL3RyYWRlL3ZlcmlmeS9jYXBpdGFsL2NvbmZpZ1wiKTtcbiAgICBjb25zb2xlLmxvZyhcInZlcmlmeSBjYXBpdGFsIGNvbmZpZyBsb2FkZWQgc3VjY2Vzc2Z1bGx5OlwiLCByZXNwb25zZSk7XG4gICAgaWYgKHJlc3BvbnNlKSB7XG4gICAgICAgICRkYXRhLnZlcmlmeUNhcGl0YWwuZGF0YXMgPSAgcmVzcG9uc2UuZGF0YSB8fCBbXTtcbiAgICAgICAgJGRhdGEudmVyaWZ5Q2FwaXRhbC5pc2ZldGNoZWQgPSB0cnVlO1xuICAgIH1cbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGlzRmV0Y2hlZCgpIHtcbiAgICByZXR1cm4gJGRhdGEudmVyaWZ5Q2FwaXRhbC5pc2ZldGNoZWQ7XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBjb25maWdGb3JDdXJyZW5jeShjdXJyZW5jeSkge1xuICAgIGlmICh0eXBlb2YgY3VycmVuY3kgIT09ICdzdHJpbmcnKSByZXR1cm4gbnVsbDtcbiAgICB2YXIgb3JkZXJBbW91bnQgPSBudWxsO1xuICAgICRkYXRhLnZlcmlmeUNhcGl0YWwuZGF0YXMuZm9yRWFjaChpdGVtID0+IHtcbiAgICAgICAgaWYgKGl0ZW0uY3VycmVuY3kudG9VcHBlckNhc2UoKSA9PT0gY3VycmVuY3kudG9VcHBlckNhc2UoKSkge1xuICAgICAgICAgICAgb3JkZXJBbW91bnQgPSBpdGVtLm9yZGVyQW1vdW50O1xuICAgICAgICB9XG4gICAgfSk7XG4gICAgcmV0dXJuIG9yZGVyQW1vdW50O1xufVxuXG5leHBvcnQgZnVuY3Rpb24gcG9wVmVyaWZ5VGlwKGN1cnJlbmN5TmFtZSkge1xuICAgIGlmIChvcmRlckFtb3VudCA9IGNvbmZpZ0ZvckN1cnJlbmN5KGN1cnJlbmN5TmFtZSkpIHtcbiAgICAgICAgJGRhdGEudmVyaWZ5Q2FwaXRhbC5wb3BTdGF0ZS5jb250ZW50ID0gJGkxOG4ubl9vdGNfYWR2ZXJ0X3ZlcmlmeV9jYXBpdGFsX3N1YnRpdGxlLnJlcGxhY2UoXCJ7ezB9fVwiLCBvcmRlckFtb3VudCkucmVwbGFjZShcInt7MX19XCIsIGN1cnJlbmN5TmFtZSk7XG4gICAgICAgICRkYXRhLnZlcmlmeUNhcGl0YWwucG9wU3RhdGUuaXNTaG93aW5nID0gXCJ0cnVlXCI7XG4gICAgICAgIHJldHVybiB0cnVlO1xuICAgIH1cbiAgICByZXR1cm4gZmFsc2U7XG59XG5cbm1vZHVsZUV2ZW50LnBvcERpc21pc3MgPSBmdW5jdGlvbiAoKSB7XG4gICAgJGRhdGEudmVyaWZ5Q2FwaXRhbC5wb3BTdGF0ZS5pc1Nob3dpbmcgPSBcImZhbHNlXCI7XG59IiwiaW1wb3J0ICogIGFzIGNvbW1vbiBmcm9tICcuL2NvbW1vbi5qcyc7XG5pbXBvcnQgeyBjb25maWcsIFNpdGVUeXBlIH0gZnJvbSAnLi9jb25maWcuanMnO1xuaW1wb3J0ICogYXMgZGF0YVNlcnZpY2UgZnJvbSAnLi9hZHZlcnREYXRhU2VydmljZS5qcydcbmltcG9ydCAqIGFzIFZlcmlmeUNhcGl0YWwgZnJvbSAnLi92ZXJpZnlDYXBpdGFsLmpzJztcbmltcG9ydCAqIGFzIGFkdmVydEZpbHRlciBmcm9tICcuL2FkdmVydEZpbHRlci5qcyc7XG5cbmNvbnN0IHsgbW9kdWxlRGF0YSwgbW9kdWxlRXZlbnQgfSA9IGNvbW1vbi5tb2R1bGVEZWZpbmUoXG4gICAgXCJhZHZlcnRMaXN0XCIsXG4gICAgZnVuY3Rpb24gKCkge1xuICAgICAgICBjb25zb2xlLmxvZyhcImFkdmVydExpc3QgbG9hZGluZy4uLi5cIilcbiAgICB9LFxuICAgIGRlZmF1bHREYXRhXG4pO1xuXG5mdW5jdGlvbiBkZWZhdWx0RGF0YSgpIHtcbiAgICByZXR1cm4ge1xuICAgICAgICBicmFuZDogaW5pdGFsUGFnZURhdGEoKSxcbiAgICAgICAgbm9ybWFsOiBpbml0YWxQYWdlRGF0YSgpLFxuICAgIH07XG59XG5cbmZ1bmN0aW9uIGluaXRhbFBhZ2VEYXRhKCkge1xuICAgIHJldHVybiB7XG4gICAgICAgIHJlZnJlc2hTdGF0dXM6IDAsIC8v5Yi35paw54q25oCBXG4gICAgICAgIGxvYWRNb3JlU3RhdHVzOiAwLCAvL+WKoOi9veabtOWkmueKtuaAgVxuICAgICAgICBsaXN0VmlzaWJsZTogXCJ2aXNpYmxlXCIsIC8v5YiX6KGo5pWw5o2u5bGV56S6XG4gICAgICAgIGxvYWRpbmdTdGF0dXM6IFwicGxheVwiLFxuICAgICAgICBsb2FkaW5nVmlzaWJsZTogXCJ2aXNpYmxlXCIsXG4gICAgICAgIGV4dGVuZDogbnVsbCwgLy/moIfnrb7mlbDmja4sXG4gICAgICAgIGRhdGFzOiBbXSxcbiAgICAgICAgZW1wdHlWaXNpYmxlOiBcImdvbmVcIiwgLy8g56m66KeG5Zu+5pi+56S6XG4gICAgICAgIGVtcHR5YnV0dG9uVmlzaWJsZTogXCJnb25lXCIsIC8vIOepuuinhuWbvuaTjeS9nOaMiemSruaYvuekulxuICAgICAgICBub05ldFZpc2libGU6IFwiZ29uZVwiLFxuICAgICAgICBlbXB0eVRpcHM6IGNvbmZpZy50cmFkZVR5cGUgPT0gXCJidXlcIiAvLyDnqbrop4blm77mj5DnpLrmlofmoYhcbiAgICAgICAgICAgID8gKCRpMThuLm5fb3RjX2FkdmVydF9lbXB0eV90aXRsZSB8fCBcIuaaguaXoOW5v+WRiu+8jOaCqOWPr+WFheWAvOaVsOWtl+i1hOS6p+i/m+ihjOWFtuS7luS6pOaYk1wiKVxuICAgICAgICAgICAgOiAoJGkxOG4ub3RjX25vX2FkIHx8IFwi5pqC5peg5bm/5ZGKXCIpLFxuICAgICAgICBsb2FkaW5nVGVtcERhdGFzOiBbXSxcbiAgICAgICAgYm90dG9tT2Zmc2V0OiAwLFxuICAgIH1cbn1cblxuY29uc3QgZGF0YUhlbHBlciA9IHtcbiAgICBub3JtYWxEYXRhczogW10sXG4gICAgYnJhbmREYXRhczogW10sXG4gICAgZ2V0RGF0YXMoc2l0ZVR5cGUpIHtcbiAgICAgICAgcmV0dXJuIHNpdGVUeXBlID09IFNpdGVUeXBlLkJSQU5EID8gdGhpcy5icmFuZERhdGFzIDogdGhpcy5ub3JtYWxEYXRhc1xuICAgIH0sXG4gICAgc2V0RGF0YXMoc2l0ZVR5cGUsIHZhbHVlKSB7XG4gICAgICAgIGlmIChzaXRlVHlwZSA9PSBTaXRlVHlwZS5CUkFORCkge1xuICAgICAgICAgICAgdGhpcy5icmFuZERhdGFzID0gdmFsdWVcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIHRoaXMubm9ybWFsRGF0YXMgPSB2YWx1ZVxuICAgICAgICB9XG4gICAgfSxcbiAgICByZWZyZXNoTGlzdChzaXRlVHlwZSkge1xuICAgICAgICBpZiAoc2l0ZVR5cGUgPT0gU2l0ZVR5cGUuQlJBTkQpIHtcbiAgICAgICAgICAgIG1vZHVsZURhdGEuYnJhbmQuZGF0YXMgPSBbLi4udGhpcy5icmFuZERhdGFzLCAuLi5beyB0eXBlOiBcImZvb3RlclwiIH1dXVxuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5ub3JtYWwuZGF0YXMgPSBbLi4udGhpcy5ub3JtYWxEYXRhcywgLi4uW3sgdHlwZTogXCJmb290ZXJcIiB9XV1cbiAgICAgICAgfVxuICAgIH0sXG4gICAgLy8g6ZKI5a+55oyH5a6a55qEc2l0ZVR5cGXvvIzmm7TmlrDliJfooajmlbDmja5cbiAgICB1cGRhdGVEYXRhc1RvTGlzdChzaXRlVHlwZSwgZGF0YXMpIHtcbiAgICAgICAgaWYgKHNpdGVUeXBlID09IFNpdGVUeXBlLkJSQU5EKSB7XG4gICAgICAgICAgICB0aGlzLmJyYW5kRGF0YXMgPSBkYXRhc1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5icmFuZC5kYXRhcyA9IGRhdGFzXG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICB0aGlzLm5vcm1hbERhdGFzID0gZGF0YXNcbiAgICAgICAgICAgIG1vZHVsZURhdGEubm9ybWFsLmRhdGFzID0gZGF0YXNcbiAgICAgICAgfVxuICAgIH1cbn1cblxuLy8vIOabtOaWsOWIl+ihqOWuueWZqOmrmOW6plxubW9kdWxlRXZlbnQudXBkYXRlQ29udGVudEhlaWdodCA9IChjb250ZW50SGVpZ2h0KSA9PiB7XG4gICAgbW9kdWxlRGF0YS5jb250ZW50SGVpZ2h0ID0gY29udGVudEhlaWdodFxufVxuXG5leHBvcnQgZnVuY3Rpb24gdXBkYXRlQm90dG9tT2Zmc2V0KGhlaWdodCkge1xuICAgIG1vZHVsZURhdGEuYm90dG9tT2Zmc2V0ID0gaGVpZ2h0XG59XG5cbmV4cG9ydCBmdW5jdGlvbiByZWZyZXNoQWR2ZXJ0TGlzdElmTmVlZHMoc2l0VHlwZSwgZmlsdGVyUGFyYW1zKSB7XG4gICAgLy8gaW9z5LiK6LCD55So5pa55byP5LiN5ZCM77yM6ZyA6KaB5Y2V54us5YGa5pWw5o2u5qOA5p+l5pu05pawXG4gICAgaWYgKGNvbW1vbi5jb21tYW5EYXRhLk9TID09IDApIHtcbiAgICAgICAgLy8g6Iul5YiX6KGo6K+35rGC5Y+C5pWw5peg5pWI77yM6ZyA6KaB5YaN5qyh5ZCM5q2l6K+35rGC5Lqk5piT5a+55pWw5o2uXG4gICAgICAgIGNvbnN0IHsgY29pbklkLCBjdXJyZW5jeSB9ID0gZGF0YVNlcnZpY2UuZ2V0Q3VycmVudFJlcXVlc3RQYXJhbXMoc2l0VHlwZSk7XG4gICAgICAgIGlmICghKGNvaW5JZCAhPT0gdW5kZWZpbmVkICYmIGN1cnJlbmN5ICE9PSB1bmRlZmluZWQpKSB7XG4gICAgICAgICAgICBjb25zdCB7IGN1cnJlbmN5TmFtZSwgY29pbklkIH0gPSBmaWx0ZXJQYXJhbXNcbiAgICAgICAgICAgIGlmIChjb2luSWQgIT09IHVuZGVmaW5lZCAmJiBjdXJyZW5jeU5hbWUgIT09IHVuZGVmaW5lZCkge1xuICAgICAgICAgICAgICAgIHVwZGF0ZUFkdmVydExpc3RXaXRoRmlsdGVyUGFyYW1zKGZpbHRlclBhcmFtcywgc2l0VHlwZSlcbiAgICAgICAgICAgIH1cbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGxldCBkYXRhcyA9IGRhdGFIZWxwZXIuZ2V0RGF0YXMoc2l0VHlwZSlcbiAgICAgICAgICAgIGlmIChkYXRhcy5sZW5ndGggPT0gMCkge1xuICAgICAgICAgICAgICAgIHJlZnJlc2hBZHZlcnRMaXN0KHNpdFR5cGUpXG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICB9XG59XG5cbi8vLyDph43nva7kuqTmmJPliJfooajor7fmsYLlj4LmlbBcbmV4cG9ydCBmdW5jdGlvbiByZXNldEFkdmVydExpc3RSZXF1ZXN0KCkge1xuICAgIGRhdGFTZXJ2aWNlLnJlc2V0UGFyYW1zKClcbn1cblxuLy8vIOmHjee9ruS6pOaYk+WIl+ihqOivt+axguWPguaVsFxuZXhwb3J0IGZ1bmN0aW9uIHVwZGF0ZUFkdmVydExpc3RXaXRoRmlsdGVyUGFyYW1zTm9SZXF1ZXN0KGpzb24pIHtcbiAgICBkYXRhU2VydmljZS51cGRhdGVBZHZlcnRMaXN0V2l0aEZpbHRlclBhcmFtcyhjb25maWcuY3VycmVudFNpdGVUeXBlLCBqc29uKVxufVxuXG5leHBvcnQgZnVuY3Rpb24gdXBkYXRlQWR2ZXJ0TGlzdFdpdGhGaWx0ZXJQYXJhbXMoanNvbiwgdHlwZSA9IGNvbmZpZy5jdXJyZW50U2l0ZVR5cGUpIHtcbiAgICB0cnkge1xuICAgICAgICAvLyDln4vngrkg5pWw6YeP562b6YCJXG4gICAgICAgIGNvbnN0IHsgYW1vdW50OiBuZXdBbW91bnQgfSA9IGpzb25cbiAgICAgICAgY29uc3Qgb2xkQW1vdW50ID0gYWR2ZXJ0RmlsdGVyLmdldEFtb3VudCgpXG4gICAgICAgIGlmIChuZXdBbW91bnQgJiYgbmV3QW1vdW50ICE9IG9sZEFtb3VudCkge1xuICAgICAgICAgICAgY29tbW9uLmFuYWx5dGljcyh0eXBlID09IFNpdGVUeXBlLkJSQU5EID8gXCJvdGNfcDJwX2FkbGlzdF9icmFuZFwiIDogXCJvdGNfcDJwX2FkbGlzdFwiLCB7XG4gICAgICAgICAgICAgICAgXCJvdGNfc3RlcFwiOiBcIm90Y190cmFkZV9maWx0ZXJfYW1vdW50XCIsXG4gICAgICAgICAgICAgICAgXCJhbW91bnRcIjogbmV3QW1vdW50LFxuICAgICAgICAgICAgICAgIFwiZmlhdFwiOiBjb25maWcudGFyZ2V0LmN1cnJlbmN5TmFtZSxcbiAgICAgICAgICAgIH0pXG4gICAgICAgIH1cbiAgICAgICAgbGV0IHNlbGVjdGVkTW9yZSA9IGRhdGFTZXJ2aWNlLnVwZGF0ZUFkdmVydExpc3RXaXRoRmlsdGVyUGFyYW1zKHR5cGUsIGpzb24pXG4gICAgICAgIHJlZnJlc2hBZHZlcnRMaXN0KHR5cGUpXG4gICAgICAgIHJldHVybiBzZWxlY3RlZE1vcmVcbiAgICB9IGNhdGNoIChlcnJvcikge1xuICAgICAgICBjb25zb2xlLmxvZyhgdXBkYXRlQWR2ZXJ0TGlzdFdpdGhGaWx0ZXJQYXJhbXMgZXJyb3IgID09PT09ICR7ZXJyb3J9YClcbiAgICB9XG59XG5cbi8vIOWIt+WumumUmueCuS3llYblrrblhbPms6jnirbmgIHlj5jljJZcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiB1cGRhdGVMaXN0V2l0aEZvbGxvd1N0YXR1c0NoYW5nZWQoc2l0ZVR5cGUsIHBhcmFtcykge1xuICAgIGNvbnN0IHsgdHlwZSwgcmVsYXRpb25TdGF0dXMsIHVpZCB9ID0gcGFyYW1zO1xuICAgIGxldCBzdGF0dXMgPSByZWxhdGlvblN0YXR1cyA9PT0gXCJvblwiXG4gICAgbGV0IGlzRm9sbG93ID0gdHlwZSA9PT0gXCJmb2xsb3dcIiAmJiBzdGF0dXM7XG4gICAgbGV0IGlzU2hpZWxkID0gdHlwZSA9PT0gXCJzaGllbGRcIiAmJiBzdGF0dXM7XG4gICAgbGV0IGlzVW5zaGllbGQgPSB0eXBlID09PSBcInNoaWVsZFwiICYmICFzdGF0dXM7XG4gICAgaWYgKGlzVW5zaGllbGQpIHtcbiAgICAgICAgLy8g5Y+W5raI5bGP6JS955qE77yM6ZyA6KaB5YaN5qyh5bGV56S65pWw5o2u77yM5q2k5pe26ZyA6KaB5Yi35paw5pW05Liq5YiX6KGoXG4gICAgICAgIHJlZnJlc2hBZHZlcnRMaXN0KHNpdGVUeXBlKTtcbiAgICB9IGVsc2UgaWYgKGlzU2hpZWxkKSB7XG4gICAgICAgIC8vIOWxj+iUveeUqOaIt+S7juW5v+WRiuWIl+ihqOS4reenu+mZpFxuICAgICAgICB2YXIgaGFzQWRkQ2VsbCA9IGZhbHNlO1xuICAgICAgICB2YXIgaW5kZXhTZWFWaWV3Um9vbUNlbGwgPSAtMVxuICAgICAgICB2YXIgbmV3SW5kZXggPSAwXG4gICAgICAgIHZhciB0ZW1wRGF0YXMgPSBbXVxuICAgICAgICAvLyAxLui/h+a7pOWHuumdnuWxj+iUveeahOWVhuWutuW5v+WRiu+8jDIuYWRkQWR2ZXJ0Q2VsbOS5n+imgeenu+mZpO+8jOWxj+iUveWQjmluZGV45Y+R55Sf5Y+Y5YyWXG4gICAgICAgIGRhdGFIZWxwZXIuZ2V0RGF0YXMoc2l0ZVR5cGUpLmZvckVhY2goKGl0ZW0sIGluZGV4KSA9PiB7XG4gICAgICAgICAgICBpZiAoaXRlbS51aWQgJiYgYCR7aXRlbS51aWR9YCAhPT0gYCR7dWlkfWApIHtcbiAgICAgICAgICAgICAgICBpdGVtLmluZGV4ID0gbmV3SW5kZXhcbiAgICAgICAgICAgICAgICB0ZW1wRGF0YXMucHVzaChpdGVtKVxuICAgICAgICAgICAgICAgIG5ld0luZGV4Kys7XG4gICAgICAgICAgICB9IGVsc2UgaWYgKGl0ZW0udHlwZSA9PSBcInNlYVZpZXdSb29tQ2VsbFwiICYmIGl0ZW0ucm9vbXMpIHtcbiAgICAgICAgICAgICAgICB2YXIgZXhpc3QgPSBpdGVtLnJvb21zLnNvbWUoaXRlbSA9PiBgJHtpdGVtLnVpZH1gID09PSBgJHt1aWR9YClcbiAgICAgICAgICAgICAgICBpZiAoZXhpc3QpIHtcbiAgICAgICAgICAgICAgICAgICAgaW5kZXhTZWFWaWV3Um9vbUNlbGwgPSBpbmRleFxuICAgICAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgICAgIC8vIOa1t+aZr+aIv+S4jeWtmOWcqOWxj+iUveeUqOaIt++8jOWImeato+W4uOWxleekulxuICAgICAgICAgICAgICAgICAgICBpdGVtLmluZGV4ID0gbmV3SW5kZXhcbiAgICAgICAgICAgICAgICAgICAgdGVtcERhdGFzLnB1c2goaXRlbSlcbiAgICAgICAgICAgICAgICAgICAgbmV3SW5kZXgrKztcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICB9IGVsc2UgaWYgKGl0ZW0udHlwZSA9PSBcImFkZEFkdmVydENlbGxcIikge1xuICAgICAgICAgICAgICAgIGhhc0FkZENlbGwgPSB0cnVlXG4gICAgICAgICAgICB9XG4gICAgICAgIH0pO1xuICAgICAgICBkYXRhSGVscGVyLnNldERhdGFzKHNpdGVUeXBlLCB0ZW1wRGF0YXMpXG4gICAgICAgIGRhdGFIZWxwZXIucmVmcmVzaExpc3Qoc2l0ZVR5cGUpXG4gICAgICAgIGlmIChpbmRleFNlYVZpZXdSb29tQ2VsbCA+IDApIHtcbiAgICAgICAgICAgIGlmIChzaXRlVHlwZSA9PSBTaXRlVHlwZS5OT1JNQUwpIHtcbiAgICAgICAgICAgICAgICAvLyDph43mlrDliqDovb3mtbfmma/miL/vvIzov4fmu6TlvZPliY11aWRcbiAgICAgICAgICAgICAgICBhd2FpdCBsb2FkU2Vhdmlld1Jvb21EYXRhcyh1aWQpXG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICAgICAgaWYgKGhhc0FkZENlbGwpIHtcbiAgICAgICAgICAgIC8vIOmHjeaWsOiuoeeul+a3u+WKoOW5v+WRiueahOS9jee9rlxuICAgICAgICAgICAgYWRkR3JlYXRlQWR2ZXJ0Q2VsbElmTmVlZCgpXG4gICAgICAgIH1cbiAgICAgICAgaWYgKGZpbHRlcmVkRGF0YXMubGVuZ3RoID09PSAwKSB7XG4gICAgICAgICAgICAvLyDlsZXnpLrnqbrop4blm75cbiAgICAgICAgICAgIHNob3dMaXN0Q29uZW50KHRydWUsIHNpdGVUeXBlKTtcbiAgICAgICAgfVxuICAgIH0gZWxzZSB7XG4gICAgICAgIHZhciBkYXRhcyA9IGRhdGFIZWxwZXIuZ2V0RGF0YXMoc2l0ZVR5cGUpXG4gICAgICAgIHZhciBmb2xsb3dDdXJyZW50TWVyY2hhdFdpdGhBZHZlcnQgPSAoaXRlbSkgPT4ge1xuICAgICAgICAgICAgaWYgKGAke2l0ZW0udWlkfWAgPT09IGAke3VpZH1gKSB7XG4gICAgICAgICAgICAgICAgaXRlbS5pc0ZvbGxvd2VkID0gaXNGb2xsb3dcbiAgICAgICAgICAgICAgICBpdGVtLmZvbGxvdy5pZFZpc2libGUgPSBpc0ZvbGxvdyA/IFwidmlzaWJsZVwiIDogXCJnb25lXCJcbiAgICAgICAgICAgICAgICBpdGVtLmZvbGxvdy50aXRsZSA9IGlzRm9sbG93ID8gJGkxOG4ubl90aXRsZV9mb2xsb3dlZF9tZXJjaGFudCA6ICRpMThuLm5fdGl0bGVfZm9sbG93X21lcmNoYW50IC8vIOaJqeWxleWMuuWFs+azqHRpdGxlXG4gICAgICAgICAgICAgICAgaXRlbS5mb2xsb3cuaWNvbiA9IGlzRm9sbG93ID8gXCJAZHJhd2FibGUvc3Rhcl95ZWxsb3dfY29tbW9uXCIgOiBcIkBkcmF3YWJsZS9hZHZlcnRfZm9sbG93XCIgLy8g5omp5bGV5Yy65YWz5rOoXG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICAgICAgLy8g5YWz5rOo5Lit55qE5pu05paw54q25oCBXG4gICAgICAgIGRhdGFzLmZvckVhY2goaXRlbSA9PiBmb2xsb3dDdXJyZW50TWVyY2hhdFdpdGhBZHZlcnQoaXRlbSkpO1xuICAgICAgICBpZiAoc2l0ZVR5cGUgPT0gU2l0ZVR5cGUuTk9STUFMKSB7XG4gICAgICAgICAgICAvLyDmtbfmma/miL9jZWxs5a+56LGhXG4gICAgICAgICAgICB2YXIgZGF0YSA9IGRhdGFzLmZpbmQob2JqID0+IG9iai50eXBlID09PSBcInNlYVZpZXdSb29tQ2VsbFwiICYmIG9iai5yb29tcyAhPSB1bmRlZmluZWQpXG4gICAgICAgICAgICBkYXRhLnJvb21zLmZvckVhY2goaXRlbSA9PiBmb2xsb3dDdXJyZW50TWVyY2hhdFdpdGhBZHZlcnQoaXRlbSkpO1xuICAgICAgICB9XG4gICAgICAgIGRhdGFIZWxwZXIuc2V0RGF0YXMoc2l0ZVR5cGUsIGRhdGFzKVxuICAgICAgICBkYXRhSGVscGVyLnJlZnJlc2hMaXN0KHNpdGVUeXBlKVxuICAgIH1cbn1cblxuLy8g5Yi35a6a6ZSa54K5LeS4i+WNlemhteS7t+agvOWPmOWMllxuZXhwb3J0IGZ1bmN0aW9uIHVwZGF0ZUxpc3RXaXRoQWR2ZXJ0UHJpY2VDaGFuZ2VkKHNpdGVUeXBlLCBwYXJhbXMpIHtcbiAgICBjb25zdCB7IGFkdmVydElkLCBwcmljZSB9ID0gcGFyYW1zXG4gICAgdmFyIGRhdGFzID0gZGF0YUhlbHBlci5nZXREYXRhcyhzaXRlVHlwZSlcbiAgICB2YXIgZGF0YSA9IGRhdGFzLmZpbmQob2JqID0+IGAke29iai5pZH1gID09PSBgJHthZHZlcnRJZH1gKVxuICAgIGlmIChkYXRhICE9PSB1bmRlZmluZWQpIHtcbiAgICAgICAgZGF0YS5wcmljZSA9IHByaWNlXG4gICAgICAgIGRhdGEuc2hvd1ByaWNlID0gY29tbW9uLnRob3VzYW5kc0Zvcm1hdHRlcihwcmljZSlcbiAgICB9XG4gICAgLy8g5rW35pmv5oi/Y2VsbOS7t+agvOabtOaWsFxuICAgIGlmIChzaXRlVHlwZSA9PSBTaXRlVHlwZS5OT1JNQUwpIHtcbiAgICAgICAgdmFyIHN1YkRhdGEgPSBkYXRhcy5maW5kKG9iaiA9PiBvYmoudHlwZSA9PT0gXCJzZWFWaWV3Um9vbUNlbGxcIiAmJiBvYmoucm9vbXMgIT0gdW5kZWZpbmVkKVxuICAgICAgICB2YXIgcm9vbSA9IHN1YkRhdGEucm9vbXMuZmluZChvYmogPT4gYCR7b2JqLmlkfWAgPT09IGAke2FkdmVydElkfWApXG4gICAgICAgIGlmIChyb29tICE9PSB1bmRlZmluZWQpIHtcbiAgICAgICAgICAgIHJvb20ucHJpY2UgPSBwcmljZVxuICAgICAgICAgICAgcm9vbS5zaG93UHJpY2UgPSBjb21tb24udGhvdXNhbmRzRm9ybWF0dGVyKHByaWNlKVxuICAgICAgICB9XG4gICAgfVxuICAgIGRhdGFIZWxwZXIuc2V0RGF0YXMoc2l0ZVR5cGUsIGRhdGFzKVxuICAgIGRhdGFIZWxwZXIucmVmcmVzaExpc3Qoc2l0ZVR5cGUpXG59XG4vKipcbiAqIOW5v+WRiuWIl+ihqC3liLfmlrBcbiAqL1xuYXN5bmMgZnVuY3Rpb24gcmVmcmVzaEFkdmVydExpc3Qoc2l0ZVR5cGUpIHtcbiAgICBhd2FpdCBWZXJpZnlDYXBpdGFsLmZldGNoQ29uZmlnKClcbiAgICBhd2FpdCBsb2FkQWR2ZXJ0TGlzdFdpdGhSZWZyZXNoU3RhdHVzKGZhbHNlLCBzaXRlVHlwZSlcbiAgICBpZiAoc2l0ZVR5cGUgPT0gU2l0ZVR5cGUuTk9STUFMKSB7XG4gICAgICAgIGF3YWl0IGxvYWRTZWF2aWV3Um9vbURhdGFzKClcbiAgICB9XG4gICAgYWRkR3JlYXRlQWR2ZXJ0Q2VsbElmTmVlZCgpXG5cbiAgICAvL+Wfi+eCuSAtIOWIt+aWsFxuICAgIGNvbW1vbi5hbmFseXRpY3Moc2l0ZVR5cGUgPT0gU2l0ZVR5cGUuQlJBTkQgPyBcIm90Y19wMnBfYWRsaXN0X2JyYW5kXCIgOiBcIm90Y19wMnBfYWRsaXN0XCIsIHtcbiAgICAgICAgXCJvdGNfc3RlcFwiOiBcInJlZnJlc2hcIixcbiAgICAgICAgXCJzcG1cIjogXCJvdGMuYWRsaXN0LnBhZ2UucHVsbHRvcmVmcmVzaFwiLFxuICAgICAgICBcInNpZGVcIjogYWR2ZXJ0RmlsdGVyLmdldFRyYWRlVHlwZSgpLFxuICAgICAgICBcImNvaW5fbmFtZVwiOiBjb25maWcudGFyZ2V0LmNvaW5OYW1lLFxuICAgICAgICBcInBheW1lbnRcIjogYWR2ZXJ0RmlsdGVyLmdldFBheW1lbnQoKSxcbiAgICB9KVxufVxuXG4vKipcbiAqIOW5v+WRiuWIl+ihqC3liqDovb3mm7TlpJpcbiAqL1xuYXN5bmMgZnVuY3Rpb24gbG9hZE1vcmVBZHZlcnRMaXN0KHNpdGVUeXBlKSB7XG4gICAgYXdhaXQgbG9hZEFkdmVydExpc3RXaXRoUmVmcmVzaFN0YXR1cyh0cnVlLCBzaXRlVHlwZSlcbiAgICBhZGRHcmVhdGVBZHZlcnRDZWxsSWZOZWVkKClcblxuICAgIC8v5Z+L54K5IC0g5Yqg6L295pu05aSaXG4gICAgY29tbW9uLmFuYWx5dGljcyhzaXRlVHlwZSA9PSBTaXRlVHlwZS5CUkFORCA/IFwib3RjX3AycF9hZGxpc3RfYnJhbmRcIiA6IFwib3RjX3AycF9hZGxpc3RcIiwge1xuICAgICAgICBcIm90Y19zdGVwXCI6IFwibG9hZG1vcmVcIixcbiAgICAgICAgXCJzcG1cIjogXCJvdGMuYWRsaXN0LnBhZ2UubG9hZG1vcmVcIixcbiAgICAgICAgXCJzaWRlXCI6IGFkdmVydEZpbHRlci5nZXRUcmFkZVR5cGUoKSxcbiAgICAgICAgXCJjb2luX25hbWVcIjogY29uZmlnLnRhcmdldC5jb2luTmFtZSxcbiAgICAgICAgXCJwYXltZW50XCI6IGFkdmVydEZpbHRlci5nZXRQYXltZW50KCksXG4gICAgfSlcbn1cblxuYXN5bmMgZnVuY3Rpb24gbG9hZFNlYXZpZXdSb29tRGF0YXMoZmlsdGVyVWlkKSB7XG4gICAgaWYgKGNvbmZpZy5jb2luSWQgPT0gMikge1xuICAgICAgICBsZXQgbm9ybWFsRGF0YXMgPSBkYXRhSGVscGVyLmdldERhdGFzKFNpdGVUeXBlLk5PUk1BTClcbiAgICAgICAgaWYgKG5vcm1hbERhdGFzLmxlbmd0aCA+IDApIHtcbiAgICAgICAgICAgIHRyeSB7XG4gICAgICAgICAgICAgICAgbGV0IHsgZGF0YXMgfSA9IGF3YWl0IGRhdGFTZXJ2aWNlLmxvYWRTZWF2aWV3Um9vbURhdGFzV2l0aFRvcFRocmVlKCk7XG4gICAgICAgICAgICAgICAgLy8g5pyJ5pWw5o2u5omN6L+b6KGM5bGV56S6XG4gICAgICAgICAgICAgICAgaWYgKGRhdGFzICE9PSB1bmRlZmluZWQgJiYgZGF0YXMubGVuZ3RoID4gMCkge1xuICAgICAgICAgICAgICAgICAgICBpZiAoZmlsdGVyVWlkKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICBkYXRhcyA9IGRhdGFzLmZpbHRlcihpdGVtID0+IGAke2l0ZW0udWlkfWAgIT09IGAke2ZpbHRlclVpZH1gKVxuICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgICAgIGxldCB2aWV3TW9kZWxzID0gZGF0YXMuc2xpY2UoMCwgMylcbiAgICAgICAgICAgICAgICAgICAgLy8g5aaC5p6c6ZW/5bqm5LiN6LazM++8jOeUqOepuuWvueixoeihpem9kFxuICAgICAgICAgICAgICAgICAgICB3aGlsZSAodmlld01vZGVscy5sZW5ndGggPCAzKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICB2aWV3TW9kZWxzLnB1c2goe30pO1xuICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgICAgIHZpZXdNb2RlbHMuZm9yRWFjaCgoaXRlbSwgaW5kZXgpID0+IHtcbiAgICAgICAgICAgICAgICAgICAgICAgIGl0ZW0uY2VsbFR5cGUgPSBcInJvb21TdWJDZWxsXCJcbiAgICAgICAgICAgICAgICAgICAgICAgIGl0ZW0ucmFua0ljb24gPSBgQGRyYXdhYmxlL2MyY19hZHZlcnRfc2VhX3RvcCR7aW5kZXggKyAxfWBcbiAgICAgICAgICAgICAgICAgICAgICAgIGl0ZW0ubGluZVZpc2libGUgPSBpbmRleCA+IDEgPyBcImdvbmVcIiA6IFwidmlzaWJsZVwiXG4gICAgICAgICAgICAgICAgICAgICAgICB2YXIgZXhpc3QgPSBpdGVtLnVpZCAmJiBpdGVtLnVpZCA+IDBcbiAgICAgICAgICAgICAgICAgICAgICAgIGl0ZW0udmlzaWJpbGl0eSA9IGV4aXN0ID8gXCJ2aXNpYmxlXCIgOiBcImdvbmVcIlxuICAgICAgICAgICAgICAgICAgICAgICAgaXRlbS5lbXB0eVZpc2libGUgPSBleGlzdCA/IFwiZ29uZVwiIDogXCJ2aXNpYmxlXCJcbiAgICAgICAgICAgICAgICAgICAgICAgIGlmIChleGlzdCkge1xuICAgICAgICAgICAgICAgICAgICAgICAgICAgIC8vIOaIkOWNlemHj1xuICAgICAgICAgICAgICAgICAgICAgICAgICAgIGl0ZW0udG90YWxUcmFkZU9yZGVyQ291bnRUZXh0ID0gJGkxOG4uJGludGVyY2VwdC5uX290Y19hZHZlcnRfb3JkZXJjb3VudChgJHtpdGVtLnRvdGFsVHJhZGVPcmRlckNvdW50fWApXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgLy8g5a6M5oiQ546HXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgaXRlbS5vcmRlckNvbXBsZXRlUmF0ZVRleHQgPSBgJHtpdGVtLm9yZGVyQ29tcGxldGVSYXRlfSVgXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgLy8g5Lu35qC8XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgaXRlbS5zeW1ib2wgPSBjb25maWcuc3ltYm9sXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgaXRlbS5zaG93UHJpY2UgPSBjb21tb24udGhvdXNhbmRzRm9ybWF0dGVyKGl0ZW0ucHJpY2UpXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgZm9ybWF0VXNlcklkTGFibGVzKGl0ZW0pXG4gICAgICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgICAgIH0pXG4gICAgICAgICAgICAgICAgICAgIGxldCBpbmRleCA9IG5vcm1hbERhdGFzLmxlbmd0aCA+PSAyID8gMiA6IG5vcm1hbERhdGFzLmxlbmd0aFxuICAgICAgICAgICAgICAgICAgICBub3JtYWxEYXRhcy5zcGxpY2UoaW5kZXgsIDAsIHsgdHlwZTogXCJzZWFWaWV3Um9vbUNlbGxcIiwgcm9vbXM6IHZpZXdNb2RlbHMgfSlcbiAgICAgICAgICAgICAgICAgICAgdXBkYXRlTm9ybWFsRGF0YXMobm9ybWFsRGF0YXMpXG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgfSBjYXRjaCAoZXJyb3IpIHtcbiAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhgbG9hZFNlYXZpZXdSb29tRGF0YXMgZXJyb3IgID09PT09ICR7ZXJyb3J9YClcbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgIH1cbn1cblxuLy8g5re75Yqg5bm/5ZGK5YWl5Y+jXG5mdW5jdGlvbiBhZGRHcmVhdGVBZHZlcnRDZWxsSWZOZWVkKCkge1xuICAgIGlmIChjb25maWcuY3VycmVudFNpdGVUeXBlID09IFNpdGVUeXBlLk5PUk1BTCkge1xuICAgICAgICB0cnkge1xuICAgICAgICAgICAgbGV0IG5vcm1hbERhdGFzID0gZGF0YUhlbHBlci5nZXREYXRhcyhTaXRlVHlwZS5OT1JNQUwpXG4gICAgICAgICAgICBpZiAobm9ybWFsRGF0YXMubGVuZ3RoID4gMCkge1xuICAgICAgICAgICAgICAgIGNvbnN0IGV4aXN0cyA9IG5vcm1hbERhdGFzLnNvbWUob2JqID0+IG9iai50eXBlID09PSBcImFkZEFkdmVydENlbGxcIilcbiAgICAgICAgICAgICAgICBpZiAoIWV4aXN0cykge1xuICAgICAgICAgICAgICAgICAgICB2YXIgaW5kZXggPSAtMVxuICAgICAgICAgICAgICAgICAgICBpZiAobW9kdWxlRGF0YS5ub3JtYWwubm9Nb3JlRGF0YSA9PSB0cnVlKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICBpbmRleCA9IG5vcm1hbERhdGFzLmxlbmd0aCA+IDE0ID8gMTQgOiBub3JtYWxEYXRhcy5sZW5ndGhcbiAgICAgICAgICAgICAgICAgICAgfSBlbHNlIGlmIChub3JtYWxEYXRhcy5sZW5ndGggPiAxNCkge1xuICAgICAgICAgICAgICAgICAgICAgICAgaW5kZXggPSAxNFxuICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgICAgIGlmIChpbmRleCAhPSAtMSkge1xuICAgICAgICAgICAgICAgICAgICAgICAgbm9ybWFsRGF0YXMuc3BsaWNlKGluZGV4LCAwLCB7IHR5cGU6IFwiYWRkQWR2ZXJ0Q2VsbFwiIH0pXG4gICAgICAgICAgICAgICAgICAgICAgICB1cGRhdGVOb3JtYWxEYXRhcyhub3JtYWxEYXRhcylcbiAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH1cbiAgICAgICAgfSBjYXRjaCAoZSkge1xuICAgICAgICAgICAgY29uc29sZS5sb2coYGFkZEdyZWF0ZUFkdmVydENlbGxJZk5lZWQgZXJyb3IgID09PT09ICR7ZX1gKVxuICAgICAgICB9XG4gICAgfVxufVxuXG5mdW5jdGlvbiB1cGRhdGVOb3JtYWxEYXRhcyhkYXRhcykge1xuICAgIGRhdGFzLmZvckVhY2goKGRhdGEsIGkpID0+IGRhdGEuaW5kZXggPSBpKVxuICAgIGRhdGFIZWxwZXIuc2V0RGF0YXMoU2l0ZVR5cGUuTk9STUFMLCBkYXRhcylcbiAgICBkYXRhSGVscGVyLnJlZnJlc2hMaXN0KFNpdGVUeXBlLk5PUk1BTClcbn1cblxuYXN5bmMgZnVuY3Rpb24gbG9hZEFkdmVydExpc3RXaXRoUmVmcmVzaFN0YXR1cyhpc01vcmUgPSBmYWxzZSwgc2l0ZVR5cGUpIHtcbiAgICBjb25zdCBjdXJyZW50U2l0ZVR5cGUgPSBzaXRlVHlwZTtcbiAgICBjb25zdCB0YXJnZXQgPSBjdXJyZW50U2l0ZVR5cGUgPT09IFNpdGVUeXBlLk5PUk1BTCA/IG1vZHVsZURhdGEubm9ybWFsIDogbW9kdWxlRGF0YS5icmFuZDtcbiAgICBjb25zdCBzdGF0dXNUeXBlID0gaXNNb3JlID8gJ2xvYWRNb3JlU3RhdHVzJyA6ICdyZWZyZXNoU3RhdHVzJztcbiAgICAvLyDorr7nva7liqDovb3kuK3nirbmgIFcbiAgICBpZiAoIWlzTW9yZSkge1xuICAgICAgICAvLyDorr7nva5sb2FkaW5nIGNlbGxcbiAgICAgICAgaWYgKHRhcmdldC5sb2FkaW5nVGVtcERhdGFzLmxlbmd0aCA9PSAwKSB7XG4gICAgICAgICAgICB2YXIgbG9hZGluZ0NlbGxUeXBlID0gY29tbW9uLmNvbW1hbkRhdGEuY29sb3JNb2RlID09IDAgPyBcImFkdmVydExvYWRDZWxsRGF5XCIgOiBcImFkdmVydExvYWRDZWxsTmlnaHRcIlxuICAgICAgICAgICAgdGFyZ2V0LmxvYWRpbmdUZW1wRGF0YXMgPSBBcnJheS5mcm9tKHsgbGVuZ3RoOiAxMCB9LCAoKSA9PiAoeyB0eXBlOiBsb2FkaW5nQ2VsbFR5cGUgfSkpXG4gICAgICAgIH1cblxuICAgICAgICB0YXJnZXRbXCJsb2FkaW5nU3RhdHVzXCJdID0gXCJwbGF5XCJcbiAgICAgICAgdGFyZ2V0W1wibG9hZGluZ1Zpc2libGVcIl0gPSBcInZpc2libGVcIlxuICAgICAgICB0YXJnZXRbXCJub05ldFZpc2libGVcIl0gPSBcImdvbmVcIlxuICAgICAgICB0YXJnZXRbXCJlbXB0eVZpc2libGVcIl0gPSBcImdvbmVcIlxuICAgICAgICB0YXJnZXRbXCJsaXN0VmlzaWJsZVwiXSA9IFwiZ29uZVwiXG4gICAgfVxuXG4gICAgdHJ5IHtcbiAgICAgICAgdmFyIHJlcyA9IGlzTW9yZSA/IGF3YWl0IGRhdGFTZXJ2aWNlLmxvYWRNb3JlQWR2ZXJ0TGlzdChzaXRlVHlwZSkgOiBhd2FpdCBkYXRhU2VydmljZS5yZWZyZXNoQWR2ZXJ0TGlzdChzaXRlVHlwZSlcbiAgICB9IGZpbmFsbHkge1xuICAgICAgICB0YXJnZXRbc3RhdHVzVHlwZV0gPSBcIjJcIjtcbiAgICB9XG5cbiAgICB0cnkge1xuICAgICAgICB2YXIgb3JpZ2luRGF0YXMgPSBkYXRhSGVscGVyLmdldERhdGFzKHNpdGVUeXBlKVxuICAgICAgICB2YXIgc2hvd0VtcHR5ID0gIWlzTW9yZVxuICAgICAgICBpZiAocmVzICYmIHJlcy5kYXRhcyAhPSB1bmRlZmluZWQpIHtcbiAgICAgICAgICAgIHZhciB7IGV4dGVuZCwgZGF0YXMsIGhhc01vcmUgfSA9IHJlcztcbiAgICAgICAgICAgIHZhciBzdGFydEluZGV4ID0gaXNNb3JlID8gb3JpZ2luRGF0YXMubGVuZ3RoIDogMDtcbiAgICAgICAgICAgIGxldCB2aWV3TW9kZWxzUHJvbWlzZSA9IGRhdGFzLm1hcChhc3luYyAoZGF0YSwgaSkgPT4ge1xuICAgICAgICAgICAgICAgIHZhciBpdGVtID0gY3VycmVudFNpdGVUeXBlID09IFNpdGVUeXBlLkJSQU5EID8gYXdhaXQgZm9ybWF0QnJhbmRBZHZlcnQoZGF0YSkgOiBhd2FpdCBmb3JtYXROb3JtYWxBZHZlcnQoZGF0YSlcbiAgICAgICAgICAgICAgICBpdGVtLmluZGV4ID0gaSArIHN0YXJ0SW5kZXhcbiAgICAgICAgICAgICAgICByZXR1cm4gaXRlbVxuICAgICAgICAgICAgfSlcbiAgICAgICAgICAgIHZhciB2aWV3TW9kZWxzID0gYXdhaXQgUHJvbWlzZS5hbGwodmlld01vZGVsc1Byb21pc2UpXG4gICAgICAgICAgICAvLyDmm7TmlrDliJfooajmlbDmja5cbiAgICAgICAgICAgIGNvbnN0IG5ld0RhdGFzID0gaXNNb3JlID8gWy4uLm9yaWdpbkRhdGFzLCAuLi52aWV3TW9kZWxzXSA6IHZpZXdNb2RlbHM7XG4gICAgICAgICAgICBkYXRhSGVscGVyLnVwZGF0ZURhdGFzVG9MaXN0KGN1cnJlbnRTaXRlVHlwZSwgbmV3RGF0YXMpXG4gICAgICAgICAgICAvLyDmoIfnrb7mlbDmja4g5Yi35paw5pe26YeN6K6+XG4gICAgICAgICAgICBjb25zdCB7IGxhYmVsSWQgfSA9IGRhdGFTZXJ2aWNlLmdldEN1cnJlbnRSZXF1ZXN0UGFyYW1zKHNpdGVUeXBlKVxuICAgICAgICAgICAgaWYgKCFpc01vcmUgJiYgbGFiZWxJZCA9PSBcIlwiKSB7XG4gICAgICAgICAgICAgICAgdGFyZ2V0LmV4dGVuZCA9IEpTT04uc3RyaW5naWZ5KGV4dGVuZCk7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICAvLyDliqDovb3lrozkuoblsZXnpLpcbiAgICAgICAgICAgIHRhcmdldFtcIm5vTW9yZURhdGFcIl0gPSAhaGFzTW9yZVxuICAgICAgICAgICAgLy8g5piv5ZCm5pi+56S656m66KeG5Zu+LCDnrKzkuIDpobXmiY3mnIlsb2FkaW5nXG4gICAgICAgICAgICBzaG93RW1wdHkgPSAoIWlzTW9yZSAmJiB2aWV3TW9kZWxzLmxlbmd0aCA9PSAwKVxuICAgICAgICB9XG4gICAgICAgIC8vIOmakOiXj2xvYWRpbmdcbiAgICAgICAgaWYgKCFpc01vcmUpIHtcbiAgICAgICAgICAgIHRhcmdldFtcImxvYWRpbmdTdGF0dXNcIl0gPSBcInN0b3BcIlxuICAgICAgICAgICAgdGFyZ2V0W1wibG9hZGluZ1Zpc2libGVcIl0gPSBcImdvbmVcIlxuICAgICAgICB9XG5cbiAgICAgICAgc2hvd0xpc3RDb25lbnQoc2hvd0VtcHR5LCBjdXJyZW50U2l0ZVR5cGUsIHJlcyA9PSBudWxsKVxuICAgIH0gY2F0Y2ggKGVycm9yKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGBsb2FkQWR2ZXJ0TGlzdFdpdGhSZWZyZXNoU3RhdHVzIGVycm9yICA9PT09PSAke2Vycm9yfWApXG4gICAgfVxufVxuXG5leHBvcnQgZnVuY3Rpb24gc2hvd0xpc3RDb25lbnQoc2hvd0VtcHR5LCBzaXRlVHlwZSwgc2hvd05vTmV0ID0gZmFsc2UpIHtcbiAgICBjb25zdCB0YXJnZXQgPSBzaXRlVHlwZSA9PT0gU2l0ZVR5cGUuTk9STUFMID8gbW9kdWxlRGF0YS5ub3JtYWwgOiBtb2R1bGVEYXRhLmJyYW5kO1xuICAgIGlmIChzaG93Tm9OZXQpIHtcbiAgICAgICAgLy8g5pyJ5pWw5o2u5pe277yMdG9hc3Tmj5DnpLrvvIzml6DmlbDmja7ml7bmmoLml7bml6DnvZHmoLflvI9cbiAgICAgICAgaWYgKHNob3dFbXB0eSkge1xuICAgICAgICAgICAgdGFyZ2V0W1wibm9OZXRWaXNpYmxlXCJdID0gXCJ2aXNpYmxlXCJcbiAgICAgICAgICAgIHRhcmdldFtcImVtcHR5VmlzaWJsZVwiXSA9IFwiZ29uZVwiXG4gICAgICAgICAgICB0YXJnZXRbXCJsaXN0VmlzaWJsZVwiXSA9IFwiZ29uZVwiXG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAkbmF0aXZlQVBJLmhiVG9hc3QoJGkxOG4ubl9jaGVja19uZXR3b3JrKTtcbiAgICAgICAgfVxuICAgIH0gZWxzZSB7XG4gICAgICAgIHRhcmdldFtcIm5vTmV0VmlzaWJsZVwiXSA9IFwiZ29uZVwiXG4gICAgICAgIHRhcmdldFtcImVtcHR5VmlzaWJsZVwiXSA9IHNob3dFbXB0eSA/IFwidmlzaWJsZVwiIDogXCJnb25lXCJcbiAgICAgICAgdGFyZ2V0W1wibGlzdFZpc2libGVcIl0gPSBzaG93RW1wdHkgPyBcImdvbmVcIiA6IFwidmlzaWJsZVwiXG4gICAgICAgIGlmIChzaG93RW1wdHkpIHtcbiAgICAgICAgICAgIGNvbnN0IHsgY3VycmVuY3ksIGNvaW5JZCwgdHJhZGVUeXBlIH0gPSBkYXRhU2VydmljZS5nZXRDdXJyZW50UmVxdWVzdFBhcmFtcyhzaXRlVHlwZSlcbiAgICAgICAgICAgIGlmIChjdXJyZW5jeSA9PSAwIHx8IGN1cnJlbmN5ID09IHVuZGVmaW5lZCkgeyAvLyDmraTml7bmsqHmnInkuqTmmJPlr7lcbiAgICAgICAgICAgICAgICB0YXJnZXRbXCJlbXB0eWJ1dHRvblZpc2libGVcIl0gPSBcImdvbmVcIlxuICAgICAgICAgICAgICAgIHRhcmdldFtcImVtcHR5VGlwc1wiXSA9ICRpMThuLm5fb3RjX25vdF9zdXBwb3J0X2ZpYXQgfHwgXCLmmoLkuI3mlK/mjIHlvZPliY3ms5XluIFcIlxuICAgICAgICAgICAgfSBlbHNlIGlmIChjb2luSWQgPT0gMCB8fCBjb2luSWQgPT0gdW5kZWZpbmVkKSB7XG4gICAgICAgICAgICAgICAgdGFyZ2V0W1wiZW1wdHlidXR0b25WaXNpYmxlXCJdID0gXCJnb25lXCJcbiAgICAgICAgICAgICAgICB0YXJnZXRbXCJlbXB0eVRpcHNcIl0gPSAkaTE4bi5uX2Fzc2V0X2N1cnJlbmN5X2ludmFsaWQgfHwgXCLmraTluIHnp43mmoLkuI3mlK/mjIFcIlxuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICBsZXQgaXNCdXkgPSB0cmFkZVR5cGUgPT0gXCJzZWxsXCJcbiAgICAgICAgICAgICAgICB0YXJnZXRbXCJlbXB0eWJ1dHRvblZpc2libGVcIl0gPSBpc0J1eSA/IFwidmlzaWJsZVwiIDogXCJnb25lXCJcbiAgICAgICAgICAgICAgICB0YXJnZXRbXCJlbXB0eVRpcHNcIl0gPSBpc0J1eVxuICAgICAgICAgICAgICAgICAgICA/ICgkaTE4bi5uX290Y19hZHZlcnRfZW1wdHlfdGl0bGUgfHwgXCLmmoLml6Dlub/lkYrvvIzmgqjlj6/lhYXlgLzmlbDlrZfotYTkuqfov5vooYzlhbbku5bkuqTmmJNcIilcbiAgICAgICAgICAgICAgICAgICAgOiAoJGkxOG4ub3RjX25vX2FkIHx8IFwi5pqC5peg5bm/5ZGKXCIpXG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICB9XG59XG5cbmZ1bmN0aW9uIGZvcm1hdEFkdmVydChpdGVtKSB7XG4gICAgLy8g5piv5ZCm5pi+56S66aqM6K+B5Y2VXG4gICAgaWYgKGl0ZW0udmVyaWZ5Q2FwaXRhbFN0YXR1cyAhPT0gdW5kZWZpbmVkKSB7XG4gICAgICAgIGl0ZW0udmVyaWZ5Q2FwaXRhbFZpc2libGUgPSAoaXRlbS50cmFkZVR5cGU9PTEgJiYgVmVyaWZ5Q2FwaXRhbC5jb25maWdGb3JDdXJyZW5jeShjb25maWcuY3VycmVuY3lOYW1lKSAmJiBpdGVtLnZlcmlmeUNhcGl0YWxTdGF0dXMgIT0gMikgPyBcInZpc2libGVcIiA6IFwiZ29uZVwiO1xuICAgICAgICBpdGVtLnZlcmlmeUNhcGl0YWxUZXh0ID0gaXRlbS52ZXJpZnlDYXBpdGFsU3RhdHVzID09IDEgPyAkaTE4bi5uX290Y19hZHZlcnRfdmVyaWZ5X2NhcGl0YWxfdGl0bGUgOiAoaXRlbS52ZXJpZnlDYXBpdGFsU3RhdHVzID09IDAgPyAkaTE4bi5uX290Y19hZHZlcnRfbm9fdmVyaWZ5X2NhcGl0YWxfdGl0bGUgOiBcIlwiKTtcbiAgICAgICAgaXRlbS52ZXJpZnlDYXBpdGFsWWVzVmlzaWJsZSA9IGl0ZW0udmVyaWZ5Q2FwaXRhbFN0YXR1cyA9PSAxID8gXCJ2aXNpYmxlXCIgOiBcImdvbmVcIjtcbiAgICAgICAgaXRlbS52ZXJpZnlDYXBpdGFsTm9WaXNpYmxlID0gaXRlbS52ZXJpZnlDYXBpdGFsU3RhdHVzID09IDAgPyBcInZpc2libGVcIiA6IFwiZ29uZVwiO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIGl0ZW0udmVyaWZ5Q2FwaXRhbFZpc2libGUgPSAoaXRlbS50cmFkZVR5cGU9PTEgJiYgVmVyaWZ5Q2FwaXRhbC5jb25maWdGb3JDdXJyZW5jeShjb25maWcuY3VycmVuY3lOYW1lKSkgPyBcInZpc2libGVcIiA6IFwiZ29uZVwiO1xuICAgICAgICBpdGVtLnZlcmlmeUNhcGl0YWxUZXh0ID0gaXRlbS5pc1ZlcmlmeUNhcGl0YWwgPyAkaTE4bi5uX290Y19hZHZlcnRfdmVyaWZ5X2NhcGl0YWxfdGl0bGUgOiAkaTE4bi5uX290Y19hZHZlcnRfbm9fdmVyaWZ5X2NhcGl0YWxfdGl0bGU7XG4gICAgICAgIGl0ZW0udmVyaWZ5Q2FwaXRhbFllc1Zpc2libGUgPSBpdGVtLmlzVmVyaWZ5Q2FwaXRhbCA/IFwidmlzaWJsZVwiIDogXCJnb25lXCI7XG4gICAgICAgIGl0ZW0udmVyaWZ5Q2FwaXRhbE5vVmlzaWJsZSA9ICFpdGVtLmlzVmVyaWZ5Q2FwaXRhbCA/IFwidmlzaWJsZVwiIDogXCJnb25lXCI7XG4gICAgfVxuXG4gICAgLy8g5piv5ZCm5pi+56S65Y+z5LiK6KeS5rS75Yqo5qCH562+XG4gICAgaXRlbS5sYWJlbFZpc2libGUgPSAoaXRlbS5sYWJlbE5hbWUgJiYgaXRlbS5sYWJlbE5hbWUubGVuZ3RoID4gMCkgPyBcInZpc2libGVcIiA6IFwiZ29uZVwiO1xuICAgIC8vIOS7t+agvFxuICAgIGl0ZW0uc3ltYm9sID0gY29uZmlnLnN5bWJvbFxuICAgIGl0ZW0uc2hvd1ByaWNlID0gY29tbW9uLnRob3VzYW5kc0Zvcm1hdHRlcihpdGVtLnByaWNlKVxuICAgIC8vIOaVsOmHj1xuICAgIGl0ZW0ubnVtVGV4dCA9IGl0ZW0udHJhZGVDb3VudCArIFwiIFwiICsgY29uZmlnLmNvaW5OYW1lLnRvVXBwZXJDYXNlKCk7XG4gICAgLy8g6ZmQ6aKdXG4gICAgbGV0IG1pblRyYWRlTGltaXQgPSBpdGVtLm1pblRyYWRlTGltaXQucmVwbGFjZSgvXFxCKD89KFxcZHszfSkrKD8hXFxkKSkvZywgXCIsXCIpO1xuICAgIGxldCBtYXhUcmFkZUxpbWl0ID0gaXRlbS5tYXhUcmFkZUxpbWl0LnJlcGxhY2UoL1xcQig/PShcXGR7M30pKyg/IVxcZCkpL2csIFwiLFwiKTtcbiAgICBpdGVtLmxpbWl0QW1vdW50VGV4dCA9IGl0ZW0uc3ltYm9sICsgbWluVHJhZGVMaW1pdCArIFwiIC0gXCIgKyBpdGVtLnN5bWJvbCArIG1heFRyYWRlTGltaXQ7XG4gICAgLy8g5Lqk5piT5pe26Ze0XG4gICAgaXRlbS50cmFkZUR1cmF0aW9uVGV4dCA9ICRpMThuLiRpbnRlcmNlcHQubl9kZXNjX21pbnV0ZShgJHtpdGVtLnBheVRlcm19YClcbiAgICAvLyDmianlsZXljLrlsZXnpLogKOaZrumAmuWFs+azqClcbiAgICBpdGVtLmV4cGFuZEFyZWFWaXNpYmlsaXR5ID0gXCJnb25lXCJcbiAgICAvLyDlhbPms6hcbiAgICBpdGVtLmZvbGxvdyA9IHtcbiAgICAgICAgdGl0bGU6IGl0ZW0uaXNGb2xsb3dlZCA/ICRpMThuLm5fdGl0bGVfZm9sbG93ZWRfbWVyY2hhbnQgOiAkaTE4bi5uX3RpdGxlX2ZvbGxvd19tZXJjaGFudCwgLy8g5omp5bGV5Yy65YWz5rOodGl0bGVcbiAgICAgICAgaWNvbjogaXRlbS5pc0ZvbGxvd2VkID8gXCJAZHJhd2FibGUvc3Rhcl95ZWxsb3dfY29tbW9uXCIgOiBcIkBkcmF3YWJsZS9hZHZlcnRfZm9sbG93XCIsIC8vIOaJqeWxleWMuuWFs+azqFxuICAgICAgICBpZFZpc2libGU6IFwiZ29uZVwiLFxuICAgICAgICBpZEljb246IFwiXCJcbiAgICB9LFxuXG4gICAgICAgIC8vIOWFs+azqOeKtuaAgVxuICAgICAgICBpdGVtLmZvbGxvdy50aXRsZSA9IGl0ZW0uaXNGb2xsb3dlZCA/ICRpMThuLm5fdGl0bGVfZm9sbG93ZWRfbWVyY2hhbnQgOiAkaTE4bi5uX3RpdGxlX2ZvbGxvd19tZXJjaGFudFxuICAgIGl0ZW0uZm9sbG93Lmljb24gPSBpdGVtLmlzRm9sbG93ZWQgPyBcIkBkcmF3YWJsZS9zdGFyX3llbGxvd19jb21tb25cIiA6IFwiQGRyYXdhYmxlL2FkdmVydF9mb2xsb3dcIlxuXG4gICAgLy8g5Lqk5piT5oyJ6ZKuXG4gICAgdmFyIHRyYWRlQnV0dG9uID0ge307IC8vIOS6pOaYk+aMiemSrm1vZGVsXG4gICAgdmFyIHRyYW5zcGFyZW50ID0gZmFsc2VcbiAgICBpZiAoaXRlbS50YWtlckxpbWl0ICYgNCkgeyAvL+mcgOimgeWunuWQjeiupOivgVxuICAgICAgICB0cmFkZUJ1dHRvbi50aXRsZSA9ICRpMThuLm5fb3RjX2FkdmVydF9idG5fa3ljIHx8IFwi5a6e5ZCN6K6k6K+BXCJcbiAgICAgICAgdHJhbnNwYXJlbnQgPSB0cnVlXG4gICAgfSBlbHNlIGlmIChpdGVtLnRha2VyTGltaXQgJiAxKSB7IC8v57uR5a6a5omL5py6XG4gICAgICAgIHRyYWRlQnV0dG9uLnRpdGxlID0gJGkxOG4ubl9vdGNfYWR2ZXJ0X2J0bl9iaW5kX3Bob25lIHx8IFwi57uR5a6a5omL5py65Y+3XCJcbiAgICAgICAgdHJhbnNwYXJlbnQgPSB0cnVlXG4gICAgfSBlbHNlIGlmIChpdGVtLnRha2VyTGltaXQgJiAyIHx8IGl0ZW0udGFrZXJMaW1pdCAmIDgpIHsgLy/llYblrrborr7pmZBcbiAgICAgICAgdHJhZGVCdXR0b24udGl0bGUgPSAkaTE4bi5uX290Y190YWtlcl9saW1pdF9uZXcgfHwgXCLlub/lkYrmlrnlt7Lorr7pmZBcIlxuICAgICAgICB0cmFuc3BhcmVudCA9IHRydWVcbiAgICB9IGVsc2UgeyAvLyDmraPluLjkuqTmmJNcbiAgICAgICAgaWYgKGl0ZW0udHJhZGVUeXBlID09IDEpIHtcbiAgICAgICAgICAgIHRyYWRlQnV0dG9uLnRpdGxlID0gJGkxOG4ubl9vdGNfYnV5IHx8IFwi6LSt5LmwXCJcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIHRyYWRlQnV0dG9uLnRpdGxlID0gJGkxOG4ubl9vdGNfc2VsbCB8fCBcIuWHuuWUrlwiXG4gICAgICAgIH1cbiAgICB9XG4gICAgdHJhZGVCdXR0b24udGlwc1Zpc2liaWxpdHkgPSB0cmFuc3BhcmVudCA/IFwidmlzaWJsZVwiIDogXCJnb25lXCJcbiAgICB0cmFkZUJ1dHRvbi52aXNpYmlsaXR5ID0gdHJhbnNwYXJlbnQgPyBcImdvbmVcIiA6IFwidmlzaWJsZVwiXG4gICAgdHJhZGVCdXR0b24udHJhbnNwYXJlbnQgPSB0cmFuc3BhcmVudFxuICAgIGl0ZW0udHJhZGVCdXR0b24gPSB0cmFkZUJ1dHRvbjtcbiAgICBsZXQgbWV0aG9kcyA9IFtdXG4gICAgZm9yIChsZXQgbWV0aG9kIG9mIGl0ZW0ucGF5TWV0aG9kcykge1xuICAgICAgICBtZXRob2QudHlwZSA9IFwiMVwiXG4gICAgICAgIG1ldGhvZHMucHVzaChtZXRob2QpXG4gICAgfVxuICAgIGl0ZW0ucGF5TWV0aG9kcyA9IG1ldGhvZHNcbn1cblxuZnVuY3Rpb24gZm9ybWF0VXNlcklkTGFibGVzKGl0ZW0pIHtcbiAgICAvLyDok53nm75cbiAgICBsZXQgaGFzQmx1ZVNoaWVsZCA9IGZhbHNlO1xuICAgIGlmIChpdGVtLm1lcmNoYW50VGFncyAmJiBBcnJheS5pc0FycmF5KGl0ZW0ubWVyY2hhbnRUYWdzKSkge1xuICAgICAgICBoYXNCbHVlU2hpZWxkID0gaXRlbS5tZXJjaGFudFRhZ3MuaW5jbHVkZXMoMSk7XG4gICAgfVxuICAgIGl0ZW0uYmx1ZVNoaWVsZCA9IGl0ZW0uYmx1ZVNoaWVsZCB8fCB7fVxuICAgIGl0ZW0uYmx1ZVNoaWVsZC5pZFZpc2libGUgPSBoYXNCbHVlU2hpZWxkID8gXCJ2aXNpYmxlXCIgOiBcImdvbmVcIlxuICAgIC8vIOWVhuWutuetiee6p1xuICAgIGl0ZW0ubGV2ZWwgPSBpdGVtLmxldmVsIHx8IHt9XG4gICAgaWYgKGl0ZW0ubWVyY2hhbnRMZXZlbCA9PSAzKSB7XG4gICAgICAgIGl0ZW0ubGV2ZWwuaWRWaXNpYmxlID0gXCJ2aXNpYmxlXCJcbiAgICAgICAgaXRlbS5sZXZlbC5pZEljb24gPSBcIkBkcmF3YWJsZS9vdGNfbWFya2V0X2Nyb3duX2ljb25cIlxuICAgIH0gZWxzZSBpZiAoaXRlbS5tZXJjaGFudExldmVsID09IDIpIHtcbiAgICAgICAgaXRlbS5sZXZlbC5pZFZpc2libGUgPSBcInZpc2libGVcIlxuICAgICAgICBpdGVtLmxldmVsLmlkSWNvbiA9IFwiQGRyYXdhYmxlL290Y19tYXJrZXRfdl9pY29uXCJcbiAgICB9IGVsc2Uge1xuICAgICAgICBpdGVtLmxldmVsLmlkVmlzaWJsZSA9IFwiZ29uZVwiXG4gICAgICAgIGl0ZW0ubGV2ZWwuaWRJY29uID0gXCJcIlxuICAgIH1cbiAgICAvLyDlpKfmi4fmjIdcbiAgICBpdGVtLnRodW1iVXBEYXRhID0gaXRlbS50aHVtYlVwRGF0YSB8fCB7fVxuICAgIGl0ZW0udGh1bWJVcERhdGEuaWRWaXNpYmxlID0gaXRlbS50aHVtYlVwID09IDAgPyBcImdvbmVcIiA6IFwidmlzaWJsZVwiXG4gICAgaXRlbS50aHVtYlVwRGF0YS5pZEljb24gPSBcIkBkcmF3YWJsZS9vdGNfYWR2ZXJ0X3RodW1iX3VwX2ljb25cIlxuICAgIC8vIOWFs+azqFxuICAgIGl0ZW0uZm9sbG93ID0gaXRlbS5mb2xsb3cgfHwge31cbiAgICBpdGVtLmZvbGxvdy5pZFZpc2libGUgPSBpdGVtLmlzRm9sbG93ZWQgPyBcInZpc2libGVcIiA6IFwiZ29uZVwiXG4gICAgLy8g5Lqk5piT6L+HXG4gICAgaXRlbS50cmFkZWQgPSBpdGVtLnRyYWRlZCB8fCB7fVxuICAgIGl0ZW0udHJhZGVkLmlkVmlzaWJsZSA9IGl0ZW0uaXNUcmFkZSA/IFwidmlzaWJsZVwiIDogXCJnb25lXCJcbiAgICAvLyBpY29uOiDok53nm74gJiDkuqTmmJPov4dcbiAgICBpZiAoY29tbW9uLmNvbW1hbkRhdGEubGFuZ3VhZ2UgPT0gXCJ6aC1jblwiKSB7XG4gICAgICAgIGl0ZW0uYmx1ZVNoaWVsZC5pZEljb24gPSBoYXNCbHVlU2hpZWxkID8gXCJAZHJhd2FibGUvb3RjX2JsdWVfc2hpZWxkX3poX2NuXCIgOiBcIlwiXG4gICAgICAgIGl0ZW0udHJhZGVkLmlkSWNvbiA9IGl0ZW0uaXNUcmFkZSA/IFwiQGRyYXdhYmxlL2xhYmVsX3RyYWRlZF96aF9jblwiIDogXCJcIlxuICAgIH0gZWxzZSBpZiAoY29tbW9uLmNvbW1hbkRhdGEubGFuZ3VhZ2UgPT0gXCJ6aC1oa1wiKSB7XG4gICAgICAgIGl0ZW0uYmx1ZVNoaWVsZC5pZEljb24gPSBoYXNCbHVlU2hpZWxkID8gXCJAZHJhd2FibGUvb3RjX2JsdWVfc2hpZWxkX3poX2hrXCIgOiBcIlwiXG4gICAgICAgIGl0ZW0udHJhZGVkLmlkSWNvbiA9IGl0ZW0uaXNUcmFkZSA/IFwiQGRyYXdhYmxlL2xhYmVsX3RyYWRlZF96aF9oa1wiIDogXCJcIlxuICAgIH0gZWxzZSB7XG4gICAgICAgIGl0ZW0uYmx1ZVNoaWVsZC5pZEljb24gPSBoYXNCbHVlU2hpZWxkID8gXCJAZHJhd2FibGUvb3RjX2JsdWVfc2hpZWxkX290aGVyXCIgOiBcIlwiXG4gICAgICAgIGl0ZW0udHJhZGVkLmlkSWNvbiA9IGl0ZW0uaXNUcmFkZSA/IFwiQGRyYXdhYmxlL2xhYmVsX3RyYWRlZF9lblwiIDogXCJcIlxuICAgIH1cbn1cblxuYXN5bmMgZnVuY3Rpb24gZm9ybWF0Tm9ybWFsQWR2ZXJ0KGl0ZW0pIHtcbiAgICBpdGVtLnR5cGUgPSBcImFkdmVydENlbGxcIlxuICAgIGZvcm1hdEFkdmVydChpdGVtKVxuICAgIGZvcm1hdFVzZXJJZExhYmxlcyhpdGVtKVxuICAgIC8vIOWcqOe6v1xuICAgIGl0ZW0ub25saW5lQ29sb3IgPSBpdGVtLmlzT25saW5lID8gXCIjMDBBMTcxXCIgOiBcIkBjb2xvci9rQ29sb3JGb3VyTGV2ZWxUZXh0XCJcbiAgICAvLyDmiJDljZXph49cbiAgICBpdGVtLnRvdGFsVHJhZGVPcmRlckNvdW50VGV4dCA9IGAkeyRpMThuLm5fb3RjX2Fkc19vcmRlcl9udW1iZXJ9ICR7aXRlbS50b3RhbFRyYWRlT3JkZXJDb3VudH1gXG4gICAgLy8g5a6M5oiQ546HXG4gICAgaXRlbS5vcmRlckNvbXBsZXRlUmF0ZVRleHQgPSBgJHtpdGVtLm9yZGVyQ29tcGxldGVSYXRlfSVgXG4gICAgLy8g5Lqk5piT5oyJ6ZKu5qC35byPXG4gICAgaWYgKGl0ZW0udHJhZGVCdXR0b24udHJhbnNwYXJlbnQpIHtcbiAgICAgICAgaWYgKGl0ZW0udGFrZXJMaW1pdCAmIDEgfHwgaXRlbS50YWtlckxpbWl0ICYgNCkge1xuICAgICAgICAgICAgaXRlbS50cmFkZUJ1dHRvbi50aXRsZUNvbG9yID0gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiXG4gICAgICAgICAgICBpdGVtLnRyYWRlQnV0dG9uLmJhY2tncm91bmRDb2xvciA9IFwiXCJcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGl0ZW0udHJhZGVCdXR0b24udGl0bGVDb2xvciA9IFwiQGNvbG9yL2tDb2xvclNlY29uZGFyeVRleHRcIlxuICAgICAgICAgICAgaXRlbS50cmFkZUJ1dHRvbi5iYWNrZ3JvdW5kQ29sb3IgPSBcIlwiXG4gICAgICAgIH1cbiAgICB9IGVsc2Uge1xuICAgICAgICBpdGVtLnRyYWRlQnV0dG9uLnRpdGxlQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JXaGl0ZVRleHRcIlxuICAgICAgICAvLyBpdGVtLnRyYWRlQnV0dG9uLmJhY2tncm91bmRDb2xvciA9IGl0ZW0udHJhZGVUeXBlID09IDEgPyBcIkBjb2xvci9rQ29sb3JPdGNNYWpvckdyZWVuXCIgOiBcIkBjb2xvci9rQ29sb3JPdGNNYWpvclJlZFwiXG4gICAgICAgIC8vIGFuZHJvaWTkuIrmsqHmnInov5nkuKrlrZfmrrXlrprkuYnvvIzmlLnkuLrnm7TmjqXlhpnoibLlgLxcbiAgICAgICAgaXRlbS50cmFkZUJ1dHRvbi5iYWNrZ3JvdW5kQ29sb3IgPSBpdGVtLnRyYWRlVHlwZSA9PSAxID8gXCIjMDBBMTcxXCIgOiBcIiNFOTQzNTlcIlxuICAgIH1cblxuICAgIC8vIOWVhuWutuWQjeWtl1xuICAgIGl0ZW0ubWVyY2hhbnRWaXNpYmxlID0gaXRlbS5jaGFyZ2VUeXBlID8gXCJnb25lXCIgOiBcInZpc2libGVcIlxuICAgIGl0ZW0uc01lcmNoYW50VmlzaWJsZSA9IGl0ZW0uY2hhcmdlVHlwZSA/IFwidmlzaWJsZVwiIDogXCJnb25lXCJcbiAgICBpZiAoaXRlbS5jaGFyZ2VUeXBlKSB7XG4gICAgICAgIGl0ZW0uc01lcmNoYW50Q29udGVudFdpZHRoID0gYXdhaXQgX2dldFN0cmluZ1dpZHRoKGl0ZW0udXNlck5hbWUsIDE0LCA1MDApICsgMjRcbiAgICB9XG4gICAgcmV0dXJuIGl0ZW1cbn1cblxuYXN5bmMgZnVuY3Rpb24gZm9ybWF0QnJhbmRBZHZlcnQoaXRlbSkge1xuICAgIGZvcm1hdEFkdmVydChpdGVtKVxuICAgIHZhciBhZHZlcnQgPSBpdGVtO1xuICAgIGNvbnNvbGUubG9nKGBpdGVtOiAke2l0ZW19YCk7XG4gICAgLy8g5piv5ZCm5Lqk5piT6L+HXG4gICAgYWR2ZXJ0LnRyYWRlZFZpc2libGUgPSAoaXRlbS5pc1RyYWRlID8/IGZhbHNlKSA/IFwidmlzaWJsZVwiIDogXCJnb25lXCI7XG5cbiAgICAvLyDkuqTmmJPmjInpkq7moLflvI9cbiAgICBpZiAoaXRlbS50cmFkZUJ1dHRvbi50cmFuc3BhcmVudCkge1xuICAgICAgICBpZiAoaXRlbS50YWtlckxpbWl0ICYgMSB8fCBpdGVtLnRha2VyTGltaXQgJiA0KSB7XG4gICAgICAgICAgICBpdGVtLnRyYWRlQnV0dG9uLnRpdGxlQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JNYWpvclRoZW1lMTAwXCJcbiAgICAgICAgICAgIGl0ZW0udHJhZGVCdXR0b24uYmFja2dyb3VuZENvbG9yID0gXCJcIlxuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgaXRlbS50cmFkZUJ1dHRvbi50aXRsZUNvbG9yID0gXCJAY29sb3Iva0NvbG9yU2Vjb25kYXJ5VGV4dFwiXG4gICAgICAgICAgICBpdGVtLnRyYWRlQnV0dG9uLmJhY2tncm91bmRDb2xvciA9IFwiXCJcbiAgICAgICAgfVxuICAgIH0gZWxzZSB7XG4gICAgICAgIGl0ZW0udHJhZGVCdXR0b24udGl0bGVDb2xvciA9IFwiXCJcbiAgICAgICAgaXRlbS50cmFkZUJ1dHRvbi5iYWNrZ3JvdW5kQ29sb3IgPSBcIlwiXG4gICAgfVxuXG4gICAgLy8g5pSv5LuY5pa55byPXG4gICAgYWR2ZXJ0LnBheU1ldGhvZHNKc29uID0gSlNPTi5zdHJpbmdpZnkoaXRlbS5wYXlNZXRob2RzKTtcbiAgICAvLyDnibnmrormoIfnrb5cbiAgICAvLyB0cmFkZVR5cGUgPT0gMSDllYblrrblh7rllK7vvIznlKjmiLfkubDlhaVcbiAgICBpZiAoYWR2ZXJ0LmJsb2NrVHlwZSA9PSA1XG4gICAgICAgICYmIEFycmF5LmlzQXJyYXkoaXRlbS5zcGVjaWFsQnJhbmRMYWJlbHMpICYmIGl0ZW0uc3BlY2lhbEJyYW5kTGFiZWxzLmxlbmd0aCA+IDBcbiAgICApIHtcbiAgICAgICAgYWR2ZXJ0LnNwZWNpYWxMYWJlbEljb24gPSBpdGVtLnNwZWNpYWxCcmFuZExhYmVsc1swXS51cmwgfHwgKGl0ZW0udHJhZGVUeXBlID09IDEgPyBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV90cmFkaW5nX2J1eV9zcGVjaWFsX2xhYmVsXCIgOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV90cmFkaW5nX3NlbGxfc3BlY2lhbF9sYWJlbFwiKTtcbiAgICAgICAgYWR2ZXJ0LnNwZWNpYWxMYWJlbFRleHQgPSBpdGVtLnNwZWNpYWxCcmFuZExhYmVsc1swXS5uYW1lIHx8IFwiXCI7XG4gICAgICAgIC8vIOmcgOimgeaPkOWJjeiuoeeul+a4kOWPmOiDjOaZr+WuveW6plxuICAgICAgICBpZiAoYWR2ZXJ0LnNwZWNpYWxMYWJlbFRleHQubGVuZ3RoID4gMCkge1xuICAgICAgICAgICAgYWR2ZXJ0LnNwZWNpYWxMYWJlbFdpZHRoID0gMTYgKyA2ICsgYXdhaXQgX2dldFN0cmluZ1dpZHRoKGFkdmVydC5zcGVjaWFsTGFiZWxUZXh0LCAxMSwgNTAwKSArIDY7XG4gICAgICAgIH1cbiAgICAgICAgYWR2ZXJ0LnNwZWNpYWxMYWJlbFZpc2libGUgPSBhZHZlcnQuc3BlY2lhbExhYmVsVGV4dC5sZW5ndGggPiAwID8gXCJ2aXNpYmxlXCIgOiBcImdvbmVcIjtcbiAgICB9IGVsc2Uge1xuICAgICAgICBhZHZlcnQuc3BlY2lhbExhYmVsVmlzaWJsZSA9IFwiZ29uZVwiO1xuICAgICAgICBhZHZlcnQuc3BlY2lhbExhYmVsV2lkdGggPSAwO1xuICAgICAgICBhZHZlcnQuc3BlY2lhbExhYmVsSWNvbiA9IFwiXCI7XG4gICAgICAgIGFkdmVydC5zcGVjaWFsTGFiZWxUZXh0ID0gXCJcIjtcbiAgICB9XG5cbiAgICAvLyDmma7pgJrmoIfnrb5cbiAgICBpZiAoQXJyYXkuaXNBcnJheShpdGVtLm5vcm1hbEJyYW5kTGFiZWxzKSAmJiBpdGVtLm5vcm1hbEJyYW5kTGFiZWxzLmxlbmd0aCA+IDApIHtcbiAgICAgICAgdmFyIG5vcm1hbEJyYW5kTGFiZWxzID0gW107XG4gICAgICAgIGZvciAobGV0IGxhYmVsIG9mIGl0ZW0ubm9ybWFsQnJhbmRMYWJlbHMpIHtcbiAgICAgICAgICAgIGlmIChub3JtYWxCcmFuZExhYmVscy5sZW5ndGggPT0gMCkge1xuICAgICAgICAgICAgICAgIG5vcm1hbEJyYW5kTGFiZWxzLnB1c2goeyB0eXBlOiBcInRhZ1wiLCBib3JkZXJXaWR0aDogMCwgYmFja2dyb3VuZDogXCJAY29sb3Iva090Y0JyYW5kVHJhZGVUYWdCZ0NvbG9yXCIsIHRleHRTaXplOiBcIjExXCIsIHRleHRDb2xvcjogXCJAY29sb3Iva090Y0JyYW5kVHJhZGVUYWdUZXh0Q29sb3IxXCIsIC4uLmxhYmVsIH0pO1xuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICBub3JtYWxCcmFuZExhYmVscy5wdXNoKHsgdHlwZTogXCJ0YWdcIiwgYm9yZGVyV2lkdGg6IDAuNSwgYmFja2dyb3VuZDogXCIjMDAwMDAwMDBcIiwgdGV4dFNpemU6IFwiMTBcIiwgdGV4dENvbG9yOiBcIkBjb2xvci9rT3RjQnJhbmRUcmFkZVRhZ1RleHRDb2xvcjJcIiwgLi4ubGFiZWwgfSk7XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICAgICAgYWR2ZXJ0Lm5vcm1hbEJyYW5kTGFiZWxzID0gbm9ybWFsQnJhbmRMYWJlbHM7XG4gICAgICAgIGFkdmVydC5ub3JtYWxMYWJlbFZpc2libGUgPSBcInZpc2libGVcIjtcbiAgICAgICAgYWR2ZXJ0Lm5vcm1hbEJvdHRvbU9mZnNldCA9IGNvbW1vbi5jb21tYW5EYXRhLk9TID09IDAgPyA2IDogMDtcbiAgICB9IGVsc2Uge1xuICAgICAgICBhZHZlcnQubm9ybWFsTGFiZWxWaXNpYmxlID0gXCJnb25lXCI7XG4gICAgICAgIGFkdmVydC5ub3JtYWxCcmFuZExhYmVscyA9IFtdO1xuICAgICAgICBhZHZlcnQubm9ybWFsQm90dG9tT2Zmc2V0ID0gMDtcbiAgICB9XG4gICAgYWR2ZXJ0LnR5cGUgPSBcImJyYW5kXCI7XG4gICAgcmV0dXJuIGFkdmVydFxufVxuXG4vLyDojrflj5blrZfnrKbkuLLlrr3luqZcbmFzeW5jIGZ1bmN0aW9uIF9nZXRTdHJpbmdXaWR0aChzdHIsIGZvbnRTaXplLCBmb250V2VpZ2h0KSB7XG4gICAgdHJ5IHtcbiAgICAgICAgY29uc3Qgc2l6ZUluZm8gPSBhd2FpdCAkbmF0aXZlQVBJLnAycEZpbHRlckJyaWRnZSh7XG4gICAgICAgICAgICBhY3Rpb246IFwibWVzdXJlU2l6ZU9mU3RyaW5nXCIsXG4gICAgICAgICAgICBwYXJhbXM6IHsgdGV4dDogc3RyLCBmb250U2l6ZTogZm9udFNpemUsIGZvbnRXZWlnaHQ6IGZvbnRXZWlnaHQgfSxcbiAgICAgICAgfVxuICAgICAgICApXG4gICAgICAgIGNvbnN0IG9iaiA9IEpTT04ucGFyc2Uoc2l6ZUluZm8pXG4gICAgICAgIGNvbnN0IHsgd2lkdGg6IHdpZHRoLCBoZWlnaHQ6IGhlaWdodCB9ID0gb2JqXG4gICAgICAgIHJldHVybiB3aWR0aFxuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5sb2coYG1lc3VyZVNpemVPZlN0cmluZyBlcnJvcjogJHtlfWApO1xuICAgICAgICByZXR1cm4gMFxuICAgIH1cbn1cblxuLyoqXG4g54K55Ye75ZWG5a625ZCN56ewXG4gKi9cbm1vZHVsZUV2ZW50Lm9uQ2xpY2tNZXJjaGFudE5hbWUgPSBmdW5jdGlvbiAodWlkKSB7XG4gICAgJG5hdGl2ZUFQSS5wMnBGaWx0ZXJCcmlkZ2UoeyBhY3Rpb246IFwiZ29NZXJjaGFudEhvbWVcIiwgcGFyYW1zOiBgJHt1aWR9YCB9KTtcbn1cblxuLyoqXG4g54K55Ye76aqM6K+B5Y2VXG4gKi9cbm1vZHVsZUV2ZW50Lm9uQ2xpY2tWZXJpZnlDYXBpdGFsID0gZnVuY3Rpb24gKGluZGV4KSB7XG4gICAgdmFyIGl0ZW0gPSBkYXRhSGVscGVyLmdldERhdGFzKGNvbmZpZy5jdXJyZW50U2l0ZVR5cGUpW2luZGV4XVxuICAgIGlmIChpdGVtICYmIGl0ZW0udmVyaWZ5Q2FwaXRhbFN0YXR1cyA9PSAxKSB7XG4gICAgICAgIFZlcmlmeUNhcGl0YWwucG9wVmVyaWZ5VGlwKGNvbmZpZy5jdXJyZW5jeU5hbWUpXG4gICAgfVxufVxuXG5tb2R1bGVFdmVudC5vbkNsaWNrVHJhZGVPcGVyYXRpb24gPSBmdW5jdGlvbiAoaW5kZXgpIHtcbiAgICBjb25zdCBzaXRUeXBlID0gY29uZmlnLmN1cnJlbnRTaXRlVHlwZVxuICAgIHZhciBpdGVtID0gZGF0YUhlbHBlci5nZXREYXRhcyhzaXRUeXBlKVtpbmRleF1cbiAgICBpZiAoaXRlbSkge1xuICAgICAgICBpZiAoaXRlbS50YWtlckxpbWl0ICYgMiB8fCBpdGVtLnRha2VyTGltaXQgJiA0KSB7XG4gICAgICAgICAgICAvLyDpnIDopoHpq5jnuqforqTor4FcbiAgICAgICAgICAgIGNvbW1vbi5vcGVuVVJMKFwiaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9hY2NvdW50L2t5Yz9hdXRoQml6Q29kZT1PVENcIilcbiAgICAgICAgfSBlbHNlIGlmIChpdGVtLnRha2VyTGltaXQgJiAxKSB7XG4gICAgICAgICAgICAvLyDnu5HlrprmiYvmnLpcbiAgICAgICAgICAgIGlmIChjb21tb24uY29tbWFuRGF0YS5PUyA9PSAwKSB7XG4gICAgICAgICAgICAgICAgY29tbW9uLm9wZW5VUkwoXCJob2xpZ2VpdDovL29wZW4vdjE/bG9naW49MSZ1cmw9aWh1b2JpZ2xvYmFsOi8vbS5oYmcuY29tL3NlY3VyaXR5Q2VudGVyL2JpbmRQaG9uZVwiKVxuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICAvL+e7keWumuaJi+aculxuICAgICAgICAgICAgICAgICRuYXRpdmVBUEkucDJwRmlsdGVyQnJpZGdlKHtcbiAgICAgICAgICAgICAgICAgICAgYWN0aW9uOiBcIm9uU3dpdGNoUGFnZVwiLFxuICAgICAgICAgICAgICAgICAgICBwYXJhbXM6IHtcbiAgICAgICAgICAgICAgICAgICAgICAgIHRhcmdldDogXCJ0b0JpbmRQaG9uZVwiLFxuICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgfSlcbiAgICAgICAgICAgIH1cbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIC8vIOWOu+S4i+WNlVxuICAgICAgICAgICAgJG5hdGl2ZUFQSS5wMnBGaWx0ZXJCcmlkZ2Uoe1xuICAgICAgICAgICAgICAgIGFjdGlvbjogXCJvblN3aXRjaFBhZ2VcIixcbiAgICAgICAgICAgICAgICBwYXJhbXM6IHtcbiAgICAgICAgICAgICAgICAgICAgdGFyZ2V0OiBcInRvQ3JlYXRlT3JkZXJcIixcbiAgICAgICAgICAgICAgICAgICAgcGFyYW1zOiBKU09OLnN0cmluZ2lmeShpdGVtKVxuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH0pXG4gICAgICAgIH1cblxuICAgICAgICAvLyDln4vngrkgLSDotK3kubAv5Ye65ZSuXG4gICAgICAgIGNvbW1vbi5hbmFseXRpY3Moc2l0VHlwZSA9PSBTaXRlVHlwZS5CUkFORCA/IFwib3RjX3AycF9hZGxpc3RfYnJhbmRcIiA6IFwib3RjX3AycF9hZGxpc3RcIiwge1xuICAgICAgICAgICAgXCJvdGNfc3RlcFwiOiBcImNsaWNrX3F1b3RlXCIsXG4gICAgICAgICAgICBcInNwbVwiOiBpdGVtLnRyYWRlVHlwZSA9PSAwID8gXCJvdGMuYWRsaXN0LnBhZ2Uuc2VsbFwiIDogXCJvdGMuYWRsaXN0LnBhZ2UuYnV5XCIsXG4gICAgICAgICAgICBcInNpZGVcIjogYWR2ZXJ0RmlsdGVyLmdldFRyYWRlVHlwZSgpLFxuICAgICAgICAgICAgXCJjb2luX25hbWVcIjogY29uZmlnLnRhcmdldC5jb2luTmFtZSxcbiAgICAgICAgICAgIFwicGF5bWVudFwiOiBhZHZlcnRGaWx0ZXIuZ2V0UGF5bWVudCgpLFxuICAgICAgICB9KVxuICAgIH1cbn1cblxubW9kdWxlRXZlbnQub25DbGlja01vcmUgPSAoaW5kZXgpID0+IHtcbiAgICBjb25zdCBzaXRUeXBlID0gY29uZmlnLmN1cnJlbnRTaXRlVHlwZVxuICAgIHZhciBpdGVtID0gZGF0YUhlbHBlci5nZXREYXRhcyhzaXRUeXBlKVtpbmRleF1cbiAgICBpdGVtLmV4cGFuZEFyZWFWaXNpYmlsaXR5ID0gaXRlbS5leHBhbmRBcmVhVmlzaWJpbGl0eSA9PT0gXCJnb25lXCIgPyBcInZpc2libGVcIiA6IFwiZ29uZVwiO1xuICAgIGRhdGFIZWxwZXIucmVmcmVzaExpc3Qoc2l0VHlwZSlcbn1cblxubW9kdWxlRXZlbnQub25DbGlja0ZvbGxvdyA9IGFzeW5jIChpbmRleCkgPT4ge1xuICAgIGNvbnN0IHNpdFR5cGUgPSBjb25maWcuY3VycmVudFNpdGVUeXBlXG4gICAgdmFyIGl0ZW0gPSBkYXRhSGVscGVyLmdldERhdGFzKHNpdFR5cGUpW2luZGV4XVxuICAgIGlmIChpdGVtICYmICFpdGVtLmlzRm9sbG93ZWQpIHtcbiAgICAgICAgLy8g5o6l5Y+j5pu05pawXG4gICAgICAgIHZhciB1cmwgPSBgdjEvdXNlci9yZWxhdGlvbi9jaGFuZ2UvJHtpdGVtLnVpZH0/dHlwZT1mb2xsb3cmcmVsYXRpb25TdGF0dXM9b25gXG4gICAgICAgIHZhciB7IGNvZGUsIG1lc3NhZ2UgfSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdCh1cmwsIHt9LCAxLCAxLCB7fSlcbiAgICAgICAgaWYgKGNvZGUgPT0gMjAwKSB7XG4gICAgICAgICAgICBpdGVtLmlzRm9sbG93ZWQgPSB0cnVlXG4gICAgICAgICAgICBpdGVtLmZvbGxvdy5pZFZpc2libGUgPSBpdGVtLmlzRm9sbG93ZWQgPyBcInZpc2libGVcIiA6IFwiZ29uZVwiXG4gICAgICAgICAgICBpdGVtLmZvbGxvdy50aXRsZSA9IGl0ZW0uaXNGb2xsb3dlZCA/ICRpMThuLm5fdGl0bGVfZm9sbG93ZWRfbWVyY2hhbnQgOiAkaTE4bi5uX3RpdGxlX2ZvbGxvd19tZXJjaGFudFxuICAgICAgICAgICAgaXRlbS5mb2xsb3cuaWNvbiA9IGl0ZW0uaXNGb2xsb3dlZCA/IFwiQGRyYXdhYmxlL3N0YXJfeWVsbG93X2NvbW1vblwiIDogXCJAZHJhd2FibGUvYWR2ZXJ0X2ZvbGxvd1wiXG4gICAgICAgICAgICBkYXRhSGVscGVyLnJlZnJlc2hMaXN0KHNpdFR5cGUpXG4gICAgICAgICAgICAkbmF0aXZlQVBJLmhiVG9hc3QoJGkxOG4ubl90aXRsZV9vcGVyYXRlX3N1Y2Nlc3MpO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgJG5hdGl2ZUFQSS5oYlRvYXN0KCghbWVzc2FnZSB8fCBtZXNzYWdlLmxlbmd0aCA9PSAwKSA/ICRpMThuLm5fY2hlY2tfbmV0d29yayA6IG1lc3NhZ2UpO1xuICAgICAgICB9XG4gICAgfVxufVxuXG5tb2R1bGVFdmVudC5vbkNsaWNrVG9EZXBvc2l0ID0gZnVuY3Rpb24gKCkge1xuICAgIGlmIChjb21tb24uY29tbWFuRGF0YS5PUyA9PSAwKSB7XG4gICAgICAgIGNvbW1vbi5vcGVuVVJMKFwiaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9iYWxhbmNlL2RlcG9zaXRTZWFyY2hcIilcbiAgICB9IGVsc2Uge1xuICAgICAgICBjb21tb24ub3BlblVSTChcImhvbGlnZWl0Oi8vb3Blbi92MT9sb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vYmFsYW5jZS9kZXBvc2l0U2VhcmNoP2V4dHJhX3R5cGU9MSZleHRyYV9mcm9tPTBcIilcbiAgICB9XG59XG5cbm1vZHVsZUV2ZW50Lm9uQ2xpY2tUb1N0cmljdFNlbGVjdGlvbiA9IGZ1bmN0aW9uIChpbmRleCkge1xuICAgICRuYXRpdmVBUEkucDJwRmlsdGVyQnJpZGdlKHsgYWN0aW9uOiBcInRvU3RyaWN0U2VsZWN0aW9uXCIgfSk7XG59XG5cbm1vZHVsZUV2ZW50Lm9uQ2xpY2tTZWF2aWV3Um9vbSA9IGZ1bmN0aW9uICgpIHtcbiAgICAvLyDmraTmrKHlvoXkvJjljJbvvIxjb25maWcudHJhZGVUeXBl5ZCO6Z2i6ZyA6KaB5ouG5YiGXG4gICAgbGV0IHRyYWRlVHlwZSA9IGFkdmVydEZpbHRlci5nZXRUcmFkZVR5cGUoKVxuICAgICRuYXRpdmVBUEkucDJwRmlsdGVyQnJpZGdlKHtcbiAgICAgICAgYWN0aW9uOiBcIm9uU3dpdGNoUGFnZVwiLFxuICAgICAgICBwYXJhbXM6IHtcbiAgICAgICAgICAgIHRhcmdldDogXCJ0b1NlYXZpZXdSb29tXCIsXG4gICAgICAgICAgICBwYXJhbXM6IEpTT04uc3RyaW5naWZ5KHtcbiAgICAgICAgICAgICAgICAuLi5jb25maWcubm9ybWFsLFxuICAgICAgICAgICAgICAgIHRyYWRlVHlwZTogdHJhZGVUeXBlXG4gICAgICAgICAgICB9KVxuICAgICAgICB9XG4gICAgfSlcblxuICAgIC8v5Z+L54K5IC0g6L+b5YWl5rW35pmv5oi/XG4gICAgY29tbW9uLmFuYWx5dGljcyhcIm90Y19wMnBfYWRsaXN0XCIsIHtcbiAgICAgICAgXCJvdGNfc3RlcFwiOiBcIm90Y19wMnBfdGh1bWJzVXBfY2xpY2tcIixcbiAgICAgICAgXCJzaWRlXCI6IHRyYWRlVHlwZSxcbiAgICAgICAgXCJjb2luX25hbWVcIjogY29uZmlnLnRhcmdldC5jb2luTmFtZSxcbiAgICB9KVxufVxuXG5tb2R1bGVFdmVudC5vbkdyZWF0ZUFkdmVydCA9IGZ1bmN0aW9uICgpIHtcbiAgICAkbmF0aXZlQVBJLnAycEZpbHRlckJyaWRnZSh7XG4gICAgICAgIGFjdGlvbjogXCJvblN3aXRjaFBhZ2VcIixcbiAgICAgICAgcGFyYW1zOiB7XG4gICAgICAgICAgICB0YXJnZXQ6IFwidG9HcmVhdGVBZHZlcnRcIixcbiAgICAgICAgICAgIHBhcmFtczogXCJcIlxuICAgICAgICB9XG4gICAgfSlcbn1cblxubW9kdWxlRXZlbnQucmVmcmVzaEFkdmVydExpc3QgPSBmdW5jdGlvbiAoaW5kZXgpIHtcbiAgICByZWZyZXNoQWR2ZXJ0TGlzdChpbmRleCA9PSAwID8gU2l0ZVR5cGUuQlJBTkQgOiBTaXRlVHlwZS5OT1JNQUwpXG59XG5tb2R1bGVFdmVudC5sb2FkTW9yZUFkdmVydExpc3QgPSBmdW5jdGlvbiAoaW5kZXgpIHtcbiAgICBsb2FkTW9yZUFkdmVydExpc3QoaW5kZXggPT0gMCA/IFNpdGVUeXBlLkJSQU5EIDogU2l0ZVR5cGUuTk9STUFMKVxufSBcbiIsIlxuaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vbi5qc1wiXG5pbXBvcnQge2NvbmZpZ30gIGZyb20gXCIuL2NvbmZpZy5qc1wiXG5cbmNvbnN0IHsgbW9kdWxlRGF0YSwgbW9kdWxlRXZlbnQgfSA9IGNvbW1vbi5tb2R1bGVEZWZpbmUoXG4gICAgXCJyaXNrQ29udHJvbFwiLFxuICAgICgpPT57fSxcbiAgICBkZWZhdWx0RGF0YVxuKTtcblxuY29uc3Qgcmlza0luZm9Nb2RlbCA9IHtcbiAgICB0aXRsZTogXCJcIixcbiAgICBjb250ZW50OiBcIlwiLFxuICAgIHRhZzogW10sXG4gICAgYnV0dG9uOiB7bmFtZTogXCJcIn0sXG59XG5cbmZ1bmN0aW9uIGRlZmF1bHREYXRhKCkge1xuICAgIHJldHVybiB7XG4gICAgICAgIHBvcFN0YXRlOiB7XG4gICAgICAgICAgICBpc1Nob3dpbmc6IFwiZmFsc2VcIixcbiAgICAgICAgICAgIHRpdGxlOiBcIlwiLFxuICAgICAgICAgICAgY29udGVudDogXCJcIixcbiAgICAgICAgICAgIGNoZWNrVGV4dDogXCJcIixcbiAgICAgICAgICAgIGJ1dHRvblRpdGxlOiAkaTE4bi5uX290Y19rbm93LFxuICAgICAgICB9LFxuICAgICAgICBjYW5TaG93UmlzazogdHJ1ZSxcbiAgICAgICAgY3VycmVuY3lOYW1lOiBcIlwiLFxuICAgICAgICBzaG93QWxlcnRDYWNoZToge31cbiAgICB9O1xufVxuXG5hc3luYyBmdW5jdGlvbiBnZXRSaXNrSW5mb0J5Q3VycmVuY3lOYW1lKGN1cnJlbmN5TmFtZSkge1xuICAgIGNvbnN0IHBhcmFtcyA9IHtcbiAgICAgICAgXCJmYWN0b3JcIjoge1xuICAgICAgICAgICAgXCJhcHBQYWdlSWRcIjogNTAsXG4gICAgICAgICAgICBcImV2ZW50SWRcIjogNDM1NTkzLFxuICAgICAgICAgICAgXCJjdXJyZW5jeUFzc2V0TmFtZVwiOiBjdXJyZW5jeU5hbWUudG9VcHBlckNhc2UoKSxcbiAgICAgICAgfVxuICAgIH1cbiAgICBjb25zdCByZXNwb25zZSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdChcInYxL3Jpc2svcGFnZS9lbGVtZW50XCIscGFyYW1zLDEsMSx7XCJDb250ZW50LVR5cGVcIjogXCJhcHBsaWNhdGlvbi9qc29uXCJ9KTtcbiAgICBjb25zb2xlLmxvZyhcInJpc2tDb250cm9sIGxvYWRlZCBzdWNjZXNzZnVsbHk6XCIsIHJlc3BvbnNlKTtcbiAgICByZXR1cm4gKHJlc3BvbnNlICYmIHJlc3BvbnNlLmRhdGEpID8gey4uLnJpc2tJbmZvTW9kZWwsIC4uLnJlc3BvbnNlLmRhdGF9IDogbnVsbDtcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGNoZWNrRm9yQ3VycmVuY3lJZk5lZWRlZCgpIHtcbiAgICBpZiAobW9kdWxlRGF0YS5jYW5TaG93UmlzayAmJiBjb25maWcuY3VycmVuY3lOYW1lICYmIGNvbmZpZy5jdXJyZW5jeU5hbWUgIT0gbW9kdWxlRGF0YS5jdXJyZW5jeU5hbWUpIHtcbiAgICAgICAgaGFuZGxlQ3VyZW5jeUNoYW5nZShjb25maWcuY3VycmVuY3lOYW1lKVxuICAgIH0gZWxzZSB7XG4gICAgICAgIGNvbnNvbGUubG9nKFwicmlza0NvbnRyb2wuY2hlY2tGb3JDdXJyZW5jeUlmTmVlZGVkOlwiLCBjb25maWcuY3VycmVuY3lOYW1lLCBtb2R1bGVEYXRhLmN1cnJlbmN5TmFtZSk7XG4gICAgfVxufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gaGFuZGxlQ3VyZW5jeUNoYW5nZShjdXJyZW5jeU5hbWUpIHtcbiAgICBpZiAobW9kdWxlRGF0YS5wb3BTdGF0ZS5pc1Nob3dpbmcgPT0gXCJ0cnVlXCIpe1xuICAgICAgICByZXR1cm5cbiAgICB9XG4gICAgbW9kdWxlRGF0YS5jdXJyZW5jeU5hbWUgPSBjdXJyZW5jeU5hbWU7XG4gICAgXG4gICAgaWYgKG1vZHVsZURhdGEuc2hvd0FsZXJ0Q2FjaGVbY3VycmVuY3lOYW1lXSA9PSB0cnVlKXtcbiAgICAgICAgcmV0dXJuXG4gICAgfVxuXG4gICAgY29uc3Qgcmlza0luZm8gPSBhd2FpdCBnZXRSaXNrSW5mb0J5Q3VycmVuY3lOYW1lKGN1cnJlbmN5TmFtZSlcbiAgICBpZiAocmlza0luZm8gIT0gdW5kZWZpbmVkICYmIHJpc2tJbmZvLnRpdGxlLmxlbmd0aCAmJiByaXNrSW5mby5jb250ZW50Lmxlbmd0aCkge1xuICAgICAgICBtb2R1bGVEYXRhLnNob3dBbGVydENhY2hlW2N1cnJlbmN5TmFtZV0gPSB0cnVlXG4gICAgICAgIG1vZHVsZURhdGEucG9wU3RhdGUuY29udGVudCA9IHJpc2tJbmZvLmNvbnRlbnRcbiAgICAgICAgbW9kdWxlRGF0YS5wb3BTdGF0ZS5idXR0b25UaXRsZSA9IHJpc2tJbmZvLmJ1dHRvbi5uYW1lLmxlbmd0aCA/IHJpc2tJbmZvLmJ1dHRvbi5uYW1lIDogJGkxOG4ubl9jb3B5X3RyYWRpbmdfbWVfa25vd1xuICAgICAgICBtb2R1bGVEYXRhLnBvcFN0YXRlLnRpdGxlID0gcmlza0luZm8udGl0bGVcbiAgICAgICAgbW9kdWxlRGF0YS5wb3BTdGF0ZS5jaGVja1RleHQgPSByaXNrSW5mby50YWdbMF0gfHwgXCJcIlxuICAgICAgICBtb2R1bGVEYXRhLnBvcFN0YXRlLmlzU2hvd2luZyA9IFwidHJ1ZVwiXG4gICAgfVxufVxuXG5leHBvcnQgZnVuY3Rpb24gc2V0Q2FuU2hvd1Jpc2soY2FuU2hvdykge1xuICAgIG1vZHVsZURhdGEuY2FuU2hvd1Jpc2sgPSBjYW5TaG93XG59XG5cbm1vZHVsZUV2ZW50LnBvcERpc21pc3MgPSBmdW5jdGlvbiAoKSB7XG4gICAgY29uc29sZS5sb2coXCJwb3AgZGlzbWlzc1wiKTtcbiAgICAkZGF0YS5yaXNrQ29udHJvbC5wb3BTdGF0ZS5pc1Nob3dpbmcgPSBcImZhbHNlXCI7XG59IiwiaW1wb3J0IHsgY29uZmlnLCBTaXRlVHlwZSB9IGZyb20gJy4vY29uZmlnLmpzJztcbmltcG9ydCAqIGFzIGNvbW1vbiBmcm9tICcuL2NvbW1vbi5qcyc7XG5pbXBvcnQgKiBhcyBhZHZlcnRGaWx0ZXIgZnJvbSAnLi9hZHZlcnRGaWx0ZXIuanMnO1xuaW1wb3J0ICogYXMgYmFubmVyIGZyb20gJy4vYmFubmVyLmpzJztcbmltcG9ydCAqIGFzIG1haW5UYWIgZnJvbSAnLi9tYWluVGFiLmpzJztcbmltcG9ydCAqIGFzIGFkdmVydExpc3QgZnJvbSAnLi9hZHZlcnRMaXN0LmpzJztcbmltcG9ydCAqIGFzIHJpc2tDb250cm9sIGZyb20gJy4vcmlza0NvbnRyb2wuanMnO1xuXG5cbi8vIOi4qeWdkeWIhuS6q1xuLy8gMS4g5YaF6YOo6LCD55So5pa55rOV5ZCN5Y2D5LiH5LiN6KaB5LiO5aSW6YOo6LCD55So5pa55rOV5ZCN5ZCM5ZCN77yM5Lya6Zm35YWl5b6q546v6LCD55SoXG4vLyBlZzogJGV2ZW50Lnh4eCA9IGZ1bmN0aW9uKCl7XG4vLyAgICAgICAgYWEueHh4KClcbi8vICAgICB9XG5cbmNvbnN0IGRpdmVyc2lvbkhlbHBlciA9IHtcbiAgICBtb2R1bGU6IFwicDJwLWNvbmZpZ1wiLFxuICAgIGdldCBjYWNoZUtleSgpIHtcbiAgICAgICAgcmV0dXJuIGBjb20ucDJwLWRpdmVyc2lvbi4ke2NvbW1vbi5jb21tYW5EYXRhLnVpZH1gXG4gICAgfSxcbiAgICBhc3luYyBnZXRTaXRlKCkge1xuICAgICAgICAvLyDlpoLmnpzkuLrkuK3mlofnmoTpu5jorqTpgInkuK3lk4HniYznq5lcbiAgICAgICAgaWYgKGNvbW1vbi5jb21tYW5EYXRhLmxhbmd1YWdlLnRvTG93ZXJDYXNlKCkgPT0gXCJ6aC1jblwiKSB7XG4gICAgICAgICAgICByZXR1cm4gU2l0ZVR5cGUuQlJBTkRcbiAgICAgICAgfVxuICAgICAgICAvLyDliIbmtYFcbiAgICAgICAgdmFyIGNvbnRlbnQgPSBhd2FpdCBjb21tb24ucmVhZCh0aGlzLm1vZHVsZSwgdGhpcy5jYWNoZUtleSlcbiAgICAgICAgaWYgKGNvbnRlbnQgPT0gbnVsbCkge1xuICAgICAgICAgICAgLy8ge1wic3VjY2Vzc1wiOnRydWUsXCJjb2RlXCI6MjAwLFwibWVzc2FnZVwiOlwi5oiQ5YqfXCIsXCJkYXRhXCI6e1wiZ3JheUVuYWJsZVwiOm51bGwsXCJzaG93UGFnZVwiOlwiTk9NQUxcIixcImdyYXlSZXRcIjpudWxsfSxcImV4dGVuZFwiOm51bGx9XG4gICAgICAgICAgICB2YXIgcmVzID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KFwidjEvdHJhZGUvc2lkZS9kaXZlcnNpb25cIilcbiAgICAgICAgICAgIGlmIChyZXMgJiYgcmVzLmRhdGEgJiYgcmVzLmRhdGEuc2hvd1BhZ2UpIHtcbiAgICAgICAgICAgICAgICBjb250ZW50ID0gcmVzLmRhdGEuc2hvd1BhZ2VcbiAgICAgICAgICAgICAgICBjb21tb24uc2F2ZSh0aGlzLm1vZHVsZSwgdGhpcy5jYWNoZUtleSwgcmVzLmRhdGEuc2hvd1BhZ2UpLnRoZW4oKF8pID0+IHsgfSk7XG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgIC8vIOm7mOiupOWIh+WIsOWTgeeJjOermVxuICAgICAgICAgICAgICAgIGNvbnRlbnQgPSBcIkJSQU5EXCJcbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgICAgICB2YXIgc2l0ZSA9IGNvbnRlbnQgPT0gXCJOT01BTFwiID8gU2l0ZVR5cGUuTk9STUFMIDogU2l0ZVR5cGUuQlJBTkRcbiAgICAgICAgcmV0dXJuIHNpdGVcbiAgICB9LFxuICAgIHVwZGF0ZVNpdGUodHlwZSkge1xuICAgICAgICB2YXIgZGl2ZXJzaW9uID0gdHlwZSA9PSBTaXRlVHlwZS5OT1JNQUwgPyBcIk5PTUFMXCIgOiBcIkJSQU5EXCJcbiAgICAgICAgY29tbW9uLnNhdmUodGhpcy5tb2R1bGUsIHRoaXMuY2FjaGVLZXksIGRpdmVyc2lvbikudGhlbigoXykgPT4geyB9KTtcbiAgICB9XG59XG5cbi8vID09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09XG4kZXZlbnQucGFnZVdpbGxBcHBlYXIgPSBhc3luYyBmdW5jdGlvbiAoKSB7XG4gICAgLy/ln4vngrkgLSDlub/lkYrliJfooajmm53lhYlcbiAgICBjb21tb24uYW5hbHl0aWNzKGNvbmZpZy5jdXJyZW50U2l0ZVR5cGUgPT0gU2l0ZVR5cGUuQlJBTkQgPyBcIm90Y19wMnBfYWRsaXN0X2JyYW5kXCIgOiBcIm90Y19wMnBfYWRsaXN0XCIsIHtcbiAgICAgICAgXCJvdGNfc3RlcFwiOiBcInZpZXdcIixcbiAgICAgICAgXCJzcG1cIjogXCJvdGMuYWRsaXN0LnBhZ2Uudmlld1wiLFxuICAgICAgICBcInNpZGVcIjogYWR2ZXJ0RmlsdGVyLmdldFRyYWRlVHlwZSgpLFxuICAgICAgICBcImNvaW5fbmFtZVwiOiBjb25maWcudGFyZ2V0LmNvaW5OYW1lLFxuICAgICAgICBcImFtb3VudFwiOiBhZHZlcnRGaWx0ZXIuZ2V0QW1vdW50KCksXG4gICAgfSlcbn1cblxuJGV2ZW50LnBhZ2VXaWxsRGlzYXBwZWFyID0gYXN5bmMgZnVuY3Rpb24gKCkge1xuICAgIGNvbnNvbGUubG9nKFwicGFnZVdpbGxEaXNhcHBlYXIgPT09PT09PT09XCIpXG59XG5cbiRldmVudC5tb2R1bGVXaWxsQXBwZWFyID0gYXN5bmMgZnVuY3Rpb24gKCkge1xuICAgIGNvbnNvbGUubG9nKFwibW9kdWxlV2lsbEFwcGVhciA9PT09PT09PT1cIilcbiAgICByaXNrQ29udHJvbC5zZXRDYW5TaG93Umlzayh0cnVlKVxuICAgIHJpc2tDb250cm9sLmNoZWNrRm9yQ3VycmVuY3lJZk5lZWRlZCgpO1xuICAgIGlmIChjb25maWcuY3VycmVudFNpdGVUeXBlICE9PSB1bmRlZmluZWQpIHtcbiAgICAgICAgYWR2ZXJ0RmlsdGVyLmxvYWRUcmFkZVRpcHNJbmZvKCk7XG4gICAgfVxufVxuXG4kZXZlbnQubW9kdWxlV2lsbERpc2FwcGVhciA9IGFzeW5jIGZ1bmN0aW9uICgpIHtcbiAgICBjb25zb2xlLmxvZyhcIm1vZHVsZVdpbGxEaXNhcHBlYXIgPT09PT09PT09XCIpXG4gICAgcmlza0NvbnRyb2wuc2V0Q2FuU2hvd1Jpc2soZmFsc2UpXG59XG5cbi8vID09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09XG5cbiRldmVudC5zZW5kQ29tbW9uQ29uZmlnID0gZnVuY3Rpb24gKHBhcmFtKSB7XG4gICAgdmFyIHZhaWxkUGFyYW1zID0gY29tbW9uLnBhcnNlUmVxdWVzdFBhcmFtcyhwYXJhbSlcbiAgICBjb25zb2xlLmxvZyhKU09OLnN0cmluZ2lmeSh2YWlsZFBhcmFtcykpXG4gICAgY29tbW9uLnBhcnNlQ29tbW9uQ29uZmlnKHZhaWxkUGFyYW1zKVxufVxuXG4vLyA9PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PVxuXG4vLyDliIfmjaLmlrnlkJHlkI7liLfmlrDlub/lkYrliJfooahcbiRldmVudC5yZWZyZXNoQWR2ZXJ0TGlzdFdpdGhUcmFkZVR5cGUgPSBhc3luYyAodHJhZGVUeXBlKSA9PiB7XG4gICAgY29uZmlnLnRyYWRlVHlwZSA9IHRyYWRlVHlwZVxuICAgIC8vIOaOpeWPo+ivt+axguaYr+WPjeaWueWQkVxuICAgIC8vIOS5sOWNluaWueWQkeWIh+aNouWQju+8jG5hdGl2ZemhtemdouWIh+aNouS8muiwg+eUqHVwZGF0ZVRyYWRpbmdQYWlyc+i/m+ihjOabtOaWsO+8jOatpOaXtuWPqumcgOimgeabtOaWsOivt+axguWPguaVsOWNs+WPr1xuICAgIGFkdmVydExpc3QudXBkYXRlQWR2ZXJ0TGlzdFdpdGhGaWx0ZXJQYXJhbXNOb1JlcXVlc3QoeyB0cmFkZVR5cGU6IHRyYWRlVHlwZSA9PSBcImJ1eVwiID8gXCJzZWxsXCIgOiBcImJ1eVwiIH0pXG59XG5cbi8vIOWIh+aNouaWueWQkeWQjuWIt+aWsOW5v+WRiuWIl+ihqFxuJGV2ZW50LnJlZnJlc2hBZHZlcnRMaXN0V2l0aFRyYWRhYmxlID0gKG9ubHlUcmFkYWJsZSkgPT4ge1xuICAgIGFkdmVydExpc3QudXBkYXRlQWR2ZXJ0TGlzdFdpdGhGaWx0ZXJQYXJhbXMoeyBvbmx5VHJhZGFibGUgfSlcbn1cblxuLy8gPT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT1cbi8vIOWIt+WumumUmueCuS3llYblrrblhbPms6jnirbmgIHlj5jljJZcbi8vIHtcInR5cGVcIjogXCJzaGllbGRcIiwgXCJyZWxhdGlvblN0YXR1c1wiOiBcIm9uZVwiLCBcInVpZFwiOiAyMzQyM31cbiRldmVudC5vbk1lcmNoYW50QXR0ZW50aW9uQ2hhbmdlZCA9IGZ1bmN0aW9uIChyZXF1ZXN0SnNvbikge1xuICAgIHZhciBwYXJhbSA9IGNvbW1vbi5wYXJzZVJlcXVlc3RQYXJhbXMocmVxdWVzdEpzb24pO1xuICAgIGFkdmVydExpc3QudXBkYXRlTGlzdFdpdGhGb2xsb3dTdGF0dXNDaGFuZ2VkKGNvbmZpZy5jdXJyZW50U2l0ZVR5cGUsIHBhcmFtKVxufVxuXG4vLyDliLflrprplJrngrkt5LiL5Y2V6aG15Lu35qC85Y+Y5YyWXG4vLyB7XCJhZHZlcnRJZFwiOiBcIjIzNDIzNFwiLCBcInByaWNlXCI6IFwiNy4xMlwifVxuJGV2ZW50Lm9uQWR2ZXJ0UHJpY2VDaGFuZ2VkID0gZnVuY3Rpb24gKHJlcXVlc3RKc29uKSB7XG4gICAgdmFyIHBhcmFtID0gY29tbW9uLnBhcnNlUmVxdWVzdFBhcmFtcyhyZXF1ZXN0SnNvbik7XG4gICAgYWR2ZXJ0TGlzdC51cGRhdGVMaXN0V2l0aEFkdmVydFByaWNlQ2hhbmdlZChjb25maWcuY3VycmVudFNpdGVUeXBlLCBwYXJhbSk7XG59XG5cbi8vIOWwneivleS8mOWMlu+8miDkuqTmmJPlr7nlj6rmm7TmlrDms5XluIHjgIHlhbbkvZnotbB1cGRhdGVMaXN0XG5cbi8qKlxuICog5pu05pawUDJQ5YiX6KGoXG4gKiBAcGFyYW0ge09iamVjdHxzdHJpbmd9IHJlcXVlc3RKc29uIC0g6K+35rGC5Y+C5pWw77yI5a+56LGh5oiWSlNPTuWtl+espuS4su+8iVxuICovXG4kZXZlbnQudXBkYXRlUDJwTGlzdCA9IGZ1bmN0aW9uIChyZXF1ZXN0SnNvbikge1xuICAgIHRyeSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGB1cGRhdGVQMnBMaXN0ID09PT09PT09PSAke0pTT04uc3RyaW5naWZ5KHJlcXVlc3RKc29uKX1gKVxuICAgICAgICBjb25zdCBwYXJhbXMgPSBjb21tb24ucGFyc2VSZXF1ZXN0UGFyYW1zKHJlcXVlc3RKc29uKTtcbiAgICAgICAgaWYgKHBhcmFtcykge1xuICAgICAgICAgICAgLy8g5aaC5p6cIHBhcmFtcyDkuK3msqHmnIkgY29pbk5hbWXvvIzliJnkvb/nlKggY29uZmlnLmNvaW5OYW1lIOS9nOS4uum7mOiupOWAvFxuICAgICAgICAgICAgY29uc3QgeyBjb2luTmFtZTogbmV3Q29pbk5hbWUgPSBjb25maWcuY29pbk5hbWUsIGNvaW5JZDogcENvaW4gfSA9IHBhcmFtcztcbiAgICAgICAgICAgIGlmIChuZXdDb2luTmFtZSkgeyBjb25maWcuY29pbk5hbWUgPSBuZXdDb2luTmFtZSB9XG4gICAgICAgICAgICBpZiAocENvaW4pIHsgY29uZmlnLmNvaW5JZCA9IHBDb2luIH1cbiAgICAgICAgICAgIGNvbnN0IHNlbGVjdGVkTW9yZSA9IGFkdmVydExpc3QudXBkYXRlQWR2ZXJ0TGlzdFdpdGhGaWx0ZXJQYXJhbXMocGFyYW1zKVxuICAgICAgICAgICAgcGFyYW1zLnNlbGVjdGVkTW9yZSA9IHNlbGVjdGVkTW9yZVxuICAgICAgICAgICAgYWR2ZXJ0RmlsdGVyLnVwZGF0ZVN0eWxlKHBhcmFtcywgbmV3Q29pbk5hbWUpOyAvLyDmm7TmlrDnrZvpgInmoI9cbiAgICAgICAgfVxuICAgIH0gY2F0Y2ggKGVycm9yKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKFwidXBkYXRlUDJwTGlzdCBGYWlsZWQgdG8gdXBkYXRlIFAyUCBsaXN0OlwiLCBlcnJvcik7XG4gICAgfVxufVxuXG4kZXZlbnQubG9jYXRlVG8gPSBhc3luYyBmdW5jdGlvbiAocmVxdWVzdEpzb24pIHtcbiAgICBjb25zdCBwYXJhbSA9IGNvbW1vbi5wYXJzZVJlcXVlc3RQYXJhbXMocmVxdWVzdEpzb24pO1xuICAgIGNvbnN0IHsgdHJhZGVUeXBlLCBzaXRlVHlwZSwgLi4uc3ViUGFyYW1zIH0gPSBwYXJhbTtcbiAgICB2YXIgdXBkYXRlUGFyYW1zID0gc3ViUGFyYW1zXG4gICAgLy8g5Li7dGFi5YiH5o2iXG4gICAgaWYgKHNpdGVUeXBlICE9PSB1bmRlZmluZWQgJiYgc2l0ZVR5cGUgIT09IGNvbmZpZy5jdXJyZW50U2l0ZVR5cGUpIHtcbiAgICAgICAgY29uZmlnLmN1cnJlbnRTaXRlVHlwZSA9IHNpdGVUeXBlXG4gICAgICAgIG1haW5UYWIuc2hvd01haW5UYWIoY29uZmlnLmN1cnJlbnRTaXRlVHlwZSlcbiAgICB9XG4gICAgLy8g5Lqk5piT5pa55ZCRXG4gICAgaWYgKHRyYWRlVHlwZSAhPT0gdW5kZWZpbmVkKSB7XG4gICAgICAgIGNvbmZpZy50cmFkZVR5cGUgPSB0cmFkZVR5cGVcbiAgICAgICAgYWR2ZXJ0RmlsdGVyLnVwZGF0ZVN0eWxlV2l0aERpcmVjdGlvbih0cmFkZVR5cGUpXG4gICAgICAgIHVwZGF0ZVBhcmFtcy50cmFkZVR5cGUgPSB0cmFkZVR5cGUgPT0gXCJidXlcIiA/IFwic2VsbFwiIDogXCJidXlcIlxuICAgIH1cbiAgICAvLyDkuqTmmJPlr7nmm7TmlrBcbiAgICB2YXIgdXBkYXRlUGFyYW1zID0geyAuLi51cGRhdGVQYXJhbXMsIC4uLmhhbmRsZVdpdGhUcmFkaW5nUGFpcnMocGFyYW0pIH1cbiAgICAvLyDmo4Dmn6UgdXBkYXRlUGFyYW1zIOaYr+WQpuS4uuepuuWvueixoVxuICAgIGlmIChPYmplY3Qua2V5cyh1cGRhdGVQYXJhbXMpLmxlbmd0aCA+IDApIHtcbiAgICAgICAgaWYgKGNvbW1vbi5jb21tYW5EYXRhLk9TID09IDApIHtcbiAgICAgICAgICAgIGFkdmVydExpc3QudXBkYXRlQWR2ZXJ0TGlzdFdpdGhGaWx0ZXJQYXJhbXModXBkYXRlUGFyYW1zKVxuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgYWR2ZXJ0TGlzdC51cGRhdGVBZHZlcnRMaXN0V2l0aEZpbHRlclBhcmFtc05vUmVxdWVzdCh1cGRhdGVQYXJhbXMpXG4gICAgICAgIH1cbiAgICB9XG59XG5cbi8vLyDmm7TmlrDkuqTmmJPlr7lcbi8vLyBjb2luSWQg5pWw5a2X5biBaWRcbi8vLyBjb2luTmFtZSDmlbDlrZfluIHlkI3np7Bcbi8vLyBjdXJyZW5jeSDms5XluIFpZFxuLy8vIGN1cnJlbmN5TmFtZSDms5XluIHlkI3np7Bcbi8vLyBzeW1ib2wg5rOV5biB56ym5Y+3IO+/pSwkXG4kZXZlbnQudXBkYXRlVHJhZGluZ1BhaXJzID0gYXN5bmMgZnVuY3Rpb24gKHJlcXVlc3RKc29uKSB7XG4gICAgY29uc3QgcGFyYW0gPSBjb21tb24ucGFyc2VSZXF1ZXN0UGFyYW1zKHJlcXVlc3RKc29uKTtcbiAgICBpZiAocGFyYW0gPT09IFwiXCIgfHwgT2JqZWN0LmtleXMocGFyYW0pLmxlbmd0aCA9PSAwKSB7XG4gICAgICAgIGFkdmVydExpc3QucmVzZXRBZHZlcnRMaXN0UmVxdWVzdCgpXG4gICAgfSBlbHNlIHtcbiAgICAgICAgbGV0IHVwZGF0ZVBhcmFtcyA9IGhhbmRsZVdpdGhUcmFkaW5nUGFpcnMocGFyYW0pXG4gICAgICAgIC8vIOajgOafpSB1cGRhdGVQYXJhbXMg5piv5ZCm5Li656m65a+56LGhXG4gICAgICAgIGlmIChPYmplY3Qua2V5cyh1cGRhdGVQYXJhbXMpLmxlbmd0aCA+IDApIHtcbiAgICAgICAgICAgIGlmIChjb21tb24uY29tbWFuRGF0YS5PUyA9PSAwKSB7XG4gICAgICAgICAgICAgICAgYWR2ZXJ0TGlzdC51cGRhdGVBZHZlcnRMaXN0V2l0aEZpbHRlclBhcmFtcyh1cGRhdGVQYXJhbXMpXG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgIGFkdmVydExpc3QudXBkYXRlQWR2ZXJ0TGlzdFdpdGhGaWx0ZXJQYXJhbXNOb1JlcXVlc3QodXBkYXRlUGFyYW1zKVxuICAgICAgICAgICAgfVxuICAgICAgICB9XG4gICAgfVxufVxuXG5mdW5jdGlvbiBoYW5kbGVXaXRoVHJhZGluZ1BhaXJzKHBhcmFtKSB7XG4gICAgY29uc3QgeyBzaXRlVHlwZSB9ID0gcGFyYW1cbiAgICBjb25zdCB7IGNvaW5OYW1lLCBjdXJyZW5jeU5hbWUgfSA9IGNvbmZpZy51cGRhdGVDb25maWdUcmFkaW5nUGFpcnMocGFyYW0pO1xuICAgIGFkdmVydEZpbHRlci51cGRhdGVTdHlsZVdpdGhUcmFkaW5nUGFpcnMoY29pbk5hbWUsIGN1cnJlbmN5TmFtZSwgc2l0ZVR5cGUpXG4gICAgLy8g6Iul5oyH5a6a5LqG56uZ54K55pu05paw5Lqk5piT5a+577yM5b2T5YmN56uZ54K55LiO5oyH5a6a56uZ54K55LiN5LiA6Ie077yM5YiZ5LiN5pu05pawVUnmoLflvI9cbiAgICBpZiAoc2l0ZVR5cGUgIT09IHVuZGVmaW5lZCAmJiBzaXRlVHlwZSAhPSBjb25maWcuY3VycmVudFNpdGVUeXBlKSB7XG4gICAgICAgIHJldHVybiB7fVxuICAgIH1cbiAgICBpZiAoY29pbk5hbWUgIT09IHVuZGVmaW5lZCkge1xuICAgICAgICAvL+Wfi+eCuSAtIOaVsOWtl+W4geWIh+aNolxuICAgICAgICBjb21tb24uYW5hbHl0aWNzKGNvbmZpZy5jdXJyZW50U2l0ZVR5cGUgPT0gU2l0ZVR5cGUuQlJBTkQgPyBcIm90Y19wMnBfYWRsaXN0X2JyYW5kXCIgOiBcIm90Y19wMnBfYWRsaXN0XCIsIHtcbiAgICAgICAgICAgIFwib3RjX3N0ZXBcIjogXCJjaGFuZ2VfY29pblwiLFxuICAgICAgICAgICAgXCJzcG1cIjogXCJvdGMuYWRsaXN0LnBhZ2UuY2hhbmdlX0RDXCIsXG4gICAgICAgICAgICBcInNpZGVcIjogYWR2ZXJ0RmlsdGVyLmdldFRyYWRlVHlwZSgpLFxuICAgICAgICAgICAgXCJjb2luX25hbWVcIjogY29pbk5hbWUsXG4gICAgICAgIH0pXG4gICAgfVxuICAgIGlmIChjdXJyZW5jeU5hbWUgIT09IHVuZGVmaW5lZCkge1xuICAgICAgICBiYW5uZXIucmVmcmVzaEJhbm5lcihjb25maWcuY3VycmVudFNpdGVUeXBlLCBjdXJyZW5jeU5hbWUsIHRydWUpXG4gICAgICAgIHJpc2tDb250cm9sLmNoZWNrRm9yQ3VycmVuY3lJZk5lZWRlZCgpO1xuICAgICAgICAvL+Wfi+eCuSAtIOazleW4geWIh+aNolxuICAgICAgICBjb21tb24uYW5hbHl0aWNzKGNvbmZpZy5jdXJyZW50U2l0ZVR5cGUgPT0gU2l0ZVR5cGUuQlJBTkQgPyBcIm90Y19wMnBfYWRsaXN0X2JyYW5kXCIgOiBcIm90Y19wMnBfYWRsaXN0XCIsIHtcbiAgICAgICAgICAgIFwib3RjX3N0ZXBcIjogXCJjaGFuZ2VfZmlhdFwiLFxuICAgICAgICAgICAgXCJzcG1cIjogXCJvdGMuYWRsaXN0LnBhZ2UuY2hhbmdlX0xDXCIsXG4gICAgICAgICAgICBcInNpZGVcIjogYWR2ZXJ0RmlsdGVyLmdldFRyYWRlVHlwZSgpLFxuICAgICAgICAgICAgXCJjb2luX25hbWVcIjogY29uZmlnLmNvaW5OYW1lLFxuICAgICAgICB9KVxuICAgIH1cbiAgICAvLyDlvZPphY3nva7kv6Hmga/kuK1jb25pZOS4jmN1cnJlbmN56YO95a2Y5Zyo5pe277yM5omN6L+U5Zue5Lqk5piT5a+55L+h5oGv77yM5q2k5pe25Li65pyJ5pWI5Lqk5piT5a+55pWw5o2u77yM6L+H5ruk5o6J5LiN5b+F6KaB55qE6K+35rGCXG4gICAgaWYgKGNvbmZpZy5jb2luSWQgIT09IHVuZGVmaW5lZCAmJiBjb25maWcuY3VycmVuY3kgIT09IHVuZGVmaW5lZCkge1xuICAgICAgICByZXR1cm4ge1xuICAgICAgICAgICAgY29pbklkOiBjb25maWcuY29pbklkLFxuICAgICAgICAgICAgY3VycmVuY3k6IGNvbmZpZy5jdXJyZW5jeVxuICAgICAgICB9XG4gICAgfSBlbHNlIGlmIChjb25maWcuY3VycmVuY3kgIT09IHVuZGVmaW5lZCkge1xuICAgICAgICByZXR1cm4ge1xuICAgICAgICAgICAgY3VycmVuY3k6IGNvbmZpZy5jdXJyZW5jeVxuICAgICAgICB9XG4gICAgfVxuICAgIHJldHVybiB7fTtcbn1cblxuJGV2ZW50LmxvYWRMaXN0Q29udGVudCA9IGFzeW5jIGZ1bmN0aW9uICh0eXBlLCB1cGRhdGVMaXN0KSB7XG4gICAgY29uZmlnLmN1cnJlbnRTaXRlVHlwZSA9IHR5cGVcbiAgICBhZHZlcnRGaWx0ZXIuY2hhbmdlU2l0ZSh0eXBlKVxuICAgIGJhbm5lci5yZWZyZXNoQmFubmVyKHR5cGUsIGNvbmZpZy5jdXJyZW5jeU5hbWUpXG4gICAgaWYgKHVwZGF0ZUxpc3QpIHsgYWR2ZXJ0TGlzdC5yZWZyZXNoQWR2ZXJ0TGlzdElmTmVlZHModHlwZSwgY29uZmlnLnRhcmdldCkgfVxuICAgIC8vIOabtOaWsOWIh+aNonRhYlxuICAgIGRpdmVyc2lvbkhlbHBlci51cGRhdGVTaXRlKHR5cGUpXG59XG5cbi8vLyDliIfmjaLkuqTmmJPmqKHlvI/vvJow5LiL5Y2V5qih5byPLzHlub/lkYrmqKHlvI8sIGludC9zdHJpbmfpg73lj6/ku6XmjqXlj5dcbiRldmVudC5jaGFuZ2VUcmFkZU1vZGVsID0gZnVuY3Rpb24gKG1vZGUpIHtcbiAgICB2YXIgaXNBZHZlcnRNb2RlID0gYCR7bW9kZX1gID09IFwiMVwiXG4gICAgY29uZmlnLmlzQWR2ZXJ0TW9kZSA9IGlzQWR2ZXJ0TW9kZVxuICAgIHZhciBvZmZzZXQgPSBjb21tb24uY29tbWFuRGF0YS5wYWdlQm90dG9tT2Zmc2V0ID8/IDBcbiAgICBvZmZzZXQgPSBpc0FkdmVydE1vZGUgPyBvZmZzZXQgKyA1NiA6IG9mZnNldFxuICAgIGFkdmVydExpc3QudXBkYXRlQm90dG9tT2Zmc2V0KG9mZnNldClcbiAgICBhZHZlcnRGaWx0ZXIuY2hlY2tBZHZlcnRQdXNobGlzaFN0YXR1cygpO1xufVxuXG4vLy8g56uv5byV5pOO5ZCv5Yqo5YWl5Y+jXG4kZXZlbnQuc3RhcnQgPSBhc3luYyBmdW5jdGlvbiAoKSB7XG4gICAgY29uZmlnLmN1cnJlbnRTaXRlVHlwZSA9IGF3YWl0IGRpdmVyc2lvbkhlbHBlci5nZXRTaXRlKClcbiAgICBtYWluVGFiLnNob3dNYWluVGFiKGNvbmZpZy5jdXJyZW50U2l0ZVR5cGUpXG59XG4iXSwibmFtZXMiOlsiU2l0ZVR5cGUiLCJCUkFORCIsIk5PUk1BTCIsInRyYWRlUGFpcnMiLCJjb2luSWQiLCJ1bmRlZmluZWQiLCJjb2luTmFtZSIsImN1cnJlbmN5IiwiY3VycmVuY3lOYW1lIiwic3ltYm9sIiwiY29uZmlnIiwidHJhZGVUeXBlIiwiY3VycmVudFNpdGVUeXBlIiwiaXNBZHZlcnRNb2RlIiwibm9ybWFsIiwiYnJhbmQiLCJ0YXJnZXQiLCJ0aGlzIiwidXBkYXRlQ29uZmlnVHJhZGluZ1BhaXJzIiwicGFyYW0iLCJzaXRlVHlwZSIsInVwZGF0ZVBhcmFtcyIsIk9iamVjdCIsImVudHJpZXMiLCJmb3JFYWNoIiwicHJvcCIsImRlZmluZVByb3BlcnR5IiwiZW51bWVyYWJsZSIsImNvbmZpZ3VyYWJsZSIsImdldCIsInNldCIsInZhbHVlIiwiY29tbWFuRGF0YSIsImljb25VUkxIb3N0IiwiY29sb3JNb2RlIiwiT1MiLCJhcHBWZXJzaW9uIiwibGFuZ3VhZ2UiLCJ1aWQiLCJwYWdlQm90dG9tT2Zmc2V0Iiwic2NyZWVuV2lkdGgiLCJzY3JlZW5IZWlnaHQiLCJhc3luYyIsInNlbmRSZXF1ZXN0IiwicGF0aCIsInBhcmFtcyIsIm1ldGhvZCIsImhvc3RUeXBlIiwiaGVhZGVyIiwiY29uc29sZSIsImxvZyIsInJlc3BvbnNlU3RyaW5nIiwiJG5hdGl2ZUFQSSIsInJlcXVlc3QiLCJKU09OIiwic3RyaW5naWZ5IiwicmVzcG9uc2UiLCJwYXJzZSIsImNvZGUiLCJlIiwiZ2V0SWNvblVSTCIsInRvTG93ZXJDYXNlIiwiaWNvblVSTCIsImNsaWNrVGltZXIiLCJjbGlja1Rocm90dGxlIiwiaW50ZXJ2YWwiLCJub3ciLCJEYXRlIiwidGltZXIiLCJvcGVuVVJMIiwidXJsIiwib3BlblJvdXRlIiwic2F2ZSIsIm1vZHVsZSIsImtleSIsImRhdGEiLCJzdG9yYWdlIiwiYWN0aW9uIiwibmFtZSIsInJlYWQiLCJhbmFseXRpY3MiLCJldmVudCIsInByb3BlcnRpZXMiLCJwcm9wZXJ0aWVzSnNvbiIsIm1hcCIsInBhcnNlQ29tbW9uQ29uZmlnIiwicGFyc2VJbnQiLCJtb2R1bGVEZWZpbmUiLCJtb2R1bGVOYW1lIiwic3RhcnRGdW5jdGlvbiIsImRlZmF1bHREYXRhRnVuY3Rpb24iLCIkZGF0YSIsIiRldmVudCIsInN0YXJ0IiwibW9kdWxlRXZlbnQiLCJtb2R1bGVEYXRhIiwicGFyc2VSZXF1ZXN0UGFyYW1zIiwicmVxdWVzdEpzb24iLCJTdHJpbmciLCJ0aG91c2FuZHNGb3JtYXR0ZXIiLCJudW1iZXIiLCJudW1iZXJTdHJpbmciLCJ0b1N0cmluZyIsImluY2x1ZGVzIiwiaW50ZWdlclBhcnQiLCJkZWNpbWFsUGFydCIsInNwbGl0IiwicmVwbGFjZSIsImFkdmVydFJlcXVzdENvbW1vbkRhdGEiLCJvbmx5VHJhZGFibGUiLCJjdXJyUGFnZSIsImJsb2NrVHlwZSIsImFtb3VudCIsInBheU1ldGhvZCIsIm5vcm1hbEFkdmVydFBhcmFtcyIsImlzVHJhZGVkIiwiaXNUaHVtYnNVcCIsImlzRm9sbG93ZWQiLCJzZWFWaWV3Um9vbSIsImxhYmVsSWQiLCJpc01lcmNoYW50IiwibWFrZXJDb21wbGV0ZVJhdGUiLCJtZXJjaGFudFRhZ3MiLCJicmFuZEFkdmVydFBhcmFtcyIsImJyYW5kTGFiZWxJZHMiLCJyZXFldXN0Iiwic2V0UGFyYW1zIiwiZ2V0UGFyYW1zIiwiZ2V0RW5kUG9pbnQiLCJyZXNldCIsImhhc1NlbGVjdGVkTW9yZSIsImxlbmd0aCIsImdldEN1cnJlbnRSZXF1ZXN0UGFyYW1zIiwicmVzZXRQYXJhbXMiLCJyZXNldExhYmVsSWQiLCJyZXNldE1lcmNoYW50VGFncyIsInVwZGF0ZUFkdmVydExpc3RXaXRoRmlsdGVyUGFyYW1zIiwianNvbiIsInJlZnJlc2hBZHZlcnRMaXN0IiwibG9hZEFkdmVydExpc3REYXRhcyIsImxvYWRNb3JlQWR2ZXJ0TGlzdCIsImVuZHBvaW50IiwiY29tbW9uLnNlbmRSZXF1ZXN0Iiwic3VjY2VzcyIsIm1lc3NhZ2UiLCJ0b3RhbFBhZ2UiLCJleHRlbmQiLCJoYXNNb3JlIiwiZGF0YXMiLCJlcnJvciIsImxvYWRTZWF2aWV3Um9vbURhdGFzV2l0aFRvcFRocmVlIiwicGFnZVNpemUiLCJ0cmFkZUxpbWl0IiwiaGFzQmluZENhcmQiLCJoYXNBdXRoUmVhbG5hbWUiLCJoYXNCaW5kUGhvbmUiLCJjbG9zZU9mZmxpbmVCeU1hbnVhbCIsImNsb3NlVHJhZGVUaXBzQnlNYW51YWwiLCJwcm9wZXJ0eURlZmluaXRpb25zIiwidHJhZGFibGUiLCJ0cmFkYWJsZVN3aXRjaEljb24iLCJjcnlwdG9DdXJyZW5jeSIsImNyeXB0b0ljb24iLCJhbW91bnRUZXh0Q29sb3IiLCJwYXlNZXRob2RUZXh0Q29sb3IiLCJtb3JlQ29uZGl0aW9uIiwibW9yZUljb24iLCJkaXJlY3Rpb24iLCJidXlUYWJTdHlsZSIsInRleHRDb2xvciIsInNlbGxUYWJTdHlsZSIsImNvbW1vbi5tb2R1bGVEZWZpbmUiLCJkZWZhdWx0RGF0YSIsImRhdGFIZWxwZXIiLCJkZWZhdWx0VmFsdWUiLCJvZmZsaW5lVGlwcyIsIm9mZmxpbmVUaXBzVmlzaWJsZSIsInRyYWRlVGlwc1Zpc2libGUiLCJidXlUcmFkZVRpcHMiLCJzZWxsVHJhZGVUaXBzIiwiYnV5VHJhZGVUaXBzVmlzaWJsZSIsInNlbGxUcmFkZVRpcHNWaXNpYmxlIiwidXBkYXRlVHJhZGVUaXBzIiwidHlwZSIsInRpcHMiLCJjbG9zZVRpcHNXaXRoTWVyY2hhbnRPZmZsaW5lIiwiY2xvc2VUaXBzV2l0aFRyYWRlIiwiY29tbW9uLmFuYWx5dGljcyIsIm90Y19zdGVwIiwic2lkZSIsImdldFRyYWRlVHlwZSIsInVwZGF0ZVN0eWxlV2l0aERpcmVjdGlvbiIsIm5vcm1hbFN0eWxlIiwic2VsZWN0ZWRTdHlsZSIsImNoZWNrVHJhZGVMaW1pdCIsInJlc2V0RGF0YVNlcnZpY2VTZWxlY3Rpb24iLCJkYXRhU2VydmljZS5yZXNldExhYmVsSWQiLCJkYXRhU2VydmljZS5yZXNldE1lcmNoYW50VGFncyIsImNsaWNrRmlsdGVyT3B0aW9uV2l0aERpcmVjdGlvbiIsInAycEZpbHRlckJyaWRnZSIsInJlZnJlc2hBZHZlcnRMaXN0V2l0aFRyYWRlVHlwZSIsInVwZGF0ZU1vcmVTZWxlY3Rpb25TdHlsZSIsImRhdGFTZXJ2aWNlLmhhc1NlbGVjdGVkTW9yZSIsInNwbSIsImNvaW5fbmFtZSIsImNsaWNrRmlsdGVyT3B0aW9uV2l0aENyeXB0b0N1cnJlbmN5IiwiY2xpY2tGaWx0ZXJPcHRpb25XaXRoQW1vdW50IiwiY2xpY2tGaWx0ZXJPcHRpb25XaXRoUGF5TWVob2QiLCJjbGlja0ZpbHRlck9wdGlvbldpdGhUcmFkYWJsZSIsInJlZnJlc2hBZHZlcnRMaXN0V2l0aFRyYWRhYmxlIiwib3BlbiIsImNsaWNrRmlsdGVyT3B0aW9uV2l0aE1vcmUiLCJ1cGRhdGVTdHlsZSIsImFkdmVydFJlcXVlc3RQYXJhbXMiLCJ1cGRhdGVTdHlsZVdpdGhUcmFkaW5nUGFpcnMiLCJ0cmltIiwic2VsZWN0ZWRNb3JlIiwic2VsZWN0ZWRQYXltZXRob2QiLCJ0b1VwcGVyQ2FzZSIsImNvbW1vbi5nZXRJY29uVVJMIiwiY2hlY2tBZHZlcnRQdXNobGlzaFN0YXR1cyIsInJlcG9zIiwiUHJvbWlzZSIsImFsbCIsIm9ubGluZSIsImFwcF9hZHZlcnQiLCJoYXNBZHZlcnQiLCJzaG93VGlwcyIsImdldENsaWNrQ29udGVudCIsIiRpMThuIiwibl9vdGNfYWR2ZXJ0X29wdF9hZF9tYWtlcl9zdGF0ZV90aXAiLCJuX290Y19hZHZlcnRfb3B0X2J1dHRvbl90ZXh0X3RvX2FkdmVydCIsImNvbnRlbnQiLCJjbGlja1RleHQiLCJhY3Rpb25EZXNjIiwiY29sb3IiLCJjb21tb24uY29tbWFuRGF0YSIsImRlc2MiLCJ0b1NldHRpbmdzVGV4dCIsIm9uU3dpdGNoUGFnZSIsImNvbW1vbi5vcGVuVVJMIiwidG9LeWNBdXRoZW50aWNhdGlvbiIsInRvQmluZFBob25lIiwidG9BZGRQYXltZW50IiwiaXNUcmFkZUJpbmQiLCJ2ZXJpZnlXYXlIYXZlU2V0IiwiZG93bmdyYWRlRnVuZFBhc3N3b3JkIiwiZG93bmdyYWRlIiwiQm9vbGVhbiIsImNsaWNrRmlsdGVyT3B0aW9uV2l0aEN1cnJlbmN5IiwiZ2V0VHJhZGVMaW1pdFRpcHNXaXRoUmVhbG5hbWUiLCJyZXMiLCJhdXRoTGV2ZWwiLCJuX290Y19ndWlkZV90aXBzX3JlYWxfbmFtZSIsIm5fb3RjX2dvX3ZlcmlmaWNhdGlvbiIsInZlcmlmeVJlcyIsInVjUGhvbmVTdGF0dXMiLCJuX290Y19ndWlkZV90aXBzX2JpbmRfcGhvbmUiLCJuX290Y19hZHZlcnRfdHJhZGVfcDJwX25ld191c2VyX2JpbmRfcGhvbmUiLCJhY2NvdW50UmVzIiwibl9vdGNfZ3VpZGVfdGlwc19hZGRfcGF5X21ldGhvZCIsIm5fb3RjX2FkdmVydF90cmFkZV9wMnBfbmV3X3VzZXJfZ29fYWRkX3BheU1ldGhvZCIsImxvYWRUcmFkZVRpcHNJbmZvIiwiY2hhbmdlU2l0ZSIsInRvIiwiZ2V0QW1vdW50IiwiZ2V0UGF5bWVudCIsImNvbnRlbnREYXRhIiwiY29udGVudEhlaWdodCIsImJvdHRvbVBhZGRpbmciLCJnZXREYXRhcyIsInNldERhdGFzIiwiYmFubmVySGVpZ2h0IiwiTWF0aCIsImNlaWwiLCJjbGFlckNhY2hlIiwicmVmcmVzaEJhbm5lciIsImNsZWFyIiwiY2FjaGVEYXRhcyIsImxvYWRQMnBCYW5uZXJEYXRhcyIsImV2ZW50SWQiLCJhcHBQYWdlSWQiLCJtZ3RSdWxlU2NlbmVDb2RlIiwiY3VycmVuY3lBc3NldE5hbWUiLCJwYWdlTGlzdCIsInBpY0tleSIsImZpbHRlciIsIml0ZW0iLCJzb21lIiwiY29udGVudEl0ZW0iLCJuZXdDb250ZW50IiwiYmFja2dyb3VuZENvbG9yIiwiYnV5U2VsbEJhclZpc2libGUiLCJmaWx0ZXJCYXJUaXBWaXNpYmxlIiwiY29udGFpbmVySGVpZ2h0IiwibWFyZ2luQm90dG9tIiwiY29udGFpbmVyQmdDb2xvciIsInVwZGF0ZUJhclN0eWxlIiwidGFiSW5kZXgiLCJvbkNsaWNrTWFpblRhYiIsImluZGV4IiwidXBsb2FkTGlzdCIsInNlbGVjdGVkTWFpblRhYkluZGV4IiwibG9hZExpc3RDb250ZW50IiwiZXJyIiwic2hvd01haW5UYWIiLCJwb3BTdGF0ZSIsImlzU2hvd2luZyIsInRpdGxlIiwibl9vdGNfYWR2ZXJ0X3ZlcmlmeV9jYXBpdGFsX3RpdGxlIiwiYnV0dG9uVGl0bGUiLCJuX290Y19rbm93IiwiaXNmZXRjaGVkIiwiZmV0Y2hDb25maWciLCJ2ZXJpZnlDYXBpdGFsIiwiY29uZmlnRm9yQ3VycmVuY3kiLCJvcmRlckFtb3VudCIsInBvcFZlcmlmeVRpcCIsIm5fb3RjX2FkdmVydF92ZXJpZnlfY2FwaXRhbF9zdWJ0aXRsZSIsInBvcERpc21pc3MiLCJpbml0YWxQYWdlRGF0YSIsInJlZnJlc2hTdGF0dXMiLCJsb2FkTW9yZVN0YXR1cyIsImxpc3RWaXNpYmxlIiwibG9hZGluZ1N0YXR1cyIsImxvYWRpbmdWaXNpYmxlIiwiZW1wdHlWaXNpYmxlIiwiZW1wdHlidXR0b25WaXNpYmxlIiwibm9OZXRWaXNpYmxlIiwiZW1wdHlUaXBzIiwibl9vdGNfYWR2ZXJ0X2VtcHR5X3RpdGxlIiwib3RjX25vX2FkIiwibG9hZGluZ1RlbXBEYXRhcyIsImJvdHRvbU9mZnNldCIsIm5vcm1hbERhdGFzIiwiYnJhbmREYXRhcyIsInJlZnJlc2hMaXN0IiwidXBkYXRlRGF0YXNUb0xpc3QiLCJ1cGRhdGVDb250ZW50SGVpZ2h0IiwidXBkYXRlQm90dG9tT2Zmc2V0IiwiaGVpZ2h0IiwicmVmcmVzaEFkdmVydExpc3RJZk5lZWRzIiwic2l0VHlwZSIsImZpbHRlclBhcmFtcyIsImRhdGFTZXJ2aWNlLmdldEN1cnJlbnRSZXF1ZXN0UGFyYW1zIiwicmVzZXRBZHZlcnRMaXN0UmVxdWVzdCIsImRhdGFTZXJ2aWNlLnJlc2V0UGFyYW1zIiwidXBkYXRlQWR2ZXJ0TGlzdFdpdGhGaWx0ZXJQYXJhbXNOb1JlcXVlc3QiLCJkYXRhU2VydmljZS51cGRhdGVBZHZlcnRMaXN0V2l0aEZpbHRlclBhcmFtcyIsIm5ld0Ftb3VudCIsIm9sZEFtb3VudCIsImFkdmVydEZpbHRlci5nZXRBbW91bnQiLCJmaWF0IiwidXBkYXRlTGlzdFdpdGhGb2xsb3dTdGF0dXNDaGFuZ2VkIiwicmVsYXRpb25TdGF0dXMiLCJzdGF0dXMiLCJpc0ZvbGxvdyIsImlzU2hpZWxkIiwiaXNVbnNoaWVsZCIsImhhc0FkZENlbGwiLCJpbmRleFNlYVZpZXdSb29tQ2VsbCIsIm5ld0luZGV4IiwidGVtcERhdGFzIiwicHVzaCIsInJvb21zIiwiZXhpc3QiLCJsb2FkU2Vhdmlld1Jvb21EYXRhcyIsImFkZEdyZWF0ZUFkdmVydENlbGxJZk5lZWQiLCJmaWx0ZXJlZERhdGFzIiwic2hvd0xpc3RDb25lbnQiLCJmb2xsb3dDdXJyZW50TWVyY2hhdFdpdGhBZHZlcnQiLCJmb2xsb3ciLCJpZFZpc2libGUiLCJuX3RpdGxlX2ZvbGxvd2VkX21lcmNoYW50Iiwibl90aXRsZV9mb2xsb3dfbWVyY2hhbnQiLCJpY29uIiwiZmluZCIsIm9iaiIsInVwZGF0ZUxpc3RXaXRoQWR2ZXJ0UHJpY2VDaGFuZ2VkIiwiYWR2ZXJ0SWQiLCJwcmljZSIsImlkIiwic2hvd1ByaWNlIiwiY29tbW9uLnRob3VzYW5kc0Zvcm1hdHRlciIsInN1YkRhdGEiLCJyb29tIiwiVmVyaWZ5Q2FwaXRhbC5mZXRjaENvbmZpZyIsImxvYWRBZHZlcnRMaXN0V2l0aFJlZnJlc2hTdGF0dXMiLCJhZHZlcnRGaWx0ZXIuZ2V0VHJhZGVUeXBlIiwicGF5bWVudCIsImFkdmVydEZpbHRlci5nZXRQYXltZW50IiwiZmlsdGVyVWlkIiwiZGF0YVNlcnZpY2UubG9hZFNlYXZpZXdSb29tRGF0YXNXaXRoVG9wVGhyZWUiLCJ2aWV3TW9kZWxzIiwic2xpY2UiLCJjZWxsVHlwZSIsInJhbmtJY29uIiwibGluZVZpc2libGUiLCJ2aXNpYmlsaXR5IiwidG90YWxUcmFkZU9yZGVyQ291bnRUZXh0IiwiJGludGVyY2VwdCIsIm5fb3RjX2FkdmVydF9vcmRlcmNvdW50IiwidG90YWxUcmFkZU9yZGVyQ291bnQiLCJvcmRlckNvbXBsZXRlUmF0ZVRleHQiLCJvcmRlckNvbXBsZXRlUmF0ZSIsImZvcm1hdFVzZXJJZExhYmxlcyIsInNwbGljZSIsInVwZGF0ZU5vcm1hbERhdGFzIiwiZXhpc3RzIiwibm9Nb3JlRGF0YSIsImkiLCJpc01vcmUiLCJzdGF0dXNUeXBlIiwibG9hZGluZ0NlbGxUeXBlIiwiQXJyYXkiLCJmcm9tIiwiZGF0YVNlcnZpY2UubG9hZE1vcmVBZHZlcnRMaXN0IiwiZGF0YVNlcnZpY2UucmVmcmVzaEFkdmVydExpc3QiLCJvcmlnaW5EYXRhcyIsInNob3dFbXB0eSIsInN0YXJ0SW5kZXgiLCJ2aWV3TW9kZWxzUHJvbWlzZSIsImZvcm1hdEJyYW5kQWR2ZXJ0IiwiZm9ybWF0Tm9ybWFsQWR2ZXJ0IiwibmV3RGF0YXMiLCJzaG93Tm9OZXQiLCJoYlRvYXN0Iiwibl9jaGVja19uZXR3b3JrIiwibl9vdGNfbm90X3N1cHBvcnRfZmlhdCIsIm5fYXNzZXRfY3VycmVuY3lfaW52YWxpZCIsImlzQnV5IiwiZm9ybWF0QWR2ZXJ0IiwidmVyaWZ5Q2FwaXRhbFN0YXR1cyIsInZlcmlmeUNhcGl0YWxWaXNpYmxlIiwiVmVyaWZ5Q2FwaXRhbC5jb25maWdGb3JDdXJyZW5jeSIsInZlcmlmeUNhcGl0YWxUZXh0Iiwibl9vdGNfYWR2ZXJ0X25vX3ZlcmlmeV9jYXBpdGFsX3RpdGxlIiwidmVyaWZ5Q2FwaXRhbFllc1Zpc2libGUiLCJ2ZXJpZnlDYXBpdGFsTm9WaXNpYmxlIiwiaXNWZXJpZnlDYXBpdGFsIiwibGFiZWxWaXNpYmxlIiwibGFiZWxOYW1lIiwibnVtVGV4dCIsInRyYWRlQ291bnQiLCJtaW5UcmFkZUxpbWl0IiwibWF4VHJhZGVMaW1pdCIsImxpbWl0QW1vdW50VGV4dCIsInRyYWRlRHVyYXRpb25UZXh0Iiwibl9kZXNjX21pbnV0ZSIsInBheVRlcm0iLCJleHBhbmRBcmVhVmlzaWJpbGl0eSIsImlkSWNvbiIsInRyYWRlQnV0dG9uIiwidHJhbnNwYXJlbnQiLCJ0YWtlckxpbWl0Iiwibl9vdGNfYWR2ZXJ0X2J0bl9reWMiLCJuX290Y19hZHZlcnRfYnRuX2JpbmRfcGhvbmUiLCJuX290Y190YWtlcl9saW1pdF9uZXciLCJuX290Y19idXkiLCJuX290Y19zZWxsIiwidGlwc1Zpc2liaWxpdHkiLCJtZXRob2RzIiwicGF5TWV0aG9kcyIsImhhc0JsdWVTaGllbGQiLCJpc0FycmF5IiwiYmx1ZVNoaWVsZCIsImxldmVsIiwibWVyY2hhbnRMZXZlbCIsInRodW1iVXBEYXRhIiwidGh1bWJVcCIsInRyYWRlZCIsImlzVHJhZGUiLCJvbmxpbmVDb2xvciIsImlzT25saW5lIiwibl9vdGNfYWRzX29yZGVyX251bWJlciIsInRpdGxlQ29sb3IiLCJtZXJjaGFudFZpc2libGUiLCJjaGFyZ2VUeXBlIiwic01lcmNoYW50VmlzaWJsZSIsInNNZXJjaGFudENvbnRlbnRXaWR0aCIsIl9nZXRTdHJpbmdXaWR0aCIsInVzZXJOYW1lIiwiYWR2ZXJ0IiwidHJhZGVkVmlzaWJsZSIsInBheU1ldGhvZHNKc29uIiwic3BlY2lhbEJyYW5kTGFiZWxzIiwic3BlY2lhbExhYmVsSWNvbiIsInNwZWNpYWxMYWJlbFRleHQiLCJzcGVjaWFsTGFiZWxXaWR0aCIsInNwZWNpYWxMYWJlbFZpc2libGUiLCJub3JtYWxCcmFuZExhYmVscyIsImxhYmVsIiwiYm9yZGVyV2lkdGgiLCJiYWNrZ3JvdW5kIiwidGV4dFNpemUiLCJub3JtYWxMYWJlbFZpc2libGUiLCJub3JtYWxCb3R0b21PZmZzZXQiLCJzdHIiLCJmb250U2l6ZSIsImZvbnRXZWlnaHQiLCJzaXplSW5mbyIsInRleHQiLCJ3aWR0aCIsIm9uQ2xpY2tNZXJjaGFudE5hbWUiLCJvbkNsaWNrVmVyaWZ5Q2FwaXRhbCIsIlZlcmlmeUNhcGl0YWwucG9wVmVyaWZ5VGlwIiwib25DbGlja1RyYWRlT3BlcmF0aW9uIiwib25DbGlja01vcmUiLCJvbkNsaWNrRm9sbG93Iiwibl90aXRsZV9vcGVyYXRlX3N1Y2Nlc3MiLCJvbkNsaWNrVG9EZXBvc2l0Iiwib25DbGlja1RvU3RyaWN0U2VsZWN0aW9uIiwib25DbGlja1NlYXZpZXdSb29tIiwib25HcmVhdGVBZHZlcnQiLCJyaXNrSW5mb01vZGVsIiwidGFnIiwiYnV0dG9uIiwiY2hlY2tUZXh0IiwiY2FuU2hvd1Jpc2siLCJzaG93QWxlcnRDYWNoZSIsImdldFJpc2tJbmZvQnlDdXJyZW5jeU5hbWUiLCJmYWN0b3IiLCJjaGVja0ZvckN1cnJlbmN5SWZOZWVkZWQiLCJoYW5kbGVDdXJlbmN5Q2hhbmdlIiwicmlza0luZm8iLCJuX2NvcHlfdHJhZGluZ19tZV9rbm93Iiwic2V0Q2FuU2hvd1Jpc2siLCJjYW5TaG93Iiwicmlza0NvbnRyb2wiLCJkaXZlcnNpb25IZWxwZXIiLCJjYWNoZUtleSIsImdldFNpdGUiLCJjb21tb24ucmVhZCIsInNob3dQYWdlIiwiY29tbW9uLnNhdmUiLCJ0aGVuIiwiXyIsInNpdGUiLCJ1cGRhdGVTaXRlIiwiZGl2ZXJzaW9uIiwicGFnZVdpbGxBcHBlYXIiLCJwYWdlV2lsbERpc2FwcGVhciIsIm1vZHVsZVdpbGxBcHBlYXIiLCJyaXNrQ29udHJvbC5zZXRDYW5TaG93UmlzayIsInJpc2tDb250cm9sLmNoZWNrRm9yQ3VycmVuY3lJZk5lZWRlZCIsImFkdmVydEZpbHRlci5sb2FkVHJhZGVUaXBzSW5mbyIsIm1vZHVsZVdpbGxEaXNhcHBlYXIiLCJzZW5kQ29tbW9uQ29uZmlnIiwidmFpbGRQYXJhbXMiLCJjb21tb24ucGFyc2VSZXF1ZXN0UGFyYW1zIiwiY29tbW9uLnBhcnNlQ29tbW9uQ29uZmlnIiwiYWR2ZXJ0TGlzdC51cGRhdGVBZHZlcnRMaXN0V2l0aEZpbHRlclBhcmFtc05vUmVxdWVzdCIsImFkdmVydExpc3QudXBkYXRlQWR2ZXJ0TGlzdFdpdGhGaWx0ZXJQYXJhbXMiLCJvbk1lcmNoYW50QXR0ZW50aW9uQ2hhbmdlZCIsImFkdmVydExpc3QudXBkYXRlTGlzdFdpdGhGb2xsb3dTdGF0dXNDaGFuZ2VkIiwib25BZHZlcnRQcmljZUNoYW5nZWQiLCJhZHZlcnRMaXN0LnVwZGF0ZUxpc3RXaXRoQWR2ZXJ0UHJpY2VDaGFuZ2VkIiwidXBkYXRlUDJwTGlzdCIsIm5ld0NvaW5OYW1lIiwicENvaW4iLCJhZHZlcnRGaWx0ZXIudXBkYXRlU3R5bGUiLCJsb2NhdGVUbyIsInN1YlBhcmFtcyIsIm1haW5UYWIuc2hvd01haW5UYWIiLCJhZHZlcnRGaWx0ZXIudXBkYXRlU3R5bGVXaXRoRGlyZWN0aW9uIiwiaGFuZGxlV2l0aFRyYWRpbmdQYWlycyIsImtleXMiLCJ1cGRhdGVUcmFkaW5nUGFpcnMiLCJhZHZlcnRMaXN0LnJlc2V0QWR2ZXJ0TGlzdFJlcXVlc3QiLCJhZHZlcnRGaWx0ZXIudXBkYXRlU3R5bGVXaXRoVHJhZGluZ1BhaXJzIiwiYmFubmVyLnJlZnJlc2hCYW5uZXIiLCJ1cGRhdGVMaXN0IiwiYWR2ZXJ0RmlsdGVyLmNoYW5nZVNpdGUiLCJhZHZlcnRMaXN0LnJlZnJlc2hBZHZlcnRMaXN0SWZOZWVkcyIsImNoYW5nZVRyYWRlTW9kZWwiLCJtb2RlIiwib2Zmc2V0IiwiYWR2ZXJ0TGlzdC51cGRhdGVCb3R0b21PZmZzZXQiLCJhZHZlcnRGaWx0ZXIuY2hlY2tBZHZlcnRQdXNobGlzaFN0YXR1cyJdLCJtYXBwaW5ncyI6IkFBQ08sTUFBTUEsV0FBVztJQUNwQkMsT0FBTztJQUNQQyxRQUFROzs7QUFRWixNQUFNQyxhQUFhO0lBQ2ZDLFFBQVFDO0lBQ1JDLFVBQVU7SUFDVkMsVUFBVUY7SUFDVkcsY0FBYztJQUNkQyxRQUFROzs7QUFNTCxNQUFNQyxTQUFTO0lBQ2xCQyxXQUFXO0lBQ1hDLGlCQUFpQlA7SUFDakJRLGNBQWNSO0lBRWRTLFFBQVE7V0FBS1g7O0lBQ2JZLE9BQU87V0FBS1o7O0lBQ1osVUFBSWE7UUFDQSxJQUFJQyxLQUFLTCxvQkFBb0JQLFdBQVc7WUFDcEMsT0FBT0E7QUFDVjtRQUNELE9BQU9ZLEtBQUtMLG9CQUFvQlosU0FBU0MsUUFBUWdCLEtBQUtGLFFBQVFFLEtBQUtIO0FBQ3RFO0lBQ0RJLDBCQUEwQixTQUFTQztRQUMvQixPQUFNYixVQUFFQSxVQUFRRixRQUFFQSxRQUFNRyxVQUFFQSxVQUFRRSxRQUFFQSxRQUFNRCxjQUFFQSxjQUFZWSxVQUFFQSxZQUFhRDtRQUN2RSxJQUFJRSxlQUFlLENBQUU7UUFDckIsSUFBSUwsU0FBU0MsS0FBS0Q7UUFFbEIsSUFBSUksYUFBYWYsV0FBVztZQUN4QlcsU0FBU0ksWUFBWSxJQUFJSCxLQUFLRixRQUFRRSxLQUFLSDtBQUM5QztRQUVELElBQUlSLFlBQVlVLE9BQU9WLFlBQVlBLFlBQzVCRixXQUFXQyxhQUFhVyxPQUFPWixVQUFVQSxRQUFTO1lBQ3JEWSxPQUFPWixTQUFTQTtZQUNoQlksT0FBT1YsV0FBV0E7WUFDbEJlLGFBQWFqQixTQUFTQTtZQUN0QmlCLGFBQWFmLFdBQVdBO0FBQzNCO1FBRUQsSUFBSUUsZ0JBQWdCUSxPQUFPUixnQkFBZ0JBLGdCQUNwQ0QsYUFBYUYsYUFBYVcsT0FBT1QsWUFBWUEsWUFDN0NFLFVBQVVPLE9BQU9QLFVBQVVBLFFBQ2hDO1lBQ0VPLE9BQU9ULFdBQVdBO1lBQ2xCUyxPQUFPUixlQUFlQTtZQUN0QlEsT0FBT1AsU0FBU0E7WUFDaEJZLGFBQWFkLFdBQVdBO1lBQ3hCYyxhQUFhYixlQUFlQTtZQUM1QmEsYUFBYVosU0FBU0E7QUFDekI7UUFDRCxPQUFPWTtBQUNWOzs7QUFHTEMsT0FBT0MsUUFBUXBCLFlBQVlxQixTQUFRLEVBQUVDO0lBQ2pDSCxPQUFPSSxlQUFlaEIsUUFBUWUsTUFBTTtRQUNsQ0UsWUFBWTtRQUNaQyxjQUFjO1FBQ2QsR0FBQUM7WUFDRSxRQUFRbkIsT0FBT00sVUFBVU4sT0FBT00sT0FBT1MsVUFBVXRCLFdBQVdzQjtBQUM3RDtRQUNELEdBQUFLLENBQUlDO1lBQ0YsSUFBSXJCLE9BQU9NLFFBQVE7Z0JBQ2ZOLE9BQU9NLE9BQU9TLFFBQVFNO0FBQ3pCO0FBQ0Y7Ozs7QUNuRUEsSUFBSUMsYUFBYTtJQUNwQkMsYUFBYTtJQUNiQyxXQUFXO0lBQ1hDLElBQUk7SUFDSkMsWUFBWTtJQUNaQyxVQUFVO0lBQ1ZDLEtBQUs7SUFDTEMsa0JBQWtCO0lBQ2xCQyxhQUFhO0lBQ2JDLGNBQWM7OztBQUtYQyxlQUFlQyxZQUFZQyxNQUFNQyxTQUFTLElBQUlDLFNBQVMsR0FBR0MsV0FBVyxHQUFHQyxTQUFTO0lBQ3BGQyxRQUFRQyxJQUFJLFdBQVdOO0lBQ3ZCLE1BQU16QixRQUFRO1FBQ1Z5QjtRQUNBRTtRQUNBQztRQUNBQztRQUNBSDs7SUFFSjtRQUNJLElBQUlNLGlCQUFpQkEsdUJBQXVCQyxXQUFXQyxRQUFRQyxLQUFLQyxVQUFVcEM7UUFDOUUsSUFBSXFDLFdBQVdGLEtBQUtHLE1BQU1OO1FBQzFCLEtBQUlPLE1BQUVBLFFBQVNGO1FBQ2YsSUFBSUUsUUFBUSxLQUFLO1lBQ2JULFFBQVFDLElBQUksV0FBV047WUFDdkIsT0FBT1k7QUFDbkIsZUFBZTtZQUNIUCxRQUFRQyxJQUFJLHdCQUF3QlE7WUFDcEMsT0FBT0Y7QUFDVjtBQUNKLE1BQUMsT0FBT0c7UUFFTFYsUUFBUUMsSUFBSSx3QkFBd0JTO1FBQ3BDLE9BQU87QUFDVjtBQUNMOztBQUdPLFNBQVNDLFdBQVdyRDtJQUN2QixJQUFJRCxXQUFXQyxTQUFTc0Q7SUFDeEIsTUFBTUMsVUFBVSxXQUFXOUIsV0FBV0MsdURBQXVEM0I7SUFDN0YsT0FBT3dEO0FBQ1g7O0FBR0EsSUFBSUMsYUFBYTs7QUFFakIsU0FBU0MsY0FBY0MsV0FBVztJQUM5QixJQUFJQyxPQUFPLElBQUlDO0lBQ2YsSUFBSUMsUUFBUUw7SUFFWixJQUFJRyxNQUFNRSxRQUFRSCxVQUFVO1FBR3hCLE9BQU87QUFDZixXQUFXO1FBRUhGLGFBQWFHO1FBQ2IsT0FBTztBQUNWO0FBQ0w7O0FBR094QixlQUFlMkIsUUFBUUM7SUFDMUIsS0FBS04saUJBQ0Q7SUFDSlosV0FBV21CLFVBQVVEO0FBQ3pCOztBQUdPNUIsZUFBZThCLEtBQUtDLFFBQVFDLEtBQUtDO1VBQzlCdkIsV0FBV3dCLFFBQVE7UUFDckJDLFFBQVE7UUFDUkMsTUFBTUw7UUFDTkMsS0FBS0E7UUFDTEMsTUFBTXJCLEtBQUtDLFVBQVVvQjs7QUFFN0I7O0FBR09qQyxlQUFlcUMsS0FBS04sUUFBUUM7SUFDL0IsTUFBTUMsYUFBYXZCLFdBQVd3QixRQUFRO1FBQ2xDQyxRQUFRO1FBQ1JDLE1BQU1MO1FBQ05DLEtBQUtBOztJQUVULElBQUlDLFFBQVFBLFFBQVEsSUFBSTtRQUNwQixPQUFPckIsS0FBS0csTUFBTWtCO0FBQ3JCO0lBQ0QsT0FBTztBQUNYOztBQStCT2pDLGVBQWVzQyxVQUFVQyxRQUFRLElBQUlDLGFBQWEsQ0FBQTtJQUNyRCxNQUFNQyxpQkFBaUI3QixLQUFLQyxVQUFVMkI7SUFFdEMsSUFBSUUsTUFBTTtRQUNOSCxPQUFPQTtRQUNQQyxZQUFZQzs7VUFFVi9CLFdBQVc0QixVQUFVSTtBQUMvQjs7QUFHTyxTQUFTQyxrQkFBa0JsRTtJQUM5QmEsV0FBV0UsWUFBWW9ELFNBQVNuRSxNQUFNZTtJQUN0Q0YsV0FBV0MsY0FBY2QsTUFBTWM7SUFDL0JELFdBQVdHLEtBQUttRCxTQUFTbkUsTUFBTWdCO0lBQy9CSCxXQUFXSSxhQUFhakIsTUFBTWlCO0lBQzlCSixXQUFXSyxXQUFXbEIsTUFBTWtCO0lBQzVCTCxXQUFXTSxNQUFNbkIsTUFBTW1CO0lBQ3ZCTixXQUFXTyxtQkFBbUJwQixNQUFNb0I7SUFDcENQLFdBQVdRLGNBQWNyQixNQUFNcUI7SUFDL0JSLFdBQVdTLGVBQWV0QixNQUFNc0I7QUFDcEM7O0FBRU8sU0FBUzhDLGFBQWFDLFlBQVlDLGVBQWVDO0lBQ3BEQyxNQUFNSCxjQUFjRTtJQUNwQkUsT0FBT0osY0FBYztRQUFFSyxPQUFPSjs7SUFDOUIsT0FBTztRQUNISyxhQUFhRixPQUFPSjtRQUNwQk8sWUFBWUosTUFBTUg7O0FBRTFCOztBQU9PLFNBQVNRLG1CQUFtQkM7SUFDL0IsV0FBV0EsZ0JBQWdCLFlBQVlBLHVCQUF1QkMsUUFBUTtRQUNsRSxPQUFPNUMsS0FBS0csTUFBTXdDO0FBQ3JCO0lBQ0QsT0FBT0E7QUFDWDs7QUFRTyxTQUFTRSxtQkFBbUJDO0lBQy9CLElBQUlDLGVBQWVELE9BQU9FO0lBQzFCLElBQUlELGFBQWFFLFNBQVMsTUFBTTtRQUM1QixPQUFPRjtBQUNWO0lBQ0QsS0FBS0csYUFBYUMsZUFBZUosYUFBYUssTUFBTTtJQUNwREYsY0FBY0EsWUFBWUcsUUFBUSx5QkFBeUI7SUFDM0QsSUFBSUYsYUFBYTtRQUNiLE9BQU9ELGNBQWMsTUFBTUM7QUFDbkMsV0FBVztRQUNILE9BQU9EO0FBQ1Y7QUFDTDs7QUNqTUEsTUFBTUkseUJBQXlCO0lBRTNCeEcsUUFBUTtJQUVSRyxVQUFVRjtJQUVWTSxXQUFXO0lBRVhrRyxjQUFjO0lBRWRDLFVBQVU7SUFFVkMsV0FBVztJQUVYQyxRQUFRO0lBRVJDLFdBQVc7OztBQUdSLE1BQU1DLHFCQUFxQjtJQUU5QkMsVUFBVTtJQUVWQyxZQUFZO0lBRVpDLFlBQVk7SUFFWkMsYUFBYTtJQUViQyxTQUFTO0lBRVRDLFlBQVk7SUFFWkMsbUJBQW1CO0lBRW5CQyxjQUFjO09BQ1hkOzs7QUFHQSxNQUFNZSxvQkFBb0I7T0FDMUJmO0lBRUhHLFdBQVc7SUFDWGEsZUFBZTtJQUNmTCxTQUFTOzs7QUFHYixNQUFNTSxVQUFVO0lBQ1o5RyxPQUFPO1dBQUs0Rzs7SUFDWjdHLFFBQVE7V0FBS29HOztJQUNiLFNBQUFZLENBQVUxRyxVQUFVVztRQUVoQixJQUFJQSxTQUFTckIsT0FBT0MsYUFBYW9CLE1BQU0rRSxZQUFZLEdBQUc7WUFDbEQvRSxNQUFNK0UsV0FBVztBQUNwQjtRQUNELElBQUkxRixZQUFZcEIsU0FBU0MsT0FBTztZQUM1QmdCLEtBQUtGLFFBQVFnQjtBQUN6QixlQUFlO1lBQ0hkLEtBQUtILFNBQVNpQjtBQUNqQjtBQUNKO0lBQ0QsU0FBQWdHLENBQVUzRztRQUNOLE9BQU9BLFlBQVlwQixTQUFTQyxRQUFRZ0IsS0FBS0YsUUFBUUUsS0FBS0g7QUFDekQ7SUFDRCxXQUFBa0gsQ0FBWTVHO1FBQ1IsT0FBT0EsWUFBWXBCLFNBQVNDLFFBQVEseUNBQXlDO0FBQ2hGO0lBQ0QsS0FBQWdJO1FBQ0loSCxLQUFLRixRQUFRO2VBQUs0Rzs7UUFDbEIxRyxLQUFLSCxTQUFTO2VBQUtvRzs7QUFDdEI7SUFDRCxlQUFBZ0IsQ0FBZ0I5RztRQUNaLElBQUlBLFlBQVlwQixTQUFTQyxPQUFPO1lBQzVCLE9BQU9nQixLQUFLRixNQUFNNkcsa0JBQWtCLE1BQU0zRyxLQUFLRixNQUFNd0csWUFBWTtBQUM3RSxlQUFlO1lBQ0gsT0FBT3RHLEtBQUtILE9BQU91RyxjQUFjcEcsS0FBS0gsT0FBTzBHLGNBQWN2RyxLQUFLSCxPQUFPcUcsWUFBWWxHLEtBQUtILE9BQU9zRyxjQUMxRm5HLEtBQUtILE9BQU80RyxhQUFhUyxTQUFTLEtBQUtsSCxLQUFLSCxPQUFPSCxhQUFhLFNBQVVNLEtBQUtILE9BQU8yRyxvQkFBb0IsS0FDM0d4RyxLQUFLSCxPQUFPeUcsWUFBWSxNQUFNdEcsS0FBS0gsT0FBT2lHLGNBQWM7QUFDL0Q7QUFDSjs7O0FBSUwsU0FBU3FCLHdCQUF3QmhIO0lBQzdCLE9BQU95RyxRQUFRRSxVQUFVM0c7QUFDN0I7O0FBRUEsU0FBU2lIO0lBQ0xSLFFBQVFJO0FBQ1o7O0FBRUEsU0FBU0ssYUFBYWxIO0lBQ2xCeUcsUUFBUUUsVUFBVTNHLFVBQVVtRyxVQUFVO0FBQzFDOztBQUVBLFNBQVNnQixrQkFBa0JuSDtJQUN2QnlHLFFBQVFFLFVBQVUzRyxVQUFVc0csZUFBZTtBQUMvQzs7QUFFQSxTQUFTUSxnQkFBZ0I5RztJQUNyQixPQUFPeUcsUUFBUUssZ0JBQWdCOUc7QUFDbkM7O0FBRUEsU0FBU29ILG1DQUFpQ3BILFVBQVVxSDtJQUNoRFosUUFBUUMsVUFBVTFHLFVBQVU7V0FBS3lHLFFBQVFFLFVBQVUzRztXQUFjcUg7O0lBQ2pFLE9BQU9aLFFBQVFLLGdCQUFnQjlHO0FBQ25DOztBQUVBc0IsZUFBZWdHLG9CQUFrQnRIO0lBQzdCeUcsUUFBUUUsVUFBVTNHLFVBQVUwRixXQUFXO0lBQ3ZDLGFBQWE2QixvQkFBb0J2SDtBQUNyQzs7QUFFQXNCLGVBQWVrRyxxQkFBbUJ4SDtJQUM5QnlHLFFBQVFFLFVBQVUzRyxVQUFVMEY7SUFDNUIsYUFBYTZCLG9CQUFvQnZIO0FBQ3JDOztBQUVBc0IsZUFBZWlHLG9CQUFvQnZIO0lBQy9CLE1BQU15SCxXQUFXaEIsUUFBUUcsWUFBWTVHO0lBQ3JDLE1BQU15QixTQUFTZ0YsUUFBUUUsVUFBVTNHO0lBQ2pDNkIsUUFBUUMsSUFBSUksS0FBS0MsVUFBVVY7SUFDM0IsTUFBTVcsaUJBQWlCc0YsWUFBbUJELFVBQVVoRztJQUNwRCxJQUFJVyxVQUFVO1FBQ1YsSUFBSUEsU0FBU3VGLFNBQVM7WUFDbEIsT0FBTWpDLFVBQUVBLFVBQVFpQyxTQUFFQSxTQUFPQyxTQUFFQSxTQUFPQyxXQUFFQSxXQUFTdEUsTUFBRUEsTUFBSXVFLFFBQUVBLFVBQVcxRjtZQUNoRVAsUUFBUUMsSUFBSSx5REFBeUR5QjtZQUNyRWtELFFBQVFFLFVBQVUzRyxVQUFVMEYsV0FBV0E7WUFDdkMsSUFBSXFDLFVBQVVyQyxXQUFXbUM7WUFDekIsT0FBTztnQkFDSEM7Z0JBQ0FFLE9BQU96RTtnQkFDUHdFO2dCQUNBL0g7O0FBRWhCLGVBQWUsSUFBSW9DLFNBQVN3RixZQUFZM0ksV0FBVztZQUN2QzRDLFFBQVFvRyxNQUFNLG9EQUFvRDdGLFNBQVN3RjtZQUMzRSxPQUFPLENBQUU7QUFDWjtBQUNULFdBQVc7UUFFSCxPQUFPO0FBQ1Y7QUFDTDs7QUFHQXRHLGVBQWU0RztJQUVYLElBQUl6QixRQUFRRSxVQUFVL0gsU0FBU0UsUUFBUUUsVUFBVSxHQUFHO1FBQ2hELE9BQU87WUFBRWdKLE9BQU87O0FBQ25CO0lBQ0Q7UUFDSSxNQUFNNUYsaUJBQWlCc0YsWUFBbUIsd0JBQXdCO2VBQUtqQixRQUFRRSxVQUFVL0gsU0FBU0U7WUFBU29ILGFBQWE7WUFBR1IsVUFBVTtZQUFHeUMsVUFBVTs7UUFDbEosT0FBTVIsU0FBRUEsU0FBT0MsU0FBRUEsU0FBT3JFLE1BQUVBLFFBQVNuQjtRQUNuQyxJQUFJdUYsU0FBUztZQUNUOUYsUUFBUUMsSUFBSSx5REFBeUR5QjtZQUNyRSxPQUFPO2dCQUNIeUUsT0FBT3pFOztBQUV2QixlQUFlO1lBQ0gxQixRQUFRb0csTUFBTSxvREFBb0RMO1lBQ2xFLE9BQU8sQ0FBRTtBQUNaO0FBQ0osTUFBQyxPQUFPSztRQUNMcEcsUUFBUW9HLE1BQU0sbURBQW1EQTtRQUNqRSxPQUFPO0FBQ1Y7QUFDTDs7QUN2S0EzRyxlQUFlbUQ7SUFDWDVDLFFBQVFDLElBQUk7QUFDaEI7O0FBR0EsTUFBTXNHLGFBQWE7SUFDZkMsYUFBYTtJQUNiQyxpQkFBaUI7SUFDakJDLGNBQWM7SUFFZEMsc0JBQXNCO0lBQ3RCQyx3QkFBd0I7OztBQUc1QixNQUFNQyxzQkFBc0I7SUFDeEJDLFVBQVU7SUFDVkMsb0JBQW9CO0lBQ3BCQyxnQkFBZ0I7SUFDaEJDLFlBQVk7SUFDWmxELFFBQVE7SUFDUm1ELGlCQUFpQjtJQUNqQmxELFdBQVc7SUFDWG1ELG9CQUFvQjtJQUNwQkMsZUFBZTtJQUNmQyxVQUFVO0lBQ1ZDLFdBQVc7SUFDWC9KLGNBQWM7SUFDZGdLLGFBQWE7UUFDVEMsV0FBVzs7SUFFZkMsY0FBYztRQUNWRCxXQUFXOzs7O0FBSW5CLG1CQUFRMUUsY0FBVUQsYUFBRUEsaUJBQWdCNkUsYUFDaEMsYUFDQTlFLE9BQ0ErRTs7QUFHSixNQUFNQyxlQUFhLENBQUE7O0FBRW5CdkosT0FBT0MsUUFBUXVJLHFCQUFxQnRJLFNBQVEsRUFBRUMsTUFBTXFKO0lBQ2hEeEosT0FBT0ksZUFBZW1KLGNBQVlwSixNQUFNO1FBQ3BDRSxZQUFZO1FBQ1pDLGNBQWM7UUFDZCxHQUFBQztZQUNJLE1BQU1iLFNBQVMrRSxhQUFXM0UsYUFBYXBCLFNBQVNFLFNBQzFDNkYsYUFBV2pGLFNBQ1hpRixhQUFXaEY7WUFDakIsT0FBT0MsT0FBT1MsU0FBU3FKO0FBQzFCO1FBQ0QsR0FBQWhKLENBQUlDO1lBQ0EsTUFBTWYsU0FBUytFLGFBQVczRSxhQUFhcEIsU0FBU0UsU0FDMUM2RixhQUFXakYsU0FDWGlGLGFBQVdoRjtZQUNqQkMsT0FBT1MsUUFBUU07QUFDbEI7Ozs7QUFLVCxTQUFTNkk7SUFDTCxPQUFPO1FBQ0h4SixVQUFVcEIsU0FBU0M7UUFDbkJhLFFBQVE7ZUFBS2dKOztRQUNiL0ksT0FBTztlQUFLK0k7O1FBRVppQixhQUFhO1FBQ2JDLG9CQUFvQjtRQUNwQkMsa0JBQWtCO1FBQ2xCQyxjQUFjO1FBQ2RDLGVBQWU7UUFDZkMscUJBQXFCO1FBQ3JCQyxzQkFBc0I7UUFFdEIsZUFBQUMsQ0FBZ0JDLE1BQU1DLE9BQU87WUFDekIsSUFBSUQsUUFBUSxHQUFHO2dCQUNYdEssS0FBS21LLHNCQUFzQkksS0FBS3JELFNBQVMsSUFBSSxZQUFZO2dCQUN6RGxILEtBQUtvSyx1QkFBdUI7Z0JBQzVCcEssS0FBS2dLLG1CQUFtQk8sS0FBS3JELFNBQVMsSUFBSSxZQUFZO2dCQUV0RCxJQUFJbEgsS0FBS2lLLGlCQUFpQk0sTUFBTTtvQkFDNUJ2SyxLQUFLaUssZUFBZU07QUFDdkI7QUFDakIsbUJBQW1CLElBQUlELFFBQVEsR0FBRztnQkFDbEJ0SyxLQUFLbUssc0JBQXNCO2dCQUMzQm5LLEtBQUtvSyx1QkFBdUJHLEtBQUtyRCxTQUFTLElBQUksWUFBWTtnQkFDMURsSCxLQUFLZ0ssbUJBQW1CTyxLQUFLckQsU0FBUyxJQUFJLFlBQVk7Z0JBQ3RELElBQUlsSCxLQUFLa0ssa0JBQWtCSyxNQUFNO29CQUM3QnZLLEtBQUtrSyxnQkFBZ0JLO0FBQ3hCO0FBQ2pCLG1CQUFtQjtnQkFDSHZLLEtBQUttSyxzQkFBc0JuSyxLQUFLaUssYUFBYS9DLFNBQVMsSUFBSSxZQUFZO2dCQUN0RWxILEtBQUtvSyx1QkFBdUJwSyxLQUFLa0ssY0FBY2hELFNBQVMsSUFBSSxZQUFZO2dCQUN4RWxILEtBQUtnSyxvQkFBb0JoSyxLQUFLaUssYUFBYS9DLFNBQVMsS0FBS2xILEtBQUtrSyxjQUFjaEQsU0FBUyxLQUFLLElBQUksWUFBWTtBQUM3RztBQUNKOztBQUVUOztBQUVBckMsY0FBWTJGLCtCQUErQjtJQUN2QzFGLGFBQVdpRixxQkFBcUI7SUFDaEN4QixXQUFXSSx1QkFBdUI7OztBQUd0QzlELGNBQVk0RixxQkFBcUI7SUFDN0IzRixhQUFXa0YsbUJBQW1CO0lBQzlCekIsV0FBV0sseUJBQXlCO0lBRXBDOEIsVUFBaUI1RixhQUFXM0UsWUFBWXBCLFNBQVNDLFFBQVEseUJBQXlCLGtCQUFrQjtRQUNoRzJMLFVBQVk7UUFDWkMsTUFBUUM7Ozs7QUFJVCxTQUFTQyx5QkFBeUJ4QjtJQUNyQ00sYUFBV04sWUFBWUE7SUFDdkIsSUFBSXlCLGNBQWM7UUFDZHZCLFdBQVc7O0lBRWYsSUFBSXdCLGdCQUFnQjtRQUNoQnhCLFdBQVc7O0lBRWYsSUFBSUYsYUFBYSxPQUFPO1FBQ3BCTSxhQUFXTCxjQUFjeUI7UUFDekJwQixhQUFXSCxlQUFlc0I7QUFDbEMsV0FBVyxJQUFJekIsYUFBYSxRQUFRO1FBQzVCTSxhQUFXTCxjQUFjd0I7UUFDekJuQixhQUFXSCxlQUFldUI7QUFDN0I7SUFFREM7QUFDSjs7QUFFQSxTQUFTQztJQUNMQyxhQUF5QjFMLE9BQU9FO0lBQ2hDLElBQUlGLE9BQU9FLG1CQUFtQlosU0FBU0UsUUFBUTtRQUMzQ21NLGtCQUE4QnJNLFNBQVNFO0FBQzFDO0FBQ0w7O0FBRUE0RixjQUFZd0csaUNBQWlDNUosTUFBTzZIO0lBQ2hELElBQUlNLGFBQVdOLGFBQWFBLFdBQVc7UUFDbkM7QUFDSDtJQUNEd0IseUJBQXlCeEI7SUFFekI0QjtJQUVBL0ksV0FBV21KLGdCQUFnQjtRQUFFMUgsUUFBUTtRQUErQmhDLFFBQVEwSDs7SUFFNUUzRSxPQUFPNEcsK0JBQStCakM7SUFFdENrQyx5QkFBeUJDLGdCQUE0QmhNLE9BQU9FO0lBRzVEK0ssVUFBaUI1RixhQUFXM0UsWUFBWXBCLFNBQVNDLFFBQVEseUJBQXlCLGtCQUFrQjtRQUNoRzJMLFVBQVk7UUFDWmUsS0FBT3BDLGFBQWEsUUFBUSwrQkFBK0I7UUFDM0RxQyxXQUFhbE0sT0FBT00sT0FBT1Y7UUFDM0J1TCxNQUFRdEI7Ozs7QUFJaEJ6RSxjQUFZK0csc0NBQXNDO0lBQzlDekosV0FBV21KLGdCQUFnQjtRQUN2QjFILFFBQVE7UUFDUmhDLFFBQVE7Ozs7QUFJaEJpRCxjQUFZZ0gsOEJBQThCO0lBQ3RDMUosV0FBV21KLGdCQUFnQjtRQUN2QjFILFFBQVE7Ozs7QUFJaEJpQixjQUFZaUgsZ0NBQWdDO0lBQ3hDM0osV0FBV21KLGdCQUFnQjtRQUN2QjFILFFBQVE7Ozs7QUFJaEJpQixjQUFZa0gsZ0NBQWdDdEs7SUFDeENtSSxhQUFXZCxZQUFZYyxhQUFXZDtJQUNsQ2MsYUFBV2IscUJBQXFCYSxhQUFXZCxXQUFXLDhDQUE4QztJQUNwR25FLE9BQU9xSCw4QkFBOEJwQyxhQUFXZDtJQUdoRDRCLFVBQWlCNUYsYUFBVzNFLFlBQVlwQixTQUFTQyxRQUFRLHlCQUF5QixrQkFBa0I7UUFDaEcyTCxVQUFZO1FBQ1pzQixNQUFRckMsYUFBV2Q7UUFDbkI4QixNQUFRQzs7OztBQUloQmhHLGNBQVlxSCw0QkFBNEI7SUFDcEMvSixXQUFXbUosZ0JBQWdCO1FBQ3ZCMUgsUUFBUTs7SUFJWjhHLFVBQWlCNUYsYUFBVzNFLFlBQVlwQixTQUFTQyxRQUFRLHlCQUF5QixrQkFBa0I7UUFDaEcyTCxVQUFZO1FBQ1pnQixXQUFhbE0sT0FBT00sT0FBT1Y7UUFDM0J1TCxNQUFRQzs7OztBQUloQixTQUFTVyx5QkFBeUJ2RTtJQUM5QjJDLGFBQVdQLFdBQVdwQyxrQkFBa0IsaURBQWlEO0FBQzdGOztBQUVPLFNBQVNrRixZQUFZQyxxQkFBcUIvTTtJQUM3Q1csS0FBS3FNLDRCQUE0QmhOLFVBQVUrTSxvQkFBb0I3TTtJQUMvRHFLLGFBQVc3RCxTQUFTcUcsb0JBQW9CckcsVUFBVTNHLFlBQVlnTixvQkFBb0JyRyxTQUFTNkQsYUFBVzdEO0lBQ3RHNkQsYUFBV1Ysa0JBQWtCVSxhQUFXN0QsT0FBT3VHLE9BQU9wRixXQUFXLElBQUksNkJBQTZCO0lBQ2xHc0UseUJBQXlCWSxvQkFBb0JHO0lBRTdDLElBQUlILG9CQUFvQnBHLGFBQWE1RyxXQUFXO1FBQzVDLElBQUlvTixvQkFBb0I1QyxhQUFXNUQsYUFBYTRELGFBQVc1RCxjQUFjLE9BQU9vRyxvQkFBb0JwRyxjQUFjO1FBQ2xINEQsYUFBV1QscUJBQXFCcUQsb0JBQW9CLCtCQUErQjtBQUMzRixXQUFXO1FBQ0gsSUFBSUEsb0JBQW9CSixvQkFBb0JwRyxhQUFhb0csb0JBQW9CcEcsY0FBYztRQUMzRjRELGFBQVc1RCxZQUFZd0csb0JBQW9CSixvQkFBb0JwRyxZQUFZO1FBQzNFNEQsYUFBV1QscUJBQXFCcUQsb0JBQW9CLCtCQUErQjtBQUN0RjtBQUVMOztBQUVPLFNBQVNILDRCQUE0QmhOLFVBQVVFLGNBQWNZO0lBQ2hFLE1BQU1KLFNBQVNJLFlBQVlmLFlBQWFlLFlBQVlwQixTQUFTQyxRQUFROEYsYUFBV2hGLFFBQVFnRixhQUFXakYsU0FBVStKO0lBQzdHLElBQUl2SyxZQUFZRCxXQUFXO1FBQ3ZCVyxPQUFPaUosaUJBQWlCM0osU0FBU29OO1FBRWpDMU0sT0FBT2tKLGFBQWF5RCxXQUFrQnJOO0FBQ3pDO0lBQ0QsSUFBSUUsZ0JBQWdCSCxXQUFXO1FBQzNCVyxPQUFPUixlQUFlQTtBQUN6QjtBQUNMOztBQUdPa0MsZUFBZWtMO0lBQ2xCLElBQUlwRSxXQUFXSSxzQkFBc0I7UUFDakM7QUFDSDtJQUNELElBQUlpRSxjQUFjQyxRQUFRQyxJQUFJLEVBQzFCakYsWUFBbUIsMkJBQ25CQSxZQUFtQiwyQkFBMkI7UUFDMUNoQyxVQUFZO1FBQ1pRLGFBQWU7O0lBR3ZCLElBQUkwRyxTQUFTSCxNQUFNLEdBQUdsSixLQUFLc0o7SUFDM0IsSUFBSUMsWUFBWUwsTUFBTSxHQUFHbEosS0FBS3dELFNBQVM7SUFDdkMsSUFBSWdHLGFBQWFILFVBQVVFO0lBQzNCbkksYUFBV2lGLHFCQUFxQm1ELFdBQVcsWUFBWTtJQUN2RCxJQUFJQSxVQUFVO1FBQ1ZwSSxhQUFXZ0YsY0FBY3FELGdCQUFnQkMsTUFBTUMscUNBQXFDRCxNQUFNRSx3Q0FBd0M7QUFDMUksV0FBVztRQUNIeEksYUFBV2dGLGNBQWM7QUFDNUI7QUFDTDs7QUFFQSxTQUFTcUQsZ0JBQWdCSSxTQUFTQyxXQUFXQztJQUN6QyxNQUFNQyxRQUFRQyxXQUFrQjFNLGFBQWEsSUFBSSxZQUFZO0lBQzdELElBQUkyTSxPQUFPLHVEQUF1REYsV0FBV0g7SUFDN0UsSUFBSU0saUJBQWlCLHVGQUF1Rkw7SUFDNUcsT0FBTyxHQUFHSSxlQUFlSCxjQUFjSTtBQUMzQzs7QUFFQSxTQUFTQyxhQUFhL04sUUFBUTZCLFNBQVM7SUFDbkMsUUFBUTdCO01BQ0osS0FBSztRQUNEb0MsV0FBV21KLGdCQUFnQjtZQUN2QjFILFFBQVE7WUFDUmhDLFFBQVE7Z0JBQ0o3QjtnQkFDQTZCOzs7UUFHUjs7TUFDSjtRQUNJbU0sUUFBZWhPO1FBQ2Y7O0FBRVo7O0FBRUE4RSxjQUFZbUosc0JBQXNCO0lBQzlCRixhQUFhO0lBQ2JwRCxVQUFpQjVGLGFBQVczRSxZQUFZcEIsU0FBU0MsUUFBUSx5QkFBeUIsa0JBQWtCO1FBQ2hHMkwsVUFBWTs7QUFFcEI7O0FBRUE5RixjQUFZb0osY0FBYztJQUV0QixJQUFJTixXQUFrQnpNLE1BQU0sR0FBRztRQUMzQjZNLFFBQWU7QUFDdkIsV0FBVztRQUVINUwsV0FBV21KLGdCQUFnQjtZQUN2QjFILFFBQVE7WUFDUmhDLFFBQVE7Z0JBQ0o3QixRQUFROzs7QUFHbkI7SUFDRDJLLFVBQWlCNUYsYUFBVzNFLFlBQVlwQixTQUFTQyxRQUFRLHlCQUF5QixrQkFBa0I7UUFDaEcyTCxVQUFZOztBQUVwQjs7QUFFQTlGLGNBQVlxSixlQUFlek07SUFDdkIsSUFBSW1MLGNBQWNDLFFBQVFDLElBQUksRUFDMUJqRixZQUFtQixrQkFDbkJBLFlBQW1CLCtCQUErQjtRQUFFcEUsS0FBSzs7SUFFN0QsT0FBTTBLLGFBQUVBLGFBQVdDLGtCQUFFQSxvQkFBcUJ4QixNQUFNLEdBQUdsSjtJQUNuRCxPQUFNMkssdUJBQUVBLHlCQUEwQnpCLE1BQU0sR0FBR2xKO0lBQzNDMUIsUUFBUUMsSUFBSSxtQ0FBbUNxTTtJQUMvQyxJQUFJQSxZQUFZO0lBQ2hCLElBQUlELGlDQUFpQ0UsU0FBUztRQUMxQ0QsWUFBWUQ7QUFDZjtJQUNELElBQUlDLFdBQVc7UUFDWCxJQUFJSCxhQUFhO1lBRWJMLGFBQWE7QUFDekIsZUFBZTtZQUVIQSxhQUFhO0FBQ2hCO0FBQ1QsV0FBVztRQUNILElBQUlNLGtCQUFrQjtZQUVsQk4sYUFBYTtBQUN6QixlQUFlO1lBRUhBLGFBQWE7QUFDaEI7QUFDSjtJQUdEcEQsVUFBaUI1RixhQUFXM0UsWUFBWXBCLFNBQVNDLFFBQVEseUJBQXlCLGtCQUFrQjtRQUNoRzJMLFVBQVk7O0FBRXBCOztBQUdBOUYsY0FBWTJKLGdDQUFnQyxTQUFVck87SUFDbEQ2QixRQUFRQyxJQUFJLHFDQUFxQzlCO0lBQ2pEZ0MsV0FBV21KLGdCQUFnQjtRQUN2QjFILFFBQVE7O0FBRWhCOztBQUlBbkMsZUFBZXdKO0lBQ1gsSUFBSTFDLFdBQVdLLHdCQUF3QjtRQUNuQztBQUNIO0lBQ0QsSUFBSTZGLGdDQUFnQ2hOO1FBQ2hDLEtBQUs4RyxXQUFXRSxpQkFBaUI7WUFDN0IsSUFBSWlHLFlBQVk3RyxZQUFtQjtZQUNuQ1UsV0FBV0Usa0JBQWtCaUcsSUFBSWhMLEtBQUtpTCxhQUFhO1lBQ25ELEtBQUtwRyxXQUFXRSxpQkFBaUI7Z0JBQzdCLE9BQU8wRSxnQkFBZ0JDLE1BQU13Qiw0QkFBNEJ4QixNQUFNeUIsdUJBQXVCO0FBQ3RHLG1CQUFtQjtnQkFDSCxPQUFPO0FBQ1Y7QUFDYixlQUFlO1lBQ0gsT0FBTztBQUNWO0FBQ0o7SUFFRCxJQUFJakYsYUFBV04sYUFBYSxPQUFPO1FBQy9CLElBQUlpQixhQUFha0U7UUFDakIsSUFBSWxFLEtBQUtyRCxVQUFVLEdBQUc7WUFDbEIsS0FBS3FCLFdBQVdHLGNBQWM7Z0JBQzFCLElBQUlvRyxrQkFBa0JqSCxZQUFtQjtnQkFDekNVLFdBQVdHLGVBQWVvRyxVQUFVcEwsS0FBS3FMLGlCQUFpQjtnQkFDMUQsS0FBS3hHLFdBQVdHLGNBQWM7b0JBQzFCNkIsT0FBTzRDLGdCQUFnQkMsTUFBTTRCLDZCQUE2QjVCLE1BQU02Qiw0Q0FBNEM7QUFDL0c7QUFDSjtBQUNKO1FBQ0RuSyxhQUFXdUYsZ0JBQWdCLEdBQUdFO0FBQ3RDLFdBQVc7UUFFSCxJQUFJQSxPQUFPO1FBQ1gsS0FBS2hDLFdBQVdDLGFBQWE7WUFDekIsSUFBSTBHLG1CQUFtQnJILFlBQW1CO1lBQzFDVSxXQUFXQyxjQUFjMEcsV0FBV3hMLEtBQUt3RCxTQUFTO1lBQ2xELEtBQUtxQixXQUFXQyxhQUFhO2dCQUN6QitCLE9BQU80QyxnQkFBZ0JDLE1BQU0rQixpQ0FBaUMvQixNQUFNZ0Msa0RBQWtEO0FBQ3RJLG1CQUFtQjtnQkFDSDdFLGFBQWFrRTtBQUNoQjtBQUNiLGVBQWU7WUFDSGxFLGFBQWFrRTtBQUNoQjtRQUNEM0osYUFBV3VGLGdCQUFnQixHQUFHRTtBQUNqQztJQUNELElBQUkyQyxXQUFXcEksYUFBV21GLGFBQWEvQyxTQUFTLEtBQUtwQyxhQUFXb0YsY0FBY2hELFNBQVM7SUFFdkYsSUFBSWdHLFVBQVU7UUFDVnhDLFVBQWlCNUYsYUFBVzNFLFlBQVlwQixTQUFTQyxRQUFRLHlCQUF5QixrQkFBa0I7WUFDaEcyTCxVQUFZZixhQUFXTixhQUFhLFFBQVEseUJBQXlCOztBQUU1RTtBQUNMOztBQUVPLFNBQVMrRjtJQUNacEU7SUFDQSxJQUFJeEwsT0FBT0csZ0JBQWdCLE1BQU07UUFDN0IrTTtBQUNSLFdBQVc7UUFDSDdILGFBQVdpRixxQkFBcUI7QUFDbkM7QUFDTDs7QUFFTyxTQUFTdUYsV0FBV0M7SUFDdkJ6SyxhQUFXM0UsV0FBV29QO0lBRXRCLElBQUkzRixhQUFXWCxjQUFjLElBQUk7UUFDN0JXLGFBQVdYLGFBQWF5RCxXQUFrQjlDLGFBQVdaO0FBQ3hEO0lBQ0RxRztJQUVBM0UsVUFBaUI1RixhQUFXM0UsWUFBWXBCLFNBQVNDLFFBQVEseUJBQXlCLGtCQUFrQjtRQUNoRzJMLFVBQVk7O0FBRXBCOztBQUVPLFNBQVNFO0lBQ1osT0FBT2pCLGFBQVdOO0FBQ3RCOztBQUVPLFNBQVNrRztJQUNaLE9BQU81RixhQUFXN0Q7QUFDdEI7O0FBRU8sU0FBUzBKO0lBQ1osT0FBTzdGLGFBQVc1RDtBQUN0Qjs7QUFFQW5CLGNBQVlpSixlQUFlQTs7QUNyYzNCLE9BQVFoSixZQUFBQSxnQkFBZTRFLGFBQ25CLGNBQ0EsV0FDQUM7O0FBR0osU0FBU0E7SUFDTCxNQUFNK0YsY0FBYztRQUNoQnZILE9BQU87UUFDUHdILGVBQWU7UUFDZkMsZUFBZTs7SUFFbkIsT0FBTztRQUNIelAsVUFBVXBCLFNBQVNDO1FBQ25CYSxRQUFRO2VBQUs2UDs7UUFDYjVQLE9BQU87ZUFBSzRQOztRQUVaLFFBQUFHO1lBQ0ksT0FBTzdQLEtBQUtHLGFBQWFwQixTQUFTRSxTQUFTZSxLQUFLSCxPQUFPc0ksUUFBUW5JLEtBQUtGLE1BQU1xSTtBQUM3RTtRQUNELFFBQUEySCxDQUFTaFA7WUFDTCxJQUFJZixTQUFTQyxLQUFLRyxhQUFhcEIsU0FBU0UsU0FBU2UsS0FBS0gsU0FBU0csS0FBS0Y7WUFDcEVDLE9BQU9vSSxRQUFRckg7WUFDZixJQUFJNk0sV0FBa0J6TSxNQUFNLEdBQUc7Z0JBQzNCbkIsT0FBTzRQLGdCQUFnQjdPLE1BQU1vRyxTQUFTLElBQUksT0FBTztnQkFDakRuSCxPQUFPNlAsZ0JBQWdCO0FBQ3ZDLG1CQUFtQjtnQkFDSCxNQUFNRyxlQUFlQyxLQUFLQyxNQUFNdEMsV0FBa0JwTSxjQUFjLE1BQUksS0FBRztnQkFDdkV4QixPQUFPNFAsZ0JBQWdCN08sTUFBTW9HLFNBQVMsSUFBSSxHQUFHNkksbUJBQW1CO2dCQUNoRWhRLE9BQU82UCxnQkFBZ0I5TyxNQUFNb0csU0FBUyxJQUFJLE9BQU87QUFDcEQ7QUFDSjtRQUNELFVBQUFnSjtZQUNJbFEsS0FBS0gsU0FBUzttQkFBSzZQOztZQUNuQjFQLEtBQUtGLFFBQVE7bUJBQUs0UDs7QUFDckI7O0FBRVQ7O0FBRU9qTyxlQUFlME8sY0FBYzdGLE1BQU0vSyxjQUFjNlEsUUFBUTtJQUU1RCxJQUFJOUYsUUFBUWxMLGFBQWFHLGFBQWEySCxVQUFVLEdBQUc7UUFDL0M7QUFDSDtJQUNEcEMsYUFBVzNFLFdBQVdtSztJQUV0QixJQUFJcUQsV0FBa0J6TSxNQUFNLEdBQUc7UUFDM0IsSUFBSW5CLFNBQVN1SyxTQUFTdkwsU0FBU0UsU0FBUzZGLGFBQVdoRixRQUFRZ0YsYUFBV2pGO1FBQ3RFRSxPQUFPNFAsZ0JBQWdCO0FBQzFCO0lBQ0QsSUFBSVMsT0FBTztRQUNQdEwsYUFBV29MO0FBQ2Q7SUFFRCxJQUFJRyxhQUFhdkwsYUFBVytLO0lBQzVCLElBQUlRLFdBQVduSixVQUFVLEdBQUk7UUFDekIsSUFBSWlCLGNBQWNtSSxtQkFBbUJoRyxNQUFNL0s7UUFDM0N1RixhQUFXZ0wsU0FBUzNIO0FBQzVCLFdBQVM7UUFDRHJELGFBQVdnTCxTQUFTTztBQUN2QjtBQUNMOztBQUVBNU8sZUFBZTZPLG1CQUFtQmhHLE1BQU0vSztJQUdwQyxJQUFJZ1IsVUFBVWpHLFFBQVF2TCxTQUFTRSxTQUFTLFFBQVE7SUFDaEQsS0FBSXlFLE1BQUVBLGNBQWVtRSxZQUFtQix5QkFBeUI7UUFDN0QySSxXQUFhO1FBQ2JDLGtCQUFvQjtRQUNwQkYsU0FBV0E7UUFDWEcsbUJBQXFCblI7O0lBRXpCLElBQUltRSxRQUFRQSxLQUFLaU4sVUFBVTtRQUN2QixJQUFJQyxTQUFTakQsV0FBa0IxTSxhQUFhLElBQUksUUFBUTtRQUV4RCxJQUFJa0gsUUFBUXpFLEtBQUtpTixTQUFTRSxRQUFPQyxRQUFRQSxLQUFLdkQsUUFBUXdELE1BQUtDLGVBQWVBLFlBQVkxRyxTQUFTO1FBQy9GbkMsUUFBUUEsTUFBTWhFLEtBQUkyTTtZQUVkLE1BQU1HLGFBQWFILEtBQUt2RCxRQUFRc0QsUUFBT0c7Z0JBQ25DLElBQUlBLFlBQVkxRyxTQUFTLEdBQUc7b0JBQ3hCLE9BQU87QUFDVjtnQkFDRCxJQUFJMEcsWUFBWTFHLFNBQVMsSUFBSTtvQkFDekIwRyxZQUFZMUcsT0FBTztvQkFDbkIwRyxZQUFZbFEsUUFBUWtRLFlBQVlsUSxNQUFNOFAsV0FBV0ksWUFBWWxRO0FBQ2hFO2dCQUNELE9BQU87O1lBRVgsT0FBTzttQkFBS2dRO2dCQUFNdkQsU0FBUzBEOzs7UUFFL0IsSUFBSTlJLE1BQU1qQixTQUFTLEdBQUc7WUFDbEIsT0FBTzdFLEtBQUtDLFVBQVU2RjtBQUN6QjtBQUNKO0lBQ0QsT0FBTztBQUNYOztBQ2pHQSxtQkFBUXJELGNBQVVELGFBQUVBLGlCQUFnQjZFLGFBQ2hDLGVBQ0EsV0FDQUM7O0FBR0osU0FBU0E7SUFDTCxPQUFPO1FBQ0g3SixPQUFPO1lBQ0gwSixXQUFXO1lBQ1gwSCxpQkFBaUI7WUFDakJDLG1CQUFtQjtZQUNuQkMscUJBQXFCOztRQUV6QnZSLFFBQVE7WUFDSjJKLFdBQVc7WUFDWDBILGlCQUFpQjtZQUNqQkMsbUJBQW1CO1lBQ25CQyxxQkFBcUI7O1FBRXpCQyxpQkFBaUI7UUFDakJDLGNBQWM7UUFDZEosaUJBQWlCO1FBQ2pCSyxrQkFBa0I7O0FBRTFCOztBQU1BLFNBQVNDLGVBQWVDO0lBQ3BCM00sYUFBV2hGLE1BQU1vUixrQkFBa0JPLGFBQWEsSUFBSSxZQUFZO0lBQ2hFM00sYUFBV2pGLE9BQU9xUixrQkFBa0JPLGFBQWEsSUFBSSxrQ0FBa0M7SUFDdkYzTSxhQUFXb00sa0JBQWtCTyxhQUFhLElBQUksWUFBWTtJQUMxRDNNLGFBQVd5TSxtQkFBbUJFLGFBQWEsSUFBSSxZQUFZO0lBQzNEM00sYUFBV2hGLE1BQU0wSixZQUFhaUksYUFBYSxLQUFLOUQsV0FBa0IxTSxhQUFhLElBQUssWUFBWTtJQUVoRyxJQUFJME0sV0FBa0J6TSxNQUFNLEdBQUc7UUFDM0I0RCxhQUFXakYsT0FBT3NSLG9CQUFvQk0sYUFBYSxJQUFJLFNBQVM7UUFDaEUzTSxhQUFXakYsT0FBT3VSLHNCQUFzQkssYUFBYSxJQUFJLFNBQVM7UUFDbEUzTSxhQUFXaEYsTUFBTXFSLG9CQUFvQk0sYUFBYSxJQUFJLFlBQVk7UUFDbEUzTSxhQUFXaEYsTUFBTXNSLHNCQUFzQkssYUFBYSxJQUFJLFlBQVk7QUFDNUUsV0FBVztRQUNIM00sYUFBV2pGLE9BQU9zUixvQkFBb0I7UUFDdENyTSxhQUFXakYsT0FBT3VSLHNCQUFzQjtRQUN4Q3RNLGFBQVdoRixNQUFNcVIsb0JBQW9CO1FBQ3JDck0sYUFBV2hGLE1BQU1zUixzQkFBc0I7QUFDMUM7QUFDTDs7QUFNQTNQLGVBQWVpUSxlQUFlQyxPQUFPQyxhQUFhO0lBQzlDO1FBQ0ksSUFBSTlNLGFBQVcrTSx5QkFBeUJGLE9BQU87UUFDL0M3TSxhQUFXK00sdUJBQXVCRjtRQUNsQ0gsZUFBZUc7UUFDZmhOLE9BQU9tTixnQkFBZ0JILE9BQU9DO0FBQ2pDLE1BQUMsT0FBT0c7UUFDTC9QLFFBQVFDLElBQUk4UDtBQUNmO0FBQ0w7O0FBRU90USxlQUFldVEsWUFBWUw7SUFDOUI3TSxhQUFXdU0sa0JBQWtCO0lBQzdCdk0sYUFBV3dNLGVBQWU7SUFDMUJJLGVBQWVDLE9BQU87QUFDMUI7O0FBRUE5TSxjQUFZNk0saUJBQWlCQTs7QUN4RTdCLG1CQUFRNU0sY0FBVUQsYUFBRUEsaUJBQWdCNkUsYUFDaEMsa0JBQ0EsV0FDQUM7O0FBR0osU0FBU0E7SUFDTCxPQUFPO1FBQ0hzSSxVQUFVO1lBQ05DLFdBQVc7WUFDWEMsT0FBTy9FLE1BQU1nRjtZQUNiN0UsU0FBUTtZQUNSOEUsYUFBYWpGLE1BQU1rRjs7UUFFdkJuSyxPQUFNO1FBQ05vSyxXQUFVOztBQUVsQjs7QUFFTzlRLGVBQWUrUTtJQUNsQixJQUFJMU4sYUFBV3FELE1BQU1qQixTQUFTLEdBQUc7UUFDN0I7QUFDSDtJQUNELE1BQU0zRSxpQkFBaUJzRixZQUFtQjtJQUMxQzdGLFFBQVFDLElBQUksOENBQThDTTtJQUMxRCxJQUFJQSxVQUFVO1FBQ1ZtQyxNQUFNK04sY0FBY3RLLFFBQVM1RixTQUFTbUIsUUFBUTtRQUM5Q2dCLE1BQU0rTixjQUFjRixZQUFZO0FBQ25DO0FBQ0w7O0FBTU8sU0FBU0csa0JBQWtCcFQ7SUFDOUIsV0FBV0EsYUFBYSxVQUFVLE9BQU87SUFDekMsSUFBSXFULGNBQWM7SUFDbEJqTyxNQUFNK04sY0FBY3RLLE1BQU01SCxTQUFRdVE7UUFDOUIsSUFBSUEsS0FBS3hSLFNBQVNtTixrQkFBa0JuTixTQUFTbU4sZUFBZTtZQUN4RGtHLGNBQWM3QixLQUFLNkI7QUFDdEI7O0lBRUwsT0FBT0E7QUFDWDs7QUFFTyxTQUFTQyxhQUFhclQ7SUFDekIsSUFBSW9ULGNBQWNELGtCQUFrQm5ULGVBQWU7UUFDL0NtRixNQUFNK04sY0FBY1IsU0FBUzFFLFVBQVVILE1BQU15RixxQ0FBcUNuTixRQUFRLFNBQVNpTixhQUFhak4sUUFBUSxTQUFTbkc7UUFDakltRixNQUFNK04sY0FBY1IsU0FBU0MsWUFBWTtRQUN6QyxPQUFPO0FBQ1Y7SUFDRCxPQUFPO0FBQ1g7O0FBRUFyTixjQUFZaU8sYUFBYTtJQUNyQnBPLE1BQU0rTixjQUFjUixTQUFTQyxZQUFZO0FBQzdDOztBQ3JEQSxtQkFBUXBOLGNBQVVELGFBQUVBLGlCQUFnQjZFLGFBQ2hDLGVBQ0E7SUFDSTFILFFBQVFDLElBQUk7QUFDZixJQUNEMEg7O0FBR0osU0FBU0E7SUFDTCxPQUFPO1FBQ0g3SixPQUFPaVQ7UUFDUGxULFFBQVFrVDs7QUFFaEI7O0FBRUEsU0FBU0E7SUFDTCxPQUFPO1FBQ0hDLGVBQWU7UUFDZkMsZ0JBQWdCO1FBQ2hCQyxhQUFhO1FBQ2JDLGVBQWU7UUFDZkMsZ0JBQWdCO1FBQ2hCbkwsUUFBUTtRQUNSRSxPQUFPO1FBQ1BrTCxjQUFjO1FBQ2RDLG9CQUFvQjtRQUNwQkMsY0FBYztRQUNkQyxXQUFXL1QsT0FBT0MsYUFBYSxRQUN4QjBOLE1BQU1xRyw0QkFBNEIsd0JBQ2xDckcsTUFBTXNHLGFBQWE7UUFDMUJDLGtCQUFrQjtRQUNsQkMsY0FBYzs7QUFFdEI7O0FBRUEsTUFBTWhLLGFBQWE7SUFDZmlLLGFBQWE7SUFDYkMsWUFBWTtJQUNaLFFBQUFqRSxDQUFTMVA7UUFDTCxPQUFPQSxZQUFZcEIsU0FBU0MsUUFBUWdCLEtBQUs4VCxhQUFhOVQsS0FBSzZUO0FBQzlEO0lBQ0QsUUFBQS9ELENBQVMzUCxVQUFVVztRQUNmLElBQUlYLFlBQVlwQixTQUFTQyxPQUFPO1lBQzVCZ0IsS0FBSzhULGFBQWFoVDtBQUM5QixlQUFlO1lBQ0hkLEtBQUs2VCxjQUFjL1M7QUFDdEI7QUFDSjtJQUNELFdBQUFpVCxDQUFZNVQ7UUFDUixJQUFJQSxZQUFZcEIsU0FBU0MsT0FBTztZQUM1QjhGLGFBQVdoRixNQUFNcUksUUFBUSxLQUFJbkksS0FBSzhULGVBQWUsRUFBQztnQkFBRXhKLE1BQU07O0FBQ3RFLGVBQWU7WUFDSHhGLGFBQVdqRixPQUFPc0ksUUFBUSxLQUFJbkksS0FBSzZULGdCQUFnQixFQUFDO2dCQUFFdkosTUFBTTs7QUFDL0Q7QUFDSjtJQUVELGlCQUFBMEosQ0FBa0I3VCxVQUFVZ0k7UUFDeEIsSUFBSWhJLFlBQVlwQixTQUFTQyxPQUFPO1lBQzVCZ0IsS0FBSzhULGFBQWEzTDtZQUNsQnJELGFBQVdoRixNQUFNcUksUUFBUUE7QUFDckMsZUFBZTtZQUNIbkksS0FBSzZULGNBQWMxTDtZQUNuQnJELGFBQVdqRixPQUFPc0ksUUFBUUE7QUFDN0I7QUFDSjs7O0FBSUx0RCxjQUFZb1Asc0JBQXVCdEU7SUFDL0I3SyxhQUFXNkssZ0JBQWdCQTs7O0FBR3hCLFNBQVN1RSxtQkFBbUJDO0lBQy9CclAsYUFBVzhPLGVBQWVPO0FBQzlCOztBQUVPLFNBQVNDLHlCQUF5QkMsU0FBU0M7SUFFOUMsSUFBSTNHLFdBQWtCek0sTUFBTSxHQUFHO1FBRTNCLE9BQU0vQixRQUFFQSxRQUFNRyxVQUFFQSxZQUFhaVYsd0JBQW9DRjtRQUNqRSxNQUFNbFYsV0FBV0MsYUFBYUUsYUFBYUYsWUFBWTtZQUNuRCxPQUFNRyxjQUFFQSxjQUFZSixRQUFFQSxVQUFXbVY7WUFDakMsSUFBSW5WLFdBQVdDLGFBQWFHLGlCQUFpQkgsV0FBVztnQkFDcERtSSxpQ0FBaUMrTSxjQUFjRDtBQUNsRDtBQUNiLGVBQWU7WUFDSCxJQUFJbE0sUUFBUXlCLFdBQVdpRyxTQUFTd0U7WUFDaEMsSUFBSWxNLE1BQU1qQixVQUFVLEdBQUc7Z0JBQ25CTyxrQkFBa0I0TTtBQUNyQjtBQUNKO0FBQ0o7QUFDTDs7QUFHTyxTQUFTRztJQUNaQztBQUNKOztBQUdPLFNBQVNDLDBDQUEwQ2xOO0lBQ3REbU4sbUNBQTZDbFYsT0FBT0UsaUJBQWlCNkg7QUFDekU7O0FBRU8sU0FBU0QsaUNBQWlDQyxNQUFNOEMsT0FBTzdLLE9BQU9FO0lBQ2pFO1FBRUksT0FBUW9HLFFBQVE2TyxhQUFjcE47UUFDOUIsTUFBTXFOLFlBQVlDO1FBQ2xCLElBQUlGLGFBQWFBLGFBQWFDLFdBQVc7WUFDckNuSyxVQUFpQkosUUFBUXZMLFNBQVNDLFFBQVEseUJBQXlCLGtCQUFrQjtnQkFDakYyTCxVQUFZO2dCQUNaNUUsUUFBVTZPO2dCQUNWRyxNQUFRdFYsT0FBT00sT0FBT1I7O0FBRTdCO1FBQ0QsSUFBSWdOLGVBQWVvSSxtQ0FBNkNySyxNQUFNOUM7UUFDdEVDLGtCQUFrQjZDO1FBQ2xCLE9BQU9pQztBQUNWLE1BQUMsT0FBT25FO1FBQ0xwRyxRQUFRQyxJQUFJLGlEQUFpRG1HO0FBQ2hFO0FBQ0w7O0FBR08zRyxlQUFldVQsa0NBQWtDN1UsVUFBVXlCO0lBQzlELE9BQU0wSSxNQUFFQSxNQUFJMkssZ0JBQUVBLGdCQUFjNVQsS0FBRUEsT0FBUU87SUFDdEMsSUFBSXNULFNBQVNELG1CQUFtQjtJQUNoQyxJQUFJRSxXQUFXN0ssU0FBUyxZQUFZNEs7SUFDcEMsSUFBSUUsV0FBVzlLLFNBQVMsWUFBWTRLO0lBQ3BDLElBQUlHLGFBQWEvSyxTQUFTLGFBQWE0SztJQUN2QyxJQUFJRyxZQUFZO1FBRVo1TixrQkFBa0J0SDtBQUNyQixXQUFNLElBQUlpVixVQUFVO1FBRWpCLElBQUlFLGFBQWE7UUFDakIsSUFBSUMsd0JBQXdCO1FBQzVCLElBQUlDLFdBQVc7UUFDZixJQUFJQyxZQUFZO1FBRWhCN0wsV0FBV2lHLFNBQVMxUCxVQUFVSSxTQUFRLENBQUN1USxNQUFNYTtZQUN6QyxJQUFJYixLQUFLelAsT0FBTyxHQUFHeVAsS0FBS3pQLFVBQVUsR0FBR0EsT0FBTztnQkFDeEN5UCxLQUFLYSxRQUFRNkQ7Z0JBQ2JDLFVBQVVDLEtBQUs1RTtnQkFDZjBFO0FBQ0gsbUJBQU0sSUFBSTFFLEtBQUt4RyxRQUFRLHFCQUFxQndHLEtBQUs2RSxPQUFPO2dCQUNyRCxJQUFJQyxRQUFROUUsS0FBSzZFLE1BQU01RSxNQUFLRCxRQUFRLEdBQUdBLEtBQUt6UCxVQUFVLEdBQUdBO2dCQUN6RCxJQUFJdVUsT0FBTztvQkFDUEwsdUJBQXVCNUQ7QUFDM0MsdUJBQXVCO29CQUVIYixLQUFLYSxRQUFRNkQ7b0JBQ2JDLFVBQVVDLEtBQUs1RTtvQkFDZjBFO0FBQ0g7QUFDakIsbUJBQW1CLElBQUkxRSxLQUFLeEcsUUFBUSxpQkFBaUI7Z0JBQ3JDZ0wsYUFBYTtBQUNoQjs7UUFFTDFMLFdBQVdrRyxTQUFTM1AsVUFBVXNWO1FBQzlCN0wsV0FBV21LLFlBQVk1VDtRQUN2QixJQUFJb1YsdUJBQXVCLEdBQUc7WUFDMUIsSUFBSXBWLFlBQVlwQixTQUFTRSxRQUFRO3NCQUV2QjRXLHFCQUFxQnhVO0FBQzlCO0FBQ0o7UUFDRCxJQUFJaVUsWUFBWTtZQUVaUTtBQUNIO1FBQ0QsSUFBSUMsY0FBYzdPLFdBQVcsR0FBRztZQUU1QjhPLGVBQWUsTUFBTTdWO0FBQ3hCO0FBQ1QsV0FBVztRQUNILElBQUlnSSxRQUFReUIsV0FBV2lHLFNBQVMxUDtRQUNoQyxJQUFJOFYsaUNBQWtDbkY7WUFDbEMsSUFBSSxHQUFHQSxLQUFLelAsVUFBVSxHQUFHQSxPQUFPO2dCQUM1QnlQLEtBQUsxSyxhQUFhK087Z0JBQ2xCckUsS0FBS29GLE9BQU9DLFlBQVloQixXQUFXLFlBQVk7Z0JBQy9DckUsS0FBS29GLE9BQU8vRCxRQUFRZ0QsV0FBVy9ILE1BQU1nSiw0QkFBNEJoSixNQUFNaUo7Z0JBQ3ZFdkYsS0FBS29GLE9BQU9JLE9BQU9uQixXQUFXLGlDQUFpQztBQUNsRTs7UUFHTGhOLE1BQU01SCxTQUFRdVEsUUFBUW1GLCtCQUErQm5GO1FBQ3JELElBQUkzUSxZQUFZcEIsU0FBU0UsUUFBUTtZQUU3QixJQUFJeUUsT0FBT3lFLE1BQU1vTyxNQUFLQyxPQUFPQSxJQUFJbE0sU0FBUyxxQkFBcUJrTSxJQUFJYixTQUFTdlc7WUFDNUVzRSxLQUFLaVMsTUFBTXBWLFNBQVF1USxRQUFRbUYsK0JBQStCbkY7QUFDN0Q7UUFDRGxILFdBQVdrRyxTQUFTM1AsVUFBVWdJO1FBQzlCeUIsV0FBV21LLFlBQVk1VDtBQUMxQjtBQUNMOztBQUdPLFNBQVNzVyxpQ0FBaUN0VyxVQUFVeUI7SUFDdkQsT0FBTThVLFVBQUVBLFVBQVFDLE9BQUVBLFNBQVUvVTtJQUM1QixJQUFJdUcsUUFBUXlCLFdBQVdpRyxTQUFTMVA7SUFDaEMsSUFBSXVELE9BQU95RSxNQUFNb08sTUFBS0MsT0FBTyxHQUFHQSxJQUFJSSxTQUFTLEdBQUdGO0lBQ2hELElBQUloVCxTQUFTdEUsV0FBVztRQUNwQnNFLEtBQUtpVCxRQUFRQTtRQUNialQsS0FBS21ULFlBQVlDLG1CQUEwQkg7QUFDOUM7SUFFRCxJQUFJeFcsWUFBWXBCLFNBQVNFLFFBQVE7UUFDN0IsSUFBSThYLFVBQVU1TyxNQUFNb08sTUFBS0MsT0FBT0EsSUFBSWxNLFNBQVMscUJBQXFCa00sSUFBSWIsU0FBU3ZXO1FBQy9FLElBQUk0WCxPQUFPRCxRQUFRcEIsTUFBTVksTUFBS0MsT0FBTyxHQUFHQSxJQUFJSSxTQUFTLEdBQUdGO1FBQ3hELElBQUlNLFNBQVM1WCxXQUFXO1lBQ3BCNFgsS0FBS0wsUUFBUUE7WUFDYkssS0FBS0gsWUFBWUMsbUJBQTBCSDtBQUM5QztBQUNKO0lBQ0QvTSxXQUFXa0csU0FBUzNQLFVBQVVnSTtJQUM5QnlCLFdBQVdtSyxZQUFZNVQ7QUFDM0I7O0FBSUFzQixlQUFlZ0csa0JBQWtCdEg7VUFDdkI4VztVQUNBQyxnQ0FBZ0MsT0FBTy9XO0lBQzdDLElBQUlBLFlBQVlwQixTQUFTRSxRQUFRO2NBQ3ZCNFc7QUFDVDtJQUNEQztJQUdBcEwsVUFBaUJ2SyxZQUFZcEIsU0FBU0MsUUFBUSx5QkFBeUIsa0JBQWtCO1FBQ3JGMkwsVUFBWTtRQUNaZSxLQUFPO1FBQ1BkLE1BQVF1TTtRQUNSeEwsV0FBYWxNLE9BQU9NLE9BQU9WO1FBQzNCK1gsU0FBV0M7O0FBRW5COztBQUtBNVYsZUFBZWtHLG1CQUFtQnhIO1VBQ3hCK1csZ0NBQWdDLE1BQU0vVztJQUM1QzJWO0lBR0FwTCxVQUFpQnZLLFlBQVlwQixTQUFTQyxRQUFRLHlCQUF5QixrQkFBa0I7UUFDckYyTCxVQUFZO1FBQ1plLEtBQU87UUFDUGQsTUFBUXVNO1FBQ1J4TCxXQUFhbE0sT0FBT00sT0FBT1Y7UUFDM0IrWCxTQUFXQzs7QUFFbkI7O0FBRUE1VixlQUFlb1UscUJBQXFCeUI7SUFDaEMsSUFBSTdYLE9BQU9OLFVBQVUsR0FBRztRQUNwQixJQUFJMFUsY0FBY2pLLFdBQVdpRyxTQUFTOVEsU0FBU0U7UUFDL0MsSUFBSTRVLFlBQVkzTSxTQUFTLEdBQUc7WUFDeEI7Z0JBQ0ksS0FBSWlCLE9BQUVBLGVBQWdCb1A7Z0JBRXRCLElBQUlwUCxVQUFVL0ksYUFBYStJLE1BQU1qQixTQUFTLEdBQUc7b0JBQ3pDLElBQUlvUSxXQUFXO3dCQUNYblAsUUFBUUEsTUFBTTBJLFFBQU9DLFFBQVEsR0FBR0EsS0FBS3pQLFVBQVUsR0FBR2lXO0FBQ3JEO29CQUNELElBQUlFLGFBQWFyUCxNQUFNc1AsTUFBTSxHQUFHO29CQUVoQyxPQUFPRCxXQUFXdFEsU0FBUyxHQUFHO3dCQUMxQnNRLFdBQVc5QixLQUFLLENBQUE7QUFDbkI7b0JBQ0Q4QixXQUFXalgsU0FBUSxDQUFDdVEsTUFBTWE7d0JBQ3RCYixLQUFLNEcsV0FBVzt3QkFDaEI1RyxLQUFLNkcsV0FBVywrQkFBK0JoRyxRQUFRO3dCQUN2RGIsS0FBSzhHLGNBQWNqRyxRQUFRLElBQUksU0FBUzt3QkFDeEMsSUFBSWlFLFFBQVE5RSxLQUFLelAsT0FBT3lQLEtBQUt6UCxNQUFNO3dCQUNuQ3lQLEtBQUsrRyxhQUFhakMsUUFBUSxZQUFZO3dCQUN0QzlFLEtBQUt1QyxlQUFldUMsUUFBUSxTQUFTO3dCQUNyQyxJQUFJQSxPQUFPOzRCQUVQOUUsS0FBS2dILDJCQUEyQjFLLE1BQU0ySyxXQUFXQyx3QkFBd0IsR0FBR2xILEtBQUttSDs0QkFFakZuSCxLQUFLb0gsd0JBQXdCLEdBQUdwSCxLQUFLcUg7NEJBRXJDckgsS0FBS3RSLFNBQVNDLE9BQU9EOzRCQUNyQnNSLEtBQUsrRixZQUFZQyxtQkFBMEJoRyxLQUFLNkY7NEJBQ2hEeUIsbUJBQW1CdEg7QUFDdEI7O29CQUVMLElBQUlhLFFBQVFrQyxZQUFZM00sVUFBVSxJQUFJLElBQUkyTSxZQUFZM007b0JBQ3REMk0sWUFBWXdFLE9BQU8xRyxPQUFPLEdBQUc7d0JBQUVySCxNQUFNO3dCQUFtQnFMLE9BQU82Qjs7b0JBQy9EYyxrQkFBa0J6RTtBQUNyQjtBQUNKLGNBQUMsT0FBT3pMO2dCQUNMcEcsUUFBUUMsSUFBSSxxQ0FBcUNtRztBQUNwRDtBQUNKO0FBQ0o7QUFDTDs7QUFHQSxTQUFTME47SUFDTCxJQUFJclcsT0FBT0UsbUJBQW1CWixTQUFTRSxRQUFRO1FBQzNDO1lBQ0ksSUFBSTRVLGNBQWNqSyxXQUFXaUcsU0FBUzlRLFNBQVNFO1lBQy9DLElBQUk0VSxZQUFZM00sU0FBUyxHQUFHO2dCQUN4QixNQUFNcVIsU0FBUzFFLFlBQVk5QyxNQUFLeUYsT0FBT0EsSUFBSWxNLFNBQVM7Z0JBQ3BELEtBQUtpTyxRQUFRO29CQUNULElBQUk1RyxTQUFTO29CQUNiLElBQUk3TSxhQUFXakYsT0FBTzJZLGNBQWMsTUFBTTt3QkFDdEM3RyxRQUFRa0MsWUFBWTNNLFNBQVMsS0FBSyxLQUFLMk0sWUFBWTNNO0FBQzNFLDJCQUEyQixJQUFJMk0sWUFBWTNNLFNBQVMsSUFBSTt3QkFDaEN5SyxRQUFRO0FBQ1g7b0JBQ0QsSUFBSUEsVUFBVSxHQUFHO3dCQUNia0MsWUFBWXdFLE9BQU8xRyxPQUFPLEdBQUc7NEJBQUVySCxNQUFNOzt3QkFDckNnTyxrQkFBa0J6RTtBQUNyQjtBQUNKO0FBQ0o7QUFDSixVQUFDLE9BQU9uUjtZQUNMVixRQUFRQyxJQUFJLDBDQUEwQ1M7QUFDekQ7QUFDSjtBQUNMOztBQUVBLFNBQVM0VixrQkFBa0JuUTtJQUN2QkEsTUFBTTVILFNBQVEsQ0FBQ21ELE1BQU0rVSxNQUFNL1UsS0FBS2lPLFFBQVE4RztJQUN4QzdPLFdBQVdrRyxTQUFTL1EsU0FBU0UsUUFBUWtKO0lBQ3JDeUIsV0FBV21LLFlBQVloVixTQUFTRTtBQUNwQzs7QUFFQXdDLGVBQWV5VixnQ0FBZ0N3QixTQUFTLE9BQU92WTtJQUMzRCxNQUFNUixrQkFBa0JRO0lBQ3hCLE1BQU1KLFNBQVNKLG9CQUFvQlosU0FBU0UsU0FBUzZGLGFBQVdqRixTQUFTaUYsYUFBV2hGO0lBQ3BGLE1BQU02WSxhQUFhRCxTQUFTLG1CQUFtQjtJQUUvQyxLQUFLQSxRQUFRO1FBRVQsSUFBSTNZLE9BQU80VCxpQkFBaUJ6TSxVQUFVLEdBQUc7WUFDckMsSUFBSTBSLGtCQUFrQmpMLFdBQWtCMU0sYUFBYSxJQUFJLHNCQUFzQjtZQUMvRWxCLE9BQU80VCxtQkFBbUJrRixNQUFNQyxLQUFLO2dCQUFFNVIsUUFBUTtnQkFBTSxPQUFPO2dCQUFFb0QsTUFBTXNPOztBQUN2RTtRQUVEN1ksT0FBTyxtQkFBbUI7UUFDMUJBLE9BQU8sb0JBQW9CO1FBQzNCQSxPQUFPLGtCQUFrQjtRQUN6QkEsT0FBTyxrQkFBa0I7UUFDekJBLE9BQU8saUJBQWlCO0FBQzNCO0lBRUQ7UUFDSSxJQUFJMk8sTUFBTWdLLGVBQWVLLHFCQUErQjVZLGtCQUFrQjZZLG9CQUE4QjdZO0FBQ2hILE1BQWM7UUFDTkosT0FBTzRZLGNBQWM7QUFDeEI7SUFFRDtRQUNJLElBQUlNLGNBQWNyUCxXQUFXaUcsU0FBUzFQO1FBQ3RDLElBQUkrWSxhQUFhUjtRQUNqQixJQUFJaEssT0FBT0EsSUFBSXZHLFNBQVMvSSxXQUFXO1lBQy9CLEtBQUk2SSxRQUFFQSxRQUFNRSxPQUFFQSxPQUFLRCxTQUFFQSxXQUFZd0c7WUFDakMsSUFBSXlLLGFBQWFULFNBQVNPLFlBQVkvUixTQUFTO1lBQy9DLElBQUlrUyxvQkFBb0JqUixNQUFNaEUsS0FBSTFDLE9BQU9pQyxNQUFNK1U7Z0JBQzNDLElBQUkzSCxPQUFPblIsbUJBQW1CWixTQUFTQyxjQUFjcWEsa0JBQWtCM1YsY0FBYzRWLG1CQUFtQjVWO2dCQUN4R29OLEtBQUthLFFBQVE4RyxJQUFJVTtnQkFDakIsT0FBT3JJOztZQUVYLElBQUkwRyxtQkFBbUIzSyxRQUFRQyxJQUFJc007WUFFbkMsTUFBTUcsV0FBV2IsU0FBUyxLQUFJTyxnQkFBZ0J6QixlQUFjQTtZQUM1RDVOLFdBQVdvSyxrQkFBa0JyVSxpQkFBaUI0WjtZQUU5QyxPQUFNalQsU0FBRUEsV0FBWWlPLHdCQUFvQ3BVO1lBQ3hELEtBQUt1WSxVQUFVcFMsV0FBVyxJQUFJO2dCQUMxQnZHLE9BQU9rSSxTQUFTNUYsS0FBS0MsVUFBVTJGO0FBQ2xDO1lBRURsSSxPQUFPLGlCQUFpQm1JO1lBRXhCZ1IsYUFBY1IsVUFBVWxCLFdBQVd0USxVQUFVO0FBQ2hEO1FBRUQsS0FBS3dSLFFBQVE7WUFDVDNZLE9BQU8sbUJBQW1CO1lBQzFCQSxPQUFPLG9CQUFvQjtBQUM5QjtRQUVEaVcsZUFBZWtELFdBQVd2WixpQkFBaUIrTyxPQUFPO0FBQ3JELE1BQUMsT0FBT3RHO1FBQ0xwRyxRQUFRQyxJQUFJLGdEQUFnRG1HO0FBQy9EO0FBQ0w7O0FBRU8sU0FBUzROLGVBQWVrRCxXQUFXL1ksVUFBVXFaLFlBQVk7SUFDNUQsTUFBTXpaLFNBQVNJLGFBQWFwQixTQUFTRSxTQUFTNkYsYUFBV2pGLFNBQVNpRixhQUFXaEY7SUFDN0UsSUFBSTBaLFdBQVc7UUFFWCxJQUFJTixXQUFXO1lBQ1huWixPQUFPLGtCQUFrQjtZQUN6QkEsT0FBTyxrQkFBa0I7WUFDekJBLE9BQU8saUJBQWlCO0FBQ3BDLGVBQWU7WUFDSG9DLFdBQVdzWCxRQUFRck0sTUFBTXNNO0FBQzVCO0FBQ1QsV0FBVztRQUNIM1osT0FBTyxrQkFBa0I7UUFDekJBLE9BQU8sa0JBQWtCbVosWUFBWSxZQUFZO1FBQ2pEblosT0FBTyxpQkFBaUJtWixZQUFZLFNBQVM7UUFDN0MsSUFBSUEsV0FBVztZQUNYLE9BQU01WixVQUFFQSxVQUFRSCxRQUFFQSxRQUFNTyxXQUFFQSxhQUFjNlUsd0JBQW9DcFU7WUFDNUUsSUFBSWIsWUFBWSxLQUFLQSxZQUFZRixXQUFXO2dCQUN4Q1csT0FBTyx3QkFBd0I7Z0JBQy9CQSxPQUFPLGVBQWVxTixNQUFNdU0sMEJBQTBCO0FBQ3pELG1CQUFNLElBQUl4YSxVQUFVLEtBQUtBLFVBQVVDLFdBQVc7Z0JBQzNDVyxPQUFPLHdCQUF3QjtnQkFDL0JBLE9BQU8sZUFBZXFOLE1BQU13TSw0QkFBNEI7QUFDeEUsbUJBQW1CO2dCQUNILElBQUlDLFFBQVFuYSxhQUFhO2dCQUN6QkssT0FBTyx3QkFBd0I4WixRQUFRLFlBQVk7Z0JBQ25EOVosT0FBTyxlQUFlOFosUUFDZnpNLE1BQU1xRyw0QkFBNEIsd0JBQ2xDckcsTUFBTXNHLGFBQWE7QUFDN0I7QUFDSjtBQUNKO0FBQ0w7O0FBRUEsU0FBU29HLGFBQWFoSjtJQUVsQixJQUFJQSxLQUFLaUosd0JBQXdCM2EsV0FBVztRQUN4QzBSLEtBQUtrSix1QkFBd0JsSixLQUFLcFIsYUFBVyxLQUFLdWEsa0JBQWdDeGEsT0FBT0YsaUJBQWlCdVIsS0FBS2lKLHVCQUF1QixJQUFLLFlBQVk7UUFDdkpqSixLQUFLb0osb0JBQW9CcEosS0FBS2lKLHVCQUF1QixJQUFJM00sTUFBTWdGLG9DQUFxQ3RCLEtBQUtpSix1QkFBdUIsSUFBSTNNLE1BQU0rTSx1Q0FBdUM7UUFDakxySixLQUFLc0osMEJBQTBCdEosS0FBS2lKLHVCQUF1QixJQUFJLFlBQVk7UUFDM0VqSixLQUFLdUoseUJBQXlCdkosS0FBS2lKLHVCQUF1QixJQUFJLFlBQVk7QUFDbEYsV0FBVztRQUNIakosS0FBS2tKLHVCQUF3QmxKLEtBQUtwUixhQUFXLEtBQUt1YSxrQkFBZ0N4YSxPQUFPRixnQkFBaUIsWUFBWTtRQUN0SHVSLEtBQUtvSixvQkFBb0JwSixLQUFLd0osa0JBQWtCbE4sTUFBTWdGLG9DQUFvQ2hGLE1BQU0rTTtRQUNoR3JKLEtBQUtzSiwwQkFBMEJ0SixLQUFLd0osa0JBQWtCLFlBQVk7UUFDbEV4SixLQUFLdUosMEJBQTBCdkosS0FBS3dKLGtCQUFrQixZQUFZO0FBQ3JFO0lBR0R4SixLQUFLeUosZUFBZ0J6SixLQUFLMEosYUFBYTFKLEtBQUswSixVQUFVdFQsU0FBUyxJQUFLLFlBQVk7SUFFaEY0SixLQUFLdFIsU0FBU0MsT0FBT0Q7SUFDckJzUixLQUFLK0YsWUFBWUMsbUJBQTBCaEcsS0FBSzZGO0lBRWhEN0YsS0FBSzJKLFVBQVUzSixLQUFLNEosYUFBYSxNQUFNamIsT0FBT0osU0FBU29OO0lBRXZELElBQUlrTyxnQkFBZ0I3SixLQUFLNkosY0FBY2pWLFFBQVEseUJBQXlCO0lBQ3hFLElBQUlrVixnQkFBZ0I5SixLQUFLOEosY0FBY2xWLFFBQVEseUJBQXlCO0lBQ3hFb0wsS0FBSytKLGtCQUFrQi9KLEtBQUt0UixTQUFTbWIsZ0JBQWdCLFFBQVE3SixLQUFLdFIsU0FBU29iO0lBRTNFOUosS0FBS2dLLG9CQUFvQjFOLE1BQU0ySyxXQUFXZ0QsY0FBYyxHQUFHakssS0FBS2tLO0lBRWhFbEssS0FBS21LLHVCQUF1QjtJQUU1Qm5LLEtBQUtvRixTQUFTO1FBQ1YvRCxPQUFPckIsS0FBSzFLLGFBQWFnSCxNQUFNZ0osNEJBQTRCaEosTUFBTWlKO1FBQ2pFQyxNQUFNeEYsS0FBSzFLLGFBQWEsaUNBQWlDO1FBQ3pEK1AsV0FBVztRQUNYK0UsUUFBUTtPQUlScEssS0FBS29GLE9BQU8vRCxRQUFRckIsS0FBSzFLLGFBQWFnSCxNQUFNZ0osNEJBQTRCaEosTUFBTWlKO0lBQ2xGdkYsS0FBS29GLE9BQU9JLE9BQU94RixLQUFLMUssYUFBYSxpQ0FBaUM7SUFHdEUsSUFBSStVLGNBQWMsQ0FBQTtJQUNsQixJQUFJQyxjQUFjO0lBQ2xCLElBQUl0SyxLQUFLdUssYUFBYSxHQUFHO1FBQ3JCRixZQUFZaEosUUFBUS9FLE1BQU1rTyx3QkFBd0I7UUFDbERGLGNBQWM7QUFDdEIsV0FBVyxJQUFJdEssS0FBS3VLLGFBQWEsR0FBRztRQUM1QkYsWUFBWWhKLFFBQVEvRSxNQUFNbU8sK0JBQStCO1FBQ3pESCxjQUFjO0FBQ3RCLFdBQVcsSUFBSXRLLEtBQUt1SyxhQUFhLEtBQUt2SyxLQUFLdUssYUFBYSxHQUFHO1FBQ25ERixZQUFZaEosUUFBUS9FLE1BQU1vTyx5QkFBeUI7UUFDbkRKLGNBQWM7QUFDdEIsV0FBVztRQUNILElBQUl0SyxLQUFLcFIsYUFBYSxHQUFHO1lBQ3JCeWIsWUFBWWhKLFFBQVEvRSxNQUFNcU8sYUFBYTtBQUNuRCxlQUFlO1lBQ0hOLFlBQVloSixRQUFRL0UsTUFBTXNPLGNBQWM7QUFDM0M7QUFDSjtJQUNEUCxZQUFZUSxpQkFBaUJQLGNBQWMsWUFBWTtJQUN2REQsWUFBWXRELGFBQWF1RCxjQUFjLFNBQVM7SUFDaERELFlBQVlDLGNBQWNBO0lBQzFCdEssS0FBS3FLLGNBQWNBO0lBQ25CLElBQUlTLFVBQVU7SUFDZCxLQUFLLElBQUkvWixVQUFVaVAsS0FBSytLLFlBQVk7UUFDaENoYSxPQUFPeUksT0FBTztRQUNkc1IsUUFBUWxHLEtBQUs3VDtBQUNoQjtJQUNEaVAsS0FBSytLLGFBQWFEO0FBQ3RCOztBQUVBLFNBQVN4RCxtQkFBbUJ0SDtJQUV4QixJQUFJZ0wsZ0JBQWdCO0lBQ3BCLElBQUloTCxLQUFLckssZ0JBQWdCb1MsTUFBTWtELFFBQVFqTCxLQUFLckssZUFBZTtRQUN2RHFWLGdCQUFnQmhMLEtBQUtySyxhQUFhbkIsU0FBUztBQUM5QztJQUNEd0wsS0FBS2tMLGFBQWFsTCxLQUFLa0wsY0FBYyxDQUFFO0lBQ3ZDbEwsS0FBS2tMLFdBQVc3RixZQUFZMkYsZ0JBQWdCLFlBQVk7SUFFeERoTCxLQUFLbUwsUUFBUW5MLEtBQUttTCxTQUFTLENBQUU7SUFDN0IsSUFBSW5MLEtBQUtvTCxpQkFBaUIsR0FBRztRQUN6QnBMLEtBQUttTCxNQUFNOUYsWUFBWTtRQUN2QnJGLEtBQUttTCxNQUFNZixTQUFTO0FBQzVCLFdBQVcsSUFBSXBLLEtBQUtvTCxpQkFBaUIsR0FBRztRQUNoQ3BMLEtBQUttTCxNQUFNOUYsWUFBWTtRQUN2QnJGLEtBQUttTCxNQUFNZixTQUFTO0FBQzVCLFdBQVc7UUFDSHBLLEtBQUttTCxNQUFNOUYsWUFBWTtRQUN2QnJGLEtBQUttTCxNQUFNZixTQUFTO0FBQ3ZCO0lBRURwSyxLQUFLcUwsY0FBY3JMLEtBQUtxTCxlQUFlLENBQUU7SUFDekNyTCxLQUFLcUwsWUFBWWhHLFlBQVlyRixLQUFLc0wsV0FBVyxJQUFJLFNBQVM7SUFDMUR0TCxLQUFLcUwsWUFBWWpCLFNBQVM7SUFFMUJwSyxLQUFLb0YsU0FBU3BGLEtBQUtvRixVQUFVLENBQUU7SUFDL0JwRixLQUFLb0YsT0FBT0MsWUFBWXJGLEtBQUsxSyxhQUFhLFlBQVk7SUFFdEQwSyxLQUFLdUwsU0FBU3ZMLEtBQUt1TCxVQUFVLENBQUU7SUFDL0J2TCxLQUFLdUwsT0FBT2xHLFlBQVlyRixLQUFLd0wsVUFBVSxZQUFZO0lBRW5ELElBQUkzTyxXQUFrQnZNLFlBQVksU0FBUztRQUN2QzBQLEtBQUtrTCxXQUFXZCxTQUFTWSxnQkFBZ0Isb0NBQW9DO1FBQzdFaEwsS0FBS3VMLE9BQU9uQixTQUFTcEssS0FBS3dMLFVBQVUsaUNBQWlDO0FBQzdFLFdBQVcsSUFBSTNPLFdBQWtCdk0sWUFBWSxTQUFTO1FBQzlDMFAsS0FBS2tMLFdBQVdkLFNBQVNZLGdCQUFnQixvQ0FBb0M7UUFDN0VoTCxLQUFLdUwsT0FBT25CLFNBQVNwSyxLQUFLd0wsVUFBVSxpQ0FBaUM7QUFDN0UsV0FBVztRQUNIeEwsS0FBS2tMLFdBQVdkLFNBQVNZLGdCQUFnQixvQ0FBb0M7UUFDN0VoTCxLQUFLdUwsT0FBT25CLFNBQVNwSyxLQUFLd0wsVUFBVSw4QkFBOEI7QUFDckU7QUFDTDs7QUFFQTdhLGVBQWU2WCxtQkFBbUJ4STtJQUM5QkEsS0FBS3hHLE9BQU87SUFDWndQLGFBQWFoSjtJQUNic0gsbUJBQW1CdEg7SUFFbkJBLEtBQUt5TCxjQUFjekwsS0FBSzBMLFdBQVcsWUFBWTtJQUUvQzFMLEtBQUtnSCwyQkFBMkIsR0FBRzFLLE1BQU1xUCwwQkFBMEIzTCxLQUFLbUg7SUFFeEVuSCxLQUFLb0gsd0JBQXdCLEdBQUdwSCxLQUFLcUg7SUFFckMsSUFBSXJILEtBQUtxSyxZQUFZQyxhQUFhO1FBQzlCLElBQUl0SyxLQUFLdUssYUFBYSxLQUFLdkssS0FBS3VLLGFBQWEsR0FBRztZQUM1Q3ZLLEtBQUtxSyxZQUFZdUIsYUFBYTtZQUM5QjVMLEtBQUtxSyxZQUFZakssa0JBQWtCO0FBQy9DLGVBQWU7WUFDSEosS0FBS3FLLFlBQVl1QixhQUFhO1lBQzlCNUwsS0FBS3FLLFlBQVlqSyxrQkFBa0I7QUFDdEM7QUFDVCxXQUFXO1FBQ0hKLEtBQUtxSyxZQUFZdUIsYUFBYTtRQUc5QjVMLEtBQUtxSyxZQUFZakssa0JBQWtCSixLQUFLcFIsYUFBYSxJQUFJLFlBQVk7QUFDeEU7SUFHRG9SLEtBQUs2TCxrQkFBa0I3TCxLQUFLOEwsYUFBYSxTQUFTO0lBQ2xEOUwsS0FBSytMLG1CQUFtQi9MLEtBQUs4TCxhQUFhLFlBQVk7SUFDdEQsSUFBSTlMLEtBQUs4TCxZQUFZO1FBQ2pCOUwsS0FBS2dNLDhCQUE4QkMsZ0JBQWdCak0sS0FBS2tNLFVBQVUsSUFBSSxPQUFPO0FBQ2hGO0lBQ0QsT0FBT2xNO0FBQ1g7O0FBRUFyUCxlQUFlNFgsa0JBQWtCdkk7SUFDN0JnSixhQUFhaEo7SUFDYixJQUFJbU0sU0FBU25NO0lBQ2I5TyxRQUFRQyxJQUFJLFNBQVM2TztJQUVyQm1NLE9BQU9DLGdCQUFpQnBNLEtBQUt3TCxXQUFXLFFBQVMsWUFBWTtJQUc3RCxJQUFJeEwsS0FBS3FLLFlBQVlDLGFBQWE7UUFDOUIsSUFBSXRLLEtBQUt1SyxhQUFhLEtBQUt2SyxLQUFLdUssYUFBYSxHQUFHO1lBQzVDdkssS0FBS3FLLFlBQVl1QixhQUFhO1lBQzlCNUwsS0FBS3FLLFlBQVlqSyxrQkFBa0I7QUFDL0MsZUFBZTtZQUNISixLQUFLcUssWUFBWXVCLGFBQWE7WUFDOUI1TCxLQUFLcUssWUFBWWpLLGtCQUFrQjtBQUN0QztBQUNULFdBQVc7UUFDSEosS0FBS3FLLFlBQVl1QixhQUFhO1FBQzlCNUwsS0FBS3FLLFlBQVlqSyxrQkFBa0I7QUFDdEM7SUFHRCtMLE9BQU9FLGlCQUFpQjlhLEtBQUtDLFVBQVV3TyxLQUFLK0s7SUFHNUMsSUFBSW9CLE9BQU9uWCxhQUFhLEtBQ2pCK1MsTUFBTWtELFFBQVFqTCxLQUFLc00sdUJBQXVCdE0sS0FBS3NNLG1CQUFtQmxXLFNBQVMsR0FDaEY7UUFDRStWLE9BQU9JLG1CQUFtQnZNLEtBQUtzTSxtQkFBbUIsR0FBRy9aLFFBQVF5TixLQUFLcFIsYUFBYSxJQUFJLG9EQUFvRDtRQUN2SXVkLE9BQU9LLG1CQUFtQnhNLEtBQUtzTSxtQkFBbUIsR0FBR3ZaLFFBQVE7UUFFN0QsSUFBSW9aLE9BQU9LLGlCQUFpQnBXLFNBQVMsR0FBRztZQUNwQytWLE9BQU9NLG9CQUFvQixLQUFLLFVBQVVSLGdCQUFnQkUsT0FBT0ssa0JBQWtCLElBQUksT0FBTztBQUNqRztRQUNETCxPQUFPTyxzQkFBc0JQLE9BQU9LLGlCQUFpQnBXLFNBQVMsSUFBSSxZQUFZO0FBQ3RGLFdBQVc7UUFDSCtWLE9BQU9PLHNCQUFzQjtRQUM3QlAsT0FBT00sb0JBQW9CO1FBQzNCTixPQUFPSSxtQkFBbUI7UUFDMUJKLE9BQU9LLG1CQUFtQjtBQUM3QjtJQUdELElBQUl6RSxNQUFNa0QsUUFBUWpMLEtBQUsyTSxzQkFBc0IzTSxLQUFLMk0sa0JBQWtCdlcsU0FBUyxHQUFHO1FBQzVFLElBQUl1VyxvQkFBb0I7UUFDeEIsS0FBSyxJQUFJQyxTQUFTNU0sS0FBSzJNLG1CQUFtQjtZQUN0QyxJQUFJQSxrQkFBa0J2VyxVQUFVLEdBQUc7Z0JBQy9CdVcsa0JBQWtCL0gsS0FBSztvQkFBRXBMLE1BQU07b0JBQU9xVCxhQUFhO29CQUFHQyxZQUFZO29CQUFtQ0MsVUFBVTtvQkFBTXJVLFdBQVc7dUJBQXlDa1U7O0FBQ3pMLG1CQUFtQjtnQkFDSEQsa0JBQWtCL0gsS0FBSztvQkFBRXBMLE1BQU07b0JBQU9xVCxhQUFhO29CQUFLQyxZQUFZO29CQUFhQyxVQUFVO29CQUFNclUsV0FBVzt1QkFBeUNrVTs7QUFDeEo7QUFDSjtRQUNEVCxPQUFPUSxvQkFBb0JBO1FBQzNCUixPQUFPYSxxQkFBcUI7UUFDNUJiLE9BQU9jLHFCQUFxQnBRLFdBQWtCek0sTUFBTSxJQUFJLElBQUk7QUFDcEUsV0FBVztRQUNIK2IsT0FBT2EscUJBQXFCO1FBQzVCYixPQUFPUSxvQkFBb0I7UUFDM0JSLE9BQU9jLHFCQUFxQjtBQUMvQjtJQUNEZCxPQUFPM1MsT0FBTztJQUNkLE9BQU8yUztBQUNYOztBQUdBeGIsZUFBZXNiLGdCQUFnQmlCLEtBQUtDLFVBQVVDO0lBQzFDO1FBQ0ksTUFBTUMsaUJBQWlCaGMsV0FBV21KLGdCQUFnQjtZQUM5QzFILFFBQVE7WUFDUmhDLFFBQVE7Z0JBQUV3YyxNQUFNSjtnQkFBS0MsVUFBVUE7Z0JBQVVDLFlBQVlBOzs7UUFHekQsTUFBTTFILE1BQU1uVSxLQUFLRyxNQUFNMmI7UUFDdkIsT0FBUUUsT0FBT0EsT0FBT2xLLFFBQVFBLFVBQVdxQztRQUN6QyxPQUFPNkg7QUFDVixNQUFDLE9BQU8zYjtRQUNMVixRQUFRQyxJQUFJLDZCQUE2QlM7UUFDekMsT0FBTztBQUNWO0FBQ0w7O0FBS0FtQyxjQUFZeVosc0JBQXNCLFNBQVVqZDtJQUN4Q2MsV0FBV21KLGdCQUFnQjtRQUFFMUgsUUFBUTtRQUFrQmhDLFFBQVEsR0FBR1A7O0FBQ3RFOztBQUtBd0QsY0FBWTBaLHVCQUF1QixTQUFVNU07SUFDekMsSUFBSWIsT0FBT2xILFdBQVdpRyxTQUFTcFEsT0FBT0UsaUJBQWlCZ1M7SUFDdkQsSUFBSWIsUUFBUUEsS0FBS2lKLHVCQUF1QixHQUFHO1FBQ3ZDeUUsYUFBMkIvZSxPQUFPRjtBQUNyQztBQUNMOztBQUVBc0YsY0FBWTRaLHdCQUF3QixTQUFVOU07SUFDMUMsTUFBTTBDLFVBQVU1VSxPQUFPRTtJQUN2QixJQUFJbVIsT0FBT2xILFdBQVdpRyxTQUFTd0UsU0FBUzFDO0lBQ3hDLElBQUliLE1BQU07UUFDTixJQUFJQSxLQUFLdUssYUFBYSxLQUFLdkssS0FBS3VLLGFBQWEsR0FBRztZQUU1Q3ROLFFBQWU7QUFDM0IsZUFBZSxJQUFJK0MsS0FBS3VLLGFBQWEsR0FBRztZQUU1QixJQUFJMU4sV0FBa0J6TSxNQUFNLEdBQUc7Z0JBQzNCNk0sUUFBZTtBQUMvQixtQkFBbUI7Z0JBRUg1TCxXQUFXbUosZ0JBQWdCO29CQUN2QjFILFFBQVE7b0JBQ1JoQyxRQUFRO3dCQUNKN0IsUUFBUTs7O0FBR25CO0FBQ2IsZUFBZTtZQUVIb0MsV0FBV21KLGdCQUFnQjtnQkFDdkIxSCxRQUFRO2dCQUNSaEMsUUFBUTtvQkFDSjdCLFFBQVE7b0JBQ1I2QixRQUFRUyxLQUFLQyxVQUFVd087OztBQUdsQztRQUdEcEcsVUFBaUIySixXQUFXdFYsU0FBU0MsUUFBUSx5QkFBeUIsa0JBQWtCO1lBQ3BGMkwsVUFBWTtZQUNaZSxLQUFPb0YsS0FBS3BSLGFBQWEsSUFBSSx5QkFBeUI7WUFDdERrTCxNQUFRdU07WUFDUnhMLFdBQWFsTSxPQUFPTSxPQUFPVjtZQUMzQitYLFNBQVdDOztBQUVsQjtBQUNMOztBQUVBeFMsY0FBWTZaLGNBQWUvTTtJQUN2QixNQUFNMEMsVUFBVTVVLE9BQU9FO0lBQ3ZCLElBQUltUixPQUFPbEgsV0FBV2lHLFNBQVN3RSxTQUFTMUM7SUFDeENiLEtBQUttSyx1QkFBdUJuSyxLQUFLbUsseUJBQXlCLFNBQVMsWUFBWTtJQUMvRXJSLFdBQVdtSyxZQUFZTTs7O0FBRzNCeFAsY0FBWThaLGdCQUFnQmxkLE1BQU9rUTtJQUMvQixNQUFNMEMsVUFBVTVVLE9BQU9FO0lBQ3ZCLElBQUltUixPQUFPbEgsV0FBV2lHLFNBQVN3RSxTQUFTMUM7SUFDeEMsSUFBSWIsU0FBU0EsS0FBSzFLLFlBQVk7UUFFMUIsSUFBSS9DLE1BQU0sMkJBQTJCeU4sS0FBS3pQO1FBQzFDLEtBQUlvQixNQUFFQSxNQUFJc0YsU0FBRUEsaUJBQWtCRixZQUFtQnhFLEtBQUssSUFBSSxHQUFHLEdBQUc7UUFDaEUsSUFBSVosUUFBUSxLQUFLO1lBQ2JxTyxLQUFLMUssYUFBYTtZQUNsQjBLLEtBQUtvRixPQUFPQyxZQUFZckYsS0FBSzFLLGFBQWEsWUFBWTtZQUN0RDBLLEtBQUtvRixPQUFPL0QsUUFBUXJCLEtBQUsxSyxhQUFhZ0gsTUFBTWdKLDRCQUE0QmhKLE1BQU1pSjtZQUM5RXZGLEtBQUtvRixPQUFPSSxPQUFPeEYsS0FBSzFLLGFBQWEsaUNBQWlDO1lBQ3RFd0QsV0FBV21LLFlBQVlNO1lBQ3ZCbFMsV0FBV3NYLFFBQVFyTSxNQUFNd1I7QUFDckMsZUFBZTtZQUNIemMsV0FBV3NYLFNBQVUxUixXQUFXQSxRQUFRYixVQUFVLElBQUtrRyxNQUFNc00sa0JBQWtCM1I7QUFDbEY7QUFDSjs7O0FBR0xsRCxjQUFZZ2EsbUJBQW1CO0lBQzNCLElBQUlsUixXQUFrQnpNLE1BQU0sR0FBRztRQUMzQjZNLFFBQWU7QUFDdkIsV0FBVztRQUNIQSxRQUFlO0FBQ2xCO0FBQ0w7O0FBRUFsSixjQUFZaWEsMkJBQTJCLFNBQVVuTjtJQUM3Q3hQLFdBQVdtSixnQkFBZ0I7UUFBRTFILFFBQVE7O0FBQ3pDOztBQUVBaUIsY0FBWWthLHFCQUFxQjtJQUU3QixJQUFJcmYsWUFBWXlYO0lBQ2hCaFYsV0FBV21KLGdCQUFnQjtRQUN2QjFILFFBQVE7UUFDUmhDLFFBQVE7WUFDSjdCLFFBQVE7WUFDUjZCLFFBQVFTLEtBQUtDLFVBQVU7bUJBQ2hCN0MsT0FBT0k7Z0JBQ1ZILFdBQVdBOzs7O0lBTXZCZ0wsVUFBaUIsa0JBQWtCO1FBQy9CQyxVQUFZO1FBQ1pDLE1BQVFsTDtRQUNSaU0sV0FBYWxNLE9BQU9NLE9BQU9WOztBQUVuQzs7QUFFQXdGLGNBQVltYSxpQkFBaUI7SUFDekI3YyxXQUFXbUosZ0JBQWdCO1FBQ3ZCMUgsUUFBUTtRQUNSaEMsUUFBUTtZQUNKN0IsUUFBUTtZQUNSNkIsUUFBUTs7O0FBR3BCOztBQUVBaUQsY0FBWTRDLG9CQUFvQixTQUFVa0s7SUFDdENsSyxrQkFBa0JrSyxTQUFTLElBQUk1UyxTQUFTQyxRQUFRRCxTQUFTRTtBQUM3RDs7QUFDQTRGLGNBQVk4QyxxQkFBcUIsU0FBVWdLO0lBQ3ZDaEssbUJBQW1CZ0ssU0FBUyxJQUFJNVMsU0FBU0MsUUFBUUQsU0FBU0U7QUFDOUQ7O0FDL3hCQSxPQUFNNkYsWUFBRUEsWUFBVUQsYUFBRUEsZUFBZ0I2RSxhQUNoQyxnQkFDQSxXQUNBQzs7QUFHSixNQUFNc1YsZ0JBQWdCO0lBQ2xCOU0sT0FBTztJQUNQNUUsU0FBUztJQUNUMlIsS0FBSztJQUNMQyxRQUFRO1FBQUN0YixNQUFNOzs7O0FBR25CLFNBQVM4RjtJQUNMLE9BQU87UUFDSHNJLFVBQVU7WUFDTkMsV0FBVztZQUNYQyxPQUFPO1lBQ1A1RSxTQUFTO1lBQ1Q2UixXQUFXO1lBQ1gvTSxhQUFhakYsTUFBTWtGOztRQUV2QitNLGFBQWE7UUFDYjlmLGNBQWM7UUFDZCtmLGdCQUFnQixDQUFFOztBQUUxQjs7QUFFQTdkLGVBQWU4ZCwwQkFBMEJoZ0I7SUFDckMsTUFBTXFDLFNBQVM7UUFDWDRkLFFBQVU7WUFDTmhQLFdBQWE7WUFDYkQsU0FBVztZQUNYRyxtQkFBcUJuUixhQUFha047OztJQUcxQyxNQUFNbEssaUJBQWlCc0YsWUFBbUIsd0JBQXVCakcsUUFBTyxHQUFFLEdBQUU7UUFBQyxnQkFBZ0I7O0lBQzdGSSxRQUFRQyxJQUFJLG9DQUFvQ007SUFDaEQsT0FBUUEsWUFBWUEsU0FBU21CLE9BQVE7V0FBSXViO1dBQWtCMWMsU0FBU21CO1FBQVE7QUFDaEY7O0FBRU9qQyxlQUFlZ2U7SUFDbEIsSUFBSTNhLFdBQVd1YSxlQUFlNWYsT0FBT0YsZ0JBQWdCRSxPQUFPRixnQkFBZ0J1RixXQUFXdkYsY0FBYztRQUNqR21nQixvQkFBb0JqZ0IsT0FBT0Y7QUFDbkMsV0FBVztRQUNIeUMsUUFBUUMsSUFBSSx5Q0FBeUN4QyxPQUFPRixjQUFjdUYsV0FBV3ZGO0FBQ3hGO0FBQ0w7O0FBRU9rQyxlQUFlaWUsb0JBQW9CbmdCO0lBQ3RDLElBQUl1RixXQUFXbU4sU0FBU0MsYUFBYSxRQUFPO1FBQ3hDO0FBQ0g7SUFDRHBOLFdBQVd2RixlQUFlQTtJQUUxQixJQUFJdUYsV0FBV3dhLGVBQWUvZixpQkFBaUIsTUFBSztRQUNoRDtBQUNIO0lBRUQsTUFBTW9nQixpQkFBaUJKLDBCQUEwQmhnQjtJQUNqRCxJQUFJb2dCLFlBQVl2Z0IsYUFBYXVnQixTQUFTeE4sTUFBTWpMLFVBQVV5WSxTQUFTcFMsUUFBUXJHLFFBQVE7UUFDM0VwQyxXQUFXd2EsZUFBZS9mLGdCQUFnQjtRQUMxQ3VGLFdBQVdtTixTQUFTMUUsVUFBVW9TLFNBQVNwUztRQUN2Q3pJLFdBQVdtTixTQUFTSSxjQUFjc04sU0FBU1IsT0FBT3RiLEtBQUtxRCxTQUFTeVksU0FBU1IsT0FBT3RiLE9BQU91SixNQUFNd1M7UUFDN0Y5YSxXQUFXbU4sU0FBU0UsUUFBUXdOLFNBQVN4TjtRQUNyQ3JOLFdBQVdtTixTQUFTbU4sWUFBWU8sU0FBU1QsSUFBSSxNQUFNO1FBQ25EcGEsV0FBV21OLFNBQVNDLFlBQVk7QUFDbkM7QUFDTDs7QUFFTyxTQUFTMk4sZUFBZUM7SUFDM0JoYixXQUFXdWEsY0FBY1M7QUFDN0I7O0FBRUFqYixZQUFZaU8sYUFBYTtJQUNyQjlRLFFBQVFDLElBQUk7SUFDWnlDLE1BQU1xYixZQUFZOU4sU0FBU0MsWUFBWTtBQUMzQzs7QUNsRUEsTUFBTThOLGtCQUFrQjtJQUNwQnhjLFFBQVE7SUFDUixZQUFJeWM7UUFDQSxPQUFPLHFCQUFxQnRTLFdBQWtCdE07QUFDakQ7SUFDRCxhQUFNNmU7UUFFRixJQUFJdlMsV0FBa0J2TSxTQUFTd0IsaUJBQWlCLFNBQVM7WUFDckQsT0FBTzdELFNBQVNDO0FBQ25CO1FBRUQsSUFBSXVPLGdCQUFnQjRTLEtBQVluZ0IsS0FBS3dELFFBQVF4RCxLQUFLaWdCO1FBQ2xELElBQUkxUyxXQUFXLE1BQU07WUFFakIsSUFBSW1CLFlBQVk3RyxZQUFtQjtZQUNuQyxJQUFJNkcsT0FBT0EsSUFBSWhMLFFBQVFnTCxJQUFJaEwsS0FBSzBjLFVBQVU7Z0JBQ3RDN1MsVUFBVW1CLElBQUloTCxLQUFLMGM7Z0JBQ25CQyxLQUFZcmdCLEtBQUt3RCxRQUFReEQsS0FBS2lnQixVQUFVdlIsSUFBSWhMLEtBQUswYyxVQUFVRSxNQUFNQztBQUNqRixtQkFBbUI7Z0JBRUhoVCxVQUFVO0FBQ2I7QUFDSjtRQUNELElBQUlpVCxPQUFPalQsV0FBVyxVQUFVeE8sU0FBU0UsU0FBU0YsU0FBU0M7UUFDM0QsT0FBT3doQjtBQUNWO0lBQ0QsVUFBQUMsQ0FBV25XO1FBQ1AsSUFBSW9XLFlBQVlwVyxRQUFRdkwsU0FBU0UsU0FBUyxVQUFVO1FBQ3BEb2hCLEtBQVlyZ0IsS0FBS3dELFFBQVF4RCxLQUFLaWdCLFVBQVVTLFdBQVdKLE1BQU1DO0FBQzVEOzs7QUFJTDViLE9BQU9nYyxpQkFBaUJsZjtJQUVwQmlKLFVBQWlCakwsT0FBT0UsbUJBQW1CWixTQUFTQyxRQUFRLHlCQUF5QixrQkFBa0I7UUFDbkcyTCxVQUFZO1FBQ1plLEtBQU87UUFDUGQsTUFBUXVNO1FBQ1J4TCxXQUFhbE0sT0FBT00sT0FBT1Y7UUFDM0IwRyxRQUFVK087O0FBRWxCOztBQUVBblEsT0FBT2ljLG9CQUFvQm5mO0lBQ3ZCTyxRQUFRQyxJQUFJO0FBQ2hCOztBQUVBMEMsT0FBT2tjLG1CQUFtQnBmO0lBQ3RCTyxRQUFRQyxJQUFJO0lBQ1o2ZSxlQUEyQjtJQUMzQkM7SUFDQSxJQUFJdGhCLE9BQU9FLG9CQUFvQlAsV0FBVztRQUN0QzRoQjtBQUNIO0FBQ0w7O0FBRUFyYyxPQUFPc2Msc0JBQXNCeGY7SUFDekJPLFFBQVFDLElBQUk7SUFDWjZlLGVBQTJCO0FBQy9COztBQUlBbmMsT0FBT3VjLG1CQUFtQixTQUFVaGhCO0lBQ2hDLElBQUlpaEIsY0FBY0MsbUJBQTBCbGhCO0lBQzVDOEIsUUFBUUMsSUFBSUksS0FBS0MsVUFBVTZlO0lBQzNCRSxrQkFBeUJGO0FBQzdCOztBQUtBeGMsT0FBTzRHLGlDQUFpQzlKLE1BQU8vQjtJQUMzQ0QsT0FBT0MsWUFBWUE7SUFHbkI0aEIsMENBQXFEO1FBQUU1aEIsV0FBV0EsYUFBYSxRQUFRLFNBQVM7Ozs7QUFJcEdpRixPQUFPcUgsZ0NBQWlDcEc7SUFDcEMyYixpQ0FBNEM7UUFBRTNiOzs7O0FBTWxEakIsT0FBTzZjLDZCQUE2QixTQUFVeGM7SUFDMUMsSUFBSTlFLFFBQVFraEIsbUJBQTBCcGM7SUFDdEN5YyxrQ0FBNkNoaUIsT0FBT0UsaUJBQWlCTztBQUN6RTs7QUFJQXlFLE9BQU8rYyx1QkFBdUIsU0FBVTFjO0lBQ3BDLElBQUk5RSxRQUFRa2hCLG1CQUEwQnBjO0lBQ3RDMmMsaUNBQTRDbGlCLE9BQU9FLGlCQUFpQk87QUFDeEU7O0FBUUF5RSxPQUFPaWQsZ0JBQWdCLFNBQVU1YztJQUM3QjtRQUNJaEQsUUFBUUMsSUFBSSwyQkFBMkJJLEtBQUtDLFVBQVUwQztRQUN0RCxNQUFNcEQsU0FBU3dmLG1CQUEwQnBjO1FBQ3pDLElBQUlwRCxRQUFRO1lBRVIsT0FBUXZDLFVBQVV3aUIsY0FBY3BpQixPQUFPSixVQUFVRixRQUFRMmlCLFNBQVVsZ0I7WUFDbkUsSUFBSWlnQixhQUFhO2dCQUFFcGlCLE9BQU9KLFdBQVd3aUI7QUFBYTtZQUNsRCxJQUFJQyxPQUFPO2dCQUFFcmlCLE9BQU9OLFNBQVMyaUI7QUFBTztZQUNwQyxNQUFNdlYsZUFBZWdWLGlDQUE0QzNmO1lBQ2pFQSxPQUFPMkssZUFBZUE7WUFDdEJ3VixZQUF5Qm5nQixRQUFRaWdCO0FBQ3BDO0FBQ0osTUFBQyxPQUFPelo7UUFDTHBHLFFBQVFDLElBQUksNENBQTRDbUc7QUFDM0Q7QUFDTDs7QUFFQXpELE9BQU9xZCxXQUFXdmdCLGVBQWdCdUQ7SUFDOUIsTUFBTTlFLFFBQVFraEIsbUJBQTBCcGM7SUFDeEMsT0FBTXRGLFdBQUVBLFdBQVNTLFVBQUVBLGFBQWE4aEIsYUFBYy9oQjtJQUM5QyxJQUFJRSxlQUFlNmhCO0lBRW5CLElBQUk5aEIsYUFBYWYsYUFBYWUsYUFBYVYsT0FBT0UsaUJBQWlCO1FBQy9ERixPQUFPRSxrQkFBa0JRO1FBQ3pCK2hCLFlBQW9CemlCLE9BQU9FO0FBQzlCO0lBRUQsSUFBSUQsY0FBY04sV0FBVztRQUN6QkssT0FBT0MsWUFBWUE7UUFDbkJ5aUIseUJBQXNDemlCO1FBQ3RDVSxhQUFhVixZQUFZQSxhQUFhLFFBQVEsU0FBUztBQUMxRDtJQUVELElBQUlVLGVBQWU7V0FBS0E7V0FBaUJnaUIsdUJBQXVCbGlCOztJQUVoRSxJQUFJRyxPQUFPZ2lCLEtBQUtqaUIsY0FBYzhHLFNBQVMsR0FBRztRQUN0QyxJQUFJeUcsV0FBa0J6TSxNQUFNLEdBQUc7WUFDM0JxZ0IsaUNBQTRDbmhCO0FBQ3hELGVBQWU7WUFDSGtoQiwwQ0FBcURsaEI7QUFDeEQ7QUFDSjtBQUNMOztBQVFBdUUsT0FBTzJkLHFCQUFxQjdnQixlQUFnQnVEO0lBQ3hDLE1BQU05RSxRQUFRa2hCLG1CQUEwQnBjO0lBQ3hDLElBQUk5RSxVQUFVLE1BQU1HLE9BQU9naUIsS0FBS25pQixPQUFPZ0gsVUFBVSxHQUFHO1FBQ2hEcWI7QUFDUixXQUFXO1FBQ0gsSUFBSW5pQixlQUFlZ2lCLHVCQUF1QmxpQjtRQUUxQyxJQUFJRyxPQUFPZ2lCLEtBQUtqaUIsY0FBYzhHLFNBQVMsR0FBRztZQUN0QyxJQUFJeUcsV0FBa0J6TSxNQUFNLEdBQUc7Z0JBQzNCcWdCLGlDQUE0Q25oQjtBQUM1RCxtQkFBbUI7Z0JBQ0hraEIsMENBQXFEbGhCO0FBQ3hEO0FBQ0o7QUFDSjtBQUNMOztBQUVBLFNBQVNnaUIsdUJBQXVCbGlCO0lBQzVCLE9BQU1DLFVBQUVBLFlBQWFEO0lBQ3JCLE9BQU1iLFVBQUVBLFVBQVFFLGNBQUVBLGdCQUFpQkUsT0FBT1EseUJBQXlCQztJQUNuRXNpQiw0QkFBeUNuakIsVUFBVUUsY0FBY1k7SUFFakUsSUFBSUEsYUFBYWYsYUFBYWUsWUFBWVYsT0FBT0UsaUJBQWlCO1FBQzlELE9BQU8sQ0FBRTtBQUNaO0lBQ0QsSUFBSU4sYUFBYUQsV0FBVztRQUV4QnNMLFVBQWlCakwsT0FBT0UsbUJBQW1CWixTQUFTQyxRQUFRLHlCQUF5QixrQkFBa0I7WUFDbkcyTCxVQUFZO1lBQ1plLEtBQU87WUFDUGQsTUFBUXVNO1lBQ1J4TCxXQUFhdE07O0FBRXBCO0lBQ0QsSUFBSUUsaUJBQWlCSCxXQUFXO1FBQzVCcWpCLGNBQXFCaGpCLE9BQU9FLGlCQUFpQkosY0FBYztRQUMzRHdoQjtRQUVBclcsVUFBaUJqTCxPQUFPRSxtQkFBbUJaLFNBQVNDLFFBQVEseUJBQXlCLGtCQUFrQjtZQUNuRzJMLFVBQVk7WUFDWmUsS0FBTztZQUNQZCxNQUFRdU07WUFDUnhMLFdBQWFsTSxPQUFPSjs7QUFFM0I7SUFFRCxJQUFJSSxPQUFPTixXQUFXQyxhQUFhSyxPQUFPSCxhQUFhRixXQUFXO1FBQzlELE9BQU87WUFDSEQsUUFBUU0sT0FBT047WUFDZkcsVUFBVUcsT0FBT0g7O0FBRTdCLFdBQVcsSUFBSUcsT0FBT0gsYUFBYUYsV0FBVztRQUN0QyxPQUFPO1lBQ0hFLFVBQVVHLE9BQU9IOztBQUV4QjtJQUNELE9BQU87QUFDWDs7QUFFQXFGLE9BQU9tTixrQkFBa0JyUSxlQUFnQjZJLE1BQU1vWTtJQUMzQ2pqQixPQUFPRSxrQkFBa0IySztJQUN6QnFZLFdBQXdCclk7SUFDeEJtWSxjQUFxQm5ZLE1BQU03SyxPQUFPRjtJQUNsQyxJQUFJbWpCLFlBQVk7UUFBRUUseUJBQW9DdFksTUFBTTdLLE9BQU9NO0FBQVM7SUFFNUVpZ0IsZ0JBQWdCUyxXQUFXblc7QUFDL0I7O0FBR0EzRixPQUFPa2UsbUJBQW1CLFNBQVVDO0lBQ2hDLElBQUlsakIsZUFBZSxHQUFHa2pCLFVBQVU7SUFDaENyakIsT0FBT0csZUFBZUE7SUFDdEIsSUFBSW1qQixTQUFTcFYsV0FBa0JyTSxvQkFBb0I7SUFDbkR5aEIsU0FBU25qQixlQUFlbWpCLFNBQVMsS0FBS0E7SUFDdENDLG1CQUE4QkQ7SUFDOUJFO0FBQ0o7O0FBR0F0ZSxPQUFPQyxRQUFRbkQ7SUFDWGhDLE9BQU9FLHdCQUF3QnFnQixnQkFBZ0JFO0lBQy9DZ0MsWUFBb0J6aUIsT0FBT0U7QUFDL0IifQ==
