var DP = 20, RM = 1, MAX_DP = 1e6, MAX_POWER = 1e6, NE = -7, PE = 21, NAME = "[big.js] ", INVALID = NAME + "Invalid ", INVALID_DP = INVALID + "decimal places", INVALID_RM = INVALID + "rounding mode", DIV_BY_ZERO = NAME + "Division by zero", P = {}, UNDEFINED = void 0, NUMERIC = /^-?(\d+(\.\d*)?|\.\d+)(e[+-]?\d+)?$/i;

function _Big_() {
    function Big(n) {
        var x = this;
        if (!(x instanceof Big)) return n === UNDEFINED ? _Big_() : new Big(n);
        if (n instanceof Big) {
            x.s = n.s;
            x.e = n.e;
            x.c = n.c.slice();
        } else {
            parse(x, n);
        }
        x.constructor = Big;
    }
    Big.prototype = P;
    Big.DP = DP;
    Big.RM = RM;
    Big.NE = NE;
    Big.PE = PE;
    Big.version = "5.2.2";
    return Big;
}

function parse(x, n) {
    var e, i, nl;
    if (n === 0 && 1 / n < 0) n = "-0"; else if (!NUMERIC.test(n += "")) throw Error(INVALID + "number");
    x.s = n.charAt(0) == "-" ? (n = n.slice(1), -1) : 1;
    if ((e = n.indexOf(".")) > -1) n = n.replace(".", "");
    if ((i = n.search(/e/i)) > 0) {
        if (e < 0) e = i;
        e += +n.slice(i + 1);
        n = n.substring(0, i);
    } else if (e < 0) {
        e = n.length;
    }
    nl = n.length;
    for (i = 0; i < nl && n.charAt(i) == "0"; ) ++i;
    if (i == nl) {
        x.c = [ x.e = 0 ];
    } else {
        for (;nl > 0 && n.charAt(--nl) == "0"; ) ;
        x.e = e - i - 1;
        x.c = [];
        for (e = 0; i <= nl; ) x.c[e++] = +n.charAt(i++);
    }
    return x;
}

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

var Big = _Big_();

var upColorList;

var downColorList;

var commanData = {
    symbolInfo: {},
    priceColorType: 0,
    marketData: {},
    iconURLHost: "",
    iconPlaceholder: "",
    rateTypeStr: 0,
    colorMode: 0,
    OS: "",
    appVersion: "",
    isInReview: 1,
    isLogin: 0,
    serviceTimeInterval: 0,
    hasNewVersion: false,
    userInfo: {}
};

async function sendRequest(path, params = {}, method = 0, hostType = 0, header = {}) {
    console.log(`request ${path}`);
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
        var responseString = "";
        if (commanData.OS == 0) {
            responseString = await $nativeAPI.homeRequest(JSON.stringify(param));
        } else {
            responseString = await $nativeAPI.request(JSON.stringify(param));
        }
        var response = JSON.parse(responseString);
        var {code: code, data: data} = response;
        if (code == 200) {
            console.log(`request ${path} done`);
            return data;
        } else {
            console.log(`request failed, code=${code}`);
            return null;
        }
    } catch (e) {
        console.log(`request error, error=${e}`);
        return null;
    }
}

async function sendRequestWithCache(path, callback, params = {}, method = 0, hostType = 0, header = {}, cacheKeyList = null) {
    var cacheKey = getCacheKey(path, params, cacheKeyList);
    const cache = await read("apiCache", cacheKey);
    if (cache && callback) {
        try {
            await callback(cache, true);
            console.log(`sendRequestWithCache cache, cache=${JSON.stringify(cache)} cacheKey=${cacheKey}`);
            await uploadLog("HOME", `读缓存成功, cacheKey=${cacheKey}`);
        } catch (error) {}
    }
    const requestData = await sendRequest(path, params, method, hostType, header);
    if (requestData) {
        if (callback) {
            try {
                await callback(requestData, false);
                await uploadLog("HOME", `网路请求成功,path=${path}`);
            } catch (error) {}
        }
        await save("apiCache", cacheKey, requestData);
        await uploadLog("HOME", `缓存保存成功, cacheKey=${cacheKey}`);
        console.log(`sendRequestWithCache requestData, requestData=${JSON.stringify(requestData)} cacheKey=${cacheKey}`);
    } else {
        await callback(null, false);
        console.log(`sendRequestWithCache error`);
        await uploadLog("HOME", `网路请求失败,path=${path}`);
    }
    return requestData;
}

function getCacheKey(path, params, cacheKeyList = null) {
    var cacheKey = "";
    if (cacheKeyList == null) {
        var paramStr = JSON.stringify(params);
        cacheKey = `${path}_${paramStr}_${commanData.language}_${commanData.colorMode}`;
    } else if (cacheKeyList.length == 0) {
        cacheKey = `${path}_${commanData.language}_${commanData.colorMode}`;
    } else {
        var cacheKeyListStr = cacheKeyList.join("_");
        cacheKey = `${path}_${cacheKeyListStr}_${commanData.language}_${commanData.colorMode}`;
    }
    return cacheKey;
}

function getSymbolInfo(symbol) {
    var symbolInfo = commanData.symbolInfo[symbol];
    if (symbolInfo == null) {
        console.log(`getSymbolInfo fail ${symbol}`);
    }
    return symbolInfo;
}

function getIconURL(currency) {
    var coinName = currency.toLowerCase();
    const iconURL = `https://${commanData.iconURLHost}/-/x/hb/p/api/contents/currency/icon_png/${coinName}.png`;
    return iconURL;
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
    const priceNum = Number(priceStr);
    const bigValue = new Big(priceNum);
    const priceString = bigValue.toFixed(precision, {
        notation: "fixed",
        precision: precision
    });
    const finalPriceStr = priceString.replace(/\d(?=(\d{3})+\.)/g, "$&,");
    return finalPriceStr;
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

async function openURL(url, params = {}) {
    if (!clickThrottle()) return;
    await $nativeAPI.homeBridge({
        action: "openPage",
        type: "url",
        page: url,
        params: JSON.stringify(params)
    });
}

async function openPage(page, params = {}) {
    await $nativeAPI.homeBridge({
        action: "openPage",
        type: "native",
        page: page,
        params: JSON.stringify(params)
    });
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

async function clear(module, key) {
    await $nativeAPI.storage({
        action: "clear",
        name: module,
        key: key
    });
}

async function uploadLog(tag, info = "") {
    if (commanData.OS == 0) {
        var map = {
            tag: tag,
            info: info
        };
        await $nativeAPI.uploadLog(map);
    }
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

function sendLoginStatus$1(data) {
    commanData.isLogin = parseInt(data.isLogin);
    if (data.userInfo != null) {
        commanData.userInfo.name = data.userInfo.name;
        commanData.userInfo.uId = data.userInfo.uId;
        commanData.userInfo.isChildAccount = parseInt(data.userInfo.isChildAccount);
        commanData.userInfo.headImage = data.userInfo.headImage;
        commanData.userInfo.isNFT = parseInt(data.userInfo.isNFT);
        commanData.userInfo.countryId = data.userInfo.countryId;
        commanData.userInfo.registerCountryId = data.userInfo.registerCountryId;
    }
    console.log(`isLogin = ${commanData.isLogin}`);
}

function sendCommonConfig$1(param) {
    commanData.priceColorType = parseInt(param.priceColorType);
    commanData.colorMode = parseInt(param.colorMode);
    commanData.iconURLHost = param.iconURLHost;
    commanData.iconPlaceholder = param.iconPlaceholder;
    commanData.OS = parseInt(param.OS);
    commanData.appVersion = param.appVersion;
    commanData.isInReview = parseInt(param.isInReview);
    commanData.language = param.language;
    commanData.appLifeCycleId = param.appLifeCycleId;
    commanData.hasNewVersion = param.hasNewVersion;
    console.log(`colorMode = ${commanData.colorMode}`);
    console.log(`isInReview = ${commanData.isInReview}`);
    var redColorList = [ "#ADB0B2", "#E94359", "#E94359", "#E94359" ];
    var greenColorList = [ "#ADB0B2", "#00A171", "#00A171", "#00A171" ];
    if (parseInt(commanData.priceColorType) == 0) {
        upColorList = redColorList;
        downColorList = greenColorList;
    } else {
        upColorList = greenColorList;
        downColorList = redColorList;
    }
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

async function setModuleStatus(moduleName, statusType) {
    var status = "showLoading";
    switch (statusType) {
      case 0:
        status = "showLoading";
        break;

      case 1:
        status = "hideLoading";
        break;

      case 2:
        status = "hideModule";
        break;
    }
    console.log(`${moduleName} setModuleStatus ${status}`);
    await $nativeAPI.homeBridge({
        action: "setModuleStatus",
        status: status,
        moduleName: moduleName
    });
}

function getVisibilityStatus(show) {
    if (typeof show === "boolean") {
        return show ? "visible" : "gone";
    } else if (typeof show === "number") {
        return show !== 0 ? "visible" : "gone";
    } else {
        return "gone";
    }
}

function formatDate(date, fmt) {
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    let o = {
        "M+": date.getMonth() + 1,
        "d+": date.getDate(),
        "h+": date.getHours(),
        "m+": date.getMinutes(),
        "s+": date.getSeconds()
    };
    for (let k in o) {
        if (new RegExp(`(${k})`).test(fmt)) {
            console.log(RegExp.$1);
            let str = o[k] + "";
            fmt = fmt.replace(RegExp.$1, RegExp.$1.length === 1 ? str : padLeftZero(str));
        }
    }
    return fmt;
}

function padLeftZero(str) {
    return ("00" + str).substr(str.length);
}

async function requestServicesTime() {
    var timerIntervalInfo = await sendRequest("/v1/config/push/timer");
    console.log(`timerIntervalInfo = ${timerIntervalInfo}`);
    if (timerIntervalInfo != null) {
        let currentTimeInterval = (new Date).getTime();
        commanData.serviceTimeInterval = timerIntervalInfo - currentTimeInterval;
    }
}

var moduleDidStart$6 = false;

async function start$8() {
    moduleDidStart$6 = true;
    await setModuleStatus("nav", 1);
    await requestNavData();
    refreshAvatar();
}

function defaultData$8() {
    return {
        currentIndex: 0,
        userInfo: {},
        searchData: {},
        rewardsData: {},
        rewardsImage: "",
        rewardsVisibility: "gone",
        rewardsRedDotVisibility: "gone",
        messageCount: 0,
        noticeCount: 0,
        messageVisibility: "gone",
        noticeVisibility: "gone",
        redDotVisible: "gone",
        numRedDotVisible: "gone",
        hotVisibility: "gone"
    };
}

const {moduleData: moduleData$8, moduleEvent: moduleEvent$8} = moduleDefine("nav", start$8, defaultData$8);

async function moduleAppear$8() {}

async function moduleDisappear$8() {}

moduleEvent$8.moduleAppear = moduleAppear$8;

moduleEvent$8.moduleDisappear = moduleDisappear$8;

var imMgsCount = 0;

var activityCount = 0;

var noticeCount = 0;

var lastTime$1;

var searchDataCache;

async function searchDataCallback(searchData, isCache) {
    console.log(`isCache = ${isCache}`);
    if (searchData && searchData != "") {
        if (searchData.hotWordContext && searchData.hotWordContext.hotWords && searchData.hotWordContext.hotWords.length > 0) {
            for (var i = 0; i < searchData.hotWordContext.hotWords.length; i++) {
                var element = searchData.hotWordContext.hotWords[i];
                element.cellType = "1";
                element.wrodIndex = String(i);
            }
            moduleData$8.hotVisibility = "visible";
        } else {
            moduleData$8.hotVisibility = "gone";
        }
        searchDataCache = searchData;
        moduleData$8.searchData = searchData;
    }
    await setModuleStatus("nav", 1);
}

function rewardsDataCallback(rewardsData, isCache) {
    if (rewardsData) {
        moduleData$8.rewardsData = rewardsData;
        if (commanData.colorMode == 1) {
            moduleData$8.rewardsImage = rewardsData.navigationNightImgUrl;
        } else {
            moduleData$8.rewardsImage = rewardsData.navigationDayImgUrl;
        }
        if (!isCache) {
            moduleData$8.rewardsRedDotVisibility = commanData.isLogin == 1 && rewardsData.rewardCenterFlag ? "visible" : "gone";
        }
        console.log(`navnav rewardsDataCallback rewardCenterFlag:${rewardsData.rewardCenterFlag} ${moduleData$8.rewardsRedDotVisibility}`);
    }
    if (moduleData$8.rewardsImage) {
        moduleData$8.rewardsVisibility = "visible";
    } else {
        moduleData$8.rewardsVisibility = "gone";
    }
}

async function requestNavData() {
    moduleData$8.userInfo = commanData.userInfo;
    await sendRequestWithCache("v1/hbg/open/invite/appSearch/list", callback = searchDataCallback);
    if (commanData.isInReview != 1) {
        await sendRequestWithCache("v1/app/home/commonData", callback = rewardsDataCallback);
    } else {
        moduleData$8.rewardsVisibility = "gone";
    }
    await requestMessageCount();
}

function updateMessageCount() {
    if (commanData.isLogin != 1) {
        activityCount = 0;
        imMgsCount = 0;
        noticeCount = 0;
        moduleData$8.messageVisibility = "gone";
        moduleData$8.noticeVisibility = "gone";
        return;
    }
    console.log(`updateMessageCount:imMgsCount = ${imMgsCount}`);
    console.log(`updateMessageCount:activityCount = ${activityCount}`);
    console.log(`updateMessageCount:noticeCount = ${noticeCount}`);
    var messageCount = activityCount + imMgsCount;
    if (messageCount > 99) {
        moduleData$8.messageCount = "99+";
    } else {
        moduleData$8.messageCount = String(messageCount);
    }
    console.log(`updateMessageCount:messageCount = ${messageCount}`);
    moduleData$8.noticeCount = String(noticeCount);
    if (messageCount > 0) {
        moduleData$8.messageVisibility = "visible";
        moduleData$8.noticeVisibility = "gone";
    } else {
        moduleData$8.messageVisibility = "gone";
        if (noticeCount > 0) {
            moduleData$8.noticeVisibility = "visible";
        } else {
            moduleData$8.noticeVisibility = "gone";
        }
    }
}

function sendUnreadMessage(data) {
    imMgsCount = parseInt(data.count);
    console.log(`sendUnreadMessage:imMgsCount = ${imMgsCount}`);
    updateMessageCount();
}

async function checkMessageCountTimer() {
    if (moduleDidStart$6 == false) {
        return;
    }
    const currentTime = (new Date).getTime();
    if (currentTime - lastTime$1 > 60 * 1e3) {
        await requestMessageCount();
    }
}

function refreshAvatar() {
    if (moduleDidStart$6 == false) {
        return;
    }
    $data.nav.refreshAvatar = "1";
    requestAvatar();
}

async function requestAvatar() {
    var isKyc = false;
    if (commanData.isLogin != 1 || commanData.userInfo.isChildAccount == 1) {
        isKyc = false;
    } else {
        var userGetData = await sendRequest("uc/open/user/get", {}, 0, 5);
        if (userGetData != null) {
            if (!userGetData.kyc_level || userGetData.kyc_level == null || userGetData.kyc_level.length == 0) {
                isKyc = true;
            }
        }
    }
    const isHtx = commanData.hasNewVersion;
    const params = {
        isHtx: isHtx,
        isKyc: isKyc
    };
    var redDotData = await sendRequest("v1/hbg/myhome/redDot/queryUserRedDot", params);
    console.log(redDotData.redDotNum, redDotData.redDot);
    moduleData$8.numRedDotLeft = 36;
    if (redDotData.redDotNum && redDotData.redDotNum > 0) {
        if (redDotData.redDotNum > 99) {
            moduleData$8.numRedDotLeft = 30;
            moduleData$8.redDotNum = "99+";
        } else {
            moduleData$8.redDotNum = `${redDotData.redDotNum}`;
        }
        moduleData$8.numRedDotVisible = "visible";
        moduleData$8.redDotVisible = "gone";
    } else if (redDotData.redDot) {
        moduleData$8.numRedDotVisible = "gone";
        moduleData$8.redDotVisible = "visible";
    } else {
        moduleData$8.redDotVisible = "gone";
        moduleData$8.numRedDotVisible = "gone";
    }
}

async function requestMessageCount() {
    console.log("requestMessageCount");
    if (commanData.isLogin != 1) {
        updateMessageCount();
        return;
    }
    var params = {
        exchange_id: "1",
        template_code: [ "1.PRO.CONTENT_PRAISE_ALL_MSG", "1.PRO.CONTENT_COMMENT_ALL_MSG", "1.PRO.CONTENT_FOCUS_USER_MSG" ]
    };
    var countData = await sendRequest("uc/open/letter/v3/list_by_code", params, 1, 5, {});
    if (countData) {
        activityCount = parseInt(countData.sum_sub_un_read);
        noticeCount = parseInt(countData.sum_un_read_except_code);
        const letterType = parseInt(countData.letter_sub_type);
        if (letterType == 2) {
            noticeCount = 0;
        }
        updateMessageCount();
    }
    console.log("requestMessageCount done");
    lastTime$1 = (new Date).getTime();
    console.log(`lastTime = ${lastTime$1}`);
}

function hotIndexChange(index) {
    moduleData$8.currentIndex = index;
}

async function goToSearch(index) {
    console.log(`goToSearch start ${index}`);
    var hotwords = searchDataCache && searchDataCache.hotWordContext && searchDataCache.hotWordContext.hotWords != null ? searchDataCache.hotWordContext.hotWords[index] : "";
    await openPage("search", hotwords);
    await analytics("appClick_home", {
        module_name: "topbar",
        button_name: "search",
        pre_text: hotwords.word
    });
}

async function goToScan() {
    await openPage("scan", {});
    await analytics("appClick_home", {
        module_name: "topbar",
        button_name: "scan"
    });
}

async function goToIM() {
    await openPage("im", {});
    var badges = "";
    if ($data.nav.messageVisibility == "visible") {
        badges = String($data.nav.messageCount);
    } else if ($data.nav.noticeVisibility == "visible") {
        badges = "redDot";
    }
    await analytics("appClick_home", {
        module_name: "topbar",
        button_name: "message",
        superscript: badges
    });
}

async function goToRewards() {
    await openURL(moduleData$8.rewardsData.navigationJumpUrl, {});
    var badges = "";
    if ($data.nav.rewardsRedDotVisibility == "visible") {
        badges = "redDot";
    }
    console.log(`navnav goToRewards badges:${badges} rewardsRedDotVisibility：${$data.nav.rewardsRedDotVisibility}`);
    await analytics("appClick_home", {
        module_name: "topbar",
        button_name: "welfare",
        superscript: badges
    });
}

async function goToUser() {
    await openURL("holigeit://open/v1?url=ihuobiglobal://m.hbg.com/newAccount/index", {});
    await analytics("appClick_home", {
        module_name: "topbar",
        button_name: "me"
    });
}

async function loginStateChange$3() {
    if (commanData.isLogin != 1) {
        moduleData$8.rewardsRedDotVisibility = "gone";
    }
}

moduleEvent$8.loginStateChange = loginStateChange$3;

moduleEvent$8.sendUnreadMessage = sendUnreadMessage;

moduleEvent$8.goToSearch = goToSearch;

moduleEvent$8.goToScan = goToScan;

moduleEvent$8.goToIM = goToIM;

moduleEvent$8.goToRewards = goToRewards;

moduleEvent$8.hotIndexChange = hotIndexChange;

moduleEvent$8.goToUser = goToUser;

var moduleDidStart$5 = false;

async function start$7() {
    moduleDidStart$5 = true;
    await readThirdSymbolIndex();
    await requestTopContractSymbols();
}

function defaultData$7() {
    return {
        list: []
    };
}

var thirdIndex = 2;

const {moduleData: moduleData$7, moduleEvent: moduleEvent$7} = moduleDefine("market", start$7, defaultData$7);

async function moduleAppear$7() {}

async function moduleDisappear$7() {}

moduleEvent$7.moduleAppear = moduleAppear$7;

moduleEvent$7.moduleDisappear = moduleDisappear$7;

function resetMarketData$1() {
    if (moduleDidStart$5 == false) {
        return;
    }
    for (let i = 0; i < moduleData$7.list.length; i++) {
        var item = moduleData$7.list[i];
        const coinDict = commanData.marketData[item.symbol];
        if (coinDict == null) {
            continue;
        }
        const symbolInfo = getSymbolInfo(item.symbol);
        if (coinDict.decimalcPrice > 0) {
            item.currentPrice = getPriceString(coinDict.decimalcPrice, symbolInfo.tradePricePrecision);
        }
        let upDown = coinDict.decimalDelta.toFixed(2);
        item.ratio = formatRatio(upDown);
        item.ratioColor = getPriceColor(upDown);
    }
}

async function requestTopContractSymbols() {
    let data = await sendRequest("v1/app/topMarketSymbols");
    if (data == null || data.length == 0) {
        if (moduleData$7.list.length == 0) {
            await setModuleStatus("market", 2);
        }
        return;
    }
    var array = [];
    for (var i = 0; i < data.length; i++) {
        if (array.length < 3) {
            if (array.length == 2 && thirdIndex < data.length) {
                if (i == thirdIndex) {
                    var model = await handleTopSymbolModel(data[i]);
                    model.index = "2";
                    array.push(model);
                }
            } else {
                var model = await handleTopSymbolModel(data[i]);
                model.index = String(i);
                array.push(model);
            }
        }
    }
    moduleData$7.list = array;
    if (array.length == 0) {
        await setModuleStatus("market", 2);
    } else {
        if (commanData.marketData != null) {
            resetMarketData$1();
        }
        await setModuleStatus("market", 1);
    }
}

async function handleTopSymbolModel(obj) {
    var symbolModel = obj;
    symbolModel.productTitle = `${obj.baseCurrency.toUpperCase()}/${obj.quoteCurrency.toUpperCase()}`;
    symbolModel.cellType = "normal";
    const symbolInfo = getSymbolInfo(obj.symbol);
    var priceStr = "--";
    const coinDict = commanData.marketData[obj.symbol];
    if (coinDict != null) {
        var price = coinDict.decimalcPrice;
        priceStr = getPriceString(price, symbolInfo.tradePricePrecision);
    } else {
        if (obj.price != null && obj.price.length > 0) {
            priceStr = getPriceString(obj.price, symbolInfo.tradePricePrecision);
        } else {
            priceStr = "--";
        }
    }
    symbolModel.currentPrice = priceStr;
    let upDown;
    if (coinDict != null) {
        upDown = coinDict.decimalDelta.toFixed(2);
    } else {
        upDown = handleRtio(obj.upDown);
    }
    symbolModel.ratio = formatRatio(upDown);
    symbolModel.ratioColor = getPriceColor(upDown);
    return symbolModel;
}

function handleRtio(number) {
    return (100 * number).toFixed(2);
}

function formatRatio(upDown) {
    let prefix = upDown > 0 ? "+" : "";
    return `${prefix}${upDown.toString()}%`;
}

async function readThirdSymbolIndex() {
    var indexMap = await read("market", "thirdSymbolIndexMap");
    if (indexMap) {
        if (indexMap.appLifeID != commanData.appLifeCycleId) {
            indexMap.appLifeID = commanData.appLifeCycleId;
            if (indexMap.index == "2") {
                indexMap.index = "3";
                thirdIndex = 3;
            } else {
                indexMap.index = "2";
                thirdIndex = 2;
            }
            await save("market", "thirdSymbolIndexMap", indexMap);
        } else {
            thirdIndex = parseInt(indexMap.index);
        }
    } else {
        thirdIndex = 2;
        indexMap = {
            appLifeID: commanData.appLifeCycleId,
            index: "2"
        };
        await save("market", "thirdSymbolIndexMap", indexMap);
    }
}

moduleEvent$7.jumpToKline = async function(index) {
    if (index) {
        let i = parseInt(index);
        let model = moduleData$7.list[i];
        let param = {};
        param.symbol = model.symbol;
        param.tradeCategoryType = "0";
        await openPage("kline", param);
        let upDown = handleRtio(model.upDown);
        let chg = "rise";
        if (upDown < 0) {
            chg = "fall";
        } else if (upDown == 0) {
            chg = "horizontal";
        }
        await analytics("appClick_home", {
            module_name: "symbol",
            module_position: i + 1,
            chg: chg,
            name: model.productTitle
        });
    }
};

var moduleDidStart$4 = false;

var currentCacheKey;

async function start$6() {
    moduleDidStart$4 = true;
    await requestUserRegistryTransferGuide();
}

function defaultData$6() {
    return {};
}

const {moduleData: moduleData$6, moduleEvent: moduleEvent$6} = moduleDefine("guide", start$6, defaultData$6);

async function moduleAppear$6() {}

async function moduleDisappear$6() {}

moduleEvent$6.moduleAppear = moduleAppear$6;

moduleEvent$6.moduleDisappear = moduleDisappear$6;

async function requestUserRegistryTransferGuide() {
    var cacheKey = `${commanData.isLogin}_${commanData.userInfo.uId}`;
    if (commanData.isLogin == 2) {
        moduleData$6.show = "gone";
        await setModuleStatus("guide", 2);
        return;
    }
    if (currentCacheKey == null || cacheKey != currentCacheKey) {
        moduleData$6.show = "gone";
        await setModuleStatus("guide", 2);
    }
    let data = await sendRequest("v1/app/guide/userRegistryTransferGuide");
    if (data == null) {
        moduleData$6.show = "gone";
        await setModuleStatus("guide", 2);
        return;
    }
    if (data.taskProgress > 1) {
        moduleData$6.show = "gone";
        await setModuleStatus("guide", 2);
        return;
    }
    var titleColor = "#000000";
    if (commanData.colorMode == 1) {
        titleColor = "#E6E6E6";
    }
    var title = data.title.replace(/{|}/g, (function(match) {
        return match === "{" ? "</span><span style='color:#FE8731; font-size:22px;'>" : `</span><span style='color:${titleColor}; font-size:22px;'>`;
    }));
    title = `<span style='color:${titleColor}; font-size:22px;'>${title}</span>`;
    console.log(`title=${title}`);
    moduleData$6.title = title;
    moduleData$6.subTitle = data.subTitle;
    moduleData$6.taskProgress = data.taskProgress;
    moduleData$6.totalAward = data.totalAward;
    moduleData$6.material_name = data.material_name;
    currentCacheKey = cacheKey;
    if (data.taskProgress == 1) {
        moduleData$6.buttonTitle = $i18n.n_index_amount_immediately;
        moduleData$6.show = "visible";
        await setModuleStatus("guide", 1);
    } else if (data.taskProgress == 0) {
        moduleData$6.buttonTitle = $i18n.n_home_login_register;
        moduleData$6.show = "visible";
        await setModuleStatus("guide", 1);
    } else {
        moduleData$6.show = "gone";
        await setModuleStatus("guide", 2);
    }
    if (commanData.OS == 0) {
        await $nativeAPI.homeBridge({
            action: "refreshTable",
            data: ""
        });
    }
}

async function loginStateChange$2() {
    if (moduleDidStart$4 == false) {
        return;
    }
    var cacheKey = `${commanData.isLogin}_${commanData.userInfo.uId}`;
    if (currentCacheKey == null || cacheKey != currentCacheKey) {
        moduleData$6.show = "gone";
        await setModuleStatus("guide", 2);
    }
}

moduleEvent$6.openGuidPage = async function() {
    var button_name = "";
    if (moduleData$6.taskProgress == 1) {
        await openPage("guide");
        button_name = "deposit";
    } else if (moduleData$6.taskProgress == 0) {
        await openPage("login");
        button_name = "login";
    }
    await analytics("appClick_home", {
        module_name: "guidance",
        button_name: button_name,
        material_name: $data.guide.material_name
    });
};

var moduleDidStart$3 = false;

async function start$5() {
    moduleDidStart$3 = true;
    await requestInvestDrawerData();
}

function defaultData$5() {
    return {
        showTitleText: "",
        url: "",
        visibility: "gone",
        tradingToEarn: {},
        contractCopyTrade: {},
        dual: {},
        spot: {}
    };
}

const {moduleData: moduleData$5, moduleEvent: moduleEvent$5} = moduleDefine("invest", start$5, defaultData$5);

async function moduleAppear$5() {
    await analyticsAppear$2();
}

async function moduleDisappear$5() {}

moduleEvent$5.moduleAppear = moduleAppear$5;

moduleEvent$5.moduleDisappear = moduleDisappear$5;

var needAnalyticsWhenRequestSuccess$2 = false;

async function analyticsAppear$2() {
    if (moduleData$5.visibility == "gone") {
        needAnalyticsWhenRequestSuccess$2 = true;
        return;
    }
    needAnalyticsWhenRequestSuccess$2 = false;
    var typeList = [];
    if (moduleData$5.tradingToEarn.visibility == "visible") {
        typeList.push("tradingToEarn");
    } else if (moduleData$5.spot.visibility == "visible") {
        typeList.push("SpotGrid");
    } else if (moduleData$5.contractCopyTrade.visibility == "visible") {
        typeList.push("contractCopyTrade");
    } else if (moduleData$5.dual.visibility == "visible") {
        typeList.push("Dual");
    }
    const typeStr = typeList.join(",");
    await analytics("appExposure_home", {
        module_name: "invest",
        type: typeStr
    });
}

moduleEvent$5.moreTapAction = async function() {
    let jumpUrl = encodeURI(moduleData$5.url);
    await openURL(jumpUrl);
    await analytics("appClick_home", {
        module_name: "invest",
        type: "more"
    });
};

moduleEvent$5.tapAction = async function(key) {
    var jumpUrl = "";
    var module_position = 0;
    var typeStr = "";
    if (key == "tradingToEarn") {
        jumpUrl = encodeURI(moduleData$5.tradingToEarn.url);
        module_position = moduleData$5.tradingToEarn.module_position;
        typeStr = "tradingToEarn";
    } else if (key == "spot") {
        jumpUrl = encodeURI(moduleData$5.spot.url);
        module_position = moduleData$5.spot.module_position;
        typeStr = "SpotGrid";
    } else if (key == "contractCopyTrade") {
        jumpUrl = encodeURI(moduleData$5.contractCopyTrade.url);
        module_position = moduleData$5.contractCopyTrade.module_position;
        typeStr = "contractCopyTrade";
    } else if (key == "dual") {
        jumpUrl = encodeURI(moduleData$5.dual.url);
        module_position = moduleData$5.dual.module_position;
        typeStr = "Dual";
    }
    await openURL(jumpUrl);
    await analytics("appClick_home", {
        module_name: "invest",
        module_position: String(module_position),
        type: typeStr
    });
};

async function runTradingToEarnCountDown() {
    if (moduleDidStart$3 == false) {
        return;
    }
    if (moduleData$5.tradingToEarn.activityStatus === 0 || moduleData$5.tradingToEarn.activityStatus === 1) {
        const remainingTime = Math.max(0, moduleData$5.tradingToEarn.remainTime - 1e3);
        let times = handleShowTime$1(remainingTime);
        moduleData$5.tradingToEarn.remainTime = remainingTime;
        moduleData$5.tradingToEarn.countDownTimeStr = `${moduleData$5.tradingToEarn.showScheduleText}:${times}`;
        if (remainingTime === 0) {
            moduleData$5.tradingToEarn.showRemain = getVisibilityStatus(false);
            await requestInvestDrawerData();
        } else {
            moduleData$5.tradingToEarn.showRemain = getVisibilityStatus(true);
        }
    }
}

async function investDataCallBack(data, isCache) {
    await setModuleStatus("invest", 1);
    if ((moduleData$5.tradingToEarn || moduleData$5.spot || moduleData$5.contractCopyTrade || moduleData$5.dual) && isCache) {
        return;
    }
    moduleData$5.showTitleText = data.showTitleText;
    moduleData$5.visibility = getVisibilityStatus(data.show);
    moduleData$5.url = data.url;
    var module_position = 1;
    moduleData$5.tradingToEarn = handleTradingToEarn(data.tradingToEarn);
    moduleData$5.tradingToEarn.module_position = module_position;
    if (moduleData$5.tradingToEarn.visibility == "visible") {
        module_position += 1;
    }
    let spot = data.spot;
    spot.key = "spot";
    spot.visibility = getVisibilityStatus(data.spot.show);
    spot.imgVisibility = spot.img != undefined && spot.img != null && spot.img.length > 0 ? "visible" : "gone";
    spot.showSubTitleText = spot.showSubTitleText != undefined && spot.showSubTitleText != null && spot.showSubTitleText.length > 0 ? spot.showSubTitleText : spot.nick;
    spot.totalProfitAmount = getAmountPriceStr(spot.totalProfitAmount);
    spot.module_position = module_position;
    moduleData$5.spot = spot;
    if (spot.visibility == "visible") {
        module_position += 1;
    }
    let contractCopyTrade = data.contractCopyTrade;
    contractCopyTrade.key = "contractCopyTrade";
    contractCopyTrade.visibility = getVisibilityStatus(data.contractCopyTrade.show);
    contractCopyTrade.totalProfitAmount = getAmountPriceStr(contractCopyTrade.totalProfitAmount);
    contractCopyTrade.module_position = module_position;
    moduleData$5.contractCopyTrade = contractCopyTrade;
    if (contractCopyTrade.visibility == "visible") {
        module_position += 1;
    }
    moduleData$5.dual = handleDual(data);
    moduleData$5.dual.module_position = module_position;
}

function getAmountPriceStr(price) {
    if (price == null) {
        return "$--";
    }
    var priceStr = String(price);
    priceStr = priceStr.replace("$", "");
    var amountStr = getPriceString(priceStr, 2);
    return `$${amountStr}`;
}

async function requestInvestDrawerData() {
    await sendRequestWithCache("v1/app/invest/drawer/getData", callback = investDataCallBack);
    if (moduleData$5.visibility === "visible") {
        await setModuleStatus("invest", 1);
        if (needAnalyticsWhenRequestSuccess$2 == true) {
            await analyticsAppear$2();
        }
    } else {
        await setModuleStatus("invest", 2);
    }
}

function handleDual(data) {
    let dual = data.dual;
    dual.key = "dual";
    dual.visibility = getVisibilityStatus(data.dual.show);
    if (data.dual.currency) {
        dual.imgCurrency = getIconURL(data.dual.currency);
    } else {
        dual.imgCurrency = "@drawable/home_coin_placeholder_24";
    }
    if (data.dual.covertCurrency) {
        dual.imgeCovertCurrency = getIconURL(data.dual.covertCurrency);
    } else {
        dual.imgeCovertCurrency = "@drawable/home_coin_placeholder_24";
    }
    dual.rateTitle = "APY";
    let apy = data.dual.apy;
    dual.apyPercent = formatNumber(apy);
    return dual;
}

function handleTradingToEarn(data) {
    let tradingToEarn = data;
    tradingToEarn.key = "tradingToEarn";
    tradingToEarn.visibility = getVisibilityStatus(data.show);
    let apyPercent = data.apyPercent;
    tradingToEarn.apyPercent = formatNumber(apyPercent);
    if (data.symbol) {
        tradingToEarn.symbol = data.symbol.toUpperCase();
    }
    let prizeAmount = data.prizeAmount != null ? parseInt(data.prizeAmount) : 1;
    let prizeAmountDisplay = `/${formatNumberWithCommas(prizeAmount)}`;
    let allocatedScore = data.allocatedScore != null ? parseInt(data.allocatedScore) : 1;
    let allocatedScoreDisplay = formatNumberWithCommas(allocatedScore);
    let remainingProportion = prizeAmount - allocatedScore;
    if (allocatedScore > 0) {
        tradingToEarn.usedProportionShow = getVisibilityStatus(true);
    } else {
        allocatedScore = 2;
        tradingToEarn.usedProportionShow = getVisibilityStatus(false);
    }
    tradingToEarn.usedProportion = String(allocatedScore);
    if (remainingProportion > 0) {
        tradingToEarn.remainingProportionShow = getVisibilityStatus(true);
    } else {
        remainingProportion = 2;
        tradingToEarn.remainingProportionShow = getVisibilityStatus(false);
    }
    tradingToEarn.remainingProportion = String(remainingProportion);
    console.log(`usedProportion ${tradingToEarn.usedProportion}  remainingProportion  ${tradingToEarn.remainingProportion}`);
    let prizeAmountString = prizeAmountDisplay;
    let allocatedScoreString = allocatedScoreDisplay;
    tradingToEarn.prizeAmountString = prizeAmountString;
    tradingToEarn.allocatedScoreString = allocatedScoreString;
    tradingToEarn.activityStatus = data.activityStatus;
    if (tradingToEarn.activityStatus === 0 || tradingToEarn.activityStatus === 1) {
        var remainTime = 0;
        if (tradingToEarn.activityStatus == 0) {
            remainTime = data.startTime - data.systemTime;
        } else if (tradingToEarn.activityStatus = 1) {
            remainTime = data.endTime - data.systemTime;
        }
        if (remainTime <= 0) {
            remainTime = 0;
            tradingToEarn.showRemain = getVisibilityStatus(false);
        } else {
            tradingToEarn.remainTime = remainTime;
            let times = handleShowTime$1(tradingToEarn.remainTime);
            tradingToEarn.countDownTimeStr = `${tradingToEarn.showScheduleText}:${times}`;
            tradingToEarn.showRemain = getVisibilityStatus(true);
        }
    } else {
        tradingToEarn.showRemain = getVisibilityStatus(false);
    }
    let symbolInfo = getSymbolInfo(data.symbol);
    if (symbolInfo) {
        let coinIcon = getIconURL(symbolInfo.baseCurrency);
        tradingToEarn.coinIcon = coinIcon;
    } else {
        tradingToEarn.coinIcon = "@drawable/edge_engine_home_coin_placeholder_16";
    }
    return tradingToEarn;
}

function handleShowTime$1(timestamp) {
    const seconds = Math.floor(timestamp / 1e3);
    const minutes = Math.floor(seconds / 60);
    const hours = Math.floor(minutes / 60);
    const days = Math.floor(hours / 24);
    var showDay = days > 0 ? true : false;
    const remainingSeconds = seconds % 60;
    const remainingMinutes = minutes % 60;
    const remainingHours = hours % 24;
    const addLeadingZero = value => value < 10 ? `0${value}` : value.toString();
    const safeValue = value => value > 0 ? value : 0;
    const d = addLeadingZero(safeValue(days));
    const h = addLeadingZero(safeValue(remainingHours));
    const m = addLeadingZero(safeValue(remainingMinutes));
    const s = addLeadingZero(safeValue(remainingSeconds));
    if (showDay === true) {
        return `${d}:${h}:${m}:${s}`;
    } else {
        return `${h}:${m}:${s}`;
    }
}

function formatNumber(number) {
    const floatValue = parseFloat(number);
    if (isNaN(floatValue)) {
        return "0.00%";
    }
    const truncatedValue = Math.trunc(floatValue * 1e4) / 100;
    const formattedNumber = truncatedValue.toFixed(2);
    return `${formattedNumber}%`;
}

function formatNumberWithCommas(number) {
    if (typeof number !== "number") {
        return "";
    }
    const parts = number.toString().split(".");
    parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    return parts.join(".");
}

var moduleDidStart$2 = false;

async function start$4() {
    moduleDidStart$2 = true;
    if (commanData.isInReview == 1) {
        $data.banner.bannerVisibility = "visible";
        $data.banner.noticeVisibility = "gone";
        $data.banner.bannerPlaceholerVisibility = "visible";
        $data.banner.bannerPlaceholerImage = "@drawable/home_banner_image_inReview";
        await setModuleStatus("banner", 1);
    } else {
        await requestBanner();
    }
}

function defaultData$4() {
    return {
        bannerList: [],
        noticeList: [],
        bannerCurrentIndex: "1",
        noticeCurrentIndex: "1",
        totalPage: "0",
        bannerVisibility: "gone",
        noticeVisibility: "gone",
        bannerTextVisibility: "gone",
        bannerPlaceholerVisibility: "gone",
        bannerPlaceholerImage: "@drawable/home_new_banner_placeholder",
        noticePlaceholerVisibility: "gone",
        bannerAndroidStrokeVisibility: commanData.OS == 1 ? "visible" : "gone",
        autoScroll: "true",
        currentIndex: "0",
        currentNoticeIndex: "0"
    };
}

const {moduleData: moduleData$4, moduleEvent: moduleEvent$4} = moduleDefine("banner", start$4, defaultData$4);

var bannerExposureMap = new Map;

var notiveExposureMap = new Map;

async function bannerExposure() {
    var index = parseInt(moduleData$4.bannerCurrentIndex) - 1;
    if (index >= bannerDataList.length) {
        return;
    }
    var obj = bannerDataList[index];
    if (!bannerExposureMap.has(obj["id"])) {
        try {
            await analytics("appExposure_home", {
                module_name: "banner",
                module_position: String(index + 1),
                material_name: obj["adName"],
                elementId: String(obj["id"])
            });
            bannerExposureMap.set(obj["id"], true);
        } catch (e) {
            console.log(`banner bannerExposure error, error=${e}`);
        }
    }
}

async function noticeExposure() {
    var index = parseInt(moduleData$4.noticeCurrentIndex) - 1;
    if (index >= noticeDataList.length) {
        return;
    }
    var obj = noticeDataList[index];
    if (!notiveExposureMap.has(obj["procla_id"])) {
        try {
            await analytics("appExposure_home", {
                module_name: "notice",
                type: obj["orgTag"],
                notice_is_top: obj["isTop"],
                elementId: String(obj["procla_id"])
            });
            notiveExposureMap.set(obj["procla_id"], true);
        } catch (e) {
            console.log(`notice notiveExposure error, error=${e}`);
        }
    }
}

async function clearBannerExposureMap() {
    bannerExposureMap.clear();
}

async function moduleAppear$4() {
    await bannerExposure();
    await noticeExposure();
}

async function moduleDisappear$4() {}

moduleEvent$4.moduleAppear = moduleAppear$4;

moduleEvent$4.moduleDisappear = moduleDisappear$4;

async function requestBanner() {
    await requestBannerList();
    await requestNoticeList();
}

var bannerDataList = [];

var noticeDataList = [];

async function requestBannerList() {
    var ua = "M:huobiapp:phone:android";
    if (commanData.OS == 0) {
        ua = "M:huobiapp:phone:iOS";
    }
    var cType = "1";
    var countryId = parseInt(commanData.userInfo.countryId);
    if (countryId > 0 && countryId != 37) {
        cType = "2";
    }
    var uid = commanData.userInfo.uId;
    if (commanData.isLogin != 1) {
        uid = "";
    }
    var params = {
        lang: commanData.language,
        type: "52",
        uId: uid,
        channel_name: "huobi",
        userAgent: ua,
        version: commanData.appVersion,
        countryType: cType
    };
    var header = {};
    var registerCountryId = commanData.userInfo.registerCountryId;
    if (registerCountryId > 0) {
        header["clientCountryId"] = registerCountryId;
    }
    await sendRequestWithCache("v1/app-web-api/banner/list", callback = bannerDataCallback, params, 0, 0, header, []);
    await setModuleStatus("banner", 1);
}

async function bannerDataCallback(bannerData, isCache) {
    await setModuleStatus("banner", 1);
    if (isCache && bannerDataList.length > 0) {
        return;
    }
    if (bannerData && bannerData != "") {
        console.log("requestBannerList " + JSON.stringify(bannerData));
        if (bannerData != null && bannerData.adList != null) {
            moduleData$4.bannerAndroidStrokeVisibility = commanData.OS == 1 ? "visible" : "gone";
            bannerDataList = isEffectiveAdvertising(bannerData.adList);
            for (var i = 0; i < bannerDataList.length; i++) {
                var obj = bannerDataList[i];
                obj["type"] = "1";
            }
            console.log("requestBannerList effectiveAdList：" + JSON.stringify(bannerDataList));
            var length = bannerDataList.length <= parseInt(moduleData$4.currentIndex) ? "0" : parseInt(moduleData$4.currentIndex);
            moduleData$4.bannerList = bannerDataList;
            moduleData$4.currentIndex = String(length);
            moduleData$4.totalPage = String(bannerDataList.length);
            moduleData$4.bannerVisibility = "visible";
            moduleData$4.bannerTextVisibility = bannerDataList.length > 1 ? "visible" : "gone";
            moduleData$4.bannerPlaceholerVisibility = bannerDataList.length > 0 ? "gone" : "visible";
        } else {
            moduleData$4.bannerPlaceholerVisibility = "visible";
            moduleData$4.bannerVisibility = "gone";
            moduleData$4.bannerTextVisibility = "gone";
        }
    } else {
        moduleData$4.bannerPlaceholerVisibility = "visible";
        moduleData$4.bannerVisibility = "gone";
        moduleData$4.bannerTextVisibility = "gone";
        moduleData$4.bannerList = null;
    }
}

async function requestNoticeList() {
    var header = {};
    var countryId = commanData.userInfo.registerCountryId;
    if (countryId > 0) {
        header["clientCountryId"] = countryId;
    }
    await sendRequestWithCache("v1/proclamation/app/home-page/announcement", callback = noticeDataCallback, {}, 0, 0, header, []);
    await setModuleStatus("banner", 1);
}

function noticeDataCallback(noticeData, isCache) {
    if (isCache && noticeDataList.length > 0) {
        return;
    }
    if (noticeData && noticeData != "") {
        console.log("requestNoticeList " + JSON.stringify(noticeData));
        var top = noticeData.top;
        var topLength = top != null ? top.length : 0;
        var normal = noticeData.normal;
        var dataList = top.concat(normal);
        console.log("dataList " + JSON.stringify(dataList));
        if (dataList != null) {
            for (var i = 0; i < dataList.length; i++) {
                var obj = dataList[i];
                obj["orgTag"] = obj["tag"];
                obj["isTop"] = i < topLength ? 1 : 0;
                if (obj["tag"] == "Promotions") {
                    obj["tag"] = $i18n.n_notice_event;
                    obj["color"] = "@color/KBaseRiskTextColorMid";
                } else if (obj["tag"] == "Announcement") {
                    obj["tag"] = $i18n.n_notice;
                    obj["color"] = "@color/kColorMajorTheme100";
                } else if (obj["tag"] == "New_Coin") {
                    obj["tag"] = $i18n.n_notice_new_coin;
                    obj["color"] = "@color/KBaseRiskTextColorLow";
                }
                obj["type"] = "1";
            }
            moduleData$4.noticeList = dataList;
            moduleData$4.noticeVisibility = dataList.length > 0 ? "visible" : "gone";
            noticeDataList = dataList;
            moduleData$4.noticePlaceholerVisibility = "gone";
        } else {
            moduleData$4.noticePlaceholerVisibility = "visible";
            moduleData$4.noticeVisibility = "gone";
        }
    } else {
        moduleData$4.noticePlaceholerVisibility = "visible";
        moduleData$4.noticeVisibility = "gone";
    }
}

function isEffectiveAdvertising(list) {
    var result = new Array;
    var interval = (new Date).getTime() + commanData.serviceTimeInterval;
    for (var i = 0; i < list.length; i++) {
        var isEffective = true;
        var obj = list[i];
        var currentImageURL = null;
        if (commanData.colorMode == 0 && obj.img != null) {
            currentImageURL = obj.img;
        } else if (commanData.colorMode == 1 && obj.nightImageUrl != null) {
            currentImageURL = obj.nightImageUrl;
        }
        obj.currentImageURL = currentImageURL;
        if (currentImageURL == null || currentImageURL.length == 0) {
            isEffective = false;
        }
        if (obj.beginTime == null || String(obj.beginTime).length < 13 || obj.endTime == null || String(obj.endTime).length < 13) {
            isEffective = true;
        } else {
            if (interval >= obj.endTime || interval < obj.beginTime) {
                isEffective = false;
            }
        }
        var support = false;
        if (commanData.OS == 0) {
            support = obj.appIosTradeSupport == 1 ? true : false;
        } else {
            support = obj.appAndroidSupport == 1 ? true : false;
        }
        if (obj.isShow == 0 && isEffective && obj.isNeedLogin != commanData.isLogin && support) {
            result.push(obj);
        }
    }
    return result;
}

async function loginStateChange$1() {
    if (moduleDidStart$2 == false) {
        return;
    }
    moduleData$4.bannerPlaceholerVisibility = "visible";
    moduleData$4.bannerVisibility = "gone";
    moduleData$4.bannerTextVisibility = "gone";
    moduleData$4.bannerList = null;
}

moduleEvent$4.selectedBannerIndex = async function(index) {
    $data.banner.bannerCurrentIndex = String(index + 1);
    await bannerExposure();
    console.log("selectedBannerIndex" + index);
};

moduleEvent$4.selectedNoticeIndex = async function(index) {
    $data.banner.noticeCurrentIndex = String(index + 1);
    await noticeExposure();
    console.log("selectedNoticeIndex " + index);
};

moduleEvent$4.bannerClickBanner = async function() {
    var index = parseInt(moduleData$4.bannerCurrentIndex) - 1;
    if (index >= bannerDataList.length) {
        return;
    }
    var obj = bannerDataList[index];
    try {
        await $nativeAPI.homeBridge({
            action: "bannerClickBanner",
            data: JSON.stringify(obj)
        });
        await analytics("appClick_home", {
            module_name: "banner",
            module_position: String(index + 1),
            material_name: obj["adName"],
            elementId: String(obj["id"])
        });
    } catch (e) {
        console.log(`bannerClickMore error, error=${e}`);
    }
};

moduleEvent$4.bannerClickNotice = async function() {
    var index = parseInt(moduleData$4.noticeCurrentIndex) - 1;
    if (index >= noticeDataList.length) {
        return;
    }
    var obj = noticeDataList[index];
    if (obj.absolute_url != null) {
        console.log("clicknoice" + obj.absolute_url);
        await openURL(encodeURI(obj.absolute_url));
    }
    await analytics("appClick_home", {
        module_name: "notice",
        button_name: "notice",
        module_position: String(index + 1),
        type: obj["orgTag"],
        material_name: obj["adName"],
        notice_is_top: obj["isTop"],
        elementId: obj["procla_id"]
    });
};

moduleEvent$4.bannerClickMore = async function() {
    try {
        console.log("click more");
        await $nativeAPI.homeBridge({
            action: "bannerClickMore"
        });
        await analytics("appClick_home", {
            module_name: "notice",
            button_name: "more"
        });
    } catch (e) {
        console.log(`bannerClickMore error, error=${e}`);
    }
};

function startScroll() {
    if (moduleDidStart$2 == false) {
        return;
    }
    moduleData$4.autoScroll = "true";
}

function endScroll() {
    if (moduleDidStart$2 == false) {
        return;
    }
    moduleData$4.autoScroll = "false";
}

async function start$3() {
    console.log("tl -- earn 111");
    await requestEarnAreaHomepagerData();
}

function defaultData$3() {
    return {
        visibility: "gone",
        show: "",
        title: "",
        more: {},
        earnList: [],
        offsetX: ""
    };
}

var isLoad = false;

var isNewUser = false;

const {moduleData: moduleData$3, moduleEvent: moduleEvent$3} = moduleDefine("earn", start$3, defaultData$3);

async function moduleAppear$3() {
    await analyticsAppear$1();
}

async function moduleDisappear$3() {}

moduleEvent$3.moduleAppear = moduleAppear$3;

moduleEvent$3.moduleDisappear = moduleDisappear$3;

var earnList;

var needAnalyticsWhenRequestSuccess$1 = false;

async function analyticsAppear$1() {
    if (moduleData$3.visibility == "gone") {
        needAnalyticsWhenRequestSuccess$1 = true;
        return;
    }
    needAnalyticsWhenRequestSuccess$1 = false;
    var typeList = [];
    var idList = [];
    earnList.forEach((element => {
        if (element.visibility == "visible") {
            typeList.push(getTypeAnalyticsString(element.shelfType));
            var id = element.projectId == null ? "null" : String(element.projectId);
            idList.push(id);
        }
    }));
    const typeStr = typeList.join(",");
    const idStr = idList.join(",");
    await analytics("appExposure_home", {
        module_name: "earn",
        type: typeStr,
        elementId: idStr
    });
}

function getTypeAnalyticsString(type) {
    var typeStr = "PrimeEarn";
    if (type == 1) {
        typeStr = "PrimeEarn";
    } else if (type == 2) {
        typeStr = "Fixed";
    } else if (type == 3) {
        typeStr = "NewList";
    } else if (type == 4) {
        typeStr = "Flexible";
    }
    return typeStr;
}

moduleEvent$3.endScrollXAction = async function(params) {
    const x = parseInt(params);
    await save("earn", "offset", x);
};

moduleEvent$3.moreTapAction = async function() {
    let jumpUrl = encodeURI(moduleData$3.more.jumpUrl);
    let title = moduleData$3.more.title;
    let param = {
        title: title,
        needLogin: false
    };
    await openURL(jumpUrl, param);
    await analytics("appClick_home", {
        module_name: "earn",
        type: "more"
    });
};

moduleEvent$3.earnTapAction = async function(index) {
    let model = moduleData$3.earnList[parseInt(index)];
    let jumpUrl = encodeURI(model.url.jumpUrl);
    let title = model.url.title;
    let param = {
        title: title,
        needLogin: false
    };
    await openURL(jumpUrl, param);
    await analytics("appClick_home", {
        module_name: "earn",
        module_position: String(index + 1),
        type: parseInt(model.shelfType),
        name: model.coinName,
        elementId: String(model.projectId)
    });
};

async function earnDataCallback(data, isCache) {
    await setModuleStatus("earn", 1);
    if (moduleData$3.earnList.length > 0 && isCache === true) {
        return;
    }
    isNewUser = data.newUser;
    moduleData$3.isNewUser = data.newUser ? "visible" : "gone";
    moduleData$3.isOldUser = data.newUser ? "gone" : "visible";
    moduleData$3.title = data.title;
    moduleData$3.more = data.more;
    var array = [];
    var itemsShow = false;
    for (var i = 0; i < data.contents.length; i++) {
        let obj = data.contents[i];
        var earn = handleEarnObject(obj);
        if (earn.visibility === "visible") {
            itemsShow = true;
        }
        earn.index = i;
        array.push(earn);
    }
    moduleData$3.earnList = array;
    earnList = array;
    moduleData$3.visibility = getVisibilityStatus(data.show === 1 && itemsShow === true);
}

async function requestEarnAreaHomepagerData() {
    var params = {
        style: 0
    };
    if (commanData.colorMode != null && commanData.colorMode != undefined) {
        console.log(`请求 earn 数据，当前模式是==${commanData.colorMode}`);
        params = {
            style: commanData.colorMode
        };
    }
    await sendRequestWithCache("v1/saving-market/mining/app/index/earnAreaHomepageView", callback = earnDataCallback, params);
    if (moduleData$3.visibility === "visible") {
        await setModuleStatus("earn", 1);
        if (needAnalyticsWhenRequestSuccess$1 == true) {
            await analyticsAppear$1();
        }
        await finishLoad();
    } else {
        await setModuleStatus("earn", 2);
    }
}

async function finishLoad() {
    if (isNewUser == true) {
        await clear("earn", "offset");
    } else {
        if (isLoad == false) {
            await clear("earn", "offset");
            isLoad = true;
        } else {
            const lastOffsetX = await read("earn", "offset");
            moduleData$3.offsetX = lastOffsetX;
            isLoad = true;
        }
    }
}

function handleEarnObject(obj) {
    var earn = obj;
    earn.visibility = getVisibilityStatus(obj.isShow === 1);
    earn.coinName = obj.currency;
    earn.coinIcon = obj.iconUrl;
    earn.rateString = obj.rate.toString();
    earn.rateTitle = "APY";
    earn.tagShow = earn.tag != undefined && earn.tag != null ? "visible" : "gone";
    if (obj.tagValue == 9) {
        earn.tagBgColor = "#1A0173E5";
        earn.tagTextColor = "@color/kColorMajorTheme100";
    } else {
        earn.tagBgColor = "#1AFE8731";
        earn.tagTextColor = "@color/kSecurityMiddleLevelColor";
    }
    earn.originalRateShow = "gone";
    if (earn.originApy != undefined && earn.originApy != null) {
        earn.originalRateString = earn.originApy;
        earn.originalRateShow = "visible";
    }
    if (obj.shelfType === 4) {
        earn.earnType = "saving";
    } else {
        earn.earnType = "normal";
    }
    return earn;
}

async function start$2() {
    await requestOperationData();
}

function defaultData$2() {
    return {
        firstFunctionList: [],
        secondFunctionList: [],
        functionVisibility: "gone",
        firstFunctionVisibility: "gone",
        secondFunctionVisibility: "gone"
    };
}

const {moduleData: moduleData$2, moduleEvent: moduleEvent$2} = moduleDefine("operation", start$2, defaultData$2);

var operationExposureMap = new Map;

async function clearOperationExposureMap() {
    operationExposureMap.clear();
}

async function moduleAppear$2() {
    if (operationDataList.length > 0 && !operationExposureMap.has("ball")) {
        var typeStr = "";
        var badgesStr = "";
        for (let index in operationDataList) {
            let item = operationDataList[index];
            if (item.id == operationInvalidId) break;
            if (index != 0) {
                typeStr = typeStr.concat(",");
                badgesStr = badgesStr.concat(",");
            }
            typeStr = typeStr.concat(item.jumpMode == 999 ? "more" : item.groupCode);
            badgesStr = badgesStr.concat(item.cornerMarkContent != null ? String(item.cornerMarkContent.cornerMarkId) : "0");
        }
        await analytics("appExposure_home", {
            module_name: "ball",
            type: typeStr,
            superscript: badgesStr
        });
        operationExposureMap.set("ball", true);
    }
}

async function moduleDisappear$2() {}

moduleEvent$2.moduleAppear = moduleAppear$2;

moduleEvent$2.moduleDisappear = moduleDisappear$2;

var operationDataList = [];

var operationInvalidId = -9527;

async function requestOperationData() {
    var uid = "";
    if (commanData.isLogin == 1) {
        uid = commanData.userInfo.uId;
    }
    var params = {
        uid: uid,
        moduleSize: 20,
        version: commanData.appVersion,
        platform: commanData.OS == 1 ? 1 : 2,
        nightMode: commanData.colorMode,
        ts: (new Date).getTime()
    };
    var header = {};
    var countryId = commanData.userInfo.registerCountryId;
    if (countryId > 0) {
        header["clientCountryId"] = countryId;
    }
    await sendRequestWithCache("p/api/appFeatures/module/8", callback = operationDataCallback, params, 0, 7, header, []);
    if (operationDataList.length > 0) {
        await setModuleStatus("operation", 1);
    } else {
        await setModuleStatus("operation", 2);
    }
}

async function operationDataCallback(functionData, isCache) {
    await setModuleStatus("operation", 1);
    if (isCache && operationDataList.length > 0) {
        return;
    }
    if (functionData && functionData != "") {
        if (functionData.contentList != null) {
            var contentList = functionData.contentList;
            if (commanData.isInReview == 1) {
                if (functionData.contentList.length > 4) {
                    contentList = functionData.contentList.slice(0, 4);
                    functionData.contentList = contentList;
                }
            }
            var contentListLength = functionData.contentList.length;
            $data.operation.functionVisibility = contentListLength > 0 ? "visible" : "gone";
            $data.operation.firstFunctionVisibility = contentListLength > 0 ? "visible" : "gone";
            if (contentListLength > 5 && contentListLength < 8) {
                for (var i = contentListLength; i < 8; i++) {
                    var cellData = {
                        id: operationInvalidId,
                        title: "",
                        imgUrl: "",
                        imgNightUrl: ""
                    };
                    functionData.contentList.push(cellData);
                }
                contentListLength = functionData.contentList.length;
            }
            for (var index in functionData.contentList) {
                let item = functionData.contentList[index];
                item.iconUrl = commanData.colorMode == 1 ? item.imgNightUrl : item.imgUrl;
                let markContentLength = item.cornerMarkContent != null && item.cornerMarkContent.text != null ? item.cornerMarkContent.text.length : 0;
                item.cornerMarkText = markContentLength > 0 ? item.cornerMarkContent.text : "";
                item.cornerMarkTextVisibility = markContentLength > 0 ? "visible" : "gone";
                if (item.cornerMarkContent != null && markContentLength == 0) {
                    item.cornerMarkIcon = commanData.colorMode == 1 ? item.cornerMarkContent.nightImageUrl : item.cornerMarkContent.imageUrl;
                    item.cornerMarkIconVisibility = item.cornerMarkIcon != null && item.cornerMarkIcon.length > 0 ? "visible" : "gone";
                } else {
                    item.cornerMarkIconVisibility = "gone";
                }
                item.type = "1";
                item.operationIndex = index;
                item.contentVisibility = item.id != operationInvalidId ? "visible" : "gone";
            }
            operationDataList = functionData.contentList;
            if (contentListLength <= 5) {
                $data.operation.secondFunctionVisibility = "gone";
                $data.operation.firstFunctionList = functionData.contentList;
            } else {
                $data.operation.secondFunctionVisibility = "visible";
                $data.operation.firstFunctionList = functionData.contentList.slice(0, 4);
                $data.operation.secondFunctionList = functionData.contentList.slice(4, 8);
            }
        } else {
            $data.operation.functionVisibility = operationDataList != null && operationDataList.length > 0 ? "visible" : "gone";
        }
    }
}

async function operationClickItem(index) {
    try {
        var item = operationDataList[index];
        console.log("operationClickItem 金刚位 index:" + index + " stringify:" + JSON.stringify(item));
        if (item.id == operationInvalidId) return;
        await $nativeAPI.homeBridge({
            action: "operationClickItem",
            data: JSON.stringify(operationDataList[index])
        });
        await analytics("appClick_home", {
            module_name: "ball",
            module_position: String(index + 1),
            type: item.jumpMode == 999 ? "more" : item.groupCode,
            material_name: item["adName"],
            elementId: String(item["id"]),
            superscript: item.cornerMarkContent != null ? item.cornerMarkContent.cornerMarkId : "",
            isNeedLogin: item.needLogin == 1 ? "True" : "False"
        });
    } catch (e) {
        console.log(`request error, error=${e}`);
    }
}

$event.operationClickItem = operationClickItem;

var moduleDidStart$1 = false;

async function start$1() {
    moduleDidStart$1 = true;
    await requestSpotHomePageInfo();
}

function defaultData$1() {
    return {
        listData: []
    };
}

var cubeDataList;

const {moduleData: moduleData$1, moduleEvent: moduleEvent$1} = moduleDefine("cube", start$1, defaultData$1);

var cubeExposureMap = new Map;

async function clearCubeExposureMap() {
    cubeExposureMap.clear();
}

async function moduleAppear$1() {
    if (cubeDataList && cubeDataList.length > 0 && !cubeExposureMap.has("cube")) {
        var type = "";
        var material_id = "";
        var material_name = "";
        var reserve_byte1 = "";
        var reserve_byte2 = "";
        for (let index in cubeDataList) {
            let item = cubeDataList[index];
            if (index != 0) {
                type = type.concat(",");
                material_id = material_id.concat(",");
                material_name = material_name.concat(",");
                reserve_byte1 = reserve_byte1.concat(",");
                reserve_byte2 = reserve_byte2.concat(",");
            }
            type = type.concat(item["name"]);
            material_id = material_id.concat(item["materialId"]);
            material_name = material_name.concat(item["name"]);
            reserve_byte1 = reserve_byte1.concat(item["extension"]);
            reserve_byte2 = reserve_byte2.concat(item["extensionText"]);
        }
        await analytics("appExposure_home", {
            module_name: "tofu",
            type: type,
            elementId: material_id,
            material_name: material_name,
            reserve_byte1: reserve_byte1,
            reserve_byte2: reserve_byte2
        });
        cubeExposureMap.set("cube", true);
    }
}

async function moduleDisappear$1() {}

moduleEvent$1.moduleAppear = moduleAppear$1;

moduleEvent$1.moduleDisappear = moduleDisappear$1;

moduleEvent$1.tapCubeAction = async function(index) {
    if (index) {
        let i = parseInt(index);
        if (i < cubeDataList.length) {
            let item = cubeDataList[i];
            await openPage("cubeClick", item.url);
            await analytics("appClick_home", {
                module_name: "tofu",
                module_position: i + 1,
                type: item["name"],
                material_name: item["name"],
                elementId: item["materialId"],
                reserve_byte1: item["extension"],
                reserve_byte2: item["extensionText"]
            });
        }
    }
};

async function countDown() {
    if (moduleDidStart$1 == false) {
        return;
    }
    for (var i = 0; i < moduleData$1.listData.length; i++) {
        let item = moduleData$1.listData[i];
        if (item.cubeType === "countDown" && item.needCountDown === true && moduleData$1.showData === "visible") {
            let diff = item.diffTime - 1e3;
            let remainingTime = Math.max(0, diff);
            let times = handleShowTime(remainingTime);
            item.day = times[0];
            item.hour = times[1];
            item.minute = times[2];
            item.second = times[3];
            let showDay = getVisibilityStatus(item.day !== "00");
            item.showDay = showDay;
            item.diffTime = remainingTime;
            if (remainingTime === 0) {
                item.showCountDown = getVisibilityStatus(false);
                await requestSpotHomePageInfo();
            } else {
                item.showCountDown = getVisibilityStatus(true);
            }
        }
    }
}

async function homepageInfoDataCallback(data, isCache) {
    await setModuleStatus("cube", 1);
    if (moduleData$1.listData.length > 0 && isCache === true) {
        return;
    }
    if (data && data.access && data.access.length > 1) {
        var arr = [];
        var index = 0;
        for (var i = 0; i < data.access.length; i++) {
            let item = data.access[i];
            var cubeData = item;
            if (cubeData.bgImageUrl.includes(".gif") && commanData.OS == 1) {
                cubeData.bgImageUrl = "";
            }
            cubeData.cubeType = itemCellType(item.style);
            if (cubeData.cubeType === "countDown") {
                handleCubeItemTimer(cubeData);
            }
            if (arr.length < 2) {
                cubeData.index = String(index);
                index += 1;
                arr.push(cubeData);
            }
        }
        moduleData$1.listData = arr;
        cubeDataList = arr;
        moduleData$1.showData = getVisibilityStatus(moduleData$1.listData.length >= 2);
    } else {
        moduleData$1.showData = getVisibilityStatus(false);
    }
}

async function requestSpotHomePageInfo() {
    await sendRequestWithCache("v1/spot/homepage/info", callback = homepageInfoDataCallback, requestParams(), 0, 0, requestHeader());
    if (moduleData$1.showData === "visible") {
        await setModuleStatus("cube", 1);
    } else {
        await setModuleStatus("cube", 2);
    }
}

function requestParams() {
    var param = {};
    param.pricingMode = commanData.rateTypeStr;
    param.nightMode = commanData.colorMode;
    return param;
}

function requestHeader() {
    var header = {};
    let countryId = parseInt(commanData.userInfo.countryId);
    if (countryId > 0 && countryId != 37) {
        header.countryType = "2";
    } else {
        header.countryType = "1";
    }
    return header;
}

function itemCellType(style) {
    if (style == 5 || style == 6) {
        return "countDown";
    } else if (style == 2) {
        return "summaryButton";
    } else {
        return "normal";
    }
}

function handleCubeItemTimer(object) {
    let endTime = object.endTime;
    let beginTime = object.beginTime;
    var diffTime = 0;
    object.needCountDown = false;
    if (endTime > 0 && beginTime > 0) {
        if (endTime > beginTime) {
            diffTime = endTime - beginTime;
            object.needCountDown = true;
        }
    }
    object.diffTime = diffTime;
    let times = handleShowTime(diffTime);
    object.day = times[0];
    object.hour = times[1];
    object.minute = times[2];
    object.second = times[3];
    object.showDay = getVisibilityStatus(object.day == "00");
    object.showCountDown = getVisibilityStatus(diffTime > 0);
}

function handleShowTime(timestamp) {
    const seconds = Math.floor(timestamp / 1e3);
    const minutes = Math.floor(seconds / 60);
    const hours = Math.floor(minutes / 60);
    const days = Math.floor(hours / 24);
    const remainingSeconds = seconds % 60;
    const remainingMinutes = minutes % 60;
    const remainingHours = hours % 24;
    const addLeadingZero = value => value < 10 ? `0${value}` : value.toString();
    const safeValue = value => value > 0 ? value : 0;
    const dayString = addLeadingZero(safeValue(days));
    const hourString = addLeadingZero(safeValue(remainingHours));
    const minuteString = addLeadingZero(safeValue(remainingMinutes));
    const secondString = addLeadingZero(safeValue(remainingSeconds));
    return [ dayString, hourString, minuteString, secondString ];
}

var originData;

var moreActionDataMap = {};

var rankingCacheKey = "RankingIndexCache";

var favoritesSelectImageMap = {};

var lastTime = 0;

var newListNeedRefresh = false;

var currentScreen;

var favoriteScreenData = {
    spot: null,
    future: null
};

var titleColor_Normal;

var titleColor_Selected;

var titleFont_Normal = 14;

var titleFont_Selected = 20;

var favoriteImageNormal = "@drawable/edge_engine_home_ranking_favorite_uncheck";

var favoriteImageSelected = "@drawable/edge_engine_home_ranking_favorite_check";

var latestUpCoinTime = 0;

var moduleDidStart = false;

var marketRankHint = true;

async function start() {
    moduleDidStart = true;
    lastTime = (new Date).getTime();
    if (commanData.colorMode == 1) {
        titleColor_Normal = "#8C8C93";
        titleColor_Selected = "#E6E6E6";
    } else {
        titleColor_Normal = "#565656";
        titleColor_Selected = "#000000";
    }
    marketRankHint = true;
    console.log(`marketRankHint = 1111, marketRankHint==${marketRankHint}`);
    await getCacheIndex();
    await requestRankingData();
}

async function getCacheIndex() {
    const cacheIndex = await read("ranking", rankingCacheKey);
    if (cacheIndex != null) {
        console.log(`cacheIndex = ${cacheIndex}`);
        $data.ranking.currentIndex = cacheIndex;
        $data.ranking.currentTag = String(parseInt(cacheIndex) + 100);
        console.log(`marketRankHint = 2222, marketRankHint==${marketRankHint}`);
    } else {
        marketRankHint = false;
        let defaultIndex = 1;
        $data.ranking.currentIndex = String(defaultIndex);
        $data.ranking.currentTag = String(defaultIndex + 100);
        await save("ranking", rankingCacheKey, String(defaultIndex));
        await save("ranking", "market_cap_tip", "hint");
        console.log(`marketRankHint = 3333, marketRankHint==${marketRankHint}`);
    }
}

function defaultData() {
    let defaultIndex = 1;
    return {
        currentTag: String(defaultIndex + 100),
        currentIndex: String(defaultIndex)
    };
}

const {moduleData: moduleData, moduleEvent: moduleEvent} = moduleDefine("ranking", start, defaultData);

async function moduleAppear() {
    await analyticsAppear();
}

async function moduleDisappear() {}

moduleEvent.moduleAppear = moduleAppear;

moduleEvent.moduleDisappear = moduleDisappear;

var needAnalyticsWhenRequestSuccess = false;

async function analyticsAppear() {
    if ($data.ranking.titleData == null || $data.ranking.titleData.length == 0) {
        needAnalyticsWhenRequestSuccess = true;
        return;
    }
    needAnalyticsWhenRequestSuccess = false;
    var currentIndex = parseInt($data.ranking.currentIndex);
    if (currentIndex < $data.ranking.titleData.length) {
        var titleItem = $data.ranking.titleData[currentIndex];
        await analytics("appExposure_home", {
            module_name: "toplist",
            list_type: titleItem.type
        });
    }
}

$data.rankingpop = {
    popshow: false
};

function getPriceSymbol(quoteCurrency) {
    if (quoteCurrency == "USD") {
        return "$";
    }
    return "";
}

function getEmptyCell(type, subType) {
    var emptyCellType;
    if (type == 9) {
        emptyCellType = "favoriteEmpty";
    } else {
        emptyCellType = "empty";
    }
    var emptyCell = {
        cellType: emptyCellType,
        type: type,
        subType: subType
    };
    return emptyCell;
}

async function getLocalFavorites() {
    const favorites = await $nativeAPI.homeBridge({
        action: "getLocalFavorites"
    });
    console.log(`favorites = ${favorites}`);
    return favorites;
}

async function getContractBusinessTypeTag(symbol) {
    const businessTypeTag = await $nativeAPI.homeBridge({
        action: "getContractBusinessTypeTag",
        symbol: symbol
    });
    return businessTypeTag;
}

function headerCellItemFrom(titles, cellType) {
    var headerItem = {};
    headerItem.cellType = cellType;
    headerItem.leftTitle = titles[0];
    headerItem.middleTitle = titles[1];
    headerItem.rightTitle = titles[2];
    if (titles[2]["titleProperty"] == 6 || titles[2]["titleProperty"] == 7) {
        headerItem.rightTitle.originTitleName = headerItem.rightTitle.titleName;
        headerItem.rightTitle.titleName = `${headerItem.rightTitle.titleName}(${commanData.rateTypeStr})`;
    }
    return headerItem;
}

async function filterListItems(type, subType, list, dataCount = 10, showMore = true, showQuota = false) {
    var filterList = [];
    let maxCount = list.length;
    var count = 0;
    for (let i = 0; i < maxCount; i++) {
        if (count >= dataCount) {
            break;
        }
        var item = list[i];
        var detailInfo = {};
        detailInfo.originItemJson = JSON.stringify(item);
        detailInfo.type = type.toFixed(0).toString();
        detailInfo.subType = subType;
        detailInfo.symbol = item.symbol;
        detailInfo.baseName = item.baseCurrency.toUpperCase();
        if (type == 1 || type == 6 || type == 9 && subType == "spot" || showQuota == true) {
            detailInfo.quoteName = `/${item.quoteCurrency.toUpperCase()}`;
            detailInfo.isQuoteName = "visible";
        } else {
            detailInfo.isQuoteName = "gone";
        }
        detailInfo.iconURL = getIconURL(item.baseCurrency);
        detailInfo.iconPlaceholder = `@drawable/${commanData.iconPlaceholder}`;
        if (item.tagUrl != null && item.tagUrl !== "") {
            detailInfo.flagURL = item.tagUrl;
            detailInfo.flagViewVisibility = "visible";
            detailInfo.isZeroFee = "gone";
        } else {
            detailInfo.flagViewVisibility = "gone";
            var tags = item.tags;
            if (tags != null && tags.length > 0) {
                const isZeroFee = tags.includes("zerofee");
                detailInfo.isZeroFee = isZeroFee ? "visible" : "gone";
            } else {
                detailInfo.isZeroFee = "gone";
            }
        }
        if (type == 9 && subType == "future") {
            if (type == 9 && subType == "future") {
                detailInfo.cellType = "future";
            }
            detailInfo.baseName = item.contractShowSymbol.toUpperCase();
            detailInfo.analyticsSymbolName = detailInfo.baseName;
            var priceSymbol = getPriceSymbol(item.quoteCurrency);
            if (item.price != null && item.price.length > 0) {
                detailInfo.price = `${priceSymbol}${item.price}`;
            } else {
                detailInfo.price = "--";
            }
            var ratio = 0;
            if (item.upAndDown != null && item.upAndDown !== "") {
                var upAndDown = parseFloat(item.upAndDown);
                if (Math.abs(upAndDown) > 0) {
                    ratio = upAndDown * 100;
                }
            }
            var prefix = ratio > 0 ? "+" : "";
            detailInfo.ratio = `${prefix}${ratio.toFixed(2).toString()}%`;
            detailInfo.colorHex = getPriceColor(ratio);
            detailInfo.isFavorites = getPriceColor(ratio);
            if (item.contractBusinessTypeTag != null && item.contractBusinessTypeTag.length > 0) {
                detailInfo.contractBusinessTypeTag = item.contractBusinessTypeTag;
            } else {
                detailInfo.contractBusinessTypeTag = await getContractBusinessTypeTag(item.symbol);
            }
        } else {
            var symbolInfo = getSymbolInfo(item.symbol);
            if (symbolInfo == null) {
                console.log(`无币对信息，过滤币对 ${item.symbol}, type = ${type}, subtype = ${subType}`);
                continue;
            }
            if (symbolInfo.isHiddenUp) {
                console.log(`isHiddenUp = ${symbolInfo.isHiddenUp}，过滤币对 ${item.symbol}, type = ${type}, subtype = ${subType}`);
                continue;
            }
            var priceStr = "--";
            const coinDict = commanData.marketData[item.symbol];
            if (coinDict != null) {
                var price = coinDict.decimalcPrice;
                priceStr = getPriceString(price, symbolInfo.tradePricePrecision);
            } else {
                if (item.price != null && item.price.length > 0) {
                    priceStr = getPriceString(item.price, symbolInfo.tradePricePrecision);
                } else {
                    priceStr = "--";
                }
            }
            detailInfo.analyticsSymbolName = `${symbolInfo.baseCurrencyDisplayName}/${symbolInfo.quoteCurrencyDisplayName}`;
            detailInfo.price = priceStr;
            if (type == 1 || type == 5 || type == 6 || type == 9) {
                detailInfo.cellType = "normal";
                var ratio = 0;
                if (coinDict != null) {
                    if (Math.abs(coinDict.decimalDelta) >= 0) {
                        ratio = coinDict.decimalDelta;
                    }
                } else {
                    if (item.upAndDown != null && item.upAndDown !== "") {
                        var upAndDown = parseFloat(item.upAndDown);
                        if (Math.abs(upAndDown) > 0) {
                            ratio = upAndDown * 100;
                        }
                    }
                }
                var prefix = ratio > 0 ? "+" : "";
                detailInfo.ratio = `${prefix}${ratio.toFixed(2).toString()}%`;
                detailInfo.colorHex = getPriceColor(ratio);
                if (type == 9) {
                    detailInfo.isFavorites = getPriceColor(ratio);
                }
            } else if (type == 2) {
                detailInfo.cellType = "deal";
                if (item.volume != null && item.volume !== "") {
                    detailInfo.volume = await getVolumeStr(item.volume);
                } else {
                    detailInfo.volume = "--";
                }
            } else if (type == 10) {
                detailInfo.cellType = "market";
                if (item.volume != null && item.volume !== "") {
                    detailInfo.volume = await getVolumeStr(item.volume);
                } else {
                    detailInfo.volume = "--";
                }
            } else if (type == 4) {
                if (latestUpCoinTime == null || latestUpCoinTime < item.beginTradeDate) {
                    latestUpCoinTime = item.beginTradeDate;
                    console.log(`pointVisibility  获取最新时间 = ${latestUpCoinTime}`);
                }
                detailInfo.beginDate = item.beginTradeDate;
                const date = new Date(item.beginTradeDate);
                if (subType == "tradeable") {
                    detailInfo.cellType = "new";
                    var ratio = 0;
                    if (Math.abs(item.beginTradeUpAndDown) > 0) {
                        ratio = item.beginTradeUpAndDown * 100;
                    }
                    var prefix = ratio > 0 ? "+" : "";
                    detailInfo.ratio = `${prefix}${ratio.toFixed(2).toString()}%`;
                    detailInfo.colorHex = getPriceColor(ratio);
                    detailInfo.beginDateStr = formatDate(date, "yyyy-MM-dd");
                } else if (subType == "untradeable") {
                    detailInfo.cellType = "willUp";
                    detailInfo.beginDateStr = formatDate(date, "MM-dd hh:mm");
                    var timeMap = getCountDownMap(detailInfo.beginDate);
                    detailInfo.day = timeMap.day;
                    detailInfo.hour = timeMap.hour;
                    detailInfo.minute = timeMap.minute;
                    detailInfo.second = timeMap.second;
                    detailInfo.showDay = timeMap.showDay;
                    if (timeMap.isZero) {
                        newListNeedRefresh = true;
                    }
                }
            }
        }
        filterList.push(detailInfo);
        count += 1;
    }
    if (filterList.length >= dataCount && showMore) {
        var moreCell = {
            cellType: "more",
            type: String(type),
            subType: ""
        };
        if (type == 9) {
            moreCell.subType = String(subType);
        }
        var version = parseInt(commanData.appVersion);
        if (version < 102200) {
            console.log(`tl -- version==${version},111`);
            if (type != 10) {
                console.log(`tl -- version==${version},222`);
                filterList.push(moreCell);
            }
        } else {
            console.log(`tl -- version==${version},333`);
            filterList.push(moreCell);
        }
    }
    for (let i = 0; i < filterList.length; i++) {
        var cellItem = filterList[i];
        var analytics = {};
        analytics.module_position = i + 1;
        analytics.list_type = type;
        if (cellItem.cellType != "more") {
            analytics.name = cellItem.analyticsSymbolName;
            analytics.status = cellItem.cellType == "willUp" ? "Unlisted" : "Listed";
        }
        cellItem.analytics = JSON.stringify(analytics);
    }
    return filterList;
}

async function handleFavoriteList(item) {
    var favoriteList = [];
    var favoriteTitleCell = {
        cellType: "favoriteTitle",
        favoriteTitle: $i18n.n_home_favorite_select_crypto
    };
    favoriteList.push(favoriteTitleCell);
    const dataCellList = await filterListItems(item.type, null, item.singleList, maxCount = 6, showMore = false, showQuota = true);
    let hasChoose = false;
    for (var dataCell of dataCellList) {
        var imageName = favoritesSelectImageMap[dataCell.symbol];
        if (imageName == null) {
            imageName = favoriteImageSelected;
            favoritesSelectImageMap[dataCell.symbol] = imageName;
        }
        if (imageName == favoriteImageSelected) {
            hasChoose = true;
        }
        dataCell.favoriteImage = imageName;
    }
    var favoriteDataCell = {
        cellType: "spotFavorite",
        leftItemVisibility: "gone",
        rightItemVisibility: "gone"
    };
    for (const cellItem of dataCellList) {
        if (favoriteDataCell.leftItem == null) {
            favoriteDataCell.leftItem = cellItem;
            favoriteDataCell.leftItemVisibility = "visible";
        } else if (favoriteDataCell.rightItem == null) {
            favoriteDataCell.rightItem = cellItem;
            favoriteDataCell.rightItemVisibility = "visible";
            favoriteList.push(favoriteDataCell);
            favoriteDataCell = {
                cellType: "spotFavorite",
                leftItemVisibility: "gone",
                rightItemVisibility: "gone"
            };
        }
    }
    if (favoriteDataCell.leftItem != null) {
        favoriteList.push(favoriteDataCell);
    }
    var favoriteAddCell = {
        cellType: "favoriteAdd",
        enableButton: hasChoose == true ? "visible" : "gone",
        disableButton: hasChoose == true ? "gone" : "visible"
    };
    favoriteList.push(favoriteAddCell);
    return favoriteList;
}

async function handleSingleListData(item) {
    var dataMap = {};
    dataMap.listType = "1";
    dataMap.type = item.type;
    var cellList = [];
    if (!item.screen) {
        if (item.type == 9) {
            cellList = await handleFavoriteList(item);
        } else {
            var titles = item.title;
            const titleCell = headerCellItemFrom(titles, "title");
            titleCell.type = dataMap.type;
            cellList.push(titleCell);
            var dataCellList = await filterListItems(item.type, null, item.singleList);
            if (dataCellList.length == 0) {
                cellList.push(getEmptyCell(item.type, null));
            } else {
                cellList = cellList.concat(dataCellList);
            }
        }
    } else {
        var maxCount = 10;
        for (var screenObject of item.screenListObject) {
            const subType = screenObject.screenValue;
            var itemList = item.multipleMap[subType];
            if (dataMap.type == 4) {
                if (subType == "untradeable") {
                    if (itemList.length == 0) {
                        continue;
                    }
                } else if (subType == "tradeable") {
                    if (cellList.length > 0) {
                        var emptyCell = {
                            cellType: "space"
                        };
                        cellList.push(emptyCell);
                    }
                }
            }
            const titles = item.titleMap[subType];
            var titleCellType;
            if (dataMap.type == 9 && item.screenListObject.length > 1) {
                if (currentScreen == null) {
                    currentScreen = subType;
                }
                if (subType != currentScreen) {
                    continue;
                }
                titleCellType = "interactionTitle";
                for (const screenTitle of item.screenListObject) {
                    console.log(`screenTitle = ${screenTitle}`);
                    if (screenTitle.screenValue == currentScreen) {
                        titles[0].titleName = screenTitle.screenTitle;
                    }
                }
            } else {
                titleCellType = "title";
            }
            const titleCell = headerCellItemFrom(titles, titleCellType);
            titleCell.type = dataMap.type;
            var dataCellList;
            if (dataMap.type == 4 && subType == "untradeable") {
                var untradeableMaxCount = 10;
                dataCellList = await filterListItems(item.type, subType, itemList, dataCount = untradeableMaxCount, false);
                maxCount = maxCount - dataCellList.length - 1;
            } else {
                dataCellList = await filterListItems(item.type, subType, itemList, dataCount = maxCount, true);
            }
            if (dataCellList.length == 0) {
                if (dataMap.type == 4 && subType == "untradeable") {
                    continue;
                }
                cellList.push(titleCell);
                cellList.push(getEmptyCell(item.type, subType));
            } else {
                cellList.push(titleCell);
                cellList = cellList.concat(dataCellList);
            }
        }
    }
    dataMap.data = cellList;
    if (dataMap.type == 9) {
        favoriteScreenData[currentScreen] = dataMap;
    }
    return dataMap;
}

async function getVolumeStr(volume) {
    if (volume == null) {
        return "--";
    }
    const volumeStr = await $nativeAPI.homeBridge({
        action: "getVolumeStr",
        data: volume
    });
    return volumeStr;
}

async function handleRankingListData(data) {
    console.log("all start");
    const filterListData = data.filter((item => true));
    var listData = await Promise.all(filterListData.map((async item => {
        var dataMap = await handleSingleListData(item);
        return dataMap;
    })));
    var titleData = [];
    for (var i = 0; i < filterListData.length; i++) {
        var item = filterListData[i];
        var color = titleColor_Normal;
        var font = titleFont_Normal;
        if (i == parseInt($data.ranking.currentIndex)) {
            color = titleColor_Selected;
            font = titleFont_Selected;
        }
        var tag = String(100 + i);
        var pointVisibility = "gone";
        if (item.type == 4) {
            const index = parseInt($data.ranking.currentIndex);
            if (i == index) {
                console.log(`pointVisibility  当前在新币榜，直接更新最新时间 = ${latestUpCoinTime}`);
                await save("ranking", "latestUp", String(latestUpCoinTime));
            } else {
                const latestUpCache = await read("ranking", "latestUp");
                if (latestUpCache != null) {
                    const latestUpCacheTime = parseInt(latestUpCache);
                    console.log(`pointVisibility  缓存时间 = ${latestUpCacheTime}`);
                    console.log(`pointVisibility  当前最新时间 = ${latestUpCoinTime}`);
                    if (latestUpCoinTime > latestUpCacheTime) {
                        pointVisibility = "visible";
                    }
                }
            }
        } else if (item.type == 10) {
            if (marketRankHint) {
                console.log(`marketRankHint = 4444, marketRankHint==${marketRankHint}`);
                const hint = await read("ranking", "market_cap_tip");
                if (hint == null) {
                    console.log(`marketRankHint = 5555, marketRankHint==${marketRankHint}`);
                    pointVisibility = "visible";
                } else {
                    console.log(`marketRankHint = 6666, marketRankHint==${marketRankHint}`);
                }
            }
        }
        var titleItem = {
            type: item.type,
            title: item.typeTitle,
            titleColor: color,
            titleSize: font,
            pointVisibility: pointVisibility,
            tag: tag
        };
        titleData.push(titleItem);
    }
    setupProcessedTitleData(titleData);
    setupProcessedListData(listData);
    await setModuleStatus("ranking", 1);
    for (const titleItem of titleData) {
        var subTypeStr = null;
        if (titleItem.type == 9) {
            subTypeStr = currentScreen;
        }
        await getMoreActionData(titleItem.type, subTypeStr);
    }
    if (newListNeedRefresh == true) {
        var now = (new Date).getTime();
        if (now - lastTime > 3e3) {
            await requestRankingData();
        }
    }
    console.log("all done ");
}

function setupProcessedTitleData(newTitleData) {
    $data.ranking.titleData = newTitleData;
}

function setupProcessedListData(newListData) {
    $data.ranking.listData = newListData;
}

async function requestRankingData() {
    newListNeedRefresh = false;
    var params = {};
    const favorites = await getLocalFavorites();
    if (favorites.length > 0) {
        params.favorites = JSON.parse(favorites);
    } else {
        params.favorites = [];
    }
    var header = {
        "Content-Type": "application/json"
    };
    originData = await sendRequest("v1/app/new/rankingList/v3", params = params, method = 1, hostType = 0, header = header);
    if (originData != null) {
        await handleRankingListData(originData);
        if (needAnalyticsWhenRequestSuccess == true) {
            await analyticsAppear();
        }
    } else if ($data.ranking.listData == null) {
        await setModuleStatus("ranking", 0);
    }
    lastTime = (new Date).getTime();
}

async function getMoreActionData(type = "", subType = "") {
    if (parseInt(type) == 2 || parseInt(type) == 5) {
        subType = "spot";
    }
    var key = `${type}_${subType}`;
    var actionData = moreActionDataMap[key];
    if (actionData == null) {
        await requestMoreActionData(type, subType);
    }
    actionData = moreActionDataMap[key];
    return actionData;
}

async function requestMoreActionData(type = "", subType = "spot") {
    var param = {
        type: String(type),
        screen: subType
    };
    var key = `${type}_${subType}`;
    moreActionDataMap[key] = await sendRequest("v1/app/jump/info", params = param);
}

async function updateFavoritesSymbols(symbols = []) {
    var params = {
        tradingPairs: symbols,
        website: "PRO"
    };
    await sendRequest("uc/open/trading_pair/multiple/add", params, 1, 5, {});
}

async function resetFavoritesListData() {
    console.log(`currentScreen = ${currentScreen}`);
    var dataMap = favoriteScreenData[currentScreen];
    if (dataMap == null) {
        for (const item of originData) {
            if (item.type == 9) {
                dataMap = await handleSingleListData(item);
                favoriteScreenData[currentScreen] = dataMap;
            }
        }
    }
    for (var i = 0; i < $data.ranking.listData.length; i++) {
        var data = $data.ranking.listData[i];
        if (data.type == 9) {
            data.data = dataMap.data;
            return;
        }
    }
}

async function checkRequestTimer() {
    if (moduleDidStart == false) {
        return;
    }
    const currentTime = (new Date).getTime();
    if (currentTime - lastTime > 60 * 1e3) {
        await requestRankingData();
    }
    resetWillUpCellInTimer();
}

async function resetWillUpCellInTimer() {
    for (let i = 0; i < $data.ranking.listData.length; i++) {
        var dataMap = $data.ranking.listData[i];
        for (let j = 0; j < dataMap.data.length; j++) {
            var cellData = dataMap.data[j];
            if (cellData.cellType == "willUp") {
                var timeMap = getCountDownMap(cellData.beginDate);
                cellData.day = timeMap.day;
                cellData.hour = timeMap.hour;
                cellData.minute = timeMap.minute;
                cellData.second = timeMap.second;
                cellData.showDay = timeMap.showDay;
                if (timeMap.isZero) {
                    newListNeedRefresh = true;
                }
            }
        }
    }
    if (newListNeedRefresh == true) {
        var now = (new Date).getTime();
        if (now - lastTime > 3e3) {
            await requestRankingData();
        }
    }
}

function getCountDownMap(date) {
    const beginDate = new Date(date).getTime();
    const newDate = (new Date).getTime() + commanData.serviceTimeInterval;
    const milliseconds = beginDate - newDate;
    const interval = milliseconds / 1e3;
    if (interval <= 0) {
        return {
            day: "00",
            hour: "00",
            minute: "00",
            second: "00",
            showDay: "gone",
            isZero: true
        };
    }
    let d = parseInt(interval / 60 / 60 / 24);
    let day = d < 10 ? `0${d}` : `${d}`;
    let h = parseInt(interval / 60 / 60 % 24);
    let hour = h < 10 ? `0${h}` : `${h}`;
    let m = parseInt(interval / 60 % 60);
    let minute = m < 10 ? `0${m}` : `${m}`;
    let s = parseInt(interval % 60);
    let second = s < 10 ? `0${s}` : `${s}`;
    var showDay = d > 0 ? "visible" : "gone";
    var isZero = d + h + m + s > 0 ? false : true;
    return {
        day: day,
        hour: hour,
        minute: minute,
        second: second,
        showDay: showDay,
        isZero: isZero
    };
}

function resetMarketData() {
    if (moduleDidStart == false) {
        return;
    }
    console.log("resetMarketData");
    for (let i = 0; i < $data.ranking.listData.length; i++) {
        var dataMap = $data.ranking.listData[i];
        for (let j = 0; j < dataMap.data.length; j++) {
            var cellData = dataMap.data[j];
            if (cellData.cellType == "normal" || cellData.cellType == "deal" || cellData.cellType == "market" || cellData.cellType == "new" || cellData.cellType == "willUp" || cellData.cellType == "future") {
                const symbolInfo = getSymbolInfo(cellData.symbol);
                const coinDict = commanData.marketData[cellData.symbol];
                if (coinDict == null) {
                    continue;
                }
                var price = coinDict.decimalcPrice;
                if (price > 0) {
                    var priceStr = getPriceString(price, symbolInfo.tradePricePrecision);
                    if (cellData.cellType == "future") {
                        cellData.price = getPriceSymbol(symbolInfo.quoteCurrencyDisplayName) + priceStr;
                    } else {
                        cellData.price = priceStr;
                    }
                }
                var type = parseInt(cellData.type);
                if (type == 1 || type == 5 || type == 6 || type == 9) {
                    var ratio = 0;
                    if (Math.abs(coinDict.decimalDelta) >= 0) {
                        ratio = coinDict.decimalDelta;
                        var prefix = ratio > 0 ? "+" : "";
                        cellData.ratio = `${prefix}${ratio.toFixed(2).toString()}%`;
                        cellData.colorHex = getPriceColor(ratio);
                    }
                }
            }
        }
    }
}

async function resetMarketTitle() {
    if (moduleDidStart == false) {
        return;
    }
    for (let i = 0; i < $data.ranking.listData.length; i++) {
        var dataMap = $data.ranking.listData[i];
        for (let j = 0; j < dataMap.data.length; j++) {
            var cellData = dataMap.data[j];
            if (cellData.cellType == "title" && (cellData.rightTitle.titleProperty == 6 || cellData.rightTitle.titleProperty == 7)) {
                cellData.rightTitle.titleName = `${cellData.rightTitle.originTitleName}(${commanData.rateTypeStr})`;
            }
        }
    }
}

async function rankingClicked(symbol, analyticsJson, originItemJson) {
    const originItem = JSON.parse(originItemJson);
    const analytics$1 = JSON.parse(analyticsJson);
    await openPage("kline", {
        symbol: symbol,
        originItem: originItem
    });
    await analytics("appClick_home", {
        module_name: "toplist",
        module_position: analytics$1.module_position,
        name: analytics$1.name,
        list_type: analytics$1.list_type,
        status: analytics$1.status
    });
}

async function moreButtonClicked(typeStr, subTypeStr, analyticsJson) {
    var type = parseInt(typeStr);
    var actionData = await getMoreActionData(typeStr, subTypeStr);
    if (actionData != null) {
        const target = parseInt(actionData.target);
        if ((type == 1 || type == 2 || type == 4 || type == 5 || type == 6 || type == 10) && target == 1) {
            await openPage("allRanking", {
                type: type
            });
        } else {
            const h5Url = actionData.h5Url;
            const jumpType = parseInt(actionData.type);
            if (h5Url != null && h5Url.length > 0 && jumpType == 1) {
                await openURL(h5Url);
            } else {
                const primaryTitle = parseInt(actionData.primaryTitle);
                if (primaryTitle < 1 || primaryTitle > 3) {
                    actionData.filter = "1";
                } else if (primaryTitle == 1) {
                    actionData.hb_isRankingListFavourites = true;
                }
                if (commanData.OS == 0) {
                    if (primaryTitle == 0) {
                        actionData.hb_isRankingListFavourites = true;
                    }
                }
                actionData.hb_isRankingListFuture = true;
                await openPage("rankingToMarket", actionData);
            }
        }
    }
    const analytics$1 = JSON.parse(analyticsJson);
    await analytics("appClick_home", {
        module_name: "toplist",
        name: "More",
        list_type: analytics$1.list_type
    });
}

async function interactionTitleClick() {
    for (const item of originData) {
        if (item.type == 9) {
            for (const screenMap of item.screenListObject) {
                $data.rankingpop[screenMap.screenValue] = {
                    listType: "1",
                    name: screenMap.screenTitle,
                    screenTitle: screenMap.screenValue,
                    color: screenMap.screenValue == currentScreen ? "#0173E5" : "#565656"
                };
            }
            $data.rankingpop.popshow = true;
            console.log(`showPop`);
            break;
        }
    }
}

async function selectedFavoriteSymbol(symbol = "") {
    var imageName = favoritesSelectImageMap[symbol];
    if (imageName == favoriteImageSelected) {
        imageName = favoriteImageNormal;
    } else {
        imageName = favoriteImageSelected;
    }
    favoritesSelectImageMap[symbol] = imageName;
    for (let i = 0; i < $data.ranking.listData.length; i++) {
        var dataMap = $data.ranking.listData[i];
        if (dataMap.type != 9) {
            continue;
        }
        let hasChoose = false;
        for (let j = 0; j < dataMap.data.length; j++) {
            var cellData = dataMap.data[j];
            if (cellData.cellType == "spotFavorite") {
                if (cellData.leftItem.symbol == symbol) {
                    cellData.leftItem.favoriteImage = imageName;
                } else if (cellData.rightItem.symbol == symbol) {
                    cellData.rightItem.favoriteImage = imageName;
                }
                if (cellData.leftItem.favoriteImage == favoriteImageSelected || cellData.rightItem.favoriteImage == favoriteImageSelected) {
                    hasChoose = true;
                }
            }
        }
        for (let j = 0; j < dataMap.data.length; j++) {
            var cellData = dataMap.data[j];
            if (cellData.cellType == "favoriteAdd") {
                cellData.enableButton = hasChoose == true ? "visible" : "gone";
                cellData.disableButton = hasChoose == true ? "gone" : "visible";
            }
        }
    }
}

async function tabClick(tag) {
    var index = parseInt(tag) - 100;
    $data.ranking.currentIndex = String(index);
    await resetTitleSelectTab(index);
}

async function resetTitleSelectTab(index) {
    console.log(`index = ${index}`);
    await save("ranking", rankingCacheKey, String(index));
    var selectedItem = null;
    for (var i = 0; i < $data.ranking.titleData.length; i++) {
        var item = $data.ranking.titleData[i];
        if (i == index) {
            selectedItem = item;
        }
        item.titleColor = titleColor_Normal;
        item.titleSize = titleFont_Normal;
    }
    var selectedChange = false;
    if (selectedItem != null) {
        selectedItem.titleColor = titleColor_Selected;
        selectedItem.titleSize = titleFont_Selected;
        selectedItem.pointVisibility = "gone";
        if ($data.ranking.currentTag != selectedItem.tag) {
            selectedChange = true;
            $data.ranking.currentTag = selectedItem.tag;
        }
        if (selectedItem.type == 4) {
            console.log(`pointVisibility  缓存最新时间 = ${latestUpCoinTime}`);
            await save("ranking", "latestUp", String(latestUpCoinTime));
        } else if (selectedItem.type == 10) {
            console.log(`marketRankHint = 7777, marketRankHint==${marketRankHint}`);
            await save("ranking", "market_cap_tip", "hint");
        }
        var subTypeStr = null;
        if (selectedItem.type == 9) {
            subTypeStr = currentScreen;
        }
        var moreActionData = await getMoreActionData(selectedItem.type, subTypeStr);
        console.log(`moreActionData = ${moreActionData}`);
    }
    if (selectedChange == true) {
        await analyticsAppear();
    }
}

async function goToFavorites() {
    await openPage("marketAdd");
}

async function addFavoritesClick() {
    var symbols = Object.keys(favoritesSelectImageMap).filter((item => favoritesSelectImageMap[item] == favoriteImageSelected));
    await addFavoritesSymbols(symbols);
}

async function addFavoritesSymbols(symbols = []) {
    if (symbols == null || symbols.length == 0) {
        return;
    }
    if (commanData.isLogin == 1) {
        await updateFavoritesSymbols(symbols);
    } else {
        await $nativeAPI.homeBridge({
            action: "addFavoritesSymbolsToLocal",
            symbols: JSON.stringify(symbols)
        });
    }
    currentScreen = "spot";
    await requestRankingData();
}

async function loginStateChange() {
    if (moduleDidStart == false) {
        return;
    }
    if (commanData.userInfo.uId != currentUID) {
        currentUID = commanData.userInfo.uId;
        favoritesSelectImageMap = {};
    }
}

moduleEvent.loginStateChange = loginStateChange;

moduleEvent.rankingClicked = rankingClicked;

moduleEvent.moreButtonClicked = moreButtonClicked;

moduleEvent.interactionTitleClick = interactionTitleClick;

moduleEvent.tabClick = tabClick;

moduleEvent.resetTitleSelectTab = resetTitleSelectTab;

moduleEvent.goToFavorites = goToFavorites;

moduleEvent.selectedFavoriteSymbol = selectedFavoriteSymbol;

moduleEvent.addFavoritesClick = addFavoritesClick;

$event.rankingpop = {};

async function rankingPopClick(name) {
    $data.rankingpop.popshow = false;
    if (currentScreen != name) {
        currentScreen = name;
        await resetFavoritesListData();
    }
}

$event.rankingpop.rankingPopClick = rankingPopClick;

$event.rankingpop.cancel = function() {
    $data.rankingpop.popshow = false;
};

$event.rankingpop.popDismiss = function() {
    if ($data.rankingpop.popshow != false) {
        $data.rankingpop.popshow = false;
    }
};

var timerObject;

var currentLoginStateKey;

async function initEngine() {}

async function pageAppear() {
    startTimer();
    startScroll();
    refreshAvatar();
    await requestServicesTime();
}

async function pageDisappear() {
    clearTimer();
    endScroll();
    clearBannerExposureMap();
    clearOperationExposureMap();
    clearCubeExposureMap();
}

function startTimer() {
    if (timerObject == null) {
        timerObject = setInterval(timer, 1e3);
    }
}

function clearTimer() {
    if (timerObject) {
        clearInterval(timerObject);
        timerObject = null;
    }
}

async function timer() {
    await checkMessageCountTimer();
    await checkRequestTimer();
    await runTradingToEarnCountDown();
    await countDown();
}

function sendSymbolInfo(info) {
    commanData.symbolInfo = info;
}

async function sendSocketData(data) {
    if (data.type == "market") {
        console.log("resetMarketData");
        commanData.marketData = Object.assign(commanData.marketData, data.data);
        resetMarketData();
        resetMarketData$1();
    }
}

async function sendLoginStatus(data) {
    sendLoginStatus$1(data);
    var loginStateKey = `${commanData.isLogin}_${commanData.userInfo.uId}`;
    if (currentLoginStateKey == null || currentLoginStateKey != loginStateKey) {
        currentLoginStateKey = loginStateKey;
        await loginStateChange$3();
        await loginStateChange();
        await loginStateChange$2();
        await loginStateChange$1();
    }
}

async function sendRateTypeStr(data) {
    commanData.rateTypeStr = data.character;
    await resetMarketTitle();
}

function sendCommonConfig(param) {
    sendCommonConfig$1(param);
}

$event.updateHasNewVersion = function(param) {
    commanData.hasNewVersion = param.hasNewVersion;
};

$event.sendSymbolInfo = sendSymbolInfo;

$event.sendSocketData = sendSocketData;

$event.sendLoginStatus = sendLoginStatus;

$event.sendRateTypeStr = sendRateTypeStr;

$event.sendCommonConfig = sendCommonConfig;

$event.initEngine = initEngine;

$event.pageAppear = pageAppear;

$event.pageDisappear = pageDisappear;

startTimer();
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWFpbi5qcyIsInNvdXJjZXMiOlsiLi4vLi4vcmVwb3NpdG9yeS9ub2RlX21vZHVsZXMvYmlnLmpzL2JpZy5tanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9jb21tb24uanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9uYXYuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9tYXJrZXQuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9ndWlkZS5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL2ludmVzdC5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL2Jhbm5lci5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL2Vhcm4uanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9vcGVyYXRpb24uanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9jdWJlLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvcmFua2luZy5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL21haW4uanMiXSwic291cmNlc0NvbnRlbnQiOlsiLypcclxuICogIGJpZy5qcyB2NS4yLjJcclxuICogIEEgc21hbGwsIGZhc3QsIGVhc3ktdG8tdXNlIGxpYnJhcnkgZm9yIGFyYml0cmFyeS1wcmVjaXNpb24gZGVjaW1hbCBhcml0aG1ldGljLlxyXG4gKiAgQ29weXJpZ2h0IChjKSAyMDE4IE1pY2hhZWwgTWNsYXVnaGxpbiA8TThjaDg4bEBnbWFpbC5jb20+XHJcbiAqICBodHRwczovL2dpdGh1Yi5jb20vTWlrZU1jbC9iaWcuanMvTElDRU5DRVxyXG4gKi9cclxuXHJcblxyXG4vKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKiogRURJVEFCTEUgREVGQVVMVFMgKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKiovXHJcblxyXG5cclxuICAvLyBUaGUgZGVmYXVsdCB2YWx1ZXMgYmVsb3cgbXVzdCBiZSBpbnRlZ2VycyB3aXRoaW4gdGhlIHN0YXRlZCByYW5nZXMuXHJcblxyXG4gIC8qXHJcbiAgICogVGhlIG1heGltdW0gbnVtYmVyIG9mIGRlY2ltYWwgcGxhY2VzIChEUCkgb2YgdGhlIHJlc3VsdHMgb2Ygb3BlcmF0aW9ucyBpbnZvbHZpbmcgZGl2aXNpb246XHJcbiAgICogZGl2IGFuZCBzcXJ0LCBhbmQgcG93IHdpdGggbmVnYXRpdmUgZXhwb25lbnRzLlxyXG4gICAqL1xyXG52YXIgRFAgPSAyMCwgICAgICAgICAgLy8gMCB0byBNQVhfRFBcclxuXHJcbiAgLypcclxuICAgKiBUaGUgcm91bmRpbmcgbW9kZSAoUk0pIHVzZWQgd2hlbiByb3VuZGluZyB0byB0aGUgYWJvdmUgZGVjaW1hbCBwbGFjZXMuXHJcbiAgICpcclxuICAgKiAgMCAgVG93YXJkcyB6ZXJvIChpLmUuIHRydW5jYXRlLCBubyByb3VuZGluZykuICAgICAgIChST1VORF9ET1dOKVxyXG4gICAqICAxICBUbyBuZWFyZXN0IG5laWdoYm91ci4gSWYgZXF1aWRpc3RhbnQsIHJvdW5kIHVwLiAgKFJPVU5EX0hBTEZfVVApXHJcbiAgICogIDIgIFRvIG5lYXJlc3QgbmVpZ2hib3VyLiBJZiBlcXVpZGlzdGFudCwgdG8gZXZlbi4gICAoUk9VTkRfSEFMRl9FVkVOKVxyXG4gICAqICAzICBBd2F5IGZyb20gemVyby4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgKFJPVU5EX1VQKVxyXG4gICAqL1xyXG4gIFJNID0gMSwgICAgICAgICAgICAgLy8gMCwgMSwgMiBvciAzXHJcblxyXG4gIC8vIFRoZSBtYXhpbXVtIHZhbHVlIG9mIERQIGFuZCBCaWcuRFAuXHJcbiAgTUFYX0RQID0gMUU2LCAgICAgICAvLyAwIHRvIDEwMDAwMDBcclxuXHJcbiAgLy8gVGhlIG1heGltdW0gbWFnbml0dWRlIG9mIHRoZSBleHBvbmVudCBhcmd1bWVudCB0byB0aGUgcG93IG1ldGhvZC5cclxuICBNQVhfUE9XRVIgPSAxRTYsICAgIC8vIDEgdG8gMTAwMDAwMFxyXG5cclxuICAvKlxyXG4gICAqIFRoZSBuZWdhdGl2ZSBleHBvbmVudCAoTkUpIGF0IGFuZCBiZW5lYXRoIHdoaWNoIHRvU3RyaW5nIHJldHVybnMgZXhwb25lbnRpYWwgbm90YXRpb24uXHJcbiAgICogKEphdmFTY3JpcHQgbnVtYmVyczogLTcpXHJcbiAgICogLTEwMDAwMDAgaXMgdGhlIG1pbmltdW0gcmVjb21tZW5kZWQgZXhwb25lbnQgdmFsdWUgb2YgYSBCaWcuXHJcbiAgICovXHJcbiAgTkUgPSAtNywgICAgICAgICAgICAvLyAwIHRvIC0xMDAwMDAwXHJcblxyXG4gIC8qXHJcbiAgICogVGhlIHBvc2l0aXZlIGV4cG9uZW50IChQRSkgYXQgYW5kIGFib3ZlIHdoaWNoIHRvU3RyaW5nIHJldHVybnMgZXhwb25lbnRpYWwgbm90YXRpb24uXHJcbiAgICogKEphdmFTY3JpcHQgbnVtYmVyczogMjEpXHJcbiAgICogMTAwMDAwMCBpcyB0aGUgbWF4aW11bSByZWNvbW1lbmRlZCBleHBvbmVudCB2YWx1ZSBvZiBhIEJpZy5cclxuICAgKiAoVGhpcyBsaW1pdCBpcyBub3QgZW5mb3JjZWQgb3IgY2hlY2tlZC4pXHJcbiAgICovXHJcbiAgUEUgPSAyMSwgICAgICAgICAgICAvLyAwIHRvIDEwMDAwMDBcclxuXHJcblxyXG4vKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKiovXHJcblxyXG5cclxuICAvLyBFcnJvciBtZXNzYWdlcy5cclxuICBOQU1FID0gJ1tiaWcuanNdICcsXHJcbiAgSU5WQUxJRCA9IE5BTUUgKyAnSW52YWxpZCAnLFxyXG4gIElOVkFMSURfRFAgPSBJTlZBTElEICsgJ2RlY2ltYWwgcGxhY2VzJyxcclxuICBJTlZBTElEX1JNID0gSU5WQUxJRCArICdyb3VuZGluZyBtb2RlJyxcclxuICBESVZfQllfWkVSTyA9IE5BTUUgKyAnRGl2aXNpb24gYnkgemVybycsXHJcblxyXG4gIC8vIFRoZSBzaGFyZWQgcHJvdG90eXBlIG9iamVjdC5cclxuICBQID0ge30sXHJcbiAgVU5ERUZJTkVEID0gdm9pZCAwLFxyXG4gIE5VTUVSSUMgPSAvXi0/KFxcZCsoXFwuXFxkKik/fFxcLlxcZCspKGVbKy1dP1xcZCspPyQvaTtcclxuXHJcblxyXG4vKlxyXG4gKiBDcmVhdGUgYW5kIHJldHVybiBhIEJpZyBjb25zdHJ1Y3Rvci5cclxuICpcclxuICovXHJcbmZ1bmN0aW9uIF9CaWdfKCkge1xyXG5cclxuICAvKlxyXG4gICAqIFRoZSBCaWcgY29uc3RydWN0b3IgYW5kIGV4cG9ydGVkIGZ1bmN0aW9uLlxyXG4gICAqIENyZWF0ZSBhbmQgcmV0dXJuIGEgbmV3IGluc3RhbmNlIG9mIGEgQmlnIG51bWJlciBvYmplY3QuXHJcbiAgICpcclxuICAgKiBuIHtudW1iZXJ8c3RyaW5nfEJpZ30gQSBudW1lcmljIHZhbHVlLlxyXG4gICAqL1xyXG4gIGZ1bmN0aW9uIEJpZyhuKSB7XHJcbiAgICB2YXIgeCA9IHRoaXM7XHJcblxyXG4gICAgLy8gRW5hYmxlIGNvbnN0cnVjdG9yIHVzYWdlIHdpdGhvdXQgbmV3LlxyXG4gICAgaWYgKCEoeCBpbnN0YW5jZW9mIEJpZykpIHJldHVybiBuID09PSBVTkRFRklORUQgPyBfQmlnXygpIDogbmV3IEJpZyhuKTtcclxuXHJcbiAgICAvLyBEdXBsaWNhdGUuXHJcbiAgICBpZiAobiBpbnN0YW5jZW9mIEJpZykge1xyXG4gICAgICB4LnMgPSBuLnM7XHJcbiAgICAgIHguZSA9IG4uZTtcclxuICAgICAgeC5jID0gbi5jLnNsaWNlKCk7XHJcbiAgICB9IGVsc2Uge1xyXG4gICAgICBwYXJzZSh4LCBuKTtcclxuICAgIH1cclxuXHJcbiAgICAvKlxyXG4gICAgICogUmV0YWluIGEgcmVmZXJlbmNlIHRvIHRoaXMgQmlnIGNvbnN0cnVjdG9yLCBhbmQgc2hhZG93IEJpZy5wcm90b3R5cGUuY29uc3RydWN0b3Igd2hpY2hcclxuICAgICAqIHBvaW50cyB0byBPYmplY3QuXHJcbiAgICAgKi9cclxuICAgIHguY29uc3RydWN0b3IgPSBCaWc7XHJcbiAgfVxyXG5cclxuICBCaWcucHJvdG90eXBlID0gUDtcclxuICBCaWcuRFAgPSBEUDtcclxuICBCaWcuUk0gPSBSTTtcclxuICBCaWcuTkUgPSBORTtcclxuICBCaWcuUEUgPSBQRTtcclxuICBCaWcudmVyc2lvbiA9ICc1LjIuMic7XHJcblxyXG4gIHJldHVybiBCaWc7XHJcbn1cclxuXHJcblxyXG4vKlxyXG4gKiBQYXJzZSB0aGUgbnVtYmVyIG9yIHN0cmluZyB2YWx1ZSBwYXNzZWQgdG8gYSBCaWcgY29uc3RydWN0b3IuXHJcbiAqXHJcbiAqIHgge0JpZ30gQSBCaWcgbnVtYmVyIGluc3RhbmNlLlxyXG4gKiBuIHtudW1iZXJ8c3RyaW5nfSBBIG51bWVyaWMgdmFsdWUuXHJcbiAqL1xyXG5mdW5jdGlvbiBwYXJzZSh4LCBuKSB7XHJcbiAgdmFyIGUsIGksIG5sO1xyXG5cclxuICAvLyBNaW51cyB6ZXJvP1xyXG4gIGlmIChuID09PSAwICYmIDEgLyBuIDwgMCkgbiA9ICctMCc7XHJcbiAgZWxzZSBpZiAoIU5VTUVSSUMudGVzdChuICs9ICcnKSkgdGhyb3cgRXJyb3IoSU5WQUxJRCArICdudW1iZXInKTtcclxuXHJcbiAgLy8gRGV0ZXJtaW5lIHNpZ24uXHJcbiAgeC5zID0gbi5jaGFyQXQoMCkgPT0gJy0nID8gKG4gPSBuLnNsaWNlKDEpLCAtMSkgOiAxO1xyXG5cclxuICAvLyBEZWNpbWFsIHBvaW50P1xyXG4gIGlmICgoZSA9IG4uaW5kZXhPZignLicpKSA+IC0xKSBuID0gbi5yZXBsYWNlKCcuJywgJycpO1xyXG5cclxuICAvLyBFeHBvbmVudGlhbCBmb3JtP1xyXG4gIGlmICgoaSA9IG4uc2VhcmNoKC9lL2kpKSA+IDApIHtcclxuXHJcbiAgICAvLyBEZXRlcm1pbmUgZXhwb25lbnQuXHJcbiAgICBpZiAoZSA8IDApIGUgPSBpO1xyXG4gICAgZSArPSArbi5zbGljZShpICsgMSk7XHJcbiAgICBuID0gbi5zdWJzdHJpbmcoMCwgaSk7XHJcbiAgfSBlbHNlIGlmIChlIDwgMCkge1xyXG5cclxuICAgIC8vIEludGVnZXIuXHJcbiAgICBlID0gbi5sZW5ndGg7XHJcbiAgfVxyXG5cclxuICBubCA9IG4ubGVuZ3RoO1xyXG5cclxuICAvLyBEZXRlcm1pbmUgbGVhZGluZyB6ZXJvcy5cclxuICBmb3IgKGkgPSAwOyBpIDwgbmwgJiYgbi5jaGFyQXQoaSkgPT0gJzAnOykgKytpO1xyXG5cclxuICBpZiAoaSA9PSBubCkge1xyXG5cclxuICAgIC8vIFplcm8uXHJcbiAgICB4LmMgPSBbeC5lID0gMF07XHJcbiAgfSBlbHNlIHtcclxuXHJcbiAgICAvLyBEZXRlcm1pbmUgdHJhaWxpbmcgemVyb3MuXHJcbiAgICBmb3IgKDsgbmwgPiAwICYmIG4uY2hhckF0KC0tbmwpID09ICcwJzspO1xyXG4gICAgeC5lID0gZSAtIGkgLSAxO1xyXG4gICAgeC5jID0gW107XHJcblxyXG4gICAgLy8gQ29udmVydCBzdHJpbmcgdG8gYXJyYXkgb2YgZGlnaXRzIHdpdGhvdXQgbGVhZGluZy90cmFpbGluZyB6ZXJvcy5cclxuICAgIGZvciAoZSA9IDA7IGkgPD0gbmw7KSB4LmNbZSsrXSA9ICtuLmNoYXJBdChpKyspO1xyXG4gIH1cclxuXHJcbiAgcmV0dXJuIHg7XHJcbn1cclxuXHJcblxyXG4vKlxyXG4gKiBSb3VuZCBCaWcgeCB0byBhIG1heGltdW0gb2YgZHAgZGVjaW1hbCBwbGFjZXMgdXNpbmcgcm91bmRpbmcgbW9kZSBybS5cclxuICogQ2FsbGVkIGJ5IHN0cmluZ2lmeSwgUC5kaXYsIFAucm91bmQgYW5kIFAuc3FydC5cclxuICpcclxuICogeCB7QmlnfSBUaGUgQmlnIHRvIHJvdW5kLlxyXG4gKiBkcCB7bnVtYmVyfSBJbnRlZ2VyLCAwIHRvIE1BWF9EUCBpbmNsdXNpdmUuXHJcbiAqIHJtIHtudW1iZXJ9IDAsIDEsIDIgb3IgMyAoRE9XTiwgSEFMRl9VUCwgSEFMRl9FVkVOLCBVUClcclxuICogW21vcmVdIHtib29sZWFufSBXaGV0aGVyIHRoZSByZXN1bHQgb2YgZGl2aXNpb24gd2FzIHRydW5jYXRlZC5cclxuICovXHJcbmZ1bmN0aW9uIHJvdW5kKHgsIGRwLCBybSwgbW9yZSkge1xyXG4gIHZhciB4YyA9IHguYyxcclxuICAgIGkgPSB4LmUgKyBkcCArIDE7XHJcblxyXG4gIGlmIChpIDwgeGMubGVuZ3RoKSB7XHJcbiAgICBpZiAocm0gPT09IDEpIHtcclxuXHJcbiAgICAgIC8vIHhjW2ldIGlzIHRoZSBkaWdpdCBhZnRlciB0aGUgZGlnaXQgdGhhdCBtYXkgYmUgcm91bmRlZCB1cC5cclxuICAgICAgbW9yZSA9IHhjW2ldID49IDU7XHJcbiAgICB9IGVsc2UgaWYgKHJtID09PSAyKSB7XHJcbiAgICAgIG1vcmUgPSB4Y1tpXSA+IDUgfHwgeGNbaV0gPT0gNSAmJlxyXG4gICAgICAgIChtb3JlIHx8IGkgPCAwIHx8IHhjW2kgKyAxXSAhPT0gVU5ERUZJTkVEIHx8IHhjW2kgLSAxXSAmIDEpO1xyXG4gICAgfSBlbHNlIGlmIChybSA9PT0gMykge1xyXG4gICAgICBtb3JlID0gbW9yZSB8fCAhIXhjWzBdO1xyXG4gICAgfSBlbHNlIHtcclxuICAgICAgbW9yZSA9IGZhbHNlO1xyXG4gICAgICBpZiAocm0gIT09IDApIHRocm93IEVycm9yKElOVkFMSURfUk0pO1xyXG4gICAgfVxyXG5cclxuICAgIGlmIChpIDwgMSkge1xyXG4gICAgICB4Yy5sZW5ndGggPSAxO1xyXG5cclxuICAgICAgaWYgKG1vcmUpIHtcclxuXHJcbiAgICAgICAgLy8gMSwgMC4xLCAwLjAxLCAwLjAwMSwgMC4wMDAxIGV0Yy5cclxuICAgICAgICB4LmUgPSAtZHA7XHJcbiAgICAgICAgeGNbMF0gPSAxO1xyXG4gICAgICB9IGVsc2Uge1xyXG5cclxuICAgICAgICAvLyBaZXJvLlxyXG4gICAgICAgIHhjWzBdID0geC5lID0gMDtcclxuICAgICAgfVxyXG4gICAgfSBlbHNlIHtcclxuXHJcbiAgICAgIC8vIFJlbW92ZSBhbnkgZGlnaXRzIGFmdGVyIHRoZSByZXF1aXJlZCBkZWNpbWFsIHBsYWNlcy5cclxuICAgICAgeGMubGVuZ3RoID0gaS0tO1xyXG5cclxuICAgICAgLy8gUm91bmQgdXA/XHJcbiAgICAgIGlmIChtb3JlKSB7XHJcblxyXG4gICAgICAgIC8vIFJvdW5kaW5nIHVwIG1heSBtZWFuIHRoZSBwcmV2aW91cyBkaWdpdCBoYXMgdG8gYmUgcm91bmRlZCB1cC5cclxuICAgICAgICBmb3IgKDsgKyt4Y1tpXSA+IDk7KSB7XHJcbiAgICAgICAgICB4Y1tpXSA9IDA7XHJcbiAgICAgICAgICBpZiAoIWktLSkge1xyXG4gICAgICAgICAgICArK3guZTtcclxuICAgICAgICAgICAgeGMudW5zaGlmdCgxKTtcclxuICAgICAgICAgIH1cclxuICAgICAgICB9XHJcbiAgICAgIH1cclxuXHJcbiAgICAgIC8vIFJlbW92ZSB0cmFpbGluZyB6ZXJvcy5cclxuICAgICAgZm9yIChpID0geGMubGVuZ3RoOyAheGNbLS1pXTspIHhjLnBvcCgpO1xyXG4gICAgfVxyXG4gIH0gZWxzZSBpZiAocm0gPCAwIHx8IHJtID4gMyB8fCBybSAhPT0gfn5ybSkge1xyXG4gICAgdGhyb3cgRXJyb3IoSU5WQUxJRF9STSk7XHJcbiAgfVxyXG5cclxuICByZXR1cm4geDtcclxufVxyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIHN0cmluZyByZXByZXNlbnRpbmcgdGhlIHZhbHVlIG9mIEJpZyB4IGluIG5vcm1hbCBvciBleHBvbmVudGlhbCBub3RhdGlvbi5cclxuICogSGFuZGxlcyBQLnRvRXhwb25lbnRpYWwsIFAudG9GaXhlZCwgUC50b0pTT04sIFAudG9QcmVjaXNpb24sIFAudG9TdHJpbmcgYW5kIFAudmFsdWVPZi5cclxuICpcclxuICogeCB7QmlnfVxyXG4gKiBpZD8ge251bWJlcn0gQ2FsbGVyIGlkLlxyXG4gKiAgICAgICAgIDEgdG9FeHBvbmVudGlhbFxyXG4gKiAgICAgICAgIDIgdG9GaXhlZFxyXG4gKiAgICAgICAgIDMgdG9QcmVjaXNpb25cclxuICogICAgICAgICA0IHZhbHVlT2ZcclxuICogbj8ge251bWJlcnx1bmRlZmluZWR9IENhbGxlcidzIGFyZ3VtZW50LlxyXG4gKiBrPyB7bnVtYmVyfHVuZGVmaW5lZH1cclxuICovXHJcbmZ1bmN0aW9uIHN0cmluZ2lmeSh4LCBpZCwgbiwgaykge1xyXG4gIHZhciBlLCBzLFxyXG4gICAgQmlnID0geC5jb25zdHJ1Y3RvcixcclxuICAgIHogPSAheC5jWzBdO1xyXG5cclxuICBpZiAobiAhPT0gVU5ERUZJTkVEKSB7XHJcbiAgICBpZiAobiAhPT0gfn5uIHx8IG4gPCAoaWQgPT0gMykgfHwgbiA+IE1BWF9EUCkge1xyXG4gICAgICB0aHJvdyBFcnJvcihpZCA9PSAzID8gSU5WQUxJRCArICdwcmVjaXNpb24nIDogSU5WQUxJRF9EUCk7XHJcbiAgICB9XHJcblxyXG4gICAgeCA9IG5ldyBCaWcoeCk7XHJcblxyXG4gICAgLy8gVGhlIGluZGV4IG9mIHRoZSBkaWdpdCB0aGF0IG1heSBiZSByb3VuZGVkIHVwLlxyXG4gICAgbiA9IGsgLSB4LmU7XHJcblxyXG4gICAgLy8gUm91bmQ/XHJcbiAgICBpZiAoeC5jLmxlbmd0aCA+ICsraykgcm91bmQoeCwgbiwgQmlnLlJNKTtcclxuXHJcbiAgICAvLyB0b0ZpeGVkOiByZWNhbGN1bGF0ZSBrIGFzIHguZSBtYXkgaGF2ZSBjaGFuZ2VkIGlmIHZhbHVlIHJvdW5kZWQgdXAuXHJcbiAgICBpZiAoaWQgPT0gMikgayA9IHguZSArIG4gKyAxO1xyXG5cclxuICAgIC8vIEFwcGVuZCB6ZXJvcz9cclxuICAgIGZvciAoOyB4LmMubGVuZ3RoIDwgazspIHguYy5wdXNoKDApO1xyXG4gIH1cclxuXHJcbiAgZSA9IHguZTtcclxuICBzID0geC5jLmpvaW4oJycpO1xyXG4gIG4gPSBzLmxlbmd0aDtcclxuXHJcbiAgLy8gRXhwb25lbnRpYWwgbm90YXRpb24/XHJcbiAgaWYgKGlkICE9IDIgJiYgKGlkID09IDEgfHwgaWQgPT0gMyAmJiBrIDw9IGUgfHwgZSA8PSBCaWcuTkUgfHwgZSA+PSBCaWcuUEUpKSB7XHJcbiAgICBzID0gcy5jaGFyQXQoMCkgKyAobiA+IDEgPyAnLicgKyBzLnNsaWNlKDEpIDogJycpICsgKGUgPCAwID8gJ2UnIDogJ2UrJykgKyBlO1xyXG5cclxuICAvLyBOb3JtYWwgbm90YXRpb24uXHJcbiAgfSBlbHNlIGlmIChlIDwgMCkge1xyXG4gICAgZm9yICg7ICsrZTspIHMgPSAnMCcgKyBzO1xyXG4gICAgcyA9ICcwLicgKyBzO1xyXG4gIH0gZWxzZSBpZiAoZSA+IDApIHtcclxuICAgIGlmICgrK2UgPiBuKSBmb3IgKGUgLT0gbjsgZS0tOykgcyArPSAnMCc7XHJcbiAgICBlbHNlIGlmIChlIDwgbikgcyA9IHMuc2xpY2UoMCwgZSkgKyAnLicgKyBzLnNsaWNlKGUpO1xyXG4gIH0gZWxzZSBpZiAobiA+IDEpIHtcclxuICAgIHMgPSBzLmNoYXJBdCgwKSArICcuJyArIHMuc2xpY2UoMSk7XHJcbiAgfVxyXG5cclxuICByZXR1cm4geC5zIDwgMCAmJiAoIXogfHwgaWQgPT0gNCkgPyAnLScgKyBzIDogcztcclxufVxyXG5cclxuXHJcbi8vIFByb3RvdHlwZS9pbnN0YW5jZSBtZXRob2RzXHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgbmV3IEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgYWJzb2x1dGUgdmFsdWUgb2YgdGhpcyBCaWcuXHJcbiAqL1xyXG5QLmFicyA9IGZ1bmN0aW9uICgpIHtcclxuICB2YXIgeCA9IG5ldyB0aGlzLmNvbnN0cnVjdG9yKHRoaXMpO1xyXG4gIHgucyA9IDE7XHJcbiAgcmV0dXJuIHg7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIDEgaWYgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGlzIGdyZWF0ZXIgdGhhbiB0aGUgdmFsdWUgb2YgQmlnIHksXHJcbiAqICAgICAgIC0xIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBsZXNzIHRoYW4gdGhlIHZhbHVlIG9mIEJpZyB5LCBvclxyXG4gKiAgICAgICAgMCBpZiB0aGV5IGhhdmUgdGhlIHNhbWUgdmFsdWUuXHJcbiovXHJcblAuY21wID0gZnVuY3Rpb24gKHkpIHtcclxuICB2YXIgaXNuZWcsXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIHhjID0geC5jLFxyXG4gICAgeWMgPSAoeSA9IG5ldyB4LmNvbnN0cnVjdG9yKHkpKS5jLFxyXG4gICAgaSA9IHgucyxcclxuICAgIGogPSB5LnMsXHJcbiAgICBrID0geC5lLFxyXG4gICAgbCA9IHkuZTtcclxuXHJcbiAgLy8gRWl0aGVyIHplcm8/XHJcbiAgaWYgKCF4Y1swXSB8fCAheWNbMF0pIHJldHVybiAheGNbMF0gPyAheWNbMF0gPyAwIDogLWogOiBpO1xyXG5cclxuICAvLyBTaWducyBkaWZmZXI/XHJcbiAgaWYgKGkgIT0gaikgcmV0dXJuIGk7XHJcblxyXG4gIGlzbmVnID0gaSA8IDA7XHJcblxyXG4gIC8vIENvbXBhcmUgZXhwb25lbnRzLlxyXG4gIGlmIChrICE9IGwpIHJldHVybiBrID4gbCBeIGlzbmVnID8gMSA6IC0xO1xyXG5cclxuICBqID0gKGsgPSB4Yy5sZW5ndGgpIDwgKGwgPSB5Yy5sZW5ndGgpID8gayA6IGw7XHJcblxyXG4gIC8vIENvbXBhcmUgZGlnaXQgYnkgZGlnaXQuXHJcbiAgZm9yIChpID0gLTE7ICsraSA8IGo7KSB7XHJcbiAgICBpZiAoeGNbaV0gIT0geWNbaV0pIHJldHVybiB4Y1tpXSA+IHljW2ldIF4gaXNuZWcgPyAxIDogLTE7XHJcbiAgfVxyXG5cclxuICAvLyBDb21wYXJlIGxlbmd0aHMuXHJcbiAgcmV0dXJuIGsgPT0gbCA/IDAgOiBrID4gbCBeIGlzbmVnID8gMSA6IC0xO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGRpdmlkZWQgYnkgdGhlIHZhbHVlIG9mIEJpZyB5LCByb3VuZGVkLFxyXG4gKiBpZiBuZWNlc3NhcnksIHRvIGEgbWF4aW11bSBvZiBCaWcuRFAgZGVjaW1hbCBwbGFjZXMgdXNpbmcgcm91bmRpbmcgbW9kZSBCaWcuUk0uXHJcbiAqL1xyXG5QLmRpdiA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIHggPSB0aGlzLFxyXG4gICAgQmlnID0geC5jb25zdHJ1Y3RvcixcclxuICAgIGEgPSB4LmMsICAgICAgICAgICAgICAgICAgLy8gZGl2aWRlbmRcclxuICAgIGIgPSAoeSA9IG5ldyBCaWcoeSkpLmMsICAgLy8gZGl2aXNvclxyXG4gICAgayA9IHgucyA9PSB5LnMgPyAxIDogLTEsXHJcbiAgICBkcCA9IEJpZy5EUDtcclxuXHJcbiAgaWYgKGRwICE9PSB+fmRwIHx8IGRwIDwgMCB8fCBkcCA+IE1BWF9EUCkgdGhyb3cgRXJyb3IoSU5WQUxJRF9EUCk7XHJcblxyXG4gIC8vIERpdmlzb3IgaXMgemVybz9cclxuICBpZiAoIWJbMF0pIHRocm93IEVycm9yKERJVl9CWV9aRVJPKTtcclxuXHJcbiAgLy8gRGl2aWRlbmQgaXMgMD8gUmV0dXJuICstMC5cclxuICBpZiAoIWFbMF0pIHJldHVybiBuZXcgQmlnKGsgKiAwKTtcclxuXHJcbiAgdmFyIGJsLCBidCwgbiwgY21wLCByaSxcclxuICAgIGJ6ID0gYi5zbGljZSgpLFxyXG4gICAgYWkgPSBibCA9IGIubGVuZ3RoLFxyXG4gICAgYWwgPSBhLmxlbmd0aCxcclxuICAgIHIgPSBhLnNsaWNlKDAsIGJsKSwgICAvLyByZW1haW5kZXJcclxuICAgIHJsID0gci5sZW5ndGgsXHJcbiAgICBxID0geSwgICAgICAgICAgICAgICAgLy8gcXVvdGllbnRcclxuICAgIHFjID0gcS5jID0gW10sXHJcbiAgICBxaSA9IDAsXHJcbiAgICBkID0gZHAgKyAocS5lID0geC5lIC0geS5lKSArIDE7ICAgIC8vIG51bWJlciBvZiBkaWdpdHMgb2YgdGhlIHJlc3VsdFxyXG5cclxuICBxLnMgPSBrO1xyXG4gIGsgPSBkIDwgMCA/IDAgOiBkO1xyXG5cclxuICAvLyBDcmVhdGUgdmVyc2lvbiBvZiBkaXZpc29yIHdpdGggbGVhZGluZyB6ZXJvLlxyXG4gIGJ6LnVuc2hpZnQoMCk7XHJcblxyXG4gIC8vIEFkZCB6ZXJvcyB0byBtYWtlIHJlbWFpbmRlciBhcyBsb25nIGFzIGRpdmlzb3IuXHJcbiAgZm9yICg7IHJsKysgPCBibDspIHIucHVzaCgwKTtcclxuXHJcbiAgZG8ge1xyXG5cclxuICAgIC8vIG4gaXMgaG93IG1hbnkgdGltZXMgdGhlIGRpdmlzb3IgZ29lcyBpbnRvIGN1cnJlbnQgcmVtYWluZGVyLlxyXG4gICAgZm9yIChuID0gMDsgbiA8IDEwOyBuKyspIHtcclxuXHJcbiAgICAgIC8vIENvbXBhcmUgZGl2aXNvciBhbmQgcmVtYWluZGVyLlxyXG4gICAgICBpZiAoYmwgIT0gKHJsID0gci5sZW5ndGgpKSB7XHJcbiAgICAgICAgY21wID0gYmwgPiBybCA/IDEgOiAtMTtcclxuICAgICAgfSBlbHNlIHtcclxuICAgICAgICBmb3IgKHJpID0gLTEsIGNtcCA9IDA7ICsrcmkgPCBibDspIHtcclxuICAgICAgICAgIGlmIChiW3JpXSAhPSByW3JpXSkge1xyXG4gICAgICAgICAgICBjbXAgPSBiW3JpXSA+IHJbcmldID8gMSA6IC0xO1xyXG4gICAgICAgICAgICBicmVhaztcclxuICAgICAgICAgIH1cclxuICAgICAgICB9XHJcbiAgICAgIH1cclxuXHJcbiAgICAgIC8vIElmIGRpdmlzb3IgPCByZW1haW5kZXIsIHN1YnRyYWN0IGRpdmlzb3IgZnJvbSByZW1haW5kZXIuXHJcbiAgICAgIGlmIChjbXAgPCAwKSB7XHJcblxyXG4gICAgICAgIC8vIFJlbWFpbmRlciBjYW4ndCBiZSBtb3JlIHRoYW4gMSBkaWdpdCBsb25nZXIgdGhhbiBkaXZpc29yLlxyXG4gICAgICAgIC8vIEVxdWFsaXNlIGxlbmd0aHMgdXNpbmcgZGl2aXNvciB3aXRoIGV4dHJhIGxlYWRpbmcgemVybz9cclxuICAgICAgICBmb3IgKGJ0ID0gcmwgPT0gYmwgPyBiIDogYno7IHJsOykge1xyXG4gICAgICAgICAgaWYgKHJbLS1ybF0gPCBidFtybF0pIHtcclxuICAgICAgICAgICAgcmkgPSBybDtcclxuICAgICAgICAgICAgZm9yICg7IHJpICYmICFyWy0tcmldOykgcltyaV0gPSA5O1xyXG4gICAgICAgICAgICAtLXJbcmldO1xyXG4gICAgICAgICAgICByW3JsXSArPSAxMDtcclxuICAgICAgICAgIH1cclxuICAgICAgICAgIHJbcmxdIC09IGJ0W3JsXTtcclxuICAgICAgICB9XHJcblxyXG4gICAgICAgIGZvciAoOyAhclswXTspIHIuc2hpZnQoKTtcclxuICAgICAgfSBlbHNlIHtcclxuICAgICAgICBicmVhaztcclxuICAgICAgfVxyXG4gICAgfVxyXG5cclxuICAgIC8vIEFkZCB0aGUgZGlnaXQgbiB0byB0aGUgcmVzdWx0IGFycmF5LlxyXG4gICAgcWNbcWkrK10gPSBjbXAgPyBuIDogKytuO1xyXG5cclxuICAgIC8vIFVwZGF0ZSB0aGUgcmVtYWluZGVyLlxyXG4gICAgaWYgKHJbMF0gJiYgY21wKSByW3JsXSA9IGFbYWldIHx8IDA7XHJcbiAgICBlbHNlIHIgPSBbYVthaV1dO1xyXG5cclxuICB9IHdoaWxlICgoYWkrKyA8IGFsIHx8IHJbMF0gIT09IFVOREVGSU5FRCkgJiYgay0tKTtcclxuXHJcbiAgLy8gTGVhZGluZyB6ZXJvPyBEbyBub3QgcmVtb3ZlIGlmIHJlc3VsdCBpcyBzaW1wbHkgemVybyAocWkgPT0gMSkuXHJcbiAgaWYgKCFxY1swXSAmJiBxaSAhPSAxKSB7XHJcblxyXG4gICAgLy8gVGhlcmUgY2FuJ3QgYmUgbW9yZSB0aGFuIG9uZSB6ZXJvLlxyXG4gICAgcWMuc2hpZnQoKTtcclxuICAgIHEuZS0tO1xyXG4gIH1cclxuXHJcbiAgLy8gUm91bmQ/XHJcbiAgaWYgKHFpID4gZCkgcm91bmQocSwgZHAsIEJpZy5STSwgclswXSAhPT0gVU5ERUZJTkVEKTtcclxuXHJcbiAgcmV0dXJuIHE7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIHRydWUgaWYgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGlzIGVxdWFsIHRvIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3RoZXJ3aXNlIHJldHVybiBmYWxzZS5cclxuICovXHJcblAuZXEgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHJldHVybiAhdGhpcy5jbXAoeSk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIHRydWUgaWYgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGlzIGdyZWF0ZXIgdGhhbiB0aGUgdmFsdWUgb2YgQmlnIHksIG90aGVyd2lzZSByZXR1cm5cclxuICogZmFsc2UuXHJcbiAqL1xyXG5QLmd0ID0gZnVuY3Rpb24gKHkpIHtcclxuICByZXR1cm4gdGhpcy5jbXAoeSkgPiAwO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiB0cnVlIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBncmVhdGVyIHRoYW4gb3IgZXF1YWwgdG8gdGhlIHZhbHVlIG9mIEJpZyB5LCBvdGhlcndpc2VcclxuICogcmV0dXJuIGZhbHNlLlxyXG4gKi9cclxuUC5ndGUgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHJldHVybiB0aGlzLmNtcCh5KSA+IC0xO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiB0cnVlIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBsZXNzIHRoYW4gdGhlIHZhbHVlIG9mIEJpZyB5LCBvdGhlcndpc2UgcmV0dXJuIGZhbHNlLlxyXG4gKi9cclxuUC5sdCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgcmV0dXJuIHRoaXMuY21wKHkpIDwgMDtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gdHJ1ZSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgbGVzcyB0aGFuIG9yIGVxdWFsIHRvIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3RoZXJ3aXNlXHJcbiAqIHJldHVybiBmYWxzZS5cclxuICovXHJcblAubHRlID0gZnVuY3Rpb24gKHkpIHtcclxuICByZXR1cm4gdGhpcy5jbXAoeSkgPCAxO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIG1pbnVzIHRoZSB2YWx1ZSBvZiBCaWcgeS5cclxuICovXHJcblAubWludXMgPSBQLnN1YiA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIGksIGosIHQsIHhsdHksXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5zLFxyXG4gICAgYiA9ICh5ID0gbmV3IEJpZyh5KSkucztcclxuXHJcbiAgLy8gU2lnbnMgZGlmZmVyP1xyXG4gIGlmIChhICE9IGIpIHtcclxuICAgIHkucyA9IC1iO1xyXG4gICAgcmV0dXJuIHgucGx1cyh5KTtcclxuICB9XHJcblxyXG4gIHZhciB4YyA9IHguYy5zbGljZSgpLFxyXG4gICAgeGUgPSB4LmUsXHJcbiAgICB5YyA9IHkuYyxcclxuICAgIHllID0geS5lO1xyXG5cclxuICAvLyBFaXRoZXIgemVybz9cclxuICBpZiAoIXhjWzBdIHx8ICF5Y1swXSkge1xyXG5cclxuICAgIC8vIHkgaXMgbm9uLXplcm8/IHggaXMgbm9uLXplcm8/IE9yIGJvdGggYXJlIHplcm8uXHJcbiAgICByZXR1cm4geWNbMF0gPyAoeS5zID0gLWIsIHkpIDogbmV3IEJpZyh4Y1swXSA/IHggOiAwKTtcclxuICB9XHJcblxyXG4gIC8vIERldGVybWluZSB3aGljaCBpcyB0aGUgYmlnZ2VyIG51bWJlci4gUHJlcGVuZCB6ZXJvcyB0byBlcXVhbGlzZSBleHBvbmVudHMuXHJcbiAgaWYgKGEgPSB4ZSAtIHllKSB7XHJcblxyXG4gICAgaWYgKHhsdHkgPSBhIDwgMCkge1xyXG4gICAgICBhID0gLWE7XHJcbiAgICAgIHQgPSB4YztcclxuICAgIH0gZWxzZSB7XHJcbiAgICAgIHllID0geGU7XHJcbiAgICAgIHQgPSB5YztcclxuICAgIH1cclxuXHJcbiAgICB0LnJldmVyc2UoKTtcclxuICAgIGZvciAoYiA9IGE7IGItLTspIHQucHVzaCgwKTtcclxuICAgIHQucmV2ZXJzZSgpO1xyXG4gIH0gZWxzZSB7XHJcblxyXG4gICAgLy8gRXhwb25lbnRzIGVxdWFsLiBDaGVjayBkaWdpdCBieSBkaWdpdC5cclxuICAgIGogPSAoKHhsdHkgPSB4Yy5sZW5ndGggPCB5Yy5sZW5ndGgpID8geGMgOiB5YykubGVuZ3RoO1xyXG5cclxuICAgIGZvciAoYSA9IGIgPSAwOyBiIDwgajsgYisrKSB7XHJcbiAgICAgIGlmICh4Y1tiXSAhPSB5Y1tiXSkge1xyXG4gICAgICAgIHhsdHkgPSB4Y1tiXSA8IHljW2JdO1xyXG4gICAgICAgIGJyZWFrO1xyXG4gICAgICB9XHJcbiAgICB9XHJcbiAgfVxyXG5cclxuICAvLyB4IDwgeT8gUG9pbnQgeGMgdG8gdGhlIGFycmF5IG9mIHRoZSBiaWdnZXIgbnVtYmVyLlxyXG4gIGlmICh4bHR5KSB7XHJcbiAgICB0ID0geGM7XHJcbiAgICB4YyA9IHljO1xyXG4gICAgeWMgPSB0O1xyXG4gICAgeS5zID0gLXkucztcclxuICB9XHJcblxyXG4gIC8qXHJcbiAgICogQXBwZW5kIHplcm9zIHRvIHhjIGlmIHNob3J0ZXIuIE5vIG5lZWQgdG8gYWRkIHplcm9zIHRvIHljIGlmIHNob3J0ZXIgYXMgc3VidHJhY3Rpb24gb25seVxyXG4gICAqIG5lZWRzIHRvIHN0YXJ0IGF0IHljLmxlbmd0aC5cclxuICAgKi9cclxuICBpZiAoKGIgPSAoaiA9IHljLmxlbmd0aCkgLSAoaSA9IHhjLmxlbmd0aCkpID4gMCkgZm9yICg7IGItLTspIHhjW2krK10gPSAwO1xyXG5cclxuICAvLyBTdWJ0cmFjdCB5YyBmcm9tIHhjLlxyXG4gIGZvciAoYiA9IGk7IGogPiBhOykge1xyXG4gICAgaWYgKHhjWy0tal0gPCB5Y1tqXSkge1xyXG4gICAgICBmb3IgKGkgPSBqOyBpICYmICF4Y1stLWldOykgeGNbaV0gPSA5O1xyXG4gICAgICAtLXhjW2ldO1xyXG4gICAgICB4Y1tqXSArPSAxMDtcclxuICAgIH1cclxuXHJcbiAgICB4Y1tqXSAtPSB5Y1tqXTtcclxuICB9XHJcblxyXG4gIC8vIFJlbW92ZSB0cmFpbGluZyB6ZXJvcy5cclxuICBmb3IgKDsgeGNbLS1iXSA9PT0gMDspIHhjLnBvcCgpO1xyXG5cclxuICAvLyBSZW1vdmUgbGVhZGluZyB6ZXJvcyBhbmQgYWRqdXN0IGV4cG9uZW50IGFjY29yZGluZ2x5LlxyXG4gIGZvciAoOyB4Y1swXSA9PT0gMDspIHtcclxuICAgIHhjLnNoaWZ0KCk7XHJcbiAgICAtLXllO1xyXG4gIH1cclxuXHJcbiAgaWYgKCF4Y1swXSkge1xyXG5cclxuICAgIC8vIG4gLSBuID0gKzBcclxuICAgIHkucyA9IDE7XHJcblxyXG4gICAgLy8gUmVzdWx0IG11c3QgYmUgemVyby5cclxuICAgIHhjID0gW3llID0gMF07XHJcbiAgfVxyXG5cclxuICB5LmMgPSB4YztcclxuICB5LmUgPSB5ZTtcclxuXHJcbiAgcmV0dXJuIHk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgbmV3IEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgbW9kdWxvIHRoZSB2YWx1ZSBvZiBCaWcgeS5cclxuICovXHJcblAubW9kID0gZnVuY3Rpb24gKHkpIHtcclxuICB2YXIgeWd0eCxcclxuICAgIHggPSB0aGlzLFxyXG4gICAgQmlnID0geC5jb25zdHJ1Y3RvcixcclxuICAgIGEgPSB4LnMsXHJcbiAgICBiID0gKHkgPSBuZXcgQmlnKHkpKS5zO1xyXG5cclxuICBpZiAoIXkuY1swXSkgdGhyb3cgRXJyb3IoRElWX0JZX1pFUk8pO1xyXG5cclxuICB4LnMgPSB5LnMgPSAxO1xyXG4gIHlndHggPSB5LmNtcCh4KSA9PSAxO1xyXG4gIHgucyA9IGE7XHJcbiAgeS5zID0gYjtcclxuXHJcbiAgaWYgKHlndHgpIHJldHVybiBuZXcgQmlnKHgpO1xyXG5cclxuICBhID0gQmlnLkRQO1xyXG4gIGIgPSBCaWcuUk07XHJcbiAgQmlnLkRQID0gQmlnLlJNID0gMDtcclxuICB4ID0geC5kaXYoeSk7XHJcbiAgQmlnLkRQID0gYTtcclxuICBCaWcuUk0gPSBiO1xyXG5cclxuICByZXR1cm4gdGhpcy5taW51cyh4LnRpbWVzKHkpKTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBwbHVzIHRoZSB2YWx1ZSBvZiBCaWcgeS5cclxuICovXHJcblAucGx1cyA9IFAuYWRkID0gZnVuY3Rpb24gKHkpIHtcclxuICB2YXIgdCxcclxuICAgIHggPSB0aGlzLFxyXG4gICAgQmlnID0geC5jb25zdHJ1Y3RvcixcclxuICAgIGEgPSB4LnMsXHJcbiAgICBiID0gKHkgPSBuZXcgQmlnKHkpKS5zO1xyXG5cclxuICAvLyBTaWducyBkaWZmZXI/XHJcbiAgaWYgKGEgIT0gYikge1xyXG4gICAgeS5zID0gLWI7XHJcbiAgICByZXR1cm4geC5taW51cyh5KTtcclxuICB9XHJcblxyXG4gIHZhciB4ZSA9IHguZSxcclxuICAgIHhjID0geC5jLFxyXG4gICAgeWUgPSB5LmUsXHJcbiAgICB5YyA9IHkuYztcclxuXHJcbiAgLy8gRWl0aGVyIHplcm8/IHkgaXMgbm9uLXplcm8/IHggaXMgbm9uLXplcm8/IE9yIGJvdGggYXJlIHplcm8uXHJcbiAgaWYgKCF4Y1swXSB8fCAheWNbMF0pIHJldHVybiB5Y1swXSA/IHkgOiBuZXcgQmlnKHhjWzBdID8geCA6IGEgKiAwKTtcclxuXHJcbiAgeGMgPSB4Yy5zbGljZSgpO1xyXG5cclxuICAvLyBQcmVwZW5kIHplcm9zIHRvIGVxdWFsaXNlIGV4cG9uZW50cy5cclxuICAvLyBOb3RlOiByZXZlcnNlIGZhc3RlciB0aGFuIHVuc2hpZnRzLlxyXG4gIGlmIChhID0geGUgLSB5ZSkge1xyXG4gICAgaWYgKGEgPiAwKSB7XHJcbiAgICAgIHllID0geGU7XHJcbiAgICAgIHQgPSB5YztcclxuICAgIH0gZWxzZSB7XHJcbiAgICAgIGEgPSAtYTtcclxuICAgICAgdCA9IHhjO1xyXG4gICAgfVxyXG5cclxuICAgIHQucmV2ZXJzZSgpO1xyXG4gICAgZm9yICg7IGEtLTspIHQucHVzaCgwKTtcclxuICAgIHQucmV2ZXJzZSgpO1xyXG4gIH1cclxuXHJcbiAgLy8gUG9pbnQgeGMgdG8gdGhlIGxvbmdlciBhcnJheS5cclxuICBpZiAoeGMubGVuZ3RoIC0geWMubGVuZ3RoIDwgMCkge1xyXG4gICAgdCA9IHljO1xyXG4gICAgeWMgPSB4YztcclxuICAgIHhjID0gdDtcclxuICB9XHJcblxyXG4gIGEgPSB5Yy5sZW5ndGg7XHJcblxyXG4gIC8vIE9ubHkgc3RhcnQgYWRkaW5nIGF0IHljLmxlbmd0aCAtIDEgYXMgdGhlIGZ1cnRoZXIgZGlnaXRzIG9mIHhjIGNhbiBiZSBsZWZ0IGFzIHRoZXkgYXJlLlxyXG4gIGZvciAoYiA9IDA7IGE7IHhjW2FdICU9IDEwKSBiID0gKHhjWy0tYV0gPSB4Y1thXSArIHljW2FdICsgYikgLyAxMCB8IDA7XHJcblxyXG4gIC8vIE5vIG5lZWQgdG8gY2hlY2sgZm9yIHplcm8sIGFzICt4ICsgK3kgIT0gMCAmJiAteCArIC15ICE9IDBcclxuXHJcbiAgaWYgKGIpIHtcclxuICAgIHhjLnVuc2hpZnQoYik7XHJcbiAgICArK3llO1xyXG4gIH1cclxuXHJcbiAgLy8gUmVtb3ZlIHRyYWlsaW5nIHplcm9zLlxyXG4gIGZvciAoYSA9IHhjLmxlbmd0aDsgeGNbLS1hXSA9PT0gMDspIHhjLnBvcCgpO1xyXG5cclxuICB5LmMgPSB4YztcclxuICB5LmUgPSB5ZTtcclxuXHJcbiAgcmV0dXJuIHk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyByYWlzZWQgdG8gdGhlIHBvd2VyIG4uXHJcbiAqIElmIG4gaXMgbmVnYXRpdmUsIHJvdW5kIHRvIGEgbWF4aW11bSBvZiBCaWcuRFAgZGVjaW1hbCBwbGFjZXMgdXNpbmcgcm91bmRpbmdcclxuICogbW9kZSBCaWcuUk0uXHJcbiAqXHJcbiAqIG4ge251bWJlcn0gSW50ZWdlciwgLU1BWF9QT1dFUiB0byBNQVhfUE9XRVIgaW5jbHVzaXZlLlxyXG4gKi9cclxuUC5wb3cgPSBmdW5jdGlvbiAobikge1xyXG4gIHZhciB4ID0gdGhpcyxcclxuICAgIG9uZSA9IG5ldyB4LmNvbnN0cnVjdG9yKDEpLFxyXG4gICAgeSA9IG9uZSxcclxuICAgIGlzbmVnID0gbiA8IDA7XHJcblxyXG4gIGlmIChuICE9PSB+fm4gfHwgbiA8IC1NQVhfUE9XRVIgfHwgbiA+IE1BWF9QT1dFUikgdGhyb3cgRXJyb3IoSU5WQUxJRCArICdleHBvbmVudCcpO1xyXG4gIGlmIChpc25lZykgbiA9IC1uO1xyXG5cclxuICBmb3IgKDs7KSB7XHJcbiAgICBpZiAobiAmIDEpIHkgPSB5LnRpbWVzKHgpO1xyXG4gICAgbiA+Pj0gMTtcclxuICAgIGlmICghbikgYnJlYWs7XHJcbiAgICB4ID0geC50aW1lcyh4KTtcclxuICB9XHJcblxyXG4gIHJldHVybiBpc25lZyA/IG9uZS5kaXYoeSkgOiB5O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIHJvdW5kZWQgdXNpbmcgcm91bmRpbmcgbW9kZSBybVxyXG4gKiB0byBhIG1heGltdW0gb2YgZHAgZGVjaW1hbCBwbGFjZXMsIG9yLCBpZiBkcCBpcyBuZWdhdGl2ZSwgdG8gYW4gaW50ZWdlciB3aGljaCBpcyBhXHJcbiAqIG11bHRpcGxlIG9mIDEwKiotZHAuXHJcbiAqIElmIGRwIGlzIG5vdCBzcGVjaWZpZWQsIHJvdW5kIHRvIDAgZGVjaW1hbCBwbGFjZXMuXHJcbiAqIElmIHJtIGlzIG5vdCBzcGVjaWZpZWQsIHVzZSBCaWcuUk0uXHJcbiAqXHJcbiAqIGRwPyB7bnVtYmVyfSBJbnRlZ2VyLCAtTUFYX0RQIHRvIE1BWF9EUCBpbmNsdXNpdmUuXHJcbiAqIHJtPyAwLCAxLCAyIG9yIDMgKFJPVU5EX0RPV04sIFJPVU5EX0hBTEZfVVAsIFJPVU5EX0hBTEZfRVZFTiwgUk9VTkRfVVApXHJcbiAqL1xyXG5QLnJvdW5kID0gZnVuY3Rpb24gKGRwLCBybSkge1xyXG4gIHZhciBCaWcgPSB0aGlzLmNvbnN0cnVjdG9yO1xyXG4gIGlmIChkcCA9PT0gVU5ERUZJTkVEKSBkcCA9IDA7XHJcbiAgZWxzZSBpZiAoZHAgIT09IH5+ZHAgfHwgZHAgPCAtTUFYX0RQIHx8IGRwID4gTUFYX0RQKSB0aHJvdyBFcnJvcihJTlZBTElEX0RQKTtcclxuICByZXR1cm4gcm91bmQobmV3IEJpZyh0aGlzKSwgZHAsIHJtID09PSBVTkRFRklORUQgPyBCaWcuUk0gOiBybSk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgbmV3IEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgc3F1YXJlIHJvb3Qgb2YgdGhlIHZhbHVlIG9mIHRoaXMgQmlnLCByb3VuZGVkLCBpZlxyXG4gKiBuZWNlc3NhcnksIHRvIGEgbWF4aW11bSBvZiBCaWcuRFAgZGVjaW1hbCBwbGFjZXMgdXNpbmcgcm91bmRpbmcgbW9kZSBCaWcuUk0uXHJcbiAqL1xyXG5QLnNxcnQgPSBmdW5jdGlvbiAoKSB7XHJcbiAgdmFyIHIsIGMsIHQsXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBzID0geC5zLFxyXG4gICAgZSA9IHguZSxcclxuICAgIGhhbGYgPSBuZXcgQmlnKDAuNSk7XHJcblxyXG4gIC8vIFplcm8/XHJcbiAgaWYgKCF4LmNbMF0pIHJldHVybiBuZXcgQmlnKHgpO1xyXG5cclxuICAvLyBOZWdhdGl2ZT9cclxuICBpZiAocyA8IDApIHRocm93IEVycm9yKE5BTUUgKyAnTm8gc3F1YXJlIHJvb3QnKTtcclxuXHJcbiAgLy8gRXN0aW1hdGUuXHJcbiAgcyA9IE1hdGguc3FydCh4ICsgJycpO1xyXG5cclxuICAvLyBNYXRoLnNxcnQgdW5kZXJmbG93L292ZXJmbG93P1xyXG4gIC8vIFJlLWVzdGltYXRlOiBwYXNzIHggY29lZmZpY2llbnQgdG8gTWF0aC5zcXJ0IGFzIGludGVnZXIsIHRoZW4gYWRqdXN0IHRoZSByZXN1bHQgZXhwb25lbnQuXHJcbiAgaWYgKHMgPT09IDAgfHwgcyA9PT0gMSAvIDApIHtcclxuICAgIGMgPSB4LmMuam9pbignJyk7XHJcbiAgICBpZiAoIShjLmxlbmd0aCArIGUgJiAxKSkgYyArPSAnMCc7XHJcbiAgICBzID0gTWF0aC5zcXJ0KGMpO1xyXG4gICAgZSA9ICgoZSArIDEpIC8gMiB8IDApIC0gKGUgPCAwIHx8IGUgJiAxKTtcclxuICAgIHIgPSBuZXcgQmlnKChzID09IDEgLyAwID8gJzFlJyA6IChzID0gcy50b0V4cG9uZW50aWFsKCkpLnNsaWNlKDAsIHMuaW5kZXhPZignZScpICsgMSkpICsgZSk7XHJcbiAgfSBlbHNlIHtcclxuICAgIHIgPSBuZXcgQmlnKHMpO1xyXG4gIH1cclxuXHJcbiAgZSA9IHIuZSArIChCaWcuRFAgKz0gNCk7XHJcblxyXG4gIC8vIE5ld3Rvbi1SYXBoc29uIGl0ZXJhdGlvbi5cclxuICBkbyB7XHJcbiAgICB0ID0gcjtcclxuICAgIHIgPSBoYWxmLnRpbWVzKHQucGx1cyh4LmRpdih0KSkpO1xyXG4gIH0gd2hpbGUgKHQuYy5zbGljZSgwLCBlKS5qb2luKCcnKSAhPT0gci5jLnNsaWNlKDAsIGUpLmpvaW4oJycpKTtcclxuXHJcbiAgcmV0dXJuIHJvdW5kKHIsIEJpZy5EUCAtPSA0LCBCaWcuUk0pO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIHRpbWVzIHRoZSB2YWx1ZSBvZiBCaWcgeS5cclxuICovXHJcblAudGltZXMgPSBQLm11bCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIGMsXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICB4YyA9IHguYyxcclxuICAgIHljID0gKHkgPSBuZXcgQmlnKHkpKS5jLFxyXG4gICAgYSA9IHhjLmxlbmd0aCxcclxuICAgIGIgPSB5Yy5sZW5ndGgsXHJcbiAgICBpID0geC5lLFxyXG4gICAgaiA9IHkuZTtcclxuXHJcbiAgLy8gRGV0ZXJtaW5lIHNpZ24gb2YgcmVzdWx0LlxyXG4gIHkucyA9IHgucyA9PSB5LnMgPyAxIDogLTE7XHJcblxyXG4gIC8vIFJldHVybiBzaWduZWQgMCBpZiBlaXRoZXIgMC5cclxuICBpZiAoIXhjWzBdIHx8ICF5Y1swXSkgcmV0dXJuIG5ldyBCaWcoeS5zICogMCk7XHJcblxyXG4gIC8vIEluaXRpYWxpc2UgZXhwb25lbnQgb2YgcmVzdWx0IGFzIHguZSArIHkuZS5cclxuICB5LmUgPSBpICsgajtcclxuXHJcbiAgLy8gSWYgYXJyYXkgeGMgaGFzIGZld2VyIGRpZ2l0cyB0aGFuIHljLCBzd2FwIHhjIGFuZCB5YywgYW5kIGxlbmd0aHMuXHJcbiAgaWYgKGEgPCBiKSB7XHJcbiAgICBjID0geGM7XHJcbiAgICB4YyA9IHljO1xyXG4gICAgeWMgPSBjO1xyXG4gICAgaiA9IGE7XHJcbiAgICBhID0gYjtcclxuICAgIGIgPSBqO1xyXG4gIH1cclxuXHJcbiAgLy8gSW5pdGlhbGlzZSBjb2VmZmljaWVudCBhcnJheSBvZiByZXN1bHQgd2l0aCB6ZXJvcy5cclxuICBmb3IgKGMgPSBuZXcgQXJyYXkoaiA9IGEgKyBiKTsgai0tOykgY1tqXSA9IDA7XHJcblxyXG4gIC8vIE11bHRpcGx5LlxyXG5cclxuICAvLyBpIGlzIGluaXRpYWxseSB4Yy5sZW5ndGguXHJcbiAgZm9yIChpID0gYjsgaS0tOykge1xyXG4gICAgYiA9IDA7XHJcblxyXG4gICAgLy8gYSBpcyB5Yy5sZW5ndGguXHJcbiAgICBmb3IgKGogPSBhICsgaTsgaiA+IGk7KSB7XHJcblxyXG4gICAgICAvLyBDdXJyZW50IHN1bSBvZiBwcm9kdWN0cyBhdCB0aGlzIGRpZ2l0IHBvc2l0aW9uLCBwbHVzIGNhcnJ5LlxyXG4gICAgICBiID0gY1tqXSArIHljW2ldICogeGNbaiAtIGkgLSAxXSArIGI7XHJcbiAgICAgIGNbai0tXSA9IGIgJSAxMDtcclxuXHJcbiAgICAgIC8vIGNhcnJ5XHJcbiAgICAgIGIgPSBiIC8gMTAgfCAwO1xyXG4gICAgfVxyXG5cclxuICAgIGNbal0gPSAoY1tqXSArIGIpICUgMTA7XHJcbiAgfVxyXG5cclxuICAvLyBJbmNyZW1lbnQgcmVzdWx0IGV4cG9uZW50IGlmIHRoZXJlIGlzIGEgZmluYWwgY2FycnksIG90aGVyd2lzZSByZW1vdmUgbGVhZGluZyB6ZXJvLlxyXG4gIGlmIChiKSArK3kuZTtcclxuICBlbHNlIGMuc2hpZnQoKTtcclxuXHJcbiAgLy8gUmVtb3ZlIHRyYWlsaW5nIHplcm9zLlxyXG4gIGZvciAoaSA9IGMubGVuZ3RoOyAhY1stLWldOykgYy5wb3AoKTtcclxuICB5LmMgPSBjO1xyXG5cclxuICByZXR1cm4geTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBzdHJpbmcgcmVwcmVzZW50aW5nIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpbiBleHBvbmVudGlhbCBub3RhdGlvbiB0byBkcCBmaXhlZCBkZWNpbWFsXHJcbiAqIHBsYWNlcyBhbmQgcm91bmRlZCB1c2luZyBCaWcuUk0uXHJcbiAqXHJcbiAqIGRwPyB7bnVtYmVyfSBJbnRlZ2VyLCAwIHRvIE1BWF9EUCBpbmNsdXNpdmUuXHJcbiAqL1xyXG5QLnRvRXhwb25lbnRpYWwgPSBmdW5jdGlvbiAoZHApIHtcclxuICByZXR1cm4gc3RyaW5naWZ5KHRoaXMsIDEsIGRwLCBkcCk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaW4gbm9ybWFsIG5vdGF0aW9uIHRvIGRwIGZpeGVkIGRlY2ltYWxcclxuICogcGxhY2VzIGFuZCByb3VuZGVkIHVzaW5nIEJpZy5STS5cclxuICpcclxuICogZHA/IHtudW1iZXJ9IEludGVnZXIsIDAgdG8gTUFYX0RQIGluY2x1c2l2ZS5cclxuICpcclxuICogKC0wKS50b0ZpeGVkKDApIGlzICcwJywgYnV0ICgtMC4xKS50b0ZpeGVkKDApIGlzICctMCcuXHJcbiAqICgtMCkudG9GaXhlZCgxKSBpcyAnMC4wJywgYnV0ICgtMC4wMSkudG9GaXhlZCgxKSBpcyAnLTAuMCcuXHJcbiAqL1xyXG5QLnRvRml4ZWQgPSBmdW5jdGlvbiAoZHApIHtcclxuICByZXR1cm4gc3RyaW5naWZ5KHRoaXMsIDIsIGRwLCB0aGlzLmUgKyBkcCk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgcm91bmRlZCB0byBzZCBzaWduaWZpY2FudCBkaWdpdHMgdXNpbmdcclxuICogQmlnLlJNLiBVc2UgZXhwb25lbnRpYWwgbm90YXRpb24gaWYgc2QgaXMgbGVzcyB0aGFuIHRoZSBudW1iZXIgb2YgZGlnaXRzIG5lY2Vzc2FyeSB0byByZXByZXNlbnRcclxuICogdGhlIGludGVnZXIgcGFydCBvZiB0aGUgdmFsdWUgaW4gbm9ybWFsIG5vdGF0aW9uLlxyXG4gKlxyXG4gKiBzZCB7bnVtYmVyfSBJbnRlZ2VyLCAxIHRvIE1BWF9EUCBpbmNsdXNpdmUuXHJcbiAqL1xyXG5QLnRvUHJlY2lzaW9uID0gZnVuY3Rpb24gKHNkKSB7XHJcbiAgcmV0dXJuIHN0cmluZ2lmeSh0aGlzLCAzLCBzZCwgc2QgLSAxKTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBzdHJpbmcgcmVwcmVzZW50aW5nIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZy5cclxuICogUmV0dXJuIGV4cG9uZW50aWFsIG5vdGF0aW9uIGlmIHRoaXMgQmlnIGhhcyBhIHBvc2l0aXZlIGV4cG9uZW50IGVxdWFsIHRvIG9yIGdyZWF0ZXIgdGhhblxyXG4gKiBCaWcuUEUsIG9yIGEgbmVnYXRpdmUgZXhwb25lbnQgZXF1YWwgdG8gb3IgbGVzcyB0aGFuIEJpZy5ORS5cclxuICogT21pdCB0aGUgc2lnbiBmb3IgbmVnYXRpdmUgemVyby5cclxuICovXHJcblAudG9TdHJpbmcgPSBmdW5jdGlvbiAoKSB7XHJcbiAgcmV0dXJuIHN0cmluZ2lmeSh0aGlzKTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBzdHJpbmcgcmVwcmVzZW50aW5nIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZy5cclxuICogUmV0dXJuIGV4cG9uZW50aWFsIG5vdGF0aW9uIGlmIHRoaXMgQmlnIGhhcyBhIHBvc2l0aXZlIGV4cG9uZW50IGVxdWFsIHRvIG9yIGdyZWF0ZXIgdGhhblxyXG4gKiBCaWcuUEUsIG9yIGEgbmVnYXRpdmUgZXhwb25lbnQgZXF1YWwgdG8gb3IgbGVzcyB0aGFuIEJpZy5ORS5cclxuICogSW5jbHVkZSB0aGUgc2lnbiBmb3IgbmVnYXRpdmUgemVyby5cclxuICovXHJcblAudmFsdWVPZiA9IFAudG9KU09OID0gZnVuY3Rpb24gKCkge1xyXG4gIHJldHVybiBzdHJpbmdpZnkodGhpcywgNCk7XHJcbn07XHJcblxyXG5cclxuLy8gRXhwb3J0XHJcblxyXG5cclxuZXhwb3J0IHZhciBCaWcgPSBfQmlnXygpO1xyXG5cclxuZXhwb3J0IGRlZmF1bHQgQmlnO1xyXG4iLCJpbXBvcnQgQmlnIGZyb20gJ2JpZy5qcyc7XG4vLyBpbXBvcnQgeyByZSB9IGZyb20gJ21hdGhqcyc7XG5cbi8vIOminOiJsumFjee9riAwOue6oua2qOe7v+i3jCDmiJYgMTrnu7/mtqjnuqLot4xcbnZhciB1cENvbG9yTGlzdDtcbnZhciBkb3duQ29sb3JMaXN0O1xuXG4vKipcbiAqIEB0eXBlZGVmICB7T2JqZWN0fSBVc2VySW5mbyBcbiAqIEBwcm9wZXJ0eSB7c3RyaW5nfSB1SWQgICAgICAgICAgICAtIOeUqOaIt2lkXG4gKiBAcHJvcGVydHkge3N0cmluZ30gbmFtZSAgICAgICAgICAgICAgLSDnlKjmiLflkI1cbiAqIEBwcm9wZXJ0eSB7bnVtYmVyfSBpc0NoaWxkQWNjb3VudCAgICAtIOaYr+WQpuWtkOi0puWPt1xuICogQHByb3BlcnR5IHtzdHJpbmd9IGhlYWRJbWFnZSAgICAgICAgIC0g55So5oi35aS05YOPXG4gKiBAcHJvcGVydHkge251bWJlcn0gaXNORlQgICAgICAgICAgICAgLSDmmK/lkKZORlTlpLTlg49cbiAqIEBwcm9wZXJ0eSB7c3RyaW5nfSBjb3VudHJ5SWQgICAgICAgICAtIOWbveWutmlkXG4gKiBAcHJvcGVydHkge3N0cmluZ30gcmVnaXN0ZXJDb3VudHJ5SWQgICAgICAgICAtIOazqOWGjOWbveWutmlkXG4gKi9cblxuLyoqXG4gKiBAdHlwZWRlZiB7T2JqZWN0fSBDb21tYW5EYXRhIFxuICogQHByb3BlcnR5IHtvYmplY3R9IHN5bWJvbEluZm8gICAgICAgIC0g5biB5a+55L+h5oGvXG4gKiBAcHJvcGVydHkge251bWJlcn0gcHJpY2VDb2xvclR5cGUgICAgLSDku7fmoLzmtqjot4zluYXpopzoibLorr7nva4gXG4gKiBAcHJvcGVydHkge29iamVjdH0gbWFya2V0RGF0YSAgICAgICAgLSDooYzmg4XorqLpmIXkv6Hmga9cbiAqIEBwcm9wZXJ0eSB7c3RyaW5nfSBpY29uVVJMSG9zdCAgICAgICAtIOW4geenjeWbvuagh+Wfn+WQjVxuICogQHByb3BlcnR5IHtzdHJpbmd9IGljb25QbGFjZWhvbGRlciAgIC0g5Zu+5qCH6buY6K6k5Zu+XG4gKiBAcHJvcGVydHkge251bWJlcn0gcmF0ZVR5cGVTdHIgICAgICAgLSDorqHku7fmlrnlvI/lrZfnrKbkuLJcbiAqIEBwcm9wZXJ0eSB7bnVtYmVyfSBjb2xvck1vZGUgICAgICAgICAtIOeZveWkqem7keWknOaooeW8j1xuICogQHByb3BlcnR5IHtzdHJpbmd9IGxhbmd1YWdlICAgICAgICAgIC0g6K+t56eN6YWN572uXG4gKiBAcHJvcGVydHkge3N0cmluZ30gT1MgICAgICAgICAgICAgICAgLSDns7vnu59cbiAqIEBwcm9wZXJ0eSB7c3RyaW5nfSBhcHBMaWZlQ3ljbGVJZCAgICAtIGFwcOeUn+WRveWRqOacn+WUr+S4gOagh+ivhuesplxuICogQHByb3BlcnR5IHtzdHJpbmd9IGFwcFZlcnNpb24gICAgICAgIC0g54mI5pys5Y+3XG4gKiBAcHJvcGVydHkge251bWJlcn0gaGFzTmV3VmVyc2lvblx0XHQtIOaYr+WQpuacieaWsOeJiOacrFxuICogQHByb3BlcnR5IHtudW1iZXJ9IGlzSW5SZXZpZXcgICAgICAgIC0gaU9T5a6h5qC454q25oCBXG4gKiBAcHJvcGVydHkge251bWJlcn0gaXNMb2dpbiAgICAgICAgICAgLSDmmK/lkKbnmbvlvZVcbiAqIEBwcm9wZXJ0eSB7bnVtYmVyfSBzZXJ2aWNlVGltZUludGVydmFsICAgICAgLSDmnI3liqHlmajml7bpl7TkuI7mnKzlnLDml7bpl7TnmoTlgY/lt64g5q+r56eSXG4gKiBAcHJvcGVydHkge1VzZXJJbmZvfSB1c2VySW5mbyAgICAgICAgLSDnlKjmiLfkv6Hmga9cbiAqL1xuXG4vKiogQHR5cGUgQ29tbWFuRGF0YSAqL1xuZXhwb3J0IHZhciBjb21tYW5EYXRhID0ge1xuICAgIHN5bWJvbEluZm86IHt9LFxuICAgIHByaWNlQ29sb3JUeXBlOiAwLFxuICAgIG1hcmtldERhdGE6IHt9LFxuICAgIGljb25VUkxIb3N0OiBcIlwiLFxuICAgIGljb25QbGFjZWhvbGRlcjogXCJcIixcbiAgICByYXRlVHlwZVN0cjogMCxcbiAgICBjb2xvck1vZGU6IDAsXG4gICAgT1M6IFwiXCIsXG4gICAgYXBwVmVyc2lvbjogXCJcIixcbiAgICBpc0luUmV2aWV3OiAxLFxuICAgIGlzTG9naW46IDAsXG4gICAgc2VydmljZVRpbWVJbnRlcnZhbDogMCxcbiAgICBoYXNOZXdWZXJzaW9uOiBmYWxzZSxcbiAgICB1c2VySW5mbzoge31cbn07XG5cbi8v5Y+R6YCB6K+35rGCXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc2VuZFJlcXVlc3QocGF0aCwgcGFyYW1zID0ge30sIG1ldGhvZCA9IDAsIGhvc3RUeXBlID0gMCwgaGVhZGVyID0ge30pIHtcbiAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCAke3BhdGh9YCk7XG5cbiAgICBpZiAoaG9zdFR5cGUgPT0gNSB8fCBob3N0VHlwZSA9PSA2KSB7XG4gICAgICAgIGhlYWRlclsnQ29udGVudC1UeXBlJ10gPSAnYXBwbGljYXRpb24vanNvbic7XG4gICAgfVxuXG4gICAgY29uc3QgcGFyYW0gPSB7XG4gICAgICAgIHBhdGgsXG4gICAgICAgIG1ldGhvZCxcbiAgICAgICAgaG9zdFR5cGUsXG4gICAgICAgIGhlYWRlcixcbiAgICAgICAgcGFyYW1zXG4gICAgfTtcbiAgICB0cnkge1xuICAgICAgICB2YXIgcmVzcG9uc2VTdHJpbmcgPSAnJ1xuICAgICAgICBpZiAoY29tbWFuRGF0YS5PUyA9PSAwKSB7XG4gICAgICAgICAgICAvL2lPU+S9v+eUqGhvbWVSZXF1ZXN0LOWinuWKoOS6huW7tui/n+WkhOeQhlxuICAgICAgICAgICAgcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLmhvbWVSZXF1ZXN0KEpTT04uc3RyaW5naWZ5KHBhcmFtKSk7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICByZXNwb25zZVN0cmluZyA9IGF3YWl0ICRuYXRpdmVBUEkucmVxdWVzdChKU09OLnN0cmluZ2lmeShwYXJhbSkpO1xuICAgICAgICB9XG4gICAgICAgIHZhciByZXNwb25zZSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcpO1xuICAgICAgICB2YXIgeyBjb2RlLCBkYXRhIH0gPSByZXNwb25zZTtcbiAgICAgICAgaWYgKGNvZGUgPT0gMjAwKSB7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCAke3BhdGh9IGRvbmVgKTtcbiAgICAgICAgICAgIHJldHVybiBkYXRhO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgZmFpbGVkLCBjb2RlPSR7Y29kZX1gKTtcbiAgICAgICAgICAgIHJldHVybiBudWxsO1xuICAgICAgICB9XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCBlcnJvciwgZXJyb3I9JHtlfWApO1xuICAgICAgICByZXR1cm4gbnVsbDtcbiAgICB9XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzZW5kUmVxdWVzdFdpdGhDYWNoZShwYXRoLCBjYWxsYmFjaywgcGFyYW1zID0ge30sIG1ldGhvZCA9IDAsIGhvc3RUeXBlID0gMCwgaGVhZGVyID0ge30sIGNhY2hlS2V5TGlzdCA9IG51bGwpIHtcbiAgICB2YXIgY2FjaGVLZXkgPSBnZXRDYWNoZUtleShwYXRoLCBwYXJhbXMsIGNhY2hlS2V5TGlzdCk7XG4gICAgY29uc3QgY2FjaGUgPSBhd2FpdCByZWFkKFwiYXBpQ2FjaGVcIiwgY2FjaGVLZXkpO1xuICAgIGlmIChjYWNoZSAmJiBjYWxsYmFjaykge1xuICAgICAgICB0cnkge1xuICAgICAgICAgICAgYXdhaXQgY2FsbGJhY2soY2FjaGUsIHRydWUpO1xuICAgICAgICAgICAgY29uc29sZS5sb2coYHNlbmRSZXF1ZXN0V2l0aENhY2hlIGNhY2hlLCBjYWNoZT0ke0pTT04uc3RyaW5naWZ5KGNhY2hlKX0gY2FjaGVLZXk9JHtjYWNoZUtleX1gKTtcbiAgICAgICAgICAgIGF3YWl0IHVwbG9hZExvZyhcIkhPTUVcIiwgYOivu+e8k+WtmOaIkOWKnywgY2FjaGVLZXk9JHtjYWNoZUtleX1gKTtcbiAgICAgICAgfSBjYXRjaCAoZXJyb3IpIHt9XG4gICAgfVxuICAgIFxuICAgIGNvbnN0IHJlcXVlc3REYXRhID0gYXdhaXQgc2VuZFJlcXVlc3QocGF0aCwgcGFyYW1zLCBtZXRob2QsIGhvc3RUeXBlLCBoZWFkZXIpO1xuICAgIGlmIChyZXF1ZXN0RGF0YSkge1xuICAgICAgICBpZiAoY2FsbGJhY2spIHtcbiAgICAgICAgICAgIHRyeSB7XG4gICAgICAgICAgICAgICAgYXdhaXQgY2FsbGJhY2socmVxdWVzdERhdGEsIGZhbHNlKTtcbiAgICAgICAgICAgICAgICBhd2FpdCB1cGxvYWRMb2coXCJIT01FXCIsIGDnvZHot6/or7fmsYLmiJDlip8scGF0aD0ke3BhdGh9YCk7XG4gICAgICAgICAgICB9IGNhdGNoIChlcnJvcikge31cbiAgICAgICAgfVxuICAgICAgICBhd2FpdCBzYXZlKFwiYXBpQ2FjaGVcIiwgY2FjaGVLZXksIHJlcXVlc3REYXRhKTtcbiAgICAgICAgYXdhaXQgdXBsb2FkTG9nKFwiSE9NRVwiLCBg57yT5a2Y5L+d5a2Y5oiQ5YqfLCBjYWNoZUtleT0ke2NhY2hlS2V5fWApO1xuICAgICAgICBjb25zb2xlLmxvZyhgc2VuZFJlcXVlc3RXaXRoQ2FjaGUgcmVxdWVzdERhdGEsIHJlcXVlc3REYXRhPSR7SlNPTi5zdHJpbmdpZnkocmVxdWVzdERhdGEpfSBjYWNoZUtleT0ke2NhY2hlS2V5fWApO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIGF3YWl0IGNhbGxiYWNrKG51bGwsIGZhbHNlKTtcbiAgICAgICAgY29uc29sZS5sb2coYHNlbmRSZXF1ZXN0V2l0aENhY2hlIGVycm9yYCk7XG4gICAgICAgIGF3YWl0IHVwbG9hZExvZyhcIkhPTUVcIiwgYOe9kei3r+ivt+axguWksei0pSxwYXRoPSR7cGF0aH1gKTtcbiAgICB9XG4gICAgcmV0dXJuIHJlcXVlc3REYXRhO1xufVxuXG5mdW5jdGlvbiBnZXRDYWNoZUtleShwYXRoLCBwYXJhbXMsIGNhY2hlS2V5TGlzdCA9IG51bGwpIHtcbiAgICB2YXIgY2FjaGVLZXkgPSBcIlwiO1xuICAgIHZhciBsb2dpblN0YXRlID0gY29tbWFuRGF0YS5pc0xvZ2luID09IDEgPyBcInRydWVcIiA6IFwiZmFsc2VcIjtcbiAgICBpZiAoY2FjaGVLZXlMaXN0ID09IG51bGwpIHsvL251bGzvvJrmiYDmnInlj4LmlbDkvZzkuLrnvJPlrZjlj4LmlbBcbiAgICAgICAgdmFyIHBhcmFtU3RyID0gSlNPTi5zdHJpbmdpZnkocGFyYW1zKTtcbiAgICAgICAgY2FjaGVLZXkgPSBgJHtwYXRofV8ke3BhcmFtU3RyfV8ke2NvbW1hbkRhdGEubGFuZ3VhZ2V9XyR7Y29tbWFuRGF0YS5jb2xvck1vZGV9YDtcbiAgICB9XG4gICAgZWxzZSBpZiAoY2FjaGVLZXlMaXN0Lmxlbmd0aCA9PSAwKSB7IC8vIFtdICzkuKrmlbDkuLow77ya5LiN6ZyA6KaB5Y+C5pWw5L2c5Li657yT5a2Y5Y+C5pWwXG4gICAgICAgIGNhY2hlS2V5ID0gYCR7cGF0aH1fJHtjb21tYW5EYXRhLmxhbmd1YWdlfV8ke2NvbW1hbkRhdGEuY29sb3JNb2RlfWA7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgdmFyIGNhY2hlS2V5TGlzdFN0ciA9IGNhY2hlS2V5TGlzdC5qb2luKFwiX1wiKTtcbiAgICAgICAgY2FjaGVLZXkgPSBgJHtwYXRofV8ke2NhY2hlS2V5TGlzdFN0cn1fJHtjb21tYW5EYXRhLmxhbmd1YWdlfV8ke2NvbW1hbkRhdGEuY29sb3JNb2RlfWA7XG4gICAgfVxuICAgIHJldHVybiBjYWNoZUtleTtcbn1cblxuLy/ojrflj5bljZXkuKrluIHlr7nkv6Hmga9cbmV4cG9ydCBmdW5jdGlvbiBnZXRTeW1ib2xJbmZvKHN5bWJvbCkge1xuICAgIC8vIGNvbnNvbGUubG9nKCdnZXRTeW1ib2xJbmZvJyArIHN5bWJvbCk7XG4gICAgdmFyIHN5bWJvbEluZm8gPSBjb21tYW5EYXRhLnN5bWJvbEluZm9bc3ltYm9sXTtcbiAgICBpZiAoc3ltYm9sSW5mbyA9PSBudWxsKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGBnZXRTeW1ib2xJbmZvIGZhaWwgJHtzeW1ib2x9YCk7XG4gICAgfVxuICAgIHJldHVybiBzeW1ib2xJbmZvO1xufVxuXG4vL+iOt+WPlmljb27lrozmlbR1cmxcbmV4cG9ydCBmdW5jdGlvbiBnZXRJY29uVVJMKGN1cnJlbmN5KSB7XG4gICAgdmFyIGNvaW5OYW1lID0gY3VycmVuY3kudG9Mb3dlckNhc2UoKTtcbiAgICBjb25zdCBpY29uVVJMID0gYGh0dHBzOi8vJHtjb21tYW5EYXRhLmljb25VUkxIb3N0fS8tL3gvaGIvcC9hcGkvY29udGVudHMvY3VycmVuY3kvaWNvbl9wbmcvJHtjb2luTmFtZX0ucG5nYDtcbiAgICByZXR1cm4gaWNvblVSTDtcbn1cblxuLy/moLnmja7mtqjot4zluYXojrflj5bmmL7npLrpopzoibJcbmV4cG9ydCBmdW5jdGlvbiBnZXRQcmljZUNvbG9yKHJhdGlvKSB7XG4gICAgLy8gY29uc29sZS5sb2coJ2dldFByaWNlQ29sb3InKTtcbiAgICBpZiAocmF0aW8gPT0gbnVsbCkge1xuICAgICAgICByYXRpbyA9IDA7XG4gICAgfVxuICAgIGNvbnN0IHJhdGlvX2FicyA9IE1hdGguYWJzKHJhdGlvKTtcbiAgICB2YXIgY29sb3JMZXZlbCA9IDA7XG4gICAgaWYgKHJhdGlvX2FicyA+IDAgJiYgcmF0aW9fYWJzIDwgMykge1xuICAgICAgICBjb2xvckxldmVsID0gMTtcbiAgICB9XG4gICAgZWxzZSBpZiAocmF0aW9fYWJzID49IDMgJiYgcmF0aW9fYWJzIDwgOCkge1xuICAgICAgICBjb2xvckxldmVsID0gMjtcbiAgICB9XG4gICAgZWxzZSBpZiAocmF0aW9fYWJzID49IDgpIHtcbiAgICAgICAgY29sb3JMZXZlbCA9IDM7XG4gICAgfVxuICAgIHZhciBjb2xvckhleFN0ciA9IG51bGw7XG4gICAgaWYgKHJhdGlvID4gMCkge1xuICAgICAgICBjb2xvckhleFN0ciA9IHVwQ29sb3JMaXN0W2NvbG9yTGV2ZWxdO1xuICAgIH1cbiAgICBlbHNlIHtcbiAgICAgICAgY29sb3JIZXhTdHIgPSBkb3duQ29sb3JMaXN0W2NvbG9yTGV2ZWxdO1xuICAgIH1cbiAgICByZXR1cm4gY29sb3JIZXhTdHI7XG59XG5cbi8v6I635Y+W5Lu35qC85pi+56S65paH5pysXG5leHBvcnQgZnVuY3Rpb24gZ2V0UHJpY2VTdHJpbmcocHJpY2VTdHIsIHByZWNpc2lvbikge1xuICAgIGNvbnN0IHByaWNlTnVtID0gTnVtYmVyKHByaWNlU3RyKTtcbiAgICBjb25zdCBiaWdWYWx1ZSA9IG5ldyBCaWcocHJpY2VOdW0pO1xuICAgIGNvbnN0IHByaWNlU3RyaW5nID0gYmlnVmFsdWUudG9GaXhlZChwcmVjaXNpb24sIHsgbm90YXRpb246ICdmaXhlZCcsIHByZWNpc2lvbiB9KTtcbiAgICBjb25zdCBmaW5hbFByaWNlU3RyID0gcHJpY2VTdHJpbmcucmVwbGFjZSgvXFxkKD89KFxcZHszfSkrXFwuKS9nLCAnJCYsJyk7XG4gICAgcmV0dXJuIGZpbmFsUHJpY2VTdHI7XG59XG5cbi8qIOmYsuatoumHjeWkjeeCueWHuyAqL1xubGV0IGNsaWNrVGltZXIgPSAwXG5cbmZ1bmN0aW9uIGNsaWNrVGhyb3R0bGUoaW50ZXJ2YWwgPSAxMDAwKSB7XG4gICAgbGV0IG5vdyA9ICtuZXcgRGF0ZSgpOyAvLyDojrflj5blvZPliY3ml7bpl7TnmoTml7bpl7TmiLNcbiAgICBsZXQgdGltZXIgPSBjbGlja1RpbWVyOyAvLyDorrDlvZXop6blj5Hkuovku7bnmoTkuovku7bmiLNcblxuICAgIGlmIChub3cgLSB0aW1lciA8IGludGVydmFsKSB7XG4gICAgICAgIC8vIOWmguaenOW9k+WJjeaXtumXtCAtIOinpuWPkeS6i+S7tuaXtueahOS6i+S7tiA8IGludGVyVmFs77yM6YKj5LmI5LiN56ym5ZCI5p2h5Lu277yM55u05o6lcmV0dXJuIGZhbHNl77yMXG4gICAgICAgIC8vIOS4jeiuqeW9k+WJjeS6i+S7tue7p+e7reaJp+ihjOS4i+WOu1xuICAgICAgICByZXR1cm4gZmFsc2U7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgLy8g5Y+N5LmL77yM6K6w5b2V56ym5ZCI5p2h5Lu26Kem5Y+R5LqG5LqL5Lu255qE5pe26Ze05oiz77yM5bm2IHJldHVybiB0cnVl77yM5L2/5LqL5Lu257un57ut5b6A5LiL5omn6KGMXG4gICAgICAgIGNsaWNrVGltZXIgPSBub3c7XG4gICAgICAgIHJldHVybiB0cnVlO1xuICAgIH1cbn1cblxuLy/miZPlvIBVUkxcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBvcGVuVVJMKHVybCwgcGFyYW1zID0ge30pIHtcbiAgICBpZiAoIWNsaWNrVGhyb3R0bGUoKSlcbiAgICAgICAgcmV0dXJuO1xuICAgIGF3YWl0ICRuYXRpdmVBUEkuaG9tZUJyaWRnZSh7XG4gICAgICAgIGFjdGlvbjogXCJvcGVuUGFnZVwiLFxuICAgICAgICB0eXBlOiBcInVybFwiLFxuICAgICAgICBwYWdlOiB1cmwsXG4gICAgICAgIHBhcmFtczogSlNPTi5zdHJpbmdpZnkocGFyYW1zKVxuICAgIH0pO1xufVxuXG4vL+aJk+W8gOmhtemdolxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIG9wZW5QYWdlKHBhZ2UsIHBhcmFtcyA9IHt9KSB7XG4gICAgYXdhaXQgJG5hdGl2ZUFQSS5ob21lQnJpZGdlKHtcbiAgICAgICAgYWN0aW9uOiBcIm9wZW5QYWdlXCIsXG4gICAgICAgIHR5cGU6IFwibmF0aXZlXCIsXG4gICAgICAgIHBhZ2U6IHBhZ2UsXG4gICAgICAgIHBhcmFtczogSlNPTi5zdHJpbmdpZnkocGFyYW1zKVxuICAgIH0pO1xufVxuXG4vL+S/neWtmOaVsOaNrlxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNhdmUobW9kdWxlLCBrZXksIGRhdGEpIHtcbiAgICBhd2FpdCAkbmF0aXZlQVBJLnN0b3JhZ2Uoe1xuICAgICAgICBhY3Rpb246IFwic2F2ZVwiLFxuICAgICAgICBuYW1lOiBtb2R1bGUsXG4gICAgICAgIGtleToga2V5LFxuICAgICAgICBkYXRhOiBKU09OLnN0cmluZ2lmeShkYXRhKVxuICAgIH0pO1xufVxuXG4vL+ivu+WPluaVsOaNrlxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHJlYWQobW9kdWxlLCBrZXkpIHtcbiAgICBjb25zdCBkYXRhID0gYXdhaXQgJG5hdGl2ZUFQSS5zdG9yYWdlKHtcbiAgICAgICAgYWN0aW9uOiBcInJlYWRcIixcbiAgICAgICAgbmFtZTogbW9kdWxlLFxuICAgICAgICBrZXk6IGtleVxuICAgIH0pO1xuICAgIGlmIChkYXRhICYmIGRhdGEgIT0gXCJcIikge1xuICAgICAgICByZXR1cm4gSlNPTi5wYXJzZShkYXRhKTtcbiAgICB9XG4gICAgcmV0dXJuIG51bGw7XG59XG5cbi8v5riF55CG5pWw5o2uXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gY2xlYXIobW9kdWxlLCBrZXkpIHtcbiAgICBhd2FpdCAkbmF0aXZlQVBJLnN0b3JhZ2Uoe1xuICAgICAgICBhY3Rpb246IFwiY2xlYXJcIixcbiAgICAgICAgbmFtZTogbW9kdWxlLFxuICAgICAgICBrZXk6IGtleVxuICAgIH0pO1xufVxuXG4vL+a4heeQhuWFqOmDqOaVsOaNrlxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGNsZWFyQWxsKG1vZHVsZSkge1xuICAgIGF3YWl0ICRuYXRpdmVBUEkuc3RvcmFnZSh7XG4gICAgICAgIGFjdGlvbjogXCJjbGVhclwiLFxuICAgICAgICBuYW1lOiBtb2R1bGVcbiAgICB9KTtcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHVwbG9hZExvZyh0YWcsIGluZm8gPSBcIlwiKSB7XG4gICAgaWYgKGNvbW1hbkRhdGEuT1MgPT0gMCkge1xuICAgICAgICB2YXIgbWFwID0ge1xuICAgICAgICAgICAgdGFnOiB0YWcsXG4gICAgICAgICAgICBpbmZvOiBpbmZvXG4gICAgICAgIH07XG4gICAgICAgIGF3YWl0ICRuYXRpdmVBUEkudXBsb2FkTG9nKG1hcCk7XG4gICAgfVxuXG59XG5cbi8v5Z+L54K5XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gYW5hbHl0aWNzKGV2ZW50ID0gXCJcIiwgcHJvcGVydGllcyA9IHt9KSB7XG4gICAgY29uc3QgcHJvcGVydGllc0pzb24gPSBKU09OLnN0cmluZ2lmeShwcm9wZXJ0aWVzKTtcbiAgICBjb25zb2xlLmxvZyhgYW5hbHl0aWNzIGV2ZW50OiAke2V2ZW50fSwgcHJvcGVydGllc0pzb24gPSAke3Byb3BlcnRpZXNKc29ufWApO1xuICAgIHZhciBtYXAgPSB7XG4gICAgICAgIGV2ZW50OiBldmVudCxcbiAgICAgICAgcHJvcGVydGllczogcHJvcGVydGllc0pzb25cbiAgICB9O1xuICAgIGF3YWl0ICRuYXRpdmVBUEkuYW5hbHl0aWNzKG1hcCk7XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBzZW5kTG9naW5TdGF0dXMoZGF0YSkge1xuICAgIGNvbW1hbkRhdGEuaXNMb2dpbiA9IHBhcnNlSW50KGRhdGEuaXNMb2dpbik7XG4gICAgaWYgKGRhdGEudXNlckluZm8gIT0gbnVsbCkge1xuICAgICAgICBjb21tYW5EYXRhLnVzZXJJbmZvLm5hbWUgPSBkYXRhLnVzZXJJbmZvLm5hbWU7XG4gICAgICAgIGNvbW1hbkRhdGEudXNlckluZm8udUlkID0gZGF0YS51c2VySW5mby51SWQ7XG4gICAgICAgIGNvbW1hbkRhdGEudXNlckluZm8uaXNDaGlsZEFjY291bnQgPSBwYXJzZUludChkYXRhLnVzZXJJbmZvLmlzQ2hpbGRBY2NvdW50KTtcbiAgICAgICAgY29tbWFuRGF0YS51c2VySW5mby5oZWFkSW1hZ2UgPSBkYXRhLnVzZXJJbmZvLmhlYWRJbWFnZTtcbiAgICAgICAgY29tbWFuRGF0YS51c2VySW5mby5pc05GVCA9IHBhcnNlSW50KGRhdGEudXNlckluZm8uaXNORlQpO1xuICAgICAgICBjb21tYW5EYXRhLnVzZXJJbmZvLmNvdW50cnlJZCA9IGRhdGEudXNlckluZm8uY291bnRyeUlkO1xuICAgICAgICBjb21tYW5EYXRhLnVzZXJJbmZvLnJlZ2lzdGVyQ291bnRyeUlkID0gZGF0YS51c2VySW5mby5yZWdpc3RlckNvdW50cnlJZDtcbiAgICB9XG4gICAgY29uc29sZS5sb2coYGlzTG9naW4gPSAke2NvbW1hbkRhdGEuaXNMb2dpbn1gKTtcbn1cblxuLy/orr7nva7pgJrnlKjphY3nva5cbmV4cG9ydCBmdW5jdGlvbiBzZW5kQ29tbW9uQ29uZmlnKHBhcmFtKSB7XG4gICAgY29tbWFuRGF0YS5wcmljZUNvbG9yVHlwZSA9IHBhcnNlSW50KHBhcmFtLnByaWNlQ29sb3JUeXBlKTtcbiAgICBjb21tYW5EYXRhLmNvbG9yTW9kZSA9IHBhcnNlSW50KHBhcmFtLmNvbG9yTW9kZSk7XG4gICAgY29tbWFuRGF0YS5pY29uVVJMSG9zdCA9IHBhcmFtLmljb25VUkxIb3N0O1xuICAgIGNvbW1hbkRhdGEuaWNvblBsYWNlaG9sZGVyID0gcGFyYW0uaWNvblBsYWNlaG9sZGVyO1xuICAgIGNvbW1hbkRhdGEuT1MgPSBwYXJzZUludChwYXJhbS5PUyk7XG4gICAgY29tbWFuRGF0YS5hcHBWZXJzaW9uID0gcGFyYW0uYXBwVmVyc2lvbjtcbiAgICBjb21tYW5EYXRhLmlzSW5SZXZpZXcgPSBwYXJzZUludChwYXJhbS5pc0luUmV2aWV3KTtcbiAgICBjb21tYW5EYXRhLmxhbmd1YWdlID0gcGFyYW0ubGFuZ3VhZ2U7XG4gICAgY29tbWFuRGF0YS5hcHBMaWZlQ3ljbGVJZCA9IHBhcmFtLmFwcExpZmVDeWNsZUlkO1xuICAgIGNvbW1hbkRhdGEuaGFzTmV3VmVyc2lvbiA9IHBhcmFtLmhhc05ld1ZlcnNpb247XG5cbiAgICBjb25zb2xlLmxvZyhgY29sb3JNb2RlID0gJHtjb21tYW5EYXRhLmNvbG9yTW9kZX1gKTtcbiAgICBjb25zb2xlLmxvZyhgaXNJblJldmlldyA9ICR7Y29tbWFuRGF0YS5pc0luUmV2aWV3fWApO1xuXG4gICAgdmFyIHJlZENvbG9yTGlzdCA9IFtcIiNBREIwQjJcIiwgXCIjRTk0MzU5XCIsIFwiI0U5NDM1OVwiLCBcIiNFOTQzNTlcIl07XG4gICAgdmFyIGdyZWVuQ29sb3JMaXN0ID0gW1wiI0FEQjBCMlwiLCBcIiMwMEExNzFcIiwgXCIjMDBBMTcxXCIsIFwiIzAwQTE3MVwiXTtcblxuICAgIGlmIChwYXJzZUludChjb21tYW5EYXRhLnByaWNlQ29sb3JUeXBlKSA9PSAwKSB7XG4gICAgICAgIHVwQ29sb3JMaXN0ID0gcmVkQ29sb3JMaXN0O1xuICAgICAgICBkb3duQ29sb3JMaXN0ID0gZ3JlZW5Db2xvckxpc3Q7XG4gICAgfVxuICAgIGVsc2Uge1xuICAgICAgICB1cENvbG9yTGlzdCA9IGdyZWVuQ29sb3JMaXN0O1xuICAgICAgICBkb3duQ29sb3JMaXN0ID0gcmVkQ29sb3JMaXN0O1xuICAgIH1cbn1cblxuZXhwb3J0IGZ1bmN0aW9uIG1vZHVsZURlZmluZShtb2R1bGVOYW1lLCBzdGFydEZ1bmN0aW9uLCBkZWZhdWx0RGF0YUZ1bmN0aW9uKSB7XG4gICAgJGRhdGFbbW9kdWxlTmFtZV0gPSBkZWZhdWx0RGF0YUZ1bmN0aW9uKCk7XG4gICAgJGV2ZW50W21vZHVsZU5hbWVdID0geyBzdGFydDogc3RhcnRGdW5jdGlvbiB9O1xuICAgIHJldHVybiB7XG4gICAgICAgIG1vZHVsZUV2ZW50OiAkZXZlbnRbbW9kdWxlTmFtZV0sXG4gICAgICAgIG1vZHVsZURhdGE6ICRkYXRhW21vZHVsZU5hbWVdXG4gICAgfTtcbn1cblxuLy8gc3RhdHVzIDogMD1zaG93TG9hZGluZyAxPWhpZGVMb2FkaW5nIDI9aGlkZU1vZHVsZVxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNldE1vZHVsZVN0YXR1cyhtb2R1bGVOYW1lLCBzdGF0dXNUeXBlKSB7XG4gICAgdmFyIHN0YXR1cyA9IFwic2hvd0xvYWRpbmdcIjtcbiAgICBzd2l0Y2ggKHN0YXR1c1R5cGUpIHtcbiAgICAgICAgY2FzZSAwOlxuICAgICAgICAgICAgc3RhdHVzID0gXCJzaG93TG9hZGluZ1wiO1xuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgMTpcbiAgICAgICAgICAgIHN0YXR1cyA9IFwiaGlkZUxvYWRpbmdcIjtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIDI6XG4gICAgICAgICAgICBzdGF0dXMgPSBcImhpZGVNb2R1bGVcIjtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBkZWZhdWx0OlxuICAgICAgICAgICAgYnJlYWs7XG4gICAgfVxuICAgIGNvbnNvbGUubG9nKGAke21vZHVsZU5hbWV9IHNldE1vZHVsZVN0YXR1cyAke3N0YXR1c31gKTtcbiAgICBhd2FpdCAkbmF0aXZlQVBJLmhvbWVCcmlkZ2Uoe1xuICAgICAgICBhY3Rpb246IFwic2V0TW9kdWxlU3RhdHVzXCIsXG4gICAgICAgIHN0YXR1czogc3RhdHVzLFxuICAgICAgICBtb2R1bGVOYW1lOiBtb2R1bGVOYW1lXG4gICAgfSk7XG59XG5cbi8v5Yik5pat6KeG5Zu+5piv5ZCm5bGV56S6XG5leHBvcnQgZnVuY3Rpb24gZ2V0VmlzaWJpbGl0eVN0YXR1cyhzaG93KSB7XG4gICAgaWYgKHR5cGVvZiBzaG93ID09PSAnYm9vbGVhbicpIHtcbiAgICAgICAgcmV0dXJuIHNob3cgPyAndmlzaWJsZScgOiAnZ29uZSc7XG4gICAgfSBlbHNlIGlmICh0eXBlb2Ygc2hvdyA9PT0gJ251bWJlcicpIHtcbiAgICAgICAgcmV0dXJuIHNob3cgIT09IDAgPyAndmlzaWJsZScgOiAnZ29uZSc7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgcmV0dXJuICdnb25lJztcbiAgICB9XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBmb3JtYXREYXRlKGRhdGUsIGZtdCkge1xuICAgIGlmICgvKHkrKS8udGVzdChmbXQpKSB7XG4gICAgICAgIGZtdCA9IGZtdC5yZXBsYWNlKFJlZ0V4cC4kMSwgKGRhdGUuZ2V0RnVsbFllYXIoKSArICcnKS5zdWJzdHIoNCAtIFJlZ0V4cC4kMS5sZW5ndGgpKTtcbiAgICB9XG4gICAgbGV0IG8gPSB7XG4gICAgICAgICdNKyc6IGRhdGUuZ2V0TW9udGgoKSArIDEsXG4gICAgICAgICdkKyc6IGRhdGUuZ2V0RGF0ZSgpLFxuICAgICAgICAnaCsnOiBkYXRlLmdldEhvdXJzKCksXG4gICAgICAgICdtKyc6IGRhdGUuZ2V0TWludXRlcygpLFxuICAgICAgICAncysnOiBkYXRlLmdldFNlY29uZHMoKVxuICAgIH07XG5cbiAgICAvLyDpgY3ljobov5nkuKrlr7nosaFcbiAgICBmb3IgKGxldCBrIGluIG8pIHtcbiAgICAgICAgaWYgKG5ldyBSZWdFeHAoYCgke2t9KWApLnRlc3QoZm10KSkge1xuICAgICAgICAgICAgLy8gY29uc29sZS5sb2coYCR7a31gKVxuICAgICAgICAgICAgY29uc29sZS5sb2coUmVnRXhwLiQxKVxuICAgICAgICAgICAgbGV0IHN0ciA9IG9ba10gKyAnJztcbiAgICAgICAgICAgIGZtdCA9IGZtdC5yZXBsYWNlKFJlZ0V4cC4kMSwgKFJlZ0V4cC4kMS5sZW5ndGggPT09IDEpID8gc3RyIDogcGFkTGVmdFplcm8oc3RyKSk7XG4gICAgICAgIH1cbiAgICB9XG4gICAgcmV0dXJuIGZtdDtcbn07XG5cbmZ1bmN0aW9uIHBhZExlZnRaZXJvKHN0cikge1xuICAgIHJldHVybiAoJzAwJyArIHN0cikuc3Vic3RyKHN0ci5sZW5ndGgpO1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gcmVxdWVzdFNlcnZpY2VzVGltZSgpIHtcbiAgICB2YXIgdGltZXJJbnRlcnZhbEluZm8gPSBhd2FpdCBzZW5kUmVxdWVzdChcIi92MS9jb25maWcvcHVzaC90aW1lclwiKTtcbiAgICBjb25zb2xlLmxvZyhgdGltZXJJbnRlcnZhbEluZm8gPSAke3RpbWVySW50ZXJ2YWxJbmZvfWApO1xuICAgIGlmICh0aW1lckludGVydmFsSW5mbyAhPSBudWxsKSB7XG4gICAgICAgIGxldCBjdXJyZW50VGltZUludGVydmFsID0gbmV3IERhdGUoKS5nZXRUaW1lKCk7XG4gICAgICAgIGNvbW1hbkRhdGEuc2VydmljZVRpbWVJbnRlcnZhbCA9IHRpbWVySW50ZXJ2YWxJbmZvIC0gY3VycmVudFRpbWVJbnRlcnZhbDtcbiAgICB9XG59XG4iLCIvLyBpbXBvcnQgeyBmb3JJbiB9IGZyb20gJ2xvZGFzaCc7XG5pbXBvcnQgKiBhcyBjb21tb24gZnJvbSAnLi9jb21tb24nO1xuXG52YXIgbW9kdWxlRGlkU3RhcnQgPSBmYWxzZTtcblxuLy/liJ3lp4vljJZcbmFzeW5jIGZ1bmN0aW9uIHN0YXJ0KCkge1xuICAgIG1vZHVsZURpZFN0YXJ0ID0gdHJ1ZTtcbiAgICAvL+iuvue9ruWvvOiIquagj+inhuWbvum7mOiupOeKtuaAgeS4uuaYvuekuueKtuaAgVxuICAgIGF3YWl0IGNvbW1vbi5zZXRNb2R1bGVTdGF0dXMoXCJuYXZcIiwgMSk7XG5cbiAgICBhd2FpdCByZXF1ZXN0TmF2RGF0YSgpO1xuICAgIHJlZnJlc2hBdmF0YXIoKTtcbn1cblxuLy/liJ3lp4vljJbmlbDmja5cbmZ1bmN0aW9uIGRlZmF1bHREYXRhKCkge1xuICAgIHJldHVybiB7XG4gICAgICAgIGN1cnJlbnRJbmRleDogMCxcbiAgICAgICAgdXNlckluZm86IHt9LFxuICAgICAgICBzZWFyY2hEYXRhOiB7fSxcbiAgICAgICAgcmV3YXJkc0RhdGE6IHt9LFxuICAgICAgICByZXdhcmRzSW1hZ2U6IFwiXCIsXG4gICAgICAgIHJld2FyZHNWaXNpYmlsaXR5OiBcImdvbmVcIixcbiAgICAgICAgcmV3YXJkc1JlZERvdFZpc2liaWxpdHk6IFwiZ29uZVwiLFxuICAgICAgICBtZXNzYWdlQ291bnQ6IDAsXG4gICAgICAgIG5vdGljZUNvdW50OiAwLFxuICAgICAgICBtZXNzYWdlVmlzaWJpbGl0eTogXCJnb25lXCIsXG4gICAgICAgIG5vdGljZVZpc2liaWxpdHk6IFwiZ29uZVwiLFxuXHRcdHJlZERvdFZpc2libGU6IFwiZ29uZVwiLFxuXHRcdG51bVJlZERvdFZpc2libGU6IFwiZ29uZVwiLFxuICAgICAgICBob3RWaXNpYmlsaXR5OiBcImdvbmVcIlxuICAgIH07XG59XG5cblxuY29uc3QgeyBtb2R1bGVEYXRhLCBtb2R1bGVFdmVudCB9ID0gY29tbW9uLm1vZHVsZURlZmluZShcIm5hdlwiLCBzdGFydCwgZGVmYXVsdERhdGEpO1xuYXN5bmMgZnVuY3Rpb24gbW9kdWxlQXBwZWFyKCkge1xuICAgIFxufVxuXG5hc3luYyBmdW5jdGlvbiBtb2R1bGVEaXNhcHBlYXIoKSB7XG5cbn1cblxubW9kdWxlRXZlbnQubW9kdWxlQXBwZWFyID0gbW9kdWxlQXBwZWFyO1xubW9kdWxlRXZlbnQubW9kdWxlRGlzYXBwZWFyID0gbW9kdWxlRGlzYXBwZWFyO1xuXG4vL2lt5raI5oGv5pyq6K+75pWw6YePXG52YXIgaW1NZ3NDb3VudCA9IDA7XG4vL+a0u+WKqOa2iOaBr+aVsOmHj1xudmFyIGFjdGl2aXR5Q291bnQgPSAwO1xuLy/pgJrnn6XmlbDph49cbnZhciBub3RpY2VDb3VudCA9IDA7XG4vL+S4iuS4gOasoeiOt+WPlua2iOaBr+eahOaXtumXtFxudmFyIGxhc3RUaW1lO1xuXG52YXIgc2VhcmNoRGF0YUNhY2hlO1xudmFyIHJld2FyZHNEYXRhQ2FjaGU7XG5cbmFzeW5jIGZ1bmN0aW9uIHNlYXJjaERhdGFDYWxsYmFjayhzZWFyY2hEYXRhLCBpc0NhY2hlKSB7XG4gICAgY29uc29sZS5sb2coYGlzQ2FjaGUgPSAke2lzQ2FjaGV9YCk7XG4gICAgaWYgKHNlYXJjaERhdGEgJiYgc2VhcmNoRGF0YSAhPSBcIlwiKSB7XG4gICAgICAgIGlmIChzZWFyY2hEYXRhLmhvdFdvcmRDb250ZXh0ICYmIHNlYXJjaERhdGEuaG90V29yZENvbnRleHQuaG90V29yZHMgJiYgc2VhcmNoRGF0YS5ob3RXb3JkQ29udGV4dC5ob3RXb3Jkcy5sZW5ndGggPiAwKSB7XG4gICAgICAgICAgICBmb3IgKHZhciBpID0gMDsgaTwgc2VhcmNoRGF0YS5ob3RXb3JkQ29udGV4dC5ob3RXb3Jkcy5sZW5ndGg7IGkrKykge1xuICAgICAgICAgICAgICAgIHZhciBlbGVtZW50ID0gc2VhcmNoRGF0YS5ob3RXb3JkQ29udGV4dC5ob3RXb3Jkc1tpXTtcbiAgICAgICAgICAgICAgICBlbGVtZW50LmNlbGxUeXBlID0gXCIxXCI7XG4gICAgICAgICAgICAgICAgZWxlbWVudC53cm9kSW5kZXggPSBTdHJpbmcoaSk7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBtb2R1bGVEYXRhLmhvdFZpc2liaWxpdHkgPSBcInZpc2libGVcIjtcbiAgICAgICAgfVxuICAgICAgICBlbHNlIHtcbiAgICAgICAgICAgIG1vZHVsZURhdGEuaG90VmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgICAgICB9XG4gICAgICAgIHNlYXJjaERhdGFDYWNoZSA9IHNlYXJjaERhdGE7XG4gICAgICAgIG1vZHVsZURhdGEuc2VhcmNoRGF0YSA9IHNlYXJjaERhdGE7XG4gICAgfVxuICAgIGF3YWl0IGNvbW1vbi5zZXRNb2R1bGVTdGF0dXMoXCJuYXZcIiwgMSk7XG59XG5cbmZ1bmN0aW9uIHJld2FyZHNEYXRhQ2FsbGJhY2socmV3YXJkc0RhdGEsIGlzQ2FjaGUpIHtcbiAgICBpZiAocmV3YXJkc0RhdGEpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5yZXdhcmRzRGF0YSA9IHJld2FyZHNEYXRhO1xuICAgICAgICByZXdhcmRzRGF0YUNhY2hlID0gcmV3YXJkc0RhdGE7XG4gICAgICAgIGlmIChjb21tb24uY29tbWFuRGF0YS5jb2xvck1vZGUgPT0gMSkgey8vMeihqOekuum7keWknFxuICAgICAgICAgICAgbW9kdWxlRGF0YS5yZXdhcmRzSW1hZ2UgPSByZXdhcmRzRGF0YS5uYXZpZ2F0aW9uTmlnaHRJbWdVcmw7XG4gICAgICAgIH1cbiAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLnJld2FyZHNJbWFnZSA9IHJld2FyZHNEYXRhLm5hdmlnYXRpb25EYXlJbWdVcmw7XG4gICAgICAgIH1cbiAgICAgICAgLy/npo/liKnkuK3lv4Plj7PkuIrop5LnuqLngrkg5LiN55So57yT5a2Y5pWw5o2u44CC5aaC5p6c5a6i5oi356uv6K+35rGC5pyN5Yqh56uv5pyq6L+U5Zue57uT5p6c77yM5bCx5Lul5a6i5oi356uv5pys5Zyw54q25oCB5Li65YeG77yM5LiN5YGa5Y+Y5pu044CCXG4gICAgICAgIGlmKCFpc0NhY2hlKXtcbiAgICAgICAgICAgIG1vZHVsZURhdGEucmV3YXJkc1JlZERvdFZpc2liaWxpdHkgPSBjb21tb24uY29tbWFuRGF0YS5pc0xvZ2luID09IDEgJiYgcmV3YXJkc0RhdGEucmV3YXJkQ2VudGVyRmxhZyA/IFwidmlzaWJsZVwiOlwiZ29uZVwiO1xuICAgICAgICB9XG4gICAgICAgIGNvbnNvbGUubG9nKGBuYXZuYXYgcmV3YXJkc0RhdGFDYWxsYmFjayByZXdhcmRDZW50ZXJGbGFnOiR7cmV3YXJkc0RhdGEucmV3YXJkQ2VudGVyRmxhZ30gJHttb2R1bGVEYXRhLnJld2FyZHNSZWREb3RWaXNpYmlsaXR5fWApO1xuICAgIH1cbiAgICBpZiAobW9kdWxlRGF0YS5yZXdhcmRzSW1hZ2UpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5yZXdhcmRzVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuICAgIH1cbiAgICBlbHNlIHtcbiAgICAgICAgbW9kdWxlRGF0YS5yZXdhcmRzVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgIH1cbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHJlcXVlc3ROYXZEYXRhKCkge1xuICAgIG1vZHVsZURhdGEudXNlckluZm8gPSBjb21tb24uY29tbWFuRGF0YS51c2VySW5mbztcblxuICAgIC8v5pCc57Si5o6l5Y+jXG4gICAgYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0V2l0aENhY2hlKCd2MS9oYmcvb3Blbi9pbnZpdGUvYXBwU2VhcmNoL2xpc3QnLCBjYWxsYmFjayA9IHNlYXJjaERhdGFDYWxsYmFjayk7XG5cbiAgICBpZiAoY29tbW9uLmNvbW1hbkRhdGEuaXNJblJldmlldyAhPSAxKSB7XG4gICAgICAgIC8v56aP5Yip5Lit5b+D5o6l5Y+jXG4gICAgICAgIGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdFdpdGhDYWNoZSgndjEvYXBwL2hvbWUvY29tbW9uRGF0YScsIGNhbGxiYWNrID0gcmV3YXJkc0RhdGFDYWxsYmFjayk7XG4gICAgfVxuICAgIGVsc2Uge1xuICAgICAgICBtb2R1bGVEYXRhLnJld2FyZHNWaXNpYmlsaXR5ID0gXCJnb25lXCI7XG4gICAgfVxuICAgIGF3YWl0IHJlcXVlc3RNZXNzYWdlQ291bnQoKTtcbn1cblxuZnVuY3Rpb24gdXBkYXRlTWVzc2FnZUNvdW50KCkge1xuICAgIGlmIChjb21tb24uY29tbWFuRGF0YS5pc0xvZ2luICE9IDEpIHtcbiAgICAgICAgYWN0aXZpdHlDb3VudCA9IDA7XG4gICAgICAgIGltTWdzQ291bnQgPSAwO1xuICAgICAgICBub3RpY2VDb3VudCA9IDA7XG4gICAgICAgIG1vZHVsZURhdGEubWVzc2FnZVZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICAgICAgbW9kdWxlRGF0YS5ub3RpY2VWaXNpYmlsaXR5ID0gXCJnb25lXCI7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG5cbiAgICBjb25zb2xlLmxvZyhgdXBkYXRlTWVzc2FnZUNvdW50OmltTWdzQ291bnQgPSAke2ltTWdzQ291bnR9YCk7XG4gICAgY29uc29sZS5sb2coYHVwZGF0ZU1lc3NhZ2VDb3VudDphY3Rpdml0eUNvdW50ID0gJHthY3Rpdml0eUNvdW50fWApO1xuICAgIGNvbnNvbGUubG9nKGB1cGRhdGVNZXNzYWdlQ291bnQ6bm90aWNlQ291bnQgPSAke25vdGljZUNvdW50fWApO1xuXG4gICAgdmFyIG1lc3NhZ2VDb3VudCA9IGFjdGl2aXR5Q291bnQgKyBpbU1nc0NvdW50O1xuICAgIGlmIChtZXNzYWdlQ291bnQgPiA5OSkge1xuICAgICAgICBtb2R1bGVEYXRhLm1lc3NhZ2VDb3VudCA9IFwiOTkrXCI7XG4gICAgfVxuICAgIGVsc2Uge1xuICAgICAgICBtb2R1bGVEYXRhLm1lc3NhZ2VDb3VudCA9IFN0cmluZyhtZXNzYWdlQ291bnQpO1xuICAgIH1cbiAgICBjb25zb2xlLmxvZyhgdXBkYXRlTWVzc2FnZUNvdW50Om1lc3NhZ2VDb3VudCA9ICR7bWVzc2FnZUNvdW50fWApO1xuXG4gICAgbW9kdWxlRGF0YS5ub3RpY2VDb3VudCA9IFN0cmluZyhub3RpY2VDb3VudCk7XG4gICAgaWYgKG1lc3NhZ2VDb3VudCA+IDApIHtcbiAgICAgICAgbW9kdWxlRGF0YS5tZXNzYWdlVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuICAgICAgICBtb2R1bGVEYXRhLm5vdGljZVZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICB9XG4gICAgZWxzZSB7XG4gICAgICAgIG1vZHVsZURhdGEubWVzc2FnZVZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICAgICAgaWYgKG5vdGljZUNvdW50ID4gMCkge1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5ub3RpY2VWaXNpYmlsaXR5ID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgIH1cbiAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLm5vdGljZVZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICAgICAgfVxuICAgIH1cbn1cblxuZnVuY3Rpb24gc2VuZFVucmVhZE1lc3NhZ2UoZGF0YSkge1xuICAgIGltTWdzQ291bnQgPSBwYXJzZUludChkYXRhLmNvdW50KTtcbiAgICBjb25zb2xlLmxvZyhgc2VuZFVucmVhZE1lc3NhZ2U6aW1NZ3NDb3VudCA9ICR7aW1NZ3NDb3VudH1gKTtcbiAgICB1cGRhdGVNZXNzYWdlQ291bnQoKVxufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gY2hlY2tNZXNzYWdlQ291bnRUaW1lcigpIHtcbiAgICBpZiAobW9kdWxlRGlkU3RhcnQgPT0gZmFsc2UpIHtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICBjb25zdCBjdXJyZW50VGltZSA9IG5ldyBEYXRlKCkuZ2V0VGltZSgpO1xuICAgIC8vNjDnp5Lor7fmsYLkuIDmrKFcbiAgICBpZiAoY3VycmVudFRpbWUgLSBsYXN0VGltZSA+IDYwICogMTAwMCkge1xuICAgICAgICBhd2FpdCByZXF1ZXN0TWVzc2FnZUNvdW50KCk7XG4gICAgfVxufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc2V0dXBVc2VySW5mbyh1c2VySW5mbykge1xuICAgICRkYXRhLm5hdi51c2VySW5mbyA9IHVzZXJJbmZvO1xuXG4gICAgaWYgKGNvbW1vbi5jb21tYW5EYXRhLmlzTG9naW4gPT0gMSkge1xuICAgICAgICBjb25zb2xlLmxvZyhcImxvZ2luXCIpO1xuICAgICAgICBhd2FpdCByZXF1ZXN0TWVzc2FnZUNvdW50KCk7XG4gICAgfVxuICAgIGVsc2Uge1xuICAgICAgICB1cGRhdGVNZXNzYWdlQ291bnQoKTtcbiAgICB9XG59XG5leHBvcnQgZnVuY3Rpb24gcmVmcmVzaEF2YXRhcigpIHtcbiAgICBpZiAobW9kdWxlRGlkU3RhcnQgPT0gZmFsc2UpIHtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICAkZGF0YS5uYXYucmVmcmVzaEF2YXRhciA9IFwiMVwiO1xuXHRyZXF1ZXN0QXZhdGFyKCk7XG59XG5cbi8vIOWktOWDj+acquivu+aVsFxuYXN5bmMgZnVuY3Rpb24gcmVxdWVzdEF2YXRhcigpIHtcblx0dmFyIGlzS3ljID0gZmFsc2U7XG5cdGlmIChjb21tb24uY29tbWFuRGF0YS5pc0xvZ2luICE9IDEgfHwgY29tbW9uLmNvbW1hbkRhdGEudXNlckluZm8uaXNDaGlsZEFjY291bnQgPT0gMSkge1xuXHRcdGlzS3ljID0gZmFsc2U7XG5cdH0gZWxzZSB7XG5cdFx0dmFyIHVzZXJHZXREYXRhID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KCd1Yy9vcGVuL3VzZXIvZ2V0Jywge30sIDAsIDUpO1xuXHRcdGlmICh1c2VyR2V0RGF0YSAhPSBudWxsKSB7XG5cdFx0XHRpZiAoIXVzZXJHZXREYXRhLmt5Y19sZXZlbCB8fCB1c2VyR2V0RGF0YS5reWNfbGV2ZWwgPT0gbnVsbCB8fCB1c2VyR2V0RGF0YS5reWNfbGV2ZWwubGVuZ3RoID09IDApIHtcblx0XHRcdFx0aXNLeWMgPSB0cnVlO1xuXHRcdFx0fVxuXHRcdH1cblx0fVxuXHRjb25zdCBpc0h0eCA9IGNvbW1vbi5jb21tYW5EYXRhLmhhc05ld1ZlcnNpb247XG5cdGNvbnN0IHBhcmFtcyA9IHtcbiAgICAgICAgaXNIdHgsXG5cdFx0aXNLeWNcbiAgICB9O1xuXG5cdHZhciByZWREb3REYXRhID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KCd2MS9oYmcvbXlob21lL3JlZERvdC9xdWVyeVVzZXJSZWREb3QnLCBwYXJhbXMpO1xuXHRjb25zb2xlLmxvZyhyZWREb3REYXRhLnJlZERvdE51bSwgcmVkRG90RGF0YS5yZWREb3QpO1xuXHRtb2R1bGVEYXRhLm51bVJlZERvdExlZnQgPSAzNlxuXHRpZiAocmVkRG90RGF0YS5yZWREb3ROdW0gJiYgcmVkRG90RGF0YS5yZWREb3ROdW0gPiAwKSB7XG5cdFx0aWYgKHJlZERvdERhdGEucmVkRG90TnVtID4gOTkpIHtcblx0XHRcdG1vZHVsZURhdGEubnVtUmVkRG90TGVmdCA9IDMwXG5cdFx0XHRtb2R1bGVEYXRhLnJlZERvdE51bSA9IFwiOTkrXCI7XG5cdFx0fSBlbHNlIHtcblx0XHRcdG1vZHVsZURhdGEucmVkRG90TnVtID0gYCR7cmVkRG90RGF0YS5yZWREb3ROdW19YDtcblx0XHR9XG5cdFx0bW9kdWxlRGF0YS5udW1SZWREb3RWaXNpYmxlID0gXCJ2aXNpYmxlXCI7XG5cdFx0bW9kdWxlRGF0YS5yZWREb3RWaXNpYmxlID0gXCJnb25lXCI7XG5cdH0gZWxzZSBpZiAocmVkRG90RGF0YS5yZWREb3QpIHtcblx0XHRtb2R1bGVEYXRhLm51bVJlZERvdFZpc2libGUgPSBcImdvbmVcIjtcblx0XHRtb2R1bGVEYXRhLnJlZERvdFZpc2libGUgPSBcInZpc2libGVcIjtcblx0fSBlbHNlIHtcblx0XHRtb2R1bGVEYXRhLnJlZERvdFZpc2libGUgPSBcImdvbmVcIjtcblx0XHRtb2R1bGVEYXRhLm51bVJlZERvdFZpc2libGUgPSBcImdvbmVcIjtcblx0fVxufVxuXG4vLyDojrflj5bnq5nlhoXkv6HmnKror7vmlbAgXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0TWVzc2FnZUNvdW50KCkge1xuICAgIGNvbnNvbGUubG9nKCdyZXF1ZXN0TWVzc2FnZUNvdW50Jyk7XG4gICAgaWYgKGNvbW1vbi5jb21tYW5EYXRhLmlzTG9naW4gIT0gMSkge1xuICAgICAgICB1cGRhdGVNZXNzYWdlQ291bnQoKTtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICB2YXIgcGFyYW1zID0geyBleGNoYW5nZV9pZDogJzEnLCB0ZW1wbGF0ZV9jb2RlOiBbXCIxLlBSTy5DT05URU5UX1BSQUlTRV9BTExfTVNHXCIsIFwiMS5QUk8uQ09OVEVOVF9DT01NRU5UX0FMTF9NU0dcIiwgXCIxLlBSTy5DT05URU5UX0ZPQ1VTX1VTRVJfTVNHXCJdIH07XG5cbiAgICB2YXIgY291bnREYXRhID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KCd1Yy9vcGVuL2xldHRlci92My9saXN0X2J5X2NvZGUnLCBwYXJhbXMsIDEsIDUsIHt9KTtcbiAgICBpZiAoY291bnREYXRhKSB7XG4gICAgICAgIGFjdGl2aXR5Q291bnQgPSBwYXJzZUludChjb3VudERhdGEuc3VtX3N1Yl91bl9yZWFkKTtcbiAgICAgICAgbm90aWNlQ291bnQgPSBwYXJzZUludChjb3VudERhdGEuc3VtX3VuX3JlYWRfZXhjZXB0X2NvZGUpO1xuICAgICAgICBjb25zdCBsZXR0ZXJUeXBlID0gcGFyc2VJbnQoY291bnREYXRhLmxldHRlcl9zdWJfdHlwZSk7XG5cbiAgICAgICAgaWYgKGxldHRlclR5cGUgPT0gMikge1xuICAgICAgICAgICAgbm90aWNlQ291bnQgPSAwO1xuICAgICAgICB9XG4gICAgICAgIHVwZGF0ZU1lc3NhZ2VDb3VudCgpO1xuICAgIH1cbiAgICBjb25zb2xlLmxvZygncmVxdWVzdE1lc3NhZ2VDb3VudCBkb25lJyk7XG5cbiAgICBsYXN0VGltZSA9IG5ldyBEYXRlKCkuZ2V0VGltZSgpO1xuICAgIGNvbnNvbGUubG9nKGBsYXN0VGltZSA9ICR7bGFzdFRpbWV9YCk7XG59XG5mdW5jdGlvbiBob3RJbmRleENoYW5nZShpbmRleCkge1xuICAgIG1vZHVsZURhdGEuY3VycmVudEluZGV4ID0gaW5kZXg7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIGdvVG9TZWFyY2goaW5kZXgpIHtcbiAgICBjb25zb2xlLmxvZyhgZ29Ub1NlYXJjaCBzdGFydCAke2luZGV4fWApO1xuICAgIHZhciBob3R3b3JkcyA9IHNlYXJjaERhdGFDYWNoZSAmJiBzZWFyY2hEYXRhQ2FjaGUuaG90V29yZENvbnRleHQgJiYgc2VhcmNoRGF0YUNhY2hlLmhvdFdvcmRDb250ZXh0LmhvdFdvcmRzICE9IG51bGwgPyBzZWFyY2hEYXRhQ2FjaGUuaG90V29yZENvbnRleHQuaG90V29yZHNbaW5kZXhdOlwiXCI7XG4gICAgYXdhaXQgY29tbW9uLm9wZW5QYWdlKFwic2VhcmNoXCIsIGhvdHdvcmRzKTtcbiAgICBhd2FpdCBjb21tb24uYW5hbHl0aWNzKFwiYXBwQ2xpY2tfaG9tZVwiLCB7XG4gICAgICAgIG1vZHVsZV9uYW1lOiBcInRvcGJhclwiLFxuICAgICAgICBidXR0b25fbmFtZTogXCJzZWFyY2hcIixcbiAgICAgICAgcHJlX3RleHQ6IGhvdHdvcmRzLndvcmRcbiAgICB9KTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gZ29Ub1NjYW4oKSB7XG4gICAgYXdhaXQgY29tbW9uLm9wZW5QYWdlKFwic2NhblwiLCB7fSk7XG4gICAgYXdhaXQgY29tbW9uLmFuYWx5dGljcyhcImFwcENsaWNrX2hvbWVcIiwge1xuICAgICAgICBtb2R1bGVfbmFtZTogXCJ0b3BiYXJcIixcbiAgICAgICAgYnV0dG9uX25hbWU6IFwic2NhblwiXG4gICAgfSk7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIGdvVG9JTSgpIHtcbiAgICBhd2FpdCBjb21tb24ub3BlblBhZ2UoXCJpbVwiLCB7fSk7XG5cbiAgICB2YXIgYmFkZ2VzID0gXCJcIjtcbiAgICBpZiAoJGRhdGEubmF2Lm1lc3NhZ2VWaXNpYmlsaXR5ID09IFwidmlzaWJsZVwiKSB7XG4gICAgICAgIGJhZGdlcyA9IFN0cmluZygkZGF0YS5uYXYubWVzc2FnZUNvdW50KTtcbiAgICB9XG4gICAgZWxzZSBpZiAoJGRhdGEubmF2Lm5vdGljZVZpc2liaWxpdHkgPT0gXCJ2aXNpYmxlXCIpIHtcbiAgICAgICAgYmFkZ2VzID0gXCJyZWREb3RcIjtcbiAgICB9XG4gICAgYXdhaXQgY29tbW9uLmFuYWx5dGljcyhcImFwcENsaWNrX2hvbWVcIiwge1xuICAgICAgICBtb2R1bGVfbmFtZTogXCJ0b3BiYXJcIixcbiAgICAgICAgYnV0dG9uX25hbWU6IFwibWVzc2FnZVwiLFxuICAgICAgICBzdXBlcnNjcmlwdDogYmFkZ2VzXG4gICAgfSk7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIGdvVG9SZXdhcmRzKCkge1xuICAgIGF3YWl0IGNvbW1vbi5vcGVuVVJMKG1vZHVsZURhdGEucmV3YXJkc0RhdGEubmF2aWdhdGlvbkp1bXBVcmwsIHt9KTtcbiAgICB2YXIgYmFkZ2VzID0gXCJcIjtcbiAgICBpZiAoJGRhdGEubmF2LnJld2FyZHNSZWREb3RWaXNpYmlsaXR5ID09IFwidmlzaWJsZVwiKSB7XG4gICAgICAgIGJhZGdlcyA9IFwicmVkRG90XCI7XG4gICAgfVxuICAgIGNvbnNvbGUubG9nKGBuYXZuYXYgZ29Ub1Jld2FyZHMgYmFkZ2VzOiR7YmFkZ2VzfSByZXdhcmRzUmVkRG90VmlzaWJpbGl0ee+8miR7JGRhdGEubmF2LnJld2FyZHNSZWREb3RWaXNpYmlsaXR5fWApO1xuICAgIGF3YWl0IGNvbW1vbi5hbmFseXRpY3MoXCJhcHBDbGlja19ob21lXCIsIHtcbiAgICAgICAgbW9kdWxlX25hbWU6IFwidG9wYmFyXCIsXG4gICAgICAgIGJ1dHRvbl9uYW1lOiBcIndlbGZhcmVcIixcbiAgICAgICAgc3VwZXJzY3JpcHQ6IGJhZGdlc1xuICAgIH0pO1xufVxuXG5hc3luYyBmdW5jdGlvbiBnb1RvVXNlcigpIHtcbiAgICBhd2FpdCBjb21tb24ub3BlblVSTCgnaG9saWdlaXQ6Ly9vcGVuL3YxP3VybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vbmV3QWNjb3VudC9pbmRleCcsIHt9KTtcbiAgICBhd2FpdCBjb21tb24uYW5hbHl0aWNzKFwiYXBwQ2xpY2tfaG9tZVwiLCB7XG4gICAgICAgIG1vZHVsZV9uYW1lOiBcInRvcGJhclwiLFxuICAgICAgICBidXR0b25fbmFtZTogXCJtZVwiXG4gICAgfSk7XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBsb2dpblN0YXRlQ2hhbmdlKCkge1xuICAgIGlmIChjb21tb24uY29tbWFuRGF0YS5pc0xvZ2luICE9IDEpIHtcbiAgICAgICAgLy/pgIDlh7rnmbvlvZUg5LiN5pi+56S656aP5Yip5Lit5b+D57qi54K5XG4gICAgICAgIG1vZHVsZURhdGEucmV3YXJkc1JlZERvdFZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICB9XG59XG5cbm1vZHVsZUV2ZW50LmxvZ2luU3RhdGVDaGFuZ2UgPSBsb2dpblN0YXRlQ2hhbmdlO1xubW9kdWxlRXZlbnQuc2VuZFVucmVhZE1lc3NhZ2UgPSBzZW5kVW5yZWFkTWVzc2FnZTtcbm1vZHVsZUV2ZW50LmdvVG9TZWFyY2ggPSBnb1RvU2VhcmNoO1xubW9kdWxlRXZlbnQuZ29Ub1NjYW4gPSBnb1RvU2Nhbjtcbm1vZHVsZUV2ZW50LmdvVG9JTSA9IGdvVG9JTTtcbm1vZHVsZUV2ZW50LmdvVG9SZXdhcmRzID0gZ29Ub1Jld2FyZHM7XG5tb2R1bGVFdmVudC5ob3RJbmRleENoYW5nZSA9IGhvdEluZGV4Q2hhbmdlO1xubW9kdWxlRXZlbnQuZ29Ub1VzZXIgPSBnb1RvVXNlcjtcblxuIiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gJy4vY29tbW9uJztcblxudmFyIG1vZHVsZURpZFN0YXJ0ID0gZmFsc2U7XG5cbi8v5Yid5aeL5YyWXG5hc3luYyBmdW5jdGlvbiBzdGFydCgpIHtcbiAgICBtb2R1bGVEaWRTdGFydCA9IHRydWU7XG4gICAgYXdhaXQgcmVhZFRoaXJkU3ltYm9sSW5kZXgoKVxuICAgIGF3YWl0IHJlcXVlc3RUb3BDb250cmFjdFN5bWJvbHMoKVxufVxuXG4vL+WIneWni+WMluaVsOaNrlxuZnVuY3Rpb24gZGVmYXVsdERhdGEoKSB7XG4gICAgcmV0dXJuIHsgIFxuICAgICAgICBsaXN0OltdXG4gICAgfTtcbn1cblxuXG52YXIgdGhpcmRJbmRleCA9IDI7XG5cbmNvbnN0IHttb2R1bGVEYXRhLCBtb2R1bGVFdmVudH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFwibWFya2V0XCIsIHN0YXJ0LCBkZWZhdWx0RGF0YSk7XG5cbmFzeW5jIGZ1bmN0aW9uIG1vZHVsZUFwcGVhcigpIHtcblxufVxuXG5hc3luYyBmdW5jdGlvbiBtb2R1bGVEaXNhcHBlYXIoKSB7XG5cbn1cblxubW9kdWxlRXZlbnQubW9kdWxlQXBwZWFyID0gbW9kdWxlQXBwZWFyO1xubW9kdWxlRXZlbnQubW9kdWxlRGlzYXBwZWFyID0gbW9kdWxlRGlzYXBwZWFyO1xuXG5leHBvcnQgZnVuY3Rpb24gcmVzZXRNYXJrZXREYXRhKCkge1xuICAgIC8vICBjb25zb2xlLmxvZygncmVzZXRNYXJrZXREYXRhIG1vZHVsZURpZFN0YXJ0OicgKyBtb2R1bGVEaWRTdGFydCtcIiBtb2R1bGVEYXRhLmxpc3QubGVuZ3RoOlwiK21vZHVsZURhdGEubGlzdC5sZW5ndGgrXCIgYnRjdXNkdDpcIitKU09OLnN0cmluZ2lmeShjb21tb24uY29tbWFuRGF0YS5tYXJrZXREYXRhW1wiYnRjdXNkdFwiXSkpO1xuXG4gICAgaWYgKG1vZHVsZURpZFN0YXJ0ID09IGZhbHNlKSB7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgZm9yIChsZXQgaSA9IDA7IGkgPCBtb2R1bGVEYXRhLmxpc3QubGVuZ3RoOyBpKyspIHtcbiAgICAgICAgdmFyIGl0ZW0gPSBtb2R1bGVEYXRhLmxpc3RbaV07XG4gICAgICAgIGNvbnN0IGNvaW5EaWN0ID0gY29tbW9uLmNvbW1hbkRhdGEubWFya2V0RGF0YVtpdGVtLnN5bWJvbF07XG4gICAgICAgIGlmIChjb2luRGljdCA9PSBudWxsKSB7XG4gICAgICAgICAgICBjb250aW51ZTtcbiAgICAgICAgfVxuICAgICAgICBjb25zdCBzeW1ib2xJbmZvID0gY29tbW9uLmdldFN5bWJvbEluZm8oaXRlbS5zeW1ib2wpO1xuICAgICAgICBpZiAoY29pbkRpY3QuZGVjaW1hbGNQcmljZSA+IDApIHtcbiAgICAgICAgICAgIGl0ZW0uY3VycmVudFByaWNlID0gY29tbW9uLmdldFByaWNlU3RyaW5nKGNvaW5EaWN0LmRlY2ltYWxjUHJpY2UsIHN5bWJvbEluZm8udHJhZGVQcmljZVByZWNpc2lvbik7XG4gICAgICAgIH1cbiAgICAgICAgbGV0IHVwRG93biA9IGNvaW5EaWN0LmRlY2ltYWxEZWx0YS50b0ZpeGVkKDIpO1xuICAgICAgICBpdGVtLnJhdGlvID0gZm9ybWF0UmF0aW8odXBEb3duKTtcbiAgICAgICAgaXRlbS5yYXRpb0NvbG9yID0gY29tbW9uLmdldFByaWNlQ29sb3IodXBEb3duKTtcbiAgICB9XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiByZXF1ZXN0VG9wQ29udHJhY3RTeW1ib2xzKCkge1xuICAgIGxldCBkYXRhID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KCd2MS9hcHAvdG9wTWFya2V0U3ltYm9scycpXG4gICAgaWYgKGRhdGEgPT0gbnVsbCB8fCBkYXRhLmxlbmd0aCA9PSAwICkge1xuICAgICAgICBpZiAobW9kdWxlRGF0YS5saXN0Lmxlbmd0aCA9PSAwKSB7XG4gICAgICAgICAgICBhd2FpdCBjb21tb24uc2V0TW9kdWxlU3RhdHVzKFwibWFya2V0XCIsIDIpO1xuICAgICAgICB9XG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgdmFyIGFycmF5ID0gW107XG4gICAgZm9yICh2YXIgaSA9IDA7IGkgPCBkYXRhLmxlbmd0aDsgaSsrKSB7XG4gICAgICAgIGlmIChhcnJheS5sZW5ndGggPCAzKSB7XG4gICAgICAgICAgICBpZiAoYXJyYXkubGVuZ3RoID09IDIgJiYgdGhpcmRJbmRleCA8IGRhdGEubGVuZ3RoKSB7XG4gICAgICAgICAgICAgICAgaWYgKGkgPT0gdGhpcmRJbmRleCkge1xuICAgICAgICAgICAgICAgICAgICB2YXIgbW9kZWwgPSBhd2FpdCBoYW5kbGVUb3BTeW1ib2xNb2RlbChkYXRhW2ldKTtcbiAgICAgICAgICAgICAgICAgICAgbW9kZWwuaW5kZXggPSBcIjJcIjtcbiAgICAgICAgICAgICAgICAgICAgYXJyYXkucHVzaChtb2RlbCk7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICB2YXIgbW9kZWwgPSBhd2FpdCBoYW5kbGVUb3BTeW1ib2xNb2RlbChkYXRhW2ldKTtcbiAgICAgICAgICAgICAgICBtb2RlbC5pbmRleCA9IFN0cmluZyhpKTtcbiAgICAgICAgICAgICAgICBhcnJheS5wdXNoKG1vZGVsKTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgIH1cblxuICAgIG1vZHVsZURhdGEubGlzdCA9IGFycmF5O1xuICAgIGlmIChhcnJheS5sZW5ndGggPT0gMCkge1xuICAgICAgICBhd2FpdCBjb21tb24uc2V0TW9kdWxlU3RhdHVzKFwibWFya2V0XCIsIDIpO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIGlmIChjb21tb24uY29tbWFuRGF0YS5tYXJrZXREYXRhICE9IG51bGwpIHtcbiAgICAgICAgICAgIHJlc2V0TWFya2V0RGF0YSgpXG4gICAgICAgIH1cbiAgICAgICAgYXdhaXQgY29tbW9uLnNldE1vZHVsZVN0YXR1cyhcIm1hcmtldFwiLCAxKTtcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIGhhbmRsZVRvcFN5bWJvbE1vZGVsKG9iaikge1xuICAgIHZhciBzeW1ib2xNb2RlbCA9IG9iajtcbiAgICBzeW1ib2xNb2RlbC5wcm9kdWN0VGl0bGUgPSBgJHtvYmouYmFzZUN1cnJlbmN5LnRvVXBwZXJDYXNlKCl9LyR7b2JqLnF1b3RlQ3VycmVuY3kudG9VcHBlckNhc2UoKX1gO1xuICAgIHN5bWJvbE1vZGVsLmNlbGxUeXBlID0gXCJub3JtYWxcIjtcblxuICAgIGNvbnN0IHN5bWJvbEluZm8gPSBjb21tb24uZ2V0U3ltYm9sSW5mbyhvYmouc3ltYm9sKTtcbiAgICBcbiAgICB2YXIgcHJpY2VTdHIgPSBcIi0tXCI7XG4gICAgY29uc3QgY29pbkRpY3QgPSBjb21tb24uY29tbWFuRGF0YS5tYXJrZXREYXRhW29iai5zeW1ib2xdO1xuICAgIGlmIChjb2luRGljdCAhPSBudWxsKSB7XG4gICAgICAgIHZhciBwcmljZSA9IGNvaW5EaWN0LmRlY2ltYWxjUHJpY2U7XG4gICAgICAgIHByaWNlU3RyID0gY29tbW9uLmdldFByaWNlU3RyaW5nKHByaWNlLCBzeW1ib2xJbmZvLnRyYWRlUHJpY2VQcmVjaXNpb24pO1xuICAgIH1cbiAgICBlbHNlIHtcbiAgICAgICAgaWYgKG9iai5wcmljZSAhPSBudWxsICYmIG9iai5wcmljZS5sZW5ndGggPiAwKSB7XG4gICAgICAgICAgICBwcmljZVN0ciA9IGNvbW1vbi5nZXRQcmljZVN0cmluZyhvYmoucHJpY2UsIHN5bWJvbEluZm8udHJhZGVQcmljZVByZWNpc2lvbik7XG4gICAgICAgIH1cbiAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICBwcmljZVN0ciA9IFwiLS1cIjtcbiAgICAgICAgfVxuICAgIH1cbiAgICBzeW1ib2xNb2RlbC5jdXJyZW50UHJpY2UgPSBwcmljZVN0cjtcbiAgICBcbiAgICBsZXQgdXBEb3duIDtcbiAgICBpZiAoY29pbkRpY3QgIT0gbnVsbCkge1xuICAgICAgICB1cERvd24gPSBjb2luRGljdC5kZWNpbWFsRGVsdGEudG9GaXhlZCgyKTtcbiAgICB9XG4gICAgZWxzZSB7XG4gICAgICAgIHVwRG93biA9IGhhbmRsZVJ0aW8ob2JqLnVwRG93bilcbiAgICB9XG5cbiAgICBzeW1ib2xNb2RlbC5yYXRpbyA9IGZvcm1hdFJhdGlvKHVwRG93bik7XG4gICAgc3ltYm9sTW9kZWwucmF0aW9Db2xvciA9IGNvbW1vbi5nZXRQcmljZUNvbG9yKHVwRG93bik7XG5cbiAgICByZXR1cm4gc3ltYm9sTW9kZWw7XG59XG5cbmZ1bmN0aW9uIGhhbmRsZVJ0aW8obnVtYmVyKSB7XG4gICAgcmV0dXJuICgxMDAgKiBudW1iZXIpLnRvRml4ZWQoMik7XG59XG5cbmZ1bmN0aW9uIGZvcm1hdFJhdGlvKHVwRG93bikge1xuICAgIGxldCBwcmVmaXggPSB1cERvd24gPiAwID8gXCIrXCIgOiBcIlwiO1xuICAgIHJldHVybiBgJHtwcmVmaXh9JHt1cERvd24udG9TdHJpbmcoKX0lYDtcbn1cblxuYXN5bmMgZnVuY3Rpb24gcmVhZFRoaXJkU3ltYm9sSW5kZXgoKSB7XG4gICAgdmFyIGluZGV4TWFwID0gYXdhaXQgY29tbW9uLnJlYWQoXCJtYXJrZXRcIixcInRoaXJkU3ltYm9sSW5kZXhNYXBcIik7XG4gICAgaWYgKGluZGV4TWFwKSB7XG4gICAgICAgIGlmIChpbmRleE1hcC5hcHBMaWZlSUQgIT0gY29tbW9uLmNvbW1hbkRhdGEuYXBwTGlmZUN5Y2xlSWQpIHtcbiAgICAgICAgICAgIGluZGV4TWFwLmFwcExpZmVJRCA9IGNvbW1vbi5jb21tYW5EYXRhLmFwcExpZmVDeWNsZUlkO1xuICAgICAgICAgICAgaWYgKGluZGV4TWFwLmluZGV4ID09IFwiMlwiKSB7XG4gICAgICAgICAgICAgICAgaW5kZXhNYXAuaW5kZXggPSBcIjNcIjtcbiAgICAgICAgICAgICAgICB0aGlyZEluZGV4ID0gMztcbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgaW5kZXhNYXAuaW5kZXggPSBcIjJcIjtcbiAgICAgICAgICAgICAgICB0aGlyZEluZGV4ID0gMjtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGF3YWl0IGNvbW1vbi5zYXZlKFwibWFya2V0XCIsIFwidGhpcmRTeW1ib2xJbmRleE1hcFwiLCBpbmRleE1hcCk7XG4gICAgICAgIH1cbiAgICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgdGhpcmRJbmRleCA9IHBhcnNlSW50KGluZGV4TWFwLmluZGV4KTtcbiAgICAgICAgfVxuICAgIH0gZWxzZSB7XG4gICAgICAgIHRoaXJkSW5kZXggPSAyO1xuICAgICAgICBpbmRleE1hcCA9IHtcbiAgICAgICAgICAgIGFwcExpZmVJRDogY29tbW9uLmNvbW1hbkRhdGEuYXBwTGlmZUN5Y2xlSWQsXG4gICAgICAgICAgICBpbmRleDogXCIyXCJcbiAgICAgICAgfTtcbiAgICAgICAgYXdhaXQgY29tbW9uLnNhdmUoXCJtYXJrZXRcIiwgXCJ0aGlyZFN5bWJvbEluZGV4TWFwXCIsIGluZGV4TWFwKTtcbiAgICB9XG59XG5cbm1vZHVsZUV2ZW50Lmp1bXBUb0tsaW5lID0gYXN5bmMgZnVuY3Rpb24gKGluZGV4KSB7XG4gICAgaWYgKGluZGV4KSB7XG4gICAgICAgIGxldCBpID0gcGFyc2VJbnQoaW5kZXgpO1xuICAgICAgICBsZXQgbW9kZWwgPSBtb2R1bGVEYXRhLmxpc3RbaV07XG4gICAgICAgIGxldCBwYXJhbSA9IHt9O1xuICAgICAgICBwYXJhbS5zeW1ib2wgPSBtb2RlbC5zeW1ib2w7XG4gICAgICAgIHBhcmFtLnRyYWRlQ2F0ZWdvcnlUeXBlID0gXCIwXCI7XG4gICAgICAgIGF3YWl0IGNvbW1vbi5vcGVuUGFnZShcImtsaW5lXCIscGFyYW0pO1xuXG4gICAgICAgIGxldCB1cERvd24gPSBoYW5kbGVSdGlvKG1vZGVsLnVwRG93bik7XG4gICAgICAgIGxldCBjaGcgPSBcInJpc2VcIjtcbiAgICAgICAgaWYodXBEb3duIDwgMCl7XG4gICAgICAgICAgICBjaGcgPSBcImZhbGxcIjtcbiAgICAgICAgfWVsc2UgaWYodXBEb3duID09IDApe1xuICAgICAgICAgICAgY2hnID0gXCJob3Jpem9udGFsXCI7XG4gICAgICAgIH1cbiAgICAgICAgYXdhaXQgY29tbW9uLmFuYWx5dGljcyhcImFwcENsaWNrX2hvbWVcIiwge1xuICAgICAgICAgICAgICAgICAgICAgICAgbW9kdWxlX25hbWU6IFwic3ltYm9sXCIsXG4gICAgICAgICAgICAgICAgICAgICAgICBtb2R1bGVfcG9zaXRpb246IGkgKyAxLFxuICAgICAgICAgICAgICAgICAgICAgICAgY2hnOiBjaGcsXG4gICAgICAgICAgICAgICAgICAgICAgICBuYW1lOiBtb2RlbC5wcm9kdWN0VGl0bGUsXG4gICAgICAgICAgICAgICAgICAgIH0pO1xuICAgIH1cbn0iLCJpbXBvcnQgKiBhcyBjb21tb24gZnJvbSAnLi9jb21tb24nXG5cbnZhciBtb2R1bGVEaWRTdGFydCA9IGZhbHNlO1xuXG52YXIgY3VycmVudENhY2hlS2V5O1xuLy/liJ3lp4vljJZcbmFzeW5jIGZ1bmN0aW9uIHN0YXJ0KCkge1xuICAgIG1vZHVsZURpZFN0YXJ0ID0gdHJ1ZTtcbiAgICBhd2FpdCByZXF1ZXN0VXNlclJlZ2lzdHJ5VHJhbnNmZXJHdWlkZSgpXG59XG5cbi8v5Yid5aeL5YyW5pWw5o2uXG5mdW5jdGlvbiBkZWZhdWx0RGF0YSgpIHtcbiAgICByZXR1cm4ge1xuICAgIH07XG59XG5cblxuY29uc3Qge21vZHVsZURhdGEsIG1vZHVsZUV2ZW50fSA9IGNvbW1vbi5tb2R1bGVEZWZpbmUoXCJndWlkZVwiLCBzdGFydCwgZGVmYXVsdERhdGEpO1xuXG5cbmFzeW5jIGZ1bmN0aW9uIG1vZHVsZUFwcGVhcigpIHtcbiAgICBcbn1cblxuYXN5bmMgZnVuY3Rpb24gbW9kdWxlRGlzYXBwZWFyKCkge1xuXG59XG5cbm1vZHVsZUV2ZW50Lm1vZHVsZUFwcGVhciA9IG1vZHVsZUFwcGVhcjtcbm1vZHVsZUV2ZW50Lm1vZHVsZURpc2FwcGVhciA9IG1vZHVsZURpc2FwcGVhcjtcblxuYXN5bmMgZnVuY3Rpb24gcmVxdWVzdFVzZXJSZWdpc3RyeVRyYW5zZmVyR3VpZGUoKSB7XG4gICAgdmFyIGNhY2hlS2V5ID0gYCR7Y29tbW9uLmNvbW1hbkRhdGEuaXNMb2dpbn1fJHtjb21tb24uY29tbWFuRGF0YS51c2VySW5mby51SWR9YDtcbiAgICBpZiAoY29tbW9uLmNvbW1hbkRhdGEuaXNMb2dpbiA9PSAyKSB7XG4gICAgICAgIG1vZHVsZURhdGEuc2hvdyA9IFwiZ29uZVwiO1xuICAgICAgICBhd2FpdCBjb21tb24uc2V0TW9kdWxlU3RhdHVzKFwiZ3VpZGVcIiwgMik7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgaWYgKGN1cnJlbnRDYWNoZUtleSA9PSBudWxsIHx8IGNhY2hlS2V5ICE9IGN1cnJlbnRDYWNoZUtleSkge1xuICAgICAgICBtb2R1bGVEYXRhLnNob3cgPSBcImdvbmVcIjtcbiAgICAgICAgYXdhaXQgY29tbW9uLnNldE1vZHVsZVN0YXR1cyhcImd1aWRlXCIsIDIpO1xuICAgIH1cbiAgICBsZXQgZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdCgndjEvYXBwL2d1aWRlL3VzZXJSZWdpc3RyeVRyYW5zZmVyR3VpZGUnKTtcbiAgICBcbiAgICBpZiAoZGF0YSA9PSBudWxsKSB7XG4gICAgICAgIG1vZHVsZURhdGEuc2hvdyA9IFwiZ29uZVwiO1xuICAgICAgICBhd2FpdCBjb21tb24uc2V0TW9kdWxlU3RhdHVzKFwiZ3VpZGVcIiwgMik7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgXG4gICAgaWYgKGRhdGEudGFza1Byb2dyZXNzID4gMSkge1xuICAgICAgICBtb2R1bGVEYXRhLnNob3cgPSBcImdvbmVcIjtcbiAgICAgICAgYXdhaXQgY29tbW9uLnNldE1vZHVsZVN0YXR1cyhcImd1aWRlXCIsIDIpO1xuICAgICAgICByZXR1cm47XG4gICAgfVxuXG4gICAgLy8gbGV0IGRhdGEgPSBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3QoJ3YxL2FwcC9ndWlkZS9nZXRUcmFuc2ZlckFtb3VudEluZm8nKTtcbiAgICB2YXIgdGl0bGVDb2xvciA9IFwiIzAwMDAwMFwiO1xuICAgIGlmIChjb21tb24uY29tbWFuRGF0YS5jb2xvck1vZGUgPT0gMSkge1xuICAgICAgICB0aXRsZUNvbG9yID0gXCIjRTZFNkU2XCI7XG4gICAgfVxuXG4gICAgdmFyIHRpdGxlID0gZGF0YS50aXRsZS5yZXBsYWNlKC97fH0vZywgZnVuY3Rpb24obWF0Y2gpIHtcbiAgICAgICAgcmV0dXJuIG1hdGNoID09PSAneycgPyBcIjwvc3Bhbj48c3BhbiBzdHlsZT0nY29sb3I6I0ZFODczMTsgZm9udC1zaXplOjIycHg7Jz5cIiA6IGA8L3NwYW4+PHNwYW4gc3R5bGU9J2NvbG9yOiR7dGl0bGVDb2xvcn07IGZvbnQtc2l6ZToyMnB4Oyc+YDtcbiAgICAgIH0pO1xuICAgIHRpdGxlID0gYDxzcGFuIHN0eWxlPSdjb2xvcjoke3RpdGxlQ29sb3J9OyBmb250LXNpemU6MjJweDsnPiR7dGl0bGV9PC9zcGFuPmBcbiAgICBjb25zb2xlLmxvZyhgdGl0bGU9JHt0aXRsZX1gKTtcblxuICAgIG1vZHVsZURhdGEudGl0bGUgPSB0aXRsZTtcbiAgICBtb2R1bGVEYXRhLnN1YlRpdGxlID0gZGF0YS5zdWJUaXRsZTtcbiAgICBtb2R1bGVEYXRhLnRhc2tQcm9ncmVzcyA9IGRhdGEudGFza1Byb2dyZXNzOyBcbiAgICBtb2R1bGVEYXRhLnRvdGFsQXdhcmQgPSBkYXRhLnRvdGFsQXdhcmQ7XG4gICAgbW9kdWxlRGF0YS5tYXRlcmlhbF9uYW1lID0gZGF0YS5tYXRlcmlhbF9uYW1lO1xuICAgIC8vIDDvvJrmnKrnmbvlvZXvvIwx77ya5bey55m75b2V5pyq5YWl6YeR77yMMu+8muW3suWFpemHkeacquS6pOaYk++8jDPvvJrlt7LkuqTmmJNcbiAgICAvLzDmmL7npLrms6jlhowv55m75b2V5byV5a+877yMMeaYvuekuuWFpemHkeW8leWvvCwgMjPkuI3lsZXnpLpcbiAgICBjdXJyZW50Q2FjaGVLZXkgPSBjYWNoZUtleTtcbiAgICBpZiAoZGF0YS50YXNrUHJvZ3Jlc3MgPT0gMSkge1xuICAgICAgICBtb2R1bGVEYXRhLmJ1dHRvblRpdGxlID0gJGkxOG4ubl9pbmRleF9hbW91bnRfaW1tZWRpYXRlbHk7XG4gICAgICAgIG1vZHVsZURhdGEuc2hvdyA9IFwidmlzaWJsZVwiO1xuICAgICAgICBhd2FpdCBjb21tb24uc2V0TW9kdWxlU3RhdHVzKFwiZ3VpZGVcIiwgMSk7XG4gICAgfSBlbHNlIGlmIChkYXRhLnRhc2tQcm9ncmVzcyA9PSAwKSB7XG4gICAgICAgIG1vZHVsZURhdGEuYnV0dG9uVGl0bGUgPSAkaTE4bi5uX2hvbWVfbG9naW5fcmVnaXN0ZXI7XG4gICAgICAgIG1vZHVsZURhdGEuc2hvdyA9IFwidmlzaWJsZVwiO1xuICAgICAgICBhd2FpdCBjb21tb24uc2V0TW9kdWxlU3RhdHVzKFwiZ3VpZGVcIiwgMSk7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgbW9kdWxlRGF0YS5zaG93ID0gXCJnb25lXCI7XG4gICAgICAgIGF3YWl0IGNvbW1vbi5zZXRNb2R1bGVTdGF0dXMoXCJndWlkZVwiLCAyKTtcbiAgICB9XG4gICAgaWYgKGNvbW1vbi5jb21tYW5EYXRhLk9TID09IDApIHtcbiAgICAgICAgYXdhaXQgJG5hdGl2ZUFQSS5ob21lQnJpZGdlKHtcbiAgICAgICAgICAgIGFjdGlvbjogXCJyZWZyZXNoVGFibGVcIixcbiAgICAgICAgICAgIGRhdGE6ICcnXG4gICAgICAgIH0pXG4gICAgfVxufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gbG9naW5TdGF0ZUNoYW5nZSgpIHtcbiAgICBpZiAobW9kdWxlRGlkU3RhcnQgPT0gZmFsc2UpIHtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICB2YXIgY2FjaGVLZXkgPSBgJHtjb21tb24uY29tbWFuRGF0YS5pc0xvZ2lufV8ke2NvbW1vbi5jb21tYW5EYXRhLnVzZXJJbmZvLnVJZH1gO1xuICAgIGlmIChjdXJyZW50Q2FjaGVLZXkgPT0gbnVsbCB8fCBjYWNoZUtleSAhPSBjdXJyZW50Q2FjaGVLZXkpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5zaG93ID0gXCJnb25lXCI7XG4gICAgICAgIGF3YWl0IGNvbW1vbi5zZXRNb2R1bGVTdGF0dXMoXCJndWlkZVwiLCAyKTtcbiAgICB9XG59XG5cbm1vZHVsZUV2ZW50Lm9wZW5HdWlkUGFnZSA9IGFzeW5jIGZ1bmN0aW9uICgpIHtcbiAgICB2YXIgYnV0dG9uX25hbWUgPSBcIlwiO1xuICAgIGlmIChtb2R1bGVEYXRhLnRhc2tQcm9ncmVzcyA9PSAxKSB7XG4gICAgICAgIC8v5YWl6YeRXG4gICAgICAgIC8vIGxldCBkaWRDaG9vc2UgPSBhd2FpdCBjb21tb24ucmVhZChcImd1aWRlXCIsXCJkaWRDaG9vc2VcIik7XG4gICAgICAgIC8vIGlmIChkaWRDaG9vc2UgPT0gXCIxXCIpIHtcbiAgICAgICAgLy8gICAgIGF3YWl0IGNvbW1vbi5vcGVuVVJMKFwiaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9vdGMvdHJhZGVcIik7XG4gICAgICAgIC8vIH1cbiAgICAgICAgLy8gZWxzZSB7XG4gICAgICAgIC8vICAgICBhd2FpdCBjb21tb24ub3BlblBhZ2UoXCJndWlkZVwiKTtcbiAgICAgICAgLy8gfVxuICAgICAgICBhd2FpdCBjb21tb24ub3BlblBhZ2UoXCJndWlkZVwiKTtcbiAgICAgICAgYnV0dG9uX25hbWUgPSBcImRlcG9zaXRcIjtcbiAgICB9IGVsc2UgaWYgKG1vZHVsZURhdGEudGFza1Byb2dyZXNzID09IDApIHtcbiAgICAgICAgLy/nmbvlvZVcbiAgICAgICAgYXdhaXQgY29tbW9uLm9wZW5QYWdlKFwibG9naW5cIik7IFxuICAgICAgICBidXR0b25fbmFtZSA9IFwibG9naW5cIjtcbiAgICB9XG4gICAgYXdhaXQgY29tbW9uLmFuYWx5dGljcyhcImFwcENsaWNrX2hvbWVcIiwge1xuICAgICAgICBtb2R1bGVfbmFtZTogXCJndWlkYW5jZVwiLFxuICAgICAgICBidXR0b25fbmFtZTogYnV0dG9uX25hbWUsXG4gICAgICAgIG1hdGVyaWFsX25hbWU6ICRkYXRhLmd1aWRlLm1hdGVyaWFsX25hbWVcbiAgICB9KTtcbn0iLCJpbXBvcnQgKiBhcyBjb21tb24gZnJvbSAnLi9jb21tb24nXG5cbnZhciBtb2R1bGVEaWRTdGFydCA9IGZhbHNlO1xuXG4vL+WIneWni+WMllxuYXN5bmMgZnVuY3Rpb24gc3RhcnQoKSB7XG4gICAgbW9kdWxlRGlkU3RhcnQgPSB0cnVlO1xuICAgIGF3YWl0IHJlcXVlc3RJbnZlc3REcmF3ZXJEYXRhKCk7XG59XG5cbi8v5Yid5aeL5YyW5pWw5o2uXG5mdW5jdGlvbiBkZWZhdWx0RGF0YSgpIHtcbiAgICByZXR1cm4ge1xuICAgICAgICBzaG93VGl0bGVUZXh0OiBcIlwiLFxuICAgICAgICB1cmw6IFwiXCIsXG4gICAgICAgIHZpc2liaWxpdHk6IFwiZ29uZVwiLFxuICAgICAgICB0cmFkaW5nVG9FYXJuOnt9LFxuICAgICAgICBjb250cmFjdENvcHlUcmFkZTp7fSxcbiAgICAgICAgZHVhbDp7fSxcbiAgICAgICAgc3BvdDp7fVxuICAgIH07XG59XG5cblxuY29uc3Qge21vZHVsZURhdGEsIG1vZHVsZUV2ZW50fSA9IGNvbW1vbi5tb2R1bGVEZWZpbmUoXCJpbnZlc3RcIiwgc3RhcnQsIGRlZmF1bHREYXRhKTtcblxuYXN5bmMgZnVuY3Rpb24gbW9kdWxlQXBwZWFyKCkge1xuICAgIGF3YWl0IGFuYWx5dGljc0FwcGVhcigpO1xufVxuXG5hc3luYyBmdW5jdGlvbiBtb2R1bGVEaXNhcHBlYXIoKSB7XG5cbn1cblxubW9kdWxlRXZlbnQubW9kdWxlQXBwZWFyID0gbW9kdWxlQXBwZWFyO1xubW9kdWxlRXZlbnQubW9kdWxlRGlzYXBwZWFyID0gbW9kdWxlRGlzYXBwZWFyO1xuXG52YXIgbmVlZEFuYWx5dGljc1doZW5SZXF1ZXN0U3VjY2VzcyA9IGZhbHNlO1xuYXN5bmMgZnVuY3Rpb24gYW5hbHl0aWNzQXBwZWFyKCkge1xuICAgIGlmIChtb2R1bGVEYXRhLnZpc2liaWxpdHkgPT0gXCJnb25lXCIgKSB7XG4gICAgICAgIG5lZWRBbmFseXRpY3NXaGVuUmVxdWVzdFN1Y2Nlc3MgPSB0cnVlO1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIG5lZWRBbmFseXRpY3NXaGVuUmVxdWVzdFN1Y2Nlc3MgPSBmYWxzZTtcbiAgICB2YXIgdHlwZUxpc3QgPSBbXTtcbiAgICBpZiAobW9kdWxlRGF0YS50cmFkaW5nVG9FYXJuLnZpc2liaWxpdHkgPT0gXCJ2aXNpYmxlXCIpIHtcbiAgICAgICAgdHlwZUxpc3QucHVzaChcInRyYWRpbmdUb0Vhcm5cIik7XG4gICAgfSBlbHNlIGlmIChtb2R1bGVEYXRhLnNwb3QudmlzaWJpbGl0eSA9PSBcInZpc2libGVcIikge1xuICAgICAgICB0eXBlTGlzdC5wdXNoKFwiU3BvdEdyaWRcIik7XG4gICAgfSBlbHNlIGlmIChtb2R1bGVEYXRhLmNvbnRyYWN0Q29weVRyYWRlLnZpc2liaWxpdHkgPT0gXCJ2aXNpYmxlXCIpIHtcbiAgICAgICAgdHlwZUxpc3QucHVzaChcImNvbnRyYWN0Q29weVRyYWRlXCIpO1xuICAgIH0gZWxzZSBpZiAobW9kdWxlRGF0YS5kdWFsLnZpc2liaWxpdHkgPT0gXCJ2aXNpYmxlXCIpIHtcbiAgICAgICAgdHlwZUxpc3QucHVzaChcIkR1YWxcIik7XG4gICAgfVxuICAgIFxuICAgIGNvbnN0IHR5cGVTdHIgPSB0eXBlTGlzdC5qb2luKFwiLFwiKTtcbiAgICBhd2FpdCBjb21tb24uYW5hbHl0aWNzKFwiYXBwRXhwb3N1cmVfaG9tZVwiLCB7XG4gICAgICAgIG1vZHVsZV9uYW1lOiBcImludmVzdFwiLFxuICAgICAgICB0eXBlOiB0eXBlU3RyXG4gICAgfSk7XG59XG5cbm1vZHVsZUV2ZW50Lm1vcmVUYXBBY3Rpb24gPSBhc3luYyBmdW5jdGlvbiAoKSB7XG4gICAgbGV0IGp1bXBVcmwgPSBlbmNvZGVVUkkobW9kdWxlRGF0YS51cmwpO1xuICAgIGF3YWl0IGNvbW1vbi5vcGVuVVJMKGp1bXBVcmwpO1xuICAgIGF3YWl0IGNvbW1vbi5hbmFseXRpY3MoXCJhcHBDbGlja19ob21lXCIsIHtcbiAgICAgICAgbW9kdWxlX25hbWU6IFwiaW52ZXN0XCIsXG4gICAgICAgIHR5cGU6IFwibW9yZVwiXG4gICAgfSk7XG59XG5cbm1vZHVsZUV2ZW50LnRhcEFjdGlvbiA9IGFzeW5jIGZ1bmN0aW9uIChrZXkpIHtcbiAgICB2YXIganVtcFVybCA9IFwiXCI7XG4gICAgdmFyIG1vZHVsZV9wb3NpdGlvbiA9IDA7XG4gICAgdmFyIHR5cGVTdHIgPSBcIlwiO1xuICAgIGlmIChrZXkgPT0gXCJ0cmFkaW5nVG9FYXJuXCIpIHtcbiAgICAgICAganVtcFVybCA9IGVuY29kZVVSSShtb2R1bGVEYXRhLnRyYWRpbmdUb0Vhcm4udXJsKTtcbiAgICAgICAgbW9kdWxlX3Bvc2l0aW9uID0gbW9kdWxlRGF0YS50cmFkaW5nVG9FYXJuLm1vZHVsZV9wb3NpdGlvbjtcbiAgICAgICAgdHlwZVN0ciA9IFwidHJhZGluZ1RvRWFyblwiO1xuICAgIH0gZWxzZSAgaWYgKGtleSA9PSBcInNwb3RcIikge1xuICAgICAgICBqdW1wVXJsID0gZW5jb2RlVVJJKG1vZHVsZURhdGEuc3BvdC51cmwpO1xuICAgICAgICBtb2R1bGVfcG9zaXRpb24gPSBtb2R1bGVEYXRhLnNwb3QubW9kdWxlX3Bvc2l0aW9uO1xuICAgICAgICB0eXBlU3RyID0gXCJTcG90R3JpZFwiO1xuICAgIH0gZWxzZSBpZiAoa2V5ID09IFwiY29udHJhY3RDb3B5VHJhZGVcIikge1xuICAgICAgICBqdW1wVXJsID0gZW5jb2RlVVJJKG1vZHVsZURhdGEuY29udHJhY3RDb3B5VHJhZGUudXJsKTtcbiAgICAgICAgbW9kdWxlX3Bvc2l0aW9uID0gbW9kdWxlRGF0YS5jb250cmFjdENvcHlUcmFkZS5tb2R1bGVfcG9zaXRpb247XG4gICAgICAgIHR5cGVTdHIgPSBcImNvbnRyYWN0Q29weVRyYWRlXCI7XG4gICAgfSBlbHNlIGlmIChrZXkgPT0gXCJkdWFsXCIpIHtcbiAgICAgICAganVtcFVybCA9IGVuY29kZVVSSShtb2R1bGVEYXRhLmR1YWwudXJsKTtcbiAgICAgICAgbW9kdWxlX3Bvc2l0aW9uID0gbW9kdWxlRGF0YS5kdWFsLm1vZHVsZV9wb3NpdGlvbjtcbiAgICAgICAgdHlwZVN0ciA9IFwiRHVhbFwiO1xuICAgIH1cblxuICAgIGF3YWl0IGNvbW1vbi5vcGVuVVJMKGp1bXBVcmwpXG5cbiAgICBhd2FpdCBjb21tb24uYW5hbHl0aWNzKFwiYXBwQ2xpY2tfaG9tZVwiLCB7XG4gICAgICAgIG1vZHVsZV9uYW1lOiBcImludmVzdFwiLFxuICAgICAgICBtb2R1bGVfcG9zaXRpb246IFN0cmluZyhtb2R1bGVfcG9zaXRpb24pLFxuICAgICAgICB0eXBlOiB0eXBlU3RyXG4gICAgfSk7XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBydW5UcmFkaW5nVG9FYXJuQ291bnREb3duKCkge1xuICAgIGlmIChtb2R1bGVEaWRTdGFydCA9PSBmYWxzZSkge1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIGlmIChtb2R1bGVEYXRhLnRyYWRpbmdUb0Vhcm4uYWN0aXZpdHlTdGF0dXMgPT09IDAgfHwgbW9kdWxlRGF0YS50cmFkaW5nVG9FYXJuLmFjdGl2aXR5U3RhdHVzID09PSAxKSAge1xuICAgICAgICBjb25zdCByZW1haW5pbmdUaW1lID0gTWF0aC5tYXgoMCwgbW9kdWxlRGF0YS50cmFkaW5nVG9FYXJuLnJlbWFpblRpbWUgLSAxMDAwKTtcbiAgICBcbiAgICAgICAgbGV0IHRpbWVzID0gaGFuZGxlU2hvd1RpbWUocmVtYWluaW5nVGltZSk7XG4gICAgICAgIG1vZHVsZURhdGEudHJhZGluZ1RvRWFybi5yZW1haW5UaW1lID0gcmVtYWluaW5nVGltZTtcbiAgICAgICAgbW9kdWxlRGF0YS50cmFkaW5nVG9FYXJuLmNvdW50RG93blRpbWVTdHIgPSBgJHttb2R1bGVEYXRhLnRyYWRpbmdUb0Vhcm4uc2hvd1NjaGVkdWxlVGV4dH06JHt0aW1lc31gO1xuICAgIFxuICAgICAgICBpZiAocmVtYWluaW5nVGltZSA9PT0gMCkge1xuICAgICAgICAgICAgLy/lgJLorqHml7bnu5PmnZ/vvIzliLfmlrDnirbmgIFcbiAgICAgICAgICAgIG1vZHVsZURhdGEudHJhZGluZ1RvRWFybi5zaG93UmVtYWluID0gY29tbW9uLmdldFZpc2liaWxpdHlTdGF0dXMoZmFsc2UpXG4gICAgICAgICAgICBhd2FpdCByZXF1ZXN0SW52ZXN0RHJhd2VyRGF0YSgpXG4gICAgICAgIH0gZWxzZSB7IFxuICAgICAgICAgICAgbW9kdWxlRGF0YS50cmFkaW5nVG9FYXJuLnNob3dSZW1haW4gPSBjb21tb24uZ2V0VmlzaWJpbGl0eVN0YXR1cyh0cnVlKVxuICAgICAgICB9ICAgIFxuICAgIH1cbn1cblxuYXN5bmMgZnVuY3Rpb24gaW52ZXN0RGF0YUNhbGxCYWNrKGRhdGEsIGlzQ2FjaGUpIHtcbiAgICBhd2FpdCBjb21tb24uc2V0TW9kdWxlU3RhdHVzKFwiaW52ZXN0XCIsIDEpO1xuICAgIGlmICgobW9kdWxlRGF0YS50cmFkaW5nVG9FYXJuIHx8IG1vZHVsZURhdGEuc3BvdCB8fCBtb2R1bGVEYXRhLmNvbnRyYWN0Q29weVRyYWRlIHx8IG1vZHVsZURhdGEuZHVhbCkgJiYgaXNDYWNoZSkge1xuICAgICAgICByZXR1cm47XG4gICAgfVxuXG4gICAgbW9kdWxlRGF0YS5zaG93VGl0bGVUZXh0ID0gZGF0YS5zaG93VGl0bGVUZXh0OyAgIFxuICAgIG1vZHVsZURhdGEudmlzaWJpbGl0eSA9IGNvbW1vbi5nZXRWaXNpYmlsaXR5U3RhdHVzKGRhdGEuc2hvdyk7XG4gICAgbW9kdWxlRGF0YS51cmwgPSBkYXRhLnVybDtcblxuICAgIHZhciBtb2R1bGVfcG9zaXRpb24gPSAxO1xuICAgIG1vZHVsZURhdGEudHJhZGluZ1RvRWFybiA9IGhhbmRsZVRyYWRpbmdUb0Vhcm4oZGF0YS50cmFkaW5nVG9FYXJuKTtcbiAgICBtb2R1bGVEYXRhLnRyYWRpbmdUb0Vhcm4ubW9kdWxlX3Bvc2l0aW9uID0gbW9kdWxlX3Bvc2l0aW9uO1xuXG4gICAgaWYgKG1vZHVsZURhdGEudHJhZGluZ1RvRWFybi52aXNpYmlsaXR5ID09IFwidmlzaWJsZVwiICkge1xuICAgICAgICBtb2R1bGVfcG9zaXRpb24gKz0gMTtcbiAgICB9XG5cbiAgICBsZXQgc3BvdCA9IGRhdGEuc3BvdDtcbiAgICBzcG90LmtleSA9IFwic3BvdFwiO1xuICAgIHNwb3QudmlzaWJpbGl0eSA9IGNvbW1vbi5nZXRWaXNpYmlsaXR5U3RhdHVzKGRhdGEuc3BvdC5zaG93KTtcbiAgICBzcG90LmltZ1Zpc2liaWxpdHkgPSBzcG90LmltZyAhPSB1bmRlZmluZWQgJiYgc3BvdC5pbWcgIT0gbnVsbCAmJiBzcG90LmltZy5sZW5ndGg+MD9cInZpc2libGVcIjpcImdvbmVcIjtcbiAgICBzcG90LnNob3dTdWJUaXRsZVRleHQgPSBzcG90LnNob3dTdWJUaXRsZVRleHQgIT0gdW5kZWZpbmVkICYmIHNwb3Quc2hvd1N1YlRpdGxlVGV4dCAhPSBudWxsICYmIHNwb3Quc2hvd1N1YlRpdGxlVGV4dC5sZW5ndGg+MD9zcG90LnNob3dTdWJUaXRsZVRleHQ6c3BvdC5uaWNrO1xuICAgIHNwb3QudG90YWxQcm9maXRBbW91bnQgPSBnZXRBbW91bnRQcmljZVN0cihzcG90LnRvdGFsUHJvZml0QW1vdW50KTtcbiAgICBzcG90Lm1vZHVsZV9wb3NpdGlvbiA9IG1vZHVsZV9wb3NpdGlvbjtcbiAgICBtb2R1bGVEYXRhLnNwb3QgPSBzcG90O1xuXG4gICAgaWYgKHNwb3QudmlzaWJpbGl0eSA9PSBcInZpc2libGVcIiApIHtcbiAgICAgICAgbW9kdWxlX3Bvc2l0aW9uICs9IDE7XG4gICAgfVxuXG4gICAgbGV0IGNvbnRyYWN0Q29weVRyYWRlID0gZGF0YS5jb250cmFjdENvcHlUcmFkZTtcbiAgICBjb250cmFjdENvcHlUcmFkZS5rZXkgPSBcImNvbnRyYWN0Q29weVRyYWRlXCI7XG4gICAgY29udHJhY3RDb3B5VHJhZGUudmlzaWJpbGl0eSA9IGNvbW1vbi5nZXRWaXNpYmlsaXR5U3RhdHVzKGRhdGEuY29udHJhY3RDb3B5VHJhZGUuc2hvdyk7XG4gICAgY29udHJhY3RDb3B5VHJhZGUudG90YWxQcm9maXRBbW91bnQgPSBnZXRBbW91bnRQcmljZVN0cihjb250cmFjdENvcHlUcmFkZS50b3RhbFByb2ZpdEFtb3VudCk7XG4gICAgY29udHJhY3RDb3B5VHJhZGUubW9kdWxlX3Bvc2l0aW9uID0gbW9kdWxlX3Bvc2l0aW9uO1xuICAgIG1vZHVsZURhdGEuY29udHJhY3RDb3B5VHJhZGUgPSBjb250cmFjdENvcHlUcmFkZTtcblxuICAgIGlmIChjb250cmFjdENvcHlUcmFkZS52aXNpYmlsaXR5ID09IFwidmlzaWJsZVwiICkge1xuICAgICAgICBtb2R1bGVfcG9zaXRpb24gKz0gMTtcbiAgICB9XG5cbiAgICBtb2R1bGVEYXRhLmR1YWwgPSBoYW5kbGVEdWFsKGRhdGEpO1xuICAgIG1vZHVsZURhdGEuZHVhbC5tb2R1bGVfcG9zaXRpb24gPSBtb2R1bGVfcG9zaXRpb247XG5cbn1cblxuZnVuY3Rpb24gZ2V0QW1vdW50UHJpY2VTdHIocHJpY2UpIHtcbiAgICBpZiAocHJpY2UgPT0gbnVsbCkge1xuICAgICAgICByZXR1cm4gXCIkLS1cIlxuICAgIH1cbiAgICB2YXIgcHJpY2VTdHIgPSBTdHJpbmcocHJpY2UpO1xuICAgIHByaWNlU3RyID0gcHJpY2VTdHIucmVwbGFjZShcIiRcIiwgXCJcIik7XG4gICAgdmFyIGFtb3VudFN0ciA9IGNvbW1vbi5nZXRQcmljZVN0cmluZyhwcmljZVN0ciwgMik7XG4gICAgcmV0dXJuIGAkJHthbW91bnRTdHJ9YDtcbn1cblxuLy/mipXotYTnkIbotKJcbmFzeW5jIGZ1bmN0aW9uIHJlcXVlc3RJbnZlc3REcmF3ZXJEYXRhKCkge1xuICAgIGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdFdpdGhDYWNoZSgndjEvYXBwL2ludmVzdC9kcmF3ZXIvZ2V0RGF0YScsIGNhbGxiYWNrID0gaW52ZXN0RGF0YUNhbGxCYWNrKTtcbiAgICBpZiAobW9kdWxlRGF0YS52aXNpYmlsaXR5ID09PSBcInZpc2libGVcIikge1xuICAgICAgICBhd2FpdCBjb21tb24uc2V0TW9kdWxlU3RhdHVzKFwiaW52ZXN0XCIsIDEpO1xuICAgICAgICBpZiAobmVlZEFuYWx5dGljc1doZW5SZXF1ZXN0U3VjY2VzcyA9PSB0cnVlKSB7XG4gICAgICAgICAgICBhd2FpdCBhbmFseXRpY3NBcHBlYXIoKTtcbiAgICAgICAgfVxuICAgIH0gZWxzZSB7XG4gICAgICAgIGF3YWl0IGNvbW1vbi5zZXRNb2R1bGVTdGF0dXMoXCJpbnZlc3RcIiwgMik7XG4gICAgfVxufVxuXG5mdW5jdGlvbiBoYW5kbGVEdWFsKGRhdGEpIHtcbiAgICBsZXQgZHVhbCA9IGRhdGEuZHVhbDtcbiAgICBkdWFsLmtleSA9IFwiZHVhbFwiO1xuICAgIGR1YWwudmlzaWJpbGl0eSA9IGNvbW1vbi5nZXRWaXNpYmlsaXR5U3RhdHVzKGRhdGEuZHVhbC5zaG93KTsgXG5cbiAgICBpZiAoZGF0YS5kdWFsLmN1cnJlbmN5KSB7XG4gICAgICAgIGR1YWwuaW1nQ3VycmVuY3kgPSBjb21tb24uZ2V0SWNvblVSTChkYXRhLmR1YWwuY3VycmVuY3kpO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIGR1YWwuaW1nQ3VycmVuY3kgPSBcIkBkcmF3YWJsZS9ob21lX2NvaW5fcGxhY2Vob2xkZXJfMjRcIjtcbiAgICB9XG5cbiAgICBpZiAoZGF0YS5kdWFsLmNvdmVydEN1cnJlbmN5KSB7XG4gICAgICAgIGR1YWwuaW1nZUNvdmVydEN1cnJlbmN5ID0gY29tbW9uLmdldEljb25VUkwoZGF0YS5kdWFsLmNvdmVydEN1cnJlbmN5KTtcbiAgICB9IGVsc2Uge1xuICAgICAgICBkdWFsLmltZ2VDb3ZlcnRDdXJyZW5jeSA9IFwiQGRyYXdhYmxlL2hvbWVfY29pbl9wbGFjZWhvbGRlcl8yNFwiO1xuICAgIH1cblxuICAgIGR1YWwucmF0ZVRpdGxlID0gXCJBUFlcIjtcbiAgICBsZXQgYXB5ID0gZGF0YS5kdWFsLmFweTtcbiAgICBkdWFsLmFweVBlcmNlbnQgPSBmb3JtYXROdW1iZXIoYXB5KTtcblxuICAgIHJldHVybiBkdWFsO1xufVxuXG5mdW5jdGlvbiBoYW5kbGVUcmFkaW5nVG9FYXJuKGRhdGEpIHtcbiAgICBsZXQgdHJhZGluZ1RvRWFybiA9IGRhdGE7XG4gICAgdHJhZGluZ1RvRWFybi5rZXkgPSBcInRyYWRpbmdUb0Vhcm5cIjtcbiAgICB0cmFkaW5nVG9FYXJuLnZpc2liaWxpdHkgPSBjb21tb24uZ2V0VmlzaWJpbGl0eVN0YXR1cyhkYXRhLnNob3cpO1xuXG4gICAgbGV0IGFweVBlcmNlbnQgPSBkYXRhLmFweVBlcmNlbnQ7XG4gICAgdHJhZGluZ1RvRWFybi5hcHlQZXJjZW50ID0gZm9ybWF0TnVtYmVyKGFweVBlcmNlbnQpO1xuICAgIFxuICAgIGlmIChkYXRhLnN5bWJvbCkge1xuICAgICAgICB0cmFkaW5nVG9FYXJuLnN5bWJvbCA9IGRhdGEuc3ltYm9sLnRvVXBwZXJDYXNlKCk7XG4gICAgfVxuXG4gICAgLy8vIOa0u+WKqOWllumHkeminVxuICAgIGxldCBwcml6ZUFtb3VudCA9IChkYXRhLnByaXplQW1vdW50ICE9IG51bGwpID8gcGFyc2VJbnQoZGF0YS5wcml6ZUFtb3VudCkgOiAxO1xuICAgIGxldCBwcml6ZUFtb3VudERpc3BsYXkgPSBgLyR7Zm9ybWF0TnVtYmVyV2l0aENvbW1hcyhwcml6ZUFtb3VudCl9YDtcblxuICAgIC8vLyDlpZbph5HmsaDlt7Lkvb/nlKjpop3luqZcbiAgICBsZXQgYWxsb2NhdGVkU2NvcmUgPSAoZGF0YS5hbGxvY2F0ZWRTY29yZSAhPSBudWxsKSA/IHBhcnNlSW50KGRhdGEuYWxsb2NhdGVkU2NvcmUpIDogMTtcbiAgICBsZXQgYWxsb2NhdGVkU2NvcmVEaXNwbGF5ID0gZm9ybWF0TnVtYmVyV2l0aENvbW1hcyhhbGxvY2F0ZWRTY29yZSk7XG5cbiAgICBsZXQgcmVtYWluaW5nUHJvcG9ydGlvbiA9IHByaXplQW1vdW50IC0gYWxsb2NhdGVkU2NvcmU7XG5cbiAgICBpZiAoYWxsb2NhdGVkU2NvcmUgPiAwKSB7XG4gICAgICAgIHRyYWRpbmdUb0Vhcm4udXNlZFByb3BvcnRpb25TaG93ID0gY29tbW9uLmdldFZpc2liaWxpdHlTdGF0dXModHJ1ZSk7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgYWxsb2NhdGVkU2NvcmUgPSAyXG4gICAgICAgIHRyYWRpbmdUb0Vhcm4udXNlZFByb3BvcnRpb25TaG93ID0gY29tbW9uLmdldFZpc2liaWxpdHlTdGF0dXMoZmFsc2UpO1xuICAgIH1cbiAgICB0cmFkaW5nVG9FYXJuLnVzZWRQcm9wb3J0aW9uID0gU3RyaW5nKGFsbG9jYXRlZFNjb3JlKTtcblxuICAgIGlmIChyZW1haW5pbmdQcm9wb3J0aW9uID4gMCkge1xuICAgICAgICB0cmFkaW5nVG9FYXJuLnJlbWFpbmluZ1Byb3BvcnRpb25TaG93ID0gY29tbW9uLmdldFZpc2liaWxpdHlTdGF0dXModHJ1ZSk7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgcmVtYWluaW5nUHJvcG9ydGlvbiA9IDJcbiAgICAgICAgdHJhZGluZ1RvRWFybi5yZW1haW5pbmdQcm9wb3J0aW9uU2hvdyA9IGNvbW1vbi5nZXRWaXNpYmlsaXR5U3RhdHVzKGZhbHNlKTtcbiAgICB9XG4gICAgdHJhZGluZ1RvRWFybi5yZW1haW5pbmdQcm9wb3J0aW9uID0gU3RyaW5nKHJlbWFpbmluZ1Byb3BvcnRpb24pO1xuXG5cbiAgICBjb25zb2xlLmxvZyhgdXNlZFByb3BvcnRpb24gJHt0cmFkaW5nVG9FYXJuLnVzZWRQcm9wb3J0aW9ufSAgcmVtYWluaW5nUHJvcG9ydGlvbiAgJHt0cmFkaW5nVG9FYXJuLnJlbWFpbmluZ1Byb3BvcnRpb259YCk7XG5cbiAgICBsZXQgcHJpemVBbW91bnRTdHJpbmcgPSBwcml6ZUFtb3VudERpc3BsYXk7XG4gICAgbGV0IGFsbG9jYXRlZFNjb3JlU3RyaW5nID0gYWxsb2NhdGVkU2NvcmVEaXNwbGF5O1xuXG4gICAgdHJhZGluZ1RvRWFybi5wcml6ZUFtb3VudFN0cmluZyA9IHByaXplQW1vdW50U3RyaW5nO1xuICAgIHRyYWRpbmdUb0Vhcm4uYWxsb2NhdGVkU2NvcmVTdHJpbmcgPSBhbGxvY2F0ZWRTY29yZVN0cmluZztcbiAgICBcbiAgICAvLzAgUmVhZOOAgSAxIEluUHJvZ3Jlc3NcbiAgICB0cmFkaW5nVG9FYXJuLmFjdGl2aXR5U3RhdHVzID0gZGF0YS5hY3Rpdml0eVN0YXR1cztcblxuICAgIGlmICh0cmFkaW5nVG9FYXJuLmFjdGl2aXR5U3RhdHVzID09PSAwIHx8IHRyYWRpbmdUb0Vhcm4uYWN0aXZpdHlTdGF0dXMgPT09IDEpIHtcbiAgICAgICAgdmFyIHJlbWFpblRpbWUgPSAwO1xuICAgICAgICBpZiAodHJhZGluZ1RvRWFybi5hY3Rpdml0eVN0YXR1cyA9PSAwKSB7XG4gICAgICAgICAgICByZW1haW5UaW1lID0gKGRhdGEuc3RhcnRUaW1lIC0gZGF0YS5zeXN0ZW1UaW1lKTtcbiAgICAgICAgfSBlbHNlIGlmICh0cmFkaW5nVG9FYXJuLmFjdGl2aXR5U3RhdHVzID0gMSkge1xuICAgICAgICAgICAgcmVtYWluVGltZSA9IChkYXRhLmVuZFRpbWUgLSBkYXRhLnN5c3RlbVRpbWUpO1xuICAgICAgICB9XG4gICAgICAgIGlmIChyZW1haW5UaW1lIDw9IDApIHtcbiAgICAgICAgICAgIHJlbWFpblRpbWUgPSAwO1xuICAgICAgICAgICAgdHJhZGluZ1RvRWFybi5zaG93UmVtYWluID0gY29tbW9uLmdldFZpc2liaWxpdHlTdGF0dXMoZmFsc2UpXG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICB0cmFkaW5nVG9FYXJuLnJlbWFpblRpbWUgPSByZW1haW5UaW1lO1xuICAgICAgICAgICAgbGV0IHRpbWVzID0gaGFuZGxlU2hvd1RpbWUodHJhZGluZ1RvRWFybi5yZW1haW5UaW1lKTtcbiAgICAgICAgICAgIHRyYWRpbmdUb0Vhcm4uY291bnREb3duVGltZVN0ciA9IGAke3RyYWRpbmdUb0Vhcm4uc2hvd1NjaGVkdWxlVGV4dH06JHt0aW1lc31gO1xuICAgICAgICAgICAgdHJhZGluZ1RvRWFybi5zaG93UmVtYWluID0gY29tbW9uLmdldFZpc2liaWxpdHlTdGF0dXModHJ1ZSlcbiAgICAgICAgfVxuICAgIH0gZWxzZSB7XG4gICAgICAgIHRyYWRpbmdUb0Vhcm4uc2hvd1JlbWFpbiA9IGNvbW1vbi5nZXRWaXNpYmlsaXR5U3RhdHVzKGZhbHNlKVxuICAgIH1cblxuICAgIGxldCBzeW1ib2xJbmZvID0gY29tbW9uLmdldFN5bWJvbEluZm8oZGF0YS5zeW1ib2wpO1xuICAgIGlmIChzeW1ib2xJbmZvKSB7XG4gICAgICAgIGxldCBjb2luSWNvbiA9IGNvbW1vbi5nZXRJY29uVVJMKHN5bWJvbEluZm8uYmFzZUN1cnJlbmN5KTtcbiAgICAgICAgdHJhZGluZ1RvRWFybi5jb2luSWNvbiA9IGNvaW5JY29uO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIHRyYWRpbmdUb0Vhcm4uY29pbkljb24gPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9ob21lX2NvaW5fcGxhY2Vob2xkZXJfMTZcIjtcbiAgICB9XG4gICAgcmV0dXJuIHRyYWRpbmdUb0Vhcm47XG59XG5cbmZ1bmN0aW9uIGhhbmRsZVNob3dUaW1lKHRpbWVzdGFtcCkge1xuXG4gICAgY29uc3Qgc2Vjb25kcyA9IE1hdGguZmxvb3IodGltZXN0YW1wIC8gMTAwMCk7XG4gICAgY29uc3QgbWludXRlcyA9IE1hdGguZmxvb3Ioc2Vjb25kcyAvIDYwKTtcbiAgICBjb25zdCBob3VycyA9IE1hdGguZmxvb3IobWludXRlcyAvIDYwKTtcbiAgICBjb25zdCBkYXlzID0gTWF0aC5mbG9vcihob3VycyAvIDI0KTtcblxuICAgIHZhciBzaG93RGF5ID0gZGF5cyA+IDAgPyB0cnVlIDogZmFsc2U7XG5cbiAgICBjb25zdCByZW1haW5pbmdTZWNvbmRzID0gc2Vjb25kcyAlIDYwO1xuICAgIGNvbnN0IHJlbWFpbmluZ01pbnV0ZXMgPSBtaW51dGVzICUgNjA7XG4gICAgY29uc3QgcmVtYWluaW5nSG91cnMgPSBob3VycyAlIDI0O1xuXG4gICAgLy8g6KGl6Zu25Ye95pWwXG4gICAgY29uc3QgYWRkTGVhZGluZ1plcm8gPSAodmFsdWUpID0+IHtcbiAgICAgICAgcmV0dXJuIHZhbHVlIDwgMTAgPyBgMCR7dmFsdWV9YCA6IHZhbHVlLnRvU3RyaW5nKCk7XG4gICAgfTtcbiAgXG4gICAgLy8g5a656ZSZ5aSE55CGXG4gICAgY29uc3Qgc2FmZVZhbHVlID0gKHZhbHVlKSA9PiB7XG4gICAgICAgIHJldHVybiB2YWx1ZSA+IDAgPyB2YWx1ZSA6IDA7XG4gICAgfTtcblxuICAgIGNvbnN0IGQgPSBhZGRMZWFkaW5nWmVybyhzYWZlVmFsdWUoZGF5cykpO1xuICAgIGNvbnN0IGggPSBhZGRMZWFkaW5nWmVybyhzYWZlVmFsdWUocmVtYWluaW5nSG91cnMpKTtcbiAgICBjb25zdCBtID0gYWRkTGVhZGluZ1plcm8oc2FmZVZhbHVlKHJlbWFpbmluZ01pbnV0ZXMpKTtcbiAgICBjb25zdCBzID0gYWRkTGVhZGluZ1plcm8oc2FmZVZhbHVlKHJlbWFpbmluZ1NlY29uZHMpKTtcblxuICAgIGlmIChzaG93RGF5ID09PSB0cnVlKSB7XG4gICAgICAgIHJldHVybiBgJHtkfToke2h9OiR7bX06JHtzfWA7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgcmV0dXJuIGAke2h9OiR7bX06JHtzfWA7XG4gICAgfVxufVxuXG5mdW5jdGlvbiBmb3JtYXROdW1iZXIobnVtYmVyKSB7XG4gICAgY29uc3QgZmxvYXRWYWx1ZSA9IHBhcnNlRmxvYXQobnVtYmVyKTtcbiAgICBpZiAoaXNOYU4oZmxvYXRWYWx1ZSkpIHtcbiAgICAgIHJldHVybiBcIjAuMDAlXCI7XG4gICAgfVxuICAgIGNvbnN0IHRydW5jYXRlZFZhbHVlID0gTWF0aC50cnVuYyhmbG9hdFZhbHVlICogMTAwMDApIC8gMTAwO1xuICAgIGNvbnN0IGZvcm1hdHRlZE51bWJlciA9IHRydW5jYXRlZFZhbHVlLnRvRml4ZWQoMik7XG4gIFxuICAgIHJldHVybiBgJHtmb3JtYXR0ZWROdW1iZXJ9JWA7XG59XG5cbmZ1bmN0aW9uIGZvcm1hdE51bWJlcldpdGhDb21tYXMobnVtYmVyKSB7XG4gICAgaWYgKHR5cGVvZiBudW1iZXIgIT09ICdudW1iZXInKSB7XG4gICAgICByZXR1cm4gJyc7XG4gICAgfVxuXG4gICAgY29uc3QgcGFydHMgPSBudW1iZXIudG9TdHJpbmcoKS5zcGxpdCgnLicpO1xuICAgIHBhcnRzWzBdID0gcGFydHNbMF0ucmVwbGFjZSgvXFxCKD89KFxcZHszfSkrKD8hXFxkKSkvZywgJywnKTtcblxuICAgIHJldHVybiBwYXJ0cy5qb2luKCcuJyk7XG4gIH1cbiIsImltcG9ydCAqIGFzIGNvbW1vbiBmcm9tICcuL2NvbW1vbidcblxudmFyIG1vZHVsZURpZFN0YXJ0ID0gZmFsc2U7XG5cbi8v5Yid5aeL5YyWXG5hc3luYyBmdW5jdGlvbiBzdGFydCgpIHtcbiAgICBtb2R1bGVEaWRTdGFydCA9IHRydWU7XG4gICAgaWYgKGNvbW1vbi5jb21tYW5EYXRhLmlzSW5SZXZpZXcgPT0gMSkge1xuICAgICAgICAkZGF0YS5iYW5uZXIuYmFubmVyVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuICAgICAgICAkZGF0YS5iYW5uZXIubm90aWNlVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgICAgICAkZGF0YS5iYW5uZXIuYmFubmVyUGxhY2Vob2xlclZpc2liaWxpdHkgPSBcInZpc2libGVcIjtcbiAgICAgICAgJGRhdGEuYmFubmVyLmJhbm5lclBsYWNlaG9sZXJJbWFnZSA9IFwiQGRyYXdhYmxlL2hvbWVfYmFubmVyX2ltYWdlX2luUmV2aWV3XCJcbiAgICAgICAgYXdhaXQgY29tbW9uLnNldE1vZHVsZVN0YXR1cyhcImJhbm5lclwiLCAxKTtcbiAgICB9XG4gICAgZWxzZSB7XG4gICAgICAgIGF3YWl0IHJlcXVlc3RCYW5uZXIoKTtcbiAgICB9XG59XG5cbi8v5Yid5aeL5YyW5pWw5o2uXG5mdW5jdGlvbiBkZWZhdWx0RGF0YSgpIHtcbiAgICByZXR1cm4ge1xuICAgICAgICBiYW5uZXJMaXN0OltdLFxuICAgICAgICBub3RpY2VMaXN0OltdLFxuICAgICAgICBiYW5uZXJDdXJyZW50SW5kZXg6XCIxXCIsXG4gICAgICAgIG5vdGljZUN1cnJlbnRJbmRleDpcIjFcIixcbiAgICAgICAgdG90YWxQYWdlOlwiMFwiLFxuICAgICAgICBiYW5uZXJWaXNpYmlsaXR5OlwiZ29uZVwiLFxuICAgICAgICBub3RpY2VWaXNpYmlsaXR5OlwiZ29uZVwiLFxuICAgICAgICBiYW5uZXJUZXh0VmlzaWJpbGl0eTpcImdvbmVcIixcbiAgICAgICAgYmFubmVyUGxhY2Vob2xlclZpc2liaWxpdHk6XCJnb25lXCIsXG4gICAgICAgIGJhbm5lclBsYWNlaG9sZXJJbWFnZTpcIkBkcmF3YWJsZS9ob21lX25ld19iYW5uZXJfcGxhY2Vob2xkZXJcIixcbiAgICAgICAgbm90aWNlUGxhY2Vob2xlclZpc2liaWxpdHk6XCJnb25lXCIsXG4gICAgICAgIGJhbm5lckFuZHJvaWRTdHJva2VWaXNpYmlsaXR5OmNvbW1vbi5jb21tYW5EYXRhLk9TID09IDEgP1widmlzaWJsZVwiOlwiZ29uZVwiLFxuICAgICAgICBhdXRvU2Nyb2xsOiBcInRydWVcIixcbiAgICAgICAgY3VycmVudEluZGV4OlwiMFwiLFxuICAgICAgICBjdXJyZW50Tm90aWNlSW5kZXg6XCIwXCJcbiAgIH07XG59XG5cbmNvbnN0IHttb2R1bGVEYXRhLCBtb2R1bGVFdmVudH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFwiYmFubmVyXCIsIHN0YXJ0LCBkZWZhdWx0RGF0YSk7XG5cbnZhciBiYW5uZXJFeHBvc3VyZU1hcCA9IG5ldyBNYXAoKTtcbnZhciBub3RpdmVFeHBvc3VyZU1hcCA9IG5ldyBNYXAoKTtcblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGJhbm5lckV4cG9zdXJlKCkge1xuICAgIHZhciBpbmRleCA9IHBhcnNlSW50KG1vZHVsZURhdGEuYmFubmVyQ3VycmVudEluZGV4KSAtIDE7XG4gICAgaWYgKGluZGV4ID49IGJhbm5lckRhdGFMaXN0Lmxlbmd0aCkge1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIHZhciBvYmogPSBiYW5uZXJEYXRhTGlzdFtpbmRleF07XG4gICAgaWYoIWJhbm5lckV4cG9zdXJlTWFwLmhhcyhvYmpbXCJpZFwiXSkpe1xuICAgICAgICB0cnkge1xuICAgICAgICAgICAgYXdhaXQgY29tbW9uLmFuYWx5dGljcyhcImFwcEV4cG9zdXJlX2hvbWVcIiwge1xuICAgICAgICAgICAgICAgICAgICBtb2R1bGVfbmFtZTogXCJiYW5uZXJcIixcbiAgICAgICAgICAgICAgICAgICAgbW9kdWxlX3Bvc2l0aW9uOiBTdHJpbmcoaW5kZXggKyAxKSxcbiAgICAgICAgICAgICAgICAgICAgbWF0ZXJpYWxfbmFtZTogb2JqW1wiYWROYW1lXCJdLFxuICAgICAgICAgICAgICAgICAgICBlbGVtZW50SWQ6IFN0cmluZyhvYmpbXCJpZFwiXSksXG4gICAgICAgICAgICAgICAgfSk7XG4gICAgICAgICAgICAgICAgYmFubmVyRXhwb3N1cmVNYXAuc2V0KG9ialtcImlkXCJdLHRydWUpO1xuICAgICAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgYmFubmVyIGJhbm5lckV4cG9zdXJlIGVycm9yLCBlcnJvcj0ke2V9YCk7XG4gICAgICAgIH1cbiAgICB9XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBub3RpY2VFeHBvc3VyZSgpIHtcbiAgICB2YXIgaW5kZXggPSBwYXJzZUludChtb2R1bGVEYXRhLm5vdGljZUN1cnJlbnRJbmRleCkgLSAxO1xuICAgIGlmIChpbmRleCA+PSBub3RpY2VEYXRhTGlzdC5sZW5ndGgpIHtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICB2YXIgb2JqID0gbm90aWNlRGF0YUxpc3RbaW5kZXhdO1xuICAgIGlmKCFub3RpdmVFeHBvc3VyZU1hcC5oYXMob2JqW1wicHJvY2xhX2lkXCJdKSl7XG4gICAgICAgIHRyeSB7XG4gICAgICAgICAgICBhd2FpdCBjb21tb24uYW5hbHl0aWNzKFwiYXBwRXhwb3N1cmVfaG9tZVwiLCB7XG4gICAgICAgICAgICAgICAgICAgIG1vZHVsZV9uYW1lOiBcIm5vdGljZVwiLFxuICAgICAgICAgICAgICAgICAgICB0eXBlOiBvYmpbXCJvcmdUYWdcIl0sXG4gICAgICAgICAgICAgICAgICAgIG5vdGljZV9pc190b3A6IG9ialtcImlzVG9wXCJdLFxuICAgICAgICAgICAgICAgICAgICBlbGVtZW50SWQ6IFN0cmluZyhvYmpbXCJwcm9jbGFfaWRcIl0pLFxuICAgICAgICAgICAgICAgIH0pO1xuICAgICAgICAgICAgICAgIG5vdGl2ZUV4cG9zdXJlTWFwLnNldChvYmpbXCJwcm9jbGFfaWRcIl0sdHJ1ZSk7XG4gICAgICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGBub3RpY2Ugbm90aXZlRXhwb3N1cmUgZXJyb3IsIGVycm9yPSR7ZX1gKTtcbiAgICAgICAgfVxuICAgIH1cbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGNsZWFyQmFubmVyRXhwb3N1cmVNYXAoKSB7XG4gICAgYmFubmVyRXhwb3N1cmVNYXAuY2xlYXIoKTtcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGNsZWFyTm90aWNlRXhwb3N1cmVNYXAoKSB7XG4gICAgbm90aXZlRXhwb3N1cmVNYXAuY2xlYXIoKTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gbW9kdWxlQXBwZWFyKCkge1xuICAgIGF3YWl0IGJhbm5lckV4cG9zdXJlKCk7XG4gICAgYXdhaXQgbm90aWNlRXhwb3N1cmUoKTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gbW9kdWxlRGlzYXBwZWFyKCkge1xuXG59XG5cbm1vZHVsZUV2ZW50Lm1vZHVsZUFwcGVhciA9IG1vZHVsZUFwcGVhcjtcbm1vZHVsZUV2ZW50Lm1vZHVsZURpc2FwcGVhciA9IG1vZHVsZURpc2FwcGVhcjtcblxuYXN5bmMgZnVuY3Rpb24gcmVxdWVzdEJhbm5lcigpIHtcbiAgICBhd2FpdCByZXF1ZXN0QmFubmVyTGlzdCgpO1xuICAgIGF3YWl0IHJlcXVlc3ROb3RpY2VMaXN0KCk7XG59XG5cbnZhciBiYW5uZXJEYXRhTGlzdCA9IFtdO1xudmFyIG5vdGljZURhdGFMaXN0ID0gW107XG5cbmFzeW5jIGZ1bmN0aW9uIHJlcXVlc3RCYW5uZXJMaXN0KCkge1xuICAgIHZhciB1YSA9IFwiTTpodW9iaWFwcDpwaG9uZTphbmRyb2lkXCI7XG4gICAgaWYgKGNvbW1vbi5jb21tYW5EYXRhLk9TID09IDApIHtcbiAgICAgICAgLy8gaW9zXG4gICAgICAgIHVhID0gXCJNOmh1b2JpYXBwOnBob25lOmlPU1wiO1xuICAgIH0gXG5cbiAgICB2YXIgY1R5cGUgPSBcIjFcIjtcbiAgICB2YXIgY291bnRyeUlkID0gcGFyc2VJbnQoY29tbW9uLmNvbW1hbkRhdGEudXNlckluZm8uY291bnRyeUlkKVxuICAgIGlmIChjb3VudHJ5SWQgPiAwICYmIGNvdW50cnlJZCAhPSAzNykge1xuICAgICAgICAvLyBpb3NcbiAgICAgICAgY1R5cGUgPSBcIjJcIjtcbiAgICB9IFxuXG4gICAgdmFyIHVpZCA9IGNvbW1vbi5jb21tYW5EYXRhLnVzZXJJbmZvLnVJZDtcbiAgICBpZiAoY29tbW9uLmNvbW1hbkRhdGEuaXNMb2dpbiAhPSAxKSB7XG4gICAgICAgIHVpZCA9IFwiXCI7XG4gICAgfVxuXG4gICAgdmFyIHBhcmFtcyA9IHsgbGFuZzogY29tbW9uLmNvbW1hbkRhdGEubGFuZ3VhZ2UsIHR5cGU6ICc1MicsIHVJZDogdWlkLCBjaGFubmVsX25hbWU6ICdodW9iaScsIHVzZXJBZ2VudDogdWEsIHZlcnNpb246IGNvbW1vbi5jb21tYW5EYXRhLmFwcFZlcnNpb24sIGNvdW50cnlUeXBlOiBjVHlwZX07XG5cbiAgICB2YXIgaGVhZGVyID0ge307XG4gICAgdmFyIHJlZ2lzdGVyQ291bnRyeUlkID0gY29tbW9uLmNvbW1hbkRhdGEudXNlckluZm8ucmVnaXN0ZXJDb3VudHJ5SWQ7XG4gICAgaWYgKHJlZ2lzdGVyQ291bnRyeUlkID4gMCkge1xuICAgICAgICBoZWFkZXJbXCJjbGllbnRDb3VudHJ5SWRcIl0gPSByZWdpc3RlckNvdW50cnlJZDtcbiAgICB9XG4gICAgYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0V2l0aENhY2hlKCd2MS9hcHAtd2ViLWFwaS9iYW5uZXIvbGlzdCcsIGNhbGxiYWNrID0gYmFubmVyRGF0YUNhbGxiYWNrLCBwYXJhbXMgLCAwLCAwLCBoZWFkZXIsIFtdKTtcbiAgICBhd2FpdCBjb21tb24uc2V0TW9kdWxlU3RhdHVzKFwiYmFubmVyXCIsIDEpO1xufVxuXG5hc3luYyBmdW5jdGlvbiBiYW5uZXJEYXRhQ2FsbGJhY2soYmFubmVyRGF0YSwgaXNDYWNoZSkge1xuICAgIGF3YWl0IGNvbW1vbi5zZXRNb2R1bGVTdGF0dXMoXCJiYW5uZXJcIiwgMSk7XG4gICAgaWYoaXNDYWNoZSAmJiBiYW5uZXJEYXRhTGlzdC5sZW5ndGggPiAwKXtcbiAgICAgICAgLy/mlbDmja7mmL7npLrlh7rmnaXkuYvlkI4g57yT5a2Y5Zue5p2l5LiN55So5Yi35pawXG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgaWYgKGJhbm5lckRhdGEgJiYgYmFubmVyRGF0YSAhPSBcIlwiKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKFwicmVxdWVzdEJhbm5lckxpc3QgXCIgKyBKU09OLnN0cmluZ2lmeShiYW5uZXJEYXRhKSk7XG4gICAgICAgIGlmIChiYW5uZXJEYXRhICE9IG51bGwgJiYgYmFubmVyRGF0YS5hZExpc3QgIT0gbnVsbCkge1xuICAgICAgICAgICAgLy9BbmRyb2lk5Zub5Liq5ZyG6KeS5o+P6L655peg5rOV5pi+56S6IOmhtuS4iuimhuebluS4gOS4quWchuinkuaPj+i+uSBpT1PpmpDol4/kuI3nhLbml6Dms5Xngrnlh7vova7mkq3lm75cbiAgICAgICAgICAgIG1vZHVsZURhdGEuYmFubmVyQW5kcm9pZFN0cm9rZVZpc2liaWxpdHkgPSBjb21tb24uY29tbWFuRGF0YS5PUyA9PSAxID9cInZpc2libGVcIjpcImdvbmVcIjtcbiAgICAgICAgICAgIGJhbm5lckRhdGFMaXN0ID0gaXNFZmZlY3RpdmVBZHZlcnRpc2luZyhiYW5uZXJEYXRhLmFkTGlzdCk7XG4gICAgICAgICAgICBmb3IgKHZhciBpID0gMDsgaSA8IGJhbm5lckRhdGFMaXN0Lmxlbmd0aDsgaSsrKSB7XG4gICAgICAgICAgICAgICAgdmFyIG9iaiA9IGJhbm5lckRhdGFMaXN0W2ldO1xuICAgICAgICAgICAgICAgIG9ialtcInR5cGVcIl09XCIxXCI7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhcInJlcXVlc3RCYW5uZXJMaXN0IGVmZmVjdGl2ZUFkTGlzdO+8mlwiICsgSlNPTi5zdHJpbmdpZnkoYmFubmVyRGF0YUxpc3QpKTtcbiAgICAgICAgICAgIHZhciBsZW5ndGggPSBiYW5uZXJEYXRhTGlzdC5sZW5ndGggPD0gcGFyc2VJbnQobW9kdWxlRGF0YS5jdXJyZW50SW5kZXgpID8gXCIwXCIgOiBwYXJzZUludChtb2R1bGVEYXRhLmN1cnJlbnRJbmRleCk7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLmJhbm5lckxpc3QgPSBiYW5uZXJEYXRhTGlzdDtcbiAgICAgICAgICAgIG1vZHVsZURhdGEuY3VycmVudEluZGV4ID0gU3RyaW5nKGxlbmd0aCk7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLnRvdGFsUGFnZSA9IFN0cmluZyhiYW5uZXJEYXRhTGlzdC5sZW5ndGgpO1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5iYW5uZXJWaXNpYmlsaXR5ID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLmJhbm5lclRleHRWaXNpYmlsaXR5ID0gYmFubmVyRGF0YUxpc3QubGVuZ3RoID4gMSA/IFwidmlzaWJsZVwiIDogXCJnb25lXCI7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLmJhbm5lclBsYWNlaG9sZXJWaXNpYmlsaXR5ID0gYmFubmVyRGF0YUxpc3QubGVuZ3RoID4gMCA/IFwiZ29uZVwiIDogXCJ2aXNpYmxlXCIgO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5iYW5uZXJQbGFjZWhvbGVyVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5iYW5uZXJWaXNpYmlsaXR5ID0gXCJnb25lXCI7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLmJhbm5lclRleHRWaXNpYmlsaXR5ID0gXCJnb25lXCI7XG4gICAgICAgIH1cbiAgICB9IGVsc2Uge1xuICAgICAgICBtb2R1bGVEYXRhLmJhbm5lclBsYWNlaG9sZXJWaXNpYmlsaXR5ID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgIG1vZHVsZURhdGEuYmFubmVyVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgICAgICBtb2R1bGVEYXRhLmJhbm5lclRleHRWaXNpYmlsaXR5ID0gXCJnb25lXCI7XG4gICAgICAgIG1vZHVsZURhdGEuYmFubmVyTGlzdCA9IG51bGw7XG4gICAgfVxufVxuXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0Tm90aWNlTGlzdCgpIHtcbiAgICB2YXIgaGVhZGVyID0ge307XG4gICAgdmFyIGNvdW50cnlJZCA9IGNvbW1vbi5jb21tYW5EYXRhLnVzZXJJbmZvLnJlZ2lzdGVyQ291bnRyeUlkO1xuICAgIGlmIChjb3VudHJ5SWQgPiAwKSB7XG4gICAgICAgIGhlYWRlcltcImNsaWVudENvdW50cnlJZFwiXSA9IGNvdW50cnlJZDtcbiAgICB9XG4gICAgYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0V2l0aENhY2hlKCd2MS9wcm9jbGFtYXRpb24vYXBwL2hvbWUtcGFnZS9hbm5vdW5jZW1lbnQnLCBjYWxsYmFjayA9IG5vdGljZURhdGFDYWxsYmFjaywge30gLCAwLCAwLCBoZWFkZXIsIFtdKTtcbiAgICBhd2FpdCBjb21tb24uc2V0TW9kdWxlU3RhdHVzKFwiYmFubmVyXCIsIDEpO1xufVxuXG5mdW5jdGlvbiBub3RpY2VEYXRhQ2FsbGJhY2sobm90aWNlRGF0YSwgaXNDYWNoZSkge1xuICAgIGlmKGlzQ2FjaGUgJiYgbm90aWNlRGF0YUxpc3QubGVuZ3RoID4gMCl7XG4gICAgICAgIC8v5pWw5o2u5pi+56S65Ye65p2l5LmL5ZCOIOe8k+WtmOWbnuadpeS4jeeUqOWIt+aWsFxuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIGlmIChub3RpY2VEYXRhICYmIG5vdGljZURhdGEgIT0gXCJcIikge1xuICAgICAgICBjb25zb2xlLmxvZyhcInJlcXVlc3ROb3RpY2VMaXN0IFwiICsgSlNPTi5zdHJpbmdpZnkobm90aWNlRGF0YSkpO1xuICAgICAgICB2YXIgdG9wID0gbm90aWNlRGF0YS50b3A7XG4gICAgICAgIHZhciB0b3BMZW5ndGggPSB0b3AgIT0gbnVsbCA/IHRvcC5sZW5ndGggOiAwO1xuICAgICAgICB2YXIgbm9ybWFsID0gbm90aWNlRGF0YS5ub3JtYWw7XG4gICAgICAgIHZhciBkYXRhTGlzdCA9IHRvcC5jb25jYXQobm9ybWFsKTtcbiAgICAgICAgIGNvbnNvbGUubG9nKFwiZGF0YUxpc3QgXCIgKyBKU09OLnN0cmluZ2lmeShkYXRhTGlzdCkpO1xuXG4gICAgICAgIGlmIChkYXRhTGlzdCAhPSBudWxsKSB7XG4gICAgICAgICAgICBmb3IgKHZhciBpID0gMDsgaSA8IGRhdGFMaXN0Lmxlbmd0aDsgaSsrKSB7XG4gICAgICAgICAgICAgICAgdmFyIG9iaiA9IGRhdGFMaXN0W2ldO1xuICAgICAgICAgICAgICAgIG9ialtcIm9yZ1RhZ1wiXSA9IG9ialtcInRhZ1wiXTtcbiAgICAgICAgICAgICAgICBvYmpbXCJpc1RvcFwiXSA9IGkgPCB0b3BMZW5ndGggPyAxOjA7XG4gICAgICAgICAgICAgICAgLy8vTmV3X0NvaW4g5paw5biBIEFubm91bmNlbWVudCDlhazlkYogUHJvbW90aW9ucyDmtLvliqhcbiAgICAgICAgICAgICAgICBpZiAob2JqW1widGFnXCJdID09IFwiUHJvbW90aW9uc1wiKSB7XG4gICAgICAgICAgICAgICAgICAgIG9ialtcInRhZ1wiXSA9ICRpMThuLm5fbm90aWNlX2V2ZW50O1xuICAgICAgICAgICAgICAgICAgICBvYmpbXCJjb2xvclwiXSA9IFwiQGNvbG9yL0tCYXNlUmlza1RleHRDb2xvck1pZFwiO1xuICAgICAgICAgICAgICAgIH0gZWxzZSBpZiAob2JqW1widGFnXCJdID09IFwiQW5ub3VuY2VtZW50XCIpIHtcbiAgICAgICAgICAgICAgICAgICAgb2JqW1widGFnXCJdID0gJGkxOG4ubl9ub3RpY2U7XG4gICAgICAgICAgICAgICAgICAgIG9ialtcImNvbG9yXCJdID0gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiO1xuICAgICAgICAgICAgICAgIH0gZWxzZSBpZiAob2JqW1widGFnXCJdID09IFwiTmV3X0NvaW5cIikge1xuICAgICAgICAgICAgICAgICAgICBvYmpbXCJ0YWdcIl0gPSAkaTE4bi5uX25vdGljZV9uZXdfY29pbjtcbiAgICAgICAgICAgICAgICAgICAgb2JqW1wiY29sb3JcIl0gPSBcIkBjb2xvci9LQmFzZVJpc2tUZXh0Q29sb3JMb3dcIjtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgb2JqW1widHlwZVwiXT1cIjFcIjtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIG1vZHVsZURhdGEubm90aWNlTGlzdCA9IGRhdGFMaXN0O1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5ub3RpY2VWaXNpYmlsaXR5ID0gZGF0YUxpc3QubGVuZ3RoID4gMCA/IFwidmlzaWJsZVwiIDogXCJnb25lXCI7XG4gICAgICAgICAgICBub3RpY2VEYXRhTGlzdCA9IGRhdGFMaXN0O1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5ub3RpY2VQbGFjZWhvbGVyVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgICAgICB9ICBlbHNlIHtcbiAgICAgICAgICAgIG1vZHVsZURhdGEubm90aWNlUGxhY2Vob2xlclZpc2liaWxpdHkgPSBcInZpc2libGVcIjtcbiAgICAgICAgICAgIG1vZHVsZURhdGEubm90aWNlVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgICAgICB9XG4gICAgfSBlbHNlIHtcbiAgICAgICAgbW9kdWxlRGF0YS5ub3RpY2VQbGFjZWhvbGVyVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuICAgICAgICBtb2R1bGVEYXRhLm5vdGljZVZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICB9XG59XG5cbi8v5Yik5pat5piv5LiN5piv5pyJ5pWI5bm/5ZGKXG5mdW5jdGlvbiBpc0VmZmVjdGl2ZUFkdmVydGlzaW5nKGxpc3QpIHtcbiAgICB2YXIgcmVzdWx0ID0gbmV3IEFycmF5KCk7XG4gICAgdmFyIGludGVydmFsID0gbmV3IERhdGUoKS5nZXRUaW1lKCkgKyBjb21tb24uY29tbWFuRGF0YS5zZXJ2aWNlVGltZUludGVydmFsO1xuICAgIGZvciAodmFyIGkgPSAwOyBpIDwgbGlzdC5sZW5ndGg7IGkrKykge1xuICAgICAgICB2YXIgaXNFZmZlY3RpdmUgPSB0cnVlO1xuICAgICAgICB2YXIgb2JqID0gbGlzdFtpXTtcbiAgICAgICAgdmFyIGN1cnJlbnRJbWFnZVVSTCA9IG51bGw7XG4gICAgICAgIGlmIChjb21tb24uY29tbWFuRGF0YS5jb2xvck1vZGUgPT0gMCAmJiBvYmouaW1nICE9IG51bGwpIHtcbiAgICAgICAgICAgIGN1cnJlbnRJbWFnZVVSTCA9IG9iai5pbWc7XG4gICAgICAgIH0gXG4gICAgICAgIGVsc2UgaWYgKGNvbW1vbi5jb21tYW5EYXRhLmNvbG9yTW9kZSA9PSAxICYmIG9iai5uaWdodEltYWdlVXJsICE9IG51bGwpIHtcbiAgICAgICAgICAgIGN1cnJlbnRJbWFnZVVSTCA9IG9iai5uaWdodEltYWdlVXJsO1xuICAgICAgICB9XG4gICAgICAgIG9iai5jdXJyZW50SW1hZ2VVUkwgPSBjdXJyZW50SW1hZ2VVUkw7XG4gICAgICAgIGlmIChjdXJyZW50SW1hZ2VVUkwgPT0gbnVsbCB8fCBjdXJyZW50SW1hZ2VVUkwubGVuZ3RoID09IDApIHtcbiAgICAgICAgICAgIGlzRWZmZWN0aXZlID0gZmFsc2U7XG4gICAgICAgIH1cblxuICAgICAgICBpZiAob2JqLmJlZ2luVGltZSA9PSBudWxsIHx8IFN0cmluZyhvYmouYmVnaW5UaW1lKS5sZW5ndGggPCAxM+OAgHx8IG9iai5lbmRUaW1lID09IG51bGwgfHwgU3RyaW5nKG9iai5lbmRUaW1lKS5sZW5ndGggPCAxMykge1xuICAgICAgICAgICAgaXNFZmZlY3RpdmUgPSB0cnVlO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgaWYgKGludGVydmFsID49IG9iai5lbmRUaW1lIHx8IGludGVydmFsIDwgb2JqLmJlZ2luVGltZSkge1xuICAgICAgICAgICAgICAgIGlzRWZmZWN0aXZlID0gZmFsc2U7XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cblxuICAgICAgICB2YXIgc3VwcG9ydCA9IGZhbHNlO1xuICAgICAgICBpZiAoY29tbW9uLmNvbW1hbkRhdGEuT1MgPT0gMCkge1xuICAgICAgICAgICAgLy8gaW9zXG4gICAgICAgICAgICBzdXBwb3J0ID0gKG9iai5hcHBJb3NUcmFkZVN1cHBvcnQgPT0gMSA/IHRydWUgOiBmYWxzZSk7ICBcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIC8vIGFuZHJvaWRcbiAgICAgICAgICAgIHN1cHBvcnQgPSAob2JqLmFwcEFuZHJvaWRTdXBwb3J0ID09IDEgPyB0cnVlIDogZmFsc2UpOyAgXG4gICAgICAgIH1cbiAgICAgICAgaWYgKG9iai5pc1Nob3cgPT0gMCAmJiBpc0VmZmVjdGl2ZSAmJiAob2JqLmlzTmVlZExvZ2luICE9IGNvbW1vbi5jb21tYW5EYXRhLmlzTG9naW4pICYmIHN1cHBvcnQpIHtcbiAgICAgICAgICAgIHJlc3VsdC5wdXNoKG9iaik7XG4gICAgICAgIH1cbiAgICB9XG4gICAgcmV0dXJuIHJlc3VsdDtcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGxvZ2luU3RhdGVDaGFuZ2UoKSB7XG4gICAgaWYgKG1vZHVsZURpZFN0YXJ0ID09IGZhbHNlKSB7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgbW9kdWxlRGF0YS5iYW5uZXJQbGFjZWhvbGVyVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuICAgIG1vZHVsZURhdGEuYmFubmVyVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgIG1vZHVsZURhdGEuYmFubmVyVGV4dFZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICBtb2R1bGVEYXRhLmJhbm5lckxpc3QgPSBudWxsO1xufVxuXG5tb2R1bGVFdmVudC5zZWxlY3RlZEJhbm5lckluZGV4ID0gYXN5bmMgZnVuY3Rpb24gKGluZGV4KSB7XG4gICAgJGRhdGEuYmFubmVyLmJhbm5lckN1cnJlbnRJbmRleCA9IFN0cmluZyhpbmRleCArIDEpO1xuICAgIGF3YWl0IGJhbm5lckV4cG9zdXJlKCk7XG4gICAgY29uc29sZS5sb2coXCJzZWxlY3RlZEJhbm5lckluZGV4XCIgKyBpbmRleCk7XG59XG5cbm1vZHVsZUV2ZW50LnNlbGVjdGVkTm90aWNlSW5kZXggPSBhc3luYyBmdW5jdGlvbiAoaW5kZXgpIHtcbiAgICAkZGF0YS5iYW5uZXIubm90aWNlQ3VycmVudEluZGV4ID0gU3RyaW5nKGluZGV4ICsgMSk7XG4gICAgYXdhaXQgbm90aWNlRXhwb3N1cmUoKTtcbiAgICBjb25zb2xlLmxvZyhcInNlbGVjdGVkTm90aWNlSW5kZXggXCIgKyBpbmRleCk7XG59XG5cbm1vZHVsZUV2ZW50LmJhbm5lckNsaWNrQmFubmVyID0gYXN5bmMgZnVuY3Rpb24gKCkge1xuICAgIHZhciBpbmRleCA9IHBhcnNlSW50KG1vZHVsZURhdGEuYmFubmVyQ3VycmVudEluZGV4KSAtIDE7XG4gICAgaWYgKGluZGV4ID49IGJhbm5lckRhdGFMaXN0Lmxlbmd0aCkge1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIHZhciBvYmogPSBiYW5uZXJEYXRhTGlzdFtpbmRleF07XG5cbiAgICB0cnkge1xuICAgICAgICBhd2FpdCAkbmF0aXZlQVBJLmhvbWVCcmlkZ2Uoe1xuICAgICAgICAgICAgYWN0aW9uOiBcImJhbm5lckNsaWNrQmFubmVyXCIsXG4gICAgICAgICAgICBkYXRhOkpTT04uc3RyaW5naWZ5KG9iailcbiAgICAgICAgfSk7XG5cbiAgICAgICAgYXdhaXQgY29tbW9uLmFuYWx5dGljcyhcImFwcENsaWNrX2hvbWVcIiwge1xuICAgICAgICAgICAgICAgIG1vZHVsZV9uYW1lOiBcImJhbm5lclwiLFxuICAgICAgICAgICAgICAgIG1vZHVsZV9wb3NpdGlvbjogU3RyaW5nKGluZGV4ICsgMSksXG4gICAgICAgICAgICAgICAgbWF0ZXJpYWxfbmFtZTogb2JqW1wiYWROYW1lXCJdLFxuICAgICAgICAgICAgICAgIGVsZW1lbnRJZDogU3RyaW5nKG9ialtcImlkXCJdKSxcbiAgICAgICAgICAgIH0pO1xuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5sb2coYGJhbm5lckNsaWNrTW9yZSBlcnJvciwgZXJyb3I9JHtlfWApO1xuICAgIH1cbn1cblxubW9kdWxlRXZlbnQuYmFubmVyQ2xpY2tOb3RpY2UgPSBhc3luYyBmdW5jdGlvbiAoKSB7XG4gICAgdmFyIGluZGV4ID0gcGFyc2VJbnQobW9kdWxlRGF0YS5ub3RpY2VDdXJyZW50SW5kZXgpIC0gMTtcblxuICAgIGlmIChpbmRleCA+PSBub3RpY2VEYXRhTGlzdC5sZW5ndGgpIHtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICB2YXIgb2JqID0gbm90aWNlRGF0YUxpc3RbaW5kZXhdO1xuICAgIGlmIChvYmouYWJzb2x1dGVfdXJsICE9IG51bGwpIHtcbiAgICAgICAgY29uc29sZS5sb2coJ2NsaWNrbm9pY2UnICsgb2JqLmFic29sdXRlX3VybCk7XG4gICAgICAgIGF3YWl0IGNvbW1vbi5vcGVuVVJMKGVuY29kZVVSSShvYmouYWJzb2x1dGVfdXJsKSk7XG4gICAgfVxuICAgIGF3YWl0IGNvbW1vbi5hbmFseXRpY3MoXCJhcHBDbGlja19ob21lXCIsIHtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBtb2R1bGVfbmFtZTogXCJub3RpY2VcIixcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBidXR0b25fbmFtZTogXCJub3RpY2VcIixcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBtb2R1bGVfcG9zaXRpb246IFN0cmluZyhpbmRleCArIDEpLFxuICAgICAgICAgICAgICAgICAgICAgICAgICAgIHR5cGU6IG9ialtcIm9yZ1RhZ1wiXSxcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBtYXRlcmlhbF9uYW1lOiBvYmpbXCJhZE5hbWVcIl0sXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgbm90aWNlX2lzX3RvcDogb2JqW1wiaXNUb3BcIl0sXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgZWxlbWVudElkOiBvYmpbXCJwcm9jbGFfaWRcIl0sXG4gICAgICAgICAgICAgICAgICAgICAgICB9KTtcblxufVxuXG5tb2R1bGVFdmVudC5iYW5uZXJDbGlja01vcmUgPSBhc3luYyBmdW5jdGlvbiAoKSB7XG4gICAgLy8zNjAwMDAwMzk0ODFcbiAgICB0cnkge1xuICAgICAgICBjb25zb2xlLmxvZyhcImNsaWNrIG1vcmVcIik7XG4gICAgICAgIGF3YWl0ICRuYXRpdmVBUEkuaG9tZUJyaWRnZSh7XG4gICAgICAgICAgICBhY3Rpb246IFwiYmFubmVyQ2xpY2tNb3JlXCJcbiAgICAgICAgfSk7XG4gICAgICAgIGF3YWl0IGNvbW1vbi5hbmFseXRpY3MoXCJhcHBDbGlja19ob21lXCIsIHtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBtb2R1bGVfbmFtZTogXCJub3RpY2VcIixcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICBidXR0b25fbmFtZTogXCJtb3JlXCIsXG4gICAgICAgICAgICAgICAgICAgICAgICB9KTtcbiAgICAgICAgfSBjYXRjaCAoZSkge1xuICAgICAgICAgICAgY29uc29sZS5sb2coYGJhbm5lckNsaWNrTW9yZSBlcnJvciwgZXJyb3I9JHtlfWApO1xuICAgICAgICB9XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBzdGFydFNjcm9sbCgpIHtcbiAgICBpZiAobW9kdWxlRGlkU3RhcnQgPT0gZmFsc2UpIHtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICBtb2R1bGVEYXRhLmF1dG9TY3JvbGwgPSBcInRydWVcIjtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGVuZFNjcm9sbCgpIHtcbiAgICBpZiAobW9kdWxlRGlkU3RhcnQgPT0gZmFsc2UpIHtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICBtb2R1bGVEYXRhLmF1dG9TY3JvbGwgPSBcImZhbHNlXCI7XG59XG5cbiIsImltcG9ydCAqIGFzIGNvbW1vbiBmcm9tICcuL2NvbW1vbidcblxuLy/liJ3lp4vljJZcbmFzeW5jIGZ1bmN0aW9uIHN0YXJ0KCkge1xuICAgIGNvbnNvbGUubG9nKCd0bCAtLSBlYXJuIDExMScpO1xuICAgIGF3YWl0IHJlcXVlc3RFYXJuQXJlYUhvbWVwYWdlckRhdGEoKTtcbn1cblxuLy/liJ3lp4vljJbmlbDmja5cbmZ1bmN0aW9uIGRlZmF1bHREYXRhKCkge1xuICAgIHJldHVybiB7XG4gICAgICAgIHZpc2liaWxpdHk6IFwiZ29uZVwiLFxuICAgICAgICBzaG93OiBcIlwiLFxuICAgICAgICB0aXRsZTogXCJcIixcbiAgICAgICAgbW9yZToge30sXG4gICAgICAgIGVhcm5MaXN0OiBbXSxcbiAgICAgICAgb2Zmc2V0WDogXCJcIlxuICAgIH07XG59XG5cbnZhciBpc0xvYWQgPSBmYWxzZTtcbnZhciBpc05ld1VzZXIgPSBmYWxzZTtcblxuY29uc3Qge21vZHVsZURhdGEsIG1vZHVsZUV2ZW50fSA9IGNvbW1vbi5tb2R1bGVEZWZpbmUoXCJlYXJuXCIsIHN0YXJ0LCBkZWZhdWx0RGF0YSk7XG5cbmFzeW5jIGZ1bmN0aW9uIG1vZHVsZUFwcGVhcigpIHtcbiAgICBhd2FpdCBhbmFseXRpY3NBcHBlYXIoKTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gbW9kdWxlRGlzYXBwZWFyKCkge1xuXG59XG5tb2R1bGVFdmVudC5tb2R1bGVBcHBlYXIgPSBtb2R1bGVBcHBlYXI7XG5tb2R1bGVFdmVudC5tb2R1bGVEaXNhcHBlYXIgPSBtb2R1bGVEaXNhcHBlYXI7XG5cbnZhciBlYXJuTGlzdDtcblxudmFyIG5lZWRBbmFseXRpY3NXaGVuUmVxdWVzdFN1Y2Nlc3MgPSBmYWxzZTtcbmFzeW5jIGZ1bmN0aW9uIGFuYWx5dGljc0FwcGVhcigpIHtcbiAgICBpZiAobW9kdWxlRGF0YS52aXNpYmlsaXR5ID09IFwiZ29uZVwiICkge1xuICAgICAgICBuZWVkQW5hbHl0aWNzV2hlblJlcXVlc3RTdWNjZXNzID0gdHJ1ZTtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICBuZWVkQW5hbHl0aWNzV2hlblJlcXVlc3RTdWNjZXNzID0gZmFsc2U7XG4gICAgdmFyIHR5cGVMaXN0ID0gW107XG4gICAgdmFyIGlkTGlzdCA9IFtdO1xuICAgIGVhcm5MaXN0LmZvckVhY2goZWxlbWVudCA9PiB7XG4gICAgICAgIGlmIChlbGVtZW50LnZpc2liaWxpdHkgPT0gJ3Zpc2libGUnKSB7XG4gICAgICAgICAgICB0eXBlTGlzdC5wdXNoKGdldFR5cGVBbmFseXRpY3NTdHJpbmcoZWxlbWVudC5zaGVsZlR5cGUpKTtcbiAgICAgICAgICAgIHZhciBpZCA9IGVsZW1lbnQucHJvamVjdElkID09IG51bGwgPyBcIm51bGxcIiA6IFN0cmluZyhlbGVtZW50LnByb2plY3RJZCk7XG4gICAgICAgICAgICBpZExpc3QucHVzaChpZClcbiAgICAgICAgfVxuICAgIH0pO1xuXG4gICAgY29uc3QgdHlwZVN0ciA9IHR5cGVMaXN0LmpvaW4oXCIsXCIpO1xuICAgIGNvbnN0IGlkU3RyID0gaWRMaXN0LmpvaW4oXCIsXCIpO1xuICAgIGF3YWl0IGNvbW1vbi5hbmFseXRpY3MoXCJhcHBFeHBvc3VyZV9ob21lXCIsIHtcbiAgICAgICAgbW9kdWxlX25hbWU6IFwiZWFyblwiLFxuICAgICAgICB0eXBlOiB0eXBlU3RyLFxuICAgICAgICBlbGVtZW50SWQ6IGlkU3RyXG4gICAgfSk7XG59XG5cbmZ1bmN0aW9uIGdldFR5cGVBbmFseXRpY3NTdHJpbmcodHlwZSkge1xuICAgIHZhciB0eXBlU3RyID0gXCJQcmltZUVhcm5cIjtcbiAgICBpZiAodHlwZSA9PSAxKSB7XG4gICAgICAgIHR5cGVTdHIgPSBcIlByaW1lRWFyblwiO1xuICAgIH0gZWxzZSBpZiAodHlwZSA9PSAyKSB7XG4gICAgICAgIHR5cGVTdHIgPSBcIkZpeGVkXCI7XG4gICAgfSBlbHNlIGlmICh0eXBlID09IDMpIHtcbiAgICAgICAgdHlwZVN0ciA9IFwiTmV3TGlzdFwiO1xuICAgIH0gZWxzZSBpZiAodHlwZSA9PSA0KSB7XG4gICAgICAgIHR5cGVTdHIgPSBcIkZsZXhpYmxlXCI7XG4gICAgfVxuICAgIHJldHVybiB0eXBlU3RyO1xufVxuXG5tb2R1bGVFdmVudC5lbmRTY3JvbGxYQWN0aW9uID0gYXN5bmMgZnVuY3Rpb24ocGFyYW1zKSB7XG4gICAgY29uc3QgeCA9IHBhcnNlSW50KHBhcmFtcyk7XG4gICAgYXdhaXQgY29tbW9uLnNhdmUoXCJlYXJuXCIsXCJvZmZzZXRcIiwgeCk7XG59XG5cbm1vZHVsZUV2ZW50Lm1vcmVUYXBBY3Rpb24gPSBhc3luYyBmdW5jdGlvbiAoKSB7XG4gICAgbGV0IGp1bXBVcmwgPSBlbmNvZGVVUkkobW9kdWxlRGF0YS5tb3JlLmp1bXBVcmwpO1xuICAgIGxldCB0aXRsZSA9IG1vZHVsZURhdGEubW9yZS50aXRsZTtcbiAgICBsZXQgcGFyYW0gPSB7XG4gICAgICAgIHRpdGxlOiB0aXRsZSxcbiAgICAgICAgbmVlZExvZ2luOiBmYWxzZVxuICAgIH07XG4gICAgYXdhaXQgY29tbW9uLm9wZW5VUkwoanVtcFVybCwgcGFyYW0pO1xuICAgIGF3YWl0IGNvbW1vbi5hbmFseXRpY3MoXCJhcHBDbGlja19ob21lXCIsIHtcbiAgICAgICAgbW9kdWxlX25hbWU6IFwiZWFyblwiLFxuICAgICAgICB0eXBlOiBcIm1vcmVcIlxuICAgIH0pO1xufVxuXG5tb2R1bGVFdmVudC5lYXJuVGFwQWN0aW9uID0gYXN5bmMgZnVuY3Rpb24gKGluZGV4KSB7XG4gICAgbGV0IG1vZGVsID0gbW9kdWxlRGF0YS5lYXJuTGlzdFtwYXJzZUludChpbmRleCldO1xuICAgIGxldCBqdW1wVXJsID0gZW5jb2RlVVJJKG1vZGVsLnVybC5qdW1wVXJsKTtcbiAgICBsZXQgdGl0bGUgPSBtb2RlbC51cmwudGl0bGU7XG4gICAgbGV0IHBhcmFtID0ge1xuICAgICAgICB0aXRsZTogdGl0bGUsXG4gICAgICAgIG5lZWRMb2dpbjogZmFsc2VcbiAgICB9O1xuICAgIGF3YWl0IGNvbW1vbi5vcGVuVVJMKGp1bXBVcmwsIHBhcmFtKTtcblxuICAgIGF3YWl0IGNvbW1vbi5hbmFseXRpY3MoXCJhcHBDbGlja19ob21lXCIsIHtcbiAgICAgICAgbW9kdWxlX25hbWU6IFwiZWFyblwiLFxuICAgICAgICBtb2R1bGVfcG9zaXRpb246IFN0cmluZyhpbmRleCArIDEpLFxuICAgICAgICB0eXBlOiBwYXJzZUludChtb2RlbC5zaGVsZlR5cGUpLFxuICAgICAgICBuYW1lOiBtb2RlbC5jb2luTmFtZSxcbiAgICAgICAgZWxlbWVudElkOiBTdHJpbmcobW9kZWwucHJvamVjdElkKVxuICAgIH0pO1xufVxuXG5hc3luYyBmdW5jdGlvbiBlYXJuRGF0YUNhbGxiYWNrKGRhdGEsIGlzQ2FjaGUpIHtcbiAgICBhd2FpdCBjb21tb24uc2V0TW9kdWxlU3RhdHVzKCdlYXJuJywgMSk7XG4gICAgaWYgKG1vZHVsZURhdGEuZWFybkxpc3QubGVuZ3RoID4gMCAmJiBpc0NhY2hlID09PSB0cnVlKSB7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG5cbiAgICBpc05ld1VzZXIgPSBkYXRhLm5ld1VzZXJcbiAgICBcbiAgICBtb2R1bGVEYXRhLmlzTmV3VXNlciA9IGRhdGEubmV3VXNlciA/IFwidmlzaWJsZVwiIDogXCJnb25lXCI7XG4gICAgbW9kdWxlRGF0YS5pc09sZFVzZXIgPSBkYXRhLm5ld1VzZXIgPyBcImdvbmVcIiA6IFwidmlzaWJsZVwiO1xuICAgIG1vZHVsZURhdGEudGl0bGUgPSBkYXRhLnRpdGxlO1xuICAgIG1vZHVsZURhdGEubW9yZSA9IGRhdGEubW9yZTtcbiAgICB2YXIgYXJyYXkgPSBbXTtcbiAgICB2YXIgaXRlbXNTaG93ID0gZmFsc2U7XG4gICAgZm9yICh2YXIgaSA9IDA7IGkgPCBkYXRhLmNvbnRlbnRzLmxlbmd0aDsgaSsrKSB7XG4gICAgICAgIGxldCBvYmogPSBkYXRhLmNvbnRlbnRzW2ldO1xuICAgICAgICB2YXIgZWFybiA9IGhhbmRsZUVhcm5PYmplY3Qob2JqKTtcbiAgICAgICAgaWYgKGVhcm4udmlzaWJpbGl0eSA9PT0gJ3Zpc2libGUnKSB7XG4gICAgICAgICAgICBpdGVtc1Nob3cgPSB0cnVlO1xuICAgICAgICB9XG4gICAgICAgIGVhcm4uaW5kZXggPSBpO1xuICAgICAgICBhcnJheS5wdXNoKGVhcm4pO1xuICAgIH1cbiAgICBtb2R1bGVEYXRhLmVhcm5MaXN0ID0gYXJyYXk7XG4gICAgZWFybkxpc3QgPSBhcnJheTtcbiAgICBcbiAgICBtb2R1bGVEYXRhLnZpc2liaWxpdHkgPSBjb21tb24uZ2V0VmlzaWJpbGl0eVN0YXR1cygoZGF0YS5zaG93ID09PSAxICYmIGl0ZW1zU2hvdyA9PT0gdHJ1ZSkpOyAgICBcbn1cblxuYXN5bmMgZnVuY3Rpb24gcmVxdWVzdEVhcm5BcmVhSG9tZXBhZ2VyRGF0YSgpIHtcbiAgICAvL3N0eWxlIDE65aSc6Ze0IDA65pel6Ze0IOm7mOiupOaYrzBcbiAgICB2YXIgcGFyYW1zID0ge3N0eWxlOiAwfTtcbiAgICBpZiAoY29tbW9uLmNvbW1hbkRhdGEuY29sb3JNb2RlICE9IG51bGwgJiYgY29tbW9uLmNvbW1hbkRhdGEuY29sb3JNb2RlICE9IHVuZGVmaW5lZCkge1xuICAgICAgICBjb25zb2xlLmxvZyhg6K+35rGCIGVhcm4g5pWw5o2u77yM5b2T5YmN5qih5byP5pivPT0ke2NvbW1vbi5jb21tYW5EYXRhLmNvbG9yTW9kZX1gKTtcbiAgICAgICAgcGFyYW1zID0ge3N0eWxlOiBjb21tb24uY29tbWFuRGF0YS5jb2xvck1vZGV9O1xuICAgIH1cbiAgICBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3RXaXRoQ2FjaGUoJ3YxL3NhdmluZy1tYXJrZXQvbWluaW5nL2FwcC9pbmRleC9lYXJuQXJlYUhvbWVwYWdlVmlldycsIGNhbGxiYWNrID0gZWFybkRhdGFDYWxsYmFjaywgcGFyYW1zKTtcbiAgICBpZiAobW9kdWxlRGF0YS52aXNpYmlsaXR5ID09PSAndmlzaWJsZScpIHtcbiAgICAgICAgYXdhaXQgY29tbW9uLnNldE1vZHVsZVN0YXR1cygnZWFybicsIDEpO1xuICAgICAgICBpZiAobmVlZEFuYWx5dGljc1doZW5SZXF1ZXN0U3VjY2VzcyA9PSB0cnVlKSB7XG4gICAgICAgICAgICBhd2FpdCBhbmFseXRpY3NBcHBlYXIoKTtcbiAgICAgICAgfVxuICAgICAgICBhd2FpdCBmaW5pc2hMb2FkKCk7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgYXdhaXQgY29tbW9uLnNldE1vZHVsZVN0YXR1cygnZWFybicsIDIpO1xuICAgIH1cblxufVxuXG5hc3luYyBmdW5jdGlvbiBmaW5pc2hMb2FkKCkge1xuICAgIGlmIChpc05ld1VzZXIgPT0gdHJ1ZSkge1xuICAgICAgICBhd2FpdCBjb21tb24uY2xlYXIoXCJlYXJuXCIsXCJvZmZzZXRcIik7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgaWYgKGlzTG9hZCA9PSBmYWxzZSkge1xuICAgICAgICAgICAgYXdhaXQgY29tbW9uLmNsZWFyKFwiZWFyblwiLFwib2Zmc2V0XCIpO1xuICAgICAgICAgICAgaXNMb2FkID0gdHJ1ZTtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGNvbnN0IGxhc3RPZmZzZXRYID0gYXdhaXQgY29tbW9uLnJlYWQoXCJlYXJuXCIsXCJvZmZzZXRcIik7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLm9mZnNldFggPSBsYXN0T2Zmc2V0WDtcbiAgICAgICAgICAgIGlzTG9hZCA9IHRydWU7XG4gICAgICAgIH1cbiAgICB9XG59XG5cbmZ1bmN0aW9uIGhhbmRsZUVhcm5PYmplY3Qob2JqKSB7XG4gICAgdmFyIGVhcm4gPSBvYmo7XG4gICAgZWFybi52aXNpYmlsaXR5ID0gY29tbW9uLmdldFZpc2liaWxpdHlTdGF0dXMob2JqLmlzU2hvdyA9PT0gMSk7XG4gICAgZWFybi5jb2luTmFtZSA9IG9iai5jdXJyZW5jeTtcbiAgICBlYXJuLmNvaW5JY29uID0gb2JqLmljb25Vcmw7XG4gICAgZWFybi5yYXRlU3RyaW5nID0gb2JqLnJhdGUudG9TdHJpbmcoKTtcbiAgICBlYXJuLnJhdGVUaXRsZSA9IFwiQVBZXCI7XG5cbiAgICBlYXJuLnRhZ1Nob3cgPSBlYXJuLnRhZyAhPSB1bmRlZmluZWQgJiYgZWFybi50YWcgIT0gbnVsbCA/IFwidmlzaWJsZVwiIDogXCJnb25lXCI7Ly/moIfnrb7mmK/lkKbmmL7npLpcblx0aWYgKG9iai50YWdWYWx1ZSA9PSA5KSB7XG5cdFx0ZWFybi50YWdCZ0NvbG9yID0gXCIjMUEwMTczRTVcIjtcblx0XHRlYXJuLnRhZ1RleHRDb2xvciA9IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIjtcblx0fSBlbHNlIHtcblx0XHRlYXJuLnRhZ0JnQ29sb3IgPSBcIiMxQUZFODczMVwiO1xuXHRcdGVhcm4udGFnVGV4dENvbG9yID0gXCJAY29sb3Iva1NlY3VyaXR5TWlkZGxlTGV2ZWxDb2xvclwiO1xuXHR9XG4gICAgZWFybi5vcmlnaW5hbFJhdGVTaG93ID0gXCJnb25lXCI7XG4gICAgaWYgKGVhcm4ub3JpZ2luQXB5ICE9IHVuZGVmaW5lZCAmJiBlYXJuLm9yaWdpbkFweSAhPSBudWxsKSB7XG4gICAgICAgIGVhcm4ub3JpZ2luYWxSYXRlU3RyaW5nID0gZWFybi5vcmlnaW5BcHk7XG4gICAgICAgIGVhcm4ub3JpZ2luYWxSYXRlU2hvdyA9IFwidmlzaWJsZVwiO1xuICAgIH1cbiAgICBcbiAgICBpZiAob2JqLnNoZWxmVHlwZSA9PT0gNCkge1xuICAgICAgICAvL+S9meW4geWunVxuICAgICAgICBlYXJuLmVhcm5UeXBlID0gXCJzYXZpbmdcIlxuICAgIH0gZWxzZSB7XG4gICAgICAgIGVhcm4uZWFyblR5cGUgPSBcIm5vcm1hbFwiXG4gICAgfVxuXG4gICAgcmV0dXJuIGVhcm5cbn1cbiIsImltcG9ydCAqIGFzIGNvbW1vbiBmcm9tICcuL2NvbW1vbidcblxuLy/liJ3lp4vljJZcbmFzeW5jIGZ1bmN0aW9uIHN0YXJ0KCkge1xuICAgIGF3YWl0IHJlcXVlc3RPcGVyYXRpb25EYXRhKCk7XG59XG5cbi8v5Yid5aeL5YyW5pWw5o2uXG5mdW5jdGlvbiBkZWZhdWx0RGF0YSgpIHtcbiAgICByZXR1cm4ge1xuICAgICAgICAgICAgZmlyc3RGdW5jdGlvbkxpc3Q6W10sXG4gICAgICAgICAgICBzZWNvbmRGdW5jdGlvbkxpc3Q6W10sXG4gICAgICAgICAgICBmdW5jdGlvblZpc2liaWxpdHk6XCJnb25lXCIsXG4gICAgICAgICAgICBmaXJzdEZ1bmN0aW9uVmlzaWJpbGl0eTpcImdvbmVcIixcbiAgICAgICAgICAgIHNlY29uZEZ1bmN0aW9uVmlzaWJpbGl0eSA6XCJnb25lXCJcbiAgICB9O1xufVxuXG5cblxuY29uc3Qge21vZHVsZURhdGEsIG1vZHVsZUV2ZW50fSA9IGNvbW1vbi5tb2R1bGVEZWZpbmUoXCJvcGVyYXRpb25cIiwgc3RhcnQsIGRlZmF1bHREYXRhKTtcblxudmFyIG9wZXJhdGlvbkV4cG9zdXJlTWFwID0gbmV3IE1hcCgpO1xuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gY2xlYXJPcGVyYXRpb25FeHBvc3VyZU1hcCgpIHtcbiAgICBvcGVyYXRpb25FeHBvc3VyZU1hcC5jbGVhcigpO1xufVxuXG5hc3luYyBmdW5jdGlvbiBtb2R1bGVBcHBlYXIoKSB7XG4gICAgaWYgKG9wZXJhdGlvbkRhdGFMaXN0Lmxlbmd0aCA+IDAgJiYgIW9wZXJhdGlvbkV4cG9zdXJlTWFwLmhhcyhcImJhbGxcIikpIHtcbiAgICAgICAgICAgIHZhciB0eXBlU3RyID0gXCJcIjtcbiAgICAgICAgICAgIHZhciBiYWRnZXNTdHIgPSBcIlwiO1xuICAgICAgICAgICAgZm9yIChsZXQgaW5kZXggaW4gb3BlcmF0aW9uRGF0YUxpc3QpIHtcbiAgICAgICAgICAgICAgICBsZXQgaXRlbSA9IG9wZXJhdGlvbkRhdGFMaXN0W2luZGV4XTtcbiAgICAgICAgICAgICAgICBpZihpdGVtLmlkID09IG9wZXJhdGlvbkludmFsaWRJZCkgYnJlYWs7XG4gICAgICAgICAgICAgICAgaWYoaW5kZXggIT0gMCl7XG4gICAgICAgICAgICAgICAgICAgIHR5cGVTdHIgPSB0eXBlU3RyLmNvbmNhdChcIixcIik7XG4gICAgICAgICAgICAgICAgICAgIGJhZGdlc1N0ciA9IGJhZGdlc1N0ci5jb25jYXQoXCIsXCIpO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICB0eXBlU3RyID0gdHlwZVN0ci5jb25jYXQoaXRlbS5qdW1wTW9kZSA9PSA5OTkgPyBcIm1vcmVcIjogaXRlbS5ncm91cENvZGUpO1xuICAgICAgICAgICAgICAgIGJhZGdlc1N0ciA9IGJhZGdlc1N0ci5jb25jYXQoaXRlbS5jb3JuZXJNYXJrQ29udGVudCAhPSBudWxsPyBTdHJpbmcoaXRlbS5jb3JuZXJNYXJrQ29udGVudC5jb3JuZXJNYXJrSWQpOlwiMFwiKTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGF3YWl0IGNvbW1vbi5hbmFseXRpY3MoXCJhcHBFeHBvc3VyZV9ob21lXCIsIHtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIG1vZHVsZV9uYW1lOiBcImJhbGxcIixcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIHR5cGU6IHR5cGVTdHIsXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICBzdXBlcnNjcmlwdDogYmFkZ2VzU3RyXG4gICAgICAgICAgICAgICAgICAgICAgICAgIH0pO1xuICAgICAgICAgICAgb3BlcmF0aW9uRXhwb3N1cmVNYXAuc2V0KFwiYmFsbFwiLHRydWUpO1xuICAgICAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIG1vZHVsZURpc2FwcGVhcigpIHtcblxufVxuXG5tb2R1bGVFdmVudC5tb2R1bGVBcHBlYXIgPSBtb2R1bGVBcHBlYXI7XG5tb2R1bGVFdmVudC5tb2R1bGVEaXNhcHBlYXIgPSBtb2R1bGVEaXNhcHBlYXI7XG5cbnZhciBvcGVyYXRpb25EYXRhTGlzdCA9IFtdO1xudmFyIG9wZXJhdGlvbkludmFsaWRJZCA9IC05NTI3O1xuXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0T3BlcmF0aW9uRGF0YSgpIHtcbiAgICB2YXIgdWlkID0gXCJcIjtcbiAgICBpZiAoY29tbW9uLmNvbW1hbkRhdGEuaXNMb2dpbiA9PSAxKSB7XG4gICAgICAgIHVpZCA9IGNvbW1vbi5jb21tYW5EYXRhLnVzZXJJbmZvLnVJZDtcbiAgICB9XG4gICAgdmFyIHBhcmFtcyA9IHsgdWlkOiB1aWQsIG1vZHVsZVNpemU6IDIwLCB2ZXJzaW9uOiBjb21tb24uY29tbWFuRGF0YS5hcHBWZXJzaW9uLCBwbGF0Zm9ybTogY29tbW9uLmNvbW1hbkRhdGEuT1MgPT0gMT8gMSA6IDIsIG5pZ2h0TW9kZTogY29tbW9uLmNvbW1hbkRhdGEuY29sb3JNb2RlLCB0czogbmV3IERhdGUoKS5nZXRUaW1lKCl9O1xuICAgIHZhciBoZWFkZXIgPSB7fTtcbiAgICB2YXIgY291bnRyeUlkID0gY29tbW9uLmNvbW1hbkRhdGEudXNlckluZm8ucmVnaXN0ZXJDb3VudHJ5SWQ7XG4gICAgaWYgKGNvdW50cnlJZCA+IDApIHtcbiAgICAgICAgaGVhZGVyW1wiY2xpZW50Q291bnRyeUlkXCJdID0gY291bnRyeUlkO1xuICAgIH1cbiAgICBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3RXaXRoQ2FjaGUoJ3AvYXBpL2FwcEZlYXR1cmVzL21vZHVsZS84JywgY2FsbGJhY2sgPSBvcGVyYXRpb25EYXRhQ2FsbGJhY2ssIHBhcmFtcyAsIDAsIDcsIGhlYWRlciwgW10pO1xuICAgIGlmIChvcGVyYXRpb25EYXRhTGlzdC5sZW5ndGggPiAwKSB7XG4gICAgICAgIGF3YWl0IGNvbW1vbi5zZXRNb2R1bGVTdGF0dXMoXCJvcGVyYXRpb25cIiwgMSk7XG4gICAgfVxuICAgIGVsc2Uge1xuICAgICAgICBhd2FpdCBjb21tb24uc2V0TW9kdWxlU3RhdHVzKFwib3BlcmF0aW9uXCIsIDIpO1xuICAgIH1cbn1cblxuYXN5bmMgZnVuY3Rpb24gb3BlcmF0aW9uRGF0YUNhbGxiYWNrKGZ1bmN0aW9uRGF0YSwgaXNDYWNoZSkge1xuICAgIGF3YWl0IGNvbW1vbi5zZXRNb2R1bGVTdGF0dXMoXCJvcGVyYXRpb25cIiwgMSk7XG4gICAgLy8gY29uc29sZS5sb2coYHJlcXVlc3RPcGVyYXRpb25EYXRhIOmHkeWImuS9jeaOpeWPoyBvcGVyYXRpb25EYXRhQ2FsbGJhY2sgaXNDYWNoZSA9ICR7aXNDYWNoZX0gb3BlcmF0aW9uRGF0YUxpc3QubGVuZ3RoID0gJHtvcGVyYXRpb25EYXRhTGlzdC5sZW5ndGh9IGZ1bmN0aW9uRGF0YToke0pTT04uc3RyaW5naWZ5KGZ1bmN0aW9uRGF0YSl9YCk7XG4gICAgaWYoaXNDYWNoZSAmJiBvcGVyYXRpb25EYXRhTGlzdC5sZW5ndGggPiAwKXtcbiAgICAgICAgLy/mlbDmja7mmL7npLrlh7rmnaXkuYvlkI4g57yT5a2Y5Zue5p2l5LiN55So5Yi35pawXG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgaWYgKGZ1bmN0aW9uRGF0YSAmJiBmdW5jdGlvbkRhdGEgIT0gXCJcIikge1xuICAgICAgICAvLyBjb25zb2xlLmxvZyhcInJlcXVlc3RPcGVyYXRpb25EYXRhIOmHkeWImuS9jeaOpeWPoyBlbmQgZnVuY3Rpb25EYXRhLmNvbnRlbnRMaXN0OlwiKyBKU09OLnN0cmluZ2lmeShmdW5jdGlvbkRhdGEuY29udGVudExpc3QpKTtcbiAgICAgICAgaWYoZnVuY3Rpb25EYXRhLmNvbnRlbnRMaXN0ICE9IG51bGwpe1xuICAgICAgICAgICAgdmFyIGNvbnRlbnRMaXN0ID0gZnVuY3Rpb25EYXRhLmNvbnRlbnRMaXN0O1xuICAgICAgICAgICAgaWYgKGNvbW1vbi5jb21tYW5EYXRhLmlzSW5SZXZpZXcgPT0gMSkge1xuICAgICAgICAgICAgICAgIGlmIChmdW5jdGlvbkRhdGEuY29udGVudExpc3QubGVuZ3RoID4gNCkge1xuICAgICAgICAgICAgICAgICAgICBjb250ZW50TGlzdCA9IGZ1bmN0aW9uRGF0YS5jb250ZW50TGlzdC5zbGljZSgwLDQpO1xuICAgICAgICAgICAgICAgICAgICBmdW5jdGlvbkRhdGEuY29udGVudExpc3QgPSBjb250ZW50TGlzdDtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICB2YXIgY29udGVudExpc3RMZW5ndGggPSBmdW5jdGlvbkRhdGEuY29udGVudExpc3QubGVuZ3RoO1xuICAgICAgICAgICAgLy8gY29uc29sZS5sb2coXCJyZXF1ZXN0T3BlcmF0aW9uRGF0YSBjb250ZW50TGlzdExlbmd0aDpcIitjb250ZW50TGlzdExlbmd0aCk7XG4gICAgICAgICAgICAkZGF0YS5vcGVyYXRpb24uZnVuY3Rpb25WaXNpYmlsaXR5ID0gY29udGVudExpc3RMZW5ndGggPiAwID8gXCJ2aXNpYmxlXCI6XCJnb25lXCI7XG4gICAgICAgICAgICAkZGF0YS5vcGVyYXRpb24uZmlyc3RGdW5jdGlvblZpc2liaWxpdHkgPSBjb250ZW50TGlzdExlbmd0aCA+IDAgPyBcInZpc2libGVcIjpcImdvbmVcIjtcbiAgICAgICAgICAgIC8v5pWw5o2u6ZW/5bqm5bGe5LqO5Yy66Ze0KDUsOCkg5aGr6KGl56m65L2NIOWOu+W5s+WIhuepuumXtFxuICAgICAgICAgICAgaWYgKGNvbnRlbnRMaXN0TGVuZ3RoID4gNSAmJiBjb250ZW50TGlzdExlbmd0aCA8IDgpIHtcbiAgICAgICAgICAgICAgICBmb3IgKHZhciBpID0gY29udGVudExpc3RMZW5ndGg7IGkgPCA4OyBpKyspIHtcbiAgICAgICAgICAgICAgICAgICAgdmFyIGNlbGxEYXRhID0ge1xuICAgICAgICAgICAgICAgICAgICAgICAgaWQ6IG9wZXJhdGlvbkludmFsaWRJZCxcbiAgICAgICAgICAgICAgICAgICAgICAgIHRpdGxlOiBcIlwiLFxuICAgICAgICAgICAgICAgICAgICAgICAgaW1nVXJsOiBcIlwiLFxuICAgICAgICAgICAgICAgICAgICAgICAgaW1nTmlnaHRVcmw6IFwiXCIsXG4gICAgICAgICAgICAgICAgICAgIH07XG4gICAgICAgICAgICAgICAgICAgIGZ1bmN0aW9uRGF0YS5jb250ZW50TGlzdC5wdXNoKGNlbGxEYXRhKTtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgY29udGVudExpc3RMZW5ndGggPSBmdW5jdGlvbkRhdGEuY29udGVudExpc3QubGVuZ3RoO1xuICAgICAgICAgICAgfVxuXG4gICAgICAgICAgICBmb3IgKHZhciBpbmRleCBpbiBmdW5jdGlvbkRhdGEuY29udGVudExpc3QpIHtcbiAgICAgICAgICAgICAgICBsZXQgaXRlbSA9IGZ1bmN0aW9uRGF0YS5jb250ZW50TGlzdFtpbmRleF07XG4gICAgICAgICAgICAgICAgaXRlbS5pY29uVXJsID0gY29tbW9uLmNvbW1hbkRhdGEuY29sb3JNb2RlID09IDE/IGl0ZW0uaW1nTmlnaHRVcmw6aXRlbS5pbWdVcmw7XG4gICAgICAgICAgICAgICAgLy/mlbTkvZPop5LmoIfop4TliJnkv53mjIHkuLrvvIzkuIDkuKrpobXpnaLmnIDlpJoy5Liq6KeS5qCH77yM5Yqo5oCB6KeS5qCH5pyA5aSa5LiA5Liq44CC54m55q6K5oOF5Ya177ya5aaC5p6c6KeS5qCH5o6l5Y+j5a+55ZCM5LiA5Liq6YeR5Yia5L2N6L+U5Zue5LqG5Zu+54mH5ZKM5paH5pys77yM5YiZ5Y+W5paH5pys44CCXG4gICAgICAgICAgICAgICAgbGV0IG1hcmtDb250ZW50TGVuZ3RoID0gaXRlbS5jb3JuZXJNYXJrQ29udGVudCAhPSBudWxsICYmIGl0ZW0uY29ybmVyTWFya0NvbnRlbnQudGV4dCAhPSBudWxsID8gaXRlbS5jb3JuZXJNYXJrQ29udGVudC50ZXh0Lmxlbmd0aCA6IDA7XG4gICAgICAgICAgICAgICAgaXRlbS5jb3JuZXJNYXJrVGV4dCAgPSBtYXJrQ29udGVudExlbmd0aCA+IDAgPyBpdGVtLmNvcm5lck1hcmtDb250ZW50LnRleHQ6XCJcIjtcbiAgICAgICAgICAgICAgICBpdGVtLmNvcm5lck1hcmtUZXh0VmlzaWJpbGl0eSAgPSBtYXJrQ29udGVudExlbmd0aCA+IDAgPyBcInZpc2libGVcIjpcImdvbmVcIjtcbiAgICAgICAgICAgICAgICBpZihpdGVtLmNvcm5lck1hcmtDb250ZW50ICE9IG51bGwgJiYgbWFya0NvbnRlbnRMZW5ndGggPT0gMCl7XG4gICAgICAgICAgICAgICAgICAgIGl0ZW0uY29ybmVyTWFya0ljb24gPSBjb21tb24uY29tbWFuRGF0YS5jb2xvck1vZGUgPT0gMT8gaXRlbS5jb3JuZXJNYXJrQ29udGVudC5uaWdodEltYWdlVXJsOml0ZW0uY29ybmVyTWFya0NvbnRlbnQuaW1hZ2VVcmw7XG4gICAgICAgICAgICAgICAgICAgIGl0ZW0uY29ybmVyTWFya0ljb25WaXNpYmlsaXR5ID0gaXRlbS5jb3JuZXJNYXJrSWNvbiAhPSBudWxsICYmIGl0ZW0uY29ybmVyTWFya0ljb24ubGVuZ3RoID4gMCA/IFwidmlzaWJsZVwiOlwiZ29uZVwiO1xuICAgICAgICAgICAgICAgIH1lbHNle1xuICAgICAgICAgICAgICAgICAgICBpdGVtLmNvcm5lck1hcmtJY29uVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICBpdGVtLnR5cGUgPSBcIjFcIjtcbiAgICAgICAgICAgICAgICBpdGVtLm9wZXJhdGlvbkluZGV4ID0gaW5kZXg7XG4gICAgICAgICAgICAgICAgaXRlbS5jb250ZW50VmlzaWJpbGl0eSAgPSBpdGVtLmlkICE9IG9wZXJhdGlvbkludmFsaWRJZCA/IFwidmlzaWJsZVwiOlwiZ29uZVwiO1xuICAgICAgICAgICAgICAgIC8vIGNvbnNvbGUubG9nKFwicmVxdWVzdE9wZXJhdGlvbkRhdGEg6YGN5Y6GIGl0ZW06XCIrSlNPTi5zdHJpbmdpZnkoaXRlbSkpO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgb3BlcmF0aW9uRGF0YUxpc3QgPSBmdW5jdGlvbkRhdGEuY29udGVudExpc3Q7XG4gICAgICAgICAgICBpZihjb250ZW50TGlzdExlbmd0aCA8PSA1KXtcbiAgICAgICAgICAgICAgICAkZGF0YS5vcGVyYXRpb24uc2Vjb25kRnVuY3Rpb25WaXNpYmlsaXR5ID0gXCJnb25lXCI7XG4gICAgICAgICAgICAgICAgJGRhdGEub3BlcmF0aW9uLmZpcnN0RnVuY3Rpb25MaXN0PSBmdW5jdGlvbkRhdGEuY29udGVudExpc3Q7XG4gICAgICAgICAgICAgICAgLy8gY29uc29sZS5sb2coXCJyZXF1ZXN0T3BlcmF0aW9uRGF0YSAkZGF0YS5vcGVyYXRpb24uZmlyc3RGdW5jdGlvbkxpc3Q6XCIrSlNPTi5zdHJpbmdpZnkoJGRhdGEub3BlcmF0aW9uLmZpcnN0RnVuY3Rpb25MaXN0KStcIiBzbGljZTpcIitKU09OLnN0cmluZ2lmeShmdW5jdGlvbkRhdGEuY29udGVudExpc3QpKTtcbiAgICAgICAgICAgIH1lbHNle1xuICAgICAgICAgICAgICAgICRkYXRhLm9wZXJhdGlvbi5zZWNvbmRGdW5jdGlvblZpc2liaWxpdHkgPSAgXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAgJGRhdGEub3BlcmF0aW9uLmZpcnN0RnVuY3Rpb25MaXN0ID0gZnVuY3Rpb25EYXRhLmNvbnRlbnRMaXN0LnNsaWNlKDAsNCk7XG4gICAgICAgICAgICAgICAgJGRhdGEub3BlcmF0aW9uLnNlY29uZEZ1bmN0aW9uTGlzdCA9IGZ1bmN0aW9uRGF0YS5jb250ZW50TGlzdC5zbGljZSg0LDgpO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgLy8gY29uc29sZS5sb2coXCJyZXF1ZXN0T3BlcmF0aW9uRGF0YSBvcGVyYXRpb25EYXRhTGlzdDpcIitKU09OLnN0cmluZ2lmeShvcGVyYXRpb25EYXRhTGlzdCkpO1xuICAgICAgICB9ZWxzZXtcbiAgICAgICAgICAgIC8vIGNvbnNvbGUubG9nKFwicmVxdWVzdE9wZXJhdGlvbkRhdGEgb3BlcmF0aW9uRGF0YUxpc3QgPSBudWxsXCIpO1xuICAgICAgICAgICAgJGRhdGEub3BlcmF0aW9uLmZ1bmN0aW9uVmlzaWJpbGl0eSA9IG9wZXJhdGlvbkRhdGFMaXN0ICE9IG51bGwgJiYgb3BlcmF0aW9uRGF0YUxpc3QubGVuZ3RoID4gMCA/IFwidmlzaWJsZVwiOlwiZ29uZVwiO1xuICAgICAgICB9XG4gICAgfVxufVxuXG5hc3luYyBmdW5jdGlvbiBvcGVyYXRpb25DbGlja0l0ZW0oaW5kZXgpIHtcbiAgICB0cnkge1xuICAgICAgICB2YXIgaXRlbSA9IG9wZXJhdGlvbkRhdGFMaXN0W2luZGV4XTtcbiAgICAgICAgY29uc29sZS5sb2coXCJvcGVyYXRpb25DbGlja0l0ZW0g6YeR5Yia5L2NIGluZGV4OlwiK2luZGV4K1wiIHN0cmluZ2lmeTpcIitKU09OLnN0cmluZ2lmeShpdGVtKSk7XG4gICAgICAgIGlmKGl0ZW0uaWQgPT0gb3BlcmF0aW9uSW52YWxpZElkKSByZXR1cm47XG4gICAgICAgIGF3YWl0ICRuYXRpdmVBUEkuaG9tZUJyaWRnZSh7XG4gICAgICAgICAgICAgICAgYWN0aW9uOiBcIm9wZXJhdGlvbkNsaWNrSXRlbVwiLFxuICAgICAgICAgICAgICAgIGRhdGE6SlNPTi5zdHJpbmdpZnkob3BlcmF0aW9uRGF0YUxpc3RbaW5kZXhdKVxuICAgICAgICAgICAgfSk7XG5cblxuICAgICAgICAgIGF3YWl0IGNvbW1vbi5hbmFseXRpY3MoXCJhcHBDbGlja19ob21lXCIsIHtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgbW9kdWxlX25hbWU6IFwiYmFsbFwiLFxuICAgICAgICAgICAgICAgICAgICAgICAgICBtb2R1bGVfcG9zaXRpb246IFN0cmluZyhpbmRleCArIDEpLFxuICAgICAgICAgICAgICAgICAgICAgICAgICB0eXBlOiBpdGVtLmp1bXBNb2RlID09IDk5OSA/IFwibW9yZVwiOiBpdGVtLmdyb3VwQ29kZSxcbiAgICAgICAgICAgICAgICAgICAgICAgICAgbWF0ZXJpYWxfbmFtZTogaXRlbVtcImFkTmFtZVwiXSxcbiAgICAgICAgICAgICAgICAgICAgICAgICAgZWxlbWVudElkOiBTdHJpbmcoaXRlbVtcImlkXCJdKSxcbiAgICAgICAgICAgICAgICAgICAgICAgICAgc3VwZXJzY3JpcHQ6IGl0ZW0uY29ybmVyTWFya0NvbnRlbnQgIT0gbnVsbD9pdGVtLmNvcm5lck1hcmtDb250ZW50LmNvcm5lck1hcmtJZDpcIlwiLFxuICAgICAgICAgICAgICAgICAgICAgICAgICBpc05lZWRMb2dpbjogaXRlbS5uZWVkTG9naW4gPT0gMSA/XCJUcnVlXCI6XCJGYWxzZVwiLFxuICAgICAgICAgICAgICAgICAgICAgIH0pO1xuICAgICAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCBlcnJvciwgZXJyb3I9JHtlfWApO1xuICAgICAgICB9XG59XG5cblxuJGV2ZW50Lm9wZXJhdGlvbkNsaWNrSXRlbSA9IG9wZXJhdGlvbkNsaWNrSXRlbTtcbiIsImltcG9ydCAqIGFzIGNvbW1vbiBmcm9tICcuL2NvbW1vbidcblxudmFyIG1vZHVsZURpZFN0YXJ0ID0gZmFsc2U7XG5cbi8v5Yid5aeL5YyWXG5hc3luYyBmdW5jdGlvbiBzdGFydCgpIHtcbiAgICBtb2R1bGVEaWRTdGFydCA9IHRydWU7XG4gICAgYXdhaXQgcmVxdWVzdFNwb3RIb21lUGFnZUluZm8oKTtcbn1cblxuLy/liJ3lp4vljJbmlbDmja5cbmZ1bmN0aW9uIGRlZmF1bHREYXRhKCkge1xuICAgIHJldHVybiB7XG4gICAgICAgIGxpc3REYXRhOiBbXG4gICAgICAgIF1cbiAgICB9O1xufVxuXG52YXIgY3ViZURhdGFMaXN0O1xuXG5jb25zdCB7IG1vZHVsZURhdGEsIG1vZHVsZUV2ZW50IH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFwiY3ViZVwiLCBzdGFydCwgZGVmYXVsdERhdGEpO1xuXG52YXIgY3ViZUV4cG9zdXJlTWFwID0gbmV3IE1hcCgpO1xuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gY2xlYXJDdWJlRXhwb3N1cmVNYXAoKSB7XG4gICAgY3ViZUV4cG9zdXJlTWFwLmNsZWFyKCk7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIG1vZHVsZUFwcGVhcigpIHtcbiAgICBpZiAoY3ViZURhdGFMaXN0ICYmIGN1YmVEYXRhTGlzdC5sZW5ndGggPiAwICYmICFjdWJlRXhwb3N1cmVNYXAuaGFzKFwiY3ViZVwiKSkge1xuICAgICAgICB2YXIgdHlwZSA9IFwiXCI7XG4gICAgICAgIHZhciBtYXRlcmlhbF9pZCA9IFwiXCI7XG4gICAgICAgIHZhciBtYXRlcmlhbF9uYW1lID0gXCJcIjtcbiAgICAgICAgdmFyIHJlc2VydmVfYnl0ZTEgPSBcIlwiO1xuICAgICAgICB2YXIgcmVzZXJ2ZV9ieXRlMiA9IFwiXCI7XG4gICAgICAgIGZvciAobGV0IGluZGV4IGluIGN1YmVEYXRhTGlzdCkge1xuICAgICAgICAgICAgbGV0IGl0ZW0gPSBjdWJlRGF0YUxpc3RbaW5kZXhdO1xuICAgICAgICAgICAgaWYgKGluZGV4ICE9IDApIHtcbiAgICAgICAgICAgICAgICB0eXBlID0gdHlwZS5jb25jYXQoXCIsXCIpO1xuICAgICAgICAgICAgICAgIG1hdGVyaWFsX2lkID0gbWF0ZXJpYWxfaWQuY29uY2F0KFwiLFwiKTtcbiAgICAgICAgICAgICAgICBtYXRlcmlhbF9uYW1lID0gbWF0ZXJpYWxfbmFtZS5jb25jYXQoXCIsXCIpO1xuICAgICAgICAgICAgICAgIHJlc2VydmVfYnl0ZTEgPSByZXNlcnZlX2J5dGUxLmNvbmNhdChcIixcIik7XG4gICAgICAgICAgICAgICAgcmVzZXJ2ZV9ieXRlMiA9IHJlc2VydmVfYnl0ZTIuY29uY2F0KFwiLFwiKTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIHR5cGUgPSB0eXBlLmNvbmNhdChpdGVtW1wibmFtZVwiXSk7XG4gICAgICAgICAgICBtYXRlcmlhbF9pZCA9IG1hdGVyaWFsX2lkLmNvbmNhdChpdGVtW1wibWF0ZXJpYWxJZFwiXSk7XG4gICAgICAgICAgICBtYXRlcmlhbF9uYW1lID0gbWF0ZXJpYWxfbmFtZS5jb25jYXQoaXRlbVtcIm5hbWVcIl0pO1xuICAgICAgICAgICAgcmVzZXJ2ZV9ieXRlMSA9IHJlc2VydmVfYnl0ZTEuY29uY2F0KGl0ZW1bXCJleHRlbnNpb25cIl0pO1xuICAgICAgICAgICAgcmVzZXJ2ZV9ieXRlMiA9IHJlc2VydmVfYnl0ZTIuY29uY2F0KGl0ZW1bXCJleHRlbnNpb25UZXh0XCJdKTtcbiAgICAgICAgfVxuICAgICAgICBhd2FpdCBjb21tb24uYW5hbHl0aWNzKFwiYXBwRXhwb3N1cmVfaG9tZVwiLCB7XG4gICAgICAgICAgICBtb2R1bGVfbmFtZTogXCJ0b2Z1XCIsXG4gICAgICAgICAgICB0eXBlOiB0eXBlLFxuICAgICAgICAgICAgZWxlbWVudElkOiBtYXRlcmlhbF9pZCxcbiAgICAgICAgICAgIG1hdGVyaWFsX25hbWU6IG1hdGVyaWFsX25hbWUsXG4gICAgICAgICAgICByZXNlcnZlX2J5dGUxOiByZXNlcnZlX2J5dGUxLFxuICAgICAgICAgICAgcmVzZXJ2ZV9ieXRlMjogcmVzZXJ2ZV9ieXRlMixcbiAgICAgICAgfSk7XG4gICAgICAgIGN1YmVFeHBvc3VyZU1hcC5zZXQoXCJjdWJlXCIsIHRydWUpO1xuICAgIH1cbn1cblxuYXN5bmMgZnVuY3Rpb24gbW9kdWxlRGlzYXBwZWFyKCkge1xuXG59XG5cbm1vZHVsZUV2ZW50Lm1vZHVsZUFwcGVhciA9IG1vZHVsZUFwcGVhcjtcbm1vZHVsZUV2ZW50Lm1vZHVsZURpc2FwcGVhciA9IG1vZHVsZURpc2FwcGVhcjtcblxubW9kdWxlRXZlbnQudGFwQ3ViZUFjdGlvbiA9IGFzeW5jIGZ1bmN0aW9uIChpbmRleCkge1xuICAgIGlmIChpbmRleCkge1xuICAgICAgICBsZXQgaSA9IHBhcnNlSW50KGluZGV4KTtcbiAgICAgICAgaWYgKGkgPCBjdWJlRGF0YUxpc3QubGVuZ3RoKSB7XG4gICAgICAgICAgICBsZXQgaXRlbSA9IGN1YmVEYXRhTGlzdFtpXTtcbiAgICAgICAgICAgIGF3YWl0IGNvbW1vbi5vcGVuUGFnZShcImN1YmVDbGlja1wiLCBpdGVtLnVybCk7XG5cbiAgICAgICAgICAgIGF3YWl0IGNvbW1vbi5hbmFseXRpY3MoXCJhcHBDbGlja19ob21lXCIsIHtcbiAgICAgICAgICAgICAgICBtb2R1bGVfbmFtZTogXCJ0b2Z1XCIsXG4gICAgICAgICAgICAgICAgbW9kdWxlX3Bvc2l0aW9uOiBpICsgMSxcbiAgICAgICAgICAgICAgICB0eXBlOiBpdGVtW1wibmFtZVwiXSxcbiAgICAgICAgICAgICAgICBtYXRlcmlhbF9uYW1lOiBpdGVtW1wibmFtZVwiXSxcbiAgICAgICAgICAgICAgICBlbGVtZW50SWQ6IGl0ZW1bXCJtYXRlcmlhbElkXCJdLFxuICAgICAgICAgICAgICAgIHJlc2VydmVfYnl0ZTE6IGl0ZW1bXCJleHRlbnNpb25cIl0sXG4gICAgICAgICAgICAgICAgcmVzZXJ2ZV9ieXRlMjogaXRlbVtcImV4dGVuc2lvblRleHRcIl0sXG4gICAgICAgICAgICB9KTtcbiAgICAgICAgfVxuICAgIH1cbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGNvdW50RG93bigpIHtcbiAgICBpZiAobW9kdWxlRGlkU3RhcnQgPT0gZmFsc2UpIHtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICBmb3IgKHZhciBpID0gMDsgaSA8IG1vZHVsZURhdGEubGlzdERhdGEubGVuZ3RoOyBpKyspIHtcbiAgICAgICAgbGV0IGl0ZW0gPSBtb2R1bGVEYXRhLmxpc3REYXRhW2ldO1xuICAgICAgICBpZiAoaXRlbS5jdWJlVHlwZSA9PT0gXCJjb3VudERvd25cIiAmJiBpdGVtLm5lZWRDb3VudERvd24gPT09IHRydWUgJiYgbW9kdWxlRGF0YS5zaG93RGF0YSA9PT0gJ3Zpc2libGUnKSB7XG4gICAgICAgICAgICBsZXQgZGlmZiA9IGl0ZW0uZGlmZlRpbWUgLSAxMDAwO1xuICAgICAgICAgICAgbGV0IHJlbWFpbmluZ1RpbWUgPSBNYXRoLm1heCgwLCBkaWZmKTtcbiAgICAgICAgICAgIGxldCB0aW1lcyA9IGhhbmRsZVNob3dUaW1lKHJlbWFpbmluZ1RpbWUpO1xuICAgICAgICAgICAgaXRlbS5kYXkgPSB0aW1lc1swXTtcbiAgICAgICAgICAgIGl0ZW0uaG91ciA9IHRpbWVzWzFdO1xuICAgICAgICAgICAgaXRlbS5taW51dGUgPSB0aW1lc1syXTtcbiAgICAgICAgICAgIGl0ZW0uc2Vjb25kID0gdGltZXNbM107XG4gICAgICAgICAgICBsZXQgc2hvd0RheSA9IGNvbW1vbi5nZXRWaXNpYmlsaXR5U3RhdHVzKGl0ZW0uZGF5ICE9PSBcIjAwXCIpO1xuICAgICAgICAgICAgaXRlbS5zaG93RGF5ID0gc2hvd0RheTtcbiAgICAgICAgICAgIGl0ZW0uZGlmZlRpbWUgPSByZW1haW5pbmdUaW1lO1xuICAgICAgICAgICAgaWYgKHJlbWFpbmluZ1RpbWUgPT09IDApIHtcbiAgICAgICAgICAgICAgICAvL+WAkuiuoeaXtue7k+adn1xuICAgICAgICAgICAgICAgIGl0ZW0uc2hvd0NvdW50RG93biA9IGNvbW1vbi5nZXRWaXNpYmlsaXR5U3RhdHVzKGZhbHNlKTtcbiAgICAgICAgICAgICAgICBhd2FpdCByZXF1ZXN0U3BvdEhvbWVQYWdlSW5mbygpO1xuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICBpdGVtLnNob3dDb3VudERvd24gPSBjb21tb24uZ2V0VmlzaWJpbGl0eVN0YXR1cyh0cnVlKTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgIH1cbn1cblxuYXN5bmMgZnVuY3Rpb24gaG9tZXBhZ2VJbmZvRGF0YUNhbGxiYWNrKGRhdGEsIGlzQ2FjaGUpIHtcbiAgICBhd2FpdCBjb21tb24uc2V0TW9kdWxlU3RhdHVzKCdjdWJlJywgMSk7XG4gICAgaWYgKG1vZHVsZURhdGEubGlzdERhdGEubGVuZ3RoID4gMCAmJiBpc0NhY2hlID09PSB0cnVlKSB7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG5cbiAgICAvLyBUT0RPOiBAQnVyZ2VyIOWinuWKoOaXpeW/l+iusOW9lVxuICAgIC8v5aKe5Yqg5Yik5pat77yM6Ziy5q2i57yT5a2Y6ISP5pWw5o2u77yM5a+86Ie056iL5bqP5byC5bi4XG4gICAgaWYgKGRhdGEgJiYgZGF0YS5hY2Nlc3MgJiYgZGF0YS5hY2Nlc3MubGVuZ3RoID4gMSkge1xuICAgICAgICB2YXIgYXJyID0gW107XG4gICAgICAgIHZhciBpbmRleCA9IDA7XG4gICAgICAgIGZvciAodmFyIGkgPSAwOyBpIDwgZGF0YS5hY2Nlc3MubGVuZ3RoOyBpKyspIHtcbiAgICAgICAgICAgIGxldCBpdGVtID0gZGF0YS5hY2Nlc3NbaV07XG4gICAgICAgICAgICB2YXIgY3ViZURhdGEgPSBpdGVtO1xuICAgICAgICAgICAgLy/lronljZPlpoLmnpzmmK9naWblm74g5YiZ5LiN5pi+56S6IFxuICAgICAgICAgICAgaWYgKGN1YmVEYXRhLmJnSW1hZ2VVcmwuaW5jbHVkZXMoJy5naWYnKSAmJiBjb21tb24uY29tbWFuRGF0YS5PUyA9PSAxKSB7XG4gICAgICAgICAgICAgICAgY3ViZURhdGEuYmdJbWFnZVVybCA9IFwiXCI7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBjdWJlRGF0YS5jdWJlVHlwZSA9IGl0ZW1DZWxsVHlwZShpdGVtLnN0eWxlKTtcbiAgICAgICAgICAgIGlmIChjdWJlRGF0YS5jdWJlVHlwZSA9PT0gXCJjb3VudERvd25cIikge1xuICAgICAgICAgICAgICAgIGhhbmRsZUN1YmVJdGVtVGltZXIoY3ViZURhdGEpXG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBpZiAoYXJyLmxlbmd0aCA8IDIpIHtcbiAgICAgICAgICAgICAgICBjdWJlRGF0YS5pbmRleCA9IFN0cmluZyhpbmRleCk7XG4gICAgICAgICAgICAgICAgaW5kZXggKz0gMTtcbiAgICAgICAgICAgICAgICBhcnIucHVzaChjdWJlRGF0YSk7XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICAgICAgbW9kdWxlRGF0YS5saXN0RGF0YSA9IGFycjtcbiAgICAgICAgY3ViZURhdGFMaXN0ID0gYXJyO1xuICAgICAgICBtb2R1bGVEYXRhLnNob3dEYXRhID0gY29tbW9uLmdldFZpc2liaWxpdHlTdGF0dXMobW9kdWxlRGF0YS5saXN0RGF0YS5sZW5ndGggPj0gMik7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgbW9kdWxlRGF0YS5zaG93RGF0YSA9IGNvbW1vbi5nZXRWaXNpYmlsaXR5U3RhdHVzKGZhbHNlKTtcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlcXVlc3RTcG90SG9tZVBhZ2VJbmZvKCkge1xuXG4gICAgYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0V2l0aENhY2hlKCd2MS9zcG90L2hvbWVwYWdlL2luZm8nLCBjYWxsYmFjayA9IGhvbWVwYWdlSW5mb0RhdGFDYWxsYmFjaywgcmVxdWVzdFBhcmFtcygpLCAwLCAwLCByZXF1ZXN0SGVhZGVyKCkpO1xuXG4gICAgaWYgKG1vZHVsZURhdGEuc2hvd0RhdGEgPT09ICd2aXNpYmxlJykge1xuICAgICAgICBhd2FpdCBjb21tb24uc2V0TW9kdWxlU3RhdHVzKCdjdWJlJywgMSk7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgYXdhaXQgY29tbW9uLnNldE1vZHVsZVN0YXR1cygnY3ViZScsIDIpO1xuICAgIH1cbn1cblxuZnVuY3Rpb24gcmVxdWVzdFBhcmFtcygpIHtcbiAgICB2YXIgcGFyYW0gPSB7fTtcbiAgICBwYXJhbS5wcmljaW5nTW9kZSA9IGNvbW1vbi5jb21tYW5EYXRhLnJhdGVUeXBlU3RyO1xuICAgIHBhcmFtLm5pZ2h0TW9kZSA9IGNvbW1vbi5jb21tYW5EYXRhLmNvbG9yTW9kZTtcbiAgICByZXR1cm4gcGFyYW07XG59XG5cbmZ1bmN0aW9uIHJlcXVlc3RIZWFkZXIoKSB7XG4gICAgdmFyIGhlYWRlciA9IHt9O1xuICAgIGxldCBjb3VudHJ5SWQgPSBwYXJzZUludChjb21tb24uY29tbWFuRGF0YS51c2VySW5mby5jb3VudHJ5SWQpO1xuICAgIGlmIChjb3VudHJ5SWQgPiAwICYmIGNvdW50cnlJZCAhPSAzNykge1xuICAgICAgICBoZWFkZXIuY291bnRyeVR5cGUgPSBcIjJcIjtcbiAgICB9IGVsc2Uge1xuICAgICAgICBoZWFkZXIuY291bnRyeVR5cGUgPSBcIjFcIjtcbiAgICB9XG4gICAgcmV0dXJuIGhlYWRlclxufVxuXG5mdW5jdGlvbiBpdGVtQ2VsbFR5cGUoc3R5bGUpIHtcbiAgICBpZiAoc3R5bGUgPT0gNSB8fCBzdHlsZSA9PSA2KSB7XG4gICAgICAgIHJldHVybiBcImNvdW50RG93blwiO1xuICAgIH0gZWxzZSBpZiAoc3R5bGUgPT0gMikge1xuICAgICAgICByZXR1cm4gXCJzdW1tYXJ5QnV0dG9uXCI7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgcmV0dXJuIFwibm9ybWFsXCI7XG4gICAgfVxufVxuXG5mdW5jdGlvbiBoYW5kbGVDdWJlSXRlbVRpbWVyKG9iamVjdCkge1xuICAgIGxldCBlbmRUaW1lID0gb2JqZWN0LmVuZFRpbWU7XG4gICAgbGV0IGJlZ2luVGltZSA9IG9iamVjdC5iZWdpblRpbWU7XG4gICAgdmFyIGRpZmZUaW1lID0gMDtcblxuICAgIG9iamVjdC5uZWVkQ291bnREb3duID0gZmFsc2U7XG5cbiAgICBpZiAoZW5kVGltZSA+IDAgJiYgYmVnaW5UaW1lID4gMCkge1xuICAgICAgICBpZiAoZW5kVGltZSA+IGJlZ2luVGltZSkge1xuICAgICAgICAgICAgZGlmZlRpbWUgPSBlbmRUaW1lIC0gYmVnaW5UaW1lO1xuICAgICAgICAgICAgb2JqZWN0Lm5lZWRDb3VudERvd24gPSB0cnVlO1xuICAgICAgICB9XG4gICAgfVxuICAgIG9iamVjdC5kaWZmVGltZSA9IGRpZmZUaW1lO1xuICAgIGxldCB0aW1lcyA9IGhhbmRsZVNob3dUaW1lKGRpZmZUaW1lKTtcbiAgICBvYmplY3QuZGF5ID0gdGltZXNbMF07XG4gICAgb2JqZWN0LmhvdXIgPSB0aW1lc1sxXTtcbiAgICBvYmplY3QubWludXRlID0gdGltZXNbMl07XG4gICAgb2JqZWN0LnNlY29uZCA9IHRpbWVzWzNdO1xuICAgIG9iamVjdC5zaG93RGF5ID0gY29tbW9uLmdldFZpc2liaWxpdHlTdGF0dXMob2JqZWN0LmRheSA9PSBcIjAwXCIpO1xuICAgIG9iamVjdC5zaG93Q291bnREb3duID0gY29tbW9uLmdldFZpc2liaWxpdHlTdGF0dXMoZGlmZlRpbWUgPiAwKVxufVxuXG5mdW5jdGlvbiBoYW5kbGVTaG93VGltZSh0aW1lc3RhbXApIHtcblxuICAgIGNvbnN0IHNlY29uZHMgPSBNYXRoLmZsb29yKHRpbWVzdGFtcCAvIDEwMDApO1xuICAgIGNvbnN0IG1pbnV0ZXMgPSBNYXRoLmZsb29yKHNlY29uZHMgLyA2MCk7XG4gICAgY29uc3QgaG91cnMgPSBNYXRoLmZsb29yKG1pbnV0ZXMgLyA2MCk7XG4gICAgY29uc3QgZGF5cyA9IE1hdGguZmxvb3IoaG91cnMgLyAyNCk7XG5cbiAgICBjb25zdCByZW1haW5pbmdTZWNvbmRzID0gc2Vjb25kcyAlIDYwO1xuICAgIGNvbnN0IHJlbWFpbmluZ01pbnV0ZXMgPSBtaW51dGVzICUgNjA7XG4gICAgY29uc3QgcmVtYWluaW5nSG91cnMgPSBob3VycyAlIDI0O1xuXG4gICAgLy8g6KGl6Zu25Ye95pWwXG4gICAgY29uc3QgYWRkTGVhZGluZ1plcm8gPSAodmFsdWUpID0+IHtcbiAgICAgICAgcmV0dXJuIHZhbHVlIDwgMTAgPyBgMCR7dmFsdWV9YCA6IHZhbHVlLnRvU3RyaW5nKCk7XG4gICAgfTtcblxuICAgIC8vIOWuuemUmeWkhOeQhlxuICAgIGNvbnN0IHNhZmVWYWx1ZSA9ICh2YWx1ZSkgPT4ge1xuICAgICAgICByZXR1cm4gdmFsdWUgPiAwID8gdmFsdWUgOiAwO1xuICAgIH07XG5cbiAgICBjb25zdCBkYXlTdHJpbmcgPSBhZGRMZWFkaW5nWmVybyhzYWZlVmFsdWUoZGF5cykpO1xuICAgIGNvbnN0IGhvdXJTdHJpbmcgPSBhZGRMZWFkaW5nWmVybyhzYWZlVmFsdWUocmVtYWluaW5nSG91cnMpKTtcbiAgICBjb25zdCBtaW51dGVTdHJpbmcgPSBhZGRMZWFkaW5nWmVybyhzYWZlVmFsdWUocmVtYWluaW5nTWludXRlcykpO1xuICAgIGNvbnN0IHNlY29uZFN0cmluZyA9IGFkZExlYWRpbmdaZXJvKHNhZmVWYWx1ZShyZW1haW5pbmdTZWNvbmRzKSk7XG5cbiAgICByZXR1cm4gW2RheVN0cmluZywgaG91clN0cmluZywgbWludXRlU3RyaW5nLCBzZWNvbmRTdHJpbmddO1xufVxuIiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gJy4vY29tbW9uJztcblxuLy/mlbDmja5cbnZhciBvcmlnaW5EYXRhO1xuXG52YXIgbW9yZUFjdGlvbkRhdGFNYXAgPSB7fTtcblxudmFyIHJhbmtpbmdDYWNoZUtleSA9IFwiUmFua2luZ0luZGV4Q2FjaGVcIjtcblxuLy/nlKjkuo7lrZjlgqjoh6rpgInpobXpnaLluIHlr7npgInkuK3nirbmgIHnmoRcbnZhciBmYXZvcml0ZXNTZWxlY3RJbWFnZU1hcCA9IHt9O1xuXG4vL+S4iuS4gOasoeiOt+WPluaVsOaNrueahOaXtumXtFxudmFyIGxhc3RUaW1lID0gMDtcblxuLy/mlrDluIHmppzpnIDopoHliLfmlrBcbnZhciBuZXdMaXN0TmVlZFJlZnJlc2ggPSBmYWxzZTtcblxuLy/oh6rpgIl0YWLlvZPliY3pgInkuK3nmoTliJfooahcbnZhciBjdXJyZW50U2NyZWVuO1xuXG4vL+iHqumAieWIl+ihqOe8k+WtmOaVsOaNriDkvr/kuo7liIfmjaLml7bpgJ/luqbmm7Tlv6tcbnZhciBmYXZvcml0ZVNjcmVlbkRhdGEgPSB7XG4gICAgXCJzcG90XCI6IG51bGwsXG4gICAgXCJmdXR1cmVcIjogbnVsbFxufTtcblxudmFyIHRpdGxlQ29sb3JfTm9ybWFsO1xudmFyIHRpdGxlQ29sb3JfU2VsZWN0ZWQ7XG52YXIgdGl0bGVGb250X05vcm1hbCA9IDE0O1xudmFyIHRpdGxlRm9udF9TZWxlY3RlZCA9IDIwO1xuXG52YXIgZmF2b3JpdGVJbWFnZU5vcm1hbCA9ICdAZHJhd2FibGUvZWRnZV9lbmdpbmVfaG9tZV9yYW5raW5nX2Zhdm9yaXRlX3VuY2hlY2snO1xudmFyIGZhdm9yaXRlSW1hZ2VTZWxlY3RlZCA9ICdAZHJhd2FibGUvZWRnZV9lbmdpbmVfaG9tZV9yYW5raW5nX2Zhdm9yaXRlX2NoZWNrJztcblxudmFyIGxhdGVzdFVwQ29pblRpbWUgPSAwO1xuXG52YXIgbW9kdWxlRGlkU3RhcnQgPSBmYWxzZTtcbnZhciBtYXJrZXRSYW5rSGludCA9IHRydWU7XG5cbi8v5Yid5aeL5YyWXG5hc3luYyBmdW5jdGlvbiBzdGFydCgpIHtcbiAgICBtb2R1bGVEaWRTdGFydCA9IHRydWU7XG4gICAgbGFzdFRpbWUgPSBuZXcgRGF0ZSgpLmdldFRpbWUoKTtcbiAgICBpZiAoY29tbW9uLmNvbW1hbkRhdGEuY29sb3JNb2RlID09IDEpIHtcbiAgICAgICAgdGl0bGVDb2xvcl9Ob3JtYWwgPSBcIiM4QzhDOTNcIjtcbiAgICAgICAgdGl0bGVDb2xvcl9TZWxlY3RlZCA9IFwiI0U2RTZFNlwiO1xuICAgIH1cbiAgICBlbHNlIHtcbiAgICAgICAgdGl0bGVDb2xvcl9Ob3JtYWwgPSBcIiM1NjU2NTZcIjtcbiAgICAgICAgdGl0bGVDb2xvcl9TZWxlY3RlZCA9IFwiIzAwMDAwMFwiO1xuICAgIH1cbiAgICBtYXJrZXRSYW5rSGludCA9IHRydWU7XG4gICAgY29uc29sZS5sb2coYG1hcmtldFJhbmtIaW50ID0gMTExMSwgbWFya2V0UmFua0hpbnQ9PSR7bWFya2V0UmFua0hpbnR9YCk7XG4gICAgYXdhaXQgZ2V0Q2FjaGVJbmRleCgpO1xuICAgIGF3YWl0IHJlcXVlc3RSYW5raW5nRGF0YSgpO1xufVxuXG5hc3luYyBmdW5jdGlvbiBnZXRDYWNoZUluZGV4KCkge1xuICAgIGNvbnN0IGNhY2hlSW5kZXggPSBhd2FpdCBjb21tb24ucmVhZChcInJhbmtpbmdcIiwgcmFua2luZ0NhY2hlS2V5KTtcbiAgICBpZiAoY2FjaGVJbmRleCAhPSBudWxsKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGBjYWNoZUluZGV4ID0gJHtjYWNoZUluZGV4fWApO1xuICAgICAgICAkZGF0YS5yYW5raW5nLmN1cnJlbnRJbmRleCA9IGNhY2hlSW5kZXg7XG4gICAgICAgICRkYXRhLnJhbmtpbmcuY3VycmVudFRhZyA9IFN0cmluZyhwYXJzZUludChjYWNoZUluZGV4KSArIDEwMCk7XG4gICAgICAgIGNvbnNvbGUubG9nKGBtYXJrZXRSYW5rSGludCA9IDIyMjIsIG1hcmtldFJhbmtIaW50PT0ke21hcmtldFJhbmtIaW50fWApO1xuICAgIH1cbiAgICBlbHNlIHtcbiAgICAgICAgbWFya2V0UmFua0hpbnQgPSBmYWxzZVxuICAgICAgICBsZXQgZGVmYXVsdEluZGV4ID0gMTtcbiAgICAgICAgJGRhdGEucmFua2luZy5jdXJyZW50SW5kZXggPSBTdHJpbmcoZGVmYXVsdEluZGV4KTtcbiAgICAgICAgJGRhdGEucmFua2luZy5jdXJyZW50VGFnID0gU3RyaW5nKGRlZmF1bHRJbmRleCArIDEwMCk7XG4gICAgICAgIGF3YWl0IGNvbW1vbi5zYXZlKFwicmFua2luZ1wiLCByYW5raW5nQ2FjaGVLZXksIFN0cmluZyhkZWZhdWx0SW5kZXgpKTtcbiAgICAgICAgYXdhaXQgY29tbW9uLnNhdmUoXCJyYW5raW5nXCIsIFwibWFya2V0X2NhcF90aXBcIiwgXCJoaW50XCIpO1xuICAgICAgICBjb25zb2xlLmxvZyhgbWFya2V0UmFua0hpbnQgPSAzMzMzLCBtYXJrZXRSYW5rSGludD09JHttYXJrZXRSYW5rSGludH1gKTtcbiAgICB9XG59XG5cbi8v5Yid5aeL5YyW5pWw5o2uXG5mdW5jdGlvbiBkZWZhdWx0RGF0YSgpIHtcbiAgICBsZXQgZGVmYXVsdEluZGV4ID0gMTtcbiAgICByZXR1cm4ge1xuICAgICAgICBjdXJyZW50VGFnOiBTdHJpbmcoZGVmYXVsdEluZGV4ICsgMTAwKSxcbiAgICAgICAgY3VycmVudEluZGV4OiBTdHJpbmcoZGVmYXVsdEluZGV4KVxuICAgIH07XG59XG5cbmNvbnN0IHsgbW9kdWxlRGF0YSwgbW9kdWxlRXZlbnQgfSA9IGNvbW1vbi5tb2R1bGVEZWZpbmUoXCJyYW5raW5nXCIsIHN0YXJ0LCBkZWZhdWx0RGF0YSk7XG5cbmFzeW5jIGZ1bmN0aW9uIG1vZHVsZUFwcGVhcigpIHtcbiAgICBhd2FpdCBhbmFseXRpY3NBcHBlYXIoKTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gbW9kdWxlRGlzYXBwZWFyKCkge1xuXG59XG5tb2R1bGVFdmVudC5tb2R1bGVBcHBlYXIgPSBtb2R1bGVBcHBlYXI7XG5tb2R1bGVFdmVudC5tb2R1bGVEaXNhcHBlYXIgPSBtb2R1bGVEaXNhcHBlYXI7XG5cbnZhciBuZWVkQW5hbHl0aWNzV2hlblJlcXVlc3RTdWNjZXNzID0gZmFsc2U7XG5hc3luYyBmdW5jdGlvbiBhbmFseXRpY3NBcHBlYXIoKSB7XG4gICAgaWYgKCRkYXRhLnJhbmtpbmcudGl0bGVEYXRhID09IG51bGwgfHwgJGRhdGEucmFua2luZy50aXRsZURhdGEubGVuZ3RoID09IDApIHtcbiAgICAgICAgbmVlZEFuYWx5dGljc1doZW5SZXF1ZXN0U3VjY2VzcyA9IHRydWU7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgbmVlZEFuYWx5dGljc1doZW5SZXF1ZXN0U3VjY2VzcyA9IGZhbHNlO1xuICAgIHZhciBjdXJyZW50SW5kZXggPSBwYXJzZUludCgkZGF0YS5yYW5raW5nLmN1cnJlbnRJbmRleCk7XG4gICAgaWYgKGN1cnJlbnRJbmRleCA8ICRkYXRhLnJhbmtpbmcudGl0bGVEYXRhLmxlbmd0aCkge1xuICAgICAgICB2YXIgdGl0bGVJdGVtID0gJGRhdGEucmFua2luZy50aXRsZURhdGFbY3VycmVudEluZGV4XTtcblxuICAgICAgICBhd2FpdCBjb21tb24uYW5hbHl0aWNzKFwiYXBwRXhwb3N1cmVfaG9tZVwiLCB7XG4gICAgICAgICAgICBtb2R1bGVfbmFtZTogXCJ0b3BsaXN0XCIsXG4gICAgICAgICAgICBsaXN0X3R5cGU6IHRpdGxlSXRlbS50eXBlXG4gICAgICAgIH0pO1xuICAgIH1cbn1cblxuJGRhdGEucmFua2luZ3BvcCA9IHtcbiAgICBwb3BzaG93OiBmYWxzZVxufTtcblxuLy8gdG9vbHMgXG5mdW5jdGlvbiBnZXRUeXBlU3RyaW5nKHR5cGUpIHtcbiAgICB2YXIgdHlwZVN0ciA9IFwiSG90XCI7XG4gICAgc3dpdGNoICh0eXBlKSB7XG4gICAgICAgIGNhc2UgMTpcbiAgICAgICAgICAgIHR5cGVTdHIgPSBcIkdhaW5lcnNcIjtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIDI6XG4gICAgICAgICAgICB0eXBlU3RyID0gXCJWb2xcIjtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIDQ6XG4gICAgICAgICAgICB0eXBlU3RyID0gXCJOZXdcIjtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIDU6XG4gICAgICAgICAgICB0eXBlU3RyID0gXCJIb3RcIjtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIDY6XG4gICAgICAgICAgICB0eXBlU3RyID0gXCJMb3NlcnNcIjtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIDk6XG4gICAgICAgICAgICB0eXBlU3RyID0gXCJGYXZvcml0ZVwiO1xuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGRlZmF1bHQ6XG4gICAgICAgICAgICBicmVhaztcbiAgICB9XG4gICAgcmV0dXJuIHR5cGVTdHI7XG59XG5cbmZ1bmN0aW9uIGdldFByaWNlU3ltYm9sKHF1b3RlQ3VycmVuY3kpIHtcbiAgICBpZiAocXVvdGVDdXJyZW5jeSA9PSBcIlVTRFwiKSB7XG4gICAgICAgIHJldHVybiBcIiRcIjtcbiAgICB9XG4gICAgcmV0dXJuIFwiXCI7XG59XG5cbmZ1bmN0aW9uIGdldEVtcHR5Q2VsbCh0eXBlLCBzdWJUeXBlKSB7XG4gICAgdmFyIGVtcHR5Q2VsbFR5cGU7XG4gICAgaWYgKHR5cGUgPT0gOSkge1xuICAgICAgICBlbXB0eUNlbGxUeXBlID0gXCJmYXZvcml0ZUVtcHR5XCI7XG4gICAgfVxuICAgIGVsc2Uge1xuICAgICAgICBlbXB0eUNlbGxUeXBlID0gXCJlbXB0eVwiO1xuICAgIH1cbiAgICB2YXIgZW1wdHlDZWxsID0ge1xuICAgICAgICBjZWxsVHlwZTogZW1wdHlDZWxsVHlwZSxcbiAgICAgICAgdHlwZTogdHlwZSxcbiAgICAgICAgc3ViVHlwZTogc3ViVHlwZVxuICAgIH1cbiAgICByZXR1cm4gZW1wdHlDZWxsO1xufVxuXG5hc3luYyBmdW5jdGlvbiBnZXRMb2NhbEZhdm9yaXRlcygpIHtcbiAgICBjb25zdCBmYXZvcml0ZXMgPSBhd2FpdCAkbmF0aXZlQVBJLmhvbWVCcmlkZ2UoeyBhY3Rpb246IFwiZ2V0TG9jYWxGYXZvcml0ZXNcIiB9KTtcbiAgICBjb25zb2xlLmxvZyhgZmF2b3JpdGVzID0gJHtmYXZvcml0ZXN9YCk7XG4gICAgcmV0dXJuIGZhdm9yaXRlcztcbn1cblxuYXN5bmMgZnVuY3Rpb24gZ2V0Q29udHJhY3RCdXNpbmVzc1R5cGVUYWcoc3ltYm9sKSB7XG4gICAgY29uc3QgYnVzaW5lc3NUeXBlVGFnID0gYXdhaXQgJG5hdGl2ZUFQSS5ob21lQnJpZGdlKHsgYWN0aW9uOiBcImdldENvbnRyYWN0QnVzaW5lc3NUeXBlVGFnXCIsIHN5bWJvbCB9KTtcbiAgICByZXR1cm4gYnVzaW5lc3NUeXBlVGFnO1xufVxuXG5mdW5jdGlvbiBoZWFkZXJDZWxsSXRlbUZyb20odGl0bGVzLCBjZWxsVHlwZSkge1xuICAgIC8v6aG26YOo5qCH6aKYXG4gICAgdmFyIGhlYWRlckl0ZW0gPSB7fTtcbiAgICBoZWFkZXJJdGVtLmNlbGxUeXBlID0gY2VsbFR5cGU7XG4gICAgaGVhZGVySXRlbS5sZWZ0VGl0bGUgPSB0aXRsZXNbMF07XG4gICAgaGVhZGVySXRlbS5taWRkbGVUaXRsZSA9IHRpdGxlc1sxXTtcbiAgICBoZWFkZXJJdGVtLnJpZ2h0VGl0bGUgPSB0aXRsZXNbMl07XG4gICAgaWYgKHRpdGxlc1syXVtcInRpdGxlUHJvcGVydHlcIl0gPT0gNiB8fCB0aXRsZXNbMl1bXCJ0aXRsZVByb3BlcnR5XCJdID09IDcpIHtcbiAgICAgICAgaGVhZGVySXRlbS5yaWdodFRpdGxlLm9yaWdpblRpdGxlTmFtZSA9IGhlYWRlckl0ZW0ucmlnaHRUaXRsZS50aXRsZU5hbWU7XG4gICAgICAgIGhlYWRlckl0ZW0ucmlnaHRUaXRsZS50aXRsZU5hbWUgPSBgJHtoZWFkZXJJdGVtLnJpZ2h0VGl0bGUudGl0bGVOYW1lfSgke2NvbW1vbi5jb21tYW5EYXRhLnJhdGVUeXBlU3RyfSlgO1xuICAgIH1cbiAgICByZXR1cm4gaGVhZGVySXRlbTtcbn1cblxuLy/lpITnkIZjZWxs5pWw5o2uXG5hc3luYyBmdW5jdGlvbiBmaWx0ZXJMaXN0SXRlbXModHlwZSwgc3ViVHlwZSwgbGlzdCwgZGF0YUNvdW50ID0gMTAsIHNob3dNb3JlID0gdHJ1ZSwgc2hvd1F1b3RhID0gZmFsc2UpIHtcbiAgICB2YXIgZmlsdGVyTGlzdCA9IFtdO1xuXG4gICAgbGV0IG1heENvdW50ID0gbGlzdC5sZW5ndGg7XG4gICAgdmFyIGNvdW50ID0gMDtcbiAgICBmb3IgKGxldCBpID0gMDsgaSA8IG1heENvdW50OyBpKyspIHtcbiAgICAgICAgaWYgKGNvdW50ID49IGRhdGFDb3VudCkge1xuICAgICAgICAgICAgYnJlYWtcbiAgICAgICAgfVxuICAgICAgICB2YXIgaXRlbSA9IGxpc3RbaV07XG4gICAgICAgIHZhciBkZXRhaWxJbmZvID0ge307XG4gICAgICAgIGRldGFpbEluZm8ub3JpZ2luSXRlbUpzb24gPSBKU09OLnN0cmluZ2lmeShpdGVtKTtcbiAgICAgICAgZGV0YWlsSW5mby50eXBlID0gdHlwZS50b0ZpeGVkKDApLnRvU3RyaW5nKCk7XG4gICAgICAgIGRldGFpbEluZm8uc3ViVHlwZSA9IHN1YlR5cGU7XG4gICAgICAgIGRldGFpbEluZm8uc3ltYm9sID0gaXRlbS5zeW1ib2w7XG4gICAgICAgIGRldGFpbEluZm8uYmFzZU5hbWUgPSBpdGVtLmJhc2VDdXJyZW5jeS50b1VwcGVyQ2FzZSgpO1xuICAgICAgICBpZiAodHlwZSA9PSAxIHx8IHR5cGUgPT0gNiB8fCAodHlwZSA9PSA5ICYmIHN1YlR5cGUgPT0gJ3Nwb3QnKSB8fCBzaG93UXVvdGEgPT0gdHJ1ZSkgey8vMTrmtqjluYXmppwgNu+8mui3jOW5heamnFxuICAgICAgICAgICAgZGV0YWlsSW5mby5xdW90ZU5hbWUgPSBgLyR7aXRlbS5xdW90ZUN1cnJlbmN5LnRvVXBwZXJDYXNlKCl9YDtcbiAgICAgICAgICAgIGRldGFpbEluZm8uaXNRdW90ZU5hbWUgPSAndmlzaWJsZSc7XG4gICAgICAgIH1cbiAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICBkZXRhaWxJbmZvLmlzUXVvdGVOYW1lID0gJ2dvbmUnO1xuICAgICAgICB9XG4gICAgICAgIGRldGFpbEluZm8uaWNvblVSTCA9IGNvbW1vbi5nZXRJY29uVVJMKGl0ZW0uYmFzZUN1cnJlbmN5KTtcbiAgICAgICAgZGV0YWlsSW5mby5pY29uUGxhY2Vob2xkZXIgPSBgQGRyYXdhYmxlLyR7Y29tbW9uLmNvbW1hbkRhdGEuaWNvblBsYWNlaG9sZGVyfWA7XG5cbiAgICAgICAgaWYgKGl0ZW0udGFnVXJsICE9IG51bGwgJiYgaXRlbS50YWdVcmwgIT09ICcnKSB7XG4gICAgICAgICAgICBkZXRhaWxJbmZvLmZsYWdVUkwgPSBpdGVtLnRhZ1VybDtcbiAgICAgICAgICAgIGRldGFpbEluZm8uZmxhZ1ZpZXdWaXNpYmlsaXR5ID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICBkZXRhaWxJbmZvLmlzWmVyb0ZlZSA9IFwiZ29uZVwiO1xuICAgICAgICB9XG4gICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgZGV0YWlsSW5mby5mbGFnVmlld1Zpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICAgICAgICAgIHZhciB0YWdzID0gaXRlbS50YWdzO1xuICAgICAgICAgICAgaWYgKHRhZ3MgIT0gbnVsbCAmJiB0YWdzLmxlbmd0aCA+IDApIHtcbiAgICAgICAgICAgICAgICBjb25zdCBpc1plcm9GZWUgPSB0YWdzLmluY2x1ZGVzKFwiemVyb2ZlZVwiKTtcbiAgICAgICAgICAgICAgICBkZXRhaWxJbmZvLmlzWmVyb0ZlZSA9IGlzWmVyb0ZlZSA/IFwidmlzaWJsZVwiIDogXCJnb25lXCI7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBlbHNlIHtcbiAgICAgICAgICAgICAgICBkZXRhaWxJbmZvLmlzWmVyb0ZlZSA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgfVxuICAgICAgICB9XG5cbiAgICAgICAgaWYgKHR5cGUgPT0gOSAmJiBzdWJUeXBlID09ICdmdXR1cmUnKSB7XG4gICAgICAgICAgICBpZiAodHlwZSA9PSA5ICYmIHN1YlR5cGUgPT0gJ2Z1dHVyZScpIHtcbiAgICAgICAgICAgICAgICBkZXRhaWxJbmZvLmNlbGxUeXBlID0gXCJmdXR1cmVcIjtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGRldGFpbEluZm8uYmFzZU5hbWUgPSBpdGVtLmNvbnRyYWN0U2hvd1N5bWJvbC50b1VwcGVyQ2FzZSgpO1xuICAgICAgICAgICAgZGV0YWlsSW5mby5hbmFseXRpY3NTeW1ib2xOYW1lID0gZGV0YWlsSW5mby5iYXNlTmFtZTtcbiAgICAgICAgICAgIHZhciBwcmljZVN5bWJvbCA9IGdldFByaWNlU3ltYm9sKGl0ZW0ucXVvdGVDdXJyZW5jeSk7XG4gICAgICAgICAgICBpZiAoaXRlbS5wcmljZSAhPSBudWxsICYmIGl0ZW0ucHJpY2UubGVuZ3RoID4gMCkge1xuICAgICAgICAgICAgICAgIGRldGFpbEluZm8ucHJpY2UgPSBgJHtwcmljZVN5bWJvbH0ke2l0ZW0ucHJpY2V9YDtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgICAgIGRldGFpbEluZm8ucHJpY2UgPSBcIi0tXCI7XG4gICAgICAgICAgICB9XG5cbiAgICAgICAgICAgIHZhciByYXRpbyA9IDA7XG4gICAgICAgICAgICBpZiAoaXRlbS51cEFuZERvd24gIT0gbnVsbCAmJiBpdGVtLnVwQW5kRG93biAhPT0gJycpIHtcbiAgICAgICAgICAgICAgICB2YXIgdXBBbmREb3duID0gcGFyc2VGbG9hdChpdGVtLnVwQW5kRG93bik7XG4gICAgICAgICAgICAgICAgaWYgKE1hdGguYWJzKHVwQW5kRG93bikgPiAwKSB7XG4gICAgICAgICAgICAgICAgICAgIHJhdGlvID0gdXBBbmREb3duICogMTAwO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH1cblxuICAgICAgICAgICAgdmFyIHByZWZpeCA9IHJhdGlvID4gMCA/IFwiK1wiIDogXCJcIjtcbiAgICAgICAgICAgIGRldGFpbEluZm8ucmF0aW8gPSBgJHtwcmVmaXh9JHtyYXRpby50b0ZpeGVkKDIpLnRvU3RyaW5nKCl9JWA7XG4gICAgICAgICAgICBkZXRhaWxJbmZvLmNvbG9ySGV4ID0gY29tbW9uLmdldFByaWNlQ29sb3IocmF0aW8pO1xuICAgICAgICAgICAgZGV0YWlsSW5mby5pc0Zhdm9yaXRlcyA9IGNvbW1vbi5nZXRQcmljZUNvbG9yKHJhdGlvKTtcblxuICAgICAgICAgICAgaWYgKGl0ZW0uY29udHJhY3RCdXNpbmVzc1R5cGVUYWcgIT0gbnVsbCAmJiBpdGVtLmNvbnRyYWN0QnVzaW5lc3NUeXBlVGFnLmxlbmd0aCA+IDApIHtcbiAgICAgICAgICAgICAgICBkZXRhaWxJbmZvLmNvbnRyYWN0QnVzaW5lc3NUeXBlVGFnID0gaXRlbS5jb250cmFjdEJ1c2luZXNzVHlwZVRhZztcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgICAgIGRldGFpbEluZm8uY29udHJhY3RCdXNpbmVzc1R5cGVUYWcgPSBhd2FpdCBnZXRDb250cmFjdEJ1c2luZXNzVHlwZVRhZyhpdGVtLnN5bWJvbCk7XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICB2YXIgc3ltYm9sSW5mbyA9IGNvbW1vbi5nZXRTeW1ib2xJbmZvKGl0ZW0uc3ltYm9sKTtcbiAgICAgICAgICAgIGlmIChzeW1ib2xJbmZvID09IG51bGwpIHtcbiAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhg5peg5biB5a+55L+h5oGv77yM6L+H5ruk5biB5a+5ICR7aXRlbS5zeW1ib2x9LCB0eXBlID0gJHt0eXBlfSwgc3VidHlwZSA9ICR7c3ViVHlwZX1gKTtcbiAgICAgICAgICAgICAgICBjb250aW51ZTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGlmIChzeW1ib2xJbmZvLmlzSGlkZGVuVXApIHtcbiAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhgaXNIaWRkZW5VcCA9ICR7c3ltYm9sSW5mby5pc0hpZGRlblVwfe+8jOi/h+a7pOW4geWvuSAke2l0ZW0uc3ltYm9sfSwgdHlwZSA9ICR7dHlwZX0sIHN1YnR5cGUgPSAke3N1YlR5cGV9YCk7XG4gICAgICAgICAgICAgICAgY29udGludWU7XG4gICAgICAgICAgICB9XG5cbiAgICAgICAgICAgIHZhciBwcmljZVN0ciA9IFwiLS1cIjtcbiAgICAgICAgICAgIGNvbnN0IGNvaW5EaWN0ID0gY29tbW9uLmNvbW1hbkRhdGEubWFya2V0RGF0YVtpdGVtLnN5bWJvbF07XG4gICAgICAgICAgICBpZiAoY29pbkRpY3QgIT0gbnVsbCkge1xuICAgICAgICAgICAgICAgIHZhciBwcmljZSA9IGNvaW5EaWN0LmRlY2ltYWxjUHJpY2U7XG4gICAgICAgICAgICAgICAgcHJpY2VTdHIgPSBjb21tb24uZ2V0UHJpY2VTdHJpbmcocHJpY2UsIHN5bWJvbEluZm8udHJhZGVQcmljZVByZWNpc2lvbik7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBlbHNlIHtcbiAgICAgICAgICAgICAgICBpZiAoaXRlbS5wcmljZSAhPSBudWxsICYmIGl0ZW0ucHJpY2UubGVuZ3RoID4gMCkge1xuICAgICAgICAgICAgICAgICAgICBwcmljZVN0ciA9IGNvbW1vbi5nZXRQcmljZVN0cmluZyhpdGVtLnByaWNlLCBzeW1ib2xJbmZvLnRyYWRlUHJpY2VQcmVjaXNpb24pO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICBlbHNlIHtcbiAgICAgICAgICAgICAgICAgICAgcHJpY2VTdHIgPSBcIi0tXCI7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgfVxuXG4gICAgICAgICAgICBkZXRhaWxJbmZvLmFuYWx5dGljc1N5bWJvbE5hbWUgPSBgJHtzeW1ib2xJbmZvLmJhc2VDdXJyZW5jeURpc3BsYXlOYW1lfS8ke3N5bWJvbEluZm8ucXVvdGVDdXJyZW5jeURpc3BsYXlOYW1lfWBcbiAgICAgICAgICAgIGRldGFpbEluZm8ucHJpY2UgPSBwcmljZVN0cjtcblxuICAgICAgICAgICAgaWYgKHR5cGUgPT0gMSB8fCB0eXBlID09IDUgfHwgdHlwZSA9PSA2IHx8IHR5cGUgPT0gOSkgey8vMTrmtqjluYXmppwgNe+8mueDreamnCA277ya6LeM5bmF5qacIDnvvJroh6rpgInkuK3nmoTnjrDotKdcbiAgICAgICAgICAgICAgICBkZXRhaWxJbmZvLmNlbGxUeXBlID0gXCJub3JtYWxcIjtcbiAgICAgICAgICAgICAgICB2YXIgcmF0aW8gPSAwO1xuICAgICAgICAgICAgICAgIGlmIChjb2luRGljdCAhPSBudWxsKSB7XG4gICAgICAgICAgICAgICAgICAgIGlmIChNYXRoLmFicyhjb2luRGljdC5kZWNpbWFsRGVsdGEpID49IDApIHtcbiAgICAgICAgICAgICAgICAgICAgICAgIHJhdGlvID0gY29pbkRpY3QuZGVjaW1hbERlbHRhO1xuICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICBpZiAoaXRlbS51cEFuZERvd24gIT0gbnVsbCAmJiBpdGVtLnVwQW5kRG93biAhPT0gJycpIHtcbiAgICAgICAgICAgICAgICAgICAgICAgIHZhciB1cEFuZERvd24gPSBwYXJzZUZsb2F0KGl0ZW0udXBBbmREb3duKTtcbiAgICAgICAgICAgICAgICAgICAgICAgIGlmIChNYXRoLmFicyh1cEFuZERvd24pID4gMCkge1xuICAgICAgICAgICAgICAgICAgICAgICAgICAgIHJhdGlvID0gdXBBbmREb3duICogMTAwO1xuICAgICAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgfVxuXG4gICAgICAgICAgICAgICAgdmFyIHByZWZpeCA9IHJhdGlvID4gMCA/IFwiK1wiIDogXCJcIjtcbiAgICAgICAgICAgICAgICBkZXRhaWxJbmZvLnJhdGlvID0gYCR7cHJlZml4fSR7cmF0aW8udG9GaXhlZCgyKS50b1N0cmluZygpfSVgO1xuICAgICAgICAgICAgICAgIGRldGFpbEluZm8uY29sb3JIZXggPSBjb21tb24uZ2V0UHJpY2VDb2xvcihyYXRpbyk7XG4gICAgICAgICAgICAgICAgaWYgKHR5cGUgPT0gOSkge1xuICAgICAgICAgICAgICAgICAgICBkZXRhaWxJbmZvLmlzRmF2b3JpdGVzID0gY29tbW9uLmdldFByaWNlQ29sb3IocmF0aW8pO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGVsc2UgaWYgKHR5cGUgPT0gMikgeyAvLzI65oiQ5Lqk6aKd5qacXG4gICAgICAgICAgICAgICAgZGV0YWlsSW5mby5jZWxsVHlwZSA9IFwiZGVhbFwiO1xuICAgICAgICAgICAgICAgIGlmIChpdGVtLnZvbHVtZSAhPSBudWxsICYmIGl0ZW0udm9sdW1lICE9PSAnJykge1xuICAgICAgICAgICAgICAgICAgICBkZXRhaWxJbmZvLnZvbHVtZSA9IGF3YWl0IGdldFZvbHVtZVN0cihpdGVtLnZvbHVtZSk7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICBkZXRhaWxJbmZvLnZvbHVtZSA9IFwiLS1cIjtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBlbHNlIGlmICh0eXBlID09IDEwKSB7IC8vMTAgOiDluILlgLzmppxcbiAgICAgICAgICAgICAgICBkZXRhaWxJbmZvLmNlbGxUeXBlID0gXCJtYXJrZXRcIjtcbiAgICAgICAgICAgICAgICBpZiAoaXRlbS52b2x1bWUgIT0gbnVsbCAmJiBpdGVtLnZvbHVtZSAhPT0gJycpIHtcbiAgICAgICAgICAgICAgICAgICAgZGV0YWlsSW5mby52b2x1bWUgPSBhd2FpdCBnZXRWb2x1bWVTdHIoaXRlbS52b2x1bWUpO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICBlbHNlIHtcbiAgICAgICAgICAgICAgICAgICAgZGV0YWlsSW5mby52b2x1bWUgPSBcIi0tXCI7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgfVxuICAgICAgICAgICAgZWxzZSBpZiAodHlwZSA9PSA0KSB7Ly80OuaWsOW4geamnFxuICAgICAgICAgICAgICAgIGlmIChsYXRlc3RVcENvaW5UaW1lID09IG51bGwgfHwgbGF0ZXN0VXBDb2luVGltZSA8IGl0ZW0uYmVnaW5UcmFkZURhdGUpIHtcbiAgICAgICAgICAgICAgICAgICAgbGF0ZXN0VXBDb2luVGltZSA9IGl0ZW0uYmVnaW5UcmFkZURhdGU7XG4gICAgICAgICAgICAgICAgICAgIGNvbnNvbGUubG9nKGBwb2ludFZpc2liaWxpdHkgIOiOt+WPluacgOaWsOaXtumXtCA9ICR7bGF0ZXN0VXBDb2luVGltZX1gKTtcbiAgICAgICAgICAgICAgICB9XG5cbiAgICAgICAgICAgICAgICBkZXRhaWxJbmZvLmJlZ2luRGF0ZSA9IGl0ZW0uYmVnaW5UcmFkZURhdGU7XG4gICAgICAgICAgICAgICAgY29uc3QgZGF0ZSA9IG5ldyBEYXRlKGl0ZW0uYmVnaW5UcmFkZURhdGUpO1xuICAgICAgICAgICAgICAgIGlmIChzdWJUeXBlID09IFwidHJhZGVhYmxlXCIpIHtcbiAgICAgICAgICAgICAgICAgICAgZGV0YWlsSW5mby5jZWxsVHlwZSA9IFwibmV3XCI7XG5cbiAgICAgICAgICAgICAgICAgICAgdmFyIHJhdGlvID0gMDtcbiAgICAgICAgICAgICAgICAgICAgaWYgKE1hdGguYWJzKGl0ZW0uYmVnaW5UcmFkZVVwQW5kRG93bikgPiAwKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICByYXRpbyA9IGl0ZW0uYmVnaW5UcmFkZVVwQW5kRG93biAqIDEwMDtcbiAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgICAgICB2YXIgcHJlZml4ID0gcmF0aW8gPiAwID8gXCIrXCIgOiBcIlwiO1xuICAgICAgICAgICAgICAgICAgICBkZXRhaWxJbmZvLnJhdGlvID0gYCR7cHJlZml4fSR7cmF0aW8udG9GaXhlZCgyKS50b1N0cmluZygpfSVgO1xuICAgICAgICAgICAgICAgICAgICBkZXRhaWxJbmZvLmNvbG9ySGV4ID0gY29tbW9uLmdldFByaWNlQ29sb3IocmF0aW8pO1xuICAgICAgICAgICAgICAgICAgICBkZXRhaWxJbmZvLmJlZ2luRGF0ZVN0ciA9IGNvbW1vbi5mb3JtYXREYXRlKGRhdGUsIFwieXl5eS1NTS1kZFwiKTtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgZWxzZSBpZiAoc3ViVHlwZSA9PSBcInVudHJhZGVhYmxlXCIpIHtcbiAgICAgICAgICAgICAgICAgICAgZGV0YWlsSW5mby5jZWxsVHlwZSA9IFwid2lsbFVwXCI7XG4gICAgICAgICAgICAgICAgICAgIGRldGFpbEluZm8uYmVnaW5EYXRlU3RyID0gY29tbW9uLmZvcm1hdERhdGUoZGF0ZSwgXCJNTS1kZCBoaDptbVwiKTtcblxuICAgICAgICAgICAgICAgICAgICB2YXIgdGltZU1hcCA9IGdldENvdW50RG93bk1hcChkZXRhaWxJbmZvLmJlZ2luRGF0ZSk7XG4gICAgICAgICAgICAgICAgICAgIGRldGFpbEluZm8uZGF5ID0gdGltZU1hcC5kYXk7XG4gICAgICAgICAgICAgICAgICAgIGRldGFpbEluZm8uaG91ciA9IHRpbWVNYXAuaG91cjtcbiAgICAgICAgICAgICAgICAgICAgZGV0YWlsSW5mby5taW51dGUgPSB0aW1lTWFwLm1pbnV0ZTtcbiAgICAgICAgICAgICAgICAgICAgZGV0YWlsSW5mby5zZWNvbmQgPSB0aW1lTWFwLnNlY29uZDtcbiAgICAgICAgICAgICAgICAgICAgZGV0YWlsSW5mby5zaG93RGF5ID0gdGltZU1hcC5zaG93RGF5O1xuICAgICAgICAgICAgICAgICAgICBpZiAodGltZU1hcC5pc1plcm8pIHtcbiAgICAgICAgICAgICAgICAgICAgICAgIG5ld0xpc3ROZWVkUmVmcmVzaCA9IHRydWU7XG4gICAgICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICAgICAgZmlsdGVyTGlzdC5wdXNoKGRldGFpbEluZm8pO1xuICAgICAgICBjb3VudCArPSAxO1xuICAgIH1cbiAgICBpZiAoZmlsdGVyTGlzdC5sZW5ndGggPj0gZGF0YUNvdW50ICYmIHNob3dNb3JlKSB7XG4gICAgICAgIHZhciBtb3JlQ2VsbCA9IHtcbiAgICAgICAgICAgIGNlbGxUeXBlOiBcIm1vcmVcIixcbiAgICAgICAgICAgIHR5cGU6IFN0cmluZyh0eXBlKSxcbiAgICAgICAgICAgIHN1YlR5cGU6IFwiXCIsXG4gICAgICAgIH07XG4gICAgICAgIGlmICh0eXBlID09IDkpIHtcbiAgICAgICAgICAgIG1vcmVDZWxsLnN1YlR5cGUgPSBTdHJpbmcoc3ViVHlwZSk7XG4gICAgICAgIH1cbiAgICAgICAgdmFyIHZlcnNpb24gPSBwYXJzZUludChjb21tb24uY29tbWFuRGF0YS5hcHBWZXJzaW9uKTtcbiAgICAgICAgaWYgKHZlcnNpb24gPCAxMDIyMDApIHtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGB0bCAtLSB2ZXJzaW9uPT0ke3ZlcnNpb259LDExMWApO1xuICAgICAgICAgICAgaWYgKHR5cGUgIT0gMTApIHtcbiAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhgdGwgLS0gdmVyc2lvbj09JHt2ZXJzaW9ufSwyMjJgKTtcbiAgICAgICAgICAgICAgICBmaWx0ZXJMaXN0LnB1c2gobW9yZUNlbGwpOyAgXG4gICAgICAgICAgICB9XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgdGwgLS0gdmVyc2lvbj09JHt2ZXJzaW9ufSwzMzNgKTtcbiAgICAgICAgICAgIGZpbHRlckxpc3QucHVzaChtb3JlQ2VsbCk7XG4gICAgICAgIH1cbiAgICB9XG5cbiAgICBmb3IgKGxldCBpID0gMDsgaSA8IGZpbHRlckxpc3QubGVuZ3RoOyBpKyspIHtcbiAgICAgICAgdmFyIGNlbGxJdGVtID0gZmlsdGVyTGlzdFtpXTtcbiAgICAgICAgdmFyIGFuYWx5dGljcyA9IHt9O1xuICAgICAgICBhbmFseXRpY3MubW9kdWxlX3Bvc2l0aW9uID0gaSArIDE7XG4gICAgICAgIGFuYWx5dGljcy5saXN0X3R5cGUgPSB0eXBlO1xuICAgICAgICBpZiAoY2VsbEl0ZW0uY2VsbFR5cGUgIT0gXCJtb3JlXCIpIHtcbiAgICAgICAgICAgIGFuYWx5dGljcy5uYW1lID0gY2VsbEl0ZW0uYW5hbHl0aWNzU3ltYm9sTmFtZTtcbiAgICAgICAgICAgIGFuYWx5dGljcy5zdGF0dXMgPSBjZWxsSXRlbS5jZWxsVHlwZSA9PSBcIndpbGxVcFwiID8gXCJVbmxpc3RlZFwiIDogXCJMaXN0ZWRcIjtcbiAgICAgICAgfVxuICAgICAgICBjZWxsSXRlbS5hbmFseXRpY3MgPSBKU09OLnN0cmluZ2lmeShhbmFseXRpY3MpO1xuICAgIH1cbiAgICByZXR1cm4gZmlsdGVyTGlzdDtcbn1cblxuYXN5bmMgZnVuY3Rpb24gaGFuZGxlRmF2b3JpdGVMaXN0KGl0ZW0pIHtcbiAgICB2YXIgZmF2b3JpdGVMaXN0ID0gW107XG4gICAgdmFyIGZhdm9yaXRlVGl0bGVDZWxsID0ge1xuICAgICAgICBjZWxsVHlwZTogXCJmYXZvcml0ZVRpdGxlXCIsXG4gICAgICAgIGZhdm9yaXRlVGl0bGU6ICRpMThuLm5faG9tZV9mYXZvcml0ZV9zZWxlY3RfY3J5cHRvXG4gICAgfTtcbiAgICBmYXZvcml0ZUxpc3QucHVzaChmYXZvcml0ZVRpdGxlQ2VsbCk7XG5cbiAgICBjb25zdCBkYXRhQ2VsbExpc3QgPSBhd2FpdCBmaWx0ZXJMaXN0SXRlbXMoaXRlbS50eXBlLCBudWxsLCBpdGVtLnNpbmdsZUxpc3QsIG1heENvdW50ID0gNiwgc2hvd01vcmUgPSBmYWxzZSwgc2hvd1F1b3RhID0gdHJ1ZSk7XG5cbiAgICBsZXQgaGFzQ2hvb3NlID0gZmFsc2U7XG4gICAgLy/oh6rpgInmjqjojZDpgInkuK3nirbmgIFcbiAgICBmb3IgKHZhciBkYXRhQ2VsbCBvZiBkYXRhQ2VsbExpc3QpIHtcbiAgICAgICAgdmFyIGltYWdlTmFtZSA9IGZhdm9yaXRlc1NlbGVjdEltYWdlTWFwW2RhdGFDZWxsLnN5bWJvbF07XG4gICAgICAgIGlmIChpbWFnZU5hbWUgPT0gbnVsbCkge1xuICAgICAgICAgICAgaW1hZ2VOYW1lID0gZmF2b3JpdGVJbWFnZVNlbGVjdGVkO1xuICAgICAgICAgICAgZmF2b3JpdGVzU2VsZWN0SW1hZ2VNYXBbZGF0YUNlbGwuc3ltYm9sXSA9IGltYWdlTmFtZTtcbiAgICAgICAgfVxuICAgICAgICBpZiAoaW1hZ2VOYW1lID09IGZhdm9yaXRlSW1hZ2VTZWxlY3RlZCkge1xuICAgICAgICAgICAgaGFzQ2hvb3NlID0gdHJ1ZTtcbiAgICAgICAgfVxuICAgICAgICBkYXRhQ2VsbC5mYXZvcml0ZUltYWdlID0gaW1hZ2VOYW1lO1xuICAgIH1cblxuICAgIHZhciBmYXZvcml0ZURhdGFDZWxsID0ge1xuICAgICAgICBjZWxsVHlwZTogXCJzcG90RmF2b3JpdGVcIixcbiAgICAgICAgbGVmdEl0ZW1WaXNpYmlsaXR5OiBcImdvbmVcIixcbiAgICAgICAgcmlnaHRJdGVtVmlzaWJpbGl0eTogXCJnb25lXCJcbiAgICB9XG5cbiAgICBmb3IgKGNvbnN0IGNlbGxJdGVtIG9mIGRhdGFDZWxsTGlzdCkge1xuICAgICAgICBpZiAoZmF2b3JpdGVEYXRhQ2VsbC5sZWZ0SXRlbSA9PSBudWxsKSB7XG4gICAgICAgICAgICBmYXZvcml0ZURhdGFDZWxsLmxlZnRJdGVtID0gY2VsbEl0ZW07XG4gICAgICAgICAgICBmYXZvcml0ZURhdGFDZWxsLmxlZnRJdGVtVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuICAgICAgICB9XG4gICAgICAgIGVsc2UgaWYgKGZhdm9yaXRlRGF0YUNlbGwucmlnaHRJdGVtID09IG51bGwpIHtcbiAgICAgICAgICAgIGZhdm9yaXRlRGF0YUNlbGwucmlnaHRJdGVtID0gY2VsbEl0ZW07XG4gICAgICAgICAgICBmYXZvcml0ZURhdGFDZWxsLnJpZ2h0SXRlbVZpc2liaWxpdHkgPSBcInZpc2libGVcIjtcbiAgICAgICAgICAgIGZhdm9yaXRlTGlzdC5wdXNoKGZhdm9yaXRlRGF0YUNlbGwpO1xuICAgICAgICAgICAgZmF2b3JpdGVEYXRhQ2VsbCA9IHtcbiAgICAgICAgICAgICAgICBjZWxsVHlwZTogXCJzcG90RmF2b3JpdGVcIixcbiAgICAgICAgICAgICAgICBsZWZ0SXRlbVZpc2liaWxpdHk6IFwiZ29uZVwiLFxuICAgICAgICAgICAgICAgIHJpZ2h0SXRlbVZpc2liaWxpdHk6IFwiZ29uZVwiXG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICB9XG4gICAgaWYgKGZhdm9yaXRlRGF0YUNlbGwubGVmdEl0ZW0gIT0gbnVsbCkge1xuICAgICAgICBmYXZvcml0ZUxpc3QucHVzaChmYXZvcml0ZURhdGFDZWxsKTtcbiAgICB9XG4gICAgdmFyIGZhdm9yaXRlQWRkQ2VsbCA9IHtcbiAgICAgICAgY2VsbFR5cGU6IFwiZmF2b3JpdGVBZGRcIixcbiAgICAgICAgZW5hYmxlQnV0dG9uOiBoYXNDaG9vc2UgPT0gdHJ1ZSA/IFwidmlzaWJsZVwiIDogXCJnb25lXCIsXG4gICAgICAgIGRpc2FibGVCdXR0b246IGhhc0Nob29zZSA9PSB0cnVlID8gXCJnb25lXCIgOiBcInZpc2libGVcIlxuICAgIH07XG4gICAgZmF2b3JpdGVMaXN0LnB1c2goZmF2b3JpdGVBZGRDZWxsKTtcbiAgICByZXR1cm4gZmF2b3JpdGVMaXN0O1xufVxuYXN5bmMgZnVuY3Rpb24gaGFuZGxlU2luZ2xlTGlzdERhdGEoaXRlbSkge1xuICAgIHZhciBkYXRhTWFwID0ge307XG4gICAgZGF0YU1hcC5saXN0VHlwZSA9IFwiMVwiO1xuICAgIGRhdGFNYXAudHlwZSA9IGl0ZW0udHlwZTtcbiAgICB2YXIgY2VsbExpc3QgPSBbXTtcbiAgICBpZiAoIWl0ZW0uc2NyZWVuKSB7Ly/ljZXmlbDnu4RcbiAgICAgICAgaWYgKGl0ZW0udHlwZSA9PSA5KSB7XG4gICAgICAgICAgICBjZWxsTGlzdCA9IGF3YWl0IGhhbmRsZUZhdm9yaXRlTGlzdChpdGVtKTtcbiAgICAgICAgfVxuICAgICAgICBlbHNlIHtcbiAgICAgICAgICAgIC8v6aG26YOo5qCH6aKYXG4gICAgICAgICAgICB2YXIgdGl0bGVzID0gaXRlbS50aXRsZTtcblxuICAgICAgICAgICAgY29uc3QgdGl0bGVDZWxsID0gaGVhZGVyQ2VsbEl0ZW1Gcm9tKHRpdGxlcywgXCJ0aXRsZVwiKTtcbiAgICAgICAgICAgIHRpdGxlQ2VsbC50eXBlID0gZGF0YU1hcC50eXBlO1xuICAgICAgICAgICAgY2VsbExpc3QucHVzaCh0aXRsZUNlbGwpO1xuICAgICAgICAgICAgLy/lpITnkIbmlbDmja5cbiAgICAgICAgICAgIHZhciBkYXRhQ2VsbExpc3QgPSBhd2FpdCBmaWx0ZXJMaXN0SXRlbXMoaXRlbS50eXBlLCBudWxsLCBpdGVtLnNpbmdsZUxpc3QpO1xuXG4gICAgICAgICAgICBpZiAoZGF0YUNlbGxMaXN0Lmxlbmd0aCA9PSAwKSB7XG4gICAgICAgICAgICAgICAgY2VsbExpc3QucHVzaChnZXRFbXB0eUNlbGwoaXRlbS50eXBlLCBudWxsKSk7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBlbHNlIHtcbiAgICAgICAgICAgICAgICBjZWxsTGlzdCA9IGNlbGxMaXN0LmNvbmNhdChkYXRhQ2VsbExpc3QpO1xuICAgICAgICAgICAgfVxuICAgICAgICB9XG4gICAgfVxuICAgIGVsc2Uge1xuICAgICAgICB2YXIgbWF4Q291bnQgPSAxMDtcbiAgICAgICAgZm9yICh2YXIgc2NyZWVuT2JqZWN0IG9mIGl0ZW0uc2NyZWVuTGlzdE9iamVjdCkge1xuICAgICAgICAgICAgY29uc3Qgc3ViVHlwZSA9IHNjcmVlbk9iamVjdC5zY3JlZW5WYWx1ZTtcbiAgICAgICAgICAgIHZhciBpdGVtTGlzdCA9IGl0ZW0ubXVsdGlwbGVNYXBbc3ViVHlwZV07XG4gICAgICAgICAgICBpZiAoZGF0YU1hcC50eXBlID09IDQpIHtcbiAgICAgICAgICAgICAgICBpZiAoc3ViVHlwZSA9PSBcInVudHJhZGVhYmxlXCIpIHtcbiAgICAgICAgICAgICAgICAgICAgaWYgKGl0ZW1MaXN0Lmxlbmd0aCA9PSAwKSB7Ly/lpoLmnpzlvoXkuIrmlrDluIHmlbDph4/kuLowIOWImeS4jeaYvuekulxuICAgICAgICAgICAgICAgICAgICAgICAgY29udGludWU7XG4gICAgICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgZWxzZSBpZiAoc3ViVHlwZSA9PSBcInRyYWRlYWJsZVwiKSB7XG4gICAgICAgICAgICAgICAgICAgIGlmIChjZWxsTGlzdC5sZW5ndGggPiAwKSB7Ly/lpoLmnpzlt7Lnu4/mnIljZWxs77yM6K+05piO5pyJ5b6F5LiK5paw5biBIOmcgOimgea3u+WKoOepuueahOWNoOS9jWNlbGxcbiAgICAgICAgICAgICAgICAgICAgICAgIHZhciBlbXB0eUNlbGwgPSB7IGNlbGxUeXBlOiBcInNwYWNlXCIgfTtcbiAgICAgICAgICAgICAgICAgICAgICAgIGNlbGxMaXN0LnB1c2goZW1wdHlDZWxsKTtcbiAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIC8v6aG26YOo5qCH6aKYXG4gICAgICAgICAgICBjb25zdCB0aXRsZXMgPSBpdGVtLnRpdGxlTWFwW3N1YlR5cGVdO1xuICAgICAgICAgICAgdmFyIHRpdGxlQ2VsbFR5cGU7XG4gICAgICAgICAgICBpZiAoZGF0YU1hcC50eXBlID09IDkgJiYgaXRlbS5zY3JlZW5MaXN0T2JqZWN0Lmxlbmd0aCA+IDEpIHsvL+iHqumAiSDlubbkuJTmlbDph4/lpKfkuo4x5LiqXG4gICAgICAgICAgICAgICAgaWYgKGN1cnJlbnRTY3JlZW4gPT0gbnVsbCkge1xuICAgICAgICAgICAgICAgICAgICBjdXJyZW50U2NyZWVuID0gc3ViVHlwZTtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgaWYgKHN1YlR5cGUgIT0gY3VycmVudFNjcmVlbikge1xuICAgICAgICAgICAgICAgICAgICBjb250aW51ZTtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgdGl0bGVDZWxsVHlwZSA9IFwiaW50ZXJhY3Rpb25UaXRsZVwiO1xuICAgICAgICAgICAgICAgIGZvciAoY29uc3Qgc2NyZWVuVGl0bGUgb2YgaXRlbS5zY3JlZW5MaXN0T2JqZWN0KSB7XG4gICAgICAgICAgICAgICAgICAgIGNvbnNvbGUubG9nKGBzY3JlZW5UaXRsZSA9ICR7c2NyZWVuVGl0bGV9YCk7XG4gICAgICAgICAgICAgICAgICAgIGlmIChzY3JlZW5UaXRsZS5zY3JlZW5WYWx1ZSA9PSBjdXJyZW50U2NyZWVuKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICB0aXRsZXNbMF0udGl0bGVOYW1lID0gc2NyZWVuVGl0bGUuc2NyZWVuVGl0bGU7XG4gICAgICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBlbHNlIHtcbiAgICAgICAgICAgICAgICB0aXRsZUNlbGxUeXBlID0gXCJ0aXRsZVwiO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgY29uc3QgdGl0bGVDZWxsID0gaGVhZGVyQ2VsbEl0ZW1Gcm9tKHRpdGxlcywgdGl0bGVDZWxsVHlwZSk7XG4gICAgICAgICAgICB0aXRsZUNlbGwudHlwZSA9IGRhdGFNYXAudHlwZTtcblxuICAgICAgICAgICAgdmFyIGRhdGFDZWxsTGlzdDtcbiAgICAgICAgICAgIGlmIChkYXRhTWFwLnR5cGUgPT0gNCAmJiBzdWJUeXBlID09IFwidW50cmFkZWFibGVcIikge1xuICAgICAgICAgICAgICAgIHZhciB1bnRyYWRlYWJsZU1heENvdW50ID0gMTA7XG4gICAgICAgICAgICAgICAgZGF0YUNlbGxMaXN0ID0gYXdhaXQgZmlsdGVyTGlzdEl0ZW1zKGl0ZW0udHlwZSwgc3ViVHlwZSwgaXRlbUxpc3QsIGRhdGFDb3VudCA9IHVudHJhZGVhYmxlTWF4Q291bnQsIGZhbHNlKTtcbiAgICAgICAgICAgICAgICBtYXhDb3VudCA9IG1heENvdW50IC0gZGF0YUNlbGxMaXN0Lmxlbmd0aCAtIDE7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBlbHNlIHtcbiAgICAgICAgICAgICAgICBkYXRhQ2VsbExpc3QgPSBhd2FpdCBmaWx0ZXJMaXN0SXRlbXMoaXRlbS50eXBlLCBzdWJUeXBlLCBpdGVtTGlzdCwgZGF0YUNvdW50ID0gbWF4Q291bnQsIHRydWUpO1xuICAgICAgICAgICAgfVxuXG4gICAgICAgICAgICBpZiAoZGF0YUNlbGxMaXN0Lmxlbmd0aCA9PSAwKSB7XG4gICAgICAgICAgICAgICAgaWYgKGRhdGFNYXAudHlwZSA9PSA0ICYmIHN1YlR5cGUgPT0gXCJ1bnRyYWRlYWJsZVwiKSB7XG4gICAgICAgICAgICAgICAgICAgIGNvbnRpbnVlO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICBjZWxsTGlzdC5wdXNoKHRpdGxlQ2VsbCk7XG4gICAgICAgICAgICAgICAgY2VsbExpc3QucHVzaChnZXRFbXB0eUNlbGwoaXRlbS50eXBlLCBzdWJUeXBlKSk7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBlbHNlIHtcbiAgICAgICAgICAgICAgICBjZWxsTGlzdC5wdXNoKHRpdGxlQ2VsbCk7XG4gICAgICAgICAgICAgICAgY2VsbExpc3QgPSBjZWxsTGlzdC5jb25jYXQoZGF0YUNlbGxMaXN0KTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgIH1cbiAgICBkYXRhTWFwLmRhdGEgPSBjZWxsTGlzdDtcbiAgICBpZiAoZGF0YU1hcC50eXBlID09IDkpIHtcbiAgICAgICAgZmF2b3JpdGVTY3JlZW5EYXRhW2N1cnJlbnRTY3JlZW5dID0gZGF0YU1hcDtcbiAgICB9XG4gICAgcmV0dXJuIGRhdGFNYXA7XG59XG5cbi8v6I635Y+W5oiQ5Lqk6aKd5pi+56S65paH5pysXG5hc3luYyBmdW5jdGlvbiBnZXRWb2x1bWVTdHIodm9sdW1lKSB7XG4gICAgaWYgKHZvbHVtZSA9PSBudWxsKSB7XG4gICAgICAgIHJldHVybiBcIi0tXCI7XG4gICAgfVxuICAgIGNvbnN0IHZvbHVtZVN0ciA9IGF3YWl0ICRuYXRpdmVBUEkuaG9tZUJyaWRnZSh7IGFjdGlvbjogXCJnZXRWb2x1bWVTdHJcIiwgZGF0YTogdm9sdW1lIH0pO1xuICAgIHJldHVybiB2b2x1bWVTdHI7XG59XG5cblxuLy/lpITnkIbmjqXlj6PmlbDmja5cbmFzeW5jIGZ1bmN0aW9uIGhhbmRsZVJhbmtpbmdMaXN0RGF0YShkYXRhKSB7XG4gICAgY29uc29sZS5sb2coJ2FsbCBzdGFydCcpO1xuXG4gICAgY29uc3QgZmlsdGVyTGlzdERhdGEgPSBkYXRhLmZpbHRlcigoaXRlbSkgPT4ge1xuICAgICAgICByZXR1cm4gdHJ1ZTtcbiAgICB9KTtcblxuICAgIHZhciBsaXN0RGF0YSA9IGF3YWl0IFByb21pc2UuYWxsKGZpbHRlckxpc3REYXRhLm1hcChhc3luYyAoaXRlbSkgPT4ge1xuICAgICAgICB2YXIgZGF0YU1hcCA9IGF3YWl0IGhhbmRsZVNpbmdsZUxpc3REYXRhKGl0ZW0pO1xuICAgICAgICByZXR1cm4gZGF0YU1hcDtcbiAgICB9KSk7XG5cbiAgICB2YXIgdGl0bGVEYXRhID0gW107XG4gICAgZm9yICh2YXIgaSA9IDA7IGkgPCBmaWx0ZXJMaXN0RGF0YS5sZW5ndGg7IGkrKykge1xuICAgICAgICB2YXIgaXRlbSA9IGZpbHRlckxpc3REYXRhW2ldO1xuICAgICAgICB2YXIgY29sb3IgPSB0aXRsZUNvbG9yX05vcm1hbDtcbiAgICAgICAgdmFyIGZvbnQgPSB0aXRsZUZvbnRfTm9ybWFsO1xuXG4gICAgICAgIGlmIChpID09IHBhcnNlSW50KCRkYXRhLnJhbmtpbmcuY3VycmVudEluZGV4KSkge1xuICAgICAgICAgICAgY29sb3IgPSB0aXRsZUNvbG9yX1NlbGVjdGVkO1xuICAgICAgICAgICAgZm9udCA9IHRpdGxlRm9udF9TZWxlY3RlZDtcbiAgICAgICAgfVxuICAgICAgICB2YXIgdGFnID0gU3RyaW5nKDEwMCArIGkpO1xuICAgICAgICB2YXIgcG9pbnRWaXNpYmlsaXR5ID0gXCJnb25lXCI7XG4gICAgICAgIGlmIChpdGVtLnR5cGUgPT0gNCkge1xuICAgICAgICAgICAgY29uc3QgaW5kZXggPSBwYXJzZUludCgkZGF0YS5yYW5raW5nLmN1cnJlbnRJbmRleCk7XG4gICAgICAgICAgICBpZiAoaSA9PSBpbmRleCkge1xuICAgICAgICAgICAgICAgIGNvbnNvbGUubG9nKGBwb2ludFZpc2liaWxpdHkgIOW9k+WJjeWcqOaWsOW4geamnO+8jOebtOaOpeabtOaWsOacgOaWsOaXtumXtCA9ICR7bGF0ZXN0VXBDb2luVGltZX1gKTtcbiAgICAgICAgICAgICAgICBhd2FpdCBjb21tb24uc2F2ZShcInJhbmtpbmdcIiwgXCJsYXRlc3RVcFwiLCBTdHJpbmcobGF0ZXN0VXBDb2luVGltZSkpO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICAgICAgY29uc3QgbGF0ZXN0VXBDYWNoZSA9IGF3YWl0IGNvbW1vbi5yZWFkKFwicmFua2luZ1wiLCBcImxhdGVzdFVwXCIpXG4gICAgICAgICAgICAgICAgaWYgKGxhdGVzdFVwQ2FjaGUgIT0gbnVsbCkge1xuICAgICAgICAgICAgICAgICAgICBjb25zdCBsYXRlc3RVcENhY2hlVGltZSA9IHBhcnNlSW50KGxhdGVzdFVwQ2FjaGUpO1xuICAgICAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhgcG9pbnRWaXNpYmlsaXR5ICDnvJPlrZjml7bpl7QgPSAke2xhdGVzdFVwQ2FjaGVUaW1lfWApO1xuICAgICAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhgcG9pbnRWaXNpYmlsaXR5ICDlvZPliY3mnIDmlrDml7bpl7QgPSAke2xhdGVzdFVwQ29pblRpbWV9YCk7XG4gICAgICAgICAgICAgICAgICAgIGlmIChsYXRlc3RVcENvaW5UaW1lID4gbGF0ZXN0VXBDYWNoZVRpbWUpIHsvL+acieaWsOeahOW4gVxuICAgICAgICAgICAgICAgICAgICAgICAgcG9pbnRWaXNpYmlsaXR5ID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICB9XG4gICAgICAgIH0gZWxzZSBpZiAoaXRlbS50eXBlID09IDEwKSB7XG4gICAgICAgICAgICBpZiAobWFya2V0UmFua0hpbnQpIHtcbiAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhgbWFya2V0UmFua0hpbnQgPSA0NDQ0LCBtYXJrZXRSYW5rSGludD09JHttYXJrZXRSYW5rSGludH1gKTtcbiAgICAgICAgICAgICAgICBjb25zdCBoaW50ID0gYXdhaXQgY29tbW9uLnJlYWQoXCJyYW5raW5nXCIsIFwibWFya2V0X2NhcF90aXBcIik7XG4gICAgICAgICAgICAgICAgaWYgKGhpbnQgPT0gbnVsbCkge1xuICAgICAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhgbWFya2V0UmFua0hpbnQgPSA1NTU1LCBtYXJrZXRSYW5rSGludD09JHttYXJrZXRSYW5rSGludH1gKTtcbiAgICAgICAgICAgICAgICAgICAgcG9pbnRWaXNpYmlsaXR5ID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICAgICAgY29uc29sZS5sb2coYG1hcmtldFJhbmtIaW50ID0gNjY2NiwgbWFya2V0UmFua0hpbnQ9PSR7bWFya2V0UmFua0hpbnR9YCk7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgfVxuICAgICAgICB9XG4gICAgICAgIHZhciB0aXRsZUl0ZW0gPSB7XG4gICAgICAgICAgICB0eXBlOiBpdGVtLnR5cGUsXG4gICAgICAgICAgICB0aXRsZTogaXRlbS50eXBlVGl0bGUsXG4gICAgICAgICAgICB0aXRsZUNvbG9yOiBjb2xvcixcbiAgICAgICAgICAgIHRpdGxlU2l6ZTogZm9udCxcbiAgICAgICAgICAgIHBvaW50VmlzaWJpbGl0eTogcG9pbnRWaXNpYmlsaXR5LFxuICAgICAgICAgICAgdGFnOiB0YWdcbiAgICAgICAgfTtcbiAgICAgICAgdGl0bGVEYXRhLnB1c2godGl0bGVJdGVtKTtcbiAgICB9XG5cbiAgICBzZXR1cFByb2Nlc3NlZFRpdGxlRGF0YSh0aXRsZURhdGEpXG4gICAgc2V0dXBQcm9jZXNzZWRMaXN0RGF0YShsaXN0RGF0YSlcblxuICAgIGF3YWl0IGNvbW1vbi5zZXRNb2R1bGVTdGF0dXMoXCJyYW5raW5nXCIsIDEpO1xuXG4gICAgZm9yIChjb25zdCB0aXRsZUl0ZW0gb2YgdGl0bGVEYXRhKSB7XG4gICAgICAgIC8v6I635Y+W5pu05aSa5oyJ6ZKu55qE54K55Ye75pWw5o2uXG4gICAgICAgIHZhciBzdWJUeXBlU3RyID0gbnVsbDtcbiAgICAgICAgaWYgKHRpdGxlSXRlbS50eXBlID09IDkpIHtcbiAgICAgICAgICAgIHN1YlR5cGVTdHIgPSBjdXJyZW50U2NyZWVuO1xuICAgICAgICB9XG4gICAgICAgIGF3YWl0IGdldE1vcmVBY3Rpb25EYXRhKHRpdGxlSXRlbS50eXBlLCBzdWJUeXBlU3RyKTtcbiAgICB9XG5cbiAgICBpZiAobmV3TGlzdE5lZWRSZWZyZXNoID09IHRydWUpIHtcbiAgICAgICAgdmFyIG5vdyA9IG5ldyBEYXRlKCkuZ2V0VGltZSgpO1xuICAgICAgICBpZiAobm93IC0gbGFzdFRpbWUgPiAzMDAwKSB7XG4gICAgICAgICAgICBhd2FpdCByZXF1ZXN0UmFua2luZ0RhdGEoKTtcbiAgICAgICAgfVxuICAgIH1cbiAgICBjb25zb2xlLmxvZygnYWxsIGRvbmUgJyk7XG59XG5cbmZ1bmN0aW9uIHNldHVwUHJvY2Vzc2VkVGl0bGVEYXRhKG5ld1RpdGxlRGF0YSkge1xuICAgICRkYXRhLnJhbmtpbmcudGl0bGVEYXRhID0gbmV3VGl0bGVEYXRhO1xufVxuXG5mdW5jdGlvbiBzZXR1cFByb2Nlc3NlZExpc3REYXRhKG5ld0xpc3REYXRhKSB7XG4gICAgJGRhdGEucmFua2luZy5saXN0RGF0YSA9IG5ld0xpc3REYXRhO1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gcmVxdWVzdFJhbmtpbmdEYXRhKCkge1xuICAgIG5ld0xpc3ROZWVkUmVmcmVzaCA9IGZhbHNlO1xuICAgIHZhciBwYXJhbXMgPSB7fTtcbiAgICBjb25zdCBmYXZvcml0ZXMgPSBhd2FpdCBnZXRMb2NhbEZhdm9yaXRlcygpO1xuICAgIGlmIChmYXZvcml0ZXMubGVuZ3RoID4gMCkge1xuICAgICAgICBwYXJhbXMuZmF2b3JpdGVzID0gSlNPTi5wYXJzZShmYXZvcml0ZXMpO1xuICAgIH1cbiAgICBlbHNlIHtcbiAgICAgICAgcGFyYW1zLmZhdm9yaXRlcyA9IFtdO1xuICAgIH1cbiAgICB2YXIgaGVhZGVyID0geyAnQ29udGVudC1UeXBlJzogJ2FwcGxpY2F0aW9uL2pzb24nIH07XG4gICAgb3JpZ2luRGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdChcInYxL2FwcC9uZXcvcmFua2luZ0xpc3QvdjNcIiwgcGFyYW1zID0gcGFyYW1zLCBtZXRob2QgPSAxLCBob3N0VHlwZSA9IDAsIGhlYWRlciA9IGhlYWRlcik7XG4gICAgaWYgKG9yaWdpbkRhdGEgIT0gbnVsbCkge1xuICAgICAgICBhd2FpdCBoYW5kbGVSYW5raW5nTGlzdERhdGEob3JpZ2luRGF0YSk7XG4gICAgICAgIGlmIChuZWVkQW5hbHl0aWNzV2hlblJlcXVlc3RTdWNjZXNzID09IHRydWUpIHtcbiAgICAgICAgICAgIGF3YWl0IGFuYWx5dGljc0FwcGVhcigpO1xuICAgICAgICB9XG4gICAgfVxuICAgIGVsc2UgaWYgKCRkYXRhLnJhbmtpbmcubGlzdERhdGEgPT0gbnVsbCkge1xuICAgICAgICBhd2FpdCBjb21tb24uc2V0TW9kdWxlU3RhdHVzKFwicmFua2luZ1wiLCAwKTtcbiAgICB9XG4gICAgbGFzdFRpbWUgPSBuZXcgRGF0ZSgpLmdldFRpbWUoKTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gZ2V0TW9yZUFjdGlvbkRhdGEodHlwZSA9IFwiXCIsIHN1YlR5cGUgPSBcIlwiKSB7XG4gICAgaWYgKHBhcnNlSW50KHR5cGUpID09IDIgfHwgcGFyc2VJbnQodHlwZSkgPT0gNSkge1xuICAgICAgICBzdWJUeXBlID0gXCJzcG90XCI7XG4gICAgfVxuICAgIHZhciBrZXkgPSBgJHt0eXBlfV8ke3N1YlR5cGV9YDtcbiAgICB2YXIgYWN0aW9uRGF0YSA9IG1vcmVBY3Rpb25EYXRhTWFwW2tleV07XG4gICAgaWYgKGFjdGlvbkRhdGEgPT0gbnVsbCkge1xuICAgICAgICBhd2FpdCByZXF1ZXN0TW9yZUFjdGlvbkRhdGEodHlwZSwgc3ViVHlwZSk7XG4gICAgfVxuICAgIGFjdGlvbkRhdGEgPSBtb3JlQWN0aW9uRGF0YU1hcFtrZXldO1xuICAgIHJldHVybiBhY3Rpb25EYXRhO1xufVxuXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0TW9yZUFjdGlvbkRhdGEodHlwZSA9IFwiXCIsIHN1YlR5cGUgPSBcInNwb3RcIikge1xuICAgIHZhciBwYXJhbSA9IHsgdHlwZTogU3RyaW5nKHR5cGUpLCBcInNjcmVlblwiOiBzdWJUeXBlIH07XG4gICAgdmFyIGtleSA9IGAke3R5cGV9XyR7c3ViVHlwZX1gO1xuICAgIG1vcmVBY3Rpb25EYXRhTWFwW2tleV0gPSBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3QoXCJ2MS9hcHAvanVtcC9pbmZvXCIsIHBhcmFtcyA9IHBhcmFtKTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gdXBkYXRlRmF2b3JpdGVzU3ltYm9scyhzeW1ib2xzID0gW10pIHtcbiAgICB2YXIgcGFyYW1zID0geyB0cmFkaW5nUGFpcnM6IHN5bWJvbHMsIHdlYnNpdGU6IFwiUFJPXCIgfTtcbiAgICBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3QoXCJ1Yy9vcGVuL3RyYWRpbmdfcGFpci9tdWx0aXBsZS9hZGRcIiwgcGFyYW1zLCAxLCA1LCB7fSk7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlc2V0RmF2b3JpdGVzTGlzdERhdGEoKSB7XG4gICAgY29uc29sZS5sb2coYGN1cnJlbnRTY3JlZW4gPSAke2N1cnJlbnRTY3JlZW59YCk7XG4gICAgdmFyIGRhdGFNYXAgPSBmYXZvcml0ZVNjcmVlbkRhdGFbY3VycmVudFNjcmVlbl07XG4gICAgaWYgKGRhdGFNYXAgPT0gbnVsbCkge1xuICAgICAgICBmb3IgKGNvbnN0IGl0ZW0gb2Ygb3JpZ2luRGF0YSkge1xuICAgICAgICAgICAgaWYgKGl0ZW0udHlwZSA9PSA5KSB7XG4gICAgICAgICAgICAgICAgZGF0YU1hcCA9IGF3YWl0IGhhbmRsZVNpbmdsZUxpc3REYXRhKGl0ZW0pO1xuICAgICAgICAgICAgICAgIGZhdm9yaXRlU2NyZWVuRGF0YVtjdXJyZW50U2NyZWVuXSA9IGRhdGFNYXA7XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICB9XG5cbiAgICBmb3IgKHZhciBpID0gMDsgaSA8ICRkYXRhLnJhbmtpbmcubGlzdERhdGEubGVuZ3RoOyBpKyspIHtcbiAgICAgICAgdmFyIGRhdGEgPSAkZGF0YS5yYW5raW5nLmxpc3REYXRhW2ldO1xuICAgICAgICBpZiAoZGF0YS50eXBlID09IDkpIHtcbiAgICAgICAgICAgIGRhdGEuZGF0YSA9IGRhdGFNYXAuZGF0YTtcbiAgICAgICAgICAgIHJldHVybjtcbiAgICAgICAgfVxuICAgIH1cblxufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gY2hlY2tSZXF1ZXN0VGltZXIoKSB7XG4gICAgaWYgKG1vZHVsZURpZFN0YXJ0ID09IGZhbHNlKSB7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgY29uc3QgY3VycmVudFRpbWUgPSBuZXcgRGF0ZSgpLmdldFRpbWUoKTtcblxuICAgIC8vIDYw56eS5Yi35paw5LiA5qyhXG4gICAgaWYgKGN1cnJlbnRUaW1lIC0gbGFzdFRpbWUgPiA2MCAqIDEwMDApIHtcbiAgICAgICAgYXdhaXQgcmVxdWVzdFJhbmtpbmdEYXRhKCk7XG4gICAgfVxuICAgIHJlc2V0V2lsbFVwQ2VsbEluVGltZXIoKTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gcmVzZXRXaWxsVXBDZWxsSW5UaW1lcigpIHtcbiAgICBmb3IgKGxldCBpID0gMDsgaSA8ICRkYXRhLnJhbmtpbmcubGlzdERhdGEubGVuZ3RoOyBpKyspIHtcbiAgICAgICAgdmFyIGRhdGFNYXAgPSAkZGF0YS5yYW5raW5nLmxpc3REYXRhW2ldO1xuICAgICAgICBmb3IgKGxldCBqID0gMDsgaiA8IGRhdGFNYXAuZGF0YS5sZW5ndGg7IGorKykge1xuICAgICAgICAgICAgdmFyIGNlbGxEYXRhID0gZGF0YU1hcC5kYXRhW2pdO1xuICAgICAgICAgICAgaWYgKGNlbGxEYXRhLmNlbGxUeXBlID09IFwid2lsbFVwXCIpIHtcbiAgICAgICAgICAgICAgICB2YXIgdGltZU1hcCA9IGdldENvdW50RG93bk1hcChjZWxsRGF0YS5iZWdpbkRhdGUpO1xuICAgICAgICAgICAgICAgIGNlbGxEYXRhLmRheSA9IHRpbWVNYXAuZGF5O1xuICAgICAgICAgICAgICAgIGNlbGxEYXRhLmhvdXIgPSB0aW1lTWFwLmhvdXI7XG4gICAgICAgICAgICAgICAgY2VsbERhdGEubWludXRlID0gdGltZU1hcC5taW51dGU7XG4gICAgICAgICAgICAgICAgY2VsbERhdGEuc2Vjb25kID0gdGltZU1hcC5zZWNvbmQ7XG4gICAgICAgICAgICAgICAgY2VsbERhdGEuc2hvd0RheSA9IHRpbWVNYXAuc2hvd0RheTtcbiAgICAgICAgICAgICAgICBpZiAodGltZU1hcC5pc1plcm8pIHtcbiAgICAgICAgICAgICAgICAgICAgbmV3TGlzdE5lZWRSZWZyZXNoID0gdHJ1ZTtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICB9XG4gICAgaWYgKG5ld0xpc3ROZWVkUmVmcmVzaCA9PSB0cnVlKSB7XG4gICAgICAgIHZhciBub3cgPSBuZXcgRGF0ZSgpLmdldFRpbWUoKTtcbiAgICAgICAgaWYgKG5vdyAtIGxhc3RUaW1lID4gMzAwMCkge1xuICAgICAgICAgICAgYXdhaXQgcmVxdWVzdFJhbmtpbmdEYXRhKCk7XG4gICAgICAgIH1cbiAgICB9XG59XG5cbmZ1bmN0aW9uIGdldENvdW50RG93bk1hcChkYXRlKSB7XG4gICAgY29uc3QgYmVnaW5EYXRlID0gbmV3IERhdGUoZGF0ZSkuZ2V0VGltZSgpO1xuICAgIGNvbnN0IG5ld0RhdGUgPSBuZXcgRGF0ZSgpLmdldFRpbWUoKSArIGNvbW1vbi5jb21tYW5EYXRhLnNlcnZpY2VUaW1lSW50ZXJ2YWw7XG5cbiAgICBjb25zdCBtaWxsaXNlY29uZHMgPSBiZWdpbkRhdGUgLSBuZXdEYXRlO1xuICAgIGNvbnN0IGludGVydmFsID0gbWlsbGlzZWNvbmRzIC8gMTAwMDtcblxuICAgIGlmIChpbnRlcnZhbCA8PSAwKSB7XG4gICAgICAgIHJldHVybiB7XG4gICAgICAgICAgICBkYXk6ICcwMCcsXG4gICAgICAgICAgICBob3VyOiAnMDAnLFxuICAgICAgICAgICAgbWludXRlOiAnMDAnLFxuICAgICAgICAgICAgc2Vjb25kOiAnMDAnLFxuICAgICAgICAgICAgc2hvd0RheTogJ2dvbmUnLFxuICAgICAgICAgICAgaXNaZXJvOiB0cnVlXG4gICAgICAgIH07XG4gICAgfVxuXG4gICAgbGV0IGQgPSBwYXJzZUludChpbnRlcnZhbCAvIDYwIC8gNjAgLyAyNCk7XG4gICAgbGV0IGRheSA9IGQgPCAxMCA/IGAwJHtkfWAgOiBgJHtkfWA7XG5cbiAgICBsZXQgaCA9IHBhcnNlSW50KGludGVydmFsIC8gNjAgLyA2MCAlIDI0KTtcbiAgICBsZXQgaG91ciA9IGggPCAxMCA/IGAwJHtofWAgOiBgJHtofWA7XG5cbiAgICBsZXQgbSA9IHBhcnNlSW50KGludGVydmFsIC8gNjAgJSA2MCk7XG4gICAgbGV0IG1pbnV0ZSA9IG0gPCAxMCA/IGAwJHttfWAgOiBgJHttfWA7XG5cbiAgICBsZXQgcyA9IHBhcnNlSW50KGludGVydmFsICUgNjApO1xuICAgIGxldCBzZWNvbmQgPSBzIDwgMTAgPyBgMCR7c31gIDogYCR7c31gO1xuXG4gICAgdmFyIHNob3dEYXkgPSBkID4gMCA/IFwidmlzaWJsZVwiIDogJ2dvbmUnO1xuICAgIHZhciBpc1plcm8gPSBkICsgaCArIG0gKyBzID4gMCA/IGZhbHNlIDogdHJ1ZTtcbiAgICByZXR1cm4ge1xuICAgICAgICBkYXksXG4gICAgICAgIGhvdXIsXG4gICAgICAgIG1pbnV0ZSxcbiAgICAgICAgc2Vjb25kLFxuICAgICAgICBzaG93RGF5LFxuICAgICAgICBpc1plcm9cbiAgICB9O1xufVxuXG5leHBvcnQgZnVuY3Rpb24gcmVzZXRNYXJrZXREYXRhKCkge1xuICAgIGlmIChtb2R1bGVEaWRTdGFydCA9PSBmYWxzZSkge1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIGNvbnNvbGUubG9nKFwicmVzZXRNYXJrZXREYXRhXCIpO1xuICAgIGZvciAobGV0IGkgPSAwOyBpIDwgJGRhdGEucmFua2luZy5saXN0RGF0YS5sZW5ndGg7IGkrKykge1xuICAgICAgICB2YXIgZGF0YU1hcCA9ICRkYXRhLnJhbmtpbmcubGlzdERhdGFbaV07XG4gICAgICAgIGZvciAobGV0IGogPSAwOyBqIDwgZGF0YU1hcC5kYXRhLmxlbmd0aDsgaisrKSB7XG4gICAgICAgICAgICB2YXIgY2VsbERhdGEgPSBkYXRhTWFwLmRhdGFbal07XG4gICAgICAgICAgICBpZiAoY2VsbERhdGEuY2VsbFR5cGUgPT0gXCJub3JtYWxcIlxuICAgICAgICAgICAgICAgIHx8IGNlbGxEYXRhLmNlbGxUeXBlID09IFwiZGVhbFwiXG4gICAgICAgICAgICAgICAgfHwgY2VsbERhdGEuY2VsbFR5cGUgPT0gXCJtYXJrZXRcIlxuICAgICAgICAgICAgICAgIHx8IGNlbGxEYXRhLmNlbGxUeXBlID09IFwibmV3XCJcbiAgICAgICAgICAgICAgICB8fCBjZWxsRGF0YS5jZWxsVHlwZSA9PSBcIndpbGxVcFwiXG4gICAgICAgICAgICAgICAgfHwgY2VsbERhdGEuY2VsbFR5cGUgPT0gXCJmdXR1cmVcIikge1xuICAgICAgICAgICAgICAgIGNvbnN0IHN5bWJvbEluZm8gPSBjb21tb24uZ2V0U3ltYm9sSW5mbyhjZWxsRGF0YS5zeW1ib2wpO1xuICAgICAgICAgICAgICAgIGNvbnN0IGNvaW5EaWN0ID0gY29tbW9uLmNvbW1hbkRhdGEubWFya2V0RGF0YVtjZWxsRGF0YS5zeW1ib2xdO1xuICAgICAgICAgICAgICAgIGlmIChjb2luRGljdCA9PSBudWxsKSB7XG4gICAgICAgICAgICAgICAgICAgIGNvbnRpbnVlO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICB2YXIgcHJpY2UgPSBjb2luRGljdC5kZWNpbWFsY1ByaWNlO1xuXG4gICAgICAgICAgICAgICAgaWYgKHByaWNlID4gMCkge1xuICAgICAgICAgICAgICAgICAgICB2YXIgcHJpY2VTdHIgPSBjb21tb24uZ2V0UHJpY2VTdHJpbmcocHJpY2UsIHN5bWJvbEluZm8udHJhZGVQcmljZVByZWNpc2lvbik7XG4gICAgICAgICAgICAgICAgICAgIGlmIChjZWxsRGF0YS5jZWxsVHlwZSA9PSBcImZ1dHVyZVwiKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICBjZWxsRGF0YS5wcmljZSA9IGdldFByaWNlU3ltYm9sKHN5bWJvbEluZm8ucXVvdGVDdXJyZW5jeURpc3BsYXlOYW1lKSArIHByaWNlU3RyO1xuICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICAgICAgY2VsbERhdGEucHJpY2UgPSBwcmljZVN0cjtcbiAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICB2YXIgdHlwZSA9IHBhcnNlSW50KGNlbGxEYXRhLnR5cGUpO1xuICAgICAgICAgICAgICAgIGlmICh0eXBlID09IDEgfHwgdHlwZSA9PSA1IHx8IHR5cGUgPT0gNiB8fCB0eXBlID09IDkpIHsvLzE65rao5bmF5qacIDXvvJrng63mppwgNu+8mui3jOW5heamnFxuICAgICAgICAgICAgICAgICAgICB2YXIgcmF0aW8gPSAwO1xuICAgICAgICAgICAgICAgICAgICBpZiAoTWF0aC5hYnMoY29pbkRpY3QuZGVjaW1hbERlbHRhKSA+PSAwKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICByYXRpbyA9IGNvaW5EaWN0LmRlY2ltYWxEZWx0YTtcbiAgICAgICAgICAgICAgICAgICAgICAgIHZhciBwcmVmaXggPSByYXRpbyA+IDAgPyBcIitcIiA6IFwiXCI7XG4gICAgICAgICAgICAgICAgICAgICAgICBjZWxsRGF0YS5yYXRpbyA9IGAke3ByZWZpeH0ke3JhdGlvLnRvRml4ZWQoMikudG9TdHJpbmcoKX0lYDtcbiAgICAgICAgICAgICAgICAgICAgICAgIGNlbGxEYXRhLmNvbG9ySGV4ID0gY29tbW9uLmdldFByaWNlQ29sb3IocmF0aW8pO1xuICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgfVxuICAgICAgICB9XG5cbiAgICB9XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiByZXNldE1hcmtldFRpdGxlKCkge1xuICAgIGlmIChtb2R1bGVEaWRTdGFydCA9PSBmYWxzZSkge1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIGZvciAobGV0IGkgPSAwOyBpIDwgJGRhdGEucmFua2luZy5saXN0RGF0YS5sZW5ndGg7IGkrKykge1xuICAgICAgICB2YXIgZGF0YU1hcCA9ICRkYXRhLnJhbmtpbmcubGlzdERhdGFbaV07XG4gICAgICAgIGZvciAobGV0IGogPSAwOyBqIDwgZGF0YU1hcC5kYXRhLmxlbmd0aDsgaisrKSB7XG4gICAgICAgICAgICB2YXIgY2VsbERhdGEgPSBkYXRhTWFwLmRhdGFbal07XG4gICAgICAgICAgICBpZiAoY2VsbERhdGEuY2VsbFR5cGUgPT0gXCJ0aXRsZVwiICYmIChjZWxsRGF0YS5yaWdodFRpdGxlLnRpdGxlUHJvcGVydHkgPT0gNiB8fCBjZWxsRGF0YS5yaWdodFRpdGxlLnRpdGxlUHJvcGVydHkgPT0gNykpIHtcbiAgICAgICAgICAgICAgICBjZWxsRGF0YS5yaWdodFRpdGxlLnRpdGxlTmFtZSA9IGAke2NlbGxEYXRhLnJpZ2h0VGl0bGUub3JpZ2luVGl0bGVOYW1lfSgke2NvbW1vbi5jb21tYW5EYXRhLnJhdGVUeXBlU3RyfSlgXG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICB9XG59XG5cbi8vIGFjdGlvblxuYXN5bmMgZnVuY3Rpb24gcmFua2luZ0NsaWNrZWQoc3ltYm9sLCBhbmFseXRpY3NKc29uLCBvcmlnaW5JdGVtSnNvbikge1xuICAgIGNvbnN0IG9yaWdpbkl0ZW0gPSBKU09OLnBhcnNlKG9yaWdpbkl0ZW1Kc29uKTtcbiAgICBjb25zdCBhbmFseXRpY3MgPSBKU09OLnBhcnNlKGFuYWx5dGljc0pzb24pO1xuICAgIGF3YWl0IGNvbW1vbi5vcGVuUGFnZShcImtsaW5lXCIsIHsgc3ltYm9sLCBvcmlnaW5JdGVtIH0pO1xuXG4gICAgYXdhaXQgY29tbW9uLmFuYWx5dGljcyhcImFwcENsaWNrX2hvbWVcIiwge1xuICAgICAgICBtb2R1bGVfbmFtZTogXCJ0b3BsaXN0XCIsXG4gICAgICAgIG1vZHVsZV9wb3NpdGlvbjogYW5hbHl0aWNzLm1vZHVsZV9wb3NpdGlvbixcbiAgICAgICAgbmFtZTogYW5hbHl0aWNzLm5hbWUsXG4gICAgICAgIGxpc3RfdHlwZTogYW5hbHl0aWNzLmxpc3RfdHlwZSxcbiAgICAgICAgc3RhdHVzOiBhbmFseXRpY3Muc3RhdHVzXG4gICAgfSk7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIG1vcmVCdXR0b25DbGlja2VkKHR5cGVTdHIsIHN1YlR5cGVTdHIsIGFuYWx5dGljc0pzb24pIHtcbiAgICB2YXIgdHlwZSA9IHBhcnNlSW50KHR5cGVTdHIpO1xuICAgIHZhciBhY3Rpb25EYXRhID0gYXdhaXQgZ2V0TW9yZUFjdGlvbkRhdGEodHlwZVN0ciwgc3ViVHlwZVN0cik7XG4gICAgaWYgKGFjdGlvbkRhdGEgIT0gbnVsbCkge1xuICAgICAgICBjb25zdCB0YXJnZXQgPSBwYXJzZUludChhY3Rpb25EYXRhLnRhcmdldCk7XG4gICAgICAgIGlmICgodHlwZSA9PSAxIHx8IHR5cGUgPT0gMiB8fCB0eXBlID09IDQgfHwgdHlwZSA9PSA1IHx8IHR5cGUgPT0gNiB8fCB0eXBlID09IDEwKSAmJiB0YXJnZXQgPT0gMSkge1xuICAgICAgICAgICAgYXdhaXQgY29tbW9uLm9wZW5QYWdlKFwiYWxsUmFua2luZ1wiLCB7IHR5cGUgfSk7XG4gICAgICAgIH1cbiAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICBjb25zdCBoNVVybCA9IGFjdGlvbkRhdGEuaDVVcmw7XG4gICAgICAgICAgICBjb25zdCBqdW1wVHlwZSA9IHBhcnNlSW50KGFjdGlvbkRhdGEudHlwZSk7XG4gICAgICAgICAgICBpZiAoaDVVcmwgIT0gbnVsbCAmJiBoNVVybC5sZW5ndGggPiAwICYmIGp1bXBUeXBlID09IDEpIHtcbiAgICAgICAgICAgICAgICBhd2FpdCBjb21tb24ub3BlblVSTChoNVVybCk7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBlbHNlIHtcbiAgICAgICAgICAgICAgICBjb25zdCBwcmltYXJ5VGl0bGUgPSBwYXJzZUludChhY3Rpb25EYXRhLnByaW1hcnlUaXRsZSk7XG4gICAgICAgICAgICAgICAgaWYgKHByaW1hcnlUaXRsZSA8IDEgfHwgcHJpbWFyeVRpdGxlID4gMykge1xuICAgICAgICAgICAgICAgICAgICBhY3Rpb25EYXRhLmZpbHRlciA9IFwiMVwiO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICBlbHNlIGlmIChwcmltYXJ5VGl0bGUgPT0gMSkge1xuICAgICAgICAgICAgICAgICAgICBhY3Rpb25EYXRhLmhiX2lzUmFua2luZ0xpc3RGYXZvdXJpdGVzID0gdHJ1ZTtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgLy/nu5PlsYDooYzmg4Xpobbpg6jntKLlvJXkvY3nva7lj5jmm7TlkI7vvIzpppbpobXmppzljZXot7PovazooYzmg4Xml7bmnaHku7bkuI3mu6HnmoTpl67pophcbiAgICAgICAgICAgICAgICBpZiAoY29tbW9uLmNvbW1hbkRhdGEuT1MgPT0gMCkgeyBcbiAgICAgICAgICAgICAgICAgICAgaWYgKHByaW1hcnlUaXRsZSA9PSAwKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICBhY3Rpb25EYXRhLmhiX2lzUmFua2luZ0xpc3RGYXZvdXJpdGVzID0gdHJ1ZTtcbiAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICBhY3Rpb25EYXRhLmhiX2lzUmFua2luZ0xpc3RGdXR1cmUgPSB0cnVlO1xuICAgICAgICAgICAgICAgIGF3YWl0IGNvbW1vbi5vcGVuUGFnZShcInJhbmtpbmdUb01hcmtldFwiLCBhY3Rpb25EYXRhKTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgIH1cbiAgICBjb25zdCBhbmFseXRpY3MgPSBKU09OLnBhcnNlKGFuYWx5dGljc0pzb24pO1xuICAgIGF3YWl0IGNvbW1vbi5hbmFseXRpY3MoXCJhcHBDbGlja19ob21lXCIsIHtcbiAgICAgICAgbW9kdWxlX25hbWU6IFwidG9wbGlzdFwiLFxuICAgICAgICBuYW1lOiBcIk1vcmVcIixcbiAgICAgICAgbGlzdF90eXBlOiBhbmFseXRpY3MubGlzdF90eXBlXG4gICAgfSk7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIGludGVyYWN0aW9uVGl0bGVDbGljaygpIHtcbiAgICBmb3IgKGNvbnN0IGl0ZW0gb2Ygb3JpZ2luRGF0YSkge1xuICAgICAgICBpZiAoaXRlbS50eXBlID09IDkpIHtcbiAgICAgICAgICAgIGZvciAoY29uc3Qgc2NyZWVuTWFwIG9mIGl0ZW0uc2NyZWVuTGlzdE9iamVjdCkge1xuICAgICAgICAgICAgICAgICRkYXRhLnJhbmtpbmdwb3Bbc2NyZWVuTWFwLnNjcmVlblZhbHVlXSA9IHtcbiAgICAgICAgICAgICAgICAgICAgbGlzdFR5cGU6IFwiMVwiLFxuICAgICAgICAgICAgICAgICAgICBuYW1lOiBzY3JlZW5NYXAuc2NyZWVuVGl0bGUsXG4gICAgICAgICAgICAgICAgICAgIHNjcmVlblRpdGxlOiBzY3JlZW5NYXAuc2NyZWVuVmFsdWUsXG4gICAgICAgICAgICAgICAgICAgIGNvbG9yOiBzY3JlZW5NYXAuc2NyZWVuVmFsdWUgPT0gY3VycmVudFNjcmVlbiA/IFwiIzAxNzNFNVwiIDogXCIjNTY1NjU2XCJcbiAgICAgICAgICAgICAgICB9O1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgJGRhdGEucmFua2luZ3BvcC5wb3BzaG93ID0gdHJ1ZTtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGBzaG93UG9wYCk7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgfVxuICAgIH1cbn1cblxuYXN5bmMgZnVuY3Rpb24gc2VsZWN0ZWRGYXZvcml0ZVN5bWJvbChzeW1ib2wgPSBcIlwiKSB7XG4gICAgdmFyIGltYWdlTmFtZSA9IGZhdm9yaXRlc1NlbGVjdEltYWdlTWFwW3N5bWJvbF07XG4gICAgaWYgKGltYWdlTmFtZSA9PSBmYXZvcml0ZUltYWdlU2VsZWN0ZWQpIHtcbiAgICAgICAgaW1hZ2VOYW1lID0gZmF2b3JpdGVJbWFnZU5vcm1hbDtcbiAgICB9XG4gICAgZWxzZSB7XG4gICAgICAgIGltYWdlTmFtZSA9IGZhdm9yaXRlSW1hZ2VTZWxlY3RlZFxuICAgIH1cbiAgICBmYXZvcml0ZXNTZWxlY3RJbWFnZU1hcFtzeW1ib2xdID0gaW1hZ2VOYW1lO1xuICAgIGZvciAobGV0IGkgPSAwOyBpIDwgJGRhdGEucmFua2luZy5saXN0RGF0YS5sZW5ndGg7IGkrKykge1xuICAgICAgICB2YXIgZGF0YU1hcCA9ICRkYXRhLnJhbmtpbmcubGlzdERhdGFbaV07XG4gICAgICAgIGlmIChkYXRhTWFwLnR5cGUgIT0gOSkge1xuICAgICAgICAgICAgY29udGludWU7XG4gICAgICAgIH1cbiAgICAgICAgbGV0IGhhc0Nob29zZSA9IGZhbHNlO1xuICAgICAgICBmb3IgKGxldCBqID0gMDsgaiA8IGRhdGFNYXAuZGF0YS5sZW5ndGg7IGorKykge1xuICAgICAgICAgICAgdmFyIGNlbGxEYXRhID0gZGF0YU1hcC5kYXRhW2pdO1xuICAgICAgICAgICAgaWYgKGNlbGxEYXRhLmNlbGxUeXBlID09IFwic3BvdEZhdm9yaXRlXCIpIHtcbiAgICAgICAgICAgICAgICBpZiAoY2VsbERhdGEubGVmdEl0ZW0uc3ltYm9sID09IHN5bWJvbCkge1xuICAgICAgICAgICAgICAgICAgICBjZWxsRGF0YS5sZWZ0SXRlbS5mYXZvcml0ZUltYWdlID0gaW1hZ2VOYW1lO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICBlbHNlIGlmIChjZWxsRGF0YS5yaWdodEl0ZW0uc3ltYm9sID09IHN5bWJvbCkge1xuICAgICAgICAgICAgICAgICAgICBjZWxsRGF0YS5yaWdodEl0ZW0uZmF2b3JpdGVJbWFnZSA9IGltYWdlTmFtZTtcbiAgICAgICAgICAgICAgICB9XG5cbiAgICAgICAgICAgICAgICBpZiAoY2VsbERhdGEubGVmdEl0ZW0uZmF2b3JpdGVJbWFnZSA9PSBmYXZvcml0ZUltYWdlU2VsZWN0ZWQgfHwgY2VsbERhdGEucmlnaHRJdGVtLmZhdm9yaXRlSW1hZ2UgPT0gZmF2b3JpdGVJbWFnZVNlbGVjdGVkKSB7XG4gICAgICAgICAgICAgICAgICAgIGhhc0Nob29zZSA9IHRydWU7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgfVxuICAgICAgICB9XG5cbiAgICAgICAgZm9yIChsZXQgaiA9IDA7IGogPCBkYXRhTWFwLmRhdGEubGVuZ3RoOyBqKyspIHtcbiAgICAgICAgICAgIHZhciBjZWxsRGF0YSA9IGRhdGFNYXAuZGF0YVtqXTtcbiAgICAgICAgICAgIGlmIChjZWxsRGF0YS5jZWxsVHlwZSA9PSBcImZhdm9yaXRlQWRkXCIpIHtcbiAgICAgICAgICAgICAgICBjZWxsRGF0YS5lbmFibGVCdXR0b24gPSBoYXNDaG9vc2UgPT0gdHJ1ZSA/IFwidmlzaWJsZVwiIDogXCJnb25lXCI7XG4gICAgICAgICAgICAgICAgY2VsbERhdGEuZGlzYWJsZUJ1dHRvbiA9IGhhc0Nob29zZSA9PSB0cnVlID8gXCJnb25lXCIgOiBcInZpc2libGVcIjtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgIH1cbn1cblxuYXN5bmMgZnVuY3Rpb24gdGFiQ2xpY2sodGFnKSB7XG4gICAgdmFyIGluZGV4ID0gcGFyc2VJbnQodGFnKSAtIDEwMDtcbiAgICAkZGF0YS5yYW5raW5nLmN1cnJlbnRJbmRleCA9IFN0cmluZyhpbmRleCk7XG4gICAgYXdhaXQgcmVzZXRUaXRsZVNlbGVjdFRhYihpbmRleCk7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlc2V0VGl0bGVTZWxlY3RUYWIoaW5kZXgpIHtcbiAgICBjb25zb2xlLmxvZyhgaW5kZXggPSAke2luZGV4fWApO1xuICAgIGF3YWl0IGNvbW1vbi5zYXZlKFwicmFua2luZ1wiLCByYW5raW5nQ2FjaGVLZXksIFN0cmluZyhpbmRleCkpO1xuXG4gICAgdmFyIHNlbGVjdGVkSXRlbSA9IG51bGw7XG4gICAgZm9yICh2YXIgaSA9IDA7IGkgPCAkZGF0YS5yYW5raW5nLnRpdGxlRGF0YS5sZW5ndGg7IGkrKykge1xuICAgICAgICB2YXIgaXRlbSA9ICRkYXRhLnJhbmtpbmcudGl0bGVEYXRhW2ldO1xuICAgICAgICBpZiAoaSA9PSBpbmRleCkge1xuICAgICAgICAgICAgc2VsZWN0ZWRJdGVtID0gaXRlbTtcbiAgICAgICAgfVxuICAgICAgICBpdGVtLnRpdGxlQ29sb3IgPSB0aXRsZUNvbG9yX05vcm1hbDtcbiAgICAgICAgaXRlbS50aXRsZVNpemUgPSB0aXRsZUZvbnRfTm9ybWFsO1xuICAgIH1cblxuICAgIHZhciBzZWxlY3RlZENoYW5nZSA9IGZhbHNlO1xuICAgIGlmIChzZWxlY3RlZEl0ZW0gIT0gbnVsbCkge1xuICAgICAgICBzZWxlY3RlZEl0ZW0udGl0bGVDb2xvciA9IHRpdGxlQ29sb3JfU2VsZWN0ZWQ7XG4gICAgICAgIHNlbGVjdGVkSXRlbS50aXRsZVNpemUgPSB0aXRsZUZvbnRfU2VsZWN0ZWQ7XG4gICAgICAgIHNlbGVjdGVkSXRlbS5wb2ludFZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICAgICAgaWYgKCRkYXRhLnJhbmtpbmcuY3VycmVudFRhZyAhPSBzZWxlY3RlZEl0ZW0udGFnKSB7XG4gICAgICAgICAgICBzZWxlY3RlZENoYW5nZSA9IHRydWU7XG4gICAgICAgICAgICAkZGF0YS5yYW5raW5nLmN1cnJlbnRUYWcgPSBzZWxlY3RlZEl0ZW0udGFnO1xuICAgICAgICB9XG4gICAgICAgIGlmIChzZWxlY3RlZEl0ZW0udHlwZSA9PSA0KSB7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgcG9pbnRWaXNpYmlsaXR5ICDnvJPlrZjmnIDmlrDml7bpl7QgPSAke2xhdGVzdFVwQ29pblRpbWV9YCk7XG4gICAgICAgICAgICBhd2FpdCBjb21tb24uc2F2ZShcInJhbmtpbmdcIiwgXCJsYXRlc3RVcFwiLCBTdHJpbmcobGF0ZXN0VXBDb2luVGltZSkpO1xuICAgICAgICB9IGVsc2UgaWYgKHNlbGVjdGVkSXRlbS50eXBlID09IDEwKSB7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgbWFya2V0UmFua0hpbnQgPSA3Nzc3LCBtYXJrZXRSYW5rSGludD09JHttYXJrZXRSYW5rSGludH1gKTtcbiAgICAgICAgICAgIGF3YWl0IGNvbW1vbi5zYXZlKFwicmFua2luZ1wiLCBcIm1hcmtldF9jYXBfdGlwXCIsIFwiaGludFwiKTtcbiAgICAgICAgfVxuXG4gICAgICAgIC8v6I635Y+W5pu05aSa5oyJ6ZKu55qE54K55Ye75pWw5o2uXG4gICAgICAgIHZhciBzdWJUeXBlU3RyID0gbnVsbDtcbiAgICAgICAgaWYgKHNlbGVjdGVkSXRlbS50eXBlID09IDkpIHtcbiAgICAgICAgICAgIHN1YlR5cGVTdHIgPSBjdXJyZW50U2NyZWVuO1xuICAgICAgICB9XG4gICAgICAgIHZhciBtb3JlQWN0aW9uRGF0YSA9IGF3YWl0IGdldE1vcmVBY3Rpb25EYXRhKHNlbGVjdGVkSXRlbS50eXBlLCBzdWJUeXBlU3RyKTtcbiAgICAgICAgY29uc29sZS5sb2coYG1vcmVBY3Rpb25EYXRhID0gJHttb3JlQWN0aW9uRGF0YX1gKTtcbiAgICB9XG4gICAgaWYgKHNlbGVjdGVkQ2hhbmdlID09IHRydWUpIHtcbiAgICAgICAgYXdhaXQgYW5hbHl0aWNzQXBwZWFyKCk7XG4gICAgfVxufVxuXG5hc3luYyBmdW5jdGlvbiBnb1RvRmF2b3JpdGVzKCkge1xuICAgIGF3YWl0IGNvbW1vbi5vcGVuUGFnZShcIm1hcmtldEFkZFwiKTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gYWRkRmF2b3JpdGVzQ2xpY2soKSB7XG4gICAgdmFyIHN5bWJvbHMgPSBPYmplY3Qua2V5cyhmYXZvcml0ZXNTZWxlY3RJbWFnZU1hcCkuZmlsdGVyKChpdGVtKSA9PiB7XG4gICAgICAgIHJldHVybiBmYXZvcml0ZXNTZWxlY3RJbWFnZU1hcFtpdGVtXSA9PSBmYXZvcml0ZUltYWdlU2VsZWN0ZWQ7XG4gICAgfSk7XG4gICAgYXdhaXQgYWRkRmF2b3JpdGVzU3ltYm9scyhzeW1ib2xzKTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gYWRkRmF2b3JpdGVzU3ltYm9scyhzeW1ib2xzID0gW10pIHtcbiAgICBpZiAoc3ltYm9scyA9PSBudWxsIHx8IHN5bWJvbHMubGVuZ3RoID09IDApIHtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICBpZiAoY29tbW9uLmNvbW1hbkRhdGEuaXNMb2dpbiA9PSAxKSB7XG4gICAgICAgIGF3YWl0IHVwZGF0ZUZhdm9yaXRlc1N5bWJvbHMoc3ltYm9scyk7XG4gICAgfVxuICAgIGVsc2Uge1xuICAgICAgICBhd2FpdCAkbmF0aXZlQVBJLmhvbWVCcmlkZ2Uoe1xuICAgICAgICAgICAgYWN0aW9uOiBcImFkZEZhdm9yaXRlc1N5bWJvbHNUb0xvY2FsXCIsXG4gICAgICAgICAgICBzeW1ib2xzOiBKU09OLnN0cmluZ2lmeShzeW1ib2xzKVxuICAgICAgICB9KTtcbiAgICB9XG4gICAgY3VycmVudFNjcmVlbiA9IFwic3BvdFwiO1xuICAgIGF3YWl0IHJlcXVlc3RSYW5raW5nRGF0YSgpO1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gbG9naW5TdGF0ZUNoYW5nZSgpIHtcbiAgICBpZiAobW9kdWxlRGlkU3RhcnQgPT0gZmFsc2UpIHtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICBpZiAoY29tbW9uLmNvbW1hbkRhdGEudXNlckluZm8udUlkICE9IGN1cnJlbnRVSUQpIHtcbiAgICAgICAgY3VycmVudFVJRCA9IGNvbW1vbi5jb21tYW5EYXRhLnVzZXJJbmZvLnVJZDtcbiAgICAgICAgZmF2b3JpdGVzU2VsZWN0SW1hZ2VNYXAgPSB7fTtcbiAgICB9XG59XG5cbm1vZHVsZUV2ZW50LmxvZ2luU3RhdGVDaGFuZ2UgPSBsb2dpblN0YXRlQ2hhbmdlO1xuXG5tb2R1bGVFdmVudC5yYW5raW5nQ2xpY2tlZCA9IHJhbmtpbmdDbGlja2VkO1xubW9kdWxlRXZlbnQubW9yZUJ1dHRvbkNsaWNrZWQgPSBtb3JlQnV0dG9uQ2xpY2tlZDtcbm1vZHVsZUV2ZW50LmludGVyYWN0aW9uVGl0bGVDbGljayA9IGludGVyYWN0aW9uVGl0bGVDbGljaztcblxubW9kdWxlRXZlbnQudGFiQ2xpY2sgPSB0YWJDbGljaztcbm1vZHVsZUV2ZW50LnJlc2V0VGl0bGVTZWxlY3RUYWIgPSByZXNldFRpdGxlU2VsZWN0VGFiO1xuXG5tb2R1bGVFdmVudC5nb1RvRmF2b3JpdGVzID0gZ29Ub0Zhdm9yaXRlcztcbm1vZHVsZUV2ZW50LnNlbGVjdGVkRmF2b3JpdGVTeW1ib2wgPSBzZWxlY3RlZEZhdm9yaXRlU3ltYm9sO1xubW9kdWxlRXZlbnQuYWRkRmF2b3JpdGVzQ2xpY2sgPSBhZGRGYXZvcml0ZXNDbGljaztcblxuJGV2ZW50LnJhbmtpbmdwb3AgPSB7fTtcblxuYXN5bmMgZnVuY3Rpb24gcmFua2luZ1BvcENsaWNrKG5hbWUpIHtcbiAgICAkZGF0YS5yYW5raW5ncG9wLnBvcHNob3cgPSBmYWxzZTtcbiAgICBpZiAoY3VycmVudFNjcmVlbiAhPSBuYW1lKSB7XG4gICAgICAgIGN1cnJlbnRTY3JlZW4gPSBuYW1lO1xuICAgICAgICBhd2FpdCByZXNldEZhdm9yaXRlc0xpc3REYXRhKCk7XG4gICAgfVxufTtcbiRldmVudC5yYW5raW5ncG9wLnJhbmtpbmdQb3BDbGljayA9IHJhbmtpbmdQb3BDbGljaztcblxuJGV2ZW50LnJhbmtpbmdwb3AuY2FuY2VsID0gZnVuY3Rpb24gKCkge1xuICAgICRkYXRhLnJhbmtpbmdwb3AucG9wc2hvdyA9IGZhbHNlO1xufTtcblxuJGV2ZW50LnJhbmtpbmdwb3AucG9wRGlzbWlzcyA9IGZ1bmN0aW9uICgpIHtcbiAgICBpZiAoJGRhdGEucmFua2luZ3BvcC5wb3BzaG93ICE9IGZhbHNlKSB7XG4gICAgICAgICRkYXRhLnJhbmtpbmdwb3AucG9wc2hvdyA9IGZhbHNlO1xuICAgIH1cbn07XG4iLCJpbXBvcnQgKiBhcyBjb21tb24gZnJvbSAnLi9jb21tb24nXG5pbXBvcnQgKiBhcyBuYXYgZnJvbSAnLi9uYXYnXG5pbXBvcnQgKiBhcyBtYXJrZXQgZnJvbSAnLi9tYXJrZXQnXG5pbXBvcnQgKiBhcyBndWlkZSBmcm9tICcuL2d1aWRlJ1xuaW1wb3J0ICogYXMgaW52ZXN0IGZyb20gJy4vaW52ZXN0J1xuaW1wb3J0ICogYXMgYmFubmVyIGZyb20gJy4vYmFubmVyJ1xuaW1wb3J0ICogYXMgZWFybiBmcm9tICcuL2Vhcm4nXG5pbXBvcnQgKiBhcyBvcGVyYXRpb24gZnJvbSAnLi9vcGVyYXRpb24nXG5pbXBvcnQgKiBhcyBjdWJlIGZyb20gJy4vY3ViZSdcbmltcG9ydCAqIGFzIHJhbmtpbmcgZnJvbSAnLi9yYW5raW5nJ1xuXG52YXIgdGltZXJPYmplY3QgO1xudmFyIGN1cnJlbnRMb2dpblN0YXRlS2V5IDtcblxuYXN5bmMgZnVuY3Rpb24gaW5pdEVuZ2luZSgpIHtcblxufVxuXG5hc3luYyBmdW5jdGlvbiBwYWdlQXBwZWFyKCkge1xuICAgIHN0YXJ0VGltZXIoKTtcbiAgICBiYW5uZXIuc3RhcnRTY3JvbGwoKTtcbiAgICBuYXYucmVmcmVzaEF2YXRhcigpO1xuICAgIGF3YWl0IGNvbW1vbi5yZXF1ZXN0U2VydmljZXNUaW1lKCk7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHBhZ2VEaXNhcHBlYXIoKSB7XG4gICAgY2xlYXJUaW1lcigpO1xuICAgIGJhbm5lci5lbmRTY3JvbGwoKTtcbiAgICBiYW5uZXIuY2xlYXJCYW5uZXJFeHBvc3VyZU1hcCgpO1xuICAgIG9wZXJhdGlvbi5jbGVhck9wZXJhdGlvbkV4cG9zdXJlTWFwKCk7XG4gICAgY3ViZS5jbGVhckN1YmVFeHBvc3VyZU1hcCgpO1xufVxuXG5mdW5jdGlvbiBzdGFydFRpbWVyKCkge1xuICAgIGlmICh0aW1lck9iamVjdCA9PSBudWxsKSB7XG4gICAgICAgIHRpbWVyT2JqZWN0ID0gc2V0SW50ZXJ2YWwodGltZXIsIDEwMDApO1xuICAgIH1cbn1cblxuZnVuY3Rpb24gY2xlYXJUaW1lcigpIHtcbiAgICBpZiAodGltZXJPYmplY3QpIHtcbiAgICAgICAgY2xlYXJJbnRlcnZhbCh0aW1lck9iamVjdCk7XG4gICAgICAgIHRpbWVyT2JqZWN0ID0gbnVsbDtcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHRpbWVyKCkge1xuICAgIGF3YWl0IG5hdi5jaGVja01lc3NhZ2VDb3VudFRpbWVyKCk7XG4gICAgYXdhaXQgcmFua2luZy5jaGVja1JlcXVlc3RUaW1lcigpO1xuICAgIGF3YWl0IGludmVzdC5ydW5UcmFkaW5nVG9FYXJuQ291bnREb3duKCk7XG4gICAgYXdhaXQgY3ViZS5jb3VudERvd24oKTtcbn1cblxuXG5cbmZ1bmN0aW9uIHNlbmRTeW1ib2xJbmZvKGluZm8pIHtcbiAgICBjb21tb24uY29tbWFuRGF0YS5zeW1ib2xJbmZvID0gaW5mbztcbn1cblxuYXN5bmMgZnVuY3Rpb24gc2VuZFNvY2tldERhdGEoZGF0YSkge1xuICAgIGlmIChkYXRhLnR5cGUgPT0gJ21hcmtldCcpIHtcbiAgICAgICAgY29uc29sZS5sb2coJ3Jlc2V0TWFya2V0RGF0YScpO1xuICAgICAgICBjb21tb24uY29tbWFuRGF0YS5tYXJrZXREYXRhID0gT2JqZWN0LmFzc2lnbihjb21tb24uY29tbWFuRGF0YS5tYXJrZXREYXRhLCBkYXRhLmRhdGEpO1xuICAgICAgICByYW5raW5nLnJlc2V0TWFya2V0RGF0YSgpO1xuICAgICAgICBtYXJrZXQucmVzZXRNYXJrZXREYXRhKCk7XG4gICAgfVxufVxuXG5hc3luYyBmdW5jdGlvbiBzZW5kTG9naW5TdGF0dXMoZGF0YSkge1xuICAgIGNvbW1vbi5zZW5kTG9naW5TdGF0dXMoZGF0YSk7XG4gICAgdmFyIGxvZ2luU3RhdGVLZXkgPSBgJHtjb21tb24uY29tbWFuRGF0YS5pc0xvZ2lufV8ke2NvbW1vbi5jb21tYW5EYXRhLnVzZXJJbmZvLnVJZH1gO1xuXG4gICAgaWYgKGN1cnJlbnRMb2dpblN0YXRlS2V5ID09IG51bGwgfHwgY3VycmVudExvZ2luU3RhdGVLZXkgIT0gbG9naW5TdGF0ZUtleSkge1xuICAgICAgICBjdXJyZW50TG9naW5TdGF0ZUtleSA9IGxvZ2luU3RhdGVLZXk7XG4gICAgICAgIGF3YWl0IG5hdi5sb2dpblN0YXRlQ2hhbmdlKCk7XG4gICAgICAgIGF3YWl0IHJhbmtpbmcubG9naW5TdGF0ZUNoYW5nZSgpO1xuICAgICAgICBhd2FpdCBndWlkZS5sb2dpblN0YXRlQ2hhbmdlKCk7XG4gICAgICAgIGF3YWl0IGJhbm5lci5sb2dpblN0YXRlQ2hhbmdlKCk7XG4gICAgfVxuXG4gICAgXG59XG5cbmFzeW5jIGZ1bmN0aW9uIHNlbmRSYXRlVHlwZVN0cihkYXRhKSB7XG4gICAgY29tbW9uLmNvbW1hbkRhdGEucmF0ZVR5cGVTdHIgPSBkYXRhLmNoYXJhY3RlcjtcbiAgICBhd2FpdCByYW5raW5nLnJlc2V0TWFya2V0VGl0bGUoKTtcbn1cblxuZnVuY3Rpb24gc2VuZENvbW1vbkNvbmZpZyhwYXJhbSkge1xuICAgIGNvbW1vbi5zZW5kQ29tbW9uQ29uZmlnKHBhcmFtKTtcbn1cblxuJGV2ZW50LnVwZGF0ZUhhc05ld1ZlcnNpb24gPSBmdW5jdGlvbiAocGFyYW0pIHtcblx0Y29tbW9uLmNvbW1hbkRhdGEuaGFzTmV3VmVyc2lvbiA9IHBhcmFtLmhhc05ld1ZlcnNpb247XG59XG5cbiRldmVudC5zZW5kU3ltYm9sSW5mbyA9IHNlbmRTeW1ib2xJbmZvO1xuJGV2ZW50LnNlbmRTb2NrZXREYXRhID0gc2VuZFNvY2tldERhdGE7XG4kZXZlbnQuc2VuZExvZ2luU3RhdHVzID0gc2VuZExvZ2luU3RhdHVzO1xuJGV2ZW50LnNlbmRSYXRlVHlwZVN0ciA9IHNlbmRSYXRlVHlwZVN0cjtcbiRldmVudC5zZW5kQ29tbW9uQ29uZmlnID0gc2VuZENvbW1vbkNvbmZpZztcbiRldmVudC5pbml0RW5naW5lID0gaW5pdEVuZ2luZTtcbiRldmVudC5wYWdlQXBwZWFyID0gcGFnZUFwcGVhcjtcbiRldmVudC5wYWdlRGlzYXBwZWFyID0gcGFnZURpc2FwcGVhcjtcblxuc3RhcnRUaW1lcigpIl0sIm5hbWVzIjpbIkRQIiwiUk0iLCJNQVhfRFAiLCJNQVhfUE9XRVIiLCJORSIsIlBFIiwiTkFNRSIsIklOVkFMSUQiLCJJTlZBTElEX0RQIiwiSU5WQUxJRF9STSIsIkRJVl9CWV9aRVJPIiwiUCIsIlVOREVGSU5FRCIsIk5VTUVSSUMiLCJfQmlnXyIsIkJpZyIsIm4iLCJ4IiwidGhpcyIsInMiLCJlIiwiYyIsInNsaWNlIiwicGFyc2UiLCJjb25zdHJ1Y3RvciIsInByb3RvdHlwZSIsInZlcnNpb24iLCJpIiwibmwiLCJ0ZXN0IiwiRXJyb3IiLCJjaGFyQXQiLCJpbmRleE9mIiwicmVwbGFjZSIsInNlYXJjaCIsInN1YnN0cmluZyIsImxlbmd0aCIsInJvdW5kIiwiZHAiLCJybSIsIm1vcmUiLCJ4YyIsInVuc2hpZnQiLCJwb3AiLCJzdHJpbmdpZnkiLCJpZCIsImsiLCJ6IiwicHVzaCIsImpvaW4iLCJhYnMiLCJjbXAiLCJ5IiwiaXNuZWciLCJ5YyIsImoiLCJsIiwiZGl2IiwiYSIsImIiLCJibCIsImJ0IiwicmkiLCJieiIsImFpIiwiYWwiLCJyIiwicmwiLCJxIiwicWMiLCJxaSIsImQiLCJzaGlmdCIsImVxIiwiZ3QiLCJndGUiLCJsdCIsImx0ZSIsIm1pbnVzIiwic3ViIiwidCIsInhsdHkiLCJwbHVzIiwieGUiLCJ5ZSIsInJldmVyc2UiLCJtb2QiLCJ5Z3R4IiwidGltZXMiLCJhZGQiLCJwb3ciLCJvbmUiLCJzcXJ0IiwiaGFsZiIsIk1hdGgiLCJ0b0V4cG9uZW50aWFsIiwibXVsIiwiQXJyYXkiLCJ0b0ZpeGVkIiwidG9QcmVjaXNpb24iLCJzZCIsInRvU3RyaW5nIiwidmFsdWVPZiIsInRvSlNPTiIsInVwQ29sb3JMaXN0IiwiZG93bkNvbG9yTGlzdCIsImNvbW1hbkRhdGEiLCJzeW1ib2xJbmZvIiwicHJpY2VDb2xvclR5cGUiLCJtYXJrZXREYXRhIiwiaWNvblVSTEhvc3QiLCJpY29uUGxhY2Vob2xkZXIiLCJyYXRlVHlwZVN0ciIsImNvbG9yTW9kZSIsIk9TIiwiYXBwVmVyc2lvbiIsImlzSW5SZXZpZXciLCJpc0xvZ2luIiwic2VydmljZVRpbWVJbnRlcnZhbCIsImhhc05ld1ZlcnNpb24iLCJ1c2VySW5mbyIsImFzeW5jIiwic2VuZFJlcXVlc3QiLCJwYXRoIiwicGFyYW1zIiwibWV0aG9kIiwiaG9zdFR5cGUiLCJoZWFkZXIiLCJjb25zb2xlIiwibG9nIiwicGFyYW0iLCJyZXNwb25zZVN0cmluZyIsIiRuYXRpdmVBUEkiLCJob21lUmVxdWVzdCIsIkpTT04iLCJyZXF1ZXN0IiwicmVzcG9uc2UiLCJjb2RlIiwiZGF0YSIsInNlbmRSZXF1ZXN0V2l0aENhY2hlIiwiY2FsbGJhY2siLCJjYWNoZUtleUxpc3QiLCJjYWNoZUtleSIsImdldENhY2hlS2V5IiwiY2FjaGUiLCJyZWFkIiwidXBsb2FkTG9nIiwiZXJyb3IiLCJyZXF1ZXN0RGF0YSIsInNhdmUiLCJwYXJhbVN0ciIsImxhbmd1YWdlIiwiY2FjaGVLZXlMaXN0U3RyIiwiZ2V0U3ltYm9sSW5mbyIsInN5bWJvbCIsImdldEljb25VUkwiLCJjdXJyZW5jeSIsImNvaW5OYW1lIiwidG9Mb3dlckNhc2UiLCJpY29uVVJMIiwiZ2V0UHJpY2VDb2xvciIsInJhdGlvIiwicmF0aW9fYWJzIiwiY29sb3JMZXZlbCIsImNvbG9ySGV4U3RyIiwiZ2V0UHJpY2VTdHJpbmciLCJwcmljZVN0ciIsInByZWNpc2lvbiIsInByaWNlTnVtIiwiTnVtYmVyIiwiYmlnVmFsdWUiLCJwcmljZVN0cmluZyIsIm5vdGF0aW9uIiwiZmluYWxQcmljZVN0ciIsImNsaWNrVGltZXIiLCJjbGlja1Rocm90dGxlIiwiaW50ZXJ2YWwiLCJub3ciLCJEYXRlIiwidGltZXIiLCJvcGVuVVJMIiwidXJsIiwiaG9tZUJyaWRnZSIsImFjdGlvbiIsInR5cGUiLCJwYWdlIiwib3BlblBhZ2UiLCJtb2R1bGUiLCJrZXkiLCJzdG9yYWdlIiwibmFtZSIsImNsZWFyIiwidGFnIiwiaW5mbyIsIm1hcCIsImFuYWx5dGljcyIsImV2ZW50IiwicHJvcGVydGllcyIsInByb3BlcnRpZXNKc29uIiwic2VuZExvZ2luU3RhdHVzIiwicGFyc2VJbnQiLCJ1SWQiLCJpc0NoaWxkQWNjb3VudCIsImhlYWRJbWFnZSIsImlzTkZUIiwiY291bnRyeUlkIiwicmVnaXN0ZXJDb3VudHJ5SWQiLCJzZW5kQ29tbW9uQ29uZmlnIiwiYXBwTGlmZUN5Y2xlSWQiLCJyZWRDb2xvckxpc3QiLCJncmVlbkNvbG9yTGlzdCIsIm1vZHVsZURlZmluZSIsIm1vZHVsZU5hbWUiLCJzdGFydEZ1bmN0aW9uIiwiZGVmYXVsdERhdGFGdW5jdGlvbiIsIiRkYXRhIiwiJGV2ZW50Iiwic3RhcnQiLCJtb2R1bGVFdmVudCIsIm1vZHVsZURhdGEiLCJzZXRNb2R1bGVTdGF0dXMiLCJzdGF0dXNUeXBlIiwic3RhdHVzIiwiZ2V0VmlzaWJpbGl0eVN0YXR1cyIsInNob3ciLCJmb3JtYXREYXRlIiwiZGF0ZSIsImZtdCIsIlJlZ0V4cCIsIiQxIiwiZ2V0RnVsbFllYXIiLCJzdWJzdHIiLCJvIiwiZ2V0TW9udGgiLCJnZXREYXRlIiwiZ2V0SG91cnMiLCJnZXRNaW51dGVzIiwiZ2V0U2Vjb25kcyIsInN0ciIsInBhZExlZnRaZXJvIiwicmVxdWVzdFNlcnZpY2VzVGltZSIsInRpbWVySW50ZXJ2YWxJbmZvIiwiY3VycmVudFRpbWVJbnRlcnZhbCIsImdldFRpbWUiLCJtb2R1bGVEaWRTdGFydCIsImNvbW1vbi5zZXRNb2R1bGVTdGF0dXMiLCJyZXF1ZXN0TmF2RGF0YSIsInJlZnJlc2hBdmF0YXIiLCJkZWZhdWx0RGF0YSIsImN1cnJlbnRJbmRleCIsInNlYXJjaERhdGEiLCJyZXdhcmRzRGF0YSIsInJld2FyZHNJbWFnZSIsInJld2FyZHNWaXNpYmlsaXR5IiwicmV3YXJkc1JlZERvdFZpc2liaWxpdHkiLCJtZXNzYWdlQ291bnQiLCJub3RpY2VDb3VudCIsIm1lc3NhZ2VWaXNpYmlsaXR5Iiwibm90aWNlVmlzaWJpbGl0eSIsInJlZERvdFZpc2libGUiLCJudW1SZWREb3RWaXNpYmxlIiwiaG90VmlzaWJpbGl0eSIsImNvbW1vbi5tb2R1bGVEZWZpbmUiLCJtb2R1bGVBcHBlYXIiLCJtb2R1bGVEaXNhcHBlYXIiLCJpbU1nc0NvdW50IiwiYWN0aXZpdHlDb3VudCIsImxhc3RUaW1lIiwic2VhcmNoRGF0YUNhY2hlIiwic2VhcmNoRGF0YUNhbGxiYWNrIiwiaXNDYWNoZSIsImhvdFdvcmRDb250ZXh0IiwiaG90V29yZHMiLCJlbGVtZW50IiwiY2VsbFR5cGUiLCJ3cm9kSW5kZXgiLCJTdHJpbmciLCJyZXdhcmRzRGF0YUNhbGxiYWNrIiwiY29tbW9uLmNvbW1hbkRhdGEiLCJuYXZpZ2F0aW9uTmlnaHRJbWdVcmwiLCJuYXZpZ2F0aW9uRGF5SW1nVXJsIiwicmV3YXJkQ2VudGVyRmxhZyIsImNvbW1vbi5zZW5kUmVxdWVzdFdpdGhDYWNoZSIsInJlcXVlc3RNZXNzYWdlQ291bnQiLCJ1cGRhdGVNZXNzYWdlQ291bnQiLCJzZW5kVW5yZWFkTWVzc2FnZSIsImNvdW50IiwiY2hlY2tNZXNzYWdlQ291bnRUaW1lciIsImN1cnJlbnRUaW1lIiwibmF2IiwicmVxdWVzdEF2YXRhciIsImlzS3ljIiwidXNlckdldERhdGEiLCJjb21tb24uc2VuZFJlcXVlc3QiLCJreWNfbGV2ZWwiLCJpc0h0eCIsInJlZERvdERhdGEiLCJyZWREb3ROdW0iLCJyZWREb3QiLCJudW1SZWREb3RMZWZ0IiwiZXhjaGFuZ2VfaWQiLCJ0ZW1wbGF0ZV9jb2RlIiwiY291bnREYXRhIiwic3VtX3N1Yl91bl9yZWFkIiwic3VtX3VuX3JlYWRfZXhjZXB0X2NvZGUiLCJsZXR0ZXJUeXBlIiwibGV0dGVyX3N1Yl90eXBlIiwiaG90SW5kZXhDaGFuZ2UiLCJpbmRleCIsImdvVG9TZWFyY2giLCJob3R3b3JkcyIsImNvbW1vbi5vcGVuUGFnZSIsImNvbW1vbi5hbmFseXRpY3MiLCJtb2R1bGVfbmFtZSIsImJ1dHRvbl9uYW1lIiwicHJlX3RleHQiLCJ3b3JkIiwiZ29Ub1NjYW4iLCJnb1RvSU0iLCJiYWRnZXMiLCJzdXBlcnNjcmlwdCIsImdvVG9SZXdhcmRzIiwiY29tbW9uLm9wZW5VUkwiLCJuYXZpZ2F0aW9uSnVtcFVybCIsImdvVG9Vc2VyIiwibG9naW5TdGF0ZUNoYW5nZSIsInJlYWRUaGlyZFN5bWJvbEluZGV4IiwicmVxdWVzdFRvcENvbnRyYWN0U3ltYm9scyIsImxpc3QiLCJ0aGlyZEluZGV4IiwicmVzZXRNYXJrZXREYXRhIiwiaXRlbSIsImNvaW5EaWN0IiwiY29tbW9uLmdldFN5bWJvbEluZm8iLCJkZWNpbWFsY1ByaWNlIiwiY3VycmVudFByaWNlIiwiY29tbW9uLmdldFByaWNlU3RyaW5nIiwidHJhZGVQcmljZVByZWNpc2lvbiIsInVwRG93biIsImRlY2ltYWxEZWx0YSIsImZvcm1hdFJhdGlvIiwicmF0aW9Db2xvciIsImNvbW1vbi5nZXRQcmljZUNvbG9yIiwiYXJyYXkiLCJtb2RlbCIsImhhbmRsZVRvcFN5bWJvbE1vZGVsIiwib2JqIiwic3ltYm9sTW9kZWwiLCJwcm9kdWN0VGl0bGUiLCJiYXNlQ3VycmVuY3kiLCJ0b1VwcGVyQ2FzZSIsInF1b3RlQ3VycmVuY3kiLCJwcmljZSIsImhhbmRsZVJ0aW8iLCJudW1iZXIiLCJwcmVmaXgiLCJpbmRleE1hcCIsImNvbW1vbi5yZWFkIiwiYXBwTGlmZUlEIiwiY29tbW9uLnNhdmUiLCJqdW1wVG9LbGluZSIsInRyYWRlQ2F0ZWdvcnlUeXBlIiwiY2hnIiwibW9kdWxlX3Bvc2l0aW9uIiwiY3VycmVudENhY2hlS2V5IiwicmVxdWVzdFVzZXJSZWdpc3RyeVRyYW5zZmVyR3VpZGUiLCJ0YXNrUHJvZ3Jlc3MiLCJ0aXRsZUNvbG9yIiwidGl0bGUiLCJtYXRjaCIsInN1YlRpdGxlIiwidG90YWxBd2FyZCIsIm1hdGVyaWFsX25hbWUiLCJidXR0b25UaXRsZSIsIiRpMThuIiwibl9pbmRleF9hbW91bnRfaW1tZWRpYXRlbHkiLCJuX2hvbWVfbG9naW5fcmVnaXN0ZXIiLCJvcGVuR3VpZFBhZ2UiLCJndWlkZSIsInJlcXVlc3RJbnZlc3REcmF3ZXJEYXRhIiwic2hvd1RpdGxlVGV4dCIsInZpc2liaWxpdHkiLCJ0cmFkaW5nVG9FYXJuIiwiY29udHJhY3RDb3B5VHJhZGUiLCJkdWFsIiwic3BvdCIsImFuYWx5dGljc0FwcGVhciIsIm5lZWRBbmFseXRpY3NXaGVuUmVxdWVzdFN1Y2Nlc3MiLCJ0eXBlTGlzdCIsInR5cGVTdHIiLCJtb3JlVGFwQWN0aW9uIiwianVtcFVybCIsImVuY29kZVVSSSIsInRhcEFjdGlvbiIsInJ1blRyYWRpbmdUb0Vhcm5Db3VudERvd24iLCJhY3Rpdml0eVN0YXR1cyIsInJlbWFpbmluZ1RpbWUiLCJtYXgiLCJyZW1haW5UaW1lIiwiaGFuZGxlU2hvd1RpbWUiLCJjb3VudERvd25UaW1lU3RyIiwic2hvd1NjaGVkdWxlVGV4dCIsInNob3dSZW1haW4iLCJjb21tb24uZ2V0VmlzaWJpbGl0eVN0YXR1cyIsImludmVzdERhdGFDYWxsQmFjayIsImhhbmRsZVRyYWRpbmdUb0Vhcm4iLCJpbWdWaXNpYmlsaXR5IiwiaW1nIiwidW5kZWZpbmVkIiwic2hvd1N1YlRpdGxlVGV4dCIsIm5pY2siLCJ0b3RhbFByb2ZpdEFtb3VudCIsImdldEFtb3VudFByaWNlU3RyIiwiaGFuZGxlRHVhbCIsImFtb3VudFN0ciIsImltZ0N1cnJlbmN5IiwiY29tbW9uLmdldEljb25VUkwiLCJjb3ZlcnRDdXJyZW5jeSIsImltZ2VDb3ZlcnRDdXJyZW5jeSIsInJhdGVUaXRsZSIsImFweSIsImFweVBlcmNlbnQiLCJmb3JtYXROdW1iZXIiLCJwcml6ZUFtb3VudCIsInByaXplQW1vdW50RGlzcGxheSIsImZvcm1hdE51bWJlcldpdGhDb21tYXMiLCJhbGxvY2F0ZWRTY29yZSIsImFsbG9jYXRlZFNjb3JlRGlzcGxheSIsInJlbWFpbmluZ1Byb3BvcnRpb24iLCJ1c2VkUHJvcG9ydGlvblNob3ciLCJ1c2VkUHJvcG9ydGlvbiIsInJlbWFpbmluZ1Byb3BvcnRpb25TaG93IiwicHJpemVBbW91bnRTdHJpbmciLCJhbGxvY2F0ZWRTY29yZVN0cmluZyIsInN0YXJ0VGltZSIsInN5c3RlbVRpbWUiLCJlbmRUaW1lIiwiY29pbkljb24iLCJ0aW1lc3RhbXAiLCJzZWNvbmRzIiwiZmxvb3IiLCJtaW51dGVzIiwiaG91cnMiLCJkYXlzIiwic2hvd0RheSIsInJlbWFpbmluZ1NlY29uZHMiLCJyZW1haW5pbmdNaW51dGVzIiwicmVtYWluaW5nSG91cnMiLCJhZGRMZWFkaW5nWmVybyIsInZhbHVlIiwic2FmZVZhbHVlIiwiaCIsIm0iLCJmbG9hdFZhbHVlIiwicGFyc2VGbG9hdCIsImlzTmFOIiwidHJ1bmNhdGVkVmFsdWUiLCJ0cnVuYyIsImZvcm1hdHRlZE51bWJlciIsInBhcnRzIiwic3BsaXQiLCJiYW5uZXIiLCJiYW5uZXJWaXNpYmlsaXR5IiwiYmFubmVyUGxhY2Vob2xlclZpc2liaWxpdHkiLCJiYW5uZXJQbGFjZWhvbGVySW1hZ2UiLCJyZXF1ZXN0QmFubmVyIiwiYmFubmVyTGlzdCIsIm5vdGljZUxpc3QiLCJiYW5uZXJDdXJyZW50SW5kZXgiLCJub3RpY2VDdXJyZW50SW5kZXgiLCJ0b3RhbFBhZ2UiLCJiYW5uZXJUZXh0VmlzaWJpbGl0eSIsIm5vdGljZVBsYWNlaG9sZXJWaXNpYmlsaXR5IiwiYmFubmVyQW5kcm9pZFN0cm9rZVZpc2liaWxpdHkiLCJhdXRvU2Nyb2xsIiwiY3VycmVudE5vdGljZUluZGV4IiwiYmFubmVyRXhwb3N1cmVNYXAiLCJNYXAiLCJub3RpdmVFeHBvc3VyZU1hcCIsImJhbm5lckV4cG9zdXJlIiwiYmFubmVyRGF0YUxpc3QiLCJoYXMiLCJlbGVtZW50SWQiLCJzZXQiLCJub3RpY2VFeHBvc3VyZSIsIm5vdGljZURhdGFMaXN0Iiwibm90aWNlX2lzX3RvcCIsImNsZWFyQmFubmVyRXhwb3N1cmVNYXAiLCJyZXF1ZXN0QmFubmVyTGlzdCIsInJlcXVlc3ROb3RpY2VMaXN0IiwidWEiLCJjVHlwZSIsInVpZCIsImxhbmciLCJjaGFubmVsX25hbWUiLCJ1c2VyQWdlbnQiLCJjb3VudHJ5VHlwZSIsImJhbm5lckRhdGFDYWxsYmFjayIsImJhbm5lckRhdGEiLCJhZExpc3QiLCJpc0VmZmVjdGl2ZUFkdmVydGlzaW5nIiwibm90aWNlRGF0YUNhbGxiYWNrIiwibm90aWNlRGF0YSIsInRvcCIsInRvcExlbmd0aCIsIm5vcm1hbCIsImRhdGFMaXN0IiwiY29uY2F0Iiwibl9ub3RpY2VfZXZlbnQiLCJuX25vdGljZSIsIm5fbm90aWNlX25ld19jb2luIiwicmVzdWx0IiwiaXNFZmZlY3RpdmUiLCJjdXJyZW50SW1hZ2VVUkwiLCJuaWdodEltYWdlVXJsIiwiYmVnaW5UaW1lIiwic3VwcG9ydCIsImFwcElvc1RyYWRlU3VwcG9ydCIsImFwcEFuZHJvaWRTdXBwb3J0IiwiaXNTaG93IiwiaXNOZWVkTG9naW4iLCJzZWxlY3RlZEJhbm5lckluZGV4Iiwic2VsZWN0ZWROb3RpY2VJbmRleCIsImJhbm5lckNsaWNrQmFubmVyIiwiYmFubmVyQ2xpY2tOb3RpY2UiLCJhYnNvbHV0ZV91cmwiLCJiYW5uZXJDbGlja01vcmUiLCJzdGFydFNjcm9sbCIsImVuZFNjcm9sbCIsInJlcXVlc3RFYXJuQXJlYUhvbWVwYWdlckRhdGEiLCJlYXJuTGlzdCIsIm9mZnNldFgiLCJpc0xvYWQiLCJpc05ld1VzZXIiLCJpZExpc3QiLCJmb3JFYWNoIiwiZ2V0VHlwZUFuYWx5dGljc1N0cmluZyIsInNoZWxmVHlwZSIsInByb2plY3RJZCIsImlkU3RyIiwiZW5kU2Nyb2xsWEFjdGlvbiIsIm5lZWRMb2dpbiIsImVhcm5UYXBBY3Rpb24iLCJlYXJuRGF0YUNhbGxiYWNrIiwibmV3VXNlciIsImlzT2xkVXNlciIsIml0ZW1zU2hvdyIsImNvbnRlbnRzIiwiZWFybiIsImhhbmRsZUVhcm5PYmplY3QiLCJzdHlsZSIsImZpbmlzaExvYWQiLCJjb21tb24uY2xlYXIiLCJsYXN0T2Zmc2V0WCIsImljb25VcmwiLCJyYXRlU3RyaW5nIiwicmF0ZSIsInRhZ1Nob3ciLCJ0YWdWYWx1ZSIsInRhZ0JnQ29sb3IiLCJ0YWdUZXh0Q29sb3IiLCJvcmlnaW5hbFJhdGVTaG93Iiwib3JpZ2luQXB5Iiwib3JpZ2luYWxSYXRlU3RyaW5nIiwiZWFyblR5cGUiLCJyZXF1ZXN0T3BlcmF0aW9uRGF0YSIsImZpcnN0RnVuY3Rpb25MaXN0Iiwic2Vjb25kRnVuY3Rpb25MaXN0IiwiZnVuY3Rpb25WaXNpYmlsaXR5IiwiZmlyc3RGdW5jdGlvblZpc2liaWxpdHkiLCJzZWNvbmRGdW5jdGlvblZpc2liaWxpdHkiLCJvcGVyYXRpb25FeHBvc3VyZU1hcCIsImNsZWFyT3BlcmF0aW9uRXhwb3N1cmVNYXAiLCJvcGVyYXRpb25EYXRhTGlzdCIsImJhZGdlc1N0ciIsIm9wZXJhdGlvbkludmFsaWRJZCIsImp1bXBNb2RlIiwiZ3JvdXBDb2RlIiwiY29ybmVyTWFya0NvbnRlbnQiLCJjb3JuZXJNYXJrSWQiLCJtb2R1bGVTaXplIiwicGxhdGZvcm0iLCJuaWdodE1vZGUiLCJ0cyIsIm9wZXJhdGlvbkRhdGFDYWxsYmFjayIsImZ1bmN0aW9uRGF0YSIsImNvbnRlbnRMaXN0IiwiY29udGVudExpc3RMZW5ndGgiLCJvcGVyYXRpb24iLCJjZWxsRGF0YSIsImltZ1VybCIsImltZ05pZ2h0VXJsIiwibWFya0NvbnRlbnRMZW5ndGgiLCJ0ZXh0IiwiY29ybmVyTWFya1RleHQiLCJjb3JuZXJNYXJrVGV4dFZpc2liaWxpdHkiLCJjb3JuZXJNYXJrSWNvbiIsImltYWdlVXJsIiwiY29ybmVyTWFya0ljb25WaXNpYmlsaXR5Iiwib3BlcmF0aW9uSW5kZXgiLCJjb250ZW50VmlzaWJpbGl0eSIsIm9wZXJhdGlvbkNsaWNrSXRlbSIsInJlcXVlc3RTcG90SG9tZVBhZ2VJbmZvIiwibGlzdERhdGEiLCJjdWJlRGF0YUxpc3QiLCJjdWJlRXhwb3N1cmVNYXAiLCJjbGVhckN1YmVFeHBvc3VyZU1hcCIsIm1hdGVyaWFsX2lkIiwicmVzZXJ2ZV9ieXRlMSIsInJlc2VydmVfYnl0ZTIiLCJ0YXBDdWJlQWN0aW9uIiwiY291bnREb3duIiwiY3ViZVR5cGUiLCJuZWVkQ291bnREb3duIiwic2hvd0RhdGEiLCJkaWZmIiwiZGlmZlRpbWUiLCJkYXkiLCJob3VyIiwibWludXRlIiwic2Vjb25kIiwic2hvd0NvdW50RG93biIsImhvbWVwYWdlSW5mb0RhdGFDYWxsYmFjayIsImFjY2VzcyIsImFyciIsImN1YmVEYXRhIiwiYmdJbWFnZVVybCIsImluY2x1ZGVzIiwiaXRlbUNlbGxUeXBlIiwiaGFuZGxlQ3ViZUl0ZW1UaW1lciIsInJlcXVlc3RQYXJhbXMiLCJyZXF1ZXN0SGVhZGVyIiwicHJpY2luZ01vZGUiLCJvYmplY3QiLCJkYXlTdHJpbmciLCJob3VyU3RyaW5nIiwibWludXRlU3RyaW5nIiwic2Vjb25kU3RyaW5nIiwib3JpZ2luRGF0YSIsIm1vcmVBY3Rpb25EYXRhTWFwIiwicmFua2luZ0NhY2hlS2V5IiwiZmF2b3JpdGVzU2VsZWN0SW1hZ2VNYXAiLCJuZXdMaXN0TmVlZFJlZnJlc2giLCJjdXJyZW50U2NyZWVuIiwiZmF2b3JpdGVTY3JlZW5EYXRhIiwiZnV0dXJlIiwidGl0bGVDb2xvcl9Ob3JtYWwiLCJ0aXRsZUNvbG9yX1NlbGVjdGVkIiwidGl0bGVGb250X05vcm1hbCIsInRpdGxlRm9udF9TZWxlY3RlZCIsImZhdm9yaXRlSW1hZ2VOb3JtYWwiLCJmYXZvcml0ZUltYWdlU2VsZWN0ZWQiLCJsYXRlc3RVcENvaW5UaW1lIiwibWFya2V0UmFua0hpbnQiLCJnZXRDYWNoZUluZGV4IiwicmVxdWVzdFJhbmtpbmdEYXRhIiwiY2FjaGVJbmRleCIsInJhbmtpbmciLCJjdXJyZW50VGFnIiwiZGVmYXVsdEluZGV4IiwidGl0bGVEYXRhIiwidGl0bGVJdGVtIiwibGlzdF90eXBlIiwicmFua2luZ3BvcCIsInBvcHNob3ciLCJnZXRQcmljZVN5bWJvbCIsImdldEVtcHR5Q2VsbCIsInN1YlR5cGUiLCJlbXB0eUNlbGxUeXBlIiwiZW1wdHlDZWxsIiwiZ2V0TG9jYWxGYXZvcml0ZXMiLCJmYXZvcml0ZXMiLCJnZXRDb250cmFjdEJ1c2luZXNzVHlwZVRhZyIsImJ1c2luZXNzVHlwZVRhZyIsImhlYWRlckNlbGxJdGVtRnJvbSIsInRpdGxlcyIsImhlYWRlckl0ZW0iLCJsZWZ0VGl0bGUiLCJtaWRkbGVUaXRsZSIsInJpZ2h0VGl0bGUiLCJvcmlnaW5UaXRsZU5hbWUiLCJ0aXRsZU5hbWUiLCJmaWx0ZXJMaXN0SXRlbXMiLCJkYXRhQ291bnQiLCJzaG93TW9yZSIsInNob3dRdW90YSIsImZpbHRlckxpc3QiLCJtYXhDb3VudCIsImRldGFpbEluZm8iLCJvcmlnaW5JdGVtSnNvbiIsImJhc2VOYW1lIiwicXVvdGVOYW1lIiwiaXNRdW90ZU5hbWUiLCJ0YWdVcmwiLCJmbGFnVVJMIiwiZmxhZ1ZpZXdWaXNpYmlsaXR5IiwiaXNaZXJvRmVlIiwidGFncyIsImNvbnRyYWN0U2hvd1N5bWJvbCIsImFuYWx5dGljc1N5bWJvbE5hbWUiLCJwcmljZVN5bWJvbCIsInVwQW5kRG93biIsImNvbG9ySGV4IiwiaXNGYXZvcml0ZXMiLCJjb250cmFjdEJ1c2luZXNzVHlwZVRhZyIsImlzSGlkZGVuVXAiLCJiYXNlQ3VycmVuY3lEaXNwbGF5TmFtZSIsInF1b3RlQ3VycmVuY3lEaXNwbGF5TmFtZSIsInZvbHVtZSIsImdldFZvbHVtZVN0ciIsImJlZ2luVHJhZGVEYXRlIiwiYmVnaW5EYXRlIiwiYmVnaW5UcmFkZVVwQW5kRG93biIsImJlZ2luRGF0ZVN0ciIsImNvbW1vbi5mb3JtYXREYXRlIiwidGltZU1hcCIsImdldENvdW50RG93bk1hcCIsImlzWmVybyIsIm1vcmVDZWxsIiwiY2VsbEl0ZW0iLCJoYW5kbGVGYXZvcml0ZUxpc3QiLCJmYXZvcml0ZUxpc3QiLCJmYXZvcml0ZVRpdGxlQ2VsbCIsImZhdm9yaXRlVGl0bGUiLCJuX2hvbWVfZmF2b3JpdGVfc2VsZWN0X2NyeXB0byIsImRhdGFDZWxsTGlzdCIsInNpbmdsZUxpc3QiLCJoYXNDaG9vc2UiLCJkYXRhQ2VsbCIsImltYWdlTmFtZSIsImZhdm9yaXRlSW1hZ2UiLCJmYXZvcml0ZURhdGFDZWxsIiwibGVmdEl0ZW1WaXNpYmlsaXR5IiwicmlnaHRJdGVtVmlzaWJpbGl0eSIsImxlZnRJdGVtIiwicmlnaHRJdGVtIiwiZmF2b3JpdGVBZGRDZWxsIiwiZW5hYmxlQnV0dG9uIiwiZGlzYWJsZUJ1dHRvbiIsImhhbmRsZVNpbmdsZUxpc3REYXRhIiwiZGF0YU1hcCIsImxpc3RUeXBlIiwiY2VsbExpc3QiLCJzY3JlZW4iLCJ0aXRsZUNlbGwiLCJzY3JlZW5PYmplY3QiLCJzY3JlZW5MaXN0T2JqZWN0Iiwic2NyZWVuVmFsdWUiLCJpdGVtTGlzdCIsIm11bHRpcGxlTWFwIiwidGl0bGVNYXAiLCJ0aXRsZUNlbGxUeXBlIiwic2NyZWVuVGl0bGUiLCJ1bnRyYWRlYWJsZU1heENvdW50Iiwidm9sdW1lU3RyIiwiaGFuZGxlUmFua2luZ0xpc3REYXRhIiwiZmlsdGVyTGlzdERhdGEiLCJmaWx0ZXIiLCJQcm9taXNlIiwiYWxsIiwiY29sb3IiLCJmb250IiwicG9pbnRWaXNpYmlsaXR5IiwibGF0ZXN0VXBDYWNoZSIsImxhdGVzdFVwQ2FjaGVUaW1lIiwiaGludCIsInR5cGVUaXRsZSIsInRpdGxlU2l6ZSIsInNldHVwUHJvY2Vzc2VkVGl0bGVEYXRhIiwic2V0dXBQcm9jZXNzZWRMaXN0RGF0YSIsInN1YlR5cGVTdHIiLCJnZXRNb3JlQWN0aW9uRGF0YSIsIm5ld1RpdGxlRGF0YSIsIm5ld0xpc3REYXRhIiwiYWN0aW9uRGF0YSIsInJlcXVlc3RNb3JlQWN0aW9uRGF0YSIsInVwZGF0ZUZhdm9yaXRlc1N5bWJvbHMiLCJzeW1ib2xzIiwidHJhZGluZ1BhaXJzIiwid2Vic2l0ZSIsInJlc2V0RmF2b3JpdGVzTGlzdERhdGEiLCJjaGVja1JlcXVlc3RUaW1lciIsInJlc2V0V2lsbFVwQ2VsbEluVGltZXIiLCJuZXdEYXRlIiwibWlsbGlzZWNvbmRzIiwicmVzZXRNYXJrZXRUaXRsZSIsInRpdGxlUHJvcGVydHkiLCJyYW5raW5nQ2xpY2tlZCIsImFuYWx5dGljc0pzb24iLCJvcmlnaW5JdGVtIiwibW9yZUJ1dHRvbkNsaWNrZWQiLCJ0YXJnZXQiLCJoNVVybCIsImp1bXBUeXBlIiwicHJpbWFyeVRpdGxlIiwiaGJfaXNSYW5raW5nTGlzdEZhdm91cml0ZXMiLCJoYl9pc1JhbmtpbmdMaXN0RnV0dXJlIiwiaW50ZXJhY3Rpb25UaXRsZUNsaWNrIiwic2NyZWVuTWFwIiwic2VsZWN0ZWRGYXZvcml0ZVN5bWJvbCIsInRhYkNsaWNrIiwicmVzZXRUaXRsZVNlbGVjdFRhYiIsInNlbGVjdGVkSXRlbSIsInNlbGVjdGVkQ2hhbmdlIiwibW9yZUFjdGlvbkRhdGEiLCJnb1RvRmF2b3JpdGVzIiwiYWRkRmF2b3JpdGVzQ2xpY2siLCJPYmplY3QiLCJrZXlzIiwiYWRkRmF2b3JpdGVzU3ltYm9scyIsImN1cnJlbnRVSUQiLCJyYW5raW5nUG9wQ2xpY2siLCJjYW5jZWwiLCJwb3BEaXNtaXNzIiwidGltZXJPYmplY3QiLCJjdXJyZW50TG9naW5TdGF0ZUtleSIsImluaXRFbmdpbmUiLCJwYWdlQXBwZWFyIiwic3RhcnRUaW1lciIsImJhbm5lci5zdGFydFNjcm9sbCIsIm5hdi5yZWZyZXNoQXZhdGFyIiwiY29tbW9uLnJlcXVlc3RTZXJ2aWNlc1RpbWUiLCJwYWdlRGlzYXBwZWFyIiwiY2xlYXJUaW1lciIsImJhbm5lci5lbmRTY3JvbGwiLCJiYW5uZXIuY2xlYXJCYW5uZXJFeHBvc3VyZU1hcCIsIm9wZXJhdGlvbi5jbGVhck9wZXJhdGlvbkV4cG9zdXJlTWFwIiwiY3ViZS5jbGVhckN1YmVFeHBvc3VyZU1hcCIsInNldEludGVydmFsIiwiY2xlYXJJbnRlcnZhbCIsIm5hdi5jaGVja01lc3NhZ2VDb3VudFRpbWVyIiwicmFua2luZy5jaGVja1JlcXVlc3RUaW1lciIsImludmVzdC5ydW5UcmFkaW5nVG9FYXJuQ291bnREb3duIiwiY3ViZS5jb3VudERvd24iLCJzZW5kU3ltYm9sSW5mbyIsInNlbmRTb2NrZXREYXRhIiwiYXNzaWduIiwicmFua2luZy5yZXNldE1hcmtldERhdGEiLCJtYXJrZXQucmVzZXRNYXJrZXREYXRhIiwiY29tbW9uLnNlbmRMb2dpblN0YXR1cyIsImxvZ2luU3RhdGVLZXkiLCJuYXYubG9naW5TdGF0ZUNoYW5nZSIsInJhbmtpbmcubG9naW5TdGF0ZUNoYW5nZSIsImd1aWRlLmxvZ2luU3RhdGVDaGFuZ2UiLCJiYW5uZXIubG9naW5TdGF0ZUNoYW5nZSIsInNlbmRSYXRlVHlwZVN0ciIsImNoYXJhY3RlciIsInJhbmtpbmcucmVzZXRNYXJrZXRUaXRsZSIsImNvbW1vbi5zZW5kQ29tbW9uQ29uZmlnIiwidXBkYXRlSGFzTmV3VmVyc2lvbiJdLCJtYXBwaW5ncyI6IkFBaUJBLElBQUlBLEtBQUssSUFVUEMsS0FBSyxHQUdMQyxTQUFTLEtBR1RDLFlBQVksS0FPWkMsTUFBTSxHQVFOQyxLQUFLLElBT0xDLE9BQU8sYUFDUEMsVUFBVUQsT0FBTyxZQUNqQkUsYUFBYUQsVUFBVSxrQkFDdkJFLGFBQWFGLFVBQVUsaUJBQ3ZCRyxjQUFjSixPQUFPLG9CQUdyQkssSUFBSSxDQUFFLEdBQ05DLGlCQUFpQixHQUNqQkMsVUFBVTs7QUFPWixTQUFTQztJQVFQLFNBQVNDLElBQUlDO1FBQ1gsSUFBSUMsSUFBSUM7UUFHUixNQUFNRCxhQUFhRixNQUFNLE9BQU9DLE1BQU1KLFlBQVlFLFVBQVUsSUFBSUMsSUFBSUM7UUFHcEUsSUFBSUEsYUFBYUQsS0FBSztZQUNwQkUsRUFBRUUsSUFBSUgsRUFBRUc7WUFDUkYsRUFBRUcsSUFBSUosRUFBRUk7WUFDUkgsRUFBRUksSUFBSUwsRUFBRUssRUFBRUM7QUFDaEIsZUFBVztZQUNMQyxNQUFNTixHQUFHRDtBQUNWO1FBTURDLEVBQUVPLGNBQWNUO0FBQ2pCO0lBRURBLElBQUlVLFlBQVlkO0lBQ2hCSSxJQUFJZixLQUFLQTtJQUNUZSxJQUFJZCxLQUFLQTtJQUNU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
