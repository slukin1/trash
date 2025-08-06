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

!async function() {
    var redColorList = [ "#ADB0B2", "#E94359", "#E94359", "#E94359" ];
    var greenColorList = [ "#ADB0B2", "#00A171", "#00A171", "#00A171" ];
    var upColorList;
    var downColorList;
    var cacheColorType = await $nativeAPI.rankingBridge({
        action: "getPriceColorType"
    });
    if (parseInt(cacheColorType) == 0) {
        upColorList = redColorList;
        downColorList = greenColorList;
    } else {
        upColorList = greenColorList;
        downColorList = redColorList;
    }
    var symbolInfoMapJsonString = await $nativeAPI.rankingBridge({
        action: "getAllSymbolInfo"
    });
    var symbolInfoMap = JSON.parse(symbolInfoMapJsonString);
    var iconURLHost = await $nativeAPI.rankingBridge({
        action: "getIconURLHost"
    });
    var iconPlaceholder = await $nativeAPI.rankingBridge({
        action: "getIconPlaceholder"
    });
    var rateTypeStr = await $nativeAPI.rankingBridge({
        action: "getRateTypeStr"
    });
    var cacheTitleData;
    var cacheListData;
    var currentType;
    var latestUpCoinTime = 0;
    var timerObject = null;
    var lastRequestTime = 0;
    var rankingXmlNameConfig = "";
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
    async function goToKLine(symbol) {
        console.log("goToKLine");
        await $nativeAPI.rankingBridge({
            action: "goToKLine",
            data: symbol
        });
    }
    async function setRankingData(titleData, listData) {
        console.log("setRankingData");
        var statusData = {};
        Object.keys(listData).forEach((key => {
            var data = listData[key];
            var hasData = 0;
            for (const sectionItem of data.sectionList) {
                var list = sectionItem["data"];
                if (list.length > 0) {
                    hasData = 1;
                }
            }
            statusData[key] = hasData;
        }));
        var callbackData = {
            4: listData["4"]
        };
        var data = {
            titleData: titleData,
            listData: callbackData,
            statusData: statusData,
            rankingXmlConfig: rankingXmlNameConfig
        };
        var dataJson = JSON.stringify(data);
        $data.rankingData = dataJson;
        await $nativeAPI.rankingBridge({
            action: "setRankingData",
            data: dataJson
        });
    }
    async function setRankingRequestError(errorMsg) {
        console.log("setRankingRequestError");
        await $nativeAPI.rankingBridge({
            action: "setRankingRequestError",
            data: errorMsg
        });
        console.log(errorMsg);
    }
    async function getSymbolInfo(symbol) {
        var symbolInfo = symbolInfoMap[symbol];
        if (symbolInfo == null || symbolInfo == "") {
            try {
                var symbolInfoStr = await $nativeAPI.rankingBridge({
                    action: "getSymbolInfo",
                    data: symbol
                });
                symbolInfo = JSON.parse(symbolInfoStr);
                symbolInfoMap[symbol] = symbolInfo;
            } catch (e) {
                console.log(`getSymbolInfo fail ${symbol}`);
            }
        }
        if (symbolInfo == null) {
            console.log(`getSymbolInfo fail ${symbol}`);
        }
        return symbolInfo;
    }
    async function getIconURL(currency) {
        const iconURL = `https://${iconURLHost}/-/x/hb/p/api/contents/currency/icon_png/${currency}.png`;
        return iconURL;
    }
    async function getVolumeStr(volume) {
        if (volume == null) {
            return "";
        }
        const volumeStr = await $nativeAPI.rankingBridge({
            action: "getVolumeStr",
            data: volume
        });
        return volumeStr;
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
    function sectionHeaderFrom(titles) {
        var sectionHeader = {};
        sectionHeader.leftTitle = titles[0]["titleName"];
        sectionHeader.middleTitle = titles[1]["titleName"];
        if (titles[2]["titleProperty"] == 6 || titles[2]["titleProperty"] == 7) {
            sectionHeader.rightTitle = `${titles[2]["titleName"]}(${rateTypeStr})`;
        } else {
            sectionHeader.rightTitle = titles[2]["titleName"];
        }
        var sectionTitles = [];
        for (var title of titles) {
            sectionTitles.push(title.titleName);
        }
        sectionHeader.sectionTitles = sectionTitles;
        return sectionHeader;
    }
    function resetTypeListData(item) {
        switch (item.type) {
          case 1:
            $data.upListData = item.sectionItem;
            break;

          case 2:
            $data.volumeListData = item.sectionItem;
            break;

          case 5:
            $data.hotListData = item.sectionItem;
            break;

          case 6:
            $data.downListData = item.sectionItem;
            break;

          case 4:
            for (const newItem of item.sectionList) {
                if (newItem.subType == "tradeable") {
                    $data.newListData = newItem;
                } else if (newItem.subType == "untradeable") {
                    $data.willListData = newItem;
                }
            }
            break;

          case 10:
            $data.marketCapListData = item.sectionItem;
            break;
        }
    }
    async function filterListItems(type, subType, list) {
        var filterList = [];
        for (var item of list) {
            const symbolInfo = await getSymbolInfo(item.symbol);
            if (symbolInfo == null) {
                continue;
            }
            if (symbolInfo.isHiddenUp) {
                continue;
            }
            var detailInfo = {};
            detailInfo.type = type.toFixed(0).toString();
            detailInfo.subType = subType;
            detailInfo.iconURL = await getIconURL(item.baseCurrency);
            detailInfo.iconPlaceholder = `@drawable/${iconPlaceholder}`;
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
            detailInfo.symbol = item.symbol;
            detailInfo.baseName = symbolInfo.baseCurrencyDisplayName;
            if (type == 1 || type == 6) {
                detailInfo.quoteName = `/${symbolInfo.quoteCurrencyDisplayName}`;
            }
            if (item.price != null && item.price !== "") {
                detailInfo.price = getPriceString(item.price, symbolInfo.tradePricePrecision);
            } else {
                detailInfo.price = "--";
            }
            if (type == 1 || type == 5 || type == 6) {
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
            } else if (type == 2) {
                if (item.volume != null && item.volume !== "") {
                    detailInfo.volume = await getVolumeStr(item.volume);
                } else {
                    detailInfo.volume = "--";
                }
            } else if (type == 10) {
                if (item.volume != null && item.volume !== "") {
                    detailInfo.volume = await getVolumeStr(item.volume);
                } else {
                    detailInfo.volume = "--";
                }
            } else if (type == 4) {
                if (latestUpCoinTime == null || latestUpCoinTime < item.beginTradeDate) {
                    latestUpCoinTime = item.beginTradeDate;
                }
                detailInfo.beginDate = item.beginTradeDate;
                const date = new Date(item.beginTradeDate);
                const year = date.getFullYear();
                const month = date.getMonth() + 1 < 10 ? `0${date.getMonth() + 1}` : date.getMonth() + 1;
                const day = date.getDate() < 10 ? `0${date.getDate()}` : date.getDate();
                const hour = date.getHours() < 10 ? `0${date.getHours()}` : date.getHours();
                const minute = date.getMinutes() < 10 ? `0${date.getMinutes()}` : date.getMinutes();
                if (subType == "tradeable") {
                    var ratio = 0;
                    if (Math.abs(item.beginTradeUpAndDown) > 0) {
                        ratio = item.beginTradeUpAndDown * 100;
                    }
                    var prefix = ratio > 0 ? "+" : "";
                    detailInfo.ratio = `${prefix}${ratio.toFixed(2).toString()}%`;
                    detailInfo.colorHex = getPriceColor(ratio);
                    const formattedDate = `${year}-${month}-${day}`;
                    detailInfo.beginDateStr = formattedDate;
                } else if (subType == "untradeable") {
                    const formattedDate = `${month}-${day} ${hour}:${minute}`;
                    detailInfo.beginDateStr = formattedDate;
                }
            }
            filterList.push(detailInfo);
        }
        return filterList;
    }
    async function handleRankingListData(data) {
        console.log("handleRankingListData");
        const filterListData = data.filter((item => item.type == 1 || item.type == 2 || item.type == 4 || item.type == 5 || item.type == 6 || item.type == 10));
        var titleData = filterListData.map((item => ({
            type: item.type,
            title: item.typeTitle
        })));
        const list = await Promise.all(filterListData.map((async item => {
            var dataMap = {};
            dataMap.isSingleList = !item.screen;
            dataMap.type = item.type;
            var sectionList = [];
            if (!item.screen) {
                var sectionItem = {};
                sectionItem.type = item.type;
                var titles = item.title;
                sectionItem.sectionHeader = sectionHeaderFrom(titles);
                sectionItem.data = await filterListItems(item.type, null, item.singleList);
                sectionList.push(sectionItem);
                dataMap.sectionItem = sectionItem;
            } else {
                for (var screenObject of item.screenListObject) {
                    var sectionItem = {};
                    sectionItem.type = item.type;
                    const subType = screenObject.screenValue;
                    sectionItem.subType = subType;
                    const titles = item.titleMap[subType];
                    sectionItem.sectionHeader = sectionHeaderFrom(titles);
                    var itemList = item.multipleMap[subType];
                    sectionItem.data = await filterListItems(item.type, subType, itemList);
                    sectionList.push(sectionItem);
                }
            }
            dataMap.sectionList = sectionList;
            return dataMap;
        })));
        var listData = {};
        for (const listItem of list) {
            listData[listItem.type.toFixed(0).toString()] = listItem;
            resetTypeListData(listItem);
            if (listItem.type == 4 && currentType == 4 && latestUpCoinTime != null) {
                const latestUpCache = await read("ranking", "latestUp");
                if (latestUpCoinTime > latestUpCache) {
                    await save("ranking", "latestUp", String(latestUpCoinTime));
                }
            }
        }
        cacheTitleData = titleData;
        cacheListData = listData;
        $data.titleData = titleData;
        $data.listData = listData;
        await setRankingData(cacheTitleData, cacheListData);
        lastRequestTime = (new Date).getTime();
    }
    async function updateRankingDataPrice(priceData) {
        if (cacheListData == null) {
            return;
        }
        var listDataValue = Object.values(cacheListData);
        for (var item of listDataValue) {
            for (var sectionItem of item.sectionList) {
                for (var detailInfo of sectionItem.data) {
                    const symbolInfo = await getSymbolInfo(detailInfo.symbol);
                    const coinDict = priceData[detailInfo.symbol];
                    if (coinDict == null) {
                        continue;
                    }
                    var price = coinDict.decimalcPrice;
                    type = parseInt(detailInfo.type);
                    if (price > 0) {
                        detailInfo.price = getPriceString(price.toString(), symbolInfo.tradePricePrecision);
                    }
                    if (type == 1 || type == 5 || type == 6) {
                        var ratio = 0;
                        if (Math.abs(coinDict.decimalDelta) >= 0) {
                            ratio = coinDict.decimalDelta;
                            var prefix = ratio > 0 ? "+" : "";
                            detailInfo.ratio = `${prefix}${ratio.toFixed(2).toString()}%`;
                            detailInfo.colorHex = getPriceColor(ratio);
                        }
                    }
                }
            }
            if (item.isSingleList == true) {
                item.sectionItem = item.sectionList[0];
            }
            resetTypeListData(item);
        }
        await setRankingData(cacheTitleData, cacheListData);
    }
    function sendRequest(path, params = "", method = 0, hostType = 0, header = "") {
        console.log("sendRequest");
        const param = {
            path: path,
            method: method,
            hostType: hostType,
            header: header,
            params: params
        };
        return JSON.stringify(param);
    }
    async function requestRankingList() {
        console.log("request allRankingList");
        const requestParams = sendRequest("v1/app/new/allRankingList");
        try {
            const responseString = await $nativeAPI.request(requestParams);
            const response = JSON.parse(responseString);
            const {code: code, data: data} = response;
            if (code == 200) {
                await handleRankingListData(data);
            } else {
                await setRankingRequestError(`request failed, code=${code}`);
            }
        } catch (e) {
            await setRankingRequestError(`request error, error=${e}`);
        }
    }
    async function sendSocketData(socketData) {
        console.log("sendSocketData");
        var priceData = socketData;
        await updateRankingDataPrice(priceData);
    }
    async function displayList(param) {
        currentType = parseInt(param.type);
        if (currentType == 4) {
            if (latestUpCoinTime != null) {
                const latestUpCache = await read("ranking", "latestUp");
                if (latestUpCoinTime > latestUpCache) {
                    await save("ranking", "latestUp", String(latestUpCoinTime));
                }
            }
        }
    }
    function startTimer() {
        if (timerObject == null) {
            timerObject = setInterval(timer, 1e3);
        }
    }
    function stopTimer() {
        if (timerObject) {
            clearInterval(timerObject);
            timerObject = null;
        }
    }
    async function timer() {
        const currentTime = (new Date).getTime();
        if (currentTime - lastRequestTime > 60 * 1e3) {
            await requestRankingList();
        }
    }
    function sendRankingXmlConfig() {
        var dict = {
            1: "up_ranking_list",
            2: "volume_ranking_list",
            5: "hot_ranking_list",
            6: "down_ranking_list",
            10: "market_cap_ranking_list"
        };
        console.log(`rankingXmlConfig==${JSON.stringify(dict)}`);
        rankingXmlNameConfig = JSON.stringify(dict);
        $data.rankingXmlConfig = rankingXmlNameConfig;
    }
    $event.requestRankingList = requestRankingList;
    $event.sendSocketData = sendSocketData;
    $event.goToKLine = goToKLine;
    $event.displayList = displayList;
    $event.startTimer = startTimer;
    $event.stopTimer = stopTimer;
    sendRankingXmlConfig();
    await requestRankingList();
}();
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWFpbi5qcyIsInNvdXJjZXMiOlsiLi4vLi4vcmVwb3NpdG9yeS9ub2RlX21vZHVsZXMvYmlnLmpzL2JpZy5tanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9tYWluLmpzIl0sInNvdXJjZXNDb250ZW50IjpbIi8qXHJcbiAqICBiaWcuanMgdjUuMi4yXHJcbiAqICBBIHNtYWxsLCBmYXN0LCBlYXN5LXRvLXVzZSBsaWJyYXJ5IGZvciBhcmJpdHJhcnktcHJlY2lzaW9uIGRlY2ltYWwgYXJpdGhtZXRpYy5cclxuICogIENvcHlyaWdodCAoYykgMjAxOCBNaWNoYWVsIE1jbGF1Z2hsaW4gPE04Y2g4OGxAZ21haWwuY29tPlxyXG4gKiAgaHR0cHM6Ly9naXRodWIuY29tL01pa2VNY2wvYmlnLmpzL0xJQ0VOQ0VcclxuICovXHJcblxyXG5cclxuLyoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqIEVESVRBQkxFIERFRkFVTFRTICoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqL1xyXG5cclxuXHJcbiAgLy8gVGhlIGRlZmF1bHQgdmFsdWVzIGJlbG93IG11c3QgYmUgaW50ZWdlcnMgd2l0aGluIHRoZSBzdGF0ZWQgcmFuZ2VzLlxyXG5cclxuICAvKlxyXG4gICAqIFRoZSBtYXhpbXVtIG51bWJlciBvZiBkZWNpbWFsIHBsYWNlcyAoRFApIG9mIHRoZSByZXN1bHRzIG9mIG9wZXJhdGlvbnMgaW52b2x2aW5nIGRpdmlzaW9uOlxyXG4gICAqIGRpdiBhbmQgc3FydCwgYW5kIHBvdyB3aXRoIG5lZ2F0aXZlIGV4cG9uZW50cy5cclxuICAgKi9cclxudmFyIERQID0gMjAsICAgICAgICAgIC8vIDAgdG8gTUFYX0RQXHJcblxyXG4gIC8qXHJcbiAgICogVGhlIHJvdW5kaW5nIG1vZGUgKFJNKSB1c2VkIHdoZW4gcm91bmRpbmcgdG8gdGhlIGFib3ZlIGRlY2ltYWwgcGxhY2VzLlxyXG4gICAqXHJcbiAgICogIDAgIFRvd2FyZHMgemVybyAoaS5lLiB0cnVuY2F0ZSwgbm8gcm91bmRpbmcpLiAgICAgICAoUk9VTkRfRE9XTilcclxuICAgKiAgMSAgVG8gbmVhcmVzdCBuZWlnaGJvdXIuIElmIGVxdWlkaXN0YW50LCByb3VuZCB1cC4gIChST1VORF9IQUxGX1VQKVxyXG4gICAqICAyICBUbyBuZWFyZXN0IG5laWdoYm91ci4gSWYgZXF1aWRpc3RhbnQsIHRvIGV2ZW4uICAgKFJPVU5EX0hBTEZfRVZFTilcclxuICAgKiAgMyAgQXdheSBmcm9tIHplcm8uICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIChST1VORF9VUClcclxuICAgKi9cclxuICBSTSA9IDEsICAgICAgICAgICAgIC8vIDAsIDEsIDIgb3IgM1xyXG5cclxuICAvLyBUaGUgbWF4aW11bSB2YWx1ZSBvZiBEUCBhbmQgQmlnLkRQLlxyXG4gIE1BWF9EUCA9IDFFNiwgICAgICAgLy8gMCB0byAxMDAwMDAwXHJcblxyXG4gIC8vIFRoZSBtYXhpbXVtIG1hZ25pdHVkZSBvZiB0aGUgZXhwb25lbnQgYXJndW1lbnQgdG8gdGhlIHBvdyBtZXRob2QuXHJcbiAgTUFYX1BPV0VSID0gMUU2LCAgICAvLyAxIHRvIDEwMDAwMDBcclxuXHJcbiAgLypcclxuICAgKiBUaGUgbmVnYXRpdmUgZXhwb25lbnQgKE5FKSBhdCBhbmQgYmVuZWF0aCB3aGljaCB0b1N0cmluZyByZXR1cm5zIGV4cG9uZW50aWFsIG5vdGF0aW9uLlxyXG4gICAqIChKYXZhU2NyaXB0IG51bWJlcnM6IC03KVxyXG4gICAqIC0xMDAwMDAwIGlzIHRoZSBtaW5pbXVtIHJlY29tbWVuZGVkIGV4cG9uZW50IHZhbHVlIG9mIGEgQmlnLlxyXG4gICAqL1xyXG4gIE5FID0gLTcsICAgICAgICAgICAgLy8gMCB0byAtMTAwMDAwMFxyXG5cclxuICAvKlxyXG4gICAqIFRoZSBwb3NpdGl2ZSBleHBvbmVudCAoUEUpIGF0IGFuZCBhYm92ZSB3aGljaCB0b1N0cmluZyByZXR1cm5zIGV4cG9uZW50aWFsIG5vdGF0aW9uLlxyXG4gICAqIChKYXZhU2NyaXB0IG51bWJlcnM6IDIxKVxyXG4gICAqIDEwMDAwMDAgaXMgdGhlIG1heGltdW0gcmVjb21tZW5kZWQgZXhwb25lbnQgdmFsdWUgb2YgYSBCaWcuXHJcbiAgICogKFRoaXMgbGltaXQgaXMgbm90IGVuZm9yY2VkIG9yIGNoZWNrZWQuKVxyXG4gICAqL1xyXG4gIFBFID0gMjEsICAgICAgICAgICAgLy8gMCB0byAxMDAwMDAwXHJcblxyXG5cclxuLyoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqL1xyXG5cclxuXHJcbiAgLy8gRXJyb3IgbWVzc2FnZXMuXHJcbiAgTkFNRSA9ICdbYmlnLmpzXSAnLFxyXG4gIElOVkFMSUQgPSBOQU1FICsgJ0ludmFsaWQgJyxcclxuICBJTlZBTElEX0RQID0gSU5WQUxJRCArICdkZWNpbWFsIHBsYWNlcycsXHJcbiAgSU5WQUxJRF9STSA9IElOVkFMSUQgKyAncm91bmRpbmcgbW9kZScsXHJcbiAgRElWX0JZX1pFUk8gPSBOQU1FICsgJ0RpdmlzaW9uIGJ5IHplcm8nLFxyXG5cclxuICAvLyBUaGUgc2hhcmVkIHByb3RvdHlwZSBvYmplY3QuXHJcbiAgUCA9IHt9LFxyXG4gIFVOREVGSU5FRCA9IHZvaWQgMCxcclxuICBOVU1FUklDID0gL14tPyhcXGQrKFxcLlxcZCopP3xcXC5cXGQrKShlWystXT9cXGQrKT8kL2k7XHJcblxyXG5cclxuLypcclxuICogQ3JlYXRlIGFuZCByZXR1cm4gYSBCaWcgY29uc3RydWN0b3IuXHJcbiAqXHJcbiAqL1xyXG5mdW5jdGlvbiBfQmlnXygpIHtcclxuXHJcbiAgLypcclxuICAgKiBUaGUgQmlnIGNvbnN0cnVjdG9yIGFuZCBleHBvcnRlZCBmdW5jdGlvbi5cclxuICAgKiBDcmVhdGUgYW5kIHJldHVybiBhIG5ldyBpbnN0YW5jZSBvZiBhIEJpZyBudW1iZXIgb2JqZWN0LlxyXG4gICAqXHJcbiAgICogbiB7bnVtYmVyfHN0cmluZ3xCaWd9IEEgbnVtZXJpYyB2YWx1ZS5cclxuICAgKi9cclxuICBmdW5jdGlvbiBCaWcobikge1xyXG4gICAgdmFyIHggPSB0aGlzO1xyXG5cclxuICAgIC8vIEVuYWJsZSBjb25zdHJ1Y3RvciB1c2FnZSB3aXRob3V0IG5ldy5cclxuICAgIGlmICghKHggaW5zdGFuY2VvZiBCaWcpKSByZXR1cm4gbiA9PT0gVU5ERUZJTkVEID8gX0JpZ18oKSA6IG5ldyBCaWcobik7XHJcblxyXG4gICAgLy8gRHVwbGljYXRlLlxyXG4gICAgaWYgKG4gaW5zdGFuY2VvZiBCaWcpIHtcclxuICAgICAgeC5zID0gbi5zO1xyXG4gICAgICB4LmUgPSBuLmU7XHJcbiAgICAgIHguYyA9IG4uYy5zbGljZSgpO1xyXG4gICAgfSBlbHNlIHtcclxuICAgICAgcGFyc2UoeCwgbik7XHJcbiAgICB9XHJcblxyXG4gICAgLypcclxuICAgICAqIFJldGFpbiBhIHJlZmVyZW5jZSB0byB0aGlzIEJpZyBjb25zdHJ1Y3RvciwgYW5kIHNoYWRvdyBCaWcucHJvdG90eXBlLmNvbnN0cnVjdG9yIHdoaWNoXHJcbiAgICAgKiBwb2ludHMgdG8gT2JqZWN0LlxyXG4gICAgICovXHJcbiAgICB4LmNvbnN0cnVjdG9yID0gQmlnO1xyXG4gIH1cclxuXHJcbiAgQmlnLnByb3RvdHlwZSA9IFA7XHJcbiAgQmlnLkRQID0gRFA7XHJcbiAgQmlnLlJNID0gUk07XHJcbiAgQmlnLk5FID0gTkU7XHJcbiAgQmlnLlBFID0gUEU7XHJcbiAgQmlnLnZlcnNpb24gPSAnNS4yLjInO1xyXG5cclxuICByZXR1cm4gQmlnO1xyXG59XHJcblxyXG5cclxuLypcclxuICogUGFyc2UgdGhlIG51bWJlciBvciBzdHJpbmcgdmFsdWUgcGFzc2VkIHRvIGEgQmlnIGNvbnN0cnVjdG9yLlxyXG4gKlxyXG4gKiB4IHtCaWd9IEEgQmlnIG51bWJlciBpbnN0YW5jZS5cclxuICogbiB7bnVtYmVyfHN0cmluZ30gQSBudW1lcmljIHZhbHVlLlxyXG4gKi9cclxuZnVuY3Rpb24gcGFyc2UoeCwgbikge1xyXG4gIHZhciBlLCBpLCBubDtcclxuXHJcbiAgLy8gTWludXMgemVybz9cclxuICBpZiAobiA9PT0gMCAmJiAxIC8gbiA8IDApIG4gPSAnLTAnO1xyXG4gIGVsc2UgaWYgKCFOVU1FUklDLnRlc3QobiArPSAnJykpIHRocm93IEVycm9yKElOVkFMSUQgKyAnbnVtYmVyJyk7XHJcblxyXG4gIC8vIERldGVybWluZSBzaWduLlxyXG4gIHgucyA9IG4uY2hhckF0KDApID09ICctJyA/IChuID0gbi5zbGljZSgxKSwgLTEpIDogMTtcclxuXHJcbiAgLy8gRGVjaW1hbCBwb2ludD9cclxuICBpZiAoKGUgPSBuLmluZGV4T2YoJy4nKSkgPiAtMSkgbiA9IG4ucmVwbGFjZSgnLicsICcnKTtcclxuXHJcbiAgLy8gRXhwb25lbnRpYWwgZm9ybT9cclxuICBpZiAoKGkgPSBuLnNlYXJjaCgvZS9pKSkgPiAwKSB7XHJcblxyXG4gICAgLy8gRGV0ZXJtaW5lIGV4cG9uZW50LlxyXG4gICAgaWYgKGUgPCAwKSBlID0gaTtcclxuICAgIGUgKz0gK24uc2xpY2UoaSArIDEpO1xyXG4gICAgbiA9IG4uc3Vic3RyaW5nKDAsIGkpO1xyXG4gIH0gZWxzZSBpZiAoZSA8IDApIHtcclxuXHJcbiAgICAvLyBJbnRlZ2VyLlxyXG4gICAgZSA9IG4ubGVuZ3RoO1xyXG4gIH1cclxuXHJcbiAgbmwgPSBuLmxlbmd0aDtcclxuXHJcbiAgLy8gRGV0ZXJtaW5lIGxlYWRpbmcgemVyb3MuXHJcbiAgZm9yIChpID0gMDsgaSA8IG5sICYmIG4uY2hhckF0KGkpID09ICcwJzspICsraTtcclxuXHJcbiAgaWYgKGkgPT0gbmwpIHtcclxuXHJcbiAgICAvLyBaZXJvLlxyXG4gICAgeC5jID0gW3guZSA9IDBdO1xyXG4gIH0gZWxzZSB7XHJcblxyXG4gICAgLy8gRGV0ZXJtaW5lIHRyYWlsaW5nIHplcm9zLlxyXG4gICAgZm9yICg7IG5sID4gMCAmJiBuLmNoYXJBdCgtLW5sKSA9PSAnMCc7KTtcclxuICAgIHguZSA9IGUgLSBpIC0gMTtcclxuICAgIHguYyA9IFtdO1xyXG5cclxuICAgIC8vIENvbnZlcnQgc3RyaW5nIHRvIGFycmF5IG9mIGRpZ2l0cyB3aXRob3V0IGxlYWRpbmcvdHJhaWxpbmcgemVyb3MuXHJcbiAgICBmb3IgKGUgPSAwOyBpIDw9IG5sOykgeC5jW2UrK10gPSArbi5jaGFyQXQoaSsrKTtcclxuICB9XHJcblxyXG4gIHJldHVybiB4O1xyXG59XHJcblxyXG5cclxuLypcclxuICogUm91bmQgQmlnIHggdG8gYSBtYXhpbXVtIG9mIGRwIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgcm0uXHJcbiAqIENhbGxlZCBieSBzdHJpbmdpZnksIFAuZGl2LCBQLnJvdW5kIGFuZCBQLnNxcnQuXHJcbiAqXHJcbiAqIHgge0JpZ30gVGhlIEJpZyB0byByb3VuZC5cclxuICogZHAge251bWJlcn0gSW50ZWdlciwgMCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKiBybSB7bnVtYmVyfSAwLCAxLCAyIG9yIDMgKERPV04sIEhBTEZfVVAsIEhBTEZfRVZFTiwgVVApXHJcbiAqIFttb3JlXSB7Ym9vbGVhbn0gV2hldGhlciB0aGUgcmVzdWx0IG9mIGRpdmlzaW9uIHdhcyB0cnVuY2F0ZWQuXHJcbiAqL1xyXG5mdW5jdGlvbiByb3VuZCh4LCBkcCwgcm0sIG1vcmUpIHtcclxuICB2YXIgeGMgPSB4LmMsXHJcbiAgICBpID0geC5lICsgZHAgKyAxO1xyXG5cclxuICBpZiAoaSA8IHhjLmxlbmd0aCkge1xyXG4gICAgaWYgKHJtID09PSAxKSB7XHJcblxyXG4gICAgICAvLyB4Y1tpXSBpcyB0aGUgZGlnaXQgYWZ0ZXIgdGhlIGRpZ2l0IHRoYXQgbWF5IGJlIHJvdW5kZWQgdXAuXHJcbiAgICAgIG1vcmUgPSB4Y1tpXSA+PSA1O1xyXG4gICAgfSBlbHNlIGlmIChybSA9PT0gMikge1xyXG4gICAgICBtb3JlID0geGNbaV0gPiA1IHx8IHhjW2ldID09IDUgJiZcclxuICAgICAgICAobW9yZSB8fCBpIDwgMCB8fCB4Y1tpICsgMV0gIT09IFVOREVGSU5FRCB8fCB4Y1tpIC0gMV0gJiAxKTtcclxuICAgIH0gZWxzZSBpZiAocm0gPT09IDMpIHtcclxuICAgICAgbW9yZSA9IG1vcmUgfHwgISF4Y1swXTtcclxuICAgIH0gZWxzZSB7XHJcbiAgICAgIG1vcmUgPSBmYWxzZTtcclxuICAgICAgaWYgKHJtICE9PSAwKSB0aHJvdyBFcnJvcihJTlZBTElEX1JNKTtcclxuICAgIH1cclxuXHJcbiAgICBpZiAoaSA8IDEpIHtcclxuICAgICAgeGMubGVuZ3RoID0gMTtcclxuXHJcbiAgICAgIGlmIChtb3JlKSB7XHJcblxyXG4gICAgICAgIC8vIDEsIDAuMSwgMC4wMSwgMC4wMDEsIDAuMDAwMSBldGMuXHJcbiAgICAgICAgeC5lID0gLWRwO1xyXG4gICAgICAgIHhjWzBdID0gMTtcclxuICAgICAgfSBlbHNlIHtcclxuXHJcbiAgICAgICAgLy8gWmVyby5cclxuICAgICAgICB4Y1swXSA9IHguZSA9IDA7XHJcbiAgICAgIH1cclxuICAgIH0gZWxzZSB7XHJcblxyXG4gICAgICAvLyBSZW1vdmUgYW55IGRpZ2l0cyBhZnRlciB0aGUgcmVxdWlyZWQgZGVjaW1hbCBwbGFjZXMuXHJcbiAgICAgIHhjLmxlbmd0aCA9IGktLTtcclxuXHJcbiAgICAgIC8vIFJvdW5kIHVwP1xyXG4gICAgICBpZiAobW9yZSkge1xyXG5cclxuICAgICAgICAvLyBSb3VuZGluZyB1cCBtYXkgbWVhbiB0aGUgcHJldmlvdXMgZGlnaXQgaGFzIHRvIGJlIHJvdW5kZWQgdXAuXHJcbiAgICAgICAgZm9yICg7ICsreGNbaV0gPiA5Oykge1xyXG4gICAgICAgICAgeGNbaV0gPSAwO1xyXG4gICAgICAgICAgaWYgKCFpLS0pIHtcclxuICAgICAgICAgICAgKyt4LmU7XHJcbiAgICAgICAgICAgIHhjLnVuc2hpZnQoMSk7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgfVxyXG4gICAgICB9XHJcblxyXG4gICAgICAvLyBSZW1vdmUgdHJhaWxpbmcgemVyb3MuXHJcbiAgICAgIGZvciAoaSA9IHhjLmxlbmd0aDsgIXhjWy0taV07KSB4Yy5wb3AoKTtcclxuICAgIH1cclxuICB9IGVsc2UgaWYgKHJtIDwgMCB8fCBybSA+IDMgfHwgcm0gIT09IH5+cm0pIHtcclxuICAgIHRocm93IEVycm9yKElOVkFMSURfUk0pO1xyXG4gIH1cclxuXHJcbiAgcmV0dXJuIHg7XHJcbn1cclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBzdHJpbmcgcmVwcmVzZW50aW5nIHRoZSB2YWx1ZSBvZiBCaWcgeCBpbiBub3JtYWwgb3IgZXhwb25lbnRpYWwgbm90YXRpb24uXHJcbiAqIEhhbmRsZXMgUC50b0V4cG9uZW50aWFsLCBQLnRvRml4ZWQsIFAudG9KU09OLCBQLnRvUHJlY2lzaW9uLCBQLnRvU3RyaW5nIGFuZCBQLnZhbHVlT2YuXHJcbiAqXHJcbiAqIHgge0JpZ31cclxuICogaWQ/IHtudW1iZXJ9IENhbGxlciBpZC5cclxuICogICAgICAgICAxIHRvRXhwb25lbnRpYWxcclxuICogICAgICAgICAyIHRvRml4ZWRcclxuICogICAgICAgICAzIHRvUHJlY2lzaW9uXHJcbiAqICAgICAgICAgNCB2YWx1ZU9mXHJcbiAqIG4/IHtudW1iZXJ8dW5kZWZpbmVkfSBDYWxsZXIncyBhcmd1bWVudC5cclxuICogaz8ge251bWJlcnx1bmRlZmluZWR9XHJcbiAqL1xyXG5mdW5jdGlvbiBzdHJpbmdpZnkoeCwgaWQsIG4sIGspIHtcclxuICB2YXIgZSwgcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICB6ID0gIXguY1swXTtcclxuXHJcbiAgaWYgKG4gIT09IFVOREVGSU5FRCkge1xyXG4gICAgaWYgKG4gIT09IH5+biB8fCBuIDwgKGlkID09IDMpIHx8IG4gPiBNQVhfRFApIHtcclxuICAgICAgdGhyb3cgRXJyb3IoaWQgPT0gMyA/IElOVkFMSUQgKyAncHJlY2lzaW9uJyA6IElOVkFMSURfRFApO1xyXG4gICAgfVxyXG5cclxuICAgIHggPSBuZXcgQmlnKHgpO1xyXG5cclxuICAgIC8vIFRoZSBpbmRleCBvZiB0aGUgZGlnaXQgdGhhdCBtYXkgYmUgcm91bmRlZCB1cC5cclxuICAgIG4gPSBrIC0geC5lO1xyXG5cclxuICAgIC8vIFJvdW5kP1xyXG4gICAgaWYgKHguYy5sZW5ndGggPiArK2spIHJvdW5kKHgsIG4sIEJpZy5STSk7XHJcblxyXG4gICAgLy8gdG9GaXhlZDogcmVjYWxjdWxhdGUgayBhcyB4LmUgbWF5IGhhdmUgY2hhbmdlZCBpZiB2YWx1ZSByb3VuZGVkIHVwLlxyXG4gICAgaWYgKGlkID09IDIpIGsgPSB4LmUgKyBuICsgMTtcclxuXHJcbiAgICAvLyBBcHBlbmQgemVyb3M/XHJcbiAgICBmb3IgKDsgeC5jLmxlbmd0aCA8IGs7KSB4LmMucHVzaCgwKTtcclxuICB9XHJcblxyXG4gIGUgPSB4LmU7XHJcbiAgcyA9IHguYy5qb2luKCcnKTtcclxuICBuID0gcy5sZW5ndGg7XHJcblxyXG4gIC8vIEV4cG9uZW50aWFsIG5vdGF0aW9uP1xyXG4gIGlmIChpZCAhPSAyICYmIChpZCA9PSAxIHx8IGlkID09IDMgJiYgayA8PSBlIHx8IGUgPD0gQmlnLk5FIHx8IGUgPj0gQmlnLlBFKSkge1xyXG4gICAgcyA9IHMuY2hhckF0KDApICsgKG4gPiAxID8gJy4nICsgcy5zbGljZSgxKSA6ICcnKSArIChlIDwgMCA/ICdlJyA6ICdlKycpICsgZTtcclxuXHJcbiAgLy8gTm9ybWFsIG5vdGF0aW9uLlxyXG4gIH0gZWxzZSBpZiAoZSA8IDApIHtcclxuICAgIGZvciAoOyArK2U7KSBzID0gJzAnICsgcztcclxuICAgIHMgPSAnMC4nICsgcztcclxuICB9IGVsc2UgaWYgKGUgPiAwKSB7XHJcbiAgICBpZiAoKytlID4gbikgZm9yIChlIC09IG47IGUtLTspIHMgKz0gJzAnO1xyXG4gICAgZWxzZSBpZiAoZSA8IG4pIHMgPSBzLnNsaWNlKDAsIGUpICsgJy4nICsgcy5zbGljZShlKTtcclxuICB9IGVsc2UgaWYgKG4gPiAxKSB7XHJcbiAgICBzID0gcy5jaGFyQXQoMCkgKyAnLicgKyBzLnNsaWNlKDEpO1xyXG4gIH1cclxuXHJcbiAgcmV0dXJuIHgucyA8IDAgJiYgKCF6IHx8IGlkID09IDQpID8gJy0nICsgcyA6IHM7XHJcbn1cclxuXHJcblxyXG4vLyBQcm90b3R5cGUvaW5zdGFuY2UgbWV0aG9kc1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIGFic29sdXRlIHZhbHVlIG9mIHRoaXMgQmlnLlxyXG4gKi9cclxuUC5hYnMgPSBmdW5jdGlvbiAoKSB7XHJcbiAgdmFyIHggPSBuZXcgdGhpcy5jb25zdHJ1Y3Rvcih0aGlzKTtcclxuICB4LnMgPSAxO1xyXG4gIHJldHVybiB4O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiAxIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBncmVhdGVyIHRoYW4gdGhlIHZhbHVlIG9mIEJpZyB5LFxyXG4gKiAgICAgICAtMSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgbGVzcyB0aGFuIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3JcclxuICogICAgICAgIDAgaWYgdGhleSBoYXZlIHRoZSBzYW1lIHZhbHVlLlxyXG4qL1xyXG5QLmNtcCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIGlzbmVnLFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICB4YyA9IHguYyxcclxuICAgIHljID0gKHkgPSBuZXcgeC5jb25zdHJ1Y3Rvcih5KSkuYyxcclxuICAgIGkgPSB4LnMsXHJcbiAgICBqID0geS5zLFxyXG4gICAgayA9IHguZSxcclxuICAgIGwgPSB5LmU7XHJcblxyXG4gIC8vIEVpdGhlciB6ZXJvP1xyXG4gIGlmICgheGNbMF0gfHwgIXljWzBdKSByZXR1cm4gIXhjWzBdID8gIXljWzBdID8gMCA6IC1qIDogaTtcclxuXHJcbiAgLy8gU2lnbnMgZGlmZmVyP1xyXG4gIGlmIChpICE9IGopIHJldHVybiBpO1xyXG5cclxuICBpc25lZyA9IGkgPCAwO1xyXG5cclxuICAvLyBDb21wYXJlIGV4cG9uZW50cy5cclxuICBpZiAoayAhPSBsKSByZXR1cm4gayA+IGwgXiBpc25lZyA/IDEgOiAtMTtcclxuXHJcbiAgaiA9IChrID0geGMubGVuZ3RoKSA8IChsID0geWMubGVuZ3RoKSA/IGsgOiBsO1xyXG5cclxuICAvLyBDb21wYXJlIGRpZ2l0IGJ5IGRpZ2l0LlxyXG4gIGZvciAoaSA9IC0xOyArK2kgPCBqOykge1xyXG4gICAgaWYgKHhjW2ldICE9IHljW2ldKSByZXR1cm4geGNbaV0gPiB5Y1tpXSBeIGlzbmVnID8gMSA6IC0xO1xyXG4gIH1cclxuXHJcbiAgLy8gQ29tcGFyZSBsZW5ndGhzLlxyXG4gIHJldHVybiBrID09IGwgPyAwIDogayA+IGwgXiBpc25lZyA/IDEgOiAtMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBkaXZpZGVkIGJ5IHRoZSB2YWx1ZSBvZiBCaWcgeSwgcm91bmRlZCxcclxuICogaWYgbmVjZXNzYXJ5LCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgQmlnLlJNLlxyXG4gKi9cclxuUC5kaXYgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5jLCAgICAgICAgICAgICAgICAgIC8vIGRpdmlkZW5kXHJcbiAgICBiID0gKHkgPSBuZXcgQmlnKHkpKS5jLCAgIC8vIGRpdmlzb3JcclxuICAgIGsgPSB4LnMgPT0geS5zID8gMSA6IC0xLFxyXG4gICAgZHAgPSBCaWcuRFA7XHJcblxyXG4gIGlmIChkcCAhPT0gfn5kcCB8fCBkcCA8IDAgfHwgZHAgPiBNQVhfRFApIHRocm93IEVycm9yKElOVkFMSURfRFApO1xyXG5cclxuICAvLyBEaXZpc29yIGlzIHplcm8/XHJcbiAgaWYgKCFiWzBdKSB0aHJvdyBFcnJvcihESVZfQllfWkVSTyk7XHJcblxyXG4gIC8vIERpdmlkZW5kIGlzIDA/IFJldHVybiArLTAuXHJcbiAgaWYgKCFhWzBdKSByZXR1cm4gbmV3IEJpZyhrICogMCk7XHJcblxyXG4gIHZhciBibCwgYnQsIG4sIGNtcCwgcmksXHJcbiAgICBieiA9IGIuc2xpY2UoKSxcclxuICAgIGFpID0gYmwgPSBiLmxlbmd0aCxcclxuICAgIGFsID0gYS5sZW5ndGgsXHJcbiAgICByID0gYS5zbGljZSgwLCBibCksICAgLy8gcmVtYWluZGVyXHJcbiAgICBybCA9IHIubGVuZ3RoLFxyXG4gICAgcSA9IHksICAgICAgICAgICAgICAgIC8vIHF1b3RpZW50XHJcbiAgICBxYyA9IHEuYyA9IFtdLFxyXG4gICAgcWkgPSAwLFxyXG4gICAgZCA9IGRwICsgKHEuZSA9IHguZSAtIHkuZSkgKyAxOyAgICAvLyBudW1iZXIgb2YgZGlnaXRzIG9mIHRoZSByZXN1bHRcclxuXHJcbiAgcS5zID0gaztcclxuICBrID0gZCA8IDAgPyAwIDogZDtcclxuXHJcbiAgLy8gQ3JlYXRlIHZlcnNpb24gb2YgZGl2aXNvciB3aXRoIGxlYWRpbmcgemVyby5cclxuICBiei51bnNoaWZ0KDApO1xyXG5cclxuICAvLyBBZGQgemVyb3MgdG8gbWFrZSByZW1haW5kZXIgYXMgbG9uZyBhcyBkaXZpc29yLlxyXG4gIGZvciAoOyBybCsrIDwgYmw7KSByLnB1c2goMCk7XHJcblxyXG4gIGRvIHtcclxuXHJcbiAgICAvLyBuIGlzIGhvdyBtYW55IHRpbWVzIHRoZSBkaXZpc29yIGdvZXMgaW50byBjdXJyZW50IHJlbWFpbmRlci5cclxuICAgIGZvciAobiA9IDA7IG4gPCAxMDsgbisrKSB7XHJcblxyXG4gICAgICAvLyBDb21wYXJlIGRpdmlzb3IgYW5kIHJlbWFpbmRlci5cclxuICAgICAgaWYgKGJsICE9IChybCA9IHIubGVuZ3RoKSkge1xyXG4gICAgICAgIGNtcCA9IGJsID4gcmwgPyAxIDogLTE7XHJcbiAgICAgIH0gZWxzZSB7XHJcbiAgICAgICAgZm9yIChyaSA9IC0xLCBjbXAgPSAwOyArK3JpIDwgYmw7KSB7XHJcbiAgICAgICAgICBpZiAoYltyaV0gIT0gcltyaV0pIHtcclxuICAgICAgICAgICAgY21wID0gYltyaV0gPiByW3JpXSA/IDEgOiAtMTtcclxuICAgICAgICAgICAgYnJlYWs7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgfVxyXG4gICAgICB9XHJcblxyXG4gICAgICAvLyBJZiBkaXZpc29yIDwgcmVtYWluZGVyLCBzdWJ0cmFjdCBkaXZpc29yIGZyb20gcmVtYWluZGVyLlxyXG4gICAgICBpZiAoY21wIDwgMCkge1xyXG5cclxuICAgICAgICAvLyBSZW1haW5kZXIgY2FuJ3QgYmUgbW9yZSB0aGFuIDEgZGlnaXQgbG9uZ2VyIHRoYW4gZGl2aXNvci5cclxuICAgICAgICAvLyBFcXVhbGlzZSBsZW5ndGhzIHVzaW5nIGRpdmlzb3Igd2l0aCBleHRyYSBsZWFkaW5nIHplcm8/XHJcbiAgICAgICAgZm9yIChidCA9IHJsID09IGJsID8gYiA6IGJ6OyBybDspIHtcclxuICAgICAgICAgIGlmIChyWy0tcmxdIDwgYnRbcmxdKSB7XHJcbiAgICAgICAgICAgIHJpID0gcmw7XHJcbiAgICAgICAgICAgIGZvciAoOyByaSAmJiAhclstLXJpXTspIHJbcmldID0gOTtcclxuICAgICAgICAgICAgLS1yW3JpXTtcclxuICAgICAgICAgICAgcltybF0gKz0gMTA7XHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgICByW3JsXSAtPSBidFtybF07XHJcbiAgICAgICAgfVxyXG5cclxuICAgICAgICBmb3IgKDsgIXJbMF07KSByLnNoaWZ0KCk7XHJcbiAgICAgIH0gZWxzZSB7XHJcbiAgICAgICAgYnJlYWs7XHJcbiAgICAgIH1cclxuICAgIH1cclxuXHJcbiAgICAvLyBBZGQgdGhlIGRpZ2l0IG4gdG8gdGhlIHJlc3VsdCBhcnJheS5cclxuICAgIHFjW3FpKytdID0gY21wID8gbiA6ICsrbjtcclxuXHJcbiAgICAvLyBVcGRhdGUgdGhlIHJlbWFpbmRlci5cclxuICAgIGlmIChyWzBdICYmIGNtcCkgcltybF0gPSBhW2FpXSB8fCAwO1xyXG4gICAgZWxzZSByID0gW2FbYWldXTtcclxuXHJcbiAgfSB3aGlsZSAoKGFpKysgPCBhbCB8fCByWzBdICE9PSBVTkRFRklORUQpICYmIGstLSk7XHJcblxyXG4gIC8vIExlYWRpbmcgemVybz8gRG8gbm90IHJlbW92ZSBpZiByZXN1bHQgaXMgc2ltcGx5IHplcm8gKHFpID09IDEpLlxyXG4gIGlmICghcWNbMF0gJiYgcWkgIT0gMSkge1xyXG5cclxuICAgIC8vIFRoZXJlIGNhbid0IGJlIG1vcmUgdGhhbiBvbmUgemVyby5cclxuICAgIHFjLnNoaWZ0KCk7XHJcbiAgICBxLmUtLTtcclxuICB9XHJcblxyXG4gIC8vIFJvdW5kP1xyXG4gIGlmIChxaSA+IGQpIHJvdW5kKHEsIGRwLCBCaWcuUk0sIHJbMF0gIT09IFVOREVGSU5FRCk7XHJcblxyXG4gIHJldHVybiBxO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiB0cnVlIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBlcXVhbCB0byB0aGUgdmFsdWUgb2YgQmlnIHksIG90aGVyd2lzZSByZXR1cm4gZmFsc2UuXHJcbiAqL1xyXG5QLmVxID0gZnVuY3Rpb24gKHkpIHtcclxuICByZXR1cm4gIXRoaXMuY21wKHkpO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiB0cnVlIGlmIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBpcyBncmVhdGVyIHRoYW4gdGhlIHZhbHVlIG9mIEJpZyB5LCBvdGhlcndpc2UgcmV0dXJuXHJcbiAqIGZhbHNlLlxyXG4gKi9cclxuUC5ndCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgcmV0dXJuIHRoaXMuY21wKHkpID4gMDtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gdHJ1ZSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgZ3JlYXRlciB0aGFuIG9yIGVxdWFsIHRvIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3RoZXJ3aXNlXHJcbiAqIHJldHVybiBmYWxzZS5cclxuICovXHJcblAuZ3RlID0gZnVuY3Rpb24gKHkpIHtcclxuICByZXR1cm4gdGhpcy5jbXAoeSkgPiAtMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gdHJ1ZSBpZiB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaXMgbGVzcyB0aGFuIHRoZSB2YWx1ZSBvZiBCaWcgeSwgb3RoZXJ3aXNlIHJldHVybiBmYWxzZS5cclxuICovXHJcblAubHQgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHJldHVybiB0aGlzLmNtcCh5KSA8IDA7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIHRydWUgaWYgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGlzIGxlc3MgdGhhbiBvciBlcXVhbCB0byB0aGUgdmFsdWUgb2YgQmlnIHksIG90aGVyd2lzZVxyXG4gKiByZXR1cm4gZmFsc2UuXHJcbiAqL1xyXG5QLmx0ZSA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgcmV0dXJuIHRoaXMuY21wKHkpIDwgMTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyBtaW51cyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLm1pbnVzID0gUC5zdWIgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciBpLCBqLCB0LCB4bHR5LFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgYSA9IHgucyxcclxuICAgIGIgPSAoeSA9IG5ldyBCaWcoeSkpLnM7XHJcblxyXG4gIC8vIFNpZ25zIGRpZmZlcj9cclxuICBpZiAoYSAhPSBiKSB7XHJcbiAgICB5LnMgPSAtYjtcclxuICAgIHJldHVybiB4LnBsdXMoeSk7XHJcbiAgfVxyXG5cclxuICB2YXIgeGMgPSB4LmMuc2xpY2UoKSxcclxuICAgIHhlID0geC5lLFxyXG4gICAgeWMgPSB5LmMsXHJcbiAgICB5ZSA9IHkuZTtcclxuXHJcbiAgLy8gRWl0aGVyIHplcm8/XHJcbiAgaWYgKCF4Y1swXSB8fCAheWNbMF0pIHtcclxuXHJcbiAgICAvLyB5IGlzIG5vbi16ZXJvPyB4IGlzIG5vbi16ZXJvPyBPciBib3RoIGFyZSB6ZXJvLlxyXG4gICAgcmV0dXJuIHljWzBdID8gKHkucyA9IC1iLCB5KSA6IG5ldyBCaWcoeGNbMF0gPyB4IDogMCk7XHJcbiAgfVxyXG5cclxuICAvLyBEZXRlcm1pbmUgd2hpY2ggaXMgdGhlIGJpZ2dlciBudW1iZXIuIFByZXBlbmQgemVyb3MgdG8gZXF1YWxpc2UgZXhwb25lbnRzLlxyXG4gIGlmIChhID0geGUgLSB5ZSkge1xyXG5cclxuICAgIGlmICh4bHR5ID0gYSA8IDApIHtcclxuICAgICAgYSA9IC1hO1xyXG4gICAgICB0ID0geGM7XHJcbiAgICB9IGVsc2Uge1xyXG4gICAgICB5ZSA9IHhlO1xyXG4gICAgICB0ID0geWM7XHJcbiAgICB9XHJcblxyXG4gICAgdC5yZXZlcnNlKCk7XHJcbiAgICBmb3IgKGIgPSBhOyBiLS07KSB0LnB1c2goMCk7XHJcbiAgICB0LnJldmVyc2UoKTtcclxuICB9IGVsc2Uge1xyXG5cclxuICAgIC8vIEV4cG9uZW50cyBlcXVhbC4gQ2hlY2sgZGlnaXQgYnkgZGlnaXQuXHJcbiAgICBqID0gKCh4bHR5ID0geGMubGVuZ3RoIDwgeWMubGVuZ3RoKSA/IHhjIDogeWMpLmxlbmd0aDtcclxuXHJcbiAgICBmb3IgKGEgPSBiID0gMDsgYiA8IGo7IGIrKykge1xyXG4gICAgICBpZiAoeGNbYl0gIT0geWNbYl0pIHtcclxuICAgICAgICB4bHR5ID0geGNbYl0gPCB5Y1tiXTtcclxuICAgICAgICBicmVhaztcclxuICAgICAgfVxyXG4gICAgfVxyXG4gIH1cclxuXHJcbiAgLy8geCA8IHk/IFBvaW50IHhjIHRvIHRoZSBhcnJheSBvZiB0aGUgYmlnZ2VyIG51bWJlci5cclxuICBpZiAoeGx0eSkge1xyXG4gICAgdCA9IHhjO1xyXG4gICAgeGMgPSB5YztcclxuICAgIHljID0gdDtcclxuICAgIHkucyA9IC15LnM7XHJcbiAgfVxyXG5cclxuICAvKlxyXG4gICAqIEFwcGVuZCB6ZXJvcyB0byB4YyBpZiBzaG9ydGVyLiBObyBuZWVkIHRvIGFkZCB6ZXJvcyB0byB5YyBpZiBzaG9ydGVyIGFzIHN1YnRyYWN0aW9uIG9ubHlcclxuICAgKiBuZWVkcyB0byBzdGFydCBhdCB5Yy5sZW5ndGguXHJcbiAgICovXHJcbiAgaWYgKChiID0gKGogPSB5Yy5sZW5ndGgpIC0gKGkgPSB4Yy5sZW5ndGgpKSA+IDApIGZvciAoOyBiLS07KSB4Y1tpKytdID0gMDtcclxuXHJcbiAgLy8gU3VidHJhY3QgeWMgZnJvbSB4Yy5cclxuICBmb3IgKGIgPSBpOyBqID4gYTspIHtcclxuICAgIGlmICh4Y1stLWpdIDwgeWNbal0pIHtcclxuICAgICAgZm9yIChpID0gajsgaSAmJiAheGNbLS1pXTspIHhjW2ldID0gOTtcclxuICAgICAgLS14Y1tpXTtcclxuICAgICAgeGNbal0gKz0gMTA7XHJcbiAgICB9XHJcblxyXG4gICAgeGNbal0gLT0geWNbal07XHJcbiAgfVxyXG5cclxuICAvLyBSZW1vdmUgdHJhaWxpbmcgemVyb3MuXHJcbiAgZm9yICg7IHhjWy0tYl0gPT09IDA7KSB4Yy5wb3AoKTtcclxuXHJcbiAgLy8gUmVtb3ZlIGxlYWRpbmcgemVyb3MgYW5kIGFkanVzdCBleHBvbmVudCBhY2NvcmRpbmdseS5cclxuICBmb3IgKDsgeGNbMF0gPT09IDA7KSB7XHJcbiAgICB4Yy5zaGlmdCgpO1xyXG4gICAgLS15ZTtcclxuICB9XHJcblxyXG4gIGlmICgheGNbMF0pIHtcclxuXHJcbiAgICAvLyBuIC0gbiA9ICswXHJcbiAgICB5LnMgPSAxO1xyXG5cclxuICAgIC8vIFJlc3VsdCBtdXN0IGJlIHplcm8uXHJcbiAgICB4YyA9IFt5ZSA9IDBdO1xyXG4gIH1cclxuXHJcbiAgeS5jID0geGM7XHJcbiAgeS5lID0geWU7XHJcblxyXG4gIHJldHVybiB5O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIG1vZHVsbyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLm1vZCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIHlndHgsXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5zLFxyXG4gICAgYiA9ICh5ID0gbmV3IEJpZyh5KSkucztcclxuXHJcbiAgaWYgKCF5LmNbMF0pIHRocm93IEVycm9yKERJVl9CWV9aRVJPKTtcclxuXHJcbiAgeC5zID0geS5zID0gMTtcclxuICB5Z3R4ID0geS5jbXAoeCkgPT0gMTtcclxuICB4LnMgPSBhO1xyXG4gIHkucyA9IGI7XHJcblxyXG4gIGlmICh5Z3R4KSByZXR1cm4gbmV3IEJpZyh4KTtcclxuXHJcbiAgYSA9IEJpZy5EUDtcclxuICBiID0gQmlnLlJNO1xyXG4gIEJpZy5EUCA9IEJpZy5STSA9IDA7XHJcbiAgeCA9IHguZGl2KHkpO1xyXG4gIEJpZy5EUCA9IGE7XHJcbiAgQmlnLlJNID0gYjtcclxuXHJcbiAgcmV0dXJuIHRoaXMubWludXMoeC50aW1lcyh5KSk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgbmV3IEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgcGx1cyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLnBsdXMgPSBQLmFkZCA9IGZ1bmN0aW9uICh5KSB7XHJcbiAgdmFyIHQsXHJcbiAgICB4ID0gdGhpcyxcclxuICAgIEJpZyA9IHguY29uc3RydWN0b3IsXHJcbiAgICBhID0geC5zLFxyXG4gICAgYiA9ICh5ID0gbmV3IEJpZyh5KSkucztcclxuXHJcbiAgLy8gU2lnbnMgZGlmZmVyP1xyXG4gIGlmIChhICE9IGIpIHtcclxuICAgIHkucyA9IC1iO1xyXG4gICAgcmV0dXJuIHgubWludXMoeSk7XHJcbiAgfVxyXG5cclxuICB2YXIgeGUgPSB4LmUsXHJcbiAgICB4YyA9IHguYyxcclxuICAgIHllID0geS5lLFxyXG4gICAgeWMgPSB5LmM7XHJcblxyXG4gIC8vIEVpdGhlciB6ZXJvPyB5IGlzIG5vbi16ZXJvPyB4IGlzIG5vbi16ZXJvPyBPciBib3RoIGFyZSB6ZXJvLlxyXG4gIGlmICgheGNbMF0gfHwgIXljWzBdKSByZXR1cm4geWNbMF0gPyB5IDogbmV3IEJpZyh4Y1swXSA/IHggOiBhICogMCk7XHJcblxyXG4gIHhjID0geGMuc2xpY2UoKTtcclxuXHJcbiAgLy8gUHJlcGVuZCB6ZXJvcyB0byBlcXVhbGlzZSBleHBvbmVudHMuXHJcbiAgLy8gTm90ZTogcmV2ZXJzZSBmYXN0ZXIgdGhhbiB1bnNoaWZ0cy5cclxuICBpZiAoYSA9IHhlIC0geWUpIHtcclxuICAgIGlmIChhID4gMCkge1xyXG4gICAgICB5ZSA9IHhlO1xyXG4gICAgICB0ID0geWM7XHJcbiAgICB9IGVsc2Uge1xyXG4gICAgICBhID0gLWE7XHJcbiAgICAgIHQgPSB4YztcclxuICAgIH1cclxuXHJcbiAgICB0LnJldmVyc2UoKTtcclxuICAgIGZvciAoOyBhLS07KSB0LnB1c2goMCk7XHJcbiAgICB0LnJldmVyc2UoKTtcclxuICB9XHJcblxyXG4gIC8vIFBvaW50IHhjIHRvIHRoZSBsb25nZXIgYXJyYXkuXHJcbiAgaWYgKHhjLmxlbmd0aCAtIHljLmxlbmd0aCA8IDApIHtcclxuICAgIHQgPSB5YztcclxuICAgIHljID0geGM7XHJcbiAgICB4YyA9IHQ7XHJcbiAgfVxyXG5cclxuICBhID0geWMubGVuZ3RoO1xyXG5cclxuICAvLyBPbmx5IHN0YXJ0IGFkZGluZyBhdCB5Yy5sZW5ndGggLSAxIGFzIHRoZSBmdXJ0aGVyIGRpZ2l0cyBvZiB4YyBjYW4gYmUgbGVmdCBhcyB0aGV5IGFyZS5cclxuICBmb3IgKGIgPSAwOyBhOyB4Y1thXSAlPSAxMCkgYiA9ICh4Y1stLWFdID0geGNbYV0gKyB5Y1thXSArIGIpIC8gMTAgfCAwO1xyXG5cclxuICAvLyBObyBuZWVkIHRvIGNoZWNrIGZvciB6ZXJvLCBhcyAreCArICt5ICE9IDAgJiYgLXggKyAteSAhPSAwXHJcblxyXG4gIGlmIChiKSB7XHJcbiAgICB4Yy51bnNoaWZ0KGIpO1xyXG4gICAgKyt5ZTtcclxuICB9XHJcblxyXG4gIC8vIFJlbW92ZSB0cmFpbGluZyB6ZXJvcy5cclxuICBmb3IgKGEgPSB4Yy5sZW5ndGg7IHhjWy0tYV0gPT09IDA7KSB4Yy5wb3AoKTtcclxuXHJcbiAgeS5jID0geGM7XHJcbiAgeS5lID0geWU7XHJcblxyXG4gIHJldHVybiB5O1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIEJpZyB3aG9zZSB2YWx1ZSBpcyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgcmFpc2VkIHRvIHRoZSBwb3dlciBuLlxyXG4gKiBJZiBuIGlzIG5lZ2F0aXZlLCByb3VuZCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nXHJcbiAqIG1vZGUgQmlnLlJNLlxyXG4gKlxyXG4gKiBuIHtudW1iZXJ9IEludGVnZXIsIC1NQVhfUE9XRVIgdG8gTUFYX1BPV0VSIGluY2x1c2l2ZS5cclxuICovXHJcblAucG93ID0gZnVuY3Rpb24gKG4pIHtcclxuICB2YXIgeCA9IHRoaXMsXHJcbiAgICBvbmUgPSBuZXcgeC5jb25zdHJ1Y3RvcigxKSxcclxuICAgIHkgPSBvbmUsXHJcbiAgICBpc25lZyA9IG4gPCAwO1xyXG5cclxuICBpZiAobiAhPT0gfn5uIHx8IG4gPCAtTUFYX1BPV0VSIHx8IG4gPiBNQVhfUE9XRVIpIHRocm93IEVycm9yKElOVkFMSUQgKyAnZXhwb25lbnQnKTtcclxuICBpZiAoaXNuZWcpIG4gPSAtbjtcclxuXHJcbiAgZm9yICg7Oykge1xyXG4gICAgaWYgKG4gJiAxKSB5ID0geS50aW1lcyh4KTtcclxuICAgIG4gPj49IDE7XHJcbiAgICBpZiAoIW4pIGJyZWFrO1xyXG4gICAgeCA9IHgudGltZXMoeCk7XHJcbiAgfVxyXG5cclxuICByZXR1cm4gaXNuZWcgPyBvbmUuZGl2KHkpIDogeTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyByb3VuZGVkIHVzaW5nIHJvdW5kaW5nIG1vZGUgcm1cclxuICogdG8gYSBtYXhpbXVtIG9mIGRwIGRlY2ltYWwgcGxhY2VzLCBvciwgaWYgZHAgaXMgbmVnYXRpdmUsIHRvIGFuIGludGVnZXIgd2hpY2ggaXMgYVxyXG4gKiBtdWx0aXBsZSBvZiAxMCoqLWRwLlxyXG4gKiBJZiBkcCBpcyBub3Qgc3BlY2lmaWVkLCByb3VuZCB0byAwIGRlY2ltYWwgcGxhY2VzLlxyXG4gKiBJZiBybSBpcyBub3Qgc3BlY2lmaWVkLCB1c2UgQmlnLlJNLlxyXG4gKlxyXG4gKiBkcD8ge251bWJlcn0gSW50ZWdlciwgLU1BWF9EUCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKiBybT8gMCwgMSwgMiBvciAzIChST1VORF9ET1dOLCBST1VORF9IQUxGX1VQLCBST1VORF9IQUxGX0VWRU4sIFJPVU5EX1VQKVxyXG4gKi9cclxuUC5yb3VuZCA9IGZ1bmN0aW9uIChkcCwgcm0pIHtcclxuICB2YXIgQmlnID0gdGhpcy5jb25zdHJ1Y3RvcjtcclxuICBpZiAoZHAgPT09IFVOREVGSU5FRCkgZHAgPSAwO1xyXG4gIGVsc2UgaWYgKGRwICE9PSB+fmRwIHx8IGRwIDwgLU1BWF9EUCB8fCBkcCA+IE1BWF9EUCkgdGhyb3cgRXJyb3IoSU5WQUxJRF9EUCk7XHJcbiAgcmV0dXJuIHJvdW5kKG5ldyBCaWcodGhpcyksIGRwLCBybSA9PT0gVU5ERUZJTkVEID8gQmlnLlJNIDogcm0pO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIG5ldyBCaWcgd2hvc2UgdmFsdWUgaXMgdGhlIHNxdWFyZSByb290IG9mIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZywgcm91bmRlZCwgaWZcclxuICogbmVjZXNzYXJ5LCB0byBhIG1heGltdW0gb2YgQmlnLkRQIGRlY2ltYWwgcGxhY2VzIHVzaW5nIHJvdW5kaW5nIG1vZGUgQmlnLlJNLlxyXG4gKi9cclxuUC5zcXJ0ID0gZnVuY3Rpb24gKCkge1xyXG4gIHZhciByLCBjLCB0LFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgcyA9IHgucyxcclxuICAgIGUgPSB4LmUsXHJcbiAgICBoYWxmID0gbmV3IEJpZygwLjUpO1xyXG5cclxuICAvLyBaZXJvP1xyXG4gIGlmICgheC5jWzBdKSByZXR1cm4gbmV3IEJpZyh4KTtcclxuXHJcbiAgLy8gTmVnYXRpdmU/XHJcbiAgaWYgKHMgPCAwKSB0aHJvdyBFcnJvcihOQU1FICsgJ05vIHNxdWFyZSByb290Jyk7XHJcblxyXG4gIC8vIEVzdGltYXRlLlxyXG4gIHMgPSBNYXRoLnNxcnQoeCArICcnKTtcclxuXHJcbiAgLy8gTWF0aC5zcXJ0IHVuZGVyZmxvdy9vdmVyZmxvdz9cclxuICAvLyBSZS1lc3RpbWF0ZTogcGFzcyB4IGNvZWZmaWNpZW50IHRvIE1hdGguc3FydCBhcyBpbnRlZ2VyLCB0aGVuIGFkanVzdCB0aGUgcmVzdWx0IGV4cG9uZW50LlxyXG4gIGlmIChzID09PSAwIHx8IHMgPT09IDEgLyAwKSB7XHJcbiAgICBjID0geC5jLmpvaW4oJycpO1xyXG4gICAgaWYgKCEoYy5sZW5ndGggKyBlICYgMSkpIGMgKz0gJzAnO1xyXG4gICAgcyA9IE1hdGguc3FydChjKTtcclxuICAgIGUgPSAoKGUgKyAxKSAvIDIgfCAwKSAtIChlIDwgMCB8fCBlICYgMSk7XHJcbiAgICByID0gbmV3IEJpZygocyA9PSAxIC8gMCA/ICcxZScgOiAocyA9IHMudG9FeHBvbmVudGlhbCgpKS5zbGljZSgwLCBzLmluZGV4T2YoJ2UnKSArIDEpKSArIGUpO1xyXG4gIH0gZWxzZSB7XHJcbiAgICByID0gbmV3IEJpZyhzKTtcclxuICB9XHJcblxyXG4gIGUgPSByLmUgKyAoQmlnLkRQICs9IDQpO1xyXG5cclxuICAvLyBOZXd0b24tUmFwaHNvbiBpdGVyYXRpb24uXHJcbiAgZG8ge1xyXG4gICAgdCA9IHI7XHJcbiAgICByID0gaGFsZi50aW1lcyh0LnBsdXMoeC5kaXYodCkpKTtcclxuICB9IHdoaWxlICh0LmMuc2xpY2UoMCwgZSkuam9pbignJykgIT09IHIuYy5zbGljZSgwLCBlKS5qb2luKCcnKSk7XHJcblxyXG4gIHJldHVybiByb3VuZChyLCBCaWcuRFAgLT0gNCwgQmlnLlJNKTtcclxufTtcclxuXHJcblxyXG4vKlxyXG4gKiBSZXR1cm4gYSBuZXcgQmlnIHdob3NlIHZhbHVlIGlzIHRoZSB2YWx1ZSBvZiB0aGlzIEJpZyB0aW1lcyB0aGUgdmFsdWUgb2YgQmlnIHkuXHJcbiAqL1xyXG5QLnRpbWVzID0gUC5tdWwgPSBmdW5jdGlvbiAoeSkge1xyXG4gIHZhciBjLFxyXG4gICAgeCA9IHRoaXMsXHJcbiAgICBCaWcgPSB4LmNvbnN0cnVjdG9yLFxyXG4gICAgeGMgPSB4LmMsXHJcbiAgICB5YyA9ICh5ID0gbmV3IEJpZyh5KSkuYyxcclxuICAgIGEgPSB4Yy5sZW5ndGgsXHJcbiAgICBiID0geWMubGVuZ3RoLFxyXG4gICAgaSA9IHguZSxcclxuICAgIGogPSB5LmU7XHJcblxyXG4gIC8vIERldGVybWluZSBzaWduIG9mIHJlc3VsdC5cclxuICB5LnMgPSB4LnMgPT0geS5zID8gMSA6IC0xO1xyXG5cclxuICAvLyBSZXR1cm4gc2lnbmVkIDAgaWYgZWl0aGVyIDAuXHJcbiAgaWYgKCF4Y1swXSB8fCAheWNbMF0pIHJldHVybiBuZXcgQmlnKHkucyAqIDApO1xyXG5cclxuICAvLyBJbml0aWFsaXNlIGV4cG9uZW50IG9mIHJlc3VsdCBhcyB4LmUgKyB5LmUuXHJcbiAgeS5lID0gaSArIGo7XHJcblxyXG4gIC8vIElmIGFycmF5IHhjIGhhcyBmZXdlciBkaWdpdHMgdGhhbiB5Yywgc3dhcCB4YyBhbmQgeWMsIGFuZCBsZW5ndGhzLlxyXG4gIGlmIChhIDwgYikge1xyXG4gICAgYyA9IHhjO1xyXG4gICAgeGMgPSB5YztcclxuICAgIHljID0gYztcclxuICAgIGogPSBhO1xyXG4gICAgYSA9IGI7XHJcbiAgICBiID0gajtcclxuICB9XHJcblxyXG4gIC8vIEluaXRpYWxpc2UgY29lZmZpY2llbnQgYXJyYXkgb2YgcmVzdWx0IHdpdGggemVyb3MuXHJcbiAgZm9yIChjID0gbmV3IEFycmF5KGogPSBhICsgYik7IGotLTspIGNbal0gPSAwO1xyXG5cclxuICAvLyBNdWx0aXBseS5cclxuXHJcbiAgLy8gaSBpcyBpbml0aWFsbHkgeGMubGVuZ3RoLlxyXG4gIGZvciAoaSA9IGI7IGktLTspIHtcclxuICAgIGIgPSAwO1xyXG5cclxuICAgIC8vIGEgaXMgeWMubGVuZ3RoLlxyXG4gICAgZm9yIChqID0gYSArIGk7IGogPiBpOykge1xyXG5cclxuICAgICAgLy8gQ3VycmVudCBzdW0gb2YgcHJvZHVjdHMgYXQgdGhpcyBkaWdpdCBwb3NpdGlvbiwgcGx1cyBjYXJyeS5cclxuICAgICAgYiA9IGNbal0gKyB5Y1tpXSAqIHhjW2ogLSBpIC0gMV0gKyBiO1xyXG4gICAgICBjW2otLV0gPSBiICUgMTA7XHJcblxyXG4gICAgICAvLyBjYXJyeVxyXG4gICAgICBiID0gYiAvIDEwIHwgMDtcclxuICAgIH1cclxuXHJcbiAgICBjW2pdID0gKGNbal0gKyBiKSAlIDEwO1xyXG4gIH1cclxuXHJcbiAgLy8gSW5jcmVtZW50IHJlc3VsdCBleHBvbmVudCBpZiB0aGVyZSBpcyBhIGZpbmFsIGNhcnJ5LCBvdGhlcndpc2UgcmVtb3ZlIGxlYWRpbmcgemVyby5cclxuICBpZiAoYikgKyt5LmU7XHJcbiAgZWxzZSBjLnNoaWZ0KCk7XHJcblxyXG4gIC8vIFJlbW92ZSB0cmFpbGluZyB6ZXJvcy5cclxuICBmb3IgKGkgPSBjLmxlbmd0aDsgIWNbLS1pXTspIGMucG9wKCk7XHJcbiAgeS5jID0gYztcclxuXHJcbiAgcmV0dXJuIHk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcgaW4gZXhwb25lbnRpYWwgbm90YXRpb24gdG8gZHAgZml4ZWQgZGVjaW1hbFxyXG4gKiBwbGFjZXMgYW5kIHJvdW5kZWQgdXNpbmcgQmlnLlJNLlxyXG4gKlxyXG4gKiBkcD8ge251bWJlcn0gSW50ZWdlciwgMCB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKi9cclxuUC50b0V4cG9uZW50aWFsID0gZnVuY3Rpb24gKGRwKSB7XHJcbiAgcmV0dXJuIHN0cmluZ2lmeSh0aGlzLCAxLCBkcCwgZHApO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIHN0cmluZyByZXByZXNlbnRpbmcgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIGluIG5vcm1hbCBub3RhdGlvbiB0byBkcCBmaXhlZCBkZWNpbWFsXHJcbiAqIHBsYWNlcyBhbmQgcm91bmRlZCB1c2luZyBCaWcuUk0uXHJcbiAqXHJcbiAqIGRwPyB7bnVtYmVyfSBJbnRlZ2VyLCAwIHRvIE1BWF9EUCBpbmNsdXNpdmUuXHJcbiAqXHJcbiAqICgtMCkudG9GaXhlZCgwKSBpcyAnMCcsIGJ1dCAoLTAuMSkudG9GaXhlZCgwKSBpcyAnLTAnLlxyXG4gKiAoLTApLnRvRml4ZWQoMSkgaXMgJzAuMCcsIGJ1dCAoLTAuMDEpLnRvRml4ZWQoMSkgaXMgJy0wLjAnLlxyXG4gKi9cclxuUC50b0ZpeGVkID0gZnVuY3Rpb24gKGRwKSB7XHJcbiAgcmV0dXJuIHN0cmluZ2lmeSh0aGlzLCAyLCBkcCwgdGhpcy5lICsgZHApO1xyXG59O1xyXG5cclxuXHJcbi8qXHJcbiAqIFJldHVybiBhIHN0cmluZyByZXByZXNlbnRpbmcgdGhlIHZhbHVlIG9mIHRoaXMgQmlnIHJvdW5kZWQgdG8gc2Qgc2lnbmlmaWNhbnQgZGlnaXRzIHVzaW5nXHJcbiAqIEJpZy5STS4gVXNlIGV4cG9uZW50aWFsIG5vdGF0aW9uIGlmIHNkIGlzIGxlc3MgdGhhbiB0aGUgbnVtYmVyIG9mIGRpZ2l0cyBuZWNlc3NhcnkgdG8gcmVwcmVzZW50XHJcbiAqIHRoZSBpbnRlZ2VyIHBhcnQgb2YgdGhlIHZhbHVlIGluIG5vcm1hbCBub3RhdGlvbi5cclxuICpcclxuICogc2Qge251bWJlcn0gSW50ZWdlciwgMSB0byBNQVhfRFAgaW5jbHVzaXZlLlxyXG4gKi9cclxuUC50b1ByZWNpc2lvbiA9IGZ1bmN0aW9uIChzZCkge1xyXG4gIHJldHVybiBzdHJpbmdpZnkodGhpcywgMywgc2QsIHNkIC0gMSk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcuXHJcbiAqIFJldHVybiBleHBvbmVudGlhbCBub3RhdGlvbiBpZiB0aGlzIEJpZyBoYXMgYSBwb3NpdGl2ZSBleHBvbmVudCBlcXVhbCB0byBvciBncmVhdGVyIHRoYW5cclxuICogQmlnLlBFLCBvciBhIG5lZ2F0aXZlIGV4cG9uZW50IGVxdWFsIHRvIG9yIGxlc3MgdGhhbiBCaWcuTkUuXHJcbiAqIE9taXQgdGhlIHNpZ24gZm9yIG5lZ2F0aXZlIHplcm8uXHJcbiAqL1xyXG5QLnRvU3RyaW5nID0gZnVuY3Rpb24gKCkge1xyXG4gIHJldHVybiBzdHJpbmdpZnkodGhpcyk7XHJcbn07XHJcblxyXG5cclxuLypcclxuICogUmV0dXJuIGEgc3RyaW5nIHJlcHJlc2VudGluZyB0aGUgdmFsdWUgb2YgdGhpcyBCaWcuXHJcbiAqIFJldHVybiBleHBvbmVudGlhbCBub3RhdGlvbiBpZiB0aGlzIEJpZyBoYXMgYSBwb3NpdGl2ZSBleHBvbmVudCBlcXVhbCB0byBvciBncmVhdGVyIHRoYW5cclxuICogQmlnLlBFLCBvciBhIG5lZ2F0aXZlIGV4cG9uZW50IGVxdWFsIHRvIG9yIGxlc3MgdGhhbiBCaWcuTkUuXHJcbiAqIEluY2x1ZGUgdGhlIHNpZ24gZm9yIG5lZ2F0aXZlIHplcm8uXHJcbiAqL1xyXG5QLnZhbHVlT2YgPSBQLnRvSlNPTiA9IGZ1bmN0aW9uICgpIHtcclxuICByZXR1cm4gc3RyaW5naWZ5KHRoaXMsIDQpO1xyXG59O1xyXG5cclxuXHJcbi8vIEV4cG9ydFxyXG5cclxuXHJcbmV4cG9ydCB2YXIgQmlnID0gX0JpZ18oKTtcclxuXHJcbmV4cG9ydCBkZWZhdWx0IEJpZztcclxuIiwiXG5pbXBvcnQgQmlnIGZyb20gJ2JpZy5qcyc7XG5cbiEoYXN5bmMgZnVuY3Rpb24gKCkge1xuXG4gICAgLy/mtqjot4zluYXpopzoibLphY3nva5cbiAgICB2YXIgcmVkQ29sb3JMaXN0ID0gW1wiI0FEQjBCMlwiLCBcIiNFOTQzNTlcIiwgXCIjRTk0MzU5XCIsIFwiI0U5NDM1OVwiXTtcbiAgICB2YXIgZ3JlZW5Db2xvckxpc3QgPSBbXCIjQURCMEIyXCIsIFwiIzAwQTE3MVwiLCBcIiMwMEExNzFcIiwgXCIjMDBBMTcxXCJdO1xuXG4gICAgLy8g6aKc6Imy6YWN572uIDA657qi5rao57u/6LeMIOaIliAxOue7v+a2qOe6oui3jFxuICAgIHZhciB1cENvbG9yTGlzdDtcbiAgICB2YXIgZG93bkNvbG9yTGlzdDtcblxuICAgIHZhciBjYWNoZUNvbG9yVHlwZSA9IGF3YWl0ICRuYXRpdmVBUEkucmFua2luZ0JyaWRnZSh7IGFjdGlvbjogXCJnZXRQcmljZUNvbG9yVHlwZVwiIH0pO1xuXG4gICAgaWYgKHBhcnNlSW50KGNhY2hlQ29sb3JUeXBlKSA9PSAwKSB7XG4gICAgICAgIHVwQ29sb3JMaXN0ID0gcmVkQ29sb3JMaXN0O1xuICAgICAgICBkb3duQ29sb3JMaXN0ID0gZ3JlZW5Db2xvckxpc3Q7XG4gICAgfVxuICAgIGVsc2Uge1xuICAgICAgICB1cENvbG9yTGlzdCA9IGdyZWVuQ29sb3JMaXN0O1xuICAgICAgICBkb3duQ29sb3JMaXN0ID0gcmVkQ29sb3JMaXN0O1xuICAgIH1cblxuICAgIC8v5biB5a+55L+h5oGvXG4gICAgdmFyIHN5bWJvbEluZm9NYXBKc29uU3RyaW5nID0gYXdhaXQgJG5hdGl2ZUFQSS5yYW5raW5nQnJpZGdlKHsgYWN0aW9uOiBcImdldEFsbFN5bWJvbEluZm9cIiB9KVxuICAgIHZhciBzeW1ib2xJbmZvTWFwID0gSlNPTi5wYXJzZShzeW1ib2xJbmZvTWFwSnNvblN0cmluZyk7XG5cbiAgICAvLyBpY29uIHVybOeahOWfn+WQjVxuICAgIHZhciBpY29uVVJMSG9zdCA9IGF3YWl0ICRuYXRpdmVBUEkucmFua2luZ0JyaWRnZSh7IGFjdGlvbjogXCJnZXRJY29uVVJMSG9zdFwiIH0pO1xuXG4gICAgLy9pY29uIOm7mOiupOWNoOS9jeWbvuWQjeensFxuICAgIHZhciBpY29uUGxhY2Vob2xkZXIgPSBhd2FpdCAkbmF0aXZlQVBJLnJhbmtpbmdCcmlkZ2UoeyBhY3Rpb246IFwiZ2V0SWNvblBsYWNlaG9sZGVyXCIgfSk7XG5cbiAgICAvL+iuoeS7t+aWueW8j+Wtl+espuS4slxuICAgIHZhciByYXRlVHlwZVN0ciA9IGF3YWl0ICRuYXRpdmVBUEkucmFua2luZ0JyaWRnZSh7IGFjdGlvbjogXCJnZXRSYXRlVHlwZVN0clwiIH0pO1xuXG4gICAgLy/pobXpnaLnmoTmoIfpopjmlbDmja5cbiAgICB2YXIgY2FjaGVUaXRsZURhdGE7XG5cbiAgICAvL+mhtemdoueahOWIl+ihqOaVsOaNrlxuICAgIHZhciBjYWNoZUxpc3REYXRhO1xuXG4gICAgdmFyIGN1cnJlbnRUeXBlO1xuICAgIHZhciBsYXRlc3RVcENvaW5UaW1lID0gMDtcblxuICAgIHZhciB0aW1lck9iamVjdCA9IG51bGw7XG4gICAgdmFyIGxhc3RSZXF1ZXN0VGltZSA9IDA7XG4gICAgdmFyIHJhbmtpbmdYbWxOYW1lQ29uZmlnID0gXCJcIjtcblxuICAgIC8v5L+d5a2Y5pWw5o2uXG4gICAgYXN5bmMgZnVuY3Rpb24gc2F2ZShtb2R1bGUsIGtleSwgZGF0YSkge1xuICAgICAgICBhd2FpdCAkbmF0aXZlQVBJLnN0b3JhZ2Uoe1xuICAgICAgICAgICAgYWN0aW9uOiBcInNhdmVcIixcbiAgICAgICAgICAgIG5hbWU6IG1vZHVsZSxcbiAgICAgICAgICAgIGtleToga2V5LFxuICAgICAgICAgICAgZGF0YTogSlNPTi5zdHJpbmdpZnkoZGF0YSlcbiAgICAgICAgfSk7XG4gICAgfVxuXG4gICAgLy/or7vlj5bmlbDmja5cbiAgICBhc3luYyBmdW5jdGlvbiByZWFkKG1vZHVsZSwga2V5KSB7XG4gICAgICAgIGNvbnN0IGRhdGEgPSBhd2FpdCAkbmF0aXZlQVBJLnN0b3JhZ2Uoe1xuICAgICAgICAgICAgYWN0aW9uOiBcInJlYWRcIixcbiAgICAgICAgICAgIG5hbWU6IG1vZHVsZSxcbiAgICAgICAgICAgIGtleToga2V5XG4gICAgICAgIH0pO1xuICAgICAgICBpZiAoZGF0YSAmJiBkYXRhICE9IFwiXCIpIHtcbiAgICAgICAgICAgIHJldHVybiBKU09OLnBhcnNlKGRhdGEpO1xuICAgICAgICB9XG4gICAgICAgIHJldHVybiBudWxsO1xuICAgIH1cblxuICAgIC8v6Lez6L2sS+e6v1xuICAgIGFzeW5jIGZ1bmN0aW9uIGdvVG9LTGluZShzeW1ib2wpIHtcbiAgICAgICAgY29uc29sZS5sb2coJ2dvVG9LTGluZScpO1xuICAgICAgICBhd2FpdCAkbmF0aXZlQVBJLnJhbmtpbmdCcmlkZ2UoeyBhY3Rpb246IFwiZ29Ub0tMaW5lXCIsIGRhdGE6IHN5bWJvbCB9KTtcbiAgICB9XG5cbiAgICAvL+Wbnuiwg+aVsOaNrlxuICAgIGFzeW5jIGZ1bmN0aW9uIHNldFJhbmtpbmdEYXRhKHRpdGxlRGF0YSwgbGlzdERhdGEpIHtcbiAgICAgICAgY29uc29sZS5sb2coJ3NldFJhbmtpbmdEYXRhJyk7XG5cbiAgICAgICAgdmFyIHN0YXR1c0RhdGEgPSB7fTtcbiAgICAgICAgT2JqZWN0LmtleXMobGlzdERhdGEpLmZvckVhY2goa2V5ID0+IHtcbiAgICAgICAgICAgIHZhciBkYXRhID0gbGlzdERhdGFba2V5XTtcbiAgICAgICAgICAgIHZhciBoYXNEYXRhID0gMDtcbiAgICAgICAgICAgIGZvciAoY29uc3Qgc2VjdGlvbkl0ZW0gb2YgZGF0YS5zZWN0aW9uTGlzdCkge1xuICAgICAgICAgICAgICAgIHZhciBsaXN0ID0gc2VjdGlvbkl0ZW1bXCJkYXRhXCJdO1xuICAgICAgICAgICAgICAgIGlmIChsaXN0Lmxlbmd0aCA+IDApIHtcbiAgICAgICAgICAgICAgICAgICAgaGFzRGF0YSA9IDE7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgfVxuICAgICAgICAgICAgc3RhdHVzRGF0YVtrZXldID0gaGFzRGF0YTtcbiAgICAgICAgfSk7XG5cbiAgICAgICAgdmFyIGNhbGxiYWNrRGF0YSA9IHsgXCI0XCI6IGxpc3REYXRhW1wiNFwiXSB9O1xuICAgICAgICB2YXIgZGF0YSA9IHsgdGl0bGVEYXRhLCBsaXN0RGF0YTogY2FsbGJhY2tEYXRhLCBzdGF0dXNEYXRhLCByYW5raW5nWG1sQ29uZmlnOiByYW5raW5nWG1sTmFtZUNvbmZpZyB9O1xuICAgICAgICB2YXIgZGF0YUpzb24gPSBKU09OLnN0cmluZ2lmeShkYXRhKTtcbiAgICAgICAgJGRhdGEucmFua2luZ0RhdGEgPSBkYXRhSnNvbjtcbiAgICAgICAgYXdhaXQgJG5hdGl2ZUFQSS5yYW5raW5nQnJpZGdlKHsgYWN0aW9uOiBcInNldFJhbmtpbmdEYXRhXCIsIGRhdGE6IGRhdGFKc29uIH0pO1xuICAgIH1cblxuICAgIC8v6ZSZ6K+v5L+h5oGv5Zue6LCDXG4gICAgYXN5bmMgZnVuY3Rpb24gc2V0UmFua2luZ1JlcXVlc3RFcnJvcihlcnJvck1zZykge1xuICAgICAgICBjb25zb2xlLmxvZygnc2V0UmFua2luZ1JlcXVlc3RFcnJvcicpO1xuICAgICAgICBhd2FpdCAkbmF0aXZlQVBJLnJhbmtpbmdCcmlkZ2UoeyBhY3Rpb246IFwic2V0UmFua2luZ1JlcXVlc3RFcnJvclwiLCBkYXRhOiBlcnJvck1zZyB9KTtcbiAgICAgICAgY29uc29sZS5sb2coZXJyb3JNc2cpO1xuICAgIH1cblxuICAgIC8v6I635Y+W5Y2V5Liq5biB5a+55L+h5oGvXG4gICAgYXN5bmMgZnVuY3Rpb24gZ2V0U3ltYm9sSW5mbyhzeW1ib2wpIHtcbiAgICAgICAgLy8gY29uc29sZS5sb2coJ2dldFN5bWJvbEluZm8nICsgc3ltYm9sKTtcbiAgICAgICAgdmFyIHN5bWJvbEluZm8gPSBzeW1ib2xJbmZvTWFwW3N5bWJvbF07XG4gICAgICAgIGlmIChzeW1ib2xJbmZvID09IG51bGwgfHwgc3ltYm9sSW5mbyA9PSBcIlwiKSB7XG4gICAgICAgICAgICB0cnkge1xuICAgICAgICAgICAgICAgIHZhciBzeW1ib2xJbmZvU3RyID0gYXdhaXQgJG5hdGl2ZUFQSS5yYW5raW5nQnJpZGdlKHsgYWN0aW9uOiBcImdldFN5bWJvbEluZm9cIiwgZGF0YTogc3ltYm9sIH0pXG4gICAgICAgICAgICAgICAgc3ltYm9sSW5mbyA9IEpTT04ucGFyc2Uoc3ltYm9sSW5mb1N0cik7XG4gICAgICAgICAgICAgICAgc3ltYm9sSW5mb01hcFtzeW1ib2xdID0gc3ltYm9sSW5mbztcbiAgICAgICAgICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhgZ2V0U3ltYm9sSW5mbyBmYWlsICR7c3ltYm9sfWApO1xuICAgICAgICAgICAgfVxuICAgICAgICB9XG4gICAgICAgIGlmIChzeW1ib2xJbmZvID09IG51bGwpIHtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGBnZXRTeW1ib2xJbmZvIGZhaWwgJHtzeW1ib2x9YCk7XG4gICAgICAgIH1cbiAgICAgICAgLy8gY29uc29sZS5sb2coJ2dldFN5bWJvbEluZm8gZW5kJyArIHN5bWJvbCArICcgJyArIEpTT04uc3RyaW5naWZ5KHN5bWJvbEluZm8pKTtcbiAgICAgICAgcmV0dXJuIHN5bWJvbEluZm87XG4gICAgfVxuXG4gICAgLy/ojrflj5ZpY29u5a6M5pW0dXJsXG4gICAgYXN5bmMgZnVuY3Rpb24gZ2V0SWNvblVSTChjdXJyZW5jeSkge1xuICAgICAgICAvLyBjb25zb2xlLmxvZygnZ2V0SWNvblVSTCcpO1xuICAgICAgICBjb25zdCBpY29uVVJMID0gYGh0dHBzOi8vJHtpY29uVVJMSG9zdH0vLS94L2hiL3AvYXBpL2NvbnRlbnRzL2N1cnJlbmN5L2ljb25fcG5nLyR7Y3VycmVuY3l9LnBuZ2A7XG4gICAgICAgIHJldHVybiBpY29uVVJMO1xuICAgIH1cblxuICAgIC8v6I635Y+W5oiQ5Lqk6aKd5pi+56S65paH5pysXG4gICAgYXN5bmMgZnVuY3Rpb24gZ2V0Vm9sdW1lU3RyKHZvbHVtZSkge1xuICAgICAgICAvLyBjb25zb2xlLmxvZygnZ2V0Vm9sdW1lU3RyJyk7XG4gICAgICAgIGlmICh2b2x1bWUgPT0gbnVsbCkge1xuICAgICAgICAgICAgcmV0dXJuIFwiXCI7XG4gICAgICAgIH1cbiAgICAgICAgY29uc3Qgdm9sdW1lU3RyID0gYXdhaXQgJG5hdGl2ZUFQSS5yYW5raW5nQnJpZGdlKHsgYWN0aW9uOiBcImdldFZvbHVtZVN0clwiLCBkYXRhOiB2b2x1bWUgfSk7XG4gICAgICAgIHJldHVybiB2b2x1bWVTdHI7XG4gICAgfVxuXG4gICAgLy/ojrflj5bmtqjot4zpopzoibJcbiAgICBmdW5jdGlvbiBnZXRQcmljZUNvbG9yKHJhdGlvKSB7XG4gICAgICAgIC8vIGNvbnNvbGUubG9nKCdnZXRQcmljZUNvbG9yJyk7XG4gICAgICAgIGlmIChyYXRpbyA9PSBudWxsKSB7XG4gICAgICAgICAgICByYXRpbyA9IDA7XG4gICAgICAgIH1cbiAgICAgICAgY29uc3QgcmF0aW9fYWJzID0gTWF0aC5hYnMocmF0aW8pO1xuICAgICAgICB2YXIgY29sb3JMZXZlbCA9IDA7XG4gICAgICAgIGlmIChyYXRpb19hYnMgPiAwICYmIHJhdGlvX2FicyA8IDMpIHtcbiAgICAgICAgICAgIGNvbG9yTGV2ZWwgPSAxO1xuICAgICAgICB9XG4gICAgICAgIGVsc2UgaWYgKHJhdGlvX2FicyA+PSAzICYmIHJhdGlvX2FicyA8IDgpIHtcbiAgICAgICAgICAgIGNvbG9yTGV2ZWwgPSAyO1xuICAgICAgICB9XG4gICAgICAgIGVsc2UgaWYgKHJhdGlvX2FicyA+PSA4KSB7XG4gICAgICAgICAgICBjb2xvckxldmVsID0gMztcbiAgICAgICAgfVxuICAgICAgICB2YXIgY29sb3JIZXhTdHIgPSBudWxsO1xuICAgICAgICBpZiAocmF0aW8gPiAwKSB7XG4gICAgICAgICAgICBjb2xvckhleFN0ciA9IHVwQ29sb3JMaXN0W2NvbG9yTGV2ZWxdO1xuICAgICAgICB9XG4gICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgY29sb3JIZXhTdHIgPSBkb3duQ29sb3JMaXN0W2NvbG9yTGV2ZWxdO1xuICAgICAgICB9XG4gICAgICAgIHJldHVybiBjb2xvckhleFN0cjtcbiAgICB9XG5cbiAgICBmdW5jdGlvbiBnZXRQcmljZVN0cmluZyhwcmljZVN0ciwgcHJlY2lzaW9uKSB7XG4gICAgICAgIGNvbnN0IHByaWNlTnVtID0gTnVtYmVyKHByaWNlU3RyKTtcbiAgICAgICAgY29uc3QgYmlnVmFsdWUgPSBuZXcgQmlnKHByaWNlTnVtKTtcbiAgICAgICAgY29uc3QgcHJpY2VTdHJpbmcgPSBiaWdWYWx1ZS50b0ZpeGVkKHByZWNpc2lvbiwgeyBub3RhdGlvbjogJ2ZpeGVkJywgcHJlY2lzaW9uIH0pO1xuICAgICAgICBjb25zdCBmaW5hbFByaWNlU3RyID0gcHJpY2VTdHJpbmcucmVwbGFjZSgvXFxkKD89KFxcZHszfSkrXFwuKS9nLCAnJCYsJyk7XG4gICAgICAgIHJldHVybiBmaW5hbFByaWNlU3RyO1xuICAgIH1cblxuXG4gICAgZnVuY3Rpb24gc2VjdGlvbkhlYWRlckZyb20odGl0bGVzKSB7XG4gICAgICAgIC8v6aG26YOo5qCH6aKYXG4gICAgICAgIHZhciBzZWN0aW9uSGVhZGVyID0ge307XG4gICAgICAgIHNlY3Rpb25IZWFkZXIubGVmdFRpdGxlID0gdGl0bGVzWzBdW1widGl0bGVOYW1lXCJdO1xuICAgICAgICBzZWN0aW9uSGVhZGVyLm1pZGRsZVRpdGxlID0gdGl0bGVzWzFdW1widGl0bGVOYW1lXCJdO1xuICAgICAgICBpZiAodGl0bGVzWzJdW1widGl0bGVQcm9wZXJ0eVwiXSA9PSA2IHx8IHRpdGxlc1syXVtcInRpdGxlUHJvcGVydHlcIl0gPT0gNykge1xuICAgICAgICAgICAgc2VjdGlvbkhlYWRlci5yaWdodFRpdGxlID0gYCR7dGl0bGVzWzJdW1widGl0bGVOYW1lXCJdfSgke3JhdGVUeXBlU3RyfSlgO1xuICAgICAgICB9XG4gICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgc2VjdGlvbkhlYWRlci5yaWdodFRpdGxlID0gdGl0bGVzWzJdW1widGl0bGVOYW1lXCJdO1xuICAgICAgICB9XG5cbiAgICAgICAgdmFyIHNlY3Rpb25UaXRsZXMgPSBbXTtcbiAgICAgICAgZm9yICh2YXIgdGl0bGUgb2YgdGl0bGVzKSB7XG4gICAgICAgICAgICBzZWN0aW9uVGl0bGVzLnB1c2godGl0bGUudGl0bGVOYW1lKTtcbiAgICAgICAgfVxuICAgICAgICBzZWN0aW9uSGVhZGVyLnNlY3Rpb25UaXRsZXMgPSBzZWN0aW9uVGl0bGVzO1xuICAgICAgICByZXR1cm4gc2VjdGlvbkhlYWRlcjtcbiAgICB9XG5cbiAgICBmdW5jdGlvbiByZXNldFR5cGVMaXN0RGF0YShpdGVtKSB7XG4gICAgICAgIC8vMTrmtqjluYXmppwgMjrmiJDkuqTpop3mppwgNDrmlrDluIHmppwgIDXvvJrng63mppwgNu+8mui3jOW5heamnCAxMCA6IOW4guWAvOamnFxuICAgICAgICBzd2l0Y2ggKGl0ZW0udHlwZSkge1xuICAgICAgICAgICAgY2FzZSAxOlxuICAgICAgICAgICAgICAgICRkYXRhLnVwTGlzdERhdGEgPSBpdGVtLnNlY3Rpb25JdGVtO1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSAyOlxuICAgICAgICAgICAgICAgICRkYXRhLnZvbHVtZUxpc3REYXRhID0gaXRlbS5zZWN0aW9uSXRlbTtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGNhc2UgNTpcbiAgICAgICAgICAgICAgICAkZGF0YS5ob3RMaXN0RGF0YSA9IGl0ZW0uc2VjdGlvbkl0ZW07XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIDY6XG4gICAgICAgICAgICAgICAgJGRhdGEuZG93bkxpc3REYXRhID0gaXRlbS5zZWN0aW9uSXRlbTtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGNhc2UgNDpcbiAgICAgICAgICAgICAgICBmb3IgKGNvbnN0IG5ld0l0ZW0gb2YgaXRlbS5zZWN0aW9uTGlzdCkge1xuICAgICAgICAgICAgICAgICAgICBpZiAobmV3SXRlbS5zdWJUeXBlID09IFwidHJhZGVhYmxlXCIpIHtcbiAgICAgICAgICAgICAgICAgICAgICAgICRkYXRhLm5ld0xpc3REYXRhID0gbmV3SXRlbTtcbiAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgICAgICBlbHNlIGlmIChuZXdJdGVtLnN1YlR5cGUgPT0gXCJ1bnRyYWRlYWJsZVwiKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICAkZGF0YS53aWxsTGlzdERhdGEgPSBuZXdJdGVtO1xuICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSAxMDovL+W4guWAvOamnFxuICAgICAgICAgICAgICAgICRkYXRhLm1hcmtldENhcExpc3REYXRhID0gaXRlbS5zZWN0aW9uSXRlbTtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgfVxuICAgIH1cblxuICAgIC8v5aSE55CGY2VsbOaVsOaNrlxuICAgIGFzeW5jIGZ1bmN0aW9uIGZpbHRlckxpc3RJdGVtcyh0eXBlLCBzdWJUeXBlLCBsaXN0KSB7XG4gICAgICAgIC8vIGNvbnNvbGUubG9nKCdmaWx0ZXJMaXN0SXRlbXMnKTtcbiAgICAgICAgdmFyIGZpbHRlckxpc3QgPSBbXTtcbiAgICAgICAgZm9yICh2YXIgaXRlbSBvZiBsaXN0KSB7XG4gICAgICAgICAgICBjb25zdCBzeW1ib2xJbmZvID0gYXdhaXQgZ2V0U3ltYm9sSW5mbyhpdGVtLnN5bWJvbCk7XG4gICAgICAgICAgICBpZiAoc3ltYm9sSW5mbyA9PSBudWxsKSB7XG4gICAgICAgICAgICAgICAgY29udGludWU7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBpZiAoc3ltYm9sSW5mby5pc0hpZGRlblVwKSB7XG4gICAgICAgICAgICAgICAgY29udGludWU7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICB2YXIgZGV0YWlsSW5mbyA9IHt9O1xuICAgICAgICAgICAgZGV0YWlsSW5mby50eXBlID0gdHlwZS50b0ZpeGVkKDApLnRvU3RyaW5nKCk7XG4gICAgICAgICAgICBkZXRhaWxJbmZvLnN1YlR5cGUgPSBzdWJUeXBlO1xuICAgICAgICAgICAgZGV0YWlsSW5mby5pY29uVVJMID0gYXdhaXQgZ2V0SWNvblVSTChpdGVtLmJhc2VDdXJyZW5jeSk7XG4gICAgICAgICAgICBkZXRhaWxJbmZvLmljb25QbGFjZWhvbGRlciA9IGBAZHJhd2FibGUvJHtpY29uUGxhY2Vob2xkZXJ9YDtcblxuICAgICAgICAgICAgaWYgKGl0ZW0udGFnVXJsICE9IG51bGwgJiYgaXRlbS50YWdVcmwgIT09ICcnKSB7XG4gICAgICAgICAgICAgICAgZGV0YWlsSW5mby5mbGFnVVJMID0gaXRlbS50YWdVcmw7XG4gICAgICAgICAgICAgICAgZGV0YWlsSW5mby5mbGFnVmlld1Zpc2liaWxpdHkgPSBcInZpc2libGVcIjtcbiAgICAgICAgICAgICAgICBkZXRhaWxJbmZvLmlzWmVyb0ZlZSA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICAgICAgZGV0YWlsSW5mby5mbGFnVmlld1Zpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICAgICAgICAgICAgICB2YXIgdGFncyA9IGl0ZW0udGFncztcbiAgICAgICAgICAgICAgICBpZiAodGFncyAhPSBudWxsICYmIHRhZ3MubGVuZ3RoID4gMCkge1xuICAgICAgICAgICAgICAgICAgICBjb25zdCBpc1plcm9GZWUgPSB0YWdzLmluY2x1ZGVzKFwiemVyb2ZlZVwiKTtcbiAgICAgICAgICAgICAgICAgICAgZGV0YWlsSW5mby5pc1plcm9GZWUgPSBpc1plcm9GZWUgPyBcInZpc2libGVcIiA6IFwiZ29uZVwiO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICBlbHNlIHtcbiAgICAgICAgICAgICAgICAgICAgZGV0YWlsSW5mby5pc1plcm9GZWUgPSBcImdvbmVcIjtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICB9XG5cbiAgICAgICAgICAgIGRldGFpbEluZm8uc3ltYm9sID0gaXRlbS5zeW1ib2w7XG4gICAgICAgICAgICBkZXRhaWxJbmZvLmJhc2VOYW1lID0gc3ltYm9sSW5mby5iYXNlQ3VycmVuY3lEaXNwbGF5TmFtZTtcbiAgICAgICAgICAgIGlmICh0eXBlID09IDEgfHwgdHlwZSA9PSA2KSB7Ly8xOua2qOW5heamnCA277ya6LeM5bmF5qacXG4gICAgICAgICAgICAgICAgZGV0YWlsSW5mby5xdW90ZU5hbWUgPSBgLyR7c3ltYm9sSW5mby5xdW90ZUN1cnJlbmN5RGlzcGxheU5hbWV9YDtcbiAgICAgICAgICAgIH1cblxuICAgICAgICAgICAgaWYgKGl0ZW0ucHJpY2UgIT0gbnVsbCAmJiBpdGVtLnByaWNlICE9PSAnJykge1xuICAgICAgICAgICAgICAgIGRldGFpbEluZm8ucHJpY2UgPSBnZXRQcmljZVN0cmluZyhpdGVtLnByaWNlLCBzeW1ib2xJbmZvLnRyYWRlUHJpY2VQcmVjaXNpb24pO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICAgICAgZGV0YWlsSW5mby5wcmljZSA9IFwiLS1cIjtcbiAgICAgICAgICAgIH1cblxuXG5cbiAgICAgICAgICAgIGlmICh0eXBlID09IDEgfHwgdHlwZSA9PSA1IHx8IHR5cGUgPT0gNikgey8vMTrmtqjluYXmppwgNe+8mueDreamnCA277ya6LeM5bmF5qacXG4gICAgICAgICAgICAgICAgdmFyIHJhdGlvID0gMDtcbiAgICAgICAgICAgICAgICBpZiAoaXRlbS51cEFuZERvd24gIT0gbnVsbCAmJiBpdGVtLnVwQW5kRG93biAhPT0gJycpIHtcbiAgICAgICAgICAgICAgICAgICAgdmFyIHVwQW5kRG93biA9IHBhcnNlRmxvYXQoaXRlbS51cEFuZERvd24pO1xuICAgICAgICAgICAgICAgICAgICBpZiAoTWF0aC5hYnModXBBbmREb3duKSA+IDApIHtcbiAgICAgICAgICAgICAgICAgICAgICAgIHJhdGlvID0gdXBBbmREb3duICogMTAwO1xuICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIHZhciBwcmVmaXggPSByYXRpbyA+IDAgPyBcIitcIiA6IFwiXCI7XG4gICAgICAgICAgICAgICAgZGV0YWlsSW5mby5yYXRpbyA9IGAke3ByZWZpeH0ke3JhdGlvLnRvRml4ZWQoMikudG9TdHJpbmcoKX0lYDtcbiAgICAgICAgICAgICAgICBkZXRhaWxJbmZvLmNvbG9ySGV4ID0gZ2V0UHJpY2VDb2xvcihyYXRpbyk7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBlbHNlIGlmICh0eXBlID09IDIpIHsgLy8yOuaIkOS6pOmineamnFxuICAgICAgICAgICAgICAgIGlmIChpdGVtLnZvbHVtZSAhPSBudWxsICYmIGl0ZW0udm9sdW1lICE9PSAnJykge1xuICAgICAgICAgICAgICAgICAgICBkZXRhaWxJbmZvLnZvbHVtZSA9IGF3YWl0IGdldFZvbHVtZVN0cihpdGVtLnZvbHVtZSk7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICBkZXRhaWxJbmZvLnZvbHVtZSA9IFwiLS1cIjtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBlbHNlIGlmICh0eXBlID09IDEwKSB7IC8vMTA65biC5YC85qacLOa1geWKqOW4guWAvOWtl+auteWPluWAvOWQjO+8mnZvbHVtZVxuICAgICAgICAgICAgICAgIGlmIChpdGVtLnZvbHVtZSAhPSBudWxsICYmIGl0ZW0udm9sdW1lICE9PSAnJykge1xuICAgICAgICAgICAgICAgICAgICBkZXRhaWxJbmZvLnZvbHVtZSA9IGF3YWl0IGdldFZvbHVtZVN0cihpdGVtLnZvbHVtZSk7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICBkZXRhaWxJbmZvLnZvbHVtZSA9IFwiLS1cIjtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBlbHNlIGlmICh0eXBlID09IDQpIHsvLzQ65paw5biB5qacXG4gICAgICAgICAgICAgICAgaWYgKGxhdGVzdFVwQ29pblRpbWUgPT0gbnVsbCB8fCBsYXRlc3RVcENvaW5UaW1lIDwgaXRlbS5iZWdpblRyYWRlRGF0ZSkge1xuICAgICAgICAgICAgICAgICAgICBsYXRlc3RVcENvaW5UaW1lID0gaXRlbS5iZWdpblRyYWRlRGF0ZTtcbiAgICAgICAgICAgICAgICB9XG5cbiAgICAgICAgICAgICAgICBkZXRhaWxJbmZvLmJlZ2luRGF0ZSA9IGl0ZW0uYmVnaW5UcmFkZURhdGU7XG4gICAgICAgICAgICAgICAgY29uc3QgZGF0ZSA9IG5ldyBEYXRlKGl0ZW0uYmVnaW5UcmFkZURhdGUpO1xuICAgICAgICAgICAgICAgIGNvbnN0IHllYXIgPSBkYXRlLmdldEZ1bGxZZWFyKCk7XG4gICAgICAgICAgICAgICAgY29uc3QgbW9udGggPSBkYXRlLmdldE1vbnRoKCkgKyAxIDwgMTAgPyBgMCR7ZGF0ZS5nZXRNb250aCgpICsgMX1gIDogZGF0ZS5nZXRNb250aCgpICsgMTtcbiAgICAgICAgICAgICAgICBjb25zdCBkYXkgPSBkYXRlLmdldERhdGUoKSA8IDEwID8gYDAke2RhdGUuZ2V0RGF0ZSgpfWAgOiBkYXRlLmdldERhdGUoKTtcbiAgICAgICAgICAgICAgICBjb25zdCBob3VyID0gZGF0ZS5nZXRIb3VycygpIDwgMTAgPyBgMCR7ZGF0ZS5nZXRIb3VycygpfWAgOiBkYXRlLmdldEhvdXJzKCk7XG4gICAgICAgICAgICAgICAgY29uc3QgbWludXRlID0gZGF0ZS5nZXRNaW51dGVzKCkgPCAxMCA/IGAwJHtkYXRlLmdldE1pbnV0ZXMoKX1gIDogZGF0ZS5nZXRNaW51dGVzKCk7XG4gICAgICAgICAgICAgICAgaWYgKHN1YlR5cGUgPT0gXCJ0cmFkZWFibGVcIikge1xuICAgICAgICAgICAgICAgICAgICB2YXIgcmF0aW8gPSAwO1xuICAgICAgICAgICAgICAgICAgICBpZiAoTWF0aC5hYnMoaXRlbS5iZWdpblRyYWRlVXBBbmREb3duKSA+IDApIHtcbiAgICAgICAgICAgICAgICAgICAgICAgIHJhdGlvID0gaXRlbS5iZWdpblRyYWRlVXBBbmREb3duICogMTAwO1xuICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgICAgIHZhciBwcmVmaXggPSByYXRpbyA+IDAgPyBcIitcIiA6IFwiXCI7XG4gICAgICAgICAgICAgICAgICAgIGRldGFpbEluZm8ucmF0aW8gPSBgJHtwcmVmaXh9JHtyYXRpby50b0ZpeGVkKDIpLnRvU3RyaW5nKCl9JWA7XG4gICAgICAgICAgICAgICAgICAgIGRldGFpbEluZm8uY29sb3JIZXggPSBnZXRQcmljZUNvbG9yKHJhdGlvKTtcblxuICAgICAgICAgICAgICAgICAgICBjb25zdCBmb3JtYXR0ZWREYXRlID0gYCR7eWVhcn0tJHttb250aH0tJHtkYXl9YDtcbiAgICAgICAgICAgICAgICAgICAgZGV0YWlsSW5mby5iZWdpbkRhdGVTdHIgPSBmb3JtYXR0ZWREYXRlO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICBlbHNlIGlmIChzdWJUeXBlID09IFwidW50cmFkZWFibGVcIikge1xuICAgICAgICAgICAgICAgICAgICBjb25zdCBmb3JtYXR0ZWREYXRlID0gYCR7bW9udGh9LSR7ZGF5fSAke2hvdXJ9OiR7bWludXRlfWA7XG4gICAgICAgICAgICAgICAgICAgIGRldGFpbEluZm8uYmVnaW5EYXRlU3RyID0gZm9ybWF0dGVkRGF0ZTtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBmaWx0ZXJMaXN0LnB1c2goZGV0YWlsSW5mbyk7XG4gICAgICAgIH1cbiAgICAgICAgcmV0dXJuIGZpbHRlckxpc3Q7XG4gICAgfVxuXG4gICAgLy/lpITnkIbmjqXlj6PmlbDmja5cbiAgICBhc3luYyBmdW5jdGlvbiBoYW5kbGVSYW5raW5nTGlzdERhdGEoZGF0YSkge1xuICAgICAgICBjb25zb2xlLmxvZygnaGFuZGxlUmFua2luZ0xpc3REYXRhJyk7XG5cbiAgICAgICAgY29uc3QgZmlsdGVyTGlzdERhdGEgPSBkYXRhLmZpbHRlcigoaXRlbSkgPT4ge1xuICAgICAgICAgICAgcmV0dXJuIGl0ZW0udHlwZSA9PSAxIHx8IGl0ZW0udHlwZSA9PSAyIHx8IGl0ZW0udHlwZSA9PSA0IHx8IGl0ZW0udHlwZSA9PSA1IHx8IGl0ZW0udHlwZSA9PSA2IHx8IGl0ZW0udHlwZSA9PSAxMDtcbiAgICAgICAgfSk7XG5cbiAgICAgICAgdmFyIHRpdGxlRGF0YSA9IGZpbHRlckxpc3REYXRhLm1hcCgoaXRlbSkgPT4ge1xuICAgICAgICAgICAgcmV0dXJuIHtcbiAgICAgICAgICAgICAgICB0eXBlOiBpdGVtLnR5cGUsXG4gICAgICAgICAgICAgICAgdGl0bGU6IGl0ZW0udHlwZVRpdGxlXG4gICAgICAgICAgICB9O1xuICAgICAgICB9KTtcblxuICAgICAgICBjb25zdCBsaXN0ID0gYXdhaXQgUHJvbWlzZS5hbGwoZmlsdGVyTGlzdERhdGEubWFwKGFzeW5jIChpdGVtKSA9PiB7XG4gICAgICAgICAgICB2YXIgZGF0YU1hcCA9IHt9O1xuICAgICAgICAgICAgZGF0YU1hcC5pc1NpbmdsZUxpc3QgPSAhaXRlbS5zY3JlZW47XG4gICAgICAgICAgICBkYXRhTWFwLnR5cGUgPSBpdGVtLnR5cGU7XG4gICAgICAgICAgICB2YXIgc2VjdGlvbkxpc3QgPSBbXTtcbiAgICAgICAgICAgIGlmICghaXRlbS5zY3JlZW4pIHsvL+WNleaVsOe7hFxuICAgICAgICAgICAgICAgIHZhciBzZWN0aW9uSXRlbSA9IHt9O1xuICAgICAgICAgICAgICAgIHNlY3Rpb25JdGVtLnR5cGUgPSBpdGVtLnR5cGU7XG4gICAgICAgICAgICAgICAgLy/pobbpg6jmoIfpophcbiAgICAgICAgICAgICAgICB2YXIgdGl0bGVzID0gaXRlbS50aXRsZTtcblxuICAgICAgICAgICAgICAgIHNlY3Rpb25JdGVtLnNlY3Rpb25IZWFkZXIgPSBzZWN0aW9uSGVhZGVyRnJvbSh0aXRsZXMpO1xuICAgICAgICAgICAgICAgIC8v5aSE55CG5pWw5o2uXG4gICAgICAgICAgICAgICAgc2VjdGlvbkl0ZW0uZGF0YSA9IGF3YWl0IGZpbHRlckxpc3RJdGVtcyhpdGVtLnR5cGUsIG51bGwsIGl0ZW0uc2luZ2xlTGlzdCk7XG4gICAgICAgICAgICAgICAgc2VjdGlvbkxpc3QucHVzaChzZWN0aW9uSXRlbSk7XG4gICAgICAgICAgICAgICAgZGF0YU1hcC5zZWN0aW9uSXRlbSA9IHNlY3Rpb25JdGVtO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICAgICAgZm9yICh2YXIgc2NyZWVuT2JqZWN0IG9mIGl0ZW0uc2NyZWVuTGlzdE9iamVjdCkge1xuICAgICAgICAgICAgICAgICAgICB2YXIgc2VjdGlvbkl0ZW0gPSB7fTtcbiAgICAgICAgICAgICAgICAgICAgc2VjdGlvbkl0ZW0udHlwZSA9IGl0ZW0udHlwZTtcbiAgICAgICAgICAgICAgICAgICAgY29uc3Qgc3ViVHlwZSA9IHNjcmVlbk9iamVjdC5zY3JlZW5WYWx1ZTtcbiAgICAgICAgICAgICAgICAgICAgc2VjdGlvbkl0ZW0uc3ViVHlwZSA9IHN1YlR5cGU7XG4gICAgICAgICAgICAgICAgICAgIC8v6aG26YOo5qCH6aKYXG4gICAgICAgICAgICAgICAgICAgIGNvbnN0IHRpdGxlcyA9IGl0ZW0udGl0bGVNYXBbc3ViVHlwZV07XG4gICAgICAgICAgICAgICAgICAgIHNlY3Rpb25JdGVtLnNlY3Rpb25IZWFkZXIgPSBzZWN0aW9uSGVhZGVyRnJvbSh0aXRsZXMpO1xuXG4gICAgICAgICAgICAgICAgICAgIHZhciBpdGVtTGlzdCA9IGl0ZW0ubXVsdGlwbGVNYXBbc3ViVHlwZV07XG4gICAgICAgICAgICAgICAgICAgIC8v5aSE55CG5pWw5o2uXG4gICAgICAgICAgICAgICAgICAgIHNlY3Rpb25JdGVtLmRhdGEgPSBhd2FpdCBmaWx0ZXJMaXN0SXRlbXMoaXRlbS50eXBlLCBzdWJUeXBlLCBpdGVtTGlzdCk7XG4gICAgICAgICAgICAgICAgICAgIHNlY3Rpb25MaXN0LnB1c2goc2VjdGlvbkl0ZW0pO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGRhdGFNYXAuc2VjdGlvbkxpc3QgPSBzZWN0aW9uTGlzdDtcbiAgICAgICAgICAgIHJldHVybiBkYXRhTWFwO1xuICAgICAgICB9KSk7XG5cbiAgICAgICAgdmFyIGxpc3REYXRhID0ge307XG4gICAgICAgIGZvciAoY29uc3QgbGlzdEl0ZW0gb2YgbGlzdCkge1xuICAgICAgICAgICAgbGlzdERhdGFbbGlzdEl0ZW0udHlwZS50b0ZpeGVkKDApLnRvU3RyaW5nKCldID0gbGlzdEl0ZW07XG4gICAgICAgICAgICByZXNldFR5cGVMaXN0RGF0YShsaXN0SXRlbSk7XG5cbiAgICAgICAgICAgIGlmIChsaXN0SXRlbS50eXBlID09IDQgJiYgY3VycmVudFR5cGUgPT0gNCAmJiBsYXRlc3RVcENvaW5UaW1lICE9IG51bGwpIHtcbiAgICAgICAgICAgICAgICBjb25zdCBsYXRlc3RVcENhY2hlID0gYXdhaXQgcmVhZChcInJhbmtpbmdcIiwgXCJsYXRlc3RVcFwiKVxuICAgICAgICAgICAgICAgIGlmIChsYXRlc3RVcENvaW5UaW1lID4gbGF0ZXN0VXBDYWNoZSkge1xuICAgICAgICAgICAgICAgICAgICBhd2FpdCBzYXZlKFwicmFua2luZ1wiLCBcImxhdGVzdFVwXCIsIFN0cmluZyhsYXRlc3RVcENvaW5UaW1lKSk7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgfVxuICAgICAgICB9XG5cbiAgICAgICAgY2FjaGVUaXRsZURhdGEgPSB0aXRsZURhdGE7XG4gICAgICAgIGNhY2hlTGlzdERhdGEgPSBsaXN0RGF0YTtcbiAgICAgICAgJGRhdGEudGl0bGVEYXRhID0gdGl0bGVEYXRhO1xuICAgICAgICAkZGF0YS5saXN0RGF0YSA9IGxpc3REYXRhO1xuICAgICAgICBhd2FpdCBzZXRSYW5raW5nRGF0YShjYWNoZVRpdGxlRGF0YSwgY2FjaGVMaXN0RGF0YSk7XG4gICAgICAgIGxhc3RSZXF1ZXN0VGltZSA9IG5ldyBEYXRlKCkuZ2V0VGltZSgpO1xuICAgICAgICAvLyBzZXRUaW1lb3V0KGZ1bmN0aW9uICgpIHtcbiAgICAgICAgLy8gICAgIGNvbnNvbGUubG9nKCdzZXRUaW1lb3V0Jyk7XG4gICAgICAgIC8vIH0sNSk7XG4gICAgfVxuXG4gICAgLy/lpITnkIbluIHlr7nku7fmoLzkv6Hmga9cbiAgICBhc3luYyBmdW5jdGlvbiB1cGRhdGVSYW5raW5nRGF0YVByaWNlKHByaWNlRGF0YSkge1xuICAgICAgICAvLyBjb25zb2xlLmxvZygndXBkYXRlUmFua2luZ0RhdGFQcmljZScpO1xuICAgICAgICBpZiAoY2FjaGVMaXN0RGF0YSA9PSBudWxsKSB7XG4gICAgICAgICAgICByZXR1cm47XG4gICAgICAgIH1cbiAgICAgICAgdmFyIGxpc3REYXRhVmFsdWUgPSBPYmplY3QudmFsdWVzKGNhY2hlTGlzdERhdGEpO1xuICAgICAgICBmb3IgKHZhciBpdGVtIG9mIGxpc3REYXRhVmFsdWUpIHtcbiAgICAgICAgICAgIGZvciAodmFyIHNlY3Rpb25JdGVtIG9mIGl0ZW0uc2VjdGlvbkxpc3QpIHtcbiAgICAgICAgICAgICAgICBmb3IgKHZhciBkZXRhaWxJbmZvIG9mIHNlY3Rpb25JdGVtLmRhdGEpIHtcbiAgICAgICAgICAgICAgICAgICAgY29uc3Qgc3ltYm9sSW5mbyA9IGF3YWl0IGdldFN5bWJvbEluZm8oZGV0YWlsSW5mby5zeW1ib2wpO1xuICAgICAgICAgICAgICAgICAgICBjb25zdCBjb2luRGljdCA9IHByaWNlRGF0YVtkZXRhaWxJbmZvLnN5bWJvbF07XG4gICAgICAgICAgICAgICAgICAgIGlmIChjb2luRGljdCA9PSBudWxsKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICBjb250aW51ZTtcbiAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgICAgICB2YXIgcHJpY2UgPSBjb2luRGljdC5kZWNpbWFsY1ByaWNlO1xuICAgICAgICAgICAgICAgICAgICB0eXBlID0gcGFyc2VJbnQoZGV0YWlsSW5mby50eXBlKTtcbiAgICAgICAgICAgICAgICAgICAgaWYgKHByaWNlID4gMCkge1xuICAgICAgICAgICAgICAgICAgICAgICAgZGV0YWlsSW5mby5wcmljZSA9IGdldFByaWNlU3RyaW5nKHByaWNlLnRvU3RyaW5nKCksIHN5bWJvbEluZm8udHJhZGVQcmljZVByZWNpc2lvbik7XG4gICAgICAgICAgICAgICAgICAgIH1cblxuICAgICAgICAgICAgICAgICAgICBpZiAodHlwZSA9PSAxIHx8IHR5cGUgPT0gNSB8fCB0eXBlID09IDYpIHsvLzE65rao5bmF5qacIDXvvJrng63mppwgNu+8mui3jOW5heamnFxuICAgICAgICAgICAgICAgICAgICAgICAgdmFyIHJhdGlvID0gMDtcbiAgICAgICAgICAgICAgICAgICAgICAgIGlmIChNYXRoLmFicyhjb2luRGljdC5kZWNpbWFsRGVsdGEpID49IDApIHtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICByYXRpbyA9IGNvaW5EaWN0LmRlY2ltYWxEZWx0YTtcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICB2YXIgcHJlZml4ID0gcmF0aW8gPiAwID8gXCIrXCIgOiBcIlwiO1xuICAgICAgICAgICAgICAgICAgICAgICAgICAgIGRldGFpbEluZm8ucmF0aW8gPSBgJHtwcmVmaXh9JHtyYXRpby50b0ZpeGVkKDIpLnRvU3RyaW5nKCl9JWA7XG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgZGV0YWlsSW5mby5jb2xvckhleCA9IGdldFByaWNlQ29sb3IocmF0aW8pO1xuICAgICAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgfVxuICAgICAgICAgICAgaWYgKGl0ZW0uaXNTaW5nbGVMaXN0ID09IHRydWUpIHtcbiAgICAgICAgICAgICAgICBpdGVtLnNlY3Rpb25JdGVtID0gaXRlbS5zZWN0aW9uTGlzdFswXTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIHJlc2V0VHlwZUxpc3REYXRhKGl0ZW0pO1xuICAgICAgICB9XG4gICAgICAgIGF3YWl0IHNldFJhbmtpbmdEYXRhKGNhY2hlVGl0bGVEYXRhLCBjYWNoZUxpc3REYXRhKTtcbiAgICB9XG5cbiAgICAvL+WPkemAgeivt+axglxuICAgIGZ1bmN0aW9uIHNlbmRSZXF1ZXN0KHBhdGgsIHBhcmFtcyA9IFwiXCIsIG1ldGhvZCA9IDAsIGhvc3RUeXBlID0gMCwgaGVhZGVyID0gXCJcIikge1xuICAgICAgICBjb25zb2xlLmxvZygnc2VuZFJlcXVlc3QnKTtcbiAgICAgICAgY29uc3QgcGFyYW0gPSB7XG4gICAgICAgICAgICBwYXRoLFxuICAgICAgICAgICAgbWV0aG9kLFxuICAgICAgICAgICAgaG9zdFR5cGUsXG4gICAgICAgICAgICBoZWFkZXIsXG4gICAgICAgICAgICBwYXJhbXNcbiAgICAgICAgfTtcbiAgICAgICAgcmV0dXJuIEpTT04uc3RyaW5naWZ5KHBhcmFtKTtcbiAgICB9XG5cbiAgICAvL+ivt+axguaOkuihjOamnOaOpeWPo1xuICAgIGFzeW5jIGZ1bmN0aW9uIHJlcXVlc3RSYW5raW5nTGlzdCgpIHtcbiAgICAgICAgY29uc29sZS5sb2coJ3JlcXVlc3QgYWxsUmFua2luZ0xpc3QnKTtcbiAgICAgICAgY29uc3QgcmVxdWVzdFBhcmFtcyA9IHNlbmRSZXF1ZXN0KCd2MS9hcHAvbmV3L2FsbFJhbmtpbmdMaXN0Jyk7XG4gICAgICAgIHRyeSB7XG4gICAgICAgICAgICBjb25zdCByZXNwb25zZVN0cmluZyA9IGF3YWl0ICRuYXRpdmVBUEkucmVxdWVzdChyZXF1ZXN0UGFyYW1zKTtcbiAgICAgICAgICAgIGNvbnN0IHJlc3BvbnNlID0gSlNPTi5wYXJzZShyZXNwb25zZVN0cmluZyk7XG4gICAgICAgICAgICBjb25zdCB7IGNvZGUsIGRhdGEgfSA9IHJlc3BvbnNlO1xuICAgICAgICAgICAgaWYgKGNvZGUgPT0gMjAwKSB7XG4gICAgICAgICAgICAgICAgYXdhaXQgaGFuZGxlUmFua2luZ0xpc3REYXRhKGRhdGEpO1xuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICBhd2FpdCBzZXRSYW5raW5nUmVxdWVzdEVycm9yKGByZXF1ZXN0IGZhaWxlZCwgY29kZT0ke2NvZGV9YCk7XG4gICAgICAgICAgICB9XG4gICAgICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgICAgIGF3YWl0IHNldFJhbmtpbmdSZXF1ZXN0RXJyb3IoYHJlcXVlc3QgZXJyb3IsIGVycm9yPSR7ZX1gKTtcbiAgICAgICAgfVxuICAgIH1cblxuICAgIC8v6K6+572u5biB5a+55Lu35qC85L+h5oGvXG4gICAgYXN5bmMgZnVuY3Rpb24gc2VuZFNvY2tldERhdGEoc29ja2V0RGF0YSkge1xuICAgICAgICBjb25zb2xlLmxvZygnc2VuZFNvY2tldERhdGEnKTtcbiAgICAgICAgdmFyIHByaWNlRGF0YSA9IHNvY2tldERhdGE7XG4gICAgICAgIGF3YWl0IHVwZGF0ZVJhbmtpbmdEYXRhUHJpY2UocHJpY2VEYXRhKTtcbiAgICB9XG5cbiAgICBhc3luYyBmdW5jdGlvbiBkaXNwbGF5TGlzdChwYXJhbSkge1xuICAgICAgICBjdXJyZW50VHlwZSA9IHBhcnNlSW50KHBhcmFtLnR5cGUpO1xuICAgICAgICBpZiAoY3VycmVudFR5cGUgPT0gNCkge1xuICAgICAgICAgICAgaWYgKGxhdGVzdFVwQ29pblRpbWUgIT0gbnVsbCkge1xuICAgICAgICAgICAgICAgIGNvbnN0IGxhdGVzdFVwQ2FjaGUgPSBhd2FpdCByZWFkKFwicmFua2luZ1wiLCBcImxhdGVzdFVwXCIpXG4gICAgICAgICAgICAgICAgaWYgKGxhdGVzdFVwQ29pblRpbWUgPiBsYXRlc3RVcENhY2hlKSB7XG4gICAgICAgICAgICAgICAgICAgIGF3YWl0IHNhdmUoXCJyYW5raW5nXCIsIFwibGF0ZXN0VXBcIiwgU3RyaW5nKGxhdGVzdFVwQ29pblRpbWUpKTtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICB9XG5cbiAgICBmdW5jdGlvbiBzdGFydFRpbWVyKCkge1xuICAgICAgICBpZiAodGltZXJPYmplY3QgPT0gbnVsbCkge1xuICAgICAgICAgICAgdGltZXJPYmplY3QgPSBzZXRJbnRlcnZhbCh0aW1lciwgMTAwMCk7XG4gICAgICAgIH1cbiAgICB9XG5cbiAgICBmdW5jdGlvbiBzdG9wVGltZXIoKSB7XG4gICAgICAgIGlmICh0aW1lck9iamVjdCkge1xuICAgICAgICAgICAgY2xlYXJJbnRlcnZhbCh0aW1lck9iamVjdCk7XG4gICAgICAgICAgICB0aW1lck9iamVjdCA9IG51bGw7XG4gICAgICAgIH1cbiAgICB9XG5cbiAgICBhc3luYyBmdW5jdGlvbiB0aW1lcigpIHtcbiAgICAgICAgY29uc3QgY3VycmVudFRpbWUgPSBuZXcgRGF0ZSgpLmdldFRpbWUoKTtcbiAgICAgICAgLy8gNjDnp5LliLfmlrDkuIDmrKFcbiAgICAgICAgaWYgKGN1cnJlbnRUaW1lIC0gbGFzdFJlcXVlc3RUaW1lID4gNjAgKiAxMDAwKSB7XG4gICAgICAgICAgICBhd2FpdCByZXF1ZXN0UmFua2luZ0xpc3QoKTtcbiAgICAgICAgfVxuICAgIH1cblxuICAgIGZ1bmN0aW9uIHNlbmRSYW5raW5nWG1sQ29uZmlnKCkge1xuICAgICAgICB2YXIgZGljdCA9IHtcbiAgICAgICAgICAgIFwiMVwiOiBcInVwX3JhbmtpbmdfbGlzdFwiLFxuICAgICAgICAgICAgXCIyXCI6IFwidm9sdW1lX3JhbmtpbmdfbGlzdFwiLFxuICAgICAgICAgICAgXCI1XCI6IFwiaG90X3JhbmtpbmdfbGlzdFwiLFxuICAgICAgICAgICAgXCI2XCI6IFwiZG93bl9yYW5raW5nX2xpc3RcIixcbiAgICAgICAgICAgIFwiMTBcIjogXCJtYXJrZXRfY2FwX3JhbmtpbmdfbGlzdFwiLFxuICAgICAgICB9O1xuICAgICAgICBjb25zb2xlLmxvZyhgcmFua2luZ1htbENvbmZpZz09JHtKU09OLnN0cmluZ2lmeShkaWN0KX1gKTtcbiAgICAgICAgcmFua2luZ1htbE5hbWVDb25maWcgPSBKU09OLnN0cmluZ2lmeShkaWN0KTtcbiAgICAgICAgJGRhdGEucmFua2luZ1htbENvbmZpZyA9IHJhbmtpbmdYbWxOYW1lQ29uZmlnO1xuICAgIH1cblxuICAgICRldmVudC5yZXF1ZXN0UmFua2luZ0xpc3QgPSByZXF1ZXN0UmFua2luZ0xpc3Q7XG4gICAgJGV2ZW50LnNlbmRTb2NrZXREYXRhID0gc2VuZFNvY2tldERhdGE7XG4gICAgJGV2ZW50LmdvVG9LTGluZSA9IGdvVG9LTGluZTtcbiAgICAkZXZlbnQuZGlzcGxheUxpc3QgPSBkaXNwbGF5TGlzdDtcbiAgICAkZXZlbnQuc3RhcnRUaW1lciA9IHN0YXJ0VGltZXI7XG4gICAgJGV2ZW50LnN0b3BUaW1lciA9IHN0b3BUaW1lcjtcblxuICAgIHNlbmRSYW5raW5nWG1sQ29uZmlnKCk7XG4gICAgYXdhaXQgcmVxdWVzdFJhbmtpbmdMaXN0KCk7XG59XG4pKClcblxuIl0sIm5hbWVzIjpbIkRQIiwiUk0iLCJNQVhfRFAiLCJNQVhfUE9XRVIiLCJORSIsIlBFIiwiTkFNRSIsIklOVkFMSUQiLCJJTlZBTElEX0RQIiwiSU5WQUxJRF9STSIsIkRJVl9CWV9aRVJPIiwiUCIsIlVOREVGSU5FRCIsIk5VTUVSSUMiLCJfQmlnXyIsIkJpZyIsIm4iLCJ4IiwidGhpcyIsInMiLCJlIiwiYyIsInNsaWNlIiwicGFyc2UiLCJjb25zdHJ1Y3RvciIsInByb3RvdHlwZSIsInZlcnNpb24iLCJpIiwibmwiLCJ0ZXN0IiwiRXJyb3IiLCJjaGFyQXQiLCJpbmRleE9mIiwicmVwbGFjZSIsInNlYXJjaCIsInN1YnN0cmluZyIsImxlbmd0aCIsInJvdW5kIiwiZHAiLCJybSIsIm1vcmUiLCJ4YyIsInVuc2hpZnQiLCJwb3AiLCJzdHJpbmdpZnkiLCJpZCIsImsiLCJ6IiwicHVzaCIsImpvaW4iLCJhYnMiLCJjbXAiLCJ5IiwiaXNuZWciLCJ5YyIsImoiLCJsIiwiZGl2IiwiYSIsImIiLCJibCIsImJ0IiwicmkiLCJieiIsImFpIiwiYWwiLCJyIiwicmwiLCJxIiwicWMiLCJxaSIsImQiLCJzaGlmdCIsImVxIiwiZ3QiLCJndGUiLCJsdCIsImx0ZSIsIm1pbnVzIiwic3ViIiwidCIsInhsdHkiLCJwbHVzIiwieGUiLCJ5ZSIsInJldmVyc2UiLCJtb2QiLCJ5Z3R4IiwidGltZXMiLCJhZGQiLCJwb3ciLCJvbmUiLCJzcXJ0IiwiaGFsZiIsIk1hdGgiLCJ0b0V4cG9uZW50aWFsIiwibXVsIiwiQXJyYXkiLCJ0b0ZpeGVkIiwidG9QcmVjaXNpb24iLCJzZCIsInRvU3RyaW5nIiwidmFsdWVPZiIsInRvSlNPTiIsInJlZENvbG9yTGlzdCIsImdyZWVuQ29sb3JMaXN0IiwidXBDb2xvckxpc3QiLCJkb3duQ29sb3JMaXN0IiwiY2FjaGVDb2xvclR5cGUiLCIkbmF0aXZlQVBJIiwicmFua2luZ0JyaWRnZSIsImFjdGlvbiIsInBhcnNlSW50Iiwic3ltYm9sSW5mb01hcEpzb25TdHJpbmciLCJzeW1ib2xJbmZvTWFwIiwiSlNPTiIsImljb25VUkxIb3N0IiwiaWNvblBsYWNlaG9sZGVyIiwicmF0ZVR5cGVTdHIiLCJjYWNoZVRpdGxlRGF0YSIsImNhY2hlTGlzdERhdGEiLCJjdXJyZW50VHlwZSIsImxhdGVzdFVwQ29pblRpbWUiLCJ0aW1lck9iamVjdCIsImxhc3RSZXF1ZXN0VGltZSIsInJhbmtpbmdYbWxOYW1lQ29uZmlnIiwiYXN5bmMiLCJzYXZlIiwibW9kdWxlIiwia2V5IiwiZGF0YSIsInN0b3JhZ2UiLCJuYW1lIiwicmVhZCIsImdvVG9LTGluZSIsInN5bWJvbCIsImNvbnNvbGUiLCJsb2ciLCJzZXRSYW5raW5nRGF0YSIsInRpdGxlRGF0YSIsImxpc3REYXRhIiwic3RhdHVzRGF0YSIsIk9iamVjdCIsImtleXMiLCJmb3JFYWNoIiwiaGFzRGF0YSIsInNlY3Rpb25JdGVtIiwic2VjdGlvbkxpc3QiLCJsaXN0IiwiY2FsbGJhY2tEYXRhIiwicmFua2luZ1htbENvbmZpZyIsImRhdGFKc29uIiwiJGRhdGEiLCJyYW5raW5nRGF0YSIsInNldFJhbmtpbmdSZXF1ZXN0RXJyb3IiLCJlcnJvck1zZyIsImdldFN5bWJvbEluZm8iLCJzeW1ib2xJbmZvIiwic3ltYm9sSW5mb1N0ciIsImdldEljb25VUkwiLCJjdXJyZW5jeSIsImljb25VUkwiLCJnZXRWb2x1bWVTdHIiLCJ2b2x1bWUiLCJ2b2x1bWVTdHIiLCJnZXRQcmljZUNvbG9yIiwicmF0aW8iLCJyYXRpb19hYnMiLCJjb2xvckxldmVsIiwiY29sb3JIZXhTdHIiLCJnZXRQcmljZVN0cmluZyIsInByaWNlU3RyIiwicHJlY2lzaW9uIiwicHJpY2VOdW0iLCJOdW1iZXIiLCJiaWdWYWx1ZSIsInByaWNlU3RyaW5nIiwibm90YXRpb24iLCJmaW5hbFByaWNlU3RyIiwic2VjdGlvbkhlYWRlckZyb20iLCJ0aXRsZXMiLCJzZWN0aW9uSGVhZGVyIiwibGVmdFRpdGxlIiwibWlkZGxlVGl0bGUiLCJyaWdodFRpdGxlIiwic2VjdGlvblRpdGxlcyIsInRpdGxlIiwidGl0bGVOYW1lIiwicmVzZXRUeXBlTGlzdERhdGEiLCJpdGVtIiwidHlwZSIsInVwTGlzdERhdGEiLCJ2b2x1bWVMaXN0RGF0YSIsImhvdExpc3REYXRhIiwiZG93bkxpc3REYXRhIiwibmV3SXRlbSIsInN1YlR5cGUiLCJuZXdMaXN0RGF0YSIsIndpbGxMaXN0RGF0YSIsIm1hcmtldENhcExpc3REYXRhIiwiZmlsdGVyTGlzdEl0ZW1zIiwiZmlsdGVyTGlzdCIsImlzSGlkZGVuVXAiLCJkZXRhaWxJbmZvIiwiYmFzZUN1cnJlbmN5IiwidGFnVXJsIiwiZmxhZ1VSTCIsImZsYWdWaWV3VmlzaWJpbGl0eSIsImlzWmVyb0ZlZSIsInRhZ3MiLCJpbmNsdWRlcyIsImJhc2VOYW1lIiwiYmFzZUN1cnJlbmN5RGlzcGxheU5hbWUiLCJxdW90ZU5hbWUiLCJxdW90ZUN1cnJlbmN5RGlzcGxheU5hbWUiLCJwcmljZSIsInRyYWRlUHJpY2VQcmVjaXNpb24iLCJ1cEFuZERvd24iLCJwYXJzZUZsb2F0IiwicHJlZml4IiwiY29sb3JIZXgiLCJiZWdpblRyYWRlRGF0ZSIsImJlZ2luRGF0ZSIsImRhdGUiLCJEYXRlIiwieWVhciIsImdldEZ1bGxZZWFyIiwibW9udGgiLCJnZXRNb250aCIsImRheSIsImdldERhdGUiLCJob3VyIiwiZ2V0SG91cnMiLCJtaW51dGUiLCJnZXRNaW51dGVzIiwiYmVnaW5UcmFkZVVwQW5kRG93biIsImZvcm1hdHRlZERhdGUiLCJiZWdpbkRhdGVTdHIiLCJoYW5kbGVSYW5raW5nTGlzdERhdGEiLCJmaWx0ZXJMaXN0RGF0YSIsImZpbHRlciIsIm1hcCIsInR5cGVUaXRsZSIsIlByb21pc2UiLCJhbGwiLCJkYXRhTWFwIiwiaXNTaW5nbGVMaXN0Iiwic2NyZWVuIiwic2luZ2xlTGlzdCIsInNjcmVlbk9iamVjdCIsInNjcmVlbkxpc3RPYmplY3QiLCJzY3JlZW5WYWx1ZSIsInRpdGxlTWFwIiwiaXRlbUxpc3QiLCJtdWx0aXBsZU1hcCIsImxpc3RJdGVtIiwibGF0ZXN0VXBDYWNoZSIsIlN0cmluZyIsImdldFRpbWUiLCJ1cGRhdGVSYW5raW5nRGF0YVByaWNlIiwicHJpY2VEYXRhIiwibGlzdERhdGFWYWx1ZSIsInZhbHVlcyIsImNvaW5EaWN0IiwiZGVjaW1hbGNQcmljZSIsImRlY2ltYWxEZWx0YSIsInNlbmRSZXF1ZXN0IiwicGF0aCIsInBhcmFtcyIsIm1ldGhvZCIsImhvc3RUeXBlIiwiaGVhZGVyIiwicGFyYW0iLCJyZXF1ZXN0UmFua2luZ0xpc3QiLCJyZXF1ZXN0UGFyYW1zIiwicmVzcG9uc2VTdHJpbmciLCJyZXF1ZXN0IiwicmVzcG9uc2UiLCJjb2RlIiwic2VuZFNvY2tldERhdGEiLCJzb2NrZXREYXRhIiwiZGlzcGxheUxpc3QiLCJzdGFydFRpbWVyIiwic2V0SW50ZXJ2YWwiLCJ0aW1lciIsInN0b3BUaW1lciIsImNsZWFySW50ZXJ2YWwiLCJjdXJyZW50VGltZSIsInNlbmRSYW5raW5nWG1sQ29uZmlnIiwiZGljdCIsIiRldmVudCJdLCJtYXBwaW5ncyI6IkFBaUJBLElBQUlBLEtBQUssSUFVUEMsS0FBSyxHQUdMQyxTQUFTLEtBR1RDLFlBQVksS0FPWkMsTUFBTSxHQVFOQyxLQUFLLElBT0xDLE9BQU8sYUFDUEMsVUFBVUQsT0FBTyxZQUNqQkUsYUFBYUQsVUFBVSxrQkFDdkJFLGFBQWFGLFVBQVUsaUJBQ3ZCRyxjQUFjSixPQUFPLG9CQUdyQkssSUFBSSxDQUFFLEdBQ05DLGlCQUFpQixHQUNqQkMsVUFBVTs7QUFPWixTQUFTQztJQVFQLFNBQVNDLElBQUlDO1FBQ1gsSUFBSUMsSUFBSUM7UUFHUixNQUFNRCxhQUFhRixNQUFNLE9BQU9DLE1BQU1KLFlBQVlFLFVBQVUsSUFBSUMsSUFBSUM7UUFHcEUsSUFBSUEsYUFBYUQsS0FBSztZQUNwQkUsRUFBRUUsSUFBSUgsRUFBRUc7WUFDUkYsRUFBRUcsSUFBSUosRUFBRUk7WUFDUkgsRUFBRUksSUFBSUwsRUFBRUssRUFBRUM7QUFDaEIsZUFBVztZQUNMQyxNQUFNTixHQUFHRDtBQUNWO1FBTURDLEVBQUVPLGNBQWNUO0FBQ2pCO0lBRURBLElBQUlVLFlBQVlkO0lBQ2hCSSxJQUFJZixLQUFLQTtJQUNUZSxJQUFJZCxLQUFLQTtJQUNUYyxJQUFJWCxLQUFL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
