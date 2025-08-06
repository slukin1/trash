var MAX_DP = 1e6, MAX_POWER = 1e6, NAME = "[big.js] ", INVALID = NAME + "Invalid ", INVALID_DP = INVALID + "decimal places", INVALID_RM = INVALID + "rounding mode", DIV_BY_ZERO = NAME + "Division by zero", P = {}, UNDEFINED = void 0;

function round(x, dp, rm, more) {
    var xc = x.c, i = x.e + dp + 1;
    if (i < xc.length) {
        if (rm === 1) {
            more = xc[i] >= 5;
        } else if (rm === 2) {
            more = xc[i] > 5 || xc[i] == 5 && (more || i < 0 || xc[i + 1] !== UNDEFINED || xc[i - 1] & 1);
        } else if (rm === 3) {
            more = more || !!xc[0];
        } else {
            more = false;
            if (rm !== 0) throw Error(INVALID_RM);
        }
        if (i < 1) {
            xc.length = 1;
            if (more) {
                x.e = -dp;
                xc[0] = 1;
            } else {
                xc[0] = x.e = 0;
            }
        } else {
            xc.length = i--;
            if (more) {
                for (;++xc[i] > 9; ) {
                    xc[i] = 0;
                    if (!i--) {
                        ++x.e;
                        xc.unshift(1);
                    }
                }
            }
            for (i = xc.length; !xc[--i]; ) xc.pop();
        }
    } else if (rm < 0 || rm > 3 || rm !== ~~rm) {
        throw Error(INVALID_RM);
    }
    return x;
}

function stringify(x, id, n, k) {
    var e, s, Big = x.constructor, z = !x.c[0];
    if (n !== UNDEFINED) {
        if (n !== ~~n || n < (id == 3) || n > MAX_DP) {
            throw Error(id == 3 ? INVALID + "precision" : INVALID_DP);
        }
        x = new Big(x);
        n = k - x.e;
        if (x.c.length > ++k) round(x, n, Big.RM);
        if (id == 2) k = x.e + n + 1;
        for (;x.c.length < k; ) x.c.push(0);
    }
    e = x.e;
    s = x.c.join("");
    n = s.length;
    if (id != 2 && (id == 1 || id == 3 && k <= e || e <= Big.NE || e >= Big.PE)) {
        s = s.charAt(0) + (n > 1 ? "." + s.slice(1) : "") + (e < 0 ? "e" : "e+") + e;
    } else if (e < 0) {
        for (;++e; ) s = "0" + s;
        s = "0." + s;
    } else if (e > 0) {
        if (++e > n) for (e -= n; e--; ) s += "0"; else if (e < n) s = s.slice(0, e) + "." + s.slice(e);
    } else if (n > 1) {
        s = s.charAt(0) + "." + s.slice(1);
    }
    return x.s < 0 && (!z || id == 4) ? "-" + s : s;
}

P.abs = function() {
    var x = new this.constructor(this);
    x.s = 1;
    return x;
};

P.cmp = function(y) {
    var isneg, x = this, xc = x.c, yc = (y = new x.constructor(y)).c, i = x.s, j = y.s, k = x.e, l = y.e;
    if (!xc[0] || !yc[0]) return !xc[0] ? !yc[0] ? 0 : -j : i;
    if (i != j) return i;
    isneg = i < 0;
    if (k != l) return k > l ^ isneg ? 1 : -1;
    j = (k = xc.length) < (l = yc.length) ? k : l;
    for (i = -1; ++i < j; ) {
        if (xc[i] != yc[i]) return xc[i] > yc[i] ^ isneg ? 1 : -1;
    }
    return k == l ? 0 : k > l ^ isneg ? 1 : -1;
};

P.div = function(y) {
    var x = this, Big = x.constructor, a = x.c, b = (y = new Big(y)).c, k = x.s == y.s ? 1 : -1, dp = Big.DP;
    if (dp !== ~~dp || dp < 0 || dp > MAX_DP) throw Error(INVALID_DP);
    if (!b[0]) throw Error(DIV_BY_ZERO);
    if (!a[0]) return new Big(k * 0);
    var bl, bt, n, cmp, ri, bz = b.slice(), ai = bl = b.length, al = a.length, r = a.slice(0, bl), rl = r.length, q = y, qc = q.c = [], qi = 0, d = dp + (q.e = x.e - y.e) + 1;
    q.s = k;
    k = d < 0 ? 0 : d;
    bz.unshift(0);
    for (;rl++ < bl; ) r.push(0);
    do {
        for (n = 0; n < 10; n++) {
            if (bl != (rl = r.length)) {
                cmp = bl > rl ? 1 : -1;
            } else {
                for (ri = -1, cmp = 0; ++ri < bl; ) {
                    if (b[ri] != r[ri]) {
                        cmp = b[ri] > r[ri] ? 1 : -1;
                        break;
                    }
                }
            }
            if (cmp < 0) {
                for (bt = rl == bl ? b : bz; rl; ) {
                    if (r[--rl] < bt[rl]) {
                        ri = rl;
                        for (;ri && !r[--ri]; ) r[ri] = 9;
                        --r[ri];
                        r[rl] += 10;
                    }
                    r[rl] -= bt[rl];
                }
                for (;!r[0]; ) r.shift();
            } else {
                break;
            }
        }
        qc[qi++] = cmp ? n : ++n;
        if (r[0] && cmp) r[rl] = a[ai] || 0; else r = [ a[ai] ];
    } while ((ai++ < al || r[0] !== UNDEFINED) && k--);
    if (!qc[0] && qi != 1) {
        qc.shift();
        q.e--;
    }
    if (qi > d) round(q, dp, Big.RM, r[0] !== UNDEFINED);
    return q;
};

P.eq = function(y) {
    return !this.cmp(y);
};

P.gt = function(y) {
    return this.cmp(y) > 0;
};

P.gte = function(y) {
    return this.cmp(y) > -1;
};

P.lt = function(y) {
    return this.cmp(y) < 0;
};

P.lte = function(y) {
    return this.cmp(y) < 1;
};

P.minus = P.sub = function(y) {
    var i, j, t, xlty, x = this, Big = x.constructor, a = x.s, b = (y = new Big(y)).s;
    if (a != b) {
        y.s = -b;
        return x.plus(y);
    }
    var xc = x.c.slice(), xe = x.e, yc = y.c, ye = y.e;
    if (!xc[0] || !yc[0]) {
        return yc[0] ? (y.s = -b, y) : new Big(xc[0] ? x : 0);
    }
    if (a = xe - ye) {
        if (xlty = a < 0) {
            a = -a;
            t = xc;
        } else {
            ye = xe;
            t = yc;
        }
        t.reverse();
        for (b = a; b--; ) t.push(0);
        t.reverse();
    } else {
        j = ((xlty = xc.length < yc.length) ? xc : yc).length;
        for (a = b = 0; b < j; b++) {
            if (xc[b] != yc[b]) {
                xlty = xc[b] < yc[b];
                break;
            }
        }
    }
    if (xlty) {
        t = xc;
        xc = yc;
        yc = t;
        y.s = -y.s;
    }
    if ((b = (j = yc.length) - (i = xc.length)) > 0) for (;b--; ) xc[i++] = 0;
    for (b = i; j > a; ) {
        if (xc[--j] < yc[j]) {
            for (i = j; i && !xc[--i]; ) xc[i] = 9;
            --xc[i];
            xc[j] += 10;
        }
        xc[j] -= yc[j];
    }
    for (;xc[--b] === 0; ) xc.pop();
    for (;xc[0] === 0; ) {
        xc.shift();
        --ye;
    }
    if (!xc[0]) {
        y.s = 1;
        xc = [ ye = 0 ];
    }
    y.c = xc;
    y.e = ye;
    return y;
};

P.mod = function(y) {
    var ygtx, x = this, Big = x.constructor, a = x.s, b = (y = new Big(y)).s;
    if (!y.c[0]) throw Error(DIV_BY_ZERO);
    x.s = y.s = 1;
    ygtx = y.cmp(x) == 1;
    x.s = a;
    y.s = b;
    if (ygtx) return new Big(x);
    a = Big.DP;
    b = Big.RM;
    Big.DP = Big.RM = 0;
    x = x.div(y);
    Big.DP = a;
    Big.RM = b;
    return this.minus(x.times(y));
};

P.plus = P.add = function(y) {
    var t, x = this, Big = x.constructor, a = x.s, b = (y = new Big(y)).s;
    if (a != b) {
        y.s = -b;
        return x.minus(y);
    }
    var xe = x.e, xc = x.c, ye = y.e, yc = y.c;
    if (!xc[0] || !yc[0]) return yc[0] ? y : new Big(xc[0] ? x : a * 0);
    xc = xc.slice();
    if (a = xe - ye) {
        if (a > 0) {
            ye = xe;
            t = yc;
        } else {
            a = -a;
            t = xc;
        }
        t.reverse();
        for (;a--; ) t.push(0);
        t.reverse();
    }
    if (xc.length - yc.length < 0) {
        t = yc;
        yc = xc;
        xc = t;
    }
    a = yc.length;
    for (b = 0; a; xc[a] %= 10) b = (xc[--a] = xc[a] + yc[a] + b) / 10 | 0;
    if (b) {
        xc.unshift(b);
        ++ye;
    }
    for (a = xc.length; xc[--a] === 0; ) xc.pop();
    y.c = xc;
    y.e = ye;
    return y;
};

P.pow = function(n) {
    var x = this, one = new x.constructor(1), y = one, isneg = n < 0;
    if (n !== ~~n || n < -MAX_POWER || n > MAX_POWER) throw Error(INVALID + "exponent");
    if (isneg) n = -n;
    for (;;) {
        if (n & 1) y = y.times(x);
        n >>= 1;
        if (!n) break;
        x = x.times(x);
    }
    return isneg ? one.div(y) : y;
};

P.round = function(dp, rm) {
    var Big = this.constructor;
    if (dp === UNDEFINED) dp = 0; else if (dp !== ~~dp || dp < -MAX_DP || dp > MAX_DP) throw Error(INVALID_DP);
    return round(new Big(this), dp, rm === UNDEFINED ? Big.RM : rm);
};

P.sqrt = function() {
    var r, c, t, x = this, Big = x.constructor, s = x.s, e = x.e, half = new Big(.5);
    if (!x.c[0]) return new Big(x);
    if (s < 0) throw Error(NAME + "No square root");
    s = Math.sqrt(x + "");
    if (s === 0 || s === 1 / 0) {
        c = x.c.join("");
        if (!(c.length + e & 1)) c += "0";
        s = Math.sqrt(c);
        e = ((e + 1) / 2 | 0) - (e < 0 || e & 1);
        r = new Big((s == 1 / 0 ? "1e" : (s = s.toExponential()).slice(0, s.indexOf("e") + 1)) + e);
    } else {
        r = new Big(s);
    }
    e = r.e + (Big.DP += 4);
    do {
        t = r;
        r = half.times(t.plus(x.div(t)));
    } while (t.c.slice(0, e).join("") !== r.c.slice(0, e).join(""));
    return round(r, Big.DP -= 4, Big.RM);
};

P.times = P.mul = function(y) {
    var c, x = this, Big = x.constructor, xc = x.c, yc = (y = new Big(y)).c, a = xc.length, b = yc.length, i = x.e, j = y.e;
    y.s = x.s == y.s ? 1 : -1;
    if (!xc[0] || !yc[0]) return new Big(y.s * 0);
    y.e = i + j;
    if (a < b) {
        c = xc;
        xc = yc;
        yc = c;
        j = a;
        a = b;
        b = j;
    }
    for (c = new Array(j = a + b); j--; ) c[j] = 0;
    for (i = b; i--; ) {
        b = 0;
        for (j = a + i; j > i; ) {
            b = c[j] + yc[i] * xc[j - i - 1] + b;
            c[j--] = b % 10;
            b = b / 10 | 0;
        }
        c[j] = (c[j] + b) % 10;
    }
    if (b) ++y.e; else c.shift();
    for (i = c.length; !c[--i]; ) c.pop();
    y.c = c;
    return y;
};

P.toExponential = function(dp) {
    return stringify(this, 1, dp, dp);
};

P.toFixed = function(dp) {
    return stringify(this, 2, dp, this.e + dp);
};

P.toPrecision = function(sd) {
    return stringify(this, 3, sd, sd - 1);
};

P.toString = function() {
    return stringify(this);
};

P.valueOf = P.toJSON = function() {
    return stringify(this, 4);
};

var clickable = true;

var upColorList;

var downColorList;

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
    linearSwapWsData: {}
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

function getPriceString(priceStr, precision) {
    var priceTemp = priceStr;
    var decimalArr = priceTemp.split(".");
    if (decimalArr.length < 2) {
        priceTemp = parseFloat(priceTemp).toFixed(1);
        decimalArr = priceTemp.split(".");
    }
    const decimalCount = decimalArr[1].length;
    const paddedPriceStr = decimalCount < precision ? priceTemp.padEnd(priceTemp.length + (precision - decimalCount), "0") : parseFloat(priceTemp).toFixed(precision);
    const finalPriceStr = paddedPriceStr.replace(/\d(?=(\d{3})+\.)/g, "$&,");
    return finalPriceStr;
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
    var redColorList = [ "#8C9FAD", "#E94359", "#EE3F34", "#DD281D", "#FFF5F4" ];
    var greenColorList = [ "#8C9FAD", "#00A171", "#139A84", "#0F7665", "#121F25" ];
    if (parseInt(commonData.priceColorType) == 0) {
        upColorList = redColorList;
        downColorList = greenColorList;
    } else {
        upColorList = greenColorList;
        downColorList = redColorList;
    }
}

function moduleDefine(moduleName, startFunction, defaultDataFunction) {
    console.log(`loadModule`, moduleName);
    $data[moduleName] = defaultDataFunction();
    $event[moduleName] = {
        start: startFunction
    };
    return {
        moduleEvent: $event[moduleName],
        moduleData: $data[moduleName]
    };
}

let symbolMap = {};

async function getSpotSymbolModel(symbol) {
    if (symbolMap.hasOwnProperty(symbol)) {
        return symbolMap[symbol];
    }
    const json = await $nativeAPI.getSpotSymbolModel(symbol);
    console.log(`tl -- getSpotSymbolModel==>json==${json}`);
    const response = JSON.parse(json);
    console.log(`tl -- getSpotSymbolModel==>response==${response}`);
    symbolMap[symbol] = response;
    return response;
}

async function handleFavorite$1(symbol, isFavorite) {
    var dict = {
        symbol: symbol,
        isFavorite: isFavorite
    };
    console.log(`tl -- handleFavorite, symbol==${symbol}, isFavorite==${isFavorite}`);
    return await $nativeAPI.handleFavorite(JSON.stringify(dict));
}

function handlePNGIconUrl(baseCurrency) {
    let baseUrl = commonData.webUrl ? commonData.webUrl : "";
    let iconUrl = `${baseUrl}/-/x/hb/p/api/contents/currency/icon_png/${baseCurrency.toLowerCase()}.png`;
    console.log(`tl -- handlePNGIconUrl, iconUrl==${iconUrl}`);
    return iconUrl;
}

var dataLoading = false;

var timerId = 0;

var count = 0;

async function start() {
    await requestDataList();
}

function defaultData() {
    return {
        dataList: [],
        emptyVisible: "invisible",
        listVisible: "invisible",
        refreshStatus: 0,
        showOftenHistory: "gone",
        showNormalHistory: "gone"
    };
}

const {moduleData: moduleData, moduleEvent: moduleEvent} = moduleDefine("klineHistory", start, defaultData);

async function requestDataList() {
    if (dataLoading) {
        console.log("tl -- 正在请求浏览历史列表，不在重复请求");
        return;
    }
    dataLoading = true;
    showLoading(true);
    let listData = await sendRequest("v1/hbg/myhome/symbolView/queryHistory", null);
    dataLoading = false;
    showLoading(false);
    try {
        handleDataWithList(listData);
    } catch (error) {
        console.log(`error :${error}`);
    }
}

function handleDataWithList(listData) {
    moduleData.refreshStatus = "2";
    if (listData != null) {
        if ((listData.oftenHistory == null || listData.oftenHistory.length == 0) && (listData.normalHistory == null || listData.normalHistory.length == 0)) {
            moduleData.emptyVisible = "visible";
            moduleData.listVisible = "invisible";
            console.log("tl -- 111 展示空视图");
            return;
        }
        moduleData.emptyVisible = "gone";
        moduleData.listVisible = "visible";
        moduleData.showNormalHistory = listData.normalHistory.length > 0 ? "visible" : "gone";
        moduleData.showOftenHistory = listData.oftenHistory.length > 0 ? "visible" : "gone";
        console.log("tl -- 222 展示列表");
        listDataConfig(listData.oftenHistory, true);
        listDataConfig(listData.normalHistory, false);
        return;
    } else {
        moduleData.emptyVisible = "visible";
        moduleData.listVisible = "invisible";
        console.log("tl -- 333 展示空视图");
        return;
    }
}

async function listDataConfig(list, isOften) {
    if (list == null) {
        return;
    }
    for (let [index, item] of list.entries()) {
        item.index = index;
        item.type = isOften ? "often" : "normal";
        const symbolModel = await getSpotSymbolModel(item.symbol);
        item.baseCurrency = symbolModel.baseCurrencyDisplayName;
        item.quoteCurrency = symbolModel.quoteCurrencyDisplayName;
        if (item.price == null || item.price.length == 0) {
            item.price = "--";
        } else {
            let newPrice = getPriceString(item.price, symbolModel.tradePricePrecision);
            item.price = newPrice;
        }
        if (item.upAndDown == null || item.upAndDown.length == 0) {
            item.upAndDownText = "--";
            item.upAndDownColor = getPriceColor(0);
        } else {
            if (parseFloat(item.upAndDown) > 0) {
                item.upAndDownText = "+" + (parseFloat(item.upAndDown) * 100).toFixed(2).toString() + "%";
            } else {
                item.upAndDownText = (parseFloat(item.upAndDown) * 100).toFixed(2).toString() + "%";
            }
            item.upAndDownColor = getPriceColor(parseFloat(item.upAndDown));
        }
        item.showAddFavorite = item.isAddFavorite == 1 ? "visible" : "gone";
        item.showUnAddFavorite = item.isAddFavorite == 0 ? "visible" : "gone";
        item.iconUrl = handlePNGIconUrl(symbolModel.baseCurrency);
    }
    if (isOften) {
        moduleData.oftenHistory = list;
    } else {
        moduleData.normalHistory = list;
    }
}

moduleEvent.clickedOftenHistoryItem = function(index) {
    if (index >= moduleData.oftenHistory.length) {
        return;
    }
    gotoKlineDetail(moduleData.oftenHistory[index].symbol);
    console.log(`点击了经常浏览记录,index==${index}`);
};

moduleEvent.clickedNormalHistoryItem = function(index) {
    if (index >= moduleData.normalHistory.length) {
        return;
    }
    gotoKlineDetail(moduleData.normalHistory[index].symbol);
    console.log(`点击了历史浏览记录,index==${index}`);
};

var isClick = false;

function gotoKlineDetail(symbol) {
    if (isClick) {
        console.log(`tl -- 重复点击无效`);
        return;
    }
    isClick = true;
    console.log(`tl -- 防止重复点击，isClick==${isClick}`);
    let url = `holigeit://open/v1?url=ihuobiglobal://m.hbg.com/kline/index?symbol=${symbol}`;
    openURL(url);
    console.log(`打开路由地址==${url}`);
    setTimeout((function() {
        isClick = false;
        console.log(`tl -- 防止重复点击，isClick==${isClick}`);
    }), 2e3);
}

var canClickedFavorite = true;

moduleEvent.clickedOftenHistoryItemFavorite = async function(index) {
    if (!canClickedFavorite) {
        console.log(`添加/删除自选执行中，请稍后再试...`);
        return;
    }
    canClickedFavorite = false;
    canClickedFavorite = await handleFavorite(moduleData.oftenHistory, index);
};

moduleEvent.clickedNormalHistoryItemFavorite = async function(index) {
    if (!canClickedFavorite) {
        console.log(`添加/删除自选执行中，请稍后再试...`);
        return;
    }
    canClickedFavorite = false;
    canClickedFavorite = await handleFavorite(moduleData.normalHistory, index);
};

async function handleFavorite(list, index, isOften) {
    if (index >= list.length) {
        return true;
    }
    let item = list.at(index);
    const ret = await handleFavorite$1(item.symbol, item.isAddFavorite);
    if (0 == ret) {
        return true;
    }
    if (item.isAddFavorite == 1) {
        item.isAddFavorite = 0;
    } else {
        item.isAddFavorite = 1;
    }
    item.showAddFavorite = item.isAddFavorite == 1 ? "visible" : "gone";
    item.showUnAddFavorite = item.isAddFavorite == 0 ? "visible" : "gone";
    await requestDataList();
    return true;
}

moduleEvent.onRefresh = async function(searchWord = null, rankType = null) {
    stopTimer();
    await requestDataList();
    startTimer();
};

moduleEvent.updateData = async function(data) {
    if (data == null || data == {}) {
        return;
    }
    const normalList = moduleData.normalHistory;
    normalList.forEach(((normalItem, index, normalList) => {
        var symbolData = data[normalItem.symbol];
        console.log(`tl -- 订阅回传的数据,symbolData==${JSON.stringify(symbolData)},symbol==${normalItem.symbol}`);
        if (symbolData != null) {
            normalItem.price = symbolData.price;
            if (parseFloat(symbolData.upAndDown) > 0) {
                normalItem.upAndDownText = "+" + parseFloat(symbolData.upAndDown).toFixed(2).toString() + "%";
            } else {
                normalItem.upAndDownText = parseFloat(symbolData.upAndDown).toFixed(2).toString() + "%";
            }
            normalItem.upAndDownColor = getPriceColor(parseFloat(symbolData.upAndDown));
        }
    }));
    moduleData.normalHistory = normalList;
    const oftenList = moduleData.oftenHistory;
    oftenList.forEach(((oftenItem, index, oftenList) => {
        var symbolData = data[oftenItem.symbol];
        if (symbolData != null) {
            oftenItem.price = symbolData.price;
            if (parseFloat(symbolData.upAndDown) > 0) {
                oftenItem.upAndDownText = "+" + parseFloat(symbolData.upAndDown).toFixed(2).toString() + "%";
            } else {
                oftenItem.upAndDownText = parseFloat(symbolData.upAndDown).toFixed(2).toString() + "%";
            }
            oftenItem.upAndDownColor = getPriceColor(parseFloat(symbolData.upAndDown));
        }
    }));
    moduleData.oftenHistory = oftenList;
};

function startTimer() {
    0 == timerId && (timerId = setInterval((() => {
        console.log(`tl ---count==${count}`);
        count = count + 1;
        requestDataList();
    }), 15e3));
}

function stopTimer() {
    console.log(`tl ---stopTimer`);
    clearInterval(timerId), timerId = 0;
}

moduleEvent.onResume = async function() {
    console.log("tl -- onResume");
    requestDataList();
    startTimer();
};

moduleEvent.onStart = async function() {};

moduleEvent.onPause = async function() {};

moduleEvent.onStop = async function() {
    console.log("tl -- onStop");
    stopTimer();
};

moduleEvent.onCreate = async function(eventParams) {
    moduleData.navConfig = getNavConfigString();
};

function getNavConfigString() {
    let nav = {
        titleKey: "n_user_browsing_title",
        left: {
            action: {
                type: "back",
                parameter: ""
            },
            icon: "edge_engine_top_bar_back_normal"
        }
    };
    return nav;
}

let loadingCount = 0;

function showLoading(isShow = true) {
    if (0 != loadingCount++ && isShow) {
        return;
    }
    $nativeAPI.showLoading(isShow ? 1 : 0);
}

function sendCommonConfig(param) {
    sendCommonConfig$1(param);
}

$event.sendCommonConfig = sendCommonConfig;
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWFpbi5qcyIsInNvdXJjZXMiOlsiLi4vLi4vcmVwb3NpdG9yeS9ub2RlX21vZHVsZXMvYmlnLmpzL2JpZy5tanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9jb21tb24uanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9rbGluZUhpc3RvcnkuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9tYWluLmpzIl0sInNvdXJjZXNDb250ZW50IjpbIi8qXHJcbiAqICBiaWcuanMgdjUuMi4yXHJcbiAqICBBIHNtYWxsLCBmYXN0LCBlYXN5LXRvLXVzZSBsaWJyYXJ5IGZvciBhcmJpdHJhcnktcHJlY2lzaW9uIGRlY2ltYWwgYXJpdGhtZXRpYy5cclxuICogIENvcHlyaWdodCAoYykgMjAxOCBNaWNoYWVsIE1jbGF1Z2hsaW4gPE04Y2g4OGxAZ21haWwuY29tPlxyXG4gKiAgaHR0cHM6Ly9naXRodWIuY29tL01pa2VNY2wvYmlnLmpzL0xJQ0VOQ0VcclxuICovXHJcblxyXG5cclxuLyoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqIEVESVRBQkxFIERFRkFVTFRTICoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqL1xyXG5cclxuXHJcbiAgLy8gVGhlIGRlZmF1bHQgdmFsdWVzIGJlbG93IG11c3QgYmUgaW50ZWdlcnMgd2l0aGluIHRoZSBzdGF0ZWQgcmFuZ2VzLlxyXG5cclxuICAvKlxyXG4gICAqIFRoZSBtYXhpbXVtIG51bWJlciBvZiBkZWNpbWFsIHBsYWNlcyAoRFApIG9mIHRoZSByZXN1bHRzIG9mIG9wZXJhdGlvbnMgaW52b2x2aW5nIGRpdmlzaW9uOlxyXG4gICAqIGRpdiBhbmQgc3FydCwgYW5kIHBvdyB3aXRoIG5lZ2F0aXZlIGV4cG9uZW50cy5cclxuICAgKi9cclxudmFyIERQID0gMjAsICAgICAgICAgIC8vIDAgdG8gTUFYX0RQXHJcblxyXG4gIC8qXHJcbiAgICogVGhlIHJvdW5kaW5nIG1vZGUgKFJNKSB1c2VkIHdoZW4gcm91bmRpbmcgdG8gdGhlIGFib3ZlIGRlY2ltYWwgcGxhY2VzLlxyXG4gICAqXHJcbiAgICogIDAgIFRvd2FyZHMgemVybyAoaS5lLiB0cnVuY2F0ZSwgbm8gcm91bmRpbmcpLiAgICAgICAoUk9VTkRfRE9XTilcclxuICAgKiAgMSAgVG8gbmVhcmVzdCBuZWlnaGJvdXIuIElmIGVxdWlkaXN0YW50LCByb3VuZCB1cC4gIChST1VORF9IQUxGX1VQKVxyXG4gICAqICAyICBUbyBuZWFyZXN0IG5laWdoYm91ci4gSWYgZXF1aWRpc3RhbnQsIHRvIGV2ZW4uICAgKFJPVU5EX0hBTEZfRVZFTilcclxuICAgKiAgMyAgQXdheSBmcm9tIHplcm8uICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIChST1VORF9VUClcclxuICAgKi9cclxuICBSTSA9IDEsICAgICAgICAgICAgIC8vIDAsIDEsIDIgb3IgM1xyXG5cclxuICAvLyBUaGUgbWF4aW11bSB2YWx1ZSBvZiBEUCBhbmQgQmlnLkRQLlxyXG4gIE1BWF9EUCA9IDFFNiwgICAgICAgLy8gMCB0byAxMDAwMDAwXHJcblxyXG4gIC8vIFRoZSBtYXhpbXVtIG1hZ25pdHVkZSBvZiB0aGUgZXhwb25lbnQgYXJndW1lbnQgdG8gdGhlIHBvdyBtZXRob2QuXHJcbiAgTUFYX1BPV0VSID0gMUU2LCAgICAvLyAxIHRvIDEwMDAwMDBcclxuXHJcbiAgLypcclxuICAgKiBUaGUgbmVnYXRpdmUgZXhwb25lbnQgKE5FKSBhdCBhbmQgYmVuZWF0aCB3aGljaCB0b1N0cmluZyByZXR1cm5zIGV4cG9uZW50aWFsIG5vdGF0aW9uLlxyXG4gICAqIChKYXZhU2NyaXB0IG51bWJlcnM6IC03KVxyXG4gICAqIC0xMDAwMDAwIGlzIHRoZSBtaW5pbXVtIHJlY29tbWVuZGVkIGV4cG9uZW50IHZhbHVlIG9mIGEgQmlnLlxyXG4gICAqL1xyXG4gIE5FID0gLTcsICAgICAgICAgICAgLy8gMCB0byAtMTAwMDAwMFxyXG5cclxuICAvKlxyXG4gICAqIFRoZSBwb3NpdGl2ZSBleHBvbmVudCAoUEUpIGF0IGFuZCBhYm92ZSB3aGljaCB0b1N0cmluZyByZXR1cm5zIGV4cG9uZW50aWFsIG5vdGF0aW9uLlxyXG4gICAqIChKYXZhU2NyaXB0IG51bWJlcnM6IDIxKVxyXG4gICAqIDEwMDAwMDAgaXMgdGhlIG1heGltdW0gcmVjb21tZW5kZWQgZXhwb25lbnQgdmFsdWUgb2YgYSBCaWcuXHJcbiAgICogKFRoaXMgbGltaXQgaXMgbm90IGVuZm9yY2VkIG9yIGNoZWNrZWQuKVxyXG4gICAqL1xyXG4gIFBFID0gMjEsICAgICAgICAgICAgLy8gMCB0byAxMDAwMDAwXHJcblxyXG5cclxuLyoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqL1xyXG5cclxuXHJcbiAgLy8gRXJyb3IgbWVzc2FnZXMuXHJcbiAgTkFNRSA9ICdbYmlnLmpzXSAnLFxyXG4gIElOVkFMSUQgPSBOQU1FICsgJ0ludmFsaWQgJyxcclxuICBJTlZBTElEX0RQID0gSU5WQUxJRCArICdkZWNpbWFsIHBsYWNlcycsXHJcbiAgSU5WQUxJRF9STSA9IElOVkFMSUQgKyAncm91bmRpbmcgbW9kZScsXHJcbiAgRElWX0JZX1pFUk8gPSBOQU1FICsgJ0RpdmlzaW9uIGJ5IHplcm8nLFxyXG5cclxuICAvLyBUaGUgc2hhcmVkIHByb3RvdHlwZSBvYmplY3QuXHJcbiAgUCA9IHt9LFxyXG4gIFVOREVGSU5FRCA9IHZvaWQgMCxcclxuICBOVU1FUklDID0gL14tPyhcXGQrKFxcLlxcZCopP3xcXC5cXGQrKShlWystXT9cXGQrKT8kL2k7XHJcblxyXG5cclxuLypcclxuICogQ3JlYXRlIGFuZCByZXR1cm4gYSBCaWcgY29uc3RydWN0b3IuXHJcbiAqXHJcbiAqL1xyXG5mdW5jdGlvbiBfQmlnXygpIHtcclxuXHJcbiAgLypcclxuICAgKiBUaGUgQmlnIGNvbnN0cnVjdG9yIGFuZCBleHBvcnRlZCBmdW5jdGlvbi5cclxuICAgKiBDcmVhdGUgYW5kIHJldHVybiBhIG5ldyBpbnN0YW5jZSBvZiBhIEJpZyBudW1iZXIgb2JqZWN0LlxyXG4gICAqXHJcbiAgICogbiB7bnVtYmVyfHN0cmluZ3xCaWd9IEEgbnVtZXJpYyB2YWx1ZS5cclxuICAgKi9cclxuICBmdW5jdGlvbiBCaWcobikge1xyXG4gICAgdmFyIHggPSB0aGlzO1xyXG5cclxuICAgIC8vIEVuYWJsZSBjb25zdHJ1Y3RvciB1c2FnZSB3aXRob3V0IG5ldy5cclxuICAgIGlmICghKHggaW5zdGFuY2VvZiBCaWcpKSByZXR1cm4gbiA9PT0gVU5ERUZJTkVEID8gX0JpZ18oKSA6IG5ldyBCaWcobik7XHJcblxyXG4gICAgLy8gRHVwbGljYXRlLlxyXG4gICAgaWYgKG4gaW5zdGFuY2VvZiBCaWcpIHtcclxuICAgICAgeC5zID0gbi5zO1xyXG4gICAgICB4LmUgPSBuLmU7XHJcbiAgICAgIHguYyA9IG4uYy5zbGljZSgpO1xyXG4gICAgfSBlbHNlIHtcclxuICAgICAgcGFyc2UoeCwgbik7XHJcbiAgICB9XHJcblxyXG4gICAgLypcclxuICAgICAqIFJldGFpbiBhIHJlZmVyZW5jZSB0byB0aGlzIEJpZyBjb25zdHJ1Y3RvciwgYW5kIHNoYWRvdyBCaWcucHJvdG90eXBlLmNvbnN0cnVjdG9yIHdoaWNoXHJcbiAgICAgKiBwb2ludHMgdG8gT2JqZWN0LlxyXG4gICAgICovXHJcbiAgICB4LmNvbnN0cnVjdG9yID0gQmlnO1xyXG4gIH1cclxuXHJcbiAgQmlnLnByb3RvdHlwZSA9IFA7XHJcbiAgQmlnLkRQID0gRFA7XHJcbiAgQmlnLlJNID0gUk07XHJcbiAgQmlnLk5FID0gTkU7XHJcbiAgQmlnLlBFID0gUEU7XHJcbiAgQmlnLnZlcnNpb24gPSAnNS4yLjInO1xyXG5cclxuICByZXR1cm4gQmlnO1xyXG59XHJcblxyXG5cclxuLypcclxuICogUGFyc2UgdGhlIG51bWJlciBvciBzdHJpbmcgdmFsdWUgcGFzc2VkIHRvIGEgQmlnIGNvbnN0cnVjdG9yLlxyXG4gKlxyXG4gKiB4IHtCaWd9IEEgQmlnIG51bWJlciBpbnN0YW5jZS5cclxuICogbiB7bnVtYmVyfHN0cmluZ30gQSBudW1lcmljIHZhbHVlLlxyXG4gKi9cclxuZnVuY3Rpb24gcGFyc2UoeCwgbikge1xyXG4gIHZhciBlLCBpLCBubDtcclxuXHJcbiAgLy8gTWludXMgemVybz9cclxuICBpZiAobiA9PT0gMCAmJiAxIC8gbiA8IDApIG4gPSAnLTAnO1xyXG4gIGVsc2UgaWYgKCFOVU1FUklDLnRlc3QobiArPSAnJykpIHRocm93IEVycm9yKElOVkFMSUQgKyAnbnVtYmVyJyk7XHJcblxyXG4gIC8vIERldGVybWluZSBzaWduLlxyXG4gIHgucyA9IG4uY2hhckF0KDApID09ICctJyA/IChuID0gbi5zbGljZSgxKSwgLTEpIDogMTtcclxuXHJcbiAgLy8gRGVjaW1hbCBwb2ludD9cclxuICBpZiAoKGUgPSBuLmluZGV4T2YoJy4nKSkgPiAtMSkgbiA9IG4ucmVwbGFjZSgnLicsICcnKTtcclxuXHJcbiAgLy8gRXhwb25lbnRpYWwgZm9ybT9cclxuICBpZiAoKGkgPSBuLnNlYXJjaCgvZS9pKSkgPiAwKSB7XHJcblxyXG4gICAgLy8gRGV0ZXJtaW5lIGV4cG9uZW50LlxyXG4gICAgaWYgKGUgPCAwKSBlID0gaTtcclxuICAgIGUgKz0gK24uc2xpY2UoaSArIDEpO1xyXG4gICAgbiA9IG4uc3Vic3RyaW5nKDAsIGkpO1xyXG4gIH0gZWxzZSBpZiAoZSA8IDApIHtcclxuXHJcbiAgICAvLyBJbnRlZ2VyLlxyXG4gICAgZSA9IG4ubGVuZ3RoO1xyXG4gIH1cclxuXHJcbiAgbmwgPSBuLmxlbmd0aDtcclxuXHJcbiAgLy8gRGV0ZXJtaW5lIGxlYWRpbmcgemVyb3MuXHJcbiAgZm9yIChpID0gMDsgaSA8IG5sICYmIG4uY2hhckF0KGkpID09ICcwJzspICsraTtcclxuXHJcbiAgaWYgKGkgPT0gbmwpIHtcclxuXHJcbiAgICAvLyBaZXJvLlxyXG4gICAgeC5jID0gW3guZSA9IDBdO1xyXG4gIH0gZWxzZSB7XHJcblxyXG4gICAgLy8gRGV0ZXJtaW5lIHRyYWlsaW5nIHplcm9zLlxyXG4gICAgZm9yICg7IG5sID4gMCAmJiBuLmNoYXJBdCgtLW5sKSA9PSAnMCc7KTtcclxuICAgIHguZSA9IGUgLSBpIC0gMTtcclxuICAgIHguYyA9IFtdO1xyXG5cclxuICAgIC8vIENvbnZlcnQgc3RyaW5nIHRvIGFycmF5IG9mIGRpZ2l0cyB3aXRob3V0IGxlYWRpbmcvdHJhaWxpbmcgemVyb3MuXHJcbiAgICBmb3IgKGUgPSAwOyBpIDw9IG5sOykgeC5jW2UrK10gPSArbi5jaGFyQXQoaSsrKTtcclxuICB9XHJcblxyXG4gIHJldHVybiB4O1xyXG59XHJcblxyXG5cclxuLypcclxuICogUm91bmQgQmlnIHggdG8gYSBtYXhpbXVtIG9mIGRwIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgcm0uXHJcbiAqIENhbGxlZCBieSBzdHJpbmdpZnksIFAuZGl2LCBQLnJvdW5kIGFuZCBQLnNxcnQuXHJcbiAqXHJcbiAqIHgge0JpZ30gVGhlIEJpZyB0byByb3VuZC5cclxuICogZHAge251bWJlcn0gSW50ZWdlciwgMCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKiBybSB7bnVtYmVyfSAwLCAxLCAyIG9yIDMgKERPV04sIEhBTEZfVVAsIEhBTEZfRVZFTiwgVVApXHJcbiAqIFttb3JlXSB7Ym9vbGVhbn0gV2hldGhlciB0aGUgcmVzdWx0IG9mIGRpdmlzaW9uIHdhcyB0cnVuY2F0ZWQuXHJcbiAqL1xyXG5mdW5jdGlvbiByb3VuZCh4LCBkcCwgcm0sIG1vcmUpIHtcclxuICB2YXIgeGMgPSB4LmMsXHJcbiAgICBpID0geC5lICsgZHAgKyAxO1xyXG5cclxuICBpZiAoaSA8IHhjLmxlbmd0aCkge1xyXG4gICAgaWYgKHJtID09PSAxKSB7XHJcblxyXG4gICAgICAvLyB4Y1tpXSBpcyB0aGUgZGlnaXQgYWZ0ZXIgdGhlIGRpZ2l0IHRoYXQgbWF5IGJlIHJvdW5kZWQgdXAuXHJcbiAgICAgIG1vcmUgPSB4Y1tpXSA+PSA1O1xyXG4gICAgfSBlbHNlIGlmIChybSA9PT0gMikge1xyXG4gICAgICBtb3JlID0geGNbaV0gPiA1IHx8IHhjW2ldID09IDUgJiZcclxuICAgICAgICAobW9yZSB8fCBpIDwgMCB8fCB4Y1tpICsgMV0gIT09IFVOREVGSU5FRCB8fCB4Y1tpIC0gMV0gJiAxKTtcclxuICAgIH0gZWxzZSBpZiAocm0gPT09IDMpIHtcclxuICAgICAgbW9yZSA9IG1vcmUgfHwgISF4Y1swXTtcclxuICAgIH0gZWxzZSB7XHJcbiAgICAgIG1vcmUgPSBmYWxzZTtcclxuICAgICAgaWYgKHJtICE9PSAwKSB0aHJvdyBFcnJvcihJTlZBTElEX1JNKTtcclxuICAgIH1cclxuXHJcbiAgICBpZiAoaSA8IDEpIHtcclxuICAgICAgeGMubGVuZ3RoID0gMTtcclxuXHJcbiAgICAgIGlmIChtb3JlKSB7XHJcblxyXG4gICAgICAgIC8vIDEsIDAuMSwgMC4wMSwgMC4wMDEsIDAuMDAwMSBldGMuXHJcbiAgICAgICAgeC5lID0gLWRwO1xyXG4gICAgICAgIHhjWzBdID0gMTtcclxuICAgICAgfSBlbHNlIHtcclxuXHJcbiAgICAgICAgLy8gWmVyby5cclxuICAgICAgICB4Y1swXSA9IHguZSA9IDA7XHJcbiAgICAgIH1cclxuICAgIH0gZWxzZSB7XHJcblxyXG4gICAgICAvLyBSZW1vdmUgYW55IGRpZ2l0cyBhZnRlciB0aGUgcmVxdWlyZWQgZGVjaW1hbCBwbGFjZXMuXHJcbiAgICAgIHhjLmxlbmd0aCA9IGktLTtcclxuXHJcbiAgICAgIC8vIFJvdW5kIHVwP1xyXG4gICAgICBpZiAobW9yZSkge1xyXG5cclxuICAgICAgICAvLyBSb3VuZGluZyB1cCBtYXkgbWVhbiB0aGUgcHJldmlvdXMgZGlnaXQgaGFzIHRvIGJlIHJvdW5kZWQgdXAuXHJcbiAgICAgICAgZm9yICg7ICsreGNbaV0gPiA5Oykge1xyXG4gICAgICAgICAgeGNbaV0gPSAwO1xyXG4gICAgICAgICAgaWYgKCFpLS0pIHtcclxuICAgICAgICAgICAgKyt4LmU7XHJcbiAgICAgICAgICAgIHhjLnVuc2hpZnQoMSk7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgfVxyXG4gICAgICB9XHJcblxyXG4gICAgICAvLyBSZW1vdmUgdHJhaWxpbmcgemVyb3MuXHJcbiAgICAgIGZvciAoaSA9IHhjLmxlbmd0aDsgIXhjWy0taV07KSB4Yy5wb3AoKTtcclxuICAgIH1cclxuICB9IGVsc2UgaWYgKHJtIDwgMCB8fCBybSA+IDMgfHwgcm0gIT09IH5+cm0pIHtcclxuICAgIHRocm93IEVycm9yKElOVkFMSURfUk0pO1xyXG4gIH1cclxuXHJcbiAgcmV0dXJuIHg7XHJcbn1cclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBzdHJpbmcgcmVwcmVzZW50aW5nIHRoZSB2YWx1ZSBvZiBCaWcgeCBpbiBub3JtYWwgb3IgZXhwb25lbnRpYWwgbm90YXRpb24uXHJcbiAqIEhhbmRsZXMgUC50b0V4cG9uZW50aWFsLCBQLnRvRml4ZWQsIFAudG9KU09OLCBQLnRvUHJlY2lzaW9uLCBQLnRvU3RyaW5nIGFuZCBQLnZhbHVlT2YuXHJcbiAqXHJcbiAqIHgge0JpZ31cclxuICogaWQ/IHtudW1iZXJ9IENhbGxlciBpZC5cclxuICogICAgICAgICAxIHRvRXhwb25lbnRpYWxcclxuICogICAgICAgICAyIHRvRml4ZWRcclxuICogICAgICAgICAzIHRvUHJlY2lzaW9uXHJcbiAqICAgICAgICAgNCB2YWx1ZU9mXHJcbiAqIG4/IHtudW1iZXJ8dW5kZWZpbmVkfSBDYWxsZXIncyBhcmd1bWVudC5cclxuICogaz8ge251bWJlcnx1bmRlZmluZWR9XHJcbiAqL1xyXG5mdW5jdGlvbiBzdHJpbmdpZnkoeCwgaWQsIG4sIGspIHtcclxuICB2YXIgZSwgcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICB6ID0gIXguY1swXTtcclxuXHJcbiAgaWYgKG4gIT09IFVOREVGSU5FRCkge1xyXG4gICAgaWYgKG4gIT09IH5+biB8fCBuIDwgKGlkID09IDMpIHx8IG4gPiBNQVhfRFApIHtcclxuICAgICAgdGhyb3cgRXJyb3IoaWQgPT0gMyA/IElOVkFMSUQgKyAncHJlY2lzaW9uJyA6IElOVkFMSURfRFApO1xyXG4gICAgfVxyXG5cclxuICAgIHggPSBuZXcgQmlnKHgpO1xyXG5cclxuICAgIC8vIFRoZSBpbmRleCBvZiB0aGUgZGlnaXQgdGhhdCBtYXkgYmUgcm91bmRlZCB1cC5cclxuICAgIG4gPSBrIC0geC5lO1xyXG5cclxuICAgIC8vIFJvdW5kP1xyXG4gICAgaWYgKHguYy5sZW5ndGggPiArK2spIHJvdW5kKHgsIG4sIEJpZy5STSk7XHJcblxyXG4gICAgLy8gdG9GaXhlZDogcmVjYWxjdWxhdGUgayBhcyB4LmUgbWF5IGhhdmUgY2hhbmdlZCBpZiB2YWx1ZSByb3VuZGVkIHVwLlxyXG4gICAgaWYgKGlkID09IDIpIGsgPSB4LmUgKyBuICsgMTtcclxuXHJcbiAgICAvLyBBcHBlbmQgemVyb3M/XHJcbiAgICBmb3IgKDsgeC5jLmxlbmd0aCA8IGs7KSB4LmMucHVzaCgwKTtcclxuICB9XHJcblxyXG4gIGUgPSB4LmU7XHJcbiAgcyA9IHguYy5qb2luKCcnKTtcclxuICBuID0gcy5sZW5ndGg7XHJcblxyXG4gIC8vIEV4cG9uZW50aWFsIG5vdGF0aW9uP1xyXG4gIGlmIChpZCAhPSAyICYmIChpZCA9PSAxIHx8IGlkID09IDMgJiYgayA8PSBlIHx8IGUgPD0gQmlnLk5FIHx8IGUgPj0gQmlnLlBFKSkge1xyXG4gICAgcyA9IHMuY2hhckF0KDApICsgKG4gPiAxID8gJy4nICsgcy5zbGljZSgxKSA6ICcnKSArIChlIDwgMCA/ICdlJyA6ICdlKycpICsgZTtcclxuXHJcbiAgLy8gTm9ybWFsIG5vdGF0aW9uLlxyXG4gIH0gZWxzZSBpZiAoZSA8IDApIHtcclxuICAgIGZvciAoOyArK2U7KSBzID0gJzAnICsgcztcclxuICAgIHMgPSAnMC4nICsgcztcclxuICB9IGVsc2UgaWYgKGUgPiAwKSB7XHJcbiAgICBpZiAoKytlID4gbikgZm9yIChlIC09IG47IGUtLTspIHMgKz0gJzAnO1xyXG4gICAgZWxzZSBpZiAoZSA8IG4pIHMgPSBzLnNsaWNlKDAsIGUpICsgJy4nICsgcy5zbGljZShlKTtcclxuICB9IGVsc2UgaWYgKG4gPiAxKSB7XHJcbiAgICBzID0gcy5jaGFyQXQoMCkgKyAnLicgKyBzLnNsaWNlKDEpO1xyXG4gIH1cclxuXHJcbiAgcmV0dXJuIHgucyA8IDAgJiYgKCF6IHx8IGlkID09IDQpID8gJy0nICsgcyA6IHM7XHJcbn1cclxuXHJcblxyXG4vLyBQcm90b3R5cGUvaW5zdGFuY2UgbWV0aG9kc1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIGFic29sdXRlIHZhbHVlIG9mIHRoaXMgQmlnLlxyXG4gKi9cclxuUC5hYnMgPSBmdW5jdGlvbiAoKSB7XHJcbiAgdmFyIHggPSBuZXcgdGhpcy5jb25zdHJ1Y3Rvcih0aGlzKTtcclxuICB4LnMgPSAxO1xyXG4gIHJldHVybiB4O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiAxIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBncmVhdGVyIHRoYW4gdGhlIHZhbHVlIG9mIEJpZyB5LFxyXG4gKiAgICAgICAtMSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgbGVzcyB0aGFuIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3JcclxuICogICAgICAgIDAgaWYgdGhleSBoYXZlIHRoZSBzYW1lIHZhbHVlLlxyXG4qL1xyXG5QLmNtcCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIGlzbmVnLFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICB4YyA9IHguYyxcclxuICAgIHljID0gKHkgPSBuZXcgeC5jb25zdHJ1Y3Rvcih5KSkuYyxcclxuICAgIGkgPSB4LnMsXHJcbiAgICBqID0geS5zLFxyXG4gICAgayA9IHguZSxcclxuICAgIGwgPSB5LmU7XHJcblxyXG4gIC8vIEVpdGhlciB6ZXJvP1xyXG4gIGlmICgheGNbMF0gfHwgIXljWzBdKSByZXR1cm4gIXhjWzBdID8gIXljWzBdID8gMCA6IC1qIDogaTtcclxuXHJcbiAgLy8gU2lnbnMgZGlmZmVyP1xyXG4gIGlmIChpICE9IGopIHJldHVybiBpO1xyXG5cclxuICBpc25lZyA9IGkgPCAwO1xyXG5cclxuICAvLyBDb21wYXJlIGV4cG9uZW50cy5cclxuICBpZiAoayAhPSBsKSByZXR1cm4gayA+IGwgXiBpc25lZyA/IDEgOiAtMTtcclxuXHJcbiAgaiA9IChrID0geGMubGVuZ3RoKSA8IChsID0geWMubGVuZ3RoKSA/IGsgOiBsO1xyXG5cclxuICAvLyBDb21wYXJlIGRpZ2l0IGJ5IGRpZ2l0LlxyXG4gIGZvciAoaSA9IC0xOyArK2kgPCBqOykge1xyXG4gICAgaWYgKHhjW2ldICE9IHljW2ldKSByZXR1cm4geGNbaV0gPiB5Y1tpXSBeIGlzbmVnID8gMSA6IC0xO1xyXG4gIH1cclxuXHJcbiAgLy8gQ29tcGFyZSBsZW5ndGhzLlxyXG4gIHJldHVybiBrID09IGwgPyAwIDogayA+IGwgXiBpc25lZyA/IDEgOiAtMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBkaXZpZGVkIGJ5IHRoZSB2YWx1ZSBvZiBCaWcgeSwgcm91bmRlZCxcclxuICogaWYgbmVjZXNzYXJ5LCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgQmlnLlJNLlxyXG4gKi9cclxuUC5kaXYgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5jLCAgICAgICAgICAgICAgICAgIC8vIGRpdmlkZW5kXHJcbiAgICBiID0gKHkgPSBuZXcgQmlnKHkpKS5jLCAgIC8vIGRpdmlzb3JcclxuICAgIGsgPSB4LnMgPT0geS5zID8gMSA6IC0xLFxyXG4gICAgZHAgPSBCaWcuRFA7XHJcblxyXG4gIGlmIChkcCAhPT0gfn5kcCB8fCBkcCA8IDAgfHwgZHAgPiBNQVhfRFApIHRocm93IEVycm9yKElOVkFMSURfRFApO1xyXG5cclxuICAvLyBEaXZpc29yIGlzIHplcm8/XHJcbiAgaWYgKCFiWzBdKSB0aHJvdyBFcnJvcihESVZfQllfWkVSTyk7XHJcblxyXG4gIC8vIERpdmlkZW5kIGlzIDA/IFJldHVybiArLTAuXHJcbiAgaWYgKCFhWzBdKSByZXR1cm4gbmV3IEJpZyhrICogMCk7XHJcblxyXG4gIHZhciBibCwgYnQsIG4sIGNtcCwgcmksXHJcbiAgICBieiA9IGIuc2xpY2UoKSxcclxuICAgIGFpID0gYmwgPSBiLmxlbmd0aCxcclxuICAgIGFsID0gYS5sZW5ndGgsXHJcbiAgICByID0gYS5zbGljZSgwLCBibCksICAgLy8gcmVtYWluZGVyXHJcbiAgICBybCA9IHIubGVuZ3RoLFxyXG4gICAgcSA9IHksICAgICAgICAgICAgICAgIC8vIHF1b3RpZW50XHJcbiAgICBxYyA9IHEuYyA9IFtdLFxyXG4gICAgcWkgPSAwLFxyXG4gICAgZCA9IGRwICsgKHEuZSA9IHguZSAtIHkuZSkgKyAxOyAgICAvLyBudW1iZXIgb2YgZGlnaXRzIG9mIHRoZSByZXN1bHRcclxuXHJcbiAgcS5zID0gaztcclxuICBrID0gZCA8IDAgPyAwIDogZDtcclxuXHJcbiAgLy8gQ3JlYXRlIHZlcnNpb24gb2YgZGl2aXNvciB3aXRoIGxlYWRpbmcgemVyby5cclxuICBiei51bnNoaWZ0KDApO1xyXG5cclxuICAvLyBBZGQgemVyb3MgdG8gbWFrZSByZW1haW5kZXIgYXMgbG9uZyBhcyBkaXZpc29yLlxyXG4gIGZvciAoOyBybCsrIDwgYmw7KSByLnB1c2goMCk7XHJcblxyXG4gIGRvIHtcclxuXHJcbiAgICAvLyBuIGlzIGhvdyBtYW55IHRpbWVzIHRoZSBkaXZpc29yIGdvZXMgaW50byBjdXJyZW50IHJlbWFpbmRlci5cclxuICAgIGZvciAobiA9IDA7IG4gPCAxMDsgbisrKSB7XHJcblxyXG4gICAgICAvLyBDb21wYXJlIGRpdmlzb3IgYW5kIHJlbWFpbmRlci5cclxuICAgICAgaWYgKGJsICE9IChybCA9IHIubGVuZ3RoKSkge1xyXG4gICAgICAgIGNtcCA9IGJsID4gcmwgPyAxIDogLTE7XHJcbiAgICAgIH0gZWxzZSB7XHJcbiAgICAgICAgZm9yIChyaSA9IC0xLCBjbXAgPSAwOyArK3JpIDwgYmw7KSB7XHJcbiAgICAgICAgICBpZiAoYltyaV0gIT0gcltyaV0pIHtcclxuICAgICAgICAgICAgY21wID0gYltyaV0gPiByW3JpXSA/IDEgOiAtMTtcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgfVxyXG4gICAgICB9XHJcblxyXG4gICAgICAvLyBJZiBkaXZpc29yIDwgcmVtYWluZGVyLCBzdWJ0cmFjdCBkaXZpc29yIGZyb20gcmVtYWluZGVyLlxyXG4gICAgICBpZiAoY21wIDwgMCkge1xyXG5cclxuICAgICAgICAvLyBSZW1haW5kZXIgY2FuJ3QgYmUgbW9yZSB0aGFuIDEgZGlnaXQgbG9uZ2VyIHRoYW4gZGl2aXNvci5cclxuICAgICAgICAvLyBFcXVhbGlzZSBsZW5ndGhzIHVzaW5nIGRpdmlzb3Igd2l0aCBleHRyYSBsZWFkaW5nIHplcm8/XHJcbiAgICAgICAgZm9yIChidCA9IHJsID09IGJsID8gYiA6IGJ6OyBybDspIHtcclxuICAgICAgICAgIGlmIChyWy0tcmxdIDwgYnRbcmxdKSB7XHJcbiAgICAgICAgICAgIHJpID0gcmw7XHJcbiAgICAgICAgICAgIGZvciAoOyByaSAmJiAhclstLXJpXTspIHJbcmldID0gOTtcclxuICAgICAgICAgICAgLS1yW3JpXTtcclxuICAgICAgICAgICAgcltybF0gKz0gMTA7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgICByW3JsXSAtPSBidFtybF07XHJcbiAgICAgICAgfVxyXG5cclxuICAgICAgICBmb3IgKDsgIXJbMF07KSByLnNoaWZ0KCk7XHJcbiAgICAgIH0gZWxzZSB7XHJcbiAgICAgICAgYnJlYWs7XHJcbiAgICAgIH1cclxuICAgIH1cclxuXHJcbiAgICAvLyBBZGQgdGhlIGRpZ2l0IG4gdG8gdGhlIHJlc3VsdCBhcnJheS5cclxuICAgIHFjW3FpKytdID0gY21wID8gbiA6ICsrbjtcclxuXHJcbiAgICAvLyBVcGRhdGUgdGhlIHJlbWFpbmRlci5cclxuICAgIGlmIChyWzBdICYmIGNtcCkgcltybF0gPSBhW2FpXSB8fCAwO1xyXG4gICAgZWxzZSByID0gW2FbYWldXTtcclxuXHJcbiAgfSB3aGlsZSAoKGFpKysgPCBhbCB8fCByWzBdICE9PSBVTkRFRklORUQpICYmIGstLSk7XHJcblxyXG4gIC8vIExlYWRpbmcgemVybz8gRG8gbm90IHJlbW92ZSBpZiByZXN1bHQgaXMgc2ltcGx5IHplcm8gKHFpID09IDEpLlxyXG4gIGlmICghcWNbMF0gJiYgcWkgIT0gMSkge1xyXG5cclxuICAgIC8vIFRoZXJlIGNhbid0IGJlIG1vcmUgdGhhbiBvbmUgemVyby5cclxuICAgIHFjLnNoaWZ0KCk7XHJcbiAgICBxLmUtLTtcclxuICB9XHJcblxyXG4gIC8vIFJvdW5kP1xyXG4gIGlmIChxaSA+IGQpIHJvdW5kKHEsIGRwLCBCaWcuUk0sIHJbMF0gIT09IFVOREVGSU5FRCk7XHJcblxyXG4gIHJldHVybiBxO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiB0cnVlIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBlcXVhbCB0byB0aGUgdmFsdWUgb2YgQmlnIHksIG90aGVyd2lzZSByZXR1cm4gZmFsc2UuXHJcbiAqL1xyXG5QLmVxID0gZnVuY3Rpb24gKHkpIHtcclxuICByZXR1cm4gIXRoaXMuY21wKHkpO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiB0cnVlIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBncmVhdGVyIHRoYW4gdGhlIHZhbHVlIG9mIEJpZyB5LCBvdGhlcndpc2UgcmV0dXJuXHJcbiAqIGZhbHNlLlxyXG4gKi9cclxuUC5ndCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgcmV0dXJuIHRoaXMuY21wKHkpID4gMDtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gdHJ1ZSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgZ3JlYXRlciB0aGFuIG9yIGVxdWFsIHRvIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3RoZXJ3aXNlXHJcbiAqIHJldHVybiBmYWxzZS5cclxuICovXHJcblAuZ3RlID0gZnVuY3Rpb24gKHkpIHtcclxuICByZXR1cm4gdGhpcy5jbXAoeSkgPiAtMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gdHJ1ZSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgbGVzcyB0aGFuIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3RoZXJ3aXNlIHJldHVybiBmYWxzZS5cclxuICovXHJcblAubHQgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHJldHVybiB0aGlzLmNtcCh5KSA8IDA7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIHRydWUgaWYgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGlzIGxlc3MgdGhhbiBvciBlcXVhbCB0byB0aGUgdmFsdWUgb2YgQmlnIHksIG90aGVyd2lzZVxyXG4gKiByZXR1cm4gZmFsc2UuXHJcbiAqL1xyXG5QLmx0ZSA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgcmV0dXJuIHRoaXMuY21wKHkpIDwgMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBtaW51cyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLm1pbnVzID0gUC5zdWIgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciBpLCBqLCB0LCB4bHR5LFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgYSA9IHgucyxcclxuICAgIGIgPSAoeSA9IG5ldyBCaWcoeSkpLnM7XHJcblxyXG4gIC8vIFNpZ25zIGRpZmZlcj9cclxuICBpZiAoYSAhPSBiKSB7XHJcbiAgICB5LnMgPSAtYjtcclxuICAgIHJldHVybiB4LnBsdXMoeSk7XHJcbiAgfVxyXG5cclxuICB2YXIgeGMgPSB4LmMuc2xpY2UoKSxcclxuICAgIHhlID0geC5lLFxyXG4gICAgeWMgPSB5LmMsXHJcbiAgICB5ZSA9IHkuZTtcclxuXHJcbiAgLy8gRWl0aGVyIHplcm8/XHJcbiAgaWYgKCF4Y1swXSB8fCAheWNbMF0pIHtcclxuXHJcbiAgICAvLyB5IGlzIG5vbi16ZXJvPyB4IGlzIG5vbi16ZXJvPyBPciBib3RoIGFyZSB6ZXJvLlxyXG4gICAgcmV0dXJuIHljWzBdID8gKHkucyA9IC1iLCB5KSA6IG5ldyBCaWcoeGNbMF0gPyB4IDogMCk7XHJcbiAgfVxyXG5cclxuICAvLyBEZXRlcm1pbmUgd2hpY2ggaXMgdGhlIGJpZ2dlciBudW1iZXIuIFByZXBlbmQgemVyb3MgdG8gZXF1YWxpc2UgZXhwb25lbnRzLlxyXG4gIGlmIChhID0geGUgLSB5ZSkge1xyXG5cclxuICAgIGlmICh4bHR5ID0gYSA8IDApIHtcclxuICAgICAgYSA9IC1hO1xyXG4gICAgICB0ID0geGM7XHJcbiAgICB9IGVsc2Uge1xyXG4gICAgICB5ZSA9IHhlO1xyXG4gICAgICB0ID0geWM7XHJcbiAgICB9XHJcblxyXG4gICAgdC5yZXZlcnNlKCk7XHJcbiAgICBmb3IgKGIgPSBhOyBiLS07KSB0LnB1c2goMCk7XHJcbiAgICB0LnJldmVyc2UoKTtcclxuICB9IGVsc2Uge1xyXG5cclxuICAgIC8vIEV4cG9uZW50cyBlcXVhbC4gQ2hlY2sgZGlnaXQgYnkgZGlnaXQuXHJcbiAgICBqID0gKCh4bHR5ID0geGMubGVuZ3RoIDwgeWMubGVuZ3RoKSA/IHhjIDogeWMpLmxlbmd0aDtcclxuXHJcbiAgICBmb3IgKGEgPSBiID0gMDsgYiA8IGo7IGIrKykge1xyXG4gICAgICBpZiAoeGNbYl0gIT0geWNbYl0pIHtcclxuICAgICAgICB4bHR5ID0geGNbYl0gPCB5Y1tiXTtcclxuICAgICAgICBicmVhaztcclxuICAgICAgfVxyXG4gICAgfVxyXG4gIH1cclxuXHJcbiAgLy8geCA8IHk/IFBvaW50IHhjIHRvIHRoZSBhcnJheSBvZiB0aGUgYmlnZ2VyIG51bWJlci5cclxuICBpZiAoeGx0eSkge1xyXG4gICAgdCA9IHhjO1xyXG4gICAgeGMgPSB5YztcclxuICAgIHljID0gdDtcclxuICAgIHkucyA9IC15LnM7XHJcbiAgfVxyXG5cclxuICAvKlxyXG4gICAqIEFwcGVuZCB6ZXJvcyB0byB4YyBpZiBzaG9ydGVyLiBObyBuZWVkIHRvIGFkZCB6ZXJvcyB0byB5YyBpZiBzaG9ydGVyIGFzIHN1YnRyYWN0aW9uIG9ubHlcclxuICAgKiBuZWVkcyB0byBzdGFydCBhdCB5Yy5sZW5ndGguXHJcbiAgICovXHJcbiAgaWYgKChiID0gKGogPSB5Yy5sZW5ndGgpIC0gKGkgPSB4Yy5sZW5ndGgpKSA+IDApIGZvciAoOyBiLS07KSB4Y1tpKytdID0gMDtcclxuXHJcbiAgLy8gU3VidHJhY3QgeWMgZnJvbSB4Yy5cclxuICBmb3IgKGIgPSBpOyBqID4gYTspIHtcclxuICAgIGlmICh4Y1stLWpdIDwgeWNbal0pIHtcclxuICAgICAgZm9yIChpID0gajsgaSAmJiAheGNbLS1pXTspIHhjW2ldID0gOTtcclxuICAgICAgLS14Y1tpXTtcclxuICAgICAgeGNbal0gKz0gMTA7XHJcbiAgICB9XHJcblxyXG4gICAgeGNbal0gLT0geWNbal07XHJcbiAgfVxyXG5cclxuICAvLyBSZW1vdmUgdHJhaWxpbmcgemVyb3MuXHJcbiAgZm9yICg7IHhjWy0tYl0gPT09IDA7KSB4Yy5wb3AoKTtcclxuXHJcbiAgLy8gUmVtb3ZlIGxlYWRpbmcgemVyb3MgYW5kIGFkanVzdCBleHBvbmVudCBhY2NvcmRpbmdseS5cclxuICBmb3IgKDsgeGNbMF0gPT09IDA7KSB7XHJcbiAgICB4Yy5zaGlmdCgpO1xyXG4gICAgLS15ZTtcclxuICB9XHJcblxyXG4gIGlmICgheGNbMF0pIHtcclxuXHJcbiAgICAvLyBuIC0gbiA9ICswXHJcbiAgICB5LnMgPSAxO1xyXG5cclxuICAgIC8vIFJlc3VsdCBtdXN0IGJlIHplcm8uXHJcbiAgICB4YyA9IFt5ZSA9IDBdO1xyXG4gIH1cclxuXHJcbiAgeS5jID0geGM7XHJcbiAgeS5lID0geWU7XHJcblxyXG4gIHJldHVybiB5O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIG1vZHVsbyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLm1vZCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIHlndHgsXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5zLFxyXG4gICAgYiA9ICh5ID0gbmV3IEJpZyh5KSkucztcclxuXHJcbiAgaWYgKCF5LmNbMF0pIHRocm93IEVycm9yKERJVl9CWV9aRVJPKTtcclxuXHJcbiAgeC5zID0geS5zID0gMTtcclxuICB5Z3R4ID0geS5jbXAoeCkgPT0gMTtcclxuICB4LnMgPSBhO1xyXG4gIHkucyA9IGI7XHJcblxyXG4gIGlmICh5Z3R4KSByZXR1cm4gbmV3IEJpZyh4KTtcclxuXHJcbiAgYSA9IEJpZy5EUDtcclxuICBiID0gQmlnLlJNO1xyXG4gIEJpZy5EUCA9IEJpZy5STSA9IDA7XHJcbiAgeCA9IHguZGl2KHkpO1xyXG4gIEJpZy5EUCA9IGE7XHJcbiAgQmlnLlJNID0gYjtcclxuXHJcbiAgcmV0dXJuIHRoaXMubWludXMoeC50aW1lcyh5KSk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgbmV3IEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgcGx1cyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLnBsdXMgPSBQLmFkZCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIHQsXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5zLFxyXG4gICAgYiA9ICh5ID0gbmV3IEJpZyh5KSkucztcclxuXHJcbiAgLy8gU2lnbnMgZGlmZmVyP1xyXG4gIGlmIChhICE9IGIpIHtcclxuICAgIHkucyA9IC1iO1xyXG4gICAgcmV0dXJuIHgubWludXMoeSk7XHJcbiAgfVxyXG5cclxuICB2YXIgeGUgPSB4LmUsXHJcbiAgICB4YyA9IHguYyxcclxuICAgIHllID0geS5lLFxyXG4gICAgeWMgPSB5LmM7XHJcblxyXG4gIC8vIEVpdGhlciB6ZXJvPyB5IGlzIG5vbi16ZXJvPyB4IGlzIG5vbi16ZXJvPyBPciBib3RoIGFyZSB6ZXJvLlxyXG4gIGlmICgheGNbMF0gfHwgIXljWzBdKSByZXR1cm4geWNbMF0gPyB5IDogbmV3IEJpZyh4Y1swXSA/IHggOiBhICogMCk7XHJcblxyXG4gIHhjID0geGMuc2xpY2UoKTtcclxuXHJcbiAgLy8gUHJlcGVuZCB6ZXJvcyB0byBlcXVhbGlzZSBleHBvbmVudHMuXHJcbiAgLy8gTm90ZTogcmV2ZXJzZSBmYXN0ZXIgdGhhbiB1bnNoaWZ0cy5cclxuICBpZiAoYSA9IHhlIC0geWUpIHtcclxuICAgIGlmIChhID4gMCkge1xyXG4gICAgICB5ZSA9IHhlO1xyXG4gICAgICB0ID0geWM7XHJcbiAgICB9IGVsc2Uge1xyXG4gICAgICBhID0gLWE7XHJcbiAgICAgIHQgPSB4YztcclxuICAgIH1cclxuXHJcbiAgICB0LnJldmVyc2UoKTtcclxuICAgIGZvciAoOyBhLS07KSB0LnB1c2goMCk7XHJcbiAgICB0LnJldmVyc2UoKTtcclxuICB9XHJcblxyXG4gIC8vIFBvaW50IHhjIHRvIHRoZSBsb25nZXIgYXJyYXkuXHJcbiAgaWYgKHhjLmxlbmd0aCAtIHljLmxlbmd0aCA8IDApIHtcclxuICAgIHQgPSB5YztcclxuICAgIHljID0geGM7XHJcbiAgICB4YyA9IHQ7XHJcbiAgfVxyXG5cclxuICBhID0geWMubGVuZ3RoO1xyXG5cclxuICAvLyBPbmx5IHN0YXJ0IGFkZGluZyBhdCB5Yy5sZW5ndGggLSAxIGFzIHRoZSBmdXJ0aGVyIGRpZ2l0cyBvZiB4YyBjYW4gYmUgbGVmdCBhcyB0aGV5IGFyZS5cclxuICBmb3IgKGIgPSAwOyBhOyB4Y1thXSAlPSAxMCkgYiA9ICh4Y1stLWFdID0geGNbYV0gKyB5Y1thXSArIGIpIC8gMTAgfCAwO1xyXG5cclxuICAvLyBObyBuZWVkIHRvIGNoZWNrIGZvciB6ZXJvLCBhcyAreCArICt5ICE9IDAgJiYgLXggKyAteSAhPSAwXHJcblxyXG4gIGlmIChiKSB7XHJcbiAgICB4Yy51bnNoaWZ0KGIpO1xyXG4gICAgKyt5ZTtcclxuICB9XHJcblxyXG4gIC8vIFJlbW92ZSB0cmFpbGluZyB6ZXJvcy5cclxuICBmb3IgKGEgPSB4Yy5sZW5ndGg7IHhjWy0tYV0gPT09IDA7KSB4Yy5wb3AoKTtcclxuXHJcbiAgeS5jID0geGM7XHJcbiAgeS5lID0geWU7XHJcblxyXG4gIHJldHVybiB5O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgcmFpc2VkIHRvIHRoZSBwb3dlciBuLlxyXG4gKiBJZiBuIGlzIG5lZ2F0aXZlLCByb3VuZCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nXHJcbiAqIG1vZGUgQmlnLlJNLlxyXG4gKlxyXG4gKiBuIHtudW1iZXJ9IEludGVnZXIsIC1NQVhfUE9XRVIgdG8gTUFYX1BPV0VSIGluY2x1c2l2ZS5cclxuICovXHJcblAucG93ID0gZnVuY3Rpb24gKG4pIHtcclxuICB2YXIgeCA9IHRoaXMsXHJcbiAgICBvbmUgPSBuZXcgeC5jb25zdHJ1Y3RvcigxKSxcclxuICAgIHkgPSBvbmUsXHJcbiAgICBpc25lZyA9IG4gPCAwO1xyXG5cclxuICBpZiAobiAhPT0gfn5uIHx8IG4gPCAtTUFYX1BPV0VSIHx8IG4gPiBNQVhfUE9XRVIpIHRocm93IEVycm9yKElOVkFMSUQgKyAnZXhwb25lbnQnKTtcclxuICBpZiAoaXNuZWcpIG4gPSAtbjtcclxuXHJcbiAgZm9yICg7Oykge1xyXG4gICAgaWYgKG4gJiAxKSB5ID0geS50aW1lcyh4KTtcclxuICAgIG4gPj49IDE7XHJcbiAgICBpZiAoIW4pIGJyZWFrO1xyXG4gICAgeCA9IHgudGltZXMoeCk7XHJcbiAgfVxyXG5cclxuICByZXR1cm4gaXNuZWcgPyBvbmUuZGl2KHkpIDogeTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyByb3VuZGVkIHVzaW5nIHJvdW5kaW5nIG1vZGUgcm1cclxuICogdG8gYSBtYXhpbXVtIG9mIGRwIGRlY2ltYWwgcGxhY2VzLCBvciwgaWYgZHAgaXMgbmVnYXRpdmUsIHRvIGFuIGludGVnZXIgd2hpY2ggaXMgYVxyXG4gKiBtdWx0aXBsZSBvZiAxMCoqLWRwLlxyXG4gKiBJZiBkcCBpcyBub3Qgc3BlY2lmaWVkLCByb3VuZCB0byAwIGRlY2ltYWwgcGxhY2VzLlxyXG4gKiBJZiBybSBpcyBub3Qgc3BlY2lmaWVkLCB1c2UgQmlnLlJNLlxyXG4gKlxyXG4gKiBkcD8ge251bWJlcn0gSW50ZWdlciwgLU1BWF9EUCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKiBybT8gMCwgMSwgMiBvciAzIChST1VORF9ET1dOLCBST1VORF9IQUxGX1VQLCBST1VORF9IQUxGX0VWRU4sIFJPVU5EX1VQKVxyXG4gKi9cclxuUC5yb3VuZCA9IGZ1bmN0aW9uIChkcCwgcm0pIHtcclxuICB2YXIgQmlnID0gdGhpcy5jb25zdHJ1Y3RvcjtcclxuICBpZiAoZHAgPT09IFVOREVGSU5FRCkgZHAgPSAwO1xyXG4gIGVsc2UgaWYgKGRwICE9PSB+fmRwIHx8IGRwIDwgLU1BWF9EUCB8fCBkcCA+IE1BWF9EUCkgdGhyb3cgRXJyb3IoSU5WQUxJRF9EUCk7XHJcbiAgcmV0dXJuIHJvdW5kKG5ldyBCaWcodGhpcyksIGRwLCBybSA9PT0gVU5ERUZJTkVEID8gQmlnLlJNIDogcm0pO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHNxdWFyZSByb290IG9mIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZywgcm91bmRlZCwgaWZcclxuICogbmVjZXNzYXJ5LCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgQmlnLlJNLlxyXG4gKi9cclxuUC5zcXJ0ID0gZnVuY3Rpb24gKCkge1xyXG4gIHZhciByLCBjLCB0LFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgcyA9IHgucyxcclxuICAgIGUgPSB4LmUsXHJcbiAgICBoYWxmID0gbmV3IEJpZygwLjUpO1xyXG5cclxuICAvLyBaZXJvP1xyXG4gIGlmICgheC5jWzBdKSByZXR1cm4gbmV3IEJpZyh4KTtcclxuXHJcbiAgLy8gTmVnYXRpdmU/XHJcbiAgaWYgKHMgPCAwKSB0aHJvdyBFcnJvcihOQU1FICsgJ05vIHNxdWFyZSByb290Jyk7XHJcblxyXG4gIC8vIEVzdGltYXRlLlxyXG4gIHMgPSBNYXRoLnNxcnQoeCArICcnKTtcclxuXHJcbiAgLy8gTWF0aC5zcXJ0IHVuZGVyZmxvdy9vdmVyZmxvdz9cclxuICAvLyBSZS1lc3RpbWF0ZTogcGFzcyB4IGNvZWZmaWNpZW50IHRvIE1hdGguc3FydCBhcyBpbnRlZ2VyLCB0aGVuIGFkanVzdCB0aGUgcmVzdWx0IGV4cG9uZW50LlxyXG4gIGlmIChzID09PSAwIHx8IHMgPT09IDEgLyAwKSB7XHJcbiAgICBjID0geC5jLmpvaW4oJycpO1xyXG4gICAgaWYgKCEoYy5sZW5ndGggKyBlICYgMSkpIGMgKz0gJzAnO1xyXG4gICAgcyA9IE1hdGguc3FydChjKTtcclxuICAgIGUgPSAoKGUgKyAxKSAvIDIgfCAwKSAtIChlIDwgMCB8fCBlICYgMSk7XHJcbiAgICByID0gbmV3IEJpZygocyA9PSAxIC8gMCA/ICcxZScgOiAocyA9IHMudG9FeHBvbmVudGlhbCgpKS5zbGljZSgwLCBzLmluZGV4T2YoJ2UnKSArIDEpKSArIGUpO1xyXG4gIH0gZWxzZSB7XHJcbiAgICByID0gbmV3IEJpZyhzKTtcclxuICB9XHJcblxyXG4gIGUgPSByLmUgKyAoQmlnLkRQICs9IDQpO1xyXG5cclxuICAvLyBOZXd0b24tUmFwaHNvbiBpdGVyYXRpb24uXHJcbiAgZG8ge1xyXG4gICAgdCA9IHI7XHJcbiAgICByID0gaGFsZi50aW1lcyh0LnBsdXMoeC5kaXYodCkpKTtcclxuICB9IHdoaWxlICh0LmMuc2xpY2UoMCwgZSkuam9pbignJykgIT09IHIuYy5zbGljZSgwLCBlKS5qb2luKCcnKSk7XHJcblxyXG4gIHJldHVybiByb3VuZChyLCBCaWcuRFAgLT0gNCwgQmlnLlJNKTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyB0aW1lcyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLnRpbWVzID0gUC5tdWwgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciBjLFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgeGMgPSB4LmMsXHJcbiAgICB5YyA9ICh5ID0gbmV3IEJpZyh5KSkuYyxcclxuICAgIGEgPSB4Yy5sZW5ndGgsXHJcbiAgICBiID0geWMubGVuZ3RoLFxyXG4gICAgaSA9IHguZSxcclxuICAgIGogPSB5LmU7XHJcblxyXG4gIC8vIERldGVybWluZSBzaWduIG9mIHJlc3VsdC5cclxuICB5LnMgPSB4LnMgPT0geS5zID8gMSA6IC0xO1xyXG5cclxuICAvLyBSZXR1cm4gc2lnbmVkIDAgaWYgZWl0aGVyIDAuXHJcbiAgaWYgKCF4Y1swXSB8fCAheWNbMF0pIHJldHVybiBuZXcgQmlnKHkucyAqIDApO1xyXG5cclxuICAvLyBJbml0aWFsaXNlIGV4cG9uZW50IG9mIHJlc3VsdCBhcyB4LmUgKyB5LmUuXHJcbiAgeS5lID0gaSArIGo7XHJcblxyXG4gIC8vIElmIGFycmF5IHhjIGhhcyBmZXdlciBkaWdpdHMgdGhhbiB5Yywgc3dhcCB4YyBhbmQgeWMsIGFuZCBsZW5ndGhzLlxyXG4gIGlmIChhIDwgYikge1xyXG4gICAgYyA9IHhjO1xyXG4gICAgeGMgPSB5YztcclxuICAgIHljID0gYztcclxuICAgIGogPSBhO1xyXG4gICAgYSA9IGI7XHJcbiAgICBiID0gajtcclxuICB9XHJcblxyXG4gIC8vIEluaXRpYWxpc2UgY29lZmZpY2llbnQgYXJyYXkgb2YgcmVzdWx0IHdpdGggemVyb3MuXHJcbiAgZm9yIChjID0gbmV3IEFycmF5KGogPSBhICsgYik7IGotLTspIGNbal0gPSAwO1xyXG5cclxuICAvLyBNdWx0aXBseS5cclxuXHJcbiAgLy8gaSBpcyBpbml0aWFsbHkgeGMubGVuZ3RoLlxyXG4gIGZvciAoaSA9IGI7IGktLTspIHtcclxuICAgIGIgPSAwO1xyXG5cclxuICAgIC8vIGEgaXMgeWMubGVuZ3RoLlxyXG4gICAgZm9yIChqID0gYSArIGk7IGogPiBpOykge1xyXG5cclxuICAgICAgLy8gQ3VycmVudCBzdW0gb2YgcHJvZHVjdHMgYXQgdGhpcyBkaWdpdCBwb3NpdGlvbiwgcGx1cyBjYXJyeS5cclxuICAgICAgYiA9IGNbal0gKyB5Y1tpXSAqIHhjW2ogLSBpIC0gMV0gKyBiO1xyXG4gICAgICBjW2otLV0gPSBiICUgMTA7XHJcblxyXG4gICAgICAvLyBjYXJyeVxyXG4gICAgICBiID0gYiAvIDEwIHwgMDtcclxuICAgIH1cclxuXHJcbiAgICBjW2pdID0gKGNbal0gKyBiKSAlIDEwO1xyXG4gIH1cclxuXHJcbiAgLy8gSW5jcmVtZW50IHJlc3VsdCBleHBvbmVudCBpZiB0aGVyZSBpcyBhIGZpbmFsIGNhcnJ5LCBvdGhlcndpc2UgcmVtb3ZlIGxlYWRpbmcgemVyby5cclxuICBpZiAoYikgKyt5LmU7XHJcbiAgZWxzZSBjLnNoaWZ0KCk7XHJcblxyXG4gIC8vIFJlbW92ZSB0cmFpbGluZyB6ZXJvcy5cclxuICBmb3IgKGkgPSBjLmxlbmd0aDsgIWNbLS1pXTspIGMucG9wKCk7XHJcbiAgeS5jID0gYztcclxuXHJcbiAgcmV0dXJuIHk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaW4gZXhwb25lbnRpYWwgbm90YXRpb24gdG8gZHAgZml4ZWQgZGVjaW1hbFxyXG4gKiBwbGFjZXMgYW5kIHJvdW5kZWQgdXNpbmcgQmlnLlJNLlxyXG4gKlxyXG4gKiBkcD8ge251bWJlcn0gSW50ZWdlciwgMCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKi9cclxuUC50b0V4cG9uZW50aWFsID0gZnVuY3Rpb24gKGRwKSB7XHJcbiAgcmV0dXJuIHN0cmluZ2lmeSh0aGlzLCAxLCBkcCwgZHApO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIHN0cmluZyByZXByZXNlbnRpbmcgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGluIG5vcm1hbCBub3RhdGlvbiB0byBkcCBmaXhlZCBkZWNpbWFsXHJcbiAqIHBsYWNlcyBhbmQgcm91bmRlZCB1c2luZyBCaWcuUk0uXHJcbiAqXHJcbiAqIGRwPyB7bnVtYmVyfSBJbnRlZ2VyLCAwIHRvIE1BWF9EUCBpbmNsdXNpdmUuXHJcbiAqXHJcbiAqICgtMCkudG9GaXhlZCgwKSBpcyAnMCcsIGJ1dCAoLTAuMSkudG9GaXhlZCgwKSBpcyAnLTAnLlxyXG4gKiAoLTApLnRvRml4ZWQoMSkgaXMgJzAuMCcsIGJ1dCAoLTAuMDEpLnRvRml4ZWQoMSkgaXMgJy0wLjAnLlxyXG4gKi9cclxuUC50b0ZpeGVkID0gZnVuY3Rpb24gKGRwKSB7XHJcbiAgcmV0dXJuIHN0cmluZ2lmeSh0aGlzLCAyLCBkcCwgdGhpcy5lICsgZHApO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIHN0cmluZyByZXByZXNlbnRpbmcgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIHJvdW5kZWQgdG8gc2Qgc2lnbmlmaWNhbnQgZGlnaXRzIHVzaW5nXHJcbiAqIEJpZy5STS4gVXNlIGV4cG9uZW50aWFsIG5vdGF0aW9uIGlmIHNkIGlzIGxlc3MgdGhhbiB0aGUgbnVtYmVyIG9mIGRpZ2l0cyBuZWNlc3NhcnkgdG8gcmVwcmVzZW50XHJcbiAqIHRoZSBpbnRlZ2VyIHBhcnQgb2YgdGhlIHZhbHVlIGluIG5vcm1hbCBub3RhdGlvbi5cclxuICpcclxuICogc2Qge251bWJlcn0gSW50ZWdlciwgMSB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKi9cclxuUC50b1ByZWNpc2lvbiA9IGZ1bmN0aW9uIChzZCkge1xyXG4gIHJldHVybiBzdHJpbmdpZnkodGhpcywgMywgc2QsIHNkIC0gMSk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcuXHJcbiAqIFJldHVybiBleHBvbmVudGlhbCBub3RhdGlvbiBpZiB0aGlzIEJpZyBoYXMgYSBwb3NpdGl2ZSBleHBvbmVudCBlcXVhbCB0byBvciBncmVhdGVyIHRoYW5cclxuICogQmlnLlBFLCBvciBhIG5lZ2F0aXZlIGV4cG9uZW50IGVxdWFsIHRvIG9yIGxlc3MgdGhhbiBCaWcuTkUuXHJcbiAqIE9taXQgdGhlIHNpZ24gZm9yIG5lZ2F0aXZlIHplcm8uXHJcbiAqL1xyXG5QLnRvU3RyaW5nID0gZnVuY3Rpb24gKCkge1xyXG4gIHJldHVybiBzdHJpbmdpZnkodGhpcyk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcuXHJcbiAqIFJldHVybiBleHBvbmVudGlhbCBub3RhdGlvbiBpZiB0aGlzIEJpZyBoYXMgYSBwb3NpdGl2ZSBleHBvbmVudCBlcXVhbCB0byBvciBncmVhdGVyIHRoYW5cclxuICogQmlnLlBFLCBvciBhIG5lZ2F0aXZlIGV4cG9uZW50IGVxdWFsIHRvIG9yIGxlc3MgdGhhbiBCaWcuTkUuXHJcbiAqIEluY2x1ZGUgdGhlIHNpZ24gZm9yIG5lZ2F0aXZlIHplcm8uXHJcbiAqL1xyXG5QLnZhbHVlT2YgPSBQLnRvSlNPTiA9IGZ1bmN0aW9uICgpIHtcclxuICByZXR1cm4gc3RyaW5naWZ5KHRoaXMsIDQpO1xyXG59O1xyXG5cclxuXHJcbi8vIEV4cG9ydFxyXG5cclxuXHJcbmV4cG9ydCB2YXIgQmlnID0gX0JpZ18oKTtcclxuXHJcbmV4cG9ydCBkZWZhdWx0IEJpZztcclxuIiwiaW1wb3J0ICogYXMgbnVtYmVyIGZyb20gXCIuL251bWJlclwiO1xuXG52YXIgY2xpY2thYmxlID0gdHJ1ZTtcblxuLy8g6aKc6Imy6YWN572uIDA657qi5rao57u/6LeMIOaIliAxOue7v+a2qOe6oui3jFxudmFyIHVwQ29sb3JMaXN0O1xudmFyIGRvd25Db2xvckxpc3Q7XG5cbi8qKlxuICogQHR5cGVkZWYge09iamVjdH0gQ29tbW9uRGF0YVxuICogQHByb3BlcnR5IHtudW1iZXJ9IHByaWNlQ29sb3JUeXBlICAgIC0g5Lu35qC85rao6LeM5bmF6aKc6Imy6K6+572uXG4gKiBAcHJvcGVydHkge251bWJlcn0gY29sb3JNb2RlICAgICAgICAgLSDnmb3lpKnpu5HlpJzmqKHlvI9cbiAqIEBwcm9wZXJ0eSB7c3RyaW5nfSBsYW5ndWFnZSAgICAgICAgICAtIOivreenjemFjee9rlxuICogQHByb3BlcnR5IHtzdHJpbmd9IE9TICAgICAgICAgICAgICAgIC0g57O757ufXG4gKiBAcHJvcGVydHkge3N0cmluZ30gYXBwVmVyc2lvbiAgICAgICAgLSDniYjmnKzlj7dcbiAqIEBwcm9wZXJ0eSB7bnVtYmVyfSBpc0luUmV2aWV3ICAgICAgICAtIGlPU+WuoeaguOeKtuaAgVxuICogQHByb3BlcnR5IHtudW1iZXJ9IGlzTG9naW4gICAgICAgICAgIC0g5piv5ZCm55m75b2VXG4gKiBAcHJvcGVydHkge29iamVjdH0gbGluZWFyU3dhcFdzRGF0YSAgLSBV5pys5L2N5ZCI57qm6K6i6ZiF5L+h5oGvXG4gKi9cblxuLyoqIEB0eXBlIENvbW1vbkRhdGEgKi9cbmV4cG9ydCB2YXIgY29tbW9uRGF0YSA9IHtcbiAgdXNlclNpZ246IFwiXCIsIC8vLyDnlKjmiLfmoIfor4ZcbiAgY3VycmVudFN5bWJvbDogXCJCVEMtVVNEVFwiLCAvLy/lvZPliY3nmoTlkIjnuqblk4Hnp41cbiAgY3VycmVudENvbnRyYWN0SW5mbzoge30sIC8vL+W9k+WJjeeahOWQiOe6puWTgeenjeaVsOaNrlxuICBjb250cmFjdEluZm9EYXRhOiBbXSwgLy8vbGluZWFyLXN3YXAtb3JkZXIveC92MS9saW5lYXJfc3dhcF9jb250cmFjdF9pbmZvP2J1c2luZXNzX3R5cGU9YWxsJnRyYWRlX3BhcnRpdGlvbj1hbGzjgIDmjqXlj6Pov5Tlm57nmoTmiYDmnInlkIjnuqblk4Hnp43mlbDmja5cbiAgY29udHJhY3RINVVybDogXCJcIiwgLy8v5ZCI57qmSDXlnLDlnYBcbiAgY3VycmVuY3lSYXRlOiBcIjYuNFwiLCAvLy/nvo7lhYPlr7nlhbblroPms5XluIHnmoTmsYfnjodcbiAgY3VycmVuY3lDaGFyYWN0ZXI6IFwiQ05ZXCIsIC8vL+azleW4geespuWPt1xuICBwcmljZUNvbG9yVHlwZTogMCwgLy8vMO+8mue6oua2qOe7v+i3jCAgIDHvvJrnu7/mtqjnuqLot4xcbiAgY29sb3JNb2RlOiAwLCAvLy8w77ya55m95aSpICAgMe+8mum7keWknFxuICBPUzogMCwgLy8w77yaaU9TICAx77ya5a6J5Y2TXG4gIGFwcFZlcnNpb246IFwiXCIsIC8vYXBw54mI5pys5Y+3XG4gIGlzSW5SZXZpZXc6IDEsXG4gIGlzTG9naW46IDAsXG4gIHdlYlVybDogXCJcIiwgLy8vIGg15Yqo5oCB5Z+f5ZCNXG4gIGxhbmd1YWdlOiBcIlwiLCAvLy8g6K+t6KiA56eN57G7XG4gIGxpbmVhclN3YXBXc0RhdGE6IHt9LFxufTtcblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHN1YldlYlNvY2tldCh0eXBlKSB7XG4gIGF3YWl0ICRuYXRpdmVBUEkuaGFuZGxlU29ja2V0KHtcbiAgICBhY3Rpb246IFwic3ViV2ViU29ja2V0XCIsXG4gICAgdHlwZTogdHlwZSxcbiAgfSk7XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiB1blN1YldlYlNvY2tldCh0eXBlKSB7XG4gIGF3YWl0ICRuYXRpdmVBUEkuaGFuZGxlU29ja2V0KHtcbiAgICBhY3Rpb246IFwidW5TdWJXZWJTb2NrZXRcIixcbiAgICB0eXBlOiB0eXBlLFxuICB9KTtcbn1cblxuLy/lj5HpgIHor7fmsYJcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzZW5kUmVxdWVzdChwYXRoLCBwYXJhbXMgPSB7fSwgbWV0aG9kID0gMCwgaG9zdFR5cGUgPSAwLCBoZWFkZXIgPSB7fSkge1xuICBjb25zb2xlLmxvZyhgcmVxdWVzdCAke3BhdGh9LCBwYXJhbXM6JHtKU09OLnN0cmluZ2lmeShwYXJhbXMpfWApO1xuXG4gIGlmIChob3N0VHlwZSA9PSA1IHx8IGhvc3RUeXBlID09IDYpIHtcbiAgICBoZWFkZXJbXCJDb250ZW50LVR5cGVcIl0gPSBcImFwcGxpY2F0aW9uL2pzb25cIjtcbiAgfVxuXG4gIGNvbnN0IHBhcmFtID0ge1xuICAgIHBhdGgsXG4gICAgbWV0aG9kLFxuICAgIGhvc3RUeXBlLFxuICAgIGhlYWRlcixcbiAgICBwYXJhbXMsXG4gIH07XG4gIHRyeSB7XG4gICAgdmFyIHJlc3BvbnNlU3RyaW5nID0gYXdhaXQgJG5hdGl2ZUFQSS5yZXF1ZXN0KEpTT04uc3RyaW5naWZ5KHBhcmFtKSk7XG4gICAgdmFyIHJlc3BvbnNlID0gSlNPTi5wYXJzZShyZXNwb25zZVN0cmluZyk7XG4gICAgdmFyIHsgY29kZSwgZGF0YSB9ID0gcmVzcG9uc2U7XG4gICAgaWYgKDggPT0gaG9zdFR5cGUpIHtcbiAgICAgIC8v5ZCI57qm55qE5o6l5Y+j5aSE55CGXG4gICAgICB2YXIgc3RhdHVzID0gcmVzcG9uc2Uuc3RhdHVzO1xuICAgICAgdmFyIGVycl9jb2RlID0gcmVzcG9uc2UuZXJyX2NvZGU7XG4gICAgICB2YXIgZXJyX21zZyA9IHJlc3BvbnNlLmVycl9tc2c7XG4gICAgICBpZiAoc3RhdHVzID09IFwib2tcIikge1xuICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCAke3BhdGh9IGRvbmVgKTtcbiAgICAgICAgaWYgKHR5cGVvZiBkYXRhID09PSAnbnVtYmVyJykge1xuICAgICAgICAgIGxldCBzdGFydCA9IGBcImRhdGFcIjpgO1xuICAgICAgICAgIGxldCBzdGFydEluZGV4ID0gcmVzcG9uc2VTdHJpbmcuaW5kZXhPZihzdGFydCk7XG4gICAgICAgICAgbGV0IGVuZCA9IGAsXCJ0c1wiOmA7XG4gICAgICAgICAgbGV0IGVuZEluZGV4ID0gcmVzcG9uc2VTdHJpbmcuaW5kZXhPZihlbmQpO1xuICAgICAgICAgIGxldCBkYXRhU3RyaW5nID0gcmVzcG9uc2VTdHJpbmcuc3Vic3RyaW5nKHN0YXJ0SW5kZXggKyBzdGFydC5sZW5ndGgsIGVuZEluZGV4KTtcbiAgICAgICAgICBjb25zb2xlLmxvZyhgZGF0YSBpcyB0eXBlb2YgbnVtYmVyLCBkYXRhU3RyaW5nID0gJHtkYXRhU3RyaW5nfWApO1xuICAgICAgICAgIHJldHVybiBkYXRhU3RyaW5nO1xuICAgICAgICB9XG4gICAgICAgIHJldHVybiBkYXRhO1xuICAgICAgfSBlbHNlIHtcbiAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgZmFpbGVkLCBjb2RlPSR7ZXJyX2NvZGV9LCBtZXNzYWdlPSR7ZXJyX21zZ31gKTtcbiAgICAgICAgaWYgKG1ldGhvZCAhPSAwKSB7XG4gICAgICAgICAgc2hvd1RvYXN0KGVycl9tc2cpO1xuICAgICAgICB9XG4gICAgICAgIHJldHVybiBudWxsO1xuICAgICAgfVxuICAgIH0gZWxzZSBpZiAoY29kZSA9PSAyMDApIHtcbiAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0ICR7cGF0aH0gZG9uZWApO1xuICAgICAgcmV0dXJuIGRhdGE7XG4gICAgfSBlbHNlIHtcbiAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0IGZhaWxlZCwgY29kZT0ke2NvZGV9YCk7XG4gICAgICBsZXQgbWVzc2FnZSA9IHJlc3BvbnNlLm1lc3NhZ2U7XG4gICAgICBpZiAobWV0aG9kICE9IDAgJiYgbWVzc2FnZSkge1xuICAgICAgICBzaG93VG9hc3QobWVzc2FnZSk7XG4gICAgICB9XG4gICAgICByZXR1cm4gbnVsbDtcbiAgICB9XG4gIH0gY2F0Y2ggKGUpIHtcbiAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCBlcnJvciwgZXJyb3I9JHtlfWApO1xuICAgIHJldHVybiBudWxsO1xuICB9XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzZW5kUmVxdWVzdFdpdGhDYWNoZShcbiAgcGF0aCxcbiAgY2FsbGJhY2ssXG4gIHBhcmFtcyA9IHt9LFxuICBtZXRob2QgPSAwLFxuICBob3N0VHlwZSA9IDAsXG4gIGhlYWRlciA9IHt9LFxuICBjYWNoZUtleUxpc3QgPSBudWxsXG4pIHtcbiAgdmFyIGNhY2hlS2V5ID0gZ2V0Q2FjaGVLZXkocGF0aCwgcGFyYW1zLCBjYWNoZUtleUxpc3QpO1xuICBjb25zdCBjYWNoZSA9IGF3YWl0IHJlYWQoXCJhcGlDYWNoZVwiLCBjYWNoZUtleSk7XG4gIGlmIChjYWNoZSAmJiBjYWxsYmFjaykge1xuICAgIGNhbGxiYWNrKGNhY2hlLCB0cnVlKTtcbiAgfVxuICBjb25zdCByZXF1ZXN0RGF0YSA9IGF3YWl0IHNlbmRSZXF1ZXN0KHBhdGgsIHBhcmFtcywgbWV0aG9kLCBob3N0VHlwZSwgaGVhZGVyKTtcbiAgYXdhaXQgc2F2ZShcImFwaUNhY2hlXCIsIGNhY2hlS2V5LCByZXF1ZXN0RGF0YSk7XG4gIGlmIChyZXF1ZXN0RGF0YSAmJiBjYWxsYmFjaykge1xuICAgIGNhbGxiYWNrKHJlcXVlc3REYXRhLCBmYWxzZSk7XG4gIH1cbiAgcmV0dXJuIHJlcXVlc3REYXRhO1xufVxuXG5mdW5jdGlvbiBnZXRDYWNoZUtleShwYXRoLCBwYXJhbXMsIGNhY2hlS2V5TGlzdCA9IG51bGwpIHtcbiAgdmFyIGNhY2hlS2V5ID0gXCJcIjtcbiAgaWYgKGNhY2hlS2V5TGlzdCA9PSBudWxsKSB7XG4gICAgLy9udWxs77ya5omA5pyJ5Y+C5pWw5L2c5Li657yT5a2Y5Y+C5pWwXG4gICAgdmFyIHBhcmFtU3RyID0gSlNPTi5zdHJpbmdpZnkocGFyYW1zKTtcbiAgICBjYWNoZUtleSA9IGAke3BhdGh9XyR7cGFyYW1TdHJ9XyR7Y29tbW9uRGF0YS5sYW5ndWFnZX1fJHtjb21tb25EYXRhLmNvbG9yTW9kZX1fJHtjb21tb25EYXRhLmlzTG9naW59YDtcbiAgfSBlbHNlIGlmIChjYWNoZUtleUxpc3QubGVuZ3RoID09IDApIHtcbiAgICAvLyBbXSAs5Liq5pWw5Li6MO+8muS4jemcgOimgeWPguaVsOS9nOS4uue8k+WtmOWPguaVsFxuICAgIGNhY2hlS2V5ID0gYCR7cGF0aH1fJHtjb21tb25EYXRhLmxhbmd1YWdlfV8ke2NvbW1vbkRhdGEuY29sb3JNb2RlfV8ke2NvbW1vbkRhdGEuaXNMb2dpbn1gO1xuICB9IGVsc2Uge1xuICAgIHZhciBjYWNoZUtleUxpc3RTdHIgPSBjYWNoZUtleUxpc3Quam9pbihcIl9cIik7XG4gICAgY2FjaGVLZXkgPSBgJHtwYXRofV8ke2NhY2hlS2V5TGlzdFN0cn1fJHtjb21tb25EYXRhLmxhbmd1YWdlfV8ke2NvbW1vbkRhdGEuY29sb3JNb2RlfV8ke2NvbW1vbkRhdGEuaXNMb2dpbn1gO1xuICB9XG4gIHJldHVybiBjYWNoZUtleTtcbn1cblxuLy/moLnmja7mtqjot4zluYXojrflj5bmmL7npLrpopzoibJcbmV4cG9ydCBmdW5jdGlvbiBnZXRQcmljZUNvbG9yKHJhdGlvKSB7XG4gIC8vIGNvbnNvbGUubG9nKCdnZXRQcmljZUNvbG9yJyk7XG4gIGlmIChyYXRpbyA9PSBudWxsKSB7XG4gICAgcmF0aW8gPSAwO1xuICB9XG4gIGNvbnN0IHJhdGlvX2FicyA9IE1hdGguYWJzKHJhdGlvKTtcbiAgdmFyIGNvbG9yTGV2ZWwgPSAwO1xuICBpZiAocmF0aW9fYWJzID4gMCAmJiByYXRpb19hYnMgPCAzKSB7XG4gICAgY29sb3JMZXZlbCA9IDE7XG4gIH0gZWxzZSBpZiAocmF0aW9fYWJzID49IDMgJiYgcmF0aW9fYWJzIDwgOCkge1xuICAgIGNvbG9yTGV2ZWwgPSAyO1xuICB9IGVsc2UgaWYgKHJhdGlvX2FicyA+PSA4KSB7XG4gICAgY29sb3JMZXZlbCA9IDM7XG4gIH1cbiAgdmFyIGNvbG9ySGV4U3RyID0gbnVsbDtcbiAgaWYgKHJhdGlvID4gMCkge1xuICAgIGNvbG9ySGV4U3RyID0gdXBDb2xvckxpc3RbY29sb3JMZXZlbF07XG4gIH0gZWxzZSB7XG4gICAgY29sb3JIZXhTdHIgPSBkb3duQ29sb3JMaXN0W2NvbG9yTGV2ZWxdO1xuICB9XG4gIHJldHVybiBjb2xvckhleFN0cjtcbn1cblxuLy/ojrflj5bku7fmoLzmmL7npLrmlofmnKxcbmV4cG9ydCBmdW5jdGlvbiBnZXRQcmljZVN0cmluZyhwcmljZVN0ciwgcHJlY2lzaW9uKSB7XG4gIHZhciBwcmljZVRlbXAgPSBwcmljZVN0cjtcbiAgdmFyIGRlY2ltYWxBcnIgPSBwcmljZVRlbXAuc3BsaXQoXCIuXCIpO1xuICBpZiAoZGVjaW1hbEFyci5sZW5ndGggPCAyKSB7XG4gICAgcHJpY2VUZW1wID0gcGFyc2VGbG9hdChwcmljZVRlbXApLnRvRml4ZWQoMSk7XG4gICAgZGVjaW1hbEFyciA9IHByaWNlVGVtcC5zcGxpdChcIi5cIik7XG4gIH1cbiAgY29uc3QgZGVjaW1hbENvdW50ID0gZGVjaW1hbEFyclsxXS5sZW5ndGg7XG4gIGNvbnN0IHBhZGRlZFByaWNlU3RyID1cbiAgICBkZWNpbWFsQ291bnQgPCBwcmVjaXNpb25cbiAgICAgID8gcHJpY2VUZW1wLnBhZEVuZChwcmljZVRlbXAubGVuZ3RoICsgKHByZWNpc2lvbiAtIGRlY2ltYWxDb3VudCksIFwiMFwiKVxuICAgICAgOiBwYXJzZUZsb2F0KHByaWNlVGVtcCkudG9GaXhlZChwcmVjaXNpb24pO1xuICBjb25zdCBmaW5hbFByaWNlU3RyID0gcGFkZGVkUHJpY2VTdHIucmVwbGFjZSgvXFxkKD89KFxcZHszfSkrXFwuKS9nLCBcIiQmLFwiKTtcbiAgcmV0dXJuIGZpbmFsUHJpY2VTdHI7XG59XG5cbi8v6L+b6KGM57K+5bqm5aSE55CGXG5leHBvcnQgZnVuY3Rpb24gZm9ybWF0UHJlY2lzaW9uKHZhbHVlLCBwcmVjaXNpb24pIHtcbiAgdHJ5IHtcbiAgICBjb25zdCByZXN1bHQgPSBudW1iZXIuZm9ybWF0KHZhbHVlLCBwcmVjaXNpb24pO1xuICAgIHJldHVybiByZXN1bHQ7XG4gIH0gY2F0Y2ggKGUpIHtcbiAgICBjb25zb2xlLmxvZyhlKTtcbiAgICByZXR1cm4gdmFsdWUudG9GaXhlZChwcmVjaXNpb24pO1xuICB9XG59XG5cbi8vIC8v5omT5byAVVJMXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gb3BlblVSTCh1cmwpIHtcbiAgaWYgKCFjbGlja2FibGUpIHtcbiAgICByZXR1cm47XG4gIH1cbiAgY29uc29sZS5sb2coYG9wZW4gdXJsOmAsIHVybCk7XG4gIGlmICh1cmwgJiYgdXJsICE9IG51bGwgJiYgdXJsLmxlbmd0aCA+IDApIHtcbiAgICBhd2FpdCAkbmF0aXZlQVBJLm9wZW5Sb3V0ZSh1cmwpO1xuICB9XG4gIGNsaWNrYWJsZSA9IGZhbHNlO1xuICBzZXRUaW1lb3V0KCgpID0+IHtcbiAgICBjbGlja2FibGUgPSB0cnVlO1xuICB9LCAxMDAwKTtcbn1cblxuLy/miZPlvIDpobXpnaJcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBvcGVuUGFnZShwYWdlLCB0eXBlID0gXCJuYXRpdmVcIiwgcGFyYW1zID0ge30pIHtcbiAgYXdhaXQgJG5hdGl2ZUFQSS5jb3B5VHJhZGluZ0JyaWRnZSh7XG4gICAgYWN0aW9uOiBcIm9wZW5QYWdlXCIsXG4gICAgdHlwZTogdHlwZSxcbiAgICBwYWdlOiBwYWdlLFxuICAgIHBhcmFtczogSlNPTi5zdHJpbmdpZnkocGFyYW1zKSxcbiAgfSk7XG59XG5cbi8vdG9hc3RcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzaG93VG9hc3QobXNnKSB7XG4gIGF3YWl0ICRuYXRpdmVBUEkuaGJUb2FzdChtc2cpO1xufVxuXG4vL+S/neWtmOaVsOaNrlxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNhdmUobW9kdWxlLCBrZXksIGRhdGEpIHtcbiAgYXdhaXQgJG5hdGl2ZUFQSS5zdG9yYWdlKHtcbiAgICBhY3Rpb246IFwic2F2ZVwiLFxuICAgIG5hbWU6IG1vZHVsZSxcbiAgICBrZXk6IGtleSxcbiAgICBkYXRhOiBKU09OLnN0cmluZ2lmeShkYXRhKSxcbiAgfSk7XG59XG5cbi8v6K+75Y+W5pWw5o2uXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gcmVhZChtb2R1bGUsIGtleSkge1xuICBjb25zdCBkYXRhID0gYXdhaXQgJG5hdGl2ZUFQSS5zdG9yYWdlKHtcbiAgICBhY3Rpb246IFwicmVhZFwiLFxuICAgIG5hbWU6IG1vZHVsZSxcbiAgICBrZXk6IGtleSxcbiAgfSk7XG4gIGlmIChkYXRhICYmIGRhdGEgIT0gXCJcIikge1xuICAgIHJldHVybiBKU09OLnBhcnNlKGRhdGEpO1xuICB9XG4gIHJldHVybiBudWxsO1xufVxuXG4vL+a4heeQhuaVsOaNrlxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGNsZWFyKG1vZHVsZSwga2V5KSB7XG4gIGF3YWl0ICRuYXRpdmVBUEkuc3RvcmFnZSh7XG4gICAgYWN0aW9uOiBcImNsZWFyXCIsXG4gICAgbmFtZTogbW9kdWxlLFxuICAgIGtleToga2V5LFxuICB9KTtcbn1cblxuLy/muIXnkIblhajpg6jmlbDmja5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBjbGVhckFsbChtb2R1bGUpIHtcbiAgYXdhaXQgJG5hdGl2ZUFQSS5zdG9yYWdlKHtcbiAgICBhY3Rpb246IFwiY2xlYXJcIixcbiAgICBuYW1lOiBtb2R1bGUsXG4gIH0pO1xufVxuXG4vL+iuvue9rumAmueUqOmFjee9rlxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNlbmRDb21tb25Db25maWcocGFyYW0pIHtcbiAgY29uc29sZS5sb2cocGFyYW0pO1xuICBsZXQgc2F2ZWRTeW1ib2wgPSBhd2FpdCByZWFkKFwiY29weVRyYWRpbmdcIiwgXCJjdXJyZW50Q29weVRyYWRpbmdTeW1ib2xcIik7XG4gIGlmIChudWxsID09IHNhdmVkU3ltYm9sIHx8IDAgPT0gc2F2ZWRTeW1ib2wubGVuZ3RoKSB7XG4gICAgY29tbW9uRGF0YS5jdXJyZW50U3ltYm9sID0gXCJCVEMtVVNEVFwiO1xuICB9IGVsc2Uge1xuICAgIGNvbW1vbkRhdGEuY3VycmVudFN5bWJvbCA9IHNhdmVkU3ltYm9sO1xuICB9XG4gIGNvbW1vbkRhdGEuY29udHJhY3RINVVybCA9IHBhcmFtLmNvbnRyYWN0SDVVcmw7XG4gIGNvbW1vbkRhdGEuY3VycmVuY3lSYXRlID0gcGFyYW0uY3VycmVuY3lSYXRlO1xuICBpZiAocGFyYW0uY3VycmVuY3lSYXRlICE9IG51bGwgJiYgMCA9PSBwYXJhbS5jdXJyZW5jeVJhdGUubGVuZ3RoKSB7XG4gICAgY29tbW9uRGF0YS5jdXJyZW5jeVJhdGUgPSBcIjFcIjtcbiAgfVxuICBjb21tb25EYXRhLmN1cnJlbmN5Q2hhcmFjdGVyID0gcGFyYW0uY3VycmVuY3lDaGFyYWN0ZXI7XG4gIGNvbW1vbkRhdGEucHJpY2VDb2xvclR5cGUgPSBwYXJzZUludChwYXJhbS5wcmljZUNvbG9yVHlwZSk7XG4gIGNvbW1vbkRhdGEuY29sb3JNb2RlID0gcGFyc2VJbnQocGFyYW0uY29sb3JNb2RlKTtcbiAgY29tbW9uRGF0YS5PUyA9IHBhcnNlSW50KHBhcmFtLk9TKTtcbiAgY29tbW9uRGF0YS5hcHBWZXJzaW9uID0gcGFyYW0uYXBwVmVyc2lvbjtcbiAgY29tbW9uRGF0YS5pc0luUmV2aWV3ID0gcGFyc2VJbnQocGFyYW0uaXNJblJldmlldyk7XG4gIGNvbW1vbkRhdGEubGFuZ3VhZ2UgPSBwYXJhbS5sYW5ndWFnZTtcbiAgY29tbW9uRGF0YS53ZWJVcmwgPSBwYXJhbS5oNVVybDtcblxuICB2YXIgcmVkQ29sb3JMaXN0ID0gW1wiIzhDOUZBRFwiLCBcIiNFOTQzNTlcIiwgXCIjRUUzRjM0XCIsIFwiI0REMjgxRFwiLCBcIiNGRkY1RjRcIl07XG4gIHZhciBncmVlbkNvbG9yTGlzdCA9IFtcIiM4QzlGQURcIiwgXCIjMDBBMTcxXCIsIFwiIzEzOUE4NFwiLCBcIiMwRjc2NjVcIiwgXCIjMTIxRjI1XCJdO1xuXG4gIGlmIChwYXJzZUludChjb21tb25EYXRhLnByaWNlQ29sb3JUeXBlKSA9PSAwKSB7XG4gICAgdXBDb2xvckxpc3QgPSByZWRDb2xvckxpc3Q7XG4gICAgZG93bkNvbG9yTGlzdCA9IGdyZWVuQ29sb3JMaXN0O1xuICB9IGVsc2Uge1xuICAgIHVwQ29sb3JMaXN0ID0gZ3JlZW5Db2xvckxpc3Q7XG4gICAgZG93bkNvbG9yTGlzdCA9IHJlZENvbG9yTGlzdDtcbiAgfVxufVxuXG5leHBvcnQgZnVuY3Rpb24gZ2V0VXBEb3duQ29sb3IoaXNVcHBlciA9IHRydWUsIGxldmVsID0gMSkge1xuICBjb25zdCBsZXYgPSBsZXZlbCA8IDQgPyBsZXZlbCA6IDA7XG4gIGlmIChpc1VwcGVyKSB7XG4gICAgcmV0dXJuIHVwQ29sb3JMaXN0W2xldl07XG4gIH1cbiAgcmV0dXJuIGRvd25Db2xvckxpc3RbbGV2XTtcbn1cbmxldCBzeW1ib2xEZXNjTWFwID0ge31cbmV4cG9ydCBmdW5jdGlvbiBzeW1ib2xEZXNjKHN5bWJvbCkge1xuICBpZiAoIXN5bWJvbERlc2NNYXAuaGFzT3duUHJvcGVydHkoc3ltYm9sKSkge1xuICAgIHN5bWJvbERlc2NNYXBbc3ltYm9sXSA9ICRpMThuLiRpbnRlcmNlcHQubl9jb250cmFjdF9zd2FwX3RyYWRlX25hbWUoc3ltYm9sLnJlcGxhY2UoXCItXCIsIFwiXCIpKTtcbiAgfVxuICByZXR1cm4gc3ltYm9sRGVzY01hcFtzeW1ib2xdO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gbW9kdWxlRGVmaW5lKG1vZHVsZU5hbWUsIHN0YXJ0RnVuY3Rpb24sIGRlZmF1bHREYXRhRnVuY3Rpb24pIHtcbiAgY29uc29sZS5sb2coYGxvYWRNb2R1bGVgLCBtb2R1bGVOYW1lKTtcbiAgJGRhdGFbbW9kdWxlTmFtZV0gPSBkZWZhdWx0RGF0YUZ1bmN0aW9uKCk7XG4gICRldmVudFttb2R1bGVOYW1lXSA9IHsgc3RhcnQ6IHN0YXJ0RnVuY3Rpb24gfTtcbiAgcmV0dXJuIHtcbiAgICBtb2R1bGVFdmVudDogJGV2ZW50W21vZHVsZU5hbWVdLFxuICAgIG1vZHVsZURhdGE6ICRkYXRhW21vZHVsZU5hbWVdLFxuICB9O1xufVxuXG5leHBvcnQgZnVuY3Rpb24gTG9nKG1zZywgLi4uYXJncykge1xuICBjb25zb2xlLmxvZyhgW2NvcHl0cmFkaW5nIGpzLV0ke21zZ31gLCBhcmdzKTtcbn1cblxuLyoqXG4gKiBcbiAqIEBwYXJhbSB7Ym9vbGVhbn0gaXNTaG93IOaYr+WQpuaYvuekuuWKoOi9veahhlxuICovXG5leHBvcnQgZnVuY3Rpb24gc2hvd0xvYWRpbmcoaXNTaG93ID0gdHJ1ZSkge1xuICAkbmF0aXZlQVBJLnNob3dMb2FkaW5nKGlzU2hvdyA/IDEgOiAwKTtcbn1cblxubGV0IHN5bWJvbE1hcCA9IHt9O1xuXG4vKipcbiAqIFxuICogQHBhcmFtIHtzdHJpbmd9IHN5bWJvbCDluIHlr7nkv6Hmga/vvIxCVEMtVVNEVFxuICogQHJldHVybnMg6L+U5Zue546w6LSn5Lqk5piT5a+55qih5Z6LXG4gKi9cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRTcG90U3ltYm9sTW9kZWwoc3ltYm9sKSB7XG4gIGlmIChzeW1ib2xNYXAuaGFzT3duUHJvcGVydHkoc3ltYm9sKSkge1xuICAgIHJldHVybiBzeW1ib2xNYXBbc3ltYm9sXTtcbiAgfVxuICBjb25zdCBqc29uID0gYXdhaXQgJG5hdGl2ZUFQSS5nZXRTcG90U3ltYm9sTW9kZWwoc3ltYm9sKTtcbiAgY29uc29sZS5sb2coYHRsIC0tIGdldFNwb3RTeW1ib2xNb2RlbD09Pmpzb249PSR7anNvbn1gKTtcbiAgY29uc3QgcmVzcG9uc2UgPSBKU09OLnBhcnNlKGpzb24pO1xuICBjb25zb2xlLmxvZyhgdGwgLS0gZ2V0U3BvdFN5bWJvbE1vZGVsPT0+cmVzcG9uc2U9PSR7cmVzcG9uc2V9YCk7XG4gIHN5bWJvbE1hcFtzeW1ib2xdID0gcmVzcG9uc2U7XG4gIHJldHVybiByZXNwb25zZTtcbn1cblxuLyoqXG4gKiDmt7vliqAv5Yig6Zmk6Ieq6YCJXG4gKiBAcGFyYW0ge3N0cmluZ30gc3ltYm9sIOW4geWvueS/oeaBr++8jEJUQy1VU0RUXG4gKiBAcGFyYW0ge2Jvb2xlYW59IGlzRmF2b3JpdGUgPTEg5bey5re75YqgID0+IOacqua3u+WKoFxuICogQHJldHVybiAwIOaTjeS9nOWksei0pe+8jDEg5pON5L2c5oiQ5YqfXG4gKi9cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBoYW5kbGVGYXZvcml0ZShzeW1ib2wsIGlzRmF2b3JpdGUpIHtcbiAgdmFyIGRpY3QgPSB7ICdzeW1ib2wnOiBzeW1ib2wsICdpc0Zhdm9yaXRlJzogaXNGYXZvcml0ZSB9O1xuICBjb25zb2xlLmxvZyhgdGwgLS0gaGFuZGxlRmF2b3JpdGUsIHN5bWJvbD09JHtzeW1ib2x9LCBpc0Zhdm9yaXRlPT0ke2lzRmF2b3JpdGV9YCk7XG4gIHJldHVybiBhd2FpdCAkbmF0aXZlQVBJLmhhbmRsZUZhdm9yaXRlKEpTT04uc3RyaW5naWZ5KGRpY3QpKTtcbn1cblxuLyoqXG4gKiDojrflj5bluIHnp43lm77moIdcbiAqIEBwYXJhbSB7c3RyaW5nfSBiYXNlQ3VycmVuY3kg5Z+656GA5biB5L+h5oGv77yM5L6L5aaCIEJUQ++8jEVUSFxuICogQHJldHVybnMg6L+U5Zue5biB5a+55Zu+5qCHIHBuZyDlnLDlnYBcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIGhhbmRsZVBOR0ljb25VcmwoYmFzZUN1cnJlbmN5KSB7XG4gIGxldCBiYXNlVXJsID0gY29tbW9uRGF0YS53ZWJVcmwgPyBjb21tb25EYXRhLndlYlVybCA6IFwiXCI7XG4gIGxldCBpY29uVXJsID0gYCR7YmFzZVVybH0vLS94L2hiL3AvYXBpL2NvbnRlbnRzL2N1cnJlbmN5L2ljb25fcG5nLyR7YmFzZUN1cnJlbmN5LnRvTG93ZXJDYXNlKCl9LnBuZ2A7XG4gIGNvbnNvbGUubG9nKGB0bCAtLSBoYW5kbGVQTkdJY29uVXJsLCBpY29uVXJsPT0ke2ljb25Vcmx9YCk7XG4gIHJldHVybiBpY29uVXJsO1xufSIsImltcG9ydCAqIGFzIGNvbW1vbiBmcm9tIFwiLi9jb21tb25cIjtcblxudmFyIGRhdGFMb2FkaW5nID0gZmFsc2U7XG52YXIgdGltZXJJZCA9IDA7XG52YXIgY291bnQgPSAwO1xuXG5hc3luYyBmdW5jdGlvbiBzdGFydCgpIHtcbiAgYXdhaXQgcmVxdWVzdERhdGFMaXN0KCk7XG59XG5cbmZ1bmN0aW9uIGRlZmF1bHREYXRhKCkge1xuICByZXR1cm4ge1xuICAgIGRhdGFMaXN0OiBbXSxcbiAgICBlbXB0eVZpc2libGU6IFwiaW52aXNpYmxlXCIsXG4gICAgbGlzdFZpc2libGU6IFwiaW52aXNpYmxlXCIsXG4gICAgcmVmcmVzaFN0YXR1czogMCxcbiAgICBzaG93T2Z0ZW5IaXN0b3J5OiBcImdvbmVcIixcbiAgICBzaG93Tm9ybWFsSGlzdG9yeTogXCJnb25lXCIsXG4gIH07XG59XG5cbmNvbnN0IHsgbW9kdWxlRGF0YSwgbW9kdWxlRXZlbnQgfSA9IGNvbW1vbi5tb2R1bGVEZWZpbmUoXG4gIFwia2xpbmVIaXN0b3J5XCIsXG4gIHN0YXJ0LFxuICBkZWZhdWx0RGF0YVxuKTtcblxuLy8vIOiOt+WPluS6pOaYk+WRmOWIl+ihqO+8mjAg57u85ZCI5qac5Y2V77yI6buY6K6k77yJ77yMMSDmlLbnm4rnjofvvIwyIOaAu+aUtuebiu+8iOWTjeW6lOmHjOayoeacie+8ie+8jDMg6Lef5Y2V6ICF5oC75pS255uKXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0RGF0YUxpc3QoKSB7XG4gIGlmIChkYXRhTG9hZGluZykge1xuICAgIGNvbnNvbGUubG9nKFwidGwgLS0g5q2j5Zyo6K+35rGC5rWP6KeI5Y6G5Y+y5YiX6KGo77yM5LiN5Zyo6YeN5aSN6K+35rGCXCIpO1xuICAgIHJldHVybjtcbiAgfVxuXG4gIGRhdGFMb2FkaW5nID0gdHJ1ZTtcbiAgc2hvd0xvYWRpbmcodHJ1ZSk7XG4gIGxldCBsaXN0RGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdChcbiAgICBcInYxL2hiZy9teWhvbWUvc3ltYm9sVmlldy9xdWVyeUhpc3RvcnlcIixcbiAgICBudWxsXG4gICk7XG4gIGRhdGFMb2FkaW5nID0gZmFsc2U7XG4gIHNob3dMb2FkaW5nKGZhbHNlKTtcbiAgdHJ5IHtcbiAgICBoYW5kbGVEYXRhV2l0aExpc3QobGlzdERhdGEpO1xuICB9IGNhdGNoIChlcnJvcikge1xuICAgIGNvbnNvbGUubG9nKGBlcnJvciA6JHtlcnJvcn1gKVxuICB9XG5cbn1cblxuZnVuY3Rpb24gaGFuZGxlRGF0YVdpdGhMaXN0KGxpc3REYXRhKSB7XG4gIG1vZHVsZURhdGEucmVmcmVzaFN0YXR1cyA9IFwiMlwiO1xuICBpZiAobGlzdERhdGEgIT0gbnVsbCkge1xuICAgIGlmIChcbiAgICAgIChsaXN0RGF0YS5vZnRlbkhpc3RvcnkgPT0gbnVsbCB8fCBsaXN0RGF0YS5vZnRlbkhpc3RvcnkubGVuZ3RoID09IDApICYmXG4gICAgICAobGlzdERhdGEubm9ybWFsSGlzdG9yeSA9PSBudWxsIHx8IGxpc3REYXRhLm5vcm1hbEhpc3RvcnkubGVuZ3RoID09IDApXG4gICAgKSB7XG4gICAgICBtb2R1bGVEYXRhLmVtcHR5VmlzaWJsZSA9IFwidmlzaWJsZVwiO1xuICAgICAgbW9kdWxlRGF0YS5saXN0VmlzaWJsZSA9IFwiaW52aXNpYmxlXCI7XG4gICAgICBjb25zb2xlLmxvZyhcInRsIC0tIDExMSDlsZXnpLrnqbrop4blm75cIik7XG4gICAgICByZXR1cm47XG4gICAgfVxuICAgIG1vZHVsZURhdGEuZW1wdHlWaXNpYmxlID0gXCJnb25lXCI7XG4gICAgbW9kdWxlRGF0YS5saXN0VmlzaWJsZSA9IFwidmlzaWJsZVwiO1xuICAgIG1vZHVsZURhdGEuc2hvd05vcm1hbEhpc3RvcnkgPVxuICAgICAgbGlzdERhdGEubm9ybWFsSGlzdG9yeS5sZW5ndGggPiAwID8gXCJ2aXNpYmxlXCIgOiBcImdvbmVcIjtcbiAgICBtb2R1bGVEYXRhLnNob3dPZnRlbkhpc3RvcnkgPVxuICAgICAgbGlzdERhdGEub2Z0ZW5IaXN0b3J5Lmxlbmd0aCA+IDAgPyBcInZpc2libGVcIiA6IFwiZ29uZVwiO1xuICAgIGNvbnNvbGUubG9nKFwidGwgLS0gMjIyIOWxleekuuWIl+ihqFwiKTtcbiAgICBsaXN0RGF0YUNvbmZpZyhsaXN0RGF0YS5vZnRlbkhpc3RvcnksIHRydWUpO1xuICAgIGxpc3REYXRhQ29uZmlnKGxpc3REYXRhLm5vcm1hbEhpc3RvcnksIGZhbHNlKTtcbiAgICByZXR1cm47XG4gIH0gZWxzZSB7XG4gICAgbW9kdWxlRGF0YS5lbXB0eVZpc2libGUgPSBcInZpc2libGVcIjtcbiAgICBtb2R1bGVEYXRhLmxpc3RWaXNpYmxlID0gXCJpbnZpc2libGVcIjtcbiAgICBjb25zb2xlLmxvZyhcInRsIC0tIDMzMyDlsZXnpLrnqbrop4blm75cIik7XG4gICAgcmV0dXJuO1xuICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIGxpc3REYXRhQ29uZmlnKGxpc3QsIGlzT2Z0ZW4pIHtcbiAgaWYgKGxpc3QgPT0gbnVsbCkge1xuICAgIHJldHVybjtcbiAgfVxuICBmb3IgKGxldCBbaW5kZXgsIGl0ZW1dIG9mIGxpc3QuZW50cmllcygpKSB7XG4gICAgaXRlbS5pbmRleCA9IGluZGV4O1xuICAgIGl0ZW0udHlwZSA9IGlzT2Z0ZW4gPyBcIm9mdGVuXCIgOiBcIm5vcm1hbFwiO1xuICAgIGNvbnN0IHN5bWJvbE1vZGVsID0gYXdhaXQgY29tbW9uLmdldFNwb3RTeW1ib2xNb2RlbChpdGVtLnN5bWJvbCk7XG4gICAgaXRlbS5iYXNlQ3VycmVuY3kgPSBzeW1ib2xNb2RlbC5iYXNlQ3VycmVuY3lEaXNwbGF5TmFtZTtcbiAgICBpdGVtLnF1b3RlQ3VycmVuY3kgPSBzeW1ib2xNb2RlbC5xdW90ZUN1cnJlbmN5RGlzcGxheU5hbWU7XG5cbiAgICBpZiAoaXRlbS5wcmljZSA9PSBudWxsIHx8IGl0ZW0ucHJpY2UubGVuZ3RoID09IDApIHtcbiAgICAgIGl0ZW0ucHJpY2UgPSBcIi0tXCI7XG4gICAgfSBlbHNlIHtcbiAgICAgIGxldCBuZXdQcmljZSA9IGNvbW1vbi5nZXRQcmljZVN0cmluZyhpdGVtLnByaWNlLCBzeW1ib2xNb2RlbC50cmFkZVByaWNlUHJlY2lzaW9uKTtcbiAgICAgIGl0ZW0ucHJpY2UgPSBuZXdQcmljZTtcbiAgICB9XG5cbiAgICBpZiAoaXRlbS51cEFuZERvd24gPT0gbnVsbCB8fCBpdGVtLnVwQW5kRG93bi5sZW5ndGggPT0gMCkge1xuICAgICAgaXRlbS51cEFuZERvd25UZXh0ID0gJy0tJztcbiAgICAgIGl0ZW0udXBBbmREb3duQ29sb3IgPSBjb21tb24uZ2V0UHJpY2VDb2xvcigwKTtcbiAgICB9IGVsc2Uge1xuICAgICAgaWYgKHBhcnNlRmxvYXQoaXRlbS51cEFuZERvd24pID4gMCkge1xuICAgICAgICBpdGVtLnVwQW5kRG93blRleHQgPVxuICAgICAgICAgIFwiK1wiICsgKHBhcnNlRmxvYXQoaXRlbS51cEFuZERvd24pICogMTAwKS50b0ZpeGVkKDIpLnRvU3RyaW5nKCkgKyBcIiVcIjtcbiAgICAgIH0gZWxzZSB7XG4gICAgICAgIGl0ZW0udXBBbmREb3duVGV4dCA9XG4gICAgICAgICAgKHBhcnNlRmxvYXQoaXRlbS51cEFuZERvd24pICogMTAwKS50b0ZpeGVkKDIpLnRvU3RyaW5nKCkgKyBcIiVcIjtcbiAgICAgIH1cbiAgICAgIGl0ZW0udXBBbmREb3duQ29sb3IgPSBjb21tb24uZ2V0UHJpY2VDb2xvcihwYXJzZUZsb2F0KGl0ZW0udXBBbmREb3duKSk7XG4gICAgfVxuICAgIGl0ZW0uc2hvd0FkZEZhdm9yaXRlID0gaXRlbS5pc0FkZEZhdm9yaXRlID09IDEgPyBcInZpc2libGVcIiA6IFwiZ29uZVwiOyAvL+aYvuekuuW3sua3u+WKoFxuICAgIGl0ZW0uc2hvd1VuQWRkRmF2b3JpdGUgPSBpdGVtLmlzQWRkRmF2b3JpdGUgPT0gMCA/IFwidmlzaWJsZVwiIDogXCJnb25lXCI7IC8v5pi+56S6K+iHqumAiVxuICAgIGl0ZW0uaWNvblVybCA9IGNvbW1vbi5oYW5kbGVQTkdJY29uVXJsKHN5bWJvbE1vZGVsLmJhc2VDdXJyZW5jeSk7XG4gIH1cbiAgaWYgKGlzT2Z0ZW4pIHtcbiAgICBtb2R1bGVEYXRhLm9mdGVuSGlzdG9yeSA9IGxpc3Q7XG4gIH0gZWxzZSB7XG4gICAgbW9kdWxlRGF0YS5ub3JtYWxIaXN0b3J5ID0gbGlzdDtcbiAgfVxufVxuXG5tb2R1bGVFdmVudC5jbGlja2VkT2Z0ZW5IaXN0b3J5SXRlbSA9IGZ1bmN0aW9uIChpbmRleCkge1xuICBpZiAoaW5kZXggPj0gbW9kdWxlRGF0YS5vZnRlbkhpc3RvcnkubGVuZ3RoKSB7XG4gICAgcmV0dXJuO1xuICB9XG4gIGdvdG9LbGluZURldGFpbChtb2R1bGVEYXRhLm9mdGVuSGlzdG9yeVtpbmRleF0uc3ltYm9sKTtcbiAgY29uc29sZS5sb2coYOeCueWHu+S6hue7j+W4uOa1j+iniOiusOW9lSxpbmRleD09JHtpbmRleH1gKTtcbn1cblxubW9kdWxlRXZlbnQuY2xpY2tlZE5vcm1hbEhpc3RvcnlJdGVtID0gZnVuY3Rpb24gKGluZGV4KSB7XG4gIGlmIChpbmRleCA+PSBtb2R1bGVEYXRhLm5vcm1hbEhpc3RvcnkubGVuZ3RoKSB7XG4gICAgcmV0dXJuO1xuICB9XG4gIGdvdG9LbGluZURldGFpbChtb2R1bGVEYXRhLm5vcm1hbEhpc3RvcnlbaW5kZXhdLnN5bWJvbCk7XG4gIGNvbnNvbGUubG9nKGDngrnlh7vkuobljoblj7LmtY/op4jorrDlvZUsaW5kZXg9PSR7aW5kZXh9YCk7XG59XG5cbnZhciBpc0NsaWNrID0gZmFsc2U7XG5mdW5jdGlvbiBnb3RvS2xpbmVEZXRhaWwoc3ltYm9sKSB7XG4gIGlmIChpc0NsaWNrKSB7XG4gICAgY29uc29sZS5sb2coYHRsIC0tIOmHjeWkjeeCueWHu+aXoOaViGApO1xuICAgIHJldHVybjtcbiAgfVxuICBpc0NsaWNrID0gdHJ1ZTtcbiAgY29uc29sZS5sb2coYHRsIC0tIOmYsuatoumHjeWkjeeCueWHu++8jGlzQ2xpY2s9PSR7aXNDbGlja31gKTtcbiAgbGV0IHVybCA9IGBob2xpZ2VpdDovL29wZW4vdjE/dXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9rbGluZS9pbmRleD9zeW1ib2w9JHtzeW1ib2x9YDtcbiAgY29tbW9uLm9wZW5VUkwodXJsKTtcbiAgY29uc29sZS5sb2coYOaJk+W8gOi3r+eUseWcsOWdgD09JHt1cmx9YCk7XG4gIHNldFRpbWVvdXQoZnVuY3Rpb24gKCkge1xuICAgIGlzQ2xpY2sgPSBmYWxzZTtcbiAgICBjb25zb2xlLmxvZyhgdGwgLS0g6Ziy5q2i6YeN5aSN54K55Ye777yMaXNDbGljaz09JHtpc0NsaWNrfWApO1xuICB9LCAyMDAwKTtcbn1cblxudmFyIGNhbkNsaWNrZWRGYXZvcml0ZSA9IHRydWU7XG5tb2R1bGVFdmVudC5jbGlja2VkT2Z0ZW5IaXN0b3J5SXRlbUZhdm9yaXRlID0gYXN5bmMgZnVuY3Rpb24gKGluZGV4KSB7XG4gIGlmICghY2FuQ2xpY2tlZEZhdm9yaXRlKSB7XG4gICAgY29uc29sZS5sb2coYOa3u+WKoC/liKDpmaToh6rpgInmiafooYzkuK3vvIzor7fnqI3lkI7lho3or5UuLi5gKTtcbiAgICByZXR1cm47XG4gIH1cbiAgY2FuQ2xpY2tlZEZhdm9yaXRlID0gZmFsc2U7XG4gIGNhbkNsaWNrZWRGYXZvcml0ZSA9IGF3YWl0IGhhbmRsZUZhdm9yaXRlKG1vZHVsZURhdGEub2Z0ZW5IaXN0b3J5LCBpbmRleCwgdHJ1ZSk7XG59XG5cbm1vZHVsZUV2ZW50LmNsaWNrZWROb3JtYWxIaXN0b3J5SXRlbUZhdm9yaXRlID0gYXN5bmMgZnVuY3Rpb24gKGluZGV4KSB7XG4gIGlmICghY2FuQ2xpY2tlZEZhdm9yaXRlKSB7XG4gICAgY29uc29sZS5sb2coYOa3u+WKoC/liKDpmaToh6rpgInmiafooYzkuK3vvIzor7fnqI3lkI7lho3or5UuLi5gKTtcbiAgICByZXR1cm47XG4gIH1cbiAgY2FuQ2xpY2tlZEZhdm9yaXRlID0gZmFsc2U7XG4gIGNhbkNsaWNrZWRGYXZvcml0ZSA9IGF3YWl0IGhhbmRsZUZhdm9yaXRlKG1vZHVsZURhdGEubm9ybWFsSGlzdG9yeSwgaW5kZXgsIGZhbHNlKTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gaGFuZGxlRmF2b3JpdGUobGlzdCwgaW5kZXgsIGlzT2Z0ZW4pIHtcbiAgaWYgKGluZGV4ID49IGxpc3QubGVuZ3RoKSB7XG4gICAgcmV0dXJuIHRydWU7XG4gIH1cbiAgbGV0IGl0ZW0gPSBsaXN0LmF0KGluZGV4KTtcbiAgY29uc3QgcmV0ID0gYXdhaXQgY29tbW9uLmhhbmRsZUZhdm9yaXRlKGl0ZW0uc3ltYm9sLCBpdGVtLmlzQWRkRmF2b3JpdGUpO1xuICBpZiAoMCA9PSByZXQpIHtcbiAgICByZXR1cm4gdHJ1ZTtcbiAgfVxuICBpZiAoaXRlbS5pc0FkZEZhdm9yaXRlID09IDEpIHtcbiAgICBpdGVtLmlzQWRkRmF2b3JpdGUgPSAwO1xuICB9IGVsc2Uge1xuICAgIGl0ZW0uaXNBZGRGYXZvcml0ZSA9IDE7XG4gIH1cbiAgaXRlbS5zaG93QWRkRmF2b3JpdGUgPSBpdGVtLmlzQWRkRmF2b3JpdGUgPT0gMSA/IFwidmlzaWJsZVwiIDogXCJnb25lXCI7IC8v5pi+56S65bey5re75YqgXG4gIGl0ZW0uc2hvd1VuQWRkRmF2b3JpdGUgPSBpdGVtLmlzQWRkRmF2b3JpdGUgPT0gMCA/IFwidmlzaWJsZVwiIDogXCJnb25lXCI7IC8v5pi+56S6K+iHqumAiVxuICBhd2FpdCByZXF1ZXN0RGF0YUxpc3QoKTtcbiAgLy8gaWYgKGlzT2Z0ZW4pIHtcbiAgLy8gICBtb2R1bGVEYXRhLm9mdGVuSGlzdG9yeSA9IGxpc3Q7XG4gIC8vICAgLy8g5ZCM5q2l5L+u5pS55Y6G5Y+y5rWP6KeI5biB5a+555qE6Ieq6YCJ54q25oCBXG4gIC8vICAgY29uc3Qgbm9ybWFsTGlzdCA9IG1vZHVsZURhdGEubm9ybWFsSGlzdG9yeTtcbiAgLy8gICBub3JtYWxMaXN0LmZvckVhY2goKG5vcm1hbEl0ZW0sIGluZGV4LCBub3JtYWxMaXN0KSA9PiB7XG4gIC8vICAgICBpZiAobm9ybWFsSXRlbS5zeW1ib2wgPT0gaXRlbS5zeW1ib2wpIHtcbiAgLy8gICAgICAgbm9ybWFsSXRlbS5pc0FkZEZhdm9yaXRlID0gaXRlbS5pc0FkZEZhdm9yaXRlO1xuICAvLyAgICAgICBub3JtYWxJdGVtLnNob3dBZGRGYXZvcml0ZSA9IGl0ZW0uc2hvd0FkZEZhdm9yaXRlOyAvL+aYvuekuuW3sua3u+WKoFxuICAvLyAgICAgICBub3JtYWxJdGVtLnNob3dVbkFkZEZhdm9yaXRlID0gaXRlbS5zaG93VW5BZGRGYXZvcml0ZTsgLy/mmL7npLor6Ieq6YCJXG4gIC8vICAgICB9XG4gIC8vICAgfSk7XG4gIC8vICAgbW9kdWxlRGF0YS5ub3JtYWxIaXN0b3J5ID0gbm9ybWFsTGlzdDtcbiAgLy8gfSBlbHNlIHtcbiAgLy8gICBtb2R1bGVEYXRhLm5vcm1hbEhpc3RvcnlbaW5kZXhdID0gaXRlbTtcbiAgLy8gICAvLyDlkIzmraXkv67mlLnnu4/luLjmtY/op4jluIHlr7nnmoToh6rpgInnirbmgIFcbiAgLy8gICBjb25zdCBvZnRlbkxpc3QgPSBtb2R1bGVEYXRhLm9mdGVuSGlzdG9yeTtcbiAgLy8gICBvZnRlbkxpc3QuZm9yRWFjaCgob2Z0ZW5JdGVtLCBpbmRleCwgb2Z0ZW5MaXN0KSA9PiB7XG4gIC8vICAgICBpZiAob2Z0ZW5JdGVtLnN5bWJvbCA9PSBpdGVtLnN5bWJvbCkge1xuICAvLyAgICAgICBvZnRlbkl0ZW0uaXNBZGRGYXZvcml0ZSA9IGl0ZW0uaXNBZGRGYXZvcml0ZTtcbiAgLy8gICAgICAgb2Z0ZW5JdGVtLnNob3dBZGRGYXZvcml0ZSA9IGl0ZW0uc2hvd0FkZEZhdm9yaXRlOyAvL+aYvuekuuW3sua3u+WKoFxuICAvLyAgICAgICBvZnRlbkl0ZW0uc2hvd1VuQWRkRmF2b3JpdGUgPSBpdGVtLnNob3dVbkFkZEZhdm9yaXRlOyAvL+aYvuekuivoh6rpgIlcbiAgLy8gICAgIH1cbiAgLy8gICB9KTtcbiAgLy8gICBtb2R1bGVEYXRhLm9mdGVuSGlzdG9yeSA9IG9mdGVuTGlzdDtcbiAgLy8gfVxuICByZXR1cm4gdHJ1ZTtcbn1cblxubW9kdWxlRXZlbnQub25SZWZyZXNoID0gYXN5bmMgZnVuY3Rpb24gKHNlYXJjaFdvcmQgPSBudWxsLCByYW5rVHlwZSA9IG51bGwpIHtcbiAgc3RvcFRpbWVyKCk7XG4gIGF3YWl0IHJlcXVlc3REYXRhTGlzdCgpO1xuICBzdGFydFRpbWVyKCk7XG59XG5cbi8vLyDlpITnkIborqLpmIXkvKDov4fmnaXnmoTmlbDmja7vvIjmnKrlkK/nlKjvvIlcbm1vZHVsZUV2ZW50LnVwZGF0ZURhdGEgPSBhc3luYyBmdW5jdGlvbiAoZGF0YSkge1xuICBpZiAoZGF0YSA9PSBudWxsIHx8IGRhdGEgPT0ge30pIHtcbiAgICByZXR1cm47XG4gIH1cbiAgY29uc3Qgbm9ybWFsTGlzdCA9IG1vZHVsZURhdGEubm9ybWFsSGlzdG9yeTtcbiAgbm9ybWFsTGlzdC5mb3JFYWNoKChub3JtYWxJdGVtLCBpbmRleCwgbm9ybWFsTGlzdCkgPT4ge1xuICAgIHZhciBzeW1ib2xEYXRhID0gZGF0YVtub3JtYWxJdGVtLnN5bWJvbF07XG4gICAgY29uc29sZS5sb2coXG4gICAgICBgdGwgLS0g6K6i6ZiF5Zue5Lyg55qE5pWw5o2uLHN5bWJvbERhdGE9PSR7SlNPTi5zdHJpbmdpZnkoc3ltYm9sRGF0YSl9LHN5bWJvbD09JHtub3JtYWxJdGVtLnN5bWJvbFxuICAgICAgfWBcbiAgICApO1xuICAgIGlmIChzeW1ib2xEYXRhICE9IG51bGwpIHtcbiAgICAgIG5vcm1hbEl0ZW0ucHJpY2UgPSBzeW1ib2xEYXRhLnByaWNlO1xuICAgICAgaWYgKHBhcnNlRmxvYXQoc3ltYm9sRGF0YS51cEFuZERvd24pID4gMCkge1xuICAgICAgICBub3JtYWxJdGVtLnVwQW5kRG93blRleHQgPVxuICAgICAgICAgIFwiK1wiICsgcGFyc2VGbG9hdChzeW1ib2xEYXRhLnVwQW5kRG93bikudG9GaXhlZCgyKS50b1N0cmluZygpICsgXCIlXCI7XG4gICAgICB9IGVsc2Uge1xuICAgICAgICBub3JtYWxJdGVtLnVwQW5kRG93blRleHQgPVxuICAgICAgICAgIHBhcnNlRmxvYXQoc3ltYm9sRGF0YS51cEFuZERvd24pLnRvRml4ZWQoMikudG9TdHJpbmcoKSArIFwiJVwiO1xuICAgICAgfVxuICAgICAgbm9ybWFsSXRlbS51cEFuZERvd25Db2xvciA9IGNvbW1vbi5nZXRQcmljZUNvbG9yKFxuICAgICAgICBwYXJzZUZsb2F0KHN5bWJvbERhdGEudXBBbmREb3duKVxuICAgICAgKTtcbiAgICB9XG4gIH0pO1xuICBtb2R1bGVEYXRhLm5vcm1hbEhpc3RvcnkgPSBub3JtYWxMaXN0O1xuXG4gIGNvbnN0IG9mdGVuTGlzdCA9IG1vZHVsZURhdGEub2Z0ZW5IaXN0b3J5O1xuICBvZnRlbkxpc3QuZm9yRWFjaCgob2Z0ZW5JdGVtLCBpbmRleCwgb2Z0ZW5MaXN0KSA9PiB7XG4gICAgdmFyIHN5bWJvbERhdGEgPSBkYXRhW29mdGVuSXRlbS5zeW1ib2xdO1xuICAgIGlmIChzeW1ib2xEYXRhICE9IG51bGwpIHtcbiAgICAgIG9mdGVuSXRlbS5wcmljZSA9IHN5bWJvbERhdGEucHJpY2U7XG4gICAgICBpZiAocGFyc2VGbG9hdChzeW1ib2xEYXRhLnVwQW5kRG93bikgPiAwKSB7XG4gICAgICAgIG9mdGVuSXRlbS51cEFuZERvd25UZXh0ID1cbiAgICAgICAgICBcIitcIiArIHBhcnNlRmxvYXQoc3ltYm9sRGF0YS51cEFuZERvd24pLnRvRml4ZWQoMikudG9TdHJpbmcoKSArIFwiJVwiO1xuICAgICAgfSBlbHNlIHtcbiAgICAgICAgb2Z0ZW5JdGVtLnVwQW5kRG93blRleHQgPVxuICAgICAgICAgIHBhcnNlRmxvYXQoc3ltYm9sRGF0YS51cEFuZERvd24pLnRvRml4ZWQoMikudG9TdHJpbmcoKSArIFwiJVwiO1xuICAgICAgfVxuICAgICAgb2Z0ZW5JdGVtLnVwQW5kRG93bkNvbG9yID0gY29tbW9uLmdldFByaWNlQ29sb3IoXG4gICAgICAgIHBhcnNlRmxvYXQoc3ltYm9sRGF0YS51cEFuZERvd24pXG4gICAgICApO1xuICAgIH1cbiAgfSk7XG4gIG1vZHVsZURhdGEub2Z0ZW5IaXN0b3J5ID0gb2Z0ZW5MaXN0O1xufVxuXG4vLy8gNWUzID0gNSAqIDEw55qEM+asoeaWuSA9IDUwMDAg5q+r56eSXG5mdW5jdGlvbiBzdGFydFRpbWVyKCkge1xuICAwID09IHRpbWVySWQgJiZcbiAgICAodGltZXJJZCA9IHNldEludGVydmFsKCgpID0+IHtcbiAgICAgIGNvbnNvbGUubG9nKGB0bCAtLS1jb3VudD09JHtjb3VudH1gKTtcbiAgICAgIGNvdW50ID0gY291bnQgKyAxO1xuICAgICAgcmVxdWVzdERhdGFMaXN0KCk7XG4gICAgfSwgMTVlMykpO1xufVxuXG5mdW5jdGlvbiBzdG9wVGltZXIoKSB7XG4gIGNvbnNvbGUubG9nKGB0bCAtLS1zdG9wVGltZXJgKTtcbiAgY2xlYXJJbnRlcnZhbCh0aW1lcklkKSwgKHRpbWVySWQgPSAwKTtcbn1cblxuLy8vIOmhtemdouWNs+WwhuWxleekulxubW9kdWxlRXZlbnQub25SZXN1bWUgPSBhc3luYyBmdW5jdGlvbiAoKSB7XG4gIGNvbnNvbGUubG9nKCd0bCAtLSBvblJlc3VtZScpO1xuICByZXF1ZXN0RGF0YUxpc3QoKTtcbiAgc3RhcnRUaW1lcigpO1xufVxuXG5tb2R1bGVFdmVudC5vblN0YXJ0ID0gYXN5bmMgZnVuY3Rpb24gKCkge1xuXG59XG5cbm1vZHVsZUV2ZW50Lm9uUGF1c2UgPSBhc3luYyBmdW5jdGlvbiAoKSB7XG5cbn1cblxuLy8vIOmhtemdouWNs+Wwhua2iOWksVxubW9kdWxlRXZlbnQub25TdG9wID0gYXN5bmMgZnVuY3Rpb24gKCkge1xuICBjb25zb2xlLmxvZygndGwgLS0gb25TdG9wJyk7XG4gIHN0b3BUaW1lcigpO1xufVxuXG5cbm1vZHVsZUV2ZW50Lm9uQ3JlYXRlID0gYXN5bmMgZnVuY3Rpb24gKGV2ZW50UGFyYW1zKSB7XG4gIG1vZHVsZURhdGEubmF2Q29uZmlnID0gZ2V0TmF2Q29uZmlnU3RyaW5nKCk7XG59O1xuXG5mdW5jdGlvbiBnZXROYXZDb25maWdTdHJpbmcoKSB7XG4gIGxldCBuYXYgPSB7XG4gICAgdGl0bGVLZXk6IFwibl91c2VyX2Jyb3dzaW5nX3RpdGxlXCIsXG4gICAgbGVmdDoge1xuICAgICAgYWN0aW9uOiB7XG4gICAgICAgIHR5cGU6IFwiYmFja1wiLFxuICAgICAgICBwYXJhbWV0ZXI6IFwiXCIsXG4gICAgICB9LFxuICAgICAgaWNvbjogXCJlZGdlX2VuZ2luZV90b3BfYmFyX2JhY2tfbm9ybWFsXCIsXG4gICAgfSxcbiAgfTtcbiAgcmV0dXJuIG5hdjtcbn1cblxubGV0IGxvYWRpbmdDb3VudCA9IDBcbmZ1bmN0aW9uIHNob3dMb2FkaW5nKGlzU2hvdyA9IHRydWUpIHtcbiAgaWYgKDAgIT0gbG9hZGluZ0NvdW50KysgJiYgaXNTaG93KSB7XG4gICAgcmV0dXJuO1xuICB9XG4gICRuYXRpdmVBUEkuc2hvd0xvYWRpbmcoaXNTaG93ID8gMSA6IDApO1xufVxuIiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiO1xuaW1wb3J0ICogYXMga2xpbmVIaXN0b3J5IGZyb20gXCIuL2tsaW5lSGlzdG9yeVwiO1xuXG5mdW5jdGlvbiBzZW5kQ29tbW9uQ29uZmlnKHBhcmFtKSB7XG4gICAgY29tbW9uLnNlbmRDb21tb25Db25maWcocGFyYW0pO1xufVxuXG4kZXZlbnQuc2VuZENvbW1vbkNvbmZpZyA9IHNlbmRDb21tb25Db25maWc7Il0sIm5hbWVzIjpbIk1BWF9EUCIsIk1BWF9QT1dFUiIsIk5BTUUiLCJJTlZBTElEIiwiSU5WQUxJRF9EUCIsIklOVkFMSURfUk0iLCJESVZfQllfWkVSTyIsIlAiLCJVTkRFRklORUQiLCJyb3VuZCIsIngiLCJkcCIsInJtIiwibW9yZSIsImMiLCJpIiwiZSIsInhjIiwibGVuZ3RoIiwiRXJyb3IiLCJ1bnNoaWZ0IiwicG9wIiwic3RyaW5naWZ5IiwiaWQiLCJuIiwiayIsInMiLCJCaWciLCJjb25zdHJ1Y3RvciIsInoiLCJSTSIsInB1c2giLCJORSIsIlBFIiwiY2hhckF0Iiwic2xpY2UiLCJhYnMiLCJ0aGlzIiwiY21wIiwieSIsInljIiwiaiIsImwiLCJpc25lZyIsImRpdiIsImEiLCJiIiwiRFAiLCJibCIsImJ0IiwicmkiLCJieiIsImFpIiwiYWwiLCJyIiwicmwiLCJxIiwicWMiLCJxaSIsImQiLCJzaGlmdCIsImVxIiwiZ3QiLCJndGUiLCJsdCIsImx0ZSIsIm1pbnVzIiwic3ViIiwidCIsInhsdHkiLCJwbHVzIiwieGUiLCJ5ZSIsInJldmVyc2UiLCJtb2QiLCJ5Z3R4IiwidGltZXMiLCJhZGQiLCJwb3ciLCJvbmUiLCJzcXJ0IiwiaGFsZiIsIk1hdGgiLCJqb2luIiwidG9FeHBvbmVudGlhbCIsImluZGV4T2YiLCJtdWwiLCJBcnJheSIsInRvRml4ZWQiLCJ0b1ByZWNpc2lvbiIsInNkIiwidG9TdHJpbmciLCJ2YWx1ZU9mIiwidG9KU09OIiwiY2xpY2thYmxlIiwidXBDb2xvckxpc3QiLCJkb3duQ29sb3JMaXN0IiwiY29tbW9uRGF0YSIsInVzZXJTaWduIiwiY3VycmVudFN5bWJvbCIsImN1cnJlbnRDb250cmFjdEluZm8iLCJjb250cmFjdEluZm9EYXRhIiwiY29udHJhY3RINVVybCIsImN1cnJlbmN5UmF0ZSIsImN1cnJlbmN5Q2hhcmFjdGVyIiwicHJpY2VDb2xvclR5cGUiLCJjb2xvck1vZGUiLCJPUyIsImFwcFZlcnNpb24iLCJpc0luUmV2aWV3IiwiaXNMb2dpbiIsIndlYlVybCIsImxhbmd1YWdlIiwibGluZWFyU3dhcFdzRGF0YSIsImFzeW5jIiwic2VuZFJlcXVlc3QiLCJwYXJhbXMiLCJtZXRob2QiLCJob3N0VHlwZSIsImhlYWRlciIsImNvbnNvbGUiLCJsb2ciLCJwYXRoIiwiSlNPTiIsInBhcmFtIiwicmVzcG9uc2VTdHJpbmciLCIkbmF0aXZlQVBJIiwicmVxdWVzdCIsInJlc3BvbnNlIiwicGFyc2UiLCJjb2RlIiwiZGF0YSIsInN0YXR1cyIsImVycl9jb2RlIiwiZXJyX21zZyIsInN0YXJ0Iiwic3RhcnRJbmRleCIsImVuZCIsImVuZEluZGV4IiwiZGF0YVN0cmluZyIsInN1YnN0cmluZyIsInNob3dUb2FzdCIsIm1lc3NhZ2UiLCJnZXRQcmljZUNvbG9yIiwicmF0aW8iLCJyYXRpb19hYnMiLCJjb2xvckxldmVsIiwiY29sb3JIZXhTdHIiLCJnZXRQcmljZVN0cmluZyIsInByaWNlU3RyIiwicHJlY2lzaW9uIiwicHJpY2VUZW1wIiwiZGVjaW1hbEFyciIsInNwbGl0IiwiZGVjaW1hbENvdW50IiwicGFkZGVkUHJpY2VTdHIiLCJwYWRFbmQiLCJwYXJzZUZsb2F0IiwiZmluYWxQcmljZVN0ciIsInJlcGxhY2UiLCJvcGVuVVJMIiwidXJsIiwib3BlblJvdXRlIiwic2V0VGltZW91dCIsImhiVG9hc3QiLCJtc2ciLCJyZWFkIiwia2V5Iiwic3RvcmFnZSIsImFjdGlvbiIsIm5hbWUiLCJtb2R1bGUiLCJzZW5kQ29tbW9uQ29uZmlnJDEiLCJzYXZlZFN5bWJvbCIsInBhcnNlSW50IiwiaDVVcmwiLCJyZWRDb2xvckxpc3QiLCJncmVlbkNvbG9yTGlzdCIsIm1vZHVsZURlZmluZSIsInN0YXJ0RnVuY3Rpb24iLCJkZWZhdWx0RGF0YUZ1bmN0aW9uIiwibW9kdWxlTmFtZSIsIiRkYXRhIiwiJGV2ZW50IiwibW9kdWxlRXZlbnQiLCJtb2R1bGVEYXRhIiwic3ltYm9sTWFwIiwiZ2V0U3BvdFN5bWJvbE1vZGVsIiwic3ltYm9sIiwiaGFzT3duUHJvcGVydHkiLCJqc29uIiwiaGFuZGxlRmF2b3JpdGUkMSIsImlzRmF2b3JpdGUiLCJkaWN0IiwiaGFuZGxlRmF2b3JpdGUiLCJoYW5kbGVQTkdJY29uVXJsIiwiYmFzZUN1cnJlbmN5IiwiYmFzZVVybCIsImljb25VcmwiLCJ0b0xvd2VyQ2FzZSIsImRhdGFMb2FkaW5nIiwidGltZXJJZCIsImNvdW50IiwicmVxdWVzdERhdGFMaXN0IiwiZGVmYXVsdERhdGEiLCJkYXRhTGlzdCIsImVtcHR5VmlzaWJsZSIsImxpc3RWaXNpYmxlIiwicmVmcmVzaFN0YXR1cyIsInNob3dPZnRlbkhpc3RvcnkiLCJzaG93Tm9ybWFsSGlzdG9yeSIsInNob3dMb2FkaW5nIiwibGlzdERhdGEiLCJoYW5kbGVEYXRhV2l0aExpc3QiLCJlcnJvciIsIm9mdGVuSGlzdG9yeSIsIm5vcm1hbEhpc3RvcnkiLCJsaXN0RGF0YUNvbmZpZyIsImxpc3QiLCJpc09mdGVuIiwiaW5kZXgiLCJlbnRyaWVzIiwiaXRlbSIsInR5cGUiLCJjb21tb24uZ2V0U3BvdFN5bWJvbE1vZGVsIiwic3ltYm9sTW9kZWwiLCJiYXNlQ3VycmVuY3lEaXNwbGF5TmFtZSIsInF1b3RlQ3VycmVuY3kiLCJxdW90ZUN1cnJlbmN5RGlzcGxheU5hbWUiLCJwcmljZSIsIm5ld1ByaWNlIiwidHJhZGVQcmljZVByZWNpc2lvbiIsInVwQW5kRG93biIsInVwQW5kRG93blRleHQiLCJ1cEFuZERvd25Db2xvciIsInNob3dBZGRGYXZvcml0ZSIsImlzQWRkRmF2b3JpdGUiLCJzaG93VW5BZGRGYXZvcml0ZSIsImNvbW1vbi5oYW5kbGVQTkdJY29uVXJsIiwiY2xpY2tlZE9mdGVuSGlzdG9yeUl0ZW0iLCJnb3RvS2xpbmVEZXRhaWwiLCJjbGlja2VkTm9ybWFsSGlzdG9yeUl0ZW0iLCJpc0NsaWNrIiwiY29tbW9uLm9wZW5VUkwiLCJjYW5DbGlja2VkRmF2b3JpdGUiLCJjbGlja2VkT2Z0ZW5IaXN0b3J5SXRlbUZhdm9yaXRlIiwiY2xpY2tlZE5vcm1hbEhpc3RvcnlJdGVtRmF2b3JpdGUiLCJhdCIsInJldCIsInNlYXJjaFdvcmQiLCJyYW5rVHlwZSIsInN0b3BUaW1lciIsInN0YXJ0VGltZXIiLCJ1cGRhdGVEYXRhIiwibm9ybWFsTGlzdCIsIm5vcm1hbEl0ZW0iLCJzeW1ib2xEYXRhIiwib2Z0ZW5MaXN0Iiwib2Z0ZW5JdGVtIiwic2V0SW50ZXJ2YWwiLCJjbGVhckludGVydmFsIiwib25SZXN1bWUiLCJvblN0YXJ0Iiwib25QYXVzZSIsIm9uU3RvcCIsIm9uQ3JlYXRlIiwiZXZlbnRQYXJhbXMiLCJuYXZDb25maWciLCJnZXROYXZDb25maWdTdHJpbmciLCJuYXYiLCJ0aXRsZUtleSIsImxlZnQiLCJwYXJhbWV0ZXIiLCJpY29uIiwibG9hZGluZ0NvdW50IiwiaXNTaG93Iiwic2VuZENvbW1vbkNvbmZpZyJdLCJtYXBwaW5ncyI6IkFBaUJHLElBYURBLFNBQVMsS0FHVEMsWUFBWSxLQXNCWkMsT0FBTyxhQUNQQyxVQUFVRCxPQUFPLFlBQ2pCRSxhQUFhRCxVQUFVLGtCQUN2QkUsYUFBYUYsVUFBVSxpQkFDdkJHLGNBQWNKLE9BQU8sb0JBR3JCSyxJQUFJLENBQUEsR0FDSkMsaUJBQWlCOztBQW1IbkIsU0FBV0MsTUFBR0MsR0FBQUMsSUFBQUMsSUFBQUM7SUFDVixTQUFPSCxFQUFHSSxHQUNkQyxJQUFBTCxFQUFBTSxJQUFBTCxLQUFBO0lBRUEsSUFBUUksSUFBRUUsR0FBS0MsUUFBRztRQUNsQixJQUFBTixPQUFBLEdBQUE7WUFHV0MsT0FBQUksR0FBTUYsTUFBSztBQUN0QixlQUFVLElBQUtILE9BQU8sR0FBQTtZQUNiQyxPQUFJSSxHQUFJRixLQUFJLEtBQUtFLEdBQUdGLE1BQU0sTUFDeEJGLFFBQU1FLElBQUEsS0FBUUUsR0FBQUYsSUFBQSxPQUFBUCxhQUFBUyxHQUFBRixJQUFBLEtBQUE7QUFDbkIsZUFBTyxJQUFBSCxPQUFTLEdBQUc7WUFDZEMsT0FBQUEsVUFBQUksR0FBQTtBQUNMLGVBQU87WUFDUEosT0FBTTtZQUNQLElBQUFELE9BQUEsR0FBQSxNQUFBTyxNQUFBZDtBQUNMO1FBRUEsSUFBUVUsSUFBTyxHQUFBO1lBQ2ZFLEdBQUFDLFNBQUE7WUFFQSxJQUFBTCxNQUFBO2dCQUdRSCxFQUFFTSxLQUFHTDtnQkFDQU0sR0FBQSxLQUFBO0FBQ2IsbUJBQUE7Z0JBR09BLEdBQUEsS0FBQVAsRUFBQU0sSUFBQTtBQUNJO0FBQ1gsZUFBQTtZQUdBQyxHQUFBQyxTQUFBSDtZQUdBLElBQUFGLE1BQUE7Z0JBR0EsUUFBZUksR0FBS0YsS0FBQSxLQUFBO29CQUNWRSxHQUFJRixLQUFJO29CQUNsQixLQUFlQSxLQUFHOzBCQUNKTCxFQUFDTTt3QkFDSkMsR0FBQUcsUUFBQTtBQUNGO0FBQ0Y7QUFDUDtZQUdLLEtBQUFMLElBQUFFLEdBQUFDLFNBQUFELEtBQUFGLE1BQUFFLEdBQUFJO0FBQ0k7QUFDVCxXQUFVLElBQUFULEtBQU0sS0FBQUEsS0FBWSxLQUFBQSxTQUFBQSxJQUFBO1FBQ3pCLE1BQUFPLE1BQUFkO0FBQ0g7SUFFQyxPQUFBSztBQUNEOztBQWdCQSxTQUFTWSxVQUFDWixHQUFBYSxJQUFBQyxHQUFBQztJQUNWLElBQU9ULEdBQUFVLEdBQ0hDLE1BQU1qQixFQUFFa0IsYUFDWkMsS0FBQW5CLEVBQUFJLEVBQUE7SUFFQSxVQUFTTixXQUFpQjtRQUMxQixJQUFZZ0IsUUFBQUEsS0FBWUEsS0FBSUQsTUFBQSxNQUFVQyxJQUFBeEIsUUFBYztZQUMvQyxNQUFBbUIsTUFBQUksTUFBQSxJQUFBcEIsVUFBQSxjQUFBQztBQUNMO1FBRUFNLElBQUEsSUFBQWlCLElBQUFqQjtRQUdBYyxJQUFBQyxJQUFBZixFQUFBTTtRQUdBLElBQUFOLEVBQUFJLEVBQUFJLFdBQUFPLEdBQUFoQixNQUFBQyxHQUFBYyxHQUFBRyxJQUFBRztRQUdBLElBQUFQLE1BQUEsR0FBQUUsSUFBQWYsRUFBQU0sSUFBQVEsSUFBQTtRQUdHLE1BQUFkLEVBQUFJLEVBQUFJLFNBQUFPLEtBQUFmLEVBQUFJLEVBQUFpQixLQUFBO0FBQ0g7SUFFRWYsSUFBSU4sRUFBRU07SUFDTlUsSUFBSWhCLEVBQUVJLE9BQU87SUFDZlUsSUFBQUUsRUFBQVI7SUFHQSxJQUFLSyxZQUFhQSxNQUFNLEtBQU9BLFdBQWFFLEtBQUNULEtBQUtBLFNBQVFnQixNQUFPaEIsS0FBTVcsSUFBQU0sS0FBUTtRQUMvRVAsSUFBQUEsRUFBQVEsT0FBQSxNQUFBVixJQUFBLElBQUEsTUFBQUUsRUFBQVMsTUFBQSxLQUFBLE9BQUFuQixJQUFBLElBQUEsTUFBQSxRQUFBQTtBQUdJLFdBQUEsSUFBU0EsSUFBSSxHQUFJO1FBQ2pCLFFBQVFBLEtBQUtVLElBQUEsTUFBQUE7UUFDUkEsSUFBQSxPQUFLQTtBQUNkLFdBQVUsSUFBSVYsSUFBRyxHQUFLO1FBQ2IsTUFBQUEsSUFBS1EsR0FBRyxLQUFPUixLQUFFUSxHQUFBUixPQUFVVSxLQUFJLFVBQy9CLElBQUlWLElBQUlRLEdBQUdFLElBQUFBLEVBQUFTLE1BQUEsR0FBQW5CLEtBQUEsTUFBQVUsRUFBQVMsTUFBQW5CO0FBQ3BCLFdBQVMsSUFBQ1EsSUFBTyxHQUFLO1FBQ25CRSxJQUFBQSxFQUFBUSxPQUFBLEtBQUEsTUFBQVIsRUFBQVMsTUFBQTtBQUNIO0lBRUMsT0FBQXpCLEVBQUFnQixJQUFBLE9BQUFHLEtBQUFOLE1BQUEsS0FBQSxNQUFBRyxJQUFBQTtBQUNEOztBQVNBbkIsRUFBRTZCLE1BQUs7SUFDTCxJQUFHMUIsSUFBSyxJQUFBMkIsS0FBQVQsWUFBQVM7SUFDUjNCLEVBQUFnQixJQUFBO0lBQ0EsT0FBQWhCO0FBQ0Y7O0FBUUFILEVBQUUrQixNQUFTLFNBQUFDO0lBQ1AsV0FDQTdCLElBQUUyQixNQUNGcEIsS0FBS1AsRUFBRUksR0FDUDBCLE1BQU1ELElBQUMsSUFBQTdCLEVBQUFrQixZQUFBVyxJQUFBekIsR0FDUEMsSUFBSUwsRUFBRWdCLEdBQ05lLElBQUlGLEVBQUViLEdBQ05ELElBQUlmLEVBQUVNLEdBQ1YwQixJQUFBSCxFQUFBdkI7SUFHQSxLQUFBQyxHQUFBLE9BQUF1QixHQUFBLElBQUEsUUFBQXZCLEdBQUEsTUFBQXVCLEdBQUEsS0FBQSxLQUFBQyxJQUFBMUI7SUFHQSxJQUFBQSxLQUFBMEIsR0FBQSxPQUFBMUI7SUFFQTRCLFFBQUE1QixJQUFBO0lBR0EsSUFBQVUsS0FBQWlCLEdBQUEsT0FBQWpCLElBQUFpQixJQUFBQyxRQUFBLEtBQUE7SUFFQUYsS0FBQWhCLElBQUFSLEdBQUFDLFdBQUF3QixJQUFBRixHQUFBdEIsVUFBQU8sSUFBQWlCO0lBR0EsS0FBUTNCLEtBQUksS0FBS0EsSUFBSTBCLEtBQUc7UUFDckIsSUFBQXhCLEdBQUFGLE1BQUF5QixHQUFBekIsSUFBQSxPQUFBRSxHQUFBRixLQUFBeUIsR0FBQXpCLEtBQUE0QixRQUFBLEtBQUE7QUFDSDtJQUdFLE9BQUFsQixLQUFBaUIsSUFBQSxJQUFBakIsSUFBQWlCLElBQUFDLFFBQUEsS0FBQTtBQUNGOztBQU9BcEMsRUFBRXFDLE1BQUssU0FBT0w7SUFDZCxJQUFPN0IsSUFBRzJCLE1BQ05WLE1BQU1qQixFQUFDa0IsYUFDUGlCLElBQUluQyxFQUFFSSxHQUNOZ0MsS0FBS1AsSUFBRSxJQUFNWixJQUFJWSxJQUFJekIsR0FDckJXLElBQUVmLEVBQU1nQixLQUFHYSxFQUFDYixJQUFBLEtBQUEsR0FDaEJmLEtBQUFnQixJQUFBb0I7SUFFQSxJQUFBcEMsU0FBQUEsTUFBQUEsS0FBQSxLQUFBQSxLQUFBWCxRQUFBLE1BQUFtQixNQUFBZjtJQUdBLEtBQUEwQyxFQUFBLElBQUEsTUFBQTNCLE1BQUFiO0lBR0EsS0FBQXVDLEVBQUEsSUFBQSxPQUFBLElBQUFsQixJQUFBRixJQUFBO0lBRUEsSUFBTXVCLElBQUlDLE9BQVFYLEtBQUFZLElBQ2RDLEtBQUtMLEVBQUVYLFNBQ1BpQixLQUFLSixLQUFRRixFQUFBNUIsUUFDYm1DLEtBQUtSLFVBQ0xTLElBQUVULEVBQUlWLE1BQU8sR0FBQWEsS0FDYk8sS0FBS0QsRUFBQXBDLFFBQ0xzQyxJQUFLakIsR0FDTGtCLEtBQUtELEVBQUMxQyxJQUFBLElBQ040QyxLQUFJLEdBQ1JDLElBQUFoRCxNQUFBNkMsRUFBQXhDLElBQUFOLEVBQUFNLElBQUF1QixFQUFBdkIsS0FBQTtJQUVFd0MsTUFBSy9CO0lBQ1BBLElBQUFrQyxJQUFBLElBQUEsSUFBQUE7SUFHQVIsR0FBQS9CLFFBQUE7SUFHQSxNQUFBbUMsT0FBQVAsTUFBQU0sRUFBQXZCLEtBQUE7SUFFQSxHQUFBO1FBR0EsS0FBQVAsSUFBQSxHQUFBQSxJQUFBLElBQUFBLEtBQUE7WUFHUSxJQUFBd0IsT0FBV08sT0FBS3JDLFNBQU87Z0JBQ2xCb0IsTUFBQVUsS0FBQU8sS0FBQSxLQUFBO0FBQ2IsbUJBQWE7Z0JBQ0gsS0FBQUwsTUFBUyxTQUFTLEtBQUVBLEtBQUFGLE1BQUE7b0JBQzlCLE1BQWtCRSxPQUFLSSxFQUFHSixLQUFJO3dCQUNsQlosTUFBTVEsRUFBQUksTUFBQUksRUFBQUosTUFBQSxLQUFBO3dCQUNQO0FBQ0Y7QUFDRjtBQUNQO1lBR0EsSUFBQVosTUFBQSxHQUFBO2dCQUlVLEtBQUFXLEtBQVFNLE1BQU1QLEtBQUtGLElBQUdLLElBQUFJLE1BQUE7b0JBQ3BCLElBQUVELElBQUdDLE1BQUdOLEdBQUFNLEtBQUE7d0JBQ1JMO3dCQUNBLE1BQU9BLE9BQUNJLElBQUFKLE9BQUFJLEVBQUFKLE1BQUE7MEJBQ05JLEVBQUVKO3dCQUNMSSxFQUFBQyxPQUFBO0FBQ0Q7b0JBQ0RELEVBQUFDLE9BQUFOLEdBQUFNO0FBQ1Q7Z0JBRWEsT0FBQUQsRUFBQSxNQUFBQSxFQUFBTTtBQUNiLG1CQUFjO2dCQUNQO0FBQ0Y7QUFDTDtRQUdBSCxHQUFBQyxRQUFBcEIsTUFBQWQsTUFBQUE7UUFHUyxJQUFBOEIsRUFBQyxNQUFNaEIsS0FBS2dCLEVBQUFDLE1BQUFWLEVBQUFPLE9BQUEsUUFDckJFLElBQUEsRUFBQVQsRUFBQU87QUFFQSxjQUFBQSxPQUFBQyxNQUFBQyxFQUFBLE9BQUE5QyxjQUFBaUI7SUFHQSxLQUFBZ0MsR0FBQSxNQUFBQyxNQUFBLEdBQUE7UUFHSUQsR0FBR0c7UUFDSkosRUFBQXhDO0FBQ0g7SUFHQSxJQUFBMEMsS0FBQUMsR0FBQWxELE1BQUErQyxHQUFBN0MsSUFBQWdCLElBQUFHLElBQUF3QixFQUFBLE9BQUE5QztJQUVFLE9BQUFnRDtBQUNGOztBQU1BakQsRUFBRXNELEtBQUE7SUFDQSxRQUFBeEIsS0FBQUMsSUFBQUM7QUFDRjs7QUFPQWhDLEVBQUV1RCxLQUFBLFNBQWV2QjtJQUNmLE9BQUFGLEtBQUFDLElBQUFDLEtBQUE7QUFDRjs7QUFPQWhDLEVBQUV3RCxNQUFBLFNBQWdCeEI7SUFDaEIsT0FBQUYsS0FBQUMsSUFBQUMsTUFBQTtBQUNGOztBQU1BaEMsRUFBRXlELEtBQUEsU0FBZXpCO0lBQ2YsT0FBQUYsS0FBQUMsSUFBQUMsS0FBQTtBQUNGOztBQU9BaEMsRUFBRTBELE1BQUEsU0FBZ0IxQjtJQUNoQixPQUFBRixLQUFBQyxJQUFBQyxLQUFBO0FBQ0Y7O0FBTUFoQyxFQUFFMkQsUUFBUTNELEVBQUU0RCxNQUFPLFNBQUE1QjtJQUNmLE9BQVFFLEdBQUEyQixHQUFBQyxNQUNSM0QsSUFBRzJCLE1BQ0hWLE1BQU1qQixFQUFDa0IsYUFDUGlCLElBQUluQyxFQUFFZ0IsR0FDVm9CLEtBQUFQLElBQUEsSUFBQVosSUFBQVksSUFBQWI7SUFHQSxJQUFNbUIsS0FBS0MsR0FBRTtRQUNUUCxPQUFPTztRQUNSLE9BQUFwQyxFQUFBNEQsS0FBQS9CO0FBQ0g7SUFFQSxJQUFNdEIsS0FBS1AsRUFBQ0ksRUFBQXFCLFNBQ1JvQyxLQUFLN0QsRUFBRU0sR0FDUHdCLEtBQUtELEVBQUV6QixHQUNYMEQsS0FBQWpDLEVBQUF2QjtJQUdBLEtBQUFDLEdBQUEsT0FBQXVCLEdBQUEsSUFBQTtRQUdHLE9BQUFBLEdBQUEsTUFBQUQsRUFBQWIsS0FBQW9CLEdBQUFQLEtBQUEsSUFBQVosSUFBQVYsR0FBQSxLQUFBUCxJQUFBO0FBQ0g7SUFHQSxJQUFBbUMsSUFBQTBCLEtBQUFDLElBQUE7UUFFQSxJQUFPSCxPQUFNeEIsSUFBQSxHQUFBO1lBQ1BBLEtBQUlBO1lBQ0N1QixJQUFBbkQ7QUFDTCxlQUFLO1lBQ0x1RCxLQUFJRDtZQUNMSCxJQUFBNUI7QUFDTDtRQUVJNEIsRUFBS0s7UUFDTCxLQUFTM0IsSUFBQUQsR0FBR0MsT0FBQXNCLEVBQUFyQyxLQUFBO1FBQ1BxQyxFQUFBSztBQUNULFdBQUE7UUFHQWhDLE1BQUE0QixPQUFBcEQsR0FBQUMsU0FBQXNCLEdBQUF0QixVQUFBRCxLQUFBdUIsSUFBQXRCO1FBRU0sS0FBQTJCLElBQU9DLE9BQVFBLElBQUdMLEdBQUVLLEtBQUE7WUFDbEIsSUFBQTdCLEdBQU82QixNQUFJTixHQUFDTSxJQUFNO2dCQUNsQnVCLE9BQU1wRCxHQUFBNkIsS0FBQU4sR0FBQU07Z0JBQ1A7QUFDRjtBQUNGO0FBQ0g7SUFHSSxJQUFJdUIsTUFBRztRQUNQRCxJQUFLbkQ7UUFDTEEsS0FBS3VCO1FBQ0xBLEtBQUc0QjtRQUNKN0IsRUFBQWIsS0FBQWEsRUFBQWI7QUFDSDtJQU1BLEtBQUFvQixLQUFBTCxJQUFBRCxHQUFBdEIsV0FBQUgsSUFBQUUsR0FBQUMsV0FBQSxHQUFBLE1BQUE0QixPQUFBN0IsR0FBQUYsT0FBQTtJQUdJLEtBQUErQixJQUFPL0IsR0FBRzBCLElBQUlJLEtBQUk7UUFDaEIsSUFBQTVCLEtBQVN3QixLQUFHRCxHQUFDQyxJQUFPO1lBQ3BCLEtBQUsxQixJQUFHMEIsR0FBQTFCLE1BQUFFLEtBQUFGLE1BQUFFLEdBQUFGLEtBQUE7Y0FDTkUsR0FBR0Y7WUFDTkUsR0FBQXdCLE1BQUE7QUFDTDtRQUVHeEIsR0FBQXdCLE1BQUFELEdBQUFDO0FBQ0g7SUFHQSxNQUFBeEIsS0FBQTZCLE9BQUEsS0FBQTdCLEdBQUFJO0lBR0EsTUFBWUosR0FBQSxPQUFHLEtBQUE7UUFDWEE7VUFDRHVEO0FBQ0g7SUFFQSxLQUFBdkQsR0FBQSxJQUFBO1FBR0FzQixFQUFBYixJQUFBO1FBR0dULEtBQUEsRUFBQXVELEtBQUE7QUFDSDtJQUVFakMsRUFBRXpCLElBQUlHO0lBQ1JzQixFQUFBdkIsSUFBQXdEO0lBRUUsT0FBQWpDO0FBQ0Y7O0FBTUFoQyxFQUFFbUUsTUFBUSxTQUFBbkM7SUFDTixVQUNBN0IsSUFBRzJCLE1BQ0hWLE1BQU1qQixFQUFDa0IsYUFDUGlCLElBQUluQyxFQUFFZ0IsR0FDVm9CLEtBQUFQLElBQUEsSUFBQVosSUFBQVksSUFBQWI7SUFFQSxLQUFBYSxFQUFBekIsRUFBQSxJQUFBLE1BQUFLLE1BQUFiO0lBRUVJLEVBQUFnQixJQUFPYSxFQUFDYixJQUFJO0lBQ1ppRCxPQUFPcEMsRUFBQ0QsSUFBQTVCLE1BQUE7SUFDUkEsRUFBRWdCLElBQUltQjtJQUNSTixFQUFBYixJQUFBb0I7SUFFQSxJQUFBNkIsTUFBQSxPQUFBLElBQUFoRCxJQUFBakI7SUFFRW1DLElBQUlsQixJQUFJb0I7SUFDUkQsSUFBSW5CLElBQUVHO0lBQ05ILElBQUlvQixLQUFLcEIsSUFBSUcsS0FBQTtJQUNicEIsSUFBSUEsRUFBRWtDLElBQUlMO0lBQ1ZaLElBQUlvQixLQUFLRjtJQUNYbEIsSUFBQUcsS0FBQWdCO0lBRUUsT0FBQVQsS0FBQTZCLE1BQUF4RCxFQUFBa0UsTUFBQXJDO0FBQ0Y7O0FBTUFoQyxFQUFFK0QsT0FBSy9ELEVBQUFzRSxNQUFBLFNBQUF0QztJQUNILE9BQ0E3QixJQUFHMkIsTUFDSFYsTUFBTWpCLEVBQUNrQixhQUNQaUIsSUFBSW5DLEVBQUVnQixHQUNWb0IsS0FBQVAsSUFBQSxJQUFBWixJQUFBWSxJQUFBYjtJQUdBLElBQU1tQixLQUFLQyxHQUFFO1FBQ1RQLE9BQU9PO1FBQ1IsT0FBQXBDLEVBQUF3RCxNQUFBM0I7QUFDSDtJQUVBLElBQU1nQyxLQUFLN0QsRUFBQ00sR0FDUkMsS0FBS1AsRUFBRUksR0FDUDBELEtBQUtqQyxFQUFFdkIsR0FDWHdCLEtBQUFELEVBQUF6QjtJQUdBLEtBQUFHLEdBQUEsT0FBQXVCLEdBQUEsSUFBQSxPQUFBQSxHQUFBLEtBQUFELElBQUEsSUFBQVosSUFBQVYsR0FBQSxLQUFBUCxJQUFBbUMsSUFBQTtJQUVBNUIsS0FBQUEsR0FBQWtCO0lBSUEsSUFBUVUsSUFBSTBCLEtBQUdDLElBQUE7UUFDVCxJQUFFM0IsSUFBRyxHQUFHO1lBQ1IyQixLQUFJRDtZQUNDSCxJQUFBNUI7QUFDWCxlQUFXO1lBQ0xLLEtBQUlBO1lBQ0x1QixJQUFBbkQ7QUFDTDtRQUVJbUQsRUFBQUs7UUFDQSxNQUFTNUIsT0FBR3VCLEVBQUFyQyxLQUFBO1FBQ2JxQyxFQUFBSztBQUNIO0lBR0ksSUFBSXhELEdBQUFDLFNBQUdzQixHQUFBdEIsU0FBQSxHQUFBO1FBQ1BrRCxJQUFLNUI7UUFDTEEsS0FBS3ZCO1FBQ05BLEtBQUFtRDtBQUNIO0lBRUF2QixJQUFBTCxHQUFBdEI7SUFHQSxLQUFBNEIsSUFBQSxHQUFBRCxHQUFBNUIsR0FBQTRCLE1BQUEsSUFBQUMsS0FBQTdCLEtBQUE0QixLQUFBNUIsR0FBQTRCLEtBQUFMLEdBQUFLLEtBQUFDLEtBQUEsS0FBQTtJQUlBLElBQU1BLEdBQUM7UUFDSDdCLFdBQUs2QjtVQUNOMEI7QUFDSDtJQUdBLEtBQUEzQixJQUFBNUIsR0FBQUMsUUFBQUQsS0FBQTRCLE9BQUEsS0FBQTVCLEdBQUFJO0lBRUVrQixFQUFFekIsSUFBSUc7SUFDUnNCLEVBQUF2QixJQUFBd0Q7SUFFRSxPQUFBakM7QUFDRjs7QUFVQWhDLEVBQUV1RSxNQUFLLFNBQU90RDtJQUNWLElBQUFkLElBQU0yQixNQUNOMEMsTUFBTyxJQUFBckUsRUFBQWtCLFlBQUEsSUFDUFcsSUFBS3dDLEtBQ1RwQyxRQUFBbkIsSUFBQTtJQUVFLElBQUlBLFFBQVFBLEtBQUtBLEtBQUN2QixhQUFBdUIsSUFBQXZCLFdBQUEsTUFBQWtCLE1BQUFoQixVQUFBO0lBQ3BCLElBQUF3QyxPQUFBbkIsS0FBQUE7SUFFQSxTQUFZO1FBQ1IsSUFBTUEsSUFBRSxHQUFBZSxJQUFBQSxFQUFBcUMsTUFBQWxFO1FBQ1JjLE1BQU07UUFDTixLQUFLQTtRQUNOZCxJQUFBQSxFQUFBa0UsTUFBQWxFO0FBQ0g7SUFFRSxPQUFBaUMsUUFBQW9DLElBQUFuQyxJQUFBTCxLQUFBQTtBQUNGOztBQWFBaEMsRUFBRUUsUUFBTztJQUNQLElBQUlrQixNQUFPVSxLQUFBVDtJQUNOLElBQUFqQixPQUFNSCxXQUFTRyxLQUFTLFFBQzdCLG1CQUFxQkEsTUFBU1gsdUJBQXFCLE1BQU1tQixNQUFPZjtJQUNoRSxPQUFBSyxNQUFBLElBQUFrQixJQUFBVSxPQUFBMUIsSUFBQUMsT0FBQUosWUFBQW1CLElBQUFHLEtBQUFsQjtBQUNGOztBQU9BTCxFQUFFeUUsT0FBTztJQUNMLE9BQVFsRSxHQUFBc0QsR0FDUjFELElBQUcyQixNQUNIVixNQUFNakIsRUFBQ2tCLGFBQ1BGLElBQUloQixFQUFFZ0IsR0FDTlYsSUFBSU4sRUFBR00sR0FDWGlFLE9BQUEsSUFBQXRELElBQUE7SUFHQSxLQUFBakIsRUFBQUksRUFBQSxJQUFBLE9BQUEsSUFBQWEsSUFBQWpCO0lBR0EsSUFBQWdCLElBQUEsR0FBQSxNQUFBUCxNQUFBakIsT0FBQTtJQUdBd0IsSUFBQXdELEtBQUFGLEtBQUF0RSxJQUFBO0lBSUksSUFBSWdCLE1BQUksS0FBS0EsTUFBSSxJQUFBLEdBQUE7UUFDakJaLElBQUlKLEVBQUVJLEVBQUVxRTtRQUNSLE1BQVFyRSxFQUFBSSxTQUFTRixJQUFBLElBQUFGLEtBQUE7UUFDakJZLElBQUl3RCxLQUFNRjtRQUNWaEUsTUFBSUEsSUFBTyxLQUFHLElBQUssTUFBT0EsSUFBQSxLQUFRQSxJQUFJO1FBQ2pDc0MsSUFBQSxJQUFBM0IsS0FBQUQsS0FBQSxJQUFBLElBQUEsUUFBQUEsSUFBQUEsRUFBQTBELGlCQUFBakQsTUFBQSxHQUFBVCxFQUFBMkQsUUFBQSxPQUFBLE1BQUFyRTtBQUNULFdBQVE7UUFDTHNDLElBQUEsSUFBQTNCLElBQUFEO0FBQ0g7SUFFQVYsSUFBQXNDLEVBQUF0QyxLQUFBVyxJQUFBb0IsTUFBQTtJQUdJLEdBQUM7UUFDRHFCLElBQUlkO1FBQ0dBLElBQUEyQixLQUFFTCxNQUFPUixFQUFDRSxLQUFLNUQsRUFBQ2tDLElBQUt3QjtBQUNoQyxhQUFBQSxFQUFBdEQsRUFBQXFCLE1BQUEsR0FBQW5CLEdBQUFtRSxLQUFBLFFBQUE3QixFQUFBeEMsRUFBQXFCLE1BQUEsR0FBQW5CLEdBQUFtRSxLQUFBO0lBRUUsT0FBQTFFLE1BQUE2QyxHQUFBM0IsSUFBQW9CLE1BQUEsR0FBQXBCLElBQUFHO0FBQ0Y7O0FBTUF2QixFQUFFcUUsUUFBS3JFLEVBQUErRSxNQUFBLFNBQUEvQztJQUNILE9BQ0E3QixJQUFHMkIsTUFDSFYsTUFBTWpCLEVBQUVrQixhQUNSWCxLQUFLUCxFQUFFSSxHQUNQMEIsTUFBTUQsSUFBTyxJQUFBWixJQUFBWSxJQUFBekIsR0FDYitCLElBQUk1QixHQUFHQyxRQUNQNEIsSUFBSU4sR0FBR3RCLFFBQ1BILElBQUlMLEVBQUVNLEdBQ1Z5QixJQUFBRixFQUFBdkI7SUFHQXVCLEVBQUFiLElBQUFoQixFQUFBZ0IsS0FBQWEsRUFBQWIsSUFBQSxLQUFBO0lBR0EsS0FBQVQsR0FBQSxPQUFBdUIsR0FBQSxJQUFBLE9BQUEsSUFBQWIsSUFBQVksRUFBQWIsSUFBQTtJQUdBYSxFQUFBdkIsSUFBQUQsSUFBQTBCO0lBR0ksSUFBSUksSUFBRUMsR0FBQztRQUNQaEMsSUFBS0c7UUFDTEEsS0FBS3VCO1FBQ0xBLEtBQUsxQjtRQUNMMkIsSUFBSUk7UUFDSkEsSUFBSUM7UUFDTEEsSUFBQUw7QUFDSDtJQUdBLEtBQUEzQixJQUFBLElBQUF5RSxNQUFBOUMsSUFBQUksSUFBQUMsSUFBQUwsT0FBQTNCLEVBQUEyQixLQUFBO0lBS0ksS0FBSTFCLElBQUUrQixHQUFBL0IsT0FBQTtRQUNWK0IsSUFBQTtRQUdBLEtBQUFMLElBQUFJLElBQUE5QixHQUFBMEIsSUFBQTFCLEtBQUE7WUFHTStCLElBQUdoQyxFQUFHMkIsS0FBT0QsR0FBQXpCLEtBQUdFLEdBQUF3QixJQUFBMUIsSUFBQSxLQUFBK0I7WUFDdEJoQyxFQUFBMkIsT0FBQUssSUFBQTtZQUdLQSxJQUFBQSxJQUFBLEtBQUE7QUFDTDtRQUVHaEMsRUFBQTJCLE1BQUEzQixFQUFBMkIsS0FBQUssS0FBQTtBQUNIO0lBR0EsSUFBQUEsS0FBY1AsRUFBQXZCLFFBQ2RGLEVBQUE4QztJQUdFLEtBQUc3QyxJQUFLRCxFQUFBSSxTQUFBSixJQUFBQyxNQUFBRCxFQUFBTztJQUNWa0IsRUFBQXpCLElBQUFBO0lBRUUsT0FBQXlCO0FBQ0Y7O0FBU0FoQyxFQUFFNkUsZ0JBQWdCLFNBQVV6RTtJQUMxQixPQUFBVyxVQUFBZSxNQUFBLEdBQUExQixJQUFBQTtBQUNGOztBQVlBSixFQUFFaUYsVUFBTyxTQUFVN0U7SUFDakIsT0FBQVcsVUFBQWUsTUFBQSxHQUFBMUIsSUFBQTBCLEtBQUFyQixJQUFBTDtBQUNGOztBQVVBSixFQUFFa0YsY0FBTyxTQUFpQkM7SUFDeEIsT0FBQXBFLFVBQUFlLE1BQUEsR0FBQXFELElBQUFBLEtBQUE7QUFDRjs7QUFTQW5GLEVBQUVvRixXQUFPO0lBQ1AsT0FBQXJFLFVBQUFlO0FBQ0Y7O0FBU0E5QixFQUFFcUYsVUFBZ0JyRixFQUFBc0YsU0FBSztJQUN0QixPQUFBdkUsVUFBQWUsTUFBQTs7O0FDaDVCRCxJQUFBeUQsWUFBQTs7QUFHQSxJQUFJQzs7QUFDSixJQUFBQzs7QUFlQSxJQUFFQyxhQUFZO0lBQ1pDLFVBQUE7SUFDQUMsZUFBQTtJQUNBQyxxQkFBb0IsQ0FBQTtJQUNwQkMsa0JBQWlCO0lBQ2pCQyxlQUFtQjtJQUNuQkMsY0FBQTtJQUNBQyxtQkFBaUI7SUFDakJDLGdCQUFZO0lBQ1pDLFdBQUs7SUFDTEMsSUFBQTtJQUNBQyxZQUFZO0lBQ1pDLFlBQVU7SUFDVkMsU0FBVTtJQUNWQyxRQUFRO0lBQ1JDLFVBQUE7SUFDQUMsa0JBQUEsQ0FBQTs7O0FBa0JGQyxlQUFlQyxrQkFBZUMsU0FBZSxDQUFBLEdBQUNDLFNBQVMsR0FBQ0MsV0FBVyxHQUFBQyxTQUFBLENBQUE7SUFDbkVDLFFBQUFDLElBQUEsV0FBQUMsZ0JBQUFDLEtBQUFyRyxVQUFBOEY7SUFFQSxnQkFBVyxLQUFBRTtRQUNSQyxPQUFBLGtCQUFBO0FBQ0g7SUFFQSxNQUFRSyxRQUFBO1FBQ0pGO1FBQ0FMO1FBQ0FDO1FBQ0FDO1FBQ0FIOztJQUVKO1FBQ0ksSUFBSVMsdUJBQW9DQyxXQUFBQyxRQUFFSixLQUFBckcsVUFBQXNHO1FBQzFDLElBQUlJLGdCQUFjQztRQUNsQixLQUFJQyxNQUFLQSxNQUFBQyxNQUFBQSxRQUFVSDtRQUN2QixJQUFBLEtBQUFWLFVBQUE7WUFFTSxJQUFJYyxTQUFRSixTQUFXSTtZQUN2QixJQUFJQyxXQUFrQkw7WUFDdEIsSUFBSU0sVUFBVU4sU0FBTU07WUFDMUIsSUFBZUYsVUFBSyxNQUFDO2dCQUNiWixRQUFJQyxJQUFXO2dCQUN2QixXQUFtQlUsU0FBSSxVQUFTO29CQUN0QixJQUFJSTtvQkFDSixJQUFJQyxhQUFhWCxlQUFFeEMsUUFBQWtEO29CQUNuQixJQUFJRTtvQkFDSixJQUFJQyxXQUFhYixlQUFBeEMsUUFBd0JvRDtvQkFDekMsSUFBQUUsYUFBaURkLGVBQUFlLFVBQUFKLGFBQVlELE1BQUFySCxRQUFJd0g7b0JBQ2pFbEIsbURBQWtCbUI7b0JBQ25CLE9BQUFBO0FBQ0Q7Z0JBQ0ssT0FBQVI7QUFDYixtQkFBZTtnQkFDUFgsUUFBSUMsSUFBVSx3QkFBR1kscUJBQUFDO2dCQUN6QixJQUFtQmpCLFVBQVEsR0FBQTtvQkFDbEJ3QixVQUFBUDtBQUNEO2dCQUNELE9BQUE7QUFDSTtBQUNYLGVBQWEsSUFBSUosUUFBRSxLQUFVO1lBQ3ZCVixZQUFZLFdBQUFFO1lBQ1AsT0FBQVM7QUFDTCxlQUFBO1lBQ0FYLFFBQVdDLElBQUEsd0JBQW9CUztZQUMvQixJQUFJWSxVQUFVZDtZQUNwQixJQUFpQlgsVUFBUSxLQUFBeUIsU0FBRTtnQkFDcEJELFVBQUFDO0FBQ0Q7WUFDRCxPQUFBO0FBQ0Q7QUFDQSxNQUFBLE9BQU85SDtRQUNQd0csWUFBWSx3QkFBQXhHO1FBQ2IsT0FBQTtBQUNGO0FBdUNEOztBQUdBLFNBQUErSCxjQUFBQztJQUVJLElBQUFBLFNBQVUsTUFBQTtRQUNYQSxRQUFBO0FBQ0Q7SUFDQSxNQUFJQyxZQUFjL0QsS0FBQzlDLElBQUE0RztJQUNuQixJQUFJRSxhQUFhO0lBQ2YsSUFBQUQsWUFBYyxLQUFDQSxZQUFBLEdBQUE7UUFDaEJDLGFBQW1CO0FBQ2xCLFdBQUEsSUFBQUQsYUFBZSxLQUFBQSxZQUFBLEdBQUE7UUFDVkMsYUFBYTtBQUNsQixXQUFBLElBQUFELGFBQWUsR0FBQTtRQUNoQkMsYUFBQTtBQUNEO0lBQ0EsSUFBSUMsY0FBVztJQUNqQixlQUFrQjtRQUNUQSxjQUFBcEQsWUFBQW1EO0FBQ1Q7UUFDR0MsY0FBQW5ELGNBQUFrRDtBQUNEO0lBQ0QsT0FBQUM7QUFDRDs7QUFHQSxTQUFNQyxlQUFZQyxVQUFTQztJQUN6QixJQUFJQyxZQUFhRjtJQUNqQixJQUFJRyxhQUFpQkQsVUFBTUUsTUFBQTtJQUN6QixJQUFBRCxXQUFZdEksU0FBVSxHQUFDO1FBQ3ZCcUksdUJBQXVCQSxXQUFXL0QsUUFBQTtRQUNuQ2dFLGFBQUFELFVBQUFFLE1BQUE7QUFDRDtJQUNBLE1BQU1DLGVBQWNGLFdBQUEsR0FBQXRJO0lBQ2xCLE1BQUF5SSxpQkFDSkQsZUFBd0JKLFlBQ2hCQyxVQUFVSyxPQUFVTCxVQUFTckksVUFBVW9JLFlBQUVJLGVBQUEsT0FDekNHLFdBQWFOLFdBQWlCL0QsUUFBQThEO0lBQ3BDLE1BQUFRLGdCQUFxQkgsZUFBQUksUUFBQSxxQkFBQTtJQUN0QixPQUFBRDtBQVlEOztBQUdBNUMsZUFBTzhDLFFBQVdDO0lBQ2xCLEtBQVduRSxXQUFBO1FBQ1I7QUFDRDtJQUNBMEIsUUFBV0MsSUFBQSxhQUFld0M7SUFDNUIsV0FBb0JBLE9BQUEsWUFBVy9JLFNBQUssR0FBQTtjQUNqQzRHLFdBQUFvQyxVQUFBRDtBQUNEO0lBQ0FuRSxZQUFpQjtJQUNmcUUsWUFBUztRQUNWckUsWUFBUTtBQUFBLFFBQ1Y7QUFXRDs7QUFHQW9CLGVBQWtCMkI7VUFDakJmLFdBQUFzQyxRQUFBQztBQVdEOztBQUdBbkQsZUFBZW9ELGFBQWdCQztJQUMzQixNQUFBcEMsYUFBY0wsV0FBQTBDLFFBQUE7UUFDZEMsUUFBWTtRQUNaQyxNQUFRQztRQUNSSixLQUFDQTs7SUFFTCxZQUFlcEMsUUFBTyxJQUFJO1FBQ3ZCLE9BQUFSLEtBQUFNLE1BQUFFO0FBQ0Q7SUFDRCxPQUFBO0FBa0JEOztBQUdBakIsZUFBYzBELG1CQUFPaEQ7SUFDbkJKLFFBQWVDLElBQUFHO0lBQ2YsSUFBSWlELG9CQUFtQlAsS0FBUyxlQUFZO0lBQzlDLElBQWMsUUFBQU8sZUFBYyxpQkFBYzNKLFFBQUE7UUFDakMrRSxXQUFBRSxnQkFBQTtBQUNULFdBQWM7UUFDWEYsV0FBQUUsZ0JBQUEwRTtBQUNEO0lBQ0E1RSxXQUFXSyxnQkFBb0JzQjtJQUMvQjNCLFdBQVVNLGVBQWdCcUIsTUFBSXJCO0lBQ2hDLElBQWNxQixNQUFBckIsZ0JBQWEsUUFBTyxLQUFBcUIsTUFBQXJCLGFBQUFyRixRQUFBO1FBQy9CK0UsV0FBQU0sZUFBQTtBQUNEO0lBQ0FOLFdBQVdPLG9CQUFpQm9CLE1BQVNwQjtJQUNyQ1AsV0FBV1EsaUJBQVlxRSxTQUFjbEQsTUFBVW5CO0lBQy9DUixXQUFXUyxZQUFLb0UsU0FBaUJsRCxNQUFFbEI7SUFDbkNULFdBQVdVLEtBQUFtRSxTQUFrQmxEO0lBQzdCM0IsV0FBV1csYUFBYWdCLE1BQUFoQjtJQUN4QlgsV0FBV1ksYUFBZ0JpRSxlQUFVakU7SUFDckNaLFdBQVdlLFdBQWNZO0lBQzNCM0IsV0FBQWMsU0FBQWEsTUFBQW1EO0lBRUUsSUFBSUMsZUFBaUIsRUFBQSxXQUFVLFdBQVcsV0FBVyxXQUFXO0lBQ2xFLElBQUFDLGlCQUFBLEVBQUEsV0FBQSxXQUFBLFdBQUEsV0FBQTtJQUVJLElBQUFILFNBQVc3RSxXQUFHUSxtQkFBYSxHQUFBO1FBQzNCVixjQUFnQmlGO1FBQ1hoRixnQkFBQWlGO0FBQ0wsV0FBQTtRQUNBbEYsY0FBZ0JrRjtRQUNqQmpGLGdCQUFBZ0Y7QUFDRjtBQWdCRDs7QUFFQSxTQUFTRSx5QkFBNkJDLGVBQUVDO0lBQ3RDNUQsUUFBTUMsSUFBQSxjQUFjNEQ7SUFDcEJDLE1BQU1ELGNBQVlEO0lBQ2xCRyxPQUFPRixjQUFBO1FBQUE5QyxPQUFBNEM7O0lBQ1QsT0FBZTtRQUNYSyxhQUFpQkQ7UUFDakJFLFlBQUFILE1BQUFEOztBQWNKOztBQUVBLElBQUFLLFlBQUEsQ0FBQTs7QUFPQXhFLGVBQWV5RSxtQkFBZ0JDO0lBQy9CLElBQVdGLFVBQUFHLGVBQWtCRCxTQUFBO1FBQzFCLE9BQUFGLFVBQUFFO0FBQ0Q7SUFDQSxNQUFBRSxhQUE4Q2hFLFdBQUE2RCxtQkFBTUM7SUFDcERwRSxnREFBa0NzRTtJQUNsQyxNQUFBOUQsV0FBa0RMLEtBQUFNLE1BQUE2RDtJQUNsRHRFLFlBQVUsd0NBQW1CUTtJQUM3QjBELG9CQUFnQjFEO0lBQ2pCLE9BQUFBO0FBQ0Q7O0FBUUFkLGVBQWU2RSxpQkFBZ0JILFFBQWNJO0lBQzNDLElBQU9DLE9BQUk7UUFBRUwsUUFBOEJBO1FBQUFJLFlBQUVBOztJQUM3Q3hFLFFBQU9DLElBQUEsaUNBQThDbUUsdUJBQVFJO0lBQzlELGFBQUFsRSxXQUFBb0UsZUFBQXZFLEtBQUFyRyxVQUFBMks7QUFDRDs7QUFPQSxTQUFNRSxpQkFBb0JDO0lBQ3hCLElBQUlDLFVBQVVwRyxXQUFXYyxTQUFBZCxXQUFBYyxTQUFBO0lBQ3pCLElBQUF1RixVQUE4QyxHQUFBRCxtREFBYUQsYUFBQUc7SUFDM0QvRSxnREFBZThFO0lBQ2pCLE9BQUFBOzs7QUNoWUEsSUFBSUUsY0FBWTs7QUFDaEIsSUFBSUMsVUFBVTs7QUFDZCxJQUFBQyxRQUFBOztBQUVBeEYsZUFBdUJxQjtVQUN0Qm9FO0FBQ0Q7O0FBRUEsU0FBU0M7SUFDTCxPQUFBO1FBQ0FDLFVBQUE7UUFDQUMsY0FBd0I7UUFDeEJDLGFBQWE7UUFDYkMsZUFBQTtRQUNBQztRQUNBQyxtQkFBQTs7QUFFSjs7QUFFQSxPQUFnQnpCLFlBQUFBLFlBQUFELGFBQUFBLGVBQUFOLGFBQ2QsZ0JBQ0EzQyxPQUNBcUU7O0FBSUYxRjtJQUNBLGlCQUFnQjtRQUNaTSxRQUFPQyxJQUFBO1FBQ1I7QUFDSDtJQUVFK0UsY0FBZ0I7SUFDaEJXLFlBQVk7SUFDZCxJQUEyQ0MsaUJBQUFqRyxZQUN2Qyx5Q0FDQTtJQUVGcUYsY0FBaUI7SUFDakJXLFlBQUk7SUFDTjtRQUNJRSxtQkFBY0Q7QUFDZCxNQUFBLE9BQU9FO1FBQ1I5RixRQUFBQyxJQUFBLFVBQUE2RjtBQUNIO0FBRUE7O0FBRUEsU0FBWUQsbUJBQWNEO0lBQ3hCM0IsV0FBSXVCLGdCQUFrQjtJQUNwQixJQUFBSSxZQUFBLE1BQUE7UUFDSixLQUNPQSxTQUFTRyxnQkFBYSxRQUFRSCxTQUFZRyxhQUFjck0sVUFBTyxPQUNoRWtNLFNBQUFJLGlCQUFBLFFBQUFKLFNBQUFJLGNBQUF0TSxVQUFBLElBQ0E7WUFDQXVLLFdBQVdxQjtZQUNYckIsV0FBV3NCLGNBQUM7WUFDWnZGLFFBQU9DLElBQUE7WUFDUjtBQUNEO1FBQ0FnRSxXQUFXcUI7UUFDWHJCLFdBQVdzQixjQUFpQjtRQUMxQnRCLFdBQVN5QixvQkFDWEUsU0FBV0ksY0FBZ0J0TSxTQUFBLElBQUEsWUFBQTtRQUN6QnVLLFdBQVN3Qiw0QkFDQU0sYUFBQ3JNLFNBQWtCLElBQUEsWUFBQTtRQUM5QnNHLFFBQUFDLElBQUE7UUFDQWdHLGVBQWVMLFNBQVNHLGNBQWU7UUFDdkNFLGVBQU9MLFNBQUFJLGVBQUE7UUFDRjtBQUNULFdBQWM7UUFDVi9CLFdBQVdxQjtRQUNYckIsV0FBV3NCLGNBQUM7UUFDWnZGLFFBQU9DLElBQUE7UUFDUjtBQUNGO0FBQ0Q7O0FBRUFQLGVBQWN1RyxlQUFNQyxNQUFBQztJQUNwQixJQUFXRCxRQUFBLE1BQUE7UUFDUjtBQUNEO0lBQ0YsS0FBUSxLQUFNRSxnQkFBU0YsS0FBQUcsV0FBQTtRQUNuQkMsS0FBS0Y7UUFDTEUsS0FBQUMsT0FBaUJKLFVBQVNLLFVBQUFBO1FBQzFCLE1BQUtDLG9CQUEwQnRDO1FBQy9CbUMsS0FBSzFCLDJCQUEyQjhCO1FBQ3BDSixLQUFBSyxnQkFBQUYsWUFBQUc7UUFFQSxJQUFVTixLQUFNTyxpQkFBUVAsS0FBQU8sTUFBQW5OLFVBQUEsR0FBQTtZQUNiNE0sS0FBQU8sUUFBQTtBQUNYLGVBQVU7WUFDSixJQUFJQywwQkFBa0JSLEtBQUFPLE9BQUFKLFlBQUFNO1lBQ3ZCVCxLQUFBTyxRQUFBQztBQUNMO1FBRUEsSUFBVVIsS0FBY1UsYUFBQSxRQUFRVixLQUFBVSxVQUFBdE4sVUFBQSxHQUFBO1lBQzFCNE0sS0FBS1csZ0JBQWM7WUFDZFgsS0FBQVksaUJBQUEzRixjQUFBO0FBQ0w7WUFDRSxJQUFBYyxXQUFrQmlFLEtBQUFVLGFBQUEsR0FBQTtnQkFDaEJWLEtBQUdXLGdCQUNBLE9BQUE1RSxXQUFBaUUsS0FBQVUsYUFBQSxLQUFBaEosUUFBQSxHQUFBRyxhQUFBO0FBQ0wsbUJBQUs7Z0JBQ2JtSSxLQUFxQlcsaUJBQ2Q1RSxXQUFBaUUsS0FBQVUsYUFBQSxLQUFBaEosUUFBQSxHQUFBRyxhQUFBO0FBQ0Q7WUFDRG1JLEtBQUFZLGlCQUFBM0YsY0FBQWMsV0FBQWlFLEtBQUFVO0FBQ0Q7UUFDQVYsS0FBS2Esa0JBQWlCYixLQUFPYyxpQkFBYyxJQUFLLFlBQVk7UUFDNURkLEtBQUtlLG9CQUFVQyxLQUFBQSxpQkFBZ0QsSUFBQSxZQUFFO1FBQ2xFaEIsS0FBQXhCLFVBQUFILGlCQUFBOEIsWUFBQTdCO0FBQ0Q7SUFDRixJQUFjdUIsU0FBQztRQUNObEMsV0FBQThCLGVBQUFHO0FBQ1QsV0FBYztRQUNYakMsV0FBQStCLGdCQUFBRTtBQUNGO0FBQ0Q7O0FBRUFsQyxZQUFldUQsMEJBQXVCLFNBQVNuQjtJQUMvQyxJQUFXQSxTQUFBbkMsV0FBQThCLGFBQUFyTSxRQUFBO1FBQ1I7QUFDRDtJQUNBOE4sZ0JBQThCdkQsV0FBQThCLGFBQVVLLE9BQUNoQztJQUMxQ3BFLFFBQUFDLElBQUEsb0JBQUFtRztBQUNEOztBQUVBcEMsWUFBZXlELDJCQUF3QixTQUFTckI7SUFDaEQsSUFBV0EsU0FBQW5DLFdBQUErQixjQUFBdE0sUUFBQTtRQUNSO0FBQ0Q7SUFDQThOLGdCQUE4QnZELFdBQUErQixjQUFXSSxPQUFBaEM7SUFDMUNwRSxRQUFBQyxJQUFBLG9CQUFBbUc7QUFDRDs7QUFFQSxJQUFTc0IsVUFBQTs7QUFDVCx5QkFBZXREO0lBQ1gsSUFBQXNELFNBQVc7UUFDWDFILFFBQU9DLElBQUE7UUFDUjtBQUNEO0lBQ0F5SCxVQUFRO0lBQ1IxSCxRQUFVQztJQUNWMEgsSUFBY2xGLE1BQUksc0VBQUUyQjtJQUNwQjVCLFFBQVFDO0lBQ1J6QyxRQUFBQyxJQUF1QixXQUFBd0M7SUFDckJFLFlBQVU7UUFDVitFLFVBQVE7UUFDVDFILFFBQVFDLElBQUEseUJBQUF5SDtBQUNWLFFBQUE7QUFDRDs7QUFFQSxJQUFBRSxxQkFBWTs7QUFDWjVELFlBQU82RCxrQ0FBb0JuSSxlQUFBMEc7SUFDdkIsS0FBQXdCLG9CQUFnQztRQUNoQzVILFFBQU9DLElBQUE7UUFDUjtBQUNEO0lBQ0EySCxxQkFBcUI7SUFDdEJBLDJCQUFBbEQsZUFBQVQsV0FBQThCLGNBQUFLO0FBQ0Q7O0FBRUFwQyxZQUFPOEQsbUNBQW9CcEksZUFBQTBHO0lBQ3ZCLEtBQUF3QixvQkFBZ0M7UUFDaEM1SCxRQUFPQyxJQUFBO1FBQ1I7QUFDRDtJQUNBMkgscUJBQXFCO0lBQ3RCQSwyQkFBQWxELGVBQUFULFdBQUErQixlQUFBSTtBQUNEOztBQUVBMUcsZUFBZWdGLGVBQWF3QixNQUFBRSxPQUFBRDtJQUN4QixJQUFBQyxTQUFXRixLQUFDeE0sUUFBQTtRQUNiLE9BQUE7QUFDRDtJQUNBLElBQU00TSxPQUFNSixLQUFBNkI7SUFDWixNQUFTQyxZQUFLekQsaUJBQUErQixLQUFBbEMsUUFBQWtDLEtBQUFjO0lBQ1osSUFBQSxLQUFPWSxLQUFLO1FBQ2IsT0FBQTtBQUNEO0lBQ0YsSUFBUTFCLEtBQWNjLGlCQUFLLEdBQUE7UUFDbEJkLEtBQUFjLGdCQUFBO0FBQ1QsV0FBUztRQUNOZCxLQUFBYyxnQkFBQTtBQUNEO0lBQ0FkLEtBQUthLGtCQUFpQmIsS0FBT2MsaUJBQWMsSUFBSyxZQUFZO0lBQzVEZCxLQUFBZSxvQkFBd0JmLEtBQUFjLGlCQUFBLElBQUEsWUFBQTtVQUMxQmpDO0lBMEJDLE9BQUE7QUFDRDs7QUFFQW5CLHdCQUFjdEUsZUFBQXVJLGFBQUEsTUFBQUMsV0FBQTtJQUNaQztVQUNBaEQ7SUFDRGlEO0FBQ0Q7O0FBR0FwRSxZQUFjcUUsYUFBWTNJLGVBQVFpQjtJQUNsQyxJQUFXQSxRQUFBLFFBQUFBLFFBQUEsQ0FBQSxHQUFBO1FBQ1I7QUFDRDtJQUNBLE1BQUEySCxhQUFtQnJFLFdBQVcrQjtJQUM1QnNDLG9CQUFpQixDQUFBQyxZQUFlbkMsT0FBT2tDO1FBQ3ZDLElBQUFFLGFBQVc3SCxLQUFBNEgsV0FBQW5FO1FBQ2ZwRSxRQUFPQyxJQUNQLDZCQUFRRSxLQUFBckcsVUFBQTBPLHVCQUFBRCxXQUFBbkU7UUFHUixrQkFBc0IsTUFBYTtZQUM3Qm1FLG1CQUFlQyxXQUFvQjNCO1lBQ2pDLElBQUF4RSxXQUF3Qm1HLFdBQUF4QixhQUFBLEdBQUE7Z0JBQ2hDdUIsV0FBZ0J0QixnQkFDSCxNQUFBNUUsV0FBQW1HLFdBQUF4QixXQUFBaEosUUFBQSxHQUFBRyxhQUFBO0FBQ0wsbUJBQUE7Z0JBQ1JvSywyQkFDT2xHLFdBQUFtRyxXQUFBeEIsV0FBQWhKLFFBQUEsR0FBQUcsYUFBQTtBQUNEO1lBQ05vSyxXQUFrQnJCLCtCQUNWN0UsV0FBQW1HLFdBQUF4QjtBQUVKO0FBQUE7SUFFSi9DLFdBQUErQixnQkFBQXNDO0lBRUUsTUFBQUcsWUFBa0J4RSxXQUFZOEI7SUFDNUIwQyxtQkFBaUIsQ0FBQUMsV0FBY3RDLE9BQU9xQztRQUN0QyxJQUFJRCxhQUFjN0gsS0FBSStILFVBQUV0RTtRQUM1Qix3QkFBa0M7WUFDNUJzRSxrQkFBZUYsV0FBb0IzQjtZQUNqQyxJQUFBeEUsV0FBdUJtRyxXQUFBeEIsYUFBQSxHQUFBO2dCQUMvQjBCLFVBQWdCekIsZ0JBQ0gsTUFBQTVFLFdBQUFtRyxXQUFBeEIsV0FBQWhKLFFBQUEsR0FBQUcsYUFBQTtBQUNMLG1CQUFBO2dCQUNSdUssMEJBQ09yRyxXQUFBbUcsV0FBQXhCLFdBQUFoSixRQUFBLEdBQUFHLGFBQUE7QUFDRDtZQUNOdUssVUFBa0J4QiwrQkFDVjdFLFdBQUFtRyxXQUFBeEI7QUFFSjtBQUFBO0lBRUgvQyxXQUFBOEIsZUFBQTBDO0FBQ0Q7O0FBR0EsU0FBY0w7SUFDZCxLQUFZbkQsWUFDTkEsVUFBUTBELGFBQWtCO1FBQzFCM0ksUUFBUUMsSUFBSyxnQkFBS2lGO1FBQ2xCQSxRQUFBQTtRQUNDQztBQUFPLFFBQ2I7QUFDRDs7QUFFQSxTQUFTZ0Q7SUFDUG5JLFFBQUFDLElBQUE7SUFDRDJJLGNBQUEzRCxVQUFBQSxVQUFBO0FBQ0Q7O0FBR0FqQixZQUFVNkUsV0FBSW5KO0lBQ1pNLFFBQUFDLElBQUE7SUFDQWtGO0lBQ0RpRDtBQUNEOztBQUVBcEUsWUFBQThFLFVBQUFwSixrQkFFQTs7QUFFQXNFLFlBQUErRSxVQUFBckosa0JBRUE7O0FBR0FzRSxZQUFVZ0YsU0FBSXRKO0lBQ1pNLFFBQUFDLElBQVk7SUFDYmtJO0FBQ0Q7O0FBR0FuRSxZQUFZaUYsV0FBYXZKLGVBQUF3SjtJQUN2QmpGLFdBQUFrRixZQUFBQztBQUNGOztBQUVBLFNBQVNBO0lBQ0wsSUFBQUMsTUFBUTtRQUNSQyxVQUFNO1FBQ1ZDO1lBQ1F0RyxRQUFNO2dCQUNOc0QsTUFBQTtnQkFDRGlELFdBQUE7O1lBRUZDLE1BQUE7OztJQUdKLE9BQUFKO0FBQ0Q7O0FBRUEsSUFBQUssZUFBb0I7O0FBQ3BCLFNBQU8vRDtJQUNQLElBQVcsS0FBQStELGtCQUFBQyxRQUFBO1FBQ1I7QUFDRDtJQUNGckosV0FBQXFGLFlBQUFnRSxTQUFBLElBQUE7OztBQzFVQSxTQUEyQkMsaUJBQU14SjtJQUNoQ2dELG1CQUFBaEQ7QUFDRDs7In0=
