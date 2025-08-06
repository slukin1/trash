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
    Big.NE = -9;
    const bigValue = new Big(value);
    let stringValue = bigValue.toString();
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

var clickable = true;

var accountId = -1;

function moduleDefine(moduleName, defaultDataFunction, functions = {
    onCreate: onCreate$7,
    onDestroy: onDestroy$3,
    onResume: onResume$2,
    onPause: onPause$1,
    onStart: onStart,
    onStop: onStop
}) {
    console.log(`loadModule`, moduleName);
    $data[moduleName] = defaultDataFunction();
    $event[moduleName] = {
        onCreate: typeof functions.onCreate == "undefined" ? onCreate$7 : functions.onCreate,
        onDestroy: typeof functions.onDestroy == "undefined" ? onDestroy$3 : functions.onDestroy,
        onResume: typeof functions.onResume == "undefined" ? onResume$2 : functions.onResume,
        onPause: typeof functions.onPause == "undefined" ? onPause$1 : functions.onPause,
        onStart: typeof functions.onStart == "undefined" ? onStart : functions.onStart,
        onStop: typeof functions.onStop == "undefined" ? onStop : functions.onStop
    };
    return {
        moduleData: $data[moduleName],
        moduleEvent: $event[moduleName]
    };
}

function onCreate$7() {
    console.log("common onCreate");
}

function onDestroy$3() {}

function onResume$2() {}

function onPause$1() {}

function onStart() {}

function onStop() {}

var commonData = {
    priceColorType: 0,
    colorMode: 0,
    OS: 0,
    appVersion: "",
    isInReview: 1,
    h5Url: "",
    language: "",
    statusHeight: 0,
    vToken: "",
    oldVToken: "",
    bottomSafeAreaHeight: 0
};

$data.commonData = commonData;

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

function getCommonConfig(param) {
    console.log(param);
    commonData.priceColorType = parseInt(param.priceColorType);
    commonData.colorMode = parseInt(param.colorMode);
    commonData.OS = parseInt(param.OS);
    commonData.appVersion = param.appVersion;
    commonData.isInReview = parseInt(param.isInReview);
    commonData.language = param.language;
    commonData.h5Url = param.h5Url;
    commonData.statusHeight = param.statusHeight;
    commonData.vToken = param.vToken;
    commonData.oldVToken = param.oldVToken;
    commonData.bottomSafeAreaHeight = param.bottomSafeAreaHeight;
    $data.commonData = commonData;
}

function getPNGIconURLByCurrency(currency) {
    let baseUrl = commonData.h5Url ? commonData.h5Url : "";
    return `${baseUrl}/-/x/hb/p/api/contents/currency/icon_png/${currency.toLowerCase()}.png`;
}

async function requestAccountId() {
    const data = await sendRequest("v1/account/accounts", {}, 0, 4);
    console.log(`requestAccountId : ${JSON.stringify(data)}`);
    for (var i = 0; i < data.length; i++) {
        if (data[i].type == "otc-options") {
            accountId = data[i].id;
            break;
        }
    }
}

async function sendRequest2(path, params = {}, method = 0, hostType = 0, header = {}) {
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
        return response;
    } catch (e) {
        console.log(`request error, error=${e}`);
        return null;
    }
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
        } else if ((code == null || code == "" || code == "undefined") && response.status == "ok") {
            if (data == null) {
                return response;
            }
            console.log(`request ${path} done`);
            return data;
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

async function showToast(msg) {
    await $nativeAPI.hbToast(msg);
}

function showLoading(isShow = true) {
    $nativeAPI.showLoading(isShow ? 1 : 0);
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

function formatPrecision(value, precision) {
    try {
        const result = format(value, precision);
        return result;
    } catch (e) {
        console.log(e);
        return value.toFixed(precision);
    }
}

function containerBack(param = 0) {
    console.log("containerBack");
    $nativeAPI.containerBack(param);
}

function defaultData$6() {
    return {
        popData: [],
        currentIndex: 0,
        setupText: ""
    };
}

const {moduleData: moduleData$6, moduleEvent: moduleEvent$6} = moduleDefine("guidepop", defaultData$6, {
    onCreate: onCreate$6
});

moduleEvent$6.last = last;

moduleEvent$6.next = next;

var titleList = [ $i18n.n_double_coin_open_account, $i18n.n_double_coin_guide_setup_2, $i18n.n_double_coin_guide_setup_4, $i18n.n_double_coin_guide_setup_4 ];

var contentList = [ $i18n.n_double_coin_guide_setup_1, $i18n.n_double_coin_guide_setup_3, $i18n.n_double_coin_guide_setup_6, $i18n.n_double_coin_guide_setup_8 ];

function onCreate$6() {
    console.log(`guidepop onCreate`);
    requestGuidePopData();
}

async function requestGuidePopData() {
    const data = await sendRequest("otc/opt/option/order/v1/guide-pop-up/resources", {
        productTypeId: 5
    }, 0, 0);
    if (data != null) {
        let pictureList = data["picture-links"];
        let popData = [];
        for (let i = 0; i < pictureList.length; i++) {
            let obj = {
                title: titleList[i],
                content: contentList[i],
                image: pictureList[i]
            };
            if (i == 2 || i == 3) {
                obj.type = "cell1";
                obj.subTitle = i == 2 ? $i18n.n_double_coin_guide_setup_5 : $i18n.n_double_coin_guide_setup_7;
            } else {
                obj.type = "cell";
            }
            popData.push(obj);
        }
        console.log(`updateSetupText1 : ${JSON.stringify(popData)}`);
        moduleData$6.popData = popData;
        updateSetupText();
    }
}

function last() {
    console.log(`last ${moduleData$6.currentIndex}`);
    if (moduleData$6.currentIndex == 0) {
        return;
    }
    moduleData$6.currentIndex = moduleData$6.currentIndex - 1;
    updateSetupText();
}

function next() {
    console.log(`last ${moduleData$6.currentIndex} --- ${moduleData$6.popData.length}`);
    if (moduleData$6.currentIndex == moduleData$6.popData.length - 1) {
        return;
    }
    moduleData$6.currentIndex = moduleData$6.currentIndex + 1;
    updateSetupText();
}

function updateSetupText() {
    console.log(`updateSetupText : ${moduleData$6.popData.length}`);
    if (moduleData$6.popData.length == 0) {
        return;
    }
    moduleData$6.setupText = `(${moduleData$6.currentIndex + 1}/${moduleData$6.popData.length})`;
}

function defaultData$5() {
    return {
        refresh: "0",
        mainData: [ {
            type: "5"
        }, {
            type: "2"
        }, {
            type: "3"
        }, {
            type: "4",
            answerVisable1: "gone",
            answerVisable2: "gone",
            answerVisable3: "gone",
            answerVisable4: "gone",
            answerVisable5: "gone",
            qaIcon1: "@drawable/edge_engine_shark_home_qa_spread_icon",
            qaIcon2: "@drawable/edge_engine_shark_home_qa_spread_icon",
            qaIcon3: "@drawable/edge_engine_shark_home_qa_spread_icon",
            qaIcon4: "@drawable/edge_engine_shark_home_qa_spread_icon",
            qaIcon5: "@drawable/edge_engine_shark_home_qa_spread_icon"
        } ]
    };
}

function getNavConfigString$4() {
    return {
        titleKey: "n_double_coin_earn",
        left: {
            action: {
                type: "back",
                parameter: ""
            },
            icon: "edge_engine_top_bar_back_normal"
        },
        right: {
            action: {
                type: "evalJS",
                parameter: "rightBtnClicked"
            },
            icon: "edge_engine_dbcoin_right_btn"
        },
        backgroundColor: "eHomeTopBackgroundColor"
    };
}

const {moduleData: moduleData$5, moduleEvent: moduleEvent$5} = moduleDefine("home", defaultData$5, {
    onCreate: onCreate$5
});

function onCreate$5() {
    console.log("home onCreate");
    moduleData$5.statusBarConfig = {
        statusBarMode: "true",
        adStatusBarColor: "eHomeTopBackgroundColor"
    };
    moduleData$5.navConfig = getNavConfigString$4();
    requestCoinDatas();
}

function getSupplementData() {
    return [ {
        type: "2"
    }, {
        type: "3"
    }, {
        type: "4",
        answerVisable1: "gone",
        answerVisable2: "gone",
        answerVisable3: "gone",
        answerVisable4: "gone",
        answerVisable5: "gone",
        qaIcon1: "@drawable/edge_engine_shark_home_qa_spread_icon",
        qaIcon2: "@drawable/edge_engine_shark_home_qa_spread_icon",
        qaIcon3: "@drawable/edge_engine_shark_home_qa_spread_icon",
        qaIcon4: "@drawable/edge_engine_shark_home_qa_spread_icon",
        qaIcon5: "@drawable/edge_engine_shark_home_qa_spread_icon"
    } ];
}

function clickQA(index) {
    var data = moduleData$5.mainData[moduleData$5.mainData.length - 1];
    if (data.type != "4") return;
    var curKey = "answerVisable" + index;
    var curValue = data[curKey];
    data.answerVisable1 = "gone";
    data.answerVisable2 = "gone";
    data.answerVisable3 = "gone";
    data.answerVisable4 = "gone";
    data.answerVisable5 = "gone";
    data.qaIcon1 = "@drawable/edge_engine_shark_home_qa_spread_icon";
    data.qaIcon2 = "@drawable/edge_engine_shark_home_qa_spread_icon";
    data.qaIcon3 = "@drawable/edge_engine_shark_home_qa_spread_icon";
    data.qaIcon4 = "@drawable/edge_engine_shark_home_qa_spread_icon";
    data.qaIcon5 = "@drawable/edge_engine_shark_home_qa_spread_icon";
    if (curValue == "gone") {
        data[curKey] = "visible";
        data["qaIcon" + index] = "@drawable/edge_engine_shark_home_qa_retract_icon";
    }
}

async function requestCoinDatas() {
    showLoading(true);
    const data = await sendRequest("/option/v2/pre/dcw-tab-nav");
    showLoading(false);
    var dataList = [];
    if (data && data.navigations.length) {
        const list = data.navigations;
        for (var i = 0; i < list.length; i++) {
            const curData = list[i];
            var object = {};
            object.type = "1";
            object.index = i;
            object.foldedVisible = "visible", object.unfoldedVisible = "gone", object.coinName = curData.currency.toUpperCase();
            object.mainIcon = getPNGIconURLByCurrency(curData.currency);
            for (var j = 0; j < curData.items.length; j++) {
                const item = curData.items[j];
                if (item["product-type-id"] == "5") {
                    object[`descText${j + 1}`] = $i18n.$intercept.n_double_coin_earn_low_buy(object.coinName);
                    object[`bigIcon${j + 1}`] = getPNGIconURLByCurrency(item["base-currency"]);
                    object[`smallIcon${j + 1}`] = getPNGIconURLByCurrency(item["quote-currency"]);
                    object["support-quotes-buy"] = item["support-quotes"];
                } else if (item["product-type-id"] == "6") {
                    object[`descText${j + 1}`] = $i18n.$intercept.n_double_coin_earn_high_sell(object.coinName);
                    object[`smallIcon${j + 1}`] = getPNGIconURLByCurrency(item["base-currency"]);
                    object[`bigIcon${j + 1}`] = getPNGIconURLByCurrency(item["quote-currency"]);
                    object["support-quotes-sell"] = item["support-quotes"];
                }
                var idxStr = j + 1 + "";
                object["yieldText" + idxStr] = item["arr-range"];
                object["productTypeId" + idxStr] = item["product-type-id"];
                object["currency"] = item["base-currency"];
            }
            dataList.push(object);
        }
    } else {
        dataList.push({
            type: "5"
        });
    }
    dataList = dataList.concat(getSupplementData());
    moduleData$5.mainData = dataList;
}

function clickItem(index) {
    var curData = moduleData$5.mainData[parseInt(index)];
    if (curData.unfoldedVisible == "gone") {
        curData.unfoldedVisible = "visible";
        curData.foldedVisible = "gone";
    } else {
        curData.foldedVisible = "visible";
        curData.unfoldedVisible = "gone";
    }
}

function toCustomProject() {
    openURL("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=doublecoin&rootName=custom&navConfig=native");
}

function rightBtnClicked() {
    openURL("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=doublecoin&rootName=result&navConfig=&money=15BCH");
}

function refresh() {
    requestCoinDatas();
    moduleData$5.refresh = "2";
}

function toIntroduce() {
    openURL("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=doublecoin&rootName=introduce&navConfig=native&index=0");
}

function toDetail(index, type) {
    var curData = moduleData$5.mainData[parseInt(index)];
    const productTypeId = type;
    const currency = curData["currency"];
    var arr = [];
    if (parseInt(type) == "5") {
        arr = curData["support-quotes-buy"];
    } else {
        arr = curData["support-quotes-sell"];
    }
    var supportQuotes = "";
    for (var i = 0; i < arr.length; i++) {
        supportQuotes = supportQuotes + arr[i];
        if (i != arr.length - 1) {
            supportQuotes = supportQuotes + "-";
        }
    }
    const url = "holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=doublecoin&rootName=coindetail&navConfig=native";
    openURL(`${url}&productTypeId=${productTypeId}&currency=${currency}&supportQuotes=${supportQuotes}`);
}

moduleEvent$5.rightBtnClicked = rightBtnClicked;

moduleEvent$5.clickQA = clickQA;

moduleEvent$5.refresh = refresh;

moduleEvent$5.clickItem = clickItem;

moduleEvent$5.toCustomProject = toCustomProject;

moduleEvent$5.toIntroduce = toIntroduce;

moduleEvent$5.toDetail = toDetail;

function defaultData$4() {
    return {
        navigations: [],
        items: [],
        selectedItem: {},
        footerHeight: 56,
        coinChoseAlertShow: "false",
        coinChoseAlertHeight: 0,
        typeChoseAlertShow: "false",
        typeChoseAlertHeight: 0,
        selectedCoin: "",
        bigIcon: "",
        smallIcon: "",
        selectedType: "",
        selectedDate: $i18n.n_double_coin_earn_select_expire_date,
        selectedTime: 0,
        selectedDateColor: "@color/eBaseColorThreeLevelText",
        coinIndexPrice: "--",
        productDate: "",
        priceRange: "",
        clearVisibility: "gone",
        onFocus: false,
        targetPriceText: "",
        editErrorShow: "gone",
        editTextBorderColor: "@color/KBaseColorInputBackground",
        productYield: "",
        productYieldVisible: "gone",
        btnBgColor: "@color/baseColorThreeLevelText",
        currentTime: -1
    };
}

function getNavConfigString$3() {
    return {
        titleKey: "n_double_coin_earn_product_custom",
        left: {
            action: {
                type: "back",
                parameter: ""
            },
            icon: "edge_engine_top_bar_back_normal"
        },
        backgroundColor: "KBaseColorContentBackground"
    };
}

const {moduleData: moduleData$4, moduleEvent: moduleEvent$4} = moduleDefine("custom", defaultData$4, {
    onCreate: onCreate$4,
    onDestroy: onDestroy$2
});

let indexPriceTimer$1;

let parameter$2;

var productYieldError = false;

function onCreate$4(jsonParameters) {
    console.log(`home onCreate : ${jsonParameters}`);
    parameter$2 = JSON.parse(jsonParameters);
    moduleData$4.statusBarConfig = {
        statusBarMode: "true",
        adStatusBarColor: "KBaseColorContentBackground",
        keyBoardMode: "adjustPan"
    };
    moduleData$4.navConfig = getNavConfigString$3();
    requestData();
}

async function requestData() {
    showLoading(true);
    console.log(`requestData : start`);
    const data = await sendRequest("otc/opt/option/v1/pre/dcw-tab-nav/custom");
    console.log(`requestData : done`);
    var dataList = [];
    if (data && data.navigations.length) {
        moduleData$4.currentTime = data["curr-time"];
        const list = data.navigations;
        for (var i = 0; i < list.length; i++) {
            const curData = list[i];
            var object = {};
            object.type = "1";
            object.index = i;
            object.selected = "gone";
            object.dialogTextColor = "@color/kColorPrimaryText";
            object.coinName = curData.currency.toUpperCase();
            object.mainIcon = getPNGIconURLByCurrency(curData.currency);
            object.currency = curData.currency;
            for (var j = 0; j < curData.items.length; j++) {
                var subObject = curData.items[j];
                subObject.type = "1";
                subObject.index = j;
                subObject.selected = "gone";
                subObject.dialogTextColor = "@color/kColorPrimaryText";
                if (subObject["product-type-id"] == "5") {
                    subObject.typeDesc = $i18n.$intercept.n_double_coin_earn_low_buy_something(subObject["quote-currency"].toUpperCase(), subObject["base-currency"].toUpperCase());
                    subObject.bigIcon = getPNGIconURLByCurrency(subObject["quote-currency"]);
                    subObject.smallIcon = getPNGIconURLByCurrency(subObject["base-currency"]);
                } else if (subObject["product-type-id"] == "6") {
                    subObject.typeDesc = $i18n.$intercept.n_double_coin_earn_high_sell_for(subObject["base-currency"].toUpperCase(), subObject["quote-currency"].toUpperCase());
                    subObject.bigIcon = getPNGIconURLByCurrency(subObject["base-currency"]);
                    subObject.smallIcon = getPNGIconURLByCurrency(subObject["quote-currency"]);
                }
            }
            object.items = curData.items;
            dataList.push(object);
        }
    } else {
        errorBack();
    }
    if (dataList.length <= 0) {
        errorBack();
    }
    moduleData$4.footerHeight = commonData.bottomSafeAreaHeight + 56;
    var length = dataList.length > 8 ? 8 : dataList.length;
    moduleData$4.coinChoseAlertHeight = length * 56 + 64 + commonData.bottomSafeAreaHeight;
    moduleData$4.navigations = dataList;
    var curObject;
    if (parameter$2.currency) {
        for (var i = 0; i < moduleData$4.navigations.length; i++) {
            if (moduleData$4.navigations[i].coinName.toUpperCase() == parameter$2.currency.toUpperCase()) {
                curObject = moduleData$4.navigations[i];
                break;
            }
        }
    }
    if (!curObject) {
        curObject = moduleData$4.navigations[0];
    }
    curObject.selected = "visible";
    curObject.dialogTextColor = "@color/kColorMajorTheme100";
    moduleData$4.curData = curObject;
    moduleData$4.selectedCoin = curObject.coinName;
    moduleData$4.selectedIcon = curObject.mainIcon;
    if (curObject.items.length <= 0) {
        errorBack();
    }
    moduleData$4.typeChoseAlertHeight = curObject.items.length * 56 + 64 + commonData.bottomSafeAreaHeight;
    moduleData$4.items = curObject.items;
    var subObject = moduleData$4.items[0];
    for (var i = 0; i < moduleData$4.items.length; i++) {
        var item = moduleData$4.items[i];
        console.log(`选中类型   ${item["product-type-id"]} -----   ${parameter$2.productTypeId}`);
        console.log(`选中类型   ${item["quote-currency"]} -----   ${parameter$2.quoteCoin}`);
        if (item["product-type-id"] == parameter$2.productTypeId && item["quote-currency"] == parameter$2.quoteCoin) {
            subObject = item;
            break;
        }
    }
    const subItem = subObject;
    if (subItem["product-type-id"] == "5") {
        moduleData$4.selectedType = $i18n.$intercept.n_double_coin_earn_low_buy_something(subItem["quote-currency"].toUpperCase(), subItem["base-currency"].toUpperCase());
        moduleData$4.bigIcon = getPNGIconURLByCurrency(subItem["quote-currency"]);
        moduleData$4.smallIcon = getPNGIconURLByCurrency(subItem["base-currency"]);
    } else if (subItem["product-type-id"] == "6") {
        moduleData$4.selectedType = $i18n.$intercept.n_double_coin_earn_high_sell_for(subItem["base-currency"].toUpperCase(), subItem["quote-currency"].toUpperCase());
        moduleData$4.bigIcon = getPNGIconURLByCurrency(subItem["base-currency"]);
        moduleData$4.smallIcon = getPNGIconURLByCurrency(subItem["quote-currency"]);
    }
    subObject.selected = "visible";
    subObject.dialogTextColor = "@color/kColorMajorTheme100";
    setSelectedItem(subObject);
    showLoading(false);
    console.log(`requestData : 弹窗done`);
}

function intervalRequestIndexPrice$1() {
    if (indexPriceTimer$1 == null) {
        requestIndexPrice$1();
        indexPriceTimer$1 = setInterval(requestIndexPrice$1, 5e3);
    }
}

async function requestIndexPrice$1() {
    const data = await sendRequest("otc/opt/option/v1/pre/index", {
        symbol: `${moduleData$4.selectedItem["base-currency"]}${moduleData$4.selectedItem["quote-currency"]}`
    });
    if (data) {
        console.log(`indexPrice : ${data}`);
        updateIndexPrice(data);
    }
}

function updateIndexPrice(price) {
    moduleData$4.coinIndexPrice = $i18n.$intercept.n_double_coin_earn_quantity_price(moduleData$4.selectedItem["currency"].toUpperCase(), price);
    if (price != "--" && price != "") {
        if (moduleData$4.selectedItem["product-type-id"] == "5") {
            const lowRate = 1 - parseFloat(moduleData$4.selectedItem["bottom-low-limit-price-rate"]);
            const upperRate = 1 - parseFloat(moduleData$4.selectedItem["bottom-upper-limit-price-rate"]);
            var persion = 0;
            if (moduleData$4.selectedItem["base-currency"] != "btc" && moduleData$4.selectedItem["base-currency"] != "eth") {
                persion = 2;
            }
            console.log(`updateIndexPrice ---\x3e ${moduleData$4.selectedItem["base-currency"]}   persion : ${persion}`);
            moduleData$4.lowPrice = formatPrecision(multiply(price, lowRate), persion);
            moduleData$4.highPrice = formatPrecision(multiply(price, upperRate), persion);
            moduleData$4.priceRange = $i18n.$intercept.n_double_coin_earn_price_range(`${moduleData$4.lowPrice} - ${moduleData$4.highPrice}`);
        } else if (moduleData$4.selectedItem["product-type-id"] == "6") {
            const lowRate = 1 + parseFloat(moduleData$4.selectedItem["target-low-limit-price-rate"]);
            const upperRate = 1 + parseFloat(moduleData$4.selectedItem["target-upper-limit-price-rate"]);
            var persion = 0;
            if (moduleData$4.selectedItem["base-currency"] != "btc" && moduleData$4.selectedItem["base-currency"] != "eth") {
                persion = 2;
            }
            console.log(`updateIndexPrice ---\x3e ${moduleData$4.selectedItem["base-currency"]}   persion : ${persion}`);
            moduleData$4.lowPrice = formatPrecision(multiply(price, lowRate), persion);
            moduleData$4.highPrice = formatPrecision(multiply(price, upperRate), persion);
            moduleData$4.priceRange = $i18n.$intercept.n_double_coin_earn_price_range(`${moduleData$4.lowPrice} - ${moduleData$4.highPrice}`);
        }
    } else {
        moduleData$4.priceRange = "";
    }
}

async function requestYield() {
    if (moduleData$4.selectedTime <= 0 || moduleData$4.targetPriceText == "" || moduleData$4.selectedItem == null) {
        return;
    }
    var params = {
        productTypeId: moduleData$4.selectedItem["product-type-id"],
        productId: moduleData$4.selectedItem["product-id"],
        productFinanceId: moduleData$4.selectedItem["product-finance-id"]
    };
    params["expireAt"] = moduleData$4.selectedTime;
    params["hookPrice"] = moduleData$4.targetPriceText;
    const data = await sendRequest("otc/opt/option/order/v2/double-currency-win/product", params);
    if (data != null && data["arr"] != null && data["arr"] != undefined) {
        moduleData$4.productYield = `${formatPrecision(data.arr, 2)}%`;
        moduleData$4.productYieldVisible = "visible";
        productYieldError = false;
    } else {
        productYieldError = true;
        moduleData$4.productYield = "";
        moduleData$4.productYieldVisible = "gone";
        moduleData$4.btnBgColor = "@color/baseColorThreeLevelText";
        moduleData$4.editTextBorderColor = "#E94359";
    }
}

function clearData() {
    moduleData$4.lowPrice = "";
    moduleData$4.highPrice = "";
    moduleData$4.priceRange = "";
    moduleData$4.editErrorShow = "gone";
    moduleData$4.editTextBorderColor = "@color/KBaseColorInputBackground";
    moduleData$4.targetPriceText = "";
    moduleData$4.selectedDate = $i18n.n_double_coin_earn_select_expire_date;
    moduleData$4.selectedTime = 0;
    moduleData$4.productYield = "";
    moduleData$4.productYieldVisible = "gone";
    moduleData$4.selectedDateColor = "@color/eBaseColorThreeLevelText";
    moduleData$4.productDateVisible = "gone";
    productYieldError = false;
}

function errorBack() {
    showToast($i18n.n_not_support);
    containerBack();
}

function openAlert(param) {
    moduleData$4[param] = "true";
    moduleData$4.onFocus = "false";
}

function closeAlert(param) {
    moduleData$4[param] = "false";
}

function choseCoin(idx) {
    for (var i = 0; i < moduleData$4.navigations.length; i++) {
        var object = moduleData$4.navigations[i];
        object.selected = "gone";
        object.dialogTextColor = "@color/kColorPrimaryText";
    }
    var targetObject = moduleData$4.navigations[parseInt(idx)];
    targetObject.selected = "visible";
    targetObject.dialogTextColor = "@color/kColorMajorTheme100";
    moduleData$4.selectedCoin = targetObject.coinName;
    moduleData$4.selectedIcon = targetObject.mainIcon;
    const subItem = targetObject.items[0];
    if (subItem["product-type-id"] == "5") {
        moduleData$4.selectedType = $i18n.$intercept.n_double_coin_earn_low_buy_something(subItem["quote-currency"].toUpperCase(), subItem["base-currency"].toUpperCase());
        moduleData$4.bigIcon = getPNGIconURLByCurrency(subItem["quote-currency"]);
        moduleData$4.smallIcon = getPNGIconURLByCurrency(subItem["base-currency"]);
    } else if (subItem["product-type-id"] == "6") {
        moduleData$4.selectedType = $i18n.$intercept.n_double_coin_earn_high_sell_for(subItem["base-currency"].toUpperCase(), subItem["quote-currency"].toUpperCase());
        moduleData$4.bigIcon = getPNGIconURLByCurrency(subItem["base-currency"]);
        moduleData$4.smallIcon = getPNGIconURLByCurrency(subItem["quote-currency"]);
    }
    moduleData$4.typeChoseAlertHeight = targetObject.items.length * 56 + 64 + commonData.bottomSafeAreaHeight;
    moduleData$4.items = targetObject.items;
    for (var i = 0; i < moduleData$4.items.length; i++) {
        var object = moduleData$4.items[i];
        object.selected = "gone";
        object.dialogTextColor = "@color/kColorPrimaryText";
    }
    var subObject = moduleData$4.items[0];
    subObject.selected = "visible";
    subObject.dialogTextColor = "@color/kColorMajorTheme100";
    setSelectedItem(subObject);
    closeAlert("coinChoseAlertShow");
}

function choseCoinType(idx) {
    for (var i = 0; i < moduleData$4.items.length; i++) {
        var object = moduleData$4.items[i];
        object.selected = "gone";
        object.dialogTextColor = "@color/kColorPrimaryText";
    }
    var targetObject = moduleData$4.items[parseInt(idx)];
    targetObject.selected = "visible";
    targetObject.dialogTextColor = "@color/kColorMajorTheme100";
    setSelectedItem(targetObject);
    moduleData$4.selectedType = targetObject.typeDesc;
    if (targetObject["product-type-id"] == "5") {
        moduleData$4.bigIcon = getPNGIconURLByCurrency(targetObject["quote-currency"]);
        moduleData$4.smallIcon = getPNGIconURLByCurrency(targetObject["base-currency"]);
    } else if (targetObject["product-type-id"] == "6") {
        moduleData$4.bigIcon = getPNGIconURLByCurrency(targetObject["base-currency"]);
        moduleData$4.smallIcon = getPNGIconURLByCurrency(targetObject["quote-currency"]);
    }
    closeAlert("typeChoseAlertShow");
}

async function showDatePicker() {
    moduleData$4.onFocus = "false";
    var param = moduleData$4.selectedDate == $i18n.n_double_coin_earn_select_expire_date ? "" : moduleData$4.selectedDate;
    var jsonObj = await $nativeAPI.doubleCoinShowDatePicker(param);
    var timeObj = JSON.parse(jsonObj);
    console.log(`showDatePicker : ${jsonObj}  ${timeObj}`);
    if (timeObj) {
        const timestamp = moduleData$4.selectedItem["invalid-at"];
        const selectedTime = timestampToNoon(parseInt(timeObj.time));
        moduleData$4.selectedTime = selectedTime;
        if (timestamp < selectedTime) {
            const date = new Date(timestamp).Format("yyyy/MM/dd");
            showToast($i18n.$intercept.n_double_coin_product_due_limit(date));
            updateBtnBgColor();
            return;
        }
        const formatTimeStr = timeObj.formatTime;
        const arr = formatTimeStr.split("/", 3);
        var today;
        if (moduleData$4.currentTime == -1) {
            today = new Date;
        } else {
            today = new Date(moduleData$4.currentTime);
        }
        console.log(`showDatePicker : ${JSON.stringify(arr)}`);
        console.log(`showDatePicker getFullYear : ${today.getFullYear()}`);
        console.log(`showDatePicker getMonth : ${today.getMonth()}`);
        console.log(`showDatePicker getDate : ${today.getDate()}`);
        console.log(`showDatePicker getHours : ${today.getHours()}`);
        if (arr[0] == today.getFullYear()) {
            if (arr[1] < today.getMonth() + 1) {
                showToast($i18n.n_double_coin_due_date_not_less);
                updateBtnBgColor();
                return;
            } else if (arr[1] == today.getMonth() + 1 && arr[2] <= today.getDate() && today.getHours() > 14) {
                showToast($i18n.n_double_coin_due_date_not_less_2_new);
                updateBtnBgColor();
                return;
            }
        }
        moduleData$4.selectedDate = formatTimeStr;
        if (moduleData$4.selectedDate == $i18n.n_double_coin_earn_select_expire_date) {
            moduleData$4.selectedDateColor = "@color/eBaseColorThreeLevelText";
            moduleData$4.productDateVisible = "gone";
        } else {
            moduleData$4.selectedDateColor = "@color/kColorPrimaryText";
            moduleData$4.productDateVisible = "visible";
        }
        const day = formatPrecision(daysBetween(formatTimeStr), 0) + "";
        moduleData$4.productDate = $i18n.$intercept.n_double_coin_earn_product_deadline(day);
        requestYield();
        updateBtnBgColor();
    }
}

function timestampToNoon(timestamp) {
    const noonDate = new Date(timestamp);
    noonDate.setHours(16, 0, 0, 0);
    return noonDate.getTime();
}

function setSelectedItem(param) {
    moduleData$4.selectedItem = param;
    moduleData$4.priceUnit = param["quote-currency"].toUpperCase();
    clearIndexPriceTimer$1();
    clearData();
    intervalRequestIndexPrice$1();
    requestYield();
    updateBtnBgColor();
}

function daysBetween(end) {
    const eDate = Date.parse(end);
    const sDate = new Date(new Date((new Date).toLocaleDateString()).getTime()).getTime();
    if (sDate > eDate) return 0;
    if (sDate === eDate) return 1;
    return (eDate - sDate) / (24 * 60 * 60 * 1e3);
}

function onDestroy$2() {
    clearIndexPriceTimer$1();
    clearData();
}

function clearIndexPriceTimer$1() {
    if (indexPriceTimer$1 != null) {
        clearInterval(indexPriceTimer$1);
        indexPriceTimer$1 = null;
    }
}

function focusChange(param) {
    if (param == false && productYieldError) {
        return;
    }
    updateBtnBgColor();
    updateEditTextBorderColor(param);
}

function textChange(text) {
    console.log(`textChange : ${text}`);
    if (text.length > 0) {
        moduleData$4.clearVisibility = "visible";
    } else {
        moduleData$4.clearVisibility = "gone";
    }
    if (text == "" || inputNum(text)) {
        moduleData$4.editErrorShow = "gone";
    } else {
        moduleData$4.editErrorShow = "visible";
    }
    moduleData$4.targetPriceText = text;
    productYieldError = false;
    updateEditTextBorderColor();
    updateBtnBgColor();
    if (moduleData$4.btnBgColor == "@color/kColorMajorTheme100") {
        requestYield();
    }
}

function updateEditTextBorderColor(focus = true) {
    if (moduleData$4.editErrorShow == "visible") {
        moduleData$4.editTextBorderColor = "#E94359";
    } else if (focus || focus == "true") {
        moduleData$4.editTextBorderColor = "@color/kColorMajorTheme100";
    } else {
        moduleData$4.editTextBorderColor = "@color/KBaseColorInputBackground";
    }
}

function updateBtnBgColor() {
    if (moduleData$4.selectedItem["product-type-id"] != "5" && moduleData$4.selectedItem["product-type-id"] != "6") {
        moduleData$4.btnBgColor = "@color/baseColorThreeLevelText";
        return;
    }
    if (moduleData$4.selectedTime <= 0) {
        moduleData$4.btnBgColor = "@color/baseColorThreeLevelText";
        return;
    }
    if (moduleData$4.editErrorShow == "visible" || moduleData$4.targetPriceText == "") {
        moduleData$4.btnBgColor = "@color/baseColorThreeLevelText";
        return;
    }
    moduleData$4.btnBgColor = "@color/kColorMajorTheme100";
}

function submit() {
    if (moduleData$4.btnBgColor == "@color/kColorMajorTheme100") {
        const url = "holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=doublecoin&rootName=productsub&navConfig=native";
        const productTypeId = moduleData$4.selectedItem["product-type-id"];
        const productId = moduleData$4.selectedItem["product-id"];
        const productFinanceId = moduleData$4.selectedItem["product-finance-id"];
        const hookPrice = moduleData$4.targetPriceText;
        const expireAt = moduleData$4.selectedTime + "";
        const currency = moduleData$4.selectedItem["base-currency"];
        const quote = moduleData$4.selectedItem["quote-currency"];
        openURL(`${url}&productTypeId=${productTypeId}&productId=${productId}&productFinanceId=${productFinanceId}&hookPrice=${hookPrice}&expireAt=${expireAt}&currency=${currency}&quote=${quote}`);
    }
}

function cleanPrice() {
    moduleData$4.targetPriceText = "";
    moduleData$4.clearVisibility = "gone";
    moduleData$4.editErrorShow = "gone";
    if (commonData.OS == 0) {
        textChange("");
    }
}

function inputNum(t) {
    const low = parseFloat(moduleData$4.lowPrice);
    const high = parseFloat(moduleData$4.highPrice);
    const cur = parseFloat(t);
    if (cur <= high && cur >= low) {
        return true;
    }
    return false;
}

moduleEvent$4.openAlert = openAlert;

moduleEvent$4.closeAlert = closeAlert;

moduleEvent$4.choseCoin = choseCoin;

moduleEvent$4.choseCoinType = choseCoinType;

moduleEvent$4.showDatePicker = showDatePicker;

moduleEvent$4.textChange = textChange;

moduleEvent$4.cleanPrice = cleanPrice;

moduleEvent$4.focusChange = focusChange;

moduleEvent$4.submit = submit;

function defaultData$3() {
    return {
        mainData: [],
        refreshStatus: 0,
        baseCoinIcon: "",
        quoteCoinIcon: "",
        subTitle: "",
        usdtColor: "@color/kColorPrimaryText",
        usdtBg: "@color/KBaseColorContentBackground",
        usdcColor: "@color/kColorThreeLevelText",
        usdcBg: "#00000000",
        threeTitle: "",
        tabData: [],
        quoteVis: "visible",
        indexPrice: "--",
        quoteCoin: "usdt"
    };
}

var parameter$1 = {};

var d7 = $i18n.$intercept.n_c2c_lend_days("<7");

var d73 = $i18n.$intercept.n_c2c_lend_days("7-30");

var d39 = $i18n.$intercept.n_c2c_lend_days("30-90");

var d9 = $i18n.$intercept.n_c2c_lend_days(">90");

const hh$1 = 36e5;

const dd$1 = 864e5;

var listReqObj = {};

var indexPriceReqObj = {};

var indexPrice = 0;

let listTimerObject;

const {moduleData: moduleData$3, moduleEvent: moduleEvent$3} = moduleDefine("coindetail", defaultData$3, {
    onCreate: onCreate$3,
    onDestroy: onDestroy$1,
    onResume: onResume$1,
    onPause: onPause
});

function onCreate$3(jsonParameters) {
    try {
        console.log(`coinDetail create : ${jsonParameters}`);
        let parameterTemp = JSON.parse(jsonParameters);
        parameter$1 = {
            productTypeId: parameterTemp.productTypeId,
            currency: parameterTemp.currency,
            supportQuotes: parameterTemp.supportQuotes.split("-")
        };
        console.log(`coinDetail init  ${parameter$1}`);
        initUi$1();
        initData$1();
    } catch (e) {
        console.log(`init error, error=${e}`);
    }
}

function onResume$1() {
    console.log("coindetail onResume");
    intervalRequestProductList();
}

function onPause() {
    console.log("coindetail onPause");
    clearListTimer();
}

function initData$1() {
    listReqObj = {
        productTypeId: parameter$1.productTypeId,
        symbol: `${parameter$1.currency}${parameter$1.supportQuotes[0]}`,
        currency: parameter$1.productTypeId == 6 ? parameter$1.currency : parameter$1.supportQuotes[0]
    };
    indexPriceReqObj = {
        symbol: `${parameter$1.currency}${parameter$1.supportQuotes[0]}`
    };
}

function initUi$1() {
    let title = "";
    if (parameter$1.productTypeId == 5) {
        title = $i18n.$intercept.n_double_coin_earn_low_buy(parameter$1.currency.toUpperCase());
    } else {
        title = $i18n.$intercept.n_double_coin_earn_high_sell(parameter$1.currency.toUpperCase());
    }
    moduleData$3.navConfig = getNavConfigString$2(title);
    updateSecondTitle(parameter$1.supportQuotes[0].toUpperCase());
    updateThreeTitle(parameter$1.supportQuotes[0].toUpperCase());
    updateCoinIcon(parameter$1.supportQuotes[0].toUpperCase());
    if (parameter$1.supportQuotes.length == 1) {
        moduleData$3.quoteVis = "gone";
    } else {
        moduleData$3.quoteVis = "visible";
    }
}

function updateCoinIcon(quote) {
    if (parameter$1.productTypeId == 5) {
        moduleData$3.baseCoinIcon = getPNGIconURLByCurrency(quote);
        moduleData$3.quoteCoinIcon = getPNGIconURLByCurrency(parameter$1.currency);
    } else {
        moduleData$3.baseCoinIcon = getPNGIconURLByCurrency(parameter$1.currency);
        moduleData$3.quoteCoinIcon = getPNGIconURLByCurrency(quote);
    }
    console.log(`icon Url : ${getPNGIconURLByCurrency(parameter$1.currency)}`);
}

function updateThreeTitle(quote) {
    let base = parameter$1.currency.toUpperCase();
    if (parameter$1.productTypeId == 5) {
        moduleData$3.threeTitle = $i18n.$intercept.n_double_coin_earn_low_buy_explain_new(quote, quote, base, quote, base, base, base);
    } else {
        moduleData$3.threeTitle = $i18n.$intercept.n_double_coin_earn_high_sell_explain_new(base, quote, base, base, base, base, quote);
    }
}

function updateSecondTitle(quote) {
    if (parameter$1.productTypeId == 5) {
        moduleData$3.subTitle = $i18n.$intercept.n_double_coin_earn_low_buy_something(quote, parameter$1.currency.toUpperCase());
    } else {
        moduleData$3.subTitle = $i18n.$intercept.n_double_coin_earn_high_sell_for(parameter$1.currency.toUpperCase(), quote);
    }
}

async function intervalRequestProductList() {
    console.log("start Timer");
    clearListTimer();
    if (null == listTimerObject) {
        requestProductList();
        listTimerObject = setInterval(requestProductList, 6e3);
    }
}

function clearListTimer() {
    if (listTimerObject != null) {
        clearInterval(listTimerObject);
        listTimerObject = null;
    }
}

async function requestProductList() {
    const priceData = await sendRequest("otc/opt/option/v1/pre/index", indexPriceReqObj);
    console.log(`indexPrice : ${JSON.stringify(priceData)}`);
    if (priceData) {
        indexPrice = priceData;
        moduleData$3.indexPrice = $i18n.$intercept.n_double_coin_earn_quantity_latest(parameter$1.currency.toUpperCase(), `${indexPrice}`);
    }
    console.log("coinDetail requestProductList");
    const data = await sendRequest("otc/opt/option/order/v2/double-currency-win/products", listReqObj);
    handleMainListData(data);
}

function handleMainListData(data) {
    if (!data || data.length == 0) {
        console.log(`handleMainListData 空数据`);
        moduleData$3.mainData = [ {
            type: "2"
        } ];
        if (!listReqObj.cycle || listReqObj.cycle == "") {
            moduleData$3.tabData = createTempTabData();
        }
        return;
    }
    console.log(`coinDetail1 : ${JSON.stringify(data)}`);
    if (moduleData$3.tabData.length == 0) {
        moduleData$3.tabData = handleTabData(data);
    }
    var dataList = [];
    for (var i = 0; i < data.length; i++) {
        const curData = data[i];
        var parentObj = {};
        parentObj.index = i;
        parentObj.type = "1";
        let currTime = curData["curr-time"];
        let expireTime = curData["expire-time"];
        let diffTime = expireTime - currTime;
        if (diffTime > 0) {
            const d = Math.floor(diffTime / dd$1);
            const h = Math.floor(diffTime / hh$1);
            if (d > 0) {
                parentObj.timeLimit = `${$i18n.n_home_index_earn_time_limit}：${d}${$i18n.n_day}`;
            } else {
                parentObj.timeLimit = `${$i18n.n_home_index_earn_time_limit}：${h}${$i18n.n_hour}`;
            }
        }
        parentObj.dueDate = $i18n.$intercept.n_double_coin_earn_expire_date_new(`${new Date(expireTime).Format("yyyy/MM/dd hh:mm")}`);
        var products = curData.products;
        console.log(`coinDetail3 ${JSON.stringify(products)}`);
        for (var j = 0; j < products.length; j++) {
            const curData = products[j];
            curData.type = "2";
            curData.index = j;
            curData.price = curData["hook-price"];
            curData.yieldByDay = calYield(curData);
            curData.yieldByYear = `${formatPrecision(curData.arr, 2)}%`;
        }
        parentObj.products = products;
        dataList.push(parentObj);
    }
    console.log(`coinDetail4 : ${JSON.stringify(dataList)}`);
    moduleData$3.mainData = dataList;
    moduleData$3.refreshStatus = 2;
}

function handleTabData(data) {
    let tabData = [];
    tabData.push(getTabUiData($i18n.n_balance_all, true));
    for (var i = 0; i < data.length; i++) {
        const curData = data[i];
        if (curData.cycle < 7 && !isContains(tabData, d7)) {
            tabData.push(getTabUiData(d7, false));
        }
        if (curData.cycle > 6 && curData.cycle < 30 && !isContains(tabData, d73)) {
            tabData.push(getTabUiData(d73, false));
        }
        if (curData.cycle > 29 && curData.cycle < 90 && !isContains(tabData, d39)) {
            tabData.push(getTabUiData(d39, false));
        }
        if (curData.cycle > 89 && !isContains(tabData, d9)) {
            tabData.push(getTabUiData(d9, false));
        }
    }
    return tabData;
}

function createTempTabData() {
    let tabData = [];
    tabData.push(getTabUiData($i18n.n_balance_all, true));
    tabData.push(getTabUiData(d7, false));
    tabData.push(getTabUiData(d73, false));
    tabData.push(getTabUiData(d39, false));
    tabData.push(getTabUiData(d9, false));
    return tabData;
}

function isContains(data, title) {
    for (var i = 0; i < data.length; i++) {
        if (data[i].title == title) {
            return true;
        }
    }
    return false;
}

function getTabUiData(title, isCheck) {
    return {
        tag: title,
        title: title,
        titleColor: isCheck ? "@color/kColorPrimaryText" : "@color/kColorThreeLevelText",
        titleSize: isCheck ? "16" : "14"
    };
}

function calYield(product) {
    if (indexPrice == 0) {
        return "--%";
    }
    let ratio = (1 - indexPrice / product["hook-price"]) * 100;
    let ratioStr = formatPrecision(ratio, 2);
    console.log(`ratio : ${ratio}  -- > ${indexPrice / product["hook-price"]}`);
    if (ratio > 0) {
        return `+${ratioStr}%`;
    } else {
        return `${ratioStr}%`;
    }
}

function getNavConfigString$2(title) {
    return {
        title: title,
        left: {
            action: {
                type: "back",
                parameter: ""
            },
            icon: "edge_engine_top_bar_back_normal"
        },
        right: {
            action: {
                type: "evalJS",
                parameter: "showTipsDialog"
            },
            icon: "edge_engine_double_coin_detail_tips"
        },
        backgroundColor: "KBaseColorDeepestBackground"
    };
}

moduleEvent$3.refresh = function() {
    moduleData$3.refreshStatus = 1;
    initData$1();
};

moduleEvent$3.usdtClick = function() {
    quoteCheck(1);
    updateSecondTitle(parameter$1.supportQuotes[0].toUpperCase());
    updateThreeTitle(parameter$1.supportQuotes[0].toUpperCase());
    updateCoinIcon(parameter$1.supportQuotes[0].toUpperCase());
    listReqObj.symbol = `${parameter$1.currency}${parameter$1.supportQuotes[0]}`;
    listReqObj.currency = parameter$1.productTypeId == 6 ? parameter$1.currency : parameter$1.supportQuotes[0];
    indexPriceReqObj.contract_code = `${parameter$1.currency.toUpperCase()}-${parameter$1.supportQuotes[0].toUpperCase()}`;
    indexPriceReqObj.symbol = `${parameter$1.currency}${parameter$1.supportQuotes[0]}`;
    intervalRequestProductList();
    moduleData$3.quoteCoin = parameter$1.supportQuotes[0];
};

moduleEvent$3.usdcClick = function() {
    quoteCheck(2);
    updateSecondTitle(parameter$1.supportQuotes[1].toUpperCase());
    updateThreeTitle(parameter$1.supportQuotes[1].toUpperCase());
    updateCoinIcon(parameter$1.supportQuotes[1].toUpperCase());
    listReqObj.symbol = `${parameter$1.currency}${parameter$1.supportQuotes[1]}`;
    listReqObj.currency = parameter$1.productTypeId == 6 ? parameter$1.currency : parameter$1.supportQuotes[1];
    indexPriceReqObj.contract_code = `${parameter$1.currency.toUpperCase()}-${parameter$1.supportQuotes[1].toUpperCase()}`;
    indexPriceReqObj.symbol = `${parameter$1.currency}${parameter$1.supportQuotes[1]}`;
    intervalRequestProductList();
    moduleData$3.quoteCoin = parameter$1.supportQuotes[1];
};

moduleEvent$3.showTipsDialog = function() {
    console.log(`showTipsDialog`);
    openURL("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=earn&rootName=introduce&navConfig=nav&index=2&tabIndex=1");
};

function quoteCheck(flag) {
    if (flag == 1) {
        moduleData$3.usdtBg = "@color/KBaseColorContentBackground";
        moduleData$3.usdtColor = "@color/kColorPrimaryText";
        moduleData$3.usdcBg = "#00000000";
        moduleData$3.usdcColor = "@color/kColorThreeLevelText";
    } else {
        moduleData$3.usdcBg = "@color/KBaseColorContentBackground";
        moduleData$3.usdcColor = "@color/kColorPrimaryText";
        moduleData$3.usdtBg = "#00000000";
        moduleData$3.usdtColor = "@color/kColorThreeLevelText";
    }
}

moduleEvent$3.itemOnClick = function(parentIndex, childIndex) {
    console.log(`itemOnClick element : ${parentIndex}  ${childIndex}`);
    var element = moduleData$3.mainData[parentIndex].products[childIndex];
    console.log(`itemOnClick element : ${JSON.stringify(element.rawObject())}`);
    var quote = "";
    if (parameter$1.productTypeId == 5) {
        quote = element["currency"];
    } else {
        quote = element["covert-currency"];
    }
    console.log(`productTypeId=${parameter$1.productTypeId}&productId=${element["product-id"]}&productFinanceId=${element["product-finance-id"]}&currency=${element["trade-currency"]}&quote=${quote}`);
    let url = "holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=doublecoin&rootName=productsub&navConfig=native";
    openURL(`${url}&productTypeId=${parameter$1.productTypeId}&productId=${element["product-id"]}&productFinanceId=${element["product-finance-id"]}&currency=${element["trade-currency"]}&quote=${quote}`);
};

moduleEvent$3.tabClick = function(tabTag) {
    console.log(`tab click ${tabTag}`);
    if (tabTag == d7) {
        listReqObj.cycle = 1;
    } else if (tabTag == d73) {
        listReqObj.cycle = 2;
    } else if (tabTag == d39) {
        listReqObj.cycle = 3;
    } else if (tabTag == d9) {
        listReqObj.cycle = 4;
    } else {
        listReqObj.cycle = "";
    }
    for (var i = 0; i < moduleData$3.tabData.length; i++) {
        var obj = moduleData$3.tabData[i];
        if (obj.titleColor == "@color/kColorPrimaryText") {
            if (obj.tag == tabTag) {
                return;
            }
            var temObject = moduleData$3.tabData[i];
            temObject.tag = obj.title;
            temObject.title = obj.title;
            temObject.titleColor = "@color/kColorThreeLevelText";
            temObject.titleSize = "14";
        }
        if (obj.tag == tabTag) {
            var temObject = moduleData$3.tabData[i];
            temObject.tag = obj.title;
            temObject.title = obj.title;
            temObject.titleColor = "@color/kColorPrimaryText";
            temObject.titleSize = "16";
        }
    }
    intervalRequestProductList();
};

moduleEvent$3.refresh = function() {
    intervalRequestProductList();
};

moduleEvent$3.toCustom = function() {
    openURL(`holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=doublecoin&rootName=custom&navConfig=native&currency=${parameter$1.currency}&quoteCoin=${moduleData$3.quoteCoin}&productTypeId=${parameter$1.productTypeId}`);
};

function onDestroy$1() {
    console.log("coindetail onDestroy");
    clearListTimer();
}

function getNavConfigString$1() {
    let nav = {
        titleKey: "n_double_coin_earn_what",
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

function defaultData$2() {
    return {
        currentTag: 0,
        currentIndex: 0,
        titleData: [ {
            title: $i18n.n_double_coin_product_introduce,
            titleSize: "14",
            titleColor: "@color/kColorPrimaryText",
            tag: "0"
        }, {
            title: $i18n.n_double_coin_payment_regulation,
            titleSize: "14",
            titleColor: "@color/kColorSecondaryText",
            tag: "1"
        }, {
            title: $i18n.n_shark_fin_common_problem,
            titleSize: "14",
            titleColor: "@color/kColorSecondaryText",
            tag: "2"
        } ],
        sliderData: [ {
            listType: "1"
        }, {
            listType: "2"
        }, {
            listType: "3"
        } ],
        compoText1: $i18n.$intercept.n_double_coin_product_operation_eg_buy_one_less("≤"),
        problems1Open: "visible",
        problems1Close: "gone",
        problems2Open: "gone",
        problems2Close: "visible",
        problems3Open: "gone",
        problems3Close: "visible",
        problems4Open: "gone",
        problems4Close: "visible",
        problems5Open: "gone",
        problems5Close: "visible"
    };
}

const {moduleData: moduleData$2, moduleEvent: moduleEvent$2} = moduleDefine("introduce", defaultData$2, {
    onCreate: onCreate$2
});

function onCreate$2(param) {
    console.log("introduce on create");
    console.log(param);
    moduleData$2.navConfig = getNavConfigString$1();
    let paramDic = JSON.parse(param);
    let index = parseInt(paramDic["index"]);
    console.log(index);
    console.log(parseInt(index));
    if (index == undefined || isNaN(index)) {
        index = 0;
    }
    moduleEvent$2.tabClick(index);
}

function resetTitlesStyle(idx) {
    for (let i = 0; i < moduleData$2.titleData.length; i++) {
        var obj = moduleData$2.titleData[i];
        obj.titleSize = "14";
        obj.titleColor = "@color/kColorSecondaryText";
    }
    var cur = moduleData$2.titleData[idx];
    cur.titleColor = "@color/kColorPrimaryText";
}

moduleEvent$2.openOrCloseProblem = function(index) {
    let visible = moduleData$2[`problems${index}Open`];
    if (visible == "visible") {
        moduleData$2[`problems${index}Close`] = visible;
        visible = "gone";
    } else {
        moduleData$2[`problems${index}Close`] = visible;
        visible = "visible";
    }
    moduleData$2[`problems${index}Open`] = visible;
};

moduleEvent$2.tabClick = function(idx) {
    resetTitlesStyle(idx);
    moduleData$2.currentIndex = `${idx}`;
};

moduleEvent$2.resetTitleSelectTab = function(idx) {
    resetTitlesStyle(idx);
};

function defaultData$1() {
    return {
        mainData: {},
        yearYield: "--",
        yield: "--",
        expireDate: "--",
        hookPrice: "--",
        priceLimit: "--",
        subHint: "",
        subInput: "",
        subOnFocus: false,
        baseCoin: "",
        quoteCoin: "",
        balance: "--",
        estimatedProfit: "--",
        residueBuy: "",
        wpOnFocus: false,
        subUnit: "",
        indexPrice: "",
        withdrawPriceHint: "",
        withdrawPriceVis: "gone",
        redeemPriceVis: "gone",
        openCloseStr: $i18n.n_content_expand,
        openCloseRes: "@drawable/edge_engine_ic_dc_status_open",
        chartBaseData: "",
        withDrawPrice: "",
        quantity: "",
        openAccountAlertShow: false,
        tipsAlertShowCommon: false,
        tipsAlertShowWp: false,
        expireTimeTips: "",
        wpBorderColor: "@color/KBaseColorInputBackground",
        subBorderColor: "@color/KBaseColorInputBackground",
        subErrorStr: "",
        subErrorVis: "gone",
        wpErrorStr: "",
        wpErrorVis: "gone",
        tipsStr: "",
        principalPrecision: 4,
        btnColor: "@color/kColorEBEBEB",
        btnTitleColor: "@color/kColorThreeLevelText",
        subAlertShow: false,
        productName: "",
        withDrawVis: "gone",
        pop1Show: "false",
        pop2Show: "false",
        pop3Show: "false",
        huobiSelected: false,
        huobiAgreeImage: "@drawable/edge_engine_live_redpacket_unselect",
        agreeText: "",
        doColor: "@color/eButtonUnenabledBgColor",
        doBackColor: "@color/kColorEBEBEB"
    };
}

var parameter = {};

let indexPriceTimer;

let subDetailTimer;

let checkPriceTimer;

var subInput = "";

var wpInput = "";

var mMinSub = "";

var btnEnable = false;

var indexPrie = "0";

const hh = 36e5;

const dd = 864e5;

const {moduleData: moduleData$1, moduleEvent: moduleEvent$1} = moduleDefine("productsub", defaultData$1, {
    onCreate: onCreate$1,
    onDestroy: onDestroy,
    onResume: onResume
});

function onCreate$1(jsonParameters) {
    console.log(`onCreate jsonParameters : ${jsonParameters}`);
    parameter = JSON.parse(jsonParameters);
    initUi();
    initData();
}

async function onResume() {
    console.log(`onResume`);
    requestBanlance();
}

function initUi() {
    let title = "";
    if (parameter.productTypeId == 5) {
        moduleData$1.subUnit = parameter.quote.toUpperCase();
        title = $i18n.$intercept.n_double_coin_earn_low_buy_something(parameter.quote.toUpperCase(), parameter.currency.toUpperCase());
    } else {
        moduleData$1.subUnit = parameter.currency.toUpperCase();
        title = $i18n.$intercept.n_double_coin_earn_high_sell_for(parameter.currency.toUpperCase(), parameter.quote.toUpperCase());
    }
    moduleData$1.statusBarConfig = {
        statusBarMode: "true",
        adStatusBarColor: "KBaseColorInputBackground",
        keyBoardMode: "adjustPan"
    };
    moduleData$1.navConfig = getNavConfigString(title);
    moduleData$1.baseCoin = parameter.currency.toUpperCase();
    moduleData$1.quoteCoin = parameter.quote.toUpperCase();
    const color = commonData.colorMode == 1 ? "#E6E6E6" : "#000000";
    const fullText = $i18n.n_doublecoin_pop_agreement_content_full;
    const richText = $i18n.n_doublecoin_pop_agreement_content;
    const spanStart = `<span style="color:${color}; font-size:12px;">`;
    const richHighlight = `</span><span style="color:#0173E5; font-size:12px;">${richText}</span>${spanStart}`;
    const joinText = fullText.split(richText).join(richHighlight);
    moduleData$1.agreeText = `${spanStart}${joinText}</span>`;
}

function initData() {
    intervalRequestIndexPrice();
    intervalSubDetail();
}

function intervalSubDetail() {
    if (subDetailTimer == null) {
        requestSubDetail();
        subDetailTimer = setInterval(requestSubDetail, 1e4);
    }
}

async function requestBanlance() {
    if (accountId == -1) {
        console.log(`账户ID获取失败`);
        return;
    }
    const data = await sendRequest(`v1/account/accounts/${accountId}/balance`, {}, 0, 4);
    if (data != null && data.list != null) {
        for (var i = 0; i < data.list.length; i++) {
            let element = data.list[i];
            console.log(`requestBanlance : ${element.currency.toUpperCase()}  ------  ${moduleData$1.subUnit}    ------ ${element.currency.toUpperCase() == moduleData$1.subUnit}`);
            if (element.type == "trade" && element.currency.toUpperCase() == moduleData$1.subUnit) {
                var formatBalance = formatPrecision(element.balance, 8).toString();
                console.log(`doubleCoinFormat stringValue : ${formatBalance} `);
                console.log(`doubleCoinFormat stringValue : ${removeExtraZeros(formatBalance)} `);
                moduleData$1.balance = `${removeExtraZeros(formatPrecision(element.balance, 8).toString())}`;
                element.balance;
                break;
            }
        }
    } else {
        moduleData$1.balance = `--`;
    }
}

async function requestSubDetail() {
    let reqObkj = {
        productTypeId: parameter.productTypeId,
        productId: parameter.productId,
        productFinanceId: parameter.productFinanceId,
        hookPrice: parameter.hookPrice,
        expireAt: parameter.expireAt
    };
    const data = await sendRequest("otc/opt/option/order/v2/double-currency-win/product", reqObkj);
    console.log(`mainData : ${JSON.stringify(data)}`);
    moduleData$1.mainData = data;
    if (data != null) {
        if (checkPriceTimer == null) {
            moduleData$1.yearYield = `${formatPrecision(data.arr, 2)}%`;
            moduleData$1.yield = `${formatPrecision(data["earning-rate"], 4)}%`;
        }
        let currTime = data["curr-time"];
        let expireTime = data["expire-at"];
        let diffTime = expireTime - currTime;
        let remainIng = "";
        if (diffTime > 0) {
            const d = Math.floor(diffTime / dd);
            const h = Math.floor(diffTime / hh);
            if (d > 0) {
                remainIng = `${d}${$i18n.n_day}`;
            } else {
                remainIng = `${h}${$i18n.n_hour}`;
            }
        }
        let expire = $i18n.$intercept.n_double_coin_earn_expire_date_new(`${new Date(expireTime).Format("yyyy/MM/dd hh:mm")}`);
        moduleData$1.expireDate = `${remainIng}  (${expire})`;
        moduleData$1.hookPrice = data["hook-price"];
        mMinSub = data["min-expenses"];
        moduleData$1.subHint = $i18n.$intercept.n_shark_fin_min_amount(`${mMinSub}`);
        moduleData$1.residueBuy = `${data["total-quantity"] - data["used-quantity"]}`;
        if (parameter.productTypeId == 5) {
            moduleData$1.withdrawPriceHint = $i18n.$intercept.n_double_coin_withdraw_price_low_buy_hint(data["hook-price"]);
        } else {
            moduleData$1.withdrawPriceHint = $i18n.$intercept.n_double_coin_withdraw_price_high_sell_hint(data["hook-price"]);
        }
        moduleData$1.productName = data["product-name"];
        moduleData$1.principalPrecision = data["principal-precision"];
        if (data["show-redeem-price"] == true) {
            moduleData$1.redeemPriceVis = "visible";
        } else {
            moduleData$1.redeemPriceVis = "gone";
            moduleData$1.withdrawPriceVis = "gone";
        }
        var chartBaseData = {
            productTypeId: parameter.productTypeId,
            baseCoin: parameter.currency,
            quoteCoin: parameter.quote,
            hookPrice: getHookPrice()
        };
        console.log(`chartBaseData ： ${moduleData$1.chartBaseData == ""}  ${moduleData$1.chartBaseData != JSON.stringify(chartBaseData)}`);
        if (moduleData$1.chartBaseData == "" || moduleData$1.chartBaseData != JSON.stringify(chartBaseData)) {
            moduleData$1.chartBaseData = JSON.stringify(chartBaseData);
        }
        var guideShow = await $nativeAPI.storage({
            action: "read",
            name: "doubleCoin",
            key: "guide_show"
        });
        if (guideShow == null || guideShow == "") {
            moduleData$1.pop1Show = true;
            $nativeAPI.storage({
                action: "save",
                name: "doubleCoin",
                key: "guide_show",
                data: "1"
            });
        }
        calPriceLimit();
    } else {
        containerBack();
    }
}

function removeExtraZeros(num) {
    return num.replace(/(\.\d*?[1-9])0+$/, "$1");
}

function intervalCheckPrice() {
    clearCheckPriceTimer();
    if (checkPriceTimer == null) {
        requestCheckPrice();
        checkPriceTimer = setInterval(requestCheckPrice, 1e4);
    }
}

async function requestCheckPrice() {
    var reqObkj = {
        productTypeId: parameter.productTypeId,
        productFinanceId: parameter.productFinanceId,
        tradeCurrency: parameter.currency,
        currency: parameter.productTypeId == 5 ? parameter.quote : parameter.currency,
        hookPrice: getHookPrice(),
        expensesPayable: subInput,
        expireAt: getExpireAt()
    };
    if (wpInput != null && wpInput != "") {
        reqObkj.redeemPrice = wpInput;
    }
    const response = await sendRequest2("otc/opt/option/order/v1/double-currency-win/pricing", reqObkj);
    var {code: code, data: data} = response;
    console.log(`requestCheckPrice : ${JSON.stringify(data)}`);
    if (code == 200 || response.status == "ok") {
        moduleData$1.estimatedProfit = data["estimate-profit"];
        moduleData$1.yearYield = `${formatPrecision(data["arr"], 2)}%`;
        moduleData$1.yield = `${formatPrecision(data["earning-rate"], 4)}%`;
        moduleData$1.wpBorderColor = "@color/KBaseColorInputBackground";
        moduleData$1.wpErrorVis = "gone";
        checkBtnStatus();
    } else {
        if (code === 40046) {
            moduleData$1.estimatedProfit = "--";
            moduleData$1.wpErrorStr = $i18n.n_double_coin_wp_price_error_tips;
            moduleData$1.wpBorderColor = "@color/KBaseInputInvalidTipColor";
            moduleData$1.wpErrorVis = "visible";
            checkBtnStatus();
        } else {
            let message = response.message;
            if (message) {
                showToast(message);
                btnEnable = false;
                moduleData$1.btnColor = "@color/kColorEBEBEB";
                moduleData$1.btnTitleColor = "@color/kColorThreeLevelText";
            }
        }
        clearCheckPriceTimer();
    }
}

function clearCheckPriceTimer() {
    if (checkPriceTimer != null) {
        clearInterval(checkPriceTimer);
        checkPriceTimer = null;
    }
}

function getExpireAt() {
    return parameter.expireAt == null ? moduleData$1.mainData["expire-at"] : parameter.expireAt;
}

function intervalRequestIndexPrice() {
    if (indexPriceTimer == null) {
        requestIndexPrice();
        indexPriceTimer = setInterval(requestIndexPrice, 5e3);
    }
}

async function requestIndexPrice() {
    const data = await sendRequest("otc/opt/option/v1/pre/index", {
        symbol: `${parameter.currency}${parameter.quote}`
    });
    console.log(`indexPrice : ${JSON.stringify(data)}`);
    if (data) {
        moduleData$1.indexPrice = $i18n.$intercept.n_double_coin_earn_quantity_latest(parameter.currency.toUpperCase(), `${data}`);
        indexPrie = data;
        calPriceLimit();
    } else {
        indexPrie = "0";
        moduleData$1.indexPrice = $i18n.$intercept.n_double_coin_earn_quantity_latest(parameter.currency.toUpperCase(), "--");
    }
}

function calPriceLimit() {
    let hookPrice = getHookPrice();
    if (hookPrice != null && hookPrice != "--") {
        let ratio = (1 - indexPrie / hookPrice) * 100;
        console.log(`requestIndexPrice ${ratio}   ${hookPrice}`);
        if (ratio >= 0 && ratio < .01) {
            ratio = .01;
        } else if (ratio < 0 && ratio > -.01) {
            ratio = -.01;
        }
        let ratioStr = formatPrecision(ratio, 2);
        if (ratio >= 0) {
            moduleData$1.priceLimit = `+${ratioStr}%`;
        } else {
            moduleData$1.priceLimit = `${ratioStr}%`;
        }
    } else {
        moduleData$1.priceLimit = `--`;
    }
}

function onDestroy() {
    console.log(`onDestroy`);
    clearIndexPriceTimer();
    clearUIData();
}

function clearUIData() {
    moduleData$1.yearYield = "--";
    moduleData$1.yield = "--";
    moduleData$1.expireDate = "--";
    moduleData$1.hookPrice = "--";
    moduleData$1.priceLimit = "--";
    moduleData$1.subHint = "";
    moduleData$1.subInput = "";
    moduleData$1.subOnFocus = false;
    moduleData$1.baseCoin = "";
    moduleData$1.quoteCoin = "";
    moduleData$1.balance = "--";
    moduleData$1.estimatedProfit = "--";
    moduleData$1.residueBuy = "";
    moduleData$1.wpOnFocus = false;
    moduleData$1.subUnit = "";
    moduleData$1.indexPrice = "";
    moduleData$1.withdrawPriceHint = "";
    moduleData$1.withdrawPriceVis = "gone";
    moduleData$1.openCloseStr = $i18n.n_content_expand;
    moduleData$1.openCloseRes = "@drawable/edge_engine_ic_dc_status_open";
    moduleData$1.chartBaseData = "";
    moduleData$1.withDrawPrice = "";
    moduleData$1.quantity = "";
    moduleData$1.openAccountAlertShow = false;
    moduleData$1.tipsAlertShowCommon = false;
    moduleData$1.tipsAlertShowWp = false;
    moduleData$1.expireTimeTips = "";
    moduleData$1.wpBorderColor = "@color/KBaseColorInputBackground";
    moduleData$1.subBorderColor = "@color/KBaseColorInputBackground";
    moduleData$1.subErrorStr = "";
    moduleData$1.subErrorVis = "gone";
    moduleData$1.wpErrorStr = "";
    moduleData$1.wpErrorVis = "gone";
    moduleData$1.tipsStr = "";
    moduleData$1.btnColor = "@color/kColorEBEBEB";
    moduleData$1.btnTitleColor = "@color/kColorThreeLevelText";
    moduleData$1.subAlertShow = false;
    moduleData$1.productName = "";
    moduleData$1.withDrawVis = "gone";
    wpInput = "";
    indexPrie = "0";
    moduleData$1.huobiSelected = false;
    moduleData$1.huobiAgreeImage = "@drawable/edge_engine_live_redpacket_unselect";
    moduleData$1.doBackColor = "@color/kColorEBEBEB";
    moduleData$1.doColor = "@color/eButtonUnenabledBgColor";
    btnEnable = false;
}

function clearIndexPriceTimer() {
    if (indexPriceTimer != null) {
        clearInterval(indexPriceTimer);
        indexPriceTimer = null;
    }
    if (subDetailTimer != null) {
        clearInterval(subDetailTimer);
        subDetailTimer = null;
    }
    clearCheckPriceTimer();
}

function getNavConfigString(title) {
    return {
        title: title,
        left: {
            action: {
                type: "back",
                parameter: ""
            },
            icon: "edge_engine_top_bar_back_normal"
        },
        backgroundColor: "KBaseColorDeepestBackground"
    };
}

async function checkOpenAccount() {
    const data = await sendRequest("otc/opt/option/order/v1/double-currency-win/check-all");
    console.log(`checkOpenAccount : ${JSON.stringify(data)}`);
    if (data["warrant-account"] == true) {
        openTransfer();
    } else {
        moduleData$1.openAccountAlertShow = true;
    }
}

function openTransfer() {
    let transferObj = {
        type: 1
    };
    if (parameter.productTypeId == 5) {
        transferObj.currency = parameter.quote;
    } else {
        transferObj.currency = parameter.currency;
    }
    $nativeAPI.doubleCoinAbility(JSON.stringify(transferObj));
}

moduleEvent$1.subTextChange = function(inputStr) {
    console.log(`subTextChange : ${inputStr}`);
    subInput = inputStr;
    checkSubInput();
    if (checkBtnStatus()) {
        moduleData$1.quantity = subInput;
        intervalCheckPrice();
    }
};

moduleEvent$1.subFocusChange = function(focus) {
    console.log(`subFocusChange : ${focus}`);
    if (!focus && moduleData$1.subErrorVis == "gone") ;
};

function checkSubInput() {
    const quantity = parseFloat(subInput);
    const minSub = parseFloat(mMinSub);
    const balance = moduleData$1.balance == "--" ? 0 : parseFloat(moduleData$1.balance);
    const residueBuy = parseFloat(moduleData$1.residueBuy);
    if (quantity > balance) {
        moduleData$1.subBorderColor = "@color/KBaseInputInvalidTipColor";
        moduleData$1.subErrorStr = $i18n.n_linear_swap_guide_asset_toast;
        moduleData$1.subErrorVis = "visible";
    } else if (quantity < minSub) {
        moduleData$1.subBorderColor = "@color/KBaseInputInvalidTipColor";
        moduleData$1.subErrorStr = moduleData$1.subHint;
        moduleData$1.subErrorVis = "visible";
    } else if (quantity > residueBuy) {
        moduleData$1.subBorderColor = "@color/KBaseInputInvalidTipColor";
        moduleData$1.subErrorStr = $i18n.n_double_coin_residue_insufficient;
        moduleData$1.subErrorVis = "visible";
    } else {
        moduleData$1.subBorderColor = "@color/KBaseColorInputBackground";
        moduleData$1.subErrorVis = "gone";
    }
}

moduleEvent$1.subOnReturn = function(parameter) {
    console.log(`subOnReturn : ${parameter}`);
    moduleData$1.subOnFocus = false;
};

moduleEvent$1.maxSub = function() {
    if (moduleData$1.balance != "--") {
        moduleData$1.subInput = moduleData$1.balance;
        if (commonData.OS == 0) {
            moduleEvent$1.subTextChange(moduleData$1.balance);
        }
    } else {
        moduleData$1.subInput = "0";
    }
};

moduleEvent$1.buyCoin = function() {
    let buyCoinObj = {
        type: 2,
        currency: moduleData$1.subUnit
    };
    console.log(`buyCoin : ${JSON.stringify(buyCoinObj)}`);
    $nativeAPI.doubleCoinAbility(JSON.stringify(buyCoinObj));
};

moduleEvent$1.transfer = function() {
    checkOpenAccount();
};

moduleEvent$1.wpTextChange = function(inputStr) {
    console.log(`wpTextChange : ${inputStr}`);
    wpInput = inputStr;
    if (wpInput != null && wpInput != "") {
        moduleData$1.withDrawVis = "visible";
    } else {
        moduleData$1.withDrawVis = "gone";
    }
    if (chenckWpInput()) {
        moduleData$1.withDrawPrice = wpInput;
    }
    if (checkBtnStatus()) {
        intervalCheckPrice();
    }
};

moduleEvent$1.wpFocusChange = function(focus) {
    console.log(`wpFocusChange : ${focus}`);
    if (!focus && moduleData$1.wpErrorVis == "gone") ;
};

function chenckWpInput() {
    const hookPrice = parseFloat(getHookPrice());
    const wp = parseFloat(wpInput);
    console.log(`wpInput : ${wpInput}   wp : ${wp}`);
    moduleData$1.wpErrorStr = moduleData$1.withdrawPriceHint;
    if (parameter.productTypeId == 5) {
        if (wp < hookPrice || wpInput == "") {
            moduleData$1.wpBorderColor = "@color/KBaseColorInputBackground";
            moduleData$1.wpErrorVis = "gone";
            return true;
        } else {
            moduleData$1.wpBorderColor = "@color/KBaseInputInvalidTipColor";
            moduleData$1.wpErrorVis = "visible";
            return false;
        }
    } else {
        if (wp > hookPrice || wpInput == "") {
            moduleData$1.wpBorderColor = "@color/KBaseColorInputBackground";
            moduleData$1.wpErrorVis = "gone";
            return true;
        } else {
            moduleData$1.wpBorderColor = "@color/KBaseInputInvalidTipColor";
            moduleData$1.wpErrorVis = "visible";
            return false;
        }
    }
}

function getHookPrice() {
    console.log(`getHookPrice : ${parameter.hookPrice == null || parameter.hookPrice == "" ? moduleData$1.hookPrice : parameter.hookPrice}`);
    return parameter.hookPrice == null || parameter.hookPrice == "" ? moduleData$1.hookPrice : parameter.hookPrice;
}

moduleEvent$1.nextPop = function(step) {
    moduleData$1.pop1Show = "false";
    moduleData$1.pop2Show = "false";
    moduleData$1.pop3Show = "false";
    moduleData$1[`pop${step}Show`] = "true";
};

moduleEvent$1.hidePop = function() {
    moduleData$1.pop1Show = "false";
    moduleData$1.pop2Show = "false";
    moduleData$1.pop3Show = "false";
};

moduleEvent$1.wpOnReturn = function(parameter) {
    console.log(`wpOnReturn : ${parameter}`);
    moduleData$1.wpOnFocus = false;
};

moduleEvent$1.closeOpenAccountAlert = function() {
    moduleData$1.openAccountAlertShow = false;
};

moduleEvent$1.openDoubleCoinAccount = async function() {
    let par = {};
    par["device-vToken"] = commonData.vToken;
    par["device-fbToken"] = commonData.oldVToken;
    const data = await sendRequest("otc/opt/option/order/v1/create-warrant", {}, 1, 0, par);
    if (data != null) {
        moduleData$1.openAccountAlertShow = false;
        showToast($i18n.n_double_coin_open_success);
    } else {
        showToast($i18n.n_double_coin_open_fail);
    }
};

function checkBtnStatus() {
    if (moduleData$1.subErrorVis == "gone" && moduleData$1.wpErrorVis == "gone" && subInput != "") {
        btnEnable = true;
        moduleData$1.btnColor = "@color/kColorMajorTheme100";
        moduleData$1.btnTitleColor = "@color/KBaseTextColor";
        return true;
    } else {
        btnEnable = false;
        moduleData$1.btnColor = "@color/kColorEBEBEB";
        moduleData$1.btnTitleColor = "@color/kColorThreeLevelText";
        return false;
    }
}

moduleEvent$1.showSubDialog = function() {
    if (btnEnable) {
        moduleData$1.subOnFocus = false;
        moduleData$1.wpOnFocus = false;
        moduleData$1.subAlertShow = true;
    }
};

moduleEvent$1.closeSubDialog = function() {
    moduleData$1.subAlertShow = false;
};

moduleEvent$1.doOrder = async function() {
    if (!moduleData$1.huobiSelected) {
        return;
    }
    console.log(`doOrder   ${JSON.stringify(parameter)}`);
    var data = null;
    var doOrder = {};
    if (parameter.hookPrice == null) {
        doOrder = {
            "channel-source": 2,
            "estimate-profit": moduleData$1.estimatedProfit,
            "product-id": parameter.productId,
            "product-finance-id": parameter.productFinanceId,
            notional: subInput
        };
        if (wpInput != null && wpInput != "") {
            doOrder["redeem-price"] = wpInput;
        }
        console.log(`doOrder   ${JSON.stringify(doOrder)}`);
        data = await sendRequest("otc/opt/option/order/v1/double-currency-win/place-order", doOrder, 1, 0, {
            "Content-Type": "application/json"
        });
    } else {
        console.log(`doOrder   ${JSON.stringify(parameter)}`);
        doOrder = {
            "product-type-id": parameter.productTypeId,
            "channel-source": 2,
            "estimate-profit": moduleData$1.estimatedProfit,
            "product-id": parameter.productId,
            "product-finance-id": parameter.productFinanceId,
            notional: subInput,
            "expire-at": parameter.expireAt,
            "hook-price": parameter.hookPrice
        };
        if (wpInput != null && wpInput != "") {
            doOrder["redeem-price"] = wpInput;
        }
        console.log(`doOrder   ${parameter.hookPrice}    ${JSON.stringify(parameter)}     ${JSON.stringify(doOrder)}`);
        data = await sendRequest("otc/opt/option/order/v1/double-currency-win/flexible-place-order", doOrder, 1, 0, {
            "Content-Type": "application/json"
        });
    }
    if (data != null) {
        moduleData$1.subAlertShow = false;
        let resultStr = `${doOrder.notional}  ${moduleData$1.subUnit}`;
        let url = "holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=doublecoin&rootName=result&navConfig=";
        openURL(`${url}&resultStr=${resultStr}`);
        containerBack(-1);
    }
    console.log(`doOrder   ${JSON.stringify(data)}`);
};

moduleEvent$1.openTipsDialog = function(type) {
    if (type == 1) {
        moduleData$1.tipsStr = $i18n.n_double_coin_yield_tips;
        moduleData$1.tipsAlertShowCommon = true;
    } else if (type == 2) {
        moduleData$1.tipsStr = $i18n.n_double_coin_with_draw_price_tips_new_2;
        moduleData$1.tipsAlertShowWp = true;
    }
};

moduleEvent$1.closeTipsDialog = function() {
    moduleData$1.tipsAlertShowCommon = false;
    moduleData$1.tipsAlertShowWp = false;
};

moduleEvent$1.clearFocus = function() {
    console.log(`clearFocus : ${parameter}`);
    moduleData$1.subOnFocus = false;
    moduleData$1.wpOnFocus = false;
};

moduleEvent$1.openWithdrawPriceInput = function() {
    if (moduleData$1.withdrawPriceVis == "gone") {
        moduleData$1.withdrawPriceVis = "visible";
        moduleData$1.openCloseStr = $i18n.n_content_collapse;
        moduleData$1.openCloseRes = "@drawable/edge_engine_ic_dc_status_close";
    } else {
        moduleData$1.withdrawPriceVis = "gone";
        moduleData$1.openCloseStr = $i18n.n_content_expand;
        moduleData$1.openCloseRes = "@drawable/edge_engine_ic_dc_status_open";
    }
};

moduleEvent$1.huobiSelected = function() {
    if (moduleData$1.huobiSelected) {
        moduleData$1.huobiSelected = false;
        moduleData$1.huobiAgreeImage = "@drawable/edge_engine_live_redpacket_unselect";
        moduleData$1.doBackColor = "@color/kColorEBEBEB";
        moduleData$1.doColor = "@color/eButtonUnenabledBgColor";
    } else {
        moduleData$1.huobiSelected = true;
        moduleData$1.huobiAgreeImage = "@drawable/edge_engine_live_redpacket_select";
        moduleData$1.doBackColor = "@color/kColorMajorTheme100";
        moduleData$1.doColor = "@color/KBaseTextColor";
    }
};

moduleEvent$1.huobilink = function() {
    moduleData$1.subAlertShow = false;
    openURL(`${commonData.h5Url}/${commonData.language}/support/24952033711717`);
};

function defaultData() {
    return {
        money: "--",
        loadingLottieStatus: "stop"
    };
}

const {moduleData: moduleData, moduleEvent: moduleEvent} = moduleDefine("result", defaultData, {
    onCreate: onCreate
});

function onCreate(param) {
    console.log("onCreate result" + param);
    const params = JSON.parse(param);
    moduleData.resultStr = params.resultStr;
    setTimeout((() => {
        moduleData.loadingLottieStatus = "play";
    }), 600);
}

moduleEvent.checkMyOrder = function() {
    openURL(`${commonData.h5Url}/${commonData.language}/otc-option/win/h5/order`);
    containerBack(-1);
};

moduleEvent.continueBuy = function() {
    containerBack();
};

function sendCommonConfig(param) {
    getCommonConfig(param);
}

requestAccountId();

$event.sendCommonConfig = sendCommonConfig;
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWFpbi5qcyIsInNvdXJjZXMiOlsiLi4vLi4vcmVwb3NpdG9yeS9ub2RlX21vZHVsZXMvYmlnLmpzL2JpZy5tanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9udW1iZXIuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9jb21tb24uanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9ndWlkZV9wb3AuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9ob21lLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvY3VzdG9tLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvY29pbmRldGFpbC5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL2ludHJvZHVjZS5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL3Byb2R1Y3RzdWIuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9yZXN1bHQuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9tYWluLmpzIl0sInNvdXJjZXNDb250ZW50IjpbIi8qXHJcbiAqICBiaWcuanMgdjUuMi4yXHJcbiAqICBBIHNtYWxsLCBmYXN0LCBlYXN5LXRvLXVzZSBsaWJyYXJ5IGZvciBhcmJpdHJhcnktcHJlY2lzaW9uIGRlY2ltYWwgYXJpdGhtZXRpYy5cclxuICogIENvcHlyaWdodCAoYykgMjAxOCBNaWNoYWVsIE1jbGF1Z2hsaW4gPE04Y2g4OGxAZ21haWwuY29tPlxyXG4gKiAgaHR0cHM6Ly9naXRodWIuY29tL01pa2VNY2wvYmlnLmpzL0xJQ0VOQ0VcclxuICovXHJcblxyXG5cclxuLyoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqIEVESVRBQkxFIERFRkFVTFRTICoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqL1xyXG5cclxuXHJcbiAgLy8gVGhlIGRlZmF1bHQgdmFsdWVzIGJlbG93IG11c3QgYmUgaW50ZWdlcnMgd2l0aGluIHRoZSBzdGF0ZWQgcmFuZ2VzLlxyXG5cclxuICAvKlxyXG4gICAqIFRoZSBtYXhpbXVtIG51bWJlciBvZiBkZWNpbWFsIHBsYWNlcyAoRFApIG9mIHRoZSByZXN1bHRzIG9mIG9wZXJhdGlvbnMgaW52b2x2aW5nIGRpdmlzaW9uOlxyXG4gICAqIGRpdiBhbmQgc3FydCwgYW5kIHBvdyB3aXRoIG5lZ2F0aXZlIGV4cG9uZW50cy5cclxuICAgKi9cclxudmFyIERQID0gMjAsICAgICAgICAgIC8vIDAgdG8gTUFYX0RQXHJcblxyXG4gIC8qXHJcbiAgICogVGhlIHJvdW5kaW5nIG1vZGUgKFJNKSB1c2VkIHdoZW4gcm91bmRpbmcgdG8gdGhlIGFib3ZlIGRlY2ltYWwgcGxhY2VzLlxyXG4gICAqXHJcbiAgICogIDAgIFRvd2FyZHMgemVybyAoaS5lLiB0cnVuY2F0ZSwgbm8gcm91bmRpbmcpLiAgICAgICAoUk9VTkRfRE9XTilcclxuICAgKiAgMSAgVG8gbmVhcmVzdCBuZWlnaGJvdXIuIElmIGVxdWlkaXN0YW50LCByb3VuZCB1cC4gIChST1VORF9IQUxGX1VQKVxyXG4gICAqICAyICBUbyBuZWFyZXN0IG5laWdoYm91ci4gSWYgZXF1aWRpc3RhbnQsIHRvIGV2ZW4uICAgKFJPVU5EX0hBTEZfRVZFTilcclxuICAgKiAgMyAgQXdheSBmcm9tIHplcm8uICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIChST1VORF9VUClcclxuICAgKi9cclxuICBSTSA9IDEsICAgICAgICAgICAgIC8vIDAsIDEsIDIgb3IgM1xyXG5cclxuICAvLyBUaGUgbWF4aW11bSB2YWx1ZSBvZiBEUCBhbmQgQmlnLkRQLlxyXG4gIE1BWF9EUCA9IDFFNiwgICAgICAgLy8gMCB0byAxMDAwMDAwXHJcblxyXG4gIC8vIFRoZSBtYXhpbXVtIG1hZ25pdHVkZSBvZiB0aGUgZXhwb25lbnQgYXJndW1lbnQgdG8gdGhlIHBvdyBtZXRob2QuXHJcbiAgTUFYX1BPV0VSID0gMUU2LCAgICAvLyAxIHRvIDEwMDAwMDBcclxuXHJcbiAgLypcclxuICAgKiBUaGUgbmVnYXRpdmUgZXhwb25lbnQgKE5FKSBhdCBhbmQgYmVuZWF0aCB3aGljaCB0b1N0cmluZyByZXR1cm5zIGV4cG9uZW50aWFsIG5vdGF0aW9uLlxyXG4gICAqIChKYXZhU2NyaXB0IG51bWJlcnM6IC03KVxyXG4gICAqIC0xMDAwMDAwIGlzIHRoZSBtaW5pbXVtIHJlY29tbWVuZGVkIGV4cG9uZW50IHZhbHVlIG9mIGEgQmlnLlxyXG4gICAqL1xyXG4gIE5FID0gLTcsICAgICAgICAgICAgLy8gMCB0byAtMTAwMDAwMFxyXG5cclxuICAvKlxyXG4gICAqIFRoZSBwb3NpdGl2ZSBleHBvbmVudCAoUEUpIGF0IGFuZCBhYm92ZSB3aGljaCB0b1N0cmluZyByZXR1cm5zIGV4cG9uZW50aWFsIG5vdGF0aW9uLlxyXG4gICAqIChKYXZhU2NyaXB0IG51bWJlcnM6IDIxKVxyXG4gICAqIDEwMDAwMDAgaXMgdGhlIG1heGltdW0gcmVjb21tZW5kZWQgZXhwb25lbnQgdmFsdWUgb2YgYSBCaWcuXHJcbiAgICogKFRoaXMgbGltaXQgaXMgbm90IGVuZm9yY2VkIG9yIGNoZWNrZWQuKVxyXG4gICAqL1xyXG4gIFBFID0gMjEsICAgICAgICAgICAgLy8gMCB0byAxMDAwMDAwXHJcblxyXG5cclxuLyoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqL1xyXG5cclxuXHJcbiAgLy8gRXJyb3IgbWVzc2FnZXMuXHJcbiAgTkFNRSA9ICdbYmlnLmpzXSAnLFxyXG4gIElOVkFMSUQgPSBOQU1FICsgJ0ludmFsaWQgJyxcclxuICBJTlZBTElEX0RQID0gSU5WQUxJRCArICdkZWNpbWFsIHBsYWNlcycsXHJcbiAgSU5WQUxJRF9STSA9IElOVkFMSUQgKyAncm91bmRpbmcgbW9kZScsXHJcbiAgRElWX0JZX1pFUk8gPSBOQU1FICsgJ0RpdmlzaW9uIGJ5IHplcm8nLFxyXG5cclxuICAvLyBUaGUgc2hhcmVkIHByb3RvdHlwZSBvYmplY3QuXHJcbiAgUCA9IHt9LFxyXG4gIFVOREVGSU5FRCA9IHZvaWQgMCxcclxuICBOVU1FUklDID0gL14tPyhcXGQrKFxcLlxcZCopP3xcXC5cXGQrKShlWystXT9cXGQrKT8kL2k7XHJcblxyXG5cclxuLypcclxuICogQ3JlYXRlIGFuZCByZXR1cm4gYSBCaWcgY29uc3RydWN0b3IuXHJcbiAqXHJcbiAqL1xyXG5mdW5jdGlvbiBfQmlnXygpIHtcclxuXHJcbiAgLypcclxuICAgKiBUaGUgQmlnIGNvbnN0cnVjdG9yIGFuZCBleHBvcnRlZCBmdW5jdGlvbi5cclxuICAgKiBDcmVhdGUgYW5kIHJldHVybiBhIG5ldyBpbnN0YW5jZSBvZiBhIEJpZyBudW1iZXIgb2JqZWN0LlxyXG4gICAqXHJcbiAgICogbiB7bnVtYmVyfHN0cmluZ3xCaWd9IEEgbnVtZXJpYyB2YWx1ZS5cclxuICAgKi9cclxuICBmdW5jdGlvbiBCaWcobikge1xyXG4gICAgdmFyIHggPSB0aGlzO1xyXG5cclxuICAgIC8vIEVuYWJsZSBjb25zdHJ1Y3RvciB1c2FnZSB3aXRob3V0IG5ldy5cclxuICAgIGlmICghKHggaW5zdGFuY2VvZiBCaWcpKSByZXR1cm4gbiA9PT0gVU5ERUZJTkVEID8gX0JpZ18oKSA6IG5ldyBCaWcobik7XHJcblxyXG4gICAgLy8gRHVwbGljYXRlLlxyXG4gICAgaWYgKG4gaW5zdGFuY2VvZiBCaWcpIHtcclxuICAgICAgeC5zID0gbi5zO1xyXG4gICAgICB4LmUgPSBuLmU7XHJcbiAgICAgIHguYyA9IG4uYy5zbGljZSgpO1xyXG4gICAgfSBlbHNlIHtcclxuICAgICAgcGFyc2UoeCwgbik7XHJcbiAgICB9XHJcblxyXG4gICAgLypcclxuICAgICAqIFJldGFpbiBhIHJlZmVyZW5jZSB0byB0aGlzIEJpZyBjb25zdHJ1Y3RvciwgYW5kIHNoYWRvdyBCaWcucHJvdG90eXBlLmNvbnN0cnVjdG9yIHdoaWNoXHJcbiAgICAgKiBwb2ludHMgdG8gT2JqZWN0LlxyXG4gICAgICovXHJcbiAgICB4LmNvbnN0cnVjdG9yID0gQmlnO1xyXG4gIH1cclxuXHJcbiAgQmlnLnByb3RvdHlwZSA9IFA7XHJcbiAgQmlnLkRQID0gRFA7XHJcbiAgQmlnLlJNID0gUk07XHJcbiAgQmlnLk5FID0gTkU7XHJcbiAgQmlnLlBFID0gUEU7XHJcbiAgQmlnLnZlcnNpb24gPSAnNS4yLjInO1xyXG5cclxuICByZXR1cm4gQmlnO1xyXG59XHJcblxyXG5cclxuLypcclxuICogUGFyc2UgdGhlIG51bWJlciBvciBzdHJpbmcgdmFsdWUgcGFzc2VkIHRvIGEgQmlnIGNvbnN0cnVjdG9yLlxyXG4gKlxyXG4gKiB4IHtCaWd9IEEgQmlnIG51bWJlciBpbnN0YW5jZS5cclxuICogbiB7bnVtYmVyfHN0cmluZ30gQSBudW1lcmljIHZhbHVlLlxyXG4gKi9cclxuZnVuY3Rpb24gcGFyc2UoeCwgbikge1xyXG4gIHZhciBlLCBpLCBubDtcclxuXHJcbiAgLy8gTWludXMgemVybz9cclxuICBpZiAobiA9PT0gMCAmJiAxIC8gbiA8IDApIG4gPSAnLTAnO1xyXG4gIGVsc2UgaWYgKCFOVU1FUklDLnRlc3QobiArPSAnJykpIHRocm93IEVycm9yKElOVkFMSUQgKyAnbnVtYmVyJyk7XHJcblxyXG4gIC8vIERldGVybWluZSBzaWduLlxyXG4gIHgucyA9IG4uY2hhckF0KDApID09ICctJyA/IChuID0gbi5zbGljZSgxKSwgLTEpIDogMTtcclxuXHJcbiAgLy8gRGVjaW1hbCBwb2ludD9cclxuICBpZiAoKGUgPSBuLmluZGV4T2YoJy4nKSkgPiAtMSkgbiA9IG4ucmVwbGFjZSgnLicsICcnKTtcclxuXHJcbiAgLy8gRXhwb25lbnRpYWwgZm9ybT9cclxuICBpZiAoKGkgPSBuLnNlYXJjaCgvZS9pKSkgPiAwKSB7XHJcblxyXG4gICAgLy8gRGV0ZXJtaW5lIGV4cG9uZW50LlxyXG4gICAgaWYgKGUgPCAwKSBlID0gaTtcclxuICAgIGUgKz0gK24uc2xpY2UoaSArIDEpO1xyXG4gICAgbiA9IG4uc3Vic3RyaW5nKDAsIGkpO1xyXG4gIH0gZWxzZSBpZiAoZSA8IDApIHtcclxuXHJcbiAgICAvLyBJbnRlZ2VyLlxyXG4gICAgZSA9IG4ubGVuZ3RoO1xyXG4gIH1cclxuXHJcbiAgbmwgPSBuLmxlbmd0aDtcclxuXHJcbiAgLy8gRGV0ZXJtaW5lIGxlYWRpbmcgemVyb3MuXHJcbiAgZm9yIChpID0gMDsgaSA8IG5sICYmIG4uY2hhckF0KGkpID09ICcwJzspICsraTtcclxuXHJcbiAgaWYgKGkgPT0gbmwpIHtcclxuXHJcbiAgICAvLyBaZXJvLlxyXG4gICAgeC5jID0gW3guZSA9IDBdO1xyXG4gIH0gZWxzZSB7XHJcblxyXG4gICAgLy8gRGV0ZXJtaW5lIHRyYWlsaW5nIHplcm9zLlxyXG4gICAgZm9yICg7IG5sID4gMCAmJiBuLmNoYXJBdCgtLW5sKSA9PSAnMCc7KTtcclxuICAgIHguZSA9IGUgLSBpIC0gMTtcclxuICAgIHguYyA9IFtdO1xyXG5cclxuICAgIC8vIENvbnZlcnQgc3RyaW5nIHRvIGFycmF5IG9mIGRpZ2l0cyB3aXRob3V0IGxlYWRpbmcvdHJhaWxpbmcgemVyb3MuXHJcbiAgICBmb3IgKGUgPSAwOyBpIDw9IG5sOykgeC5jW2UrK10gPSArbi5jaGFyQXQoaSsrKTtcclxuICB9XHJcblxyXG4gIHJldHVybiB4O1xyXG59XHJcblxyXG5cclxuLypcclxuICogUm91bmQgQmlnIHggdG8gYSBtYXhpbXVtIG9mIGRwIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgcm0uXHJcbiAqIENhbGxlZCBieSBzdHJpbmdpZnksIFAuZGl2LCBQLnJvdW5kIGFuZCBQLnNxcnQuXHJcbiAqXHJcbiAqIHgge0JpZ30gVGhlIEJpZyB0byByb3VuZC5cclxuICogZHAge251bWJlcn0gSW50ZWdlciwgMCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKiBybSB7bnVtYmVyfSAwLCAxLCAyIG9yIDMgKERPV04sIEhBTEZfVVAsIEhBTEZfRVZFTiwgVVApXHJcbiAqIFttb3JlXSB7Ym9vbGVhbn0gV2hldGhlciB0aGUgcmVzdWx0IG9mIGRpdmlzaW9uIHdhcyB0cnVuY2F0ZWQuXHJcbiAqL1xyXG5mdW5jdGlvbiByb3VuZCh4LCBkcCwgcm0sIG1vcmUpIHtcclxuICB2YXIgeGMgPSB4LmMsXHJcbiAgICBpID0geC5lICsgZHAgKyAxO1xyXG5cclxuICBpZiAoaSA8IHhjLmxlbmd0aCkge1xyXG4gICAgaWYgKHJtID09PSAxKSB7XHJcblxyXG4gICAgICAvLyB4Y1tpXSBpcyB0aGUgZGlnaXQgYWZ0ZXIgdGhlIGRpZ2l0IHRoYXQgbWF5IGJlIHJvdW5kZWQgdXAuXHJcbiAgICAgIG1vcmUgPSB4Y1tpXSA+PSA1O1xyXG4gICAgfSBlbHNlIGlmIChybSA9PT0gMikge1xyXG4gICAgICBtb3JlID0geGNbaV0gPiA1IHx8IHhjW2ldID09IDUgJiZcclxuICAgICAgICAobW9yZSB8fCBpIDwgMCB8fCB4Y1tpICsgMV0gIT09IFVOREVGSU5FRCB8fCB4Y1tpIC0gMV0gJiAxKTtcclxuICAgIH0gZWxzZSBpZiAocm0gPT09IDMpIHtcclxuICAgICAgbW9yZSA9IG1vcmUgfHwgISF4Y1swXTtcclxuICAgIH0gZWxzZSB7XHJcbiAgICAgIG1vcmUgPSBmYWxzZTtcclxuICAgICAgaWYgKHJtICE9PSAwKSB0aHJvdyBFcnJvcihJTlZBTElEX1JNKTtcclxuICAgIH1cclxuXHJcbiAgICBpZiAoaSA8IDEpIHtcclxuICAgICAgeGMubGVuZ3RoID0gMTtcclxuXHJcbiAgICAgIGlmIChtb3JlKSB7XHJcblxyXG4gICAgICAgIC8vIDEsIDAuMSwgMC4wMSwgMC4wMDEsIDAuMDAwMSBldGMuXHJcbiAgICAgICAgeC5lID0gLWRwO1xyXG4gICAgICAgIHhjWzBdID0gMTtcclxuICAgICAgfSBlbHNlIHtcclxuXHJcbiAgICAgICAgLy8gWmVyby5cclxuICAgICAgICB4Y1swXSA9IHguZSA9IDA7XHJcbiAgICAgIH1cclxuICAgIH0gZWxzZSB7XHJcblxyXG4gICAgICAvLyBSZW1vdmUgYW55IGRpZ2l0cyBhZnRlciB0aGUgcmVxdWlyZWQgZGVjaW1hbCBwbGFjZXMuXHJcbiAgICAgIHhjLmxlbmd0aCA9IGktLTtcclxuXHJcbiAgICAgIC8vIFJvdW5kIHVwP1xyXG4gICAgICBpZiAobW9yZSkge1xyXG5cclxuICAgICAgICAvLyBSb3VuZGluZyB1cCBtYXkgbWVhbiB0aGUgcHJldmlvdXMgZGlnaXQgaGFzIHRvIGJlIHJvdW5kZWQgdXAuXHJcbiAgICAgICAgZm9yICg7ICsreGNbaV0gPiA5Oykge1xyXG4gICAgICAgICAgeGNbaV0gPSAwO1xyXG4gICAgICAgICAgaWYgKCFpLS0pIHtcclxuICAgICAgICAgICAgKyt4LmU7XHJcbiAgICAgICAgICAgIHhjLnVuc2hpZnQoMSk7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgfVxyXG4gICAgICB9XHJcblxyXG4gICAgICAvLyBSZW1vdmUgdHJhaWxpbmcgemVyb3MuXHJcbiAgICAgIGZvciAoaSA9IHhjLmxlbmd0aDsgIXhjWy0taV07KSB4Yy5wb3AoKTtcclxuICAgIH1cclxuICB9IGVsc2UgaWYgKHJtIDwgMCB8fCBybSA+IDMgfHwgcm0gIT09IH5+cm0pIHtcclxuICAgIHRocm93IEVycm9yKElOVkFMSURfUk0pO1xyXG4gIH1cclxuXHJcbiAgcmV0dXJuIHg7XHJcbn1cclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBzdHJpbmcgcmVwcmVzZW50aW5nIHRoZSB2YWx1ZSBvZiBCaWcgeCBpbiBub3JtYWwgb3IgZXhwb25lbnRpYWwgbm90YXRpb24uXHJcbiAqIEhhbmRsZXMgUC50b0V4cG9uZW50aWFsLCBQLnRvRml4ZWQsIFAudG9KU09OLCBQLnRvUHJlY2lzaW9uLCBQLnRvU3RyaW5nIGFuZCBQLnZhbHVlT2YuXHJcbiAqXHJcbiAqIHgge0JpZ31cclxuICogaWQ/IHtudW1iZXJ9IENhbGxlciBpZC5cclxuICogICAgICAgICAxIHRvRXhwb25lbnRpYWxcclxuICogICAgICAgICAyIHRvRml4ZWRcclxuICogICAgICAgICAzIHRvUHJlY2lzaW9uXHJcbiAqICAgICAgICAgNCB2YWx1ZU9mXHJcbiAqIG4/IHtudW1iZXJ8dW5kZWZpbmVkfSBDYWxsZXIncyBhcmd1bWVudC5cclxuICogaz8ge251bWJlcnx1bmRlZmluZWR9XHJcbiAqL1xyXG5mdW5jdGlvbiBzdHJpbmdpZnkoeCwgaWQsIG4sIGspIHtcclxuICB2YXIgZSwgcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICB6ID0gIXguY1swXTtcclxuXHJcbiAgaWYgKG4gIT09IFVOREVGSU5FRCkge1xyXG4gICAgaWYgKG4gIT09IH5+biB8fCBuIDwgKGlkID09IDMpIHx8IG4gPiBNQVhfRFApIHtcclxuICAgICAgdGhyb3cgRXJyb3IoaWQgPT0gMyA/IElOVkFMSUQgKyAncHJlY2lzaW9uJyA6IElOVkFMSURfRFApO1xyXG4gICAgfVxyXG5cclxuICAgIHggPSBuZXcgQmlnKHgpO1xyXG5cclxuICAgIC8vIFRoZSBpbmRleCBvZiB0aGUgZGlnaXQgdGhhdCBtYXkgYmUgcm91bmRlZCB1cC5cclxuICAgIG4gPSBrIC0geC5lO1xyXG5cclxuICAgIC8vIFJvdW5kP1xyXG4gICAgaWYgKHguYy5sZW5ndGggPiArK2spIHJvdW5kKHgsIG4sIEJpZy5STSk7XHJcblxyXG4gICAgLy8gdG9GaXhlZDogcmVjYWxjdWxhdGUgayBhcyB4LmUgbWF5IGhhdmUgY2hhbmdlZCBpZiB2YWx1ZSByb3VuZGVkIHVwLlxyXG4gICAgaWYgKGlkID09IDIpIGsgPSB4LmUgKyBuICsgMTtcclxuXHJcbiAgICAvLyBBcHBlbmQgemVyb3M/XHJcbiAgICBmb3IgKDsgeC5jLmxlbmd0aCA8IGs7KSB4LmMucHVzaCgwKTtcclxuICB9XHJcblxyXG4gIGUgPSB4LmU7XHJcbiAgcyA9IHguYy5qb2luKCcnKTtcclxuICBuID0gcy5sZW5ndGg7XHJcblxyXG4gIC8vIEV4cG9uZW50aWFsIG5vdGF0aW9uP1xyXG4gIGlmIChpZCAhPSAyICYmIChpZCA9PSAxIHx8IGlkID09IDMgJiYgayA8PSBlIHx8IGUgPD0gQmlnLk5FIHx8IGUgPj0gQmlnLlBFKSkge1xyXG4gICAgcyA9IHMuY2hhckF0KDApICsgKG4gPiAxID8gJy4nICsgcy5zbGljZSgxKSA6ICcnKSArIChlIDwgMCA/ICdlJyA6ICdlKycpICsgZTtcclxuXHJcbiAgLy8gTm9ybWFsIG5vdGF0aW9uLlxyXG4gIH0gZWxzZSBpZiAoZSA8IDApIHtcclxuICAgIGZvciAoOyArK2U7KSBzID0gJzAnICsgcztcclxuICAgIHMgPSAnMC4nICsgcztcclxuICB9IGVsc2UgaWYgKGUgPiAwKSB7XHJcbiAgICBpZiAoKytlID4gbikgZm9yIChlIC09IG47IGUtLTspIHMgKz0gJzAnO1xyXG4gICAgZWxzZSBpZiAoZSA8IG4pIHMgPSBzLnNsaWNlKDAsIGUpICsgJy4nICsgcy5zbGljZShlKTtcclxuICB9IGVsc2UgaWYgKG4gPiAxKSB7XHJcbiAgICBzID0gcy5jaGFyQXQoMCkgKyAnLicgKyBzLnNsaWNlKDEpO1xyXG4gIH1cclxuXHJcbiAgcmV0dXJuIHgucyA8IDAgJiYgKCF6IHx8IGlkID09IDQpID8gJy0nICsgcyA6IHM7XHJcbn1cclxuXHJcblxyXG4vLyBQcm90b3R5cGUvaW5zdGFuY2UgbWV0aG9kc1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIGFic29sdXRlIHZhbHVlIG9mIHRoaXMgQmlnLlxyXG4gKi9cclxuUC5hYnMgPSBmdW5jdGlvbiAoKSB7XHJcbiAgdmFyIHggPSBuZXcgdGhpcy5jb25zdHJ1Y3Rvcih0aGlzKTtcclxuICB4LnMgPSAxO1xyXG4gIHJldHVybiB4O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiAxIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBncmVhdGVyIHRoYW4gdGhlIHZhbHVlIG9mIEJpZyB5LFxyXG4gKiAgICAgICAtMSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgbGVzcyB0aGFuIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3JcclxuICogICAgICAgIDAgaWYgdGhleSBoYXZlIHRoZSBzYW1lIHZhbHVlLlxyXG4qL1xyXG5QLmNtcCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIGlzbmVnLFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICB4YyA9IHguYyxcclxuICAgIHljID0gKHkgPSBuZXcgeC5jb25zdHJ1Y3Rvcih5KSkuYyxcclxuICAgIGkgPSB4LnMsXHJcbiAgICBqID0geS5zLFxyXG4gICAgayA9IHguZSxcclxuICAgIGwgPSB5LmU7XHJcblxyXG4gIC8vIEVpdGhlciB6ZXJvP1xyXG4gIGlmICgheGNbMF0gfHwgIXljWzBdKSByZXR1cm4gIXhjWzBdID8gIXljWzBdID8gMCA6IC1qIDogaTtcclxuXHJcbiAgLy8gU2lnbnMgZGlmZmVyP1xyXG4gIGlmIChpICE9IGopIHJldHVybiBpO1xyXG5cclxuICBpc25lZyA9IGkgPCAwO1xyXG5cclxuICAvLyBDb21wYXJlIGV4cG9uZW50cy5cclxuICBpZiAoayAhPSBsKSByZXR1cm4gayA+IGwgXiBpc25lZyA/IDEgOiAtMTtcclxuXHJcbiAgaiA9IChrID0geGMubGVuZ3RoKSA8IChsID0geWMubGVuZ3RoKSA/IGsgOiBsO1xyXG5cclxuICAvLyBDb21wYXJlIGRpZ2l0IGJ5IGRpZ2l0LlxyXG4gIGZvciAoaSA9IC0xOyArK2kgPCBqOykge1xyXG4gICAgaWYgKHhjW2ldICE9IHljW2ldKSByZXR1cm4geGNbaV0gPiB5Y1tpXSBeIGlzbmVnID8gMSA6IC0xO1xyXG4gIH1cclxuXHJcbiAgLy8gQ29tcGFyZSBsZW5ndGhzLlxyXG4gIHJldHVybiBrID09IGwgPyAwIDogayA+IGwgXiBpc25lZyA/IDEgOiAtMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBkaXZpZGVkIGJ5IHRoZSB2YWx1ZSBvZiBCaWcgeSwgcm91bmRlZCxcclxuICogaWYgbmVjZXNzYXJ5LCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgQmlnLlJNLlxyXG4gKi9cclxuUC5kaXYgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5jLCAgICAgICAgICAgICAgICAgIC8vIGRpdmlkZW5kXHJcbiAgICBiID0gKHkgPSBuZXcgQmlnKHkpKS5jLCAgIC8vIGRpdmlzb3JcclxuICAgIGsgPSB4LnMgPT0geS5zID8gMSA6IC0xLFxyXG4gICAgZHAgPSBCaWcuRFA7XHJcblxyXG4gIGlmIChkcCAhPT0gfn5kcCB8fCBkcCA8IDAgfHwgZHAgPiBNQVhfRFApIHRocm93IEVycm9yKElOVkFMSURfRFApO1xyXG5cclxuICAvLyBEaXZpc29yIGlzIHplcm8/XHJcbiAgaWYgKCFiWzBdKSB0aHJvdyBFcnJvcihESVZfQllfWkVSTyk7XHJcblxyXG4gIC8vIERpdmlkZW5kIGlzIDA/IFJldHVybiArLTAuXHJcbiAgaWYgKCFhWzBdKSByZXR1cm4gbmV3IEJpZyhrICogMCk7XHJcblxyXG4gIHZhciBibCwgYnQsIG4sIGNtcCwgcmksXHJcbiAgICBieiA9IGIuc2xpY2UoKSxcclxuICAgIGFpID0gYmwgPSBiLmxlbmd0aCxcclxuICAgIGFsID0gYS5sZW5ndGgsXHJcbiAgICByID0gYS5zbGljZSgwLCBibCksICAgLy8gcmVtYWluZGVyXHJcbiAgICBybCA9IHIubGVuZ3RoLFxyXG4gICAgcSA9IHksICAgICAgICAgICAgICAgIC8vIHF1b3RpZW50XHJcbiAgICBxYyA9IHEuYyA9IFtdLFxyXG4gICAgcWkgPSAwLFxyXG4gICAgZCA9IGRwICsgKHEuZSA9IHguZSAtIHkuZSkgKyAxOyAgICAvLyBudW1iZXIgb2YgZGlnaXRzIG9mIHRoZSByZXN1bHRcclxuXHJcbiAgcS5zID0gaztcclxuICBrID0gZCA8IDAgPyAwIDogZDtcclxuXHJcbiAgLy8gQ3JlYXRlIHZlcnNpb24gb2YgZGl2aXNvciB3aXRoIGxlYWRpbmcgemVyby5cclxuICBiei51bnNoaWZ0KDApO1xyXG5cclxuICAvLyBBZGQgemVyb3MgdG8gbWFrZSByZW1haW5kZXIgYXMgbG9uZyBhcyBkaXZpc29yLlxyXG4gIGZvciAoOyBybCsrIDwgYmw7KSByLnB1c2goMCk7XHJcblxyXG4gIGRvIHtcclxuXHJcbiAgICAvLyBuIGlzIGhvdyBtYW55IHRpbWVzIHRoZSBkaXZpc29yIGdvZXMgaW50byBjdXJyZW50IHJlbWFpbmRlci5cclxuICAgIGZvciAobiA9IDA7IG4gPCAxMDsgbisrKSB7XHJcblxyXG4gICAgICAvLyBDb21wYXJlIGRpdmlzb3IgYW5kIHJlbWFpbmRlci5cclxuICAgICAgaWYgKGJsICE9IChybCA9IHIubGVuZ3RoKSkge1xyXG4gICAgICAgIGNtcCA9IGJsID4gcmwgPyAxIDogLTE7XHJcbiAgICAgIH0gZWxzZSB7XHJcbiAgICAgICAgZm9yIChyaSA9IC0xLCBjbXAgPSAwOyArK3JpIDwgYmw7KSB7XHJcbiAgICAgICAgICBpZiAoYltyaV0gIT0gcltyaV0pIHtcclxuICAgICAgICAgICAgY21wID0gYltyaV0gPiByW3JpXSA/IDEgOiAtMTtcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgfVxyXG4gICAgICB9XHJcblxyXG4gICAgICAvLyBJZiBkaXZpc29yIDwgcmVtYWluZGVyLCBzdWJ0cmFjdCBkaXZpc29yIGZyb20gcmVtYWluZGVyLlxyXG4gICAgICBpZiAoY21wIDwgMCkge1xyXG5cclxuICAgICAgICAvLyBSZW1haW5kZXIgY2FuJ3QgYmUgbW9yZSB0aGFuIDEgZGlnaXQgbG9uZ2VyIHRoYW4gZGl2aXNvci5cclxuICAgICAgICAvLyBFcXVhbGlzZSBsZW5ndGhzIHVzaW5nIGRpdmlzb3Igd2l0aCBleHRyYSBsZWFkaW5nIHplcm8/XHJcbiAgICAgICAgZm9yIChidCA9IHJsID09IGJsID8gYiA6IGJ6OyBybDspIHtcclxuICAgICAgICAgIGlmIChyWy0tcmxdIDwgYnRbcmxdKSB7XHJcbiAgICAgICAgICAgIHJpID0gcmw7XHJcbiAgICAgICAgICAgIGZvciAoOyByaSAmJiAhclstLXJpXTspIHJbcmldID0gOTtcclxuICAgICAgICAgICAgLS1yW3JpXTtcclxuICAgICAgICAgICAgcltybF0gKz0gMTA7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgICByW3JsXSAtPSBidFtybF07XHJcbiAgICAgICAgfVxyXG5cclxuICAgICAgICBmb3IgKDsgIXJbMF07KSByLnNoaWZ0KCk7XHJcbiAgICAgIH0gZWxzZSB7XHJcbiAgICAgICAgYnJlYWs7XHJcbiAgICAgIH1cclxuICAgIH1cclxuXHJcbiAgICAvLyBBZGQgdGhlIGRpZ2l0IG4gdG8gdGhlIHJlc3VsdCBhcnJheS5cclxuICAgIHFjW3FpKytdID0gY21wID8gbiA6ICsrbjtcclxuXHJcbiAgICAvLyBVcGRhdGUgdGhlIHJlbWFpbmRlci5cclxuICAgIGlmIChyWzBdICYmIGNtcCkgcltybF0gPSBhW2FpXSB8fCAwO1xyXG4gICAgZWxzZSByID0gW2FbYWldXTtcclxuXHJcbiAgfSB3aGlsZSAoKGFpKysgPCBhbCB8fCByWzBdICE9PSBVTkRFRklORUQpICYmIGstLSk7XHJcblxyXG4gIC8vIExlYWRpbmcgemVybz8gRG8gbm90IHJlbW92ZSBpZiByZXN1bHQgaXMgc2ltcGx5IHplcm8gKHFpID09IDEpLlxyXG4gIGlmICghcWNbMF0gJiYgcWkgIT0gMSkge1xyXG5cclxuICAgIC8vIFRoZXJlIGNhbid0IGJlIG1vcmUgdGhhbiBvbmUgemVyby5cclxuICAgIHFjLnNoaWZ0KCk7XHJcbiAgICBxLmUtLTtcclxuICB9XHJcblxyXG4gIC8vIFJvdW5kP1xyXG4gIGlmIChxaSA+IGQpIHJvdW5kKHEsIGRwLCBCaWcuUk0sIHJbMF0gIT09IFVOREVGSU5FRCk7XHJcblxyXG4gIHJldHVybiBxO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiB0cnVlIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBlcXVhbCB0byB0aGUgdmFsdWUgb2YgQmlnIHksIG90aGVyd2lzZSByZXR1cm4gZmFsc2UuXHJcbiAqL1xyXG5QLmVxID0gZnVuY3Rpb24gKHkpIHtcclxuICByZXR1cm4gIXRoaXMuY21wKHkpO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiB0cnVlIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBncmVhdGVyIHRoYW4gdGhlIHZhbHVlIG9mIEJpZyB5LCBvdGhlcndpc2UgcmV0dXJuXHJcbiAqIGZhbHNlLlxyXG4gKi9cclxuUC5ndCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgcmV0dXJuIHRoaXMuY21wKHkpID4gMDtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gdHJ1ZSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgZ3JlYXRlciB0aGFuIG9yIGVxdWFsIHRvIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3RoZXJ3aXNlXHJcbiAqIHJldHVybiBmYWxzZS5cclxuICovXHJcblAuZ3RlID0gZnVuY3Rpb24gKHkpIHtcclxuICByZXR1cm4gdGhpcy5jbXAoeSkgPiAtMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gdHJ1ZSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgbGVzcyB0aGFuIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3RoZXJ3aXNlIHJldHVybiBmYWxzZS5cclxuICovXHJcblAubHQgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHJldHVybiB0aGlzLmNtcCh5KSA8IDA7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIHRydWUgaWYgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGlzIGxlc3MgdGhhbiBvciBlcXVhbCB0byB0aGUgdmFsdWUgb2YgQmlnIHksIG90aGVyd2lzZVxyXG4gKiByZXR1cm4gZmFsc2UuXHJcbiAqL1xyXG5QLmx0ZSA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgcmV0dXJuIHRoaXMuY21wKHkpIDwgMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBtaW51cyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLm1pbnVzID0gUC5zdWIgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciBpLCBqLCB0LCB4bHR5LFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgYSA9IHgucyxcclxuICAgIGIgPSAoeSA9IG5ldyBCaWcoeSkpLnM7XHJcblxyXG4gIC8vIFNpZ25zIGRpZmZlcj9cclxuICBpZiAoYSAhPSBiKSB7XHJcbiAgICB5LnMgPSAtYjtcclxuICAgIHJldHVybiB4LnBsdXMoeSk7XHJcbiAgfVxyXG5cclxuICB2YXIgeGMgPSB4LmMuc2xpY2UoKSxcclxuICAgIHhlID0geC5lLFxyXG4gICAgeWMgPSB5LmMsXHJcbiAgICB5ZSA9IHkuZTtcclxuXHJcbiAgLy8gRWl0aGVyIHplcm8/XHJcbiAgaWYgKCF4Y1swXSB8fCAheWNbMF0pIHtcclxuXHJcbiAgICAvLyB5IGlzIG5vbi16ZXJvPyB4IGlzIG5vbi16ZXJvPyBPciBib3RoIGFyZSB6ZXJvLlxyXG4gICAgcmV0dXJuIHljWzBdID8gKHkucyA9IC1iLCB5KSA6IG5ldyBCaWcoeGNbMF0gPyB4IDogMCk7XHJcbiAgfVxyXG5cclxuICAvLyBEZXRlcm1pbmUgd2hpY2ggaXMgdGhlIGJpZ2dlciBudW1iZXIuIFByZXBlbmQgemVyb3MgdG8gZXF1YWxpc2UgZXhwb25lbnRzLlxyXG4gIGlmIChhID0geGUgLSB5ZSkge1xyXG5cclxuICAgIGlmICh4bHR5ID0gYSA8IDApIHtcclxuICAgICAgYSA9IC1hO1xyXG4gICAgICB0ID0geGM7XHJcbiAgICB9IGVsc2Uge1xyXG4gICAgICB5ZSA9IHhlO1xyXG4gICAgICB0ID0geWM7XHJcbiAgICB9XHJcblxyXG4gICAgdC5yZXZlcnNlKCk7XHJcbiAgICBmb3IgKGIgPSBhOyBiLS07KSB0LnB1c2goMCk7XHJcbiAgICB0LnJldmVyc2UoKTtcclxuICB9IGVsc2Uge1xyXG5cclxuICAgIC8vIEV4cG9uZW50cyBlcXVhbC4gQ2hlY2sgZGlnaXQgYnkgZGlnaXQuXHJcbiAgICBqID0gKCh4bHR5ID0geGMubGVuZ3RoIDwgeWMubGVuZ3RoKSA/IHhjIDogeWMpLmxlbmd0aDtcclxuXHJcbiAgICBmb3IgKGEgPSBiID0gMDsgYiA8IGo7IGIrKykge1xyXG4gICAgICBpZiAoeGNbYl0gIT0geWNbYl0pIHtcclxuICAgICAgICB4bHR5ID0geGNbYl0gPCB5Y1tiXTtcclxuICAgICAgICBicmVhaztcclxuICAgICAgfVxyXG4gICAgfVxyXG4gIH1cclxuXHJcbiAgLy8geCA8IHk/IFBvaW50IHhjIHRvIHRoZSBhcnJheSBvZiB0aGUgYmlnZ2VyIG51bWJlci5cclxuICBpZiAoeGx0eSkge1xyXG4gICAgdCA9IHhjO1xyXG4gICAgeGMgPSB5YztcclxuICAgIHljID0gdDtcclxuICAgIHkucyA9IC15LnM7XHJcbiAgfVxyXG5cclxuICAvKlxyXG4gICAqIEFwcGVuZCB6ZXJvcyB0byB4YyBpZiBzaG9ydGVyLiBObyBuZWVkIHRvIGFkZCB6ZXJvcyB0byB5YyBpZiBzaG9ydGVyIGFzIHN1YnRyYWN0aW9uIG9ubHlcclxuICAgKiBuZWVkcyB0byBzdGFydCBhdCB5Yy5sZW5ndGguXHJcbiAgICovXHJcbiAgaWYgKChiID0gKGogPSB5Yy5sZW5ndGgpIC0gKGkgPSB4Yy5sZW5ndGgpKSA+IDApIGZvciAoOyBiLS07KSB4Y1tpKytdID0gMDtcclxuXHJcbiAgLy8gU3VidHJhY3QgeWMgZnJvbSB4Yy5cclxuICBmb3IgKGIgPSBpOyBqID4gYTspIHtcclxuICAgIGlmICh4Y1stLWpdIDwgeWNbal0pIHtcclxuICAgICAgZm9yIChpID0gajsgaSAmJiAheGNbLS1pXTspIHhjW2ldID0gOTtcclxuICAgICAgLS14Y1tpXTtcclxuICAgICAgeGNbal0gKz0gMTA7XHJcbiAgICB9XHJcblxyXG4gICAgeGNbal0gLT0geWNbal07XHJcbiAgfVxyXG5cclxuICAvLyBSZW1vdmUgdHJhaWxpbmcgemVyb3MuXHJcbiAgZm9yICg7IHhjWy0tYl0gPT09IDA7KSB4Yy5wb3AoKTtcclxuXHJcbiAgLy8gUmVtb3ZlIGxlYWRpbmcgemVyb3MgYW5kIGFkanVzdCBleHBvbmVudCBhY2NvcmRpbmdseS5cclxuICBmb3IgKDsgeGNbMF0gPT09IDA7KSB7XHJcbiAgICB4Yy5zaGlmdCgpO1xyXG4gICAgLS15ZTtcclxuICB9XHJcblxyXG4gIGlmICgheGNbMF0pIHtcclxuXHJcbiAgICAvLyBuIC0gbiA9ICswXHJcbiAgICB5LnMgPSAxO1xyXG5cclxuICAgIC8vIFJlc3VsdCBtdXN0IGJlIHplcm8uXHJcbiAgICB4YyA9IFt5ZSA9IDBdO1xyXG4gIH1cclxuXHJcbiAgeS5jID0geGM7XHJcbiAgeS5lID0geWU7XHJcblxyXG4gIHJldHVybiB5O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIG1vZHVsbyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLm1vZCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIHlndHgsXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5zLFxyXG4gICAgYiA9ICh5ID0gbmV3IEJpZyh5KSkucztcclxuXHJcbiAgaWYgKCF5LmNbMF0pIHRocm93IEVycm9yKERJVl9CWV9aRVJPKTtcclxuXHJcbiAgeC5zID0geS5zID0gMTtcclxuICB5Z3R4ID0geS5jbXAoeCkgPT0gMTtcclxuICB4LnMgPSBhO1xyXG4gIHkucyA9IGI7XHJcblxyXG4gIGlmICh5Z3R4KSByZXR1cm4gbmV3IEJpZyh4KTtcclxuXHJcbiAgYSA9IEJpZy5EUDtcclxuICBiID0gQmlnLlJNO1xyXG4gIEJpZy5EUCA9IEJpZy5STSA9IDA7XHJcbiAgeCA9IHguZGl2KHkpO1xyXG4gIEJpZy5EUCA9IGE7XHJcbiAgQmlnLlJNID0gYjtcclxuXHJcbiAgcmV0dXJuIHRoaXMubWludXMoeC50aW1lcyh5KSk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgbmV3IEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgcGx1cyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLnBsdXMgPSBQLmFkZCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIHQsXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5zLFxyXG4gICAgYiA9ICh5ID0gbmV3IEJpZyh5KSkucztcclxuXHJcbiAgLy8gU2lnbnMgZGlmZmVyP1xyXG4gIGlmIChhICE9IGIpIHtcclxuICAgIHkucyA9IC1iO1xyXG4gICAgcmV0dXJuIHgubWludXMoeSk7XHJcbiAgfVxyXG5cclxuICB2YXIgeGUgPSB4LmUsXHJcbiAgICB4YyA9IHguYyxcclxuICAgIHllID0geS5lLFxyXG4gICAgeWMgPSB5LmM7XHJcblxyXG4gIC8vIEVpdGhlciB6ZXJvPyB5IGlzIG5vbi16ZXJvPyB4IGlzIG5vbi16ZXJvPyBPciBib3RoIGFyZSB6ZXJvLlxyXG4gIGlmICgheGNbMF0gfHwgIXljWzBdKSByZXR1cm4geWNbMF0gPyB5IDogbmV3IEJpZyh4Y1swXSA/IHggOiBhICogMCk7XHJcblxyXG4gIHhjID0geGMuc2xpY2UoKTtcclxuXHJcbiAgLy8gUHJlcGVuZCB6ZXJvcyB0byBlcXVhbGlzZSBleHBvbmVudHMuXHJcbiAgLy8gTm90ZTogcmV2ZXJzZSBmYXN0ZXIgdGhhbiB1bnNoaWZ0cy5cclxuICBpZiAoYSA9IHhlIC0geWUpIHtcclxuICAgIGlmIChhID4gMCkge1xyXG4gICAgICB5ZSA9IHhlO1xyXG4gICAgICB0ID0geWM7XHJcbiAgICB9IGVsc2Uge1xyXG4gICAgICBhID0gLWE7XHJcbiAgICAgIHQgPSB4YztcclxuICAgIH1cclxuXHJcbiAgICB0LnJldmVyc2UoKTtcclxuICAgIGZvciAoOyBhLS07KSB0LnB1c2goMCk7XHJcbiAgICB0LnJldmVyc2UoKTtcclxuICB9XHJcblxyXG4gIC8vIFBvaW50IHhjIHRvIHRoZSBsb25nZXIgYXJyYXkuXHJcbiAgaWYgKHhjLmxlbmd0aCAtIHljLmxlbmd0aCA8IDApIHtcclxuICAgIHQgPSB5YztcclxuICAgIHljID0geGM7XHJcbiAgICB4YyA9IHQ7XHJcbiAgfVxyXG5cclxuICBhID0geWMubGVuZ3RoO1xyXG5cclxuICAvLyBPbmx5IHN0YXJ0IGFkZGluZyBhdCB5Yy5sZW5ndGggLSAxIGFzIHRoZSBmdXJ0aGVyIGRpZ2l0cyBvZiB4YyBjYW4gYmUgbGVmdCBhcyB0aGV5IGFyZS5cclxuICBmb3IgKGIgPSAwOyBhOyB4Y1thXSAlPSAxMCkgYiA9ICh4Y1stLWFdID0geGNbYV0gKyB5Y1thXSArIGIpIC8gMTAgfCAwO1xyXG5cclxuICAvLyBObyBuZWVkIHRvIGNoZWNrIGZvciB6ZXJvLCBhcyAreCArICt5ICE9IDAgJiYgLXggKyAteSAhPSAwXHJcblxyXG4gIGlmIChiKSB7XHJcbiAgICB4Yy51bnNoaWZ0KGIpO1xyXG4gICAgKyt5ZTtcclxuICB9XHJcblxyXG4gIC8vIFJlbW92ZSB0cmFpbGluZyB6ZXJvcy5cclxuICBmb3IgKGEgPSB4Yy5sZW5ndGg7IHhjWy0tYV0gPT09IDA7KSB4Yy5wb3AoKTtcclxuXHJcbiAgeS5jID0geGM7XHJcbiAgeS5lID0geWU7XHJcblxyXG4gIHJldHVybiB5O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgcmFpc2VkIHRvIHRoZSBwb3dlciBuLlxyXG4gKiBJZiBuIGlzIG5lZ2F0aXZlLCByb3VuZCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nXHJcbiAqIG1vZGUgQmlnLlJNLlxyXG4gKlxyXG4gKiBuIHtudW1iZXJ9IEludGVnZXIsIC1NQVhfUE9XRVIgdG8gTUFYX1BPV0VSIGluY2x1c2l2ZS5cclxuICovXHJcblAucG93ID0gZnVuY3Rpb24gKG4pIHtcclxuICB2YXIgeCA9IHRoaXMsXHJcbiAgICBvbmUgPSBuZXcgeC5jb25zdHJ1Y3RvcigxKSxcclxuICAgIHkgPSBvbmUsXHJcbiAgICBpc25lZyA9IG4gPCAwO1xyXG5cclxuICBpZiAobiAhPT0gfn5uIHx8IG4gPCAtTUFYX1BPV0VSIHx8IG4gPiBNQVhfUE9XRVIpIHRocm93IEVycm9yKElOVkFMSUQgKyAnZXhwb25lbnQnKTtcclxuICBpZiAoaXNuZWcpIG4gPSAtbjtcclxuXHJcbiAgZm9yICg7Oykge1xyXG4gICAgaWYgKG4gJiAxKSB5ID0geS50aW1lcyh4KTtcclxuICAgIG4gPj49IDE7XHJcbiAgICBpZiAoIW4pIGJyZWFrO1xyXG4gICAgeCA9IHgudGltZXMoeCk7XHJcbiAgfVxyXG5cclxuICByZXR1cm4gaXNuZWcgPyBvbmUuZGl2KHkpIDogeTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyByb3VuZGVkIHVzaW5nIHJvdW5kaW5nIG1vZGUgcm1cclxuICogdG8gYSBtYXhpbXVtIG9mIGRwIGRlY2ltYWwgcGxhY2VzLCBvciwgaWYgZHAgaXMgbmVnYXRpdmUsIHRvIGFuIGludGVnZXIgd2hpY2ggaXMgYVxyXG4gKiBtdWx0aXBsZSBvZiAxMCoqLWRwLlxyXG4gKiBJZiBkcCBpcyBub3Qgc3BlY2lmaWVkLCByb3VuZCB0byAwIGRlY2ltYWwgcGxhY2VzLlxyXG4gKiBJZiBybSBpcyBub3Qgc3BlY2lmaWVkLCB1c2UgQmlnLlJNLlxyXG4gKlxyXG4gKiBkcD8ge251bWJlcn0gSW50ZWdlciwgLU1BWF9EUCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKiBybT8gMCwgMSwgMiBvciAzIChST1VORF9ET1dOLCBST1VORF9IQUxGX1VQLCBST1VORF9IQUxGX0VWRU4sIFJPVU5EX1VQKVxyXG4gKi9cclxuUC5yb3VuZCA9IGZ1bmN0aW9uIChkcCwgcm0pIHtcclxuICB2YXIgQmlnID0gdGhpcy5jb25zdHJ1Y3RvcjtcclxuICBpZiAoZHAgPT09IFVOREVGSU5FRCkgZHAgPSAwO1xyXG4gIGVsc2UgaWYgKGRwICE9PSB+fmRwIHx8IGRwIDwgLU1BWF9EUCB8fCBkcCA+IE1BWF9EUCkgdGhyb3cgRXJyb3IoSU5WQUxJRF9EUCk7XHJcbiAgcmV0dXJuIHJvdW5kKG5ldyBCaWcodGhpcyksIGRwLCBybSA9PT0gVU5ERUZJTkVEID8gQmlnLlJNIDogcm0pO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHNxdWFyZSByb290IG9mIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZywgcm91bmRlZCwgaWZcclxuICogbmVjZXNzYXJ5LCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgQmlnLlJNLlxyXG4gKi9cclxuUC5zcXJ0ID0gZnVuY3Rpb24gKCkge1xyXG4gIHZhciByLCBjLCB0LFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgcyA9IHgucyxcclxuICAgIGUgPSB4LmUsXHJcbiAgICBoYWxmID0gbmV3IEJpZygwLjUpO1xyXG5cclxuICAvLyBaZXJvP1xyXG4gIGlmICgheC5jWzBdKSByZXR1cm4gbmV3IEJpZyh4KTtcclxuXHJcbiAgLy8gTmVnYXRpdmU/XHJcbiAgaWYgKHMgPCAwKSB0aHJvdyBFcnJvcihOQU1FICsgJ05vIHNxdWFyZSByb290Jyk7XHJcblxyXG4gIC8vIEVzdGltYXRlLlxyXG4gIHMgPSBNYXRoLnNxcnQoeCArICcnKTtcclxuXHJcbiAgLy8gTWF0aC5zcXJ0IHVuZGVyZmxvdy9vdmVyZmxvdz9cclxuICAvLyBSZS1lc3RpbWF0ZTogcGFzcyB4IGNvZWZmaWNpZW50IHRvIE1hdGguc3FydCBhcyBpbnRlZ2VyLCB0aGVuIGFkanVzdCB0aGUgcmVzdWx0IGV4cG9uZW50LlxyXG4gIGlmIChzID09PSAwIHx8IHMgPT09IDEgLyAwKSB7XHJcbiAgICBjID0geC5jLmpvaW4oJycpO1xyXG4gICAgaWYgKCEoYy5sZW5ndGggKyBlICYgMSkpIGMgKz0gJzAnO1xyXG4gICAgcyA9IE1hdGguc3FydChjKTtcclxuICAgIGUgPSAoKGUgKyAxKSAvIDIgfCAwKSAtIChlIDwgMCB8fCBlICYgMSk7XHJcbiAgICByID0gbmV3IEJpZygocyA9PSAxIC8gMCA/ICcxZScgOiAocyA9IHMudG9FeHBvbmVudGlhbCgpKS5zbGljZSgwLCBzLmluZGV4T2YoJ2UnKSArIDEpKSArIGUpO1xyXG4gIH0gZWxzZSB7XHJcbiAgICByID0gbmV3IEJpZyhzKTtcclxuICB9XHJcblxyXG4gIGUgPSByLmUgKyAoQmlnLkRQICs9IDQpO1xyXG5cclxuICAvLyBOZXd0b24tUmFwaHNvbiBpdGVyYXRpb24uXHJcbiAgZG8ge1xyXG4gICAgdCA9IHI7XHJcbiAgICByID0gaGFsZi50aW1lcyh0LnBsdXMoeC5kaXYodCkpKTtcclxuICB9IHdoaWxlICh0LmMuc2xpY2UoMCwgZSkuam9pbignJykgIT09IHIuYy5zbGljZSgwLCBlKS5qb2luKCcnKSk7XHJcblxyXG4gIHJldHVybiByb3VuZChyLCBCaWcuRFAgLT0gNCwgQmlnLlJNKTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyB0aW1lcyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLnRpbWVzID0gUC5tdWwgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciBjLFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgeGMgPSB4LmMsXHJcbiAgICB5YyA9ICh5ID0gbmV3IEJpZyh5KSkuYyxcclxuICAgIGEgPSB4Yy5sZW5ndGgsXHJcbiAgICBiID0geWMubGVuZ3RoLFxyXG4gICAgaSA9IHguZSxcclxuICAgIGogPSB5LmU7XHJcblxyXG4gIC8vIERldGVybWluZSBzaWduIG9mIHJlc3VsdC5cclxuICB5LnMgPSB4LnMgPT0geS5zID8gMSA6IC0xO1xyXG5cclxuICAvLyBSZXR1cm4gc2lnbmVkIDAgaWYgZWl0aGVyIDAuXHJcbiAgaWYgKCF4Y1swXSB8fCAheWNbMF0pIHJldHVybiBuZXcgQmlnKHkucyAqIDApO1xyXG5cclxuICAvLyBJbml0aWFsaXNlIGV4cG9uZW50IG9mIHJlc3VsdCBhcyB4LmUgKyB5LmUuXHJcbiAgeS5lID0gaSArIGo7XHJcblxyXG4gIC8vIElmIGFycmF5IHhjIGhhcyBmZXdlciBkaWdpdHMgdGhhbiB5Yywgc3dhcCB4YyBhbmQgeWMsIGFuZCBsZW5ndGhzLlxyXG4gIGlmIChhIDwgYikge1xyXG4gICAgYyA9IHhjO1xyXG4gICAgeGMgPSB5YztcclxuICAgIHljID0gYztcclxuICAgIGogPSBhO1xyXG4gICAgYSA9IGI7XHJcbiAgICBiID0gajtcclxuICB9XHJcblxyXG4gIC8vIEluaXRpYWxpc2UgY29lZmZpY2llbnQgYXJyYXkgb2YgcmVzdWx0IHdpdGggemVyb3MuXHJcbiAgZm9yIChjID0gbmV3IEFycmF5KGogPSBhICsgYik7IGotLTspIGNbal0gPSAwO1xyXG5cclxuICAvLyBNdWx0aXBseS5cclxuXHJcbiAgLy8gaSBpcyBpbml0aWFsbHkgeGMubGVuZ3RoLlxyXG4gIGZvciAoaSA9IGI7IGktLTspIHtcclxuICAgIGIgPSAwO1xyXG5cclxuICAgIC8vIGEgaXMgeWMubGVuZ3RoLlxyXG4gICAgZm9yIChqID0gYSArIGk7IGogPiBpOykge1xyXG5cclxuICAgICAgLy8gQ3VycmVudCBzdW0gb2YgcHJvZHVjdHMgYXQgdGhpcyBkaWdpdCBwb3NpdGlvbiwgcGx1cyBjYXJyeS5cclxuICAgICAgYiA9IGNbal0gKyB5Y1tpXSAqIHhjW2ogLSBpIC0gMV0gKyBiO1xyXG4gICAgICBjW2otLV0gPSBiICUgMTA7XHJcblxyXG4gICAgICAvLyBjYXJyeVxyXG4gICAgICBiID0gYiAvIDEwIHwgMDtcclxuICAgIH1cclxuXHJcbiAgICBjW2pdID0gKGNbal0gKyBiKSAlIDEwO1xyXG4gIH1cclxuXHJcbiAgLy8gSW5jcmVtZW50IHJlc3VsdCBleHBvbmVudCBpZiB0aGVyZSBpcyBhIGZpbmFsIGNhcnJ5LCBvdGhlcndpc2UgcmVtb3ZlIGxlYWRpbmcgemVyby5cclxuICBpZiAoYikgKyt5LmU7XHJcbiAgZWxzZSBjLnNoaWZ0KCk7XHJcblxyXG4gIC8vIFJlbW92ZSB0cmFpbGluZyB6ZXJvcy5cclxuICBmb3IgKGkgPSBjLmxlbmd0aDsgIWNbLS1pXTspIGMucG9wKCk7XHJcbiAgeS5jID0gYztcclxuXHJcbiAgcmV0dXJuIHk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaW4gZXhwb25lbnRpYWwgbm90YXRpb24gdG8gZHAgZml4ZWQgZGVjaW1hbFxyXG4gKiBwbGFjZXMgYW5kIHJvdW5kZWQgdXNpbmcgQmlnLlJNLlxyXG4gKlxyXG4gKiBkcD8ge251bWJlcn0gSW50ZWdlciwgMCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKi9cclxuUC50b0V4cG9uZW50aWFsID0gZnVuY3Rpb24gKGRwKSB7XHJcbiAgcmV0dXJuIHN0cmluZ2lmeSh0aGlzLCAxLCBkcCwgZHApO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIHN0cmluZyByZXByZXNlbnRpbmcgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGluIG5vcm1hbCBub3RhdGlvbiB0byBkcCBmaXhlZCBkZWNpbWFsXHJcbiAqIHBsYWNlcyBhbmQgcm91bmRlZCB1c2luZyBCaWcuUk0uXHJcbiAqXHJcbiAqIGRwPyB7bnVtYmVyfSBJbnRlZ2VyLCAwIHRvIE1BWF9EUCBpbmNsdXNpdmUuXHJcbiAqXHJcbiAqICgtMCkudG9GaXhlZCgwKSBpcyAnMCcsIGJ1dCAoLTAuMSkudG9GaXhlZCgwKSBpcyAnLTAnLlxyXG4gKiAoLTApLnRvRml4ZWQoMSkgaXMgJzAuMCcsIGJ1dCAoLTAuMDEpLnRvRml4ZWQoMSkgaXMgJy0wLjAnLlxyXG4gKi9cclxuUC50b0ZpeGVkID0gZnVuY3Rpb24gKGRwKSB7XHJcbiAgcmV0dXJuIHN0cmluZ2lmeSh0aGlzLCAyLCBkcCwgdGhpcy5lICsgZHApO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIHN0cmluZyByZXByZXNlbnRpbmcgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIHJvdW5kZWQgdG8gc2Qgc2lnbmlmaWNhbnQgZGlnaXRzIHVzaW5nXHJcbiAqIEJpZy5STS4gVXNlIGV4cG9uZW50aWFsIG5vdGF0aW9uIGlmIHNkIGlzIGxlc3MgdGhhbiB0aGUgbnVtYmVyIG9mIGRpZ2l0cyBuZWNlc3NhcnkgdG8gcmVwcmVzZW50XHJcbiAqIHRoZSBpbnRlZ2VyIHBhcnQgb2YgdGhlIHZhbHVlIGluIG5vcm1hbCBub3RhdGlvbi5cclxuICpcclxuICogc2Qge251bWJlcn0gSW50ZWdlciwgMSB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKi9cclxuUC50b1ByZWNpc2lvbiA9IGZ1bmN0aW9uIChzZCkge1xyXG4gIHJldHVybiBzdHJpbmdpZnkodGhpcywgMywgc2QsIHNkIC0gMSk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcuXHJcbiAqIFJldHVybiBleHBvbmVudGlhbCBub3RhdGlvbiBpZiB0aGlzIEJpZyBoYXMgYSBwb3NpdGl2ZSBleHBvbmVudCBlcXVhbCB0byBvciBncmVhdGVyIHRoYW5cclxuICogQmlnLlBFLCBvciBhIG5lZ2F0aXZlIGV4cG9uZW50IGVxdWFsIHRvIG9yIGxlc3MgdGhhbiBCaWcuTkUuXHJcbiAqIE9taXQgdGhlIHNpZ24gZm9yIG5lZ2F0aXZlIHplcm8uXHJcbiAqL1xyXG5QLnRvU3RyaW5nID0gZnVuY3Rpb24gKCkge1xyXG4gIHJldHVybiBzdHJpbmdpZnkodGhpcyk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcuXHJcbiAqIFJldHVybiBleHBvbmVudGlhbCBub3RhdGlvbiBpZiB0aGlzIEJpZyBoYXMgYSBwb3NpdGl2ZSBleHBvbmVudCBlcXVhbCB0byBvciBncmVhdGVyIHRoYW5cclxuICogQmlnLlBFLCBvciBhIG5lZ2F0aXZlIGV4cG9uZW50IGVxdWFsIHRvIG9yIGxlc3MgdGhhbiBCaWcuTkUuXHJcbiAqIEluY2x1ZGUgdGhlIHNpZ24gZm9yIG5lZ2F0aXZlIHplcm8uXHJcbiAqL1xyXG5QLnZhbHVlT2YgPSBQLnRvSlNPTiA9IGZ1bmN0aW9uICgpIHtcclxuICByZXR1cm4gc3RyaW5naWZ5KHRoaXMsIDQpO1xyXG59O1xyXG5cclxuXHJcbi8vIEV4cG9ydFxyXG5cclxuXHJcbmV4cG9ydCB2YXIgQmlnID0gX0JpZ18oKTtcclxuXHJcbmV4cG9ydCBkZWZhdWx0IEJpZztcclxuIiwiaW1wb3J0IEJpZyBmcm9tICdiaWcuanMnO1xuXG4vKipcbiAqIOWKoOazleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g5Yqg5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDliqDmlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u45Yqg57uT5p6cXG4gKi9cbmZ1bmN0aW9uIGFkZCh4LCB5KSB7XG4gICAgcmV0dXJuIG5ldyBCaWcoeCkucGx1cyh5KS50b1N0cmluZygpO1xufVxuXG4vKipcbiAqIOWHj+azleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g6KKr5YeP5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDlh4/mlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u45YeP57uT5p6cXG4gKi9cbmZ1bmN0aW9uIHN1YnRyYWN0KHgsIHkpIHtcbiAgICByZXR1cm4gbmV3IEJpZyh4KS5taW51cyh5KS50b1N0cmluZygpO1xufVxuXG4vKipcbiAqIOS5mOazleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g5LmY5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDkuZjmlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u45LmY57uT5p6cXG4gKi9cbmZ1bmN0aW9uIG11bHRpcGx5KHgsIHkpIHtcbiAgICByZXR1cm4gbmV3IEJpZyh4KS50aW1lcyh5KS50b1N0cmluZygpO1xufVxuXG4vKipcbiAqIOmZpOazleWHveaVsFxuICogQHBhcmFtIHtudW1iZXJ8c3RyaW5nfSB4IC0g6KKr6Zmk5pWwXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHkgLSDpmaTmlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g6L+U5Zue55u46Zmk57uT5p6cXG4gKi9cbmZ1bmN0aW9uIGRpdmlkZSh4LCB5KSB7XG4gICAgcmV0dXJuIG5ldyBCaWcoeCkuZGl2KHkpLnRvU3RyaW5nKCk7XG59XG5cbi8qKlxuICog5qC85byP5YyW5pWw5a2XXG4gKiBAcGFyYW0ge251bWJlcnxzdHJpbmd9IHZhbHVlIC0g5b6F5qC85byP5YyW55qE5pWw5a2XXG4gKiBAcGFyYW0ge251bWJlcn0gW3ByZWNpc2lvbl0gLSDnsr7luqbvvIzljbPlsI/mlbDkvY3mlbBcbiAqIEByZXR1cm5zIHtzdHJpbmd9IC0g5qC85byP5YyW5ZCO55qE5a2X56ym5LiyXG4gKi9cbmZ1bmN0aW9uIGZvcm1hdCh2YWx1ZSwgcHJlY2lzaW9uKSB7XG4gICAgQmlnLk5FID0gLTlcbiAgICBjb25zdCBiaWdWYWx1ZSA9IG5ldyBCaWcodmFsdWUpO1xuICAgIGxldCBzdHJpbmdWYWx1ZSA9IGJpZ1ZhbHVlLnRvU3RyaW5nKCk7XG4gICAgLy/lhpnov5nkuYjpurvng6bvvIzmmK/lm6DkuLpCaWcucm91bmTnm7jlhbPmlrnms5XkuI3lpb3kvb/vvIzlvpfkuI3liLDpooTmnJ/nu5PmnpzjgIJcbiAgICBpZiAoc3RyaW5nVmFsdWUuaW5jbHVkZXMoJy4nKSkge1xuICAgICAgICBsZXQgc3RyQXJyYXkgPSBzdHJpbmdWYWx1ZS5zcGxpdCgnLicpO1xuICAgICAgICBpZiAoc3RyQXJyYXlbMV0ubGVuZ3RoID49IHByZWNpc2lvbikge1xuICAgICAgICAgICAgaWYgKDAgPT0gcHJlY2lzaW9uKSB7XG4gICAgICAgICAgICAgICAgcmV0dXJuIHN0ckFycmF5WzBdO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICAgICAgLy/miKrmlq1cbiAgICAgICAgICAgICAgICBsZXQgdHJ1bmNhdGUgPSBzdHJBcnJheVsxXS5zdWJzdHJpbmcoMCwgcHJlY2lzaW9uKTtcbiAgICAgICAgICAgICAgICByZXR1cm4gYCR7c3RyQXJyYXlbMF19LiR7dHJ1bmNhdGV9YDtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgICAgICBlbHNlIHtcbiAgICAgICAgICAgIC8v6KGl6Zu2XG4gICAgICAgICAgICBsZXQgemVyb051bWJlciA9IHByZWNpc2lvbiAtIHN0ckFycmF5WzFdLmxlbmd0aDtcbiAgICAgICAgICAgIHZhciBzdHIgPSAnJztcbiAgICAgICAgICAgIGZvciAobGV0IGkgPSAwOyBpIDwgemVyb051bWJlcjsgaSsrKSB7XG4gICAgICAgICAgICAgICAgc3RyICs9ICcwJztcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIHJldHVybiBgJHtzdHJpbmdWYWx1ZX0ke3N0cn1gO1xuICAgICAgICB9XG4gICAgfVxuICAgIGVsc2Uge1xuICAgICAgICBpZiAoMCA9PSBwcmVjaXNpb24pIHtcbiAgICAgICAgICAgIHJldHVybiBzdHJpbmdWYWx1ZTtcbiAgICAgICAgfVxuICAgICAgICBlbHNlIHtcbiAgICAgICAgICAgIGxldCB6ZXJvTnVtYmVyID0gcHJlY2lzaW9uO1xuICAgICAgICAgICAgdmFyIHN0ciA9ICcnO1xuICAgICAgICAgICAgZm9yIChsZXQgaSA9IDA7IGkgPCB6ZXJvTnVtYmVyOyBpKyspIHtcbiAgICAgICAgICAgICAgICBzdHIgKz0gJzAnO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgcmV0dXJuIGAke3N0cmluZ1ZhbHVlfS4ke3N0cn1gO1xuICAgICAgICB9XG4gICAgfVxufVxuXG4vKipcbiAqIOWvueaVsOe7hOS4reeahOavj+S4quWFg+e0oOi/m+ihjOeyvuehrui/kOeul+W5tui/lOWbnuS4gOS4quaWsOaVsOe7hFxuICogQHBhcmFtIHtBcnJheTxudW1iZXJ8c3RyaW5nPn0gYXJyIC0g5b6F6L+Q566X5pWw57uEXG4gKiBAcmV0dXJucyB7QXJyYXk8c3RyaW5nPn0gLSDov5Tlm57ov5Dnrpfnu5PmnpzmlbDnu4RcbiAqL1xuZnVuY3Rpb24gYmlnbnVtYmVyKGFycikge1xuICAgIGlmIChBcnJheS5pc0FycmF5KGFycikpIHtcbiAgICAgICAgcmV0dXJuIGFyci5tYXAoKHZhbHVlKSA9PiBCaWcodmFsdWUpLnRvRml4ZWQoKSk7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgcmV0dXJuIEJpZyhhcnIpLnRvRml4ZWQoKTtcbiAgICB9XG59XG5cbmV4cG9ydCB7IGFkZCwgc3VidHJhY3QsIG11bHRpcGx5LCBkaXZpZGUsIGZvcm1hdCwgYmlnbnVtYmVyIH07XG4iLCJpbXBvcnQgKiBhcyBudW1iZXIgZnJvbSBcIi4vbnVtYmVyXCI7XG5cbnZhciBjbGlja2FibGUgPSB0cnVlO1xuZXhwb3J0IHZhciBhY2NvdW50SWQgPSAtMTtcblxuZXhwb3J0IGZ1bmN0aW9uIG1vZHVsZURlZmluZShtb2R1bGVOYW1lLCBkZWZhdWx0RGF0YUZ1bmN0aW9uLCBmdW5jdGlvbnMgPSB7IG9uQ3JlYXRlLCBvbkRlc3Ryb3ksIG9uUmVzdW1lLCBvblBhdXNlLCBvblN0YXJ0LCBvblN0b3AgfSkge1xuICAgIGNvbnNvbGUubG9nKGBsb2FkTW9kdWxlYCwgbW9kdWxlTmFtZSk7XG4gICAgJGRhdGFbbW9kdWxlTmFtZV0gPSBkZWZhdWx0RGF0YUZ1bmN0aW9uKCk7XG4gICAgJGV2ZW50W21vZHVsZU5hbWVdID0ge1xuICAgICAgICBvbkNyZWF0ZTogdHlwZW9mIGZ1bmN0aW9ucy5vbkNyZWF0ZSA9PSAndW5kZWZpbmVkJyA/IG9uQ3JlYXRlIDogZnVuY3Rpb25zLm9uQ3JlYXRlLFxuICAgICAgICBvbkRlc3Ryb3k6IHR5cGVvZiBmdW5jdGlvbnMub25EZXN0cm95ID09ICd1bmRlZmluZWQnID8gb25EZXN0cm95IDogZnVuY3Rpb25zLm9uRGVzdHJveSxcbiAgICAgICAgb25SZXN1bWU6IHR5cGVvZiBmdW5jdGlvbnMub25SZXN1bWUgPT0gJ3VuZGVmaW5lZCcgPyBvblJlc3VtZSA6IGZ1bmN0aW9ucy5vblJlc3VtZSxcbiAgICAgICAgb25QYXVzZTogdHlwZW9mIGZ1bmN0aW9ucy5vblBhdXNlID09ICd1bmRlZmluZWQnID8gb25QYXVzZSA6IGZ1bmN0aW9ucy5vblBhdXNlLFxuICAgICAgICBvblN0YXJ0OiB0eXBlb2YgZnVuY3Rpb25zLm9uU3RhcnQgPT0gJ3VuZGVmaW5lZCcgPyBvblN0YXJ0IDogZnVuY3Rpb25zLm9uU3RhcnQsXG4gICAgICAgIG9uU3RvcDogdHlwZW9mIGZ1bmN0aW9ucy5vblN0b3AgPT0gJ3VuZGVmaW5lZCcgPyBvblN0b3AgOiBmdW5jdGlvbnMub25TdG9wLFxuICAgIH07XG4gICAgcmV0dXJuIHtcbiAgICAgICAgbW9kdWxlRGF0YTogJGRhdGFbbW9kdWxlTmFtZV0sXG4gICAgICAgIG1vZHVsZUV2ZW50OiAkZXZlbnRbbW9kdWxlTmFtZV1cbiAgICB9O1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gYW5hbHl0aWNzKGV2ZW50ID0gXCJcIiwgcHJvcGVydGllcyA9IHt9KSB7XG4gICAgY29uc3QgcHJvcGVydGllc0pzb24gPSBKU09OLnN0cmluZ2lmeShwcm9wZXJ0aWVzKTtcbiAgICBjb25zb2xlLmxvZyhgYW5hbHl0aWNzIGV2ZW50OiAke2V2ZW50fSwgcHJvcGVydGllc0pzb24gPSAke3Byb3BlcnRpZXNKc29ufWApO1xuICAgIHZhciBtYXAgPSB7XG4gICAgICAgIGV2ZW50OiBldmVudCxcbiAgICAgICAgcHJvcGVydGllczogcHJvcGVydGllc0pzb25cbiAgICB9O1xuICAgIGF3YWl0ICRuYXRpdmVBUEkuYW5hbHl0aWNzKG1hcCk7XG59XG5cbmZ1bmN0aW9uIG9uQ3JlYXRlKCkge1xuICAgIGNvbnNvbGUubG9nKCdjb21tb24gb25DcmVhdGUnKTtcbn1cblxuZnVuY3Rpb24gb25EZXN0cm95KCkge1xufVxuXG5mdW5jdGlvbiBvblJlc3VtZSgpIHtcbn1cblxuZnVuY3Rpb24gb25QYXVzZSgpIHtcbn1cblxuZnVuY3Rpb24gb25TdGFydCgpIHtcbn1cblxuZnVuY3Rpb24gb25TdG9wKCkge1xufVxuXG5leHBvcnQgdmFyIGNvbW1vbkRhdGEgPSB7XG4gICAgcHJpY2VDb2xvclR5cGU6IDAsIC8vLzDvvJrnuqLmtqjnu7/ot4wgICAx77ya57u/5rao57qi6LeMXG4gICAgY29sb3JNb2RlOiAwLCAvLy8w77ya55m95aSpICAgMe+8mum7keWknFxuICAgIE9TOiAwLCAvLzDvvJppT1MgIDHvvJrlronljZNcbiAgICBhcHBWZXJzaW9uOiBcIlwiLCAvL2FwcOeJiOacrOWPt1xuICAgIGlzSW5SZXZpZXc6IDEsXG4gICAgaDVVcmw6IFwiXCIsIC8vLyBoNeWKqOaAgeWfn+WQjVxuICAgIGxhbmd1YWdlOiBcIlwiLCAvLy8g6K+t6KiA56eN57G7XG4gICAgc3RhdHVzSGVpZ2h0OiAwLFxuICAgIHZUb2tlbjogXCJcIiwgLy8g5paw6K6+5aSH5oyH57q5XG4gICAgb2xkVlRva2VuOiBcIlwiLCAvLyDml6forr7lpIfmjIfnurks5Y+C6ICD5Y6f5p2lXCJmcFwiXG4gICAgYm90dG9tU2FmZUFyZWFIZWlnaHQ6IDAsXG59O1xuJGRhdGEuY29tbW9uRGF0YSA9IGNvbW1vbkRhdGE7XG5cbi8vIC8v5omT5byAVVJMXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gb3BlblVSTCh1cmwpIHtcbiAgICBpZiAoIWNsaWNrYWJsZSkge1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIGNvbnNvbGUubG9nKGBvcGVuIHVybDpgLCB1cmwpO1xuICAgIGlmICh1cmwgJiYgdXJsICE9IG51bGwgJiYgdXJsLmxlbmd0aCA+IDApIHtcbiAgICAgICAgYXdhaXQgJG5hdGl2ZUFQSS5vcGVuUm91dGUodXJsKTtcbiAgICB9XG4gICAgY2xpY2thYmxlID0gZmFsc2U7XG4gICAgc2V0VGltZW91dCgoKSA9PiB7XG4gICAgICAgIGNsaWNrYWJsZSA9IHRydWU7XG4gICAgfSwgMTAwMCk7XG59XG5cbi8v6K6+572u6YCa55So6YWN572uXG5leHBvcnQgZnVuY3Rpb24gZ2V0Q29tbW9uQ29uZmlnKHBhcmFtKSB7XG4gICAgY29uc29sZS5sb2cocGFyYW0pO1xuICAgIGNvbW1vbkRhdGEucHJpY2VDb2xvclR5cGUgPSBwYXJzZUludChwYXJhbS5wcmljZUNvbG9yVHlwZSk7XG4gICAgY29tbW9uRGF0YS5jb2xvck1vZGUgPSBwYXJzZUludChwYXJhbS5jb2xvck1vZGUpO1xuICAgIGNvbW1vbkRhdGEuT1MgPSBwYXJzZUludChwYXJhbS5PUyk7XG4gICAgY29tbW9uRGF0YS5hcHBWZXJzaW9uID0gcGFyYW0uYXBwVmVyc2lvbjtcbiAgICBjb21tb25EYXRhLmlzSW5SZXZpZXcgPSBwYXJzZUludChwYXJhbS5pc0luUmV2aWV3KTtcbiAgICBjb21tb25EYXRhLmxhbmd1YWdlID0gcGFyYW0ubGFuZ3VhZ2U7XG4gICAgY29tbW9uRGF0YS5oNVVybCA9IHBhcmFtLmg1VXJsO1xuICAgIGNvbW1vbkRhdGEuc3RhdHVzSGVpZ2h0ID0gcGFyYW0uc3RhdHVzSGVpZ2h0O1xuICAgIGNvbW1vbkRhdGEudlRva2VuID0gcGFyYW0udlRva2VuO1xuICAgIGNvbW1vbkRhdGEub2xkVlRva2VuID0gcGFyYW0ub2xkVlRva2VuO1xuICAgIGNvbW1vbkRhdGEuYm90dG9tU2FmZUFyZWFIZWlnaHQgPSBwYXJhbS5ib3R0b21TYWZlQXJlYUhlaWdodDtcbiAgICAkZGF0YS5jb21tb25EYXRhID0gY29tbW9uRGF0YTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGdldFBOR0ljb25VUkxCeUN1cnJlbmN5KGN1cnJlbmN5KSB7XG4gICAgbGV0IGJhc2VVcmwgPSBjb21tb25EYXRhLmg1VXJsID8gY29tbW9uRGF0YS5oNVVybCA6IFwiXCI7XG4gICAgcmV0dXJuIGAke2Jhc2VVcmx9Ly0veC9oYi9wL2FwaS9jb250ZW50cy9jdXJyZW5jeS9pY29uX3BuZy8ke2N1cnJlbmN5LnRvTG93ZXJDYXNlKCl9LnBuZ2A7XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRJbmRleFByaWNlQnlTeW1ib2woc3ltYm9sKSB7XG4gICAgbGV0IGluZGV4UHJpY2VSZXFPYmogPSB7XG4gICAgICAgIHN5bWJvbDogc3ltYm9sXG4gICAgfTtcbiAgICBjb25zdCBkYXRhID0gYXdhaXQgc2VuZFJlcXVlc3QoXCJvcHRpb24vdjEvcHJlL2luZGV4XCIsIGluZGV4UHJpY2VSZXFPYmosIDAsIDgpO1xuICAgIGlmIChkYXRhKSB7XG4gICAgICAgIHJldHVybiBkYXRhO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIHJldHVybiBcIi0tXCI7XG4gICAgfVxufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gcmVxdWVzdEFjY291bnRJZCgpIHtcbiAgICBjb25zdCBkYXRhID0gYXdhaXQgc2VuZFJlcXVlc3QoJ3YxL2FjY291bnQvYWNjb3VudHMnLCB7fSwgMCwgNCk7XG4gICAgY29uc29sZS5sb2coYHJlcXVlc3RBY2NvdW50SWQgOiAke0pTT04uc3RyaW5naWZ5KGRhdGEpfWApXG4gICAgZm9yICh2YXIgaSA9IDA7IGkgPCBkYXRhLmxlbmd0aDsgaSsrKSB7XG4gICAgICAgIGlmIChkYXRhW2ldLnR5cGUgPT0gXCJvdGMtb3B0aW9uc1wiKSB7XG4gICAgICAgICAgICBhY2NvdW50SWQgPSBkYXRhW2ldLmlkXG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgfVxuICAgIH1cbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNlbmRSZXF1ZXN0MihwYXRoLCBwYXJhbXMgPSB7fSwgbWV0aG9kID0gMCwgaG9zdFR5cGUgPSAwLCBoZWFkZXIgPSB7fSkge1xuICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0ICR7cGF0aH0sIHBhcmFtczoke0pTT04uc3RyaW5naWZ5KHBhcmFtcyl9YCk7XG5cbiAgICBpZiAoaG9zdFR5cGUgPT0gNSB8fCBob3N0VHlwZSA9PSA2KSB7XG4gICAgICAgIGhlYWRlcltcIkNvbnRlbnQtVHlwZVwiXSA9IFwiYXBwbGljYXRpb24vanNvblwiO1xuICAgIH1cblxuICAgIGNvbnN0IHBhcmFtID0ge1xuICAgICAgICBwYXRoLFxuICAgICAgICBtZXRob2QsXG4gICAgICAgIGhvc3RUeXBlLFxuICAgICAgICBoZWFkZXIsXG4gICAgICAgIHBhcmFtcyxcbiAgICB9O1xuICAgIHRyeSB7XG4gICAgICAgIHZhciByZXNwb25zZVN0cmluZyA9IGF3YWl0ICRuYXRpdmVBUEkucmVxdWVzdChKU09OLnN0cmluZ2lmeShwYXJhbSkpO1xuICAgICAgICB2YXIgcmVzcG9uc2UgPSBKU09OLnBhcnNlKHJlc3BvbnNlU3RyaW5nKTtcbiAgICAgICAgcmV0dXJuIHJlc3BvbnNlO1xuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgZXJyb3IsIGVycm9yPSR7ZX1gKTtcbiAgICAgICAgcmV0dXJuIG51bGw7XG4gICAgfVxufVxuXG4vL+WPkemAgeivt+axglxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNlbmRSZXF1ZXN0KHBhdGgsIHBhcmFtcyA9IHt9LCBtZXRob2QgPSAwLCBob3N0VHlwZSA9IDAsIGhlYWRlciA9IHt9KSB7XG4gICAgY29uc29sZS5sb2coYHJlcXVlc3QgJHtwYXRofSwgcGFyYW1zOiR7SlNPTi5zdHJpbmdpZnkocGFyYW1zKX1gKTtcblxuICAgIGlmIChob3N0VHlwZSA9PSA1IHx8IGhvc3RUeXBlID09IDYpIHtcbiAgICAgICAgaGVhZGVyW1wiQ29udGVudC1UeXBlXCJdID0gXCJhcHBsaWNhdGlvbi9qc29uXCI7XG4gICAgfVxuXG4gICAgY29uc3QgcGFyYW0gPSB7XG4gICAgICAgIHBhdGgsXG4gICAgICAgIG1ldGhvZCxcbiAgICAgICAgaG9zdFR5cGUsXG4gICAgICAgIGhlYWRlcixcbiAgICAgICAgcGFyYW1zLFxuICAgIH07XG4gICAgdHJ5IHtcbiAgICAgICAgdmFyIHJlc3BvbnNlU3RyaW5nID0gYXdhaXQgJG5hdGl2ZUFQSS5yZXF1ZXN0KEpTT04uc3RyaW5naWZ5KHBhcmFtKSk7XG4gICAgICAgIHZhciByZXNwb25zZSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcpO1xuICAgICAgICB2YXIgeyBjb2RlLCBkYXRhIH0gPSByZXNwb25zZTtcbiAgICAgICAgaWYgKDggPT0gaG9zdFR5cGUpIHtcbiAgICAgICAgICAgIC8v5ZCI57qm55qE5o6l5Y+j5aSE55CGXG4gICAgICAgICAgICB2YXIgc3RhdHVzID0gcmVzcG9uc2Uuc3RhdHVzO1xuICAgICAgICAgICAgdmFyIGVycl9jb2RlID0gcmVzcG9uc2UuZXJyX2NvZGU7XG4gICAgICAgICAgICB2YXIgZXJyX21zZyA9IHJlc3BvbnNlLmVycl9tc2c7XG4gICAgICAgICAgICBpZiAoc3RhdHVzID09IFwib2tcIikge1xuICAgICAgICAgICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0ICR7cGF0aH0gZG9uZWApO1xuICAgICAgICAgICAgICAgIGlmICh0eXBlb2YgZGF0YSA9PT0gJ251bWJlcicpIHtcbiAgICAgICAgICAgICAgICAgICAgbGV0IHN0YXJ0ID0gYFwiZGF0YVwiOmA7XG4gICAgICAgICAgICAgICAgICAgIGxldCBzdGFydEluZGV4ID0gcmVzcG9uc2VTdHJpbmcuaW5kZXhPZihzdGFydCk7XG4gICAgICAgICAgICAgICAgICAgIGxldCBlbmQgPSBgLFwidHNcIjpgO1xuICAgICAgICAgICAgICAgICAgICBsZXQgZW5kSW5kZXggPSByZXNwb25zZVN0cmluZy5pbmRleE9mKGVuZCk7XG4gICAgICAgICAgICAgICAgICAgIGxldCBkYXRhU3RyaW5nID0gcmVzcG9uc2VTdHJpbmcuc3Vic3RyaW5nKHN0YXJ0SW5kZXggKyBzdGFydC5sZW5ndGgsIGVuZEluZGV4KTtcbiAgICAgICAgICAgICAgICAgICAgY29uc29sZS5sb2coYGRhdGEgaXMgdHlwZW9mIG51bWJlciwgZGF0YVN0cmluZyA9ICR7ZGF0YVN0cmluZ31gKTtcbiAgICAgICAgICAgICAgICAgICAgcmV0dXJuIGRhdGFTdHJpbmc7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIHJldHVybiBkYXRhO1xuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCBmYWlsZWQsIGNvZGU9JHtlcnJfY29kZX0sIG1lc3NhZ2U9JHtlcnJfbXNnfWApO1xuICAgICAgICAgICAgICAgIGlmIChtZXRob2QgIT0gMCkge1xuICAgICAgICAgICAgICAgICAgICBzaG93VG9hc3QoZXJyX21zZyk7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIHJldHVybiBudWxsO1xuICAgICAgICAgICAgfVxuICAgICAgICB9IGVsc2UgaWYgKGNvZGUgPT0gMjAwKSB7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCAke3BhdGh9IGRvbmVgKTtcbiAgICAgICAgICAgIHJldHVybiBkYXRhO1xuICAgICAgICB9IGVsc2UgaWYgKChjb2RlID09IG51bGwgfHwgY29kZSA9PSBcIlwiIHx8IGNvZGUgPT0gXCJ1bmRlZmluZWRcIikgJiYgcmVzcG9uc2Uuc3RhdHVzID09IFwib2tcIikge1xuICAgICAgICAgICAgaWYgKGRhdGEgPT0gbnVsbCkge1xuICAgICAgICAgICAgICAgIHJldHVybiByZXNwb25zZTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0ICR7cGF0aH0gZG9uZWApO1xuICAgICAgICAgICAgcmV0dXJuIGRhdGE7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCBmYWlsZWQsIGNvZGU9JHtjb2RlfWApO1xuICAgICAgICAgICAgbGV0IG1lc3NhZ2UgPSByZXNwb25zZS5tZXNzYWdlO1xuICAgICAgICAgICAgaWYgKG1lc3NhZ2UpIHtcbiAgICAgICAgICAgICAgICBzaG93VG9hc3QobWVzc2FnZSk7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICByZXR1cm4gbnVsbDtcbiAgICAgICAgfVxuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgZXJyb3IsIGVycm9yPSR7ZX1gKTtcbiAgICAgICAgcmV0dXJuIG51bGw7XG4gICAgfVxufVxuXG4vL3RvYXN0XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc2hvd1RvYXN0KG1zZykge1xuICAgIGF3YWl0ICRuYXRpdmVBUEkuaGJUb2FzdChtc2cpO1xufVxuXG4vKipcbiAqIFxuICogQHBhcmFtIHtib29sZWFufSBpc1Nob3cg5piv5ZCm5pi+56S65Yqg6L295qGGXG4gKi9cbmV4cG9ydCBmdW5jdGlvbiBzaG93TG9hZGluZyhpc1Nob3cgPSB0cnVlKSB7XG4gICAgJG5hdGl2ZUFQSS5zaG93TG9hZGluZyhpc1Nob3cgPyAxIDogMCk7XG59XG5cbi8qKlxuICogXG4gKiBAcGFyYW0ge+aXtumXtOaXpeacn+agvOW8j+WMln0gZm10IHl5eXktTU0tZGQgaGg6bW06c3NcbiAqIEByZXR1cm5zIOagvOW8j+WMluS5i+WQjueahCDlrZfnrKbkuLLvvIznlKjms5XkvovlpoIgbmV3IERhdGUo5pe26Ze05oizKS5Gb3JtYXQoXCJ5eXl5LU1NLWRkIGhoOm1tOnNzXCIpXG4gKi9cbkRhdGUucHJvdG90eXBlLkZvcm1hdCA9IGZ1bmN0aW9uIChmbXQpIHtcbiAgICB2YXIgbyA9IHtcbiAgICAgICAgXCJNK1wiOiB0aGlzLmdldE1vbnRoKCkgKyAxLCAvL+aciOS7vSBcbiAgICAgICAgXCJkK1wiOiB0aGlzLmdldERhdGUoKSwgLy/ml6UgXG4gICAgICAgIFwiaCtcIjogdGhpcy5nZXRIb3VycygpLCAvL+Wwj+aXtiBcbiAgICAgICAgXCJtK1wiOiB0aGlzLmdldE1pbnV0ZXMoKSwgLy/liIYgXG4gICAgICAgIFwicytcIjogdGhpcy5nZXRTZWNvbmRzKCksIC8v56eSIFxuICAgICAgICBcInErXCI6IE1hdGguZmxvb3IoKHRoaXMuZ2V0TW9udGgoKSArIDMpIC8gMyksIC8v5a2j5bqmIFxuICAgICAgICBcIlNcIjogdGhpcy5nZXRNaWxsaXNlY29uZHMoKSAvL+avq+enkiBcbiAgICB9O1xuICAgIGlmICgvKHkrKS8udGVzdChmbXQpKSBmbXQgPSBmbXQucmVwbGFjZShSZWdFeHAuJDEsICh0aGlzLmdldEZ1bGxZZWFyKCkgKyBcIlwiKS5zdWJzdHIoNCAtIFJlZ0V4cC4kMS5sZW5ndGgpKTtcbiAgICBmb3IgKHZhciBrIGluIG8pXG4gICAgICAgIGlmIChuZXcgUmVnRXhwKFwiKFwiICsgayArIFwiKVwiKS50ZXN0KGZtdCkpIGZtdCA9IGZtdC5yZXBsYWNlKFJlZ0V4cC4kMSwgKFJlZ0V4cC4kMS5sZW5ndGggPT0gMSkgPyAob1trXSkgOiAoKFwiMDBcIiArIG9ba10pLnN1YnN0cigoXCJcIiArIG9ba10pLmxlbmd0aCkpKTtcbiAgICByZXR1cm4gZm10O1xufVxuXG4vL+i/m+ihjOeyvuW6puWkhOeQhlxuZXhwb3J0IGZ1bmN0aW9uIGZvcm1hdFByZWNpc2lvbih2YWx1ZSwgcHJlY2lzaW9uKSB7XG4gICAgdHJ5IHtcbiAgICAgICAgY29uc3QgcmVzdWx0ID0gbnVtYmVyLmZvcm1hdCh2YWx1ZSwgcHJlY2lzaW9uKTtcbiAgICAgICAgcmV0dXJuIHJlc3VsdDtcbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGUpO1xuICAgICAgICByZXR1cm4gdmFsdWUudG9GaXhlZChwcmVjaXNpb24pO1xuICAgIH1cbn1cblxuLy/lrrnlmajov5Tlm57og73liptcbmV4cG9ydCBmdW5jdGlvbiBjb250YWluZXJCYWNrKHBhcmFtID0gMCkge1xuICAgIGNvbnNvbGUubG9nKFwiY29udGFpbmVyQmFja1wiKVxuICAgICRuYXRpdmVBUEkuY29udGFpbmVyQmFjayhwYXJhbSlcbn0iLCJpbXBvcnQgKiBhcyBjb21tb24gZnJvbSBcIi4vY29tbW9uXCI7XG5cbmZ1bmN0aW9uIGRlZmF1bHREYXRhKCkge1xuICAgIHJldHVybiB7XG4gICAgICAgIHBvcERhdGE6IFtdLFxuICAgICAgICBjdXJyZW50SW5kZXg6IDAsXG4gICAgICAgIHNldHVwVGV4dDogXCJcIixcbiAgICB9O1xufVxuXG5jb25zdCB7IG1vZHVsZURhdGEsIG1vZHVsZUV2ZW50IH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFwiZ3VpZGVwb3BcIiwgZGVmYXVsdERhdGEsIHsgb25DcmVhdGUgfSk7XG5cbm1vZHVsZUV2ZW50Lmxhc3QgPSBsYXN0O1xubW9kdWxlRXZlbnQubmV4dCA9IG5leHQ7XG5cbnZhciB0aXRsZUxpc3QgPSBbXG4gICAgJGkxOG4ubl9kb3VibGVfY29pbl9vcGVuX2FjY291bnQsXG4gICAgJGkxOG4ubl9kb3VibGVfY29pbl9ndWlkZV9zZXR1cF8yLFxuICAgICRpMThuLm5fZG91YmxlX2NvaW5fZ3VpZGVfc2V0dXBfNCxcbiAgICAkaTE4bi5uX2RvdWJsZV9jb2luX2d1aWRlX3NldHVwXzRdO1xudmFyIGNvbnRlbnRMaXN0ID0gW1xuICAgICRpMThuLm5fZG91YmxlX2NvaW5fZ3VpZGVfc2V0dXBfMSxcbiAgICAkaTE4bi5uX2RvdWJsZV9jb2luX2d1aWRlX3NldHVwXzMsXG4gICAgJGkxOG4ubl9kb3VibGVfY29pbl9ndWlkZV9zZXR1cF82LFxuICAgICRpMThuLm5fZG91YmxlX2NvaW5fZ3VpZGVfc2V0dXBfOF07XG5cbmZ1bmN0aW9uIG9uQ3JlYXRlKCkge1xuICAgIGNvbnNvbGUubG9nKGBndWlkZXBvcCBvbkNyZWF0ZWApO1xuICAgIHJlcXVlc3RHdWlkZVBvcERhdGEoKTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gcmVxdWVzdEd1aWRlUG9wRGF0YSgpIHtcbiAgICAvL+W8leWvvOWbvueJh+i1hOa6kOivt+axguWcsOWdgFxuICAgIGNvbnN0IGRhdGEgPSBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3QoJ290Yy9vcHQvb3B0aW9uL29yZGVyL3YxL2d1aWRlLXBvcC11cC9yZXNvdXJjZXMnLCB7IHByb2R1Y3RUeXBlSWQ6IDUgfSwgMCwgMCk7XG4gICAgaWYgKGRhdGEgIT0gbnVsbCkge1xuICAgICAgICBsZXQgcGljdHVyZUxpc3QgPSBkYXRhW1wicGljdHVyZS1saW5rc1wiXTtcbiAgICAgICAgbGV0IHBvcERhdGEgPSBbXTtcbiAgICAgICAgZm9yIChsZXQgaSA9IDA7IGkgPCBwaWN0dXJlTGlzdC5sZW5ndGg7IGkrKykge1xuICAgICAgICAgICAgbGV0IG9iaiA9IHtcbiAgICAgICAgICAgICAgICB0aXRsZTogdGl0bGVMaXN0W2ldLFxuICAgICAgICAgICAgICAgIGNvbnRlbnQ6IGNvbnRlbnRMaXN0W2ldLFxuICAgICAgICAgICAgICAgIGltYWdlOiBwaWN0dXJlTGlzdFtpXVxuICAgICAgICAgICAgfTtcbiAgICAgICAgICAgIGlmIChpID09IDIgfHwgaSA9PSAzKSB7XG4gICAgICAgICAgICAgICAgb2JqLnR5cGUgPSBcImNlbGwxXCJcbiAgICAgICAgICAgICAgICBvYmouc3ViVGl0bGUgPSBpID09IDIgPyAkaTE4bi5uX2RvdWJsZV9jb2luX2d1aWRlX3NldHVwXzUgOiAkaTE4bi5uX2RvdWJsZV9jb2luX2d1aWRlX3NldHVwXzdcbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgb2JqLnR5cGUgPSBcImNlbGxcIlxuICAgICAgICAgICAgfVxuICAgICAgICAgICAgcG9wRGF0YS5wdXNoKG9iaik7XG4gICAgICAgIH1cbiAgICAgICAgY29uc29sZS5sb2coYHVwZGF0ZVNldHVwVGV4dDEgOiAke0pTT04uc3RyaW5naWZ5KHBvcERhdGEpfWApO1xuICAgICAgICBtb2R1bGVEYXRhLnBvcERhdGEgPSBwb3BEYXRhO1xuICAgICAgICB1cGRhdGVTZXR1cFRleHQoKTtcbiAgICB9XG59XG5cbmZ1bmN0aW9uIGxhc3QoKSB7XG4gICAgY29uc29sZS5sb2coYGxhc3QgJHttb2R1bGVEYXRhLmN1cnJlbnRJbmRleH1gKTtcbiAgICBpZiAobW9kdWxlRGF0YS5jdXJyZW50SW5kZXggPT0gMCkge1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIG1vZHVsZURhdGEuY3VycmVudEluZGV4ID0gbW9kdWxlRGF0YS5jdXJyZW50SW5kZXggLSAxO1xuICAgIHVwZGF0ZVNldHVwVGV4dCgpO1xufVxuXG5mdW5jdGlvbiBuZXh0KCkge1xuICAgIGNvbnNvbGUubG9nKGBsYXN0ICR7bW9kdWxlRGF0YS5jdXJyZW50SW5kZXh9IC0tLSAke21vZHVsZURhdGEucG9wRGF0YS5sZW5ndGh9YCk7XG4gICAgaWYgKG1vZHVsZURhdGEuY3VycmVudEluZGV4ID09IG1vZHVsZURhdGEucG9wRGF0YS5sZW5ndGggLSAxKSB7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgbW9kdWxlRGF0YS5jdXJyZW50SW5kZXggPSBtb2R1bGVEYXRhLmN1cnJlbnRJbmRleCArIDE7XG4gICAgdXBkYXRlU2V0dXBUZXh0KCk7XG59XG5cbmZ1bmN0aW9uIHVwZGF0ZVNldHVwVGV4dCgpIHtcbiAgICBjb25zb2xlLmxvZyhgdXBkYXRlU2V0dXBUZXh0IDogJHttb2R1bGVEYXRhLnBvcERhdGEubGVuZ3RofWApO1xuICAgIGlmIChtb2R1bGVEYXRhLnBvcERhdGEubGVuZ3RoID09IDApIHtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICBtb2R1bGVEYXRhLnNldHVwVGV4dCA9IGAoJHttb2R1bGVEYXRhLmN1cnJlbnRJbmRleCArIDF9LyR7bW9kdWxlRGF0YS5wb3BEYXRhLmxlbmd0aH0pYFxufSIsImltcG9ydCAqIGFzIGNvbW1vbiBmcm9tIFwiLi9jb21tb25cIjtcblxuZnVuY3Rpb24gZGVmYXVsdERhdGEoKSB7XG4gICAgcmV0dXJuIHtcbiAgICAgICAgcmVmcmVzaDonMCcsXG4gICAgICAgIG1haW5EYXRhOiBbXG4gICAgICAgICAgICB7XG4gICAgICAgICAgICAgICAgdHlwZTonNScsXG4gICAgICAgICAgICB9LFxuICAgICAgICAgICAge1xuICAgICAgICAgICAgICAgIHR5cGU6JzInLFxuICAgICAgICAgICAgfSxcbiAgICAgICAgICAgIHtcbiAgICAgICAgICAgICAgICB0eXBlOiczJyxcbiAgICAgICAgICAgIH0sXG4gICAgICAgICAgICB7XG4gICAgICAgICAgICAgICAgdHlwZTonNCcsXG4gICAgICAgICAgICAgICAgYW5zd2VyVmlzYWJsZTE6J2dvbmUnLFxuICAgICAgICAgICAgICAgIGFuc3dlclZpc2FibGUyOidnb25lJyxcbiAgICAgICAgICAgICAgICBhbnN3ZXJWaXNhYmxlMzonZ29uZScsXG4gICAgICAgICAgICAgICAgYW5zd2VyVmlzYWJsZTQ6J2dvbmUnLFxuICAgICAgICAgICAgICAgIGFuc3dlclZpc2FibGU1Oidnb25lJyxcbiAgICAgICAgICAgICAgICBxYUljb24xOlwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIixcbiAgICAgICAgICAgICAgICBxYUljb24yOlwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIixcbiAgICAgICAgICAgICAgICBxYUljb24zOlwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIixcbiAgICAgICAgICAgICAgICBxYUljb240OlwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIixcbiAgICAgICAgICAgICAgICBxYUljb241OlwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIixcbiAgICAgICAgICAgIH1cbiAgICAgICAgXSxcbiAgICB9O1xufVxuXG5mdW5jdGlvbiBnZXROYXZDb25maWdTdHJpbmcoKSB7XG4gICAgcmV0dXJuIHtcbiAgICAgICd0aXRsZUtleSc6ICduX2RvdWJsZV9jb2luX2Vhcm4nLFxuICAgICAgJ2xlZnQnOiB7XG4gICAgICAgICdhY3Rpb24nOiB7XG4gICAgICAgICAgJ3R5cGUnOiAnYmFjaycsXG4gICAgICAgICAgJ3BhcmFtZXRlcic6ICcnXG4gICAgICAgIH0sXG4gICAgICAgICdpY29uJzogJ2VkZ2VfZW5naW5lX3RvcF9iYXJfYmFja19ub3JtYWwnXG4gICAgICB9LFxuICAgICAgJ3JpZ2h0Jzp7XG4gICAgICAgICdhY3Rpb24nOntcbiAgICAgICAgICAgICd0eXBlJzonZXZhbEpTJyxcbiAgICAgICAgICAgICdwYXJhbWV0ZXInOiAncmlnaHRCdG5DbGlja2VkJ1xuICAgICAgICB9LFxuICAgICAgICAnaWNvbic6J2VkZ2VfZW5naW5lX2RiY29pbl9yaWdodF9idG4nXG4gICAgICB9LFxuICAgICAgJ2JhY2tncm91bmRDb2xvcic6J2VIb21lVG9wQmFja2dyb3VuZENvbG9yJ1xuICAgIH07XG4gIH1cblxuY29uc3QgeyBtb2R1bGVEYXRhLCBtb2R1bGVFdmVudCB9ID0gY29tbW9uLm1vZHVsZURlZmluZShcImhvbWVcIiwgZGVmYXVsdERhdGEsIHsgb25DcmVhdGUgfSk7XG5cbmZ1bmN0aW9uIG9uQ3JlYXRlKCkge1xuICAgIGNvbnNvbGUubG9nKCdob21lIG9uQ3JlYXRlJyk7XG4gICAgbW9kdWxlRGF0YS5zdGF0dXNCYXJDb25maWcgPSB7IFwic3RhdHVzQmFyTW9kZVwiOiBcInRydWVcIiwgXCJhZFN0YXR1c0JhckNvbG9yXCI6XCJlSG9tZVRvcEJhY2tncm91bmRDb2xvclwiIH07XG4gICAgbW9kdWxlRGF0YS5uYXZDb25maWcgPSBnZXROYXZDb25maWdTdHJpbmcoKTtcbiAgICByZXF1ZXN0Q29pbkRhdGFzKCk7XG59XG5cbmZ1bmN0aW9uIGdldFN1cHBsZW1lbnREYXRhKCkge1xuICAgIHJldHVybiBbXG4gICAgICAgIHtcbiAgICAgICAgICAgIHR5cGU6JzInLFxuICAgICAgICB9LFxuICAgICAgICB7XG4gICAgICAgICAgICB0eXBlOiczJyxcbiAgICAgICAgfSxcbiAgICAgICAge1xuICAgICAgICAgICAgdHlwZTonNCcsXG4gICAgICAgICAgICBhbnN3ZXJWaXNhYmxlMTonZ29uZScsXG4gICAgICAgICAgICBhbnN3ZXJWaXNhYmxlMjonZ29uZScsXG4gICAgICAgICAgICBhbnN3ZXJWaXNhYmxlMzonZ29uZScsXG4gICAgICAgICAgICBhbnN3ZXJWaXNhYmxlNDonZ29uZScsXG4gICAgICAgICAgICBhbnN3ZXJWaXNhYmxlNTonZ29uZScsXG4gICAgICAgICAgICBxYUljb24xOlwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIixcbiAgICAgICAgICAgIHFhSWNvbjI6XCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiLFxuICAgICAgICAgICAgcWFJY29uMzpcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCIsXG4gICAgICAgICAgICBxYUljb240OlwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIixcbiAgICAgICAgICAgIHFhSWNvbjU6XCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiLFxuICAgICAgICB9XG4gICAgXTtcbn1cblxuZnVuY3Rpb24gY2xpY2tRQShpbmRleCkge1xuICAgIHZhciBkYXRhID0gbW9kdWxlRGF0YS5tYWluRGF0YVttb2R1bGVEYXRhLm1haW5EYXRhLmxlbmd0aCAtMV07XG4gICAgaWYgKGRhdGEudHlwZSAhPSAnNCcpIHJldHVybjtcbiAgICB2YXIgY3VyS2V5ID0gJ2Fuc3dlclZpc2FibGUnICsgaW5kZXg7XG4gICAgdmFyIGN1clZhbHVlID0gZGF0YVtjdXJLZXldO1xuICAgIGRhdGEuYW5zd2VyVmlzYWJsZTEgPSAnZ29uZSc7XG4gICAgZGF0YS5hbnN3ZXJWaXNhYmxlMiA9ICdnb25lJztcbiAgICBkYXRhLmFuc3dlclZpc2FibGUzID0gJ2dvbmUnO1xuICAgIGRhdGEuYW5zd2VyVmlzYWJsZTQgPSAnZ29uZSc7XG4gICAgZGF0YS5hbnN3ZXJWaXNhYmxlNSA9ICdnb25lJztcbiAgICBkYXRhLnFhSWNvbjEgPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCI7XG4gICAgZGF0YS5xYUljb24yID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiO1xuICAgIGRhdGEucWFJY29uMyA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX3NoYXJrX2hvbWVfcWFfc3ByZWFkX2ljb25cIjtcbiAgICBkYXRhLnFhSWNvbjQgPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zaGFya19ob21lX3FhX3NwcmVhZF9pY29uXCI7XG4gICAgZGF0YS5xYUljb241ID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9zcHJlYWRfaWNvblwiO1xuICAgIGlmIChjdXJWYWx1ZSA9PSAnZ29uZScpIHtcbiAgICAgICAgZGF0YVtjdXJLZXldID0gJ3Zpc2libGUnO1xuICAgICAgICBkYXRhWydxYUljb24nICsgaW5kZXhdID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc2hhcmtfaG9tZV9xYV9yZXRyYWN0X2ljb25cIjtcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlcXVlc3RDb2luRGF0YXMoKSB7XG4gICAgY29tbW9uLnNob3dMb2FkaW5nKHRydWUpO1xuICAgIGNvbnN0IGRhdGEgPSBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3QoJy9vcHRpb24vdjIvcHJlL2Rjdy10YWItbmF2Jyk7XG4gICAgY29tbW9uLnNob3dMb2FkaW5nKGZhbHNlKTtcbiAgICB2YXIgZGF0YUxpc3QgPSBbXTtcbiAgICBpZiAoZGF0YSAmJiBkYXRhLm5hdmlnYXRpb25zLmxlbmd0aCkge1xuICAgICAgICBjb25zdCBsaXN0ID0gZGF0YS5uYXZpZ2F0aW9ucztcbiAgICAgICAgZm9yICh2YXIgaSA9IDA7IGkgPCBsaXN0Lmxlbmd0aDsgaSsrKSB7XG4gICAgICAgICAgICBjb25zdCBjdXJEYXRhID0gIGxpc3RbaV07XG4gICAgICAgICAgICB2YXIgb2JqZWN0ID0ge307XG4gICAgICAgICAgICBvYmplY3QudHlwZSA9ICcxJztcbiAgICAgICAgICAgIG9iamVjdC5pbmRleCA9IGk7XG4gICAgICAgICAgICBvYmplY3QuZm9sZGVkVmlzaWJsZSA9ICd2aXNpYmxlJyxcbiAgICAgICAgICAgIG9iamVjdC51bmZvbGRlZFZpc2libGUgPSAnZ29uZScsXG4gICAgICAgICAgICBvYmplY3QuY29pbk5hbWUgPSBjdXJEYXRhLmN1cnJlbmN5LnRvVXBwZXJDYXNlKCk7XG4gICAgICAgICAgICBvYmplY3QubWFpbkljb24gPSBjb21tb24uZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3koY3VyRGF0YS5jdXJyZW5jeSk7XG4gICAgICAgICAgICBmb3IgKHZhciBqID0gMDsgaiA8IGN1ckRhdGEuaXRlbXMubGVuZ3RoOyBqKyspIHtcbiAgICAgICAgICAgICAgICBjb25zdCBpdGVtID0gY3VyRGF0YS5pdGVtc1tqXTtcbiAgICAgICAgICAgICAgICBpZiAoaXRlbVsncHJvZHVjdC10eXBlLWlkJ10gPT0gJzUnKSB7Ly/mioTlupXlrp1cbiAgICAgICAgICAgICAgICAgICAgb2JqZWN0W2BkZXNjVGV4dCR7aisxfWBdID0gICRpMThuLiRpbnRlcmNlcHQubl9kb3VibGVfY29pbl9lYXJuX2xvd19idXkob2JqZWN0LmNvaW5OYW1lKTtcbiAgICAgICAgICAgICAgICAgICAgb2JqZWN0W2BiaWdJY29uJHtqKzF9YF0gPSAgY29tbW9uLmdldFBOR0ljb25VUkxCeUN1cnJlbmN5KGl0ZW1bJ2Jhc2UtY3VycmVuY3knXSk7XG4gICAgICAgICAgICAgICAgICAgIG9iamVjdFtgc21hbGxJY29uJHtqKzF9YF0gPSAgY29tbW9uLmdldFBOR0ljb25VUkxCeUN1cnJlbmN5KGl0ZW1bJ3F1b3RlLWN1cnJlbmN5J10pO1xuICAgICAgICAgICAgICAgICAgICBvYmplY3RbJ3N1cHBvcnQtcXVvdGVzLWJ1eSddID0gaXRlbVsnc3VwcG9ydC1xdW90ZXMnXTtcbiAgICAgICAgICAgICAgICB9IGVsc2UgaWYgKGl0ZW1bJ3Byb2R1Y3QtdHlwZS1pZCddID09ICc2Jykgey8v5q2i55uI5a6dXG4gICAgICAgICAgICAgICAgICAgIG9iamVjdFtgZGVzY1RleHQke2orMX1gXSA9ICAkaTE4bi4kaW50ZXJjZXB0Lm5fZG91YmxlX2NvaW5fZWFybl9oaWdoX3NlbGwob2JqZWN0LmNvaW5OYW1lKTtcbiAgICAgICAgICAgICAgICAgICAgb2JqZWN0W2BzbWFsbEljb24ke2orMX1gXSA9IGNvbW1vbi5nZXRQTkdJY29uVVJMQnlDdXJyZW5jeShpdGVtWydiYXNlLWN1cnJlbmN5J10pO1xuICAgICAgICAgICAgICAgICAgICBvYmplY3RbYGJpZ0ljb24ke2orMX1gXSA9ICBjb21tb24uZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3koaXRlbVsncXVvdGUtY3VycmVuY3knXSk7XG4gICAgICAgICAgICAgICAgICAgIG9iamVjdFsnc3VwcG9ydC1xdW90ZXMtc2VsbCddID0gaXRlbVsnc3VwcG9ydC1xdW90ZXMnXTtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgdmFyIGlkeFN0ciA9IChqICsgMSkgKyAnJztcbiAgICAgICAgICAgICAgICBvYmplY3RbIFwieWllbGRUZXh0XCIgKyBpZHhTdHJdID0gIGl0ZW1bJ2Fyci1yYW5nZSddO1xuICAgICAgICAgICAgICAgIG9iamVjdFtcInByb2R1Y3RUeXBlSWRcIiArIGlkeFN0cl0gPSBpdGVtWydwcm9kdWN0LXR5cGUtaWQnXTtcbiAgICAgICAgICAgICAgICBvYmplY3RbJ2N1cnJlbmN5J10gPSBpdGVtWydiYXNlLWN1cnJlbmN5J107XG5cblxuICAgICAgICAgICAgfVxuICAgICAgICAgICAgZGF0YUxpc3QucHVzaChvYmplY3QpO1xuICAgICAgICB9XG4gICAgfSBlbHNlIHtcbiAgICAgICAgZGF0YUxpc3QucHVzaCh7XG4gICAgICAgICAgICB0eXBlOic1J1xuICAgICAgICB9KTtcbiAgICB9XG4gICAgZGF0YUxpc3QgPSBkYXRhTGlzdC5jb25jYXQoZ2V0U3VwcGxlbWVudERhdGEoKSk7XG4gICAgXG4gICAgbW9kdWxlRGF0YS5tYWluRGF0YSA9IGRhdGFMaXN0O1xufVxuXG5mdW5jdGlvbiBjbGlja0l0ZW0oaW5kZXgpIHtcbiAgICB2YXIgY3VyRGF0YSA9ICBtb2R1bGVEYXRhLm1haW5EYXRhW3BhcnNlSW50KGluZGV4KV07XG4gICAgaWYgKGN1ckRhdGEudW5mb2xkZWRWaXNpYmxlID09ICdnb25lJykge1xuICAgICAgICBjdXJEYXRhLnVuZm9sZGVkVmlzaWJsZSA9ICd2aXNpYmxlJztcbiAgICAgICAgY3VyRGF0YS5mb2xkZWRWaXNpYmxlID0gJ2dvbmUnO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIGN1ckRhdGEuZm9sZGVkVmlzaWJsZSA9ICd2aXNpYmxlJztcbiAgICAgICAgY3VyRGF0YS51bmZvbGRlZFZpc2libGUgPSAnZ29uZSc7XG4gICAgfVxufVxuXG5mdW5jdGlvbiB0b0N1c3RvbVByb2plY3QoKSB7XG4gICAgY29tbW9uLm9wZW5VUkwoJ2hvbGlnZWl0Oi8vb3Blbi92MT9sb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vZWRnZWVuZ2luZS9jb250YWluZXI/c2NlbmU9ZG91YmxlY29pbiZyb290TmFtZT1jdXN0b20mbmF2Q29uZmlnPW5hdGl2ZScpO1xufVxuXG5mdW5jdGlvbiByaWdodEJ0bkNsaWNrZWQoKSB7XG4gICAgY29tbW9uLm9wZW5VUkwoJ2hvbGlnZWl0Oi8vb3Blbi92MT9sb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vZWRnZWVuZ2luZS9jb250YWluZXI/c2NlbmU9ZG91YmxlY29pbiZyb290TmFtZT1yZXN1bHQmbmF2Q29uZmlnPSZtb25leT0xNUJDSCcpO1xufVxuXG5mdW5jdGlvbiByZWZyZXNoKCkge1xuICAgIHJlcXVlc3RDb2luRGF0YXMoKTtcbiAgICBtb2R1bGVEYXRhLnJlZnJlc2ggPSAnMic7XG59XG5cbmZ1bmN0aW9uIHRvSW50cm9kdWNlKCkge1xuICAgIGNvbW1vbi5vcGVuVVJMKFwiaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9lZGdlZW5naW5lL2NvbnRhaW5lcj9zY2VuZT1kb3VibGVjb2luJnJvb3ROYW1lPWludHJvZHVjZSZuYXZDb25maWc9bmF0aXZlJmluZGV4PTBcIik7XG59XG5cbmZ1bmN0aW9uIHRvRGV0YWlsKGluZGV4LHR5cGUpIHtcbiAgICB2YXIgY3VyRGF0YSA9ICBtb2R1bGVEYXRhLm1haW5EYXRhW3BhcnNlSW50KGluZGV4KV07XG4gICAgY29uc3QgcHJvZHVjdFR5cGVJZCA9IHR5cGU7XG4gICAgY29uc3QgY3VycmVuY3kgPSBjdXJEYXRhWydjdXJyZW5jeSddO1xuICAgIHZhciBhcnIgPSBbXTtcbiAgICBpZiAocGFyc2VJbnQodHlwZSkgPT0gJzUnKSB7XG4gICAgICAgIGFyciA9IGN1ckRhdGFbJ3N1cHBvcnQtcXVvdGVzLWJ1eSddO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIGFyciA9IGN1ckRhdGFbJ3N1cHBvcnQtcXVvdGVzLXNlbGwnXTtcbiAgICB9XG4gICAgdmFyIHN1cHBvcnRRdW90ZXMgPSAnJztcbiAgICBmb3IgKHZhciBpID0gMDsgaSA8IGFyci5sZW5ndGg7IGkrKykge1xuICAgICAgICBzdXBwb3J0UXVvdGVzID0gc3VwcG9ydFF1b3RlcyArIGFycltpXTtcbiAgICAgICAgaWYgKGkgIT0gYXJyLmxlbmd0aCAtMSkge1xuICAgICAgICAgICAgc3VwcG9ydFF1b3RlcyA9IHN1cHBvcnRRdW90ZXMgKyAnLSc7XG4gICAgICAgIH1cbiAgICB9XG4gICAgY29uc3QgdXJsID0gXCJob2xpZ2VpdDovL29wZW4vdjE/bG9naW49MSZ1cmw9aWh1b2JpZ2xvYmFsOi8vbS5oYmcuY29tL2VkZ2VlbmdpbmUvY29udGFpbmVyP3NjZW5lPWRvdWJsZWNvaW4mcm9vdE5hbWU9Y29pbmRldGFpbCZuYXZDb25maWc9bmF0aXZlXCI7XG4gICAgY29tbW9uLm9wZW5VUkwoYCR7dXJsfSZwcm9kdWN0VHlwZUlkPSR7cHJvZHVjdFR5cGVJZH0mY3VycmVuY3k9JHtjdXJyZW5jeX0mc3VwcG9ydFF1b3Rlcz0ke3N1cHBvcnRRdW90ZXN9YCk7XG59XG5cblxuXG5tb2R1bGVFdmVudC5yaWdodEJ0bkNsaWNrZWQgPSByaWdodEJ0bkNsaWNrZWQ7XG5tb2R1bGVFdmVudC5jbGlja1FBID0gY2xpY2tRQTtcbm1vZHVsZUV2ZW50LnJlZnJlc2ggPSByZWZyZXNoO1xubW9kdWxlRXZlbnQuY2xpY2tJdGVtID0gY2xpY2tJdGVtO1xubW9kdWxlRXZlbnQudG9DdXN0b21Qcm9qZWN0ID0gdG9DdXN0b21Qcm9qZWN0O1xubW9kdWxlRXZlbnQudG9JbnRyb2R1Y2UgPSB0b0ludHJvZHVjZTtcbm1vZHVsZUV2ZW50LnRvRGV0YWlsID0gdG9EZXRhaWw7IiwiXG5pbXBvcnQgKiBhcyBjb21tb24gZnJvbSBcIi4vY29tbW9uXCI7XG5pbXBvcnQgKiBhcyBudW1iZXIgZnJvbSBcIi4vbnVtYmVyXCI7XG5cbmZ1bmN0aW9uIGRlZmF1bHREYXRhKCkge1xuICAgIHJldHVybiB7XG4gICAgICAgIG5hdmlnYXRpb25zOiBbXSxcbiAgICAgICAgaXRlbXM6IFtdLFxuICAgICAgICBzZWxlY3RlZEl0ZW06IHt9LFxuICAgICAgICBmb290ZXJIZWlnaHQ6IDU2LFxuICAgICAgICBjb2luQ2hvc2VBbGVydFNob3c6ICdmYWxzZScsXG4gICAgICAgIGNvaW5DaG9zZUFsZXJ0SGVpZ2h0OiAwLFxuICAgICAgICB0eXBlQ2hvc2VBbGVydFNob3c6ICdmYWxzZScsXG4gICAgICAgIHR5cGVDaG9zZUFsZXJ0SGVpZ2h0OiAwLFxuICAgICAgICBzZWxlY3RlZENvaW46ICcnLFxuICAgICAgICBiaWdJY29uOiAnJyxcbiAgICAgICAgc21hbGxJY29uOiAnJyxcbiAgICAgICAgc2VsZWN0ZWRUeXBlOiAnJyxcbiAgICAgICAgc2VsZWN0ZWREYXRlOiAkaTE4bi5uX2RvdWJsZV9jb2luX2Vhcm5fc2VsZWN0X2V4cGlyZV9kYXRlLFxuICAgICAgICBzZWxlY3RlZFRpbWU6IDAsLy/mr6vnp5JcbiAgICAgICAgc2VsZWN0ZWREYXRlQ29sb3I6ICdAY29sb3IvZUJhc2VDb2xvclRocmVlTGV2ZWxUZXh0JyxcbiAgICAgICAgY29pbkluZGV4UHJpY2U6ICctLScsXG4gICAgICAgIHByb2R1Y3REYXRlOiAnJyxcbiAgICAgICAgcHJpY2VSYW5nZTogJycsXG4gICAgICAgIGNsZWFyVmlzaWJpbGl0eTogJ2dvbmUnLFxuICAgICAgICBvbkZvY3VzOiBmYWxzZSxcbiAgICAgICAgdGFyZ2V0UHJpY2VUZXh0OiAnJyxcbiAgICAgICAgZWRpdEVycm9yU2hvdzogJ2dvbmUnLFxuICAgICAgICBlZGl0VGV4dEJvcmRlckNvbG9yOiAnQGNvbG9yL0tCYXNlQ29sb3JJbnB1dEJhY2tncm91bmQnLFxuICAgICAgICBwcm9kdWN0WWllbGQ6ICcnLFxuICAgICAgICBwcm9kdWN0WWllbGRWaXNpYmxlOiAnZ29uZScsXG4gICAgICAgIGJ0bkJnQ29sb3I6ICdAY29sb3IvYmFzZUNvbG9yVGhyZWVMZXZlbFRleHQnLFxuICAgICAgICBjdXJyZW50VGltZTogLTEsXG4gICAgfTtcbn1cblxuZnVuY3Rpb24gZ2V0TmF2Q29uZmlnU3RyaW5nKCkge1xuICAgIHJldHVybiB7XG4gICAgICAgICd0aXRsZUtleSc6ICduX2RvdWJsZV9jb2luX2Vhcm5fcHJvZHVjdF9jdXN0b20nLFxuICAgICAgICAnbGVmdCc6IHtcbiAgICAgICAgICAgICdhY3Rpb24nOiB7XG4gICAgICAgICAgICAgICAgJ3R5cGUnOiAnYmFjaycsXG4gICAgICAgICAgICAgICAgJ3BhcmFtZXRlcic6ICcnXG4gICAgICAgICAgICB9LFxuICAgICAgICAgICAgJ2ljb24nOiAnZWRnZV9lbmdpbmVfdG9wX2Jhcl9iYWNrX25vcm1hbCdcbiAgICAgICAgfSxcbiAgICAgICAgJ2JhY2tncm91bmRDb2xvcic6ICdLQmFzZUNvbG9yQ29udGVudEJhY2tncm91bmQnXG4gICAgfTtcbn1cblxuY29uc3QgeyBtb2R1bGVEYXRhLCBtb2R1bGVFdmVudCB9ID0gY29tbW9uLm1vZHVsZURlZmluZShcImN1c3RvbVwiLCBkZWZhdWx0RGF0YSwgeyBvbkNyZWF0ZSwgb25EZXN0cm95IH0pO1xuXG4vL+aMh+aVsOe6p+i9ruiureWZqFxubGV0IGluZGV4UHJpY2VUaW1lcjtcblxubGV0IHBhcmFtZXRlcjtcblxudmFyIHByb2R1Y3RZaWVsZEVycm9yID0gZmFsc2VcblxuZnVuY3Rpb24gb25DcmVhdGUoanNvblBhcmFtZXRlcnMpIHtcbiAgICBjb25zb2xlLmxvZyhgaG9tZSBvbkNyZWF0ZSA6ICR7anNvblBhcmFtZXRlcnN9YCk7XG4gICAgcGFyYW1ldGVyID0gSlNPTi5wYXJzZShqc29uUGFyYW1ldGVycyk7XG4gICAgbW9kdWxlRGF0YS5zdGF0dXNCYXJDb25maWcgPSB7IFwic3RhdHVzQmFyTW9kZVwiOiBcInRydWVcIiwgXCJhZFN0YXR1c0JhckNvbG9yXCI6IFwiS0Jhc2VDb2xvckNvbnRlbnRCYWNrZ3JvdW5kXCIsIFwia2V5Qm9hcmRNb2RlXCI6IFwiYWRqdXN0UGFuXCIgfTtcbiAgICBtb2R1bGVEYXRhLm5hdkNvbmZpZyA9IGdldE5hdkNvbmZpZ1N0cmluZygpO1xuICAgIHJlcXVlc3REYXRhKCk7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlcXVlc3REYXRhKCkge1xuICAgIGNvbW1vbi5zaG93TG9hZGluZyh0cnVlKTtcbiAgICBjb25zb2xlLmxvZyhgcmVxdWVzdERhdGEgOiBzdGFydGApO1xuICAgIGNvbnN0IGRhdGEgPSBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3QoJ290Yy9vcHQvb3B0aW9uL3YxL3ByZS9kY3ctdGFiLW5hdi9jdXN0b20nKTtcbiAgICBjb25zb2xlLmxvZyhgcmVxdWVzdERhdGEgOiBkb25lYCk7XG4gICAgdmFyIGRhdGFMaXN0ID0gW107XG4gICAgaWYgKGRhdGEgJiYgZGF0YS5uYXZpZ2F0aW9ucy5sZW5ndGgpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5jdXJyZW50VGltZSA9IGRhdGFbXCJjdXJyLXRpbWVcIl07XG4gICAgICAgIGNvbnN0IGxpc3QgPSBkYXRhLm5hdmlnYXRpb25zO1xuICAgICAgICBmb3IgKHZhciBpID0gMDsgaSA8IGxpc3QubGVuZ3RoOyBpKyspIHtcbiAgICAgICAgICAgIGNvbnN0IGN1ckRhdGEgPSBsaXN0W2ldO1xuICAgICAgICAgICAgdmFyIG9iamVjdCA9IHt9O1xuICAgICAgICAgICAgb2JqZWN0LnR5cGUgPSAnMSc7XG4gICAgICAgICAgICBvYmplY3QuaW5kZXggPSBpO1xuICAgICAgICAgICAgb2JqZWN0LnNlbGVjdGVkID0gJ2dvbmUnO1xuICAgICAgICAgICAgb2JqZWN0LmRpYWxvZ1RleHRDb2xvciA9IFwiQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0XCI7XG4gICAgICAgICAgICBvYmplY3QuY29pbk5hbWUgPSBjdXJEYXRhLmN1cnJlbmN5LnRvVXBwZXJDYXNlKCk7XG4gICAgICAgICAgICBvYmplY3QubWFpbkljb24gPSBjb21tb24uZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3koY3VyRGF0YS5jdXJyZW5jeSk7XG4gICAgICAgICAgICBvYmplY3QuY3VycmVuY3kgPSBjdXJEYXRhLmN1cnJlbmN5O1xuICAgICAgICAgICAgZm9yICh2YXIgaiA9IDA7IGogPCBjdXJEYXRhLml0ZW1zLmxlbmd0aDsgaisrKSB7XG4gICAgICAgICAgICAgICAgdmFyIHN1Yk9iamVjdCA9IGN1ckRhdGEuaXRlbXNbal07XG4gICAgICAgICAgICAgICAgc3ViT2JqZWN0LnR5cGUgPSBcIjFcIlxuICAgICAgICAgICAgICAgIHN1Yk9iamVjdC5pbmRleCA9IGo7XG4gICAgICAgICAgICAgICAgc3ViT2JqZWN0LnNlbGVjdGVkID0gJ2dvbmUnO1xuICAgICAgICAgICAgICAgIHN1Yk9iamVjdC5kaWFsb2dUZXh0Q29sb3IgPSBcIkBjb2xvci9rQ29sb3JQcmltYXJ5VGV4dFwiO1xuICAgICAgICAgICAgICAgIGlmIChzdWJPYmplY3RbJ3Byb2R1Y3QtdHlwZS1pZCddID09ICc1Jykgey8v5oqE5bqV5a6dXG4gICAgICAgICAgICAgICAgICAgIHN1Yk9iamVjdC50eXBlRGVzYyA9ICRpMThuLiRpbnRlcmNlcHQubl9kb3VibGVfY29pbl9lYXJuX2xvd19idXlfc29tZXRoaW5nKHN1Yk9iamVjdFsncXVvdGUtY3VycmVuY3knXS50b1VwcGVyQ2FzZSgpLCBzdWJPYmplY3RbJ2Jhc2UtY3VycmVuY3knXS50b1VwcGVyQ2FzZSgpKTtcbiAgICAgICAgICAgICAgICAgICAgc3ViT2JqZWN0LmJpZ0ljb24gPSBjb21tb24uZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3koc3ViT2JqZWN0WydxdW90ZS1jdXJyZW5jeSddKTtcbiAgICAgICAgICAgICAgICAgICAgc3ViT2JqZWN0LnNtYWxsSWNvbiA9IGNvbW1vbi5nZXRQTkdJY29uVVJMQnlDdXJyZW5jeShzdWJPYmplY3RbJ2Jhc2UtY3VycmVuY3knXSk7XG4gICAgICAgICAgICAgICAgfSBlbHNlIGlmIChzdWJPYmplY3RbJ3Byb2R1Y3QtdHlwZS1pZCddID09ICc2Jykgey8v5q2i55uI5a6dXG4gICAgICAgICAgICAgICAgICAgIHN1Yk9iamVjdC50eXBlRGVzYyA9ICRpMThuLiRpbnRlcmNlcHQubl9kb3VibGVfY29pbl9lYXJuX2hpZ2hfc2VsbF9mb3Ioc3ViT2JqZWN0WydiYXNlLWN1cnJlbmN5J10udG9VcHBlckNhc2UoKSwgc3ViT2JqZWN0WydxdW90ZS1jdXJyZW5jeSddLnRvVXBwZXJDYXNlKCkpO1xuICAgICAgICAgICAgICAgICAgICBzdWJPYmplY3QuYmlnSWNvbiA9IGNvbW1vbi5nZXRQTkdJY29uVVJMQnlDdXJyZW5jeShzdWJPYmplY3RbJ2Jhc2UtY3VycmVuY3knXSk7XG4gICAgICAgICAgICAgICAgICAgIHN1Yk9iamVjdC5zbWFsbEljb24gPSBjb21tb24uZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3koc3ViT2JqZWN0WydxdW90ZS1jdXJyZW5jeSddKTtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBvYmplY3QuaXRlbXMgPSBjdXJEYXRhLml0ZW1zO1xuICAgICAgICAgICAgZGF0YUxpc3QucHVzaChvYmplY3QpO1xuICAgICAgICB9XG4gICAgfSBlbHNlIHtcbiAgICAgICAgZXJyb3JCYWNrKCk7XG4gICAgfVxuICAgIGlmIChkYXRhTGlzdC5sZW5ndGggPD0gMCkge1xuICAgICAgICBlcnJvckJhY2soKTtcbiAgICB9XG4gICAgbW9kdWxlRGF0YS5mb290ZXJIZWlnaHQgPSBjb21tb24uY29tbW9uRGF0YS5ib3R0b21TYWZlQXJlYUhlaWdodCArIDU2O1xuICAgIHZhciBsZW5ndGggPSBkYXRhTGlzdC5sZW5ndGggPiA4ID8gOCA6IGRhdGFMaXN0Lmxlbmd0aDtcbiAgICBtb2R1bGVEYXRhLmNvaW5DaG9zZUFsZXJ0SGVpZ2h0ID0gbGVuZ3RoICogNTYgKyA2NCArIGNvbW1vbi5jb21tb25EYXRhLmJvdHRvbVNhZmVBcmVhSGVpZ2h0O1xuICAgIG1vZHVsZURhdGEubmF2aWdhdGlvbnMgPSBkYXRhTGlzdDtcbiAgICB2YXIgY3VyT2JqZWN0O1xuICAgIGlmIChwYXJhbWV0ZXIuY3VycmVuY3kpIHtcbiAgICAgICAgZm9yICh2YXIgaSA9IDA7IGkgPCBtb2R1bGVEYXRhLm5hdmlnYXRpb25zLmxlbmd0aDsgaSsrKSB7XG4gICAgICAgICAgICBpZiAobW9kdWxlRGF0YS5uYXZpZ2F0aW9uc1tpXS5jb2luTmFtZS50b1VwcGVyQ2FzZSgpID09IHBhcmFtZXRlci5jdXJyZW5jeS50b1VwcGVyQ2FzZSgpKSB7XG4gICAgICAgICAgICAgICAgY3VyT2JqZWN0ID0gbW9kdWxlRGF0YS5uYXZpZ2F0aW9uc1tpXTtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgIH1cbiAgICBpZiAoIWN1ck9iamVjdCkge1xuICAgICAgICBjdXJPYmplY3QgPSBtb2R1bGVEYXRhLm5hdmlnYXRpb25zWzBdO1xuICAgIH1cbiAgICBjdXJPYmplY3Quc2VsZWN0ZWQgPSAndmlzaWJsZSc7XG4gICAgY3VyT2JqZWN0LmRpYWxvZ1RleHRDb2xvciA9IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIjtcbiAgICBtb2R1bGVEYXRhLmN1ckRhdGEgPSBjdXJPYmplY3Q7XG4gICAgbW9kdWxlRGF0YS5zZWxlY3RlZENvaW4gPSBjdXJPYmplY3QuY29pbk5hbWU7XG4gICAgbW9kdWxlRGF0YS5zZWxlY3RlZEljb24gPSBjdXJPYmplY3QubWFpbkljb247XG4gICAgaWYgKGN1ck9iamVjdC5pdGVtcy5sZW5ndGggPD0gMCkge1xuICAgICAgICBlcnJvckJhY2soKTtcbiAgICB9XG4gICAgbW9kdWxlRGF0YS50eXBlQ2hvc2VBbGVydEhlaWdodCA9IGN1ck9iamVjdC5pdGVtcy5sZW5ndGggKiA1NiArIDY0ICsgY29tbW9uLmNvbW1vbkRhdGEuYm90dG9tU2FmZUFyZWFIZWlnaHQ7XG4gICAgbW9kdWxlRGF0YS5pdGVtcyA9IGN1ck9iamVjdC5pdGVtcztcbiAgICB2YXIgc3ViT2JqZWN0ID0gbW9kdWxlRGF0YS5pdGVtc1swXTtcbiAgICBmb3IgKHZhciBpID0gMDsgaSA8IG1vZHVsZURhdGEuaXRlbXMubGVuZ3RoOyBpKyspIHtcbiAgICAgICAgdmFyIGl0ZW0gPSBtb2R1bGVEYXRhLml0ZW1zW2ldO1xuICAgICAgICBjb25zb2xlLmxvZyhg6YCJ5Lit57G75Z6LICAgJHtpdGVtW1wicHJvZHVjdC10eXBlLWlkXCJdfSAtLS0tLSAgICR7cGFyYW1ldGVyLnByb2R1Y3RUeXBlSWR9YCk7XG4gICAgICAgIGNvbnNvbGUubG9nKGDpgInkuK3nsbvlnosgICAke2l0ZW1bXCJxdW90ZS1jdXJyZW5jeVwiXX0gLS0tLS0gICAke3BhcmFtZXRlci5xdW90ZUNvaW59YCk7XG4gICAgICAgIGlmIChpdGVtW1wicHJvZHVjdC10eXBlLWlkXCJdID09IHBhcmFtZXRlci5wcm9kdWN0VHlwZUlkICYmIGl0ZW1bXCJxdW90ZS1jdXJyZW5jeVwiXSA9PSBwYXJhbWV0ZXIucXVvdGVDb2luKSB7XG4gICAgICAgICAgICBzdWJPYmplY3QgPSBpdGVtO1xuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIH1cbiAgICB9XG4gICAgY29uc3Qgc3ViSXRlbSA9IHN1Yk9iamVjdDtcbiAgICBpZiAoc3ViSXRlbVsncHJvZHVjdC10eXBlLWlkJ10gPT0gJzUnKSB7Ly/mioTlupXlrp1cbiAgICAgICAgbW9kdWxlRGF0YS5zZWxlY3RlZFR5cGUgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fZG91YmxlX2NvaW5fZWFybl9sb3dfYnV5X3NvbWV0aGluZyhzdWJJdGVtWydxdW90ZS1jdXJyZW5jeSddLnRvVXBwZXJDYXNlKCksIHN1Ykl0ZW1bJ2Jhc2UtY3VycmVuY3knXS50b1VwcGVyQ2FzZSgpKTtcbiAgICAgICAgbW9kdWxlRGF0YS5iaWdJY29uID0gY29tbW9uLmdldFBOR0ljb25VUkxCeUN1cnJlbmN5KHN1Ykl0ZW1bJ3F1b3RlLWN1cnJlbmN5J10pO1xuICAgICAgICBtb2R1bGVEYXRhLnNtYWxsSWNvbiA9IGNvbW1vbi5nZXRQTkdJY29uVVJMQnlDdXJyZW5jeShzdWJJdGVtWydiYXNlLWN1cnJlbmN5J10pO1xuICAgIH0gZWxzZSBpZiAoc3ViSXRlbVsncHJvZHVjdC10eXBlLWlkJ10gPT0gJzYnKSB7Ly/mraLnm4jlrp1cbiAgICAgICAgbW9kdWxlRGF0YS5zZWxlY3RlZFR5cGUgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fZG91YmxlX2NvaW5fZWFybl9oaWdoX3NlbGxfZm9yKHN1Ykl0ZW1bJ2Jhc2UtY3VycmVuY3knXS50b1VwcGVyQ2FzZSgpLCBzdWJJdGVtWydxdW90ZS1jdXJyZW5jeSddLnRvVXBwZXJDYXNlKCkpO1xuICAgICAgICBtb2R1bGVEYXRhLmJpZ0ljb24gPSBjb21tb24uZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3koc3ViSXRlbVsnYmFzZS1jdXJyZW5jeSddKTtcbiAgICAgICAgbW9kdWxlRGF0YS5zbWFsbEljb24gPSBjb21tb24uZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3koc3ViSXRlbVsncXVvdGUtY3VycmVuY3knXSk7XG4gICAgfVxuICAgIHN1Yk9iamVjdC5zZWxlY3RlZCA9ICd2aXNpYmxlJztcbiAgICBzdWJPYmplY3QuZGlhbG9nVGV4dENvbG9yID0gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiO1xuICAgIHNldFNlbGVjdGVkSXRlbShzdWJPYmplY3QpO1xuICAgIGNvbW1vbi5zaG93TG9hZGluZyhmYWxzZSk7XG4gICAgY29uc29sZS5sb2coYHJlcXVlc3REYXRhIDog5by556qXZG9uZWApO1xufVxuXG5mdW5jdGlvbiBpbnRlcnZhbFJlcXVlc3RJbmRleFByaWNlKCkge1xuICAgIGlmIChpbmRleFByaWNlVGltZXIgPT0gbnVsbCkge1xuICAgICAgICByZXF1ZXN0SW5kZXhQcmljZSgpO1xuICAgICAgICBpbmRleFByaWNlVGltZXIgPSBzZXRJbnRlcnZhbChyZXF1ZXN0SW5kZXhQcmljZSwgNTAwMCk7XG4gICAgfVxufVxuXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0SW5kZXhQcmljZSgpIHtcbiAgICBjb25zdCBkYXRhID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KCdvdGMvb3B0L29wdGlvbi92MS9wcmUvaW5kZXgnLCB7IHN5bWJvbDogYCR7bW9kdWxlRGF0YS5zZWxlY3RlZEl0ZW1bJ2Jhc2UtY3VycmVuY3knXX0ke21vZHVsZURhdGEuc2VsZWN0ZWRJdGVtWydxdW90ZS1jdXJyZW5jeSddfWAgfSk7XG4gICAgaWYgKGRhdGEpIHtcbiAgICAgICAgY29uc29sZS5sb2coYGluZGV4UHJpY2UgOiAke2RhdGF9YCk7XG4gICAgICAgIHVwZGF0ZUluZGV4UHJpY2UoZGF0YSk7XG4gICAgfVxufVxuXG5mdW5jdGlvbiB1cGRhdGVJbmRleFByaWNlKHByaWNlKSB7XG4gICAgbW9kdWxlRGF0YS5jb2luSW5kZXhQcmljZSA9ICRpMThuLiRpbnRlcmNlcHQubl9kb3VibGVfY29pbl9lYXJuX3F1YW50aXR5X3ByaWNlKG1vZHVsZURhdGEuc2VsZWN0ZWRJdGVtWydjdXJyZW5jeSddLnRvVXBwZXJDYXNlKCksIHByaWNlKTtcbiAgICBpZiAocHJpY2UgIT0gJy0tJyAmJiBwcmljZSAhPSAnJykge1xuICAgICAgICBpZiAobW9kdWxlRGF0YS5zZWxlY3RlZEl0ZW1bJ3Byb2R1Y3QtdHlwZS1pZCddID09ICc1Jykge1xuICAgICAgICAgICAgY29uc3QgbG93UmF0ZSA9IDEgLSBwYXJzZUZsb2F0KG1vZHVsZURhdGEuc2VsZWN0ZWRJdGVtWydib3R0b20tbG93LWxpbWl0LXByaWNlLXJhdGUnXSk7XG4gICAgICAgICAgICBjb25zdCB1cHBlclJhdGUgPSAxIC0gcGFyc2VGbG9hdChtb2R1bGVEYXRhLnNlbGVjdGVkSXRlbVsnYm90dG9tLXVwcGVyLWxpbWl0LXByaWNlLXJhdGUnXSk7XG4gICAgICAgICAgICB2YXIgcGVyc2lvbiA9IDA7XG4gICAgICAgICAgICBpZiAobW9kdWxlRGF0YS5zZWxlY3RlZEl0ZW1bJ2Jhc2UtY3VycmVuY3knXSAhPSAnYnRjJyAmJiBtb2R1bGVEYXRhLnNlbGVjdGVkSXRlbVsnYmFzZS1jdXJyZW5jeSddICE9ICdldGgnKSB7XG4gICAgICAgICAgICAgICAgcGVyc2lvbiA9IDI7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgdXBkYXRlSW5kZXhQcmljZSAtLS0+ICR7bW9kdWxlRGF0YS5zZWxlY3RlZEl0ZW1bJ2Jhc2UtY3VycmVuY3knXX0gICBwZXJzaW9uIDogJHtwZXJzaW9ufWApO1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5sb3dQcmljZSA9IGNvbW1vbi5mb3JtYXRQcmVjaXNpb24obnVtYmVyLm11bHRpcGx5KHByaWNlLCBsb3dSYXRlKSwgcGVyc2lvbik7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLmhpZ2hQcmljZSA9IGNvbW1vbi5mb3JtYXRQcmVjaXNpb24obnVtYmVyLm11bHRpcGx5KHByaWNlLCB1cHBlclJhdGUpLCBwZXJzaW9uKTtcbiAgICAgICAgICAgIG1vZHVsZURhdGEucHJpY2VSYW5nZSA9ICRpMThuLiRpbnRlcmNlcHQubl9kb3VibGVfY29pbl9lYXJuX3ByaWNlX3JhbmdlKGAke21vZHVsZURhdGEubG93UHJpY2V9IC0gJHttb2R1bGVEYXRhLmhpZ2hQcmljZX1gKTtcblxuICAgICAgICB9IGVsc2UgaWYgKG1vZHVsZURhdGEuc2VsZWN0ZWRJdGVtWydwcm9kdWN0LXR5cGUtaWQnXSA9PSAnNicpIHtcbiAgICAgICAgICAgIGNvbnN0IGxvd1JhdGUgPSAxICsgcGFyc2VGbG9hdChtb2R1bGVEYXRhLnNlbGVjdGVkSXRlbVsndGFyZ2V0LWxvdy1saW1pdC1wcmljZS1yYXRlJ10pO1xuICAgICAgICAgICAgY29uc3QgdXBwZXJSYXRlID0gMSArIHBhcnNlRmxvYXQobW9kdWxlRGF0YS5zZWxlY3RlZEl0ZW1bJ3RhcmdldC11cHBlci1saW1pdC1wcmljZS1yYXRlJ10pO1xuICAgICAgICAgICAgdmFyIHBlcnNpb24gPSAwO1xuICAgICAgICAgICAgaWYgKG1vZHVsZURhdGEuc2VsZWN0ZWRJdGVtWydiYXNlLWN1cnJlbmN5J10gIT0gJ2J0YycgJiYgbW9kdWxlRGF0YS5zZWxlY3RlZEl0ZW1bJ2Jhc2UtY3VycmVuY3knXSAhPSAnZXRoJykge1xuICAgICAgICAgICAgICAgIHBlcnNpb24gPSAyO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgY29uc29sZS5sb2coYHVwZGF0ZUluZGV4UHJpY2UgLS0tPiAke21vZHVsZURhdGEuc2VsZWN0ZWRJdGVtWydiYXNlLWN1cnJlbmN5J119ICAgcGVyc2lvbiA6ICR7cGVyc2lvbn1gKTtcbiAgICAgICAgICAgIG1vZHVsZURhdGEubG93UHJpY2UgPSBjb21tb24uZm9ybWF0UHJlY2lzaW9uKG51bWJlci5tdWx0aXBseShwcmljZSwgbG93UmF0ZSksIHBlcnNpb24pO1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5oaWdoUHJpY2UgPSBjb21tb24uZm9ybWF0UHJlY2lzaW9uKG51bWJlci5tdWx0aXBseShwcmljZSwgdXBwZXJSYXRlKSwgcGVyc2lvbik7XG4gICAgICAgICAgICBtb2R1bGVEYXRhLnByaWNlUmFuZ2UgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fZG91YmxlX2NvaW5fZWFybl9wcmljZV9yYW5nZShgJHttb2R1bGVEYXRhLmxvd1ByaWNlfSAtICR7bW9kdWxlRGF0YS5oaWdoUHJpY2V9YCk7XG4gICAgICAgIH1cbiAgICB9IGVsc2Uge1xuICAgICAgICBtb2R1bGVEYXRhLnByaWNlUmFuZ2UgPSAnJztcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlcXVlc3RZaWVsZCgpIHtcbiAgICBpZiAobW9kdWxlRGF0YS5zZWxlY3RlZFRpbWUgPD0gMCB8fCBtb2R1bGVEYXRhLnRhcmdldFByaWNlVGV4dCA9PSAnJyB8fCBtb2R1bGVEYXRhLnNlbGVjdGVkSXRlbSA9PSBudWxsKSB7IHJldHVybjsgfVxuICAgIHZhciBwYXJhbXMgPSB7XG4gICAgICAgIHByb2R1Y3RUeXBlSWQ6IG1vZHVsZURhdGEuc2VsZWN0ZWRJdGVtWydwcm9kdWN0LXR5cGUtaWQnXSxcbiAgICAgICAgcHJvZHVjdElkOiBtb2R1bGVEYXRhLnNlbGVjdGVkSXRlbVsncHJvZHVjdC1pZCddLFxuICAgICAgICBwcm9kdWN0RmluYW5jZUlkOiBtb2R1bGVEYXRhLnNlbGVjdGVkSXRlbVsncHJvZHVjdC1maW5hbmNlLWlkJ10sXG4gICAgfTtcbiAgICBwYXJhbXNbJ2V4cGlyZUF0J10gPSBtb2R1bGVEYXRhLnNlbGVjdGVkVGltZTtcbiAgICBwYXJhbXNbJ2hvb2tQcmljZSddID0gbW9kdWxlRGF0YS50YXJnZXRQcmljZVRleHQ7XG4gICAgY29uc3QgZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdCgnb3RjL29wdC9vcHRpb24vb3JkZXIvdjIvZG91YmxlLWN1cnJlbmN5LXdpbi9wcm9kdWN0JywgcGFyYW1zKTtcbiAgICBpZiAoZGF0YSAhPSBudWxsICYmIGRhdGFbJ2FyciddICE9IG51bGwgJiYgZGF0YVsnYXJyJ10gIT0gdW5kZWZpbmVkKSB7XG4gICAgICAgIG1vZHVsZURhdGEucHJvZHVjdFlpZWxkID0gYCR7Y29tbW9uLmZvcm1hdFByZWNpc2lvbihkYXRhLmFyciwgMil9JWA7XG4gICAgICAgIG1vZHVsZURhdGEucHJvZHVjdFlpZWxkVmlzaWJsZSA9ICd2aXNpYmxlJztcblx0XHRwcm9kdWN0WWllbGRFcnJvciA9IGZhbHNlO1xuICAgIH0gZWxzZSB7XG5cdFx0cHJvZHVjdFlpZWxkRXJyb3IgPSB0cnVlO1xuICAgICAgICBtb2R1bGVEYXRhLnByb2R1Y3RZaWVsZCA9ICcnO1xuICAgICAgICBtb2R1bGVEYXRhLnByb2R1Y3RZaWVsZFZpc2libGUgPSAnZ29uZSc7XG4gICAgICAgIG1vZHVsZURhdGEuYnRuQmdDb2xvciA9ICdAY29sb3IvYmFzZUNvbG9yVGhyZWVMZXZlbFRleHQnO1xuICAgICAgICBtb2R1bGVEYXRhLmVkaXRUZXh0Qm9yZGVyQ29sb3IgPSAnI0U5NDM1OSc7XG4gICAgfVxufVxuXG5mdW5jdGlvbiBjbGVhckRhdGEoKSB7XG4gICAgbW9kdWxlRGF0YS5sb3dQcmljZSA9ICcnO1xuICAgIG1vZHVsZURhdGEuaGlnaFByaWNlID0gJyc7XG4gICAgbW9kdWxlRGF0YS5wcmljZVJhbmdlID0gJyc7XG4gICAgbW9kdWxlRGF0YS5lZGl0RXJyb3JTaG93ID0gJ2dvbmUnO1xuICAgIG1vZHVsZURhdGEuZWRpdFRleHRCb3JkZXJDb2xvciA9ICdAY29sb3IvS0Jhc2VDb2xvcklucHV0QmFja2dyb3VuZCc7XG4gICAgbW9kdWxlRGF0YS50YXJnZXRQcmljZVRleHQgPSAnJztcbiAgICBtb2R1bGVEYXRhLnNlbGVjdGVkRGF0ZSA9ICRpMThuLm5fZG91YmxlX2NvaW5fZWFybl9zZWxlY3RfZXhwaXJlX2RhdGU7XG4gICAgbW9kdWxlRGF0YS5zZWxlY3RlZFRpbWUgPSAwO1xuICAgIG1vZHVsZURhdGEucHJvZHVjdFlpZWxkID0gJyc7XG4gICAgbW9kdWxlRGF0YS5wcm9kdWN0WWllbGRWaXNpYmxlID0gJ2dvbmUnO1xuICAgIG1vZHVsZURhdGEuc2VsZWN0ZWREYXRlQ29sb3IgPSAnQGNvbG9yL2VCYXNlQ29sb3JUaHJlZUxldmVsVGV4dCc7XG4gICAgbW9kdWxlRGF0YS5wcm9kdWN0RGF0ZVZpc2libGUgPSAnZ29uZSc7XG5cdHByb2R1Y3RZaWVsZEVycm9yID0gZmFsc2U7XG59XG5cbmZ1bmN0aW9uIGVycm9yQmFjaygpIHtcbiAgICBjb21tb24uc2hvd1RvYXN0KCRpMThuLm5fbm90X3N1cHBvcnQpO1xuICAgIGNvbW1vbi5jb250YWluZXJCYWNrKCk7XG59XG5cbmZ1bmN0aW9uIG9wZW5BbGVydChwYXJhbSkge1xuICAgIG1vZHVsZURhdGFbcGFyYW1dID0gJ3RydWUnO1xuICAgIG1vZHVsZURhdGEub25Gb2N1cyA9ICdmYWxzZSc7XG59XG5cbmZ1bmN0aW9uIGNsb3NlQWxlcnQocGFyYW0pIHtcbiAgICBtb2R1bGVEYXRhW3BhcmFtXSA9ICdmYWxzZSc7XG59XG5cbmZ1bmN0aW9uIGNob3NlQ29pbihpZHgpIHtcbiAgICBmb3IgKHZhciBpID0gMDsgaSA8IG1vZHVsZURhdGEubmF2aWdhdGlvbnMubGVuZ3RoOyBpKyspIHtcbiAgICAgICAgdmFyIG9iamVjdCA9IG1vZHVsZURhdGEubmF2aWdhdGlvbnNbaV07XG4gICAgICAgIG9iamVjdC5zZWxlY3RlZCA9ICdnb25lJztcbiAgICAgICAgb2JqZWN0LmRpYWxvZ1RleHRDb2xvciA9IFwiQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0XCI7XG4gICAgfVxuICAgIHZhciB0YXJnZXRPYmplY3QgPSBtb2R1bGVEYXRhLm5hdmlnYXRpb25zW3BhcnNlSW50KGlkeCldO1xuICAgIHRhcmdldE9iamVjdC5zZWxlY3RlZCA9ICd2aXNpYmxlJztcbiAgICB0YXJnZXRPYmplY3QuZGlhbG9nVGV4dENvbG9yID0gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiO1xuICAgIG1vZHVsZURhdGEuc2VsZWN0ZWRDb2luID0gdGFyZ2V0T2JqZWN0LmNvaW5OYW1lO1xuICAgIG1vZHVsZURhdGEuc2VsZWN0ZWRJY29uID0gdGFyZ2V0T2JqZWN0Lm1haW5JY29uO1xuICAgIGNvbnN0IHN1Ykl0ZW0gPSB0YXJnZXRPYmplY3QuaXRlbXNbMF1cbiAgICBpZiAoc3ViSXRlbVsncHJvZHVjdC10eXBlLWlkJ10gPT0gJzUnKSB7Ly/mioTlupXlrp1cbiAgICAgICAgbW9kdWxlRGF0YS5zZWxlY3RlZFR5cGUgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fZG91YmxlX2NvaW5fZWFybl9sb3dfYnV5X3NvbWV0aGluZyhzdWJJdGVtWydxdW90ZS1jdXJyZW5jeSddLnRvVXBwZXJDYXNlKCksIHN1Ykl0ZW1bJ2Jhc2UtY3VycmVuY3knXS50b1VwcGVyQ2FzZSgpKTtcbiAgICAgICAgbW9kdWxlRGF0YS5iaWdJY29uID0gY29tbW9uLmdldFBOR0ljb25VUkxCeUN1cnJlbmN5KHN1Ykl0ZW1bJ3F1b3RlLWN1cnJlbmN5J10pO1xuICAgICAgICBtb2R1bGVEYXRhLnNtYWxsSWNvbiA9IGNvbW1vbi5nZXRQTkdJY29uVVJMQnlDdXJyZW5jeShzdWJJdGVtWydiYXNlLWN1cnJlbmN5J10pO1xuICAgIH0gZWxzZSBpZiAoc3ViSXRlbVsncHJvZHVjdC10eXBlLWlkJ10gPT0gJzYnKSB7Ly/mraLnm4jlrp1cbiAgICAgICAgbW9kdWxlRGF0YS5zZWxlY3RlZFR5cGUgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fZG91YmxlX2NvaW5fZWFybl9oaWdoX3NlbGxfZm9yKHN1Ykl0ZW1bJ2Jhc2UtY3VycmVuY3knXS50b1VwcGVyQ2FzZSgpLCBzdWJJdGVtWydxdW90ZS1jdXJyZW5jeSddLnRvVXBwZXJDYXNlKCkpO1xuICAgICAgICBtb2R1bGVEYXRhLmJpZ0ljb24gPSBjb21tb24uZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3koc3ViSXRlbVsnYmFzZS1jdXJyZW5jeSddKTtcbiAgICAgICAgbW9kdWxlRGF0YS5zbWFsbEljb24gPSBjb21tb24uZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3koc3ViSXRlbVsncXVvdGUtY3VycmVuY3knXSk7XG4gICAgfVxuICAgIG1vZHVsZURhdGEudHlwZUNob3NlQWxlcnRIZWlnaHQgPSB0YXJnZXRPYmplY3QuaXRlbXMubGVuZ3RoICogNTYgKyA2NCArIGNvbW1vbi5jb21tb25EYXRhLmJvdHRvbVNhZmVBcmVhSGVpZ2h0O1xuICAgIG1vZHVsZURhdGEuaXRlbXMgPSB0YXJnZXRPYmplY3QuaXRlbXM7XG4gICAgZm9yICh2YXIgaSA9IDA7IGkgPCBtb2R1bGVEYXRhLml0ZW1zLmxlbmd0aDsgaSsrKSB7XG4gICAgICAgIHZhciBvYmplY3QgPSBtb2R1bGVEYXRhLml0ZW1zW2ldO1xuICAgICAgICBvYmplY3Quc2VsZWN0ZWQgPSAnZ29uZSc7XG4gICAgICAgIG9iamVjdC5kaWFsb2dUZXh0Q29sb3IgPSBcIkBjb2xvci9rQ29sb3JQcmltYXJ5VGV4dFwiO1xuICAgIH1cbiAgICB2YXIgc3ViT2JqZWN0ID0gbW9kdWxlRGF0YS5pdGVtc1swXTtcbiAgICBzdWJPYmplY3Quc2VsZWN0ZWQgPSAndmlzaWJsZSc7XG4gICAgc3ViT2JqZWN0LmRpYWxvZ1RleHRDb2xvciA9IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIjtcbiAgICBzZXRTZWxlY3RlZEl0ZW0oc3ViT2JqZWN0KTtcbiAgICBjbG9zZUFsZXJ0KCdjb2luQ2hvc2VBbGVydFNob3cnKTtcbn1cblxuZnVuY3Rpb24gY2hvc2VDb2luVHlwZShpZHgpIHtcbiAgICBmb3IgKHZhciBpID0gMDsgaSA8IG1vZHVsZURhdGEuaXRlbXMubGVuZ3RoOyBpKyspIHtcbiAgICAgICAgdmFyIG9iamVjdCA9IG1vZHVsZURhdGEuaXRlbXNbaV07XG4gICAgICAgIG9iamVjdC5zZWxlY3RlZCA9ICdnb25lJztcbiAgICAgICAgb2JqZWN0LmRpYWxvZ1RleHRDb2xvciA9IFwiQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0XCI7XG4gICAgfVxuICAgIHZhciB0YXJnZXRPYmplY3QgPSBtb2R1bGVEYXRhLml0ZW1zW3BhcnNlSW50KGlkeCldO1xuICAgIHRhcmdldE9iamVjdC5zZWxlY3RlZCA9ICd2aXNpYmxlJztcbiAgICB0YXJnZXRPYmplY3QuZGlhbG9nVGV4dENvbG9yID0gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiO1xuICAgIHNldFNlbGVjdGVkSXRlbSh0YXJnZXRPYmplY3QpXG4gICAgbW9kdWxlRGF0YS5zZWxlY3RlZFR5cGUgPSB0YXJnZXRPYmplY3QudHlwZURlc2M7XG4gICAgaWYgKHRhcmdldE9iamVjdFsncHJvZHVjdC10eXBlLWlkJ10gPT0gJzUnKSB7Ly/mioTlupXlrp1cbiAgICAgICAgbW9kdWxlRGF0YS5iaWdJY29uID0gY29tbW9uLmdldFBOR0ljb25VUkxCeUN1cnJlbmN5KHRhcmdldE9iamVjdFsncXVvdGUtY3VycmVuY3knXSk7XG4gICAgICAgIG1vZHVsZURhdGEuc21hbGxJY29uID0gY29tbW9uLmdldFBOR0ljb25VUkxCeUN1cnJlbmN5KHRhcmdldE9iamVjdFsnYmFzZS1jdXJyZW5jeSddKTtcbiAgICB9IGVsc2UgaWYgKHRhcmdldE9iamVjdFsncHJvZHVjdC10eXBlLWlkJ10gPT0gJzYnKSB7Ly/mraLnm4jlrp1cbiAgICAgICAgbW9kdWxlRGF0YS5iaWdJY29uID0gY29tbW9uLmdldFBOR0ljb25VUkxCeUN1cnJlbmN5KHRhcmdldE9iamVjdFsnYmFzZS1jdXJyZW5jeSddKTtcbiAgICAgICAgbW9kdWxlRGF0YS5zbWFsbEljb24gPSBjb21tb24uZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3kodGFyZ2V0T2JqZWN0WydxdW90ZS1jdXJyZW5jeSddKTtcbiAgICB9XG4gICAgY2xvc2VBbGVydCgndHlwZUNob3NlQWxlcnRTaG93Jyk7XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHNob3dEYXRlUGlja2VyKCkge1xuICAgIG1vZHVsZURhdGEub25Gb2N1cyA9ICdmYWxzZSc7XG4gICAgdmFyIHBhcmFtID0gbW9kdWxlRGF0YS5zZWxlY3RlZERhdGUgPT0gJGkxOG4ubl9kb3VibGVfY29pbl9lYXJuX3NlbGVjdF9leHBpcmVfZGF0ZSA/ICcnIDogbW9kdWxlRGF0YS5zZWxlY3RlZERhdGVcbiAgICB2YXIganNvbk9iaiA9IGF3YWl0ICRuYXRpdmVBUEkuZG91YmxlQ29pblNob3dEYXRlUGlja2VyKHBhcmFtKTtcbiAgICB2YXIgdGltZU9iaiA9IEpTT04ucGFyc2UoanNvbk9iaik7XG4gICAgY29uc29sZS5sb2coYHNob3dEYXRlUGlja2VyIDogJHtqc29uT2JqfSAgJHt0aW1lT2JqfWApO1xuICAgIGlmICh0aW1lT2JqKSB7XG4gICAgICAgIGNvbnN0IHRpbWVzdGFtcCA9IG1vZHVsZURhdGEuc2VsZWN0ZWRJdGVtWydpbnZhbGlkLWF0J107XG4gICAgICAgIGNvbnN0IHNlbGVjdGVkVGltZSA9IHRpbWVzdGFtcFRvTm9vbihwYXJzZUludCh0aW1lT2JqLnRpbWUpKTtcbiAgICAgICAgbW9kdWxlRGF0YS5zZWxlY3RlZFRpbWUgPSBzZWxlY3RlZFRpbWU7XG4gICAgICAgIGlmICh0aW1lc3RhbXAgPCBzZWxlY3RlZFRpbWUpIHtcbiAgICAgICAgICAgIGNvbnN0IGRhdGUgPSBuZXcgRGF0ZSh0aW1lc3RhbXApLkZvcm1hdCgneXl5eS9NTS9kZCcpO1xuICAgICAgICAgICAgY29tbW9uLnNob3dUb2FzdCgkaTE4bi4kaW50ZXJjZXB0Lm5fZG91YmxlX2NvaW5fcHJvZHVjdF9kdWVfbGltaXQoZGF0ZSkpO1xuICAgICAgICAgICAgdXBkYXRlQnRuQmdDb2xvcigpO1xuICAgICAgICAgICAgcmV0dXJuO1xuICAgICAgICB9XG4gICAgICAgIGNvbnN0IGZvcm1hdFRpbWVTdHIgPSB0aW1lT2JqLmZvcm1hdFRpbWU7XG4gICAgICAgIGNvbnN0IGFyciA9IGZvcm1hdFRpbWVTdHIuc3BsaXQoXCIvXCIsIDMpO1xuICAgICAgICB2YXIgdG9kYXk7XG4gICAgICAgIGlmIChtb2R1bGVEYXRhLmN1cnJlbnRUaW1lID09IC0xKSB7XG4gICAgICAgICAgICB0b2RheSA9IG5ldyBEYXRlKCk7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICB0b2RheSA9IG5ldyBEYXRlKG1vZHVsZURhdGEuY3VycmVudFRpbWUpO1xuICAgICAgICB9XG4gICAgICAgIGNvbnNvbGUubG9nKGBzaG93RGF0ZVBpY2tlciA6ICR7SlNPTi5zdHJpbmdpZnkoYXJyKX1gKTtcbiAgICAgICAgY29uc29sZS5sb2coYHNob3dEYXRlUGlja2VyIGdldEZ1bGxZZWFyIDogJHt0b2RheS5nZXRGdWxsWWVhcigpfWApO1xuICAgICAgICBjb25zb2xlLmxvZyhgc2hvd0RhdGVQaWNrZXIgZ2V0TW9udGggOiAke3RvZGF5LmdldE1vbnRoKCl9YCk7XG4gICAgICAgIGNvbnNvbGUubG9nKGBzaG93RGF0ZVBpY2tlciBnZXREYXRlIDogJHt0b2RheS5nZXREYXRlKCl9YCk7XG4gICAgICAgIGNvbnNvbGUubG9nKGBzaG93RGF0ZVBpY2tlciBnZXRIb3VycyA6ICR7dG9kYXkuZ2V0SG91cnMoKX1gKTtcbiAgICAgICAgaWYgKGFyclswXSA9PSB0b2RheS5nZXRGdWxsWWVhcigpKSB7XG4gICAgICAgICAgICBpZiAoYXJyWzFdIDwgKHRvZGF5LmdldE1vbnRoKCkgKyAxKSkge1xuICAgICAgICAgICAgICAgIGNvbW1vbi5zaG93VG9hc3QoJGkxOG4ubl9kb3VibGVfY29pbl9kdWVfZGF0ZV9ub3RfbGVzcyk7XG4gICAgICAgICAgICAgICAgdXBkYXRlQnRuQmdDb2xvcigpO1xuICAgICAgICAgICAgICAgIHJldHVybjtcbiAgICAgICAgICAgIH0gZWxzZSBpZiAoYXJyWzFdID09ICh0b2RheS5nZXRNb250aCgpICsgMSkgJiYgYXJyWzJdIDw9IHRvZGF5LmdldERhdGUoKSAmJiB0b2RheS5nZXRIb3VycygpID4gMTQpIHtcbiAgICAgICAgICAgICAgICBjb21tb24uc2hvd1RvYXN0KCRpMThuLm5fZG91YmxlX2NvaW5fZHVlX2RhdGVfbm90X2xlc3NfMl9uZXcpO1xuICAgICAgICAgICAgICAgIHVwZGF0ZUJ0bkJnQ29sb3IoKTtcbiAgICAgICAgICAgICAgICByZXR1cm47XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICAgICAgbW9kdWxlRGF0YS5zZWxlY3RlZERhdGUgPSBmb3JtYXRUaW1lU3RyO1xuICAgICAgICBpZiAobW9kdWxlRGF0YS5zZWxlY3RlZERhdGUgPT0gJGkxOG4ubl9kb3VibGVfY29pbl9lYXJuX3NlbGVjdF9leHBpcmVfZGF0ZSkge1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5zZWxlY3RlZERhdGVDb2xvciA9ICdAY29sb3IvZUJhc2VDb2xvclRocmVlTGV2ZWxUZXh0JztcbiAgICAgICAgICAgIG1vZHVsZURhdGEucHJvZHVjdERhdGVWaXNpYmxlID0gJ2dvbmUnO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5zZWxlY3RlZERhdGVDb2xvciA9ICdAY29sb3Iva0NvbG9yUHJpbWFyeVRleHQnO1xuICAgICAgICAgICAgbW9kdWxlRGF0YS5wcm9kdWN0RGF0ZVZpc2libGUgPSAndmlzaWJsZSc7XG4gICAgICAgIH1cbiAgICAgICAgY29uc3QgZGF5ID0gY29tbW9uLmZvcm1hdFByZWNpc2lvbihkYXlzQmV0d2Vlbihmb3JtYXRUaW1lU3RyKSwgMCkgKyAnJztcbiAgICAgICAgbW9kdWxlRGF0YS5wcm9kdWN0RGF0ZSA9ICRpMThuLiRpbnRlcmNlcHQubl9kb3VibGVfY29pbl9lYXJuX3Byb2R1Y3RfZGVhZGxpbmUoZGF5KTtcbiAgICAgICAgcmVxdWVzdFlpZWxkKCk7XG4gICAgICAgIHVwZGF0ZUJ0bkJnQ29sb3IoKTtcbiAgICB9XG5cbn1cblxuZnVuY3Rpb24gdGltZXN0YW1wVG9Ob29uKHRpbWVzdGFtcCkge1xuICAgIGNvbnN0IG5vb25EYXRlID0gbmV3IERhdGUodGltZXN0YW1wKTtcbiAgICBub29uRGF0ZS5zZXRIb3VycygxNiwgMCwgMCwgMCk7IC8vIOiuvue9ruaXtumXtOS4uuS4i+WNiDTngrlcbiAgICByZXR1cm4gbm9vbkRhdGUuZ2V0VGltZSgpOyAvLyDov5Tlm57kv67mlLnlkI7nmoTml7bpl7TmiLNcbn1cblxuZnVuY3Rpb24gc2V0U2VsZWN0ZWRJdGVtKHBhcmFtKSB7XG4gICAgbW9kdWxlRGF0YS5zZWxlY3RlZEl0ZW0gPSBwYXJhbTtcbiAgICBtb2R1bGVEYXRhLnByaWNlVW5pdCA9IHBhcmFtWydxdW90ZS1jdXJyZW5jeSddLnRvVXBwZXJDYXNlKCk7XG4gICAgY2xlYXJJbmRleFByaWNlVGltZXIoKTtcbiAgICBjbGVhckRhdGEoKTtcbiAgICBpbnRlcnZhbFJlcXVlc3RJbmRleFByaWNlKCk7XG4gICAgcmVxdWVzdFlpZWxkKCk7XG4gICAgdXBkYXRlQnRuQmdDb2xvcigpO1xufVxuXG5mdW5jdGlvbiBkYXlzQmV0d2VlbihlbmQpIHtcbiAgICBjb25zdCBlRGF0ZSA9IERhdGUucGFyc2UoZW5kKTtcbiAgICBjb25zdCBzRGF0ZSA9IG5ldyBEYXRlKG5ldyBEYXRlKG5ldyBEYXRlKCkudG9Mb2NhbGVEYXRlU3RyaW5nKCkpLmdldFRpbWUoKSkuZ2V0VGltZSgpO1xuICAgIGlmIChzRGF0ZSA+IGVEYXRlKSByZXR1cm4gMDtcbiAgICBpZiAoc0RhdGUgPT09IGVEYXRlKSByZXR1cm4gMTtcbiAgICByZXR1cm4gKGVEYXRlIC0gc0RhdGUpIC8gKDI0ICogNjAgKiA2MCAqIDEwMDApO1xufVxuXG5mdW5jdGlvbiBvbkRlc3Ryb3koKSB7XG4gICAgY2xlYXJJbmRleFByaWNlVGltZXIoKTtcbiAgICBjbGVhckRhdGEoKTtcbn1cblxuZnVuY3Rpb24gY2xlYXJJbmRleFByaWNlVGltZXIoKSB7XG4gICAgaWYgKGluZGV4UHJpY2VUaW1lciAhPSBudWxsKSB7XG4gICAgICAgIGNsZWFySW50ZXJ2YWwoaW5kZXhQcmljZVRpbWVyKTtcbiAgICAgICAgaW5kZXhQcmljZVRpbWVyID0gbnVsbDtcbiAgICB9XG59XG5cbmZ1bmN0aW9uIGZvY3VzQ2hhbmdlKHBhcmFtKSB7XG4gICAgLy8gaWYgKHBhcmFtID09IGZhbHNlKSB7XG4gICAgLy8gICAgIHJlcXVlc3RZaWVsZCgpO1xuICAgIC8vIH1cblx0aWYgKHBhcmFtID09IGZhbHNlICYmIHByb2R1Y3RZaWVsZEVycm9yKSB7XG5cdFx0cmV0dXJuXG5cdH1cbiAgICB1cGRhdGVCdG5CZ0NvbG9yKCk7XG4gICAgdXBkYXRlRWRpdFRleHRCb3JkZXJDb2xvcihwYXJhbSk7XG59XG5cbmZ1bmN0aW9uIHRleHRDaGFuZ2UodGV4dCkge1xuICAgIGNvbnNvbGUubG9nKGB0ZXh0Q2hhbmdlIDogJHt0ZXh0fWApO1xuICAgIGlmICh0ZXh0Lmxlbmd0aCA+IDApIHtcbiAgICAgICAgbW9kdWxlRGF0YS5jbGVhclZpc2liaWxpdHkgPSAndmlzaWJsZSc7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgbW9kdWxlRGF0YS5jbGVhclZpc2liaWxpdHkgPSAnZ29uZSc7XG4gICAgfVxuICAgIGlmICh0ZXh0ID09IFwiXCIgfHwgaW5wdXROdW0odGV4dCkpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5lZGl0RXJyb3JTaG93ID0gJ2dvbmUnO1xuICAgICAgICAvLyBtb2R1bGVEYXRhLmVkaXRUZXh0Qm9yZGVyQ29sb3IgPSAnQGNvbG9yL0tCYXNlQ29sb3JJbnB1dEJhY2tncm91bmQnO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIG1vZHVsZURhdGEuZWRpdEVycm9yU2hvdyA9ICd2aXNpYmxlJztcbiAgICAgICAgLy8gbW9kdWxlRGF0YS5lZGl0VGV4dEJvcmRlckNvbG9yID0gJyNFOTQzNTknO1xuICAgIH1cbiAgICBtb2R1bGVEYXRhLnRhcmdldFByaWNlVGV4dCA9IHRleHQ7XG5cdHByb2R1Y3RZaWVsZEVycm9yID0gZmFsc2U7XG4gICAgdXBkYXRlRWRpdFRleHRCb3JkZXJDb2xvcigpO1xuICAgIHVwZGF0ZUJ0bkJnQ29sb3IoKTtcbiAgICBpZiAobW9kdWxlRGF0YS5idG5CZ0NvbG9yID09ICdAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMCcpIHtcbiAgICAgICAgcmVxdWVzdFlpZWxkKCk7XG4gICAgfVxufVxuXG5mdW5jdGlvbiB1cGRhdGVFZGl0VGV4dEJvcmRlckNvbG9yKGZvY3VzID0gdHJ1ZSkge1xuICAgIGlmIChtb2R1bGVEYXRhLmVkaXRFcnJvclNob3cgPT0gJ3Zpc2libGUnKSB7XG4gICAgICAgIG1vZHVsZURhdGEuZWRpdFRleHRCb3JkZXJDb2xvciA9ICcjRTk0MzU5JztcbiAgICB9IGVsc2UgaWYgKGZvY3VzIHx8IGZvY3VzID09ICd0cnVlJykge1xuICAgICAgICBtb2R1bGVEYXRhLmVkaXRUZXh0Qm9yZGVyQ29sb3IgPSAnQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDAnO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIG1vZHVsZURhdGEuZWRpdFRleHRCb3JkZXJDb2xvciA9ICdAY29sb3IvS0Jhc2VDb2xvcklucHV0QmFja2dyb3VuZCc7XG4gICAgfVxufVxuXG5mdW5jdGlvbiB1cGRhdGVCdG5CZ0NvbG9yKCkge1xuICAgIGlmIChtb2R1bGVEYXRhLnNlbGVjdGVkSXRlbVsncHJvZHVjdC10eXBlLWlkJ10gIT0gJzUnICYmIG1vZHVsZURhdGEuc2VsZWN0ZWRJdGVtWydwcm9kdWN0LXR5cGUtaWQnXSAhPSAnNicpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5idG5CZ0NvbG9yID0gJ0Bjb2xvci9iYXNlQ29sb3JUaHJlZUxldmVsVGV4dCc7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgaWYgKG1vZHVsZURhdGEuc2VsZWN0ZWRUaW1lIDw9IDApIHtcbiAgICAgICAgbW9kdWxlRGF0YS5idG5CZ0NvbG9yID0gJ0Bjb2xvci9iYXNlQ29sb3JUaHJlZUxldmVsVGV4dCc7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgaWYgKG1vZHVsZURhdGEuZWRpdEVycm9yU2hvdyA9PSAndmlzaWJsZScgfHwgbW9kdWxlRGF0YS50YXJnZXRQcmljZVRleHQgPT0gXCJcIikge1xuICAgICAgICBtb2R1bGVEYXRhLmJ0bkJnQ29sb3IgPSAnQGNvbG9yL2Jhc2VDb2xvclRocmVlTGV2ZWxUZXh0JztcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICBtb2R1bGVEYXRhLmJ0bkJnQ29sb3IgPSAnQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDAnO1xufVxuXG5mdW5jdGlvbiBzdWJtaXQoKSB7XG4gICAgaWYgKG1vZHVsZURhdGEuYnRuQmdDb2xvciA9PSAnQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDAnKSB7XG4gICAgICAgIGNvbnN0IHVybCA9IFwiaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9lZGdlZW5naW5lL2NvbnRhaW5lcj9zY2VuZT1kb3VibGVjb2luJnJvb3ROYW1lPXByb2R1Y3RzdWImbmF2Q29uZmlnPW5hdGl2ZVwiO1xuICAgICAgICBjb25zdCBwcm9kdWN0VHlwZUlkID0gbW9kdWxlRGF0YS5zZWxlY3RlZEl0ZW1bJ3Byb2R1Y3QtdHlwZS1pZCddO1xuICAgICAgICBjb25zdCBwcm9kdWN0SWQgPSBtb2R1bGVEYXRhLnNlbGVjdGVkSXRlbVsncHJvZHVjdC1pZCddO1xuICAgICAgICBjb25zdCBwcm9kdWN0RmluYW5jZUlkID0gbW9kdWxlRGF0YS5zZWxlY3RlZEl0ZW1bJ3Byb2R1Y3QtZmluYW5jZS1pZCddO1xuICAgICAgICBjb25zdCBob29rUHJpY2UgPSBtb2R1bGVEYXRhLnRhcmdldFByaWNlVGV4dDtcbiAgICAgICAgY29uc3QgZXhwaXJlQXQgPSBtb2R1bGVEYXRhLnNlbGVjdGVkVGltZSArICcnO1xuICAgICAgICBjb25zdCBjdXJyZW5jeSA9IG1vZHVsZURhdGEuc2VsZWN0ZWRJdGVtWydiYXNlLWN1cnJlbmN5J107XG4gICAgICAgIGNvbnN0IHF1b3RlID0gbW9kdWxlRGF0YS5zZWxlY3RlZEl0ZW1bJ3F1b3RlLWN1cnJlbmN5J107XG4gICAgICAgIGNvbW1vbi5vcGVuVVJMKGAke3VybH0mcHJvZHVjdFR5cGVJZD0ke3Byb2R1Y3RUeXBlSWR9JnByb2R1Y3RJZD0ke3Byb2R1Y3RJZH0mcHJvZHVjdEZpbmFuY2VJZD0ke3Byb2R1Y3RGaW5hbmNlSWR9Jmhvb2tQcmljZT0ke2hvb2tQcmljZX0mZXhwaXJlQXQ9JHtleHBpcmVBdH0mY3VycmVuY3k9JHtjdXJyZW5jeX0mcXVvdGU9JHtxdW90ZX1gKTtcbiAgICB9XG59XG5cbmZ1bmN0aW9uIGNsZWFuUHJpY2UoKSB7XG4gICAgbW9kdWxlRGF0YS50YXJnZXRQcmljZVRleHQgPSAnJztcbiAgICBtb2R1bGVEYXRhLmNsZWFyVmlzaWJpbGl0eSA9ICdnb25lJztcbiAgICBtb2R1bGVEYXRhLmVkaXRFcnJvclNob3cgPSAnZ29uZSc7XG4gICAgaWYgKGNvbW1vbi5jb21tb25EYXRhLk9TID09IDApIHtcbiAgICAgICAgdGV4dENoYW5nZSgnJyk7XG4gICAgfVxufVxuXG5mdW5jdGlvbiBpbnB1dE51bSh0KSB7XG4gICAgY29uc3QgbG93ID0gcGFyc2VGbG9hdChtb2R1bGVEYXRhLmxvd1ByaWNlKTtcbiAgICBjb25zdCBoaWdoID0gcGFyc2VGbG9hdChtb2R1bGVEYXRhLmhpZ2hQcmljZSk7XG4gICAgY29uc3QgY3VyID0gcGFyc2VGbG9hdCh0KTtcbiAgICBpZiAoY3VyIDw9IGhpZ2ggJiYgY3VyID49IGxvdykge1xuICAgICAgICByZXR1cm4gdHJ1ZTtcbiAgICB9XG4gICAgcmV0dXJuIGZhbHNlO1xufVxuXG5tb2R1bGVFdmVudC5vcGVuQWxlcnQgPSBvcGVuQWxlcnQ7XG5tb2R1bGVFdmVudC5jbG9zZUFsZXJ0ID0gY2xvc2VBbGVydDtcbm1vZHVsZUV2ZW50LmNob3NlQ29pbiA9IGNob3NlQ29pbjtcbm1vZHVsZUV2ZW50LmNob3NlQ29pblR5cGUgPSBjaG9zZUNvaW5UeXBlO1xubW9kdWxlRXZlbnQuc2hvd0RhdGVQaWNrZXIgPSBzaG93RGF0ZVBpY2tlcjtcbm1vZHVsZUV2ZW50LnRleHRDaGFuZ2UgPSB0ZXh0Q2hhbmdlO1xubW9kdWxlRXZlbnQuY2xlYW5QcmljZSA9IGNsZWFuUHJpY2U7XG5tb2R1bGVFdmVudC5mb2N1c0NoYW5nZSA9IGZvY3VzQ2hhbmdlO1xubW9kdWxlRXZlbnQuc3VibWl0ID0gc3VibWl0O1xuIiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiO1xuXG5cbmZ1bmN0aW9uIGRlZmF1bHREYXRhKCkge1xuICByZXR1cm4ge1xuICAgIG1haW5EYXRhOiBbXSwvL+WIl+ihqOaVsOaNrlxuICAgIHJlZnJlc2hTdGF0dXM6IDAsLy/liLfmlrDnirbmgIFcbiAgICBiYXNlQ29pbkljb246IFwiXCIsLy/mipXotYTluIHnp41cbiAgICBxdW90ZUNvaW5JY29uOiBcIlwiLC8v5oyC6ZKp5biB56eNXG4gICAgc3ViVGl0bGU6IFwiXCIsLy/kuoznuqfmoIfpophcbiAgICB1c2R0Q29sb3I6IFwiQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0XCIsXG4gICAgdXNkdEJnOiBcIkBjb2xvci9LQmFzZUNvbG9yQ29udGVudEJhY2tncm91bmRcIiwvL3VzZHQg6IOM5pmvXG4gICAgdXNkY0NvbG9yOiBcIkBjb2xvci9rQ29sb3JUaHJlZUxldmVsVGV4dFwiLFxuICAgIHVzZGNCZzogXCIjMDAwMDAwMDBcIixcbiAgICB0aHJlZVRpdGxlOiBcIlwiLC8v5o+P6L+w5paH5qGIXG4gICAgdGFiRGF0YTogW10sIC8v5YiG5pe25pWw5o2uXG4gICAgcXVvdGVWaXM6ICd2aXNpYmxlJywvL+WIhuaXtuaVsOaNruaYr+WQpuWxleekulxuICAgIGluZGV4UHJpY2U6IFwiLS1cIiwvL+aMh+aVsOS7t1xuICAgIHF1b3RlQ29pbjogXCJ1c2R0XCIsLy/lvZPliY3pgInkuK3nmoTorqHku7fljZXkvY1cbiAgfTtcbn1cblxuLy/pppbpobXluKblhaXlj4LmlbBcbnZhciBwYXJhbWV0ZXIgPSB7fTtcblxuLy90YWIg5L6/562+XG52YXIgZDcgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fYzJjX2xlbmRfZGF5cyhcIjw3XCIpXG52YXIgZDczID0gJGkxOG4uJGludGVyY2VwdC5uX2MyY19sZW5kX2RheXMoXCI3LTMwXCIpXG52YXIgZDM5ID0gJGkxOG4uJGludGVyY2VwdC5uX2MyY19sZW5kX2RheXMoXCIzMC05MFwiKVxudmFyIGQ5ID0gJGkxOG4uJGludGVyY2VwdC5uX2MyY19sZW5kX2RheXMoXCI+OTBcIilcblxuY29uc3QgbW0gPSA2MDAwMDtcbmNvbnN0IGhoID0gMzYwMDAwMDtcbmNvbnN0IGRkID0gODY0MDAwMDA7XG5cbi8v6K6w5b2V5YiX6KGo6K+35rGC5Y+C5pWwXG52YXIgbGlzdFJlcU9iaiA9IHt9O1xuLy/mjIfmlbDku7for7fmsYLlj4LmlbBcbnZhciBpbmRleFByaWNlUmVxT2JqID0ge307XG5cbi8v5oyH5pWw5Lu3XG52YXIgaW5kZXhQcmljZSA9IDA7XG5cbi8v5YiX6KGo6L2u6K6t5ZmoXG5sZXQgbGlzdFRpbWVyT2JqZWN0O1xuXG5jb25zdCB7IG1vZHVsZURhdGEsIG1vZHVsZUV2ZW50IH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFwiY29pbmRldGFpbFwiLCBkZWZhdWx0RGF0YSwgeyBvbkNyZWF0ZSwgb25EZXN0cm95LCBvblJlc3VtZSwgb25QYXVzZSB9KTtcblxuXG5mdW5jdGlvbiBvbkNyZWF0ZShqc29uUGFyYW1ldGVycykge1xuICB0cnkge1xuICAgIGNvbnNvbGUubG9nKGBjb2luRGV0YWlsIGNyZWF0ZSA6ICR7anNvblBhcmFtZXRlcnN9YCk7XG4gICAgbGV0IHBhcmFtZXRlclRlbXAgPSBKU09OLnBhcnNlKGpzb25QYXJhbWV0ZXJzKTtcbiAgICBwYXJhbWV0ZXIgPSB7XG4gICAgICBwcm9kdWN0VHlwZUlkOiBwYXJhbWV0ZXJUZW1wLnByb2R1Y3RUeXBlSWQsXG4gICAgICBjdXJyZW5jeTogcGFyYW1ldGVyVGVtcC5jdXJyZW5jeSxcbiAgICAgIHN1cHBvcnRRdW90ZXM6IHBhcmFtZXRlclRlbXAuc3VwcG9ydFF1b3Rlcy5zcGxpdChcIi1cIilcbiAgICB9XG4gICAgY29uc29sZS5sb2coYGNvaW5EZXRhaWwgaW5pdCAgJHtwYXJhbWV0ZXJ9YCk7XG4gICAgLy/liJ3lp4vljJbop4blm75cbiAgICBpbml0VWkoKTtcbiAgICAvL+WIneWni+WMluaVsOaNrlxuICAgIGluaXREYXRhKCk7XG4gIH0gY2F0Y2ggKGUpIHtcbiAgICBjb25zb2xlLmxvZyhgaW5pdCBlcnJvciwgZXJyb3I9JHtlfWApO1xuICB9XG59XG5cbmZ1bmN0aW9uIG9uUmVzdW1lKCkge1xuICBjb25zb2xlLmxvZyhcImNvaW5kZXRhaWwgb25SZXN1bWVcIik7XG4gIC8v5Lqn5ZOB5YiX6KGoXG4gIGludGVydmFsUmVxdWVzdFByb2R1Y3RMaXN0KCk7XG59XG5cbmZ1bmN0aW9uIG9uUGF1c2UoKSB7XG4gIGNvbnNvbGUubG9nKFwiY29pbmRldGFpbCBvblBhdXNlXCIpO1xuICBjbGVhckxpc3RUaW1lcigpO1xufVxuXG5mdW5jdGlvbiBpbml0RGF0YSgpIHtcbiAgLy/orrDlvZXor7fmsYLlj4LmlbBcbiAgbGlzdFJlcU9iaiA9IHtcbiAgICBwcm9kdWN0VHlwZUlkOiBwYXJhbWV0ZXIucHJvZHVjdFR5cGVJZCxcbiAgICBzeW1ib2w6IGAke3BhcmFtZXRlci5jdXJyZW5jeX0ke3BhcmFtZXRlci5zdXBwb3J0UXVvdGVzWzBdfWAsXG4gICAgY3VycmVuY3k6IHBhcmFtZXRlci5wcm9kdWN0VHlwZUlkID09IDYgPyBwYXJhbWV0ZXIuY3VycmVuY3kgOiBwYXJhbWV0ZXIuc3VwcG9ydFF1b3Rlc1swXVxuICB9XG4gIGluZGV4UHJpY2VSZXFPYmogPSB7XG4gICAgc3ltYm9sOiBgJHtwYXJhbWV0ZXIuY3VycmVuY3l9JHtwYXJhbWV0ZXIuc3VwcG9ydFF1b3Rlc1swXX1gXG4gIH1cbn1cblxuZnVuY3Rpb24gaW5pdFVpKCkge1xuICAvL+agh+mimFxuICBsZXQgdGl0bGUgPSBcIlwiO1xuICBpZiAocGFyYW1ldGVyLnByb2R1Y3RUeXBlSWQgPT0gNSkge1xuICAgIHRpdGxlID0gJGkxOG4uJGludGVyY2VwdC5uX2RvdWJsZV9jb2luX2Vhcm5fbG93X2J1eShwYXJhbWV0ZXIuY3VycmVuY3kudG9VcHBlckNhc2UoKSk7XG4gIH0gZWxzZSB7XG4gICAgdGl0bGUgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fZG91YmxlX2NvaW5fZWFybl9oaWdoX3NlbGwocGFyYW1ldGVyLmN1cnJlbmN5LnRvVXBwZXJDYXNlKCkpO1xuICB9XG4gIG1vZHVsZURhdGEubmF2Q29uZmlnID0gZ2V0TmF2Q29uZmlnU3RyaW5nKHRpdGxlKTtcbiAgLy/kuoznuqfmoIfpophcbiAgdXBkYXRlU2Vjb25kVGl0bGUocGFyYW1ldGVyLnN1cHBvcnRRdW90ZXNbMF0udG9VcHBlckNhc2UoKSk7XG4gIC8v6aG555uu5o+P6L+wXG4gIHVwZGF0ZVRocmVlVGl0bGUocGFyYW1ldGVyLnN1cHBvcnRRdW90ZXNbMF0udG9VcHBlckNhc2UoKSk7XG4gIC8vaWNvblxuICB1cGRhdGVDb2luSWNvbihwYXJhbWV0ZXIuc3VwcG9ydFF1b3Rlc1swXS50b1VwcGVyQ2FzZSgpKTtcbiAgLy/orqHku7fmoIfnrb5cbiAgaWYgKHBhcmFtZXRlci5zdXBwb3J0UXVvdGVzLmxlbmd0aCA9PSAxKSB7XG4gICAgbW9kdWxlRGF0YS5xdW90ZVZpcyA9ICdnb25lJ1xuICB9IGVsc2Uge1xuICAgIG1vZHVsZURhdGEucXVvdGVWaXMgPSAndmlzaWJsZSdcbiAgfVxufVxuXG5mdW5jdGlvbiB1cGRhdGVDb2luSWNvbihxdW90ZSkge1xuICAvL2ljb25cbiAgaWYgKHBhcmFtZXRlci5wcm9kdWN0VHlwZUlkID09IDUpIHtcbiAgICBtb2R1bGVEYXRhLmJhc2VDb2luSWNvbiA9IGNvbW1vbi5nZXRQTkdJY29uVVJMQnlDdXJyZW5jeShxdW90ZSk7XG4gICAgbW9kdWxlRGF0YS5xdW90ZUNvaW5JY29uID0gY29tbW9uLmdldFBOR0ljb25VUkxCeUN1cnJlbmN5KHBhcmFtZXRlci5jdXJyZW5jeSk7XG4gIH0gZWxzZSB7XG4gICAgbW9kdWxlRGF0YS5iYXNlQ29pbkljb24gPSBjb21tb24uZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3kocGFyYW1ldGVyLmN1cnJlbmN5KTtcbiAgICBtb2R1bGVEYXRhLnF1b3RlQ29pbkljb24gPSBjb21tb24uZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3kocXVvdGUpO1xuICB9XG4gIGNvbnNvbGUubG9nKGBpY29uIFVybCA6ICR7Y29tbW9uLmdldFBOR0ljb25VUkxCeUN1cnJlbmN5KHBhcmFtZXRlci5jdXJyZW5jeSl9YCk7XG59XG5cbmZ1bmN0aW9uIHVwZGF0ZVRocmVlVGl0bGUocXVvdGUpIHtcbiAgbGV0IGJhc2UgPSBwYXJhbWV0ZXIuY3VycmVuY3kudG9VcHBlckNhc2UoKTtcbiAgaWYgKHBhcmFtZXRlci5wcm9kdWN0VHlwZUlkID09IDUpIHtcbiAgICBtb2R1bGVEYXRhLnRocmVlVGl0bGUgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fZG91YmxlX2NvaW5fZWFybl9sb3dfYnV5X2V4cGxhaW5fbmV3KHF1b3RlLCBxdW90ZSwgYmFzZSwgcXVvdGUsIGJhc2UsIGJhc2UsIGJhc2UpXG4gIH0gZWxzZSB7XG4gICAgbW9kdWxlRGF0YS50aHJlZVRpdGxlID0gJGkxOG4uJGludGVyY2VwdC5uX2RvdWJsZV9jb2luX2Vhcm5faGlnaF9zZWxsX2V4cGxhaW5fbmV3KGJhc2UsIHF1b3RlLCBiYXNlLCBiYXNlLCBiYXNlLCBiYXNlLCBxdW90ZSlcbiAgfVxufVxuXG5mdW5jdGlvbiB1cGRhdGVTZWNvbmRUaXRsZShxdW90ZSkge1xuICBpZiAocGFyYW1ldGVyLnByb2R1Y3RUeXBlSWQgPT0gNSkge1xuICAgIG1vZHVsZURhdGEuc3ViVGl0bGUgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fZG91YmxlX2NvaW5fZWFybl9sb3dfYnV5X3NvbWV0aGluZyhxdW90ZSwgcGFyYW1ldGVyLmN1cnJlbmN5LnRvVXBwZXJDYXNlKCkpO1xuICB9IGVsc2Uge1xuICAgIG1vZHVsZURhdGEuc3ViVGl0bGUgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fZG91YmxlX2NvaW5fZWFybl9oaWdoX3NlbGxfZm9yKHBhcmFtZXRlci5jdXJyZW5jeS50b1VwcGVyQ2FzZSgpLCBxdW90ZSk7XG4gIH1cbn1cblxuYXN5bmMgZnVuY3Rpb24gaW50ZXJ2YWxSZXF1ZXN0UHJvZHVjdExpc3QoKSB7XG4gIGNvbnNvbGUubG9nKFwic3RhcnQgVGltZXJcIilcbiAgLy/muIXnqbrlrprml7blmahcbiAgY2xlYXJMaXN0VGltZXIoKTtcbiAgLy/or7fmsYLkuqflk4Hor6bmg4VcbiAgaWYgKG51bGwgPT0gbGlzdFRpbWVyT2JqZWN0KSB7XG4gICAgLy/lrprml7blmajlpb3lg4/msqHmnInnq4vljbPmiafooYznmoTlj4LmlbBcbiAgICByZXF1ZXN0UHJvZHVjdExpc3QoKTtcbiAgICBsaXN0VGltZXJPYmplY3QgPSBzZXRJbnRlcnZhbChyZXF1ZXN0UHJvZHVjdExpc3QsIDYwMDApO1xuICB9XG59XG5cbmZ1bmN0aW9uIGNsZWFyTGlzdFRpbWVyKCkge1xuICBpZiAobGlzdFRpbWVyT2JqZWN0ICE9IG51bGwpIHtcbiAgICBjbGVhckludGVydmFsKGxpc3RUaW1lck9iamVjdCk7XG4gICAgbGlzdFRpbWVyT2JqZWN0ID0gbnVsbDtcbiAgfVxufVxuXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0UHJvZHVjdExpc3QoKSB7XG5cdC8vIOWFiOivt+axguaMh+aVsOS7tyAtIOino+WGs3lpZWxkQnlEYXnmmL7npLrpl67pophcblx0Y29uc3QgcHJpY2VEYXRhID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KCdvdGMvb3B0L29wdGlvbi92MS9wcmUvaW5kZXgnLCBpbmRleFByaWNlUmVxT2JqKTtcblx0Y29uc29sZS5sb2coYGluZGV4UHJpY2UgOiAke0pTT04uc3RyaW5naWZ5KHByaWNlRGF0YSl9YClcblx0aWYgKHByaWNlRGF0YSkge1xuXHRcdGluZGV4UHJpY2UgPSBwcmljZURhdGE7XG5cdFx0bW9kdWxlRGF0YS5pbmRleFByaWNlID0gJGkxOG4uJGludGVyY2VwdC5uX2RvdWJsZV9jb2luX2Vhcm5fcXVhbnRpdHlfbGF0ZXN0KHBhcmFtZXRlci5jdXJyZW5jeS50b1VwcGVyQ2FzZSgpLCBgJHtpbmRleFByaWNlfWApO1xuXHR9XG5cdGNvbnNvbGUubG9nKFwiY29pbkRldGFpbCByZXF1ZXN0UHJvZHVjdExpc3RcIik7XG5cdC8vIGNvbW1vbi5zaG93TG9hZGluZyh0cnVlKTtcblx0Y29uc3QgZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdCgnb3RjL29wdC9vcHRpb24vb3JkZXIvdjIvZG91YmxlLWN1cnJlbmN5LXdpbi9wcm9kdWN0cycsIGxpc3RSZXFPYmopO1xuXHQvLyBjb21tb24uc2hvd0xvYWRpbmcoZmFsc2UpO1xuXHRoYW5kbGVNYWluTGlzdERhdGEoZGF0YSk7XG59XG5cbmZ1bmN0aW9uIGhhbmRsZU1haW5MaXN0RGF0YShkYXRhKSB7XG4gIGlmICghZGF0YSB8fCBkYXRhLmxlbmd0aCA9PSAwKSB7XG4gICAgLy/lsZXnpLrnqbrmlbDmja7pobVcbiAgICBjb25zb2xlLmxvZyhgaGFuZGxlTWFpbkxpc3REYXRhIOepuuaVsOaNrmApO1xuICAgIG1vZHVsZURhdGEubWFpbkRhdGEgPSBbeyB0eXBlOiBcIjJcIiB9XTtcbiAgICBpZiAoIWxpc3RSZXFPYmouY3ljbGUgfHwgbGlzdFJlcU9iai5jeWNsZSA9PSBcIlwiKSB7XG4gICAgICBtb2R1bGVEYXRhLnRhYkRhdGEgPSBjcmVhdGVUZW1wVGFiRGF0YSgpO1xuICAgIH1cbiAgICByZXR1cm47XG4gIH1cbiAgY29uc29sZS5sb2coYGNvaW5EZXRhaWwxIDogJHtKU09OLnN0cmluZ2lmeShkYXRhKX1gKTtcbiAgaWYgKG1vZHVsZURhdGEudGFiRGF0YS5sZW5ndGggPT0gMCkge1xuICAgIC8v5aSE55CGdGFi5pWw5o2uXG4gICAgbW9kdWxlRGF0YS50YWJEYXRhID0gaGFuZGxlVGFiRGF0YShkYXRhKTtcbiAgfVxuICB2YXIgZGF0YUxpc3QgPSBbXTtcbiAgZm9yICh2YXIgaSA9IDA7IGkgPCBkYXRhLmxlbmd0aDsgaSsrKSB7XG4gICAgY29uc3QgY3VyRGF0YSA9IGRhdGFbaV07XG4gICAgdmFyIHBhcmVudE9iaiA9IHt9O1xuICAgIHBhcmVudE9iai5pbmRleCA9IGk7XG4gICAgcGFyZW50T2JqLnR5cGUgPSBcIjFcIjtcbiAgICBsZXQgY3VyclRpbWUgPSBjdXJEYXRhW1wiY3Vyci10aW1lXCJdO1xuICAgIGxldCBleHBpcmVUaW1lID0gY3VyRGF0YVtcImV4cGlyZS10aW1lXCJdO1xuICAgIGxldCBkaWZmVGltZSA9IGV4cGlyZVRpbWUgLSBjdXJyVGltZTtcbiAgICBpZiAoZGlmZlRpbWUgPiAwKSB7XG4gICAgICBjb25zdCBkID0gTWF0aC5mbG9vcihkaWZmVGltZSAvIGRkKTtcbiAgICAgIGNvbnN0IGggPSBNYXRoLmZsb29yKGRpZmZUaW1lIC8gaGgpO1xuICAgICAgaWYgKGQgPiAwKSB7XG4gICAgICAgIHBhcmVudE9iai50aW1lTGltaXQgPSBgJHskaTE4bi5uX2hvbWVfaW5kZXhfZWFybl90aW1lX2xpbWl0fe+8miR7ZH0keyRpMThuLm5fZGF5fWBcbiAgICAgIH0gZWxzZSB7XG4gICAgICAgIHBhcmVudE9iai50aW1lTGltaXQgPSBgJHskaTE4bi5uX2hvbWVfaW5kZXhfZWFybl90aW1lX2xpbWl0fe+8miR7aH0keyRpMThuLm5faG91cn1gXG4gICAgICB9XG4gICAgfVxuICAgIHBhcmVudE9iai5kdWVEYXRlID0gJGkxOG4uJGludGVyY2VwdC5uX2RvdWJsZV9jb2luX2Vhcm5fZXhwaXJlX2RhdGVfbmV3KGAke25ldyBEYXRlKGV4cGlyZVRpbWUpLkZvcm1hdChcInl5eXkvTU0vZGQgaGg6bW1cIil9YCk7XG4gICAgLy/pgY3ljoblrZDmlbDnu4RcbiAgICB2YXIgcHJvZHVjdHMgPSBjdXJEYXRhLnByb2R1Y3RzO1xuICAgIGNvbnNvbGUubG9nKGBjb2luRGV0YWlsMyAke0pTT04uc3RyaW5naWZ5KHByb2R1Y3RzKX1gKTtcbiAgICBmb3IgKHZhciBqID0gMDsgaiA8IHByb2R1Y3RzLmxlbmd0aDsgaisrKSB7XG4gICAgICBjb25zdCBjdXJEYXRhID0gcHJvZHVjdHNbal07XG4gICAgICBjdXJEYXRhLnR5cGUgPSBcIjJcIjtcbiAgICAgIGN1ckRhdGEuaW5kZXggPSBqO1xuICAgICAgY3VyRGF0YS5wcmljZSA9IGN1ckRhdGFbXCJob29rLXByaWNlXCJdO1xuICAgICAgY3VyRGF0YS55aWVsZEJ5RGF5ID0gY2FsWWllbGQoY3VyRGF0YSk7XG4gICAgICBjdXJEYXRhLnlpZWxkQnlZZWFyID0gYCR7Y29tbW9uLmZvcm1hdFByZWNpc2lvbihjdXJEYXRhLmFyciwgMil9JWA7XG4gICAgfVxuICAgIHBhcmVudE9iai5wcm9kdWN0cyA9IHByb2R1Y3RzO1xuICAgIC8v5Yiw5pyf5pe26Ze05re75Yqg5Yiw5pWw57uEXG4gICAgZGF0YUxpc3QucHVzaChwYXJlbnRPYmopO1xuICB9XG4gIGNvbnNvbGUubG9nKGBjb2luRGV0YWlsNCA6ICR7SlNPTi5zdHJpbmdpZnkoZGF0YUxpc3QpfWApO1xuICBtb2R1bGVEYXRhLm1haW5EYXRhID0gZGF0YUxpc3Q7XG4gIG1vZHVsZURhdGEucmVmcmVzaFN0YXR1cyA9IDI7XG59XG5cbmZ1bmN0aW9uIGhhbmRsZVRhYkRhdGEoZGF0YSkge1xuICAvL+WPquacieesrOS4gOasoemcgOimgeWIneWni+WMlnRhYuaVsOaNrlxuICBsZXQgdGFiRGF0YSA9IFtdO1xuICAvL+i/veWKoOWFqOmDqOagh+etvlxuICB0YWJEYXRhLnB1c2goZ2V0VGFiVWlEYXRhKCRpMThuLm5fYmFsYW5jZV9hbGwsIHRydWUpKTtcbiAgZm9yICh2YXIgaSA9IDA7IGkgPCBkYXRhLmxlbmd0aDsgaSsrKSB7XG4gICAgY29uc3QgY3VyRGF0YSA9IGRhdGFbaV07XG4gICAgLy88N1xuICAgIGlmIChjdXJEYXRhLmN5Y2xlIDwgNyAmJiAhaXNDb250YWlucyh0YWJEYXRhLCBkNykpIHtcbiAgICAgIHRhYkRhdGEucHVzaChnZXRUYWJVaURhdGEoZDcsIGZhbHNlKSk7XG4gICAgfVxuICAgIC8vNy0zMFxuICAgIGlmIChjdXJEYXRhLmN5Y2xlID4gNiAmJiBjdXJEYXRhLmN5Y2xlIDwgMzAgJiYgIWlzQ29udGFpbnModGFiRGF0YSwgZDczKSkge1xuICAgICAgdGFiRGF0YS5wdXNoKGdldFRhYlVpRGF0YShkNzMsIGZhbHNlKSk7XG4gICAgfVxuICAgIC8vMzAtOTBcbiAgICBpZiAoY3VyRGF0YS5jeWNsZSA+IDI5ICYmIGN1ckRhdGEuY3ljbGUgPCA5MCAmJiAhaXNDb250YWlucyh0YWJEYXRhLCBkMzkpKSB7XG4gICAgICB0YWJEYXRhLnB1c2goZ2V0VGFiVWlEYXRhKGQzOSwgZmFsc2UpKTtcbiAgICB9XG4gICAgLy8+OTBcbiAgICBpZiAoY3VyRGF0YS5jeWNsZSA+IDg5ICYmICFpc0NvbnRhaW5zKHRhYkRhdGEsIGQ5KSkge1xuICAgICAgdGFiRGF0YS5wdXNoKGdldFRhYlVpRGF0YShkOSwgZmFsc2UpKTtcbiAgICB9XG4gIH1cbiAgcmV0dXJuIHRhYkRhdGE7XG59XG5cbmZ1bmN0aW9uIGNyZWF0ZVRlbXBUYWJEYXRhKCkge1xuICAvL+WPquacieesrOS4gOasoemcgOimgeWIneWni+WMlnRhYuaVsOaNrlxuICBsZXQgdGFiRGF0YSA9IFtdO1xuICAvL+i/veWKoOWFqOmDqOagh+etvlxuICB0YWJEYXRhLnB1c2goZ2V0VGFiVWlEYXRhKCRpMThuLm5fYmFsYW5jZV9hbGwsIHRydWUpKTtcbiAgdGFiRGF0YS5wdXNoKGdldFRhYlVpRGF0YShkNywgZmFsc2UpKTtcbiAgdGFiRGF0YS5wdXNoKGdldFRhYlVpRGF0YShkNzMsIGZhbHNlKSk7XG4gIHRhYkRhdGEucHVzaChnZXRUYWJVaURhdGEoZDM5LCBmYWxzZSkpO1xuICB0YWJEYXRhLnB1c2goZ2V0VGFiVWlEYXRhKGQ5LCBmYWxzZSkpO1xuICByZXR1cm4gdGFiRGF0YTtcbn1cblxuXG5mdW5jdGlvbiBpc0NvbnRhaW5zKGRhdGEsIHRpdGxlKSB7XG4gIGZvciAodmFyIGkgPSAwOyBpIDwgZGF0YS5sZW5ndGg7IGkrKykge1xuICAgIGlmIChkYXRhW2ldLnRpdGxlID09IHRpdGxlKSB7XG4gICAgICByZXR1cm4gdHJ1ZTtcbiAgICB9XG4gIH1cbiAgcmV0dXJuIGZhbHNlO1xufVxuXG5mdW5jdGlvbiBnZXRUYWJVaURhdGEodGl0bGUsIGlzQ2hlY2spIHtcbiAgcmV0dXJuIHtcbiAgICB0YWc6IHRpdGxlLFxuICAgIHRpdGxlOiB0aXRsZSxcbiAgICB0aXRsZUNvbG9yOiBpc0NoZWNrID8gJ0Bjb2xvci9rQ29sb3JQcmltYXJ5VGV4dCcgOiAnQGNvbG9yL2tDb2xvclRocmVlTGV2ZWxUZXh0JyxcbiAgICB0aXRsZVNpemU6IGlzQ2hlY2sgPyAnMTYnIDogJzE0J1xuICB9O1xufVxuXG5mdW5jdGlvbiBjYWxZaWVsZChwcm9kdWN0KSB7XG4gIGlmIChpbmRleFByaWNlID09IDApIHtcbiAgICByZXR1cm4gXCItLSVcIjtcbiAgfVxuICAvL+a2qOi3jOW5hT3vvIgx4p6W5b2T5YmN5Lu34p6X55uu5qCH5Lu377yJ4pyW77iPMTAwJe+8jOS/neeVmeWwj+aVsOeCueWQjuS4pOS9jVxuICBsZXQgcmF0aW8gPSAoMSAtIGluZGV4UHJpY2UgLyAocHJvZHVjdFtcImhvb2stcHJpY2VcIl0pKSAqIDEwMDtcbiAgbGV0IHJhdGlvU3RyID0gY29tbW9uLmZvcm1hdFByZWNpc2lvbihyYXRpbywgMik7XG4gIGNvbnNvbGUubG9nKGByYXRpbyA6ICR7cmF0aW99ICAtLSA+ICR7aW5kZXhQcmljZSAvIChwcm9kdWN0W1wiaG9vay1wcmljZVwiXSl9YCk7XG4gIGlmKHJhdGlvID4gMCl7XG4gICAgcmV0dXJuIGArJHtyYXRpb1N0cn0lYFxuICB9ZWxzZXtcbiAgICByZXR1cm4gYCR7cmF0aW9TdHJ9JWBcbiAgfVxufVxuXG5mdW5jdGlvbiBnZXROYXZDb25maWdTdHJpbmcodGl0bGUpIHtcbiAgcmV0dXJuIHtcbiAgICAndGl0bGUnOiB0aXRsZSxcbiAgICAnbGVmdCc6IHtcbiAgICAgICdhY3Rpb24nOiB7XG4gICAgICAgICd0eXBlJzogJ2JhY2snLFxuICAgICAgICAncGFyYW1ldGVyJzogJydcbiAgICAgIH0sXG4gICAgICAnaWNvbic6ICdlZGdlX2VuZ2luZV90b3BfYmFyX2JhY2tfbm9ybWFsJ1xuICAgIH0sXG4gICAgJ3JpZ2h0Jzoge1xuICAgICAgJ2FjdGlvbic6IHtcbiAgICAgICAgJ3R5cGUnOiAnZXZhbEpTJyxcbiAgICAgICAgJ3BhcmFtZXRlcic6ICdzaG93VGlwc0RpYWxvZydcbiAgICAgIH0sXG4gICAgICAnaWNvbic6ICdlZGdlX2VuZ2luZV9kb3VibGVfY29pbl9kZXRhaWxfdGlwcydcbiAgICB9LFxuICAgICdiYWNrZ3JvdW5kQ29sb3InOiAnS0Jhc2VDb2xvckRlZXBlc3RCYWNrZ3JvdW5kJ1xuICB9O1xufVxuXG5cbi8vIC0tLS0tLS0tLS0tLS0tLS0t5LqL5Lu257uR5a6aXG4vL+S4i+aLieWIt+aWsFxubW9kdWxlRXZlbnQucmVmcmVzaCA9IGZ1bmN0aW9uICgpIHtcbiAgbW9kdWxlRGF0YS5yZWZyZXNoU3RhdHVzID0gMTtcbiAgaW5pdERhdGEoKTtcbn1cblxubW9kdWxlRXZlbnQudXNkdENsaWNrID0gZnVuY3Rpb24gKCkge1xuICBxdW90ZUNoZWNrKDEpO1xuICB1cGRhdGVTZWNvbmRUaXRsZShwYXJhbWV0ZXIuc3VwcG9ydFF1b3Rlc1swXS50b1VwcGVyQ2FzZSgpKTtcbiAgdXBkYXRlVGhyZWVUaXRsZShwYXJhbWV0ZXIuc3VwcG9ydFF1b3Rlc1swXS50b1VwcGVyQ2FzZSgpKTtcbiAgdXBkYXRlQ29pbkljb24ocGFyYW1ldGVyLnN1cHBvcnRRdW90ZXNbMF0udG9VcHBlckNhc2UoKSk7XG4gIGxpc3RSZXFPYmouc3ltYm9sID0gYCR7cGFyYW1ldGVyLmN1cnJlbmN5fSR7cGFyYW1ldGVyLnN1cHBvcnRRdW90ZXNbMF19YDtcbiAgbGlzdFJlcU9iai5jdXJyZW5jeSA9IHBhcmFtZXRlci5wcm9kdWN0VHlwZUlkID09IDYgPyBwYXJhbWV0ZXIuY3VycmVuY3kgOiBwYXJhbWV0ZXIuc3VwcG9ydFF1b3Rlc1swXVxuICBpbmRleFByaWNlUmVxT2JqLmNvbnRyYWN0X2NvZGUgPSBgJHtwYXJhbWV0ZXIuY3VycmVuY3kudG9VcHBlckNhc2UoKX0tJHtwYXJhbWV0ZXIuc3VwcG9ydFF1b3Rlc1swXS50b1VwcGVyQ2FzZSgpfWBcbiAgaW5kZXhQcmljZVJlcU9iai5zeW1ib2wgPSBgJHtwYXJhbWV0ZXIuY3VycmVuY3l9JHtwYXJhbWV0ZXIuc3VwcG9ydFF1b3Rlc1swXX1gO1xuICBpbnRlcnZhbFJlcXVlc3RQcm9kdWN0TGlzdCgpO1xuICBtb2R1bGVEYXRhLnF1b3RlQ29pbiA9IHBhcmFtZXRlci5zdXBwb3J0UXVvdGVzWzBdXG59XG5cbm1vZHVsZUV2ZW50LnVzZGNDbGljayA9IGZ1bmN0aW9uICgpIHtcbiAgcXVvdGVDaGVjaygyKTtcbiAgdXBkYXRlU2Vjb25kVGl0bGUocGFyYW1ldGVyLnN1cHBvcnRRdW90ZXNbMV0udG9VcHBlckNhc2UoKSk7XG4gIHVwZGF0ZVRocmVlVGl0bGUocGFyYW1ldGVyLnN1cHBvcnRRdW90ZXNbMV0udG9VcHBlckNhc2UoKSk7XG4gIHVwZGF0ZUNvaW5JY29uKHBhcmFtZXRlci5zdXBwb3J0UXVvdGVzWzFdLnRvVXBwZXJDYXNlKCkpO1xuICBsaXN0UmVxT2JqLnN5bWJvbCA9IGAke3BhcmFtZXRlci5jdXJyZW5jeX0ke3BhcmFtZXRlci5zdXBwb3J0UXVvdGVzWzFdfWA7XG4gIGxpc3RSZXFPYmouY3VycmVuY3kgPSBwYXJhbWV0ZXIucHJvZHVjdFR5cGVJZCA9PSA2ID8gcGFyYW1ldGVyLmN1cnJlbmN5IDogcGFyYW1ldGVyLnN1cHBvcnRRdW90ZXNbMV1cbiAgaW5kZXhQcmljZVJlcU9iai5jb250cmFjdF9jb2RlID0gYCR7cGFyYW1ldGVyLmN1cnJlbmN5LnRvVXBwZXJDYXNlKCl9LSR7cGFyYW1ldGVyLnN1cHBvcnRRdW90ZXNbMV0udG9VcHBlckNhc2UoKX1gXG4gIGluZGV4UHJpY2VSZXFPYmouc3ltYm9sID0gYCR7cGFyYW1ldGVyLmN1cnJlbmN5fSR7cGFyYW1ldGVyLnN1cHBvcnRRdW90ZXNbMV19YDtcbiAgaW50ZXJ2YWxSZXF1ZXN0UHJvZHVjdExpc3QoKTtcbiAgbW9kdWxlRGF0YS5xdW90ZUNvaW4gPSBwYXJhbWV0ZXIuc3VwcG9ydFF1b3Rlc1sxXVxufVxuXG5tb2R1bGVFdmVudC5zaG93VGlwc0RpYWxvZyA9IGZ1bmN0aW9uICgpIHtcbiAgY29uc29sZS5sb2coYHNob3dUaXBzRGlhbG9nYCk7XG4gIGNvbW1vbi5vcGVuVVJMKFwiaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9lZGdlZW5naW5lL2NvbnRhaW5lcj9zY2VuZT1lYXJuJnJvb3ROYW1lPWludHJvZHVjZSZuYXZDb25maWc9bmF2JmluZGV4PTImdGFiSW5kZXg9MVwiKTtcbn1cblxuZnVuY3Rpb24gcXVvdGVDaGVjayhmbGFnKSB7XG4gIGlmIChmbGFnID09IDEpIHtcbiAgICBtb2R1bGVEYXRhLnVzZHRCZyA9ICdAY29sb3IvS0Jhc2VDb2xvckNvbnRlbnRCYWNrZ3JvdW5kJ1xuICAgIG1vZHVsZURhdGEudXNkdENvbG9yID0gJ0Bjb2xvci9rQ29sb3JQcmltYXJ5VGV4dCdcbiAgICBtb2R1bGVEYXRhLnVzZGNCZyA9ICcjMDAwMDAwMDAnXG4gICAgbW9kdWxlRGF0YS51c2RjQ29sb3IgPSAnQGNvbG9yL2tDb2xvclRocmVlTGV2ZWxUZXh0J1xuICB9IGVsc2Uge1xuICAgIG1vZHVsZURhdGEudXNkY0JnID0gJ0Bjb2xvci9LQmFzZUNvbG9yQ29udGVudEJhY2tncm91bmQnXG4gICAgbW9kdWxlRGF0YS51c2RjQ29sb3IgPSAnQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0J1xuICAgIG1vZHVsZURhdGEudXNkdEJnID0gJyMwMDAwMDAwMCdcbiAgICBtb2R1bGVEYXRhLnVzZHRDb2xvciA9ICdAY29sb3Iva0NvbG9yVGhyZWVMZXZlbFRleHQnXG4gIH1cbn1cblxubW9kdWxlRXZlbnQuaXRlbU9uQ2xpY2sgPSBmdW5jdGlvbiAocGFyZW50SW5kZXgsIGNoaWxkSW5kZXgpIHtcbiAgY29uc29sZS5sb2coYGl0ZW1PbkNsaWNrIGVsZW1lbnQgOiAke3BhcmVudEluZGV4fSAgJHtjaGlsZEluZGV4fWApO1xuICB2YXIgZWxlbWVudCA9IG1vZHVsZURhdGEubWFpbkRhdGFbcGFyZW50SW5kZXhdLnByb2R1Y3RzW2NoaWxkSW5kZXhdO1xuICBjb25zb2xlLmxvZyhgaXRlbU9uQ2xpY2sgZWxlbWVudCA6ICR7SlNPTi5zdHJpbmdpZnkoZWxlbWVudC5yYXdPYmplY3QoKSl9YCk7XG4gIHZhciBxdW90ZSA9IFwiXCI7XG4gIGlmIChwYXJhbWV0ZXIucHJvZHVjdFR5cGVJZCA9PSA1KSB7XG4gICAgcXVvdGUgPSBlbGVtZW50W1wiY3VycmVuY3lcIl07XG4gIH0gZWxzZSB7XG4gICAgcXVvdGUgPSBlbGVtZW50W1wiY292ZXJ0LWN1cnJlbmN5XCJdXG4gIH1cbiAgY29uc29sZS5sb2coYHByb2R1Y3RUeXBlSWQ9JHtwYXJhbWV0ZXIucHJvZHVjdFR5cGVJZH0mcHJvZHVjdElkPSR7ZWxlbWVudFtcInByb2R1Y3QtaWRcIl19JnByb2R1Y3RGaW5hbmNlSWQ9JHtlbGVtZW50W1wicHJvZHVjdC1maW5hbmNlLWlkXCJdfSZjdXJyZW5jeT0ke2VsZW1lbnRbXCJ0cmFkZS1jdXJyZW5jeVwiXX0mcXVvdGU9JHtxdW90ZX1gKTtcbiAgbGV0IHVybCA9IFwiaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9lZGdlZW5naW5lL2NvbnRhaW5lcj9zY2VuZT1kb3VibGVjb2luJnJvb3ROYW1lPXByb2R1Y3RzdWImbmF2Q29uZmlnPW5hdGl2ZVwiO1xuICBjb21tb24ub3BlblVSTChgJHt1cmx9JnByb2R1Y3RUeXBlSWQ9JHtwYXJhbWV0ZXIucHJvZHVjdFR5cGVJZH0mcHJvZHVjdElkPSR7ZWxlbWVudFtcInByb2R1Y3QtaWRcIl19JnByb2R1Y3RGaW5hbmNlSWQ9JHtlbGVtZW50W1wicHJvZHVjdC1maW5hbmNlLWlkXCJdfSZjdXJyZW5jeT0ke2VsZW1lbnRbXCJ0cmFkZS1jdXJyZW5jeVwiXX0mcXVvdGU9JHtxdW90ZX1gKTtcbn1cblxubW9kdWxlRXZlbnQudGFiQ2xpY2sgPSBmdW5jdGlvbiAodGFiVGFnKSB7XG4gIGNvbnNvbGUubG9nKGB0YWIgY2xpY2sgJHt0YWJUYWd9YClcbiAgaWYgKHRhYlRhZyA9PSBkNykge1xuICAgIGxpc3RSZXFPYmouY3ljbGUgPSAxO1xuICB9IGVsc2UgaWYgKHRhYlRhZyA9PSBkNzMpIHtcbiAgICBsaXN0UmVxT2JqLmN5Y2xlID0gMjtcbiAgfSBlbHNlIGlmICh0YWJUYWcgPT0gZDM5KSB7XG4gICAgbGlzdFJlcU9iai5jeWNsZSA9IDM7XG4gIH0gZWxzZSBpZiAodGFiVGFnID09IGQ5KSB7XG4gICAgbGlzdFJlcU9iai5jeWNsZSA9IDQ7XG4gIH0gZWxzZSB7XG4gICAgbGlzdFJlcU9iai5jeWNsZSA9IFwiXCI7XG4gIH1cbiAgZm9yICh2YXIgaSA9IDA7IGkgPCBtb2R1bGVEYXRhLnRhYkRhdGEubGVuZ3RoOyBpKyspIHtcbiAgICB2YXIgb2JqID0gbW9kdWxlRGF0YS50YWJEYXRhW2ldO1xuICAgIGlmIChvYmoudGl0bGVDb2xvciA9PSAnQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0Jykge1xuICAgICAgaWYgKG9iai50YWcgPT0gdGFiVGFnKSB7XG4gICAgICAgIHJldHVybjtcbiAgICAgIH1cbiAgICAgIHZhciB0ZW1PYmplY3QgPSBtb2R1bGVEYXRhLnRhYkRhdGFbaV07XG4gICAgICB0ZW1PYmplY3QudGFnID0gb2JqLnRpdGxlO1xuICAgICAgdGVtT2JqZWN0LnRpdGxlID0gb2JqLnRpdGxlO1xuICAgICAgdGVtT2JqZWN0LnRpdGxlQ29sb3IgPSAnQGNvbG9yL2tDb2xvclRocmVlTGV2ZWxUZXh0JztcbiAgICAgIHRlbU9iamVjdC50aXRsZVNpemUgPSBcIjE0XCI7XG4gICAgfVxuICAgIGlmIChvYmoudGFnID09IHRhYlRhZykge1xuICAgICAgLy8gbW9kdWxlRGF0YS50YWJEYXRhW2ldID0gZ2V0VGFiVWlEYXRhKG9iai50aXRsZSwgdHJ1ZSk7XG4gICAgICB2YXIgdGVtT2JqZWN0ID0gbW9kdWxlRGF0YS50YWJEYXRhW2ldO1xuICAgICAgdGVtT2JqZWN0LnRhZyA9IG9iai50aXRsZTtcbiAgICAgIHRlbU9iamVjdC50aXRsZSA9IG9iai50aXRsZTtcbiAgICAgIHRlbU9iamVjdC50aXRsZUNvbG9yID0gJ0Bjb2xvci9rQ29sb3JQcmltYXJ5VGV4dCc7XG4gICAgICB0ZW1PYmplY3QudGl0bGVTaXplID0gXCIxNlwiO1xuICAgIH1cbiAgfVxuICBpbnRlcnZhbFJlcXVlc3RQcm9kdWN0TGlzdCgpXG59XG5cbm1vZHVsZUV2ZW50LnJlZnJlc2ggPSBmdW5jdGlvbiAoKSB7XG4gIGludGVydmFsUmVxdWVzdFByb2R1Y3RMaXN0KCk7XG59XG5cbm1vZHVsZUV2ZW50LnRvQ3VzdG9tID0gZnVuY3Rpb24gKCkge1xuICBjb21tb24ub3BlblVSTChgaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9lZGdlZW5naW5lL2NvbnRhaW5lcj9zY2VuZT1kb3VibGVjb2luJnJvb3ROYW1lPWN1c3RvbSZuYXZDb25maWc9bmF0aXZlJmN1cnJlbmN5PSR7cGFyYW1ldGVyLmN1cnJlbmN5fSZxdW90ZUNvaW49JHttb2R1bGVEYXRhLnF1b3RlQ29pbn0mcHJvZHVjdFR5cGVJZD0ke3BhcmFtZXRlci5wcm9kdWN0VHlwZUlkfWApO1xufVxuXG5mdW5jdGlvbiBvbkRlc3Ryb3koKSB7XG4gIGNvbnNvbGUubG9nKFwiY29pbmRldGFpbCBvbkRlc3Ryb3lcIik7XG4gIGNsZWFyTGlzdFRpbWVyKCk7XG59IiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiO1xuXG5mdW5jdGlvbiBnZXROYXZDb25maWdTdHJpbmcoKSB7XG4gICAgbGV0IG5hdiA9IHtcbiAgICAgICAgJ3RpdGxlS2V5JzogJ25fZG91YmxlX2NvaW5fZWFybl93aGF0JyxcbiAgICAgICAgJ2xlZnQnOiB7XG4gICAgICAgICAgICAnYWN0aW9uJzoge1xuICAgICAgICAgICAgICAgICd0eXBlJzogJ2JhY2snLFxuICAgICAgICAgICAgICAgICdwYXJhbWV0ZXInOiAnJ1xuICAgICAgICAgICAgfSxcbiAgICAgICAgICAgICdpY29uJzogJ2VkZ2VfZW5naW5lX3RvcF9iYXJfYmFja19ub3JtYWwnXG4gICAgICAgIH1cbiAgICB9O1xuICAgIHJldHVybiBuYXY7XG59XG5cbmZ1bmN0aW9uIGRlZmF1bHREYXRhKCkge1xuXG4gICAgcmV0dXJuIHtcbiAgICAgICAgY3VycmVudFRhZzogMCxcbiAgICAgICAgY3VycmVudEluZGV4OiAwLFxuICAgICAgICB0aXRsZURhdGE6IFtcbiAgICAgICAgICAgIHtcbiAgICAgICAgICAgICAgICAndGl0bGUnOiAkaTE4bi5uX2RvdWJsZV9jb2luX3Byb2R1Y3RfaW50cm9kdWNlLFxuICAgICAgICAgICAgICAgICd0aXRsZVNpemUnOiAnMTQnLFxuICAgICAgICAgICAgICAgICd0aXRsZUNvbG9yJzogJ0Bjb2xvci9rQ29sb3JQcmltYXJ5VGV4dCcsXG4gICAgICAgICAgICAgICAgJ3RhZyc6ICcwJ1xuXG4gICAgICAgICAgICB9LFxuICAgICAgICAgICAge1xuICAgICAgICAgICAgICAgICd0aXRsZSc6ICRpMThuLm5fZG91YmxlX2NvaW5fcGF5bWVudF9yZWd1bGF0aW9uLFxuICAgICAgICAgICAgICAgICd0aXRsZVNpemUnOiAnMTQnLFxuICAgICAgICAgICAgICAgICd0aXRsZUNvbG9yJzogJ0Bjb2xvci9rQ29sb3JTZWNvbmRhcnlUZXh0JyxcbiAgICAgICAgICAgICAgICAndGFnJzogJzEnXG4gICAgICAgICAgICB9LFxuICAgICAgICAgICAge1xuICAgICAgICAgICAgICAgICd0aXRsZSc6ICRpMThuLm5fc2hhcmtfZmluX2NvbW1vbl9wcm9ibGVtLFxuICAgICAgICAgICAgICAgICd0aXRsZVNpemUnOiAnMTQnLFxuICAgICAgICAgICAgICAgICd0aXRsZUNvbG9yJzogJ0Bjb2xvci9rQ29sb3JTZWNvbmRhcnlUZXh0JyxcbiAgICAgICAgICAgICAgICAndGFnJzogJzInXG4gICAgICAgICAgICB9XG4gICAgICAgIF0sXG4gICAgICAgIHNsaWRlckRhdGE6IFt7XG4gICAgICAgICAgICBcImxpc3RUeXBlXCI6ICcxJyxcbiAgICAgICAgfSwge1xuICAgICAgICAgICAgXCJsaXN0VHlwZVwiOiAnMicsXG4gICAgICAgIH0sXG4gICAgICAgIHtcbiAgICAgICAgICAgIFwibGlzdFR5cGVcIjogJzMnLFxuICAgICAgICB9XSxcblxuICAgICAgICBjb21wb1RleHQxOiRpMThuLiRpbnRlcmNlcHQubl9kb3VibGVfY29pbl9wcm9kdWN0X29wZXJhdGlvbl9lZ19idXlfb25lX2xlc3MoJ+KJpCcpLFxuICAgICAgICBwcm9ibGVtczFPcGVuOid2aXNpYmxlJyxcbiAgICAgICAgcHJvYmxlbXMxQ2xvc2U6J2dvbmUnLFxuXG4gICAgICAgIHByb2JsZW1zMk9wZW46J2dvbmUnLFxuICAgICAgICBwcm9ibGVtczJDbG9zZTondmlzaWJsZScsXG5cbiAgICAgICAgcHJvYmxlbXMzT3BlbjonZ29uZScsXG4gICAgICAgIHByb2JsZW1zM0Nsb3NlOid2aXNpYmxlJyxcblxuICAgICAgICBwcm9ibGVtczRPcGVuOidnb25lJyxcbiAgICAgICAgcHJvYmxlbXM0Q2xvc2U6J3Zpc2libGUnLFxuXG4gICAgICAgIHByb2JsZW1zNU9wZW46J2dvbmUnLFxuICAgICAgICBwcm9ibGVtczVDbG9zZTondmlzaWJsZScsXG5cbiAgICAgICAgLy8gcHJvYmxlbXM2T3BlbjonZ29uZScsXG4gICAgICAgIC8vIHByb2JsZW1zNkNsb3NlOid2aXNpYmxlJyxcblxuICAgICAgICAvLyBwcm9ibGVtczdPcGVuOidnb25lJyxcbiAgICAgICAgLy8gcHJvYmxlbXM3Q2xvc2U6J3Zpc2libGUnLFxuXG4gICAgICAgIC8vIHByb2JsZW1zOE9wZW46J2dvbmUnLFxuICAgICAgICAvLyBwcm9ibGVtczhDbG9zZTondmlzaWJsZScsXG5cbiAgICAgICAgLy8gcHJvYmxlbXM5T3BlbjonZ29uZScsXG4gICAgICAgIC8vIHByb2JsZW1zOUNsb3NlOid2aXNpYmxlJyxcblxuICAgIH1cbn1cblxuXG5jb25zdCB7IG1vZHVsZURhdGEsIG1vZHVsZUV2ZW50IH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFwiaW50cm9kdWNlXCIsIGRlZmF1bHREYXRhLCB7IG9uQ3JlYXRlIH0pO1xuXG5mdW5jdGlvbiBvbkNyZWF0ZShwYXJhbSkge1xuICAgIGNvbnNvbGUubG9nKCdpbnRyb2R1Y2Ugb24gY3JlYXRlJyk7XG4gICAgY29uc29sZS5sb2cocGFyYW0pO1xuICAgIG1vZHVsZURhdGEubmF2Q29uZmlnID0gZ2V0TmF2Q29uZmlnU3RyaW5nKCk7XG4gICAgbGV0IHBhcmFtRGljID0gSlNPTi5wYXJzZShwYXJhbSk7XG4gICAgbGV0IGluZGV4ID0gcGFyc2VJbnQocGFyYW1EaWNbJ2luZGV4J10pO1xuICAgIGNvbnNvbGUubG9nKGluZGV4KTtcbiAgICBjb25zb2xlLmxvZyhwYXJzZUludChpbmRleCkpO1xuICAgIGlmIChpbmRleCA9PSB1bmRlZmluZWQgfHwgaXNOYU4oaW5kZXgpKSB7XG4gICAgICAgIGluZGV4ID0gMDtcbiAgICB9IFxuICAgIG1vZHVsZUV2ZW50LnRhYkNsaWNrKGluZGV4KTtcbn1cblxuXG5cbmZ1bmN0aW9uIHJlc2V0VGl0bGVzU3R5bGUoaWR4KSB7XG4gICAgZm9yIChsZXQgaSA9IDA7IGkgPCBtb2R1bGVEYXRhLnRpdGxlRGF0YS5sZW5ndGg7IGkrKykge1xuICAgICAgICB2YXIgb2JqID0gIG1vZHVsZURhdGEudGl0bGVEYXRhW2ldO1xuICAgICAgICBvYmoudGl0bGVTaXplPScxNCc7XG4gICAgICAgIG9iai50aXRsZUNvbG9yID0gJ0Bjb2xvci9rQ29sb3JTZWNvbmRhcnlUZXh0JztcbiAgICB9XG4gICB2YXIgY3VyID0gIG1vZHVsZURhdGEudGl0bGVEYXRhW2lkeF07XG4gICBjdXIudGl0bGVDb2xvciA9ICdAY29sb3Iva0NvbG9yUHJpbWFyeVRleHQnO1xufVxuXG5tb2R1bGVFdmVudC5vcGVuT3JDbG9zZVByb2JsZW0gPSAgZnVuY3Rpb24gKGluZGV4KSB7XG4gICBsZXQgdmlzaWJsZSA9IG1vZHVsZURhdGFbYHByb2JsZW1zJHtpbmRleH1PcGVuYF07XG4gICBpZiAodmlzaWJsZSA9PSAndmlzaWJsZScpIHtcbiAgICAgICAgbW9kdWxlRGF0YVtgcHJvYmxlbXMke2luZGV4fUNsb3NlYF0gPSB2aXNpYmxlO1xuICAgICAgICB2aXNpYmxlID0gJ2dvbmUnXG4gICB9IGVsc2Uge1xuICAgICAgICBtb2R1bGVEYXRhW2Bwcm9ibGVtcyR7aW5kZXh9Q2xvc2VgXSA9IHZpc2libGU7XG4gICAgICAgIHZpc2libGUgPSAndmlzaWJsZSdcbiAgIH1cbiAgIG1vZHVsZURhdGFbYHByb2JsZW1zJHtpbmRleH1PcGVuYF0gPSB2aXNpYmxlO1xufVxuXG5tb2R1bGVFdmVudC50YWJDbGljayA9IGZ1bmN0aW9uIChpZHgpIHtcbiAgICByZXNldFRpdGxlc1N0eWxlKGlkeCk7XG4gICAgbW9kdWxlRGF0YS5jdXJyZW50SW5kZXggPSBgJHtpZHh9YDtcbn1cblxubW9kdWxlRXZlbnQucmVzZXRUaXRsZVNlbGVjdFRhYiA9IGZ1bmN0aW9uIChpZHgpIHtcbiAgICByZXNldFRpdGxlc1N0eWxlKGlkeCk7XG59XG5cbiIsImltcG9ydCAqIGFzIGNvbW1vbiBmcm9tIFwiLi9jb21tb25cIjtcblxuZnVuY3Rpb24gZGVmYXVsdERhdGEoKSB7XG4gIHJldHVybiB7XG4gICAgbWFpbkRhdGE6IHt9LFxuICAgIHllYXJZaWVsZDogXCItLVwiLC8v5Y+C6ICD5bm05YyWXG4gICAgeWllbGQ6IFwiLS1cIiwvL+aUtuebiueOh1xuICAgIGV4cGlyZURhdGU6IFwiLS1cIiwvL+acn+mZkFxuICAgIGhvb2tQcmljZTogXCItLVwiLC8v55uu5qCH5Lu3XG4gICAgcHJpY2VMaW1pdDogXCItLVwiLC8v5rao6LeM5bmFXG4gICAgc3ViSGludDogXCJcIiwvL+eUs+i0reaVsOmHj+aPkOekuuivrVxuICAgIHN1YklucHV0OiBcIlwiLC8v55Sz6LSt5pWw6YeP6L6T5YWl5qGGXG4gICAgc3ViT25Gb2N1czogZmFsc2UsLy/nlLPotK3nhKbngrlcbiAgICBiYXNlQ29pbjogXCJcIiwvL+WfuuehgOW4geenjVxuICAgIHF1b3RlQ29pbjogXCJcIiwvL+aMgumSqeW4geenjVxuICAgIGJhbGFuY2U6IFwiLS1cIiwvL+S9meminVxuICAgIGVzdGltYXRlZFByb2ZpdDogXCItLVwiLC8v6aKE5Lyw5pS255uKXG4gICAgcmVzaWR1ZUJ1eTogXCJcIiwvL+WJqeS9meWPr+eUs+i0rVxuICAgIHdwT25Gb2N1czogZmFsc2UsLy/otY7lm57nhKbngrlcbiAgICBzdWJVbml0OiBcIlwiLC8v5Y2V5L2NXG4gICAgaW5kZXhQcmljZTogXCJcIiwvL+aMh+aVsOS7t1xuICAgIHdpdGhkcmF3UHJpY2VIaW50OiBcIlwiLC8v6LWO5Zue5Lu35o+Q56S66K+tXG4gICAgd2l0aGRyYXdQcmljZVZpczogXCJnb25lXCIsLy/otY7lm57ku7fovpPlhaXmoYZcbiAgICByZWRlZW1QcmljZVZpczogXCJnb25lXCIsLy/mmK/lkKblsZXnpLrotY7lm57ku7dcbiAgICBvcGVuQ2xvc2VTdHI6ICRpMThuLm5fY29udGVudF9leHBhbmQsXG4gICAgb3BlbkNsb3NlUmVzOiBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9pY19kY19zdGF0dXNfb3BlblwiLFxuICAgIGNoYXJ0QmFzZURhdGE6IFwiXCIsLy/lm77ooajln7rnoYDmlbDmja5cbiAgICB3aXRoRHJhd1ByaWNlOiBcIlwiLC8v6LWO5Zue5Lu3XG4gICAgcXVhbnRpdHk6IFwiXCIsLy/nlLPotK3mlbDph49cbiAgICBvcGVuQWNjb3VudEFsZXJ0U2hvdzogZmFsc2UsLy/lvIDpgJrmnJ/mnYPotKbmiLflvLnnqpdcbiAgICB0aXBzQWxlcnRTaG93Q29tbW9uOiBmYWxzZSwvL3RpcHPlvLnnqpdcbiAgICB0aXBzQWxlcnRTaG93V3A6IGZhbHNlLC8vdGlwc+W8ueeql1xuICAgIGV4cGlyZVRpbWVUaXBzOiBcIlwiLC8v5Yiw5pyf5pe26Ze05paH5qGIXG4gICAgd3BCb3JkZXJDb2xvcjogXCJAY29sb3IvS0Jhc2VDb2xvcklucHV0QmFja2dyb3VuZFwiLC8vXG4gICAgc3ViQm9yZGVyQ29sb3I6IFwiQGNvbG9yL0tCYXNlQ29sb3JJbnB1dEJhY2tncm91bmRcIiwvL1xuICAgIHN1YkVycm9yU3RyOiBcIlwiLC8v55Sz6LSt6L6T5YWl5qGG6ZSZ6K+v5paH5qGIXG4gICAgc3ViRXJyb3JWaXM6IFwiZ29uZVwiLC8vXG4gICAgd3BFcnJvclN0cjogXCJcIiwvL+i1juWbnuS7t+i+k+WFpeahhumUmeivr+aWh+ahiFxuICAgIHdwRXJyb3JWaXM6IFwiZ29uZVwiLC8vXG4gICAgdGlwc1N0cjogXCJcIiwvL3RpcHPlvLnnqpfmlofmoYhcbiAgICBwcmluY2lwYWxQcmVjaXNpb246IDQsLy/mnKzph5Hnsr7luqZcbiAgICBidG5Db2xvcjogXCJAY29sb3Iva0NvbG9yRUJFQkVCXCIsLy/nlLPotK3mjInpkq7popzoibJcblx0YnRuVGl0bGVDb2xvcjogXCJAY29sb3Iva0NvbG9yVGhyZWVMZXZlbFRleHRcIiwgLy8g55Sz6LSt5paH5a2X6aKc6ImyXG4gICAgc3ViQWxlcnRTaG93OiBmYWxzZSwvL+iuouWNleehruiupOW8ueeql1xuICAgIHByb2R1Y3ROYW1lOiBcIlwiLC8v5Lqn5ZOB5ZCN56ewXG4gICAgd2l0aERyYXdWaXM6IFwiZ29uZVwiLC8v6LWO5Zue5Lu35bGV56S654q25oCBXG4gICAgcG9wMVNob3c6IFwiZmFsc2VcIixcbiAgICBwb3AyU2hvdzogXCJmYWxzZVwiLFxuICAgIHBvcDNTaG93OiBcImZhbHNlXCIsXG5cdGh1b2JpU2VsZWN0ZWQ6IGZhbHNlLFxuXHRodW9iaUFncmVlSW1hZ2U6IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2xpdmVfcmVkcGFja2V0X3Vuc2VsZWN0XCIsXG5cdGFncmVlVGV4dDogXCJcIixcblx0ZG9Db2xvcjogXCJAY29sb3IvZUJ1dHRvblVuZW5hYmxlZEJnQ29sb3JcIixcblx0ZG9CYWNrQ29sb3I6IFwiQGNvbG9yL2tDb2xvckVCRUJFQlwiLFxuICB9O1xufVxuXG4vL+aVtOS9k+WPguaVsFxudmFyIHBhcmFtZXRlciA9IHt9O1xuXG4vL+aMh+aVsOS7t+WPguaVsFxudmFyIGluZGV4UHJpY2VSZXFPYmogPSB7fTtcblxuLy/mjIfmlbDova7orq3lmahcbmxldCBpbmRleFByaWNlVGltZXI7XG4vL+ivpuaDhei9ruiureWZqFxubGV0IHN1YkRldGFpbFRpbWVyO1xuLy/or6Lku7fova7orq3lmahcbmxldCBjaGVja1ByaWNlVGltZXI7XG5cbi8v55Sz6LSt6L6T5YWl5qGGXG52YXIgc3ViSW5wdXQgPSBcIlwiO1xuXG4vL+i1juWbnui+k+WFpeahhlxudmFyIHdwSW5wdXQgPSBcIlwiO1xuXG4vL+acgOWwj+i1t+aKlVxudmFyIG1NaW5TdWIgPSBcIlwiO1xuXG4vL+eUs+i0reaMiemSrueKtuaAgVxudmFyIGJ0bkVuYWJsZSA9IGZhbHNlO1xuXG4vLyDlj6/nlKjkvZnpop3vvIzorrDlvZXliJ3lp4vlgLzvvIzpmLLmraLnsr7luqborqHnrpfml7blgLzkuKLlpLFcbnZhciBtQmFsYW5jZSA9IFwiMFwiO1xuXG52YXIgaW5kZXhQcmllID0gXCIwXCI7XG5cbmNvbnN0IG1tID0gNjAwMDA7XG5jb25zdCBoaCA9IDM2MDAwMDA7XG5jb25zdCBkZCA9IDg2NDAwMDAwO1xuXG4xMDAwICogNjAgKiA2MCAqIDI0XG5cbmNvbnN0IHsgbW9kdWxlRGF0YSwgbW9kdWxlRXZlbnQgfSA9IGNvbW1vbi5tb2R1bGVEZWZpbmUoXCJwcm9kdWN0c3ViXCIsIGRlZmF1bHREYXRhLCB7IG9uQ3JlYXRlLCBvbkRlc3Ryb3ksIG9uUmVzdW1lIH0pO1xuXG5mdW5jdGlvbiBvbkNyZWF0ZShqc29uUGFyYW1ldGVycykge1xuICBjb25zb2xlLmxvZyhgb25DcmVhdGUganNvblBhcmFtZXRlcnMgOiAke2pzb25QYXJhbWV0ZXJzfWApO1xuICAvLyBwYXJhbWV0ZXIgPSB7XG4gIC8vICAgcHJvZHVjdFR5cGVJZDogNiwvLzXvvJrmioTlupXlrp3vvIw277ya5q2i6LWi5a6dXG4gIC8vICAgcHJvZHVjdElkOiBcIlwiLC8v5Lqn5ZOBaWRcbiAgLy8gICBwcm9kdWN0RmluYW5jZUlkOiBcIlwiLC8v5Lqn5ZOB5piO57uGSURcbiAgLy8gICBob29rUHJpY2U6IFwiXCIsIC8v5oyC6ZKp5Lu3IO+8iOWumuWItuS6p+WTge+8iVxuICAvLyAgIGV4cGlyZUF0OiBcIlwiLC8v5Yiw5pyf5pe26Ze0IO+8iOWumuWItuS6p+WTge+8iVxuICAvLyAgIGN1cnJlbmN5OiBcImJ0Y1wiLC8v5Z+656GA5biB56eNXG4gIC8vICAgcXVvdGU6IFwidXNkdFwiLy/mjILpkqnluIHnp41cbiAgLy8gfTtcblxuICBwYXJhbWV0ZXIgPSBKU09OLnBhcnNlKGpzb25QYXJhbWV0ZXJzKTtcblxuICBpbml0VWkoKTtcblxuICBpbml0RGF0YSgpO1xufVxuXG5hc3luYyBmdW5jdGlvbiBvblJlc3VtZSgpIHtcbiAgY29uc29sZS5sb2coYG9uUmVzdW1lYCk7XG4gIC8v5L2Z6aKdXG4gIHJlcXVlc3RCYW5sYW5jZSgpO1xufVxuXG5mdW5jdGlvbiBpbml0VWkoKSB7XG4gIC8v5qCH6aKYXG4gIGxldCB0aXRsZSA9IFwiXCI7XG4gIGlmIChwYXJhbWV0ZXIucHJvZHVjdFR5cGVJZCA9PSA1KSB7XG4gICAgbW9kdWxlRGF0YS5zdWJVbml0ID0gcGFyYW1ldGVyLnF1b3RlLnRvVXBwZXJDYXNlKClcbiAgICB0aXRsZSA9ICRpMThuLiRpbnRlcmNlcHQubl9kb3VibGVfY29pbl9lYXJuX2xvd19idXlfc29tZXRoaW5nKHBhcmFtZXRlci5xdW90ZS50b1VwcGVyQ2FzZSgpLCBwYXJhbWV0ZXIuY3VycmVuY3kudG9VcHBlckNhc2UoKSk7XG4gIH0gZWxzZSB7XG4gICAgbW9kdWxlRGF0YS5zdWJVbml0ID0gcGFyYW1ldGVyLmN1cnJlbmN5LnRvVXBwZXJDYXNlKClcbiAgICB0aXRsZSA9ICRpMThuLiRpbnRlcmNlcHQubl9kb3VibGVfY29pbl9lYXJuX2hpZ2hfc2VsbF9mb3IocGFyYW1ldGVyLmN1cnJlbmN5LnRvVXBwZXJDYXNlKCksIHBhcmFtZXRlci5xdW90ZS50b1VwcGVyQ2FzZSgpKTtcbiAgfVxuICBtb2R1bGVEYXRhLnN0YXR1c0JhckNvbmZpZyA9IHsgXCJzdGF0dXNCYXJNb2RlXCI6IFwidHJ1ZVwiLCBcImFkU3RhdHVzQmFyQ29sb3JcIjogXCJLQmFzZUNvbG9ySW5wdXRCYWNrZ3JvdW5kXCIsIFwia2V5Qm9hcmRNb2RlXCI6IFwiYWRqdXN0UGFuXCIgfTtcblxuICBtb2R1bGVEYXRhLm5hdkNvbmZpZyA9IGdldE5hdkNvbmZpZ1N0cmluZyh0aXRsZSk7XG4gIC8v5Z+656GA5biB56eN5LiO6K6h5Lu35biB56eNXG4gIG1vZHVsZURhdGEuYmFzZUNvaW4gPSBwYXJhbWV0ZXIuY3VycmVuY3kudG9VcHBlckNhc2UoKTtcbiAgbW9kdWxlRGF0YS5xdW90ZUNvaW4gPSBwYXJhbWV0ZXIucXVvdGUudG9VcHBlckNhc2UoKTtcblxuXHRjb25zdCBjb2xvciA9IGNvbW1vbi5jb21tb25EYXRhLmNvbG9yTW9kZSA9PSAxID8gXCIjRTZFNkU2XCIgOiBcIiMwMDAwMDBcIjtcblx0Y29uc3QgZnVsbFRleHQgPSAkaTE4bi5uX2RvdWJsZWNvaW5fcG9wX2FncmVlbWVudF9jb250ZW50X2Z1bGw7XG5cdGNvbnN0IHJpY2hUZXh0ID0gJGkxOG4ubl9kb3VibGVjb2luX3BvcF9hZ3JlZW1lbnRfY29udGVudDtcblx0Y29uc3Qgc3BhblN0YXJ0ID0gYDxzcGFuIHN0eWxlPVwiY29sb3I6JHtjb2xvcn07IGZvbnQtc2l6ZToxMnB4O1wiPmA7XG5cdGNvbnN0IHJpY2hIaWdobGlnaHQgPSBgPC9zcGFuPjxzcGFuIHN0eWxlPVwiY29sb3I6IzAxNzNFNTsgZm9udC1zaXplOjEycHg7XCI+JHtyaWNoVGV4dH08L3NwYW4+JHtzcGFuU3RhcnR9YDtcblx0Y29uc3Qgam9pblRleHQgPSBmdWxsVGV4dC5zcGxpdChyaWNoVGV4dCkuam9pbihyaWNoSGlnaGxpZ2h0KTtcblx0bW9kdWxlRGF0YS5hZ3JlZVRleHQgPSBgJHtzcGFuU3RhcnR9JHtqb2luVGV4dH08L3NwYW4+YDtcbn1cblxuZnVuY3Rpb24gaW5pdERhdGEoKSB7XG4gIC8v5oyH5pWw5Lu3XG4gIGludGVydmFsUmVxdWVzdEluZGV4UHJpY2UoKTtcbiAgLy/kuqflk4Hor6bmg4VcbiAgaW50ZXJ2YWxTdWJEZXRhaWwoKTtcbn1cblxuZnVuY3Rpb24gaW50ZXJ2YWxTdWJEZXRhaWwoKSB7XG4gIGlmIChzdWJEZXRhaWxUaW1lciA9PSBudWxsKSB7XG4gICAgcmVxdWVzdFN1YkRldGFpbCgpO1xuICAgIHN1YkRldGFpbFRpbWVyID0gc2V0SW50ZXJ2YWwocmVxdWVzdFN1YkRldGFpbCwgMTAwMDApO1xuICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlcXVlc3RCYW5sYW5jZSgpIHtcbiAgaWYgKGNvbW1vbi5hY2NvdW50SWQgPT0gLTEpIHtcbiAgICBjb25zb2xlLmxvZyhg6LSm5oi3SUTojrflj5blpLHotKVgKVxuICAgIHJldHVybjtcbiAgfVxuICBjb25zdCBkYXRhID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KGB2MS9hY2NvdW50L2FjY291bnRzLyR7Y29tbW9uLmFjY291bnRJZH0vYmFsYW5jZWAsIHt9LCAwLCA0KTtcbiAgaWYgKGRhdGEgIT0gbnVsbCAmJiBkYXRhLmxpc3QgIT0gbnVsbCkge1xuICAgIGZvciAodmFyIGkgPSAwOyBpIDwgZGF0YS5saXN0Lmxlbmd0aDsgaSsrKSB7XG4gICAgICBsZXQgZWxlbWVudCA9IGRhdGEubGlzdFtpXTtcbiAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0QmFubGFuY2UgOiAke2VsZW1lbnQuY3VycmVuY3kudG9VcHBlckNhc2UoKX0gIC0tLS0tLSAgJHttb2R1bGVEYXRhLnN1YlVuaXR9ICAgIC0tLS0tLSAke2VsZW1lbnQuY3VycmVuY3kudG9VcHBlckNhc2UoKSA9PSBtb2R1bGVEYXRhLnN1YlVuaXR9YClcbiAgICAgIGlmIChlbGVtZW50LnR5cGUgPT0gXCJ0cmFkZVwiICYmIGVsZW1lbnQuY3VycmVuY3kudG9VcHBlckNhc2UoKSA9PSBtb2R1bGVEYXRhLnN1YlVuaXQpIHtcbiAgICAgICAgLy8g57K+5bqmIOacgOWkmjjkvY1cbiAgICAgICAgdmFyIGZvcm1hdEJhbGFuY2UgPSBjb21tb24uZm9ybWF0UHJlY2lzaW9uKGVsZW1lbnQuYmFsYW5jZSwgOCkudG9TdHJpbmcoKTtcbiAgICAgICAgY29uc29sZS5sb2coYGRvdWJsZUNvaW5Gb3JtYXQgc3RyaW5nVmFsdWUgOiAke2Zvcm1hdEJhbGFuY2V9IGApO1xuICAgICAgICBjb25zb2xlLmxvZyhgZG91YmxlQ29pbkZvcm1hdCBzdHJpbmdWYWx1ZSA6ICR7cmVtb3ZlRXh0cmFaZXJvcyhmb3JtYXRCYWxhbmNlKX0gYCk7XG4gICAgICAgIG1vZHVsZURhdGEuYmFsYW5jZSA9IGAke3JlbW92ZUV4dHJhWmVyb3MoY29tbW9uLmZvcm1hdFByZWNpc2lvbihlbGVtZW50LmJhbGFuY2UsIDgpLnRvU3RyaW5nKCkpfWA7XG4gICAgICAgIG1CYWxhbmNlID0gZWxlbWVudC5iYWxhbmNlO1xuICAgICAgICBicmVhaztcbiAgICAgIH1cbiAgICB9XG4gIH0gZWxzZSB7XG4gICAgbW9kdWxlRGF0YS5iYWxhbmNlID0gYC0tYDtcbiAgfVxufVxuXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0U3ViRGV0YWlsKCkge1xuICBsZXQgcmVxT2JraiA9IHtcbiAgICBwcm9kdWN0VHlwZUlkOiBwYXJhbWV0ZXIucHJvZHVjdFR5cGVJZCxcbiAgICBwcm9kdWN0SWQ6IHBhcmFtZXRlci5wcm9kdWN0SWQsXG4gICAgcHJvZHVjdEZpbmFuY2VJZDogcGFyYW1ldGVyLnByb2R1Y3RGaW5hbmNlSWQsXG4gICAgaG9va1ByaWNlOiBwYXJhbWV0ZXIuaG9va1ByaWNlLFxuICAgIGV4cGlyZUF0OiBwYXJhbWV0ZXIuZXhwaXJlQXQsXG4gIH07XG5cbiAgY29uc3QgZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdCgnb3RjL29wdC9vcHRpb24vb3JkZXIvdjIvZG91YmxlLWN1cnJlbmN5LXdpbi9wcm9kdWN0JywgcmVxT2Jraik7XG4gIGNvbnNvbGUubG9nKGBtYWluRGF0YSA6ICR7SlNPTi5zdHJpbmdpZnkoZGF0YSl9YClcbiAgbW9kdWxlRGF0YS5tYWluRGF0YSA9IGRhdGE7XG4gIGlmIChkYXRhICE9IG51bGwpIHtcblx0aWYgKGNoZWNrUHJpY2VUaW1lciA9PSBudWxsKSB7XG5cdFx0Ly/lj4LogIPlubTljJZcblx0XHRtb2R1bGVEYXRhLnllYXJZaWVsZCA9IGAke2NvbW1vbi5mb3JtYXRQcmVjaXNpb24oZGF0YS5hcnIsIDIpfSVgO1xuXHRcdC8v5pS255uK546HXG5cdFx0bW9kdWxlRGF0YS55aWVsZCA9IGAke2NvbW1vbi5mb3JtYXRQcmVjaXNpb24oZGF0YVtcImVhcm5pbmctcmF0ZVwiXSwgNCl9JWA7XG5cdH1cbiAgICAvL+acn+mZkFxuICAgIGxldCBjdXJyVGltZSA9IGRhdGFbXCJjdXJyLXRpbWVcIl07XG4gICAgbGV0IGV4cGlyZVRpbWUgPSBkYXRhW1wiZXhwaXJlLWF0XCJdO1xuICAgIGxldCBkaWZmVGltZSA9IGV4cGlyZVRpbWUgLSBjdXJyVGltZTtcbiAgICBsZXQgcmVtYWluSW5nID0gXCJcIjtcbiAgICBpZiAoZGlmZlRpbWUgPiAwKSB7XG4gICAgICBjb25zdCBkID0gTWF0aC5mbG9vcihkaWZmVGltZSAvIGRkKTtcbiAgICAgIGNvbnN0IGggPSBNYXRoLmZsb29yKGRpZmZUaW1lIC8gaGgpO1xuICAgICAgaWYgKGQgPiAwKSB7XG4gICAgICAgIHJlbWFpbkluZyA9IGAke2R9JHskaTE4bi5uX2RheX1gXG4gICAgICB9IGVsc2Uge1xuICAgICAgICByZW1haW5JbmcgPSBgJHtofSR7JGkxOG4ubl9ob3VyfWBcbiAgICAgIH1cbiAgICB9XG4gICAgbGV0IGV4cGlyZSA9ICRpMThuLiRpbnRlcmNlcHQubl9kb3VibGVfY29pbl9lYXJuX2V4cGlyZV9kYXRlX25ldyhgJHtuZXcgRGF0ZShleHBpcmVUaW1lKS5Gb3JtYXQoXCJ5eXl5L01NL2RkIGhoOm1tXCIpfWApO1xuICAgIG1vZHVsZURhdGEuZXhwaXJlRGF0ZSA9IGAke3JlbWFpbkluZ30gICgke2V4cGlyZX0pYDtcbiAgICAvL+ebruagh+S7t1xuICAgIG1vZHVsZURhdGEuaG9va1ByaWNlID0gZGF0YVtcImhvb2stcHJpY2VcIl07XG4gICAgLy/nlLPotK3mlbDph4/mj5DnpLror61cbiAgICBtTWluU3ViID0gZGF0YVtcIm1pbi1leHBlbnNlc1wiXTtcbiAgICBtb2R1bGVEYXRhLnN1YkhpbnQgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fc2hhcmtfZmluX21pbl9hbW91bnQoYCR7bU1pblN1Yn1gKTtcbiAgICAvL+WJqeS9meWPr+eUs+i0rVxuICAgIG1vZHVsZURhdGEucmVzaWR1ZUJ1eSA9IGAkeyhkYXRhW1widG90YWwtcXVhbnRpdHlcIl0pIC0gKGRhdGFbXCJ1c2VkLXF1YW50aXR5XCJdKX1gO1xuICAgIC8v6LWO5Zue5Lu35o+Q56S66K+tXG4gICAgaWYgKHBhcmFtZXRlci5wcm9kdWN0VHlwZUlkID09IDUpIHtcbiAgICAgIG1vZHVsZURhdGEud2l0aGRyYXdQcmljZUhpbnQgPSAkaTE4bi4kaW50ZXJjZXB0Lm5fZG91YmxlX2NvaW5fd2l0aGRyYXdfcHJpY2VfbG93X2J1eV9oaW50KGRhdGFbXCJob29rLXByaWNlXCJdKTtcbiAgICB9IGVsc2Uge1xuICAgICAgbW9kdWxlRGF0YS53aXRoZHJhd1ByaWNlSGludCA9ICRpMThuLiRpbnRlcmNlcHQubl9kb3VibGVfY29pbl93aXRoZHJhd19wcmljZV9oaWdoX3NlbGxfaGludChkYXRhW1wiaG9vay1wcmljZVwiXSk7XG4gICAgfVxuICAgIC8v5Lqn5ZOB5ZCN56ewXG4gICAgbW9kdWxlRGF0YS5wcm9kdWN0TmFtZSA9IGRhdGFbXCJwcm9kdWN0LW5hbWVcIl07XG4gICAgLy/mnKzph5Hnsr7luqZcbiAgICBtb2R1bGVEYXRhLnByaW5jaXBhbFByZWNpc2lvbiA9IGRhdGFbXCJwcmluY2lwYWwtcHJlY2lzaW9uXCJdXG4gICAgLy/mmK/lkKblsZXnpLrotY7lm57ku7dcbiAgICBpZiAoZGF0YVtcInNob3ctcmVkZWVtLXByaWNlXCJdID09IHRydWUpIHtcbiAgICAgIG1vZHVsZURhdGEucmVkZWVtUHJpY2VWaXMgPSBcInZpc2libGVcIlxuICAgIH0gZWxzZSB7XG4gICAgICBtb2R1bGVEYXRhLnJlZGVlbVByaWNlVmlzID0gXCJnb25lXCJcbiAgICAgIG1vZHVsZURhdGEud2l0aGRyYXdQcmljZVZpcyA9IFwiZ29uZVwiXG4gICAgfVxuICAgIC8v5Zu+6KGo5Z+656GA5pWw5o2uXG4gICAgdmFyIGNoYXJ0QmFzZURhdGEgPSB7XG4gICAgICBwcm9kdWN0VHlwZUlkOiBwYXJhbWV0ZXIucHJvZHVjdFR5cGVJZCxcbiAgICAgIGJhc2VDb2luOiBwYXJhbWV0ZXIuY3VycmVuY3ksXG4gICAgICBxdW90ZUNvaW46IHBhcmFtZXRlci5xdW90ZSxcbiAgICAgIGhvb2tQcmljZTogZ2V0SG9va1ByaWNlKClcbiAgICB9XG5cbiAgICBjb25zb2xlLmxvZyhgY2hhcnRCYXNlRGF0YSDvvJogJHttb2R1bGVEYXRhLmNoYXJ0QmFzZURhdGEgPT0gXCJcIn0gICR7bW9kdWxlRGF0YS5jaGFydEJhc2VEYXRhICE9IEpTT04uc3RyaW5naWZ5KGNoYXJ0QmFzZURhdGEpfWApO1xuICAgIGlmIChtb2R1bGVEYXRhLmNoYXJ0QmFzZURhdGEgPT0gXCJcIiB8fCBtb2R1bGVEYXRhLmNoYXJ0QmFzZURhdGEgIT0gSlNPTi5zdHJpbmdpZnkoY2hhcnRCYXNlRGF0YSkpIHtcbiAgICAgIG1vZHVsZURhdGEuY2hhcnRCYXNlRGF0YSA9IEpTT04uc3RyaW5naWZ5KGNoYXJ0QmFzZURhdGEpO1xuICAgIH1cblxuICAgIHZhciBndWlkZVNob3cgPSBhd2FpdCAkbmF0aXZlQVBJLnN0b3JhZ2Uoe1xuICAgICAgYWN0aW9uOiBcInJlYWRcIixcbiAgICAgIG5hbWU6IFwiZG91YmxlQ29pblwiLFxuICAgICAga2V5OiBcImd1aWRlX3Nob3dcIlxuICAgIH0pXG4gICAgaWYgKGd1aWRlU2hvdyA9PSBudWxsIHx8IGd1aWRlU2hvdyA9PSBcIlwiKSB7XG4gICAgICBtb2R1bGVEYXRhLnBvcDFTaG93ID0gdHJ1ZTtcbiAgICAgICRuYXRpdmVBUEkuc3RvcmFnZSh7XG4gICAgICAgIGFjdGlvbjogXCJzYXZlXCIsXG4gICAgICAgIG5hbWU6IFwiZG91YmxlQ29pblwiLFxuICAgICAgICBrZXk6IFwiZ3VpZGVfc2hvd1wiLFxuICAgICAgICBkYXRhOiBcIjFcIlxuICAgICAgfSlcbiAgICB9XG5cbiAgICAvL+iuoeeul+a2qOi3jOW5hVxuICAgIGNhbFByaWNlTGltaXQoKTtcbiAgfSBlbHNlIHtcbiAgICBjb21tb24uY29udGFpbmVyQmFjaygpO1xuICB9XG59XG5cbmZ1bmN0aW9uIHJlbW92ZUV4dHJhWmVyb3MobnVtKSB7XG4gIHJldHVybiBudW0ucmVwbGFjZSgvKFxcLlxcZCo/WzEtOV0pMCskLywgJyQxJyk7XG59XG5cbmZ1bmN0aW9uIGludGVydmFsQ2hlY2tQcmljZSgpIHtcbiAgY2xlYXJDaGVja1ByaWNlVGltZXIoKTtcbiAgaWYgKGNoZWNrUHJpY2VUaW1lciA9PSBudWxsKSB7XG4gICAgcmVxdWVzdENoZWNrUHJpY2UoKTtcbiAgICBjaGVja1ByaWNlVGltZXIgPSBzZXRJbnRlcnZhbChyZXF1ZXN0Q2hlY2tQcmljZSwgMTAwMDApO1xuICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHJlcXVlc3RDaGVja1ByaWNlKCkge1xuICB2YXIgcmVxT2JraiA9IHtcbiAgICBwcm9kdWN0VHlwZUlkOiBwYXJhbWV0ZXIucHJvZHVjdFR5cGVJZCxcbiAgICBwcm9kdWN0RmluYW5jZUlkOiBwYXJhbWV0ZXIucHJvZHVjdEZpbmFuY2VJZCxcbiAgICB0cmFkZUN1cnJlbmN5OiBwYXJhbWV0ZXIuY3VycmVuY3ksXG4gICAgY3VycmVuY3k6IHBhcmFtZXRlci5wcm9kdWN0VHlwZUlkID09IDUgPyBwYXJhbWV0ZXIucXVvdGUgOiBwYXJhbWV0ZXIuY3VycmVuY3ksXG4gICAgaG9va1ByaWNlOiBnZXRIb29rUHJpY2UoKSxcbiAgICBleHBlbnNlc1BheWFibGU6IHN1YklucHV0LFxuICAgIGV4cGlyZUF0OiBnZXRFeHBpcmVBdCgpLFxuICB9XG4gIGlmICh3cElucHV0ICE9IG51bGwgJiYgd3BJbnB1dCAhPSBcIlwiKSB7XG4gICAgcmVxT2Jrai5yZWRlZW1QcmljZSA9IHdwSW5wdXRcbiAgfVxuICBjb25zdCByZXNwb25zZSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdDIoJ290Yy9vcHQvb3B0aW9uL29yZGVyL3YxL2RvdWJsZS1jdXJyZW5jeS13aW4vcHJpY2luZycsIHJlcU9ia2opO1xuICB2YXIgeyBjb2RlLCBkYXRhIH0gPSByZXNwb25zZTtcbiAgY29uc29sZS5sb2coYHJlcXVlc3RDaGVja1ByaWNlIDogJHtKU09OLnN0cmluZ2lmeShkYXRhKX1gKVxuICBpZiAoY29kZSA9PSAyMDAgfHwgcmVzcG9uc2Uuc3RhdHVzID09IFwib2tcIikge1xuICAgIG1vZHVsZURhdGEuZXN0aW1hdGVkUHJvZml0ID0gZGF0YVtcImVzdGltYXRlLXByb2ZpdFwiXTtcbiAgICBtb2R1bGVEYXRhLnllYXJZaWVsZCA9IGAke2NvbW1vbi5mb3JtYXRQcmVjaXNpb24oZGF0YVtcImFyclwiXSwgMil9JWA7XG4gICAgbW9kdWxlRGF0YS55aWVsZCA9IGAke2NvbW1vbi5mb3JtYXRQcmVjaXNpb24oZGF0YVtcImVhcm5pbmctcmF0ZVwiXSwgNCl9JWA7XG4gICAgbW9kdWxlRGF0YS53cEJvcmRlckNvbG9yID0gXCJAY29sb3IvS0Jhc2VDb2xvcklucHV0QmFja2dyb3VuZFwiO1xuICAgIG1vZHVsZURhdGEud3BFcnJvclZpcyA9IFwiZ29uZVwiO1xuICAgIGNoZWNrQnRuU3RhdHVzKCk7XG4gIH0gZWxzZSB7XG4gICAgaWYgKGNvZGUgPT09IDQwMDQ2KSB7XG4gICAgICBtb2R1bGVEYXRhLmVzdGltYXRlZFByb2ZpdCA9IFwiLS1cIjtcbiAgICAgIG1vZHVsZURhdGEud3BFcnJvclN0ciA9ICRpMThuLm5fZG91YmxlX2NvaW5fd3BfcHJpY2VfZXJyb3JfdGlwcztcbiAgICAgIG1vZHVsZURhdGEud3BCb3JkZXJDb2xvciA9IFwiQGNvbG9yL0tCYXNlSW5wdXRJbnZhbGlkVGlwQ29sb3JcIjtcbiAgICAgIG1vZHVsZURhdGEud3BFcnJvclZpcyA9IFwidmlzaWJsZVwiO1xuICAgICAgY2hlY2tCdG5TdGF0dXMoKTtcbiAgICB9IGVsc2Uge1xuICAgICAgbGV0IG1lc3NhZ2UgPSByZXNwb25zZS5tZXNzYWdlO1xuICAgICAgaWYgKG1lc3NhZ2UpIHtcbiAgICAgICAgY29tbW9uLnNob3dUb2FzdChtZXNzYWdlKTtcbiAgICAgICAgYnRuRW5hYmxlID0gZmFsc2U7XG4gICAgICAgIG1vZHVsZURhdGEuYnRuQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JFQkVCRUJcIjtcblx0XHRtb2R1bGVEYXRhLmJ0blRpdGxlQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JUaHJlZUxldmVsVGV4dFwiO1xuICAgICAgfVxuICAgIH1cbiAgICBjbGVhckNoZWNrUHJpY2VUaW1lcigpXG4gIH1cbn1cblxuZnVuY3Rpb24gY2xlYXJDaGVja1ByaWNlVGltZXIoKSB7XG4gIGlmIChjaGVja1ByaWNlVGltZXIgIT0gbnVsbCkge1xuICAgIGNsZWFySW50ZXJ2YWwoY2hlY2tQcmljZVRpbWVyKTtcbiAgICBjaGVja1ByaWNlVGltZXIgPSBudWxsO1xuICB9XG59XG5cbmZ1bmN0aW9uIGdldEV4cGlyZUF0KCkge1xuICByZXR1cm4gcGFyYW1ldGVyLmV4cGlyZUF0ID09IG51bGwgPyBtb2R1bGVEYXRhLm1haW5EYXRhW1wiZXhwaXJlLWF0XCJdIDogcGFyYW1ldGVyLmV4cGlyZUF0O1xufVxuXG5mdW5jdGlvbiBpbnRlcnZhbFJlcXVlc3RJbmRleFByaWNlKCkge1xuICBpZiAoaW5kZXhQcmljZVRpbWVyID09IG51bGwpIHtcbiAgICByZXF1ZXN0SW5kZXhQcmljZSgpO1xuICAgIGluZGV4UHJpY2VUaW1lciA9IHNldEludGVydmFsKHJlcXVlc3RJbmRleFByaWNlLCA1MDAwKTtcbiAgfVxufVxuXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0SW5kZXhQcmljZSgpIHtcbiAgY29uc3QgZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdCgnb3RjL29wdC9vcHRpb24vdjEvcHJlL2luZGV4JywgeyBzeW1ib2w6IGAke3BhcmFtZXRlci5jdXJyZW5jeX0ke3BhcmFtZXRlci5xdW90ZX1gIH0pO1xuICBjb25zb2xlLmxvZyhgaW5kZXhQcmljZSA6ICR7SlNPTi5zdHJpbmdpZnkoZGF0YSl9YClcbiAgaWYgKGRhdGEpIHtcblx0bW9kdWxlRGF0YS5pbmRleFByaWNlID0gJGkxOG4uJGludGVyY2VwdC5uX2RvdWJsZV9jb2luX2Vhcm5fcXVhbnRpdHlfbGF0ZXN0KHBhcmFtZXRlci5jdXJyZW5jeS50b1VwcGVyQ2FzZSgpLCBgJHtkYXRhfWApO1xuICAgIGluZGV4UHJpZSA9IGRhdGE7XG4gICAgY2FsUHJpY2VMaW1pdCgpXG4gIH0gZWxzZSB7XG4gICAgaW5kZXhQcmllID0gXCIwXCI7XG5cdG1vZHVsZURhdGEuaW5kZXhQcmljZSA9ICRpMThuLiRpbnRlcmNlcHQubl9kb3VibGVfY29pbl9lYXJuX3F1YW50aXR5X2xhdGVzdChwYXJhbWV0ZXIuY3VycmVuY3kudG9VcHBlckNhc2UoKSwgXCItLVwiKTtcbiAgfVxufVxuXG5mdW5jdGlvbiBjYWxQcmljZUxpbWl0KCkge1xuICAvL+iuoeeul+a2qOi3jOW5hVxuICBsZXQgaG9va1ByaWNlID0gZ2V0SG9va1ByaWNlKCk7XG4gIGlmIChob29rUHJpY2UgIT0gbnVsbCAmJiBob29rUHJpY2UgIT0gXCItLVwiKSB7XG4gICAgbGV0IHJhdGlvID0gKDEgLSBpbmRleFByaWUgLyBob29rUHJpY2UpICogMTAwO1xuICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0SW5kZXhQcmljZSAke3JhdGlvfSAgICR7aG9va1ByaWNlfWApO1xuICAgIGlmIChyYXRpbyA+PSAwICYmIHJhdGlvIDwgMC4wMSkge1xuICAgICAgcmF0aW8gPSAwLjAxO1xuICAgIH0gZWxzZSBpZiAocmF0aW8gPCAwICYmIHJhdGlvID4gLTAuMDEpIHtcbiAgICAgIHJhdGlvID0gLTAuMDE7XG4gICAgfVxuICAgIGxldCByYXRpb1N0ciA9IGNvbW1vbi5mb3JtYXRQcmVjaXNpb24ocmF0aW8sIDIpO1xuICAgIGlmIChyYXRpbyA+PSAwKSB7XG4gICAgICBtb2R1bGVEYXRhLnByaWNlTGltaXQgPSBgKyR7cmF0aW9TdHJ9JWA7XG4gICAgfSBlbHNlIHtcbiAgICAgIG1vZHVsZURhdGEucHJpY2VMaW1pdCA9IGAke3JhdGlvU3RyfSVgO1xuXG4gICAgfVxuICB9IGVsc2Uge1xuICAgIG1vZHVsZURhdGEucHJpY2VMaW1pdCA9IGAtLWA7XG4gIH1cbn1cblxuXG5mdW5jdGlvbiBvbkRlc3Ryb3koKSB7XG4gIGNvbnNvbGUubG9nKGBvbkRlc3Ryb3lgKTtcbiAgY2xlYXJJbmRleFByaWNlVGltZXIoKTtcbiAgY2xlYXJVSURhdGEoKTtcbn1cblxuZnVuY3Rpb24gY2xlYXJVSURhdGEoKSB7XG4gIG1vZHVsZURhdGEueWVhcllpZWxkID0gXCItLVwiLy/lj4LogIPlubTljJZcbiAgbW9kdWxlRGF0YS55aWVsZCA9IFwiLS1cIi8v5pS255uK546HXG4gIG1vZHVsZURhdGEuZXhwaXJlRGF0ZSA9IFwiLS1cIi8v5pyf6ZmQXG4gIG1vZHVsZURhdGEuaG9va1ByaWNlID0gXCItLVwiLy/nm67moIfku7dcbiAgbW9kdWxlRGF0YS5wcmljZUxpbWl0ID0gXCItLVwiLy/mtqjot4zluYVcbiAgbW9kdWxlRGF0YS5zdWJIaW50ID0gXCJcIi8v55Sz6LSt5pWw6YeP5o+Q56S66K+tXG4gIG1vZHVsZURhdGEuc3ViSW5wdXQgPSBcIlwiLy/nlLPotK3mlbDph4/ovpPlhaXmoYZcbiAgbW9kdWxlRGF0YS5zdWJPbkZvY3VzID0gZmFsc2UvL+eUs+i0reeEpueCuVxuICBtb2R1bGVEYXRhLmJhc2VDb2luID0gXCJcIi8v5Z+656GA5biB56eNXG4gIG1vZHVsZURhdGEucXVvdGVDb2luID0gXCJcIi8v5oyC6ZKp5biB56eNXG4gIG1vZHVsZURhdGEuYmFsYW5jZSA9IFwiLS1cIi8v5L2Z6aKdXG4gIG1vZHVsZURhdGEuZXN0aW1hdGVkUHJvZml0ID0gXCItLVwiLy/pooTkvLDmlLbnm4pcbiAgbW9kdWxlRGF0YS5yZXNpZHVlQnV5ID0gXCJcIi8v5Ymp5L2Z5Y+v55Sz6LStXG4gIG1vZHVsZURhdGEud3BPbkZvY3VzID0gZmFsc2UvL+i1juWbnueEpueCuVxuICBtb2R1bGVEYXRhLnN1YlVuaXQgPSBcIlwiLy/ljZXkvY1cbiAgbW9kdWxlRGF0YS5pbmRleFByaWNlID0gXCJcIi8v5oyH5pWw5Lu3XG4gIG1vZHVsZURhdGEud2l0aGRyYXdQcmljZUhpbnQgPSBcIlwiLy/otY7lm57ku7fmj5DnpLror61cbiAgbW9kdWxlRGF0YS53aXRoZHJhd1ByaWNlVmlzID0gXCJnb25lXCIvL+i1juWbnuS7t+i+k+WFpeahhlxuICBtb2R1bGVEYXRhLm9wZW5DbG9zZVN0ciA9ICRpMThuLm5fY29udGVudF9leHBhbmRcbiAgbW9kdWxlRGF0YS5vcGVuQ2xvc2VSZXMgPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9pY19kY19zdGF0dXNfb3BlblwiXG4gIG1vZHVsZURhdGEuY2hhcnRCYXNlRGF0YSA9IFwiXCIvL+WbvuihqOWfuuehgOaVsOaNrlxuICBtb2R1bGVEYXRhLndpdGhEcmF3UHJpY2UgPSBcIlwiLy/otY7lm57ku7dcbiAgbW9kdWxlRGF0YS5xdWFudGl0eSA9IFwiXCIvL+eUs+i0reaVsOmHj1xuICBtb2R1bGVEYXRhLm9wZW5BY2NvdW50QWxlcnRTaG93ID0gZmFsc2UvL+W8gOmAmuacn+adg+i0puaIt+W8ueeql1xuICBtb2R1bGVEYXRhLnRpcHNBbGVydFNob3dDb21tb24gPSBmYWxzZS8vdGlwc+W8ueeql1xuICBtb2R1bGVEYXRhLnRpcHNBbGVydFNob3dXcCA9IGZhbHNlLy90aXBz5by556qXXG4gIG1vZHVsZURhdGEuZXhwaXJlVGltZVRpcHMgPSBcIlwiLy/liLDmnJ/ml7bpl7TmlofmoYhcbiAgbW9kdWxlRGF0YS53cEJvcmRlckNvbG9yID0gXCJAY29sb3IvS0Jhc2VDb2xvcklucHV0QmFja2dyb3VuZFwiLy9cbiAgbW9kdWxlRGF0YS5zdWJCb3JkZXJDb2xvciA9IFwiQGNvbG9yL0tCYXNlQ29sb3JJbnB1dEJhY2tncm91bmRcIi8vXG4gIG1vZHVsZURhdGEuc3ViRXJyb3JTdHIgPSBcIlwiLy/nlLPotK3ovpPlhaXmoYbplJnor6/mlofmoYhcbiAgbW9kdWxlRGF0YS5zdWJFcnJvclZpcyA9IFwiZ29uZVwiLy9cbiAgbW9kdWxlRGF0YS53cEVycm9yU3RyID0gXCJcIi8v6LWO5Zue5Lu36L6T5YWl5qGG6ZSZ6K+v5paH5qGIXG4gIG1vZHVsZURhdGEud3BFcnJvclZpcyA9IFwiZ29uZVwiLy9cbiAgbW9kdWxlRGF0YS50aXBzU3RyID0gXCJcIi8vdGlwc+W8ueeql+aWh+ahiFxuICBtb2R1bGVEYXRhLmJ0bkNvbG9yID0gXCJAY29sb3Iva0NvbG9yRUJFQkVCXCIvL+eUs+i0reaMiemSruminOiJslxuICBtb2R1bGVEYXRhLmJ0blRpdGxlQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JUaHJlZUxldmVsVGV4dFwiXG4gIG1vZHVsZURhdGEuc3ViQWxlcnRTaG93ID0gZmFsc2UvL+iuouWNleehruiupOW8ueeql1xuICBtb2R1bGVEYXRhLnByb2R1Y3ROYW1lID0gXCJcIi8v5Lqn5ZOB5ZCN56ewXG4gIG1vZHVsZURhdGEud2l0aERyYXdWaXMgPSBcImdvbmVcIi8v6LWO5Zue5Lu35bGV56S654q25oCBXG4gIHdwSW5wdXQgPSBcIlwiXG4gIGluZGV4UHJpZSA9IFwiMFwiXG4gIG1vZHVsZURhdGEuaHVvYmlTZWxlY3RlZCA9IGZhbHNlO1xuICBtb2R1bGVEYXRhLmh1b2JpQWdyZWVJbWFnZSA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2xpdmVfcmVkcGFja2V0X3Vuc2VsZWN0XCI7XG4gIG1vZHVsZURhdGEuZG9CYWNrQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JFQkVCRUJcIjtcbiAgbW9kdWxlRGF0YS5kb0NvbG9yID0gXCJAY29sb3IvZUJ1dHRvblVuZW5hYmxlZEJnQ29sb3JcIjtcbiAgYnRuRW5hYmxlID0gZmFsc2U7XG59XG5cbmZ1bmN0aW9uIGNsZWFySW5kZXhQcmljZVRpbWVyKCkge1xuICBpZiAoaW5kZXhQcmljZVRpbWVyICE9IG51bGwpIHtcbiAgICBjbGVhckludGVydmFsKGluZGV4UHJpY2VUaW1lcik7XG4gICAgaW5kZXhQcmljZVRpbWVyID0gbnVsbDtcbiAgfVxuICBpZiAoc3ViRGV0YWlsVGltZXIgIT0gbnVsbCkge1xuICAgIGNsZWFySW50ZXJ2YWwoc3ViRGV0YWlsVGltZXIpO1xuICAgIHN1YkRldGFpbFRpbWVyID0gbnVsbDtcbiAgfVxuICBjbGVhckNoZWNrUHJpY2VUaW1lcigpO1xufVxuXG5mdW5jdGlvbiBnZXROYXZDb25maWdTdHJpbmcodGl0bGUpIHtcbiAgcmV0dXJuIHtcbiAgICAndGl0bGUnOiB0aXRsZSxcbiAgICAnbGVmdCc6IHtcbiAgICAgICdhY3Rpb24nOiB7XG4gICAgICAgICd0eXBlJzogJ2JhY2snLFxuICAgICAgICAncGFyYW1ldGVyJzogJydcbiAgICAgIH0sXG4gICAgICAnaWNvbic6ICdlZGdlX2VuZ2luZV90b3BfYmFyX2JhY2tfbm9ybWFsJ1xuICAgIH0sXG4gICAgJ2JhY2tncm91bmRDb2xvcic6ICdLQmFzZUNvbG9yRGVlcGVzdEJhY2tncm91bmQnXG4gIH07XG59XG5cbmFzeW5jIGZ1bmN0aW9uIGNoZWNrT3BlbkFjY291bnQoKSB7XG4gIGNvbnN0IGRhdGEgPSBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3QoJ290Yy9vcHQvb3B0aW9uL29yZGVyL3YxL2RvdWJsZS1jdXJyZW5jeS13aW4vY2hlY2stYWxsJyk7XG4gIGNvbnNvbGUubG9nKGBjaGVja09wZW5BY2NvdW50IDogJHtKU09OLnN0cmluZ2lmeShkYXRhKX1gKVxuICBpZiAoZGF0YVtcIndhcnJhbnQtYWNjb3VudFwiXSA9PSB0cnVlKSB7XG4gICAgLy/lvIDpgJrkuoblj4zluIHotKbmiLcg6Lez6L2s5YiS6L2sXG4gICAgb3BlblRyYW5zZmVyKCk7XG4gIH0gZWxzZSB7XG4gICAgLy/lvLnnqpfmj5DnpLrlvIDpgJrotKbmiLdcbiAgICBtb2R1bGVEYXRhLm9wZW5BY2NvdW50QWxlcnRTaG93ID0gdHJ1ZTtcbiAgfVxuXG59XG5cbmZ1bmN0aW9uIG9wZW5UcmFuc2ZlcigpIHtcbiAgbGV0IHRyYW5zZmVyT2JqID0geyB0eXBlOiAxIH07XG4gIGlmIChwYXJhbWV0ZXIucHJvZHVjdFR5cGVJZCA9PSA1KSB7XG4gICAgdHJhbnNmZXJPYmouY3VycmVuY3kgPSBwYXJhbWV0ZXIucXVvdGU7XG4gIH0gZWxzZSB7XG4gICAgdHJhbnNmZXJPYmouY3VycmVuY3kgPSBwYXJhbWV0ZXIuY3VycmVuY3k7XG4gIH1cbiAgJG5hdGl2ZUFQSS5kb3VibGVDb2luQWJpbGl0eShKU09OLnN0cmluZ2lmeSh0cmFuc2Zlck9iaikpO1xufVxuXG5tb2R1bGVFdmVudC5zdWJUZXh0Q2hhbmdlID0gZnVuY3Rpb24gKGlucHV0U3RyKSB7XG4gIGNvbnNvbGUubG9nKGBzdWJUZXh0Q2hhbmdlIDogJHtpbnB1dFN0cn1gKTtcbiAgc3ViSW5wdXQgPSBpbnB1dFN0cjtcbiAgLy/mo4DmtYvovpPlhaXmmK/lkKblkIjms5VcbiAgY2hlY2tTdWJJbnB1dCgpO1xuICAvL+ajgOa1i+aMiemSrueKtuaAgVxuICBpZiAoY2hlY2tCdG5TdGF0dXMoKSkge1xuICAgIC8v5pu05paw5Zu+6KGoXG4gICAgbW9kdWxlRGF0YS5xdWFudGl0eSA9IHN1YklucHV0O1xuICAgIC8v6K+i5Lu3XG4gICAgaW50ZXJ2YWxDaGVja1ByaWNlKCk7XG4gIH1cbn1cblxubW9kdWxlRXZlbnQuc3ViRm9jdXNDaGFuZ2UgPSBmdW5jdGlvbiAoZm9jdXMpIHtcbiAgY29uc29sZS5sb2coYHN1YkZvY3VzQ2hhbmdlIDogJHtmb2N1c31gKTtcbiAgaWYgKCFmb2N1cyAmJiBtb2R1bGVEYXRhLnN1YkVycm9yVmlzID09IFwiZ29uZVwiKSB7XG4gICAgLy/mm7TmlrDlm77ooahcbiAgICAvLyBtb2R1bGVEYXRhLnF1YW50aXR5ID0gc3ViSW5wdXQ7XG4gICAgLy/lpLHnhKbkuYvlkI7osIPnlKjor6Lku7fmjqXlj6NcbiAgICAvLyByZXF1ZXN0Q2hlY2tQcmljZSgpO1xuICB9XG59XG5cbmZ1bmN0aW9uIGNoZWNrU3ViSW5wdXQoKSB7XG4gIC8v5qOA5rWL5L2Z6aKd5piv5ZCm5ZCI5rOVXG4gIGNvbnN0IHF1YW50aXR5ID0gcGFyc2VGbG9hdChzdWJJbnB1dCk7XG4gIGNvbnN0IG1pblN1YiA9IHBhcnNlRmxvYXQobU1pblN1Yik7XG4gIGNvbnN0IGJhbGFuY2UgPSBtb2R1bGVEYXRhLmJhbGFuY2UgPT0gXCItLVwiID8gMCA6IHBhcnNlRmxvYXQobW9kdWxlRGF0YS5iYWxhbmNlKTtcbiAgLy/lj6/nlLPotK3mlbDph4/mo4DmtYtcbiAgY29uc3QgcmVzaWR1ZUJ1eSA9IHBhcnNlRmxvYXQobW9kdWxlRGF0YS5yZXNpZHVlQnV5KTtcbiAgLy/lj6/nlKjkvZnpop3mo4DmtYtcbiAgaWYgKHF1YW50aXR5ID4gYmFsYW5jZSkge1xuICAgIG1vZHVsZURhdGEuc3ViQm9yZGVyQ29sb3IgPSBcIkBjb2xvci9LQmFzZUlucHV0SW52YWxpZFRpcENvbG9yXCI7XG4gICAgbW9kdWxlRGF0YS5zdWJFcnJvclN0ciA9ICRpMThuLm5fbGluZWFyX3N3YXBfZ3VpZGVfYXNzZXRfdG9hc3Q7XG4gICAgbW9kdWxlRGF0YS5zdWJFcnJvclZpcyA9IFwidmlzaWJsZVwiO1xuICB9IGVsc2UgaWYgKHF1YW50aXR5IDwgbWluU3ViKSB7XG4gICAgbW9kdWxlRGF0YS5zdWJCb3JkZXJDb2xvciA9IFwiQGNvbG9yL0tCYXNlSW5wdXRJbnZhbGlkVGlwQ29sb3JcIjtcbiAgICBtb2R1bGVEYXRhLnN1YkVycm9yU3RyID0gbW9kdWxlRGF0YS5zdWJIaW50O1xuICAgIG1vZHVsZURhdGEuc3ViRXJyb3JWaXMgPSBcInZpc2libGVcIjtcbiAgfSBlbHNlIGlmIChxdWFudGl0eSA+IHJlc2lkdWVCdXkpIHtcbiAgICBtb2R1bGVEYXRhLnN1YkJvcmRlckNvbG9yID0gXCJAY29sb3IvS0Jhc2VJbnB1dEludmFsaWRUaXBDb2xvclwiO1xuICAgIG1vZHVsZURhdGEuc3ViRXJyb3JTdHIgPSAkaTE4bi5uX2RvdWJsZV9jb2luX3Jlc2lkdWVfaW5zdWZmaWNpZW50O1xuICAgIG1vZHVsZURhdGEuc3ViRXJyb3JWaXMgPSBcInZpc2libGVcIjtcbiAgfSBlbHNlIHtcbiAgICBtb2R1bGVEYXRhLnN1YkJvcmRlckNvbG9yID0gXCJAY29sb3IvS0Jhc2VDb2xvcklucHV0QmFja2dyb3VuZFwiO1xuICAgIG1vZHVsZURhdGEuc3ViRXJyb3JWaXMgPSBcImdvbmVcIjtcbiAgfVxufVxuXG5tb2R1bGVFdmVudC5zdWJPblJldHVybiA9IGZ1bmN0aW9uIChwYXJhbWV0ZXIpIHtcbiAgY29uc29sZS5sb2coYHN1Yk9uUmV0dXJuIDogJHtwYXJhbWV0ZXJ9YCk7XG4gIG1vZHVsZURhdGEuc3ViT25Gb2N1cyA9IGZhbHNlO1xufVxuXG5tb2R1bGVFdmVudC5tYXhTdWIgPSBmdW5jdGlvbiAoKSB7XG4gIGlmIChtb2R1bGVEYXRhLmJhbGFuY2UgIT0gXCItLVwiKSB7XG4gICAgbW9kdWxlRGF0YS5zdWJJbnB1dCA9IG1vZHVsZURhdGEuYmFsYW5jZTtcbiAgICBpZiAoY29tbW9uLmNvbW1vbkRhdGEuT1MgPT0gMCkge1xuICAgICAgbW9kdWxlRXZlbnQuc3ViVGV4dENoYW5nZShtb2R1bGVEYXRhLmJhbGFuY2UpO1xuICAgIH1cbiAgfSBlbHNlIHtcbiAgICBtb2R1bGVEYXRhLnN1YklucHV0ID0gXCIwXCI7XG4gIH1cbn1cblxubW9kdWxlRXZlbnQuYnV5Q29pbiA9IGZ1bmN0aW9uICgpIHtcbiAgLy/ot7PovazkubDluIFcbiAgbGV0IGJ1eUNvaW5PYmogPSB7IHR5cGU6IDIsIGN1cnJlbmN5OiBtb2R1bGVEYXRhLnN1YlVuaXQgfTtcbiAgY29uc29sZS5sb2coYGJ1eUNvaW4gOiAke0pTT04uc3RyaW5naWZ5KGJ1eUNvaW5PYmopfWApO1xuICAkbmF0aXZlQVBJLmRvdWJsZUNvaW5BYmlsaXR5KEpTT04uc3RyaW5naWZ5KGJ1eUNvaW5PYmopKTtcbn1cblxubW9kdWxlRXZlbnQudHJhbnNmZXIgPSBmdW5jdGlvbiAoKSB7XG4gIC8v6Lez6L2s5YiS6L2sXG4gIGNoZWNrT3BlbkFjY291bnQoKTtcbn1cblxubW9kdWxlRXZlbnQud3BUZXh0Q2hhbmdlID0gZnVuY3Rpb24gKGlucHV0U3RyKSB7XG4gIGNvbnNvbGUubG9nKGB3cFRleHRDaGFuZ2UgOiAke2lucHV0U3RyfWApO1xuICB3cElucHV0ID0gaW5wdXRTdHI7XG4gIGlmICh3cElucHV0ICE9IG51bGwgJiYgd3BJbnB1dCAhPSBcIlwiKSB7XG4gICAgbW9kdWxlRGF0YS53aXRoRHJhd1ZpcyA9IFwidmlzaWJsZVwiO1xuICB9IGVsc2Uge1xuICAgIG1vZHVsZURhdGEud2l0aERyYXdWaXMgPSBcImdvbmVcIjtcbiAgfVxuICBpZiAoY2hlbmNrV3BJbnB1dCgpKSB7XG4gICAgLy/mm7TmlrDlm77ooahcbiAgICBtb2R1bGVEYXRhLndpdGhEcmF3UHJpY2UgPSB3cElucHV0O1xuICB9XG4gIGlmIChjaGVja0J0blN0YXR1cygpKSB7XG4gICAgLy/or6Lku7dcbiAgICBpbnRlcnZhbENoZWNrUHJpY2UoKTtcbiAgfVxufVxuXG5tb2R1bGVFdmVudC53cEZvY3VzQ2hhbmdlID0gZnVuY3Rpb24gKGZvY3VzKSB7XG4gIGNvbnNvbGUubG9nKGB3cEZvY3VzQ2hhbmdlIDogJHtmb2N1c31gKTtcbiAgaWYgKCFmb2N1cyAmJiBtb2R1bGVEYXRhLndwRXJyb3JWaXMgPT0gXCJnb25lXCIpIHtcbiAgICAvL+abtOaWsOWbvuihqFxuICAgIC8vIG1vZHVsZURhdGEud2l0aERyYXdQcmljZSA9IHdwSW5wdXQ7XG4gICAgLy8gaWYgKG1vZHVsZURhdGEucXVhbnRpdHkgIT0gbnVsbCkge1xuICAgIC8v6K+i5Lu35o6l5Y+jXG4gICAgLy8gcmVxdWVzdENoZWNrUHJpY2UoKTtcbiAgICAvLyB9XG4gIH1cbn1cblxuZnVuY3Rpb24gY2hlbmNrV3BJbnB1dCgpIHtcbiAgY29uc3QgaG9va1ByaWNlID0gcGFyc2VGbG9hdChnZXRIb29rUHJpY2UoKSk7XG4gIGNvbnN0IHdwID0gcGFyc2VGbG9hdCh3cElucHV0KTtcbiAgY29uc29sZS5sb2coYHdwSW5wdXQgOiAke3dwSW5wdXR9ICAgd3AgOiAke3dwfWApO1xuICBtb2R1bGVEYXRhLndwRXJyb3JTdHIgPSBtb2R1bGVEYXRhLndpdGhkcmF3UHJpY2VIaW50O1xuICBpZiAocGFyYW1ldGVyLnByb2R1Y3RUeXBlSWQgPT0gNSkge1xuICAgIC8v5L2O5LmwIOW/hemhu+Wwj+S6jui1juWbnuS7t1xuICAgIGlmICh3cCA8IGhvb2tQcmljZSB8fCB3cElucHV0ID09IFwiXCIpIHtcbiAgICAgIG1vZHVsZURhdGEud3BCb3JkZXJDb2xvciA9IFwiQGNvbG9yL0tCYXNlQ29sb3JJbnB1dEJhY2tncm91bmRcIjtcbiAgICAgIG1vZHVsZURhdGEud3BFcnJvclZpcyA9IFwiZ29uZVwiO1xuICAgICAgcmV0dXJuIHRydWU7XG4gICAgfSBlbHNlIHtcbiAgICAgIG1vZHVsZURhdGEud3BCb3JkZXJDb2xvciA9IFwiQGNvbG9yL0tCYXNlSW5wdXRJbnZhbGlkVGlwQ29sb3JcIjtcbiAgICAgIG1vZHVsZURhdGEud3BFcnJvclZpcyA9IFwidmlzaWJsZVwiO1xuICAgICAgcmV0dXJuIGZhbHNlO1xuICAgIH1cbiAgfSBlbHNlIHtcbiAgICAvL+mrmOWNliDlv4XpobvlsI/kuo7otY7lm57ku7dcbiAgICBpZiAod3AgPiBob29rUHJpY2UgfHwgd3BJbnB1dCA9PSBcIlwiKSB7XG4gICAgICBtb2R1bGVEYXRhLndwQm9yZGVyQ29sb3IgPSBcIkBjb2xvci9LQmFzZUNvbG9ySW5wdXRCYWNrZ3JvdW5kXCI7XG4gICAgICBtb2R1bGVEYXRhLndwRXJyb3JWaXMgPSBcImdvbmVcIjtcbiAgICAgIHJldHVybiB0cnVlO1xuICAgIH0gZWxzZSB7XG4gICAgICBtb2R1bGVEYXRhLndwQm9yZGVyQ29sb3IgPSBcIkBjb2xvci9LQmFzZUlucHV0SW52YWxpZFRpcENvbG9yXCI7XG4gICAgICBtb2R1bGVEYXRhLndwRXJyb3JWaXMgPSBcInZpc2libGVcIjtcbiAgICAgIHJldHVybiBmYWxzZTtcbiAgICB9XG4gIH1cbn1cblxuZnVuY3Rpb24gZ2V0SG9va1ByaWNlKCkge1xuICBjb25zb2xlLmxvZyhgZ2V0SG9va1ByaWNlIDogJHtwYXJhbWV0ZXIuaG9va1ByaWNlID09IG51bGwgfHwgcGFyYW1ldGVyLmhvb2tQcmljZSA9PSAnJyA/IG1vZHVsZURhdGEuaG9va1ByaWNlIDogcGFyYW1ldGVyLmhvb2tQcmljZX1gKTtcbiAgcmV0dXJuIHBhcmFtZXRlci5ob29rUHJpY2UgPT0gbnVsbCB8fCBwYXJhbWV0ZXIuaG9va1ByaWNlID09ICcnID8gbW9kdWxlRGF0YS5ob29rUHJpY2UgOiBwYXJhbWV0ZXIuaG9va1ByaWNlO1xufVxuXG5hc3luYyBmdW5jdGlvbiBzaG93RGVwb3NpdEd1aWRlKCkge1xuICB2YXIgZ3VpZGVTaG93ID0gYXdhaXQgJG5hdGl2ZUFQSS5zdG9yYWdlKHtcbiAgICBhY3Rpb246IFwicmVhZFwiLFxuICAgIG5hbWU6IFwiZG91YmxlX2NvaW5cIixcbiAgICBrZXk6IFwiZG91YmxlX2NvaW5fZ3VpZGVfc2hvd1wiXG4gIH0pXG4gIGlmIChndWlkZVNob3cgPT0gbnVsbCB8fCBndWlkZVNob3cgPT0gXCJcIikge1xuICAgIG1vZHVsZURhdGEucG9wMVNob3cgPSB0cnVlO1xuICAgICRuYXRpdmVBUEkuc3RvcmFnZSh7XG4gICAgICBhY3Rpb246IFwic2F2ZVwiLFxuICAgICAgbmFtZTogXCJkb3VibGVfY29pblwiLFxuICAgICAga2V5OiBcImRvdWJsZV9jb2luX2d1aWRlX3Nob3dcIixcbiAgICAgIGRhdGE6IFwiMVwiXG4gICAgfSlcbiAgfVxufVxuXG5tb2R1bGVFdmVudC5uZXh0UG9wID0gZnVuY3Rpb24gKHN0ZXApIHtcbiAgbW9kdWxlRGF0YS5wb3AxU2hvdyA9IFwiZmFsc2VcIjtcbiAgbW9kdWxlRGF0YS5wb3AyU2hvdyA9IFwiZmFsc2VcIjtcbiAgbW9kdWxlRGF0YS5wb3AzU2hvdyA9IFwiZmFsc2VcIjtcbiAgbW9kdWxlRGF0YVtgcG9wJHtzdGVwfVNob3dgXSA9IFwidHJ1ZVwiO1xufVxuXG5tb2R1bGVFdmVudC5oaWRlUG9wID0gZnVuY3Rpb24gKCkge1xuICBtb2R1bGVEYXRhLnBvcDFTaG93ID0gXCJmYWxzZVwiO1xuICBtb2R1bGVEYXRhLnBvcDJTaG93ID0gXCJmYWxzZVwiO1xuICBtb2R1bGVEYXRhLnBvcDNTaG93ID0gXCJmYWxzZVwiO1xufVxuXG5tb2R1bGVFdmVudC53cE9uUmV0dXJuID0gZnVuY3Rpb24gKHBhcmFtZXRlcikge1xuICBjb25zb2xlLmxvZyhgd3BPblJldHVybiA6ICR7cGFyYW1ldGVyfWApO1xuICBtb2R1bGVEYXRhLndwT25Gb2N1cyA9IGZhbHNlO1xufVxuXG5tb2R1bGVFdmVudC5jbG9zZU9wZW5BY2NvdW50QWxlcnQgPSBmdW5jdGlvbiAoKSB7XG4gIC8v5YWz6Zet5byA6YCa6LSm5oi35by556qXXG4gIG1vZHVsZURhdGEub3BlbkFjY291bnRBbGVydFNob3cgPSBmYWxzZTtcbn1cblxubW9kdWxlRXZlbnQub3BlbkRvdWJsZUNvaW5BY2NvdW50ID0gYXN5bmMgZnVuY3Rpb24gKCkge1xuICAvL+W8gOmAmuacn+adg+i0puaIt1xuICBsZXQgcGFyID0ge307XG4gIHBhcltcImRldmljZS12VG9rZW5cIl0gPSBjb21tb24uY29tbW9uRGF0YS52VG9rZW47XG4gIHBhcltcImRldmljZS1mYlRva2VuXCJdID0gY29tbW9uLmNvbW1vbkRhdGEub2xkVlRva2VuO1xuICBjb25zdCBkYXRhID0gYXdhaXQgY29tbW9uLnNlbmRSZXF1ZXN0KCdvdGMvb3B0L29wdGlvbi9vcmRlci92MS9jcmVhdGUtd2FycmFudCcsIHt9LCAxLCAwLCBwYXIpO1xuICBpZiAoZGF0YSAhPSBudWxsKSB7XG4gICAgbW9kdWxlRGF0YS5vcGVuQWNjb3VudEFsZXJ0U2hvdyA9IGZhbHNlO1xuICAgIGNvbW1vbi5zaG93VG9hc3QoJGkxOG4ubl9kb3VibGVfY29pbl9vcGVuX3N1Y2Nlc3MpO1xuICB9IGVsc2Uge1xuICAgIGNvbW1vbi5zaG93VG9hc3QoJGkxOG4ubl9kb3VibGVfY29pbl9vcGVuX2ZhaWwpO1xuICB9XG59XG5cblxuZnVuY3Rpb24gY2hlY2tCdG5TdGF0dXMoKSB7XG4gIGlmIChtb2R1bGVEYXRhLnN1YkVycm9yVmlzID09IFwiZ29uZVwiICYmIG1vZHVsZURhdGEud3BFcnJvclZpcyA9PSBcImdvbmVcIiAmJiBzdWJJbnB1dCAhPSBcIlwiKSB7XG4gICAgYnRuRW5hYmxlID0gdHJ1ZTtcbiAgICBtb2R1bGVEYXRhLmJ0bkNvbG9yID0gXCJAY29sb3Iva0NvbG9yTWFqb3JUaGVtZTEwMFwiO1xuXHRtb2R1bGVEYXRhLmJ0blRpdGxlQ29sb3IgPSBcIkBjb2xvci9LQmFzZVRleHRDb2xvclwiO1xuICAgIHJldHVybiB0cnVlO1xuICB9IGVsc2Uge1xuICAgIGJ0bkVuYWJsZSA9IGZhbHNlO1xuICAgIG1vZHVsZURhdGEuYnRuQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JFQkVCRUJcIjtcblx0bW9kdWxlRGF0YS5idG5UaXRsZUNvbG9yID0gXCJAY29sb3Iva0NvbG9yVGhyZWVMZXZlbFRleHRcIjtcbiAgICByZXR1cm4gZmFsc2U7XG4gIH1cbn1cblxubW9kdWxlRXZlbnQuc2hvd1N1YkRpYWxvZyA9IGZ1bmN0aW9uICgpIHtcbiAgaWYgKGJ0bkVuYWJsZSkge1xuICAgIC8v5riF56m65omA5pyJ54Sm54K5XG4gICAgbW9kdWxlRGF0YS5zdWJPbkZvY3VzID0gZmFsc2U7XG4gICAgbW9kdWxlRGF0YS53cE9uRm9jdXMgPSBmYWxzZTtcbiAgICBtb2R1bGVEYXRhLnN1YkFsZXJ0U2hvdyA9IHRydWU7XG4gIH1cbn1cblxubW9kdWxlRXZlbnQuY2xvc2VTdWJEaWFsb2cgPSBmdW5jdGlvbiAoKSB7XG4gIG1vZHVsZURhdGEuc3ViQWxlcnRTaG93ID0gZmFsc2U7XG59XG5cbm1vZHVsZUV2ZW50LmRvT3JkZXIgPSBhc3luYyBmdW5jdGlvbiAoKSB7XG4gIGlmICghbW9kdWxlRGF0YS5odW9iaVNlbGVjdGVkKSB7XG5cdHJldHVybjtcbiAgfVxuICAvL+S4i+WNlSDljLrliIbmmK/lkKbmmK/oh6rlrprkuYnkuqflk4FcbiAgY29uc29sZS5sb2coYGRvT3JkZXIgICAke0pTT04uc3RyaW5naWZ5KHBhcmFtZXRlcil9YCk7XG4gIHZhciBkYXRhID0gbnVsbDtcbiAgdmFyIGRvT3JkZXIgPSB7fTtcbiAgaWYgKHBhcmFtZXRlci5ob29rUHJpY2UgPT0gbnVsbCkge1xuICAgIC8v5pmu6YCa5Lqn5ZOBIG9wdGlvbi9vcmRlci92MS9kb3VibGUtY3VycmVuY3ktd2luL3BsYWNlLW9yZGVyXG4gICAgZG9PcmRlciA9IHtcbiAgICAgIFwiY2hhbm5lbC1zb3VyY2VcIjogMixcbiAgICAgIFwiZXN0aW1hdGUtcHJvZml0XCI6IG1vZHVsZURhdGEuZXN0aW1hdGVkUHJvZml0LCAvL+mcgOimgeWJjee9ruivouS7t+aOpeWPo1xuICAgICAgXCJwcm9kdWN0LWlkXCI6IHBhcmFtZXRlci5wcm9kdWN0SWQsXG4gICAgICBcInByb2R1Y3QtZmluYW5jZS1pZFwiOiBwYXJhbWV0ZXIucHJvZHVjdEZpbmFuY2VJZCxcbiAgICAgIFwibm90aW9uYWxcIjogc3ViSW5wdXQsXG4gICAgfVxuICAgIGlmICh3cElucHV0ICE9IG51bGwgJiYgd3BJbnB1dCAhPSBcIlwiKSB7XG4gICAgICBkb09yZGVyW1wicmVkZWVtLXByaWNlXCJdID0gd3BJbnB1dC8v6LWO5Zue5Lu3IOayoeacieS4jeS8oFxuICAgIH1cbiAgICBjb25zb2xlLmxvZyhgZG9PcmRlciAgICR7SlNPTi5zdHJpbmdpZnkoZG9PcmRlcil9YCk7XG4gICAgZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdCgnb3RjL29wdC9vcHRpb24vb3JkZXIvdjEvZG91YmxlLWN1cnJlbmN5LXdpbi9wbGFjZS1vcmRlcicsIGRvT3JkZXIsIDEsIDAsIHsgXCJDb250ZW50LVR5cGVcIjogXCJhcHBsaWNhdGlvbi9qc29uXCIgfSk7XG4gIH0gZWxzZSB7XG4gICAgY29uc29sZS5sb2coYGRvT3JkZXIgICAke0pTT04uc3RyaW5naWZ5KHBhcmFtZXRlcil9YCk7XG4gICAgLy/oh6rlrprkuYnkuqflk4FcbiAgICBkb09yZGVyID0ge1xuICAgICAgXCJwcm9kdWN0LXR5cGUtaWRcIjogcGFyYW1ldGVyLnByb2R1Y3RUeXBlSWQsXG4gICAgICBcImNoYW5uZWwtc291cmNlXCI6IDIsXG4gICAgICBcImVzdGltYXRlLXByb2ZpdFwiOiBtb2R1bGVEYXRhLmVzdGltYXRlZFByb2ZpdCwgLy/pnIDopoHliY3nva7or6Lku7fmjqXlj6NcbiAgICAgIFwicHJvZHVjdC1pZFwiOiBwYXJhbWV0ZXIucHJvZHVjdElkLFxuICAgICAgXCJwcm9kdWN0LWZpbmFuY2UtaWRcIjogcGFyYW1ldGVyLnByb2R1Y3RGaW5hbmNlSWQsXG4gICAgICBcIm5vdGlvbmFsXCI6IHN1YklucHV0LFxuICAgICAgXCJleHBpcmUtYXRcIjogcGFyYW1ldGVyLmV4cGlyZUF0LC8v6Ieq5a6a5LmJ5Lqn5ZOB54us5pyJXG4gICAgICBcImhvb2stcHJpY2VcIjogcGFyYW1ldGVyLmhvb2tQcmljZSwvL+iHquWumuS5ieS6p+WTgeeLrOaciVxuICAgIH1cbiAgICBpZiAod3BJbnB1dCAhPSBudWxsICYmIHdwSW5wdXQgIT0gXCJcIikge1xuICAgICAgZG9PcmRlcltcInJlZGVlbS1wcmljZVwiXSA9IHdwSW5wdXQvL+i1juWbnuS7tyDmsqHmnInkuI3kvKBcbiAgICB9XG4gICAgY29uc29sZS5sb2coYGRvT3JkZXIgICAke3BhcmFtZXRlci5ob29rUHJpY2V9ICAgICR7SlNPTi5zdHJpbmdpZnkocGFyYW1ldGVyKX0gICAgICR7SlNPTi5zdHJpbmdpZnkoZG9PcmRlcil9YCk7XG4gICAgZGF0YSA9IGF3YWl0IGNvbW1vbi5zZW5kUmVxdWVzdCgnb3RjL29wdC9vcHRpb24vb3JkZXIvdjEvZG91YmxlLWN1cnJlbmN5LXdpbi9mbGV4aWJsZS1wbGFjZS1vcmRlcicsIGRvT3JkZXIsIDEsIDAsIHsgXCJDb250ZW50LVR5cGVcIjogXCJhcHBsaWNhdGlvbi9qc29uXCIgfSk7XG4gIH1cbiAgaWYgKGRhdGEgIT0gbnVsbCkge1xuICAgIG1vZHVsZURhdGEuc3ViQWxlcnRTaG93ID0gZmFsc2U7XG4gICAgbGV0IHJlc3VsdFN0ciA9IGAke2RvT3JkZXIubm90aW9uYWx9ICAke21vZHVsZURhdGEuc3ViVW5pdH1gXG4gICAgbGV0IHVybCA9IFwiaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9lZGdlZW5naW5lL2NvbnRhaW5lcj9zY2VuZT1kb3VibGVjb2luJnJvb3ROYW1lPXJlc3VsdCZuYXZDb25maWc9XCI7XG4gICAgY29tbW9uLm9wZW5VUkwoYCR7dXJsfSZyZXN1bHRTdHI9JHtyZXN1bHRTdHJ9YCk7XG4gICAgY29tbW9uLmNvbnRhaW5lckJhY2soLTEpO1xuICB9XG4gIGNvbnNvbGUubG9nKGBkb09yZGVyICAgJHtKU09OLnN0cmluZ2lmeShkYXRhKX1gKTtcblxufVxuXG5tb2R1bGVFdmVudC5vcGVuVGlwc0RpYWxvZyA9IGZ1bmN0aW9uICh0eXBlKSB7XG4gIC8v6LWO5Zue5Lu3dGlwc1xuICBpZiAodHlwZSA9PSAxKSB7XG4gICAgbW9kdWxlRGF0YS50aXBzU3RyID0gJGkxOG4ubl9kb3VibGVfY29pbl95aWVsZF90aXBzO1xuICAgIG1vZHVsZURhdGEudGlwc0FsZXJ0U2hvd0NvbW1vbiA9IHRydWU7XG4gIH0gZWxzZSBpZiAodHlwZSA9PSAyKSB7XG4gICAgbW9kdWxlRGF0YS50aXBzU3RyID0gJGkxOG4ubl9kb3VibGVfY29pbl93aXRoX2RyYXdfcHJpY2VfdGlwc19uZXdfMjtcbiAgICBtb2R1bGVEYXRhLnRpcHNBbGVydFNob3dXcCA9IHRydWU7XG4gIH1cbn1cblxubW9kdWxlRXZlbnQuY2xvc2VUaXBzRGlhbG9nID0gZnVuY3Rpb24gKCkge1xuICBtb2R1bGVEYXRhLnRpcHNBbGVydFNob3dDb21tb24gPSBmYWxzZTtcbiAgbW9kdWxlRGF0YS50aXBzQWxlcnRTaG93V3AgPSBmYWxzZTtcbn1cblxubW9kdWxlRXZlbnQuY2xlYXJGb2N1cyA9IGZ1bmN0aW9uICgpIHtcbiAgY29uc29sZS5sb2coYGNsZWFyRm9jdXMgOiAke3BhcmFtZXRlcn1gKTtcbiAgLy/muIXnqbrmiYDmnInnhKbngrlcbiAgbW9kdWxlRGF0YS5zdWJPbkZvY3VzID0gZmFsc2U7XG4gIG1vZHVsZURhdGEud3BPbkZvY3VzID0gZmFsc2U7XG59XG5cbm1vZHVsZUV2ZW50Lm9wZW5XaXRoZHJhd1ByaWNlSW5wdXQgPSBmdW5jdGlvbiAoKSB7XG4gIGlmIChtb2R1bGVEYXRhLndpdGhkcmF3UHJpY2VWaXMgPT0gXCJnb25lXCIpIHtcbiAgICBtb2R1bGVEYXRhLndpdGhkcmF3UHJpY2VWaXMgPSBcInZpc2libGVcIlxuICAgIG1vZHVsZURhdGEub3BlbkNsb3NlU3RyID0gJGkxOG4ubl9jb250ZW50X2NvbGxhcHNlO1xuICAgIG1vZHVsZURhdGEub3BlbkNsb3NlUmVzID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfaWNfZGNfc3RhdHVzX2Nsb3NlXCJcbiAgfSBlbHNlIHtcbiAgICBtb2R1bGVEYXRhLndpdGhkcmF3UHJpY2VWaXMgPSBcImdvbmVcIlxuICAgIG1vZHVsZURhdGEub3BlbkNsb3NlU3RyID0gJGkxOG4ubl9jb250ZW50X2V4cGFuZDtcbiAgICBtb2R1bGVEYXRhLm9wZW5DbG9zZVJlcyA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2ljX2RjX3N0YXR1c19vcGVuXCJcbiAgfVxufVxuXG4vLyBodW9iaeWNj+iurlxubW9kdWxlRXZlbnQuaHVvYmlTZWxlY3RlZCA9IGZ1bmN0aW9uICgpIHtcblx0aWYgKG1vZHVsZURhdGEuaHVvYmlTZWxlY3RlZCkge1xuXHRcdG1vZHVsZURhdGEuaHVvYmlTZWxlY3RlZCA9IGZhbHNlO1xuXHRcdG1vZHVsZURhdGEuaHVvYmlBZ3JlZUltYWdlID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfbGl2ZV9yZWRwYWNrZXRfdW5zZWxlY3RcIjtcblx0XHRtb2R1bGVEYXRhLmRvQmFja0NvbG9yID0gXCJAY29sb3Iva0NvbG9yRUJFQkVCXCI7XG5cdFx0bW9kdWxlRGF0YS5kb0NvbG9yID0gXCJAY29sb3IvZUJ1dHRvblVuZW5hYmxlZEJnQ29sb3JcIjtcblx0fSBlbHNlIHtcblx0XHRtb2R1bGVEYXRhLmh1b2JpU2VsZWN0ZWQgPSB0cnVlO1xuXHRcdG1vZHVsZURhdGEuaHVvYmlBZ3JlZUltYWdlID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfbGl2ZV9yZWRwYWNrZXRfc2VsZWN0XCI7XG5cdFx0bW9kdWxlRGF0YS5kb0JhY2tDb2xvciA9IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIjtcblx0XHRtb2R1bGVEYXRhLmRvQ29sb3IgPSBcIkBjb2xvci9LQmFzZVRleHRDb2xvclwiO1xuXHR9XG59XG5cbm1vZHVsZUV2ZW50Lmh1b2JpbGluayA9IGZ1bmN0aW9uICgpIHtcblx0bW9kdWxlRGF0YS5zdWJBbGVydFNob3cgPSBmYWxzZTtcbiAgICBjb21tb24ub3BlblVSTChgJHtjb21tb24uY29tbW9uRGF0YS5oNVVybH0vJHtjb21tb24uY29tbW9uRGF0YS5sYW5ndWFnZX0vc3VwcG9ydC8yNDk1MjAzMzcxMTcxN2ApO1xufVxuIiwiXG5pbXBvcnQgKiBhcyBjb21tb24gZnJvbSBcIi4vY29tbW9uXCI7XG5cbmZ1bmN0aW9uIGRlZmF1bHREYXRhKCkge1xuICAgIHJldHVybiB7XG4gICAgICAgIG1vbmV5OiAnLS0nLFxuICAgICAgICBsb2FkaW5nTG90dGllU3RhdHVzOiBcInN0b3BcIixcbiAgICB9O1xufVxuXG5jb25zdCB7IG1vZHVsZURhdGEsIG1vZHVsZUV2ZW50IH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFwicmVzdWx0XCIsIGRlZmF1bHREYXRhLCB7IG9uQ3JlYXRlIH0pO1xuXG5mdW5jdGlvbiBvbkNyZWF0ZShwYXJhbSkge1xuICAgIGNvbnNvbGUubG9nKCdvbkNyZWF0ZSByZXN1bHQnICsgcGFyYW0pO1xuICAgIGNvbnN0IHBhcmFtcyA9IEpTT04ucGFyc2UocGFyYW0pO1xuICAgIG1vZHVsZURhdGEucmVzdWx0U3RyID0gcGFyYW1zLnJlc3VsdFN0cjtcblx0c2V0VGltZW91dCgoKSA9PiB7XG5cdFx0bW9kdWxlRGF0YS5sb2FkaW5nTG90dGllU3RhdHVzID0gXCJwbGF5XCI7XG5cdH0sIDYwMCk7XG59XG5cblxubW9kdWxlRXZlbnQuY2hlY2tNeU9yZGVyID0gZnVuY3Rpb24gKCkge1xuXHRjb21tb24ub3BlblVSTChgJHtjb21tb24uY29tbW9uRGF0YS5oNVVybH0vJHtjb21tb24uY29tbW9uRGF0YS5sYW5ndWFnZX0vb3RjLW9wdGlvbi93aW4vaDUvb3JkZXJgKTtcblx0Y29tbW9uLmNvbnRhaW5lckJhY2soLTEpO1xufVxuXG5tb2R1bGVFdmVudC5jb250aW51ZUJ1eSA9IGZ1bmN0aW9uICgpIHtcbiAgICBjb21tb24uY29udGFpbmVyQmFjaygpO1xufSIsImltcG9ydCAqIGFzIGd1aWRlUG9wIGZyb20gXCIuL2d1aWRlX3BvcFwiO1xuaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiO1xuaW1wb3J0ICogYXMgaG9tZSBmcm9tIFwiLi9ob21lXCI7XG5pbXBvcnQgKiBhcyBjdXN0b20gZnJvbSBcIi4vY3VzdG9tXCI7XG5pbXBvcnQgKiBhcyBjb2luZGV0YWlsIGZyb20gXCIuL2NvaW5kZXRhaWxcIjtcbmltcG9ydCAqIGFzIGludHJvZHVjZSBmcm9tIFwiLi9pbnRyb2R1Y2VcIjtcbmltcG9ydCAqIGFzIHByb2R1Y3RzdWIgZnJvbSBcIi4vcHJvZHVjdHN1YlwiO1xuaW1wb3J0ICogYXMgcmVzdWx0IGZyb20gXCIuL3Jlc3VsdFwiO1xuXG5mdW5jdGlvbiBzZW5kQ29tbW9uQ29uZmlnKHBhcmFtKSB7XG4gICAgY29tbW9uLmdldENvbW1vbkNvbmZpZyhwYXJhbSk7XG59XG5cbmNvbW1vbi5yZXF1ZXN0QWNjb3VudElkKCk7XG4kZXZlbnQuc2VuZENvbW1vbkNvbmZpZyA9IHNlbmRDb21tb25Db25maWc7Il0sIm5hbWVzIjpbIkRQIiwiUk0iLCJNQVhfRFAiLCJNQVhfUE9XRVIiLCJORSIsIlBFIiwiTkFNRSIsIklOVkFMSUQiLCJJTlZBTElEX0RQIiwiSU5WQUxJRF9STSIsIkRJVl9CWV9aRVJPIiwiUCIsIlVOREVGSU5FRCIsIk5VTUVSSUMiLCJfQmlnXyIsIkJpZyIsIm4iLCJ4IiwidGhpcyIsInMiLCJlIiwiYyIsInNsaWNlIiwicGFyc2UiLCJjb25zdHJ1Y3RvciIsInByb3RvdHlwZSIsInZlcnNpb24iLCJpIiwibmwiLCJ0ZXN0IiwiRXJyb3IiLCJjaGFyQXQiLCJpbmRleE9mIiwicmVwbGFjZSIsInNlYXJjaCIsInN1YnN0cmluZyIsImxlbmd0aCIsInJvdW5kIiwiZHAiLCJybSIsIm1vcmUiLCJ4YyIsInVuc2hpZnQiLCJwb3AiLCJzdHJpbmdpZnkiLCJpZCIsImsiLCJ6IiwicHVzaCIsImpvaW4iLCJhYnMiLCJjbXAiLCJ5IiwiaXNuZWciLCJ5YyIsImoiLCJsIiwiZGl2IiwiYSIsImIiLCJibCIsImJ0IiwicmkiLCJieiIsImFpIiwiYWwiLCJyIiwicmwiLCJxIiwicWMiLCJxaSIsImQiLCJzaGlmdCIsImVxIiwiZ3QiLCJndGUiLCJsdCIsImx0ZSIsIm1pbnVzIiwic3ViIiwidCIsInhsdHkiLCJwbHVzIiwieGUiLCJ5ZSIsInJldmVyc2UiLCJtb2QiLCJ5Z3R4IiwidGltZXMiLCJhZGQiLCJwb3ciLCJvbmUiLCJzcXJ0IiwiaGFsZiIsIk1hdGgiLCJ0b0V4cG9uZW50aWFsIiwibXVsIiwiQXJyYXkiLCJ0b0ZpeGVkIiwidG9QcmVjaXNpb24iLCJzZCIsInRvU3RyaW5nIiwidmFsdWVPZiIsInRvSlNPTiIsIm11bHRpcGx5IiwiZm9ybWF0IiwidmFsdWUiLCJwcmVjaXNpb24iLCJiaWdWYWx1ZSIsInN0cmluZ1ZhbHVlIiwiaW5jbHVkZXMiLCJzdHJBcnJheSIsInNwbGl0IiwidHJ1bmNhdGUiLCJ6ZXJvTnVtYmVyIiwic3RyIiwiY2xpY2thYmxlIiwiYWNjb3VudElkIiwibW9kdWxlRGVmaW5lIiwibW9kdWxlTmFtZSIsImRlZmF1bHREYXRhRnVuY3Rpb24iLCJmdW5jdGlvbnMiLCJvbkNyZWF0ZSIsIm9uRGVzdHJveSIsIm9uUmVzdW1lIiwib25QYXVzZSIsIm9uU3RhcnQiLCJvblN0b3AiLCJjb25zb2xlIiwibG9nIiwiJGRhdGEiLCIkZXZlbnQiLCJtb2R1bGVEYXRhIiwibW9kdWxlRXZlbnQiLCJjb21tb25EYXRhIiwicHJpY2VDb2xvclR5cGUiLCJjb2xvck1vZGUiLCJPUyIsImFwcFZlcnNpb24iLCJpc0luUmV2aWV3IiwiaDVVcmwiLCJsYW5ndWFnZSIsInN0YXR1c0hlaWdodCIsInZUb2tlbiIsIm9sZFZUb2tlbiIsImJvdHRvbVNhZmVBcmVhSGVpZ2h0IiwiYXN5bmMiLCJvcGVuVVJMIiwidXJsIiwiJG5hdGl2ZUFQSSIsIm9wZW5Sb3V0ZSIsInNldFRpbWVvdXQiLCJnZXRDb21tb25Db25maWciLCJwYXJhbSIsInBhcnNlSW50IiwiZ2V0UE5HSWNvblVSTEJ5Q3VycmVuY3kiLCJjdXJyZW5jeSIsImJhc2VVcmwiLCJ0b0xvd2VyQ2FzZSIsInJlcXVlc3RBY2NvdW50SWQiLCJkYXRhIiwic2VuZFJlcXVlc3QiLCJKU09OIiwidHlwZSIsInNlbmRSZXF1ZXN0MiIsInBhdGgiLCJwYXJhbXMiLCJtZXRob2QiLCJob3N0VHlwZSIsImhlYWRlciIsInJlc3BvbnNlU3RyaW5nIiwicmVxdWVzdCIsInJlc3BvbnNlIiwiY29kZSIsInN0YXR1cyIsImVycl9jb2RlIiwiZXJyX21zZyIsInN0YXJ0Iiwic3RhcnRJbmRleCIsImVuZCIsImVuZEluZGV4IiwiZGF0YVN0cmluZyIsInNob3dUb2FzdCIsIm1lc3NhZ2UiLCJtc2ciLCJoYlRvYXN0Iiwic2hvd0xvYWRpbmciLCJpc1Nob3ciLCJEYXRlIiwiRm9ybWF0IiwiZm10IiwibyIsImdldE1vbnRoIiwiZ2V0RGF0ZSIsImdldEhvdXJzIiwiZ2V0TWludXRlcyIsImdldFNlY29uZHMiLCJmbG9vciIsIlMiLCJnZXRNaWxsaXNlY29uZHMiLCJSZWdFeHAiLCIkMSIsImdldEZ1bGxZZWFyIiwic3Vic3RyIiwiZm9ybWF0UHJlY2lzaW9uIiwicmVzdWx0IiwibnVtYmVyLmZvcm1hdCIsImNvbnRhaW5lckJhY2siLCJkZWZhdWx0RGF0YSIsInBvcERhdGEiLCJjdXJyZW50SW5kZXgiLCJzZXR1cFRleHQiLCJjb21tb24ubW9kdWxlRGVmaW5lIiwibGFzdCIsIm5leHQiLCJ0aXRsZUxpc3QiLCIkaTE4biIsIm5fZG91YmxlX2NvaW5fb3Blbl9hY2NvdW50Iiwibl9kb3VibGVfY29pbl9ndWlkZV9zZXR1cF8yIiwibl9kb3VibGVfY29pbl9ndWlkZV9zZXR1cF80IiwiY29udGVudExpc3QiLCJuX2RvdWJsZV9jb2luX2d1aWRlX3NldHVwXzEiLCJuX2RvdWJsZV9jb2luX2d1aWRlX3NldHVwXzMiLCJuX2RvdWJsZV9jb2luX2d1aWRlX3NldHVwXzYiLCJuX2RvdWJsZV9jb2luX2d1aWRlX3NldHVwXzgiLCJyZXF1ZXN0R3VpZGVQb3BEYXRhIiwiY29tbW9uLnNlbmRSZXF1ZXN0IiwicHJvZHVjdFR5cGVJZCIsInBpY3R1cmVMaXN0Iiwib2JqIiwidGl0bGUiLCJjb250ZW50IiwiaW1hZ2UiLCJzdWJUaXRsZSIsIm5fZG91YmxlX2NvaW5fZ3VpZGVfc2V0dXBfNSIsIm5fZG91YmxlX2NvaW5fZ3VpZGVfc2V0dXBfNyIsInVwZGF0ZVNldHVwVGV4dCIsInJlZnJlc2giLCJtYWluRGF0YSIsImFuc3dlclZpc2FibGUxIiwiYW5zd2VyVmlzYWJsZTIiLCJhbnN3ZXJWaXNhYmxlMyIsImFuc3dlclZpc2FibGU0IiwiYW5zd2VyVmlzYWJsZTUiLCJxYUljb24xIiwicWFJY29uMiIsInFhSWNvbjMiLCJxYUljb240IiwicWFJY29uNSIsImdldE5hdkNvbmZpZ1N0cmluZyIsInRpdGxlS2V5IiwibGVmdCIsImFjdGlvbiIsInBhcmFtZXRlciIsImljb24iLCJyaWdodCIsImJhY2tncm91bmRDb2xvciIsInN0YXR1c0JhckNvbmZpZyIsInN0YXR1c0Jhck1vZGUiLCJhZFN0YXR1c0JhckNvbG9yIiwibmF2Q29uZmlnIiwicmVxdWVzdENvaW5EYXRhcyIsImdldFN1cHBsZW1lbnREYXRhIiwiY2xpY2tRQSIsImluZGV4IiwiY3VyS2V5IiwiY3VyVmFsdWUiLCJjb21tb24uc2hvd0xvYWRpbmciLCJkYXRhTGlzdCIsIm5hdmlnYXRpb25zIiwibGlzdCIsImN1ckRhdGEiLCJvYmplY3QiLCJmb2xkZWRWaXNpYmxlIiwidW5mb2xkZWRWaXNpYmxlIiwiY29pbk5hbWUiLCJ0b1VwcGVyQ2FzZSIsIm1haW5JY29uIiwiY29tbW9uLmdldFBOR0ljb25VUkxCeUN1cnJlbmN5IiwiaXRlbXMiLCJpdGVtIiwiJGludGVyY2VwdCIsIm5fZG91YmxlX2NvaW5fZWFybl9sb3dfYnV5Iiwibl9kb3VibGVfY29pbl9lYXJuX2hpZ2hfc2VsbCIsImlkeFN0ciIsImNvbmNhdCIsImNsaWNrSXRlbSIsInRvQ3VzdG9tUHJvamVjdCIsImNvbW1vbi5vcGVuVVJMIiwicmlnaHRCdG5DbGlja2VkIiwidG9JbnRyb2R1Y2UiLCJ0b0RldGFpbCIsImFyciIsInN1cHBvcnRRdW90ZXMiLCJzZWxlY3RlZEl0ZW0iLCJmb290ZXJIZWlnaHQiLCJjb2luQ2hvc2VBbGVydFNob3ciLCJjb2luQ2hvc2VBbGVydEhlaWdodCIsInR5cGVDaG9zZUFsZXJ0U2hvdyIsInR5cGVDaG9zZUFsZXJ0SGVpZ2h0Iiwic2VsZWN0ZWRDb2luIiwiYmlnSWNvbiIsInNtYWxsSWNvbiIsInNlbGVjdGVkVHlwZSIsInNlbGVjdGVkRGF0ZSIsIm5fZG91YmxlX2NvaW5fZWFybl9zZWxlY3RfZXhwaXJlX2RhdGUiLCJzZWxlY3RlZFRpbWUiLCJzZWxlY3RlZERhdGVDb2xvciIsImNvaW5JbmRleFByaWNlIiwicHJvZHVjdERhdGUiLCJwcmljZVJhbmdlIiwiY2xlYXJWaXNpYmlsaXR5Iiwib25Gb2N1cyIsInRhcmdldFByaWNlVGV4dCIsImVkaXRFcnJvclNob3ciLCJlZGl0VGV4dEJvcmRlckNvbG9yIiwicHJvZHVjdFlpZWxkIiwicHJvZHVjdFlpZWxkVmlzaWJsZSIsImJ0bkJnQ29sb3IiLCJjdXJyZW50VGltZSIsImluZGV4UHJpY2VUaW1lciIsInByb2R1Y3RZaWVsZEVycm9yIiwianNvblBhcmFtZXRlcnMiLCJrZXlCb2FyZE1vZGUiLCJyZXF1ZXN0RGF0YSIsInNlbGVjdGVkIiwiZGlhbG9nVGV4dENvbG9yIiwic3ViT2JqZWN0IiwidHlwZURlc2MiLCJuX2RvdWJsZV9jb2luX2Vhcm5fbG93X2J1eV9zb21ldGhpbmciLCJuX2RvdWJsZV9jb2luX2Vhcm5faGlnaF9zZWxsX2ZvciIsImVycm9yQmFjayIsImNvbW1vbi5jb21tb25EYXRhIiwiY3VyT2JqZWN0Iiwic2VsZWN0ZWRJY29uIiwicXVvdGVDb2luIiwic3ViSXRlbSIsInNldFNlbGVjdGVkSXRlbSIsImludGVydmFsUmVxdWVzdEluZGV4UHJpY2UiLCJyZXF1ZXN0SW5kZXhQcmljZSIsInNldEludGVydmFsIiwic3ltYm9sIiwidXBkYXRlSW5kZXhQcmljZSIsInByaWNlIiwibl9kb3VibGVfY29pbl9lYXJuX3F1YW50aXR5X3ByaWNlIiwibG93UmF0ZSIsInBhcnNlRmxvYXQiLCJ1cHBlclJhdGUiLCJwZXJzaW9uIiwibG93UHJpY2UiLCJjb21tb24uZm9ybWF0UHJlY2lzaW9uIiwibnVtYmVyLm11bHRpcGx5IiwiaGlnaFByaWNlIiwibl9kb3VibGVfY29pbl9lYXJuX3ByaWNlX3JhbmdlIiwicmVxdWVzdFlpZWxkIiwicHJvZHVjdElkIiwicHJvZHVjdEZpbmFuY2VJZCIsInVuZGVmaW5lZCIsImNsZWFyRGF0YSIsInByb2R1Y3REYXRlVmlzaWJsZSIsImNvbW1vbi5zaG93VG9hc3QiLCJuX25vdF9zdXBwb3J0IiwiY29tbW9uLmNvbnRhaW5lckJhY2siLCJvcGVuQWxlcnQiLCJjbG9zZUFsZXJ0IiwiY2hvc2VDb2luIiwiaWR4IiwidGFyZ2V0T2JqZWN0IiwiY2hvc2VDb2luVHlwZSIsInNob3dEYXRlUGlja2VyIiwianNvbk9iaiIsImRvdWJsZUNvaW5TaG93RGF0ZVBpY2tlciIsInRpbWVPYmoiLCJ0aW1lc3RhbXAiLCJ0aW1lc3RhbXBUb05vb24iLCJ0aW1lIiwiZGF0ZSIsIm5fZG91YmxlX2NvaW5fcHJvZHVjdF9kdWVfbGltaXQiLCJ1cGRhdGVCdG5CZ0NvbG9yIiwiZm9ybWF0VGltZVN0ciIsImZvcm1hdFRpbWUiLCJ0b2RheSIsIm5fZG91YmxlX2NvaW5fZHVlX2RhdGVfbm90X2xlc3MiLCJuX2RvdWJsZV9jb2luX2R1ZV9kYXRlX25vdF9sZXNzXzJfbmV3IiwiZGF5IiwiZGF5c0JldHdlZW4iLCJuX2RvdWJsZV9jb2luX2Vhcm5fcHJvZHVjdF9kZWFkbGluZSIsIm5vb25EYXRlIiwic2V0SG91cnMiLCJnZXRUaW1lIiwicHJpY2VVbml0IiwiY2xlYXJJbmRleFByaWNlVGltZXIiLCJlRGF0ZSIsInNEYXRlIiwidG9Mb2NhbGVEYXRlU3RyaW5nIiwiY2xlYXJJbnRlcnZhbCIsImZvY3VzQ2hhbmdlIiwidXBkYXRlRWRpdFRleHRCb3JkZXJDb2xvciIsInRleHRDaGFuZ2UiLCJ0ZXh0IiwiaW5wdXROdW0iLCJmb2N1cyIsInN1Ym1pdCIsImhvb2tQcmljZSIsImV4cGlyZUF0IiwicXVvdGUiLCJjbGVhblByaWNlIiwibG93IiwiaGlnaCIsImN1ciIsInJlZnJlc2hTdGF0dXMiLCJiYXNlQ29pbkljb24iLCJxdW90ZUNvaW5JY29uIiwidXNkdENvbG9yIiwidXNkdEJnIiwidXNkY0NvbG9yIiwidXNkY0JnIiwidGhyZWVUaXRsZSIsInRhYkRhdGEiLCJxdW90ZVZpcyIsImluZGV4UHJpY2UiLCJkNyIsIm5fYzJjX2xlbmRfZGF5cyIsImQ3MyIsImQzOSIsImQ5IiwiaGgiLCJkZCIsImxpc3RSZXFPYmoiLCJpbmRleFByaWNlUmVxT2JqIiwibGlzdFRpbWVyT2JqZWN0IiwicGFyYW1ldGVyVGVtcCIsImluaXRVaSIsImluaXREYXRhIiwiaW50ZXJ2YWxSZXF1ZXN0UHJvZHVjdExpc3QiLCJjbGVhckxpc3RUaW1lciIsInVwZGF0ZVNlY29uZFRpdGxlIiwidXBkYXRlVGhyZWVUaXRsZSIsInVwZGF0ZUNvaW5JY29uIiwiYmFzZSIsIm5fZG91YmxlX2NvaW5fZWFybl9sb3dfYnV5X2V4cGxhaW5fbmV3Iiwibl9kb3VibGVfY29pbl9lYXJuX2hpZ2hfc2VsbF9leHBsYWluX25ldyIsInJlcXVlc3RQcm9kdWN0TGlzdCIsInByaWNlRGF0YSIsIm5fZG91YmxlX2NvaW5fZWFybl9xdWFudGl0eV9sYXRlc3QiLCJoYW5kbGVNYWluTGlzdERhdGEiLCJjeWNsZSIsImNyZWF0ZVRlbXBUYWJEYXRhIiwiaGFuZGxlVGFiRGF0YSIsInBhcmVudE9iaiIsImN1cnJUaW1lIiwiZXhwaXJlVGltZSIsImRpZmZUaW1lIiwiaCIsInRpbWVMaW1pdCIsIm5faG9tZV9pbmRleF9lYXJuX3RpbWVfbGltaXQiLCJuX2RheSIsIm5faG91ciIsImR1ZURhdGUiLCJuX2RvdWJsZV9jb2luX2Vhcm5fZXhwaXJlX2RhdGVfbmV3IiwicHJvZHVjdHMiLCJ5aWVsZEJ5RGF5IiwiY2FsWWllbGQiLCJ5aWVsZEJ5WWVhciIsImdldFRhYlVpRGF0YSIsIm5fYmFsYW5jZV9hbGwiLCJpc0NvbnRhaW5zIiwiaXNDaGVjayIsInRhZyIsInRpdGxlQ29sb3IiLCJ0aXRsZVNpemUiLCJwcm9kdWN0IiwicmF0aW8iLCJyYXRpb1N0ciIsInVzZHRDbGljayIsInF1b3RlQ2hlY2siLCJjb250cmFjdF9jb2RlIiwidXNkY0NsaWNrIiwic2hvd1RpcHNEaWFsb2ciLCJmbGFnIiwiaXRlbU9uQ2xpY2siLCJwYXJlbnRJbmRleCIsImNoaWxkSW5kZXgiLCJlbGVtZW50IiwicmF3T2JqZWN0IiwidGFiQ2xpY2siLCJ0YWJUYWciLCJ0ZW1PYmplY3QiLCJ0b0N1c3RvbSIsIm5hdiIsImN1cnJlbnRUYWciLCJ0aXRsZURhdGEiLCJuX2RvdWJsZV9jb2luX3Byb2R1Y3RfaW50cm9kdWNlIiwibl9kb3VibGVfY29pbl9wYXltZW50X3JlZ3VsYXRpb24iLCJuX3NoYXJrX2Zpbl9jb21tb25fcHJvYmxlbSIsInNsaWRlckRhdGEiLCJsaXN0VHlwZSIsImNvbXBvVGV4dDEiLCJuX2RvdWJsZV9jb2luX3Byb2R1Y3Rfb3BlcmF0aW9uX2VnX2J1eV9vbmVfbGVzcyIsInByb2JsZW1zMU9wZW4iLCJwcm9ibGVtczFDbG9zZSIsInByb2JsZW1zMk9wZW4iLCJwcm9ibGVtczJDbG9zZSIsInByb2JsZW1zM09wZW4iLCJwcm9ibGVtczNDbG9zZSIsInByb2JsZW1zNE9wZW4iLCJwcm9ibGVtczRDbG9zZSIsInByb2JsZW1zNU9wZW4iLCJwcm9ibGVtczVDbG9zZSIsInBhcmFtRGljIiwiaXNOYU4iLCJyZXNldFRpdGxlc1N0eWxlIiwib3Blbk9yQ2xvc2VQcm9ibGVtIiwidmlzaWJsZSIsInJlc2V0VGl0bGVTZWxlY3RUYWIiLCJ5ZWFyWWllbGQiLCJ5aWVsZCIsImV4cGlyZURhdGUiLCJwcmljZUxpbWl0Iiwic3ViSGludCIsInN1YklucHV0Iiwic3ViT25Gb2N1cyIsImJhc2VDb2luIiwiYmFsYW5jZSIsImVzdGltYXRlZFByb2ZpdCIsInJlc2lkdWVCdXkiLCJ3cE9uRm9jdXMiLCJzdWJVbml0Iiwid2l0aGRyYXdQcmljZUhpbnQiLCJ3aXRoZHJhd1ByaWNlVmlzIiwicmVkZWVtUHJpY2VWaXMiLCJvcGVuQ2xvc2VTdHIiLCJuX2NvbnRlbnRfZXhwYW5kIiwib3BlbkNsb3NlUmVzIiwiY2hhcnRCYXNlRGF0YSIsIndpdGhEcmF3UHJpY2UiLCJxdWFudGl0eSIsIm9wZW5BY2NvdW50QWxlcnRTaG93IiwidGlwc0FsZXJ0U2hvd0NvbW1vbiIsInRpcHNBbGVydFNob3dXcCIsImV4cGlyZVRpbWVUaXBzIiwid3BCb3JkZXJDb2xvciIsInN1YkJvcmRlckNvbG9yIiwic3ViRXJyb3JTdHIiLCJzdWJFcnJvclZpcyIsIndwRXJyb3JTdHIiLCJ3cEVycm9yVmlzIiwidGlwc1N0ciIsInByaW5jaXBhbFByZWNpc2lvbiIsImJ0bkNvbG9yIiwiYnRuVGl0bGVDb2xvciIsInN1YkFsZXJ0U2hvdyIsInByb2R1Y3ROYW1lIiwid2l0aERyYXdWaXMiLCJwb3AxU2hvdyIsInBvcDJTaG93IiwicG9wM1Nob3ciLCJodW9iaVNlbGVjdGVkIiwiaHVvYmlBZ3JlZUltYWdlIiwiYWdyZWVUZXh0IiwiZG9Db2xvciIsImRvQmFja0NvbG9yIiwic3ViRGV0YWlsVGltZXIiLCJjaGVja1ByaWNlVGltZXIiLCJ3cElucHV0IiwibU1pblN1YiIsImJ0bkVuYWJsZSIsImluZGV4UHJpZSIsInJlcXVlc3RCYW5sYW5jZSIsImNvbG9yIiwiZnVsbFRleHQiLCJuX2RvdWJsZWNvaW5fcG9wX2FncmVlbWVudF9jb250ZW50X2Z1bGwiLCJyaWNoVGV4dCIsIm5fZG91YmxlY29pbl9wb3BfYWdyZWVtZW50X2NvbnRlbnQiLCJzcGFuU3RhcnQiLCJyaWNoSGlnaGxpZ2h0Iiwiam9pblRleHQiLCJpbnRlcnZhbFN1YkRldGFpbCIsInJlcXVlc3RTdWJEZXRhaWwiLCJjb21tb24uYWNjb3VudElkIiwiZm9ybWF0QmFsYW5jZSIsInJlbW92ZUV4dHJhWmVyb3MiLCJyZXFPYmtqIiwicmVtYWluSW5nIiwiZXhwaXJlIiwibl9zaGFya19maW5fbWluX2Ftb3VudCIsIm5fZG91YmxlX2NvaW5fd2l0aGRyYXdfcHJpY2VfbG93X2J1eV9oaW50Iiwibl9kb3VibGVfY29pbl93aXRoZHJhd19wcmljZV9oaWdoX3NlbGxfaGludCIsImdldEhvb2tQcmljZSIsImd1aWRlU2hvdyIsInN0b3JhZ2UiLCJuYW1lIiwia2V5IiwiY2FsUHJpY2VMaW1pdCIsIm51bSIsImludGVydmFsQ2hlY2tQcmljZSIsImNsZWFyQ2hlY2tQcmljZVRpbWVyIiwicmVxdWVzdENoZWNrUHJpY2UiLCJ0cmFkZUN1cnJlbmN5IiwiZXhwZW5zZXNQYXlhYmxlIiwiZ2V0RXhwaXJlQXQiLCJyZWRlZW1QcmljZSIsImNvbW1vbi5zZW5kUmVxdWVzdDIiLCJjaGVja0J0blN0YXR1cyIsIm5fZG91YmxlX2NvaW5fd3BfcHJpY2VfZXJyb3JfdGlwcyIsImNsZWFyVUlEYXRhIiwiY2hlY2tPcGVuQWNjb3VudCIsIm9wZW5UcmFuc2ZlciIsInRyYW5zZmVyT2JqIiwiZG91YmxlQ29pbkFiaWxpdHkiLCJzdWJUZXh0Q2hhbmdlIiwiaW5wdXRTdHIiLCJjaGVja1N1YklucHV0Iiwic3ViRm9jdXNDaGFuZ2UiLCJtaW5TdWIiLCJuX2xpbmVhcl9zd2FwX2d1aWRlX2Fzc2V0X3RvYXN0Iiwibl9kb3VibGVfY29pbl9yZXNpZHVlX2luc3VmZmljaWVudCIsInN1Yk9uUmV0dXJuIiwibWF4U3ViIiwiYnV5Q29pbiIsImJ1eUNvaW5PYmoiLCJ0cmFuc2ZlciIsIndwVGV4dENoYW5nZSIsImNoZW5ja1dwSW5wdXQiLCJ3cEZvY3VzQ2hhbmdlIiwid3AiLCJuZXh0UG9wIiwic3RlcCIsImhpZGVQb3AiLCJ3cE9uUmV0dXJuIiwiY2xvc2VPcGVuQWNjb3VudEFsZXJ0Iiwib3BlbkRvdWJsZUNvaW5BY2NvdW50IiwicGFyIiwibl9kb3VibGVfY29pbl9vcGVuX3N1Y2Nlc3MiLCJuX2RvdWJsZV9jb2luX29wZW5fZmFpbCIsInNob3dTdWJEaWFsb2ciLCJjbG9zZVN1YkRpYWxvZyIsImRvT3JkZXIiLCJub3Rpb25hbCIsInJlc3VsdFN0ciIsIm9wZW5UaXBzRGlhbG9nIiwibl9kb3VibGVfY29pbl95aWVsZF90aXBzIiwibl9kb3VibGVfY29pbl93aXRoX2RyYXdfcHJpY2VfdGlwc19uZXdfMiIsImNsb3NlVGlwc0RpYWxvZyIsImNsZWFyRm9jdXMiLCJvcGVuV2l0aGRyYXdQcmljZUlucHV0Iiwibl9jb250ZW50X2NvbGxhcHNlIiwiaHVvYmlsaW5rIiwibW9uZXkiLCJsb2FkaW5nTG90dGllU3RhdHVzIiwiY2hlY2tNeU9yZGVyIiwiY29udGludWVCdXkiLCJzZW5kQ29tbW9uQ29uZmlnIiwiY29tbW9uLmdldENvbW1vbkNvbmZpZyIsImNvbW1vbi5yZXF1ZXN0QWNjb3VudElkIl0sIm1hcHBpbmdzIjoiQUFpQkEsSUFBSUEsS0FBSyxJQVVQQyxLQUFLLEdBR0xDLFNBQVMsS0FHVEMsWUFBWSxLQU9aQyxNQUFNLEdBUU5DLEtBQUssSUFPTEMsT0FBTyxhQUNQQyxVQUFVRCxPQUFPLFlBQ2pCRSxhQUFhRCxVQUFVLGtCQUN2QkUsYUFBYUYsVUFBVSxpQkFDdkJHLGNBQWNKLE9BQU8sb0JBR3JCSyxJQUFJLENBQUUsR0FDTkMsaUJBQWlCLEdBQ2pCQyxVQUFVOztBQU9aLFNBQVNDO0lBUVAsU0FBU0MsSUFBSUM7UUFDWCxJQUFJQyxJQUFJQztRQUdSLE1BQU1ELGFBQWFGLE1BQU0sT0FBT0MsTUFBTUosWUFBWUUsVUFBVSxJQUFJQyxJQUFJQztRQUdwRSxJQUFJQSxhQUFhRCxLQUFLO1lBQ3BCRSxFQUFFRSxJQUFJSCxFQUFFRztZQUNSRixFQUFFRyxJQUFJSixFQUFFSTtZQUNSSCxFQUFFSSxJQUFJTCxFQUFFSyxFQUFFQztBQUNoQixlQUFXO1lBQ0xDLE1BQU1OLEdBQUdEO0FBQ1Y7UUFNREMsRUFBRU8sY0FBY1Q7QUFDakI7SUFFREEsSUFBSVUsWUFBWWQ7SUFDaEJJLElBQUlmLEtBQUtBO0lBQ1RlLElBQUlkLEtBQUtBO0lBQ1RjLElBQUlYLEtBQUtBO0lBQ1RXLElBQUlWLEtBQUtBO0lBQ1RVLElBQUlXLFVBQVU7SUFFZCxPQUFPWDtBQUNUOztBQVNBLFNBQVNRLE1BQU1OLEdBQUdEO0lB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
