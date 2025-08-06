var nativeData = {
    isLogin: 0,
    platform: 2,
    nightMode: 0,
    uid: "",
    nickName: "",
    account: "",
    hasNewVersion: false,
    language: "",
    flaghost: "",
    webhost: "",
    childAccount: false,
    pro_status: -1
};

function generateParams(path, params = "", method = 0, hostType = 0, header = "") {
    const param = {
        path: path,
        method: method,
        hostType: hostType,
        header: header,
        params: params
    };
    console.log("generateParams:%o", param);
    return JSON.stringify(param);
}

async function contentAction(action, data) {
    return await $nativeAPI.contentBridge({
        action: action,
        data: data
    });
}

function setNativeData(data) {
    nativeData = data;
}

function getNativeData() {
    return nativeData;
}

$data.nav = {
    contentNavList: [],
    newsNavList: [],
    deepNavList: [],
    allNavList: [],
    saveNavStatus: -1,
    girdDataList: [],
    tabSelectList: []
};

$event.nav = {
    initNativeData(nativeJson) {
        setNativeData(JSON.parse(nativeJson));
    },
    getContentNav() {
        getContentNavigation();
    },
    getNewsNav() {
        getNewsNavigation();
    },
    getDeepNav() {
        getDeepNavigation();
    },
    getAllNewsNav() {
        getAllNewsNavigation();
    },
    initSelectionItem(jsonParams) {
        initSelectionItem(jsonParams);
    },
    onItemClick(position) {
        onItemClick(position);
    },
    saveNav(params) {
        saveNavigation(params);
    },
    getSelectedItem() {
        getSelectedItem();
    }
};

async function getContentNavigation() {
    const requestParams = generateParams("v1/content/community/nav/list", "", 0, 0);
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (code == 200 && data.length > 0) {
            $data.nav.contentNavList = data;
        }
    } catch (e) {
        console.error(`getContentNavigation error:${e}`);
    }
}

async function getNewsNavigation() {
    const requestParams = generateParams("v1/content/newsflash/api/category-list", "", 0, 0);
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (code == 200 && data.length > 0) {
            $data.nav.newsNavList = data;
        }
    } catch (e) {
        console.error(`getNewsNavigation error:${e}`);
    }
}

async function getDeepNavigation() {
    const requestParams = generateParams("v1/content/news/category-v1-list", "", 0, 0);
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (code == 200 && data.length > 0) {
            $data.nav.deepNavList = data;
        }
    } catch (e) {
        console.error(`getDeepNavigation error:${e}`);
    }
}

async function getAllNewsNavigation() {
    const requestParams = generateParams("v1/content/newsflash/api/all-category-list", "", 0, 0);
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (code == 200 && data.length > 0) {
            $data.nav.allNavList = data;
        }
    } catch (e) {
        console.error(`getAllNewsNavigation error:${e}`);
    }
}

async function initSelectionItem(jsonParams) {
    try {
        var params = JSON.parse(jsonParams);
        for (var i = 0; i < params.length; i++) {
            let item = params[i];
            if (item.isChoose == 1) {
                item.textColor = getNativeData().nightMode ? "#0094FF" : "#0173E5";
                item.backgroundColor = getNativeData().nightMode ? "#0F0094FF" : "#0F0173E5";
            } else {
                item.textColor = getNativeData().nightMode ? "#5E5E61" : "#8A8A8E";
                item.backgroundColor = getNativeData().nightMode ? "#313132" : "#FAFAFA";
            }
            item.index = i;
            item.cellType = "1";
        }
        $data.nav.girdDataList = params;
    } catch (e) {
        console.error(`initSelectionItem error:${e}`);
    }
}

function getSelectedItem() {
    try {
        const selectedItems = [];
        for (var i = 0; i < $data.nav.girdDataList.length; i++) {
            let item = $data.nav.girdDataList[i];
            console.log(`selectedItems ${item.isChoose}`);
            if (item.isChoose == 1) {
                selectedItems.push(item.rawObject());
            }
        }
        console.log(`selectedItems ${JSON.stringify(selectedItems)}`);
        $data.nav.tabSelectList = selectedItems;
    } catch (e) {
        console.error(`getSelectedItem error:${e}`);
    }
}

async function onItemClick(idx) {
    try {
        var item = $data.nav.girdDataList[idx];
        if (item.isFixed == 0) {
            if (item.isChoose == 1) {
                item.textColor = getNativeData().nightMode ? "#5E5E61" : "#8A8A8E";
                item.backgroundColor = getNativeData().nightMode ? "#313132" : "#FAFAFA";
                item.isChoose = 0;
            } else {
                item.textColor = getNativeData().nightMode ? "#0094FF" : "#0173E5";
                item.backgroundColor = getNativeData().nightMode ? "#0F0094FF" : "#0F0173E5";
                item.isChoose = 1;
            }
        }
    } catch (e) {
        console.error(`onItemClick error:${e}`);
    }
}

async function saveNavigation(params) {
    var dict = {};
    dict["commandList"] = params;
    console.log(`saveNavigation ${params}`);
    const requestParams = generateParams("v1/content/community/nav/save", dict, 1, 0, {
        "Content-Type": "application/json"
    });
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        $data.nav.saveNavStatus = code;
    } catch (e) {
        $data.nav.saveNavStatus = -2;
        console.error(`saveNavigation error:${e}`);
    }
}

$data.nativeRes = {
    nativeRes: {}
};

$event.nativeRes = {
    initRes() {
        initAllRes();
    }
};

async function initAllRes() {
    $data.nativeRes.nativeRes.baseColorMajorTheme100 = getNativeData().nightMode ? "#0094FF" : "#0173E5";
    $data.nativeRes.nativeRes.baseColorPrimaryText = getNativeData().nightMode ? "#E6E6E6" : "#000000";
    $data.nativeRes.nativeRes.baseColorPrimaryText070 = getNativeData().nightMode ? "#B3F0F1F4" : "#B31C1C1E";
    $data.nativeRes.nativeRes.baseColorSecondaryText = getNativeData().nightMode ? "#5E5E61" : "#8A8A8E";
    $data.nativeRes.nativeRes.baseColorSecondaryTextNew = getNativeData().nightMode ? "#8C8C93" : "#565656";
    $data.nativeRes.nativeRes.baseColorThreeLevelText = getNativeData().nightMode ? "#333F54" : "#ADADB4";
    $data.nativeRes.nativeRes.baseColorContentBackground = getNativeData().nightMode ? "#1E1E1F" : "#FFFFFF";
    $data.nativeRes.nativeRes.baseColorInputBackground = getNativeData().nightMode ? "#313132" : "#F5F5F5";
    $data.nativeRes.nativeRes.bg_hot_comment = getNativeData().nightMode ? "#282829" : "#FAFAFA";
    $data.nativeRes.nativeRes.baseColorPrimarySeparator = getNativeData().nightMode ? "#333333" : "#DDDDDD";
    $data.nativeRes.nativeRes.eContentTabDialogBackground = getNativeData().nightMode ? "#161616" : "#FFFFFF";
    $data.nativeRes.nativeRes.informationComment = getNativeData().nightMode ? "@drawable/ic_information_comment_night" : "@drawable/ic_information_comment_light";
    $data.nativeRes.nativeRes.informationLike = getNativeData().nightMode ? "@drawable/information_like_night" : "@drawable/information_like_light";
    $data.nativeRes.nativeRes.informationLikeFocus = getNativeData().nightMode ? "@drawable/information_like_focus_night" : "@drawable/information_like_focus_light";
    $data.nativeRes.nativeRes.informationShare = getNativeData().nightMode ? "@drawable/information_news_share_night" : "@drawable/information_news_share_light";
    $data.nativeRes.nativeRes.coinTagBg = getNativeData().nightMode ? "#181B25" : "#F9F9F9";
}

function getNativeRes() {
    return $data.nativeRes.nativeRes;
}

var flashContentList = [];

var tempFlashList = [];

$data.flashNews = {
    refreshContent: [],
    loadMoreContent: [],
    allContentList: [],
    tempCategoryId: "",
    listRefreshStatus: "2",
    listLoadMoreStatus: "2"
};

$event.flashNews = {
    requestList(categoryId, isMore) {
        requestNewsList(categoryId, isMore);
    },
    itemClick(newsId, isComment) {
        contentAction("flashDetail", '{"id":' + newsId + ',"isComment":' + isComment + "}");
    },
    onPageChange(categoryId) {
        selPage$1(categoryId);
    },
    onRefresh() {
        requestNewsList($data.flashNews.tempCategoryId, false);
    },
    onLoadMore() {
        requestNewsList($data.flashNews.tempCategoryId, true);
    },
    coinTagClick(symbol) {
        contentAction("goToKline", symbol);
    },
    shareFlash(itemIndex) {
        contentAction("shareFlash", JSON.stringify(flashContentList[itemIndex]));
        flashContentList[itemIndex].shared += 1;
        $data.flashNews.allContentList = flashContentList;
    },
    like(itemIndex) {
        likeFlash(itemIndex);
    }
};

async function requestNewsList(categoryId, isMore) {
    $data.flashNews.tempCategoryId = categoryId;
    var dict = {};
    if (isMore) {
        if (flashContentList.length <= 0) return;
        var lastIssueTime = flashContentList[flashContentList.length - 1].issueTime;
        console.log(`flashContent.lastIssueTime==${lastIssueTime}`);
        dict["lastIssueTime"] = lastIssueTime + "";
    }
    dict["size"] = "20";
    dict["categoryId"] = categoryId;
    const requestParams = generateParams("v1/content/newsflash/api/page-list", dict, 0, 0);
    try {
        $data.flashNews.listRefreshStatus = "2";
        $data.flashNews.listLoadMoreStatus = "2";
        const responseString = await $nativeAPI.request(requestParams);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (data != null && data.length > 0) {
            var startIndex = flashContentList.length;
            for (var item of data) {
                item.itemIndex = startIndex;
                startIndex++;
                item.showTime = await contentAction("getTime", item.issueTime + "");
                if (item.rank == 0) {
                    item.circle = getNativeData().nightMode ? "@drawable/rectangle_news_point_night" : "@drawable/rectangle_news_point_light";
                    item.timeLine = getNativeData().nightMode ? "#333333" : "#E9EAED";
                } else {
                    item.circle = getNativeData().nightMode ? "@drawable/rectangle_news_point_hightlight_night" : "@drawable/rectangle_news_point_hightlight_light";
                    item.timeLine = getNativeData().nightMode ? "#0173E5" : "#0094FF";
                }
                var coinTags = item.coinTags;
                item.tagShowStatus = "gone";
                item.firstShowStatus = "gone";
                item.sndShowStatus = "gone";
                item.thrShowStatus = "gone";
                var coinTag = {};
                coinTag.coin = "";
                item.firstTag = coinTag;
                item.sndTag = coinTag;
                item.thrTag = coinTag;
                if (coinTags.length > 0) {
                    item.tagShowStatus = "visible";
                    item.firstTag = item.coinTags[0];
                    item.firstTag.icon = await contentAction("coinIcon", item.firstTag.coin);
                    item.firstTag.percent = await contentAction("coinPercent", item.firstTag.symbol);
                    item.firstTag.color = await contentAction("percentColor", item.firstTag.symbol);
                    item.firstShowStatus = "visible";
                }
                if (coinTags.length > 1) {
                    item.sndTag = item.coinTags[0];
                    item.sndTag.icon = await contentAction("coinIcon", item.sndTag.coin);
                    item.sndTag.percent = await contentAction("coinPercent", item.sndTag.symbol);
                    item.sndTag.color = await contentAction("percentColor", item.sndTag.symbol);
                    item.sndShowStatus = "visible";
                }
                if (coinTags.length > 2) {
                    item.thrTag = item.coinTags[0];
                    item.thrTag.icon = await contentAction("coinIcon", item.thrTag.coin);
                    item.thrTag.percent = await contentAction("coinPercent", item.thrTag.symbol);
                    item.thrTag.color = await contentAction("percentColor", item.thrTag.symbol);
                    item.thrShowStatus = "visible";
                }
                var hotComments = item.hotCommentList;
                item.firstHotStatus = "gone";
                item.sndHotStatus = "gone";
                item.thrHotStatus = "gone";
                const color1 = getNativeData().nightMode ? "#CFD3E9" : "#1C1C1C";
                const color2 = getNativeData().nightMode ? "#6D87A8" : "#8A8A8E";
                if (hotComments.length > 0) {
                    item.firstHotStatus = "visible";
                    item.firstHot = `<font color=${color1} size='14px'>${item.hotCommentList[0].hotComAuditor}:</font><font color=${color2} size='14px'>${item.hotCommentList[0].hotComment}</font>`;
                }
                if (hotComments.length > 1) {
                    item.sndHotStatus = "visible";
                    item.sndHot = `<font color=${color1} size='14px'>${item.hotCommentList[1].hotComAuditor}:</font><font color=${color2} size='14px'>${item.hotCommentList[1].hotComment}</font>`;
                }
                if (hotComments.length > 2) {
                    item.thrHotStatus = "visible";
                    item.thrHot = `<font color=${color1} size='14px'>${item.hotCommentList[2].hotComAuditor}:</font><font color=${color2} size='14px'>${item.hotCommentList[2].hotComment}</font>`;
                }
                item.praiseIcon = item.praiseStatus == 1 ? getNativeRes().informationLikeFocus : getNativeRes().informationLike;
                console.log("requestNewsList item == " + JSON.stringify(item));
            }
        }
        if (!isMore) {
            $data.flashNews.refreshContent = data;
            if (code == 200 && data.length > 0) {
                flashContentList = data;
                $data.flashNews.allContentList = flashContentList;
                tempFlashList[categoryId] = flashContentList;
            }
        } else {
            $data.flashNews.loadMoreContent = data;
            if (code == 200 && data.length > 0) {
                flashContentList.push(...data);
                $data.flashNews.allContentList = flashContentList;
                tempFlashList[categoryId] = flashContentList;
            }
        }
    } catch (e) {
        console.error(e.stack);
        console.error(`requestNewsList error:${e}`);
    }
}

async function selPage$1(categoryId) {
    $data.flashNews.tempCategoryId = categoryId;
    flashContentList = tempFlashList[categoryId];
    $data.flashNews.allContentList = flashContentList;
}

async function likeFlash(itemIndex) {
    try {
        var likeResult = await contentAction("like", '{"id":"' + flashContentList[itemIndex].id + '","cType":2}');
        const resJSON = JSON.parse(likeResult);
        const {praiseNum: praiseNum, praiseStatus: praiseStatus} = resJSON;
        flashContentList[itemIndex].praiseNum = praiseNum;
        flashContentList[itemIndex].praiseStatus = praiseStatus;
        flashContentList[itemIndex].praiseIcon = praiseStatus == 1 ? getNativeRes().informationLikeFocus : getNativeRes().informationLike;
        $data.flashNews.allContentList = flashContentList;
    } catch (e) {
        console.error(e.stack);
        console.error(`LikeFlash error:${e}`);
    }
}

var deepContentList = [];

var tempDeepList = [];

$data.deepNews = {
    code: 0,
    message: "",
    refreshContent: [],
    loadMoreContent: [],
    allContentList: [],
    tempCategoryId: "",
    listRefreshStatus: "2",
    listLoadMoreStatus: "2"
};

$event.deepNews = {
    requestList(categoryId, isMore) {
        requestDeepNewsList(categoryId, isMore);
    },
    itemClick(newsId) {
        contentAction("deepDetail", newsId + "");
    },
    onPageChange(categoryId) {
        selPage(categoryId);
    },
    onRefresh() {
        requestDeepNewsList($data.deepNews.tempCategoryId, false);
    },
    onLoadMore() {
        requestDeepNewsList($data.deepNews.tempCategoryId, true);
    }
};

async function requestDeepNewsList(categoryId, isMore) {
    $data.deepNews.tempCategoryId = categoryId;
    var dict = {};
    if (isMore) {
        if (deepContentList.length <= 0) return;
        var lastIssueTime = deepContentList[deepContentList.length - 1].news.issueTime;
        console.log(`longContent.lastIssueTime==${lastIssueTime}`);
        dict["issueTime"] = lastIssueTime + "";
    }
    dict["size"] = "20";
    dict["categoryId"] = categoryId;
    const requestParams = generateParams("v1/content/news/list", dict, 0, 0);
    try {
        $data.deepNews.listRefreshStatus = "2";
        $data.deepNews.listLoadMoreStatus = "2";
        const responseString = await $nativeAPI.request(requestParams);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (data != null && data.length > 0) {
            for (var item of data) {
                item.showTime = await contentAction("getFormatTime", item.news.issueTime + "");
            }
        }
        if (!isMore) {
            $data.deepNews.refreshContent = data;
            if (code == 200 && data.length > 0) {
                deepContentList = data;
                $data.deepNews.allContentList = deepContentList;
                tempDeepList[categoryId] = deepContentList;
            }
        } else {
            $data.deepNews.loadMoreContent = data;
            if (code == 200 && data.length > 0) {
                deepContentList.push(...data);
                $data.deepNews.allContentList = deepContentList;
                tempDeepList[categoryId] = deepContentList;
            }
        }
    } catch (e) {
        console.error(`requestLongContentList error:${e}`);
    }
}

async function selPage(categoryId) {
    $data.deepNews.tempCategoryId = categoryId;
    deepContentList = tempDeepList[categoryId];
    $data.deepNews.allContentList = deepContentList;
}

var upColorList;

var downColorList;

var commanData = {
    priceColorType: 0,
    marketData: {},
    colorMode: 0
};

async function handleSocketData(data) {
    commanData.marketData = Object.assign(commanData.marketData, data.data);
}

async function sendCommonConfig$1(param) {
    commanData.priceColorType = parseInt(param.priceColorType);
    commanData.colorMode = parseInt(param.colorMode);
    var redColorList = [ "#ADB0B2", "#E94359", "#DE2941", "#CE142B" ];
    var greenColorList = [ "#ADB0B2", "#00A171", "#008B61", "#006245" ];
    if (parseInt(commanData.priceColorType) == 0) {
        upColorList = redColorList;
        downColorList = greenColorList;
    } else {
        upColorList = greenColorList;
        downColorList = redColorList;
    }
    commanData.webUrl = param.webUrl;
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

function formatRatio(upDown) {
    let prefix = upDown > 0 ? "+" : "";
    return `${prefix}${upDown.toString()}%`;
}

async function openPage(page, params = {}) {
    await $nativeAPI.contentBridge({
        action: "openPage",
        type: "native",
        page: page,
        params: JSON.stringify(params)
    });
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

function getPNGIconURLByCurrency(currency) {
    let baseUrl = commanData.webUrl ? commanData.webUrl : "";
    return `${baseUrl}/-/x/hb/p/api/contents/currency/icon_png/${currency.toLowerCase()}.png`;
}

function defaultData() {
    return {
        tagList: []
    };
}

async function start() {}

const {moduleData: moduleData, moduleEvent: moduleEvent} = moduleDefine("coinTags", start, defaultData);

moduleEvent.getCoinList = async function(coinsData) {
    var array = [];
    const list = coinsData["list"];
    for (var i = 0; i < list.length; i++) {
        var obj = list[i];
        obj.index = String(i);
        obj.type = "1";
        const upDown = 0;
        obj.upDown = formatRatio(upDown);
        obj.ratioColor = getPriceColor(upDown);
        let symbol = obj.symbol.toLowerCase();
        const coinDict = commanData.marketData[symbol];
        if (coinDict != null) {
            const upDown = coinDict.decimalDelta.toFixed(2);
            obj.upDown = formatRatio(upDown);
            obj.ratioColor = getPriceColor(upDown);
        }
        obj.icon = getPNGIconURLByCurrency(obj.coin.toLowerCase()), array.push(obj);
    }
    moduleData.tagList = array;
};

function resetCoinListData() {
    var list = moduleData.tagList;
    for (let i = 0; i < list.length; i++) {
        var obj = list[i];
        let symbol = obj.symbol.toLowerCase();
        const coinDict = commanData.marketData[symbol];
        if (coinDict != null) {
            const upDown = coinDict.decimalDelta.toFixed(2);
            obj.upDown = formatRatio(upDown);
            obj.ratioColor = getPriceColor(upDown);
        }
    }
    moduleData.tagList = list;
}

moduleEvent.jumpToKline = async function jumpToKline(index) {
    if (index) {
        let i = parseInt(index);
        let model = moduleData.tagList[i];
        var param = {};
        param.coin = model.coin;
        param.symbol = model.symbol;
        await openPage("kline", param);
    }
};

function sendTopicData(attitudeInfo) {
    attitude.sendTopicData(attitudeInfo);
}

async function sendCommonConfig(param) {
    await sendCommonConfig$1(param);
}

async function sendSocketData(data) {
    if (data.type == "market") {
        console.log(data);
        await handleSocketData(data);
        resetCoinListData();
    }
}

$event.sendCommonConfig = sendCommonConfig;

$event.sendSocketData = sendSocketData;

$event.sendTopicData = sendTopicData;
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWFpbi5qcyIsInNvdXJjZXMiOlsiLi4vLi4vcmVwb3NpdG9yeS9zcmMvdXRpbC5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL2NvbnRlbnRfbmF2LmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvbmF0aXZlX3Jlcy5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL2ZsYXNoX25ld3MuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9kZWVwX25ld3MuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9jb21tb24uanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9jb2luX3RhZ3MuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9tYWluLmpzIl0sInNvdXJjZXNDb250ZW50IjpbInZhciBuYXRpdmVEYXRhID0ge1xuICAgIGlzTG9naW46IDAsXG4gICAgcGxhdGZvcm06IDIsXG4gICAgbmlnaHRNb2RlOiAwLFxuICAgIHVpZDogXCJcIixcbiAgICBuaWNrTmFtZTogXCJcIixcbiAgICBhY2NvdW50OiBcIlwiLFxuICAgIGhhc05ld1ZlcnNpb246IGZhbHNlLFxuICAgIGxhbmd1YWdlOiBcIlwiLFxuICAgIGZsYWdob3N0OiBcIlwiLFxuICAgIHdlYmhvc3Q6IFwiXCIsXG4gICAgY2hpbGRBY2NvdW50OiBmYWxzZSxcbiAgICBwcm9fc3RhdHVzOiAtMVxufVxuXG4vKipcbiAqIEBwYXJhbSB7U3RyaW5nfSBwYXRoIOi3r+W+hFxuICogQHBhcmFtIHtPYmplY3R9IHBhcmFtcyDlj4LmlbBcbiAqIEBwYXJhbSB7TnVtYmVyfSBtZXRob2QgZ2V077yaMCBwb3N077yaMVxuICogQHBhcmFtIHtOdW1iZXJ9IGhvc3RUeXBlIHVybEhvc3QgMO+8mmhiZ1xuICogQHBhcmFtIHtTdHJpbmd9IGhlYWRlciBoZWFkZXJcbiAqIEByZXR1cm5zIHtPYmplY3R9XG4gKi9cblxuZXhwb3J0IGZ1bmN0aW9uIGdlbmVyYXRlUGFyYW1zKHBhdGgsIHBhcmFtcyA9IFwiXCIsIG1ldGhvZCA9IDAsIGhvc3RUeXBlID0gMCwgaGVhZGVyID0gXCJcIikge1xuICAgIGNvbnN0IHBhcmFtID0ge1xuICAgICAgICBwYXRoLFxuICAgICAgICBtZXRob2QsXG4gICAgICAgIGhvc3RUeXBlLFxuICAgICAgICBoZWFkZXIsXG4gICAgICAgIHBhcmFtc1xuICAgIH07XG4gICAgY29uc29sZS5sb2coXCJnZW5lcmF0ZVBhcmFtczolb1wiLCBwYXJhbSk7XG4gICAgcmV0dXJuIEpTT04uc3RyaW5naWZ5KHBhcmFtKTtcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHJlYWxWYWx1ZVN0cmluZyhrZXksIHJlYWxWYWx1ZSA9IFtdKSB7XG4gICAgY29uc3QgcmVhbERpY3QgPSB7IGtleSwgcmVhbFZhbHVlIH07XG4gICAgcmV0dXJuIGF3YWl0ICRuYXRpdmVBUEkuaTE4bihKU09OLnN0cmluZ2lmeShyZWFsRGljdCkpO1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gY29udGVudEFjdGlvbihhY3Rpb24sIGRhdGEpIHtcbiAgICByZXR1cm4gYXdhaXQgJG5hdGl2ZUFQSS5jb250ZW50QnJpZGdlKHsgXCJhY3Rpb25cIjogYWN0aW9uLCBcImRhdGFcIjogZGF0YSB9KTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIHNldE5hdGl2ZURhdGEoZGF0YSkge1xuICAgIG5hdGl2ZURhdGEgPSBkYXRhXG59XG5cbmV4cG9ydCBmdW5jdGlvbiBnZXROYXRpdmVEYXRhKCkge1xuICAgIHJldHVybiBuYXRpdmVEYXRhXG59IiwiaW1wb3J0IHsgZ2VuZXJhdGVQYXJhbXMsIHJlYWxWYWx1ZVN0cmluZywgc2V0TmF0aXZlRGF0YSwgZ2V0TmF0aXZlRGF0YSB9IGZyb20gXCIuL3V0aWxcIlxuXG4kZGF0YS5uYXYgPSB7XG4gICAgY29udGVudE5hdkxpc3Q6IFtdLFxuICAgIG5ld3NOYXZMaXN0OiBbXSxcbiAgICBkZWVwTmF2TGlzdDogW10sXG4gICAgYWxsTmF2TGlzdDogW10sXG4gICAgc2F2ZU5hdlN0YXR1czogLTEsXG4gICAgZ2lyZERhdGFMaXN0OiBbXSxcbiAgICB0YWJTZWxlY3RMaXN0OiBbXVxufVxuXG4kZXZlbnQubmF2ID0ge1xuICAgIGluaXROYXRpdmVEYXRhKG5hdGl2ZUpzb24pIHtcbiAgICAgICAgc2V0TmF0aXZlRGF0YShKU09OLnBhcnNlKG5hdGl2ZUpzb24pKVxuICAgIH0sXG4gICAgZ2V0Q29udGVudE5hdigpIHtcbiAgICAgICAgZ2V0Q29udGVudE5hdmlnYXRpb24oKVxuICAgIH0sXG4gICAgZ2V0TmV3c05hdigpIHtcbiAgICAgICAgZ2V0TmV3c05hdmlnYXRpb24oKVxuICAgIH0sXG4gICAgZ2V0RGVlcE5hdigpIHtcbiAgICAgICAgZ2V0RGVlcE5hdmlnYXRpb24oKVxuICAgIH0sXG4gICAgZ2V0QWxsTmV3c05hdigpIHtcbiAgICAgICAgZ2V0QWxsTmV3c05hdmlnYXRpb24oKVxuICAgIH0sXG4gICAgaW5pdFNlbGVjdGlvbkl0ZW0oanNvblBhcmFtcykge1xuICAgICAgICBpbml0U2VsZWN0aW9uSXRlbShqc29uUGFyYW1zKVxuICAgIH0sXG4gICAgb25JdGVtQ2xpY2socG9zaXRpb24pIHtcbiAgICAgICAgb25JdGVtQ2xpY2socG9zaXRpb24pXG4gICAgfSxcbiAgICBzYXZlTmF2KHBhcmFtcykge1xuICAgICAgICAgICAgc2F2ZU5hdmlnYXRpb24ocGFyYW1zKVxuICAgICAgICB9LFxuICAgIGdldFNlbGVjdGVkSXRlbSgpIHtcbiAgICAgICAgZ2V0U2VsZWN0ZWRJdGVtKClcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIGdldENvbnRlbnROYXZpZ2F0aW9uKCkge1xuICAgIGNvbnN0IHJlcXVlc3RQYXJhbXMgPSBnZW5lcmF0ZVBhcmFtcygndjEvY29udGVudC9jb21tdW5pdHkvbmF2L2xpc3QnLCAnJywgMCwgMCk7XG4gICAgdHJ5IHtcbiAgICAgICAgY29uc3QgcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QocmVxdWVzdFBhcmFtcyk7XG4gICAgICAgIGNvbnN0IHJlc3BvbnNlID0gSlNPTi5wYXJzZShyZXNwb25zZVN0cmluZyk7XG4gICAgICAgIGNvbnN0IHsgY29kZSwgZGF0YSB9ID0gcmVzcG9uc2U7XG4gICAgICAgIGlmIChjb2RlID09IDIwMCAmJiBkYXRhLmxlbmd0aCA+IDApIHtcbiAgICAgICAgICAgICRkYXRhLm5hdi5jb250ZW50TmF2TGlzdCA9IGRhdGE7XG4gICAgICAgIH1cbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUuZXJyb3IoYGdldENvbnRlbnROYXZpZ2F0aW9uIGVycm9yOiR7ZX1gKTtcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIGdldE5ld3NOYXZpZ2F0aW9uKCkge1xuICAgIGNvbnN0IHJlcXVlc3RQYXJhbXMgPSBnZW5lcmF0ZVBhcmFtcygndjEvY29udGVudC9uZXdzZmxhc2gvYXBpL2NhdGVnb3J5LWxpc3QnLCAnJywgMCwgMCk7XG4gICAgdHJ5IHtcbiAgICAgICAgY29uc3QgcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QocmVxdWVzdFBhcmFtcyk7XG4gICAgICAgIGNvbnN0IHJlc3BvbnNlID0gSlNPTi5wYXJzZShyZXNwb25zZVN0cmluZyk7XG4gICAgICAgIGNvbnN0IHsgY29kZSwgZGF0YSB9ID0gcmVzcG9uc2U7XG4gICAgICAgIGlmIChjb2RlID09IDIwMCAmJiBkYXRhLmxlbmd0aCA+IDApIHtcbiAgICAgICAgICAgICRkYXRhLm5hdi5uZXdzTmF2TGlzdCA9IGRhdGE7XG4gICAgICAgIH1cbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUuZXJyb3IoYGdldE5ld3NOYXZpZ2F0aW9uIGVycm9yOiR7ZX1gKTtcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIGdldERlZXBOYXZpZ2F0aW9uKCkge1xuICAgIGNvbnN0IHJlcXVlc3RQYXJhbXMgPSBnZW5lcmF0ZVBhcmFtcygndjEvY29udGVudC9uZXdzL2NhdGVnb3J5LXYxLWxpc3QnLCAnJywgMCwgMCk7XG4gICAgdHJ5IHtcbiAgICAgICAgY29uc3QgcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QocmVxdWVzdFBhcmFtcyk7XG4gICAgICAgIGNvbnN0IHJlc3BvbnNlID0gSlNPTi5wYXJzZShyZXNwb25zZVN0cmluZyk7XG4gICAgICAgIGNvbnN0IHsgY29kZSwgZGF0YSB9ID0gcmVzcG9uc2U7XG4gICAgICAgIGlmIChjb2RlID09IDIwMCAmJiBkYXRhLmxlbmd0aCA+IDApIHtcbiAgICAgICAgICAgICRkYXRhLm5hdi5kZWVwTmF2TGlzdCA9IGRhdGE7XG4gICAgICAgIH1cbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUuZXJyb3IoYGdldERlZXBOYXZpZ2F0aW9uIGVycm9yOiR7ZX1gKTtcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIGdldEFsbE5ld3NOYXZpZ2F0aW9uKCkge1xuICAgIGNvbnN0IHJlcXVlc3RQYXJhbXMgPSBnZW5lcmF0ZVBhcmFtcygndjEvY29udGVudC9uZXdzZmxhc2gvYXBpL2FsbC1jYXRlZ29yeS1saXN0JywgJycsIDAsIDApO1xuICAgIHRyeSB7XG4gICAgICAgIGNvbnN0IHJlc3BvbnNlU3RyaW5nID0gYXdhaXQgJG5hdGl2ZUFQSS5yZXF1ZXN0KHJlcXVlc3RQYXJhbXMpO1xuICAgICAgICBjb25zdCByZXNwb25zZSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcpO1xuICAgICAgICBjb25zdCB7IGNvZGUsIGRhdGEgfSA9IHJlc3BvbnNlO1xuICAgICAgICBpZiAoY29kZSA9PSAyMDAgJiYgZGF0YS5sZW5ndGggPiAwKSB7XG4gICAgICAgICAgICAkZGF0YS5uYXYuYWxsTmF2TGlzdCA9IGRhdGE7XG4gICAgICAgIH1cbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUuZXJyb3IoYGdldEFsbE5ld3NOYXZpZ2F0aW9uIGVycm9yOiR7ZX1gKTtcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIGluaXRTZWxlY3Rpb25JdGVtKGpzb25QYXJhbXMpIHtcbiAgICB0cnkge1xuICAgICAgICB2YXIgcGFyYW1zID0gSlNPTi5wYXJzZShqc29uUGFyYW1zKTtcbiAgICAgICAgZm9yICh2YXIgaSA9IDA7IGkgPCBwYXJhbXMubGVuZ3RoOyBpKyspIHtcbiAgICAgICAgICAgIGxldCBpdGVtID0gcGFyYW1zW2ldO1xuICAgICAgICAgICAgaWYgKGl0ZW0uaXNDaG9vc2UgPT0gMSkge1xuICAgICAgICAgICAgICAgIGl0ZW0udGV4dENvbG9yID0gZ2V0TmF0aXZlRGF0YSgpLm5pZ2h0TW9kZSA/IFwiIzAwOTRGRlwiIDogXCIjMDE3M0U1XCI7XG4gICAgICAgICAgICAgICAgaXRlbS5iYWNrZ3JvdW5kQ29sb3IgPSBnZXROYXRpdmVEYXRhKCkubmlnaHRNb2RlID8gXCIjMEYwMDk0RkZcIiA6IFwiIzBGMDE3M0U1XCI7XG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgIGl0ZW0udGV4dENvbG9yID0gZ2V0TmF0aXZlRGF0YSgpLm5pZ2h0TW9kZSA/IFwiIzVFNUU2MVwiIDogXCIjOEE4QThFXCI7XG4gICAgICAgICAgICAgICAgaXRlbS5iYWNrZ3JvdW5kQ29sb3IgPSBnZXROYXRpdmVEYXRhKCkubmlnaHRNb2RlID8gXCIjMzEzMTMyXCIgOiBcIiNGQUZBRkFcIjtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGl0ZW0uaW5kZXggPSBpO1xuICAgICAgICAgICAgaXRlbS5jZWxsVHlwZSA9IFwiMVwiO1xuICAgICAgICB9XG4gICAgICAgICRkYXRhLm5hdi5naXJkRGF0YUxpc3QgPSBwYXJhbXM7XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICBjb25zb2xlLmVycm9yKGBpbml0U2VsZWN0aW9uSXRlbSBlcnJvcjoke2V9YCk7XG4gICAgfVxufVxuXG5mdW5jdGlvbiBnZXRTZWxlY3RlZEl0ZW0oKSB7XG4gICAgdHJ5IHtcbiAgICAgICAgY29uc3Qgc2VsZWN0ZWRJdGVtcyA9IFtdO1xuICAgICAgICBmb3IgKHZhciBpID0gMDsgaSA8ICRkYXRhLm5hdi5naXJkRGF0YUxpc3QubGVuZ3RoOyBpKyspIHtcbiAgICAgICAgICAgIGxldCBpdGVtID0gJGRhdGEubmF2LmdpcmREYXRhTGlzdFtpXTtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGBzZWxlY3RlZEl0ZW1zICR7aXRlbS5pc0Nob29zZX1gKTtcbiAgICAgICAgICAgIGlmIChpdGVtLmlzQ2hvb3NlID09IDEpIHtcbiAgICAgICAgICAgICAgICBzZWxlY3RlZEl0ZW1zLnB1c2goaXRlbS5yYXdPYmplY3QoKSk7XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICAgICAgY29uc29sZS5sb2coYHNlbGVjdGVkSXRlbXMgJHtKU09OLnN0cmluZ2lmeShzZWxlY3RlZEl0ZW1zKX1gKTtcbiAgICAgICAgJGRhdGEubmF2LnRhYlNlbGVjdExpc3QgPSBzZWxlY3RlZEl0ZW1zO1xuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5lcnJvcihgZ2V0U2VsZWN0ZWRJdGVtIGVycm9yOiR7ZX1gKTtcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIG9uSXRlbUNsaWNrKGlkeCkge1xuICAgIHRyeSB7XG4gICAgICAgIHZhciBpdGVtID0gJGRhdGEubmF2LmdpcmREYXRhTGlzdFtpZHhdO1xuICAgICAgICBpZiAoaXRlbS5pc0ZpeGVkID09IDApIHtcbiAgICAgICAgICAgIGlmIChpdGVtLmlzQ2hvb3NlID09IDEpIHtcbiAgICAgICAgICAgICAgICBpdGVtLnRleHRDb2xvciA9IGdldE5hdGl2ZURhdGEoKS5uaWdodE1vZGUgPyBcIiM1RTVFNjFcIiA6IFwiIzhBOEE4RVwiO1xuICAgICAgICAgICAgICAgIGl0ZW0uYmFja2dyb3VuZENvbG9yID0gZ2V0TmF0aXZlRGF0YSgpLm5pZ2h0TW9kZSA/IFwiIzMxMzEzMlwiIDogXCIjRkFGQUZBXCI7XG4gICAgICAgICAgICAgICAgaXRlbS5pc0Nob29zZSA9IDBcbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgaXRlbS50ZXh0Q29sb3IgPSBnZXROYXRpdmVEYXRhKCkubmlnaHRNb2RlID8gXCIjMDA5NEZGXCIgOiBcIiMwMTczRTVcIjtcbiAgICAgICAgICAgICAgICBpdGVtLmJhY2tncm91bmRDb2xvciA9IGdldE5hdGl2ZURhdGEoKS5uaWdodE1vZGUgPyBcIiMwRjAwOTRGRlwiIDogXCIjMEYwMTczRTVcIjtcbiAgICAgICAgICAgICAgICBpdGVtLmlzQ2hvb3NlID0gMVxuICAgICAgICAgICAgfVxuICAgICAgICB9XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICBjb25zb2xlLmVycm9yKGBvbkl0ZW1DbGljayBlcnJvcjoke2V9YCk7XG4gICAgfVxufVxuXG4vKipcbiAqIEBwYXJhbSB7U3RyaW5nfSBpZHMg5YiG57G7aWTvvIzpgJflj7fmi7zmjqVcbiAqIEBwYXJhbSB7TnVtYmVyfSB0b3BpY1R5cGUgMeW/q+iuryAy6ZW/5paHXG4gKiBAcmV0dXJucyB7T2JqZWN0fVxuICovXG5hc3luYyBmdW5jdGlvbiBzYXZlTmF2aWdhdGlvbihwYXJhbXMpIHtcbiAgICB2YXIgZGljdCA9IHt9O1xuICAgIGRpY3RbXCJjb21tYW5kTGlzdFwiXSA9IHBhcmFtcztcbiAgICBjb25zb2xlLmxvZyhgc2F2ZU5hdmlnYXRpb24gJHtwYXJhbXN9YCk7XG4gICAgY29uc3QgcmVxdWVzdFBhcmFtcyA9IGdlbmVyYXRlUGFyYW1zKCd2MS9jb250ZW50L2NvbW11bml0eS9uYXYvc2F2ZScsIGRpY3QsIDEsIDAsIHsgXCJDb250ZW50LVR5cGVcIjogXCJhcHBsaWNhdGlvbi9qc29uXCIgfSk7XG4gICAgdHJ5IHtcbiAgICAgICAgY29uc3QgcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QocmVxdWVzdFBhcmFtcyk7XG4gICAgICAgIGNvbnN0IHJlc3BvbnNlID0gSlNPTi5wYXJzZShyZXNwb25zZVN0cmluZyk7XG4gICAgICAgIGNvbnN0IHsgY29kZSwgZGF0YSB9ID0gcmVzcG9uc2U7XG4gICAgICAgICRkYXRhLm5hdi5zYXZlTmF2U3RhdHVzID0gY29kZTtcbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgICRkYXRhLm5hdi5zYXZlTmF2U3RhdHVzID0gLTI7XG4gICAgICAgIGNvbnNvbGUuZXJyb3IoYHNhdmVOYXZpZ2F0aW9uIGVycm9yOiR7ZX1gKTtcbiAgICB9XG59IiwiaW1wb3J0IHsgZ2V0TmF0aXZlRGF0YSB9IGZyb20gXCIuL3V0aWxcIlxuXG4kZGF0YS5uYXRpdmVSZXMgPSB7XG4gICAgbmF0aXZlUmVzOnt9XG59XG5cbiRldmVudC5uYXRpdmVSZXMgPSB7XG4gICAgaW5pdFJlcygpIHtcbiAgICAgICAgaW5pdEFsbFJlcygpXG4gICAgfVxufVxuXG5hc3luYyBmdW5jdGlvbiBpbml0QWxsUmVzKCkge1xuICAgICRkYXRhLm5hdGl2ZVJlcy5uYXRpdmVSZXMuYmFzZUNvbG9yTWFqb3JUaGVtZTEwMCA9IGdldE5hdGl2ZURhdGEoKS5uaWdodE1vZGUgPyBcIiMwMDk0RkZcIiA6IFwiIzAxNzNFNVwiO1xuICAgICRkYXRhLm5hdGl2ZVJlcy5uYXRpdmVSZXMuYmFzZUNvbG9yUHJpbWFyeVRleHQgPSBnZXROYXRpdmVEYXRhKCkubmlnaHRNb2RlID8gXCIjRTZFNkU2XCIgOiBcIiMwMDAwMDBcIjtcbiAgICAkZGF0YS5uYXRpdmVSZXMubmF0aXZlUmVzLmJhc2VDb2xvclByaW1hcnlUZXh0MDcwID0gZ2V0TmF0aXZlRGF0YSgpLm5pZ2h0TW9kZSA/IFwiI0IzRjBGMUY0XCIgOiBcIiNCMzFDMUMxRVwiO1xuICAgICRkYXRhLm5hdGl2ZVJlcy5uYXRpdmVSZXMuYmFzZUNvbG9yU2Vjb25kYXJ5VGV4dCA9IGdldE5hdGl2ZURhdGEoKS5uaWdodE1vZGUgPyBcIiM1RTVFNjFcIiA6IFwiIzhBOEE4RVwiO1xuICAgICRkYXRhLm5hdGl2ZVJlcy5uYXRpdmVSZXMuYmFzZUNvbG9yU2Vjb25kYXJ5VGV4dE5ldyA9IGdldE5hdGl2ZURhdGEoKS5uaWdodE1vZGUgPyBcIiM4QzhDOTNcIiA6IFwiIzU2NTY1NlwiO1xuICAgICRkYXRhLm5hdGl2ZVJlcy5uYXRpdmVSZXMuYmFzZUNvbG9yVGhyZWVMZXZlbFRleHQgPSBnZXROYXRpdmVEYXRhKCkubmlnaHRNb2RlID8gXCIjMzMzRjU0XCIgOiBcIiNBREFEQjRcIjtcbiAgICAkZGF0YS5uYXRpdmVSZXMubmF0aXZlUmVzLmJhc2VDb2xvckNvbnRlbnRCYWNrZ3JvdW5kID0gZ2V0TmF0aXZlRGF0YSgpLm5pZ2h0TW9kZSA/IFwiIzFFMUUxRlwiIDogXCIjRkZGRkZGXCI7XG4gICAgJGRhdGEubmF0aXZlUmVzLm5hdGl2ZVJlcy5iYXNlQ29sb3JJbnB1dEJhY2tncm91bmQgPSBnZXROYXRpdmVEYXRhKCkubmlnaHRNb2RlID8gXCIjMzEzMTMyXCIgOiBcIiNGNUY1RjVcIjtcbiAgICAkZGF0YS5uYXRpdmVSZXMubmF0aXZlUmVzLmJnX2hvdF9jb21tZW50ID0gZ2V0TmF0aXZlRGF0YSgpLm5pZ2h0TW9kZSA/IFwiIzI4MjgyOVwiIDogXCIjRkFGQUZBXCI7XG4gICAgJGRhdGEubmF0aXZlUmVzLm5hdGl2ZVJlcy5iYXNlQ29sb3JQcmltYXJ5U2VwYXJhdG9yID0gZ2V0TmF0aXZlRGF0YSgpLm5pZ2h0TW9kZSA/IFwiIzMzMzMzM1wiIDogXCIjREREREREXCI7XG4gICAgJGRhdGEubmF0aXZlUmVzLm5hdGl2ZVJlcy5lQ29udGVudFRhYkRpYWxvZ0JhY2tncm91bmQgPSBnZXROYXRpdmVEYXRhKCkubmlnaHRNb2RlID8gXCIjMTYxNjE2XCIgOiBcIiNGRkZGRkZcIjtcbiAgICAkZGF0YS5uYXRpdmVSZXMubmF0aXZlUmVzLmluZm9ybWF0aW9uQ29tbWVudCA9IGdldE5hdGl2ZURhdGEoKS5uaWdodE1vZGUgPyBcIkBkcmF3YWJsZS9pY19pbmZvcm1hdGlvbl9jb21tZW50X25pZ2h0XCIgOiBcIkBkcmF3YWJsZS9pY19pbmZvcm1hdGlvbl9jb21tZW50X2xpZ2h0XCI7XG4gICAgJGRhdGEubmF0aXZlUmVzLm5hdGl2ZVJlcy5pbmZvcm1hdGlvbkxpa2UgPSBnZXROYXRpdmVEYXRhKCkubmlnaHRNb2RlID8gXCJAZHJhd2FibGUvaW5mb3JtYXRpb25fbGlrZV9uaWdodFwiIDogXCJAZHJhd2FibGUvaW5mb3JtYXRpb25fbGlrZV9saWdodFwiO1xuICAgICRkYXRhLm5hdGl2ZVJlcy5uYXRpdmVSZXMuaW5mb3JtYXRpb25MaWtlRm9jdXMgPSBnZXROYXRpdmVEYXRhKCkubmlnaHRNb2RlID8gXCJAZHJhd2FibGUvaW5mb3JtYXRpb25fbGlrZV9mb2N1c19uaWdodFwiIDogXCJAZHJhd2FibGUvaW5mb3JtYXRpb25fbGlrZV9mb2N1c19saWdodFwiO1xuICAgICRkYXRhLm5hdGl2ZVJlcy5uYXRpdmVSZXMuaW5mb3JtYXRpb25TaGFyZSA9IGdldE5hdGl2ZURhdGEoKS5uaWdodE1vZGUgPyBcIkBkcmF3YWJsZS9pbmZvcm1hdGlvbl9uZXdzX3NoYXJlX25pZ2h0XCIgOiBcIkBkcmF3YWJsZS9pbmZvcm1hdGlvbl9uZXdzX3NoYXJlX2xpZ2h0XCI7XG4gICAgLy/luIHnp43moIfnrb7lhbzlrrlcbiAgICAkZGF0YS5uYXRpdmVSZXMubmF0aXZlUmVzLmNvaW5UYWdCZyA9IGdldE5hdGl2ZURhdGEoKS5uaWdodE1vZGUgPyBcIiMxODFCMjVcIiA6IFwiI0Y5RjlGOVwiXG59XG5cbmV4cG9ydCBmdW5jdGlvbiBnZXROYXRpdmVSZXMoKSB7XG4gICAgcmV0dXJuICRkYXRhLm5hdGl2ZVJlcy5uYXRpdmVSZXNcbn0iLCJpbXBvcnQgeyBnZW5lcmF0ZVBhcmFtcywgcmVhbFZhbHVlU3RyaW5nLCBjb250ZW50QWN0aW9uLCBnZXROYXRpdmVEYXRhIH0gZnJvbSBcIi4vdXRpbFwiXG5pbXBvcnQgeyBnZXROYXRpdmVSZXMgfSBmcm9tIFwiLi9uYXRpdmVfcmVzXCJcblxudmFyIGZsYXNoQ29udGVudExpc3Q9W107XG52YXIgdGVtcEZsYXNoTGlzdD1bXTtcblxuJGRhdGEuZmxhc2hOZXdzID0ge1xuICAgIHJlZnJlc2hDb250ZW50OiBbXSxcbiAgICBsb2FkTW9yZUNvbnRlbnQ6IFtdLFxuICAgIGFsbENvbnRlbnRMaXN0OiBbXSxcbiAgICB0ZW1wQ2F0ZWdvcnlJZDogXCJcIixcbiAgICBsaXN0UmVmcmVzaFN0YXR1czogXCIyXCIsXG4gICAgbGlzdExvYWRNb3JlU3RhdHVzOiBcIjJcIlxufVxuXG4kZXZlbnQuZmxhc2hOZXdzID0ge1xuICAgIHJlcXVlc3RMaXN0KGNhdGVnb3J5SWQsIGlzTW9yZSkge1xuICAgICAgICByZXF1ZXN0TmV3c0xpc3QoY2F0ZWdvcnlJZCwgaXNNb3JlKVxuICAgIH0sXG4gICAgaXRlbUNsaWNrKG5ld3NJZCwgaXNDb21tZW50KSB7XG4gICAgICAgIGNvbnRlbnRBY3Rpb24oXCJmbGFzaERldGFpbFwiLCAne1wiaWRcIjonICsgbmV3c0lkICsgJyxcImlzQ29tbWVudFwiOicgKyBpc0NvbW1lbnQgKyAnfScpXG4gICAgfSxcbiAgICBvblBhZ2VDaGFuZ2UoY2F0ZWdvcnlJZCkge1xuICAgICAgICBzZWxQYWdlKGNhdGVnb3J5SWQpXG4gICAgfSxcbiAgICBvblJlZnJlc2goKSB7XG4gICAgICAgIHJlcXVlc3ROZXdzTGlzdCgkZGF0YS5mbGFzaE5ld3MudGVtcENhdGVnb3J5SWQsIGZhbHNlKVxuICAgIH0sXG4gICAgb25Mb2FkTW9yZSgpIHtcbiAgICAgICAgcmVxdWVzdE5ld3NMaXN0KCRkYXRhLmZsYXNoTmV3cy50ZW1wQ2F0ZWdvcnlJZCwgdHJ1ZSlcbiAgICB9LFxuICAgIGNvaW5UYWdDbGljayhzeW1ib2wpIHtcbiAgICAgICAgY29udGVudEFjdGlvbihcImdvVG9LbGluZVwiLCBzeW1ib2wpXG4gICAgfSxcbiAgICBzaGFyZUZsYXNoKGl0ZW1JbmRleCkge1xuICAgICAgICBjb250ZW50QWN0aW9uKFwic2hhcmVGbGFzaFwiLCBKU09OLnN0cmluZ2lmeShmbGFzaENvbnRlbnRMaXN0W2l0ZW1JbmRleF0pKVxuICAgICAgICBmbGFzaENvbnRlbnRMaXN0W2l0ZW1JbmRleF0uc2hhcmVkICs9IDFcbiAgICAgICAgJGRhdGEuZmxhc2hOZXdzLmFsbENvbnRlbnRMaXN0ID0gZmxhc2hDb250ZW50TGlzdFxuICAgIH0sXG4gICAgbGlrZShpdGVtSW5kZXgpIHtcbiAgICAgICAgbGlrZUZsYXNoKGl0ZW1JbmRleClcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlcXVlc3ROZXdzTGlzdChjYXRlZ29yeUlkLCBpc01vcmUpIHtcbiAgICAkZGF0YS5mbGFzaE5ld3MudGVtcENhdGVnb3J5SWQgPSBjYXRlZ29yeUlkXG4gICAgdmFyIGRpY3QgPSB7fTtcbiAgICBpZiAoaXNNb3JlKSB7XG4gICAgICAgIGlmIChmbGFzaENvbnRlbnRMaXN0Lmxlbmd0aCA8PSAwKSByZXR1cm47XG4gICAgICAgIHZhciBsYXN0SXNzdWVUaW1lID0gZmxhc2hDb250ZW50TGlzdFtmbGFzaENvbnRlbnRMaXN0Lmxlbmd0aCAtIDFdLmlzc3VlVGltZTtcbiAgICAgICAgY29uc29sZS5sb2coYGZsYXNoQ29udGVudC5sYXN0SXNzdWVUaW1lPT0ke2xhc3RJc3N1ZVRpbWV9YCk7XG4gICAgICAgIGRpY3RbXCJsYXN0SXNzdWVUaW1lXCJdID0gbGFzdElzc3VlVGltZSArIFwiXCI7XG4gICAgfVxuICAgIGRpY3RbXCJzaXplXCJdID0gXCIyMFwiO1xuICAgIGRpY3RbXCJjYXRlZ29yeUlkXCJdID0gY2F0ZWdvcnlJZDtcbiAgICBjb25zdCByZXF1ZXN0UGFyYW1zID0gZ2VuZXJhdGVQYXJhbXMoJ3YxL2NvbnRlbnQvbmV3c2ZsYXNoL2FwaS9wYWdlLWxpc3QnLCBkaWN0LCAwLCAwKTtcbiAgICB0cnkge1xuICAgICAgICAkZGF0YS5mbGFzaE5ld3MubGlzdFJlZnJlc2hTdGF0dXMgPSBcIjJcIlxuICAgICAgICAkZGF0YS5mbGFzaE5ld3MubGlzdExvYWRNb3JlU3RhdHVzID0gXCIyXCJcbiAgICAgICAgY29uc3QgcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QocmVxdWVzdFBhcmFtcyk7XG4gICAgICAgIGNvbnN0IHJlc3BvbnNlID0gSlNPTi5wYXJzZShyZXNwb25zZVN0cmluZyk7XG4gICAgICAgIGNvbnN0IHtjb2RlLCBkYXRhfSA9IHJlc3BvbnNlO1xuICAgICAgICBpZiAoZGF0YSAhPSBudWxsICYmIGRhdGEubGVuZ3RoID4gMCkge1xuICAgICAgICAgICAgdmFyIHN0YXJ0SW5kZXggPSBmbGFzaENvbnRlbnRMaXN0Lmxlbmd0aFxuICAgICAgICAgICAgZm9yICh2YXIgaXRlbSBvZiBkYXRhKSB7XG4gICAgICAgICAgICAgICAgaXRlbS5pdGVtSW5kZXggPSBzdGFydEluZGV4XG4gICAgICAgICAgICAgICAgc3RhcnRJbmRleCsrXG4gICAgICAgICAgICAgICAgaXRlbS5zaG93VGltZSA9IGF3YWl0IGNvbnRlbnRBY3Rpb24oXCJnZXRUaW1lXCIsIGl0ZW0uaXNzdWVUaW1lICsgXCJcIilcbiAgICAgICAgICAgICAgICBpZiAoaXRlbS5yYW5rID09IDApIHtcbiAgICAgICAgICAgICAgICAgICAgaXRlbS5jaXJjbGUgPSBnZXROYXRpdmVEYXRhKCkubmlnaHRNb2RlID8gXCJAZHJhd2FibGUvcmVjdGFuZ2xlX25ld3NfcG9pbnRfbmlnaHRcIiA6IFwiQGRyYXdhYmxlL3JlY3RhbmdsZV9uZXdzX3BvaW50X2xpZ2h0XCJcbiAgICAgICAgICAgICAgICAgICAgaXRlbS50aW1lTGluZSA9IGdldE5hdGl2ZURhdGEoKS5uaWdodE1vZGUgPyBcIiMzMzMzMzNcIiA6IFwiI0U5RUFFRFwiXG4gICAgICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICAgICAgaXRlbS5jaXJjbGUgPSBnZXROYXRpdmVEYXRhKCkubmlnaHRNb2RlID8gXCJAZHJhd2FibGUvcmVjdGFuZ2xlX25ld3NfcG9pbnRfaGlnaHRsaWdodF9uaWdodFwiIDogXCJAZHJhd2FibGUvcmVjdGFuZ2xlX25ld3NfcG9pbnRfaGlnaHRsaWdodF9saWdodFwiXG4gICAgICAgICAgICAgICAgICAgIGl0ZW0udGltZUxpbmUgPSBnZXROYXRpdmVEYXRhKCkubmlnaHRNb2RlID8gXCIjMDE3M0U1XCIgOiBcIiMwMDk0RkZcIlxuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICB2YXIgY29pblRhZ3MgPSBpdGVtLmNvaW5UYWdzO1xuICAgICAgICAgICAgICAgIGl0ZW0udGFnU2hvd1N0YXR1cyA9IFwiZ29uZVwiXG4gICAgICAgICAgICAgICAgaXRlbS5maXJzdFNob3dTdGF0dXMgPSBcImdvbmVcIjtcbiAgICAgICAgICAgICAgICBpdGVtLnNuZFNob3dTdGF0dXMgPSBcImdvbmVcIjtcbiAgICAgICAgICAgICAgICBpdGVtLnRoclNob3dTdGF0dXMgPSBcImdvbmVcIjtcbiAgICAgICAgICAgICAgICB2YXIgY29pblRhZyA9IHt9XG4gICAgICAgICAgICAgICAgY29pblRhZy5jb2luID0gXCJcIlxuICAgICAgICAgICAgICAgIGl0ZW0uZmlyc3RUYWcgPSBjb2luVGFnXG4gICAgICAgICAgICAgICAgaXRlbS5zbmRUYWcgPSBjb2luVGFnXG4gICAgICAgICAgICAgICAgaXRlbS50aHJUYWcgPSBjb2luVGFnXG4gICAgICAgICAgICAgICAgaWYgKGNvaW5UYWdzLmxlbmd0aCA+IDApIHtcbiAgICAgICAgICAgICAgICAgICAgaXRlbS50YWdTaG93U3RhdHVzID0gXCJ2aXNpYmxlXCJcbiAgICAgICAgICAgICAgICAgICAgaXRlbS5maXJzdFRhZyA9IGl0ZW0uY29pblRhZ3NbMF1cbiAgICAgICAgICAgICAgICAgICAgaXRlbS5maXJzdFRhZy5pY29uID0gYXdhaXQgY29udGVudEFjdGlvbihcImNvaW5JY29uXCIsIGl0ZW0uZmlyc3RUYWcuY29pbilcbiAgICAgICAgICAgICAgICAgICAgaXRlbS5maXJzdFRhZy5wZXJjZW50ID0gYXdhaXQgY29udGVudEFjdGlvbihcImNvaW5QZXJjZW50XCIsIGl0ZW0uZmlyc3RUYWcuc3ltYm9sKVxuICAgICAgICAgICAgICAgICAgICBpdGVtLmZpcnN0VGFnLmNvbG9yID0gYXdhaXQgY29udGVudEFjdGlvbihcInBlcmNlbnRDb2xvclwiLCBpdGVtLmZpcnN0VGFnLnN5bWJvbClcbiAgICAgICAgICAgICAgICAgICAgaXRlbS5maXJzdFNob3dTdGF0dXM9XCJ2aXNpYmxlXCJcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgaWYgKGNvaW5UYWdzLmxlbmd0aCA+IDEpIHtcbiAgICAgICAgICAgICAgICAgICAgaXRlbS5zbmRUYWcgPSBpdGVtLmNvaW5UYWdzWzBdXG4gICAgICAgICAgICAgICAgICAgIGl0ZW0uc25kVGFnLmljb24gPSBhd2FpdCBjb250ZW50QWN0aW9uKFwiY29pbkljb25cIiwgaXRlbS5zbmRUYWcuY29pbilcbiAgICAgICAgICAgICAgICAgICAgaXRlbS5zbmRUYWcucGVyY2VudCAgPSBhd2FpdCBjb250ZW50QWN0aW9uKFwiY29pblBlcmNlbnRcIiwgaXRlbS5zbmRUYWcuc3ltYm9sKVxuICAgICAgICAgICAgICAgICAgICBpdGVtLnNuZFRhZy5jb2xvciA9ICBhd2FpdCBjb250ZW50QWN0aW9uKFwicGVyY2VudENvbG9yXCIsIGl0ZW0uc25kVGFnLnN5bWJvbClcbiAgICAgICAgICAgICAgICAgICAgaXRlbS5zbmRTaG93U3RhdHVzID0gXCJ2aXNpYmxlXCJcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgaWYgKGNvaW5UYWdzLmxlbmd0aCA+IDIpIHtcbiAgICAgICAgICAgICAgICAgICAgaXRlbS50aHJUYWcgPSBpdGVtLmNvaW5UYWdzWzBdXG4gICAgICAgICAgICAgICAgICAgIGl0ZW0udGhyVGFnLmljb24gPSBhd2FpdCBjb250ZW50QWN0aW9uKFwiY29pbkljb25cIiwgaXRlbS50aHJUYWcuY29pbilcbiAgICAgICAgICAgICAgICAgICAgaXRlbS50aHJUYWcucGVyY2VudCA9IGF3YWl0IGNvbnRlbnRBY3Rpb24oXCJjb2luUGVyY2VudFwiLCBpdGVtLnRoclRhZy5zeW1ib2wpXG4gICAgICAgICAgICAgICAgICAgIGl0ZW0udGhyVGFnLmNvbG9yID0gYXdhaXQgY29udGVudEFjdGlvbihcInBlcmNlbnRDb2xvclwiLCBpdGVtLnRoclRhZy5zeW1ib2wpXG4gICAgICAgICAgICAgICAgICAgIGl0ZW0udGhyU2hvd1N0YXR1cyA9IFwidmlzaWJsZVwiXG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIHZhciBob3RDb21tZW50cyA9IGl0ZW0uaG90Q29tbWVudExpc3Q7XG4gICAgICAgICAgICAgICAgaXRlbS5maXJzdEhvdFN0YXR1cyA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgICAgIGl0ZW0uc25kSG90U3RhdHVzID0gXCJnb25lXCI7XG4gICAgICAgICAgICAgICAgaXRlbS50aHJIb3RTdGF0dXMgPSBcImdvbmVcIjtcbiAgICAgICAgICAgICAgICBjb25zdCBjb2xvcjEgPSBnZXROYXRpdmVEYXRhKCkubmlnaHRNb2RlID8gXCIjQ0ZEM0U5XCIgOiBcIiMxQzFDMUNcIjtcbiAgICAgICAgICAgICAgICBjb25zdCBjb2xvcjIgPSBnZXROYXRpdmVEYXRhKCkubmlnaHRNb2RlID8gXCIjNkQ4N0E4XCIgOiBcIiM4QThBOEVcIjtcbiAgICAgICAgICAgICAgICBpZiAoaG90Q29tbWVudHMubGVuZ3RoID4gMCkge1xuICAgICAgICAgICAgICAgICAgICBpdGVtLmZpcnN0SG90U3RhdHVzID0gXCJ2aXNpYmxlXCJcbiAgICAgICAgICAgICAgICAgICAgaXRlbS5maXJzdEhvdCA9IGA8Zm9udCBjb2xvcj0ke2NvbG9yMX0gc2l6ZT0nMTRweCc+JHtpdGVtLmhvdENvbW1lbnRMaXN0WzBdLmhvdENvbUF1ZGl0b3J9OjwvZm9udD48Zm9udCBjb2xvcj0ke2NvbG9yMn0gc2l6ZT0nMTRweCc+JHtpdGVtLmhvdENvbW1lbnRMaXN0WzBdLmhvdENvbW1lbnR9PC9mb250PmBcbi8vICAgICAgICAgICAgICAgICAgICBpdGVtLmZpcnN0SG90ID0gYDxzcGFuIHN0eWxlPVwiY29sb3I6e3tAY29sb3IvYmFzZUNvbG9yUHJpbWFyeVRleHR9fTtmb250LXNpemU6MTRweDtcIj4ke2l0ZW0uaG90Q29tbWVudExpc3RbMF0uaG90Q29tQXVkaXRvcn06PC9zcGFuPjxzcGFuIHN0eWxlPVwiY29sb3I6e3tAY29sb3IvYmFzZUNvbG9yU2Vjb25kYXJ5VGV4dH19O2ZvbnQtc2l6ZToxNHB4O1wiPiR7aXRlbS5ob3RDb21tZW50TGlzdFswXS5ob3RDb21tZW50fTwvc3Bhbj5gXG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIGlmIChob3RDb21tZW50cy5sZW5ndGggPiAxKSB7XG4gICAgICAgICAgICAgICAgICAgIGl0ZW0uc25kSG90U3RhdHVzID0gXCJ2aXNpYmxlXCJcbiAgICAgICAgICAgICAgICAgICAgaXRlbS5zbmRIb3QgPSBgPGZvbnQgY29sb3I9JHtjb2xvcjF9IHNpemU9JzE0cHgnPiR7aXRlbS5ob3RDb21tZW50TGlzdFsxXS5ob3RDb21BdWRpdG9yfTo8L2ZvbnQ+PGZvbnQgY29sb3I9JHtjb2xvcjJ9IHNpemU9JzE0cHgnPiR7aXRlbS5ob3RDb21tZW50TGlzdFsxXS5ob3RDb21tZW50fTwvZm9udD5gXG4vLyAgICAgICAgICAgICAgICAgICAgaXRlbS5zbmRIb3QgPSBgPHNwYW4gc3R5bGU9XCJjb2xvcjp7e0Bjb2xvci9iYXNlQ29sb3JQcmltYXJ5VGV4dH19O2ZvbnQtc2l6ZToxNHB4O1wiPiR7aXRlbS5ob3RDb21tZW50TGlzdFsxXS5ob3RDb21BdWRpdG9yfTo8L3NwYW4+PHNwYW4gc3R5bGU9XCJjb2xvcjp7e0Bjb2xvci9iYXNlQ29sb3JTZWNvbmRhcnlUZXh0fX07Zm9udC1zaXplOjE0cHg7XCI+JHtpdGVtLmhvdENvbW1lbnRMaXN0WzFdLmhvdENvbW1lbnR9PC9zcGFuPmBcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgaWYgKGhvdENvbW1lbnRzLmxlbmd0aCA+IDIpIHtcbiAgICAgICAgICAgICAgICAgICAgaXRlbS50aHJIb3RTdGF0dXMgPSBcInZpc2libGVcIlxuICAgICAgICAgICAgICAgICAgICBpdGVtLnRockhvdCA9IGA8Zm9udCBjb2xvcj0ke2NvbG9yMX0gc2l6ZT0nMTRweCc+JHtpdGVtLmhvdENvbW1lbnRMaXN0WzJdLmhvdENvbUF1ZGl0b3J9OjwvZm9udD48Zm9udCBjb2xvcj0ke2NvbG9yMn0gc2l6ZT0nMTRweCc+JHtpdGVtLmhvdENvbW1lbnRMaXN0WzJdLmhvdENvbW1lbnR9PC9mb250PmBcbi8vICAgICAgICAgICAgICAgICAgICBpdGVtLnRockhvdCA9IGA8c3BhbiBzdHlsZT1cImNvbG9yOnt7QGNvbG9yL2Jhc2VDb2xvclByaW1hcnlUZXh0fX07Zm9udC1zaXplOjE0cHg7XCI+JHtpdGVtLmhvdENvbW1lbnRMaXN0WzJdLmhvdENvbUF1ZGl0b3J9Ojwvc3Bhbj48c3BhbiBzdHlsZT1cImNvbG9yOnt7QGNvbG9yL2Jhc2VDb2xvclNlY29uZGFyeVRleHR9fTtmb250LXNpemU6MTRweDtcIj4ke2l0ZW0uaG90Q29tbWVudExpc3RbMl0uaG90Q29tbWVudH08L3NwYW4+YFxuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICBpdGVtLnByYWlzZUljb24gPSBpdGVtLnByYWlzZVN0YXR1cyA9PSAxID8gZ2V0TmF0aXZlUmVzKCkuaW5mb3JtYXRpb25MaWtlRm9jdXMgOiBnZXROYXRpdmVSZXMoKS5pbmZvcm1hdGlvbkxpa2VcbiAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhcInJlcXVlc3ROZXdzTGlzdCBpdGVtID09IFwiICsgSlNPTi5zdHJpbmdpZnkoaXRlbSkpXG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICAgICAgaWYgKCFpc01vcmUpIHtcbiAgICAgICAgICAgICRkYXRhLmZsYXNoTmV3cy5yZWZyZXNoQ29udGVudCA9IGRhdGE7XG4gICAgICAgICAgICBpZiAoY29kZSA9PSAyMDAgJiYgZGF0YS5sZW5ndGggPiAwKSB7XG4gICAgICAgICAgICAgICAgZmxhc2hDb250ZW50TGlzdCA9IGRhdGE7XG4gICAgICAgICAgICAgICAgJGRhdGEuZmxhc2hOZXdzLmFsbENvbnRlbnRMaXN0ID0gZmxhc2hDb250ZW50TGlzdDtcbiAgICAgICAgICAgICAgICB0ZW1wRmxhc2hMaXN0W2NhdGVnb3J5SWRdID0gZmxhc2hDb250ZW50TGlzdFxuICAgICAgICAgICAgfVxuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgJGRhdGEuZmxhc2hOZXdzLmxvYWRNb3JlQ29udGVudCA9IGRhdGE7XG4gICAgICAgICAgICBpZiAoY29kZSA9PSAyMDAgJiYgZGF0YS5sZW5ndGggPiAwKSB7XG4gICAgICAgICAgICAgICAgZmxhc2hDb250ZW50TGlzdC5wdXNoKC4uLmRhdGEpXG4gICAgICAgICAgICAgICAgJGRhdGEuZmxhc2hOZXdzLmFsbENvbnRlbnRMaXN0ID0gZmxhc2hDb250ZW50TGlzdFxuICAgICAgICAgICAgICAgIHRlbXBGbGFzaExpc3RbY2F0ZWdvcnlJZF0gPSBmbGFzaENvbnRlbnRMaXN0XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUuZXJyb3IoZS5zdGFjaylcbiAgICAgICAgY29uc29sZS5lcnJvcihgcmVxdWVzdE5ld3NMaXN0IGVycm9yOiR7ZX1gKTtcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHNlbFBhZ2UoY2F0ZWdvcnlJZCkge1xuICAgICRkYXRhLmZsYXNoTmV3cy50ZW1wQ2F0ZWdvcnlJZCA9IGNhdGVnb3J5SWRcbiAgICBmbGFzaENvbnRlbnRMaXN0ID0gdGVtcEZsYXNoTGlzdFtjYXRlZ29yeUlkXVxuICAgICRkYXRhLmZsYXNoTmV3cy5hbGxDb250ZW50TGlzdCA9IGZsYXNoQ29udGVudExpc3Rcbn1cblxuYXN5bmMgZnVuY3Rpb24gbGlrZUZsYXNoKGl0ZW1JbmRleCkge1xuICAgIHRyeSB7XG4gICAgICAgIHZhciBsaWtlUmVzdWx0ID0gYXdhaXQgY29udGVudEFjdGlvbihcImxpa2VcIiwgJ3tcImlkXCI6XCInICsgZmxhc2hDb250ZW50TGlzdFtpdGVtSW5kZXhdLmlkICsgJ1wiLFwiY1R5cGVcIjoyfScpXG4gICAgICAgIGNvbnN0IHJlc0pTT04gPSBKU09OLnBhcnNlKGxpa2VSZXN1bHQpXG4gICAgICAgIGNvbnN0IHtwcmFpc2VOdW0sIHByYWlzZVN0YXR1c30gPSByZXNKU09OO1xuICAgICAgICBmbGFzaENvbnRlbnRMaXN0W2l0ZW1JbmRleF0ucHJhaXNlTnVtID0gcHJhaXNlTnVtXG4gICAgICAgIGZsYXNoQ29udGVudExpc3RbaXRlbUluZGV4XS5wcmFpc2VTdGF0dXMgPSBwcmFpc2VTdGF0dXNcbiAgICAgICAgZmxhc2hDb250ZW50TGlzdFtpdGVtSW5kZXhdLnByYWlzZUljb24gPSBwcmFpc2VTdGF0dXMgPT0gMSA/IGdldE5hdGl2ZVJlcygpLmluZm9ybWF0aW9uTGlrZUZvY3VzIDogZ2V0TmF0aXZlUmVzKCkuaW5mb3JtYXRpb25MaWtlXG4gICAgICAgICRkYXRhLmZsYXNoTmV3cy5hbGxDb250ZW50TGlzdCA9IGZsYXNoQ29udGVudExpc3RcbiAgICB9IGNhdGNoKGUpIHtcbiAgICAgICAgY29uc29sZS5lcnJvcihlLnN0YWNrKVxuICAgICAgICBjb25zb2xlLmVycm9yKGBMaWtlRmxhc2ggZXJyb3I6JHtlfWApO1xuICAgIH1cbn0iLCJpbXBvcnQgeyBnZW5lcmF0ZVBhcmFtcywgcmVhbFZhbHVlU3RyaW5nLCBjb250ZW50QWN0aW9uIH0gZnJvbSBcIi4vdXRpbFwiXG5cbnZhciBkZWVwQ29udGVudExpc3Q9W107XG52YXIgdGVtcERlZXBMaXN0PVtdO1xuXG4kZGF0YS5kZWVwTmV3cyA9IHtcbiAgICBjb2RlOiAwLFxuICAgIG1lc3NhZ2U6IFwiXCIsXG4gICAgcmVmcmVzaENvbnRlbnQ6IFtdLFxuICAgIGxvYWRNb3JlQ29udGVudDogW10sXG4gICAgYWxsQ29udGVudExpc3Q6IFtdLFxuICAgIHRlbXBDYXRlZ29yeUlkOiBcIlwiLFxuICAgIGxpc3RSZWZyZXNoU3RhdHVzOiBcIjJcIixcbiAgICBsaXN0TG9hZE1vcmVTdGF0dXM6IFwiMlwiXG59XG5cbiRldmVudC5kZWVwTmV3cyA9IHtcbiAgICByZXF1ZXN0TGlzdChjYXRlZ29yeUlkLCBpc01vcmUpIHtcbiAgICAgICAgcmVxdWVzdERlZXBOZXdzTGlzdChjYXRlZ29yeUlkLCBpc01vcmUpXG4gICAgfSxcbiAgICBpdGVtQ2xpY2sobmV3c0lkKSB7XG4gICAgICAgIGNvbnRlbnRBY3Rpb24oXCJkZWVwRGV0YWlsXCIsIG5ld3NJZCArIFwiXCIpXG4gICAgfSxcbiAgICBvblBhZ2VDaGFuZ2UoY2F0ZWdvcnlJZCkge1xuICAgICAgICBzZWxQYWdlKGNhdGVnb3J5SWQpXG4gICAgfSxcbiAgICBvblJlZnJlc2goKSB7XG4gICAgICAgIHJlcXVlc3REZWVwTmV3c0xpc3QoJGRhdGEuZGVlcE5ld3MudGVtcENhdGVnb3J5SWQsIGZhbHNlKVxuICAgIH0sXG4gICAgb25Mb2FkTW9yZSgpIHtcbiAgICAgICAgcmVxdWVzdERlZXBOZXdzTGlzdCgkZGF0YS5kZWVwTmV3cy50ZW1wQ2F0ZWdvcnlJZCwgdHJ1ZSlcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlcXVlc3REZWVwTmV3c0xpc3QoY2F0ZWdvcnlJZCwgaXNNb3JlKSB7XG4gICAgJGRhdGEuZGVlcE5ld3MudGVtcENhdGVnb3J5SWQgPSBjYXRlZ29yeUlkXG4gICAgdmFyIGRpY3QgPSB7fTtcbiAgICBpZiAoaXNNb3JlKSB7XG4gICAgICAgIGlmIChkZWVwQ29udGVudExpc3QubGVuZ3RoIDw9IDApIHJldHVybjtcbiAgICAgICAgdmFyIGxhc3RJc3N1ZVRpbWUgPSBkZWVwQ29udGVudExpc3RbZGVlcENvbnRlbnRMaXN0Lmxlbmd0aCAtIDFdLm5ld3MuaXNzdWVUaW1lO1xuICAgICAgICBjb25zb2xlLmxvZyhgbG9uZ0NvbnRlbnQubGFzdElzc3VlVGltZT09JHtsYXN0SXNzdWVUaW1lfWApO1xuICAgICAgICBkaWN0W1wiaXNzdWVUaW1lXCJdID0gbGFzdElzc3VlVGltZSArIFwiXCI7XG4gICAgfVxuICAgIGRpY3RbXCJzaXplXCJdID0gXCIyMFwiO1xuICAgIGRpY3RbXCJjYXRlZ29yeUlkXCJdID0gY2F0ZWdvcnlJZDtcbiAgICBjb25zdCByZXF1ZXN0UGFyYW1zID0gZ2VuZXJhdGVQYXJhbXMoJ3YxL2NvbnRlbnQvbmV3cy9saXN0JywgZGljdCwgMCwgMCk7XG4gICAgdHJ5IHtcbiAgICAgICAgJGRhdGEuZGVlcE5ld3MubGlzdFJlZnJlc2hTdGF0dXMgPSBcIjJcIlxuICAgICAgICAkZGF0YS5kZWVwTmV3cy5saXN0TG9hZE1vcmVTdGF0dXMgPSBcIjJcIlxuICAgICAgICBjb25zdCByZXNwb25zZVN0cmluZyA9IGF3YWl0ICRuYXRpdmVBUEkucmVxdWVzdChyZXF1ZXN0UGFyYW1zKTtcbiAgICAgICAgY29uc3QgcmVzcG9uc2UgPSBKU09OLnBhcnNlKHJlc3BvbnNlU3RyaW5nKTtcbiAgICAgICAgY29uc3Qge2NvZGUsIGRhdGF9ID0gcmVzcG9uc2U7XG4gICAgICAgIGlmIChkYXRhICE9IG51bGwgJiYgZGF0YS5sZW5ndGggPiAwKSB7XG4gICAgICAgICAgICBmb3IgKHZhciBpdGVtIG9mIGRhdGEpIHtcbiAgICAgICAgICAgICAgICBpdGVtLnNob3dUaW1lID0gYXdhaXQgY29udGVudEFjdGlvbihcImdldEZvcm1hdFRpbWVcIiwgaXRlbS5uZXdzLmlzc3VlVGltZSArIFwiXCIpXG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICAgICAgaWYgKCFpc01vcmUpIHtcbiAgICAgICAgICAgICRkYXRhLmRlZXBOZXdzLnJlZnJlc2hDb250ZW50ID0gZGF0YTtcbiAgICAgICAgICAgIGlmIChjb2RlID09IDIwMCAmJiBkYXRhLmxlbmd0aCA+IDApIHtcbiAgICAgICAgICAgICAgICBkZWVwQ29udGVudExpc3QgPSBkYXRhO1xuICAgICAgICAgICAgICAgICRkYXRhLmRlZXBOZXdzLmFsbENvbnRlbnRMaXN0ID0gZGVlcENvbnRlbnRMaXN0O1xuICAgICAgICAgICAgICAgIHRlbXBEZWVwTGlzdFtjYXRlZ29yeUlkXSA9IGRlZXBDb250ZW50TGlzdFxuICAgICAgICAgICAgfVxuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgJGRhdGEuZGVlcE5ld3MubG9hZE1vcmVDb250ZW50ID0gZGF0YTtcbiAgICAgICAgICAgIGlmIChjb2RlID09IDIwMCAmJiBkYXRhLmxlbmd0aCA+IDApIHtcbiAgICAgICAgICAgICAgICBkZWVwQ29udGVudExpc3QucHVzaCguLi5kYXRhKVxuICAgICAgICAgICAgICAgICRkYXRhLmRlZXBOZXdzLmFsbENvbnRlbnRMaXN0ID0gZGVlcENvbnRlbnRMaXN0XG4gICAgICAgICAgICAgICAgdGVtcERlZXBMaXN0W2NhdGVnb3J5SWRdID0gZGVlcENvbnRlbnRMaXN0XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUuZXJyb3IoYHJlcXVlc3RMb25nQ29udGVudExpc3QgZXJyb3I6JHtlfWApO1xuICAgIH1cbn1cblxuYXN5bmMgZnVuY3Rpb24gc2VsUGFnZShjYXRlZ29yeUlkKSB7XG4gICAgJGRhdGEuZGVlcE5ld3MudGVtcENhdGVnb3J5SWQgPSBjYXRlZ29yeUlkXG4gICAgZGVlcENvbnRlbnRMaXN0ID0gdGVtcERlZXBMaXN0W2NhdGVnb3J5SWRdXG4gICAgJGRhdGEuZGVlcE5ld3MuYWxsQ29udGVudExpc3QgPSBkZWVwQ29udGVudExpc3Rcbn0iLCIvLyDpopzoibLphY3nva4gMDrnuqLmtqjnu7/ot4wg5oiWIDE657u/5rao57qi6LeMXG52YXIgdXBDb2xvckxpc3Q7XG52YXIgZG93bkNvbG9yTGlzdDtcblxuZXhwb3J0IHZhciBjb21tYW5EYXRhID0ge1xuICAgIHByaWNlQ29sb3JUeXBlOiAwLFxuICAgIG1hcmtldERhdGE6IHt9LFxuICAgIGNvbG9yTW9kZTogMFxufTtcblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGhhbmRsZVNvY2tldERhdGEoZGF0YSkge1xuICAgIGNvbW1hbkRhdGEubWFya2V0RGF0YSA9IE9iamVjdC5hc3NpZ24oY29tbWFuRGF0YS5tYXJrZXREYXRhLCBkYXRhLmRhdGEpO1xufVxuXG4vL+iuvue9rumAmueUqOmFjee9rlxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNlbmRDb21tb25Db25maWcocGFyYW0pIHtcbiAgICBjb21tYW5EYXRhLnByaWNlQ29sb3JUeXBlID0gcGFyc2VJbnQocGFyYW0ucHJpY2VDb2xvclR5cGUpO1xuICAgIGNvbW1hbkRhdGEuY29sb3JNb2RlID0gcGFyc2VJbnQocGFyYW0uY29sb3JNb2RlKTtcblxuICAgIHZhciByZWRDb2xvckxpc3QgPSBbXCIjQURCMEIyXCIsIFwiI0U5NDM1OVwiLCBcIiNERTI5NDFcIiwgXCIjQ0UxNDJCXCJdO1xuICAgIHZhciBncmVlbkNvbG9yTGlzdCA9IFtcIiNBREIwQjJcIiwgXCIjMDBBMTcxXCIsIFwiIzAwOEI2MVwiLCBcIiMwMDYyNDVcIl07XG5cbiAgICBpZiAocGFyc2VJbnQoY29tbWFuRGF0YS5wcmljZUNvbG9yVHlwZSkgPT0gMCkge1xuICAgICAgICB1cENvbG9yTGlzdCA9IHJlZENvbG9yTGlzdDtcbiAgICAgICAgZG93bkNvbG9yTGlzdCA9IGdyZWVuQ29sb3JMaXN0O1xuICAgIH0gZWxzZSB7XG4gICAgICAgIHVwQ29sb3JMaXN0ID0gZ3JlZW5Db2xvckxpc3Q7XG4gICAgICAgIGRvd25Db2xvckxpc3QgPSByZWRDb2xvckxpc3Q7XG4gICAgfVxuICAgIGNvbW1hbkRhdGEud2ViVXJsID0gcGFyYW0ud2ViVXJsO1xufVxuXG4vL+agueaNrua2qOi3jOW5heiOt+WPluaYvuekuuminOiJslxuZXhwb3J0IGZ1bmN0aW9uIGdldFByaWNlQ29sb3IocmF0aW8pIHtcbiAgICBpZiAocmF0aW8gPT0gbnVsbCkge1xuICAgICAgICByYXRpbyA9IDA7XG4gICAgfVxuICAgIGNvbnN0IHJhdGlvX2FicyA9IE1hdGguYWJzKHJhdGlvKTtcbiAgICB2YXIgY29sb3JMZXZlbCA9IDA7XG4gICAgaWYgKHJhdGlvX2FicyA+IDAgJiYgcmF0aW9fYWJzIDwgMykge1xuICAgICAgICBjb2xvckxldmVsID0gMTtcbiAgICB9XG4gICAgZWxzZSBpZiAocmF0aW9fYWJzID49IDMgJiYgcmF0aW9fYWJzIDwgOCkge1xuICAgICAgICBjb2xvckxldmVsID0gMjtcbiAgICB9XG4gICAgZWxzZSBpZiAocmF0aW9fYWJzID49IDgpIHtcbiAgICAgICAgY29sb3JMZXZlbCA9IDM7XG4gICAgfVxuICAgIHZhciBjb2xvckhleFN0ciA9IG51bGw7XG4gICAgaWYgKHJhdGlvID4gMCkge1xuICAgICAgICBjb2xvckhleFN0ciA9IHVwQ29sb3JMaXN0W2NvbG9yTGV2ZWxdO1xuICAgIH1cbiAgICBlbHNlIHtcbiAgICAgICAgY29sb3JIZXhTdHIgPSBkb3duQ29sb3JMaXN0W2NvbG9yTGV2ZWxdO1xuICAgIH1cbiAgICByZXR1cm4gY29sb3JIZXhTdHI7XG59XG5cbi8v5qC85byP5YyW5rao6LeM5bmFXG5leHBvcnQgZnVuY3Rpb24gZm9ybWF0UmF0aW8odXBEb3duKSB7XG4gICAgbGV0IHByZWZpeCA9IHVwRG93biA+IDAgPyBcIitcIiA6IFwiXCI7XG4gICAgcmV0dXJuIGAke3ByZWZpeH0ke3VwRG93bi50b1N0cmluZygpfSVgO1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gb3BlblBhZ2UocGFnZSwgcGFyYW1zPXt9KSB7XG4gICAgYXdhaXQgJG5hdGl2ZUFQSS5jb250ZW50QnJpZGdlKHtcbiAgICAgICAgYWN0aW9uOiBcIm9wZW5QYWdlXCIsXG4gICAgICAgIHR5cGU6IFwibmF0aXZlXCIsXG4gICAgICAgIHBhZ2U6IHBhZ2UsXG4gICAgICAgIHBhcmFtczogSlNPTi5zdHJpbmdpZnkocGFyYW1zKVxuICAgIH0pO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gbW9kdWxlRGVmaW5lKG1vZHVsZU5hbWUsIHN0YXJ0RnVuY3Rpb24sIGRlZmF1bHREYXRhRnVuY3Rpb24pIHtcbiAgICAkZGF0YVttb2R1bGVOYW1lXSA9IGRlZmF1bHREYXRhRnVuY3Rpb24oKTtcbiAgICAkZXZlbnRbbW9kdWxlTmFtZV0gPSB7IHN0YXJ0OiBzdGFydEZ1bmN0aW9uIH07XG4gICAgcmV0dXJuIHtcbiAgICAgICAgbW9kdWxlRXZlbnQ6ICRldmVudFttb2R1bGVOYW1lXSxcbiAgICAgICAgbW9kdWxlRGF0YTogJGRhdGFbbW9kdWxlTmFtZV1cbiAgICB9O1xufVxuXG4vL+WPkemAgeivt+axglxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNlbmRSZXF1ZXN0KHBhdGgsIHBhcmFtcyA9IHt9LCBtZXRob2QgPSAwLCBob3N0VHlwZSA9IDAsIGhlYWRlciA9IHt9KSB7XG4gICAgY29uc29sZS5sb2coYHJlcXVlc3QgJHtwYXRofSwgcGFyYW1zOiR7SlNPTi5zdHJpbmdpZnkocGFyYW1zKX1gKTtcblxuICAgIGlmIChob3N0VHlwZSA9PSA1IHx8IGhvc3RUeXBlID09IDYpIHtcbiAgICAgICAgaGVhZGVyW1wiQ29udGVudC1UeXBlXCJdID0gXCJhcHBsaWNhdGlvbi9qc29uXCI7XG4gICAgfVxuXG4gICAgY29uc3QgcGFyYW0gPSB7XG4gICAgICAgIHBhdGgsXG4gICAgICAgIG1ldGhvZCxcbiAgICAgICAgaG9zdFR5cGUsXG4gICAgICAgIGhlYWRlcixcbiAgICAgICAgcGFyYW1zLFxuICAgIH07XG4gICAgdHJ5IHtcbiAgICAgICAgdmFyIHJlc3BvbnNlU3RyaW5nID0gYXdhaXQgJG5hdGl2ZUFQSS5yZXF1ZXN0KEpTT04uc3RyaW5naWZ5KHBhcmFtKSk7XG4gICAgICAgIHZhciByZXNwb25zZSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcpO1xuICAgICAgICB2YXIgeyBjb2RlLCBkYXRhIH0gPSByZXNwb25zZTtcbiAgICAgICAgaWYgKDggPT0gaG9zdFR5cGUpIHtcbiAgICAgICAgICAgIC8v5ZCI57qm55qE5o6l5Y+j5aSE55CGXG4gICAgICAgICAgICB2YXIgc3RhdHVzID0gcmVzcG9uc2Uuc3RhdHVzO1xuICAgICAgICAgICAgdmFyIGVycl9jb2RlID0gcmVzcG9uc2UuZXJyX2NvZGU7XG4gICAgICAgICAgICB2YXIgZXJyX21zZyA9IHJlc3BvbnNlLmVycl9tc2c7XG4gICAgICAgICAgICBpZiAoc3RhdHVzID09IFwib2tcIikge1xuICAgICAgICAgICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0ICR7cGF0aH0gZG9uZWApO1xuICAgICAgICAgICAgICAgIGlmICh0eXBlb2YgZGF0YSA9PT0gJ251bWJlcicpIHtcbiAgICAgICAgICAgICAgICAgICAgbGV0IHN0YXJ0ID0gYFwiZGF0YVwiOmA7XG4gICAgICAgICAgICAgICAgICAgIGxldCBzdGFydEluZGV4ID0gcmVzcG9uc2VTdHJpbmcuaW5kZXhPZihzdGFydCk7XG4gICAgICAgICAgICAgICAgICAgIGxldCBlbmQgPSBgLFwidHNcIjpgO1xuICAgICAgICAgICAgICAgICAgICBsZXQgZW5kSW5kZXggPSByZXNwb25zZVN0cmluZy5pbmRleE9mKGVuZCk7XG4gICAgICAgICAgICAgICAgICAgIGxldCBkYXRhU3RyaW5nID0gcmVzcG9uc2VTdHJpbmcuc3Vic3RyaW5nKHN0YXJ0SW5kZXggKyBzdGFydC5sZW5ndGgsIGVuZEluZGV4KTtcbiAgICAgICAgICAgICAgICAgICAgY29uc29sZS5sb2coYGRhdGEgaXMgdHlwZW9mIG51bWJlciwgZGF0YVN0cmluZyA9ICR7ZGF0YVN0cmluZ31gKTtcbiAgICAgICAgICAgICAgICAgICAgcmV0dXJuIGRhdGFTdHJpbmc7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIHJldHVybiBkYXRhO1xuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCBmYWlsZWQsIGNvZGU9JHtlcnJfY29kZX0sIG1lc3NhZ2U9JHtlcnJfbXNnfWApO1xuICAgICAgICAgICAgICAgIGlmIChtZXRob2QgIT0gMCkge1xuICAgICAgICAgICAgICAgICAgICBzaG93VG9hc3QoZXJyX21zZyk7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIHJldHVybiBudWxsO1xuICAgICAgICAgICAgfVxuICAgICAgICB9IGVsc2UgaWYgKGNvZGUgPT0gMjAwKSB7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCAke3BhdGh9IGRvbmVgKTtcbiAgICAgICAgICAgIHJldHVybiBkYXRhO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgZmFpbGVkLCBjb2RlPSR7Y29kZX1gKTtcbiAgICAgICAgICAgIGxldCBtZXNzYWdlID0gcmVzcG9uc2UubWVzc2FnZTtcbiAgICAgICAgICAgIGlmIChtZXRob2QgIT0gMCAmJiBtZXNzYWdlKSB7XG4gICAgICAgICAgICAgICAgc2hvd1RvYXN0KG1lc3NhZ2UpO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgcmV0dXJuIG51bGw7XG4gICAgICAgIH1cbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0IGVycm9yLCBlcnJvcj0ke2V9YCk7XG4gICAgICAgIHJldHVybiBudWxsO1xuICAgIH1cbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGdldFBOR0ljb25VUkxCeUN1cnJlbmN5KGN1cnJlbmN5KSB7XG4gICAgbGV0IGJhc2VVcmwgPSBjb21tYW5EYXRhLndlYlVybCA/IGNvbW1hbkRhdGEud2ViVXJsIDogXCJcIjtcbiAgICByZXR1cm4gYCR7YmFzZVVybH0vLS94L2hiL3AvYXBpL2NvbnRlbnRzL2N1cnJlbmN5L2ljb25fcG5nLyR7Y3VycmVuY3kudG9Mb3dlckNhc2UoKX0ucG5nYDtcbn0iLCJpbXBvcnQgKiBhcyBjb21tb24gZnJvbSAnLi9jb21tb24nXG5cbmZ1bmN0aW9uIGRlZmF1bHREYXRhKCkge1xuICAgIHJldHVybiB7XG4gICAgICAgIHRhZ0xpc3Q6W11cbiAgICB9O1xufVxuXG5hc3luYyBmdW5jdGlvbiBzdGFydCgpIHtcbn1cblxuY29uc3Qge21vZHVsZURhdGEsIG1vZHVsZUV2ZW50fSA9IGNvbW1vbi5tb2R1bGVEZWZpbmUoXCJjb2luVGFnc1wiLCBzdGFydCwgZGVmYXVsdERhdGEpO1xuXG5tb2R1bGVFdmVudC5nZXRDb2luTGlzdCA9IGFzeW5jIGZ1bmN0aW9uIChjb2luc0RhdGEpIHtcbiAgICB2YXIgYXJyYXkgPSBbXTtcbiAgICBjb25zdCBsaXN0ID0gY29pbnNEYXRhW1wibGlzdFwiXTtcbiAgICBmb3IgKHZhciBpID0gMDsgaSA8IGxpc3QubGVuZ3RoOyBpKyspIHtcbiAgICAgICAgdmFyIG9iaiA9IGxpc3RbaV07XG4gICAgICAgIG9iai5pbmRleCA9IFN0cmluZyhpKTtcbiAgICAgICAgb2JqLnR5cGUgPSBcIjFcIjtcbiAgICAgICAgY29uc3QgdXBEb3duID0gMDtcbiAgICAgICAgb2JqLnVwRG93biA9IGNvbW1vbi5mb3JtYXRSYXRpbyh1cERvd24pO1xuICAgICAgICBvYmoucmF0aW9Db2xvciA9IGNvbW1vbi5nZXRQcmljZUNvbG9yKHVwRG93bik7XG4gICAgICAgIFxuICAgICAgICBsZXQgc3ltYm9sID0gb2JqLnN5bWJvbC50b0xvd2VyQ2FzZSgpO1xuICAgICAgICBjb25zdCBjb2luRGljdCA9IGNvbW1vbi5jb21tYW5EYXRhLm1hcmtldERhdGFbc3ltYm9sXTtcbiAgICAgICAgaWYgKGNvaW5EaWN0ICE9IG51bGwpIHtcbiAgICAgICAgICAgIGNvbnN0IHVwRG93biA9IGNvaW5EaWN0LmRlY2ltYWxEZWx0YS50b0ZpeGVkKDIpO1xuICAgICAgICAgICAgb2JqLnVwRG93biA9IGNvbW1vbi5mb3JtYXRSYXRpbyh1cERvd24pO1xuICAgICAgICAgICAgb2JqLnJhdGlvQ29sb3IgPSBjb21tb24uZ2V0UHJpY2VDb2xvcih1cERvd24pO1xuICAgICAgICB9XG4gICAgICAgIG9iai5pY29uID0gY29tbW9uLmdldFBOR0ljb25VUkxCeUN1cnJlbmN5KG9iai5jb2luLnRvTG93ZXJDYXNlKCkpLFxuICAgICAgICBhcnJheS5wdXNoKG9iaik7XG4gICAgfVxuICAgIG1vZHVsZURhdGEudGFnTGlzdCA9IGFycmF5O1xufVxuXG5leHBvcnQgZnVuY3Rpb24gcmVzZXRDb2luTGlzdERhdGEoKSB7XG4gICAgdmFyIGxpc3QgPSBtb2R1bGVEYXRhLnRhZ0xpc3Q7XG4gICAgZm9yIChsZXQgaSA9IDA7IGkgPCBsaXN0Lmxlbmd0aDsgaSsrKSB7XG4gICAgICAgIHZhciBvYmogPSBsaXN0W2ldO1xuICAgICAgICBsZXQgc3ltYm9sID0gb2JqLnN5bWJvbC50b0xvd2VyQ2FzZSgpO1xuICAgICAgICBjb25zdCBjb2luRGljdCA9IGNvbW1vbi5jb21tYW5EYXRhLm1hcmtldERhdGFbc3ltYm9sXTtcbiAgICAgICAgaWYgKGNvaW5EaWN0ICE9IG51bGwpIHtcbiAgICAgICAgICAgIGNvbnN0IHVwRG93biA9IGNvaW5EaWN0LmRlY2ltYWxEZWx0YS50b0ZpeGVkKDIpO1xuICAgICAgICAgICAgb2JqLnVwRG93biA9IGNvbW1vbi5mb3JtYXRSYXRpbyh1cERvd24pO1xuICAgICAgICAgICAgb2JqLnJhdGlvQ29sb3IgPSBjb21tb24uZ2V0UHJpY2VDb2xvcih1cERvd24pO1xuICAgICAgICB9XG4gICAgfVxuICAgIG1vZHVsZURhdGEudGFnTGlzdCA9IGxpc3Q7XG59XG5cbm1vZHVsZUV2ZW50Lmp1bXBUb0tsaW5lID0gYXN5bmMgZnVuY3Rpb24ganVtcFRvS2xpbmUoaW5kZXgpIHtcbiAgICBpZiAoaW5kZXgpIHtcbiAgICAgICAgbGV0IGkgPSBwYXJzZUludChpbmRleCk7XG4gICAgICAgIGxldCBtb2RlbCA9IG1vZHVsZURhdGEudGFnTGlzdFtpXTtcbiAgICAgICAgdmFyIHBhcmFtID0ge307XG4gICAgICAgIHBhcmFtLmNvaW4gPSBtb2RlbC5jb2luO1xuICAgICAgICBwYXJhbS5zeW1ib2wgPSBtb2RlbC5zeW1ib2w7XG4gICAgICAgIGF3YWl0IGNvbW1vbi5vcGVuUGFnZShcImtsaW5lXCIscGFyYW0pO1xuICAgIH1cbn0iLCJpbXBvcnQgKiBhcyBuYXYgZnJvbSAnLi9jb250ZW50X25hdidcbmltcG9ydCAqIGFzIG5hdGl2ZVJlcyBmcm9tICcuL25hdGl2ZV9yZXMnXG5pbXBvcnQgKiBhcyBmbGFzaE5ld3MgZnJvbSAnLi9mbGFzaF9uZXdzJ1xuaW1wb3J0ICogYXMgZGVlcE5ld3MgZnJvbSAnLi9kZWVwX25ld3MnXG5pbXBvcnQgKiBhcyBjb21tb24gZnJvbSAnLi9jb21tb24nXG5pbXBvcnQgKiBhcyBjb2luVGFncyBmcm9tICcuL2NvaW5fdGFncydcbi8vIGltcG9ydCAqIGFzIGF0dGl0dWRlIGZyb20gJy4vYXR0aXR1ZGUnXG5cbmZ1bmN0aW9uIHNlbmRUb3BpY0RhdGEoYXR0aXR1ZGVJbmZvKSB7XG4gICAgYXR0aXR1ZGUuc2VuZFRvcGljRGF0YShhdHRpdHVkZUluZm8pO1xufVxuXG5hc3luYyBmdW5jdGlvbiBzZW5kQ29tbW9uQ29uZmlnKHBhcmFtKSB7XG4gICAgYXdhaXQgY29tbW9uLnNlbmRDb21tb25Db25maWcocGFyYW0pO1xufVxuXG5hc3luYyBmdW5jdGlvbiBzZW5kU29ja2V0RGF0YShkYXRhKSB7XG4gICAgaWYgKGRhdGEudHlwZSA9PSAnbWFya2V0Jykge1xuICAgICAgICBjb25zb2xlLmxvZyhkYXRhKTtcbiAgICAgICAgYXdhaXQgY29tbW9uLmhhbmRsZVNvY2tldERhdGEoZGF0YSk7XG4gICAgICAgIGNvaW5UYWdzLnJlc2V0Q29pbkxpc3REYXRhKCk7XG4gICAgfVxufVxuXG4vLyBhdHRpdHVkZS5zdGFydCgpO1xuXG4kZXZlbnQuc2VuZENvbW1vbkNvbmZpZyA9IHNlbmRDb21tb25Db25maWc7XG4kZXZlbnQuc2VuZFNvY2tldERhdGEgPSBzZW5kU29ja2V0RGF0YTtcbiRldmVudC5zZW5kVG9waWNEYXRhID0gc2VuZFRvcGljRGF0YTtcbiJdLCJuYW1lcyI6WyJuYXRpdmVEYXRhIiwiaXNMb2dpbiIsInBsYXRmb3JtIiwibmlnaHRNb2RlIiwidWlkIiwibmlja05hbWUiLCJhY2NvdW50IiwiaGFzTmV3VmVyc2lvbiIsImxhbmd1YWdlIiwiZmxhZ2hvc3QiLCJ3ZWJob3N0IiwiY2hpbGRBY2NvdW50IiwicHJvX3N0YXR1cyIsImdlbmVyYXRlUGFyYW1zIiwicGF0aCIsInBhcmFtcyIsIm1ldGhvZCIsImhvc3RUeXBlIiwiaGVhZGVyIiwicGFyYW0iLCJjb25zb2xlIiwibG9nIiwiSlNPTiIsInN0cmluZ2lmeSIsImFzeW5jIiwiY29udGVudEFjdGlvbiIsImFjdGlvbiIsImRhdGEiLCIkbmF0aXZlQVBJIiwiY29udGVudEJyaWRnZSIsInNldE5hdGl2ZURhdGEiLCJnZXROYXRpdmVEYXRhIiwiJGRhdGEiLCJuYXYiLCJjb250ZW50TmF2TGlzdCIsIm5ld3NOYXZMaXN0IiwiZGVlcE5hdkxpc3QiLCJhbGxOYXZMaXN0Iiwic2F2ZU5hdlN0YXR1cyIsImdpcmREYXRhTGlzdCIsInRhYlNlbGVjdExpc3QiLCIkZXZlbnQiLCJpbml0TmF0aXZlRGF0YSIsIm5hdGl2ZUpzb24iLCJwYXJzZSIsImdldENvbnRlbnROYXYiLCJnZXRDb250ZW50TmF2aWdhdGlvbiIsImdldE5ld3NOYXYiLCJnZXROZXdzTmF2aWdhdGlvbiIsImdldERlZXBOYXYiLCJnZXREZWVwTmF2aWdhdGlvbiIsImdldEFsbE5ld3NOYXYiLCJnZXRBbGxOZXdzTmF2aWdhdGlvbiIsImluaXRTZWxlY3Rpb25JdGVtIiwianNvblBhcmFtcyIsIm9uSXRlbUNsaWNrIiwicG9zaXRpb24iLCJzYXZlTmF2Iiwic2F2ZU5hdmlnYXRpb24iLCJnZXRTZWxlY3RlZEl0ZW0iLCJyZXF1ZXN0UGFyYW1zIiwicmVzcG9uc2VTdHJpbmciLCJyZXF1ZXN0IiwicmVzcG9uc2UiLCJjb2RlIiwibGVuZ3RoIiwiZSIsImVycm9yIiwiaSIsIml0ZW0iLCJpc0Nob29zZSIsInRleHRDb2xvciIsImJhY2tncm91bmRDb2xvciIsImluZGV4IiwiY2VsbFR5cGUiLCJzZWxlY3RlZEl0ZW1zIiwicHVzaCIsInJhd09iamVjdCIsImlkeCIsImlzRml4ZWQiLCJkaWN0IiwibmF0aXZlUmVzIiwiaW5pdFJlcyIsImluaXRBbGxSZXMiLCJiYXNlQ29sb3JNYWpvclRoZW1lMTAwIiwiYmFzZUNvbG9yUHJpbWFyeVRleHQiLCJiYXNlQ29sb3JQcmltYXJ5VGV4dDA3MCIsImJhc2VDb2xvclNlY29uZGFyeVRleHQiLCJiYXNlQ29sb3JTZWNvbmRhcnlUZXh0TmV3IiwiYmFzZUNvbG9yVGhyZWVMZXZlbFRleHQiLCJiYXNlQ29sb3JDb250ZW50QmFja2dyb3VuZCIsImJhc2VDb2xvcklucHV0QmFja2dyb3VuZCIsImJnX2hvdF9jb21tZW50IiwiYmFzZUNvbG9yUHJpbWFyeVNlcGFyYXRvciIsImVDb250ZW50VGFiRGlhbG9nQmFja2dyb3VuZCIsImluZm9ybWF0aW9uQ29tbWVudCIsImluZm9ybWF0aW9uTGlrZSIsImluZm9ybWF0aW9uTGlrZUZvY3VzIiwiaW5mb3JtYXRpb25TaGFyZSIsImNvaW5UYWdCZyIsImdldE5hdGl2ZVJlcyIsImZsYXNoQ29udGVudExpc3QiLCJ0ZW1wRmxhc2hMaXN0IiwiZmxhc2hOZXdzIiwicmVmcmVzaENvbnRlbnQiLCJsb2FkTW9yZUNvbnRlbnQiLCJhbGxDb250ZW50TGlzdCIsInRlbXBDYXRlZ29yeUlkIiwibGlzdFJlZnJlc2hTdGF0dXMiLCJsaXN0TG9hZE1vcmVTdGF0dXMiLCJyZXF1ZXN0TGlzdCIsImNhdGVnb3J5SWQiLCJpc01vcmUiLCJyZXF1ZXN0TmV3c0xpc3QiLCJpdGVtQ2xpY2siLCJuZXdzSWQiLCJpc0NvbW1lbnQiLCJvblBhZ2VDaGFuZ2UiLCJzZWxQYWdlIiwib25SZWZyZXNoIiwib25Mb2FkTW9yZSIsImNvaW5UYWdDbGljayIsInN5bWJvbCIsInNoYXJlRmxhc2giLCJpdGVtSW5kZXgiLCJzaGFyZWQiLCJsaWtlIiwibGlrZUZsYXNoIiwibGFzdElzc3VlVGltZSIsImlzc3VlVGltZSIsInN0YXJ0SW5kZXgiLCJzaG93VGltZSIsInJhbmsiLCJjaXJjbGUiLCJ0aW1lTGluZSIsImNvaW5UYWdzIiwidGFnU2hvd1N0YXR1cyIsImZpcnN0U2hvd1N0YXR1cyIsInNuZFNob3dTdGF0dXMiLCJ0aHJTaG93U3RhdHVzIiwiY29pblRhZyIsImNvaW4iLCJmaXJzdFRhZyIsInNuZFRhZyIsInRoclRhZyIsImljb24iLCJwZXJjZW50IiwiY29sb3IiLCJob3RDb21tZW50cyIsImhvdENvbW1lbnRMaXN0IiwiZmlyc3RIb3RTdGF0dXMiLCJzbmRIb3RTdGF0dXMiLCJ0aHJIb3RTdGF0dXMiLCJjb2xvcjEiLCJjb2xvcjIiLCJmaXJzdEhvdCIsImhvdENvbUF1ZGl0b3IiLCJob3RDb21tZW50Iiwic25kSG90IiwidGhySG90IiwicHJhaXNlSWNvbiIsInByYWlzZVN0YXR1cyIsInN0YWNrIiwibGlrZVJlc3VsdCIsImlkIiwicmVzSlNPTiIsInByYWlzZU51bSIsImRlZXBDb250ZW50TGlzdCIsInRlbXBEZWVwTGlzdCIsImRlZXBOZXdzIiwibWVzc2FnZSIsInJlcXVlc3REZWVwTmV3c0xpc3QiLCJuZXdzIiwidXBDb2xvckxpc3QiLCJkb3duQ29sb3JMaXN0IiwiY29tbWFuRGF0YSIsInByaWNlQ29sb3JUeXBlIiwibWFya2V0RGF0YSIsImNvbG9yTW9kZSIsImhhbmRsZVNvY2tldERhdGEiLCJPYmplY3QiLCJhc3NpZ24iLCJzZW5kQ29tbW9uQ29uZmlnIiwicGFyc2VJbnQiLCJyZWRDb2xvckxpc3QiLCJncmVlbkNvbG9yTGlzdCIsIndlYlVybCIsImdldFByaWNlQ29sb3IiLCJyYXRpbyIsInJhdGlvX2FicyIsIk1hdGgiLCJhYnMiLCJjb2xvckxldmVsIiwiY29sb3JIZXhTdHIiLCJmb3JtYXRSYXRpbyIsInVwRG93biIsInByZWZpeCIsInRvU3RyaW5nIiwib3BlblBhZ2UiLCJwYWdlIiwidHlwZSIsIm1vZHVsZURlZmluZSIsIm1vZHVsZU5hbWUiLCJzdGFydEZ1bmN0aW9uIiwiZGVmYXVsdERhdGFGdW5jdGlvbiIsInN0YXJ0IiwibW9kdWxlRXZlbnQiLCJtb2R1bGVEYXRhIiwiZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3kiLCJjdXJyZW5jeSIsImJhc2VVcmwiLCJ0b0xvd2VyQ2FzZSIsImRlZmF1bHREYXRhIiwidGFnTGlzdCIsImNvbW1vbi5tb2R1bGVEZWZpbmUiLCJnZXRDb2luTGlzdCIsImNvaW5zRGF0YSIsImFycmF5IiwibGlzdCIsIm9iaiIsIlN0cmluZyIsImNvbW1vbi5mb3JtYXRSYXRpbyIsInJhdGlvQ29sb3IiLCJjb21tb24uZ2V0UHJpY2VDb2xvciIsImNvaW5EaWN0IiwiY29tbW9uLmNvbW1hbkRhdGEiLCJkZWNpbWFsRGVsdGEiLCJ0b0ZpeGVkIiwiY29tbW9uLmdldFBOR0ljb25VUkxCeUN1cnJlbmN5IiwicmVzZXRDb2luTGlzdERhdGEiLCJqdW1wVG9LbGluZSIsIm1vZGVsIiwiY29tbW9uLm9wZW5QYWdlIiwic2VuZFRvcGljRGF0YSIsImF0dGl0dWRlSW5mbyIsImF0dGl0dWRlIiwiY29tbW9uLnNlbmRDb21tb25Db25maWciLCJzZW5kU29ja2V0RGF0YSIsImNvbW1vbi5oYW5kbGVTb2NrZXREYXRhIiwiY29pblRhZ3MucmVzZXRDb2luTGlzdERhdGEiXSwibWFwcGluZ3MiOiJBQUFBLElBQUlBLGFBQWE7SUFDYkMsU0FBUztJQUNUQyxVQUFVO0lBQ1ZDLFdBQVc7SUFDWEMsS0FBSztJQUNMQyxVQUFVO0lBQ1ZDLFNBQVM7SUFDVEMsZUFBZTtJQUNmQyxVQUFVO0lBQ1ZDLFVBQVU7SUFDVkMsU0FBUztJQUNUQyxjQUFjO0lBQ2RDLGFBQWE7OztBQVlWLFNBQVNDLGVBQWVDLE1BQU1DLFNBQVMsSUFBSUMsU0FBUyxHQUFHQyxXQUFXLEdBQUdDLFNBQVM7SUFDakYsTUFBTUMsUUFBUTtRQUNWTDtRQUNBRTtRQUNBQztRQUNBQztRQUNBSDs7SUFFSkssUUFBUUMsSUFBSSxxQkFBcUJGO0lBQ2pDLE9BQU9HLEtBQUtDLFVBQVVKO0FBQzFCOztBQU9PSyxlQUFlQyxjQUFjQyxRQUFRQztJQUN4QyxhQUFhQyxXQUFXQyxjQUFjO1FBQUVILFFBQVVBO1FBQVFDLE1BQVFBOztBQUN0RTs7QUFFTyxTQUFTRyxjQUFjSDtJQUMxQjNCLGFBQWEyQjtBQUNqQjs7QUFFTyxTQUFTSTtJQUNaLE9BQU8vQjtBQUNYOztBQ2pEQWdDLE1BQU1DLE1BQU07SUFDUkMsZ0JBQWdCO0lBQ2hCQyxhQUFhO0lBQ2JDLGFBQWE7SUFDYkMsWUFBWTtJQUNaQyxnQkFBZ0I7SUFDaEJDLGNBQWM7SUFDZEMsZUFBZTs7O0FBR25CQyxPQUFPUixNQUFNO0lBQ1QsY0FBQVMsQ0FBZUM7UUFDWGIsY0FBY1IsS0FBS3NCLE1BQU1EO0FBQzVCO0lBQ0QsYUFBQUU7UUFDSUM7QUFDSDtJQUNELFVBQUFDO1FBQ0lDO0FBQ0g7SUFDRCxVQUFBQztRQUNJQztBQUNIO0lBQ0QsYUFBQUM7UUFDSUM7QUFDSDtJQUNELGlCQUFBQyxDQUFrQkM7UUFDZEQsa0JBQWtCQztBQUNyQjtJQUNELFdBQUFDLENBQVlDO1FBQ1JELFlBQVlDO0FBQ2Y7SUFDRCxPQUFBQyxDQUFRMUM7UUFDQTJDLGVBQWUzQztBQUNsQjtJQUNMLGVBQUE0QztRQUNJQTtBQUNIOzs7QUFHTG5DLGVBQWVzQjtJQUNYLE1BQU1jLGdCQUFnQi9DLGVBQWUsaUNBQWlDLElBQUksR0FBRztJQUM3RTtRQUNJLE1BQU1nRCx1QkFBdUJqQyxXQUFXa0MsUUFBUUY7UUFDaEQsTUFBTUcsV0FBV3pDLEtBQUtzQixNQUFNaUI7UUFDNUIsT0FBTUcsTUFBRUEsTUFBSXJDLE1BQUVBLFFBQVNvQztRQUN2QixJQUFJQyxRQUFRLE9BQU9yQyxLQUFLc0MsU0FBUyxHQUFHO1lBQ2hDakMsTUFBTUMsSUFBSUMsaUJBQWlCUDtBQUM5QjtBQUNKLE1BQUMsT0FBT3VDO1FBQ0w5QyxRQUFRK0MsTUFBTSw4QkFBOEJEO0FBQy9DO0FBQ0w7O0FBRUExQyxlQUFld0I7SUFDWCxNQUFNWSxnQkFBZ0IvQyxlQUFlLDBDQUEwQyxJQUFJLEdBQUc7SUFDdEY7UUFDSSxNQUFNZ0QsdUJBQXVCakMsV0FBV2tDLFFBQVFGO1FBQ2hELE1BQU1HLFdBQVd6QyxLQUFLc0IsTUFBTWlCO1FBQzVCLE9BQU1HLE1BQUVBLE1BQUlyQyxNQUFFQSxRQUFTb0M7UUFDdkIsSUFBSUMsUUFBUSxPQUFPckMsS0FBS3NDLFNBQVMsR0FBRztZQUNoQ2pDLE1BQU1DLElBQUlFLGNBQWNSO0FBQzNCO0FBQ0osTUFBQyxPQUFPdUM7UUFDTDlDLFFBQVErQyxNQUFNLDJCQUEyQkQ7QUFDNUM7QUFDTDs7QUFFQTFDLGVBQWUwQjtJQUNYLE1BQU1VLGdCQUFnQi9DLGVBQWUsb0NBQW9DLElBQUksR0FBRztJQUNoRjtRQUNJLE1BQU1nRCx1QkFBdUJqQyxXQUFXa0MsUUFBUUY7UUFDaEQsTUFBTUcsV0FBV3pDLEtBQUtzQixNQUFNaUI7UUFDNUIsT0FBTUcsTUFBRUEsTUFBSXJDLE1BQUVBLFFBQVNvQztRQUN2QixJQUFJQyxRQUFRLE9BQU9yQyxLQUFLc0MsU0FBUyxHQUFHO1lBQ2hDakMsTUFBTUMsSUFBSUcsY0FBY1Q7QUFDM0I7QUFDSixNQUFDLE9BQU91QztRQUNMOUMsUUFBUStDLE1BQU0sMkJBQTJCRDtBQUM1QztBQUNMOztBQUVBMUMsZUFBZTRCO0lBQ1gsTUFBTVEsZ0JBQWdCL0MsZUFBZSw4Q0FBOEMsSUFBSSxHQUFHO0lBQzFGO1FBQ0ksTUFBTWdELHVCQUF1QmpDLFdBQVdrQyxRQUFRRjtRQUNoRCxNQUFNRyxXQUFXekMsS0FBS3NCLE1BQU1pQjtRQUM1QixPQUFNRyxNQUFFQSxNQUFJckMsTUFBRUEsUUFBU29DO1FBQ3ZCLElBQUlDLFFBQVEsT0FBT3JDLEtBQUtzQyxTQUFTLEdBQUc7WUFDaENqQyxNQUFNQyxJQUFJSSxhQUFhVjtBQUMxQjtBQUNKLE1BQUMsT0FBT3VDO1FBQ0w5QyxRQUFRK0MsTUFBTSw4QkFBOEJEO0FBQy9DO0FBQ0w7O0FBRUExQyxlQUFlNkIsa0JBQWtCQztJQUM3QjtRQUNJLElBQUl2QyxTQUFTTyxLQUFLc0IsTUFBTVU7UUFDeEIsS0FBSyxJQUFJYyxJQUFJLEdBQUdBLElBQUlyRCxPQUFPa0QsUUFBUUcsS0FBSztZQUNwQyxJQUFJQyxPQUFPdEQsT0FBT3FEO1lBQ2xCLElBQUlDLEtBQUtDLFlBQVksR0FBRztnQkFDcEJELEtBQUtFLFlBQVl4QyxnQkFBZ0I1QixZQUFZLFlBQVk7Z0JBQ3pEa0UsS0FBS0csa0JBQWtCekMsZ0JBQWdCNUIsWUFBWSxjQUFjO0FBQ2pGLG1CQUFtQjtnQkFDSGtFLEtBQUtFLFlBQVl4QyxnQkFBZ0I1QixZQUFZLFlBQVk7Z0JBQ3pEa0UsS0FBS0csa0JBQWtCekMsZ0JBQWdCNUIsWUFBWSxZQUFZO0FBQ2xFO1lBQ0RrRSxLQUFLSSxRQUFRTDtZQUNiQyxLQUFLSyxXQUFXO0FBQ25CO1FBQ0QxQyxNQUFNQyxJQUFJTSxlQUFleEI7QUFDNUIsTUFBQyxPQUFPbUQ7UUFDTDlDLFFBQVErQyxNQUFNLDJCQUEyQkQ7QUFDNUM7QUFDTDs7QUFFQSxTQUFTUDtJQUNMO1FBQ0ksTUFBTWdCLGdCQUFnQjtRQUN0QixLQUFLLElBQUlQLElBQUksR0FBR0EsSUFBSXBDLE1BQU1DLElBQUlNLGFBQWEwQixRQUFRRyxLQUFLO1lBQ3BELElBQUlDLE9BQU9yQyxNQUFNQyxJQUFJTSxhQUFhNkI7WUFDbENoRCxRQUFRQyxJQUFJLGlCQUFpQmdELEtBQUtDO1lBQ2xDLElBQUlELEtBQUtDLFlBQVksR0FBRztnQkFDcEJLLGNBQWNDLEtBQUtQLEtBQUtRO0FBQzNCO0FBQ0o7UUFDRHpELFFBQVFDLElBQUksaUJBQWlCQyxLQUFLQyxVQUFVb0Q7UUFDNUMzQyxNQUFNQyxJQUFJTyxnQkFBZ0JtQztBQUM3QixNQUFDLE9BQU9UO1FBQ0w5QyxRQUFRK0MsTUFBTSx5QkFBeUJEO0FBQzFDO0FBQ0w7O0FBRUExQyxlQUFlK0IsWUFBWXVCO0lBQ3ZCO1FBQ0ksSUFBSVQsT0FBT3JDLE1BQU1DLElBQUlNLGFBQWF1QztRQUNsQyxJQUFJVCxLQUFLVSxXQUFXLEdBQUc7WUFDbkIsSUFBSVYsS0FBS0MsWUFBWSxHQUFHO2dCQUNwQkQsS0FBS0UsWUFBWXhDLGdCQUFnQjVCLFlBQVksWUFBWTtnQkFDekRrRSxLQUFLRyxrQkFBa0J6QyxnQkFBZ0I1QixZQUFZLFlBQVk7Z0JBQy9Ea0UsS0FBS0MsV0FBVztBQUNoQyxtQkFBbUI7Z0JBQ0hELEtBQUtFLFlBQVl4QyxnQkFBZ0I1QixZQUFZLFlBQVk7Z0JBQ3pEa0UsS0FBS0csa0JBQWtCekMsZ0JBQWdCNUIsWUFBWSxjQUFjO2dCQUNqRWtFLEtBQUtDLFdBQVc7QUFDbkI7QUFDSjtBQUNKLE1BQUMsT0FBT0o7UUFDTDlDLFFBQVErQyxNQUFNLHFCQUFxQkQ7QUFDdEM7QUFDTDs7QUFPQTFDLGVBQWVrQyxlQUFlM0M7SUFDMUIsSUFBSWlFLE9BQU8sQ0FBQTtJQUNYQSxLQUFLLGlCQUFpQmpFO0lBQ3RCSyxRQUFRQyxJQUFJLGtCQUFrQk47SUFDOUIsTUFBTTZDLGdCQUFnQi9DLGVBQWUsaUNBQWlDbUUsTUFBTSxHQUFHLEdBQUc7UUFBRSxnQkFBZ0I7O0lBQ3BHO1FBQ0ksTUFBTW5CLHVCQUF1QmpDLFdBQVdrQyxRQUFRRjtRQUNoRCxNQUFNRyxXQUFXekMsS0FBS3NCLE1BQU1pQjtRQUM1QixPQUFNRyxNQUFFQSxNQUFJckMsTUFBRUEsUUFBU29DO1FBQ3ZCL0IsTUFBTUMsSUFBSUssZ0JBQWdCMEI7QUFDN0IsTUFBQyxPQUFPRTtRQUNMbEMsTUFBTUMsSUFBSUssaUJBQWlCO1FBQzNCbEIsUUFBUStDLE1BQU0sd0JBQXdCRDtBQUN6QztBQUNMOztBQzVLQWxDLE1BQU1pRCxZQUFZO0lBQ2RBLFdBQVUsQ0FBRTs7O0FBR2hCeEMsT0FBT3dDLFlBQVk7SUFDZixPQUFBQztRQUNJQztBQUNIOzs7QUFHTDNELGVBQWUyRDtJQUNYbkQsTUFBTWlELFVBQVVBLFVBQVVHLHlCQUF5QnJELGdCQUFnQjVCLFlBQVksWUFBWTtJQUMzRjZCLE1BQU1pRCxVQUFVQSxVQUFVSSx1QkFBdUJ0RCxnQkFBZ0I1QixZQUFZLFlBQVk7SUFDekY2QixNQUFNaUQsVUFBVUEsVUFBVUssMEJBQTBCdkQsZ0JBQWdCNUIsWUFBWSxjQUFjO0lBQzlGNkIsTUFBTWlELFVBQVVBLFVBQVVNLHlCQUF5QnhELGdCQUFnQjVCLFlBQVksWUFBWTtJQUMzRjZCLE1BQU1pRCxVQUFVQSxVQUFVTyw0QkFBNEJ6RCxnQkFBZ0I1QixZQUFZLFlBQVk7SUFDOUY2QixNQUFNaUQsVUFBVUEsVUFBVVEsMEJBQTBCMUQsZ0JBQWdCNUIsWUFBWSxZQUFZO0lBQzVGNkIsTUFBTWlELFVBQVVBLFVBQVVTLDZCQUE2QjNELGdCQUFnQjVCLFlBQVksWUFBWTtJQUMvRjZCLE1BQU1pRCxVQUFVQSxVQUFVVSwyQkFBMkI1RCxnQkFBZ0I1QixZQUFZLFlBQVk7SUFDN0Y2QixNQUFNaUQsVUFBVUEsVUFBVVcsaUJBQWlCN0QsZ0JBQWdCNUIsWUFBWSxZQUFZO0lBQ25GNkIsTUFBTWlELFVBQVVBLFVBQVVZLDRCQUE0QjlELGdCQUFnQjVCLFlBQVksWUFBWTtJQUM5RjZCLE1BQU1pRCxVQUFVQSxVQUFVYSw4QkFBOEIvRCxnQkFBZ0I1QixZQUFZLFlBQVk7SUFDaEc2QixNQUFNaUQsVUFBVUEsVUFBVWMscUJBQXFCaEUsZ0JBQWdCNUIsWUFBWSwyQ0FBMkM7SUFDdEg2QixNQUFNaUQsVUFBVUEsVUFBVWUsa0JBQWtCakUsZ0JBQWdCNUIsWUFBWSxxQ0FBcUM7SUFDN0c2QixNQUFNaUQsVUFBVUEsVUFBVWdCLHVCQUF1QmxFLGdCQUFnQjVCLFlBQVksMkNBQTJDO0lBQ3hINkIsTUFBTWlELFVBQVVBLFVBQVVpQixtQkFBbUJuRSxnQkFBZ0I1QixZQUFZLDJDQUEyQztJQUVwSDZCLE1BQU1pRCxVQUFVQSxVQUFVa0IsWUFBWXBFLGdCQUFnQjVCLFlBQVksWUFBWTtBQUNsRjs7QUFFTyxTQUFTaUc7SUFDWixPQUFPcEUsTUFBTWlELFVBQVVBO0FBQzNCOztBQy9CQSxJQUFJb0IsbUJBQWlCOztBQUNyQixJQUFJQyxnQkFBYzs7QUFFbEJ0RSxNQUFNdUUsWUFBWTtJQUNkQyxnQkFBZ0I7SUFDaEJDLGlCQUFpQjtJQUNqQkMsZ0JBQWdCO0lBQ2hCQyxnQkFBZ0I7SUFDaEJDLG1CQUFtQjtJQUNuQkMsb0JBQW9COzs7QUFHeEJwRSxPQUFPOEQsWUFBWTtJQUNmLFdBQUFPLENBQVlDLFlBQVlDO1FBQ3BCQyxnQkFBZ0JGLFlBQVlDO0FBQy9CO0lBQ0QsU0FBQUUsQ0FBVUMsUUFBUUM7UUFDZDNGLGNBQWMsZUFBZSxXQUFXMEYsU0FBUyxrQkFBa0JDLFlBQVk7QUFDbEY7SUFDRCxZQUFBQyxDQUFhTjtRQUNUTyxVQUFRUDtBQUNYO0lBQ0QsU0FBQVE7UUFDSU4sZ0JBQWdCakYsTUFBTXVFLFVBQVVJLGdCQUFnQjtBQUNuRDtJQUNELFVBQUFhO1FBQ0lQLGdCQUFnQmpGLE1BQU11RSxVQUFVSSxnQkFBZ0I7QUFDbkQ7SUFDRCxZQUFBYyxDQUFhQztRQUNUakcsY0FBYyxhQUFhaUc7QUFDOUI7SUFDRCxVQUFBQyxDQUFXQztRQUNQbkcsY0FBYyxjQUFjSCxLQUFLQyxVQUFVOEUsaUJBQWlCdUI7UUFDNUR2QixpQkFBaUJ1QixXQUFXQyxVQUFVO1FBQ3RDN0YsTUFBTXVFLFVBQVVHLGlCQUFpQkw7QUFDcEM7SUFDRCxJQUFBeUIsQ0FBS0Y7UUFDREcsVUFBVUg7QUFDYjs7O0FBR0xwRyxlQUFleUYsZ0JBQWdCRixZQUFZQztJQUN2Q2hGLE1BQU11RSxVQUFVSSxpQkFBaUJJO0lBQ2pDLElBQUkvQixPQUFPLENBQUE7SUFDWCxJQUFJZ0MsUUFBUTtRQUNSLElBQUlYLGlCQUFpQnBDLFVBQVUsR0FBRztRQUNsQyxJQUFJK0QsZ0JBQWdCM0IsaUJBQWlCQSxpQkFBaUJwQyxTQUFTLEdBQUdnRTtRQUNsRTdHLFFBQVFDLElBQUksK0JBQStCMkc7UUFDM0NoRCxLQUFLLG1CQUFtQmdELGdCQUFnQjtBQUMzQztJQUNEaEQsS0FBSyxVQUFVO0lBQ2ZBLEtBQUssZ0JBQWdCK0I7SUFDckIsTUFBTW5ELGdCQUFnQi9DLGVBQWUsc0NBQXNDbUUsTUFBTSxHQUFHO0lBQ3BGO1FBQ0loRCxNQUFNdUUsVUFBVUssb0JBQW9CO1FBQ3BDNUUsTUFBTXVFLFVBQVVNLHFCQUFxQjtRQUNyQyxNQUFNaEQsdUJBQXVCakMsV0FBV2tDLFFBQVFGO1FBQ2hELE1BQU1HLFdBQVd6QyxLQUFLc0IsTUFBTWlCO1FBQzVCLE9BQU1HLE1BQUNBLE1BQUlyQyxNQUFFQSxRQUFRb0M7UUFDckIsSUFBSXBDLFFBQVEsUUFBUUEsS0FBS3NDLFNBQVMsR0FBRztZQUNqQyxJQUFJaUUsYUFBYTdCLGlCQUFpQnBDO1lBQ2xDLEtBQUssSUFBSUksUUFBUTFDLE1BQU07Z0JBQ25CMEMsS0FBS3VELFlBQVlNO2dCQUNqQkE7Z0JBQ0E3RCxLQUFLOEQsaUJBQWlCMUcsY0FBYyxXQUFXNEMsS0FBSzRELFlBQVk7Z0JBQ2hFLElBQUk1RCxLQUFLK0QsUUFBUSxHQUFHO29CQUNoQi9ELEtBQUtnRSxTQUFTdEcsZ0JBQWdCNUIsWUFBWSx5Q0FBeUM7b0JBQ25Ga0UsS0FBS2lFLFdBQVd2RyxnQkFBZ0I1QixZQUFZLFlBQVk7QUFDNUUsdUJBQXVCO29CQUNIa0UsS0FBS2dFLFNBQVN0RyxnQkFBZ0I1QixZQUFZLG9EQUFvRDtvQkFDOUZrRSxLQUFLaUUsV0FBV3ZHLGdCQUFnQjVCLFlBQVksWUFBWTtBQUMzRDtnQkFDRCxJQUFJb0ksV0FBV2xFLEtBQUtrRTtnQkFDcEJsRSxLQUFLbUUsZ0JBQWdCO2dCQUNyQm5FLEtBQUtvRSxrQkFBa0I7Z0JBQ3ZCcEUsS0FBS3FFLGdCQUFnQjtnQkFDckJyRSxLQUFLc0UsZ0JBQWdCO2dCQUNyQixJQUFJQyxVQUFVLENBQUU7Z0JBQ2hCQSxRQUFRQyxPQUFPO2dCQUNmeEUsS0FBS3lFLFdBQVdGO2dCQUNoQnZFLEtBQUswRSxTQUFTSDtnQkFDZHZFLEtBQUsyRSxTQUFTSjtnQkFDZCxJQUFJTCxTQUFTdEUsU0FBUyxHQUFHO29CQUNyQkksS0FBS21FLGdCQUFnQjtvQkFDckJuRSxLQUFLeUUsV0FBV3pFLEtBQUtrRSxTQUFTO29CQUM5QmxFLEtBQUt5RSxTQUFTRyxhQUFheEgsY0FBYyxZQUFZNEMsS0FBS3lFLFNBQVNEO29CQUNuRXhFLEtBQUt5RSxTQUFTSSxnQkFBZ0J6SCxjQUFjLGVBQWU0QyxLQUFLeUUsU0FBU3BCO29CQUN6RXJELEtBQUt5RSxTQUFTSyxjQUFjMUgsY0FBYyxnQkFBZ0I0QyxLQUFLeUUsU0FBU3BCO29CQUN4RXJELEtBQUtvRSxrQkFBZ0I7QUFDeEI7Z0JBQ0QsSUFBSUYsU0FBU3RFLFNBQVMsR0FBRztvQkFDckJJLEtBQUswRSxTQUFTMUUsS0FBS2tFLFNBQVM7b0JBQzVCbEUsS0FBSzBFLE9BQU9FLGFBQWF4SCxjQUFjLFlBQVk0QyxLQUFLMEUsT0FBT0Y7b0JBQy9EeEUsS0FBSzBFLE9BQU9HLGdCQUFpQnpILGNBQWMsZUFBZTRDLEtBQUswRSxPQUFPckI7b0JBQ3RFckQsS0FBSzBFLE9BQU9JLGNBQWUxSCxjQUFjLGdCQUFnQjRDLEtBQUswRSxPQUFPckI7b0JBQ3JFckQsS0FBS3FFLGdCQUFnQjtBQUN4QjtnQkFDRCxJQUFJSCxTQUFTdEUsU0FBUyxHQUFHO29CQUNyQkksS0FBSzJFLFNBQVMzRSxLQUFLa0UsU0FBUztvQkFDNUJsRSxLQUFLMkUsT0FBT0MsYUFBYXhILGNBQWMsWUFBWTRDLEtBQUsyRSxPQUFPSDtvQkFDL0R4RSxLQUFLMkUsT0FBT0UsZ0JBQWdCekgsY0FBYyxlQUFlNEMsS0FBSzJFLE9BQU90QjtvQkFDckVyRCxLQUFLMkUsT0FBT0csY0FBYzFILGNBQWMsZ0JBQWdCNEMsS0FBSzJFLE9BQU90QjtvQkFDcEVyRCxLQUFLc0UsZ0JBQWdCO0FBQ3hCO2dCQUNELElBQUlTLGNBQWMvRSxLQUFLZ0Y7Z0JBQ3ZCaEYsS0FBS2lGLGlCQUFpQjtnQkFDdEJqRixLQUFLa0YsZUFBZTtnQkFDcEJsRixLQUFLbUYsZUFBZTtnQkFDcEIsTUFBTUMsU0FBUzFILGdCQUFnQjVCLFlBQVksWUFBWTtnQkFDdkQsTUFBTXVKLFNBQVMzSCxnQkFBZ0I1QixZQUFZLFlBQVk7Z0JBQ3ZELElBQUlpSixZQUFZbkYsU0FBUyxHQUFHO29CQUN4QkksS0FBS2lGLGlCQUFpQjtvQkFDdEJqRixLQUFLc0YsV0FBVyxlQUFlRixzQkFBc0JwRixLQUFLZ0YsZUFBZSxHQUFHTyxvQ0FBb0NGLHNCQUFzQnJGLEtBQUtnRixlQUFlLEdBQUdRO0FBRWhLO2dCQUNELElBQUlULFlBQVluRixTQUFTLEdBQUc7b0JBQ3hCSSxLQUFLa0YsZUFBZTtvQkFDcEJsRixLQUFLeUYsU0FBUyxlQUFlTCxzQkFBc0JwRixLQUFLZ0YsZUFBZSxHQUFHTyxvQ0FBb0NGLHNCQUFzQnJGLEtBQUtnRixlQUFlLEdBQUdRO0FBRTlKO2dCQUNELElBQUlULFlBQVluRixTQUFTLEdBQUc7b0JBQ3hCSSxLQUFLbUYsZUFBZTtvQkFDcEJuRixLQUFLMEYsU0FBUyxlQUFlTixzQkFBc0JwRixLQUFLZ0YsZUFBZSxHQUFHTyxvQ0FBb0NGLHNCQUFzQnJGLEtBQUtnRixlQUFlLEdBQUdRO0FBRTlKO2dCQUNEeEYsS0FBSzJGLGFBQWEzRixLQUFLNEYsZ0JBQWdCLElBQUk3RCxlQUFlSCx1QkFBdUJHLGVBQWVKO2dCQUNoRzVFLFFBQVFDLElBQUksNkJBQTZCQyxLQUFLQyxVQUFVOEM7QUFDM0Q7QUFDSjtRQUNELEtBQUsyQyxRQUFRO1lBQ1RoRixNQUFNdUUsVUFBVUMsaUJBQWlCN0U7WUFDakMsSUFBSXFDLFFBQVEsT0FBT3JDLEtBQUtzQyxTQUFTLEdBQUc7Z0JBQ2hDb0MsbUJBQW1CMUU7Z0JBQ25CSyxNQUFNdUUsVUFBVUcsaUJBQWlCTDtnQkFDakNDLGNBQWNTLGNBQWNWO0FBQy9CO0FBQ2IsZUFBZTtZQUNIckUsTUFBTXVFLFVBQVVFLGtCQUFrQjlFO1lBQ2xDLElBQUlxQyxRQUFRLE9BQU9yQyxLQUFLc0MsU0FBUyxHQUFHO2dCQUNoQ29DLGlCQUFpQnpCLFFBQVFqRDtnQkFDekJLLE1BQU11RSxVQUFVRyxpQkFBaUJMO2dCQUNqQ0MsY0FBY1MsY0FBY1Y7QUFDL0I7QUFDSjtBQUNKLE1BQUMsT0FBT25DO1FBQ0w5QyxRQUFRK0MsTUFBTUQsRUFBRWdHO1FBQ2hCOUksUUFBUStDLE1BQU0seUJBQXlCRDtBQUMxQztBQUNMOztBQUVBMUMsZUFBZThGLFVBQVFQO0lBQ25CL0UsTUFBTXVFLFVBQVVJLGlCQUFpQkk7SUFDakNWLG1CQUFtQkMsY0FBY1M7SUFDakMvRSxNQUFNdUUsVUFBVUcsaUJBQWlCTDtBQUNyQzs7QUFFQTdFLGVBQWV1RyxVQUFVSDtJQUNyQjtRQUNJLElBQUl1QyxtQkFBbUIxSSxjQUFjLFFBQVEsWUFBWTRFLGlCQUFpQnVCLFdBQVd3QyxLQUFLO1FBQzFGLE1BQU1DLFVBQVUvSSxLQUFLc0IsTUFBTXVIO1FBQzNCLE9BQU1HLFdBQUNBLFdBQVNMLGNBQUVBLGdCQUFnQkk7UUFDbENoRSxpQkFBaUJ1QixXQUFXMEMsWUFBWUE7UUFDeENqRSxpQkFBaUJ1QixXQUFXcUMsZUFBZUE7UUFDM0M1RCxpQkFBaUJ1QixXQUFXb0MsYUFBYUMsZ0JBQWdCLElBQUk3RCxlQUFlSCx1QkFBdUJHLGVBQWVKO1FBQ2xIaEUsTUFBTXVFLFVBQVVHLGlCQUFpQkw7QUFDcEMsTUFBQyxPQUFNbkM7UUFDSjlDLFFBQVErQyxNQUFNRCxFQUFFZ0c7UUFDaEI5SSxRQUFRK0MsTUFBTSxtQkFBbUJEO0FBQ3BDO0FBQ0w7O0FDMUtBLElBQUlxRyxrQkFBZ0I7O0FBQ3BCLElBQUlDLGVBQWE7O0FBRWpCeEksTUFBTXlJLFdBQVc7SUFDYnpHLE1BQU07SUFDTjBHLFNBQVM7SUFDVGxFLGdCQUFnQjtJQUNoQkMsaUJBQWlCO0lBQ2pCQyxnQkFBZ0I7SUFDaEJDLGdCQUFnQjtJQUNoQkMsbUJBQW1CO0lBQ25CQyxvQkFBb0I7OztBQUd4QnBFLE9BQU9nSSxXQUFXO0lBQ2QsV0FBQTNELENBQVlDLFlBQVlDO1FBQ3BCMkQsb0JBQW9CNUQsWUFBWUM7QUFDbkM7SUFDRCxTQUFBRSxDQUFVQztRQUNOMUYsY0FBYyxjQUFjMEYsU0FBUztBQUN4QztJQUNELFlBQUFFLENBQWFOO1FBQ1RPLFFBQVFQO0FBQ1g7SUFDRCxTQUFBUTtRQUNJb0Qsb0JBQW9CM0ksTUFBTXlJLFNBQVM5RCxnQkFBZ0I7QUFDdEQ7SUFDRCxVQUFBYTtRQUNJbUQsb0JBQW9CM0ksTUFBTXlJLFNBQVM5RCxnQkFBZ0I7QUFDdEQ7OztBQUdMbkYsZUFBZW1KLG9CQUFvQjVELFlBQVlDO0lBQzNDaEYsTUFBTXlJLFNBQVM5RCxpQkFBaUJJO0lBQ2hDLElBQUkvQixPQUFPLENBQUE7SUFDWCxJQUFJZ0MsUUFBUTtRQUNSLElBQUl1RCxnQkFBZ0J0RyxVQUFVLEdBQUc7UUFDakMsSUFBSStELGdCQUFnQnVDLGdCQUFnQkEsZ0JBQWdCdEcsU0FBUyxHQUFHMkcsS0FBSzNDO1FBQ3JFN0csUUFBUUMsSUFBSSw4QkFBOEIyRztRQUMxQ2hELEtBQUssZUFBZWdELGdCQUFnQjtBQUN2QztJQUNEaEQsS0FBSyxVQUFVO0lBQ2ZBLEtBQUssZ0JBQWdCK0I7SUFDckIsTUFBTW5ELGdCQUFnQi9DLGVBQWUsd0JBQXdCbUUsTUFBTSxHQUFHO0lBQ3RFO1FBQ0loRCxNQUFNeUksU0FBUzdELG9CQUFvQjtRQUNuQzVFLE1BQU15SSxTQUFTNUQscUJBQXFCO1FBQ3BDLE1BQU1oRCx1QkFBdUJqQyxXQUFXa0MsUUFBUUY7UUFDaEQsTUFBTUcsV0FBV3pDLEtBQUtzQixNQUFNaUI7UUFDNUIsT0FBTUcsTUFBQ0EsTUFBSXJDLE1BQUVBLFFBQVFvQztRQUNyQixJQUFJcEMsUUFBUSxRQUFRQSxLQUFLc0MsU0FBUyxHQUFHO1lBQ2pDLEtBQUssSUFBSUksUUFBUTFDLE1BQU07Z0JBQ25CMEMsS0FBSzhELGlCQUFpQjFHLGNBQWMsaUJBQWlCNEMsS0FBS3VHLEtBQUszQyxZQUFZO0FBQzlFO0FBQ0o7UUFDRCxLQUFLakIsUUFBUTtZQUNUaEYsTUFBTXlJLFNBQVNqRSxpQkFBaUI3RTtZQUNoQyxJQUFJcUMsUUFBUSxPQUFPckMsS0FBS3NDLFNBQVMsR0FBRztnQkFDaENzRyxrQkFBa0I1STtnQkFDbEJLLE1BQU15SSxTQUFTL0QsaUJBQWlCNkQ7Z0JBQ2hDQyxhQUFhekQsY0FBY3dEO0FBQzlCO0FBQ2IsZUFBZTtZQUNIdkksTUFBTXlJLFNBQVNoRSxrQkFBa0I5RTtZQUNqQyxJQUFJcUMsUUFBUSxPQUFPckMsS0FBS3NDLFNBQVMsR0FBRztnQkFDaENzRyxnQkFBZ0IzRixRQUFRakQ7Z0JBQ3hCSyxNQUFNeUksU0FBUy9ELGlCQUFpQjZEO2dCQUNoQ0MsYUFBYXpELGNBQWN3RDtBQUM5QjtBQUNKO0FBQ0osTUFBQyxPQUFPckc7UUFDTDlDLFFBQVErQyxNQUFNLGdDQUFnQ0Q7QUFDakQ7QUFDTDs7QUFFQTFDLGVBQWU4RixRQUFRUDtJQUNuQi9FLE1BQU15SSxTQUFTOUQsaUJBQWlCSTtJQUNoQ3dELGtCQUFrQkMsYUFBYXpEO0lBQy9CL0UsTUFBTXlJLFNBQVMvRCxpQkFBaUI2RDtBQUNwQzs7QUNoRkEsSUFBSU07O0FBQ0osSUFBSUM7O0FBRUcsSUFBSUMsYUFBYTtJQUNwQkMsZ0JBQWdCO0lBQ2hCQyxZQUFZLENBQUU7SUFDZEMsV0FBVzs7O0FBR1IxSixlQUFlMkosaUJBQWlCeEo7SUFDbkNvSixXQUFXRSxhQUFhRyxPQUFPQyxPQUFPTixXQUFXRSxZQUFZdEosS0FBS0E7QUFDdEU7O0FBR09ILGVBQWU4SixtQkFBaUJuSztJQUNuQzRKLFdBQVdDLGlCQUFpQk8sU0FBU3BLLE1BQU02SjtJQUMzQ0QsV0FBV0csWUFBWUssU0FBU3BLLE1BQU0rSjtJQUV0QyxJQUFJTSxlQUFlLEVBQUMsV0FBVyxXQUFXLFdBQVc7SUFDckQsSUFBSUMsaUJBQWlCLEVBQUMsV0FBVyxXQUFXLFdBQVc7SUFFdkQsSUFBSUYsU0FBU1IsV0FBV0MsbUJBQW1CLEdBQUc7UUFDMUNILGNBQWNXO1FBQ2RWLGdCQUFnQlc7QUFDeEIsV0FBVztRQUNIWixjQUFjWTtRQUNkWCxnQkFBZ0JVO0FBQ25CO0lBQ0RULFdBQVdXLFNBQVN2SyxNQUFNdUs7QUFDOUI7O0FBR08sU0FBU0MsY0FBY0M7SUFDMUIsSUFBSUEsU0FBUyxNQUFNO1FBQ2ZBLFFBQVE7QUFDWDtJQUNELE1BQU1DLFlBQVlDLEtBQUtDLElBQUlIO0lBQzNCLElBQUlJLGFBQWE7SUFDakIsSUFBSUgsWUFBWSxLQUFLQSxZQUFZLEdBQUc7UUFDaENHLGFBQWE7QUFDaEIsV0FDSSxJQUFJSCxhQUFhLEtBQUtBLFlBQVksR0FBRztRQUN0Q0csYUFBYTtBQUNoQixXQUNJLElBQUlILGFBQWEsR0FBRztRQUNyQkcsYUFBYTtBQUNoQjtJQUNELElBQUlDLGNBQWM7SUFDbEIsSUFBSUwsUUFBUSxHQUFHO1FBQ1hLLGNBQWNwQixZQUFZbUI7QUFDN0IsV0FDSTtRQUNEQyxjQUFjbkIsY0FBY2tCO0FBQy9CO0lBQ0QsT0FBT0M7QUFDWDs7QUFHTyxTQUFTQyxZQUFZQztJQUN4QixJQUFJQyxTQUFTRCxTQUFTLElBQUksTUFBTTtJQUNoQyxPQUFPLEdBQUdDLFNBQVNELE9BQU9FO0FBQzlCOztBQUVPN0ssZUFBZThLLFNBQVNDLE1BQU14TCxTQUFPO1VBQ2xDYSxXQUFXQyxjQUFjO1FBQzNCSCxRQUFRO1FBQ1I4SyxNQUFNO1FBQ05ELE1BQU1BO1FBQ054TCxRQUFRTyxLQUFLQyxVQUFVUjs7QUFFL0I7O0FBRU8sU0FBUzBMLGFBQWFDLFlBQVlDLGVBQWVDO0lBQ3BENUssTUFBTTBLLGNBQWNFO0lBQ3BCbkssT0FBT2lLLGNBQWM7UUFBRUcsT0FBT0Y7O0lBQzlCLE9BQU87UUFDSEcsYUFBYXJLLE9BQU9pSztRQUNwQkssWUFBWS9LLE1BQU0wSzs7QUFFMUI7O0FBOERPLFNBQVNNLHdCQUF3QkM7SUFDcEMsSUFBSUMsVUFBVW5DLFdBQVdXLFNBQVNYLFdBQVdXLFNBQVM7SUFDdEQsT0FBTyxHQUFHd0IsbURBQW1ERCxTQUFTRTtBQUMxRTs7QUMvSUEsU0FBU0M7SUFDTCxPQUFPO1FBQ0hDLFNBQVE7O0FBRWhCOztBQUVBN0wsZUFBZXFMLFNBQ2Y7O0FBRUEsT0FBTUUsWUFBQ0EsWUFBVUQsYUFBRUEsZUFBZVEsYUFBb0IsWUFBWVQsT0FBT087O0FBRXpFTixZQUFZUyxjQUFjL0wsZUFBZ0JnTTtJQUN0QyxJQUFJQyxRQUFRO0lBQ1osTUFBTUMsT0FBT0YsVUFBVTtJQUN2QixLQUFLLElBQUlwSixJQUFJLEdBQUdBLElBQUlzSixLQUFLekosUUFBUUcsS0FBSztRQUNsQyxJQUFJdUosTUFBTUQsS0FBS3RKO1FBQ2Z1SixJQUFJbEosUUFBUW1KLE9BQU94SjtRQUNuQnVKLElBQUluQixPQUFPO1FBQ1gsTUFBTUwsU0FBUztRQUNmd0IsSUFBSXhCLFNBQVMwQixZQUFtQjFCO1FBQ2hDd0IsSUFBSUcsYUFBYUMsY0FBcUI1QjtRQUV0QyxJQUFJekUsU0FBU2lHLElBQUlqRyxPQUFPeUY7UUFDeEIsTUFBTWEsV0FBV0MsV0FBa0JoRCxXQUFXdkQ7UUFDOUMsSUFBSXNHLFlBQVksTUFBTTtZQUNsQixNQUFNN0IsU0FBUzZCLFNBQVNFLGFBQWFDLFFBQVE7WUFDN0NSLElBQUl4QixTQUFTMEIsWUFBbUIxQjtZQUNoQ3dCLElBQUlHLGFBQWFDLGNBQXFCNUI7QUFDekM7UUFDRHdCLElBQUkxRSxPQUFPbUYsd0JBQStCVCxJQUFJOUUsS0FBS3NFLGdCQUNuRE0sTUFBTTdJLEtBQUsrSTtBQUNkO0lBQ0RaLFdBQVdNLFVBQVVJO0FBQ3pCOztBQUVPLFNBQVNZO0lBQ1osSUFBSVgsT0FBT1gsV0FBV007SUFDdEIsS0FBSyxJQUFJakosSUFBSSxHQUFHQSxJQUFJc0osS0FBS3pKLFFBQVFHLEtBQUs7UUFDbEMsSUFBSXVKLE1BQU1ELEtBQUt0SjtRQUNmLElBQUlzRCxTQUFTaUcsSUFBSWpHLE9BQU95RjtRQUN4QixNQUFNYSxXQUFXQyxXQUFrQmhELFdBQVd2RDtRQUM5QyxJQUFJc0csWUFBWSxNQUFNO1lBQ2xCLE1BQU03QixTQUFTNkIsU0FBU0UsYUFBYUMsUUFBUTtZQUM3Q1IsSUFBSXhCLFNBQVMwQixZQUFtQjFCO1lBQ2hDd0IsSUFBSUcsYUFBYUMsY0FBcUI1QjtBQUN6QztBQUNKO0lBQ0RZLFdBQVdNLFVBQVVLO0FBQ3pCOztBQUVBWixZQUFZd0IsY0FBYzlNLGVBQWU4TSxZQUFZN0o7SUFDakQsSUFBSUEsT0FBTztRQUNQLElBQUlMLElBQUltSCxTQUFTOUc7UUFDakIsSUFBSThKLFFBQVF4QixXQUFXTSxRQUFRako7UUFDL0IsSUFBSWpELFFBQVEsQ0FBQTtRQUNaQSxNQUFNMEgsT0FBTzBGLE1BQU0xRjtRQUNuQjFILE1BQU11RyxTQUFTNkcsTUFBTTdHO2NBQ2Y4RyxTQUFnQixTQUFRck47QUFDakM7QUFDTDs7QUNyREEsU0FBU3NOLGNBQWNDO0lBQ25CQyxTQUFTRixjQUFjQztBQUMzQjs7QUFFQWxOLGVBQWU4SixpQkFBaUJuSztVQUN0QnlOLG1CQUF3QnpOO0FBQ2xDOztBQUVBSyxlQUFlcU4sZUFBZWxOO0lBQzFCLElBQUlBLEtBQUs2SyxRQUFRLFVBQVU7UUFDdkJwTCxRQUFRQyxJQUFJTTtjQUNObU4saUJBQXdCbk47UUFDOUJvTjtBQUNIO0FBQ0w7O0FBSUF0TSxPQUFPNkksbUJBQW1CQTs7QUFDMUI3SSxPQUFPb00saUJBQWlCQTs7QUFDeEJwTSxPQUFPZ00sZ0JBQWdCQSJ9
