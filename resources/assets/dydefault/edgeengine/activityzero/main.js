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

function add(x, y) {
    return new Big(x).plus(y).toString();
}

function subtract(x, y) {
    return new Big(x).minus(y).toString();
}

function multiply(x, y) {
    return new Big(x).times(y).toString();
}

function divide(x, y) {
    return new Big(x).div(y).toString();
}

function format(value, precision) {
    const bigValue = new Big(value);
    let stringValue = bigValue.toString();
    stringValue = scientificToNumber(stringValue);
    if (stringValue.includes(".")) {
        let strArray = stringValue.split(".");
        if (strArray[1].length >= precision) {
            if (0 == precision) {
                return strArray[0];
            } else {
                let truncate = strArray[1].substring(0, precision);
                return `${strArray[0]}.${truncate}`;
            }
        } else {
            let zeroNumber = precision - strArray[1].length;
            var str = "";
            for (let i = 0; i < zeroNumber; i++) {
                str += "0";
            }
            return `${stringValue}${str}`;
        }
    } else {
        if (0 == precision) {
            return stringValue;
        } else {
            let zeroNumber = precision;
            var str = "";
            for (let i = 0; i < zeroNumber; i++) {
                str += "0";
            }
            return `${stringValue}.${str}`;
        }
    }
}

function bignumber(arr) {
    if (Array.isArray(arr)) {
        return arr.map((value => Big(value).toFixed()));
    } else {
        return Big(arr).toFixed();
    }
}

function scientificToNumber(num) {
    if (/\d+\.?\d*e[\+\-]*\d+/i.test(num)) {
        let zero = "0";
        let parts = String(num).toLowerCase().split("e");
        let e = parts[1];
        let zeroLen = Math.abs(e);
        let sign = e / zeroLen;
        let beforeArr = parts[0].split(".");
        if (sign < 0) {
            num = zero + "." + new Array(zeroLen).join(zero) + beforeArr.join("");
        } else {
            let dec = beforeArr[1];
            if (dec) {
                zeroLen = zeroLen - dec.length;
                num = beforeArr.join("") + new Array(zeroLen + 1).join(zero);
            }
        }
    }
    return num;
}

var clickable = true;

const UnitType = {
    unitTypeSymbol: "symbol",
    unitTypeUSDT: "usdt"
};

const TabType = {
    tabTypePosition: "position",
    tabTypeOpenOrders: "openOrders",
    tabTypeOrders: "orders",
    tabTypeHistory: "history"
};

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
    linearSwapWsData: {},
    unitType: UnitType.unitTypeSymbol,
    lastUnitType: UnitType.unitTypeSymbol,
    openSingleMargin: true,
    curTabType: TabType.tabTypePosition,
    isChild: false,
    bottomBarHeight: 0
};

async function subPriceWebSocket(type = "linearSwapWs") {
    await $nativeAPI.copyTradingBridge({
        action: "subPriceWebSocket",
        type: type
    });
}

async function unsubPriceWebSocket(type = "linearSwapWs") {
    await $nativeAPI.copyTradingBridge({
        action: "unsubPriceWebSocket",
        type: type
    });
}

function getModelByContractShortType(contractShortType) {
    for (let i = 0; i < commonData.contractInfoData.length; i++) {
        if (commonData.contractInfoData[i].contract_short_type == contractShortType) {
            return commonData.contractInfoData[i];
        }
    }
    return null;
}

function getPriceTickPrecision(contractInfo) {
    if (null == contractInfo) {
        return 4;
    }
    var sizeString = bignumber(contractInfo.price_tick);
    return sizeString.split(".")[1].length;
}

async function sendRequest(path, params = {}, method = 0, hostType = 0, header = {}, returnStatus = 0) {
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
            var err_code = response["err-code"];
            var err_msg = response["err-msg"];
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
            if (data == null) {
                return response;
            }
            console.log(`request ${path} done`);
            return data;
        } else if ((code == null || code == "" || code == "undefined") && response.status == "ok") {
            if (data == null) {
                return response;
            }
            console.log(`request ${path} done`);
            return data;
        } else if (returnStatus == 1) {
            var status = response.status;
            var err_code = response["err-code"];
            var err_msg = response["err-msg"];
            if (status == "ok") {
                console.log(`request ${path} done`);
                return data;
            } else {
                console.log(`request failed, code=${err_code}, message=${err_msg}`);
                if (method != 0) {
                    showToast(err_msg);
                }
                return null;
            }
        } else {
            console.log(`request failed, code=${code}`);
            let message = response.message;
            if (message) {
                showToast(message);
            }
            return null;
        }
    } catch (e) {
        console.log(`request error, error=${e}`);
        return null;
    }
}

function formatPrecision(value, precision) {
    try {
        const result = format(value, precision);
        return result;
    } catch (e) {
        console.log(e);
        return value.toFixed(precision);
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

async function sendCommonConfig$1(param) {
    console.log(param);
    commonData.contractH5Url = param.contractH5Url;
    commonData.currencyRate = param.currencyRate;
    commonData.currencyCharacter = param.currencyCharacter;
    commonData.priceColorType = parseInt(param.priceColorType);
    commonData.colorMode = parseInt(param.colorMode);
    commonData.OS = parseInt(param.OS);
    commonData.appVersion = param.appVersion;
    commonData.isInReview = parseInt(param.isInReview);
    commonData.language = param.language;
    commonData.webUrl = param.webUrl;
    if (parseInt(param.OS) == 0) {
        commonData.bottomBarHeight = parseInt(param.bottomBarHeight);
    }
    var redColorList = [ "#ADB0B2", "#E94359", "#DE2941", "#CE142B" ];
    var greenColorList = [ "#ADB0B2", "#00A171", "#008B61", "#006245" ];
    if (parseInt(commonData.priceColorType) == 0) {
        upColorList = redColorList;
        downColorList = greenColorList;
    } else {
        upColorList = greenColorList;
        downColorList = redColorList;
    }
}

function getUpDownColor(isUpper = true, level = 1) {
    const lev = level < 4 ? level : 0;
    if (isUpper) {
        return upColorList[lev];
    }
    return downColorList[lev];
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

Date.prototype.Format = function(fmt) {
    var o = {
        "M+": this.getMonth() + 1,
        "d+": this.getDate(),
        "h+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds(),
        "q+": Math.floor((this.getMonth() + 3) / 3),
        S: this.getMilliseconds()
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o) if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
    return fmt;
};

function showLoading(isShow = true) {
    $nativeAPI.showLoading(isShow ? 1 : 0);
}

function getPNGIconURLByCurrency(currency) {
    let baseUrl = commonData.webUrl ? commonData.webUrl : "";
    return `${baseUrl}/-/x/hb/p/api/contents/currency/icon_png/${currency.toLowerCase()}.png`;
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

function toNumber(obj) {
    const num = Number(obj);
    return isNaN(num) ? 0 : num;
}

function getHandicapColor(isLong = true) {
    let colorType = commonData.priceColorType;
    if (colorType == 0) {
        return isLong ? "#1AE94359" : "#1A00A171";
    } else {
        return isLong ? "#1A00A171" : "#1AE94359";
    }
}

function isInvalidString(str) {
    return !str || str.length === 0 || str == "undefined";
}

let oneCallback;

let leftCallback;

let rightCallback;

async function start$4() {}

function defaultData$4() {
    return {
        titleVisibility: "visible",
        oneButtonVisibility: "gone",
        twoButtonVisibility: "visible",
        centerButtonText: $i18n.n_copy_trading_me_know,
        leftButtonText: $i18n.n_cancel,
        rightButtonText: $i18n.n_sure,
        popTitle: $i18n.n_copy_trading_tip,
        popContent: "--",
        toastType: -1,
        popShow: false
    };
}

const {moduleData: moduleData$4, moduleEvent: moduleEvent$4} = moduleDefine("commonPop", start$4, defaultData$4);

function popUpContentOfOneButton(title, conetent, centerText, titleVisibility = "visible", oneBtnCallBack = null) {
    oneCallback = oneBtnCallBack;
    moduleData$4.oneButtonVisibility = "visible";
    moduleData$4.twoButtonVisibility = "gone";
    moduleData$4.titleVisibility = titleVisibility;
    if (title && title !== null) {
        moduleData$4.popTitle = title;
    }
    if (conetent && conetent !== null) {
        moduleData$4.popContent = conetent;
    }
    if (centerText && centerText !== null) {
        moduleData$4.centerButtonText = centerText;
    }
    if (!moduleData$4.popShow) {
        moduleData$4.popShow = true;
    }
}

function popUpContentOfTwoButton(type, title, content, leftText, rightText, titleVisibility = "visible", leftBtnCallback = null, rightBtnCallback) {
    leftCallback = leftBtnCallback;
    rightCallback = rightBtnCallback;
    moduleData$4.oneButtonVisibility = "gone";
    moduleData$4.twoButtonVisibility = "visible";
    moduleData$4.titleVisibility = titleVisibility;
    if (title && title !== null) {
        moduleData$4.popTitle = title;
    }
    if (content && content !== null) {
        moduleData$4.popContent = content;
    }
    if (leftText && leftText !== null) {
        moduleData$4.leftButtonText = leftText;
    }
    if (rightText && rightText !== null) {
        moduleData$4.rightButtonText = rightText;
    }
    moduleData$4.toastType = type;
    if (!moduleData$4.popShow) {
        moduleData$4.popShow = true;
    }
}

moduleEvent$4.popDismiss = function() {
    moduleData$4.popShow = false;
};

moduleEvent$4.btnClick = function(type) {
    moduleData$4.popShow = false;
    if (type == 0 && oneCallback != null) {
        oneCallback();
    } else if (type == 1 && leftCallback != null) {
        leftCallback();
    } else if (type == 2 && rightCallback != null) {
        rightCallback();
    }
};

function defaultData$3() {
    return {};
}

async function start$3() {}

const {moduleData: moduleData$3, moduleEvent: moduleEvent$3} = moduleDefine("position", start$3, defaultData$3);

async function showActivityRuleDialog() {
    await analytics("appclick_contracts", {
        business_category: "usdt_0_yuan_buy",
        button_name: "usdt_assistance_0_yuan"
    });
    let rules = $i18n.n_zero_swap_activity_rule_content_1 + "\n" + $i18n.n_zero_swap_activity_rule_content_2 + "\n" + $i18n.n_zero_swap_activity_rule_content_3 + "\n" + $i18n.n_zero_swap_activity_rule_content_4 + "\n" + $i18n.n_zero_swap_activity_rule_content_5;
    popUpContentOfOneButton($i18n.n_zero_swap_activity_rule_title, rules, $i18n.n_copy_trading_me_know, "visible", null);
}

moduleEvent$3.showActivityRuleDialog = showActivityRuleDialog;

function defaultData$2() {
    return {
        bannerCurrentIndex: "0",
        bannerList: [],
        bannerVisibility: "gone",
        bannerAndroidStrokeVisibility: commonData.OS == 1 ? "visible" : "gone",
        bannerIndicatorList: [],
        bannerIndicatorVisibility: "gone",
        bannerAutoScroll: "true",
        pnl: "--",
        activityPnlVisibility: "gone",
        activityPnl: $i18n.$intercept.n_zero_swap_recharge_profit("-"),
        activityCountDownTime: "--" + $i18n.n_day + " " + "-- : -- : --",
        tabInfo: `{"tabs":[{"title":"${$i18n.n_zero_swap_my_position}","template":"openPosition","module":"openPosition","onAppear":"openPosition.onAppear"},{"title":"${$i18n.n_exchange_order_history_orders}","template":"historyPosition","module":"historyPosition","onAppear":"historyPosition.onAppear"}]}`
    };
}

async function start$2() {}

const {moduleData: moduleData$2, moduleEvent: moduleEvent$2} = moduleDefine("headerProfit", start$2, defaultData$2);

let timer$1;

let remainingSeconds$1 = 0;

function startCountdown$1() {
    cancelCountdown$1();
    timer$1 = setInterval((() => {
        if (remainingSeconds$1 >= 0) {
            let days = Math.floor(remainingSeconds$1 / (24 * 60 * 60));
            let hours = Math.floor(remainingSeconds$1 % (24 * 60 * 60) / (60 * 60));
            let minutes = Math.floor(remainingSeconds$1 % (60 * 60) / 60);
            let seconds = remainingSeconds$1 % 60;
            days = days < 10 ? "0" + days : days;
            hours = hours < 10 ? "0" + hours : hours;
            minutes = minutes < 10 ? "0" + minutes : minutes;
            seconds = seconds < 10 ? "0" + seconds : seconds;
            moduleData$2.activityCountDownTime = `${days.toString()} ${$i18n.n_day} ${hours.toString()} : ${minutes.toString()} : ${seconds.toString()}`;
            remainingSeconds$1--;
        } else {
            cancelCountdown$1();
            moduleData$2.activityPnlVisibility = "gone";
            console.log("倒计时结束");
        }
    }), 1e3);
}

function cancelCountdown$1() {
    if (timer$1 != null) {
        clearInterval(timer$1);
        timer$1 = null;
        console.log("倒计时已取消");
    }
}

async function requestHeaderProfit() {
    const data = await sendRequest("v1/activity/zero/parity/profit", {}, 0, 0, {
        "Content-Type": "application/json"
    });
    moduleData$2.pnl = data.totalProfit;
    cancelCountdown$1();
    if (data.positionProfit == null) {
        moduleData$2.activityPnlVisibility = "gone";
    } else {
        let goldStatus = toNumber(data.goldStatus);
        remainingSeconds$1 = Math.floor(toNumber(data.goldExpireTime) / 1e3);
        if (remainingSeconds$1 > 0) {
            if (1 == goldStatus) {
                moduleData$2.activityPnlVisibility = "gone";
            } else {
                let positionProfit = toNumber(data.positionProfit);
                if (positionProfit > 0) {
                    moduleData$2.activityPnl = $i18n.$intercept.n_zero_swap_recharge_profit(positionProfit.toString());
                } else {
                    moduleData$2.activityPnl = $i18n.n_zero_swap_recharge_reward;
                }
                startCountdown$1();
                moduleData$2.activityPnlVisibility = "visible";
            }
        } else {
            moduleData$2.activityPnlVisibility = "gone";
        }
    }
}

async function appear() {
    requestBannerInfo();
    await requestHeaderProfit();
}

function disappear$1() {
    cancelCountdown$1();
}

moduleEvent$2.selectedBannerIndex = async function(index) {
    moduleData$2.bannerCurrentIndex = String(index);
    handleSliderIndicatorView();
};

moduleEvent$2.bannerClickBanner = async function() {
    var index = parseInt(moduleData$2.bannerCurrentIndex);
    if (index >= moduleData$2.bannerList.length) {
        return;
    }
    var obj = moduleData$2.bannerList[index];
    if (!isInvalidString(obj.jumpTo)) {
        openURL(obj.jumpTo);
        await analytics("appclick_contracts", {
            business_category: "top_ad_trade",
            button_name: "top_ad_trade_go",
            banner_id: String(obj.advId),
            banner_name: obj.title
        });
    }
};

async function requestBannerInfo() {
    var params = {
        pageType: 73,
        showType: 9
    };
    let data = await sendRequest("v1/config/push/banner/list", params);
    if (data && data != null && data.bannerAdvList != null || data.bannerAdvList.length > 0) {
        for (let i = 0; i < data.bannerAdvList.length; ++i) {
            let v = data.bannerAdvList[i];
            v.index = i;
            v.type = "1";
            v.currentImageURL = commonData.colorMode === 1 ? v.nightImageUrl : v.imageUrl;
        }
        handleSliderView(data.bannerAdvList);
    } else {
        handleSliderView([]);
    }
}

async function handleSliderView(list) {
    moduleData$2.bannerList = list;
    moduleData$2.bannerVisibility = list.length > 0 ? "visible" : "gone";
    moduleData$2.bannerAndroidStrokeVisibility = commonData.OS == 1 ? list.length > 0 ? "visible" : "gone" : "gone";
    handleSliderIndicatorView();
    if (list.length > 0) {
        await analytics("pageview_contracts", {
            business_category: "top_ad_trade"
        });
    }
}

function handleSliderIndicatorView() {
    let indicatorList = [];
    for (let index = 0; index < moduleData$2.bannerList.length; index++) {
        if (moduleData$2.bannerCurrentIndex == String(index)) {
            indicatorList.push({
                type: "1"
            });
        } else {
            indicatorList.push({
                type: "2"
            });
        }
    }
    moduleData$2.bannerIndicatorList = indicatorList;
    moduleData$2.bannerIndicatorVisibility = indicatorList.length > 1 ? "visible" : "gone";
}

function getProfit(openPrice, latestPrice, amount, direction) {
    if (openPrice == "" || latestPrice == "" || amount == "") {
        return "";
    }
    let delta = "";
    if (direction == 1) {
        delta = subtract(latestPrice, openPrice);
    } else {
        delta = subtract(openPrice, latestPrice);
    }
    let profit = formatPrecision(multiply(delta, amount), 4);
    return profit;
}

function getProfitRate(openPrice, latestPrice, amount, direction, leverRate) {
    if (openPrice == "" || latestPrice == "" || amount == "" || leverRate == "") {
        return "";
    }
    let delta = "";
    if (direction == 1) {
        delta = subtract(latestPrice, openPrice);
    } else {
        delta = subtract(openPrice, latestPrice);
    }
    let ratio = multiply(divide(delta, openPrice), leverRate);
    let profitRate = multiply(ratio, 100);
    let profitRateStr = formatPrecision(profitRate, 2);
    return profitRateStr;
}

function getPositionValue(amount, latestPrice) {
    if (amount == "" || latestPrice == "") {
        return "";
    }
    return multiply(amount, latestPrice);
}

function getUnrealizedProfitOrLoss(openPrice, latestPrice, amount, direction) {
    if (openPrice == "" || latestPrice == "" || amount == "") {
        return "";
    }
    let delta = "";
    if (direction == 1) {
        delta = subtract(latestPrice, openPrice);
    } else {
        delta = subtract(openPrice, latestPrice);
    }
    let profit = formatPrecision(multiply(delta, amount), 4);
    return profit;
}

function getMarginRate(openPrice, latestPrice, amount, direction, leverRate, margin) {
    if (openPrice == "" || latestPrice == "" || amount == "" || leverRate == "" || margin == "") {
        return "--";
    }
    let positionValue = getPositionValue(amount, latestPrice);
    let value1 = multiply(positionValue, .005);
    let profit = getUnrealizedProfitOrLoss(openPrice, latestPrice, amount, direction);
    let value2 = add(margin, profit);
    let marginRate = multiply(divide(value1, value2), 100);
    let marginRateStr = formatPrecision(marginRate, 2);
    return `${marginRateStr}%`;
}

function getLiquidationPrice(openPrice, latestPrice, amount, leverRate, margin, direction, precision) {
    if (openPrice == "" || latestPrice == "" || amount == "" || leverRate == "" || margin == "" || direction == "") {
        return "--";
    }
    let value1 = divide(margin, amount);
    let value2 = "";
    let value3 = "";
    if (direction == 1) {
        value2 = subtract(openPrice, value1);
        value3 = divide(value2, 1 - .005);
    } else {
        value2 = add(openPrice, value1);
        value3 = divide(value2, 1 + .005);
    }
    return formatPrecision(value3, precision);
}

var curList$1 = [];

var giftStepList = [];

let itemTimer;

let totalCountdownSeconds = 0;

var isRequest = false;

function defaultData$1() {
    return {
        loadingLottieStatus: "stop",
        openPositionList: [],
        listViewVisibility: "gone",
        osListViewVisibility: "gone",
        emptyViewVisibility: "gone",
        curCloseIndex: -1,
        lastFoldIndex: 0,
        closePositionData: {},
        closePositionActivityDialogMaxPnlPrefix: $i18n.$intercept.n_zero_swap_profit_close_position(""),
        closePositionActivityDialog: {
            pnl: "-" + " " + $i18n.n_personal_center_reward_unit,
            pnlColor: "@color/kColorPriceGreen",
            maxPnl: "-" + " " + $i18n.n_personal_center_reward_unit,
            maxActivityPnl: $i18n.$intercept.n_zero_swap_highest_limited_time_reward("-"),
            onlyClosePositionPnl: $i18n.$intercept.n_zero_swap_obtain_immediately("-"),
            profitVisibility: "visible",
            lossVisibility: "gone"
        },
        closePositionActivityDialogShow: "false",
        closePositionSuccessDialog: {
            show: "false",
            pnl: "-" + " " + $i18n.n_personal_center_reward_unit
        },
        rechargeRewardsDialog: {
            show: "false",
            indicatorColor: commonData.colorMode == 1 ? "#1AEAEAEA" : "#1A000000",
            leverList: []
        },
        rechargeRewardsDialogDay: "--",
        rechargeRewardsDialogHour: "--",
        rechargeRewardsDialogMinute: "--",
        rechargeRewardsDialogSecond: "--",
        closePositionOnlyDialog: {
            pnl: "-" + " " + $i18n.n_personal_center_reward_unit,
            pnlColor: "@color/kColorPriceGreen",
            maxPnl: "-" + " " + $i18n.n_personal_center_reward_unit,
            profitVisibility: "gone",
            lossVisibility: "visible"
        },
        closePositionOnlyDialogShow: "false",
        bottomBarHeight: 0
    };
}

async function start$1() {
    if (commonData.bottomBarHeight > 0) {
        moduleData$1.bottomBarHeight = commonData.bottomBarHeight;
    }
    showLoading(true);
    await requestContractInfoData();
    requestPositionList$2();
    requestGiftStep();
}

const {moduleData: moduleData$1, moduleEvent: moduleEvent$1} = moduleDefine("openPosition", start$1, defaultData$1);

async function requestContractInfoData() {
    console.log("requestContractInfoData");
    var params = {
        business_type: "all",
        trade_partition: "all"
    };
    var respData = await sendRequest("linear-swap-order/x/v1/linear_swap_contract_info", params, 0, 8);
    if (respData) {
        commonData.contractInfoData = respData;
    }
}

async function requestPositionList$2() {
    var param = {
        state: 1,
        pageNum: 1,
        pageSize: 20
    };
    if (isRequest) {
        return;
    }
    isRequest = true;
    const data = await sendRequest("v1/activity/zero/position/list", param, 0, 0, {
        "Content-Type": "application/json"
    });
    isRequest = false;
    if (!data || data == null || !data.list || data.list == null || data.list.length == 0) {
        setListVisible$1(false);
        curList$1 = [];
        moduleData$1.openPositionList = [];
        return;
    }
    setListVisible$1(true);
    try {
        const {total: total, list: list} = data;
        moduleData$1.total = total;
        totalCountdownSeconds = 0;
        handleOpenPositionData(list);
    } catch (e) {
        console.log(`handle requestPositionList data error=${e}`);
    }
}

function setListVisible$1(visible) {
    if (true == visible) {
        moduleData$1.emptyViewVisibility = "gone";
        moduleData$1.osListViewVisibility = "visible";
    } else {
        moduleData$1.emptyViewVisibility = "visible";
        moduleData$1.osListViewVisibility = "gone";
    }
}

async function handleOpenPositionData(list) {
    for (let i = 0; i < list.length; ++i) {
        let v = list[i];
        var strArray = v.symbol.split("-");
        let baseCurrency = strArray[0].toUpperCase();
        let quoteCurrency = strArray[1].toUpperCase();
        v.baseCurrency = baseCurrency;
        v.quoteCurrency = quoteCurrency;
        v.type = "1";
        v.index = i;
        v.dayUnit = $i18n.n_day;
        v.icon = getPNGIconURLByCurrency(baseCurrency);
        v.disPlaySymbol = $i18n.$intercept.n_contract_swap_trade_name(`${baseCurrency}${quoteCurrency}`);
        v.klineTitle = `${baseCurrency}${quoteCurrency}${$i18n.n_market_contract_swap_trade_name_abbr} ${$i18n.n_zero_swap_kline_chart}`;
        v.marginMode = $i18n.n_contract_trade_margin;
        v.lever = `${v.leverageRatio}X`;
        v.pnlName = $i18n.n_contract_profit + "(" + quoteCurrency + ")";
        v.positionAmountTitle = $i18n.$intercept.n_contarct_position_volume_label(baseCurrency);
        v.marginName = $i18n.n_bond + "(" + quoteCurrency + ")";
        v.openAvgPxName = $i18n.$intercept.n_linear_swap_open_price(quoteCurrency);
        v.liqPxName = $i18n.$intercept.n_linear_swap_prediction_of_strong_parity(`(${quoteCurrency})`);
        v.marginRatioName = $i18n.n_asset_margin_rate;
        v.pnlRatioName = $i18n.n_contract_yield;
        if (v.direction == 1) {
            v.posSide = $i18n.n_asset_future_buy;
            v.posSideColor = getUpDownColor();
            v.posSidebackColor = getHandicapColor();
        } else {
            v.posSide = $i18n.n_asset_future_sell;
            v.posSideColor = getUpDownColor(false);
            v.posSidebackColor = getHandicapColor(false);
        }
        v.amount = v.positionAmount;
        v.openAvgPx = v.openPrice;
        v.margin = v.positionMargin;
        v.showChart = moduleData$1.lastFoldIndex == i ? "visible" : "gone";
        v.updownImage = moduleData$1.lastFoldIndex == i ? "@drawable/edge_engine_arrow_up" : "@drawable/edge_engine_arrow_down";
        v.fold = moduleData$1.lastFoldIndex == i ? true : false;
        let remainingSeconds = Math.floor((v.positionFinishTime || 0) / 1e3) - totalCountdownSeconds;
        if (remainingSeconds > 0) {
            let days = Math.floor(remainingSeconds / (24 * 60 * 60));
            let hours = Math.floor(remainingSeconds % (24 * 60 * 60) / (60 * 60));
            let minutes = Math.floor(remainingSeconds % (60 * 60) / 60);
            let seconds = remainingSeconds % 60;
            v.day = (days < 10 ? "0" + days : days).toString();
            v.hour = (hours < 10 ? "0" + hours : hours).toString();
            v.minute = (minutes < 10 ? "0" + minutes : minutes).toString();
            v.second = (seconds < 10 ? "0" + seconds : seconds).toString();
            v.effectiveTimeVisibility = "visible";
            v.title = $i18n.n_zero_swap_position_effective_period;
            v.closeVisibility = "visible";
            v.showClose = true;
        } else {
            v.effectiveTimeVisibility = "gone";
            v.title = $i18n.n_zero_swap_position_has_expired;
            v.closeVisibility = "gone";
            v.showClose = false;
        }
        dealPriceCalculation(v);
    }
    curList$1 = list;
    moduleData$1.openPositionList = curList$1;
    updateOSData();
    showLoading(false);
    startItemCountdown();
}

async function startItemCountdown() {
    cancelItemCountdown();
    itemTimer = setInterval((() => {
        if (curList$1.length > 0) {
            for (let i = 0; i < curList$1.length; ++i) {
                let v = curList$1[i];
                try {
                    let remainingSeconds = Math.floor((v.positionFinishTime || 0) / 1e3) - totalCountdownSeconds;
                    if (remainingSeconds > 0) {
                        let days = Math.floor(remainingSeconds / (24 * 60 * 60));
                        let hours = Math.floor(remainingSeconds % (24 * 60 * 60) / (60 * 60));
                        let minutes = Math.floor(remainingSeconds % (60 * 60) / 60);
                        let seconds = remainingSeconds % 60;
                        v.day = (days < 10 ? "0" + days : days).toString();
                        v.hour = (hours < 10 ? "0" + hours : hours).toString();
                        v.minute = (minutes < 10 ? "0" + minutes : minutes).toString();
                        v.second = (seconds < 10 ? "0" + seconds : seconds).toString();
                        v.effectiveTimeVisibility = "visible";
                        v.title = $i18n.n_zero_swap_position_effective_period;
                        v.closeVisibility = "visible";
                        v.showClose = true;
                    } else {
                        v.effectiveTimeVisibility = "gone";
                        v.title = $i18n.n_zero_swap_position_has_expired;
                        v.closeVisibility = "gone";
                        v.showClose = false;
                    }
                    dealPriceCalculation(v);
                } catch (e) {
                    console.log(`refreshtime- 仓位有效期-e = ${e}`);
                }
            }
            moduleData$1.openPositionList = curList$1;
            updateOSData();
            totalCountdownSeconds++;
        }
    }), 1e3);
}

async function updateOSData() {
    moduleData$1.positionList = JSON.stringify(curList$1);
}

async function cancelItemCountdown() {
    if (itemTimer != null) {
        clearInterval(itemTimer);
        itemTimer = null;
    }
}

async function onAppear$1() {
    await analytics("appclick_contracts", {
        business_category: "usdt_0_yuan_buy",
        button_name: "usdt_my_position_0_yuan"
    });
    requestPositionList$2();
    subPriceWebSocket("linearSwapWs");
}

async function refreshProfit() {
    console.log(`wp---------refreshProfit`);
    if (Object.getOwnPropertyNames(commonData.linearSwapWsData).length == 0) {
        return;
    }
    if (curList$1.length > 0) {
        for (let i = 0; i < curList$1.length; ++i) {
            let v = curList$1[i];
            dealPriceCalculation(v);
        }
        moduleData$1.openPositionList = curList$1;
        updateOSData();
        updateClosePosition();
    }
    showLoading(false);
}

async function dealPriceCalculation(v) {
    try {
        var usePrice = "";
        let data = commonData.linearSwapWsData[v.symbol];
        if (data && typeof data !== "undefined" && data !== null && data.price !== null && data.price !== "" && data.price !== "undefined") {
            usePrice = data.price;
        } else {
            if (v && typeof v !== "undefined" && v.latestPrice !== undefined && v.latestPrice !== null && v.latestPrice !== "null" && v.latestPrice !== "") {
                usePrice = v.latestPrice;
            }
        }
        let profit = getProfit(v.openPrice, usePrice, v.amount, v.direction);
        v.profit = profit;
        if (parseFloat(profit) >= 0) {
            v.pnlColor = getUpDownColor();
            v.pnl = `+${profit}`;
        } else if (isNaN(parseFloat(profit))) {
            v.pnlColor = "@color/kColorSecondaryText";
            v.pnl = "--";
        } else {
            v.pnlColor = getUpDownColor(false);
            v.pnl = profit;
        }
        if (parseFloat(profit) > parseFloat(v.highestProfit)) {
            v.limitTips = $i18n.$intercept.n_zero_swap_limit_tips(` ${v.highestProfit} ${v.quoteCurrency}`);
        } else {
            v.limitTips = "";
        }
        let profitRate = getProfitRate(v.openPrice, usePrice, v.positionAmount, v.direction, v.leverageRatio);
        if (Number.parseFloat(profitRate) > 0) {
            v.pnlRatio = `+${profitRate}%`;
        } else if (isNaN(parseFloat(profitRate))) {
            v.pnlRatio = "--";
        } else {
            v.pnlRatio = `${profitRate}%`;
        }
        v.price = usePrice;
        let currentContractInfo = getModelByContractShortType(v.symbol);
        let precision = getPriceTickPrecision(currentContractInfo);
        v.liqPx = getLiquidationPrice(v.openPrice, usePrice, v.positionAmount, v.leverageRatio, v.positionMargin, v.direction, precision);
        v.marginRatio = getMarginRate(v.openPrice, usePrice, v.positionAmount, v.direction, v.leverageRatio, v.positionMargin, precision);
    } catch (e) {
        console.log(`dealPriceCalculation--e = ${e}`);
    }
}

async function clickedFold(index) {
    if (moduleData$1.lastFoldIndex > -1 && index != moduleData$1.lastFoldIndex) {
        var lastFoldItem = curList$1[moduleData$1.lastFoldIndex];
        if (lastFoldItem.fold) {
            lastFoldItem.fold = false;
            lastFoldItem.showChart = "gone";
            lastFoldItem.updownImage = "@drawable/edge_engine_arrow_down";
            moduleData$1.openPositionList[moduleData$1.lastFoldIndex] = lastFoldItem;
            curList$1[moduleData$1.lastFoldIndex] = lastFoldItem;
        }
    }
    var selectItem = curList$1[index];
    selectItem.fold = !selectItem.fold;
    selectItem.showChart = selectItem.fold ? "visible" : "gone";
    selectItem.updownImage = selectItem.fold ? "@drawable/edge_engine_arrow_up" : "@drawable/edge_engine_arrow_down";
    moduleData$1.openPositionList[index] = selectItem;
    curList$1[index] = selectItem;
    moduleData$1.lastFoldIndex = selectItem.fold ? index : -1;
    updateOSData();
}

async function clickClosePosition(index) {
    console.log(`clickClosePosition`);
    await analytics("appclick_contracts", {
        business_category: "usdt_0_yuan_buy",
        button_name: "usdt_close_0_yuan"
    });
    moduleData$1.curCloseIndex = index;
    var item = curList$1[index];
    var param = {
        positionId: item.id
    };
    const data = await sendRequest("v1/activity/zero/to/parity/position", param, 0, 0, {
        "Content-Type": "application/json"
    });
    if (!data || data == null) {
        return;
    }
    moduleData$1.closePositionData = data;
    var hasGift = data.hasGift;
    var item = curList$1[moduleData$1.curCloseIndex];
    let positionProfit = item.profit;
    if (isNaN(parseFloat(positionProfit))) {
        positionProfit = formatPrecision(moduleData$1.closePositionData.positionProfit, 4);
    }
    if (hasGift) {
        moduleData$1.closePositionActivityDialogShow = "true";
        updateClosePositionActivityDialog(positionProfit);
        await analytics("appexposure_contracts", {
            business_category: "usdt_0_yuan_buy",
            button_name: "usdt_deposit_rebate_pop_up"
        });
    } else {
        moduleData$1.closePositionOnlyDialogShow = "true";
        updateClosePositionOnlyDialog(positionProfit);
    }
}

async function updateClosePosition() {
    if (parseFloat(moduleData$1.curCloseIndex) > -1) {
        var item = curList$1[moduleData$1.curCloseIndex];
        let positionProfit = item.profit;
        if (moduleData$1.closePositionData != {}) {
            if (moduleData$1.closePositionData.hasGift) {
                updateClosePositionActivityDialog(positionProfit);
            } else {
                updateClosePositionOnlyDialog(positionProfit);
            }
        }
    }
}

async function updateClosePositionActivityDialog(positionProfit) {
    var highestProfit = moduleData$1.closePositionData.highestProfit;
    var onlyCloseProfit = positionProfit;
    if (parseFloat(positionProfit) < 0) {
        onlyCloseProfit = 0;
    } else if (parseFloat(positionProfit) > parseFloat(highestProfit)) {
        onlyCloseProfit = highestProfit;
    }
    var param = {
        pnl: `${positionProfit} ` + $i18n.n_personal_center_reward_unit,
        maxPnl: `${highestProfit} ` + $i18n.n_personal_center_reward_unit,
        maxActivityPnl: $i18n.$intercept.n_zero_swap_highest_limited_time_reward(moduleData$1.closePositionData.maxGiftProfit),
        onlyClosePositionPnl: $i18n.$intercept.n_zero_swap_obtain_immediately(`${onlyCloseProfit}`),
        profitVisibility: "visible",
        lossVisibility: "gone"
    };
    if (positionProfit != null && positionProfit > 0) {
        param["pnlColor"] = "@color/kColorPriceGreen";
    } else {
        param["pnlColor"] = "@color/kColorPrimaryText";
    }
    showClosePositionActivityDialog(param);
}

async function updateClosePositionOnlyDialog(positionProfit) {
    var highestProfit = moduleData$1.closePositionData.highestProfit;
    var param = {
        pnl: `${positionProfit} ` + $i18n.n_personal_center_reward_unit,
        pnlColor: "@color/kColorPriceGreen",
        maxPnl: `${highestProfit} ` + $i18n.n_personal_center_reward_unit
    };
    if (positionProfit != null && positionProfit > 0) {
        param["pnlColor"] = "@color/kColorPriceGreen";
        param["profitVisibility"] = "visible";
        param["lossVisibility"] = "gone";
    } else {
        param["pnlColor"] = "@color/kColorPrimaryText";
        param["profitVisibility"] = "gone";
        param["lossVisibility"] = "visible";
    }
    showClosePositionOnlyDialog(param);
}

async function showClosePositionActivityDialog(params) {
    moduleData$1.closePositionActivityDialog = params;
}

async function hideClosePositionActivityDialog(closeType) {
    moduleData$1.closePositionActivityDialogShow = "false";
    if (2 == closeType) {
        await analytics("appclick_contracts", {
            business_category: "usdt_0_yuan_buy",
            button_name: "usdt_close_position_deposit_0_yuan"
        });
        await sureParityPosition(closeType);
        showRechargeRewardsDialog(1);
    } else if (1 == closeType) {
        await analytics("appclick_contracts", {
            business_category: "usdt_0_yuan_buy",
            button_name: "usdt_only_close_0_yuan"
        });
        var hasGift = moduleData$1.closePositionData.hasGift;
        var maxGiftProfit = moduleData$1.closePositionData.maxGiftProfit;
        if (hasGift) {
            popUpContentOfTwoButton(-1, $i18n.n_zero_swap_only_close_position_title, $i18n.$intercept.n_zero_swap_only_close_position_content(maxGiftProfit), $i18n.n_cancel, $i18n.n_confirm, "visible", (async function() {
                await analytics("appclick_contracts", {
                    business_category: "usdt_0_yuan_buy",
                    button_name: "usdt_cancel_0_yuan"
                });
            }), (async function() {
                await analytics("appclick_contracts", {
                    business_category: "usdt_0_yuan_buy",
                    button_name: "usdt_confirm_0_yuan"
                });
                sureParityPosition(closeType);
            }));
        } else {
            await analytics("appclick_contracts", {
                business_category: "usdt_0_yuan_buy",
                button_name: "usdt_confirm_close_0_yuan"
            });
            sureParityPosition(closeType);
        }
    }
}

async function sureParityPosition(closeType) {
    var item = curList$1[moduleData$1.curCloseIndex];
    var param = {
        positionId: item.id,
        operationType: closeType
    };
    const data = await sendRequest("v1/activity/zero/sure/parity/position", param, 1, 0, {
        "Content-Type": "application/json"
    });
    if (data == null) {
        requestPositionList$2();
        return;
    }
    if (1 == closeType) {
        let pnl = toNumber(data);
        if (pnl > 0) {
            showClosePositionSuccessDialog(pnl.toString());
        } else {
            showToast($i18n.n_zero_swap_close_position_successful);
        }
    }
    if (item.fold) {
        moduleData$1.lastFoldIndex = -1;
    }
    moduleData$1.curCloseIndex = -1;
    moduleData$1.closePositionData = {};
    await requestPositionList$2();
    await appear();
}

async function showClosePositionOnlyDialog(params) {
    moduleData$1.closePositionOnlyDialog = params;
}

async function showClosePositionSuccessDialog(pnl) {
    moduleData$1.loadingLottieStatus = "play";
    moduleData$1.closePositionSuccessDialog = {
        show: "true",
        pnl: pnl + " " + $i18n.n_personal_center_reward_unit
    };
}

async function hideClosePositionSuccessDialog() {
    moduleData$1.closePositionSuccessDialog = {
        show: "false",
        pnl: "- " + $i18n.n_personal_center_reward_unit
    };
}

async function navigationClosePositionSuccessDialog() {
    await analytics("appclick_contracts", {
        business_category: "usdt_0_yuan_buy",
        button_name: "usdt_go_check_0_yuan"
    });
    hideClosePositionSuccessDialog();
    await openURL(`holigeit://open/v1?url=ihuobiglobal://m.hbg.com/contract/index`);
}

let timer;

let remainingSeconds = 0;

async function startCountdown() {
    cancelCountdown();
    const data = await sendRequest("v1/activity/zero/parity/profit", {}, 0, 0, {
        "Content-Type": "application/json"
    });
    remainingSeconds = Math.floor(toNumber(data.goldExpireTime) / 1e3);
    timer = setInterval((() => {
        if (remainingSeconds >= 0) {
            let days = Math.floor(remainingSeconds / (24 * 60 * 60));
            let hours = Math.floor(remainingSeconds % (24 * 60 * 60) / (60 * 60));
            let minutes = Math.floor(remainingSeconds % (60 * 60) / 60);
            let seconds = remainingSeconds % 60;
            days = days < 10 ? "0" + days : days;
            hours = hours < 10 ? "0" + hours : hours;
            minutes = minutes < 10 ? "0" + minutes : minutes;
            seconds = seconds < 10 ? "0" + seconds : seconds;
            moduleData$1.rechargeRewardsDialogDay = days.toString();
            moduleData$1.rechargeRewardsDialogHour = hours.toString();
            moduleData$1.rechargeRewardsDialogMinute = minutes.toString();
            moduleData$1.rechargeRewardsDialogSecond = seconds.toString();
            remainingSeconds--;
        } else {
            cancelCountdown();
            console.log("倒计时结束");
        }
    }), 1e3);
}

function cancelCountdown() {
    if (timer != null) {
        clearInterval(timer);
        timer = null;
        console.log("倒计时已取消");
    }
}

async function showRechargeRewardsDialog(showType) {
    if (0 == showType) {
        await analytics("appclick_contracts", {
            business_category: "usdt_0_yuan_buy",
            button_name: "usdt_recharge_promotion_0_yuan"
        });
    } else {
        await analytics("appexposure_contracts", {
            business_category: "usdt_0_yuan_buy",
            button_name: "usdt_recharge_exposure_pop_up"
        });
    }
    moduleData$1.rechargeRewardsDialogDay = "--";
    moduleData$1.rechargeRewardsDialogHour = "--";
    moduleData$1.rechargeRewardsDialogMinute = "--";
    moduleData$1.rechargeRewardsDialogSecond = "--";
    startCountdown();
    moduleData$1.rechargeRewardsDialog = {
        show: "true",
        leverList: giftStepList,
        indicatorColor: commonData.colorMode == 1 ? "#1AEAEAEA" : "#1A000000"
    };
}

async function hideRechargeRewardsDialog(closeType) {
    cancelCountdown();
    moduleData$1.rechargeRewardsDialog = {
        show: "false"
    };
    if (1 == closeType) {
        await analytics("appclick_contracts", {
            business_category: "usdt_0_yuan_buy",
            button_name: "usdt_go_recharge_0_yuan"
        });
        await openURL(`holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/balance/transfer?coin=USDT&account=11`);
    }
}

async function hideClosePositionOnlyDialog(closeType) {
    moduleData$1.closePositionOnlyDialogShow = "false";
    if (0 == closeType) ; else if (1 == closeType) {
        sureParityPosition(1);
        await analytics("appclick_contracts", {
            business_category: "usdt_0_yuan_buy",
            button_name: "usdt_confirm_close_0_yuan"
        });
    }
}

async function requestGiftStep() {
    const data = await sendRequest("v1/activity/zero/gift/step", {}, 0, 0, {
        "Content-Type": "application/json"
    });
    if (data == null) {
        return;
    }
    let leverList = [];
    for (let i = 0; i < data.length; i++) {
        let v = data[i];
        let suffix = i > 4 ? 4 : i;
        leverList.push({
            reward: `+${v.giftAmount} ${$i18n.n_personal_center_reward_unit}`,
            condition: `${v.incomeAmount} ${$i18n.n_personal_center_reward_unit}`,
            indicatorVisibility: i == data.length - 1 ? "gone" : "visible",
            drawable: `@drawable/edge_engine_zero_swap_reward_level_${suffix + 1}`,
            type: "normal"
        });
    }
    giftStepList = leverList;
}

function disappear() {
    cancelCountdown();
    cancelItemCountdown();
}

moduleEvent$1.onAppear = onAppear$1;

moduleEvent$1.clickedFold = clickedFold;

moduleEvent$1.clickClosePosition = clickClosePosition;

moduleEvent$1.hideClosePositionActivityDialog = hideClosePositionActivityDialog;

moduleEvent$1.showClosePositionActivityDialog = showClosePositionActivityDialog;

moduleEvent$1.navigationClosePositionSuccessDialog = navigationClosePositionSuccessDialog;

moduleEvent$1.hideRechargeRewardsDialog = hideRechargeRewardsDialog;

moduleEvent$1.hideClosePositionOnlyDialog = hideClosePositionOnlyDialog;

moduleEvent$1.showRechargeRewardsDialog = showRechargeRewardsDialog;

moduleEvent$1.hideClosePositionSuccessDialog = hideClosePositionSuccessDialog;

var pageNum = 1;

var curList = [];

function defaultData() {
    return {
        historyPositionList: [],
        listViewVisibility: "visible",
        emptyViewVisibility: "gone",
        refreshStatus: "2",
        loadMoreStatus: "0"
    };
}

async function start() {}

const {moduleData: moduleData, moduleEvent: moduleEvent} = moduleDefine("historyPosition", start, defaultData);

async function onRefresh() {
    await requestPositionList$1(false);
}

async function onLoadMore() {
    if (moduleData.total > moduleData.historyPositionList.length) {
        await requestPositionList$1(true);
    } else {
        moduleData.loadMoreStatus = "2";
    }
}

async function onAppear() {
    await analytics("appclick_contracts", {
        business_category: "usdt_0_yuan_buy",
        button_name: "usdt_history_0_yuan"
    });
    requestPositionList$1(false);
}

async function requestPositionList$1(isMore) {
    if (!isMore) {
        pageNum = 1;
    } else {
        pageNum += 1;
    }
    var param = {
        state: 2,
        pageNum: pageNum,
        pageSize: 10
    };
    const data = await sendRequest("v1/activity/zero/position/list", param, 0, 0, {
        "Content-Type": "application/json"
    });
    if (!data || data == null || !data.list || data.list == null || data.list.length == 0) {
        if (pageNum == 1) {
            moduleData.refreshStatus = "2";
            setListVisible(false);
            curList = [];
            moduleData.historyPositionList = [];
        } else {
            pageNum -= 1;
            moduleData.loadMoreStatus = "2";
        }
        return;
    }
    if (pageNum == 1) {
        moduleData.refreshStatus = 2;
    } else {
        moduleData.loadMoreStatus = 2;
    }
    setListVisible(true);
    try {
        const {total: total, list: list} = data;
        moduleData.total = total;
        handleHistoryPositionData(list);
    } catch (e) {
        console.log(`handle requestPositionList data error=${e}`);
    }
}

function setListVisible(visible) {
    if (true == visible) {
        moduleData.listViewVisibility = "visible";
        moduleData.emptyViewVisibility = "gone";
    } else {
        moduleData.listViewVisibility = "gone";
        moduleData.emptyViewVisibility = "visible";
    }
}

function handleHistoryPositionData(list) {
    for (let i = 0; i < list.length; ++i) {
        let v = list[i];
        var strArray = v.symbol.split("-");
        let baseCcy = strArray[0].toUpperCase();
        let quoteCcy = strArray[1].toUpperCase();
        if (3 == v.positionStatus) {
            v.type = "2";
            v.title = $i18n.n_zero_swap_position_reclaimed;
            v.closeTimeName = $i18n.n_zero_swap_position_recovery_time;
        } else if (4 == v.positionStatus) {
            v.type = "2";
            v.title = $i18n.n_zero_swap_position_liquidation;
            v.closeTimeName = $i18n.n_zero_swap_position_recovery_time;
        } else {
            v.type = "1";
            v.title = $i18n.n_zero_swap_position_closed;
            v.pnlName = $i18n.n_contract_profit + "(" + quoteCcy + ")";
            v.pnl = formatNumberSign(v.positionProfit);
            v.pnlColor = trendColorScheme(v.positionProfit);
            v.pnlRatioName = $i18n.n_contract_yield;
            v.pnlRatio = formatNumberSign(v.profitRate) + "%";
            v.pnlRatioColor = trendColorScheme(v.profitRate);
            v.closeAvgPxName = $i18n.n_contract_share_history_position_close_price + `(${quoteCcy})`;
            v.closeAvgPx = v.parityPrice;
            v.closeTimeName = $i18n.n_copy_trading_close_time;
        }
        v.icon = getPNGIconURLByCurrency(baseCcy);
        v.symbol = $i18n.$intercept.n_contract_swap_trade_name(`${baseCcy}${quoteCcy}`);
        if (v.direction == 1) {
            v.posSide = $i18n.n_asset_future_buy;
            v.posSideColor = getUpDownColor();
            v.posSidebackColor = getHandicapColor();
        } else {
            v.posSide = $i18n.n_asset_future_sell;
            v.posSideColor = getUpDownColor(false);
            v.posSidebackColor = getHandicapColor(false);
        }
        v.marginMode = $i18n.n_contract_trade_margin;
        v.lever = `${v.leverageRatio}X`;
        v.szName = $i18n.$intercept.n_contarct_position_volume_label(baseCcy);
        v.sz = v.positionAmount;
        v.openAvgPxName = $i18n.$intercept.n_linear_swap_open_price(quoteCcy);
        v.openAvgPx = v.openPrice;
        v.openTimeName = $i18n.n_copy_trading_open_time;
        v.openTime = new Date(v.createdAt).Format("yyyy-MM-dd hh:mm:ss");
        v.closeTime = new Date(v.parityTime).Format("yyyy-MM-dd hh:mm:ss");
        if (pageNum > 1) {
            curList.push(v);
        }
    }
    if (pageNum == 1) {
        curList = list;
    }
    moduleData.historyPositionList = curList;
}

function isNumeric(str) {
    if (typeof str !== "string") return false;
    return !isNaN(str) && !isNaN(parseFloat(str));
}

function formatNumberSign(numberStr) {
    if (isNumeric(numberStr)) {
        const num = parseFloat(numberStr);
        if (num > 0) {
            return `+${num}`;
        } else if (num < 0) {
            return `${num}`;
        } else {
            return `0`;
        }
    } else {
        return "--";
    }
}

function trendColorScheme(numberStr) {
    let colorType = commonData.priceColorType;
    const defaultColor = "@color/kColorPriceGreen";
    if (numberStr == null || numberStr === "") {
        return defaultColor;
    }
    const num = parseFloat(numberStr);
    if (isNaN(num)) {
        return defaultColor;
    }
    if (colorType === 0) {
        return num >= 0 ? "@color/kColorPriceRed" : "@color/kColorPriceGreen";
    } else {
        return num >= 0 ? "@color/kColorPriceGreen" : "@color/kColorPriceRed";
    }
}

moduleEvent.onAppear = onAppear;

moduleEvent.onRefresh = onRefresh;

moduleEvent.onLoadMore = onLoadMore;

function sendCommonConfig(param) {
    sendCommonConfig$1(param);
}

async function moduleAppear() {
    console.log("main-moduleAppear");
    appear();
    subPriceWebSocket("linearSwapWs");
}

function moduleWillDisappear() {
    console.log("main-moduleWillDisappear");
}

async function moduleDisappear() {
    console.log("main-moduleDisappear");
    unsubPriceWebSocket("linearSwapWs");
    disappear$1();
    disappear();
}

async function sendSocketData(data) {
    if (data.type == "linearSwapWs") {
        commonData.linearSwapWsData = JSON.parse(data.data);
        refreshProfit();
    }
}

async function requestPositionList() {
    requestPositionList$2();
}

$event.sendCommonConfig = sendCommonConfig;

$event.sendSocketData = sendSocketData;

$event.moduleAppear = moduleAppear;

$event.moduleDisappear = moduleDisappear;

$event.moduleWillDisappear = moduleWillDisappear;

$event.requestPositionList = requestPositionList;
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWFpbi5qcyIsInNvdXJjZXMiOlsiLi4vLi4vcmVwb3NpdG9yeS9ub2RlX21vZHVsZXMvYmlnLmpzL2JpZy5tanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9udW1iZXIuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9jb21tb24uanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9jb21tb25Qb3AuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9wb3NpdGlvbi5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL2hlYWRlclByb2ZpdC5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL2NhbGN1bGF0b3IuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9vcGVuUG9zaXRpb24uanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9oaXN0b3J5UG9zaXRpb24uanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9tYWluLmpzIl0sInNvdXJjZXNDb250ZW50IjpbIi8qXHJcbiAqICBiaWcuanMgdjUuMi4yXHJcbiAqICBBIHNtYWxsLCBmYXN0LCBlYXN5LXRvLXVzZSBsaWJyYXJ5IGZvciBhcmJpdHJhcnktcHJlY2lzaW9uIGRlY2ltYWwgYXJpdGhtZXRpYy5cclxuICogIENvcHlyaWdodCAoYykgMjAxOCBNaWNoYWVsIE1jbGF1Z2hsaW4gPE04Y2g4OGxAZ21haWwuY29tPlxyXG4gKiAgaHR0cHM6Ly9naXRodWIuY29tL01pa2VNY2wvYmlnLmpzL0xJQ0VOQ0VcclxuICovXHJcblxyXG5cclxuLyoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqIEVESVRBQkxFIERFRkFVTFRTICoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqL1xyXG5cclxuXHJcbiAgLy8gVGhlIGRlZmF1bHQgdmFsdWVzIGJlbG93IG11c3QgYmUgaW50ZWdlcnMgd2l0aGluIHRoZSBzdGF0ZWQgcmFuZ2VzLlxyXG5cclxuICAvKlxyXG4gICAqIFRoZSBtYXhpbXVtIG51bWJlciBvZiBkZWNpbWFsIHBsYWNlcyAoRFApIG9mIHRoZSByZXN1bHRzIG9mIG9wZXJhdGlvbnMgaW52b2x2aW5nIGRpdmlzaW9uOlxyXG4gICAqIGRpdiBhbmQgc3FydCwgYW5kIHBvdyB3aXRoIG5lZ2F0aXZlIGV4cG9uZW50cy5cclxuICAgKi9cclxudmFyIERQID0gMjAsICAgICAgICAgIC8vIDAgdG8gTUFYX0RQXHJcblxyXG4gIC8qXHJcbiAgICogVGhlIHJvdW5kaW5nIG1vZGUgKFJNKSB1c2VkIHdoZW4gcm91bmRpbmcgdG8gdGhlIGFib3ZlIGRlY2ltYWwgcGxhY2VzLlxyXG4gICAqXHJcbiAgICogIDAgIFRvd2FyZHMgemVybyAoaS5lLiB0cnVuY2F0ZSwgbm8gcm91bmRpbmcpLiAgICAgICAoUk9VTkRfRE9XTilcclxuICAgKiAgMSAgVG8gbmVhcmVzdCBuZWlnaGJvdXIuIElmIGVxdWlkaXN0YW50LCByb3VuZCB1cC4gIChST1VORF9IQUxGX1VQKVxyXG4gICAqICAyICBUbyBuZWFyZXN0IG5laWdoYm91ci4gSWYgZXF1aWRpc3RhbnQsIHRvIGV2ZW4uICAgKFJPVU5EX0hBTEZfRVZFTilcclxuICAgKiAgMyAgQXdheSBmcm9tIHplcm8uICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIChST1VORF9VUClcclxuICAgKi9cclxuICBSTSA9IDEsICAgICAgICAgICAgIC8vIDAsIDEsIDIgb3IgM1xyXG5cclxuICAvLyBUaGUgbWF4aW11bSB2YWx1ZSBvZiBEUCBhbmQgQmlnLkRQLlxyXG4gIE1BWF9EUCA9IDFFNiwgICAgICAgLy8gMCB0byAxMDAwMDAwXHJcblxyXG4gIC8vIFRoZSBtYXhpbXVtIG1hZ25pdHVkZSBvZiB0aGUgZXhwb25lbnQgYXJndW1lbnQgdG8gdGhlIHBvdyBtZXRob2QuXHJcbiAgTUFYX1BPV0VSID0gMUU2LCAgICAvLyAxIHRvIDEwMDAwMDBcclxuXHJcbiAgLypcclxuICAgKiBUaGUgbmVnYXRpdmUgZXhwb25lbnQgKE5FKSBhdCBhbmQgYmVuZWF0aCB3aGljaCB0b1N0cmluZyByZXR1cm5zIGV4cG9uZW50aWFsIG5vdGF0aW9uLlxyXG4gICAqIChKYXZhU2NyaXB0IG51bWJlcnM6IC03KVxyXG4gICAqIC0xMDAwMDAwIGlzIHRoZSBtaW5pbXVtIHJlY29tbWVuZGVkIGV4cG9uZW50IHZhbHVlIG9mIGEgQmlnLlxyXG4gICAqL1xyXG4gIE5FID0gLTcsICAgICAgICAgICAgLy8gMCB0byAtMTAwMDAwMFxyXG5cclxuICAvKlxyXG4gICAqIFRoZSBwb3NpdGl2ZSBleHBvbmVudCAoUEUpIGF0IGFuZCBhYm92ZSB3aGljaCB0b1N0cmluZyByZXR1cm5zIGV4cG9uZW50aWFsIG5vdGF0aW9uLlxyXG4gICAqIChKYXZhU2NyaXB0IG51bWJlcnM6IDIxKVxyXG4gICAqIDEwMDAwMDAgaXMgdGhlIG1heGltdW0gcmVjb21tZW5kZWQgZXhwb25lbnQgdmFsdWUgb2YgYSBCaWcuXHJcbiAgICogKFRoaXMgbGltaXQgaXMgbm90IGVuZm9yY2VkIG9yIGNoZWNrZWQuKVxyXG4gICAqL1xyXG4gIFBFID0gMjEsICAgICAgICAgICAgLy8gMCB0byAxMDAwMDAwXHJcblxyXG5cclxuLyoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqL1xyXG5cclxuXHJcbiAgLy8gRXJyb3IgbWVzc2FnZXMuXHJcbiAgTkFNRSA9ICdbYmlnLmpzXSAnLFxyXG4gIElOVkFMSUQgPSBOQU1FICsgJ0ludmFsaWQgJyxcclxuICBJTlZBTElEX0RQID0gSU5WQUxJRCArICdkZWNpbWFsIHBsYWNlcycsXHJcbiAgSU5WQUxJRF9STSA9IElOVkFMSUQgKyAncm91bmRpbmcgbW9kZScsXHJcbiAgRElWX0JZX1pFUk8gPSBOQU1FICsgJ0RpdmlzaW9uIGJ5IHplcm8nLFxyXG5cclxuICAvLyBUaGUgc2hhcmVkIHByb3RvdHlwZSBvYmplY3QuXHJcbiAgUCA9IHt9LFxyXG4gIFVOREVGSU5FRCA9IHZvaWQgMCxcclxuICBOVU1FUklDID0gL14tPyhcXGQrKFxcLlxcZCopP3xcXC5cXGQrKShlWystXT9cXGQrKT8kL2k7XHJcblxyXG5cclxuLypcclxuICogQ3JlYXRlIGFuZCByZXR1cm4gYSBCaWcgY29uc3RydWN0b3IuXHJcbiAqXHJcbiAqL1xyXG5mdW5jdGlvbiBfQmlnXygpIHtcclxuXHJcbiAgLypcclxuICAgKiBUaGUgQmlnIGNvbnN0cnVjdG9yIGFuZCBleHBvcnRlZCBmdW5jdGlvbi5cclxuICAgKiBDcmVhdGUgYW5kIHJldHVybiBhIG5ldyBpbnN0YW5jZSBvZiBhIEJpZyBudW1iZXIgb2JqZWN0LlxyXG4gICAqXHJcbiAgICogbiB7bnVtYmVyfHN0cmluZ3xCaWd9IEEgbnVtZXJpYyB2YWx1ZS5cclxuICAgKi9cclxuICBmdW5jdGlvbiBCaWcobikge1xyXG4gICAgdmFyIHggPSB0aGlzO1xyXG5cclxuICAgIC8vIEVuYWJsZSBjb25zdHJ1Y3RvciB1c2FnZSB3aXRob3V0IG5ldy5cclxuICAgIGlmICghKHggaW5zdGFuY2VvZiBCaWcpKSByZXR1cm4gbiA9PT0gVU5ERUZJTkVEID8gX0JpZ18oKSA6IG5ldyBCaWcobik7XHJcblxyXG4gICAgLy8gRHVwbGljYXRlLlxyXG4gICAgaWYgKG4gaW5zdGFuY2VvZiBCaWcpIHtcclxuICAgICAgeC5zID0gbi5zO1xyXG4gICAgICB4LmUgPSBuLmU7XHJcbiAgICAgIHguYyA9IG4uYy5zbGljZSgpO1xyXG4gICAgfSBlbHNlIHtcclxuICAgICAgcGFyc2UoeCwgbik7XHJcbiAgICB9XHJcblxyXG4gICAgLypcclxuICAgICAqIFJldGFpbiBhIHJlZmVyZW5jZSB0byB0aGlzIEJpZyBjb25zdHJ1Y3RvciwgYW5kIHNoYWRvdyBCaWcucHJvdG90eXBlLmNvbnN0cnVjdG9yIHdoaWNoXHJcbiAgICAgKiBwb2ludHMgdG8gT2JqZWN0LlxyXG4gICAgICovXHJcbiAgICB4LmNvbnN0cnVjdG9yID0gQmlnO1xyXG4gIH1cclxuXHJcbiAgQmlnLnByb3RvdHlwZSA9IFA7XHJcbiAgQmlnLkRQID0gRFA7XHJcbiAgQmlnLlJNID0gUk07XHJcbiAgQmlnLk5FID0gTkU7XHJcbiAgQmlnLlBFID0gUEU7XHJcbiAgQmlnLnZlcnNpb24gPSAnNS4yLjInO1xyXG5cclxuICByZXR1cm4gQmlnO1xyXG59XHJcblxyXG5cclxuLypcclxuICogUGFyc2UgdGhlIG51bWJlciBvciBzdHJpbmcgdmFsdWUgcGFzc2VkIHRvIGEgQmlnIGNvbnN0cnVjdG9yLlxyXG4gKlxyXG4gKiB4IHtCaWd9IEEgQmlnIG51bWJlciBpbnN0YW5jZS5cclxuICogbiB7bnVtYmVyfHN0cmluZ30gQSBudW1lcmljIHZhbHVlLlxyXG4gKi9cclxuZnVuY3Rpb24gcGFyc2UoeCwgbikge1xyXG4gIHZhciBlLCBpLCBubDtcclxuXHJcbiAgLy8gTWludXMgemVybz9cclxuICBpZiAobiA9PT0gMCAmJiAxIC8gbiA8IDApIG4gPSAnLTAnO1xyXG4gIGVsc2UgaWYgKCFOVU1FUklDLnRlc3QobiArPSAnJykpIHRocm93IEVycm9yKElOVkFMSUQgKyAnbnVtYmVyJyk7XHJcblxyXG4gIC8vIERldGVybWluZSBzaWduLlxyXG4gIHgucyA9IG4uY2hhckF0KDApID09ICctJyA/IChuID0gbi5zbGljZSgxKSwgLTEpIDogMTtcclxuXHJcbiAgLy8gRGVjaW1hbCBwb2ludD9cclxuICBpZiAoKGUgPSBuLmluZGV4T2YoJy4nKSkgPiAtMSkgbiA9IG4ucmVwbGFjZSgnLicsICcnKTtcclxuXHJcbiAgLy8gRXhwb25lbnRpYWwgZm9ybT9cclxuICBpZiAoKGkgPSBuLnNlYXJjaCgvZS9pKSkgPiAwKSB7XHJcblxyXG4gICAgLy8gRGV0ZXJtaW5lIGV4cG9uZW50LlxyXG4gICAgaWYgKGUgPCAwKSBlID0gaTtcclxuICAgIGUgKz0gK24uc2xpY2UoaSArIDEpO1xyXG4gICAgbiA9IG4uc3Vic3RyaW5nKDAsIGkpO1xyXG4gIH0gZWxzZSBpZiAoZSA8IDApIHtcclxuXHJcbiAgICAvLyBJbnRlZ2VyLlxyXG4gICAgZSA9IG4ubGVuZ3RoO1xyXG4gIH1cclxuXHJcbiAgbmwgPSBuLmxlbmd0aDtcclxuXHJcbiAgLy8gRGV0ZXJtaW5lIGxlYWRpbmcgemVyb3MuXHJcbiAgZm9yIChpID0gMDsgaSA8IG5sICYmIG4uY2hhckF0KGkpID09ICcwJzspICsraTtcclxuXHJcbiAgaWYgKGkgPT0gbmwpIHtcclxuXHJcbiAgICAvLyBaZXJvLlxyXG4gICAgeC5jID0gW3guZSA9IDBdO1xyXG4gIH0gZWxzZSB7XHJcblxyXG4gICAgLy8gRGV0ZXJtaW5lIHRyYWlsaW5nIHplcm9zLlxyXG4gICAgZm9yICg7IG5sID4gMCAmJiBuLmNoYXJBdCgtLW5sKSA9PSAnMCc7KTtcclxuICAgIHguZSA9IGUgLSBpIC0gMTtcclxuICAgIHguYyA9IFtdO1xyXG5cclxuICAgIC8vIENvbnZlcnQgc3RyaW5nIHRvIGFycmF5IG9mIGRpZ2l0cyB3aXRob3V0IGxlYWRpbmcvdHJhaWxpbmcgemVyb3MuXHJcbiAgICBmb3IgKGUgPSAwOyBpIDw9IG5sOykgeC5jW2UrK10gPSArbi5jaGFyQXQoaSsrKTtcclxuICB9XHJcblxyXG4gIHJldHVybiB4O1xyXG59XHJcblxyXG5cclxuLypcclxuICogUm91bmQgQmlnIHggdG8gYSBtYXhpbXVtIG9mIGRwIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgcm0uXHJcbiAqIENhbGxlZCBieSBzdHJpbmdpZnksIFAuZGl2LCBQLnJvdW5kIGFuZCBQLnNxcnQuXHJcbiAqXHJcbiAqIHgge0JpZ30gVGhlIEJpZyB0byByb3VuZC5cclxuICogZHAge251bWJlcn0gSW50ZWdlciwgMCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKiBybSB7bnVtYmVyfSAwLCAxLCAyIG9yIDMgKERPV04sIEhBTEZfVVAsIEhBTEZfRVZFTiwgVVApXHJcbiAqIFttb3JlXSB7Ym9vbGVhbn0gV2hldGhlciB0aGUgcmVzdWx0IG9mIGRpdmlzaW9uIHdhcyB0cnVuY2F0ZWQuXHJcbiAqL1xyXG5mdW5jdGlvbiByb3VuZCh4LCBkcCwgcm0sIG1vcmUpIHtcclxuICB2YXIgeGMgPSB4LmMsXHJcbiAgICBpID0geC5lICsgZHAgKyAxO1xyXG5cclxuICBpZiAoaSA8IHhjLmxlbmd0aCkge1xyXG4gICAgaWYgKHJtID09PSAxKSB7XHJcblxyXG4gICAgICAvLyB4Y1tpXSBpcyB0aGUgZGlnaXQgYWZ0ZXIgdGhlIGRpZ2l0IHRoYXQgbWF5IGJlIHJvdW5kZWQgdXAuXHJcbiAgICAgIG1vcmUgPSB4Y1tpXSA+PSA1O1xyXG4gICAgfSBlbHNlIGlmIChybSA9PT0gMikge1xyXG4gICAgICBtb3JlID0geGNbaV0gPiA1IHx8IHhjW2ldID09IDUgJiZcclxuICAgICAgICAobW9yZSB8fCBpIDwgMCB8fCB4Y1tpICsgMV0gIT09IFVOREVGSU5FRCB8fCB4Y1tpIC0gMV0gJiAxKTtcclxuICAgIH0gZWxzZSBpZiAocm0gPT09IDMpIHtcclxuICAgICAgbW9yZSA9IG1vcmUgfHwgISF4Y1swXTtcclxuICAgIH0gZWxzZSB7XHJcbiAgICAgIG1vcmUgPSBmYWxzZTtcclxuICAgICAgaWYgKHJtICE9PSAwKSB0aHJvdyBFcnJvcihJTlZBTElEX1JNKTtcclxuICAgIH1cclxuXHJcbiAgICBpZiAoaSA8IDEpIHtcclxuICAgICAgeGMubGVuZ3RoID0gMTtcclxuXHJcbiAgICAgIGlmIChtb3JlKSB7XHJcblxyXG4gICAgICAgIC8vIDEsIDAuMSwgMC4wMSwgMC4wMDEsIDAuMDAwMSBldGMuXHJcbiAgICAgICAgeC5lID0gLWRwO1xyXG4gICAgICAgIHhjWzBdID0gMTtcclxuICAgICAgfSBlbHNlIHtcclxuXHJcbiAgICAgICAgLy8gWmVyby5cclxuICAgICAgICB4Y1swXSA9IHguZSA9IDA7XHJcbiAgICAgIH1cclxuICAgIH0gZWxzZSB7XHJcblxyXG4gICAgICAvLyBSZW1vdmUgYW55IGRpZ2l0cyBhZnRlciB0aGUgcmVxdWlyZWQgZGVjaW1hbCBwbGFjZXMuXHJcbiAgICAgIHhjLmxlbmd0aCA9IGktLTtcclxuXHJcbiAgICAgIC8vIFJvdW5kIHVwP1xyXG4gICAgICBpZiAobW9yZSkge1xyXG5cclxuICAgICAgICAvLyBSb3VuZGluZyB1cCBtYXkgbWVhbiB0aGUgcHJldmlvdXMgZGlnaXQgaGFzIHRvIGJlIHJvdW5kZWQgdXAuXHJcbiAgICAgICAgZm9yICg7ICsreGNbaV0gPiA5Oykge1xyXG4gICAgICAgICAgeGNbaV0gPSAwO1xyXG4gICAgICAgICAgaWYgKCFpLS0pIHtcclxuICAgICAgICAgICAgKyt4LmU7XHJcbiAgICAgICAgICAgIHhjLnVuc2hpZnQoMSk7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgfVxyXG4gICAgICB9XHJcblxyXG4gICAgICAvLyBSZW1vdmUgdHJhaWxpbmcgemVyb3MuXHJcbiAgICAgIGZvciAoaSA9IHhjLmxlbmd0aDsgIXhjWy0taV07KSB4Yy5wb3AoKTtcclxuICAgIH1cclxuICB9IGVsc2UgaWYgKHJtIDwgMCB8fCBybSA+IDMgfHwgcm0gIT09IH5+cm0pIHtcclxuICAgIHRocm93IEVycm9yKElOVkFMSURfUk0pO1xyXG4gIH1cclxuXHJcbiAgcmV0dXJuIHg7XHJcbn1cclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBzdHJpbmcgcmVwcmVzZW50aW5nIHRoZSB2YWx1ZSBvZiBCaWcgeCBpbiBub3JtYWwgb3IgZXhwb25lbnRpYWwgbm90YXRpb24uXHJcbiAqIEhhbmRsZXMgUC50b0V4cG9uZW50aWFsLCBQLnRvRml4ZWQsIFAudG9KU09OLCBQLnRvUHJlY2lzaW9uLCBQLnRvU3RyaW5nIGFuZCBQLnZhbHVlT2YuXHJcbiAqXHJcbiAqIHgge0JpZ31cclxuICogaWQ/IHtudW1iZXJ9IENhbGxlciBpZC5cclxuICogICAgICAgICAxIHRvRXhwb25lbnRpYWxcclxuICogICAgICAgICAyIHRvRml4ZWRcclxuICogICAgICAgICAzIHRvUHJlY2lzaW9uXHJcbiAqICAgICAgICAgNCB2YWx1ZU9mXHJcbiAqIG4/IHtudW1iZXJ8dW5kZWZpbmVkfSBDYWxsZXIncyBhcmd1bWVudC5cclxuICogaz8ge251bWJlcnx1bmRlZmluZWR9XHJcbiAqL1xyXG5mdW5jdGlvbiBzdHJpbmdpZnkoeCwgaWQsIG4sIGspIHtcclxuICB2YXIgZSwgcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICB6ID0gIXguY1swXTtcclxuXHJcbiAgaWYgKG4gIT09IFVOREVGSU5FRCkge1xyXG4gICAgaWYgKG4gIT09IH5+biB8fCBuIDwgKGlkID09IDMpIHx8IG4gPiBNQVhfRFApIHtcclxuICAgICAgdGhyb3cgRXJyb3IoaWQgPT0gMyA/IElOVkFMSUQgKyAncHJlY2lzaW9uJyA6IElOVkFMSURfRFApO1xyXG4gICAgfVxyXG5cclxuICAgIHggPSBuZXcgQmlnKHgpO1xyXG5cclxuICAgIC8vIFRoZSBpbmRleCBvZiB0aGUgZGlnaXQgdGhhdCBtYXkgYmUgcm91bmRlZCB1cC5cclxuICAgIG4gPSBrIC0geC5lO1xyXG5cclxuICAgIC8vIFJvdW5kP1xyXG4gICAgaWYgKHguYy5sZW5ndGggPiArK2spIHJvdW5kKHgsIG4sIEJpZy5STSk7XHJcblxyXG4gICAgLy8gdG9GaXhlZDogcmVjYWxjdWxhdGUgayBhcyB4LmUgbWF5IGhhdmUgY2hhbmdlZCBpZiB2YWx1ZSByb3VuZGVkIHVwLlxyXG4gICAgaWYgKGlkID09IDIpIGsgPSB4LmUgKyBuICsgMTtcclxuXHJcbiAgICAvLyBBcHBlbmQgemVyb3M/XHJcbiAgICBmb3IgKDsgeC5jLmxlbmd0aCA8IGs7KSB4LmMucHVzaCgwKTtcclxuICB9XHJcblxyXG4gIGUgPSB4LmU7XHJcbiAgcyA9IHguYy5qb2luKCcnKTtcclxuICBuID0gcy5sZW5ndGg7XHJcblxyXG4gIC8vIEV4cG9uZW50aWFsIG5vdGF0aW9uP1xyXG4gIGlmIChpZCAhPSAyICYmIChpZCA9PSAxIHx8IGlkID09IDMgJiYgayA8PSBlIHx8IGUgPD0gQmlnLk5FIHx8IGUgPj0gQmlnLlBFKSkge1xyXG4gICAgcyA9IHMuY2hhckF0KDApICsgKG4gPiAxID8gJy4nICsgcy5zbGljZSgxKSA6ICcnKSArIChlIDwgMCA/ICdlJyA6ICdlKycpICsgZTtcclxuXHJcbiAgLy8gTm9ybWFsIG5vdGF0aW9uLlxyXG4gIH0gZWxzZSBpZiAoZSA8IDApIHtcclxuICAgIGZvciAoOyArK2U7KSBzID0gJzAnICsgcztcclxuICAgIHMgPSAnMC4nICsgcztcclxuICB9IGVsc2UgaWYgKGUgPiAwKSB7XHJcbiAgICBpZiAoKytlID4gbikgZm9yIChlIC09IG47IGUtLTspIHMgKz0gJzAnO1xyXG4gICAgZWxzZSBpZiAoZSA8IG4pIHMgPSBzLnNsaWNlKDAsIGUpICsgJy4nICsgcy5zbGljZShlKTtcclxuICB9IGVsc2UgaWYgKG4gPiAxKSB7XHJcbiAgICBzID0gcy5jaGFyQXQoMCkgKyAnLicgKyBzLnNsaWNlKDEpO1xyXG4gIH1cclxuXHJcbiAgcmV0dXJuIHgucyA8IDAgJiYgKCF6IHx8IGlkID09IDQpID8gJy0nICsgcyA6IHM7XHJcbn1cclxuXHJcblxyXG4vLyBQcm90b3R5cGUvaW5zdGFuY2UgbWV0aG9kc1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIGFic29sdXRlIHZhbHVlIG9mIHRoaXMgQmlnLlxyXG4gKi9cclxuUC5hYnMgPSBmdW5jdGlvbiAoKSB7XHJcbiAgdmFyIHggPSBuZXcgdGhpcy5jb25zdHJ1Y3Rvcih0aGlzKTtcclxuICB4LnMgPSAxO1xyXG4gIHJldHVybiB4O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiAxIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBncmVhdGVyIHRoYW4gdGhlIHZhbHVlIG9mIEJpZyB5LFxyXG4gKiAgICAgICAtMSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgbGVzcyB0aGFuIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3JcclxuICogICAgICAgIDAgaWYgdGhleSBoYXZlIHRoZSBzYW1lIHZhbHVlLlxyXG4qL1xyXG5QLmNtcCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIGlzbmVnLFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICB4YyA9IHguYyxcclxuICAgIHljID0gKHkgPSBuZXcgeC5jb25zdHJ1Y3Rvcih5KSkuYyxcclxuICAgIGkgPSB4LnMsXHJcbiAgICBqID0geS5zLFxyXG4gICAgayA9IHguZSxcclxuICAgIGwgPSB5LmU7XHJcblxyXG4gIC8vIEVpdGhlciB6ZXJvP1xyXG4gIGlmICgheGNbMF0gfHwgIXljWzBdKSByZXR1cm4gIXhjWzBdID8gIXljWzBdID8gMCA6IC1qIDogaTtcclxuXHJcbiAgLy8gU2lnbnMgZGlmZmVyP1xyXG4gIGlmIChpICE9IGopIHJldHVybiBpO1xyXG5cclxuICBpc25lZyA9IGkgPCAwO1xyXG5cclxuICAvLyBDb21wYXJlIGV4cG9uZW50cy5cclxuICBpZiAoayAhPSBsKSByZXR1cm4gayA+IGwgXiBpc25lZyA/IDEgOiAtMTtcclxuXHJcbiAgaiA9IChrID0geGMubGVuZ3RoKSA8IChsID0geWMubGVuZ3RoKSA/IGsgOiBsO1xyXG5cclxuICAvLyBDb21wYXJlIGRpZ2l0IGJ5IGRpZ2l0LlxyXG4gIGZvciAoaSA9IC0xOyArK2kgPCBqOykge1xyXG4gICAgaWYgKHhjW2ldICE9IHljW2ldKSByZXR1cm4geGNbaV0gPiB5Y1tpXSBeIGlzbmVnID8gMSA6IC0xO1xyXG4gIH1cclxuXHJcbiAgLy8gQ29tcGFyZSBsZW5ndGhzLlxyXG4gIHJldHVybiBrID09IGwgPyAwIDogayA+IGwgXiBpc25lZyA/IDEgOiAtMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBkaXZpZGVkIGJ5IHRoZSB2YWx1ZSBvZiBCaWcgeSwgcm91bmRlZCxcclxuICogaWYgbmVjZXNzYXJ5LCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgQmlnLlJNLlxyXG4gKi9cclxuUC5kaXYgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5jLCAgICAgICAgICAgICAgICAgIC8vIGRpdmlkZW5kXHJcbiAgICBiID0gKHkgPSBuZXcgQmlnKHkpKS5jLCAgIC8vIGRpdmlzb3JcclxuICAgIGsgPSB4LnMgPT0geS5zID8gMSA6IC0xLFxyXG4gICAgZHAgPSBCaWcuRFA7XHJcblxyXG4gIGlmIChkcCAhPT0gfn5kcCB8fCBkcCA8IDAgfHwgZHAgPiBNQVhfRFApIHRocm93IEVycm9yKElOVkFMSURfRFApO1xyXG5cclxuICAvLyBEaXZpc29yIGlzIHplcm8/XHJcbiAgaWYgKCFiWzBdKSB0aHJvdyBFcnJvcihESVZfQllfWkVSTyk7XHJcblxyXG4gIC8vIERpdmlkZW5kIGlzIDA/IFJldHVybiArLTAuXHJcbiAgaWYgKCFhWzBdKSByZXR1cm4gbmV3IEJpZyhrICogMCk7XHJcblxyXG4gIHZhciBibCwgYnQsIG4sIGNtcCwgcmksXHJcbiAgICBieiA9IGIuc2xpY2UoKSxcclxuICAgIGFpID0gYmwgPSBiLmxlbmd0aCxcclxuICAgIGFsID0gYS5sZW5ndGgsXHJcbiAgICByID0gYS5zbGljZSgwLCBibCksICAgLy8gcmVtYWluZGVyXHJcbiAgICBybCA9IHIubGVuZ3RoLFxyXG4gICAgcSA9IHksICAgICAgICAgICAgICAgIC8vIHF1b3RpZW50XHJcbiAgICBxYyA9IHEuYyA9IFtdLFxyXG4gICAgcWkgPSAwLFxyXG4gICAgZCA9IGRwICsgKHEuZSA9IHguZSAtIHkuZSkgKyAxOyAgICAvLyBudW1iZXIgb2YgZGlnaXRzIG9mIHRoZSByZXN1bHRcclxuXHJcbiAgcS5zID0gaztcclxuICBrID0gZCA8IDAgPyAwIDogZDtcclxuXHJcbiAgLy8gQ3JlYXRlIHZlcnNpb24gb2YgZGl2aXNvciB3aXRoIGxlYWRpbmcgemVyby5cclxuICBiei51bnNoaWZ0KDApO1xyXG5cclxuICAvLyBBZGQgemVyb3MgdG8gbWFrZSByZW1haW5kZXIgYXMgbG9uZyBhcyBkaXZpc29yLlxyXG4gIGZvciAoOyBybCsrIDwgYmw7KSByLnB1c2goMCk7XHJcblxyXG4gIGRvIHtcclxuXHJcbiAgICAvLyBuIGlzIGhvdyBtYW55IHRpbWVzIHRoZSBkaXZpc29yIGdvZXMgaW50byBjdXJyZW50IHJlbWFpbmRlci5cclxuICAgIGZvciAobiA9IDA7IG4gPCAxMDsgbisrKSB7XHJcblxyXG4gICAgICAvLyBDb21wYXJlIGRpdmlzb3IgYW5kIHJlbWFpbmRlci5cclxuICAgICAgaWYgKGJsICE9IChybCA9IHIubGVuZ3RoKSkge1xyXG4gICAgICAgIGNtcCA9IGJsID4gcmwgPyAxIDogLTE7XHJcbiAgICAgIH0gZWxzZSB7XHJcbiAgICAgICAgZm9yIChyaSA9IC0xLCBjbXAgPSAwOyArK3JpIDwgYmw7KSB7XHJcbiAgICAgICAgICBpZiAoYltyaV0gIT0gcltyaV0pIHtcclxuICAgICAgICAgICAgY21wID0gYltyaV0gPiByW3JpXSA/IDEgOiAtMTtcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgfVxyXG4gICAgICB9XHJcblxyXG4gICAgICAvLyBJZiBkaXZpc29yIDwgcmVtYWluZGVyLCBzdWJ0cmFjdCBkaXZpc29yIGZyb20gcmVtYWluZGVyLlxyXG4gICAgICBpZiAoY21wIDwgMCkge1xyXG5cclxuICAgICAgICAvLyBSZW1haW5kZXIgY2FuJ3QgYmUgbW9yZSB0aGFuIDEgZGlnaXQgbG9uZ2VyIHRoYW4gZGl2aXNvci5cclxuICAgICAgICAvLyBFcXVhbGlzZSBsZW5ndGhzIHVzaW5nIGRpdmlzb3Igd2l0aCBleHRyYSBsZWFkaW5nIHplcm8/XHJcbiAgICAgICAgZm9yIChidCA9IHJsID09IGJsID8gYiA6IGJ6OyBybDspIHtcclxuICAgICAgICAgIGlmIChyWy0tcmxdIDwgYnRbcmxdKSB7XHJcbiAgICAgICAgICAgIHJpID0gcmw7XHJcbiAgICAgICAgICAgIGZvciAoOyByaSAmJiAhclstLXJpXTspIHJbcmldID0gOTtcclxuICAgICAgICAgICAgLS1yW3JpXTtcclxuICAgICAgICAgICAgcltybF0gKz0gMTA7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgICByW3JsXSAtPSBidFtybF07XHJcbiAgICAgICAgfVxyXG5cclxuICAgICAgICBmb3IgKDsgIXJbMF07KSByLnNoaWZ0KCk7XHJcbiAgICAgIH0gZWxzZSB7XHJcbiAgICAgICAgYnJlYWs7XHJcbiAgICAgIH1cclxuICAgIH1cclxuXHJcbiAgICAvLyBBZGQgdGhlIGRpZ2l0IG4gdG8gdGhlIHJlc3VsdCBhcnJheS5cclxuICAgIHFjW3FpKytdID0gY21wID8gbiA6ICsrbjtcclxuXHJcbiAgICAvLyBVcGRhdGUgdGhlIHJlbWFpbmRlci5cclxuICAgIGlmIChyWzBdICYmIGNtcCkgcltybF0gPSBhW2FpXSB8fCAwO1xyXG4gICAgZWxzZSByID0gW2FbYWldXTtcclxuXHJcbiAgfSB3aGlsZSAoKGFpKysgPCBhbCB8fCByWzBdICE9PSBVTkRFRklORUQpICYmIGstLSk7XHJcblxyXG4gIC8vIExlYWRpbmcgemVybz8gRG8gbm90IHJlbW92ZSBpZiByZXN1bHQgaXMgc2ltcGx5IHplcm8gKHFpID09IDEpLlxyXG4gIGlmICghcWNbMF0gJiYgcWkgIT0gMSkge1xyXG5cclxuICAgIC8vIFRoZXJlIGNhbid0IGJlIG1vcmUgdGhhbiBvbmUgemVyby5cclxuICAgIHFjLnNoaWZ0KCk7XHJcbiAgICBxLmUtLTtcclxuICB9XHJcblxyXG4gIC8vIFJvdW5kP1xyXG4gIGlmIChxaSA+IGQpIHJvdW5kKHEsIGRwLCBCaWcuUk0sIHJbMF0gIT09IFVOREVGSU5FRCk7XHJcblxyXG4gIHJldHVybiBxO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiB0cnVlIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBlcXVhbCB0byB0aGUgdmFsdWUgb2YgQmlnIHksIG90aGVyd2lzZSByZXR1cm4gZmFsc2UuXHJcbiAqL1xyXG5QLmVxID0gZnVuY3Rpb24gKHkpIHtcclxuICByZXR1cm4gIXRoaXMuY21wKHkpO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiB0cnVlIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBncmVhdGVyIHRoYW4gdGhlIHZhbHVlIG9mIEJpZyB5LCBvdGhlcndpc2UgcmV0dXJuXHJcbiAqIGZhbHNlLlxyXG4gKi9cclxuUC5ndCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgcmV0dXJuIHRoaXMuY21wKHkpID4gMDtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gdHJ1ZSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgZ3JlYXRlciB0aGFuIG9yIGVxdWFsIHRvIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3RoZXJ3aXNlXHJcbiAqIHJldHVybiBmYWxzZS5cclxuICovXHJcblAuZ3RlID0gZnVuY3Rpb24gKHkpIHtcclxuICByZXR1cm4gdGhpcy5jbXAoeSkgPiAtMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gdHJ1ZSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgbGVzcyB0aGFuIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3RoZXJ3aXNlIHJldHVybiBmYWxzZS5cclxuICovXHJcblAubHQgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHJldHVybiB0aGlzLmNtcCh5KSA8IDA7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIHRydWUgaWYgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGlzIGxlc3MgdGhhbiBvciBlcXVhbCB0byB0aGUgdmFsdWUgb2YgQmlnIHksIG90aGVyd2lzZVxyXG4gKiByZXR1cm4gZmFsc2UuXHJcbiAqL1xyXG5QLmx0ZSA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgcmV0dXJuIHRoaXMuY21wKHkpIDwgMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBtaW51cyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLm1pbnVzID0gUC5zdWIgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciBpLCBqLCB0LCB4bHR5LFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgYSA9IHgucyxcclxuICAgIGIgPSAoeSA9IG5ldyBCaWcoeSkpLnM7XHJcblxyXG4gIC8vIFNpZ25zIGRpZmZlcj9cclxuICBpZiAoYSAhPSBiKSB7XHJcbiAgICB5LnMgPSAtYjtcclxuICAgIHJldHVybiB4LnBsdXMoeSk7XHJcbiAgfVxyXG5cclxuICB2YXIgeGMgPSB4LmMuc2xpY2UoKSxcclxuICAgIHhlID0geC5lLFxyXG4gICAgeWMgPSB5LmMsXHJcbiAgICB5ZSA9IHkuZTtcclxuXHJcbiAgLy8gRWl0aGVyIHplcm8/XHJcbiAgaWYgKCF4Y1swXSB8fCAheWNbMF0pIHtcclxuXHJcbiAgICAvLyB5IGlzIG5vbi16ZXJvPyB4IGlzIG5vbi16ZXJvPyBPciBib3RoIGFyZSB6ZXJvLlxyXG4gICAgcmV0dXJuIHljWzBdID8gKHkucyA9IC1iLCB5KSA6IG5ldyBCaWcoeGNbMF0gPyB4IDogMCk7XHJcbiAgfVxyXG5cclxuICAvLyBEZXRlcm1pbmUgd2hpY2ggaXMgdGhlIGJpZ2dlciBudW1iZXIuIFByZXBlbmQgemVyb3MgdG8gZXF1YWxpc2UgZXhwb25lbnRzLlxyXG4gIGlmIChhID0geGUgLSB5ZSkge1xyXG5cclxuICAgIGlmICh4bHR5ID0gYSA8IDApIHtcclxuICAgICAgYSA9IC1hO1xyXG4gICAgICB0ID0geGM7XHJcbiAgICB9IGVsc2Uge1xyXG4gICAgICB5ZSA9IHhlO1xyXG4gICAgICB0ID0geWM7XHJcbiAgICB9XHJcblxyXG4gICAgdC5yZXZlcnNlKCk7XHJcbiAgICBmb3IgKGIgPSBhOyBiLS07KSB0LnB1c2goMCk7XHJcbiAgICB0LnJldmVyc2UoKTtcclxuICB9IGVsc2Uge1xyXG5cclxuICAgIC8vIEV4cG9uZW50cyBlcXVhbC4gQ2hlY2sgZGlnaXQgYnkgZGlnaXQuXHJcbiAgICBqID0gKCh4bHR5ID0geGMubGVuZ3RoIDwgeWMubGVuZ3RoKSA/IHhjIDogeWMpLmxlbmd0aDtcclxuXHJcbiAgICBmb3IgKGEgPSBiID0gMDsgYiA8IGo7IGIrKykge1xyXG4gICAgICBpZiAoeGNbYl0gIT0geWNbYl0pIHtcclxuICAgICAgICB4bHR5ID0geGNbYl0gPCB5Y1tiXTtcclxuICAgICAgICBicmVhaztcclxuICAgICAgfVxyXG4gICAgfVxyXG4gIH1cclxuXHJcbiAgLy8geCA8IHk/IFBvaW50IHhjIHRvIHRoZSBhcnJheSBvZiB0aGUgYmlnZ2VyIG51bWJlci5cclxuICBpZiAoeGx0eSkge1xyXG4gICAgdCA9IHhjO1xyXG4gICAgeGMgPSB5YztcclxuICAgIHljID0gdDtcclxuICAgIHkucyA9IC15LnM7XHJcbiAgfVxyXG5cclxuICAvKlxyXG4gICAqIEFwcGVuZCB6ZXJvcyB0byB4YyBpZiBzaG9ydGVyLiBObyBuZWVkIHRvIGFkZCB6ZXJvcyB0byB5YyBpZiBzaG9ydGVyIGFzIHN1YnRyYWN0aW9uIG9ubHlcclxuICAgKiBuZWVkcyB0byBzdGFydCBhdCB5Yy5sZW5ndGguXHJcbiAgICovXHJcbiAgaWYgKChiID0gKGogPSB5Yy5sZW5ndGgpIC0gKGkgPSB4Yy5sZW5ndGgpKSA+IDApIGZvciAoOyBiLS07KSB4Y1tpKytdID0gMDtcclxuXHJcbiAgLy8gU3VidHJhY3QgeWMgZnJvbSB4Yy5cclxuICBmb3IgKGIgPSBpOyBqID4gYTspIHtcclxuICAgIGlmICh4Y1stLWpdIDwgeWNbal0pIHtcclxuICAgICAgZm9yIChpID0gajsgaSAmJiAheGNbLS1pXTspIHhjW2ldID0gOTtcclxuICAgICAgLS14Y1tpXTtcclxuICAgICAgeGNbal0gKz0gMTA7XHJcbiAgICB9XHJcblxyXG4gICAgeGNbal0gLT0geWNbal07XHJcbiAgfVxyXG5cclxuICAvLyBSZW1vdmUgdHJhaWxpbmcgemVyb3MuXHJcbiAgZm9yICg7IHhjWy0tYl0gPT09IDA7KSB4Yy5wb3AoKTtcclxuXHJcbiAgLy8gUmVtb3ZlIGxlYWRpbmcgemVyb3MgYW5kIGFkanVzdCBleHBvbmVudCBhY2NvcmRpbmdseS5cclxuICBmb3IgKDsgeGNbMF0gPT09IDA7KSB7XHJcbiAgICB4Yy5zaGlmdCgpO1xyXG4gICAgLS15ZTtcclxuICB9XHJcblxyXG4gIGlmICgheGNbMF0pIHtcclxuXHJcbiAgICAvLyBuIC0gbiA9ICswXHJcbiAgICB5LnMgPSAxO1xyXG5cclxuICAgIC8vIFJlc3VsdCBtdXN0IGJlIHplcm8uXHJcbiAgICB4YyA9IFt5ZSA9IDBdO1xyXG4gIH1cclxuXHJcbiAgeS5jID0geGM7XHJcbiAgeS5lID0geWU7XHJcblxyXG4gIHJldHVybiB5O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIG1vZHVsbyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLm1vZCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIHlndHgsXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5zLFxyXG4gICAgYiA9ICh5ID0gbmV3IEJpZyh5KSkucztcclxuXHJcbiAgaWYgKCF5LmNbMF0pIHRocm93IEVycm9yKERJVl9CWV9aRVJPKTtcclxuXHJcbiAgeC5zID0geS5zID0gMTtcclxuICB5Z3R4ID0geS5jbXAoeCkgPT0gMTtcclxuICB4LnMgPSBhO1xyXG4gIHkucyA9IGI7XHJcblxyXG4gIGlmICh5Z3R4KSByZXR1cm4gbmV3IEJpZyh4KTtcclxuXHJcbiAgYSA9IEJpZy5EUDtcclxuICBiID0gQmlnLlJNO1xyXG4gIEJpZy5EUCA9IEJpZy5STSA9IDA7XHJcbiAgeCA9IHguZGl2KHkpO1xyXG4gIEJpZy5EUCA9IGE7XHJcbiAgQmlnLlJNID0gYjtcclxuXHJcbiAgcmV0dXJuIHRoaXMubWludXMoeC50aW1lcyh5KSk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgbmV3IEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgcGx1cyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLnBsdXMgPSBQLmFkZCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIHQsXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5zLFxyXG4gICAgYiA9ICh5ID0gbmV3IEJpZyh5KSkucztcclxuXHJcbiAgLy8gU2lnbnMgZGlmZmVyP1xyXG4gIGlmIChhICE9IGIpIHtcclxuICAgIHkucyA9IC1iO1xyXG4gICAgcmV0dXJuIHgubWludXMoeSk7XHJcbiAgfVxyXG5cclxuICB2YXIgeGUgPSB4LmUsXHJcbiAgICB4YyA9IHguYyxcclxuICAgIHllID0geS5lLFxyXG4gICAgeWMgPSB5LmM7XHJcblxyXG4gIC8vIEVpdGhlciB6ZXJvPyB5IGlzIG5vbi16ZXJvPyB4IGlzIG5vbi16ZXJvPyBPciBib3RoIGFyZSB6ZXJvLlxyXG4gIGlmICgheGNbMF0gfHwgIXljWzBdKSByZXR1cm4geWNbMF0gPyB5IDogbmV3IEJpZyh4Y1swXSA/IHggOiBhICogMCk7XHJcblxyXG4gIHhjID0geGMuc2xpY2UoKTtcclxuXHJcbiAgLy8gUHJlcGVuZCB6ZXJvcyB0byBlcXVhbGlzZSBleHBvbmVudHMuXHJcbiAgLy8gTm90ZTogcmV2ZXJzZSBmYXN0ZXIgdGhhbiB1bnNoaWZ0cy5cclxuICBpZiAoYSA9IHhlIC0geWUpIHtcclxuICAgIGlmIChhID4gMCkge1xyXG4gICAgICB5ZSA9IHhlO1xyXG4gICAgICB0ID0geWM7XHJcbiAgICB9IGVsc2Uge1xyXG4gICAgICBhID0gLWE7XHJcbiAgICAgIHQgPSB4YztcclxuICAgIH1cclxuXHJcbiAgICB0LnJldmVyc2UoKTtcclxuICAgIGZvciAoOyBhLS07KSB0LnB1c2goMCk7XHJcbiAgICB0LnJldmVyc2UoKTtcclxuICB9XHJcblxyXG4gIC8vIFBvaW50IHhjIHRvIHRoZSBsb25nZXIgYXJyYXkuXHJcbiAgaWYgKHhjLmxlbmd0aCAtIHljLmxlbmd0aCA8IDApIHtcclxuICAgIHQgPSB5YztcclxuICAgIHljID0geGM7XHJcbiAgICB4YyA9IHQ7XHJcbiAgfVxyXG5cclxuICBhID0geWMubGVuZ3RoO1xyXG5cclxuICAvLyBPbmx5IHN0YXJ0IGFkZGluZyBhdCB5Yy5sZW5ndGggLSAxIGFzIHRoZSBmdXJ0aGVyIGRpZ2l0cyBvZiB4YyBjYW4gYmUgbGVmdCBhcyB0aGV5IGFyZS5cclxuICBmb3IgKGIgPSAwOyBhOyB4Y1thXSAlPSAxMCkgYiA9ICh4Y1stLWFdID0geGNbYV0gKyB5Y1thXSArIGIpIC8gMTAgfCAwO1xyXG5cclxuICAvLyBObyBuZWVkIHRvIGNoZWNrIGZvciB6ZXJvLCBhcyAreCArICt5ICE9IDAgJiYgLXggKyAteSAhPSAwXHJcblxyXG4gIGlmIChiKSB7XHJcbiAgICB4Yy51bnNoaWZ0KGIpO1xyXG4gICAgKyt5ZTtcclxuICB9XHJcblxyXG4gIC8vIFJlbW92ZSB0cmFpbGluZyB6ZXJvcy5cclxuICBmb3IgKGEgPSB4Yy5sZW5ndGg7IHhjWy0tYV0gPT09IDA7KSB4Yy5wb3AoKTtcclxuXHJcbiAgeS5jID0geGM7XHJcbiAgeS5lID0geWU7XHJcblxyXG4gIHJldHVybiB5O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgcmFpc2VkIHRvIHRoZSBwb3dlciBuLlxyXG4gKiBJZiBuIGlzIG5lZ2F0aXZlLCByb3VuZCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nXHJcbiAqIG1vZGUgQmlnLlJNLlxyXG4gKlxyXG4gKiBuIHtudW1iZXJ9IEludGVnZXIsIC1NQVhfUE9XRVIgdG8gTUFYX1BPV0VSIGluY2x1c2l2ZS5cclxuICovXHJcblAucG93ID0gZnVuY3Rpb24gKG4pIHtcclxuICB2YXIgeCA9IHRoaXMsXHJcbiAgICBvbmUgPSBuZXcgeC5jb25zdHJ1Y3RvcigxKSxcclxuICAgIHkgPSBvbmUsXHJcbiAgICBpc25lZyA9IG4gPCAwO1xyXG5cclxuICBpZiAobiAhPT0gfn5uIHx8IG4gPCAtTUFYX1BPV0VSIHx8IG4gPiBNQVhfUE9XRVIpIHRocm93IEVycm9yKElOVkFMSUQgKyAnZXhwb25lbnQnKTtcclxuICBpZiAoaXNuZWcpIG4gPSAtbjtcclxuXHJcbiAgZm9yICg7Oykge1xyXG4gICAgaWYgKG4gJiAxKSB5ID0geS50aW1lcyh4KTtcclxuICAgIG4gPj49IDE7XHJcbiAgICBpZiAoIW4pIGJyZWFrO1xyXG4gICAgeCA9IHgudGltZXMoeCk7XHJcbiAgfVxyXG5cclxuICByZXR1cm4gaXNuZWcgPyBvbmUuZGl2KHkpIDogeTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyByb3VuZGVkIHVzaW5nIHJvdW5kaW5nIG1vZGUgcm1cclxuICogdG8gYSBtYXhpbXVtIG9mIGRwIGRlY2ltYWwgcGxhY2VzLCBvciwgaWYgZHAgaXMgbmVnYXRpdmUsIHRvIGFuIGludGVnZXIgd2hpY2ggaXMgYVxyXG4gKiBtdWx0aXBsZSBvZiAxMCoqLWRwLlxyXG4gKiBJZiBkcCBpcyBub3Qgc3BlY2lmaWVkLCByb3VuZCB0byAwIGRlY2ltYWwgcGxhY2VzLlxyXG4gKiBJZiBybSBpcyBub3Qgc3BlY2lmaWVkLCB1c2UgQmlnLlJNLlxyXG4gKlxyXG4gKiBkcD8ge251bWJlcn0gSW50ZWdlciwgLU1BWF9EUCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKiBybT8gMCwgMSwgMiBvciAzIChST1VORF9ET1dOLCBST1VORF9IQUxGX1VQLCBST1VORF9IQUxGX0VWRU4sIFJPVU5EX1VQKVxyXG4gKi9cclxuUC5yb3VuZCA9IGZ1bmN0aW9uIChkcCwgcm0pIHtcclxuICB2YXIgQmlnID0gdGhpcy5jb25zdHJ1Y3RvcjtcclxuICBpZiAoZHAgPT09IFVOREVGSU5FRCkgZHAgPSAwO1xyXG4gIGVsc2UgaWYgKGRwICE9PSB+fmRwIHx8IGRwIDwgLU1BWF9EUCB8fCBkcCA+IE1BWF9EUCkgdGhyb3cgRXJyb3IoSU5WQUxJRF9EUCk7XHJcbiAgcmV0dXJuIHJvdW5kKG5ldyBCaWcodGhpcyksIGRwLCBybSA9PT0gVU5ERUZJTkVEID8gQmlnLlJNIDogcm0pO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHNxdWFyZSByb290IG9mIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZywgcm91bmRlZCwgaWZcclxuICogbmVjZXNzYXJ5LCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgQmlnLlJNLlxyXG4gKi9cclxuUC5zcXJ0ID0gZnVuY3Rpb24gKCkge1xyXG4gIHZhciByLCBjLCB0LFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgcyA9IHgucyxcclxuICAgIGUgPSB4LmUsXHJcbiAgICBoYWxmID0gbmV3IEJpZygwLjUpO1xyXG5cclxuICAvLyBaZXJvP1xyXG4gIGlmICgheC5jWzBdKSByZXR1cm4gbmV3IEJpZyh4KTtcclxuXHJcbiAgLy8gTmVnYXRpdmU/XHJcbiAgaWYgKHMgPCAwKSB0aHJvdyBFcnJvcihOQU1FICsgJ05vIHNxdWFyZSByb290Jyk7XHJcblxyXG4gIC8vIEVzdGltYXRlLlxyXG4gIHMgPSBNYXRoLnNxcnQoeCArICcnKTtcclxuXHJcbiAgLy8gTWF0aC5zcXJ0IHVuZGVyZmxvdy9vdmVyZmxvdz9cclxuICAvLyBSZS1lc3RpbWF0ZTogcGFzcyB4IGNvZWZmaWNpZW50IHRvIE1hdGguc3FydCBhcyBpbnRlZ2VyLCB0aGVuIGFkanVzdCB0aGUgcmVzdWx0IGV4cG9uZW50LlxyXG4gIGlmIChzID09PSAwIHx8IHMgPT09IDEgLyAwKSB7XHJcbiAgICBjID0geC5jLmpvaW4oJycpO1xyXG4gICAgaWYgKCEoYy5sZW5ndGggKyBlICYgMSkpIGMgKz0gJzAnO1xyXG4gICAgcyA9IE1hdGguc3FydChjKTtcclxuICAgIGUgPSAoKGUgKyAxKSAvIDIgfCAwKSAtIChlIDwgMCB8fCBlICYgMSk7XHJcbiAgICByID0gbmV3IEJpZygocyA9PSAxIC8gMCA/ICcxZScgOiAocyA9IHMudG9FeHBvbmVudGlhbCgpKS5zbGljZSgwLCBzLmluZGV4T2YoJ2UnKSArIDEpKSArIGUpO1xyXG4gIH0gZWxzZSB7XHJcbiAgICByID0gbmV3IEJpZyhzKTtcclxuICB9XHJcblxyXG4gIGUgPSByLmUgKyAoQmlnLkRQICs9IDQpO1xyXG5cclxuICAvLyBOZXd0b24tUmFwaHNvbiBpdGVyYXRpb24uXHJcbiAgZG8ge1xyXG4gICAgdCA9IHI7XHJcbiAgICByID0gaGFsZi50aW1lcyh0LnBsdXMoeC5kaXYodCkpKTtcclxuICB9IHdoaWxlICh0LmMuc2xpY2UoMCwgZSkuam9pbignJykgIT09IHIuYy5zbGljZSgwLCBlKS5qb2luKCcnKSk7XHJcblxyXG4gIHJldHVybiByb3VuZChyLCBCaWcuRFAgLT0gNCwgQmlnLlJNKTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyB0aW1lcyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLnRpbWVzID0gUC5tdWwgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciBjLFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgeGMgPSB4LmMsXHJcbiAgICB5YyA9ICh5ID0gbmV3IEJpZyh5KSkuYyxcclxuICAgIGEgPSB4Yy5sZW5ndGgsXHJcbiAgICBiID0geWMubGVuZ3RoLFxyXG4gICAgaSA9IHguZSxcclxuICAgIGogPSB5LmU7XHJcblxyXG4gIC8vIERldGVybWluZSBzaWduIG9mIHJlc3VsdC5cclxuICB5LnMgPSB4LnMgPT0geS5zID8gMSA6IC0xO1xyXG5cclxuICAvLyBSZXR1cm4gc2lnbmVkIDAgaWYgZWl0aGVyIDAuXHJcbiAgaWYgKCF4Y1swXSB8fCAheWNbMF0pIHJldHVybiBuZXcgQmlnKHkucyAqIDApO1xyXG5cclxuICAvLyBJbml0aWFsaXNlIGV4cG9uZW50IG9mIHJlc3VsdCBhcyB4LmUgKyB5LmUuXHJcbiAgeS5lID0gaSArIGo7XHJcblxyXG4gIC8vIElmIGFycmF5IHhjIGhhcyBmZXdlciBkaWdpdHMgdGhhbiB5Yywgc3dhcCB4YyBhbmQgeWMsIGFuZCBsZW5ndGhzLlxyXG4gIGlmIChhIDwgYikge1xyXG4gICAgYyA9IHhjO1xyXG4gICAgeGMgPSB5YztcclxuICAgIHljID0gYztcclxuICAgIGogPSBhO1xyXG4gICAgYSA9IGI7XHJcbiAgICBiID0gajtcclxuICB9XHJcblxyXG4gIC8vIEluaXRpYWxpc2UgY29lZmZpY2llbnQgYXJyYXkgb2YgcmVzdWx0IHdpdGggemVyb3MuXHJcbiAgZm9yIChjID0gbmV3IEFycmF5KGogPSBhICsgYik7IGotLTspIGNbal0gPSAwO1xyXG5cclxuICAvLyBNdWx0aXBseS5cclxuXHJcbiAgLy8gaSBpcyBpbml0aWFsbHkgeGMubGVuZ3RoLlxyXG4gIGZvciAoaSA9IGI7IGktLTspIHtcclxuICAgIGIgPSAwO1xyXG5cclxuICAgIC8vIGEgaXMgeWMubGVuZ3RoLlxyXG4gICAgZm9yIChqID0gYSArIGk7IGogPiBpOykge1xyXG5cclxuICAgICAgLy8gQ3VycmVudCBzdW0gb2YgcHJvZHVjdHMgYXQgdGhpcyBkaWdpdCBwb3NpdGlvbiwgcGx1cyBjYXJyeS5cclxuICAgICAgYiA9IGNbal0gKyB5Y1tpXSAqIHhjW2ogLSBpIC0gMV0gKyBiO1xyXG4gICAgICBjW2otLV0gPSBiICUgMTA7XHJcblxyXG4gICAgICAvLyBjYXJyeVxyXG4gICAgICBiID0gYiAvIDEwIHwgMDtcclxuICAgIH1cclxuXHJcbiAgICBjW2pdID0gKGNbal0gKyBiKSAlIDEwO1xyXG4gIH1cclxuXHJcbiAgLy8gSW5jcmVtZW50IHJlc3VsdCBleHBvbmVudCBpZiB0aGVyZSBpcyBhIGZpbmFsIGNhcnJ5LCBvdGhlcndpc2UgcmVtb3ZlIGxlYWRpbmcgemVyby5cclxuICBpZiAoYikgKyt5LmU7XHJcbiAgZWxzZSBjLnNoaWZ0KCk7XHJcblxyXG4gIC8vIFJlbW92ZSB0cmFpbGluZyB6ZXJvcy5cclxuICBmb3IgKGkgPSBjLmxlbmd0aDsgIWNbLS1pXTspIGMucG9wKCk7XHJcbiAgeS5jID0gYztcclxuXHJcbiAgcmV0dXJuIHk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaW4gZXhwb25lbnRpYWwgbm90YXRpb24gdG8gZHAgZml4ZWQgZGVjaW1hbFxyXG4gKiBwbGFjZXMgYW5kIHJvdW5kZWQgdXNpbmcgQmlnLlJNLlxyXG4gKlxyXG4gKiBkcD8ge251bWJlcn0gSW50ZWdlciwgMCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKi9cclxuUC50b0V4cG9uZW50aWFsID0gZnVuY3Rpb24gKGRwKSB7XHJcbiAgcmV0dXJuIHN0cmluZ2lmeSh0aGlzLCAxLCBkcCwgZHApO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIHN0cmluZyByZXByZXNlbnRpbmcgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGluIG5vcm1hbCBub3RhdGlvbiB0byBkcCBmaXhlZCBkZWNpbWFsXHJcbiAqIHBsYWNlcyBhbmQgcm91bmRlZCB1c2luZyBCaWcuUk0uXHJcbiAqXHJcbiAqIGRwPyB7bnVtYmVyfSBJbnRlZ2VyLCAwIHRvIE1BWF9EUCBpbmNsdXNpdmUuXHJcbiAqXHJcbiAqICgtMCkudG9GaXhlZCgwKSBpcyAnMCcsIGJ1dCAoLTAuMSkudG9GaXhlZCgwKSBpcyAnLTAnLlxyXG4gKiAoLTApLnRvRml4ZWQoMSkgaXMgJzAuMCcsIGJ1dCAoLTAuMDEpLnRvRml4ZWQoMSkgaXMgJy0wLjAnLlxyXG4gKi9cclxuUC50b0ZpeGVkID0gZnVuY3Rpb24gKGRwKSB7XHJcbiAgcmV0dXJuIHN0cmluZ2lmeSh0aGlzLCAyLCBkcCwgdGhpcy5lICsgZHApO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIHN0cmluZyByZXByZXNlbnRpbmcgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIHJvdW5kZWQgdG8gc2Qgc2lnbmlmaWNhbnQgZGlnaXRzIHVzaW5nXHJcbiAqIEJpZy5STS4gVXNlIGV4cG9uZW50aWFsIG5vdGF0aW9uIGlmIHNkIGlzIGxlc3MgdGhhbiB0aGUgbnVtYmVyIG9mIGRpZ2l0cyBuZWNlc3NhcnkgdG8gcmVwcmVzZW50XHJcbiAqIHRoZSBpbnRlZ2VyIHBhcnQgb2YgdGhlIHZhbHVlIGluIG5vcm1hbCBub3RhdGlvbi5cclxuICpcclxuICogc2Qge251bWJlcn0gSW50ZWdlciwgMSB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKi9cclxuUC50b1ByZWNpc2lvbiA9IGZ1bmN0aW9uIChzZCkge1xyXG4gIHJldHVybiBzdHJpbmdpZnkodGhpcywgMywgc2QsIHNkIC0gMSk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcuXHJcbiAqIFJldHVybiBleHBvbmVudGlhbCBub3RhdGlvbiBpZiB0aGlzIEJpZyBoYXMgYSBwb3NpdGl2ZSBleHBvbmVudCBlcXVhbCB0byBvciBncmVhdGVyIHRoYW5cclxuICogQmlnLlBFLCBvciBhIG5lZ2F0aXZlIGV4cG9uZW50IGVxdWFsIHRvIG9yIGxlc3MgdGhhbiBCaWcuTkUuXHJcbiAqIE9taXQgdGhlIHNpZ24gZm9yIG5lZ2F0aXZlIHplcm8uXHJcbiAqL1xyXG5QLnRvU3RyaW5nID0gZnVuY3Rpb24gKCkge1xyXG4gIHJldHVybiBzdHJpbmdpZnkodGhpcyk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcuXHJcbiAqIFJldHVybiBleHBvbmVudGlhbCBub3RhdGlvbiBpZiB0aGlzIEJpZyBoYXMgYSBwb3NpdGl2ZSBleHBvbmVudCBlcXVhbCB0byBvciBncmVhdGVyIHRoYW5cclxuICogQmlnLlBFLCBvciBhIG5lZ2F0aXZlIGV4cG9uZW50IGVxdWFsIHRvIG9yIGxlc3MgdGhhbiBCaWcuTkUuXHJcbiAqIEluY2x1ZGUgdGhlIHNpZ24gZm9yIG5lZ2F0aXZlIHplcm8uXHJcbiAqL1xyXG5QLnZhbHVlT2YgPSBQLnRvSlNPTiA9IGZ1bmN0aW9uICgpIHtcclxuICByZXR1cm4gc3RyaW5naWZ5KHRoaXMsIDQpO1xyXG59O1xyXG5cclxuXHJcbi8vIEV4cG9ydFxyXG5cclxuXHJcbmV4cG9ydCB2YXIgQmlnID0gX0JpZ18oKTtcclxuXHJcbmV4cG9ydCBkZWZhdWx0IEJpZztcclxuIiwiaW1wb3J0IEJpZyBmcm9tICdiaWcuanMnO1xuXG4vKipcbiAqIOWKoOazleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g5Yqg5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDliqDmlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u45Yqg57uT5p6cXG4gKi9cbmZ1bmN0aW9uIGFkZCh4LCB5KSB7XG4gICAgcmV0dXJuIG5ldyBCaWcoeCkucGx1cyh5KS50b1N0cmluZygpO1xufVxuXG4vKipcbiAqIOWHj+azleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g6KKr5YeP5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDlh4/mlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u45YeP57uT5p6cXG4gKi9cbmZ1bmN0aW9uIHN1YnRyYWN0KHgsIHkpIHtcbiAgICByZXR1cm4gbmV3IEJpZyh4KS5taW51cyh5KS50b1N0cmluZygpO1xufVxuXG4vKipcbiAqIOS5mOazleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g5LmY5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDkuZjmlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u45LmY57uT5p6cXG4gKi9cbmZ1bmN0aW9uIG11bHRpcGx5KHgsIHkpIHtcbiAgICByZXR1cm4gbmV3IEJpZyh4KS50aW1lcyh5KS50b1N0cmluZygpO1xufVxuXG4vKipcbiAqIOmZpOazleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g6KKr6Zmk5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDpmaTmlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u46Zmk57uT5p6cXG4gKi9cbmZ1bmN0aW9uIGRpdmlkZSh4LCB5KSB7XG4gICAgcmV0dXJuIG5ldyBCaWcoeCkuZGl2KHkpLnRvU3RyaW5nKCk7XG59XG5cbi8qKlxuICog5qC85byP5YyW5pWw5a2XXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHZhbHVlIC0g5b6F5qC85byP5YyW55qE5pWw5a2XXG4gKiBAcGFyYW0ge251bWJlcn0gW3ByZWNpc2lvbl0gLSDnsr7luqbvvIzljbPlsI/mlbDkvY3mlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g5qC85byP5YyW5ZCO55qE5a2X56ym5LiyXG4gKi9cbmZ1bmN0aW9uIGZvcm1hdCh2YWx1ZSwgcHJlY2lzaW9uKSB7XG4gICAgY29uc3QgYmlnVmFsdWUgPSBuZXcgQmlnKHZhbHVlKTtcbiAgICBsZXQgc3RyaW5nVmFsdWUgPSBiaWdWYWx1ZS50b1N0cmluZygpO1xuICAgIHN0cmluZ1ZhbHVlID0gc2NpZW50aWZpY1RvTnVtYmVyKHN0cmluZ1ZhbHVlKTsgXG4gICAgLy/lhpnov5nkuYjpurvng6bvvIzmmK/lm6DkuLpCaWcucm91bmTnm7jlhbPmlrnms5XkuI3lpb3kvb/vvIzlvpfkuI3liLDpooTmnJ/nu5PmnpzjgIJcbiAgICBpZiAoc3RyaW5nVmFsdWUuaW5jbHVkZXMoJy4nKSkge1xuICAgICAgICBsZXQgc3RyQXJyYXkgPSBzdHJpbmdWYWx1ZS5zcGxpdCgnLicpO1xuICAgICAgICBpZiAoc3RyQXJyYXlbMV0ubGVuZ3RoID49IHByZWNpc2lvbikge1xuICAgICAgICAgICAgaWYgKDAgPT0gcHJlY2lzaW9uKSB7XG4gICAgICAgICAgICAgICAgcmV0dXJuIHN0ckFycmF5WzBdO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICAgICAgLy/miKrmlq1cbiAgICAgICAgICAgICAgICBsZXQgdHJ1bmNhdGUgPSBzdHJBcnJheVsxXS5zdWJzdHJpbmcoMCwgcHJlY2lzaW9uKTtcbiAgICAgICAgICAgICAgICByZXR1cm4gYCR7c3RyQXJyYXlbMF19LiR7dHJ1bmNhdGV9YDtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgICAgICBlbHNlIHtcbiAgICAgICAgICAgIC8v6KGl6Zu2XG4gICAgICAgICAgICBsZXQgemVyb051bWJlciA9IHByZWNpc2lvbiAtIHN0ckFycmF5WzFdLmxlbmd0aDtcbiAgICAgICAgICAgIHZhciBzdHIgPSAnJztcbiAgICAgICAgICAgIGZvciAobGV0IGkgPSAwOyBpIDwgemVyb051bWJlcjsgaSsrKSB7XG4gICAgICAgICAgICAgICAgc3RyICs9ICcwJztcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIHJldHVybiBgJHtzdHJpbmdWYWx1ZX0ke3N0cn1gO1xuICAgICAgICB9XG4gICAgfVxuICAgIGVsc2Uge1xuICAgICAgICBpZiAoMCA9PSBwcmVjaXNpb24pIHtcbiAgICAgICAgICAgIHJldHVybiBzdHJpbmdWYWx1ZTtcbiAgICAgICAgfVxuICAgICAgICBlbHNlIHtcbiAgICAgICAgICAgIGxldCB6ZXJvTnVtYmVyID0gcHJlY2lzaW9uO1xuICAgICAgICAgICAgdmFyIHN0ciA9ICcnO1xuICAgICAgICAgICAgZm9yIChsZXQgaSA9IDA7IGkgPCB6ZXJvTnVtYmVyOyBpKyspIHtcbiAgICAgICAgICAgICAgICBzdHIgKz0gJzAnO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgcmV0dXJuIGAke3N0cmluZ1ZhbHVlfS4ke3N0cn1gO1xuICAgICAgICB9XG4gICAgfVxufVxuXG4vKipcbiAqIOWvueaVsOe7hOS4reeahOavj+S4quWFg+e0oOi/m+ihjOeyvuehrui/kOeul+W5tui/lOWbnuS4gOS4quaWsOaVsOe7hFxuICogQHBhcmFtIHtBcnJheTxudW1iZXJ8c3RyaW5nPn0gYXJyIC0g5b6F6L+Q566X5pWw57uEXG4gKiBAcmV0dXJucyB7QXJyYXk8c3RyaW5nPn0gLSDov5Tlm57ov5Dnrpfnu5PmnpzmlbDnu4RcbiAqL1xuZnVuY3Rpb24gYmlnbnVtYmVyKGFycikge1xuICAgIGlmIChBcnJheS5pc0FycmF5KGFycikpIHtcbiAgICAgICAgcmV0dXJuIGFyci5tYXAoKHZhbHVlKSA9PiBCaWcodmFsdWUpLnRvRml4ZWQoKSk7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgcmV0dXJuIEJpZyhhcnIpLnRvRml4ZWQoKTtcbiAgICB9XG59XG5cbi8qKlxuICogSmF2YXNjcmlwdCDlnKjku6XkuIvmg4Xmma/kuIvkvJroh6rliqjlsIbmlbDlgLzovazmjaLkuLrnp5HlraborqHmlbDms5XvvJpcbiAqIDHjgIHlvZPmlbTmlbDnmoTkvY3mlbDotoXov4cyMuS9jeaXtu+8jGpz5Lya6Ieq5Yqo5bCG5pW05pWw5pWw5YC86L2s5YyW5Li656eR5a2m6K6w5pWw5rOV44CCXG4gICAgICBqc+S4reeahOenkeWtpuiusOaVsOazle+8mjEwMDAwMDAwMDAwMDAwMDAwMDAw77yIMjHkuKow77yJ5ZyoanPkuK3nmoTnp5HlraborrDmlbDms5XooajnpLrkuLrvvJoxZSsyMTsgICAgIFxuICogMuOAgeWwj+aVsOeCueWJjei+ueaYrzDvvIzlsI/mlbDngrnlkI7ljYHliIbkvY3vvIjljIXlkKvljYHliIbkvY3vvInkuYvlkI7nmoQw55qE5Liq5pWw6LaF6L+HNuS4quaVsOWAvOWwseS8muiHquWKqOi9rOWMluS4uuenkeWtpuiuoeaVsOazle+8m1xuICAgICAgIDAuMDAwMDAwNCDkvJrovazmjaLkuLrvvJogNGUtNywgIOiAjDAuMTAwMDAwMDQg5YiZ5LiN5Lya6KKr6L2s5o2i77yMMS4wMDAwMDAwMDTkuZ/kuI3kvJrooqvovazmjaJcbiAqIOS4uuS6humBv+WFjei/meenjeiHquWKqOi9rOaNou+8jOe8luWGmeS4gOS4quWHveaVsOWIqeeUqOato+WImeadpeWwhuenkeWtpuiuoeaVsOazleeahOaVsOWAvOi9rOaNouS4uuaVsOWAvOaYvuekuu+8mlxuICovXG5mdW5jdGlvbiBzY2llbnRpZmljVG9OdW1iZXIobnVtKSB7XG4gICAgaWYgKC9cXGQrXFwuP1xcZCplW1xcK1xcLV0qXFxkKy9pLnRlc3QobnVtKSkge1xuICAgICAgICBsZXQgemVybyA9ICcwJztcbiAgICAgICAgbGV0IHBhcnRzID0gU3RyaW5nKG51bSkudG9Mb3dlckNhc2UoKS5zcGxpdCgnZScpO1xuICAgICAgICBsZXQgZSA9IHBhcnRzWzFdO1xuICAgICAgICBsZXQgemVyb0xlbiA9IE1hdGguYWJzKGUpO1xuICAgICAgICBsZXQgc2lnbiA9IGUgLyB6ZXJvTGVuO1xuICAgICAgICBsZXQgYmVmb3JlQXJyID0gcGFydHNbMF0uc3BsaXQoJy4nKTtcbiAgICAgICAgaWYgKHNpZ24gPCAwKSB7XG4gICAgICAgICAgICBudW0gPSB6ZXJvICsgJy4nICsgbmV3IEFycmF5KHplcm9MZW4pLmpvaW4oemVybykgKyBiZWZvcmVBcnIuam9pbignJyk7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBsZXQgZGVjID0gYmVmb3JlQXJyWzFdO1xuICAgICAgICAgICAgaWYgKGRlYykge1xuICAgICAgICAgICAgICAgIHplcm9MZW4gPSB6ZXJvTGVuIC0gZGVjLmxlbmd0aDtcbiAgICAgICAgICAgICAgICBudW0gPSBiZWZvcmVBcnIuam9pbignJykgKyBuZXcgQXJyYXkoemVyb0xlbiArIDEpLmpvaW4oemVybyk7XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICB9XG4gICAgcmV0dXJuIG51bTtcbn1cblxuXG5leHBvcnQgeyBhZGQsIHN1YnRyYWN0LCBtdWx0aXBseSwgZGl2aWRlLCBmb3JtYXQsIGJpZ251bWJlciwgc2NpZW50aWZpY1RvTnVtYmVyIH07XG4iLCJpbXBvcnQgKiBhcyBudW1iZXIgZnJvbSBcIi4vbnVtYmVyXCI7XG5cbnZhciBjbGlja2FibGUgPSB0cnVlO1xuXG4vL3N5bWJvbCx1c2R0LOm7mOiupHN5bWJvbFxuZXhwb3J0IGNvbnN0IFVuaXRUeXBlID0ge1xuICAgIHVuaXRUeXBlU3ltYm9sOiAnc3ltYm9sJyxcbiAgICB1bml0VHlwZVVTRFQ6ICd1c2R0Jyxcbn07XG5cbi8v5b2T5YmNdGFi57G75Z6LICDlvZPliY3mjIHku5Mg5b2T5YmN5aeU5omYICDlvZPliY3luKbljZUg5Y6G5Y+y5bim5Y2VXG5leHBvcnQgY29uc3QgVGFiVHlwZSA9IHtcbiAgICB0YWJUeXBlUG9zaXRpb246ICdwb3NpdGlvbicsXG4gICAgdGFiVHlwZU9wZW5PcmRlcnM6ICdvcGVuT3JkZXJzJyxcbiAgICB0YWJUeXBlT3JkZXJzOiAnb3JkZXJzJyxcbiAgICB0YWJUeXBlSGlzdG9yeTogJ2hpc3RvcnknLFxufTtcblxuLy8g6aKc6Imy6YWN572uIDA657qi5rao57u/6LeMIOaIliAxOue7v+a2qOe6oui3jFxudmFyIHVwQ29sb3JMaXN0O1xudmFyIGRvd25Db2xvckxpc3Q7XG5cbmNvbnN0IERFRkFVTFRfU1RSID0gJzAuMDAnO1xuXG4vKipcbiAqIEB0eXBlZGVmIHtPYmplY3R9IENvbW1vbkRhdGFcbiAqIEBwcm9wZXJ0eSB7bnVtYmVyfSBwcmljZUNvbG9yVHlwZSAgICAtIOS7t+agvOa2qOi3jOW5heminOiJsuiuvue9rlxuICogQHByb3BlcnR5IHtudW1iZXJ9IGNvbG9yTW9kZSAgICAgICAgIC0g55m95aSp6buR5aSc5qih5byPXG4gKiBAcHJvcGVydHkge3N0cmluZ30gbGFuZ3VhZ2UgICAgICAgICAgLSDor63np43phY3nva5cbiAqIEBwcm9wZXJ0eSB7c3RyaW5nfSBPUyAgICAgICAgICAgICAgICAtIOezu+e7n1xuICogQHByb3BlcnR5IHtzdHJpbmd9IGFwcFZlcnNpb24gICAgICAgIC0g54mI5pys5Y+3XG4gKiBAcHJvcGVydHkge251bWJlcn0gaXNJblJldmlldyAgICAgICAgLSBpT1PlrqHmoLjnirbmgIFcbiAqIEBwcm9wZXJ0eSB7bnVtYmVyfSBpc0xvZ2luICAgICAgICAgICAtIOaYr+WQpueZu+W9lVxuICogQHByb3BlcnR5IHtvYmplY3R9IGxpbmVhclN3YXBXc0RhdGEgIC0gVeacrOS9jeWQiOe6puiuoumYheS/oeaBr1xuICovXG5cbi8qKiBAdHlwZSBDb21tb25EYXRhICovXG5leHBvcnQgdmFyIGNvbW1vbkRhdGEgPSB7XG4gICAgdXNlclNpZ246IFwiXCIsIC8vLyDnlKjmiLfmoIfor4ZcbiAgICBjdXJyZW50U3ltYm9sOiBcIkJUQy1VU0RUXCIsIC8vL+W9k+WJjeeahOWQiOe6puWTgeenjVxuICAgIGN1cnJlbnRDb250cmFjdEluZm86IHt9LCAvLy/lvZPliY3nmoTlkIjnuqblk4Hnp43mlbDmja5cbiAgICBjb250cmFjdEluZm9EYXRhOiBbXSwgLy8vbGluZWFyLXN3YXAtb3JkZXIveC92MS9saW5lYXJfc3dhcF9jb250cmFjdF9pbmZvP2J1c2luZXNzX3R5cGU9YWxsJnRyYWRlX3BhcnRpdGlvbj1hbGzjgIDmjqXlj6Pov5Tlm57nmoTmiYDmnInlkIjnuqblk4Hnp43mlbDmja5cbiAgICBjb250cmFjdEg1VXJsOiBcIlwiLCAvLy/lkIjnuqZINeWcsOWdgFxuICAgIGN1cnJlbmN5UmF0ZTogXCI2LjRcIiwgLy8v576O5YWD5a+55YW25a6D5rOV5biB55qE5rGH546HXG4gICAgY3VycmVuY3lDaGFyYWN0ZXI6IFwiQ05ZXCIsIC8vL+azleW4geespuWPt1xuICAgIHByaWNlQ29sb3JUeXBlOiAwLCAvLy8w77ya57qi5rao57u/6LeMICAgMe+8mue7v+a2qOe6oui3jFxuICAgIGNvbG9yTW9kZTogMCwgLy8vMO+8mueZveWkqSAgIDHvvJrpu5HlpJxcbiAgICBPUzogMCwgLy8w77yaaU9TICAx77ya5a6J5Y2TXG4gICAgYXBwVmVyc2lvbjogXCJcIiwgLy9hcHDniYjmnKzlj7dcbiAgICBpc0luUmV2aWV3OiAxLFxuICAgIGlzTG9naW46IDAsXG4gICAgd2ViVXJsOiBcIlwiLCAvLy8gaDXliqjmgIHln5/lkI1cbiAgICBsYW5ndWFnZTogXCJcIiwgLy8vIOivreiogOenjeexu1xuICAgIGxpbmVhclN3YXBXc0RhdGE6IHt9LFxuICAgIHVuaXRUeXBlOiBVbml0VHlwZS51bml0VHlwZVN5bWJvbCxcbiAgICBsYXN0VW5pdFR5cGU6IFVuaXRUeXBlLnVuaXRUeXBlU3ltYm9sLFxuICAgIG9wZW5TaW5nbGVNYXJnaW46IHRydWUsXG4gICAgY3VyVGFiVHlwZTogVGFiVHlwZS50YWJUeXBlUG9zaXRpb24sXG4gICAgaXNDaGlsZDogZmFsc2UsXG4gICAgYm90dG9tQmFySGVpZ2h0OiAwLFxufTtcblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHN1YlByaWNlV2ViU29ja2V0KHR5cGUgPSBcImxpbmVhclN3YXBXc1wiKSB7XG4gICAgYXdhaXQgJG5hdGl2ZUFQSS5jb3B5VHJhZGluZ0JyaWRnZSh7XG4gICAgICAgIGFjdGlvbjogXCJzdWJQcmljZVdlYlNvY2tldFwiLFxuICAgICAgICB0eXBlOiB0eXBlLFxuICAgIH0pO1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gdW5zdWJQcmljZVdlYlNvY2tldCh0eXBlID0gXCJsaW5lYXJTd2FwV3NcIikge1xuICAgIGF3YWl0ICRuYXRpdmVBUEkuY29weVRyYWRpbmdCcmlkZ2Uoe1xuICAgICAgICBhY3Rpb246IFwidW5zdWJQcmljZVdlYlNvY2tldFwiLFxuICAgICAgICB0eXBlOiB0eXBlLFxuICAgIH0pO1xufVxuXG4vKirlkIjnuqbkv6Hmga/ojrflj5bnm7jlhbPmlrnms5UgKi9cblxuLyoqXG4gKiDmoLnmja5jb250cmFjdFNob3J0VHlwZeaJvuWIsOebuOW6lOeahOWQiOe6pm1vZGVsXG4gKiBAcGFyYW0ge1N0cmluZ30gY29udHJhY3RTaG9ydFR5cGVcbiAqIEByZXR1cm5zIOWvueW6lOeahG1vZGVsXG4gKi9cbmV4cG9ydCBmdW5jdGlvbiBnZXRNb2RlbEJ5Q29udHJhY3RTaG9ydFR5cGUoY29udHJhY3RTaG9ydFR5cGUpIHtcbiAgICBmb3IgKGxldCBpID0gMDsgaSA8IGNvbW1vbkRhdGEuY29udHJhY3RJbmZvRGF0YS5sZW5ndGg7IGkrKykge1xuICAgICAgICBpZiAoXG4gICAgICAgICAgICBjb21tb25EYXRhLmNvbnRyYWN0SW5mb0RhdGFbaV0uY29udHJhY3Rfc2hvcnRfdHlwZSA9PSBjb250cmFjdFNob3J0VHlwZVxuICAgICAgICApIHtcbiAgICAgICAgICAgIHJldHVybiBjb21tb25EYXRhLmNvbnRyYWN0SW5mb0RhdGFbaV07XG4gICAgICAgIH1cbiAgICB9XG5cbiAgICByZXR1cm4gbnVsbDtcbn1cblxuLyoqXG4gKiDmoLnmja5jb250cmFjdENvZGXmib7liLDnm7jlupTnmoTlkIjnuqZtb2RlbFxuICogQHBhcmFtIHtTdHJpbmd9IGNvbnRyYWN0Q29kZVxuICogQHJldHVybnMg5a+55bqU55qEbW9kZWxcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIGdldE1vZGVsQnlDb250cmFjdENvZGUoY29udHJhY3RDb2RlKSB7XG4gICAgZm9yIChsZXQgaSA9IDA7IGkgPCBjb21tb25EYXRhLmNvbnRyYWN0SW5mb0RhdGEubGVuZ3RoOyBpKyspIHtcbiAgICAgICAgaWYgKGNvbW1vbkRhdGEuY29udHJhY3RJbmZvRGF0YVtpXS5jb250cmFjdF9jb2RlID09IGNvbnRyYWN0Q29kZSkge1xuICAgICAgICAgICAgcmV0dXJuIGNvbW1vbkRhdGEuY29udHJhY3RJbmZvRGF0YVtpXTtcbiAgICAgICAgfVxuICAgIH1cblxuICAgIHJldHVybiBudWxsO1xufVxuXG4vKipcbiAqIOiOt+WPluWQiOe6pumdouWAvO+8jOWPr+eUqOS6juacgOWwj+S4i+WNlemHj+eahOagoemqjFxuICogQHBhcmFtIHvlr7nosaF9IGNvbnRyYWN0SW5mbyDlkIjnuqZtb2RlbFxuICogQHJldHVybnMgU3RyaW5n77yM5LiA5byg5a+55bqU55qE5biB6YePXG4gKi9cbmV4cG9ydCBmdW5jdGlvbiBnZXRDb250cmFjdFNpemUoY29udHJhY3RJbmZvKSB7XG4gICAgaWYgKGNvbnRyYWN0SW5mbykge1xuICAgICAgICByZXR1cm4gY29udHJhY3RJbmZvLmNvbnRyYWN0X3NpemUudG9TdHJpbmcoKTtcbiAgICB9XG5cbiAgICByZXR1cm4gXCJcIjtcbn1cblxuLyoqXG4gKiDojrflj5blkIjnuqblk4Hnp43nmoTmlbDph4/nsr7luqbvvJrnlKjkuo7otKbmiLfmnYPnm4rjgIHlt7Llrp7njrDnm4jkuo/jgIHmnKrlrp7njrDnm4jkuo/jgIHlj6/nlKjmi4Xkv53otYTkuqfjgIHmjIHku5Pmi4Xkv53otYTkuqfjgIHlhrvnu5Pmi4Xkv53otYTkuqfjgIHkubDljZbnm5jlj6PmlbDph4/jgIHkubDljZbnm5jlj6PntK/orqHjgIHlj6/lvIDph4/jgIHkuIvljZXph4/jgIHmjIHku5Pph4/jgIHlj6/lubPph4/jgIHmt7Hluqblm77ntK/orqHjgIHpnZnmgIHmnYPnm4rjgIHmlLbnm4rjgIHpo47pmanlh4blpIfph5Hnsr7luqZcbiAqIEBwYXJhbSB75a+56LGhfSBjb250cmFjdEluZm8g5ZCI57qmbW9kZWxcbiAqIEByZXR1cm5zIOaVsOmHj+eyvuW6plxuICovXG5leHBvcnQgZnVuY3Rpb24gZ2V0T3RoZXJBbW91bnRQcmVjaXNpb24oY29udHJhY3RJbmZvKSB7XG4gICAgaWYgKGNvbnRyYWN0SW5mbykge1xuICAgICAgICByZXR1cm4gcGFyc2VJbnQoY29udHJhY3RJbmZvLm90aGVyX2Ftb3VudF9wcmVjaXNpb24pO1xuICAgIH1cblxuICAgIHJldHVybiA0O1xufVxuXG4vKipcbiAqIOiOt+WPluWQiOe6puWTgeenjeeahOS7t+agvOeyvuW6piDmjIHku5PlnYfku7cg5byA5LuT5Lu35qC8IOatouebiOatouaNn+S7t+agvCDpooTkvLDniIbku5Pku7fmoLxcbiAqIEBwYXJhbSB75a+56LGhfSBjb250cmFjdEluZm8g5ZCI57qmbW9kZWxcbiAqIEByZXR1cm5zIOS7t+agvOeyvuW6plxuICovXG5leHBvcnQgZnVuY3Rpb24gZ2V0UHJpY2VUaWNrUHJlY2lzaW9uKGNvbnRyYWN0SW5mbykge1xuICAgIGlmIChudWxsID09IGNvbnRyYWN0SW5mbykge1xuICAgICAgICByZXR1cm4gNDtcbiAgICB9XG5cbiAgICB2YXIgc2l6ZVN0cmluZyA9IG51bWJlci5iaWdudW1iZXIoY29udHJhY3RJbmZvLnByaWNlX3RpY2spO1xuICAgIHJldHVybiBzaXplU3RyaW5nLnNwbGl0KFwiLlwiKVsxXS5sZW5ndGg7XG59XG5cbi8qKlxuICog6I635Y+W5ZCI57qm5ZOB56eN55qE6Z2i5YC857K+5bqmIOW8gOS7k+mHj1xuICogQHBhcmFtIHvlr7nosaF9IGNvbnRyYWN0SW5mbyDlkIjnuqZtb2RlbFxuICogQHJldHVybnMg6Z2i5YC857K+5bqmXG4gKi9cbmV4cG9ydCBmdW5jdGlvbiBnZXRDb250cmFjdFNpemVQcmVjaXNpb24oY29udHJhY3RJbmZvKSB7XG4gICAgaWYgKG51bGwgPT0gY29udHJhY3RJbmZvKSB7XG4gICAgICAgIHJldHVybiAwO1xuICAgIH1cblxuICAgIGlmIChwYXJzZUZsb2F0KGNvbnRyYWN0SW5mby5jb250cmFjdF9zaXplKSA+PSAxLjApIHtcbiAgICAgICAgcmV0dXJuIDA7XG4gICAgfVxuXG4gICAgdmFyIHNpemVTdHJpbmcgPSBjb250cmFjdEluZm8uY29udHJhY3Rfc2l6ZS50b1N0cmluZygpO1xuICAgIHJldHVybiBzaXplU3RyaW5nLnNwbGl0KFwiLlwiKVsxXS5sZW5ndGg7XG59XG5cbi8qKlxuICog6I635Y+W5ZCI57qm5ZOB56eN55qE5omL57ut6LS557K+5bqmXG4gKiBAcGFyYW0ge+WvueixoX0gY29udHJhY3RJbmZvIOWQiOe6pm1vZGVsXG4gKiBAcmV0dXJucyDmiYvnu63otLnnsr7luqZcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIGdldEZlZUFtb3VudFByZWNpc2lvbihjb250cmFjdEluZm8pIHtcbiAgICBpZiAoY29udHJhY3RJbmZvKSB7XG4gICAgICAgIHJldHVybiBwYXJzZUludChjb250cmFjdEluZm8uZmVlX2Ftb3VudF9wcmVjaXNpb24pO1xuICAgIH1cbiAgICByZXR1cm4gNjtcbn1cblxuLyoqXG4gKiDojrflj5blkIjnuqblk4Hnp43nmoTlhbbku5bnsbvlnovnsr7luqYg5oC75pS255uKIOS7iuaXpeaUtuebiiDljoblj7LmlLbnm4pcbiAqIEBwYXJhbSB75a+56LGhfSBjb250cmFjdEluZm8g5ZCI57qmbW9kZWxcbiAqIEByZXR1cm5zIOWFtuS7luexu+Wei+eyvuW6plxuICovXG5leHBvcnQgZnVuY3Rpb24gZ2V0T3RoZXJQcmVjaXNpb24oY29udHJhY3RJbmZvKSB7XG4gICAgaWYgKGNvbnRyYWN0SW5mbykge1xuICAgICAgICByZXR1cm4gcGFyc2VJbnQoY29udHJhY3RJbmZvLm90aGVyX2Ftb3VudF9wcmVjaXNpb24pO1xuICAgIH1cbiAgICByZXR1cm4gNDtcbn1cblxuLyoqXG4gKiDlj5HpgIHor7fmsYJcbiAqIEBwYXJhbSB7c3RyaW5nfSBwYXRoIFxuICogQHBhcmFtIHtNYXB9IHBhcmFtcyBcbiAqIEBwYXJhbSB7bnVtYmVyfSBtZXRob2QgMDpHRVQgMTpQT1NUXG4gKiBAcGFyYW0ge251bWJlcn0gaG9zdFR5cGUgMDpIQkcgMTpPVEMgMjpJTlNUIDM6S1lDIDQ6UFJPIDU6VUNUT0tFTiA2Ok5PVUNUT0tFTiA3OkhPTUUgODpMSU5FQVJfU1dBUFxuICogQHBhcmFtIHtNYXB9IGhlYWRlciBcbiAqIEBwYXJhbSB7bnVtYmVyfSByZXR1cm5TdGF0dXMgXG4gKiBAcmV0dXJucyBcbiAqL1xuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNlbmRSZXF1ZXN0KHBhdGgsIHBhcmFtcyA9IHt9LCBtZXRob2QgPSAwLCBob3N0VHlwZSA9IDAsIGhlYWRlciA9IHt9LCByZXR1cm5TdGF0dXMgPSAwKSB7XG4gICAgY29uc29sZS5sb2coYHJlcXVlc3QgJHtwYXRofSwgcGFyYW1zOiR7SlNPTi5zdHJpbmdpZnkocGFyYW1zKX1gKTtcblxuICAgIGlmIChob3N0VHlwZSA9PSA1IHx8IGhvc3RUeXBlID09IDYpIHtcbiAgICAgICAgaGVhZGVyW1wiQ29udGVudC1UeXBlXCJdID0gXCJhcHBsaWNhdGlvbi9qc29uXCI7XG4gICAgfVxuXG4gICAgY29uc3QgcGFyYW0gPSB7XG4gICAgICAgIHBhdGgsXG4gICAgICAgIG1ldGhvZCxcbiAgICAgICAgaG9zdFR5cGUsXG4gICAgICAgIGhlYWRlcixcbiAgICAgICAgcGFyYW1zLFxuICAgIH07XG4gICAgdHJ5IHtcbiAgICAgICAgdmFyIHJlc3BvbnNlU3RyaW5nID0gYXdhaXQgJG5hdGl2ZUFQSS5yZXF1ZXN0KEpTT04uc3RyaW5naWZ5KHBhcmFtKSk7XG4gICAgICAgIHZhciByZXNwb25zZSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcpO1xuICAgICAgICB2YXIgeyBjb2RlLCBkYXRhIH0gPSByZXNwb25zZTtcbiAgICAgICAgaWYgKDggPT0gaG9zdFR5cGUpIHtcbiAgICAgICAgICAgIC8v5ZCI57qm55qE5o6l5Y+j5aSE55CGXG4gICAgICAgICAgICB2YXIgc3RhdHVzID0gcmVzcG9uc2Uuc3RhdHVzO1xuICAgICAgICAgICAgdmFyIGVycl9jb2RlID0gcmVzcG9uc2VbXCJlcnItY29kZVwiXTtcbiAgICAgICAgICAgIHZhciBlcnJfbXNnID0gcmVzcG9uc2VbXCJlcnItbXNnXCJdO1xuICAgICAgICAgICAgaWYgKHN0YXR1cyA9PSBcIm9rXCIpIHtcbiAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCAke3BhdGh9IGRvbmVgKTtcbiAgICAgICAgICAgICAgICBpZiAodHlwZW9mIGRhdGEgPT09ICdudW1iZXInKSB7XG4gICAgICAgICAgICAgICAgICAgIGxldCBzdGFydCA9IGBcImRhdGFcIjpgO1xuICAgICAgICAgICAgICAgICAgICBsZXQgc3RhcnRJbmRleCA9IHJlc3BvbnNlU3RyaW5nLmluZGV4T2Yoc3RhcnQpO1xuICAgICAgICAgICAgICAgICAgICBsZXQgZW5kID0gYCxcInRzXCI6YDtcbiAgICAgICAgICAgICAgICAgICAgbGV0IGVuZEluZGV4ID0gcmVzcG9uc2VTdHJpbmcuaW5kZXhPZihlbmQpO1xuICAgICAgICAgICAgICAgICAgICBsZXQgZGF0YVN0cmluZyA9IHJlc3BvbnNlU3RyaW5nLnN1YnN0cmluZyhzdGFydEluZGV4ICsgc3RhcnQubGVuZ3RoLCBlbmRJbmRleCk7XG4gICAgICAgICAgICAgICAgICAgIGNvbnNvbGUubG9nKGBkYXRhIGlzIHR5cGVvZiBudW1iZXIsIGRhdGFTdHJpbmcgPSAke2RhdGFTdHJpbmd9YCk7XG4gICAgICAgICAgICAgICAgICAgIHJldHVybiBkYXRhU3RyaW5nO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICByZXR1cm4gZGF0YTtcbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgZmFpbGVkLCBjb2RlPSR7ZXJyX2NvZGV9LCBtZXNzYWdlPSR7ZXJyX21zZ31gKTtcbiAgICAgICAgICAgICAgICBpZiAobWV0aG9kICE9IDApIHtcbiAgICAgICAgICAgICAgICAgICAgc2hvd1RvYXN0KGVycl9tc2cpO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICByZXR1cm4gbnVsbDtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfSBlbHNlIGlmIChjb2RlID09IDIwMCkge1xuICAgICAgICAgICAgaWYgKGRhdGEgPT0gbnVsbCkge1xuICAgICAgICAgICAgICAgIHJldHVybiByZXNwb25zZTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0ICR7cGF0aH0gZG9uZWApO1xuICAgICAgICAgICAgcmV0dXJuIGRhdGE7XG4gICAgICAgIH0gZWxzZSBpZiAoKGNvZGUgPT0gbnVsbCB8fCBjb2RlID09IFwiXCIgfHwgY29kZSA9PSBcInVuZGVmaW5lZFwiKSAmJiByZXNwb25zZS5zdGF0dXMgPT0gXCJva1wiKSB7XG4gICAgICAgICAgICBpZiAoZGF0YSA9PSBudWxsKSB7XG4gICAgICAgICAgICAgICAgcmV0dXJuIHJlc3BvbnNlO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgJHtwYXRofSBkb25lYCk7XG4gICAgICAgICAgICByZXR1cm4gZGF0YTtcbiAgICAgICAgfSBlbHNlIGlmIChyZXR1cm5TdGF0dXMgPT0gMSkge1xuICAgICAgICAgICAgLy9wcm/nmoTmjqXlj6PlpITnkIZcbiAgICAgICAgICAgIHZhciBzdGF0dXMgPSByZXNwb25zZS5zdGF0dXM7XG4gICAgICAgICAgICB2YXIgZXJyX2NvZGUgPSByZXNwb25zZVtcImVyci1jb2RlXCJdO1xuICAgICAgICAgICAgdmFyIGVycl9tc2cgPSByZXNwb25zZVtcImVyci1tc2dcIl07XG4gICAgICAgICAgICBpZiAoc3RhdHVzID09IFwib2tcIikge1xuICAgICAgICAgICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0ICR7cGF0aH0gZG9uZWApO1xuICAgICAgICAgICAgICAgIHJldHVybiBkYXRhO1xuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCBmYWlsZWQsIGNvZGU9JHtlcnJfY29kZX0sIG1lc3NhZ2U9JHtlcnJfbXNnfWApO1xuICAgICAgICAgICAgICAgIGlmIChtZXRob2QgIT0gMCkge1xuICAgICAgICAgICAgICAgICAgICBzaG93VG9hc3QoZXJyX21zZyk7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIHJldHVybiBudWxsO1xuICAgICAgICAgICAgfVxuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgZmFpbGVkLCBjb2RlPSR7Y29kZX1gKTtcbiAgICAgICAgICAgIGxldCBtZXNzYWdlID0gcmVzcG9uc2UubWVzc2FnZTtcbiAgICAgICAgICAgIGlmIChtZXNzYWdlKSB7XG4gICAgICAgICAgICAgICAgc2hvd1RvYXN0KG1lc3NhZ2UpO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgcmV0dXJuIG51bGw7XG4gICAgICAgIH1cbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0IGVycm9yLCBlcnJvcj0ke2V9YCk7XG4gICAgICAgIHJldHVybiBudWxsO1xuICAgIH1cbn1cblxuLy/lj5HpgIHor7fmsYJcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzZW5kUmVxdWVzdFJldHVybkNvZGUocGF0aCwgcGFyYW1zID0ge30sIG1ldGhvZCA9IDAsIGhvc3RUeXBlID0gMCwgaGVhZGVyID0ge30pIHtcbiAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCAke3BhdGh9LCBwYXJhbXM6JHtKU09OLnN0cmluZ2lmeShwYXJhbXMpfWApO1xuXG4gICAgaWYgKGhvc3RUeXBlID09IDUgfHwgaG9zdFR5cGUgPT0gNikge1xuICAgICAgICBoZWFkZXJbXCJDb250ZW50LVR5cGVcIl0gPSBcImFwcGxpY2F0aW9uL2pzb25cIjtcbiAgICB9XG5cbiAgICBjb25zdCBwYXJhbSA9IHtcbiAgICAgICAgcGF0aCxcbiAgICAgICAgbWV0aG9kLFxuICAgICAgICBob3N0VHlwZSxcbiAgICAgICAgaGVhZGVyLFxuICAgICAgICBwYXJhbXMsXG4gICAgfTtcbiAgICB0cnkge1xuICAgICAgICB2YXIgcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QoSlNPTi5zdHJpbmdpZnkocGFyYW0pKTtcbiAgICAgICAgdmFyIHJlc3BvbnNlID0gSlNPTi5wYXJzZShyZXNwb25zZVN0cmluZyk7XG4gICAgICAgIHZhciB7IGNvZGUsIGRhdGEgfSA9IHJlc3BvbnNlO1xuICAgICAgICBpZiAoOCA9PSBob3N0VHlwZSkge1xuICAgICAgICAgICAgLy/lkIjnuqbnmoTmjqXlj6PlpITnkIZcbiAgICAgICAgICAgIHZhciBzdGF0dXMgPSByZXNwb25zZS5zdGF0dXM7XG4gICAgICAgICAgICB2YXIgZXJyX2NvZGUgPSByZXNwb25zZS5lcnJfY29kZTtcbiAgICAgICAgICAgIHZhciBlcnJfbXNnID0gcmVzcG9uc2UuZXJyX21zZztcbiAgICAgICAgICAgIGlmIChzdGF0dXMgPT0gXCJva1wiKSB7XG4gICAgICAgICAgICAgICAgcmV0dXJuIGNvZGU7XG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0IGZhaWxlZCwgY29kZT0ke2Vycl9jb2RlfSwgbWVzc2FnZT0ke2Vycl9tc2d9YCk7XG4gICAgICAgICAgICAgICAgaWYgKG1ldGhvZCAhPSAwKSB7XG4gICAgICAgICAgICAgICAgICAgIHNob3dUb2FzdChlcnJfbXNnKTtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgcmV0dXJuIGNvZGU7XG4gICAgICAgICAgICB9XG4gICAgICAgIH0gZWxzZSBpZiAoY29kZSA9PSAyMDApIHtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0ICR7cGF0aH0gZG9uZWApO1xuICAgICAgICAgICAgcmV0dXJuIGNvZGU7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCBmYWlsZWQsIGNvZGU9JHtjb2RlfWApO1xuICAgICAgICAgICAgbGV0IG1lc3NhZ2UgPSByZXNwb25zZVtcImVyci1tc2dcIl07XG4gICAgICAgICAgICBpZiAobWV0aG9kICE9IDAgJiYgbWVzc2FnZSkge1xuICAgICAgICAgICAgICAgIHNob3dUb2FzdChtZXNzYWdlKTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIHJldHVybiBjb2RlO1xuICAgICAgICB9XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCBlcnJvciwgZXJyb3I9JHtlfWApO1xuICAgICAgICByZXR1cm4gMDtcbiAgICB9XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzZW5kUmVxdWVzdFdpdGhDYWNoZShcbiAgICBwYXRoLFxuICAgIGNhbGxiYWNrLFxuICAgIHBhcmFtcyA9IHt9LFxuICAgIG1ldGhvZCA9IDAsXG4gICAgaG9zdFR5cGUgPSAwLFxuICAgIGhlYWRlciA9IHt9LFxuICAgIGNhY2hlS2V5TGlzdCA9IG51bGxcbikge1xuICAgIHZhciBjYWNoZUtleSA9IGdldENhY2hlS2V5KHBhdGgsIHBhcmFtcywgY2FjaGVLZXlMaXN0KTtcbiAgICBjb25zdCBjYWNoZSA9IGF3YWl0IHJlYWQoXCJhcGlDYWNoZVwiLCBjYWNoZUtleSk7XG4gICAgaWYgKGNhY2hlICYmIGNhbGxiYWNrKSB7XG4gICAgICAgIGNhbGxiYWNrKGNhY2hlLCB0cnVlKTtcbiAgICB9XG4gICAgY29uc3QgcmVxdWVzdERhdGEgPSBhd2FpdCBzZW5kUmVxdWVzdChwYXRoLCBwYXJhbXMsIG1ldGhvZCwgaG9zdFR5cGUsIGhlYWRlcik7XG4gICAgYXdhaXQgc2F2ZShcImFwaUNhY2hlXCIsIGNhY2hlS2V5LCByZXF1ZXN0RGF0YSk7XG4gICAgaWYgKHJlcXVlc3REYXRhICYmIGNhbGxiYWNrKSB7XG4gICAgICAgIGNhbGxiYWNrKHJlcXVlc3REYXRhLCBmYWxzZSk7XG4gICAgfVxuICAgIHJldHVybiByZXF1ZXN0RGF0YTtcbn1cblxuZnVuY3Rpb24gZ2V0Q2FjaGVLZXkocGF0aCwgcGFyYW1zLCBjYWNoZUtleUxpc3QgPSBudWxsKSB7XG4gICAgdmFyIGNhY2hlS2V5ID0gXCJcIjtcbiAgICBpZiAoY2FjaGVLZXlMaXN0ID09IG51bGwpIHtcbiAgICAgICAgLy9udWxs77ya5omA5pyJ5Y+C5pWw5L2c5Li657yT5a2Y5Y+C5pWwXG4gICAgICAgIHZhciBwYXJhbVN0ciA9IEpTT04uc3RyaW5naWZ5KHBhcmFtcyk7XG4gICAgICAgIGNhY2hlS2V5ID0gYCR7cGF0aH1fJHtwYXJhbVN0cn1fJHtjb21tb25EYXRhLmxhbmd1YWdlfV8ke2NvbW1vbkRhdGEuY29sb3JNb2RlfV8ke2NvbW1vbkRhdGEuaXNMb2dpbn1gO1xuICAgIH0gZWxzZSBpZiAoY2FjaGVLZXlMaXN0Lmxlbmd0aCA9PSAwKSB7XG4gICAgICAgIC8vIFtdICzkuKrmlbDkuLow77ya5LiN6ZyA6KaB5Y+C5pWw5L2c5Li657yT5a2Y5Y+C5pWwXG4gICAgICAgIGNhY2hlS2V5ID0gYCR7cGF0aH1fJHtjb21tb25EYXRhLmxhbmd1YWdlfV8ke2NvbW1vbkRhdGEuY29sb3JNb2RlfV8ke2NvbW1vbkRhdGEuaXNMb2dpbn1gO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIHZhciBjYWNoZUtleUxpc3RTdHIgPSBjYWNoZUtleUxpc3Quam9pbihcIl9cIik7XG4gICAgICAgIGNhY2hlS2V5ID0gYCR7cGF0aH1fJHtjYWNoZUtleUxpc3RTdHJ9XyR7Y29tbW9uRGF0YS5sYW5ndWFnZX1fJHtjb21tb25EYXRhLmNvbG9yTW9kZX1fJHtjb21tb25EYXRhLmlzTG9naW59YDtcbiAgICB9XG4gICAgcmV0dXJuIGNhY2hlS2V5O1xufVxuXG4vL+agueaNrua2qOi3jOW5heiOt+WPluaYvuekuuminOiJslxuZXhwb3J0IGZ1bmN0aW9uIGdldFByaWNlQ29sb3IocmF0aW8pIHtcbiAgICAvLyBjb25zb2xlLmxvZygnZ2V0UHJpY2VDb2xvcicpO1xuICAgIGlmIChyYXRpbyA9PSBudWxsKSB7XG4gICAgICAgIHJhdGlvID0gMDtcbiAgICB9XG4gICAgY29uc3QgcmF0aW9fYWJzID0gTWF0aC5hYnMocmF0aW8pO1xuICAgIHZhciBjb2xvckxldmVsID0gMDtcbiAgICBpZiAocmF0aW9fYWJzID4gMCAmJiByYXRpb19hYnMgPCAzKSB7XG4gICAgICAgIGNvbG9yTGV2ZWwgPSAxO1xuICAgIH0gZWxzZSBpZiAocmF0aW9fYWJzID49IDMgJiYgcmF0aW9fYWJzIDwgOCkge1xuICAgICAgICBjb2xvckxldmVsID0gMjtcbiAgICB9IGVsc2UgaWYgKHJhdGlvX2FicyA+PSA4KSB7XG4gICAgICAgIGNvbG9yTGV2ZWwgPSAzO1xuICAgIH1cbiAgICB2YXIgY29sb3JIZXhTdHIgPSBudWxsO1xuICAgIGlmIChyYXRpbyA+IDApIHtcbiAgICAgICAgY29sb3JIZXhTdHIgPSB1cENvbG9yTGlzdFtjb2xvckxldmVsXTtcbiAgICB9IGVsc2Uge1xuICAgICAgICBjb2xvckhleFN0ciA9IGRvd25Db2xvckxpc3RbY29sb3JMZXZlbF07XG4gICAgfVxuICAgIHJldHVybiBjb2xvckhleFN0cjtcbn1cblxuLy/ojrflj5bku7fmoLzmmL7npLrmlofmnKxcbmV4cG9ydCBmdW5jdGlvbiBnZXRQcmljZVN0cmluZyhwcmljZVN0ciwgcHJlY2lzaW9uKSB7XG4gICAgdmFyIHByaWNlVGVtcCA9IHByaWNlU3RyO1xuICAgIHZhciBkZWNpbWFsQXJyID0gcHJpY2VUZW1wLnNwbGl0KFwiLlwiKTtcbiAgICBpZiAoZGVjaW1hbEFyci5sZW5ndGggPCAyKSB7XG4gICAgICAgIHByaWNlVGVtcCA9IHBhcnNlRmxvYXQocHJpY2VUZW1wKS50b0ZpeGVkKDEpO1xuICAgICAgICBkZWNpbWFsQXJyID0gcHJpY2VUZW1wLnNwbGl0KFwiLlwiKTtcbiAgICB9XG4gICAgY29uc3QgZGVjaW1hbENvdW50ID0gZGVjaW1hbEFyclsxXS5sZW5ndGg7XG4gICAgY29uc3QgcGFkZGVkUHJpY2VTdHIgPVxuICAgICAgICBkZWNpbWFsQ291bnQgPCBwcmVjaXNpb25cbiAgICAgICAgICAgID8gcHJpY2VUZW1wLnBhZEVuZChwcmljZVRlbXAubGVuZ3RoICsgKHByZWNpc2lvbiAtIGRlY2ltYWxDb3VudCksIFwiMFwiKVxuICAgICAgICAgICAgOiBwYXJzZUZsb2F0KHByaWNlVGVtcCkudG9GaXhlZChwcmVjaXNpb24pO1xuICAgIGNvbnN0IGZpbmFsUHJpY2VTdHIgPSBwYWRkZWRQcmljZVN0ci5yZXBsYWNlKC9cXGQoPz0oXFxkezN9KStcXC4pL2csIFwiJCYsXCIpO1xuICAgIHJldHVybiBmaW5hbFByaWNlU3RyO1xufVxuXG4vL+i/m+ihjOeyvuW6puWkhOeQhlxuZXhwb3J0IGZ1bmN0aW9uIGZvcm1hdFByZWNpc2lvbih2YWx1ZSwgcHJlY2lzaW9uKSB7XG4gICAgdHJ5IHtcbiAgICAgICAgY29uc3QgcmVzdWx0ID0gbnVtYmVyLmZvcm1hdCh2YWx1ZSwgcHJlY2lzaW9uKTtcbiAgICAgICAgcmV0dXJuIHJlc3VsdDtcbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGUpO1xuICAgICAgICByZXR1cm4gdmFsdWUudG9GaXhlZChwcmVjaXNpb24pO1xuICAgIH1cbn1cblxuLy8gLy/miZPlvIBVUkxcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBvcGVuVVJMKHVybCkge1xuICAgIGlmICghY2xpY2thYmxlKSB7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgY29uc29sZS5sb2coYG9wZW4gdXJsOmAsIHVybCk7XG4gICAgaWYgKHVybCAmJiB1cmwgIT0gbnVsbCAmJiB1cmwubGVuZ3RoID4gMCkge1xuICAgICAgICBhd2FpdCAkbmF0aXZlQVBJLm9wZW5Sb3V0ZSh1cmwpO1xuICAgIH1cbiAgICBjbGlja2FibGUgPSBmYWxzZTtcbiAgICBzZXRUaW1lb3V0KCgpID0+IHtcbiAgICAgICAgY2xpY2thYmxlID0gdHJ1ZTtcbiAgICB9LCAxMDAwKTtcbn1cblxuLy/miZPlvIDpobXpnaJcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBvcGVuUGFnZShwYWdlLCB0eXBlID0gXCJuYXRpdmVcIiwgcGFyYW1zID0ge30pIHtcbiAgICBhd2FpdCAkbmF0aXZlQVBJLmNvcHlUcmFkaW5nQnJpZGdlKHtcbiAgICAgICAgYWN0aW9uOiBcIm9wZW5QYWdlXCIsXG4gICAgICAgIHR5cGU6IHR5cGUsXG4gICAgICAgIHBhZ2U6IHBhZ2UsXG4gICAgICAgIHBhcmFtczogSlNPTi5zdHJpbmdpZnkocGFyYW1zKSxcbiAgICB9KTtcbn1cblxuLy90b2FzdFxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNob3dUb2FzdChtc2cpIHtcbiAgICBhd2FpdCAkbmF0aXZlQVBJLmhiVG9hc3QobXNnKTtcbn1cblxuLy/kv53lrZjmlbDmja5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzYXZlKG1vZHVsZSwga2V5LCBkYXRhKSB7XG4gICAgYXdhaXQgJG5hdGl2ZUFQSS5zdG9yYWdlKHtcbiAgICAgICAgYWN0aW9uOiBcInNhdmVcIixcbiAgICAgICAgbmFtZTogbW9kdWxlLFxuICAgICAgICBrZXk6IGtleSxcbiAgICAgICAgZGF0YTogSlNPTi5zdHJpbmdpZnkoZGF0YSksXG4gICAgfSk7XG59XG5cbi8v6K+75Y+W5pWw5o2uXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gcmVhZChtb2R1bGUsIGtleSkge1xuICAgIGNvbnN0IGRhdGEgPSBhd2FpdCAkbmF0aXZlQVBJLnN0b3JhZ2Uoe1xuICAgICAgICBhY3Rpb246IFwicmVhZFwiLFxuICAgICAgICBuYW1lOiBtb2R1bGUsXG4gICAgICAgIGtleToga2V5LFxuICAgIH0pO1xuICAgIGlmIChkYXRhICYmIGRhdGEgIT0gXCJcIikge1xuICAgICAgICByZXR1cm4gSlNPTi5wYXJzZShkYXRhKTtcbiAgICB9XG4gICAgcmV0dXJuIG51bGw7XG59XG5cbi8v5riF55CG5pWw5o2uXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gY2xlYXIobW9kdWxlLCBrZXkpIHtcbiAgICBhd2FpdCAkbmF0aXZlQVBJLnN0b3JhZ2Uoe1xuICAgICAgICBhY3Rpb246IFwiY2xlYXJcIixcbiAgICAgICAgbmFtZTogbW9kdWxlLFxuICAgICAgICBrZXk6IGtleSxcbiAgICB9KTtcbn1cblxuLy/muIXnkIblhajpg6jmlbDmja5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBjbGVhckFsbChtb2R1bGUpIHtcbiAgICBhd2FpdCAkbmF0aXZlQVBJLnN0b3JhZ2Uoe1xuICAgICAgICBhY3Rpb246IFwiY2xlYXJcIixcbiAgICAgICAgbmFtZTogbW9kdWxlLFxuICAgIH0pO1xufVxuXG4vL+iuvue9rumAmueUqOmFjee9rlxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNlbmRDb21tb25Db25maWcocGFyYW0pIHtcbiAgICBjb25zb2xlLmxvZyhwYXJhbSk7XG4gICAgY29tbW9uRGF0YS5jb250cmFjdEg1VXJsID0gcGFyYW0uY29udHJhY3RINVVybDtcbiAgICBjb21tb25EYXRhLmN1cnJlbmN5UmF0ZSA9IHBhcmFtLmN1cnJlbmN5UmF0ZTtcbiAgICBjb21tb25EYXRhLmN1cnJlbmN5Q2hhcmFjdGVyID0gcGFyYW0uY3VycmVuY3lDaGFyYWN0ZXI7XG4gICAgY29tbW9uRGF0YS5wcmljZUNvbG9yVHlwZSA9IHBhcnNlSW50KHBhcmFtLnByaWNlQ29sb3JUeXBlKTtcbiAgICBjb21tb25EYXRhLmNvbG9yTW9kZSA9IHBhcnNlSW50KHBhcmFtLmNvbG9yTW9kZSk7XG4gICAgY29tbW9uRGF0YS5PUyA9IHBhcnNlSW50KHBhcmFtLk9TKTtcbiAgICBjb21tb25EYXRhLmFwcFZlcnNpb24gPSBwYXJhbS5hcHBWZXJzaW9uO1xuICAgIGNvbW1vbkRhdGEuaXNJblJldmlldyA9IHBhcnNlSW50KHBhcmFtLmlzSW5SZXZpZXcpO1xuICAgIGNvbW1vbkRhdGEubGFuZ3VhZ2UgPSBwYXJhbS5sYW5ndWFnZTtcbiAgICBjb21tb25EYXRhLndlYlVybCA9IHBhcmFtLndlYlVybDtcbiAgICBpZiAocGFyc2VJbnQocGFyYW0uT1MpID09IDApIHtcbiAgICAgICAgY29tbW9uRGF0YS5ib3R0b21CYXJIZWlnaHQgPSBwYXJzZUludChwYXJhbS5ib3R0b21CYXJIZWlnaHQpO1xuICAgIH1cbiAgICB2YXIgcmVkQ29sb3JMaXN0ID0gW1wiI0FEQjBCMlwiLCBcIiNFOTQzNTlcIiwgXCIjREUyOTQxXCIsIFwiI0NFMTQyQlwiXTtcbiAgICB2YXIgZ3JlZW5Db2xvckxpc3QgPSBbXCIjQURCMEIyXCIsIFwiIzAwQTE3MVwiLCBcIiMwMDhCNjFcIiwgXCIjMDA2MjQ1XCJdO1xuICAgIGlmIChwYXJzZUludChjb21tb25EYXRhLnByaWNlQ29sb3JUeXBlKSA9PSAwKSB7XG4gICAgICAgIHVwQ29sb3JMaXN0ID0gcmVkQ29sb3JMaXN0O1xuICAgICAgICBkb3duQ29sb3JMaXN0ID0gZ3JlZW5Db2xvckxpc3Q7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgdXBDb2xvckxpc3QgPSBncmVlbkNvbG9yTGlzdDtcbiAgICAgICAgZG93bkNvbG9yTGlzdCA9IHJlZENvbG9yTGlzdDtcbiAgICB9XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBnZXRVcERvd25Db2xvcihpc1VwcGVyID0gdHJ1ZSwgbGV2ZWwgPSAxKSB7XG4gICAgY29uc3QgbGV2ID0gbGV2ZWwgPCA0ID8gbGV2ZWwgOiAwO1xuICAgIGlmIChpc1VwcGVyKSB7XG4gICAgICAgIHJldHVybiB1cENvbG9yTGlzdFtsZXZdO1xuICAgIH1cbiAgICByZXR1cm4gZG93bkNvbG9yTGlzdFtsZXZdO1xufVxubGV0IHN5bWJvbERlc2NNYXAgPSB7fVxuZXhwb3J0IGZ1bmN0aW9uIHN5bWJvbERlc2Moc3ltYm9sKSB7XG4gICAgaWYgKCFzeW1ib2xEZXNjTWFwLmhhc093blByb3BlcnR5KHN5bWJvbCkpIHtcbiAgICAgICAgc3ltYm9sRGVzY01hcFtzeW1ib2xdID0gJGkxOG4uJGludGVyY2VwdC5uX2NvbnRyYWN0X3N3YXBfdHJhZGVfbmFtZShzeW1ib2wucmVwbGFjZShcIi1cIiwgXCJcIikpO1xuICAgIH1cbiAgICByZXR1cm4gc3ltYm9sRGVzY01hcFtzeW1ib2xdO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gbW9kdWxlRGVmaW5lKG1vZHVsZU5hbWUsIHN0YXJ0RnVuY3Rpb24sIGRlZmF1bHREYXRhRnVuY3Rpb24pIHtcbiAgICBjb25zb2xlLmxvZyhgbG9hZE1vZHVsZWAsIG1vZHVsZU5hbWUpO1xuICAgICRkYXRhW21vZHVsZU5hbWVdID0gZGVmYXVsdERhdGFGdW5jdGlvbigpO1xuICAgICRldmVudFttb2R1bGVOYW1lXSA9IHsgc3RhcnQ6IHN0YXJ0RnVuY3Rpb24gfTtcbiAgICByZXR1cm4ge1xuICAgICAgICBtb2R1bGVFdmVudDogJGV2ZW50W21vZHVsZU5hbWVdLFxuICAgICAgICBtb2R1bGVEYXRhOiAkZGF0YVttb2R1bGVOYW1lXSxcbiAgICB9O1xufVxuXG5leHBvcnQgZnVuY3Rpb24gTG9nKG1zZywgLi4uYXJncykge1xuICAgIGNvbnNvbGUubG9nKGBbY29weXRyYWRpbmcganMtXSR7bXNnfWAsIGFyZ3MpO1xufVxuXG4vKipcbiAqXG4gKiBAcGFyYW0ge+aXtumXtOaXpeacn+agvOW8j+WMln0gZm10IHl5eXktTU0tZGQgaGg6bW06c3NcbiAqIEByZXR1cm5zIOagvOW8j+WMluS5i+WQjueahCDlrZfnrKbkuLLvvIznlKjms5XkvovlpoIgbmV3IERhdGUo5pe26Ze05oizKS5Gb3JtYXQoXCJ5eXl5LU1NLWRkIGhoOm1tOnNzXCIpXG4gKi9cbkRhdGUucHJvdG90eXBlLkZvcm1hdCA9IGZ1bmN0aW9uIChmbXQpIHtcbiAgICB2YXIgbyA9IHtcbiAgICAgICAgXCJNK1wiOiB0aGlzLmdldE1vbnRoKCkgKyAxLCAvL+aciOS7vVxuICAgICAgICBcImQrXCI6IHRoaXMuZ2V0RGF0ZSgpLCAvL+aXpVxuICAgICAgICBcImgrXCI6IHRoaXMuZ2V0SG91cnMoKSwgLy/lsI/ml7ZcbiAgICAgICAgXCJtK1wiOiB0aGlzLmdldE1pbnV0ZXMoKSwgLy/liIZcbiAgICAgICAgXCJzK1wiOiB0aGlzLmdldFNlY29uZHMoKSwgLy/np5JcbiAgICAgICAgXCJxK1wiOiBNYXRoLmZsb29yKCh0aGlzLmdldE1vbnRoKCkgKyAzKSAvIDMpLCAvL+Wto+W6plxuICAgICAgICBcIlNcIjogdGhpcy5nZXRNaWxsaXNlY29uZHMoKSAvL+avq+enklxuICAgIH07XG4gICAgaWYgKC8oeSspLy50ZXN0KGZtdCkpIGZtdCA9IGZtdC5yZXBsYWNlKFJlZ0V4cC4kMSwgKHRoaXMuZ2V0RnVsbFllYXIoKSArIFwiXCIpLnN1YnN0cig0IC0gUmVnRXhwLiQxLmxlbmd0aCkpO1xuICAgIGZvciAodmFyIGsgaW4gbylcbiAgICAgICAgaWYgKG5ldyBSZWdFeHAoXCIoXCIgKyBrICsgXCIpXCIpLnRlc3QoZm10KSkgZm10ID0gZm10LnJlcGxhY2UoUmVnRXhwLiQxLCAoUmVnRXhwLiQxLmxlbmd0aCA9PSAxKSA/IChvW2tdKSA6ICgoXCIwMFwiICsgb1trXSkuc3Vic3RyKChcIlwiICsgb1trXSkubGVuZ3RoKSkpO1xuICAgIHJldHVybiBmbXQ7XG59XG5cbi8qKlxuICpcbiAqIEBwYXJhbSB7Ym9vbGVhbn0gaXNTaG93IOaYr+WQpuaYvuekuuWKoOi9veahhlxuICovXG5leHBvcnQgZnVuY3Rpb24gc2hvd0xvYWRpbmcoaXNTaG93ID0gdHJ1ZSkge1xuICAgICRuYXRpdmVBUEkuc2hvd0xvYWRpbmcoaXNTaG93ID8gMSA6IDApO1xufVxuXG4vKipcbiAqIOeUn+aIkOWvjOaWh+acrO+8jOagueaNruaMh+WumueahOeJueWumuWtl+espuS4suiuvue9ruS4jeWQjOeahOminOiJsuWSjOWtl+WPt+agt+W8j+OAglxuICogQHBhcmFtIHtzdHJpbmd9IGlucHV0VGV4dCAtIOi+k+WFpeeahOaWh+acrOOAglxuICogQHBhcmFtIHtBcnJheX0gc3BlY2lmaWNTdHJpbmdzIC0g5YyF5ZCr54m55a6a5a2X56ym5Liy5Y+K5YW25qC35byP55qE5a+56LGh5pWw57uE44CCXG4gKiBAcGFyYW0ge09iamVjdH0gW2RlZmF1bHRTdHlsZV0gLSDpu5jorqTnmoTmoLflvI/lr7nosaHvvIzljIXlkKvpu5jorqTnmoTpopzoibLlkozlrZflj7fjgIJcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g5qC85byP5YyW5ZCO55qE5a+M5paH5pys5a2X56ym5Liy44CCXG4gKi9cbmV4cG9ydCBjb25zdCBnZW5lcmF0ZVJpY2hUZXh0ID0gKGlucHV0VGV4dCwgZGVmYXVsdFN0eWxlLCBzcGVjaWZpY1N0cmluZ3MpID0+IHtcbiAgICBpZiAoIWRlZmF1bHRTdHlsZSkgcmV0dXJuIGlucHV0VGV4dDtcblxuICAgIGNvbnN0IGRlZmF1bHRDb2xvciA9IGRlZmF1bHRTdHlsZS5jb2xvciB8fCAnJztcbiAgICBjb25zdCBkZWZhdWx0Rm9udFNpemUgPSBkZWZhdWx0U3R5bGUuZm9udFNpemUgfHwgJyc7XG5cbiAgICBpZiAoIWRlZmF1bHRDb2xvciB8fCAhZGVmYXVsdEZvbnRTaXplKSByZXR1cm4gaW5wdXRUZXh0O1xuXG4gICAgbGV0IHJlc3VsdCA9IHNwZWNpZmljU3RyaW5ncyAmJiBzcGVjaWZpY1N0cmluZ3MubGVuZ3RoID4gMFxuICAgICAgICA/IHNwZWNpZmljU3RyaW5ncy5yZWR1Y2UoXG4gICAgICAgICAgICAoZm9ybWF0dGVkVGV4dCwgeyB0ZXh0LCBjb2xvciA9IGRlZmF1bHRDb2xvciwgZm9udFNpemUgPSBkZWZhdWx0Rm9udFNpemUgfSkgPT5cbiAgICAgICAgICAgICAgICBmb3JtYXR0ZWRUZXh0LnJlcGxhY2UoXG4gICAgICAgICAgICAgICAgICAgIG5ldyBSZWdFeHAodGV4dCwgJ2cnKSxcbiAgICAgICAgICAgICAgICAgICAgYDxzcGFuIHN0eWxlPVwiY29sb3I6ICR7Y29sb3J9OyBmb250LXNpemU6ICR7Zm9udFNpemV9O1wiPiR7dGV4dH08L3NwYW4+YFxuICAgICAgICAgICAgICAgICksXG4gICAgICAgICAgICBgPHNwYW4gc3R5bGU9XCJjb2xvcjogJHtkZWZhdWx0Q29sb3J9OyBmb250LXNpemU6ICR7ZGVmYXVsdEZvbnRTaXplfTtcIj4ke2lucHV0VGV4dH08L3NwYW4+YFxuICAgICAgICApXG4gICAgICAgIDogYDxzcGFuIHN0eWxlPVwiY29sb3I6ICR7ZGVmYXVsdENvbG9yfTsgZm9udC1zaXplOiAke2RlZmF1bHRGb250U2l6ZX07XCI+JHtpbnB1dFRleHR9PC9zcGFuPmA7XG4gICAgY29uc29sZS5sb2coXCJyaWNoIHRleHQ6JW9cIiwgcmVzdWx0KTtcbiAgICByZXR1cm4gcmVzdWx0O1xufTtcblxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc3ViS2V5Ym9yZFNvY2tldChzaG93KSB7XG4gICAgYXdhaXQgJG5hdGl2ZUFQSS5jb3B5VHJhZGluZ0JyaWRnZSh7XG4gICAgICAgIGFjdGlvbjogc2hvdyxcbiAgICAgICAgdHlwZTogXCJ0cmFkZUxpbWl0S2V5Ym9hcmRcIixcbiAgICB9KTtcbn1cblxuLyoqXG4gKlxuICogQHBhcmFtIHtzdHJpbmd9IHN5bWJvbCDluIHlr7nkv6Hmga/vvIxCVEMtVVNEVFxuICogQHJldHVybnMg6L+U5Zue5biB56eN5ZKM5Y2V5L2Ne2NvaW46J0JUQycsdW5pdDonVVNEVCcgfVxuICovXG5leHBvcnQgZnVuY3Rpb24gY29pblVuaXQoc3ltYm9sKSB7XG4gICAgY29pbiA9IFwiXCJcbiAgICB1bml0ID0gXCJcIlxuICAgIGNvbnN0IGNvaW5Vbml0ID0gc3ltYm9sLnNwbGl0KFwiLVwiKTtcbiAgICBpZiAoY29pblVuaXQgJiYgY29pblVuaXQubGVuZ3RoID4gMCkge1xuICAgICAgICBjb2luID0gY29pblVuaXRbMF07XG4gICAgICAgIGlmIChjb2luVW5pdC5sZW5ndGggPiAxKSB7XG4gICAgICAgICAgICB1bml0ID0gY29pblVuaXRbMV07XG4gICAgICAgIH1cbiAgICB9XG4gICAgcmV0dXJuIHsgY29pbiwgdW5pdCB9O1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gY2hlY2tMb2dpbigpIHtcbiAgICByZXR1cm4gYXdhaXQgJG5hdGl2ZUFQSS5jaGVja0xvZ2luKCk7XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBnZXRQTkdJY29uVVJMQnlDdXJyZW5jeShjdXJyZW5jeSkge1xuICAgIGxldCBiYXNlVXJsID0gY29tbW9uRGF0YS53ZWJVcmwgPyBjb21tb25EYXRhLndlYlVybCA6IFwiXCI7XG4gICAgcmV0dXJuIGAke2Jhc2VVcmx9Ly0veC9oYi9wL2FwaS9jb250ZW50cy9jdXJyZW5jeS9pY29uX3BuZy8ke2N1cnJlbmN5LnRvTG93ZXJDYXNlKCl9LnBuZ2A7XG59XG5cbi8qIOmYsuatoumHjeWkjeeCueWHuyAqL1xubGV0IGNsaWNrVGltZXIgPSAwXG5cbmV4cG9ydCBmdW5jdGlvbiBjbGlja1Rocm90dGxlKGludGVydmFsID0gMjAwMCkge1xuICAgIHRyeSB7XG4gICAgICAgIGxldCBub3cgPSBuZXcgRGF0ZSgpLmdldFRpbWUoKTtcbiAgICAgICAgbGV0IHRpbWVyID0gY2xpY2tUaW1lcjtcbiAgICAgICAgY29uc29sZS5sb2coYGNvbW1vbiBjbGlja1Rocm90dGxlIG5vdyA9ICR7bm93fWApXG4gICAgICAgIGNvbnNvbGUubG9nKGBjb21tb24gY2xpY2tUaHJvdHRsZSB0aW1lciA9ICR7dGltZXJ9YClcbiAgICAgICAgaWYgKG5vdyAtIHRpbWVyIDwgaW50ZXJ2YWwpIHtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGBjb21tb24gY2xpY2tUaHJvdHRsZSBkb3VibGUgY2xpY2tgKVxuICAgICAgICAgICAgcmV0dXJuIGZhbHNlO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgY2xpY2tUaW1lciA9IG5vdztcbiAgICAgICAgICAgIHJldHVybiB0cnVlO1xuICAgICAgICB9XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICBjb25zb2xlLmxvZyhgY29tbW9uIGNsaWNrVGhyb3R0bGUgZXJyb3IgPSAke2V9YClcbiAgICB9XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBwYXJzZUJvb2xlYW4oc3RyaW5nKSB7XG4gICAgc3dpdGNoIChTdHJpbmcoc3RyaW5nKS50b0xvd2VyQ2FzZSgpKSB7XG4gICAgICAgIGNhc2UgXCJ0cnVlXCI6XG4gICAgICAgIGNhc2UgXCIxXCI6XG4gICAgICAgIGNhc2UgXCJ5ZXNcIjpcbiAgICAgICAgY2FzZSBcInlcIjpcbiAgICAgICAgICAgIHJldHVybiB0cnVlO1xuICAgICAgICBjYXNlIFwiZmFsc2VcIjpcbiAgICAgICAgY2FzZSBcIjBcIjpcbiAgICAgICAgY2FzZSBcIm5vXCI6XG4gICAgICAgIGNhc2UgXCJuXCI6XG4gICAgICAgICAgICByZXR1cm4gZmFsc2U7XG4gICAgICAgIGRlZmF1bHQ6XG4gICAgICAgICAgICAvL3lvdSBjb3VsZCB0aHJvdyBhbiBlcnJvciwgYnV0ICd1bmRlZmluZWQnIHNlZW1zIGEgbW9yZSBsb2dpY2FsIHJlcGx5XG4gICAgICAgICAgICByZXR1cm4gdW5kZWZpbmVkO1xuICAgIH1cbn1cbmV4cG9ydCBmdW5jdGlvbiBub3ROdWxsKHN0cmluZykge1xuICAgIGlmIChzdHJpbmcgPT0gbnVsbCB8fCBzdHJpbmcgPT0gXCJcIikge1xuICAgICAgICByZXR1cm4gZmFsc2U7XG4gICAgfVxuICAgIHJldHVybiB0cnVlO1xufVxuXG4vL+Wfi+eCuVxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGFuYWx5dGljcyhldmVudCA9IFwiXCIsIHByb3BlcnRpZXMgPSB7fSkge1xuICAgIGNvbnN0IHByb3BlcnRpZXNKc29uID0gSlNPTi5zdHJpbmdpZnkocHJvcGVydGllcyk7XG4gICAgY29uc29sZS5sb2coYGFuYWx5dGljcyBldmVudDogJHtldmVudH0sIHByb3BlcnRpZXNKc29uID0gJHtwcm9wZXJ0aWVzSnNvbn1gKTtcbiAgICB2YXIgbWFwID0ge1xuICAgICAgICBldmVudDogZXZlbnQsXG4gICAgICAgIHByb3BlcnRpZXM6IHByb3BlcnRpZXNKc29uXG4gICAgfTtcbiAgICBhd2FpdCAkbmF0aXZlQVBJLmFuYWx5dGljcyhtYXApO1xufVxuXG4vKipcbiAqIOivpeW4geenjeebuOW6lOaVsOmHj+WvueW6lOeahOazleW4geaKmOWQiFxuICovXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50KGN1cnJlbmN5LCBhbW91bnQpIHtcbiAgICBpZiAoIWFtb3VudCkge1xuICAgICAgICBhbW91bnQgPSAnMCc7XG4gICAgfVxuICAgIGNvbnN0IHBhcmFtID0ge1xuICAgICAgICB0eXBlOiAxLFxuICAgICAgICBjdXJyZW5jeTogY3VycmVuY3ksXG4gICAgICAgIGFtb3VudCxcbiAgICB9O1xuICAgIGNvbnN0IHBhcmFtU3RyaW5nID0gSlNPTi5zdHJpbmdpZnkocGFyYW0pO1xuICAgIHJldHVybiB0aG91c2FuZHNGb3JtYXR0ZXIoYXdhaXQgJG5hdGl2ZUFQSS5jdXJyZW5jeUNvbW1vbihwYXJhbVN0cmluZykgKyBcIlwiKTtcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGdldExlZ2FsQ3VycmVuY3lTeW1ib2woKSB7XG4gICAgY29uc3QgY3VycmVuY3lTeW1ib2wgPSBhd2FpdCAkbmF0aXZlQVBJLmN1cnJlbmN5Q29tbW9uKCd7XCJ0eXBlXCI6OX0nKTtcbiAgICByZXR1cm4gY3VycmVuY3lTeW1ib2w7XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBhZGRDdXJyZW50Q3VycmVuY3lTeW1ib2woc291cmNlKSB7XG4gICAgY29uc3Qgc3ltYm9sID0gYXdhaXQgZ2V0TGVnYWxDdXJyZW5jeVN5bWJvbCgpO1xuICAgIHJldHVybiBhZGRDdXJyZW5jeVN5bWJvbChzeW1ib2wsIHNvdXJjZSk7XG59XG5leHBvcnQgZnVuY3Rpb24gYWRkQ3VycmVuY3lTeW1ib2woY3VycmVuY3lTeW1ib2wsIHNvdXJjZSkge1xuICAgIGlmIChzb3VyY2UgPT09ICctLScpIHtcbiAgICAgICAgcmV0dXJuIHNvdXJjZTtcbiAgICB9XG4gICAgZWxzZSBpZiAoc291cmNlICYmIHNvdXJjZSAhPT0gREVGQVVMVF9TVFIpIHtcbiAgICAgICAgaWYgKHNvdXJjZS5zdGFydHNXaXRoKCctJykpIHtcbiAgICAgICAgICAgIHJldHVybiBgLSR7Y3VycmVuY3lTeW1ib2x9JHtzb3VyY2Uuc3Vic3RyaW5nKDEpfWA7XG4gICAgICAgIH1cbiAgICAgICAgcmV0dXJuIGAke2N1cnJlbmN5U3ltYm9sfSR7c291cmNlfWA7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgcmV0dXJuIGAke2N1cnJlbmN5U3ltYm9sfSR7REVGQVVMVF9TVFJ9YDtcbiAgICB9XG59XG5cbi8qKlxuICog6I635Y+WQWNjb3VudElkXG4gKi9cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRBY2NvdW50SWQoKSB7XG4gICAgY29uc3QgYWNjb3VudHMgPSBhd2FpdCBzZW5kUmVxdWVzdChcInYxL2FjY291bnQvYWNjb3VudHNcIiwge30sIDAsIDQpO1xuICAgIGNvbnNvbGUubG9nKGBtYXJnaW4taG9tZSBnZXRBY2NvdW50SWQgMTExIGFjY291bnRzID0gJHthY2NvdW50c30sIGpzb24gPSAke0pTT04uc3RyaW5naWZ5KGFjY291bnRzKX1gKVxuICAgIGlmIChhY2NvdW50cyA9PSBudWxsIHx8IGFjY291bnRzLmxlbmd0aCA9PSAwKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGBtYXJnaW4taG9tZSBnZXRBY2NvdW50SWQgMjIyYClcbiAgICAgICAgcmV0dXJuXG4gICAgfVxuICAgIGZvciAobGV0IGkgPSAwOyBpIDwgYWNjb3VudHMubGVuZ3RoOyBpKyspIHtcbiAgICAgICAgbGV0IGFjY291bnQgPSBhY2NvdW50c1tpXVxuICAgICAgICBjb25zb2xlLmxvZyhgbWFyZ2luLWhvbWUgZ2V0QWNjb3VudElkIGFjY291bnQgPSAke0pTT04uc3RyaW5naWZ5KGFjY291bnQpfWApXG4gICAgICAgIGlmIChhY2NvdW50LnR5cGUgPT0gXCJzdXBlci1tYXJnaW5cIikge1xuICAgICAgICAgICAgY29tbW9uRGF0YS5zdXBlck1hcmdpbkFjY291bnRJZCA9IGFjY291bnQuaWRcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGBtYXJnaW4taG9tZSBnZXRBY2NvdW50SWQgc3VwZXJNYXJnaW5BY2NvdW50SWQgPSAke2NvbW1vbkRhdGEuc3VwZXJNYXJnaW5BY2NvdW50SWR9YClcbiAgICAgICAgfSBlbHNlIGlmIChhY2NvdW50LnR5cGUgPT0gXCJtYXJnaW5cIikge1xuICAgICAgICAgICAgY29tbW9uRGF0YS5tYXJnaW5BY2NvdW50SWQgPSBhY2NvdW50LmlkXG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgbWFyZ2luLWhvbWUgZ2V0QWNjb3VudElkIG1hcmdpbkFjY291bnRJZCA9ICR7Y29tbW9uRGF0YS5tYXJnaW5BY2NvdW50SWR9YClcbiAgICAgICAgfVxuICAgIH1cbiAgICBjb25zb2xlLmxvZyhgbWFyZ2luLWhvbWUgZ2V0QWNjb3VudElkIGVuZGApXG59XG5cbi8qKlxuICog5Y2D5YiG5L2N5aSE55CGXG4gKi9cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBmb3JtYXRUaG91c2FuZHMobnVtYmVyKSB7XG4gICAgaWYgKG51bWJlciA9PT0gJy0tJykge1xuICAgICAgICByZXR1cm4gbnVtYmVyO1xuICAgIH1cbiAgICBjb25zdCBwYXJhbXMgPSB7XG4gICAgICAgIHR5cGU6IDUzLFxuICAgICAgICBudW1iZXJcbiAgICB9O1xuICAgIHJldHVybiBhd2FpdCAkbmF0aXZlQVBJLmN1cnJlbmN5Q29tbW9uKEpTT04uc3RyaW5naWZ5KHBhcmFtcykpO1xufVxuXG4vKipcbiAqIOWwj+aVsOeyvuW6plxuICogQHBhcmFtIHN0ciDmlbDlrZdcbiAqIEBwYXJhbSBwcmVjaXNpb24g57K+5bqm77yM5L+d55WZ5bCP5pWw5L2N5pWwXG4gKiBAcGFyYW0gbmVlZFRob3VzYW5kcyDmmK/lkKbpnIDopoHljYPliIbkvY3lpITnkIZcbiAqL1xuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGZvcm1hdERlY2ltYWwoc3RyLCBwcmVjaXNpb24sIG5lZWRUaG91c2FuZHMpIHtcbiAgICBpZiAoc3RyLmxlbmd0aCA9PT0gMCB8fCBpc05hTihzdHIpKSB7XG4gICAgICAgIHJldHVybiBcIjBcIjtcbiAgICB9XG4gICAgc3RyICs9IFwiXCJcbiAgICBpZiAoc3RyLmluY2x1ZGVzKFwiLlwiKSkge1xuICAgICAgICB2YXIgZGVjaW1hbCA9IHN0ci5zcGxpdCgnLicpWzFdO1xuICAgICAgICBpZiAoZGVjaW1hbCAmJiBkZWNpbWFsLmxlbmd0aCA+IHByZWNpc2lvbikge1xuICAgICAgICAgICAgc3RyID0gc3RyLnJlcGxhY2UoJy4nICsgZGVjaW1hbCwgJy4nICsgZGVjaW1hbC5zbGljZSgwLCBwcmVjaXNpb24pKTtcbiAgICAgICAgICAgIHJldHVybiBuZWVkVGhvdXNhbmRzID8gYXdhaXQgZm9ybWF0VGhvdXNhbmRzKHN0cikgOiBzdHI7XG4gICAgICAgIH1cbiAgICB9XG4gICAgcmV0dXJuIG5lZWRUaG91c2FuZHMgPyBhd2FpdCBmb3JtYXRUaG91c2FuZHMoc3RyICsgXCJcIikgOiBzdHIgKyBcIlwiO1xufVxuXG4vKipcbiAqIOWNg+WIhuS9jeWkhOeQhlxuICovXG5leHBvcnQgZnVuY3Rpb24gdGhvdXNhbmRzRm9ybWF0dGVyKG51bWJlcikge1xuICAgIC8vIOWFiOWwhuaVsOWtl+i9rOS4uuWtl+espuS4su+8jOW5tuWIpOaWreaYr+WQpuacieWwj+aVsOmDqOWIhlxuICAgIGxldCBbaW50ZWdlclBhcnQsIGRlY2ltYWxQYXJ0XSA9IG51bWJlci50b1N0cmluZygpLnNwbGl0KCcuJyk7XG5cbiAgICAvLyDlr7nmlbTmlbDpg6jliIbmt7vliqDljYPliIbkvY3liIbpmpTnrKZcbiAgICBpbnRlZ2VyUGFydCA9IGludGVnZXJQYXJ0LnJlcGxhY2UoL1xcQig/PShcXGR7M30pKyg/IVxcZCkpL2csICcsJyk7XG5cbiAgICAvLyDlpoLmnpzmnInlsI/mlbDpg6jliIbvvIzliJnmi7zmjqXmlbTmlbDpg6jliIblkozlsI/mlbDpg6jliIZcbiAgICBpZiAoZGVjaW1hbFBhcnQpIHtcbiAgICAgICAgcmV0dXJuIGludGVnZXJQYXJ0ICsgJy4nICsgZGVjaW1hbFBhcnQ7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgcmV0dXJuIGludGVnZXJQYXJ0O1xuICAgIH1cbn1cblxuLy/ml7bpl7TpgInmi6nlmahcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzaG93RGF0ZVBpY2tlcihwYXJhbSkge1xuICAgIGNvbnN0IGRhdGEgPSBhd2FpdCAkbmF0aXZlQVBJLnNob3dEYXRlUGlja2VyKEpTT04uc3RyaW5naWZ5KHBhcmFtKSk7XG4gICAgaWYgKGRhdGEgJiYgZGF0YSAhPSBcIlwiKSB7XG4gICAgICAgIHJldHVybiBkYXRhO1xuICAgIH1cbiAgICByZXR1cm4gbnVsbDtcbn1cblxuLy/luIHnp43nsr7luqZcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRDdXJyZW5jeVNob3dQcmVjaXNpb24ocGFyYW0pIHtcbiAgICBjb25zdCBkYXRhID0gYXdhaXQgJG5hdGl2ZUFQSS5nZXRDdXJyZW5jeVNob3dQcmVjaXNpb24ocGFyYW0pO1xuICAgIGlmIChkYXRhICYmIGRhdGEgIT0gXCJcIikge1xuICAgICAgICByZXR1cm4gcGFyc2VJbnQoZGF0YSk7XG4gICAgfVxuICAgIHJldHVybiA4O1xufVxuXG4vL+iOt+WPlnN5bWJvbOeahGRpc3BsYXlOYW1lXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZ2V0U3ltYm9sRGlzcGxheU5hbWUoc3ltYm9sKSB7XG4gICAgY29uc3QgZGF0YSA9IGF3YWl0ICRuYXRpdmVBUEkuZ2V0U3BvdFN5bWJvbE1vZGVsKHN5bWJvbCk7XG4gICAgY29uc3Qgc3ltYm9sTW9kZWwgPSBKU09OLnBhcnNlKGRhdGEpO1xuICAgIGlmIChzeW1ib2xNb2RlbCAmJiBzeW1ib2xNb2RlbCAhPSBcIlwiKSB7XG4gICAgICAgIHJldHVybiBzeW1ib2xNb2RlbC5zeW1ib2xOYW1lO1xuICAgIH1cbiAgICByZXR1cm4gXCItLVwiO1xufVxuXG4vKipcbiAqIOWtl+espuS4sui9rOaNok51bWJlclxuICogQHBhcmFtIHtvYmplY3R9IG9iaiBcbiAqIEByZXR1cm5zIFxuICovXG5leHBvcnQgZnVuY3Rpb24gdG9OdW1iZXIob2JqKSB7XG4gICAgY29uc3QgbnVtID0gTnVtYmVyKG9iaik7XG4gICAgcmV0dXJuIGlzTmFOKG51bSkgPyAwIDogbnVtO1xufVxuXG5cbi8qKlxuICog6I635Y+W5aSaIOepuiDog4zmma/oibJcbiAqIEBwYXJhbSAgaXNMb25nIC0g5YGa5aSaIHRydWUgIOWBmuepuiBmYWxzZVxuICogQHJldHVybnMge3N0cmluZ30gLSDov5Tlm57popzoibLnmoTnsbvlnotcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIGdldEhhbmRpY2FwQ29sb3IoaXNMb25nID0gdHJ1ZSkge1xuICAgIC8vICAwOiDnuqLmtqjnu7/ot4wsIDE6IOe7v+a2qOe6oui3jFxuICAgIGxldCBjb2xvclR5cGUgPSBjb21tb25EYXRhLnByaWNlQ29sb3JUeXBlO1xuICAgIGlmIChjb2xvclR5cGUgPT0gMCkge1xuICAgICAgICByZXR1cm4gaXNMb25nID8gXCIjMUFFOTQzNTlcIiA6IFwiIzFBMDBBMTcxXCI7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgcmV0dXJuIGlzTG9uZyA/IFwiIzFBMDBBMTcxXCIgOiBcIiMxQUU5NDM1OVwiO1xuICAgIH1cbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGlzSW52YWxpZFN0cmluZyhzdHIpIHtcbiAgICByZXR1cm4gIXN0ciB8fCBzdHIubGVuZ3RoID09PSAwIHx8IHN0ciA9PSBcInVuZGVmaW5lZFwiO1xufVxuIiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gJy4vY29tbW9uJztcblxubGV0IG9uZUNhbGxiYWNrO1xubGV0IGxlZnRDYWxsYmFjaztcbmxldCByaWdodENhbGxiYWNrO1xuXG4vL+WIneWni+WMllxuYXN5bmMgZnVuY3Rpb24gc3RhcnQoKSB7XG59XG5cbi8v5Yid5aeL5YyW5pWw5o2uXG5mdW5jdGlvbiBkZWZhdWx0RGF0YSgpIHtcbiAgICByZXR1cm4ge1xuICAgICAgICB0aXRsZVZpc2liaWxpdHkgOiBcInZpc2libGVcIixcbiAgICAgICAgb25lQnV0dG9uVmlzaWJpbGl0eSA6IFwiZ29uZVwiLFxuICAgICAgICB0d29CdXR0b25WaXNpYmlsaXR5IDogXCJ2aXNpYmxlXCIsXG4gICAgICAgIGNlbnRlckJ1dHRvblRleHQgOiAkaTE4bi5uX2NvcHlfdHJhZGluZ19tZV9rbm93LFxuICAgICAgICBsZWZ0QnV0dG9uVGV4dCA6ICRpMThuLm5fY2FuY2VsLFxuICAgICAgICByaWdodEJ1dHRvblRleHQgOiAkaTE4bi5uX3N1cmUsXG4gICAgICAgIHBvcFRpdGxlIDogJGkxOG4ubl9jb3B5X3RyYWRpbmdfdGlwLFxuICAgICAgICBwb3BDb250ZW50IDogXCItLVwiLFxuICAgICAgICB0b2FzdFR5cGU6IC0xLFxuICAgICAgICBwb3BTaG93OiBmYWxzZVxuICAgIH07XG59XG5cbmNvbnN0IHsgbW9kdWxlRGF0YSwgbW9kdWxlRXZlbnQgfSA9IGNvbW1vbi5tb2R1bGVEZWZpbmUoXCJjb21tb25Qb3BcIiwgc3RhcnQsIGRlZmF1bHREYXRhKTtcblxuXG5leHBvcnQgZnVuY3Rpb24gcG9wVXBDb250ZW50T2ZPbmVCdXR0b24odGl0bGUsIGNvbmV0ZW50LCBjZW50ZXJUZXh0LCB0aXRsZVZpc2liaWxpdHkgPSBcInZpc2libGVcIiwgb25lQnRuQ2FsbEJhY2sgPSBudWxsKSB7XG4gICAgb25lQ2FsbGJhY2sgPSBvbmVCdG5DYWxsQmFjaztcbiAgICBtb2R1bGVEYXRhLm9uZUJ1dHRvblZpc2liaWxpdHkgPSBcInZpc2libGVcIjtcbiAgICBtb2R1bGVEYXRhLnR3b0J1dHRvblZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICBtb2R1bGVEYXRhLnRpdGxlVmlzaWJpbGl0eSA9IHRpdGxlVmlzaWJpbGl0eTtcbiAgICBpZiAodGl0bGUgJiYgdGl0bGUgIT09IG51bGwpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5wb3BUaXRsZSA9IHRpdGxlO1xuICAgIH1cbiAgICBpZiAoY29uZXRlbnQgJiYgY29uZXRlbnQgIT09IG51bGwpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5wb3BDb250ZW50ID0gY29uZXRlbnQ7XG4gICAgfVxuICAgIGlmIChjZW50ZXJUZXh0ICYmIGNlbnRlclRleHQgIT09IG51bGwpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5jZW50ZXJCdXR0b25UZXh0ID0gY2VudGVyVGV4dDtcbiAgICB9XG4gICAgaWYoIW1vZHVsZURhdGEucG9wU2hvdykge1xuICAgICAgICBtb2R1bGVEYXRhLnBvcFNob3cgPSB0cnVlO1xuICAgIH0gIFxufVxuXG5leHBvcnQgZnVuY3Rpb24gcG9wVXBDb250ZW50T2ZUd29CdXR0b24odHlwZSwgdGl0bGUsIGNvbnRlbnQsIGxlZnRUZXh0LCByaWdodFRleHQsIHRpdGxlVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiLCBsZWZ0QnRuQ2FsbGJhY2sgPSBudWxsLCByaWdodEJ0bkNhbGxiYWNrKSB7XG4gICAgbGVmdENhbGxiYWNrID0gbGVmdEJ0bkNhbGxiYWNrO1xuICAgIHJpZ2h0Q2FsbGJhY2sgPSByaWdodEJ0bkNhbGxiYWNrO1xuICAgIG1vZHVsZURhdGEub25lQnV0dG9uVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgIG1vZHVsZURhdGEudHdvQnV0dG9uVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuICAgIG1vZHVsZURhdGEudGl0bGVWaXNpYmlsaXR5ID0gdGl0bGVWaXNpYmlsaXR5O1xuICAgIGlmICh0aXRsZSAmJiB0aXRsZSAhPT0gbnVsbCkge1xuICAgICAgICBtb2R1bGVEYXRhLnBvcFRpdGxlID0gdGl0bGU7XG4gICAgfVxuICAgIGlmIChjb250ZW50ICYmIGNvbnRlbnQgIT09IG51bGwpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5wb3BDb250ZW50ID0gY29udGVudDtcbiAgICB9XG4gICAgaWYgKGxlZnRUZXh0ICYmIGxlZnRUZXh0ICE9PSBudWxsKSB7XG4gICAgICAgIG1vZHVsZURhdGEubGVmdEJ1dHRvblRleHQgPSBsZWZ0VGV4dDtcbiAgICB9XG4gICAgaWYgKHJpZ2h0VGV4dCAmJiByaWdodFRleHQgIT09IG51bGwpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5yaWdodEJ1dHRvblRleHQgPSByaWdodFRleHQ7XG4gICAgfVxuICAgIG1vZHVsZURhdGEudG9hc3RUeXBlID0gdHlwZTtcbiAgICBpZighbW9kdWxlRGF0YS5wb3BTaG93KSB7XG4gICAgICAgIG1vZHVsZURhdGEucG9wU2hvdyA9IHRydWU7XG4gICAgfVxufVxuXG5tb2R1bGVFdmVudC5wb3BEaXNtaXNzID0gZnVuY3Rpb24gKCkge1xuICAgIG1vZHVsZURhdGEucG9wU2hvdyA9IGZhbHNlO1xufVxuXG5tb2R1bGVFdmVudC5idG5DbGljayA9IGZ1bmN0aW9uICh0eXBlKSB7XG4gICAgbW9kdWxlRGF0YS5wb3BTaG93ID0gZmFsc2U7XG4gICAgaWYgKHR5cGUgPT0gMCAmJiBvbmVDYWxsYmFjayAhPSBudWxsKSB7XG4gICAgICAgIG9uZUNhbGxiYWNrKCk7XG4gICAgfSBlbHNlIGlmICh0eXBlID09IDEgJiYgbGVmdENhbGxiYWNrICE9IG51bGwpIHtcbiAgICAgICAgbGVmdENhbGxiYWNrKClcbiAgICB9IGVsc2UgaWYgKHR5cGUgPT0gMiAmJiByaWdodENhbGxiYWNrICE9IG51bGwpIHtcbiAgICAgICAgcmlnaHRDYWxsYmFjaygpXG4gICAgfVxufVxuIiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiO1xuaW1wb3J0ICogYXMgY29tbW9uUG9wIGZyb20gXCIuL2NvbW1vblBvcFwiO1xuXG5mdW5jdGlvbiBkZWZhdWx0RGF0YSgpIHtcbiAgICByZXR1cm4ge307XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHN0YXJ0KCkge1xufVxuXG5jb25zdCB7IG1vZHVsZURhdGEsIG1vZHVsZUV2ZW50IH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFwicG9zaXRpb25cIiwgc3RhcnQsIGRlZmF1bHREYXRhKTtcblxuLyoqXG4gKiDmmL7npLog5rS75Yqo6KeE5YiZIOW8ueahhlxuICovXG5hc3luYyBmdW5jdGlvbiBzaG93QWN0aXZpdHlSdWxlRGlhbG9nKCkge1xuICAgIGF3YWl0IGNvbW1vbi5hbmFseXRpY3MoXCJhcHBjbGlja19jb250cmFjdHNcIiwge1xuICAgICAgICBidXNpbmVzc19jYXRlZ29yeTogXCJ1c2R0XzBfeXVhbl9idXlcIixcbiAgICAgICAgYnV0dG9uX25hbWU6IFwidXNkdF9hc3Npc3RhbmNlXzBfeXVhblwiLFxuICAgIH0pO1xuICAgIGxldCBydWxlcyA9ICRpMThuLm5femVyb19zd2FwX2FjdGl2aXR5X3J1bGVfY29udGVudF8xICsgXCJcXG5cIlxuICAgICAgICArICRpMThuLm5femVyb19zd2FwX2FjdGl2aXR5X3J1bGVfY29udGVudF8yICsgXCJcXG5cIlxuICAgICAgICArICRpMThuLm5femVyb19zd2FwX2FjdGl2aXR5X3J1bGVfY29udGVudF8zICsgXCJcXG5cIlxuICAgICAgICArICRpMThuLm5femVyb19zd2FwX2FjdGl2aXR5X3J1bGVfY29udGVudF80ICsgXCJcXG5cIlxuICAgICAgICArICRpMThuLm5femVyb19zd2FwX2FjdGl2aXR5X3J1bGVfY29udGVudF81O1xuICAgIGNvbW1vblBvcC5wb3BVcENvbnRlbnRPZk9uZUJ1dHRvbigkaTE4bi5uX3plcm9fc3dhcF9hY3Rpdml0eV9ydWxlX3RpdGxlLCBydWxlcywgJGkxOG4ubl9jb3B5X3RyYWRpbmdfbWVfa25vdywgXCJ2aXNpYmxlXCIsIG51bGwpO1xufVxuXG5tb2R1bGVFdmVudC5zaG93QWN0aXZpdHlSdWxlRGlhbG9nID0gc2hvd0FjdGl2aXR5UnVsZURpYWxvZyIsImltcG9ydCAqIGFzIGNvbW1vbiBmcm9tIFwiLi9jb21tb25cIjtcblxuZnVuY3Rpb24gZGVmYXVsdERhdGEoKSB7XG4gICAgcmV0dXJuIHtcbiAgICAgICAgLy8gIEJhbm5lcuW9k+WJjee0ouW8lVxuICAgICAgICBiYW5uZXJDdXJyZW50SW5kZXg6IFwiMFwiLFxuICAgICAgICAvLyAgQmFubmVy5pWw5o2uXG4gICAgICAgIGJhbm5lckxpc3Q6IFtdLFxuICAgICAgICAvLyAgQmFubmVy5piv5ZCm5Y+v6KeBXG4gICAgICAgIGJhbm5lclZpc2liaWxpdHk6IFwiZ29uZVwiLFxuICAgICAgICAvLyAgQmFubmVyIEFuZHJvaWQgQm9yZGVyXG4gICAgICAgIGJhbm5lckFuZHJvaWRTdHJva2VWaXNpYmlsaXR5OiBjb21tb24uY29tbW9uRGF0YS5PUyA9PSAxID8gXCJ2aXNpYmxlXCIgOiBcImdvbmVcIixcbiAgICAgICAgLy8gIOW5v+WRiuWIl+ihqOaMh+ekuuWZqFxuICAgICAgICBiYW5uZXJJbmRpY2F0b3JMaXN0OiBbXSxcbiAgICAgICAgLy8gIOW5v+WRiuWIl+ihqOaMh+ekuuWZqOaYr+WQpuWPr+ingVxuICAgICAgICBiYW5uZXJJbmRpY2F0b3JWaXNpYmlsaXR5OiAnZ29uZScsXG4gICAgICAgIC8vICBCYW5uZXLmmK/lkKboh6rliqjmu5rliqhcbiAgICAgICAgYmFubmVyQXV0b1Njcm9sbDogXCJ0cnVlXCIsXG4gICAgICAgIC8vICDmiJHnmoTmlLbnm4pcbiAgICAgICAgcG5sOiBcIi0tXCIsXG4gICAgICAgIC8vICDlnKjpgJTlpZblirHmmK/lkKblj6/op4FcbiAgICAgICAgYWN0aXZpdHlQbmxWaXNpYmlsaXR5OiBcImdvbmVcIixcbiAgICAgICAgLy8gIOWcqOmAlOWlluWKseaWh+ahiFxuICAgICAgICBhY3Rpdml0eVBubDogJGkxOG4uJGludGVyY2VwdC5uX3plcm9fc3dhcF9yZWNoYXJnZV9wcm9maXQoXCItXCIpLFxuICAgICAgICAvLyAg5Zyo6YCU5aWW5Yqx5YCS6K6h5pe2XG4gICAgICAgIGFjdGl2aXR5Q291bnREb3duVGltZTogXCItLVwiICsgJGkxOG4ubl9kYXkgKyBcIiBcIiArIFwiLS0gOiAtLSA6IC0tXCIsXG4gICAgICAgIHRhYkluZm86IGB7XCJ0YWJzXCI6W3tcInRpdGxlXCI6XCIkeyRpMThuLm5femVyb19zd2FwX215X3Bvc2l0aW9ufVwiLFwidGVtcGxhdGVcIjpcIm9wZW5Qb3NpdGlvblwiLFwibW9kdWxlXCI6XCJvcGVuUG9zaXRpb25cIixcIm9uQXBwZWFyXCI6XCJvcGVuUG9zaXRpb24ub25BcHBlYXJcIn0se1widGl0bGVcIjpcIiR7JGkxOG4ubl9leGNoYW5nZV9vcmRlcl9oaXN0b3J5X29yZGVyc31cIixcInRlbXBsYXRlXCI6XCJoaXN0b3J5UG9zaXRpb25cIixcIm1vZHVsZVwiOlwiaGlzdG9yeVBvc2l0aW9uXCIsXCJvbkFwcGVhclwiOlwiaGlzdG9yeVBvc2l0aW9uLm9uQXBwZWFyXCJ9XX1gXG4gICAgfTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gc3RhcnQoKSB7XG5cbn1cblxuY29uc3QgeyBtb2R1bGVEYXRhLCBtb2R1bGVFdmVudCB9ID0gY29tbW9uLm1vZHVsZURlZmluZShcImhlYWRlclByb2ZpdFwiLCBzdGFydCwgZGVmYXVsdERhdGEpO1xuXG4vKipcbiAqIOWumuaXtuWZqFxuICovXG5sZXQgdGltZXI7XG5cbi8qKlxuICog5Yid5aeL5YCS6K6h5pe25pe26Ze0XG4gKi9cbmxldCByZW1haW5pbmdTZWNvbmRzID0gMDtcblxuLyoqXG4gKiDlvIDlp4vlgJLorqHml7ZcbiAqL1xuZnVuY3Rpb24gc3RhcnRDb3VudGRvd24oKSB7XG4gICAgY2FuY2VsQ291bnRkb3duKCk7XG4gICAgdGltZXIgPSBzZXRJbnRlcnZhbCgoKSA9PiB7XG4gICAgICAgIGlmIChyZW1haW5pbmdTZWNvbmRzID49IDApIHtcbiAgICAgICAgICAgIGxldCBkYXlzID0gTWF0aC5mbG9vcihyZW1haW5pbmdTZWNvbmRzIC8gKDI0ICogNjAgKiA2MCkpO1xuICAgICAgICAgICAgbGV0IGhvdXJzID0gTWF0aC5mbG9vcigocmVtYWluaW5nU2Vjb25kcyAlICgyNCAqIDYwICogNjApKSAvICg2MCAqIDYwKSk7XG4gICAgICAgICAgICBsZXQgbWludXRlcyA9IE1hdGguZmxvb3IoKHJlbWFpbmluZ1NlY29uZHMgJSAoNjAgKiA2MCkpIC8gNjApO1xuICAgICAgICAgICAgbGV0IHNlY29uZHMgPSByZW1haW5pbmdTZWNvbmRzICUgNjA7XG4gICAgICAgICAgICBkYXlzID0gZGF5cyA8IDEwID8gJzAnICsgZGF5cyA6IGRheXM7XG4gICAgICAgICAgICBob3VycyA9IGhvdXJzIDwgMTAgPyAnMCcgKyBob3VycyA6IGhvdXJzO1xuICAgICAgICAgICAgbWludXRlcyA9IG1pbnV0ZXMgPCAxMCA/ICcwJyArIG1pbnV0ZXMgOiBtaW51dGVzO1xuICAgICAgICAgICAgc2Vjb25kcyA9IHNlY29uZHMgPCAxMCA/ICcwJyArIHNlY29uZHMgOiBzZWNvbmRzO1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5hY3Rpdml0eUNvdW50RG93blRpbWUgPSBgJHtkYXlzLnRvU3RyaW5nKCl9ICR7JGkxOG4ubl9kYXl9ICR7aG91cnMudG9TdHJpbmcoKX0gOiAke21pbnV0ZXMudG9TdHJpbmcoKX0gOiAke3NlY29uZHMudG9TdHJpbmcoKX1gO1xuICAgICAgICAgICAgcmVtYWluaW5nU2Vjb25kcy0tO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgY2FuY2VsQ291bnRkb3duKCk7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLmFjdGl2aXR5UG5sVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgY29uc29sZS5sb2coJ+WAkuiuoeaXtue7k+adnycpO1xuICAgICAgICB9XG4gICAgfSwgMTAwMCk7XG59XG5cbi8qKlxuICog5Y+W5raI5YCS6K6h5pe2XG4gKi9cbmZ1bmN0aW9uIGNhbmNlbENvdW50ZG93bigpIHtcbiAgICBpZiAodGltZXIgIT0gbnVsbCkge1xuICAgICAgICBjbGVhckludGVydmFsKHRpbWVyKTtcbiAgICAgICAgdGltZXIgPSBudWxsO1xuICAgICAgICBjb25zb2xlLmxvZygn5YCS6K6h5pe25bey5Y+W5raIJyk7XG4gICAgfVxufVxuXG4vKipcbiAqIOaIkeeahOW5s+S7k+aUtuebilxuICovXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0SGVhZGVyUHJvZml0KCkge1xuICAgIGNvbnN0IGRhdGEgPSBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3QoXCJ2MS9hY3Rpdml0eS96ZXJvL3Bhcml0eS9wcm9maXRcIiwge30sIDAsIDAsIHsgXCJDb250ZW50LVR5cGVcIjogXCJhcHBsaWNhdGlvbi9qc29uXCIgfSlcbiAgICBtb2R1bGVEYXRhLnBubCA9IGRhdGEudG90YWxQcm9maXQ7XG4gICAgY2FuY2VsQ291bnRkb3duKCk7XG4gICAgaWYgKGRhdGEucG9zaXRpb25Qcm9maXQgPT0gbnVsbCkge1xuICAgICAgICBtb2R1bGVEYXRhLmFjdGl2aXR5UG5sVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIC8vICAxLeW3suaJk+asvlxuICAgICAgICBsZXQgZ29sZFN0YXR1cyA9IGNvbW1vbi50b051bWJlcihkYXRhLmdvbGRTdGF0dXMpO1xuICAgICAgICByZW1haW5pbmdTZWNvbmRzID0gTWF0aC5mbG9vcigoY29tbW9uLnRvTnVtYmVyKGRhdGEuZ29sZEV4cGlyZVRpbWUpKSAvIDEwMDApO1xuICAgICAgICBpZiAocmVtYWluaW5nU2Vjb25kcyA+IDApIHtcbiAgICAgICAgICAgIGlmICgxID09IGdvbGRTdGF0dXMpIHtcbiAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLmFjdGl2aXR5UG5sVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICBsZXQgcG9zaXRpb25Qcm9maXQgPSBjb21tb24udG9OdW1iZXIoZGF0YS5wb3NpdGlvblByb2ZpdCk7XG4gICAgICAgICAgICAgICAgaWYgKHBvc2l0aW9uUHJvZml0ID4gMCkge1xuICAgICAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLmFjdGl2aXR5UG5sID0gJGkxOG4uJGludGVyY2VwdC5uX3plcm9fc3dhcF9yZWNoYXJnZV9wcm9maXQocG9zaXRpb25Qcm9maXQudG9TdHJpbmcoKSk7XG4gICAgICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICAgICAgbW9kdWxlRGF0YS5hY3Rpdml0eVBubCA9ICRpMThuLm5femVyb19zd2FwX3JlY2hhcmdlX3Jld2FyZDtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgc3RhcnRDb3VudGRvd24oKTtcbiAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLmFjdGl2aXR5UG5sVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgICAgfVxuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5hY3Rpdml0eVBubFZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICAgICAgfVxuICAgIH1cbn1cblxuLyoqXG4gKiDpobXpnaLlj6/op4FcbiAqL1xuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGFwcGVhcigpIHtcbiAgICByZXF1ZXN0QmFubmVySW5mbygpO1xuICAgIGF3YWl0IHJlcXVlc3RIZWFkZXJQcm9maXQoKTtcbn1cblxuXG4vKipcbiAqIOmhtemdouS4jeWPr+ingVxuICovXG5leHBvcnQgZnVuY3Rpb24gZGlzYXBwZWFyKCkge1xuICAgIGNhbmNlbENvdW50ZG93bigpO1xufVxuXG4vKipcbiAqIEJhbm5lcumAieS4reebkeWQrFxuICogQHBhcmFtIHtudW1iZXJ9IGluZGV4IFxuICovXG5tb2R1bGVFdmVudC5zZWxlY3RlZEJhbm5lckluZGV4ID0gYXN5bmMgZnVuY3Rpb24gKGluZGV4KSB7XG4gICAgbW9kdWxlRGF0YS5iYW5uZXJDdXJyZW50SW5kZXggPSBTdHJpbmcoaW5kZXgpO1xuICAgIGhhbmRsZVNsaWRlckluZGljYXRvclZpZXcoKTtcbn1cblxuLyoqXG4gKiBCYW5uZXIg54K55Ye75LqL5Lu2XG4gKiBAcmV0dXJucyBcbiAqL1xubW9kdWxlRXZlbnQuYmFubmVyQ2xpY2tCYW5uZXIgPSBhc3luYyBmdW5jdGlvbiAoKSB7XG4gICAgdmFyIGluZGV4ID0gcGFyc2VJbnQobW9kdWxlRGF0YS5iYW5uZXJDdXJyZW50SW5kZXgpO1xuICAgIGlmIChpbmRleCA+PSBtb2R1bGVEYXRhLmJhbm5lckxpc3QubGVuZ3RoKSB7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgdmFyIG9iaiA9IG1vZHVsZURhdGEuYmFubmVyTGlzdFtpbmRleF07XG4gICAgaWYgKCFjb21tb24uaXNJbnZhbGlkU3RyaW5nKG9iai5qdW1wVG8pKSB7XG4gICAgICAgIGNvbW1vbi5vcGVuVVJMKG9iai5qdW1wVG8pO1xuICAgICAgICBhd2FpdCBjb21tb24uYW5hbHl0aWNzKFwiYXBwY2xpY2tfY29udHJhY3RzXCIsIHtcbiAgICAgICAgICAgIGJ1c2luZXNzX2NhdGVnb3J5OiBcInRvcF9hZF90cmFkZVwiLFxuICAgICAgICAgICAgYnV0dG9uX25hbWU6IFwidG9wX2FkX3RyYWRlX2dvXCIsXG4gICAgICAgICAgICBiYW5uZXJfaWQ6IFN0cmluZyhvYmouYWR2SWQpLFxuICAgICAgICAgICAgYmFubmVyX25hbWU6IG9iai50aXRsZSxcbiAgICAgICAgfSk7XG4gICAgfVxufVxuXG4vKipcbiAqIOivt+axgkJhbm5lclxuICovXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0QmFubmVySW5mbygpIHtcbiAgICB2YXIgcGFyYW1zID0ge1xuICAgICAgICBwYWdlVHlwZTogNzMsXG4gICAgICAgIHNob3dUeXBlOiA5LFxuICAgIH07XG4gICAgbGV0IGRhdGEgPSBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3QoXCJ2MS9jb25maWcvcHVzaC9iYW5uZXIvbGlzdFwiLCBwYXJhbXMpO1xuICAgIGlmIChkYXRhICYmIGRhdGEgIT0gbnVsbCAmJiBkYXRhLmJhbm5lckFkdkxpc3QgIT0gbnVsbCB8fCBkYXRhLmJhbm5lckFkdkxpc3QubGVuZ3RoID4gMCkge1xuICAgICAgICBmb3IgKGxldCBpID0gMDsgaSA8IGRhdGEuYmFubmVyQWR2TGlzdC5sZW5ndGg7ICsraSkge1xuICAgICAgICAgICAgbGV0IHYgPSBkYXRhLmJhbm5lckFkdkxpc3RbaV07XG4gICAgICAgICAgICB2LmluZGV4ID0gaTtcbiAgICAgICAgICAgIHYudHlwZSA9IFwiMVwiO1xuICAgICAgICAgICAgdi5jdXJyZW50SW1hZ2VVUkwgPSBjb21tb24uY29tbW9uRGF0YS5jb2xvck1vZGUgPT09IDEgPyB2Lm5pZ2h0SW1hZ2VVcmwgOiB2LmltYWdlVXJsO1xuICAgICAgICB9O1xuICAgICAgICBoYW5kbGVTbGlkZXJWaWV3KGRhdGEuYmFubmVyQWR2TGlzdCk7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgaGFuZGxlU2xpZGVyVmlldyhbXSk7XG4gICAgfVxufVxuXG4vKipcbiAqIOWkhOeQhui9ruaSreinhuWbvlxuICogQHBhcmFtIHtBcnJheX0gbGlzdCBcbiAqL1xuYXN5bmMgZnVuY3Rpb24gaGFuZGxlU2xpZGVyVmlldyhsaXN0KSB7XG4gICAgbW9kdWxlRGF0YS5iYW5uZXJMaXN0ID0gbGlzdDtcbiAgICBtb2R1bGVEYXRhLmJhbm5lclZpc2liaWxpdHkgPSBsaXN0Lmxlbmd0aCA+IDAgPyAndmlzaWJsZScgOiAnZ29uZSc7XG4gICAgbW9kdWxlRGF0YS5iYW5uZXJBbmRyb2lkU3Ryb2tlVmlzaWJpbGl0eSA9IGNvbW1vbi5jb21tb25EYXRhLk9TID09IDEgPyAobGlzdC5sZW5ndGggPiAwID8gJ3Zpc2libGUnIDogJ2dvbmUnKSA6IFwiZ29uZVwiO1xuICAgIGhhbmRsZVNsaWRlckluZGljYXRvclZpZXcoKTtcbiAgICBpZiAobGlzdC5sZW5ndGggPiAwKSB7XG4gICAgICAgIGF3YWl0IGNvbW1vbi5hbmFseXRpY3MoXCJwYWdldmlld19jb250cmFjdHNcIiwge1xuICAgICAgICAgICAgYnVzaW5lc3NfY2F0ZWdvcnk6IFwidG9wX2FkX3RyYWRlXCJcbiAgICAgICAgfSk7XG4gICAgfVxufVxuXG4vKipcbiAqIOWkhOeQhui9ruaSreaMh+ekuuWZqOinhuWbvlxuICovXG5mdW5jdGlvbiBoYW5kbGVTbGlkZXJJbmRpY2F0b3JWaWV3KCkge1xuICAgIGxldCBpbmRpY2F0b3JMaXN0ID0gW107XG4gICAgZm9yIChsZXQgaW5kZXggPSAwOyBpbmRleCA8IG1vZHVsZURhdGEuYmFubmVyTGlzdC5sZW5ndGg7IGluZGV4KyspIHtcbiAgICAgICAgaWYgKG1vZHVsZURhdGEuYmFubmVyQ3VycmVudEluZGV4ID09IFN0cmluZyhpbmRleCkpIHtcbiAgICAgICAgICAgIGluZGljYXRvckxpc3QucHVzaCh7ICd0eXBlJzogJzEnIH0pO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgaW5kaWNhdG9yTGlzdC5wdXNoKHsgJ3R5cGUnOiAnMicgfSk7XG4gICAgICAgIH1cbiAgICB9XG4gICAgbW9kdWxlRGF0YS5iYW5uZXJJbmRpY2F0b3JMaXN0ID0gaW5kaWNhdG9yTGlzdDtcbiAgICBtb2R1bGVEYXRhLmJhbm5lckluZGljYXRvclZpc2liaWxpdHkgPSBpbmRpY2F0b3JMaXN0Lmxlbmd0aCA+IDEgPyAndmlzaWJsZScgOiAnZ29uZSc7XG59IiwiaW1wb3J0ICogYXMgbnVtYmVyIGZyb20gXCIuL251bWJlclwiO1xuaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiO1xuXG4vKipcbiAqIOaUtuebiuminSDlpJrvvJooIOacgOaWsOS7tyAtIOW8gOS7k+S7tyApICog5oyB5LuT5pWw6YePIOepuu+8migg5byA5LuT5Lu3IC0g5pyA5paw5Lu3ICkgKiDmjIHku5PmlbDph49cbiAqIEBwYXJhbSB7U3RyaW5nfSBvcGVuUHJpY2UgIOW8gOS7k+S7t1xuICogQHBhcmFtIHtTdHJpbmd9IGxhdGVzdFByaWNlIOebmOWPo+acgOaWsOS7t1xuICogQHBhcmFtIHtOdW1iZXJ9IGFtb3VudCDmjIHku5PmlbDph49cbiAqIEBwYXJhbSB7c3RyaW5nfSBkaXJlY3Rpb24gMSDlvIDlpJogIDIg5byA56m6XG4gKiBAcmV0dXJucyBTdHJpbmdcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIGdldFByb2ZpdChvcGVuUHJpY2UsIGxhdGVzdFByaWNlLCBhbW91bnQsIGRpcmVjdGlvbikge1xuICAgIGlmIChvcGVuUHJpY2UgPT0gJycgfHwgbGF0ZXN0UHJpY2UgPT0gJycgfHwgYW1vdW50ID09ICcnKSB7XG4gICAgICAgIHJldHVybiAnJztcbiAgICB9XG4gICAgbGV0IGRlbHRhID0gJyc7XG4gICAgaWYgKGRpcmVjdGlvbiA9PSAxKSB7XG4gICAgICAgIGRlbHRhID0gbnVtYmVyLnN1YnRyYWN0KGxhdGVzdFByaWNlLCBvcGVuUHJpY2UpO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIGRlbHRhID0gbnVtYmVyLnN1YnRyYWN0KG9wZW5QcmljZSwgbGF0ZXN0UHJpY2UpO1xuICAgIH1cbiAgICBsZXQgcHJvZml0ID0gY29tbW9uLmZvcm1hdFByZWNpc2lvbihudW1iZXIubXVsdGlwbHkoZGVsdGEsIGFtb3VudCksIDQpO1xuICAgIHJldHVybiBwcm9maXQ7XG59XG5cbi8qKlxuICog5pS255uK546HIOWkmu+8migg5pyA5paw5Lu3IC0g5byA5LuT5Lu3ICkgLyDlvIDku5Pku7cgKiDmnaDmnYYgKiAxMDAlIOepuu+8migg5byA5LuT5Lu3IC0g5pyA5paw5Lu3ICkgLyDlvIDku5Pku7cgKiDmnaDmnYYgKiAxMDAlXG4gKiBAcGFyYW0ge1N0cmluZ30gb3BlblByaWNlICDlvIDku5Pku7dcbiAqIEBwYXJhbSB7U3RyaW5nfSBsYXRlc3RQcmljZSDnm5jlj6PmnIDmlrDku7dcbiAqIEBwYXJhbSB7TnVtYmVyfSBhbW91bnQg5oyB5LuT5pWw6YePXG4gKiBAcGFyYW0ge3N0cmluZ30gZGlyZWN0aW9uIDEg5byA5aSaICAyIOW8gOepulxuICogQHBhcmFtIHtOdW1iZXJ9IGxldmVyUmF0ZSDmnaDmnYblgI3mlbBcbiAqIEByZXR1cm5zIFN0cmluZ1xuICovXG5leHBvcnQgZnVuY3Rpb24gZ2V0UHJvZml0UmF0ZShvcGVuUHJpY2UsIGxhdGVzdFByaWNlLCBhbW91bnQsIGRpcmVjdGlvbiwgbGV2ZXJSYXRlKSB7XG4gICAgaWYgKG9wZW5QcmljZSA9PSAnJyB8fCBsYXRlc3RQcmljZSA9PSAnJyB8fCBhbW91bnQgPT0gJycgfHwgbGV2ZXJSYXRlID09ICcnKSB7XG4gICAgICAgIHJldHVybiAnJztcbiAgICB9XG4gICAgbGV0IGRlbHRhID0gJyc7XG4gICAgaWYgKGRpcmVjdGlvbiA9PSAxKSB7XG4gICAgICAgIGRlbHRhID0gbnVtYmVyLnN1YnRyYWN0KGxhdGVzdFByaWNlLCBvcGVuUHJpY2UpO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIGRlbHRhID0gbnVtYmVyLnN1YnRyYWN0KG9wZW5QcmljZSwgbGF0ZXN0UHJpY2UpO1xuICAgIH1cbiAgICBsZXQgcmF0aW8gPSBudW1iZXIubXVsdGlwbHkobnVtYmVyLmRpdmlkZShkZWx0YSwgb3BlblByaWNlKSwgbGV2ZXJSYXRlKTtcbiAgICBsZXQgcHJvZml0UmF0ZSA9IG51bWJlci5tdWx0aXBseShyYXRpbywgMTAwKTtcbiAgICBsZXQgcHJvZml0UmF0ZVN0ciA9IGNvbW1vbi5mb3JtYXRQcmVjaXNpb24ocHJvZml0UmF0ZSwgMik7XG4gICAgcmV0dXJuIHByb2ZpdFJhdGVTdHI7XG59XG5cbi8qKlxuICog5LuT5L2N5Lu35YC8PeW8oOaVsCrlkIjnuqbpnaLlgLwq5pyA5paw5Lu35qC8XG4gKiBAcGFyYW0ge051bWJlcn0gYW1vdW50IOaMgeS7k+aVsOmHj1xuICogQHBhcmFtIHtOdW1iZXJ9IGxhdGVzdFByaWNlIOacgOaWsOS7t+agvFxuICogQHJldHVybnMgU3RyaW5nXG4gKi9cbmV4cG9ydCBmdW5jdGlvbiBnZXRQb3NpdGlvblZhbHVlKGFtb3VudCwgbGF0ZXN0UHJpY2UpIHtcbiAgICBpZiAoYW1vdW50ID09ICcnIHx8IGxhdGVzdFByaWNlID09ICcnKSB7XG4gICAgICAgIHJldHVybiAnJztcbiAgICB9XG4gICAgcmV0dXJuIG51bWJlci5tdWx0aXBseShhbW91bnQsIGxhdGVzdFByaWNlKTtcbn1cblxuLyoqXG4gKiDlpJrku5PmnKrlrp7njrDnm4jkuo8977yI5bmz5LuT5Z2H5Lu3Leagh+iusOS7t+agvO+8iSrlvKDmlbAq5ZCI57qm6Z2i5YC8XG4gKiDnqbrku5PmnKrlrp7njrDnm4jkuo8977yI5byA5LuT5Z2H5Lu3Leagh+iusOS7t+agvO+8iSrlvKDmlbAq5ZCI57qm6Z2i5YC8XG4gKiBAcGFyYW0ge1N0cmluZ30gb3BlblByaWNlICDlvIDku5Pku7dcbiAqIEBwYXJhbSB7U3RyaW5nfSBsYXRlc3RQcmljZSDnm5jlj6PmnIDmlrDku7dcbiAqIEBwYXJhbSB7TnVtYmVyfSBhbW91bnQg5oyB5LuT5pWw6YePXG4gKiBAcGFyYW0ge3N0cmluZ30gZGlyZWN0aW9uIDEg5byA5aSaICAyIOW8gOepulxuICogQHJldHVybnMgU3RyaW5nXG4gKi9cbmV4cG9ydCBmdW5jdGlvbiBnZXRVbnJlYWxpemVkUHJvZml0T3JMb3NzKG9wZW5QcmljZSwgbGF0ZXN0UHJpY2UsIGFtb3VudCwgZGlyZWN0aW9uKSB7XG4gICAgaWYgKG9wZW5QcmljZSA9PSAnJyB8fCBsYXRlc3RQcmljZSA9PSAnJyB8fCBhbW91bnQgPT0gJycpIHtcbiAgICAgICAgcmV0dXJuICcnO1xuICAgIH1cbiAgICBsZXQgZGVsdGEgPSAnJztcbiAgICBpZiAoZGlyZWN0aW9uID09IDEpIHtcbiAgICAgICAgZGVsdGEgPSBudW1iZXIuc3VidHJhY3QobGF0ZXN0UHJpY2UsIG9wZW5QcmljZSk7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgZGVsdGEgPSBudW1iZXIuc3VidHJhY3Qob3BlblByaWNlLCBsYXRlc3RQcmljZSk7XG4gICAgfVxuICAgIGxldCBwcm9maXQgPSBjb21tb24uZm9ybWF0UHJlY2lzaW9uKG51bWJlci5tdWx0aXBseShkZWx0YSwgYW1vdW50KSwgNCk7XG4gICAgcmV0dXJuIHByb2ZpdDtcbn1cblxuLyoqXG4gKiDlpJrku5Pkv53or4Hph5Hnjoc95aSa5LuT5LuT5L2N5Lu35YC8Kue7tOaMgeS/neivgemHkeeOhyAv77yI5aSa5LuT5LuT5L2N6Z2Z5oCB5p2D55uKK+WkmuS7k+S7k+S9jeacquWunueOsOebiOS6j++8iSoxMDAlXG4gKiDnqbrku5Pkv53or4Hph5Hnjoc956m65LuT5LuT5L2N5Lu35YC8Kue7tOaMgeS/neivgemHkeeOhyAv77yI56m65LuT5LuT5L2N6Z2Z5oCB5p2D55uKK+epuuS7k+S7k+S9jeacquWunueOsOebiOS6j++8iSoxMDAlXG4gKiDnu7TmjIHkv53or4Hph5HnjocgPSDosIPmlbTns7vmlbAgLyDmnaDmnYbvvIzov5nph4zpu5jorqQwLjAwNVxuICogQHBhcmFtIHtTdHJpbmd9IG9wZW5QcmljZSAg5byA5LuT5Lu3XG4gKiBAcGFyYW0ge1N0cmluZ30gbGF0ZXN0UHJpY2Ug55uY5Y+j5pyA5paw5Lu3XG4gKiBAcGFyYW0ge051bWJlcn0gYW1vdW50IOaMgeS7k+aVsOmHj1xuICogQHBhcmFtIHtzdHJpbmd9IGRpcmVjdGlvbiAxIOW8gOWkmiAgMiDlvIDnqbpcbiAqIEBwYXJhbSB7TnVtYmVyfSBsZXZlclJhdGUg5p2g5p2G5YCN5pWwXG4gKiBAcGFyYW0ge051bWJlcn0gbGV2ZXJSYXRlIOadoOadhuWAjeaVsFxuICogQHJldHVybnMgU3RyaW5nXG4gKi9cbmV4cG9ydCBmdW5jdGlvbiBnZXRNYXJnaW5SYXRlKG9wZW5QcmljZSwgbGF0ZXN0UHJpY2UsIGFtb3VudCwgZGlyZWN0aW9uLCBsZXZlclJhdGUsIG1hcmdpbikge1xuICAgIGlmIChvcGVuUHJpY2UgPT0gJycgfHwgbGF0ZXN0UHJpY2UgPT0gJycgfHwgYW1vdW50ID09ICcnIHx8IGxldmVyUmF0ZSA9PSAnJyB8fCBtYXJnaW4gPT0gJycpIHtcbiAgICAgICAgcmV0dXJuICctLSc7XG4gICAgfVxuICAgIGxldCBwb3NpdGlvblZhbHVlID0gZ2V0UG9zaXRpb25WYWx1ZShhbW91bnQsIGxhdGVzdFByaWNlKTtcbiAgICBsZXQgdmFsdWUxID0gbnVtYmVyLm11bHRpcGx5KHBvc2l0aW9uVmFsdWUsIDAuMDA1KTtcbiAgICBsZXQgcHJvZml0ID0gZ2V0VW5yZWFsaXplZFByb2ZpdE9yTG9zcyhvcGVuUHJpY2UsIGxhdGVzdFByaWNlLCBhbW91bnQsIGRpcmVjdGlvbik7XG4gICAgbGV0IHZhbHVlMiA9IG51bWJlci5hZGQobWFyZ2luLCBwcm9maXQpO1xuXG4gICAgbGV0IG1hcmdpblJhdGUgPSBudW1iZXIubXVsdGlwbHkobnVtYmVyLmRpdmlkZSh2YWx1ZTEsIHZhbHVlMiksIDEwMCk7XG4gICAgbGV0IG1hcmdpblJhdGVTdHIgPSBjb21tb24uZm9ybWF0UHJlY2lzaW9uKG1hcmdpblJhdGUsIDIpO1xuICAgIHJldHVybiBgJHttYXJnaW5SYXRlU3RyfSVgO1xufVxuXG4vKipcbiAqIOaWsOWFrOW8j1xuICog5aSa5LuT6aKE5Lyw5by65bmz5Lu35qC8PeOAkOWkmuS7k+aMgeS7k+Wdh+S7ty3jgJDku5PkvY3ljaDnlKjkv53or4Hph5Ev77yI6Z2i5YC8KuaVsOmHj++8ieOAkeOAkS/vvIgxLW1tcu+8iVxuICog56m65LuT6aKE5Lyw5by65bmz5Lu35qC8PeOAkOepuuS7k+S7k+aMgeS7k+Wdh+S7tyvjgJDku5PkvY3ljaDnlKjkv53or4Hph5Ev77yI6Z2i5YC8KuaVsOmHj++8ieOAkeOAkS/vvIgxK21tcu+8iVxuICog6ICB5YWs5byPXG4gKiDlpJrku5PpooTkvLDlvLrlubPku7fmoLw95oyB5LuT5Z2H5Lu3K++8iOS7k+S9jeS7t+WAvCrnu7TmjIHkv53or4Hph5HnjocgLeS7k+S9jeWNoOeUqOS/neivgemHke+8iS/vvIjlvKDmlbAq5ZCI57qm6Z2i5YC877yJXG4gKiDnqbrku5PpooTkvLDlvLrlubPku7fmoLw95oyB5LuT5Z2H5Lu3Le+8iOS7k+S9jeS7t+WAvCrnu7TmjIHkv53or4Hph5HnjocgLeS7k+S9jeWNoOeUqOS/neivgemHke+8iS/vvIjlvKDmlbAq5ZCI57qm6Z2i5YC877yJXG4gKiBAcGFyYW0ge1N0cmluZ30gb3BlblByaWNlICDlvIDku5Pku7dcbiAqIEBwYXJhbSB7U3RyaW5nfSBsYXRlc3RQcmljZSDnm5jlj6PmnIDmlrDku7dcbiAqIEBwYXJhbSB7TnVtYmVyfSBhbW91bnQg5oyB5LuT5pWw6YePXG4gKiBAcGFyYW0ge051bWJlcn0gbGV2ZXJSYXRlIOadoOadhuWAjeaVsFxuICogQHBhcmFtIHtzdHJpbmd9IGRpcmVjdGlvbiAxIOW8gOWkmiAgMiDlvIDnqbpcbiAqIEByZXR1cm5zIFN0cmluZ1xuICovXG5leHBvcnQgZnVuY3Rpb24gZ2V0TGlxdWlkYXRpb25QcmljZShvcGVuUHJpY2UsIGxhdGVzdFByaWNlLCBhbW91bnQsIGxldmVyUmF0ZSwgbWFyZ2luLCBkaXJlY3Rpb24sIHByZWNpc2lvbikge1xuICAgIGlmIChvcGVuUHJpY2UgPT0gJycgfHwgbGF0ZXN0UHJpY2UgPT0gJycgfHwgYW1vdW50ID09ICcnIHx8IGxldmVyUmF0ZSA9PSAnJyB8fCBtYXJnaW4gPT0gJycgfHwgZGlyZWN0aW9uID09ICcnKSB7XG4gICAgICAgIHJldHVybiAnLS0nO1xuICAgIH1cbiAgICBsZXQgdmFsdWUxID0gbnVtYmVyLmRpdmlkZShtYXJnaW4sIGFtb3VudCk7XG4gICAgbGV0IHZhbHVlMiA9ICcnO1xuICAgIGxldCB2YWx1ZTMgPSAnJztcbiAgICBpZiAoZGlyZWN0aW9uID09IDEpIHtcbiAgICAgICAgdmFsdWUyID0gbnVtYmVyLnN1YnRyYWN0KG9wZW5QcmljZSwgdmFsdWUxKTtcbiAgICAgICAgdmFsdWUzID0gbnVtYmVyLmRpdmlkZSh2YWx1ZTIsICgxLTAuMDA1KSk7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgdmFsdWUyID0gbnVtYmVyLmFkZChvcGVuUHJpY2UsIHZhbHVlMSk7XG4gICAgICAgIHZhbHVlMyA9IG51bWJlci5kaXZpZGUodmFsdWUyLCAoMSswLjAwNSkpO1xuICAgIH1cbiAgICByZXR1cm4gY29tbW9uLmZvcm1hdFByZWNpc2lvbih2YWx1ZTMsIHByZWNpc2lvbik7XG4gICAgLy8gbGV0IHBvc2l0aW9uVmFsdWUgPSBnZXRQb3NpdGlvblZhbHVlKGFtb3VudCwgbGF0ZXN0UHJpY2UpO1xuICAgIC8vIGxldCB2YWx1ZTEgPSBudW1iZXIubXVsdGlwbHkocG9zaXRpb25WYWx1ZSwgMC4wMDUpO1xuICAgIC8vIGxldCB2YWx1ZTIgPSBudW1iZXIuc3VidHJhY3QodmFsdWUxLCBtYXJnaW4pO1xuICAgIC8vIGxldCB2YWx1ZTMgPSBudW1iZXIuZGl2aWRlKHZhbHVlMiwgYW1vdW50KTtcbiAgICAvLyBsZXQgZGVsdGEgPSAnJztcbiAgICAvLyBpZiAoZGlyZWN0aW9uID09IDEpIHtcbiAgICAvLyAgICAgZGVsdGEgPSBudW1iZXIuYWRkKG9wZW5QcmljZSwgdmFsdWUzKTtcbiAgICAvLyB9IGVsc2Uge1xuICAgIC8vICAgICBkZWx0YSA9IG51bWJlci5zdWJ0cmFjdChvcGVuUHJpY2UsIHZhbHVlMyk7XG4gICAgLy8gfVxufVxuXG4iLCJpbXBvcnQgKiBhcyBjb21tb24gZnJvbSBcIi4vY29tbW9uXCI7XG5pbXBvcnQgKiBhcyBjb21tb25Qb3AgZnJvbSBcIi4vY29tbW9uUG9wXCI7XG5pbXBvcnQgKiBhcyBjYWxjdWxhdG9yIGZyb20gXCIuL2NhbGN1bGF0b3JcIjtcbmltcG9ydCAqIGFzIGhlYWRlclByb2ZpdCBmcm9tIFwiLi9oZWFkZXJQcm9maXRcIjtcblxudmFyIGN1ckxpc3QgPSBbXTtcbi8qKlxuICog5YWF5YC85aWW5Yqx5pWw57uEXG4gKi9cbnZhciBnaWZ0U3RlcExpc3QgPSBbXTtcblxuLyoqXG4gKiDku5PkvY3mnInmlYjmnJ/lgJLorqHml7ZcbiAqL1xubGV0IGl0ZW1UaW1lcjtcblxubGV0IHRvdGFsQ291bnRkb3duU2Vjb25kcyA9IDA7XG5cbnZhciBpc1JlcXVlc3QgPSBmYWxzZTtcblxuZnVuY3Rpb24gZGVmYXVsdERhdGEoKSB7XG4gICAgcmV0dXJuIHtcbiAgICAgICAgbG9hZGluZ0xvdHRpZVN0YXR1czogXCJzdG9wXCIsXG4gICAgICAgIG9wZW5Qb3NpdGlvbkxpc3Q6IFtdLFxuICAgICAgICBsaXN0Vmlld1Zpc2liaWxpdHk6IFwiZ29uZVwiLFxuICAgICAgICBvc0xpc3RWaWV3VmlzaWJpbGl0eTogXCJnb25lXCIsXG4gICAgICAgIGVtcHR5Vmlld1Zpc2liaWxpdHk6IFwiZ29uZVwiLFxuICAgICAgICBjdXJDbG9zZUluZGV4OiAtMSxcbiAgICAgICAgbGFzdEZvbGRJbmRleDogMCxcbiAgICAgICAgY2xvc2VQb3NpdGlvbkRhdGE6IHt9LFxuICAgICAgICBjbG9zZVBvc2l0aW9uQWN0aXZpdHlEaWFsb2dNYXhQbmxQcmVmaXg6ICRpMThuLiRpbnRlcmNlcHQubl96ZXJvX3N3YXBfcHJvZml0X2Nsb3NlX3Bvc2l0aW9uKFwiXCIpLFxuICAgICAgICAvLyAg5bmz5LuTLeaciea0u+WKqCDlvLnmoYZcbiAgICAgICAgY2xvc2VQb3NpdGlvbkFjdGl2aXR5RGlhbG9nOiB7XG4gICAgICAgICAgICAvLyAg5pS255uKXG4gICAgICAgICAgICBcInBubFwiOiBcIi1cIiArIFwiIFwiICsgJGkxOG4ubl9wZXJzb25hbF9jZW50ZXJfcmV3YXJkX3VuaXQsXG4gICAgICAgICAgICAvLyAg5pS255uK6aKc6ImyIOS6j+aNnzoga0NvbG9yUHJpbWFyeVRleHQg55uI5YipOiBrQ29sb3JQcmljZUdyZWVuXG4gICAgICAgICAgICBcInBubENvbG9yXCI6IFwiQGNvbG9yL2tDb2xvclByaWNlR3JlZW5cIixcbiAgICAgICAgICAgIC8vICDmnIDpq5jmlLbnm4rkuIrpmZBcbiAgICAgICAgICAgIFwibWF4UG5sXCI6IFwiLVwiICsgXCIgXCIgKyAkaTE4bi5uX3BlcnNvbmFsX2NlbnRlcl9yZXdhcmRfdW5pdCxcbiAgICAgICAgICAgIC8vICDmnIDpq5jmtLvliqjlpZblirFcbiAgICAgICAgICAgIFwibWF4QWN0aXZpdHlQbmxcIjogJGkxOG4uJGludGVyY2VwdC5uX3plcm9fc3dhcF9oaWdoZXN0X2xpbWl0ZWRfdGltZV9yZXdhcmQoXCItXCIpLFxuICAgICAgICAgICAgLy8gIOS7heW5s+S7k+aWh+ahiFxuICAgICAgICAgICAgXCJvbmx5Q2xvc2VQb3NpdGlvblBubFwiOiAkaTE4bi4kaW50ZXJjZXB0Lm5femVyb19zd2FwX29idGFpbl9pbW1lZGlhdGVseShcIi1cIiksXG4gICAgICAgICAgICAvLyAg55uI5Yip5paH5qGI5pi+56S654q25oCBXG4gICAgICAgICAgICBcInByb2ZpdFZpc2liaWxpdHlcIjogXCJ2aXNpYmxlXCIsXG4gICAgICAgICAgICAvLyAg5LqP5o2f5paH5qGI5pi+56S654q25oCBXG4gICAgICAgICAgICBcImxvc3NWaXNpYmlsaXR5XCI6IFwiZ29uZVwiLFxuICAgICAgICB9LFxuICAgICAgICBjbG9zZVBvc2l0aW9uQWN0aXZpdHlEaWFsb2dTaG93OiBcImZhbHNlXCIsXG4gICAgICAgIC8vICDnm4jliKnlubPku5PmiJDlip8g5by55qGGXG4gICAgICAgIGNsb3NlUG9zaXRpb25TdWNjZXNzRGlhbG9nOiB7XG4gICAgICAgICAgICBcInNob3dcIjogXCJmYWxzZVwiLFxuICAgICAgICAgICAgXCJwbmxcIjogXCItXCIgKyBcIiBcIiArICRpMThuLm5fcGVyc29uYWxfY2VudGVyX3Jld2FyZF91bml0LFxuICAgICAgICB9LFxuICAgICAgICAvLyAg5YWF5YC85ou/5aWW5YqxIOW8ueahhlxuICAgICAgICByZWNoYXJnZVJld2FyZHNEaWFsb2c6IHtcbiAgICAgICAgICAgIFwic2hvd1wiOiBcImZhbHNlXCIsXG4gICAgICAgICAgICBcImluZGljYXRvckNvbG9yXCI6IGNvbW1vbi5jb21tb25EYXRhLmNvbG9yTW9kZSA9PSAxID8gXCIjMUFFQUVBRUFcIiA6IFwiIzFBMDAwMDAwXCIsXG4gICAgICAgICAgICBcImxldmVyTGlzdFwiOiBbXSxcbiAgICAgICAgfSxcbiAgICAgICAgcmVjaGFyZ2VSZXdhcmRzRGlhbG9nRGF5OiBcIi0tXCIsXG4gICAgICAgIHJlY2hhcmdlUmV3YXJkc0RpYWxvZ0hvdXI6IFwiLS1cIixcbiAgICAgICAgcmVjaGFyZ2VSZXdhcmRzRGlhbG9nTWludXRlOiBcIi0tXCIsXG4gICAgICAgIHJlY2hhcmdlUmV3YXJkc0RpYWxvZ1NlY29uZDogXCItLVwiLFxuICAgICAgICAvLyAg5LuF5bmz5LuTIOW8ueahhlxuICAgICAgICBjbG9zZVBvc2l0aW9uT25seURpYWxvZzoge1xuICAgICAgICAgICAgLy8gIOaUtuebilxuICAgICAgICAgICAgXCJwbmxcIjogXCItXCIgKyBcIiBcIiArICRpMThuLm5fcGVyc29uYWxfY2VudGVyX3Jld2FyZF91bml0LFxuICAgICAgICAgICAgLy8gIOaUtuebiuminOiJsiDkuo/mjZ86IGtDb2xvclByaW1hcnlUZXh0IOebiOWIqToga0NvbG9yUHJpY2VHcmVlblxuICAgICAgICAgICAgXCJwbmxDb2xvclwiOiBcIkBjb2xvci9rQ29sb3JQcmljZUdyZWVuXCIsXG4gICAgICAgICAgICAvLyAg5pyA6auY5pS255uK5LiK6ZmQXG4gICAgICAgICAgICBcIm1heFBubFwiOiBcIi1cIiArIFwiIFwiICsgJGkxOG4ubl9wZXJzb25hbF9jZW50ZXJfcmV3YXJkX3VuaXQsXG4gICAgICAgICAgICAvLyAg55uI5Yip5paH5qGI5pi+56S654q25oCBXG4gICAgICAgICAgICBcInByb2ZpdFZpc2liaWxpdHlcIjogXCJnb25lXCIsXG4gICAgICAgICAgICAvLyAg5LqP5o2f5paH5qGI5pi+56S654q25oCBXG4gICAgICAgICAgICBcImxvc3NWaXNpYmlsaXR5XCI6IFwidmlzaWJsZVwiLFxuICAgICAgICB9LFxuICAgICAgICBjbG9zZVBvc2l0aW9uT25seURpYWxvZ1Nob3c6IFwiZmFsc2VcIixcbiAgICAgICAgYm90dG9tQmFySGVpZ2h0OiAwXG4gICAgfTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gc3RhcnQoKSB7XG4gICAgaWYgKGNvbW1vbi5jb21tb25EYXRhLmJvdHRvbUJhckhlaWdodCA+IDApIHtcbiAgICAgICAgbW9kdWxlRGF0YS5ib3R0b21CYXJIZWlnaHQgPSBjb21tb24uY29tbW9uRGF0YS5ib3R0b21CYXJIZWlnaHQ7XG4gICAgfVxuICAgIGNvbW1vbi5zaG93TG9hZGluZyh0cnVlKTtcbiAgICBhd2FpdCByZXF1ZXN0Q29udHJhY3RJbmZvRGF0YSgpO1xuICAgIHJlcXVlc3RQb3NpdGlvbkxpc3QoKTtcbiAgICByZXF1ZXN0R2lmdFN0ZXAoKTtcbn1cblxuY29uc3QgeyBtb2R1bGVEYXRhLCBtb2R1bGVFdmVudCB9ID0gY29tbW9uLm1vZHVsZURlZmluZShcIm9wZW5Qb3NpdGlvblwiLCBzdGFydCwgZGVmYXVsdERhdGEpO1xuXG5cbi8qKlxuICog6K+35rGC5omA5pyJ5ZCI57qm55qE5L+h5oGvXG4gKi9cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiByZXF1ZXN0Q29udHJhY3RJbmZvRGF0YSgpIHtcbiAgICBjb25zb2xlLmxvZyhcInJlcXVlc3RDb250cmFjdEluZm9EYXRhXCIpO1xuICAgIHZhciBwYXJhbXMgPSB7XG4gICAgICAgIGJ1c2luZXNzX3R5cGU6IFwiYWxsXCIsXG4gICAgICAgIHRyYWRlX3BhcnRpdGlvbjogXCJhbGxcIixcbiAgICB9O1xuICAgIHZhciByZXNwRGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdChcImxpbmVhci1zd2FwLW9yZGVyL3gvdjEvbGluZWFyX3N3YXBfY29udHJhY3RfaW5mb1wiLCBwYXJhbXMsIDAsIDgpO1xuICAgIGlmIChyZXNwRGF0YSkge1xuICAgICAgICBjb21tb24uY29tbW9uRGF0YS5jb250cmFjdEluZm9EYXRhID0gcmVzcERhdGE7XG4gICAgfVxufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gcmVxdWVzdFBvc2l0aW9uTGlzdCgpIHtcbiAgICB2YXIgcGFyYW0gPSB7XG4gICAgICAgIHN0YXRlOiAxLFxuICAgICAgICBwYWdlTnVtOiAxLFxuICAgICAgICBwYWdlU2l6ZTogMjBcbiAgICB9XG4gICAgaWYgKGlzUmVxdWVzdCkge1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIGlzUmVxdWVzdCA9IHRydWU7XG4gICAgY29uc3QgZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdChcInYxL2FjdGl2aXR5L3plcm8vcG9zaXRpb24vbGlzdFwiLCBwYXJhbSwgMCwgMCwgeyBcIkNvbnRlbnQtVHlwZVwiOiBcImFwcGxpY2F0aW9uL2pzb25cIiB9KVxuICAgIGlzUmVxdWVzdCA9IGZhbHNlO1xuICAgIGlmICghZGF0YSB8fCBkYXRhID09IG51bGwgfHwgIWRhdGEubGlzdCB8fCBkYXRhLmxpc3QgPT0gbnVsbCB8fCBkYXRhLmxpc3QubGVuZ3RoID09IDApIHtcbiAgICAgICAgc2V0TGlzdFZpc2libGUoZmFsc2UpO1xuICAgICAgICBjdXJMaXN0ID0gW107XG4gICAgICAgIG1vZHVsZURhdGEub3BlblBvc2l0aW9uTGlzdCA9IFtdO1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIHNldExpc3RWaXNpYmxlKHRydWUpO1xuICAgIHRyeSB7XG4gICAgICAgIGNvbnN0IHsgdG90YWwsIGxpc3QgfSA9IGRhdGE7XG4gICAgICAgIG1vZHVsZURhdGEudG90YWwgPSB0b3RhbDtcbiAgICAgICAgdG90YWxDb3VudGRvd25TZWNvbmRzID0gMDtcbiAgICAgICAgaGFuZGxlT3BlblBvc2l0aW9uRGF0YShsaXN0KTtcbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGBoYW5kbGUgcmVxdWVzdFBvc2l0aW9uTGlzdCBkYXRhIGVycm9yPSR7ZX1gKTtcbiAgICB9XG59XG5cbmZ1bmN0aW9uIHNldExpc3RWaXNpYmxlKHZpc2libGUpIHtcbiAgICBpZiAodHJ1ZSA9PSB2aXNpYmxlKSB7XG4gICAgICAgIG1vZHVsZURhdGEuZW1wdHlWaWV3VmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgICAgICBtb2R1bGVEYXRhLm9zTGlzdFZpZXdWaXNpYmlsaXR5ID0gXCJ2aXNpYmxlXCI7XG4gICAgfVxuICAgIGVsc2Uge1xuICAgICAgICBtb2R1bGVEYXRhLmVtcHR5Vmlld1Zpc2liaWxpdHkgPSBcInZpc2libGVcIjtcbiAgICAgICAgbW9kdWxlRGF0YS5vc0xpc3RWaWV3VmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgIH1cbn1cblxuLyoqXG4gKiDlpITnkIbmjIHku5PmlbDmja5cbiAqL1xuYXN5bmMgZnVuY3Rpb24gaGFuZGxlT3BlblBvc2l0aW9uRGF0YShsaXN0KSB7XG4gICAgZm9yIChsZXQgaSA9IDA7IGkgPCBsaXN0Lmxlbmd0aDsgKytpKSB7XG4gICAgICAgIGxldCB2ID0gbGlzdFtpXTtcbiAgICAgICAgdmFyIHN0ckFycmF5ID0gdi5zeW1ib2wuc3BsaXQoJy0nKTtcbiAgICAgICAgbGV0IGJhc2VDdXJyZW5jeSA9IHN0ckFycmF5WzBdLnRvVXBwZXJDYXNlKCk7XG4gICAgICAgIGxldCBxdW90ZUN1cnJlbmN5ID0gc3RyQXJyYXlbMV0udG9VcHBlckNhc2UoKTtcbiAgICAgICAgdi5iYXNlQ3VycmVuY3kgPSBiYXNlQ3VycmVuY3k7XG4gICAgICAgIHYucXVvdGVDdXJyZW5jeSA9IHF1b3RlQ3VycmVuY3k7XG4gICAgICAgIHYudHlwZSA9IFwiMVwiO1xuICAgICAgICB2LmluZGV4ID0gaTtcbiAgICAgICAgdi5kYXlVbml0ID0gJGkxOG4ubl9kYXk7XG4gICAgICAgIHYuaWNvbiA9IGNvbW1vbi5nZXRQTkdJY29uVVJMQnlDdXJyZW5jeShiYXNlQ3VycmVuY3kpO1xuICAgICAgICB2LmRpc1BsYXlTeW1ib2wgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fY29udHJhY3Rfc3dhcF90cmFkZV9uYW1lKGAke2Jhc2VDdXJyZW5jeX0ke3F1b3RlQ3VycmVuY3l9YCk7XG4gICAgICAgIHYua2xpbmVUaXRsZSA9IGAke2Jhc2VDdXJyZW5jeX0ke3F1b3RlQ3VycmVuY3l9JHskaTE4bi5uX21hcmtldF9jb250cmFjdF9zd2FwX3RyYWRlX25hbWVfYWJicn0gJHskaTE4bi5uX3plcm9fc3dhcF9rbGluZV9jaGFydH1gO1xuICAgICAgICB2Lm1hcmdpbk1vZGUgPSAkaTE4bi5uX2NvbnRyYWN0X3RyYWRlX21hcmdpbjtcbiAgICAgICAgdi5sZXZlciA9IGAke3YubGV2ZXJhZ2VSYXRpb31YYDtcbiAgICAgICAgdi5wbmxOYW1lID0gJGkxOG4ubl9jb250cmFjdF9wcm9maXQgKyBcIihcIiArIHF1b3RlQ3VycmVuY3kgKyBcIilcIjtcbiAgICAgICAgdi5wb3NpdGlvbkFtb3VudFRpdGxlID0gJGkxOG4uJGludGVyY2VwdC5uX2NvbnRhcmN0X3Bvc2l0aW9uX3ZvbHVtZV9sYWJlbChiYXNlQ3VycmVuY3kpO1xuICAgICAgICB2Lm1hcmdpbk5hbWUgPSAkaTE4bi5uX2JvbmQgKyBcIihcIiArIHF1b3RlQ3VycmVuY3kgKyBcIilcIjtcbiAgICAgICAgdi5vcGVuQXZnUHhOYW1lID0gJGkxOG4uJGludGVyY2VwdC5uX2xpbmVhcl9zd2FwX29wZW5fcHJpY2UocXVvdGVDdXJyZW5jeSk7XG4gICAgICAgIHYubGlxUHhOYW1lID0gJGkxOG4uJGludGVyY2VwdC5uX2xpbmVhcl9zd2FwX3ByZWRpY3Rpb25fb2Zfc3Ryb25nX3Bhcml0eShgKCR7cXVvdGVDdXJyZW5jeX0pYCk7XG4gICAgICAgIHYubWFyZ2luUmF0aW9OYW1lID0gJGkxOG4ubl9hc3NldF9tYXJnaW5fcmF0ZTtcbiAgICAgICAgdi5wbmxSYXRpb05hbWUgPSAkaTE4bi5uX2NvbnRyYWN0X3lpZWxkO1xuICAgICAgICBpZiAodi5kaXJlY3Rpb24gPT0gMSkge1xuICAgICAgICAgICAgdi5wb3NTaWRlID0gJGkxOG4ubl9hc3NldF9mdXR1cmVfYnV5O1xuICAgICAgICAgICAgdi5wb3NTaWRlQ29sb3IgPSBjb21tb24uZ2V0VXBEb3duQ29sb3IoKTtcbiAgICAgICAgICAgIHYucG9zU2lkZWJhY2tDb2xvciA9IGNvbW1vbi5nZXRIYW5kaWNhcENvbG9yKCk7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICB2LnBvc1NpZGUgPSAkaTE4bi5uX2Fzc2V0X2Z1dHVyZV9zZWxsO1xuICAgICAgICAgICAgdi5wb3NTaWRlQ29sb3IgPSBjb21tb24uZ2V0VXBEb3duQ29sb3IoZmFsc2UpO1xuICAgICAgICAgICAgdi5wb3NTaWRlYmFja0NvbG9yID0gY29tbW9uLmdldEhhbmRpY2FwQ29sb3IoZmFsc2UpO1xuICAgICAgICB9XG4gICAgICAgIHYuYW1vdW50ID0gdi5wb3NpdGlvbkFtb3VudDtcbiAgICAgICAgdi5vcGVuQXZnUHggPSB2Lm9wZW5QcmljZTtcbiAgICAgICAgdi5tYXJnaW4gPSB2LnBvc2l0aW9uTWFyZ2luO1xuICAgICAgICB2LnNob3dDaGFydCA9IChtb2R1bGVEYXRhLmxhc3RGb2xkSW5kZXggPT0gaSkgPyBcInZpc2libGVcIiA6IFwiZ29uZVwiO1xuICAgICAgICB2LnVwZG93bkltYWdlID0gKG1vZHVsZURhdGEubGFzdEZvbGRJbmRleCA9PSBpKSA/IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2Fycm93X3VwXCIgOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9hcnJvd19kb3duXCI7XG4gICAgICAgIHYuZm9sZCA9IChtb2R1bGVEYXRhLmxhc3RGb2xkSW5kZXggPT0gaSkgPyB0cnVlIDogZmFsc2U7XG4gICAgICAgIGxldCByZW1haW5pbmdTZWNvbmRzID0gTWF0aC5mbG9vcigodi5wb3NpdGlvbkZpbmlzaFRpbWUgfHwgMCkgLyAxMDAwKSAtIHRvdGFsQ291bnRkb3duU2Vjb25kcztcbiAgICAgICAgaWYgKHJlbWFpbmluZ1NlY29uZHMgPiAwKSB7XG4gICAgICAgICAgICBsZXQgZGF5cyA9IE1hdGguZmxvb3IocmVtYWluaW5nU2Vjb25kcyAvICgyNCAqIDYwICogNjApKTtcbiAgICAgICAgICAgIGxldCBob3VycyA9IE1hdGguZmxvb3IoKHJlbWFpbmluZ1NlY29uZHMgJSAoMjQgKiA2MCAqIDYwKSkgLyAoNjAgKiA2MCkpO1xuICAgICAgICAgICAgbGV0IG1pbnV0ZXMgPSBNYXRoLmZsb29yKChyZW1haW5pbmdTZWNvbmRzICUgKDYwICogNjApKSAvIDYwKTtcbiAgICAgICAgICAgIGxldCBzZWNvbmRzID0gcmVtYWluaW5nU2Vjb25kcyAlIDYwO1xuICAgICAgICAgICAgdi5kYXkgPSAoZGF5cyA8IDEwID8gJzAnICsgZGF5cyA6IGRheXMpLnRvU3RyaW5nKCk7XG4gICAgICAgICAgICB2LmhvdXIgPSAoaG91cnMgPCAxMCA/ICcwJyArIGhvdXJzIDogaG91cnMpLnRvU3RyaW5nKCk7XG4gICAgICAgICAgICB2Lm1pbnV0ZSA9IChtaW51dGVzIDwgMTAgPyAnMCcgKyBtaW51dGVzIDogbWludXRlcykudG9TdHJpbmcoKTtcbiAgICAgICAgICAgIHYuc2Vjb25kID0gKHNlY29uZHMgPCAxMCA/ICcwJyArIHNlY29uZHMgOiBzZWNvbmRzKS50b1N0cmluZygpO1xuICAgICAgICAgICAgdi5lZmZlY3RpdmVUaW1lVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgICAgdi50aXRsZSA9ICRpMThuLm5femVyb19zd2FwX3Bvc2l0aW9uX2VmZmVjdGl2ZV9wZXJpb2Q7XG4gICAgICAgICAgICB2LmNsb3NlVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgICAgdi5zaG93Q2xvc2UgPSB0cnVlO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgdi5lZmZlY3RpdmVUaW1lVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgdi50aXRsZSA9ICRpMThuLm5femVyb19zd2FwX3Bvc2l0aW9uX2hhc19leHBpcmVkO1xuICAgICAgICAgICAgdi5jbG9zZVZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICAgICAgICAgIHYuc2hvd0Nsb3NlID0gZmFsc2U7XG4gICAgICAgIH1cbiAgICAgICAgZGVhbFByaWNlQ2FsY3VsYXRpb24odik7XG4gICAgfVxuICAgIGN1ckxpc3QgPSBsaXN0O1xuICAgIG1vZHVsZURhdGEub3BlblBvc2l0aW9uTGlzdCA9IGN1ckxpc3Q7XG4gICAgdXBkYXRlT1NEYXRhKCk7XG4gICAgY29tbW9uLnNob3dMb2FkaW5nKGZhbHNlKTtcbiAgICBzdGFydEl0ZW1Db3VudGRvd24oKTtcbn1cblxuLyoqXG4gKiDlvIDlp4vlgJLorqHml7YgMeWIhumSn+S4gOasoeWIt+aWsOmhtemdouacieaViOacn+aXtumXtFxuICovXG5hc3luYyBmdW5jdGlvbiBzdGFydEl0ZW1Db3VudGRvd24oKSB7XG4gICAgY2FuY2VsSXRlbUNvdW50ZG93bigpO1xuICAgIGl0ZW1UaW1lciA9IHNldEludGVydmFsKCgpID0+IHtcbiAgICAgICAgaWYgKGN1ckxpc3QubGVuZ3RoID4gMCkge1xuICAgICAgICAgICAgZm9yIChsZXQgaSA9IDA7IGkgPCBjdXJMaXN0Lmxlbmd0aDsgKytpKSB7XG4gICAgICAgICAgICAgICAgbGV0IHYgPSBjdXJMaXN0W2ldO1xuICAgICAgICAgICAgICAgIHRyeSB7XG4gICAgICAgICAgICAgICAgICAgIGxldCByZW1haW5pbmdTZWNvbmRzID0gTWF0aC5mbG9vcigodi5wb3NpdGlvbkZpbmlzaFRpbWUgfHwgMCkgLyAxMDAwKSAtIHRvdGFsQ291bnRkb3duU2Vjb25kcztcbiAgICAgICAgICAgICAgICAgICAgaWYgKHJlbWFpbmluZ1NlY29uZHMgPiAwKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICBsZXQgZGF5cyA9IE1hdGguZmxvb3IocmVtYWluaW5nU2Vjb25kcyAvICgyNCAqIDYwICogNjApKTtcbiAgICAgICAgICAgICAgICAgICAgICAgIGxldCBob3VycyA9IE1hdGguZmxvb3IoKHJlbWFpbmluZ1NlY29uZHMgJSAoMjQgKiA2MCAqIDYwKSkgLyAoNjAgKiA2MCkpO1xuICAgICAgICAgICAgICAgICAgICAgICAgbGV0IG1pbnV0ZXMgPSBNYXRoLmZsb29yKChyZW1haW5pbmdTZWNvbmRzICUgKDYwICogNjApKSAvIDYwKTtcbiAgICAgICAgICAgICAgICAgICAgICAgIGxldCBzZWNvbmRzID0gcmVtYWluaW5nU2Vjb25kcyAlIDYwO1xuICAgICAgICAgICAgICAgICAgICAgICAgdi5kYXkgPSAoZGF5cyA8IDEwID8gJzAnICsgZGF5cyA6IGRheXMpLnRvU3RyaW5nKCk7XG4gICAgICAgICAgICAgICAgICAgICAgICB2LmhvdXIgPSAoaG91cnMgPCAxMCA/ICcwJyArIGhvdXJzIDogaG91cnMpLnRvU3RyaW5nKCk7XG4gICAgICAgICAgICAgICAgICAgICAgICB2Lm1pbnV0ZSA9IChtaW51dGVzIDwgMTAgPyAnMCcgKyBtaW51dGVzIDogbWludXRlcykudG9TdHJpbmcoKTtcbiAgICAgICAgICAgICAgICAgICAgICAgIHYuc2Vjb25kID0gKHNlY29uZHMgPCAxMCA/ICcwJyArIHNlY29uZHMgOiBzZWNvbmRzKS50b1N0cmluZygpO1xuICAgICAgICAgICAgICAgICAgICAgICAgdi5lZmZlY3RpdmVUaW1lVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgICAgICAgICAgICAgICAgdi50aXRsZSA9ICRpMThuLm5femVyb19zd2FwX3Bvc2l0aW9uX2VmZmVjdGl2ZV9wZXJpb2Q7XG4gICAgICAgICAgICAgICAgICAgICAgICB2LmNsb3NlVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgICAgICAgICAgICAgICAgdi5zaG93Q2xvc2UgPSB0cnVlO1xuICAgICAgICAgICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICAgICAgdi5lZmZlY3RpdmVUaW1lVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgICAgICAgICAgICAgdi50aXRsZSA9ICRpMThuLm5femVyb19zd2FwX3Bvc2l0aW9uX2hhc19leHBpcmVkO1xuICAgICAgICAgICAgICAgICAgICAgICAgdi5jbG9zZVZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICAgICAgICAgICAgICAgICAgICAgIHYuc2hvd0Nsb3NlID0gZmFsc2U7XG4gICAgICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICAgICAgZGVhbFByaWNlQ2FsY3VsYXRpb24odik7XG4gICAgICAgICAgICAgICAgfSBjYXRjaCAoZSkge1xuICAgICAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVmcmVzaHRpbWUtIOS7k+S9jeacieaViOacny1lID0gJHtlfWApO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIG1vZHVsZURhdGEub3BlblBvc2l0aW9uTGlzdCA9IGN1ckxpc3Q7XG4gICAgICAgICAgICB1cGRhdGVPU0RhdGEoKTtcbiAgICAgICAgICAgIHRvdGFsQ291bnRkb3duU2Vjb25kcysrO1xuICAgICAgICB9XG4gICAgfSwgMTAwMCk7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHVwZGF0ZU9TRGF0YSgpIHtcbiAgICBtb2R1bGVEYXRhLnBvc2l0aW9uTGlzdCA9IEpTT04uc3RyaW5naWZ5KGN1ckxpc3QpO1xufVxuXG4vKipcbiAqIGl0ZW3lj5bmtojlgJLorqHml7ZcbiAqL1xuYXN5bmMgZnVuY3Rpb24gY2FuY2VsSXRlbUNvdW50ZG93bigpIHtcbiAgICBpZiAoaXRlbVRpbWVyICE9IG51bGwpIHtcbiAgICAgICAgY2xlYXJJbnRlcnZhbChpdGVtVGltZXIpO1xuICAgICAgICBpdGVtVGltZXIgPSBudWxsO1xuICAgIH1cbn1cblxuYXN5bmMgZnVuY3Rpb24gb25BcHBlYXIoKSB7XG4gICAgYXdhaXQgY29tbW9uLmFuYWx5dGljcyhcImFwcGNsaWNrX2NvbnRyYWN0c1wiLCB7XG4gICAgICAgIGJ1c2luZXNzX2NhdGVnb3J5OiBcInVzZHRfMF95dWFuX2J1eVwiLFxuICAgICAgICBidXR0b25fbmFtZTogXCJ1c2R0X215X3Bvc2l0aW9uXzBfeXVhblwiLFxuICAgIH0pO1xuICAgIHJlcXVlc3RQb3NpdGlvbkxpc3QoKTtcbiAgICBjb21tb24uc3ViUHJpY2VXZWJTb2NrZXQoXCJsaW5lYXJTd2FwV3NcIik7XG5cbn1cblxuLy/pgJrov4fmnIDmlrDku7fliLfmlrDmlLbnm4rjgIHmlLbnm4rnjodcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiByZWZyZXNoUHJvZml0KCkge1xuICAgIGNvbnNvbGUubG9nKGB3cC0tLS0tLS0tLXJlZnJlc2hQcm9maXRgKTtcbiAgICBpZiAoT2JqZWN0LmdldE93blByb3BlcnR5TmFtZXMoY29tbW9uLmNvbW1vbkRhdGEubGluZWFyU3dhcFdzRGF0YSkubGVuZ3RoID09IDApIHtcbiAgICAgICAgLy/mnKrojrflj5bliLDplb/ov57mjqXmlbDmja4g5LiN5aSE55CGXG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgaWYgKGN1ckxpc3QubGVuZ3RoID4gMCkge1xuICAgICAgICBmb3IgKGxldCBpID0gMDsgaSA8IGN1ckxpc3QubGVuZ3RoOyArK2kpIHtcbiAgICAgICAgICAgIGxldCB2ID0gY3VyTGlzdFtpXTtcbiAgICAgICAgICAgIGRlYWxQcmljZUNhbGN1bGF0aW9uKHYpO1xuICAgICAgICB9XG4gICAgICAgIG1vZHVsZURhdGEub3BlblBvc2l0aW9uTGlzdCA9IGN1ckxpc3Q7XG4gICAgICAgIHVwZGF0ZU9TRGF0YSgpO1xuICAgICAgICB1cGRhdGVDbG9zZVBvc2l0aW9uKCk7XG4gICAgfVxuICAgIGNvbW1vbi5zaG93TG9hZGluZyhmYWxzZSk7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIGRlYWxQcmljZUNhbGN1bGF0aW9uKHYpIHtcbiAgICB0cnkge1xuICAgICAgICB2YXIgdXNlUHJpY2UgPSBcIlwiO1xuICAgICAgICBsZXQgZGF0YSA9IGNvbW1vbi5jb21tb25EYXRhLmxpbmVhclN3YXBXc0RhdGFbdi5zeW1ib2xdO1xuICAgICAgICBpZiAoZGF0YSAmJiB0eXBlb2YgZGF0YSAhPT0gXCJ1bmRlZmluZWRcIiAmJiBkYXRhICE9PSBudWxsICYmIGRhdGEucHJpY2UgIT09IG51bGwgJiYgZGF0YS5wcmljZSAhPT0gXCJcIiAmJiBkYXRhLnByaWNlICE9PSBcInVuZGVmaW5lZFwiKSB7XG4gICAgICAgICAgICB1c2VQcmljZSA9IGRhdGEucHJpY2U7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBpZiAodiAmJiB0eXBlb2YgdiAhPT0gXCJ1bmRlZmluZWRcIiAmJiB2LmxhdGVzdFByaWNlICE9PSB1bmRlZmluZWQgJiYgdi5sYXRlc3RQcmljZSAhPT0gbnVsbCAmJiB2LmxhdGVzdFByaWNlICE9PSBcIm51bGxcIiAmJiB2LmxhdGVzdFByaWNlICE9PSBcIlwiKSB7XG4gICAgICAgICAgICAgICAgdXNlUHJpY2UgPSB2LmxhdGVzdFByaWNlO1xuICAgICAgICAgICAgfVxuICAgICAgICB9XG4gICAgICAgIGxldCBwcm9maXQgPSBjYWxjdWxhdG9yLmdldFByb2ZpdCh2Lm9wZW5QcmljZSwgdXNlUHJpY2UsIHYuYW1vdW50LCB2LmRpcmVjdGlvbik7XG4gICAgICAgIHYucHJvZml0ID0gcHJvZml0O1xuICAgICAgICBpZiAocGFyc2VGbG9hdChwcm9maXQpID49IDApIHtcbiAgICAgICAgICAgIHYucG5sQ29sb3IgPSBjb21tb24uZ2V0VXBEb3duQ29sb3IoKTtcbiAgICAgICAgICAgIHYucG5sID0gYCske3Byb2ZpdH1gO1xuICAgICAgICB9IGVsc2UgaWYgKGlzTmFOKHBhcnNlRmxvYXQocHJvZml0KSkpIHtcbiAgICAgICAgICAgIHYucG5sQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JTZWNvbmRhcnlUZXh0XCI7XG4gICAgICAgICAgICB2LnBubCA9IFwiLS1cIjtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIHYucG5sQ29sb3IgPSBjb21tb24uZ2V0VXBEb3duQ29sb3IoZmFsc2UpO1xuICAgICAgICAgICAgdi5wbmwgPSBwcm9maXQ7XG4gICAgICAgIH1cbiAgICAgICAgaWYgKHBhcnNlRmxvYXQocHJvZml0KSA+IHBhcnNlRmxvYXQodi5oaWdoZXN0UHJvZml0KSkge1xuICAgICAgICAgICAgdi5saW1pdFRpcHMgPSAkaTE4bi4kaW50ZXJjZXB0Lm5femVyb19zd2FwX2xpbWl0X3RpcHMoYCAke3YuaGlnaGVzdFByb2ZpdH0gJHt2LnF1b3RlQ3VycmVuY3l9YCk7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICB2LmxpbWl0VGlwcyA9IFwiXCI7XG4gICAgICAgIH1cbiAgICAgICAgbGV0IHByb2ZpdFJhdGUgPSBjYWxjdWxhdG9yLmdldFByb2ZpdFJhdGUodi5vcGVuUHJpY2UsIHVzZVByaWNlLCB2LnBvc2l0aW9uQW1vdW50LCB2LmRpcmVjdGlvbiwgdi5sZXZlcmFnZVJhdGlvKTtcbiAgICAgICAgaWYgKE51bWJlci5wYXJzZUZsb2F0KHByb2ZpdFJhdGUpID4gMCkge1xuICAgICAgICAgICAgdi5wbmxSYXRpbyA9IGArJHtwcm9maXRSYXRlfSVgO1xuICAgICAgICB9IGVsc2UgaWYgKGlzTmFOKHBhcnNlRmxvYXQocHJvZml0UmF0ZSkpKSB7XG4gICAgICAgICAgICB2LnBubFJhdGlvID0gXCItLVwiO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgdi5wbmxSYXRpbyA9IGAke3Byb2ZpdFJhdGV9JWA7XG4gICAgICAgIH1cbiAgICAgICAgdi5wcmljZSA9IHVzZVByaWNlO1xuICAgICAgICBsZXQgY3VycmVudENvbnRyYWN0SW5mbyA9IGNvbW1vbi5nZXRNb2RlbEJ5Q29udHJhY3RTaG9ydFR5cGUodi5zeW1ib2wpO1xuICAgICAgICBsZXQgcHJlY2lzaW9uID0gY29tbW9uLmdldFByaWNlVGlja1ByZWNpc2lvbihjdXJyZW50Q29udHJhY3RJbmZvKTtcbiAgICAgICAgdi5saXFQeCA9IGNhbGN1bGF0b3IuZ2V0TGlxdWlkYXRpb25QcmljZSh2Lm9wZW5QcmljZSwgdXNlUHJpY2UsIHYucG9zaXRpb25BbW91bnQsIHYubGV2ZXJhZ2VSYXRpbywgdi5wb3NpdGlvbk1hcmdpbiwgdi5kaXJlY3Rpb24sIHByZWNpc2lvbik7XG4gICAgICAgIHYubWFyZ2luUmF0aW8gPSBjYWxjdWxhdG9yLmdldE1hcmdpblJhdGUodi5vcGVuUHJpY2UsIHVzZVByaWNlLCB2LnBvc2l0aW9uQW1vdW50LCB2LmRpcmVjdGlvbiwgdi5sZXZlcmFnZVJhdGlvLCB2LnBvc2l0aW9uTWFyZ2luLCBwcmVjaXNpb24pO1xuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5sb2coYGRlYWxQcmljZUNhbGN1bGF0aW9uLS1lID0gJHtlfWApO1xuICAgIH1cbn1cblxuLyoqXG4gKiDmjIHku5PliJfooahJdGVt5bGV5byA5YiG5pe25Zu+XG4gKiBAcGFyYW0ge251bWJlcn0gaW5kZXgg5oyB5LuT57Si5byVXG4gKi9cbmFzeW5jIGZ1bmN0aW9uIGNsaWNrZWRGb2xkKGluZGV4KSB7XG4gICAgaWYgKG1vZHVsZURhdGEubGFzdEZvbGRJbmRleCA+IC0xICYmIGluZGV4ICE9IG1vZHVsZURhdGEubGFzdEZvbGRJbmRleCkgey8v5b2T5YmN6YCJ5oup5LiO5LiK5qyh5LiN5LiA6Ie077yM5YiZ5YWz6Zet5LiK5qyh5bGV5byA6KeG5Zu+XG4gICAgICAgIHZhciBsYXN0Rm9sZEl0ZW0gPSBjdXJMaXN0W21vZHVsZURhdGEubGFzdEZvbGRJbmRleF07XG4gICAgICAgIGlmIChsYXN0Rm9sZEl0ZW0uZm9sZCkge1xuICAgICAgICAgICAgbGFzdEZvbGRJdGVtLmZvbGQgPSBmYWxzZTtcbiAgICAgICAgICAgIGxhc3RGb2xkSXRlbS5zaG93Q2hhcnQgPSBcImdvbmVcIjtcbiAgICAgICAgICAgIGxhc3RGb2xkSXRlbS51cGRvd25JbWFnZSA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2Fycm93X2Rvd25cIjtcbiAgICAgICAgICAgIG1vZHVsZURhdGEub3BlblBvc2l0aW9uTGlzdFttb2R1bGVEYXRhLmxhc3RGb2xkSW5kZXhdID0gbGFzdEZvbGRJdGVtO1xuICAgICAgICAgICAgY3VyTGlzdFttb2R1bGVEYXRhLmxhc3RGb2xkSW5kZXhdID0gbGFzdEZvbGRJdGVtO1xuICAgICAgICB9XG4gICAgfVxuICAgIHZhciBzZWxlY3RJdGVtID0gY3VyTGlzdFtpbmRleF07XG4gICAgc2VsZWN0SXRlbS5mb2xkID0gIXNlbGVjdEl0ZW0uZm9sZDtcbiAgICBzZWxlY3RJdGVtLnNob3dDaGFydCA9IHNlbGVjdEl0ZW0uZm9sZCA/IFwidmlzaWJsZVwiIDogXCJnb25lXCI7XG4gICAgc2VsZWN0SXRlbS51cGRvd25JbWFnZSA9IHNlbGVjdEl0ZW0uZm9sZCA/IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2Fycm93X3VwXCIgOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9hcnJvd19kb3duXCI7XG4gICAgbW9kdWxlRGF0YS5vcGVuUG9zaXRpb25MaXN0W2luZGV4XSA9IHNlbGVjdEl0ZW07XG4gICAgY3VyTGlzdFtpbmRleF0gPSBzZWxlY3RJdGVtO1xuICAgIG1vZHVsZURhdGEubGFzdEZvbGRJbmRleCA9IHNlbGVjdEl0ZW0uZm9sZCA/IGluZGV4IDogLTE7XG4gICAgdXBkYXRlT1NEYXRhKCk7XG59XG5cbi8qKlxuICog5oyB5LuT5YiX6KGoSXRlbeW5s+S7k1xuICogQHBhcmFtIHtudW1iZXJ9IGluZGV4IOaMgeS7k+e0ouW8lVxuICovXG5hc3luYyBmdW5jdGlvbiBjbGlja0Nsb3NlUG9zaXRpb24oaW5kZXgpIHtcbiAgICBjb25zb2xlLmxvZyhgY2xpY2tDbG9zZVBvc2l0aW9uYCk7XG4gICAgYXdhaXQgY29tbW9uLmFuYWx5dGljcyhcImFwcGNsaWNrX2NvbnRyYWN0c1wiLCB7XG4gICAgICAgIGJ1c2luZXNzX2NhdGVnb3J5OiBcInVzZHRfMF95dWFuX2J1eVwiLFxuICAgICAgICBidXR0b25fbmFtZTogXCJ1c2R0X2Nsb3NlXzBfeXVhblwiLFxuICAgIH0pO1xuICAgIG1vZHVsZURhdGEuY3VyQ2xvc2VJbmRleCA9IGluZGV4O1xuICAgIHZhciBpdGVtID0gY3VyTGlzdFtpbmRleF07XG4gICAgdmFyIHBhcmFtID0ge1xuICAgICAgICBwb3NpdGlvbklkOiBpdGVtLmlkXG4gICAgfVxuICAgIGNvbnN0IGRhdGEgPSBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3QoXCJ2MS9hY3Rpdml0eS96ZXJvL3RvL3Bhcml0eS9wb3NpdGlvblwiLCBwYXJhbSwgMCwgMCwgeyBcIkNvbnRlbnQtVHlwZVwiOiBcImFwcGxpY2F0aW9uL2pzb25cIiB9KVxuICAgIGlmICghZGF0YSB8fCBkYXRhID09IG51bGwpIHtcbiAgICAgICAgcmV0dXJuXG4gICAgfVxuICAgIG1vZHVsZURhdGEuY2xvc2VQb3NpdGlvbkRhdGEgPSBkYXRhO1xuICAgIHZhciBoYXNHaWZ0ID0gZGF0YS5oYXNHaWZ0O1xuICAgIHZhciBpdGVtID0gY3VyTGlzdFttb2R1bGVEYXRhLmN1ckNsb3NlSW5kZXhdO1xuICAgIGxldCBwb3NpdGlvblByb2ZpdCA9IGl0ZW0ucHJvZml0O1xuICAgIGlmKGlzTmFOKHBhcnNlRmxvYXQocG9zaXRpb25Qcm9maXQpKSkge1xuICAgICAgICBwb3NpdGlvblByb2ZpdCA9IGNvbW1vbi5mb3JtYXRQcmVjaXNpb24obW9kdWxlRGF0YS5jbG9zZVBvc2l0aW9uRGF0YS5wb3NpdGlvblByb2ZpdCwgNCk7XG4gICAgfVxuXG4gICAgaWYgKGhhc0dpZnQpIHsgLy/mnInmtLvliqhcbiAgICAgICAgbW9kdWxlRGF0YS5jbG9zZVBvc2l0aW9uQWN0aXZpdHlEaWFsb2dTaG93ID0gXCJ0cnVlXCI7XG4gICAgICAgIHVwZGF0ZUNsb3NlUG9zaXRpb25BY3Rpdml0eURpYWxvZyhwb3NpdGlvblByb2ZpdCk7XG4gICAgICAgIGF3YWl0IGNvbW1vbi5hbmFseXRpY3MoXCJhcHBleHBvc3VyZV9jb250cmFjdHNcIiwge1xuICAgICAgICAgICAgYnVzaW5lc3NfY2F0ZWdvcnk6IFwidXNkdF8wX3l1YW5fYnV5XCIsXG4gICAgICAgICAgICBidXR0b25fbmFtZTogXCJ1c2R0X2RlcG9zaXRfcmViYXRlX3BvcF91cFwiLFxuICAgICAgICB9KTtcbiAgICB9IGVsc2Uge1xuICAgICAgICBtb2R1bGVEYXRhLmNsb3NlUG9zaXRpb25Pbmx5RGlhbG9nU2hvdyA9IFwidHJ1ZVwiO1xuICAgICAgICB1cGRhdGVDbG9zZVBvc2l0aW9uT25seURpYWxvZyhwb3NpdGlvblByb2ZpdCk7XG4gICAgfVxufVxuXG5hc3luYyBmdW5jdGlvbiB1cGRhdGVDbG9zZVBvc2l0aW9uKCkge1xuICAgIGlmIChwYXJzZUZsb2F0KG1vZHVsZURhdGEuY3VyQ2xvc2VJbmRleCkgPiAtMSkge1xuICAgICAgICB2YXIgaXRlbSA9IGN1ckxpc3RbbW9kdWxlRGF0YS5jdXJDbG9zZUluZGV4XTtcbiAgICAgICAgbGV0IHBvc2l0aW9uUHJvZml0ID0gaXRlbS5wcm9maXQ7XG4gICAgICAgIGlmIChtb2R1bGVEYXRhLmNsb3NlUG9zaXRpb25EYXRhICE9IHt9KSB7XG4gICAgICAgICAgICBpZiAobW9kdWxlRGF0YS5jbG9zZVBvc2l0aW9uRGF0YS5oYXNHaWZ0KSB7XG4gICAgICAgICAgICAgICAgdXBkYXRlQ2xvc2VQb3NpdGlvbkFjdGl2aXR5RGlhbG9nKHBvc2l0aW9uUHJvZml0KTtcbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgdXBkYXRlQ2xvc2VQb3NpdGlvbk9ubHlEaWFsb2cocG9zaXRpb25Qcm9maXQpO1xuICAgICAgICAgICAgfVxuICAgICAgICB9XG4gICAgfVxufVxuXG5hc3luYyBmdW5jdGlvbiB1cGRhdGVDbG9zZVBvc2l0aW9uQWN0aXZpdHlEaWFsb2cocG9zaXRpb25Qcm9maXQpIHtcbiAgICB2YXIgaGlnaGVzdFByb2ZpdCA9IG1vZHVsZURhdGEuY2xvc2VQb3NpdGlvbkRhdGEuaGlnaGVzdFByb2ZpdDtcbiAgICB2YXIgb25seUNsb3NlUHJvZml0ID0gcG9zaXRpb25Qcm9maXQ7XG4gICAgaWYocGFyc2VGbG9hdChwb3NpdGlvblByb2ZpdCkgPCAwKSB7XG4gICAgICAgIG9ubHlDbG9zZVByb2ZpdCA9IDA7XG4gICAgfSBlbHNlIGlmIChwYXJzZUZsb2F0KHBvc2l0aW9uUHJvZml0KSA+IHBhcnNlRmxvYXQoaGlnaGVzdFByb2ZpdCkpIHtcbiAgICAgICAgb25seUNsb3NlUHJvZml0ID0gaGlnaGVzdFByb2ZpdDtcbiAgICB9XG4gICAgdmFyIHBhcmFtID0ge1xuICAgICAgICBcInBubFwiOiBgJHtwb3NpdGlvblByb2ZpdH0gYCArICRpMThuLm5fcGVyc29uYWxfY2VudGVyX3Jld2FyZF91bml0LFxuICAgICAgICBcIm1heFBubFwiOiBgJHtoaWdoZXN0UHJvZml0fSBgICsgJGkxOG4ubl9wZXJzb25hbF9jZW50ZXJfcmV3YXJkX3VuaXQsXG4gICAgICAgIFwibWF4QWN0aXZpdHlQbmxcIjogJGkxOG4uJGludGVyY2VwdC5uX3plcm9fc3dhcF9oaWdoZXN0X2xpbWl0ZWRfdGltZV9yZXdhcmQobW9kdWxlRGF0YS5jbG9zZVBvc2l0aW9uRGF0YS5tYXhHaWZ0UHJvZml0KSxcbiAgICAgICAgXCJvbmx5Q2xvc2VQb3NpdGlvblBubFwiOiAkaTE4bi4kaW50ZXJjZXB0Lm5femVyb19zd2FwX29idGFpbl9pbW1lZGlhdGVseShgJHtvbmx5Q2xvc2VQcm9maXR9YCksXG4gICAgICAgIFwicHJvZml0VmlzaWJpbGl0eVwiOiBcInZpc2libGVcIixcbiAgICAgICAgXCJsb3NzVmlzaWJpbGl0eVwiOiBcImdvbmVcIixcbiAgICB9XG4gICAgaWYgKHBvc2l0aW9uUHJvZml0ICE9IG51bGwgJiYgcG9zaXRpb25Qcm9maXQgPiAwKSB7IC8v55uI5YipXG4gICAgICAgIHBhcmFtW1wicG5sQ29sb3JcIl0gPSBcIkBjb2xvci9rQ29sb3JQcmljZUdyZWVuXCI7XG4gICAgfSBlbHNlIHsvL+S6j+aNn1xuICAgICAgICBwYXJhbVtcInBubENvbG9yXCJdID0gXCJAY29sb3Iva0NvbG9yUHJpbWFyeVRleHRcIjtcbiAgICB9XG4gICAgc2hvd0Nsb3NlUG9zaXRpb25BY3Rpdml0eURpYWxvZyhwYXJhbSk7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHVwZGF0ZUNsb3NlUG9zaXRpb25Pbmx5RGlhbG9nKHBvc2l0aW9uUHJvZml0KSB7XG4gICAgdmFyIGhpZ2hlc3RQcm9maXQgPSBtb2R1bGVEYXRhLmNsb3NlUG9zaXRpb25EYXRhLmhpZ2hlc3RQcm9maXQ7XG4gICAgdmFyIHBhcmFtID0ge1xuICAgICAgICAvLyAg5pS255uKXG4gICAgICAgIFwicG5sXCI6IGAke3Bvc2l0aW9uUHJvZml0fSBgICsgJGkxOG4ubl9wZXJzb25hbF9jZW50ZXJfcmV3YXJkX3VuaXQsXG4gICAgICAgIFwicG5sQ29sb3JcIjogXCJAY29sb3Iva0NvbG9yUHJpY2VHcmVlblwiLFxuICAgICAgICAvLyAg5pyA6auY5pS255uK5LiK6ZmQXG4gICAgICAgIFwibWF4UG5sXCI6IGAke2hpZ2hlc3RQcm9maXR9IGAgKyAkaTE4bi5uX3BlcnNvbmFsX2NlbnRlcl9yZXdhcmRfdW5pdCxcbiAgICB9O1xuICAgIGlmIChwb3NpdGlvblByb2ZpdCAhPSBudWxsICYmIHBvc2l0aW9uUHJvZml0ID4gMCkgeyAvL+ebiOWIqVxuICAgICAgICBwYXJhbVtcInBubENvbG9yXCJdID0gXCJAY29sb3Iva0NvbG9yUHJpY2VHcmVlblwiO1xuICAgICAgICBwYXJhbVtcInByb2ZpdFZpc2liaWxpdHlcIl0gPSBcInZpc2libGVcIjtcbiAgICAgICAgcGFyYW1bXCJsb3NzVmlzaWJpbGl0eVwiXSA9IFwiZ29uZVwiO1xuICAgIH0gZWxzZSB7Ly/kuo/mjZ9cbiAgICAgICAgcGFyYW1bXCJwbmxDb2xvclwiXSA9IFwiQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0XCI7XG4gICAgICAgIHBhcmFtW1wicHJvZml0VmlzaWJpbGl0eVwiXSA9IFwiZ29uZVwiO1xuICAgICAgICBwYXJhbVtcImxvc3NWaXNpYmlsaXR5XCJdID0gXCJ2aXNpYmxlXCI7XG4gICAgfVxuICAgIHNob3dDbG9zZVBvc2l0aW9uT25seURpYWxvZyhwYXJhbSk7XG59XG5cbi8qKlxuICog5pi+56S6IOW5s+S7ky3mnInmtLvliqgg5by55qGGXG4gKiBAcGFyYW0ge0pTT059IHBhcmFtcyDlubPku5Plj4LmlbBcbiAqL1xuYXN5bmMgZnVuY3Rpb24gc2hvd0Nsb3NlUG9zaXRpb25BY3Rpdml0eURpYWxvZyhwYXJhbXMpIHtcbiAgICBtb2R1bGVEYXRhLmNsb3NlUG9zaXRpb25BY3Rpdml0eURpYWxvZyA9IHBhcmFtcztcbn1cblxuLyoqXG4gKiDpmpDol48g5bmz5LuTLeaciea0u+WKqCDlvLnmoYZcbiAqIEBwYXJhbSB7bnVtYmVyfSBjbG9zZVR5cGUg5YWz6Zet57G75Z6LIDA65q2j5bi45YWz6ZetIDI65bmz5LuT5LiU5YWF5YC8IDE65LuF5bmz5LuTXG4gKi9cbmFzeW5jIGZ1bmN0aW9uIGhpZGVDbG9zZVBvc2l0aW9uQWN0aXZpdHlEaWFsb2coY2xvc2VUeXBlKSB7XG4gICAgbW9kdWxlRGF0YS5jbG9zZVBvc2l0aW9uQWN0aXZpdHlEaWFsb2dTaG93ID0gXCJmYWxzZVwiO1xuICAgIGlmICgyID09IGNsb3NlVHlwZSkge1xuICAgICAgICAvLyAg5bmz5LuT5LiU5YWF5YC8ICDlhYjlubPku5MgIOWFheWAvOaLv+WlluWKsVxuICAgICAgICBhd2FpdCBjb21tb24uYW5hbHl0aWNzKFwiYXBwY2xpY2tfY29udHJhY3RzXCIsIHtcbiAgICAgICAgICAgIGJ1c2luZXNzX2NhdGVnb3J5OiBcInVzZHRfMF95dWFuX2J1eVwiLFxuICAgICAgICAgICAgYnV0dG9uX25hbWU6IFwidXNkdF9jbG9zZV9wb3NpdGlvbl9kZXBvc2l0XzBfeXVhblwiLFxuICAgICAgICB9KTtcbiAgICAgICAgYXdhaXQgc3VyZVBhcml0eVBvc2l0aW9uKGNsb3NlVHlwZSk7XG4gICAgICAgIHNob3dSZWNoYXJnZVJld2FyZHNEaWFsb2coMSk7XG4gICAgfSBlbHNlIGlmICgxID09IGNsb3NlVHlwZSkge1xuICAgICAgICBhd2FpdCBjb21tb24uYW5hbHl0aWNzKFwiYXBwY2xpY2tfY29udHJhY3RzXCIsIHtcbiAgICAgICAgICAgIGJ1c2luZXNzX2NhdGVnb3J5OiBcInVzZHRfMF95dWFuX2J1eVwiLFxuICAgICAgICAgICAgYnV0dG9uX25hbWU6IFwidXNkdF9vbmx5X2Nsb3NlXzBfeXVhblwiLFxuICAgICAgICB9KTtcbiAgICAgICAgdmFyIGhhc0dpZnQgPSBtb2R1bGVEYXRhLmNsb3NlUG9zaXRpb25EYXRhLmhhc0dpZnQ7XG4gICAgICAgIHZhciBtYXhHaWZ0UHJvZml0ID0gbW9kdWxlRGF0YS5jbG9zZVBvc2l0aW9uRGF0YS5tYXhHaWZ0UHJvZml0O1xuICAgICAgICBpZiAoaGFzR2lmdCkge1xuICAgICAgICAgICAgLy8gIOS7heW5s+S7k+S4jeWFheWAvFxuICAgICAgICAgICAgY29tbW9uUG9wLnBvcFVwQ29udGVudE9mVHdvQnV0dG9uKC0xLCAkaTE4bi5uX3plcm9fc3dhcF9vbmx5X2Nsb3NlX3Bvc2l0aW9uX3RpdGxlLCAkaTE4bi4kaW50ZXJjZXB0Lm5femVyb19zd2FwX29ubHlfY2xvc2VfcG9zaXRpb25fY29udGVudChtYXhHaWZ0UHJvZml0KSwgJGkxOG4ubl9jYW5jZWwsICRpMThuLm5fY29uZmlybSwgXCJ2aXNpYmxlXCIsIGFzeW5jIGZ1bmN0aW9uICgpIHtcbiAgICAgICAgICAgICAgICAvLyAg5Y+W5raIXG4gICAgICAgICAgICAgICAgYXdhaXQgY29tbW9uLmFuYWx5dGljcyhcImFwcGNsaWNrX2NvbnRyYWN0c1wiLCB7XG4gICAgICAgICAgICAgICAgICAgIGJ1c2luZXNzX2NhdGVnb3J5OiBcInVzZHRfMF95dWFuX2J1eVwiLFxuICAgICAgICAgICAgICAgICAgICBidXR0b25fbmFtZTogXCJ1c2R0X2NhbmNlbF8wX3l1YW5cIixcbiAgICAgICAgICAgICAgICB9KTtcbiAgICAgICAgICAgIH0sIGFzeW5jIGZ1bmN0aW9uICgpIHtcbiAgICAgICAgICAgICAgICAvLyAg5bmz5LuTXG4gICAgICAgICAgICAgICAgYXdhaXQgY29tbW9uLmFuYWx5dGljcyhcImFwcGNsaWNrX2NvbnRyYWN0c1wiLCB7XG4gICAgICAgICAgICAgICAgICAgIGJ1c2luZXNzX2NhdGVnb3J5OiBcInVzZHRfMF95dWFuX2J1eVwiLFxuICAgICAgICAgICAgICAgICAgICBidXR0b25fbmFtZTogXCJ1c2R0X2NvbmZpcm1fMF95dWFuXCIsXG4gICAgICAgICAgICAgICAgfSk7XG4gICAgICAgICAgICAgICAgc3VyZVBhcml0eVBvc2l0aW9uKGNsb3NlVHlwZSk7XG4gICAgICAgICAgICB9KTtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGF3YWl0IGNvbW1vbi5hbmFseXRpY3MoXCJhcHBjbGlja19jb250cmFjdHNcIiwge1xuICAgICAgICAgICAgICAgIGJ1c2luZXNzX2NhdGVnb3J5OiBcInVzZHRfMF95dWFuX2J1eVwiLFxuICAgICAgICAgICAgICAgIGJ1dHRvbl9uYW1lOiBcInVzZHRfY29uZmlybV9jbG9zZV8wX3l1YW5cIixcbiAgICAgICAgICAgIH0pO1xuICAgICAgICAgICAgc3VyZVBhcml0eVBvc2l0aW9uKGNsb3NlVHlwZSk7XG4gICAgICAgIH1cbiAgICB9XG59XG5cbi8v56Gu6K6k5bmz5LuTICAgUE9TVCAgL2hiZy92MS9hY3Rpdml0eS96ZXJvL3N1cmUvcGFyaXR5L3Bvc2l0aW9uXG5hc3luYyBmdW5jdGlvbiBzdXJlUGFyaXR5UG9zaXRpb24oY2xvc2VUeXBlKSB7XG4gICAgdmFyIGl0ZW0gPSBjdXJMaXN0W21vZHVsZURhdGEuY3VyQ2xvc2VJbmRleF07XG4gICAgdmFyIHBhcmFtID0ge1xuICAgICAgICBwb3NpdGlvbklkOiBpdGVtLmlkLFxuICAgICAgICBvcGVyYXRpb25UeXBlOiBjbG9zZVR5cGVcbiAgICB9XG4gICAgY29uc3QgZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdChcInYxL2FjdGl2aXR5L3plcm8vc3VyZS9wYXJpdHkvcG9zaXRpb25cIiwgcGFyYW0sIDEsIDAsIHsgXCJDb250ZW50LVR5cGVcIjogXCJhcHBsaWNhdGlvbi9qc29uXCIgfSlcbiAgICBpZiAoZGF0YSA9PSBudWxsKSB7XG4gICAgICAgIHJlcXVlc3RQb3NpdGlvbkxpc3QoKTtcbiAgICAgICAgcmV0dXJuXG4gICAgfVxuICAgIGlmICgxID09IGNsb3NlVHlwZSkge1xuICAgICAgICBsZXQgcG5sID0gY29tbW9uLnRvTnVtYmVyKGRhdGEpO1xuICAgICAgICBpZiAocG5sID4gMCkge1xuICAgICAgICAgICAgc2hvd0Nsb3NlUG9zaXRpb25TdWNjZXNzRGlhbG9nKHBubC50b1N0cmluZygpKVxuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgY29tbW9uLnNob3dUb2FzdCgkaTE4bi5uX3plcm9fc3dhcF9jbG9zZV9wb3NpdGlvbl9zdWNjZXNzZnVsKVxuICAgICAgICB9XG4gICAgfVxuXG4gICAgLy/lubPku5PlkI4g5bmz5LuTaXRlbeeahEvnur/ml7blsZXlvIDvvIzliJnlvZPliY3liJfooajmsqHmnInooqvmiZPlvIDnmoQgbGFzdEZvbGRJbmRleOS4ui0xXG4gICAgaWYgKGl0ZW0uZm9sZCkge1xuICAgICAgICBtb2R1bGVEYXRhLmxhc3RGb2xkSW5kZXggPSAtMTtcbiAgICB9XG4gICAgbW9kdWxlRGF0YS5jdXJDbG9zZUluZGV4ID0gLTE7XG4gICAgbW9kdWxlRGF0YS5jbG9zZVBvc2l0aW9uRGF0YSA9IHt9O1xuICAgIGF3YWl0IHJlcXVlc3RQb3NpdGlvbkxpc3QoKTtcbiAgICBhd2FpdCBoZWFkZXJQcm9maXQuYXBwZWFyKCk7XG59XG5cbi8qKlxuICog5pi+56S6IOS7heW5s+S7kyDlvLnmoYZcbiAqIEBwYXJhbSB7SlNPTn0gcGFyYW1zIOW5s+S7k+WPguaVsFxuICovXG5hc3luYyBmdW5jdGlvbiBzaG93Q2xvc2VQb3NpdGlvbk9ubHlEaWFsb2cocGFyYW1zKSB7XG4gICAgbW9kdWxlRGF0YS5jbG9zZVBvc2l0aW9uT25seURpYWxvZyA9IHBhcmFtcztcbn1cblxuLyoqXG4gKiDmmL7npLog55uI5Yip5bmz5LuTIOW8ueahhlxuICogQHBhcmFtIHtzdHJpbmd9IHBubCDlubPku5PmlLbnm4pcbiAqL1xuYXN5bmMgZnVuY3Rpb24gc2hvd0Nsb3NlUG9zaXRpb25TdWNjZXNzRGlhbG9nKHBubCkge1xuICAgIG1vZHVsZURhdGEubG9hZGluZ0xvdHRpZVN0YXR1cyA9IFwicGxheVwiO1xuICAgIG1vZHVsZURhdGEuY2xvc2VQb3NpdGlvblN1Y2Nlc3NEaWFsb2cgPSB7XG4gICAgICAgIFwic2hvd1wiOiBcInRydWVcIixcbiAgICAgICAgXCJwbmxcIjogcG5sICsgXCIgXCIgKyAkaTE4bi5uX3BlcnNvbmFsX2NlbnRlcl9yZXdhcmRfdW5pdCxcbiAgICB9O1xufVxuXG4vKipcbiAqIOmakOiXjyDnm4jliKnlubPku5Mg5by55qGGXG4gKi9cbmFzeW5jIGZ1bmN0aW9uIGhpZGVDbG9zZVBvc2l0aW9uU3VjY2Vzc0RpYWxvZygpIHtcbiAgICBtb2R1bGVEYXRhLmNsb3NlUG9zaXRpb25TdWNjZXNzRGlhbG9nID0ge1xuICAgICAgICBcInNob3dcIjogXCJmYWxzZVwiLFxuICAgICAgICBcInBubFwiOiBcIi0gXCIgKyAkaTE4bi5uX3BlcnNvbmFsX2NlbnRlcl9yZXdhcmRfdW5pdCxcbiAgICB9O1xufVxuXG4vKipcbiAqIOebiOWIqeW5s+S7kyDljrvmn6XnnItcbiAqL1xuYXN5bmMgZnVuY3Rpb24gbmF2aWdhdGlvbkNsb3NlUG9zaXRpb25TdWNjZXNzRGlhbG9nKCkge1xuICAgIGF3YWl0IGNvbW1vbi5hbmFseXRpY3MoXCJhcHBjbGlja19jb250cmFjdHNcIiwge1xuICAgICAgICBidXNpbmVzc19jYXRlZ29yeTogXCJ1c2R0XzBfeXVhbl9idXlcIixcbiAgICAgICAgYnV0dG9uX25hbWU6IFwidXNkdF9nb19jaGVja18wX3l1YW5cIixcbiAgICB9KTtcbiAgICBoaWRlQ2xvc2VQb3NpdGlvblN1Y2Nlc3NEaWFsb2coKVxuICAgIC8vICDljrvmn6XnnItcbiAgICBhd2FpdCBjb21tb24ub3BlblVSTChgaG9saWdlaXQ6Ly9vcGVuL3YxP3VybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vY29udHJhY3QvaW5kZXhgKTtcblxufVxuXG4vKipcbiAqIOWumuaXtuWZqFxuICovXG5sZXQgdGltZXI7XG5cbi8qKlxuICog5Yid5aeL5YCS6K6h5pe25pe26Ze0XG4gKi9cbmxldCByZW1haW5pbmdTZWNvbmRzID0gMDtcblxuLyoqXG4gKiDlvIDlp4vlgJLorqHml7ZcbiAqL1xuYXN5bmMgZnVuY3Rpb24gc3RhcnRDb3VudGRvd24oKSB7XG4gICAgY2FuY2VsQ291bnRkb3duKCk7XG4gICAgY29uc3QgZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdChcInYxL2FjdGl2aXR5L3plcm8vcGFyaXR5L3Byb2ZpdFwiLCB7fSwgMCwgMCwgeyBcIkNvbnRlbnQtVHlwZVwiOiBcImFwcGxpY2F0aW9uL2pzb25cIiB9KVxuICAgIHJlbWFpbmluZ1NlY29uZHMgPSBNYXRoLmZsb29yKChjb21tb24udG9OdW1iZXIoZGF0YS5nb2xkRXhwaXJlVGltZSkpIC8gMTAwMCk7XG4gICAgdGltZXIgPSBzZXRJbnRlcnZhbCgoKSA9PiB7XG4gICAgICAgIGlmIChyZW1haW5pbmdTZWNvbmRzID49IDApIHtcbiAgICAgICAgICAgIGxldCBkYXlzID0gTWF0aC5mbG9vcihyZW1haW5pbmdTZWNvbmRzIC8gKDI0ICogNjAgKiA2MCkpO1xuICAgICAgICAgICAgbGV0IGhvdXJzID0gTWF0aC5mbG9vcigocmVtYWluaW5nU2Vjb25kcyAlICgyNCAqIDYwICogNjApKSAvICg2MCAqIDYwKSk7XG4gICAgICAgICAgICBsZXQgbWludXRlcyA9IE1hdGguZmxvb3IoKHJlbWFpbmluZ1NlY29uZHMgJSAoNjAgKiA2MCkpIC8gNjApO1xuICAgICAgICAgICAgbGV0IHNlY29uZHMgPSByZW1haW5pbmdTZWNvbmRzICUgNjA7XG4gICAgICAgICAgICBkYXlzID0gZGF5cyA8IDEwID8gJzAnICsgZGF5cyA6IGRheXM7XG4gICAgICAgICAgICBob3VycyA9IGhvdXJzIDwgMTAgPyAnMCcgKyBob3VycyA6IGhvdXJzO1xuICAgICAgICAgICAgbWludXRlcyA9IG1pbnV0ZXMgPCAxMCA/ICcwJyArIG1pbnV0ZXMgOiBtaW51dGVzO1xuICAgICAgICAgICAgc2Vjb25kcyA9IHNlY29uZHMgPCAxMCA/ICcwJyArIHNlY29uZHMgOiBzZWNvbmRzO1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5yZWNoYXJnZVJld2FyZHNEaWFsb2dEYXkgPSBkYXlzLnRvU3RyaW5nKCk7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLnJlY2hhcmdlUmV3YXJkc0RpYWxvZ0hvdXIgPSBob3Vycy50b1N0cmluZygpO1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5yZWNoYXJnZVJld2FyZHNEaWFsb2dNaW51dGUgPSBtaW51dGVzLnRvU3RyaW5nKCk7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLnJlY2hhcmdlUmV3YXJkc0RpYWxvZ1NlY29uZCA9IHNlY29uZHMudG9TdHJpbmcoKTtcbiAgICAgICAgICAgIHJlbWFpbmluZ1NlY29uZHMtLTtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGNhbmNlbENvdW50ZG93bigpO1xuICAgICAgICAgICAgY29uc29sZS5sb2coJ+WAkuiuoeaXtue7k+adnycpO1xuICAgICAgICB9XG4gICAgfSwgMTAwMCk7XG59XG5cbi8qKlxuICog5Y+W5raI5YCS6K6h5pe2XG4gKi9cbmZ1bmN0aW9uIGNhbmNlbENvdW50ZG93bigpIHtcbiAgICBpZiAodGltZXIgIT0gbnVsbCkge1xuICAgICAgICBjbGVhckludGVydmFsKHRpbWVyKTtcbiAgICAgICAgdGltZXIgPSBudWxsO1xuICAgICAgICBjb25zb2xlLmxvZygn5YCS6K6h5pe25bey5Y+W5raIJyk7XG4gICAgfVxufVxuXG4vKipcbiAqIOaYvuekuiDlhYXlgLzmi7/lpZblirEg5by55qGGXG4gKiBAcGFyYW0ge251bWJlcn0gc2hvd1R5cGUg5p2l5rqQ57G75Z6LIDA65Zyo6YCU5pS255uKIDE65bmz5LuT5LiU5YWF5YC8XG4gKi9cbmFzeW5jIGZ1bmN0aW9uIHNob3dSZWNoYXJnZVJld2FyZHNEaWFsb2coc2hvd1R5cGUpIHtcbiAgICBpZiAoMCA9PSBzaG93VHlwZSkge1xuICAgICAgICBhd2FpdCBjb21tb24uYW5hbHl0aWNzKFwiYXBwY2xpY2tfY29udHJhY3RzXCIsIHtcbiAgICAgICAgICAgIGJ1c2luZXNzX2NhdGVnb3J5OiBcInVzZHRfMF95dWFuX2J1eVwiLFxuICAgICAgICAgICAgYnV0dG9uX25hbWU6IFwidXNkdF9yZWNoYXJnZV9wcm9tb3Rpb25fMF95dWFuXCIsXG4gICAgICAgIH0pO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIGF3YWl0IGNvbW1vbi5hbmFseXRpY3MoXCJhcHBleHBvc3VyZV9jb250cmFjdHNcIiwge1xuICAgICAgICAgICAgYnVzaW5lc3NfY2F0ZWdvcnk6IFwidXNkdF8wX3l1YW5fYnV5XCIsXG4gICAgICAgICAgICBidXR0b25fbmFtZTogXCJ1c2R0X3JlY2hhcmdlX2V4cG9zdXJlX3BvcF91cFwiLFxuICAgICAgICB9KTtcbiAgICB9XG4gICAgbW9kdWxlRGF0YS5yZWNoYXJnZVJld2FyZHNEaWFsb2dEYXkgPSBcIi0tXCI7XG4gICAgbW9kdWxlRGF0YS5yZWNoYXJnZVJld2FyZHNEaWFsb2dIb3VyID0gXCItLVwiO1xuICAgIG1vZHVsZURhdGEucmVjaGFyZ2VSZXdhcmRzRGlhbG9nTWludXRlID0gXCItLVwiO1xuICAgIG1vZHVsZURhdGEucmVjaGFyZ2VSZXdhcmRzRGlhbG9nU2Vjb25kID0gXCItLVwiO1xuICAgIHN0YXJ0Q291bnRkb3duKCk7XG4gICAgbW9kdWxlRGF0YS5yZWNoYXJnZVJld2FyZHNEaWFsb2cgPSB7XG4gICAgICAgIFwic2hvd1wiOiBcInRydWVcIixcbiAgICAgICAgXCJsZXZlckxpc3RcIjogZ2lmdFN0ZXBMaXN0LFxuICAgICAgICBcImluZGljYXRvckNvbG9yXCI6IGNvbW1vbi5jb21tb25EYXRhLmNvbG9yTW9kZSA9PSAxID8gXCIjMUFFQUVBRUFcIiA6IFwiIzFBMDAwMDAwXCIsXG4gICAgfTtcbn1cblxuLyoqXG4gKiDpmpDol48g5YWF5YC85ou/5aWW5YqxIOW8ueahhlxuICogQHBhcmFtIHtudW1iZXJ9IGNsb3NlVHlwZSDlhbPpl63nsbvlnosgMDrmraPluLjlhbPpl60gMTrlhYXlgLxcbiAqL1xuYXN5bmMgZnVuY3Rpb24gaGlkZVJlY2hhcmdlUmV3YXJkc0RpYWxvZyhjbG9zZVR5cGUpIHtcbiAgICBjYW5jZWxDb3VudGRvd24oKTtcbiAgICBtb2R1bGVEYXRhLnJlY2hhcmdlUmV3YXJkc0RpYWxvZyA9IHtcbiAgICAgICAgXCJzaG93XCI6IFwiZmFsc2VcIixcbiAgICB9O1xuICAgIGlmICgxID09IGNsb3NlVHlwZSkge1xuICAgICAgICBhd2FpdCBjb21tb24uYW5hbHl0aWNzKFwiYXBwY2xpY2tfY29udHJhY3RzXCIsIHtcbiAgICAgICAgICAgIGJ1c2luZXNzX2NhdGVnb3J5OiBcInVzZHRfMF95dWFuX2J1eVwiLFxuICAgICAgICAgICAgYnV0dG9uX25hbWU6IFwidXNkdF9nb19yZWNoYXJnZV8wX3l1YW5cIixcbiAgICAgICAgfSk7XG4gICAgICAgIGF3YWl0IGNvbW1vbi5vcGVuVVJMKGBob2xpZ2VpdDovL29wZW4vdjE/bG9naW49MSZ1cmw9aWh1b2JpZ2xvYmFsOi8vbS5oYmcuY29tL2JhbGFuY2UvdHJhbnNmZXI/Y29pbj1VU0RUJmFjY291bnQ9MTFgKTtcbiAgICB9XG59XG5cbi8qKlxuICog6ZqQ6JePIOS7heW5s+S7kyDlvLnmoYZcbiAqIEBwYXJhbSB7bnVtYmVyfSBjbG9zZVR5cGUg5YWz6Zet57G75Z6LIDA65q2j5bi45YWz6ZetIDE656Gu6K6k5bmz5LuTXG4gKi9cbmFzeW5jIGZ1bmN0aW9uIGhpZGVDbG9zZVBvc2l0aW9uT25seURpYWxvZyhjbG9zZVR5cGUpIHtcbiAgICBtb2R1bGVEYXRhLmNsb3NlUG9zaXRpb25Pbmx5RGlhbG9nU2hvdyA9IFwiZmFsc2VcIjtcblxuICAgIGlmICgwID09IGNsb3NlVHlwZSkge1xuICAgICAgICAvLyAg5q2j5bi45YWz6ZetXG4gICAgfSBlbHNlIGlmICgxID09IGNsb3NlVHlwZSkge1xuICAgICAgICAvLyAg56Gu6K6k5bmz5LuTXG4gICAgICAgIHN1cmVQYXJpdHlQb3NpdGlvbigxKTtcbiAgICAgICAgYXdhaXQgY29tbW9uLmFuYWx5dGljcyhcImFwcGNsaWNrX2NvbnRyYWN0c1wiLCB7XG4gICAgICAgICAgICBidXNpbmVzc19jYXRlZ29yeTogXCJ1c2R0XzBfeXVhbl9idXlcIixcbiAgICAgICAgICAgIGJ1dHRvbl9uYW1lOiBcInVzZHRfY29uZmlybV9jbG9zZV8wX3l1YW5cIixcbiAgICAgICAgfSk7XG4gICAgfVxufVxuXG4vKipcbiAqIOWFheWAvOWlluWKseair+W6plxuICovXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0R2lmdFN0ZXAoKSB7XG4gICAgY29uc3QgZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdChcInYxL2FjdGl2aXR5L3plcm8vZ2lmdC9zdGVwXCIsIHt9LCAwLCAwLCB7IFwiQ29udGVudC1UeXBlXCI6IFwiYXBwbGljYXRpb24vanNvblwiIH0pXG4gICAgaWYgKGRhdGEgPT0gbnVsbCkge1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIGxldCBsZXZlckxpc3QgPSBbXTtcbiAgICBmb3IgKGxldCBpID0gMDsgaSA8IGRhdGEubGVuZ3RoOyBpKyspIHtcbiAgICAgICAgbGV0IHYgPSBkYXRhW2ldO1xuICAgICAgICBsZXQgc3VmZml4ID0gaSA+IDQgPyA0IDogaTtcbiAgICAgICAgbGV2ZXJMaXN0LnB1c2goe1xuICAgICAgICAgICAgXCJyZXdhcmRcIjogYCske3YuZ2lmdEFtb3VudH0gJHskaTE4bi5uX3BlcnNvbmFsX2NlbnRlcl9yZXdhcmRfdW5pdH1gLFxuICAgICAgICAgICAgXCJjb25kaXRpb25cIjogYCR7di5pbmNvbWVBbW91bnR9ICR7JGkxOG4ubl9wZXJzb25hbF9jZW50ZXJfcmV3YXJkX3VuaXR9YCxcbiAgICAgICAgICAgIFwiaW5kaWNhdG9yVmlzaWJpbGl0eVwiOiBpID09IChkYXRhLmxlbmd0aCAtIDEpID8gXCJnb25lXCIgOiBcInZpc2libGVcIixcbiAgICAgICAgICAgIFwiZHJhd2FibGVcIjogYEBkcmF3YWJsZS9lZGdlX2VuZ2luZV96ZXJvX3N3YXBfcmV3YXJkX2xldmVsXyR7c3VmZml4ICsgMX1gLFxuICAgICAgICAgICAgXCJ0eXBlXCI6IFwibm9ybWFsXCJcbiAgICAgICAgfSk7XG4gICAgfVxuICAgIGdpZnRTdGVwTGlzdCA9IGxldmVyTGlzdDtcbn1cblxuLyoqXG4gKiDpobXpnaLkuI3lj6/op4FcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIGRpc2FwcGVhcigpIHtcbiAgICBjYW5jZWxDb3VudGRvd24oKTtcbiAgICBjYW5jZWxJdGVtQ291bnRkb3duKCk7XG59XG5cbm1vZHVsZUV2ZW50Lm9uQXBwZWFyID0gb25BcHBlYXI7XG5tb2R1bGVFdmVudC5jbGlja2VkRm9sZCA9IGNsaWNrZWRGb2xkO1xubW9kdWxlRXZlbnQuY2xpY2tDbG9zZVBvc2l0aW9uID0gY2xpY2tDbG9zZVBvc2l0aW9uO1xubW9kdWxlRXZlbnQuaGlkZUNsb3NlUG9zaXRpb25BY3Rpdml0eURpYWxvZyA9IGhpZGVDbG9zZVBvc2l0aW9uQWN0aXZpdHlEaWFsb2c7XG5tb2R1bGVFdmVudC5zaG93Q2xvc2VQb3NpdGlvbkFjdGl2aXR5RGlhbG9nID0gc2hvd0Nsb3NlUG9zaXRpb25BY3Rpdml0eURpYWxvZztcbm1vZHVsZUV2ZW50Lm5hdmlnYXRpb25DbG9zZVBvc2l0aW9uU3VjY2Vzc0RpYWxvZyA9IG5hdmlnYXRpb25DbG9zZVBvc2l0aW9uU3VjY2Vzc0RpYWxvZztcbm1vZHVsZUV2ZW50LmhpZGVSZWNoYXJnZVJld2FyZHNEaWFsb2cgPSBoaWRlUmVjaGFyZ2VSZXdhcmRzRGlhbG9nO1xubW9kdWxlRXZlbnQuaGlkZUNsb3NlUG9zaXRpb25Pbmx5RGlhbG9nID0gaGlkZUNsb3NlUG9zaXRpb25Pbmx5RGlhbG9nO1xubW9kdWxlRXZlbnQuc2hvd1JlY2hhcmdlUmV3YXJkc0RpYWxvZyA9IHNob3dSZWNoYXJnZVJld2FyZHNEaWFsb2c7XG5tb2R1bGVFdmVudC5oaWRlQ2xvc2VQb3NpdGlvblN1Y2Nlc3NEaWFsb2cgPSBoaWRlQ2xvc2VQb3NpdGlvblN1Y2Nlc3NEaWFsb2c7XG4iLCJpbXBvcnQgKiBhcyBjb21tb24gZnJvbSBcIi4vY29tbW9uXCI7XG5cbnZhciBwYWdlTnVtID0gMVxudmFyIGN1ckxpc3QgPSBbXTtcblxuZnVuY3Rpb24gZGVmYXVsdERhdGEoKSB7XG4gICAgcmV0dXJuIHtcbiAgICAgICAgaGlzdG9yeVBvc2l0aW9uTGlzdDogW10sXG4gICAgICAgIGxpc3RWaWV3VmlzaWJpbGl0eTogXCJ2aXNpYmxlXCIsXG4gICAgICAgIGVtcHR5Vmlld1Zpc2liaWxpdHk6IFwiZ29uZVwiLFxuICAgICAgICByZWZyZXNoU3RhdHVzOiBcIjJcIixcbiAgICAgICAgbG9hZE1vcmVTdGF0dXM6IFwiMFwiLFxuICAgIH07XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHN0YXJ0KCkge1xuXG59XG5cbmNvbnN0IHsgbW9kdWxlRGF0YSwgbW9kdWxlRXZlbnQgfSA9IGNvbW1vbi5tb2R1bGVEZWZpbmUoXCJoaXN0b3J5UG9zaXRpb25cIiwgc3RhcnQsIGRlZmF1bHREYXRhKTtcblxuYXN5bmMgZnVuY3Rpb24gb25SZWZyZXNoKCkge1xuICAgIGF3YWl0IHJlcXVlc3RQb3NpdGlvbkxpc3QoZmFsc2UpO1xufVxuXG5hc3luYyBmdW5jdGlvbiBvbkxvYWRNb3JlKCkge1xuICAgIGlmIChtb2R1bGVEYXRhLnRvdGFsID4gbW9kdWxlRGF0YS5oaXN0b3J5UG9zaXRpb25MaXN0Lmxlbmd0aCkge1xuICAgICAgICBhd2FpdCByZXF1ZXN0UG9zaXRpb25MaXN0KHRydWUpO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIG1vZHVsZURhdGEubG9hZE1vcmVTdGF0dXMgPSBcIjJcIjtcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIG9uQXBwZWFyKCkge1xuICAgIGF3YWl0IGNvbW1vbi5hbmFseXRpY3MoXCJhcHBjbGlja19jb250cmFjdHNcIiwge1xuICAgICAgICBidXNpbmVzc19jYXRlZ29yeTogXCJ1c2R0XzBfeXVhbl9idXlcIixcbiAgICAgICAgYnV0dG9uX25hbWU6IFwidXNkdF9oaXN0b3J5XzBfeXVhblwiLFxuICAgIH0pO1xuICAgIHJlcXVlc3RQb3NpdGlvbkxpc3QoZmFsc2UpO1xufVxuXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0UG9zaXRpb25MaXN0KGlzTW9yZSkge1xuICAgIGlmICghaXNNb3JlKSB7XG4gICAgICAgIHBhZ2VOdW0gPSAxXG4gICAgfSBlbHNlIHtcbiAgICAgICAgcGFnZU51bSArPSAxXG4gICAgfVxuICAgIHZhciBwYXJhbSA9IHtcbiAgICAgICAgc3RhdGU6IDIsXG4gICAgICAgIHBhZ2VOdW06IHBhZ2VOdW0sXG4gICAgICAgIHBhZ2VTaXplOiAxMFxuICAgIH1cbiAgICBjb25zdCBkYXRhID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KFwidjEvYWN0aXZpdHkvemVyby9wb3NpdGlvbi9saXN0XCIsIHBhcmFtLCAwLCAwLCB7IFwiQ29udGVudC1UeXBlXCI6IFwiYXBwbGljYXRpb24vanNvblwiIH0pXG4gICAgaWYgKCFkYXRhIHx8IGRhdGEgPT0gbnVsbCB8fCAhZGF0YS5saXN0IHx8IGRhdGEubGlzdCA9PSBudWxsIHx8IGRhdGEubGlzdC5sZW5ndGggPT0gMCkge1xuICAgICAgICBpZiAocGFnZU51bSA9PSAxKSB7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLnJlZnJlc2hTdGF0dXMgPSBcIjJcIjtcbiAgICAgICAgICAgIHNldExpc3RWaXNpYmxlKGZhbHNlKTtcbiAgICAgICAgICAgIGN1ckxpc3QgPSBbXTtcbiAgICAgICAgICAgIG1vZHVsZURhdGEuaGlzdG9yeVBvc2l0aW9uTGlzdCA9IFtdO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgcGFnZU51bSAtPSAxXG4gICAgICAgICAgICBtb2R1bGVEYXRhLmxvYWRNb3JlU3RhdHVzID0gXCIyXCJcbiAgICAgICAgfVxuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIGlmIChwYWdlTnVtID09IDEpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5yZWZyZXNoU3RhdHVzID0gMlxuICAgIH0gZWxzZSB7XG4gICAgICAgIG1vZHVsZURhdGEubG9hZE1vcmVTdGF0dXMgPSAyXG4gICAgfVxuICAgIHNldExpc3RWaXNpYmxlKHRydWUpO1xuICAgIHRyeSB7XG4gICAgICAgIGNvbnN0IHsgdG90YWwsIGxpc3QgfSA9IGRhdGE7XG4gICAgICAgIG1vZHVsZURhdGEudG90YWwgPSB0b3RhbDtcbiAgICAgICAgaGFuZGxlSGlzdG9yeVBvc2l0aW9uRGF0YShsaXN0KTtcbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGBoYW5kbGUgcmVxdWVzdFBvc2l0aW9uTGlzdCBkYXRhIGVycm9yPSR7ZX1gKTtcbiAgICB9XG59XG5cbmZ1bmN0aW9uIHNldExpc3RWaXNpYmxlKHZpc2libGUpIHtcbiAgICBpZiAodHJ1ZSA9PSB2aXNpYmxlKSB7XG4gICAgICAgIG1vZHVsZURhdGEubGlzdFZpZXdWaXNpYmlsaXR5ID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgIG1vZHVsZURhdGEuZW1wdHlWaWV3VmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgIH1cbiAgICBlbHNlIHtcbiAgICAgICAgbW9kdWxlRGF0YS5saXN0Vmlld1Zpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICAgICAgbW9kdWxlRGF0YS5lbXB0eVZpZXdWaXNpYmlsaXR5ID0gXCJ2aXNpYmxlXCI7XG4gICAgfVxufVxuXG4vKipcbiAqIOWkhOeQhuWOhuWPsuaVsOaNrlxuICovXG5mdW5jdGlvbiBoYW5kbGVIaXN0b3J5UG9zaXRpb25EYXRhKGxpc3QpIHtcbiAgICBmb3IgKGxldCBpID0gMDsgaSA8IGxpc3QubGVuZ3RoOyArK2kpIHtcbiAgICAgICAgbGV0IHYgPSBsaXN0W2ldO1xuICAgICAgICB2YXIgc3RyQXJyYXkgPSB2LnN5bWJvbC5zcGxpdCgnLScpO1xuICAgICAgICBsZXQgYmFzZUNjeSA9IHN0ckFycmF5WzBdLnRvVXBwZXJDYXNlKCk7XG4gICAgICAgIGxldCBxdW90ZUNjeSA9IHN0ckFycmF5WzFdLnRvVXBwZXJDYXNlKCk7XG4gICAgICAgIC8vICDov4fmnJ/oh6rliqjlubPku5NcbiAgICAgICAgaWYgKDMgPT0gdi5wb3NpdGlvblN0YXR1cykge1xuICAgICAgICAgICAgdi50eXBlID0gXCIyXCI7XG4gICAgICAgICAgICB2LnRpdGxlID0gJGkxOG4ubl96ZXJvX3N3YXBfcG9zaXRpb25fcmVjbGFpbWVkO1xuICAgICAgICAgICAgdi5jbG9zZVRpbWVOYW1lID0gJGkxOG4ubl96ZXJvX3N3YXBfcG9zaXRpb25fcmVjb3ZlcnlfdGltZTtcbiAgICAgICAgfSBlbHNlIGlmICg0ID09IHYucG9zaXRpb25TdGF0dXMpIHtcbiAgICAgICAgICAgIHYudHlwZSA9IFwiMlwiO1xuICAgICAgICAgICAgdi50aXRsZSA9ICRpMThuLm5femVyb19zd2FwX3Bvc2l0aW9uX2xpcXVpZGF0aW9uO1xuICAgICAgICAgICAgdi5jbG9zZVRpbWVOYW1lID0gJGkxOG4ubl96ZXJvX3N3YXBfcG9zaXRpb25fcmVjb3ZlcnlfdGltZTtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIC8vICDlubPku5NcbiAgICAgICAgICAgIHYudHlwZSA9IFwiMVwiO1xuICAgICAgICAgICAgdi50aXRsZSA9ICRpMThuLm5femVyb19zd2FwX3Bvc2l0aW9uX2Nsb3NlZDtcbiAgICAgICAgICAgIHYucG5sTmFtZSA9ICRpMThuLm5fY29udHJhY3RfcHJvZml0ICsgXCIoXCIgKyBxdW90ZUNjeSArIFwiKVwiO1xuICAgICAgICAgICAgLy8gIOWIpOaWreaYr+WQpuWkp+S6jjAgXG4gICAgICAgICAgICB2LnBubCA9IGZvcm1hdE51bWJlclNpZ24odi5wb3NpdGlvblByb2ZpdCk7XG4gICAgICAgICAgICB2LnBubENvbG9yID0gdHJlbmRDb2xvclNjaGVtZSh2LnBvc2l0aW9uUHJvZml0KVxuICAgICAgICAgICAgdi5wbmxSYXRpb05hbWUgPSAkaTE4bi5uX2NvbnRyYWN0X3lpZWxkO1xuICAgICAgICAgICAgdi5wbmxSYXRpbyA9IGZvcm1hdE51bWJlclNpZ24odi5wcm9maXRSYXRlKSArIFwiJVwiO1xuICAgICAgICAgICAgdi5wbmxSYXRpb0NvbG9yID0gdHJlbmRDb2xvclNjaGVtZSh2LnByb2ZpdFJhdGUpXG4gICAgICAgICAgICB2LmNsb3NlQXZnUHhOYW1lID0gJGkxOG4ubl9jb250cmFjdF9zaGFyZV9oaXN0b3J5X3Bvc2l0aW9uX2Nsb3NlX3ByaWNlICsgYCgke3F1b3RlQ2N5fSlgXG4gICAgICAgICAgICB2LmNsb3NlQXZnUHggPSB2LnBhcml0eVByaWNlO1xuICAgICAgICAgICAgdi5jbG9zZVRpbWVOYW1lID0gJGkxOG4ubl9jb3B5X3RyYWRpbmdfY2xvc2VfdGltZTtcbiAgICAgICAgfVxuICAgICAgICB2Lmljb24gPSBjb21tb24uZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3koYmFzZUNjeSlcbiAgICAgICAgdi5zeW1ib2wgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fY29udHJhY3Rfc3dhcF90cmFkZV9uYW1lKGAke2Jhc2VDY3l9JHtxdW90ZUNjeX1gKTtcbiAgICAgICAgaWYgKHYuZGlyZWN0aW9uID09IDEpIHtcbiAgICAgICAgICAgIHYucG9zU2lkZSA9ICRpMThuLm5fYXNzZXRfZnV0dXJlX2J1eTtcbiAgICAgICAgICAgIHYucG9zU2lkZUNvbG9yID0gY29tbW9uLmdldFVwRG93bkNvbG9yKCk7XG4gICAgICAgICAgICB2LnBvc1NpZGViYWNrQ29sb3IgPSBjb21tb24uZ2V0SGFuZGljYXBDb2xvcigpO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgdi5wb3NTaWRlID0gJGkxOG4ubl9hc3NldF9mdXR1cmVfc2VsbDtcbiAgICAgICAgICAgIHYucG9zU2lkZUNvbG9yID0gY29tbW9uLmdldFVwRG93bkNvbG9yKGZhbHNlKTtcbiAgICAgICAgICAgIHYucG9zU2lkZWJhY2tDb2xvciA9IGNvbW1vbi5nZXRIYW5kaWNhcENvbG9yKGZhbHNlKTtcbiAgICAgICAgfVxuICAgICAgICB2Lm1hcmdpbk1vZGUgPSAkaTE4bi5uX2NvbnRyYWN0X3RyYWRlX21hcmdpbjtcbiAgICAgICAgdi5sZXZlciA9IGAke3YubGV2ZXJhZ2VSYXRpb31YYDtcbiAgICAgICAgdi5zek5hbWUgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fY29udGFyY3RfcG9zaXRpb25fdm9sdW1lX2xhYmVsKGJhc2VDY3kpO1xuICAgICAgICB2LnN6ID0gdi5wb3NpdGlvbkFtb3VudDtcbiAgICAgICAgdi5vcGVuQXZnUHhOYW1lID0gJGkxOG4uJGludGVyY2VwdC5uX2xpbmVhcl9zd2FwX29wZW5fcHJpY2UocXVvdGVDY3kpO1xuICAgICAgICB2Lm9wZW5BdmdQeCA9IHYub3BlblByaWNlO1xuICAgICAgICB2Lm9wZW5UaW1lTmFtZSA9ICRpMThuLm5fY29weV90cmFkaW5nX29wZW5fdGltZTtcbiAgICAgICAgdi5vcGVuVGltZSA9IG5ldyBEYXRlKHYuY3JlYXRlZEF0KS5Gb3JtYXQoXCJ5eXl5LU1NLWRkIGhoOm1tOnNzXCIpO1xuICAgICAgICB2LmNsb3NlVGltZSA9IG5ldyBEYXRlKHYucGFyaXR5VGltZSkuRm9ybWF0KFwieXl5eS1NTS1kZCBoaDptbTpzc1wiKTtcblxuICAgICAgICBpZiAocGFnZU51bSA+IDEpIHtcbiAgICAgICAgICAgIGN1ckxpc3QucHVzaCh2KVxuICAgICAgICB9XG4gICAgfVxuICAgIGlmIChwYWdlTnVtID09IDEpIHtcbiAgICAgICAgY3VyTGlzdCA9IGxpc3RcbiAgICB9XG4gICAgbW9kdWxlRGF0YS5oaXN0b3J5UG9zaXRpb25MaXN0ID0gY3VyTGlzdDtcbn1cblxuLyoqXG4gKiDmmK/lkKbmmK/mlbDlrZdcbiAqIEBwYXJhbSB7c3RyfSBzdHIgXG4gKiBAcmV0dXJucyBcbiAqL1xuZnVuY3Rpb24gaXNOdW1lcmljKHN0cikge1xuICAgIGlmICh0eXBlb2Ygc3RyICE9PSAnc3RyaW5nJykgcmV0dXJuIGZhbHNlO1xuICAgIHJldHVybiAhaXNOYU4oc3RyKSAmJiAhaXNOYU4ocGFyc2VGbG9hdChzdHIpKTtcbn1cblxuZnVuY3Rpb24gZm9ybWF0TnVtYmVyU2lnbihudW1iZXJTdHIpIHtcbiAgICAvLyDliKTmlq3pgLvovpFcbiAgICBpZiAoaXNOdW1lcmljKG51bWJlclN0cikpIHtcbiAgICAgICAgY29uc3QgbnVtID0gcGFyc2VGbG9hdChudW1iZXJTdHIpO1xuICAgICAgICBpZiAobnVtID4gMCkge1xuICAgICAgICAgICAgcmV0dXJuIGArJHtudW19YDtcbiAgICAgICAgfSBlbHNlIGlmIChudW0gPCAwKSB7XG4gICAgICAgICAgICByZXR1cm4gYCR7bnVtfWA7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICByZXR1cm4gYDBgO1xuICAgICAgICB9XG4gICAgfSBlbHNlIHtcbiAgICAgICAgcmV0dXJuICctLSc7XG4gICAgfVxufVxuXG4vKipcbiAqIOiOt+WPlui2i+WKv+minOiJsuaWueahiFxuICogQHBhcmFtIHtzdHJpbmd8bnVtYmVyfSBudW1iZXJTdHIgLSDmlbDlgLzlrZfnrKbkuLLmiJbmlbDlgLxcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue6aKc6Imy55qE57G75Z6LXG4gKi9cbmZ1bmN0aW9uIHRyZW5kQ29sb3JTY2hlbWUobnVtYmVyU3RyKSB7XG4gICAgLy8gIDA6IOe6oua2qOe7v+i3jCwgMTog57u/5rao57qi6LeMXG4gICAgbGV0IGNvbG9yVHlwZSA9IGNvbW1vbi5jb21tb25EYXRhLnByaWNlQ29sb3JUeXBlO1xuXG4gICAgY29uc3QgZGVmYXVsdENvbG9yID0gJ0Bjb2xvci9rQ29sb3JQcmljZUdyZWVuJztcblxuICAgIC8vIOagoemqjCBudW1iZXJTdHIg5piv5ZCm5Li656m65oiW6Z2e5rOVXG4gICAgaWYgKG51bWJlclN0ciA9PSBudWxsIHx8IG51bWJlclN0ciA9PT0gJycpIHtcbiAgICAgICAgcmV0dXJuIGRlZmF1bHRDb2xvcjtcbiAgICB9XG5cbiAgICAvLyDlsJ3or5XlsIbovpPlhaXovazkuLrmta7ngrnmlbBcbiAgICBjb25zdCBudW0gPSBwYXJzZUZsb2F0KG51bWJlclN0cik7XG4gICAgaWYgKGlzTmFOKG51bSkpIHtcbiAgICAgICAgcmV0dXJuIGRlZmF1bHRDb2xvcjtcbiAgICB9XG5cbiAgICBpZiAoY29sb3JUeXBlID09PSAwKSB7XG4gICAgICAgIHJldHVybiBudW0gPj0gMCA/ICdAY29sb3Iva0NvbG9yUHJpY2VSZWQnIDogJ0Bjb2xvci9rQ29sb3JQcmljZUdyZWVuJztcbiAgICB9IGVsc2Uge1xuICAgICAgICByZXR1cm4gbnVtID49IDAgPyAnQGNvbG9yL2tDb2xvclByaWNlR3JlZW4nIDogJ0Bjb2xvci9rQ29sb3JQcmljZVJlZCc7XG4gICAgfVxufVxuXG5tb2R1bGVFdmVudC5vbkFwcGVhciA9IG9uQXBwZWFyO1xubW9kdWxlRXZlbnQub25SZWZyZXNoID0gb25SZWZyZXNoO1xubW9kdWxlRXZlbnQub25Mb2FkTW9yZSA9IG9uTG9hZE1vcmU7IiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiO1xuaW1wb3J0ICogYXMgY29tbW9uUG9wIGZyb20gXCIuL2NvbW1vblBvcFwiO1xuaW1wb3J0ICogYXMgcG9zaXRpb24gZnJvbSBcIi4vcG9zaXRpb25cIjtcbmltcG9ydCAqIGFzIGhlYWRlclByb2ZpdCBmcm9tIFwiLi9oZWFkZXJQcm9maXRcIjtcbmltcG9ydCAqIGFzIG9wZW5Qb3NpdGlvbiBmcm9tIFwiLi9vcGVuUG9zaXRpb25cIjtcbmltcG9ydCAqIGFzIGhpc3RvcnlQb3NpdGlvbiBmcm9tIFwiLi9oaXN0b3J5UG9zaXRpb25cIjtcblxuZnVuY3Rpb24gc2VuZENvbW1vbkNvbmZpZyhwYXJhbSkge1xuICAgIGNvbW1vbi5zZW5kQ29tbW9uQ29uZmlnKHBhcmFtKTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gbW9kdWxlQXBwZWFyKCkge1xuICAgIGNvbnNvbGUubG9nKCdtYWluLW1vZHVsZUFwcGVhcicpO1xuICAgIGhlYWRlclByb2ZpdC5hcHBlYXIoKTtcbiAgICBjb21tb24uc3ViUHJpY2VXZWJTb2NrZXQoXCJsaW5lYXJTd2FwV3NcIik7XG59XG5cbmZ1bmN0aW9uIG1vZHVsZVdpbGxEaXNhcHBlYXIoKSB7XG4gICAgY29uc29sZS5sb2coJ21haW4tbW9kdWxlV2lsbERpc2FwcGVhcicpO1xufVxuXG5hc3luYyBmdW5jdGlvbiBtb2R1bGVEaXNhcHBlYXIoKSB7XG4gICAgY29uc29sZS5sb2coJ21haW4tbW9kdWxlRGlzYXBwZWFyJyk7XG4gICAgY29tbW9uLnVuc3ViUHJpY2VXZWJTb2NrZXQoXCJsaW5lYXJTd2FwV3NcIik7XG4gICAgaGVhZGVyUHJvZml0LmRpc2FwcGVhcigpO1xuICAgIG9wZW5Qb3NpdGlvbi5kaXNhcHBlYXIoKTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gc2VuZFNvY2tldERhdGEoZGF0YSkge1xuICAgICBpZiAoZGF0YS50eXBlID09IFwibGluZWFyU3dhcFdzXCIpIHtcbiAgICAgICAgY29tbW9uLmNvbW1vbkRhdGEubGluZWFyU3dhcFdzRGF0YSA9IEpTT04ucGFyc2UoZGF0YS5kYXRhKTtcbiAgICAgICAgb3BlblBvc2l0aW9uLnJlZnJlc2hQcm9maXQoKTtcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlcXVlc3RQb3NpdGlvbkxpc3QoKSB7XG4gICAgb3BlblBvc2l0aW9uLnJlcXVlc3RQb3NpdGlvbkxpc3QoKTtcbn1cblxuJGV2ZW50LnNlbmRDb21tb25Db25maWcgPSBzZW5kQ29tbW9uQ29uZmlnO1xuJGV2ZW50LnNlbmRTb2NrZXREYXRhID0gc2VuZFNvY2tldERhdGE7XG4kZXZlbnQubW9kdWxlQXBwZWFyID0gbW9kdWxlQXBwZWFyO1xuJGV2ZW50Lm1vZHVsZURpc2FwcGVhciA9IG1vZHVsZURpc2FwcGVhcjtcbiRldmVudC5tb2R1bGVXaWxsRGlzYXBwZWFyID0gbW9kdWxlV2lsbERpc2FwcGVhcjtcbiRldmVudC5yZXF1ZXN0UG9zaXRpb25MaXN0ID0gcmVxdWVzdFBvc2l0aW9uTGlzdDsiXSwibmFtZXMiOlsiRFAiLCJSTSIsIk1BWF9EUCIsIk1BWF9QT1dFUiIsIk5FIiwiUEUiLCJOQU1FIiwiSU5WQUxJRCIsIklOVkFMSURfRFAiLCJJTlZBTElEX1JNIiwiRElWX0JZX1pFUk8iLCJQIiwiVU5ERUZJTkVEIiwiTlVNRVJJQyIsIl9CaWdfIiwiQmlnIiwibiIsIngiLCJ0aGlzIiwicyIsImUiLCJjIiwic2xpY2UiLCJwYXJzZSIsImNvbnN0cnVjdG9yIiwicHJvdG90eXBlIiwidmVyc2lvbiIsImkiLCJubCIsInRlc3QiLCJFcnJvciIsImNoYXJBdCIsImluZGV4T2YiLCJyZXBsYWNlIiwic2VhcmNoIiwic3Vic3RyaW5nIiwibGVuZ3RoIiwicm91bmQiLCJkcCIsInJtIiwibW9yZSIsInhjIiwidW5zaGlmdCIsInBvcCIsInN0cmluZ2lmeSIsImlkIiwiayIsInoiLCJwdXNoIiwiam9pbiIsImFicyIsImNtcCIsInkiLCJpc25lZyIsInljIiwiaiIsImwiLCJkaXYiLCJhIiwiYiIsImJsIiwiYnQiLCJyaSIsImJ6IiwiYWkiLCJhbCIsInIiLCJybCIsInEiLCJxYyIsInFpIiwiZCIsInNoaWZ0IiwiZXEiLCJndCIsImd0ZSIsImx0IiwibHRlIiwibWludXMiLCJzdWIiLCJ0IiwieGx0eSIsInBsdXMiLCJ4ZSIsInllIiwicmV2ZXJzZSIsIm1vZCIsInlndHgiLCJ0aW1lcyIsImFkZCIsInBvdyIsIm9uZSIsInNxcnQiLCJoYWxmIiwiTWF0aCIsInRvRXhwb25lbnRpYWwiLCJtdWwiLCJBcnJheSIsInRvRml4ZWQiLCJ0b1ByZWNpc2lvbiIsInNkIiwidG9TdHJpbmciLCJ2YWx1ZU9mIiwidG9KU09OIiwic3VidHJhY3QiLCJtdWx0aXBseSIsImRpdmlkZSIsImZvcm1hdCIsInZhbHVlIiwicHJlY2lzaW9uIiwiYmlnVmFsdWUiLCJzdHJpbmdWYWx1ZSIsInNjaWVudGlmaWNUb051bWJlciIsImluY2x1ZGVzIiwic3RyQXJyYXkiLCJzcGxpdCIsInRydW5jYXRlIiwiemVyb051bWJlciIsInN0ciIsImJpZ251bWJlciIsImFyciIsImlzQXJyYXkiLCJtYXAiLCJudW0iLCJ6ZXJvIiwicGFydHMiLCJTdHJpbmciLCJ0b0xvd2VyQ2FzZSIsInplcm9MZW4iLCJzaWduIiwiYmVmb3JlQXJyIiwiZGVjIiwiY2xpY2thYmxlIiwiVW5pdFR5cGUiLCJ1bml0VHlwZVN5bWJvbCIsInVuaXRUeXBlVVNEVCIsIlRhYlR5cGUiLCJ0YWJUeXBlUG9zaXRpb24iLCJ0YWJUeXBlT3Blbk9yZGVycyIsInRhYlR5cGVPcmRlcnMiLCJ0YWJUeXBlSGlzdG9yeSIsInVwQ29sb3JMaXN0IiwiZG93bkNvbG9yTGlzdCIsImNvbW1vbkRhdGEiLCJ1c2VyU2lnbiIsImN1cnJlbnRTeW1ib2wiLCJjdXJyZW50Q29udHJhY3RJbmZvIiwiY29udHJhY3RJbmZvRGF0YSIsImNvbnRyYWN0SDVVcmwiLCJjdXJyZW5jeVJhdGUiLCJjdXJyZW5jeUNoYXJhY3RlciIsInByaWNlQ29sb3JUeXBlIiwiY29sb3JNb2RlIiwiT1MiLCJhcHBWZXJzaW9uIiwiaXNJblJldmlldyIsImlzTG9naW4iLCJ3ZWJVcmwiLCJsYW5ndWFnZSIsImxpbmVhclN3YXBXc0RhdGEiLCJ1bml0VHlwZSIsImxhc3RVbml0VHlwZSIsIm9wZW5TaW5nbGVNYXJnaW4iLCJjdXJUYWJUeXBlIiwiaXNDaGlsZCIsImJvdHRvbUJhckhlaWdodCIsImFzeW5jIiwic3ViUHJpY2VXZWJTb2NrZXQiLCJ0eXBlIiwiJG5hdGl2ZUFQSSIsImNvcHlUcmFkaW5nQnJpZGdlIiwiYWN0aW9uIiwidW5zdWJQcmljZVdlYlNvY2tldCIsImdldE1vZGVsQnlDb250cmFjdFNob3J0VHlwZSIsImNvbnRyYWN0U2hvcnRUeXBlIiwiY29udHJhY3Rfc2hvcnRfdHlwZSIsImdldFByaWNlVGlja1ByZWNpc2lvbiIsImNvbnRyYWN0SW5mbyIsInNpemVTdHJpbmciLCJudW1iZXIuYmlnbnVtYmVyIiwicHJpY2VfdGljayIsInNlbmRSZXF1ZXN0IiwicGF0aCIsInBhcmFtcyIsIm1ldGhvZCIsImhvc3RUeXBlIiwiaGVhZGVyIiwicmV0dXJuU3RhdHVzIiwiY29uc29sZSIsImxvZyIsIkpTT04iLCJwYXJhbSIsInJlc3BvbnNlU3RyaW5nIiwicmVxdWVzdCIsInJlc3BvbnNlIiwiY29kZSIsImRhdGEiLCJzdGF0dXMiLCJlcnJfY29kZSIsImVycl9tc2ciLCJzdGFydCIsInN0YXJ0SW5kZXgiLCJlbmQiLCJlbmRJbmRleCIsImRhdGFTdHJpbmciLCJzaG93VG9hc3QiLCJtZXNzYWdlIiwiZm9ybWF0UHJlY2lzaW9uIiwicmVzdWx0IiwibnVtYmVyLmZvcm1hdCIsIm9wZW5VUkwiLCJ1cmwiLCJvcGVuUm91dGUiLCJzZXRUaW1lb3V0IiwibXNnIiwiaGJUb2FzdCIsInNlbmRDb21tb25Db25maWciLCJwYXJzZUludCIsInJlZENvbG9yTGlzdCIsImdyZWVuQ29sb3JMaXN0IiwiZ2V0VXBEb3duQ29sb3IiLCJpc1VwcGVyIiwibGV2ZWwiLCJsZXYiLCJtb2R1bGVEZWZpbmUiLCJtb2R1bGVOYW1lIiwic3RhcnRGdW5jdGlvbiIsImRlZmF1bHREYXRhRnVuY3Rpb24iLCIkZGF0YSIsIiRldmVudCIsIm1vZHVsZUV2ZW50IiwibW9kdWxlRGF0YSIsIkRhdGUiLCJGb3JtYXQiLCJmbXQiLCJvIiwiZ2V0TW9udGgiLCJnZXREYXRlIiwiZ2V0SG91cnMiLCJnZXRNaW51dGVzIiwiZ2V0U2Vjb25kcyIsImZsb29yIiwiUyIsImdldE1pbGxpc2Vjb25kcyIsIlJlZ0V4cCIsIiQxIiwiZ2V0RnVsbFllYXIiLCJzdWJzdHIiLCJzaG93TG9hZGluZyIsImlzU2hvdyIsImdldFBOR0ljb25VUkxCeUN1cnJlbmN5IiwiY3VycmVuY3kiLCJiYXNlVXJsIiwiYW5hbHl0aWNzIiwiZXZlbnQiLCJwcm9wZXJ0aWVzIiwicHJvcGVydGllc0pzb24iLCJ0b051bWJlciIsIm9iaiIsIk51bWJlciIsImlzTmFOIiwiZ2V0SGFuZGljYXBDb2xvciIsImlzTG9uZyIsImNvbG9yVHlwZSIsImlzSW52YWxpZFN0cmluZyIsIm9uZUNhbGxiYWNrIiwibGVmdENhbGxiYWNrIiwicmlnaHRDYWxsYmFjayIsImRlZmF1bHREYXRhIiwidGl0bGVWaXNpYmlsaXR5Iiwib25lQnV0dG9uVmlzaWJpbGl0eSIsInR3b0J1dHRvblZpc2liaWxpdHkiLCJjZW50ZXJCdXR0b25UZXh0IiwiJGkxOG4iLCJuX2NvcHlfdHJhZGluZ19tZV9rbm93IiwibGVmdEJ1dHRvblRleHQiLCJuX2NhbmNlbCIsInJpZ2h0QnV0dG9uVGV4dCIsIm5fc3VyZSIsInBvcFRpdGxlIiwibl9jb3B5X3RyYWRpbmdfdGlwIiwicG9wQ29udGVudCIsInRvYXN0VHlwZSIsInBvcFNob3ciLCJjb21tb24ubW9kdWxlRGVmaW5lIiwicG9wVXBDb250ZW50T2ZPbmVCdXR0b24iLCJ0aXRsZSIsImNvbmV0ZW50IiwiY2VudGVyVGV4dCIsIm9uZUJ0bkNhbGxCYWNrIiwicG9wVXBDb250ZW50T2ZUd29CdXR0b24iLCJjb250ZW50IiwibGVmdFRleHQiLCJyaWdodFRleHQiLCJsZWZ0QnRuQ2FsbGJhY2siLCJyaWdodEJ0bkNhbGxiYWNrIiwicG9wRGlzbWlzcyIsImJ0bkNsaWNrIiwic2hvd0FjdGl2aXR5UnVsZURpYWxvZyIsImNvbW1vbi5hbmFseXRpY3MiLCJidXNpbmVzc19jYXRlZ29yeSIsImJ1dHRvbl9uYW1lIiwicnVsZXMiLCJuX3plcm9fc3dhcF9hY3Rpdml0eV9ydWxlX2NvbnRlbnRfMSIsIm5femVyb19zd2FwX2FjdGl2aXR5X3J1bGVfY29udGVudF8yIiwibl96ZXJvX3N3YXBfYWN0aXZpdHlfcnVsZV9jb250ZW50XzMiLCJuX3plcm9fc3dhcF9hY3Rpdml0eV9ydWxlX2NvbnRlbnRfNCIsIm5femVyb19zd2FwX2FjdGl2aXR5X3J1bGVfY29udGVudF81IiwiY29tbW9uUG9wLnBvcFVwQ29udGVudE9mT25lQnV0dG9uIiwibl96ZXJvX3N3YXBfYWN0aXZpdHlfcnVsZV90aXRsZSIsImJhbm5lckN1cnJlbnRJbmRleCIsImJhbm5lckxpc3QiLCJiYW5uZXJWaXNpYmlsaXR5IiwiYmFubmVyQW5kcm9pZFN0cm9rZVZpc2liaWxpdHkiLCJjb21tb24uY29tbW9uRGF0YSIsImJhbm5lckluZGljYXRvckxpc3QiLCJiYW5uZXJJbmRpY2F0b3JWaXNpYmlsaXR5IiwiYmFubmVyQXV0b1Njcm9sbCIsInBubCIsImFjdGl2aXR5UG5sVmlzaWJpbGl0eSIsImFjdGl2aXR5UG5sIiwiJGludGVyY2VwdCIsIm5femVyb19zd2FwX3JlY2hhcmdlX3Byb2ZpdCIsImFjdGl2aXR5Q291bnREb3duVGltZSIsIm5fZGF5IiwidGFiSW5mbyIsIm5femVyb19zd2FwX215X3Bvc2l0aW9uIiwibl9leGNoYW5nZV9vcmRlcl9oaXN0b3J5X29yZGVycyIsInRpbWVyIiwicmVtYWluaW5nU2Vjb25kcyIsInN0YXJ0Q291bnRkb3duIiwiY2FuY2VsQ291bnRkb3duIiwic2V0SW50ZXJ2YWwiLCJkYXlzIiwiaG91cnMiLCJtaW51dGVzIiwic2Vjb25kcyIsImNsZWFySW50ZXJ2YWwiLCJyZXF1ZXN0SGVhZGVyUHJvZml0IiwiY29tbW9uLnNlbmRSZXF1ZXN0IiwidG90YWxQcm9maXQiLCJwb3NpdGlvblByb2ZpdCIsImdvbGRTdGF0dXMiLCJjb21tb24udG9OdW1iZXIiLCJnb2xkRXhwaXJlVGltZSIsIm5femVyb19zd2FwX3JlY2hhcmdlX3Jld2FyZCIsImFwcGVhciIsInJlcXVlc3RCYW5uZXJJbmZvIiwiZGlzYXBwZWFyIiwic2VsZWN0ZWRCYW5uZXJJbmRleCIsImluZGV4IiwiaGFuZGxlU2xpZGVySW5kaWNhdG9yVmlldyIsImJhbm5lckNsaWNrQmFubmVyIiwiY29tbW9uLmlzSW52YWxpZFN0cmluZyIsImp1bXBUbyIsImNvbW1vbi5vcGVuVVJMIiwiYmFubmVyX2lkIiwiYWR2SWQiLCJiYW5uZXJfbmFtZSIsInBhZ2VUeXBlIiwic2hvd1R5cGUiLCJiYW5uZXJBZHZMaXN0IiwidiIsImN1cnJlbnRJbWFnZVVSTCIsIm5pZ2h0SW1hZ2VVcmwiLCJpbWFnZVVybCIsImhhbmRsZVNsaWRlclZpZXciLCJsaXN0IiwiaW5kaWNhdG9yTGlzdCIsImdldFByb2ZpdCIsIm9wZW5QcmljZSIsImxhdGVzdFByaWNlIiwiYW1vdW50IiwiZGlyZWN0aW9uIiwiZGVsdGEiLCJudW1iZXIuc3VidHJhY3QiLCJwcm9maXQiLCJjb21tb24uZm9ybWF0UHJlY2lzaW9uIiwibnVtYmVyLm11bHRpcGx5IiwiZ2V0UHJvZml0UmF0ZSIsImxldmVyUmF0ZSIsInJhdGlvIiwibnVtYmVyLmRpdmlkZSIsInByb2ZpdFJhdGUiLCJwcm9maXRSYXRlU3RyIiwiZ2V0UG9zaXRpb25WYWx1ZSIsImdldFVucmVhbGl6ZWRQcm9maXRPckxvc3MiLCJnZXRNYXJnaW5SYXRlIiwibWFyZ2luIiwicG9zaXRpb25WYWx1ZSIsInZhbHVlMSIsInZhbHVlMiIsIm51bWJlci5hZGQiLCJtYXJnaW5SYXRlIiwibWFyZ2luUmF0ZVN0ciIsImdldExpcXVpZGF0aW9uUHJpY2UiLCJ2YWx1ZTMiLCJjdXJMaXN0IiwiZ2lmdFN0ZXBMaXN0IiwiaXRlbVRpbWVyIiwidG90YWxDb3VudGRvd25TZWNvbmRzIiwiaXNSZXF1ZXN0IiwibG9hZGluZ0xvdHRpZVN0YXR1cyIsIm9wZW5Qb3NpdGlvbkxpc3QiLCJsaXN0Vmlld1Zpc2liaWxpdHkiLCJvc0xpc3RWaWV3VmlzaWJpbGl0eSIsImVtcHR5Vmlld1Zpc2liaWxpdHkiLCJjdXJDbG9zZUluZGV4IiwibGFzdEZvbGRJbmRleCIsImNsb3NlUG9zaXRpb25EYXRhIiwiY2xvc2VQb3NpdGlvbkFjdGl2aXR5RGlhbG9nTWF4UG5sUHJlZml4Iiwibl96ZXJvX3N3YXBfcHJvZml0X2Nsb3NlX3Bvc2l0aW9uIiwiY2xvc2VQb3NpdGlvbkFjdGl2aXR5RGlhbG9nIiwibl9wZXJzb25hbF9jZW50ZXJfcmV3YXJkX3VuaXQiLCJwbmxDb2xvciIsIm1heFBubCIsIm1heEFjdGl2aXR5UG5sIiwibl96ZXJvX3N3YXBfaGlnaGVzdF9saW1pdGVkX3RpbWVfcmV3YXJkIiwib25seUNsb3NlUG9zaXRpb25QbmwiLCJuX3plcm9fc3dhcF9vYnRhaW5faW1tZWRpYXRlbHkiLCJwcm9maXRWaXNpYmlsaXR5IiwibG9zc1Zpc2liaWxpdHkiLCJjbG9zZVBvc2l0aW9uQWN0aXZpdHlEaWFsb2dTaG93IiwiY2xvc2VQb3NpdGlvblN1Y2Nlc3NEaWFsb2ciLCJzaG93IiwicmVjaGFyZ2VSZXdhcmRzRGlhbG9nIiwiaW5kaWNhdG9yQ29sb3IiLCJsZXZlckxpc3QiLCJyZWNoYXJnZVJld2FyZHNEaWFsb2dEYXkiLCJyZWNoYXJnZVJld2FyZHNEaWFsb2dIb3VyIiwicmVjaGFyZ2VSZXdhcmRzRGlhbG9nTWludXRlIiwicmVjaGFyZ2VSZXdhcmRzRGlhbG9nU2Vjb25kIiwiY2xvc2VQb3NpdGlvbk9ubHlEaWFsb2ciLCJjbG9zZVBvc2l0aW9uT25seURpYWxvZ1Nob3ciLCJjb21tb24uc2hvd0xvYWRpbmciLCJyZXF1ZXN0Q29udHJhY3RJbmZvRGF0YSIsInJlcXVlc3RQb3NpdGlvbkxpc3QiLCJyZXF1ZXN0R2lmdFN0ZXAiLCJidXNpbmVzc190eXBlIiwidHJhZGVfcGFydGl0aW9uIiwicmVzcERhdGEiLCJzdGF0ZSIsInBhZ2VOdW0iLCJwYWdlU2l6ZSIsInNldExpc3RWaXNpYmxlIiwidG90YWwiLCJoYW5kbGVPcGVuUG9zaXRpb25EYXRhIiwidmlzaWJsZSIsInN5bWJvbCIsImJhc2VDdXJyZW5jeSIsInRvVXBwZXJDYXNlIiwicXVvdGVDdXJyZW5jeSIsImRheVVuaXQiLCJpY29uIiwiY29tbW9uLmdldFBOR0ljb25VUkxCeUN1cnJlbmN5IiwiZGlzUGxheVN5bWJvbCIsIm5fY29udHJhY3Rfc3dhcF90cmFkZV9uYW1lIiwia2xpbmVUaXRsZSIsIm5fbWFya2V0X2NvbnRyYWN0X3N3YXBfdHJhZGVfbmFtZV9hYmJyIiwibl96ZXJvX3N3YXBfa2xpbmVfY2hhcnQiLCJtYXJnaW5Nb2RlIiwibl9jb250cmFjdF90cmFkZV9tYXJnaW4iLCJsZXZlciIsImxldmVyYWdlUmF0aW8iLCJwbmxOYW1lIiwibl9jb250cmFjdF9wcm9maXQiLCJwb3NpdGlvbkFtb3VudFRpdGxlIiwibl9jb250YXJjdF9wb3NpdGlvbl92b2x1bWVfbGFiZWwiLCJtYXJnaW5OYW1lIiwibl9ib25kIiwib3BlbkF2Z1B4TmFtZSIsIm5fbGluZWFyX3N3YXBfb3Blbl9wcmljZSIsImxpcVB4TmFtZSIsIm5fbGluZWFyX3N3YXBfcHJlZGljdGlvbl9vZl9zdHJvbmdfcGFyaXR5IiwibWFyZ2luUmF0aW9OYW1lIiwibl9hc3NldF9tYXJnaW5fcmF0ZSIsInBubFJhdGlvTmFtZSIsIm5fY29udHJhY3RfeWllbGQiLCJwb3NTaWRlIiwibl9hc3NldF9mdXR1cmVfYnV5IiwicG9zU2lkZUNvbG9yIiwiY29tbW9uLmdldFVwRG93bkNvbG9yIiwicG9zU2lkZWJhY2tDb2xvciIsImNvbW1vbi5nZXRIYW5kaWNhcENvbG9yIiwibl9hc3NldF9mdXR1cmVfc2VsbCIsInBvc2l0aW9uQW1vdW50Iiwib3BlbkF2Z1B4IiwicG9zaXRpb25NYXJnaW4iLCJzaG93Q2hhcnQiLCJ1cGRvd25JbWFnZSIsImZvbGQiLCJwb3NpdGlvbkZpbmlzaFRpbWUiLCJkYXkiLCJob3VyIiwibWludXRlIiwic2Vjb25kIiwiZWZmZWN0aXZlVGltZVZpc2liaWxpdHkiLCJuX3plcm9fc3dhcF9wb3NpdGlvbl9lZmZlY3RpdmVfcGVyaW9kIiwiY2xvc2VWaXNpYmlsaXR5Iiwic2hvd0Nsb3NlIiwibl96ZXJvX3N3YXBfcG9zaXRpb25faGFzX2V4cGlyZWQiLCJkZWFsUHJpY2VDYWxjdWxhdGlvbiIsInVwZGF0ZU9TRGF0YSIsInN0YXJ0SXRlbUNvdW50ZG93biIsImNhbmNlbEl0ZW1Db3VudGRvd24iLCJwb3NpdGlvbkxpc3QiLCJvbkFwcGVhciIsImNvbW1vbi5zdWJQcmljZVdlYlNvY2tldCIsInJlZnJlc2hQcm9maXQiLCJPYmplY3QiLCJnZXRPd25Qcm9wZXJ0eU5hbWVzIiwidXBkYXRlQ2xvc2VQb3NpdGlvbiIsInVzZVByaWNlIiwicHJpY2UiLCJ1bmRlZmluZWQiLCJjYWxjdWxhdG9yLmdldFByb2ZpdCIsInBhcnNlRmxvYXQiLCJoaWdoZXN0UHJvZml0IiwibGltaXRUaXBzIiwibl96ZXJvX3N3YXBfbGltaXRfdGlwcyIsImNhbGN1bGF0b3IuZ2V0UHJvZml0UmF0ZSIsInBubFJhdGlvIiwiY29tbW9uLmdldE1vZGVsQnlDb250cmFjdFNob3J0VHlwZSIsImNvbW1vbi5nZXRQcmljZVRpY2tQcmVjaXNpb24iLCJsaXFQeCIsImNhbGN1bGF0b3IuZ2V0TGlxdWlkYXRpb25QcmljZSIsIm1hcmdpblJhdGlvIiwiY2FsY3VsYXRvci5nZXRNYXJnaW5SYXRlIiwiY2xpY2tlZEZvbGQiLCJsYXN0Rm9sZEl0ZW0iLCJzZWxlY3RJdGVtIiwiY2xpY2tDbG9zZVBvc2l0aW9uIiwiaXRlbSIsInBvc2l0aW9uSWQiLCJoYXNHaWZ0IiwidXBkYXRlQ2xvc2VQb3NpdGlvbkFjdGl2aXR5RGlhbG9nIiwidXBkYXRlQ2xvc2VQb3NpdGlvbk9ubHlEaWFsb2ciLCJvbmx5Q2xvc2VQcm9maXQiLCJtYXhHaWZ0UHJvZml0Iiwic2hvd0Nsb3NlUG9zaXRpb25BY3Rpdml0eURpYWxvZyIsInNob3dDbG9zZVBvc2l0aW9uT25seURpYWxvZyIsImhpZGVDbG9zZVBvc2l0aW9uQWN0aXZpdHlEaWFsb2ciLCJjbG9zZVR5cGUiLCJzdXJlUGFyaXR5UG9zaXRpb24iLCJzaG93UmVjaGFyZ2VSZXdhcmRzRGlhbG9nIiwiY29tbW9uUG9wLnBvcFVwQ29udGVudE9mVHdvQnV0dG9uIiwibl96ZXJvX3N3YXBfb25seV9jbG9zZV9wb3NpdGlvbl90aXRsZSIsIm5femVyb19zd2FwX29ubHlfY2xvc2VfcG9zaXRpb25fY29udGVudCIsIm5fY29uZmlybSIsIm9wZXJhdGlvblR5cGUiLCJzaG93Q2xvc2VQb3NpdGlvblN1Y2Nlc3NEaWFsb2ciLCJjb21tb24uc2hvd1RvYXN0Iiwibl96ZXJvX3N3YXBfY2xvc2VfcG9zaXRpb25fc3VjY2Vzc2Z1bCIsImhlYWRlclByb2ZpdC5hcHBlYXIiLCJoaWRlQ2xvc2VQb3NpdGlvblN1Y2Nlc3NEaWFsb2ciLCJuYXZpZ2F0aW9uQ2xvc2VQb3NpdGlvblN1Y2Nlc3NEaWFsb2ciLCJoaWRlUmVjaGFyZ2VSZXdhcmRzRGlhbG9nIiwiaGlkZUNsb3NlUG9zaXRpb25Pbmx5RGlhbG9nIiwic3VmZml4IiwicmV3YXJkIiwiZ2lmdEFtb3VudCIsImNvbmRpdGlvbiIsImluY29tZUFtb3VudCIsImluZGljYXRvclZpc2liaWxpdHkiLCJkcmF3YWJsZSIsImhpc3RvcnlQb3NpdGlvbkxpc3QiLCJyZWZyZXNoU3RhdHVzIiwibG9hZE1vcmVTdGF0dXMiLCJvblJlZnJlc2giLCJvbkxvYWRNb3JlIiwiaXNNb3JlIiwiaGFuZGxlSGlzdG9yeVBvc2l0aW9uRGF0YSIsImJhc2VDY3kiLCJxdW90ZUNjeSIsInBvc2l0aW9uU3RhdHVzIiwibl96ZXJvX3N3YXBfcG9zaXRpb25fcmVjbGFpbWVkIiwiY2xvc2VUaW1lTmFtZSIsIm5femVyb19zd2FwX3Bvc2l0aW9uX3JlY292ZXJ5X3RpbWUiLCJuX3plcm9fc3dhcF9wb3NpdGlvbl9saXF1aWRhdGlvbiIsIm5femVyb19zd2FwX3Bvc2l0aW9uX2Nsb3NlZCIsImZvcm1hdE51bWJlclNpZ24iLCJ0cmVuZENvbG9yU2NoZW1lIiwicG5sUmF0aW9Db2xvciIsImNsb3NlQXZnUHhOYW1lIiwibl9jb250cmFjdF9zaGFyZV9oaXN0b3J5X3Bvc2l0aW9uX2Nsb3NlX3ByaWNlIiwiY2xvc2VBdmdQeCIsInBhcml0eVByaWNlIiwibl9jb3B5X3RyYWRpbmdfY2xvc2VfdGltZSIsInN6TmFtZSIsInN6Iiwib3BlblRpbWVOYW1lIiwibl9jb3B5X3RyYWRpbmdfb3Blbl90aW1lIiwib3BlblRpbWUiLCJjcmVhdGVkQXQiLCJjbG9zZVRpbWUiLCJwYXJpdHlUaW1lIiwiaXNOdW1lcmljIiwibnVtYmVyU3RyIiwiZGVmYXVsdENvbG9yIiwiY29tbW9uLnNlbmRDb21tb25Db25maWciLCJtb2R1bGVBcHBlYXIiLCJtb2R1bGVXaWxsRGlzYXBwZWFyIiwibW9kdWxlRGlzYXBwZWFyIiwiY29tbW9uLnVuc3ViUHJpY2VXZWJTb2NrZXQiLCJoZWFkZXJQcm9maXQuZGlzYXBwZWFyIiwib3BlblBvc2l0aW9uLmRpc2FwcGVhciIsInNlbmRTb2NrZXREYXRhIiwib3BlblBvc2l0aW9uLnJlZnJlc2hQcm9maXQiLCJvcGVuUG9zaXRpb24ucmVxdWVzdFBvc2l0aW9uTGlzdCJdLCJtYXBwaW5ncyI6IkFBaUJBLElBQUlBLEtBQUssSUFVUEMsS0FBSyxHQUdMQyxTQUFTLEtBR1RDLFlBQVksS0FPWkMsTUFBTSxHQVFOQyxLQUFLLElBT0xDLE9BQU8sYUFDUEMsVUFBVUQsT0FBTyxZQUNqQkUsYUFBYUQsVUFBVSxrQkFDdkJFLGFBQWFGLFVBQVUsaUJBQ3ZCRyxjQUFjSixPQUFPLG9CQUdyQkssSUFBSSxDQUFFLEdBQ05DLGlCQUFpQixHQUNqQkMsVUFBVTs7QUFPWixTQUFTQztJQVFQLFNBQVNDLElBQUlDO1FBQ1gsSUFBSUMsSUFBSUM7UUFHUixNQUFNRCxhQUFhRixNQUFNLE9BQU9DLE1BQU1KLFlBQVlFLFVBQVUsSUFBSUMsSUFBSUM7UUFHcEUsSUFBSUEsYUFBYUQsS0FBSztZQUNw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
