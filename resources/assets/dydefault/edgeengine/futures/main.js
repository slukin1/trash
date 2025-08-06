var clickable = true;

var commonData = {
    userSign: "",
    currentSymbol: "BTC-USDT",
    currentContractInfo: {},
    contractInfoData: [],
    contractH5Url: "",
    currencyRate: "6.4",
    currencyCharacter: "CNY",
    priceColorType: 0,
    colorMode: 0,
    OS: 0,
    appVersion: "",
    isInReview: 1,
    isLogin: 0,
    webUrl: "",
    language: "",
    pageType: 53,
    contractType: "",
    userInfo: {}
};

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
        if (8 == hostType) {
            var status = response.status;
            var err_code = response.err_code;
            var err_msg = response.err_msg;
            if (status == "ok") {
                console.log(`request ${path} done`);
                if (typeof data === "number") {
                    let start = `"data":`;
                    let startIndex = responseString.indexOf(start);
                    let end = `,"ts":`;
                    let endIndex = responseString.indexOf(end);
                    let dataString = responseString.substring(startIndex + start.length, endIndex);
                    console.log(`data is typeof number, dataString = ${dataString}`);
                    return dataString;
                }
                return data;
            } else {
                console.log(`request failed, code=${err_code}, message=${err_msg}`);
                if (method != 0) {
                    showToast(err_msg);
                }
                return null;
            }
        } else if (code == 200) {
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

async function openURL(url) {
    if (!clickable) {
        return;
    }
    console.log(`open url:`, url);
    if (url && url != null && url.length > 0) {
        await $nativeAPI.openRoute(url);
    }
    clickable = false;
    setTimeout((() => {
        clickable = true;
    }), 1e3);
}

async function showToast(msg) {
    await $nativeAPI.hbToast(msg);
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
    console.log(`analytics event: ${event}, propertiesJson = ${propertiesJson}`);
    var map = {
        event: event,
        properties: propertiesJson
    };
    await $nativeAPI.analytics(map);
}

async function sendCommonConfig$1(param) {
    console.log(param);
    let savedSymbol = await read("copyTrading", "currentCopyTradingSymbol");
    if (null == savedSymbol || 0 == savedSymbol.length) {
        commonData.currentSymbol = "BTC-USDT";
    } else {
        commonData.currentSymbol = savedSymbol;
    }
    commonData.contractH5Url = param.contractH5Url;
    commonData.currencyRate = param.currencyRate;
    if (param.currencyRate != null && 0 == param.currencyRate.length) {
        commonData.currencyRate = "1";
    }
    commonData.currencyCharacter = param.currencyCharacter;
    commonData.priceColorType = parseInt(param.priceColorType);
    commonData.colorMode = parseInt(param.colorMode);
    commonData.OS = parseInt(param.OS);
    commonData.appVersion = param.appVersion;
    commonData.isInReview = parseInt(param.isInReview);
    commonData.language = param.language;
    commonData.webUrl = param.h5Url;
}

function moduleDefine(moduleName, startFunction, defaultDataFunction) {
    console.log(`loadModule`, moduleName + " begin");
    $data[moduleName] = defaultDataFunction();
    $event[moduleName] = {
        start: startFunction
    };
    console.log(`loadModule`, moduleName + " end");
    return {
        moduleEvent: $event[moduleName],
        moduleData: $data[moduleName]
    };
}

async function start$1() {}

function defaultData$1() {
    return {};
}

const {moduleData: moduleData$1, moduleEvent: moduleEvent$1} = moduleDefine("futures", start$1, defaultData$1);

var canJump = true;

moduleEvent$1.buy = async function() {
    if (!canJump) {
        return;
    }
    canJump = false;
    let url = `holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/otc/trade`;
    openURL(url);
    setTimeout((function() {
        canJump = true;
        console.log(`tl -- buy,防止重复点击,canJump==${canJump}`);
    }), 2e3);
};

moduleEvent$1.recharge = async function() {
    if (!canJump) {
        return;
    }
    canJump = false;
    let url = `holigeit://open/v1?&login=1&url=ihuobiglobal://m.hbg.com/otc/index?tradeArea=deposit&isOutArea=true&tradeSide=buy&tradeCurrency=USDT&fiatName=CNY`;
    openURL(url);
    setTimeout((function() {
        canJump = true;
        console.log(`recharge,防止重复点击,canJump==${canJump}`);
    }), 2e3);
    console.log(`recharge -- url==${url}`);
};

moduleEvent$1.copytrading = async function() {
    if (!canJump) {
        return;
    }
    canJump = false;
    let url = `holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/Contract/CopyTrading?index=0`;
    openURL(url);
    setTimeout((function() {
        canJump = true;
        console.log(`copytrading,防止重复点击,canJump==${canJump}`);
    }), 2e3);
    console.log(`copytrading -- url==${url}`);
};

moduleEvent$1.transfer = async function() {
    if (!canJump) {
        return;
    }
    canJump = false;
    var account = 11;
    if (commonData.contractType == "delivery") {
        account = 4;
    } else if (commonData.contractType == "swap") {
        account = 7;
    } else if (commonData.contractType == "linearSwap") {
        account = 11;
    }
    let url = `holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/balance/transfer?coin=usdt&account=${account}`;
    console.log(`contractType==${commonData.contractType}`);
    openURL(url);
    setTimeout((function() {
        canJump = true;
        console.log(`transfer,防止重复点击,canJump==${canJump}`);
    }), 2e3);
    console.log(`transfer -- url==${url}`);
};

var moduleDidStart = false;

async function start() {
    moduleDidStart = true;
    await requestNoticeList();
}

function defaultData() {
    return {
        noticeList: [],
        noticeVisibility: "gone",
        noticeIndicatorList: [],
        noticeIndicatorVisibility: "gone",
        autoScroll: "true",
        currentNoticeIndex: "0"
    };
}

const {moduleData: moduleData, moduleEvent: moduleEvent} = moduleDefine("contractNotice", start, defaultData);

var closedNoticeSet = new Set;

var noticeExposureMap = new Map;

async function noticeExposure() {
    var index = parseInt(moduleData.currentNoticeIndex);
    if (index >= noticeDataList.length) {
        return;
    }
    var obj = noticeDataList[index];
    if (!noticeExposureMap.has(obj["advId"])) {
        try {
            await analytics("pageview_contracts", {
                business_category: "contracts_app",
                button_name: "banner",
                button_location: String(obj["advId"])
            });
            noticeExposureMap.set(obj["advId"], true);
        } catch (e) {
            console.log(`notice noticeExposureMap error, error=${e}`);
        }
    }
}

var noticeDataList = [];

async function requestNoticeList() {
    var params = {
        pageType: commonData.pageType,
        showType: 9
    };
    let noticeData = await sendRequest("v1/config/push/banner/list", params, 0, 0, {});
    if (noticeData && noticeData.bannerAdvList != null && noticeData.bannerAdvList.length > 0) {
        refreshNoticeList(noticeData.bannerAdvList);
    } else {
        noticeDataList = [];
        moduleData.noticeList = [];
        moduleData.noticeVisibility = "gone";
    }
}

async function refreshNoticeList(bannerAdvList) {
    if (bannerAdvList && bannerAdvList.length > 0) {
        var dataList = [];
        var i = 0;
        await loadSaveClosedNotice();
        for (let item of bannerAdvList) {
            if (closedNoticeSet.has(item["advId"])) {
                continue;
            }
            item.index = i++;
            item.type = "1";
            item.currentImageURL = commonData.colorMode === 1 ? item.nightImageUrl : item.imageUrl;
            dataList.push(item);
        }
        moduleData.noticeList = dataList;
        moduleData.noticeVisibility = dataList.length > 0 ? "visible" : "gone";
        noticeDataList = dataList;
        noticeExposure();
    } else {
        noticeDataList = [];
        moduleData.noticeList = [];
        moduleData.noticeVisibility = "gone";
    }
    handleSliderIndicatorView();
}

function handleSliderIndicatorView() {
    let indicatorList = [];
    for (let index = 0; index < noticeDataList.length; index++) {
        if (moduleData.currentNoticeIndex == String(index)) {
            indicatorList.push({
                type: "1"
            });
        } else {
            indicatorList.push({
                type: "2"
            });
        }
    }
    moduleData.noticeIndicatorVisibility = indicatorList.length > 1 ? "visible" : "gone";
    moduleData.noticeIndicatorList = indicatorList;
}

async function loadSaveClosedNotice() {
    var noticeClosed = await read("contractNotice", "contractNoticeExposure");
    if (noticeClosed && noticeClosed.length > 0) {
        for (let item of noticeClosed) {
            closedNoticeSet.add(item);
        }
    }
}

moduleEvent.selectedNoticeIndex = async function(index) {
    $data.contractNotice.currentNoticeIndex = String(index);
    await noticeExposure();
    handleSliderIndicatorView();
};

moduleEvent.clickNoticeItem = async function() {
    var index = parseInt(moduleData.currentNoticeIndex);
    if (index >= noticeDataList.length) {
        return;
    }
    var obj = noticeDataList[index];
    if (obj.jumpTo != null) {
        await openURL(encodeURI(obj.jumpTo));
    }
    await analytics("appclick_contracts", {
        business_category: "contracts_app",
        button_name: "banner",
        button_location: String(obj["advId"])
    });
};

moduleEvent.clickNoticeClose = async function() {
    moduleData.noticeVisibility = "gone";
    var saveData = [];
    for (let item of noticeDataList) {
        closedNoticeSet.add(item["advId"]);
    }
    closedNoticeSet.forEach((function(value) {
        saveData.push(value);
    }));
    noticeDataList = [];
    moduleData.noticeList = [];
    await save("contractNotice", "contractNoticeExposure", saveData);
};

function pageAppear$1() {
    if (moduleDidStart == false) {
        return;
    }
    moduleData.autoScroll = "true";
    refreshNoticeList(noticeDataList);
}

function pageDisappear$1() {
    if (moduleDidStart == false) {
        return;
    }
    moduleData.autoScroll = "false";
}

async function sendContractInfo(params) {
    console.log(`contractType -- dict==${params.contractType}`);
    if (commonData.contractType != params.contractType) {
        commonData.contractType = params.contractType;
    }
}

function sendCommonConfig(param) {
    sendCommonConfig$1(param);
}

async function pageAppear() {
    pageAppear$1();
}

async function pageDisappear() {
    pageDisappear$1();
}

$event.sendContractInfo = sendContractInfo;

$event.pageAppear = pageAppear;

$event.pageDisappear = pageDisappear;

$event.sendCommonConfig = sendCommonConfig;
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWFpbi5qcyIsInNvdXJjZXMiOlsiLi4vLi4vcmVwb3NpdG9yeS9zcmMvY29tbW9uLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvcmVjaGFyZ2VFbnRyeS5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL2NvbnRyYWN0Tm90aWNlLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvbWFpbi5qcyJdLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQgKiBhcyBudW1iZXIgZnJvbSBcIi4vbnVtYmVyXCI7XG5cbnZhciBjbGlja2FibGUgPSB0cnVlO1xuXG4vLyDpopzoibLphY3nva4gMDrnuqLmtqjnu7/ot4wg5oiWIDE657u/5rao57qi6LeMXG52YXIgdXBDb2xvckxpc3Q7XG52YXIgZG93bkNvbG9yTGlzdDtcblxuLyoqXG4gKiBAdHlwZWRlZiB7T2JqZWN0fSBDb21tb25EYXRhXG4gKiBAcHJvcGVydHkge251bWJlcn0gcHJpY2VDb2xvclR5cGUgICAgLSDku7fmoLzmtqjot4zluYXpopzoibLorr7nva5cbiAqIEBwcm9wZXJ0eSB7bnVtYmVyfSBjb2xvck1vZGUgICAgICAgICAtIOeZveWkqem7keWknOaooeW8j1xuICogQHByb3BlcnR5IHtzdHJpbmd9IGxhbmd1YWdlICAgICAgICAgIC0g6K+t56eN6YWN572uXG4gKiBAcHJvcGVydHkge3N0cmluZ30gT1MgICAgICAgICAgICAgICAgLSDns7vnu59cbiAqIEBwcm9wZXJ0eSB7c3RyaW5nfSBhcHBWZXJzaW9uICAgICAgICAtIOeJiOacrOWPt1xuICogQHByb3BlcnR5IHtudW1iZXJ9IGlzSW5SZXZpZXcgICAgICAgIC0gaU9T5a6h5qC454q25oCBXG4gKiBAcHJvcGVydHkge251bWJlcn0gaXNMb2dpbiAgICAgICAgICAgLSDmmK/lkKbnmbvlvZVcbiAqIEBwcm9wZXJ0eSB7b2JqZWN0fSBsaW5lYXJTd2FwV3NEYXRhICAtIFXmnKzkvY3lkIjnuqborqLpmIXkv6Hmga9cbiAqL1xuXG4vKiogQHR5cGUgQ29tbW9uRGF0YSAqL1xuZXhwb3J0IHZhciBjb21tb25EYXRhID0ge1xuICB1c2VyU2lnbjogXCJcIiwgLy8vIOeUqOaIt+agh+ivhlxuICBjdXJyZW50U3ltYm9sOiBcIkJUQy1VU0RUXCIsIC8vL+W9k+WJjeeahOWQiOe6puWTgeenjVxuICBjdXJyZW50Q29udHJhY3RJbmZvOiB7fSwgLy8v5b2T5YmN55qE5ZCI57qm5ZOB56eN5pWw5o2uXG4gIGNvbnRyYWN0SW5mb0RhdGE6IFtdLCAvLy9saW5lYXItc3dhcC1vcmRlci94L3YxL2xpbmVhcl9zd2FwX2NvbnRyYWN0X2luZm8/YnVzaW5lc3NfdHlwZT1hbGwmdHJhZGVfcGFydGl0aW9uPWFsbOOAgOaOpeWPo+i/lOWbnueahOaJgOacieWQiOe6puWTgeenjeaVsOaNrlxuICBjb250cmFjdEg1VXJsOiBcIlwiLCAvLy/lkIjnuqZINeWcsOWdgFxuICBjdXJyZW5jeVJhdGU6IFwiNi40XCIsIC8vL+e+juWFg+WvueWFtuWug+azleW4geeahOaxh+eOh1xuICBjdXJyZW5jeUNoYXJhY3RlcjogXCJDTllcIiwgLy8v5rOV5biB56ym5Y+3XG4gIHByaWNlQ29sb3JUeXBlOiAwLCAvLy8w77ya57qi5rao57u/6LeMICAgMe+8mue7v+a2qOe6oui3jFxuICBjb2xvck1vZGU6IDAsIC8vLzDvvJrnmb3lpKkgICAx77ya6buR5aScXG4gIE9TOiAwLCAvLzDvvJppT1MgIDHvvJrlronljZNcbiAgYXBwVmVyc2lvbjogXCJcIiwgLy9hcHDniYjmnKzlj7dcbiAgaXNJblJldmlldzogMSxcbiAgaXNMb2dpbjogMCxcbiAgd2ViVXJsOiBcIlwiLCAvLy8gaDXliqjmgIHln5/lkI1cbiAgbGFuZ3VhZ2U6IFwiXCIsIC8vLyDor63oqIDnp43nsbtcbiAgcGFnZVR5cGU6IDUzLC8vNTMg5ZCI57qmLeiFsOmDqOWFpeWPoy1hcHDjgIE1NSDlkIjnuqbot5/ljZUt6IWw6YOoLWFwcFxuICBjb250cmFjdFR5cGU6IFwiXCIsIC8v5ZCI57qm5Lqn5ZOB57q/57G75Z6LXG4gIHVzZXJJbmZvOiB7fVxufTtcblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHN1YldlYlNvY2tldCh0eXBlKSB7XG4gIGF3YWl0ICRuYXRpdmVBUEkuaGFuZGxlU29ja2V0KHtcbiAgICBhY3Rpb246IFwic3ViV2ViU29ja2V0XCIsXG4gICAgdHlwZTogdHlwZSxcbiAgfSk7XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiB1blN1YldlYlNvY2tldCh0eXBlKSB7XG4gIGF3YWl0ICRuYXRpdmVBUEkuaGFuZGxlU29ja2V0KHtcbiAgICBhY3Rpb246IFwidW5TdWJXZWJTb2NrZXRcIixcbiAgICB0eXBlOiB0eXBlLFxuICB9KTtcbn1cblxuLy/lj5HpgIHor7fmsYJcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzZW5kUmVxdWVzdChwYXRoLCBwYXJhbXMgPSB7fSwgbWV0aG9kID0gMCwgaG9zdFR5cGUgPSAwLCBoZWFkZXIgPSB7fSkge1xuICBjb25zb2xlLmxvZyhgcmVxdWVzdCAke3BhdGh9LCBwYXJhbXM6JHtKU09OLnN0cmluZ2lmeShwYXJhbXMpfWApO1xuXG4gIGlmIChob3N0VHlwZSA9PSA1IHx8IGhvc3RUeXBlID09IDYpIHtcbiAgICBoZWFkZXJbXCJDb250ZW50LVR5cGVcIl0gPSBcImFwcGxpY2F0aW9uL2pzb25cIjtcbiAgfVxuXG4gIGNvbnN0IHBhcmFtID0ge1xuICAgIHBhdGgsXG4gICAgbWV0aG9kLFxuICAgIGhvc3RUeXBlLFxuICAgIGhlYWRlcixcbiAgICBwYXJhbXMsXG4gIH07XG4gIHRyeSB7XG4gICAgdmFyIHJlc3BvbnNlU3RyaW5nID0gYXdhaXQgJG5hdGl2ZUFQSS5yZXF1ZXN0KEpTT04uc3RyaW5naWZ5KHBhcmFtKSk7XG4gICAgdmFyIHJlc3BvbnNlID0gSlNPTi5wYXJzZShyZXNwb25zZVN0cmluZyk7XG4gICAgdmFyIHsgY29kZSwgZGF0YSB9ID0gcmVzcG9uc2U7XG4gICAgaWYgKDggPT0gaG9zdFR5cGUpIHtcbiAgICAgIC8v5ZCI57qm55qE5o6l5Y+j5aSE55CGXG4gICAgICB2YXIgc3RhdHVzID0gcmVzcG9uc2Uuc3RhdHVzO1xuICAgICAgdmFyIGVycl9jb2RlID0gcmVzcG9uc2UuZXJyX2NvZGU7XG4gICAgICB2YXIgZXJyX21zZyA9IHJlc3BvbnNlLmVycl9tc2c7XG4gICAgICBpZiAoc3RhdHVzID09IFwib2tcIikge1xuICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCAke3BhdGh9IGRvbmVgKTtcbiAgICAgICAgaWYgKHR5cGVvZiBkYXRhID09PSAnbnVtYmVyJykge1xuICAgICAgICAgIGxldCBzdGFydCA9IGBcImRhdGFcIjpgO1xuICAgICAgICAgIGxldCBzdGFydEluZGV4ID0gcmVzcG9uc2VTdHJpbmcuaW5kZXhPZihzdGFydCk7XG4gICAgICAgICAgbGV0IGVuZCA9IGAsXCJ0c1wiOmA7XG4gICAgICAgICAgbGV0IGVuZEluZGV4ID0gcmVzcG9uc2VTdHJpbmcuaW5kZXhPZihlbmQpO1xuICAgICAgICAgIGxldCBkYXRhU3RyaW5nID0gcmVzcG9uc2VTdHJpbmcuc3Vic3RyaW5nKHN0YXJ0SW5kZXggKyBzdGFydC5sZW5ndGgsIGVuZEluZGV4KTtcbiAgICAgICAgICBjb25zb2xlLmxvZyhgZGF0YSBpcyB0eXBlb2YgbnVtYmVyLCBkYXRhU3RyaW5nID0gJHtkYXRhU3RyaW5nfWApO1xuICAgICAgICAgIHJldHVybiBkYXRhU3RyaW5nO1xuICAgICAgICB9XG4gICAgICAgIHJldHVybiBkYXRhO1xuICAgICAgfSBlbHNlIHtcbiAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgZmFpbGVkLCBjb2RlPSR7ZXJyX2NvZGV9LCBtZXNzYWdlPSR7ZXJyX21zZ31gKTtcbiAgICAgICAgaWYgKG1ldGhvZCAhPSAwKSB7XG4gICAgICAgICAgc2hvd1RvYXN0KGVycl9tc2cpO1xuICAgICAgICB9XG4gICAgICAgIHJldHVybiBudWxsO1xuICAgICAgfVxuICAgIH0gZWxzZSBpZiAoY29kZSA9PSAyMDApIHtcbiAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0ICR7cGF0aH0gZG9uZWApO1xuICAgICAgcmV0dXJuIGRhdGE7XG4gICAgfSBlbHNlIHtcbiAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0IGZhaWxlZCwgY29kZT0ke2NvZGV9YCk7XG4gICAgICBsZXQgbWVzc2FnZSA9IHJlc3BvbnNlLm1lc3NhZ2U7XG4gICAgICBpZiAobWV0aG9kICE9IDAgJiYgbWVzc2FnZSkge1xuICAgICAgICBzaG93VG9hc3QobWVzc2FnZSk7XG4gICAgICB9XG4gICAgICByZXR1cm4gbnVsbDtcbiAgICB9XG4gIH0gY2F0Y2ggKGUpIHtcbiAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCBlcnJvciwgZXJyb3I9JHtlfWApO1xuICAgIHJldHVybiBudWxsO1xuICB9XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzZW5kUmVxdWVzdFdpdGhDYWNoZShcbiAgcGF0aCxcbiAgY2FsbGJhY2ssXG4gIHBhcmFtcyA9IHt9LFxuICBtZXRob2QgPSAwLFxuICBob3N0VHlwZSA9IDAsXG4gIGhlYWRlciA9IHt9LFxuICBjYWNoZUtleUxpc3QgPSBudWxsXG4pIHtcbiAgdmFyIGNhY2hlS2V5ID0gZ2V0Q2FjaGVLZXkocGF0aCwgcGFyYW1zLCBjYWNoZUtleUxpc3QpO1xuICBjb25zdCBjYWNoZSA9IGF3YWl0IHJlYWQoXCJhcGlDYWNoZVwiLCBjYWNoZUtleSk7XG4gIGlmIChjYWNoZSAmJiBjYWxsYmFjaykge1xuICAgIGNhbGxiYWNrKGNhY2hlLCB0cnVlKTtcbiAgfVxuICBjb25zdCByZXF1ZXN0RGF0YSA9IGF3YWl0IHNlbmRSZXF1ZXN0KHBhdGgsIHBhcmFtcywgbWV0aG9kLCBob3N0VHlwZSwgaGVhZGVyKTtcbiAgYXdhaXQgc2F2ZShcImFwaUNhY2hlXCIsIGNhY2hlS2V5LCByZXF1ZXN0RGF0YSk7XG4gIGlmIChyZXF1ZXN0RGF0YSAmJiBjYWxsYmFjaykge1xuICAgIGNhbGxiYWNrKHJlcXVlc3REYXRhLCBmYWxzZSk7XG4gIH1cbiAgcmV0dXJuIHJlcXVlc3REYXRhO1xufVxuXG5mdW5jdGlvbiBnZXRDYWNoZUtleShwYXRoLCBwYXJhbXMsIGNhY2hlS2V5TGlzdCA9IG51bGwpIHtcbiAgdmFyIGNhY2hlS2V5ID0gXCJcIjtcbiAgaWYgKGNhY2hlS2V5TGlzdCA9PSBudWxsKSB7XG4gICAgLy9udWxs77ya5omA5pyJ5Y+C5pWw5L2c5Li657yT5a2Y5Y+C5pWwXG4gICAgdmFyIHBhcmFtU3RyID0gSlNPTi5zdHJpbmdpZnkocGFyYW1zKTtcbiAgICBjYWNoZUtleSA9IGAke3BhdGh9XyR7cGFyYW1TdHJ9XyR7Y29tbW9uRGF0YS5sYW5ndWFnZX1fJHtjb21tb25EYXRhLmNvbG9yTW9kZX1fJHtjb21tb25EYXRhLmlzTG9naW59YDtcbiAgfSBlbHNlIGlmIChjYWNoZUtleUxpc3QubGVuZ3RoID09IDApIHtcbiAgICAvLyBbXSAs5Liq5pWw5Li6MO+8muS4jemcgOimgeWPguaVsOS9nOS4uue8k+WtmOWPguaVsFxuICAgIGNhY2hlS2V5ID0gYCR7cGF0aH1fJHtjb21tb25EYXRhLmxhbmd1YWdlfV8ke2NvbW1vbkRhdGEuY29sb3JNb2RlfV8ke2NvbW1vbkRhdGEuaXNMb2dpbn1gO1xuICB9IGVsc2Uge1xuICAgIHZhciBjYWNoZUtleUxpc3RTdHIgPSBjYWNoZUtleUxpc3Quam9pbihcIl9cIik7XG4gICAgY2FjaGVLZXkgPSBgJHtwYXRofV8ke2NhY2hlS2V5TGlzdFN0cn1fJHtjb21tb25EYXRhLmxhbmd1YWdlfV8ke2NvbW1vbkRhdGEuY29sb3JNb2RlfV8ke2NvbW1vbkRhdGEuaXNMb2dpbn1gO1xuICB9XG4gIHJldHVybiBjYWNoZUtleTtcbn1cblxuLy/moLnmja7mtqjot4zluYXojrflj5bmmL7npLrpopzoibJcbmV4cG9ydCBmdW5jdGlvbiBnZXRQcmljZUNvbG9yKHJhdGlvKSB7XG4gIC8vIGNvbnNvbGUubG9nKCdnZXRQcmljZUNvbG9yJyk7XG4gIGlmIChyYXRpbyA9PSBudWxsKSB7XG4gICAgcmF0aW8gPSAwO1xuICB9XG4gIGNvbnN0IHJhdGlvX2FicyA9IE1hdGguYWJzKHJhdGlvKTtcbiAgdmFyIGNvbG9yTGV2ZWwgPSAwO1xuICBpZiAocmF0aW9fYWJzID4gMCAmJiByYXRpb19hYnMgPCAzKSB7XG4gICAgY29sb3JMZXZlbCA9IDE7XG4gIH0gZWxzZSBpZiAocmF0aW9fYWJzID49IDMgJiYgcmF0aW9fYWJzIDwgOCkge1xuICAgIGNvbG9yTGV2ZWwgPSAyO1xuICB9IGVsc2UgaWYgKHJhdGlvX2FicyA+PSA4KSB7XG4gICAgY29sb3JMZXZlbCA9IDM7XG4gIH1cbiAgdmFyIGNvbG9ySGV4U3RyID0gbnVsbDtcbiAgaWYgKHJhdGlvID4gMCkge1xuICAgIGNvbG9ySGV4U3RyID0gdXBDb2xvckxpc3RbY29sb3JMZXZlbF07XG4gIH0gZWxzZSB7XG4gICAgY29sb3JIZXhTdHIgPSBkb3duQ29sb3JMaXN0W2NvbG9yTGV2ZWxdO1xuICB9XG4gIHJldHVybiBjb2xvckhleFN0cjtcbn1cblxuLy/ojrflj5bku7fmoLzmmL7npLrmlofmnKxcbmV4cG9ydCBmdW5jdGlvbiBnZXRQcmljZVN0cmluZyhwcmljZVN0ciwgcHJlY2lzaW9uKSB7XG4gIHZhciBwcmljZVRlbXAgPSBwcmljZVN0cjtcbiAgdmFyIGRlY2ltYWxBcnIgPSBwcmljZVRlbXAuc3BsaXQoXCIuXCIpO1xuICBpZiAoZGVjaW1hbEFyci5sZW5ndGggPCAyKSB7XG4gICAgcHJpY2VUZW1wID0gcGFyc2VGbG9hdChwcmljZVRlbXApLnRvRml4ZWQoMSk7XG4gICAgZGVjaW1hbEFyciA9IHByaWNlVGVtcC5zcGxpdChcIi5cIik7XG4gIH1cbiAgY29uc3QgZGVjaW1hbENvdW50ID0gZGVjaW1hbEFyclsxXS5sZW5ndGg7XG4gIGNvbnN0IHBhZGRlZFByaWNlU3RyID1cbiAgICBkZWNpbWFsQ291bnQgPCBwcmVjaXNpb25cbiAgICAgID8gcHJpY2VUZW1wLnBhZEVuZChwcmljZVRlbXAubGVuZ3RoICsgKHByZWNpc2lvbiAtIGRlY2ltYWxDb3VudCksIFwiMFwiKVxuICAgICAgOiBwYXJzZUZsb2F0KHByaWNlVGVtcCkudG9GaXhlZChwcmVjaXNpb24pO1xuICBjb25zdCBmaW5hbFByaWNlU3RyID0gcGFkZGVkUHJpY2VTdHIucmVwbGFjZSgvXFxkKD89KFxcZHszfSkrXFwuKS9nLCBcIiQmLFwiKTtcbiAgcmV0dXJuIGZpbmFsUHJpY2VTdHI7XG59XG5cbi8v6L+b6KGM57K+5bqm5aSE55CGXG5leHBvcnQgZnVuY3Rpb24gZm9ybWF0UHJlY2lzaW9uKHZhbHVlLCBwcmVjaXNpb24pIHtcbiAgdHJ5IHtcbiAgICBjb25zdCByZXN1bHQgPSBudW1iZXIuZm9ybWF0KHZhbHVlLCBwcmVjaXNpb24pO1xuICAgIHJldHVybiByZXN1bHQ7XG4gIH0gY2F0Y2ggKGUpIHtcbiAgICBjb25zb2xlLmxvZyhlKTtcbiAgICByZXR1cm4gdmFsdWUudG9GaXhlZChwcmVjaXNpb24pO1xuICB9XG59XG5cbi8vIC8v5omT5byAVVJMXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gb3BlblVSTCh1cmwpIHtcbiAgaWYgKCFjbGlja2FibGUpIHtcbiAgICByZXR1cm47XG4gIH1cbiAgY29uc29sZS5sb2coYG9wZW4gdXJsOmAsIHVybCk7XG4gIGlmICh1cmwgJiYgdXJsICE9IG51bGwgJiYgdXJsLmxlbmd0aCA+IDApIHtcbiAgICBhd2FpdCAkbmF0aXZlQVBJLm9wZW5Sb3V0ZSh1cmwpO1xuICB9XG4gIGNsaWNrYWJsZSA9IGZhbHNlO1xuICBzZXRUaW1lb3V0KCgpID0+IHtcbiAgICBjbGlja2FibGUgPSB0cnVlO1xuICB9LCAxMDAwKTtcbn1cblxuLy/miZPlvIDpobXpnaJcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBvcGVuUGFnZShwYWdlLCB0eXBlID0gXCJuYXRpdmVcIiwgcGFyYW1zID0ge30pIHtcbiAgYXdhaXQgJG5hdGl2ZUFQSS5jb3B5VHJhZGluZ0JyaWRnZSh7XG4gICAgYWN0aW9uOiBcIm9wZW5QYWdlXCIsXG4gICAgdHlwZTogdHlwZSxcbiAgICBwYWdlOiBwYWdlLFxuICAgIHBhcmFtczogSlNPTi5zdHJpbmdpZnkocGFyYW1zKSxcbiAgfSk7XG59XG5cbi8vdG9hc3RcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzaG93VG9hc3QobXNnKSB7XG4gIGF3YWl0ICRuYXRpdmVBUEkuaGJUb2FzdChtc2cpO1xufVxuXG4vL+S/neWtmOaVsOaNrlxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNhdmUobW9kdWxlLCBrZXksIGRhdGEpIHtcbiAgYXdhaXQgJG5hdGl2ZUFQSS5zdG9yYWdlKHtcbiAgICBhY3Rpb246IFwic2F2ZVwiLFxuICAgIG5hbWU6IG1vZHVsZSxcbiAgICBrZXk6IGtleSxcbiAgICBkYXRhOiBKU09OLnN0cmluZ2lmeShkYXRhKSxcbiAgfSk7XG59XG5cbi8v6K+75Y+W5pWw5o2uXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gcmVhZChtb2R1bGUsIGtleSkge1xuICBjb25zdCBkYXRhID0gYXdhaXQgJG5hdGl2ZUFQSS5zdG9yYWdlKHtcbiAgICBhY3Rpb246IFwicmVhZFwiLFxuICAgIG5hbWU6IG1vZHVsZSxcbiAgICBrZXk6IGtleSxcbiAgfSk7XG4gIGlmIChkYXRhICYmIGRhdGEgIT0gXCJcIikge1xuICAgIHJldHVybiBKU09OLnBhcnNlKGRhdGEpO1xuICB9XG4gIHJldHVybiBudWxsO1xufVxuXG4vL+a4heeQhuaVsOaNrlxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGNsZWFyKG1vZHVsZSwga2V5KSB7XG4gIGF3YWl0ICRuYXRpdmVBUEkuc3RvcmFnZSh7XG4gICAgYWN0aW9uOiBcImNsZWFyXCIsXG4gICAgbmFtZTogbW9kdWxlLFxuICAgIGtleToga2V5LFxuICB9KTtcbn1cblxuLy/muIXnkIblhajpg6jmlbDmja5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBjbGVhckFsbChtb2R1bGUpIHtcbiAgYXdhaXQgJG5hdGl2ZUFQSS5zdG9yYWdlKHtcbiAgICBhY3Rpb246IFwiY2xlYXJcIixcbiAgICBuYW1lOiBtb2R1bGUsXG4gIH0pO1xufVxuXG4vL+Wfi+eCuVxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGFuYWx5dGljcyhldmVudCA9IFwiXCIsIHByb3BlcnRpZXMgPSB7fSkge1xuICAgIGNvbnN0IHByb3BlcnRpZXNKc29uID0gSlNPTi5zdHJpbmdpZnkocHJvcGVydGllcyk7XG4gICAgY29uc29sZS5sb2coYGFuYWx5dGljcyBldmVudDogJHtldmVudH0sIHByb3BlcnRpZXNKc29uID0gJHtwcm9wZXJ0aWVzSnNvbn1gKTtcbiAgICB2YXIgbWFwID0ge1xuICAgICAgICBldmVudDogZXZlbnQsXG4gICAgICAgIHByb3BlcnRpZXM6IHByb3BlcnRpZXNKc29uXG4gICAgfTtcbiAgICBhd2FpdCAkbmF0aXZlQVBJLmFuYWx5dGljcyhtYXApO1xufVxuXG4vL+iuvue9rumAmueUqOmFjee9rlxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNlbmRDb21tb25Db25maWcocGFyYW0pIHtcbiAgY29uc29sZS5sb2cocGFyYW0pO1xuICBsZXQgc2F2ZWRTeW1ib2wgPSBhd2FpdCByZWFkKFwiY29weVRyYWRpbmdcIiwgXCJjdXJyZW50Q29weVRyYWRpbmdTeW1ib2xcIik7XG4gIGlmIChudWxsID09IHNhdmVkU3ltYm9sIHx8IDAgPT0gc2F2ZWRTeW1ib2wubGVuZ3RoKSB7XG4gICAgY29tbW9uRGF0YS5jdXJyZW50U3ltYm9sID0gXCJCVEMtVVNEVFwiO1xuICB9IGVsc2Uge1xuICAgIGNvbW1vbkRhdGEuY3VycmVudFN5bWJvbCA9IHNhdmVkU3ltYm9sO1xuICB9XG4gIGNvbW1vbkRhdGEuY29udHJhY3RINVVybCA9IHBhcmFtLmNvbnRyYWN0SDVVcmw7XG4gIGNvbW1vbkRhdGEuY3VycmVuY3lSYXRlID0gcGFyYW0uY3VycmVuY3lSYXRlO1xuICBpZiAocGFyYW0uY3VycmVuY3lSYXRlICE9IG51bGwgJiYgMCA9PSBwYXJhbS5jdXJyZW5jeVJhdGUubGVuZ3RoKSB7XG4gICAgY29tbW9uRGF0YS5jdXJyZW5jeVJhdGUgPSBcIjFcIjtcbiAgfVxuICBjb21tb25EYXRhLmN1cnJlbmN5Q2hhcmFjdGVyID0gcGFyYW0uY3VycmVuY3lDaGFyYWN0ZXI7XG4gIGNvbW1vbkRhdGEucHJpY2VDb2xvclR5cGUgPSBwYXJzZUludChwYXJhbS5wcmljZUNvbG9yVHlwZSk7XG4gIGNvbW1vbkRhdGEuY29sb3JNb2RlID0gcGFyc2VJbnQocGFyYW0uY29sb3JNb2RlKTtcbiAgY29tbW9uRGF0YS5PUyA9IHBhcnNlSW50KHBhcmFtLk9TKTtcbiAgY29tbW9uRGF0YS5hcHBWZXJzaW9uID0gcGFyYW0uYXBwVmVyc2lvbjtcbiAgY29tbW9uRGF0YS5pc0luUmV2aWV3ID0gcGFyc2VJbnQocGFyYW0uaXNJblJldmlldyk7XG4gIGNvbW1vbkRhdGEubGFuZ3VhZ2UgPSBwYXJhbS5sYW5ndWFnZTtcbiAgY29tbW9uRGF0YS53ZWJVcmwgPSBwYXJhbS5oNVVybDtcblxuICB2YXIgcmVkQ29sb3JMaXN0ID0gW1wiIzhDOUZBRFwiLCBcIiNFOTQzNTlcIiwgXCIjRUUzRjM0XCIsIFwiI0REMjgxRFwiLCBcIiNGRkY1RjRcIl07XG4gIHZhciBncmVlbkNvbG9yTGlzdCA9IFtcIiM4QzlGQURcIiwgXCIjMDBBMTcxXCIsIFwiIzEzOUE4NFwiLCBcIiMwRjc2NjVcIiwgXCIjMTIxRjI1XCJdO1xuXG4gIGlmIChwYXJzZUludChjb21tb25EYXRhLnByaWNlQ29sb3JUeXBlKSA9PSAwKSB7XG4gICAgdXBDb2xvckxpc3QgPSByZWRDb2xvckxpc3Q7XG4gICAgZG93bkNvbG9yTGlzdCA9IGdyZWVuQ29sb3JMaXN0O1xuICB9IGVsc2Uge1xuICAgIHVwQ29sb3JMaXN0ID0gZ3JlZW5Db2xvckxpc3Q7XG4gICAgZG93bkNvbG9yTGlzdCA9IHJlZENvbG9yTGlzdDtcbiAgfVxufVxuXG5leHBvcnQgZnVuY3Rpb24gZ2V0VXBEb3duQ29sb3IoaXNVcHBlciA9IHRydWUsIGxldmVsID0gMSkge1xuICBjb25zdCBsZXYgPSBsZXZlbCA8IDQgPyBsZXZlbCA6IDA7XG4gIGlmIChpc1VwcGVyKSB7XG4gICAgcmV0dXJuIHVwQ29sb3JMaXN0W2xldl07XG4gIH1cbiAgcmV0dXJuIGRvd25Db2xvckxpc3RbbGV2XTtcbn1cbmxldCBzeW1ib2xEZXNjTWFwID0ge31cbmV4cG9ydCBmdW5jdGlvbiBzeW1ib2xEZXNjKHN5bWJvbCkge1xuICBpZiAoIXN5bWJvbERlc2NNYXAuaGFzT3duUHJvcGVydHkoc3ltYm9sKSkge1xuICAgIHN5bWJvbERlc2NNYXBbc3ltYm9sXSA9ICRpMThuLiRpbnRlcmNlcHQubl9jb250cmFjdF9zd2FwX3RyYWRlX25hbWUoc3ltYm9sLnJlcGxhY2UoXCItXCIsIFwiXCIpKTtcbiAgfVxuICByZXR1cm4gc3ltYm9sRGVzY01hcFtzeW1ib2xdO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gbW9kdWxlRGVmaW5lKG1vZHVsZU5hbWUsIHN0YXJ0RnVuY3Rpb24sIGRlZmF1bHREYXRhRnVuY3Rpb24pIHtcbiAgY29uc29sZS5sb2coYGxvYWRNb2R1bGVgLCBtb2R1bGVOYW1lK1wiIGJlZ2luXCIpO1xuICAkZGF0YVttb2R1bGVOYW1lXSA9IGRlZmF1bHREYXRhRnVuY3Rpb24oKTtcbiAgJGV2ZW50W21vZHVsZU5hbWVdID0geyBzdGFydDogc3RhcnRGdW5jdGlvbiB9O1xuICBjb25zb2xlLmxvZyhgbG9hZE1vZHVsZWAsIG1vZHVsZU5hbWUrXCIgZW5kXCIpO1xuICByZXR1cm4ge1xuICAgIG1vZHVsZUV2ZW50OiAkZXZlbnRbbW9kdWxlTmFtZV0sXG4gICAgbW9kdWxlRGF0YTogJGRhdGFbbW9kdWxlTmFtZV0sXG4gIH07XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBMb2cobXNnLCAuLi5hcmdzKSB7XG4gIGNvbnNvbGUubG9nKGBbY29weXRyYWRpbmcganMtXSR7bXNnfWAsIGFyZ3MpO1xufVxuXG4vKipcbiAqIFxuICogQHBhcmFtIHtib29sZWFufSBpc1Nob3cg5piv5ZCm5pi+56S65Yqg6L295qGGXG4gKi9cbmV4cG9ydCBmdW5jdGlvbiBzaG93TG9hZGluZyhpc1Nob3cgPSB0cnVlKSB7XG4gICRuYXRpdmVBUEkuc2hvd0xvYWRpbmcoaXNTaG93ID8gMSA6IDApO1xufVxuXG5sZXQgc3ltYm9sTWFwID0ge307XG5cbi8qKlxuICogXG4gKiBAcGFyYW0ge3N0cmluZ30gc3ltYm9sIOW4geWvueS/oeaBr++8jEJUQy1VU0RUXG4gKiBAcmV0dXJucyDov5Tlm57njrDotKfkuqTmmJPlr7nmqKHlnotcbiAqL1xuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGdldFNwb3RTeW1ib2xNb2RlbChzeW1ib2wpIHtcbiAgaWYgKHN5bWJvbE1hcC5oYXNPd25Qcm9wZXJ0eShzeW1ib2wpKSB7XG4gICAgcmV0dXJuIHN5bWJvbE1hcFtzeW1ib2xdO1xuICB9XG4gIGNvbnN0IGpzb24gPSBhd2FpdCAkbmF0aXZlQVBJLmdldFNwb3RTeW1ib2xNb2RlbChzeW1ib2wpO1xuICBjb25zb2xlLmxvZyhgdGwgLS0gZ2V0U3BvdFN5bWJvbE1vZGVsPT0+anNvbj09JHtqc29ufWApO1xuICBjb25zdCByZXNwb25zZSA9IEpTT04ucGFyc2UoanNvbik7XG4gIGNvbnNvbGUubG9nKGB0bCAtLSBnZXRTcG90U3ltYm9sTW9kZWw9PT5yZXNwb25zZT09JHtyZXNwb25zZX1gKTtcbiAgc3ltYm9sTWFwW3N5bWJvbF0gPSByZXNwb25zZTtcbiAgcmV0dXJuIHJlc3BvbnNlO1xufVxuXG4vKipcbiAqIOa3u+WKoC/liKDpmaToh6rpgIlcbiAqIEBwYXJhbSB7c3RyaW5nfSBzeW1ib2wg5biB5a+55L+h5oGv77yMQlRDLVVTRFRcbiAqIEBwYXJhbSB7Ym9vbGVhbn0gaXNGYXZvcml0ZSA9MSDlt7Lmt7vliqAgPT4g5pyq5re75YqgXG4gKiBAcmV0dXJuIDAg5pON5L2c5aSx6LSl77yMMSDmk43kvZzmiJDlip9cbiAqL1xuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGhhbmRsZUZhdm9yaXRlKHN5bWJvbCwgaXNGYXZvcml0ZSkge1xuICB2YXIgZGljdCA9IHsgJ3N5bWJvbCc6IHN5bWJvbCwgJ2lzRmF2b3JpdGUnOiBpc0Zhdm9yaXRlIH07XG4gIGNvbnNvbGUubG9nKGB0bCAtLSBoYW5kbGVGYXZvcml0ZSwgc3ltYm9sPT0ke3N5bWJvbH0sIGlzRmF2b3JpdGU9PSR7aXNGYXZvcml0ZX1gKTtcbiAgcmV0dXJuIGF3YWl0ICRuYXRpdmVBUEkuaGFuZGxlRmF2b3JpdGUoSlNPTi5zdHJpbmdpZnkoZGljdCkpO1xufVxuXG4vKipcbiAqIOiOt+WPluW4geenjeWbvuagh1xuICogQHBhcmFtIHtzdHJpbmd9IGJhc2VDdXJyZW5jeSDln7rnoYDluIHkv6Hmga/vvIzkvovlpoIgQlRD77yMRVRIXG4gKiBAcmV0dXJucyDov5Tlm57luIHlr7nlm77moIcgcG5nIOWcsOWdgFxuICovXG5leHBvcnQgZnVuY3Rpb24gaGFuZGxlUE5HSWNvblVybChiYXNlQ3VycmVuY3kpIHtcbiAgbGV0IGJhc2VVcmwgPSBjb21tb25EYXRhLndlYlVybCA/IGNvbW1vbkRhdGEud2ViVXJsIDogXCJcIjtcbiAgbGV0IGljb25VcmwgPSBgJHtiYXNlVXJsfS8tL3gvaGIvcC9hcGkvY29udGVudHMvY3VycmVuY3kvaWNvbl9wbmcvJHtiYXNlQ3VycmVuY3kudG9Mb3dlckNhc2UoKX0ucG5nYDtcbiAgY29uc29sZS5sb2coYHRsIC0tIGhhbmRsZVBOR0ljb25VcmwsIGljb25Vcmw9PSR7aWNvblVybH1gKTtcbiAgcmV0dXJuIGljb25Vcmw7XG59IiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiO1xuXG5hc3luYyBmdW5jdGlvbiBzdGFydCgpIHt9XG5cbmZ1bmN0aW9uIGRlZmF1bHREYXRhKCkge1xuICByZXR1cm4ge307XG59XG5cbmNvbnN0IHsgbW9kdWxlRGF0YSwgbW9kdWxlRXZlbnQgfSA9IGNvbW1vbi5tb2R1bGVEZWZpbmUoXG4gIFwiZnV0dXJlc1wiLFxuICBzdGFydCxcbiAgZGVmYXVsdERhdGFcbik7XG5cbi8v5Y675Lmw5biBXG52YXIgY2FuSnVtcCA9IHRydWU7XG5tb2R1bGVFdmVudC5idXkgPSBhc3luYyBmdW5jdGlvbiAoKSB7XG4gIGlmICghY2FuSnVtcCkge1xuICAgIHJldHVybjtcbiAgfVxuICBjYW5KdW1wID0gZmFsc2U7XG4gIC8vIGxldCB1cmwgPSBgaG9saWdlaXQ6Ly9vcGVuL3YxPyZsb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vb3RjL2luZGV4P3RyYWRlQXJlYT1wMnAmaXNPdXRBcmVhPXRydWUmdHJhZGVTaWRlPWJ1eSZ0cmFkZUN1cnJlbmN5PVVTRFQmZmlhdE5hbWU9Q05ZYDtcbiAgbGV0IHVybCA9IGBob2xpZ2VpdDovL29wZW4vdjE/bG9naW49MSZ1cmw9aWh1b2JpZ2xvYmFsOi8vbS5oYmcuY29tL290Yy90cmFkZWA7XG4gIGNvbW1vbi5vcGVuVVJMKHVybCk7XG4gIHNldFRpbWVvdXQoZnVuY3Rpb24gKCkge1xuICAgIGNhbkp1bXAgPSB0cnVlO1xuICAgIGNvbnNvbGUubG9nKGB0bCAtLSBidXks6Ziy5q2i6YeN5aSN54K55Ye7LGNhbkp1bXA9PSR7Y2FuSnVtcH1gKTtcbiAgfSwgMjAwMCk7XG59O1xuXG4vL+WOu+WFheWAvFxubW9kdWxlRXZlbnQucmVjaGFyZ2UgPSBhc3luYyBmdW5jdGlvbiAoKSB7XG4gIGlmICghY2FuSnVtcCkge1xuICAgIHJldHVybjtcbiAgfVxuICBjYW5KdW1wID0gZmFsc2U7XG4gIGxldCB1cmwgPSBgaG9saWdlaXQ6Ly9vcGVuL3YxPyZsb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vb3RjL2luZGV4P3RyYWRlQXJlYT1kZXBvc2l0JmlzT3V0QXJlYT10cnVlJnRyYWRlU2lkZT1idXkmdHJhZGVDdXJyZW5jeT1VU0RUJmZpYXROYW1lPUNOWWA7XG4gIGNvbW1vbi5vcGVuVVJMKHVybCk7XG4gIHNldFRpbWVvdXQoZnVuY3Rpb24gKCkge1xuICAgIGNhbkp1bXAgPSB0cnVlO1xuICAgIGNvbnNvbGUubG9nKGByZWNoYXJnZSzpmLLmraLph43lpI3ngrnlh7ssY2FuSnVtcD09JHtjYW5KdW1wfWApO1xuICB9LCAyMDAwKTtcbiAgY29uc29sZS5sb2coYHJlY2hhcmdlIC0tIHVybD09JHt1cmx9YCk7XG59O1xuXG4vL+i3n+WNlVxubW9kdWxlRXZlbnQuY29weXRyYWRpbmcgPSBhc3luYyBmdW5jdGlvbiAoKSB7XG4gIGlmICghY2FuSnVtcCkge1xuICAgIHJldHVybjtcbiAgfVxuICBjYW5KdW1wID0gZmFsc2U7XG4gIGxldCB1cmwgPSBgaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9Db250cmFjdC9Db3B5VHJhZGluZz9pbmRleD0wYDtcbiAgY29tbW9uLm9wZW5VUkwodXJsKTtcbiAgc2V0VGltZW91dChmdW5jdGlvbiAoKSB7XG4gICAgY2FuSnVtcCA9IHRydWU7XG4gICAgY29uc29sZS5sb2coYGNvcHl0cmFkaW5nLOmYsuatoumHjeWkjeeCueWHuyxjYW5KdW1wPT0ke2Nhbkp1bXB9YCk7XG4gIH0sIDIwMDApO1xuICBjb25zb2xlLmxvZyhgY29weXRyYWRpbmcgLS0gdXJsPT0ke3VybH1gKTtcbn07XG5cbi8v5Y675YiS6L2sXG5tb2R1bGVFdmVudC50cmFuc2ZlciA9IGFzeW5jIGZ1bmN0aW9uICgpIHtcbiAgaWYgKCFjYW5KdW1wKSB7XG4gICAgcmV0dXJuO1xuICB9XG4gIGNhbkp1bXAgPSBmYWxzZTtcbiAgdmFyIGFjY291bnQgPSAxMTsvL+m7mOiupFXmnKzkvY1cbiAgaWYgKGNvbW1vbi5jb21tb25EYXRhLmNvbnRyYWN0VHlwZSA9PSBcImRlbGl2ZXJ5XCIpIHtcbiAgICBhY2NvdW50ID0gNDtcbiAgfSBlbHNlIGlmIChjb21tb24uY29tbW9uRGF0YS5jb250cmFjdFR5cGUgPT0gXCJzd2FwXCIpIHtcbiAgICBhY2NvdW50ID0gNztcbiAgfSBlbHNlIGlmIChjb21tb24uY29tbW9uRGF0YS5jb250cmFjdFR5cGUgPT0gXCJsaW5lYXJTd2FwXCIpIHtcbiAgICBhY2NvdW50ID0gMTE7XG4gIH1cbiAgbGV0IHVybCA9IGBob2xpZ2VpdDovL29wZW4vdjE/bG9naW49MSZ1cmw9aWh1b2JpZ2xvYmFsOi8vbS5oYmcuY29tL2JhbGFuY2UvdHJhbnNmZXI/Y29pbj11c2R0JmFjY291bnQ9JHthY2NvdW50fWA7XG4gIGNvbnNvbGUubG9nKGBjb250cmFjdFR5cGU9PSR7Y29tbW9uLmNvbW1vbkRhdGEuY29udHJhY3RUeXBlfWApO1xuICBjb21tb24ub3BlblVSTCh1cmwpO1xuICBzZXRUaW1lb3V0KGZ1bmN0aW9uICgpIHtcbiAgICBjYW5KdW1wID0gdHJ1ZTtcbiAgICBjb25zb2xlLmxvZyhgdHJhbnNmZXIs6Ziy5q2i6YeN5aSN54K55Ye7LGNhbkp1bXA9PSR7Y2FuSnVtcH1gKTtcbiAgfSwgMjAwMCk7XG4gIGNvbnNvbGUubG9nKGB0cmFuc2ZlciAtLSB1cmw9PSR7dXJsfWApO1xufTtcbiIsImltcG9ydCAqIGFzIGNvbW1vbiBmcm9tICcuL2NvbW1vbidcblxudmFyIG1vZHVsZURpZFN0YXJ0ID0gZmFsc2U7XG5cbi8v5Yid5aeL5YyWXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc3RhcnQoKSB7XG4gICAgLy9jb25zb2xlLmxvZyhcInJlcXVlc3ROb3RpY2VMaXN0IHN0YXJ0IHN0YXJ0XCIpO1xuICAgIG1vZHVsZURpZFN0YXJ0ID0gdHJ1ZTtcbiAgICBhd2FpdCByZXF1ZXN0Tm90aWNlTGlzdCgpO1xufVxuXG4vL+WIneWni+WMluaVsOaNrlxuZnVuY3Rpb24gZGVmYXVsdERhdGEoKSB7XG4gICAgLy9jb25zb2xlLmxvZyhcInJlcXVlc3ROb3RpY2VMaXN0IGRlZmF1bHREYXRhXCIpO1xuICAgIHJldHVybiB7XG4gICAgICAgIG5vdGljZUxpc3Q6W10sXG4gICAgICAgIG5vdGljZVZpc2liaWxpdHk6XCJnb25lXCIsXG4gICAgICAgIC8vICDlub/lkYrliJfooajmjIfnpLrlmahcbiAgICAgICAgbm90aWNlSW5kaWNhdG9yTGlzdDogW10sXG4gICAgICAgIC8vICDlub/lkYrliJfooajmjIfnpLrlmajmmK/lkKblj6/op4FcbiAgICAgICAgbm90aWNlSW5kaWNhdG9yVmlzaWJpbGl0eTogJ2dvbmUnLFxuICAgICAgICBhdXRvU2Nyb2xsOiBcInRydWVcIixcbiAgICAgICAgY3VycmVudE5vdGljZUluZGV4OlwiMFwiXG4gICB9O1xufVxuXG5jb25zdCB7IG1vZHVsZURhdGEsIG1vZHVsZUV2ZW50IH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFxuICBcImNvbnRyYWN0Tm90aWNlXCIsXG4gIHN0YXJ0LFxuICBkZWZhdWx0RGF0YVxuKTtcblxudmFyIGNsb3NlZE5vdGljZVNldCA9IG5ldyBTZXQoKTtcbnZhciBub3RpY2VFeHBvc3VyZU1hcCA9IG5ldyBNYXAoKTtcblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIG5vdGljZUV4cG9zdXJlKCkge1xuICAgIHZhciBpbmRleCA9IHBhcnNlSW50KG1vZHVsZURhdGEuY3VycmVudE5vdGljZUluZGV4KTtcbiAgICBpZiAoaW5kZXggPj0gbm90aWNlRGF0YUxpc3QubGVuZ3RoKSB7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgdmFyIG9iaiA9IG5vdGljZURhdGFMaXN0W2luZGV4XTtcbiAgICBpZighbm90aWNlRXhwb3N1cmVNYXAuaGFzKG9ialtcImFkdklkXCJdKSl7XG4gICAgICAgIHRyeSB7XG4gICAgICAgICAgICBhd2FpdCBjb21tb24uYW5hbHl0aWNzKFwicGFnZXZpZXdfY29udHJhY3RzXCIsIHtcbiAgICAgICAgICAgICAgICAgICAgYnVzaW5lc3NfY2F0ZWdvcnk6IFwiY29udHJhY3RzX2FwcFwiLFxuICAgICAgICAgICAgICAgICAgICBidXR0b25fbmFtZTogXCJiYW5uZXJcIixcbiAgICAgICAgICAgICAgICAgICAgYnV0dG9uX2xvY2F0aW9uOiBTdHJpbmcob2JqW1wiYWR2SWRcIl0pLFxuICAgICAgICAgICAgICAgIH0pO1xuICAgICAgICAgICBub3RpY2VFeHBvc3VyZU1hcC5zZXQob2JqW1wiYWR2SWRcIl0sdHJ1ZSk7XG4gICAgICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGBub3RpY2Ugbm90aWNlRXhwb3N1cmVNYXAgZXJyb3IsIGVycm9yPSR7ZX1gKTtcbiAgICAgICAgfVxuICAgIH1cbn1cblxudmFyIG5vdGljZURhdGFMaXN0ID0gW107XG5cbmFzeW5jIGZ1bmN0aW9uIHJlcXVlc3ROb3RpY2VMaXN0KCkge1xuICAgIC8vY29uc29sZS5sb2coXCJyZXF1ZXN0Tm90aWNlTGlzdCBiZWdpblwiKTtcbiAgICB2YXIgcGFyYW1zID0ge1wicGFnZVR5cGVcIjpjb21tb24uY29tbW9uRGF0YS5wYWdlVHlwZSxcInNob3dUeXBlXCI6OX07XG4gICAgbGV0IG5vdGljZURhdGEgPSBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3QoXCJ2MS9jb25maWcvcHVzaC9iYW5uZXIvbGlzdFwiLCBwYXJhbXMsIDAsIDAsIHt9KTtcbiAgICBpZiAobm90aWNlRGF0YSAmJiBub3RpY2VEYXRhLmJhbm5lckFkdkxpc3QgIT0gbnVsbCAmJiBub3RpY2VEYXRhLmJhbm5lckFkdkxpc3QubGVuZ3RoID4gMCkge1xuICAgICAgICByZWZyZXNoTm90aWNlTGlzdChub3RpY2VEYXRhLmJhbm5lckFkdkxpc3QpO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIG5vdGljZURhdGFMaXN0ID0gW107XG4gICAgICAgIG1vZHVsZURhdGEubm90aWNlTGlzdCA9IFtdO1xuICAgICAgICBtb2R1bGVEYXRhLm5vdGljZVZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlZnJlc2hOb3RpY2VMaXN0KGJhbm5lckFkdkxpc3QpIHtcbiAgICBpZiAoYmFubmVyQWR2TGlzdCAmJiBiYW5uZXJBZHZMaXN0Lmxlbmd0aCA+IDApIHtcbiAgICAgICAgLy9jb25zb2xlLmxvZyhcInJlcXVlc3ROb3RpY2VMaXN0IGJhbm5lckFkdkxpc3Q6XCIgKyBKU09OLnN0cmluZ2lmeShiYW5uZXJBZHZMaXN0KSk7XG4gICAgICAgIHZhciBkYXRhTGlzdCA9IFtdO1xuICAgICAgICB2YXIgaSA9IDA7XG4gICAgICAgIGF3YWl0IGxvYWRTYXZlQ2xvc2VkTm90aWNlKCk7XG4gICAgICAgIC8v6L+H5ruk5bey5bGV56S65pWw5o2uXG4gICAgICAgIGZvciAobGV0IGl0ZW0gb2YgYmFubmVyQWR2TGlzdCkge1xuICAgICAgICAgICAgLy9jb25zb2xlLmxvZyhcInJlcXVlc3ROb3RpY2VMaXN0IGFkdklkOlwiICsgaXRlbVtcImFkdklkXCJdK1wiIGhhc++8mlwiK2Nsb3NlZE5vdGljZVNldC5oYXMoaXRlbVtcImFkdklkXCJdKSk7XG4gICAgICAgICAgICBpZihjbG9zZWROb3RpY2VTZXQuaGFzKGl0ZW1bXCJhZHZJZFwiXSkpe1xuICAgICAgICAgICAgICAgIGNvbnRpbnVlO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgaXRlbS5pbmRleCA9IGkrKztcbiAgICAgICAgICAgIGl0ZW0udHlwZSA9IFwiMVwiO1xuICAgICAgICAgICAgaXRlbS5jdXJyZW50SW1hZ2VVUkwgPSBjb21tb24uY29tbW9uRGF0YS5jb2xvck1vZGUgPT09IDEgPyBpdGVtLm5pZ2h0SW1hZ2VVcmwgOiBpdGVtLmltYWdlVXJsO1xuICAgICAgICAgICAgZGF0YUxpc3QucHVzaChpdGVtKTtcbiAgICAgICAgfVxuICAgICAgICAvL2NvbnNvbGUubG9nKFwicmVxdWVzdE5vdGljZUxpc3QgIGRhdGFMaXN0Lmxlbmd0aO+8mlwiK2RhdGFMaXN0Lmxlbmd0aCk7XG4gICAgICAgIG1vZHVsZURhdGEubm90aWNlTGlzdCA9IGRhdGFMaXN0O1xuICAgICAgICBtb2R1bGVEYXRhLm5vdGljZVZpc2liaWxpdHkgPSBkYXRhTGlzdC5sZW5ndGggPiAwID8gXCJ2aXNpYmxlXCIgOiBcImdvbmVcIjtcbiAgICAgICAgbm90aWNlRGF0YUxpc3QgPSBkYXRhTGlzdDtcbiAgICAgICAgLy/lj6rmnInkuIDmnaHmlbDmja4g5Y+R546w5LiN5Lya5omn6KGMc2VsZWN0ZWROb3RpY2VJbmRleOWbnuiwgyAg5omL5Yqo6LCD5LiA5LiLXG4gICAgICAgIG5vdGljZUV4cG9zdXJlKCk7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgbm90aWNlRGF0YUxpc3QgPSBbXTtcbiAgICAgICAgbW9kdWxlRGF0YS5ub3RpY2VMaXN0ID0gW107XG4gICAgICAgIG1vZHVsZURhdGEubm90aWNlVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgIH1cbiAgICBoYW5kbGVTbGlkZXJJbmRpY2F0b3JWaWV3KCk7XG59XG5cbi8qKlxuICog5aSE55CG6L2u5pKt5oyH56S65Zmo6KeG5Zu+XG4gKi9cbmZ1bmN0aW9uIGhhbmRsZVNsaWRlckluZGljYXRvclZpZXcoKSB7XG4gICAgbGV0IGluZGljYXRvckxpc3QgPSBbXTtcbiAgICBmb3IgKGxldCBpbmRleCA9IDA7IGluZGV4IDwgbm90aWNlRGF0YUxpc3QubGVuZ3RoOyBpbmRleCsrKSB7XG4gICAgICAgIGlmIChtb2R1bGVEYXRhLmN1cnJlbnROb3RpY2VJbmRleCA9PSBTdHJpbmcoaW5kZXgpKSB7XG4gICAgICAgICAgICBpbmRpY2F0b3JMaXN0LnB1c2goeyAndHlwZSc6ICcxJyB9KTtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGluZGljYXRvckxpc3QucHVzaCh7ICd0eXBlJzogJzInIH0pO1xuICAgICAgICB9XG4gICAgfVxuICAgIG1vZHVsZURhdGEubm90aWNlSW5kaWNhdG9yVmlzaWJpbGl0eSA9IGluZGljYXRvckxpc3QubGVuZ3RoID4gMSA/ICd2aXNpYmxlJyA6ICdnb25lJztcbiAgICBtb2R1bGVEYXRhLm5vdGljZUluZGljYXRvckxpc3QgPSBpbmRpY2F0b3JMaXN0O1xufVxuXG5hc3luYyBmdW5jdGlvbiBsb2FkU2F2ZUNsb3NlZE5vdGljZSgpIHtcbiAgICB2YXIgbm90aWNlQ2xvc2VkID0gYXdhaXQgY29tbW9uLnJlYWQoXCJjb250cmFjdE5vdGljZVwiLFwiY29udHJhY3ROb3RpY2VFeHBvc3VyZVwiKTtcbiAgICAvL2NvbnNvbGUubG9nKFwicmVxdWVzdE5vdGljZUxpc3QgbG9hZFNhdmVDbG9zZWROb3RpY2Ugbm90aWNlQ2xvc2VkOlwiK25vdGljZUNsb3NlZCtcIiBub3RpY2VDbG9zZWTvvJpcIiArIEpTT04uc3RyaW5naWZ5KG5vdGljZUNsb3NlZCkpO1xuICAgIGlmIChub3RpY2VDbG9zZWQgJiYgbm90aWNlQ2xvc2VkLmxlbmd0aCA+IDApIHtcbiAgICAgICAgLy9jb25zb2xlLmxvZyhcInJlcXVlc3ROb3RpY2VMaXN0IGxvYWRTYXZlQ2xvc2VkTm90aWNlIGVudGVyOlwiKTtcbiAgICAgICAgZm9yIChsZXQgaXRlbSBvZiBub3RpY2VDbG9zZWQpIHtcbiAgICAgICAgICAgIC8vY29uc29sZS5sb2coXCJyZXF1ZXN0Tm90aWNlTGlzdCBsb2FkU2F2ZUNsb3NlZE5vdGljZSBlbnRlciBpdGVtOlwiK2l0ZW0pO1xuICAgICAgICAgICAgY2xvc2VkTm90aWNlU2V0LmFkZChpdGVtKTtcbiAgICAgICAgfVxuICAgIH1cbn1cblxubW9kdWxlRXZlbnQuc2VsZWN0ZWROb3RpY2VJbmRleCA9IGFzeW5jIGZ1bmN0aW9uIChpbmRleCkge1xuICAgICRkYXRhLmNvbnRyYWN0Tm90aWNlLmN1cnJlbnROb3RpY2VJbmRleCA9IFN0cmluZyhpbmRleCk7XG4gICAgYXdhaXQgbm90aWNlRXhwb3N1cmUoKTtcbiAgICBoYW5kbGVTbGlkZXJJbmRpY2F0b3JWaWV3KCk7XG4gICAgLy9jb25zb2xlLmxvZyhcInNlbGVjdGVkTm90aWNlSW5kZXggXCIgKyBpbmRleCk7XG59XG5cblxubW9kdWxlRXZlbnQuY2xpY2tOb3RpY2VJdGVtID0gYXN5bmMgZnVuY3Rpb24gKCkge1xuICAgIHZhciBpbmRleCA9IHBhcnNlSW50KG1vZHVsZURhdGEuY3VycmVudE5vdGljZUluZGV4KTtcblxuICAgIGlmIChpbmRleCA+PSBub3RpY2VEYXRhTGlzdC5sZW5ndGgpIHtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICB2YXIgb2JqID0gbm90aWNlRGF0YUxpc3RbaW5kZXhdO1xuICAgIGlmIChvYmouanVtcFRvICE9IG51bGwpIHtcbiAgICAgICAgLy9jb25zb2xlLmxvZygnY2xpY2tOb3RpY2XvvJonICsgb2JqLmp1bXBUbyk7XG4gICAgICAgIGF3YWl0IGNvbW1vbi5vcGVuVVJMKGVuY29kZVVSSShvYmouanVtcFRvKSk7XG4gICAgfVxuICAgIGF3YWl0IGNvbW1vbi5hbmFseXRpY3MoXCJhcHBjbGlja19jb250cmFjdHNcIiwge1xuICAgICAgICAgICAgICAgICAgICAgICAgYnVzaW5lc3NfY2F0ZWdvcnk6IFwiY29udHJhY3RzX2FwcFwiLFxuICAgICAgICAgICAgICAgICAgICAgICAgYnV0dG9uX25hbWU6IFwiYmFubmVyXCIsXG4gICAgICAgICAgICAgICAgICAgICAgICBidXR0b25fbG9jYXRpb246IFN0cmluZyhvYmpbXCJhZHZJZFwiXSksXG4gICAgICAgICAgICAgICAgICAgIH0pO1xufVxuXG5tb2R1bGVFdmVudC5jbGlja05vdGljZUNsb3NlID0gYXN5bmMgZnVuY3Rpb24gKCkge1xuICAgIG1vZHVsZURhdGEubm90aWNlVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuXG4gICAgdmFyIHNhdmVEYXRhID0gW107XG4gICAgZm9yIChsZXQgaXRlbSBvZiBub3RpY2VEYXRhTGlzdCkge1xuICAgICAgICAvL+aWsOaVsOaNruWSjOaXp+aVsOaNriDkuIDotbforrDlvZXliLDmlofku7Yg5Y+q6K6w5b2V5pyA5paw55qE5a2Y5Zyo6Zeu6aKY77yaMeOAgTLlhbPpl63lkI4g5ouJ5Y+WMyDlhbPpl60z5ZCOICAx44CBMuWPiOWHuueOsOS6hlxuICAgICAgICBjbG9zZWROb3RpY2VTZXQuYWRkKGl0ZW1bXCJhZHZJZFwiXSk7XG4gICAgfVxuICAgIGNsb3NlZE5vdGljZVNldC5mb3JFYWNoIChmdW5jdGlvbih2YWx1ZSkge1xuICAgICAgc2F2ZURhdGEucHVzaCh2YWx1ZSk7XG4gICAgfSlcbiAgICBub3RpY2VEYXRhTGlzdCA9IFtdO1xuICAgIG1vZHVsZURhdGEubm90aWNlTGlzdCA9IFtdO1xuICAgIC8vY29uc29sZS5sb2coXCJyZXF1ZXN0Tm90aWNlTGlzdCBjbGlja05vdGljZUNsb3NlIHNhdmVEYXRhOlwiICsgSlNPTi5zdHJpbmdpZnkoc2F2ZURhdGEpKTtcbiAgICBhd2FpdCBjb21tb24uc2F2ZShcImNvbnRyYWN0Tm90aWNlXCIsIFwiY29udHJhY3ROb3RpY2VFeHBvc3VyZVwiLCBzYXZlRGF0YSk7XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBwYWdlQXBwZWFyKCkge1xuICAgIGlmIChtb2R1bGVEaWRTdGFydCA9PSBmYWxzZSkge1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIG1vZHVsZURhdGEuYXV0b1Njcm9sbCA9IFwidHJ1ZVwiO1xuICAgIC8v6aG16Z2i5Y+v6KeBIOWIt+aWsOWIl+ihqCDov4fmu6TmlbDmja5cbiAgICByZWZyZXNoTm90aWNlTGlzdChub3RpY2VEYXRhTGlzdCk7XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBwYWdlRGlzYXBwZWFyKCkge1xuICAgIGlmIChtb2R1bGVEaWRTdGFydCA9PSBmYWxzZSkge1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIG1vZHVsZURhdGEuYXV0b1Njcm9sbCA9IFwiZmFsc2VcIjtcbn1cblxuIiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiO1xuaW1wb3J0ICogYXMgcmVjaGFyZ2VFbnRyeSBmcm9tIFwiLi9yZWNoYXJnZUVudHJ5XCI7XG5pbXBvcnQgKiBhcyBjb250cmFjdE5vdGljZSBmcm9tIFwiLi9jb250cmFjdE5vdGljZVwiO1xuXG5hc3luYyBmdW5jdGlvbiBzZW5kQ29udHJhY3RJbmZvKHBhcmFtcykge1xuICBjb25zb2xlLmxvZyhgY29udHJhY3RUeXBlIC0tIGRpY3Q9PSR7cGFyYW1zLmNvbnRyYWN0VHlwZX1gKTtcbiAgaWYgKGNvbW1vbi5jb21tb25EYXRhLmNvbnRyYWN0VHlwZSAhPSBwYXJhbXMuY29udHJhY3RUeXBlKSB7XG4gICAgY29tbW9uLmNvbW1vbkRhdGEuY29udHJhY3RUeXBlID0gcGFyYW1zLmNvbnRyYWN0VHlwZTtcbiAgfVxufVxuXG5mdW5jdGlvbiBzZW5kQ29tbW9uQ29uZmlnKHBhcmFtKSB7XG4gICAgY29tbW9uLnNlbmRDb21tb25Db25maWcocGFyYW0pO1xufVxuXG5hc3luYyBmdW5jdGlvbiBwYWdlQXBwZWFyKCkge1xuICAgIGNvbnRyYWN0Tm90aWNlLnBhZ2VBcHBlYXIoKTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gcGFnZURpc2FwcGVhcigpIHtcbiAgICBjb250cmFjdE5vdGljZS5wYWdlRGlzYXBwZWFyKCk7XG59XG5cbiRldmVudC5zZW5kQ29udHJhY3RJbmZvID0gc2VuZENvbnRyYWN0SW5mbztcbiRldmVudC5wYWdlQXBwZWFyID0gcGFnZUFwcGVhcjtcbiRldmVudC5wYWdlRGlzYXBwZWFyID0gcGFnZURpc2FwcGVhcjtcbiRldmVudC5zZW5kQ29tbW9uQ29uZmlnID0gc2VuZENvbW1vbkNvbmZpZzsiXSwibmFtZXMiOlsiY2xpY2thYmxlIiwiY29tbW9uRGF0YSIsInVzZXJTaWduIiwiY3VycmVudFN5bWJvbCIsImN1cnJlbnRDb250cmFjdEluZm8iLCJjb250cmFjdEluZm9EYXRhIiwiY29udHJhY3RINVVybCIsImN1cnJlbmN5UmF0ZSIsImN1cnJlbmN5Q2hhcmFjdGVyIiwicHJpY2VDb2xvclR5cGUiLCJjb2xvck1vZGUiLCJPUyIsImFwcFZlcnNpb24iLCJpc0luUmV2aWV3IiwiaXNMb2dpbiIsIndlYlVybCIsImxhbmd1YWdlIiwicGFnZVR5cGUiLCJjb250cmFjdFR5cGUiLCJ1c2VySW5mbyIsImFzeW5jIiwic2VuZFJlcXVlc3QiLCJwYXRoIiwicGFyYW1zIiwibWV0aG9kIiwiaG9zdFR5cGUiLCJoZWFkZXIiLCJjb25zb2xlIiwibG9nIiwiSlNPTiIsInN0cmluZ2lmeSIsInBhcmFtIiwicmVzcG9uc2VTdHJpbmciLCIkbmF0aXZlQVBJIiwicmVxdWVzdCIsInJlc3BvbnNlIiwicGFyc2UiLCJjb2RlIiwiZGF0YSIsInN0YXR1cyIsImVycl9jb2RlIiwiZXJyX21zZyIsInN0YXJ0Iiwic3RhcnRJbmRleCIsImluZGV4T2YiLCJlbmQiLCJlbmRJbmRleCIsImRhdGFTdHJpbmciLCJzdWJzdHJpbmciLCJsZW5ndGgiLCJzaG93VG9hc3QiLCJtZXNzYWdlIiwiZSIsIm9wZW5VUkwiLCJ1cmwiLCJvcGVuUm91dGUiLCJzZXRUaW1lb3V0IiwibXNnIiwiaGJUb2FzdCIsInNhdmUiLCJtb2R1bGUiLCJrZXkiLCJzdG9yYWdlIiwiYWN0aW9uIiwibmFtZSIsInJlYWQiLCJhbmFseXRpY3MiLCJldmVudCIsInByb3BlcnRpZXMiLCJwcm9wZXJ0aWVzSnNvbiIsIm1hcCIsInNlbmRDb21tb25Db25maWciLCJzYXZlZFN5bWJvbCIsInBhcnNlSW50IiwiaDVVcmwiLCJtb2R1bGVEZWZpbmUiLCJtb2R1bGVOYW1lIiwic3RhcnRGdW5jdGlvbiIsImRlZmF1bHREYXRhRnVuY3Rpb24iLCIkZGF0YSIsIiRldmVudCIsIm1vZHVsZUV2ZW50IiwibW9kdWxlRGF0YSIsImRlZmF1bHREYXRhIiwiY29tbW9uLm1vZHVsZURlZmluZSIsImNhbkp1bXAiLCJidXkiLCJjb21tb24ub3BlblVSTCIsInJlY2hhcmdlIiwiY29weXRyYWRpbmciLCJ0cmFuc2ZlciIsImFjY291bnQiLCJjb21tb24uY29tbW9uRGF0YSIsIm1vZHVsZURpZFN0YXJ0IiwicmVxdWVzdE5vdGljZUxpc3QiLCJub3RpY2VMaXN0Iiwibm90aWNlVmlzaWJpbGl0eSIsIm5vdGljZUluZGljYXRvckxpc3QiLCJub3RpY2VJbmRpY2F0b3JWaXNpYmlsaXR5IiwiYXV0b1Njcm9sbCIsImN1cnJlbnROb3RpY2VJbmRleCIsImNsb3NlZE5vdGljZVNldCIsIlNldCIsIm5vdGljZUV4cG9zdXJlTWFwIiwiTWFwIiwibm90aWNlRXhwb3N1cmUiLCJpbmRleCIsIm5vdGljZURhdGFMaXN0Iiwib2JqIiwiaGFzIiwiY29tbW9uLmFuYWx5dGljcyIsImJ1c2luZXNzX2NhdGVnb3J5IiwiYnV0dG9uX25hbWUiLCJidXR0b25fbG9jYXRpb24iLCJTdHJpbmciLCJzZXQiLCJzaG93VHlwZSIsIm5vdGljZURhdGEiLCJjb21tb24uc2VuZFJlcXVlc3QiLCJiYW5uZXJBZHZMaXN0IiwicmVmcmVzaE5vdGljZUxpc3QiLCJkYXRhTGlzdCIsImkiLCJsb2FkU2F2ZUNsb3NlZE5vdGljZSIsIml0ZW0iLCJ0eXBlIiwiY3VycmVudEltYWdlVVJMIiwibmlnaHRJbWFnZVVybCIsImltYWdlVXJsIiwicHVzaCIsImhhbmRsZVNsaWRlckluZGljYXRvclZpZXciLCJpbmRpY2F0b3JMaXN0Iiwibm90aWNlQ2xvc2VkIiwiY29tbW9uLnJlYWQiLCJhZGQiLCJzZWxlY3RlZE5vdGljZUluZGV4IiwiY29udHJhY3ROb3RpY2UiLCJjbGlja05vdGljZUl0ZW0iLCJqdW1wVG8iLCJlbmNvZGVVUkkiLCJjbGlja05vdGljZUNsb3NlIiwic2F2ZURhdGEiLCJmb3JFYWNoIiwidmFsdWUiLCJjb21tb24uc2F2ZSIsInBhZ2VBcHBlYXIiLCJwYWdlRGlzYXBwZWFyIiwic2VuZENvbnRyYWN0SW5mbyIsImNvbW1vbi5zZW5kQ29tbW9uQ29uZmlnIiwiY29udHJhY3ROb3RpY2UucGFnZUFwcGVhciIsImNvbnRyYWN0Tm90aWNlLnBhZ2VEaXNhcHBlYXIiXSwibWFwcGluZ3MiOiJBQUVBLElBQUlBLFlBQVk7O0FBbUJULElBQUlDLGFBQWE7SUFDdEJDLFVBQVU7SUFDVkMsZUFBZTtJQUNmQyxxQkFBcUIsQ0FBRTtJQUN2QkMsa0JBQWtCO0lBQ2xCQyxlQUFlO0lBQ2ZDLGNBQWM7SUFDZEMsbUJBQW1CO0lBQ25CQyxnQkFBZ0I7SUFDaEJDLFdBQVc7SUFDWEMsSUFBSTtJQUNKQyxZQUFZO0lBQ1pDLFlBQVk7SUFDWkMsU0FBUztJQUNUQyxRQUFRO0lBQ1JDLFVBQVU7SUFDVkMsVUFBVTtJQUNWQyxjQUFjO0lBQ2RDLFVBQVUsQ0FBRTs7O0FBa0JQQyxlQUFlQyxZQUFZQyxNQUFNQyxTQUFTLElBQUlDLFNBQVMsR0FBR0MsV0FBVyxHQUFHQyxTQUFTO0lBQ3RGQyxRQUFRQyxJQUFJLFdBQVdOLGdCQUFnQk8sS0FBS0MsVUFBVVA7SUFFdEQsSUFBSUUsWUFBWSxLQUFLQSxZQUFZLEdBQUc7UUFDbENDLE9BQU8sa0JBQWtCO0FBQzFCO0lBRUQsTUFBTUssUUFBUTtRQUNaVDtRQUNBRTtRQUNBQztRQUNBQztRQUNBSDs7SUFFRjtRQUNFLElBQUlTLHVCQUF1QkMsV0FBV0MsUUFBUUwsS0FBS0MsVUFBVUM7UUFDN0QsSUFBSUksV0FBV04sS0FBS08sTUFBTUo7UUFDMUIsS0FBSUssTUFBRUEsTUFBSUMsTUFBRUEsUUFBU0g7UUFDckIsSUFBSSxLQUFLVixVQUFVO1lBRWpCLElBQUljLFNBQVNKLFNBQVNJO1lBQ3RCLElBQUlDLFdBQVdMLFNBQVNLO1lBQ3hCLElBQUlDLFVBQVVOLFNBQVNNO1lBQ3ZCLElBQUlGLFVBQVUsTUFBTTtnQkFDbEJaLFFBQVFDLElBQUksV0FBV047Z0JBQ3ZCLFdBQVdnQixTQUFTLFVBQVU7b0JBQzVCLElBQUlJLFFBQVE7b0JBQ1osSUFBSUMsYUFBYVgsZUFBZVksUUFBUUY7b0JBQ3hDLElBQUlHLE1BQU07b0JBQ1YsSUFBSUMsV0FBV2QsZUFBZVksUUFBUUM7b0JBQ3RDLElBQUlFLGFBQWFmLGVBQWVnQixVQUFVTCxhQUFhRCxNQUFNTyxRQUFRSDtvQkFDckVuQixRQUFRQyxJQUFJLHVDQUF1Q21CO29CQUNuRCxPQUFPQTtBQUNSO2dCQUNELE9BQU9UO0FBQ2YsbUJBQWE7Z0JBQ0xYLFFBQVFDLElBQUksd0JBQXdCWSxxQkFBcUJDO2dCQUN6RCxJQUFJakIsVUFBVSxHQUFHO29CQUNmMEIsVUFBVVQ7QUFDWDtnQkFDRCxPQUFPO0FBQ1I7QUFDUCxlQUFXLElBQUlKLFFBQVEsS0FBSztZQUN0QlYsUUFBUUMsSUFBSSxXQUFXTjtZQUN2QixPQUFPZ0I7QUFDYixlQUFXO1lBQ0xYLFFBQVFDLElBQUksd0JBQXdCUztZQUNwQyxJQUFJYyxVQUFVaEIsU0FBU2dCO1lBQ3ZCLElBQUkzQixVQUFVLEtBQUsyQixTQUFTO2dCQUMxQkQsVUFBVUM7QUFDWDtZQUNELE9BQU87QUFDUjtBQUNGLE1BQUMsT0FBT0M7UUFDUHpCLFFBQVFDLElBQUksd0JBQXdCd0I7UUFDcEMsT0FBTztBQUNSO0FBQ0g7O0FBNkZPaEMsZUFBZWlDLFFBQVFDO0lBQzVCLEtBQUt0RCxXQUFXO1FBQ2Q7QUFDRDtJQUNEMkIsUUFBUUMsSUFBSSxhQUFhMEI7SUFDekIsSUFBSUEsT0FBT0EsT0FBTyxRQUFRQSxJQUFJTCxTQUFTLEdBQUc7Y0FDbENoQixXQUFXc0IsVUFBVUQ7QUFDNUI7SUFDRHRELFlBQVk7SUFDWndELFlBQVc7UUFDVHhELFlBQVk7QUFBSSxRQUNmO0FBQ0w7O0FBYU9vQixlQUFlOEIsVUFBVU87VUFDeEJ4QixXQUFXeUIsUUFBUUQ7QUFDM0I7O0FBR09yQyxlQUFldUMsS0FBS0MsUUFBUUMsS0FBS3ZCO1VBQ2hDTCxXQUFXNkIsUUFBUTtRQUN2QkMsUUFBUTtRQUNSQyxNQUFNSjtRQUNOQyxLQUFLQTtRQUNMdkIsTUFBTVQsS0FBS0MsVUFBVVE7O0FBRXpCOztBQUdPbEIsZUFBZTZDLEtBQUtMLFFBQVFDO0lBQ2pDLE1BQU12QixhQUFhTCxXQUFXNkIsUUFBUTtRQUNwQ0MsUUFBUTtRQUNSQyxNQUFNSjtRQUNOQyxLQUFLQTs7SUFFUCxJQUFJdkIsUUFBUUEsUUFBUSxJQUFJO1FBQ3RCLE9BQU9ULEtBQUtPLE1BQU1FO0FBQ25CO0lBQ0QsT0FBTztBQUNUOztBQW9CT2xCLGVBQWU4QyxVQUFVQyxRQUFRLElBQUlDLGFBQWEsQ0FBQTtJQUNyRCxNQUFNQyxpQkFBaUJ4QyxLQUFLQyxVQUFVc0M7SUFDdEN6QyxRQUFRQyxJQUFJLG9CQUFvQnVDLDJCQUEyQkU7SUFDM0QsSUFBSUMsTUFBTTtRQUNOSCxPQUFPQTtRQUNQQyxZQUFZQzs7VUFFVnBDLFdBQVdpQyxVQUFVSTtBQUMvQjs7QUFHT2xELGVBQWVtRCxtQkFBaUJ4QztJQUNyQ0osUUFBUUMsSUFBSUc7SUFDWixJQUFJeUMsb0JBQW9CUCxLQUFLLGVBQWU7SUFDNUMsSUFBSSxRQUFRTyxlQUFlLEtBQUtBLFlBQVl2QixRQUFRO1FBQ2xEaEQsV0FBV0UsZ0JBQWdCO0FBQy9CLFdBQVM7UUFDTEYsV0FBV0UsZ0JBQWdCcUU7QUFDNUI7SUFDRHZFLFdBQVdLLGdCQUFnQnlCLE1BQU16QjtJQUNqQ0wsV0FBV00sZUFBZXdCLE1BQU14QjtJQUNoQyxJQUFJd0IsTUFBTXhCLGdCQUFnQixRQUFRLEtBQUt3QixNQUFNeEIsYUFBYTBDLFFBQVE7UUFDaEVoRCxXQUFXTSxlQUFlO0FBQzNCO0lBQ0ROLFdBQVdPLG9CQUFvQnVCLE1BQU12QjtJQUNyQ1AsV0FBV1EsaUJBQWlCZ0UsU0FBUzFDLE1BQU10QjtJQUMzQ1IsV0FBV1MsWUFBWStELFNBQVMxQyxNQUFNckI7SUFDdENULFdBQVdVLEtBQUs4RCxTQUFTMUMsTUFBTXBCO0lBQy9CVixXQUFXVyxhQUFhbUIsTUFBTW5CO0lBQzlCWCxXQUFXWSxhQUFhNEQsU0FBUzFDLE1BQU1sQjtJQUN2Q1osV0FBV2UsV0FBV2UsTUFBTWY7SUFDNUJmLFdBQVdjLFNBQVNnQixNQUFNMkM7QUFZNUI7O0FBaUJPLFNBQVNDLGFBQWFDLFlBQVlDLGVBQWVDO0lBQ3REbkQsUUFBUUMsSUFBSSxjQUFjZ0QsYUFBVztJQUNyQ0csTUFBTUgsY0FBY0U7SUFDcEJFLE9BQU9KLGNBQWM7UUFBRWxDLE9BQU9tQzs7SUFDOUJsRCxRQUFRQyxJQUFJLGNBQWNnRCxhQUFXO0lBQ3JDLE9BQU87UUFDTEssYUFBYUQsT0FBT0o7UUFDcEJNLFlBQVlILE1BQU1IOztBQUV0Qjs7QUN4VkF4RCxlQUFlc0IsV0FBVTs7QUFFekIsU0FBU3lDO0lBQ1AsT0FBTztBQUNUOztBQUVBLG1CQUFRRCxjQUFVRCxhQUFFQSxpQkFBZ0JHLGFBQ2xDLFdBQ0ExQyxTQUNBeUM7O0FBSUYsSUFBSUUsVUFBVTs7QUFDZEosY0FBWUssTUFBTWxFO0lBQ2hCLEtBQUtpRSxTQUFTO1FBQ1o7QUFDRDtJQUNEQSxVQUFVO0lBRVYsSUFBSS9CLE1BQU07SUFDVmlDLFFBQWVqQztJQUNmRSxZQUFXO1FBQ1Q2QixVQUFVO1FBQ1YxRCxRQUFRQyxJQUFJLDZCQUE2QnlEO0FBQzFDLFFBQUU7QUFDTDs7QUFHQUosY0FBWU8sV0FBV3BFO0lBQ3JCLEtBQUtpRSxTQUFTO1FBQ1o7QUFDRDtJQUNEQSxVQUFVO0lBQ1YsSUFBSS9CLE1BQU07SUFDVmlDLFFBQWVqQztJQUNmRSxZQUFXO1FBQ1Q2QixVQUFVO1FBQ1YxRCxRQUFRQyxJQUFJLDRCQUE0QnlEO0FBQ3pDLFFBQUU7SUFDSDFELFFBQVFDLElBQUksb0JBQW9CMEI7QUFDbEM7O0FBR0EyQixjQUFZUSxjQUFjckU7SUFDeEIsS0FBS2lFLFNBQVM7UUFDWjtBQUNEO0lBQ0RBLFVBQVU7SUFDVixJQUFJL0IsTUFBTTtJQUNWaUMsUUFBZWpDO0lBQ2ZFLFlBQVc7UUFDVDZCLFVBQVU7UUFDVjFELFFBQVFDLElBQUksK0JBQStCeUQ7QUFDNUMsUUFBRTtJQUNIMUQsUUFBUUMsSUFBSSx1QkFBdUIwQjtBQUNyQzs7QUFHQTJCLGNBQVlTLFdBQVd0RTtJQUNyQixLQUFLaUUsU0FBUztRQUNaO0FBQ0Q7SUFDREEsVUFBVTtJQUNWLElBQUlNLFVBQVU7SUFDZCxJQUFJQyxXQUFrQjFFLGdCQUFnQixZQUFZO1FBQ2hEeUUsVUFBVTtBQUNkLFdBQVMsSUFBSUMsV0FBa0IxRSxnQkFBZ0IsUUFBUTtRQUNuRHlFLFVBQVU7QUFDZCxXQUFTLElBQUlDLFdBQWtCMUUsZ0JBQWdCLGNBQWM7UUFDekR5RSxVQUFVO0FBQ1g7SUFDRCxJQUFJckMsTUFBTSw4RkFBOEZxQztJQUN4R2hFLFFBQVFDLElBQUksaUJBQWlCZ0UsV0FBa0IxRTtJQUMvQ3FFLFFBQWVqQztJQUNmRSxZQUFXO1FBQ1Q2QixVQUFVO1FBQ1YxRCxRQUFRQyxJQUFJLDRCQUE0QnlEO0FBQ3pDLFFBQUU7SUFDSDFELFFBQVFDLElBQUksb0JBQW9CMEI7QUFDbEM7O0FDaEZBLElBQUl1QyxpQkFBaUI7O0FBR2R6RSxlQUFlc0I7SUFFbEJtRCxpQkFBaUI7VUFDWEM7QUFDVjs7QUFHQSxTQUFTWDtJQUVMLE9BQU87UUFDSFksWUFBVztRQUNYQyxrQkFBaUI7UUFFakJDLHFCQUFxQjtRQUVyQkMsMkJBQTJCO1FBQzNCQyxZQUFZO1FBQ1pDLG9CQUFtQjs7QUFFM0I7O0FBRUEsT0FBTWxCLFlBQUVBLFlBQVVELGFBQUVBLGVBQWdCRyxhQUNsQyxrQkFDQTFDLE9BQ0F5Qzs7QUFHRixJQUFJa0Isa0JBQWtCLElBQUlDOztBQUMxQixJQUFJQyxvQkFBb0IsSUFBSUM7O0FBRXJCcEYsZUFBZXFGO0lBQ2xCLElBQUlDLFFBQVFqQyxTQUFTUyxXQUFXa0I7SUFDaEMsSUFBSU0sU0FBU0MsZUFBZTFELFFBQVE7UUFDaEM7QUFDSDtJQUNELElBQUkyRCxNQUFNRCxlQUFlRDtJQUN6QixLQUFJSCxrQkFBa0JNLElBQUlELElBQUksV0FBVTtRQUNwQztrQkFDVUUsVUFBaUIsc0JBQXNCO2dCQUNyQ0MsbUJBQW1CO2dCQUNuQkMsYUFBYTtnQkFDYkMsaUJBQWlCQyxPQUFPTixJQUFJOztZQUVyQ0wsa0JBQWtCWSxJQUFJUCxJQUFJLFVBQVM7QUFDckMsVUFBQyxPQUFPeEQ7WUFDTHpCLFFBQVFDLElBQUkseUNBQXlDd0I7QUFDeEQ7QUFDSjtBQUNMOztBQUVBLElBQUl1RCxpQkFBaUI7O0FBRXJCdkYsZUFBZTBFO0lBRVgsSUFBSXZFLFNBQVM7UUFBQ04sVUFBVzJFLFdBQWtCM0U7UUFBU21HLFVBQVc7O0lBQy9ELElBQUlDLG1CQUFtQkMsWUFBbUIsOEJBQThCL0YsUUFBUSxHQUFHLEdBQUcsQ0FBQTtJQUN0RixJQUFJOEYsY0FBY0EsV0FBV0UsaUJBQWlCLFFBQVFGLFdBQVdFLGNBQWN0RSxTQUFTLEdBQUc7UUFDdkZ1RSxrQkFBa0JILFdBQVdFO0FBQ3JDLFdBQVc7UUFDSFosaUJBQWlCO1FBQ2pCekIsV0FBV2EsYUFBYTtRQUN4QmIsV0FBV2MsbUJBQW1CO0FBQ2pDO0FBQ0w7O0FBRUE1RSxlQUFlb0csa0JBQWtCRDtJQUM3QixJQUFJQSxpQkFBaUJBLGNBQWN0RSxTQUFTLEdBQUc7UUFFM0MsSUFBSXdFLFdBQVc7UUFDZixJQUFJQyxJQUFJO2NBQ0ZDO1FBRU4sS0FBSyxJQUFJQyxRQUFRTCxlQUFlO1lBRTVCLElBQUdsQixnQkFBZ0JRLElBQUllLEtBQUssV0FBVTtnQkFDbEM7QUFDSDtZQUNEQSxLQUFLbEIsUUFBUWdCO1lBQ2JFLEtBQUtDLE9BQU87WUFDWkQsS0FBS0Usa0JBQWtCbEMsV0FBa0JsRixjQUFjLElBQUlrSCxLQUFLRyxnQkFBZ0JILEtBQUtJO1lBQ3JGUCxTQUFTUSxLQUFLTDtBQUNqQjtRQUVEMUMsV0FBV2EsYUFBYTBCO1FBQ3hCdkMsV0FBV2MsbUJBQW1CeUIsU0FBU3hFLFNBQVMsSUFBSSxZQUFZO1FBQ2hFMEQsaUJBQWlCYztRQUVqQmhCO0FBQ1IsV0FBVztRQUNIRSxpQkFBaUI7UUFDakJ6QixXQUFXYSxhQUFhO1FBQ3hCYixXQUFXYyxtQkFBbUI7QUFDakM7SUFDRGtDO0FBQ0o7O0FBS0EsU0FBU0E7SUFDTCxJQUFJQyxnQkFBZ0I7SUFDcEIsS0FBSyxJQUFJekIsUUFBUSxHQUFHQSxRQUFRQyxlQUFlMUQsUUFBUXlELFNBQVM7UUFDeEQsSUFBSXhCLFdBQVdrQixzQkFBc0JjLE9BQU9SLFFBQVE7WUFDaER5QixjQUFjRixLQUFLO2dCQUFFSixNQUFROztBQUN6QyxlQUFlO1lBQ0hNLGNBQWNGLEtBQUs7Z0JBQUVKLE1BQVE7O0FBQ2hDO0FBQ0o7SUFDRDNDLFdBQVdnQiw0QkFBNEJpQyxjQUFjbEYsU0FBUyxJQUFJLFlBQVk7SUFDOUVpQyxXQUFXZSxzQkFBc0JrQztBQUNyQzs7QUFFQS9HLGVBQWV1RztJQUNYLElBQUlTLHFCQUFxQkMsS0FBWSxrQkFBaUI7SUFFdEQsSUFBSUQsZ0JBQWdCQSxhQUFhbkYsU0FBUyxHQUFHO1FBRXpDLEtBQUssSUFBSTJFLFFBQVFRLGNBQWM7WUFFM0IvQixnQkFBZ0JpQyxJQUFJVjtBQUN2QjtBQUNKO0FBQ0w7O0FBRUEzQyxZQUFZc0Qsc0JBQXNCbkgsZUFBZ0JzRjtJQUM5QzNCLE1BQU15RCxlQUFlcEMscUJBQXFCYyxPQUFPUjtVQUMzQ0Q7SUFDTnlCO0FBRUo7O0FBR0FqRCxZQUFZd0Qsa0JBQWtCckg7SUFDMUIsSUFBSXNGLFFBQVFqQyxTQUFTUyxXQUFXa0I7SUFFaEMsSUFBSU0sU0FBU0MsZUFBZTFELFFBQVE7UUFDaEM7QUFDSDtJQUNELElBQUkyRCxNQUFNRCxlQUFlRDtJQUN6QixJQUFJRSxJQUFJOEIsVUFBVSxNQUFNO2NBRWRuRCxRQUFlb0QsVUFBVS9CLElBQUk4QjtBQUN0QztVQUNLNUIsVUFBaUIsc0JBQXNCO1FBQ3pCQyxtQkFBbUI7UUFDbkJDLGFBQWE7UUFDYkMsaUJBQWlCQyxPQUFPTixJQUFJOztBQUVwRDs7QUFFQTNCLFlBQVkyRCxtQkFBbUJ4SDtJQUMzQjhELFdBQVdjLG1CQUFtQjtJQUU5QixJQUFJNkMsV0FBVztJQUNmLEtBQUssSUFBSWpCLFFBQVFqQixnQkFBZ0I7UUFFN0JOLGdCQUFnQmlDLElBQUlWLEtBQUs7QUFDNUI7SUFDRHZCLGdCQUFnQnlDLFNBQVMsU0FBU0M7UUFDaENGLFNBQVNaLEtBQUtjO0FBQ3BCO0lBQ0lwQyxpQkFBaUI7SUFDakJ6QixXQUFXYSxhQUFhO1VBRWxCaUQsS0FBWSxrQkFBa0IsMEJBQTBCSDtBQUNsRTs7QUFFTyxTQUFTSTtJQUNaLElBQUlwRCxrQkFBa0IsT0FBTztRQUN6QjtBQUNIO0lBQ0RYLFdBQVdpQixhQUFhO0lBRXhCcUIsa0JBQWtCYjtBQUN0Qjs7QUFFTyxTQUFTdUM7SUFDWixJQUFJckQsa0JBQWtCLE9BQU87UUFDekI7QUFDSDtJQUNEWCxXQUFXaUIsYUFBYTtBQUM1Qjs7QUN0TEEvRSxlQUFlK0gsaUJBQWlCNUg7SUFDOUJJLFFBQVFDLElBQUkseUJBQXlCTCxPQUFPTDtJQUM1QyxJQUFJMEUsV0FBa0IxRSxnQkFBZ0JLLE9BQU9MLGNBQWM7UUFDekQwRSxXQUFrQjFFLGVBQWVLLE9BQU9MO0FBQ3pDO0FBQ0g7O0FBRUEsU0FBU3FELGlCQUFpQnhDO0lBQ3RCcUgsbUJBQXdCckg7QUFDNUI7O0FBRUFYLGVBQWU2SDtJQUNYSTtBQUNKOztBQUVBakksZUFBZThIO0lBQ1hJO0FBQ0o7O0FBRUF0RSxPQUFPbUUsbUJBQW1CQTs7QUFDMUJuRSxPQUFPaUUsYUFBYUE7O0FBQ3BCakUsT0FBT2tFLGdCQUFnQkE7O0FBQ3ZCbEUsT0FBT1QsbUJBQW1CQSJ9
