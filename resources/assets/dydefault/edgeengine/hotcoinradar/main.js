const tag = "hotCoinRadar";

var upColorList;

var downColorList;

var commonData = {
    statusHeight: 0,
    priceColorType: 0,
    colorMode: 0,
    OS: 0,
    appVersion: "",
    isInReview: 1,
    isLogin: 0,
    webUrl: "",
    language: "",
    navbarHeight: 44,
    statusBarHeight: 44,
    hasTraderRight: 0
};

function moduleDefine(moduleName, defaultDataFunction, functions = {
    onCreate: onCreate$1,
    onDestroy: onDestroy,
    onResume: onResume$1,
    onPause: onPause,
    onStart: onStart,
    onStop: onStop$1
}) {
    console.log(`loadModule`, moduleName);
    $data[moduleName] = defaultDataFunction();
    $event[moduleName] = {
        onCreate: typeof functions.onCreate == "undefined" ? onCreate$1 : functions.onCreate,
        onDestroy: typeof functions.onDestroy == "undefined" ? onDestroy : functions.onDestroy,
        onResume: typeof functions.onResume == "undefined" ? onResume$1 : functions.onResume,
        onPause: typeof functions.onPause == "undefined" ? onPause : functions.onPause,
        onStart: typeof functions.onStart == "undefined" ? onStart : functions.onStart,
        onStop: typeof functions.onStop == "undefined" ? onStop$1 : functions.onStop
    };
    return {
        moduleData: $data[moduleName],
        moduleEvent: $event[moduleName]
    };
}

function onCreate$1() {
    console.log("common onCreate");
}

function onDestroy() {}

function onResume$1() {}

function onPause() {}

function onStart() {}

function onStop$1() {}

function getPNGIconURLByCurrency(currency) {
    let baseUrl = commonData.webUrl ? commonData.webUrl : "";
    return `${baseUrl}/-/x/hb/p/api/contents/currency/icon_png/${currency.toLowerCase()}.png`;
}

async function sendCommonConfig$1(param) {
    console.log(`${tag} sendCommonConfig ${JSON.stringify(param)}`);
    commonData.priceColorType = parseInt(param.priceColorType);
    commonData.colorMode = parseInt(param.colorMode);
    commonData.OS = parseInt(param.OS);
    commonData.appVersion = param.appVersion;
    commonData.isInReview = parseInt(param.isInReview);
    commonData.language = param.language;
    commonData.webUrl = param.webUrl;
    commonData.statusHeight = commonData.OS == 0 ? param.statusHeight : 0;
    var redColorList = [ "#ADB0B2", "#E94359", "#DE2941", "#CE142B" ];
    var greenColorList = [ "#ADB0B2", "#00A171", "#008B61", "#006245" ];
    if (parseInt(commonData.priceColorType) == 0) {
        upColorList = redColorList;
        downColorList = greenColorList;
    } else {
        upColorList = greenColorList;
        downColorList = redColorList;
    }
    $data.commonData = commonData;
}

async function sendRequest(path, params = {}, method = 0, hostType = 0, header = {}) {
    console.log(`request ${path}, params:${JSON.stringify(params)}`);
    if (hostType == 5 || hostType == 6) {
        header["Content-Type"] = "application/json";
    }
    const param = {
        path: path,
        method: method,
        hostType: hostType,
        header: header,
        params: params
    };
    try {
        var responseString = await $nativeAPI.request(JSON.stringify(param));
        var response = JSON.parse(responseString);
        var {code: code, data: data} = response;
        if (code == 200) {
            console.log(`request ${path} done`);
            return data;
        } else {
            console.log(`request failed, code=${code}`);
            let message = response.message;
            if (method != 0 && message) {
                showToast(message);
            }
            return null;
        }
    } catch (e) {
        console.log(`request error, error=${e}`);
        return null;
    }
}

function getPriceColor(ratio) {
    if (ratio == null) {
        ratio = 0;
    }
    const ratio_abs = Math.abs(ratio);
    var colorLevel = 0;
    if (ratio_abs > 0 && ratio_abs < 3) {
        colorLevel = 1;
    } else if (ratio_abs >= 3 && ratio_abs < 8) {
        colorLevel = 2;
    } else if (ratio_abs >= 8) {
        colorLevel = 3;
    }
    var colorHexStr = null;
    if (ratio > 0) {
        colorHexStr = upColorList[colorLevel];
    } else {
        colorHexStr = downColorList[colorLevel];
    }
    return colorHexStr;
}

function containerBack(params = 0) {
    console.log("containerBack");
    $nativeAPI.containerBack(params);
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

const storageModuleName = "hotCoinDetail";

const storagePageVpnAlertKey = "pageVpnAlertShown";

const storagePageAlertKey = "pageAlertShown";

const storageNewsAlertKey = "newsAlertShown";

var alert = {
    vpnAlertShow: false,
    pageVpnAlertShow: false,
    pageAlertShow: false,
    newsAlertShow: false
};

var currentNotNeedShow = false;

var selNewsMode = {};

var selDynamicMode = {};

const tipTitle = $i18n.n_option_delivery_tip;

var hasDynamic = 0;

var hasNews = 0;

const ChartPeriod = {
    Period24: `24${$i18n.n_notification_push_nodisturb_hour}`,
    Period7day: `7${$i18n.n_mining_day_text}`,
    Period30day: `30${$i18n.n_mining_day_text}`,
    Period90day: `90${$i18n.n_mining_day_text}`,
    Period1year: `1${$i18n.n_hotcoin_radar_year}`
};

const selSecondColor = "@color/kColorMajorTheme100";

const selSecondBgColor = "@color/kColorMajorTheme006";

const normalSecondColor = "@color/kColorPrimaryText";

const normalSecondBgColor = "@color/KBaseColorInputBackground";

const selTitleColor = "@color/kColorPrimaryText";

const normalTitleColor = "@color/kColorThreeLevelText";

const showSourceTitle = $i18n.n_content_translate_show_originaltext;

const showContentTitle = $i18n.n_content_translate;

var coinNewPageNo = 1;

var coinDynamicHotPageNo = 1;

var coinDynamicLastPageNo = 1;

var selPeriodIndex = 0;

var selChartIndex = 0;

var selPostIndex = 0;

var selListIndex = 0;

var coinNewsArray = [];

var coinDynamicHotArray = [];

var coinDynamicLastArray = [];

var lastPointListJson = "";

async function start() {
    playLottie();
    configData();
    await requestDetailInfo();
    coinDynamicHotArray = await requestPostListData();
    coinNewsArray = await requestCoinNews();
    stopLottie();
    if (hasDynamic == 1) {
        moduleData.listTitles.elitePostsTitleVisibility = "visible";
        moduleData.listTitles.elitePostsTitleColor = selTitleColor;
        moduleData.list = coinDynamicHotArray;
    } else {
        moduleData.listTitles.elitePostsTitleVisibility = "gone";
        moduleData.listTitles.filterButtonVisibility = "gone";
        moduleData.listTitles.elitePostsTitleColor = normalTitleColor;
    }
    if (hasNews == 1) {
        moduleData.listTitles.newsTitleTitleVisibility = "visible";
        if (hasDynamic == 1) {
            moduleData.listTitles.newsTitleTitleVisibility = normalTitleColor;
        } else {
            moduleData.listTitles.newsTitleColor = selTitleColor;
            selListIndex = 1;
            moduleData.list = coinNewsArray;
        }
    } else {
        moduleData.listTitles.newsTitleTitleVisibility = "gone";
    }
}

function playLottie() {
    moduleData.pageVisibilityConig.listVisibility = "gone";
    moduleData.pageVisibilityConig.loadingVisibility = "visible";
    moduleData.loadingLottieStatus = "play";
}

function stopLottie() {
    moduleData.pageVisibilityConig.listVisibility = "visible";
    moduleData.pageVisibilityConig.loadingVisibility = "gone";
    moduleData.loadingLottieStatus = "stop";
}

function defaultData() {
    return {
        list: [],
        refreshStatus: 0,
        loadMoreStatus: 0,
        periodIndex: 0,
        coin: "--",
        coinPrice: "--",
        coinPriceRange: "--",
        coinPriceRangeTextColor: "@color/kColorSecondaryButtonText",
        marketSentiment: {
            title: $i18n.n_hotcoin_radar_market_sentiment,
            bullishTitle: "--",
            bullishColor: "",
            bullishValue: "0.5",
            bullishImageVisibility: "visible",
            bearishTitle: "--",
            bearishColor: "",
            bearishValue: "0.5",
            bearishImageVisibility: "visible"
        },
        listTitles: {
            elitePostsTitle: $i18n.n_hotcoin_radar_selected,
            elitePostsTitleColor: selTitleColor,
            elitePostsTitleVisibility: "visible",
            newsTitle: $i18n.n_hotcoin_radar_news,
            newsTitleColor: normalTitleColor,
            newsTitleTitleVisibility: "visible",
            hotTitle: $i18n.n_community_hot,
            hotTitleColor: selSecondColor,
            hotTitleBackgroundColor: selSecondBgColor,
            lastTitle: $i18n.n_home_feed_tab_news,
            lastTitleColor: normalSecondColor,
            lastTitleBackgroundColor: normalSecondBgColor,
            filterButtonVisibility: "visible"
        },
        itemTitle: {
            sourceTitle: "",
            interactionsTitle: $i18n.n_hotcoin_radar_number_interaction
        },
        tradeTitle: $i18n.n_new_user_guide_trade,
        topChartPopList: [ {
            type: "1",
            title: $i18n.n_spot_order_price,
            index: "0",
            textColor: "@color/kColorSecondaryButtonText",
            selImageVisibility: "visible",
            selected: "true"
        }, {
            type: "1",
            title: $i18n.n_hotcoin_radar_number_interaction,
            index: "1",
            textColor: "@color/kColorSecondaryButtonText",
            selImageVisibility: "gone",
            selected: "false"
        }, {
            type: "1",
            title: $i18n.n_hotcoin_radar_number_mentions,
            index: "2",
            textColor: "@color/kColorSecondaryButtonText",
            selImageVisibility: "gone",
            selected: "false"
        }, {
            type: "1",
            title: $i18n.n_hotcoin_radar_ruling_rate,
            index: "3",
            textColor: "@color/kColorSecondaryButtonText",
            selImageVisibility: "gone",
            selected: "false"
        }, {
            type: "1",
            title: $i18n.n_hotcoin_radar_bullish_sentiment,
            index: "4",
            textColor: "@color/kColorSecondaryButtonText",
            selImageVisibility: "gone",
            selected: "false"
        } ],
        pointListJson: "",
        tipAlertTitle: "",
        tipAlertContent: "",
        periodList: [ {
            type: "1",
            text: ChartPeriod.Period24,
            textColor: "@color/kColorMajorTheme100",
            textFontWeight: "400",
            backgroundColor: "@color/kColorMajorTheme006",
            index: "0"
        }, {
            type: "1",
            text: ChartPeriod.Period7day,
            textColor: "@color/kColorSecondaryText",
            backgroundColor: "@color/KBaseColorContentBackground",
            index: "1"
        }, {
            type: "1",
            text: ChartPeriod.Period30day,
            textColor: "@color/kColorSecondaryText",
            backgroundColor: "@color/KBaseColorContentBackground",
            index: "2"
        }, {
            type: "1",
            text: ChartPeriod.Period90day,
            textColor: "@color/kColorSecondaryText",
            backgroundColor: "@colo#r/KBaseColorContentBackground",
            index: "3"
        }, {
            type: "1",
            text: ChartPeriod.Period1year,
            textColor: "@color/kColorSecondaryText",
            backgroundColor: "@color/KBaseColorContentBackground",
            index: "4"
        } ],
        chartSelectorTitle: $i18n.n_spot_order_price,
        topIcon: "",
        topTitle: "",
        symbol: "",
        placeholder: {
            one: "@drawable/hotcoin_radar_dynamic_placeholder_343",
            left: "@drawable/hotcoin_radar_dynamic_placeholder_170",
            small: "@drawable/hotcoin_radar_dynamic_placeholder_108"
        },
        pageVisibilityConig: {
            listVisibility: "gone",
            loadingVisibility: "visible"
        },
        loadingLottieStatus: "play"
    };
}

const {moduleData: moduleData, moduleEvent: moduleEvent} = moduleDefine("detail", defaultData, {
    onCreate: onCreate,
    onResume: onResume,
    onStop: onStop
});

async function onCreate(jsonParameters) {
    moduleData.statusBarConfig = {
        statusBarMode: "true",
        adStatusBarColor: "kColorContentBackground"
    };
    parameter = JSON.parse(jsonParameters);
    console.log(`${tag} onCreate ${JSON.stringify(parameter)}`);
    moduleData.topIcon = getPNGIconURLByCurrency(parameter.coin);
    moduleData.topTitle = `${parameter.coin}`;
    moduleData.tradeMarginBottom = commonData.OS == 0 ? "36" : "0", start();
    var properties = {
        page: "RecomCoinDetail"
    };
    const propertiesJson = JSON.stringify(properties);
    var map = {
        event: "pageVIew",
        properties: propertiesJson
    };
    await $nativeAPI.analytics(map);
}

function configData() {
    if (commonData.priceColorType == 0) {
        moduleData.marketSentiment.bullishColor = "#F95A50";
        moduleData.marketSentiment.bearishColor = "#00A171";
    } else {
        moduleData.marketSentiment.bullishColor = "#00A171";
        moduleData.marketSentiment.bearishColor = "#F95A50";
    }
}

function configTipAlertTitle(title = $i18n.n_copy_trading_tip, content = "", buttonType = 0, noReminderShow = "gone") {
    currentNotNeedShow = false;
    moduleData.tipAlertTitle = title;
    moduleData.tipAlertContent = content;
    if (buttonType == 0) {
        moduleData.showContinue = "gone";
        moduleData.showIKnow = "visible";
    } else if (buttonType == 1) {
        moduleData.showContinue = "visible";
        moduleData.showIKnow = "gone";
    }
    moduleData.noReminderShow = noReminderShow;
    moduleData.noReminderImage = "@drawable/common_check_unselected";
}

async function requestPostListData() {
    var params = {};
    params.type = "hot";
    params.coin = moduleData.topTitle;
    if (selPostIndex == 1) {
        params.type = "last";
        params.pageNo = coinDynamicLastPageNo;
    } else {
        params.type = "hot";
        params.pageNo = coinDynamicHotPageNo;
    }
    params.pageSize = 10;
    console.log(`requestPostListData.params=${params.toString()}`);
    var data = await sendRequest("v1/content/community/token-discern/coin-dynamic", params);
    console.log(`requestPostListData.params=${JSON.stringify(data)}`);
    try {
        if (!data || data == null || !data.listData || data.listData == null || data.listData.length == 0) {
            return;
        }
        var dataArr = await handleElitePosts(data.listData);
        if (selPostIndex == 1) {
            coinDynamicLastPageNo++;
        } else {
            coinDynamicHotPageNo++;
        }
        return dataArr;
    } catch (e) {
        console.log(`handle couponList  error=${e}`);
    }
}

async function requestDetailInfo() {
    var params = {};
    params.coin = moduleData.topTitle;
    params.klineTypeList = selChartIndex + 1;
    params.period = getPeriodString();
    console.log(`requestDetailInfo.params=${JSON.stringify(params)}`);
    showLoading(true);
    var data = await sendRequest("v1/content/community/token-discern/coin-info", params);
    showLoading(false);
    console.log(`requestDetailInfo.params=${JSON.stringify(data)}`);
    try {
        if (!data || data == null) {
            return;
        }
        handleDetailInfo(data);
    } catch (e) {
        console.log(`requestDetailInfo  error=${e}`);
    }
}

moduleEvent.onRefresh = async function() {
    if (selListIndex == 1) {
        coinNewPageNo = 1;
        coinNewsArray = await requestCoinNews();
        moduleData.list = coinNewsArray;
    } else {
        if (selPostIndex == 1) {
            coinDynamicLastPageNo = 1;
            coinDynamicLastArray = await requestPostListData();
            moduleData.list = coinDynamicLastArray;
        } else {
            coinDynamicHotPageNo = 1;
            coinDynamicHotArray = await requestPostListData();
            moduleData.list = coinDynamicHotArray;
        }
    }
    moduleData.refreshStatus = 2;
};

moduleEvent.onLoadMore = async function() {
    if (selListIndex == 1) {
        const arr = await requestCoinNews();
        if (arr && arr.length > 0) {
            coinNewsArray.push(...arr);
            arr.forEach((element => {
                moduleData.list.push(element);
            }));
        }
    } else {
        if (selPostIndex == 1) {
            const arr = await requestPostListData();
            if (arr && arr.length > 0) {
                coinDynamicLastArray.push(...arr);
                arr.forEach((element => {
                    moduleData.list.push(element);
                }));
            }
        } else {
            const arr = await requestPostListData();
            if (arr && arr.length > 0) {
                coinDynamicHotArray.push(...arr);
                arr.forEach((element => {
                    moduleData.list.push(element);
                }));
            }
        }
    }
    moduleData.loadMoreStatus = 2;
};

moduleEvent.tradeAction = async function() {
    $nativeAPI.openRoute(`holigeit://open/v1?login=0&url=ihuobiglobal://m.hbg.com/trade/index?type=pro&symbol=${moduleData.symbol}`);
    var properties = {
        module_name: "goTrade"
    };
    const propertiesJson = JSON.stringify(properties);
    var map = {
        event: "appClick_Opporunity",
        properties: propertiesJson
    };
    await $nativeAPI.analytics(map);
};

moduleEvent.selectedHotAction = async function() {
    selPostIndex = 0;
    moduleData.listTitles.hotTitleColor = selSecondColor;
    moduleData.listTitles.hotTitleBackgroundColor = selSecondBgColor;
    moduleData.listTitles.lastTitleColor = normalSecondColor;
    moduleData.listTitles.lastTitleBackgroundColor = normalSecondBgColor;
    moduleData.list = coinDynamicHotArray;
    var properties = {
        module_name: "selectTab",
        type: "hotest"
    };
    await analyticsAppClickRecomCoinDetail(properties);
};

moduleEvent.selectedLastAction = async function() {
    console.log("selectedLastAction");
    selPostIndex = 1;
    moduleData.listTitles.hotTitleColor = normalSecondColor;
    moduleData.listTitles.hotTitleBackgroundColor = normalSecondBgColor;
    moduleData.listTitles.lastTitleColor = selSecondColor;
    moduleData.listTitles.lastTitleBackgroundColor = selSecondBgColor;
    if (coinDynamicLastArray.length <= 0) {
        coinDynamicLastArray = await requestPostListData();
    }
    moduleData.list = coinDynamicLastArray;
    var properties = {
        module_name: "selectTab",
        type: "latest"
    };
    await analyticsAppClickRecomCoinDetail(properties);
};

moduleEvent.elitePostsAction = async function() {
    moduleData.listTitles.elitePostsTitleColor = selTitleColor;
    moduleData.listTitles.newsTitleColor = normalTitleColor;
    moduleData.listTitles.filterButtonVisibility = "visible";
    selListIndex = 0;
    if (selPostIndex == 1) {
        moduleData.list = coinDynamicLastArray;
    } else {
        moduleData.list = coinDynamicHotArray;
    }
    var properties = {
        module_name: "selectTab",
        type: "posts"
    };
    await analyticsAppClickRecomCoinDetail(properties);
};

moduleEvent.selectedNewsAction = async function() {
    selListIndex = 1;
    moduleData.listTitles.elitePostsTitleColor = normalTitleColor;
    moduleData.listTitles.newsTitleColor = selTitleColor;
    moduleData.listTitles.filterButtonVisibility = "gone";
    moduleData.list = coinNewsArray;
    var properties = {
        module_name: "selectTab",
        type: "news"
    };
    await analyticsAppClickRecomCoinDetail(properties);
};

async function analyticsAppClickRecomCoinDetail(properties) {
    const propertiesJson = JSON.stringify(properties);
    var map = {
        event: "appClick_RecomCoinDetail",
        properties: propertiesJson
    };
    await $nativeAPI.analytics(map);
}

moduleEvent.marketSentimentInfoAction = async function() {
    configTipAlertTitle($i18n.n_hotcoin_radar_market_sentiment, $i18n.n_hotcoin_radar_market_sentiment_explanation);
    moduleData.tipAlertShow = true;
};

moduleEvent.imageSelected = async function(imageIndex, itemIndex) {
    console.log(`imageSelected,imageIndex${imageIndex},itemIndex==${itemIndex}`);
    if (itemIndex < moduleData.list.length) {
        var item = moduleData.list[itemIndex];
        var imgList = item.imageList.rawArray();
        if (imgList != null) {
            var map = {
                currentIndex: imageIndex,
                imageList: imgList
            };
            console.log(`imageSelected,imgListJson==${JSON.stringify(map)}`);
            $nativeAPI.openPreviewImage(JSON.stringify(map));
        }
    }
};

moduleEvent.sourceItemSelected = async function(index) {
    if (index) {
        let i = parseInt(index);
        let model = moduleData.list[i];
        if (model.showSource == true) {
            model.showContent = model.content;
            model.parentDynamicContent = model.parentDynamic;
            model.sourceTitle = showSourceTitle;
            model.showSource = false;
            var properties = {
                module_name: "translate",
                type: "translate"
            };
            await analyticsAppClickRecomCoinDetail(properties);
        } else {
            model.showContent = model.sourceContent;
            model.parentDynamicContent = model.sourceParentDynamic;
            model.sourceTitle = showContentTitle;
            model.showSource = true;
            var properties = {
                module_name: "translate",
                type: "original"
            };
            await analyticsAppClickRecomCoinDetail(properties);
        }
    }
};

moduleEvent.cellSelected = async function(index) {
    let selIndex = parseInt(index);
    if (selListIndex == 1) {
        selNewsMode = coinNewsArray[selIndex];
        if (selNewsMode) {
            if (selNewsMode.dynamicId) {
                $nativeAPI.openRoute(`holigeit://open/v1?url=ihuobiglobal://m.hbg.com/content/DynamicDetail?dynamicId=${selNewsMode.dynamicId}`);
            } else {
                const newsAlertShown = await read(storageModuleName, storageNewsAlertKey);
                if (newsAlertShown == "1") {
                    $nativeAPI.openRoute(selNewsMode.sourceLink);
                } else {
                    configTipAlertTitle(tipTitle, $i18n.n_hotcoin_radar_tip_continue_accessing_link, 1, "visible");
                    moduleData.tipAlertShow = true;
                    alert.newsAlertShow = true;
                }
            }
        }
        var properties = {
            module_name: "content",
            type: "news"
        };
        await analyticsAppClickRecomCoinDetail(properties);
    } else {
        const pageShown = await read(storageModuleName, storagePageAlertKey);
        const pageVpnShown = await read(storageModuleName, storagePageVpnAlertKey);
        if (selPostIndex == 1) {
            selDynamicMode = coinDynamicLastArray[selIndex];
        } else {
            selDynamicMode = coinDynamicHotArray[selIndex];
        }
        if (commonData.language == "zh-cn") {
            if (pageVpnShown == "1") {
                openDynamic(selDynamicMode);
            } else {
                configTipAlertTitle(tipTitle, "当前内容来源为 X，点击继续将打开 X 页面，请打开 VPN 后再访问 X", 1, "visible");
                moduleData.tipAlertShow = true;
                alert.pageVpnAlertShow = true;
            }
        } else {
            if (pageShown == "1") {
                openDynamic(selDynamicMode);
            } else {
                configTipAlertTitle(tipTitle, $i18n.n_hotcoin_radar_tip_turn_on_x, 1, "visible");
                moduleData.tipAlertShow = true;
                alert.pageAlertShow = true;
            }
        }
        var properties = {
            module_name: "content",
            type: "posts"
        };
        await analyticsAppClickRecomCoinDetail(properties);
    }
};

function clearAlertShowStatus() {
    alert.newsAlertShow = false;
    alert.pageAlertShow = false;
    alert.pageVpnAlertShow = false;
}

async function handleElitePosts(data) {
    var array = [];
    for (var i = 0; i < data.length; i++) {
        var model = await handleElitePostsModel(data[i], i);
        array.push(model);
    }
    return array;
}

async function handleElitePostsModel(item, index) {
    var model = {};
    model.nickname = item.nickname;
    model.avatar = item.avatar;
    model.authUrl = "";
    model.postId = item.postId;
    model.content = item.content;
    model.languageId = item.languageId;
    model.sourceLanguageId = item.sourceLanguageId;
    model.showSource = model.showSource;
    model.sourceContent = item.sourceContent;
    model.sourceLink = item.sourceLink;
    model.imageList = item.imageList;
    if (selPostIndex == 1) {
        if (coinDynamicLastPageNo > 1) {
            model.index = String(index + coinDynamicLastArray.length);
        } else {
            model.index = String(index);
        }
    } else {
        if (coinDynamicHotPageNo > 1) {
            model.index = String(index + coinDynamicHotArray.length);
        } else {
            model.index = String(index);
        }
    }
    model.publishTime = toFormatedDetailDate(item.publishTime);
    if (item.showSource == 1) {
        model.sourceTitle = showSourceTitle;
        model.sourceVisibility = "visible";
    } else {
        model.sourceTitle = "";
        model.sourceVisibility = "gone";
    }
    model.isSource = false;
    model.showContent = model.content;
    model.type = "1";
    if (item.imageList && item.imageList.length > 0) {
        model.imageComponenVisibility = "visible";
        if (item.imageList.length == 1) {
            model.oneImageVisibility = "visible";
            model.twoImageVisibility = "gone";
            model.threeImageVisibility = "gone";
            model.fourImageVisibility = "gone";
            model.imageOne = item.imageList[0];
        } else if (item.imageList.length == 2) {
            model.oneImageVisibility = "gone";
            model.twoImageVisibility = "visible";
            model.threeImageVisibility = "gone";
            model.fourImageVisibility = "gone";
            model.imageOne = item.imageList[0];
            model.imageTwo = item.imageList[1];
        } else if (item.imageList.length == 3) {
            model.oneImageVisibility = "gone";
            model.twoImageVisibility = "gone";
            model.threeImageVisibility = "visible";
            model.fourImageVisibility = "gone";
            model.imageOne = item.imageList[0];
            model.imageTwo = item.imageList[1];
            model.imageThree = item.imageList[2];
        } else {
            model.oneImageVisibility = "gone";
            model.twoImageVisibility = "gone";
            model.threeImageVisibility = "gone";
            model.fourImageVisibility = "visible";
            model.imageOne = item.imageList[0];
            model.imageTwo = item.imageList[1];
            model.imageThree = item.imageList[2];
            model.imageFour = item.imageList[3];
        }
    } else {
        model.imageComponenVisibility = "gone";
        model.oneImageVisibility = "gone";
        model.twoImageVisibility = "gone";
        model.threeImageVisibility = "gone";
        model.fourImageVisibility = "gone";
        model.imageOne = "";
        model.imageTwo = "";
        model.imageThree = "";
        model.imageFour = "";
    }
    if (item.parentDynamic && item.parentDynamic.length > 0) {
        model.parentDynamicComponenVisibility = "visible";
        model.parentDynamic = item.parentDynamic;
        model.sourceParentDynamic = item.sourceParentDynamic;
        model.parentDynamicContent = item.parentDynamic;
    } else {
        model.parentDynamicComponenVisibility = "gone";
        model.parentDynamicContent = "";
    }
    if (item.interactions && item.interactions > 0) {
        const interactions = item.interactions.toString();
        const interactionsString = await $nativeAPI.convertString(interactions);
        model.interactions = interactionsString;
    } else {
        model.interactions = "0";
    }
    return model;
}

async function requestCoinNews() {
    var params = {};
    params.coin = moduleData.coin;
    params.pageNo = coinNewPageNo;
    params.pageSize = 10;
    var data = await sendRequest("v1/content/community/token-discern/coin-news", params);
    try {
        if (!data || data == null || !data.listData || data.listData == null || data.listData.length == 0) {
            return;
        }
        coinNewPageNo++;
        return handleNews(data.listData);
    } catch (e) {
        console.log(`handle couponList  error=${e}`);
    }
}

function handleNews(data) {
    var array = [];
    for (var i = 0; i < data.length; i++) {
        var model = handleNewsItem(data[i], i);
        array.push(model);
    }
    return array;
}

function handleNewsItem(item, index) {
    var model = {};
    model.newsContent = item.content;
    model.newsSouce = item.nickname;
    model.newsTime = model.publishTime = toFormatedDetailDate(item.publishTime);
    model.type = "2";
    model.sourceLanguageId = item.sourceLanguageId;
    model.sourceLink = item.sourceLink;
    model.dynamicId = item.dynamicId;
    if (coinNewPageNo > 1) {
        model.index = String(index + coinNewsArray.length);
    } else {
        model.index = String(index);
    }
    model.newsId = item.newsId;
    return model;
}

moduleEvent.clickedChartSelector = async function() {
    moduleData.showChartPop = true;
    console.log("clickedChartSelector");
};

moduleEvent.clickedChartSelectorCancel = function() {
    moduleData.showChartPop = false;
};

moduleEvent.clickedChartMenuItem = async function(index) {
    if (index == selChartIndex) {
        return;
    }
    var lastItem = moduleData.topChartPopList[selChartIndex];
    lastItem.textColor = "@color/kColorSecondaryButtonText";
    lastItem.selImageVisibility = "gone";
    lastItem.selected = "false";
    selChartIndex = index;
    var selItem = moduleData.topChartPopList[selChartIndex];
    selItem.textColor = "@color/kColorSecondaryButtonText";
    selItem.selImageVisibility = "visible";
    selItem.selected = "true";
    moduleData.chartSelectorTitle = selItem.title;
    console.log(`index==${selChartIndex},title==${moduleData.topChartPopList[selChartIndex].title}`);
    moduleData.showChartPop = false;
    var typeStr = "price";
    if (selChartIndex == 1) {
        typeStr = "engagement";
    } else if (selChartIndex == 2) {
        typeStr = "mention";
    } else if (selChartIndex == 3) {
        typeStr = "dominance";
    } else if (selChartIndex == 4) {
        typeStr = "sentiment";
    }
    var properties = {
        module_name: "ChartIndicator",
        type: typeStr
    };
    const propertiesJson = JSON.stringify(properties);
    var map = {
        event: "appClick_RecomCoinDetail",
        properties: propertiesJson
    };
    await $nativeAPI.analytics(map);
    await requestDetailInfo();
};

moduleEvent.clickedPeriodItem = async function(index) {
    if (index == selPeriodIndex) {
        return;
    }
    if (index < moduleData.periodList.length) {
        var lastItem = moduleData.periodList[selPeriodIndex];
        lastItem.textColor = "@color/kColorSecondaryText";
        lastItem.backgroundColor = "@color/KBaseColorContentBackground";
        lastItem.textFontWeight = "400";
        selPeriodIndex = index;
        var selItem = moduleData.periodList[selPeriodIndex];
        selItem.textColor = "@color/kColorMajorTheme100";
        selItem.backgroundColor = "@color/kColorMajorTheme006";
        selItem.textFontWeight = "500";
    }
    var typeStr = getPeriodString();
    console.log(`index==${selPeriodIndex},title==${typeStr}`);
    var propertiesMap = {
        module_name: "ChartPeriod",
        type: typeStr
    };
    const propertiesJson = JSON.stringify(propertiesMap);
    var map = {
        event: "appClick_RecomCoinDetail",
        properties: propertiesJson
    };
    await $nativeAPI.analytics(map);
    await requestDetailInfo();
};

function getPeriodString() {
    switch (selPeriodIndex + 1) {
      case 1:
        return "24h";

      case 2:
        return "7d";

      case 3:
        return "30d";

      case 4:
        return "90d";

      case 5:
        return "1y";
    }
}

async function handleDetailInfo(data) {
    if (data != null) {
        moduleData.coin = data.coin;
        moduleData.coinPrice = `$${data.coinPrice}`;
        if (data.symbol != null) {
            moduleData.symbol = data.symbol;
        }
        if (data.coinPriceRange > 0) {
            moduleData.coinPriceRange = `+${data.coinPriceRange}%`;
        } else if (data.coinPriceRange < 0) {
            moduleData.coinPriceRange = `${data.coinPriceRange}%`;
        }
        moduleData.coinPriceRangeTextColor = getPriceColor(data.coinPriceRange);
        hasDynamic = data.hasDynamic;
        hasNews = data.hasNews;
        var bullish = parseFloat(data.sentiment).toFixed(0);
        var bearish = (100 - bullish).toFixed(0);
        moduleData.marketSentiment.bullishTitle = bullish.toString() + "%" + $i18n.n_hotcoin_radar_bullish;
        moduleData.marketSentiment.bullishValue = (bullish / 100).toString();
        if (bullish == 100) {
            moduleData.marketSentiment.bullishImageVisibility = "gone";
        } else {
            moduleData.marketSentiment.bullishImageVisibility = "visible";
        }
        moduleData.marketSentiment.bearishTitle = bearish.toString() + "%" + $i18n.n_hotcoin_radar_bearish;
        moduleData.marketSentiment.bearishValue = (bearish / 100).toString();
        if (bearish == 100) {
            moduleData.marketSentiment.bearishImageVisibility = "gone";
        } else {
            moduleData.marketSentiment.bearishImageVisibility = "visible";
        }
    }
    if (data.kline != null && data.kline.length > 0) {
        for (var i = 0; i < data.kline.length; i++) {
            var item = data.kline[i];
            if (item.type == selChartIndex + 1 && item.list.length > 0) {
                var pointList = [];
                var xList = [];
                for (var j = 0; j < item.list.length; j++) {
                    var chartItem = item.list[j];
                    var popItem = {};
                    popItem.originalValue = chartItem.number;
                    var timeNum = chartItem.time.toString().length === 10 ? chartItem.time * 1e3 : chartItem.time;
                    popItem.popupDate = `${timestampToMMDD(timeNum)} ${timestampToHHmm(timeNum)}`;
                    if (selChartIndex == 0) {
                        popItem.popupContent = `${moduleData.chartSelectorTitle}：$${chartItem.number}`;
                    } else if (selChartIndex == 3) {
                        popItem.popupContent = `${moduleData.chartSelectorTitle}：${parseFloat(chartItem.number).toFixed(2)}%`;
                    } else if (selChartIndex == 4) {
                        popItem.popupContent = `${moduleData.chartSelectorTitle}：${parseFloat(chartItem.number).toFixed(2)}%`;
                    } else {
                        var amountString = await $nativeAPI.convertString(chartItem.number.toString());
                        popItem.popupContent = `${moduleData.chartSelectorTitle}：${amountString}`;
                    }
                    pointList.push(popItem);
                    var xTime;
                    if (selPeriodIndex == 0) {
                        xTime = timestampToHHmm(timeNum);
                    } else {
                        xTime = timestampToMMDD(timeNum);
                    }
                    xList.push(xTime);
                }
                xList = handleXList(xList);
                var listMap = {
                    pointList: pointList,
                    xList: xList
                };
                let json = JSON.stringify(listMap);
                if (lastPointListJson != json) {
                    moduleData.pointListJson = json;
                    lastPointListJson = json;
                }
            }
        }
    }
}

function handleXList(list) {
    if (list.length <= 5) {
        return list;
    }
    var midIndex = Math.floor(list.length / 2);
    var letfMidIndex = Math.floor(list.length / 4);
    var rightMidIndex = Math.floor(list.length / 4) + Math.floor(list.length / 2);
    var start = list[0];
    var leftMid = list[letfMidIndex];
    var mid = list[midIndex];
    var rightMid = list[rightMidIndex];
    var end = list[list.length - 1];
    return [ start, leftMid, mid, rightMid, end ];
}

function timestampToMMDD(timestamp, multiplier = 1) {
    const date = new Date(timestamp * multiplier);
    date.getFullYear();
    const month = ("0" + (date.getMonth() + 1)).slice(-2);
    const day = ("0" + date.getDate()).slice(-2);
    return `${month}/${day}`;
}

function timestampToHHmm(timestamp, multiplier = 1) {
    const date = new Date(timestamp * multiplier);
    const hours = date.getHours();
    const minutes = date.getMinutes();
    const formattedHours = hours.toString().padStart(2, "0");
    const formattedMinutes = minutes.toString().padStart(2, "0");
    return `${formattedHours}:${formattedMinutes}`;
}

moduleEvent.clickedTipCancel = function() {
    moduleData.tipAlertShow = false;
    currentNotNeedShow = false;
    clearAlertShowStatus();
};

moduleEvent.clickedContinue = async function() {
    var show = false;
    moduleData.tipAlertShow = false;
    if (alert.newsAlertShow == true) {
        if (currentNotNeedShow == true) {
            await save(storageModuleName, storageNewsAlertKey, "1");
        }
        $nativeAPI.openRoute(selNewsMode.sourceLink);
    } else if (alert.pageAlertShow == true) {
        if (currentNotNeedShow == true) {
            await save(storageModuleName, storagePageAlertKey, "1");
        }
        if (commonData.language == "zh-cn") {
            const pageVpnShown = await read(storageModuleName, storagePageVpnAlertKey);
            if (pageVpnShown == "1") {
                openDynamic(selDynamicMode);
            } else {
                configTipAlertTitle(tipTitle, $i18n.n_hotcoin_radar_tip_turn_on_vpn, 1, "visible");
                show = true;
            }
        } else {
            openDynamic(selDynamicMode);
        }
    } else if (alert.pageVpnAlertShow == true) {
        if (currentNotNeedShow == true) {
            await save(storageModuleName, storagePageVpnAlertKey, "1");
        }
        openDynamic(selDynamicMode);
    }
    currentNotNeedShow = false;
    if (clear == true) {
        clearAlertShowStatus();
    }
    if (show) {
        moduleData.tipAlertShow = true;
        alert.pageVpnAlertShow = true;
    }
};

function openDynamic(selModel) {
    if (selModel && selModel.sourceLink) {
        let link;
        if (selModel.sourceLink.indexOf("?") !== -1) {
            link = `${selModel.sourceLink}&hb_isCanNotGoBack=true`;
        } else {
            link = `${selModel.sourceLink}?hb_isCanNotGoBack=true`;
        }
        $nativeAPI.openRoute(link);
    }
}

moduleEvent.clickedIKnow = function() {
    moduleData.tipAlertShow = false;
};

moduleEvent.clickedNoReminder = function() {
    if (currentNotNeedShow == false) {
        currentNotNeedShow = true;
        moduleData.noReminderImage = "@drawable/common_check_selected";
    } else {
        currentNotNeedShow = false;
        moduleData.noReminderImage = "@drawable/common_check_unselected";
    }
};

moduleEvent.backClicked = function() {
    containerBack();
};

function onResume() {}

function onStop() {}

function toFormatedDetailDate(timestamp) {
    const date = new Date(parseInt(timestamp));
    const timeInterval = Math.abs((date - new Date) / 1e3);
    if (timeInterval < 60) {
        return $i18n.n_content_date_justnow;
    } else if (timeInterval < 3600) {
        const minutes = Math.floor(timeInterval / 60);
        return $i18n.$intercept.n_content_date_minutesago(`${minutes}`);
    } else if (timeInterval <= 86400) {
        const isToday = isDateInToday(date);
        if (isToday) {
            const hour = Math.floor(timeInterval / 3600);
            return $i18n.$intercept.n_content_date_hoursago(`${hour}`);
        } else {
            const timeStr = formatDate(date, "HH:mm");
            return $i18n.n_content_date_yesterday + " " + timeStr;
        }
    } else {
        const isYesterday = isDateInYesterday(date);
        if (isYesterday) {
            const timeStr = formatDate(date, "HH:mm");
            return $i18n.n_content_date_yesterday + " " + timeStr;
        }
        const now = new Date;
        const isSameYear = date.getFullYear() === now.getFullYear();
        if (isSameYear) {
            return formatDate(date, "MM-dd HH:mm");
        } else {
            return formatDate(date, "yyyy-MM-dd HH:mm");
        }
    }
}

function isDateInToday(date) {
    const today = new Date;
    return date.getFullYear() === today.getFullYear() && date.getMonth() === today.getMonth() && date.getDate() === today.getDate();
}

function isDateInYesterday(date) {
    const yesterday = new Date;
    yesterday.setDate(yesterday.getDate() - 1);
    return date.getFullYear() === yesterday.getFullYear() && date.getMonth() === yesterday.getMonth() && date.getDate() === yesterday.getDate();
}

function formatDate(date, format) {
    const year = date.getFullYear();
    const month = ("0" + (date.getMonth() + 1)).slice(-2);
    const day = ("0" + date.getDate()).slice(-2);
    const hours = ("0" + date.getHours()).slice(-2);
    const minutes = ("0" + date.getMinutes()).slice(-2);
    return format.replace("yyyy", year).replace("MM", month).replace("dd", day).replace("HH", hours).replace("mm", minutes);
}

function showLoading(isShow = true) {
    $nativeAPI.showLoading(isShow ? 1 : 0);
}

function sendCommonConfig(param) {
    sendCommonConfig$1(param);
}

$event.sendCommonConfig = sendCommonConfig;
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWFpbi5qcyIsInNvdXJjZXMiOlsiLi4vLi4vcmVwb3NpdG9yeS9zcmMvY29tbW9uLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvZGV0YWlsLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvbWFpbi5qcyJdLCJzb3VyY2VzQ29udGVudCI6WyJleHBvcnQgY29uc3QgdGFnID0gXCJob3RDb2luUmFkYXJcIlxuXG4vKipcbiAqIEB0eXBlZGVmIHtPYmplY3R9IENvbW1vbkRhdGFcbiAqIEBwcm9wZXJ0eSB7bnVtYmVyfSBwcmljZUNvbG9yVHlwZSAgICAtIOS7t+agvOa2qOi3jOW5heminOiJsuiuvue9rlxuICogQHByb3BlcnR5IHtudW1iZXJ9IGNvbG9yTW9kZSAgICAgICAgIC0g55m95aSp6buR5aSc5qih5byPXG4gKiBAcHJvcGVydHkge3N0cmluZ30gbGFuZ3VhZ2UgICAgICAgICAgLSDor63np43phY3nva5cbiAqIEBwcm9wZXJ0eSB7c3RyaW5nfSBPUyAgICAgICAgICAgICAgICAtIOezu+e7n1xuICogQHByb3BlcnR5IHtzdHJpbmd9IGFwcFZlcnNpb24gICAgICAgIC0g54mI5pys5Y+3XG4gKiBAcHJvcGVydHkge251bWJlcn0gaXNJblJldmlldyAgICAgICAgLSBpT1PlrqHmoLjnirbmgIFcbiAqIEBwcm9wZXJ0eSB7bnVtYmVyfSBpc0xvZ2luICAgICAgICAgICAtIOaYr+WQpueZu+W9lVxuICogQHByb3BlcnR5IHtvYmplY3R9IGxpbmVhclN3YXBXc0RhdGEgIC0gVeacrOS9jeWQiOe6puiuoumYheS/oeaBr1xuICovXG5cblxuLy8g6aKc6Imy6YWN572uIDA657qi5rao57u/6LeMIOaIliAxOue7v+a2qOe6oui3jFxudmFyIHVwQ29sb3JMaXN0O1xudmFyIGRvd25Db2xvckxpc3Q7XG5cbi8qKiBAdHlwZSBDb21tb25EYXRhICovXG5leHBvcnQgdmFyIGNvbW1vbkRhdGEgPSB7XG4gIHN0YXR1c0hlaWdodDogMCxcbiAgcHJpY2VDb2xvclR5cGU6IDAsIC8vLzDvvJrnuqLmtqjnu7/ot4wgICAx77ya57u/5rao57qi6LeMXG4gIGNvbG9yTW9kZTogMCwgLy8vMO+8mueZveWkqSAgIDHvvJrpu5HlpJxcbiAgT1M6IDAsIC8vMO+8mmlPUyAgMe+8muWuieWNk1xuICBhcHBWZXJzaW9uOiBcIlwiLCAvL2FwcOeJiOacrOWPt1xuICBpc0luUmV2aWV3OiAxLFxuICBpc0xvZ2luOiAwLFxuICB3ZWJVcmw6IFwiXCIsIC8vLyBoNeWKqOaAgeWfn+WQjVxuICBsYW5ndWFnZTogXCJcIiwgLy8vIOivreiogOenjeexu1xuICBuYXZiYXJIZWlnaHQ6IDQ0LFxuICBzdGF0dXNCYXJIZWlnaHQ6IDQ0LFxuICBoYXNUcmFkZXJSaWdodDogMCxcbn07XG5cbmV4cG9ydCBmdW5jdGlvbiBtb2R1bGVEZWZpbmUobW9kdWxlTmFtZSwgZGVmYXVsdERhdGFGdW5jdGlvbiwgZnVuY3Rpb25zID0geyBvbkNyZWF0ZSwgb25EZXN0cm95LCBvblJlc3VtZSwgb25QYXVzZSwgb25TdGFydCwgb25TdG9wIH0pIHtcbiAgICBjb25zb2xlLmxvZyhgbG9hZE1vZHVsZWAsIG1vZHVsZU5hbWUpO1xuICAgICRkYXRhW21vZHVsZU5hbWVdID0gZGVmYXVsdERhdGFGdW5jdGlvbigpO1xuICAgICRldmVudFttb2R1bGVOYW1lXSA9IHtcbiAgICAgICAgb25DcmVhdGU6IHR5cGVvZiBmdW5jdGlvbnMub25DcmVhdGUgPT0gJ3VuZGVmaW5lZCcgPyBvbkNyZWF0ZSA6IGZ1bmN0aW9ucy5vbkNyZWF0ZSxcbiAgICAgICAgb25EZXN0cm95OiB0eXBlb2YgZnVuY3Rpb25zLm9uRGVzdHJveSA9PSAndW5kZWZpbmVkJyA/IG9uRGVzdHJveSA6IGZ1bmN0aW9ucy5vbkRlc3Ryb3ksXG4gICAgICAgIG9uUmVzdW1lOiB0eXBlb2YgZnVuY3Rpb25zLm9uUmVzdW1lID09ICd1bmRlZmluZWQnID8gb25SZXN1bWUgOiBmdW5jdGlvbnMub25SZXN1bWUsXG4gICAgICAgIG9uUGF1c2U6IHR5cGVvZiBmdW5jdGlvbnMub25QYXVzZSA9PSAndW5kZWZpbmVkJyA/IG9uUGF1c2UgOiBmdW5jdGlvbnMub25QYXVzZSxcbiAgICAgICAgb25TdGFydDogdHlwZW9mIGZ1bmN0aW9ucy5vblN0YXJ0ID09ICd1bmRlZmluZWQnID8gb25TdGFydCA6IGZ1bmN0aW9ucy5vblN0YXJ0LFxuICAgICAgICBvblN0b3A6IHR5cGVvZiBmdW5jdGlvbnMub25TdG9wID09ICd1bmRlZmluZWQnID8gb25TdG9wIDogZnVuY3Rpb25zLm9uU3RvcCxcbiAgICB9O1xuICAgIHJldHVybiB7XG4gICAgICAgIG1vZHVsZURhdGE6ICRkYXRhW21vZHVsZU5hbWVdLFxuICAgICAgICBtb2R1bGVFdmVudDogJGV2ZW50W21vZHVsZU5hbWVdXG4gICAgfTtcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGFuYWx5dGljcyhldmVudCA9IFwiXCIsIHByb3BlcnRpZXMgPSB7fSkge1xuICAgIGNvbnN0IHByb3BlcnRpZXNKc29uID0gSlNPTi5zdHJpbmdpZnkocHJvcGVydGllcyk7XG4gICAgY29uc29sZS5sb2coYGFuYWx5dGljcyBldmVudDogJHtldmVudH0sIHByb3BlcnRpZXNKc29uID0gJHtwcm9wZXJ0aWVzSnNvbn1gKTtcbiAgICB2YXIgbWFwID0ge1xuICAgICAgICBldmVudDogZXZlbnQsXG4gICAgICAgIHByb3BlcnRpZXM6IHByb3BlcnRpZXNKc29uXG4gICAgfTtcbiAgICBhd2FpdCAkbmF0aXZlQVBJLmFuYWx5dGljcyhtYXApO1xufVxuXG5mdW5jdGlvbiBvbkNyZWF0ZSgpIHtcbiAgICBjb25zb2xlLmxvZygnY29tbW9uIG9uQ3JlYXRlJyk7XG59XG5cbmZ1bmN0aW9uIG9uRGVzdHJveSgpIHtcbn1cblxuZnVuY3Rpb24gb25SZXN1bWUoKSB7XG59XG5cbmZ1bmN0aW9uIG9uUGF1c2UoKSB7XG59XG5cbmZ1bmN0aW9uIG9uU3RhcnQoKSB7XG59XG5cbmZ1bmN0aW9uIG9uU3RvcCgpIHtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGdldFBOR0ljb25VUkxCeUN1cnJlbmN5KGN1cnJlbmN5KSB7XG4gICAgbGV0IGJhc2VVcmwgPSBjb21tb25EYXRhLndlYlVybCA/IGNvbW1vbkRhdGEud2ViVXJsIDogXCJcIjtcbiAgICAgICAgcmV0dXJuIGAke2Jhc2VVcmx9Ly0veC9oYi9wL2FwaS9jb250ZW50cy9jdXJyZW5jeS9pY29uX3BuZy8ke2N1cnJlbmN5LnRvTG93ZXJDYXNlKCl9LnBuZ2A7XG59XG5cbiAgLy/orr7nva7pgJrnlKjphY3nva5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzZW5kQ29tbW9uQ29uZmlnKHBhcmFtKSB7XG4gIGNvbnNvbGUubG9nKGAke3RhZ30gc2VuZENvbW1vbkNvbmZpZyAke0pTT04uc3RyaW5naWZ5KHBhcmFtKX1gKTtcbiAgY29tbW9uRGF0YS5wcmljZUNvbG9yVHlwZSA9IHBhcnNlSW50KHBhcmFtLnByaWNlQ29sb3JUeXBlKTtcbiAgY29tbW9uRGF0YS5jb2xvck1vZGUgPSBwYXJzZUludChwYXJhbS5jb2xvck1vZGUpO1xuICBjb21tb25EYXRhLk9TID0gcGFyc2VJbnQocGFyYW0uT1MpO1xuICBjb21tb25EYXRhLmFwcFZlcnNpb24gPSBwYXJhbS5hcHBWZXJzaW9uO1xuICBjb21tb25EYXRhLmlzSW5SZXZpZXcgPSBwYXJzZUludChwYXJhbS5pc0luUmV2aWV3KTtcbiAgY29tbW9uRGF0YS5sYW5ndWFnZSA9IHBhcmFtLmxhbmd1YWdlO1xuICBjb21tb25EYXRhLndlYlVybCA9IHBhcmFtLndlYlVybDtcbiAgY29tbW9uRGF0YS5zdGF0dXNIZWlnaHQgPSBjb21tb25EYXRhLk9TID09IDAgPyBwYXJhbS5zdGF0dXNIZWlnaHQgOiAwOyBcbiAgdmFyIHJlZENvbG9yTGlzdCA9IFsgXCIjQURCMEIyXCIsIFwiI0U5NDM1OVwiLCBcIiNERTI5NDFcIiwgXCIjQ0UxNDJCXCIgXTtcbiAgdmFyIGdyZWVuQ29sb3JMaXN0ID0gWyBcIiNBREIwQjJcIiwgXCIjMDBBMTcxXCIsIFwiIzAwOEI2MVwiLCBcIiMwMDYyNDVcIiBdO1xuICBpZiAocGFyc2VJbnQoY29tbW9uRGF0YS5wcmljZUNvbG9yVHlwZSkgPT0gMCkge1xuICAgICAgdXBDb2xvckxpc3QgPSByZWRDb2xvckxpc3Q7XG4gICAgICBkb3duQ29sb3JMaXN0ID0gZ3JlZW5Db2xvckxpc3Q7XG4gIH0gZWxzZSB7XG4gICAgICB1cENvbG9yTGlzdCA9IGdyZWVuQ29sb3JMaXN0O1xuICAgICAgZG93bkNvbG9yTGlzdCA9IHJlZENvbG9yTGlzdDtcbiAgfVxuICAkZGF0YS5jb21tb25EYXRhID0gY29tbW9uRGF0YTtcbn1cblxuLy8kbmF0aXZlLmhvdENvaW5SYWRyQnJpZGdlXG5cbmFzeW5jIGZ1bmN0aW9uIG9wZW5VUkwodXJsLCBwYXJhbXMgPSB7fSkge1xuICBhd2FpdCAkbmF0aXZlQVBJLmhvdENvaW5SYWRyQnJpZGdlKHtcbiAgICAgIGFjdGlvbjogXCJvcGVuUGFnZVwiLFxuICAgICAgdHlwZTogXCJ1cmxcIixcbiAgICAgIHBhZ2U6IHVybCxcbiAgICAgIHBhcmFtczogSlNPTi5zdHJpbmdpZnkocGFyYW1zKVxuICB9KTtcbn1cblxuLy/lj5HpgIHor7fmsYJcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzZW5kUmVxdWVzdChwYXRoLCBwYXJhbXMgPSB7fSwgbWV0aG9kID0gMCwgaG9zdFR5cGUgPSAwLCBoZWFkZXIgPSB7fSkge1xuICBjb25zb2xlLmxvZyhgcmVxdWVzdCAke3BhdGh9LCBwYXJhbXM6JHtKU09OLnN0cmluZ2lmeShwYXJhbXMpfWApO1xuXG4gIGlmIChob3N0VHlwZSA9PSA1IHx8IGhvc3RUeXBlID09IDYpIHtcbiAgICAgIGhlYWRlcltcIkNvbnRlbnQtVHlwZVwiXSA9IFwiYXBwbGljYXRpb24vanNvblwiO1xuICB9XG5cbiAgY29uc3QgcGFyYW0gPSB7XG4gICAgICBwYXRoLFxuICAgICAgbWV0aG9kLFxuICAgICAgaG9zdFR5cGUsXG4gICAgICBoZWFkZXIsXG4gICAgICBwYXJhbXMsXG4gIH07XG4gIHRyeSB7XG4gICAgICB2YXIgcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QoSlNPTi5zdHJpbmdpZnkocGFyYW0pKTtcbiAgICAgIHZhciByZXNwb25zZSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcpO1xuICAgICAgdmFyIHsgY29kZSwgZGF0YSB9ID0gcmVzcG9uc2U7XG4gICAgICBpZiAoY29kZSA9PSAyMDApIHtcbiAgICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCAke3BhdGh9IGRvbmVgKTtcbiAgICAgICAgICByZXR1cm4gZGF0YTtcbiAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgZmFpbGVkLCBjb2RlPSR7Y29kZX1gKTtcbiAgICAgICAgICBsZXQgbWVzc2FnZSA9IHJlc3BvbnNlLm1lc3NhZ2U7XG4gICAgICAgICAgaWYgKG1ldGhvZCAhPSAwICYmIG1lc3NhZ2UpIHtcbiAgICAgICAgICAgICAgc2hvd1RvYXN0KG1lc3NhZ2UpO1xuICAgICAgICAgIH1cbiAgICAgICAgICByZXR1cm4gbnVsbDtcbiAgICAgIH1cbiAgfSBjYXRjaCAoZSkge1xuICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgZXJyb3IsIGVycm9yPSR7ZX1gKTtcbiAgICAgIHJldHVybiBudWxsO1xuICB9XG4gIFxufVxuXG4vL+agueaNrua2qOi3jOW5heiOt+WPluaYvuekuuminOiJslxuZXhwb3J0IGZ1bmN0aW9uIGdldFByaWNlQ29sb3IocmF0aW8pIHtcbiAgICBpZiAocmF0aW8gPT0gbnVsbCkge1xuICAgICAgICByYXRpbyA9IDA7XG4gICAgfVxuICAgIGNvbnN0IHJhdGlvX2FicyA9IE1hdGguYWJzKHJhdGlvKTtcbiAgICB2YXIgY29sb3JMZXZlbCA9IDA7XG4gICAgaWYgKHJhdGlvX2FicyA+IDAgJiYgcmF0aW9fYWJzIDwgMykge1xuICAgICAgICBjb2xvckxldmVsID0gMTtcbiAgICB9IGVsc2UgaWYgKHJhdGlvX2FicyA+PSAzICYmIHJhdGlvX2FicyA8IDgpIHtcbiAgICAgICAgY29sb3JMZXZlbCA9IDI7XG4gICAgfSBlbHNlIGlmIChyYXRpb19hYnMgPj0gOCkge1xuICAgICAgICBjb2xvckxldmVsID0gMztcbiAgICB9XG4gICAgdmFyIGNvbG9ySGV4U3RyID0gbnVsbDtcbiAgICBpZiAocmF0aW8gPiAwKSB7XG4gICAgICAgIGNvbG9ySGV4U3RyID0gdXBDb2xvckxpc3RbY29sb3JMZXZlbF07XG4gICAgfSBlbHNlIHtcbiAgICAgICAgY29sb3JIZXhTdHIgPSBkb3duQ29sb3JMaXN0W2NvbG9yTGV2ZWxdO1xuICAgIH1cbiAgICByZXR1cm4gY29sb3JIZXhTdHI7XG59XG5cbi8v5a655Zmo6L+U5Zue6IO95YqbXG5leHBvcnQgZnVuY3Rpb24gY29udGFpbmVyQmFjayhwYXJhbXMgPSAwKSB7XG4gICAgY29uc29sZS5sb2coXCJjb250YWluZXJCYWNrXCIpXG4gICAgJG5hdGl2ZUFQSS5jb250YWluZXJCYWNrKHBhcmFtcylcbn1cblxuLy/kv53lrZjmlbDmja5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzYXZlKG1vZHVsZSwga2V5LCBkYXRhKSB7XG4gICAgYXdhaXQgJG5hdGl2ZUFQSS5zdG9yYWdlKHtcbiAgICAgICAgYWN0aW9uOiBcInNhdmVcIixcbiAgICAgICAgbmFtZTogbW9kdWxlLFxuICAgICAgICBrZXk6IGtleSxcbiAgICAgICAgZGF0YTogSlNPTi5zdHJpbmdpZnkoZGF0YSlcbiAgICB9KTtcbn1cblxuLy/or7vlj5bmlbDmja5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiByZWFkKG1vZHVsZSwga2V5KSB7XG4gICAgY29uc3QgZGF0YSA9IGF3YWl0ICRuYXRpdmVBUEkuc3RvcmFnZSh7XG4gICAgICAgIGFjdGlvbjogXCJyZWFkXCIsXG4gICAgICAgIG5hbWU6IG1vZHVsZSxcbiAgICAgICAga2V5OiBrZXlcbiAgICB9KTtcbiAgICBpZiAoZGF0YSAmJiBkYXRhICE9IFwiXCIpIHtcbiAgICAgICAgcmV0dXJuIEpTT04ucGFyc2UoZGF0YSk7XG4gICAgfVxuICAgIHJldHVybiBudWxsO1xufVxuIiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiXG5cbi8v5a2Y5YKoYWxlcnTlvLnnqpfnmoRrZXlcbmNvbnN0IHN0b3JhZ2VNb2R1bGVOYW1lID0gJ2hvdENvaW5EZXRhaWwnXG5jb25zdCBzdG9yYWdlVnBuQWxlcnRLZXkgPSAndnBuQWxlcnRTaG93bidcbmNvbnN0IHN0b3JhZ2VQYWdlVnBuQWxlcnRLZXkgPSAncGFnZVZwbkFsZXJ0U2hvd24nXG5jb25zdCBzdG9yYWdlUGFnZUFsZXJ0S2V5ID0gJ3BhZ2VBbGVydFNob3duJ1xuY29uc3Qgc3RvcmFnZU5ld3NBbGVydEtleSA9ICduZXdzQWxlcnRTaG93bidcblxudmFyIGFsZXJ0ID0ge1xuICB2cG5BbGVydFNob3c6IGZhbHNlLFxuICBwYWdlVnBuQWxlcnRTaG93OiBmYWxzZSxcbiAgcGFnZUFsZXJ0U2hvdzogZmFsc2UsXG4gIG5ld3NBbGVydFNob3c6IGZhbHNlLFxufVxuXG52YXIgY3VycmVudE5vdE5lZWRTaG93ID0gZmFsc2VcblxudmFyIHNlbE5ld3NNb2RlID0ge31cbnZhciBzZWxEeW5hbWljTW9kZSA9IHt9XG5cbmNvbnN0IHRpcFRpdGxlID0gJGkxOG4ubl9vcHRpb25fZGVsaXZlcnlfdGlwXG5cbnZhciBoYXNEeW5hbWljID0gMFxudmFyIGhhc05ld3MgPSAwXG5cbmNvbnN0IENoYXJ0UGVyaW9kID0ge1xuICBQZXJpb2QyNDogYDI0JHskaTE4bi5uX25vdGlmaWNhdGlvbl9wdXNoX25vZGlzdHVyYl9ob3VyfWAsXG4gIFBlcmlvZDdkYXkgOiBgNyR7JGkxOG4ubl9taW5pbmdfZGF5X3RleHR9YCxcbiAgUGVyaW9kMzBkYXk6IGAzMCR7JGkxOG4ubl9taW5pbmdfZGF5X3RleHR9YCxcbiAgUGVyaW9kOTBkYXk6IGA5MCR7JGkxOG4ubl9taW5pbmdfZGF5X3RleHR9YCxcbiAgUGVyaW9kMXllYXI6IGAxJHskaTE4bi5uX2hvdGNvaW5fcmFkYXJfeWVhcn1gXG59O1xuXG5cbmNvbnN0IHNlbFNlY29uZENvbG9yID0gJ0Bjb2xvci9rQ29sb3JNYWpvclRoZW1lMTAwJ1xuY29uc3Qgc2VsU2Vjb25kQmdDb2xvciA9ICdAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTAwNidcbmNvbnN0IG5vcm1hbFNlY29uZENvbG9yID0gJ0Bjb2xvci9rQ29sb3JQcmltYXJ5VGV4dCdcbmNvbnN0IG5vcm1hbFNlY29uZEJnQ29sb3IgPSAnQGNvbG9yL0tCYXNlQ29sb3JJbnB1dEJhY2tncm91bmQnXG5cbmNvbnN0IHNlbFRpdGxlQ29sb3IgPSAnQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0J1xuY29uc3Qgbm9ybWFsVGl0bGVDb2xvciA9ICdAY29sb3Iva0NvbG9yVGhyZWVMZXZlbFRleHQnXG5cbmNvbnN0IHNob3dTb3VyY2VUaXRsZSA9ICRpMThuLm5fY29udGVudF90cmFuc2xhdGVfc2hvd19vcmlnaW5hbHRleHRcbmNvbnN0IHNob3dDb250ZW50VGl0bGUgPSAkaTE4bi5uX2NvbnRlbnRfdHJhbnNsYXRlXG5cbnZhciBjb2luTmV3UGFnZU5vID0gMVxudmFyIGNvaW5EeW5hbWljSG90UGFnZU5vID0gMVxudmFyIGNvaW5EeW5hbWljTGFzdFBhZ2VObyA9IDFcblxuXG52YXIgc2VsUGVyaW9kSW5kZXggPSAwOy8v6K6w5b2V6YCJ5Lit55qE5ZGo5pyfXG52YXIgc2VsQ2hhcnRJbmRleCA9IDA7Ly/orrDlvZXlm77ooajpgInkuK3nmoTnrZvpgInmnaHku7YgMD3ku7fmoLzvvIwxPeS6kuWKqO+8jDI95o+Q5Y+K77yMMz3npL7lqpLvvIw0Peeci+a2qFxudmFyIHNlbFBvc3RJbmRleCA9IDA7Ly/orrDlvZXluJblrZDnrZvpgInntKLlvJVcbnZhciBzZWxMaXN0SW5kZXggPSAwOyAvLzDnsr7pgInjgIEx5paw6Ze7XG5cbnZhciBjb2luTmV3c0FycmF5ID0gW10gLy/mlrDpl7vliJfooahcbnZhciBjb2luRHluYW1pY0hvdEFycmF5ID0gW10gLy/mjqjojZDliJfooahcbnZhciBjb2luRHluYW1pY0xhc3RBcnJheSA9IFtdIC8v5o6o6I2Q5pyA5pawXG5cbnZhciB0aW1lcklkID0gMDtcbnZhciBsYXN0UG9pbnRMaXN0SnNvbiA9IFwiXCIvL+iusOW9leS4iuasoeWbvuihqOaVsOaNrlxuXG4vL+WIneWni+WMllxuYXN5bmMgZnVuY3Rpb24gc3RhcnQoKSB7XG5cbiBcbiAgcGxheUxvdHRpZSgpO1xuXG4gIGNvbmZpZ0RhdGEoKTtcbiAgYXdhaXQgcmVxdWVzdERldGFpbEluZm8oKTsvL+ivt+axguivpuaDhemhtemhtumDqOaVsOaNrndvXG4gIGNvaW5EeW5hbWljSG90QXJyYXk9IGF3YWl0IHJlcXVlc3RQb3N0TGlzdERhdGEoKTsvL+ivt+axguW4luWtkOWIl+ihqFxuICBjb2luTmV3c0FycmF5ID0gYXdhaXQgcmVxdWVzdENvaW5OZXdzKCk7Ly/or7fmsYLmlrDpl7vliJfooahcblxuICBzdG9wTG90dGllKCk7XG4gXG5cbiAgaWYgKGhhc0R5bmFtaWMgPT0gMSkge1xuICAgIG1vZHVsZURhdGEubGlzdFRpdGxlcy5lbGl0ZVBvc3RzVGl0bGVWaXNpYmlsaXR5ID0gJ3Zpc2libGUnXG4gICAgbW9kdWxlRGF0YS5saXN0VGl0bGVzLmVsaXRlUG9zdHNUaXRsZUNvbG9yID0gc2VsVGl0bGVDb2xvclxuICAgIG1vZHVsZURhdGEubGlzdCA9IGNvaW5EeW5hbWljSG90QXJyYXlcbiAgfSBlbHNlIHtcbiAgICBtb2R1bGVEYXRhLmxpc3RUaXRsZXMuZWxpdGVQb3N0c1RpdGxlVmlzaWJpbGl0eSA9ICdnb25lJ1xuICAgIG1vZHVsZURhdGEubGlzdFRpdGxlcy5maWx0ZXJCdXR0b25WaXNpYmlsaXR5ID0gJ2dvbmUnXG4gICAgbW9kdWxlRGF0YS5saXN0VGl0bGVzLmVsaXRlUG9zdHNUaXRsZUNvbG9yID0gbm9ybWFsVGl0bGVDb2xvclxuICB9XG5cbiAgaWYgKGhhc05ld3MgPT0gMSkge1xuICAgIG1vZHVsZURhdGEubGlzdFRpdGxlcy5uZXdzVGl0bGVUaXRsZVZpc2liaWxpdHkgPSAndmlzaWJsZSdcbiAgICBpZiAoaGFzRHluYW1pYyA9PSAxKSB7XG4gICAgICBtb2R1bGVEYXRhLmxpc3RUaXRsZXMubmV3c1RpdGxlVGl0bGVWaXNpYmlsaXR5ID0gbm9ybWFsVGl0bGVDb2xvclxuICAgIH0gZWxzZSB7XG4gICAgICBtb2R1bGVEYXRhLmxpc3RUaXRsZXMubmV3c1RpdGxlQ29sb3IgPSBzZWxUaXRsZUNvbG9yXG4gICAgICBzZWxMaXN0SW5kZXggPSAxXG4gICAgICBtb2R1bGVEYXRhLmxpc3QgPSBjb2luTmV3c0FycmF5XG4gICAgfVxuICB9IGVsc2Uge1xuICAgIG1vZHVsZURhdGEubGlzdFRpdGxlcy5uZXdzVGl0bGVUaXRsZVZpc2liaWxpdHkgPSAnZ29uZSdcbiAgfVxufVxuXG5mdW5jdGlvbiBwbGF5TG90dGllKCkge1xuICBtb2R1bGVEYXRhLnBhZ2VWaXNpYmlsaXR5Q29uaWcubGlzdFZpc2liaWxpdHkgPSAnZ29uZSdcbiAgbW9kdWxlRGF0YS5wYWdlVmlzaWJpbGl0eUNvbmlnLmxvYWRpbmdWaXNpYmlsaXR5ID0gJ3Zpc2libGUnXG4gIG1vZHVsZURhdGEubG9hZGluZ0xvdHRpZVN0YXR1cyA9J3BsYXknXG59XG5cbmZ1bmN0aW9uIHN0b3BMb3R0aWUoKSB7XG4gIG1vZHVsZURhdGEucGFnZVZpc2liaWxpdHlDb25pZy5saXN0VmlzaWJpbGl0eSA9ICd2aXNpYmxlJ1xuICBtb2R1bGVEYXRhLnBhZ2VWaXNpYmlsaXR5Q29uaWcubG9hZGluZ1Zpc2liaWxpdHkgPSAnZ29uZSdcbiAgbW9kdWxlRGF0YS5sb2FkaW5nTG90dGllU3RhdHVzID0nc3RvcCdcbn1cblxuZnVuY3Rpb24gZGVmYXVsdERhdGEoKSB7XG4gIHJldHVybiB7XG4gICAgbGlzdDpbXSxcbiAgICByZWZyZXNoU3RhdHVzOiAwLFxuICAgIGxvYWRNb3JlU3RhdHVzOiAwLFxuICAgIHBlcmlvZEluZGV4IDogMCwvL+m7mOiupOWRqOacn+aYrzI0aFxuICAgIGNvaW4gOiAnLS0nLFxuICAgIGNvaW5QcmljZSA6ICctLScsXG4gICAgY29pblByaWNlUmFuZ2UgOiAnLS0nLFxuICAgIGNvaW5QcmljZVJhbmdlVGV4dENvbG9yOiBcIkBjb2xvci9rQ29sb3JTZWNvbmRhcnlCdXR0b25UZXh0XCIsXG4gICAgbWFya2V0U2VudGltZW50OiB7XG4gICAgICB0aXRsZTogJGkxOG4ubl9ob3Rjb2luX3JhZGFyX21hcmtldF9zZW50aW1lbnQsXG4gICAgICBidWxsaXNoVGl0bGU6Jy0tJywgLy/mtqhcbiAgICAgIGJ1bGxpc2hDb2xvcjonJyxcbiAgICAgIGJ1bGxpc2hWYWx1ZTonMC41JyxcbiAgICAgIGJ1bGxpc2hJbWFnZVZpc2liaWxpdHk6J3Zpc2libGUnLFxuICAgICAgYmVhcmlzaFRpdGxlOictLScsIC8v6LeMXG4gICAgICBiZWFyaXNoQ29sb3I6JycsXG4gICAgICBiZWFyaXNoVmFsdWU6JzAuNScsXG4gICAgICBiZWFyaXNoSW1hZ2VWaXNpYmlsaXR5Oid2aXNpYmxlJ1xuICAgIH0sXG4gICAgbGlzdFRpdGxlczoge1xuICAgICAgZWxpdGVQb3N0c1RpdGxlOiRpMThuLm5faG90Y29pbl9yYWRhcl9zZWxlY3RlZCxcbiAgICAgIGVsaXRlUG9zdHNUaXRsZUNvbG9yOiBzZWxUaXRsZUNvbG9yLFxuICAgICAgZWxpdGVQb3N0c1RpdGxlVmlzaWJpbGl0eTogJ3Zpc2libGUnLFxuICAgICAgbmV3c1RpdGxlOiRpMThuLm5faG90Y29pbl9yYWRhcl9uZXdzLFxuICAgICAgbmV3c1RpdGxlQ29sb3I6IG5vcm1hbFRpdGxlQ29sb3IsXG4gICAgICBuZXdzVGl0bGVUaXRsZVZpc2liaWxpdHk6ICd2aXNpYmxlJyxcbiAgICAgIGhvdFRpdGxlOiRpMThuLm5fY29tbXVuaXR5X2hvdCxcbiAgICAgIGhvdFRpdGxlQ29sb3I6IHNlbFNlY29uZENvbG9yLFxuICAgICAgaG90VGl0bGVCYWNrZ3JvdW5kQ29sb3I6IHNlbFNlY29uZEJnQ29sb3IsXG4gICAgICBsYXN0VGl0bGU6JGkxOG4ubl9ob21lX2ZlZWRfdGFiX25ld3MsXG4gICAgICBsYXN0VGl0bGVDb2xvcjogbm9ybWFsU2Vjb25kQ29sb3IsXG4gICAgICBsYXN0VGl0bGVCYWNrZ3JvdW5kQ29sb3I6IG5vcm1hbFNlY29uZEJnQ29sb3IsXG4gICAgICBmaWx0ZXJCdXR0b25WaXNpYmlsaXR5Oid2aXNpYmxlJ1xuICAgIH0sXG4gICAgaXRlbVRpdGxlOiB7XG4gICAgICBzb3VyY2VUaXRsZTonJyxcbiAgICAgIGludGVyYWN0aW9uc1RpdGxlOiRpMThuLm5faG90Y29pbl9yYWRhcl9udW1iZXJfaW50ZXJhY3Rpb24sXG4gICAgfSxcbiAgICB0cmFkZVRpdGxlOiAkaTE4bi5uX25ld191c2VyX2d1aWRlX3RyYWRlLFxuICAgIHRvcENoYXJ0UG9wTGlzdDogW1xuICAgICAge1xuICAgICAgICBcInR5cGVcIjogXCIxXCIsXG4gICAgICAgIFwidGl0bGVcIjogJGkxOG4ubl9zcG90X29yZGVyX3ByaWNlLFxuICAgICAgICBcImluZGV4XCI6IFwiMFwiLFxuICAgICAgICBcInRleHRDb2xvclwiOiBcIkBjb2xvci9rQ29sb3JTZWNvbmRhcnlCdXR0b25UZXh0XCIsXG4gICAgICAgIFwic2VsSW1hZ2VWaXNpYmlsaXR5XCI6IFwidmlzaWJsZVwiLFxuICAgICAgICBcInNlbGVjdGVkXCI6IFwidHJ1ZVwiXG4gICAgIH0sXG4gICAgIHtcbiAgICAgICAgXCJ0eXBlXCI6IFwiMVwiLFxuICAgICAgICBcInRpdGxlXCI6ICRpMThuLm5faG90Y29pbl9yYWRhcl9udW1iZXJfaW50ZXJhY3Rpb24sXG4gICAgICAgIFwiaW5kZXhcIjogXCIxXCIsXG4gICAgICAgIFwidGV4dENvbG9yXCI6IFwiQGNvbG9yL2tDb2xvclNlY29uZGFyeUJ1dHRvblRleHRcIixcbiAgICAgICAgXCJzZWxJbWFnZVZpc2liaWxpdHlcIjogXCJnb25lXCIsXG4gICAgICAgIFwic2VsZWN0ZWRcIjogXCJmYWxzZVwiXG4gICAgICB9LFxuICAgICAge1xuICAgICAgICBcInR5cGVcIjogXCIxXCIsXG4gICAgICAgIFwidGl0bGVcIjogJGkxOG4ubl9ob3Rjb2luX3JhZGFyX251bWJlcl9tZW50aW9ucyxcbiAgICAgICAgXCJpbmRleFwiOiBcIjJcIixcbiAgICAgICAgXCJ0ZXh0Q29sb3JcIjogXCJAY29sb3Iva0NvbG9yU2Vjb25kYXJ5QnV0dG9uVGV4dFwiLFxuICAgICAgICBcInNlbEltYWdlVmlzaWJpbGl0eVwiOiBcImdvbmVcIixcbiAgICAgICAgXCJzZWxlY3RlZFwiOiBcImZhbHNlXCJcbiAgICAgIH0sXG4gICAgICB7XG4gICAgICAgIFwidHlwZVwiOiBcIjFcIixcbiAgICAgICAgXCJ0aXRsZVwiOiAkaTE4bi5uX2hvdGNvaW5fcmFkYXJfcnVsaW5nX3JhdGUsXG4gICAgICAgIFwiaW5kZXhcIjogXCIzXCIsXG4gICAgICAgIFwidGV4dENvbG9yXCI6IFwiQGNvbG9yL2tDb2xvclNlY29uZGFyeUJ1dHRvblRleHRcIixcbiAgICAgICAgXCJzZWxJbWFnZVZpc2liaWxpdHlcIjogXCJnb25lXCIsXG4gICAgICAgIFwic2VsZWN0ZWRcIjogXCJmYWxzZVwiXG4gICAgICB9LFxuICAgICAge1xuICAgICAgICBcInR5cGVcIjogXCIxXCIsXG4gICAgICAgIFwidGl0bGVcIjogJGkxOG4ubl9ob3Rjb2luX3JhZGFyX2J1bGxpc2hfc2VudGltZW50LFxuICAgICAgICBcImluZGV4XCI6IFwiNFwiLFxuICAgICAgICBcInRleHRDb2xvclwiOiBcIkBjb2xvci9rQ29sb3JTZWNvbmRhcnlCdXR0b25UZXh0XCIsXG4gICAgICAgIFwic2VsSW1hZ2VWaXNpYmlsaXR5XCI6IFwiZ29uZVwiLFxuICAgICAgICBcInNlbGVjdGVkXCI6IFwiZmFsc2VcIlxuICAgICAgfSxcbiAgICBdLFxuICAgIHBvaW50TGlzdEpzb246JycsXG4gICAgdGlwQWxlcnRUaXRsZTogJycsLy/pu5jorqTmlofmoYggPSDmj5DnpLrvvIzmoLnmja7pnIDopoHlho3lvLnlh7rliY3orr7nva7mlofmoYhcbiAgICB0aXBBbGVydENvbnRlbnQ6ICcnLC8v5by55qGG5YaF5a65XG4gICAgcGVyaW9kTGlzdDpbXG4gICAgICB7XG4gICAgICAgICAgXCJ0eXBlXCI6IFwiMVwiLFxuICAgICAgICAgIFwidGV4dFwiOkNoYXJ0UGVyaW9kLlBlcmlvZDI0LFxuICAgICAgICAgIFwidGV4dENvbG9yXCI6XCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiLFxuICAgICAgICAgIFwidGV4dEZvbnRXZWlnaHRcIjpcIjQwMFwiLFxuICAgICAgICAgIFwiYmFja2dyb3VuZENvbG9yXCI6XCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTAwNlwiLFxuICAgICAgICAgIFwiaW5kZXhcIjpcIjBcIlxuICAgICAgfSxcbiAgICAgIHtcbiAgICAgICAgICBcInR5cGVcIjogXCIxXCIsXG4gICAgICAgICAgXCJ0ZXh0XCI6Q2hhcnRQZXJpb2QuUGVyaW9kN2RheSxcbiAgICAgICAgICBcInRleHRDb2xvclwiOlwiQGNvbG9yL2tDb2xvclNlY29uZGFyeVRleHRcIixcbiAgICAgICAgICBcImJhY2tncm91bmRDb2xvclwiOlwiQGNvbG9yL0tCYXNlQ29sb3JDb250ZW50QmFja2dyb3VuZFwiLFxuICAgICAgICAgIFwiaW5kZXhcIjpcIjFcIlxuICAgICAgfSxcbiAgICAgIHtcbiAgICAgICAgICBcInR5cGVcIjogXCIxXCIsXG4gICAgICAgICAgXCJ0ZXh0XCI6Q2hhcnRQZXJpb2QuUGVyaW9kMzBkYXksXG4gICAgICAgICAgXCJ0ZXh0Q29sb3JcIjpcIkBjb2xvci9rQ29sb3JTZWNvbmRhcnlUZXh0XCIsXG4gICAgICAgICAgXCJiYWNrZ3JvdW5kQ29sb3JcIjpcIkBjb2xvci9LQmFzZUNvbG9yQ29udGVudEJhY2tncm91bmRcIixcbiAgICAgICAgICBcImluZGV4XCI6XCIyXCJcbiAgICAgIH0sXG4gICAgICB7XG4gICAgICAgICAgXCJ0eXBlXCI6IFwiMVwiLFxuICAgICAgICAgIFwidGV4dFwiOkNoYXJ0UGVyaW9kLlBlcmlvZDkwZGF5LFxuICAgICAgICAgIFwidGV4dENvbG9yXCI6XCJAY29sb3Iva0NvbG9yU2Vjb25kYXJ5VGV4dFwiLFxuICAgICAgICAgIFwiYmFja2dyb3VuZENvbG9yXCI6XCJAY29sbyNyL0tCYXNlQ29sb3JDb250ZW50QmFja2dyb3VuZFwiLFxuICAgICAgICAgIFwiaW5kZXhcIjpcIjNcIlxuICAgICAgfSxcbiAgICAgIHtcbiAgICAgICAgICBcInR5cGVcIjogXCIxXCIsXG4gICAgICAgICAgXCJ0ZXh0XCI6Q2hhcnRQZXJpb2QuUGVyaW9kMXllYXIsXG4gICAgICAgICAgXCJ0ZXh0Q29sb3JcIjpcIkBjb2xvci9rQ29sb3JTZWNvbmRhcnlUZXh0XCIsXG4gICAgICAgICAgXCJiYWNrZ3JvdW5kQ29sb3JcIjpcIkBjb2xvci9LQmFzZUNvbG9yQ29udGVudEJhY2tncm91bmRcIixcbiAgICAgICAgICBcImluZGV4XCI6XCI0XCJcbiAgICAgIH1dLFxuICAgICAgY2hhcnRTZWxlY3RvclRpdGxlOiAkaTE4bi5uX3Nwb3Rfb3JkZXJfcHJpY2UsXG4gICAgICB0b3BJY29uOlwiXCIsXG4gICAgICB0b3BUaXRsZTpcIlwiLFxuICAgICAgc3ltYm9sOlwiXCIsXG4gICAgICBwbGFjZWhvbGRlcjoge1xuICAgICAgICBvbmU6ICdAZHJhd2FibGUvaG90Y29pbl9yYWRhcl9keW5hbWljX3BsYWNlaG9sZGVyXzM0MycsXG4gICAgICAgIGxlZnQ6ICdAZHJhd2FibGUvaG90Y29pbl9yYWRhcl9keW5hbWljX3BsYWNlaG9sZGVyXzE3MCcsXG4gICAgICAgIHNtYWxsOiAnQGRyYXdhYmxlL2hvdGNvaW5fcmFkYXJfZHluYW1pY19wbGFjZWhvbGRlcl8xMDgnXG4gICAgICB9LFxuICAgICAgcGFnZVZpc2liaWxpdHlDb25pZzoge1xuICAgICAgICBsaXN0VmlzaWJpbGl0eTonZ29uZScsXG4gICAgICAgIGxvYWRpbmdWaXNpYmlsaXR5OiAndmlzaWJsZSdcbiAgICAgIH0sXG4gICAgICBsb2FkaW5nTG90dGllU3RhdHVzOiAncGxheSdcbiAgfVxufVxuXG5jb25zdCB7IG1vZHVsZURhdGEsIG1vZHVsZUV2ZW50IH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFwiZGV0YWlsXCIsIGRlZmF1bHREYXRhLCB7IG9uQ3JlYXRlLCBvblJlc3VtZSwgb25TdG9wIH0pO1xuXG5hc3luYyBmdW5jdGlvbiBvbkNyZWF0ZShqc29uUGFyYW1ldGVycykge1xuICAvL+eKtuaAgeagj+iuvue9rlxuICBtb2R1bGVEYXRhLnN0YXR1c0JhckNvbmZpZyA9IHsgXCJzdGF0dXNCYXJNb2RlXCI6IFwidHJ1ZVwiLCBcImFkU3RhdHVzQmFyQ29sb3JcIjogXCJrQ29sb3JDb250ZW50QmFja2dyb3VuZFwifTtcbiAgLy/luKblhaXlj4LmlbBcbiAgcGFyYW1ldGVyID0gSlNPTi5wYXJzZShqc29uUGFyYW1ldGVycyk7XG5cbiAgY29uc29sZS5sb2coYCR7Y29tbW9uLnRhZ30gb25DcmVhdGUgJHtKU09OLnN0cmluZ2lmeShwYXJhbWV0ZXIpfWApXG4gIC8v6K6+572u6aG26YOoaWNvblxuICBtb2R1bGVEYXRhLnRvcEljb24gPSBjb21tb24uZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3kocGFyYW1ldGVyLmNvaW4pO1xuICBtb2R1bGVEYXRhLnRvcFRpdGxlID0gYCR7cGFyYW1ldGVyLmNvaW59YDtcbiAgbW9kdWxlRGF0YS50cmFkZU1hcmdpbkJvdHRvbSA9IGNvbW1vbi5jb21tb25EYXRhLk9TID09IDAgPyBcIjM2XCIgOiBcIjBcIiwvL+mAgumFjWlvc+S4reS6pOaYk+i3neemu+W6lemDqOi3neemu1xuICBzdGFydCgpXG4gIHZhciBwcm9wZXJ0aWVzID0ge1xuICAgIHBhZ2U6J1JlY29tQ29pbkRldGFpbCcsXG4gIH1cbiAgY29uc3QgcHJvcGVydGllc0pzb24gPSBKU09OLnN0cmluZ2lmeShwcm9wZXJ0aWVzKTtcbiAgdmFyIG1hcCA9IHtldmVudDogJ3BhZ2VWSWV3Jyxwcm9wZXJ0aWVzOnByb3BlcnRpZXNKc29ufTtcbiAgYXdhaXQgJG5hdGl2ZUFQSS5hbmFseXRpY3MobWFwKTtcbn1cblxuZnVuY3Rpb24gY29uZmlnRGF0YSgpIHtcbiAgaWYgKGNvbW1vbi5jb21tb25EYXRhLnByaWNlQ29sb3JUeXBlID09IDApIHtcbiAgICBtb2R1bGVEYXRhLm1hcmtldFNlbnRpbWVudC5idWxsaXNoQ29sb3IgPSAnI0Y5NUE1MCdcbiAgICBtb2R1bGVEYXRhLm1hcmtldFNlbnRpbWVudC5iZWFyaXNoQ29sb3IgPSAnIzAwQTE3MSdcbiAgfSBlbHNlIHtcbiAgICBtb2R1bGVEYXRhLm1hcmtldFNlbnRpbWVudC5idWxsaXNoQ29sb3IgPSAnIzAwQTE3MSdcbiAgICBtb2R1bGVEYXRhLm1hcmtldFNlbnRpbWVudC5iZWFyaXNoQ29sb3IgPSAnI0Y5NUE1MCdcbiAgfVxufVxuXG5mdW5jdGlvbiBjb25maWdUaXBBbGVydFRpdGxlICh0aXRsZSA9ICRpMThuLm5fY29weV90cmFkaW5nX3RpcCwgY29udGVudCA9ICcnLCBidXR0b25UeXBlID0gMCxub1JlbWluZGVyU2hvdyA9ICdnb25lJykge1xuICBjdXJyZW50Tm90TmVlZFNob3cgPSBmYWxzZVxuICBtb2R1bGVEYXRhLnRpcEFsZXJ0VGl0bGUgPSB0aXRsZTtcbiAgbW9kdWxlRGF0YS50aXBBbGVydENvbnRlbnQgPSBjb250ZW50O1xuICBpZiAoYnV0dG9uVHlwZSA9PSAwKSB7Ly/nn6XpgZPkuoZcbiAgICBtb2R1bGVEYXRhLnNob3dDb250aW51ZSA9ICdnb25lJztcbiAgICBtb2R1bGVEYXRhLnNob3dJS25vdyA9ICd2aXNpYmxlJztcbiAgfSAgZWxzZSBpZiAoYnV0dG9uVHlwZSA9PSAxKSB7Ly/lj5bmtogr57un57utXG4gICAgbW9kdWxlRGF0YS5zaG93Q29udGludWUgPSAndmlzaWJsZSc7XG4gICAgbW9kdWxlRGF0YS5zaG93SUtub3cgPSAnZ29uZSc7XG4gIH1cbiAgbW9kdWxlRGF0YS5ub1JlbWluZGVyU2hvdyA9IG5vUmVtaW5kZXJTaG93Oy8v5LiN5Zyo5o+Q6YaS5aSN6YCJ5qGG5piv5ZCm5bGV56S6XG4gIG1vZHVsZURhdGEubm9SZW1pbmRlckltYWdlID0gJ0BkcmF3YWJsZS9jb21tb25fY2hlY2tfdW5zZWxlY3RlZCdcbn1cblxuLy8v6K+35rGC57K+6YCJ5biW5a2Q5YiX6KGo5pWw5o2uXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0UG9zdExpc3REYXRhKCkge1xuICAgIC8qdHlwZVx0c3RyaW5nXHQgaG905pyA54Ot77yMNGjlm5vlsI/ml7bng63luqbpo5nljYfjgIEyNGjkuozljYHlm5vlsI/ml7bng63luqbpo5nljYcqL1xuICB2YXIgcGFyYW1zID0ge31cbiAgcGFyYW1zLnR5cGUgPSAnaG90JztcbiAgcGFyYW1zLmNvaW4gPSBtb2R1bGVEYXRhLnRvcFRpdGxlO1xuICBpZiAoc2VsUG9zdEluZGV4ID09IDEpIHtcbiAgICBwYXJhbXMudHlwZSA9ICdsYXN0JztcbiAgICBwYXJhbXMucGFnZU5vID0gY29pbkR5bmFtaWNMYXN0UGFnZU5vXG4gIH0gZWxzZSB7XG4gICAgcGFyYW1zLnR5cGUgPSAnaG90JztcbiAgICBwYXJhbXMucGFnZU5vID0gY29pbkR5bmFtaWNIb3RQYWdlTm9cbiAgfVxuXG4gIHBhcmFtcy5wYWdlU2l6ZSA9IDEwO1xuXG4gIGNvbnNvbGUubG9nKGByZXF1ZXN0UG9zdExpc3REYXRhLnBhcmFtcz0ke3BhcmFtcy50b1N0cmluZygpfWApO1xuICB2YXIgZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdChcInYxL2NvbnRlbnQvY29tbXVuaXR5L3Rva2VuLWRpc2Nlcm4vY29pbi1keW5hbWljXCIsIHBhcmFtcyk7XG4gIGNvbnNvbGUubG9nKGByZXF1ZXN0UG9zdExpc3REYXRhLnBhcmFtcz0ke0pTT04uc3RyaW5naWZ5KGRhdGEpfWApO1xuICB0cnkge1xuICAgIGlmICghZGF0YSB8fCBkYXRhID09IG51bGwgfHwgIWRhdGEubGlzdERhdGEgfHwgZGF0YS5saXN0RGF0YSA9PSBudWxsIHx8IGRhdGEubGlzdERhdGEubGVuZ3RoID09IDApIHtcbiAgICAgIHJldHVyblxuICAgIH1cbiAgICB2YXIgZGF0YUFyciA9IGF3YWl0IGhhbmRsZUVsaXRlUG9zdHMoZGF0YS5saXN0RGF0YSlcbiAgICBpZiAoc2VsUG9zdEluZGV4ID09IDEpIHtcbiAgICAgIGNvaW5EeW5hbWljTGFzdFBhZ2VObysrXG4gICAgfSBlbHNlIHtcbiAgICAgIGNvaW5EeW5hbWljSG90UGFnZU5vKytcbiAgICB9XG4gICAgcmV0dXJuIGRhdGFBcnJcbiAgfSBjYXRjaCAoZSkge1xuICAgIGNvbnNvbGUubG9nKGBoYW5kbGUgY291cG9uTGlzdCAgZXJyb3I9JHtlfWApO1xuICB9XG59XG5cbi8vL+ivt+axguW4geenjeS/oeaBryvlm77ooajmlbDmja5cbmFzeW5jIGZ1bmN0aW9uIHJlcXVlc3REZXRhaWxJbmZvKCkge1xuICAvKlxuICBrbGluZVR5cGVMaXN0OiAx5Lu35qC877yMMuS6kuWKqOasoeaVsO+8jDPmj5Dlj4rmrKHmlbDvvIw057uf5rK7546H77yMNeeci+a2qOaDhee7qlxuICBwZXJpb2Q6IDI0aO+8jDdk77yMMzBk77yMOTBk77yMMXlcbiAgKi9cbiAgdmFyIHBhcmFtcyA9IHt9XG4gIHBhcmFtcy5jb2luID0gbW9kdWxlRGF0YS50b3BUaXRsZTtcbiAgcGFyYW1zLmtsaW5lVHlwZUxpc3QgPSBzZWxDaGFydEluZGV4ICsgMTtcbiAgcGFyYW1zLnBlcmlvZCA9IGdldFBlcmlvZFN0cmluZygpO1xuICBjb25zb2xlLmxvZyhgcmVxdWVzdERldGFpbEluZm8ucGFyYW1zPSR7SlNPTi5zdHJpbmdpZnkocGFyYW1zKX1gKTtcbiAgc2hvd0xvYWRpbmcodHJ1ZSk7XG4gIHZhciBkYXRhID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KFwidjEvY29udGVudC9jb21tdW5pdHkvdG9rZW4tZGlzY2Vybi9jb2luLWluZm9cIiwgcGFyYW1zKTtcbiAgc2hvd0xvYWRpbmcoZmFsc2UpO1xuICBjb25zb2xlLmxvZyhgcmVxdWVzdERldGFpbEluZm8ucGFyYW1zPSR7SlNPTi5zdHJpbmdpZnkoZGF0YSl9YCk7XG4gIHRyeSB7XG4gICAgaWYgKCFkYXRhIHx8IGRhdGEgPT0gbnVsbCkge1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIGhhbmRsZURldGFpbEluZm8oZGF0YSk7XG4gIH0gY2F0Y2ggKGUpIHtcbiAgICBjb25zb2xlLmxvZyhgcmVxdWVzdERldGFpbEluZm8gIGVycm9yPSR7ZX1gKTtcbiAgfVxufVxuXG5tb2R1bGVFdmVudC5vblJlZnJlc2ggPSBhc3luYyBmdW5jdGlvbigpIHtcbiAgaWYgKHNlbExpc3RJbmRleCA9PSAxKSB7XG4gICAgLy/mlrDpl7tcbiAgICBjb2luTmV3UGFnZU5vID0gMVxuICAgIGNvaW5OZXdzQXJyYXkgPSBhd2FpdCByZXF1ZXN0Q29pbk5ld3MoKVxuICAgIG1vZHVsZURhdGEubGlzdCA9IGNvaW5OZXdzQXJyYXlcbiAgfSBlbHNlIHtcbiAgICAvL+eyvumAiVxuICAgIGlmIChzZWxQb3N0SW5kZXggPT0gMSkge1xuICAgICAgLy/mnIDmlrBcbiAgICAgIGNvaW5EeW5hbWljTGFzdFBhZ2VObyA9IDFcbiAgICAgIGNvaW5EeW5hbWljTGFzdEFycmF5ID0gYXdhaXQgcmVxdWVzdFBvc3RMaXN0RGF0YSgpXG4gICAgICBtb2R1bGVEYXRhLmxpc3QgPSBjb2luRHluYW1pY0xhc3RBcnJheVxuICAgIH0gZWxzZSB7XG4gICAgICAvL+acgOeDrVxuICAgICAgY29pbkR5bmFtaWNIb3RQYWdlTm8gPSAxXG4gICAgICBjb2luRHluYW1pY0hvdEFycmF5ID0gYXdhaXQgcmVxdWVzdFBvc3RMaXN0RGF0YSgpXG4gICAgICBtb2R1bGVEYXRhLmxpc3QgPSBjb2luRHluYW1pY0hvdEFycmF5XG4gICAgfVxuICB9XG4gIG1vZHVsZURhdGEucmVmcmVzaFN0YXR1cyA9IDJcbn1cblxubW9kdWxlRXZlbnQub25Mb2FkTW9yZSA9IGFzeW5jIGZ1bmN0aW9uKCkge1xuICBpZiAoc2VsTGlzdEluZGV4ID09IDEpIHtcbiAgICAvL+aWsOmXu1xuICAgIGNvbnN0IGFyciA9IGF3YWl0IHJlcXVlc3RDb2luTmV3cygpXG4gICAgaWYgKGFyciAmJiBhcnIubGVuZ3RoID4gMCkge1xuICAgICAgY29pbk5ld3NBcnJheS5wdXNoKC4uLmFycilcbiAgICAgIGFyci5mb3JFYWNoKGVsZW1lbnQgPT4ge1xuICAgICAgICBtb2R1bGVEYXRhLmxpc3QucHVzaChlbGVtZW50KVxuICAgICAgfSlcbiAgICB9XG4gIH0gZWxzZSB7XG4gICAgLy/nsr7pgIlcbiAgICBpZiAoc2VsUG9zdEluZGV4ID09IDEpIHtcbiAgICAgIGNvbnN0IGFyciA9IGF3YWl0IHJlcXVlc3RQb3N0TGlzdERhdGEoKVxuICAgICAgaWYgKGFyciAmJiBhcnIubGVuZ3RoID4gMCkge1xuICAgICAgICBjb2luRHluYW1pY0xhc3RBcnJheS5wdXNoKC4uLmFycilcbiAgICAgICAgYXJyLmZvckVhY2goZWxlbWVudCA9PiB7XG4gICAgICAgICAgbW9kdWxlRGF0YS5saXN0LnB1c2goZWxlbWVudClcbiAgICAgICAgfSlcbiAgICAgIH1cbiAgICB9IGVsc2Uge1xuICAgICAgLy/mnIDng61cbiAgICAgIGNvbnN0IGFyciA9IGF3YWl0IHJlcXVlc3RQb3N0TGlzdERhdGEoKVxuICAgICAgaWYgKGFyciAmJiBhcnIubGVuZ3RoID4gMCkge1xuICAgICAgICBjb2luRHluYW1pY0hvdEFycmF5LnB1c2goLi4uYXJyKVxuICAgICAgICBhcnIuZm9yRWFjaChlbGVtZW50ID0+IHtcbiAgICAgICAgICBtb2R1bGVEYXRhLmxpc3QucHVzaChlbGVtZW50KVxuICAgICAgICB9KVxuICAgICAgfVxuICAgIH1cbiAgfVxuICBtb2R1bGVEYXRhLmxvYWRNb3JlU3RhdHVzID0gMlxufVxuXG5tb2R1bGVFdmVudC50cmFkZUFjdGlvbiA9IGFzeW5jIGZ1bmN0aW9uKCkge1xuICAkbmF0aXZlQVBJLm9wZW5Sb3V0ZShgaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTAmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS90cmFkZS9pbmRleD90eXBlPXBybyZzeW1ib2w9JHttb2R1bGVEYXRhLnN5bWJvbH1gKTtcbiAgdmFyIHByb3BlcnRpZXMgPSB7XG4gICAgbW9kdWxlX25hbWU6J2dvVHJhZGUnLFxuICB9XG4gIGNvbnN0IHByb3BlcnRpZXNKc29uID0gSlNPTi5zdHJpbmdpZnkocHJvcGVydGllcyk7XG4gIHZhciBtYXAgPSB7XG4gICAgZXZlbnQ6ICdhcHBDbGlja19PcHBvcnVuaXR5JyxcbiAgICBwcm9wZXJ0aWVzOiBwcm9wZXJ0aWVzSnNvblxuICB9XG4gIGF3YWl0ICRuYXRpdmVBUEkuYW5hbHl0aWNzKG1hcCk7XG59XG5cbi8v5pyA54OtXG5tb2R1bGVFdmVudC5zZWxlY3RlZEhvdEFjdGlvbiA9IGFzeW5jIGZ1bmN0aW9uKCkge1xuICBzZWxQb3N0SW5kZXggPSAwXG4gIG1vZHVsZURhdGEubGlzdFRpdGxlcy5ob3RUaXRsZUNvbG9yID0gc2VsU2Vjb25kQ29sb3JcbiAgbW9kdWxlRGF0YS5saXN0VGl0bGVzLmhvdFRpdGxlQmFja2dyb3VuZENvbG9yID0gc2VsU2Vjb25kQmdDb2xvclxuICBtb2R1bGVEYXRhLmxpc3RUaXRsZXMubGFzdFRpdGxlQ29sb3IgPSBub3JtYWxTZWNvbmRDb2xvclxuICBtb2R1bGVEYXRhLmxpc3RUaXRsZXMubGFzdFRpdGxlQmFja2dyb3VuZENvbG9yID0gbm9ybWFsU2Vjb25kQmdDb2xvclxuICBtb2R1bGVEYXRhLmxpc3QgPSBjb2luRHluYW1pY0hvdEFycmF5XG5cbiAgdmFyIHByb3BlcnRpZXMgPSB7XG4gICAgbW9kdWxlX25hbWU6J3NlbGVjdFRhYicsXG4gICAgdHlwZTogJ2hvdGVzdCdcbiAgfVxuICBhd2FpdCBhbmFseXRpY3NBcHBDbGlja1JlY29tQ29pbkRldGFpbChwcm9wZXJ0aWVzKVxufVxuXG4vL+acgOaWsFxubW9kdWxlRXZlbnQuc2VsZWN0ZWRMYXN0QWN0aW9uID0gYXN5bmMgZnVuY3Rpb24oKSB7XG4gIGNvbnNvbGUubG9nKCdzZWxlY3RlZExhc3RBY3Rpb24nKVxuICBzZWxQb3N0SW5kZXggPSAxXG4gIG1vZHVsZURhdGEubGlzdFRpdGxlcy5ob3RUaXRsZUNvbG9yID0gbm9ybWFsU2Vjb25kQ29sb3JcbiAgbW9kdWxlRGF0YS5saXN0VGl0bGVzLmhvdFRpdGxlQmFja2dyb3VuZENvbG9yID0gbm9ybWFsU2Vjb25kQmdDb2xvclxuICBtb2R1bGVEYXRhLmxpc3RUaXRsZXMubGFzdFRpdGxlQ29sb3IgPSBzZWxTZWNvbmRDb2xvclxuICBtb2R1bGVEYXRhLmxpc3RUaXRsZXMubGFzdFRpdGxlQmFja2dyb3VuZENvbG9yID0gc2VsU2Vjb25kQmdDb2xvclxuICBpZiAoY29pbkR5bmFtaWNMYXN0QXJyYXkubGVuZ3RoIDw9IDApIHtcbiAgICBjb2luRHluYW1pY0xhc3RBcnJheSA9IGF3YWl0IHJlcXVlc3RQb3N0TGlzdERhdGEoKVxuICB9ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIFxuICBtb2R1bGVEYXRhLmxpc3QgPSBjb2luRHluYW1pY0xhc3RBcnJheVxuICB2YXIgcHJvcGVydGllcyA9IHtcbiAgICBtb2R1bGVfbmFtZTonc2VsZWN0VGFiJyxcbiAgICB0eXBlOiAnbGF0ZXN0J1xuICB9XG4gIGF3YWl0IGFuYWx5dGljc0FwcENsaWNrUmVjb21Db2luRGV0YWlsKHByb3BlcnRpZXMpXG59XG5cbi8v57K+6YCJXG5tb2R1bGVFdmVudC5lbGl0ZVBvc3RzQWN0aW9uID0gYXN5bmMgZnVuY3Rpb24oKSB7XG4gIG1vZHVsZURhdGEubGlzdFRpdGxlcy5lbGl0ZVBvc3RzVGl0bGVDb2xvciA9IHNlbFRpdGxlQ29sb3IgXG4gIG1vZHVsZURhdGEubGlzdFRpdGxlcy5uZXdzVGl0bGVDb2xvciA9IG5vcm1hbFRpdGxlQ29sb3JcbiAgbW9kdWxlRGF0YS5saXN0VGl0bGVzLmZpbHRlckJ1dHRvblZpc2liaWxpdHkgPSAndmlzaWJsZSdcbiAgc2VsTGlzdEluZGV4ID0gMFxuICBpZiAoc2VsUG9zdEluZGV4ID09IDEpIHtcbiAgICAvL+acgOaWsFxuICAgIG1vZHVsZURhdGEubGlzdCA9IGNvaW5EeW5hbWljTGFzdEFycmF5XG4gIH0gZWxzZSB7XG4gICAgLy/mnIDng61cbiAgICBtb2R1bGVEYXRhLmxpc3QgPSBjb2luRHluYW1pY0hvdEFycmF5XG4gIH1cbiAgdmFyIHByb3BlcnRpZXMgPSB7XG4gICAgbW9kdWxlX25hbWU6J3NlbGVjdFRhYicsXG4gICAgdHlwZTogJ3Bvc3RzJ1xuICB9XG4gIGF3YWl0IGFuYWx5dGljc0FwcENsaWNrUmVjb21Db2luRGV0YWlsKHByb3BlcnRpZXMpXG59XG5cbi8v5paw6Ze7XG5tb2R1bGVFdmVudC5zZWxlY3RlZE5ld3NBY3Rpb24gPSBhc3luYyBmdW5jdGlvbigpIHtcbiAgc2VsTGlzdEluZGV4ID0gMVxuICBtb2R1bGVEYXRhLmxpc3RUaXRsZXMuZWxpdGVQb3N0c1RpdGxlQ29sb3IgPSBub3JtYWxUaXRsZUNvbG9yXG4gIG1vZHVsZURhdGEubGlzdFRpdGxlcy5uZXdzVGl0bGVDb2xvciA9IHNlbFRpdGxlQ29sb3JcbiAgbW9kdWxlRGF0YS5saXN0VGl0bGVzLmZpbHRlckJ1dHRvblZpc2liaWxpdHkgPSAnZ29uZSdcbiAgbW9kdWxlRGF0YS5saXN0ID0gY29pbk5ld3NBcnJheVxuXG4gIHZhciBwcm9wZXJ0aWVzID0ge1xuICAgIG1vZHVsZV9uYW1lOidzZWxlY3RUYWInLFxuICAgIHR5cGU6ICduZXdzJ1xuICB9XG4gIGF3YWl0IGFuYWx5dGljc0FwcENsaWNrUmVjb21Db2luRGV0YWlsKHByb3BlcnRpZXMpXG59XG5cbmFzeW5jIGZ1bmN0aW9uIGFuYWx5dGljc0FwcENsaWNrUmVjb21Db2luRGV0YWlsKHByb3BlcnRpZXMpIHtcbiAgY29uc3QgcHJvcGVydGllc0pzb24gPSBKU09OLnN0cmluZ2lmeShwcm9wZXJ0aWVzKTtcbiAgdmFyIG1hcCA9IHtcbiAgICBldmVudDogJ2FwcENsaWNrX1JlY29tQ29pbkRldGFpbCcsXG4gICAgcHJvcGVydGllczogcHJvcGVydGllc0pzb25cbiAgfVxuICBhd2FpdCAkbmF0aXZlQVBJLmFuYWx5dGljcyhtYXApO1xufVxuXG4vL+W4guWcuuaDhee7queCueWHu1xubW9kdWxlRXZlbnQubWFya2V0U2VudGltZW50SW5mb0FjdGlvbiA9IGFzeW5jIGZ1bmN0aW9uKCkge1xuICBjb25maWdUaXBBbGVydFRpdGxlKCRpMThuLm5faG90Y29pbl9yYWRhcl9tYXJrZXRfc2VudGltZW50LCAkaTE4bi5uX2hvdGNvaW5fcmFkYXJfbWFya2V0X3NlbnRpbWVudF9leHBsYW5hdGlvbik7XG4gIG1vZHVsZURhdGEudGlwQWxlcnRTaG93ID0gdHJ1ZTtcbn1cblxuLy/ngrnlh7vlm77niYdcbm1vZHVsZUV2ZW50LmltYWdlU2VsZWN0ZWQgPSBhc3luYyBmdW5jdGlvbiAoaW1hZ2VJbmRleCwgaXRlbUluZGV4KSB7XG4gIGNvbnNvbGUubG9nKGBpbWFnZVNlbGVjdGVkLGltYWdlSW5kZXgke2ltYWdlSW5kZXh9LGl0ZW1JbmRleD09JHtpdGVtSW5kZXh9YCk7XG4gIGlmIChpdGVtSW5kZXggPCBtb2R1bGVEYXRhLmxpc3QubGVuZ3RoKSB7XG4gICAgdmFyIGl0ZW0gPSBtb2R1bGVEYXRhLmxpc3RbaXRlbUluZGV4XTtcbiAgICB2YXIgaW1nTGlzdCA9IGl0ZW0uaW1hZ2VMaXN0LnJhd0FycmF5KCk7XG4gICAgaWYgKGltZ0xpc3QgIT0gbnVsbCkge1xuICAgICAgdmFyIG1hcCA9IHtcbiAgICAgICAgY3VycmVudEluZGV4OiBpbWFnZUluZGV4LFxuICAgICAgICBpbWFnZUxpc3Q6IGltZ0xpc3QsXG4gICAgICB9O1xuICAgICAgY29uc29sZS5sb2coYGltYWdlU2VsZWN0ZWQsaW1nTGlzdEpzb249PSR7SlNPTi5zdHJpbmdpZnkobWFwKX1gKTtcbiAgICAgICRuYXRpdmVBUEkub3BlblByZXZpZXdJbWFnZShKU09OLnN0cmluZ2lmeShtYXApKTtcbiAgICB9XG4gIH1cbn07XG5cbm1vZHVsZUV2ZW50LnNvdXJjZUl0ZW1TZWxlY3RlZCA9IGFzeW5jIGZ1bmN0aW9uKGluZGV4KSB7XG4gIGlmIChpbmRleCkge1xuICAgIGxldCBpID0gcGFyc2VJbnQoaW5kZXgpO1xuICAgIGxldCBtb2RlbCA9IG1vZHVsZURhdGEubGlzdFtpXTtcbiAgICBpZiAobW9kZWwuc2hvd1NvdXJjZSA9PSB0cnVlKSB7XG4gICAgICAvL+eCueWHu+e/u+ivkVxuICAgICAgbW9kZWwuc2hvd0NvbnRlbnQgPSBtb2RlbC5jb250ZW50XG4gICAgICBtb2RlbC5wYXJlbnREeW5hbWljQ29udGVudCA9IG1vZGVsLnBhcmVudER5bmFtaWNcbiAgICAgIG1vZGVsLnNvdXJjZVRpdGxlID0gc2hvd1NvdXJjZVRpdGxlXG4gICAgICBtb2RlbC5zaG93U291cmNlID0gZmFsc2VcbiAgICAgIHZhciBwcm9wZXJ0aWVzID0ge1xuICAgICAgICBtb2R1bGVfbmFtZTondHJhbnNsYXRlJyxcbiAgICAgICAgdHlwZTogJ3RyYW5zbGF0ZSdcbiAgICAgIH1cbiAgICAgIGF3YWl0IGFuYWx5dGljc0FwcENsaWNrUmVjb21Db2luRGV0YWlsKHByb3BlcnRpZXMpXG4gICAgfSBlbHNlIHtcbiAgICAgIC8v54K55Ye75pi+56S65Y6f5paHXG4gICAgICBtb2RlbC5zaG93Q29udGVudCA9IG1vZGVsLnNvdXJjZUNvbnRlbnRcbiAgICAgIG1vZGVsLnBhcmVudER5bmFtaWNDb250ZW50ID0gbW9kZWwuc291cmNlUGFyZW50RHluYW1pY1xuICAgICAgbW9kZWwuc291cmNlVGl0bGUgPSBzaG93Q29udGVudFRpdGxlXG4gICAgICBtb2RlbC5zaG93U291cmNlID0gdHJ1ZVxuICAgICAgdmFyIHByb3BlcnRpZXMgPSB7XG4gICAgICAgIG1vZHVsZV9uYW1lOid0cmFuc2xhdGUnLFxuICAgICAgICB0eXBlOiAnb3JpZ2luYWwnXG4gICAgICB9XG4gICAgICBhd2FpdCBhbmFseXRpY3NBcHBDbGlja1JlY29tQ29pbkRldGFpbChwcm9wZXJ0aWVzKVxuICAgIH1cbiAgfVxufVxuXG5tb2R1bGVFdmVudC5jZWxsU2VsZWN0ZWQgPSBhc3luYyBmdW5jdGlvbihpbmRleCkge1xuICBsZXQgc2VsSW5kZXggPSBwYXJzZUludChpbmRleCk7XG4gIGlmIChzZWxMaXN0SW5kZXggPT0gMSkge1xuICAgIC8v5paw6Ze7XG4gICAgc2VsTmV3c01vZGUgPSBjb2luTmV3c0FycmF5W3NlbEluZGV4XVxuICAgIC8v5paw6Ze7Y2VsbOeCueWHu1xuICAgIGlmIChzZWxOZXdzTW9kZSkge1xuICAgICAgaWYgKHNlbE5ld3NNb2RlLmR5bmFtaWNJZCkge1xuICAgICAgICAvL+i/m+ekvuWMulxuICAgICAgICAkbmF0aXZlQVBJLm9wZW5Sb3V0ZShgaG9saWdlaXQ6Ly9vcGVuL3YxP3VybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vY29udGVudC9EeW5hbWljRGV0YWlsP2R5bmFtaWNJZD0ke3NlbE5ld3NNb2RlLmR5bmFtaWNJZH1gKVxuICAgICAgfSBlbHNlIHtcbiAgICAgICAgY29uc3QgbmV3c0FsZXJ0U2hvd24gPSBhd2FpdCBjb21tb24ucmVhZChzdG9yYWdlTW9kdWxlTmFtZSwgc3RvcmFnZU5ld3NBbGVydEtleSlcbiAgICAgICAgaWYgKG5ld3NBbGVydFNob3duID09ICcxJykge1xuICAgICAgICAgICAgLy/nm7TmjqXot7Povazpk77mjqVcbiAgICAgICAgICAgICRuYXRpdmVBUEkub3BlblJvdXRlKHNlbE5ld3NNb2RlLnNvdXJjZUxpbmspO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgIC8v5by55o+Q56S6XG4gICAgICAgICAgY29uZmlnVGlwQWxlcnRUaXRsZSh0aXBUaXRsZSwgJGkxOG4ubl9ob3Rjb2luX3JhZGFyX3RpcF9jb250aW51ZV9hY2Nlc3NpbmdfbGluaywgMSwgJ3Zpc2libGUnKTtcbiAgICAgICAgICBtb2R1bGVEYXRhLnRpcEFsZXJ0U2hvdyA9IHRydWU7XG4gICAgICAgICAgYWxlcnQubmV3c0FsZXJ0U2hvdyA9IHRydWVcbiAgICAgICAgfVxuICAgICAgfVxuICAgIH1cbiAgICB2YXIgcHJvcGVydGllcyA9IHtcbiAgICAgIG1vZHVsZV9uYW1lOidjb250ZW50JyxcbiAgICAgIHR5cGU6ICduZXdzJ1xuICAgIH1cbiAgICBhd2FpdCBhbmFseXRpY3NBcHBDbGlja1JlY29tQ29pbkRldGFpbChwcm9wZXJ0aWVzKVxuICB9IGVsc2Uge1xuICAgIC8v5YWI5Yik5patXG4gICAgY29uc3QgcGFnZVNob3duID0gYXdhaXQgY29tbW9uLnJlYWQoc3RvcmFnZU1vZHVsZU5hbWUsc3RvcmFnZVBhZ2VBbGVydEtleSlcbiAgICBjb25zdCBwYWdlVnBuU2hvd24gPSAgYXdhaXQgY29tbW9uLnJlYWQoc3RvcmFnZU1vZHVsZU5hbWUsIHN0b3JhZ2VQYWdlVnBuQWxlcnRLZXkpXG4gICAgaWYgKHNlbFBvc3RJbmRleCA9PSAxKSB7XG4gICAgICAvL+acgOaWsFxuICAgICAgc2VsRHluYW1pY01vZGU9IGNvaW5EeW5hbWljTGFzdEFycmF5W3NlbEluZGV4XVxuICAgIH0gZWxzZSB7XG4gICAgICAvL+acgOeDrVxuICAgICAgc2VsRHluYW1pY01vZGUgPSBjb2luRHluYW1pY0hvdEFycmF5W3NlbEluZGV4XVxuICAgIH1cbiAgICAvL+WFiOWIpOaWrVxuICAgIGlmIChjb21tb24uY29tbW9uRGF0YS5sYW5ndWFnZSA9PSAnemgtY24nKSB7XG4gICAgICBpZiAocGFnZVZwblNob3duID09ICcxJykge1xuICAgICAgICBvcGVuRHluYW1pYyhzZWxEeW5hbWljTW9kZSlcbiAgICAgIH0gZWxzZSB7XG4gICAgICAgIC8v56eR5a2m5LiK572RXG4gICAgICAgIGNvbmZpZ1RpcEFsZXJ0VGl0bGUodGlwVGl0bGUsICflvZPliY3lhoXlrrnmnaXmupDkuLogWO+8jOeCueWHu+e7p+e7reWwhuaJk+W8gCBYIOmhtemdou+8jOivt+aJk+W8gCBWUE4g5ZCO5YaN6K6/6ZeuIFgnLCAxLCAndmlzaWJsZScpO1xuICAgICAgICBtb2R1bGVEYXRhLnRpcEFsZXJ0U2hvdyA9IHRydWVcbiAgICAgICAgYWxlcnQucGFnZVZwbkFsZXJ0U2hvdyA9IHRydWVcbiAgICAgIH1cbiAgICB9IGVsc2Uge1xuICAgICAgaWYgKHBhZ2VTaG93biA9PSAnMScpIHtcbiAgICAgICAgb3BlbkR5bmFtaWMoc2VsRHluYW1pY01vZGUpXG4gICAgICB9IGVsc2Uge1xuICAgICAgICAvL+aJk+W8gOmhtemdouaPkOekulxuICAgICAgICBjb25maWdUaXBBbGVydFRpdGxlKHRpcFRpdGxlLCAkaTE4bi5uX2hvdGNvaW5fcmFkYXJfdGlwX3R1cm5fb25feCwgMSwgJ3Zpc2libGUnKTtcbiAgICAgICAgbW9kdWxlRGF0YS50aXBBbGVydFNob3cgPSB0cnVlXG4gICAgICAgIGFsZXJ0LnBhZ2VBbGVydFNob3cgPSB0cnVlXG4gICAgICB9XG4gICAgfVxuICAgIHZhciBwcm9wZXJ0aWVzID0ge1xuICAgICAgbW9kdWxlX25hbWU6J2NvbnRlbnQnLFxuICAgICAgdHlwZTogJ3Bvc3RzJ1xuICAgIH1cbiAgICBhd2FpdCBhbmFseXRpY3NBcHBDbGlja1JlY29tQ29pbkRldGFpbChwcm9wZXJ0aWVzKVxuICB9XG59XG5cbmZ1bmN0aW9uIGNsZWFyQWxlcnRTaG93U3RhdHVzKCkge1xuICBhbGVydC5uZXdzQWxlcnRTaG93ID0gZmFsc2VcbiAgYWxlcnQucGFnZUFsZXJ0U2hvdyA9IGZhbHNlXG4gIGFsZXJ0LnBhZ2VWcG5BbGVydFNob3cgPSBmYWxzZVxufVxuXG5hc3luYyBmdW5jdGlvbiBoYW5kbGVFbGl0ZVBvc3RzKGRhdGEpIHtcbiAgdmFyIGFycmF5ID0gW107XG4gIGZvciAodmFyIGkgPSAwOyBpIDwgZGF0YS5sZW5ndGg7IGkrKykge1xuICAgICAgdmFyIG1vZGVsID0gIGF3YWl0IGhhbmRsZUVsaXRlUG9zdHNNb2RlbChkYXRhW2ldLCBpKTtcbiAgICAgIGFycmF5LnB1c2gobW9kZWwpO1xuICB9XG4gIHJldHVybiBhcnJheVxufVxuXG5hc3luYyBmdW5jdGlvbiBoYW5kbGVFbGl0ZVBvc3RzTW9kZWwoaXRlbSwgaW5kZXgpIHtcbiAgdmFyIG1vZGVsID0ge307XG4gIG1vZGVsLm5pY2tuYW1lID0gaXRlbS5uaWNrbmFtZTtcbiAgbW9kZWwuYXZhdGFyID0gaXRlbS5hdmF0YXI7XG4gIG1vZGVsLmF1dGhVcmwgPSBcIlwiO1xuICBtb2RlbC5wb3N0SWQgPSBpdGVtLnBvc3RJZDtcbiAgbW9kZWwuY29udGVudCA9IGl0ZW0uY29udGVudDtcbiAgbW9kZWwubGFuZ3VhZ2VJZCA9IGl0ZW0ubGFuZ3VhZ2VJZDtcbiAgbW9kZWwuc291cmNlTGFuZ3VhZ2VJZCA9IGl0ZW0uc291cmNlTGFuZ3VhZ2VJZDtcbiAgbW9kZWwuc2hvd1NvdXJjZSA9IG1vZGVsLnNob3dTb3VyY2U7XG4gIG1vZGVsLnNvdXJjZUNvbnRlbnQgPSBpdGVtLnNvdXJjZUNvbnRlbnQ7XG4gIG1vZGVsLnNvdXJjZUxpbmsgPSBpdGVtLnNvdXJjZUxpbms7XG4gIG1vZGVsLmltYWdlTGlzdCA9IGl0ZW0uaW1hZ2VMaXN0O1xuXG4gIGlmIChzZWxQb3N0SW5kZXggPT0gMSkge1xuICAgIC8v5pyA5pawXG4gICAgaWYgKGNvaW5EeW5hbWljTGFzdFBhZ2VObyA+IDEpIHtcbiAgICAgIG1vZGVsLmluZGV4ID0gU3RyaW5nKGluZGV4ICsgY29pbkR5bmFtaWNMYXN0QXJyYXkubGVuZ3RoKTtcbiAgICB9IGVsc2Uge1xuICAgICAgbW9kZWwuaW5kZXggPSBTdHJpbmcoaW5kZXgpO1xuICAgIH1cbiAgfSBlbHNlIHtcbiAgICAvL+acgOeDrVxuICAgIGlmIChjb2luRHluYW1pY0hvdFBhZ2VObyA+IDEpIHtcbiAgICAgIG1vZGVsLmluZGV4ID0gU3RyaW5nKGluZGV4ICsgY29pbkR5bmFtaWNIb3RBcnJheS5sZW5ndGgpO1xuICAgIH0gZWxzZSB7XG4gICAgICBtb2RlbC5pbmRleCA9IFN0cmluZyhpbmRleCk7XG4gICAgfVxuICB9XG4gIG1vZGVsLnB1Ymxpc2hUaW1lID0gdG9Gb3JtYXRlZERldGFpbERhdGUoaXRlbS5wdWJsaXNoVGltZSk7XG5cbiAgLy/mmK/lkKbmmL7npLrljp/mlofvvIwx5pivMOWQplxuICBpZiAoaXRlbS5zaG93U291cmNlID09IDEpIHtcbiAgICBtb2RlbC5zb3VyY2VUaXRsZSA9IHNob3dTb3VyY2VUaXRsZVxuICAgIG1vZGVsLnNvdXJjZVZpc2liaWxpdHkgPSAndmlzaWJsZSdcbiAgfSBlbHNlIHtcbiAgICBtb2RlbC5zb3VyY2VUaXRsZSA9ICcnXG4gICAgbW9kZWwuc291cmNlVmlzaWJpbGl0eSA9ICdnb25lJ1xuICB9XG4gIG1vZGVsLmlzU291cmNlID0gZmFsc2VcbiAgbW9kZWwuc2hvd0NvbnRlbnQgPSBtb2RlbC5jb250ZW50XG5cbiAgbW9kZWwudHlwZSA9IFwiMVwiO1xuICBpZiAoaXRlbS5pbWFnZUxpc3QgJiYgaXRlbS5pbWFnZUxpc3QubGVuZ3RoID4gMCkge1xuICAgIG1vZGVsLmltYWdlQ29tcG9uZW5WaXNpYmlsaXR5ID0gXCJ2aXNpYmxlXCI7XG4gICAgaWYgKGl0ZW0uaW1hZ2VMaXN0Lmxlbmd0aCA9PSAxKSB7XG4gICAgICBtb2RlbC5vbmVJbWFnZVZpc2liaWxpdHkgPSBcInZpc2libGVcIjtcbiAgICAgIG1vZGVsLnR3b0ltYWdlVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgICAgbW9kZWwudGhyZWVJbWFnZVZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICAgIG1vZGVsLmZvdXJJbWFnZVZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICAgIG1vZGVsLmltYWdlT25lID0gaXRlbS5pbWFnZUxpc3RbMF07XG4gICAgfSBlbHNlIGlmIChpdGVtLmltYWdlTGlzdC5sZW5ndGggPT0gMikge1xuICAgICAgbW9kZWwub25lSW1hZ2VWaXNpYmlsaXR5ID0gXCJnb25lXCI7XG4gICAgICBtb2RlbC50d29JbWFnZVZpc2liaWxpdHkgPSBcInZpc2libGVcIjtcbiAgICAgIG1vZGVsLnRocmVlSW1hZ2VWaXNpYmlsaXR5ID0gXCJnb25lXCI7XG4gICAgICBtb2RlbC5mb3VySW1hZ2VWaXNpYmlsaXR5ID0gXCJnb25lXCI7XG4gICAgICBtb2RlbC5pbWFnZU9uZSA9IGl0ZW0uaW1hZ2VMaXN0WzBdO1xuICAgICAgbW9kZWwuaW1hZ2VUd28gPSBpdGVtLmltYWdlTGlzdFsxXTtcbiAgICB9IGVsc2UgaWYgKGl0ZW0uaW1hZ2VMaXN0Lmxlbmd0aCA9PSAzKSB7XG4gICAgICBtb2RlbC5vbmVJbWFnZVZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICAgIG1vZGVsLnR3b0ltYWdlVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgICAgbW9kZWwudGhyZWVJbWFnZVZpc2liaWxpdHkgPSBcInZpc2libGVcIjtcbiAgICAgIG1vZGVsLmZvdXJJbWFnZVZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICAgIG1vZGVsLmltYWdlT25lID0gaXRlbS5pbWFnZUxpc3RbMF07XG4gICAgICBtb2RlbC5pbWFnZVR3byA9IGl0ZW0uaW1hZ2VMaXN0WzFdO1xuICAgICAgbW9kZWwuaW1hZ2VUaHJlZSA9IGl0ZW0uaW1hZ2VMaXN0WzJdO1xuICAgIH0gZWxzZSB7XG4gICAgICBtb2RlbC5vbmVJbWFnZVZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICAgIG1vZGVsLnR3b0ltYWdlVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgICAgbW9kZWwudGhyZWVJbWFnZVZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICAgIG1vZGVsLmZvdXJJbWFnZVZpc2liaWxpdHkgPSBcInZpc2libGVcIjtcbiAgICAgIG1vZGVsLmltYWdlT25lID0gaXRlbS5pbWFnZUxpc3RbMF07XG4gICAgICBtb2RlbC5pbWFnZVR3byA9IGl0ZW0uaW1hZ2VMaXN0WzFdO1xuICAgICAgbW9kZWwuaW1hZ2VUaHJlZSA9IGl0ZW0uaW1hZ2VMaXN0WzJdO1xuICAgICAgbW9kZWwuaW1hZ2VGb3VyID0gaXRlbS5pbWFnZUxpc3RbM107XG4gICAgfVxuICB9IGVsc2Uge1xuICAgIG1vZGVsLmltYWdlQ29tcG9uZW5WaXNpYmlsaXR5ID0gXCJnb25lXCI7XG4gICAgbW9kZWwub25lSW1hZ2VWaXNpYmlsaXR5ID0gXCJnb25lXCI7XG4gICAgbW9kZWwudHdvSW1hZ2VWaXNpYmlsaXR5ID0gXCJnb25lXCI7XG4gICAgbW9kZWwudGhyZWVJbWFnZVZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICBtb2RlbC5mb3VySW1hZ2VWaXNpYmlsaXR5ID0gXCJnb25lXCI7XG4gICAgbW9kZWwuaW1hZ2VPbmUgPSBcIlwiO1xuICAgIG1vZGVsLmltYWdlVHdvID0gXCJcIjtcbiAgICBtb2RlbC5pbWFnZVRocmVlID0gXCJcIjtcbiAgICBtb2RlbC5pbWFnZUZvdXIgPSBcIlwiO1xuICB9XG5cbiAgaWYgKGl0ZW0ucGFyZW50RHluYW1pYyAmJiBpdGVtLnBhcmVudER5bmFtaWMubGVuZ3RoID4gMCkge1xuICAgIC8vIOi9rOW4llxuICAgIG1vZGVsLnBhcmVudER5bmFtaWNDb21wb25lblZpc2liaWxpdHkgPSBcInZpc2libGVcIjtcbiAgICBtb2RlbC5wYXJlbnREeW5hbWljID0gaXRlbS5wYXJlbnREeW5hbWljXG4gICAgbW9kZWwuc291cmNlUGFyZW50RHluYW1pYyA9IGl0ZW0uc291cmNlUGFyZW50RHluYW1pY1xuXG4gICAgbW9kZWwucGFyZW50RHluYW1pY0NvbnRlbnQgPSBpdGVtLnBhcmVudER5bmFtaWM7XG5cbiAgfSBlbHNlIHtcbiAgICBtb2RlbC5wYXJlbnREeW5hbWljQ29tcG9uZW5WaXNpYmlsaXR5ID0gXCJnb25lXCI7XG4gICAgbW9kZWwucGFyZW50RHluYW1pY0NvbnRlbnQgPSBcIlwiO1xuICB9XG4gIGlmIChpdGVtLmludGVyYWN0aW9ucyAmJiBpdGVtLmludGVyYWN0aW9ucyA+IDApIHtcbiAgICBjb25zdCBpbnRlcmFjdGlvbnMgPSBpdGVtLmludGVyYWN0aW9ucy50b1N0cmluZygpO1xuICAgIGNvbnN0IGludGVyYWN0aW9uc1N0cmluZyA9IGF3YWl0ICRuYXRpdmVBUEkuY29udmVydFN0cmluZyhpbnRlcmFjdGlvbnMpO1xuICAgIG1vZGVsLmludGVyYWN0aW9ucyA9IGludGVyYWN0aW9uc1N0cmluZ1xuICB9IGVsc2Uge1xuICAgIG1vZGVsLmludGVyYWN0aW9ucyA9ICcwJztcbiAgfVxuICByZXR1cm4gbW9kZWw7XG59XG5cbi8v6K+35rGC5paw6Ze75YiX6KGo5pWw5o2uXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0Q29pbk5ld3MoKSB7XG4gIHZhciBwYXJhbXMgPSB7fVxuICBwYXJhbXMuY29pbiA9IG1vZHVsZURhdGEuY29pblxuICBwYXJhbXMucGFnZU5vID0gY29pbk5ld1BhZ2VOb1xuICBwYXJhbXMucGFnZVNpemUgPSAxMFxuICB2YXIgZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdChcInYxL2NvbnRlbnQvY29tbXVuaXR5L3Rva2VuLWRpc2Nlcm4vY29pbi1uZXdzXCIsIHBhcmFtcyk7XG4gIHRyeSB7XG4gICAgaWYgKCFkYXRhIHx8IGRhdGEgPT0gbnVsbCB8fCAhZGF0YS5saXN0RGF0YSB8fCBkYXRhLmxpc3REYXRhID09IG51bGwgfHwgZGF0YS5saXN0RGF0YS5sZW5ndGggPT0gMCkge1xuICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICBjb2luTmV3UGFnZU5vKytcbiAgICByZXR1cm4gaGFuZGxlTmV3cyhkYXRhLmxpc3REYXRhKTtcbiAgfSBjYXRjaCAoZSkge1xuICAgIGNvbnNvbGUubG9nKGBoYW5kbGUgY291cG9uTGlzdCAgZXJyb3I9JHtlfWApO1xuICB9XG59XG5cbmZ1bmN0aW9uIGhhbmRsZU5ld3MoZGF0YSkge1xuICB2YXIgYXJyYXkgPSBbXTtcbiAgZm9yICh2YXIgaSA9IDA7IGkgPCBkYXRhLmxlbmd0aDsgaSsrKSB7XG4gICAgICB2YXIgbW9kZWwgPSAgaGFuZGxlTmV3c0l0ZW0oZGF0YVtpXSwgaSk7XG4gICAgICBhcnJheS5wdXNoKG1vZGVsKTtcbiAgfVxuICByZXR1cm4gYXJyYXlcbn1cblxuZnVuY3Rpb24gaGFuZGxlTmV3c0l0ZW0oaXRlbSwgaW5kZXgpIHtcbiAgdmFyIG1vZGVsID0ge31cbiAgbW9kZWwubmV3c0NvbnRlbnQgPSBpdGVtLmNvbnRlbnRcbiAgbW9kZWwubmV3c1NvdWNlID0gaXRlbS5uaWNrbmFtZVxuICBtb2RlbC5uZXdzVGltZSA9IG1vZGVsLnB1Ymxpc2hUaW1lID0gdG9Gb3JtYXRlZERldGFpbERhdGUoaXRlbS5wdWJsaXNoVGltZSlcbiAgbW9kZWwudHlwZSA9ICcyJ1xuICBtb2RlbC5zb3VyY2VMYW5ndWFnZUlkID0gaXRlbS5zb3VyY2VMYW5ndWFnZUlkXG4gIG1vZGVsLnNvdXJjZUxpbmsgPSBpdGVtLnNvdXJjZUxpbmtcbiAgbW9kZWwuZHluYW1pY0lkID0gaXRlbS5keW5hbWljSWQ7XG4gIGlmIChjb2luTmV3UGFnZU5vID4gMSkge1xuICAgIG1vZGVsLmluZGV4ID0gU3RyaW5nKGluZGV4ICsgY29pbk5ld3NBcnJheS5sZW5ndGgpXG4gIH0gZWxzZSB7XG4gICAgbW9kZWwuaW5kZXggPSBTdHJpbmcoaW5kZXgpXG4gIH1cbiAgbW9kZWwubmV3c0lkID0gaXRlbS5uZXdzSWRcbiAgcmV0dXJuIG1vZGVsXG59XG5cbi8v54K55Ye75LqG6aG26YOo5LqS5Yqo5qyh5pWw5qCH6aKY77yM5by55Ye66YCJ5oup5qGGXG5tb2R1bGVFdmVudC5jbGlja2VkQ2hhcnRTZWxlY3RvciA9IGFzeW5jIGZ1bmN0aW9uKCkge1xuICBtb2R1bGVEYXRhLnNob3dDaGFydFBvcCA9IHRydWU7XG4gIGNvbnNvbGUubG9nKCdjbGlja2VkQ2hhcnRTZWxlY3RvcicpXG59XG5cbi8vL+eCueS6huWbvuagh+mAieaLqXBvcOS4reeahOWPlua2iOaMiemSrlxubW9kdWxlRXZlbnQuY2xpY2tlZENoYXJ0U2VsZWN0b3JDYW5jZWwgPSBmdW5jdGlvbiAoKSB7XG4gIG1vZHVsZURhdGEuc2hvd0NoYXJ0UG9wID0gZmFsc2U7XG59XG5cbi8v6YCJ5oup5LqG5Zu+6KGo6YCJ5oup5by55qGG5Lit55qE5p+Q5LiqaXRlbVxubW9kdWxlRXZlbnQuY2xpY2tlZENoYXJ0TWVudUl0ZW0gPSBhc3luYyBmdW5jdGlvbiAoaW5kZXgpIHtcbiAgaWYgKGluZGV4ID09IHNlbENoYXJ0SW5kZXgpIHtcbiAgICAgIHJldHVybjtcbiAgfVxuICBcbiAgdmFyIGxhc3RJdGVtID0gbW9kdWxlRGF0YS50b3BDaGFydFBvcExpc3Rbc2VsQ2hhcnRJbmRleF07XG4gIGxhc3RJdGVtLnRleHRDb2xvciA9IFwiQGNvbG9yL2tDb2xvclNlY29uZGFyeUJ1dHRvblRleHRcIjtcbiAgbGFzdEl0ZW0uc2VsSW1hZ2VWaXNpYmlsaXR5ID0gXCJnb25lXCI7XG4gIGxhc3RJdGVtLnNlbGVjdGVkID0gXCJmYWxzZVwiO1xuICBcbiAgc2VsQ2hhcnRJbmRleCA9IGluZGV4O1xuICBcbiAgdmFyIHNlbEl0ZW0gPSBtb2R1bGVEYXRhLnRvcENoYXJ0UG9wTGlzdFtzZWxDaGFydEluZGV4XTtcbiAgc2VsSXRlbS50ZXh0Q29sb3IgPSBcIkBjb2xvci9rQ29sb3JTZWNvbmRhcnlCdXR0b25UZXh0XCI7XG4gIHNlbEl0ZW0uc2VsSW1hZ2VWaXNpYmlsaXR5PSBcInZpc2libGVcIjtcbiAgc2VsSXRlbS5zZWxlY3RlZCA9IFwidHJ1ZVwiO1xuXG4gIG1vZHVsZURhdGEuY2hhcnRTZWxlY3RvclRpdGxlID0gc2VsSXRlbS50aXRsZTtcbiAgY29uc29sZS5sb2coYGluZGV4PT0ke3NlbENoYXJ0SW5kZXh9LHRpdGxlPT0ke21vZHVsZURhdGEudG9wQ2hhcnRQb3BMaXN0W3NlbENoYXJ0SW5kZXhdLnRpdGxlfWApO1xuIFxuICBtb2R1bGVEYXRhLnNob3dDaGFydFBvcCA9IGZhbHNlO1xuXG4gIHZhciB0eXBlU3RyID0gJ3ByaWNlJztcbiAgaWYgKHNlbENoYXJ0SW5kZXggPT0gMSkge1xuICAgIHR5cGVTdHIgPSAnZW5nYWdlbWVudCc7XG4gIH0gZWxzZSAgaWYgKHNlbENoYXJ0SW5kZXggPT0gMikge1xuICAgIHR5cGVTdHIgPSAnbWVudGlvbic7XG4gIH0gZWxzZSAgaWYgKHNlbENoYXJ0SW5kZXggPT0gMykge1xuICAgIHR5cGVTdHIgPSAnZG9taW5hbmNlJztcbiAgfSBlbHNlICBpZiAoc2VsQ2hhcnRJbmRleCA9PSA0KSB7XG4gICAgdHlwZVN0ciA9ICdzZW50aW1lbnQnO1xuICB9XG5cbiAgdmFyIHByb3BlcnRpZXMgPSB7XG4gICAgbW9kdWxlX25hbWU6J0NoYXJ0SW5kaWNhdG9yJyxcbiAgICB0eXBlOiB0eXBlU3RyXG4gIH1cbiAgY29uc3QgcHJvcGVydGllc0pzb24gPSBKU09OLnN0cmluZ2lmeShwcm9wZXJ0aWVzKTtcbiAgdmFyIG1hcCA9IHtcbiAgICBldmVudDogJ2FwcENsaWNrX1JlY29tQ29pbkRldGFpbCcsXG4gICAgcHJvcGVydGllczogcHJvcGVydGllc0pzb25cbiAgfVxuICBhd2FpdCAkbmF0aXZlQVBJLmFuYWx5dGljcyhtYXApO1xuICBhd2FpdCByZXF1ZXN0RGV0YWlsSW5mbygpO1xufVxuXG4vLy/ngrnlh7vlkajmnJ9cbm1vZHVsZUV2ZW50LmNsaWNrZWRQZXJpb2RJdGVtID0gYXN5bmMgZnVuY3Rpb24gKGluZGV4KSB7XG4gIGlmIChpbmRleCA9PSBzZWxQZXJpb2RJbmRleCkge1xuICAgICAgcmV0dXJuO1xuICB9XG4gIGlmIChpbmRleCA8IG1vZHVsZURhdGEucGVyaW9kTGlzdC5sZW5ndGgpIHtcbiAgICB2YXIgbGFzdEl0ZW0gPSBtb2R1bGVEYXRhLnBlcmlvZExpc3Rbc2VsUGVyaW9kSW5kZXhdO1xuICAgIGxhc3RJdGVtLnRleHRDb2xvciA9IFwiQGNvbG9yL2tDb2xvclNlY29uZGFyeVRleHRcIjtcbiAgICBsYXN0SXRlbS5iYWNrZ3JvdW5kQ29sb3IgPSBcIkBjb2xvci9LQmFzZUNvbG9yQ29udGVudEJhY2tncm91bmRcIjtcbiAgICBsYXN0SXRlbS50ZXh0Rm9udFdlaWdodCA9IFwiNDAwXCI7XG4gICAgXG4gICAgc2VsUGVyaW9kSW5kZXggPSBpbmRleDtcbiAgICBcbiAgICB2YXIgc2VsSXRlbSA9IG1vZHVsZURhdGEucGVyaW9kTGlzdFtzZWxQZXJpb2RJbmRleF07XG4gICAgc2VsSXRlbS50ZXh0Q29sb3IgPSBcIkBjb2xvci9rQ29sb3JNYWpvclRoZW1lMTAwXCI7XG4gICAgc2VsSXRlbS5iYWNrZ3JvdW5kQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JNYWpvclRoZW1lMDA2XCI7XG4gICAgc2VsSXRlbS50ZXh0Rm9udFdlaWdodCA9IFwiNTAwXCI7XG4gIH1cblxuICB2YXIgdHlwZVN0ciA9IGdldFBlcmlvZFN0cmluZygpO1xuICBjb25zb2xlLmxvZyhgaW5kZXg9PSR7c2VsUGVyaW9kSW5kZXh9LHRpdGxlPT0ke3R5cGVTdHJ9YCk7XG4gIHZhciBwcm9wZXJ0aWVzTWFwID0ge1xuICAgIG1vZHVsZV9uYW1lOidDaGFydFBlcmlvZCcsXG4gICAgdHlwZTogdHlwZVN0clxuICB9O1xuICBjb25zdCBwcm9wZXJ0aWVzSnNvbiA9IEpTT04uc3RyaW5naWZ5KHByb3BlcnRpZXNNYXApO1xuICB2YXIgbWFwID0ge1xuICAgIGV2ZW50OiAnYXBwQ2xpY2tfUmVjb21Db2luRGV0YWlsJyxcbiAgICBwcm9wZXJ0aWVzOiBwcm9wZXJ0aWVzSnNvblxuICB9XG4gIGF3YWl0ICRuYXRpdmVBUEkuYW5hbHl0aWNzKG1hcCk7XG4gIGF3YWl0IHJlcXVlc3REZXRhaWxJbmZvKCk7XG59XG5cbmZ1bmN0aW9uIGdldFBlcmlvZFN0cmluZygpIHtcbiAgc3dpdGNoIChzZWxQZXJpb2RJbmRleCArIDEpIHtcbiAgICBjYXNlIDE6XG4gICAgICByZXR1cm4gJzI0aCc7XG4gICAgY2FzZSAyOlxuICAgICAgcmV0dXJuICc3ZCc7XG4gICAgY2FzZSAzOlxuICAgICAgcmV0dXJuICczMGQnO1xuICAgIGNhc2UgNDpcbiAgICAgIHJldHVybiAnOTBkJztcbiAgICBjYXNlIDU6XG4gICAgICByZXR1cm4gJzF5JztcbiAgICBkZWZhdWx0OlxuICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIGhhbmRsZURldGFpbEluZm8oZGF0YSkge1xuICBpZiAoZGF0YSAhPSBudWxsKSB7XG4gICAgbW9kdWxlRGF0YS5jb2luID0gZGF0YS5jb2luO1xuICAgIG1vZHVsZURhdGEuY29pblByaWNlID0gYCQke2RhdGEuY29pblByaWNlfWA7XG4gICAgaWYgKGRhdGEuc3ltYm9sICE9IG51bGwpIHtcbiAgICAgIG1vZHVsZURhdGEuc3ltYm9sID0gZGF0YS5zeW1ib2w7XG4gICAgfVxuICAgIGlmIChkYXRhLmNvaW5QcmljZVJhbmdlID4gMCkge1xuICAgICAgbW9kdWxlRGF0YS5jb2luUHJpY2VSYW5nZSA9IGArJHtkYXRhLmNvaW5QcmljZVJhbmdlfSVgO1xuICAgIH0gZWxzZSBpZiAoZGF0YS5jb2luUHJpY2VSYW5nZSA8IDApIHtcbiAgICAgIG1vZHVsZURhdGEuY29pblByaWNlUmFuZ2UgPSBgJHtkYXRhLmNvaW5QcmljZVJhbmdlfSVgO1xuICAgIH1cbiAgICBtb2R1bGVEYXRhLmNvaW5QcmljZVJhbmdlVGV4dENvbG9yID0gY29tbW9uLmdldFByaWNlQ29sb3IoZGF0YS5jb2luUHJpY2VSYW5nZSk7XG4gICAgXG4gICAgaGFzRHluYW1pYyA9IGRhdGEuaGFzRHluYW1pY1xuICAgIGhhc05ld3MgPSBkYXRhLmhhc05ld3NcblxuICAgIC8v5aSE55CG5pe26ZW/5oOF57uqLHNlbnRpbWVudOW3sue7j+S5mOS7peS6hjEwMFxuICAgIHZhciBidWxsaXNoID0gKHBhcnNlRmxvYXQoZGF0YS5zZW50aW1lbnQpKS50b0ZpeGVkKDApO1xuICAgIHZhciBiZWFyaXNoID0gKDEwMC4wMCAtIGJ1bGxpc2gpLnRvRml4ZWQoMCk7XG4gICAgbW9kdWxlRGF0YS5tYXJrZXRTZW50aW1lbnQuYnVsbGlzaFRpdGxlID0gYnVsbGlzaC50b1N0cmluZygpICsgJyUnICsgJGkxOG4ubl9ob3Rjb2luX3JhZGFyX2J1bGxpc2g7XG4gICAgbW9kdWxlRGF0YS5tYXJrZXRTZW50aW1lbnQuYnVsbGlzaFZhbHVlID0gKGJ1bGxpc2ggLyAxMDAuMCkudG9TdHJpbmcoKTtcbiAgICBpZiAoYnVsbGlzaCA9PSAxMDApIHtcbiAgICAgIG1vZHVsZURhdGEubWFya2V0U2VudGltZW50LmJ1bGxpc2hJbWFnZVZpc2liaWxpdHkgPSAnZ29uZSdcbiAgICB9IGVsc2Uge1xuICAgICAgbW9kdWxlRGF0YS5tYXJrZXRTZW50aW1lbnQuYnVsbGlzaEltYWdlVmlzaWJpbGl0eSA9ICd2aXNpYmxlJ1xuICAgIH1cbiAgICBtb2R1bGVEYXRhLm1hcmtldFNlbnRpbWVudC5iZWFyaXNoVGl0bGUgPSBiZWFyaXNoLnRvU3RyaW5nKCkgKyAnJScgKyAkaTE4bi5uX2hvdGNvaW5fcmFkYXJfYmVhcmlzaDtcbiAgICBtb2R1bGVEYXRhLm1hcmtldFNlbnRpbWVudC5iZWFyaXNoVmFsdWUgPSAoYmVhcmlzaCAvIDEwMC4wKS50b1N0cmluZygpO1xuICAgIGlmIChiZWFyaXNoID09IDEwMCkge1xuICAgICAgbW9kdWxlRGF0YS5tYXJrZXRTZW50aW1lbnQuYmVhcmlzaEltYWdlVmlzaWJpbGl0eSA9ICdnb25lJ1xuICAgIH0gZWxzZSB7XG4gICAgICBtb2R1bGVEYXRhLm1hcmtldFNlbnRpbWVudC5iZWFyaXNoSW1hZ2VWaXNpYmlsaXR5ID0gJ3Zpc2libGUnXG4gICAgfVxuICB9XG4gIC8v5aSE55CG5Zu+6KGo5pWw5o2uXG4gIGlmIChkYXRhLmtsaW5lICE9IG51bGwgJiYgZGF0YS5rbGluZS5sZW5ndGggPiAwKSB7XG4gICAgZm9yICh2YXIgaSA9IDA7IGkgPCBkYXRhLmtsaW5lLmxlbmd0aDsgaSsrKSB7XG4gICAgICB2YXIgaXRlbSA9IGRhdGEua2xpbmVbaV07XG4gICAgICBpZiAoaXRlbS50eXBlID09IHNlbENoYXJ0SW5kZXggKyAxICYmIGl0ZW0ubGlzdC5sZW5ndGggPiAwKSB7Ly/lj5blh7rov5nkuKp0eXBl5Lit55qE5omA5pyJ5pWw5o2uXG4gICAgICAgIHZhciBwb2ludExpc3QgPSBbXTtcbiAgICAgICAgdmFyIHhMaXN0ID0gW107XG4gICAgICAgIGZvciAodmFyIGogPSAwOyBqIDwgaXRlbS5saXN0Lmxlbmd0aDsgaisrKSB7XG4gICAgICAgICAgdmFyIGNoYXJ0SXRlbSA9IGl0ZW0ubGlzdFtqXTtcbiAgICAgICAgICB2YXIgcG9wSXRlbSA9IHt9O1xuICAgICAgICAgIHBvcEl0ZW0ub3JpZ2luYWxWYWx1ZSA9IGNoYXJ0SXRlbS5udW1iZXI7XG5cbiAgICAgICAgICB2YXIgdGltZU51bSA9IGNoYXJ0SXRlbS50aW1lLnRvU3RyaW5nKCkubGVuZ3RoID09PSAxMCA/IGNoYXJ0SXRlbS50aW1lICogMTAwMCA6IGNoYXJ0SXRlbS50aW1lO1xuXG4gICAgICAgICAgcG9wSXRlbS5wb3B1cERhdGUgPSBgJHt0aW1lc3RhbXBUb01NREQodGltZU51bSl9ICR7dGltZXN0YW1wVG9ISG1tKHRpbWVOdW0pfWA7XG5cbiAgICAgICAgICBpZiAoc2VsQ2hhcnRJbmRleCA9PSAwKSB7Ly/ku7fmoLxcbiAgICAgICAgICAgIHBvcEl0ZW0ucG9wdXBDb250ZW50ID0gYCR7bW9kdWxlRGF0YS5jaGFydFNlbGVjdG9yVGl0bGV977yaJCR7Y2hhcnRJdGVtLm51bWJlcn1gO1xuICAgICAgICAgIH0gZWxzZSBpZiAoc2VsQ2hhcnRJbmRleCA9PSAzKSB7Ly/npL7lqpLljaDmnInnjodcbiAgICAgICAgICAgIHBvcEl0ZW0ucG9wdXBDb250ZW50ID0gYCR7bW9kdWxlRGF0YS5jaGFydFNlbGVjdG9yVGl0bGV977yaJHsocGFyc2VGbG9hdChjaGFydEl0ZW0ubnVtYmVyKS50b0ZpeGVkKDIpKX0lYDtcbiAgICAgICAgICB9IGVsc2UgaWYgKHNlbENoYXJ0SW5kZXggPT0gNCkgey8v55yL5rao5oOF57uqXG4gICAgICAgICAgICBwb3BJdGVtLnBvcHVwQ29udGVudCA9IGAke21vZHVsZURhdGEuY2hhcnRTZWxlY3RvclRpdGxlfe+8miR7KHBhcnNlRmxvYXQoY2hhcnRJdGVtLm51bWJlcikudG9GaXhlZCgyKSl9JWA7XG4gICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIHZhciBhbW91bnRTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLmNvbnZlcnRTdHJpbmcoY2hhcnRJdGVtLm51bWJlci50b1N0cmluZygpKTtcbiAgICAgICAgICAgIHBvcEl0ZW0ucG9wdXBDb250ZW50ID0gYCR7bW9kdWxlRGF0YS5jaGFydFNlbGVjdG9yVGl0bGV977yaJHthbW91bnRTdHJpbmd9YDtcbiAgICAgICAgICB9XG4gICAgICAgICAgcG9pbnRMaXN0LnB1c2gocG9wSXRlbSk7XG4gICAgICAgICAgdmFyIHhUaW1lO1xuICAgICAgICAgIFxuICAgICAgICAgIGlmIChzZWxQZXJpb2RJbmRleCA9PSAwKSB7XG4gICAgICAgICAgICB4VGltZSA9IHRpbWVzdGFtcFRvSEhtbSh0aW1lTnVtKTtcbiAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgeFRpbWUgPSB0aW1lc3RhbXBUb01NREQodGltZU51bSk7XG4gICAgICAgICAgfVxuICAgICAgICAgIHhMaXN0LnB1c2goeFRpbWUpO1xuICAgICAgICB9XG4gICAgICAgIFxuICAgICAgICB4TGlzdCA9IGhhbmRsZVhMaXN0KHhMaXN0KTtcbiAgICAgICAgdmFyIGxpc3RNYXAgPSB7XG4gICAgICAgICAgXCJwb2ludExpc3RcIjogcG9pbnRMaXN0LFxuICAgICAgICAgIFwieExpc3RcIjogeExpc3RcbiAgICAgICAgfVxuICAgICAgICBsZXQganNvbiA9IEpTT04uc3RyaW5naWZ5KGxpc3RNYXApO1xuICAgICAgICBpZiAobGFzdFBvaW50TGlzdEpzb24gIT0ganNvbikge1xuICAgICAgICAgIG1vZHVsZURhdGEucG9pbnRMaXN0SnNvbiA9IGpzb247XG4gICAgICAgICAgbGFzdFBvaW50TGlzdEpzb24gPSBqc29uO1xuICAgICAgICB9XG4gICAgICB9XG4gICAgfVxuICB9XG59XG5cbmZ1bmN0aW9uIGhhbmRsZVhMaXN0KGxpc3QpIHtcbiAgaWYgKGxpc3QubGVuZ3RoIDw9IDUpIHtcbiAgICAgIHJldHVybiBsaXN0O1xuICB9XG4gIHZhciBtaWRJbmRleCA9IE1hdGguZmxvb3IobGlzdC5sZW5ndGggLyAyKTtcbiAgdmFyIGxldGZNaWRJbmRleCA9IE1hdGguZmxvb3IobGlzdC5sZW5ndGggLyA0KTtcbiAgdmFyIHJpZ2h0TWlkSW5kZXggPSBNYXRoLmZsb29yKGxpc3QubGVuZ3RoIC8gNCkgKyBNYXRoLmZsb29yKGxpc3QubGVuZ3RoIC8gMik7XG4gIHZhciBzdGFydCA9IGxpc3RbMF07XG4gIHZhciBsZWZ0TWlkID0gbGlzdFtsZXRmTWlkSW5kZXhdO1xuICB2YXIgbWlkID0gbGlzdFttaWRJbmRleF07XG4gIHZhciByaWdodE1pZCA9IGxpc3RbcmlnaHRNaWRJbmRleF07XG4gIHZhciBlbmQgPSBsaXN0W2xpc3QubGVuZ3RoIC0gMV07XG4gIHJldHVybiBbc3RhcnQsbGVmdE1pZCxtaWQscmlnaHRNaWQsZW5kXTtcbn1cblxuZnVuY3Rpb24gdGltZXN0YW1wVG9NTUREKHRpbWVzdGFtcCwgbXVsdGlwbGllciA9IDEpIHtcbiAgY29uc3QgZGF0ZSA9IG5ldyBEYXRlKHRpbWVzdGFtcCAqIG11bHRpcGxpZXIpOyAvLyDlsIbml7bpl7TmiLPovazmjaLkuLpEYXRl5a+56LGhXG4gIGNvbnN0IHllYXIgPSBkYXRlLmdldEZ1bGxZZWFyKCk7XG4gIGNvbnN0IG1vbnRoID0gKFwiMFwiICsgKGRhdGUuZ2V0TW9udGgoKSArIDEpKS5zbGljZSgtMik7IC8vIOaciOS7vemcgOimgeWKoDHvvIzkuJTkv53or4HkuKTkvY3mlbDmmL7npLpcbiAgY29uc3QgZGF5ID0gKFwiMFwiICsgZGF0ZS5nZXREYXRlKCkpLnNsaWNlKC0yKTsgLy8g5L+d6K+B5pel5pyf5pi+56S65Lik5L2N5pWwXG4gIHJldHVybiBgJHttb250aH0vJHtkYXl9YDtcbn1cblxuZnVuY3Rpb24gdGltZXN0YW1wVG9ISG1tKHRpbWVzdGFtcCxtdWx0aXBsaWVyID0gMSkge1xuICBjb25zdCBkYXRlID0gbmV3IERhdGUodGltZXN0YW1wICogbXVsdGlwbGllcik7XG4gIGNvbnN0IGhvdXJzID0gZGF0ZS5nZXRIb3VycygpO1xuICBjb25zdCBtaW51dGVzID0gZGF0ZS5nZXRNaW51dGVzKCk7XG4gIGNvbnN0IGZvcm1hdHRlZEhvdXJzID0gaG91cnMudG9TdHJpbmcoKS5wYWRTdGFydCgyLCAnMCcpO1xuICBjb25zdCBmb3JtYXR0ZWRNaW51dGVzID0gbWludXRlcy50b1N0cmluZygpLnBhZFN0YXJ0KDIsICcwJyk7XG4gIHJldHVybiBgJHtmb3JtYXR0ZWRIb3Vyc306JHtmb3JtYXR0ZWRNaW51dGVzfWA7XG59XG5cbmZ1bmN0aW9uIHRpbWVzdGFtcFRvWVlNTUREKHRpbWVzdGFtcCwgbXVsdGlwbGllciA9IDEpIHtcbiAgY29uc3QgZGF0ZSA9IG5ldyBEYXRlKHRpbWVzdGFtcCAqIG11bHRpcGxpZXIpOyAvLyDlsIbml7bpl7TmiLPovazmjaLkuLpEYXRl5a+56LGhXG4gIGNvbnN0IHllYXIgPSBkYXRlLmdldEZ1bGxZZWFyKCk7XG4gIGNvbnN0IG1vbnRoID0gKFwiMFwiICsgKGRhdGUuZ2V0TW9udGgoKSArIDEpKS5zbGljZSgtMik7IC8vIOaciOS7vemcgOimgeWKoDHvvIzkuJTkv53or4HkuKTkvY3mlbDmmL7npLpcbiAgY29uc3QgZGF5ID0gKFwiMFwiICsgZGF0ZS5nZXREYXRlKCkpLnNsaWNlKC0yKTsgLy8g5L+d6K+B5pel5pyf5pi+56S65Lik5L2N5pWwXG4gIHJldHVybiBgJHt5ZWFyfS8ke21vbnRofS8ke2RheX1gO1xufVxuXG4vL+eCueWHu+S6hmFsZXJ055qEIOWPlua2iCDmjInpkq5cbm1vZHVsZUV2ZW50LmNsaWNrZWRUaXBDYW5jZWwgPSBmdW5jdGlvbigpIHtcbiAgbW9kdWxlRGF0YS50aXBBbGVydFNob3cgPSBmYWxzZTtcbiAgY3VycmVudE5vdE5lZWRTaG93ID0gZmFsc2VcbiAgY2xlYXJBbGVydFNob3dTdGF0dXMoKVxufVxuXG4vL+eCueWHu+S6hmFsZXJ055qEIOe7p+e7rSDmjInpkq5cbm1vZHVsZUV2ZW50LmNsaWNrZWRDb250aW51ZSA9IGFzeW5jIGZ1bmN0aW9uKCkge1xuICB2YXIgc2hvdyA9IGZhbHNlXG4gIG1vZHVsZURhdGEudGlwQWxlcnRTaG93ID0gZmFsc2U7XG4gIGlmIChhbGVydC5uZXdzQWxlcnRTaG93ID09IHRydWUpIHtcbiAgICBpZiAoY3VycmVudE5vdE5lZWRTaG93ID09IHRydWUpIHtcbiAgICAgIGF3YWl0IGNvbW1vbi5zYXZlKHN0b3JhZ2VNb2R1bGVOYW1lLHN0b3JhZ2VOZXdzQWxlcnRLZXksJzEnKVxuICAgIH1cbiAgICAkbmF0aXZlQVBJLm9wZW5Sb3V0ZShzZWxOZXdzTW9kZS5zb3VyY2VMaW5rKTtcbiAgfSBlbHNlIGlmIChhbGVydC5wYWdlQWxlcnRTaG93ID09IHRydWUpIHtcbiAgICBpZiAoY3VycmVudE5vdE5lZWRTaG93ID09IHRydWUpIHtcbiAgICAgIGF3YWl0IGNvbW1vbi5zYXZlKHN0b3JhZ2VNb2R1bGVOYW1lLHN0b3JhZ2VQYWdlQWxlcnRLZXksJzEnKVxuICAgIH1cbiAgICAvL+WIpOaWreenkeWtpuS4iue9kVxuICAgIGlmIChjb21tb24uY29tbW9uRGF0YS5sYW5ndWFnZSA9PSAnemgtY24nKSB7XG4gICAgICBjb25zdCBwYWdlVnBuU2hvd24gPSAgYXdhaXQgY29tbW9uLnJlYWQoc3RvcmFnZU1vZHVsZU5hbWUsIHN0b3JhZ2VQYWdlVnBuQWxlcnRLZXkpXG4gICAgICBpZiAocGFnZVZwblNob3duID09ICcxJykge1xuICAgICAgICAvL+ebtOaOpei3s+i9rFxuICAgICAgICBvcGVuRHluYW1pYyhzZWxEeW5hbWljTW9kZSlcbiAgICAgIH0gZWxzZSB7XG4gICAgICAgIC8v56eR5a2m5LiK572RXG4gICAgICAgIGNvbmZpZ1RpcEFsZXJ0VGl0bGUodGlwVGl0bGUsICRpMThuLm5faG90Y29pbl9yYWRhcl90aXBfdHVybl9vbl92cG4sIDEsICd2aXNpYmxlJyk7XG4gICAgICAgIHNob3cgPSB0cnVlXG4gICAgICB9XG4gICAgfSBlbHNlIHtcbiAgICAgIC8v55u05o6l6Lez6L2sXG4gICAgICBvcGVuRHluYW1pYyhzZWxEeW5hbWljTW9kZSlcbiAgICB9XG4gIH0gZWxzZSBpZiAoYWxlcnQucGFnZVZwbkFsZXJ0U2hvdyA9PSB0cnVlKSB7XG4gICAgaWYgKGN1cnJlbnROb3ROZWVkU2hvdyA9PSB0cnVlKSB7XG4gICAgICBhd2FpdCBjb21tb24uc2F2ZShzdG9yYWdlTW9kdWxlTmFtZSxzdG9yYWdlUGFnZVZwbkFsZXJ0S2V5LCcxJylcbiAgICB9XG4gICAgb3BlbkR5bmFtaWMoc2VsRHluYW1pY01vZGUpXG4gIH1cbiAgY3VycmVudE5vdE5lZWRTaG93ID0gZmFsc2VcbiAgaWYgKGNsZWFyID09IHRydWUpIHtcbiAgICBjbGVhckFsZXJ0U2hvd1N0YXR1cygpXG4gIH1cbiAgaWYgKHNob3cpIHtcbiAgICBtb2R1bGVEYXRhLnRpcEFsZXJ0U2hvdyA9IHRydWVcbiAgICBhbGVydC5wYWdlVnBuQWxlcnRTaG93ID0gdHJ1ZVxuICB9XG59XG5cbmZ1bmN0aW9uIG9wZW5EeW5hbWljKHNlbE1vZGVsKSB7XG4gIGlmIChzZWxNb2RlbCAmJiBzZWxNb2RlbC5zb3VyY2VMaW5rKSB7XG4gICAgICBsZXQgbGluaztcbiAgICAgIC8vaGJfaXNDYW5Ob3RHb0JhY2vkuLp0cnVl5pe277yM56aB5q2id2Vi6aG16Z2i5YaF6YOo5L6n5ruR6L+U5Zue77yI5Zyo5Y6f55Sf5aSE55CG77yJXG4gICAgICBpZiAoc2VsTW9kZWwuc291cmNlTGluay5pbmRleE9mKCc/JykhPT0gLTEpIHtcbiAgICAgICAgICBsaW5rID0gYCR7c2VsTW9kZWwuc291cmNlTGlua30maGJfaXNDYW5Ob3RHb0JhY2s9dHJ1ZWA7XG4gICAgICB9IGVsc2Uge1xuICAgICAgICAgIGxpbmsgPSBgJHtzZWxNb2RlbC5zb3VyY2VMaW5rfT9oYl9pc0Nhbk5vdEdvQmFjaz10cnVlYDtcbiAgICAgIH1cbiAgICAgICRuYXRpdmVBUEkub3BlblJvdXRlKGxpbmspO1xuICB9XG59XG5cbi8v54K55Ye75LqGYWxlcnTnmoQg55+l6YGT5LqGIOaMiemSrlxubW9kdWxlRXZlbnQuY2xpY2tlZElLbm93ID0gZnVuY3Rpb24oKSB7XG4gIG1vZHVsZURhdGEudGlwQWxlcnRTaG93ID0gZmFsc2U7XG59XG5cbi8v5Yu+6YCJL+WPlua2iOWLvumAiSDkuI3lho3mj5DphpIg5aSN6YCJ5qGGXG5tb2R1bGVFdmVudC5jbGlja2VkTm9SZW1pbmRlciA9IGZ1bmN0aW9uKCkge1xuICBpZiAoY3VycmVudE5vdE5lZWRTaG93ID09IGZhbHNlKSB7XG4gICAgY3VycmVudE5vdE5lZWRTaG93ID0gdHJ1ZVxuICAgIG1vZHVsZURhdGEubm9SZW1pbmRlckltYWdlID0gJ0BkcmF3YWJsZS9jb21tb25fY2hlY2tfc2VsZWN0ZWQnXG4gIH0gZWxzZSB7XG4gICAgY3VycmVudE5vdE5lZWRTaG93ID0gZmFsc2VcbiAgICBtb2R1bGVEYXRhLm5vUmVtaW5kZXJJbWFnZSA9ICdAZHJhd2FibGUvY29tbW9uX2NoZWNrX3Vuc2VsZWN0ZWQnXG4gIH1cbn1cblxubW9kdWxlRXZlbnQuYmFja0NsaWNrZWQgPSBmdW5jdGlvbiAoKSB7XG4gIGNvbW1vbi5jb250YWluZXJCYWNrKCk7XG59O1xuXG5mdW5jdGlvbiBvblJlc3VtZSAoKSB7XG4gIC8vIHN0YXJ0VGltZXIoKTtcbn07XG5cbmZ1bmN0aW9uIG9uU3RvcCAoKSB7XG4gIC8vIHN0b3BUaW1lcigpO1xufTtcblxuZnVuY3Rpb24gc3RhcnRUaW1lciAoKSB7XG4gIDAgPT0gdGltZXJJZCAmJiAodGltZXJJZCA9IHNldEludGVydmFsKCgoKSA9PiB7XG4gICAgICByZXF1ZXN0RGV0YWlsSW5mbygpO1xuICAgICAgY29uc29sZS5sb2coXCLlvIDlkK/or7fmsYLlpLTpg6jkv6Hmga/nmoTlrprml7blmahcIik7XG4gIH0pLCA1ZTMpKTtcbn1cblxuZnVuY3Rpb24gc3RvcFRpbWVyKCkge1xuICBjbGVhckludGVydmFsKHRpbWVySWQpLCB0aW1lcklkID0gMDtcbiAgY29uc29sZS5sb2coXCLlgZzmraLor7fmsYLlpLTpg6jkv6Hmga/nmoTlrprml7blmahcIik7XG59XG5cbmZ1bmN0aW9uIHRvRm9ybWF0ZWREZXRhaWxEYXRlKHRpbWVzdGFtcCkge1xuICAvLyDlsIbkvKDlhaXnmoTmr6vnp5Lml7bpl7TmiLPovazmjaLkuLpKYXZhU2NyaXB055qERGF0ZeWvueixoVxuICBjb25zdCBkYXRlID0gbmV3IERhdGUocGFyc2VJbnQodGltZXN0YW1wKSk7XG4gIGNvbnN0IHRpbWVJbnRlcnZhbCA9IE1hdGguYWJzKChkYXRlIC0gbmV3IERhdGUoKSkgLyAxMDAwKTtcbiAgaWYgKHRpbWVJbnRlcnZhbCA8IDYwKSB7XG4gICAgICByZXR1cm4gJGkxOG4ubl9jb250ZW50X2RhdGVfanVzdG5vdztcbiAgfSBlbHNlIGlmICh0aW1lSW50ZXJ2YWwgPCAzNjAwKSB7XG4gICAgY29uc3QgbWludXRlcyA9ICBNYXRoLmZsb29yKHRpbWVJbnRlcnZhbCAvIDYwKTtcbiAgICByZXR1cm4gJGkxOG4uJGludGVyY2VwdC5uX2NvbnRlbnRfZGF0ZV9taW51dGVzYWdvKGAke21pbnV0ZXN9YClcbiAgICAgICBcbiAgfSBlbHNlIGlmICh0aW1lSW50ZXJ2YWwgPD0gODY0MDApIHtcbiAgICAgIGNvbnN0IGlzVG9kYXkgPSBpc0RhdGVJblRvZGF5KGRhdGUpO1xuICAgICAgaWYgKGlzVG9kYXkpIHtcbiAgICAgICAgY29uc3QgaG91ciA9IE1hdGguZmxvb3IodGltZUludGVydmFsIC8gMzYwMClcbiAgICAgICAgcmV0dXJuICRpMThuLiRpbnRlcmNlcHQubl9jb250ZW50X2RhdGVfaG91cnNhZ28oYCR7aG91cn1gKVxuICAgICAgfSBlbHNlIHtcbiAgICAgICAgICBjb25zdCB0aW1lU3RyID0gZm9ybWF0RGF0ZShkYXRlLCBcIkhIOm1tXCIpO1xuICAgICAgICAgIHJldHVybiAkaTE4bi5uX2NvbnRlbnRfZGF0ZV95ZXN0ZXJkYXkgKyAnICcgKyB0aW1lU3RyO1xuICAgICAgfVxuICB9IGVsc2Uge1xuICAgICAgY29uc3QgaXNZZXN0ZXJkYXkgPSBpc0RhdGVJblllc3RlcmRheShkYXRlKTtcbiAgICAgIGlmIChpc1llc3RlcmRheSkge1xuICAgICAgICAgIGNvbnN0IHRpbWVTdHIgPSBmb3JtYXREYXRlKGRhdGUsIFwiSEg6bW1cIik7XG4gICAgICAgICAgcmV0dXJuICRpMThuLm5fY29udGVudF9kYXRlX3llc3RlcmRheSArICcgJyArIHRpbWVTdHI7XG4gICAgICB9XG4gICAgICBjb25zdCBub3cgPSBuZXcgRGF0ZSgpO1xuICAgICAgY29uc3QgaXNTYW1lWWVhciA9IGRhdGUuZ2V0RnVsbFllYXIoKSA9PT0gbm93LmdldEZ1bGxZZWFyKCk7XG4gICAgICBpZiAoaXNTYW1lWWVhcikge1xuICAgICAgICAgIHJldHVybiBmb3JtYXREYXRlKGRhdGUsIFwiTU0tZGQgSEg6bW1cIik7XG4gICAgICB9IGVsc2Uge1xuICAgICAgICAgIHJldHVybiBmb3JtYXREYXRlKGRhdGUsIFwieXl5eS1NTS1kZCBISDptbVwiKTtcbiAgICAgIH1cbiAgfVxufVxuXG4vLyDliKTmlq3nu5nlrprml6XmnJ/mmK/lkKbmmK/ku4rlpKnnmoTovoXliqnlh73mlbBcbmZ1bmN0aW9uIGlzRGF0ZUluVG9kYXkoZGF0ZSkge1xuICBjb25zdCB0b2RheSA9IG5ldyBEYXRlKCk7XG4gIHJldHVybiAoXG4gICAgICBkYXRlLmdldEZ1bGxZZWFyKCkgPT09IHRvZGF5LmdldEZ1bGxZZWFyKCkgJiZcbiAgICAgIGRhdGUuZ2V0TW9udGgoKSA9PT0gdG9kYXkuZ2V0TW9udGgoKSAmJlxuICAgICAgZGF0ZS5nZXREYXRlKCkgPT09IHRvZGF5LmdldERhdGUoKVxuICApO1xufVxuXG4vLyDliKTmlq3nu5nlrprml6XmnJ/mmK/lkKbmmK/mmKjlpKnnmoTovoXliqnlh73mlbBcbmZ1bmN0aW9uIGlzRGF0ZUluWWVzdGVyZGF5KGRhdGUpIHtcbiAgY29uc3QgeWVzdGVyZGF5ID0gbmV3IERhdGUoKTtcbiAgeWVzdGVyZGF5LnNldERhdGUoeWVzdGVyZGF5LmdldERhdGUoKSAtIDEpO1xuICByZXR1cm4gKFxuICAgICAgZGF0ZS5nZXRGdWxsWWVhcigpID09PSB5ZXN0ZXJkYXkuZ2V0RnVsbFllYXIoKSAmJlxuICAgICAgZGF0ZS5nZXRNb250aCgpID09PSB5ZXN0ZXJkYXkuZ2V0TW9udGgoKSAmJlxuICAgICAgZGF0ZS5nZXREYXRlKCkgPT09IHllc3RlcmRheS5nZXREYXRlKClcbiAgKTtcbn1cblxuLy8g5oyJ54Wn5oyH5a6a5qC85byP5qC85byP5YyW5pel5pyf5Li65a2X56ym5Liy55qE5Ye95pWwXG5mdW5jdGlvbiBmb3JtYXREYXRlKGRhdGUsIGZvcm1hdCkge1xuICBjb25zdCB5ZWFyID0gZGF0ZS5nZXRGdWxsWWVhcigpO1xuICBjb25zdCBtb250aCA9IChcIjBcIiArIChkYXRlLmdldE1vbnRoKCkgKyAxKSkuc2xpY2UoLTIpO1xuICBjb25zdCBkYXkgPSAoXCIwXCIgKyBkYXRlLmdldERhdGUoKSkuc2xpY2UoLTIpO1xuICBjb25zdCBob3VycyA9IChcIjBcIiArIGRhdGUuZ2V0SG91cnMoKSkuc2xpY2UoLTIpO1xuICBjb25zdCBtaW51dGVzID0gKFwiMFwiICsgZGF0ZS5nZXRNaW51dGVzKCkpLnNsaWNlKC0yKTtcbiAgcmV0dXJuIGZvcm1hdFxuICAgIC5yZXBsYWNlKFwieXl5eVwiLCB5ZWFyKVxuICAgIC5yZXBsYWNlKFwiTU1cIiwgbW9udGgpXG4gICAgLnJlcGxhY2UoXCJkZFwiLCBkYXkpXG4gICAgLnJlcGxhY2UoXCJISFwiLCBob3VycylcbiAgICAucmVwbGFjZShcIm1tXCIsIG1pbnV0ZXMpO1xufVxuXG5mdW5jdGlvbiByZW1vdmVOZXdMaW5lcyh0ZXh0KSB7XG4gIGlmICh0eXBlb2YgdGV4dCE9PSBcInN0cmluZ1wiKSB7XG4gICAgICAvLyDlpoLmnpzkvKDlhaXnmoTkuI3mmK/lrZfnrKbkuLLnsbvlnovvvIzov5Tlm57nqbrlrZfnrKbkuLLmiJbogIXlj6/ku6XmoLnmja7pnIDmsYLmipvlh7rplJnor6/nrYnlpITnkIbmlrnlvI9cbiAgICAgIHJldHVybiBcIlwiO1xuICB9XG4gIGxldCBzdHJBcnJheSA9IHRleHQuc3BsaXQoXCJcXG5cIik7XG4gIHJldHVybiBzdHJBcnJheS5qb2luKFwiXCIpO1xufVxuXG5mdW5jdGlvbiBzaG93TG9hZGluZyhpc1Nob3cgPSB0cnVlKSB7XG4gICRuYXRpdmVBUEkuc2hvd0xvYWRpbmcoaXNTaG93ID8gMSA6IDApO1xufVxuXG4vLyBzdGFydCgpIiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gJy4vY29tbW9uJ1xuaW1wb3J0ICogYXMgZGV0YWlsIGZyb20gJy4vZGV0YWlsJ1xuXG5mdW5jdGlvbiBzZW5kQ29tbW9uQ29uZmlnKHBhcmFtKSB7XG4gICAgY29tbW9uLnNlbmRDb21tb25Db25maWcocGFyYW0pO1xufVxuXG4kZXZlbnQuc2VuZENvbW1vbkNvbmZpZyA9IHNlbmRDb21tb25Db25maWc7Il0sIm5hbWVzIjpbInRhZyIsInVwQ29sb3JMaXN0IiwiZG93bkNvbG9yTGlzdCIsImNvbW1vbkRhdGEiLCJzdGF0dXNIZWlnaHQiLCJwcmljZUNvbG9yVHlwZSIsImNvbG9yTW9kZSIsIk9TIiwiYXBwVmVyc2lvbiIsImlzSW5SZXZpZXciLCJpc0xvZ2luIiwid2ViVXJsIiwibGFuZ3VhZ2UiLCJuYXZiYXJIZWlnaHQiLCJzdGF0dXNCYXJIZWlnaHQiLCJoYXNUcmFkZXJSaWdodCIsIm1vZHVsZURlZmluZSIsIm1vZHVsZU5hbWUiLCJkZWZhdWx0RGF0YUZ1bmN0aW9uIiwiZnVuY3Rpb25zIiwib25DcmVhdGUiLCJvbkRlc3Ryb3kiLCJvblJlc3VtZSIsIm9uUGF1c2UiLCJvblN0YXJ0Iiwib25TdG9wIiwiY29uc29sZSIsImxvZyIsIiRkYXRhIiwiJGV2ZW50IiwibW9kdWxlRGF0YSIsIm1vZHVsZUV2ZW50IiwiZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3kiLCJjdXJyZW5jeSIsImJhc2VVcmwiLCJ0b0xvd2VyQ2FzZSIsImFzeW5jIiwic2VuZENvbW1vbkNvbmZpZyIsInBhcmFtIiwiSlNPTiIsInN0cmluZ2lmeSIsInBhcnNlSW50IiwicmVkQ29sb3JMaXN0IiwiZ3JlZW5Db2xvckxpc3QiLCJzZW5kUmVxdWVzdCIsInBhdGgiLCJwYXJhbXMiLCJtZXRob2QiLCJob3N0VHlwZSIsImhlYWRlciIsInJlc3BvbnNlU3RyaW5nIiwiJG5hdGl2ZUFQSSIsInJlcXVlc3QiLCJyZXNwb25zZSIsInBhcnNlIiwiY29kZSIsImRhdGEiLCJtZXNzYWdlIiwic2hvd1RvYXN0IiwiZSIsImdldFByaWNlQ29sb3IiLCJyYXRpbyIsInJhdGlvX2FicyIsIk1hdGgiLCJhYnMiLCJjb2xvckxldmVsIiwiY29sb3JIZXhTdHIiLCJjb250YWluZXJCYWNrIiwic2F2ZSIsIm1vZHVsZSIsImtleSIsInN0b3JhZ2UiLCJhY3Rpb24iLCJuYW1lIiwicmVhZCIsInN0b3JhZ2VNb2R1bGVOYW1lIiwic3RvcmFnZVBhZ2VWcG5BbGVydEtleSIsInN0b3JhZ2VQYWdlQWxlcnRLZXkiLCJzdG9yYWdlTmV3c0FsZXJ0S2V5IiwiYWxlcnQiLCJ2cG5BbGVydFNob3ciLCJwYWdlVnBuQWxlcnRTaG93IiwicGFnZUFsZXJ0U2hvdyIsIm5ld3NBbGVydFNob3ciLCJjdXJyZW50Tm90TmVlZFNob3ciLCJzZWxOZXdzTW9kZSIsInNlbER5bmFtaWNNb2RlIiwidGlwVGl0bGUiLCIkaTE4biIsIm5fb3B0aW9uX2RlbGl2ZXJ5X3RpcCIsImhhc0R5bmFtaWMiLCJoYXNOZXdzIiwiQ2hhcnRQZXJpb2QiLCJQZXJpb2QyNCIsIm5fbm90aWZpY2F0aW9uX3B1c2hfbm9kaXN0dXJiX2hvdXIiLCJQZXJpb2Q3ZGF5Iiwibl9taW5pbmdfZGF5X3RleHQiLCJQZXJpb2QzMGRheSIsIlBlcmlvZDkwZGF5IiwiUGVyaW9kMXllYXIiLCJuX2hvdGNvaW5fcmFkYXJfeWVhciIsInNlbFNlY29uZENvbG9yIiwic2VsU2Vjb25kQmdDb2xvciIsIm5vcm1hbFNlY29uZENvbG9yIiwibm9ybWFsU2Vjb25kQmdDb2xvciIsInNlbFRpdGxlQ29sb3IiLCJub3JtYWxUaXRsZUNvbG9yIiwic2hvd1NvdXJjZVRpdGxlIiwibl9jb250ZW50X3RyYW5zbGF0ZV9zaG93X29yaWdpbmFsdGV4dCIsInNob3dDb250ZW50VGl0bGUiLCJuX2NvbnRlbnRfdHJhbnNsYXRlIiwiY29pbk5ld1BhZ2VObyIsImNvaW5EeW5hbWljSG90UGFnZU5vIiwiY29pbkR5bmFtaWNMYXN0UGFnZU5vIiwic2VsUGVyaW9kSW5kZXgiLCJzZWxDaGFydEluZGV4Iiwic2VsUG9zdEluZGV4Iiwic2VsTGlzdEluZGV4IiwiY29pbk5ld3NBcnJheSIsImNvaW5EeW5hbWljSG90QXJyYXkiLCJjb2luRHluYW1pY0xhc3RBcnJheSIsImxhc3RQb2ludExpc3RKc29uIiwic3RhcnQiLCJwbGF5TG90dGllIiwiY29uZmlnRGF0YSIsInJlcXVlc3REZXRhaWxJbmZvIiwicmVxdWVzdFBvc3RMaXN0RGF0YSIsInJlcXVlc3RDb2luTmV3cyIsInN0b3BMb3R0aWUiLCJsaXN0VGl0bGVzIiwiZWxpdGVQb3N0c1RpdGxlVmlzaWJpbGl0eSIsImVsaXRlUG9zdHNUaXRsZUNvbG9yIiwibGlzdCIsImZpbHRlckJ1dHRvblZpc2liaWxpdHkiLCJuZXdzVGl0bGVUaXRsZVZpc2liaWxpdHkiLCJuZXdzVGl0bGVDb2xvciIsInBhZ2VWaXNpYmlsaXR5Q29uaWciLCJsaXN0VmlzaWJpbGl0eSIsImxvYWRpbmdWaXNpYmlsaXR5IiwibG9hZGluZ0xvdHRpZVN0YXR1cyIsImRlZmF1bHREYXRhIiwicmVmcmVzaFN0YXR1cyIsImxvYWRNb3JlU3RhdHVzIiwicGVyaW9kSW5kZXgiLCJjb2luIiwiY29pblByaWNlIiwiY29pblByaWNlUmFuZ2UiLCJjb2luUHJpY2VSYW5nZVRleHRDb2xvciIsIm1hcmtldFNlbnRpbWVudCIsInRpdGxlIiwibl9ob3Rjb2luX3JhZGFyX21hcmtldF9zZW50aW1lbnQiLCJidWxsaXNoVGl0bGUiLCJidWxsaXNoQ29sb3IiLCJidWxsaXNoVmFsdWUiLCJidWxsaXNoSW1hZ2VWaXNpYmlsaXR5IiwiYmVhcmlzaFRpdGxlIiwiYmVhcmlzaENvbG9yIiwiYmVhcmlzaFZhbHVlIiwiYmVhcmlzaEltYWdlVmlzaWJpbGl0eSIsImVsaXRlUG9zdHNUaXRsZSIsIm5faG90Y29pbl9yYWRhcl9zZWxlY3RlZCIsIm5ld3NUaXRsZSIsIm5faG90Y29pbl9yYWRhcl9uZXdzIiwiaG90VGl0bGUiLCJuX2NvbW11bml0eV9ob3QiLCJob3RUaXRsZUNvbG9yIiwiaG90VGl0bGVCYWNrZ3JvdW5kQ29sb3IiLCJsYXN0VGl0bGUiLCJuX2hvbWVfZmVlZF90YWJfbmV3cyIsImxhc3RUaXRsZUNvbG9yIiwibGFzdFRpdGxlQmFja2dyb3VuZENvbG9yIiwiaXRlbVRpdGxlIiwic291cmNlVGl0bGUiLCJpbnRlcmFjdGlvbnNUaXRsZSIsIm5faG90Y29pbl9yYWRhcl9udW1iZXJfaW50ZXJhY3Rpb24iLCJ0cmFkZVRpdGxlIiwibl9uZXdfdXNlcl9ndWlkZV90cmFkZSIsInRvcENoYXJ0UG9wTGlzdCIsInR5cGUiLCJuX3Nwb3Rfb3JkZXJfcHJpY2UiLCJpbmRleCIsInRleHRDb2xvciIsInNlbEltYWdlVmlzaWJpbGl0eSIsInNlbGVjdGVkIiwibl9ob3Rjb2luX3JhZGFyX251bWJlcl9tZW50aW9ucyIsIm5faG90Y29pbl9yYWRhcl9ydWxpbmdfcmF0ZSIsIm5faG90Y29pbl9yYWRhcl9idWxsaXNoX3NlbnRpbWVudCIsInBvaW50TGlzdEpzb24iLCJ0aXBBbGVydFRpdGxlIiwidGlwQWxlcnRDb250ZW50IiwicGVyaW9kTGlzdCIsInRleHQiLCJ0ZXh0Rm9udFdlaWdodCIsImJhY2tncm91bmRDb2xvciIsImNoYXJ0U2VsZWN0b3JUaXRsZSIsInRvcEljb24iLCJ0b3BUaXRsZSIsInN5bWJvbCIsInBsYWNlaG9sZGVyIiwib25lIiwibGVmdCIsInNtYWxsIiwiY29tbW9uLm1vZHVsZURlZmluZSIsImpzb25QYXJhbWV0ZXJzIiwic3RhdHVzQmFyQ29uZmlnIiwic3RhdHVzQmFyTW9kZSIsImFkU3RhdHVzQmFyQ29sb3IiLCJwYXJhbWV0ZXIiLCJjb21tb24udGFnIiwiY29tbW9uLmdldFBOR0ljb25VUkxCeUN1cnJlbmN5IiwidHJhZGVNYXJnaW5Cb3R0b20iLCJjb21tb24uY29tbW9uRGF0YSIsInByb3BlcnRpZXMiLCJwYWdlIiwicHJvcGVydGllc0pzb24iLCJtYXAiLCJldmVudCIsImFuYWx5dGljcyIsImNvbmZpZ1RpcEFsZXJ0VGl0bGUiLCJuX2NvcHlfdHJhZGluZ190aXAiLCJjb250ZW50IiwiYnV0dG9uVHlwZSIsIm5vUmVtaW5kZXJTaG93Iiwic2hvd0NvbnRpbnVlIiwic2hvd0lLbm93Iiwibm9SZW1pbmRlckltYWdlIiwicGFnZU5vIiwicGFnZVNpemUiLCJ0b1N0cmluZyIsImNvbW1vbi5zZW5kUmVxdWVzdCIsImxpc3REYXRhIiwibGVuZ3RoIiwiZGF0YUFyciIsImhhbmRsZUVsaXRlUG9zdHMiLCJrbGluZVR5cGVMaXN0IiwicGVyaW9kIiwiZ2V0UGVyaW9kU3RyaW5nIiwic2hvd0xvYWRpbmciLCJoYW5kbGVEZXRhaWxJbmZvIiwib25SZWZyZXNoIiwib25Mb2FkTW9yZSIsImFyciIsInB1c2giLCJmb3JFYWNoIiwiZWxlbWVudCIsInRyYWRlQWN0aW9uIiwib3BlblJvdXRlIiwibW9kdWxlX25hbWUiLCJzZWxlY3RlZEhvdEFjdGlvbiIsImFuYWx5dGljc0FwcENsaWNrUmVjb21Db2luRGV0YWlsIiwic2VsZWN0ZWRMYXN0QWN0aW9uIiwiZWxpdGVQb3N0c0FjdGlvbiIsInNlbGVjdGVkTmV3c0FjdGlvbiIsIm1hcmtldFNlbnRpbWVudEluZm9BY3Rpb24iLCJuX2hvdGNvaW5fcmFkYXJfbWFya2V0X3NlbnRpbWVudF9leHBsYW5hdGlvbiIsInRpcEFsZXJ0U2hvdyIsImltYWdlU2VsZWN0ZWQiLCJpbWFnZUluZGV4IiwiaXRlbUluZGV4IiwiaXRlbSIsImltZ0xpc3QiLCJpbWFnZUxpc3QiLCJyYXdBcnJheSIsImN1cnJlbnRJbmRleCIsIm9wZW5QcmV2aWV3SW1hZ2UiLCJzb3VyY2VJdGVtU2VsZWN0ZWQiLCJpIiwibW9kZWwiLCJzaG93U291cmNlIiwic2hvd0NvbnRlbnQiLCJwYXJlbnREeW5hbWljQ29udGVudCIsInBhcmVudER5bmFtaWMiLCJzb3VyY2VDb250ZW50Iiwic291cmNlUGFyZW50RHluYW1pYyIsImNlbGxTZWxlY3RlZCIsInNlbEluZGV4IiwiZHluYW1pY0lkIiwibmV3c0FsZXJ0U2hvd24iLCJjb21tb24ucmVhZCIsInNvdXJjZUxpbmsiLCJuX2hvdGNvaW5fcmFkYXJfdGlwX2NvbnRpbnVlX2FjY2Vzc2luZ19saW5rIiwicGFnZVNob3duIiwicGFnZVZwblNob3duIiwib3BlbkR5bmFtaWMiLCJuX2hvdGNvaW5fcmFkYXJfdGlwX3R1cm5fb25feCIsImNsZWFyQWxlcnRTaG93U3RhdHVzIiwiYXJyYXkiLCJoYW5kbGVFbGl0ZVBvc3RzTW9kZWwiLCJuaWNrbmFtZSIsImF2YXRhciIsImF1dGhVcmwiLCJwb3N0SWQiLCJsYW5ndWFnZUlkIiwic291cmNlTGFuZ3VhZ2VJZCIsIlN0cmluZyIsInB1Ymxpc2hUaW1lIiwidG9Gb3JtYXRlZERldGFpbERhdGUiLCJzb3VyY2VWaXNpYmlsaXR5IiwiaXNTb3VyY2UiLCJpbWFnZUNvbXBvbmVuVmlzaWJpbGl0eSIsIm9uZUltYWdlVmlzaWJpbGl0eSIsInR3b0ltYWdlVmlzaWJpbGl0eSIsInRocmVlSW1hZ2VWaXNpYmlsaXR5IiwiZm91ckltYWdlVmlzaWJpbGl0eSIsImltYWdlT25lIiwiaW1hZ2VUd28iLCJpbWFnZVRocmVlIiwiaW1hZ2VGb3VyIiwicGFyZW50RHluYW1pY0NvbXBvbmVuVmlzaWJpbGl0eSIsImludGVyYWN0aW9ucyIsImludGVyYWN0aW9uc1N0cmluZyIsImNvbnZlcnRTdHJpbmciLCJoYW5kbGVOZXdzIiwiaGFuZGxlTmV3c0l0ZW0iLCJuZXdzQ29udGVudCIsIm5ld3NTb3VjZSIsIm5ld3NUaW1lIiwibmV3c0lkIiwiY2xpY2tlZENoYXJ0U2VsZWN0b3IiLCJzaG93Q2hhcnRQb3AiLCJjbGlja2VkQ2hhcnRTZWxlY3RvckNhbmNlbCIsImNsaWNrZWRDaGFydE1lbnVJdGVtIiwibGFzdEl0ZW0iLCJzZWxJdGVtIiwidHlwZVN0ciIsImNsaWNrZWRQZXJpb2RJdGVtIiwicHJvcGVydGllc01hcCIsImNvbW1vbi5nZXRQcmljZUNvbG9yIiwiYnVsbGlzaCIsInBhcnNlRmxvYXQiLCJzZW50aW1lbnQiLCJ0b0ZpeGVkIiwiYmVhcmlzaCIsIm5faG90Y29pbl9yYWRhcl9idWxsaXNoIiwibl9ob3Rjb2luX3JhZGFyX2JlYXJpc2giLCJrbGluZSIsInBvaW50TGlzdCIsInhMaXN0IiwiaiIsImNoYXJ0SXRlbSIsInBvcEl0ZW0iLCJvcmlnaW5hbFZhbHVlIiwibnVtYmVyIiwidGltZU51bSIsInRpbWUiLCJwb3B1cERhdGUiLCJ0aW1lc3RhbXBUb01NREQiLCJ0aW1lc3RhbXBUb0hIbW0iLCJwb3B1cENvbnRlbnQiLCJhbW91bnRTdHJpbmciLCJ4VGltZSIsImhhbmRsZVhMaXN0IiwibGlzdE1hcCIsImpzb24iLCJtaWRJbmRleCIsImZsb29yIiwibGV0Zk1pZEluZGV4IiwicmlnaHRNaWRJbmRleCIsImxlZnRNaWQiLCJtaWQiLCJyaWdodE1pZCIsImVuZCIsInRpbWVzdGFtcCIsIm11bHRpcGxpZXIiLCJkYXRlIiwiRGF0ZSIsImdldEZ1bGxZZWFyIiwibW9udGgiLCJnZXRNb250aCIsInNsaWNlIiwiZGF5IiwiZ2V0RGF0ZSIsImhvdXJzIiwiZ2V0SG91cnMiLCJtaW51dGVzIiwiZ2V0TWludXRlcyIsImZvcm1hdHRlZEhvdXJzIiwicGFkU3RhcnQiLCJmb3JtYXR0ZWRNaW51dGVzIiwiY2xpY2tlZFRpcENhbmNlbCIsImNsaWNrZWRDb250aW51ZSIsInNob3ciLCJjb21tb24uc2F2ZSIsIm5faG90Y29pbl9yYWRhcl90aXBfdHVybl9vbl92cG4iLCJjbGVhciIsInNlbE1vZGVsIiwibGluayIsImluZGV4T2YiLCJjbGlja2VkSUtub3ciLCJjbGlja2VkTm9SZW1pbmRlciIsImJhY2tDbGlja2VkIiwiY29tbW9uLmNvbnRhaW5lckJhY2siLCJ0aW1lSW50ZXJ2YWwiLCJuX2NvbnRlbnRfZGF0ZV9qdXN0bm93IiwiJGludGVyY2VwdCIsIm5fY29udGVudF9kYXRlX21pbnV0ZXNhZ28iLCJpc1RvZGF5IiwiaXNEYXRlSW5Ub2RheSIsImhvdXIiLCJuX2NvbnRlbnRfZGF0ZV9ob3Vyc2FnbyIsInRpbWVTdHIiLCJmb3JtYXREYXRlIiwibl9jb250ZW50X2RhdGVfeWVzdGVyZGF5IiwiaXNZZXN0ZXJkYXkiLCJpc0RhdGVJblllc3RlcmRheSIsIm5vdyIsImlzU2FtZVllYXIiLCJ0b2RheSIsInllc3RlcmRheSIsInNldERhdGUiLCJmb3JtYXQiLCJ5ZWFyIiwicmVwbGFjZSIsImlzU2hvdyIsImNvbW1vbi5zZW5kQ29tbW9uQ29uZmlnIl0sIm1hcHBpbmdzIjoiQUFBTyxNQUFNQSxNQUFNOztBQWdCbkIsSUFBSUM7O0FBQ0osSUFBSUM7O0FBR0csSUFBSUMsYUFBYTtJQUN0QkMsY0FBYztJQUNkQyxnQkFBZ0I7SUFDaEJDLFdBQVc7SUFDWEMsSUFBSTtJQUNKQyxZQUFZO0lBQ1pDLFlBQVk7SUFDWkMsU0FBUztJQUNUQyxRQUFRO0lBQ1JDLFVBQVU7SUFDVkMsY0FBYztJQUNkQyxpQkFBaUI7SUFDakJDLGdCQUFnQjs7O0FBR1gsU0FBU0MsYUFBYUMsWUFBWUMscUJBQXFCQyxZQUFZO0lBQUVDLFVBQUFBO0lBQVVDO0lBQVNDLFVBQUVBO0lBQVVDO0lBQVNDO0lBQU9DLFFBQUVBOztJQUN6SEMsUUFBUUMsSUFBSSxjQUFjVjtJQUMxQlcsTUFBTVgsY0FBY0M7SUFDcEJXLE9BQU9aLGNBQWM7UUFDakJHLGlCQUFpQkQsVUFBVUMsWUFBWSxjQUFjQSxhQUFXRCxVQUFV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
