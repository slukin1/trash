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

function multiply(x, y) {
    return new Big(x).times(y).toString();
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

const TabType$1 = {
    tabTypePosition: "position",
    tabTypeOpenOrders: "openOrders",
    tabTypeOrders: "orders",
    tabTypeHistory: "history"
};

const DEFAULT_STR = "0.00";

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
    curTabType: TabType$1.tabTypePosition,
    isChild: false
};

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

async function sendRequestReturnCode(path, params = {}, method = 0, hostType = 0, header = {}) {
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
                return code;
            } else {
                console.log(`request failed, code=${err_code}, message=${err_msg}`);
                if (method != 0) {
                    showToast(err_msg);
                }
                return code;
            }
        } else if (code == 200) {
            console.log(`request ${path} done`);
            return code;
        } else {
            console.log(`request failed, code=${code}`);
            let message = response["err-msg"];
            if (method != 0 && message) {
                showToast(message);
            }
            return code;
        }
    } catch (e) {
        console.log(`request error, error=${e}`);
        return 0;
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

async function getEqualLegalCurrencyAmount(currency, amount) {
    if (!amount) {
        amount = "0";
    }
    const param = {
        type: 1,
        currency: currency,
        amount: amount
    };
    const paramString = JSON.stringify(param);
    return thousandsFormatter(await $nativeAPI.currencyCommon(paramString) + "");
}

async function getLegalCurrencySymbol() {
    const currencySymbol = await $nativeAPI.currencyCommon('{"type":9}');
    return currencySymbol;
}

async function addCurrentCurrencySymbol(source) {
    const symbol = await getLegalCurrencySymbol();
    return addCurrencySymbol(symbol, source);
}

function addCurrencySymbol(currencySymbol, source) {
    if (source === "--") {
        return source;
    } else if (source && source !== DEFAULT_STR) {
        if (source.startsWith("-")) {
            return `-${currencySymbol}${source.substring(1)}`;
        }
        return `${currencySymbol}${source}`;
    } else {
        return `${currencySymbol}${DEFAULT_STR}`;
    }
}

async function getAccountId() {
    const accounts = await sendRequest("v1/account/accounts", {}, 0, 4);
    console.log(`margin-home getAccountId 111 accounts = ${accounts}, json = ${JSON.stringify(accounts)}`);
    if (accounts == null || accounts.length == 0) {
        console.log(`margin-home getAccountId 222`);
        return;
    }
    for (let i = 0; i < accounts.length; i++) {
        let account = accounts[i];
        console.log(`margin-home getAccountId account = ${JSON.stringify(account)}`);
        if (account.type == "super-margin") {
            commonData.superMarginAccountId = account.id;
            console.log(`margin-home getAccountId superMarginAccountId = ${commonData.superMarginAccountId}`);
        } else if (account.type == "margin") {
            commonData.marginAccountId = account.id;
            console.log(`margin-home getAccountId marginAccountId = ${commonData.marginAccountId}`);
        }
    }
    console.log(`margin-home getAccountId end`);
}

async function getCurrencyList(type) {
    var requestType = type == 0 ? 1 : 2;
    let currencyList = await sendRequest("v1/hbg/super-margin/currency-list-v2", {
        type: requestType
    }, 0, 4);
    if (type == 0) {
        commonData.loanCurrencyList = currencyList;
    } else {
        commonData.repayCurrencyList = currencyList;
    }
}

async function getSymbolList(type) {
    var requestType = type == 0 ? 1 : 2;
    let symbolList = await sendRequest("v1/hbg/margin/symbol-list-v2", {
        type: requestType
    }, 0, 4);
    if (type == 0) {
        commonData.loanSymbolList = symbolList;
    } else {
        commonData.repaySymbolList = symbolList;
    }
}

async function formatThousands(number) {
    if (number === "--") {
        return number;
    }
    const params = {
        type: 53,
        number: number
    };
    return await $nativeAPI.currencyCommon(JSON.stringify(params));
}

async function formatDecimal(str, precision, needThousands) {
    if (str.length === 0 || isNaN(str)) {
        return "0";
    }
    str += "";
    if (str.includes(".")) {
        var decimal = str.split(".")[1];
        if (decimal && decimal.length > precision) {
            str = str.replace("." + decimal, "." + decimal.slice(0, precision));
            return needThousands ? await formatThousands(str) : str;
        }
    }
    return needThousands ? await formatThousands(str + "") : str + "";
}

function thousandsFormatter(number) {
    let [integerPart, decimalPart] = number.toString().split(".");
    integerPart = integerPart.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    if (decimalPart) {
        return integerPart + "." + decimalPart;
    } else {
        return integerPart;
    }
}

async function showDatePicker(param) {
    const data = await $nativeAPI.showDatePicker(JSON.stringify(param));
    if (data && data != "") {
        return data;
    }
    return null;
}

async function getSymbolDisplayName(symbol) {
    const data = await $nativeAPI.getSpotSymbolModel(symbol);
    const symbolModel = JSON.parse(data);
    if (symbolModel && symbolModel != "") {
        return symbolModel.symbolName;
    }
    return "--";
}

async function uploadLog(tag, info = "") {
    var map = {
        tag: tag,
        info: info
    };
    await $nativeAPI.uploadLog(map);
}

let oneCallback;

let leftCallback;

let rightCallback;

async function start$3() {}

function defaultData$3() {
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

const {moduleData: moduleData$3, moduleEvent: moduleEvent$3} = moduleDefine("commonPop", start$3, defaultData$3);

function popUpContentOfOneButton(title, conetent, centerText, titleVisibility = "visible", oneBtnCallBack = null) {
    oneCallback = oneBtnCallBack;
    moduleData$3.oneButtonVisibility = "visible";
    moduleData$3.twoButtonVisibility = "gone";
    moduleData$3.titleVisibility = titleVisibility;
    if (title && title !== null) {
        moduleData$3.popTitle = title;
    }
    if (conetent && conetent !== null) {
        moduleData$3.popContent = conetent;
    }
    if (centerText && centerText !== null) {
        moduleData$3.centerButtonText = centerText;
    }
    if (!moduleData$3.popShow) {
        moduleData$3.popShow = true;
    }
}

function popUpContentOfTwoButton(type, title, content, leftText, rightText, titleVisibility = "visible", leftBtnCallback = null, rightBtnCallback) {
    leftCallback = leftBtnCallback;
    rightCallback = rightBtnCallback;
    moduleData$3.oneButtonVisibility = "gone";
    moduleData$3.twoButtonVisibility = "visible";
    moduleData$3.titleVisibility = titleVisibility;
    if (title && title !== null) {
        moduleData$3.popTitle = title;
    }
    if (content && content !== null) {
        moduleData$3.popContent = content;
    }
    if (leftText && leftText !== null) {
        moduleData$3.leftButtonText = leftText;
    }
    if (rightText && rightText !== null) {
        moduleData$3.rightButtonText = rightText;
    }
    moduleData$3.toastType = type;
    if (!moduleData$3.popShow) {
        moduleData$3.popShow = true;
    }
}

moduleEvent$3.popDismiss = function() {
    moduleData$3.popShow = false;
};

moduleEvent$3.btnClick = function(type) {
    moduleData$3.popShow = false;
    if (type == 0 && oneCallback != null) {
        oneCallback();
    } else if (type == 1 && leftCallback != null) {
        leftCallback();
    } else if (type == 2 && rightCallback != null) {
        rightCallback();
    }
};

let callBack;

let currentMarginType = 1;

let tempList = [];

const Edit_Board_SelectColor$1 = "@color/kColorMajorTheme100";

const Edit_Board_NormalColor = "@color/KBaseColorContentBackground";

let historySearchList = [];

function defaultData$2() {
    return {
        popData: [],
        showCurrencyPop: "false",
        currencyListVisible: "invisible",
        currencyEmptyVisible: "gone",
        borderColor: Edit_Board_NormalColor,
        searchWord: "",
        titleText: $i18n.n_margin_currency_list,
        searchCoinsHistory: [],
        showHistory: "gone"
    };
}

async function start$2() {}

const {moduleData: moduleData$2, moduleEvent: moduleEvent$2} = moduleDefine("selectCurrencyPop", start$2, defaultData$2);

async function showPop(pageType, marginType, listener) {
    callBack = listener;
    moduleData$2.searchWord = "";
    currentMarginType = marginType;
    if (marginType == 1) {
        moduleData$2.popTitle = $i18n.n_margin_select_currency;
        moduleData$2.searchHint = $i18n.n_earn_search_coin;
    } else {
        moduleData$2.popTitle = $i18n.n_margin_select_currency_pair;
        moduleData$2.searchHint = $i18n.n_margin_search_currency;
    }
    tempList = [];
    let tempHistoryList = [];
    if (marginType == 1) {
        tempHistoryList = await read("margin", "historyCross");
        moduleData$2.titleText = $i18n.n_margin_currency_list;
        for (let i = 0; i < commonData.currencyList.length; i++) {
            let tempData = commonData.currencyList[i];
            let debt = `${Number(tempData.balance)}`;
            moduleData$2.titleDesc = $i18n.n_margin_assets;
            if (pageType == 1) {
                debt = `${Number(tempData.debt)}`;
                moduleData$2.titleDesc = $i18n.n_margin_liabilities_amount;
            }
            tempList.push({
                type: "cross",
                index: i.toString(),
                icon: getPNGIconURLByCurrency(tempData.currency),
                currency: tempData.currency,
                currencyText: tempData.currency.toUpperCase(),
                debt: thousandsFormatter(debt),
                debtAmount: await addCurrentCurrencySymbol(await getEqualLegalCurrencyAmount(tempData.currency, debt))
            });
        }
    } else {
        tempHistoryList = await read("margin", "historyIsolated");
        moduleData$2.titleText = $i18n.n_margin_symbol_list;
        for (let i = 0; i < commonData.symbolList.length; i++) {
            let tempData = commonData.symbolList[i];
            let baseDebt = `${Number(tempData["base-balance"])}`;
            let quotaDebt = `${Number(tempData["quota-balance"])}`;
            moduleData$2.titleDesc = $i18n.n_margin_assets;
            if (pageType == 1) {
                baseDebt = `${Number(tempData["base-debt"])}`;
                quotaDebt = `${Number(tempData["quota-debt"])}`;
                moduleData$2.titleDesc = $i18n.n_margin_liabilities_amount;
            }
            tempList.push({
                type: "isolated",
                index: i.toString(),
                icon: getPNGIconURLByCurrency(tempData["base-currency"]),
                symbol: tempData.symbol,
                displaySymbol: tempData["display-symbol"],
                currency: tempData["base-currency"],
                currencyText: tempData["base-currency"].toUpperCase(),
                quotaCurrency: tempData["quota-currency"].toUpperCase(),
                baseDebt: thousandsFormatter(baseDebt),
                quotaDebt: thousandsFormatter(quotaDebt),
                baseDebtAmount: await addCurrentCurrencySymbol(await getEqualLegalCurrencyAmount(tempData["base-currency"], baseDebt)),
                quotaDebtAmount: await addCurrentCurrencySymbol(await getEqualLegalCurrencyAmount(tempData["quota-currency"], quotaDebt))
            });
        }
    }
    if (tempHistoryList != null) {
        historySearchList = tempHistoryList;
    } else {
        historySearchList = [];
    }
    if (historySearchList != null && historySearchList.length > 0) {
        moduleData$2.historySearchList = historySearchList;
        moduleData$2.showHistory = "visible";
    } else {
        moduleData$2.showHistory = "gone";
    }
    if (tempList.length > 0) {
        moduleData$2.popData = tempList;
        moduleData$2.currencyListVisible = "visible";
        moduleData$2.currencyEmptyVisible = "gone";
    } else {
        moduleData$2.currencyListVisible = "gone";
        moduleData$2.currencyEmptyVisible = "visible";
    }
    moduleData$2.showCurrencyPop = "true";
}

function initHistoryShow() {
    if (historySearchList != null && historySearchList.length > 0 && moduleData$2.searchWord.trim() == "") {
        moduleData$2.showHistory = "visible";
    } else {
        moduleData$2.showHistory = "gone";
    }
}

moduleEvent$2.clickHistory = function(text) {
    moduleData$2.searchWord = text;
    filterList$1();
};

moduleEvent$2.clearHistory = function() {
    if (currentMarginType == 1) {
        clear("margin", "historyCross");
    } else {
        clear("margin", "historyIsolated");
    }
    historySearchList = [];
    moduleData$2.historySearchList = [];
    moduleData$2.showHistory = "gone";
};

moduleEvent$2.currencyPopDismiss = function() {
    moduleData$2.showCurrencyPop = "false";
};

moduleEvent$2.filterCurrency = function(index) {
    console.log(`margin-home filterCurrency index = ${index}`);
    console.log(`margin-home filterCurrency callBack = ${callBack}`);
    let tempData = tempList[index];
    let searchKey = "";
    if (currentMarginType == 1) {
        searchKey = tempData.currency.toUpperCase();
    } else {
        searchKey = tempData.displaySymbol.toUpperCase();
    }
    if (!historySearchList.some((item => item.text === searchKey))) {
        historySearchList.unshift({
            text: searchKey,
            type: "normal"
        });
        while (historySearchList.length > 3) {
            historySearchList.pop();
        }
        if (currentMarginType == 1) {
            save("margin", "historyCross", historySearchList);
        } else {
            save("margin", "historyIsolated", historySearchList);
        }
        moduleData$2.historySearchList = historySearchList;
    }
    if (callBack != null) {
        callBack(currentMarginType, tempData.currency, tempData.symbol);
    }
    moduleData$2.isFocus = false;
    moduleData$2.showCurrencyPop = "false";
};

moduleEvent$2.onFocusChange = async function(isFocus) {
    moduleData$2.isFocus = isFocus;
    console.log(`wp onFocusChange isFocus=${isFocus}`);
    moduleData$2.borderColor = currentBoarderColor$1(isFocus);
    moduleData$2.clearVisible = isFocus ? "visible" : "gone";
};

moduleEvent$2.onTextChange = function() {
    filterList$1();
};

function filterList$1() {
    if (tempList.length == 0) return;
    let searchKey = moduleData$2.searchWord.trim();
    if (searchKey == "") {
        moduleData$2.popData = tempList;
    }
    initHistoryShow();
    moduleData$2.popData = tempList.filter((function(item) {
        if (currentMarginType == 1) {
            return item.currencyText.toLowerCase().includes(moduleData$2.searchWord.trim().toLowerCase());
        } else {
            return item.displaySymbol.toLowerCase().includes(moduleData$2.searchWord.trim().toLowerCase());
        }
    }));
    if (moduleData$2.popData == null || moduleData$2.popData.length == 0) {
        moduleData$2.currencyListVisible = "gone";
        moduleData$2.currencyEmptyVisible = "visible";
    } else {
        moduleData$2.currencyListVisible = "visible";
        moduleData$2.currencyEmptyVisible = "gone";
    }
}

function currentBoarderColor$1(isFocus) {
    return isFocus ? Edit_Board_SelectColor$1 : Edit_Board_NormalColor;
}

moduleEvent$2.clickedClear = function() {
    moduleData$2.searchWord = "";
    moduleData$2.popData = tempList;
    if (moduleData$2.popData == null || moduleData$2.popData.length == 0) {
        moduleData$2.currencyListVisible = "gone";
        moduleData$2.currencyEmptyVisible = "visible";
    } else {
        moduleData$2.currencyListVisible = "visible";
        moduleData$2.currencyEmptyVisible = "gone";
    }
    initHistoryShow();
};

var titleColor_Normal$1 = "@color/kColorThreeLevelText";

var titleColor_Selected$1 = "@color/kColorPrimaryText";

var marginSelectBtnBg = "@color/KBaseColorContentBackground";

var marginUnselectBtnBg = "#00000000";

const CROSS_MARGIN_LADDER_LENDING = "ladder-lending/h5/cross-margin/?name=";

const MARGIN_LADDER_LENDING = "ladder-lending/h5/margin/?name=";

var marginCross = {};

var marginIsolated = {};

var superMarginCurrency = {};

var marginSymbol = {};

var tempPageData = [ {
    type: "normal"
}, {
    type: "normal"
} ];

var firstInit = true;

var firstShowPop = true;

function defaultData$1() {
    return {
        statusBarConfig: {
            statusBarMode: "true",
            adStatusBarColor: "KBaseColorContentBackground"
        },
        titleData: [ {
            type: "normal",
            title: $i18n.n_margin_loan,
            titleColor: titleColor_Selected$1,
            tag: 0
        }, {
            type: "normal",
            title: $i18n.n_margin_repay,
            titleColor: titleColor_Normal$1,
            tag: 1
        } ],
        currentTag: "1",
        currentIndex: "0",
        pageType: 1,
        symbol: "",
        currency: "",
        isLoanBtnRight: false,
        loanMarginType: 1,
        loanIsolatedType: 1,
        loanCrossCheckBtnBg: marginSelectBtnBg,
        loanCrossCheckBtnTextColor: titleColor_Selected$1,
        loanIsolatedCheckBtnBg: marginUnselectBtnBg,
        loanIsolatedCheckBtnTextColor: titleColor_Normal$1,
        loanBaseBtnBgColor: "@color/kColorMajorTheme006",
        loanBaseBorderColor: "@color/kColorMajorTheme100",
        loanQuotaBtnBgColor: "@color/kColorInputFill",
        loanQuotaBorderColor: "@color/kColorInputFill",
        loanConfirmBtnBg: "@color/eColorInputFillDisabled",
        loanConfirmBtnTextColor: "@color/kColorThreeLevelText",
        loanEditBorderColor: "@color/kColorInputFill",
        loanEditText: "",
        loanErrorVisible: "gone",
        isLoanEditFocus: false,
        isRepayBtnRight: false,
        repayMarginType: 1,
        repayIsolatedType: 1,
        repayCrossCheckBtnBg: marginSelectBtnBg,
        repayCrossCheckBtnTextColor: titleColor_Selected$1,
        repayIsolatedCheckBtnBg: marginUnselectBtnBg,
        repayIsolatedCheckBtnTextColor: titleColor_Normal$1,
        repayBaseBtnBgColor: "@color/kColorMajorTheme006",
        repayBaseBorderColor: "@color/kColorMajorTheme100",
        repayQuotaBtnBgColor: "@color/kColorInputFill",
        repayQuotaBorderColor: "@color/kColorInputFill",
        repayConfirmBtnBg: "@color/eColorInputFillDisabled",
        repayConfirmBtnTextColor: "@color/kColorThreeLevelText",
        repayEditBorderColor: "@color/kColorInputFill",
        repayEditText: "",
        repayErrorVisible: "gone",
        isRepayEditFocus: false,
        pageData: []
    };
}

async function start$1() {}

const {moduleData: moduleData$1, moduleEvent: moduleEvent$1} = moduleDefine("home", start$1, defaultData$1);

moduleEvent$1.onCreate = async function(eventParams) {
    initAllData();
    const params = JSON.parse(eventParams);
    console.log("margin-home - onCreate:%o", eventParams);
    try {
        moduleData$1.pageType = params.type;
        if (params.type == 1) {
            moduleData$1.loanMarginType = parseInt(params.marginType);
        } else {
            moduleData$1.repayMarginType = parseInt(params.marginType);
        }
        moduleData$1.symbol = params.symbol;
        moduleData$1.currency = params.currency;
        marginSymbol = params.symbol;
        superMarginCurrency = params.currency;
        moduleData$1.currentIndex = parseInt(params.type) - 1;
        getAccountId();
        resetSelectTabView(parseInt(params.type) - 1);
        initData();
    } catch (e) {
        console.log(`margin-home - onCreate error=${e}`);
    }
};

moduleEvent$1.onResume = async function() {
    if (firstInit) {
        firstInit = false;
    } else {
        initData();
    }
    console.log(`margin-home - onResume`);
};

moduleEvent$1.onStart = async function() {};

moduleEvent$1.onPause = async function() {};

moduleEvent$1.onStop = async function() {};

moduleEvent$1.onDestroy = async function() {};

function initAllData() {
    firstInit = true;
    firstShowPop = true;
    let tipsText = $i18n.n_margin_super_margin_loan_tip_new;
    let clickText = $i18n.n_margin_super_margin_loan_rules;
    let newTipsText = tipsText.replace(clickText, `<a href="@event.home.jumpTips()">${clickText}</a>`);
    let color = commonData.colorMode ? "#E6E6E6" : "#000000";
    moduleData$1.tipsText = `<span style="color:${color};font-size:12px;">${newTipsText}</span>`;
    moduleData$1.titleData = [ {
        type: "normal",
        title: $i18n.n_margin_loan,
        titleColor: titleColor_Selected$1,
        tag: 0
    }, {
        type: "normal",
        title: $i18n.n_margin_repay,
        titleColor: titleColor_Normal$1,
        tag: 1
    } ];
    moduleData$1.currentTag = "1";
    moduleData$1.currentIndex = 0;
    moduleData$1.pageType = 1, moduleData$1.marginType = 1, moduleData$1.symbol = "";
    moduleData$1.currency = "";
    moduleData$1.isLoanBtnRight = false;
    moduleData$1.loanMarginType = 1;
    moduleData$1.loanIsolatedType = 1;
    moduleData$1.loanCrossCheckBtnBg = marginSelectBtnBg;
    moduleData$1.loanCrossCheckBtnTextColor = titleColor_Selected$1;
    moduleData$1.loanIsolatedCheckBtnBg = marginUnselectBtnBg;
    moduleData$1.loanIsolatedCheckBtnTextColor = titleColor_Normal$1;
    moduleData$1.loanBaseBtnBgColor = "@color/kColorMajorTheme006";
    moduleData$1.loanBaseBorderColor = "@color/kColorMajorTheme100";
    moduleData$1.loanQuotaBtnBgColor = "@color/kColorInputFill";
    moduleData$1.loanQuotaBorderColor = "@color/kColorInputFill";
    moduleData$1.loanConfirmBtnBg = "@color/eColorInputFillDisabled";
    moduleData$1.loanConfirmBtnTextColor = "@color/kColorThreeLevelText";
    moduleData$1.loanEditBorderColor = "@color/kColorInputFill";
    moduleData$1.loanEditText = "";
    moduleData$1.loanErrorVisible = "gone";
    moduleData$1.loanEditText = "";
    moduleData$1.isLoanEditFocus = false;
    moduleData$1.isRepayBtnRight = false;
    moduleData$1.repayMarginType = 1;
    moduleData$1.repayIsolatedType = 1;
    moduleData$1.repayCrossCheckBtnBg = marginSelectBtnBg;
    moduleData$1.repayCrossCheckBtnTextColor = titleColor_Selected$1;
    moduleData$1.repayIsolatedCheckBtnBg = marginUnselectBtnBg;
    moduleData$1.repayIsolatedCheckBtnTextColor = titleColor_Normal$1;
    moduleData$1.repayBaseBtnBgColor = "@color/kColorMajorTheme006";
    moduleData$1.repayBaseBorderColor = "@color/kColorMajorTheme100";
    moduleData$1.repayQuotaBtnBgColor = "@color/kColorInputFill";
    moduleData$1.repayQuotaBorderColor = "@color/kColorInputFill";
    moduleData$1.repayConfirmBtnBg = "@color/eColorInputFillDisabled";
    moduleData$1.repayConfirmBtnTextColor = "@color/kColorThreeLevelText";
    moduleData$1.repayEditBorderColor = "@color/kColorInputFill";
    moduleData$1.repayEditText = "";
    moduleData$1.repayErrorVisible = "gone";
    moduleData$1.repayEditText = "";
    moduleData$1.isRepayEditFocus = false;
    moduleData$1.pageData = [];
}

async function initData() {
    console.log(`margin-home - initData`);
    if (moduleData$1.currentIndex == 0) {
        resetLoanMarginTitle(moduleData$1.loanMarginType);
    } else {
        resetRepayMarginTitle(moduleData$1.repayMarginType);
    }
    await requestData$1();
    if (moduleData$1.currentIndex == 0 && firstShowPop) {
        if (moduleData$1.loanMarginType == 1) {
            if (marginCross["sys-loan-amount"] <= 0) {
                popUpContentOfOneButton($i18n.n_copy_trading_tip, $i18n.$intercept.n_margin_unable_to_loan(marginCross["currency"].toUpperCase()), null);
            } else if (marginCross["max-loan-amount"] <= 0) {
                popUpContentOfTwoButton(-1, $i18n.n_copy_trading_tip, $i18n.$intercept.n_margin_super_limit_tips("0"), $i18n.n_cancel, $i18n.n_trade_alert_go_transfer, "gone", null, transfer);
            }
        } else {
            changeIsolatedLoan();
        }
        firstShowPop = false;
    }
}

async function requestData$1() {
    showLoading(true);
    await changeListType(moduleData$1.currentIndex);
    getSuperMarginCurrency();
    getMarginSymbol();
    await requestDetail();
    showLoading(false);
}

async function requestDetail() {
    console.log(`margin-home requestDetail currentIndex = ${moduleData$1.currentIndex} loanMarginType = ${moduleData$1.loanMarginType} repayMarginType = ${moduleData$1.repayMarginType}`);
    if (moduleData$1.currentIndex == 0) {
        let detail = {};
        if (moduleData$1.loanMarginType == 1) {
            detail = await sendRequest("v1/hbg/super-margin/currency-detail", {
                type: 1,
                currency: superMarginCurrency
            }, 0, 4);
            marginCross = detail;
        } else {
            detail = await sendRequest("v1/hbg/margin/symbol-detail", {
                type: 1,
                symbol: marginSymbol
            }, 0, 4);
            marginIsolated = detail;
        }
        console.log(`margin-home requestDetail loanDetail = ${JSON.stringify(detail)}`);
        uploadLog("copyTrading requestDetail loanDetail = ", `${JSON.stringify(detail)}`);
        await updateLoanChangeData();
    } else {
        let detail = {};
        if (moduleData$1.repayMarginType == 1) {
            detail = await sendRequest("v1/hbg/super-margin/currency-detail", {
                type: 2,
                currency: superMarginCurrency
            }, 0, 4);
            marginCross = detail;
        } else {
            detail = await sendRequest("v1/hbg/margin/symbol-detail", {
                type: 2,
                symbol: marginSymbol
            }, 0, 4);
            marginIsolated = detail;
        }
        console.log(`margin-home requestDetail repayDetail = ${JSON.stringify(detail)}`);
        uploadLog("copyTrading requestDetail repayDetail = ", `${JSON.stringify(detail)}`);
        await updateRepayChangeData();
    }
}

async function getSuperMarginCurrency() {
    if (!commonData.currencyList || commonData.currencyList == null) {
        return;
    }
    var currencyData = commonData.currencyList[0];
    for (let i = 0; i < commonData.currencyList.length; i++) {
        let tempData = commonData.currencyList[i];
        if (equalsIgnoreCase(tempData.currency, moduleData$1.currency)) {
            currencyData = tempData;
            break;
        }
    }
    superMarginCurrency = currencyData.currency;
}

async function getMarginSymbol() {
    if (!commonData.symbolList || commonData.symbolList == null) {
        return;
    }
    var symbolData = commonData.symbolList[0];
    for (let i = 0; i < commonData.symbolList.length; i++) {
        let tempData = commonData.symbolList[i];
        if (equalsIgnoreCase(tempData.symbol, moduleData$1.symbol)) {
            symbolData = tempData;
            break;
        }
    }
    marginSymbol = symbolData.symbol;
}

function equalsIgnoreCase(textOne, textTwo) {
    if (textOne != null && textOne != "undefined" && textTwo != null && textTwo != "undefined") {
        return textOne.toUpperCase() === textTwo.toUpperCase();
    }
    return false;
}

async function refreshCurrencyData(type, currency, symbol) {
    console.log(`margin-home refreshCurrencyData type = ${type}, currency = ${currency}, symbol = ${symbol}`);
    if (type == 1) {
        moduleData$1.currency = currency;
        superMarginCurrency = currency;
    } else {
        moduleData$1.symbol = symbol;
        marginSymbol = symbol;
    }
    showLoading(true);
    await requestDetail();
    showLoading(false);
    console.log(`margin-home refreshCurrencyData function end`);
}

async function resetTitleSelectTab$1(index) {
    console.log(`margin-home resetTitleSelectTab = ${index}`);
    resetSelectTabView(index);
    requestData$1();
    console.log(`margin-home resetTitleSelectTab function end`);
}

async function resetSelectTabView(index) {
    var selectedItem = null;
    for (var i = 0; i < moduleData$1.titleData.length; i++) {
        var item = moduleData$1.titleData[i];
        if (i == index) {
            selectedItem = item;
        }
        item.titleColor = titleColor_Normal$1;
    }
    if (selectedItem != null) {
        selectedItem.titleColor = titleColor_Selected$1;
        selectedItem.pointVisibility = "gone";
    }
}

function fixedNum(num) {
    let formatted = num.toFixed(4).replace(/\.?0+$/, "");
    return formatted;
}

moduleEvent$1.back = async function() {
    $nativeAPI.containerBack();
};

moduleEvent$1.history = async function() {
    let modeType = 1;
    if (moduleData$1.currentIndex == 0 && moduleData$1.loanMarginType == 2 || moduleData$1.currentIndex == 1 && moduleData$1.repayMarginType == 2) {
        modeType = 2;
    }
    openURL(`holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=margin&rootName=leverHistory&navConfig=&tabType=${moduleData$1.currentIndex}&modeType=${modeType}`);
};

moduleEvent$1.tabClick = async function(index) {
    closeKeyboard();
    moduleData$1.currentIndex = parseInt(index);
    await resetTitleSelectTab$1(index);
    onLoanTextChange(moduleData$1.loanEditText);
    onRepayTextChange(moduleData$1.repayEditText);
    console.log(`margin-home tabClick function end`);
};

async function loanChangeType(type, currencyChange = false) {
    console.log(`margin-home loanChangeType type = ${type}, currencyChange = ${currencyChange}`);
    if (moduleData$1.loanMarginType != type || currencyChange) {
        closeKeyboard();
        moduleData$1.loanMarginType = type;
        moduleData$1.loanEditText = "";
        resetLoanMarginTitle(type);
        await requestDetail();
    }
    onLoanTextChange(moduleData$1.loanEditText);
    console.log(`margin-home loanChangeType function end`);
}

function resetLoanMarginTitle(type) {
    if (type == 1) {
        moduleData$1.loanCrossCheckBtnBg = marginSelectBtnBg;
        moduleData$1.loanCrossCheckBtnTextColor = titleColor_Selected$1;
        moduleData$1.loanIsolatedCheckBtnBg = marginUnselectBtnBg;
        moduleData$1.loanIsolatedCheckBtnTextColor = titleColor_Normal$1;
    } else {
        moduleData$1.loanCrossCheckBtnBg = marginUnselectBtnBg;
        moduleData$1.loanCrossCheckBtnTextColor = titleColor_Normal$1;
        moduleData$1.loanIsolatedCheckBtnBg = marginSelectBtnBg;
        moduleData$1.loanIsolatedCheckBtnTextColor = titleColor_Selected$1;
    }
}

async function changeSuperMarginLoan() {
    if (marginCross == null) {
        return;
    }
    let alreadyLoan = await thousandsFormatter(scientificToNumber(marginCross.loan).toString());
    let maxLoanAmount = await thousandsFormatter(scientificToNumber(marginCross["max-loan-amount"]).toString());
    tempPageData[0] = {
        type: "loan",
        iconVisible: "visible",
        icon: getPNGIconURLByCurrency(marginCross.currency),
        symbol: marginCross.currency.toUpperCase(),
        currency: marginCross.currency.toUpperCase(),
        alreadyLoan: `${alreadyLoan} ${marginCross.currency.toUpperCase()}`,
        interestRate: `${fixedNum(marginCross["interest-rate"] * 100)}%`,
        maxLoanLimit: `${maxLoanAmount} ${marginCross.currency.toUpperCase()}`,
        editHint: $i18n.$intercept.n_margin_minimum(` ${scientificToNumber(marginCross["min-loan-limit"]).toString()}`),
        maxLoanAmount: `${maxLoanAmount} ${marginCross.currency.toUpperCase()}`
    };
    moduleData$1.pageData = tempPageData;
    console.log(`margin-home loanChangeType tempPageData[0] = ${JSON.stringify(tempPageData[0])}`);
}

async function updateLoanChangeData() {
    if (moduleData$1.loanMarginType == 1) {
        changeSuperMarginLoan();
    } else {
        changeIsolatedLoan();
    }
}

async function updateRepayChangeData() {
    if (moduleData$1.repayMarginType == 1) {
        changeSuperMarginRepay();
    } else {
        changeIsolatedRepay();
    }
}

moduleEvent$1.loanChangeType = loanChangeType;

moduleEvent$1.changeLoanIsolatedType = async function(type) {
    console.log(`margin-home changeLoanIsolatedType type = ${type}`);
    if (moduleData$1.loanIsolatedType != type) {
        closeKeyboard();
        moduleData$1.loanIsolatedType = type;
        moduleData$1.loanEditText = "";
        if (type == 1) {
            moduleData$1.loanBaseBtnBgColor = "@color/kColorMajorTheme006";
            moduleData$1.loanBaseBorderColor = "@color/kColorMajorTheme100";
            moduleData$1.loanQuotaBtnBgColor = "@color/kColorInputFill";
            moduleData$1.loanQuotaBorderColor = "@color/kColorInputFill";
        } else {
            moduleData$1.loanBaseBtnBgColor = "@color/kColorInputFill";
            moduleData$1.loanBaseBorderColor = "@color/kColorInputFill";
            moduleData$1.loanQuotaBtnBgColor = "@color/kColorMajorTheme006";
            moduleData$1.loanQuotaBorderColor = "@color/kColorMajorTheme100";
        }
        changeIsolatedLoan();
    }
    console.log(`margin-home changeLoanIsolatedType function end`);
};

async function changeIsolatedLoan() {
    console.log(`margin-home changeIsolatedLoan function start`);
    if (marginIsolated == null) {
        return;
    }
    try {
        let baseCurrency = marginIsolated["base-currency"].toUpperCase();
        let alreadyLoan = await thousandsFormatter(scientificToNumber(marginIsolated["base-loan"]).toString());
        let maxLoanAmount = await thousandsFormatter(scientificToNumber(marginIsolated["base-max-loan-amount"]).toString());
        let isolatedData = {
            type: "loan",
            iconVisible: "gone",
            icon: "",
            symbol: marginIsolated["display-symbol"].toUpperCase(),
            currency: baseCurrency,
            baseCurrency: baseCurrency,
            quotaCurrency: marginIsolated["quota-currency"].toUpperCase(),
            alreadyLoan: `${alreadyLoan} ${baseCurrency}`,
            interestRate: `${fixedNum(marginIsolated["base-interest-rate"] * 100)}%`,
            maxLoanLimit: `${maxLoanAmount} ${baseCurrency}`,
            editHint: $i18n.$intercept.n_margin_minimum(` ${scientificToNumber(marginIsolated["base-min-loan-limit"]).toString()}`),
            maxLoanAmount: `${maxLoanAmount} ${baseCurrency}`,
            showTwoCurrency: "visible",
            baseIcon: getPNGIconURLByCurrency(marginIsolated["base-currency"]),
            quotaIcon: getPNGIconURLByCurrency(marginIsolated["quota-currency"]),
            showIsolatedTitle: "visible"
        };
        if (moduleData$1.loanIsolatedType == 2) {
            baseCurrency = marginIsolated["quota-currency"].toUpperCase();
            alreadyLoan = await thousandsFormatter(scientificToNumber(marginIsolated["quota-loan"]).toString());
            maxLoanAmount = await thousandsFormatter(scientificToNumber(marginIsolated["quota-max-loan-amount"]).toString());
            isolatedData.currency = baseCurrency;
            isolatedData.alreadyLoan = `${alreadyLoan} ${baseCurrency}`;
            isolatedData.interestRate = `${fixedNum(marginIsolated["quota-interest-rate"] * 100)}%`;
            isolatedData.maxLoanLimit = `${maxLoanAmount} ${baseCurrency}`;
            isolatedData.editHint = $i18n.$intercept.n_margin_minimum(` ${scientificToNumber(marginIsolated["quota-min-loan-limit"]).toString()}`);
            isolatedData.maxLoanAmount = `${maxLoanAmount} ${baseCurrency}`;
        }
        if (firstShowPop) {
            if (marginIsolated["base-sys-loan-amount"] <= 0 && marginIsolated["quota-sys-loan-amount"] <= 0) {
                popUpContentOfOneButton($i18n.n_copy_trading_tip, $i18n.$intercept.n_margin_unable_to_loan(`${marginIsolated["base-currency"].toUpperCase()}、${marginIsolated["quota-currency"].toUpperCase()}`), null);
            } else if (marginIsolated["base-max-loan-amount"] <= 0 && marginIsolated["quota-max-loan-amount"] <= 0) {
                popUpContentOfTwoButton(-1, $i18n.n_copy_trading_tip, $i18n.$intercept.n_margin_limit_tips("0"), $i18n.n_cancel, $i18n.n_trade_alert_go_transfer, "gone", null, transfer);
            }
        }
        tempPageData[0] = isolatedData;
        moduleData$1.pageData = tempPageData;
        console.log(`margin-home changeIsolatedLoan tempPageData[0] = ${JSON.stringify(tempPageData[0])}`);
    } catch (e) {
        console.log(`margin-home changeIsolatedLoan e = ${e}`);
    }
    console.log(`margin-home changeIsolatedLoan function end`);
}

async function refreshLoanBtnStatus() {
    console.log(`margin-home refreshLoanBtnStatus function start`);
    if (moduleData$1.loanEditText == "" || Number(moduleData$1.loanEditText) == 0) {
        moduleData$1.loanEditBorderColor = moduleData$1.isLoanEditFocus ? "@color/kColorMajorTheme100" : "@color/kColorInputFill";
        moduleData$1.loanConfirmBtnBg = "@color/eColorInputFillDisabled";
        moduleData$1.loanConfirmBtnTextColor = "@color/kColorThreeLevelText";
        moduleData$1.loanErrorVisible = "gone";
        moduleData$1.isLoanBtnRight = false;
    } else {
        let isRight = false;
        let errorTips = "";
        if (moduleData$1.loanMarginType == 1) {
            if (Number(moduleData$1.loanEditText) <= Number(marginCross["max-loan-amount"])) {
                isRight = true;
            } else {
                errorTips = `${Number(marginCross["max-loan-amount"])}`;
            }
        } else if (moduleData$1.loanIsolatedType == 1) {
            if (Number(moduleData$1.loanEditText) <= Number(marginIsolated["base-max-loan-amount"])) {
                isRight = true;
            } else {
                errorTips = `${Number(marginIsolated["base-max-loan-amount"])}`;
            }
        } else {
            if (Number(moduleData$1.loanEditText) <= Number(marginIsolated["quota-max-loan-amount"])) {
                isRight = true;
            } else {
                errorTips = `${Number(marginIsolated["quota-max-loan-amount"])}`;
            }
        }
        moduleData$1.loanErrorTips = $i18n.$intercept.n_margin_maximum_amount_tips(`${errorTips}`);
        if (isRight) {
            if (moduleData$1.loanMarginType == 1) {
                isRight = Number(moduleData$1.loanEditText) >= Number(marginCross["min-loan-limit"]);
                if (!isRight) {
                    errorTips = `${Number(marginCross["min-loan-limit"])}`;
                }
            } else if (moduleData$1.loanIsolatedType == 1) {
                isRight = Number(moduleData$1.loanEditText) >= Number(marginIsolated["base-min-loan-limit"]);
                if (!isRight) {
                    errorTips = `${Number(marginIsolated["base-min-loan-limit"])}`;
                }
            } else {
                isRight = Number(moduleData$1.loanEditText) >= Number(marginIsolated["quota-min-loan-limit"]);
                if (!isRight) {
                    errorTips = `${Number(marginIsolated["quota-min-loan-limit"])}`;
                }
            }
            if (!isRight) {
                moduleData$1.loanErrorTips = $i18n.$intercept.n_margin_not_reached_borrowed(`${errorTips}`);
            }
        }
        if (isRight) {
            if (moduleData$1.loanMarginType == 1) {
                isRight = Number(moduleData$1.loanEditText) <= Number(marginCross["max-loan-amount"]);
            } else if (moduleData$1.loanIsolatedType == 1) {
                isRight = Number(moduleData$1.loanEditText) <= Number(marginIsolated["base-max-loan-amount"]);
            } else {
                isRight = Number(moduleData$1.loanEditText) <= Number(marginIsolated["quota-max-loan-amount"]);
            }
            if (!isRight) {
                moduleData$1.loanErrorTips = $i18n.n_margin_amount_over_loanable_tips;
            }
        }
        moduleData$1.loanEditBorderColor = isRight ? moduleData$1.isLoanEditFocus ? "@color/kColorMajorTheme100" : "@color/kColorInputFill" : "@color/kColorPriceRed";
        moduleData$1.loanConfirmBtnBg = isRight ? "@color/kColorMajorTheme100" : "@color/eColorInputFillDisabled";
        moduleData$1.loanConfirmBtnTextColor = isRight ? "@color/KBaseTextColor" : "@color/kColorThreeLevelText";
        moduleData$1.loanErrorVisible = isRight ? "gone" : "visible";
        moduleData$1.isLoanBtnRight = isRight;
    }
    console.log(`margin-home refreshLoanBtnStatus function end`);
}

function filterNumberStr(str) {
    if (str.startsWith("0.")) {
        return str;
    }
    let num = Number(str);
    if (isNaN(num)) {
        return "";
    }
    return num + (str.endsWith(".") ? "." : "");
}

moduleEvent$1.onLoanEditFocusChange = async function(isFocus) {
    console.log(`margin-home onLoanEditFocusChange function start`);
    moduleData$1.isLoanEditFocus = isFocus;
    refreshLoanBtnStatus();
    console.log(`margin-home onLoanEditFocusChange function end`);
};

async function onLoanTextChange(text) {
    if (text != "") {
        let replaceZero = text;
        if (text.length > 1) {
            replaceZero = filterNumberStr(text);
        }
        if (replaceZero != text) {
            moduleData$1.loanEditText = replaceZero;
        }
        let tempText = await formatDecimal(replaceZero, 3, false);
        if (tempText != replaceZero) {
            moduleData$1.loanEditText = tempText;
        }
    }
    refreshLoanBtnStatus();
}

moduleEvent$1.loanConfirm = async function() {
    console.log(`margin-home loanConfirm function start`);
    if (moduleData$1.isLoanBtnRight) {
        showLoading(true);
        let loanCode = 0;
        if (moduleData$1.loanMarginType == 1) {
            let accountId = commonData.superMarginAccountId;
            console.log(`margin-home loanConfirm accountId = ${accountId}`);
            if (accountId == null || accountId == "" || accountId == "undefined") {
                showLoading(false);
                return;
            }
            let params = {
                currency: marginCross.currency,
                amount: moduleData$1.loanEditText,
                "account-id": accountId,
                source: commonData.OS == 0 ? 4 : 3
            };
            loanCode = await sendRequestReturnCode("v1/hbg/super-margin/loan", params, 1, 4, {
                "Content-Type": "application/json"
            });
        } else {
            let params = {
                symbol: marginIsolated.symbol,
                currency: moduleData$1.loanIsolatedType == 1 ? marginIsolated["base-currency"] : marginIsolated["quota-currency"],
                amount: moduleData$1.loanEditText
            };
            loanCode = await sendRequestReturnCode("v1/margin/orders", params, 1, 4, {
                "Content-Type": "application/json"
            });
        }
        showLoading(false);
        if (loanCode == 200) {
            requestDetail();
            let content = $i18n.n_margin_completed_loan;
            let leftText = $i18n.n_cancel;
            let rightText = $i18n.n_go_trade;
            popUpContentOfTwoButton(-1, null, content, leftText, rightText, "gone", null, (async function() {
                let type = moduleData$1.loanMarginType == 1 ? "super_margin" : "margin";
                let symbol = moduleData$1.loanMarginType == 1 ? "" : marginIsolated.symbol;
                openURL(`holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/trade/index?type=${type}&symbol=${symbol}&backFirstLevelPage=1`);
            }));
        }
    }
    console.log(`margin-home loanConfirm function end`);
};

moduleEvent$1.loanAllBalance = async function() {
    console.log(`margin-home loanAllBalance function start`);
    if (moduleData$1.loanMarginType == 1) {
        moduleData$1.loanEditText = await formatDecimal(Number(marginCross["max-loan-amount"]), 3, false);
    } else if (moduleData$1.loanIsolatedType == 1) {
        moduleData$1.loanEditText = await formatDecimal(Number(marginIsolated["base-max-loan-amount"]), 3, false);
    } else {
        moduleData$1.loanEditText = await formatDecimal(Number(marginIsolated["quota-max-loan-amount"]), 3, false);
    }
    onLoanTextChange(moduleData$1.loanEditText);
    console.log(`margin-home loanAllBalance loanEditText = ${moduleData$1.loanEditText}, marginCross = ${JSON.stringify(marginCross)}, marginIsolated = ${JSON.stringify(marginIsolated)}`);
    console.log(`margin-home loanAllBalance function end`);
};

async function repayChangeType(type, currencyChange = false) {
    console.log(`margin-home repayChangeType type = ${type}, currencyChange = ${currencyChange}`);
    if (moduleData$1.repayMarginType != type || currencyChange) {
        closeKeyboard();
        moduleData$1.repayMarginType = type;
        moduleData$1.repayEditText = "";
        resetRepayMarginTitle(type);
        await requestDetail();
    }
    onRepayTextChange(moduleData$1.repayEditText);
    console.log(`margin-home repayChangeType function end`);
}

function resetRepayMarginTitle(type) {
    if (type == 1) {
        moduleData$1.repayCrossCheckBtnBg = marginSelectBtnBg;
        moduleData$1.repayCrossCheckBtnTextColor = titleColor_Selected$1;
        moduleData$1.repayIsolatedCheckBtnBg = marginUnselectBtnBg;
        moduleData$1.repayIsolatedCheckBtnTextColor = titleColor_Normal$1;
    } else {
        moduleData$1.repayCrossCheckBtnBg = marginUnselectBtnBg;
        moduleData$1.repayCrossCheckBtnTextColor = titleColor_Normal$1;
        moduleData$1.repayIsolatedCheckBtnBg = marginSelectBtnBg;
        moduleData$1.repayIsolatedCheckBtnTextColor = titleColor_Selected$1;
    }
}

moduleEvent$1.repayChangeType = repayChangeType;

moduleEvent$1.changeRepayIsolatedType = async function(type) {
    console.log(`margin-home changeRepayIsolatedType type = ${type}`);
    if (moduleData$1.repayIsolatedType != type) {
        closeKeyboard();
        moduleData$1.repayIsolatedType = type;
        moduleData$1.repayEditText = "";
        if (type == 1) {
            moduleData$1.repayBaseBtnBgColor = "@color/kColorMajorTheme006";
            moduleData$1.repayBaseBorderColor = "@color/kColorMajorTheme100";
            moduleData$1.repayQuotaBtnBgColor = "@color/kColorInputFill";
            moduleData$1.repayQuotaBorderColor = "@color/kColorInputFill";
        } else {
            moduleData$1.repayBaseBtnBgColor = "@color/kColorInputFill";
            moduleData$1.repayBaseBorderColor = "@color/kColorInputFill";
            moduleData$1.repayQuotaBtnBgColor = "@color/kColorMajorTheme006";
            moduleData$1.repayQuotaBorderColor = "@color/kColorMajorTheme100";
        }
        changeIsolatedRepay();
    }
    console.log(`margin-home changeRepayIsolatedType function end`);
};

async function changeSuperMarginRepay() {
    if (marginCross == null) {
        return;
    }
    let alreadyLoan = await thousandsFormatter(scientificToNumber(marginCross.loan).toString());
    let interest = await thousandsFormatter(scientificToNumber(marginCross.interest).toString());
    let debt = await thousandsFormatter(scientificToNumber(marginCross.debt).toString());
    let trade = await thousandsFormatter(scientificToNumber(marginCross.trade).toString());
    tempPageData[1] = {
        type: "repay",
        iconVisible: "visible",
        icon: getPNGIconURLByCurrency(marginCross.currency),
        symbol: marginCross.currency.toUpperCase(),
        currency: marginCross.currency.toUpperCase(),
        alreadyLoan: `${alreadyLoan} ${marginCross.currency.toUpperCase()}`,
        interest: `${interest} ${marginCross.currency.toUpperCase()}`,
        debt: `${debt} ${marginCross.currency.toUpperCase()}`,
        trade: `${trade} ${marginCross.currency.toUpperCase()}`
    };
    moduleData$1.pageData = tempPageData;
    console.log(`margin-home repayChangeType tempPageData[1] = ${JSON.stringify(tempPageData[1])}`);
}

async function changeIsolatedRepay() {
    console.log(`margin-home changeIsolatedRepay function start`);
    if (marginIsolated == null) {
        return;
    }
    try {
        var baseCurrency = marginIsolated["base-currency"].toUpperCase();
        let alreadyLoan = await thousandsFormatter(scientificToNumber(marginIsolated["base-loan"]).toString());
        let interest = await thousandsFormatter(scientificToNumber(marginIsolated["base-interest"]).toString());
        let debt = await thousandsFormatter(scientificToNumber(marginIsolated["base-debt"]).toString());
        let trade = await thousandsFormatter(scientificToNumber(marginIsolated["base-trade"]).toString());
        let isolatedData = {
            type: "repay",
            iconVisible: "gone",
            icon: "",
            symbol: marginIsolated["display-symbol"].toUpperCase(),
            currency: baseCurrency,
            baseCurrency: baseCurrency,
            quotaCurrency: marginIsolated["quota-currency"].toUpperCase(),
            alreadyLoan: `${alreadyLoan} ${baseCurrency}`,
            interest: `${interest} ${baseCurrency}`,
            debt: `${debt} ${baseCurrency}`,
            trade: `${trade} ${baseCurrency}`,
            showTwoCurrency: "visible",
            baseIcon: getPNGIconURLByCurrency(marginIsolated["base-currency"]),
            quotaIcon: getPNGIconURLByCurrency(marginIsolated["quota-currency"]),
            showIsolatedTitle: "visible"
        };
        if (moduleData$1.repayIsolatedType == 2) {
            baseCurrency = marginIsolated["quota-currency"].toUpperCase();
            alreadyLoan = await thousandsFormatter(scientificToNumber(marginIsolated["quota-loan"]).toString());
            interest = await thousandsFormatter(scientificToNumber(marginIsolated["quota-interest"]).toString());
            debt = await thousandsFormatter(scientificToNumber(marginIsolated["quota-debt"]).toString());
            trade = await thousandsFormatter(scientificToNumber(marginIsolated["quota-trade"]).toString());
            isolatedData.currency = baseCurrency;
            isolatedData.alreadyLoan = `${alreadyLoan} ${baseCurrency}`;
            isolatedData.interest = `${interest} ${baseCurrency}`;
            isolatedData.debt = `${debt} ${baseCurrency}`;
            isolatedData.trade = `${trade} ${baseCurrency}`;
        }
        tempPageData[1] = isolatedData;
        moduleData$1.pageData = tempPageData;
        console.log(`margin-home changeIsolatedRepay tempPageData[1] = ${JSON.stringify(tempPageData[1])}`);
    } catch (e) {
        console.log(`margin-home changeIsolatedRepay e = ${e}`);
    }
    console.log(`margin-home changeIsolatedRepay function end`);
}

async function refreshRepayBtnStatus() {
    console.log(`margin-home refreshRepayBtnStatus function start`);
    if (moduleData$1.repayEditText == "" || Number(moduleData$1.repayEditText) == 0) {
        moduleData$1.repayEditBorderColor = moduleData$1.isRepayEditFocus ? "@color/kColorMajorTheme100" : "@color/kColorInputFill";
        moduleData$1.repayConfirmBtnBg = "@color/eColorInputFillDisabled";
        moduleData$1.repayConfirmBtnTextColor = "@color/kColorThreeLevelText";
        moduleData$1.repayErrorVisible = "gone";
        moduleData$1.isRepayBtnRight = false;
    } else {
        let isRight = false;
        if (moduleData$1.repayMarginType == 1) {
            if (Number(moduleData$1.repayEditText) > Number(marginCross.trade)) {
                moduleData$1.repayErrorTipText = $i18n.n_margin_insufficient_available;
            } else if (Number(moduleData$1.repayEditText) > Number(marginCross.debt)) {
                if (Number(marginCross.debt) == 0) {
                    moduleData$1.repayErrorTipText = $i18n.n_margin_out_of_debt;
                } else {
                    moduleData$1.repayErrorTipText = $i18n.n_margin_amount_over_total_liabilities;
                }
            } else {
                isRight = true;
            }
        } else if (moduleData$1.repayIsolatedType == 1) {
            if (Number(moduleData$1.repayEditText) > Number(marginIsolated["base-trade"])) {
                moduleData$1.repayErrorTipText = $i18n.n_margin_insufficient_available;
            } else if (Number(moduleData$1.repayEditText) > Number(marginIsolated["base-debt"])) {
                if (Number(marginIsolated["base-debt"]) == 0) {
                    moduleData$1.repayErrorTipText = $i18n.n_margin_out_of_debt;
                } else {
                    moduleData$1.repayErrorTipText = $i18n.n_margin_amount_over_total_liabilities;
                }
            } else {
                isRight = true;
            }
        } else {
            if (Number(moduleData$1.repayEditText) > Number(marginIsolated["quota-trade"])) {
                moduleData$1.repayErrorTipText = $i18n.n_margin_insufficient_available;
            } else if (Number(moduleData$1.repayEditText) > Number(marginIsolated["quota-debt"])) {
                if (Number(marginIsolated["quota-debt"]) == 0) {
                    moduleData$1.repayErrorTipText = $i18n.n_margin_out_of_debt;
                } else {
                    moduleData$1.repayErrorTipText = $i18n.n_margin_amount_over_total_liabilities;
                }
            } else {
                isRight = true;
            }
        }
        moduleData$1.repayEditBorderColor = isRight ? moduleData$1.isLoanEditFocus ? "@color/kColorMajorTheme100" : "@color/kColorInputFill" : "@color/kColorPriceRed";
        moduleData$1.repayConfirmBtnBg = isRight ? "@color/kColorMajorTheme100" : "@color/eColorInputFillDisabled";
        moduleData$1.repayConfirmBtnTextColor = isRight ? "@color/KBaseTextColor" : "@color/kColorThreeLevelText";
        moduleData$1.repayErrorVisible = isRight ? "gone" : "visible";
        moduleData$1.isRepayBtnRight = isRight;
    }
    console.log(`margin-home refreshRepayBtnStatus function end`);
}

moduleEvent$1.onRepayEditFocusChange = async function(isFocus) {
    moduleData$1.isRepayEditFocus = isFocus;
    refreshRepayBtnStatus();
};

async function onRepayTextChange(text) {
    if (text != "") {
        let replaceZero = text;
        if (text.length > 1) {
            replaceZero = filterNumberStr(text);
        }
        if (replaceZero != text) {
            moduleData$1.repayEditText = replaceZero;
        }
        let tempText = await formatDecimal(replaceZero, 8, false);
        if (tempText != replaceZero) {
            moduleData$1.repayEditText = tempText;
        }
    }
    refreshRepayBtnStatus();
}

moduleEvent$1.repayConfirm = async function() {
    console.log(`margin-home repayConfirm function start`);
    if (moduleData$1.isRepayBtnRight) {
        showLoading(true);
        let repayCode = 0;
        if (moduleData$1.repayMarginType == 1) {
            let accountId = commonData.superMarginAccountId;
            console.log(`margin-home repayConfirm accountId = ${accountId}`);
            if (accountId == null || accountId == "" || accountId == "undefined") {
                showLoading(false);
                return;
            }
            let params = {
                currency: marginCross.currency,
                amount: moduleData$1.repayEditText,
                "account-id": accountId,
                source: commonData.OS == 0 ? 4 : 3
            };
            repayCode = await sendRequestReturnCode("v1/hbg/super-margin/repay", params, 1, 4, {
                "Content-Type": "application/json"
            });
        } else {
            let params = {
                symbol: marginIsolated.symbol,
                currency: moduleData$1.repayIsolatedType == 1 ? marginIsolated["base-currency"] : marginIsolated["quota-currency"],
                amount: moduleData$1.repayEditText
            };
            repayCode = await sendRequestReturnCode("v1/hbg/margin/repay", params, 1, 4, {
                "Content-Type": "application/json"
            });
        }
        showLoading(false);
        if (repayCode == 200) {
            requestDetail();
            showToast($i18n.n_margin_repayment_success);
            $nativeAPI.containerBack();
        }
    }
    console.log(`margin-home repayConfirm function end`);
};

moduleEvent$1.repayAllBalance = async function() {
    console.log(`margin-home repayAllBalance function start`);
    if (moduleData$1.repayMarginType == 1) {
        moduleData$1.repayEditText = getMinNum(Number(marginCross["trade"]), Number(marginCross.debt));
    } else if (moduleData$1.repayIsolatedType == 1) {
        moduleData$1.repayEditText = getMinNum(Number(marginIsolated["base-trade"]), Number(marginIsolated["base-debt"]));
    } else {
        moduleData$1.repayEditText = getMinNum(Number(marginIsolated["quota-trade"]), Number(marginIsolated["quota-debt"]));
    }
    onRepayTextChange(moduleData$1.repayEditText);
    console.log(`margin-home repayAllBalance function end`);
};

function getMinNum(num1, num2) {
    return (Number(num1) > Number(num2) ? Number(num2) : Number(num1)) + "";
}

async function changeListType(type) {
    if (type == 0) {
        if (commonData.loanCurrencyList == null) {
            await getCurrencyList(type);
        }
        commonData.currencyList = commonData.loanCurrencyList;
        if (commonData.loanSymbolList == null) {
            await getSymbolList(type);
        }
        commonData.symbolList = commonData.loanSymbolList;
    } else {
        if (commonData.repayCurrencyList == null) {
            await getCurrencyList(type);
        }
        commonData.currencyList = commonData.repayCurrencyList;
        if (commonData.repaySymbolList == null) {
            await getSymbolList(type);
        }
        commonData.symbolList = commonData.repaySymbolList;
    }
}

async function transfer() {
    let coin = "";
    let symbol = "";
    let account = "";
    let displayMarginSymbol = "";
    if (moduleData$1.currentIndex == 0 && moduleData$1.loanMarginType == 1 || moduleData$1.currentIndex == 1 && moduleData$1.repayMarginType == 1) {
        coin = marginCross.currency;
        account = "6";
    } else {
        if (commonData.OS == 1) {
            if (moduleData$1.currentIndex == 0 && moduleData$1.loanIsolatedType == 1 || moduleData$1.currentIndex == 1 && moduleData$1.repayIsolatedType == 1) {
                coin = marginIsolated["base-currency"];
            } else {
                coin = marginIsolated["quota-currency"];
            }
        } else {
            coin = marginIsolated["display-symbol"];
            if (moduleData$1.currentIndex == 0 && moduleData$1.loanIsolatedType == 1 || moduleData$1.currentIndex == 1 && moduleData$1.repayIsolatedType == 1) {
                displayMarginSymbol = `&displayMarginSymbol=${marginIsolated["base-currency"]}`;
            } else {
                displayMarginSymbol = `&displayMarginSymbol=${marginIsolated["quota-currency"]}`;
            }
        }
        symbol = `&symbol=${marginIsolated.symbol}`;
        account = "3";
    }
    if (commonData.OS == 1) {
        openURL(`holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/balance/transfer?coin=${coin}&account=${account}${symbol}`);
    } else {
        openURL(`holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/balance/transfer?coin=${coin}&account=${account}${displayMarginSymbol}`);
    }
}

moduleEvent$1.showCurrencyPop = async function() {
    closeKeyboard();
    showPop(moduleData$1.currentIndex, moduleData$1.currentIndex == 0 ? moduleData$1.loanMarginType : moduleData$1.repayMarginType, refreshCurrencyData);
};

function showOneBtnDialog(title, content) {
    let btnText = $i18n.n_copy_trading_me_know;
    popUpContentOfOneButton(title, content, btnText);
}

moduleEvent$1.interestRulesTips = function() {
    let title = $i18n.n_margin_currency_interest_rate_explain;
    let content = $i18n.$intercept.n_margin_interest_borrowed_tips(moduleData$1.loanMarginType == 1 ? `${fixedNum(marginCross["interest-rate"] * 100)}%` : moduleData$1.loanIsolatedType == 1 ? `${fixedNum(marginIsolated["base-interest-rate"] * 100)}%` : `${fixedNum(marginIsolated["quota-interest-rate"] * 100)}%`);
    showOneBtnDialog(title, content);
};

moduleEvent$1.maximumLoanExplainedTips = function() {
    let title = $i18n.n_margin_maximum_loan_amount_explain;
    let content = $i18n.n_margin_maximum_loan_amount_tips;
    showOneBtnDialog(title, content);
};

moduleEvent$1.totalDebtExplainedTips = function() {
    let title = $i18n.n_margin_total_liabilities_explain;
    let content = $i18n.n_margin_total_liabilities_content;
    showOneBtnDialog(title, content);
};

moduleEvent$1.toLoanLimit = async function(type) {
    openURL(`${commonData.webUrl}/${commonData.language}/${moduleData$1.loanMarginType == 1 ? CROSS_MARGIN_LADDER_LENDING : MARGIN_LADDER_LENDING}${moduleData$1.loanMarginType == 1 ? marginCross.currency : marginIsolated.symbol}`);
};

moduleEvent$1.jumpTips = function() {
    openURL(`${commonData.webUrl}/support/${commonData.language}/detail/24930315273813`);
};

function closeKeyboard() {
    moduleData$1.isLoanEditFocus = false;
    moduleData$1.isRepayEditFocus = false;
    if (commonData.OS == 1) {
        $nativeAPI.closeKeyboard();
    }
}

moduleEvent$1.transfer = transfer;

moduleEvent$1.resetTitleSelectTab = resetTitleSelectTab$1;

moduleEvent$1.onLoanTextChange = onLoanTextChange;

moduleEvent$1.onRepayTextChange = onRepayTextChange;

var titleColor_Normal = "@color/kColorThreeLevelText";

var titleColor_Selected = "@color/kColorPrimaryText";

const Edit_Board_SelectColor = "@color/kColorMajorTheme100";

const Edit_Board_NomalColor = "@color/KBaseColorContentBackground";

const buttonTitleColor_Normal = "@color/kColorPrimaryText";

const buttonTitleColor_Selected = "@color/kColorMajorTheme100";

const buttonBackColor_Normal = "@color/KBaseColorInputBackground";

const buttonBackColor_Selected = "@color/kColorMajorTheme006";

var supportCurrencies = [];

var supportSymbols = [];

var ModeType = {
    superMargin: 1,
    isolateMargin: 2
};

var TabType = {
    TabTypeLoan: 0,
    TabTypeRepay: 1,
    TabTypeInterest: 2
};

var limit = 10;

var commonList = [ getTabListDefaultData(), getTabListDefaultData(), getTabListDefaultData() ];

var commonFilterTypes = [];

function defaultData() {
    return {
        currentTabType: TabType.TabTypeLoan,
        curFilterTypeIndex: 0,
        typeHeight: 50,
        loadMoreStatus: "0",
        refreshStatus: "0",
        listData: commonList,
        modeTypeIcon: "@drawable/edge_engine_arrow_down",
        currencyIcon: "@drawable/edge_engine_arrow_down",
        filterCurrencies: [],
        borderColor: Edit_Board_NomalColor,
        clearVisible: "gone",
        filterTimes: [ {
            type: "normal",
            title: $i18n.n_order_filter_nearly_a_week,
            titleColor: buttonTitleColor_Normal,
            timeBackColor: buttonBackColor_Normal,
            tag: 0
        }, {
            type: "normal",
            title: $i18n.n_order_filter_nearly_a_month,
            titleColor: buttonTitleColor_Normal,
            timeBackColor: buttonBackColor_Normal,
            tag: 1
        }, {
            type: "normal",
            title: $i18n.n_order_filter_nearly_120_days,
            titleColor: buttonTitleColor_Selected,
            timeBackColor: buttonBackColor_Selected,
            tag: 2
        } ]
    };
}

const {moduleData: moduleData, moduleEvent: moduleEvent} = moduleDefine("leverHistory", start, defaultData);

async function start() {}

moduleEvent.onCreate = async function(eventParams) {
    moduleData.config = {
        backgroundColor: "kColorContentBackground"
    };
    const params = JSON.parse(eventParams);
    console.log(`wp -----onCreate = ${JSON.stringify(params)}`);
    if (params.tabType != null) {
        moduleData.currentTabType = params.tabType;
    } else {
        moduleData.currentTabType = TabType.TabTypeLoan;
    }
    moduleData.titleData = getTabTitleData();
    if (params.modeType != null) {
        moduleData.curModeType = params.modeType;
        setModeTypeData(params.modeType);
    } else {
        moduleData.curModeType = ModeType.superMargin;
        setModeTypeData(ModeType.superMargin);
    }
    if (params.symbol != null) {
        let symbol = params.symbol.toLowerCase();
        console.log(`wp onCreate symbol = ${symbol}`);
        moduleData.curSymbol = symbol;
        if (params.modeType == ModeType.isolateMargin) {
            moduleData.currencyText = await getSymbolDisplayName(symbol);
        } else {
            moduleData.currencyText = symbol.toUpperCase();
        }
    } else {
        moduleData.currencyText = moduleData.curModeType == ModeType.superMargin ? $i18n.n_earn_all_coin : $i18n.n_margin_all_currency;
        moduleData.curFilterCurrencyIndex = 0;
        moduleData.curSymbol = null;
    }
    defaultFilterData();
    commonFilterTypes = getFilterMoreTypes();
    moduleData.filterTypes = commonFilterTypes;
    requestData(false);
    requestSuperMarginCurrencies();
    requestMarginSymbols();
};

moduleEvent.onDestroy = async function() {
    commonList = [ getTabListDefaultData(), getTabListDefaultData(), getTabListDefaultData() ];
    moduleData.listData = commonList;
};

moduleEvent.onResume = async function() {};

moduleEvent.onPause = async function() {};

moduleEvent.onStop = async function() {};

moduleEvent.onStart = async function() {};

moduleEvent.back = async function() {
    $nativeAPI.containerBack();
};

async function filterClick(index) {
    if (index == 0) {
        moduleData.modeTypeShow = "true";
        moduleData.modeTypeIcon = "@drawable/edge_engine_arrow_up";
    } else if (index == 1) {
        moduleData.currencyShow = "true";
        moduleData.currencyIcon = "@drawable/edge_engine_arrow_up";
        moduleData.filterCurrencies = moduleData.curModeType == ModeType.superMargin ? supportCurrencies : supportSymbols;
        moduleData.searchWord = "";
        resetCurrencySearchUI();
    } else if (index == 2) {
        moduleData.filterMoreShow = "true";
    }
}

async function tabClick(tabType) {
    moduleData.loadMoreStatus = "0";
    moduleData.refreshStatus = "0";
    moduleData.currentTabType = tabType;
}

async function resetTitleSelectTab(index) {
    console.log(`wp -----resetTitleSelectTab = ${index}`);
    var selectedItem = null;
    for (var i = 0; i < moduleData.titleData.length; i++) {
        var item = moduleData.titleData[i];
        if (i == index) {
            selectedItem = item;
        }
        item.titleColor = titleColor_Normal;
    }
    if (selectedItem != null) {
        selectedItem.titleColor = titleColor_Selected;
    }
    console.log(`wp -----resetTitleSelectTab  moduleData.currentTabType= ${moduleData.currentTabType}`);
    commonFilterTypes = getFilterMoreTypes();
    moduleData.filterTypes = commonFilterTypes;
    moduleData.curFilterTypeIndex = 0;
    filterType(0);
    requestData(false);
    moduleData.typeHeight = moduleData.currentTabType == TabType.TabTypeRepay ? 100 : 50;
}

async function requestData(isMore) {
    if (moduleData.currentTabType == TabType.TabTypeLoan) {
        requestLoanHistory(isMore);
    } else if (moduleData.currentTabType == TabType.TabTypeRepay) {
        requestRepayHistory(isMore);
    } else if (moduleData.currentTabType == TabType.TabTypeInterest) {
        requestInterestHistory(isMore);
    }
}

async function requestLoanHistory(isMore) {
    var params = {
        limit: limit
    };
    params["begin-time"] = getStartTimestamp();
    params["end-time"] = getEndTimestamp();
    if (moduleData.curFilterCurrencyIndex != 0) {
        if (moduleData.curModeType == ModeType.superMargin) {
            params["currency"] = moduleData.currencyText.toLowerCase();
        } else {
            params["symbol"] = moduleData.curSymbol.toLowerCase();
        }
    }
    if (moduleData.curFilterTypeIndex != 0) {
        var item = moduleData.filterTypes[moduleData.curFilterTypeIndex];
        params["type"] = item.tag;
    }
    var loanData = commonList[TabType.TabTypeLoan];
    if (isMore) {
        params["from"] = loanData.from;
    }
    if (loanData.showLoading) {
        showLoading(true);
    }
    var url = "v1/hbg/margin/loan/history";
    if (moduleData.curModeType == ModeType.superMargin) {
        url = "v1/hbg/super-margin/loan/history";
    }
    let data = await sendRequest(url, params, 0, 4, {
        "Content-Type": "application/json"
    });
    showLoading(false);
    console.log(`wp requestLoanHistory data =${data}`);
    try {
        if (!isMore) {
            commonList[TabType.TabTypeLoan] = getTabListDefaultData();
            if (!data || data == null || data.length == 0) {
                commonList[TabType.TabTypeLoan] = {
                    data: [],
                    emptyVisible: "visible",
                    listVisible: "gone",
                    showLoading: true,
                    from: -1
                };
                moduleData.listData = commonList;
                return;
            }
        } else {
            moduleData.loadMoreStatus = "2";
        }
        handleLoanHistoryData(data);
    } catch (e) {
        console.log(`handle handleLoanHistoryData data error=${e}`);
    }
}

async function handleLoanHistoryData(historys) {
    var loanData = commonList[TabType.TabTypeLoan];
    var loans = loanData.data;
    loanData.emptyVisible = "gone";
    loanData.listVisible = "visible";
    loanData.showLoading = false;
    if (historys.length == limit) {
        let lastLoan = historys[historys.length - 1];
        loanData.from = lastLoan.id;
    } else {
        loanData.from = -1;
    }
    console.log(`wp handleLoanHistoryData loans =${loans}`);
    for (let i = 0; i < historys.length; ++i) {
        let v = historys[i];
        v.index = loans.length;
        v.tag = loans.length;
        if (moduleData.curModeType == ModeType.superMargin) {
            v.title = v.currency.toUpperCase();
            v.currencyVisible = "gone";
        } else {
            v.title = v["display-symbol"].toUpperCase();
            v.currency = v.currency.toUpperCase();
            v.currencyVisible = "visible";
        }
        v.loanType = v.type;
        v.typeContent = getTypeContent(v.loanType);
        v.type = "loan";
        v.loanAmount = thousandsFormatter(v["loan-amount"]);
        v.time = new Date(v.time).Format("yyyy-MM-dd hh:mm:ss");
        loans.push(v);
    }
    moduleData.listData = commonList;
}

async function requestRepayHistory(isMore) {
    var params = {
        limit: limit
    };
    params["begin-time"] = getStartTimestamp();
    params["end-time"] = getEndTimestamp();
    if (moduleData.curFilterCurrencyIndex != 0) {
        if (moduleData.curModeType == ModeType.superMargin) {
            params["currency"] = moduleData.currencyText.toLowerCase();
        } else {
            params["symbol"] = moduleData.curSymbol.toLowerCase();
        }
    }
    if (moduleData.curFilterTypeIndex != 0) {
        var item = moduleData.filterTypes[moduleData.curFilterTypeIndex];
        params["type"] = item.tag;
    }
    var repayData = commonList[TabType.TabTypeRepay];
    if (isMore) {
        params["from"] = repayData.from;
    }
    if (repayData.showLoading) {
        showLoading(true);
    }
    var url = "v1/hbg/margin/repay/history";
    if (moduleData.curModeType == ModeType.superMargin) {
        url = "v1/hbg/super-margin/repay/history";
    }
    let data = await sendRequest(url, params, 0, 4, {
        "Content-Type": "application/json"
    });
    showLoading(false);
    console.log(`wp requestRepayHistory data =${data}`);
    try {
        if (!isMore) {
            commonList[TabType.TabTypeRepay] = getTabListDefaultData();
            if (!data || data == null || data.length == 0) {
                commonList[TabType.TabTypeRepay] = {
                    data: [],
                    emptyVisible: "visible",
                    listVisible: "gone",
                    showLoading: true,
                    from: -1
                };
                moduleData.listData = commonList;
                return;
            }
        } else {
            moduleData.loadMoreStatus = "2";
        }
        handleRepayHistoryData(data);
    } catch (e) {
        console.log(`handle handleLoanHistoryData data error=${e}`);
    }
}

async function handleRepayHistoryData(historys) {
    var repayData = commonList[TabType.TabTypeRepay];
    var repays = repayData.data;
    repayData.emptyVisible = "gone";
    repayData.listVisible = "visible";
    repayData.showLoading = false;
    if (historys.length == limit) {
        let lastRepay = historys[historys.length - 1];
        repayData.from = lastRepay.id;
    } else {
        repayData.from = -1;
    }
    console.log(`wp handleRepayHistoryData repays =${repays}`);
    for (let i = 0; i < historys.length; ++i) {
        let v = historys[i];
        v.index = repays.length;
        v.tag = repays.length;
        v.repayType = v.type;
        v.typeContent = getTypeContent(v.repayType);
        v.type = "repay";
        if (moduleData.curModeType == ModeType.superMargin) {
            if (v.repayType == 23) {
                if (v["deduct-type"] == 1) {
                    v.title = $i18n.n_user_center_points_title;
                } else {
                    v.title = v["deduct-currency"].toUpperCase();
                }
            } else {
                v.title = v.currency.toUpperCase();
            }
            v.currencyVisible = "gone";
        } else {
            v.title = v["display-symbol"].toUpperCase();
            if (v.repayType == 23) {
                if (v["deduct-type"] == 1) {
                    v.currency = $i18n.n_user_center_points_title;
                } else {
                    v.currency = v["deduct-currency"].toUpperCase();
                }
            } else {
                v.currency = v.currency.toUpperCase();
            }
            v.currencyVisible = "visible";
        }
        if (v.repayType == 23) {
            v.repayAmountVisible = "gone";
            v.totalAmountVisible = "gone";
            let interest = scientificToNumber(v["deduct-amount"]);
            v.interestAmount = thousandsFormatter(interest);
        } else {
            v.repayAmountVisible = "visible";
            v.totalAmountVisible = "visible";
            v.repayAmount = thousandsFormatter(v["repay-amount"]);
            v.totalAmount = thousandsFormatter(v["total-amount"]);
            let interest = scientificToNumber(v["interest-amount"]);
            v.interestAmount = thousandsFormatter(interest);
        }
        v.time = new Date(v.time).Format("yyyy-MM-dd hh:mm:ss");
        repays.push(v);
    }
    moduleData.listData = commonList;
}

async function requestInterestHistory(isMore) {
    var params = {
        limit: limit
    };
    params["begin-time"] = getStartTimestamp();
    params["end-time"] = getEndTimestamp();
    if (moduleData.curFilterCurrencyIndex != 0) {
        if (moduleData.curModeType == ModeType.superMargin) {
            params["currency"] = moduleData.currencyText.toLowerCase();
        } else {
            params["symbol"] = moduleData.curSymbol.toLowerCase();
        }
    }
    if (moduleData.curFilterTypeIndex != 0) {
        var item = moduleData.filterTypes[moduleData.curFilterTypeIndex];
        params["type"] = item.tag;
    }
    var interestData = commonList[TabType.TabTypeInterest];
    if (isMore) {
        params["from"] = interestData.from;
    }
    if (interestData.showLoading) {
        showLoading(true);
    }
    var url = "v1/hbg/margin/interest/history";
    if (moduleData.curModeType == ModeType.superMargin) {
        url = "v1/hbg/super-margin/interest/history";
    }
    let data = await sendRequest(url, params, 0, 4, {
        "Content-Type": "application/json"
    });
    showLoading(false);
    console.log(`wp requestInterestHistory data =${data}`);
    try {
        if (!isMore) {
            commonList[TabType.TabTypeInterest] = getTabListDefaultData();
            if (!data || data == null || data.length == 0) {
                commonList[TabType.TabTypeInterest] = {
                    data: [],
                    emptyVisible: "visible",
                    listVisible: "gone",
                    showLoading: true,
                    from: -1
                };
                moduleData.listData = commonList;
                return;
            }
        } else {
            moduleData.loadMoreStatus = "2";
        }
        handleInterestHistoryData(data);
    } catch (e) {
        console.log(`handle handleInterestnHistoryData data error=${e}`);
    }
}

async function handleInterestHistoryData(historys) {
    var interestData = commonList[TabType.TabTypeInterest];
    var interests = interestData.data;
    interestData.emptyVisible = "gone";
    interestData.listVisible = "visible";
    interestData.showLoading = false;
    if (historys.length == limit) {
        let lastRepay = historys[historys.length - 1];
        interestData.from = lastRepay.id;
    } else {
        interestData.from = -1;
    }
    console.log(`wp handleRepayHistoryData interests =${interests}`);
    for (let i = 0; i < historys.length; ++i) {
        let v = historys[i];
        v.index = interests.length;
        v.tag = interests.length;
        if (moduleData.curModeType == ModeType.superMargin) {
            v.title = v.currency.toUpperCase();
        } else {
            v.title = v["display-symbol"].toUpperCase();
        }
        v.currency = v.currency.toUpperCase();
        v.interestType = v.type;
        v.typeContent = getTypeContent(v.interestType);
        v.type = "interest";
        let interest = scientificToNumber(v["interest-amount"]);
        v.interestAmount = thousandsFormatter(interest);
        let rate = multiply(parseFloat(v["interest-rate"]), 100);
        v.interestRate = formatPrecision(rate, 4) + "%";
        v.time = new Date(v.time).Format("yyyy-MM-dd hh:mm:ss");
        interests.push(v);
    }
    moduleData.listData = commonList;
}

function getStartTimestamp() {
    const firstTime = new Date(moduleData.startTime).setHours(0, 0, 0);
    const startTimestamp = new Date(firstTime).getTime();
    return startTimestamp;
}

function getEndTimestamp() {
    const lastTime = new Date(moduleData.endTime).setHours(23, 59, 59);
    const endTimestamp = new Date(lastTime).getTime();
    return endTimestamp;
}

async function requestSuperMarginCurrencies() {
    console.log("requestSuperMarginCurrencies");
    var params = {
        ts: "0",
        language: commonData.language
    };
    var respList = await sendRequest("v2/settings/common/currencies", params, 0, 4, {}, 1);
    if (respList) {
        supportCurrencies = [];
        if (moduleData.curModeType == ModeType.superMargin && moduleData.curSymbol != null) {
            supportCurrencies.push({
                type: "normal",
                title: $i18n.n_earn_all_coin,
                titleColor: buttonTitleColor_Normal,
                currencySelected: "gone",
                tag: 0
            });
        } else {
            supportCurrencies.push({
                type: "normal",
                title: $i18n.n_earn_all_coin,
                titleColor: buttonTitleColor_Selected,
                currencySelected: "visible",
                tag: 0
            });
        }
        for (let i = 0; i < respList.length; ++i) {
            let v = respList[i];
            v.index = supportCurrencies.length;
            v.tag = supportCurrencies.length;
            v.title = v["dn"];
            v.symbol = v["dn"];
            v.titleColor = buttonTitleColor_Normal;
            v.currencySelected = "gone";
            if (moduleData.curModeType == ModeType.superMargin && moduleData.curSymbol != null && moduleData.curSymbol.toLowerCase() == v.symbol.toLowerCase()) {
                v.titleColor = buttonTitleColor_Selected;
                v.currencySelected = "visible";
                moduleData.curFilterCurrencyIndex = v.index;
            }
            supportCurrencies.push(v);
        }
    }
    if (moduleData.curModeType == ModeType.superMargin) {
        moduleData.filterCurrencies = supportCurrencies;
    }
}

async function requestMarginSymbols() {
    console.log("requestMarginSymbols");
    var params = {
        ts: "0",
        language: commonData.language
    };
    var respList = await sendRequest("v2/settings/common/symbols", params, 0, 4, {}, 1);
    if (respList) {
        supportSymbols = [];
        if (moduleData.curModeType == ModeType.isolateMargin && moduleData.curSymbol != null) {
            supportSymbols.push({
                type: "normal",
                title: $i18n.n_margin_all_currency,
                titleColor: buttonTitleColor_Normal,
                currencySelected: "gone",
                tag: 0
            });
        } else {
            supportSymbols.push({
                type: "normal",
                title: $i18n.n_margin_all_currency,
                titleColor: buttonTitleColor_Selected,
                currencySelected: "visible",
                tag: 0
            });
        }
        for (let i = 0; i < respList.length; ++i) {
            let v = respList[i];
            v.index = supportSymbols.length;
            v.tag = supportSymbols.length;
            v.symbol = v["sc"];
            v.title = await getSymbolDisplayName(v.symbol);
            v.titleColor = buttonTitleColor_Normal;
            v.currencySelected = "gone";
            if (moduleData.curModeType == ModeType.isolateMargin && moduleData.curSymbol != null && moduleData.curSymbol.toLowerCase() == v.symbol.toLowerCase()) {
                v.titleColor = buttonTitleColor_Selected;
                v.currencySelected = "visible";
                moduleData.curFilterCurrencyIndex = v.index;
            }
            supportSymbols.push(v);
        }
    }
    if (moduleData.curModeType == ModeType.isolateMargin) {
        moduleData.filterCurrencies = supportSymbols;
    }
}

async function modeTypePopDismiss() {
    moduleData.modeTypeShow = "false";
    moduleData.modeTypeIcon = "@drawable/edge_engine_arrow_down";
}

function modeTypePopSelected(modeType) {
    if (moduleData.curModeType != modeType) {
        setModeTypeData(modeType);
        commonList = [ getTabListDefaultData(), getTabListDefaultData(), getTabListDefaultData() ];
        moduleData.listData = commonList;
        resetCurrencyIndex();
        requestData(false);
    }
    moduleData.modeTypeShow = "false";
    moduleData.modeTypeIcon = "@drawable/edge_engine_arrow_down";
}

function resetCurrencySearchUI() {
    if (moduleData.filterCurrencies == null || moduleData.filterCurrencies.length == 0) {
        moduleData.currencyListVisible = "gone";
        moduleData.currencyEmptyVisible = "visible";
    } else {
        moduleData.currencyListVisible = "visible";
        moduleData.currencyEmptyVisible = "gone";
    }
}

function resetCurrencyIndex() {
    moduleData.currencyText = moduleData.curModeType == ModeType.superMargin ? $i18n.n_earn_all_coin : $i18n.n_margin_all_currency;
    moduleData.curFilterCurrencyIndex = 0;
    for (var i = 0; i < supportSymbols.length; i++) {
        var item = supportSymbols[i];
        if (i == 0) {
            item.titleColor = buttonTitleColor_Selected;
            item.currencySelected = "visible";
        } else {
            item.titleColor = buttonTitleColor_Normal;
            item.currencySelected = "gone";
        }
    }
    for (var i = 0; i < supportCurrencies.length; i++) {
        var item = supportCurrencies[i];
        if (i == 0) {
            item.titleColor = buttonTitleColor_Selected;
            item.currencySelected = "visible";
        } else {
            item.titleColor = buttonTitleColor_Normal;
            item.currencySelected = "gone";
        }
    }
}

function setModeTypeData(modeType) {
    console.log(`wp -----setModeTypeData = ${modeType}`);
    moduleData.curModeType = modeType;
    moduleData.superMarginSelected = modeType == ModeType.superMargin ? "visible" : "gone";
    moduleData.isolateMarginSelected = modeType == ModeType.superMargin ? "gone" : "visible";
    moduleData.superMarginColor = modeType == ModeType.superMargin ? "@color/baseColorMajorTheme100" : "@color/kColorPrimaryText";
    moduleData.isolateMarginColor = modeType == ModeType.superMargin ? "@color/kColorPrimaryText" : "@color/baseColorMajorTheme100";
    moduleData.modeTypeText = modeType == ModeType.superMargin ? $i18n.n_contract_super_margin : $i18n.n_contract_trade_margin;
}

async function currencyPopDismiss() {
    moduleData.currencyShow = "false";
    moduleData.currencyIcon = "@drawable/edge_engine_arrow_down";
    moduleData.isFocus = false;
    if (commonData.OS == 1) {
        $nativeAPI.closeKeyboard();
    }
}

function filterList() {
    let supportList = moduleData.curModeType == ModeType.superMargin ? supportCurrencies : supportSymbols;
    if (supportList.length == 0) return;
    if (moduleData.searchWord.trim() == "") {
        moduleData.filterCurrencies = supportList;
    }
    moduleData.filterCurrencies = supportList.filter((function(item) {
        return item.title.toLowerCase().includes(moduleData.searchWord.trim().toLowerCase());
    }));
    resetCurrencySearchUI();
}

moduleEvent.onFocusChange = async function(isFocus) {
    moduleData.isFocus = isFocus;
    console.log(`wp onFocusChange isFocus=${isFocus}`);
    moduleData.borderColor = currentBoarderColor(isFocus);
    moduleData.clearVisible = isFocus ? "visible" : "gone";
};

function currentBoarderColor(isFocus) {
    return isFocus ? Edit_Board_SelectColor : Edit_Board_NomalColor;
}

moduleEvent.onTextChange = function() {
    filterList();
};

async function filterCurrency(index) {
    console.log(`wp filterCurrencys index=${index}`);
    var selectedItem = null;
    let supportList = moduleData.curModeType == ModeType.superMargin ? supportCurrencies : supportSymbols;
    for (var i = 0; i < supportList.length; i++) {
        var item = supportList[i];
        if (i == index) {
            selectedItem = item;
        }
        item.titleColor = buttonTitleColor_Normal;
        item.currencySelected = "gone";
    }
    if (selectedItem != null) {
        selectedItem.titleColor = buttonTitleColor_Selected;
        selectedItem.currencySelected = "visible";
        moduleData.currencyText = selectedItem.title;
        moduleData.curSymbol = selectedItem.symbol;
    }
    moduleData.curFilterCurrencyIndex = index;
    moduleData.currencyShow = "false";
    moduleData.currencyIcon = "@drawable/edge_engine_arrow_down";
    moduleData.filterCurrencies = supportList;
    moduleData.isFocus = false;
    if (commonData.OS == 1) {
        $nativeAPI.closeKeyboard();
    }
    requestData(false);
}

async function filterMorePopDismiss() {
    moduleData.filterMoreShow = "false";
}

async function filterTime(index) {
    filterTimeUI(index);
    moduleData.curFilterTimeIndex = index;
    moduleData.startTime = getStartDay(index);
    moduleData.endTime = getDay(0);
}

function filterTimeUI(index) {
    var selectedItem = null;
    for (var i = 0; i < moduleData.filterTimes.length; i++) {
        var item = moduleData.filterTimes[i];
        if (i == index) {
            selectedItem = item;
        }
        item.titleColor = buttonTitleColor_Normal;
        item.timeBackColor = buttonBackColor_Normal;
    }
    if (selectedItem != null) {
        selectedItem.titleColor = buttonTitleColor_Selected;
        selectedItem.timeBackColor = buttonBackColor_Selected;
    }
}

async function filterStartTime() {
    const startTimestamp = new Date(moduleData.startTime).getTime();
    const endTimestamp = new Date(moduleData.endTime).getTime();
    var param = {
        title: $i18n.n_order_filter_start_time,
        isSelectedStartDate: 1,
        startDate: startTimestamp,
        endDate: endTimestamp
    };
    var selectedTime = await showDatePicker(param);
    if (selectedTime != null) {
        moduleData.startTime = new Date(selectedTime).Format("yyyy-MM-dd");
        moduleData.curFilterTimeIndex = -1;
        filterTimeUI(-1);
    }
}

async function filterEndTime() {
    const startTimestamp = new Date(moduleData.startTime).getTime();
    const endTimestamp = new Date(moduleData.endTime).getTime();
    var param = {
        title: $i18n.n_order_filter_end_time,
        isSelectedStartDate: 0,
        startDate: startTimestamp,
        endDate: endTimestamp
    };
    var selectedTime = await showDatePicker(param);
    if (selectedTime != null) {
        moduleData.endTime = new Date(selectedTime).Format("yyyy-MM-dd");
        moduleData.curFilterTimeIndex = -1;
        filterTimeUI(-1);
    }
}

async function filterType(index) {
    console.log(`wp filterType index=${index}`);
    if (moduleData.curFilterTypeIndex != index) {
        var selectedItem = null;
        for (var i = 0; i < commonFilterTypes.length; i++) {
            var item = commonFilterTypes[i];
            if (i == index) {
                selectedItem = item;
            }
            item.titleColor = buttonTitleColor_Normal;
            item.backColor = buttonBackColor_Normal;
        }
        if (selectedItem != null) {
            console.log(`wp filterType selectedItem.index=${selectedItem.index}`);
            selectedItem.titleColor = buttonTitleColor_Selected;
            selectedItem.backColor = buttonBackColor_Selected;
        }
        moduleData.filterTypes = commonFilterTypes;
        moduleData.curFilterTypeIndex = index;
    }
}

async function filterReset() {
    filterTime(2);
    filterType(0);
    defaultFilterData();
}

async function filterSure() {
    moduleData.filterMoreShow = "false";
    requestData(false);
}

function defaultFilterData() {
    moduleData.startTime = getDay(-119);
    moduleData.endTime = getDay(0);
    moduleData.curFilterTimeIndex = 2;
    moduleData.curFilterTypeIndex = 0;
}

function getStartDay(index) {
    if (index == 0) {
        return getDay(-6);
    } else if (index == 1) {
        return getDay(-29);
    } else {
        return getDay(-119);
    }
}

function getDay(day) {
    var today = new Date;
    var targetday_milliseconds = today.getTime() + 1e3 * 60 * 60 * 24 * day;
    today.setTime(targetday_milliseconds);
    var tYear = today.getFullYear();
    var tMonth = today.getMonth();
    var tDate = today.getDate();
    tMonth = doHandleMonth(tMonth + 1);
    tDate = doHandleMonth(tDate);
    return tYear + "-" + tMonth + "-" + tDate;
}

function doHandleMonth(month) {
    var m = month;
    if (month.toString().length == 1) {
        m = "0" + month;
    }
    return m;
}

function getFilterMoreTypes() {
    if (moduleData.currentTabType == TabType.TabTypeLoan) {
        return [ {
            type: "normal",
            title: $i18n.n_option_market_list_setting_all_type,
            titleColor: buttonTitleColor_Selected,
            backColor: buttonBackColor_Selected,
            index: 0,
            tag: 0
        }, {
            type: "normal",
            title: $i18n.n_trade_margin_auto_borrow,
            titleColor: buttonTitleColor_Normal,
            backColor: buttonBackColor_Normal,
            index: 1,
            tag: 11
        }, {
            type: "normal",
            title: $i18n.n_margin_manual_loan,
            titleColor: buttonTitleColor_Normal,
            backColor: buttonBackColor_Normal,
            index: 2,
            tag: 12
        } ];
    } else if (moduleData.currentTabType == TabType.TabTypeRepay) {
        return [ {
            type: "normal",
            title: $i18n.n_option_market_list_setting_all_type,
            titleColor: buttonTitleColor_Selected,
            backColor: buttonBackColor_Selected,
            index: 0,
            tag: 0
        }, {
            type: "normal",
            title: $i18n.n_trade_margin_auto_repay,
            titleColor: buttonTitleColor_Normal,
            backColor: buttonBackColor_Normal,
            index: 1,
            tag: 22
        }, {
            type: "normal",
            title: $i18n.n_margin_manual_repay,
            titleColor: buttonTitleColor_Normal,
            backColor: buttonBackColor_Normal,
            index: 2,
            tag: 21
        }, {
            type: "normal",
            title: $i18n.n_margin_auto_deduction_repay,
            titleColor: buttonTitleColor_Normal,
            backColor: buttonBackColor_Normal,
            index: 3,
            tag: 23
        }, {
            type: "normal",
            title: $i18n.n_margin_system_repay,
            titleColor: buttonTitleColor_Normal,
            backColor: buttonBackColor_Normal,
            index: 4,
            tag: 24
        } ];
    } else if (moduleData.currentTabType == TabType.TabTypeInterest) {
        return [ {
            type: "normal",
            title: $i18n.n_option_market_list_setting_all_type,
            titleColor: buttonTitleColor_Selected,
            backColor: buttonBackColor_Selected,
            index: 0,
            tag: 0
        }, {
            type: "normal",
            title: $i18n.n_margin_loan_interest,
            titleColor: buttonTitleColor_Normal,
            backColor: buttonBackColor_Normal,
            index: 1,
            tag: 32
        }, {
            type: "normal",
            title: $i18n.n_margin_timing_interest,
            titleColor: buttonTitleColor_Normal,
            backColor: buttonBackColor_Normal,
            index: 2,
            tag: 31
        } ];
    }
    return [];
}

function getTabTitleData() {
    var loanTitleColor = moduleData.currentTabType == TabType.TabTypeLoan ? titleColor_Selected : titleColor_Normal;
    var repayTitleColor = moduleData.currentTabType == TabType.TabTypeRepay ? titleColor_Selected : titleColor_Normal;
    var interestTitleColor = moduleData.currentTabType == TabType.TabTypeInterest ? titleColor_Selected : titleColor_Normal;
    return [ {
        type: "normal",
        title: $i18n.n_margin_loan_history,
        titleColor: loanTitleColor,
        tag: TabType.TabTypeLoan
    }, {
        type: "normal",
        title: $i18n.n_margin_repay_history,
        titleColor: repayTitleColor,
        tag: TabType.TabTypeRepay
    }, {
        type: "normal",
        title: $i18n.n_margin_interest_history,
        titleColor: interestTitleColor,
        tag: TabType.TabTypeInterest
    } ];
}

function getTabListDefaultData() {
    return {
        data: [],
        emptyVisible: "gone",
        listVisible: "gone",
        showLoading: true,
        from: -1
    };
}

function getTypePopContent(type) {
    if (moduleData.currentTabType == TabType.TabTypeLoan) {
        if (type == 11) {
            return $i18n.n_margin_auto_loan_tips;
        } else if (type == 12) {
            return $i18n.n_margin_manual_loan_tips;
        }
    } else if (moduleData.currentTabType == TabType.TabTypeRepay) {
        if (type == 22) {
            return $i18n.n_margin_auto_repay_tips;
        } else if (type == 21) {
            return $i18n.n_margin_manual_repay_tips;
        } else if (type == 23) {
            return $i18n.n_margin_auto_deduction_repay_tips;
        } else if (type == 24) {
            return $i18n.n_margin_system_repay_tips;
        }
    } else if (moduleData.currentTabType == TabType.TabTypeInterest) {
        if (type == 31) {
            return $i18n.n_margin_timing_interest_tips;
        } else if (type == 32) {
            return $i18n.n_margin_loan_interest_tips;
        }
    }
    return "--";
}

function getTypeContent(type) {
    if (moduleData.currentTabType == TabType.TabTypeLoan) {
        if (type == 11) {
            return $i18n.n_trade_margin_auto_borrow;
        } else if (type == 12) {
            return $i18n.n_margin_manual_loan;
        }
    } else if (moduleData.currentTabType == TabType.TabTypeRepay) {
        if (type == 21) {
            return $i18n.n_margin_manual_repay;
        } else if (type == 22) {
            return $i18n.n_margin_auto_repay;
        } else if (type == 23) {
            return $i18n.n_margin_auto_deduction_repay;
        } else if (type == 24) {
            return $i18n.n_margin_system_repay;
        }
    } else if (moduleData.currentTabType == TabType.TabTypeInterest) {
        if (type == 31) {
            return $i18n.n_margin_timing_interest;
        } else if (type == 32) {
            return $i18n.n_margin_loan_interest;
        }
    }
    return "--";
}

async function onRefresh() {
    requestData(false);
}

async function onLoadMore() {
    var curData = commonList[moduleData.currentTabType];
    if (curData.from !== -1) {
        requestData(true);
    } else {
        moduleData.loadMoreStatus = "2";
    }
}

function clickedClear() {
    moduleData.filterCurrencies = moduleData.curModeType == ModeType.superMargin ? supportCurrencies : supportSymbols;
    moduleData.searchWord = "";
    resetCurrencySearchUI();
}

function typeClick(type) {
    let conetent = getTypePopContent(type);
    popUpContentOfOneButton($i18n.n_mining_type, conetent);
}

moduleEvent.filterClick = filterClick;

moduleEvent.tabClick = tabClick;

moduleEvent.typeClick = typeClick;

moduleEvent.resetTitleSelectTab = resetTitleSelectTab;

moduleEvent.modeTypePopDismiss = modeTypePopDismiss;

moduleEvent.modeTypePopSelected = modeTypePopSelected;

moduleEvent.currencyPopDismiss = currencyPopDismiss;

moduleEvent.clickedClear = clickedClear;

moduleEvent.filterMorePopDismiss = filterMorePopDismiss;

moduleEvent.filterCurrency = filterCurrency;

moduleEvent.filterStartTime = filterStartTime;

moduleEvent.filterEndTime = filterEndTime;

moduleEvent.filterTime = filterTime;

moduleEvent.filterType = filterType;

moduleEvent.filterReset = filterReset;

moduleEvent.filterSure = filterSure;

moduleEvent.onRefresh = onRefresh;

moduleEvent.onLoadMore = onLoadMore;

function sendCommonConfig(param) {
    sendCommonConfig$1(param);
}

async function moduleAppear() {
    console.log("moduleAppear");
}

function moduleWillDisappear() {}

async function moduleDisappear() {
    console.log("moduleDisappear");
}

$event.sendCommonConfig = sendCommonConfig;

$event.moduleAppear = moduleAppear;

$event.moduleDisappear = moduleDisappear;

$event.moduleWillDisappear = moduleWillDisappear;
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWFpbi5qcyIsInNvdXJjZXMiOlsiLi4vLi4vcmVwb3NpdG9yeS9ub2RlX21vZHVsZXMvYmlnLmpzL2JpZy5tanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9udW1iZXIuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9jb21tb24uanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9jb21tb25Qb3AuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9zZWxlY3RDdXJyZW5jeVBvcC5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL2hvbWUuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9sZXZlckhpc3RvcnkuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9tYWluLmpzIl0sInNvdXJjZXNDb250ZW50IjpbIi8qXHJcbiAqICBiaWcuanMgdjUuMi4yXHJcbiAqICBBIHNtYWxsLCBmYXN0LCBlYXN5LXRvLXVzZSBsaWJyYXJ5IGZvciBhcmJpdHJhcnktcHJlY2lzaW9uIGRlY2ltYWwgYXJpdGhtZXRpYy5cclxuICogIENvcHlyaWdodCAoYykgMjAxOCBNaWNoYWVsIE1jbGF1Z2hsaW4gPE04Y2g4OGxAZ21haWwuY29tPlxyXG4gKiAgaHR0cHM6Ly9naXRodWIuY29tL01pa2VNY2wvYmlnLmpzL0xJQ0VOQ0VcclxuICovXHJcblxyXG5cclxuLyoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqIEVESVRBQkxFIERFRkFVTFRTICoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqL1xyXG5cclxuXHJcbiAgLy8gVGhlIGRlZmF1bHQgdmFsdWVzIGJlbG93IG11c3QgYmUgaW50ZWdlcnMgd2l0aGluIHRoZSBzdGF0ZWQgcmFuZ2VzLlxyXG5cclxuICAvKlxyXG4gICAqIFRoZSBtYXhpbXVtIG51bWJlciBvZiBkZWNpbWFsIHBsYWNlcyAoRFApIG9mIHRoZSByZXN1bHRzIG9mIG9wZXJhdGlvbnMgaW52b2x2aW5nIGRpdmlzaW9uOlxyXG4gICAqIGRpdiBhbmQgc3FydCwgYW5kIHBvdyB3aXRoIG5lZ2F0aXZlIGV4cG9uZW50cy5cclxuICAgKi9cclxudmFyIERQID0gMjAsICAgICAgICAgIC8vIDAgdG8gTUFYX0RQXHJcblxyXG4gIC8qXHJcbiAgICogVGhlIHJvdW5kaW5nIG1vZGUgKFJNKSB1c2VkIHdoZW4gcm91bmRpbmcgdG8gdGhlIGFib3ZlIGRlY2ltYWwgcGxhY2VzLlxyXG4gICAqXHJcbiAgICogIDAgIFRvd2FyZHMgemVybyAoaS5lLiB0cnVuY2F0ZSwgbm8gcm91bmRpbmcpLiAgICAgICAoUk9VTkRfRE9XTilcclxuICAgKiAgMSAgVG8gbmVhcmVzdCBuZWlnaGJvdXIuIElmIGVxdWlkaXN0YW50LCByb3VuZCB1cC4gIChST1VORF9IQUxGX1VQKVxyXG4gICAqICAyICBUbyBuZWFyZXN0IG5laWdoYm91ci4gSWYgZXF1aWRpc3RhbnQsIHRvIGV2ZW4uICAgKFJPVU5EX0hBTEZfRVZFTilcclxuICAgKiAgMyAgQXdheSBmcm9tIHplcm8uICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIChST1VORF9VUClcclxuICAgKi9cclxuICBSTSA9IDEsICAgICAgICAgICAgIC8vIDAsIDEsIDIgb3IgM1xyXG5cclxuICAvLyBUaGUgbWF4aW11bSB2YWx1ZSBvZiBEUCBhbmQgQmlnLkRQLlxyXG4gIE1BWF9EUCA9IDFFNiwgICAgICAgLy8gMCB0byAxMDAwMDAwXHJcblxyXG4gIC8vIFRoZSBtYXhpbXVtIG1hZ25pdHVkZSBvZiB0aGUgZXhwb25lbnQgYXJndW1lbnQgdG8gdGhlIHBvdyBtZXRob2QuXHJcbiAgTUFYX1BPV0VSID0gMUU2LCAgICAvLyAxIHRvIDEwMDAwMDBcclxuXHJcbiAgLypcclxuICAgKiBUaGUgbmVnYXRpdmUgZXhwb25lbnQgKE5FKSBhdCBhbmQgYmVuZWF0aCB3aGljaCB0b1N0cmluZyByZXR1cm5zIGV4cG9uZW50aWFsIG5vdGF0aW9uLlxyXG4gICAqIChKYXZhU2NyaXB0IG51bWJlcnM6IC03KVxyXG4gICAqIC0xMDAwMDAwIGlzIHRoZSBtaW5pbXVtIHJlY29tbWVuZGVkIGV4cG9uZW50IHZhbHVlIG9mIGEgQmlnLlxyXG4gICAqL1xyXG4gIE5FID0gLTcsICAgICAgICAgICAgLy8gMCB0byAtMTAwMDAwMFxyXG5cclxuICAvKlxyXG4gICAqIFRoZSBwb3NpdGl2ZSBleHBvbmVudCAoUEUpIGF0IGFuZCBhYm92ZSB3aGljaCB0b1N0cmluZyByZXR1cm5zIGV4cG9uZW50aWFsIG5vdGF0aW9uLlxyXG4gICAqIChKYXZhU2NyaXB0IG51bWJlcnM6IDIxKVxyXG4gICAqIDEwMDAwMDAgaXMgdGhlIG1heGltdW0gcmVjb21tZW5kZWQgZXhwb25lbnQgdmFsdWUgb2YgYSBCaWcuXHJcbiAgICogKFRoaXMgbGltaXQgaXMgbm90IGVuZm9yY2VkIG9yIGNoZWNrZWQuKVxyXG4gICAqL1xyXG4gIFBFID0gMjEsICAgICAgICAgICAgLy8gMCB0byAxMDAwMDAwXHJcblxyXG5cclxuLyoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqL1xyXG5cclxuXHJcbiAgLy8gRXJyb3IgbWVzc2FnZXMuXHJcbiAgTkFNRSA9ICdbYmlnLmpzXSAnLFxyXG4gIElOVkFMSUQgPSBOQU1FICsgJ0ludmFsaWQgJyxcclxuICBJTlZBTElEX0RQID0gSU5WQUxJRCArICdkZWNpbWFsIHBsYWNlcycsXHJcbiAgSU5WQUxJRF9STSA9IElOVkFMSUQgKyAncm91bmRpbmcgbW9kZScsXHJcbiAgRElWX0JZX1pFUk8gPSBOQU1FICsgJ0RpdmlzaW9uIGJ5IHplcm8nLFxyXG5cclxuICAvLyBUaGUgc2hhcmVkIHByb3RvdHlwZSBvYmplY3QuXHJcbiAgUCA9IHt9LFxyXG4gIFVOREVGSU5FRCA9IHZvaWQgMCxcclxuICBOVU1FUklDID0gL14tPyhcXGQrKFxcLlxcZCopP3xcXC5cXGQrKShlWystXT9cXGQrKT8kL2k7XHJcblxyXG5cclxuLypcclxuICogQ3JlYXRlIGFuZCByZXR1cm4gYSBCaWcgY29uc3RydWN0b3IuXHJcbiAqXHJcbiAqL1xyXG5mdW5jdGlvbiBfQmlnXygpIHtcclxuXHJcbiAgLypcclxuICAgKiBUaGUgQmlnIGNvbnN0cnVjdG9yIGFuZCBleHBvcnRlZCBmdW5jdGlvbi5cclxuICAgKiBDcmVhdGUgYW5kIHJldHVybiBhIG5ldyBpbnN0YW5jZSBvZiBhIEJpZyBudW1iZXIgb2JqZWN0LlxyXG4gICAqXHJcbiAgICogbiB7bnVtYmVyfHN0cmluZ3xCaWd9IEEgbnVtZXJpYyB2YWx1ZS5cclxuICAgKi9cclxuICBmdW5jdGlvbiBCaWcobikge1xyXG4gICAgdmFyIHggPSB0aGlzO1xyXG5cclxuICAgIC8vIEVuYWJsZSBjb25zdHJ1Y3RvciB1c2FnZSB3aXRob3V0IG5ldy5cclxuICAgIGlmICghKHggaW5zdGFuY2VvZiBCaWcpKSByZXR1cm4gbiA9PT0gVU5ERUZJTkVEID8gX0JpZ18oKSA6IG5ldyBCaWcobik7XHJcblxyXG4gICAgLy8gRHVwbGljYXRlLlxyXG4gICAgaWYgKG4gaW5zdGFuY2VvZiBCaWcpIHtcclxuICAgICAgeC5zID0gbi5zO1xyXG4gICAgICB4LmUgPSBuLmU7XHJcbiAgICAgIHguYyA9IG4uYy5zbGljZSgpO1xyXG4gICAgfSBlbHNlIHtcclxuICAgICAgcGFyc2UoeCwgbik7XHJcbiAgICB9XHJcblxyXG4gICAgLypcclxuICAgICAqIFJldGFpbiBhIHJlZmVyZW5jZSB0byB0aGlzIEJpZyBjb25zdHJ1Y3RvciwgYW5kIHNoYWRvdyBCaWcucHJvdG90eXBlLmNvbnN0cnVjdG9yIHdoaWNoXHJcbiAgICAgKiBwb2ludHMgdG8gT2JqZWN0LlxyXG4gICAgICovXHJcbiAgICB4LmNvbnN0cnVjdG9yID0gQmlnO1xyXG4gIH1cclxuXHJcbiAgQmlnLnByb3RvdHlwZSA9IFA7XHJcbiAgQmlnLkRQID0gRFA7XHJcbiAgQmlnLlJNID0gUk07XHJcbiAgQmlnLk5FID0gTkU7XHJcbiAgQmlnLlBFID0gUEU7XHJcbiAgQmlnLnZlcnNpb24gPSAnNS4yLjInO1xyXG5cclxuICByZXR1cm4gQmlnO1xyXG59XHJcblxyXG5cclxuLypcclxuICogUGFyc2UgdGhlIG51bWJlciBvciBzdHJpbmcgdmFsdWUgcGFzc2VkIHRvIGEgQmlnIGNvbnN0cnVjdG9yLlxyXG4gKlxyXG4gKiB4IHtCaWd9IEEgQmlnIG51bWJlciBpbnN0YW5jZS5cclxuICogbiB7bnVtYmVyfHN0cmluZ30gQSBudW1lcmljIHZhbHVlLlxyXG4gKi9cclxuZnVuY3Rpb24gcGFyc2UoeCwgbikge1xyXG4gIHZhciBlLCBpLCBubDtcclxuXHJcbiAgLy8gTWludXMgemVybz9cclxuICBpZiAobiA9PT0gMCAmJiAxIC8gbiA8IDApIG4gPSAnLTAnO1xyXG4gIGVsc2UgaWYgKCFOVU1FUklDLnRlc3QobiArPSAnJykpIHRocm93IEVycm9yKElOVkFMSUQgKyAnbnVtYmVyJyk7XHJcblxyXG4gIC8vIERldGVybWluZSBzaWduLlxyXG4gIHgucyA9IG4uY2hhckF0KDApID09ICctJyA/IChuID0gbi5zbGljZSgxKSwgLTEpIDogMTtcclxuXHJcbiAgLy8gRGVjaW1hbCBwb2ludD9cclxuICBpZiAoKGUgPSBuLmluZGV4T2YoJy4nKSkgPiAtMSkgbiA9IG4ucmVwbGFjZSgnLicsICcnKTtcclxuXHJcbiAgLy8gRXhwb25lbnRpYWwgZm9ybT9cclxuICBpZiAoKGkgPSBuLnNlYXJjaCgvZS9pKSkgPiAwKSB7XHJcblxyXG4gICAgLy8gRGV0ZXJtaW5lIGV4cG9uZW50LlxyXG4gICAgaWYgKGUgPCAwKSBlID0gaTtcclxuICAgIGUgKz0gK24uc2xpY2UoaSArIDEpO1xyXG4gICAgbiA9IG4uc3Vic3RyaW5nKDAsIGkpO1xyXG4gIH0gZWxzZSBpZiAoZSA8IDApIHtcclxuXHJcbiAgICAvLyBJbnRlZ2VyLlxyXG4gICAgZSA9IG4ubGVuZ3RoO1xyXG4gIH1cclxuXHJcbiAgbmwgPSBuLmxlbmd0aDtcclxuXHJcbiAgLy8gRGV0ZXJtaW5lIGxlYWRpbmcgemVyb3MuXHJcbiAgZm9yIChpID0gMDsgaSA8IG5sICYmIG4uY2hhckF0KGkpID09ICcwJzspICsraTtcclxuXHJcbiAgaWYgKGkgPT0gbmwpIHtcclxuXHJcbiAgICAvLyBaZXJvLlxyXG4gICAgeC5jID0gW3guZSA9IDBdO1xyXG4gIH0gZWxzZSB7XHJcblxyXG4gICAgLy8gRGV0ZXJtaW5lIHRyYWlsaW5nIHplcm9zLlxyXG4gICAgZm9yICg7IG5sID4gMCAmJiBuLmNoYXJBdCgtLW5sKSA9PSAnMCc7KTtcclxuICAgIHguZSA9IGUgLSBpIC0gMTtcclxuICAgIHguYyA9IFtdO1xyXG5cclxuICAgIC8vIENvbnZlcnQgc3RyaW5nIHRvIGFycmF5IG9mIGRpZ2l0cyB3aXRob3V0IGxlYWRpbmcvdHJhaWxpbmcgemVyb3MuXHJcbiAgICBmb3IgKGUgPSAwOyBpIDw9IG5sOykgeC5jW2UrK10gPSArbi5jaGFyQXQoaSsrKTtcclxuICB9XHJcblxyXG4gIHJldHVybiB4O1xyXG59XHJcblxyXG5cclxuLypcclxuICogUm91bmQgQmlnIHggdG8gYSBtYXhpbXVtIG9mIGRwIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgcm0uXHJcbiAqIENhbGxlZCBieSBzdHJpbmdpZnksIFAuZGl2LCBQLnJvdW5kIGFuZCBQLnNxcnQuXHJcbiAqXHJcbiAqIHgge0JpZ30gVGhlIEJpZyB0byByb3VuZC5cclxuICogZHAge251bWJlcn0gSW50ZWdlciwgMCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKiBybSB7bnVtYmVyfSAwLCAxLCAyIG9yIDMgKERPV04sIEhBTEZfVVAsIEhBTEZfRVZFTiwgVVApXHJcbiAqIFttb3JlXSB7Ym9vbGVhbn0gV2hldGhlciB0aGUgcmVzdWx0IG9mIGRpdmlzaW9uIHdhcyB0cnVuY2F0ZWQuXHJcbiAqL1xyXG5mdW5jdGlvbiByb3VuZCh4LCBkcCwgcm0sIG1vcmUpIHtcclxuICB2YXIgeGMgPSB4LmMsXHJcbiAgICBpID0geC5lICsgZHAgKyAxO1xyXG5cclxuICBpZiAoaSA8IHhjLmxlbmd0aCkge1xyXG4gICAgaWYgKHJtID09PSAxKSB7XHJcblxyXG4gICAgICAvLyB4Y1tpXSBpcyB0aGUgZGlnaXQgYWZ0ZXIgdGhlIGRpZ2l0IHRoYXQgbWF5IGJlIHJvdW5kZWQgdXAuXHJcbiAgICAgIG1vcmUgPSB4Y1tpXSA+PSA1O1xyXG4gICAgfSBlbHNlIGlmIChybSA9PT0gMikge1xyXG4gICAgICBtb3JlID0geGNbaV0gPiA1IHx8IHhjW2ldID09IDUgJiZcclxuICAgICAgICAobW9yZSB8fCBpIDwgMCB8fCB4Y1tpICsgMV0gIT09IFVOREVGSU5FRCB8fCB4Y1tpIC0gMV0gJiAxKTtcclxuICAgIH0gZWxzZSBpZiAocm0gPT09IDMpIHtcclxuICAgICAgbW9yZSA9IG1vcmUgfHwgISF4Y1swXTtcclxuICAgIH0gZWxzZSB7XHJcbiAgICAgIG1vcmUgPSBmYWxzZTtcclxuICAgICAgaWYgKHJtICE9PSAwKSB0aHJvdyBFcnJvcihJTlZBTElEX1JNKTtcclxuICAgIH1cclxuXHJcbiAgICBpZiAoaSA8IDEpIHtcclxuICAgICAgeGMubGVuZ3RoID0gMTtcclxuXHJcbiAgICAgIGlmIChtb3JlKSB7XHJcblxyXG4gICAgICAgIC8vIDEsIDAuMSwgMC4wMSwgMC4wMDEsIDAuMDAwMSBldGMuXHJcbiAgICAgICAgeC5lID0gLWRwO1xyXG4gICAgICAgIHhjWzBdID0gMTtcclxuICAgICAgfSBlbHNlIHtcclxuXHJcbiAgICAgICAgLy8gWmVyby5cclxuICAgICAgICB4Y1swXSA9IHguZSA9IDA7XHJcbiAgICAgIH1cclxuICAgIH0gZWxzZSB7XHJcblxyXG4gICAgICAvLyBSZW1vdmUgYW55IGRpZ2l0cyBhZnRlciB0aGUgcmVxdWlyZWQgZGVjaW1hbCBwbGFjZXMuXHJcbiAgICAgIHhjLmxlbmd0aCA9IGktLTtcclxuXHJcbiAgICAgIC8vIFJvdW5kIHVwP1xyXG4gICAgICBpZiAobW9yZSkge1xyXG5cclxuICAgICAgICAvLyBSb3VuZGluZyB1cCBtYXkgbWVhbiB0aGUgcHJldmlvdXMgZGlnaXQgaGFzIHRvIGJlIHJvdW5kZWQgdXAuXHJcbiAgICAgICAgZm9yICg7ICsreGNbaV0gPiA5Oykge1xyXG4gICAgICAgICAgeGNbaV0gPSAwO1xyXG4gICAgICAgICAgaWYgKCFpLS0pIHtcclxuICAgICAgICAgICAgKyt4LmU7XHJcbiAgICAgICAgICAgIHhjLnVuc2hpZnQoMSk7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgfVxyXG4gICAgICB9XHJcblxyXG4gICAgICAvLyBSZW1vdmUgdHJhaWxpbmcgemVyb3MuXHJcbiAgICAgIGZvciAoaSA9IHhjLmxlbmd0aDsgIXhjWy0taV07KSB4Yy5wb3AoKTtcclxuICAgIH1cclxuICB9IGVsc2UgaWYgKHJtIDwgMCB8fCBybSA+IDMgfHwgcm0gIT09IH5+cm0pIHtcclxuICAgIHRocm93IEVycm9yKElOVkFMSURfUk0pO1xyXG4gIH1cclxuXHJcbiAgcmV0dXJuIHg7XHJcbn1cclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBzdHJpbmcgcmVwcmVzZW50aW5nIHRoZSB2YWx1ZSBvZiBCaWcgeCBpbiBub3JtYWwgb3IgZXhwb25lbnRpYWwgbm90YXRpb24uXHJcbiAqIEhhbmRsZXMgUC50b0V4cG9uZW50aWFsLCBQLnRvRml4ZWQsIFAudG9KU09OLCBQLnRvUHJlY2lzaW9uLCBQLnRvU3RyaW5nIGFuZCBQLnZhbHVlT2YuXHJcbiAqXHJcbiAqIHgge0JpZ31cclxuICogaWQ/IHtudW1iZXJ9IENhbGxlciBpZC5cclxuICogICAgICAgICAxIHRvRXhwb25lbnRpYWxcclxuICogICAgICAgICAyIHRvRml4ZWRcclxuICogICAgICAgICAzIHRvUHJlY2lzaW9uXHJcbiAqICAgICAgICAgNCB2YWx1ZU9mXHJcbiAqIG4/IHtudW1iZXJ8dW5kZWZpbmVkfSBDYWxsZXIncyBhcmd1bWVudC5cclxuICogaz8ge251bWJlcnx1bmRlZmluZWR9XHJcbiAqL1xyXG5mdW5jdGlvbiBzdHJpbmdpZnkoeCwgaWQsIG4sIGspIHtcclxuICB2YXIgZSwgcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICB6ID0gIXguY1swXTtcclxuXHJcbiAgaWYgKG4gIT09IFVOREVGSU5FRCkge1xyXG4gICAgaWYgKG4gIT09IH5+biB8fCBuIDwgKGlkID09IDMpIHx8IG4gPiBNQVhfRFApIHtcclxuICAgICAgdGhyb3cgRXJyb3IoaWQgPT0gMyA/IElOVkFMSUQgKyAncHJlY2lzaW9uJyA6IElOVkFMSURfRFApO1xyXG4gICAgfVxyXG5cclxuICAgIHggPSBuZXcgQmlnKHgpO1xyXG5cclxuICAgIC8vIFRoZSBpbmRleCBvZiB0aGUgZGlnaXQgdGhhdCBtYXkgYmUgcm91bmRlZCB1cC5cclxuICAgIG4gPSBrIC0geC5lO1xyXG5cclxuICAgIC8vIFJvdW5kP1xyXG4gICAgaWYgKHguYy5sZW5ndGggPiArK2spIHJvdW5kKHgsIG4sIEJpZy5STSk7XHJcblxyXG4gICAgLy8gdG9GaXhlZDogcmVjYWxjdWxhdGUgayBhcyB4LmUgbWF5IGhhdmUgY2hhbmdlZCBpZiB2YWx1ZSByb3VuZGVkIHVwLlxyXG4gICAgaWYgKGlkID09IDIpIGsgPSB4LmUgKyBuICsgMTtcclxuXHJcbiAgICAvLyBBcHBlbmQgemVyb3M/XHJcbiAgICBmb3IgKDsgeC5jLmxlbmd0aCA8IGs7KSB4LmMucHVzaCgwKTtcclxuICB9XHJcblxyXG4gIGUgPSB4LmU7XHJcbiAgcyA9IHguYy5qb2luKCcnKTtcclxuICBuID0gcy5sZW5ndGg7XHJcblxyXG4gIC8vIEV4cG9uZW50aWFsIG5vdGF0aW9uP1xyXG4gIGlmIChpZCAhPSAyICYmIChpZCA9PSAxIHx8IGlkID09IDMgJiYgayA8PSBlIHx8IGUgPD0gQmlnLk5FIHx8IGUgPj0gQmlnLlBFKSkge1xyXG4gICAgcyA9IHMuY2hhckF0KDApICsgKG4gPiAxID8gJy4nICsgcy5zbGljZSgxKSA6ICcnKSArIChlIDwgMCA/ICdlJyA6ICdlKycpICsgZTtcclxuXHJcbiAgLy8gTm9ybWFsIG5vdGF0aW9uLlxyXG4gIH0gZWxzZSBpZiAoZSA8IDApIHtcclxuICAgIGZvciAoOyArK2U7KSBzID0gJzAnICsgcztcclxuICAgIHMgPSAnMC4nICsgcztcclxuICB9IGVsc2UgaWYgKGUgPiAwKSB7XHJcbiAgICBpZiAoKytlID4gbikgZm9yIChlIC09IG47IGUtLTspIHMgKz0gJzAnO1xyXG4gICAgZWxzZSBpZiAoZSA8IG4pIHMgPSBzLnNsaWNlKDAsIGUpICsgJy4nICsgcy5zbGljZShlKTtcclxuICB9IGVsc2UgaWYgKG4gPiAxKSB7XHJcbiAgICBzID0gcy5jaGFyQXQoMCkgKyAnLicgKyBzLnNsaWNlKDEpO1xyXG4gIH1cclxuXHJcbiAgcmV0dXJuIHgucyA8IDAgJiYgKCF6IHx8IGlkID09IDQpID8gJy0nICsgcyA6IHM7XHJcbn1cclxuXHJcblxyXG4vLyBQcm90b3R5cGUvaW5zdGFuY2UgbWV0aG9kc1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIGFic29sdXRlIHZhbHVlIG9mIHRoaXMgQmlnLlxyXG4gKi9cclxuUC5hYnMgPSBmdW5jdGlvbiAoKSB7XHJcbiAgdmFyIHggPSBuZXcgdGhpcy5jb25zdHJ1Y3Rvcih0aGlzKTtcclxuICB4LnMgPSAxO1xyXG4gIHJldHVybiB4O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiAxIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBncmVhdGVyIHRoYW4gdGhlIHZhbHVlIG9mIEJpZyB5LFxyXG4gKiAgICAgICAtMSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgbGVzcyB0aGFuIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3JcclxuICogICAgICAgIDAgaWYgdGhleSBoYXZlIHRoZSBzYW1lIHZhbHVlLlxyXG4qL1xyXG5QLmNtcCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIGlzbmVnLFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICB4YyA9IHguYyxcclxuICAgIHljID0gKHkgPSBuZXcgeC5jb25zdHJ1Y3Rvcih5KSkuYyxcclxuICAgIGkgPSB4LnMsXHJcbiAgICBqID0geS5zLFxyXG4gICAgayA9IHguZSxcclxuICAgIGwgPSB5LmU7XHJcblxyXG4gIC8vIEVpdGhlciB6ZXJvP1xyXG4gIGlmICgheGNbMF0gfHwgIXljWzBdKSByZXR1cm4gIXhjWzBdID8gIXljWzBdID8gMCA6IC1qIDogaTtcclxuXHJcbiAgLy8gU2lnbnMgZGlmZmVyP1xyXG4gIGlmIChpICE9IGopIHJldHVybiBpO1xyXG5cclxuICBpc25lZyA9IGkgPCAwO1xyXG5cclxuICAvLyBDb21wYXJlIGV4cG9uZW50cy5cclxuICBpZiAoayAhPSBsKSByZXR1cm4gayA+IGwgXiBpc25lZyA/IDEgOiAtMTtcclxuXHJcbiAgaiA9IChrID0geGMubGVuZ3RoKSA8IChsID0geWMubGVuZ3RoKSA/IGsgOiBsO1xyXG5cclxuICAvLyBDb21wYXJlIGRpZ2l0IGJ5IGRpZ2l0LlxyXG4gIGZvciAoaSA9IC0xOyArK2kgPCBqOykge1xyXG4gICAgaWYgKHhjW2ldICE9IHljW2ldKSByZXR1cm4geGNbaV0gPiB5Y1tpXSBeIGlzbmVnID8gMSA6IC0xO1xyXG4gIH1cclxuXHJcbiAgLy8gQ29tcGFyZSBsZW5ndGhzLlxyXG4gIHJldHVybiBrID09IGwgPyAwIDogayA+IGwgXiBpc25lZyA/IDEgOiAtMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBkaXZpZGVkIGJ5IHRoZSB2YWx1ZSBvZiBCaWcgeSwgcm91bmRlZCxcclxuICogaWYgbmVjZXNzYXJ5LCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgQmlnLlJNLlxyXG4gKi9cclxuUC5kaXYgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5jLCAgICAgICAgICAgICAgICAgIC8vIGRpdmlkZW5kXHJcbiAgICBiID0gKHkgPSBuZXcgQmlnKHkpKS5jLCAgIC8vIGRpdmlzb3JcclxuICAgIGsgPSB4LnMgPT0geS5zID8gMSA6IC0xLFxyXG4gICAgZHAgPSBCaWcuRFA7XHJcblxyXG4gIGlmIChkcCAhPT0gfn5kcCB8fCBkcCA8IDAgfHwgZHAgPiBNQVhfRFApIHRocm93IEVycm9yKElOVkFMSURfRFApO1xyXG5cclxuICAvLyBEaXZpc29yIGlzIHplcm8/XHJcbiAgaWYgKCFiWzBdKSB0aHJvdyBFcnJvcihESVZfQllfWkVSTyk7XHJcblxyXG4gIC8vIERpdmlkZW5kIGlzIDA/IFJldHVybiArLTAuXHJcbiAgaWYgKCFhWzBdKSByZXR1cm4gbmV3IEJpZyhrICogMCk7XHJcblxyXG4gIHZhciBibCwgYnQsIG4sIGNtcCwgcmksXHJcbiAgICBieiA9IGIuc2xpY2UoKSxcclxuICAgIGFpID0gYmwgPSBiLmxlbmd0aCxcclxuICAgIGFsID0gYS5sZW5ndGgsXHJcbiAgICByID0gYS5zbGljZSgwLCBibCksICAgLy8gcmVtYWluZGVyXHJcbiAgICBybCA9IHIubGVuZ3RoLFxyXG4gICAgcSA9IHksICAgICAgICAgICAgICAgIC8vIHF1b3RpZW50XHJcbiAgICBxYyA9IHEuYyA9IFtdLFxyXG4gICAgcWkgPSAwLFxyXG4gICAgZCA9IGRwICsgKHEuZSA9IHguZSAtIHkuZSkgKyAxOyAgICAvLyBudW1iZXIgb2YgZGlnaXRzIG9mIHRoZSByZXN1bHRcclxuXHJcbiAgcS5zID0gaztcclxuICBrID0gZCA8IDAgPyAwIDogZDtcclxuXHJcbiAgLy8gQ3JlYXRlIHZlcnNpb24gb2YgZGl2aXNvciB3aXRoIGxlYWRpbmcgemVyby5cclxuICBiei51bnNoaWZ0KDApO1xyXG5cclxuICAvLyBBZGQgemVyb3MgdG8gbWFrZSByZW1haW5kZXIgYXMgbG9uZyBhcyBkaXZpc29yLlxyXG4gIGZvciAoOyBybCsrIDwgYmw7KSByLnB1c2goMCk7XHJcblxyXG4gIGRvIHtcclxuXHJcbiAgICAvLyBuIGlzIGhvdyBtYW55IHRpbWVzIHRoZSBkaXZpc29yIGdvZXMgaW50byBjdXJyZW50IHJlbWFpbmRlci5cclxuICAgIGZvciAobiA9IDA7IG4gPCAxMDsgbisrKSB7XHJcblxyXG4gICAgICAvLyBDb21wYXJlIGRpdmlzb3IgYW5kIHJlbWFpbmRlci5cclxuICAgICAgaWYgKGJsICE9IChybCA9IHIubGVuZ3RoKSkge1xyXG4gICAgICAgIGNtcCA9IGJsID4gcmwgPyAxIDogLTE7XHJcbiAgICAgIH0gZWxzZSB7XHJcbiAgICAgICAgZm9yIChyaSA9IC0xLCBjbXAgPSAwOyArK3JpIDwgYmw7KSB7XHJcbiAgICAgICAgICBpZiAoYltyaV0gIT0gcltyaV0pIHtcclxuICAgICAgICAgICAgY21wID0gYltyaV0gPiByW3JpXSA/IDEgOiAtMTtcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgfVxyXG4gICAgICB9XHJcblxyXG4gICAgICAvLyBJZiBkaXZpc29yIDwgcmVtYWluZGVyLCBzdWJ0cmFjdCBkaXZpc29yIGZyb20gcmVtYWluZGVyLlxyXG4gICAgICBpZiAoY21wIDwgMCkge1xyXG5cclxuICAgICAgICAvLyBSZW1haW5kZXIgY2FuJ3QgYmUgbW9yZSB0aGFuIDEgZGlnaXQgbG9uZ2VyIHRoYW4gZGl2aXNvci5cclxuICAgICAgICAvLyBFcXVhbGlzZSBsZW5ndGhzIHVzaW5nIGRpdmlzb3Igd2l0aCBleHRyYSBsZWFkaW5nIHplcm8/XHJcbiAgICAgICAgZm9yIChidCA9IHJsID09IGJsID8gYiA6IGJ6OyBybDspIHtcclxuICAgICAgICAgIGlmIChyWy0tcmxdIDwgYnRbcmxdKSB7XHJcbiAgICAgICAgICAgIHJpID0gcmw7XHJcbiAgICAgICAgICAgIGZvciAoOyByaSAmJiAhclstLXJpXTspIHJbcmldID0gOTtcclxuICAgICAgICAgICAgLS1yW3JpXTtcclxuICAgICAgICAgICAgcltybF0gKz0gMTA7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgICByW3JsXSAtPSBidFtybF07XHJcbiAgICAgICAgfVxyXG5cclxuICAgICAgICBmb3IgKDsgIXJbMF07KSByLnNoaWZ0KCk7XHJcbiAgICAgIH0gZWxzZSB7XHJcbiAgICAgICAgYnJlYWs7XHJcbiAgICAgIH1cclxuICAgIH1cclxuXHJcbiAgICAvLyBBZGQgdGhlIGRpZ2l0IG4gdG8gdGhlIHJlc3VsdCBhcnJheS5cclxuICAgIHFjW3FpKytdID0gY21wID8gbiA6ICsrbjtcclxuXHJcbiAgICAvLyBVcGRhdGUgdGhlIHJlbWFpbmRlci5cclxuICAgIGlmIChyWzBdICYmIGNtcCkgcltybF0gPSBhW2FpXSB8fCAwO1xyXG4gICAgZWxzZSByID0gW2FbYWldXTtcclxuXHJcbiAgfSB3aGlsZSAoKGFpKysgPCBhbCB8fCByWzBdICE9PSBVTkRFRklORUQpICYmIGstLSk7XHJcblxyXG4gIC8vIExlYWRpbmcgemVybz8gRG8gbm90IHJlbW92ZSBpZiByZXN1bHQgaXMgc2ltcGx5IHplcm8gKHFpID09IDEpLlxyXG4gIGlmICghcWNbMF0gJiYgcWkgIT0gMSkge1xyXG5cclxuICAgIC8vIFRoZXJlIGNhbid0IGJlIG1vcmUgdGhhbiBvbmUgemVyby5cclxuICAgIHFjLnNoaWZ0KCk7XHJcbiAgICBxLmUtLTtcclxuICB9XHJcblxyXG4gIC8vIFJvdW5kP1xyXG4gIGlmIChxaSA+IGQpIHJvdW5kKHEsIGRwLCBCaWcuUk0sIHJbMF0gIT09IFVOREVGSU5FRCk7XHJcblxyXG4gIHJldHVybiBxO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiB0cnVlIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBlcXVhbCB0byB0aGUgdmFsdWUgb2YgQmlnIHksIG90aGVyd2lzZSByZXR1cm4gZmFsc2UuXHJcbiAqL1xyXG5QLmVxID0gZnVuY3Rpb24gKHkpIHtcclxuICByZXR1cm4gIXRoaXMuY21wKHkpO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiB0cnVlIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBncmVhdGVyIHRoYW4gdGhlIHZhbHVlIG9mIEJpZyB5LCBvdGhlcndpc2UgcmV0dXJuXHJcbiAqIGZhbHNlLlxyXG4gKi9cclxuUC5ndCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgcmV0dXJuIHRoaXMuY21wKHkpID4gMDtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gdHJ1ZSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgZ3JlYXRlciB0aGFuIG9yIGVxdWFsIHRvIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3RoZXJ3aXNlXHJcbiAqIHJldHVybiBmYWxzZS5cclxuICovXHJcblAuZ3RlID0gZnVuY3Rpb24gKHkpIHtcclxuICByZXR1cm4gdGhpcy5jbXAoeSkgPiAtMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gdHJ1ZSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgbGVzcyB0aGFuIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3RoZXJ3aXNlIHJldHVybiBmYWxzZS5cclxuICovXHJcblAubHQgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHJldHVybiB0aGlzLmNtcCh5KSA8IDA7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIHRydWUgaWYgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGlzIGxlc3MgdGhhbiBvciBlcXVhbCB0byB0aGUgdmFsdWUgb2YgQmlnIHksIG90aGVyd2lzZVxyXG4gKiByZXR1cm4gZmFsc2UuXHJcbiAqL1xyXG5QLmx0ZSA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgcmV0dXJuIHRoaXMuY21wKHkpIDwgMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBtaW51cyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLm1pbnVzID0gUC5zdWIgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciBpLCBqLCB0LCB4bHR5LFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgYSA9IHgucyxcclxuICAgIGIgPSAoeSA9IG5ldyBCaWcoeSkpLnM7XHJcblxyXG4gIC8vIFNpZ25zIGRpZmZlcj9cclxuICBpZiAoYSAhPSBiKSB7XHJcbiAgICB5LnMgPSAtYjtcclxuICAgIHJldHVybiB4LnBsdXMoeSk7XHJcbiAgfVxyXG5cclxuICB2YXIgeGMgPSB4LmMuc2xpY2UoKSxcclxuICAgIHhlID0geC5lLFxyXG4gICAgeWMgPSB5LmMsXHJcbiAgICB5ZSA9IHkuZTtcclxuXHJcbiAgLy8gRWl0aGVyIHplcm8/XHJcbiAgaWYgKCF4Y1swXSB8fCAheWNbMF0pIHtcclxuXHJcbiAgICAvLyB5IGlzIG5vbi16ZXJvPyB4IGlzIG5vbi16ZXJvPyBPciBib3RoIGFyZSB6ZXJvLlxyXG4gICAgcmV0dXJuIHljWzBdID8gKHkucyA9IC1iLCB5KSA6IG5ldyBCaWcoeGNbMF0gPyB4IDogMCk7XHJcbiAgfVxyXG5cclxuICAvLyBEZXRlcm1pbmUgd2hpY2ggaXMgdGhlIGJpZ2dlciBudW1iZXIuIFByZXBlbmQgemVyb3MgdG8gZXF1YWxpc2UgZXhwb25lbnRzLlxyXG4gIGlmIChhID0geGUgLSB5ZSkge1xyXG5cclxuICAgIGlmICh4bHR5ID0gYSA8IDApIHtcclxuICAgICAgYSA9IC1hO1xyXG4gICAgICB0ID0geGM7XHJcbiAgICB9IGVsc2Uge1xyXG4gICAgICB5ZSA9IHhlO1xyXG4gICAgICB0ID0geWM7XHJcbiAgICB9XHJcblxyXG4gICAgdC5yZXZlcnNlKCk7XHJcbiAgICBmb3IgKGIgPSBhOyBiLS07KSB0LnB1c2goMCk7XHJcbiAgICB0LnJldmVyc2UoKTtcclxuICB9IGVsc2Uge1xyXG5cclxuICAgIC8vIEV4cG9uZW50cyBlcXVhbC4gQ2hlY2sgZGlnaXQgYnkgZGlnaXQuXHJcbiAgICBqID0gKCh4bHR5ID0geGMubGVuZ3RoIDwgeWMubGVuZ3RoKSA/IHhjIDogeWMpLmxlbmd0aDtcclxuXHJcbiAgICBmb3IgKGEgPSBiID0gMDsgYiA8IGo7IGIrKykge1xyXG4gICAgICBpZiAoeGNbYl0gIT0geWNbYl0pIHtcclxuICAgICAgICB4bHR5ID0geGNbYl0gPCB5Y1tiXTtcclxuICAgICAgICBicmVhaztcclxuICAgICAgfVxyXG4gICAgfVxyXG4gIH1cclxuXHJcbiAgLy8geCA8IHk/IFBvaW50IHhjIHRvIHRoZSBhcnJheSBvZiB0aGUgYmlnZ2VyIG51bWJlci5cclxuICBpZiAoeGx0eSkge1xyXG4gICAgdCA9IHhjO1xyXG4gICAgeGMgPSB5YztcclxuICAgIHljID0gdDtcclxuICAgIHkucyA9IC15LnM7XHJcbiAgfVxyXG5cclxuICAvKlxyXG4gICAqIEFwcGVuZCB6ZXJvcyB0byB4YyBpZiBzaG9ydGVyLiBObyBuZWVkIHRvIGFkZCB6ZXJvcyB0byB5YyBpZiBzaG9ydGVyIGFzIHN1YnRyYWN0aW9uIG9ubHlcclxuICAgKiBuZWVkcyB0byBzdGFydCBhdCB5Yy5sZW5ndGguXHJcbiAgICovXHJcbiAgaWYgKChiID0gKGogPSB5Yy5sZW5ndGgpIC0gKGkgPSB4Yy5sZW5ndGgpKSA+IDApIGZvciAoOyBiLS07KSB4Y1tpKytdID0gMDtcclxuXHJcbiAgLy8gU3VidHJhY3QgeWMgZnJvbSB4Yy5cclxuICBmb3IgKGIgPSBpOyBqID4gYTspIHtcclxuICAgIGlmICh4Y1stLWpdIDwgeWNbal0pIHtcclxuICAgICAgZm9yIChpID0gajsgaSAmJiAheGNbLS1pXTspIHhjW2ldID0gOTtcclxuICAgICAgLS14Y1tpXTtcclxuICAgICAgeGNbal0gKz0gMTA7XHJcbiAgICB9XHJcblxyXG4gICAgeGNbal0gLT0geWNbal07XHJcbiAgfVxyXG5cclxuICAvLyBSZW1vdmUgdHJhaWxpbmcgemVyb3MuXHJcbiAgZm9yICg7IHhjWy0tYl0gPT09IDA7KSB4Yy5wb3AoKTtcclxuXHJcbiAgLy8gUmVtb3ZlIGxlYWRpbmcgemVyb3MgYW5kIGFkanVzdCBleHBvbmVudCBhY2NvcmRpbmdseS5cclxuICBmb3IgKDsgeGNbMF0gPT09IDA7KSB7XHJcbiAgICB4Yy5zaGlmdCgpO1xyXG4gICAgLS15ZTtcclxuICB9XHJcblxyXG4gIGlmICgheGNbMF0pIHtcclxuXHJcbiAgICAvLyBuIC0gbiA9ICswXHJcbiAgICB5LnMgPSAxO1xyXG5cclxuICAgIC8vIFJlc3VsdCBtdXN0IGJlIHplcm8uXHJcbiAgICB4YyA9IFt5ZSA9IDBdO1xyXG4gIH1cclxuXHJcbiAgeS5jID0geGM7XHJcbiAgeS5lID0geWU7XHJcblxyXG4gIHJldHVybiB5O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIG1vZHVsbyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLm1vZCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIHlndHgsXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5zLFxyXG4gICAgYiA9ICh5ID0gbmV3IEJpZyh5KSkucztcclxuXHJcbiAgaWYgKCF5LmNbMF0pIHRocm93IEVycm9yKERJVl9CWV9aRVJPKTtcclxuXHJcbiAgeC5zID0geS5zID0gMTtcclxuICB5Z3R4ID0geS5jbXAoeCkgPT0gMTtcclxuICB4LnMgPSBhO1xyXG4gIHkucyA9IGI7XHJcblxyXG4gIGlmICh5Z3R4KSByZXR1cm4gbmV3IEJpZyh4KTtcclxuXHJcbiAgYSA9IEJpZy5EUDtcclxuICBiID0gQmlnLlJNO1xyXG4gIEJpZy5EUCA9IEJpZy5STSA9IDA7XHJcbiAgeCA9IHguZGl2KHkpO1xyXG4gIEJpZy5EUCA9IGE7XHJcbiAgQmlnLlJNID0gYjtcclxuXHJcbiAgcmV0dXJuIHRoaXMubWludXMoeC50aW1lcyh5KSk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgbmV3IEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgcGx1cyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLnBsdXMgPSBQLmFkZCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIHQsXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5zLFxyXG4gICAgYiA9ICh5ID0gbmV3IEJpZyh5KSkucztcclxuXHJcbiAgLy8gU2lnbnMgZGlmZmVyP1xyXG4gIGlmIChhICE9IGIpIHtcclxuICAgIHkucyA9IC1iO1xyXG4gICAgcmV0dXJuIHgubWludXMoeSk7XHJcbiAgfVxyXG5cclxuICB2YXIgeGUgPSB4LmUsXHJcbiAgICB4YyA9IHguYyxcclxuICAgIHllID0geS5lLFxyXG4gICAgeWMgPSB5LmM7XHJcblxyXG4gIC8vIEVpdGhlciB6ZXJvPyB5IGlzIG5vbi16ZXJvPyB4IGlzIG5vbi16ZXJvPyBPciBib3RoIGFyZSB6ZXJvLlxyXG4gIGlmICgheGNbMF0gfHwgIXljWzBdKSByZXR1cm4geWNbMF0gPyB5IDogbmV3IEJpZyh4Y1swXSA/IHggOiBhICogMCk7XHJcblxyXG4gIHhjID0geGMuc2xpY2UoKTtcclxuXHJcbiAgLy8gUHJlcGVuZCB6ZXJvcyB0byBlcXVhbGlzZSBleHBvbmVudHMuXHJcbiAgLy8gTm90ZTogcmV2ZXJzZSBmYXN0ZXIgdGhhbiB1bnNoaWZ0cy5cclxuICBpZiAoYSA9IHhlIC0geWUpIHtcclxuICAgIGlmIChhID4gMCkge1xyXG4gICAgICB5ZSA9IHhlO1xyXG4gICAgICB0ID0geWM7XHJcbiAgICB9IGVsc2Uge1xyXG4gICAgICBhID0gLWE7XHJcbiAgICAgIHQgPSB4YztcclxuICAgIH1cclxuXHJcbiAgICB0LnJldmVyc2UoKTtcclxuICAgIGZvciAoOyBhLS07KSB0LnB1c2goMCk7XHJcbiAgICB0LnJldmVyc2UoKTtcclxuICB9XHJcblxyXG4gIC8vIFBvaW50IHhjIHRvIHRoZSBsb25nZXIgYXJyYXkuXHJcbiAgaWYgKHhjLmxlbmd0aCAtIHljLmxlbmd0aCA8IDApIHtcclxuICAgIHQgPSB5YztcclxuICAgIHljID0geGM7XHJcbiAgICB4YyA9IHQ7XHJcbiAgfVxyXG5cclxuICBhID0geWMubGVuZ3RoO1xyXG5cclxuICAvLyBPbmx5IHN0YXJ0IGFkZGluZyBhdCB5Yy5sZW5ndGggLSAxIGFzIHRoZSBmdXJ0aGVyIGRpZ2l0cyBvZiB4YyBjYW4gYmUgbGVmdCBhcyB0aGV5IGFyZS5cclxuICBmb3IgKGIgPSAwOyBhOyB4Y1thXSAlPSAxMCkgYiA9ICh4Y1stLWFdID0geGNbYV0gKyB5Y1thXSArIGIpIC8gMTAgfCAwO1xyXG5cclxuICAvLyBObyBuZWVkIHRvIGNoZWNrIGZvciB6ZXJvLCBhcyAreCArICt5ICE9IDAgJiYgLXggKyAteSAhPSAwXHJcblxyXG4gIGlmIChiKSB7XHJcbiAgICB4Yy51bnNoaWZ0KGIpO1xyXG4gICAgKyt5ZTtcclxuICB9XHJcblxyXG4gIC8vIFJlbW92ZSB0cmFpbGluZyB6ZXJvcy5cclxuICBmb3IgKGEgPSB4Yy5sZW5ndGg7IHhjWy0tYV0gPT09IDA7KSB4Yy5wb3AoKTtcclxuXHJcbiAgeS5jID0geGM7XHJcbiAgeS5lID0geWU7XHJcblxyXG4gIHJldHVybiB5O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgcmFpc2VkIHRvIHRoZSBwb3dlciBuLlxyXG4gKiBJZiBuIGlzIG5lZ2F0aXZlLCByb3VuZCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nXHJcbiAqIG1vZGUgQmlnLlJNLlxyXG4gKlxyXG4gKiBuIHtudW1iZXJ9IEludGVnZXIsIC1NQVhfUE9XRVIgdG8gTUFYX1BPV0VSIGluY2x1c2l2ZS5cclxuICovXHJcblAucG93ID0gZnVuY3Rpb24gKG4pIHtcclxuICB2YXIgeCA9IHRoaXMsXHJcbiAgICBvbmUgPSBuZXcgeC5jb25zdHJ1Y3RvcigxKSxcclxuICAgIHkgPSBvbmUsXHJcbiAgICBpc25lZyA9IG4gPCAwO1xyXG5cclxuICBpZiAobiAhPT0gfn5uIHx8IG4gPCAtTUFYX1BPV0VSIHx8IG4gPiBNQVhfUE9XRVIpIHRocm93IEVycm9yKElOVkFMSUQgKyAnZXhwb25lbnQnKTtcclxuICBpZiAoaXNuZWcpIG4gPSAtbjtcclxuXHJcbiAgZm9yICg7Oykge1xyXG4gICAgaWYgKG4gJiAxKSB5ID0geS50aW1lcyh4KTtcclxuICAgIG4gPj49IDE7XHJcbiAgICBpZiAoIW4pIGJyZWFrO1xyXG4gICAgeCA9IHgudGltZXMoeCk7XHJcbiAgfVxyXG5cclxuICByZXR1cm4gaXNuZWcgPyBvbmUuZGl2KHkpIDogeTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyByb3VuZGVkIHVzaW5nIHJvdW5kaW5nIG1vZGUgcm1cclxuICogdG8gYSBtYXhpbXVtIG9mIGRwIGRlY2ltYWwgcGxhY2VzLCBvciwgaWYgZHAgaXMgbmVnYXRpdmUsIHRvIGFuIGludGVnZXIgd2hpY2ggaXMgYVxyXG4gKiBtdWx0aXBsZSBvZiAxMCoqLWRwLlxyXG4gKiBJZiBkcCBpcyBub3Qgc3BlY2lmaWVkLCByb3VuZCB0byAwIGRlY2ltYWwgcGxhY2VzLlxyXG4gKiBJZiBybSBpcyBub3Qgc3BlY2lmaWVkLCB1c2UgQmlnLlJNLlxyXG4gKlxyXG4gKiBkcD8ge251bWJlcn0gSW50ZWdlciwgLU1BWF9EUCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKiBybT8gMCwgMSwgMiBvciAzIChST1VORF9ET1dOLCBST1VORF9IQUxGX1VQLCBST1VORF9IQUxGX0VWRU4sIFJPVU5EX1VQKVxyXG4gKi9cclxuUC5yb3VuZCA9IGZ1bmN0aW9uIChkcCwgcm0pIHtcclxuICB2YXIgQmlnID0gdGhpcy5jb25zdHJ1Y3RvcjtcclxuICBpZiAoZHAgPT09IFVOREVGSU5FRCkgZHAgPSAwO1xyXG4gIGVsc2UgaWYgKGRwICE9PSB+fmRwIHx8IGRwIDwgLU1BWF9EUCB8fCBkcCA+IE1BWF9EUCkgdGhyb3cgRXJyb3IoSU5WQUxJRF9EUCk7XHJcbiAgcmV0dXJuIHJvdW5kKG5ldyBCaWcodGhpcyksIGRwLCBybSA9PT0gVU5ERUZJTkVEID8gQmlnLlJNIDogcm0pO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHNxdWFyZSByb290IG9mIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZywgcm91bmRlZCwgaWZcclxuICogbmVjZXNzYXJ5LCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgQmlnLlJNLlxyXG4gKi9cclxuUC5zcXJ0ID0gZnVuY3Rpb24gKCkge1xyXG4gIHZhciByLCBjLCB0LFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgcyA9IHgucyxcclxuICAgIGUgPSB4LmUsXHJcbiAgICBoYWxmID0gbmV3IEJpZygwLjUpO1xyXG5cclxuICAvLyBaZXJvP1xyXG4gIGlmICgheC5jWzBdKSByZXR1cm4gbmV3IEJpZyh4KTtcclxuXHJcbiAgLy8gTmVnYXRpdmU/XHJcbiAgaWYgKHMgPCAwKSB0aHJvdyBFcnJvcihOQU1FICsgJ05vIHNxdWFyZSByb290Jyk7XHJcblxyXG4gIC8vIEVzdGltYXRlLlxyXG4gIHMgPSBNYXRoLnNxcnQoeCArICcnKTtcclxuXHJcbiAgLy8gTWF0aC5zcXJ0IHVuZGVyZmxvdy9vdmVyZmxvdz9cclxuICAvLyBSZS1lc3RpbWF0ZTogcGFzcyB4IGNvZWZmaWNpZW50IHRvIE1hdGguc3FydCBhcyBpbnRlZ2VyLCB0aGVuIGFkanVzdCB0aGUgcmVzdWx0IGV4cG9uZW50LlxyXG4gIGlmIChzID09PSAwIHx8IHMgPT09IDEgLyAwKSB7XHJcbiAgICBjID0geC5jLmpvaW4oJycpO1xyXG4gICAgaWYgKCEoYy5sZW5ndGggKyBlICYgMSkpIGMgKz0gJzAnO1xyXG4gICAgcyA9IE1hdGguc3FydChjKTtcclxuICAgIGUgPSAoKGUgKyAxKSAvIDIgfCAwKSAtIChlIDwgMCB8fCBlICYgMSk7XHJcbiAgICByID0gbmV3IEJpZygocyA9PSAxIC8gMCA/ICcxZScgOiAocyA9IHMudG9FeHBvbmVudGlhbCgpKS5zbGljZSgwLCBzLmluZGV4T2YoJ2UnKSArIDEpKSArIGUpO1xyXG4gIH0gZWxzZSB7XHJcbiAgICByID0gbmV3IEJpZyhzKTtcclxuICB9XHJcblxyXG4gIGUgPSByLmUgKyAoQmlnLkRQICs9IDQpO1xyXG5cclxuICAvLyBOZXd0b24tUmFwaHNvbiBpdGVyYXRpb24uXHJcbiAgZG8ge1xyXG4gICAgdCA9IHI7XHJcbiAgICByID0gaGFsZi50aW1lcyh0LnBsdXMoeC5kaXYodCkpKTtcclxuICB9IHdoaWxlICh0LmMuc2xpY2UoMCwgZSkuam9pbignJykgIT09IHIuYy5zbGljZSgwLCBlKS5qb2luKCcnKSk7XHJcblxyXG4gIHJldHVybiByb3VuZChyLCBCaWcuRFAgLT0gNCwgQmlnLlJNKTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyB0aW1lcyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLnRpbWVzID0gUC5tdWwgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciBjLFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgeGMgPSB4LmMsXHJcbiAgICB5YyA9ICh5ID0gbmV3IEJpZyh5KSkuYyxcclxuICAgIGEgPSB4Yy5sZW5ndGgsXHJcbiAgICBiID0geWMubGVuZ3RoLFxyXG4gICAgaSA9IHguZSxcclxuICAgIGogPSB5LmU7XHJcblxyXG4gIC8vIERldGVybWluZSBzaWduIG9mIHJlc3VsdC5cclxuICB5LnMgPSB4LnMgPT0geS5zID8gMSA6IC0xO1xyXG5cclxuICAvLyBSZXR1cm4gc2lnbmVkIDAgaWYgZWl0aGVyIDAuXHJcbiAgaWYgKCF4Y1swXSB8fCAheWNbMF0pIHJldHVybiBuZXcgQmlnKHkucyAqIDApO1xyXG5cclxuICAvLyBJbml0aWFsaXNlIGV4cG9uZW50IG9mIHJlc3VsdCBhcyB4LmUgKyB5LmUuXHJcbiAgeS5lID0gaSArIGo7XHJcblxyXG4gIC8vIElmIGFycmF5IHhjIGhhcyBmZXdlciBkaWdpdHMgdGhhbiB5Yywgc3dhcCB4YyBhbmQgeWMsIGFuZCBsZW5ndGhzLlxyXG4gIGlmIChhIDwgYikge1xyXG4gICAgYyA9IHhjO1xyXG4gICAgeGMgPSB5YztcclxuICAgIHljID0gYztcclxuICAgIGogPSBhO1xyXG4gICAgYSA9IGI7XHJcbiAgICBiID0gajtcclxuICB9XHJcblxyXG4gIC8vIEluaXRpYWxpc2UgY29lZmZpY2llbnQgYXJyYXkgb2YgcmVzdWx0IHdpdGggemVyb3MuXHJcbiAgZm9yIChjID0gbmV3IEFycmF5KGogPSBhICsgYik7IGotLTspIGNbal0gPSAwO1xyXG5cclxuICAvLyBNdWx0aXBseS5cclxuXHJcbiAgLy8gaSBpcyBpbml0aWFsbHkgeGMubGVuZ3RoLlxyXG4gIGZvciAoaSA9IGI7IGktLTspIHtcclxuICAgIGIgPSAwO1xyXG5cclxuICAgIC8vIGEgaXMgeWMubGVuZ3RoLlxyXG4gICAgZm9yIChqID0gYSArIGk7IGogPiBpOykge1xyXG5cclxuICAgICAgLy8gQ3VycmVudCBzdW0gb2YgcHJvZHVjdHMgYXQgdGhpcyBkaWdpdCBwb3NpdGlvbiwgcGx1cyBjYXJyeS5cclxuICAgICAgYiA9IGNbal0gKyB5Y1tpXSAqIHhjW2ogLSBpIC0gMV0gKyBiO1xyXG4gICAgICBjW2otLV0gPSBiICUgMTA7XHJcblxyXG4gICAgICAvLyBjYXJyeVxyXG4gICAgICBiID0gYiAvIDEwIHwgMDtcclxuICAgIH1cclxuXHJcbiAgICBjW2pdID0gKGNbal0gKyBiKSAlIDEwO1xyXG4gIH1cclxuXHJcbiAgLy8gSW5jcmVtZW50IHJlc3VsdCBleHBvbmVudCBpZiB0aGVyZSBpcyBhIGZpbmFsIGNhcnJ5LCBvdGhlcndpc2UgcmVtb3ZlIGxlYWRpbmcgemVyby5cclxuICBpZiAoYikgKyt5LmU7XHJcbiAgZWxzZSBjLnNoaWZ0KCk7XHJcblxyXG4gIC8vIFJlbW92ZSB0cmFpbGluZyB6ZXJvcy5cclxuICBmb3IgKGkgPSBjLmxlbmd0aDsgIWNbLS1pXTspIGMucG9wKCk7XHJcbiAgeS5jID0gYztcclxuXHJcbiAgcmV0dXJuIHk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaW4gZXhwb25lbnRpYWwgbm90YXRpb24gdG8gZHAgZml4ZWQgZGVjaW1hbFxyXG4gKiBwbGFjZXMgYW5kIHJvdW5kZWQgdXNpbmcgQmlnLlJNLlxyXG4gKlxyXG4gKiBkcD8ge251bWJlcn0gSW50ZWdlciwgMCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKi9cclxuUC50b0V4cG9uZW50aWFsID0gZnVuY3Rpb24gKGRwKSB7XHJcbiAgcmV0dXJuIHN0cmluZ2lmeSh0aGlzLCAxLCBkcCwgZHApO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIHN0cmluZyByZXByZXNlbnRpbmcgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGluIG5vcm1hbCBub3RhdGlvbiB0byBkcCBmaXhlZCBkZWNpbWFsXHJcbiAqIHBsYWNlcyBhbmQgcm91bmRlZCB1c2luZyBCaWcuUk0uXHJcbiAqXHJcbiAqIGRwPyB7bnVtYmVyfSBJbnRlZ2VyLCAwIHRvIE1BWF9EUCBpbmNsdXNpdmUuXHJcbiAqXHJcbiAqICgtMCkudG9GaXhlZCgwKSBpcyAnMCcsIGJ1dCAoLTAuMSkudG9GaXhlZCgwKSBpcyAnLTAnLlxyXG4gKiAoLTApLnRvRml4ZWQoMSkgaXMgJzAuMCcsIGJ1dCAoLTAuMDEpLnRvRml4ZWQoMSkgaXMgJy0wLjAnLlxyXG4gKi9cclxuUC50b0ZpeGVkID0gZnVuY3Rpb24gKGRwKSB7XHJcbiAgcmV0dXJuIHN0cmluZ2lmeSh0aGlzLCAyLCBkcCwgdGhpcy5lICsgZHApO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIHN0cmluZyByZXByZXNlbnRpbmcgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIHJvdW5kZWQgdG8gc2Qgc2lnbmlmaWNhbnQgZGlnaXRzIHVzaW5nXHJcbiAqIEJpZy5STS4gVXNlIGV4cG9uZW50aWFsIG5vdGF0aW9uIGlmIHNkIGlzIGxlc3MgdGhhbiB0aGUgbnVtYmVyIG9mIGRpZ2l0cyBuZWNlc3NhcnkgdG8gcmVwcmVzZW50XHJcbiAqIHRoZSBpbnRlZ2VyIHBhcnQgb2YgdGhlIHZhbHVlIGluIG5vcm1hbCBub3RhdGlvbi5cclxuICpcclxuICogc2Qge251bWJlcn0gSW50ZWdlciwgMSB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKi9cclxuUC50b1ByZWNpc2lvbiA9IGZ1bmN0aW9uIChzZCkge1xyXG4gIHJldHVybiBzdHJpbmdpZnkodGhpcywgMywgc2QsIHNkIC0gMSk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcuXHJcbiAqIFJldHVybiBleHBvbmVudGlhbCBub3RhdGlvbiBpZiB0aGlzIEJpZyBoYXMgYSBwb3NpdGl2ZSBleHBvbmVudCBlcXVhbCB0byBvciBncmVhdGVyIHRoYW5cclxuICogQmlnLlBFLCBvciBhIG5lZ2F0aXZlIGV4cG9uZW50IGVxdWFsIHRvIG9yIGxlc3MgdGhhbiBCaWcuTkUuXHJcbiAqIE9taXQgdGhlIHNpZ24gZm9yIG5lZ2F0aXZlIHplcm8uXHJcbiAqL1xyXG5QLnRvU3RyaW5nID0gZnVuY3Rpb24gKCkge1xyXG4gIHJldHVybiBzdHJpbmdpZnkodGhpcyk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcuXHJcbiAqIFJldHVybiBleHBvbmVudGlhbCBub3RhdGlvbiBpZiB0aGlzIEJpZyBoYXMgYSBwb3NpdGl2ZSBleHBvbmVudCBlcXVhbCB0byBvciBncmVhdGVyIHRoYW5cclxuICogQmlnLlBFLCBvciBhIG5lZ2F0aXZlIGV4cG9uZW50IGVxdWFsIHRvIG9yIGxlc3MgdGhhbiBCaWcuTkUuXHJcbiAqIEluY2x1ZGUgdGhlIHNpZ24gZm9yIG5lZ2F0aXZlIHplcm8uXHJcbiAqL1xyXG5QLnZhbHVlT2YgPSBQLnRvSlNPTiA9IGZ1bmN0aW9uICgpIHtcclxuICByZXR1cm4gc3RyaW5naWZ5KHRoaXMsIDQpO1xyXG59O1xyXG5cclxuXHJcbi8vIEV4cG9ydFxyXG5cclxuXHJcbmV4cG9ydCB2YXIgQmlnID0gX0JpZ18oKTtcclxuXHJcbmV4cG9ydCBkZWZhdWx0IEJpZztcclxuIiwiaW1wb3J0IEJpZyBmcm9tICdiaWcuanMnO1xuXG4vKipcbiAqIOWKoOazleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g5Yqg5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDliqDmlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u45Yqg57uT5p6cXG4gKi9cbmZ1bmN0aW9uIGFkZCh4LCB5KSB7XG4gICAgcmV0dXJuIG5ldyBCaWcoeCkucGx1cyh5KS50b1N0cmluZygpO1xufVxuXG4vKipcbiAqIOWHj+azleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g6KKr5YeP5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDlh4/mlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u45YeP57uT5p6cXG4gKi9cbmZ1bmN0aW9uIHN1YnRyYWN0KHgsIHkpIHtcbiAgICByZXR1cm4gbmV3IEJpZyh4KS5taW51cyh5KS50b1N0cmluZygpO1xufVxuXG4vKipcbiAqIOS5mOazleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g5LmY5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDkuZjmlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u45LmY57uT5p6cXG4gKi9cbmZ1bmN0aW9uIG11bHRpcGx5KHgsIHkpIHtcbiAgICByZXR1cm4gbmV3IEJpZyh4KS50aW1lcyh5KS50b1N0cmluZygpO1xufVxuXG4vKipcbiAqIOmZpOazleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g6KKr6Zmk5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDpmaTmlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u46Zmk57uT5p6cXG4gKi9cbmZ1bmN0aW9uIGRpdmlkZSh4LCB5KSB7XG4gICAgcmV0dXJuIG5ldyBCaWcoeCkuZGl2KHkpLnRvU3RyaW5nKCk7XG59XG5cbi8qKlxuICog5qC85byP5YyW5pWw5a2XXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHZhbHVlIC0g5b6F5qC85byP5YyW55qE5pWw5a2XXG4gKiBAcGFyYW0ge251bWJlcn0gW3ByZWNpc2lvbl0gLSDnsr7luqbvvIzljbPlsI/mlbDkvY3mlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g5qC85byP5YyW5ZCO55qE5a2X56ym5LiyXG4gKi9cbmZ1bmN0aW9uIGZvcm1hdCh2YWx1ZSwgcHJlY2lzaW9uKSB7XG4gICAgY29uc3QgYmlnVmFsdWUgPSBuZXcgQmlnKHZhbHVlKTtcbiAgICBsZXQgc3RyaW5nVmFsdWUgPSBiaWdWYWx1ZS50b1N0cmluZygpO1xuICAgIHN0cmluZ1ZhbHVlID0gc2NpZW50aWZpY1RvTnVtYmVyKHN0cmluZ1ZhbHVlKTsgXG4gICAgLy/lhpnov5nkuYjpurvng6bvvIzmmK/lm6DkuLpCaWcucm91bmTnm7jlhbPmlrnms5XkuI3lpb3kvb/vvIzlvpfkuI3liLDpooTmnJ/nu5PmnpzjgIJcbiAgICBpZiAoc3RyaW5nVmFsdWUuaW5jbHVkZXMoJy4nKSkge1xuICAgICAgICBsZXQgc3RyQXJyYXkgPSBzdHJpbmdWYWx1ZS5zcGxpdCgnLicpO1xuICAgICAgICBpZiAoc3RyQXJyYXlbMV0ubGVuZ3RoID49IHByZWNpc2lvbikge1xuICAgICAgICAgICAgaWYgKDAgPT0gcHJlY2lzaW9uKSB7XG4gICAgICAgICAgICAgICAgcmV0dXJuIHN0ckFycmF5WzBdO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICAgICAgLy/miKrmlq1cbiAgICAgICAgICAgICAgICBsZXQgdHJ1bmNhdGUgPSBzdHJBcnJheVsxXS5zdWJzdHJpbmcoMCwgcHJlY2lzaW9uKTtcbiAgICAgICAgICAgICAgICByZXR1cm4gYCR7c3RyQXJyYXlbMF19LiR7dHJ1bmNhdGV9YDtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgICAgICBlbHNlIHtcbiAgICAgICAgICAgIC8v6KGl6Zu2XG4gICAgICAgICAgICBsZXQgemVyb051bWJlciA9IHByZWNpc2lvbiAtIHN0ckFycmF5WzFdLmxlbmd0aDtcbiAgICAgICAgICAgIHZhciBzdHIgPSAnJztcbiAgICAgICAgICAgIGZvciAobGV0IGkgPSAwOyBpIDwgemVyb051bWJlcjsgaSsrKSB7XG4gICAgICAgICAgICAgICAgc3RyICs9ICcwJztcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIHJldHVybiBgJHtzdHJpbmdWYWx1ZX0ke3N0cn1gO1xuICAgICAgICB9XG4gICAgfVxuICAgIGVsc2Uge1xuICAgICAgICBpZiAoMCA9PSBwcmVjaXNpb24pIHtcbiAgICAgICAgICAgIHJldHVybiBzdHJpbmdWYWx1ZTtcbiAgICAgICAgfVxuICAgICAgICBlbHNlIHtcbiAgICAgICAgICAgIGxldCB6ZXJvTnVtYmVyID0gcHJlY2lzaW9uO1xuICAgICAgICAgICAgdmFyIHN0ciA9ICcnO1xuICAgICAgICAgICAgZm9yIChsZXQgaSA9IDA7IGkgPCB6ZXJvTnVtYmVyOyBpKyspIHtcbiAgICAgICAgICAgICAgICBzdHIgKz0gJzAnO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgcmV0dXJuIGAke3N0cmluZ1ZhbHVlfS4ke3N0cn1gO1xuICAgICAgICB9XG4gICAgfVxufVxuXG4vKipcbiAqIOWvueaVsOe7hOS4reeahOavj+S4quWFg+e0oOi/m+ihjOeyvuehrui/kOeul+W5tui/lOWbnuS4gOS4quaWsOaVsOe7hFxuICogQHBhcmFtIHtBcnJheTxudW1iZXJ8c3RyaW5nPn0gYXJyIC0g5b6F6L+Q566X5pWw57uEXG4gKiBAcmV0dXJucyB7QXJyYXk8c3RyaW5nPn0gLSDov5Tlm57ov5Dnrpfnu5PmnpzmlbDnu4RcbiAqL1xuZnVuY3Rpb24gYmlnbnVtYmVyKGFycikge1xuICAgIGlmIChBcnJheS5pc0FycmF5KGFycikpIHtcbiAgICAgICAgcmV0dXJuIGFyci5tYXAoKHZhbHVlKSA9PiBCaWcodmFsdWUpLnRvRml4ZWQoKSk7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgcmV0dXJuIEJpZyhhcnIpLnRvRml4ZWQoKTtcbiAgICB9XG59XG5cbi8qKlxuICogSmF2YXNjcmlwdCDlnKjku6XkuIvmg4Xmma/kuIvkvJroh6rliqjlsIbmlbDlgLzovazmjaLkuLrnp5HlraborqHmlbDms5XvvJpcbiAqIDHjgIHlvZPmlbTmlbDnmoTkvY3mlbDotoXov4cyMuS9jeaXtu+8jGpz5Lya6Ieq5Yqo5bCG5pW05pWw5pWw5YC86L2s5YyW5Li656eR5a2m6K6w5pWw5rOV44CCXG4gICAgICBqc+S4reeahOenkeWtpuiusOaVsOazle+8mjEwMDAwMDAwMDAwMDAwMDAwMDAw77yIMjHkuKow77yJ5ZyoanPkuK3nmoTnp5HlraborrDmlbDms5XooajnpLrkuLrvvJoxZSsyMTsgICAgIFxuICogMuOAgeWwj+aVsOeCueWJjei+ueaYrzDvvIzlsI/mlbDngrnlkI7ljYHliIbkvY3vvIjljIXlkKvljYHliIbkvY3vvInkuYvlkI7nmoQw55qE5Liq5pWw6LaF6L+HNuS4quaVsOWAvOWwseS8muiHquWKqOi9rOWMluS4uuenkeWtpuiuoeaVsOazle+8m1xuICAgICAgIDAuMDAwMDAwNCDkvJrovazmjaLkuLrvvJogNGUtNywgIOiAjDAuMTAwMDAwMDQg5YiZ5LiN5Lya6KKr6L2s5o2i77yMMS4wMDAwMDAwMDTkuZ/kuI3kvJrooqvovazmjaJcbiAqIOS4uuS6humBv+WFjei/meenjeiHquWKqOi9rOaNou+8jOe8luWGmeS4gOS4quWHveaVsOWIqeeUqOato+WImeadpeWwhuenkeWtpuiuoeaVsOazleeahOaVsOWAvOi9rOaNouS4uuaVsOWAvOaYvuekuu+8mlxuICovXG5mdW5jdGlvbiBzY2llbnRpZmljVG9OdW1iZXIobnVtKSB7XG4gICAgaWYgKC9cXGQrXFwuP1xcZCplW1xcK1xcLV0qXFxkKy9pLnRlc3QobnVtKSkge1xuICAgICAgICBsZXQgemVybyA9ICcwJztcbiAgICAgICAgbGV0IHBhcnRzID0gU3RyaW5nKG51bSkudG9Mb3dlckNhc2UoKS5zcGxpdCgnZScpO1xuICAgICAgICBsZXQgZSA9IHBhcnRzWzFdO1xuICAgICAgICBsZXQgemVyb0xlbiA9IE1hdGguYWJzKGUpO1xuICAgICAgICBsZXQgc2lnbiA9IGUgLyB6ZXJvTGVuO1xuICAgICAgICBsZXQgYmVmb3JlQXJyID0gcGFydHNbMF0uc3BsaXQoJy4nKTtcbiAgICAgICAgaWYgKHNpZ24gPCAwKSB7XG4gICAgICAgICAgICBudW0gPSB6ZXJvICsgJy4nICsgbmV3IEFycmF5KHplcm9MZW4pLmpvaW4oemVybykgKyBiZWZvcmVBcnIuam9pbignJyk7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBsZXQgZGVjID0gYmVmb3JlQXJyWzFdO1xuICAgICAgICAgICAgaWYgKGRlYykge1xuICAgICAgICAgICAgICAgIHplcm9MZW4gPSB6ZXJvTGVuIC0gZGVjLmxlbmd0aDtcbiAgICAgICAgICAgICAgICBudW0gPSBiZWZvcmVBcnIuam9pbignJykgKyBuZXcgQXJyYXkoemVyb0xlbiArIDEpLmpvaW4oemVybyk7XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICB9XG4gICAgcmV0dXJuIG51bTtcbn1cblxuXG5leHBvcnQgeyBhZGQsIHN1YnRyYWN0LCBtdWx0aXBseSwgZGl2aWRlLCBmb3JtYXQsIGJpZ251bWJlciwgc2NpZW50aWZpY1RvTnVtYmVyIH07XG4iLCJpbXBvcnQgKiBhcyBudW1iZXIgZnJvbSBcIi4vbnVtYmVyXCI7XG5cbnZhciBjbGlja2FibGUgPSB0cnVlO1xuXG4vL3N5bWJvbCx1c2R0LOm7mOiupHN5bWJvbFxuZXhwb3J0IGNvbnN0IFVuaXRUeXBlID0ge1xuICAgIHVuaXRUeXBlU3ltYm9sOiAnc3ltYm9sJyxcbiAgICB1bml0VHlwZVVTRFQ6ICd1c2R0Jyxcbn07XG5cbi8v5b2T5YmNdGFi57G75Z6LICDlvZPliY3mjIHku5Mg5b2T5YmN5aeU5omYICDlvZPliY3luKbljZUg5Y6G5Y+y5bim5Y2VXG5leHBvcnQgY29uc3QgVGFiVHlwZSA9IHtcbiAgICB0YWJUeXBlUG9zaXRpb246ICdwb3NpdGlvbicsXG4gICAgdGFiVHlwZU9wZW5PcmRlcnM6ICdvcGVuT3JkZXJzJyxcbiAgICB0YWJUeXBlT3JkZXJzOiAnb3JkZXJzJyxcbiAgICB0YWJUeXBlSGlzdG9yeTogJ2hpc3RvcnknLFxufTtcblxuLy8g6aKc6Imy6YWN572uIDA657qi5rao57u/6LeMIOaIliAxOue7v+a2qOe6oui3jFxudmFyIHVwQ29sb3JMaXN0O1xudmFyIGRvd25Db2xvckxpc3Q7XG5cbmNvbnN0IERFRkFVTFRfU1RSID0gJzAuMDAnO1xuXG4vKipcbiAqIEB0eXBlZGVmIHtPYmplY3R9IENvbW1vbkRhdGFcbiAqIEBwcm9wZXJ0eSB7bnVtYmVyfSBwcmljZUNvbG9yVHlwZSAgICAtIOS7t+agvOa2qOi3jOW5heminOiJsuiuvue9rlxuICogQHByb3BlcnR5IHtudW1iZXJ9IGNvbG9yTW9kZSAgICAgICAgIC0g55m95aSp6buR5aSc5qih5byPXG4gKiBAcHJvcGVydHkge3N0cmluZ30gbGFuZ3VhZ2UgICAgICAgICAgLSDor63np43phY3nva5cbiAqIEBwcm9wZXJ0eSB7c3RyaW5nfSBPUyAgICAgICAgICAgICAgICAtIOezu+e7n1xuICogQHByb3BlcnR5IHtzdHJpbmd9IGFwcFZlcnNpb24gICAgICAgIC0g54mI5pys5Y+3XG4gKiBAcHJvcGVydHkge251bWJlcn0gaXNJblJldmlldyAgICAgICAgLSBpT1PlrqHmoLjnirbmgIFcbiAqIEBwcm9wZXJ0eSB7bnVtYmVyfSBpc0xvZ2luICAgICAgICAgICAtIOaYr+WQpueZu+W9lVxuICogQHByb3BlcnR5IHtvYmplY3R9IGxpbmVhclN3YXBXc0RhdGEgIC0gVeacrOS9jeWQiOe6puiuoumYheS/oeaBr1xuICovXG5cbi8qKiBAdHlwZSBDb21tb25EYXRhICovXG5leHBvcnQgdmFyIGNvbW1vbkRhdGEgPSB7XG4gICAgdXNlclNpZ246IFwiXCIsIC8vLyDnlKjmiLfmoIfor4ZcbiAgICBjdXJyZW50U3ltYm9sOiBcIkJUQy1VU0RUXCIsIC8vL+W9k+WJjeeahOWQiOe6puWTgeenjVxuICAgIGN1cnJlbnRDb250cmFjdEluZm86IHt9LCAvLy/lvZPliY3nmoTlkIjnuqblk4Hnp43mlbDmja5cbiAgICBjb250cmFjdEluZm9EYXRhOiBbXSwgLy8vbGluZWFyLXN3YXAtb3JkZXIveC92MS9saW5lYXJfc3dhcF9jb250cmFjdF9pbmZvP2J1c2luZXNzX3R5cGU9YWxsJnRyYWRlX3BhcnRpdGlvbj1hbGzjgIDmjqXlj6Pov5Tlm57nmoTmiYDmnInlkIjnuqblk4Hnp43mlbDmja5cbiAgICBjb250cmFjdEg1VXJsOiBcIlwiLCAvLy/lkIjnuqZINeWcsOWdgFxuICAgIGN1cnJlbmN5UmF0ZTogXCI2LjRcIiwgLy8v576O5YWD5a+55YW25a6D5rOV5biB55qE5rGH546HXG4gICAgY3VycmVuY3lDaGFyYWN0ZXI6IFwiQ05ZXCIsIC8vL+azleW4geespuWPt1xuICAgIHByaWNlQ29sb3JUeXBlOiAwLCAvLy8w77ya57qi5rao57u/6LeMICAgMe+8mue7v+a2qOe6oui3jFxuICAgIGNvbG9yTW9kZTogMCwgLy8vMO+8mueZveWkqSAgIDHvvJrpu5HlpJxcbiAgICBPUzogMCwgLy8w77yaaU9TICAx77ya5a6J5Y2TXG4gICAgYXBwVmVyc2lvbjogXCJcIiwgLy9hcHDniYjmnKzlj7dcbiAgICBpc0luUmV2aWV3OiAxLFxuICAgIGlzTG9naW46IDAsXG4gICAgd2ViVXJsOiBcIlwiLCAvLy8gaDXliqjmgIHln5/lkI1cbiAgICBsYW5ndWFnZTogXCJcIiwgLy8vIOivreiogOenjeexu1xuICAgIGxpbmVhclN3YXBXc0RhdGE6IHt9LFxuICAgIHVuaXRUeXBlOiBVbml0VHlwZS51bml0VHlwZVN5bWJvbCxcbiAgICBsYXN0VW5pdFR5cGU6IFVuaXRUeXBlLnVuaXRUeXBlU3ltYm9sLFxuICAgIG9wZW5TaW5nbGVNYXJnaW46IHRydWUsXG4gICAgY3VyVGFiVHlwZTogVGFiVHlwZS50YWJUeXBlUG9zaXRpb24sXG4gICAgaXNDaGlsZDogZmFsc2Vcbn07XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzdWJQcmljZVdlYlNvY2tldCh0eXBlID0gXCJsaW5lYXJTd2FwV3NcIikge1xuICAgIGF3YWl0ICRuYXRpdmVBUEkuY29weVRyYWRpbmdCcmlkZ2Uoe1xuICAgICAgICBhY3Rpb246IFwic3ViUHJpY2VXZWJTb2NrZXRcIixcbiAgICAgICAgdHlwZTogdHlwZSxcbiAgICB9KTtcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHVuc3ViUHJpY2VXZWJTb2NrZXQodHlwZSA9IFwibGluZWFyU3dhcFdzXCIpIHtcbiAgICBhd2FpdCAkbmF0aXZlQVBJLmNvcHlUcmFkaW5nQnJpZGdlKHtcbiAgICAgICAgYWN0aW9uOiBcInVuc3ViUHJpY2VXZWJTb2NrZXRcIixcbiAgICAgICAgdHlwZTogdHlwZSxcbiAgICB9KTtcbn1cblxuLyoq5ZCI57qm5L+h5oGv6I635Y+W55u45YWz5pa55rOVICovXG5cbi8qKlxuICog5qC55o2uY29udHJhY3RTaG9ydFR5cGXmib7liLDnm7jlupTnmoTlkIjnuqZtb2RlbFxuICogQHBhcmFtIHtTdHJpbmd9IGNvbnRyYWN0U2hvcnRUeXBlXG4gKiBAcmV0dXJucyDlr7nlupTnmoRtb2RlbFxuICovXG5leHBvcnQgZnVuY3Rpb24gZ2V0TW9kZWxCeUNvbnRyYWN0U2hvcnRUeXBlKGNvbnRyYWN0U2hvcnRUeXBlKSB7XG4gICAgZm9yIChsZXQgaSA9IDA7IGkgPCBjb21tb25EYXRhLmNvbnRyYWN0SW5mb0RhdGEubGVuZ3RoOyBpKyspIHtcbiAgICAgICAgaWYgKFxuICAgICAgICAgICAgY29tbW9uRGF0YS5jb250cmFjdEluZm9EYXRhW2ldLmNvbnRyYWN0X3Nob3J0X3R5cGUgPT0gY29udHJhY3RTaG9ydFR5cGVcbiAgICAgICAgKSB7XG4gICAgICAgICAgICByZXR1cm4gY29tbW9uRGF0YS5jb250cmFjdEluZm9EYXRhW2ldO1xuICAgICAgICB9XG4gICAgfVxuXG4gICAgcmV0dXJuIG51bGw7XG59XG5cbi8qKlxuICog5qC55o2uY29udHJhY3RDb2Rl5om+5Yiw55u45bqU55qE5ZCI57qmbW9kZWxcbiAqIEBwYXJhbSB7U3RyaW5nfSBjb250cmFjdENvZGVcbiAqIEByZXR1cm5zIOWvueW6lOeahG1vZGVsXG4gKi9cbmV4cG9ydCBmdW5jdGlvbiBnZXRNb2RlbEJ5Q29udHJhY3RDb2RlKGNvbnRyYWN0Q29kZSkge1xuICAgIGZvciAobGV0IGkgPSAwOyBpIDwgY29tbW9uRGF0YS5jb250cmFjdEluZm9EYXRhLmxlbmd0aDsgaSsrKSB7XG4gICAgICAgIGlmIChjb21tb25EYXRhLmNvbnRyYWN0SW5mb0RhdGFbaV0uY29udHJhY3RfY29kZSA9PSBjb250cmFjdENvZGUpIHtcbiAgICAgICAgICAgIHJldHVybiBjb21tb25EYXRhLmNvbnRyYWN0SW5mb0RhdGFbaV07XG4gICAgICAgIH1cbiAgICB9XG5cbiAgICByZXR1cm4gbnVsbDtcbn1cblxuLyoqXG4gKiDojrflj5blkIjnuqbpnaLlgLzvvIzlj6/nlKjkuo7mnIDlsI/kuIvljZXph4/nmoTmoKHpqoxcbiAqIEBwYXJhbSB75a+56LGhfSBjb250cmFjdEluZm8g5ZCI57qmbW9kZWxcbiAqIEByZXR1cm5zIFN0cmluZ++8jOS4gOW8oOWvueW6lOeahOW4gemHj1xuICovXG5leHBvcnQgZnVuY3Rpb24gZ2V0Q29udHJhY3RTaXplKGNvbnRyYWN0SW5mbykge1xuICAgIGlmIChjb250cmFjdEluZm8pIHtcbiAgICAgICAgcmV0dXJuIGNvbnRyYWN0SW5mby5jb250cmFjdF9zaXplLnRvU3RyaW5nKCk7XG4gICAgfVxuXG4gICAgcmV0dXJuIFwiXCI7XG59XG5cbi8qKlxuICog6I635Y+W5ZCI57qm5ZOB56eN55qE5pWw6YeP57K+5bqm77ya55So5LqO6LSm5oi35p2D55uK44CB5bey5a6e546w55uI5LqP44CB5pyq5a6e546w55uI5LqP44CB5Y+v55So5ouF5L+d6LWE5Lqn44CB5oyB5LuT5ouF5L+d6LWE5Lqn44CB5Ya757uT5ouF5L+d6LWE5Lqn44CB5Lmw5Y2W55uY5Y+j5pWw6YeP44CB5Lmw5Y2W55uY5Y+j57Sv6K6h44CB5Y+v5byA6YeP44CB5LiL5Y2V6YeP44CB5oyB5LuT6YeP44CB5Y+v5bmz6YeP44CB5rex5bqm5Zu+57Sv6K6h44CB6Z2Z5oCB5p2D55uK44CB5pS255uK44CB6aOO6Zmp5YeG5aSH6YeR57K+5bqmXG4gKiBAcGFyYW0ge+WvueixoX0gY29udHJhY3RJbmZvIOWQiOe6pm1vZGVsXG4gKiBAcmV0dXJucyDmlbDph4/nsr7luqZcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIGdldE90aGVyQW1vdW50UHJlY2lzaW9uKGNvbnRyYWN0SW5mbykge1xuICAgIGlmIChjb250cmFjdEluZm8pIHtcbiAgICAgICAgcmV0dXJuIHBhcnNlSW50KGNvbnRyYWN0SW5mby5vdGhlcl9hbW91bnRfcHJlY2lzaW9uKTtcbiAgICB9XG5cbiAgICByZXR1cm4gNDtcbn1cblxuLyoqXG4gKiDojrflj5blkIjnuqblk4Hnp43nmoTku7fmoLznsr7luqYg5oyB5LuT5Z2H5Lu3IOW8gOS7k+S7t+agvCDmraLnm4jmraLmjZ/ku7fmoLwg6aKE5Lyw54iG5LuT5Lu35qC8XG4gKiBAcGFyYW0ge+WvueixoX0gY29udHJhY3RJbmZvIOWQiOe6pm1vZGVsXG4gKiBAcmV0dXJucyDku7fmoLznsr7luqZcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIGdldFByaWNlVGlja1ByZWNpc2lvbihjb250cmFjdEluZm8pIHtcbiAgICBpZiAobnVsbCA9PSBjb250cmFjdEluZm8pIHtcbiAgICAgICAgcmV0dXJuIDQ7XG4gICAgfVxuXG4gICAgdmFyIHNpemVTdHJpbmcgPSBudW1iZXIuYmlnbnVtYmVyKGNvbnRyYWN0SW5mby5wcmljZV90aWNrKTtcbiAgICByZXR1cm4gc2l6ZVN0cmluZy5zcGxpdChcIi5cIilbMV0ubGVuZ3RoO1xufVxuXG4vKipcbiAqIOiOt+WPluWQiOe6puWTgeenjeeahOmdouWAvOeyvuW6piDlvIDku5Pph49cbiAqIEBwYXJhbSB75a+56LGhfSBjb250cmFjdEluZm8g5ZCI57qmbW9kZWxcbiAqIEByZXR1cm5zIOmdouWAvOeyvuW6plxuICovXG5leHBvcnQgZnVuY3Rpb24gZ2V0Q29udHJhY3RTaXplUHJlY2lzaW9uKGNvbnRyYWN0SW5mbykge1xuICAgIGlmIChudWxsID09IGNvbnRyYWN0SW5mbykge1xuICAgICAgICByZXR1cm4gMDtcbiAgICB9XG5cbiAgICBpZiAocGFyc2VGbG9hdChjb250cmFjdEluZm8uY29udHJhY3Rfc2l6ZSkgPj0gMS4wKSB7XG4gICAgICAgIHJldHVybiAwO1xuICAgIH1cblxuICAgIHZhciBzaXplU3RyaW5nID0gY29udHJhY3RJbmZvLmNvbnRyYWN0X3NpemUudG9TdHJpbmcoKTtcbiAgICByZXR1cm4gc2l6ZVN0cmluZy5zcGxpdChcIi5cIilbMV0ubGVuZ3RoO1xufVxuXG4vKipcbiAqIOiOt+WPluWQiOe6puWTgeenjeeahOaJi+e7rei0ueeyvuW6plxuICogQHBhcmFtIHvlr7nosaF9IGNvbnRyYWN0SW5mbyDlkIjnuqZtb2RlbFxuICogQHJldHVybnMg5omL57ut6LS557K+5bqmXG4gKi9cbmV4cG9ydCBmdW5jdGlvbiBnZXRGZWVBbW91bnRQcmVjaXNpb24oY29udHJhY3RJbmZvKSB7XG4gICAgaWYgKGNvbnRyYWN0SW5mbykge1xuICAgICAgICByZXR1cm4gcGFyc2VJbnQoY29udHJhY3RJbmZvLmZlZV9hbW91bnRfcHJlY2lzaW9uKTtcbiAgICB9XG4gICAgcmV0dXJuIDY7XG59XG5cbi8qKlxuICog6I635Y+W5ZCI57qm5ZOB56eN55qE5YW25LuW57G75Z6L57K+5bqmIOaAu+aUtuebiiDku4rml6XmlLbnm4og5Y6G5Y+y5pS255uKXG4gKiBAcGFyYW0ge+WvueixoX0gY29udHJhY3RJbmZvIOWQiOe6pm1vZGVsXG4gKiBAcmV0dXJucyDlhbbku5bnsbvlnovnsr7luqZcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIGdldE90aGVyUHJlY2lzaW9uKGNvbnRyYWN0SW5mbykge1xuICAgIGlmIChjb250cmFjdEluZm8pIHtcbiAgICAgICAgcmV0dXJuIHBhcnNlSW50KGNvbnRyYWN0SW5mby5vdGhlcl9hbW91bnRfcHJlY2lzaW9uKTtcbiAgICB9XG4gICAgcmV0dXJuIDQ7XG59XG5cbi8v5Y+R6YCB6K+35rGCXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc2VuZFJlcXVlc3QocGF0aCwgcGFyYW1zID0ge30sIG1ldGhvZCA9IDAsIGhvc3RUeXBlID0gMCwgaGVhZGVyID0ge30sIHJldHVyblN0YXR1cyA9IDApIHtcbiAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCAke3BhdGh9LCBwYXJhbXM6JHtKU09OLnN0cmluZ2lmeShwYXJhbXMpfWApO1xuXG4gICAgaWYgKGhvc3RUeXBlID09IDUgfHwgaG9zdFR5cGUgPT0gNikge1xuICAgICAgICBoZWFkZXJbXCJDb250ZW50LVR5cGVcIl0gPSBcImFwcGxpY2F0aW9uL2pzb25cIjtcbiAgICB9XG5cbiAgICBjb25zdCBwYXJhbSA9IHtcbiAgICAgICAgcGF0aCxcbiAgICAgICAgbWV0aG9kLFxuICAgICAgICBob3N0VHlwZSxcbiAgICAgICAgaGVhZGVyLFxuICAgICAgICBwYXJhbXMsXG4gICAgfTtcbiAgICB0cnkge1xuICAgICAgICB2YXIgcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QoSlNPTi5zdHJpbmdpZnkocGFyYW0pKTtcbiAgICAgICAgdmFyIHJlc3BvbnNlID0gSlNPTi5wYXJzZShyZXNwb25zZVN0cmluZyk7XG4gICAgICAgIHZhciB7IGNvZGUsIGRhdGEgfSA9IHJlc3BvbnNlO1xuICAgICAgICBpZiAoOCA9PSBob3N0VHlwZSkge1xuICAgICAgICAgICAgLy/lkIjnuqbnmoTmjqXlj6PlpITnkIZcbiAgICAgICAgICAgIHZhciBzdGF0dXMgPSByZXNwb25zZS5zdGF0dXM7XG4gICAgICAgICAgICB2YXIgZXJyX2NvZGUgPSByZXNwb25zZVtcImVyci1jb2RlXCJdO1xuICAgICAgICAgICAgdmFyIGVycl9tc2cgPSByZXNwb25zZVtcImVyci1tc2dcIl07XG4gICAgICAgICAgICBpZiAoc3RhdHVzID09IFwib2tcIikge1xuICAgICAgICAgICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0ICR7cGF0aH0gZG9uZWApO1xuICAgICAgICAgICAgICAgIGlmICh0eXBlb2YgZGF0YSA9PT0gJ251bWJlcicpIHtcbiAgICAgICAgICAgICAgICAgICAgbGV0IHN0YXJ0ID0gYFwiZGF0YVwiOmA7XG4gICAgICAgICAgICAgICAgICAgIGxldCBzdGFydEluZGV4ID0gcmVzcG9uc2VTdHJpbmcuaW5kZXhPZihzdGFydCk7XG4gICAgICAgICAgICAgICAgICAgIGxldCBlbmQgPSBgLFwidHNcIjpgO1xuICAgICAgICAgICAgICAgICAgICBsZXQgZW5kSW5kZXggPSByZXNwb25zZVN0cmluZy5pbmRleE9mKGVuZCk7XG4gICAgICAgICAgICAgICAgICAgIGxldCBkYXRhU3RyaW5nID0gcmVzcG9uc2VTdHJpbmcuc3Vic3RyaW5nKHN0YXJ0SW5kZXggKyBzdGFydC5sZW5ndGgsIGVuZEluZGV4KTtcbiAgICAgICAgICAgICAgICAgICAgY29uc29sZS5sb2coYGRhdGEgaXMgdHlwZW9mIG51bWJlciwgZGF0YVN0cmluZyA9ICR7ZGF0YVN0cmluZ31gKTtcbiAgICAgICAgICAgICAgICAgICAgcmV0dXJuIGRhdGFTdHJpbmc7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIHJldHVybiBkYXRhO1xuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCBmYWlsZWQsIGNvZGU9JHtlcnJfY29kZX0sIG1lc3NhZ2U9JHtlcnJfbXNnfWApO1xuICAgICAgICAgICAgICAgIGlmIChtZXRob2QgIT0gMCkge1xuICAgICAgICAgICAgICAgICAgICBzaG93VG9hc3QoZXJyX21zZyk7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIHJldHVybiBudWxsO1xuICAgICAgICAgICAgfVxuICAgICAgICB9IGVsc2UgaWYgKGNvZGUgPT0gMjAwKSB7XG4gICAgICAgICAgICBpZiAoZGF0YSA9PSBudWxsKSB7XG4gICAgICAgICAgICAgICAgcmV0dXJuIHJlc3BvbnNlO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgJHtwYXRofSBkb25lYCk7XG4gICAgICAgICAgICByZXR1cm4gZGF0YTtcbiAgICAgICAgfSBlbHNlIGlmICgoY29kZSA9PSBudWxsIHx8IGNvZGUgPT0gXCJcIiB8fCBjb2RlID09IFwidW5kZWZpbmVkXCIpICYmIHJlc3BvbnNlLnN0YXR1cyA9PSBcIm9rXCIpIHtcbiAgICAgICAgICAgIGlmIChkYXRhID09IG51bGwpIHtcbiAgICAgICAgICAgICAgICByZXR1cm4gcmVzcG9uc2U7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCAke3BhdGh9IGRvbmVgKTtcbiAgICAgICAgICAgIHJldHVybiBkYXRhO1xuICAgICAgICB9IGVsc2UgaWYgKHJldHVyblN0YXR1cyA9PSAxKSB7XG4gICAgICAgICAgICAvL3Byb+eahOaOpeWPo+WkhOeQhlxuICAgICAgICAgICAgdmFyIHN0YXR1cyA9IHJlc3BvbnNlLnN0YXR1cztcbiAgICAgICAgICAgIHZhciBlcnJfY29kZSA9IHJlc3BvbnNlW1wiZXJyLWNvZGVcIl07XG4gICAgICAgICAgICB2YXIgZXJyX21zZyA9IHJlc3BvbnNlW1wiZXJyLW1zZ1wiXTtcbiAgICAgICAgICAgIGlmIChzdGF0dXMgPT0gXCJva1wiKSB7XG4gICAgICAgICAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgJHtwYXRofSBkb25lYCk7XG4gICAgICAgICAgICAgICAgcmV0dXJuIGRhdGE7XG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0IGZhaWxlZCwgY29kZT0ke2Vycl9jb2RlfSwgbWVzc2FnZT0ke2Vycl9tc2d9YCk7XG4gICAgICAgICAgICAgICAgaWYgKG1ldGhvZCAhPSAwKSB7XG4gICAgICAgICAgICAgICAgICAgIHNob3dUb2FzdChlcnJfbXNnKTtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgcmV0dXJuIG51bGw7XG4gICAgICAgICAgICB9XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCBmYWlsZWQsIGNvZGU9JHtjb2RlfWApO1xuICAgICAgICAgICAgbGV0IG1lc3NhZ2UgPSByZXNwb25zZS5tZXNzYWdlO1xuICAgICAgICAgICAgaWYgKG1ldGhvZCAhPSAwICYmIG1lc3NhZ2UpIHtcbiAgICAgICAgICAgICAgICBzaG93VG9hc3QobWVzc2FnZSk7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICByZXR1cm4gbnVsbDtcbiAgICAgICAgfVxuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgZXJyb3IsIGVycm9yPSR7ZX1gKTtcbiAgICAgICAgcmV0dXJuIG51bGw7XG4gICAgfVxufVxuXG4vL+WPkemAgeivt+axglxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNlbmRSZXF1ZXN0UmV0dXJuQ29kZShwYXRoLCBwYXJhbXMgPSB7fSwgbWV0aG9kID0gMCwgaG9zdFR5cGUgPSAwLCBoZWFkZXIgPSB7fSkge1xuICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0ICR7cGF0aH0sIHBhcmFtczoke0pTT04uc3RyaW5naWZ5KHBhcmFtcyl9YCk7XG5cbiAgICBpZiAoaG9zdFR5cGUgPT0gNSB8fCBob3N0VHlwZSA9PSA2KSB7XG4gICAgICAgIGhlYWRlcltcIkNvbnRlbnQtVHlwZVwiXSA9IFwiYXBwbGljYXRpb24vanNvblwiO1xuICAgIH1cblxuICAgIGNvbnN0IHBhcmFtID0ge1xuICAgICAgICBwYXRoLFxuICAgICAgICBtZXRob2QsXG4gICAgICAgIGhvc3RUeXBlLFxuICAgICAgICBoZWFkZXIsXG4gICAgICAgIHBhcmFtcyxcbiAgICB9O1xuICAgIHRyeSB7XG4gICAgICAgIHZhciByZXNwb25zZVN0cmluZyA9IGF3YWl0ICRuYXRpdmVBUEkucmVxdWVzdChKU09OLnN0cmluZ2lmeShwYXJhbSkpO1xuICAgICAgICB2YXIgcmVzcG9uc2UgPSBKU09OLnBhcnNlKHJlc3BvbnNlU3RyaW5nKTtcbiAgICAgICAgdmFyIHsgY29kZSwgZGF0YSB9ID0gcmVzcG9uc2U7XG4gICAgICAgIGlmICg4ID09IGhvc3RUeXBlKSB7XG4gICAgICAgICAgICAvL+WQiOe6pueahOaOpeWPo+WkhOeQhlxuICAgICAgICAgICAgdmFyIHN0YXR1cyA9IHJlc3BvbnNlLnN0YXR1cztcbiAgICAgICAgICAgIHZhciBlcnJfY29kZSA9IHJlc3BvbnNlLmVycl9jb2RlO1xuICAgICAgICAgICAgdmFyIGVycl9tc2cgPSByZXNwb25zZS5lcnJfbXNnO1xuICAgICAgICAgICAgaWYgKHN0YXR1cyA9PSBcIm9rXCIpIHtcbiAgICAgICAgICAgICAgICByZXR1cm4gY29kZTtcbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgZmFpbGVkLCBjb2RlPSR7ZXJyX2NvZGV9LCBtZXNzYWdlPSR7ZXJyX21zZ31gKTtcbiAgICAgICAgICAgICAgICBpZiAobWV0aG9kICE9IDApIHtcbiAgICAgICAgICAgICAgICAgICAgc2hvd1RvYXN0KGVycl9tc2cpO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICByZXR1cm4gY29kZTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfSBlbHNlIGlmIChjb2RlID09IDIwMCkge1xuICAgICAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgJHtwYXRofSBkb25lYCk7XG4gICAgICAgICAgICByZXR1cm4gY29kZTtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0IGZhaWxlZCwgY29kZT0ke2NvZGV9YCk7XG4gICAgICAgICAgICBsZXQgbWVzc2FnZSA9IHJlc3BvbnNlW1wiZXJyLW1zZ1wiXTtcbiAgICAgICAgICAgIGlmIChtZXRob2QgIT0gMCAmJiBtZXNzYWdlKSB7XG4gICAgICAgICAgICAgICAgc2hvd1RvYXN0KG1lc3NhZ2UpO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgcmV0dXJuIGNvZGU7XG4gICAgICAgIH1cbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0IGVycm9yLCBlcnJvcj0ke2V9YCk7XG4gICAgICAgIHJldHVybiAwO1xuICAgIH1cbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNlbmRSZXF1ZXN0V2l0aENhY2hlKFxuICAgIHBhdGgsXG4gICAgY2FsbGJhY2ssXG4gICAgcGFyYW1zID0ge30sXG4gICAgbWV0aG9kID0gMCxcbiAgICBob3N0VHlwZSA9IDAsXG4gICAgaGVhZGVyID0ge30sXG4gICAgY2FjaGVLZXlMaXN0ID0gbnVsbFxuKSB7XG4gICAgdmFyIGNhY2hlS2V5ID0gZ2V0Q2FjaGVLZXkocGF0aCwgcGFyYW1zLCBjYWNoZUtleUxpc3QpO1xuICAgIGNvbnN0IGNhY2hlID0gYXdhaXQgcmVhZChcImFwaUNhY2hlXCIsIGNhY2hlS2V5KTtcbiAgICBpZiAoY2FjaGUgJiYgY2FsbGJhY2spIHtcbiAgICAgICAgY2FsbGJhY2soY2FjaGUsIHRydWUpO1xuICAgIH1cbiAgICBjb25zdCByZXF1ZXN0RGF0YSA9IGF3YWl0IHNlbmRSZXF1ZXN0KHBhdGgsIHBhcmFtcywgbWV0aG9kLCBob3N0VHlwZSwgaGVhZGVyKTtcbiAgICBhd2FpdCBzYXZlKFwiYXBpQ2FjaGVcIiwgY2FjaGVLZXksIHJlcXVlc3REYXRhKTtcbiAgICBpZiAocmVxdWVzdERhdGEgJiYgY2FsbGJhY2spIHtcbiAgICAgICAgY2FsbGJhY2socmVxdWVzdERhdGEsIGZhbHNlKTtcbiAgICB9XG4gICAgcmV0dXJuIHJlcXVlc3REYXRhO1xufVxuXG5mdW5jdGlvbiBnZXRDYWNoZUtleShwYXRoLCBwYXJhbXMsIGNhY2hlS2V5TGlzdCA9IG51bGwpIHtcbiAgICB2YXIgY2FjaGVLZXkgPSBcIlwiO1xuICAgIGlmIChjYWNoZUtleUxpc3QgPT0gbnVsbCkge1xuICAgICAgICAvL251bGzvvJrmiYDmnInlj4LmlbDkvZzkuLrnvJPlrZjlj4LmlbBcbiAgICAgICAgdmFyIHBhcmFtU3RyID0gSlNPTi5zdHJpbmdpZnkocGFyYW1zKTtcbiAgICAgICAgY2FjaGVLZXkgPSBgJHtwYXRofV8ke3BhcmFtU3RyfV8ke2NvbW1vbkRhdGEubGFuZ3VhZ2V9XyR7Y29tbW9uRGF0YS5jb2xvck1vZGV9XyR7Y29tbW9uRGF0YS5pc0xvZ2lufWA7XG4gICAgfSBlbHNlIGlmIChjYWNoZUtleUxpc3QubGVuZ3RoID09IDApIHtcbiAgICAgICAgLy8gW10gLOS4quaVsOS4ujDvvJrkuI3pnIDopoHlj4LmlbDkvZzkuLrnvJPlrZjlj4LmlbBcbiAgICAgICAgY2FjaGVLZXkgPSBgJHtwYXRofV8ke2NvbW1vbkRhdGEubGFuZ3VhZ2V9XyR7Y29tbW9uRGF0YS5jb2xvck1vZGV9XyR7Y29tbW9uRGF0YS5pc0xvZ2lufWA7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgdmFyIGNhY2hlS2V5TGlzdFN0ciA9IGNhY2hlS2V5TGlzdC5qb2luKFwiX1wiKTtcbiAgICAgICAgY2FjaGVLZXkgPSBgJHtwYXRofV8ke2NhY2hlS2V5TGlzdFN0cn1fJHtjb21tb25EYXRhLmxhbmd1YWdlfV8ke2NvbW1vbkRhdGEuY29sb3JNb2RlfV8ke2NvbW1vbkRhdGEuaXNMb2dpbn1gO1xuICAgIH1cbiAgICByZXR1cm4gY2FjaGVLZXk7XG59XG5cbi8v5qC55o2u5rao6LeM5bmF6I635Y+W5pi+56S66aKc6ImyXG5leHBvcnQgZnVuY3Rpb24gZ2V0UHJpY2VDb2xvcihyYXRpbykge1xuICAgIC8vIGNvbnNvbGUubG9nKCdnZXRQcmljZUNvbG9yJyk7XG4gICAgaWYgKHJhdGlvID09IG51bGwpIHtcbiAgICAgICAgcmF0aW8gPSAwO1xuICAgIH1cbiAgICBjb25zdCByYXRpb19hYnMgPSBNYXRoLmFicyhyYXRpbyk7XG4gICAgdmFyIGNvbG9yTGV2ZWwgPSAwO1xuICAgIGlmIChyYXRpb19hYnMgPiAwICYmIHJhdGlvX2FicyA8IDMpIHtcbiAgICAgICAgY29sb3JMZXZlbCA9IDE7XG4gICAgfSBlbHNlIGlmIChyYXRpb19hYnMgPj0gMyAmJiByYXRpb19hYnMgPCA4KSB7XG4gICAgICAgIGNvbG9yTGV2ZWwgPSAyO1xuICAgIH0gZWxzZSBpZiAocmF0aW9fYWJzID49IDgpIHtcbiAgICAgICAgY29sb3JMZXZlbCA9IDM7XG4gICAgfVxuICAgIHZhciBjb2xvckhleFN0ciA9IG51bGw7XG4gICAgaWYgKHJhdGlvID4gMCkge1xuICAgICAgICBjb2xvckhleFN0ciA9IHVwQ29sb3JMaXN0W2NvbG9yTGV2ZWxdO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIGNvbG9ySGV4U3RyID0gZG93bkNvbG9yTGlzdFtjb2xvckxldmVsXTtcbiAgICB9XG4gICAgcmV0dXJuIGNvbG9ySGV4U3RyO1xufVxuXG4vL+iOt+WPluS7t+agvOaYvuekuuaWh+acrFxuZXhwb3J0IGZ1bmN0aW9uIGdldFByaWNlU3RyaW5nKHByaWNlU3RyLCBwcmVjaXNpb24pIHtcbiAgICB2YXIgcHJpY2VUZW1wID0gcHJpY2VTdHI7XG4gICAgdmFyIGRlY2ltYWxBcnIgPSBwcmljZVRlbXAuc3BsaXQoXCIuXCIpO1xuICAgIGlmIChkZWNpbWFsQXJyLmxlbmd0aCA8IDIpIHtcbiAgICAgICAgcHJpY2VUZW1wID0gcGFyc2VGbG9hdChwcmljZVRlbXApLnRvRml4ZWQoMSk7XG4gICAgICAgIGRlY2ltYWxBcnIgPSBwcmljZVRlbXAuc3BsaXQoXCIuXCIpO1xuICAgIH1cbiAgICBjb25zdCBkZWNpbWFsQ291bnQgPSBkZWNpbWFsQXJyWzFdLmxlbmd0aDtcbiAgICBjb25zdCBwYWRkZWRQcmljZVN0ciA9XG4gICAgICAgIGRlY2ltYWxDb3VudCA8IHByZWNpc2lvblxuICAgICAgICAgICAgPyBwcmljZVRlbXAucGFkRW5kKHByaWNlVGVtcC5sZW5ndGggKyAocHJlY2lzaW9uIC0gZGVjaW1hbENvdW50KSwgXCIwXCIpXG4gICAgICAgICAgICA6IHBhcnNlRmxvYXQocHJpY2VUZW1wKS50b0ZpeGVkKHByZWNpc2lvbik7XG4gICAgY29uc3QgZmluYWxQcmljZVN0ciA9IHBhZGRlZFByaWNlU3RyLnJlcGxhY2UoL1xcZCg/PShcXGR7M30pK1xcLikvZywgXCIkJixcIik7XG4gICAgcmV0dXJuIGZpbmFsUHJpY2VTdHI7XG59XG5cbi8v6L+b6KGM57K+5bqm5aSE55CGXG5leHBvcnQgZnVuY3Rpb24gZm9ybWF0UHJlY2lzaW9uKHZhbHVlLCBwcmVjaXNpb24pIHtcbiAgICB0cnkge1xuICAgICAgICBjb25zdCByZXN1bHQgPSBudW1iZXIuZm9ybWF0KHZhbHVlLCBwcmVjaXNpb24pO1xuICAgICAgICByZXR1cm4gcmVzdWx0O1xuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5sb2coZSk7XG4gICAgICAgIHJldHVybiB2YWx1ZS50b0ZpeGVkKHByZWNpc2lvbik7XG4gICAgfVxufVxuXG4vLyAvL+aJk+W8gFVSTFxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIG9wZW5VUkwodXJsKSB7XG4gICAgaWYgKCFjbGlja2FibGUpIHtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICBjb25zb2xlLmxvZyhgb3BlbiB1cmw6YCwgdXJsKTtcbiAgICBpZiAodXJsICYmIHVybCAhPSBudWxsICYmIHVybC5sZW5ndGggPiAwKSB7XG4gICAgICAgIGF3YWl0ICRuYXRpdmVBUEkub3BlblJvdXRlKHVybCk7XG4gICAgfVxuICAgIGNsaWNrYWJsZSA9IGZhbHNlO1xuICAgIHNldFRpbWVvdXQoKCkgPT4ge1xuICAgICAgICBjbGlja2FibGUgPSB0cnVlO1xuICAgIH0sIDEwMDApO1xufVxuXG4vL+aJk+W8gOmhtemdolxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIG9wZW5QYWdlKHBhZ2UsIHR5cGUgPSBcIm5hdGl2ZVwiLCBwYXJhbXMgPSB7fSkge1xuICAgIGF3YWl0ICRuYXRpdmVBUEkuY29weVRyYWRpbmdCcmlkZ2Uoe1xuICAgICAgICBhY3Rpb246IFwib3BlblBhZ2VcIixcbiAgICAgICAgdHlwZTogdHlwZSxcbiAgICAgICAgcGFnZTogcGFnZSxcbiAgICAgICAgcGFyYW1zOiBKU09OLnN0cmluZ2lmeShwYXJhbXMpLFxuICAgIH0pO1xufVxuXG4vL3RvYXN0XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc2hvd1RvYXN0KG1zZykge1xuICAgIGF3YWl0ICRuYXRpdmVBUEkuaGJUb2FzdChtc2cpO1xufVxuXG4vL+S/neWtmOaVsOaNrlxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNhdmUobW9kdWxlLCBrZXksIGRhdGEpIHtcbiAgICBhd2FpdCAkbmF0aXZlQVBJLnN0b3JhZ2Uoe1xuICAgICAgICBhY3Rpb246IFwic2F2ZVwiLFxuICAgICAgICBuYW1lOiBtb2R1bGUsXG4gICAgICAgIGtleToga2V5LFxuICAgICAgICBkYXRhOiBKU09OLnN0cmluZ2lmeShkYXRhKSxcbiAgICB9KTtcbn1cblxuLy/or7vlj5bmlbDmja5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiByZWFkKG1vZHVsZSwga2V5KSB7XG4gICAgY29uc3QgZGF0YSA9IGF3YWl0ICRuYXRpdmVBUEkuc3RvcmFnZSh7XG4gICAgICAgIGFjdGlvbjogXCJyZWFkXCIsXG4gICAgICAgIG5hbWU6IG1vZHVsZSxcbiAgICAgICAga2V5OiBrZXksXG4gICAgfSk7XG4gICAgaWYgKGRhdGEgJiYgZGF0YSAhPSBcIlwiKSB7XG4gICAgICAgIHJldHVybiBKU09OLnBhcnNlKGRhdGEpO1xuICAgIH1cbiAgICByZXR1cm4gbnVsbDtcbn1cblxuLy/muIXnkIbmlbDmja5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBjbGVhcihtb2R1bGUsIGtleSkge1xuICAgIGF3YWl0ICRuYXRpdmVBUEkuc3RvcmFnZSh7XG4gICAgICAgIGFjdGlvbjogXCJjbGVhclwiLFxuICAgICAgICBuYW1lOiBtb2R1bGUsXG4gICAgICAgIGtleToga2V5LFxuICAgIH0pO1xufVxuXG4vL+a4heeQhuWFqOmDqOaVsOaNrlxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGNsZWFyQWxsKG1vZHVsZSkge1xuICAgIGF3YWl0ICRuYXRpdmVBUEkuc3RvcmFnZSh7XG4gICAgICAgIGFjdGlvbjogXCJjbGVhclwiLFxuICAgICAgICBuYW1lOiBtb2R1bGUsXG4gICAgfSk7XG59XG5cbi8v6K6+572u6YCa55So6YWN572uXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc2VuZENvbW1vbkNvbmZpZyhwYXJhbSkge1xuICAgIGNvbnNvbGUubG9nKHBhcmFtKTtcbiAgICBjb21tb25EYXRhLmNvbnRyYWN0SDVVcmwgPSBwYXJhbS5jb250cmFjdEg1VXJsO1xuICAgIGNvbW1vbkRhdGEuY3VycmVuY3lSYXRlID0gcGFyYW0uY3VycmVuY3lSYXRlO1xuICAgIGNvbW1vbkRhdGEuY3VycmVuY3lDaGFyYWN0ZXIgPSBwYXJhbS5jdXJyZW5jeUNoYXJhY3RlcjtcbiAgICBjb21tb25EYXRhLnByaWNlQ29sb3JUeXBlID0gcGFyc2VJbnQocGFyYW0ucHJpY2VDb2xvclR5cGUpO1xuICAgIGNvbW1vbkRhdGEuY29sb3JNb2RlID0gcGFyc2VJbnQocGFyYW0uY29sb3JNb2RlKTtcbiAgICBjb21tb25EYXRhLk9TID0gcGFyc2VJbnQocGFyYW0uT1MpO1xuICAgIGNvbW1vbkRhdGEuYXBwVmVyc2lvbiA9IHBhcmFtLmFwcFZlcnNpb247XG4gICAgY29tbW9uRGF0YS5pc0luUmV2aWV3ID0gcGFyc2VJbnQocGFyYW0uaXNJblJldmlldyk7XG4gICAgY29tbW9uRGF0YS5sYW5ndWFnZSA9IHBhcmFtLmxhbmd1YWdlO1xuICAgIGNvbW1vbkRhdGEud2ViVXJsID0gcGFyYW0ud2ViVXJsO1xuICAgIHZhciByZWRDb2xvckxpc3QgPSBbXCIjQURCMEIyXCIsIFwiI0U5NDM1OVwiLCBcIiNERTI5NDFcIiwgXCIjQ0UxNDJCXCJdO1xuICAgIHZhciBncmVlbkNvbG9yTGlzdCA9IFtcIiNBREIwQjJcIiwgXCIjMDBBMTcxXCIsIFwiIzAwOEI2MVwiLCBcIiMwMDYyNDVcIl07XG4gICAgaWYgKHBhcnNlSW50KGNvbW1vbkRhdGEucHJpY2VDb2xvclR5cGUpID09IDApIHtcbiAgICAgICAgdXBDb2xvckxpc3QgPSByZWRDb2xvckxpc3Q7XG4gICAgICAgIGRvd25Db2xvckxpc3QgPSBncmVlbkNvbG9yTGlzdDtcbiAgICB9IGVsc2Uge1xuICAgICAgICB1cENvbG9yTGlzdCA9IGdyZWVuQ29sb3JMaXN0O1xuICAgICAgICBkb3duQ29sb3JMaXN0ID0gcmVkQ29sb3JMaXN0O1xuICAgIH1cbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGdldFVwRG93bkNvbG9yKGlzVXBwZXIgPSB0cnVlLCBsZXZlbCA9IDEpIHtcbiAgICBjb25zdCBsZXYgPSBsZXZlbCA8IDQgPyBsZXZlbCA6IDA7XG4gICAgaWYgKGlzVXBwZXIpIHtcbiAgICAgICAgcmV0dXJuIHVwQ29sb3JMaXN0W2xldl07XG4gICAgfVxuICAgIHJldHVybiBkb3duQ29sb3JMaXN0W2xldl07XG59XG5sZXQgc3ltYm9sRGVzY01hcCA9IHt9XG5leHBvcnQgZnVuY3Rpb24gc3ltYm9sRGVzYyhzeW1ib2wpIHtcbiAgICBpZiAoIXN5bWJvbERlc2NNYXAuaGFzT3duUHJvcGVydHkoc3ltYm9sKSkge1xuICAgICAgICBzeW1ib2xEZXNjTWFwW3N5bWJvbF0gPSAkaTE4bi4kaW50ZXJjZXB0Lm5fY29udHJhY3Rfc3dhcF90cmFkZV9uYW1lKHN5bWJvbC5yZXBsYWNlKFwiLVwiLCBcIlwiKSk7XG4gICAgfVxuICAgIHJldHVybiBzeW1ib2xEZXNjTWFwW3N5bWJvbF07XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBtb2R1bGVEZWZpbmUobW9kdWxlTmFtZSwgc3RhcnRGdW5jdGlvbiwgZGVmYXVsdERhdGFGdW5jdGlvbikge1xuICAgIGNvbnNvbGUubG9nKGBsb2FkTW9kdWxlYCwgbW9kdWxlTmFtZSk7XG4gICAgJGRhdGFbbW9kdWxlTmFtZV0gPSBkZWZhdWx0RGF0YUZ1bmN0aW9uKCk7XG4gICAgJGV2ZW50W21vZHVsZU5hbWVdID0geyBzdGFydDogc3RhcnRGdW5jdGlvbiB9O1xuICAgIHJldHVybiB7XG4gICAgICAgIG1vZHVsZUV2ZW50OiAkZXZlbnRbbW9kdWxlTmFtZV0sXG4gICAgICAgIG1vZHVsZURhdGE6ICRkYXRhW21vZHVsZU5hbWVdLFxuICAgIH07XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBMb2cobXNnLCAuLi5hcmdzKSB7XG4gICAgY29uc29sZS5sb2coYFtjb3B5dHJhZGluZyBqcy1dJHttc2d9YCwgYXJncyk7XG59XG5cbi8qKlxuICpcbiAqIEBwYXJhbSB75pe26Ze05pel5pyf5qC85byP5YyWfSBmbXQgeXl5eS1NTS1kZCBoaDptbTpzc1xuICogQHJldHVybnMg5qC85byP5YyW5LmL5ZCO55qEIOWtl+espuS4su+8jOeUqOazleS+i+WmgiBuZXcgRGF0ZSjml7bpl7TmiLMpLkZvcm1hdChcInl5eXktTU0tZGQgaGg6bW06c3NcIilcbiAqL1xuRGF0ZS5wcm90b3R5cGUuRm9ybWF0ID0gZnVuY3Rpb24gKGZtdCkge1xuICAgIHZhciBvID0ge1xuICAgICAgICBcIk0rXCI6IHRoaXMuZ2V0TW9udGgoKSArIDEsIC8v5pyI5Lu9XG4gICAgICAgIFwiZCtcIjogdGhpcy5nZXREYXRlKCksIC8v5pelXG4gICAgICAgIFwiaCtcIjogdGhpcy5nZXRIb3VycygpLCAvL+Wwj+aXtlxuICAgICAgICBcIm0rXCI6IHRoaXMuZ2V0TWludXRlcygpLCAvL+WIhlxuICAgICAgICBcInMrXCI6IHRoaXMuZ2V0U2Vjb25kcygpLCAvL+enklxuICAgICAgICBcInErXCI6IE1hdGguZmxvb3IoKHRoaXMuZ2V0TW9udGgoKSArIDMpIC8gMyksIC8v5a2j5bqmXG4gICAgICAgIFwiU1wiOiB0aGlzLmdldE1pbGxpc2Vjb25kcygpIC8v5q+r56eSXG4gICAgfTtcbiAgICBpZiAoLyh5KykvLnRlc3QoZm10KSkgZm10ID0gZm10LnJlcGxhY2UoUmVnRXhwLiQxLCAodGhpcy5nZXRGdWxsWWVhcigpICsgXCJcIikuc3Vic3RyKDQgLSBSZWdFeHAuJDEubGVuZ3RoKSk7XG4gICAgZm9yICh2YXIgayBpbiBvKVxuICAgICAgICBpZiAobmV3IFJlZ0V4cChcIihcIiArIGsgKyBcIilcIikudGVzdChmbXQpKSBmbXQgPSBmbXQucmVwbGFjZShSZWdFeHAuJDEsIChSZWdFeHAuJDEubGVuZ3RoID09IDEpID8gKG9ba10pIDogKChcIjAwXCIgKyBvW2tdKS5zdWJzdHIoKFwiXCIgKyBvW2tdKS5sZW5ndGgpKSk7XG4gICAgcmV0dXJuIGZtdDtcbn1cblxuLyoqXG4gKlxuICogQHBhcmFtIHtib29sZWFufSBpc1Nob3cg5piv5ZCm5pi+56S65Yqg6L295qGGXG4gKi9cbmV4cG9ydCBmdW5jdGlvbiBzaG93TG9hZGluZyhpc1Nob3cgPSB0cnVlKSB7XG4gICAgJG5hdGl2ZUFQSS5zaG93TG9hZGluZyhpc1Nob3cgPyAxIDogMCk7XG59XG5cbi8qKlxuICog55Sf5oiQ5a+M5paH5pys77yM5qC55o2u5oyH5a6a55qE54m55a6a5a2X56ym5Liy6K6+572u5LiN5ZCM55qE6aKc6Imy5ZKM5a2X5Y+35qC35byP44CCXG4gKiBAcGFyYW0ge3N0cmluZ30gaW5wdXRUZXh0IC0g6L6T5YWl55qE5paH5pys44CCXG4gKiBAcGFyYW0ge0FycmF5fSBzcGVjaWZpY1N0cmluZ3MgLSDljIXlkKvnibnlrprlrZfnrKbkuLLlj4rlhbbmoLflvI/nmoTlr7nosaHmlbDnu4TjgIJcbiAqIEBwYXJhbSB7T2JqZWN0fSBbZGVmYXVsdFN0eWxlXSAtIOm7mOiupOeahOagt+W8j+Wvueixoe+8jOWMheWQq+m7mOiupOeahOminOiJsuWSjOWtl+WPt+OAglxuICogQHJldHVybnMge3N0cmluZ30gLSDmoLzlvI/ljJblkI7nmoTlr4zmlofmnKzlrZfnrKbkuLLjgIJcbiAqL1xuZXhwb3J0IGNvbnN0IGdlbmVyYXRlUmljaFRleHQgPSAoaW5wdXRUZXh0LCBkZWZhdWx0U3R5bGUsIHNwZWNpZmljU3RyaW5ncykgPT4ge1xuICAgIGlmICghZGVmYXVsdFN0eWxlKSByZXR1cm4gaW5wdXRUZXh0O1xuXG4gICAgY29uc3QgZGVmYXVsdENvbG9yID0gZGVmYXVsdFN0eWxlLmNvbG9yIHx8ICcnO1xuICAgIGNvbnN0IGRlZmF1bHRGb250U2l6ZSA9IGRlZmF1bHRTdHlsZS5mb250U2l6ZSB8fCAnJztcblxuICAgIGlmICghZGVmYXVsdENvbG9yIHx8ICFkZWZhdWx0Rm9udFNpemUpIHJldHVybiBpbnB1dFRleHQ7XG5cbiAgICBsZXQgcmVzdWx0ID0gc3BlY2lmaWNTdHJpbmdzICYmIHNwZWNpZmljU3RyaW5ncy5sZW5ndGggPiAwXG4gICAgICAgID8gc3BlY2lmaWNTdHJpbmdzLnJlZHVjZShcbiAgICAgICAgICAgIChmb3JtYXR0ZWRUZXh0LCB7IHRleHQsIGNvbG9yID0gZGVmYXVsdENvbG9yLCBmb250U2l6ZSA9IGRlZmF1bHRGb250U2l6ZSB9KSA9PlxuICAgICAgICAgICAgICAgIGZvcm1hdHRlZFRleHQucmVwbGFjZShcbiAgICAgICAgICAgICAgICAgICAgbmV3IFJlZ0V4cCh0ZXh0LCAnZycpLFxuICAgICAgICAgICAgICAgICAgICBgPHNwYW4gc3R5bGU9XCJjb2xvcjogJHtjb2xvcn07IGZvbnQtc2l6ZTogJHtmb250U2l6ZX07XCI+JHt0ZXh0fTwvc3Bhbj5gXG4gICAgICAgICAgICAgICAgKSxcbiAgICAgICAgICAgIGA8c3BhbiBzdHlsZT1cImNvbG9yOiAke2RlZmF1bHRDb2xvcn07IGZvbnQtc2l6ZTogJHtkZWZhdWx0Rm9udFNpemV9O1wiPiR7aW5wdXRUZXh0fTwvc3Bhbj5gXG4gICAgICAgIClcbiAgICAgICAgOiBgPHNwYW4gc3R5bGU9XCJjb2xvcjogJHtkZWZhdWx0Q29sb3J9OyBmb250LXNpemU6ICR7ZGVmYXVsdEZvbnRTaXplfTtcIj4ke2lucHV0VGV4dH08L3NwYW4+YDtcbiAgICBjb25zb2xlLmxvZyhcInJpY2ggdGV4dDolb1wiLCByZXN1bHQpO1xuICAgIHJldHVybiByZXN1bHQ7XG59O1xuXG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzdWJLZXlib3JkU29ja2V0KHNob3cpIHtcbiAgICBhd2FpdCAkbmF0aXZlQVBJLmNvcHlUcmFkaW5nQnJpZGdlKHtcbiAgICAgICAgYWN0aW9uOiBzaG93LFxuICAgICAgICB0eXBlOiBcInRyYWRlTGltaXRLZXlib2FyZFwiLFxuICAgIH0pO1xufVxuXG4vKipcbiAqXG4gKiBAcGFyYW0ge3N0cmluZ30gc3ltYm9sIOW4geWvueS/oeaBr++8jEJUQy1VU0RUXG4gKiBAcmV0dXJucyDov5Tlm57luIHnp43lkozljZXkvY17Y29pbjonQlRDJyx1bml0OidVU0RUJyB9XG4gKi9cbmV4cG9ydCBmdW5jdGlvbiBjb2luVW5pdChzeW1ib2wpIHtcbiAgICBjb2luID0gXCJcIlxuICAgIHVuaXQgPSBcIlwiXG4gICAgY29uc3QgY29pblVuaXQgPSBzeW1ib2wuc3BsaXQoXCItXCIpO1xuICAgIGlmIChjb2luVW5pdCAmJiBjb2luVW5pdC5sZW5ndGggPiAwKSB7XG4gICAgICAgIGNvaW4gPSBjb2luVW5pdFswXTtcbiAgICAgICAgaWYgKGNvaW5Vbml0Lmxlbmd0aCA+IDEpIHtcbiAgICAgICAgICAgIHVuaXQgPSBjb2luVW5pdFsxXTtcbiAgICAgICAgfVxuICAgIH1cbiAgICByZXR1cm4geyBjb2luLCB1bml0IH07XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBjaGVja0xvZ2luKCkge1xuICAgIHJldHVybiBhd2FpdCAkbmF0aXZlQVBJLmNoZWNrTG9naW4oKTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGdldFBOR0ljb25VUkxCeUN1cnJlbmN5KGN1cnJlbmN5KSB7XG4gICAgbGV0IGJhc2VVcmwgPSBjb21tb25EYXRhLndlYlVybCA/IGNvbW1vbkRhdGEud2ViVXJsIDogXCJcIjtcbiAgICByZXR1cm4gYCR7YmFzZVVybH0vLS94L2hiL3AvYXBpL2NvbnRlbnRzL2N1cnJlbmN5L2ljb25fcG5nLyR7Y3VycmVuY3kudG9Mb3dlckNhc2UoKX0ucG5nYDtcbn1cblxuLyog6Ziy5q2i6YeN5aSN54K55Ye7ICovXG5sZXQgY2xpY2tUaW1lciA9IDBcblxuZXhwb3J0IGZ1bmN0aW9uIGNsaWNrVGhyb3R0bGUoaW50ZXJ2YWwgPSAyMDAwKSB7XG4gICAgdHJ5IHtcbiAgICAgICAgbGV0IG5vdyA9IG5ldyBEYXRlKCkuZ2V0VGltZSgpO1xuICAgICAgICBsZXQgdGltZXIgPSBjbGlja1RpbWVyO1xuICAgICAgICBjb25zb2xlLmxvZyhgY29tbW9uIGNsaWNrVGhyb3R0bGUgbm93ID0gJHtub3d9YClcbiAgICAgICAgY29uc29sZS5sb2coYGNvbW1vbiBjbGlja1Rocm90dGxlIHRpbWVyID0gJHt0aW1lcn1gKVxuICAgICAgICBpZiAobm93IC0gdGltZXIgPCBpbnRlcnZhbCkge1xuICAgICAgICAgICAgY29uc29sZS5sb2coYGNvbW1vbiBjbGlja1Rocm90dGxlIGRvdWJsZSBjbGlja2ApXG4gICAgICAgICAgICByZXR1cm4gZmFsc2U7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBjbGlja1RpbWVyID0gbm93O1xuICAgICAgICAgICAgcmV0dXJuIHRydWU7XG4gICAgICAgIH1cbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGBjb21tb24gY2xpY2tUaHJvdHRsZSBlcnJvciA9ICR7ZX1gKVxuICAgIH1cbn1cblxuZXhwb3J0IGZ1bmN0aW9uIHBhcnNlQm9vbGVhbihzdHJpbmcpIHtcbiAgICBzd2l0Y2ggKFN0cmluZyhzdHJpbmcpLnRvTG93ZXJDYXNlKCkpIHtcbiAgICAgICAgY2FzZSBcInRydWVcIjpcbiAgICAgICAgY2FzZSBcIjFcIjpcbiAgICAgICAgY2FzZSBcInllc1wiOlxuICAgICAgICBjYXNlIFwieVwiOlxuICAgICAgICAgICAgcmV0dXJuIHRydWU7XG4gICAgICAgIGNhc2UgXCJmYWxzZVwiOlxuICAgICAgICBjYXNlIFwiMFwiOlxuICAgICAgICBjYXNlIFwibm9cIjpcbiAgICAgICAgY2FzZSBcIm5cIjpcbiAgICAgICAgICAgIHJldHVybiBmYWxzZTtcbiAgICAgICAgZGVmYXVsdDpcbiAgICAgICAgICAgIC8veW91IGNvdWxkIHRocm93IGFuIGVycm9yLCBidXQgJ3VuZGVmaW5lZCcgc2VlbXMgYSBtb3JlIGxvZ2ljYWwgcmVwbHlcbiAgICAgICAgICAgIHJldHVybiB1bmRlZmluZWQ7XG4gICAgfVxufVxuZXhwb3J0IGZ1bmN0aW9uIG5vdE51bGwoc3RyaW5nKSB7XG4gICAgaWYgKHN0cmluZyA9PSBudWxsIHx8IHN0cmluZyA9PSBcIlwiKSB7XG4gICAgICAgIHJldHVybiBmYWxzZTtcbiAgICB9XG4gICAgcmV0dXJuIHRydWU7XG59XG5cbi8v5Z+L54K5XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gYW5hbHl0aWNzKGV2ZW50ID0gXCJcIiwgcHJvcGVydGllcyA9IHt9KSB7XG4gICAgY29uc3QgcHJvcGVydGllc0pzb24gPSBKU09OLnN0cmluZ2lmeShwcm9wZXJ0aWVzKTtcbiAgICBjb25zb2xlLmxvZyhgYW5hbHl0aWNzIGV2ZW50OiAke2V2ZW50fSwgcHJvcGVydGllc0pzb24gPSAke3Byb3BlcnRpZXNKc29ufWApO1xuICAgIHZhciBtYXAgPSB7XG4gICAgICAgIGV2ZW50OiBldmVudCxcbiAgICAgICAgcHJvcGVydGllczogcHJvcGVydGllc0pzb25cbiAgICB9O1xuICAgIGF3YWl0ICRuYXRpdmVBUEkuYW5hbHl0aWNzKG1hcCk7XG59XG5cbi8qKlxuICog6K+l5biB56eN55u45bqU5pWw6YeP5a+55bqU55qE5rOV5biB5oqY5ZCIXG4gKi9cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnQoY3VycmVuY3ksIGFtb3VudCkge1xuICAgIGlmICghYW1vdW50KSB7XG4gICAgICAgIGFtb3VudCA9ICcwJztcbiAgICB9XG4gICAgY29uc3QgcGFyYW0gPSB7XG4gICAgICAgIHR5cGU6IDEsXG4gICAgICAgIGN1cnJlbmN5OiBjdXJyZW5jeSxcbiAgICAgICAgYW1vdW50LFxuICAgIH07XG4gICAgY29uc3QgcGFyYW1TdHJpbmcgPSBKU09OLnN0cmluZ2lmeShwYXJhbSk7XG4gICAgcmV0dXJuIHRob3VzYW5kc0Zvcm1hdHRlcihhd2FpdCAkbmF0aXZlQVBJLmN1cnJlbmN5Q29tbW9uKHBhcmFtU3RyaW5nKSArIFwiXCIpO1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZ2V0TGVnYWxDdXJyZW5jeVN5bWJvbCgpIHtcbiAgICBjb25zdCBjdXJyZW5jeVN5bWJvbCA9IGF3YWl0ICRuYXRpdmVBUEkuY3VycmVuY3lDb21tb24oJ3tcInR5cGVcIjo5fScpO1xuICAgIHJldHVybiBjdXJyZW5jeVN5bWJvbDtcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGFkZEN1cnJlbnRDdXJyZW5jeVN5bWJvbChzb3VyY2UpIHtcbiAgICBjb25zdCBzeW1ib2wgPSBhd2FpdCBnZXRMZWdhbEN1cnJlbmN5U3ltYm9sKCk7XG4gICAgcmV0dXJuIGFkZEN1cnJlbmN5U3ltYm9sKHN5bWJvbCwgc291cmNlKTtcbn1cbmV4cG9ydCBmdW5jdGlvbiBhZGRDdXJyZW5jeVN5bWJvbChjdXJyZW5jeVN5bWJvbCwgc291cmNlKSB7XG4gICAgaWYgKHNvdXJjZSA9PT0gJy0tJykge1xuICAgICAgICByZXR1cm4gc291cmNlO1xuICAgIH1cbiAgICBlbHNlIGlmIChzb3VyY2UgJiYgc291cmNlICE9PSBERUZBVUxUX1NUUikge1xuICAgICAgICBpZiAoc291cmNlLnN0YXJ0c1dpdGgoJy0nKSkge1xuICAgICAgICAgICAgcmV0dXJuIGAtJHtjdXJyZW5jeVN5bWJvbH0ke3NvdXJjZS5zdWJzdHJpbmcoMSl9YDtcbiAgICAgICAgfVxuICAgICAgICByZXR1cm4gYCR7Y3VycmVuY3lTeW1ib2x9JHtzb3VyY2V9YDtcbiAgICB9IGVsc2Uge1xuICAgICAgICByZXR1cm4gYCR7Y3VycmVuY3lTeW1ib2x9JHtERUZBVUxUX1NUUn1gO1xuICAgIH1cbn1cblxuLyoqXG4gKiDojrflj5ZBY2NvdW50SWRcbiAqL1xuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGdldEFjY291bnRJZCgpIHtcbiAgICBjb25zdCBhY2NvdW50cyA9IGF3YWl0IHNlbmRSZXF1ZXN0KFwidjEvYWNjb3VudC9hY2NvdW50c1wiLCB7fSwgMCwgNCk7XG4gICAgY29uc29sZS5sb2coYG1hcmdpbi1ob21lIGdldEFjY291bnRJZCAxMTEgYWNjb3VudHMgPSAke2FjY291bnRzfSwganNvbiA9ICR7SlNPTi5zdHJpbmdpZnkoYWNjb3VudHMpfWApXG4gICAgaWYgKGFjY291bnRzID09IG51bGwgfHwgYWNjb3VudHMubGVuZ3RoID09IDApIHtcbiAgICAgICAgY29uc29sZS5sb2coYG1hcmdpbi1ob21lIGdldEFjY291bnRJZCAyMjJgKVxuICAgICAgICByZXR1cm5cbiAgICB9XG4gICAgZm9yIChsZXQgaSA9IDA7IGkgPCBhY2NvdW50cy5sZW5ndGg7IGkrKykge1xuICAgICAgICBsZXQgYWNjb3VudCA9IGFjY291bnRzW2ldXG4gICAgICAgIGNvbnNvbGUubG9nKGBtYXJnaW4taG9tZSBnZXRBY2NvdW50SWQgYWNjb3VudCA9ICR7SlNPTi5zdHJpbmdpZnkoYWNjb3VudCl9YClcbiAgICAgICAgaWYgKGFjY291bnQudHlwZSA9PSBcInN1cGVyLW1hcmdpblwiKSB7XG4gICAgICAgICAgICBjb21tb25EYXRhLnN1cGVyTWFyZ2luQWNjb3VudElkID0gYWNjb3VudC5pZFxuICAgICAgICAgICAgY29uc29sZS5sb2coYG1hcmdpbi1ob21lIGdldEFjY291bnRJZCBzdXBlck1hcmdpbkFjY291bnRJZCA9ICR7Y29tbW9uRGF0YS5zdXBlck1hcmdpbkFjY291bnRJZH1gKVxuICAgICAgICB9IGVsc2UgaWYgKGFjY291bnQudHlwZSA9PSBcIm1hcmdpblwiKSB7XG4gICAgICAgICAgICBjb21tb25EYXRhLm1hcmdpbkFjY291bnRJZCA9IGFjY291bnQuaWRcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGBtYXJnaW4taG9tZSBnZXRBY2NvdW50SWQgbWFyZ2luQWNjb3VudElkID0gJHtjb21tb25EYXRhLm1hcmdpbkFjY291bnRJZH1gKVxuICAgICAgICB9XG4gICAgfVxuICAgIGNvbnNvbGUubG9nKGBtYXJnaW4taG9tZSBnZXRBY2NvdW50SWQgZW5kYClcbn1cblxuLyoqXG4gKiDlhajku5PlgJ/luIEv6L+Y5biB5biB56eN5o6l5Y+jXG4gKi9cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRDdXJyZW5jeUxpc3QodHlwZSkge1xuICAgIHZhciByZXF1ZXN0VHlwZSA9IHR5cGUgPT0gMCA/IDE6IDI7XG4gICAgbGV0IGN1cnJlbmN5TGlzdCA9IGF3YWl0IHNlbmRSZXF1ZXN0KFwidjEvaGJnL3N1cGVyLW1hcmdpbi9jdXJyZW5jeS1saXN0LXYyXCIsIHt0eXBlOiByZXF1ZXN0VHlwZX0sIDAsIDQpO1xuICAgIGlmICh0eXBlID09IDApIHtcbiAgICAgICAgY29tbW9uRGF0YS5sb2FuQ3VycmVuY3lMaXN0ID0gY3VycmVuY3lMaXN0O1xuICAgIH0gZWxzZSB7XG4gICAgICAgIGNvbW1vbkRhdGEucmVwYXlDdXJyZW5jeUxpc3QgPSBjdXJyZW5jeUxpc3RcbiAgICB9XG59XG5cbi8qKlxuICog6YCQ5LuT5YCf5biB5biB56eN5YiX6KGoXG4gKi9cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRTeW1ib2xMaXN0KHR5cGUpIHtcbiAgICB2YXIgcmVxdWVzdFR5cGUgPSB0eXBlID09IDAgPyAxOiAyO1xuICAgIGxldCBzeW1ib2xMaXN0ID0gYXdhaXQgc2VuZFJlcXVlc3QoXCJ2MS9oYmcvbWFyZ2luL3N5bWJvbC1saXN0LXYyXCIsIHt0eXBlOiByZXF1ZXN0VHlwZX0sIDAsIDQpO1xuICAgIGlmICh0eXBlID09IDApIHtcbiAgICAgICAgY29tbW9uRGF0YS5sb2FuU3ltYm9sTGlzdCA9IHN5bWJvbExpc3Q7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgY29tbW9uRGF0YS5yZXBheVN5bWJvbExpc3QgPSBzeW1ib2xMaXN0O1xuICAgIH1cbn1cblxuXG4vKipcbiAqIOWNg+WIhuS9jeWkhOeQhlxuICovXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZm9ybWF0VGhvdXNhbmRzKG51bWJlcikge1xuICAgIGlmIChudW1iZXIgPT09ICctLScpIHtcbiAgICAgICAgcmV0dXJuIG51bWJlcjtcbiAgICB9XG4gICAgY29uc3QgcGFyYW1zID0ge1xuICAgICAgICB0eXBlOiA1MyxcbiAgICAgICAgbnVtYmVyXG4gICAgfTtcbiAgICByZXR1cm4gYXdhaXQgJG5hdGl2ZUFQSS5jdXJyZW5jeUNvbW1vbihKU09OLnN0cmluZ2lmeShwYXJhbXMpKTtcbn1cblxuLyoqXG4gKiDlsI/mlbDnsr7luqZcbiAqIEBwYXJhbSBzdHIg5pWw5a2XXG4gKiBAcGFyYW0gcHJlY2lzaW9uIOeyvuW6pu+8jOS/neeVmeWwj+aVsOS9jeaVsFxuICogQHBhcmFtIG5lZWRUaG91c2FuZHMg5piv5ZCm6ZyA6KaB5Y2D5YiG5L2N5aSE55CGXG4gKi9cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBmb3JtYXREZWNpbWFsKHN0ciwgcHJlY2lzaW9uLCBuZWVkVGhvdXNhbmRzKSB7XG4gICAgaWYgKHN0ci5sZW5ndGggPT09IDAgfHwgaXNOYU4oc3RyKSkge1xuICAgICAgICByZXR1cm4gXCIwXCI7XG4gICAgfVxuICAgIHN0ciArPSBcIlwiXG4gICAgaWYgKHN0ci5pbmNsdWRlcyhcIi5cIikpIHtcbiAgICAgICAgdmFyIGRlY2ltYWwgPSBzdHIuc3BsaXQoJy4nKVsxXTtcbiAgICAgICAgaWYgKGRlY2ltYWwgJiYgZGVjaW1hbC5sZW5ndGggPiBwcmVjaXNpb24pIHtcbiAgICAgICAgICAgIHN0ciA9IHN0ci5yZXBsYWNlKCcuJyArIGRlY2ltYWwsICcuJyArIGRlY2ltYWwuc2xpY2UoMCwgcHJlY2lzaW9uKSk7XG4gICAgICAgICAgICByZXR1cm4gbmVlZFRob3VzYW5kcyA/IGF3YWl0IGZvcm1hdFRob3VzYW5kcyhzdHIpIDogc3RyO1xuICAgICAgICB9XG4gICAgfVxuICAgIHJldHVybiBuZWVkVGhvdXNhbmRzID8gYXdhaXQgZm9ybWF0VGhvdXNhbmRzKHN0ciArIFwiXCIpIDogc3RyICsgXCJcIjtcbn1cblxuLyoqXG4gKiDljYPliIbkvY3lpITnkIZcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIHRob3VzYW5kc0Zvcm1hdHRlcihudW1iZXIpIHtcbiAgICAvLyDlhYjlsIbmlbDlrZfovazkuLrlrZfnrKbkuLLvvIzlubbliKTmlq3mmK/lkKbmnInlsI/mlbDpg6jliIZcbiAgICBsZXQgW2ludGVnZXJQYXJ0LCBkZWNpbWFsUGFydF0gPSBudW1iZXIudG9TdHJpbmcoKS5zcGxpdCgnLicpO1xuXG4gICAgLy8g5a+55pW05pWw6YOo5YiG5re75Yqg5Y2D5YiG5L2N5YiG6ZqU56ymXG4gICAgaW50ZWdlclBhcnQgPSBpbnRlZ2VyUGFydC5yZXBsYWNlKC9cXEIoPz0oXFxkezN9KSsoPyFcXGQpKS9nLCAnLCcpO1xuXG4gICAgLy8g5aaC5p6c5pyJ5bCP5pWw6YOo5YiG77yM5YiZ5ou85o6l5pW05pWw6YOo5YiG5ZKM5bCP5pWw6YOo5YiGXG4gICAgaWYgKGRlY2ltYWxQYXJ0KSB7XG4gICAgICAgIHJldHVybiBpbnRlZ2VyUGFydCArICcuJyArIGRlY2ltYWxQYXJ0O1xuICAgIH0gZWxzZSB7XG4gICAgICAgIHJldHVybiBpbnRlZ2VyUGFydDtcbiAgICB9XG59XG5cbi8v5pe26Ze06YCJ5oup5ZmoXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc2hvd0RhdGVQaWNrZXIocGFyYW0pIHtcbiAgICBjb25zdCBkYXRhID0gYXdhaXQgJG5hdGl2ZUFQSS5zaG93RGF0ZVBpY2tlcihKU09OLnN0cmluZ2lmeShwYXJhbSkpO1xuICAgIGlmIChkYXRhICYmIGRhdGEgIT0gXCJcIikge1xuICAgICAgICByZXR1cm4gZGF0YTtcbiAgICB9XG4gICAgcmV0dXJuIG51bGw7XG59XG5cbi8v5biB56eN57K+5bqmXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZ2V0Q3VycmVuY3lTaG93UHJlY2lzaW9uKHBhcmFtKSB7XG4gICAgY29uc3QgZGF0YSA9IGF3YWl0ICRuYXRpdmVBUEkuZ2V0Q3VycmVuY3lTaG93UHJlY2lzaW9uKHBhcmFtKTtcbiAgICBpZiAoZGF0YSAmJiBkYXRhICE9IFwiXCIpIHtcbiAgICAgICAgcmV0dXJuIHBhcnNlSW50KGRhdGEpO1xuICAgIH1cbiAgICByZXR1cm4gODtcbn1cblxuLy/ojrflj5ZzeW1ib2znmoRkaXNwbGF5TmFtZVxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGdldFN5bWJvbERpc3BsYXlOYW1lKHN5bWJvbCkge1xuICAgIGNvbnN0IGRhdGEgPSBhd2FpdCAkbmF0aXZlQVBJLmdldFNwb3RTeW1ib2xNb2RlbChzeW1ib2wpO1xuICAgIGNvbnN0IHN5bWJvbE1vZGVsID0gSlNPTi5wYXJzZShkYXRhKTtcbiAgICBpZiAoc3ltYm9sTW9kZWwgJiYgc3ltYm9sTW9kZWwgIT0gXCJcIikge1xuICAgICAgICByZXR1cm4gc3ltYm9sTW9kZWwuc3ltYm9sTmFtZTtcbiAgICB9XG4gICAgcmV0dXJuIFwiLS1cIjtcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHVwbG9hZExvZyh0YWcsIGluZm8gPSBcIlwiKSB7XG4gICAgdmFyIG1hcCA9IHtcbiAgICAgICAgdGFnOiB0YWcsXG4gICAgICAgIGluZm86IGluZm9cbiAgICB9O1xuICAgIGF3YWl0ICRuYXRpdmVBUEkudXBsb2FkTG9nKG1hcCk7XG59IiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gJy4vY29tbW9uJztcblxubGV0IG9uZUNhbGxiYWNrO1xubGV0IGxlZnRDYWxsYmFjaztcbmxldCByaWdodENhbGxiYWNrO1xuXG4vL+WIneWni+WMllxuYXN5bmMgZnVuY3Rpb24gc3RhcnQoKSB7XG59XG5cbi8v5Yid5aeL5YyW5pWw5o2uXG5mdW5jdGlvbiBkZWZhdWx0RGF0YSgpIHtcbiAgICByZXR1cm4ge1xuICAgICAgICB0aXRsZVZpc2liaWxpdHkgOiBcInZpc2libGVcIixcbiAgICAgICAgb25lQnV0dG9uVmlzaWJpbGl0eSA6IFwiZ29uZVwiLFxuICAgICAgICB0d29CdXR0b25WaXNpYmlsaXR5IDogXCJ2aXNpYmxlXCIsXG4gICAgICAgIGNlbnRlckJ1dHRvblRleHQgOiAkaTE4bi5uX2NvcHlfdHJhZGluZ19tZV9rbm93LFxuICAgICAgICBsZWZ0QnV0dG9uVGV4dCA6ICRpMThuLm5fY2FuY2VsLFxuICAgICAgICByaWdodEJ1dHRvblRleHQgOiAkaTE4bi5uX3N1cmUsXG4gICAgICAgIHBvcFRpdGxlIDogJGkxOG4ubl9jb3B5X3RyYWRpbmdfdGlwLFxuICAgICAgICBwb3BDb250ZW50IDogXCItLVwiLFxuICAgICAgICB0b2FzdFR5cGU6IC0xLFxuICAgICAgICBwb3BTaG93OiBmYWxzZVxuICAgIH07XG59XG5cbmNvbnN0IHsgbW9kdWxlRGF0YSwgbW9kdWxlRXZlbnQgfSA9IGNvbW1vbi5tb2R1bGVEZWZpbmUoXCJjb21tb25Qb3BcIiwgc3RhcnQsIGRlZmF1bHREYXRhKTtcblxuXG5leHBvcnQgZnVuY3Rpb24gcG9wVXBDb250ZW50T2ZPbmVCdXR0b24odGl0bGUsIGNvbmV0ZW50LCBjZW50ZXJUZXh0LCB0aXRsZVZpc2liaWxpdHkgPSBcInZpc2libGVcIiwgb25lQnRuQ2FsbEJhY2sgPSBudWxsKSB7XG4gICAgb25lQ2FsbGJhY2sgPSBvbmVCdG5DYWxsQmFjaztcbiAgICBtb2R1bGVEYXRhLm9uZUJ1dHRvblZpc2liaWxpdHkgPSBcInZpc2libGVcIjtcbiAgICBtb2R1bGVEYXRhLnR3b0J1dHRvblZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICBtb2R1bGVEYXRhLnRpdGxlVmlzaWJpbGl0eSA9IHRpdGxlVmlzaWJpbGl0eTtcbiAgICBpZiAodGl0bGUgJiYgdGl0bGUgIT09IG51bGwpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5wb3BUaXRsZSA9IHRpdGxlO1xuICAgIH1cbiAgICBpZiAoY29uZXRlbnQgJiYgY29uZXRlbnQgIT09IG51bGwpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5wb3BDb250ZW50ID0gY29uZXRlbnQ7XG4gICAgfVxuICAgIGlmIChjZW50ZXJUZXh0ICYmIGNlbnRlclRleHQgIT09IG51bGwpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5jZW50ZXJCdXR0b25UZXh0ID0gY2VudGVyVGV4dDtcbiAgICB9XG4gICAgaWYoIW1vZHVsZURhdGEucG9wU2hvdykge1xuICAgICAgICBtb2R1bGVEYXRhLnBvcFNob3cgPSB0cnVlO1xuICAgIH0gIFxufVxuXG5leHBvcnQgZnVuY3Rpb24gcG9wVXBDb250ZW50T2ZUd29CdXR0b24odHlwZSwgdGl0bGUsIGNvbnRlbnQsIGxlZnRUZXh0LCByaWdodFRleHQsIHRpdGxlVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiLCBsZWZ0QnRuQ2FsbGJhY2sgPSBudWxsLCByaWdodEJ0bkNhbGxiYWNrKSB7XG4gICAgbGVmdENhbGxiYWNrID0gbGVmdEJ0bkNhbGxiYWNrO1xuICAgIHJpZ2h0Q2FsbGJhY2sgPSByaWdodEJ0bkNhbGxiYWNrO1xuICAgIG1vZHVsZURhdGEub25lQnV0dG9uVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgIG1vZHVsZURhdGEudHdvQnV0dG9uVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuICAgIG1vZHVsZURhdGEudGl0bGVWaXNpYmlsaXR5ID0gdGl0bGVWaXNpYmlsaXR5O1xuICAgIGlmICh0aXRsZSAmJiB0aXRsZSAhPT0gbnVsbCkge1xuICAgICAgICBtb2R1bGVEYXRhLnBvcFRpdGxlID0gdGl0bGU7XG4gICAgfVxuICAgIGlmIChjb250ZW50ICYmIGNvbnRlbnQgIT09IG51bGwpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5wb3BDb250ZW50ID0gY29udGVudDtcbiAgICB9XG4gICAgaWYgKGxlZnRUZXh0ICYmIGxlZnRUZXh0ICE9PSBudWxsKSB7XG4gICAgICAgIG1vZHVsZURhdGEubGVmdEJ1dHRvblRleHQgPSBsZWZ0VGV4dDtcbiAgICB9XG4gICAgaWYgKHJpZ2h0VGV4dCAmJiByaWdodFRleHQgIT09IG51bGwpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5yaWdodEJ1dHRvblRleHQgPSByaWdodFRleHQ7XG4gICAgfVxuICAgIG1vZHVsZURhdGEudG9hc3RUeXBlID0gdHlwZTtcbiAgICBpZighbW9kdWxlRGF0YS5wb3BTaG93KSB7XG4gICAgICAgIG1vZHVsZURhdGEucG9wU2hvdyA9IHRydWU7XG4gICAgfVxufVxuXG5tb2R1bGVFdmVudC5wb3BEaXNtaXNzID0gZnVuY3Rpb24gKCkge1xuICAgIG1vZHVsZURhdGEucG9wU2hvdyA9IGZhbHNlO1xufVxuXG5tb2R1bGVFdmVudC5idG5DbGljayA9IGZ1bmN0aW9uICh0eXBlKSB7XG4gICAgbW9kdWxlRGF0YS5wb3BTaG93ID0gZmFsc2U7XG4gICAgaWYgKHR5cGUgPT0gMCAmJiBvbmVDYWxsYmFjayAhPSBudWxsKSB7XG4gICAgICAgIG9uZUNhbGxiYWNrKCk7XG4gICAgfSBlbHNlIGlmICh0eXBlID09IDEgJiYgbGVmdENhbGxiYWNrICE9IG51bGwpIHtcbiAgICAgICAgbGVmdENhbGxiYWNrKClcbiAgICB9IGVsc2UgaWYgKHR5cGUgPT0gMiAmJiByaWdodENhbGxiYWNrICE9IG51bGwpIHtcbiAgICAgICAgcmlnaHRDYWxsYmFjaygpXG4gICAgfVxufVxuIiwiaW1wb3J0ICogYXMgbnVtYmVyIGZyb20gXCIuL251bWJlclwiXG5pbXBvcnQgKiBhcyBjb21tb24gZnJvbSBcIi4vY29tbW9uXCJcbmltcG9ydCAqIGFzIGNvbW1vblBvcCBmcm9tIFwiLi9jb21tb25Qb3BcIlxuXG5sZXQgY2FsbEJhY2s7XG5sZXQgY3VycmVudFBhZ2VUeXBlID0gMVxubGV0IGN1cnJlbnRNYXJnaW5UeXBlID0gMVxubGV0IHRlbXBMaXN0ID0gW11cbnZhciBpc0NhbmNlbFNlYXJjaCA9IGZhbHNlXG5cbi8v6L6T5YWl5qGG55u45YWz6aKc6ImyXG5jb25zdCBFZGl0X0JvYXJkX1NlbGVjdENvbG9yID0gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiXG5jb25zdCBFZGl0X0JvYXJkX05vcm1hbENvbG9yID0gXCJAY29sb3IvS0Jhc2VDb2xvckNvbnRlbnRCYWNrZ3JvdW5kXCJcblxubGV0IGhpc3RvcnlTZWFyY2hMaXN0ID0gW11cblxuZnVuY3Rpb24gZGVmYXVsdERhdGEoKSB7XG4gICAgcmV0dXJuIHtcbiAgICAgICAgcG9wRGF0YTogW10sXG4gICAgICAgIHNob3dDdXJyZW5jeVBvcDogXCJmYWxzZVwiLFxuICAgICAgICBjdXJyZW5jeUxpc3RWaXNpYmxlOiBcImludmlzaWJsZVwiLFxuICAgICAgICBjdXJyZW5jeUVtcHR5VmlzaWJsZTogXCJnb25lXCIsXG4gICAgICAgIGJvcmRlckNvbG9yOiBFZGl0X0JvYXJkX05vcm1hbENvbG9yLFxuICAgICAgICBzZWFyY2hXb3JkOiBcIlwiLFxuICAgICAgICB0aXRsZVRleHQ6ICRpMThuLm5fbWFyZ2luX2N1cnJlbmN5X2xpc3QsXG4gICAgICAgIHNlYXJjaENvaW5zSGlzdG9yeTogW10sXG4gICAgICAgIHNob3dIaXN0b3J5OiBcImdvbmVcIlxuICAgIH1cbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHN0YXJ0KCkge1xuXG59XG5cbmNvbnN0IHsgbW9kdWxlRGF0YSwgbW9kdWxlRXZlbnQgfSA9IGNvbW1vbi5tb2R1bGVEZWZpbmUoXG4gICAgXCJzZWxlY3RDdXJyZW5jeVBvcFwiLFxuICAgIHN0YXJ0LFxuICAgIGRlZmF1bHREYXRhXG4pXG5cbi8qKlxuICogQHBhcmFtIHBhZ2VUeXBlIDDlgJ/vvIwx6L+YXG4gKiBAcGFyYW0gbWFyZ2luVHlwZSAx5YWo5LuT77yMMumAkOS7k1xuICogQHBhcmFtIGxpc3RlbmVyIOmAieaLqeeCueWHu+Wbnuiwg1xuICovXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc2hvd1BvcChwYWdlVHlwZSwgbWFyZ2luVHlwZSwgbGlzdGVuZXIpIHtcbiAgICBjYWxsQmFjayA9IGxpc3RlbmVyXG4gICAgbW9kdWxlRGF0YS5zZWFyY2hXb3JkID0gXCJcIlxuICAgIGN1cnJlbnRNYXJnaW5UeXBlID0gbWFyZ2luVHlwZVxuICAgIGlmIChtYXJnaW5UeXBlID09IDEpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5wb3BUaXRsZSA9ICRpMThuLm5fbWFyZ2luX3NlbGVjdF9jdXJyZW5jeVxuICAgICAgICBtb2R1bGVEYXRhLnNlYXJjaEhpbnQgPSAkaTE4bi5uX2Vhcm5fc2VhcmNoX2NvaW5cbiAgICB9IGVsc2Uge1xuICAgICAgICBtb2R1bGVEYXRhLnBvcFRpdGxlID0gJGkxOG4ubl9tYXJnaW5fc2VsZWN0X2N1cnJlbmN5X3BhaXJcbiAgICAgICAgbW9kdWxlRGF0YS5zZWFyY2hIaW50ID0gJGkxOG4ubl9tYXJnaW5fc2VhcmNoX2N1cnJlbmN5XG4gICAgfVxuICAgIHRlbXBMaXN0ID0gW11cbiAgICBsZXQgdGVtcEhpc3RvcnlMaXN0ID0gW11cbiAgICBpZiAobWFyZ2luVHlwZSA9PSAxKSB7XG4gICAgICAgIHRlbXBIaXN0b3J5TGlzdCA9IGF3YWl0IGNvbW1vbi5yZWFkKFwibWFyZ2luXCIsIFwiaGlzdG9yeUNyb3NzXCIpXG4gICAgICAgIG1vZHVsZURhdGEudGl0bGVUZXh0ID0gJGkxOG4ubl9tYXJnaW5fY3VycmVuY3lfbGlzdFxuICAgICAgICBmb3IgKGxldCBpID0gMDsgaSA8IGNvbW1vbi5jb21tb25EYXRhLmN1cnJlbmN5TGlzdC5sZW5ndGg7IGkrKykge1xuICAgICAgICAgICAgbGV0IHRlbXBEYXRhID0gY29tbW9uLmNvbW1vbkRhdGEuY3VycmVuY3lMaXN0W2ldXG4gICAgICAgICAgICBsZXQgZGVidCA9IGAke051bWJlcih0ZW1wRGF0YS5iYWxhbmNlKX1gXG4gICAgICAgICAgICBtb2R1bGVEYXRhLnRpdGxlRGVzYyA9ICRpMThuLm5fbWFyZ2luX2Fzc2V0c1xuICAgICAgICAgICAgaWYgKHBhZ2VUeXBlID09IDEpIHtcbiAgICAgICAgICAgICAgICBkZWJ0ID0gYCR7TnVtYmVyKHRlbXBEYXRhLmRlYnQpfWBcbiAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLnRpdGxlRGVzYyA9ICRpMThuLm5fbWFyZ2luX2xpYWJpbGl0aWVzX2Ftb3VudFxuICAgICAgICAgICAgfVxuICAgICAgICAgICAgdGVtcExpc3QucHVzaCh7XG4gICAgICAgICAgICAgICAgdHlwZTogXCJjcm9zc1wiLFxuICAgICAgICAgICAgICAgIGluZGV4OiBpLnRvU3RyaW5nKCksXG4gICAgICAgICAgICAgICAgaWNvbjogY29tbW9uLmdldFBOR0ljb25VUkxCeUN1cnJlbmN5KHRlbXBEYXRhLmN1cnJlbmN5KSxcbiAgICAgICAgICAgICAgICBjdXJyZW5jeTogdGVtcERhdGEuY3VycmVuY3ksXG4gICAgICAgICAgICAgICAgY3VycmVuY3lUZXh0OiB0ZW1wRGF0YS5jdXJyZW5jeS50b1VwcGVyQ2FzZSgpLFxuICAgICAgICAgICAgICAgIGRlYnQ6IGNvbW1vbi50aG91c2FuZHNGb3JtYXR0ZXIoZGVidCksXG4gICAgICAgICAgICAgICAgZGVidEFtb3VudDogYXdhaXQgY29tbW9uLmFkZEN1cnJlbnRDdXJyZW5jeVN5bWJvbChhd2FpdCBjb21tb24uZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50KHRlbXBEYXRhLmN1cnJlbmN5LCBkZWJ0KSlcbiAgICAgICAgICAgIH0pXG4gICAgICAgIH1cbiAgICB9IGVsc2Uge1xuICAgICAgICB0ZW1wSGlzdG9yeUxpc3QgPSBhd2FpdCBjb21tb24ucmVhZChcIm1hcmdpblwiLCBcImhpc3RvcnlJc29sYXRlZFwiKVxuICAgICAgICBtb2R1bGVEYXRhLnRpdGxlVGV4dCA9ICRpMThuLm5fbWFyZ2luX3N5bWJvbF9saXN0XG4gICAgICAgIGZvciAobGV0IGkgPSAwOyBpIDwgY29tbW9uLmNvbW1vbkRhdGEuc3ltYm9sTGlzdC5sZW5ndGg7IGkrKykge1xuICAgICAgICAgICAgbGV0IHRlbXBEYXRhID0gY29tbW9uLmNvbW1vbkRhdGEuc3ltYm9sTGlzdFtpXVxuICAgICAgICAgICAgbGV0IGJhc2VEZWJ0ID0gYCR7TnVtYmVyKHRlbXBEYXRhW1wiYmFzZS1iYWxhbmNlXCJdKX1gXG4gICAgICAgICAgICBsZXQgcXVvdGFEZWJ0ID0gYCR7TnVtYmVyKHRlbXBEYXRhW1wicXVvdGEtYmFsYW5jZVwiXSl9YFxuICAgICAgICAgICAgbW9kdWxlRGF0YS50aXRsZURlc2MgPSAkaTE4bi5uX21hcmdpbl9hc3NldHNcbiAgICAgICAgICAgIGlmIChwYWdlVHlwZSA9PSAxKSB7XG4gICAgICAgICAgICAgICAgYmFzZURlYnQgPSBgJHtOdW1iZXIodGVtcERhdGFbXCJiYXNlLWRlYnRcIl0pfWBcbiAgICAgICAgICAgICAgICBxdW90YURlYnQgPSBgJHtOdW1iZXIodGVtcERhdGFbXCJxdW90YS1kZWJ0XCJdKX1gXG4gICAgICAgICAgICAgICAgbW9kdWxlRGF0YS50aXRsZURlc2MgPSAkaTE4bi5uX21hcmdpbl9saWFiaWxpdGllc19hbW91bnRcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIHRlbXBMaXN0LnB1c2goe1xuICAgICAgICAgICAgICAgIHR5cGU6IFwiaXNvbGF0ZWRcIixcbiAgICAgICAgICAgICAgICBpbmRleDogaS50b1N0cmluZygpLFxuICAgICAgICAgICAgICAgIGljb246IGNvbW1vbi5nZXRQTkdJY29uVVJMQnlDdXJyZW5jeSh0ZW1wRGF0YVtcImJhc2UtY3VycmVuY3lcIl0pLFxuICAgICAgICAgICAgICAgIHN5bWJvbDogdGVtcERhdGEuc3ltYm9sLFxuICAgICAgICAgICAgICAgIGRpc3BsYXlTeW1ib2w6IHRlbXBEYXRhW1wiZGlzcGxheS1zeW1ib2xcIl0sXG4gICAgICAgICAgICAgICAgY3VycmVuY3k6IHRlbXBEYXRhW1wiYmFzZS1jdXJyZW5jeVwiXSxcbiAgICAgICAgICAgICAgICBjdXJyZW5jeVRleHQ6IHRlbXBEYXRhW1wiYmFzZS1jdXJyZW5jeVwiXS50b1VwcGVyQ2FzZSgpLFxuICAgICAgICAgICAgICAgIHF1b3RhQ3VycmVuY3k6IHRlbXBEYXRhW1wicXVvdGEtY3VycmVuY3lcIl0udG9VcHBlckNhc2UoKSxcbiAgICAgICAgICAgICAgICBiYXNlRGVidDogY29tbW9uLnRob3VzYW5kc0Zvcm1hdHRlcihiYXNlRGVidCksXG4gICAgICAgICAgICAgICAgcXVvdGFEZWJ0OiBjb21tb24udGhvdXNhbmRzRm9ybWF0dGVyKHF1b3RhRGVidCksXG4gICAgICAgICAgICAgICAgYmFzZURlYnRBbW91bnQ6IGF3YWl0IGNvbW1vbi5hZGRDdXJyZW50Q3VycmVuY3lTeW1ib2woYXdhaXQgY29tbW9uLmdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudCh0ZW1wRGF0YVtcImJhc2UtY3VycmVuY3lcIl0sIGJhc2VEZWJ0KSksXG4gICAgICAgICAgICAgICAgcXVvdGFEZWJ0QW1vdW50OiBhd2FpdCBjb21tb24uYWRkQ3VycmVudEN1cnJlbmN5U3ltYm9sKGF3YWl0IGNvbW1vbi5nZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnQodGVtcERhdGFbXCJxdW90YS1jdXJyZW5jeVwiXSwgcXVvdGFEZWJ0KSlcbiAgICAgICAgICAgIH0pXG4gICAgICAgIH1cbiAgICB9XG4gICAgaWYgKHRlbXBIaXN0b3J5TGlzdCAhPSBudWxsKSB7XG4gICAgICAgIGhpc3RvcnlTZWFyY2hMaXN0ID0gdGVtcEhpc3RvcnlMaXN0XG4gICAgfSBlbHNlIHtcbiAgICAgICAgaGlzdG9yeVNlYXJjaExpc3QgPSBbXVxuICAgIH1cbiAgICBpZiAoaGlzdG9yeVNlYXJjaExpc3QgIT0gbnVsbCAmJiBoaXN0b3J5U2VhcmNoTGlzdC5sZW5ndGggPiAwKSB7XG4gICAgICAgIG1vZHVsZURhdGEuaGlzdG9yeVNlYXJjaExpc3QgPSBoaXN0b3J5U2VhcmNoTGlzdFxuICAgICAgICBtb2R1bGVEYXRhLnNob3dIaXN0b3J5ID0gXCJ2aXNpYmxlXCJcbiAgICB9IGVsc2Uge1xuICAgICAgICBtb2R1bGVEYXRhLnNob3dIaXN0b3J5ID0gXCJnb25lXCJcbiAgICB9XG4gICAgaWYgKHRlbXBMaXN0Lmxlbmd0aCA+IDApIHtcbiAgICAgICAgbW9kdWxlRGF0YS5wb3BEYXRhID0gdGVtcExpc3RcbiAgICAgICAgbW9kdWxlRGF0YS5jdXJyZW5jeUxpc3RWaXNpYmxlID0gXCJ2aXNpYmxlXCJcbiAgICAgICAgbW9kdWxlRGF0YS5jdXJyZW5jeUVtcHR5VmlzaWJsZSA9IFwiZ29uZVwiXG4gICAgfSBlbHNlIHtcbiAgICAgICAgbW9kdWxlRGF0YS5jdXJyZW5jeUxpc3RWaXNpYmxlID0gXCJnb25lXCJcbiAgICAgICAgbW9kdWxlRGF0YS5jdXJyZW5jeUVtcHR5VmlzaWJsZSA9IFwidmlzaWJsZVwiXG4gICAgfVxuICAgIG1vZHVsZURhdGEuc2hvd0N1cnJlbmN5UG9wID0gXCJ0cnVlXCJcbn1cblxuZnVuY3Rpb24gaW5pdEhpc3RvcnlTaG93KCkge1xuICAgIGlmIChoaXN0b3J5U2VhcmNoTGlzdCAhPSBudWxsICYmIGhpc3RvcnlTZWFyY2hMaXN0Lmxlbmd0aCA+IDAgJiYgbW9kdWxlRGF0YS5zZWFyY2hXb3JkLnRyaW0oKSA9PSBcIlwiKSB7XG4gICAgICAgIG1vZHVsZURhdGEuc2hvd0hpc3RvcnkgPSBcInZpc2libGVcIlxuICAgIH0gZWxzZSB7XG4gICAgICAgIG1vZHVsZURhdGEuc2hvd0hpc3RvcnkgPSBcImdvbmVcIlxuICAgIH1cbn1cblxubW9kdWxlRXZlbnQuY2xpY2tIaXN0b3J5ID0gZnVuY3Rpb24gKHRleHQpIHtcbiAgICBtb2R1bGVEYXRhLnNlYXJjaFdvcmQgPSB0ZXh0XG4gICAgZmlsdGVyTGlzdCgpXG59XG5cbm1vZHVsZUV2ZW50LmNsZWFySGlzdG9yeSA9IGZ1bmN0aW9uICgpIHtcbiAgICBpZiAoY3VycmVudE1hcmdpblR5cGUgPT0gMSkge1xuICAgICAgICBjb21tb24uY2xlYXIoXCJtYXJnaW5cIiwgXCJoaXN0b3J5Q3Jvc3NcIilcbiAgICB9IGVsc2Uge1xuICAgICAgICBjb21tb24uY2xlYXIoXCJtYXJnaW5cIiwgXCJoaXN0b3J5SXNvbGF0ZWRcIilcbiAgICB9XG4gICAgaGlzdG9yeVNlYXJjaExpc3QgPSBbXVxuICAgIG1vZHVsZURhdGEuaGlzdG9yeVNlYXJjaExpc3QgPSBbXVxuICAgIG1vZHVsZURhdGEuc2hvd0hpc3RvcnkgPSBcImdvbmVcIlxufVxuXG5tb2R1bGVFdmVudC5jdXJyZW5jeVBvcERpc21pc3MgPSBmdW5jdGlvbiAoKSB7XG4gICAgbW9kdWxlRGF0YS5zaG93Q3VycmVuY3lQb3AgPSBcImZhbHNlXCJcbn1cblxubW9kdWxlRXZlbnQuZmlsdGVyQ3VycmVuY3kgPSBmdW5jdGlvbiAoaW5kZXgpIHtcbiAgICBjb25zb2xlLmxvZyhgbWFyZ2luLWhvbWUgZmlsdGVyQ3VycmVuY3kgaW5kZXggPSAke2luZGV4fWApXG4gICAgY29uc29sZS5sb2coYG1hcmdpbi1ob21lIGZpbHRlckN1cnJlbmN5IGNhbGxCYWNrID0gJHtjYWxsQmFja31gKVxuICAgIGxldCB0ZW1wRGF0YSA9IHRlbXBMaXN0W2luZGV4XVxuICAgIGxldCBzZWFyY2hLZXkgPSBcIlwiXG4gICAgaWYgKGN1cnJlbnRNYXJnaW5UeXBlID09IDEpIHtcbiAgICAgICAgc2VhcmNoS2V5ID0gdGVtcERhdGEuY3VycmVuY3kudG9VcHBlckNhc2UoKVxuICAgIH0gZWxzZSB7XG4gICAgICAgIHNlYXJjaEtleSA9IHRlbXBEYXRhLmRpc3BsYXlTeW1ib2wudG9VcHBlckNhc2UoKVxuICAgIH1cbiAgICBpZiAoIWhpc3RvcnlTZWFyY2hMaXN0LnNvbWUoaXRlbSA9PiBpdGVtLnRleHQgPT09IHNlYXJjaEtleSkpIHtcbiAgICAgICAgaGlzdG9yeVNlYXJjaExpc3QudW5zaGlmdCh7XG4gICAgICAgICAgICB0ZXh0OiBzZWFyY2hLZXksXG4gICAgICAgICAgICB0eXBlOiBcIm5vcm1hbFwiXG4gICAgICAgIH0pXG4gICAgICAgIHdoaWxlIChoaXN0b3J5U2VhcmNoTGlzdC5sZW5ndGggPiAzKSB7XG4gICAgICAgICAgICBoaXN0b3J5U2VhcmNoTGlzdC5wb3AoKVxuICAgICAgICB9XG4gICAgICAgIGlmIChjdXJyZW50TWFyZ2luVHlwZSA9PSAxKSB7XG4gICAgICAgICAgICBjb21tb24uc2F2ZShcIm1hcmdpblwiLCBcImhpc3RvcnlDcm9zc1wiLCBoaXN0b3J5U2VhcmNoTGlzdClcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGNvbW1vbi5zYXZlKFwibWFyZ2luXCIsIFwiaGlzdG9yeUlzb2xhdGVkXCIsIGhpc3RvcnlTZWFyY2hMaXN0KVxuICAgICAgICB9XG4gICAgICAgIG1vZHVsZURhdGEuaGlzdG9yeVNlYXJjaExpc3QgPSBoaXN0b3J5U2VhcmNoTGlzdFxuICAgIH1cbiAgICBpZiAoY2FsbEJhY2sgIT0gbnVsbCkge1xuICAgICAgICBjYWxsQmFjayhjdXJyZW50TWFyZ2luVHlwZSwgdGVtcERhdGEuY3VycmVuY3ksIHRlbXBEYXRhLnN5bWJvbClcbiAgICB9XG4gICAgbW9kdWxlRGF0YS5pc0ZvY3VzID0gZmFsc2VcbiAgICBtb2R1bGVEYXRhLnNob3dDdXJyZW5jeVBvcCA9IFwiZmFsc2VcIlxufVxuXG4vLyBUZXh0VmlldyDnhKbngrlcbm1vZHVsZUV2ZW50Lm9uRm9jdXNDaGFuZ2UgPSBhc3luYyBmdW5jdGlvbiAoaXNGb2N1cykge1xuICAgIG1vZHVsZURhdGEuaXNGb2N1cyA9IGlzRm9jdXM7XG4gICAgY29uc29sZS5sb2coYHdwIG9uRm9jdXNDaGFuZ2UgaXNGb2N1cz0ke2lzRm9jdXN9YCk7XG4gICAgbW9kdWxlRGF0YS5ib3JkZXJDb2xvciA9IGN1cnJlbnRCb2FyZGVyQ29sb3IoaXNGb2N1cyk7XG4gICAgbW9kdWxlRGF0YS5jbGVhclZpc2libGUgPSBpc0ZvY3VzID8gXCJ2aXNpYmxlXCIgOlwiZ29uZVwiO1xufVxuXG5tb2R1bGVFdmVudC5vblRleHRDaGFuZ2UgPSBmdW5jdGlvbiAoKSB7XG4gICAgZmlsdGVyTGlzdCgpXG59XG5cbmZ1bmN0aW9uIGZpbHRlckxpc3QoKSB7XG4gICAgaWYgKHRlbXBMaXN0Lmxlbmd0aCA9PSAwKSByZXR1cm5cbiAgICBsZXQgc2VhcmNoS2V5ID0gbW9kdWxlRGF0YS5zZWFyY2hXb3JkLnRyaW0oKVxuICAgIGlmIChzZWFyY2hLZXkgPT0gXCJcIikge1xuICAgICAgICBtb2R1bGVEYXRhLnBvcERhdGEgPSB0ZW1wTGlzdFxuICAgIH1cbiAgICBpbml0SGlzdG9yeVNob3coKVxuICAgIG1vZHVsZURhdGEucG9wRGF0YSA9IHRlbXBMaXN0LmZpbHRlcihmdW5jdGlvbiAoaXRlbSkge1xuICAgICAgICBpZiAoY3VycmVudE1hcmdpblR5cGUgPT0gMSkge1xuICAgICAgICAgICAgcmV0dXJuIGl0ZW0uY3VycmVuY3lUZXh0LnRvTG93ZXJDYXNlKCkuaW5jbHVkZXMobW9kdWxlRGF0YS5zZWFyY2hXb3JkLnRyaW0oKS50b0xvd2VyQ2FzZSgpKVxuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgcmV0dXJuIGl0ZW0uZGlzcGxheVN5bWJvbC50b0xvd2VyQ2FzZSgpLmluY2x1ZGVzKG1vZHVsZURhdGEuc2VhcmNoV29yZC50cmltKCkudG9Mb3dlckNhc2UoKSlcbiAgICAgICAgfVxuICAgIH0pXG4gICAgaWYgKG1vZHVsZURhdGEucG9wRGF0YSA9PSBudWxsIHx8IG1vZHVsZURhdGEucG9wRGF0YS5sZW5ndGggPT0gMCkge1xuICAgICAgICBtb2R1bGVEYXRhLmN1cnJlbmN5TGlzdFZpc2libGUgPSBcImdvbmVcIlxuICAgICAgICBtb2R1bGVEYXRhLmN1cnJlbmN5RW1wdHlWaXNpYmxlID0gXCJ2aXNpYmxlXCJcbiAgICB9IGVsc2Uge1xuICAgICAgICBtb2R1bGVEYXRhLmN1cnJlbmN5TGlzdFZpc2libGUgPSBcInZpc2libGVcIlxuICAgICAgICBtb2R1bGVEYXRhLmN1cnJlbmN5RW1wdHlWaXNpYmxlID0gXCJnb25lXCJcbiAgICB9XG59XG5cbmZ1bmN0aW9uIGN1cnJlbnRCb2FyZGVyQ29sb3IoaXNGb2N1cykge1xuICAgIHJldHVybiBpc0ZvY3VzID8gRWRpdF9Cb2FyZF9TZWxlY3RDb2xvciA6IEVkaXRfQm9hcmRfTm9ybWFsQ29sb3I7XG59XG5cbi8v5riF56m65pCc57SiXG5tb2R1bGVFdmVudC5jbGlja2VkQ2xlYXIgPSBmdW5jdGlvbiAoKSB7XG4gICAgbW9kdWxlRGF0YS5zZWFyY2hXb3JkID0gXCJcIlxuICAgIG1vZHVsZURhdGEucG9wRGF0YSA9IHRlbXBMaXN0XG4gICAgaWYgKG1vZHVsZURhdGEucG9wRGF0YSA9PSBudWxsIHx8IG1vZHVsZURhdGEucG9wRGF0YS5sZW5ndGggPT0gMCkge1xuICAgICAgICBtb2R1bGVEYXRhLmN1cnJlbmN5TGlzdFZpc2libGUgPSBcImdvbmVcIlxuICAgICAgICBtb2R1bGVEYXRhLmN1cnJlbmN5RW1wdHlWaXNpYmxlID0gXCJ2aXNpYmxlXCJcbiAgICB9IGVsc2Uge1xuICAgICAgICBtb2R1bGVEYXRhLmN1cnJlbmN5TGlzdFZpc2libGUgPSBcInZpc2libGVcIlxuICAgICAgICBtb2R1bGVEYXRhLmN1cnJlbmN5RW1wdHlWaXNpYmxlID0gXCJnb25lXCJcbiAgICB9XG4gICAgaW5pdEhpc3RvcnlTaG93KClcbn0iLCJpbXBvcnQgKiBhcyBjb21tb24gZnJvbSBcIi4vY29tbW9uXCI7XG5pbXBvcnQgKiBhcyBjb21tb25Qb3AgZnJvbSBcIi4vY29tbW9uUG9wXCI7XG5pbXBvcnQgKiBhcyBudW1iZXIgZnJvbSBcIi4vbnVtYmVyXCI7XG5pbXBvcnQgKiBhcyBzZWxlY3RDdXJyZW5jeVBvcCBmcm9tIFwiLi9zZWxlY3RDdXJyZW5jeVBvcFwiO1xuaW1wb3J0IEJpZyBmcm9tICdiaWcuanMnO1xudmFyIHRpdGxlQ29sb3JfTm9ybWFsID0gXCJAY29sb3Iva0NvbG9yVGhyZWVMZXZlbFRleHRcIjtcbnZhciB0aXRsZUNvbG9yX1NlbGVjdGVkID0gXCJAY29sb3Iva0NvbG9yUHJpbWFyeVRleHRcIjtcbnZhciBtYXJnaW5TZWxlY3RCdG5CZyA9IFwiQGNvbG9yL0tCYXNlQ29sb3JDb250ZW50QmFja2dyb3VuZFwiO1xudmFyIG1hcmdpblVuc2VsZWN0QnRuQmcgPSBcIiMwMDAwMDAwMFwiO1xuXG5jb25zdCBDUk9TU19NQVJHSU5fTEFEREVSX0xFTkRJTkcgPSBcImxhZGRlci1sZW5kaW5nL2g1L2Nyb3NzLW1hcmdpbi8/bmFtZT1cIjtcbmNvbnN0IE1BUkdJTl9MQURERVJfTEVORElORyA9IFwibGFkZGVyLWxlbmRpbmcvaDUvbWFyZ2luLz9uYW1lPVwiO1xuXG4vLyDlhajku5PmlbDmja5cbnZhciBtYXJnaW5Dcm9zcyA9IHt9XG4vLyDpgJDku5PmlbDmja5cbnZhciBtYXJnaW5Jc29sYXRlZCA9IHt9XG5cbi8vIOWFqOS7k+W4geenjeaVsOaNrlxudmFyIHN1cGVyTWFyZ2luQ3VycmVuY3kgPSB7fVxuLy8g6YCQ5LuT5biB5a+55pWw5o2uXG52YXIgbWFyZ2luU3ltYm9sID0ge31cblxudmFyIHRlbXBQYWdlRGF0YSA9IFt7dHlwZTogXCJub3JtYWxcIn0se3R5cGU6IFwibm9ybWFsXCJ9XVxuXG52YXIgZmlyc3RJbml0ID0gdHJ1ZVxudmFyIGZpcnN0U2hvd1BvcCA9IHRydWVcblxuZnVuY3Rpb24gZGVmYXVsdERhdGEoKSB7XG4gICAgcmV0dXJuIHtcbiAgICAgICAgc3RhdHVzQmFyQ29uZmlnOiB7IFwic3RhdHVzQmFyTW9kZVwiOiBcInRydWVcIiwgXCJhZFN0YXR1c0JhckNvbG9yXCI6XCJLQmFzZUNvbG9yQ29udGVudEJhY2tncm91bmRcIiB9LFxuICAgICAgICB0aXRsZURhdGE6IFt7IHR5cGU6IFwibm9ybWFsXCIsIHRpdGxlOiAkaTE4bi5uX21hcmdpbl9sb2FuLCB0aXRsZUNvbG9yOiB0aXRsZUNvbG9yX1NlbGVjdGVkLCB0YWc6IDAgfSx7IHR5cGU6IFwibm9ybWFsXCIsIHRpdGxlOiAkaTE4bi5uX21hcmdpbl9yZXBheSwgdGl0bGVDb2xvcjogdGl0bGVDb2xvcl9Ob3JtYWwsIHRhZzogMSB9XSxcbiAgICAgICAgY3VycmVudFRhZzogXCIxXCIsXG4gICAgICAgIGN1cnJlbnRJbmRleDogXCIwXCIsXG4gICAgICAgIHBhZ2VUeXBlOiAxLCAvLyAx5YCf77yMMui/mFxuICAgICAgICBzeW1ib2w6IFwiXCIsXG4gICAgICAgIGN1cnJlbmN5OiBcIlwiLFxuICAgICAgICBpc0xvYW5CdG5SaWdodDogZmFsc2UsXG4gICAgICAgIGxvYW5NYXJnaW5UeXBlOiAxLFxuICAgICAgICBsb2FuSXNvbGF0ZWRUeXBlOiAxLFxuICAgICAgICBsb2FuQ3Jvc3NDaGVja0J0bkJnOiBtYXJnaW5TZWxlY3RCdG5CZyxcbiAgICAgICAgbG9hbkNyb3NzQ2hlY2tCdG5UZXh0Q29sb3I6IHRpdGxlQ29sb3JfU2VsZWN0ZWQsXG4gICAgICAgIGxvYW5Jc29sYXRlZENoZWNrQnRuQmc6IG1hcmdpblVuc2VsZWN0QnRuQmcsXG4gICAgICAgIGxvYW5Jc29sYXRlZENoZWNrQnRuVGV4dENvbG9yOiB0aXRsZUNvbG9yX05vcm1hbCxcbiAgICAgICAgbG9hbkJhc2VCdG5CZ0NvbG9yOiBcIkBjb2xvci9rQ29sb3JNYWpvclRoZW1lMDA2XCIsXG4gICAgICAgIGxvYW5CYXNlQm9yZGVyQ29sb3I6IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIixcbiAgICAgICAgbG9hblF1b3RhQnRuQmdDb2xvcjogXCJAY29sb3Iva0NvbG9ySW5wdXRGaWxsXCIsXG4gICAgICAgIGxvYW5RdW90YUJvcmRlckNvbG9yOiBcIkBjb2xvci9rQ29sb3JJbnB1dEZpbGxcIixcbiAgICAgICAgbG9hbkNvbmZpcm1CdG5CZzogXCJAY29sb3IvZUNvbG9ySW5wdXRGaWxsRGlzYWJsZWRcIixcbiAgICAgICAgbG9hbkNvbmZpcm1CdG5UZXh0Q29sb3I6IFwiQGNvbG9yL2tDb2xvclRocmVlTGV2ZWxUZXh0XCIsXG4gICAgICAgIGxvYW5FZGl0Qm9yZGVyQ29sb3I6IFwiQGNvbG9yL2tDb2xvcklucHV0RmlsbFwiLFxuICAgICAgICBsb2FuRWRpdFRleHQ6IFwiXCIsXG4gICAgICAgIGxvYW5FcnJvclZpc2libGU6IFwiZ29uZVwiLFxuICAgICAgICBpc0xvYW5FZGl0Rm9jdXM6IGZhbHNlLFxuICAgICAgICBpc1JlcGF5QnRuUmlnaHQ6IGZhbHNlLFxuICAgICAgICByZXBheU1hcmdpblR5cGU6IDEsXG4gICAgICAgIHJlcGF5SXNvbGF0ZWRUeXBlOiAxLFxuICAgICAgICByZXBheUNyb3NzQ2hlY2tCdG5CZzogbWFyZ2luU2VsZWN0QnRuQmcsXG4gICAgICAgIHJlcGF5Q3Jvc3NDaGVja0J0blRleHRDb2xvcjogdGl0bGVDb2xvcl9TZWxlY3RlZCxcbiAgICAgICAgcmVwYXlJc29sYXRlZENoZWNrQnRuQmc6IG1hcmdpblVuc2VsZWN0QnRuQmcsXG4gICAgICAgIHJlcGF5SXNvbGF0ZWRDaGVja0J0blRleHRDb2xvcjogdGl0bGVDb2xvcl9Ob3JtYWwsXG4gICAgICAgIHJlcGF5QmFzZUJ0bkJnQ29sb3I6IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUwMDZcIixcbiAgICAgICAgcmVwYXlCYXNlQm9yZGVyQ29sb3I6IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIixcbiAgICAgICAgcmVwYXlRdW90YUJ0bkJnQ29sb3I6IFwiQGNvbG9yL2tDb2xvcklucHV0RmlsbFwiLFxuICAgICAgICByZXBheVF1b3RhQm9yZGVyQ29sb3I6IFwiQGNvbG9yL2tDb2xvcklucHV0RmlsbFwiLFxuICAgICAgICByZXBheUNvbmZpcm1CdG5CZzogXCJAY29sb3IvZUNvbG9ySW5wdXRGaWxsRGlzYWJsZWRcIixcbiAgICAgICAgcmVwYXlDb25maXJtQnRuVGV4dENvbG9yOiBcIkBjb2xvci9rQ29sb3JUaHJlZUxldmVsVGV4dFwiLFxuICAgICAgICByZXBheUVkaXRCb3JkZXJDb2xvcjogXCJAY29sb3Iva0NvbG9ySW5wdXRGaWxsXCIsXG4gICAgICAgIHJlcGF5RWRpdFRleHQ6IFwiXCIsXG4gICAgICAgIHJlcGF5RXJyb3JWaXNpYmxlOiBcImdvbmVcIixcbiAgICAgICAgaXNSZXBheUVkaXRGb2N1czogZmFsc2UsXG4gICAgICAgIHBhZ2VEYXRhOiBbXVxuICAgIH07XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzdGFydCgpIHtcblxufVxuXG5jb25zdCB7IG1vZHVsZURhdGEsIG1vZHVsZUV2ZW50IH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFxuICAgIFwiaG9tZVwiLFxuICAgIHN0YXJ0LFxuICAgIGRlZmF1bHREYXRhXG4pO1xuXG5tb2R1bGVFdmVudC5vbkNyZWF0ZSA9IGFzeW5jIGZ1bmN0aW9uIChldmVudFBhcmFtcykge1xuICAgIGluaXRBbGxEYXRhKClcbiAgICBjb25zdCBwYXJhbXMgPSBKU09OLnBhcnNlKGV2ZW50UGFyYW1zKTtcbiAgICBjb25zb2xlLmxvZyhcIm1hcmdpbi1ob21lIC0gb25DcmVhdGU6JW9cIiwgZXZlbnRQYXJhbXMpO1xuICAgIHRyeSB7XG4gICAgICAgIG1vZHVsZURhdGEucGFnZVR5cGUgPSBwYXJhbXMudHlwZVxuICAgICAgICBpZiAocGFyYW1zLnR5cGUgPT0gMSkge1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5sb2FuTWFyZ2luVHlwZSA9IHBhcnNlSW50KHBhcmFtcy5tYXJnaW5UeXBlKVxuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5yZXBheU1hcmdpblR5cGUgPSBwYXJzZUludChwYXJhbXMubWFyZ2luVHlwZSlcbiAgICAgICAgfVxuICAgICAgICBtb2R1bGVEYXRhLnN5bWJvbCA9IHBhcmFtcy5zeW1ib2xcbiAgICAgICAgbW9kdWxlRGF0YS5jdXJyZW5jeSA9IHBhcmFtcy5jdXJyZW5jeVxuICAgICAgICBtYXJnaW5TeW1ib2wgPSBwYXJhbXMuc3ltYm9sXG4gICAgICAgIHN1cGVyTWFyZ2luQ3VycmVuY3kgPSBwYXJhbXMuY3VycmVuY3lcbiAgICAgICAgbW9kdWxlRGF0YS5jdXJyZW50SW5kZXggPSBwYXJzZUludChwYXJhbXMudHlwZSkgLSAxO1xuICAgICAgICAvLyDlvILmraXor7fmsYJBY2NvdW50SWRcbiAgICAgICAgY29tbW9uLmdldEFjY291bnRJZCgpXG4gICAgICAgIHJlc2V0U2VsZWN0VGFiVmlldyhwYXJzZUludChwYXJhbXMudHlwZSkgLSAxKTtcbiAgICAgICAgaW5pdERhdGEoKTtcbiAgICB9IGNhdGNoKGUpIHtcbiAgICAgICAgY29uc29sZS5sb2coYG1hcmdpbi1ob21lIC0gb25DcmVhdGUgZXJyb3I9JHtlfWApXG4gICAgfVxufVxuXG5tb2R1bGVFdmVudC5vblJlc3VtZSA9IGFzeW5jIGZ1bmN0aW9uICgpIHtcbiAgICBpZiAoZmlyc3RJbml0KSB7XG4gICAgICAgIGZpcnN0SW5pdCA9IGZhbHNlXG4gICAgfSBlbHNlIHtcbiAgICAgICAgaW5pdERhdGEoKVxuICAgIH1cbiAgICBjb25zb2xlLmxvZyhgbWFyZ2luLWhvbWUgLSBvblJlc3VtZWApXG59XG5cbm1vZHVsZUV2ZW50Lm9uU3RhcnQgPSBhc3luYyBmdW5jdGlvbiAoKSB7fVxuXG5tb2R1bGVFdmVudC5vblBhdXNlID0gYXN5bmMgZnVuY3Rpb24gKCkge31cblxubW9kdWxlRXZlbnQub25TdG9wID0gYXN5bmMgZnVuY3Rpb24gKCkge31cblxubW9kdWxlRXZlbnQub25EZXN0cm95ID0gYXN5bmMgZnVuY3Rpb24gKCkge31cblxuZnVuY3Rpb24gaW5pdEFsbERhdGEoKSB7XG4gICAgZmlyc3RJbml0ID0gdHJ1ZVxuICAgIGZpcnN0U2hvd1BvcCA9IHRydWVcbiAgICBsZXQgdGlwc1RleHQgPSAkaTE4bi5uX21hcmdpbl9zdXBlcl9tYXJnaW5fbG9hbl90aXBfbmV3XG4gICAgbGV0IGNsaWNrVGV4dCA9ICRpMThuLm5fbWFyZ2luX3N1cGVyX21hcmdpbl9sb2FuX3J1bGVzXG4gICAgbGV0IG5ld1RpcHNUZXh0ID0gdGlwc1RleHQucmVwbGFjZShjbGlja1RleHQsIGA8YSBocmVmPVwiQGV2ZW50LmhvbWUuanVtcFRpcHMoKVwiPiR7Y2xpY2tUZXh0fTwvYT5gKVxuICAgIGxldCBjb2xvciA9IGNvbW1vbi5jb21tb25EYXRhLmNvbG9yTW9kZSA/IFwiI0U2RTZFNlwiIDogXCIjMDAwMDAwXCJcbiAgICBtb2R1bGVEYXRhLnRpcHNUZXh0ID0gYDxzcGFuIHN0eWxlPVwiY29sb3I6JHtjb2xvcn07Zm9udC1zaXplOjEycHg7XCI+JHtuZXdUaXBzVGV4dH08L3NwYW4+YFxuICAgIG1vZHVsZURhdGEudGl0bGVEYXRhID0gW3sgdHlwZTogXCJub3JtYWxcIiwgdGl0bGU6ICRpMThuLm5fbWFyZ2luX2xvYW4sIHRpdGxlQ29sb3I6IHRpdGxlQ29sb3JfU2VsZWN0ZWQsIHRhZzogMCB9LHsgdHlwZTogXCJub3JtYWxcIiwgdGl0bGU6ICRpMThuLm5fbWFyZ2luX3JlcGF5LCB0aXRsZUNvbG9yOiB0aXRsZUNvbG9yX05vcm1hbCwgdGFnOiAxIH1dXG4gICAgbW9kdWxlRGF0YS5jdXJyZW50VGFnID0gXCIxXCJcbiAgICBtb2R1bGVEYXRhLmN1cnJlbnRJbmRleCA9IDBcbiAgICBtb2R1bGVEYXRhLnBhZ2VUeXBlID0gMSwgLy8gMeWAn++8jDJcbiAgICBtb2R1bGVEYXRhLm1hcmdpblR5cGUgPSAxLCAvLyAx5YWo5LuT77yMIDLpgJBcbiAgICBtb2R1bGVEYXRhLnN5bWJvbCA9IFwiXCJcbiAgICBtb2R1bGVEYXRhLmN1cnJlbmN5ID0gXCJcIlxuICAgIG1vZHVsZURhdGEuaXNMb2FuQnRuUmlnaHQgPSBmYWxzZVxuICAgIG1vZHVsZURhdGEubG9hbk1hcmdpblR5cGUgPSAxXG4gICAgbW9kdWxlRGF0YS5sb2FuSXNvbGF0ZWRUeXBlID0gMVxuICAgIG1vZHVsZURhdGEubG9hbkNyb3NzQ2hlY2tCdG5CZyA9IG1hcmdpblNlbGVjdEJ0bkJnXG4gICAgbW9kdWxlRGF0YS5sb2FuQ3Jvc3NDaGVja0J0blRleHRDb2xvciA9IHRpdGxlQ29sb3JfU2VsZWN0ZWRcbiAgICBtb2R1bGVEYXRhLmxvYW5Jc29sYXRlZENoZWNrQnRuQmcgPSBtYXJnaW5VbnNlbGVjdEJ0bkJnXG4gICAgbW9kdWxlRGF0YS5sb2FuSXNvbGF0ZWRDaGVja0J0blRleHRDb2xvciA9IHRpdGxlQ29sb3JfTm9ybWFsXG4gICAgbW9kdWxlRGF0YS5sb2FuQmFzZUJ0bkJnQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JNYWpvclRoZW1lMDA2XCJcbiAgICBtb2R1bGVEYXRhLmxvYW5CYXNlQm9yZGVyQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JNYWpvclRoZW1lMTAwXCJcbiAgICBtb2R1bGVEYXRhLmxvYW5RdW90YUJ0bkJnQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JJbnB1dEZpbGxcIlxuICAgIG1vZHVsZURhdGEubG9hblF1b3RhQm9yZGVyQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JJbnB1dEZpbGxcIlxuICAgIG1vZHVsZURhdGEubG9hbkNvbmZpcm1CdG5CZyA9IFwiQGNvbG9yL2VDb2xvcklucHV0RmlsbERpc2FibGVkXCJcbiAgICBtb2R1bGVEYXRhLmxvYW5Db25maXJtQnRuVGV4dENvbG9yID0gXCJAY29sb3Iva0NvbG9yVGhyZWVMZXZlbFRleHRcIlxuICAgIG1vZHVsZURhdGEubG9hbkVkaXRCb3JkZXJDb2xvciA9IFwiQGNvbG9yL2tDb2xvcklucHV0RmlsbFwiXG4gICAgbW9kdWxlRGF0YS5sb2FuRWRpdFRleHQgPSBcIlwiXG4gICAgbW9kdWxlRGF0YS5sb2FuRXJyb3JWaXNpYmxlID0gXCJnb25lXCJcbiAgICBtb2R1bGVEYXRhLmxvYW5FZGl0VGV4dCA9IFwiXCJcbiAgICBtb2R1bGVEYXRhLmlzTG9hbkVkaXRGb2N1cyA9IGZhbHNlXG4gICAgbW9kdWxlRGF0YS5pc1JlcGF5QnRuUmlnaHQgPSBmYWxzZVxuICAgIG1vZHVsZURhdGEucmVwYXlNYXJnaW5UeXBlID0gMVxuICAgIG1vZHVsZURhdGEucmVwYXlJc29sYXRlZFR5cGUgPSAxXG4gICAgbW9kdWxlRGF0YS5yZXBheUNyb3NzQ2hlY2tCdG5CZyA9IG1hcmdpblNlbGVjdEJ0bkJnXG4gICAgbW9kdWxlRGF0YS5yZXBheUNyb3NzQ2hlY2tCdG5UZXh0Q29sb3IgPSB0aXRsZUNvbG9yX1NlbGVjdGVkXG4gICAgbW9kdWxlRGF0YS5yZXBheUlzb2xhdGVkQ2hlY2tCdG5CZyA9IG1hcmdpblVuc2VsZWN0QnRuQmdcbiAgICBtb2R1bGVEYXRhLnJlcGF5SXNvbGF0ZWRDaGVja0J0blRleHRDb2xvciA9IHRpdGxlQ29sb3JfTm9ybWFsXG4gICAgbW9kdWxlRGF0YS5yZXBheUJhc2VCdG5CZ0NvbG9yID0gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTAwNlwiXG4gICAgbW9kdWxlRGF0YS5yZXBheUJhc2VCb3JkZXJDb2xvciA9IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIlxuICAgIG1vZHVsZURhdGEucmVwYXlRdW90YUJ0bkJnQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JJbnB1dEZpbGxcIlxuICAgIG1vZHVsZURhdGEucmVwYXlRdW90YUJvcmRlckNvbG9yID0gXCJAY29sb3Iva0NvbG9ySW5wdXRGaWxsXCJcbiAgICBtb2R1bGVEYXRhLnJlcGF5Q29uZmlybUJ0bkJnID0gXCJAY29sb3IvZUNvbG9ySW5wdXRGaWxsRGlzYWJsZWRcIlxuICAgIG1vZHVsZURhdGEucmVwYXlDb25maXJtQnRuVGV4dENvbG9yID0gXCJAY29sb3Iva0NvbG9yVGhyZWVMZXZlbFRleHRcIlxuICAgIG1vZHVsZURhdGEucmVwYXlFZGl0Qm9yZGVyQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JJbnB1dEZpbGxcIlxuICAgIG1vZHVsZURhdGEucmVwYXlFZGl0VGV4dCA9IFwiXCJcbiAgICBtb2R1bGVEYXRhLnJlcGF5RXJyb3JWaXNpYmxlID0gXCJnb25lXCJcbiAgICBtb2R1bGVEYXRhLnJlcGF5RWRpdFRleHQgPSBcIlwiXG4gICAgbW9kdWxlRGF0YS5pc1JlcGF5RWRpdEZvY3VzID0gZmFsc2VcbiAgICBtb2R1bGVEYXRhLnBhZ2VEYXRhID0gW11cbn1cblxuYXN5bmMgZnVuY3Rpb24gaW5pdERhdGEoKSB7XG4gICAgY29uc29sZS5sb2coYG1hcmdpbi1ob21lIC0gaW5pdERhdGFgKTtcbiAgICBpZihtb2R1bGVEYXRhLmN1cnJlbnRJbmRleCA9PSAwKSB7Ly/lgJ/mrL5cbiAgICAgICAgcmVzZXRMb2FuTWFyZ2luVGl0bGUobW9kdWxlRGF0YS5sb2FuTWFyZ2luVHlwZSk7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgcmVzZXRSZXBheU1hcmdpblRpdGxlKG1vZHVsZURhdGEucmVwYXlNYXJnaW5UeXBlKTtcbiAgICB9XG4gICAgYXdhaXQgcmVxdWVzdERhdGEoKTtcbiAgICBpZiAobW9kdWxlRGF0YS5jdXJyZW50SW5kZXggPT0gMCAmJiBmaXJzdFNob3dQb3ApIHtcbiAgICAgICAgaWYgKG1vZHVsZURhdGEubG9hbk1hcmdpblR5cGUgPT0gMSkge1xuICAgICAgICAgICAgaWYgKG1hcmdpbkNyb3NzW1wic3lzLWxvYW4tYW1vdW50XCJdIDw9IDApIHtcbiAgICAgICAgICAgICAgICBjb21tb25Qb3AucG9wVXBDb250ZW50T2ZPbmVCdXR0b24oJGkxOG4ubl9jb3B5X3RyYWRpbmdfdGlwLCAkaTE4bi4kaW50ZXJjZXB0Lm5fbWFyZ2luX3VuYWJsZV90b19sb2FuKG1hcmdpbkNyb3NzW1wiY3VycmVuY3lcIl0udG9VcHBlckNhc2UoKSksIG51bGwpXG4gICAgICAgICAgICB9IGVsc2UgaWYgKG1hcmdpbkNyb3NzW1wibWF4LWxvYW4tYW1vdW50XCJdIDw9IDApIHtcbiAgICAgICAgICAgICAgICBjb21tb25Qb3AucG9wVXBDb250ZW50T2ZUd29CdXR0b24oLTEsICRpMThuLm5fY29weV90cmFkaW5nX3RpcCwgJGkxOG4uJGludGVyY2VwdC5uX21hcmdpbl9zdXBlcl9saW1pdF90aXBzKFwiMFwiKSwgJGkxOG4ubl9jYW5jZWwsICRpMThuLm5fdHJhZGVfYWxlcnRfZ29fdHJhbnNmZXIsIFwiZ29uZVwiLCBudWxsLCB0cmFuc2ZlcilcbiAgICAgICAgICAgIH1cbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGNoYW5nZUlzb2xhdGVkTG9hbigpXG4gICAgICAgIH1cbiAgICAgICAgZmlyc3RTaG93UG9wID0gZmFsc2VcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlcXVlc3REYXRhKCkge1xuICAgIGNvbW1vbi5zaG93TG9hZGluZyh0cnVlKVxuICAgIGF3YWl0IGNoYW5nZUxpc3RUeXBlKG1vZHVsZURhdGEuY3VycmVudEluZGV4KVxuICAgIGdldFN1cGVyTWFyZ2luQ3VycmVuY3koKTtcbiAgICBnZXRNYXJnaW5TeW1ib2woKTtcbiAgICBhd2FpdCByZXF1ZXN0RGV0YWlsKCk7XG4gICAgY29tbW9uLnNob3dMb2FkaW5nKGZhbHNlKVxufVxuXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0RGV0YWlsKCkge1xuICAgIGNvbnNvbGUubG9nKGBtYXJnaW4taG9tZSByZXF1ZXN0RGV0YWlsIGN1cnJlbnRJbmRleCA9ICR7bW9kdWxlRGF0YS5jdXJyZW50SW5kZXh9IGxvYW5NYXJnaW5UeXBlID0gJHttb2R1bGVEYXRhLmxvYW5NYXJnaW5UeXBlfSByZXBheU1hcmdpblR5cGUgPSAke21vZHVsZURhdGEucmVwYXlNYXJnaW5UeXBlfWApXG4gICAgaWYobW9kdWxlRGF0YS5jdXJyZW50SW5kZXggPT0gMCkgey8v5YCf5qy+XG4gICAgICAgIGxldCBkZXRhaWwgPSB7fTtcbiAgICAgICAgaWYobW9kdWxlRGF0YS5sb2FuTWFyZ2luVHlwZSA9PSAxKSB7Ly/lhajku5NcbiAgICAgICAgICAgIGRldGFpbCA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdChcInYxL2hiZy9zdXBlci1tYXJnaW4vY3VycmVuY3ktZGV0YWlsXCIsIHt0eXBlOiAxLCBjdXJyZW5jeTogc3VwZXJNYXJnaW5DdXJyZW5jeX0sIDAsIDQpO1xuICAgICAgICAgICAgbWFyZ2luQ3Jvc3MgPSBkZXRhaWw7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBkZXRhaWwgPSBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3QoXCJ2MS9oYmcvbWFyZ2luL3N5bWJvbC1kZXRhaWxcIiwge3R5cGU6IDEsIHN5bWJvbDogbWFyZ2luU3ltYm9sfSwgMCwgNCk7XG4gICAgICAgICAgICBtYXJnaW5Jc29sYXRlZCA9IGRldGFpbDtcbiAgICAgICAgfVxuICAgICAgICBjb25zb2xlLmxvZyhgbWFyZ2luLWhvbWUgcmVxdWVzdERldGFpbCBsb2FuRGV0YWlsID0gJHtKU09OLnN0cmluZ2lmeShkZXRhaWwpfWApXG4gICAgICAgIGNvbW1vbi51cGxvYWRMb2coXCJjb3B5VHJhZGluZyByZXF1ZXN0RGV0YWlsIGxvYW5EZXRhaWwgPSBcIiwgYCR7SlNPTi5zdHJpbmdpZnkoZGV0YWlsKX1gKVxuICAgICAgICBhd2FpdCB1cGRhdGVMb2FuQ2hhbmdlRGF0YSgpO1xuICAgIH0gZWxzZSB7Ly/ov5jmrL5cbiAgICAgICAgbGV0IGRldGFpbCA9IHt9O1xuICAgICAgICBpZihtb2R1bGVEYXRhLnJlcGF5TWFyZ2luVHlwZSA9PSAxKXsvL+WFqOS7k1xuICAgICAgICAgICAgZGV0YWlsID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KFwidjEvaGJnL3N1cGVyLW1hcmdpbi9jdXJyZW5jeS1kZXRhaWxcIiwge3R5cGU6IDIsY3VycmVuY3k6IHN1cGVyTWFyZ2luQ3VycmVuY3l9LCAwLCA0KTtcbiAgICAgICAgICAgIG1hcmdpbkNyb3NzID0gZGV0YWlsO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgZGV0YWlsID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KFwidjEvaGJnL21hcmdpbi9zeW1ib2wtZGV0YWlsXCIsIHt0eXBlOiAyLCBzeW1ib2w6IG1hcmdpblN5bWJvbH0sIDAsIDQpO1xuICAgICAgICAgICAgbWFyZ2luSXNvbGF0ZWQgPSBkZXRhaWw7XG4gICAgICAgIH1cbiAgICAgICAgY29uc29sZS5sb2coYG1hcmdpbi1ob21lIHJlcXVlc3REZXRhaWwgcmVwYXlEZXRhaWwgPSAke0pTT04uc3RyaW5naWZ5KGRldGFpbCl9YClcbiAgICAgICAgY29tbW9uLnVwbG9hZExvZyhcImNvcHlUcmFkaW5nIHJlcXVlc3REZXRhaWwgcmVwYXlEZXRhaWwgPSBcIiwgYCR7SlNPTi5zdHJpbmdpZnkoZGV0YWlsKX1gKVxuICAgICAgICBhd2FpdCB1cGRhdGVSZXBheUNoYW5nZURhdGEoKTtcbiAgICB9XG59XG5cbi8qKlxuICog5YWo5LuT5biB56eNXG4gKi9cbmFzeW5jIGZ1bmN0aW9uIGdldFN1cGVyTWFyZ2luQ3VycmVuY3koKSB7XG4gICAgaWYgKCFjb21tb24uY29tbW9uRGF0YS5jdXJyZW5jeUxpc3QgfHwgY29tbW9uLmNvbW1vbkRhdGEuY3VycmVuY3lMaXN0ID09IG51bGwpIHtcbiAgICAgICAgcmV0dXJuXG4gICAgfVxuICAgIHZhciBjdXJyZW5jeURhdGEgPSBjb21tb24uY29tbW9uRGF0YS5jdXJyZW5jeUxpc3RbMF1cbiAgICBmb3IgKGxldCBpID0gMDsgaSA8IGNvbW1vbi5jb21tb25EYXRhLmN1cnJlbmN5TGlzdC5sZW5ndGg7IGkrKykge1xuICAgICAgICBsZXQgdGVtcERhdGEgPSBjb21tb24uY29tbW9uRGF0YS5jdXJyZW5jeUxpc3RbaV1cbiAgICAgICAgaWYgKGVxdWFsc0lnbm9yZUNhc2UodGVtcERhdGEuY3VycmVuY3ksIG1vZHVsZURhdGEuY3VycmVuY3kpKSB7XG4gICAgICAgICAgICBjdXJyZW5jeURhdGEgPSB0ZW1wRGF0YVxuICAgICAgICAgICAgYnJlYWtcbiAgICAgICAgfVxuICAgIH1cbiAgICBzdXBlck1hcmdpbkN1cnJlbmN5ID0gY3VycmVuY3lEYXRhLmN1cnJlbmN5O1xufVxuXG4vKipcbiAqIOmAkOS7k+W4geWvuVxuICovXG5hc3luYyBmdW5jdGlvbiBnZXRNYXJnaW5TeW1ib2woKSB7XG4gICAgaWYgKCFjb21tb24uY29tbW9uRGF0YS5zeW1ib2xMaXN0IHx8IGNvbW1vbi5jb21tb25EYXRhLnN5bWJvbExpc3QgPT0gbnVsbCkge1xuICAgICAgICByZXR1cm5cbiAgICB9XG4gICAgdmFyIHN5bWJvbERhdGEgPSBjb21tb24uY29tbW9uRGF0YS5zeW1ib2xMaXN0WzBdXG4gICAgZm9yIChsZXQgaSA9IDA7IGkgPCBjb21tb24uY29tbW9uRGF0YS5zeW1ib2xMaXN0Lmxlbmd0aDsgaSsrKSB7XG4gICAgICAgIGxldCB0ZW1wRGF0YSA9IGNvbW1vbi5jb21tb25EYXRhLnN5bWJvbExpc3RbaV1cbiAgICAgICAgaWYgKGVxdWFsc0lnbm9yZUNhc2UodGVtcERhdGEuc3ltYm9sLCBtb2R1bGVEYXRhLnN5bWJvbCkpIHtcbiAgICAgICAgICAgIHN5bWJvbERhdGEgPSB0ZW1wRGF0YVxuICAgICAgICAgICAgYnJlYWtcbiAgICAgICAgfVxuICAgIH1cbiAgICBtYXJnaW5TeW1ib2wgPSBzeW1ib2xEYXRhLnN5bWJvbDtcbn1cblxuZnVuY3Rpb24gZXF1YWxzSWdub3JlQ2FzZSh0ZXh0T25lLCB0ZXh0VHdvKSB7XG4gICAgaWYgKHRleHRPbmUgIT0gbnVsbCAmJiB0ZXh0T25lICE9IFwidW5kZWZpbmVkXCIgJiYgdGV4dFR3byAhPSBudWxsICYmIHRleHRUd28gIT0gXCJ1bmRlZmluZWRcIikge1xuICAgICAgICByZXR1cm4gdGV4dE9uZS50b1VwcGVyQ2FzZSgpID09PSB0ZXh0VHdvLnRvVXBwZXJDYXNlKClcbiAgICB9XG4gICAgcmV0dXJuIGZhbHNlXG59XG5cbi8qKlxuICog5biB5a+5L+W4geenjemAieaLqeWbnuiwg1xuICovXG5hc3luYyBmdW5jdGlvbiByZWZyZXNoQ3VycmVuY3lEYXRhKHR5cGUsIGN1cnJlbmN5LCBzeW1ib2wpIHtcbiAgICBjb25zb2xlLmxvZyhgbWFyZ2luLWhvbWUgcmVmcmVzaEN1cnJlbmN5RGF0YSB0eXBlID0gJHt0eXBlfSwgY3VycmVuY3kgPSAke2N1cnJlbmN5fSwgc3ltYm9sID0gJHtzeW1ib2x9YClcbiAgICBpZiAodHlwZSA9PSAxKSB7XG4gICAgICAgIG1vZHVsZURhdGEuY3VycmVuY3kgPSBjdXJyZW5jeVxuICAgICAgICBzdXBlck1hcmdpbkN1cnJlbmN5ID0gY3VycmVuY3lcbiAgICB9IGVsc2Uge1xuICAgICAgICBtb2R1bGVEYXRhLnN5bWJvbCA9IHN5bWJvbFxuICAgICAgICBtYXJnaW5TeW1ib2wgPSBzeW1ib2xcbiAgICB9XG4gICAgY29tbW9uLnNob3dMb2FkaW5nKHRydWUpO1xuICAgIGF3YWl0IHJlcXVlc3REZXRhaWwoKTtcbiAgICBjb21tb24uc2hvd0xvYWRpbmcoZmFsc2UpO1xuICAgIGNvbnNvbGUubG9nKGBtYXJnaW4taG9tZSByZWZyZXNoQ3VycmVuY3lEYXRhIGZ1bmN0aW9uIGVuZGApXG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlc2V0VGl0bGVTZWxlY3RUYWIoaW5kZXgpIHtcbiAgICBjb25zb2xlLmxvZyhgbWFyZ2luLWhvbWUgcmVzZXRUaXRsZVNlbGVjdFRhYiA9ICR7aW5kZXh9YCk7XG4gICAgcmVzZXRTZWxlY3RUYWJWaWV3KGluZGV4KTtcbiAgICByZXF1ZXN0RGF0YSgpO1xuICAgIGNvbnNvbGUubG9nKGBtYXJnaW4taG9tZSByZXNldFRpdGxlU2VsZWN0VGFiIGZ1bmN0aW9uIGVuZGApXG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlc2V0U2VsZWN0VGFiVmlldyhpbmRleCkge1xuICAgIHZhciBzZWxlY3RlZEl0ZW0gPSBudWxsO1xuICAgIGZvciAodmFyIGkgPSAwOyBpIDwgbW9kdWxlRGF0YS50aXRsZURhdGEubGVuZ3RoOyBpKyspIHtcbiAgICAgICAgdmFyIGl0ZW0gPSBtb2R1bGVEYXRhLnRpdGxlRGF0YVtpXTtcbiAgICAgICAgaWYgKGkgPT0gaW5kZXgpIHtcbiAgICAgICAgICAgIHNlbGVjdGVkSXRlbSA9IGl0ZW07XG4gICAgICAgIH1cbiAgICAgICAgaXRlbS50aXRsZUNvbG9yID0gdGl0bGVDb2xvcl9Ob3JtYWw7XG4gICAgfVxuXG4gICAgaWYgKHNlbGVjdGVkSXRlbSAhPSBudWxsKSB7XG4gICAgICAgIHNlbGVjdGVkSXRlbS50aXRsZUNvbG9yID0gdGl0bGVDb2xvcl9TZWxlY3RlZDtcbiAgICAgICAgc2VsZWN0ZWRJdGVtLnBvaW50VmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgIH1cbn1cblxuZnVuY3Rpb24gZml4ZWROdW0obnVtKSB7XG4gICAgbGV0IGZvcm1hdHRlZCA9IG51bS50b0ZpeGVkKDQpLnJlcGxhY2UoL1xcLj8wKyQvLCBcIlwiKVxuICAgIHJldHVybiBmb3JtYXR0ZWRcbn1cblxubW9kdWxlRXZlbnQuYmFjayA9IGFzeW5jIGZ1bmN0aW9uICgpIHtcbiAgICAkbmF0aXZlQVBJLmNvbnRhaW5lckJhY2soKTtcbn1cblxubW9kdWxlRXZlbnQuaGlzdG9yeSA9IGFzeW5jIGZ1bmN0aW9uICgpIHtcbiAgICBsZXQgbW9kZVR5cGUgPSAxXG4gICAgaWYgKChtb2R1bGVEYXRhLmN1cnJlbnRJbmRleCA9PSAwICYmIG1vZHVsZURhdGEubG9hbk1hcmdpblR5cGUgPT0gMikgfHwgKG1vZHVsZURhdGEuY3VycmVudEluZGV4ID09IDEgJiYgbW9kdWxlRGF0YS5yZXBheU1hcmdpblR5cGUgPT0gMikpIHtcbiAgICAgICAgbW9kZVR5cGUgPSAyXG4gICAgfVxuICAgIGNvbW1vbi5vcGVuVVJMKGBob2xpZ2VpdDovL29wZW4vdjE/bG9naW49MSZ1cmw9aWh1b2JpZ2xvYmFsOi8vbS5oYmcuY29tL2VkZ2VlbmdpbmUvY29udGFpbmVyP3NjZW5lPW1hcmdpbiZyb290TmFtZT1sZXZlckhpc3RvcnkmbmF2Q29uZmlnPSZ0YWJUeXBlPSR7bW9kdWxlRGF0YS5jdXJyZW50SW5kZXh9Jm1vZGVUeXBlPSR7bW9kZVR5cGV9YCk7XG59XG5cbm1vZHVsZUV2ZW50LnRhYkNsaWNrID0gYXN5bmMgZnVuY3Rpb24gKGluZGV4KSB7XG4gICAgY2xvc2VLZXlib2FyZCgpXG4gICAgbW9kdWxlRGF0YS5jdXJyZW50SW5kZXggPSBwYXJzZUludChpbmRleCk7XG4gICAgYXdhaXQgcmVzZXRUaXRsZVNlbGVjdFRhYihpbmRleCk7XG4gICAgb25Mb2FuVGV4dENoYW5nZShtb2R1bGVEYXRhLmxvYW5FZGl0VGV4dClcbiAgICBvblJlcGF5VGV4dENoYW5nZShtb2R1bGVEYXRhLnJlcGF5RWRpdFRleHQpXG4gICAgY29uc29sZS5sb2coYG1hcmdpbi1ob21lIHRhYkNsaWNrIGZ1bmN0aW9uIGVuZGApO1xufVxuXG5hc3luYyBmdW5jdGlvbiBsb2FuQ2hhbmdlVHlwZSh0eXBlLCBjdXJyZW5jeUNoYW5nZSA9IGZhbHNlKSB7XG4gICAgY29uc29sZS5sb2coYG1hcmdpbi1ob21lIGxvYW5DaGFuZ2VUeXBlIHR5cGUgPSAke3R5cGV9LCBjdXJyZW5jeUNoYW5nZSA9ICR7Y3VycmVuY3lDaGFuZ2V9YCk7XG4gICAgaWYgKG1vZHVsZURhdGEubG9hbk1hcmdpblR5cGUgIT0gdHlwZSB8fCBjdXJyZW5jeUNoYW5nZSkge1xuICAgICAgICBjbG9zZUtleWJvYXJkKClcbiAgICAgICAgbW9kdWxlRGF0YS5sb2FuTWFyZ2luVHlwZSA9IHR5cGVcbiAgICAgICAgbW9kdWxlRGF0YS5sb2FuRWRpdFRleHQgPSBcIlwiXG4gICAgICAgIHJlc2V0TG9hbk1hcmdpblRpdGxlKHR5cGUpO1xuICAgICAgICBhd2FpdCByZXF1ZXN0RGV0YWlsKCk7XG4gICAgfVxuICAgIG9uTG9hblRleHRDaGFuZ2UobW9kdWxlRGF0YS5sb2FuRWRpdFRleHQpXG4gICAgY29uc29sZS5sb2coYG1hcmdpbi1ob21lIGxvYW5DaGFuZ2VUeXBlIGZ1bmN0aW9uIGVuZGApO1xufVxuXG5mdW5jdGlvbiByZXNldExvYW5NYXJnaW5UaXRsZSAodHlwZSkge1xuICAgIGlmICh0eXBlID09IDEpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5sb2FuQ3Jvc3NDaGVja0J0bkJnID0gbWFyZ2luU2VsZWN0QnRuQmdcbiAgICAgICAgbW9kdWxlRGF0YS5sb2FuQ3Jvc3NDaGVja0J0blRleHRDb2xvciA9IHRpdGxlQ29sb3JfU2VsZWN0ZWRcbiAgICAgICAgbW9kdWxlRGF0YS5sb2FuSXNvbGF0ZWRDaGVja0J0bkJnID0gbWFyZ2luVW5zZWxlY3RCdG5CZ1xuICAgICAgICBtb2R1bGVEYXRhLmxvYW5Jc29sYXRlZENoZWNrQnRuVGV4dENvbG9yID0gdGl0bGVDb2xvcl9Ob3JtYWxcbiAgICB9IGVsc2Uge1xuICAgICAgICBtb2R1bGVEYXRhLmxvYW5Dcm9zc0NoZWNrQnRuQmcgPSBtYXJnaW5VbnNlbGVjdEJ0bkJnXG4gICAgICAgIG1vZHVsZURhdGEubG9hbkNyb3NzQ2hlY2tCdG5UZXh0Q29sb3IgPSB0aXRsZUNvbG9yX05vcm1hbFxuICAgICAgICBtb2R1bGVEYXRhLmxvYW5Jc29sYXRlZENoZWNrQnRuQmcgPSBtYXJnaW5TZWxlY3RCdG5CZ1xuICAgICAgICBtb2R1bGVEYXRhLmxvYW5Jc29sYXRlZENoZWNrQnRuVGV4dENvbG9yID0gdGl0bGVDb2xvcl9TZWxlY3RlZFxuICAgIH1cbn1cblxuYXN5bmMgZnVuY3Rpb24gY2hhbmdlU3VwZXJNYXJnaW5Mb2FuKCkge1xuICAgIGlmKG1hcmdpbkNyb3NzID09IG51bGwpIHtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICBsZXQgYWxyZWFkeUxvYW4gPSBhd2FpdCBjb21tb24udGhvdXNhbmRzRm9ybWF0dGVyKG51bWJlci5zY2llbnRpZmljVG9OdW1iZXIobWFyZ2luQ3Jvc3MubG9hbikudG9TdHJpbmcoKSlcbiAgICBsZXQgbWF4TG9hbkFtb3VudCA9IGF3YWl0IGNvbW1vbi50aG91c2FuZHNGb3JtYXR0ZXIobnVtYmVyLnNjaWVudGlmaWNUb051bWJlcihtYXJnaW5Dcm9zc1tcIm1heC1sb2FuLWFtb3VudFwiXSkudG9TdHJpbmcoKSlcblxuICAgIHRlbXBQYWdlRGF0YVswXSA9IHtcbiAgICAgICAgdHlwZTogXCJsb2FuXCIsXG4gICAgICAgIC8vIOWFqOS7k+aYvuekumljb27vvIzpgJDku5PpmpDol49cbiAgICAgICAgaWNvblZpc2libGU6IFwidmlzaWJsZVwiLFxuICAgICAgICBpY29uOiBjb21tb24uZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3kobWFyZ2luQ3Jvc3MuY3VycmVuY3kpLFxuICAgICAgICBzeW1ib2w6IG1hcmdpbkNyb3NzLmN1cnJlbmN5LnRvVXBwZXJDYXNlKCksXG4gICAgICAgIGN1cnJlbmN5OiBtYXJnaW5Dcm9zcy5jdXJyZW5jeS50b1VwcGVyQ2FzZSgpLFxuICAgICAgICAvLyDlt7LlgJ/ph5Hpop0gJiDlt7LlgJ/luIFDdXJyZW5jeVxuICAgICAgICBhbHJlYWR5TG9hbjogYCR7YWxyZWFkeUxvYW59ICR7bWFyZ2luQ3Jvc3MuY3VycmVuY3kudG9VcHBlckNhc2UoKX1gLFxuICAgICAgICAvLyDluIHmga/njodcbiAgICAgICAgaW50ZXJlc3RSYXRlOiBgJHtmaXhlZE51bShtYXJnaW5Dcm9zc1tcImludGVyZXN0LXJhdGVcIl0gKiAxMDApfSVgLFxuICAgICAgICAvLyDmnIDlpKflj6/lgJ/mlbDph49cbiAgICAgICAgbWF4TG9hbkxpbWl0OiBgJHttYXhMb2FuQW1vdW50fSAke21hcmdpbkNyb3NzLmN1cnJlbmN5LnRvVXBwZXJDYXNlKCl9YCxcbiAgICAgICAgLy8gZWRpdCBoaW50XG4gICAgICAgIGVkaXRIaW50OiAkaTE4bi4kaW50ZXJjZXB0Lm5fbWFyZ2luX21pbmltdW0oYCAke251bWJlci5zY2llbnRpZmljVG9OdW1iZXIobWFyZ2luQ3Jvc3NbXCJtaW4tbG9hbi1saW1pdFwiXSkudG9TdHJpbmcoKX1gKSxcbiAgICAgICAgbWF4TG9hbkFtb3VudDogYCR7bWF4TG9hbkFtb3VudH0gJHttYXJnaW5Dcm9zcy5jdXJyZW5jeS50b1VwcGVyQ2FzZSgpfWAsXG4gICAgfVxuICAgIG1vZHVsZURhdGEucGFnZURhdGEgPSB0ZW1wUGFnZURhdGFcbiAgICBjb25zb2xlLmxvZyhgbWFyZ2luLWhvbWUgbG9hbkNoYW5nZVR5cGUgdGVtcFBhZ2VEYXRhWzBdID0gJHtKU09OLnN0cmluZ2lmeSh0ZW1wUGFnZURhdGFbMF0pfWApXG59XG5cbmFzeW5jIGZ1bmN0aW9uIHVwZGF0ZUxvYW5DaGFuZ2VEYXRhICgpIHtcbiAgICBpZiAobW9kdWxlRGF0YS5sb2FuTWFyZ2luVHlwZSA9PSAxKSB7XG4gICAgICAgIGNoYW5nZVN1cGVyTWFyZ2luTG9hbigpXG4gICAgfSBlbHNlIHtcbiAgICAgICAgY2hhbmdlSXNvbGF0ZWRMb2FuKClcbiAgICB9XG59XG5hc3luYyBmdW5jdGlvbiB1cGRhdGVSZXBheUNoYW5nZURhdGEgKCkge1xuICAgIGlmIChtb2R1bGVEYXRhLnJlcGF5TWFyZ2luVHlwZSA9PSAxKSB7XG4gICAgICAgIGNoYW5nZVN1cGVyTWFyZ2luUmVwYXkoKVxuICAgIH0gZWxzZSB7XG4gICAgICAgIGNoYW5nZUlzb2xhdGVkUmVwYXkoKVxuICAgIH1cbn1cblxubW9kdWxlRXZlbnQubG9hbkNoYW5nZVR5cGUgPSBsb2FuQ2hhbmdlVHlwZVxuXG5tb2R1bGVFdmVudC5jaGFuZ2VMb2FuSXNvbGF0ZWRUeXBlID0gYXN5bmMgZnVuY3Rpb24gKHR5cGUpIHtcbiAgICBjb25zb2xlLmxvZyhgbWFyZ2luLWhvbWUgY2hhbmdlTG9hbklzb2xhdGVkVHlwZSB0eXBlID0gJHt0eXBlfWApO1xuICAgIGlmIChtb2R1bGVEYXRhLmxvYW5Jc29sYXRlZFR5cGUgIT0gdHlwZSkge1xuICAgICAgICBjbG9zZUtleWJvYXJkKClcbiAgICAgICAgbW9kdWxlRGF0YS5sb2FuSXNvbGF0ZWRUeXBlID0gdHlwZVxuICAgICAgICBtb2R1bGVEYXRhLmxvYW5FZGl0VGV4dCA9IFwiXCJcbiAgICAgICAgaWYgKHR5cGUgPT0gMSkge1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5sb2FuQmFzZUJ0bkJnQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JNYWpvclRoZW1lMDA2XCJcbiAgICAgICAgICAgIG1vZHVsZURhdGEubG9hbkJhc2VCb3JkZXJDb2xvciA9IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIlxuICAgICAgICAgICAgbW9kdWxlRGF0YS5sb2FuUXVvdGFCdG5CZ0NvbG9yID0gXCJAY29sb3Iva0NvbG9ySW5wdXRGaWxsXCJcbiAgICAgICAgICAgIG1vZHVsZURhdGEubG9hblF1b3RhQm9yZGVyQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JJbnB1dEZpbGxcIlxuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5sb2FuQmFzZUJ0bkJnQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JJbnB1dEZpbGxcIlxuICAgICAgICAgICAgbW9kdWxlRGF0YS5sb2FuQmFzZUJvcmRlckNvbG9yID0gXCJAY29sb3Iva0NvbG9ySW5wdXRGaWxsXCJcbiAgICAgICAgICAgIG1vZHVsZURhdGEubG9hblF1b3RhQnRuQmdDb2xvciA9IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUwMDZcIlxuICAgICAgICAgICAgbW9kdWxlRGF0YS5sb2FuUXVvdGFCb3JkZXJDb2xvciA9IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIlxuICAgICAgICB9XG4gICAgICAgIGNoYW5nZUlzb2xhdGVkTG9hbigpXG4gICAgfVxuICAgIGNvbnNvbGUubG9nKGBtYXJnaW4taG9tZSBjaGFuZ2VMb2FuSXNvbGF0ZWRUeXBlIGZ1bmN0aW9uIGVuZGApO1xufVxuXG5hc3luYyBmdW5jdGlvbiBjaGFuZ2VJc29sYXRlZExvYW4oKSB7XG4gICAgY29uc29sZS5sb2coYG1hcmdpbi1ob21lIGNoYW5nZUlzb2xhdGVkTG9hbiBmdW5jdGlvbiBzdGFydGApO1xuICAgIGlmKG1hcmdpbklzb2xhdGVkID09IG51bGwpIHtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICB0cnkge1xuICAgICAgICBsZXQgYmFzZUN1cnJlbmN5ID0gbWFyZ2luSXNvbGF0ZWRbXCJiYXNlLWN1cnJlbmN5XCJdLnRvVXBwZXJDYXNlKClcbiAgICAgICAgbGV0IGFscmVhZHlMb2FuID0gYXdhaXQgY29tbW9uLnRob3VzYW5kc0Zvcm1hdHRlcihudW1iZXIuc2NpZW50aWZpY1RvTnVtYmVyKG1hcmdpbklzb2xhdGVkW1wiYmFzZS1sb2FuXCJdKS50b1N0cmluZygpKVxuICAgICAgICBsZXQgbWF4TG9hbkFtb3VudCA9IGF3YWl0IGNvbW1vbi50aG91c2FuZHNGb3JtYXR0ZXIobnVtYmVyLnNjaWVudGlmaWNUb051bWJlcihtYXJnaW5Jc29sYXRlZFtcImJhc2UtbWF4LWxvYW4tYW1vdW50XCJdKS50b1N0cmluZygpKVxuXG4gICAgICAgIGxldCBpc29sYXRlZERhdGEgPSB7XG4gICAgICAgICAgICB0eXBlOiBcImxvYW5cIixcbiAgICAgICAgICAgIC8vIOWFqOS7k+aYvuekumljb27vvIzpgJDku5PpmpDol49cbiAgICAgICAgICAgIGljb25WaXNpYmxlOiBcImdvbmVcIixcbiAgICAgICAgICAgIGljb246IFwiXCIsXG4gICAgICAgICAgICBzeW1ib2w6IG1hcmdpbklzb2xhdGVkW1wiZGlzcGxheS1zeW1ib2xcIl0udG9VcHBlckNhc2UoKSxcbiAgICAgICAgICAgIGN1cnJlbmN5OiBiYXNlQ3VycmVuY3ksXG4gICAgICAgICAgICBiYXNlQ3VycmVuY3k6IGJhc2VDdXJyZW5jeSxcbiAgICAgICAgICAgIHF1b3RhQ3VycmVuY3k6IG1hcmdpbklzb2xhdGVkW1wicXVvdGEtY3VycmVuY3lcIl0udG9VcHBlckNhc2UoKSxcbiAgICAgICAgICAgIC8vIOW3suWAn+mHkeminSAmIOW3suWAn+W4gUN1cnJlbmN5XG4gICAgICAgICAgICBhbHJlYWR5TG9hbjogYCR7YWxyZWFkeUxvYW59ICR7YmFzZUN1cnJlbmN5fWAsXG4gICAgICAgICAgICAvLyDluIHmga/njodcbiAgICAgICAgICAgIGludGVyZXN0UmF0ZTogYCR7Zml4ZWROdW0obWFyZ2luSXNvbGF0ZWRbXCJiYXNlLWludGVyZXN0LXJhdGVcIl0gKiAxMDApfSVgLFxuICAgICAgICAgICAgLy8g5pyA5aSn5Y+v5YCf5pWw6YePXG4gICAgICAgICAgICBtYXhMb2FuTGltaXQ6IGAke21heExvYW5BbW91bnR9ICR7YmFzZUN1cnJlbmN5fWAsXG4gICAgICAgICAgICAvLyBlZGl0IGhpbnRcbiAgICAgICAgICAgIGVkaXRIaW50OiAkaTE4bi4kaW50ZXJjZXB0Lm5fbWFyZ2luX21pbmltdW0oYCAke251bWJlci5zY2llbnRpZmljVG9OdW1iZXIobWFyZ2luSXNvbGF0ZWRbXCJiYXNlLW1pbi1sb2FuLWxpbWl0XCJdKS50b1N0cmluZygpfWApLFxuICAgICAgICAgICAgbWF4TG9hbkFtb3VudDogYCR7bWF4TG9hbkFtb3VudH0gJHtiYXNlQ3VycmVuY3l9YCxcbiAgICAgICAgICAgIHNob3dUd29DdXJyZW5jeTogXCJ2aXNpYmxlXCIsXG4gICAgICAgICAgICBiYXNlSWNvbjogY29tbW9uLmdldFBOR0ljb25VUkxCeUN1cnJlbmN5KG1hcmdpbklzb2xhdGVkW1wiYmFzZS1jdXJyZW5jeVwiXSksXG4gICAgICAgICAgICBxdW90YUljb246IGNvbW1vbi5nZXRQTkdJY29uVVJMQnlDdXJyZW5jeShtYXJnaW5Jc29sYXRlZFtcInF1b3RhLWN1cnJlbmN5XCJdKSxcbiAgICAgICAgICAgIHNob3dJc29sYXRlZFRpdGxlOiBcInZpc2libGVcIlxuICAgICAgICB9XG4gICAgICAgIGlmIChtb2R1bGVEYXRhLmxvYW5Jc29sYXRlZFR5cGUgPT0gMikge1xuICAgICAgICAgICAgYmFzZUN1cnJlbmN5ID0gbWFyZ2luSXNvbGF0ZWRbXCJxdW90YS1jdXJyZW5jeVwiXS50b1VwcGVyQ2FzZSgpXG4gICAgICAgICAgICBhbHJlYWR5TG9hbiA9IGF3YWl0IGNvbW1vbi50aG91c2FuZHNGb3JtYXR0ZXIobnVtYmVyLnNjaWVudGlmaWNUb051bWJlcihtYXJnaW5Jc29sYXRlZFtcInF1b3RhLWxvYW5cIl0pLnRvU3RyaW5nKCkpXG4gICAgICAgICAgICBtYXhMb2FuQW1vdW50ID0gYXdhaXQgY29tbW9uLnRob3VzYW5kc0Zvcm1hdHRlcihudW1iZXIuc2NpZW50aWZpY1RvTnVtYmVyKG1hcmdpbklzb2xhdGVkW1wicXVvdGEtbWF4LWxvYW4tYW1vdW50XCJdKS50b1N0cmluZygpKVxuXG4gICAgICAgICAgICBpc29sYXRlZERhdGEuY3VycmVuY3kgPSBiYXNlQ3VycmVuY3lcbiAgICAgICAgICAgIGlzb2xhdGVkRGF0YS5hbHJlYWR5TG9hbiA9IGAke2FscmVhZHlMb2FufSAke2Jhc2VDdXJyZW5jeX1gXG4gICAgICAgICAgICBpc29sYXRlZERhdGEuaW50ZXJlc3RSYXRlID0gYCR7Zml4ZWROdW0obWFyZ2luSXNvbGF0ZWRbXCJxdW90YS1pbnRlcmVzdC1yYXRlXCJdICogMTAwKX0lYFxuICAgICAgICAgICAgaXNvbGF0ZWREYXRhLm1heExvYW5MaW1pdCA9IGAke21heExvYW5BbW91bnR9ICR7YmFzZUN1cnJlbmN5fWBcbiAgICAgICAgICAgIGlzb2xhdGVkRGF0YS5lZGl0SGludCA9ICRpMThuLiRpbnRlcmNlcHQubl9tYXJnaW5fbWluaW11bShgICR7bnVtYmVyLnNjaWVudGlmaWNUb051bWJlcihtYXJnaW5Jc29sYXRlZFtcInF1b3RhLW1pbi1sb2FuLWxpbWl0XCJdKS50b1N0cmluZygpfWApXG4gICAgICAgICAgICBpc29sYXRlZERhdGEubWF4TG9hbkFtb3VudCA9IGAke21heExvYW5BbW91bnR9ICR7YmFzZUN1cnJlbmN5fWBcbiAgICAgICAgfVxuICAgICAgICBpZiAoZmlyc3RTaG93UG9wKSB7XG4gICAgICAgICAgICBpZiAobWFyZ2luSXNvbGF0ZWRbXCJiYXNlLXN5cy1sb2FuLWFtb3VudFwiXSA8PSAwICYmIG1hcmdpbklzb2xhdGVkW1wicXVvdGEtc3lzLWxvYW4tYW1vdW50XCJdIDw9IDApIHtcbiAgICAgICAgICAgICAgICBjb21tb25Qb3AucG9wVXBDb250ZW50T2ZPbmVCdXR0b24oJGkxOG4ubl9jb3B5X3RyYWRpbmdfdGlwLCAkaTE4bi4kaW50ZXJjZXB0Lm5fbWFyZ2luX3VuYWJsZV90b19sb2FuKGAke21hcmdpbklzb2xhdGVkW1wiYmFzZS1jdXJyZW5jeVwiXS50b1VwcGVyQ2FzZSgpfeOAgSR7bWFyZ2luSXNvbGF0ZWRbXCJxdW90YS1jdXJyZW5jeVwiXS50b1VwcGVyQ2FzZSgpfWApLCBudWxsKVxuICAgICAgICAgICAgfSBlbHNlIGlmIChtYXJnaW5Jc29sYXRlZFtcImJhc2UtbWF4LWxvYW4tYW1vdW50XCJdIDw9IDAgJiYgbWFyZ2luSXNvbGF0ZWRbXCJxdW90YS1tYXgtbG9hbi1hbW91bnRcIl0gPD0gMCkge1xuICAgICAgICAgICAgICAgIGNvbW1vblBvcC5wb3BVcENvbnRlbnRPZlR3b0J1dHRvbigtMSwgJGkxOG4ubl9jb3B5X3RyYWRpbmdfdGlwLCAkaTE4bi4kaW50ZXJjZXB0Lm5fbWFyZ2luX2xpbWl0X3RpcHMoXCIwXCIpLCAkaTE4bi5uX2NhbmNlbCwgJGkxOG4ubl90cmFkZV9hbGVydF9nb190cmFuc2ZlciwgXCJnb25lXCIsIG51bGwsIHRyYW5zZmVyKVxuICAgICAgICAgICAgfVxuICAgICAgICB9XG4gICAgICAgIHRlbXBQYWdlRGF0YVswXSA9IGlzb2xhdGVkRGF0YVxuICAgICAgICBtb2R1bGVEYXRhLnBhZ2VEYXRhID0gdGVtcFBhZ2VEYXRhXG4gICAgICAgIGNvbnNvbGUubG9nKGBtYXJnaW4taG9tZSBjaGFuZ2VJc29sYXRlZExvYW4gdGVtcFBhZ2VEYXRhWzBdID0gJHtKU09OLnN0cmluZ2lmeSh0ZW1wUGFnZURhdGFbMF0pfWApXG4gICAgfSBjYXRjaChlKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGBtYXJnaW4taG9tZSBjaGFuZ2VJc29sYXRlZExvYW4gZSA9ICR7ZX1gKVxuICAgIH1cbiAgICBjb25zb2xlLmxvZyhgbWFyZ2luLWhvbWUgY2hhbmdlSXNvbGF0ZWRMb2FuIGZ1bmN0aW9uIGVuZGApO1xufVxuXG5hc3luYyBmdW5jdGlvbiByZWZyZXNoTG9hbkJ0blN0YXR1cygpIHtcbiAgICBjb25zb2xlLmxvZyhgbWFyZ2luLWhvbWUgcmVmcmVzaExvYW5CdG5TdGF0dXMgZnVuY3Rpb24gc3RhcnRgKTtcbiAgICBpZiAobW9kdWxlRGF0YS5sb2FuRWRpdFRleHQgPT0gXCJcIiB8fCBOdW1iZXIobW9kdWxlRGF0YS5sb2FuRWRpdFRleHQpID09IDApIHtcbiAgICAgICAgbW9kdWxlRGF0YS5sb2FuRWRpdEJvcmRlckNvbG9yID0gbW9kdWxlRGF0YS5pc0xvYW5FZGl0Rm9jdXMgPyBcIkBjb2xvci9rQ29sb3JNYWpvclRoZW1lMTAwXCIgOiBcIkBjb2xvci9rQ29sb3JJbnB1dEZpbGxcIlxuICAgICAgICBtb2R1bGVEYXRhLmxvYW5Db25maXJtQnRuQmcgPSBcIkBjb2xvci9lQ29sb3JJbnB1dEZpbGxEaXNhYmxlZFwiXG4gICAgICAgIG1vZHVsZURhdGEubG9hbkNvbmZpcm1CdG5UZXh0Q29sb3IgPSBcIkBjb2xvci9rQ29sb3JUaHJlZUxldmVsVGV4dFwiXG4gICAgICAgIG1vZHVsZURhdGEubG9hbkVycm9yVmlzaWJsZSA9IFwiZ29uZVwiXG4gICAgICAgIG1vZHVsZURhdGEuaXNMb2FuQnRuUmlnaHQgPSBmYWxzZVxuICAgIH0gZWxzZSB7XG4gICAgICAgIGxldCBpc1JpZ2h0ID0gZmFsc2VcbiAgICAgICAgbGV0IGVycm9yVGlwcyA9IFwiXCJcbiAgICAgICAgaWYgKG1vZHVsZURhdGEubG9hbk1hcmdpblR5cGUgPT0gMSkge1xuICAgICAgICAgICAgaWYgKE51bWJlcihtb2R1bGVEYXRhLmxvYW5FZGl0VGV4dCkgPD0gTnVtYmVyKG1hcmdpbkNyb3NzW1wibWF4LWxvYW4tYW1vdW50XCJdKSkge1xuICAgICAgICAgICAgICAgIGlzUmlnaHQgPSB0cnVlXG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgZXJyb3JUaXBzID0gYCR7TnVtYmVyKG1hcmdpbkNyb3NzW1wibWF4LWxvYW4tYW1vdW50XCJdKX1gXG4gICAgICAgICAgICB9XG4gICAgICAgIH0gZWxzZSBpZiAobW9kdWxlRGF0YS5sb2FuSXNvbGF0ZWRUeXBlID09IDEpe1xuICAgICAgICAgICAgaWYgKE51bWJlcihtb2R1bGVEYXRhLmxvYW5FZGl0VGV4dCkgPD0gTnVtYmVyKG1hcmdpbklzb2xhdGVkW1wiYmFzZS1tYXgtbG9hbi1hbW91bnRcIl0pKSB7XG4gICAgICAgICAgICAgICAgaXNSaWdodCA9IHRydWVcbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICBlcnJvclRpcHMgPSBgJHtOdW1iZXIobWFyZ2luSXNvbGF0ZWRbXCJiYXNlLW1heC1sb2FuLWFtb3VudFwiXSl9YFxuICAgICAgICAgICAgfVxuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgaWYgKE51bWJlcihtb2R1bGVEYXRhLmxvYW5FZGl0VGV4dCkgPD0gTnVtYmVyKG1hcmdpbklzb2xhdGVkW1wicXVvdGEtbWF4LWxvYW4tYW1vdW50XCJdKSkge1xuICAgICAgICAgICAgICAgIGlzUmlnaHQgPSB0cnVlXG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgZXJyb3JUaXBzID0gYCR7TnVtYmVyKG1hcmdpbklzb2xhdGVkW1wicXVvdGEtbWF4LWxvYW4tYW1vdW50XCJdKX1gXG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICAgICAgbW9kdWxlRGF0YS5sb2FuRXJyb3JUaXBzID0gJGkxOG4uJGludGVyY2VwdC5uX21hcmdpbl9tYXhpbXVtX2Ftb3VudF90aXBzKGAke2Vycm9yVGlwc31gKVxuICAgICAgICBpZiAoaXNSaWdodCkge1xuICAgICAgICAgICAgaWYgKG1vZHVsZURhdGEubG9hbk1hcmdpblR5cGUgPT0gMSkge1xuICAgICAgICAgICAgICAgIGlzUmlnaHQgPSAoTnVtYmVyKG1vZHVsZURhdGEubG9hbkVkaXRUZXh0KSA+PSBOdW1iZXIobWFyZ2luQ3Jvc3NbXCJtaW4tbG9hbi1saW1pdFwiXSkpXG4gICAgICAgICAgICAgICAgaWYgKCFpc1JpZ2h0KSB7XG4gICAgICAgICAgICAgICAgICAgZXJyb3JUaXBzID0gYCR7TnVtYmVyKG1hcmdpbkNyb3NzW1wibWluLWxvYW4tbGltaXRcIl0pfWBcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICB9IGVsc2UgaWYgKG1vZHVsZURhdGEubG9hbklzb2xhdGVkVHlwZSA9PSAxKXtcbiAgICAgICAgICAgICAgICBpc1JpZ2h0ID0gKE51bWJlcihtb2R1bGVEYXRhLmxvYW5FZGl0VGV4dCkgPj0gTnVtYmVyKG1hcmdpbklzb2xhdGVkW1wiYmFzZS1taW4tbG9hbi1saW1pdFwiXSkpXG4gICAgICAgICAgICAgICAgaWYgKCFpc1JpZ2h0KSB7XG4gICAgICAgICAgICAgICAgICAgZXJyb3JUaXBzID0gYCR7TnVtYmVyKG1hcmdpbklzb2xhdGVkW1wiYmFzZS1taW4tbG9hbi1saW1pdFwiXSl9YFxuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgaXNSaWdodCA9IChOdW1iZXIobW9kdWxlRGF0YS5sb2FuRWRpdFRleHQpID49IE51bWJlcihtYXJnaW5Jc29sYXRlZFtcInF1b3RhLW1pbi1sb2FuLWxpbWl0XCJdKSlcbiAgICAgICAgICAgICAgICBpZiAoIWlzUmlnaHQpIHtcbiAgICAgICAgICAgICAgICAgICBlcnJvclRpcHMgPSBgJHtOdW1iZXIobWFyZ2luSXNvbGF0ZWRbXCJxdW90YS1taW4tbG9hbi1saW1pdFwiXSl9YFxuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGlmICghaXNSaWdodCkge1xuICAgICAgICAgICAgICAgIG1vZHVsZURhdGEubG9hbkVycm9yVGlwcyA9ICRpMThuLiRpbnRlcmNlcHQubl9tYXJnaW5fbm90X3JlYWNoZWRfYm9ycm93ZWQoYCR7ZXJyb3JUaXBzfWApXG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICAgICAgaWYgKGlzUmlnaHQpIHtcbiAgICAgICAgICAgIGlmIChtb2R1bGVEYXRhLmxvYW5NYXJnaW5UeXBlID09IDEpIHtcbiAgICAgICAgICAgICAgICBpc1JpZ2h0ID0gKE51bWJlcihtb2R1bGVEYXRhLmxvYW5FZGl0VGV4dCkgPD0gTnVtYmVyKG1hcmdpbkNyb3NzW1wibWF4LWxvYW4tYW1vdW50XCJdKSlcbiAgICAgICAgICAgIH0gZWxzZSBpZiAobW9kdWxlRGF0YS5sb2FuSXNvbGF0ZWRUeXBlID09IDEpe1xuICAgICAgICAgICAgICAgIGlzUmlnaHQgPSAoTnVtYmVyKG1vZHVsZURhdGEubG9hbkVkaXRUZXh0KSA8PSBOdW1iZXIobWFyZ2luSXNvbGF0ZWRbXCJiYXNlLW1heC1sb2FuLWFtb3VudFwiXSkpXG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgIGlzUmlnaHQgPSAoTnVtYmVyKG1vZHVsZURhdGEubG9hbkVkaXRUZXh0KSA8PSBOdW1iZXIobWFyZ2luSXNvbGF0ZWRbXCJxdW90YS1tYXgtbG9hbi1hbW91bnRcIl0pKVxuICAgICAgICAgICAgfVxuICAgICAgICAgICAgaWYgKCFpc1JpZ2h0KSB7XG4gICAgICAgICAgICAgICBtb2R1bGVEYXRhLmxvYW5FcnJvclRpcHMgPSAkaTE4bi5uX21hcmdpbl9hbW91bnRfb3Zlcl9sb2FuYWJsZV90aXBzXG4gICAgICAgICAgICB9XG4gICAgICAgIH1cblxuICAgICAgICBtb2R1bGVEYXRhLmxvYW5FZGl0Qm9yZGVyQ29sb3IgPSBpc1JpZ2h0ID8gbW9kdWxlRGF0YS5pc0xvYW5FZGl0Rm9jdXMgPyBcIkBjb2xvci9rQ29sb3JNYWpvclRoZW1lMTAwXCIgOiBcIkBjb2xvci9rQ29sb3JJbnB1dEZpbGxcIiA6IFwiQGNvbG9yL2tDb2xvclByaWNlUmVkXCJcbiAgICAgICAgbW9kdWxlRGF0YS5sb2FuQ29uZmlybUJ0bkJnID0gaXNSaWdodCA/IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIiA6IFwiQGNvbG9yL2VDb2xvcklucHV0RmlsbERpc2FibGVkXCJcbiAgICAgICAgbW9kdWxlRGF0YS5sb2FuQ29uZmlybUJ0blRleHRDb2xvciA9IGlzUmlnaHQgPyBcIkBjb2xvci9LQmFzZVRleHRDb2xvclwiIDogXCJAY29sb3Iva0NvbG9yVGhyZWVMZXZlbFRleHRcIlxuICAgICAgICBtb2R1bGVEYXRhLmxvYW5FcnJvclZpc2libGUgPSBpc1JpZ2h0ID8gXCJnb25lXCIgOiBcInZpc2libGVcIlxuICAgICAgICBtb2R1bGVEYXRhLmlzTG9hbkJ0blJpZ2h0ID0gaXNSaWdodFxuICAgIH1cbiAgICBjb25zb2xlLmxvZyhgbWFyZ2luLWhvbWUgcmVmcmVzaExvYW5CdG5TdGF0dXMgZnVuY3Rpb24gZW5kYCk7XG59XG5cbmZ1bmN0aW9uIGZpbHRlck51bWJlclN0cihzdHIpIHtcbiAgICBpZiAoc3RyLnN0YXJ0c1dpdGgoXCIwLlwiKSkge1xuICAgICAgICByZXR1cm4gc3RyXG4gICAgfVxuICAgIGxldCBudW0gPSBOdW1iZXIoc3RyKVxuICAgIGlmIChpc05hTihudW0pKSB7XG4gICAgICAgIHJldHVybiBcIlwiXG4gICAgfVxuICAgIHJldHVybiBudW0gKyAoc3RyLmVuZHNXaXRoKFwiLlwiKSA/IFwiLlwiIDogXCJcIilcbn1cblxubW9kdWxlRXZlbnQub25Mb2FuRWRpdEZvY3VzQ2hhbmdlID0gYXN5bmMgZnVuY3Rpb24gKGlzRm9jdXMpIHtcbiAgICBjb25zb2xlLmxvZyhgbWFyZ2luLWhvbWUgb25Mb2FuRWRpdEZvY3VzQ2hhbmdlIGZ1bmN0aW9uIHN0YXJ0YCk7XG4gICAgbW9kdWxlRGF0YS5pc0xvYW5FZGl0Rm9jdXMgPSBpc0ZvY3VzXG4gICAgcmVmcmVzaExvYW5CdG5TdGF0dXMoKVxuICAgIGNvbnNvbGUubG9nKGBtYXJnaW4taG9tZSBvbkxvYW5FZGl0Rm9jdXNDaGFuZ2UgZnVuY3Rpb24gZW5kYCk7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIG9uTG9hblRleHRDaGFuZ2UodGV4dCkge1xuICAgIGlmICh0ZXh0ICE9IFwiXCIpIHtcbiAgICAgICAgbGV0IHJlcGxhY2VaZXJvID0gdGV4dFxuICAgICAgICBpZiAodGV4dC5sZW5ndGggPiAxKSB7XG4gICAgICAgICAgICByZXBsYWNlWmVybyA9IGZpbHRlck51bWJlclN0cih0ZXh0KVxuICAgICAgICB9XG4gICAgICAgIGlmIChyZXBsYWNlWmVybyAhPSB0ZXh0KSB7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLmxvYW5FZGl0VGV4dCA9IHJlcGxhY2VaZXJvXG4gICAgICAgIH1cbiAgICAgICAgbGV0IHRlbXBUZXh0ID0gYXdhaXQgY29tbW9uLmZvcm1hdERlY2ltYWwocmVwbGFjZVplcm8sIDMsIGZhbHNlKVxuICAgICAgICBpZiAodGVtcFRleHQgIT0gcmVwbGFjZVplcm8pIHtcbiAgICAgICAgICAgIG1vZHVsZURhdGEubG9hbkVkaXRUZXh0ID0gdGVtcFRleHRcbiAgICAgICAgfVxuICAgIH1cbiAgICByZWZyZXNoTG9hbkJ0blN0YXR1cygpXG59XG5cbm1vZHVsZUV2ZW50LmxvYW5Db25maXJtID0gYXN5bmMgZnVuY3Rpb24gKCkge1xuICAgIGNvbnNvbGUubG9nKGBtYXJnaW4taG9tZSBsb2FuQ29uZmlybSBmdW5jdGlvbiBzdGFydGApO1xuICAgIGlmIChtb2R1bGVEYXRhLmlzTG9hbkJ0blJpZ2h0KSB7XG4gICAgICAgIGNvbW1vbi5zaG93TG9hZGluZyh0cnVlKVxuICAgICAgICBsZXQgbG9hbkNvZGUgPSAwXG4gICAgICAgIGlmIChtb2R1bGVEYXRhLmxvYW5NYXJnaW5UeXBlID09IDEpIHtcbiAgICAgICAgICAgIGxldCBhY2NvdW50SWQgPSBjb21tb24uY29tbW9uRGF0YS5zdXBlck1hcmdpbkFjY291bnRJZFxuICAgICAgICAgICAgY29uc29sZS5sb2coYG1hcmdpbi1ob21lIGxvYW5Db25maXJtIGFjY291bnRJZCA9ICR7YWNjb3VudElkfWApXG4gICAgICAgICAgICBpZiAoYWNjb3VudElkID09IG51bGwgfHwgYWNjb3VudElkID09IFwiXCIgfHwgYWNjb3VudElkID09IFwidW5kZWZpbmVkXCIpIHtcbiAgICAgICAgICAgICAgICBjb21tb24uc2hvd0xvYWRpbmcoZmFsc2UpXG4gICAgICAgICAgICAgICAgcmV0dXJuXG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBsZXQgcGFyYW1zID0ge1xuICAgICAgICAgICAgICAgIGN1cnJlbmN5OiBtYXJnaW5Dcm9zcy5jdXJyZW5jeSxcbiAgICAgICAgICAgICAgICBhbW91bnQ6IG1vZHVsZURhdGEubG9hbkVkaXRUZXh0LFxuICAgICAgICAgICAgICAgIFwiYWNjb3VudC1pZFwiOiBhY2NvdW50SWQsXG4gICAgICAgICAgICAgICAgc291cmNlOiBjb21tb24uY29tbW9uRGF0YS5PUyA9PSAwID8gNCA6IDNcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGxvYW5Db2RlID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0UmV0dXJuQ29kZShcInYxL2hiZy9zdXBlci1tYXJnaW4vbG9hblwiLCBwYXJhbXMsIDEsIDQsIHsgXCJDb250ZW50LVR5cGVcIjogXCJhcHBsaWNhdGlvbi9qc29uXCIgfSlcbiAgICAgICAgfWVsc2Uge1xuICAgICAgICAgICAgbGV0IHBhcmFtcyA9IHtcbiAgICAgICAgICAgICAgICBzeW1ib2w6IG1hcmdpbklzb2xhdGVkLnN5bWJvbCxcbiAgICAgICAgICAgICAgICBjdXJyZW5jeTogbW9kdWxlRGF0YS5sb2FuSXNvbGF0ZWRUeXBlID09IDEgPyBtYXJnaW5Jc29sYXRlZFtcImJhc2UtY3VycmVuY3lcIl0gOiBtYXJnaW5Jc29sYXRlZFtcInF1b3RhLWN1cnJlbmN5XCJdLFxuICAgICAgICAgICAgICAgIGFtb3VudDogbW9kdWxlRGF0YS5sb2FuRWRpdFRleHRcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGxvYW5Db2RlID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0UmV0dXJuQ29kZShcInYxL21hcmdpbi9vcmRlcnNcIiwgcGFyYW1zLCAxLCA0LCB7IFwiQ29udGVudC1UeXBlXCI6IFwiYXBwbGljYXRpb24vanNvblwiIH0pXG4gICAgICAgIH1cbiAgICAgICAgY29tbW9uLnNob3dMb2FkaW5nKGZhbHNlKVxuICAgICAgICBpZiAobG9hbkNvZGUgPT0gMjAwKSB7XG4gICAgICAgICAgICByZXF1ZXN0RGV0YWlsKCk7XG4gICAgICAgICAgICAvLyDlkI7nu63lvLnnqpfpgLvovpEgLSDlt7LmiJDlip/lrozmiJDlgJ/luIHvvIzpqazkuIrov5vooYzmnaDmnYbkuqTmmJNcbiAgICAgICAgICAgIGxldCBjb250ZW50ID0gJGkxOG4ubl9tYXJnaW5fY29tcGxldGVkX2xvYW5cbiAgICAgICAgICAgIGxldCBsZWZ0VGV4dCA9ICRpMThuLm5fY2FuY2VsXG4gICAgICAgICAgICBsZXQgcmlnaHRUZXh0ID0gJGkxOG4ubl9nb190cmFkZVxuICAgICAgICAgICAgY29tbW9uUG9wLnBvcFVwQ29udGVudE9mVHdvQnV0dG9uKC0xLCBudWxsLCBjb250ZW50LCBsZWZ0VGV4dCwgcmlnaHRUZXh0LCBcImdvbmVcIiwgbnVsbCwgYXN5bmMgZnVuY3Rpb24gKCkge1xuICAgICAgICAgICAgICAgIGxldCB0eXBlID0gbW9kdWxlRGF0YS5sb2FuTWFyZ2luVHlwZSA9PSAxID8gXCJzdXBlcl9tYXJnaW5cIiA6IFwibWFyZ2luXCJcbiAgICAgICAgICAgICAgICBsZXQgc3ltYm9sID0gbW9kdWxlRGF0YS5sb2FuTWFyZ2luVHlwZSA9PSAxID8gXCJcIiA6IG1hcmdpbklzb2xhdGVkLnN5bWJvbFxuICAgICAgICAgICAgICAgIGNvbW1vbi5vcGVuVVJMKGBob2xpZ2VpdDovL29wZW4vdjE/bG9naW49MSZ1cmw9aWh1b2JpZ2xvYmFsOi8vbS5oYmcuY29tL3RyYWRlL2luZGV4P3R5cGU9JHt0eXBlfSZzeW1ib2w9JHtzeW1ib2x9JmJhY2tGaXJzdExldmVsUGFnZT0xYClcbiAgICAgICAgICAgIH0pXG4gICAgICAgIH1cbiAgICB9XG4gICAgY29uc29sZS5sb2coYG1hcmdpbi1ob21lIGxvYW5Db25maXJtIGZ1bmN0aW9uIGVuZGApO1xufVxuXG5tb2R1bGVFdmVudC5sb2FuQWxsQmFsYW5jZSA9IGFzeW5jIGZ1bmN0aW9uICgpIHtcbiAgICBjb25zb2xlLmxvZyhgbWFyZ2luLWhvbWUgbG9hbkFsbEJhbGFuY2UgZnVuY3Rpb24gc3RhcnRgKTtcbiAgICBpZiAobW9kdWxlRGF0YS5sb2FuTWFyZ2luVHlwZSA9PSAxKSB7XG4gICAgICAgIG1vZHVsZURhdGEubG9hbkVkaXRUZXh0ID0gYXdhaXQgY29tbW9uLmZvcm1hdERlY2ltYWwoTnVtYmVyKG1hcmdpbkNyb3NzW1wibWF4LWxvYW4tYW1vdW50XCJdKSwgMywgZmFsc2UpXG4gICAgfSBlbHNlIGlmIChtb2R1bGVEYXRhLmxvYW5Jc29sYXRlZFR5cGUgPT0gMSl7XG4gICAgICAgIG1vZHVsZURhdGEubG9hbkVkaXRUZXh0ID0gYXdhaXQgY29tbW9uLmZvcm1hdERlY2ltYWwoTnVtYmVyKG1hcmdpbklzb2xhdGVkW1wiYmFzZS1tYXgtbG9hbi1hbW91bnRcIl0pLCAzLCBmYWxzZSlcbiAgICB9IGVsc2Uge1xuICAgICAgICBtb2R1bGVEYXRhLmxvYW5FZGl0VGV4dCA9IGF3YWl0IGNvbW1vbi5mb3JtYXREZWNpbWFsKE51bWJlcihtYXJnaW5Jc29sYXRlZFtcInF1b3RhLW1heC1sb2FuLWFtb3VudFwiXSksIDMsIGZhbHNlKVxuICAgIH1cbiAgICBvbkxvYW5UZXh0Q2hhbmdlKG1vZHVsZURhdGEubG9hbkVkaXRUZXh0KVxuICAgIGNvbnNvbGUubG9nKGBtYXJnaW4taG9tZSBsb2FuQWxsQmFsYW5jZSBsb2FuRWRpdFRleHQgPSAke21vZHVsZURhdGEubG9hbkVkaXRUZXh0fSwgbWFyZ2luQ3Jvc3MgPSAke0pTT04uc3RyaW5naWZ5KG1hcmdpbkNyb3NzKX0sIG1hcmdpbklzb2xhdGVkID0gJHtKU09OLnN0cmluZ2lmeShtYXJnaW5Jc29sYXRlZCl9YCk7XG4gICAgY29uc29sZS5sb2coYG1hcmdpbi1ob21lIGxvYW5BbGxCYWxhbmNlIGZ1bmN0aW9uIGVuZGApO1xufVxuXG5hc3luYyBmdW5jdGlvbiByZXBheUNoYW5nZVR5cGUgKHR5cGUsIGN1cnJlbmN5Q2hhbmdlID0gZmFsc2UpIHtcbiAgICBjb25zb2xlLmxvZyhgbWFyZ2luLWhvbWUgcmVwYXlDaGFuZ2VUeXBlIHR5cGUgPSAke3R5cGV9LCBjdXJyZW5jeUNoYW5nZSA9ICR7Y3VycmVuY3lDaGFuZ2V9YClcbiAgICBpZiAobW9kdWxlRGF0YS5yZXBheU1hcmdpblR5cGUgIT0gdHlwZSB8fCBjdXJyZW5jeUNoYW5nZSkge1xuICAgICAgICBjbG9zZUtleWJvYXJkKClcbiAgICAgICAgbW9kdWxlRGF0YS5yZXBheU1hcmdpblR5cGUgPSB0eXBlXG4gICAgICAgIG1vZHVsZURhdGEucmVwYXlFZGl0VGV4dCA9IFwiXCJcbiAgICAgICAgcmVzZXRSZXBheU1hcmdpblRpdGxlKHR5cGUpO1xuICAgICAgICBhd2FpdCByZXF1ZXN0RGV0YWlsKCk7XG4gICAgfVxuICAgIG9uUmVwYXlUZXh0Q2hhbmdlKG1vZHVsZURhdGEucmVwYXlFZGl0VGV4dClcbiAgICBjb25zb2xlLmxvZyhgbWFyZ2luLWhvbWUgcmVwYXlDaGFuZ2VUeXBlIGZ1bmN0aW9uIGVuZGApO1xufVxuXG5mdW5jdGlvbiByZXNldFJlcGF5TWFyZ2luVGl0bGUgKHR5cGUpIHtcbiAgICBpZiAodHlwZSA9PSAxKSB7XG4gICAgICAgIG1vZHVsZURhdGEucmVwYXlDcm9zc0NoZWNrQnRuQmcgPSBtYXJnaW5TZWxlY3RCdG5CZ1xuICAgICAgICBtb2R1bGVEYXRhLnJlcGF5Q3Jvc3NDaGVja0J0blRleHRDb2xvciA9IHRpdGxlQ29sb3JfU2VsZWN0ZWRcbiAgICAgICAgbW9kdWxlRGF0YS5yZXBheUlzb2xhdGVkQ2hlY2tCdG5CZyA9IG1hcmdpblVuc2VsZWN0QnRuQmdcbiAgICAgICAgbW9kdWxlRGF0YS5yZXBheUlzb2xhdGVkQ2hlY2tCdG5UZXh0Q29sb3IgPSB0aXRsZUNvbG9yX05vcm1hbFxuICAgIH0gZWxzZSB7XG4gICAgICAgIG1vZHVsZURhdGEucmVwYXlDcm9zc0NoZWNrQnRuQmcgPSBtYXJnaW5VbnNlbGVjdEJ0bkJnXG4gICAgICAgIG1vZHVsZURhdGEucmVwYXlDcm9zc0NoZWNrQnRuVGV4dENvbG9yID0gdGl0bGVDb2xvcl9Ob3JtYWxcbiAgICAgICAgbW9kdWxlRGF0YS5yZXBheUlzb2xhdGVkQ2hlY2tCdG5CZyA9IG1hcmdpblNlbGVjdEJ0bkJnXG4gICAgICAgIG1vZHVsZURhdGEucmVwYXlJc29sYXRlZENoZWNrQnRuVGV4dENvbG9yID0gdGl0bGVDb2xvcl9TZWxlY3RlZFxuICAgIH1cbn1cblxubW9kdWxlRXZlbnQucmVwYXlDaGFuZ2VUeXBlID0gcmVwYXlDaGFuZ2VUeXBlXG5cbm1vZHVsZUV2ZW50LmNoYW5nZVJlcGF5SXNvbGF0ZWRUeXBlID0gYXN5bmMgZnVuY3Rpb24gKHR5cGUpIHtcbiAgICBjb25zb2xlLmxvZyhgbWFyZ2luLWhvbWUgY2hhbmdlUmVwYXlJc29sYXRlZFR5cGUgdHlwZSA9ICR7dHlwZX1gKTtcbiAgICBpZiAobW9kdWxlRGF0YS5yZXBheUlzb2xhdGVkVHlwZSAhPSB0eXBlKSB7XG4gICAgICAgIGNsb3NlS2V5Ym9hcmQoKVxuICAgICAgICBtb2R1bGVEYXRhLnJlcGF5SXNvbGF0ZWRUeXBlID0gdHlwZVxuICAgICAgICBtb2R1bGVEYXRhLnJlcGF5RWRpdFRleHQgPSBcIlwiXG4gICAgICAgIGlmICh0eXBlID09IDEpIHtcbiAgICAgICAgICAgIG1vZHVsZURhdGEucmVwYXlCYXNlQnRuQmdDb2xvciA9IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUwMDZcIlxuICAgICAgICAgICAgbW9kdWxlRGF0YS5yZXBheUJhc2VCb3JkZXJDb2xvciA9IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIlxuICAgICAgICAgICAgbW9kdWxlRGF0YS5yZXBheVF1b3RhQnRuQmdDb2xvciA9IFwiQGNvbG9yL2tDb2xvcklucHV0RmlsbFwiXG4gICAgICAgICAgICBtb2R1bGVEYXRhLnJlcGF5UXVvdGFCb3JkZXJDb2xvciA9IFwiQGNvbG9yL2tDb2xvcklucHV0RmlsbFwiXG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLnJlcGF5QmFzZUJ0bkJnQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JJbnB1dEZpbGxcIlxuICAgICAgICAgICAgbW9kdWxlRGF0YS5yZXBheUJhc2VCb3JkZXJDb2xvciA9IFwiQGNvbG9yL2tDb2xvcklucHV0RmlsbFwiXG4gICAgICAgICAgICBtb2R1bGVEYXRhLnJlcGF5UXVvdGFCdG5CZ0NvbG9yID0gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTAwNlwiXG4gICAgICAgICAgICBtb2R1bGVEYXRhLnJlcGF5UXVvdGFCb3JkZXJDb2xvciA9IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIlxuICAgICAgICB9XG4gICAgICAgIGNoYW5nZUlzb2xhdGVkUmVwYXkoKVxuICAgIH1cbiAgICBjb25zb2xlLmxvZyhgbWFyZ2luLWhvbWUgY2hhbmdlUmVwYXlJc29sYXRlZFR5cGUgZnVuY3Rpb24gZW5kYCk7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIGNoYW5nZVN1cGVyTWFyZ2luUmVwYXkoKSB7XG4gICAgaWYobWFyZ2luQ3Jvc3MgPT0gbnVsbCkge1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIGxldCBhbHJlYWR5TG9hbiA9IGF3YWl0IGNvbW1vbi50aG91c2FuZHNGb3JtYXR0ZXIobnVtYmVyLnNjaWVudGlmaWNUb051bWJlcihtYXJnaW5Dcm9zcy5sb2FuKS50b1N0cmluZygpKVxuICAgIGxldCBpbnRlcmVzdCA9IGF3YWl0IGNvbW1vbi50aG91c2FuZHNGb3JtYXR0ZXIobnVtYmVyLnNjaWVudGlmaWNUb051bWJlcihtYXJnaW5Dcm9zcy5pbnRlcmVzdCkudG9TdHJpbmcoKSlcbiAgICBsZXQgZGVidCA9IGF3YWl0IGNvbW1vbi50aG91c2FuZHNGb3JtYXR0ZXIobnVtYmVyLnNjaWVudGlmaWNUb051bWJlcihtYXJnaW5Dcm9zcy5kZWJ0KS50b1N0cmluZygpKVxuICAgIGxldCB0cmFkZSA9IGF3YWl0IGNvbW1vbi50aG91c2FuZHNGb3JtYXR0ZXIobnVtYmVyLnNjaWVudGlmaWNUb051bWJlcihtYXJnaW5Dcm9zcy50cmFkZSkudG9TdHJpbmcoKSlcblxuICAgIHRlbXBQYWdlRGF0YVsxXSA9IHtcbiAgICAgICAgdHlwZTogXCJyZXBheVwiLFxuICAgICAgICAvLyDlhajku5PmmL7npLppY29u77yM6YCQ5LuT6ZqQ6JePXG4gICAgICAgIGljb25WaXNpYmxlOiBcInZpc2libGVcIixcbiAgICAgICAgaWNvbjogY29tbW9uLmdldFBOR0ljb25VUkxCeUN1cnJlbmN5KG1hcmdpbkNyb3NzLmN1cnJlbmN5KSxcbiAgICAgICAgc3ltYm9sOiBtYXJnaW5Dcm9zcy5jdXJyZW5jeS50b1VwcGVyQ2FzZSgpLFxuICAgICAgICBjdXJyZW5jeTogbWFyZ2luQ3Jvc3MuY3VycmVuY3kudG9VcHBlckNhc2UoKSxcbiAgICAgICAgLy8g5bey5YCf6YeR6aKdICYg5bey5YCf5biBQ3VycmVuY3lcbiAgICAgICAgYWxyZWFkeUxvYW46IGAke2FscmVhZHlMb2FufSAke21hcmdpbkNyb3NzLmN1cnJlbmN5LnRvVXBwZXJDYXNlKCl9YCxcbiAgICAgICAgLy8g5biB5oGvXG4gICAgICAgIGludGVyZXN0OiBgJHtpbnRlcmVzdH0gJHttYXJnaW5Dcm9zcy5jdXJyZW5jeS50b1VwcGVyQ2FzZSgpfWAsXG4gICAgICAgIC8vIOaAu+i0n+WAulxuICAgICAgICBkZWJ0OiBgJHtkZWJ0fSAke21hcmdpbkNyb3NzLmN1cnJlbmN5LnRvVXBwZXJDYXNlKCl9YCxcbiAgICAgICAgLy8g5Y+v55SoXG4gICAgICAgIHRyYWRlOiBgJHt0cmFkZX0gJHttYXJnaW5Dcm9zcy5jdXJyZW5jeS50b1VwcGVyQ2FzZSgpfWAsXG4gICAgfVxuICAgIG1vZHVsZURhdGEucGFnZURhdGEgPSB0ZW1wUGFnZURhdGFcbiAgICBjb25zb2xlLmxvZyhgbWFyZ2luLWhvbWUgcmVwYXlDaGFuZ2VUeXBlIHRlbXBQYWdlRGF0YVsxXSA9ICR7SlNPTi5zdHJpbmdpZnkodGVtcFBhZ2VEYXRhWzFdKX1gKVxufVxuXG5hc3luYyBmdW5jdGlvbiBjaGFuZ2VJc29sYXRlZFJlcGF5KCkge1xuICAgIGNvbnNvbGUubG9nKGBtYXJnaW4taG9tZSBjaGFuZ2VJc29sYXRlZFJlcGF5IGZ1bmN0aW9uIHN0YXJ0YCk7XG4gICAgaWYobWFyZ2luSXNvbGF0ZWQgPT0gbnVsbCkge1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIHRyeSB7XG4gICAgICAgIHZhciBiYXNlQ3VycmVuY3kgPSBtYXJnaW5Jc29sYXRlZFtcImJhc2UtY3VycmVuY3lcIl0udG9VcHBlckNhc2UoKVxuICAgICAgICBsZXQgYWxyZWFkeUxvYW4gPSBhd2FpdCBjb21tb24udGhvdXNhbmRzRm9ybWF0dGVyKG51bWJlci5zY2llbnRpZmljVG9OdW1iZXIobWFyZ2luSXNvbGF0ZWRbXCJiYXNlLWxvYW5cIl0pLnRvU3RyaW5nKCkpXG4gICAgICAgIGxldCBpbnRlcmVzdCA9IGF3YWl0IGNvbW1vbi50aG91c2FuZHNGb3JtYXR0ZXIobnVtYmVyLnNjaWVudGlmaWNUb051bWJlcihtYXJnaW5Jc29sYXRlZFtcImJhc2UtaW50ZXJlc3RcIl0pLnRvU3RyaW5nKCkpXG4gICAgICAgIGxldCBkZWJ0ID0gYXdhaXQgY29tbW9uLnRob3VzYW5kc0Zvcm1hdHRlcihudW1iZXIuc2NpZW50aWZpY1RvTnVtYmVyKG1hcmdpbklzb2xhdGVkW1wiYmFzZS1kZWJ0XCJdKS50b1N0cmluZygpKVxuICAgICAgICBsZXQgdHJhZGUgPSBhd2FpdCBjb21tb24udGhvdXNhbmRzRm9ybWF0dGVyKG51bWJlci5zY2llbnRpZmljVG9OdW1iZXIobWFyZ2luSXNvbGF0ZWRbXCJiYXNlLXRyYWRlXCJdKS50b1N0cmluZygpKVxuXG4gICAgICAgIGxldCBpc29sYXRlZERhdGEgPSB7XG4gICAgICAgICAgICB0eXBlOiBcInJlcGF5XCIsXG4gICAgICAgICAgICAvLyDlhajku5PmmL7npLppY29u77yM6YCQ5LuT6ZqQ6JePXG4gICAgICAgICAgICBpY29uVmlzaWJsZTogXCJnb25lXCIsXG4gICAgICAgICAgICBpY29uOiBcIlwiLFxuICAgICAgICAgICAgc3ltYm9sOiBtYXJnaW5Jc29sYXRlZFtcImRpc3BsYXktc3ltYm9sXCJdLnRvVXBwZXJDYXNlKCksXG4gICAgICAgICAgICBjdXJyZW5jeTogYmFzZUN1cnJlbmN5LFxuICAgICAgICAgICAgYmFzZUN1cnJlbmN5OiBiYXNlQ3VycmVuY3ksXG4gICAgICAgICAgICBxdW90YUN1cnJlbmN5OiBtYXJnaW5Jc29sYXRlZFtcInF1b3RhLWN1cnJlbmN5XCJdLnRvVXBwZXJDYXNlKCksXG4gICAgICAgICAgICAvLyDlt7LlgJ/ph5Hpop0gJiDlt7LlgJ/luIFDdXJyZW5jeVxuICAgICAgICAgICAgYWxyZWFkeUxvYW46IGAke2FscmVhZHlMb2FufSAke2Jhc2VDdXJyZW5jeX1gLFxuICAgICAgICAgICAgLy8g5biB5oGvXG4gICAgICAgICAgICBpbnRlcmVzdDogYCR7aW50ZXJlc3R9ICR7YmFzZUN1cnJlbmN5fWAsXG4gICAgICAgICAgICAvLyDmgLvotJ/lgLpcbiAgICAgICAgICAgIGRlYnQ6IGAke2RlYnR9ICR7YmFzZUN1cnJlbmN5fWAsXG4gICAgICAgICAgICB0cmFkZTogYCR7dHJhZGV9ICR7YmFzZUN1cnJlbmN5fWAsXG4gICAgICAgICAgICBzaG93VHdvQ3VycmVuY3k6IFwidmlzaWJsZVwiLFxuICAgICAgICAgICAgYmFzZUljb246IGNvbW1vbi5nZXRQTkdJY29uVVJMQnlDdXJyZW5jeShtYXJnaW5Jc29sYXRlZFtcImJhc2UtY3VycmVuY3lcIl0pLFxuICAgICAgICAgICAgcXVvdGFJY29uOiBjb21tb24uZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3kobWFyZ2luSXNvbGF0ZWRbXCJxdW90YS1jdXJyZW5jeVwiXSksXG4gICAgICAgICAgICBzaG93SXNvbGF0ZWRUaXRsZTogXCJ2aXNpYmxlXCJcbiAgICAgICAgfVxuICAgICAgICBpZiAobW9kdWxlRGF0YS5yZXBheUlzb2xhdGVkVHlwZSA9PSAyKSB7XG4gICAgICAgICAgICBiYXNlQ3VycmVuY3kgPSBtYXJnaW5Jc29sYXRlZFtcInF1b3RhLWN1cnJlbmN5XCJdLnRvVXBwZXJDYXNlKClcbiAgICAgICAgICAgIGFscmVhZHlMb2FuID0gYXdhaXQgY29tbW9uLnRob3VzYW5kc0Zvcm1hdHRlcihudW1iZXIuc2NpZW50aWZpY1RvTnVtYmVyKG1hcmdpbklzb2xhdGVkW1wicXVvdGEtbG9hblwiXSkudG9TdHJpbmcoKSlcbiAgICAgICAgICAgIGludGVyZXN0ID0gYXdhaXQgY29tbW9uLnRob3VzYW5kc0Zvcm1hdHRlcihudW1iZXIuc2NpZW50aWZpY1RvTnVtYmVyKG1hcmdpbklzb2xhdGVkW1wicXVvdGEtaW50ZXJlc3RcIl0pLnRvU3RyaW5nKCkpXG4gICAgICAgICAgICBkZWJ0ID0gYXdhaXQgY29tbW9uLnRob3VzYW5kc0Zvcm1hdHRlcihudW1iZXIuc2NpZW50aWZpY1RvTnVtYmVyKG1hcmdpbklzb2xhdGVkW1wicXVvdGEtZGVidFwiXSkudG9TdHJpbmcoKSlcbiAgICAgICAgICAgIHRyYWRlID0gYXdhaXQgY29tbW9uLnRob3VzYW5kc0Zvcm1hdHRlcihudW1iZXIuc2NpZW50aWZpY1RvTnVtYmVyKG1hcmdpbklzb2xhdGVkW1wicXVvdGEtdHJhZGVcIl0pLnRvU3RyaW5nKCkpXG5cbiAgICAgICAgICAgIGlzb2xhdGVkRGF0YS5jdXJyZW5jeSA9IGJhc2VDdXJyZW5jeVxuICAgICAgICAgICAgaXNvbGF0ZWREYXRhLmFscmVhZHlMb2FuID0gYCR7YWxyZWFkeUxvYW59ICR7YmFzZUN1cnJlbmN5fWBcbiAgICAgICAgICAgIGlzb2xhdGVkRGF0YS5pbnRlcmVzdCA9IGAke2ludGVyZXN0fSAke2Jhc2VDdXJyZW5jeX1gXG4gICAgICAgICAgICBpc29sYXRlZERhdGEuZGVidCA9IGAke2RlYnR9ICR7YmFzZUN1cnJlbmN5fWBcbiAgICAgICAgICAgIGlzb2xhdGVkRGF0YS50cmFkZSA9IGAke3RyYWRlfSAke2Jhc2VDdXJyZW5jeX1gXG4gICAgICAgIH1cbiAgICAgICAgdGVtcFBhZ2VEYXRhWzFdID0gaXNvbGF0ZWREYXRhXG4gICAgICAgIG1vZHVsZURhdGEucGFnZURhdGEgPSB0ZW1wUGFnZURhdGFcbiAgICAgICAgY29uc29sZS5sb2coYG1hcmdpbi1ob21lIGNoYW5nZUlzb2xhdGVkUmVwYXkgdGVtcFBhZ2VEYXRhWzFdID0gJHtKU09OLnN0cmluZ2lmeSh0ZW1wUGFnZURhdGFbMV0pfWApXG4gICAgfSBjYXRjaChlKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGBtYXJnaW4taG9tZSBjaGFuZ2VJc29sYXRlZFJlcGF5IGUgPSAke2V9YClcbiAgICB9XG4gICAgY29uc29sZS5sb2coYG1hcmdpbi1ob21lIGNoYW5nZUlzb2xhdGVkUmVwYXkgZnVuY3Rpb24gZW5kYCk7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlZnJlc2hSZXBheUJ0blN0YXR1cygpIHtcbiAgICBjb25zb2xlLmxvZyhgbWFyZ2luLWhvbWUgcmVmcmVzaFJlcGF5QnRuU3RhdHVzIGZ1bmN0aW9uIHN0YXJ0YCk7XG4gICAgaWYgKG1vZHVsZURhdGEucmVwYXlFZGl0VGV4dCA9PSBcIlwiIHx8IE51bWJlcihtb2R1bGVEYXRhLnJlcGF5RWRpdFRleHQpID09IDApIHtcbiAgICAgICAgbW9kdWxlRGF0YS5yZXBheUVkaXRCb3JkZXJDb2xvciA9IG1vZHVsZURhdGEuaXNSZXBheUVkaXRGb2N1cyA/IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIiA6IFwiQGNvbG9yL2tDb2xvcklucHV0RmlsbFwiXG4gICAgICAgIG1vZHVsZURhdGEucmVwYXlDb25maXJtQnRuQmcgPSBcIkBjb2xvci9lQ29sb3JJbnB1dEZpbGxEaXNhYmxlZFwiXG4gICAgICAgIG1vZHVsZURhdGEucmVwYXlDb25maXJtQnRuVGV4dENvbG9yID0gXCJAY29sb3Iva0NvbG9yVGhyZWVMZXZlbFRleHRcIlxuICAgICAgICBtb2R1bGVEYXRhLnJlcGF5RXJyb3JWaXNpYmxlID0gXCJnb25lXCJcbiAgICAgICAgbW9kdWxlRGF0YS5pc1JlcGF5QnRuUmlnaHQgPSBmYWxzZVxuICAgIH0gZWxzZSB7XG4gICAgICAgIGxldCBpc1JpZ2h0ID0gZmFsc2VcbiAgICAgICAgaWYgKG1vZHVsZURhdGEucmVwYXlNYXJnaW5UeXBlID09IDEpIHtcbiAgICAgICAgICAgIGlmIChOdW1iZXIobW9kdWxlRGF0YS5yZXBheUVkaXRUZXh0KSA+IE51bWJlcihtYXJnaW5Dcm9zcy50cmFkZSkpIHtcbiAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLnJlcGF5RXJyb3JUaXBUZXh0ID0gJGkxOG4ubl9tYXJnaW5faW5zdWZmaWNpZW50X2F2YWlsYWJsZVxuICAgICAgICAgICAgfSBlbHNlIGlmIChOdW1iZXIobW9kdWxlRGF0YS5yZXBheUVkaXRUZXh0KSA+IE51bWJlcihtYXJnaW5Dcm9zcy5kZWJ0KSkge1xuICAgICAgICAgICAgICAgIGlmIChOdW1iZXIobWFyZ2luQ3Jvc3MuZGVidCkgPT0gMCkge1xuICAgICAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLnJlcGF5RXJyb3JUaXBUZXh0ID0gJGkxOG4ubl9tYXJnaW5fb3V0X29mX2RlYnRcbiAgICAgICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLnJlcGF5RXJyb3JUaXBUZXh0ID0gJGkxOG4ubl9tYXJnaW5fYW1vdW50X292ZXJfdG90YWxfbGlhYmlsaXRpZXNcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgIGlzUmlnaHQgPSB0cnVlXG4gICAgICAgICAgICB9XG4gICAgICAgIH0gZWxzZSBpZiAobW9kdWxlRGF0YS5yZXBheUlzb2xhdGVkVHlwZSA9PSAxKSB7XG4gICAgICAgICAgICBpZiAoTnVtYmVyKG1vZHVsZURhdGEucmVwYXlFZGl0VGV4dCkgPiBOdW1iZXIobWFyZ2luSXNvbGF0ZWRbXCJiYXNlLXRyYWRlXCJdKSkge1xuICAgICAgICAgICAgICAgIG1vZHVsZURhdGEucmVwYXlFcnJvclRpcFRleHQgPSAkaTE4bi5uX21hcmdpbl9pbnN1ZmZpY2llbnRfYXZhaWxhYmxlXG4gICAgICAgICAgICB9IGVsc2UgaWYgKE51bWJlcihtb2R1bGVEYXRhLnJlcGF5RWRpdFRleHQpID4gTnVtYmVyKG1hcmdpbklzb2xhdGVkW1wiYmFzZS1kZWJ0XCJdKSkge1xuICAgICAgICAgICAgICAgIGlmIChOdW1iZXIobWFyZ2luSXNvbGF0ZWRbXCJiYXNlLWRlYnRcIl0pID09IDApIHtcbiAgICAgICAgICAgICAgICAgICAgbW9kdWxlRGF0YS5yZXBheUVycm9yVGlwVGV4dCA9ICRpMThuLm5fbWFyZ2luX291dF9vZl9kZWJ0XG4gICAgICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICAgICAgbW9kdWxlRGF0YS5yZXBheUVycm9yVGlwVGV4dCA9ICRpMThuLm5fbWFyZ2luX2Ftb3VudF9vdmVyX3RvdGFsX2xpYWJpbGl0aWVzXG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICBpc1JpZ2h0ID0gdHJ1ZVxuICAgICAgICAgICAgfVxuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgaWYgKE51bWJlcihtb2R1bGVEYXRhLnJlcGF5RWRpdFRleHQpID4gTnVtYmVyKG1hcmdpbklzb2xhdGVkW1wicXVvdGEtdHJhZGVcIl0pKSB7XG4gICAgICAgICAgICAgICAgbW9kdWxlRGF0YS5yZXBheUVycm9yVGlwVGV4dCA9ICRpMThuLm5fbWFyZ2luX2luc3VmZmljaWVudF9hdmFpbGFibGVcbiAgICAgICAgICAgIH0gZWxzZSBpZiAoTnVtYmVyKG1vZHVsZURhdGEucmVwYXlFZGl0VGV4dCkgPiBOdW1iZXIobWFyZ2luSXNvbGF0ZWRbXCJxdW90YS1kZWJ0XCJdKSkge1xuICAgICAgICAgICAgICAgIGlmIChOdW1iZXIobWFyZ2luSXNvbGF0ZWRbXCJxdW90YS1kZWJ0XCJdKSA9PSAwKSB7XG4gICAgICAgICAgICAgICAgICAgIG1vZHVsZURhdGEucmVwYXlFcnJvclRpcFRleHQgPSAkaTE4bi5uX21hcmdpbl9vdXRfb2ZfZGVidFxuICAgICAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgICAgIG1vZHVsZURhdGEucmVwYXlFcnJvclRpcFRleHQgPSAkaTE4bi5uX21hcmdpbl9hbW91bnRfb3Zlcl90b3RhbF9saWFiaWxpdGllc1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgaXNSaWdodCA9IHRydWVcbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgICAgICBtb2R1bGVEYXRhLnJlcGF5RWRpdEJvcmRlckNvbG9yID0gaXNSaWdodCA/IG1vZHVsZURhdGEuaXNMb2FuRWRpdEZvY3VzID8gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiIDogXCJAY29sb3Iva0NvbG9ySW5wdXRGaWxsXCIgOiBcIkBjb2xvci9rQ29sb3JQcmljZVJlZFwiXG4gICAgICAgIG1vZHVsZURhdGEucmVwYXlDb25maXJtQnRuQmcgPSBpc1JpZ2h0ID8gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiIDogXCJAY29sb3IvZUNvbG9ySW5wdXRGaWxsRGlzYWJsZWRcIlxuICAgICAgICBtb2R1bGVEYXRhLnJlcGF5Q29uZmlybUJ0blRleHRDb2xvciA9IGlzUmlnaHQgPyBcIkBjb2xvci9LQmFzZVRleHRDb2xvclwiIDogXCJAY29sb3Iva0NvbG9yVGhyZWVMZXZlbFRleHRcIlxuICAgICAgICBtb2R1bGVEYXRhLnJlcGF5RXJyb3JWaXNpYmxlID0gaXNSaWdodCA/IFwiZ29uZVwiIDogXCJ2aXNpYmxlXCJcbiAgICAgICAgbW9kdWxlRGF0YS5pc1JlcGF5QnRuUmlnaHQgPSBpc1JpZ2h0XG4gICAgfVxuICAgIGNvbnNvbGUubG9nKGBtYXJnaW4taG9tZSByZWZyZXNoUmVwYXlCdG5TdGF0dXMgZnVuY3Rpb24gZW5kYCk7XG59XG5cbm1vZHVsZUV2ZW50Lm9uUmVwYXlFZGl0Rm9jdXNDaGFuZ2UgPSBhc3luYyBmdW5jdGlvbiAoaXNGb2N1cykge1xuICAgIG1vZHVsZURhdGEuaXNSZXBheUVkaXRGb2N1cyA9IGlzRm9jdXNcbiAgICByZWZyZXNoUmVwYXlCdG5TdGF0dXMoKVxufVxuXG5hc3luYyBmdW5jdGlvbiBvblJlcGF5VGV4dENoYW5nZSh0ZXh0KSB7XG4gICAgaWYgKHRleHQgIT0gXCJcIikge1xuICAgICAgICBsZXQgcmVwbGFjZVplcm8gPSB0ZXh0XG4gICAgICAgIGlmICh0ZXh0Lmxlbmd0aCA+IDEpIHtcbiAgICAgICAgICAgIHJlcGxhY2VaZXJvID0gZmlsdGVyTnVtYmVyU3RyKHRleHQpXG4gICAgICAgIH1cbiAgICAgICAgaWYgKHJlcGxhY2VaZXJvICE9IHRleHQpIHtcbiAgICAgICAgICAgIG1vZHVsZURhdGEucmVwYXlFZGl0VGV4dCA9IHJlcGxhY2VaZXJvXG4gICAgICAgIH1cbiAgICAgICAgbGV0IHRlbXBUZXh0ID0gYXdhaXQgY29tbW9uLmZvcm1hdERlY2ltYWwocmVwbGFjZVplcm8sIDgsIGZhbHNlKVxuICAgICAgICBpZiAodGVtcFRleHQgIT0gcmVwbGFjZVplcm8pIHtcbiAgICAgICAgICAgIG1vZHVsZURhdGEucmVwYXlFZGl0VGV4dCA9IHRlbXBUZXh0XG4gICAgICAgIH1cbiAgICB9XG4gICAgcmVmcmVzaFJlcGF5QnRuU3RhdHVzKClcbn1cblxubW9kdWxlRXZlbnQucmVwYXlDb25maXJtID0gYXN5bmMgZnVuY3Rpb24gKCkge1xuICAgIGNvbnNvbGUubG9nKGBtYXJnaW4taG9tZSByZXBheUNvbmZpcm0gZnVuY3Rpb24gc3RhcnRgKTtcbiAgICBpZiAobW9kdWxlRGF0YS5pc1JlcGF5QnRuUmlnaHQpIHtcbiAgICAgICAgY29tbW9uLnNob3dMb2FkaW5nKHRydWUpXG4gICAgICAgIGxldCByZXBheUNvZGUgPSAwXG4gICAgICAgIGlmIChtb2R1bGVEYXRhLnJlcGF5TWFyZ2luVHlwZSA9PSAxKSB7XG4gICAgICAgICAgICBsZXQgYWNjb3VudElkID0gY29tbW9uLmNvbW1vbkRhdGEuc3VwZXJNYXJnaW5BY2NvdW50SWRcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGBtYXJnaW4taG9tZSByZXBheUNvbmZpcm0gYWNjb3VudElkID0gJHthY2NvdW50SWR9YClcbiAgICAgICAgICAgIGlmIChhY2NvdW50SWQgPT0gbnVsbCB8fCBhY2NvdW50SWQgPT0gXCJcIiB8fCBhY2NvdW50SWQgPT0gXCJ1bmRlZmluZWRcIikge1xuICAgICAgICAgICAgICAgIGNvbW1vbi5zaG93TG9hZGluZyhmYWxzZSlcbiAgICAgICAgICAgICAgICByZXR1cm5cbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGxldCBwYXJhbXMgPSB7XG4gICAgICAgICAgICAgICAgY3VycmVuY3k6IG1hcmdpbkNyb3NzLmN1cnJlbmN5LFxuICAgICAgICAgICAgICAgIGFtb3VudDogbW9kdWxlRGF0YS5yZXBheUVkaXRUZXh0LFxuICAgICAgICAgICAgICAgIFwiYWNjb3VudC1pZFwiOiBhY2NvdW50SWQsXG4gICAgICAgICAgICAgICAgc291cmNlOiBjb21tb24uY29tbW9uRGF0YS5PUyA9PSAwID8gNCA6IDNcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIHJlcGF5Q29kZSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdFJldHVybkNvZGUoXCJ2MS9oYmcvc3VwZXItbWFyZ2luL3JlcGF5XCIsIHBhcmFtcywgMSwgNCwgeyBcIkNvbnRlbnQtVHlwZVwiOiBcImFwcGxpY2F0aW9uL2pzb25cIiB9KVxuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgbGV0IHBhcmFtcyA9IHtcbiAgICAgICAgICAgICAgICBzeW1ib2w6IG1hcmdpbklzb2xhdGVkLnN5bWJvbCxcbiAgICAgICAgICAgICAgICBjdXJyZW5jeTogbW9kdWxlRGF0YS5yZXBheUlzb2xhdGVkVHlwZSA9PSAxID8gbWFyZ2luSXNvbGF0ZWRbXCJiYXNlLWN1cnJlbmN5XCJdIDogbWFyZ2luSXNvbGF0ZWRbXCJxdW90YS1jdXJyZW5jeVwiXSxcbiAgICAgICAgICAgICAgICBhbW91bnQ6IG1vZHVsZURhdGEucmVwYXlFZGl0VGV4dFxuICAgICAgICAgICAgfVxuICAgICAgICAgICAgcmVwYXlDb2RlID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0UmV0dXJuQ29kZShcInYxL2hiZy9tYXJnaW4vcmVwYXlcIiwgcGFyYW1zLCAxLCA0LCB7IFwiQ29udGVudC1UeXBlXCI6IFwiYXBwbGljYXRpb24vanNvblwiIH0pXG4gICAgICAgIH1cbiAgICAgICAgY29tbW9uLnNob3dMb2FkaW5nKGZhbHNlKVxuICAgICAgICBpZiAocmVwYXlDb2RlID09IDIwMCkge1xuICAgICAgICAgICAgcmVxdWVzdERldGFpbCgpO1xuICAgICAgICAgICAgY29tbW9uLnNob3dUb2FzdCgkaTE4bi5uX21hcmdpbl9yZXBheW1lbnRfc3VjY2VzcylcbiAgICAgICAgICAgICRuYXRpdmVBUEkuY29udGFpbmVyQmFjaygpXG4gICAgICAgIH1cbiAgICB9XG4gICAgY29uc29sZS5sb2coYG1hcmdpbi1ob21lIHJlcGF5Q29uZmlybSBmdW5jdGlvbiBlbmRgKTtcbn1cblxubW9kdWxlRXZlbnQucmVwYXlBbGxCYWxhbmNlID0gYXN5bmMgZnVuY3Rpb24gKCkge1xuICAgIGNvbnNvbGUubG9nKGBtYXJnaW4taG9tZSByZXBheUFsbEJhbGFuY2UgZnVuY3Rpb24gc3RhcnRgKTtcbiAgICBpZiAobW9kdWxlRGF0YS5yZXBheU1hcmdpblR5cGUgPT0gMSkge1xuICAgICAgICBtb2R1bGVEYXRhLnJlcGF5RWRpdFRleHQgPSBnZXRNaW5OdW0oTnVtYmVyKG1hcmdpbkNyb3NzW1widHJhZGVcIl0pLCBOdW1iZXIobWFyZ2luQ3Jvc3MuZGVidCkpXG4gICAgfSBlbHNlIGlmIChtb2R1bGVEYXRhLnJlcGF5SXNvbGF0ZWRUeXBlID09IDEpe1xuICAgICAgICBtb2R1bGVEYXRhLnJlcGF5RWRpdFRleHQgPSBnZXRNaW5OdW0oTnVtYmVyKG1hcmdpbklzb2xhdGVkW1wiYmFzZS10cmFkZVwiXSksIE51bWJlcihtYXJnaW5Jc29sYXRlZFtcImJhc2UtZGVidFwiXSkpXG4gICAgfSBlbHNlIHtcbiAgICAgICAgbW9kdWxlRGF0YS5yZXBheUVkaXRUZXh0ID0gZ2V0TWluTnVtKE51bWJlcihtYXJnaW5Jc29sYXRlZFtcInF1b3RhLXRyYWRlXCJdKSwgTnVtYmVyKG1hcmdpbklzb2xhdGVkW1wicXVvdGEtZGVidFwiXSkpXG4gICAgfVxuICAgIG9uUmVwYXlUZXh0Q2hhbmdlKG1vZHVsZURhdGEucmVwYXlFZGl0VGV4dClcbiAgICBjb25zb2xlLmxvZyhgbWFyZ2luLWhvbWUgcmVwYXlBbGxCYWxhbmNlIGZ1bmN0aW9uIGVuZGApO1xufVxuXG5mdW5jdGlvbiBnZXRNaW5OdW0obnVtMSwgbnVtMikge1xuICAgIHJldHVybiAoTnVtYmVyKG51bTEpID4gTnVtYmVyKG51bTIpID8gTnVtYmVyKG51bTIpIDogTnVtYmVyKG51bTEpKSArIFwiXCJcbn1cblxuYXN5bmMgZnVuY3Rpb24gY2hhbmdlTGlzdFR5cGUodHlwZSkge1xuICAgIGlmICh0eXBlID09IDApIHtcbiAgICAgICAgaWYoY29tbW9uLmNvbW1vbkRhdGEubG9hbkN1cnJlbmN5TGlzdCA9PSBudWxsKSB7XG4gICAgICAgICAgICBhd2FpdCBjb21tb24uZ2V0Q3VycmVuY3lMaXN0KHR5cGUpO1xuICAgICAgICB9XG4gICAgICAgIGNvbW1vbi5jb21tb25EYXRhLmN1cnJlbmN5TGlzdCA9IGNvbW1vbi5jb21tb25EYXRhLmxvYW5DdXJyZW5jeUxpc3Q7XG4gICAgICAgIGlmKGNvbW1vbi5jb21tb25EYXRhLmxvYW5TeW1ib2xMaXN0ID09IG51bGwpIHtcbiAgICAgICAgICAgIGF3YWl0IGNvbW1vbi5nZXRTeW1ib2xMaXN0KHR5cGUpO1xuICAgICAgICB9XG4gICAgICAgIGNvbW1vbi5jb21tb25EYXRhLnN5bWJvbExpc3QgPSBjb21tb24uY29tbW9uRGF0YS5sb2FuU3ltYm9sTGlzdDtcbiAgICB9IGVsc2Uge1xuICAgICAgICBpZihjb21tb24uY29tbW9uRGF0YS5yZXBheUN1cnJlbmN5TGlzdCA9PSBudWxsKSB7XG4gICAgICAgICAgICBhd2FpdCBjb21tb24uZ2V0Q3VycmVuY3lMaXN0KHR5cGUpO1xuICAgICAgICB9IFxuICAgICAgICBjb21tb24uY29tbW9uRGF0YS5jdXJyZW5jeUxpc3QgPSBjb21tb24uY29tbW9uRGF0YS5yZXBheUN1cnJlbmN5TGlzdDtcbiAgICAgICAgaWYoY29tbW9uLmNvbW1vbkRhdGEucmVwYXlTeW1ib2xMaXN0ID09IG51bGwpIHtcbiAgICAgICAgICAgIGF3YWl0IGNvbW1vbi5nZXRTeW1ib2xMaXN0KHR5cGUpO1xuICAgICAgICB9IFxuICAgICAgICBjb21tb24uY29tbW9uRGF0YS5zeW1ib2xMaXN0ID0gY29tbW9uLmNvbW1vbkRhdGEucmVwYXlTeW1ib2xMaXN0O1xuICAgIH1cbn1cblxuYXN5bmMgZnVuY3Rpb24gdHJhbnNmZXIoKSB7XG4gICAgbGV0IGNvaW4gPSBcIlwiXG4gICAgbGV0IHN5bWJvbCA9IFwiXCJcbiAgICBsZXQgYWNjb3VudCA9IFwiXCJcbiAgICBsZXQgZGlzcGxheU1hcmdpblN5bWJvbCA9IFwiXCJcbiAgICBpZiAoKG1vZHVsZURhdGEuY3VycmVudEluZGV4ID09IDAgJiYgbW9kdWxlRGF0YS5sb2FuTWFyZ2luVHlwZSA9PSAxKSB8fCAobW9kdWxlRGF0YS5jdXJyZW50SW5kZXggPT0gMSAmJiBtb2R1bGVEYXRhLnJlcGF5TWFyZ2luVHlwZSA9PSAxKSkge1xuICAgICAgICBjb2luID0gbWFyZ2luQ3Jvc3MuY3VycmVuY3lcbiAgICAgICAgYWNjb3VudCA9IFwiNlwiXG4gICAgfSBlbHNlIHtcbiAgICAgICAgaWYgKGNvbW1vbi5jb21tb25EYXRhLk9TID09IDEpIHtcbiAgICAgICAgICAgIGlmICgobW9kdWxlRGF0YS5jdXJyZW50SW5kZXggPT0gMCAmJiBtb2R1bGVEYXRhLmxvYW5Jc29sYXRlZFR5cGUgPT0gMSkgfHwgKG1vZHVsZURhdGEuY3VycmVudEluZGV4ID09IDEgJiYgbW9kdWxlRGF0YS5yZXBheUlzb2xhdGVkVHlwZSA9PSAxKSkge1xuICAgICAgICAgICAgICAgIGNvaW4gPSBtYXJnaW5Jc29sYXRlZFtcImJhc2UtY3VycmVuY3lcIl1cbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgY29pbiA9IG1hcmdpbklzb2xhdGVkW1wicXVvdGEtY3VycmVuY3lcIl1cbiAgICAgICAgICAgIH1cbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGNvaW4gPSBtYXJnaW5Jc29sYXRlZFtcImRpc3BsYXktc3ltYm9sXCJdXG4gICAgICAgICAgICBpZiAoKG1vZHVsZURhdGEuY3VycmVudEluZGV4ID09IDAgJiYgbW9kdWxlRGF0YS5sb2FuSXNvbGF0ZWRUeXBlID09IDEpIHx8IChtb2R1bGVEYXRhLmN1cnJlbnRJbmRleCA9PSAxICYmIG1vZHVsZURhdGEucmVwYXlJc29sYXRlZFR5cGUgPT0gMSkpIHtcbiAgICAgICAgICAgICAgICBkaXNwbGF5TWFyZ2luU3ltYm9sID0gYCZkaXNwbGF5TWFyZ2luU3ltYm9sPSR7bWFyZ2luSXNvbGF0ZWRbXCJiYXNlLWN1cnJlbmN5XCJdfWBcbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgZGlzcGxheU1hcmdpblN5bWJvbCA9IGAmZGlzcGxheU1hcmdpblN5bWJvbD0ke21hcmdpbklzb2xhdGVkW1wicXVvdGEtY3VycmVuY3lcIl19YFxuICAgICAgICAgICAgfVxuICAgICAgICB9XG4gICAgICAgIHN5bWJvbD0gYCZzeW1ib2w9JHttYXJnaW5Jc29sYXRlZC5zeW1ib2x9YFxuICAgICAgICBhY2NvdW50ID0gXCIzXCJcbiAgICB9XG4gICAgZGlzcGxheU1hcmdpblN5bWJvbFxuICAgIGlmIChjb21tb24uY29tbW9uRGF0YS5PUyA9PSAxKSB7XG4gICAgICAgIGNvbW1vbi5vcGVuVVJMKGBob2xpZ2VpdDovL29wZW4vdjE/bG9naW49MSZ1cmw9aWh1b2JpZ2xvYmFsOi8vbS5oYmcuY29tL2JhbGFuY2UvdHJhbnNmZXI/Y29pbj0ke2NvaW59JmFjY291bnQ9JHthY2NvdW50fSR7c3ltYm9sfWApXG4gICAgfSBlbHNlIHtcbiAgICAgICAgY29tbW9uLm9wZW5VUkwoYGhvbGlnZWl0Oi8vb3Blbi92MT9sb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vYmFsYW5jZS90cmFuc2Zlcj9jb2luPSR7Y29pbn0mYWNjb3VudD0ke2FjY291bnR9JHtkaXNwbGF5TWFyZ2luU3ltYm9sfWApXG4gICAgfVxufVxuXG5tb2R1bGVFdmVudC5zaG93Q3VycmVuY3lQb3AgPSBhc3luYyBmdW5jdGlvbiAoKSB7XG4gICAgY2xvc2VLZXlib2FyZCgpXG4gICAgc2VsZWN0Q3VycmVuY3lQb3Auc2hvd1BvcChtb2R1bGVEYXRhLmN1cnJlbnRJbmRleCwgbW9kdWxlRGF0YS5jdXJyZW50SW5kZXggPT0gMCA/IG1vZHVsZURhdGEubG9hbk1hcmdpblR5cGUgOiBtb2R1bGVEYXRhLnJlcGF5TWFyZ2luVHlwZSwgcmVmcmVzaEN1cnJlbmN5RGF0YSlcbn1cblxuZnVuY3Rpb24gc2hvd09uZUJ0bkRpYWxvZyh0aXRsZSwgY29udGVudCkge1xuICAgIGxldCBidG5UZXh0ID0gJGkxOG4ubl9jb3B5X3RyYWRpbmdfbWVfa25vd1xuICAgIGNvbW1vblBvcC5wb3BVcENvbnRlbnRPZk9uZUJ1dHRvbih0aXRsZSwgY29udGVudCwgYnRuVGV4dClcbn1cblxubW9kdWxlRXZlbnQuaW50ZXJlc3RSdWxlc1RpcHMgPSBmdW5jdGlvbiAoKSB7XG4gICAgbGV0IHRpdGxlID0gJGkxOG4ubl9tYXJnaW5fY3VycmVuY3lfaW50ZXJlc3RfcmF0ZV9leHBsYWluXG4gICAgbGV0IGNvbnRlbnQgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fbWFyZ2luX2ludGVyZXN0X2JvcnJvd2VkX3RpcHMobW9kdWxlRGF0YS5sb2FuTWFyZ2luVHlwZSA9PSAxID8gYCR7Zml4ZWROdW0obWFyZ2luQ3Jvc3NbXCJpbnRlcmVzdC1yYXRlXCJdICogMTAwKX0lYCA6IG1vZHVsZURhdGEubG9hbklzb2xhdGVkVHlwZSA9PSAxID8gYCR7Zml4ZWROdW0obWFyZ2luSXNvbGF0ZWRbXCJiYXNlLWludGVyZXN0LXJhdGVcIl0gKiAxMDApfSVgIDogYCR7Zml4ZWROdW0obWFyZ2luSXNvbGF0ZWRbXCJxdW90YS1pbnRlcmVzdC1yYXRlXCJdICogMTAwKX0lYClcbiAgICBzaG93T25lQnRuRGlhbG9nKHRpdGxlLCBjb250ZW50KVxufVxuXG5tb2R1bGVFdmVudC5tYXhpbXVtTG9hbkV4cGxhaW5lZFRpcHMgPSBmdW5jdGlvbiAoKSB7XG4gICAgbGV0IHRpdGxlID0gJGkxOG4ubl9tYXJnaW5fbWF4aW11bV9sb2FuX2Ftb3VudF9leHBsYWluXG4gICAgbGV0IGNvbnRlbnQgPSAkaTE4bi5uX21hcmdpbl9tYXhpbXVtX2xvYW5fYW1vdW50X3RpcHNcbiAgICBzaG93T25lQnRuRGlhbG9nKHRpdGxlLCBjb250ZW50KVxufVxuXG5tb2R1bGVFdmVudC50b3RhbERlYnRFeHBsYWluZWRUaXBzID0gZnVuY3Rpb24gKCkge1xuICAgIGxldCB0aXRsZSA9ICRpMThuLm5fbWFyZ2luX3RvdGFsX2xpYWJpbGl0aWVzX2V4cGxhaW5cbiAgICBsZXQgY29udGVudCA9ICRpMThuLm5fbWFyZ2luX3RvdGFsX2xpYWJpbGl0aWVzX2NvbnRlbnRcbiAgICBzaG93T25lQnRuRGlhbG9nKHRpdGxlLCBjb250ZW50KVxufVxuXG5tb2R1bGVFdmVudC50b0xvYW5MaW1pdCA9IGFzeW5jIGZ1bmN0aW9uICh0eXBlKSB7XG4gICAgY29tbW9uLm9wZW5VUkwoYCR7Y29tbW9uLmNvbW1vbkRhdGEud2ViVXJsfS8ke2NvbW1vbi5jb21tb25EYXRhLmxhbmd1YWdlfS8ke21vZHVsZURhdGEubG9hbk1hcmdpblR5cGUgPT0gMSA/IENST1NTX01BUkdJTl9MQURERVJfTEVORElORyA6IE1BUkdJTl9MQURERVJfTEVORElOR30ke21vZHVsZURhdGEubG9hbk1hcmdpblR5cGUgPT0gMSA/IG1hcmdpbkNyb3NzLmN1cnJlbmN5IDogbWFyZ2luSXNvbGF0ZWQuc3ltYm9sfWApXG59XG5cbm1vZHVsZUV2ZW50Lmp1bXBUaXBzID0gZnVuY3Rpb24gKCkge1xuICAgIGNvbW1vbi5vcGVuVVJMKGAke2NvbW1vbi5jb21tb25EYXRhLndlYlVybH0vc3VwcG9ydC8ke2NvbW1vbi5jb21tb25EYXRhLmxhbmd1YWdlfS9kZXRhaWwvMjQ5MzAzMTUyNzM4MTNgKVxufVxuXG5mdW5jdGlvbiBjbG9zZUtleWJvYXJkKCkge1xuICAgIG1vZHVsZURhdGEuaXNMb2FuRWRpdEZvY3VzID0gZmFsc2VcbiAgICBtb2R1bGVEYXRhLmlzUmVwYXlFZGl0Rm9jdXMgPSBmYWxzZVxuICAgIGlmIChjb21tb24uY29tbW9uRGF0YS5PUyA9PSAxKSB7XG4gICAgICAgICRuYXRpdmVBUEkuY2xvc2VLZXlib2FyZCgpXG4gICAgfVxufVxuXG5tb2R1bGVFdmVudC50cmFuc2ZlciA9IHRyYW5zZmVyXG5tb2R1bGVFdmVudC5yZXNldFRpdGxlU2VsZWN0VGFiID0gcmVzZXRUaXRsZVNlbGVjdFRhYlxubW9kdWxlRXZlbnQub25Mb2FuVGV4dENoYW5nZSA9IG9uTG9hblRleHRDaGFuZ2Vcbm1vZHVsZUV2ZW50Lm9uUmVwYXlUZXh0Q2hhbmdlID0gb25SZXBheVRleHRDaGFuZ2UiLCJpbXBvcnQgKiBhcyBjb21tb24gZnJvbSAnLi9jb21tb24nXG5pbXBvcnQgKiBhcyBudW1iZXIgZnJvbSBcIi4vbnVtYmVyXCI7XG5pbXBvcnQgKiBhcyBjb21tb25Qb3AgZnJvbSAnLi9jb21tb25Qb3AnXG5cbi8v5qCH6aKY6aKc6ImyXG52YXIgdGl0bGVDb2xvcl9Ob3JtYWwgPSBcIkBjb2xvci9rQ29sb3JUaHJlZUxldmVsVGV4dFwiO1xudmFyIHRpdGxlQ29sb3JfU2VsZWN0ZWQgPSBcIkBjb2xvci9rQ29sb3JQcmltYXJ5VGV4dFwiO1xuXG4vL+i+k+WFpeahhuebuOWFs+minOiJslxuY29uc3QgRWRpdF9Cb2FyZF9TZWxlY3RDb2xvciA9IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIjtcbmNvbnN0IEVkaXRfQm9hcmRfTm9tYWxDb2xvciA9IFwiQGNvbG9yL0tCYXNlQ29sb3JDb250ZW50QmFja2dyb3VuZFwiO1xuXG4vL+aMiemSruminOiJslxuY29uc3QgYnV0dG9uVGl0bGVDb2xvcl9Ob3JtYWwgPSBcIkBjb2xvci9rQ29sb3JQcmltYXJ5VGV4dFwiO1xuY29uc3QgYnV0dG9uVGl0bGVDb2xvcl9TZWxlY3RlZCA9IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIjtcblxuY29uc3QgYnV0dG9uQmFja0NvbG9yX05vcm1hbCA9IFwiQGNvbG9yL0tCYXNlQ29sb3JJbnB1dEJhY2tncm91bmRcIjtcbmNvbnN0IGJ1dHRvbkJhY2tDb2xvcl9TZWxlY3RlZCA9IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUwMDZcIjtcblxuLy/lhajku5PliJfooahcbnZhciBzdXBwb3J0Q3VycmVuY2llcyA9IFtdXG5cbi8v6YCQ5LuT5YiX6KGoXG52YXIgc3VwcG9ydFN5bWJvbHMgPSBbXVxuXG52YXIgaXNDYW5jZWxTZWFyY2ggPSBmYWxzZVxuXG4vL+aooeW8jyAxLeWFqOS7kyAyLemAkOS7k1xudmFyIE1vZGVUeXBlID0ge1xuICAgIHN1cGVyTWFyZ2luOiAxLFxuICAgIGlzb2xhdGVNYXJnaW46IDIsXG59O1xuXG4vL+mhtemdouaooeW8jyAwIOWAn+asvuWOhuWPsiAxIOi/mOasvuWOhuWPsiAyIOWIqeaBr+WOhuWPslxudmFyIFRhYlR5cGUgPSB7XG4gICAgVGFiVHlwZUxvYW46IDAsXG4gICAgVGFiVHlwZVJlcGF5OiAxLFxuICAgIFRhYlR5cGVJbnRlcmVzdDogMixcbn07XG5cbnZhciBsaW1pdCA9IDEwO1xuXG52YXIgY29tbW9uTGlzdCA9IFtnZXRUYWJMaXN0RGVmYXVsdERhdGEoKSwgZ2V0VGFiTGlzdERlZmF1bHREYXRhKCksIGdldFRhYkxpc3REZWZhdWx0RGF0YSgpXTtcbnZhciBjb21tb25GaWx0ZXJUeXBlcyA9IFtdO1xuXG4vL+WIneWni+WMluaVsOaNrlxuZnVuY3Rpb24gZGVmYXVsdERhdGEoKSB7XG4gICAgcmV0dXJuIHtcbiAgICAgICAgY3VycmVudFRhYlR5cGU6IFRhYlR5cGUuVGFiVHlwZUxvYW4sXG4gICAgICAgIGN1ckZpbHRlclR5cGVJbmRleDogMCxcbiAgICAgICAgdHlwZUhlaWdodDogNTAsXG4gICAgICAgIGxvYWRNb3JlU3RhdHVzOiBcIjBcIixcbiAgICAgICAgcmVmcmVzaFN0YXR1czogXCIwXCIsXG4gICAgICAgIGxpc3REYXRhOiBjb21tb25MaXN0LFxuICAgICAgICBtb2RlVHlwZUljb246IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2Fycm93X2Rvd25cIixcbiAgICAgICAgY3VycmVuY3lJY29uOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9hcnJvd19kb3duXCIsXG4gICAgICAgIGZpbHRlckN1cnJlbmNpZXM6IFtdLFxuICAgICAgICBib3JkZXJDb2xvcjogRWRpdF9Cb2FyZF9Ob21hbENvbG9yLFxuICAgICAgICBjbGVhclZpc2libGU6IFwiZ29uZVwiLFxuICAgICAgICBmaWx0ZXJUaW1lczogW3sgdHlwZTogXCJub3JtYWxcIiwgdGl0bGU6ICRpMThuLm5fb3JkZXJfZmlsdGVyX25lYXJseV9hX3dlZWssIHRpdGxlQ29sb3I6IGJ1dHRvblRpdGxlQ29sb3JfTm9ybWFsLCB0aW1lQmFja0NvbG9yOiBidXR0b25CYWNrQ29sb3JfTm9ybWFsLCB0YWc6IDAgfSxcbiAgICAgICAgeyB0eXBlOiBcIm5vcm1hbFwiLCB0aXRsZTogJGkxOG4ubl9vcmRlcl9maWx0ZXJfbmVhcmx5X2FfbW9udGgsIHRpdGxlQ29sb3I6IGJ1dHRvblRpdGxlQ29sb3JfTm9ybWFsLCB0aW1lQmFja0NvbG9yOiBidXR0b25CYWNrQ29sb3JfTm9ybWFsLCB0YWc6IDEgfSxcbiAgICAgICAgeyB0eXBlOiBcIm5vcm1hbFwiLCB0aXRsZTogJGkxOG4ubl9vcmRlcl9maWx0ZXJfbmVhcmx5XzEyMF9kYXlzLCB0aXRsZUNvbG9yOiBidXR0b25UaXRsZUNvbG9yX1NlbGVjdGVkLCB0aW1lQmFja0NvbG9yOiBidXR0b25CYWNrQ29sb3JfU2VsZWN0ZWQsIHRhZzogMiB9XSxcbiAgICB9O1xufVxuXG5jb25zdCB7IG1vZHVsZURhdGEsIG1vZHVsZUV2ZW50IH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFwibGV2ZXJIaXN0b3J5XCIsIHN0YXJ0LCBkZWZhdWx0RGF0YSk7XG5cbi8v5Yid5aeL5YyWXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc3RhcnQoKSB7XG59XG5cbm1vZHVsZUV2ZW50Lm9uQ3JlYXRlID0gYXN5bmMgZnVuY3Rpb24gKGV2ZW50UGFyYW1zKSB7XG4gICAgbW9kdWxlRGF0YS5jb25maWcgPSB7IFwiYmFja2dyb3VuZENvbG9yXCI6IFwia0NvbG9yQ29udGVudEJhY2tncm91bmRcIiB9O1xuICAgIGNvbnN0IHBhcmFtcyA9IEpTT04ucGFyc2UoZXZlbnRQYXJhbXMpO1xuICAgIGNvbnNvbGUubG9nKGB3cCAtLS0tLW9uQ3JlYXRlID0gJHtKU09OLnN0cmluZ2lmeShwYXJhbXMpfWApO1xuICAgIGlmIChwYXJhbXMudGFiVHlwZSAhPSBudWxsKSB7XG4gICAgICAgIG1vZHVsZURhdGEuY3VycmVudFRhYlR5cGUgPSBwYXJhbXMudGFiVHlwZTtcbiAgICB9IGVsc2Uge1xuICAgICAgICBtb2R1bGVEYXRhLmN1cnJlbnRUYWJUeXBlID0gVGFiVHlwZS5UYWJUeXBlTG9hbjtcbiAgICB9XG4gICAgbW9kdWxlRGF0YS50aXRsZURhdGEgPSBnZXRUYWJUaXRsZURhdGEoKTtcbiAgICBpZiAocGFyYW1zLm1vZGVUeXBlICE9IG51bGwpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5jdXJNb2RlVHlwZSA9IHBhcmFtcy5tb2RlVHlwZTtcbiAgICAgICAgc2V0TW9kZVR5cGVEYXRhKHBhcmFtcy5tb2RlVHlwZSk7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgbW9kdWxlRGF0YS5jdXJNb2RlVHlwZSA9IE1vZGVUeXBlLnN1cGVyTWFyZ2luO1xuICAgICAgICBzZXRNb2RlVHlwZURhdGEoTW9kZVR5cGUuc3VwZXJNYXJnaW4pO1xuICAgIH1cbiAgICBpZiAocGFyYW1zLnN5bWJvbCAhPSBudWxsKSB7XG4gICAgICAgIGxldCBzeW1ib2wgPSBwYXJhbXMuc3ltYm9sLnRvTG93ZXJDYXNlKClcbiAgICAgICAgY29uc29sZS5sb2coYHdwIG9uQ3JlYXRlIHN5bWJvbCA9ICR7c3ltYm9sfWApO1xuICAgICAgICBtb2R1bGVEYXRhLmN1clN5bWJvbCA9IHN5bWJvbDtcbiAgICAgICAgaWYocGFyYW1zLm1vZGVUeXBlID09IE1vZGVUeXBlLmlzb2xhdGVNYXJnaW4pIHtcbiAgICAgICAgICAgIG1vZHVsZURhdGEuY3VycmVuY3lUZXh0ID0gYXdhaXQgY29tbW9uLmdldFN5bWJvbERpc3BsYXlOYW1lKHN5bWJvbCk7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLmN1cnJlbmN5VGV4dCA9IHN5bWJvbC50b1VwcGVyQ2FzZSgpO1xuICAgICAgICB9XG4gICAgfSBlbHNlIHtcbiAgICAgICAgbW9kdWxlRGF0YS5jdXJyZW5jeVRleHQgPSAobW9kdWxlRGF0YS5jdXJNb2RlVHlwZSA9PSBNb2RlVHlwZS5zdXBlck1hcmdpbikgPyAkaTE4bi5uX2Vhcm5fYWxsX2NvaW4gOiAkaTE4bi5uX21hcmdpbl9hbGxfY3VycmVuY3k7XG4gICAgICAgIG1vZHVsZURhdGEuY3VyRmlsdGVyQ3VycmVuY3lJbmRleCA9IDA7XG4gICAgICAgIG1vZHVsZURhdGEuY3VyU3ltYm9sID0gbnVsbDtcbiAgICB9XG4gICAgZGVmYXVsdEZpbHRlckRhdGEoKTtcbiAgICBjb21tb25GaWx0ZXJUeXBlcyA9IGdldEZpbHRlck1vcmVUeXBlcygpO1xuICAgIG1vZHVsZURhdGEuZmlsdGVyVHlwZXMgPSBjb21tb25GaWx0ZXJUeXBlcztcbiAgICByZXF1ZXN0RGF0YShmYWxzZSk7XG4gICAgcmVxdWVzdFN1cGVyTWFyZ2luQ3VycmVuY2llcygpO1xuICAgIHJlcXVlc3RNYXJnaW5TeW1ib2xzKCk7XG59XG5cbm1vZHVsZUV2ZW50Lm9uRGVzdHJveSA9IGFzeW5jIGZ1bmN0aW9uICgpIHtcbiAgICBjb21tb25MaXN0ID0gW2dldFRhYkxpc3REZWZhdWx0RGF0YSgpLCBnZXRUYWJMaXN0RGVmYXVsdERhdGEoKSwgZ2V0VGFiTGlzdERlZmF1bHREYXRhKCldO1xuICAgIG1vZHVsZURhdGEubGlzdERhdGEgPSBjb21tb25MaXN0O1xufVxuXG5tb2R1bGVFdmVudC5vblJlc3VtZSA9IGFzeW5jIGZ1bmN0aW9uICgpIHtcbn1cblxubW9kdWxlRXZlbnQub25QYXVzZSA9IGFzeW5jIGZ1bmN0aW9uICgpIHtcbn1cblxubW9kdWxlRXZlbnQub25TdG9wID0gYXN5bmMgZnVuY3Rpb24gKCkge1xufVxuXG5tb2R1bGVFdmVudC5vblN0YXJ0ID0gYXN5bmMgZnVuY3Rpb24gKCkge1xufVxuXG5tb2R1bGVFdmVudC5iYWNrID0gYXN5bmMgZnVuY3Rpb24gKCkge1xuICAgICRuYXRpdmVBUEkuY29udGFpbmVyQmFjaygpO1xufVxuXG5hc3luYyBmdW5jdGlvbiBmaWx0ZXJDbGljayhpbmRleCkge1xuICAgIGlmIChpbmRleCA9PSAwKSB7XG4gICAgICAgIG1vZHVsZURhdGEubW9kZVR5cGVTaG93ID0gXCJ0cnVlXCI7XG4gICAgICAgIG1vZHVsZURhdGEubW9kZVR5cGVJY29uID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfYXJyb3dfdXBcIjtcbiAgICB9IGVsc2UgaWYgKGluZGV4ID09IDEpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5jdXJyZW5jeVNob3cgPSBcInRydWVcIjtcbiAgICAgICAgbW9kdWxlRGF0YS5jdXJyZW5jeUljb24gPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9hcnJvd191cFwiO1xuICAgICAgICBtb2R1bGVEYXRhLmZpbHRlckN1cnJlbmNpZXMgPSAobW9kdWxlRGF0YS5jdXJNb2RlVHlwZSA9PSBNb2RlVHlwZS5zdXBlck1hcmdpbikgPyBzdXBwb3J0Q3VycmVuY2llcyA6IHN1cHBvcnRTeW1ib2xzO1xuICAgICAgICBtb2R1bGVEYXRhLnNlYXJjaFdvcmQgPSBcIlwiO1xuICAgICAgICByZXNldEN1cnJlbmN5U2VhcmNoVUkoKTtcbiAgICB9IGVsc2UgaWYgKGluZGV4ID09IDIpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5maWx0ZXJNb3JlU2hvdyA9IFwidHJ1ZVwiO1xuICAgIH1cbn1cblxuYXN5bmMgZnVuY3Rpb24gdGFiQ2xpY2sodGFiVHlwZSkge1xuICAgIG1vZHVsZURhdGEubG9hZE1vcmVTdGF0dXMgPSBcIjBcIjtcbiAgICBtb2R1bGVEYXRhLnJlZnJlc2hTdGF0dXMgPSBcIjBcIjtcbiAgICBtb2R1bGVEYXRhLmN1cnJlbnRUYWJUeXBlID0gdGFiVHlwZTtcbiAgICAvLyBhd2FpdCByZXNldFRpdGxlU2VsZWN0VGFiKHRhYlR5cGUpO1xufVxuXG5hc3luYyBmdW5jdGlvbiByZXNldFRpdGxlU2VsZWN0VGFiKGluZGV4KSB7XG4gICAgY29uc29sZS5sb2coYHdwIC0tLS0tcmVzZXRUaXRsZVNlbGVjdFRhYiA9ICR7aW5kZXh9YCk7XG4gICAgdmFyIHNlbGVjdGVkSXRlbSA9IG51bGw7XG4gICAgZm9yICh2YXIgaSA9IDA7IGkgPCBtb2R1bGVEYXRhLnRpdGxlRGF0YS5sZW5ndGg7IGkrKykge1xuICAgICAgICB2YXIgaXRlbSA9IG1vZHVsZURhdGEudGl0bGVEYXRhW2ldO1xuICAgICAgICBpZiAoaSA9PSBpbmRleCkge1xuICAgICAgICAgICAgc2VsZWN0ZWRJdGVtID0gaXRlbTtcbiAgICAgICAgfVxuICAgICAgICBpdGVtLnRpdGxlQ29sb3IgPSB0aXRsZUNvbG9yX05vcm1hbDtcbiAgICB9XG5cbiAgICBpZiAoc2VsZWN0ZWRJdGVtICE9IG51bGwpIHtcbiAgICAgICAgc2VsZWN0ZWRJdGVtLnRpdGxlQ29sb3IgPSB0aXRsZUNvbG9yX1NlbGVjdGVkO1xuICAgIH1cbiAgICBjb25zb2xlLmxvZyhgd3AgLS0tLS1yZXNldFRpdGxlU2VsZWN0VGFiICBtb2R1bGVEYXRhLmN1cnJlbnRUYWJUeXBlPSAke21vZHVsZURhdGEuY3VycmVudFRhYlR5cGV9YCk7XG4gICAgLy/pu5jorqTlhajpg6jnsbvlnotcbiAgICBjb21tb25GaWx0ZXJUeXBlcyA9IGdldEZpbHRlck1vcmVUeXBlcygpO1xuICAgIG1vZHVsZURhdGEuZmlsdGVyVHlwZXMgPSBjb21tb25GaWx0ZXJUeXBlcztcbiAgICBtb2R1bGVEYXRhLmN1ckZpbHRlclR5cGVJbmRleCA9IDA7XG4gICAgZmlsdGVyVHlwZSgwKTtcbiAgICAvLyByZXNldEN1cnJlbmN5SW5kZXgoKTtcbiAgICByZXF1ZXN0RGF0YShmYWxzZSk7XG4gICAgbW9kdWxlRGF0YS50eXBlSGVpZ2h0ID0gbW9kdWxlRGF0YS5jdXJyZW50VGFiVHlwZSA9PSBUYWJUeXBlLlRhYlR5cGVSZXBheSA/IDEwMCA6IDUwO1xufVxuXG4vL+aOpeWPo+ivt+axglxuYXN5bmMgZnVuY3Rpb24gcmVxdWVzdERhdGEoaXNNb3JlKSB7XG4gICAgaWYgKG1vZHVsZURhdGEuY3VycmVudFRhYlR5cGUgPT0gVGFiVHlwZS5UYWJUeXBlTG9hbikge1xuICAgICAgICByZXF1ZXN0TG9hbkhpc3RvcnkoaXNNb3JlKTtcbiAgICB9IGVsc2UgaWYgKG1vZHVsZURhdGEuY3VycmVudFRhYlR5cGUgPT0gVGFiVHlwZS5UYWJUeXBlUmVwYXkpIHtcbiAgICAgICAgcmVxdWVzdFJlcGF5SGlzdG9yeShpc01vcmUpO1xuICAgIH0gZWxzZSBpZiAobW9kdWxlRGF0YS5jdXJyZW50VGFiVHlwZSA9PSBUYWJUeXBlLlRhYlR5cGVJbnRlcmVzdCkge1xuICAgICAgICByZXF1ZXN0SW50ZXJlc3RIaXN0b3J5KGlzTW9yZSk7XG4gICAgfVxufVxuXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0TG9hbkhpc3RvcnkoaXNNb3JlKSB7XG4gICAgdmFyIHBhcmFtcyA9IHtcbiAgICAgICAgbGltaXQ6IGxpbWl0XG4gICAgfTtcbiAgICBwYXJhbXNbXCJiZWdpbi10aW1lXCJdID0gZ2V0U3RhcnRUaW1lc3RhbXAoKTtcbiAgICBwYXJhbXNbXCJlbmQtdGltZVwiXSA9IGdldEVuZFRpbWVzdGFtcCgpO1xuICAgIGlmIChtb2R1bGVEYXRhLmN1ckZpbHRlckN1cnJlbmN5SW5kZXggIT0gMCkge1xuICAgICAgICBpZiAobW9kdWxlRGF0YS5jdXJNb2RlVHlwZSA9PSBNb2RlVHlwZS5zdXBlck1hcmdpbikge1xuICAgICAgICAgICAgcGFyYW1zW1wiY3VycmVuY3lcIl0gPSBtb2R1bGVEYXRhLmN1cnJlbmN5VGV4dC50b0xvd2VyQ2FzZSgpO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgcGFyYW1zW1wic3ltYm9sXCJdID0gbW9kdWxlRGF0YS5jdXJTeW1ib2wudG9Mb3dlckNhc2UoKTtcbiAgICAgICAgfVxuICAgIH1cbiAgICBpZiAobW9kdWxlRGF0YS5jdXJGaWx0ZXJUeXBlSW5kZXggIT0gMCkge1xuICAgICAgICB2YXIgaXRlbSA9IG1vZHVsZURhdGEuZmlsdGVyVHlwZXNbbW9kdWxlRGF0YS5jdXJGaWx0ZXJUeXBlSW5kZXhdO1xuICAgICAgICBwYXJhbXNbXCJ0eXBlXCJdID0gaXRlbS50YWc7XG4gICAgfVxuICAgIHZhciBsb2FuRGF0YSA9IGNvbW1vbkxpc3RbVGFiVHlwZS5UYWJUeXBlTG9hbl07XG4gICAgaWYgKGlzTW9yZSkge1xuICAgICAgICBwYXJhbXNbXCJmcm9tXCJdID0gbG9hbkRhdGEuZnJvbTtcbiAgICB9XG4gICAgaWYobG9hbkRhdGEuc2hvd0xvYWRpbmcpIHtcbiAgICAgICAgY29tbW9uLnNob3dMb2FkaW5nKHRydWUpO1xuICAgIH1cblxuICAgIHZhciB1cmwgPSBcInYxL2hiZy9tYXJnaW4vbG9hbi9oaXN0b3J5XCI7XG4gICAgaWYgKG1vZHVsZURhdGEuY3VyTW9kZVR5cGUgPT0gTW9kZVR5cGUuc3VwZXJNYXJnaW4pIHtcbiAgICAgICAgdXJsID0gXCJ2MS9oYmcvc3VwZXItbWFyZ2luL2xvYW4vaGlzdG9yeVwiO1xuICAgIH1cbiAgICBsZXQgZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdCh1cmwsIHBhcmFtcywgMCwgNCwgeyBcIkNvbnRlbnQtVHlwZVwiOiBcImFwcGxpY2F0aW9uL2pzb25cIiB9KTtcbiAgICBjb21tb24uc2hvd0xvYWRpbmcoZmFsc2UpO1xuICAgIGNvbnNvbGUubG9nKGB3cCByZXF1ZXN0TG9hbkhpc3RvcnkgZGF0YSA9JHtkYXRhfWApO1xuICAgIHRyeSB7XG4gICAgICAgIGlmICghaXNNb3JlKSB7XG4gICAgICAgICAgICBjb21tb25MaXN0W1RhYlR5cGUuVGFiVHlwZUxvYW5dID0gZ2V0VGFiTGlzdERlZmF1bHREYXRhKCk7XG4gICAgICAgICAgICBpZiAoIWRhdGEgfHwgZGF0YSA9PSBudWxsIHx8IGRhdGEubGVuZ3RoID09IDApIHtcbiAgICAgICAgICAgICAgICBjb21tb25MaXN0W1RhYlR5cGUuVGFiVHlwZUxvYW5dID0ge1xuICAgICAgICAgICAgICAgICAgICBkYXRhOiBbXSxcbiAgICAgICAgICAgICAgICAgICAgZW1wdHlWaXNpYmxlOiBcInZpc2libGVcIixcbiAgICAgICAgICAgICAgICAgICAgbGlzdFZpc2libGU6IFwiZ29uZVwiLFxuICAgICAgICAgICAgICAgICAgICBzaG93TG9hZGluZzogdHJ1ZSxcbiAgICAgICAgICAgICAgICAgICAgZnJvbTogLTEsXG4gICAgICAgICAgICAgICAgfTtcbiAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLmxpc3REYXRhID0gY29tbW9uTGlzdDtcbiAgICAgICAgICAgICAgICByZXR1cm47XG4gICAgICAgICAgICB9XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLmxvYWRNb3JlU3RhdHVzID0gXCIyXCI7XG4gICAgICAgIH1cbiAgICAgICAgaGFuZGxlTG9hbkhpc3RvcnlEYXRhKGRhdGEpO1xuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5sb2coYGhhbmRsZSBoYW5kbGVMb2FuSGlzdG9yeURhdGEgZGF0YSBlcnJvcj0ke2V9YCk7XG4gICAgfVxufVxuXG5hc3luYyBmdW5jdGlvbiBoYW5kbGVMb2FuSGlzdG9yeURhdGEoaGlzdG9yeXMpIHtcbiAgICB2YXIgbG9hbkRhdGEgPSBjb21tb25MaXN0W1RhYlR5cGUuVGFiVHlwZUxvYW5dO1xuICAgIHZhciBsb2FucyA9IGxvYW5EYXRhLmRhdGE7XG4gICAgbG9hbkRhdGEuZW1wdHlWaXNpYmxlID0gXCJnb25lXCI7XG4gICAgbG9hbkRhdGEubGlzdFZpc2libGUgPSBcInZpc2libGVcIjtcbiAgICBsb2FuRGF0YS5zaG93TG9hZGluZyA9IGZhbHNlO1xuICAgIGlmIChoaXN0b3J5cy5sZW5ndGggPT0gbGltaXQpIHtcbiAgICAgICAgbGV0IGxhc3RMb2FuID0gaGlzdG9yeXNbaGlzdG9yeXMubGVuZ3RoIC0gMV07XG4gICAgICAgIGxvYW5EYXRhLmZyb20gPSBsYXN0TG9hbi5pZDtcbiAgICB9IGVsc2Uge1xuICAgICAgICBsb2FuRGF0YS5mcm9tID0gLTE7XG4gICAgfVxuICAgIGNvbnNvbGUubG9nKGB3cCBoYW5kbGVMb2FuSGlzdG9yeURhdGEgbG9hbnMgPSR7bG9hbnN9YCk7XG4gICAgZm9yIChsZXQgaSA9IDA7IGkgPCBoaXN0b3J5cy5sZW5ndGg7ICsraSkge1xuICAgICAgICBsZXQgdiA9IGhpc3RvcnlzW2ldO1xuICAgICAgICB2LmluZGV4ID0gbG9hbnMubGVuZ3RoO1xuICAgICAgICB2LnRhZyA9IGxvYW5zLmxlbmd0aDtcbiAgICAgICAgaWYgKG1vZHVsZURhdGEuY3VyTW9kZVR5cGUgPT0gTW9kZVR5cGUuc3VwZXJNYXJnaW4pIHtcbiAgICAgICAgICAgIHYudGl0bGUgPSB2LmN1cnJlbmN5LnRvVXBwZXJDYXNlKCk7XG4gICAgICAgICAgICB2LmN1cnJlbmN5VmlzaWJsZSA9IFwiZ29uZVwiO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgdi50aXRsZSA9IHZbXCJkaXNwbGF5LXN5bWJvbFwiXS50b1VwcGVyQ2FzZSgpO1xuICAgICAgICAgICAgdi5jdXJyZW5jeSA9IHYuY3VycmVuY3kudG9VcHBlckNhc2UoKTtcbiAgICAgICAgICAgIHYuY3VycmVuY3lWaXNpYmxlID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgIH1cbiAgICAgICAgdi5sb2FuVHlwZSA9IHYudHlwZTtcbiAgICAgICAgdi50eXBlQ29udGVudCA9IGdldFR5cGVDb250ZW50KHYubG9hblR5cGUpO1xuICAgICAgICB2LnR5cGUgPSBcImxvYW5cIjtcbiAgICAgICAgdi5sb2FuQW1vdW50ID0gY29tbW9uLnRob3VzYW5kc0Zvcm1hdHRlcih2W1wibG9hbi1hbW91bnRcIl0pO1xuICAgICAgICB2LnRpbWUgPSBuZXcgRGF0ZSh2LnRpbWUpLkZvcm1hdChcInl5eXktTU0tZGQgaGg6bW06c3NcIik7XG4gICAgICAgIGxvYW5zLnB1c2godik7XG4gICAgfTtcbiAgICBtb2R1bGVEYXRhLmxpc3REYXRhID0gY29tbW9uTGlzdDtcbn1cblxuYXN5bmMgZnVuY3Rpb24gcmVxdWVzdFJlcGF5SGlzdG9yeShpc01vcmUpIHtcbiAgICB2YXIgcGFyYW1zID0ge1xuICAgICAgICBsaW1pdDogbGltaXRcbiAgICB9O1xuICAgIHBhcmFtc1tcImJlZ2luLXRpbWVcIl0gPSBnZXRTdGFydFRpbWVzdGFtcCgpO1xuICAgIHBhcmFtc1tcImVuZC10aW1lXCJdID0gZ2V0RW5kVGltZXN0YW1wKCk7XG4gICAgaWYgKG1vZHVsZURhdGEuY3VyRmlsdGVyQ3VycmVuY3lJbmRleCAhPSAwKSB7XG4gICAgICAgIGlmIChtb2R1bGVEYXRhLmN1ck1vZGVUeXBlID09IE1vZGVUeXBlLnN1cGVyTWFyZ2luKSB7XG4gICAgICAgICAgICBwYXJhbXNbXCJjdXJyZW5jeVwiXSA9IG1vZHVsZURhdGEuY3VycmVuY3lUZXh0LnRvTG93ZXJDYXNlKCk7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBwYXJhbXNbXCJzeW1ib2xcIl0gPSBtb2R1bGVEYXRhLmN1clN5bWJvbC50b0xvd2VyQ2FzZSgpO1xuICAgICAgICB9XG4gICAgfVxuICAgIGlmIChtb2R1bGVEYXRhLmN1ckZpbHRlclR5cGVJbmRleCAhPSAwKSB7XG4gICAgICAgIHZhciBpdGVtID0gbW9kdWxlRGF0YS5maWx0ZXJUeXBlc1ttb2R1bGVEYXRhLmN1ckZpbHRlclR5cGVJbmRleF07XG4gICAgICAgIHBhcmFtc1tcInR5cGVcIl0gPSBpdGVtLnRhZztcbiAgICB9XG4gICAgdmFyIHJlcGF5RGF0YSA9IGNvbW1vbkxpc3RbVGFiVHlwZS5UYWJUeXBlUmVwYXldO1xuICAgIGlmIChpc01vcmUpIHtcbiAgICAgICAgcGFyYW1zW1wiZnJvbVwiXSA9IHJlcGF5RGF0YS5mcm9tO1xuICAgIH1cbiAgICBpZihyZXBheURhdGEuc2hvd0xvYWRpbmcpIHtcbiAgICAgICAgY29tbW9uLnNob3dMb2FkaW5nKHRydWUpO1xuICAgIH1cbiAgICB2YXIgdXJsID0gXCJ2MS9oYmcvbWFyZ2luL3JlcGF5L2hpc3RvcnlcIjtcbiAgICBpZiAobW9kdWxlRGF0YS5jdXJNb2RlVHlwZSA9PSBNb2RlVHlwZS5zdXBlck1hcmdpbikge1xuICAgICAgICB1cmwgPSBcInYxL2hiZy9zdXBlci1tYXJnaW4vcmVwYXkvaGlzdG9yeVwiO1xuICAgIH1cbiAgICBsZXQgZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdCh1cmwsIHBhcmFtcywgMCwgNCwgeyBcIkNvbnRlbnQtVHlwZVwiOiBcImFwcGxpY2F0aW9uL2pzb25cIiB9KTtcbiAgICBjb21tb24uc2hvd0xvYWRpbmcoZmFsc2UpO1xuICAgIGNvbnNvbGUubG9nKGB3cCByZXF1ZXN0UmVwYXlIaXN0b3J5IGRhdGEgPSR7ZGF0YX1gKTtcbiAgICB0cnkge1xuICAgICAgICBpZiAoIWlzTW9yZSkge1xuICAgICAgICAgICAgY29tbW9uTGlzdFtUYWJUeXBlLlRhYlR5cGVSZXBheV0gPSBnZXRUYWJMaXN0RGVmYXVsdERhdGEoKTtcbiAgICAgICAgICAgIGlmICghZGF0YSB8fCBkYXRhID09IG51bGwgfHwgZGF0YS5sZW5ndGggPT0gMCkge1xuICAgICAgICAgICAgICAgIGNvbW1vbkxpc3RbVGFiVHlwZS5UYWJUeXBlUmVwYXldID0ge1xuICAgICAgICAgICAgICAgICAgICBkYXRhOiBbXSxcbiAgICAgICAgICAgICAgICAgICAgZW1wdHlWaXNpYmxlOiBcInZpc2libGVcIixcbiAgICAgICAgICAgICAgICAgICAgbGlzdFZpc2libGU6IFwiZ29uZVwiLFxuICAgICAgICAgICAgICAgICAgICBzaG93TG9hZGluZzogdHJ1ZSxcbiAgICAgICAgICAgICAgICAgICAgZnJvbTogLTEsXG4gICAgICAgICAgICAgICAgfTtcbiAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLmxpc3REYXRhID0gY29tbW9uTGlzdDtcbiAgICAgICAgICAgICAgICByZXR1cm47XG4gICAgICAgICAgICB9XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLmxvYWRNb3JlU3RhdHVzID0gXCIyXCI7XG4gICAgICAgIH1cbiAgICAgICAgaGFuZGxlUmVwYXlIaXN0b3J5RGF0YShkYXRhKTtcbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGBoYW5kbGUgaGFuZGxlTG9hbkhpc3RvcnlEYXRhIGRhdGEgZXJyb3I9JHtlfWApO1xuICAgIH1cbn1cblxuYXN5bmMgZnVuY3Rpb24gaGFuZGxlUmVwYXlIaXN0b3J5RGF0YShoaXN0b3J5cykge1xuICAgIHZhciByZXBheURhdGEgPSBjb21tb25MaXN0W1RhYlR5cGUuVGFiVHlwZVJlcGF5XTtcbiAgICB2YXIgcmVwYXlzID0gcmVwYXlEYXRhLmRhdGE7XG4gICAgcmVwYXlEYXRhLmVtcHR5VmlzaWJsZSA9IFwiZ29uZVwiO1xuICAgIHJlcGF5RGF0YS5saXN0VmlzaWJsZSA9IFwidmlzaWJsZVwiO1xuICAgIHJlcGF5RGF0YS5zaG93TG9hZGluZyA9IGZhbHNlO1xuICAgIGlmIChoaXN0b3J5cy5sZW5ndGggPT0gbGltaXQpIHtcbiAgICAgICAgbGV0IGxhc3RSZXBheSA9IGhpc3RvcnlzW2hpc3RvcnlzLmxlbmd0aCAtIDFdO1xuICAgICAgICByZXBheURhdGEuZnJvbSA9IGxhc3RSZXBheS5pZDtcbiAgICB9XG4gICAgZWxzZSB7XG4gICAgICAgIHJlcGF5RGF0YS5mcm9tID0gLTE7XG4gICAgfVxuICAgIGNvbnNvbGUubG9nKGB3cCBoYW5kbGVSZXBheUhpc3RvcnlEYXRhIHJlcGF5cyA9JHtyZXBheXN9YCk7XG4gICAgZm9yIChsZXQgaSA9IDA7IGkgPCBoaXN0b3J5cy5sZW5ndGg7ICsraSkge1xuICAgICAgICBsZXQgdiA9IGhpc3RvcnlzW2ldO1xuICAgICAgICB2LmluZGV4ID0gcmVwYXlzLmxlbmd0aDtcbiAgICAgICAgdi50YWcgPSByZXBheXMubGVuZ3RoO1xuICAgICAgICB2LnJlcGF5VHlwZSA9IHYudHlwZTtcbiAgICAgICAgdi50eXBlQ29udGVudCA9IGdldFR5cGVDb250ZW50KHYucmVwYXlUeXBlKTtcbiAgICAgICAgdi50eXBlID0gXCJyZXBheVwiO1xuXG4gICAgICAgIGlmIChtb2R1bGVEYXRhLmN1ck1vZGVUeXBlID09IE1vZGVUeXBlLnN1cGVyTWFyZ2luKSB7XG4gICAgICAgICAgICBpZiAodi5yZXBheVR5cGUgPT0gMjMpIHtcbiAgICAgICAgICAgICAgICBpZiAodltcImRlZHVjdC10eXBlXCJdID09IDEpIHtcbiAgICAgICAgICAgICAgICAgICAgdi50aXRsZSA9ICRpMThuLm5fdXNlcl9jZW50ZXJfcG9pbnRzX3RpdGxlO1xuICAgICAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgICAgIHYudGl0bGUgPSB2W1wiZGVkdWN0LWN1cnJlbmN5XCJdLnRvVXBwZXJDYXNlKCk7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICB2LnRpdGxlID0gdi5jdXJyZW5jeS50b1VwcGVyQ2FzZSgpO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgdi5jdXJyZW5jeVZpc2libGUgPSBcImdvbmVcIjtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIHYudGl0bGUgPSB2W1wiZGlzcGxheS1zeW1ib2xcIl0udG9VcHBlckNhc2UoKTtcbiAgICAgICAgICAgIGlmICh2LnJlcGF5VHlwZSA9PSAyMykge1xuICAgICAgICAgICAgICAgIGlmICh2W1wiZGVkdWN0LXR5cGVcIl0gPT0gMSkge1xuICAgICAgICAgICAgICAgICAgICB2LmN1cnJlbmN5ID0gJGkxOG4ubl91c2VyX2NlbnRlcl9wb2ludHNfdGl0bGU7XG4gICAgICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICAgICAgdi5jdXJyZW5jeSA9IHZbXCJkZWR1Y3QtY3VycmVuY3lcIl0udG9VcHBlckNhc2UoKTtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgIHYuY3VycmVuY3kgPSB2LmN1cnJlbmN5LnRvVXBwZXJDYXNlKCk7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICB2LmN1cnJlbmN5VmlzaWJsZSA9IFwidmlzaWJsZVwiO1xuICAgICAgICB9XG5cbiAgICAgICAgaWYgKHYucmVwYXlUeXBlID09IDIzKSB7XG4gICAgICAgICAgICB2LnJlcGF5QW1vdW50VmlzaWJsZSA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgdi50b3RhbEFtb3VudFZpc2libGUgPSBcImdvbmVcIjtcbiAgICAgICAgICAgIGxldCBpbnRlcmVzdCA9IG51bWJlci5zY2llbnRpZmljVG9OdW1iZXIodltcImRlZHVjdC1hbW91bnRcIl0pO1xuICAgICAgICAgICAgdi5pbnRlcmVzdEFtb3VudCA9IGNvbW1vbi50aG91c2FuZHNGb3JtYXR0ZXIoaW50ZXJlc3QpO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgdi5yZXBheUFtb3VudFZpc2libGUgPSBcInZpc2libGVcIjtcbiAgICAgICAgICAgIHYudG90YWxBbW91bnRWaXNpYmxlID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICB2LnJlcGF5QW1vdW50ID0gY29tbW9uLnRob3VzYW5kc0Zvcm1hdHRlcih2W1wicmVwYXktYW1vdW50XCJdKTtcbiAgICAgICAgICAgIHYudG90YWxBbW91bnQgPSBjb21tb24udGhvdXNhbmRzRm9ybWF0dGVyKHZbXCJ0b3RhbC1hbW91bnRcIl0pO1xuICAgICAgICAgICAgbGV0IGludGVyZXN0ID0gbnVtYmVyLnNjaWVudGlmaWNUb051bWJlcih2W1wiaW50ZXJlc3QtYW1vdW50XCJdKTtcbiAgICAgICAgICAgIHYuaW50ZXJlc3RBbW91bnQgPSBjb21tb24udGhvdXNhbmRzRm9ybWF0dGVyKGludGVyZXN0KTtcbiAgICAgICAgfVxuXG4gICAgICAgIHYudGltZSA9IG5ldyBEYXRlKHYudGltZSkuRm9ybWF0KFwieXl5eS1NTS1kZCBoaDptbTpzc1wiKTtcbiAgICAgICAgcmVwYXlzLnB1c2godik7XG4gICAgfTtcbiAgICBtb2R1bGVEYXRhLmxpc3REYXRhID0gY29tbW9uTGlzdDtcbn1cblxuYXN5bmMgZnVuY3Rpb24gcmVxdWVzdEludGVyZXN0SGlzdG9yeShpc01vcmUpIHtcbiAgICB2YXIgcGFyYW1zID0ge1xuICAgICAgICBsaW1pdDogbGltaXRcbiAgICB9O1xuICAgIHBhcmFtc1tcImJlZ2luLXRpbWVcIl0gPSBnZXRTdGFydFRpbWVzdGFtcCgpO1xuICAgIHBhcmFtc1tcImVuZC10aW1lXCJdID0gZ2V0RW5kVGltZXN0YW1wKCk7XG4gICAgaWYgKG1vZHVsZURhdGEuY3VyRmlsdGVyQ3VycmVuY3lJbmRleCAhPSAwKSB7XG4gICAgICAgIGlmIChtb2R1bGVEYXRhLmN1ck1vZGVUeXBlID09IE1vZGVUeXBlLnN1cGVyTWFyZ2luKSB7XG4gICAgICAgICAgICBwYXJhbXNbXCJjdXJyZW5jeVwiXSA9IG1vZHVsZURhdGEuY3VycmVuY3lUZXh0LnRvTG93ZXJDYXNlKCk7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBwYXJhbXNbXCJzeW1ib2xcIl0gPSBtb2R1bGVEYXRhLmN1clN5bWJvbC50b0xvd2VyQ2FzZSgpO1xuICAgICAgICB9XG4gICAgfVxuICAgIGlmIChtb2R1bGVEYXRhLmN1ckZpbHRlclR5cGVJbmRleCAhPSAwKSB7XG4gICAgICAgIHZhciBpdGVtID0gbW9kdWxlRGF0YS5maWx0ZXJUeXBlc1ttb2R1bGVEYXRhLmN1ckZpbHRlclR5cGVJbmRleF07XG4gICAgICAgIHBhcmFtc1tcInR5cGVcIl0gPSBpdGVtLnRhZztcbiAgICB9XG4gICAgdmFyIGludGVyZXN0RGF0YSA9IGNvbW1vbkxpc3RbVGFiVHlwZS5UYWJUeXBlSW50ZXJlc3RdO1xuICAgIGlmIChpc01vcmUpIHtcbiAgICAgICAgcGFyYW1zW1wiZnJvbVwiXSA9IGludGVyZXN0RGF0YS5mcm9tO1xuICAgIH1cbiAgICBpZihpbnRlcmVzdERhdGEuc2hvd0xvYWRpbmcpIHtcbiAgICAgICAgY29tbW9uLnNob3dMb2FkaW5nKHRydWUpO1xuICAgIH1cbiAgICB2YXIgdXJsID0gXCJ2MS9oYmcvbWFyZ2luL2ludGVyZXN0L2hpc3RvcnlcIjtcbiAgICBpZiAobW9kdWxlRGF0YS5jdXJNb2RlVHlwZSA9PSBNb2RlVHlwZS5zdXBlck1hcmdpbikge1xuICAgICAgICB1cmwgPSBcInYxL2hiZy9zdXBlci1tYXJnaW4vaW50ZXJlc3QvaGlzdG9yeVwiO1xuICAgIH1cbiAgICBsZXQgZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdCh1cmwsIHBhcmFtcywgMCwgNCwgeyBcIkNvbnRlbnQtVHlwZVwiOiBcImFwcGxpY2F0aW9uL2pzb25cIiB9KTtcbiAgICBjb21tb24uc2hvd0xvYWRpbmcoZmFsc2UpO1xuICAgIGNvbnNvbGUubG9nKGB3cCByZXF1ZXN0SW50ZXJlc3RIaXN0b3J5IGRhdGEgPSR7ZGF0YX1gKTtcbiAgICB0cnkge1xuICAgICAgICBpZiAoIWlzTW9yZSkge1xuICAgICAgICAgICAgY29tbW9uTGlzdFtUYWJUeXBlLlRhYlR5cGVJbnRlcmVzdF0gPSBnZXRUYWJMaXN0RGVmYXVsdERhdGEoKTtcbiAgICAgICAgICAgIGlmICghZGF0YSB8fCBkYXRhID09IG51bGwgfHwgZGF0YS5sZW5ndGggPT0gMCkge1xuICAgICAgICAgICAgICAgIGNvbW1vbkxpc3RbVGFiVHlwZS5UYWJUeXBlSW50ZXJlc3RdID0ge1xuICAgICAgICAgICAgICAgICAgICBkYXRhOiBbXSxcbiAgICAgICAgICAgICAgICAgICAgZW1wdHlWaXNpYmxlOiBcInZpc2libGVcIixcbiAgICAgICAgICAgICAgICAgICAgbGlzdFZpc2libGU6IFwiZ29uZVwiLFxuICAgICAgICAgICAgICAgICAgICBzaG93TG9hZGluZzogdHJ1ZSxcbiAgICAgICAgICAgICAgICAgICAgZnJvbTogLTEsXG4gICAgICAgICAgICAgICAgfTtcbiAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLmxpc3REYXRhID0gY29tbW9uTGlzdDtcbiAgICAgICAgICAgICAgICByZXR1cm47XG4gICAgICAgICAgICB9XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLmxvYWRNb3JlU3RhdHVzID0gXCIyXCI7XG4gICAgICAgIH1cbiAgICAgICAgaGFuZGxlSW50ZXJlc3RIaXN0b3J5RGF0YShkYXRhKTtcbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGBoYW5kbGUgaGFuZGxlSW50ZXJlc3RuSGlzdG9yeURhdGEgZGF0YSBlcnJvcj0ke2V9YCk7XG4gICAgfVxufVxuXG5hc3luYyBmdW5jdGlvbiBoYW5kbGVJbnRlcmVzdEhpc3RvcnlEYXRhKGhpc3RvcnlzKSB7XG4gICAgdmFyIGludGVyZXN0RGF0YSA9IGNvbW1vbkxpc3RbVGFiVHlwZS5UYWJUeXBlSW50ZXJlc3RdO1xuICAgIHZhciBpbnRlcmVzdHMgPSBpbnRlcmVzdERhdGEuZGF0YTtcbiAgICBpbnRlcmVzdERhdGEuZW1wdHlWaXNpYmxlID0gXCJnb25lXCI7XG4gICAgaW50ZXJlc3REYXRhLmxpc3RWaXNpYmxlID0gXCJ2aXNpYmxlXCI7XG4gICAgaW50ZXJlc3REYXRhLnNob3dMb2FkaW5nID0gZmFsc2U7XG4gICAgaWYgKGhpc3RvcnlzLmxlbmd0aCA9PSBsaW1pdCkge1xuICAgICAgICBsZXQgbGFzdFJlcGF5ID0gaGlzdG9yeXNbaGlzdG9yeXMubGVuZ3RoIC0gMV07XG4gICAgICAgIGludGVyZXN0RGF0YS5mcm9tID0gbGFzdFJlcGF5LmlkO1xuICAgIH1cbiAgICBlbHNlIHtcbiAgICAgICAgaW50ZXJlc3REYXRhLmZyb20gPSAtMTtcbiAgICB9XG4gICAgY29uc29sZS5sb2coYHdwIGhhbmRsZVJlcGF5SGlzdG9yeURhdGEgaW50ZXJlc3RzID0ke2ludGVyZXN0c31gKTtcbiAgICBmb3IgKGxldCBpID0gMDsgaSA8IGhpc3RvcnlzLmxlbmd0aDsgKytpKSB7XG4gICAgICAgIGxldCB2ID0gaGlzdG9yeXNbaV07XG4gICAgICAgIHYuaW5kZXggPSBpbnRlcmVzdHMubGVuZ3RoO1xuICAgICAgICB2LnRhZyA9IGludGVyZXN0cy5sZW5ndGg7XG4gICAgICAgIGlmIChtb2R1bGVEYXRhLmN1ck1vZGVUeXBlID09IE1vZGVUeXBlLnN1cGVyTWFyZ2luKSB7XG4gICAgICAgICAgICB2LnRpdGxlID0gdi5jdXJyZW5jeS50b1VwcGVyQ2FzZSgpO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgdi50aXRsZSA9IHZbXCJkaXNwbGF5LXN5bWJvbFwiXS50b1VwcGVyQ2FzZSgpO1xuICAgICAgICB9XG4gICAgICAgIHYuY3VycmVuY3kgPSB2LmN1cnJlbmN5LnRvVXBwZXJDYXNlKCk7XG4gICAgICAgIHYuaW50ZXJlc3RUeXBlID0gdi50eXBlO1xuICAgICAgICB2LnR5cGVDb250ZW50ID0gZ2V0VHlwZUNvbnRlbnQodi5pbnRlcmVzdFR5cGUpO1xuICAgICAgICB2LnR5cGUgPSBcImludGVyZXN0XCI7XG4gICAgICAgIGxldCBpbnRlcmVzdCA9IG51bWJlci5zY2llbnRpZmljVG9OdW1iZXIodltcImludGVyZXN0LWFtb3VudFwiXSk7XG4gICAgICAgIHYuaW50ZXJlc3RBbW91bnQgPSBjb21tb24udGhvdXNhbmRzRm9ybWF0dGVyKGludGVyZXN0KTtcbiAgICAgICAgbGV0IHJhdGUgPSBudW1iZXIubXVsdGlwbHkocGFyc2VGbG9hdCh2W1wiaW50ZXJlc3QtcmF0ZVwiXSksIDEwMCk7XG4gICAgICAgIHYuaW50ZXJlc3RSYXRlID0gY29tbW9uLmZvcm1hdFByZWNpc2lvbihyYXRlLCA0KSArIFwiJVwiO1xuICAgICAgICB2LnRpbWUgPSBuZXcgRGF0ZSh2LnRpbWUpLkZvcm1hdChcInl5eXktTU0tZGQgaGg6bW06c3NcIik7XG4gICAgICAgIGludGVyZXN0cy5wdXNoKHYpO1xuICAgIH07XG4gICAgbW9kdWxlRGF0YS5saXN0RGF0YSA9IGNvbW1vbkxpc3Q7XG59XG5cbmZ1bmN0aW9uIGdldFN0YXJ0VGltZXN0YW1wICgpIHtcbiAgICBjb25zdCBmaXJzdFRpbWUgPSBuZXcgRGF0ZShtb2R1bGVEYXRhLnN0YXJ0VGltZSkuc2V0SG91cnMoMCwgMCwgMCk7XG4gICAgY29uc3Qgc3RhcnRUaW1lc3RhbXAgPSBuZXcgRGF0ZShmaXJzdFRpbWUpLmdldFRpbWUoKTtcbiAgICByZXR1cm4gc3RhcnRUaW1lc3RhbXA7XG59XG5cbmZ1bmN0aW9uIGdldEVuZFRpbWVzdGFtcCAoKSB7XG4gICAgY29uc3QgbGFzdFRpbWUgPSBuZXcgRGF0ZShtb2R1bGVEYXRhLmVuZFRpbWUpLnNldEhvdXJzKDIzLCA1OSwgNTkpO1xuICAgIGNvbnN0IGVuZFRpbWVzdGFtcCA9IG5ldyBEYXRlKGxhc3RUaW1lKS5nZXRUaW1lKCk7XG4gICAgcmV0dXJuIGVuZFRpbWVzdGFtcDtcbn1cblxuLyoqXG4gKiDlhajku5PliJfooahcbiAqL1xuYXN5bmMgZnVuY3Rpb24gcmVxdWVzdFN1cGVyTWFyZ2luQ3VycmVuY2llcygpIHtcbiAgICBjb25zb2xlLmxvZyhcInJlcXVlc3RTdXBlck1hcmdpbkN1cnJlbmNpZXNcIik7XG4gICAgdmFyIHBhcmFtcyA9IHtcbiAgICAgICAgdHM6IFwiMFwiLFxuICAgICAgICBsYW5ndWFnZTogY29tbW9uLmNvbW1vbkRhdGEubGFuZ3VhZ2VcbiAgICB9O1xuICAgIHZhciByZXNwTGlzdCA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdChcInYyL3NldHRpbmdzL2NvbW1vbi9jdXJyZW5jaWVzXCIsIHBhcmFtcywgMCwgNCwge30sIDEpO1xuICAgIGlmIChyZXNwTGlzdCkge1xuICAgICAgICBzdXBwb3J0Q3VycmVuY2llcyA9IFtdO1xuICAgICAgICBpZiAobW9kdWxlRGF0YS5jdXJNb2RlVHlwZSA9PSBNb2RlVHlwZS5zdXBlck1hcmdpbiAmJiBtb2R1bGVEYXRhLmN1clN5bWJvbCAhPSBudWxsKXtcbiAgICAgICAgICAgIHN1cHBvcnRDdXJyZW5jaWVzLnB1c2goeyB0eXBlOiBcIm5vcm1hbFwiLCB0aXRsZTogJGkxOG4ubl9lYXJuX2FsbF9jb2luLCB0aXRsZUNvbG9yOiBidXR0b25UaXRsZUNvbG9yX05vcm1hbCwgY3VycmVuY3lTZWxlY3RlZDogXCJnb25lXCIsIHRhZzogMCB9LCk7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBzdXBwb3J0Q3VycmVuY2llcy5wdXNoKHsgdHlwZTogXCJub3JtYWxcIiwgdGl0bGU6ICRpMThuLm5fZWFybl9hbGxfY29pbiwgdGl0bGVDb2xvcjogYnV0dG9uVGl0bGVDb2xvcl9TZWxlY3RlZCwgY3VycmVuY3lTZWxlY3RlZDogXCJ2aXNpYmxlXCIsIHRhZzogMCB9LCk7XG4gICAgICAgIH1cbiAgICAgICAgZm9yIChsZXQgaSA9IDA7IGkgPCByZXNwTGlzdC5sZW5ndGg7ICsraSkge1xuICAgICAgICAgICAgbGV0IHYgPSByZXNwTGlzdFtpXTtcbiAgICAgICAgICAgIHYuaW5kZXggPSBzdXBwb3J0Q3VycmVuY2llcy5sZW5ndGg7XG4gICAgICAgICAgICB2LnRhZyA9IHN1cHBvcnRDdXJyZW5jaWVzLmxlbmd0aDtcbiAgICAgICAgICAgIHYudGl0bGUgPSB2W1wiZG5cIl07XG4gICAgICAgICAgICB2LnN5bWJvbCA9IHZbXCJkblwiXTtcbiAgICAgICAgICAgIHYudGl0bGVDb2xvciA9IGJ1dHRvblRpdGxlQ29sb3JfTm9ybWFsO1xuICAgICAgICAgICAgdi5jdXJyZW5jeVNlbGVjdGVkID0gXCJnb25lXCI7XG4gICAgICAgICAgICBpZiAobW9kdWxlRGF0YS5jdXJNb2RlVHlwZSA9PSBNb2RlVHlwZS5zdXBlck1hcmdpbiAmJiBtb2R1bGVEYXRhLmN1clN5bWJvbCAhPSBudWxsICYmIG1vZHVsZURhdGEuY3VyU3ltYm9sLnRvTG93ZXJDYXNlKCkgPT0gdi5zeW1ib2wudG9Mb3dlckNhc2UoKSkge1xuICAgICAgICAgICAgICAgIHYudGl0bGVDb2xvciA9IGJ1dHRvblRpdGxlQ29sb3JfU2VsZWN0ZWQ7XG4gICAgICAgICAgICAgICAgdi5jdXJyZW5jeVNlbGVjdGVkID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAgbW9kdWxlRGF0YS5jdXJGaWx0ZXJDdXJyZW5jeUluZGV4ID0gdi5pbmRleDtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIHN1cHBvcnRDdXJyZW5jaWVzLnB1c2godik7XG4gICAgICAgIH07XG4gICAgfVxuICAgIGlmIChtb2R1bGVEYXRhLmN1ck1vZGVUeXBlID09IE1vZGVUeXBlLnN1cGVyTWFyZ2luKSB7XG4gICAgICAgIG1vZHVsZURhdGEuZmlsdGVyQ3VycmVuY2llcyA9IHN1cHBvcnRDdXJyZW5jaWVzO1xuICAgIH1cbn1cblxuLyoqXG4gKiDpgJDku5PliJfooahcbiAqL1xuYXN5bmMgZnVuY3Rpb24gcmVxdWVzdE1hcmdpblN5bWJvbHMoKSB7XG4gICAgY29uc29sZS5sb2coXCJyZXF1ZXN0TWFyZ2luU3ltYm9sc1wiKTtcbiAgICB2YXIgcGFyYW1zID0ge1xuICAgICAgICB0czogXCIwXCIsXG4gICAgICAgIGxhbmd1YWdlOiBjb21tb24uY29tbW9uRGF0YS5sYW5ndWFnZVxuICAgIH07XG4gICAgdmFyIHJlc3BMaXN0ID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KFwidjIvc2V0dGluZ3MvY29tbW9uL3N5bWJvbHNcIiwgcGFyYW1zLCAwLCA0LCB7fSwgMSk7XG4gICAgaWYgKHJlc3BMaXN0KSB7XG4gICAgICAgIHN1cHBvcnRTeW1ib2xzID0gW107XG4gICAgICAgIGlmKG1vZHVsZURhdGEuY3VyTW9kZVR5cGUgPT0gTW9kZVR5cGUuaXNvbGF0ZU1hcmdpbiAmJiBtb2R1bGVEYXRhLmN1clN5bWJvbCAhPSBudWxsKSB7XG4gICAgICAgICAgICBzdXBwb3J0U3ltYm9scy5wdXNoKHsgdHlwZTogXCJub3JtYWxcIiwgdGl0bGU6ICRpMThuLm5fbWFyZ2luX2FsbF9jdXJyZW5jeSwgdGl0bGVDb2xvcjogYnV0dG9uVGl0bGVDb2xvcl9Ob3JtYWwsIGN1cnJlbmN5U2VsZWN0ZWQ6IFwiZ29uZVwiLCB0YWc6IDAgfSk7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBzdXBwb3J0U3ltYm9scy5wdXNoKHsgdHlwZTogXCJub3JtYWxcIiwgdGl0bGU6ICRpMThuLm5fbWFyZ2luX2FsbF9jdXJyZW5jeSwgdGl0bGVDb2xvcjogYnV0dG9uVGl0bGVDb2xvcl9TZWxlY3RlZCwgY3VycmVuY3lTZWxlY3RlZDogXCJ2aXNpYmxlXCIsIHRhZzogMCB9KTtcbiAgICAgICAgfVxuICAgICAgICBmb3IgKGxldCBpID0gMDsgaSA8IHJlc3BMaXN0Lmxlbmd0aDsgKytpKSB7XG4gICAgICAgICAgICBsZXQgdiA9IHJlc3BMaXN0W2ldO1xuICAgICAgICAgICAgdi5pbmRleCA9IHN1cHBvcnRTeW1ib2xzLmxlbmd0aDtcbiAgICAgICAgICAgIHYudGFnID0gc3VwcG9ydFN5bWJvbHMubGVuZ3RoO1xuICAgICAgICAgICAgdi5zeW1ib2wgPSB2W1wic2NcIl07XG4gICAgICAgICAgICB2LnRpdGxlID0gYXdhaXQgY29tbW9uLmdldFN5bWJvbERpc3BsYXlOYW1lKHYuc3ltYm9sKTtcbiAgICAgICAgICAgIHYudGl0bGVDb2xvciA9IGJ1dHRvblRpdGxlQ29sb3JfTm9ybWFsO1xuICAgICAgICAgICAgdi5jdXJyZW5jeVNlbGVjdGVkID0gXCJnb25lXCI7XG4gICAgICAgICAgICBpZiAobW9kdWxlRGF0YS5jdXJNb2RlVHlwZSA9PSBNb2RlVHlwZS5pc29sYXRlTWFyZ2luICYmIG1vZHVsZURhdGEuY3VyU3ltYm9sICE9IG51bGwgJiYgbW9kdWxlRGF0YS5jdXJTeW1ib2wudG9Mb3dlckNhc2UoKSA9PSB2LnN5bWJvbC50b0xvd2VyQ2FzZSgpKSB7XG4gICAgICAgICAgICAgICAgdi50aXRsZUNvbG9yID0gYnV0dG9uVGl0bGVDb2xvcl9TZWxlY3RlZDtcbiAgICAgICAgICAgICAgICB2LmN1cnJlbmN5U2VsZWN0ZWQgPSBcInZpc2libGVcIjtcbiAgICAgICAgICAgICAgICBtb2R1bGVEYXRhLmN1ckZpbHRlckN1cnJlbmN5SW5kZXggPSB2LmluZGV4O1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgc3VwcG9ydFN5bWJvbHMucHVzaCh2KTtcbiAgICAgICAgfTtcbiAgICB9XG4gICAgaWYgKG1vZHVsZURhdGEuY3VyTW9kZVR5cGUgPT0gTW9kZVR5cGUuaXNvbGF0ZU1hcmdpbikge1xuICAgICAgICBtb2R1bGVEYXRhLmZpbHRlckN1cnJlbmNpZXMgPSBzdXBwb3J0U3ltYm9scztcbiAgICB9XG59XG5cbi8v5YiH5o2i5YWo5LuTL+mAkOS7k+W8ueahhumAu+i+kVxuYXN5bmMgZnVuY3Rpb24gbW9kZVR5cGVQb3BEaXNtaXNzKCkge1xuICAgIG1vZHVsZURhdGEubW9kZVR5cGVTaG93ID0gXCJmYWxzZVwiO1xuICAgIG1vZHVsZURhdGEubW9kZVR5cGVJY29uID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfYXJyb3dfZG93blwiO1xufVxuXG4vL+eCueWHu+WFqOS7ky/pgJDku5NcbmZ1bmN0aW9uIG1vZGVUeXBlUG9wU2VsZWN0ZWQobW9kZVR5cGUpIHtcbiAgICBpZiAobW9kdWxlRGF0YS5jdXJNb2RlVHlwZSAhPSBtb2RlVHlwZSkge1xuICAgICAgICBzZXRNb2RlVHlwZURhdGEobW9kZVR5cGUpO1xuICAgICAgICBjb21tb25MaXN0ID0gW2dldFRhYkxpc3REZWZhdWx0RGF0YSgpLCBnZXRUYWJMaXN0RGVmYXVsdERhdGEoKSwgZ2V0VGFiTGlzdERlZmF1bHREYXRhKCldO1xuICAgICAgICBtb2R1bGVEYXRhLmxpc3REYXRhID0gY29tbW9uTGlzdDtcbiAgICAgICAgcmVzZXRDdXJyZW5jeUluZGV4KCk7XG4gICAgICAgIHJlcXVlc3REYXRhKGZhbHNlKTtcbiAgICB9XG4gICAgbW9kdWxlRGF0YS5tb2RlVHlwZVNob3cgPSBcImZhbHNlXCI7XG4gICAgbW9kdWxlRGF0YS5tb2RlVHlwZUljb24gPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9hcnJvd19kb3duXCI7XG59XG5cbmZ1bmN0aW9uIHJlc2V0Q3VycmVuY3lTZWFyY2hVSSgpIHtcbiAgICBpZiAobW9kdWxlRGF0YS5maWx0ZXJDdXJyZW5jaWVzID09IG51bGwgfHwgbW9kdWxlRGF0YS5maWx0ZXJDdXJyZW5jaWVzLmxlbmd0aCA9PSAwKSB7XG4gICAgICAgIG1vZHVsZURhdGEuY3VycmVuY3lMaXN0VmlzaWJsZSA9IFwiZ29uZVwiXG4gICAgICAgIG1vZHVsZURhdGEuY3VycmVuY3lFbXB0eVZpc2libGUgPSBcInZpc2libGVcIlxuICAgIH0gZWxzZSB7XG4gICAgICAgIG1vZHVsZURhdGEuY3VycmVuY3lMaXN0VmlzaWJsZSA9IFwidmlzaWJsZVwiXG4gICAgICAgIG1vZHVsZURhdGEuY3VycmVuY3lFbXB0eVZpc2libGUgPSBcImdvbmVcIlxuICAgIH1cbn1cblxuZnVuY3Rpb24gcmVzZXRDdXJyZW5jeUluZGV4KCkge1xuICAgIC8v6buY6K6k5YWo6YOo5biB56eNL+W4geWvuVxuICAgIG1vZHVsZURhdGEuY3VycmVuY3lUZXh0ID0gKG1vZHVsZURhdGEuY3VyTW9kZVR5cGUgPT0gTW9kZVR5cGUuc3VwZXJNYXJnaW4pID8gJGkxOG4ubl9lYXJuX2FsbF9jb2luIDogJGkxOG4ubl9tYXJnaW5fYWxsX2N1cnJlbmN5O1xuICAgIG1vZHVsZURhdGEuY3VyRmlsdGVyQ3VycmVuY3lJbmRleCA9IDA7XG4gICAgZm9yICh2YXIgaSA9IDA7IGkgPCBzdXBwb3J0U3ltYm9scy5sZW5ndGg7IGkrKykge1xuICAgICAgICB2YXIgaXRlbSA9IHN1cHBvcnRTeW1ib2xzW2ldO1xuICAgICAgICBpZiAoaSA9PSAwKSB7XG4gICAgICAgICAgICBpdGVtLnRpdGxlQ29sb3IgPSBidXR0b25UaXRsZUNvbG9yX1NlbGVjdGVkO1xuICAgICAgICAgICAgaXRlbS5jdXJyZW5jeVNlbGVjdGVkID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBpdGVtLnRpdGxlQ29sb3IgPSBidXR0b25UaXRsZUNvbG9yX05vcm1hbDtcbiAgICAgICAgICAgIGl0ZW0uY3VycmVuY3lTZWxlY3RlZCA9IFwiZ29uZVwiO1xuICAgICAgICB9XG4gICAgfVxuICAgIGZvciAodmFyIGkgPSAwOyBpIDwgc3VwcG9ydEN1cnJlbmNpZXMubGVuZ3RoOyBpKyspIHtcbiAgICAgICAgdmFyIGl0ZW0gPSBzdXBwb3J0Q3VycmVuY2llc1tpXTtcbiAgICAgICAgaWYgKGkgPT0gMCkge1xuICAgICAgICAgICAgaXRlbS50aXRsZUNvbG9yID0gYnV0dG9uVGl0bGVDb2xvcl9TZWxlY3RlZDtcbiAgICAgICAgICAgIGl0ZW0uY3VycmVuY3lTZWxlY3RlZCA9IFwidmlzaWJsZVwiO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgaXRlbS50aXRsZUNvbG9yID0gYnV0dG9uVGl0bGVDb2xvcl9Ob3JtYWw7XG4gICAgICAgICAgICBpdGVtLmN1cnJlbmN5U2VsZWN0ZWQgPSBcImdvbmVcIjtcbiAgICAgICAgfVxuICAgIH1cbn1cblxuZnVuY3Rpb24gc2V0TW9kZVR5cGVEYXRhKG1vZGVUeXBlKSB7XG4gICAgY29uc29sZS5sb2coYHdwIC0tLS0tc2V0TW9kZVR5cGVEYXRhID0gJHttb2RlVHlwZX1gKTtcblxuICAgIG1vZHVsZURhdGEuY3VyTW9kZVR5cGUgPSBtb2RlVHlwZTtcbiAgICBtb2R1bGVEYXRhLnN1cGVyTWFyZ2luU2VsZWN0ZWQgPSAobW9kZVR5cGUgPT0gTW9kZVR5cGUuc3VwZXJNYXJnaW4pID8gXCJ2aXNpYmxlXCIgOiBcImdvbmVcIjtcbiAgICBtb2R1bGVEYXRhLmlzb2xhdGVNYXJnaW5TZWxlY3RlZCA9IChtb2RlVHlwZSA9PSBNb2RlVHlwZS5zdXBlck1hcmdpbikgPyBcImdvbmVcIiA6IFwidmlzaWJsZVwiO1xuICAgIG1vZHVsZURhdGEuc3VwZXJNYXJnaW5Db2xvciA9IChtb2RlVHlwZSA9PSBNb2RlVHlwZS5zdXBlck1hcmdpbikgPyBcIkBjb2xvci9iYXNlQ29sb3JNYWpvclRoZW1lMTAwXCIgOiBcIkBjb2xvci9rQ29sb3JQcmltYXJ5VGV4dFwiO1xuICAgIG1vZHVsZURhdGEuaXNvbGF0ZU1hcmdpbkNvbG9yID0gKG1vZGVUeXBlID09IE1vZGVUeXBlLnN1cGVyTWFyZ2luKSA/IFwiQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0XCIgOiBcIkBjb2xvci9iYXNlQ29sb3JNYWpvclRoZW1lMTAwXCI7XG4gICAgbW9kdWxlRGF0YS5tb2RlVHlwZVRleHQgPSAobW9kZVR5cGUgPT0gTW9kZVR5cGUuc3VwZXJNYXJnaW4pID8gJGkxOG4ubl9jb250cmFjdF9zdXBlcl9tYXJnaW4gOiAkaTE4bi5uX2NvbnRyYWN0X3RyYWRlX21hcmdpbjtcbn1cblxuLy/mm7TlpJrluIHnp43luIHlr7nlvLnmoYbpgLvovpFcbmFzeW5jIGZ1bmN0aW9uIGN1cnJlbmN5UG9wRGlzbWlzcygpIHtcbiAgICBtb2R1bGVEYXRhLmN1cnJlbmN5U2hvdyA9IFwiZmFsc2VcIjtcbiAgICBtb2R1bGVEYXRhLmN1cnJlbmN5SWNvbiA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2Fycm93X2Rvd25cIjtcbiAgICBtb2R1bGVEYXRhLmlzRm9jdXMgPSBmYWxzZVxuICAgIGlmIChjb21tb24uY29tbW9uRGF0YS5PUyA9PSAxKSB7XG4gICAgICAgICRuYXRpdmVBUEkuY2xvc2VLZXlib2FyZCgpXG4gICAgfVxufVxuXG5mdW5jdGlvbiBmaWx0ZXJMaXN0KCkge1xuICAgIGxldCBzdXBwb3J0TGlzdCA9IChtb2R1bGVEYXRhLmN1ck1vZGVUeXBlID09IE1vZGVUeXBlLnN1cGVyTWFyZ2luKSA/IHN1cHBvcnRDdXJyZW5jaWVzIDogc3VwcG9ydFN5bWJvbHM7XG4gICAgaWYgKHN1cHBvcnRMaXN0Lmxlbmd0aCA9PSAwKSByZXR1cm5cbiAgICBpZiAobW9kdWxlRGF0YS5zZWFyY2hXb3JkLnRyaW0oKSA9PSBcIlwiKSB7XG4gICAgICAgIG1vZHVsZURhdGEuZmlsdGVyQ3VycmVuY2llcyA9IHN1cHBvcnRMaXN0XG4gICAgfVxuICAgIG1vZHVsZURhdGEuZmlsdGVyQ3VycmVuY2llcyA9IHN1cHBvcnRMaXN0LmZpbHRlcihmdW5jdGlvbiAoaXRlbSkge1xuICAgICAgICByZXR1cm4gaXRlbS50aXRsZS50b0xvd2VyQ2FzZSgpLmluY2x1ZGVzKG1vZHVsZURhdGEuc2VhcmNoV29yZC50cmltKCkudG9Mb3dlckNhc2UoKSlcbiAgICB9KVxuICAgIHJlc2V0Q3VycmVuY3lTZWFyY2hVSSgpO1xufVxuXG4vLyBUZXh0VmlldyDnhKbngrlcbm1vZHVsZUV2ZW50Lm9uRm9jdXNDaGFuZ2UgPSBhc3luYyBmdW5jdGlvbiAoaXNGb2N1cykge1xuICAgIG1vZHVsZURhdGEuaXNGb2N1cyA9IGlzRm9jdXM7XG4gICAgY29uc29sZS5sb2coYHdwIG9uRm9jdXNDaGFuZ2UgaXNGb2N1cz0ke2lzRm9jdXN9YCk7XG4gICAgbW9kdWxlRGF0YS5ib3JkZXJDb2xvciA9IGN1cnJlbnRCb2FyZGVyQ29sb3IoaXNGb2N1cyk7XG4gICAgbW9kdWxlRGF0YS5jbGVhclZpc2libGUgPSBpc0ZvY3VzID8gXCJ2aXNpYmxlXCIgOiBcImdvbmVcIjtcbn1cblxuZnVuY3Rpb24gY3VycmVudEJvYXJkZXJDb2xvcihpc0ZvY3VzKSB7XG4gICAgcmV0dXJuIGlzRm9jdXMgPyBFZGl0X0JvYXJkX1NlbGVjdENvbG9yIDogRWRpdF9Cb2FyZF9Ob21hbENvbG9yO1xufVxuXG5tb2R1bGVFdmVudC5vblRleHRDaGFuZ2UgPSBmdW5jdGlvbiAoKSB7XG4gICAgZmlsdGVyTGlzdCgpXG59XG5cbmFzeW5jIGZ1bmN0aW9uIGZpbHRlckN1cnJlbmN5KGluZGV4KSB7XG4gICAgY29uc29sZS5sb2coYHdwIGZpbHRlckN1cnJlbmN5cyBpbmRleD0ke2luZGV4fWApO1xuICAgIHZhciBzZWxlY3RlZEl0ZW0gPSBudWxsO1xuICAgIGxldCBzdXBwb3J0TGlzdCA9IChtb2R1bGVEYXRhLmN1ck1vZGVUeXBlID09IE1vZGVUeXBlLnN1cGVyTWFyZ2luKSA/IHN1cHBvcnRDdXJyZW5jaWVzIDogc3VwcG9ydFN5bWJvbHM7XG4gICAgZm9yICh2YXIgaSA9IDA7IGkgPCBzdXBwb3J0TGlzdC5sZW5ndGg7IGkrKykge1xuICAgICAgICB2YXIgaXRlbSA9IHN1cHBvcnRMaXN0W2ldO1xuICAgICAgICBpZiAoaSA9PSBpbmRleCkge1xuICAgICAgICAgICAgc2VsZWN0ZWRJdGVtID0gaXRlbTtcbiAgICAgICAgfVxuICAgICAgICBpdGVtLnRpdGxlQ29sb3IgPSBidXR0b25UaXRsZUNvbG9yX05vcm1hbDtcbiAgICAgICAgaXRlbS5jdXJyZW5jeVNlbGVjdGVkID0gXCJnb25lXCI7XG4gICAgfVxuXG4gICAgaWYgKHNlbGVjdGVkSXRlbSAhPSBudWxsKSB7XG4gICAgICAgIHNlbGVjdGVkSXRlbS50aXRsZUNvbG9yID0gYnV0dG9uVGl0bGVDb2xvcl9TZWxlY3RlZDtcbiAgICAgICAgc2VsZWN0ZWRJdGVtLmN1cnJlbmN5U2VsZWN0ZWQgPSBcInZpc2libGVcIjtcbiAgICAgICAgbW9kdWxlRGF0YS5jdXJyZW5jeVRleHQgPSBzZWxlY3RlZEl0ZW0udGl0bGU7XG4gICAgICAgIG1vZHVsZURhdGEuY3VyU3ltYm9sID0gc2VsZWN0ZWRJdGVtLnN5bWJvbDtcbiAgICB9XG4gICAgbW9kdWxlRGF0YS5jdXJGaWx0ZXJDdXJyZW5jeUluZGV4ID0gaW5kZXg7XG4gICAgbW9kdWxlRGF0YS5jdXJyZW5jeVNob3cgPSBcImZhbHNlXCI7XG4gICAgbW9kdWxlRGF0YS5jdXJyZW5jeUljb24gPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9hcnJvd19kb3duXCI7XG4gICAgbW9kdWxlRGF0YS5maWx0ZXJDdXJyZW5jaWVzID0gc3VwcG9ydExpc3Q7XG4gICAgbW9kdWxlRGF0YS5pc0ZvY3VzID0gZmFsc2VcbiAgICBpZiAoY29tbW9uLmNvbW1vbkRhdGEuT1MgPT0gMSkge1xuICAgICAgICAkbmF0aXZlQVBJLmNsb3NlS2V5Ym9hcmQoKVxuICAgIH1cbiAgICByZXF1ZXN0RGF0YShmYWxzZSk7XG59XG5cbi8v5pu05aSa562b6YCJ5by55qGG6YC76L6RXG5hc3luYyBmdW5jdGlvbiBmaWx0ZXJNb3JlUG9wRGlzbWlzcygpIHtcbiAgICBtb2R1bGVEYXRhLmZpbHRlck1vcmVTaG93ID0gXCJmYWxzZVwiO1xufVxuXG5hc3luYyBmdW5jdGlvbiBmaWx0ZXJUaW1lKGluZGV4KSB7XG4gICAgZmlsdGVyVGltZVVJKGluZGV4KTtcbiAgICBtb2R1bGVEYXRhLmN1ckZpbHRlclRpbWVJbmRleCA9IGluZGV4O1xuICAgIG1vZHVsZURhdGEuc3RhcnRUaW1lID0gZ2V0U3RhcnREYXkoaW5kZXgpO1xuICAgIG1vZHVsZURhdGEuZW5kVGltZSA9IGdldERheSgwKTtcbn1cblxuZnVuY3Rpb24gZmlsdGVyVGltZVVJKGluZGV4KSB7XG4gICAgdmFyIHNlbGVjdGVkSXRlbSA9IG51bGw7XG4gICAgZm9yICh2YXIgaSA9IDA7IGkgPCBtb2R1bGVEYXRhLmZpbHRlclRpbWVzLmxlbmd0aDsgaSsrKSB7XG4gICAgICAgIHZhciBpdGVtID0gbW9kdWxlRGF0YS5maWx0ZXJUaW1lc1tpXTtcbiAgICAgICAgaWYgKGkgPT0gaW5kZXgpIHtcbiAgICAgICAgICAgIHNlbGVjdGVkSXRlbSA9IGl0ZW07XG4gICAgICAgIH1cbiAgICAgICAgaXRlbS50aXRsZUNvbG9yID0gYnV0dG9uVGl0bGVDb2xvcl9Ob3JtYWw7XG4gICAgICAgIGl0ZW0udGltZUJhY2tDb2xvciA9IGJ1dHRvbkJhY2tDb2xvcl9Ob3JtYWw7XG4gICAgfVxuXG4gICAgaWYgKHNlbGVjdGVkSXRlbSAhPSBudWxsKSB7XG4gICAgICAgIHNlbGVjdGVkSXRlbS50aXRsZUNvbG9yID0gYnV0dG9uVGl0bGVDb2xvcl9TZWxlY3RlZDtcbiAgICAgICAgc2VsZWN0ZWRJdGVtLnRpbWVCYWNrQ29sb3IgPSBidXR0b25CYWNrQ29sb3JfU2VsZWN0ZWQ7XG4gICAgfVxufVxuXG5hc3luYyBmdW5jdGlvbiBmaWx0ZXJTdGFydFRpbWUoKSB7XG4gICAgY29uc3Qgc3RhcnRUaW1lc3RhbXAgPSBuZXcgRGF0ZShtb2R1bGVEYXRhLnN0YXJ0VGltZSkuZ2V0VGltZSgpO1xuICAgIGNvbnN0IGVuZFRpbWVzdGFtcCA9IG5ldyBEYXRlKG1vZHVsZURhdGEuZW5kVGltZSkuZ2V0VGltZSgpO1xuICAgIHZhciBwYXJhbSA9IHsgdGl0bGU6ICRpMThuLm5fb3JkZXJfZmlsdGVyX3N0YXJ0X3RpbWUsIGlzU2VsZWN0ZWRTdGFydERhdGU6IDEsIHN0YXJ0RGF0ZTogc3RhcnRUaW1lc3RhbXAsIGVuZERhdGU6IGVuZFRpbWVzdGFtcCB9O1xuICAgIHZhciBzZWxlY3RlZFRpbWUgPSBhd2FpdCBjb21tb24uc2hvd0RhdGVQaWNrZXIocGFyYW0pO1xuICAgIGlmIChzZWxlY3RlZFRpbWUgIT0gbnVsbCkge1xuICAgICAgICBtb2R1bGVEYXRhLnN0YXJ0VGltZSA9IG5ldyBEYXRlKHNlbGVjdGVkVGltZSkuRm9ybWF0KFwieXl5eS1NTS1kZFwiKTtcbiAgICAgICAgbW9kdWxlRGF0YS5jdXJGaWx0ZXJUaW1lSW5kZXggPSAtMTtcbiAgICAgICAgZmlsdGVyVGltZVVJKC0xKTtcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIGZpbHRlckVuZFRpbWUoKSB7XG4gICAgY29uc3Qgc3RhcnRUaW1lc3RhbXAgPSBuZXcgRGF0ZShtb2R1bGVEYXRhLnN0YXJ0VGltZSkuZ2V0VGltZSgpO1xuICAgIGNvbnN0IGVuZFRpbWVzdGFtcCA9IG5ldyBEYXRlKG1vZHVsZURhdGEuZW5kVGltZSkuZ2V0VGltZSgpO1xuICAgIHZhciBwYXJhbSA9IHsgdGl0bGU6ICRpMThuLm5fb3JkZXJfZmlsdGVyX2VuZF90aW1lLCBpc1NlbGVjdGVkU3RhcnREYXRlOiAwLCBzdGFydERhdGU6IHN0YXJ0VGltZXN0YW1wLCBlbmREYXRlOiBlbmRUaW1lc3RhbXAgfTtcbiAgICB2YXIgc2VsZWN0ZWRUaW1lID0gYXdhaXQgY29tbW9uLnNob3dEYXRlUGlja2VyKHBhcmFtKTtcbiAgICBpZiAoc2VsZWN0ZWRUaW1lICE9IG51bGwpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5lbmRUaW1lID0gbmV3IERhdGUoc2VsZWN0ZWRUaW1lKS5Gb3JtYXQoXCJ5eXl5LU1NLWRkXCIpO1xuICAgICAgICBtb2R1bGVEYXRhLmN1ckZpbHRlclRpbWVJbmRleCA9IC0xO1xuICAgICAgICBmaWx0ZXJUaW1lVUkoLTEpO1xuICAgIH1cbn1cblxuYXN5bmMgZnVuY3Rpb24gZmlsdGVyVHlwZShpbmRleCkge1xuICAgIGNvbnNvbGUubG9nKGB3cCBmaWx0ZXJUeXBlIGluZGV4PSR7aW5kZXh9YCk7XG4gICAgXG4gICAgaWYobW9kdWxlRGF0YS5jdXJGaWx0ZXJUeXBlSW5kZXggIT0gaW5kZXgpIHtcbiAgICAgICAgdmFyIHNlbGVjdGVkSXRlbSA9IG51bGw7XG4gICAgICAgIGZvciAodmFyIGkgPSAwOyBpIDwgY29tbW9uRmlsdGVyVHlwZXMubGVuZ3RoOyBpKyspIHtcbiAgICAgICAgICAgIHZhciBpdGVtID0gY29tbW9uRmlsdGVyVHlwZXNbaV07XG4gICAgICAgICAgICBpZiAoaSA9PSBpbmRleCkge1xuICAgICAgICAgICAgICAgIHNlbGVjdGVkSXRlbSA9IGl0ZW07XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBpdGVtLnRpdGxlQ29sb3IgPSBidXR0b25UaXRsZUNvbG9yX05vcm1hbDtcbiAgICAgICAgICAgIGl0ZW0uYmFja0NvbG9yID0gYnV0dG9uQmFja0NvbG9yX05vcm1hbDtcbiAgICAgICAgfVxuICAgIFxuICAgICAgICBpZiAoc2VsZWN0ZWRJdGVtICE9IG51bGwpIHtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGB3cCBmaWx0ZXJUeXBlIHNlbGVjdGVkSXRlbS5pbmRleD0ke3NlbGVjdGVkSXRlbS5pbmRleH1gKTtcbiAgICAgICAgICAgIHNlbGVjdGVkSXRlbS50aXRsZUNvbG9yID0gYnV0dG9uVGl0bGVDb2xvcl9TZWxlY3RlZDtcbiAgICAgICAgICAgIHNlbGVjdGVkSXRlbS5iYWNrQ29sb3IgPSBidXR0b25CYWNrQ29sb3JfU2VsZWN0ZWQ7XG4gICAgICAgIH1cbiAgICAgICAgXG4gICAgICAgIG1vZHVsZURhdGEuZmlsdGVyVHlwZXMgPSBjb21tb25GaWx0ZXJUeXBlcztcbiAgICAgICAgbW9kdWxlRGF0YS5jdXJGaWx0ZXJUeXBlSW5kZXggPSBpbmRleDtcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIGZpbHRlclJlc2V0KCkge1xuICAgIGZpbHRlclRpbWUoMik7XG4gICAgZmlsdGVyVHlwZSgwKTtcbiAgICBkZWZhdWx0RmlsdGVyRGF0YSgpO1xufVxuXG5hc3luYyBmdW5jdGlvbiBmaWx0ZXJTdXJlKCkge1xuICAgIG1vZHVsZURhdGEuZmlsdGVyTW9yZVNob3cgPSBcImZhbHNlXCI7XG4gICAgcmVxdWVzdERhdGEoZmFsc2UpO1xufVxuXG5mdW5jdGlvbiBkZWZhdWx0RmlsdGVyRGF0YSgpIHtcbiAgICBtb2R1bGVEYXRhLnN0YXJ0VGltZSA9IGdldERheSgtMTE5KTsvLzEyMOWkqeWJjeaXpeacn1xuICAgIG1vZHVsZURhdGEuZW5kVGltZSA9IGdldERheSgwKTsvL+W9k+WkqeaXpeacn1xuICAgIG1vZHVsZURhdGEuY3VyRmlsdGVyVGltZUluZGV4ID0gMjsvL+m7mOiupOi/kTEyMOWkqVxuICAgIG1vZHVsZURhdGEuY3VyRmlsdGVyVHlwZUluZGV4ID0gMDsvL+m7mOiupOWFqOmDqOexu+Wei1xufVxuXG5mdW5jdGlvbiBnZXRTdGFydERheShpbmRleCkge1xuICAgIGlmIChpbmRleCA9PSAwKSB7XG4gICAgICAgIHJldHVybiBnZXREYXkoLTYpO1xuICAgIH0gZWxzZSBpZiAoaW5kZXggPT0gMSkge1xuICAgICAgICByZXR1cm4gZ2V0RGF5KC0yOSk7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgcmV0dXJuIGdldERheSgtMTE5KTtcbiAgICB9XG59XG5cbmZ1bmN0aW9uIGdldERheShkYXkpIHtcbiAgICB2YXIgdG9kYXkgPSBuZXcgRGF0ZSgpO1xuICAgIHZhciB0YXJnZXRkYXlfbWlsbGlzZWNvbmRzID0gdG9kYXkuZ2V0VGltZSgpICsgMTAwMCAqIDYwICogNjAgKiAyNCAqIGRheTtcbiAgICB0b2RheS5zZXRUaW1lKHRhcmdldGRheV9taWxsaXNlY29uZHMpO1xuICAgIHZhciB0WWVhciA9IHRvZGF5LmdldEZ1bGxZZWFyKCk7XG4gICAgdmFyIHRNb250aCA9IHRvZGF5LmdldE1vbnRoKCk7XG4gICAgdmFyIHREYXRlID0gdG9kYXkuZ2V0RGF0ZSgpO1xuICAgIHRNb250aCA9IGRvSGFuZGxlTW9udGgodE1vbnRoICsgMSk7XG4gICAgdERhdGUgPSBkb0hhbmRsZU1vbnRoKHREYXRlKTtcbiAgICByZXR1cm4gdFllYXIgKyBcIi1cIiArIHRNb250aCArIFwiLVwiICsgdERhdGU7XG59XG5cbmZ1bmN0aW9uIGRvSGFuZGxlTW9udGgobW9udGgpIHtcbiAgICB2YXIgbSA9IG1vbnRoO1xuICAgIGlmIChtb250aC50b1N0cmluZygpLmxlbmd0aCA9PSAxKSB7XG4gICAgICAgIG0gPSBcIjBcIiArIG1vbnRoO1xuICAgIH1cbiAgICByZXR1cm4gbTtcbn1cblxuZnVuY3Rpb24gZ2V0RmlsdGVyTW9yZVR5cGVzKCkge1xuICAgIGlmIChtb2R1bGVEYXRhLmN1cnJlbnRUYWJUeXBlID09IFRhYlR5cGUuVGFiVHlwZUxvYW4pIHtcbiAgICAgICAgcmV0dXJuIFt7IHR5cGU6IFwibm9ybWFsXCIsIHRpdGxlOiAkaTE4bi5uX29wdGlvbl9tYXJrZXRfbGlzdF9zZXR0aW5nX2FsbF90eXBlLCB0aXRsZUNvbG9yOiBidXR0b25UaXRsZUNvbG9yX1NlbGVjdGVkLCBiYWNrQ29sb3I6IGJ1dHRvbkJhY2tDb2xvcl9TZWxlY3RlZCwgaW5kZXg6IDAsIHRhZzogMCB9LFxuICAgICAgICB7IHR5cGU6IFwibm9ybWFsXCIsIHRpdGxlOiAkaTE4bi5uX3RyYWRlX21hcmdpbl9hdXRvX2JvcnJvdywgdGl0bGVDb2xvcjogYnV0dG9uVGl0bGVDb2xvcl9Ob3JtYWwsIGJhY2tDb2xvcjogYnV0dG9uQmFja0NvbG9yX05vcm1hbCwgaW5kZXg6IDEsIHRhZzogMTEgfSxcbiAgICAgICAgeyB0eXBlOiBcIm5vcm1hbFwiLCB0aXRsZTogJGkxOG4ubl9tYXJnaW5fbWFudWFsX2xvYW4sIHRpdGxlQ29sb3I6IGJ1dHRvblRpdGxlQ29sb3JfTm9ybWFsLCBiYWNrQ29sb3I6IGJ1dHRvbkJhY2tDb2xvcl9Ob3JtYWwsIGluZGV4OiAyLCB0YWc6IDEyIH1dO1xuICAgIH0gZWxzZSBpZiAobW9kdWxlRGF0YS5jdXJyZW50VGFiVHlwZSA9PSBUYWJUeXBlLlRhYlR5cGVSZXBheSkge1xuICAgICAgICByZXR1cm4gW3sgdHlwZTogXCJub3JtYWxcIiwgdGl0bGU6ICRpMThuLm5fb3B0aW9uX21hcmtldF9saXN0X3NldHRpbmdfYWxsX3R5cGUsIHRpdGxlQ29sb3I6IGJ1dHRvblRpdGxlQ29sb3JfU2VsZWN0ZWQsIGJhY2tDb2xvcjogYnV0dG9uQmFja0NvbG9yX1NlbGVjdGVkLCBpbmRleDogMCwgdGFnOiAwIH0sXG4gICAgICAgIHsgdHlwZTogXCJub3JtYWxcIiwgdGl0bGU6ICRpMThuLm5fdHJhZGVfbWFyZ2luX2F1dG9fcmVwYXksIHRpdGxlQ29sb3I6IGJ1dHRvblRpdGxlQ29sb3JfTm9ybWFsLCBiYWNrQ29sb3I6IGJ1dHRvbkJhY2tDb2xvcl9Ob3JtYWwsIGluZGV4OiAxLCB0YWc6IDIyIH0sXG4gICAgICAgIHsgdHlwZTogXCJub3JtYWxcIiwgdGl0bGU6ICRpMThuLm5fbWFyZ2luX21hbnVhbF9yZXBheSwgdGl0bGVDb2xvcjogYnV0dG9uVGl0bGVDb2xvcl9Ob3JtYWwsIGJhY2tDb2xvcjogYnV0dG9uQmFja0NvbG9yX05vcm1hbCwgaW5kZXg6IDIsIHRhZzogMjEgfSxcbiAgICAgICAgeyB0eXBlOiBcIm5vcm1hbFwiLCB0aXRsZTogJGkxOG4ubl9tYXJnaW5fYXV0b19kZWR1Y3Rpb25fcmVwYXksIHRpdGxlQ29sb3I6IGJ1dHRvblRpdGxlQ29sb3JfTm9ybWFsLCBiYWNrQ29sb3I6IGJ1dHRvbkJhY2tDb2xvcl9Ob3JtYWwsIGluZGV4OiAzLCB0YWc6IDIzIH0sXG4gICAgICAgIHsgdHlwZTogXCJub3JtYWxcIiwgdGl0bGU6ICRpMThuLm5fbWFyZ2luX3N5c3RlbV9yZXBheSwgdGl0bGVDb2xvcjogYnV0dG9uVGl0bGVDb2xvcl9Ob3JtYWwsIGJhY2tDb2xvcjogYnV0dG9uQmFja0NvbG9yX05vcm1hbCwgaW5kZXg6IDQsIHRhZzogMjQgfV07XG4gICAgfSBlbHNlIGlmIChtb2R1bGVEYXRhLmN1cnJlbnRUYWJUeXBlID09IFRhYlR5cGUuVGFiVHlwZUludGVyZXN0KSB7XG4gICAgICAgIHJldHVybiBbeyB0eXBlOiBcIm5vcm1hbFwiLCB0aXRsZTogJGkxOG4ubl9vcHRpb25fbWFya2V0X2xpc3Rfc2V0dGluZ19hbGxfdHlwZSwgdGl0bGVDb2xvcjogYnV0dG9uVGl0bGVDb2xvcl9TZWxlY3RlZCwgYmFja0NvbG9yOiBidXR0b25CYWNrQ29sb3JfU2VsZWN0ZWQsIGluZGV4OiAwLCB0YWc6IDAgfSxcbiAgICAgICAgeyB0eXBlOiBcIm5vcm1hbFwiLCB0aXRsZTogJGkxOG4ubl9tYXJnaW5fbG9hbl9pbnRlcmVzdCwgdGl0bGVDb2xvcjogYnV0dG9uVGl0bGVDb2xvcl9Ob3JtYWwsIGJhY2tDb2xvcjogYnV0dG9uQmFja0NvbG9yX05vcm1hbCwgaW5kZXg6IDEsIHRhZzogMzIgfSxcbiAgICAgICAgeyB0eXBlOiBcIm5vcm1hbFwiLCB0aXRsZTogJGkxOG4ubl9tYXJnaW5fdGltaW5nX2ludGVyZXN0LCB0aXRsZUNvbG9yOiBidXR0b25UaXRsZUNvbG9yX05vcm1hbCwgYmFja0NvbG9yOiBidXR0b25CYWNrQ29sb3JfTm9ybWFsLCBpbmRleDogMiwgdGFnOiAzMSB9XTtcbiAgICB9XG4gICAgcmV0dXJuIFtdO1xufVxuXG5mdW5jdGlvbiBnZXRUYWJUaXRsZURhdGEoKSB7XG4gICAgdmFyIGxvYW5UaXRsZUNvbG9yID0gbW9kdWxlRGF0YS5jdXJyZW50VGFiVHlwZSA9PSBUYWJUeXBlLlRhYlR5cGVMb2FuID8gdGl0bGVDb2xvcl9TZWxlY3RlZCA6IHRpdGxlQ29sb3JfTm9ybWFsO1xuICAgIHZhciByZXBheVRpdGxlQ29sb3IgPSBtb2R1bGVEYXRhLmN1cnJlbnRUYWJUeXBlID09IFRhYlR5cGUuVGFiVHlwZVJlcGF5ID8gdGl0bGVDb2xvcl9TZWxlY3RlZCA6IHRpdGxlQ29sb3JfTm9ybWFsO1xuICAgIHZhciBpbnRlcmVzdFRpdGxlQ29sb3IgPSBtb2R1bGVEYXRhLmN1cnJlbnRUYWJUeXBlID09IFRhYlR5cGUuVGFiVHlwZUludGVyZXN0ID8gdGl0bGVDb2xvcl9TZWxlY3RlZCA6IHRpdGxlQ29sb3JfTm9ybWFsO1xuICAgIHJldHVybiBbeyB0eXBlOiBcIm5vcm1hbFwiLCB0aXRsZTogJGkxOG4ubl9tYXJnaW5fbG9hbl9oaXN0b3J5LCB0aXRsZUNvbG9yOiBsb2FuVGl0bGVDb2xvciwgdGFnOiBUYWJUeXBlLlRhYlR5cGVMb2FuIH0sXG4gICAgeyB0eXBlOiBcIm5vcm1hbFwiLCB0aXRsZTogJGkxOG4ubl9tYXJnaW5fcmVwYXlfaGlzdG9yeSwgdGl0bGVDb2xvcjogcmVwYXlUaXRsZUNvbG9yLCB0YWc6IFRhYlR5cGUuVGFiVHlwZVJlcGF5IH0sXG4gICAgeyB0eXBlOiBcIm5vcm1hbFwiLCB0aXRsZTogJGkxOG4ubl9tYXJnaW5faW50ZXJlc3RfaGlzdG9yeSwgdGl0bGVDb2xvcjogaW50ZXJlc3RUaXRsZUNvbG9yLCB0YWc6IFRhYlR5cGUuVGFiVHlwZUludGVyZXN0IH1dO1xufVxuXG4vL+WIl+ihqOm7mOiupOaVsOaNrlxuZnVuY3Rpb24gZ2V0VGFiTGlzdERlZmF1bHREYXRhKCkge1xuICAgIHJldHVybiB7XG4gICAgICAgIGRhdGE6IFtdLFxuICAgICAgICBlbXB0eVZpc2libGU6IFwiZ29uZVwiLFxuICAgICAgICBsaXN0VmlzaWJsZTogXCJnb25lXCIsXG4gICAgICAgIHNob3dMb2FkaW5nOiB0cnVlLFxuICAgICAgICBmcm9tOiAtMSxcbiAgICB9O1xufVxuXG5mdW5jdGlvbiBnZXRUeXBlUG9wQ29udGVudCh0eXBlKSB7XG4gICAgaWYgKG1vZHVsZURhdGEuY3VycmVudFRhYlR5cGUgPT0gVGFiVHlwZS5UYWJUeXBlTG9hbikge1xuICAgICAgICBpZiAodHlwZSA9PSAxMSkge1xuICAgICAgICAgICAgcmV0dXJuICRpMThuLm5fbWFyZ2luX2F1dG9fbG9hbl90aXBzO1xuICAgICAgICB9IGVsc2UgaWYgKHR5cGUgPT0gMTIpIHtcbiAgICAgICAgICAgIHJldHVybiAkaTE4bi5uX21hcmdpbl9tYW51YWxfbG9hbl90aXBzO1xuICAgICAgICB9XG4gICAgfSBlbHNlIGlmIChtb2R1bGVEYXRhLmN1cnJlbnRUYWJUeXBlID09IFRhYlR5cGUuVGFiVHlwZVJlcGF5KSB7XG4gICAgICAgIGlmICh0eXBlID09IDIyKSB7XG4gICAgICAgICAgICByZXR1cm4gJGkxOG4ubl9tYXJnaW5fYXV0b19yZXBheV90aXBzO1xuICAgICAgICB9IGVsc2UgaWYgKHR5cGUgPT0gMjEpIHtcbiAgICAgICAgICAgIHJldHVybiAkaTE4bi5uX21hcmdpbl9tYW51YWxfcmVwYXlfdGlwcztcbiAgICAgICAgfSBlbHNlIGlmICh0eXBlID09IDIzKSB7XG4gICAgICAgICAgICByZXR1cm4gJGkxOG4ubl9tYXJnaW5fYXV0b19kZWR1Y3Rpb25fcmVwYXlfdGlwcztcbiAgICAgICAgfSBlbHNlIGlmICh0eXBlID09IDI0KSB7XG4gICAgICAgICAgICByZXR1cm4gJGkxOG4ubl9tYXJnaW5fc3lzdGVtX3JlcGF5X3RpcHM7XG4gICAgICAgIH1cbiAgICB9IGVsc2UgaWYgKG1vZHVsZURhdGEuY3VycmVudFRhYlR5cGUgPT0gVGFiVHlwZS5UYWJUeXBlSW50ZXJlc3QpIHtcbiAgICAgICAgaWYgKHR5cGUgPT0gMzEpIHtcbiAgICAgICAgICAgIHJldHVybiAkaTE4bi5uX21hcmdpbl90aW1pbmdfaW50ZXJlc3RfdGlwcztcbiAgICAgICAgfSBlbHNlIGlmICh0eXBlID09IDMyKSB7XG4gICAgICAgICAgICByZXR1cm4gJGkxOG4ubl9tYXJnaW5fbG9hbl9pbnRlcmVzdF90aXBzO1xuICAgICAgICB9XG4gICAgfVxuICAgIHJldHVybiAnLS0nO1xufVxuXG5mdW5jdGlvbiBnZXRUeXBlQ29udGVudCh0eXBlKSB7XG4gICAgaWYgKG1vZHVsZURhdGEuY3VycmVudFRhYlR5cGUgPT0gVGFiVHlwZS5UYWJUeXBlTG9hbikge1xuICAgICAgICBpZiAodHlwZSA9PSAxMSkge1xuICAgICAgICAgICAgcmV0dXJuICRpMThuLm5fdHJhZGVfbWFyZ2luX2F1dG9fYm9ycm93O1xuICAgICAgICB9IGVsc2UgaWYgKHR5cGUgPT0gMTIpIHtcbiAgICAgICAgICAgIHJldHVybiAkaTE4bi5uX21hcmdpbl9tYW51YWxfbG9hbjtcbiAgICAgICAgfVxuICAgIH0gZWxzZSBpZiAobW9kdWxlRGF0YS5jdXJyZW50VGFiVHlwZSA9PSBUYWJUeXBlLlRhYlR5cGVSZXBheSkge1xuICAgICAgICBpZiAodHlwZSA9PSAyMSkge1xuICAgICAgICAgICAgcmV0dXJuICRpMThuLm5fbWFyZ2luX21hbnVhbF9yZXBheTtcbiAgICAgICAgfSBlbHNlIGlmICh0eXBlID09IDIyKSB7XG4gICAgICAgICAgICByZXR1cm4gJGkxOG4ubl9tYXJnaW5fYXV0b19yZXBheTtcbiAgICAgICAgfSBlbHNlIGlmICh0eXBlID09IDIzKSB7XG4gICAgICAgICAgICByZXR1cm4gJGkxOG4ubl9tYXJnaW5fYXV0b19kZWR1Y3Rpb25fcmVwYXk7XG4gICAgICAgIH0gZWxzZSBpZiAodHlwZSA9PSAyNCkge1xuICAgICAgICAgICAgcmV0dXJuICRpMThuLm5fbWFyZ2luX3N5c3RlbV9yZXBheTtcbiAgICAgICAgfVxuICAgIH0gZWxzZSBpZiAobW9kdWxlRGF0YS5jdXJyZW50VGFiVHlwZSA9PSBUYWJUeXBlLlRhYlR5cGVJbnRlcmVzdCkge1xuICAgICAgICBpZiAodHlwZSA9PSAzMSkge1xuICAgICAgICAgICAgcmV0dXJuICRpMThuLm5fbWFyZ2luX3RpbWluZ19pbnRlcmVzdDtcbiAgICAgICAgfSBlbHNlIGlmICh0eXBlID09IDMyKSB7XG4gICAgICAgICAgICByZXR1cm4gJGkxOG4ubl9tYXJnaW5fbG9hbl9pbnRlcmVzdDtcbiAgICAgICAgfVxuICAgIH1cbiAgICByZXR1cm4gJy0tJztcbn1cblxuYXN5bmMgZnVuY3Rpb24gb25SZWZyZXNoKCkge1xuICAgIHJlcXVlc3REYXRhKGZhbHNlKTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gb25Mb2FkTW9yZSgpIHtcbiAgICB2YXIgY3VyRGF0YSA9IGNvbW1vbkxpc3RbbW9kdWxlRGF0YS5jdXJyZW50VGFiVHlwZV07XG4gICAgaWYgKGN1ckRhdGEuZnJvbSAhPT0gLTEpIHtcbiAgICAgICAgcmVxdWVzdERhdGEodHJ1ZSk7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgbW9kdWxlRGF0YS5sb2FkTW9yZVN0YXR1cyA9IFwiMlwiO1xuICAgIH1cbn1cblxuLy/mkJzntKLluIHnp43luIHlr7nmuIXnqbpcbmZ1bmN0aW9uIGNsaWNrZWRDbGVhcigpIHtcbiAgICBtb2R1bGVEYXRhLmZpbHRlckN1cnJlbmNpZXMgPSAobW9kdWxlRGF0YS5jdXJNb2RlVHlwZSA9PSBNb2RlVHlwZS5zdXBlck1hcmdpbikgPyBzdXBwb3J0Q3VycmVuY2llcyA6IHN1cHBvcnRTeW1ib2xzO1xuICAgIG1vZHVsZURhdGEuc2VhcmNoV29yZCA9IFwiXCI7XG4gICAgcmVzZXRDdXJyZW5jeVNlYXJjaFVJKCk7XG59XG5cbmZ1bmN0aW9uIHR5cGVDbGljayh0eXBlKSB7XG4gICAgbGV0IGNvbmV0ZW50ID0gZ2V0VHlwZVBvcENvbnRlbnQodHlwZSk7XG4gICAgY29tbW9uUG9wLnBvcFVwQ29udGVudE9mT25lQnV0dG9uKCRpMThuLm5fbWluaW5nX3R5cGUsIGNvbmV0ZW50KTtcbn1cblxubW9kdWxlRXZlbnQuZmlsdGVyQ2xpY2sgPSBmaWx0ZXJDbGljaztcbm1vZHVsZUV2ZW50LnRhYkNsaWNrID0gdGFiQ2xpY2s7XG5tb2R1bGVFdmVudC50eXBlQ2xpY2sgPSB0eXBlQ2xpY2s7XG5tb2R1bGVFdmVudC5yZXNldFRpdGxlU2VsZWN0VGFiID0gcmVzZXRUaXRsZVNlbGVjdFRhYjtcbm1vZHVsZUV2ZW50Lm1vZGVUeXBlUG9wRGlzbWlzcyA9IG1vZGVUeXBlUG9wRGlzbWlzcztcbm1vZHVsZUV2ZW50Lm1vZGVUeXBlUG9wU2VsZWN0ZWQgPSBtb2RlVHlwZVBvcFNlbGVjdGVkO1xubW9kdWxlRXZlbnQuY3VycmVuY3lQb3BEaXNtaXNzID0gY3VycmVuY3lQb3BEaXNtaXNzO1xubW9kdWxlRXZlbnQuY2xpY2tlZENsZWFyID0gY2xpY2tlZENsZWFyO1xubW9kdWxlRXZlbnQuZmlsdGVyTW9yZVBvcERpc21pc3MgPSBmaWx0ZXJNb3JlUG9wRGlzbWlzcztcbm1vZHVsZUV2ZW50LmZpbHRlckN1cnJlbmN5ID0gZmlsdGVyQ3VycmVuY3k7XG5tb2R1bGVFdmVudC5maWx0ZXJTdGFydFRpbWUgPSBmaWx0ZXJTdGFydFRpbWU7XG5tb2R1bGVFdmVudC5maWx0ZXJFbmRUaW1lID0gZmlsdGVyRW5kVGltZTtcbm1vZHVsZUV2ZW50LmZpbHRlclRpbWUgPSBmaWx0ZXJUaW1lO1xubW9kdWxlRXZlbnQuZmlsdGVyVHlwZSA9IGZpbHRlclR5cGU7XG5tb2R1bGVFdmVudC5maWx0ZXJSZXNldCA9IGZpbHRlclJlc2V0O1xubW9kdWxlRXZlbnQuZmlsdGVyU3VyZSA9IGZpbHRlclN1cmU7XG5tb2R1bGVFdmVudC5vblJlZnJlc2ggPSBvblJlZnJlc2g7XG5tb2R1bGVFdmVudC5vbkxvYWRNb3JlID0gb25Mb2FkTW9yZTsiLCJpbXBvcnQgKiBhcyBjb21tb24gZnJvbSBcIi4vY29tbW9uXCI7XG5cbmltcG9ydCAqIGFzIGhvbWUgZnJvbSBcIi4vaG9tZVwiO1xuaW1wb3J0ICogYXMgbGV2ZXJIaXN0b3J5IGZyb20gXCIuL2xldmVySGlzdG9yeVwiO1xuaW1wb3J0ICogYXMgc2VsZWN0Q3VycmVuY3lQb3AgZnJvbSBcIi4vc2VsZWN0Q3VycmVuY3lQb3BcIjtcblxuXG5mdW5jdGlvbiBzZW5kQ29tbW9uQ29uZmlnKHBhcmFtKSB7XG4gICAgY29tbW9uLnNlbmRDb21tb25Db25maWcocGFyYW0pO1xufVxuXG5hc3luYyBmdW5jdGlvbiBtb2R1bGVBcHBlYXIoKSB7XG4gICAgY29uc29sZS5sb2coJ21vZHVsZUFwcGVhcicpO1xufVxuXG5mdW5jdGlvbiBtb2R1bGVXaWxsRGlzYXBwZWFyKCkge1xufVxuXG5hc3luYyBmdW5jdGlvbiBtb2R1bGVEaXNhcHBlYXIoKSB7XG4gICAgY29uc29sZS5sb2coJ21vZHVsZURpc2FwcGVhcicpO1xufVxuXG4kZXZlbnQuc2VuZENvbW1vbkNvbmZpZyA9IHNlbmRDb21tb25Db25maWc7XG4kZXZlbnQubW9kdWxlQXBwZWFyID0gbW9kdWxlQXBwZWFyO1xuJGV2ZW50Lm1vZHVsZURpc2FwcGVhciA9IG1vZHVsZURpc2FwcGVhcjtcbiRldmVudC5tb2R1bGVXaWxsRGlzYXBwZWFyID0gbW9kdWxlV2lsbERpc2FwcGVhcjsiXSwibmFtZXMiOlsiRFAiLCJSTSIsIk1BWF9EUCIsIk1BWF9QT1dFUiIsIk5FIiwiUEUiLCJOQU1FIiwiSU5WQUxJRCIsIklOVkFMSURfRFAiLCJJTlZBTElEX1JNIiwiRElWX0JZX1pFUk8iLCJQIiwiVU5ERUZJTkVEIiwiTlVNRVJJQyIsIl9CaWdfIiwiQmlnIiwibiIsIngiLCJ0aGlzIiwicyIsImUiLCJjIiwic2xpY2UiLCJwYXJzZSIsImNvbnN0cnVjdG9yIiwicHJvdG90eXBlIiwidmVyc2lvbiIsImkiLCJubCIsInRlc3QiLCJFcnJvciIsImNoYXJBdCIsImluZGV4T2YiLCJyZXBsYWNlIiwic2VhcmNoIiwic3Vic3RyaW5nIiwibGVuZ3RoIiwicm91bmQiLCJkcCIsInJtIiwibW9yZSIsInhjIiwidW5zaGlmdCIsInBvcCIsInN0cmluZ2lmeSIsImlkIiwiayIsInoiLCJwdXNoIiwiam9pbiIsImFicyIsImNtcCIsInkiLCJpc25lZyIsInljIiwiaiIsImwiLCJkaXYiLCJhIiwiYiIsImJsIiwiYnQiLCJyaSIsImJ6IiwiYWkiLCJhbCIsInIiLCJybCIsInEiLCJxYyIsInFpIiwiZCIsInNoaWZ0IiwiZXEiLCJndCIsImd0ZSIsImx0IiwibHRlIiwibWludXMiLCJzdWIiLCJ0IiwieGx0eSIsInBsdXMiLCJ4ZSIsInllIiwicmV2ZXJzZSIsIm1vZCIsInlndHgiLCJ0aW1lcyIsImFkZCIsInBvdyIsIm9uZSIsInNxcnQiLCJoYWxmIiwiTWF0aCIsInRvRXhwb25lbnRpYWwiLCJtdWwiLCJBcnJheSIsInRvRml4ZWQiLCJ0b1ByZWNpc2lvbiIsInNkIiwidG9TdHJpbmciLCJ2YWx1ZU9mIiwidG9KU09OIiwibXVsdGlwbHkiLCJmb3JtYXQiLCJ2YWx1ZSIsInByZWNpc2lvbiIsImJpZ1ZhbHVlIiwic3RyaW5nVmFsdWUiLCJzY2llbnRpZmljVG9OdW1iZXIiLCJpbmNsdWRlcyIsInN0ckFycmF5Iiwic3BsaXQiLCJ0cnVuY2F0ZSIsInplcm9OdW1iZXIiLCJzdHIiLCJudW0iLCJ6ZXJvIiwicGFydHMiLCJTdHJpbmciLCJ0b0xvd2VyQ2FzZSIsInplcm9MZW4iLCJzaWduIiwiYmVmb3JlQXJyIiwiZGVjIiwiY2xpY2thYmxlIiwiVW5pdFR5cGUiLCJ1bml0VHlwZVN5bWJvbCIsInVuaXRUeXBlVVNEVCIsIlRhYlR5cGUiLCJ0YWJUeXBlUG9zaXRpb24iLCJ0YWJUeXBlT3Blbk9yZGVycyIsInRhYlR5cGVPcmRlcnMiLCJ0YWJUeXBlSGlzdG9yeSIsIkRFRkFVTFRfU1RSIiwiY29tbW9uRGF0YSIsInVzZXJTaWduIiwiY3VycmVudFN5bWJvbCIsImN1cnJlbnRDb250cmFjdEluZm8iLCJjb250cmFjdEluZm9EYXRhIiwiY29udHJhY3RINVVybCIsImN1cnJlbmN5UmF0ZSIsImN1cnJlbmN5Q2hhcmFjdGVyIiwicHJpY2VDb2xvclR5cGUiLCJjb2xvck1vZGUiLCJPUyIsImFwcFZlcnNpb24iLCJpc0luUmV2aWV3IiwiaXNMb2dpbiIsIndlYlVybCIsImxhbmd1YWdlIiwibGluZWFyU3dhcFdzRGF0YSIsInVuaXRUeXBlIiwibGFzdFVuaXRUeXBlIiwib3BlblNpbmdsZU1hcmdpbiIsImN1clRhYlR5cGUiLCJpc0NoaWxkIiwiYXN5bmMiLCJzZW5kUmVxdWVzdCIsInBhdGgiLCJwYXJhbXMiLCJtZXRob2QiLCJob3N0VHlwZSIsImhlYWRlciIsInJldHVyblN0YXR1cyIsImNvbnNvbGUiLCJsb2ciLCJKU09OIiwicGFyYW0iLCJyZXNwb25zZVN0cmluZyIsIiRuYXRpdmVBUEkiLCJyZXF1ZXN0IiwicmVzcG9uc2UiLCJjb2RlIiwiZGF0YSIsInN0YXR1cyIsImVycl9jb2RlIiwiZXJyX21zZyIsInN0YXJ0Iiwic3RhcnRJbmRleCIsImVuZCIsImVuZEluZGV4IiwiZGF0YVN0cmluZyIsInNob3dUb2FzdCIsIm1lc3NhZ2UiLCJzZW5kUmVxdWVzdFJldHVybkNvZGUiLCJmb3JtYXRQcmVjaXNpb24iLCJyZXN1bHQiLCJudW1iZXIuZm9ybWF0Iiwib3BlblVSTCIsInVybCIsIm9wZW5Sb3V0ZSIsInNldFRpbWVvdXQiLCJtc2ciLCJoYlRvYXN0Iiwic2F2ZSIsIm1vZHVsZSIsImtleSIsInN0b3JhZ2UiLCJhY3Rpb24iLCJuYW1lIiwicmVhZCIsImNsZWFyIiwic2VuZENvbW1vbkNvbmZpZyIsInBhcnNlSW50IiwibW9kdWxlRGVmaW5lIiwibW9kdWxlTmFtZSIsInN0YXJ0RnVuY3Rpb24iLCJkZWZhdWx0RGF0YUZ1bmN0aW9uIiwiJGRhdGEiLCIkZXZlbnQiLCJtb2R1bGVFdmVudCIsIm1vZHVsZURhdGEiLCJEYXRlIiwiRm9ybWF0IiwiZm10IiwibyIsImdldE1vbnRoIiwiZ2V0RGF0ZSIsImdldEhvdXJzIiwiZ2V0TWludXRlcyIsImdldFNlY29uZHMiLCJmbG9vciIsIlMiLCJnZXRNaWxsaXNlY29uZHMiLCJSZWdFeHAiLCIkMSIsImdldEZ1bGxZZWFyIiwic3Vic3RyIiwic2hvd0xvYWRpbmciLCJpc1Nob3ciLCJnZXRQTkdJY29uVVJMQnlDdXJyZW5jeSIsImN1cnJlbmN5IiwiYmFzZVVybCIsImdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudCIsImFtb3VudCIsInR5cGUiLCJwYXJhbVN0cmluZyIsInRob3VzYW5kc0Zvcm1hdHRlciIsImN1cnJlbmN5Q29tbW9uIiwiZ2V0TGVnYWxDdXJyZW5jeVN5bWJvbCIsImN1cnJlbmN5U3ltYm9sIiwiYWRkQ3VycmVudEN1cnJlbmN5U3ltYm9sIiwic291cmNlIiwic3ltYm9sIiwiYWRkQ3VycmVuY3lTeW1ib2wiLCJzdGFydHNXaXRoIiwiZ2V0QWNjb3VudElkIiwiYWNjb3VudHMiLCJhY2NvdW50Iiwic3VwZXJNYXJnaW5BY2NvdW50SWQiLCJtYXJnaW5BY2NvdW50SWQiLCJnZXRDdXJyZW5jeUxpc3QiLCJyZXF1ZXN0VHlwZSIsImN1cnJlbmN5TGlzdCIsImxvYW5DdXJyZW5jeUxpc3QiLCJyZXBheUN1cnJlbmN5TGlzdCIsImdldFN5bWJvbExpc3QiLCJzeW1ib2xMaXN0IiwibG9hblN5bWJvbExpc3QiLCJyZXBheVN5bWJvbExpc3QiLCJmb3JtYXRUaG91c2FuZHMiLCJudW1iZXIiLCJmb3JtYXREZWNpbWFsIiwibmVlZFRob3VzYW5kcyIsImlzTmFOIiwiZGVjaW1hbCIsImludGVnZXJQYXJ0IiwiZGVjaW1hbFBhcnQiLCJzaG93RGF0ZVBpY2tlciIsImdldFN5bWJvbERpc3BsYXlOYW1lIiwiZ2V0U3BvdFN5bWJvbE1vZGVsIiwic3ltYm9sTW9kZWwiLCJzeW1ib2xOYW1lIiwidXBsb2FkTG9nIiwidGFnIiwiaW5mbyIsIm1hcCIsIm9uZUNhbGxiYWNrIiwibGVmdENhbGxiYWNrIiwicmlnaHRDYWxsYmFjayIsImRlZmF1bHREYXRhIiwidGl0bGVWaXNpYmlsaXR5Iiwib25lQnV0dG9uVmlzaWJpbGl0eSIsInR3b0J1dHRvblZpc2liaWxpdHkiLCJjZW50ZXJCdXR0b25UZXh0IiwiJGkxOG4iLCJuX2NvcHlfdHJhZGluZ19tZV9rbm93IiwibGVmdEJ1dHRvblRleHQiLCJuX2NhbmNlbCIsInJpZ2h0QnV0dG9uVGV4dCIsIm5fc3VyZSIsInBvcFRpdGxlIiwibl9jb3B5X3RyYWRpbmdfdGlwIiwicG9wQ29udGVudCIsInRvYXN0VHlwZSIsInBvcFNob3ciLCJjb21tb24ubW9kdWxlRGVmaW5lIiwicG9wVXBDb250ZW50T2ZPbmVCdXR0b24iLCJ0aXRsZSIsImNvbmV0ZW50IiwiY2VudGVyVGV4dCIsIm9uZUJ0bkNhbGxCYWNrIiwicG9wVXBDb250ZW50T2ZUd29CdXR0b24iLCJjb250ZW50IiwibGVmdFRleHQiLCJyaWdodFRleHQiLCJsZWZ0QnRuQ2FsbGJhY2siLCJyaWdodEJ0bkNhbGxiYWNrIiwicG9wRGlzbWlzcyIsImJ0bkNsaWNrIiwiY2FsbEJhY2siLCJjdXJyZW50TWFyZ2luVHlwZSIsInRlbXBMaXN0IiwiRWRpdF9Cb2FyZF9TZWxlY3RDb2xvciIsIkVkaXRfQm9hcmRfTm9ybWFsQ29sb3IiLCJoaXN0b3J5U2VhcmNoTGlzdCIsInBvcERhdGEiLCJzaG93Q3VycmVuY3lQb3AiLCJjdXJyZW5jeUxpc3RWaXNpYmxlIiwiY3VycmVuY3lFbXB0eVZpc2libGUiLCJib3JkZXJDb2xvciIsInNlYXJjaFdvcmQiLCJ0aXRsZVRleHQiLCJuX21hcmdpbl9jdXJyZW5jeV9saXN0Iiwic2VhcmNoQ29pbnNIaXN0b3J5Iiwic2hvd0hpc3RvcnkiLCJzaG93UG9wIiwicGFnZVR5cGUiLCJtYXJnaW5UeXBlIiwibGlzdGVuZXIiLCJuX21hcmdpbl9zZWxlY3RfY3VycmVuY3kiLCJzZWFyY2hIaW50Iiwibl9lYXJuX3NlYXJjaF9jb2luIiwibl9tYXJnaW5fc2VsZWN0X2N1cnJlbmN5X3BhaXIiLCJuX21hcmdpbl9zZWFyY2hfY3VycmVuY3kiLCJ0ZW1wSGlzdG9yeUxpc3QiLCJjb21tb24ucmVhZCIsImNvbW1vbi5jb21tb25EYXRhIiwidGVtcERhdGEiLCJkZWJ0IiwiTnVtYmVyIiwiYmFsYW5jZSIsInRpdGxlRGVzYyIsIm5fbWFyZ2luX2Fzc2V0cyIsIm5fbWFyZ2luX2xpYWJpbGl0aWVzX2Ftb3VudCIsImluZGV4IiwiaWNvbiIsImNvbW1vbi5nZXRQTkdJY29uVVJMQnlDdXJyZW5jeSIsImN1cnJlbmN5VGV4dCIsInRvVXBwZXJDYXNlIiwiY29tbW9uLnRob3VzYW5kc0Zvcm1hdHRlciIsImRlYnRBbW91bnQiLCJjb21tb24uYWRkQ3VycmVudEN1cnJlbmN5U3ltYm9sIiwiY29tbW9uLmdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudCIsIm5fbWFyZ2luX3N5bWJvbF9saXN0IiwiYmFzZURlYnQiLCJxdW90YURlYnQiLCJkaXNwbGF5U3ltYm9sIiwicXVvdGFDdXJyZW5jeSIsImJhc2VEZWJ0QW1vdW50IiwicXVvdGFEZWJ0QW1vdW50IiwiaW5pdEhpc3RvcnlTaG93IiwidHJpbSIsImNsaWNrSGlzdG9yeSIsInRleHQiLCJmaWx0ZXJMaXN0IiwiY2xlYXJIaXN0b3J5IiwiY29tbW9uLmNsZWFyIiwiY3VycmVuY3lQb3BEaXNtaXNzIiwiZmlsdGVyQ3VycmVuY3kiLCJzZWFyY2hLZXkiLCJzb21lIiwiaXRlbSIsImNvbW1vbi5zYXZlIiwiaXNGb2N1cyIsIm9uRm9jdXNDaGFuZ2UiLCJjdXJyZW50Qm9hcmRlckNvbG9yIiwiY2xlYXJWaXNpYmxlIiwib25UZXh0Q2hhbmdlIiwiZmlsdGVyIiwiY2xpY2tlZENsZWFyIiwidGl0bGVDb2xvcl9Ob3JtYWwiLCJ0aXRsZUNvbG9yX1NlbGVjdGVkIiwibWFyZ2luU2VsZWN0QnRuQmciLCJtYXJnaW5VbnNlbGVjdEJ0bkJnIiwiQ1JPU1NfTUFSR0lOX0xBRERFUl9MRU5ESU5HIiwiTUFSR0lOX0xBRERFUl9MRU5ESU5HIiwibWFyZ2luQ3Jvc3MiLCJtYXJnaW5Jc29sYXRlZCIsInN1cGVyTWFyZ2luQ3VycmVuY3kiLCJtYXJnaW5TeW1ib2wiLCJ0ZW1wUGFnZURhdGEiLCJmaXJzdEluaXQiLCJmaXJzdFNob3dQb3AiLCJzdGF0dXNCYXJDb25maWciLCJzdGF0dXNCYXJNb2RlIiwiYWRTdGF0dXNCYXJDb2xvciIsInRpdGxlRGF0YSIsIm5fbWFyZ2luX2xvYW4iLCJ0aXRsZUNvbG9yIiwibl9tYXJnaW5fcmVwYXkiLCJjdXJyZW50VGFnIiwiY3VycmVudEluZGV4IiwiaXNMb2FuQnRuUmlnaHQiLCJsb2FuTWFyZ2luVHlwZSIsImxvYW5Jc29sYXRlZFR5cGUiLCJsb2FuQ3Jvc3NDaGVja0J0bkJnIiwibG9hbkNyb3NzQ2hlY2tCdG5UZXh0Q29sb3IiLCJsb2FuSXNvbGF0ZWRDaGVja0J0bkJnIiwibG9hbklzb2xhdGVkQ2hlY2tCdG5UZXh0Q29sb3IiLCJsb2FuQmFzZUJ0bkJnQ29sb3IiLCJsb2FuQmFzZUJvcmRlckNvbG9yIiwibG9hblF1b3RhQnRuQmdDb2xvciIsImxvYW5RdW90YUJvcmRlckNvbG9yIiwibG9hbkNvbmZpcm1CdG5CZyIsImxvYW5Db25maXJtQnRuVGV4dENvbG9yIiwibG9hbkVkaXRCb3JkZXJDb2xvciIsImxvYW5FZGl0VGV4dCIsImxvYW5FcnJvclZpc2libGUiLCJpc0xvYW5FZGl0Rm9jdXMiLCJpc1JlcGF5QnRuUmlnaHQiLCJyZXBheU1hcmdpblR5cGUiLCJyZXBheUlzb2xhdGVkVHlwZSIsInJlcGF5Q3Jvc3NDaGVja0J0bkJnIiwicmVwYXlDcm9zc0NoZWNrQnRuVGV4dENvbG9yIiwicmVwYXlJc29sYXRlZENoZWNrQnRuQmciLCJyZXBheUlzb2xhdGVkQ2hlY2tCdG5UZXh0Q29sb3IiLCJyZXBheUJhc2VCdG5CZ0NvbG9yIiwicmVwYXlCYXNlQm9yZGVyQ29sb3IiLCJyZXBheVF1b3RhQnRuQmdDb2xvciIsInJlcGF5UXVvdGFCb3JkZXJDb2xvciIsInJlcGF5Q29uZmlybUJ0bkJnIiwicmVwYXlDb25maXJtQnRuVGV4dENvbG9yIiwicmVwYXlFZGl0Qm9yZGVyQ29sb3IiLCJyZXBheUVkaXRUZXh0IiwicmVwYXlFcnJvclZpc2libGUiLCJpc1JlcGF5RWRpdEZvY3VzIiwicGFnZURhdGEiLCJvbkNyZWF0ZSIsImV2ZW50UGFyYW1zIiwiaW5pdEFsbERhdGEiLCJjb21tb24uZ2V0QWNjb3VudElkIiwicmVzZXRTZWxlY3RUYWJWaWV3IiwiaW5pdERhdGEiLCJvblJlc3VtZSIsIm9uU3RhcnQiLCJvblBhdXNlIiwib25TdG9wIiwib25EZXN0cm95IiwidGlwc1RleHQiLCJuX21hcmdpbl9zdXBlcl9tYXJnaW5fbG9hbl90aXBfbmV3IiwiY2xpY2tUZXh0Iiwibl9tYXJnaW5fc3VwZXJfbWFyZ2luX2xvYW5fcnVsZXMiLCJuZXdUaXBzVGV4dCIsImNvbG9yIiwicmVzZXRMb2FuTWFyZ2luVGl0bGUiLCJyZXNldFJlcGF5TWFyZ2luVGl0bGUiLCJyZXF1ZXN0RGF0YSIsImNvbW1vblBvcC5wb3BVcENvbnRlbnRPZk9uZUJ1dHRvbiIsIiRpbnRlcmNlcHQiLCJuX21hcmdpbl91bmFibGVfdG9fbG9hbiIsImNvbW1vblBvcC5wb3BVcENvbnRlbnRPZlR3b0J1dHRvbiIsIm5fbWFyZ2luX3N1cGVyX2xpbWl0X3RpcHMiLCJuX3RyYWRlX2FsZXJ0X2dvX3RyYW5zZmVyIiwidHJhbnNmZXIiLCJjaGFuZ2VJc29sYXRlZExvYW4iLCJjb21tb24uc2hvd0xvYWRpbmciLCJjaGFuZ2VMaXN0VHlwZSIsImdldFN1cGVyTWFyZ2luQ3VycmVuY3kiLCJnZXRNYXJnaW5TeW1ib2wiLCJyZXF1ZXN0RGV0YWlsIiwiZGV0YWlsIiwiY29tbW9uLnNlbmRSZXF1ZXN0IiwiY29tbW9uLnVwbG9hZExvZyIsInVwZGF0ZUxvYW5DaGFuZ2VEYXRhIiwidXBkYXRlUmVwYXlDaGFuZ2VEYXRhIiwiY3VycmVuY3lEYXRhIiwiZXF1YWxzSWdub3JlQ2FzZSIsInN5bWJvbERhdGEiLCJ0ZXh0T25lIiwidGV4dFR3byIsInJlZnJlc2hDdXJyZW5jeURhdGEiLCJyZXNldFRpdGxlU2VsZWN0VGFiIiwic2VsZWN0ZWRJdGVtIiwicG9pbnRWaXNpYmlsaXR5IiwiZml4ZWROdW0iLCJmb3JtYXR0ZWQiLCJiYWNrIiwiY29udGFpbmVyQmFjayIsImhpc3RvcnkiLCJtb2RlVHlwZSIsImNvbW1vbi5vcGVuVVJMIiwidGFiQ2xpY2siLCJjbG9zZUtleWJvYXJkIiwib25Mb2FuVGV4dENoYW5nZSIsIm9uUmVwYXlUZXh0Q2hhbmdlIiwibG9hbkNoYW5nZVR5cGUiLCJjdXJyZW5jeUNoYW5nZSIsImNoYW5nZVN1cGVyTWFyZ2luTG9hbiIsImFscmVhZHlMb2FuIiwibnVtYmVyLnNjaWVudGlmaWNUb051bWJlciIsImxvYW4iLCJtYXhMb2FuQW1vdW50IiwiaWNvblZpc2libGUiLCJpbnRlcmVzdFJhdGUiLCJtYXhMb2FuTGltaXQiLCJlZGl0SGludCIsIm5fbWFyZ2luX21pbmltdW0iLCJjaGFuZ2VTdXBlck1hcmdpblJlcGF5IiwiY2hhbmdlSXNvbGF0ZWRSZXBheSIsImNoYW5nZUxvYW5Jc29sYXRlZFR5cGUiLCJiYXNlQ3VycmVuY3kiLCJpc29sYXRlZERhdGEiLCJzaG93VHdvQ3VycmVuY3kiLCJiYXNlSWNvbiIsInF1b3RhSWNvbiIsInNob3dJc29sYXRlZFRpdGxlIiwibl9tYXJnaW5fbGltaXRfdGlwcyIsInJlZnJlc2hMb2FuQnRuU3RhdHVzIiwiaXNSaWdodCIsImVycm9yVGlwcyIsImxvYW5FcnJvclRpcHMiLCJuX21hcmdpbl9tYXhpbXVtX2Ftb3VudF90aXBzIiwibl9tYXJnaW5fbm90X3JlYWNoZWRfYm9ycm93ZWQiLCJuX21hcmdpbl9hbW91bnRfb3Zlcl9sb2FuYWJsZV90aXBzIiwiZmlsdGVyTnVtYmVyU3RyIiwiZW5kc1dpdGgiLCJvbkxvYW5FZGl0Rm9jdXNDaGFuZ2UiLCJyZXBsYWNlWmVybyIsInRlbXBUZXh0IiwiY29tbW9uLmZvcm1hdERlY2ltYWwiLCJsb2FuQ29uZmlybSIsImxvYW5Db2RlIiwiYWNjb3VudElkIiwiY29tbW9uLnNlbmRSZXF1ZXN0UmV0dXJuQ29kZSIsIm5fbWFyZ2luX2NvbXBsZXRlZF9sb2FuIiwibl9nb190cmFkZSIsImxvYW5BbGxCYWxhbmNlIiwicmVwYXlDaGFuZ2VUeXBlIiwiY2hhbmdlUmVwYXlJc29sYXRlZFR5cGUiLCJpbnRlcmVzdCIsInRyYWRlIiwicmVmcmVzaFJlcGF5QnRuU3RhdHVzIiwicmVwYXlFcnJvclRpcFRleHQiLCJuX21hcmdpbl9pbnN1ZmZpY2llbnRfYXZhaWxhYmxlIiwibl9tYXJnaW5fb3V0X29mX2RlYnQiLCJuX21hcmdpbl9hbW91bnRfb3Zlcl90b3RhbF9saWFiaWxpdGllcyIsIm9uUmVwYXlFZGl0Rm9jdXNDaGFuZ2UiLCJyZXBheUNvbmZpcm0iLCJyZXBheUNvZGUiLCJjb21tb24uc2hvd1RvYXN0Iiwibl9tYXJnaW5fcmVwYXltZW50X3N1Y2Nlc3MiLCJyZXBheUFsbEJhbGFuY2UiLCJnZXRNaW5OdW0iLCJudW0xIiwibnVtMiIsImNvbW1vbi5nZXRDdXJyZW5jeUxpc3QiLCJjb21tb24uZ2V0U3ltYm9sTGlzdCIsImNvaW4iLCJkaXNwbGF5TWFyZ2luU3ltYm9sIiwic2VsZWN0Q3VycmVuY3lQb3Auc2hvd1BvcCIsInNob3dPbmVCdG5EaWFsb2ciLCJidG5UZXh0IiwiaW50ZXJlc3RSdWxlc1RpcHMiLCJuX21hcmdpbl9jdXJyZW5jeV9pbnRlcmVzdF9yYXRlX2V4cGxhaW4iLCJuX21hcmdpbl9pbnRlcmVzdF9ib3Jyb3dlZF90aXBzIiwibWF4aW11bUxvYW5FeHBsYWluZWRUaXBzIiwibl9tYXJnaW5fbWF4aW11bV9sb2FuX2Ftb3VudF9leHBsYWluIiwibl9tYXJnaW5fbWF4aW11bV9sb2FuX2Ftb3VudF90aXBzIiwidG90YWxEZWJ0RXhwbGFpbmVkVGlwcyIsIm5fbWFyZ2luX3RvdGFsX2xpYWJpbGl0aWVzX2V4cGxhaW4iLCJuX21hcmdpbl90b3RhbF9saWFiaWxpdGllc19jb250ZW50IiwidG9Mb2FuTGltaXQiLCJqdW1wVGlwcyIsIkVkaXRfQm9hcmRfTm9tYWxDb2xvciIsImJ1dHRvblRpdGxlQ29sb3JfTm9ybWFsIiwiYnV0dG9uVGl0bGVDb2xvcl9TZWxlY3RlZCIsImJ1dHRvbkJhY2tDb2xvcl9Ob3JtYWwiLCJidXR0b25CYWNrQ29sb3JfU2VsZWN0ZWQiLCJzdXBwb3J0Q3VycmVuY2llcyIsInN1cHBvcnRTeW1ib2xzIiwiTW9kZVR5cGUiLCJzdXBlck1hcmdpbiIsImlzb2xhdGVNYXJnaW4iLCJUYWJUeXBlTG9hbiIsIlRhYlR5cGVSZXBheSIsIlRhYlR5cGVJbnRlcmVzdCIsImxpbWl0IiwiY29tbW9uTGlzdCIsImdldFRhYkxpc3REZWZhdWx0RGF0YSIsImNvbW1vbkZpbHRlclR5cGVzIiwiY3VycmVudFRhYlR5cGUiLCJjdXJGaWx0ZXJUeXBlSW5kZXgiLCJ0eXBlSGVpZ2h0IiwibG9hZE1vcmVTdGF0dXMiLCJyZWZyZXNoU3RhdHVzIiwibGlzdERhdGEiLCJtb2RlVHlwZUljb24iLCJjdXJyZW5jeUljb24iLCJmaWx0ZXJDdXJyZW5jaWVzIiwiZmlsdGVyVGltZXMiLCJuX29yZGVyX2ZpbHRlcl9uZWFybHlfYV93ZWVrIiwidGltZUJhY2tDb2xvciIsIm5fb3JkZXJfZmlsdGVyX25lYXJseV9hX21vbnRoIiwibl9vcmRlcl9maWx0ZXJfbmVhcmx5XzEyMF9kYXlzIiwiY29uZmlnIiwiYmFja2dyb3VuZENvbG9yIiwidGFiVHlwZSIsImdldFRhYlRpdGxlRGF0YSIsImN1ck1vZGVUeXBlIiwic2V0TW9kZVR5cGVEYXRhIiwiY3VyU3ltYm9sIiwiY29tbW9uLmdldFN5bWJvbERpc3BsYXlOYW1lIiwibl9lYXJuX2FsbF9jb2luIiwibl9tYXJnaW5fYWxsX2N1cnJlbmN5IiwiY3VyRmlsdGVyQ3VycmVuY3lJbmRleCIsImRlZmF1bHRGaWx0ZXJEYXRhIiwiZ2V0RmlsdGVyTW9yZVR5cGVzIiwiZmlsdGVyVHlwZXMiLCJyZXF1ZXN0U3VwZXJNYXJnaW5DdXJyZW5jaWVzIiwicmVxdWVzdE1hcmdpblN5bWJvbHMiLCJmaWx0ZXJDbGljayIsIm1vZGVUeXBlU2hvdyIsImN1cnJlbmN5U2hvdyIsInJlc2V0Q3VycmVuY3lTZWFyY2hVSSIsImZpbHRlck1vcmVTaG93IiwiZmlsdGVyVHlwZSIsImlzTW9yZSIsInJlcXVlc3RMb2FuSGlzdG9yeSIsInJlcXVlc3RSZXBheUhpc3RvcnkiLCJyZXF1ZXN0SW50ZXJlc3RIaXN0b3J5IiwiZ2V0U3RhcnRUaW1lc3RhbXAiLCJnZXRFbmRUaW1lc3RhbXAiLCJsb2FuRGF0YSIsImZyb20iLCJlbXB0eVZpc2libGUiLCJsaXN0VmlzaWJsZSIsImhhbmRsZUxvYW5IaXN0b3J5RGF0YSIsImhpc3RvcnlzIiwibG9hbnMiLCJsYXN0TG9hbiIsInYiLCJjdXJyZW5jeVZpc2libGUiLCJsb2FuVHlwZSIsInR5cGVDb250ZW50IiwiZ2V0VHlwZUNvbnRlbnQiLCJsb2FuQW1vdW50IiwidGltZSIsInJlcGF5RGF0YSIsImhhbmRsZVJlcGF5SGlzdG9yeURhdGEiLCJyZXBheXMiLCJsYXN0UmVwYXkiLCJyZXBheVR5cGUiLCJuX3VzZXJfY2VudGVyX3BvaW50c190aXRsZSIsInJlcGF5QW1vdW50VmlzaWJsZSIsInRvdGFsQW1vdW50VmlzaWJsZSIsImludGVyZXN0QW1vdW50IiwicmVwYXlBbW91bnQiLCJ0b3RhbEFtb3VudCIsImludGVyZXN0RGF0YSIsImhhbmRsZUludGVyZXN0SGlzdG9yeURhdGEiLCJpbnRlcmVzdHMiLCJpbnRlcmVzdFR5cGUiLCJyYXRlIiwibnVtYmVyLm11bHRpcGx5IiwicGFyc2VGbG9hdCIsImNvbW1vbi5mb3JtYXRQcmVjaXNpb24iLCJmaXJzdFRpbWUiLCJzdGFydFRpbWUiLCJzZXRIb3VycyIsInN0YXJ0VGltZXN0YW1wIiwiZ2V0VGltZSIsImxhc3RUaW1lIiwiZW5kVGltZSIsImVuZFRpbWVzdGFtcCIsInRzIiwicmVzcExpc3QiLCJjdXJyZW5jeVNlbGVjdGVkIiwibW9kZVR5cGVQb3BEaXNtaXNzIiwibW9kZVR5cGVQb3BTZWxlY3RlZCIsInJlc2V0Q3VycmVuY3lJbmRleCIsInN1cGVyTWFyZ2luU2VsZWN0ZWQiLCJpc29sYXRlTWFyZ2luU2VsZWN0ZWQiLCJzdXBlck1hcmdpbkNvbG9yIiwiaXNvbGF0ZU1hcmdpbkNvbG9yIiwibW9kZVR5cGVUZXh0Iiwibl9jb250cmFjdF9zdXBlcl9tYXJnaW4iLCJuX2NvbnRyYWN0X3RyYWRlX21hcmdpbiIsInN1cHBvcnRMaXN0IiwiZmlsdGVyTW9yZVBvcERpc21pc3MiLCJmaWx0ZXJUaW1lIiwiZmlsdGVyVGltZVVJIiwiY3VyRmlsdGVyVGltZUluZGV4IiwiZ2V0U3RhcnREYXkiLCJnZXREYXkiLCJmaWx0ZXJTdGFydFRpbWUiLCJuX29yZGVyX2ZpbHRlcl9zdGFydF90aW1lIiwiaXNTZWxlY3RlZFN0YXJ0RGF0ZSIsInN0YXJ0RGF0ZSIsImVuZERhdGUiLCJzZWxlY3RlZFRpbWUiLCJjb21tb24uc2hvd0RhdGVQaWNrZXIiLCJmaWx0ZXJFbmRUaW1lIiwibl9vcmRlcl9maWx0ZXJfZW5kX3RpbWUiLCJiYWNrQ29sb3IiLCJmaWx0ZXJSZXNldCIsImZpbHRlclN1cmUiLCJkYXkiLCJ0b2RheSIsInRhcmdldGRheV9taWxsaXNlY29uZHMiLCJzZXRUaW1lIiwidFllYXIiLCJ0TW9udGgiLCJ0RGF0ZSIsImRvSGFuZGxlTW9udGgiLCJtb250aCIsIm0iLCJuX29wdGlvbl9tYXJrZXRfbGlzdF9zZXR0aW5nX2FsbF90eXBlIiwibl90cmFkZV9tYXJnaW5fYXV0b19ib3Jyb3ciLCJuX21hcmdpbl9tYW51YWxfbG9hbiIsIm5fdHJhZGVfbWFyZ2luX2F1dG9fcmVwYXkiLCJuX21hcmdpbl9tYW51YWxfcmVwYXkiLCJuX21hcmdpbl9hdXRvX2RlZHVjdGlvbl9yZXBheSIsIm5fbWFyZ2luX3N5c3RlbV9yZXBheSIsIm5fbWFyZ2luX2xvYW5faW50ZXJlc3QiLCJuX21hcmdpbl90aW1pbmdfaW50ZXJlc3QiLCJsb2FuVGl0bGVDb2xvciIsInJlcGF5VGl0bGVDb2xvciIsImludGVyZXN0VGl0bGVDb2xvciIsIm5fbWFyZ2luX2xvYW5faGlzdG9yeSIsIm5fbWFyZ2luX3JlcGF5X2hpc3RvcnkiLCJuX21hcmdpbl9pbnRlcmVzdF9oaXN0b3J5IiwiZ2V0VHlwZVBvcENvbnRlbnQiLCJuX21hcmdpbl9hdXRvX2xvYW5fdGlwcyIsIm5fbWFyZ2luX21hbnVhbF9sb2FuX3RpcHMiLCJuX21hcmdpbl9hdXRvX3JlcGF5X3RpcHMiLCJuX21hcmdpbl9tYW51YWxfcmVwYXlfdGlwcyIsIm5fbWFyZ2luX2F1dG9fZGVkdWN0aW9uX3JlcGF5X3RpcHMiLCJuX21hcmdpbl9zeXN0ZW1fcmVwYXlfdGlwcyIsIm5fbWFyZ2luX3RpbWluZ19pbnRlcmVzdF90aXBzIiwibl9tYXJnaW5fbG9hbl9pbnRlcmVzdF90aXBzIiwibl9tYXJnaW5fYXV0b19yZXBheSIsIm9uUmVmcmVzaCIsIm9uTG9hZE1vcmUiLCJjdXJEYXRhIiwidHlwZUNsaWNrIiwibl9taW5pbmdfdHlwZSIsImNvbW1vbi5zZW5kQ29tbW9uQ29uZmlnIiwibW9kdWxlQXBwZWFyIiwibW9kdWxlV2lsbERpc2FwcGVhciIsIm1vZHVsZURpc2FwcGVhciJdLCJtYXBwaW5ncyI6IkFBaUJBLElBQUlBLEtBQUssSUFVUEMsS0FBSyxHQUdMQyxTQUFTLEtBR1RDLFlBQVksS0FPWkMsTUFBTSxHQVFOQyxLQUFLLElBT0xDLE9BQU8sYUFDUEMsVUFBVUQsT0FBTyxZQUNqQkUsYUFBYUQsVUFBVSxrQkFDdkJFLGFBQWFGLFVBQVUsaUJBQ3ZCRyxjQUFjSixPQUFP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
