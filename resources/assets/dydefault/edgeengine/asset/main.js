var isHidden = true;

var currentDistributionType = "0";

var usdtMAll = true;

var coinPAll = true;

var coinMAll = true;

var isContractOpenConfig = false;

var availables = [];

var clickable = true;

var endTime = 0;

var autoEarnGuideShow = false;

var todayProfitState = 0;

var clickedStrategyId = "";

var exchangeEnable = false;

var exchangeJumpUrl = "";

var commonData = {
    webUrl: "",
    language: ""
};

var currencyUpdateData = {
    upDetailCurrency: "",
    upgradeCurrency: "",
    upgradeJumpUrl: "",
    upgradeDetailUrl: "",
    upgradeState: false
};

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

async function syncCurrencyUpdateConfig() {
    const tmpData = await read("global", "currencyUpdateData");
    if (tmpData !== null) {
        currencyUpdateData = tmpData;
    }
    if (currencyUpdateData.upgradeState === true) {
        $data.asset_small_coin_title = await getWord("asset_small_coin_to_htx");
    } else {
        $data.asset_small_coin_title = await getWord("asset_small_coin_to_ht");
    }
}

async function sendCommonConfig(param) {
    console.log(`wp sendCommonConfig language ${param.language} webUrl ${param.webUrl} colorMode ${param.colorMode}`);
    commonData.language = param.language;
    commonData.webUrl = param.webUrl;
    commonData.colorMode = param.colorMode;
    commonData.OS = param.OS;
    $data.upgradeBgColor = commonData.colorMode == 0 ? "#D9F7E4" : "#1D342E";
}

function toggleShowAsset() {
    isHidden = !isHidden;
    console.log(`toggleShowAsset ${isHidden}`);
    if (isHidden) {
        hiddenAllAsset();
    } else {
        showAllAsset();
    }
    $nativeAPI.currencyCommon('{"type":14}');
}

function restrictionPop() {
    $nativeAPI.jump(JSON.stringify({
        type: 166
    }));
}

function shareAsset() {
    var share = {};
    share.type = 15;
    share.rate = cacheData.balance.todayProfitRate ? cacheData.balance.todayProfitRate : 0;
    console.log(share.rate);
    $nativeAPI.currencyCommon(JSON.stringify(share));
}

function jump(type, index, childType) {
    var params = {
        type: type
    };
    var analysisParams = {
        track: "",
        properties: {}
    };
    console.log(`jump ${type} ${index} ${childType}`);
    try {
        switch (type) {
          case 9:
            const item158 = cacheData.spot.spot.newList[index];
            params.type = 158;
            params.currency = item158.currency;
            params.stable = item158 ? checkField(item158.stable, false) : false;
            break;

          case 8:
          case 10:
            const item = cacheData.spot.spot.newList[index];
            params.currency = item.currency;
            params.stable = item ? checkField(item.stable, false) : false;
            if (type == 8 && item.currency.toLowerCase() == "usdt") {
                params.currency = "btc";
                params.stable = false;
            }
            break;

          case 11:
            const item11 = cacheData.spot.spot.newList[index];
            params.currency = item11.currency;
            params.todayProfitRate = checkField(item11.todayProfitRate, null);
            break;

          case 12:
          case 13:
            const item12 = cacheData.spot.bot.newList[index];
            params.id = item12.strategyId;
            params.symbol = item12.symbol;
            params.createPath = item12.createPath;
            analysisParams.track = type == 12 ? "app_wallet_spotbots_drawer_create_click" : "app_wallet_spotbots_drawer_detail_click";
            break;

          case 14:
            const item14 = cacheData.spot.bot.newList[index];
            params.totalProfitRate = item14.totalProfitRate;
            params.symbolTitle = item14.symbolTranslateName;
            params.quoteCurrency = item14.quoteCurrency;
            params.minPrice = item14.minPrice;
            params.maxPrice = item14.maxPrice;
            params.tradeNum = item14.tradeNum;
            params.runTime = item14.runTime;
            analysisParams.track = "app_wallet_spotbots_drawer_share_click";
            break;

          case 15:
          case 16:
          case 36:
          case 116:
            let item16;
            if (childType == 4) {
                item16 = cacheData.contract.usdt_m.all.newList[index];
                params.tradeType = "1";
            } else if (childType == 7) {
                item16 = cacheData.contract.coin_p.all.newList[index];
                params.tradeType = "2";
            } else {
                item16 = cacheData.contract.coin_f.all.newList[index];
                params.tradeType = "3";
            }
            params.symbol = item16 ? item16.symbol : "";
            params.contractCode = item16 ? item16.contractCode ? item16.contractCode : "" : "";
            break;

          case 42:
            let item42 = cacheData.contract.usdt_m_unity.all.newList[index];
            params.currency = item42 ? item42.symbol.toLowerCase() : "usdt";
            if (params.currency == "usdt") {
                params.stable = true;
            } else {
                params.stable = false;
            }
            params.type = 8;
            break;

          case 43:
            let item43 = cacheData.contract.usdt_m_unity.all.newList[index];
            params.tradeType = "1";
            params.symbol = item43 ? item43.symbol : "";
            params.contractCode = "BTC-USDT";
            break;

          case 44:
            let item44 = cacheData.contract.usdt_m_unity.all.newList[index];
            let tempItem = availables[index];
            params.tradeType = "1";
            params.symbol = item44 ? item44.symbol : "";
            params.contractCode = "BTC-USDT";
            params.marginMode = "cross";
            params.assetType = cacheData.contract.usdt_m_unity.assetType;
            if (params.assetType == 3) {
                params.available = tempItem ? tempItem.withdrawAvailableAmount : "";
                params.equity = tempItem ? tempItem.equityNumAmount : "";
            } else {
                params.available = tempItem ? tempItem.marginAvailableAmount : "";
                params.equity = tempItem ? tempItem.equityNumAmount : "";
            }
            break;

          case 17:
            let item17;
            if (childType == 4) {
                item17 = cacheData.contract.usdt_m.all.newList[index];
                params.tradeType = "1";
            } else if (childType == 7) {
                item17 = cacheData.contract.coin_p.all.newList[index];
                params.tradeType = "2";
            } else {
                item17 = cacheData.contract.coin_f.all.newList[index];
                params.tradeType = "3";
            }
            params.marginMode = item17 ? item17.marginMode : "";
            params.symbol = item17 ? item17.symbol : "";
            params.contractCode = item17 ? item17.contractCode ? item17.contractCode : "" : "";
            break;

          case 18:
            let item18;
            if (childType == 4) {
                item18 = cacheData.contract.usdt_m.all.newList[index];
                params.tradeType = "1";
            } else if (childType == 7) {
                item18 = cacheData.contract.coin_p.all.newList[index];
                params.tradeType = "2";
            } else {
                item18 = cacheData.contract.coin_f.all.newList[index];
                params.tradeType = "3";
            }
            params.symbol = item18 ? item18.symbol : "";
            params.contractCode = item18 ? item18.contractCode ? item18.contractCode : "" : "";
            params.profitRate = item18 ? item18.profitRate : "0.0";
            params.direction = item18 ? item18.direction : "";
            params.leverRate = item18 ? item18.leverRate : "";
            break;

          case 117:
            let item117;
            if (childType == 4) {
                item117 = cacheData.contract.usdt_m.owned.newList[index];
                params.tradeType = "1";
            } else if (childType == 7) {
                item117 = cacheData.contract.coin_p.owned.newList[index];
                params.tradeType = "2";
            } else {
                item117 = cacheData.contract.coin_f.owned.newList[index];
                params.tradeType = "3";
            }
            params.marginMode = item117 ? item117.marginMode : "";
            params.symbol = item117 ? item117.symbol : "";
            params.contractCode = item117 ? item117.contractCode ? item117.contractCode : "" : "";
            break;

          case 118:
            let item118;
            if (childType == 4) {
                item118 = cacheData.contract.usdt_m.owned.newList[index];
                params.tradeType = "1";
            } else if (childType == 7) {
                item118 = cacheData.contract.coin_p.owned.newList[index];
                params.tradeType = "2";
            } else {
                item118 = cacheData.contract.coin_f.owned.newList[index];
                params.tradeType = "3";
            }
            params.symbol = item118 ? item118.symbol : "";
            params.contractCode = item118 ? item118.contractCode ? item118.contractCode : "" : "";
            params.profitRate = item118 ? item118.profitRate : "0.0";
            params.direction = item118 ? item118.direction : "";
            params.leverRate = item118 ? item118.leverRate : "";
            params.openPrice = item118 ? item118.costOpen : "";
            params.lastPrice = item118 ? item118.lastPrice : "";
            break;

          case 19:
          case 21:
            let item19 = cacheData.otc.newList[index];
            params.coinID = item19.coinId;
            params.currency = item19.coinName;
            params.total = item19.total;
            params.frozen = item19.frozen;
            params.borrow = item19.borrow;
            break;

          case 20:
            let item20 = cacheData.otc.newList[index];
            params.currency = item20.coinName;
            params.total = item19.total;
            params.frozen = item19.frozen;
            params.borrow = item19.borrow;
            break;

          case 22:
            let item22 = cacheData.earn.earnYbb.newList[index];
            params.projectInfoUrl = item22 ? item22.projectInfoUrl : "";
            params.type = 22;
            analysisParams.track = "app_assets_Earn_currency_button_click";
            analysisParams.properties = {
                tabName: "flexible",
                buttonName: "deposit",
                currency: item22.currency
            };
            break;

          case 24:
            let item24 = cacheData.earn.earnYbb.newList[index];
            params.orderId = item24.orderId;
            params.projectType = "0";
            analysisParams.track = "app_assets_Earn_currency_button_click";
            analysisParams.properties = {
                tabName: "flexible",
                buttonName: "details",
                currency: item24.currency
            };
            break;

          case 25:
            let item25 = cacheData.earn.earnYbb.newList[index];
            params.miningYearRate = item25.miningYearRate;
            params.currency = item25.currency;
            params.projectType = "1";
            analysisParams.track = "app_assets_Earn_currency_button_click";
            analysisParams.properties = {
                tabName: "flexible",
                buttonName: "share",
                currency: item25.currency
            };
            break;

          case 26:
          case 27:
          case 28:
            let item26 = cacheData.option.newList[index];
            params.currency = item26.currency;
            params.availableNum = item26.availableNum;
            params.positionNum = item26.positionNum;
            break;

          case 29:
            let item29 = cacheData.option.newList[index];
            params.currency = item29.currency;
            params.profitRate = item29["profit-loss-rate"];
            break;

          case 32:
          case 34:
            let item32 = cacheData.margin.allRepo.newList[index];
            params.isSuperMargin = true;
            params.currency = item32.currency;
            break;

          case 35:
            if (index == 0) {
                analysisParams.track = "app_assets_Earn_EarnNow_click";
                analysisParams.properties = {
                    tabName: "flexible"
                };
            } else if (index == 1) {
                analysisParams.track = "app_assets_Earn_EarnNow_click";
                analysisParams.properties = {
                    tabName: "fixed"
                };
            } else if (index == 2) {
                analysisParams.track = "app_assets_Earn_EarnNow_click";
                analysisParams.properties = {
                    tabName: "maxFlaxible"
                };
            }
            break;

          case 33:
            let item33 = cacheData.margin.allRepo.newList[index];
            params.isSuperMargin = true;
            params.currency = item33.currency;
            break;

          case 38:
            const item38 = cacheData.spot.spot.newList[index];
            params.currency = item38.currency;
            break;

          case 132:
            let item132 = cacheData.margin.partRepo.newList[index];
            params.type = 32;
            params.isSuperMargin = false;
            params.currency = item132.currency;
            break;

          case 133:
            let item133 = cacheData.margin.partRepo.newList[index];
            params.type = 33;
            params.isSuperMargin = false;
            params.currency = item133.currency;
            params.quoteCurrency = item133.quoteCurrency;
            params.baseCurrency = item133.baseCurrency;
            break;

          case 134:
            let item134 = cacheData.margin.partRepo.newList[index];
            params.type = 34;
            params.isSuperMargin = false;
            params.currency = item134.currency;
            break;

          case 102:
            let item102 = cacheData.earn.earnFixed.newList[index];
            params.projectInfoUrl = item102 ? item102.projectInfoUrl : "";
            params.type = 22;
            analysisParams.track = "app_assets_Earn_currency_button_click";
            analysisParams.properties = {
                tabName: "fixed",
                buttonName: "deposit",
                currency: item102.currency
            };
            break;

          case 104:
            let item104 = cacheData.earn.earnFixed.newList[index];
            params.orderId = item104 ? item104.orderId : "";
            params.projectType = "1";
            params.type = 24;
            analysisParams.track = "app_assets_Earn_currency_button_click";
            analysisParams.properties = {
                tabName: "fixed",
                buttonName: "detail",
                currency: item104.currency
            };
            break;

          case 105:
            let item105 = cacheData.earn.earnFixed.newList[index];
            params.miningYearRate = item105.miningYearRate;
            params.currency = item105.currency;
            params.projectType = "2";
            params.type = 25;
            analysisParams.track = "app_assets_Earn_currency_button_click";
            analysisParams.properties = {
                tabName: "fixed",
                buttonName: "share",
                currency: item105.currency
            };
            break;

          case 106:
            let item106 = cacheData.earn.earnHigh.newList[index];
            params.projectInfoUrl = item106 ? item106.projectInfoUrl : "";
            params.type = 22;
            analysisParams.track = "app_assets_Earn_currency_button_click";
            analysisParams.properties = {
                tabName: "maxFlaxible",
                buttonName: "deposit",
                currency: item106.currency
            };
            break;

          case 107:
            let item107 = cacheData.earn.earnHigh.newList[index];
            params.orderId = item107 ? item107.orderId : "";
            params.projectType = "2";
            params.type = 24;
            analysisParams.track = "app_assets_Earn_currency_button_click";
            analysisParams.properties = {
                tabName: "maxFlaxible",
                buttonName: "detail",
                currency: item107.currency
            };
            break;

          case 108:
            let item108 = cacheData.earn.earnHigh.newList[index];
            params.miningYearRate = item108.totalYearRate;
            params.currency = item108.currency;
            params.projectType = "3";
            params.type = 25;
            analysisParams.track = "app_assets_Earn_currency_button_click";
            analysisParams.properties = {
                tabName: "maxFlaxible",
                buttonName: "share",
                currency: item108.currency
            };
            break;

          case 51:
            let item51 = cacheData.contract.copy_trading.newList[index];
            params.symbol = item51.symbol;
            break;

          case 52:
            let item52 = cacheData.contract.copy_trading.newList[index];
            params.symbol = item52.symbol;
            break;

          case 54:
            const item54 = cacheData.spot.spot.newList[index];
            params.currency = item54.currency;
            params.financialJumpUrl = checkField(item54.financialJumpUrl, null);
            break;

          case 137:
            const balance = cacheData.balance;
            params.url = balance.earnJumpUrl;
            break;

          case 138:
            const item138 = cacheData.earn.earnNodePledge.newList[index];
            params.url = item138.subscriptionUrl;
            analysisParams.track = "app_assets_Earn_currency_button_click";
            analysisParams.properties = {
                tabName: "staking",
                buttonName: "deposit",
                currency: item138.currency
            };
            break;

          case 139:
            const item139 = cacheData.earn.earnNodePledge.newList[index];
            params.url = item139.projectInfoUrl;
            analysisParams.track = "app_assets_Earn_currency_button_click";
            analysisParams.properties = {
                tabName: "staking",
                buttonName: "detail",
                currency: item139.currency
            };
            break;

          case 140:
            params.url = cacheData.earn.earnNodePledge.baseInfo.jumpUrl;
            break;

          case 141:
            const item141 = cacheData.earn.earnNodePledge.newList[index];
            params.miningYearRate = item141.totalYearRate;
            params.currency = item141.currency;
            params.projectType = "4";
            params.type = 25;
            analysisParams.track = "app_assets_Earn_currency_button_click";
            analysisParams.properties = {
                tabName: "staking",
                buttonName: "share",
                currency: item141.currency
            };
            break;

          case 142:
            break;

          case 143:
            const jumpUrl = cacheData.balance.contractJumpUrl;
            const contractJumpUrl = `${commonData.webUrl}/${commonData.language}${jumpUrl}`;
            openRouter(contractJumpUrl);
            break;

          case 155:
            const item155 = cacheData.earn.earnSharkFin.newList[index];
            params.currency = item155.currency;
            if (item155.productStatus == 2) {
                params.yearRate = item155.totalYearRateTranslate;
            } else {
                params.yearRate = `${item155.translateMinYearRate}-${item155.translateMaxYearRate}`;
            }
            params.projectName = item155.projectName;
            params.type = 155;
            break;

          case 156:
            const item156 = cacheData.earn.earnSharkFin.newList[index];
            openRouter(item156.subscriptionUrl);
            break;

          case 157:
            const item157 = cacheData.earn.earnSharkFin.newList[index];
            openRouter(item157.projectInfoUrl);
            break;

          case 201:
            openRouter(currencyUpdateData.upgradeJumpUrl);
            break;

          case 202:
            openRouter(currencyUpdateData.upgradeDetailUrl);
            break;

          case 53:
            openRouter("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/Contract/CopyTrading?index=0");

          case 203:
            const item203 = cacheData.spot.bot.newList[index];
            const tradingBotUrl = `${commonData.webUrl}/${commonData.language}/tradingbot/h5/my-strategies?showbar=1&strategyId=${item203.strategyId}`;
            openRouter(tradingBotUrl);
            analysisParams.track = "app_wallet_spotbots_drawer_close_click";
            break;

          case 204:
            const item204 = cacheData.contractGrid.newList[index];
            const symbol204 = item204.symbol.toUpperCase();
            openRouter(`holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/trade/contractGrid?source=app_bots_assetspage&symbol=${symbol204}`);
            analysisParams.track = "app_wallet_futuresbots_drawer_create_click";
            break;

          case 205:
            const item205 = cacheData.contractGrid.newList[index];
            openRouter(`holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/trade/contractBotDetail?source=app_bots_assetspage&strategyId=${item205.strategyId}`);
            analysisParams.track = "app_wallet_futuresbotsdrawer_detail_click";
            break;

          case 206:
            const item206 = cacheData.contractGrid.newList[index];
            clickedStrategyId = item206.strategyId;
            $data.stopPopShow = "true";
            analysisParams.track = "app_wallet_futuresbots_drawer_close_click";
            break;

          case 207:
            const item207 = cacheData.contractGrid.newList[index];
            params.strategyId = item207.strategyId;
            params.symbol = item207.symbol;
            analysisParams.track = "app_wallet_futuresbots_drawer_share_click";
            break;

          case 208:
            let item208 = cacheData.earn.earnYbb.newList[index];
            openRouter(`${commonData.webUrl}/${commonData.language}/${item208.detailUrl}`);
            analysisParams.track = "app_assets_Earn_currency_button_click";
            analysisParams.properties = {
                tabName: "flexible",
                buttonName: "details",
                currency: item208.currency
            };
            break;

          default:
            break;
        }
    } catch (e) {
        console.error(`jump parse arg ${e}`);
    }
    if (analysisParams.track.length > 0) {
        analytics(analysisParams.track, analysisParams.properties);
    }
    if (type == 9 && exchangeEnable) {
        if (params.currency.toLowerCase() == "usdt") {
            openRouter(`${exchangeJumpUrl}?from=USDT&to=USDD`);
            return;
        }
        if (params.currency.toLowerCase() == "usdd") {
            openRouter(`${exchangeJumpUrl}?from=USDD&to=USDT`);
            return;
        }
    }
    if (type == 41) {
        if ($data.profitRed == "visible") {
            $data.profitRed = "gone";
            $nativeAPI.jump(JSON.stringify(params));
        }
    } else if (type == 10) {
        openRouter(`holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=earn&rootName=coindetail&navConfig=&currency=${params.currency}&stable=${params.stable}`);
    } else if (type == 206) ; else if (type == 22 || type == 102) {
        const urlPath = params.projectInfoUrl;
        if (urlPath.indexOf("holigeit") == 0 || urlPath.indexOf("http") == 0) {
            openRouter(urlPath);
        } else {
            $nativeAPI.jump(JSON.stringify(params));
        }
    } else {
        $nativeAPI.jump(JSON.stringify(params));
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

async function openRouter(url) {
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

async function currencyChange() {
    console.log("currency change");
    getTotalAssetCurrency().then((currency => {
        $data.currency = currency.toUpperCase();
    }));
    updatePageDataByType(currentDistributionType);
}

const TAG = "engine";

const HIDDEN_STR = "****";

const DEFAULT_STR = "0.00";

var DistributionType;

(function(DistributionType) {
    DistributionType["spot"] = "1";
    DistributionType["partRepo"] = "2";
    DistributionType["allRepo"] = "3";
    DistributionType["usdtM"] = "4";
    DistributionType["otc"] = "5";
    DistributionType["miningPool"] = "6";
    DistributionType["coinP"] = "7";
    DistributionType["c2cOut"] = "8";
    DistributionType["c2cIn"] = "9";
    DistributionType["earn"] = "17";
    DistributionType["coinFutures"] = "11";
    DistributionType["option"] = "13";
    DistributionType["optionOut"] = "12";
    DistributionType["collateral"] = "14";
    DistributionType["bot"] = "15";
    DistributionType["miningEarn"] = "16";
    DistributionType["earnFixed"] = "18";
    DistributionType["contractCopy"] = "19";
    DistributionType["earnHigh"] = "20";
    DistributionType["earnNodePledge"] = "21";
    DistributionType["earnSharkFin"] = "22";
    DistributionType["contractGrid"] = "25";
})(DistributionType || (DistributionType = {}));

var Symbols;

(function(Symbols) {
    Symbols["btc"] = "btc";
    Symbols["usdt"] = "usdt";
})(Symbols || (Symbols = {}));

const DEFAULT_CACHE = {
    spot: {
        spot: {
            baseInfo: {}
        },
        bot: {
            baseInfo: {}
        },
        collateral: {
            baseInfo: {}
        }
    },
    contract: {
        coin_f: {
            baseInfo: {},
            all: {},
            owned: {}
        },
        coin_p: {
            baseInfo: {},
            all: {},
            owned: {}
        },
        usdt_m: {
            baseInfo: {},
            all: {},
            owned: {}
        },
        usdt_m_unity: {
            baseInfo: {},
            all: {},
            owned: {},
            assetType: 2
        },
        copy_trading: {
            baseInfo: {}
        }
    },
    otc: {
        baseInfo: {}
    },
    option: {
        baseInfo: {}
    },
    earn: {
        earnYbb: {
            baseInfo: {}
        },
        earnFixed: {
            baseInfo: {}
        },
        earnHigh: {
            baseInfo: {}
        },
        earnNodePledge: {
            baseInfo: {}
        },
        earnSharkFin: {
            baseInfo: {}
        }
    },
    margin: {
        allRepo: {
            baseInfo: {}
        },
        partRepo: {
            baseInfo: {}
        }
    },
    contractGrid: {
        baseInfo: {}
    }
};

var cacheData = DEFAULT_CACHE;

const balanceAssetPath = "v1/open/profit/home/balance-assets";

const sellListPath = "v1/holding/transfer/sell/list";

const spotAccountInfoPath = "v1/open/profit/assets/spots";

const spotBotInfoPath = "v1/open/profit/asset/tradingbot/list";

const spotCollateralInfoPath = "v1/open/profit/assets/pledge";

const contractCoinPerpetualPath = "v1/open/profit/contract/coinSwap/accountInfo";

const contractCoinFuturesPath = "v1/open/profit/contract/coin/accountInfo";

const contractUsdtMPath = "v1/open/profit/contract/linear/accountInfo";

const contractCopyTradingPath = "v1/open/profit/contract/linear/documentary_account";

const contractUsdtMUnityPath = "v1/open/profit/contract/linear/unity_account_position_info/v2";

const balanceFinancialBannerPath = "v1/open/profit/assets/financial";

const balanceDepositRecommendPath = "v1/open/profit/assets/home/recommend";

const balanceRocketPath = "v1/open/profit/home/rocket";

const indexPircePath = "v1/open/profit/currency/usdtPrice/v2";

const fallCoinPath = "v1/open/profit/home/remove/currency/detail";

const contractGridInfoPath = "v1/open/profit/asset/contractGrid/list";

const contractGridStopPath = "v1/gridstrategy/submit-stop";

const depositWithdrawPath = "v1/open/profit/assets/home/deposit-withdraw";

function genRequestParams(path, params = "", method = 0, hostType = 0, header = "") {
    const param = {
        path: path,
        method: method,
        hostType: hostType,
        header: header,
        params: params
    };
    return JSON.stringify(param);
}

function getErrorInfo(code, succeed, msgList) {
    const params = {
        code: code,
        succeed: succeed,
        msgList: msgList
    };
    return JSON.stringify(params);
}

function profitPrefix(profit) {
    if (profit === "--" || profit === null) {
        return "";
    } else if (profit >= 0) {
        return "+";
    }
    return "";
}

function legalString(str, defaultStr = "") {
    if (str) return str;
    return defaultStr;
}

function getResponseParams(code, succeed) {
    const params = {
        code: code,
        succeed: succeed
    };
    return JSON.stringify(params);
}

async function getBalanceAsset() {
    const params = genRequestParams(balanceAssetPath, {
        version: "new",
        unionType: 1
    });
    try {
        const responseString = await $nativeAPI.request(params);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        let errorInfo = getErrorInfo(data.code, false, data.messageList);
        $data.totalTipsError = errorInfo;
        console.log(`wp getBalanceAsset, todayProfitState=${data.todayProfitState}`);
        todayProfitState = data.todayProfitState;
        $data.isMaintain = data.todayProfitState === 1 ? "gone" : "visible";
        if (code !== 200) {
            console.error(TAG, `getBalanceAsset, code=${code}`);
            $data.totalError = code;
        } else {
            cacheData.balance = data;
            updateTotalAssetData(data);
            updateAccountList(data);
            $data.openTextVisible = data.earnStatus === null ? "gone" : "visible";
            if (data.spotRobotJumpUrl) {
                $data.spotRobotJumpUrl = data.spotRobotJumpUrl;
            }
            if (data.earnStatus === 0) {
                $data.openText = $i18n.n_asset_cash_to_yyb_now;
                $data.openTextColor = "@color/kColorMajorTheme100";
            } else if (data.earnStatus === 1) {
                $data.openText = $i18n.n_asset_cash_to_yyb_part;
                $data.openTextColor = "@color/kColorSecondaryText";
            } else if (data.earnStatus === 2) {
                $data.openText = $i18n.n_asset_cash_to_yyb_all;
                $data.openTextColor = "@color/kColorSecondaryText";
            }
            autoEarnGuideShow = data.earnAutoConfigTip == 1 && data.earnStatus == 1;
            $data.contractAutoEarnVis = data.contractEarnStatus == null || data.contractEarnStatus == undefined ? "gone" : "visible";
            if (data.contractEarnStatus == 0) {
                $data.contractAutoEarnText = $i18n.n_asset_cash_to_yyb_now;
                $data.contractAutoEarnColor = "@color/kColorMajorTheme100";
            } else if (data.contractEarnStatus == 1) {
                $data.contractAutoEarnText = $i18n.n_shark_fin_autoSubscribe_open;
                $data.contractAutoEarnColor = "@color/kColorSecondaryText";
            }
            if (data.contractEarnRate) {
                $data.contractAutoEarn = $i18n.n_asset_contract_auto_earn.replace("6", `${data.contractEarnRate}`);
            } else {
                $data.contractAutoEarnVis = "gone";
            }
            data.subAccountBalanceList.map((item => {
                switch (item.distributionType) {
                  case DistributionType.spot:
                    cacheData.spot.spot.baseInfo = item;
                    updateSpotBaseInfoData(item);
                    break;

                  case DistributionType.bot:
                    cacheData.spot.bot.baseInfo = item;
                    updateBotBaseInfoData(item);
                    break;

                  case DistributionType.collateral:
                    cacheData.spot.collateral.baseInfo = item;
                    updateSpotCollateralBaseInfoData(item);
                    break;

                  case DistributionType.usdtM:
                    cacheData.contract.usdt_m.baseInfo = item;
                    updateLinearSwapBaseInfoData(item);
                    break;

                  case DistributionType.coinP:
                    cacheData.contract.coin_p.baseInfo = item;
                    updateCoinPBaseInfoData(item);
                    break;

                  case DistributionType.coinFutures:
                    cacheData.contract.coin_f.baseInfo = item;
                    updateCoinMBaseInfoData(item);
                    break;

                  case DistributionType.contractCopy:
                    cacheData.contract.copy_trading.baseInfo = item;
                    updateCopyTradingBaseInfo(item);
                    break;

                  case DistributionType.otc:
                    cacheData.otc.baseInfo = item;
                    updateOtcBaseInfo(item);
                    break;

                  case DistributionType.allRepo:
                    cacheData.margin.allRepo.baseInfo = item;
                    updateMarginAllInfo(item);
                    break;

                  case DistributionType.partRepo:
                    cacheData.margin.partRepo.baseInfo = item;
                    updateMarginPartBaseInfo(item);
                    break;

                  case DistributionType.earn:
                    cacheData.earn.earnYbb.baseInfo = item;
                    updateEarnYbbBaseInfo(item);
                    break;

                  case DistributionType.earnFixed:
                    cacheData.earn.earnFixed.baseInfo = item;
                    updateEarnFixedBaseInfo(item);
                    break;

                  case DistributionType.earnHigh:
                    cacheData.earn.earnHigh.baseInfo = item;
                    updateEarnHighBaseInfo(item);
                    break;

                  case DistributionType.earnNodePledge:
                    cacheData.earn.earnNodePledge.baseInfo = item;
                    updateEarnNodePledgeBaseInfo(item);
                    break;

                  case DistributionType.earnSharkFin:
                    cacheData.earn.earnSharkFin.baseInfo = item;
                    updateEarnSharkFinBaseInfo(item);
                    break;

                  case DistributionType.option:
                    cacheData.option.baseInfo = item;
                    updateOptionBaseInfo(item);
                    break;

                  case DistributionType.contractGrid:
                    cacheData.contractGrid.baseInfo = item;
                    updateContractGridBaseInfo(item);
                    break;
                }
            }));
        }
    } catch (e) {
        console.error(TAG, `getBalanceAsset:${e}`);
        $data.totalError = `${e}`;
    }
}

async function getRocketAmount() {
    const params = genRequestParams(balanceRocketPath);
    try {
        const responseString = await $nativeAPI.request(params);
        const response = JSON.parse(responseString);
        console.log(`wp getRocketAmount responseString ${responseString}`);
        const {code: code, message: message} = response;
        if (code !== 200) {
            $data.rocketAmount = "--";
            $nativeAPI.hbToast(message);
        } else {
            console.log(`wp getRocketAmount success`);
            let rocketInfoList = response.data.rocketInfoList;
            if (rocketInfoList.length > 0) {
                $data.rocketAmount = isHidden ? HIDDEN_STR : rocketInfoList[0].rocketAmount.toString();
                cacheData.rocketAmount = rocketInfoList[0].rocketAmount.toString();
                console.log(`wp getRocketAmount success rocketAmount ${$data.rocketAmount}`);
            } else {
                $data.rocketAmount = isHidden ? HIDDEN_STR : "0";
                cacheData.rocketAmount = "0";
            }
        }
    } catch (e) {
        $data.rocketAmount = HIDDEN_STR;
        console.error(`wp getRocketAmount ${e}`);
    }
}

async function rocketInfoTapAction() {
    let url = `${commonData.webUrl}/${commonData.language}/assets/rocket/`;
    $nativeAPI.openRoute(url);
}

async function updateEarnYbbBaseInfo(data) {
    $data.earnYbbRiskIconShow = "gone";
    if (currencyUpdateData.upgradeState === true) {
        $data.earnYbbHeaderBottomText = await getWord("asset_small_coin_to_htx");
    } else {
        $data.earnYbbHeaderBottomText = await getWord("asset_small_coin_to_ht");
    }
    if (isHidden) {
        $data.earnYbbTotalAsset = HIDDEN_STR;
        $data.earnYbbTodayPlNumber = HIDDEN_STR;
        $data.earnYbbTodayPlNumberColor = await getColor("kColorSecondaryText");
        return;
    }
    getCurrency();
    const legalCurrencySymbol = await getLegalCurrencySymbol();
    const equalAmount = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.balance);
    $data.earnYbbTotalAsset = addCurrencySymbolTotalAsset(legalCurrencySymbol, await formatNum(equalAmount));
    const todayProfit = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.profitIncome);
    const todayProfitWithSymbol = addCurrencySymbol(legalCurrencySymbol, todayProfit);
    $data.earnYbbTodayPlNumber = todayProfitWithSymbol;
    $data.earnYbbTodayPlNumberColor = await riseColor(todayProfit);
}

async function assetNewEarnGuide() {}

function assetNewEarnGuideHide() {}

async function assetSpotAutoEarnOpenGuide() {
    console.log(`assetSpotAutoEarnOpenGuide   1`);
    if (!autoEarnGuideShow) {
        console.log(`assetSpotAutoEarnOpenGuide  ${autoEarnGuideShow}`);
        return;
    }
    $data.spotOpenGuideShow = "false";
    $data.spotOpenGuidevisibility = "gone";
    autoEarnGuideShow = false;
    var guideShowDate = await $nativeAPI.storage({
        action: "read",
        name: "global_asset_guide",
        key: "guide_asset_spot_autoearn_show"
    });
    const nowDate = Date.now();
    console.log(`guideShowDate=${guideShowDate}==nowDate=${nowDate}`);
    if (guideShowDate == null || guideShowDate == "" || nowDate - guideShowDate > 24 * 60 * 60 * 1e3) {
        console.log(`showAssetSpotOpenGuide`);
        $data.spotOpenGuidevisibility = "visible";
        setTimeout((() => {
            $data.spotOpenGuideShow = "true";
        }), 500);
        $nativeAPI.storage({
            action: "save",
            name: "global_asset_guide",
            key: "guide_asset_spot_autoearn_show",
            data: `${Date.now()}`
        });
    }
}

function assetSpotOpenGuideHide() {
    $data.spotOpenGuideShow = "false";
    $data.spotOpenGuidevisibility = "gone";
}

async function getEqualLegalCurrencyAmountHandleNull(symbol, amount) {
    if (amount === null) {
        return "--";
    } else if (!amount) {
        amount = "0";
    }
    const param = {
        type: 1,
        currency: symbol,
        amount: amount
    };
    const paramString = JSON.stringify(param);
    return await $nativeAPI.currencyCommon(paramString);
}

function fixRateHandleNull(rate) {
    if (rate === null) {
        return "--";
    } else if (!rate) {
        return "0.00%";
    }
    try {
        return `${fixNumber(Number.parseFloat(rate) * 100, 2)}%`;
    } catch (e) {
        return "0.00%";
    }
}

function fixRate(rate) {
    if (!rate) {
        return "0.00%";
    }
    try {
        return `${fixNumber(Number.parseFloat(rate) * 100, 2)}%`;
    } catch (e) {
        return "0.00%";
    }
}

function fixRateFixed(rate, fixed) {
    if (!rate) {
        return "0.00%";
    }
    try {
        return `${fixNumber(Number.parseFloat(rate) * 100, fixed)}%`;
    } catch (e) {
        return "0.00%";
    }
}

async function updateEarnFixedBaseInfo(data) {
    console.log(`updateEarnFixedBaseInfo ${isHidden}`);
    if (currencyUpdateData.upgradeState === true) {
        $data.earnHeaderBottomText = await getWord("asset_small_coin_to_htx");
    } else {
        $data.earnHeaderBottomText = await getWord("asset_small_coin_to_ht");
    }
    $data.earnRiskIconShow = "gone";
    if (isHidden) {
        console.log(`updateEarnFixedBaseInfo into ${isHidden}`);
        $data.earnTotalAsset = HIDDEN_STR;
        $data.earnTodayPlNumber = HIDDEN_STR;
        $data.earnTodayPlNumberColor = await getColor("kColorSecondaryText");
        return;
    }
    getCurrency();
    const legalCurrencySymbol = await getLegalCurrencySymbol();
    const equalAmount = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.balance);
    console.log(`updateEarnFixedBaseInfo equalAmount${equalAmount}`);
    $data.earnTotalAsset = addCurrencySymbolTotalAsset(legalCurrencySymbol, await formatNum(equalAmount));
    const todayProfit = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.profitIncome);
    const todayProfitWithSymbol = addCurrencySymbol(legalCurrencySymbol, todayProfit);
    $data.earnTodayPlNumber = todayProfitWithSymbol;
    $data.earnTodayPlNumberColor = await riseColor(todayProfit);
}

async function updateEarnHighBaseInfo(data) {
    console.log(`earnBaseInfo ${JSON.stringify(data)}`);
    if (currencyUpdateData.upgradeState === true) {
        $data.earnHeaderBottomText = await getWord("asset_small_coin_to_htx");
    } else {
        $data.earnHeaderBottomText = await getWord("asset_small_coin_to_ht");
    }
    $data.earnRiskIconShow = "gone";
    if (isHidden) {
        $data.earnHighTotalAsset = HIDDEN_STR;
        $data.earnHighTodayPlNumber = HIDDEN_STR;
        $data.earnHighTodayPlNumberColor = await getColor("kColorSecondaryText");
        return;
    }
    getCurrency();
    const legalCurrencySymbol = await getLegalCurrencySymbol();
    const equalAmount = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.balance);
    $data.earnHighTotalAsset = addCurrencySymbolTotalAsset(legalCurrencySymbol, await formatNum(equalAmount));
    const todayProfit = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.profitIncome);
    const todayProfitWithSymbol = addCurrencySymbol(legalCurrencySymbol, todayProfit);
    $data.earnHighTodayPlNumber = todayProfitWithSymbol;
    $data.earnHighTodayPlNumberColor = await riseColor(todayProfit);
}

async function updateEarnNodePledgeBaseInfo(data) {
    console.log(`earnBaseInfo ${JSON.stringify(data)}`);
    if (currencyUpdateData.upgradeState === true) {
        $data.earnHeaderBottomText = await getWord("asset_small_coin_to_htx");
    } else {
        $data.earnHeaderBottomText = await getWord("asset_small_coin_to_ht");
    }
    $data.earnRiskIconShow = "gone";
    if (isHidden) {
        console.log(`updateEarnHighBaseInfo into ${isHidden}`);
        $data.earnNodePledgeTotalAsset = HIDDEN_STR;
        $data.earnNodePledgeTodayPlNumber = HIDDEN_STR;
        $data.earnNodePledgeTodayPlNumberColor = await getColor("kColorSecondaryText");
        return;
    }
    getCurrency();
    const legalCurrencySymbol = await getLegalCurrencySymbol();
    const equalAmount = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.balance);
    $data.earnNodePledgeTotalAsset = addCurrencySymbolTotalAsset(legalCurrencySymbol, await formatNum(equalAmount));
    const todayProfit = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.profitIncome);
    const todayProfitWithSymbol = addCurrencySymbol(legalCurrencySymbol, todayProfit);
    $data.earnNodePledgeTodayPlNumber = todayProfitWithSymbol;
    $data.earnNodePledgeTodayPlNumberColor = await riseColor(todayProfit);
}

async function updateEarnSharkFinBaseInfo(data) {
    console.log(`updateEarnSharkFinBaseInfo ${isHidden}`);
    if (currencyUpdateData.upgradeState === true) {
        $data.earnHeaderBottomText = await getWord("asset_small_coin_to_htx");
    } else {
        $data.earnHeaderBottomText = await getWord("asset_small_coin_to_ht");
    }
    $data.earnRiskIconShow = "gone";
    if (isHidden) {
        console.log(`updateEarnHighBaseInfo into ${isHidden}`);
        $data.earnSharkFinTotalAsset = HIDDEN_STR;
        $data.earnSharkFinTodayPlNumber = HIDDEN_STR;
        return;
    }
    getCurrency();
    const legalCurrencySymbol = await getLegalCurrencySymbol();
    const equalAmount = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.balance);
    $data.earnSharkFinTotalAsset = addCurrencySymbolTotalAsset(legalCurrencySymbol, await formatNum(equalAmount));
    console.log(`updateEarnSharkFinBaseInfo profitIncome${data.profitIncome}`);
    const todayProfit = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.profitIncome);
    const todayProfitWithSymbol = addCurrencySymbol(legalCurrencySymbol, todayProfit);
    $data.earnSharkFinTodayPlNumber = todayProfitWithSymbol;
}

async function updateOptionBaseInfo(data) {
    const currencySymbol = await getLegalCurrencySymbol();
    $data.optionsHeaderTitle = await getWord("n_asset_all_balance_convert");
    if (isHidden) {
        $data.optionsTotalAsset = HIDDEN_STR;
        return;
    }
    const totalLegal = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.balance);
    $data.optionsTotalAsset = addCurrencySymbolTotalAsset(currencySymbol, await formatNum(totalLegal));
}

async function getEntryShow() {
    const params = genRequestParams(sellListPath);
    try {
        const responseString = await $nativeAPI.request(params);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (code !== 200) {
            console.error(TAG, `getBalanceAsset, code=${code}`);
        } else {
            $data.despositShow = data.isClearRange !== 1 ? "visible" : "gone";
        }
        $data.cloudWalletShow = await $nativeAPI.currencyCommon('{"type":21}') ? "visible" : "gone";
    } catch (e) {
        console.error(TAG, `getSellList, ${e}`);
    }
}

async function getSpotAccountInfo(distributionType) {
    const param = {
        distributionType: distributionType
    };
    const params = genRequestParams(spotAccountInfoPath, param);
    try {
        const responseString = await $nativeAPI.request(params);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (code !== 200) {
            console.error(TAG, `getSpotDetail, code=${code}`);
            $data.exchangeListError = getResponseParams(code, false);
        } else {
            const {spotAccountInfoList: spotAccountInfoList} = data;
            if (distributionType === DistributionType.spot) {
                cacheData.spot.spot.currencies = spotAccountInfoList && spotAccountInfoList[0] && spotAccountInfoList[0].currencyInfoList ? spotAccountInfoList[0].currencyInfoList : [];
                updateSpotCurrenciesData(cacheData.spot.spot.currencies, 0);
                console.log("getSpotAccountInfo updateSpotCurrenciesData");
            }
        }
    } catch (e) {
        $data.exchangeListError = getResponseParams(-1, false);
        console.error(TAG, `getSpotDetail, ${e}`);
    }
}

async function getSpotBotInfo(distributionType) {
    const param = {
        from: "0",
        direct: "1",
        limit: "100"
    };
    const params = genRequestParams(spotBotInfoPath, param);
    try {
        const responseString = await $nativeAPI.request(params);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (code !== 200) {
            $data.botListError = getResponseParams(code, false);
            console.error(TAG, `getSpotDetail, code=${code}`);
        } else {
            cacheData.spot.bot.currencies = data ? data.strategyList : [];
            updateBotCurrenciesData(cacheData.spot.bot.currencies);
            console.log("updateBotCurrenciesData");
        }
    } catch (e) {
        console.error(TAG, `getSpotDetail, ${e}`);
        $data.botListError = getResponseParams(-1, false);
    }
}

async function getSpotCollateralInfo(distributionType) {
    const param = {
        distributionType: distributionType
    };
    const params = genRequestParams(spotCollateralInfoPath, param);
    try {
        const responseString = await $nativeAPI.request(params);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (code !== 200) {
            $data.collateralDataError = getResponseParams(code, false);
            console.error(TAG, `getSpotCollateralInfo, code=${code}`);
        } else {
            cacheData.spot.collateral.loaningList = data.loaningList ? data.loaningList : [];
            cacheData.spot.collateral.pledgeList = data.pledgeList ? data.pledgeList : [];
            updateSpotCollateralCurrencyData(cacheData.spot.collateral.loaningList, cacheData.spot.collateral.pledgeList);
            cacheData.spot.bot.loaned = data.loaningUSDT;
            cacheData.spot.bot.collateral = data.pledgingUSDT;
            const newUrlEnable = data.newUrlEnable;
            const indexJumpUrl = data.indexJumpUrl;
            const orderJumpUrl = data.orderJumpUrl;
            handlerCollateralUrl({
                newUrlEnable: newUrlEnable,
                indexJumpUrl: indexJumpUrl,
                orderJumpUrl: orderJumpUrl
            });
        }
    } catch (e) {
        console.error(TAG, `getSpotCollateralInfo, ${e}`);
        $data.collateralDataError = getResponseParams(-1, false);
    }
}

function goToCollateral() {
    console.log(`goToCollateral indexJumpUrl= ${$data.indexJumpUrl}`);
    openRouter(`${$data.indexJumpUrl}`);
}

function goToCollateralHistory() {
    console.log(`goToCollateralHistory indexJumpUrl= ${$data.orderJumpUrl}`);
    openRouter(`${$data.orderJumpUrl}`);
}

function handlerCollateralUrl({newUrlEnable: newUrlEnable, indexJumpUrl: indexJumpUrl, orderJumpUrl: orderJumpUrl}) {
    if (newUrlEnable) {
        $data.indexJumpUrl = `${commonData.webUrl}/${commonData.language}${indexJumpUrl}`;
        $data.orderJumpUrl = `${commonData.webUrl}/${commonData.language}${orderJumpUrl}`;
    } else {
        $data.indexJumpUrl = indexJumpUrl;
        $data.orderJumpUrl = orderJumpUrl;
    }
}

async function getContractUsdtM() {
    console.log("getContractUsdtM");
    const params = genRequestParams(contractUsdtMPath);
    try {
        const responseString = await $nativeAPI.request(params);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (code !== 200) {
            $data.usdtMAllAssetListError = getResponseParams(code, false);
            $data.usdtMOwnAssetListError = getResponseParams(code, false);
            console.error(TAG, `getContractUsdtM, code=${code}`);
        } else {
            cacheData.contract.usdt_m.all.list = data.assetCurrencyList ? data.assetCurrencyList : [];
            cacheData.contract.usdt_m.owned.list = data.holdCurrencyList ? data.holdCurrencyList : [];
            if (usdtMAll) {
                updateContractAllData(DistributionType.usdtM, cacheData.contract.usdt_m.all.list);
            } else {
                updateContractOwnedData(DistributionType.usdtM, cacheData.contract.usdt_m.owned.list);
            }
        }
    } catch (e) {
        $data.usdtMAllAssetListError = getResponseParams(-1, false);
        $data.usdtMOwnAssetListError = getResponseParams(-1, false);
        console.error(TAG, `getContractUsdtM, ${e}`);
    }
}

async function getCopyTradingData() {
    console.log("getCopyTradingData");
    const param = {
        accountType: "2"
    };
    const params = genRequestParams(contractCopyTradingPath, param);
    try {
        const responseString = await $nativeAPI.request(params);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (code !== 200) {
            $data.copyTradingListError = getResponseParams(code, false);
            console.error(TAG, `getCopyTradingData, code=${code}`);
        } else {
            console.error(TAG, `getCopyTradingData, data=${data}  response=:${response}`);
            cacheData.contract.copy_trading.list = data.accountSymbolList ? data.accountSymbolList : [];
            updateCopyTradingList(cacheData.contract.copy_trading.list);
        }
    } catch (e) {
        $data.copyTradingListError = getResponseParams(-1, false);
        console.error(TAG, `getCopyTradingData, ${e}`);
    }
}

async function updateCopyTradingList(oldList) {
    const data = [];
    console.error("updateCopyTradingList");
    console.error(oldList);
    const searchKey = cacheData.contract.copy_trading.searchKey;
    const hiddenSmallAsset = cacheData.contract.copy_trading.hiddenSmallAsset;
    await Promise.all(oldList.map((async item => {
        if (await itemShouldShow(item.symbol, item.symbol, item.withdrawAvailable, hiddenSmallAsset, searchKey)) {
            data.push(item);
        }
    })));
    console.error("updateCopyTradingList ---\x3e>>> data");
    console.error(data);
    const sortData = await sortList(data, getEqualLegalCurrencyAmountForCopyTrading);
    cacheData.contract.copy_trading.newList = sortData;
    const list = await Promise.all(sortData.map((async item => ({
        symbolIcon: await getIconUrl(item.symbol),
        symbolName: item.symbol.toUpperCase(),
        available: isHidden ? HIDDEN_STR : await getPreCurrencyAmount(item.symbol, item.withdrawAvailable),
        total: isHidden ? HIDDEN_STR : await addCurrentCurrencySymbol(await getEqualLegalCurrencyAmount(Symbols.usdt, item.accountTotalEquity))
    }))));
    $data.copyTradingList = JSON.stringify(list);
}

async function getContractUsdtMUnity() {
    console.log("getContractUsdtMUnity");
    const params = genRequestParams(contractUsdtMUnityPath, {
        unionType: 1
    });
    try {
        const responseString = await $nativeAPI.request(params);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (code !== 200) {
            $data.usdtMAllAssetListError = getResponseParams(code, false);
            $data.usdtMOwnAssetListError = getResponseParams(code, false);
            console.error(TAG, `getContractUsdtM, code=${code}`);
        } else {
            cacheData.contract.usdt_m_unity.all.list = data.assetCurrencyList ? data.assetCurrencyList : [];
            cacheData.contract.usdt_m_unity.owned.list = data.holdCurrencyList ? data.holdCurrencyList : [];
            cacheData.contract.usdt_m_unity.assetType = data.assetType;
            if (usdtMAll) {
                updateContractUsdtMUnityData(cacheData.contract.usdt_m_unity.all.list);
            } else {
                updateContractOwnedData(DistributionType.usdtM, cacheData.contract.usdt_m_unity.owned.list);
            }
        }
    } catch (e) {
        $data.usdtMAllAssetListError = getResponseParams(-1, false);
        $data.usdtMOwnAssetListError = getResponseParams(-1, false);
        console.error(TAG, `getContractUsdtM, ${e}`);
    }
}

async function getContractCoinFutures() {
    const params = genRequestParams(contractCoinFuturesPath);
    try {
        const responseString = await $nativeAPI.request(params);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (code !== 200) {
            $data.coinMAllAssetListError = getResponseParams(code, false);
            $data.coinMOwnAssetListError = getResponseParams(code, false);
            console.error(TAG, `getContractCoinFutures, code=${code}`);
        } else {
            cacheData.contract.coin_f.all.list = data.assetCurrencyList ? data.assetCurrencyList : [];
            cacheData.contract.coin_f.owned.list = data.holdCurrencyList ? data.holdCurrencyList : [];
            if (coinMAll) {
                updateContractAllData(DistributionType.coinFutures, cacheData.contract.coin_f.all.list);
            } else {
                updateContractOwnedData(DistributionType.coinFutures, cacheData.contract.coin_f.owned.list);
            }
        }
    } catch (e) {
        $data.coinMAllAssetListError = getResponseParams(-1, false);
        $data.coinMOwnAssetListError = getResponseParams(-1, false);
        console.error(TAG, `getContractCoinFutures, ${e}`);
    }
}

async function getContractCoinPerpetual() {
    const params = genRequestParams(contractCoinPerpetualPath);
    try {
        const responseString = await $nativeAPI.request(params);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (code !== 200) {
            $data.coinPAllAssetListError = getResponseParams(code, false);
            $data.coinPOwnAssetListError = getResponseParams(code, false);
            console.error(TAG, `getContractCoinPerpetual, code=${code}`);
        } else {
            cacheData.contract.coin_p.all.list = data.assetCurrencyList ? data.assetCurrencyList : [];
            cacheData.contract.coin_p.owned.list = data.holdCurrencyList ? data.holdCurrencyList : [];
            if (coinPAll) {
                updateContractAllData(DistributionType.coinP, cacheData.contract.coin_p.all.list);
            } else {
                updateContractOwnedData(DistributionType.coinP, cacheData.contract.coin_p.owned.list);
            }
        }
    } catch (e) {
        $data.coinPAllAssetListError = getResponseParams(-1, false);
        $data.coinPOwnAssetListError = getResponseParams(-1, false);
        console.error(TAG, `getContractCoinPerpetual, ${e}`);
    }
}

async function getDepositBannerInfo(assetLevel2) {
    var assetLevel = fixNumber(assetLevel2, 0);
    const params = genRequestParams(balanceDepositRecommendPath, {
        assetLevel: assetLevel
    });
    try {
        const responseString = await $nativeAPI.request(params);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (code !== 200) {
            return null;
        } else {
            return data;
        }
    } catch (e) {
        return null;
    }
}

async function updateTotalAssetData(data) {
    try {
        const isAnalysis = await $nativeAPI.currencyCommon('{"type":11}');
        $data.isOpenAnalysis = isAnalysis ? "1" : "0";
        if (isAnalysis) {
            $data.analysis = await getWord("n_balance_goto_profit_daily");
        } else {
            $data.analysis = await getWord("n_cloud_wallet_asset_profit_daily");
        }
        $data.assetLevel = data.assetLevel;
        $data.showRecommend = data.assetLevel != 0 ? "visible" : "gone";
        $data.shareVisibility = "visible";
        $data.restrictionVis = data.isAllow == null || data.isAllow == true ? "gone" : "visible";
        exchangeEnable = data.exchangeEnable || false;
        exchangeJumpUrl = data.exchangeJumpUrl || "";
        $data.exchangeUSDDVis = $data.restrictionVis == "gone" && exchangeEnable ? "visible" : "gone";
        let bannerData = null;
        let coupon = data.coupon;
        if (data.assetLevel === 1) {
            bannerData = await getDepositBannerInfo($data.assetLevel);
            if (bannerData === null || !bannerData.length) {
                $data.showRecommend = "gone";
                $data.assetRocketFinished = "1";
            } else {
                $data.bannerInfos = JSON.stringify(bannerData);
                $data.assetBannerInfoFinished = "1";
            }
        } else if (data.assetLevel > 1) {
            const params = genRequestParams(balanceFinancialBannerPath);
            try {
                const responseString = await $nativeAPI.request(params);
                const response = JSON.parse(responseString);
                const {code: code, data: data} = response;
                let bannerInfo = null;
                if (code !== 200) {
                    console.error(TAG, `assets/financial, code=${code}`);
                } else {
                    bannerInfo = {
                        type: 2,
                        leftInfo: legalString(data.symbol),
                        title: legalString(data.projectTranslateName),
                        desc: legalString(data.apyTranslate),
                        rightInfo: legalString(data.yearDisplayRate),
                        jumpUrl: legalString(data.jumpUrl)
                    };
                }
                bannerData = await getDepositBannerInfo($data.assetLevel);
                let bannerDataNull = bannerData === null || !bannerData.length;
                if ($data.assetLevel === 2) {
                    if (bannerDataNull && bannerInfo === null) {
                        $data.showRecommend = "gone";
                    } else if (bannerDataNull && bannerInfo !== null) {
                        $data.bannerInfos = JSON.stringify([ bannerInfo ]);
                    } else if (!bannerDataNull && bannerInfo !== null && !coupon) {
                        $data.bannerInfos = JSON.stringify(bannerData.concat(bannerInfo));
                    } else {
                        $data.bannerInfos = JSON.stringify(bannerData);
                    }
                } else if ($data.assetLevel === 3 && bannerInfo !== null && !coupon) {
                    $data.bannerInfos = JSON.stringify([ bannerInfo ]);
                } else if ($data.assetLevel === 3 && !bannerDataNull && coupon) {
                    $data.bannerInfos = JSON.stringify(bannerData);
                } else {
                    $data.showRecommend = "gone";
                }
                $data.assetBannerInfoFinished = "1";
            } catch (e) {
                $data.showRecommend = "gone";
                $data.assetBannerInfoFinished = "1";
            }
        }
        if (isHidden) {
            $data.assetTotal = HIDDEN_STR;
            $data.assetToadyProfit = HIDDEN_STR;
            $data.assetToadyProfitRate = "";
            $data.assetTotalProfit = HIDDEN_STR;
            $data.totalAsset = HIDDEN_STR;
            $data.todayPlNumber = HIDDEN_STR;
            $data.rocketAmount = HIDDEN_STR;
            $data.totalBalanceData = data.currencyNum && data.assetLevel != 0 ? 1 : 0;
            return;
        }
        const currency = await getTotalAssetCurrency();
        const legalCurrencySymbol = await getLegalCurrencySymbol();
        console.log(`total ${data.totalBalanceUsdt} currency ${currency}`);
        const legalCurrencyTotal = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.totalBalanceUsdt);
        $data.assetTotal = legalCurrencyTotal;
        let assetToadyProfit;
        if (data.todayProfit) {
            $data.assetToadyProfitColor = isHidden ? await getColor("kColorSecondaryText") : await riseColor(data.todayProfit);
            if (data.todayProfit > 0) {
                assetToadyProfit = `+${addCurrencySymbol(await getLegalCurrencySymbol(), await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.todayProfit))}`;
            } else {
                assetToadyProfit = addCurrencySymbol(await getLegalCurrencySymbol(), await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.todayProfit));
            }
        } else {
            $data.assetToadyProfitColor = await getColor("kColorSecondaryText");
            assetToadyProfit = "--";
        }
        $data.assetToadyProfit = assetToadyProfit;
        $data.assetToadyProfitRate = `/${fixRateHandleNull(data.todayProfitRate)}`;
        if (data.todayProfitState !== 1) {
            $data.assetToadyProfit = "--";
            $data.assetToadyProfitRate = "";
        }
        $data.rocketAmount = cacheData.rocketAmount ? cacheData.rocketAmount : "--";
        $data.assetTotalProfit = data.totalAccumulateProfitUsdt ? addCurrencySymbol(await getLegalCurrencySymbol(), await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.totalAccumulateProfitUsdt)) : "--";
        $data.totalBalanceData = data.currencyNum && data.assetLevel != 0 ? 1 : 0;
        const lang = await $nativeAPI.currencyCommon('{"type":70}');
    } catch (e) {
        console.error(TAG, `updateTotalAssetData, ${e}`);
        $data.showRecommend = "gone";
        $data.assetBannerInfoFinished = "1";
        $data.totalError = `${e}`;
    }
}

async function updateAccountList(data) {
    const profitAccountBalanceList = data.accountBalanceList ? JSON.stringify(data.accountBalanceList) : "[]";
    $data.profitAccountBalanceList = profitAccountBalanceList;
}

async function updateBotBaseInfoData(data) {
    console.log(`updateBotBaseInfoData ${isHidden}`);
    if (isHidden) {
        $data.botTotalAsset = HIDDEN_STR;
        $data.botTodayPlNumber = HIDDEN_STR;
        return;
    }
    try {
        const legalCurrencySymbol = await getLegalCurrencySymbol();
        const equalAmount = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.balance);
        $data.botTotalAsset = addCurrencySymbolTotalAsset(legalCurrencySymbol, await formatNum(equalAmount));
        const todayProfit = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.todayProfit);
        const todayProfitWithSymbol = addCurrencySymbol(legalCurrencySymbol, todayProfit);
        $data.botTodayPlNumber = `${todayProfitWithSymbol}/${fixRateHandleNull(data.todayProfitRate)}`;
        $data.botTodayPlNumberColor = isHidden ? await getColor("kColorSecondaryText") : await riseColor(data.todayProfit);
    } catch (e) {
        console.error(`updateBotBaseInfoData ${e}`);
    }
}

async function updateSpotBaseInfoData(data) {
    if (data.spotRiskLevel == 0) {
        const text = await getWord("n_spot_account_no_risk");
        $data.riskText = text;
        $data.riskIconShow = "gone";
        $data.riskTextColor = await getColor("trade_tag_text_color");
        $data.riskBackground = await getColor("trade_tag_text_bg");
    } else if (data.spotRiskLevel == 1) {
        const text = await getWord("n_spot_order_little_risk");
        $data.riskText = `${data.spotRiskRate}% ${text}`;
        $data.riskIcon = "asset_spot_low_risk";
        const riskTextColor = await getColor("KBaseRiskTextColorLow");
        console.log(riskTextColor);
        $data.riskTextColor = riskTextColor;
        $data.riskIconShow = "visible";
    } else if (data.spotRiskLevel == 2) {
        const text = await getWord("n_spot_order_middle_risk");
        $data.riskText = `${data.spotRiskRate}% ${text}`;
        $data.riskIcon = "asset_spot_mid_risk";
        $data.riskTextColor = await getColor("KBaseRiskTextColorMid");
        $data.riskIconShow = "visible";
    } else if (data.spotRiskLevel == 3) {
        const text = await getWord("n_spot_order_high_risk");
        $data.riskText = `${data.spotRiskRate}% ${text}`;
        $data.riskIcon = "asset_spot_high_risk";
        $data.riskTextColor = await getColor("KBaseRiskTextColorHigh");
        $data.riskIconShow = "visible";
    } else if (data.spotRiskLevel == 4) {
        const text = await getWord("n_spot_order_very_high_risk");
        console.log(`text ${text}`);
        $data.riskText = `${data.spotRiskRate}% ${text}`;
        $data.riskIcon = "asset_spot_very_high_risk";
        $data.riskTextColor = await getColor("KBaseRiskTextColorHigh");
        $data.riskIconShow = "visible";
    } else if (data.spotRiskLevel == 5) {
        const text = await getWord("n_asset_ybb_lock");
        $data.riskText = text;
        $data.riskIconShow = "gone";
        $data.riskTextColor = await getColor("baseCoinLockTip");
        $data.riskBackground = await getColor("baseCoinLockTipBg");
    } else if (data.spotRiskLevel == 6) {
        const text = await getWord("n_spot_blast_a_storehouse");
        $data.riskText = text;
        $data.riskIconShow = "gone";
        $data.riskTextColor = await getColor("trade_st_color");
        $data.riskBackground = await getColor("trade_st_color_bg");
    } else if (data.spotRiskLevel == 7) {
        const text = await getWord("n_spot_wear_a_storehouse");
        $data.riskText = text;
        $data.riskIconShow = "gone";
        $data.riskTextColor = await getColor("trade_st_color");
        $data.riskBackground = await getColor("trade_st_color_bg");
    } else {
        $data.riskText = "";
        $data.riskIconShow = "gone";
    }
    console.log(`updateSpotBaseInfoData ${isHidden}`);
    if (isHidden) {
        console.log(`updateSpotBaseInfoData into ${isHidden}`);
        $data.totalAsset = HIDDEN_STR;
        $data.todayPlNumber = HIDDEN_STR;
        return;
    }
    const legalCurrencySymbol = await getLegalCurrencySymbol();
    const equalAmount = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.balance);
    $data.totalAsset = addCurrencySymbolTotalAsset(legalCurrencySymbol, await formatNum(equalAmount));
    const todayProfit = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.todayProfit);
    const todayProfitWithSymbol = addCurrencySymbol(legalCurrencySymbol, todayProfit);
    $data.todayPlNumber = `${profitPrefix(data.todayProfit)}${todayProfitWithSymbol}/${fixRateHandleNull(data.todayProfitRate)}`;
    $data.todayPlNumberColor = isHidden ? await getColor("kColorSecondaryText") : await riseColor(data.todayProfit);
    if (todayProfitState !== 1) {
        $data.todayPlNumber = "--";
    }
}

async function updateBotCurrenciesData(list) {
    try {
        const spotCurrencyData = await sortBotList(list);
        const currencySymbol = await getLegalCurrencySymbol();
        cacheData.spot.bot.newList = spotCurrencyData;
        const currencies = await Promise.all(spotCurrencyData.map((async item => {
            try {
                const symbolIcon = await getIconUrl(item.baseCurrency);
                const symbolName = `${item.symbolTranslateName}`;
                const cost = isHidden ? HIDDEN_STR : await addCurrentCurrencySymbol(await getEqualLegalCurrencyAmount(Symbols.usdt, item.investAmount));
                const equalTodayProfit = isHidden ? HIDDEN_STR : await convertLegalTender(Symbols.usdt, item.totalProfit, 2);
                const originSpotYield = addCurrencySymbol(currencySymbol, equalTodayProfit);
                const spotYield = isHidden ? HIDDEN_STR : `${item.totalProfit >= 0 ? "+" : ""}${originSpotYield}`;
                const originSpotRate = fixRate(item.totalProfitRate);
                const spotYieldRate = isHidden ? HIDDEN_STR : `${item.totalProfitRate >= 0 ? "+" : ""}${originSpotRate}`;
                const spotRiseColor = isHidden ? await getColor("kColorSecondaryText") : await riseColor(item.totalProfit);
                const spotLoan = item.runTypeTranslateName;
                return {
                    symbolIcon: symbolIcon,
                    symbolName: symbolName,
                    cost: cost,
                    spotYield: spotYield,
                    spotYieldRate: spotYieldRate,
                    spotLoan: spotLoan,
                    spotRiseColor: spotRiseColor
                };
            } catch (e) {
                console.error(`spotCurrencyData.map ${e}`);
                return {};
            }
        })));
        $data.botList = JSON.stringify(currencies);
    } catch (e) {
        console.error(`updateBotCurrenciesData ${e}`);
    }
}

var currentSpotList;

var currentSpotExpandCurrency;

var indexPriceMap = {};

async function updateSpotCurrenciesData(list, forceRefreshFlag = 1) {
    try {
        if (!list) {
            return;
        }
        const startTime = Date.now();
        if (startTime - endTime < 500 || JSON.stringify(list) == JSON.stringify(currentSpotList) && forceRefreshFlag != 0) {
            console.log(`spotAllCoinLogTag 频繁调用拦截 `);
            if (cacheData.spot.spot.searchKey != cacheData.spot.spot.lastSearchKey) {
                setTimeout((() => {
                    updateSpotCurrenciesData(cacheData.spot.spot.currencies, forceRefreshFlag);
                }), 500);
            }
            return;
        }
        cacheData.spot.spot.lastSearchKey = cacheData.spot.spot.searchKey;
        currentSpotList = list;
        console.log(`indexPriceMap : ${JSON.stringify(indexPriceMap)}`);
        var indexPrice = indexPriceMap[`${currentSpotExpandCurrency}`];
        const edgeEngineDataPackage = {
            searchKey: cacheData.spot.spot.searchKey,
            hiddenSmallAsset: cacheData.spot.spot.hiddenSmallAsset,
            spotList: list,
            sortType: sortType,
            sortSequence: sortSequence,
            indexPrice: indexPrice
        };
        const originConvertJson = await $nativeAPI.currencyCommon(JSON.stringify({
            type: 100,
            parameter: edgeEngineDataPackage
        }));
        console.log(`edgeEngineDataPackage  itemNew : ${originConvertJson}`);
        const originConvertList = JSON.parse(originConvertJson);
        cacheData.spot.spot.newList = originConvertList.spotList;
        const spotListNew = await Promise.all(originConvertList.spotList.map((async item => {
            try {
                const symbolIcon = item.symbolIcon;
                const symbolName = item.displayName.toUpperCase();
                const isLoan = checkField(item.availableNum, 0) < 0 ? "visible" : "gone";
                const equalAmount = isHidden ? HIDDEN_STR : checkField(item.equalAmount, "0.00");
                const spotNumberEquivalent = isHidden ? HIDDEN_STR : addCurrencySymbol(originConvertList.currencySymbol, equalAmount);
                const spotNumber = isHidden ? HIDDEN_STR : checkField(item.positionNumDisplayNameNew, "0.00");
                const equalTodayProfit = isHidden ? HIDDEN_STR : checkField(item.equalTodayProfit, "0.00");
                const originSpotYield = addCurrencySymbol(originConvertList.currencySymbol, equalTodayProfit);
                var spotYield = isHidden ? HIDDEN_STR : `${checkField(item.todayProfit, null) >= 0 ? "+" : ""}${originSpotYield}`;
                const originSpotRate = fixRate(checkField(item.todayProfitRate, null));
                var spotYieldRate = isHidden ? HIDDEN_STR : `${checkField(item.todayProfitRate, null) >= 0 ? "+" : ""}${originSpotRate}`;
                const spotExAvailable = isHidden ? HIDDEN_STR : checkField(item.spotExAvailable, "0.00");
                const spotExDebts = isHidden ? HIDDEN_STR : checkField(item.spotExDebts, "0.00");
                const spotExPrice = isHidden ? HIDDEN_STR : addCurrencySymbol(originConvertList.currencySymbol, checkField(item.spotExPrice, "0.00"));
                const avgPositionCost = isHidden ? HIDDEN_STR : addCurrencySymbol(originConvertList.currencySymbol, checkField(item.avgPositionCostParam, "0.00"));
                const spotExTopCenterTitle = checkField(item.avgPositionCost, null) == null ? $i18n.n_asset_price : $i18n.n_asset_price_cost_price;
                const avgPositionCostShow = checkField(item.avgPositionCost, null) == null ? "gone" : "visible";
                const spotExCost = isHidden ? HIDDEN_STR : checkField(item.spotExCost, "0.00");
                const originSpotExYield = addCurrencySymbol(originConvertList.currencySymbol, checkField(item.originSpotExYieldParam, "0.00"));
                const spotExYield = isHidden ? HIDDEN_STR : `${checkField(item.profit, null) >= 0 ? "+" : ""}${originSpotExYield}`;
                const originSpotExYieldRate = fixRate(checkField(item.profitRate, null));
                const spotExYieldRate = isHidden ? HIDDEN_STR : `${checkField(item.profitRate, null) >= 0 ? "+" : ""}${originSpotExYieldRate}`;
                var spotRiseColor = isHidden ? "@color/kColorSecondaryText" : riseColorV2(checkField(item.todayProfitRate, null), originConvertList.colorMode);
                const spotExRiseColor = isHidden ? "@color/kColorSecondaryText" : riseColorV2(checkField(item.profitRate, null), originConvertList.colorMode);
                const isUpdatedCurrency = currencyUpdateData.upDetailCurrency === item.currency && currencyUpdateData.upgradeState === true;
                const isNeedUpCurrency = currencyUpdateData.upgradeCurrency === item.currency && currencyUpdateData.upgradeState === true;
                const currency = item.currency;
                if (item.zeroState !== 1) {
                    spotYield = "--";
                    spotYieldRate = "";
                    spotRiseColor = "@color/kColorSecondaryText";
                }
                var showSpotMarket;
                var showSpotTrade;
                var showSpotEarn;
                var showSpotDetail;
                var showSpotShare;
                var showSpotUpDetail;
                var showSpotUpdate;
                if (isUpdatedCurrency === true) {
                    showSpotMarket = "visible";
                    showSpotDetail = "visible";
                    showSpotTrade = "visible";
                    showSpotEarn = "gone";
                    showSpotUpDetail = "visible";
                    showSpotShare = "visible";
                    showSpotUpdate = "gone";
                } else if (isNeedUpCurrency === true) {
                    showSpotMarket = "gone";
                    showSpotDetail = "gone";
                    showSpotTrade = "gone";
                    showSpotEarn = "gone";
                    showSpotUpDetail = "gone";
                    showSpotShare = "gone";
                    showSpotUpdate = "visible";
                } else {
                    showSpotMarket = "visible";
                    showSpotDetail = "visible";
                    showSpotTrade = "visible";
                    showSpotShare = "visible";
                    if (item.isFinancial) {
                        showSpotEarn = "visible";
                    } else {
                        showSpotEarn = "gone";
                    }
                    showSpotUpDetail = "gone";
                    showSpotUpdate = "gone";
                }
                var showSpotUpdateButton;
                var showSpotRise;
                if (isNeedUpCurrency === true) {
                    showSpotUpdateButton = "visible";
                    showSpotRise = "gone";
                } else {
                    showSpotUpdateButton = "gone";
                    showSpotRise = "visible";
                }
                var spotTradeSrc = "@drawable/asst_exc_exc_tradenew";
                var spotTradeTitle = $i18n.n_new_user_guide_trade;
                if (exchangeEnable) {
                    if (symbolName == "USDT") {
                        spotTradeSrc = "@drawable/edge_engine_asset_spot_usdd_usdt";
                        spotTradeTitle = $i18n.n_asset_spot_exchange_USDD;
                    } else if (symbolName == "USDD") {
                        spotTradeSrc = "@drawable/edge_engine_asset_spot_usdd_usdt";
                        spotTradeTitle = $i18n.n_asset_spot_exchange_USDT;
                    }
                }
                return {
                    symbolIcon: symbolIcon,
                    symbolName: symbolName,
                    isLoan: isLoan,
                    equalAmount: equalAmount,
                    spotNumberEquivalent: spotNumberEquivalent,
                    spotNumber: spotNumber,
                    spotYield: spotYield,
                    spotExTopCenterTitle: spotExTopCenterTitle,
                    avgPositionCost: avgPositionCost,
                    avgPositionCostShow: avgPositionCostShow,
                    spotYieldRate: spotYieldRate,
                    spotExAvailable: spotExAvailable,
                    spotExDebts: spotExDebts,
                    spotExPrice: spotExPrice,
                    spotExCost: spotExCost,
                    spotExYield: spotExYield,
                    spotExYieldRate: spotExYieldRate,
                    spotRiseColor: spotRiseColor,
                    spotExRiseColor: spotExRiseColor,
                    showSpotMarket: showSpotMarket,
                    showSpotDetail: showSpotDetail,
                    showSpotTrade: showSpotTrade,
                    showSpotEarn: showSpotEarn,
                    showSpotShare: showSpotShare,
                    showSpotUpDetail: showSpotUpDetail,
                    showSpotUpdate: showSpotUpdate,
                    showSpotUpdateButton: showSpotUpdateButton,
                    showSpotRise: showSpotRise,
                    currency: currency,
                    spotTradeSrc: spotTradeSrc,
                    spotTradeTitle: spotTradeTitle
                };
            } catch (e) {
                console.error(`spotCurrencyData.map ${e}`);
                return {};
            }
        })));
        cacheData.spot.spot.spotListNew = spotListNew;
        $data.exchangeList = JSON.stringify(spotListNew);
        if (list.length > 0) {
            endTime = Date.now();
        }
        console.log(`ConsumeTimeTag  总耗时 : ${endTime - startTime}`);
    } catch (e) {
        console.error(`updateSpotCurrenciesData ${e}`);
    }
}

function checkField(field, defaultValue) {
    return field == null ? defaultValue : field;
}

async function updateSpotCollateralBaseInfoData(data) {
    if (isHidden) {
        $data.collateralTotalAsset = HIDDEN_STR;
        $data.loaned = HIDDEN_STR;
        $data.collateral = HIDDEN_STR;
        return;
    }
    const currencySymbol = await getLegalCurrencySymbol();
    const legalAsset = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.balance);
    $data.collateralTotalAsset = addCurrencySymbolTotalAsset(currencySymbol, await formatNum(legalAsset));
    $data.headerBottomShow = "visible";
}

async function updateSpotCollateralCurrencyData(oldLoaingList, oldPledgeList) {
    const currencySymbol = await getLegalCurrencySymbol();
    const result = {};
    var shouldReturn = false;
    if (oldLoaingList) {
        const loaningList = [];
        const searchKey = cacheData.spot.collateral.searchKey;
        const hiddenSmallAsset = cacheData.spot.collateral.hiddenSmallAsset;
        await Promise.all(oldLoaingList.map((async item => {
            if (await itemShouldShow(item.currency, Symbols.usdt, item.usdtAmount, hiddenSmallAsset, searchKey)) {
                loaningList.push(item);
            }
        })));
        const newLoaningList = await sortList(loaningList, getEqualLegalCurrencyAmountForCollateral);
        const loaned = await Promise.all(newLoaningList.map((async item => {
            try {
                const symbolIcon = item.currencyIcon;
                const symbolName = item.currency.toUpperCase();
                const amount = isHidden ? HIDDEN_STR : item.amount;
                const equalAmount = await getEqualLegalCurrencyAmount(Symbols.usdt, item.usdtAmount);
                const value = isHidden ? HIDDEN_STR : addCurrencySymbol(currencySymbol, equalAmount);
                return {
                    symbolIcon: symbolIcon,
                    symbolName: symbolName,
                    amount: amount,
                    value: value
                };
            } catch (e) {
                console.error(`loaningList error ${e}`);
            }
            return {};
        })));
        shouldReturn = true;
        result.loanedList = loaned;
    }
    if (oldPledgeList) {
        const pledgeList = [];
        const searchKey = cacheData.spot.collateral.searchKey;
        const hiddenSmallAsset = cacheData.spot.collateral.hiddenSmallAsset;
        await Promise.all(oldPledgeList.map((async item => {
            if (await itemShouldShow(item.currency, Symbols.usdt, item.usdtAmount, hiddenSmallAsset, searchKey)) {
                pledgeList.push(item);
            }
        })));
        const newPledgeList = await sortList(pledgeList, getEqualLegalCurrencyAmountForCollateral);
        const collateral = await Promise.all(newPledgeList.map((async item => {
            try {
                const symbolIcon = item.currencyIcon;
                const symbolName = item.currency.toUpperCase();
                const amount = isHidden ? HIDDEN_STR : await getPreCurrencyAmount(item.currency, item.amount);
                const equalAmount = await getEqualLegalCurrencyAmount(Symbols.usdt, item.usdtAmount);
                const value = isHidden ? HIDDEN_STR : addCurrencySymbol(currencySymbol, equalAmount);
                return {
                    symbolIcon: symbolIcon,
                    symbolName: symbolName,
                    amount: amount,
                    value: value
                };
            } catch (e) {
                console.error(`loaningList error ${e}`);
            }
        })));
        shouldReturn = true;
        result.collateralList = collateral;
    }
    if (shouldReturn) {
        $data.collateralData = JSON.stringify(result);
    }
    $data.loaned = isHidden ? HIDDEN_STR : await addCurrentCurrencySymbol(await getEqualLegalCurrencyAmount(Symbols.usdt, cacheData.spot.bot.loaned));
    $data.collateral = isHidden ? HIDDEN_STR : await addCurrentCurrencySymbol(await getEqualLegalCurrencyAmount(Symbols.usdt, cacheData.spot.bot.collateral));
}

async function updateLinearSwapBaseInfoData(data) {
    console.log("updateLinearSwapBaseInfoData");
    const currencySymbol = await getLegalCurrencySymbol();
    if (isHidden) {
        $data.linearHeaderTotalAsset = HIDDEN_STR;
        $data.linearHeaderIncome = HIDDEN_STR;
        return;
    }
    const totalLegal = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.balance);
    $data.linearHeaderTotalAsset = addCurrencySymbolTotalAsset(currencySymbol, await formatNum(totalLegal));
    const todayProfit = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.todayProfit);
    const todayProfitWithSymbol = addCurrencySymbol(currencySymbol, todayProfit);
    $data.linearHeaderIncome = `${profitPrefix(data.todayProfit)}${todayProfitWithSymbol}/${fixRateHandleNull(data.todayProfitRate)}`;
    $data.linearHeaderIncomeColor = isHidden ? await getColor("kColorSecondaryText") : await riseColor(data.todayProfit);
}

async function updateCoinMBaseInfoData(data) {
    console.log("updateCoinMBaseInfoData");
    const currencySymbol = await getLegalCurrencySymbol();
    if (isHidden) {
        $data.coinMHeaderTotalAsset = HIDDEN_STR;
        $data.coinMHeaderIncome = HIDDEN_STR;
        return;
    }
    const totalLegal = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.balance);
    $data.coinMHeaderTotalAsset = addCurrencySymbolTotalAsset(currencySymbol, await formatNum(totalLegal));
    const todayProfit = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.todayProfit);
    const todayProfitWithSymbol = addCurrencySymbol(currencySymbol, todayProfit);
    $data.coinMHeaderIncome = `${profitPrefix(data.todayProfit)}${todayProfitWithSymbol}/${fixRateHandleNull(data.todayProfitRate)}`;
    $data.coinMHeaderIncomeColor = isHidden ? await getColor("kColorSecondaryText") : await riseColor(data.todayProfit);
}

async function updateCoinPBaseInfoData(data) {
    console.log("updateCoinPBaseInfoData");
    const currencySymbol = await getLegalCurrencySymbol();
    if (isHidden) {
        $data.coinPHeaderTotalAsset = HIDDEN_STR;
        $data.coinPHeaderIncome = HIDDEN_STR;
        return;
    }
    const totalLegal = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.balance);
    $data.coinPHeaderTotalAsset = addCurrencySymbolTotalAsset(currencySymbol, await formatNum(totalLegal));
    const todayProfit = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.todayProfit);
    const todayProfitWithSymbol = addCurrencySymbol(currencySymbol, todayProfit);
    $data.coinPHeaderIncome = `${profitPrefix(data.todayProfit)}${todayProfitWithSymbol}/${fixRateHandleNull(data.todayProfitRate)}`;
    $data.coinPHeaderIncomeColor = isHidden ? await getColor("kColorSecondaryText") : await riseColor(data.todayProfit);
}

async function updateOtcBaseInfo(data) {
    const currencySymbol = await getLegalCurrencySymbol();
    $data.fiatHeaderTitle = await getWord("n_asset_all_balance_convert");
    if (isHidden) {
        $data.otcTotalAsset = HIDDEN_STR;
        return;
    }
    const totalLegal = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.balance);
    $data.otcTotalAsset = addCurrencySymbolTotalAsset(currencySymbol, await formatNum(totalLegal));
}

async function updateCopyTradingBaseInfo(data) {
    const currencySymbol = await getLegalCurrencySymbol();
    if (isHidden) {
        $data.copyTradingTotal = HIDDEN_STR;
        $data.copyTradingHeaderIncome = HIDDEN_STR;
        return;
    }
    const totalLegal = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.balance);
    $data.copyTradingTotal = addCurrencySymbolTotalAsset(currencySymbol, await formatNum(totalLegal));
    const todayProfit = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.todayProfit);
    const todayProfitWithSymbol = addCurrencySymbol(currencySymbol, todayProfit);
    $data.copyTradingHeaderIncome = `${profitPrefix(data.todayProfit)}${todayProfitWithSymbol}/${fixRateHandleNull(data.todayProfitRate)}`;
    $data.copyTradingHeaderIncomeColor = isHidden ? await getColor("kColorSecondaryText") : await riseColor(data.todayProfit);
}

async function updateMarginAllInfo(data) {
    const currencySymbol = await getLegalCurrencySymbol();
    $data.marginAllHeaderTitle = await getWord("n_asset_all_balance_convert");
    if (isHidden) {
        $data.marginAllTotalAsset = HIDDEN_STR;
        return;
    }
    const totalLegal = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.balance);
    $data.marginAllTotalAsset = addCurrencySymbolTotalAsset(currencySymbol, await formatNum(totalLegal));
    $data.marginAllAccountType = "1";
    $data.marginAllRiskRate = data.riskRate;
    $data.marginAllRate = handlerAssetRiskRate(data.riskRate);
    $data.marginAllRateColor = getRiskStateColor(data.riskState);
}

function handlerAssetRiskRate(riskRate) {
    try {
        if (riskRate === null) {
            return "--";
        }
        if (Number.parseFloat(riskRate) >= 9.99) {
            return "≥999%";
        } else {
            return `${Math.ceil(Number.parseFloat(riskRate) * 100)}%`;
        }
    } catch (e) {
        console.error(`handlerAssetRiskRate AR${e}`);
        return "--";
    }
}

function getRiskStateColor(riskState) {
    if (riskState === null) {
        return "@color/eBaseColorThreeLevelText";
    }
    if (riskState == 0) {
        return "@color/baseCoinDangerousTip";
    } else if (riskState == 3) {
        return "@color/kColorPrimaryText";
    } else if (riskState == 2) {
        return "@color/kColorPrimaryText";
    } else if (riskState == 1) {
        return "@color/baseCoinDangerousTip";
    } else if (riskState == -1) {
        return "@color/baseCoinDangerousTip";
    }
    return "@color/kColorPrimaryText";
}

async function updateMarginPartBaseInfo(data) {
    const currencySymbol = await getLegalCurrencySymbol();
    $data.marginPartHeaderTitle = await getWord("n_asset_all_balance_convert");
    if (isHidden) {
        $data.marginPartTotalAsset = HIDDEN_STR;
        return;
    }
    const totalLegal = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.balance);
    $data.marginPartTotalAsset = addCurrencySymbolTotalAsset(currencySymbol, await formatNum(totalLegal));
}

async function updateContractUsdtMUnityData(oldList) {
    try {
        const data = [];
        let newData = [];
        let marginCross;
        console.log(`updateContractUsdtMUnityData A = ${oldList}`);
        const usdtList = [];
        const usdtMSeachKey = cacheData.contract.usdt_m_unity.all.searchKey;
        const usdtMHiddenSmallAsset = cacheData.contract.usdt_m_unity.all.hiddenSmallAsset;
        await Promise.all(oldList.map((async item => {
            if (item.marginMode === "cross") {
                item.secondSymbolName = await getWord("n_contract_super_margin");
                usdtList.push(item);
            } else if (await itemShouldShow(item.symbol, item.symbol, item.marginBalance, usdtMHiddenSmallAsset, usdtMSeachKey)) {
                data.push(item);
            }
        })));
        const sorted = await sortList(data, getEqualLegalCurrencyAmountForContractAllUsdtM);
        newData = [ ...usdtList, ...sorted ];
        cacheData.contract.usdt_m_unity.all.newList = newData;
        const currencySymbol = await getLegalCurrencySymbol();
        const assetList = await Promise.all(newData.map((async item => {
            try {
                const symbolIcon = await getIconUrl(item.symbol);
                const symbolName = item.symbol.toUpperCase();
                const currencyScale = item.currencyScale;
                const equityAmount = await getEqualLegalCurrencyAmount(symbolName, item.marginBalance);
                const equity = isHidden ? HIDDEN_STR : await addCurrentCurrencySymbol(equityAmount);
                const equityNumAmount = item.marginBalance == 0 ? "0.00" : await formatNumWithPrecision(item.marginBalance, currencyScale);
                const equityNum = isHidden ? HIDDEN_STR : equityNumAmount;
                const marginAvailableAmount = item.marginAvailable == 0 ? "0.00" : await formatNumWithPrecision(item.marginAvailable, currencyScale);
                const marginAvailable = isHidden ? HIDDEN_STR : marginAvailableAmount;
                const withdrawAvailableAmount = item.withdrawAvailable == 0 ? "0.00" : await formatNumWithPrecision(item.withdrawAvailable, currencyScale);
                const withdrawAvailable = isHidden ? HIDDEN_STR : withdrawAvailableAmount;
                const profitUnrealAmount = item.profitUnreal == 0 ? "0.00" : await formatNumWithPrecision(item.profitUnreal, currencyScale);
                const profitUnreal = isHidden ? HIDDEN_STR : `${profitUnrealAmount.startsWith("-") ? "" : "+"}${profitUnrealAmount}`;
                const profitUnrealRiseColor = isHidden ? await getColor("kColorSecondaryText") : await riseColor(item.profitUnreal);
                let voucherAvailable = null;
                let voucherVis = "gone";
                if (item.voucher != null) {
                    const voucherAmount = await formatNumWithPrecision(item.voucher, currencyScale);
                    voucherAvailable = isHidden ? HIDDEN_STR : voucherAmount;
                    voucherVis = "visible";
                }
                return {
                    symbolIcon: symbolIcon,
                    symbolName: symbolName,
                    equityNum: equityNum,
                    equityNumAmount: equityNumAmount,
                    equity: equity,
                    marginAvailable: marginAvailable,
                    marginAvailableAmount: marginAvailableAmount,
                    withdrawAvailable: withdrawAvailable,
                    withdrawAvailableAmount: withdrawAvailableAmount,
                    profitUnreal: profitUnreal,
                    profitUnrealRiseColor: profitUnrealRiseColor,
                    voucherAvailable: voucherAvailable,
                    voucherVis: voucherVis
                };
            } catch (e) {
                console.error(`updateContractUsdtMUnityData item ${e}`);
            }
        })));
        availables = assetList;
        console.log(`updateContractAllData usdtMUnity`);
        $data.usdtMAllAssetList = JSON.stringify(assetList);
    } catch (e) {
        console.error(`updateContractUsdtMUnityData AR${e}`);
    }
}

async function updateContractAllData(type, oldList) {
    try {
        const data = [];
        let newData = [];
        let marginCross;
        console.log(`updateContractAllData ${type}`);
        switch (type) {
          case DistributionType.usdtM:
            const usdtList = [];
            const usdtMSeachKey = cacheData.contract.usdt_m.all.searchKey;
            const usdtMHiddenSmallAsset = cacheData.contract.usdt_m.all.hiddenSmallAsset;
            await Promise.all(oldList.map((async item => {
                if (item.marginMode === "cross") {
                    item.secondSymbolName = await getWord("n_contract_super_margin");
                    usdtList.push(item);
                } else if (await itemShouldShow(item.symbol, item.symbol, item.marginBalance, usdtMHiddenSmallAsset, usdtMSeachKey)) {
                    data.push(item);
                }
            })));
            const sorted = await sortList(data, getEqualLegalCurrencyAmountForContractAllUsdtM);
            newData = [ ...usdtList, ...sorted ];
            cacheData.contract.usdt_m.all.newList = newData;
            break;

          case DistributionType.coinP:
            const coinPSearchKey = cacheData.contract.coin_p.all.searchKey;
            const coinPHiddenSmallAsset = cacheData.contract.coin_p.all.hiddenSmallAsset;
            await Promise.all(oldList.map((async item => {
                if (await itemShouldShow(item.symbol, item.symbol, item.marginBalance, coinPHiddenSmallAsset, coinPSearchKey)) {
                    data.push(item);
                }
            })));
            newData = await sortList(data, getEqualLegalCurrencyAmountForContractAll);
            cacheData.contract.coin_p.all.newList = newData;
            break;

          case DistributionType.coinFutures:
            const searchKey = cacheData.contract.coin_f.all.searchKey;
            const hiddenSmallAsset = cacheData.contract.coin_f.all.hiddenSmallAsset;
            await Promise.all(oldList.map((async item => {
                if (await itemShouldShow(item.symbol, item.symbol, item.marginBalance, hiddenSmallAsset, searchKey)) {
                    data.push(item);
                }
            })));
            newData = await sortList(data, getEqualLegalCurrencyAmountForContractAll);
            cacheData.contract.coin_f.all.newList = newData;
            break;
        }
        const currencySymbol = await getLegalCurrencySymbol();
        const assetList = await Promise.all(newData.map((async item => {
            try {
                const symbolIcon = await getIconUrl(item.symbol);
                const symbolName = item.symbol.toUpperCase();
                let secondSymbolName;
                if (item.secondSymbolName) {
                    secondSymbolName = item.secondSymbolName;
                } else {
                    if (type == DistributionType.usdtM) {
                        const secondSymbol = await getContractSecondSymbol(item.contractCode);
                        if (secondSymbol !== "") {
                            secondSymbolName = `/${secondSymbol}`;
                        } else {
                            secondSymbolName = "/USDT";
                        }
                    } else {
                        secondSymbolName = "/USD";
                    }
                }
                let spotNumberEquivalent;
                if (type == DistributionType.usdtM) {
                    spotNumberEquivalent = isHidden ? HIDDEN_STR : fixRate(item.riskRate);
                } else {
                    spotNumberEquivalent = isHidden ? HIDDEN_STR : fixRateFixed(item.newRiskRate, 4);
                }
                const available = await getEqualLegalCurrencyAmount(item.symbol, item.marginAvailable);
                const availableAmount = isHidden ? HIDDEN_STR : addCurrencySymbol(currencySymbol, available);
                const spotYield = isHidden ? HIDDEN_STR : await getPreCurrencyAmount(item.symbol, item.marginBalance);
                const equalLegalAmount = await getEqualLegalCurrencyAmount(type == DistributionType.usdtM ? Symbols.usdt : item.symbol, item.marginBalance);
                const spotYieldRate = isHidden ? HIDDEN_STR : addCurrencySymbol(currencySymbol, equalLegalAmount);
                const spotRiseColor = isHidden ? await getColor("kColorSecondaryText") : await riseColor(spotYieldRate);
                return {
                    symbolIcon: symbolIcon,
                    symbolName: symbolName,
                    secondSymbolName: secondSymbolName,
                    spotNumberEquivalent: spotNumberEquivalent,
                    spotYield: spotYield,
                    availableAmount: availableAmount,
                    spotYieldRate: spotYieldRate,
                    spotRiseColor: spotRiseColor
                };
            } catch (e) {
                console.error(`updateContractAllData item ${e}`);
            }
        })));
        switch (type) {
          case DistributionType.usdtM:
            console.log(`updateContractAllData usdtM`);
            $data.usdtMAllAssetList = JSON.stringify(assetList);
            break;

          case DistributionType.coinP:
            console.log(`updateContractAllData coinP`);
            $data.coinPAllAssetList = JSON.stringify(assetList);
            break;

          case DistributionType.coinFutures:
            console.log(`updateContractAllData coinFutures`);
            $data.coinMAllAssetList = JSON.stringify(assetList);
            break;
        }
    } catch (e) {
        console.error(`updateContractAllData ${e}`);
    }
}

async function updateContractOwnedData(type, oldList) {
    console.log(`updateContractOwnedData ${type}`);
    const data = [];
    let newData = [];
    switch (type) {
      case DistributionType.usdtM:
        const usdtMSeachKey = cacheData.contract.usdt_m.owned.searchKey;
        const usdtMHiddenSmallAsset = cacheData.contract.usdt_m.owned.hiddenSmallAsset;
        await Promise.all(oldList.map((async item => {
            if (await itemShouldShow(item.symbol, item.symbol, item.profit, usdtMHiddenSmallAsset, usdtMSeachKey)) {
                data.push(item);
            }
        })));
        newData = await sortList(data, getEqualLegalCurrencyAmountForContractOwned);
        cacheData.contract.usdt_m.owned.newList = newData;
        break;

      case DistributionType.coinP:
        const coinPSearchKey = cacheData.contract.coin_p.owned.searchKey;
        const coinPHiddenSmallAsset = cacheData.contract.coin_p.owned.hiddenSmallAsset;
        await Promise.all(oldList.map((async item => {
            if (await itemShouldShow(item.symbol, item.symbol, item.profit, coinPHiddenSmallAsset, coinPSearchKey)) {
                data.push(item);
            }
        })));
        newData = await sortList(data, getEqualLegalCurrencyAmountForContractOwned);
        cacheData.contract.coin_p.owned.newList = newData;
        break;

      case DistributionType.coinFutures:
        const searchKey = cacheData.contract.coin_f.owned.searchKey;
        const hiddenSmallAsset = cacheData.contract.coin_f.owned.hiddenSmallAsset;
        await Promise.all(oldList.map((async item => {
            if (await itemShouldShow(item.symbol, item.symbol, item.profit, hiddenSmallAsset, searchKey)) {
                data.push(item);
            }
        })));
        newData = await sortList(data, getEqualLegalCurrencyAmountForContractOwned);
        cacheData.contract.coin_f.owned.newList = newData;
        break;
    }
    const greenRise = await upsAndDownsColor();
    const assetList = await Promise.all(newData.map((async item => {
        try {
            let longOrShortColor;
            let longOrShortBackGroundColor = 0;
            let buyOrSellBackGroundColor = 0;
            let longOrShort = "";
            let buyOrSell = "";
            if (item.direction === "buy") {
                longOrShortColor = "@color/trade_tag_text_color";
                longOrShortBackGroundColor = "@color/trade_tag_text_bg";
                buyOrSellBackGroundColor = riseColorV2(1, greenRise);
                buyOrSell = isChinese() ? "买" : "B";
                longOrShort = $i18n.n_asset_future_buy;
            } else {
                longOrShortColor = "@color/trade_st_color";
                longOrShortBackGroundColor = "@color/trade_st_color_bg";
                buyOrSellBackGroundColor = riseColorV2(-1, greenRise);
                buyOrSell = isChinese() ? "卖" : "S";
                longOrShort = $i18n.n_asset_future_sell;
            }
            const symbolName = item.symbol.toUpperCase();
            let isolated;
            if (item.marginMode == "cross") {
                isolated = $i18n.n_contract_super_margin;
            } else {
                isolated = $i18n.n_contract_trade_margin;
            }
            const isolatedNumber = `${item.leverRate}X`;
            let isolatedName;
            if ("swap" == item.contractType) {
                isolatedName = $i18n.n_market_contract_swap_trade_name_abbr;
            } else if ("this_week" == item.contractType) {
                isolatedName = $i18n.n_market_contract_symbol_thisweek_abbr;
            } else if ("next_week" == item.contractType) {
                isolatedName = $i18n.n_market_contract_symbol_nextweek_abbr;
            } else if ("quarter" == item.contractType) {
                isolatedName = $i18n.n_market_contract_symbol_quarter_abbr;
            } else if ("next_ quarter" == item.contractType) {
                isolatedName = $i18n.n_market_contract_symbol_nextweek_abbr;
            }
            let secondSymbolName;
            let symbolNameFull;
            if (type == DistributionType.usdtM) {
                const secondSymbol = await getContractSecondSymbol(item.contractCode);
                if (secondSymbol !== "") {
                    secondSymbolName = `/${secondSymbol}`;
                    symbolNameFull = `${symbolName}${secondSymbol}`;
                } else {
                    secondSymbolName = "/USDT";
                    symbolNameFull = symbolName + "USDT";
                }
            } else {
                secondSymbolName = "/USD";
                symbolNameFull = symbolName + "USD";
            }
            const openAdl = item.openAdl && item.openAdl == 1 ? "visible" : "gone";
            let adlRiskSrc = "@drawable/adl_percent_icon_1";
            if (item.adlRiskPercent) {
                adlRiskSrc = `@drawable/adl_percent_icon_${item.adlRiskPercent}`;
            }
            const prefix = profitPrefix(item.profit);
            const rawProfit = removeTrailingZeroes(await formatNumWithPrecision(item.profit, 4));
            const profit = isHidden ? HIDDEN_STR : `${prefix}${rawProfit}`;
            const spotNumberEquivalent = isHidden ? HIDDEN_STR : `${prefix}${await addCurrentCurrencySymbol(await getEqualLegalCurrencyAmount(Symbols.usdt, item.profit))}`;
            const spotYield = isHidden ? HIDDEN_STR : `${prefix}${fixRate(item.profitRate)}`;
            const isRisk = "gone";
            const suffix = type == DistributionType.usdtM ? "USDT" : "USD";
            const currencySuffix = type == DistributionType.usdtM ? "USDT" : symbolName;
            const contractTitle1_1 = `${$i18n.n_option_market_list_setting_position_volume}(${currencySuffix})`;
            const contractTitle2_1 = isHidden ? HIDDEN_STR : await getContractNumber(item.symbol, item.contractCode, item.volume, type, item.lastPrice);
            const contractTitle3_1 = `${$i18n.n_contarct_position_cost_open_label2}(${suffix})`;
            const contractTitle4_1 = isHidden ? HIDDEN_STR : await getPreCurrencyAmount(Symbols.usdt, item.costOpen);
            const contractTitle1_2 = await getWordFormat("n_contarct_position_original_margin", suffix);
            const contractTitle2_2 = isHidden ? HIDDEN_STR : await getPreCurrencyAmount(Symbols.usdt, item.positionMargin);
            const contractTitle3_2 = `${$i18n.n_contract_last_price}(${suffix})`;
            const contractTitle4_2 = isHidden ? HIDDEN_STR : `${item.lastPrice}`;
            const contractTitle1_3 = $i18n.n_asset_margin_rate;
            const contractTitle2_3 = isHidden ? HIDDEN_STR : fixRateFixed(item.riskRate, 4);
            const contractTitle3_3 = `${$i18n.n_balance_contract_prediction_of_strong_parity}(${suffix})`;
            const contractTitle4_3 = isHidden ? HIDDEN_STR : item.liquidationPrice ? `${item.liquidationPrice}` : "--";
            const spotRiseColor = isHidden ? "@color/kColorSecondaryText" : riseColorV2(spotYield, greenRise);
            return {
                longOrShortColor: longOrShortColor,
                longOrShortBackGroundColor: longOrShortBackGroundColor,
                buyOrSellBackGroundColor: buyOrSellBackGroundColor,
                longOrShort: longOrShort,
                buyOrSell: buyOrSell,
                isolated: isolated,
                isolatedNumber: isolatedNumber,
                isolatedName: isolatedName,
                spotNumberEquivalent: spotNumberEquivalent,
                spotYield: spotYield,
                isRisk: isRisk,
                contractTitle1_1: contractTitle1_1,
                contractTitle2_1: contractTitle2_1,
                contractTitle3_1: contractTitle3_1,
                contractTitle4_1: contractTitle4_1,
                contractTitle1_2: contractTitle1_2,
                contractTitle2_2: contractTitle2_2,
                contractTitle3_2: contractTitle3_2,
                contractTitle4_2: contractTitle4_2,
                contractTitle1_3: contractTitle1_3,
                contractTitle2_3: contractTitle2_3,
                contractTitle3_3: contractTitle3_3,
                contractTitle4_3: contractTitle4_3,
                symbolName: symbolName,
                secondSymbolName: secondSymbolName,
                symbolNameFull: symbolNameFull,
                spotRiseColor: spotRiseColor,
                profit: profit,
                openAdl: openAdl,
                adlRiskSrc: adlRiskSrc
            };
        } catch (e) {
            console.log(`updateContractOwnedData item ${e}`);
        }
    })));
    switch (type) {
      case DistributionType.usdtM:
        $data.usdtMOwnAssetList = JSON.stringify(assetList);
        break;

      case DistributionType.coinP:
        $data.coinPOwnAssetList = JSON.stringify(assetList);
        break;

      case DistributionType.coinFutures:
        $data.coinMOwnAssetList = JSON.stringify(assetList);
        break;
    }
}

async function updateOtcData(oldList) {
    const data = [];
    const searchKey = cacheData.otc.searchKey;
    const hiddenSmallAsset = cacheData.otc.hiddenSmallAsset;
    await Promise.all(oldList.map((async item => {
        if (await itemShouldShow(item.coinName, item.coinName, item.total, hiddenSmallAsset, searchKey)) {
            data.push(item);
        }
    })));
    const sortData = await sortList(data, getEqualLegalCurrencyAmountForOtc);
    cacheData.otc.newList = sortData;
    const list = await Promise.all(sortData.map((async item => ({
        symbolIcon: await getIconUrl(item.coinName),
        symbolName: item.coinName,
        faitFreeze: isHidden ? HIDDEN_STR : await getPreCurrencyAmount(item.coinName, item.frozen),
        faitAvailable: isHidden ? HIDDEN_STR : await getPreCurrencyAmount(item.coinName, item.total),
        faitValue: isHidden ? HIDDEN_STR : await addCurrentCurrencySymbol(await getEqualLegalCurrencyAmount(item.coinName, item.total))
    }))));
    $data.otcList = JSON.stringify(list);
}

async function updateOptionData(oldList) {
    if (oldList) {
        const data = [];
        const searchKey = cacheData.option.searchKey;
        const hiddenSmallAsset = cacheData.option.hiddenSmallAsset;
        await Promise.all(oldList.map((async item => {
            if (await itemShouldShow(item.currency, item.currency, item.availableNum, hiddenSmallAsset, searchKey)) {
                data.push(item);
            }
        })));
        const newData = await sortList(data, getEqualLegalCurrencyAmountForOption);
        cacheData.option.newList = newData;
        const list = await Promise.all(newData.map((async item => ({
            symbolIcon: await getIconUrl(item.currency),
            symbolName: item.currency.toUpperCase(),
            spotNumberEquivalent: isHidden ? HIDDEN_STR : await getPreCurrencyAmount(item.currency, item.positionNum),
            spotYield: isHidden ? HIDDEN_STR : await getPreCurrencyAmount(item.currency, item.availableNum),
            spotYieldRate: isHidden ? HIDDEN_STR : await addCurrentCurrencySymbol(await getEqualLegalCurrencyAmount(item.currency, item.availableNum))
        }))));
        console.error(TAG, `getOptionDataSucceed, list=${list}`);
        $data.optionList = JSON.stringify(list);
    }
}

async function updateEarnHighData(type, oldList) {
    console.log(`updateEarnHighData oldList ${type} ${JSON.stringify(oldList)}`);
    try {
        if (oldList && typeof oldList === "object" && oldList.constructor === Array && oldList.length) {
            const data = [];
            let newData = [];
            const searchKey = cacheData.earn.earnHigh.searchKey;
            const hiddenSmallAsset = cacheData.earn.earnHigh.hiddenSmallAsset;
            await Promise.all(oldList.map((async item => {
                if (await itemShouldShow(item.currency, item.currency, item.miningAmount, hiddenSmallAsset, searchKey)) {
                    data.push(item);
                }
            })));
            newData = await sortList(data, getEqualLegalCurrencyAmountForEarn);
            cacheData.earn.earnHigh.newList = newData;
            const list = await Promise.all(newData.map((async (item, index) => {
                const yesterdayIncomeAmount = await getEqualLegalCurrencyAmount(Symbols.usdt, item.yesterdayIncomeAmount);
                return {
                    type: "1",
                    index: index,
                    visible: index == lastPosition ? $data.earnHighList[lastPosition].visible : "gone",
                    symbolIcon: await getIconUrl(item.currency),
                    symbolName: item.currency.toUpperCase(),
                    spotNumberEquivalent: isHidden ? HIDDEN_STR : await addCurrentCurrencySymbol(await getEqualLegalCurrencyAmount(Symbols.usdt, item.positionAmount)),
                    spotNumber: isHidden ? HIDDEN_STR : await getPreCurrencyAmount(item.currency, item.positionBalance),
                    spotYesterdayYield: isHidden ? HIDDEN_STR : `${yesterdayIncomeAmount.startsWith("-") ? "" : "+"}${await addCurrentCurrencySymbol(yesterdayIncomeAmount)}`,
                    spotYesterdayNumber: isHidden ? HIDDEN_STR : `${yesterdayIncomeAmount.startsWith("-") ? "" : "+"}${await getPreCurrencyAmount(item.currency, item.yesterdayIncome)}`,
                    spotExYearRate: isHidden ? HIDDEN_STR : fixRate(item.totalYearRate),
                    spotExDebts: isHidden ? HIDDEN_STR : item.termTranslate,
                    spotSubscriptionNumber: isHidden ? HIDDEN_STR : await getPreCurrencyAmount(item.currency, item.subscriptionBalance),
                    amountRiseColor: isHidden ? await getColor("kColorSecondaryText") : await riseColor(yesterdayIncomeAmount)
                };
            })));
            console.error(TAG, `getEarnHighDataSucceed, JSON.stringify(list)=${JSON.stringify(list)}`);
            $data.earnHighList = list;
        } else {
            $data.earnHighList = [ {
                type: "2"
            } ];
        }
    } catch (e) {
        console.error(`updateEarnHighData ${e}`);
    }
}

async function updateEarnNodePledgeData(type, oldList) {
    console.log(`updateEarnNodePledge oldList ${type} ${JSON.stringify(oldList)}`);
    try {
        if (oldList && typeof oldList === "object" && oldList.constructor === Array && oldList.length) {
            const data = [];
            let newData = [];
            const searchKey = cacheData.earn.earnNodePledge.searchKey;
            const hiddenSmallAsset = cacheData.earn.earnNodePledge.hiddenSmallAsset;
            await Promise.all(oldList.map((async item => {
                if (await itemShouldShow(item.currency, item.currency, item.miningAmount, hiddenSmallAsset, searchKey)) {
                    data.push(item);
                }
            })));
            newData = await sortList(data, getEqualLegalCurrencyAmountForEarn);
            cacheData.earn.earnNodePledge.newList = newData;
            const list = await Promise.all(newData.map((async (item, index) => {
                const yesterdayIncomeAmount = await getEqualLegalCurrencyAmount(Symbols.usdt, item.yesterdayIncomeAmount);
                const earnAmount = await getEqualLegalCurrencyAmount(Symbols.usdt, item.totalIncomeAmount);
                return {
                    type: "1",
                    index: index,
                    visible: index == nodePledgeLastPosition ? $data.earnNodePledgeList[nodePledgeLastPosition].visible : "gone",
                    symbolIcon: await getIconUrl(item.currency),
                    symbolName: item.currency.toUpperCase(),
                    spotNumberEquivalent: isHidden ? HIDDEN_STR : await addCurrentCurrencySymbol(await getEqualLegalCurrencyAmount(Symbols.usdt, item.positionAmount)),
                    spotNumber: isHidden ? HIDDEN_STR : await getPreCurrencyAmount(item.currency, item.positionBalance),
                    totalEarnAndQuantity: isHidden ? `${HIDDEN_STR}\n${HIDDEN_STR}` : await getTotalEarnAndQuantity(item.currency, earnAmount, item.totalIncomeBalance),
                    spotYesterdayYield: isHidden ? HIDDEN_STR : `${yesterdayIncomeAmount.startsWith("-") ? "" : "+"}${await addCurrentCurrencySymbol(yesterdayIncomeAmount)}`,
                    spotYesterdayNumber: isHidden ? HIDDEN_STR : `${yesterdayIncomeAmount.startsWith("-") ? "" : "+"}${await getPreCurrencyAmount(item.currency, item.yesterdayIncome)}`,
                    spotExYearRate: isHidden ? HIDDEN_STR : fixRate(item.totalYearRate),
                    spotExDebts: isHidden ? HIDDEN_STR : item.termTranslate,
                    spotSubscriptionNumber: isHidden ? HIDDEN_STR : await getPreCurrencyAmount(item.currency, item.subscriptionBalance),
                    amountRiseColor: isHidden ? await getColor("kColorSecondaryText") : await riseColor(yesterdayIncomeAmount),
                    earnAndQuantityColor: isHidden ? await getColor("kColorSecondaryText") : await riseColor(earnAmount)
                };
            })));
            console.error(TAG, `getEarnNodePledgeDataSucceed, JSON.stringify(list)=${JSON.stringify(list)}`);
            $data.earnNodePledgeList = list;
        } else {
            $data.earnNodePledgeList = [ {
                type: "2"
            } ];
        }
    } catch (e) {
        console.error(`updateEarnNodePledgeData ${e}`);
    }
}

async function updateEarnSharkFinData(type, oldList) {
    console.log(`updateEarnSharkFinData oldList ${type} ${JSON.stringify(oldList)}`);
    try {
        if (oldList && typeof oldList === "object" && oldList.constructor === Array && oldList.length) {
            const data = [];
            let newData = [];
            const searchKey = cacheData.earn.earnSharkFin.searchKey;
            const hiddenSmallAsset = cacheData.earn.earnSharkFin.hiddenSmallAsset;
            await Promise.all(oldList.map((async item => {
                if (await itemShouldShow(item.currency, item.currency, item.miningAmount, hiddenSmallAsset, searchKey)) {
                    data.push(item);
                }
            })));
            newData = await sortList(data, getEqualLegalCurrencyAmountForEarn);
            cacheData.earn.earnSharkFin.newList = newData;
            const list = await Promise.all(newData.map((async (item, index) => ({
                type: "1",
                index: index,
                visible: index == sharkFinLastPosition ? "visible" : "gone",
                symbolIcon: await getIconUrl(item.currency),
                symbolName: item.currency.toUpperCase(),
                projectName: item.projectName,
                spotNumberEquivalent: isHidden ? HIDDEN_STR : await addCurrentCurrencySymbol(await getEqualLegalCurrencyAmount(Symbols.usdt, item.positionAmount)),
                spotNumber: isHidden ? HIDDEN_STR : await getPreCurrencyAmount(item.currency, item.positionBalance),
                translateEarnRate: isHidden ? HIDDEN_STR : item.productStatus == 2 ? item.totalYearRateTranslate : `${item.translateMinYearRate}-${item.translateMaxYearRate}`,
                incomeTime: isHidden ? HIDDEN_STR : item.incomeTime,
                termTranslate: isHidden ? HIDDEN_STR : item.termTranslate,
                productTranslateStatus: isHidden ? HIDDEN_STR : item.productTranslateStatus
            }))));
            console.error(TAG, `getEarnSharkFinDataSucceed, JSON.stringify(list)=${JSON.stringify(list)}`);
            $data.earnSharkFinList = list;
        } else {
            console.log(`updateEarnSharkFinData type 2`);
            $data.earnSharkFinList = [ {
                type: "2"
            } ];
        }
    } catch (e) {
        console.error(`updateEarnSharkFinData ${e}`);
    }
}

async function updateEarnData(type, oldList) {
    console.log(`updateEarnData ${type} ${JSON.stringify(oldList)}`);
    try {
        if (oldList) {
            const data = [];
            let newData = [];
            if (type == 0) {
                const ybbSearchKey = cacheData.earn.earnYbb.searchKey;
                const ybbHiddenSmallAsset = cacheData.earn.earnYbb.hiddenSmallAsset;
                await Promise.all(oldList.map((async item => {
                    if (await itemShouldShow(item.currency, item.currency, item.miningAmount, ybbHiddenSmallAsset, ybbSearchKey)) {
                        data.push(item);
                    }
                })));
                newData = await sortList(data, getEqualLegalCurrencyAmountForEarn);
                cacheData.earn.earnYbb.newList = newData;
            } else {
                const searchKey = cacheData.earn.earnFixed.searchKey;
                const hiddenSmallAsset = cacheData.earn.earnFixed.hiddenSmallAsset;
                await Promise.all(oldList.map((async item => {
                    if (await itemShouldShow(item.currency, item.currency, item.miningAmount, hiddenSmallAsset, searchKey)) {
                        data.push(item);
                    }
                })));
                newData = await sortList(data, getEqualLegalCurrencyAmountForEarn);
                cacheData.earn.earnFixed.newList = newData;
            }
            const list = await Promise.all(newData.map((async item => {
                const spotExYield = await getEqualLegalCurrencyAmount(item.currency, item.totalIncomeAmount);
                const spotExYieldStr = await addCurrentCurrencySymbol(spotExYield);
                const earnExNumber = type == "0" ? await getPreCurrencyAmount(item.currency, item.miningAmount) : await addCurrentCurrencySymbol(await getEqualLegalCurrencyAmount(item.currency, item.confirmedFixedTotalInterest));
                const ybbExYield = `${item.totalIncomeAmount >= 0 ? "+" : "-"}${spotExYieldStr}`;
                const fixedExYield = `${item.proIncomeAmount >= 0 ? "+" : "-"}${await addCurrentCurrencySymbol(await getEqualLegalCurrencyAmount(item.currency, item.proIncomeAmount))}`;
                const ybbExYieldRate = `${item.totalIncomeAmount >= 0 ? "+" : "-"}${await getPreCurrencyAmount(item.currency, item.totalIncomeAmount)}`;
                const fixedExYieldRate = `${item.proIncomeAmount >= 0 ? "+" : "-"}${await getPreCurrencyAmount(item.currency, item.proIncomeAmount)}`;
                const ybbSpotYield = await getEqualLegalCurrencyAmount(item.currency, item.yesterdayIncome);
                const ybbSpotYieldRate = await getPreCurrencyAmount(item.currency, item.yesterdayIncome);
                const fixedSpotYield = await getEqualLegalCurrencyAmount(item.currency, item.estFixedTodayInterest);
                const fixedSpotYieldRate = await getPreCurrencyAmount(item.currency, item.estFixedTodayInterest);
                const ybbSpotYieldOperator = `${spotExYield.startsWith("-") ? "" : "+"}${await addCurrentCurrencySymbol(await getEqualLegalCurrencyAmount(item.currency, item.yesterdayIncome))}`;
                const ybbSpotYieldRateOperator = `${spotExYield.startsWith("-") ? "" : "+"}${await getPreCurrencyAmount(item.currency, item.yesterdayIncome)}`;
                const fixedSpotYieldOperator = `${spotExYield.startsWith("-") ? "" : "+"}${await addCurrentCurrencySymbol(await getEqualLegalCurrencyAmount(item.currency, item.estFixedTodayInterest))}`;
                const fixedSpotYieldRateOperator = `${spotExYield.startsWith("-") ? "" : "+"}${await getPreCurrencyAmount(item.currency, item.estFixedTodayInterest)}`;
                const ybbSpotYieldRateColor = await riseColor(ybbSpotYield);
                const fixedSpotYieldRateColor = await riseColor(fixedSpotYield);
                const ybbExRiseColor = await riseColor(spotExYield);
                const ybbFixedExRiseColor = await riseColor(await getEqualLegalCurrencyAmount(item.currency, item.proIncomeAmount));
                let label = await getWord("n_mining_asset_fixed");
                if (item.orderShowLabelType === 1) {
                    label = await getWord("n_asset_earn_new_coin");
                } else if (item.orderShowLabelType === 0) {
                    label = await getWord("n_asset_earn_label_optimization");
                } else if (item.orderShowLabelType === 2) {
                    label = await getWord("n_mining_fixed");
                }
                const showVIP = item.tag != null && item.tag == 8 ? "visible" : "gone";
                let vipIcon = "@drawable/edge_engine_earn_vip_icon_other";
                if (commonData.language.toLowerCase() == "zh-cn" || commonData.language.toLowerCase() == "zh-hk") {
                    vipIcon = "@drawable/edge_engine_earn_vip_icon";
                }
                return {
                    symbolIcon: await getIconUrl(item.currency),
                    symbolName: item.currency.toUpperCase(),
                    isLoan: item.projectType == "0" ? "gone" : "visible",
                    spotNumberEquivalent: isHidden ? HIDDEN_STR : await addCurrentCurrencySymbol(await getEqualLegalCurrencyAmount(item.currency, item.totalAmount)),
                    spotNumber: isHidden ? HIDDEN_STR : await getPreCurrencyAmount(item.currency, item.totalAmount),
                    spotYield: isHidden ? HIDDEN_STR : type == "0" ? ybbSpotYieldOperator : fixedSpotYieldOperator,
                    spotYieldRate: isHidden ? HIDDEN_STR : type == "0" ? ybbSpotYieldRateOperator : fixedSpotYieldRateOperator,
                    spotExAvailable: isHidden ? HIDDEN_STR : fixRate(item.miningYearRate),
                    spotExDebts: type == "0" ? await getWord("n_asset_earn_current") : await getWordFormat("n_c2c_lend_days", item.term),
                    spotExPrice: isHidden ? HIDDEN_STR : earnExNumber,
                    spotExCost: isHidden ? HIDDEN_STR : item.confirmedFixedTotalInterest,
                    spotExYield: isHidden ? HIDDEN_STR : type == "0" ? ybbExYield : fixedExYield,
                    spotExYieldRate: isHidden ? HIDDEN_STR : type == "0" ? ybbExYieldRate : fixedExYieldRate,
                    loanLabel: label,
                    spotRiseColor: isHidden ? await getColor("kColorSecondaryText") : type == "0" ? ybbSpotYieldRateColor : fixedSpotYieldRateColor,
                    ybbExRiseColor: isHidden ? await getColor("kColorSecondaryText") : type == "0" ? ybbExRiseColor : ybbFixedExRiseColor,
                    amountRiseColor: isHidden ? await getColor("kColorSecondaryText") : type == "0" ? await riseColor(item.yesterdayIncome) : await riseColor(item.estFixedTodayInterest),
                    amountExRiseColor: isHidden ? await getColor("kColorSecondaryText") : type == "0" ? await riseColor(item.totalIncomeAmount) : await riseColor(item.proIncomeAmount),
                    showVIP: showVIP,
                    vipIcon: vipIcon
                };
            })));
            console.error(TAG, `getEarnDataSucceed, list=${JSON.stringify(list)}`);
            if (type == "0") {
                $data.earnYbbList = JSON.stringify(list);
            } else {
                $data.earnFixedList = JSON.stringify(list);
            }
        }
    } catch (e) {
        console.error(`updateEarnData ${e}`);
    }
}

async function updateMarginAllData(oldList) {
    if (oldList) {
        const data = [];
        const searchKey = cacheData.margin.allRepo.searchKey;
        const hiddenSmallAsset = cacheData.margin.allRepo.hiddenSmallAsset;
        await Promise.all(oldList.map((async item => {
            if (await itemShouldShow(item.symbolName, item.symbolName, item.available, hiddenSmallAsset, searchKey)) {
                data.push(item);
            }
        })));
        const newData = await sortList(data, getEqualLegalCurrencyAmountForMarginAll);
        cacheData.margin.allRepo.newList = newData;
        console.log(`updateMarginAllData`);
        const list = await Promise.all(newData.map((async item => ({
            symbolIcon: item.symbolIcon,
            symbolName: item.symbolName,
            spotNumberEquivalent: isHidden ? HIDDEN_STR : item.available,
            spotYield: isHidden ? HIDDEN_STR : await addCurrentCurrencySymbol(await getEqualLegalCurrencyAmount(item.symbolName, item.estimation)),
            spotYieldRate: isHidden ? HIDDEN_STR : item.freeze,
            spotNumber: isHidden ? HIDDEN_STR : item.borrowed
        }))));
        $data.longLevelDataList = JSON.stringify(list);
    }
}

async function updateMarginPartData(oldList) {
    if (oldList) {
        const data = [];
        const searchKey = cacheData.margin.partRepo.searchKey;
        const hiddenSmallAsset = cacheData.margin.partRepo.hiddenSmallAsset;
        await Promise.all(oldList.map((async item => {
            const baseAva = await getEqualLegalCurrencyAmount(item.baseCurrency, item.baseEstimation);
            const quoteAva = await getEqualLegalCurrencyAmount(item.quoteCurrency, item.quoteEstimation);
            const marginEquivalent = getFullNum(Number.parseFloat(baseAva) + Number.parseFloat(quoteAva));
            item.marginEquivalentFixed = Number(marginEquivalent).toFixed(2);
            if (await itemShouldShow(item.displayName, item.quoteCurrencyDisplayName, item.marginEquivalentFixed, hiddenSmallAsset, searchKey)) {
                data.push(item);
            }
        })));
        const newData = await sortList(data, getEqualLegalCurrencyAmountForMarginPart);
        cacheData.margin.partRepo.newList = newData;
        const list = await Promise.all(newData.map((async item => ({
            symbolIcon: item.symbolIcon,
            symbolName: item.displayName,
            baseSymbolName: item.baseCurrencyDisplayName,
            quoteSymbolName: `/${item.quoteCurrencyDisplayName}`,
            riskText: item.riskRateStateText,
            riskTextColor: item.riskRateStateColor,
            riskTextBg: item.riskRateStateBg,
            marginPrice: isHidden ? HIDDEN_STR : await addCurrentCurrencySymbol(item.marginEquivalentFixed),
            baseSymbolName: item.baseCurrencyDisplayName,
            baseAvailable: isHidden ? HIDDEN_STR : item.baseAvailable,
            baseBorrowed: isHidden ? HIDDEN_STR : item.baseBorrowedAndFreeze,
            chaseSymbolName: item.quoteCurrencyDisplayName,
            chaseAvailable: isHidden ? HIDDEN_STR : item.quoteAvailable,
            chaseBorrowed: isHidden ? HIDDEN_STR : item.quoteBorrowedAndFreeze
        }))));
        $data.shortLevelDataList = JSON.stringify(list);
    }
}

function assetThirdTypeEvent(type, isAll) {
    console.log(`assetThirdTypeEvent ${isAll}`);
    switch (type) {
      case DistributionType.usdtM:
        usdtMAll = isAll;
        break;

      case DistributionType.coinP:
        coinPAll = isAll;
        break;

      case DistributionType.coinFutures:
        coinMAll = isAll;
        break;
    }
    updatePageListByType(currentDistributionType);
}

async function assetTabEvent(account, refresh = true, updateType = true) {
    if (updateType) {
        currentDistributionType = account;
        updatePageListHeaderByType(account);
        updatePageListByType(account);
    }
    console.log(`assetTabEvent ${account} ${refresh} ${updateType}`);
    if (!refresh) {
        return;
    }
    switch (account) {
      case DistributionType.spot:
        console.log("getSpotAccountInfo 1");
        getSpotAccountInfo(account);
        break;

      case DistributionType.bot:
        console.log("getSpotAccountInfo bot");
        getSpotBotInfo();
        break;

      case DistributionType.collateral:
        console.log("getSpotAccountInfo collateral");
        getSpotCollateralInfo(account);
        break;

      case DistributionType.usdtM:
        isContractOpenConfig ? getContractUsdtMUnity() : getContractUsdtM();
        break;

      case DistributionType.contractCopy:
        getCopyTradingData();
        break;

      case DistributionType.coinP:
        getContractCoinPerpetual();
        break;

      case DistributionType.coinFutures:
        getContractCoinFutures();
        break;

      case DistributionType.otc:
        getOTCData();
        break;

      case DistributionType.option:
        getOptionData();
        break;

      case DistributionType.earn:
        getEarnData("0");
        break;

      case DistributionType.earnFixed:
        getEarnData("1");
        break;

      case DistributionType.earnHigh:
        getEarnData("3");
        break;

      case DistributionType.earnNodePledge:
        getEarnData("4");
        break;

      case DistributionType.earnSharkFin:
        getEarnData("5");
        break;

      case DistributionType.allRepo:
        getMarginAll();
        break;

      case DistributionType.partRepo:
        getMarginPart();
        break;

      case DistributionType.contractGrid:
        console.log("getContractGridData");
        getContractGridData();
        break;
    }
}

var sortType = 0;

var sortSequence = 0;

async function sortEvent(args) {
    const params = JSON.parse(args);
    sortSequence = params.sortSequence;
    sortType = params.type;
    updateSpotCurrenciesData(cacheData.spot.spot.currencies, 0);
}

async function sortBotEvent(args) {
    const params = JSON.parse(args);
    params.sortSequence;
    params.type;
    updateBotCurrenciesData(cacheData.spot.bot.currencies);
}

async function sortSpotList(list) {
    const zeroCurrencies = [];
    const notZeroCurrencies = [];
    list.filter((item => {
        if (item.balance === 0) {
            zeroCurrencies.push(item);
        } else {
            notZeroCurrencies.push(item);
        }
    }));
    const noneCurrencies = await Promise.all(notZeroCurrencies.map((async item => {
        try {
            return {
                sortKey: await getEqualLegalCurrencyAmount(item.currency, item.positionNum),
                ...item
            };
        } catch (e) {
            console.error(`bot notZeroCurrencies.map ${e}`);
            return {};
        }
    })));
    noneCurrencies.sort(((a, b) => {
        if (sortSequence === 1) {
            if (sortType === 2) {
                return a.todayProfit - b.todayProfit;
            } else if (sortType === 3) {
                return a.todayProfitRate - b.todayProfitRate;
            } else if (sortType == 1) {
                return a.sortKey - b.sortKey;
            } else {
                return a.sortKey - b.sortKey;
            }
        } else {
            if (sortType === 2) {
                return b.todayProfit - a.todayProfit;
            } else if (sortType === 3) {
                return b.todayProfitRate - a.todayProfitRate;
            } else if (sortType == 1) {
                return b.sortKey - a.sortKey;
            } else {
                return b.sortKey - a.sortKey;
            }
        }
    }));
    const newList = [ ...noneCurrencies, ...zeroCurrencies ];
    return newList;
}

async function getEqualLegalCurrencyAmountForCollateral(item) {
    return item.usdtAmount;
}

async function getEqualLegalCurrencyAmountForContractAll(item) {
    return await getEqualLegalCurrencyAmount(item.symbol, item.marginBalance);
}

async function getEqualLegalCurrencyAmountForContractAllUsdtM(item) {
    return item.marginBalance;
}

async function getEqualLegalCurrencyAmountForContractOwned(item) {
    return await getEqualLegalCurrencyAmount(item.symbol, item.profit);
}

async function getEqualLegalCurrencyAmountForOption(item) {
    return await getEqualLegalCurrencyAmount(item.currency, item.availableNum);
}

async function getEqualLegalCurrencyAmountForEarn(item) {
    return await getEqualLegalCurrencyAmount(item.currency, item.miningAmount);
}

async function getEqualLegalCurrencyAmountForMarginAll(item) {
    return await getEqualLegalCurrencyAmount(item.symbolName, item.available);
}

async function getEqualLegalCurrencyAmountForMarginPart(item) {
    return await getEqualLegalCurrencyAmount(item.quoteCurrencyDisplayName, item.marginEquivalentFixed);
}

async function getEqualLegalCurrencyAmountForOtc(item) {
    return await getEqualLegalCurrencyAmount(item.coinName, item.total);
}

async function getEqualLegalCurrencyAmountForCopyTrading(item) {
    return await getEqualLegalCurrencyAmount(item.symbol, item.withdrawAvailable);
}

async function sortList(list, getEqualLegalCurrencyAmountFunction) {
    const zeroCurrencies = [];
    const notZeroCurrencies = [];
    list.filter((item => {
        if (item.balance === 0) {
            zeroCurrencies.push(item);
        } else {
            notZeroCurrencies.push(item);
        }
    }));
    const noneCurrencies = await Promise.all(notZeroCurrencies.map((async item => {
        try {
            return {
                sortKey: await getEqualLegalCurrencyAmountFunction(item),
                ...item
            };
        } catch (e) {
            console.error(`bot notZeroCurrencies.map ${e}`);
            return {};
        }
    })));
    noneCurrencies.sort(((a, b) => b.sortKey - a.sortKey));
    const newList = [ ...noneCurrencies, ...zeroCurrencies ];
    return newList;
}

async function sortBotList(list) {
    const zeroCurrencies = [];
    const notZeroCurrencies = [];
    list.filter((item => {
        if (item.balance === 0) {
            zeroCurrencies.push(item);
        } else {
            notZeroCurrencies.push(item);
        }
    }));
    const noneCurrencies = await Promise.all(notZeroCurrencies.map((async item => {
        try {
            return {
                sortProfit: await getEqualLegalCurrencyAmount(item.quoteCurrency, item.totalProfit),
                sortAva: await getEqualLegalCurrencyAmount(item.quoteCurrency, item.investAmount),
                ...item
            };
        } catch (e) {
            console.error(`bot notZeroCurrencies.map ${e}`);
            return {};
        }
    })));
    const newList = [ ...noneCurrencies, ...zeroCurrencies ];
    return newList;
}

async function hiddenAllAsset() {
    updatePageDataByType(currentDistributionType);
    $data.openVisibility = "gone";
    $data.closeVisibility = "visible";
    $data.usdtVis = "gone";
}

async function showAllAsset() {
    updatePageDataByType(currentDistributionType);
    $data.openVisibility = "visible";
    $data.closeVisibility = "gone";
}

async function updatePageDataByType(type) {
    updateTotalAssetData(cacheData.balance);
    console.log(`updatePageDataByType ${type}`);
    updatePageListHeaderByType(type);
    updatePageListByType(type, 0);
    hideDepositWithdraw();
}

async function updatePageListHeaderByType(type) {
    switch (type) {
      case DistributionType.spot:
        updateSpotBaseInfoData(cacheData.spot.spot.baseInfo);
        break;

      case DistributionType.bot:
        updateBotBaseInfoData(cacheData.spot.bot.baseInfo);
        break;

      case DistributionType.collateral:
        updateSpotCollateralBaseInfoData(cacheData.spot.collateral.baseInfo);
        break;

      case DistributionType.coinP:
        updateCoinPBaseInfoData(cacheData.contract.coin_p.baseInfo);
        break;

      case DistributionType.coinFutures:
        updateCoinMBaseInfoData(cacheData.contract.coin_f.baseInfo);
        break;

      case DistributionType.usdtM:
        updateLinearSwapBaseInfoData(cacheData.contract.usdt_m.baseInfo);
        break;

      case DistributionType.contractCopy:
        updateCopyTradingBaseInfo(cacheData.contract.copy_trading.baseInfo);
        break;

      case DistributionType.otc:
        updateOtcBaseInfo(cacheData.otc.baseInfo);
        break;

      case DistributionType.allRepo:
        updateMarginAllInfo(cacheData.margin.allRepo.baseInfo);
        break;

      case DistributionType.partRepo:
        updateMarginPartBaseInfo(cacheData.margin.partRepo.baseInfo);
        break;

      case DistributionType.option:
        updateOptionBaseInfo(cacheData.option.baseInfo);
        break;

      case DistributionType.earn:
        updateEarnYbbBaseInfo(cacheData.earn.earnYbb.baseInfo);
        break;

      case DistributionType.earnFixed:
        updateEarnFixedBaseInfo(cacheData.earn.earnFixed.baseInfo);
        break;

      case DistributionType.earnHigh:
        updateEarnHighBaseInfo(cacheData.earn.earnHigh.baseInfo);
        break;

      case DistributionType.earnNodePledge:
        updateEarnNodePledgeBaseInfo(cacheData.earn.earnNodePledge.baseInfo);

      case DistributionType.earnSharkFin:
        updateEarnSharkFinBaseInfo(cacheData.earn.earnSharkFin.baseInfo);
        break;

      case DistributionType.contractGrid:
        updateContractGridBaseInfo(cacheData.contractGrid.baseInfo);
        break;
    }
}

async function updatePageListByType(type, forceRefreshFlag = 1) {
    console.log(`updatePageListByType ${type}`);
    switch (type) {
      case DistributionType.spot:
        updateSpotCurrenciesData(cacheData.spot.spot.currencies, forceRefreshFlag);
        break;

      case DistributionType.bot:
        updateBotCurrenciesData(cacheData.spot.bot.currencies);
        break;

      case DistributionType.collateral:
        updateSpotCollateralCurrencyData(cacheData.spot.collateral.loaningList, cacheData.spot.collateral.pledgeList);
        break;

      case DistributionType.coinP:
        if (coinPAll) {
            updateContractAllData(type, cacheData.contract.coin_p.all.list);
        } else {
            updateContractOwnedData(type, cacheData.contract.coin_p.owned.list);
        }
        break;

      case DistributionType.coinFutures:
        if (coinMAll) {
            updateContractAllData(type, cacheData.contract.coin_f.all.list);
        } else {
            updateContractOwnedData(type, cacheData.contract.coin_f.owned.list);
        }
        break;

      case DistributionType.usdtM:
        if (usdtMAll) {
            isContractOpenConfig ? updateContractUsdtMUnityData(cacheData.contract.usdt_m_unity.all.list) : updateContractAllData(type, cacheData.contract.usdt_m.all.list);
        } else {
            updateContractOwnedData(type, isContractOpenConfig ? cacheData.contract.usdt_m_unity.owned.list : cacheData.contract.usdt_m.owned.list);
        }
        break;

      case DistributionType.contractCopy:
        updateCopyTradingList(cacheData.contract.copy_trading.list);
        break;

      case DistributionType.otc:
        updateOtcData(cacheData.otc.data);
        break;

      case DistributionType.allRepo:
        updateMarginAllData(cacheData.margin.allRepo.list);
        break;

      case DistributionType.partRepo:
        updateMarginPartData(cacheData.margin.partRepo.list);
        break;

      case DistributionType.option:
        updateOptionData(cacheData.option.list);
        break;

      case DistributionType.earn:
        updateEarnData("0", cacheData.earn.earnYbb.list);
        break;

      case DistributionType.earnFixed:
        updateEarnData("1", cacheData.earn.earnFixed.list);
        break;

      case DistributionType.earnHigh:
        updateEarnHighData("3", cacheData.earn.earnHigh.list);
        break;

      case DistributionType.earnNodePledge:
        updateEarnNodePledgeData("4", cacheData.earn.earnNodePledge.list);

      case DistributionType.earnSharkFin:
        updateEarnSharkFinData("5", cacheData.earn.earnSharkFin.list);
        break;

      case DistributionType.contractGrid:
        updateContractGridData(cacheData.contractGrid.list);
        break;
    }
}

async function getCurrency() {
    const currency = await $nativeAPI.currencyCommon('{"type":3}');
    return currency;
}

async function getTotalAssetCurrency() {
    const currency = await $nativeAPI.currencyCommon('{"type":4}');
    return currency;
}

async function getLegalCurrencySymbol() {
    const currencySymbol = await $nativeAPI.currencyCommon('{"type":9}');
    return currencySymbol;
}

async function getIconUrl(currency) {
    const params = {
        type: 6,
        currency: currency
    };
    const iconUrl = await $nativeAPI.currencyCommon(JSON.stringify(params));
    return iconUrl;
}

async function getWord(wordKey) {
    const params = {
        type: 7,
        wordKey: wordKey
    };
    const word = await $nativeAPI.currencyCommon(JSON.stringify(params));
    return word;
}

async function formatNum(number) {
    if (number === "--") {
        return number;
    }
    const params = {
        type: 53,
        number: number
    };
    const word = await $nativeAPI.currencyCommon(JSON.stringify(params));
    return word;
}

async function formatNumWithPrecision(amount, precision) {
    if (amount === "--") {
        return amount;
    }
    if (precision == null || precision == undefined) {
        return `${amount}`;
    }
    const params = {
        type: 112,
        amount: amount,
        precision: precision
    };
    const word = await $nativeAPI.currencyCommon(JSON.stringify(params));
    return word;
}

async function riseColor(num) {
    const greenRise = await upsAndDownsColor();
    var rate = Number.parseFloat(num);
    if (greenRise == "1") {
        if (rate > 0) {
            return "@color/kColorPriceGreen";
        } else if (rate < 0) {
            return "@color/kColorPriceRed";
        } else {
            return "@color/kColorSecondaryText";
        }
    } else {
        if (rate > 0) {
            return "@color/kColorPriceRed";
        } else if (rate < 0) {
            return "@color/kColorPriceGreen";
        } else {
            return "@color/kColorSecondaryText";
        }
    }
}

function riseColorV2(num, greenRise) {
    var rate = Number.parseFloat(num);
    if (greenRise == "1") {
        if (rate > 0) {
            return "@color/kColorPriceGreen";
        } else if (rate < 0) {
            return "@color/kColorPriceRed";
        } else {
            return "@color/kColorSecondaryText";
        }
    } else {
        if (rate > 0) {
            return "@color/kColorPriceRed";
        } else if (rate < 0) {
            return "@color/kColorPriceGreen";
        } else {
            return "@color/kColorSecondaryText";
        }
    }
}

async function upsAndDownsColor() {
    const greenRise = await $nativeAPI.currencyCommon('{"type":54}');
    return greenRise;
}

async function getWordFormat(wordKey, value) {
    const params = {
        type: 20,
        wordKey: wordKey,
        value: value
    };
    const word = await $nativeAPI.currencyCommon(JSON.stringify(params));
    return word;
}

async function getBTCAmount(currency, amount) {
    const params = {
        type: 22,
        currency: currency,
        amount: amount
    };
    const word = await $nativeAPI.currencyCommon(JSON.stringify(params));
    return word;
}

async function getColor(colorKey) {
    const params = {
        type: 8,
        colorKey: colorKey
    };
    const word = await $nativeAPI.currencyCommon(JSON.stringify(params));
    return word;
}

async function isShowAsset() {
    const isShow = await $nativeAPI.currencyCommon('{"type":10}');
    return isShow;
}

function fixNumber(num, fixed) {
    console.log(`fixNumber ${typeof num}`);
    try {
        if (num) {
            return Number.parseFloat(num).toFixed(fixed);
        } else {
            return Number.parseFloat(0).toFixed(fixed);
        }
    } catch (e) {
        return Number.parseFloat(0).toFixed(fixed);
    }
}

async function getContractNumber(symbol, contractCode, amount, contractType, lastPrice) {
    const params = {
        type: 30,
        symbol: symbol,
        contractCode: contractCode,
        amount: amount,
        contractType: contractType,
        lastPrice: lastPrice
    };
    const word = await $nativeAPI.currencyCommon(JSON.stringify(params));
    console.log(`getContractNumber ---\x3e ${word}  params:json=${JSON.stringify(params)}`);
    return word;
}

async function getEqualLegalCurrencyAmount(symbol, amount) {
    if (!amount) {
        amount = "0";
    }
    const param = {
        type: 1,
        currency: symbol,
        amount: amount
    };
    const paramString = JSON.stringify(param);
    return await $nativeAPI.currencyCommon(paramString);
}

async function convertLegalTender(symbol, amount, currencyScale) {
    if (!amount) {
        amount = "0";
    }
    const param = {
        type: 111,
        currency: symbol,
        amount: amount,
        currencyScale: currencyScale
    };
    const paramString = JSON.stringify(param);
    return await $nativeAPI.currencyCommon(paramString);
}

async function getUsdtAmount(symbol, amount) {
    if (!amount) {
        amount = "0";
    }
    const param = {
        type: 80,
        currency: symbol,
        amount: amount
    };
    const paramString = JSON.stringify(param);
    return await $nativeAPI.currencyCommon(paramString);
}

async function getTotalEarnAndQuantity(symbol, totalIncomeAmount, totalIncomeBalance) {
    if (!totalIncomeAmount) {
        totalIncomeAmount = "0";
    }
    if (!totalIncomeBalance) {
        totalIncomeBalance = "0";
    }
    const param = {
        type: 19,
        currency: symbol,
        amount: totalIncomeAmount
    };
    const paramString = JSON.stringify(param);
    const param2 = {
        type: 19,
        currency: symbol,
        amount: totalIncomeBalance
    };
    const paramString2 = JSON.stringify(param2);
    var totalEarnAndQuantity = `+${await addCurrentCurrencySymbol(await $nativeAPI.currencyCommon(paramString))}\n+${await $nativeAPI.currencyCommon(paramString2)}`;
    console.log(`totalIncomeAmount ---\x3e ${totalIncomeAmount} totalIncomeBalance ---\x3e ${totalIncomeBalance}`);
    console.log(`totalEarnAndQuantity ---\x3e ${totalEarnAndQuantity}`);
    return totalEarnAndQuantity;
}

async function getPreCurrencyAmount(symbol, amount) {
    if (!amount) {
        amount = "0";
    }
    const param = {
        type: 19,
        currency: symbol,
        amount: amount
    };
    const paramString = JSON.stringify(param);
    return await $nativeAPI.currencyCommon(paramString);
}

async function getContractSecondSymbol(contractCode) {
    const param = {
        type: 23,
        contractCode: contractCode
    };
    const paramString = JSON.stringify(param);
    return await $nativeAPI.currencyCommon(paramString);
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
            if (currencySymbol == `₮`) {
                return `-${source.substring(1)} USDT`;
            } else {
                return `-${currencySymbol}${source.substring(1)}`;
            }
        }
        if (currencySymbol == `₮`) {
            return `${source} USDT`;
        } else {
            return `${currencySymbol}${source}`;
        }
    } else {
        if (currencySymbol == `₮`) {
            return `${DEFAULT_STR} USDT`;
        } else {
            return `${currencySymbol}${DEFAULT_STR}`;
        }
    }
}

function addCurrencySymbolTotalAsset(currencySymbol, source) {
    if (source === "--") {
        return source;
    } else if (source && source !== DEFAULT_STR) {
        if (source.startsWith("-")) {
            if (currencySymbol == `₮`) {
                $data.usdtVis = "visible";
                return `-${source.substring(1)}`;
            } else {
                $data.usdtVis = "gone";
                return `-${currencySymbol}${source.substring(1)}`;
            }
        }
        if (currencySymbol == `₮`) {
            $data.usdtVis = "visible";
            return `${source}`;
        } else {
            $data.usdtVis = "gone";
            return `${currencySymbol}${source}`;
        }
    } else {
        if (currencySymbol == `₮`) {
            $data.usdtVis = "visible";
            return `${DEFAULT_STR}`;
        } else {
            $data.usdtVis = "gone";
            return `${currencySymbol}${DEFAULT_STR}`;
        }
    }
}

async function initData() {
    const isShow = await isShowAsset();
    isHidden = !isShow;
    if (!isHidden) {
        $data.openVisibility = "visible";
        $data.closeVisibility = "gone";
    } else {
        $data.openVisibility = "gone";
        $data.closeVisibility = "visible";
        $data.usdtVis = "gone";
    }
    getTotalAssetCurrency().then((currency => {
        $data.currency = currency.toUpperCase();
    }));
    getEntryShow();
    $data.listTitleLeft = await getWord("n_market_collecation_tab_name");
    $data.listTitleCenter = await getWord("asset_spot_table_top_balance_new");
    $data.listTitleRight = await getWord("n_asset_yestoday_interest_amount");
    $data.showSelect = 0;
    await syncCurrencyUpdateConfig();
}

function hiddenSmallAsset(type) {
    console.log(`hiddenSmallAsset ${type}`);
    switch (type) {
      case DistributionType.spot:
        cacheData.spot.spot.hiddenSmallAsset = !cacheData.spot.spot.hiddenSmallAsset;
        break;

      case DistributionType.bot:
        cacheData.spot.bot.hiddenSmallAsset = !cacheData.spot.bot.hiddenSmallAsset;
        break;

      case DistributionType.collateral:
        cacheData.spot.collateral.hiddenSmallAsset = !cacheData.spot.collateral.hiddenSmallAsset;
        break;

      case DistributionType.coinP:
        if (coinPAll) {
            cacheData.contract.coin_p.all.hiddenSmallAsset = !cacheData.contract.coin_p.all.hiddenSmallAsset;
        } else {
            cacheData.contract.coin_p.owned.hiddenSmallAsset = !cacheData.contract.coin_p.owned.hiddenSmallAsset;
        }
        break;

      case DistributionType.coinFutures:
        if (coinMAll) {
            cacheData.contract.coin_f.all.hiddenSmallAsset = !cacheData.contract.coin_f.all.hiddenSmallAsset;
        } else {
            cacheData.contract.coin_f.owned.hiddenSmallAsset = !cacheData.contract.coin_f.owned.hiddenSmallAsset;
        }
        break;

      case DistributionType.usdtM:
        if (usdtMAll) {
            cacheData.contract.usdt_m.all.hiddenSmallAsset = !cacheData.contract.usdt_m.all.hiddenSmallAsset;
            cacheData.contract.usdt_m_unity.all.hiddenSmallAsset = !cacheData.contract.usdt_m_unity.all.hiddenSmallAsset;
        } else {
            cacheData.contract.usdt_m.owned.hiddenSmallAsset = !cacheData.contract.usdt_m.owned.hiddenSmallAsset;
            cacheData.contract.usdt_m_unity.owned.hiddenSmallAsset = !cacheData.contract.usdt_m_unity.owned.hiddenSmallAsset;
        }
        break;

      case DistributionType.contractCopy:
        cacheData.contract.copy_trading.hiddenSmallAsset = !cacheData.contract.copy_trading.hiddenSmallAsset;
        break;

      case DistributionType.otc:
        cacheData.otc.hiddenSmallAsset = !cacheData.otc.hiddenSmallAsset;
        break;

      case DistributionType.allRepo:
        cacheData.margin.allRepo.hiddenSmallAsset = !cacheData.margin.allRepo.hiddenSmallAsset;
        break;

      case DistributionType.partRepo:
        cacheData.margin.partRepo.hiddenSmallAsset = !cacheData.margin.partRepo.hiddenSmallAsset;
        break;

      case DistributionType.earn:
        cacheData.earn.earnYbb.hiddenSmallAsset = !cacheData.earn.earnYbb.hiddenSmallAsset;
        break;

      case DistributionType.earnFixed:
        cacheData.earn.earnFixed.hiddenSmallAsset = !cacheData.earn.earnFixed.hiddenSmallAsset;
        break;

      case DistributionType.option:
        cacheData.option.hiddenSmallAsset = !cacheData.option.hiddenSmallAsset;
        break;

      case DistributionType.contractGrid:
        cacheData.contractGrid.hiddenSmallAsset = !cacheData.contractGrid.hiddenSmallAsset;
        break;
    }
    updatePageListByType(type, 0);
}

function existOneIncludeTwo(oneStr, twoStr) {
    if (oneStr) {
        if (twoStr) {
            return oneStr.toUpperCase().includes(twoStr.toUpperCase());
        }
        return true;
    }
    return false;
}

function searchCoinEvent(type, input) {
    console.log(`searchCoinEvent ${type} ${input}`);
    switch (type) {
      case DistributionType.spot:
        cacheData.spot.spot.searchKey = input;
        break;

      case DistributionType.bot:
        cacheData.spot.bot.searchKey = input;
        break;

      case DistributionType.collateral:
        cacheData.spot.collateral.searchKey = input;
        break;

      case DistributionType.coinP:
        if (coinPAll) {
            cacheData.contract.coin_p.all.searchKey = input;
        } else {
            cacheData.contract.coin_p.owned.searchKey = input;
        }
        break;

      case DistributionType.coinFutures:
        if (coinMAll) {
            cacheData.contract.coin_f.all.searchKey = input;
        } else {
            cacheData.contract.coin_f.owned.searchKey = input;
        }
        break;

      case DistributionType.usdtM:
        if (usdtMAll) {
            cacheData.contract.usdt_m.all.searchKey = input;
            cacheData.contract.usdt_m_unity.all.searchKey = input;
        } else {
            cacheData.contract.usdt_m.owned.searchKey = input;
            cacheData.contract.usdt_m_unity.owned.searchKey = input;
        }
        break;

      case DistributionType.contractCopy:
        cacheData.contract.copy_trading.searchKey = input;
        break;

      case DistributionType.otc:
        cacheData.otc.searchKey = input;
        break;

      case DistributionType.allRepo:
        cacheData.margin.allRepo.searchKey = input;
        break;

      case DistributionType.partRepo:
        cacheData.margin.partRepo.searchKey = input;
        break;

      case DistributionType.earn:
        cacheData.earn.earnYbb.searchKey = input;
        break;

      case DistributionType.earnFixed:
        cacheData.earn.earnFixed.searchKey = input;
        break;

      case DistributionType.option:
        cacheData.option.searchKey = input;
        break;

      case DistributionType.contractGrid:
        cacheData.contractGrid.searchKey = input;
        break;
    }
    updatePageListByType(type, 0);
}

async function itemShouldShow(currency, btcCurrency, amount, hiddenSmallAsset, searchKey) {
    console.log(`itemShouldShow ${currency} ${hiddenSmallAsset} ${searchKey}`);
    return existOneIncludeTwo(currency, searchKey) && (!hiddenSmallAsset || await getBTCAmount(btcCurrency, amount) >= 1e-4);
}

function refreshData() {
    console.log("refreshData!");
    getEntryShow();
    getBalanceAsset();
    getRocketAmount();
    assetTabEvent(currentDistributionType, true, true);
    initConfigInfo();
    getDepositWithdraw();
}

async function getFallCoinText() {
    try {
        console.log(`getFallCoinText start`);
        const params = genRequestParams(fallCoinPath);
        const fallCoinData = await $nativeAPI.request(params);
        console.log(`getFallCoinText ${fallCoinData}`);
        const response = JSON.parse(fallCoinData);
        const {code: code, data: data} = response;
        console.log(`getFallCoinText ${JSON.stringify(data)}`);
        if (code !== 200) {
            cacheData.fallCoinData = {};
            console.error(TAG, `getFallCoinText, code=${code}`);
        } else {
            cacheData.fallCoinData = data;
            if (data.leftTranslateContent != null) {
                $data.fallCoinVis = "visible";
                if (commonData.colorMode == "1") {
                    $data.fallCoinText = `<span style="color:#E6E6E6; font-size:12px;">${data.leftTranslateContent} </span> <span style="color:#0173E5; font-size:12px;"> ${data.rightTranslateContent} </span> `;
                } else {
                    $data.fallCoinText = `<span style="color:#000000; font-size:12px;">${data.leftTranslateContent} </span> <span style="color:#0173E5; font-size:12px;"> ${data.rightTranslateContent} </span> `;
                }
            } else {
                $data.fallCoinVis = "gone";
            }
        }
    } catch (e) {
        console.error(TAG, `getFallCoinText, ${e}`);
    }
}

function jumpFallCoinLink() {
    if (cacheData.fallCoinData.jumpUrl != null) {
        const urlPath = cacheData.fallCoinData.jumpUrl;
        if (urlPath.indexOf("holigeit") == 0 || urlPath.indexOf("http") == 0) {
            openRouter(urlPath);
        } else {
            openRouter(`${commonData.webUrl}/${commonData.language}${urlPath}`);
        }
    }
}

function closeFallCoin() {
    $data.fallCoinVis = "gone";
}

async function initConfigInfo() {
    isContractOpenConfig = await $nativeAPI.currencyCommon('{"type":31}');
}

async function onAppear() {
    const isShow = await isShowAsset();
    isHidden = !isShow;
    if (isHidden) {
        $data.openVisibility = "gone";
        $data.closeVisibility = "visible";
        $data.usdtVis = "gone";
    } else {
        $data.openVisibility = "visible";
        $data.closeVisibility = "gone";
    }
    await syncCurrencyUpdateConfig();
    refreshData();
    getFallCoinText();
    $data.pageAppear = "true";
}

function showProfitRed() {
    $data.profitRed = "visible";
}

async function getOTCData() {
    const params = genRequestParams("v1/capital/balance", "", 0, 1, "");
    try {
        const responseString = await $nativeAPI.request(params);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (code !== 200) {
            $data.otcListError = getResponseParams(code, false);
            console.error(TAG, `getOTCData, code=${code}`);
        } else {
            cacheData.otc.data = data ? data : [];
            updateOtcData(cacheData.otc.data);
        }
    } catch (e) {
        $data.otcListError = getResponseParams(-1, false);
        console.error(TAG, `getOTCData, ${e}`);
    }
}

async function getOptionData(account_id) {
    const params = genRequestParams(`v1/open/profit/options/dual/list`);
    try {
        const responseString = await $nativeAPI.request(params);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (code !== 200) {
            $data.optionListError = getResponseParams(code, false);
            console.error(TAG, `getOptionData, code=${code}`);
        } else {
            cacheData.option.list = data ? data.list ? data.list : [] : [];
            updateOptionData(cacheData.option.list);
        }
    } catch (e) {
        $data.optionListError = getResponseParams(-1, false);
        console.error(TAG, `getOptionData, ${e}`);
    }
}

async function getEarnData(projectType) {
    var params = genRequestParams(`/v1/saving/mining/user/assets/list?projectType=${projectType}`);
    if (projectType == "3" || projectType == "4" || projectType == "5") {
        params = genRequestParams(`/v1/open/profit/assets/saving/list?projectType=${projectType}`);
    }
    sharkFinLastPosition = -1;
    lastPosition = -1;
    nodePledgeLastPosition = -1;
    try {
        const responseString = await $nativeAPI.request(params);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (code !== 200) {
            console.error(TAG, `getEarnData, code=${code}`);
            if (projectType == "0") {
                $data.earnYbbListError = getResponseParams(code, false);
            } else if (projectType == "3") {
                $data.earnHighListError = getResponseParams(code, false);
                $data.earnHighList = [ {
                    type: "3"
                } ];
            } else if (projectType == "4") {
                $data.earnNodePledgeListError = getResponseParams(code, false);
                $data.earnNodePledgeList = [ {
                    type: "3"
                } ];
            } else if (projectType == "5") {
                $data.earnSharkFinListError = getResponseParams(code, false);
                $data.earnSharkFinList = [ {
                    type: "3"
                } ];
            } else {
                $data.earnFixedListError = getResponseParams(code, false);
            }
        } else {
            if (projectType == "0") {
                cacheData.earn.earnYbb.list = data ? data : [];
                updateEarnData(projectType, cacheData.earn.earnYbb.list);
            } else if (projectType == "3") {
                cacheData.earn.earnHigh.list = data ? data : [];
                updateEarnHighData(projectType, cacheData.earn.earnHigh.list);
            } else if (projectType == "4") {
                cacheData.earn.earnNodePledge.list = data ? data : [];
                updateEarnNodePledgeData(projectType, cacheData.earn.earnNodePledge.list);
            } else if (projectType == "5") {
                cacheData.earn.earnSharkFin.list = data ? data : [];
                updateEarnSharkFinData(projectType, cacheData.earn.earnSharkFin.list);
            } else {
                cacheData.earn.earnFixed.list = data ? data : [];
                updateEarnData(projectType, cacheData.earn.earnFixed.list);
            }
        }
    } catch (e) {
        if (projectType == "0") {
            $data.earnYbbListError = getResponseParams(-1, false);
        } else if (projectType == "3") {
            $data.earnHighList = [ {
                type: "3"
            } ];
            $data.earnHighListError = getResponseParams(-1, false);
        } else if (projectType == "4") {
            $data.earnNodePledgeList = [ {
                type: "3"
            } ];
            $data.earnNodePledgeListError = getResponseParams(-1, false);
        } else if (projectType == "5") {
            $data.earnSharkFinList = [ {
                type: "3"
            } ];
            $data.earnSharkFinListError = getResponseParams(-1, false);
        } else {
            $data.earnFixedListError = getResponseParams(-1, false);
        }
        console.error(TAG, `getEarnData, ${e}`);
    }
}

async function getMarginAll() {
    try {
        console.log("getMarginAll");
        const responseString = await $nativeAPI.currencyCommon('{"type":52}');
        const data = JSON.parse(responseString);
        cacheData.margin.allRepo.list = data ? data : [];
        updateMarginAllData(cacheData.margin.allRepo.list);
    } catch (e) {
        $data.longLevelDataListError = getResponseParams(-1, false);
        console.error(TAG, `getMarginAll, ${e}`);
    }
}

async function getMarginPart() {
    try {
        const responseString = await $nativeAPI.currencyCommon('{"type":51}');
        const data = JSON.parse(responseString);
        cacheData.margin.partRepo.list = data ? data : [];
        updateMarginPartData(cacheData.margin.partRepo.list);
    } catch (e) {
        $data.shortLevelDataListError = getResponseParams(-1, false);
        console.error(TAG, `getMarginPart, ${e}`);
    }
}

async function clearData() {
    console.log("clear data!");
    const isShow = await isShowAsset();
    isHidden = !isShow;
    if (isHidden) {
        $data.openVisibility = "gone";
        $data.closeVisibility = "visible";
        $data.usdtVis = "gone";
    } else {
        $data.openVisibility = "visible";
        $data.closeVisibility = "gone";
    }
    $data.profitAccountBalanceList = [];
    cacheData = DEFAULT_CACHE;
    $data.assetTotal = isHidden ? HIDDEN_STR : "--";
    $data.assetToadyProfit = isHidden ? HIDDEN_STR : "--";
    $data.assetToadyProfitRate = isHidden ? "" : "/--";
    $data.assetTotalProfit = isHidden ? HIDDEN_STR : "--";
    $data.rocketAmount = isHidden ? HIDDEN_STR : "--";
    $data.shareVisibility = "gone";
    $data.restrictionVis = "gone";
    $data.exchangeUSDDVis = "gone";
    exchangeEnable = false;
}

function getFullNum(num) {
    if (isNaN(num)) {
        return num;
    }
    var str = "" + num;
    if (!/e/i.test(str)) {
        return num;
    }
    var fixed = ("" + num).match(/\d+$/)[0];
    return new Number(num).toFixed(fixed);
}

var lastPosition = -1;

function onItemClick(position) {
    var currentItem = $data.earnHighList[position];
    var state = "fold";
    if (lastPosition != -1) {
        var item = $data.earnHighList[lastPosition];
        item.visible = "gone";
        $data.earnHighList[lastPosition] = item;
        if (lastPosition == position) {
            state = "unfold";
        }
    }
    if (lastPosition != position) {
        var item = $data.earnHighList[position];
        item.visible = "visible";
        $data.earnHighList[position] = item;
        lastPosition = position;
    } else {
        lastPosition = -1;
    }
    analytics("app_assets_Earn_currency_click", {
        tabName: "maxFlaxible",
        currency: currentItem.symbolName,
        click: state
    });
    console.log("onItemClick: " + position + " , lastPosition: " + lastPosition + " visible: " + $data.earnHighList[position].visible + " , item.spotNumberEquivalent:" + $data.earnHighList[position].spotNumberEquivalent);
}

var nodePledgeLastPosition = -1;

function onNodePledgeItemClick(position) {
    var currentItem = $data.earnNodePledgeList[position];
    var state = "fold";
    if (nodePledgeLastPosition != -1) {
        var item = $data.earnNodePledgeList[nodePledgeLastPosition];
        item.visible = "gone";
        $data.earnNodePledgeList[nodePledgeLastPosition] = item;
        if (nodePledgeLastPosition == position) {
            state = "unfold";
        }
    }
    if (nodePledgeLastPosition != position) {
        var item = $data.earnNodePledgeList[position];
        item.visible = "visible";
        $data.earnNodePledgeList[position] = item;
        nodePledgeLastPosition = position;
    } else {
        nodePledgeLastPosition = -1;
    }
    analytics("app_assets_Earn_currency_click", {
        tabName: "staking",
        currency: currentItem.symbolName,
        click: state
    });
}

var sharkFinLastPosition = -1;

function onSharkFinItemClick(position) {
    console.log("oldPosition: " + sharkFinLastPosition);
    var currentItem = $data.earnSharkFinList[position];
    var state = "fold";
    if (sharkFinLastPosition != -1) {
        console.log("之前有展示 先隐藏" + sharkFinLastPosition);
        var item = $data.earnSharkFinList[sharkFinLastPosition];
        item.visible = "gone";
        $data.earnSharkFinList = $data.earnSharkFinList;
        if (sharkFinLastPosition == position) {
            state = "unfold";
        }
    }
    if (sharkFinLastPosition != position) {
        console.log("有新的坐标 展示新的: " + position);
        var item = $data.earnSharkFinList[position];
        item.visible = "visible";
        $data.earnSharkFinList = $data.earnSharkFinList;
        sharkFinLastPosition = position;
        console.log("更新老坐标: " + sharkFinLastPosition);
    } else {
        console.log("两次点击一致 归位: " + sharkFinLastPosition + "--------" + position);
        sharkFinLastPosition = -1;
    }
    analytics("app_assets_Earn_currency_click", {
        tabName: "shakeFin",
        currency: currentItem.symbolName,
        click: state
    });
}

function onReloadEarnHighClick() {
    getEarnData("3");
}

function onReloadEarnNodePledgeClick() {
    getEarnData("4");
}

function onReloadEarnSharkFinClick() {
    getEarnData("5");
}

function goToHbEarnPage() {
    jump(35);
}

function goToNodePledgePage() {
    analytics("app_assets_Earn_StakeNow_click", {});
    jump(140);
}

function goToSharkFinPage() {
    analytics("app_assets_Earn_EarnNow_click", {
        tabName: "shakeFin"
    });
    openRouter("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/edgeengine/container?scene=earn&rootName=structured&navConfig=native&tab=sharkfin&isClose=true");
}

async function clickSpotItem(position) {
    try {
        const spotElement = cacheData.spot.spot.spotListNew[position];
        console.log(`clickSpotItem   currency  ----\x3e  ${JSON.stringify(spotElement)}`);
        if (!spotElement) {
            return;
        }
        currentSpotExpandCurrency = spotElement.currency;
        const params = genRequestParams(indexPircePath, {
            currencyCode: spotElement.currency
        });
        const responseString = await $nativeAPI.request(params);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (code !== 200) {} else {
            const currencySymbol = await getLegalCurrencySymbol();
            let result = await convertLegalTender("usdt", data.usdtPrice, checkField(data.currencyScale, 2));
            if (`฿` == currencySymbol && data != 0 && result == 0) {
                result = `<0.00000001`;
            }
            spotElement.spotExPrice = isHidden ? HIDDEN_STR : addCurrencySymbol(currencySymbol, result);
            $data.spotIndexPriceData = JSON.stringify({
                position: position,
                data: spotElement
            });
            indexPriceMap[`${currentSpotExpandCurrency}`] = {
                usdtPrice: `${data.usdtPrice}`,
                currencyScale: `${data.currencyScale}`,
                currentSpotExpandCurrency: `${currentSpotExpandCurrency}`
            };
            console.log(`indexPriceMap : ${JSON.stringify(indexPriceMap)}`);
        }
    } catch (e) {
        console.error(`clickSpotItem error ${e}`);
    }
}

async function getSpotExpandIndexPrice(spotElement) {}

function isChinese() {
    return commonData.language.toLowerCase() == "zh-cn" || commonData.language.toLowerCase() == "zh-hk";
}

async function getContractGridData() {
    const param = {
        limit: "100",
        from: "0",
        direct: "1"
    };
    const params = genRequestParams(contractGridInfoPath, param);
    try {
        const responseString = await $nativeAPI.request(params);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (code !== 200) {
            $data.contractGridListError = getResponseParams(code, false);
            $data.contractGridList = [ {
                type: "3"
            } ];
            console.log(TAG, `getContractGridData, code=${code}`);
        } else {
            cacheData.contractGrid.list = data ? data.strategyList : [];
            updateContractGridData(cacheData.contractGrid.list);
            console.log("updateContractGridData");
        }
    } catch (e) {
        console.error(TAG, `getContractGridData, ${e}`);
        $data.contractGridList = [ {
            type: "3"
        } ];
        $data.contractGridListError = getResponseParams(-1, false);
    }
}

async function updateContractGridData(originlist) {
    console.log(`updateContractGridData originlist: ${JSON.stringify(originlist)}`);
    if (!originlist || originlist.length == 0) {
        console.log(`updateContractGridData type 2`);
        $data.contractGridList = [ {
            type: "2"
        } ];
        return;
    }
    try {
        const contractGridData = await sortBotList(originlist);
        const currencySymbol = await getLegalCurrencySymbol();
        cacheData.contractGrid.newList = contractGridData;
        var lastPositionId = -1;
        if (contractGridLastPosition != -1 && $data.contractGridList.length > contractGridLastPosition) {
            lastPositionId = $data.contractGridList[contractGridLastPosition].strategyId;
        }
        contractGridLastPosition = -1;
        const contractGridList = await Promise.all(contractGridData.map((async (item, index) => {
            let isolatedName = "";
            if (1 == item.instrumentType) {
                isolatedName = $i18n.n_market_contract_swap_trade_name_abbr;
            } else if (2 == item.instrumentType) {
                isolatedName = $i18n.n_market_contract_symbol_thisweek_abbr;
            } else if (3 == item.instrumentType) {
                isolatedName = $i18n.n_market_contract_symbol_nextweek_abbr;
            } else if (4 == item.instrumentType) {
                isolatedName = $i18n.n_market_contract_symbol_quarter_abbr;
            } else if (5 == item.instrumentType) {
                isolatedName = $i18n.n_market_contract_symbol_nextweek_abbr;
            }
            const itemName = `${item.symbolTranslateName}${isolatedName}`;
            let trendType = "";
            let colorType = 0;
            if (item.trendType == 1) {
                trendType = $i18n.n_contract_grid_buy;
                colorType = 1;
            } else if (item.trendType == 2) {
                trendType = $i18n.n_contract_grid_sell;
                colorType = -1;
            } else if (item.trendType == 0) {
                trendType = $i18n.n_contract_grid_neutral;
                colorType = 0;
            }
            const longOrShortColor = await riseColor(colorType);
            const lever = `${item.lever}X`;
            const cost = isHidden ? HIDDEN_STR : await getEqualLegalCurrencyAmount(Symbols.usdt, item.investAmount);
            const equalTodayProfit = isHidden ? HIDDEN_STR : await convertLegalTender(Symbols.usdt, item.totalProfitAmount, 2);
            const originSpotYield = addCurrencySymbol(currencySymbol, equalTodayProfit);
            const spotYield = isHidden ? HIDDEN_STR : `${item.totalProfitAmount >= 0 ? "+" : ""}${originSpotYield}`;
            const originSpotRate = fixRate(item.totalProfitRate);
            const spotYieldRate = isHidden ? HIDDEN_STR : `${item.totalProfitRate >= 0 ? "+" : ""}${originSpotRate}`;
            const spotRiseColor = isHidden ? "@color/kColorSecondaryText" : await riseColor(item.totalProfitAmount);
            const visible = item.strategyId == lastPositionId ? "visible" : "gone";
            if (item.strategyId == lastPositionId) {
                contractGridLastPosition = index;
            }
            return {
                type: "1",
                index: index,
                strategyId: item.strategyId,
                visible: visible,
                itemName: itemName,
                trendType: trendType,
                longOrShortColor: longOrShortColor,
                lever: lever,
                cost: cost,
                spotYield: spotYield,
                spotYieldRate: spotYieldRate,
                spotRiseColor: spotRiseColor
            };
        })));
        console.log(TAG, `updateContractGridData Succeed,(list)=${JSON.stringify(contractGridList)}`);
        $data.contractGridList = contractGridList;
    } catch (e) {
        console.error(`updateContractGridData Error, ${e}`);
    }
}

async function updateContractGridBaseInfo(data) {
    console.log(`updateContractGridBaseInfo ${isHidden}`);
    if (isHidden) {
        $data.contractGridTotalAsset = HIDDEN_STR;
        $data.contractGridPlNumber = HIDDEN_STR;
        $data.contractGridPlNumberColor = "@color/kColorSecondaryText";
        return;
    }
    try {
        const legalCurrencySymbol = await getLegalCurrencySymbol();
        const equalAmount = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.balance);
        $data.contractGridTotalAsset = addCurrencySymbolTotalAsset(legalCurrencySymbol, await formatNum(equalAmount));
        const todayProfit = await getEqualLegalCurrencyAmountHandleNull(Symbols.usdt, data.todayProfit);
        const todayProfitWithSymbol = addCurrencySymbol(legalCurrencySymbol, todayProfit);
        $data.contractGridPlNumber = `${todayProfitWithSymbol}/${fixRateHandleNull(data.todayProfitRate)}`;
        $data.contractGridPlNumberColor = await riseColor(data.todayProfit);
    } catch (e) {
        console.error(`updateBotBaseInfoData ${e}`);
    }
}

var contractGridLastPosition = -1;

function onContractGridItemClick(position) {
    console.log("contractGrid oldPosition: " + contractGridLastPosition);
    var tempList = $data.contractGridList.rawArray();
    if (contractGridLastPosition != -1) {
        console.log("之前有展示 先隐藏" + contractGridLastPosition);
        if (tempList.length > contractGridLastPosition) {
            tempList[contractGridLastPosition].visible = "gone";
        } else {
            contractGridLastPosition = -1;
        }
    }
    if (contractGridLastPosition != position) {
        console.log("有新的坐标 展示新的: " + position);
        tempList[position].visible = "visible";
        contractGridLastPosition = position;
        console.log("更新老坐标: " + contractGridLastPosition);
    } else {
        console.log("两次点击一致 归位: " + contractGridLastPosition + "--------" + position);
        contractGridLastPosition = -1;
    }
    $data.contractGridList = tempList;
}

function goToContractGridPage() {
    openRouter("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/trade/contractGrid?source=app_bots_assetspage");
    analytics("app_wallet_bots_futuresGrid_create_click", {});
}

function onReloadContractGridClick() {
    getContractGridData();
}

function stopPopClose() {
    $data.stopPopShow = "false";
}

async function stopConfirmClick() {
    $nativeAPI.showLoading(1);
    var params = {
        strategyId: clickedStrategyId
    };
    var header = {
        "Content-Type": "application/json"
    };
    const requestParams = genRequestParams(contractGridStopPath, params, 1, 0, header);
    try {
        const responseString = await $nativeAPI.request(requestParams);
        const respData = JSON.parse(responseString);
        var {code: code, data: data} = respData;
        $nativeAPI.showLoading(0);
        if (code == 200 && data == true) {
            $data.stopPopShow = "false";
            $nativeAPI.hbToast($i18n.n_bot_detail_toast_stop_success);
            setTimeout((() => {
                getContractGridData();
            }), 1e3);
        } else {
            $nativeAPI.hbToast($i18n.n_bot_detail_toast_stop_fail);
        }
    } catch (e) {
        $nativeAPI.showLoading(0);
        console.error(TAG, `stopConfirmClick, ${e}`);
    }
}

async function getDepositWithdraw() {
    const params = genRequestParams(depositWithdrawPath);
    try {
        const responseString = await $nativeAPI.request(params);
        const response = JSON.parse(responseString);
        const {code: code, data: data} = response;
        if (code == 200) {
            console.log("deposit-withdraw");
            updateDepositWithdraw(data);
        } else {
            console.log(TAG, `deposit-withdraw, code=${code}`);
        }
    } catch (e) {
        console.error(TAG, `deposit-withdraw, ${e}`);
    }
}

async function updateDepositWithdraw(datalist) {
    try {
        const dwInfoList = await Promise.all(datalist.map((async (item, index) => {
            const content = isHidden ? HIDDEN_STR : item.translateContentData;
            return {
                cellType: "1",
                indicatorWidth: index == 0 ? "15" : "4",
                content: content,
                translateContentData: item.translateContentData,
                iconUrl: item.iconUrl,
                type: `${item.type}`,
                index: index
            };
        })));
        $data.dwCurrentIndex = 0;
        $data.dwInfoList = dwInfoList;
        $data.dwInfoShow = $data.dwInfoList.length > 0 ? "visible" : "gone";
        $data.showIndicator = $data.dwInfoList.length > 1 ? "visible" : "gone";
        console.log(TAG, `updateDepositWithdraw Succeed,(list)=${JSON.stringify(dwInfoList)}`);
    } catch (e) {
        console.error(`updateDepositWithdraw Error, ${e}`);
    }
}

function hideDepositWithdraw() {
    if ($data.dwInfoList && $data.dwInfoList.length > 0) {
        for (let index = 0; index < $data.dwInfoList.length; index++) {
            const element = $data.dwInfoList[index];
            if (isHidden) {
                element.content = HIDDEN_STR;
            } else {
                element.content = $data.dwInfoList[index].translateContentData;
            }
        }
    }
}

function dwIndexChange(selectIndex) {
    if ($data.dwInfoList && $data.dwInfoList.length > selectIndex) {
        for (let index = 0; index < $data.dwInfoList.length; index++) {
            const element = $data.dwInfoList[index];
            if (selectIndex == index) {
                element.indicatorWidth = "15";
            } else {
                element.indicatorWidth = "4";
            }
        }
    }
}

function dwItemClicked(type) {
    openRouter(`holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/balance/dWRecord?pageType=${type}`);
}

function removeTrailingZeroes(num) {
    let fixed = num.toString();
    return fixed.replace(/\.?0+$/, "");
}

function exchangeUSDDClicked() {
    openRouter(`${exchangeJumpUrl}?from=USDT&to=USDD`);
}

initData();

var asset = Object.freeze({
    __proto__: null,
    read: read,
    syncCurrencyUpdateConfig: syncCurrencyUpdateConfig,
    sendCommonConfig: sendCommonConfig,
    toggleShowAsset: toggleShowAsset,
    restrictionPop: restrictionPop,
    shareAsset: shareAsset,
    jump: jump,
    analytics: analytics,
    openRouter: openRouter,
    currencyChange: currencyChange,
    genRequestParams: genRequestParams,
    getErrorInfo: getErrorInfo,
    profitPrefix: profitPrefix,
    legalString: legalString,
    getResponseParams: getResponseParams,
    getBalanceAsset: getBalanceAsset,
    getRocketAmount: getRocketAmount,
    rocketInfoTapAction: rocketInfoTapAction,
    updateEarnYbbBaseInfo: updateEarnYbbBaseInfo,
    assetNewEarnGuide: assetNewEarnGuide,
    assetNewEarnGuideHide: assetNewEarnGuideHide,
    assetSpotAutoEarnOpenGuide: assetSpotAutoEarnOpenGuide,
    assetSpotOpenGuideHide: assetSpotOpenGuideHide,
    getEqualLegalCurrencyAmountHandleNull: getEqualLegalCurrencyAmountHandleNull,
    fixRateHandleNull: fixRateHandleNull,
    fixRate: fixRate,
    fixRateFixed: fixRateFixed,
    updateEarnFixedBaseInfo: updateEarnFixedBaseInfo,
    updateEarnHighBaseInfo: updateEarnHighBaseInfo,
    updateEarnNodePledgeBaseInfo: updateEarnNodePledgeBaseInfo,
    updateEarnSharkFinBaseInfo: updateEarnSharkFinBaseInfo,
    updateOptionBaseInfo: updateOptionBaseInfo,
    getEntryShow: getEntryShow,
    getSpotAccountInfo: getSpotAccountInfo,
    getSpotBotInfo: getSpotBotInfo,
    getSpotCollateralInfo: getSpotCollateralInfo,
    goToCollateral: goToCollateral,
    goToCollateralHistory: goToCollateralHistory,
    getContractUsdtM: getContractUsdtM,
    getCopyTradingData: getCopyTradingData,
    updateCopyTradingList: updateCopyTradingList,
    getContractUsdtMUnity: getContractUsdtMUnity,
    getContractCoinFutures: getContractCoinFutures,
    getContractCoinPerpetual: getContractCoinPerpetual,
    getDepositBannerInfo: getDepositBannerInfo,
    updateTotalAssetData: updateTotalAssetData,
    updateAccountList: updateAccountList,
    updateBotBaseInfoData: updateBotBaseInfoData,
    updateSpotBaseInfoData: updateSpotBaseInfoData,
    updateBotCurrenciesData: updateBotCurrenciesData,
    updateSpotCurrenciesData: updateSpotCurrenciesData,
    checkField: checkField,
    updateSpotCollateralBaseInfoData: updateSpotCollateralBaseInfoData,
    updateSpotCollateralCurrencyData: updateSpotCollateralCurrencyData,
    updateLinearSwapBaseInfoData: updateLinearSwapBaseInfoData,
    updateCoinMBaseInfoData: updateCoinMBaseInfoData,
    updateCoinPBaseInfoData: updateCoinPBaseInfoData,
    updateOtcBaseInfo: updateOtcBaseInfo,
    updateCopyTradingBaseInfo: updateCopyTradingBaseInfo,
    updateMarginAllInfo: updateMarginAllInfo,
    handlerAssetRiskRate: handlerAssetRiskRate,
    getRiskStateColor: getRiskStateColor,
    updateMarginPartBaseInfo: updateMarginPartBaseInfo,
    updateContractUsdtMUnityData: updateContractUsdtMUnityData,
    updateContractAllData: updateContractAllData,
    updateContractOwnedData: updateContractOwnedData,
    updateOtcData: updateOtcData,
    updateOptionData: updateOptionData,
    updateEarnHighData: updateEarnHighData,
    updateEarnNodePledgeData: updateEarnNodePledgeData,
    updateEarnSharkFinData: updateEarnSharkFinData,
    updateEarnData: updateEarnData,
    updateMarginAllData: updateMarginAllData,
    updateMarginPartData: updateMarginPartData,
    assetThirdTypeEvent: assetThirdTypeEvent,
    assetTabEvent: assetTabEvent,
    sortEvent: sortEvent,
    sortBotEvent: sortBotEvent,
    sortSpotList: sortSpotList,
    getEqualLegalCurrencyAmountForCollateral: getEqualLegalCurrencyAmountForCollateral,
    getEqualLegalCurrencyAmountForContractAll: getEqualLegalCurrencyAmountForContractAll,
    getEqualLegalCurrencyAmountForContractAllUsdtM: getEqualLegalCurrencyAmountForContractAllUsdtM,
    getEqualLegalCurrencyAmountForContractOwned: getEqualLegalCurrencyAmountForContractOwned,
    getEqualLegalCurrencyAmountForOption: getEqualLegalCurrencyAmountForOption,
    getEqualLegalCurrencyAmountForEarn: getEqualLegalCurrencyAmountForEarn,
    getEqualLegalCurrencyAmountForMarginAll: getEqualLegalCurrencyAmountForMarginAll,
    getEqualLegalCurrencyAmountForMarginPart: getEqualLegalCurrencyAmountForMarginPart,
    getEqualLegalCurrencyAmountForOtc: getEqualLegalCurrencyAmountForOtc,
    getEqualLegalCurrencyAmountForCopyTrading: getEqualLegalCurrencyAmountForCopyTrading,
    sortList: sortList,
    sortBotList: sortBotList,
    hiddenAllAsset: hiddenAllAsset,
    showAllAsset: showAllAsset,
    updatePageDataByType: updatePageDataByType,
    updatePageListHeaderByType: updatePageListHeaderByType,
    updatePageListByType: updatePageListByType,
    getCurrency: getCurrency,
    getTotalAssetCurrency: getTotalAssetCurrency,
    getLegalCurrencySymbol: getLegalCurrencySymbol,
    getIconUrl: getIconUrl,
    getWord: getWord,
    formatNum: formatNum,
    formatNumWithPrecision: formatNumWithPrecision,
    riseColor: riseColor,
    riseColorV2: riseColorV2,
    upsAndDownsColor: upsAndDownsColor,
    getWordFormat: getWordFormat,
    getBTCAmount: getBTCAmount,
    getColor: getColor,
    isShowAsset: isShowAsset,
    fixNumber: fixNumber,
    getContractNumber: getContractNumber,
    getEqualLegalCurrencyAmount: getEqualLegalCurrencyAmount,
    convertLegalTender: convertLegalTender,
    getUsdtAmount: getUsdtAmount,
    getTotalEarnAndQuantity: getTotalEarnAndQuantity,
    getPreCurrencyAmount: getPreCurrencyAmount,
    getContractSecondSymbol: getContractSecondSymbol,
    addCurrentCurrencySymbol: addCurrentCurrencySymbol,
    addCurrencySymbol: addCurrencySymbol,
    addCurrencySymbolTotalAsset: addCurrencySymbolTotalAsset,
    initData: initData,
    hiddenSmallAsset: hiddenSmallAsset,
    existOneIncludeTwo: existOneIncludeTwo,
    searchCoinEvent: searchCoinEvent,
    itemShouldShow: itemShouldShow,
    refreshData: refreshData,
    getFallCoinText: getFallCoinText,
    jumpFallCoinLink: jumpFallCoinLink,
    closeFallCoin: closeFallCoin,
    initConfigInfo: initConfigInfo,
    onAppear: onAppear,
    showProfitRed: showProfitRed,
    getOTCData: getOTCData,
    getOptionData: getOptionData,
    getEarnData: getEarnData,
    getMarginAll: getMarginAll,
    getMarginPart: getMarginPart,
    clearData: clearData,
    getFullNum: getFullNum,
    onItemClick: onItemClick,
    onNodePledgeItemClick: onNodePledgeItemClick,
    onSharkFinItemClick: onSharkFinItemClick,
    onReloadEarnHighClick: onReloadEarnHighClick,
    onReloadEarnNodePledgeClick: onReloadEarnNodePledgeClick,
    onReloadEarnSharkFinClick: onReloadEarnSharkFinClick,
    goToHbEarnPage: goToHbEarnPage,
    goToNodePledgePage: goToNodePledgePage,
    goToSharkFinPage: goToSharkFinPage,
    clickSpotItem: clickSpotItem,
    getSpotExpandIndexPrice: getSpotExpandIndexPrice,
    getContractGridData: getContractGridData,
    updateContractGridData: updateContractGridData,
    updateContractGridBaseInfo: updateContractGridBaseInfo,
    onContractGridItemClick: onContractGridItemClick,
    goToContractGridPage: goToContractGridPage,
    onReloadContractGridClick: onReloadContractGridClick,
    stopPopClose: stopPopClose,
    stopConfirmClick: stopConfirmClick,
    getDepositWithdraw: getDepositWithdraw,
    updateDepositWithdraw: updateDepositWithdraw,
    hideDepositWithdraw: hideDepositWithdraw,
    dwIndexChange: dwIndexChange,
    dwItemClicked: dwItemClicked,
    removeTrailingZeroes: removeTrailingZeroes,
    exchangeUSDDClicked: exchangeUSDDClicked
});

Object.assign(globalThis, asset);
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWFpbi5qcyIsInNvdXJjZXMiOlsiLi4vLi4vcmVwb3NpdG9yeS9zcmMvYXNzZXQuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9tYWluLmpzIl0sInNvdXJjZXNDb250ZW50IjpbInZhciBpc0hpZGRlbiA9IHRydWU7XG52YXIgY3VycmVudERpc3RyaWJ1dGlvblR5cGUgPSBcIjBcIjtcbnZhciB1c2R0TUFsbCA9IHRydWU7XG52YXIgY29pblBBbGwgPSB0cnVlO1xudmFyIGNvaW5NQWxsID0gdHJ1ZTtcbnZhciBpc0NvbnRyYWN0T3BlbkNvbmZpZyA9IGZhbHNlO1xudmFyIGF2YWlsYWJsZXMgPSBbXTtcbnZhciBjbGlja2FibGUgPSB0cnVlO1xudmFyIGVuZFRpbWUgPSAwO1xudmFyIGF1dG9FYXJuR3VpZGVTaG93ID0gZmFsc2U7XG52YXIgdG9kYXlQcm9maXRTdGF0ZSA9IDA7XG52YXIgY2xpY2tlZFN0cmF0ZWd5SWQgPSBcIlwiO1xudmFyIGV4Y2hhbmdlRW5hYmxlID0gZmFsc2U7XG52YXIgZXhjaGFuZ2VKdW1wVXJsID0gXCJcIjtcblxudmFyIGNvbW1vbkRhdGEgPSB7XG4gICAgd2ViVXJsOiBcIlwiLFxuICAgIGxhbmd1YWdlOiBcIlwiLFxufTtcblxudmFyIGN1cnJlbmN5VXBkYXRlRGF0YSA9IHtcbiAgICB1cERldGFpbEN1cnJlbmN5OiBcIlwiLFxuICAgIHVwZ3JhZGVDdXJyZW5jeTogXCJcIixcbiAgICB1cGdyYWRlSnVtcFVybDogXCJcIixcbiAgICB1cGdyYWRlRGV0YWlsVXJsOiBcIlwiLFxuICAgIHVwZ3JhZGVTdGF0ZTogZmFsc2UsXG59O1xuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gcmVhZChtb2R1bGUsIGtleSkge1xuICAgIGNvbnN0IGRhdGEgPSBhd2FpdCAkbmF0aXZlQVBJLnN0b3JhZ2Uoe1xuICAgICAgICBhY3Rpb246IFwicmVhZFwiLFxuICAgICAgICBuYW1lOiBtb2R1bGUsXG4gICAgICAgIGtleToga2V5XG4gICAgfSk7XG4gICAgaWYgKGRhdGEgJiYgZGF0YSAhPSBcIlwiKSB7XG4gICAgICAgIHJldHVybiBKU09OLnBhcnNlKGRhdGEpO1xuICAgIH1cbiAgICByZXR1cm4gbnVsbDtcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHN5bmNDdXJyZW5jeVVwZGF0ZUNvbmZpZygpIHtcbiAgICBjb25zdCB0bXBEYXRhID0gYXdhaXQgcmVhZChcImdsb2JhbFwiLCBcImN1cnJlbmN5VXBkYXRlRGF0YVwiKTtcbiAgICBpZiAodG1wRGF0YSAhPT0gbnVsbCkge1xuICAgICAgICBjdXJyZW5jeVVwZGF0ZURhdGEgPSB0bXBEYXRhO1xuICAgIH1cbiAgICBpZiAoY3VycmVuY3lVcGRhdGVEYXRhLnVwZ3JhZGVTdGF0ZSA9PT0gdHJ1ZSkge1xuICAgICAgICAkZGF0YS5hc3NldF9zbWFsbF9jb2luX3RpdGxlID0gYXdhaXQgZ2V0V29yZCgnYXNzZXRfc21hbGxfY29pbl90b19odHgnKTtcbiAgICB9IGVsc2Uge1xuICAgICAgICAkZGF0YS5hc3NldF9zbWFsbF9jb2luX3RpdGxlID0gYXdhaXQgZ2V0V29yZCgnYXNzZXRfc21hbGxfY29pbl90b19odCcpO1xuICAgIH1cbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNlbmRDb21tb25Db25maWcocGFyYW0pIHtcbiAgICBjb25zb2xlLmxvZyhgd3Agc2VuZENvbW1vbkNvbmZpZyBsYW5ndWFnZSAke3BhcmFtLmxhbmd1YWdlfSB3ZWJVcmwgJHtwYXJhbS53ZWJVcmx9IGNvbG9yTW9kZSAke3BhcmFtLmNvbG9yTW9kZX1gKTtcbiAgICBjb21tb25EYXRhLmxhbmd1YWdlID0gcGFyYW0ubGFuZ3VhZ2U7XG4gICAgY29tbW9uRGF0YS53ZWJVcmwgPSBwYXJhbS53ZWJVcmw7XG4gICAgY29tbW9uRGF0YS5jb2xvck1vZGUgPSBwYXJhbS5jb2xvck1vZGU7XG4gICAgY29tbW9uRGF0YS5PUyA9IHBhcmFtLk9TO1xuICAgICRkYXRhLnVwZ3JhZGVCZ0NvbG9yID0gY29tbW9uRGF0YS5jb2xvck1vZGUgPT0gMCA/IFwiI0Q5RjdFNFwiOlwiIzFEMzQyRVwiO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gdG9nZ2xlU2hvd0Fzc2V0KCkge1xuICAgIGlzSGlkZGVuID0gIWlzSGlkZGVuO1xuICAgIGNvbnNvbGUubG9nKGB0b2dnbGVTaG93QXNzZXQgJHtpc0hpZGRlbn1gKTtcbiAgICBpZiAoaXNIaWRkZW4pIHtcbiAgICAgICAgaGlkZGVuQWxsQXNzZXQoKTtcbiAgICB9IGVsc2Uge1xuICAgICAgICBzaG93QWxsQXNzZXQoKTtcbiAgICB9XG4gICAgJG5hdGl2ZUFQSS5jdXJyZW5jeUNvbW1vbigne1widHlwZVwiOjE0fScpO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gcmVzdHJpY3Rpb25Qb3AoKSB7XG4gICAgJG5hdGl2ZUFQSS5qdW1wKEpTT04uc3RyaW5naWZ5KHsgdHlwZTogMTY2IH0pKTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIHNoYXJlQXNzZXQoKSB7XG4gICAgdmFyIHNoYXJlID0ge307XG4gICAgc2hhcmUudHlwZSA9IDE1O1xuICAgIHNoYXJlLnJhdGUgPSBjYWNoZURhdGEuYmFsYW5jZS50b2RheVByb2ZpdFJhdGUgPyBjYWNoZURhdGEuYmFsYW5jZS50b2RheVByb2ZpdFJhdGUgOiAwO1xuICAgIGNvbnNvbGUubG9nKHNoYXJlLnJhdGUpO1xuICAgICRuYXRpdmVBUEkuY3VycmVuY3lDb21tb24oSlNPTi5zdHJpbmdpZnkoc2hhcmUpKTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGp1bXAodHlwZSwgaW5kZXgsIGNoaWxkVHlwZSkge1xuICAgIHZhciBwYXJhbXMgPSB7XG4gICAgICAgIHR5cGVcbiAgICB9O1xuICAgIHZhciBhbmFseXNpc1BhcmFtcyA9IHtcbiAgICAgICAgdHJhY2s6IFwiXCIsXG4gICAgICAgIHByb3BlcnRpZXM6IHt9XG4gICAgfTtcbiAgICBjb25zb2xlLmxvZyhganVtcCAke3R5cGV9ICR7aW5kZXh9ICR7Y2hpbGRUeXBlfWApO1xuICAgIHRyeSB7XG4gICAgICAgIHN3aXRjaCAodHlwZSkge1xuICAgICAgICAgICAgY2FzZSA5OlxuICAgICAgICAgICAgICAgIGNvbnN0IGl0ZW0xNTggPSBjYWNoZURhdGEuc3BvdC5zcG90Lm5ld0xpc3RbaW5kZXhdO1xuICAgICAgICAgICAgICAgIHBhcmFtcy50eXBlID0gMTU4O1xuICAgICAgICAgICAgICAgIHBhcmFtcy5jdXJyZW5jeSA9IGl0ZW0xNTguY3VycmVuY3k7XG4gICAgICAgICAgICAgICAgcGFyYW1zLnN0YWJsZSA9IGl0ZW0xNTggPyBjaGVja0ZpZWxkKGl0ZW0xNTguc3RhYmxlLCBmYWxzZSkgOiBmYWxzZTtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGNhc2UgODpcbiAgICAgICAgICAgIGNhc2UgMTA6XG4gICAgICAgICAgICAgICAgY29uc3QgaXRlbSA9IGNhY2hlRGF0YS5zcG90LnNwb3QubmV3TGlzdFtpbmRleF07XG4gICAgICAgICAgICAgICAgcGFyYW1zLmN1cnJlbmN5ID0gaXRlbS5jdXJyZW5jeTtcbiAgICAgICAgICAgICAgICBwYXJhbXMuc3RhYmxlID0gaXRlbSA/IGNoZWNrRmllbGQoaXRlbS5zdGFibGUsIGZhbHNlKSA6IGZhbHNlO1xuICAgICAgICAgICAgICAgIC8vIHVzZHTlkIxidGNcbiAgICAgICAgICAgICAgICBpZiAodHlwZSA9PSA4ICYmIGl0ZW0uY3VycmVuY3kudG9Mb3dlckNhc2UoKSA9PSBcInVzZHRcIikge1xuICAgICAgICAgICAgICAgICAgcGFyYW1zLmN1cnJlbmN5ID0gXCJidGNcIjtcbiAgICAgICAgICAgICAgICAgIHBhcmFtcy5zdGFibGUgPSBmYWxzZTtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIDExOlxuICAgICAgICAgICAgICAgIGNvbnN0IGl0ZW0xMSA9IGNhY2hlRGF0YS5zcG90LnNwb3QubmV3TGlzdFtpbmRleF07XG4gICAgICAgICAgICAgICAgcGFyYW1zLmN1cnJlbmN5ID0gaXRlbTExLmN1cnJlbmN5O1xuICAgICAgICAgICAgICAgIHBhcmFtcy50b2RheVByb2ZpdFJhdGUgPSBjaGVja0ZpZWxkKGl0ZW0xMS50b2RheVByb2ZpdFJhdGUsIG51bGwpO1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSAxMjpcbiAgICAgICAgICAgIGNhc2UgMTM6XG4gICAgICAgICAgICAgICAgY29uc3QgaXRlbTEyID0gY2FjaGVEYXRhLnNwb3QuYm90Lm5ld0xpc3RbaW5kZXhdO1xuICAgICAgICAgICAgICAgIHBhcmFtcy5pZCA9IGl0ZW0xMi5zdHJhdGVneUlkO1xuICAgICAgICAgICAgICAgIHBhcmFtcy5zeW1ib2wgPSBpdGVtMTIuc3ltYm9sO1xuICAgICAgICAgICAgICAgIHBhcmFtcy5jcmVhdGVQYXRoID0gaXRlbTEyLmNyZWF0ZVBhdGg7XG4gICAgICAgICAgICAgICAgYW5hbHlzaXNQYXJhbXMudHJhY2sgPSB0eXBlID09IDEyID8gXCJhcHBfd2FsbGV0X3Nwb3Rib3RzX2RyYXdlcl9jcmVhdGVfY2xpY2tcIiA6IFwiYXBwX3dhbGxldF9zcG90Ym90c19kcmF3ZXJfZGV0YWlsX2NsaWNrXCI7XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIDE0OlxuICAgICAgICAgICAgICAgIGNvbnN0IGl0ZW0xNCA9IGNhY2hlRGF0YS5zcG90LmJvdC5uZXdMaXN0W2luZGV4XTtcbiAgICAgICAgICAgICAgICBwYXJhbXMudG90YWxQcm9maXRSYXRlID0gaXRlbTE0LnRvdGFsUHJvZml0UmF0ZTtcbiAgICAgICAgICAgICAgICBwYXJhbXMuc3ltYm9sVGl0bGUgPSBpdGVtMTQuc3ltYm9sVHJhbnNsYXRlTmFtZTtcbiAgICAgICAgICAgICAgICBwYXJhbXMucXVvdGVDdXJyZW5jeSA9IGl0ZW0xNC5xdW90ZUN1cnJlbmN5O1xuICAgICAgICAgICAgICAgIHBhcmFtcy5taW5QcmljZSA9IGl0ZW0xNC5taW5QcmljZTtcbiAgICAgICAgICAgICAgICBwYXJhbXMubWF4UHJpY2UgPSBpdGVtMTQubWF4UHJpY2U7XG4gICAgICAgICAgICAgICAgcGFyYW1zLnRyYWRlTnVtID0gaXRlbTE0LnRyYWRlTnVtO1xuICAgICAgICAgICAgICAgIHBhcmFtcy5ydW5UaW1lID0gaXRlbTE0LnJ1blRpbWU7XG4gICAgICAgICAgICAgICAgYW5hbHlzaXNQYXJhbXMudHJhY2sgPSBcImFwcF93YWxsZXRfc3BvdGJvdHNfZHJhd2VyX3NoYXJlX2NsaWNrXCI7XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIDE1OlxuICAgICAgICAgICAgY2FzZSAxNjpcbiAgICAgICAgICAgIGNhc2UgMzY6XG4gICAgICAgICAgICBjYXNlIDExNjpcbiAgICAgICAgICAgICAgICBsZXQgaXRlbTE2O1xuICAgICAgICAgICAgICAgIGlmIChjaGlsZFR5cGUgPT0gNCkge1xuICAgICAgICAgICAgICAgICAgICBpdGVtMTYgPSBjYWNoZURhdGEuY29udHJhY3QudXNkdF9tLmFsbC5uZXdMaXN0W2luZGV4XTtcbiAgICAgICAgICAgICAgICAgICAgcGFyYW1zLnRyYWRlVHlwZSA9IFwiMVwiO1xuICAgICAgICAgICAgICAgIH0gZWxzZSBpZiAoY2hpbGRUeXBlID09IDcpIHtcbiAgICAgICAgICAgICAgICAgICAgaXRlbTE2ID0gY2FjaGVEYXRhLmNvbnRyYWN0LmNvaW5fcC5hbGwubmV3TGlzdFtpbmRleF07XG4gICAgICAgICAgICAgICAgICAgIHBhcmFtcy50cmFkZVR5cGUgPSBcIjJcIjtcbiAgICAgICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICBpdGVtMTYgPSBjYWNoZURhdGEuY29udHJhY3QuY29pbl9mLmFsbC5uZXdMaXN0W2luZGV4XTtcbiAgICAgICAgICAgICAgICAgICAgcGFyYW1zLnRyYWRlVHlwZSA9IFwiM1wiO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICBwYXJhbXMuc3ltYm9sID0gaXRlbTE2ID8gaXRlbTE2LnN5bWJvbCA6ICcnO1xuICAgICAgICAgICAgICAgIHBhcmFtcy5jb250cmFjdENvZGUgPSBpdGVtMTYgPyAoaXRlbTE2LmNvbnRyYWN0Q29kZSA/IGl0ZW0xNi5jb250cmFjdENvZGUgOiAnJykgOiAnJztcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGNhc2UgNDI6XG4gICAgICAgICAgICAgICAgbGV0IGl0ZW00MiA9IGNhY2hlRGF0YS5jb250cmFjdC51c2R0X21fdW5pdHkuYWxsLm5ld0xpc3RbaW5kZXhdO1xuICAgICAgICAgICAgICAgIHBhcmFtcy5jdXJyZW5jeSA9IGl0ZW00MiA/IGl0ZW00Mi5zeW1ib2wudG9Mb3dlckNhc2UoKSA6ICd1c2R0JztcbiAgICAgICAgICAgICAgICBpZiAocGFyYW1zLmN1cnJlbmN5ID09IFwidXNkdFwiKSB7XG4gICAgICAgICAgICAgICAgICAgIHBhcmFtcy5zdGFibGUgPSB0cnVlO1xuICAgICAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgICAgIHBhcmFtcy5zdGFibGUgPSBmYWxzZTtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgcGFyYW1zLnR5cGUgPSA4O1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSA0MzpcbiAgICAgICAgICAgICAgICBsZXQgaXRlbTQzID0gY2FjaGVEYXRhLmNvbnRyYWN0LnVzZHRfbV91bml0eS5hbGwubmV3TGlzdFtpbmRleF07XG4gICAgICAgICAgICAgICAgcGFyYW1zLnRyYWRlVHlwZSA9IFwiMVwiO1xuICAgICAgICAgICAgICAgIHBhcmFtcy5zeW1ib2wgPSBpdGVtNDMgPyBpdGVtNDMuc3ltYm9sIDogJyc7XG4gICAgICAgICAgICAgICAgcGFyYW1zLmNvbnRyYWN0Q29kZSA9ICdCVEMtVVNEVCc7XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIDQ0OlxuICAgICAgICAgICAgICAgIGxldCBpdGVtNDQgPSBjYWNoZURhdGEuY29udHJhY3QudXNkdF9tX3VuaXR5LmFsbC5uZXdMaXN0W2luZGV4XTtcbiAgICAgICAgICAgICAgICBsZXQgdGVtcEl0ZW0gPSBhdmFpbGFibGVzW2luZGV4XTtcbiAgICAgICAgICAgICAgICBwYXJhbXMudHJhZGVUeXBlID0gXCIxXCI7XG4gICAgICAgICAgICAgICAgcGFyYW1zLnN5bWJvbCA9IGl0ZW00NCA/IGl0ZW00NC5zeW1ib2wgOiAnJztcbiAgICAgICAgICAgICAgICBwYXJhbXMuY29udHJhY3RDb2RlID0gJ0JUQy1VU0RUJztcbiAgICAgICAgICAgICAgICBwYXJhbXMubWFyZ2luTW9kZSA9ICdjcm9zcyc7XG4gICAgICAgICAgICAgICAgcGFyYW1zLmFzc2V0VHlwZSA9IGNhY2hlRGF0YS5jb250cmFjdC51c2R0X21fdW5pdHkuYXNzZXRUeXBlO1xuICAgICAgICAgICAgICAgIGlmIChwYXJhbXMuYXNzZXRUeXBlID09IDMpIHtcbiAgICAgICAgICAgICAgICAgIHBhcmFtcy5hdmFpbGFibGUgPSB0ZW1wSXRlbSA/IHRlbXBJdGVtLndpdGhkcmF3QXZhaWxhYmxlQW1vdW50IDogJyc7XG4gICAgICAgICAgICAgICAgICBwYXJhbXMuZXF1aXR5ID0gdGVtcEl0ZW0gPyB0ZW1wSXRlbS5lcXVpdHlOdW1BbW91bnQgOiAnJztcbiAgICAgICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgICAgcGFyYW1zLmF2YWlsYWJsZSA9IHRlbXBJdGVtID8gdGVtcEl0ZW0ubWFyZ2luQXZhaWxhYmxlQW1vdW50IDogJyc7XG4gICAgICAgICAgICAgICAgICBwYXJhbXMuZXF1aXR5ID0gdGVtcEl0ZW0gPyB0ZW1wSXRlbS5lcXVpdHlOdW1BbW91bnQgOiAnJztcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIDE3OlxuICAgICAgICAgICAgICAgIGxldCBpdGVtMTc7XG4gICAgICAgICAgICAgICAgaWYgKGNoaWxkVHlwZSA9PSA0KSB7XG4gICAgICAgICAgICAgICAgICAgIGl0ZW0xNyA9IGNhY2hlRGF0YS5jb250cmFjdC51c2R0X20uYWxsLm5ld0xpc3RbaW5kZXhdO1xuICAgICAgICAgICAgICAgICAgICBwYXJhbXMudHJhZGVUeXBlID0gXCIxXCI7XG4gICAgICAgICAgICAgICAgfSBlbHNlIGlmIChjaGlsZFR5cGUgPT0gNykge1xuICAgICAgICAgICAgICAgICAgICBpdGVtMTcgPSBjYWNoZURhdGEuY29udHJhY3QuY29pbl9wLmFsbC5uZXdMaXN0W2luZGV4XTtcbiAgICAgICAgICAgICAgICAgICAgcGFyYW1zLnRyYWRlVHlwZSA9IFwiMlwiO1xuICAgICAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgICAgIGl0ZW0xNyA9IGNhY2hlRGF0YS5jb250cmFjdC5jb2luX2YuYWxsLm5ld0xpc3RbaW5kZXhdO1xuICAgICAgICAgICAgICAgICAgICBwYXJhbXMudHJhZGVUeXBlID0gXCIzXCI7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIHBhcmFtcy5tYXJnaW5Nb2RlID0gaXRlbTE3ID8gaXRlbTE3Lm1hcmdpbk1vZGUgOiAnJztcbiAgICAgICAgICAgICAgICBwYXJhbXMuc3ltYm9sID0gaXRlbTE3ID8gaXRlbTE3LnN5bWJvbCA6ICcnO1xuICAgICAgICAgICAgICAgIHBhcmFtcy5jb250cmFjdENvZGUgPSBpdGVtMTcgPyAoaXRlbTE3LmNvbnRyYWN0Q29kZSA/IGl0ZW0xNy5jb250cmFjdENvZGUgOiAnJykgOiAnJztcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGNhc2UgMTg6XG4gICAgICAgICAgICAgICAgbGV0IGl0ZW0xODtcbiAgICAgICAgICAgICAgICBpZiAoY2hpbGRUeXBlID09IDQpIHtcbiAgICAgICAgICAgICAgICAgICAgaXRlbTE4ID0gY2FjaGVEYXRhLmNvbnRyYWN0LnVzZHRfbS5hbGwubmV3TGlzdFtpbmRleF07XG4gICAgICAgICAgICAgICAgICAgIHBhcmFtcy50cmFkZVR5cGUgPSBcIjFcIjtcbiAgICAgICAgICAgICAgICB9IGVsc2UgaWYgKGNoaWxkVHlwZSA9PSA3KSB7XG4gICAgICAgICAgICAgICAgICAgIGl0ZW0xOCA9IGNhY2hlRGF0YS5jb250cmFjdC5jb2luX3AuYWxsLm5ld0xpc3RbaW5kZXhdO1xuICAgICAgICAgICAgICAgICAgICBwYXJhbXMudHJhZGVUeXBlID0gXCIyXCI7XG4gICAgICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICAgICAgaXRlbTE4ID0gY2FjaGVEYXRhLmNvbnRyYWN0LmNvaW5fZi5hbGwubmV3TGlzdFtpbmRleF07XG4gICAgICAgICAgICAgICAgICAgIHBhcmFtcy50cmFkZVR5cGUgPSBcIjNcIjtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgcGFyYW1zLnN5bWJvbCA9IGl0ZW0xOCA/IGl0ZW0xOC5zeW1ib2wgOiAnJztcbiAgICAgICAgICAgICAgICBwYXJhbXMuY29udHJhY3RDb2RlID0gaXRlbTE4ID8gKGl0ZW0xOC5jb250cmFjdENvZGUgPyBpdGVtMTguY29udHJhY3RDb2RlIDogJycpIDogJyc7XG4gICAgICAgICAgICAgICAgcGFyYW1zLnByb2ZpdFJhdGUgPSBpdGVtMTggPyBpdGVtMTgucHJvZml0UmF0ZSA6ICcwLjAnO1xuICAgICAgICAgICAgICAgIHBhcmFtcy5kaXJlY3Rpb24gPSBpdGVtMTggPyBpdGVtMTguZGlyZWN0aW9uIDogJyc7XG4gICAgICAgICAgICAgICAgcGFyYW1zLmxldmVyUmF0ZSA9IGl0ZW0xOCA/IGl0ZW0xOC5sZXZlclJhdGUgOiAnJztcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGNhc2UgMTE3OlxuICAgICAgICAgICAgICAgIGxldCBpdGVtMTE3O1xuICAgICAgICAgICAgICAgIGlmIChjaGlsZFR5cGUgPT0gNCkge1xuICAgICAgICAgICAgICAgICAgICBpdGVtMTE3ID0gY2FjaGVEYXRhLmNvbnRyYWN0LnVzZHRfbS5vd25lZC5uZXdMaXN0W2luZGV4XTtcbiAgICAgICAgICAgICAgICAgICAgcGFyYW1zLnRyYWRlVHlwZSA9IFwiMVwiO1xuICAgICAgICAgICAgICAgIH0gZWxzZSBpZiAoY2hpbGRUeXBlID09IDcpIHtcbiAgICAgICAgICAgICAgICAgICAgaXRlbTExNyA9IGNhY2hlRGF0YS5jb250cmFjdC5jb2luX3Aub3duZWQubmV3TGlzdFtpbmRleF07XG4gICAgICAgICAgICAgICAgICAgIHBhcmFtcy50cmFkZVR5cGUgPSBcIjJcIjtcbiAgICAgICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICBpdGVtMTE3ID0gY2FjaGVEYXRhLmNvbnRyYWN0LmNvaW5fZi5vd25lZC5uZXdMaXN0W2luZGV4XTtcbiAgICAgICAgICAgICAgICAgICAgcGFyYW1zLnRyYWRlVHlwZSA9IFwiM1wiO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICBwYXJhbXMubWFyZ2luTW9kZSA9IGl0ZW0xMTcgPyBpdGVtMTE3Lm1hcmdpbk1vZGUgOiAnJztcbiAgICAgICAgICAgICAgICBwYXJhbXMuc3ltYm9sID0gaXRlbTExNyA/IGl0ZW0xMTcuc3ltYm9sIDogJyc7XG4gICAgICAgICAgICAgICAgcGFyYW1zLmNvbnRyYWN0Q29kZSA9IGl0ZW0xMTcgPyAoaXRlbTExNy5jb250cmFjdENvZGUgPyBpdGVtMTE3LmNvbnRyYWN0Q29kZSA6ICcnKSA6ICcnO1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSAxMTg6XG4gICAgICAgICAgICAgICAgbGV0IGl0ZW0xMTg7XG4gICAgICAgICAgICAgICAgaWYgKGNoaWxkVHlwZSA9PSA0KSB7XG4gICAgICAgICAgICAgICAgICAgIGl0ZW0xMTggPSBjYWNoZURhdGEuY29udHJhY3QudXNkdF9tLm93bmVkLm5ld0xpc3RbaW5kZXhdO1xuICAgICAgICAgICAgICAgICAgICBwYXJhbXMudHJhZGVUeXBlID0gXCIxXCI7XG4gICAgICAgICAgICAgICAgfSBlbHNlIGlmIChjaGlsZFR5cGUgPT0gNykge1xuICAgICAgICAgICAgICAgICAgICBpdGVtMTE4ID0gY2FjaGVEYXRhLmNvbnRyYWN0LmNvaW5fcC5vd25lZC5uZXdMaXN0W2luZGV4XTtcbiAgICAgICAgICAgICAgICAgICAgcGFyYW1zLnRyYWRlVHlwZSA9IFwiMlwiO1xuICAgICAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgICAgIGl0ZW0xMTggPSBjYWNoZURhdGEuY29udHJhY3QuY29pbl9mLm93bmVkLm5ld0xpc3RbaW5kZXhdO1xuICAgICAgICAgICAgICAgICAgICBwYXJhbXMudHJhZGVUeXBlID0gXCIzXCI7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIHBhcmFtcy5zeW1ib2wgPSBpdGVtMTE4ID8gaXRlbTExOC5zeW1ib2wgOiAnJztcbiAgICAgICAgICAgICAgICBwYXJhbXMuY29udHJhY3RDb2RlID0gaXRlbTExOCA/IChpdGVtMTE4LmNvbnRyYWN0Q29kZSA/IGl0ZW0xMTguY29udHJhY3RDb2RlIDogJycpIDogJyc7XG4gICAgICAgICAgICAgICAgcGFyYW1zLnByb2ZpdFJhdGUgPSBpdGVtMTE4ID8gaXRlbTExOC5wcm9maXRSYXRlIDogJzAuMCc7XG4gICAgICAgICAgICAgICAgcGFyYW1zLmRpcmVjdGlvbiA9IGl0ZW0xMTggPyBpdGVtMTE4LmRpcmVjdGlvbiA6ICcnO1xuICAgICAgICAgICAgICAgIHBhcmFtcy5sZXZlclJhdGUgPSBpdGVtMTE4ID8gaXRlbTExOC5sZXZlclJhdGUgOiAnJztcbiAgICAgICAgICAgICAgICBwYXJhbXMub3BlblByaWNlID0gaXRlbTExOCA/IGl0ZW0xMTguY29zdE9wZW4gOiAnJztcbiAgICAgICAgICAgICAgICBwYXJhbXMubGFzdFByaWNlID0gaXRlbTExOCA/IGl0ZW0xMTgubGFzdFByaWNlIDogJyc7XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIDE5OlxuICAgICAgICAgICAgY2FzZSAyMTpcbiAgICAgICAgICAgICAgICBsZXQgaXRlbTE5ID0gY2FjaGVEYXRhLm90Yy5uZXdMaXN0W2luZGV4XTtcbiAgICAgICAgICAgICAgICBwYXJhbXMuY29pbklEID0gaXRlbTE5LmNvaW5JZDtcbiAgICAgICAgICAgICAgICBwYXJhbXMuY3VycmVuY3kgPSBpdGVtMTkuY29pbk5hbWU7XG4gICAgICAgICAgICAgICAgcGFyYW1zLnRvdGFsID0gaXRlbTE5LnRvdGFsO1xuICAgICAgICAgICAgICAgIHBhcmFtcy5mcm96ZW4gPSBpdGVtMTkuZnJvemVuO1xuICAgICAgICAgICAgICAgIHBhcmFtcy5ib3Jyb3cgPSBpdGVtMTkuYm9ycm93O1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSAyMDpcbiAgICAgICAgICAgICAgICBsZXQgaXRlbTIwID0gY2FjaGVEYXRhLm90Yy5uZXdMaXN0W2luZGV4XTtcbiAgICAgICAgICAgICAgICBwYXJhbXMuY3VycmVuY3kgPSBpdGVtMjAuY29pbk5hbWU7XG4gICAgICAgICAgICAgICAgcGFyYW1zLnRvdGFsID0gaXRlbTE5LnRvdGFsO1xuICAgICAgICAgICAgICAgIHBhcmFtcy5mcm96ZW4gPSBpdGVtMTkuZnJvemVuO1xuICAgICAgICAgICAgICAgIHBhcmFtcy5ib3Jyb3cgPSBpdGVtMTkuYm9ycm93O1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSAyMjpcbiAgICAgICAgICAgICAgICBsZXQgaXRlbTIyID0gY2FjaGVEYXRhLmVhcm4uZWFyblliYi5uZXdMaXN0W2luZGV4XTtcbiAgICAgICAgICAgICAgICBwYXJhbXMucHJvamVjdEluZm9VcmwgPSBpdGVtMjIgPyBpdGVtMjIucHJvamVjdEluZm9VcmwgOiAnJztcbiAgICAgICAgICAgICAgICBwYXJhbXMudHlwZSA9IDIyO1xuICAgICAgICAgICAgICAgIGFuYWx5c2lzUGFyYW1zLnRyYWNrID0gXCJhcHBfYXNzZXRzX0Vhcm5fY3VycmVuY3lfYnV0dG9uX2NsaWNrXCI7XG4gICAgICAgICAgICAgICAgYW5hbHlzaXNQYXJhbXMucHJvcGVydGllcyA9IHtcbiAgICAgICAgICAgICAgICAgICAgXCJ0YWJOYW1lXCI6IFwiZmxleGlibGVcIixcbiAgICAgICAgICAgICAgICAgICAgXCJidXR0b25OYW1lXCI6IFwiZGVwb3NpdFwiLFxuICAgICAgICAgICAgICAgICAgICBcImN1cnJlbmN5XCI6IGl0ZW0yMi5jdXJyZW5jeVxuICAgICAgICAgICAgICAgIH07XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIDI0OlxuICAgICAgICAgICAgICAgIC8v5bey57uP6KKrMjA45Luj5pu/77yM5pqC5pe25rKh5pyJ55So77yM5ouF5b+D5Yir55qE5Zyw5pa55L2/55So5pqC5pe25L+d55WZ77yM5ZCO6Z2i56Gu6K6k5peg55So5ZCO5Yig6ZmkXG4gICAgICAgICAgICAgICAgbGV0IGl0ZW0yNCA9IGNhY2hlRGF0YS5lYXJuLmVhcm5ZYmIubmV3TGlzdFtpbmRleF07XG4gICAgICAgICAgICAgICAgcGFyYW1zLm9yZGVySWQgPSBpdGVtMjQub3JkZXJJZDtcbiAgICAgICAgICAgICAgICBwYXJhbXMucHJvamVjdFR5cGUgPSBcIjBcIjtcbiAgICAgICAgICAgICAgICBhbmFseXNpc1BhcmFtcy50cmFjayA9IFwiYXBwX2Fzc2V0c19FYXJuX2N1cnJlbmN5X2J1dHRvbl9jbGlja1wiO1xuICAgICAgICAgICAgICAgIGFuYWx5c2lzUGFyYW1zLnByb3BlcnRpZXMgPSB7XG4gICAgICAgICAgICAgICAgICAgIFwidGFiTmFtZVwiOiBcImZsZXhpYmxlXCIsXG4gICAgICAgICAgICAgICAgICAgIFwiYnV0dG9uTmFtZVwiOiBcImRldGFpbHNcIixcbiAgICAgICAgICAgICAgICAgICAgXCJjdXJyZW5jeVwiOiBpdGVtMjQuY3VycmVuY3lcbiAgICAgICAgICAgICAgICB9O1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSAyNTpcbiAgICAgICAgICAgICAgICBsZXQgaXRlbTI1ID0gY2FjaGVEYXRhLmVhcm4uZWFyblliYi5uZXdMaXN0W2luZGV4XTtcbiAgICAgICAgICAgICAgICBwYXJhbXMubWluaW5nWWVhclJhdGUgPSBpdGVtMjUubWluaW5nWWVhclJhdGU7XG4gICAgICAgICAgICAgICAgcGFyYW1zLmN1cnJlbmN5ID0gaXRlbTI1LmN1cnJlbmN5O1xuICAgICAgICAgICAgICAgIHBhcmFtcy5wcm9qZWN0VHlwZSA9IFwiMVwiO1xuICAgICAgICAgICAgICAgIGFuYWx5c2lzUGFyYW1zLnRyYWNrID0gXCJhcHBfYXNzZXRzX0Vhcm5fY3VycmVuY3lfYnV0dG9uX2NsaWNrXCI7XG4gICAgICAgICAgICAgICAgYW5hbHlzaXNQYXJhbXMucHJvcGVydGllcyA9IHtcbiAgICAgICAgICAgICAgICAgICAgXCJ0YWJOYW1lXCI6IFwiZmxleGlibGVcIixcbiAgICAgICAgICAgICAgICAgICAgXCJidXR0b25OYW1lXCI6IFwic2hhcmVcIixcbiAgICAgICAgICAgICAgICAgICAgXCJjdXJyZW5jeVwiOiBpdGVtMjUuY3VycmVuY3lcbiAgICAgICAgICAgICAgICB9O1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSAyNjpcbiAgICAgICAgICAgIGNhc2UgMjc6XG4gICAgICAgICAgICBjYXNlIDI4OlxuICAgICAgICAgICAgICAgIGxldCBpdGVtMjYgPSBjYWNoZURhdGEub3B0aW9uLm5ld0xpc3RbaW5kZXhdO1xuICAgICAgICAgICAgICAgIHBhcmFtcy5jdXJyZW5jeSA9IGl0ZW0yNi5jdXJyZW5jeTtcbiAgICAgICAgICAgICAgICBwYXJhbXMuYXZhaWxhYmxlTnVtID0gaXRlbTI2LmF2YWlsYWJsZU51bTtcbiAgICAgICAgICAgICAgICBwYXJhbXMucG9zaXRpb25OdW0gPSBpdGVtMjYucG9zaXRpb25OdW07XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIDI5OlxuICAgICAgICAgICAgICAgIGxldCBpdGVtMjkgPSBjYWNoZURhdGEub3B0aW9uLm5ld0xpc3RbaW5kZXhdO1xuICAgICAgICAgICAgICAgIHBhcmFtcy5jdXJyZW5jeSA9IGl0ZW0yOS5jdXJyZW5jeTtcbiAgICAgICAgICAgICAgICBwYXJhbXMucHJvZml0UmF0ZSA9IGl0ZW0yOVsncHJvZml0LWxvc3MtcmF0ZSddO1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSAzMjpcbiAgICAgICAgICAgIGNhc2UgMzQ6XG4gICAgICAgICAgICAgICAgbGV0IGl0ZW0zMiA9IGNhY2hlRGF0YS5tYXJnaW4uYWxsUmVwby5uZXdMaXN0W2luZGV4XTtcbiAgICAgICAgICAgICAgICBwYXJhbXMuaXNTdXBlck1hcmdpbiA9IHRydWU7XG4gICAgICAgICAgICAgICAgcGFyYW1zLmN1cnJlbmN5ID0gaXRlbTMyLmN1cnJlbmN5O1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSAzNTpcbiAgICAgICAgICAgICAgICBpZiAoaW5kZXggPT0gMCkge1xuICAgICAgICAgICAgICAgICAgICBhbmFseXNpc1BhcmFtcy50cmFjayA9IFwiYXBwX2Fzc2V0c19FYXJuX0Vhcm5Ob3dfY2xpY2tcIjtcbiAgICAgICAgICAgICAgICAgICAgYW5hbHlzaXNQYXJhbXMucHJvcGVydGllcyA9IHtcbiAgICAgICAgICAgICAgICAgICAgICAgIFwidGFiTmFtZVwiOiBcImZsZXhpYmxlXCJcbiAgICAgICAgICAgICAgICAgICAgfTtcbiAgICAgICAgICAgICAgICB9IGVsc2UgaWYgKGluZGV4ID09IDEpIHtcbiAgICAgICAgICAgICAgICAgICAgYW5hbHlzaXNQYXJhbXMudHJhY2sgPSBcImFwcF9hc3NldHNfRWFybl9FYXJuTm93X2NsaWNrXCI7XG4gICAgICAgICAgICAgICAgICAgIGFuYWx5c2lzUGFyYW1zLnByb3BlcnRpZXMgPSB7XG4gICAgICAgICAgICAgICAgICAgICAgICBcInRhYk5hbWVcIjogXCJmaXhlZFwiXG4gICAgICAgICAgICAgICAgICAgIH07XG4gICAgICAgICAgICAgICAgfSBlbHNlIGlmIChpbmRleCA9PSAyKSB7XG4gICAgICAgICAgICAgICAgICAgIGFuYWx5c2lzUGFyYW1zLnRyYWNrID0gXCJhcHBfYXNzZXRzX0Vhcm5fRWFybk5vd19jbGlja1wiO1xuICAgICAgICAgICAgICAgICAgICBhbmFseXNpc1BhcmFtcy5wcm9wZXJ0aWVzID0ge1xuICAgICAgICAgICAgICAgICAgICAgICAgXCJ0YWJOYW1lXCI6IFwibWF4RmxheGlibGVcIlxuICAgICAgICAgICAgICAgICAgICB9O1xuICAgICAgICAgICAgICAgIH1cblxuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSAzMzpcbiAgICAgICAgICAgICAgICBsZXQgaXRlbTMzID0gY2FjaGVEYXRhLm1hcmdpbi5hbGxSZXBvLm5ld0xpc3RbaW5kZXhdO1xuICAgICAgICAgICAgICAgIHBhcmFtcy5pc1N1cGVyTWFyZ2luID0gdHJ1ZTtcbiAgICAgICAgICAgICAgICBwYXJhbXMuY3VycmVuY3kgPSBpdGVtMzMuY3VycmVuY3k7XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIDM4OlxuICAgICAgICAgICAgICAgIGNvbnN0IGl0ZW0zOCA9IGNhY2hlRGF0YS5zcG90LnNwb3QubmV3TGlzdFtpbmRleF07XG4gICAgICAgICAgICAgICAgcGFyYW1zLmN1cnJlbmN5ID0gaXRlbTM4LmN1cnJlbmN5O1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSAxMzI6XG4gICAgICAgICAgICAgICAgbGV0IGl0ZW0xMzIgPSBjYWNoZURhdGEubWFyZ2luLnBhcnRSZXBvLm5ld0xpc3RbaW5kZXhdO1xuICAgICAgICAgICAgICAgIHBhcmFtcy50eXBlID0gMzI7XG4gICAgICAgICAgICAgICAgcGFyYW1zLmlzU3VwZXJNYXJnaW4gPSBmYWxzZTtcbiAgICAgICAgICAgICAgICBwYXJhbXMuY3VycmVuY3kgPSBpdGVtMTMyLmN1cnJlbmN5O1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSAxMzM6XG4gICAgICAgICAgICAgICAgbGV0IGl0ZW0xMzMgPSBjYWNoZURhdGEubWFyZ2luLnBhcnRSZXBvLm5ld0xpc3RbaW5kZXhdO1xuICAgICAgICAgICAgICAgIHBhcmFtcy50eXBlID0gMzM7XG4gICAgICAgICAgICAgICAgcGFyYW1zLmlzU3VwZXJNYXJnaW4gPSBmYWxzZTtcbiAgICAgICAgICAgICAgICBwYXJhbXMuY3VycmVuY3kgPSBpdGVtMTMzLmN1cnJlbmN5O1xuICAgICAgICAgICAgICAgIHBhcmFtcy5xdW90ZUN1cnJlbmN5ID0gaXRlbTEzMy5xdW90ZUN1cnJlbmN5O1xuICAgICAgICAgICAgICAgIHBhcmFtcy5iYXNlQ3VycmVuY3kgPSBpdGVtMTMzLmJhc2VDdXJyZW5jeTtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGNhc2UgMTM0OlxuICAgICAgICAgICAgICAgIGxldCBpdGVtMTM0ID0gY2FjaGVEYXRhLm1hcmdpbi5wYXJ0UmVwby5uZXdMaXN0W2luZGV4XTtcbiAgICAgICAgICAgICAgICBwYXJhbXMudHlwZSA9IDM0O1xuICAgICAgICAgICAgICAgIHBhcmFtcy5pc1N1cGVyTWFyZ2luID0gZmFsc2U7XG4gICAgICAgICAgICAgICAgcGFyYW1zLmN1cnJlbmN5ID0gaXRlbTEzNC5jdXJyZW5jeTtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGNhc2UgMTAyOlxuICAgICAgICAgICAgICAgIGxldCBpdGVtMTAyID0gY2FjaGVEYXRhLmVhcm4uZWFybkZpeGVkLm5ld0xpc3RbaW5kZXhdO1xuICAgICAgICAgICAgICAgIHBhcmFtcy5wcm9qZWN0SW5mb1VybCA9IGl0ZW0xMDIgPyBpdGVtMTAyLnByb2plY3RJbmZvVXJsIDogJyc7XG4gICAgICAgICAgICAgICAgcGFyYW1zLnR5cGUgPSAyMjtcbiAgICAgICAgICAgICAgICBhbmFseXNpc1BhcmFtcy50cmFjayA9IFwiYXBwX2Fzc2V0c19FYXJuX2N1cnJlbmN5X2J1dHRvbl9jbGlja1wiO1xuICAgICAgICAgICAgICAgIGFuYWx5c2lzUGFyYW1zLnByb3BlcnRpZXMgPSB7XG4gICAgICAgICAgICAgICAgICAgIFwidGFiTmFtZVwiOiBcImZpeGVkXCIsXG4gICAgICAgICAgICAgICAgICAgIFwiYnV0dG9uTmFtZVwiOiBcImRlcG9zaXRcIixcbiAgICAgICAgICAgICAgICAgICAgXCJjdXJyZW5jeVwiOiBpdGVtMTAyLmN1cnJlbmN5XG4gICAgICAgICAgICAgICAgfTtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGNhc2UgMTA0OlxuICAgICAgICAgICAgICAgIGxldCBpdGVtMTA0ID0gY2FjaGVEYXRhLmVhcm4uZWFybkZpeGVkLm5ld0xpc3RbaW5kZXhdO1xuICAgICAgICAgICAgICAgIHBhcmFtcy5vcmRlcklkID0gaXRlbTEwNCA/IGl0ZW0xMDQub3JkZXJJZCA6ICcnO1xuICAgICAgICAgICAgICAgIHBhcmFtcy5wcm9qZWN0VHlwZSA9IFwiMVwiO1xuICAgICAgICAgICAgICAgIHBhcmFtcy50eXBlID0gMjQ7XG4gICAgICAgICAgICAgICAgYW5hbHlzaXNQYXJhbXMudHJhY2sgPSBcImFwcF9hc3NldHNfRWFybl9jdXJyZW5jeV9idXR0b25fY2xpY2tcIjtcbiAgICAgICAgICAgICAgICBhbmFseXNpc1BhcmFtcy5wcm9wZXJ0aWVzID0ge1xuICAgICAgICAgICAgICAgICAgICBcInRhYk5hbWVcIjogXCJmaXhlZFwiLFxuICAgICAgICAgICAgICAgICAgICBcImJ1dHRvbk5hbWVcIjogXCJkZXRhaWxcIixcbiAgICAgICAgICAgICAgICAgICAgXCJjdXJyZW5jeVwiOiBpdGVtMTA0LmN1cnJlbmN5XG4gICAgICAgICAgICAgICAgfTtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGNhc2UgMTA1OlxuICAgICAgICAgICAgICAgIGxldCBpdGVtMTA1ID0gY2FjaGVEYXRhLmVhcm4uZWFybkZpeGVkLm5ld0xpc3RbaW5kZXhdO1xuICAgICAgICAgICAgICAgIHBhcmFtcy5taW5pbmdZZWFyUmF0ZSA9IGl0ZW0xMDUubWluaW5nWWVhclJhdGU7XG4gICAgICAgICAgICAgICAgcGFyYW1zLmN1cnJlbmN5ID0gaXRlbTEwNS5jdXJyZW5jeTtcbiAgICAgICAgICAgICAgICBwYXJhbXMucHJvamVjdFR5cGUgPSBcIjJcIjtcbiAgICAgICAgICAgICAgICBwYXJhbXMudHlwZSA9IDI1O1xuICAgICAgICAgICAgICAgIGFuYWx5c2lzUGFyYW1zLnRyYWNrID0gXCJhcHBfYXNzZXRzX0Vhcm5fY3VycmVuY3lfYnV0dG9uX2NsaWNrXCI7XG4gICAgICAgICAgICAgICAgYW5hbHlzaXNQYXJhbXMucHJvcGVydGllcyA9IHtcbiAgICAgICAgICAgICAgICAgICAgXCJ0YWJOYW1lXCI6IFwiZml4ZWRcIixcbiAgICAgICAgICAgICAgICAgICAgXCJidXR0b25OYW1lXCI6IFwic2hhcmVcIixcbiAgICAgICAgICAgICAgICAgICAgXCJjdXJyZW5jeVwiOiBpdGVtMTA1LmN1cnJlbmN5XG4gICAgICAgICAgICAgICAgfTtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGNhc2UgMTA2OlxuICAgICAgICAgICAgICAgIGxldCBpdGVtMTA2ID0gY2FjaGVEYXRhLmVhcm4uZWFybkhpZ2gubmV3TGlzdFtpbmRleF07XG4gICAgICAgICAgICAgICAgcGFyYW1zLnByb2plY3RJbmZvVXJsID0gaXRlbTEwNiA/IGl0ZW0xMDYucHJvamVjdEluZm9VcmwgOiAnJztcbiAgICAgICAgICAgICAgICBwYXJhbXMudHlwZSA9IDIyO1xuICAgICAgICAgICAgICAgIGFuYWx5c2lzUGFyYW1zLnRyYWNrID0gXCJhcHBfYXNzZXRzX0Vhcm5fY3VycmVuY3lfYnV0dG9uX2NsaWNrXCI7XG4gICAgICAgICAgICAgICAgYW5hbHlzaXNQYXJhbXMucHJvcGVydGllcyA9IHtcbiAgICAgICAgICAgICAgICAgICAgXCJ0YWJOYW1lXCI6IFwibWF4RmxheGlibGVcIixcbiAgICAgICAgICAgICAgICAgICAgXCJidXR0b25OYW1lXCI6IFwiZGVwb3NpdFwiLFxuICAgICAgICAgICAgICAgICAgICBcImN1cnJlbmN5XCI6IGl0ZW0xMDYuY3VycmVuY3lcbiAgICAgICAgICAgICAgICB9O1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSAxMDc6XG4gICAgICAgICAgICAgICAgbGV0IGl0ZW0xMDcgPSBjYWNoZURhdGEuZWFybi5lYXJuSGlnaC5uZXdMaXN0W2luZGV4XTtcbiAgICAgICAgICAgICAgICBwYXJhbXMub3JkZXJJZCA9IGl0ZW0xMDcgPyBpdGVtMTA3Lm9yZGVySWQgOiAnJztcbiAgICAgICAgICAgICAgICBwYXJhbXMucHJvamVjdFR5cGUgPSBcIjJcIjtcbiAgICAgICAgICAgICAgICBwYXJhbXMudHlwZSA9IDI0O1xuICAgICAgICAgICAgICAgIGFuYWx5c2lzUGFyYW1zLnRyYWNrID0gXCJhcHBfYXNzZXRzX0Vhcm5fY3VycmVuY3lfYnV0dG9uX2NsaWNrXCI7XG4gICAgICAgICAgICAgICAgYW5hbHlzaXNQYXJhbXMucHJvcGVydGllcyA9IHtcbiAgICAgICAgICAgICAgICAgICAgXCJ0YWJOYW1lXCI6IFwibWF4RmxheGlibGVcIixcbiAgICAgICAgICAgICAgICAgICAgXCJidXR0b25OYW1lXCI6IFwiZGV0YWlsXCIsXG4gICAgICAgICAgICAgICAgICAgIFwiY3VycmVuY3lcIjogaXRlbTEwNy5jdXJyZW5jeVxuICAgICAgICAgICAgICAgIH07XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIDEwODpcbiAgICAgICAgICAgICAgICBsZXQgaXRlbTEwOCA9IGNhY2hlRGF0YS5lYXJuLmVhcm5IaWdoLm5ld0xpc3RbaW5kZXhdO1xuICAgICAgICAgICAgICAgIHBhcmFtcy5taW5pbmdZZWFyUmF0ZSA9IGl0ZW0xMDgudG90YWxZZWFyUmF0ZTtcbiAgICAgICAgICAgICAgICBwYXJhbXMuY3VycmVuY3kgPSBpdGVtMTA4LmN1cnJlbmN5O1xuICAgICAgICAgICAgICAgIHBhcmFtcy5wcm9qZWN0VHlwZSA9IFwiM1wiO1xuICAgICAgICAgICAgICAgIHBhcmFtcy50eXBlID0gMjU7XG4gICAgICAgICAgICAgICAgYW5hbHlzaXNQYXJhbXMudHJhY2sgPSBcImFwcF9hc3NldHNfRWFybl9jdXJyZW5jeV9idXR0b25fY2xpY2tcIjtcbiAgICAgICAgICAgICAgICBhbmFseXNpc1BhcmFtcy5wcm9wZXJ0aWVzID0ge1xuICAgICAgICAgICAgICAgICAgICBcInRhYk5hbWVcIjogXCJtYXhGbGF4aWJsZVwiLFxuICAgICAgICAgICAgICAgICAgICBcImJ1dHRvbk5hbWVcIjogXCJzaGFyZVwiLFxuICAgICAgICAgICAgICAgICAgICBcImN1cnJlbmN5XCI6IGl0ZW0xMDguY3VycmVuY3lcbiAgICAgICAgICAgICAgICB9O1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSA1MTpcbiAgICAgICAgICAgICAgICBsZXQgaXRlbTUxID0gY2FjaGVEYXRhLmNvbnRyYWN0LmNvcHlfdHJhZGluZy5uZXdMaXN0W2luZGV4XTtcbiAgICAgICAgICAgICAgICBwYXJhbXMuc3ltYm9sID0gaXRlbTUxLnN5bWJvbDtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGNhc2UgNTI6XG4gICAgICAgICAgICAgICAgbGV0IGl0ZW01MiA9IGNhY2hlRGF0YS5jb250cmFjdC5jb3B5X3RyYWRpbmcubmV3TGlzdFtpbmRleF07XG4gICAgICAgICAgICAgICAgcGFyYW1zLnN5bWJvbCA9IGl0ZW01Mi5zeW1ib2w7XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIDU0OlxuICAgICAgICAgICAgICAgIGNvbnN0IGl0ZW01NCA9IGNhY2hlRGF0YS5zcG90LnNwb3QubmV3TGlzdFtpbmRleF07XG4gICAgICAgICAgICAgICAgcGFyYW1zLmN1cnJlbmN5ID0gaXRlbTU0LmN1cnJlbmN5O1xuICAgICAgICAgICAgICAgIHBhcmFtcy5maW5hbmNpYWxKdW1wVXJsID0gY2hlY2tGaWVsZChpdGVtNTQuZmluYW5jaWFsSnVtcFVybCwgbnVsbCk7XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIDEzNzpcbiAgICAgICAgICAgICAgICBjb25zdCBiYWxhbmNlID0gY2FjaGVEYXRhLmJhbGFuY2U7XG4gICAgICAgICAgICAgICAgcGFyYW1zLnVybCA9IGJhbGFuY2UuZWFybkp1bXBVcmw7XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIDEzODpcbiAgICAgICAgICAgICAgICBjb25zdCBpdGVtMTM4ID0gY2FjaGVEYXRhLmVhcm4uZWFybk5vZGVQbGVkZ2UubmV3TGlzdFtpbmRleF07XG4gICAgICAgICAgICAgICAgcGFyYW1zLnVybCA9IGl0ZW0xMzguc3Vic2NyaXB0aW9uVXJsO1xuICAgICAgICAgICAgICAgIGFuYWx5c2lzUGFyYW1zLnRyYWNrID0gXCJhcHBfYXNzZXRzX0Vhcm5fY3VycmVuY3lfYnV0dG9uX2NsaWNrXCI7XG4gICAgICAgICAgICAgICAgYW5hbHlzaXNQYXJhbXMucHJvcGVydGllcyA9IHtcbiAgICAgICAgICAgICAgICAgICAgXCJ0YWJOYW1lXCI6IFwic3Rha2luZ1wiLFxuICAgICAgICAgICAgICAgICAgICBcImJ1dHRvbk5hbWVcIjogXCJkZXBvc2l0XCIsXG4gICAgICAgICAgICAgICAgICAgIFwiY3VycmVuY3lcIjogaXRlbTEzOC5jdXJyZW5jeVxuICAgICAgICAgICAgICAgIH07XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIDEzOTpcbiAgICAgICAgICAgICAgICBjb25zdCBpdGVtMTM5ID0gY2FjaGVEYXRhLmVhcm4uZWFybk5vZGVQbGVkZ2UubmV3TGlzdFtpbmRleF07XG4gICAgICAgICAgICAgICAgcGFyYW1zLnVybCA9IGl0ZW0xMzkucHJvamVjdEluZm9Vcmw7XG4gICAgICAgICAgICAgICAgYW5hbHlzaXNQYXJhbXMudHJhY2sgPSBcImFwcF9hc3NldHNfRWFybl9jdXJyZW5jeV9idXR0b25fY2xpY2tcIjtcbiAgICAgICAgICAgICAgICBhbmFseXNpc1BhcmFtcy5wcm9wZXJ0aWVzID0ge1xuICAgICAgICAgICAgICAgICAgICBcInRhYk5hbWVcIjogXCJzdGFraW5nXCIsXG4gICAgICAgICAgICAgICAgICAgIFwiYnV0dG9uTmFtZVwiOiBcImRldGFpbFwiLFxuICAgICAgICAgICAgICAgICAgICBcImN1cnJlbmN5XCI6IGl0ZW0xMzkuY3VycmVuY3lcbiAgICAgICAgICAgICAgICB9O1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSAxNDA6XG4gICAgICAgICAgICAgICAgcGFyYW1zLnVybCA9IGNhY2hlRGF0YS5lYXJuLmVhcm5Ob2RlUGxlZGdlLmJhc2VJbmZvLmp1bXBVcmw7XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIDE0MTpcbiAgICAgICAgICAgICAgICBjb25zdCBpdGVtMTQxID0gY2FjaGVEYXRhLmVhcm4uZWFybk5vZGVQbGVkZ2UubmV3TGlzdFtpbmRleF07XG4gICAgICAgICAgICAgICAgcGFyYW1zLm1pbmluZ1llYXJSYXRlID0gaXRlbTE0MS50b3RhbFllYXJSYXRlO1xuICAgICAgICAgICAgICAgIHBhcmFtcy5jdXJyZW5jeSA9IGl0ZW0xNDEuY3VycmVuY3k7XG4gICAgICAgICAgICAgICAgcGFyYW1zLnByb2plY3RUeXBlID0gXCI0XCI7XG4gICAgICAgICAgICAgICAgcGFyYW1zLnR5cGUgPSAyNTtcbiAgICAgICAgICAgICAgICBhbmFseXNpc1BhcmFtcy50cmFjayA9IFwiYXBwX2Fzc2V0c19FYXJuX2N1cnJlbmN5X2J1dHRvbl9jbGlja1wiO1xuICAgICAgICAgICAgICAgIGFuYWx5c2lzUGFyYW1zLnByb3BlcnRpZXMgPSB7XG4gICAgICAgICAgICAgICAgICAgIFwidGFiTmFtZVwiOiBcInN0YWtpbmdcIixcbiAgICAgICAgICAgICAgICAgICAgXCJidXR0b25OYW1lXCI6IFwic2hhcmVcIixcbiAgICAgICAgICAgICAgICAgICAgXCJjdXJyZW5jeVwiOiBpdGVtMTQxLmN1cnJlbmN5XG4gICAgICAgICAgICAgICAgfTtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGNhc2UgMTQyOlxuXG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIDE0MzpcbiAgICAgICAgICAgICAgICBjb25zdCBqdW1wVXJsID0gY2FjaGVEYXRhLmJhbGFuY2UuY29udHJhY3RKdW1wVXJsO1xuICAgICAgICAgICAgICAgIGNvbnN0IGNvbnRyYWN0SnVtcFVybCA9IGAke2NvbW1vbkRhdGEud2ViVXJsfS8ke2NvbW1vbkRhdGEubGFuZ3VhZ2V9JHtqdW1wVXJsfWA7XG4gICAgICAgICAgICAgICAgb3BlblJvdXRlcihjb250cmFjdEp1bXBVcmwpO1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSAxNTU6XG4gICAgICAgICAgICAgICAgY29uc3QgaXRlbTE1NSA9IGNhY2hlRGF0YS5lYXJuLmVhcm5TaGFya0Zpbi5uZXdMaXN0W2luZGV4XTtcbiAgICAgICAgICAgICAgICBwYXJhbXMuY3VycmVuY3kgPSBpdGVtMTU1LmN1cnJlbmN5O1xuICAgICAgICAgICAgICAgIGlmIChpdGVtMTU1LnByb2R1Y3RTdGF0dXMgPT0gMikge1xuICAgICAgICAgICAgICAgICAgICBwYXJhbXMueWVhclJhdGUgPSBpdGVtMTU1LnRvdGFsWWVhclJhdGVUcmFuc2xhdGU7XG4gICAgICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICAgICAgcGFyYW1zLnllYXJSYXRlID0gYCR7aXRlbTE1NS50cmFuc2xhdGVNaW5ZZWFyUmF0ZX0tJHtpdGVtMTU1LnRyYW5zbGF0ZU1heFllYXJSYXRlfWA7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIHBhcmFtcy5wcm9qZWN0TmFtZSA9IGl0ZW0xNTUucHJvamVjdE5hbWU7XG4gICAgICAgICAgICAgICAgcGFyYW1zLnR5cGUgPSAxNTU7XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIDE1NjpcbiAgICAgICAgICAgICAgICBjb25zdCBpdGVtMTU2ID0gY2FjaGVEYXRhLmVhcm4uZWFyblNoYXJrRmluLm5ld0xpc3RbaW5kZXhdO1xuICAgICAgICAgICAgICAgIG9wZW5Sb3V0ZXIoaXRlbTE1Ni5zdWJzY3JpcHRpb25VcmwpO1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSAxNTc6XG4gICAgICAgICAgICAgICAgY29uc3QgaXRlbTE1NyA9IGNhY2hlRGF0YS5lYXJuLmVhcm5TaGFya0Zpbi5uZXdMaXN0W2luZGV4XTtcbiAgICAgICAgICAgICAgICBvcGVuUm91dGVyKGl0ZW0xNTcucHJvamVjdEluZm9VcmwpO1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSAyMDE6XG4gICAgICAgICAgICAgICAgb3BlblJvdXRlcihjdXJyZW5jeVVwZGF0ZURhdGEudXBncmFkZUp1bXBVcmwpXG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIDIwMjpcbiAgICAgICAgICAgICAgICBvcGVuUm91dGVyKGN1cnJlbmN5VXBkYXRlRGF0YS51cGdyYWRlRGV0YWlsVXJsKTtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGNhc2UgNTM6XG4gICAgICAgICAgICAgICAgLy/ot5/ljZXlt7Lnu4/ljrvmjonvvIzlkI7pnaLlj6/og73kvJrnlKjvvIzmmoLml7bkv53nlZnku6PnoIFcbiAgICAgICAgICAgICAgICBvcGVuUm91dGVyKFwiaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9Db250cmFjdC9Db3B5VHJhZGluZz9pbmRleD0wXCIpO1xuICAgICAgICAgICAgY2FzZSAyMDM6XG4gICAgICAgICAgICAgICAgY29uc3QgaXRlbTIwMyA9IGNhY2hlRGF0YS5zcG90LmJvdC5uZXdMaXN0W2luZGV4XTtcbiAgICAgICAgICAgICAgICBjb25zdCB0cmFkaW5nQm90VXJsID0gYCR7Y29tbW9uRGF0YS53ZWJVcmx9LyR7Y29tbW9uRGF0YS5sYW5ndWFnZX0vdHJhZGluZ2JvdC9oNS9teS1zdHJhdGVnaWVzP3Nob3diYXI9MSZzdHJhdGVneUlkPSR7aXRlbTIwMy5zdHJhdGVneUlkfWA7XG4gICAgICAgICAgICAgICAgb3BlblJvdXRlcih0cmFkaW5nQm90VXJsKTtcbiAgICAgICAgICAgICAgICBhbmFseXNpc1BhcmFtcy50cmFjayA9IFwiYXBwX3dhbGxldF9zcG90Ym90c19kcmF3ZXJfY2xvc2VfY2xpY2tcIjtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGNhc2UgMjA0OlxuICAgICAgICAgICAgICAgIC8vIOWIm+W7uuWQiOe6pue9keagvFxuICAgICAgICAgICAgICAgIGNvbnN0IGl0ZW0yMDQgPSBjYWNoZURhdGEuY29udHJhY3RHcmlkLm5ld0xpc3RbaW5kZXhdO1xuICAgICAgICAgICAgICAgIGNvbnN0IHN5bWJvbDIwNCA9IGl0ZW0yMDQuc3ltYm9sLnRvVXBwZXJDYXNlKCk7XG4gICAgICAgICAgICAgICAgb3BlblJvdXRlcihgaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTEmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS90cmFkZS9jb250cmFjdEdyaWQ/c291cmNlPWFwcF9ib3RzX2Fzc2V0c3BhZ2Umc3ltYm9sPSR7c3ltYm9sMjA0fWApO1xuICAgICAgICAgICAgICAgIGFuYWx5c2lzUGFyYW1zLnRyYWNrID0gXCJhcHBfd2FsbGV0X2Z1dHVyZXNib3RzX2RyYXdlcl9jcmVhdGVfY2xpY2tcIjtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGNhc2UgMjA1OlxuICAgICAgICAgICAgICAgIC8vIOWQiOe6pue9keagvOivpuaDhVxuICAgICAgICAgICAgICAgIGNvbnN0IGl0ZW0yMDUgPSBjYWNoZURhdGEuY29udHJhY3RHcmlkLm5ld0xpc3RbaW5kZXhdO1xuICAgICAgICAgICAgICAgIG9wZW5Sb3V0ZXIoYGhvbGlnZWl0Oi8vb3Blbi92MT9sb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vdHJhZGUvY29udHJhY3RCb3REZXRhaWw/c291cmNlPWFwcF9ib3RzX2Fzc2V0c3BhZ2Umc3RyYXRlZ3lJZD0ke2l0ZW0yMDUuc3RyYXRlZ3lJZH1gKTtcbiAgICAgICAgICAgICAgICBhbmFseXNpc1BhcmFtcy50cmFjayA9IFwiYXBwX3dhbGxldF9mdXR1cmVzYm90c2RyYXdlcl9kZXRhaWxfY2xpY2tcIjtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgIGNhc2UgMjA2OlxuICAgICAgICAgICAgICAgIGNvbnN0IGl0ZW0yMDYgPSBjYWNoZURhdGEuY29udHJhY3RHcmlkLm5ld0xpc3RbaW5kZXhdO1xuICAgICAgICAgICAgICAgIGNsaWNrZWRTdHJhdGVneUlkID0gaXRlbTIwNi5zdHJhdGVneUlkO1xuICAgICAgICAgICAgICAgICRkYXRhLnN0b3BQb3BTaG93ID0gXCJ0cnVlXCI7XG4gICAgICAgICAgICAgICAgYW5hbHlzaXNQYXJhbXMudHJhY2sgPSBcImFwcF93YWxsZXRfZnV0dXJlc2JvdHNfZHJhd2VyX2Nsb3NlX2NsaWNrXCI7XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIDIwNzpcbiAgICAgICAgICAgICAgICBjb25zdCBpdGVtMjA3ID0gY2FjaGVEYXRhLmNvbnRyYWN0R3JpZC5uZXdMaXN0W2luZGV4XTtcbiAgICAgICAgICAgICAgICBwYXJhbXMuc3RyYXRlZ3lJZCA9IGl0ZW0yMDcuc3RyYXRlZ3lJZDtcbiAgICAgICAgICAgICAgICBwYXJhbXMuc3ltYm9sID0gaXRlbTIwNy5zeW1ib2w7XG4gICAgICAgICAgICAgICAgYW5hbHlzaXNQYXJhbXMudHJhY2sgPSBcImFwcF93YWxsZXRfZnV0dXJlc2JvdHNfZHJhd2VyX3NoYXJlX2NsaWNrXCI7XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIDIwODpcbiAgICAgICAgICAgICAgICBsZXQgaXRlbTIwOCA9IGNhY2hlRGF0YS5lYXJuLmVhcm5ZYmIubmV3TGlzdFtpbmRleF07XG4gICAgICAgICAgICAgICAgb3BlblJvdXRlcihgJHtjb21tb25EYXRhLndlYlVybH0vJHtjb21tb25EYXRhLmxhbmd1YWdlfS8ke2l0ZW0yMDguZGV0YWlsVXJsfWApO1xuICAgICAgICAgICAgICAgIGFuYWx5c2lzUGFyYW1zLnRyYWNrID0gXCJhcHBfYXNzZXRzX0Vhcm5fY3VycmVuY3lfYnV0dG9uX2NsaWNrXCI7XG4gICAgICAgICAgICAgICAgYW5hbHlzaXNQYXJhbXMucHJvcGVydGllcyA9IHtcbiAgICAgICAgICAgICAgICAgICAgXCJ0YWJOYW1lXCI6IFwiZmxleGlibGVcIixcbiAgICAgICAgICAgICAgICAgICAgXCJidXR0b25OYW1lXCI6IFwiZGV0YWlsc1wiLFxuICAgICAgICAgICAgICAgICAgICBcImN1cnJlbmN5XCI6IGl0ZW0yMDguY3VycmVuY3lcbiAgICAgICAgICAgICAgICB9O1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgZGVmYXVsdDpcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgfVxuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5lcnJvcihganVtcCBwYXJzZSBhcmcgJHtlfWApO1xuICAgIH1cbiAgICBpZiAoYW5hbHlzaXNQYXJhbXMudHJhY2subGVuZ3RoID4gMCkge1xuICAgICAgICBhbmFseXRpY3MoYW5hbHlzaXNQYXJhbXMudHJhY2ssIGFuYWx5c2lzUGFyYW1zLnByb3BlcnRpZXMpO1xuICAgIH1cbiAgICBpZiAodHlwZSA9PSA5ICYmIGV4Y2hhbmdlRW5hYmxlKSB7XG4gICAgICBpZiAocGFyYW1zLmN1cnJlbmN5LnRvTG93ZXJDYXNlKCkgPT0gXCJ1c2R0XCIpIHtcbiAgICAgICAgb3BlblJvdXRlcihgJHtleGNoYW5nZUp1bXBVcmx9P2Zyb209VVNEVCZ0bz1VU0REYCk7XG4gICAgICAgIHJldHVybjtcbiAgICAgIH1cbiAgICAgIGlmIChwYXJhbXMuY3VycmVuY3kudG9Mb3dlckNhc2UoKSA9PSBcInVzZGRcIikge1xuICAgICAgICBvcGVuUm91dGVyKGAke2V4Y2hhbmdlSnVtcFVybH0/ZnJvbT1VU0REJnRvPVVTRFRgKTtcbiAgICAgICAgcmV0dXJuO1xuICAgICAgfVxuICAgIH1cbiAgICBpZiAodHlwZSA9PSA0MSkge1xuICAgICAgICBpZiAoJGRhdGEucHJvZml0UmVkID09ICd2aXNpYmxlJykge1xuICAgICAgICAgICAgJGRhdGEucHJvZml0UmVkID0gJ2dvbmUnO1xuICAgICAgICAgICAgJG5hdGl2ZUFQSS5qdW1wKEpTT04uc3RyaW5naWZ5KHBhcmFtcykpO1xuICAgICAgICB9XG4gICAgfSBlbHNlIGlmICh0eXBlID09IDEwKSB7XG4gICAgICAgIG9wZW5Sb3V0ZXIoYGhvbGlnZWl0Oi8vb3Blbi92MT9sb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vZWRnZWVuZ2luZS9jb250YWluZXI/c2NlbmU9ZWFybiZyb290TmFtZT1jb2luZGV0YWlsJm5hdkNvbmZpZz0mY3VycmVuY3k9JHtwYXJhbXMuY3VycmVuY3l9JnN0YWJsZT0ke3BhcmFtcy5zdGFibGV9YCk7XG4gICAgfSBlbHNlIGlmICh0eXBlID09IDIwNikge1xuICAgIH0gZWxzZSBpZiAodHlwZSA9PSAyMiB8fCB0eXBlID09IDEwMikge1xuICAgICAgICBjb25zdCB1cmxQYXRoID0gcGFyYW1zLnByb2plY3RJbmZvVXJsXG4gICAgICAgIGlmICh1cmxQYXRoLmluZGV4T2YoXCJob2xpZ2VpdFwiKSA9PSAwIHx8IHVybFBhdGguaW5kZXhPZihcImh0dHBcIikgPT0gMCkge1xuICAgICAgICAgICAgb3BlblJvdXRlcih1cmxQYXRoKTtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICRuYXRpdmVBUEkuanVtcChKU09OLnN0cmluZ2lmeShwYXJhbXMpKTtcbiAgICAgICAgfVxuICAgIH0gZWxzZSB7XG4gICAgICAgICRuYXRpdmVBUEkuanVtcChKU09OLnN0cmluZ2lmeShwYXJhbXMpKTtcbiAgICB9XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBhbmFseXRpY3MoZXZlbnQgPSBcIlwiLCBwcm9wZXJ0aWVzID0ge30pIHtcbiAgICBjb25zdCBwcm9wZXJ0aWVzSnNvbiA9IEpTT04uc3RyaW5naWZ5KHByb3BlcnRpZXMpO1xuICAgIGNvbnNvbGUubG9nKGBhbmFseXRpY3MgZXZlbnQ6ICR7ZXZlbnR9LCBwcm9wZXJ0aWVzSnNvbiA9ICR7cHJvcGVydGllc0pzb259YCk7XG4gICAgdmFyIG1hcCA9IHtcbiAgICAgICAgZXZlbnQ6IGV2ZW50LFxuICAgICAgICBwcm9wZXJ0aWVzOiBwcm9wZXJ0aWVzSnNvblxuICAgIH07XG4gICAgYXdhaXQgJG5hdGl2ZUFQSS5hbmFseXRpY3MobWFwKTtcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIG9wZW5Sb3V0ZXIodXJsKSB7XG4gICAgaWYgKCFjbGlja2FibGUpIHtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICBjb25zb2xlLmxvZyhgb3BlbiB1cmw6YCwgdXJsKTtcbiAgICBpZiAodXJsICYmIHVybCAhPSBudWxsICYmIHVybC5sZW5ndGggPiAwKSB7XG4gICAgICAgIGF3YWl0ICRuYXRpdmVBUEkub3BlblJvdXRlKHVybCk7XG4gICAgfVxuICAgIGNsaWNrYWJsZSA9IGZhbHNlO1xuICAgIHNldFRpbWVvdXQoKCkgPT4ge1xuICAgICAgICBjbGlja2FibGUgPSB0cnVlO1xuICAgIH0sIDEwMDApO1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gY3VycmVuY3lDaGFuZ2UoKSB7XG4gICAgY29uc29sZS5sb2coJ2N1cnJlbmN5IGNoYW5nZScpO1xuICAgIGdldFRvdGFsQXNzZXRDdXJyZW5jeSgpLnRoZW4oY3VycmVuY3kgPT4ge1xuICAgICAgICAkZGF0YS5jdXJyZW5jeSA9IGN1cnJlbmN5LnRvVXBwZXJDYXNlKCk7XG4gICAgfSk7XG4gICAgdXBkYXRlUGFnZURhdGFCeVR5cGUoY3VycmVudERpc3RyaWJ1dGlvblR5cGUsIDApO1xufVxuXG5jb25zdCBUQUcgPSBcImVuZ2luZVwiO1xuY29uc3QgSElEREVOX1NUUiA9ICcqKioqJztcbmNvbnN0IERFRkFVTFRfU1RSID0gJzAuMDAnO1xuY29uc3QgUklTS19ISUdIID0gMC4zO1xudmFyIERpc3RyaWJ1dGlvblR5cGU7XG4oZnVuY3Rpb24gKERpc3RyaWJ1dGlvblR5cGUpIHtcbiAgICBEaXN0cmlidXRpb25UeXBlW1wic3BvdFwiXSA9IFwiMVwiO1xuICAgIERpc3RyaWJ1dGlvblR5cGVbXCJwYXJ0UmVwb1wiXSA9IFwiMlwiO1xuICAgIERpc3RyaWJ1dGlvblR5cGVbXCJhbGxSZXBvXCJdID0gXCIzXCI7XG4gICAgRGlzdHJpYnV0aW9uVHlwZVtcInVzZHRNXCJdID0gXCI0XCI7XG4gICAgRGlzdHJpYnV0aW9uVHlwZVtcIm90Y1wiXSA9IFwiNVwiO1xuICAgIERpc3RyaWJ1dGlvblR5cGVbXCJtaW5pbmdQb29sXCJdID0gXCI2XCI7XG4gICAgRGlzdHJpYnV0aW9uVHlwZVtcImNvaW5QXCJdID0gXCI3XCI7XG4gICAgRGlzdHJpYnV0aW9uVHlwZVtcImMyY091dFwiXSA9IFwiOFwiO1xuICAgIERpc3RyaWJ1dGlvblR5cGVbXCJjMmNJblwiXSA9IFwiOVwiO1xuICAgIERpc3RyaWJ1dGlvblR5cGVbXCJlYXJuXCJdID0gXCIxN1wiO1xuICAgIERpc3RyaWJ1dGlvblR5cGVbXCJjb2luRnV0dXJlc1wiXSA9IFwiMTFcIjtcbiAgICBEaXN0cmlidXRpb25UeXBlW1wib3B0aW9uXCJdID0gXCIxM1wiO1xuICAgIERpc3RyaWJ1dGlvblR5cGVbXCJvcHRpb25PdXRcIl0gPSBcIjEyXCI7XG4gICAgRGlzdHJpYnV0aW9uVHlwZVtcImNvbGxhdGVyYWxcIl0gPSBcIjE0XCI7XG4gICAgRGlzdHJpYnV0aW9uVHlwZVtcImJvdFwiXSA9IFwiMTVcIjtcbiAgICBEaXN0cmlidXRpb25UeXBlW1wibWluaW5nRWFyblwiXSA9IFwiMTZcIjtcbiAgICBEaXN0cmlidXRpb25UeXBlW1wiZWFybkZpeGVkXCJdID0gXCIxOFwiO1xuICAgIERpc3RyaWJ1dGlvblR5cGVbXCJjb250cmFjdENvcHlcIl0gPSBcIjE5XCI7XG4gICAgRGlzdHJpYnV0aW9uVHlwZVtcImVhcm5IaWdoXCJdID0gXCIyMFwiO1xuICAgIERpc3RyaWJ1dGlvblR5cGVbXCJlYXJuTm9kZVBsZWRnZVwiXSA9IFwiMjFcIjtcbiAgICBEaXN0cmlidXRpb25UeXBlW1wiZWFyblNoYXJrRmluXCJdID0gXCIyMlwiO1xuICAgIERpc3RyaWJ1dGlvblR5cGVbXCJjb250cmFjdEdyaWRcIl0gPSBcIjI1XCI7XG59KShEaXN0cmlidXRpb25UeXBlIHx8IChEaXN0cmlidXRpb25UeXBlID0ge30pKTtcbnZhciBTeW1ib2xzO1xuKGZ1bmN0aW9uIChTeW1ib2xzKSB7XG4gICAgU3ltYm9sc1tcImJ0Y1wiXSA9IFwiYnRjXCI7XG4gICAgU3ltYm9sc1tcInVzZHRcIl0gPSBcInVzZHRcIjtcbn0pKFN5bWJvbHMgfHwgKFN5bWJvbHMgPSB7fSkpO1xuY29uc3QgREVGQVVMVF9DQUNIRSA9IHtcbiAgICBzcG90OiB7XG4gICAgICAgIHNwb3Q6IHsgYmFzZUluZm86IHt9IH0sXG4gICAgICAgIGJvdDogeyBiYXNlSW5mbzoge30gfSxcbiAgICAgICAgY29sbGF0ZXJhbDogeyBiYXNlSW5mbzoge30gfVxuICAgIH0sXG4gICAgY29udHJhY3Q6IHtcbiAgICAgICAgY29pbl9mOiB7XG4gICAgICAgICAgICBiYXNlSW5mbzoge30sXG4gICAgICAgICAgICBhbGw6IHt9LFxuICAgICAgICAgICAgb3duZWQ6IHt9XG4gICAgICAgIH0sXG4gICAgICAgIGNvaW5fcDoge1xuICAgICAgICAgICAgYmFzZUluZm86IHt9LFxuICAgICAgICAgICAgYWxsOiB7fSxcbiAgICAgICAgICAgIG93bmVkOiB7fVxuICAgICAgICB9LFxuICAgICAgICB1c2R0X206IHtcbiAgICAgICAgICAgIGJhc2VJbmZvOiB7fSxcbiAgICAgICAgICAgIGFsbDoge30sXG4gICAgICAgICAgICBvd25lZDoge31cbiAgICAgICAgfSxcbiAgICAgICAgdXNkdF9tX3VuaXR5OiB7XG4gICAgICAgICAgICBiYXNlSW5mbzoge30sXG4gICAgICAgICAgICBhbGw6IHt9LFxuICAgICAgICAgICAgb3duZWQ6IHt9LFxuICAgICAgICAgICAgYXNzZXRUeXBlOiAyXG4gICAgICAgIH0sXG4gICAgICAgIGNvcHlfdHJhZGluZzoge1xuICAgICAgICAgICAgYmFzZUluZm86IHt9LFxuICAgICAgICB9XG5cbiAgICB9LFxuICAgIG90YzogeyBiYXNlSW5mbzoge30gfSxcbiAgICBvcHRpb246IHsgYmFzZUluZm86IHt9IH0sXG4gICAgZWFybjoge1xuICAgICAgICBlYXJuWWJiOiB7IGJhc2VJbmZvOiB7fSB9LFxuICAgICAgICBlYXJuRml4ZWQ6IHsgYmFzZUluZm86IHt9IH0sXG4gICAgICAgIGVhcm5IaWdoOiB7IGJhc2VJbmZvOiB7fSB9LFxuICAgICAgICBlYXJuTm9kZVBsZWRnZTogeyBiYXNlSW5mbzoge30gfSxcbiAgICAgICAgZWFyblNoYXJrRmluOiB7IGJhc2VJbmZvOiB7fSB9XG4gICAgfSxcbiAgICBtYXJnaW46IHtcbiAgICAgICAgYWxsUmVwbzogeyBiYXNlSW5mbzoge30gfSxcbiAgICAgICAgcGFydFJlcG86IHsgYmFzZUluZm86IHt9IH1cbiAgICB9LFxuICAgIGNvbnRyYWN0R3JpZDogeyBiYXNlSW5mbzoge30gfSxcbn07XG52YXIgY2FjaGVEYXRhID0gREVGQVVMVF9DQUNIRTtcbmNvbnN0IGJhbGFuY2VBc3NldFBhdGggPSBcInYxL29wZW4vcHJvZml0L2hvbWUvYmFsYW5jZS1hc3NldHNcIjtcbmNvbnN0IHNlbGxMaXN0UGF0aCA9IFwidjEvaG9sZGluZy90cmFuc2Zlci9zZWxsL2xpc3RcIjtcbmNvbnN0IHNwb3RQYXRoID0gXCJ2MS9hc3NldC9wcm9maXQvcGFnZS9hcGkvY2hlY2svc3BvdFwiO1xuY29uc3Qgc3BvdEFjY291bnRJbmZvUGF0aCA9IFwidjEvb3Blbi9wcm9maXQvYXNzZXRzL3Nwb3RzXCI7XG4vLyBjb25zdCBzcG90Qm90SW5mb1BhdGggPSBcInYxL3F1YW50aXphdGlvbi9ncmlkZGluZy9zdHJhdGVneS1saXN0XCI7XG5jb25zdCBzcG90Qm90SW5mb1BhdGggPSBcInYxL29wZW4vcHJvZml0L2Fzc2V0L3RyYWRpbmdib3QvbGlzdFwiO1xuY29uc3Qgc3BvdENvbGxhdGVyYWxJbmZvUGF0aCA9IFwidjEvb3Blbi9wcm9maXQvYXNzZXRzL3BsZWRnZVwiO1xuY29uc3QgY29udHJhY3RDb2luUGVycGV0dWFsUGF0aCA9IFwidjEvb3Blbi9wcm9maXQvY29udHJhY3QvY29pblN3YXAvYWNjb3VudEluZm9cIjtcbmNvbnN0IGNvbnRyYWN0Q29pbkZ1dHVyZXNQYXRoID0gXCJ2MS9vcGVuL3Byb2ZpdC9jb250cmFjdC9jb2luL2FjY291bnRJbmZvXCI7XG5jb25zdCBjb250cmFjdFVzZHRNUGF0aCA9IFwidjEvb3Blbi9wcm9maXQvY29udHJhY3QvbGluZWFyL2FjY291bnRJbmZvXCI7XG5jb25zdCBjb250cmFjdENvcHlUcmFkaW5nUGF0aCA9IFwidjEvb3Blbi9wcm9maXQvY29udHJhY3QvbGluZWFyL2RvY3VtZW50YXJ5X2FjY291bnRcIjtcbmNvbnN0IGNvbnRyYWN0VXNkdE1Vbml0eVBhdGggPSBcInYxL29wZW4vcHJvZml0L2NvbnRyYWN0L2xpbmVhci91bml0eV9hY2NvdW50X3Bvc2l0aW9uX2luZm8vdjJcIjtcbmNvbnN0IGJhbGFuY2VGaW5hbmNpYWxCYW5uZXJQYXRoID0gXCJ2MS9vcGVuL3Byb2ZpdC9hc3NldHMvZmluYW5jaWFsXCI7XG5jb25zdCBiYWxhbmNlRGVwb3NpdFJlY29tbWVuZFBhdGggPSBcInYxL29wZW4vcHJvZml0L2Fzc2V0cy9ob21lL3JlY29tbWVuZFwiO1xuY29uc3QgYmFsYW5jZVJvY2tldFBhdGggPSBcInYxL29wZW4vcHJvZml0L2hvbWUvcm9ja2V0XCI7XG5jb25zdCBpbmRleFBpcmNlUGF0aCA9IFwidjEvb3Blbi9wcm9maXQvY3VycmVuY3kvdXNkdFByaWNlL3YyXCI7XG5jb25zdCBmYWxsQ29pblBhdGggPSBcInYxL29wZW4vcHJvZml0L2hvbWUvcmVtb3ZlL2N1cnJlbmN5L2RldGFpbFwiO1xuY29uc3QgY29udHJhY3RHcmlkSW5mb1BhdGggPSBcInYxL29wZW4vcHJvZml0L2Fzc2V0L2NvbnRyYWN0R3JpZC9saXN0XCI7XG5jb25zdCBjb250cmFjdEdyaWRTdG9wUGF0aCA9IFwidjEvZ3JpZHN0cmF0ZWd5L3N1Ym1pdC1zdG9wXCI7XG5jb25zdCBkZXBvc2l0V2l0aGRyYXdQYXRoID0gXCJ2MS9vcGVuL3Byb2ZpdC9hc3NldHMvaG9tZS9kZXBvc2l0LXdpdGhkcmF3XCI7XG5cbmV4cG9ydCBmdW5jdGlvbiBnZW5SZXF1ZXN0UGFyYW1zKHBhdGgsIHBhcmFtcyA9IFwiXCIsIG1ldGhvZCA9IDAsIGhvc3RUeXBlID0gMCwgaGVhZGVyID0gXCJcIikge1xuICAgIGNvbnN0IHBhcmFtID0ge1xuICAgICAgICBwYXRoLFxuICAgICAgICBtZXRob2QsXG4gICAgICAgIGhvc3RUeXBlLFxuICAgICAgICBoZWFkZXIsXG4gICAgICAgIHBhcmFtc1xuICAgIH07XG4gICAgcmV0dXJuIEpTT04uc3RyaW5naWZ5KHBhcmFtKTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGdldEVycm9ySW5mbyhjb2RlLCBzdWNjZWVkLCBtc2dMaXN0KSB7XG4gICAgY29uc3QgcGFyYW1zID0ge1xuICAgICAgICBjb2RlLFxuICAgICAgICBzdWNjZWVkLFxuICAgICAgICBtc2dMaXN0XG4gICAgfTtcbiAgICByZXR1cm4gSlNPTi5zdHJpbmdpZnkocGFyYW1zKTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIHByb2ZpdFByZWZpeChwcm9maXQpIHtcbiAgICBpZiAocHJvZml0ID09PSAnLS0nIHx8IHByb2ZpdCA9PT0gbnVsbCkge1xuICAgICAgICByZXR1cm4gJyc7XG4gICAgfSBlbHNlIGlmIChwcm9maXQgPj0gMCkge1xuICAgICAgICByZXR1cm4gJysnO1xuICAgIH1cbiAgICByZXR1cm4gJyc7XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBsZWdhbFN0cmluZyhzdHIsIGRlZmF1bHRTdHIgPSBcIlwiKSB7XG4gICAgaWYgKHN0cikgcmV0dXJuIHN0cjtcbiAgICByZXR1cm4gZGVmYXVsdFN0cjtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGdldFJlc3BvbnNlUGFyYW1zKGNvZGUsIHN1Y2NlZWQpIHtcbiAgICBjb25zdCBwYXJhbXMgPSB7XG4gICAgICAgIGNvZGUsXG4gICAgICAgIHN1Y2NlZWRcbiAgICB9O1xuICAgIHJldHVybiBKU09OLnN0cmluZ2lmeShwYXJhbXMpO1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZ2V0QmFsYW5jZUFzc2V0KCkge1xuICAgIGNvbnN0IHBhcmFtcyA9IGdlblJlcXVlc3RQYXJhbXMoYmFsYW5jZUFzc2V0UGF0aCwgeyB2ZXJzaW9uOiBcIm5ld1wiLCB1bmlvblR5cGU6IDEgfSk7XG4gICAgdHJ5IHtcbiAgICAgICAgY29uc3QgcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QocGFyYW1zKTtcbiAgICAgICAgY29uc3QgcmVzcG9uc2UgPSBKU09OLnBhcnNlKHJlc3BvbnNlU3RyaW5nKTtcbiAgICAgICAgY29uc3QgeyBjb2RlLCBkYXRhIH0gPSByZXNwb25zZTtcbiAgICAgICAgbGV0IGVycm9ySW5mbyA9IGdldEVycm9ySW5mbyhkYXRhLmNvZGUsIGZhbHNlLCBkYXRhLm1lc3NhZ2VMaXN0KTtcbiAgICAgICAgJGRhdGEudG90YWxUaXBzRXJyb3IgPSBlcnJvckluZm87XG4gICAgICAgIGNvbnNvbGUubG9nKGB3cCBnZXRCYWxhbmNlQXNzZXQsIHRvZGF5UHJvZml0U3RhdGU9JHtkYXRhLnRvZGF5UHJvZml0U3RhdGV9YCk7XG4gICAgICAgIHRvZGF5UHJvZml0U3RhdGUgPSBkYXRhLnRvZGF5UHJvZml0U3RhdGU7XG4gICAgICAgICRkYXRhLmlzTWFpbnRhaW4gPSBkYXRhLnRvZGF5UHJvZml0U3RhdGUgPT09IDEgPyAnZ29uZScgOiAndmlzaWJsZSc7XG4gICAgICAgIGlmIChjb2RlICE9PSAyMDApIHtcbiAgICAgICAgICAgIGNvbnNvbGUuZXJyb3IoVEFHLCBgZ2V0QmFsYW5jZUFzc2V0LCBjb2RlPSR7Y29kZX1gKTtcbiAgICAgICAgICAgICRkYXRhLnRvdGFsRXJyb3IgPSBjb2RlO1xuICAgICAgICB9XG4gICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgY2FjaGVEYXRhLmJhbGFuY2UgPSBkYXRhO1xuICAgICAgICAgICAgdXBkYXRlVG90YWxBc3NldERhdGEoZGF0YSk7XG4gICAgICAgICAgICB1cGRhdGVBY2NvdW50TGlzdChkYXRhKTtcbiAgICAgICAgICAgICRkYXRhLm9wZW5UZXh0VmlzaWJsZSA9IGRhdGEuZWFyblN0YXR1cyA9PT0gbnVsbCA/ICdnb25lJyA6ICd2aXNpYmxlJztcbiAgICAgICAgICAgIC8vIOeOsOi0p+acuuWZqOS6uuepuumhtemdouKAnOWOu+WIm+W7uuKAnWhvbGlnZXTlnLDlnYBcbiAgICAgICAgICAgIGlmIChkYXRhLnNwb3RSb2JvdEp1bXBVcmwpIHtcbiAgICAgICAgICAgICAgICAkZGF0YS5zcG90Um9ib3RKdW1wVXJsID0gZGF0YS5zcG90Um9ib3RKdW1wVXJsO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgaWYgKGRhdGEuZWFyblN0YXR1cyA9PT0gMCkge1xuICAgICAgICAgICAgICAgICRkYXRhLm9wZW5UZXh0ID0gJGkxOG4ubl9hc3NldF9jYXNoX3RvX3l5Yl9ub3c7XG4gICAgICAgICAgICAgICAgJGRhdGEub3BlblRleHRDb2xvciA9IFwiQGNvbG9yL2tDb2xvck1ham9yVGhlbWUxMDBcIjtcbiAgICAgICAgICAgIH0gZWxzZSBpZiAoZGF0YS5lYXJuU3RhdHVzID09PSAxKSB7XG4gICAgICAgICAgICAgICAgJGRhdGEub3BlblRleHQgPSAkaTE4bi5uX2Fzc2V0X2Nhc2hfdG9feXliX3BhcnQ7XG4gICAgICAgICAgICAgICAgJGRhdGEub3BlblRleHRDb2xvciA9IFwiQGNvbG9yL2tDb2xvclNlY29uZGFyeVRleHRcIjtcbiAgICAgICAgICAgIH0gZWxzZSBpZiAoZGF0YS5lYXJuU3RhdHVzID09PSAyKSB7XG4gICAgICAgICAgICAgICAgJGRhdGEub3BlblRleHQgPSAkaTE4bi5uX2Fzc2V0X2Nhc2hfdG9feXliX2FsbDtcbiAgICAgICAgICAgICAgICAkZGF0YS5vcGVuVGV4dENvbG9yID0gXCJAY29sb3Iva0NvbG9yU2Vjb25kYXJ5VGV4dFwiO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgLy8g6Ieq5Yqo6LWa5biB5LiK5paw5byV5a+8XG4gICAgICAgICAgICBhdXRvRWFybkd1aWRlU2hvdyA9IChkYXRhLmVhcm5BdXRvQ29uZmlnVGlwID09IDEgJiYgZGF0YS5lYXJuU3RhdHVzID09IDEpO1xuICAgICAgICAgICAgLy8g5ZCI57qm6Ieq5Yqo6LWa5biB5qCH6K6wXG4gICAgICAgICAgICAkZGF0YS5jb250cmFjdEF1dG9FYXJuVmlzID0gKGRhdGEuY29udHJhY3RFYXJuU3RhdHVzID09IG51bGwgfHwgZGF0YS5jb250cmFjdEVhcm5TdGF0dXMgPT0gdW5kZWZpbmVkKSA/ICdnb25lJyA6ICd2aXNpYmxlJztcbiAgICAgICAgICAgIGlmIChkYXRhLmNvbnRyYWN0RWFyblN0YXR1cyA9PSAwKSB7XG4gICAgICAgICAgICAgICAgJGRhdGEuY29udHJhY3RBdXRvRWFyblRleHQgPSAkaTE4bi5uX2Fzc2V0X2Nhc2hfdG9feXliX25vdztcbiAgICAgICAgICAgICAgICAkZGF0YS5jb250cmFjdEF1dG9FYXJuQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JNYWpvclRoZW1lMTAwXCI7XG4gICAgICAgICAgICB9IGVsc2UgaWYgKGRhdGEuY29udHJhY3RFYXJuU3RhdHVzID09IDEpIHtcbiAgICAgICAgICAgICAgICAkZGF0YS5jb250cmFjdEF1dG9FYXJuVGV4dCA9ICRpMThuLm5fc2hhcmtfZmluX2F1dG9TdWJzY3JpYmVfb3BlbjtcbiAgICAgICAgICAgICAgICAkZGF0YS5jb250cmFjdEF1dG9FYXJuQ29sb3IgPSBcIkBjb2xvci9rQ29sb3JTZWNvbmRhcnlUZXh0XCI7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICAvLyDmmoLml7blhpnmiJDkvb/nlKggNC41JSDmm7/mjaIgNiXvvIzlkI7pnaLmjqXlj6PkuIrnur/lkI7lho3kv67mlLlcbiAgICAgICAgICAgIGlmIChkYXRhLmNvbnRyYWN0RWFyblJhdGUpIHtcbiAgICAgICAgICAgICAgICAkZGF0YS5jb250cmFjdEF1dG9FYXJuID0gJGkxOG4ubl9hc3NldF9jb250cmFjdF9hdXRvX2Vhcm4ucmVwbGFjZShcIjZcIiwgYCR7ZGF0YS5jb250cmFjdEVhcm5SYXRlfWApO1xuICAgICAgICAgICAgfWVsc2V7XG4gICAgICAgICAgICAgICAgJGRhdGEuY29udHJhY3RBdXRvRWFyblZpcyA9ICdnb25lJ1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgZGF0YS5zdWJBY2NvdW50QmFsYW5jZUxpc3QubWFwKChpdGVtKSA9PiB7XG4gICAgICAgICAgICAgICAgc3dpdGNoIChpdGVtLmRpc3RyaWJ1dGlvblR5cGUpIHtcbiAgICAgICAgICAgICAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLnNwb3Q6XG4gICAgICAgICAgICAgICAgICAgICAgICBjYWNoZURhdGEuc3BvdC5zcG90LmJhc2VJbmZvID0gaXRlbTtcbiAgICAgICAgICAgICAgICAgICAgICAgIHVwZGF0ZVNwb3RCYXNlSW5mb0RhdGEoaXRlbSk7XG4gICAgICAgICAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgICAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmJvdDpcbiAgICAgICAgICAgICAgICAgICAgICAgIGNhY2hlRGF0YS5zcG90LmJvdC5iYXNlSW5mbyA9IGl0ZW07XG4gICAgICAgICAgICAgICAgICAgICAgICB1cGRhdGVCb3RCYXNlSW5mb0RhdGEoaXRlbSk7XG4gICAgICAgICAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgICAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmNvbGxhdGVyYWw6XG4gICAgICAgICAgICAgICAgICAgICAgICBjYWNoZURhdGEuc3BvdC5jb2xsYXRlcmFsLmJhc2VJbmZvID0gaXRlbTtcbiAgICAgICAgICAgICAgICAgICAgICAgIHVwZGF0ZVNwb3RDb2xsYXRlcmFsQmFzZUluZm9EYXRhKGl0ZW0pO1xuICAgICAgICAgICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICAgICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS51c2R0TTpcbiAgICAgICAgICAgICAgICAgICAgICAgIGNhY2hlRGF0YS5jb250cmFjdC51c2R0X20uYmFzZUluZm8gPSBpdGVtO1xuICAgICAgICAgICAgICAgICAgICAgICAgdXBkYXRlTGluZWFyU3dhcEJhc2VJbmZvRGF0YShpdGVtKTtcbiAgICAgICAgICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuY29pblA6XG4gICAgICAgICAgICAgICAgICAgICAgICBjYWNoZURhdGEuY29udHJhY3QuY29pbl9wLmJhc2VJbmZvID0gaXRlbTtcbiAgICAgICAgICAgICAgICAgICAgICAgIHVwZGF0ZUNvaW5QQmFzZUluZm9EYXRhKGl0ZW0pO1xuICAgICAgICAgICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICAgICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS5jb2luRnV0dXJlczpcbiAgICAgICAgICAgICAgICAgICAgICAgIGNhY2hlRGF0YS5jb250cmFjdC5jb2luX2YuYmFzZUluZm8gPSBpdGVtO1xuICAgICAgICAgICAgICAgICAgICAgICAgdXBkYXRlQ29pbk1CYXNlSW5mb0RhdGEoaXRlbSk7XG4gICAgICAgICAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgICAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmNvbnRyYWN0Q29weTpcbiAgICAgICAgICAgICAgICAgICAgICAgIGNhY2hlRGF0YS5jb250cmFjdC5jb3B5X3RyYWRpbmcuYmFzZUluZm8gPSBpdGVtO1xuICAgICAgICAgICAgICAgICAgICAgICAgdXBkYXRlQ29weVRyYWRpbmdCYXNlSW5mbyhpdGVtKTtcbiAgICAgICAgICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUub3RjOlxuICAgICAgICAgICAgICAgICAgICAgICAgY2FjaGVEYXRhLm90Yy5iYXNlSW5mbyA9IGl0ZW07XG4gICAgICAgICAgICAgICAgICAgICAgICB1cGRhdGVPdGNCYXNlSW5mbyhpdGVtKTtcbiAgICAgICAgICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuYWxsUmVwbzpcbiAgICAgICAgICAgICAgICAgICAgICAgIC8v5YWo5LuTXG4gICAgICAgICAgICAgICAgICAgICAgICBjYWNoZURhdGEubWFyZ2luLmFsbFJlcG8uYmFzZUluZm8gPSBpdGVtO1xuICAgICAgICAgICAgICAgICAgICAgICAgdXBkYXRlTWFyZ2luQWxsSW5mbyhpdGVtKTtcbiAgICAgICAgICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUucGFydFJlcG86XG4gICAgICAgICAgICAgICAgICAgICAgICAvL+mAkOS7k1xuICAgICAgICAgICAgICAgICAgICAgICAgY2FjaGVEYXRhLm1hcmdpbi5wYXJ0UmVwby5iYXNlSW5mbyA9IGl0ZW07XG4gICAgICAgICAgICAgICAgICAgICAgICB1cGRhdGVNYXJnaW5QYXJ0QmFzZUluZm8oaXRlbSk7XG4gICAgICAgICAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgICAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmVhcm46XG4gICAgICAgICAgICAgICAgICAgICAgICBjYWNoZURhdGEuZWFybi5lYXJuWWJiLmJhc2VJbmZvID0gaXRlbTtcbiAgICAgICAgICAgICAgICAgICAgICAgIHVwZGF0ZUVhcm5ZYmJCYXNlSW5mbyhpdGVtKTtcbiAgICAgICAgICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuZWFybkZpeGVkOlxuICAgICAgICAgICAgICAgICAgICAgICAgY2FjaGVEYXRhLmVhcm4uZWFybkZpeGVkLmJhc2VJbmZvID0gaXRlbTtcbiAgICAgICAgICAgICAgICAgICAgICAgIHVwZGF0ZUVhcm5GaXhlZEJhc2VJbmZvKGl0ZW0pO1xuICAgICAgICAgICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICAgICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS5lYXJuSGlnaDpcbiAgICAgICAgICAgICAgICAgICAgICAgIGNhY2hlRGF0YS5lYXJuLmVhcm5IaWdoLmJhc2VJbmZvID0gaXRlbTtcbiAgICAgICAgICAgICAgICAgICAgICAgIHVwZGF0ZUVhcm5IaWdoQmFzZUluZm8oaXRlbSk7XG4gICAgICAgICAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgICAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmVhcm5Ob2RlUGxlZGdlOlxuICAgICAgICAgICAgICAgICAgICAgICAgY2FjaGVEYXRhLmVhcm4uZWFybk5vZGVQbGVkZ2UuYmFzZUluZm8gPSBpdGVtO1xuICAgICAgICAgICAgICAgICAgICAgICAgdXBkYXRlRWFybk5vZGVQbGVkZ2VCYXNlSW5mbyhpdGVtKTtcbiAgICAgICAgICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuZWFyblNoYXJrRmluOlxuICAgICAgICAgICAgICAgICAgICAgICAgY2FjaGVEYXRhLmVhcm4uZWFyblNoYXJrRmluLmJhc2VJbmZvID0gaXRlbTtcbiAgICAgICAgICAgICAgICAgICAgICAgIHVwZGF0ZUVhcm5TaGFya0ZpbkJhc2VJbmZvKGl0ZW0pO1xuICAgICAgICAgICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICAgICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS5vcHRpb246XG4gICAgICAgICAgICAgICAgICAgICAgICBjYWNoZURhdGEub3B0aW9uLmJhc2VJbmZvID0gaXRlbTtcbiAgICAgICAgICAgICAgICAgICAgICAgIHVwZGF0ZU9wdGlvbkJhc2VJbmZvKGl0ZW0pO1xuICAgICAgICAgICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICAgICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS5jb250cmFjdEdyaWQ6XG4gICAgICAgICAgICAgICAgICAgICAgICAvLyDlkIjnuqbnvZHmoLxcbiAgICAgICAgICAgICAgICAgICAgICAgIGNhY2hlRGF0YS5jb250cmFjdEdyaWQuYmFzZUluZm8gPSBpdGVtO1xuICAgICAgICAgICAgICAgICAgICAgICAgdXBkYXRlQ29udHJhY3RHcmlkQmFzZUluZm8oaXRlbSk7XG4gICAgICAgICAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICB9KTtcbiAgICAgICAgfVxuICAgIH1cbiAgICBjYXRjaCAoZSkge1xuICAgICAgICBjb25zb2xlLmVycm9yKFRBRywgYGdldEJhbGFuY2VBc3NldDoke2V9YCk7XG4gICAgICAgICRkYXRhLnRvdGFsRXJyb3IgPSBgJHtlfWA7XG4gICAgfVxufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZ2V0Um9ja2V0QW1vdW50KCkge1xuICAgIGNvbnN0IHBhcmFtcyA9IGdlblJlcXVlc3RQYXJhbXMoYmFsYW5jZVJvY2tldFBhdGgpO1xuICAgIHRyeSB7XG4gICAgICAgIGNvbnN0IHJlc3BvbnNlU3RyaW5nID0gYXdhaXQgJG5hdGl2ZUFQSS5yZXF1ZXN0KHBhcmFtcyk7XG4gICAgICAgIGNvbnN0IHJlc3BvbnNlID0gSlNPTi5wYXJzZShyZXNwb25zZVN0cmluZyk7XG4gICAgICAgIGNvbnNvbGUubG9nKGB3cCBnZXRSb2NrZXRBbW91bnQgcmVzcG9uc2VTdHJpbmcgJHtyZXNwb25zZVN0cmluZ31gKTtcbiAgICAgICAgY29uc3QgeyBjb2RlLCBtZXNzYWdlIH0gPSByZXNwb25zZTtcbiAgICAgICAgaWYgKGNvZGUgIT09IDIwMCkge1xuICAgICAgICAgICAgJGRhdGEucm9ja2V0QW1vdW50ID0gJy0tJztcbiAgICAgICAgICAgICRuYXRpdmVBUEkuaGJUb2FzdChtZXNzYWdlKTtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGB3cCBnZXRSb2NrZXRBbW91bnQgc3VjY2Vzc2ApO1xuICAgICAgICAgICAgbGV0IHJvY2tldEluZm9MaXN0ID0gcmVzcG9uc2UuZGF0YS5yb2NrZXRJbmZvTGlzdDtcbiAgICAgICAgICAgIGlmIChyb2NrZXRJbmZvTGlzdC5sZW5ndGggPiAwKSB7XG4gICAgICAgICAgICAgICAgJGRhdGEucm9ja2V0QW1vdW50ID0gaXNIaWRkZW4gPyBISURERU5fU1RSIDogcm9ja2V0SW5mb0xpc3RbMF0ucm9ja2V0QW1vdW50LnRvU3RyaW5nKCk7XG4gICAgICAgICAgICAgICAgY2FjaGVEYXRhLnJvY2tldEFtb3VudCA9IHJvY2tldEluZm9MaXN0WzBdLnJvY2tldEFtb3VudC50b1N0cmluZygpO1xuICAgICAgICAgICAgICAgIGNvbnNvbGUubG9nKGB3cCBnZXRSb2NrZXRBbW91bnQgc3VjY2VzcyByb2NrZXRBbW91bnQgJHskZGF0YS5yb2NrZXRBbW91bnR9YCk7XG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgICRkYXRhLnJvY2tldEFtb3VudCA9IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IFwiMFwiO1xuICAgICAgICAgICAgICAgIGNhY2hlRGF0YS5yb2NrZXRBbW91bnQgPSBcIjBcIjtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgJGRhdGEucm9ja2V0QW1vdW50ID0gSElEREVOX1NUUjtcbiAgICAgICAgY29uc29sZS5lcnJvcihgd3AgZ2V0Um9ja2V0QW1vdW50ICR7ZX1gKTtcbiAgICB9XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiByb2NrZXRJbmZvVGFwQWN0aW9uKCkge1xuICAgIGxldCB1cmwgPSBgJHtjb21tb25EYXRhLndlYlVybH0vJHtjb21tb25EYXRhLmxhbmd1YWdlfS9hc3NldHMvcm9ja2V0L2A7XG4gICAgJG5hdGl2ZUFQSS5vcGVuUm91dGUodXJsKTtcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHVwZGF0ZUVhcm5ZYmJCYXNlSW5mbyhkYXRhKSB7XG4gICAgJGRhdGEuZWFyblliYlJpc2tJY29uU2hvdyA9ICdnb25lJztcbiAgICBpZiAoY3VycmVuY3lVcGRhdGVEYXRhLnVwZ3JhZGVTdGF0ZSA9PT0gdHJ1ZSkge1xuICAgICAgICAkZGF0YS5lYXJuWWJiSGVhZGVyQm90dG9tVGV4dCA9IGF3YWl0IGdldFdvcmQoJ2Fzc2V0X3NtYWxsX2NvaW5fdG9faHR4Jyk7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgJGRhdGEuZWFyblliYkhlYWRlckJvdHRvbVRleHQgPSBhd2FpdCBnZXRXb3JkKCdhc3NldF9zbWFsbF9jb2luX3RvX2h0Jyk7XG4gICAgfVxuICAgIGlmIChpc0hpZGRlbikge1xuICAgICAgICAkZGF0YS5lYXJuWWJiVG90YWxBc3NldCA9IEhJRERFTl9TVFI7XG4gICAgICAgICRkYXRhLmVhcm5ZYmJUb2RheVBsTnVtYmVyID0gSElEREVOX1NUUjtcbiAgICAgICAgJGRhdGEuZWFyblliYlRvZGF5UGxOdW1iZXJDb2xvciA9IGF3YWl0IGdldENvbG9yKCdrQ29sb3JTZWNvbmRhcnlUZXh0Jyk7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgY29uc3QgY3VycmVuY3kgPSBnZXRDdXJyZW5jeSgpO1xuICAgIGNvbnN0IGxlZ2FsQ3VycmVuY3lTeW1ib2wgPSBhd2FpdCBnZXRMZWdhbEN1cnJlbmN5U3ltYm9sKCk7XG4gICAgY29uc3QgZXF1YWxBbW91bnQgPSBhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRIYW5kbGVOdWxsKFN5bWJvbHMudXNkdCwgZGF0YS5iYWxhbmNlKTtcbiAgICAkZGF0YS5lYXJuWWJiVG90YWxBc3NldCA9IGFkZEN1cnJlbmN5U3ltYm9sVG90YWxBc3NldChsZWdhbEN1cnJlbmN5U3ltYm9sLCBhd2FpdCBmb3JtYXROdW0oZXF1YWxBbW91bnQpKTtcblxuICAgIGNvbnN0IHRvZGF5UHJvZml0ID0gYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50SGFuZGxlTnVsbChTeW1ib2xzLnVzZHQsIGRhdGEucHJvZml0SW5jb21lKTtcbiAgICBjb25zdCB0b2RheVByb2ZpdFdpdGhTeW1ib2wgPSBhZGRDdXJyZW5jeVN5bWJvbChsZWdhbEN1cnJlbmN5U3ltYm9sLCB0b2RheVByb2ZpdCk7XG4gICAgJGRhdGEuZWFyblliYlRvZGF5UGxOdW1iZXIgPSB0b2RheVByb2ZpdFdpdGhTeW1ib2w7XG4gICAgJGRhdGEuZWFyblliYlRvZGF5UGxOdW1iZXJDb2xvciA9IGF3YWl0IHJpc2VDb2xvcih0b2RheVByb2ZpdCk7XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBhc3NldE5ld0Vhcm5HdWlkZSgpIHtcbiAgICAvLyB2YXIgZ3VpZGVTaG93ID0gYXdhaXQgJG5hdGl2ZUFQSS5zdG9yYWdlKHtcbiAgICAvLyAgICAgYWN0aW9uOiBcInJlYWRcIixcbiAgICAvLyAgICAgbmFtZTogXCJnbG9iYWxfYXNzZXRfZ3VpZGVcIixcbiAgICAvLyAgICAga2V5OiBcImd1aWRlX2Fzc2V0X25ld2Vhcm5fc2hvd1wiXG4gICAgLy8gfSlcbiAgICAvLyBpZiAoZ3VpZGVTaG93ID09IG51bGwgfHwgZ3VpZGVTaG93ID09IFwiXCIpIHtcbiAgICAvLyAgICAgc2V0VGltZW91dCgoKSA9PiB7XG4gICAgLy8gICAgICAgICAkZGF0YS5uZXdFYXJuUG9wU2hvdyA9IFwidHJ1ZVwiO1xuICAgIC8vICAgICB9LCA1MDApO1xuICAgIC8vICAgICAkbmF0aXZlQVBJLnN0b3JhZ2Uoe1xuICAgIC8vICAgICAgICAgYWN0aW9uOiBcInNhdmVcIixcbiAgICAvLyAgICAgICAgIG5hbWU6IFwiZ2xvYmFsX2Fzc2V0X2d1aWRlXCIsXG4gICAgLy8gICAgICAgICBrZXk6IFwiZ3VpZGVfYXNzZXRfbmV3ZWFybl9zaG93XCIsXG4gICAgLy8gICAgICAgICBkYXRhOiBcIjFcIlxuICAgIC8vICAgICB9KVxuICAgIC8vIH1cbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGFzc2V0TmV3RWFybkd1aWRlSGlkZSgpIHtcbiAgICAvLyAkZGF0YS5uZXdFYXJuUG9wU2hvdyA9IFwiZmFsc2VcIjtcbn1cblxuLy8g6Ieq5Yqo6LWa5biB5LiK5paw5byV5a+8XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gYXNzZXRTcG90QXV0b0Vhcm5PcGVuR3VpZGUoKSB7XG4gICAgY29uc29sZS5sb2coYGFzc2V0U3BvdEF1dG9FYXJuT3Blbkd1aWRlICAgMWApO1xuICAgIGlmICghYXV0b0Vhcm5HdWlkZVNob3cpIHtcbiAgICAgICAgY29uc29sZS5sb2coYGFzc2V0U3BvdEF1dG9FYXJuT3Blbkd1aWRlICAke2F1dG9FYXJuR3VpZGVTaG93fWApO1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgICRkYXRhLnNwb3RPcGVuR3VpZGVTaG93ID0gXCJmYWxzZVwiO1xuICAgICRkYXRhLnNwb3RPcGVuR3VpZGV2aXNpYmlsaXR5ID0gXCJnb25lXCI7XG4gICAgYXV0b0Vhcm5HdWlkZVNob3cgPSBmYWxzZTtcblxuICAgIHZhciBndWlkZVNob3dEYXRlID0gYXdhaXQgJG5hdGl2ZUFQSS5zdG9yYWdlKHtcbiAgICAgICAgYWN0aW9uOiBcInJlYWRcIixcbiAgICAgICAgbmFtZTogXCJnbG9iYWxfYXNzZXRfZ3VpZGVcIixcbiAgICAgICAga2V5OiBcImd1aWRlX2Fzc2V0X3Nwb3RfYXV0b2Vhcm5fc2hvd1wiXG4gICAgfSlcbiAgICBjb25zdCBub3dEYXRlID0gRGF0ZS5ub3coKTtcbiAgICBjb25zb2xlLmxvZyhgZ3VpZGVTaG93RGF0ZT0ke2d1aWRlU2hvd0RhdGV9PT1ub3dEYXRlPSR7bm93RGF0ZX1gKTtcbiAgICBpZiAoZ3VpZGVTaG93RGF0ZSA9PSBudWxsIHx8IGd1aWRlU2hvd0RhdGUgPT0gXCJcIiB8fCBub3dEYXRlIC0gZ3VpZGVTaG93RGF0ZSA+IDI0ICogNjAgKiA2MCAqIDEwMDApIHtcbiAgICAgICAgY29uc29sZS5sb2coYHNob3dBc3NldFNwb3RPcGVuR3VpZGVgKTtcbiAgICAgICAgJGRhdGEuc3BvdE9wZW5HdWlkZXZpc2liaWxpdHkgPSBcInZpc2libGVcIjtcbiAgICAgICAgc2V0VGltZW91dCgoKSA9PiB7XG4gICAgICAgICAgICAkZGF0YS5zcG90T3Blbkd1aWRlU2hvdyA9IFwidHJ1ZVwiO1xuICAgICAgICB9LCA1MDApO1xuICAgICAgICAkbmF0aXZlQVBJLnN0b3JhZ2Uoe1xuICAgICAgICAgICAgYWN0aW9uOiBcInNhdmVcIixcbiAgICAgICAgICAgIG5hbWU6IFwiZ2xvYmFsX2Fzc2V0X2d1aWRlXCIsXG4gICAgICAgICAgICBrZXk6IFwiZ3VpZGVfYXNzZXRfc3BvdF9hdXRvZWFybl9zaG93XCIsXG4gICAgICAgICAgICBkYXRhOiBgJHtEYXRlLm5vdygpfWBcbiAgICAgICAgfSlcbiAgICB9XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBhc3NldFNwb3RPcGVuR3VpZGVIaWRlKCkge1xuICAgICRkYXRhLnNwb3RPcGVuR3VpZGVTaG93ID0gXCJmYWxzZVwiO1xuICAgICRkYXRhLnNwb3RPcGVuR3VpZGV2aXNpYmlsaXR5ID0gXCJnb25lXCI7XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRIYW5kbGVOdWxsKHN5bWJvbCwgYW1vdW50KSB7XG4gICAgaWYgKGFtb3VudCA9PT0gbnVsbCkge1xuICAgICAgICByZXR1cm4gJy0tJztcbiAgICB9IGVsc2UgaWYgKCFhbW91bnQpIHtcbiAgICAgICAgYW1vdW50ID0gJzAnO1xuICAgIH1cbiAgICBjb25zdCBwYXJhbSA9IHtcbiAgICAgICAgdHlwZTogMSxcbiAgICAgICAgY3VycmVuY3k6IHN5bWJvbCxcbiAgICAgICAgYW1vdW50LFxuICAgIH07XG4gICAgY29uc3QgcGFyYW1TdHJpbmcgPSBKU09OLnN0cmluZ2lmeShwYXJhbSk7XG4gICAgcmV0dXJuIGF3YWl0ICRuYXRpdmVBUEkuY3VycmVuY3lDb21tb24ocGFyYW1TdHJpbmcpO1xufVxuZXhwb3J0IGZ1bmN0aW9uIGZpeFJhdGVIYW5kbGVOdWxsKHJhdGUpIHtcbiAgICBpZiAocmF0ZSA9PT0gbnVsbCkge1xuICAgICAgICByZXR1cm4gXCItLVwiO1xuICAgIH0gZWxzZSBpZiAoIXJhdGUpIHtcbiAgICAgICAgcmV0dXJuIFwiMC4wMCVcIjtcbiAgICB9XG4gICAgdHJ5IHtcbiAgICAgICAgcmV0dXJuIGAke2ZpeE51bWJlcihOdW1iZXIucGFyc2VGbG9hdChyYXRlKSAqIDEwMCwgMil9JWA7XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICByZXR1cm4gXCIwLjAwJVwiO1xuICAgIH1cbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGZpeFJhdGUocmF0ZSkge1xuICAgIGlmICghcmF0ZSkge1xuICAgICAgICByZXR1cm4gXCIwLjAwJVwiO1xuICAgIH1cbiAgICB0cnkge1xuICAgICAgICByZXR1cm4gYCR7Zml4TnVtYmVyKE51bWJlci5wYXJzZUZsb2F0KHJhdGUpICogMTAwLCAyKX0lYDtcbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIHJldHVybiBcIjAuMDAlXCI7XG4gICAgfVxufVxuXG5leHBvcnQgZnVuY3Rpb24gZml4UmF0ZUZpeGVkKHJhdGUsIGZpeGVkKSB7XG4gICAgaWYgKCFyYXRlKSB7XG4gICAgICAgIHJldHVybiBcIjAuMDAlXCI7XG4gICAgfVxuICAgIHRyeSB7XG4gICAgICAgIHJldHVybiBgJHtmaXhOdW1iZXIoTnVtYmVyLnBhcnNlRmxvYXQocmF0ZSkgKiAxMDAsIGZpeGVkKX0lYDtcbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIHJldHVybiBcIjAuMDAlXCI7XG4gICAgfVxufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gdXBkYXRlRWFybkZpeGVkQmFzZUluZm8oZGF0YSkge1xuICAgIGNvbnNvbGUubG9nKGB1cGRhdGVFYXJuRml4ZWRCYXNlSW5mbyAke2lzSGlkZGVufWApO1xuICAgIGlmIChjdXJyZW5jeVVwZGF0ZURhdGEudXBncmFkZVN0YXRlID09PSB0cnVlKSB7XG4gICAgICAgICRkYXRhLmVhcm5IZWFkZXJCb3R0b21UZXh0ID0gYXdhaXQgZ2V0V29yZCgnYXNzZXRfc21hbGxfY29pbl90b19odHgnKTtcbiAgICB9IGVsc2Uge1xuICAgICAgICAkZGF0YS5lYXJuSGVhZGVyQm90dG9tVGV4dCA9IGF3YWl0IGdldFdvcmQoJ2Fzc2V0X3NtYWxsX2NvaW5fdG9faHQnKTtcbiAgICB9XG4gICAgJGRhdGEuZWFyblJpc2tJY29uU2hvdyA9ICdnb25lJztcbiAgICBpZiAoaXNIaWRkZW4pIHtcbiAgICAgICAgY29uc29sZS5sb2coYHVwZGF0ZUVhcm5GaXhlZEJhc2VJbmZvIGludG8gJHtpc0hpZGRlbn1gKTtcbiAgICAgICAgJGRhdGEuZWFyblRvdGFsQXNzZXQgPSBISURERU5fU1RSO1xuICAgICAgICAkZGF0YS5lYXJuVG9kYXlQbE51bWJlciA9IEhJRERFTl9TVFI7XG4gICAgICAgICRkYXRhLmVhcm5Ub2RheVBsTnVtYmVyQ29sb3IgPSBhd2FpdCBnZXRDb2xvcigna0NvbG9yU2Vjb25kYXJ5VGV4dCcpO1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIGNvbnN0IGN1cnJlbmN5ID0gZ2V0Q3VycmVuY3koKTtcbiAgICBjb25zdCBsZWdhbEN1cnJlbmN5U3ltYm9sID0gYXdhaXQgZ2V0TGVnYWxDdXJyZW5jeVN5bWJvbCgpO1xuICAgIGNvbnN0IGVxdWFsQW1vdW50ID0gYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50SGFuZGxlTnVsbChTeW1ib2xzLnVzZHQsIGRhdGEuYmFsYW5jZSk7XG4gICAgY29uc29sZS5sb2coYHVwZGF0ZUVhcm5GaXhlZEJhc2VJbmZvIGVxdWFsQW1vdW50JHtlcXVhbEFtb3VudH1gKTtcbiAgICAkZGF0YS5lYXJuVG90YWxBc3NldCA9IGFkZEN1cnJlbmN5U3ltYm9sVG90YWxBc3NldChsZWdhbEN1cnJlbmN5U3ltYm9sLCBhd2FpdCBmb3JtYXROdW0oZXF1YWxBbW91bnQpKTtcblxuICAgIGNvbnN0IHRvZGF5UHJvZml0ID0gYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50SGFuZGxlTnVsbChTeW1ib2xzLnVzZHQsIGRhdGEucHJvZml0SW5jb21lKTtcbiAgICBjb25zdCB0b2RheVByb2ZpdFdpdGhTeW1ib2wgPSBhZGRDdXJyZW5jeVN5bWJvbChsZWdhbEN1cnJlbmN5U3ltYm9sLCB0b2RheVByb2ZpdCk7XG4gICAgJGRhdGEuZWFyblRvZGF5UGxOdW1iZXIgPSB0b2RheVByb2ZpdFdpdGhTeW1ib2w7XG4gICAgJGRhdGEuZWFyblRvZGF5UGxOdW1iZXJDb2xvciA9IGF3YWl0IHJpc2VDb2xvcih0b2RheVByb2ZpdCk7XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiB1cGRhdGVFYXJuSGlnaEJhc2VJbmZvKGRhdGEpIHtcbiAgICBjb25zb2xlLmxvZyhgZWFybkJhc2VJbmZvICR7SlNPTi5zdHJpbmdpZnkoZGF0YSl9YCk7XG4gICAgaWYgKGN1cnJlbmN5VXBkYXRlRGF0YS51cGdyYWRlU3RhdGUgPT09IHRydWUpIHtcbiAgICAgICAgJGRhdGEuZWFybkhlYWRlckJvdHRvbVRleHQgPSBhd2FpdCBnZXRXb3JkKCdhc3NldF9zbWFsbF9jb2luX3RvX2h0eCcpO1xuICAgIH0gZWxzZSB7XG4gICAgICAgICRkYXRhLmVhcm5IZWFkZXJCb3R0b21UZXh0ID0gYXdhaXQgZ2V0V29yZCgnYXNzZXRfc21hbGxfY29pbl90b19odCcpO1xuICAgIH1cbiAgICAkZGF0YS5lYXJuUmlza0ljb25TaG93ID0gJ2dvbmUnO1xuICAgIGlmIChpc0hpZGRlbikge1xuICAgICAgICAkZGF0YS5lYXJuSGlnaFRvdGFsQXNzZXQgPSBISURERU5fU1RSO1xuICAgICAgICAkZGF0YS5lYXJuSGlnaFRvZGF5UGxOdW1iZXIgPSBISURERU5fU1RSO1xuICAgICAgICAkZGF0YS5lYXJuSGlnaFRvZGF5UGxOdW1iZXJDb2xvciA9IGF3YWl0IGdldENvbG9yKCdrQ29sb3JTZWNvbmRhcnlUZXh0Jyk7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgY29uc3QgY3VycmVuY3kgPSBnZXRDdXJyZW5jeSgpO1xuICAgIGNvbnN0IGxlZ2FsQ3VycmVuY3lTeW1ib2wgPSBhd2FpdCBnZXRMZWdhbEN1cnJlbmN5U3ltYm9sKCk7XG4gICAgY29uc3QgZXF1YWxBbW91bnQgPSBhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRIYW5kbGVOdWxsKFN5bWJvbHMudXNkdCwgZGF0YS5iYWxhbmNlKTtcbiAgICAkZGF0YS5lYXJuSGlnaFRvdGFsQXNzZXQgPSBhZGRDdXJyZW5jeVN5bWJvbFRvdGFsQXNzZXQobGVnYWxDdXJyZW5jeVN5bWJvbCwgYXdhaXQgZm9ybWF0TnVtKGVxdWFsQW1vdW50KSk7XG5cbiAgICBjb25zdCB0b2RheVByb2ZpdCA9IGF3YWl0IGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudEhhbmRsZU51bGwoU3ltYm9scy51c2R0LCBkYXRhLnByb2ZpdEluY29tZSk7XG4gICAgY29uc3QgdG9kYXlQcm9maXRXaXRoU3ltYm9sID0gYWRkQ3VycmVuY3lTeW1ib2wobGVnYWxDdXJyZW5jeVN5bWJvbCwgdG9kYXlQcm9maXQpO1xuICAgICRkYXRhLmVhcm5IaWdoVG9kYXlQbE51bWJlciA9IHRvZGF5UHJvZml0V2l0aFN5bWJvbDtcbiAgICAkZGF0YS5lYXJuSGlnaFRvZGF5UGxOdW1iZXJDb2xvciA9IGF3YWl0IHJpc2VDb2xvcih0b2RheVByb2ZpdCk7XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiB1cGRhdGVFYXJuTm9kZVBsZWRnZUJhc2VJbmZvKGRhdGEpIHtcbiAgICBjb25zb2xlLmxvZyhgZWFybkJhc2VJbmZvICR7SlNPTi5zdHJpbmdpZnkoZGF0YSl9YCk7XG4gICAgaWYgKGN1cnJlbmN5VXBkYXRlRGF0YS51cGdyYWRlU3RhdGUgPT09IHRydWUpIHtcbiAgICAgICAgJGRhdGEuZWFybkhlYWRlckJvdHRvbVRleHQgPSBhd2FpdCBnZXRXb3JkKCdhc3NldF9zbWFsbF9jb2luX3RvX2h0eCcpO1xuICAgIH0gZWxzZSB7XG4gICAgICAgICRkYXRhLmVhcm5IZWFkZXJCb3R0b21UZXh0ID0gYXdhaXQgZ2V0V29yZCgnYXNzZXRfc21hbGxfY29pbl90b19odCcpO1xuICAgIH1cbiAgICAkZGF0YS5lYXJuUmlza0ljb25TaG93ID0gJ2dvbmUnO1xuICAgIGlmIChpc0hpZGRlbikge1xuICAgICAgICBjb25zb2xlLmxvZyhgdXBkYXRlRWFybkhpZ2hCYXNlSW5mbyBpbnRvICR7aXNIaWRkZW59YCk7XG4gICAgICAgICRkYXRhLmVhcm5Ob2RlUGxlZGdlVG90YWxBc3NldCA9IEhJRERFTl9TVFI7XG4gICAgICAgICRkYXRhLmVhcm5Ob2RlUGxlZGdlVG9kYXlQbE51bWJlciA9IEhJRERFTl9TVFI7XG4gICAgICAgICRkYXRhLmVhcm5Ob2RlUGxlZGdlVG9kYXlQbE51bWJlckNvbG9yID0gYXdhaXQgZ2V0Q29sb3IoJ2tDb2xvclNlY29uZGFyeVRleHQnKTtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICBjb25zdCBjdXJyZW5jeSA9IGdldEN1cnJlbmN5KCk7XG4gICAgY29uc3QgbGVnYWxDdXJyZW5jeVN5bWJvbCA9IGF3YWl0IGdldExlZ2FsQ3VycmVuY3lTeW1ib2woKTtcbiAgICBjb25zdCBlcXVhbEFtb3VudCA9IGF3YWl0IGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudEhhbmRsZU51bGwoU3ltYm9scy51c2R0LCBkYXRhLmJhbGFuY2UpO1xuICAgICRkYXRhLmVhcm5Ob2RlUGxlZGdlVG90YWxBc3NldCA9IGFkZEN1cnJlbmN5U3ltYm9sVG90YWxBc3NldChsZWdhbEN1cnJlbmN5U3ltYm9sLCBhd2FpdCBmb3JtYXROdW0oZXF1YWxBbW91bnQpKTtcblxuICAgIGNvbnN0IHRvZGF5UHJvZml0ID0gYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50SGFuZGxlTnVsbChTeW1ib2xzLnVzZHQsIGRhdGEucHJvZml0SW5jb21lKTtcbiAgICBjb25zdCB0b2RheVByb2ZpdFdpdGhTeW1ib2wgPSBhZGRDdXJyZW5jeVN5bWJvbChsZWdhbEN1cnJlbmN5U3ltYm9sLCB0b2RheVByb2ZpdCk7XG4gICAgJGRhdGEuZWFybk5vZGVQbGVkZ2VUb2RheVBsTnVtYmVyID0gdG9kYXlQcm9maXRXaXRoU3ltYm9sO1xuICAgICRkYXRhLmVhcm5Ob2RlUGxlZGdlVG9kYXlQbE51bWJlckNvbG9yID0gYXdhaXQgcmlzZUNvbG9yKHRvZGF5UHJvZml0KTtcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHVwZGF0ZUVhcm5TaGFya0ZpbkJhc2VJbmZvKGRhdGEpIHtcbiAgICBjb25zb2xlLmxvZyhgdXBkYXRlRWFyblNoYXJrRmluQmFzZUluZm8gJHtpc0hpZGRlbn1gKTtcbiAgICBpZiAoY3VycmVuY3lVcGRhdGVEYXRhLnVwZ3JhZGVTdGF0ZSA9PT0gdHJ1ZSkge1xuICAgICAgICAkZGF0YS5lYXJuSGVhZGVyQm90dG9tVGV4dCA9IGF3YWl0IGdldFdvcmQoJ2Fzc2V0X3NtYWxsX2NvaW5fdG9faHR4Jyk7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgJGRhdGEuZWFybkhlYWRlckJvdHRvbVRleHQgPSBhd2FpdCBnZXRXb3JkKCdhc3NldF9zbWFsbF9jb2luX3RvX2h0Jyk7XG4gICAgfVxuICAgICRkYXRhLmVhcm5SaXNrSWNvblNob3cgPSAnZ29uZSc7XG4gICAgaWYgKGlzSGlkZGVuKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGB1cGRhdGVFYXJuSGlnaEJhc2VJbmZvIGludG8gJHtpc0hpZGRlbn1gKTtcbiAgICAgICAgJGRhdGEuZWFyblNoYXJrRmluVG90YWxBc3NldCA9IEhJRERFTl9TVFI7XG4gICAgICAgICRkYXRhLmVhcm5TaGFya0ZpblRvZGF5UGxOdW1iZXIgPSBISURERU5fU1RSO1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIGNvbnN0IGN1cnJlbmN5ID0gZ2V0Q3VycmVuY3koKTtcbiAgICBjb25zdCBsZWdhbEN1cnJlbmN5U3ltYm9sID0gYXdhaXQgZ2V0TGVnYWxDdXJyZW5jeVN5bWJvbCgpO1xuICAgIGNvbnN0IGVxdWFsQW1vdW50ID0gYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50SGFuZGxlTnVsbChTeW1ib2xzLnVzZHQsIGRhdGEuYmFsYW5jZSk7XG4gICAgJGRhdGEuZWFyblNoYXJrRmluVG90YWxBc3NldCA9IGFkZEN1cnJlbmN5U3ltYm9sVG90YWxBc3NldChsZWdhbEN1cnJlbmN5U3ltYm9sLCBhd2FpdCBmb3JtYXROdW0oZXF1YWxBbW91bnQpKTtcblxuICAgIGNvbnNvbGUubG9nKGB1cGRhdGVFYXJuU2hhcmtGaW5CYXNlSW5mbyBwcm9maXRJbmNvbWUke2RhdGEucHJvZml0SW5jb21lfWApO1xuICAgIGNvbnN0IHRvZGF5UHJvZml0ID0gYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50SGFuZGxlTnVsbChTeW1ib2xzLnVzZHQsIGRhdGEucHJvZml0SW5jb21lKTtcbiAgICBjb25zdCB0b2RheVByb2ZpdFdpdGhTeW1ib2wgPSBhZGRDdXJyZW5jeVN5bWJvbChsZWdhbEN1cnJlbmN5U3ltYm9sLCB0b2RheVByb2ZpdCk7XG4gICAgJGRhdGEuZWFyblNoYXJrRmluVG9kYXlQbE51bWJlciA9IHRvZGF5UHJvZml0V2l0aFN5bWJvbDtcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHVwZGF0ZU9wdGlvbkJhc2VJbmZvKGRhdGEpIHtcbiAgICBjb25zdCBjdXJyZW5jeVN5bWJvbCA9IGF3YWl0IGdldExlZ2FsQ3VycmVuY3lTeW1ib2woKTtcbiAgICAkZGF0YS5vcHRpb25zSGVhZGVyVGl0bGUgPSBhd2FpdCBnZXRXb3JkKCduX2Fzc2V0X2FsbF9iYWxhbmNlX2NvbnZlcnQnKTtcbiAgICBpZiAoaXNIaWRkZW4pIHtcbiAgICAgICAgJGRhdGEub3B0aW9uc1RvdGFsQXNzZXQgPSBISURERU5fU1RSO1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIGNvbnN0IHRvdGFsTGVnYWwgPSBhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRIYW5kbGVOdWxsKFN5bWJvbHMudXNkdCwgZGF0YS5iYWxhbmNlKTtcbiAgICAkZGF0YS5vcHRpb25zVG90YWxBc3NldCA9IGFkZEN1cnJlbmN5U3ltYm9sVG90YWxBc3NldChjdXJyZW5jeVN5bWJvbCwgYXdhaXQgZm9ybWF0TnVtKHRvdGFsTGVnYWwpKTtcbn1cblxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZ2V0RW50cnlTaG93KCkge1xuICAgIGNvbnN0IHBhcmFtcyA9IGdlblJlcXVlc3RQYXJhbXMoc2VsbExpc3RQYXRoKTtcbiAgICB0cnkge1xuICAgICAgICBjb25zdCByZXNwb25zZVN0cmluZyA9IGF3YWl0ICRuYXRpdmVBUEkucmVxdWVzdChwYXJhbXMpO1xuICAgICAgICBjb25zdCByZXNwb25zZSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcpO1xuICAgICAgICBjb25zdCB7IGNvZGUsIGRhdGEgfSA9IHJlc3BvbnNlO1xuICAgICAgICBpZiAoY29kZSAhPT0gMjAwKSB7XG4gICAgICAgICAgICBjb25zb2xlLmVycm9yKFRBRywgYGdldEJhbGFuY2VBc3NldCwgY29kZT0ke2NvZGV9YCk7XG4gICAgICAgIH1cbiAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICAkZGF0YS5kZXNwb3NpdFNob3cgPSBkYXRhLmlzQ2xlYXJSYW5nZSAhPT0gMSA/ICd2aXNpYmxlJyA6ICdnb25lJztcbiAgICAgICAgfVxuICAgICAgICAkZGF0YS5jbG91ZFdhbGxldFNob3cgPSBhd2FpdCAkbmF0aXZlQVBJLmN1cnJlbmN5Q29tbW9uKCd7XCJ0eXBlXCI6MjF9JykgPyAndmlzaWJsZScgOiAnZ29uZSc7XG4gICAgfVxuICAgIGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUuZXJyb3IoVEFHLCBgZ2V0U2VsbExpc3QsICR7ZX1gKTtcbiAgICB9XG59XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZ2V0U3BvdEFjY291bnRJbmZvKGRpc3RyaWJ1dGlvblR5cGUpIHtcbiAgICBjb25zdCBwYXJhbSA9IHsgZGlzdHJpYnV0aW9uVHlwZSB9O1xuXG4gICAgY29uc3QgcGFyYW1zID0gZ2VuUmVxdWVzdFBhcmFtcyhzcG90QWNjb3VudEluZm9QYXRoLCBwYXJhbSk7XG4gICAgdHJ5IHtcbiAgICAgICAgY29uc3QgcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QocGFyYW1zKTtcbiAgICAgICAgY29uc3QgcmVzcG9uc2UgPSBKU09OLnBhcnNlKHJlc3BvbnNlU3RyaW5nKTtcbiAgICAgICAgY29uc3QgeyBjb2RlLCBkYXRhIH0gPSByZXNwb25zZTtcbiAgICAgICAgaWYgKGNvZGUgIT09IDIwMCkge1xuICAgICAgICAgICAgY29uc29sZS5lcnJvcihUQUcsIGBnZXRTcG90RGV0YWlsLCBjb2RlPSR7Y29kZX1gKTtcbiAgICAgICAgICAgICRkYXRhLmV4Y2hhbmdlTGlzdEVycm9yID0gZ2V0UmVzcG9uc2VQYXJhbXMoY29kZSwgZmFsc2UpO1xuICAgICAgICB9XG4gICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgY29uc3QgeyBzcG90QWNjb3VudEluZm9MaXN0IH0gPSBkYXRhO1xuICAgICAgICAgICAgaWYgKGRpc3RyaWJ1dGlvblR5cGUgPT09IERpc3RyaWJ1dGlvblR5cGUuc3BvdCkge1xuICAgICAgICAgICAgICAgIGNhY2hlRGF0YS5zcG90LnNwb3QuY3VycmVuY2llcyA9IHNwb3RBY2NvdW50SW5mb0xpc3QgJiYgc3BvdEFjY291bnRJbmZvTGlzdFswXSAmJiBzcG90QWNjb3VudEluZm9MaXN0WzBdLmN1cnJlbmN5SW5mb0xpc3QgP1xuICAgICAgICAgICAgICAgICAgICBzcG90QWNjb3VudEluZm9MaXN0WzBdLmN1cnJlbmN5SW5mb0xpc3QgOiBbXTtcbiAgICAgICAgICAgICAgICB1cGRhdGVTcG90Q3VycmVuY2llc0RhdGEoY2FjaGVEYXRhLnNwb3Quc3BvdC5jdXJyZW5jaWVzLCAwKTtcbiAgICAgICAgICAgICAgICBjb25zb2xlLmxvZygnZ2V0U3BvdEFjY291bnRJbmZvIHVwZGF0ZVNwb3RDdXJyZW5jaWVzRGF0YScpO1xuICAgICAgICAgICAgfVxuICAgICAgICB9XG4gICAgfVxuICAgIGNhdGNoIChlKSB7XG4gICAgICAgICRkYXRhLmV4Y2hhbmdlTGlzdEVycm9yID0gZ2V0UmVzcG9uc2VQYXJhbXMoLTEsIGZhbHNlKTtcbiAgICAgICAgY29uc29sZS5lcnJvcihUQUcsIGBnZXRTcG90RGV0YWlsLCAke2V9YCk7XG4gICAgfVxufVxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGdldFNwb3RCb3RJbmZvKGRpc3RyaWJ1dGlvblR5cGUpIHtcbiAgICBjb25zdCBwYXJhbSA9IHtcbiAgICAgICAgZnJvbTogXCIwXCIsXG4gICAgICAgIGRpcmVjdDogXCIxXCIsXG4gICAgICAgIGxpbWl0OiBcIjEwMFwiLFxuICAgIH07XG5cbiAgICBjb25zdCBwYXJhbXMgPSBnZW5SZXF1ZXN0UGFyYW1zKHNwb3RCb3RJbmZvUGF0aCwgcGFyYW0pO1xuICAgIHRyeSB7XG4gICAgICAgIGNvbnN0IHJlc3BvbnNlU3RyaW5nID0gYXdhaXQgJG5hdGl2ZUFQSS5yZXF1ZXN0KHBhcmFtcyk7XG4gICAgICAgIGNvbnN0IHJlc3BvbnNlID0gSlNPTi5wYXJzZShyZXNwb25zZVN0cmluZyk7XG4gICAgICAgIGNvbnN0IHsgY29kZSwgZGF0YSB9ID0gcmVzcG9uc2U7XG4gICAgICAgIGlmIChjb2RlICE9PSAyMDApIHtcbiAgICAgICAgICAgICRkYXRhLmJvdExpc3RFcnJvciA9IGdldFJlc3BvbnNlUGFyYW1zKGNvZGUsIGZhbHNlKTtcbiAgICAgICAgICAgIGNvbnNvbGUuZXJyb3IoVEFHLCBgZ2V0U3BvdERldGFpbCwgY29kZT0ke2NvZGV9YCk7XG4gICAgICAgIH1cbiAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICBjYWNoZURhdGEuc3BvdC5ib3QuY3VycmVuY2llcyA9IGRhdGEgPyBkYXRhLnN0cmF0ZWd5TGlzdCA6IFtdO1xuICAgICAgICAgICAgdXBkYXRlQm90Q3VycmVuY2llc0RhdGEoY2FjaGVEYXRhLnNwb3QuYm90LmN1cnJlbmNpZXMpO1xuICAgICAgICAgICAgY29uc29sZS5sb2coJ3VwZGF0ZUJvdEN1cnJlbmNpZXNEYXRhJyk7XG4gICAgICAgIH1cbiAgICB9XG4gICAgY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5lcnJvcihUQUcsIGBnZXRTcG90RGV0YWlsLCAke2V9YCk7XG4gICAgICAgICRkYXRhLmJvdExpc3RFcnJvciA9IGdldFJlc3BvbnNlUGFyYW1zKC0xLCBmYWxzZSk7XG4gICAgfVxufVxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGdldFNwb3RDb2xsYXRlcmFsSW5mbyhkaXN0cmlidXRpb25UeXBlKSB7XG4gICAgY29uc3QgcGFyYW0gPSB7IGRpc3RyaWJ1dGlvblR5cGUgfTtcbiAgICBjb25zdCBwYXJhbXMgPSBnZW5SZXF1ZXN0UGFyYW1zKHNwb3RDb2xsYXRlcmFsSW5mb1BhdGgsIHBhcmFtKTtcbiAgICB0cnkge1xuICAgICAgICBjb25zdCByZXNwb25zZVN0cmluZyA9IGF3YWl0ICRuYXRpdmVBUEkucmVxdWVzdChwYXJhbXMpO1xuICAgICAgICBjb25zdCByZXNwb25zZSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcpO1xuICAgICAgICBjb25zdCB7IGNvZGUsIGRhdGEgfSA9IHJlc3BvbnNlO1xuICAgICAgICBpZiAoY29kZSAhPT0gMjAwKSB7XG4gICAgICAgICAgICAkZGF0YS5jb2xsYXRlcmFsRGF0YUVycm9yID0gZ2V0UmVzcG9uc2VQYXJhbXMoY29kZSwgZmFsc2UpO1xuICAgICAgICAgICAgY29uc29sZS5lcnJvcihUQUcsIGBnZXRTcG90Q29sbGF0ZXJhbEluZm8sIGNvZGU9JHtjb2RlfWApO1xuICAgICAgICB9XG4gICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgY2FjaGVEYXRhLnNwb3QuY29sbGF0ZXJhbC5sb2FuaW5nTGlzdCA9IGRhdGEubG9hbmluZ0xpc3QgPyBkYXRhLmxvYW5pbmdMaXN0IDogW107XG4gICAgICAgICAgICBjYWNoZURhdGEuc3BvdC5jb2xsYXRlcmFsLnBsZWRnZUxpc3QgPSBkYXRhLnBsZWRnZUxpc3QgPyBkYXRhLnBsZWRnZUxpc3QgOiBbXTtcbiAgICAgICAgICAgIHVwZGF0ZVNwb3RDb2xsYXRlcmFsQ3VycmVuY3lEYXRhKGNhY2hlRGF0YS5zcG90LmNvbGxhdGVyYWwubG9hbmluZ0xpc3QsIGNhY2hlRGF0YS5zcG90LmNvbGxhdGVyYWwucGxlZGdlTGlzdCk7XG4gICAgICAgICAgICBjYWNoZURhdGEuc3BvdC5ib3QubG9hbmVkID0gZGF0YS5sb2FuaW5nVVNEVDtcbiAgICAgICAgICAgIGNhY2hlRGF0YS5zcG90LmJvdC5jb2xsYXRlcmFsID0gZGF0YS5wbGVkZ2luZ1VTRFQ7XG4gICAgICAgICAgICAvL+WkhOeQhui0qOaKvOi3s+i9rFxuICAgICAgICAgICAgY29uc3QgbmV3VXJsRW5hYmxlID0gZGF0YS5uZXdVcmxFbmFibGU7XG4gICAgICAgICAgICBjb25zdCBpbmRleEp1bXBVcmwgPSBkYXRhLmluZGV4SnVtcFVybDtcbiAgICAgICAgICAgIGNvbnN0IG9yZGVySnVtcFVybCA9IGRhdGEub3JkZXJKdW1wVXJsO1xuICAgICAgICAgICAgaGFuZGxlckNvbGxhdGVyYWxVcmwoe25ld1VybEVuYWJsZSwgaW5kZXhKdW1wVXJsLCBvcmRlckp1bXBVcmx9KTtcbiAgICAgICAgfVxuICAgIH1cbiAgICBjYXRjaCAoZSkge1xuICAgICAgICBjb25zb2xlLmVycm9yKFRBRywgYGdldFNwb3RDb2xsYXRlcmFsSW5mbywgJHtlfWApO1xuICAgICAgICAkZGF0YS5jb2xsYXRlcmFsRGF0YUVycm9yID0gZ2V0UmVzcG9uc2VQYXJhbXMoLTEsIGZhbHNlKTtcbiAgICB9XG59XG4vL+i3s+i9rOi0qOaKvFxuZXhwb3J0IGZ1bmN0aW9uIGdvVG9Db2xsYXRlcmFsKCkge1xuICAgIGNvbnNvbGUubG9nKGBnb1RvQ29sbGF0ZXJhbCBpbmRleEp1bXBVcmw9ICR7JGRhdGEuaW5kZXhKdW1wVXJsfWApO1xuICAgIG9wZW5Sb3V0ZXIoYCR7JGRhdGEuaW5kZXhKdW1wVXJsfWApO1xufVxuLy/otKjmirzorrDlvZVcbmV4cG9ydCBmdW5jdGlvbiBnb1RvQ29sbGF0ZXJhbEhpc3RvcnkoKSB7XG4gICAgY29uc29sZS5sb2coYGdvVG9Db2xsYXRlcmFsSGlzdG9yeSBpbmRleEp1bXBVcmw9ICR7JGRhdGEub3JkZXJKdW1wVXJsfWApO1xuICAgIG9wZW5Sb3V0ZXIoYCR7JGRhdGEub3JkZXJKdW1wVXJsfWApO1xufVxuZnVuY3Rpb24gaGFuZGxlckNvbGxhdGVyYWxVcmwoe25ld1VybEVuYWJsZSwgaW5kZXhKdW1wVXJsLCBvcmRlckp1bXBVcmx9KSB7XG4gICAgLy/ml6fot7Povaznm7TmjqXkvb/nlKjvvIzmlrDot7PovazpnIDopoHmi7zmjqVcbiAgICBpZiAobmV3VXJsRW5hYmxlKSB7XG4gICAgICAgICRkYXRhLmluZGV4SnVtcFVybCA9IGAke2NvbW1vbkRhdGEud2ViVXJsfS8ke2NvbW1vbkRhdGEubGFuZ3VhZ2V9JHtpbmRleEp1bXBVcmx9YDtcbiAgICAgICAgJGRhdGEub3JkZXJKdW1wVXJsID0gYCR7Y29tbW9uRGF0YS53ZWJVcmx9LyR7Y29tbW9uRGF0YS5sYW5ndWFnZX0ke29yZGVySnVtcFVybH1gO1xuICAgIH0gZWxzZSB7XG4gICAgICAgICRkYXRhLmluZGV4SnVtcFVybCA9IGluZGV4SnVtcFVybDtcbiAgICAgICAgJGRhdGEub3JkZXJKdW1wVXJsID0gb3JkZXJKdW1wVXJsO1xuICAgIH1cbn1cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRDb250cmFjdFVzZHRNKCkge1xuICAgIGNvbnNvbGUubG9nKCdnZXRDb250cmFjdFVzZHRNJyk7XG4gICAgY29uc3QgcGFyYW1zID0gZ2VuUmVxdWVzdFBhcmFtcyhjb250cmFjdFVzZHRNUGF0aCk7XG4gICAgdHJ5IHtcbiAgICAgICAgY29uc3QgcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QocGFyYW1zKTtcbiAgICAgICAgY29uc3QgcmVzcG9uc2UgPSBKU09OLnBhcnNlKHJlc3BvbnNlU3RyaW5nKTtcbiAgICAgICAgY29uc3QgeyBjb2RlLCBkYXRhIH0gPSByZXNwb25zZTtcbiAgICAgICAgaWYgKGNvZGUgIT09IDIwMCkge1xuICAgICAgICAgICAgJGRhdGEudXNkdE1BbGxBc3NldExpc3RFcnJvciA9IGdldFJlc3BvbnNlUGFyYW1zKGNvZGUsIGZhbHNlKTtcbiAgICAgICAgICAgICRkYXRhLnVzZHRNT3duQXNzZXRMaXN0RXJyb3IgPSBnZXRSZXNwb25zZVBhcmFtcyhjb2RlLCBmYWxzZSk7XG4gICAgICAgICAgICBjb25zb2xlLmVycm9yKFRBRywgYGdldENvbnRyYWN0VXNkdE0sIGNvZGU9JHtjb2RlfWApO1xuICAgICAgICB9XG4gICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgY2FjaGVEYXRhLmNvbnRyYWN0LnVzZHRfbS5hbGwubGlzdCA9IGRhdGEuYXNzZXRDdXJyZW5jeUxpc3QgPyBkYXRhLmFzc2V0Q3VycmVuY3lMaXN0IDogW107XG4gICAgICAgICAgICBjYWNoZURhdGEuY29udHJhY3QudXNkdF9tLm93bmVkLmxpc3QgPSBkYXRhLmhvbGRDdXJyZW5jeUxpc3QgPyBkYXRhLmhvbGRDdXJyZW5jeUxpc3QgOiBbXTtcbiAgICAgICAgICAgIGlmICh1c2R0TUFsbCkge1xuICAgICAgICAgICAgICAgIHVwZGF0ZUNvbnRyYWN0QWxsRGF0YShEaXN0cmlidXRpb25UeXBlLnVzZHRNLCBjYWNoZURhdGEuY29udHJhY3QudXNkdF9tLmFsbC5saXN0KTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgICAgIHVwZGF0ZUNvbnRyYWN0T3duZWREYXRhKERpc3RyaWJ1dGlvblR5cGUudXNkdE0sIGNhY2hlRGF0YS5jb250cmFjdC51c2R0X20ub3duZWQubGlzdCk7XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICB9XG4gICAgY2F0Y2ggKGUpIHtcbiAgICAgICAgJGRhdGEudXNkdE1BbGxBc3NldExpc3RFcnJvciA9IGdldFJlc3BvbnNlUGFyYW1zKC0xLCBmYWxzZSk7XG4gICAgICAgICRkYXRhLnVzZHRNT3duQXNzZXRMaXN0RXJyb3IgPSBnZXRSZXNwb25zZVBhcmFtcygtMSwgZmFsc2UpO1xuICAgICAgICBjb25zb2xlLmVycm9yKFRBRywgYGdldENvbnRyYWN0VXNkdE0sICR7ZX1gKTtcbiAgICB9XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRDb3B5VHJhZGluZ0RhdGEoKSB7XG4gICAgY29uc29sZS5sb2coJ2dldENvcHlUcmFkaW5nRGF0YScpO1xuICAgIGNvbnN0IHBhcmFtID0ge1xuICAgICAgICBhY2NvdW50VHlwZTogXCIyXCJcbiAgICB9O1xuICAgIGNvbnN0IHBhcmFtcyA9IGdlblJlcXVlc3RQYXJhbXMoY29udHJhY3RDb3B5VHJhZGluZ1BhdGgsIHBhcmFtKTtcbiAgICB0cnkge1xuICAgICAgICBjb25zdCByZXNwb25zZVN0cmluZyA9IGF3YWl0ICRuYXRpdmVBUEkucmVxdWVzdChwYXJhbXMpO1xuICAgICAgICBjb25zdCByZXNwb25zZSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcpO1xuICAgICAgICBjb25zdCB7IGNvZGUsIGRhdGEgfSA9IHJlc3BvbnNlO1xuICAgICAgICBpZiAoY29kZSAhPT0gMjAwKSB7XG4gICAgICAgICAgICAkZGF0YS5jb3B5VHJhZGluZ0xpc3RFcnJvciA9IGdldFJlc3BvbnNlUGFyYW1zKGNvZGUsIGZhbHNlKTtcbiAgICAgICAgICAgIGNvbnNvbGUuZXJyb3IoVEFHLCBgZ2V0Q29weVRyYWRpbmdEYXRhLCBjb2RlPSR7Y29kZX1gKTtcbiAgICAgICAgfVxuICAgICAgICBlbHNlIHtcbiAgICAgICAgICAgIGNvbnNvbGUuZXJyb3IoVEFHLCBgZ2V0Q29weVRyYWRpbmdEYXRhLCBkYXRhPSR7ZGF0YX0gIHJlc3BvbnNlPToke3Jlc3BvbnNlfWApO1xuICAgICAgICAgICAgY2FjaGVEYXRhLmNvbnRyYWN0LmNvcHlfdHJhZGluZy5saXN0ID0gZGF0YS5hY2NvdW50U3ltYm9sTGlzdCA/IGRhdGEuYWNjb3VudFN5bWJvbExpc3QgOiBbXTtcbiAgICAgICAgICAgIHVwZGF0ZUNvcHlUcmFkaW5nTGlzdChjYWNoZURhdGEuY29udHJhY3QuY29weV90cmFkaW5nLmxpc3QpO1xuICAgICAgICB9XG4gICAgfVxuICAgIGNhdGNoIChlKSB7XG4gICAgICAgICRkYXRhLmNvcHlUcmFkaW5nTGlzdEVycm9yID0gZ2V0UmVzcG9uc2VQYXJhbXMoLTEsIGZhbHNlKTtcbiAgICAgICAgY29uc29sZS5lcnJvcihUQUcsIGBnZXRDb3B5VHJhZGluZ0RhdGEsICR7ZX1gKTtcbiAgICB9XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiB1cGRhdGVDb3B5VHJhZGluZ0xpc3Qob2xkTGlzdCkge1xuICAgIGNvbnN0IGRhdGEgPSBbXTtcbiAgICBjb25zb2xlLmVycm9yKCd1cGRhdGVDb3B5VHJhZGluZ0xpc3QnKTtcbiAgICBjb25zb2xlLmVycm9yKG9sZExpc3QpO1xuICAgIGNvbnN0IHNlYXJjaEtleSA9IGNhY2hlRGF0YS5jb250cmFjdC5jb3B5X3RyYWRpbmcuc2VhcmNoS2V5O1xuICAgIGNvbnN0IGhpZGRlblNtYWxsQXNzZXQgPSBjYWNoZURhdGEuY29udHJhY3QuY29weV90cmFkaW5nLmhpZGRlblNtYWxsQXNzZXQ7XG4gICAgYXdhaXQgUHJvbWlzZS5hbGwob2xkTGlzdC5tYXAoYXN5bmMgKGl0ZW0pID0+IHtcbiAgICAgICAgaWYgKGF3YWl0IGl0ZW1TaG91bGRTaG93KGl0ZW0uc3ltYm9sLCBpdGVtLnN5bWJvbCwgaXRlbS53aXRoZHJhd0F2YWlsYWJsZSwgaGlkZGVuU21hbGxBc3NldCwgc2VhcmNoS2V5KSkge1xuICAgICAgICAgICAgZGF0YS5wdXNoKGl0ZW0pO1xuICAgICAgICB9XG4gICAgfSkpO1xuICAgIGNvbnNvbGUuZXJyb3IoJ3VwZGF0ZUNvcHlUcmFkaW5nTGlzdCAtLS0+Pj4+IGRhdGEnKTtcbiAgICBjb25zb2xlLmVycm9yKGRhdGEpO1xuICAgIGNvbnN0IHNvcnREYXRhID0gYXdhaXQgc29ydExpc3QoZGF0YSwgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50Rm9yQ29weVRyYWRpbmcpO1xuICAgIGNhY2hlRGF0YS5jb250cmFjdC5jb3B5X3RyYWRpbmcubmV3TGlzdCA9IHNvcnREYXRhO1xuICAgIGNvbnN0IGxpc3QgPSBhd2FpdCBQcm9taXNlLmFsbChzb3J0RGF0YS5tYXAoYXN5bmMgaXRlbSA9PiB7XG4gICAgICAgIHJldHVybiB7XG4gICAgICAgICAgICBzeW1ib2xJY29uOiBhd2FpdCBnZXRJY29uVXJsKGl0ZW0uc3ltYm9sKSxcbiAgICAgICAgICAgIHN5bWJvbE5hbWU6IGl0ZW0uc3ltYm9sLnRvVXBwZXJDYXNlKCksXG4gICAgICAgICAgICBhdmFpbGFibGU6IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGF3YWl0IGdldFByZUN1cnJlbmN5QW1vdW50KGl0ZW0uc3ltYm9sLCBpdGVtLndpdGhkcmF3QXZhaWxhYmxlKSxcbiAgICAgICAgICAgIHRvdGFsOiBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBhd2FpdCBhZGRDdXJyZW50Q3VycmVuY3lTeW1ib2woYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50KFN5bWJvbHMudXNkdCwgaXRlbS5hY2NvdW50VG90YWxFcXVpdHkpKVxuICAgICAgICB9O1xuICAgIH0pKTtcbiAgICAkZGF0YS5jb3B5VHJhZGluZ0xpc3QgPSBKU09OLnN0cmluZ2lmeShsaXN0KTtcbn1cblxuXG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRDb250cmFjdFVzZHRNVW5pdHkoKSB7XG4gICAgY29uc29sZS5sb2coJ2dldENvbnRyYWN0VXNkdE1Vbml0eScpO1xuICAgIGNvbnN0IHBhcmFtcyA9IGdlblJlcXVlc3RQYXJhbXMoY29udHJhY3RVc2R0TVVuaXR5UGF0aCwgeyB1bmlvblR5cGU6IDEgfSk7XG4gICAgdHJ5IHtcbiAgICAgICAgY29uc3QgcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QocGFyYW1zKTtcbiAgICAgICAgY29uc3QgcmVzcG9uc2UgPSBKU09OLnBhcnNlKHJlc3BvbnNlU3RyaW5nKTtcbiAgICAgICAgY29uc3QgeyBjb2RlLCBkYXRhIH0gPSByZXNwb25zZTtcbiAgICAgICAgaWYgKGNvZGUgIT09IDIwMCkge1xuICAgICAgICAgICAgJGRhdGEudXNkdE1BbGxBc3NldExpc3RFcnJvciA9IGdldFJlc3BvbnNlUGFyYW1zKGNvZGUsIGZhbHNlKTtcbiAgICAgICAgICAgICRkYXRhLnVzZHRNT3duQXNzZXRMaXN0RXJyb3IgPSBnZXRSZXNwb25zZVBhcmFtcyhjb2RlLCBmYWxzZSk7XG4gICAgICAgICAgICBjb25zb2xlLmVycm9yKFRBRywgYGdldENvbnRyYWN0VXNkdE0sIGNvZGU9JHtjb2RlfWApO1xuICAgICAgICB9XG4gICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgY2FjaGVEYXRhLmNvbnRyYWN0LnVzZHRfbV91bml0eS5hbGwubGlzdCA9IGRhdGEuYXNzZXRDdXJyZW5jeUxpc3QgPyBkYXRhLmFzc2V0Q3VycmVuY3lMaXN0IDogW107XG4gICAgICAgICAgICBjYWNoZURhdGEuY29udHJhY3QudXNkdF9tX3VuaXR5Lm93bmVkLmxpc3QgPSBkYXRhLmhvbGRDdXJyZW5jeUxpc3QgPyBkYXRhLmhvbGRDdXJyZW5jeUxpc3QgOiBbXTtcbiAgICAgICAgICAgIGNhY2hlRGF0YS5jb250cmFjdC51c2R0X21fdW5pdHkuYXNzZXRUeXBlID0gZGF0YS5hc3NldFR5cGU7IC8vIOi0puaIt+exu+Wei++8iDHvvJrlhajpgJDku5PvvIwgMu+8mue7n+S4gOi0puaIt++8jCAz77ya6IGU5ZCI5L+d6K+B6YeR77yJXG4gICAgICAgICAgICBpZiAodXNkdE1BbGwpIHtcbiAgICAgICAgICAgICAgICB1cGRhdGVDb250cmFjdFVzZHRNVW5pdHlEYXRhKGNhY2hlRGF0YS5jb250cmFjdC51c2R0X21fdW5pdHkuYWxsLmxpc3QpO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICAgICAgdXBkYXRlQ29udHJhY3RPd25lZERhdGEoRGlzdHJpYnV0aW9uVHlwZS51c2R0TSwgY2FjaGVEYXRhLmNvbnRyYWN0LnVzZHRfbV91bml0eS5vd25lZC5saXN0KTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgIH1cbiAgICBjYXRjaCAoZSkge1xuICAgICAgICAkZGF0YS51c2R0TUFsbEFzc2V0TGlzdEVycm9yID0gZ2V0UmVzcG9uc2VQYXJhbXMoLTEsIGZhbHNlKTtcbiAgICAgICAgJGRhdGEudXNkdE1Pd25Bc3NldExpc3RFcnJvciA9IGdldFJlc3BvbnNlUGFyYW1zKC0xLCBmYWxzZSk7XG4gICAgICAgIGNvbnNvbGUuZXJyb3IoVEFHLCBgZ2V0Q29udHJhY3RVc2R0TSwgJHtlfWApO1xuICAgIH1cbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGdldENvbnRyYWN0Q29pbkZ1dHVyZXMoKSB7XG4gICAgY29uc3QgcGFyYW1zID0gZ2VuUmVxdWVzdFBhcmFtcyhjb250cmFjdENvaW5GdXR1cmVzUGF0aCk7XG4gICAgdHJ5IHtcbiAgICAgICAgY29uc3QgcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QocGFyYW1zKTtcbiAgICAgICAgY29uc3QgcmVzcG9uc2UgPSBKU09OLnBhcnNlKHJlc3BvbnNlU3RyaW5nKTtcbiAgICAgICAgY29uc3QgeyBjb2RlLCBkYXRhIH0gPSByZXNwb25zZTtcbiAgICAgICAgaWYgKGNvZGUgIT09IDIwMCkge1xuICAgICAgICAgICAgJGRhdGEuY29pbk1BbGxBc3NldExpc3RFcnJvciA9IGdldFJlc3BvbnNlUGFyYW1zKGNvZGUsIGZhbHNlKTtcbiAgICAgICAgICAgICRkYXRhLmNvaW5NT3duQXNzZXRMaXN0RXJyb3IgPSBnZXRSZXNwb25zZVBhcmFtcyhjb2RlLCBmYWxzZSk7XG4gICAgICAgICAgICBjb25zb2xlLmVycm9yKFRBRywgYGdldENvbnRyYWN0Q29pbkZ1dHVyZXMsIGNvZGU9JHtjb2RlfWApO1xuICAgICAgICB9XG4gICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgY2FjaGVEYXRhLmNvbnRyYWN0LmNvaW5fZi5hbGwubGlzdCA9IGRhdGEuYXNzZXRDdXJyZW5jeUxpc3QgPyBkYXRhLmFzc2V0Q3VycmVuY3lMaXN0IDogW107XG4gICAgICAgICAgICBjYWNoZURhdGEuY29udHJhY3QuY29pbl9mLm93bmVkLmxpc3QgPSBkYXRhLmhvbGRDdXJyZW5jeUxpc3QgPyBkYXRhLmhvbGRDdXJyZW5jeUxpc3QgOiBbXTtcbiAgICAgICAgICAgIGlmIChjb2luTUFsbCkge1xuICAgICAgICAgICAgICAgIHVwZGF0ZUNvbnRyYWN0QWxsRGF0YShEaXN0cmlidXRpb25UeXBlLmNvaW5GdXR1cmVzLCBjYWNoZURhdGEuY29udHJhY3QuY29pbl9mLmFsbC5saXN0KTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgICAgIHVwZGF0ZUNvbnRyYWN0T3duZWREYXRhKERpc3RyaWJ1dGlvblR5cGUuY29pbkZ1dHVyZXMsIGNhY2hlRGF0YS5jb250cmFjdC5jb2luX2Yub3duZWQubGlzdCk7XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICB9XG4gICAgY2F0Y2ggKGUpIHtcbiAgICAgICAgJGRhdGEuY29pbk1BbGxBc3NldExpc3RFcnJvciA9IGdldFJlc3BvbnNlUGFyYW1zKC0xLCBmYWxzZSk7XG4gICAgICAgICRkYXRhLmNvaW5NT3duQXNzZXRMaXN0RXJyb3IgPSBnZXRSZXNwb25zZVBhcmFtcygtMSwgZmFsc2UpO1xuICAgICAgICBjb25zb2xlLmVycm9yKFRBRywgYGdldENvbnRyYWN0Q29pbkZ1dHVyZXMsICR7ZX1gKTtcbiAgICB9XG59XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZ2V0Q29udHJhY3RDb2luUGVycGV0dWFsKCkge1xuICAgIGNvbnN0IHBhcmFtcyA9IGdlblJlcXVlc3RQYXJhbXMoY29udHJhY3RDb2luUGVycGV0dWFsUGF0aCk7XG4gICAgdHJ5IHtcbiAgICAgICAgY29uc3QgcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QocGFyYW1zKTtcbiAgICAgICAgY29uc3QgcmVzcG9uc2UgPSBKU09OLnBhcnNlKHJlc3BvbnNlU3RyaW5nKTtcbiAgICAgICAgY29uc3QgeyBjb2RlLCBkYXRhIH0gPSByZXNwb25zZTtcbiAgICAgICAgaWYgKGNvZGUgIT09IDIwMCkge1xuICAgICAgICAgICAgJGRhdGEuY29pblBBbGxBc3NldExpc3RFcnJvciA9IGdldFJlc3BvbnNlUGFyYW1zKGNvZGUsIGZhbHNlKTtcbiAgICAgICAgICAgICRkYXRhLmNvaW5QT3duQXNzZXRMaXN0RXJyb3IgPSBnZXRSZXNwb25zZVBhcmFtcyhjb2RlLCBmYWxzZSk7XG4gICAgICAgICAgICBjb25zb2xlLmVycm9yKFRBRywgYGdldENvbnRyYWN0Q29pblBlcnBldHVhbCwgY29kZT0ke2NvZGV9YCk7XG4gICAgICAgIH1cbiAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICBjYWNoZURhdGEuY29udHJhY3QuY29pbl9wLmFsbC5saXN0ID0gZGF0YS5hc3NldEN1cnJlbmN5TGlzdCA/IGRhdGEuYXNzZXRDdXJyZW5jeUxpc3QgOiBbXTtcbiAgICAgICAgICAgIGNhY2hlRGF0YS5jb250cmFjdC5jb2luX3Aub3duZWQubGlzdCA9IGRhdGEuaG9sZEN1cnJlbmN5TGlzdCA/IGRhdGEuaG9sZEN1cnJlbmN5TGlzdCA6IFtdO1xuICAgICAgICAgICAgaWYgKGNvaW5QQWxsKSB7XG4gICAgICAgICAgICAgICAgdXBkYXRlQ29udHJhY3RBbGxEYXRhKERpc3RyaWJ1dGlvblR5cGUuY29pblAsIGNhY2hlRGF0YS5jb250cmFjdC5jb2luX3AuYWxsLmxpc3QpO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICAgICAgdXBkYXRlQ29udHJhY3RPd25lZERhdGEoRGlzdHJpYnV0aW9uVHlwZS5jb2luUCwgY2FjaGVEYXRhLmNvbnRyYWN0LmNvaW5fcC5vd25lZC5saXN0KTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgIH1cbiAgICBjYXRjaCAoZSkge1xuICAgICAgICAkZGF0YS5jb2luUEFsbEFzc2V0TGlzdEVycm9yID0gZ2V0UmVzcG9uc2VQYXJhbXMoLTEsIGZhbHNlKTtcbiAgICAgICAgJGRhdGEuY29pblBPd25Bc3NldExpc3RFcnJvciA9IGdldFJlc3BvbnNlUGFyYW1zKC0xLCBmYWxzZSk7XG4gICAgICAgIGNvbnNvbGUuZXJyb3IoVEFHLCBgZ2V0Q29udHJhY3RDb2luUGVycGV0dWFsLCAke2V9YCk7XG4gICAgfVxufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZ2V0RGVwb3NpdEJhbm5lckluZm8oYXNzZXRMZXZlbDIpIHtcbiAgICB2YXIgYXNzZXRMZXZlbCA9IGZpeE51bWJlcihhc3NldExldmVsMiwgMCk7XG4gICAgY29uc3QgcGFyYW1zID0gZ2VuUmVxdWVzdFBhcmFtcyhiYWxhbmNlRGVwb3NpdFJlY29tbWVuZFBhdGgsIHsgYXNzZXRMZXZlbCB9KTtcbiAgICB0cnkge1xuICAgICAgICBjb25zdCByZXNwb25zZVN0cmluZyA9IGF3YWl0ICRuYXRpdmVBUEkucmVxdWVzdChwYXJhbXMpO1xuICAgICAgICBjb25zdCByZXNwb25zZSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcpO1xuICAgICAgICBjb25zdCB7IGNvZGUsIGRhdGEgfSA9IHJlc3BvbnNlO1xuICAgICAgICBpZiAoY29kZSAhPT0gMjAwKSB7XG4gICAgICAgICAgICByZXR1cm4gbnVsbDtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIHJldHVybiBkYXRhO1xuICAgICAgICB9XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICByZXR1cm4gbnVsbDtcbiAgICB9XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiB1cGRhdGVUb3RhbEFzc2V0RGF0YShkYXRhKSB7XG4gICAgdHJ5IHtcbiAgICAgICAgY29uc3QgaXNBbmFseXNpcyA9IGF3YWl0ICRuYXRpdmVBUEkuY3VycmVuY3lDb21tb24oJ3tcInR5cGVcIjoxMX0nKTtcbiAgICAgICAgJGRhdGEuaXNPcGVuQW5hbHlzaXMgPSBpc0FuYWx5c2lzID8gJzEnIDogJzAnO1xuICAgICAgICBpZiAoaXNBbmFseXNpcykge1xuICAgICAgICAgICAgJGRhdGEuYW5hbHlzaXMgPSBhd2FpdCBnZXRXb3JkKCduX2JhbGFuY2VfZ290b19wcm9maXRfZGFpbHknKTtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICRkYXRhLmFuYWx5c2lzID0gYXdhaXQgZ2V0V29yZCgnbl9jbG91ZF93YWxsZXRfYXNzZXRfcHJvZml0X2RhaWx5Jyk7XG4gICAgICAgIH1cbiAgICAgICAgJGRhdGEuYXNzZXRMZXZlbCA9IGRhdGEuYXNzZXRMZXZlbDtcbiAgICAgICAgJGRhdGEuc2hvd1JlY29tbWVuZCA9IGRhdGEuYXNzZXRMZXZlbCAhPSAwID8gXCJ2aXNpYmxlXCIgOiBcImdvbmVcIjtcbiAgICAgICAgJGRhdGEuc2hhcmVWaXNpYmlsaXR5ID0gJ3Zpc2libGUnO1xuICAgICAgICAkZGF0YS5yZXN0cmljdGlvblZpcyA9IChkYXRhLmlzQWxsb3cgPT0gbnVsbCB8fCBkYXRhLmlzQWxsb3cgPT0gdHJ1ZSkgPyBcImdvbmVcIiA6IFwidmlzaWJsZVwiO1xuICAgICAgICBleGNoYW5nZUVuYWJsZSA9IGRhdGEuZXhjaGFuZ2VFbmFibGUgfHwgZmFsc2U7XG4gICAgICAgIGV4Y2hhbmdlSnVtcFVybCA9IGRhdGEuZXhjaGFuZ2VKdW1wVXJsIHx8IFwiXCI7XG4gICAgICAgICRkYXRhLmV4Y2hhbmdlVVNERFZpcyA9ICRkYXRhLnJlc3RyaWN0aW9uVmlzID09IFwiZ29uZVwiICYmIGV4Y2hhbmdlRW5hYmxlID8gXCJ2aXNpYmxlXCIgOiBcImdvbmVcIjtcbiAgICAgICAgbGV0IGJhbm5lckRhdGEgPSBudWxsO1xuICAgICAgICBsZXQgY291cG9uID0gZGF0YS5jb3Vwb247XG4gICAgICAgIGlmIChkYXRhLmFzc2V0TGV2ZWwgPT09IDEpIHtcbiAgICAgICAgICAgIGJhbm5lckRhdGEgPSBhd2FpdCBnZXREZXBvc2l0QmFubmVySW5mbygkZGF0YS5hc3NldExldmVsKTtcbiAgICAgICAgICAgIGlmIChiYW5uZXJEYXRhID09PSBudWxsIHx8ICFiYW5uZXJEYXRhLmxlbmd0aCkge1xuICAgICAgICAgICAgICAgICRkYXRhLnNob3dSZWNvbW1lbmQgPSAnZ29uZSc7XG4gICAgICAgICAgICAgICAgJGRhdGEuYXNzZXRSb2NrZXRGaW5pc2hlZCA9ICcxJztcbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgJGRhdGEuYmFubmVySW5mb3MgPSBKU09OLnN0cmluZ2lmeShiYW5uZXJEYXRhKTtcbiAgICAgICAgICAgICAgICAkZGF0YS5hc3NldEJhbm5lckluZm9GaW5pc2hlZCA9ICcxJztcbiAgICAgICAgICAgIH1cbiAgICAgICAgfSBlbHNlIGlmIChkYXRhLmFzc2V0TGV2ZWwgPiAxKSB7XG4gICAgICAgICAgICBjb25zdCBwYXJhbXMgPSBnZW5SZXF1ZXN0UGFyYW1zKGJhbGFuY2VGaW5hbmNpYWxCYW5uZXJQYXRoKTtcbiAgICAgICAgICAgIHRyeSB7XG4gICAgICAgICAgICAgICAgY29uc3QgcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QocGFyYW1zKTtcbiAgICAgICAgICAgICAgICBjb25zdCByZXNwb25zZSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcpO1xuICAgICAgICAgICAgICAgIGNvbnN0IHsgY29kZSwgZGF0YSB9ID0gcmVzcG9uc2U7XG4gICAgICAgICAgICAgICAgbGV0IGJhbm5lckluZm8gPSBudWxsO1xuICAgICAgICAgICAgICAgIGlmIChjb2RlICE9PSAyMDApIHtcbiAgICAgICAgICAgICAgICAgICAgY29uc29sZS5lcnJvcihUQUcsIGBhc3NldHMvZmluYW5jaWFsLCBjb2RlPSR7Y29kZX1gKTtcbiAgICAgICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICBiYW5uZXJJbmZvID0ge1xuICAgICAgICAgICAgICAgICAgICAgICAgXCJ0eXBlXCI6IDIsXG4gICAgICAgICAgICAgICAgICAgICAgICBcImxlZnRJbmZvXCI6IGxlZ2FsU3RyaW5nKGRhdGEuc3ltYm9sKSxcbiAgICAgICAgICAgICAgICAgICAgICAgIFwidGl0bGVcIjogbGVnYWxTdHJpbmcoZGF0YS5wcm9qZWN0VHJhbnNsYXRlTmFtZSksXG4gICAgICAgICAgICAgICAgICAgICAgICBcImRlc2NcIjogbGVnYWxTdHJpbmcoZGF0YS5hcHlUcmFuc2xhdGUpLFxuICAgICAgICAgICAgICAgICAgICAgICAgXCJyaWdodEluZm9cIjogbGVnYWxTdHJpbmcoZGF0YS55ZWFyRGlzcGxheVJhdGUpLFxuICAgICAgICAgICAgICAgICAgICAgICAgXCJqdW1wVXJsXCI6IGxlZ2FsU3RyaW5nKGRhdGEuanVtcFVybClcbiAgICAgICAgICAgICAgICAgICAgfTtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgYmFubmVyRGF0YSA9IGF3YWl0IGdldERlcG9zaXRCYW5uZXJJbmZvKCRkYXRhLmFzc2V0TGV2ZWwpO1xuICAgICAgICAgICAgICAgIGxldCBiYW5uZXJEYXRhTnVsbCA9IChiYW5uZXJEYXRhID09PSBudWxsIHx8ICFiYW5uZXJEYXRhLmxlbmd0aCk7XG4gICAgICAgICAgICAgICAgaWYgKCRkYXRhLmFzc2V0TGV2ZWwgPT09IDIpIHtcbiAgICAgICAgICAgICAgICAgICAgaWYgKGJhbm5lckRhdGFOdWxsICYmIGJhbm5lckluZm8gPT09IG51bGwpIHtcbiAgICAgICAgICAgICAgICAgICAgICAgICRkYXRhLnNob3dSZWNvbW1lbmQgPSAnZ29uZSc7XG4gICAgICAgICAgICAgICAgICAgIH0gZWxzZSBpZiAoYmFubmVyRGF0YU51bGwgJiYgYmFubmVySW5mbyAhPT0gbnVsbCkge1xuICAgICAgICAgICAgICAgICAgICAgICAgJGRhdGEuYmFubmVySW5mb3MgPSBKU09OLnN0cmluZ2lmeShbYmFubmVySW5mb10pO1xuICAgICAgICAgICAgICAgICAgICB9IGVsc2UgaWYgKCFiYW5uZXJEYXRhTnVsbCAmJiBiYW5uZXJJbmZvICE9PSBudWxsICYmICFjb3Vwb24pIHtcbiAgICAgICAgICAgICAgICAgICAgICAgICRkYXRhLmJhbm5lckluZm9zID0gSlNPTi5zdHJpbmdpZnkoYmFubmVyRGF0YS5jb25jYXQoYmFubmVySW5mbykpO1xuICAgICAgICAgICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICAgICAgJGRhdGEuYmFubmVySW5mb3MgPSBKU09OLnN0cmluZ2lmeShiYW5uZXJEYXRhKTtcbiAgICAgICAgICAgICAgICAgICAgfVxuXG4gICAgICAgICAgICAgICAgfSBlbHNlIGlmICgkZGF0YS5hc3NldExldmVsID09PSAzICYmIGJhbm5lckluZm8gIT09IG51bGwgJiYgIWNvdXBvbikge1xuICAgICAgICAgICAgICAgICAgICAkZGF0YS5iYW5uZXJJbmZvcyA9IEpTT04uc3RyaW5naWZ5KFtiYW5uZXJJbmZvXSk7XG4gICAgICAgICAgICAgICAgfSBlbHNlIGlmICgkZGF0YS5hc3NldExldmVsID09PSAzICYmICFiYW5uZXJEYXRhTnVsbCAmJiBjb3Vwb24pIHtcbiAgICAgICAgICAgICAgICAgICAgJGRhdGEuYmFubmVySW5mb3MgPSBKU09OLnN0cmluZ2lmeShiYW5uZXJEYXRhKTtcbiAgICAgICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICAkZGF0YS5zaG93UmVjb21tZW5kID0gJ2dvbmUnO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgICAgICAkZGF0YS5hc3NldEJhbm5lckluZm9GaW5pc2hlZCA9ICcxJztcbiAgICAgICAgICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgICAgICAgICAkZGF0YS5zaG93UmVjb21tZW5kID0gJ2dvbmUnO1xuICAgICAgICAgICAgICAgICRkYXRhLmFzc2V0QmFubmVySW5mb0ZpbmlzaGVkID0gJzEnO1xuICAgICAgICAgICAgfVxuICAgICAgICB9XG4gICAgICAgIGlmIChpc0hpZGRlbikge1xuICAgICAgICAgICAgJGRhdGEuYXNzZXRUb3RhbCA9IEhJRERFTl9TVFI7XG4gICAgICAgICAgICAkZGF0YS5hc3NldFRvYWR5UHJvZml0ID0gSElEREVOX1NUUjtcbiAgICAgICAgICAgICRkYXRhLmFzc2V0VG9hZHlQcm9maXRSYXRlID0gJyc7XG4gICAgICAgICAgICAkZGF0YS5hc3NldFRvdGFsUHJvZml0ID0gSElEREVOX1NUUjtcbiAgICAgICAgICAgICRkYXRhLnRvdGFsQXNzZXQgPSBISURERU5fU1RSO1xuICAgICAgICAgICAgJGRhdGEudG9kYXlQbE51bWJlciA9IEhJRERFTl9TVFI7XG4gICAgICAgICAgICAkZGF0YS5yb2NrZXRBbW91bnQgPSBISURERU5fU1RSO1xuICAgICAgICAgICAgJGRhdGEudG90YWxCYWxhbmNlRGF0YSA9IChkYXRhLmN1cnJlbmN5TnVtICYmIGRhdGEuYXNzZXRMZXZlbCAhPSAwKSA/IDEgOiAwO1xuICAgICAgICAgICAgcmV0dXJuO1xuICAgICAgICB9XG4gICAgICAgIGNvbnN0IGN1cnJlbmN5ID0gYXdhaXQgZ2V0VG90YWxBc3NldEN1cnJlbmN5KCk7XG4gICAgICAgIGNvbnN0IGxlZ2FsQ3VycmVuY3lTeW1ib2wgPSBhd2FpdCBnZXRMZWdhbEN1cnJlbmN5U3ltYm9sKCk7XG4gICAgICAgIGNvbnNvbGUubG9nKGB0b3RhbCAke2RhdGEudG90YWxCYWxhbmNlVXNkdH0gY3VycmVuY3kgJHtjdXJyZW5jeX1gKTtcbiAgICAgICAgY29uc3QgbGVnYWxDdXJyZW5jeVRvdGFsID0gYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50SGFuZGxlTnVsbChTeW1ib2xzLnVzZHQsIGRhdGEudG90YWxCYWxhbmNlVXNkdCk7XG4gICAgICAgICRkYXRhLmFzc2V0VG90YWwgPSBsZWdhbEN1cnJlbmN5VG90YWw7XG4gICAgICAgIGxldCBhc3NldFRvYWR5UHJvZml0O1xuICAgICAgICBpZiAoZGF0YS50b2RheVByb2ZpdCkge1xuICAgICAgICAgICAgJGRhdGEuYXNzZXRUb2FkeVByb2ZpdENvbG9yID0gaXNIaWRkZW4gPyBhd2FpdCBnZXRDb2xvcigna0NvbG9yU2Vjb25kYXJ5VGV4dCcpIDogYXdhaXQgcmlzZUNvbG9yKGRhdGEudG9kYXlQcm9maXQpO1xuICAgICAgICAgICAgaWYgKGRhdGEudG9kYXlQcm9maXQgPiAwKSB7XG4gICAgICAgICAgICAgICAgYXNzZXRUb2FkeVByb2ZpdCA9IGArJHthZGRDdXJyZW5jeVN5bWJvbChhd2FpdCBnZXRMZWdhbEN1cnJlbmN5U3ltYm9sKCksIGF3YWl0IGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudEhhbmRsZU51bGwoU3ltYm9scy51c2R0LCBkYXRhLnRvZGF5UHJvZml0KSl9YDtcbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgYXNzZXRUb2FkeVByb2ZpdCA9IGFkZEN1cnJlbmN5U3ltYm9sKGF3YWl0IGdldExlZ2FsQ3VycmVuY3lTeW1ib2woKSwgYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50SGFuZGxlTnVsbChTeW1ib2xzLnVzZHQsIGRhdGEudG9kYXlQcm9maXQpKTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICRkYXRhLmFzc2V0VG9hZHlQcm9maXRDb2xvciA9IGF3YWl0IGdldENvbG9yKCdrQ29sb3JTZWNvbmRhcnlUZXh0Jyk7XG4gICAgICAgICAgICBhc3NldFRvYWR5UHJvZml0ID0gJy0tJztcbiAgICAgICAgfVxuICAgICAgICAkZGF0YS5hc3NldFRvYWR5UHJvZml0ID0gYXNzZXRUb2FkeVByb2ZpdDtcbiAgICAgICAgJGRhdGEuYXNzZXRUb2FkeVByb2ZpdFJhdGUgPSBgLyR7Zml4UmF0ZUhhbmRsZU51bGwoZGF0YS50b2RheVByb2ZpdFJhdGUpfWA7XG4gICAgICAgIGlmIChkYXRhLnRvZGF5UHJvZml0U3RhdGUgIT09IDEpIHtcbiAgICAgICAgICAgICRkYXRhLmFzc2V0VG9hZHlQcm9maXQgPSAnLS0nO1xuICAgICAgICAgICAgJGRhdGEuYXNzZXRUb2FkeVByb2ZpdFJhdGUgPSAnJztcbiAgICAgICAgfVxuICAgICAgICAkZGF0YS5yb2NrZXRBbW91bnQgPSBjYWNoZURhdGEucm9ja2V0QW1vdW50ID8gY2FjaGVEYXRhLnJvY2tldEFtb3VudCA6ICctLSc7XG4gICAgICAgICRkYXRhLmFzc2V0VG90YWxQcm9maXQgPSBkYXRhLnRvdGFsQWNjdW11bGF0ZVByb2ZpdFVzZHQgPyBhZGRDdXJyZW5jeVN5bWJvbChhd2FpdCBnZXRMZWdhbEN1cnJlbmN5U3ltYm9sKCksIGF3YWl0IGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudEhhbmRsZU51bGwoU3ltYm9scy51c2R0LCBkYXRhLnRvdGFsQWNjdW11bGF0ZVByb2ZpdFVzZHQpKSA6ICctLSc7XG4gICAgICAgICRkYXRhLnRvdGFsQmFsYW5jZURhdGEgPSAoZGF0YS5jdXJyZW5jeU51bSAmJiBkYXRhLmFzc2V0TGV2ZWwgIT0gMCkgPyAxIDogMDtcbiAgICAgICAgY29uc3QgbGFuZyA9IGF3YWl0ICRuYXRpdmVBUEkuY3VycmVuY3lDb21tb24oJ3tcInR5cGVcIjo3MH0nKTtcbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUuZXJyb3IoVEFHLCBgdXBkYXRlVG90YWxBc3NldERhdGEsICR7ZX1gKTtcbiAgICAgICAgJGRhdGEuc2hvd1JlY29tbWVuZCA9ICdnb25lJztcbiAgICAgICAgJGRhdGEuYXNzZXRCYW5uZXJJbmZvRmluaXNoZWQgPSAnMSc7XG4gICAgICAgICRkYXRhLnRvdGFsRXJyb3IgPSBgJHtlfWA7XG4gICAgfVxufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gdXBkYXRlQWNjb3VudExpc3QoZGF0YSkge1xuICAgIGNvbnN0IHByb2ZpdEFjY291bnRCYWxhbmNlTGlzdCA9IGRhdGEuYWNjb3VudEJhbGFuY2VMaXN0ID8gSlNPTi5zdHJpbmdpZnkoZGF0YS5hY2NvdW50QmFsYW5jZUxpc3QpIDogJ1tdJztcbiAgICAkZGF0YS5wcm9maXRBY2NvdW50QmFsYW5jZUxpc3QgPSBwcm9maXRBY2NvdW50QmFsYW5jZUxpc3Q7XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiB1cGRhdGVCb3RCYXNlSW5mb0RhdGEoZGF0YSkge1xuICAgIGNvbnNvbGUubG9nKGB1cGRhdGVCb3RCYXNlSW5mb0RhdGEgJHtpc0hpZGRlbn1gKTtcbiAgICBpZiAoaXNIaWRkZW4pIHtcbiAgICAgICAgJGRhdGEuYm90VG90YWxBc3NldCA9IEhJRERFTl9TVFI7XG4gICAgICAgICRkYXRhLmJvdFRvZGF5UGxOdW1iZXIgPSBISURERU5fU1RSO1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIHRyeSB7XG4gICAgICAgIGNvbnN0IGxlZ2FsQ3VycmVuY3lTeW1ib2wgPSBhd2FpdCBnZXRMZWdhbEN1cnJlbmN5U3ltYm9sKCk7XG4gICAgICAgIGNvbnN0IGVxdWFsQW1vdW50ID0gYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50SGFuZGxlTnVsbChTeW1ib2xzLnVzZHQsIGRhdGEuYmFsYW5jZSk7XG4gICAgICAgICRkYXRhLmJvdFRvdGFsQXNzZXQgPSBhZGRDdXJyZW5jeVN5bWJvbFRvdGFsQXNzZXQobGVnYWxDdXJyZW5jeVN5bWJvbCwgYXdhaXQgZm9ybWF0TnVtKGVxdWFsQW1vdW50KSk7XG4gICAgICAgIGNvbnN0IHRvZGF5UHJvZml0ID0gYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50SGFuZGxlTnVsbChTeW1ib2xzLnVzZHQsIGRhdGEudG9kYXlQcm9maXQpO1xuICAgICAgICBjb25zdCB0b2RheVByb2ZpdFdpdGhTeW1ib2wgPSBhZGRDdXJyZW5jeVN5bWJvbChsZWdhbEN1cnJlbmN5U3ltYm9sLCB0b2RheVByb2ZpdCk7XG4gICAgICAgICRkYXRhLmJvdFRvZGF5UGxOdW1iZXIgPSBgJHt0b2RheVByb2ZpdFdpdGhTeW1ib2x9LyR7Zml4UmF0ZUhhbmRsZU51bGwoZGF0YS50b2RheVByb2ZpdFJhdGUpfWA7XG4gICAgICAgICRkYXRhLmJvdFRvZGF5UGxOdW1iZXJDb2xvciA9IGlzSGlkZGVuID8gYXdhaXQgZ2V0Q29sb3IoJ2tDb2xvclNlY29uZGFyeVRleHQnKSA6IGF3YWl0IHJpc2VDb2xvcihkYXRhLnRvZGF5UHJvZml0KTtcbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUuZXJyb3IoYHVwZGF0ZUJvdEJhc2VJbmZvRGF0YSAke2V9YCk7XG4gICAgfVxuXG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiB1cGRhdGVTcG90QmFzZUluZm9EYXRhKGRhdGEpIHtcbiAgICBpZiAoZGF0YS5zcG90Umlza0xldmVsID09IDApIHtcbiAgICAgICAgY29uc3QgdGV4dCA9IGF3YWl0IGdldFdvcmQoXCJuX3Nwb3RfYWNjb3VudF9ub19yaXNrXCIpO1xuICAgICAgICAkZGF0YS5yaXNrVGV4dCA9IHRleHQ7XG4gICAgICAgICRkYXRhLnJpc2tJY29uU2hvdyA9ICdnb25lJztcbiAgICAgICAgJGRhdGEucmlza1RleHRDb2xvciA9IGF3YWl0IGdldENvbG9yKCd0cmFkZV90YWdfdGV4dF9jb2xvcicpO1xuICAgICAgICAkZGF0YS5yaXNrQmFja2dyb3VuZCA9IGF3YWl0IGdldENvbG9yKCd0cmFkZV90YWdfdGV4dF9iZycpO1xuICAgIH0gZWxzZSBpZiAoZGF0YS5zcG90Umlza0xldmVsID09IDEpIHtcbiAgICAgICAgY29uc3QgdGV4dCA9IGF3YWl0IGdldFdvcmQoXCJuX3Nwb3Rfb3JkZXJfbGl0dGxlX3Jpc2tcIik7XG4gICAgICAgICRkYXRhLnJpc2tUZXh0ID0gYCR7ZGF0YS5zcG90Umlza1JhdGV9JSAke3RleHR9YDtcbiAgICAgICAgJGRhdGEucmlza0ljb24gPSAnYXNzZXRfc3BvdF9sb3dfcmlzayc7XG4gICAgICAgIGNvbnN0IHJpc2tUZXh0Q29sb3IgPSBhd2FpdCBnZXRDb2xvcignS0Jhc2VSaXNrVGV4dENvbG9yTG93Jyk7XG4gICAgICAgIGNvbnNvbGUubG9nKHJpc2tUZXh0Q29sb3IpO1xuICAgICAgICAkZGF0YS5yaXNrVGV4dENvbG9yID0gcmlza1RleHRDb2xvcjtcbiAgICAgICAgJGRhdGEucmlza0ljb25TaG93ID0gJ3Zpc2libGUnO1xuICAgIH0gZWxzZSBpZiAoZGF0YS5zcG90Umlza0xldmVsID09IDIpIHtcbiAgICAgICAgY29uc3QgdGV4dCA9IGF3YWl0IGdldFdvcmQoXCJuX3Nwb3Rfb3JkZXJfbWlkZGxlX3Jpc2tcIik7XG4gICAgICAgICRkYXRhLnJpc2tUZXh0ID0gYCR7ZGF0YS5zcG90Umlza1JhdGV9JSAke3RleHR9YDtcbiAgICAgICAgJGRhdGEucmlza0ljb24gPSAnYXNzZXRfc3BvdF9taWRfcmlzayc7XG4gICAgICAgICRkYXRhLnJpc2tUZXh0Q29sb3IgPSBhd2FpdCBnZXRDb2xvcignS0Jhc2VSaXNrVGV4dENvbG9yTWlkJyk7XG4gICAgICAgICRkYXRhLnJpc2tJY29uU2hvdyA9ICd2aXNpYmxlJztcbiAgICB9IGVsc2UgaWYgKGRhdGEuc3BvdFJpc2tMZXZlbCA9PSAzKSB7XG4gICAgICAgIGNvbnN0IHRleHQgPSBhd2FpdCBnZXRXb3JkKFwibl9zcG90X29yZGVyX2hpZ2hfcmlza1wiKTtcbiAgICAgICAgJGRhdGEucmlza1RleHQgPSBgJHtkYXRhLnNwb3RSaXNrUmF0ZX0lICR7dGV4dH1gO1xuICAgICAgICAkZGF0YS5yaXNrSWNvbiA9ICdhc3NldF9zcG90X2hpZ2hfcmlzayc7XG4gICAgICAgICRkYXRhLnJpc2tUZXh0Q29sb3IgPSBhd2FpdCBnZXRDb2xvcignS0Jhc2VSaXNrVGV4dENvbG9ySGlnaCcpO1xuICAgICAgICAkZGF0YS5yaXNrSWNvblNob3cgPSAndmlzaWJsZSc7XG4gICAgfSBlbHNlIGlmIChkYXRhLnNwb3RSaXNrTGV2ZWwgPT0gNCkge1xuICAgICAgICBjb25zdCB0ZXh0ID0gYXdhaXQgZ2V0V29yZChcIm5fc3BvdF9vcmRlcl92ZXJ5X2hpZ2hfcmlza1wiKTtcbiAgICAgICAgY29uc29sZS5sb2coYHRleHQgJHt0ZXh0fWApO1xuICAgICAgICAkZGF0YS5yaXNrVGV4dCA9IGAke2RhdGEuc3BvdFJpc2tSYXRlfSUgJHt0ZXh0fWA7XG4gICAgICAgICRkYXRhLnJpc2tJY29uID0gJ2Fzc2V0X3Nwb3RfdmVyeV9oaWdoX3Jpc2snO1xuICAgICAgICAkZGF0YS5yaXNrVGV4dENvbG9yID0gYXdhaXQgZ2V0Q29sb3IoJ0tCYXNlUmlza1RleHRDb2xvckhpZ2gnKTtcbiAgICAgICAgJGRhdGEucmlza0ljb25TaG93ID0gJ3Zpc2libGUnO1xuICAgIH0gZWxzZSBpZiAoZGF0YS5zcG90Umlza0xldmVsID09IDUpIHtcbiAgICAgICAgY29uc3QgdGV4dCA9IGF3YWl0IGdldFdvcmQoXCJuX2Fzc2V0X3liYl9sb2NrXCIpO1xuICAgICAgICAkZGF0YS5yaXNrVGV4dCA9IHRleHQ7XG4gICAgICAgICRkYXRhLnJpc2tJY29uU2hvdyA9ICdnb25lJztcbiAgICAgICAgJGRhdGEucmlza1RleHRDb2xvciA9IGF3YWl0IGdldENvbG9yKCdiYXNlQ29pbkxvY2tUaXAnKTtcbiAgICAgICAgJGRhdGEucmlza0JhY2tncm91bmQgPSBhd2FpdCBnZXRDb2xvcignYmFzZUNvaW5Mb2NrVGlwQmcnKTtcbiAgICB9IGVsc2UgaWYgKGRhdGEuc3BvdFJpc2tMZXZlbCA9PSA2KSB7XG4gICAgICAgIGNvbnN0IHRleHQgPSBhd2FpdCBnZXRXb3JkKFwibl9zcG90X2JsYXN0X2Ffc3RvcmVob3VzZVwiKTtcbiAgICAgICAgJGRhdGEucmlza1RleHQgPSB0ZXh0O1xuICAgICAgICAkZGF0YS5yaXNrSWNvblNob3cgPSAnZ29uZSc7XG4gICAgICAgICRkYXRhLnJpc2tUZXh0Q29sb3IgPSBhd2FpdCBnZXRDb2xvcigndHJhZGVfc3RfY29sb3InKTtcbiAgICAgICAgJGRhdGEucmlza0JhY2tncm91bmQgPSBhd2FpdCBnZXRDb2xvcigndHJhZGVfc3RfY29sb3JfYmcnKTtcbiAgICB9IGVsc2UgaWYgKGRhdGEuc3BvdFJpc2tMZXZlbCA9PSA3KSB7XG4gICAgICAgIGNvbnN0IHRleHQgPSBhd2FpdCBnZXRXb3JkKFwibl9zcG90X3dlYXJfYV9zdG9yZWhvdXNlXCIpO1xuICAgICAgICAkZGF0YS5yaXNrVGV4dCA9IHRleHQ7XG4gICAgICAgICRkYXRhLnJpc2tJY29uU2hvdyA9ICdnb25lJztcbiAgICAgICAgJGRhdGEucmlza1RleHRDb2xvciA9IGF3YWl0IGdldENvbG9yKCd0cmFkZV9zdF9jb2xvcicpO1xuICAgICAgICAkZGF0YS5yaXNrQmFja2dyb3VuZCA9IGF3YWl0IGdldENvbG9yKCd0cmFkZV9zdF9jb2xvcl9iZycpO1xuICAgIH0gZWxzZSB7XG4gICAgICAgICRkYXRhLnJpc2tUZXh0ID0gJyc7XG4gICAgICAgICRkYXRhLnJpc2tJY29uU2hvdyA9ICdnb25lJztcbiAgICB9XG4gICAgY29uc29sZS5sb2coYHVwZGF0ZVNwb3RCYXNlSW5mb0RhdGEgJHtpc0hpZGRlbn1gKTtcbiAgICBpZiAoaXNIaWRkZW4pIHtcbiAgICAgICAgY29uc29sZS5sb2coYHVwZGF0ZVNwb3RCYXNlSW5mb0RhdGEgaW50byAke2lzSGlkZGVufWApO1xuICAgICAgICAkZGF0YS50b3RhbEFzc2V0ID0gSElEREVOX1NUUjtcbiAgICAgICAgJGRhdGEudG9kYXlQbE51bWJlciA9IEhJRERFTl9TVFI7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgY29uc3QgbGVnYWxDdXJyZW5jeVN5bWJvbCA9IGF3YWl0IGdldExlZ2FsQ3VycmVuY3lTeW1ib2woKTtcbiAgICBjb25zdCBlcXVhbEFtb3VudCA9IGF3YWl0IGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudEhhbmRsZU51bGwoU3ltYm9scy51c2R0LCBkYXRhLmJhbGFuY2UpO1xuICAgICRkYXRhLnRvdGFsQXNzZXQgPSBhZGRDdXJyZW5jeVN5bWJvbFRvdGFsQXNzZXQobGVnYWxDdXJyZW5jeVN5bWJvbCwgYXdhaXQgZm9ybWF0TnVtKGVxdWFsQW1vdW50KSk7XG5cbiAgICBjb25zdCB0b2RheVByb2ZpdCA9IGF3YWl0IGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudEhhbmRsZU51bGwoU3ltYm9scy51c2R0LCBkYXRhLnRvZGF5UHJvZml0KTtcbiAgICBjb25zdCB0b2RheVByb2ZpdFdpdGhTeW1ib2wgPSBhZGRDdXJyZW5jeVN5bWJvbChsZWdhbEN1cnJlbmN5U3ltYm9sLCB0b2RheVByb2ZpdCk7XG4gICAgJGRhdGEudG9kYXlQbE51bWJlciA9IGAke3Byb2ZpdFByZWZpeChkYXRhLnRvZGF5UHJvZml0KX0ke3RvZGF5UHJvZml0V2l0aFN5bWJvbH0vJHtmaXhSYXRlSGFuZGxlTnVsbChkYXRhLnRvZGF5UHJvZml0UmF0ZSl9YDtcbiAgICAkZGF0YS50b2RheVBsTnVtYmVyQ29sb3IgPSBpc0hpZGRlbiA/IGF3YWl0IGdldENvbG9yKCdrQ29sb3JTZWNvbmRhcnlUZXh0JykgOiBhd2FpdCByaXNlQ29sb3IoZGF0YS50b2RheVByb2ZpdCk7XG4gICAgaWYgKHRvZGF5UHJvZml0U3RhdGUgIT09IDEpIHtcbiAgICAgICAgJGRhdGEudG9kYXlQbE51bWJlciA9ICctLSc7XG4gICAgfVxufVxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHVwZGF0ZUJvdEN1cnJlbmNpZXNEYXRhKGxpc3QpIHtcbiAgICB0cnkge1xuICAgICAgICBjb25zdCBzcG90Q3VycmVuY3lEYXRhID0gYXdhaXQgc29ydEJvdExpc3QobGlzdCk7XG4gICAgICAgIGNvbnN0IGN1cnJlbmN5U3ltYm9sID0gYXdhaXQgZ2V0TGVnYWxDdXJyZW5jeVN5bWJvbCgpO1xuICAgICAgICBjYWNoZURhdGEuc3BvdC5ib3QubmV3TGlzdCA9IHNwb3RDdXJyZW5jeURhdGE7XG4gICAgICAgIGNvbnN0IGN1cnJlbmNpZXMgPSBhd2FpdCBQcm9taXNlLmFsbChzcG90Q3VycmVuY3lEYXRhLm1hcChhc3luYyAoaXRlbSkgPT4ge1xuICAgICAgICAgICAgdHJ5IHtcbiAgICAgICAgICAgICAgICBjb25zdCBzeW1ib2xJY29uID0gYXdhaXQgZ2V0SWNvblVybChpdGVtLmJhc2VDdXJyZW5jeSk7XG4gICAgICAgICAgICAgICAgY29uc3Qgc3ltYm9sTmFtZSA9IGAke2l0ZW0uc3ltYm9sVHJhbnNsYXRlTmFtZX1gO1xuICAgICAgICAgICAgICAgIGNvbnN0IGNvc3QgPSBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBhd2FpdCBhZGRDdXJyZW50Q3VycmVuY3lTeW1ib2woYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50KFN5bWJvbHMudXNkdCwgaXRlbS5pbnZlc3RBbW91bnQpKTtcbiAgICAgICAgICAgICAgICBjb25zdCBlcXVhbFRvZGF5UHJvZml0ID0gaXNIaWRkZW4gPyBISURERU5fU1RSIDogYXdhaXQgY29udmVydExlZ2FsVGVuZGVyKFN5bWJvbHMudXNkdCwgaXRlbS50b3RhbFByb2ZpdCwgMik7XG4gICAgICAgICAgICAgICAgY29uc3Qgb3JpZ2luU3BvdFlpZWxkID0gYWRkQ3VycmVuY3lTeW1ib2woY3VycmVuY3lTeW1ib2wsIGVxdWFsVG9kYXlQcm9maXQpO1xuICAgICAgICAgICAgICAgIGNvbnN0IHNwb3RZaWVsZCA9IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGAke2l0ZW0udG90YWxQcm9maXQgPj0gMCA/ICcrJyA6ICcnfSR7b3JpZ2luU3BvdFlpZWxkfWA7XG4gICAgICAgICAgICAgICAgY29uc3Qgb3JpZ2luU3BvdFJhdGUgPSBmaXhSYXRlKGl0ZW0udG90YWxQcm9maXRSYXRlKTtcbiAgICAgICAgICAgICAgICBjb25zdCBzcG90WWllbGRSYXRlID0gaXNIaWRkZW4gPyBISURERU5fU1RSIDogYCR7aXRlbS50b3RhbFByb2ZpdFJhdGUgPj0gMCA/ICcrJyA6ICcnfSR7b3JpZ2luU3BvdFJhdGV9YDtcbiAgICAgICAgICAgICAgICBjb25zdCBzcG90UmlzZUNvbG9yID0gaXNIaWRkZW4gPyBhd2FpdCBnZXRDb2xvcigna0NvbG9yU2Vjb25kYXJ5VGV4dCcpIDogYXdhaXQgcmlzZUNvbG9yKGl0ZW0udG90YWxQcm9maXQpO1xuICAgICAgICAgICAgICAgIC8vIGNvbnN0IHN0cmF0ZWd5ID0gYXdhaXQgZ2V0V29yZCgnbl9ncmlkX2dyaWRfc3RyYXRlZ3knKTtcbiAgICAgICAgICAgICAgICBjb25zdCBzcG90TG9hbiA9IGl0ZW0ucnVuVHlwZVRyYW5zbGF0ZU5hbWU7XG4gICAgICAgICAgICAgICAgcmV0dXJuIHtcbiAgICAgICAgICAgICAgICAgICAgc3ltYm9sSWNvbixcbiAgICAgICAgICAgICAgICAgICAgc3ltYm9sTmFtZSxcbiAgICAgICAgICAgICAgICAgICAgY29zdCxcbiAgICAgICAgICAgICAgICAgICAgc3BvdFlpZWxkLFxuICAgICAgICAgICAgICAgICAgICBzcG90WWllbGRSYXRlLFxuICAgICAgICAgICAgICAgICAgICBzcG90TG9hbixcbiAgICAgICAgICAgICAgICAgICAgc3BvdFJpc2VDb2xvclxuICAgICAgICAgICAgICAgIH07XG4gICAgICAgICAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgICAgICAgICAgY29uc29sZS5lcnJvcihgc3BvdEN1cnJlbmN5RGF0YS5tYXAgJHtlfWApO1xuICAgICAgICAgICAgICAgIHJldHVybiB7fTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfSkpO1xuICAgICAgICAkZGF0YS5ib3RMaXN0ID0gSlNPTi5zdHJpbmdpZnkoY3VycmVuY2llcyk7XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICBjb25zb2xlLmVycm9yKGB1cGRhdGVCb3RDdXJyZW5jaWVzRGF0YSAke2V9YCk7XG4gICAgfVxufVxuXG52YXIgY3VycmVudFNwb3RMaXN0O1xuLy/lvZPliY3lsZXlvIDnmoTnjrDotKfluIHnp41cbnZhciBjdXJyZW50U3BvdEV4cGFuZEN1cnJlbmN5O1xuLy/mjIfmlbDku7dtYXBcbnZhciBpbmRleFByaWNlTWFwID0ge307XG4vL2ZvcmNlUmVmcmVzaEZsYWcgICAwOiDlvLrliLbliLfmlrBcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiB1cGRhdGVTcG90Q3VycmVuY2llc0RhdGEobGlzdCwgZm9yY2VSZWZyZXNoRmxhZyA9IDEpIHtcbiAgICB0cnkge1xuICAgICAgICBpZiAoIWxpc3QpIHtcbiAgICAgICAgICAgIHJldHVybjtcbiAgICAgICAgfVxuICAgICAgICBjb25zdCBzdGFydFRpbWUgPSBEYXRlLm5vdygpO1xuICAgICAgICAvL3x8IEpTT04uc3RyaW5naWZ5KGxpc3QpID09IEpTT04uc3RyaW5naWZ5KGN1cnJlbnRTcG90TGlzdClcbiAgICAgICAgaWYgKChzdGFydFRpbWUgLSBlbmRUaW1lKSA8IDUwMCB8fCAoSlNPTi5zdHJpbmdpZnkobGlzdCkgPT0gSlNPTi5zdHJpbmdpZnkoY3VycmVudFNwb3RMaXN0KSAmJiBmb3JjZVJlZnJlc2hGbGFnICE9IDApKSB7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgc3BvdEFsbENvaW5Mb2dUYWcg6aKR57mB6LCD55So5oum5oiqIGApO1xuICAgICAgICAgICAgLy8g5L+u5aSN5pCc57Si5LiN5Yi35pawXG4gICAgICAgICAgICBpZiAoY2FjaGVEYXRhLnNwb3Quc3BvdC5zZWFyY2hLZXkgIT0gY2FjaGVEYXRhLnNwb3Quc3BvdC5sYXN0U2VhcmNoS2V5KSB7XG4gICAgICAgICAgICAgIHNldFRpbWVvdXQoKCkgPT4ge1xuICAgICAgICAgICAgICAgIHVwZGF0ZVNwb3RDdXJyZW5jaWVzRGF0YShjYWNoZURhdGEuc3BvdC5zcG90LmN1cnJlbmNpZXMsIGZvcmNlUmVmcmVzaEZsYWcpO1xuICAgICAgICAgICAgICB9LCA1MDApO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgcmV0dXJuO1xuICAgICAgICB9XG4gICAgICAgIGNhY2hlRGF0YS5zcG90LnNwb3QubGFzdFNlYXJjaEtleSA9IGNhY2hlRGF0YS5zcG90LnNwb3Quc2VhcmNoS2V5O1xuICAgICAgICBjdXJyZW50U3BvdExpc3QgPSBsaXN0O1xuICAgICAgICAvKipcbiAgICAgICAgICog5pCc57Si6L+H5ruk77yM6ZqQ6JeP5bCP6aKd6LWE5Lqn77yMbWVyYWdl5YWo5biB56eN77yM5o6S5bqPIOaJk+WMheS6pOe7meWOn+eUn+WkhOeQhlxuICAgICAgICAgKiB2YXIgc29ydFR5cGUgPSAwO1xuICAgICAgICAgICB2YXIgc29ydFNlcXVlbmNlID0gMDtcbiAgICAgICAgICovXG4gICAgICAgIGNvbnNvbGUubG9nKGBpbmRleFByaWNlTWFwIDogJHtKU09OLnN0cmluZ2lmeShpbmRleFByaWNlTWFwKX1gKVxuICAgICAgICB2YXIgaW5kZXhQcmljZSA9IGluZGV4UHJpY2VNYXBbYCR7Y3VycmVudFNwb3RFeHBhbmRDdXJyZW5jeX1gXVxuICAgICAgICBjb25zdCBlZGdlRW5naW5lRGF0YVBhY2thZ2UgPSB7XG4gICAgICAgICAgICAvL+aQnOe0ouWFs+mUruWtl1xuICAgICAgICAgICAgc2VhcmNoS2V5OiBjYWNoZURhdGEuc3BvdC5zcG90LnNlYXJjaEtleSxcbiAgICAgICAgICAgIC8v5piv5ZCm5omT5byA5LqG5bCP6aKd6LWE5LqnXG4gICAgICAgICAgICBoaWRkZW5TbWFsbEFzc2V0OiBjYWNoZURhdGEuc3BvdC5zcG90LmhpZGRlblNtYWxsQXNzZXQsXG4gICAgICAgICAgICAvL+aMgeS7k+aVsOaNrlxuICAgICAgICAgICAgc3BvdExpc3Q6IGxpc3QsXG4gICAgICAgICAgICAvL+aOkuW6j+exu+Wei1xuICAgICAgICAgICAgc29ydFR5cGU6IHNvcnRUeXBlLFxuICAgICAgICAgICAgLy/mjpLluo/op4TliJlcbiAgICAgICAgICAgIHNvcnRTZXF1ZW5jZTogc29ydFNlcXVlbmNlLFxuICAgICAgICAgICAgLy/lvZPliY3lsZXlvIDnmoTluIHnp40g5LiOIOaMh+aVsOS7ty/nsr7luqZcbiAgICAgICAgICAgIGluZGV4UHJpY2U6IGluZGV4UHJpY2VcbiAgICAgICAgfVxuICAgICAgICBjb25zdCBvcmlnaW5Db252ZXJ0SnNvbiA9IGF3YWl0ICRuYXRpdmVBUEkuY3VycmVuY3lDb21tb24oSlNPTi5zdHJpbmdpZnkoeyB0eXBlOiAxMDAsIHBhcmFtZXRlcjogZWRnZUVuZ2luZURhdGFQYWNrYWdlIH0pKTtcbiAgICAgICAgY29uc29sZS5sb2coYGVkZ2VFbmdpbmVEYXRhUGFja2FnZSAgaXRlbU5ldyA6ICR7b3JpZ2luQ29udmVydEpzb259YCk7XG4gICAgICAgIC8qKlxuICAgICAgICAgKiB7XG4gICAgICAgICAqICAgIGNvbG9yTW9kZSA6IFwiXCIsXG4gICAgICAgICAqICAgIGN1cnJlbmN5U3ltYm9sIDogXCJcIixcbiAgICAgICAgICogICAgc3BvdExpc3QgOiBbXSxcbiAgICAgICAgICogfVxuICAgICAgICAgKi9cbiAgICAgICAgY29uc3Qgb3JpZ2luQ29udmVydExpc3QgPSBKU09OLnBhcnNlKG9yaWdpbkNvbnZlcnRKc29uKTtcbiAgICAgICAgY2FjaGVEYXRhLnNwb3Quc3BvdC5uZXdMaXN0ID0gb3JpZ2luQ29udmVydExpc3Quc3BvdExpc3Q7XG4gICAgICAgIGNvbnN0IHNwb3RMaXN0TmV3ID0gYXdhaXQgUHJvbWlzZS5hbGwob3JpZ2luQ29udmVydExpc3Quc3BvdExpc3QubWFwKGFzeW5jIChpdGVtKSA9PiB7XG4gICAgICAgICAgICB0cnkge1xuXG4gICAgICAgICAgICAgICAgY29uc3Qgc3ltYm9sSWNvbiA9IGl0ZW0uc3ltYm9sSWNvbjtcbiAgICAgICAgICAgICAgICBjb25zdCBzeW1ib2xOYW1lID0gaXRlbS5kaXNwbGF5TmFtZS50b1VwcGVyQ2FzZSgpO1xuICAgICAgICAgICAgICAgIGNvbnN0IGlzTG9hbiA9IGNoZWNrRmllbGQoaXRlbS5hdmFpbGFibGVOdW0sIDApIDwgMCA/ICd2aXNpYmxlJyA6ICdnb25lJztcbiAgICAgICAgICAgICAgICBjb25zdCBlcXVhbEFtb3VudCA9IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGNoZWNrRmllbGQoaXRlbS5lcXVhbEFtb3VudCwgXCIwLjAwXCIpO1xuICAgICAgICAgICAgICAgIGNvbnN0IHNwb3ROdW1iZXJFcXVpdmFsZW50ID0gaXNIaWRkZW4gPyBISURERU5fU1RSIDogYWRkQ3VycmVuY3lTeW1ib2wob3JpZ2luQ29udmVydExpc3QuY3VycmVuY3lTeW1ib2wsIGVxdWFsQW1vdW50KTtcbiAgICAgICAgICAgICAgICBjb25zdCBzcG90TnVtYmVyID0gaXNIaWRkZW4gPyBISURERU5fU1RSIDogY2hlY2tGaWVsZChpdGVtLnBvc2l0aW9uTnVtRGlzcGxheU5hbWVOZXcsIFwiMC4wMFwiKTtcbiAgICAgICAgICAgICAgICBjb25zdCBlcXVhbFRvZGF5UHJvZml0ID0gaXNIaWRkZW4gPyBISURERU5fU1RSIDogY2hlY2tGaWVsZChpdGVtLmVxdWFsVG9kYXlQcm9maXQsIFwiMC4wMFwiKTtcbiAgICAgICAgICAgICAgICBjb25zdCBvcmlnaW5TcG90WWllbGQgPSBhZGRDdXJyZW5jeVN5bWJvbChvcmlnaW5Db252ZXJ0TGlzdC5jdXJyZW5jeVN5bWJvbCwgZXF1YWxUb2RheVByb2ZpdCk7XG4gICAgICAgICAgICAgICAgdmFyIHNwb3RZaWVsZCA9IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGAke2NoZWNrRmllbGQoaXRlbS50b2RheVByb2ZpdCwgbnVsbCkgPj0gMCA/ICcrJyA6ICcnfSR7b3JpZ2luU3BvdFlpZWxkfWA7XG4gICAgICAgICAgICAgICAgY29uc3Qgb3JpZ2luU3BvdFJhdGUgPSBmaXhSYXRlKGNoZWNrRmllbGQoaXRlbS50b2RheVByb2ZpdFJhdGUsIG51bGwpKTtcbiAgICAgICAgICAgICAgICB2YXIgc3BvdFlpZWxkUmF0ZSA9IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGAke2NoZWNrRmllbGQoaXRlbS50b2RheVByb2ZpdFJhdGUsIG51bGwpID49IDAgPyAnKycgOiAnJ30ke29yaWdpblNwb3RSYXRlfWA7XG4gICAgICAgICAgICAgICAgY29uc3Qgc3BvdEV4QXZhaWxhYmxlID0gaXNIaWRkZW4gPyBISURERU5fU1RSIDogY2hlY2tGaWVsZChpdGVtLnNwb3RFeEF2YWlsYWJsZSwgXCIwLjAwXCIpO1xuICAgICAgICAgICAgICAgIGNvbnN0IHNwb3RFeERlYnRzID0gaXNIaWRkZW4gPyBISURERU5fU1RSIDogY2hlY2tGaWVsZChpdGVtLnNwb3RFeERlYnRzLCBcIjAuMDBcIik7XG4gICAgICAgICAgICAgICAgY29uc3Qgc3BvdEV4UHJpY2UgPSBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBhZGRDdXJyZW5jeVN5bWJvbChvcmlnaW5Db252ZXJ0TGlzdC5jdXJyZW5jeVN5bWJvbCwgY2hlY2tGaWVsZChpdGVtLnNwb3RFeFByaWNlLCBcIjAuMDBcIikpO1xuICAgICAgICAgICAgICAgIGNvbnN0IGF2Z1Bvc2l0aW9uQ29zdCA9IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGFkZEN1cnJlbmN5U3ltYm9sKG9yaWdpbkNvbnZlcnRMaXN0LmN1cnJlbmN5U3ltYm9sLCBjaGVja0ZpZWxkKGl0ZW0uYXZnUG9zaXRpb25Db3N0UGFyYW0sIFwiMC4wMFwiKSk7XG4gICAgICAgICAgICAgICAgY29uc3Qgc3BvdEV4VG9wQ2VudGVyVGl0bGUgPSBjaGVja0ZpZWxkKGl0ZW0uYXZnUG9zaXRpb25Db3N0LCBudWxsKSA9PSBudWxsID8gJGkxOG4ubl9hc3NldF9wcmljZSA6ICRpMThuLm5fYXNzZXRfcHJpY2VfY29zdF9wcmljZTtcbiAgICAgICAgICAgICAgICBjb25zdCBhdmdQb3NpdGlvbkNvc3RTaG93ID0gY2hlY2tGaWVsZChpdGVtLmF2Z1Bvc2l0aW9uQ29zdCwgbnVsbCkgPT0gbnVsbCA/IFwiZ29uZVwiIDogXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAgY29uc3Qgc3BvdEV4Q29zdCA9IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGNoZWNrRmllbGQoaXRlbS5zcG90RXhDb3N0LCBcIjAuMDBcIik7XG4gICAgICAgICAgICAgICAgY29uc3Qgb3JpZ2luU3BvdEV4WWllbGQgPSBhZGRDdXJyZW5jeVN5bWJvbChvcmlnaW5Db252ZXJ0TGlzdC5jdXJyZW5jeVN5bWJvbCwgY2hlY2tGaWVsZChpdGVtLm9yaWdpblNwb3RFeFlpZWxkUGFyYW0sIFwiMC4wMFwiKSk7XG4gICAgICAgICAgICAgICAgY29uc3Qgc3BvdEV4WWllbGQgPSBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBgJHtjaGVja0ZpZWxkKGl0ZW0ucHJvZml0LCBudWxsKSA+PSAwID8gJysnIDogJyd9JHtvcmlnaW5TcG90RXhZaWVsZH1gO1xuICAgICAgICAgICAgICAgIGNvbnN0IG9yaWdpblNwb3RFeFlpZWxkUmF0ZSA9IGZpeFJhdGUoY2hlY2tGaWVsZChpdGVtLnByb2ZpdFJhdGUsIG51bGwpKTtcbiAgICAgICAgICAgICAgICBjb25zdCBzcG90RXhZaWVsZFJhdGUgPSBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBgJHtjaGVja0ZpZWxkKGl0ZW0ucHJvZml0UmF0ZSwgbnVsbCkgPj0gMCA/ICcrJyA6ICcnfSR7b3JpZ2luU3BvdEV4WWllbGRSYXRlfWA7XG4gICAgICAgICAgICAgICAgdmFyIHNwb3RSaXNlQ29sb3IgPSBpc0hpZGRlbiA/ICdAY29sb3Iva0NvbG9yU2Vjb25kYXJ5VGV4dCcgOiByaXNlQ29sb3JWMihjaGVja0ZpZWxkKGl0ZW0udG9kYXlQcm9maXRSYXRlLCBudWxsKSwgb3JpZ2luQ29udmVydExpc3QuY29sb3JNb2RlKTtcbiAgICAgICAgICAgICAgICBjb25zdCBzcG90RXhSaXNlQ29sb3IgPSBpc0hpZGRlbiA/ICdAY29sb3Iva0NvbG9yU2Vjb25kYXJ5VGV4dCcgOiByaXNlQ29sb3JWMihjaGVja0ZpZWxkKGl0ZW0ucHJvZml0UmF0ZSwgbnVsbCksIG9yaWdpbkNvbnZlcnRMaXN0LmNvbG9yTW9kZSk7XG4gICAgICAgICAgICAgICAgY29uc3QgaXNVcGRhdGVkQ3VycmVuY3kgPSAoY3VycmVuY3lVcGRhdGVEYXRhLnVwRGV0YWlsQ3VycmVuY3kgPT09IGl0ZW0uY3VycmVuY3kgJiYgY3VycmVuY3lVcGRhdGVEYXRhLnVwZ3JhZGVTdGF0ZSA9PT0gdHJ1ZSk7XG4gICAgICAgICAgICAgICAgY29uc3QgaXNOZWVkVXBDdXJyZW5jeSA9IChjdXJyZW5jeVVwZGF0ZURhdGEudXBncmFkZUN1cnJlbmN5ID09PSBpdGVtLmN1cnJlbmN5ICYmIGN1cnJlbmN5VXBkYXRlRGF0YS51cGdyYWRlU3RhdGUgPT09IHRydWUpO1xuICAgICAgICAgICAgICAgIGNvbnN0IGN1cnJlbmN5ID0gaXRlbS5jdXJyZW5jeTtcblxuICAgICAgICAgICAgICAgIGlmIChpdGVtLnplcm9TdGF0ZSAhPT0gMSkge1xuICAgICAgICAgICAgICAgICAgICBzcG90WWllbGQgPSAnLS0nO1xuICAgICAgICAgICAgICAgICAgICBzcG90WWllbGRSYXRlID0gJyc7XG4gICAgICAgICAgICAgICAgICAgIHNwb3RSaXNlQ29sb3IgPSAnQGNvbG9yL2tDb2xvclNlY29uZGFyeVRleHQnO1xuICAgICAgICAgICAgICAgIH1cblxuICAgICAgICAgICAgICAgIHZhciBzaG93U3BvdE1hcmtldDtcbiAgICAgICAgICAgICAgICB2YXIgc2hvd1Nwb3RUcmFkZTtcbiAgICAgICAgICAgICAgICB2YXIgc2hvd1Nwb3RFYXJuO1xuICAgICAgICAgICAgICAgIHZhciBzaG93U3BvdERldGFpbDtcbiAgICAgICAgICAgICAgICB2YXIgc2hvd1Nwb3RTaGFyZTtcbiAgICAgICAgICAgICAgICB2YXIgc2hvd1Nwb3RVcERldGFpbDtcbiAgICAgICAgICAgICAgICB2YXIgc2hvd1Nwb3RVcGRhdGU7XG5cbiAgICAgICAgICAgICAgICBpZiAoaXNVcGRhdGVkQ3VycmVuY3kgPT09IHRydWUpIHtcbiAgICAgICAgICAgICAgICAgICAgc2hvd1Nwb3RNYXJrZXQgPSBcInZpc2libGVcIjtcbiAgICAgICAgICAgICAgICAgICAgc2hvd1Nwb3REZXRhaWwgPSBcInZpc2libGVcIjtcbiAgICAgICAgICAgICAgICAgICAgc2hvd1Nwb3RUcmFkZSA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgICAgICAgICAgICBzaG93U3BvdEVhcm4gPSBcImdvbmVcIjtcbiAgICAgICAgICAgICAgICAgICAgc2hvd1Nwb3RVcERldGFpbCA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgICAgICAgICAgICBzaG93U3BvdFNoYXJlID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAgICAgIHNob3dTcG90VXBkYXRlID0gXCJnb25lXCI7XG4gICAgICAgICAgICAgICAgfSBlbHNlIGlmIChpc05lZWRVcEN1cnJlbmN5ID09PSB0cnVlKSB7XG4gICAgICAgICAgICAgICAgICAgIHNob3dTcG90TWFya2V0ID0gXCJnb25lXCI7XG4gICAgICAgICAgICAgICAgICAgIHNob3dTcG90RGV0YWlsID0gXCJnb25lXCI7XG4gICAgICAgICAgICAgICAgICAgIHNob3dTcG90VHJhZGUgPSBcImdvbmVcIjtcbiAgICAgICAgICAgICAgICAgICAgc2hvd1Nwb3RFYXJuID0gXCJnb25lXCI7XG4gICAgICAgICAgICAgICAgICAgIHNob3dTcG90VXBEZXRhaWwgPSBcImdvbmVcIjtcbiAgICAgICAgICAgICAgICAgICAgc2hvd1Nwb3RTaGFyZSA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgICAgICAgICBzaG93U3BvdFVwZGF0ZSA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgICAgIHNob3dTcG90TWFya2V0ID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAgICAgIHNob3dTcG90RGV0YWlsID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAgICAgIHNob3dTcG90VHJhZGUgPSBcInZpc2libGVcIlxuICAgICAgICAgICAgICAgICAgICBzaG93U3BvdFNoYXJlID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAgICAgIGlmIChpdGVtLmlzRmluYW5jaWFsKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICBzaG93U3BvdEVhcm4gPSBcInZpc2libGVcIjtcbiAgICAgICAgICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICAgICAgICAgIHNob3dTcG90RWFybiA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgICAgIHNob3dTcG90VXBEZXRhaWwgPSBcImdvbmVcIlxuICAgICAgICAgICAgICAgICAgICBzaG93U3BvdFVwZGF0ZSA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgICAgIH1cblxuICAgICAgICAgICAgICAgIHZhciBzaG93U3BvdFVwZGF0ZUJ1dHRvbjtcbiAgICAgICAgICAgICAgICB2YXIgc2hvd1Nwb3RSaXNlO1xuICAgICAgICAgICAgICAgIGlmIChpc05lZWRVcEN1cnJlbmN5ID09PSB0cnVlKSB7XG4gICAgICAgICAgICAgICAgICAgIHNob3dTcG90VXBkYXRlQnV0dG9uID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAgICAgIHNob3dTcG90UmlzZSA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgICAgIHNob3dTcG90VXBkYXRlQnV0dG9uID0gXCJnb25lXCI7XG4gICAgICAgICAgICAgICAgICAgIHNob3dTcG90UmlzZSA9IFwidmlzaWJsZVwiO1xuICAgICAgICAgICAgICAgIH1cblxuICAgICAgICAgICAgICAgIHZhciBzcG90VHJhZGVTcmMgPSBcIkBkcmF3YWJsZS9hc3N0X2V4Y19leGNfdHJhZGVuZXdcIjtcbiAgICAgICAgICAgICAgICB2YXIgc3BvdFRyYWRlVGl0bGUgPSAkaTE4bi5uX25ld191c2VyX2d1aWRlX3RyYWRlO1xuICAgICAgICAgICAgICAgIGlmIChleGNoYW5nZUVuYWJsZSkge1xuICAgICAgICAgICAgICAgICAgaWYgKHN5bWJvbE5hbWUgPT0gXCJVU0RUXCIpIHtcbiAgICAgICAgICAgICAgICAgICAgc3BvdFRyYWRlU3JjID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfYXNzZXRfc3BvdF91c2RkX3VzZHRcIjtcbiAgICAgICAgICAgICAgICAgICAgc3BvdFRyYWRlVGl0bGUgPSAkaTE4bi5uX2Fzc2V0X3Nwb3RfZXhjaGFuZ2VfVVNERDtcbiAgICAgICAgICAgICAgICAgIH0gZWxzZSBpZiAoc3ltYm9sTmFtZSA9PSBcIlVTRERcIikge1xuICAgICAgICAgICAgICAgICAgICBzcG90VHJhZGVTcmMgPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9hc3NldF9zcG90X3VzZGRfdXNkdFwiO1xuICAgICAgICAgICAgICAgICAgICBzcG90VHJhZGVUaXRsZSA9ICRpMThuLm5fYXNzZXRfc3BvdF9leGNoYW5nZV9VU0RUO1xuICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIH0gICAgICAgICAgICAgICAgXG4gICAgICAgICAgICAgICAgcmV0dXJuIHtcbiAgICAgICAgICAgICAgICAgICAgc3ltYm9sSWNvbixcbiAgICAgICAgICAgICAgICAgICAgc3ltYm9sTmFtZSxcbiAgICAgICAgICAgICAgICAgICAgaXNMb2FuLFxuICAgICAgICAgICAgICAgICAgICBlcXVhbEFtb3VudCxcbiAgICAgICAgICAgICAgICAgICAgc3BvdE51bWJlckVxdWl2YWxlbnQsXG4gICAgICAgICAgICAgICAgICAgIHNwb3ROdW1iZXIsXG4gICAgICAgICAgICAgICAgICAgIHNwb3RZaWVsZCxcbiAgICAgICAgICAgICAgICAgICAgc3BvdEV4VG9wQ2VudGVyVGl0bGUsXG4gICAgICAgICAgICAgICAgICAgIGF2Z1Bvc2l0aW9uQ29zdCxcbiAgICAgICAgICAgICAgICAgICAgYXZnUG9zaXRpb25Db3N0U2hvdyxcbiAgICAgICAgICAgICAgICAgICAgc3BvdFlpZWxkUmF0ZSxcbiAgICAgICAgICAgICAgICAgICAgc3BvdEV4QXZhaWxhYmxlLFxuICAgICAgICAgICAgICAgICAgICBzcG90RXhEZWJ0cyxcbiAgICAgICAgICAgICAgICAgICAgc3BvdEV4UHJpY2UsXG4gICAgICAgICAgICAgICAgICAgIHNwb3RFeENvc3QsXG4gICAgICAgICAgICAgICAgICAgIHNwb3RFeFlpZWxkLFxuICAgICAgICAgICAgICAgICAgICBzcG90RXhZaWVsZFJhdGUsXG4gICAgICAgICAgICAgICAgICAgIHNwb3RSaXNlQ29sb3IsXG4gICAgICAgICAgICAgICAgICAgIHNwb3RFeFJpc2VDb2xvcixcbiAgICAgICAgICAgICAgICAgICAgc2hvd1Nwb3RNYXJrZXQsXG4gICAgICAgICAgICAgICAgICAgIHNob3dTcG90RGV0YWlsLFxuICAgICAgICAgICAgICAgICAgICBzaG93U3BvdFRyYWRlLFxuICAgICAgICAgICAgICAgICAgICBzaG93U3BvdEVhcm4sXG4gICAgICAgICAgICAgICAgICAgIHNob3dTcG90U2hhcmUsXG4gICAgICAgICAgICAgICAgICAgIHNob3dTcG90VXBEZXRhaWwsXG4gICAgICAgICAgICAgICAgICAgIHNob3dTcG90VXBkYXRlLFxuICAgICAgICAgICAgICAgICAgICBzaG93U3BvdFVwZGF0ZUJ1dHRvbixcbiAgICAgICAgICAgICAgICAgICAgc2hvd1Nwb3RSaXNlLFxuICAgICAgICAgICAgICAgICAgICBjdXJyZW5jeSxcbiAgICAgICAgICAgICAgICAgICAgc3BvdFRyYWRlU3JjLFxuICAgICAgICAgICAgICAgICAgICBzcG90VHJhZGVUaXRsZSxcbiAgICAgICAgICAgICAgICB9O1xuICAgICAgICAgICAgfSBjYXRjaCAoZSkge1xuICAgICAgICAgICAgICAgIGNvbnNvbGUuZXJyb3IoYHNwb3RDdXJyZW5jeURhdGEubWFwICR7ZX1gKTtcbiAgICAgICAgICAgICAgICByZXR1cm4ge307XG4gICAgICAgICAgICB9XG4gICAgICAgIH0pKTtcbiAgICAgICAgY2FjaGVEYXRhLnNwb3Quc3BvdC5zcG90TGlzdE5ldyA9IHNwb3RMaXN0TmV3O1xuICAgICAgICAkZGF0YS5leGNoYW5nZUxpc3QgPSBKU09OLnN0cmluZ2lmeShzcG90TGlzdE5ldyk7XG4gICAgICAgIGlmIChsaXN0Lmxlbmd0aCA+IDApIHtcbiAgICAgICAgICAgIGVuZFRpbWUgPSBEYXRlLm5vdygpO1xuICAgICAgICB9XG4gICAgICAgIGNvbnNvbGUubG9nKGBDb25zdW1lVGltZVRhZyAg5oC76ICX5pe2IDogJHtlbmRUaW1lIC0gc3RhcnRUaW1lfWApO1xuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5lcnJvcihgdXBkYXRlU3BvdEN1cnJlbmNpZXNEYXRhICR7ZX1gKTtcbiAgICB9XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBjaGVja0ZpZWxkKGZpZWxkLCBkZWZhdWx0VmFsdWUpIHtcbiAgICByZXR1cm4gZmllbGQgPT0gbnVsbCA/IGRlZmF1bHRWYWx1ZSA6IGZpZWxkO1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gdXBkYXRlU3BvdENvbGxhdGVyYWxCYXNlSW5mb0RhdGEoZGF0YSkge1xuICAgIGlmIChpc0hpZGRlbikge1xuICAgICAgICAkZGF0YS5jb2xsYXRlcmFsVG90YWxBc3NldCA9IEhJRERFTl9TVFI7XG4gICAgICAgICRkYXRhLmxvYW5lZCA9IEhJRERFTl9TVFI7XG4gICAgICAgICRkYXRhLmNvbGxhdGVyYWwgPSBISURERU5fU1RSO1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIGNvbnN0IGN1cnJlbmN5U3ltYm9sID0gYXdhaXQgZ2V0TGVnYWxDdXJyZW5jeVN5bWJvbCgpO1xuICAgIGNvbnN0IGxlZ2FsQXNzZXQgPSBhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRIYW5kbGVOdWxsKFN5bWJvbHMudXNkdCwgZGF0YS5iYWxhbmNlKTtcbiAgICAkZGF0YS5jb2xsYXRlcmFsVG90YWxBc3NldCA9IGFkZEN1cnJlbmN5U3ltYm9sVG90YWxBc3NldChjdXJyZW5jeVN5bWJvbCwgYXdhaXQgZm9ybWF0TnVtKGxlZ2FsQXNzZXQpKTtcbiAgICAkZGF0YS5oZWFkZXJCb3R0b21TaG93ID0gXCJ2aXNpYmxlXCI7XG59XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gdXBkYXRlU3BvdENvbGxhdGVyYWxDdXJyZW5jeURhdGEob2xkTG9haW5nTGlzdCwgb2xkUGxlZGdlTGlzdCkge1xuICAgIGNvbnN0IGN1cnJlbmN5U3ltYm9sID0gYXdhaXQgZ2V0TGVnYWxDdXJyZW5jeVN5bWJvbCgpO1xuICAgIGNvbnN0IHJlc3VsdCA9IHt9O1xuICAgIHZhciBzaG91bGRSZXR1cm4gPSBmYWxzZTtcbiAgICBpZiAob2xkTG9haW5nTGlzdCkge1xuICAgICAgICBjb25zdCBsb2FuaW5nTGlzdCA9IFtdO1xuICAgICAgICBjb25zdCBzZWFyY2hLZXkgPSBjYWNoZURhdGEuc3BvdC5jb2xsYXRlcmFsLnNlYXJjaEtleTtcbiAgICAgICAgY29uc3QgaGlkZGVuU21hbGxBc3NldCA9IGNhY2hlRGF0YS5zcG90LmNvbGxhdGVyYWwuaGlkZGVuU21hbGxBc3NldDtcbiAgICAgICAgYXdhaXQgUHJvbWlzZS5hbGwob2xkTG9haW5nTGlzdC5tYXAoYXN5bmMgKGl0ZW0pID0+IHtcbiAgICAgICAgICAgIGlmIChhd2FpdCBpdGVtU2hvdWxkU2hvdyhpdGVtLmN1cnJlbmN5LCBTeW1ib2xzLnVzZHQsIGl0ZW0udXNkdEFtb3VudCwgaGlkZGVuU21hbGxBc3NldCwgc2VhcmNoS2V5KSkge1xuICAgICAgICAgICAgICAgIGxvYW5pbmdMaXN0LnB1c2goaXRlbSk7XG4gICAgICAgICAgICB9XG4gICAgICAgIH0pKTtcbiAgICAgICAgY29uc3QgbmV3TG9hbmluZ0xpc3QgPSBhd2FpdCBzb3J0TGlzdChsb2FuaW5nTGlzdCwgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50Rm9yQ29sbGF0ZXJhbCk7XG4gICAgICAgIGNvbnN0IGxvYW5lZCA9IGF3YWl0IFByb21pc2UuYWxsKG5ld0xvYW5pbmdMaXN0Lm1hcChhc3luYyAoaXRlbSkgPT4ge1xuICAgICAgICAgICAgdHJ5IHtcbiAgICAgICAgICAgICAgICBjb25zdCBzeW1ib2xJY29uID0gaXRlbS5jdXJyZW5jeUljb247XG4gICAgICAgICAgICAgICAgY29uc3Qgc3ltYm9sTmFtZSA9IGl0ZW0uY3VycmVuY3kudG9VcHBlckNhc2UoKTtcbiAgICAgICAgICAgICAgICBjb25zdCBhbW91bnQgPSBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBpdGVtLmFtb3VudDtcbiAgICAgICAgICAgICAgICBjb25zdCBlcXVhbEFtb3VudCA9IGF3YWl0IGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudChTeW1ib2xzLnVzZHQsIGl0ZW0udXNkdEFtb3VudCk7XG4gICAgICAgICAgICAgICAgY29uc3QgdmFsdWUgPSBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBhZGRDdXJyZW5jeVN5bWJvbChjdXJyZW5jeVN5bWJvbCwgZXF1YWxBbW91bnQpO1xuICAgICAgICAgICAgICAgIHJldHVybiB7XG4gICAgICAgICAgICAgICAgICAgIHN5bWJvbEljb24sXG4gICAgICAgICAgICAgICAgICAgIHN5bWJvbE5hbWUsXG4gICAgICAgICAgICAgICAgICAgIGFtb3VudCxcbiAgICAgICAgICAgICAgICAgICAgdmFsdWUsXG4gICAgICAgICAgICAgICAgfTtcbiAgICAgICAgICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgICAgICAgICBjb25zb2xlLmVycm9yKGBsb2FuaW5nTGlzdCBlcnJvciAke2V9YCk7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICByZXR1cm4ge307XG4gICAgICAgIH0pKTtcbiAgICAgICAgc2hvdWxkUmV0dXJuID0gdHJ1ZTtcbiAgICAgICAgcmVzdWx0LmxvYW5lZExpc3QgPSBsb2FuZWQ7XG4gICAgfVxuXG4gICAgaWYgKG9sZFBsZWRnZUxpc3QpIHtcbiAgICAgICAgY29uc3QgcGxlZGdlTGlzdCA9IFtdO1xuICAgICAgICBjb25zdCBzZWFyY2hLZXkgPSBjYWNoZURhdGEuc3BvdC5jb2xsYXRlcmFsLnNlYXJjaEtleTtcbiAgICAgICAgY29uc3QgaGlkZGVuU21hbGxBc3NldCA9IGNhY2hlRGF0YS5zcG90LmNvbGxhdGVyYWwuaGlkZGVuU21hbGxBc3NldDtcbiAgICAgICAgYXdhaXQgUHJvbWlzZS5hbGwob2xkUGxlZGdlTGlzdC5tYXAoYXN5bmMgKGl0ZW0pID0+IHtcbiAgICAgICAgICAgIGlmIChhd2FpdCBpdGVtU2hvdWxkU2hvdyhpdGVtLmN1cnJlbmN5LCBTeW1ib2xzLnVzZHQsIGl0ZW0udXNkdEFtb3VudCwgaGlkZGVuU21hbGxBc3NldCwgc2VhcmNoS2V5KSkge1xuICAgICAgICAgICAgICAgIHBsZWRnZUxpc3QucHVzaChpdGVtKTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfSkpO1xuICAgICAgICBjb25zdCBuZXdQbGVkZ2VMaXN0ID0gYXdhaXQgc29ydExpc3QocGxlZGdlTGlzdCwgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50Rm9yQ29sbGF0ZXJhbCk7XG4gICAgICAgIGNvbnN0IGNvbGxhdGVyYWwgPSBhd2FpdCBQcm9taXNlLmFsbChuZXdQbGVkZ2VMaXN0Lm1hcChhc3luYyAoaXRlbSkgPT4ge1xuICAgICAgICAgICAgdHJ5IHtcbiAgICAgICAgICAgICAgICBjb25zdCBzeW1ib2xJY29uID0gaXRlbS5jdXJyZW5jeUljb247XG4gICAgICAgICAgICAgICAgY29uc3Qgc3ltYm9sTmFtZSA9IGl0ZW0uY3VycmVuY3kudG9VcHBlckNhc2UoKTtcbiAgICAgICAgICAgICAgICBjb25zdCBhbW91bnQgPSBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBhd2FpdCBnZXRQcmVDdXJyZW5jeUFtb3VudChpdGVtLmN1cnJlbmN5LCBpdGVtLmFtb3VudCk7XG4gICAgICAgICAgICAgICAgY29uc3QgZXF1YWxBbW91bnQgPSBhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnQoU3ltYm9scy51c2R0LCBpdGVtLnVzZHRBbW91bnQpO1xuICAgICAgICAgICAgICAgIGNvbnN0IHZhbHVlID0gaXNIaWRkZW4gPyBISURERU5fU1RSIDogYWRkQ3VycmVuY3lTeW1ib2woY3VycmVuY3lTeW1ib2wsIGVxdWFsQW1vdW50KTtcbiAgICAgICAgICAgICAgICByZXR1cm4ge1xuICAgICAgICAgICAgICAgICAgICBzeW1ib2xJY29uLFxuICAgICAgICAgICAgICAgICAgICBzeW1ib2xOYW1lLFxuICAgICAgICAgICAgICAgICAgICBhbW91bnQsXG4gICAgICAgICAgICAgICAgICAgIHZhbHVlLFxuICAgICAgICAgICAgICAgIH07XG4gICAgICAgICAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgICAgICAgICAgY29uc29sZS5lcnJvcihgbG9hbmluZ0xpc3QgZXJyb3IgJHtlfWApO1xuICAgICAgICAgICAgfVxuICAgICAgICB9KSk7XG4gICAgICAgIHNob3VsZFJldHVybiA9IHRydWU7XG4gICAgICAgIHJlc3VsdC5jb2xsYXRlcmFsTGlzdCA9IGNvbGxhdGVyYWw7XG4gICAgfVxuXG4gICAgaWYgKHNob3VsZFJldHVybikge1xuICAgICAgICAkZGF0YS5jb2xsYXRlcmFsRGF0YSA9IEpTT04uc3RyaW5naWZ5KHJlc3VsdCk7XG4gICAgfVxuICAgICRkYXRhLmxvYW5lZCA9IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGF3YWl0IGFkZEN1cnJlbnRDdXJyZW5jeVN5bWJvbChhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnQoU3ltYm9scy51c2R0LCBjYWNoZURhdGEuc3BvdC5ib3QubG9hbmVkKSk7XG4gICAgJGRhdGEuY29sbGF0ZXJhbCA9IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGF3YWl0IGFkZEN1cnJlbnRDdXJyZW5jeVN5bWJvbChhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnQoU3ltYm9scy51c2R0LCBjYWNoZURhdGEuc3BvdC5ib3QuY29sbGF0ZXJhbCkpO1xufVxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHVwZGF0ZUxpbmVhclN3YXBCYXNlSW5mb0RhdGEoZGF0YSkge1xuICAgIGNvbnNvbGUubG9nKCd1cGRhdGVMaW5lYXJTd2FwQmFzZUluZm9EYXRhJyk7XG4gICAgY29uc3QgY3VycmVuY3lTeW1ib2wgPSBhd2FpdCBnZXRMZWdhbEN1cnJlbmN5U3ltYm9sKCk7XG4gICAgaWYgKGlzSGlkZGVuKSB7XG4gICAgICAgICRkYXRhLmxpbmVhckhlYWRlclRvdGFsQXNzZXQgPSBISURERU5fU1RSO1xuICAgICAgICAkZGF0YS5saW5lYXJIZWFkZXJJbmNvbWUgPSBISURERU5fU1RSO1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIGNvbnN0IHRvdGFsTGVnYWwgPSBhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRIYW5kbGVOdWxsKFN5bWJvbHMudXNkdCwgZGF0YS5iYWxhbmNlKTtcbiAgICAkZGF0YS5saW5lYXJIZWFkZXJUb3RhbEFzc2V0ID0gYWRkQ3VycmVuY3lTeW1ib2xUb3RhbEFzc2V0KGN1cnJlbmN5U3ltYm9sLCBhd2FpdCBmb3JtYXROdW0odG90YWxMZWdhbCkpO1xuXG4gICAgY29uc3QgdG9kYXlQcm9maXQgPSBhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRIYW5kbGVOdWxsKFN5bWJvbHMudXNkdCwgZGF0YS50b2RheVByb2ZpdCk7XG4gICAgY29uc3QgdG9kYXlQcm9maXRXaXRoU3ltYm9sID0gYWRkQ3VycmVuY3lTeW1ib2woY3VycmVuY3lTeW1ib2wsIHRvZGF5UHJvZml0KTtcbiAgICAkZGF0YS5saW5lYXJIZWFkZXJJbmNvbWUgPSBgJHtwcm9maXRQcmVmaXgoZGF0YS50b2RheVByb2ZpdCl9JHt0b2RheVByb2ZpdFdpdGhTeW1ib2x9LyR7Zml4UmF0ZUhhbmRsZU51bGwoZGF0YS50b2RheVByb2ZpdFJhdGUpfWA7XG4gICAgJGRhdGEubGluZWFySGVhZGVySW5jb21lQ29sb3IgPSBpc0hpZGRlbiA/IGF3YWl0IGdldENvbG9yKCdrQ29sb3JTZWNvbmRhcnlUZXh0JykgOiBhd2FpdCByaXNlQ29sb3IoZGF0YS50b2RheVByb2ZpdCk7XG5cbiAgICAvL3RvZG8g5re75Yqg5byA5ZCv6LWa5biB5oyJ6ZKuXG59XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gdXBkYXRlQ29pbk1CYXNlSW5mb0RhdGEoZGF0YSkge1xuICAgIGNvbnNvbGUubG9nKCd1cGRhdGVDb2luTUJhc2VJbmZvRGF0YScpO1xuICAgIGNvbnN0IGN1cnJlbmN5U3ltYm9sID0gYXdhaXQgZ2V0TGVnYWxDdXJyZW5jeVN5bWJvbCgpO1xuICAgIGlmIChpc0hpZGRlbikge1xuICAgICAgICAkZGF0YS5jb2luTUhlYWRlclRvdGFsQXNzZXQgPSBISURERU5fU1RSO1xuICAgICAgICAkZGF0YS5jb2luTUhlYWRlckluY29tZSA9IEhJRERFTl9TVFI7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgY29uc3QgdG90YWxMZWdhbCA9IGF3YWl0IGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudEhhbmRsZU51bGwoU3ltYm9scy51c2R0LCBkYXRhLmJhbGFuY2UpO1xuICAgICRkYXRhLmNvaW5NSGVhZGVyVG90YWxBc3NldCA9IGFkZEN1cnJlbmN5U3ltYm9sVG90YWxBc3NldChjdXJyZW5jeVN5bWJvbCwgYXdhaXQgZm9ybWF0TnVtKHRvdGFsTGVnYWwpKTtcblxuICAgIGNvbnN0IHRvZGF5UHJvZml0ID0gYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50SGFuZGxlTnVsbChTeW1ib2xzLnVzZHQsIGRhdGEudG9kYXlQcm9maXQpO1xuICAgIGNvbnN0IHRvZGF5UHJvZml0V2l0aFN5bWJvbCA9IGFkZEN1cnJlbmN5U3ltYm9sKGN1cnJlbmN5U3ltYm9sLCB0b2RheVByb2ZpdCk7XG4gICAgJGRhdGEuY29pbk1IZWFkZXJJbmNvbWUgPSBgJHtwcm9maXRQcmVmaXgoZGF0YS50b2RheVByb2ZpdCl9JHt0b2RheVByb2ZpdFdpdGhTeW1ib2x9LyR7Zml4UmF0ZUhhbmRsZU51bGwoZGF0YS50b2RheVByb2ZpdFJhdGUpfWA7XG4gICAgJGRhdGEuY29pbk1IZWFkZXJJbmNvbWVDb2xvciA9IGlzSGlkZGVuID8gYXdhaXQgZ2V0Q29sb3IoJ2tDb2xvclNlY29uZGFyeVRleHQnKSA6IGF3YWl0IHJpc2VDb2xvcihkYXRhLnRvZGF5UHJvZml0KTtcbn1cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiB1cGRhdGVDb2luUEJhc2VJbmZvRGF0YShkYXRhKSB7XG4gICAgY29uc29sZS5sb2coJ3VwZGF0ZUNvaW5QQmFzZUluZm9EYXRhJyk7XG4gICAgY29uc3QgY3VycmVuY3lTeW1ib2wgPSBhd2FpdCBnZXRMZWdhbEN1cnJlbmN5U3ltYm9sKCk7XG4gICAgaWYgKGlzSGlkZGVuKSB7XG4gICAgICAgICRkYXRhLmNvaW5QSGVhZGVyVG90YWxBc3NldCA9IEhJRERFTl9TVFI7XG4gICAgICAgICRkYXRhLmNvaW5QSGVhZGVySW5jb21lID0gSElEREVOX1NUUjtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICBjb25zdCB0b3RhbExlZ2FsID0gYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50SGFuZGxlTnVsbChTeW1ib2xzLnVzZHQsIGRhdGEuYmFsYW5jZSk7XG4gICAgJGRhdGEuY29pblBIZWFkZXJUb3RhbEFzc2V0ID0gYWRkQ3VycmVuY3lTeW1ib2xUb3RhbEFzc2V0KGN1cnJlbmN5U3ltYm9sLCBhd2FpdCBmb3JtYXROdW0odG90YWxMZWdhbCkpO1xuXG4gICAgY29uc3QgdG9kYXlQcm9maXQgPSBhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRIYW5kbGVOdWxsKFN5bWJvbHMudXNkdCwgZGF0YS50b2RheVByb2ZpdCk7XG4gICAgY29uc3QgdG9kYXlQcm9maXRXaXRoU3ltYm9sID0gYWRkQ3VycmVuY3lTeW1ib2woY3VycmVuY3lTeW1ib2wsIHRvZGF5UHJvZml0KTtcbiAgICAkZGF0YS5jb2luUEhlYWRlckluY29tZSA9IGAke3Byb2ZpdFByZWZpeChkYXRhLnRvZGF5UHJvZml0KX0ke3RvZGF5UHJvZml0V2l0aFN5bWJvbH0vJHtmaXhSYXRlSGFuZGxlTnVsbChkYXRhLnRvZGF5UHJvZml0UmF0ZSl9YDtcbiAgICAkZGF0YS5jb2luUEhlYWRlckluY29tZUNvbG9yID0gaXNIaWRkZW4gPyBhd2FpdCBnZXRDb2xvcigna0NvbG9yU2Vjb25kYXJ5VGV4dCcpIDogYXdhaXQgcmlzZUNvbG9yKGRhdGEudG9kYXlQcm9maXQpO1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gdXBkYXRlT3RjQmFzZUluZm8oZGF0YSkge1xuICAgIGNvbnN0IGN1cnJlbmN5U3ltYm9sID0gYXdhaXQgZ2V0TGVnYWxDdXJyZW5jeVN5bWJvbCgpO1xuICAgICRkYXRhLmZpYXRIZWFkZXJUaXRsZSA9IGF3YWl0IGdldFdvcmQoJ25fYXNzZXRfYWxsX2JhbGFuY2VfY29udmVydCcpO1xuICAgIGlmIChpc0hpZGRlbikge1xuICAgICAgICAkZGF0YS5vdGNUb3RhbEFzc2V0ID0gSElEREVOX1NUUjtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICBjb25zdCB0b3RhbExlZ2FsID0gYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50SGFuZGxlTnVsbChTeW1ib2xzLnVzZHQsIGRhdGEuYmFsYW5jZSk7XG4gICAgJGRhdGEub3RjVG90YWxBc3NldCA9IGFkZEN1cnJlbmN5U3ltYm9sVG90YWxBc3NldChjdXJyZW5jeVN5bWJvbCwgYXdhaXQgZm9ybWF0TnVtKHRvdGFsTGVnYWwpKTtcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHVwZGF0ZUNvcHlUcmFkaW5nQmFzZUluZm8oZGF0YSkge1xuICAgIGNvbnN0IGN1cnJlbmN5U3ltYm9sID0gYXdhaXQgZ2V0TGVnYWxDdXJyZW5jeVN5bWJvbCgpO1xuICAgIGlmIChpc0hpZGRlbikge1xuICAgICAgICAkZGF0YS5jb3B5VHJhZGluZ1RvdGFsID0gSElEREVOX1NUUjtcbiAgICAgICAgJGRhdGEuY29weVRyYWRpbmdIZWFkZXJJbmNvbWUgPSBISURERU5fU1RSO1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIGNvbnN0IHRvdGFsTGVnYWwgPSBhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRIYW5kbGVOdWxsKFN5bWJvbHMudXNkdCwgZGF0YS5iYWxhbmNlKTtcbiAgICAkZGF0YS5jb3B5VHJhZGluZ1RvdGFsID0gYWRkQ3VycmVuY3lTeW1ib2xUb3RhbEFzc2V0KGN1cnJlbmN5U3ltYm9sLCBhd2FpdCBmb3JtYXROdW0odG90YWxMZWdhbCkpO1xuXG4gICAgY29uc3QgdG9kYXlQcm9maXQgPSBhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRIYW5kbGVOdWxsKFN5bWJvbHMudXNkdCwgZGF0YS50b2RheVByb2ZpdCk7XG4gICAgY29uc3QgdG9kYXlQcm9maXRXaXRoU3ltYm9sID0gYWRkQ3VycmVuY3lTeW1ib2woY3VycmVuY3lTeW1ib2wsIHRvZGF5UHJvZml0KTtcbiAgICAkZGF0YS5jb3B5VHJhZGluZ0hlYWRlckluY29tZSA9IGAke3Byb2ZpdFByZWZpeChkYXRhLnRvZGF5UHJvZml0KX0ke3RvZGF5UHJvZml0V2l0aFN5bWJvbH0vJHtmaXhSYXRlSGFuZGxlTnVsbChkYXRhLnRvZGF5UHJvZml0UmF0ZSl9YDtcbiAgICAkZGF0YS5jb3B5VHJhZGluZ0hlYWRlckluY29tZUNvbG9yID0gaXNIaWRkZW4gPyBhd2FpdCBnZXRDb2xvcigna0NvbG9yU2Vjb25kYXJ5VGV4dCcpIDogYXdhaXQgcmlzZUNvbG9yKGRhdGEudG9kYXlQcm9maXQpO1xufVxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHVwZGF0ZU1hcmdpbkFsbEluZm8oZGF0YSkge1xuICAgIGNvbnN0IGN1cnJlbmN5U3ltYm9sID0gYXdhaXQgZ2V0TGVnYWxDdXJyZW5jeVN5bWJvbCgpO1xuICAgICRkYXRhLm1hcmdpbkFsbEhlYWRlclRpdGxlID0gYXdhaXQgZ2V0V29yZCgnbl9hc3NldF9hbGxfYmFsYW5jZV9jb252ZXJ0Jyk7XG4gICAgaWYgKGlzSGlkZGVuKSB7XG4gICAgICAgICRkYXRhLm1hcmdpbkFsbFRvdGFsQXNzZXQgPSBISURERU5fU1RSO1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIGNvbnN0IHRvdGFsTGVnYWwgPSBhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRIYW5kbGVOdWxsKFN5bWJvbHMudXNkdCwgZGF0YS5iYWxhbmNlKTtcbiAgICAkZGF0YS5tYXJnaW5BbGxUb3RhbEFzc2V0ID0gYWRkQ3VycmVuY3lTeW1ib2xUb3RhbEFzc2V0KGN1cnJlbmN5U3ltYm9sLCBhd2FpdCBmb3JtYXROdW0odG90YWxMZWdhbCkpO1xuICAgICRkYXRhLm1hcmdpbkFsbEFjY291bnRUeXBlID0gXCIxXCI7XG4gICAgJGRhdGEubWFyZ2luQWxsUmlza1JhdGUgPSBkYXRhLnJpc2tSYXRlO1xuICAgICRkYXRhLm1hcmdpbkFsbFJhdGUgPSBoYW5kbGVyQXNzZXRSaXNrUmF0ZShkYXRhLnJpc2tSYXRlKTtcbiAgICAkZGF0YS5tYXJnaW5BbGxSYXRlQ29sb3IgPSBnZXRSaXNrU3RhdGVDb2xvcihkYXRhLnJpc2tTdGF0ZSk7XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBoYW5kbGVyQXNzZXRSaXNrUmF0ZShyaXNrUmF0ZSkge1xuICAgIHRyeSB7XG4gICAgICAgIGlmIChyaXNrUmF0ZSA9PT0gbnVsbCkge1xuICAgICAgICAgICAgcmV0dXJuIFwiLS1cIjtcbiAgICAgICAgfVxuICAgICAgICBpZiAoTnVtYmVyLnBhcnNlRmxvYXQocmlza1JhdGUpID49IDkuOTkpIHtcbiAgICAgICAgICAgIHJldHVybiBcIuKJpTk5OSVcIlxuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgcmV0dXJuIGAke01hdGguY2VpbChOdW1iZXIucGFyc2VGbG9hdChyaXNrUmF0ZSkgKiAxMDApfSVgO1xuICAgICAgICB9XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICBjb25zb2xlLmVycm9yKGBoYW5kbGVyQXNzZXRSaXNrUmF0ZSBBUiR7ZX1gKTtcbiAgICAgICAgcmV0dXJuIFwiLS1cIjtcbiAgICB9XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBnZXRSaXNrU3RhdGVDb2xvcihyaXNrU3RhdGUpIHtcbiAgICBpZiAocmlza1N0YXRlID09PSBudWxsKSB7XG4gICAgICAgIHJldHVybiBcIkBjb2xvci9lQmFzZUNvbG9yVGhyZWVMZXZlbFRleHRcIjtcbiAgICB9XG4gICAgaWYgKHJpc2tTdGF0ZSA9PSAwKSB7XG4gICAgICAgIC8v54iG5LuT5LitXG4gICAgICAgIHJldHVybiBcIkBjb2xvci9iYXNlQ29pbkRhbmdlcm91c1RpcFwiXG4gICAgfSBlbHNlIGlmIChyaXNrU3RhdGUgPT0gMykge1xuICAgICAgICAvL+aXoOmjjumZqVxuICAgICAgICByZXR1cm4gXCJAY29sb3Iva0NvbG9yUHJpbWFyeVRleHRcIlxuICAgIH0gZWxzZSBpZiAocmlza1N0YXRlID09IDIpIHtcbiAgICAgICAgLy/mnInpo47pmalcbiAgICAgICAgcmV0dXJuIFwiQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0XCJcbiAgICB9IGVsc2UgaWYgKHJpc2tTdGF0ZSA9PSAxKSB7XG4gICAgICAgIC8v6auY6aOO6ZmpXG4gICAgICAgIHJldHVybiBcIkBjb2xvci9iYXNlQ29pbkRhbmdlcm91c1RpcFwiXG4gICAgfSBlbHNlIGlmIChyaXNrU3RhdGUgPT0gLTEpIHtcbiAgICAgICAgLy/nqb/ku5NcbiAgICAgICAgcmV0dXJuIFwiQGNvbG9yL2Jhc2VDb2luRGFuZ2Vyb3VzVGlwXCJcbiAgICB9XG4gICAgcmV0dXJuIFwiQGNvbG9yL2tDb2xvclByaW1hcnlUZXh0XCJcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHVwZGF0ZU1hcmdpblBhcnRCYXNlSW5mbyhkYXRhKSB7XG4gICAgY29uc3QgY3VycmVuY3lTeW1ib2wgPSBhd2FpdCBnZXRMZWdhbEN1cnJlbmN5U3ltYm9sKCk7XG4gICAgJGRhdGEubWFyZ2luUGFydEhlYWRlclRpdGxlID0gYXdhaXQgZ2V0V29yZCgnbl9hc3NldF9hbGxfYmFsYW5jZV9jb252ZXJ0Jyk7XG4gICAgaWYgKGlzSGlkZGVuKSB7XG4gICAgICAgICRkYXRhLm1hcmdpblBhcnRUb3RhbEFzc2V0ID0gSElEREVOX1NUUjtcbiAgICAgICAgcmV0dXJuO1xuICAgIH1cbiAgICBjb25zdCB0b3RhbExlZ2FsID0gYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50SGFuZGxlTnVsbChTeW1ib2xzLnVzZHQsIGRhdGEuYmFsYW5jZSk7XG4gICAgJGRhdGEubWFyZ2luUGFydFRvdGFsQXNzZXQgPSBhZGRDdXJyZW5jeVN5bWJvbFRvdGFsQXNzZXQoY3VycmVuY3lTeW1ib2wsIGF3YWl0IGZvcm1hdE51bSh0b3RhbExlZ2FsKSk7XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiB1cGRhdGVDb250cmFjdFVzZHRNVW5pdHlEYXRhKG9sZExpc3QpIHtcbiAgICB0cnkge1xuICAgICAgICBjb25zdCBkYXRhID0gW107XG4gICAgICAgIGxldCBuZXdEYXRhID0gW107XG4gICAgICAgIGxldCBtYXJnaW5Dcm9zcztcbiAgICAgICAgY29uc29sZS5sb2coYHVwZGF0ZUNvbnRyYWN0VXNkdE1Vbml0eURhdGEgQSA9ICR7b2xkTGlzdH1gKTtcbiAgICAgICAgY29uc3QgdXNkdExpc3QgPSBbXTtcbiAgICAgICAgY29uc3QgdXNkdE1TZWFjaEtleSA9IGNhY2hlRGF0YS5jb250cmFjdC51c2R0X21fdW5pdHkuYWxsLnNlYXJjaEtleTtcbiAgICAgICAgY29uc3QgdXNkdE1IaWRkZW5TbWFsbEFzc2V0ID0gY2FjaGVEYXRhLmNvbnRyYWN0LnVzZHRfbV91bml0eS5hbGwuaGlkZGVuU21hbGxBc3NldDtcbiAgICAgICAgYXdhaXQgUHJvbWlzZS5hbGwob2xkTGlzdC5tYXAoYXN5bmMgKGl0ZW0pID0+IHtcbiAgICAgICAgICAgIGlmIChpdGVtLm1hcmdpbk1vZGUgPT09ICdjcm9zcycpIHtcbiAgICAgICAgICAgICAgICBpdGVtLnNlY29uZFN5bWJvbE5hbWUgPSBhd2FpdCBnZXRXb3JkKFwibl9jb250cmFjdF9zdXBlcl9tYXJnaW5cIik7XG4gICAgICAgICAgICAgICAgdXNkdExpc3QucHVzaChpdGVtKTtcbiAgICAgICAgICAgIH0gZWxzZSBpZiAoYXdhaXQgaXRlbVNob3VsZFNob3coaXRlbS5zeW1ib2wsIGl0ZW0uc3ltYm9sLCBpdGVtLm1hcmdpbkJhbGFuY2UsIHVzZHRNSGlkZGVuU21hbGxBc3NldCwgdXNkdE1TZWFjaEtleSkpIHtcbiAgICAgICAgICAgICAgICBkYXRhLnB1c2goaXRlbSk7XG4gICAgICAgICAgICB9XG4gICAgICAgIH0pKTtcbiAgICAgICAgY29uc3Qgc29ydGVkID0gYXdhaXQgc29ydExpc3QoZGF0YSwgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50Rm9yQ29udHJhY3RBbGxVc2R0TSk7XG4gICAgICAgIG5ld0RhdGEgPSBbLi4udXNkdExpc3QsIC4uLnNvcnRlZF07XG4gICAgICAgIGNhY2hlRGF0YS5jb250cmFjdC51c2R0X21fdW5pdHkuYWxsLm5ld0xpc3QgPSBuZXdEYXRhO1xuXG4gICAgICAgIGNvbnN0IGN1cnJlbmN5U3ltYm9sID0gYXdhaXQgZ2V0TGVnYWxDdXJyZW5jeVN5bWJvbCgpO1xuICAgICAgICBjb25zdCBhc3NldExpc3QgPSBhd2FpdCBQcm9taXNlLmFsbChuZXdEYXRhLm1hcChhc3luYyAoaXRlbSkgPT4ge1xuICAgICAgICAgICAgdHJ5IHtcbiAgICAgICAgICAgICAgICBjb25zdCBzeW1ib2xJY29uID0gYXdhaXQgZ2V0SWNvblVybChpdGVtLnN5bWJvbCk7XG4gICAgICAgICAgICAgICAgY29uc3Qgc3ltYm9sTmFtZSA9IGl0ZW0uc3ltYm9sLnRvVXBwZXJDYXNlKCk7XG4gICAgICAgICAgICAgICAgY29uc3QgY3VycmVuY3lTY2FsZSA9IGl0ZW0uY3VycmVuY3lTY2FsZTtcbiAgICAgICAgICAgICAgICAvL+aAu+adg+ebilxuICAgICAgICAgICAgICAgIGNvbnN0IGVxdWl0eUFtb3VudCA9IGF3YWl0IGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudChzeW1ib2xOYW1lLCBpdGVtLm1hcmdpbkJhbGFuY2UpO1xuICAgICAgICAgICAgICAgIGNvbnN0IGVxdWl0eSA9IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGF3YWl0IGFkZEN1cnJlbnRDdXJyZW5jeVN5bWJvbChlcXVpdHlBbW91bnQpO1xuICAgICAgICAgICAgICAgIC8v5aaC5p6c5pWw6YeP5Li6MO+8jOWxleekuuaIkDAuMDBcbiAgICAgICAgICAgICAgICBjb25zdCBlcXVpdHlOdW1BbW91bnQgPSBpdGVtLm1hcmdpbkJhbGFuY2UgPT0gMCA/IFwiMC4wMFwiIDogYXdhaXQgZm9ybWF0TnVtV2l0aFByZWNpc2lvbihpdGVtLm1hcmdpbkJhbGFuY2UsIGN1cnJlbmN5U2NhbGUpO1xuICAgICAgICAgICAgICAgIGNvbnN0IGVxdWl0eU51bSA9IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGVxdWl0eU51bUFtb3VudDtcbiAgICAgICAgICAgICAgICAvL+mSseWMheS9meminVxuICAgICAgICAgICAgICAgIGNvbnN0IG1hcmdpbkF2YWlsYWJsZUFtb3VudCA9IGl0ZW0ubWFyZ2luQXZhaWxhYmxlID09IDAgPyBcIjAuMDBcIiA6IGF3YWl0IGZvcm1hdE51bVdpdGhQcmVjaXNpb24oaXRlbS5tYXJnaW5BdmFpbGFibGUsIGN1cnJlbmN5U2NhbGUpO1xuICAgICAgICAgICAgICAgIGNvbnN0IG1hcmdpbkF2YWlsYWJsZSA9IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IG1hcmdpbkF2YWlsYWJsZUFtb3VudDtcbiAgICAgICAgICAgICAgICAvL+WPr+i9rFxuICAgICAgICAgICAgICAgIGNvbnN0IHdpdGhkcmF3QXZhaWxhYmxlQW1vdW50ID0gaXRlbS53aXRoZHJhd0F2YWlsYWJsZSA9PSAwID8gXCIwLjAwXCIgOiBhd2FpdCBmb3JtYXROdW1XaXRoUHJlY2lzaW9uKGl0ZW0ud2l0aGRyYXdBdmFpbGFibGUsIGN1cnJlbmN5U2NhbGUpO1xuICAgICAgICAgICAgICAgIGNvbnN0IHdpdGhkcmF3QXZhaWxhYmxlID0gaXNIaWRkZW4gPyBISURERU5fU1RSIDogd2l0aGRyYXdBdmFpbGFibGVBbW91bnQ7XG4gICAgICAgICAgICAgICAgLy/mnKrlrp7njrDnm4jkuo9cbiAgICAgICAgICAgICAgICBjb25zdCBwcm9maXRVbnJlYWxBbW91bnQgPSBpdGVtLnByb2ZpdFVucmVhbCA9PSAwID8gXCIwLjAwXCIgOiBhd2FpdCBmb3JtYXROdW1XaXRoUHJlY2lzaW9uKGl0ZW0ucHJvZml0VW5yZWFsLCBjdXJyZW5jeVNjYWxlKTtcbiAgICAgICAgICAgICAgICBjb25zdCBwcm9maXRVbnJlYWwgPSBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBgJHtwcm9maXRVbnJlYWxBbW91bnQuc3RhcnRzV2l0aCgnLScpID8gJycgOiAnKyd9JHtwcm9maXRVbnJlYWxBbW91bnR9YDtcbiAgICAgICAgICAgICAgICBjb25zdCBwcm9maXRVbnJlYWxSaXNlQ29sb3IgPSBpc0hpZGRlbiA/IGF3YWl0IGdldENvbG9yKCdrQ29sb3JTZWNvbmRhcnlUZXh0JykgOiBhd2FpdCByaXNlQ29sb3IoaXRlbS5wcm9maXRVbnJlYWwpO1xuICAgICAgICAgICAgICAgIC8v5L2T6aqM6YeR5bGV56S6XG4gICAgICAgICAgICAgICAgbGV0IHZvdWNoZXJBdmFpbGFibGUgPSBudWxsO1xuICAgICAgICAgICAgICAgIGxldCB2b3VjaGVyVmlzID0gXCJnb25lXCI7XG4gICAgICAgICAgICAgICAgaWYgKGl0ZW0udm91Y2hlciAhPSBudWxsKSB7XG4gICAgICAgICAgICAgICAgICAgIGNvbnN0IHZvdWNoZXJBbW91bnQgPSBhd2FpdCBmb3JtYXROdW1XaXRoUHJlY2lzaW9uKGl0ZW0udm91Y2hlciwgY3VycmVuY3lTY2FsZSk7XG4gICAgICAgICAgICAgICAgICAgIHZvdWNoZXJBdmFpbGFibGUgPSBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiB2b3VjaGVyQW1vdW50O1xuICAgICAgICAgICAgICAgICAgICB2b3VjaGVyVmlzID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIHJldHVybiB7XG4gICAgICAgICAgICAgICAgICAgIHN5bWJvbEljb24sXG4gICAgICAgICAgICAgICAgICAgIHN5bWJvbE5hbWUsXG4gICAgICAgICAgICAgICAgICAgIGVxdWl0eU51bSxcbiAgICAgICAgICAgICAgICAgICAgZXF1aXR5TnVtQW1vdW50LFxuICAgICAgICAgICAgICAgICAgICBlcXVpdHksXG4gICAgICAgICAgICAgICAgICAgIG1hcmdpbkF2YWlsYWJsZSxcbiAgICAgICAgICAgICAgICAgICAgbWFyZ2luQXZhaWxhYmxlQW1vdW50LFxuICAgICAgICAgICAgICAgICAgICB3aXRoZHJhd0F2YWlsYWJsZSxcbiAgICAgICAgICAgICAgICAgICAgd2l0aGRyYXdBdmFpbGFibGVBbW91bnQsXG4gICAgICAgICAgICAgICAgICAgIHByb2ZpdFVucmVhbCxcbiAgICAgICAgICAgICAgICAgICAgcHJvZml0VW5yZWFsUmlzZUNvbG9yLFxuICAgICAgICAgICAgICAgICAgICB2b3VjaGVyQXZhaWxhYmxlLFxuICAgICAgICAgICAgICAgICAgICB2b3VjaGVyVmlzXG4gICAgICAgICAgICAgICAgfTtcbiAgICAgICAgICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgICAgICAgICBjb25zb2xlLmVycm9yKGB1cGRhdGVDb250cmFjdFVzZHRNVW5pdHlEYXRhIGl0ZW0gJHtlfWApO1xuICAgICAgICAgICAgfVxuXG4gICAgICAgIH0pKTtcbiAgICAgICAgYXZhaWxhYmxlcyA9IGFzc2V0TGlzdDtcbiAgICAgICAgY29uc29sZS5sb2coYHVwZGF0ZUNvbnRyYWN0QWxsRGF0YSB1c2R0TVVuaXR5YCk7XG4gICAgICAgICRkYXRhLnVzZHRNQWxsQXNzZXRMaXN0ID0gSlNPTi5zdHJpbmdpZnkoYXNzZXRMaXN0KTtcbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUuZXJyb3IoYHVwZGF0ZUNvbnRyYWN0VXNkdE1Vbml0eURhdGEgQVIke2V9YCk7XG4gICAgfVxufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gdXBkYXRlQ29udHJhY3RBbGxEYXRhKHR5cGUsIG9sZExpc3QpIHtcbiAgICB0cnkge1xuICAgICAgICBjb25zdCBkYXRhID0gW107XG4gICAgICAgIGxldCBuZXdEYXRhID0gW107XG4gICAgICAgIGxldCBtYXJnaW5Dcm9zcztcbiAgICAgICAgY29uc29sZS5sb2coYHVwZGF0ZUNvbnRyYWN0QWxsRGF0YSAke3R5cGV9YCk7XG4gICAgICAgIHN3aXRjaCAodHlwZSkge1xuICAgICAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLnVzZHRNOlxuICAgICAgICAgICAgICAgIGNvbnN0IHVzZHRMaXN0ID0gW107XG4gICAgICAgICAgICAgICAgY29uc3QgdXNkdE1TZWFjaEtleSA9IGNhY2hlRGF0YS5jb250cmFjdC51c2R0X20uYWxsLnNlYXJjaEtleTtcbiAgICAgICAgICAgICAgICBjb25zdCB1c2R0TUhpZGRlblNtYWxsQXNzZXQgPSBjYWNoZURhdGEuY29udHJhY3QudXNkdF9tLmFsbC5oaWRkZW5TbWFsbEFzc2V0O1xuICAgICAgICAgICAgICAgIGF3YWl0IFByb21pc2UuYWxsKG9sZExpc3QubWFwKGFzeW5jIChpdGVtKSA9PiB7XG4gICAgICAgICAgICAgICAgICAgIGlmIChpdGVtLm1hcmdpbk1vZGUgPT09ICdjcm9zcycpIHtcbiAgICAgICAgICAgICAgICAgICAgICAgIGl0ZW0uc2Vjb25kU3ltYm9sTmFtZSA9IGF3YWl0IGdldFdvcmQoXCJuX2NvbnRyYWN0X3N1cGVyX21hcmdpblwiKTtcbiAgICAgICAgICAgICAgICAgICAgICAgIHVzZHRMaXN0LnB1c2goaXRlbSk7XG4gICAgICAgICAgICAgICAgICAgIH0gZWxzZSBpZiAoYXdhaXQgaXRlbVNob3VsZFNob3coaXRlbS5zeW1ib2wsIGl0ZW0uc3ltYm9sLCBpdGVtLm1hcmdpbkJhbGFuY2UsIHVzZHRNSGlkZGVuU21hbGxBc3NldCwgdXNkdE1TZWFjaEtleSkpIHtcbiAgICAgICAgICAgICAgICAgICAgICAgIGRhdGEucHVzaChpdGVtKTtcbiAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIH0pKTtcbiAgICAgICAgICAgICAgICBjb25zdCBzb3J0ZWQgPSBhd2FpdCBzb3J0TGlzdChkYXRhLCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRGb3JDb250cmFjdEFsbFVzZHRNKTtcbiAgICAgICAgICAgICAgICBuZXdEYXRhID0gWy4uLnVzZHRMaXN0LCAuLi5zb3J0ZWRdO1xuICAgICAgICAgICAgICAgIGNhY2hlRGF0YS5jb250cmFjdC51c2R0X20uYWxsLm5ld0xpc3QgPSBuZXdEYXRhO1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmNvaW5QOlxuICAgICAgICAgICAgICAgIGNvbnN0IGNvaW5QU2VhcmNoS2V5ID0gY2FjaGVEYXRhLmNvbnRyYWN0LmNvaW5fcC5hbGwuc2VhcmNoS2V5O1xuICAgICAgICAgICAgICAgIGNvbnN0IGNvaW5QSGlkZGVuU21hbGxBc3NldCA9IGNhY2hlRGF0YS5jb250cmFjdC5jb2luX3AuYWxsLmhpZGRlblNtYWxsQXNzZXQ7XG4gICAgICAgICAgICAgICAgYXdhaXQgUHJvbWlzZS5hbGwob2xkTGlzdC5tYXAoYXN5bmMgKGl0ZW0pID0+IHtcbiAgICAgICAgICAgICAgICAgICAgaWYgKGF3YWl0IGl0ZW1TaG91bGRTaG93KGl0ZW0uc3ltYm9sLCBpdGVtLnN5bWJvbCwgaXRlbS5tYXJnaW5CYWxhbmNlLCBjb2luUEhpZGRlblNtYWxsQXNzZXQsIGNvaW5QU2VhcmNoS2V5KSkge1xuICAgICAgICAgICAgICAgICAgICAgICAgZGF0YS5wdXNoKGl0ZW0pO1xuICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgfSkpO1xuICAgICAgICAgICAgICAgIG5ld0RhdGEgPSBhd2FpdCBzb3J0TGlzdChkYXRhLCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRGb3JDb250cmFjdEFsbCk7XG4gICAgICAgICAgICAgICAgY2FjaGVEYXRhLmNvbnRyYWN0LmNvaW5fcC5hbGwubmV3TGlzdCA9IG5ld0RhdGE7XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuY29pbkZ1dHVyZXM6XG4gICAgICAgICAgICAgICAgY29uc3Qgc2VhcmNoS2V5ID0gY2FjaGVEYXRhLmNvbnRyYWN0LmNvaW5fZi5hbGwuc2VhcmNoS2V5O1xuICAgICAgICAgICAgICAgIGNvbnN0IGhpZGRlblNtYWxsQXNzZXQgPSBjYWNoZURhdGEuY29udHJhY3QuY29pbl9mLmFsbC5oaWRkZW5TbWFsbEFzc2V0O1xuICAgICAgICAgICAgICAgIGF3YWl0IFByb21pc2UuYWxsKG9sZExpc3QubWFwKGFzeW5jIChpdGVtKSA9PiB7XG4gICAgICAgICAgICAgICAgICAgIGlmIChhd2FpdCBpdGVtU2hvdWxkU2hvdyhpdGVtLnN5bWJvbCwgaXRlbS5zeW1ib2wsIGl0ZW0ubWFyZ2luQmFsYW5jZSwgaGlkZGVuU21hbGxBc3NldCwgc2VhcmNoS2V5KSkge1xuICAgICAgICAgICAgICAgICAgICAgICAgZGF0YS5wdXNoKGl0ZW0pO1xuICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgfSkpO1xuICAgICAgICAgICAgICAgIG5ld0RhdGEgPSBhd2FpdCBzb3J0TGlzdChkYXRhLCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRGb3JDb250cmFjdEFsbCk7XG4gICAgICAgICAgICAgICAgY2FjaGVEYXRhLmNvbnRyYWN0LmNvaW5fZi5hbGwubmV3TGlzdCA9IG5ld0RhdGE7XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIH1cblxuICAgICAgICBjb25zdCBjdXJyZW5jeVN5bWJvbCA9IGF3YWl0IGdldExlZ2FsQ3VycmVuY3lTeW1ib2woKTtcbiAgICAgICAgY29uc3QgYXNzZXRMaXN0ID0gYXdhaXQgUHJvbWlzZS5hbGwobmV3RGF0YS5tYXAoYXN5bmMgKGl0ZW0pID0+IHtcbiAgICAgICAgICAgIHRyeSB7XG4gICAgICAgICAgICAgICAgY29uc3Qgc3ltYm9sSWNvbiA9IGF3YWl0IGdldEljb25VcmwoaXRlbS5zeW1ib2wpO1xuICAgICAgICAgICAgICAgIGNvbnN0IHN5bWJvbE5hbWUgPSBpdGVtLnN5bWJvbC50b1VwcGVyQ2FzZSgpO1xuICAgICAgICAgICAgICAgIGxldCBzZWNvbmRTeW1ib2xOYW1lO1xuICAgICAgICAgICAgICAgIGlmIChpdGVtLnNlY29uZFN5bWJvbE5hbWUpIHtcbiAgICAgICAgICAgICAgICAgICAgc2Vjb25kU3ltYm9sTmFtZSA9IGl0ZW0uc2Vjb25kU3ltYm9sTmFtZTtcbiAgICAgICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICBpZiAodHlwZSA9PSBEaXN0cmlidXRpb25UeXBlLnVzZHRNKSB7XG4gICAgICAgICAgICAgICAgICAgICAgICBjb25zdCBzZWNvbmRTeW1ib2wgPSBhd2FpdCBnZXRDb250cmFjdFNlY29uZFN5bWJvbChpdGVtLmNvbnRyYWN0Q29kZSk7XG4gICAgICAgICAgICAgICAgICAgICAgICBpZiAoc2Vjb25kU3ltYm9sICE9PSAnJykge1xuICAgICAgICAgICAgICAgICAgICAgICAgICAgIHNlY29uZFN5bWJvbE5hbWUgPSBgLyR7c2Vjb25kU3ltYm9sfWA7XG4gICAgICAgICAgICAgICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICAgICAgICAgIHNlY29uZFN5bWJvbE5hbWUgPSAnL1VTRFQnO1xuICAgICAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgICAgICAgICAgc2Vjb25kU3ltYm9sTmFtZSA9ICcvVVNEJztcbiAgICAgICAgICAgICAgICAgICAgfVxuXG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIGxldCBzcG90TnVtYmVyRXF1aXZhbGVudDtcbiAgICAgICAgICAgICAgICBpZiAodHlwZSA9PSBEaXN0cmlidXRpb25UeXBlLnVzZHRNKSB7XG4gICAgICAgICAgICAgICAgICAgIHNwb3ROdW1iZXJFcXVpdmFsZW50ID0gaXNIaWRkZW4gPyBISURERU5fU1RSIDogZml4UmF0ZShpdGVtLnJpc2tSYXRlKTtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICAgICAgICAgIHNwb3ROdW1iZXJFcXVpdmFsZW50ID0gaXNIaWRkZW4gPyBISURERU5fU1RSIDogZml4UmF0ZUZpeGVkKGl0ZW0ubmV3Umlza1JhdGUsIDQpO1xuICAgICAgICAgICAgICAgIH1cblxuICAgICAgICAgICAgICAgIGNvbnN0IGF2YWlsYWJsZSA9IGF3YWl0IGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudChpdGVtLnN5bWJvbCwgaXRlbS5tYXJnaW5BdmFpbGFibGUpO1xuICAgICAgICAgICAgICAgIGNvbnN0IGF2YWlsYWJsZUFtb3VudCA9IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGFkZEN1cnJlbmN5U3ltYm9sKGN1cnJlbmN5U3ltYm9sLCBhdmFpbGFibGUpO1xuXG4gICAgICAgICAgICAgICAgY29uc3Qgc3BvdFlpZWxkID0gaXNIaWRkZW4gPyBISURERU5fU1RSIDogYXdhaXQgZ2V0UHJlQ3VycmVuY3lBbW91bnQoaXRlbS5zeW1ib2wsIGl0ZW0ubWFyZ2luQmFsYW5jZSk7XG4gICAgICAgICAgICAgICAgY29uc3QgZXF1YWxMZWdhbEFtb3VudCA9IGF3YWl0IGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudCh0eXBlID09IERpc3RyaWJ1dGlvblR5cGUudXNkdE0gPyBTeW1ib2xzLnVzZHQgOiBpdGVtLnN5bWJvbCwgaXRlbS5tYXJnaW5CYWxhbmNlKTtcbiAgICAgICAgICAgICAgICBjb25zdCBzcG90WWllbGRSYXRlID0gaXNIaWRkZW4gPyBISURERU5fU1RSIDogYWRkQ3VycmVuY3lTeW1ib2woY3VycmVuY3lTeW1ib2wsIGVxdWFsTGVnYWxBbW91bnQpO1xuICAgICAgICAgICAgICAgIGNvbnN0IHNwb3RSaXNlQ29sb3IgPSBpc0hpZGRlbiA/IGF3YWl0IGdldENvbG9yKCdrQ29sb3JTZWNvbmRhcnlUZXh0JykgOiBhd2FpdCByaXNlQ29sb3Ioc3BvdFlpZWxkUmF0ZSk7XG4gICAgICAgICAgICAgICAgcmV0dXJuIHtcbiAgICAgICAgICAgICAgICAgICAgc3ltYm9sSWNvbixcbiAgICAgICAgICAgICAgICAgICAgc3ltYm9sTmFtZSxcbiAgICAgICAgICAgICAgICAgICAgc2Vjb25kU3ltYm9sTmFtZSxcbiAgICAgICAgICAgICAgICAgICAgc3BvdE51bWJlckVxdWl2YWxlbnQsXG4gICAgICAgICAgICAgICAgICAgIHNwb3RZaWVsZCxcbiAgICAgICAgICAgICAgICAgICAgYXZhaWxhYmxlQW1vdW50LFxuICAgICAgICAgICAgICAgICAgICBzcG90WWllbGRSYXRlLFxuICAgICAgICAgICAgICAgICAgICBzcG90UmlzZUNvbG9yXG4gICAgICAgICAgICAgICAgfTtcbiAgICAgICAgICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgICAgICAgICBjb25zb2xlLmVycm9yKGB1cGRhdGVDb250cmFjdEFsbERhdGEgaXRlbSAke2V9YCk7XG4gICAgICAgICAgICB9XG5cbiAgICAgICAgfSkpO1xuICAgICAgICBzd2l0Y2ggKHR5cGUpIHtcbiAgICAgICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS51c2R0TTpcbiAgICAgICAgICAgICAgICBjb25zb2xlLmxvZyhgdXBkYXRlQ29udHJhY3RBbGxEYXRhIHVzZHRNYCk7XG4gICAgICAgICAgICAgICAgJGRhdGEudXNkdE1BbGxBc3NldExpc3QgPSBKU09OLnN0cmluZ2lmeShhc3NldExpc3QpO1xuICAgICAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmNvaW5QOlxuICAgICAgICAgICAgICAgIGNvbnNvbGUubG9nKGB1cGRhdGVDb250cmFjdEFsbERhdGEgY29pblBgKTtcbiAgICAgICAgICAgICAgICAkZGF0YS5jb2luUEFsbEFzc2V0TGlzdCA9IEpTT04uc3RyaW5naWZ5KGFzc2V0TGlzdCk7XG4gICAgICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuY29pbkZ1dHVyZXM6XG4gICAgICAgICAgICAgICAgY29uc29sZS5sb2coYHVwZGF0ZUNvbnRyYWN0QWxsRGF0YSBjb2luRnV0dXJlc2ApO1xuICAgICAgICAgICAgICAgICRkYXRhLmNvaW5NQWxsQXNzZXRMaXN0ID0gSlNPTi5zdHJpbmdpZnkoYXNzZXRMaXN0KTtcbiAgICAgICAgICAgICAgICBicmVhaztcbiAgICAgICAgfVxuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5lcnJvcihgdXBkYXRlQ29udHJhY3RBbGxEYXRhICR7ZX1gKTtcbiAgICB9XG5cbn1cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiB1cGRhdGVDb250cmFjdE93bmVkRGF0YSh0eXBlLCBvbGRMaXN0KSB7XG4gICAgY29uc29sZS5sb2coYHVwZGF0ZUNvbnRyYWN0T3duZWREYXRhICR7dHlwZX1gKTtcbiAgICBjb25zdCBkYXRhID0gW107XG4gICAgbGV0IG5ld0RhdGEgPSBbXTtcbiAgICBzd2l0Y2ggKHR5cGUpIHtcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLnVzZHRNOlxuICAgICAgICAgICAgY29uc3QgdXNkdE1TZWFjaEtleSA9IGNhY2hlRGF0YS5jb250cmFjdC51c2R0X20ub3duZWQuc2VhcmNoS2V5O1xuICAgICAgICAgICAgY29uc3QgdXNkdE1IaWRkZW5TbWFsbEFzc2V0ID0gY2FjaGVEYXRhLmNvbnRyYWN0LnVzZHRfbS5vd25lZC5oaWRkZW5TbWFsbEFzc2V0O1xuICAgICAgICAgICAgYXdhaXQgUHJvbWlzZS5hbGwob2xkTGlzdC5tYXAoYXN5bmMgKGl0ZW0pID0+IHtcbiAgICAgICAgICAgICAgICBpZiAoYXdhaXQgaXRlbVNob3VsZFNob3coaXRlbS5zeW1ib2wsIGl0ZW0uc3ltYm9sLCBpdGVtLnByb2ZpdCwgdXNkdE1IaWRkZW5TbWFsbEFzc2V0LCB1c2R0TVNlYWNoS2V5KSkge1xuICAgICAgICAgICAgICAgICAgICBkYXRhLnB1c2goaXRlbSk7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgfSkpO1xuICAgICAgICAgICAgbmV3RGF0YSA9IGF3YWl0IHNvcnRMaXN0KGRhdGEsIGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudEZvckNvbnRyYWN0T3duZWQpO1xuICAgICAgICAgICAgY2FjaGVEYXRhLmNvbnRyYWN0LnVzZHRfbS5vd25lZC5uZXdMaXN0ID0gbmV3RGF0YTtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuY29pblA6XG4gICAgICAgICAgICBjb25zdCBjb2luUFNlYXJjaEtleSA9IGNhY2hlRGF0YS5jb250cmFjdC5jb2luX3Aub3duZWQuc2VhcmNoS2V5O1xuICAgICAgICAgICAgY29uc3QgY29pblBIaWRkZW5TbWFsbEFzc2V0ID0gY2FjaGVEYXRhLmNvbnRyYWN0LmNvaW5fcC5vd25lZC5oaWRkZW5TbWFsbEFzc2V0O1xuICAgICAgICAgICAgYXdhaXQgUHJvbWlzZS5hbGwob2xkTGlzdC5tYXAoYXN5bmMgKGl0ZW0pID0+IHtcbiAgICAgICAgICAgICAgICBpZiAoYXdhaXQgaXRlbVNob3VsZFNob3coaXRlbS5zeW1ib2wsIGl0ZW0uc3ltYm9sLCBpdGVtLnByb2ZpdCwgY29pblBIaWRkZW5TbWFsbEFzc2V0LCBjb2luUFNlYXJjaEtleSkpIHtcbiAgICAgICAgICAgICAgICAgICAgZGF0YS5wdXNoKGl0ZW0pO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH0pKTtcbiAgICAgICAgICAgIG5ld0RhdGEgPSBhd2FpdCBzb3J0TGlzdChkYXRhLCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRGb3JDb250cmFjdE93bmVkKTtcbiAgICAgICAgICAgIGNhY2hlRGF0YS5jb250cmFjdC5jb2luX3Aub3duZWQubmV3TGlzdCA9IG5ld0RhdGE7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmNvaW5GdXR1cmVzOlxuICAgICAgICAgICAgY29uc3Qgc2VhcmNoS2V5ID0gY2FjaGVEYXRhLmNvbnRyYWN0LmNvaW5fZi5vd25lZC5zZWFyY2hLZXk7XG4gICAgICAgICAgICBjb25zdCBoaWRkZW5TbWFsbEFzc2V0ID0gY2FjaGVEYXRhLmNvbnRyYWN0LmNvaW5fZi5vd25lZC5oaWRkZW5TbWFsbEFzc2V0O1xuICAgICAgICAgICAgYXdhaXQgUHJvbWlzZS5hbGwob2xkTGlzdC5tYXAoYXN5bmMgKGl0ZW0pID0+IHtcbiAgICAgICAgICAgICAgICBpZiAoYXdhaXQgaXRlbVNob3VsZFNob3coaXRlbS5zeW1ib2wsIGl0ZW0uc3ltYm9sLCBpdGVtLnByb2ZpdCwgaGlkZGVuU21hbGxBc3NldCwgc2VhcmNoS2V5KSkge1xuICAgICAgICAgICAgICAgICAgICBkYXRhLnB1c2goaXRlbSk7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgfSkpO1xuICAgICAgICAgICAgbmV3RGF0YSA9IGF3YWl0IHNvcnRMaXN0KGRhdGEsIGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudEZvckNvbnRyYWN0T3duZWQpO1xuICAgICAgICAgICAgY2FjaGVEYXRhLmNvbnRyYWN0LmNvaW5fZi5vd25lZC5uZXdMaXN0ID0gbmV3RGF0YTtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgIH1cblx0Y29uc3QgZ3JlZW5SaXNlID0gYXdhaXQgdXBzQW5kRG93bnNDb2xvcigpO1xuICAgIGNvbnN0IGFzc2V0TGlzdCA9IGF3YWl0IFByb21pc2UuYWxsKG5ld0RhdGEubWFwKGFzeW5jIChpdGVtKSA9PiB7XG4gICAgICAgIHRyeSB7XG4gICAgICAgICAgICBsZXQgbG9uZ09yU2hvcnRDb2xvcjtcbiAgICAgICAgICAgIGxldCBsb25nT3JTaG9ydEJhY2tHcm91bmRDb2xvciA9IDA7XG4gICAgICAgICAgICBsZXQgYnV5T3JTZWxsQmFja0dyb3VuZENvbG9yID0gMDtcbiAgICAgICAgICAgIGxldCBsb25nT3JTaG9ydCA9IFwiXCI7XG5cdFx0XHRsZXQgYnV5T3JTZWxsID0gXCJcIjtcbiAgICAgICAgICAgIGlmIChpdGVtLmRpcmVjdGlvbiA9PT0gXCJidXlcIikge1xuXHRcdFx0XHRsb25nT3JTaG9ydENvbG9yID0gXCJAY29sb3IvdHJhZGVfdGFnX3RleHRfY29sb3JcIjtcbiAgICAgICAgICAgICAgICBsb25nT3JTaG9ydEJhY2tHcm91bmRDb2xvciA9IFwiQGNvbG9yL3RyYWRlX3RhZ190ZXh0X2JnXCI7XG4gICAgICAgICAgICAgICAgYnV5T3JTZWxsQmFja0dyb3VuZENvbG9yID0gcmlzZUNvbG9yVjIoMSwgZ3JlZW5SaXNlKTtcbiAgICAgICAgICAgICAgICBidXlPclNlbGwgPSBpc0NoaW5lc2UoKSA/IFwi5LmwXCIgOiBcIkJcIjtcblx0XHRcdFx0bG9uZ09yU2hvcnQgPSAkaTE4bi5uX2Fzc2V0X2Z1dHVyZV9idXk7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBlbHNlIHtcblx0XHRcdFx0bG9uZ09yU2hvcnRDb2xvciA9IFwiQGNvbG9yL3RyYWRlX3N0X2NvbG9yXCI7XG4gICAgICAgICAgICAgICAgbG9uZ09yU2hvcnRCYWNrR3JvdW5kQ29sb3IgPSBcIkBjb2xvci90cmFkZV9zdF9jb2xvcl9iZ1wiO1xuICAgICAgICAgICAgICAgIGJ1eU9yU2VsbEJhY2tHcm91bmRDb2xvciA9IHJpc2VDb2xvclYyKC0xLCBncmVlblJpc2UpO1xuICAgICAgICAgICAgICAgIGJ1eU9yU2VsbCA9IGlzQ2hpbmVzZSgpID8gXCLljZZcIiA6IFwiU1wiO1xuXHRcdFx0XHRsb25nT3JTaG9ydCA9ICRpMThuLm5fYXNzZXRfZnV0dXJlX3NlbGw7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBjb25zdCBzeW1ib2xOYW1lID0gaXRlbS5zeW1ib2wudG9VcHBlckNhc2UoKTtcbiAgICAgICAgICAgIGxldCBpc29sYXRlZDtcbiAgICAgICAgICAgIGlmIChpdGVtLm1hcmdpbk1vZGUgPT0gJ2Nyb3NzJykge1xuICAgICAgICAgICAgICAgIGlzb2xhdGVkID0gJGkxOG4ubl9jb250cmFjdF9zdXBlcl9tYXJnaW47XG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgIGlzb2xhdGVkID0gJGkxOG4ubl9jb250cmFjdF90cmFkZV9tYXJnaW47XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBjb25zdCBpc29sYXRlZE51bWJlciA9IGAke2l0ZW0ubGV2ZXJSYXRlfVhgO1xuICAgICAgICAgICAgbGV0IGlzb2xhdGVkTmFtZTtcbiAgICAgICAgICAgIGlmICgnc3dhcCcgPT0gaXRlbS5jb250cmFjdFR5cGUpIHtcbiAgICAgICAgICAgICAgICBpc29sYXRlZE5hbWUgPSAkaTE4bi5uX21hcmtldF9jb250cmFjdF9zd2FwX3RyYWRlX25hbWVfYWJicjs7XG4gICAgICAgICAgICB9IGVsc2UgaWYgKCd0aGlzX3dlZWsnID09IGl0ZW0uY29udHJhY3RUeXBlKSB7XG4gICAgICAgICAgICAgICAgaXNvbGF0ZWROYW1lID0gJGkxOG4ubl9tYXJrZXRfY29udHJhY3Rfc3ltYm9sX3RoaXN3ZWVrX2FiYnI7XG4gICAgICAgICAgICB9IGVsc2UgaWYgKCduZXh0X3dlZWsnID09IGl0ZW0uY29udHJhY3RUeXBlKSB7XG4gICAgICAgICAgICAgICAgaXNvbGF0ZWROYW1lID0gJGkxOG4ubl9tYXJrZXRfY29udHJhY3Rfc3ltYm9sX25leHR3ZWVrX2FiYnI7XG4gICAgICAgICAgICB9IGVsc2UgaWYgKCdxdWFydGVyJyA9PSBpdGVtLmNvbnRyYWN0VHlwZSkge1xuICAgICAgICAgICAgICAgIGlzb2xhdGVkTmFtZSA9ICRpMThuLm5fbWFya2V0X2NvbnRyYWN0X3N5bWJvbF9xdWFydGVyX2FiYnI7XG4gICAgICAgICAgICB9IGVsc2UgaWYgKCduZXh0XyBxdWFydGVyJyA9PSBpdGVtLmNvbnRyYWN0VHlwZSkge1xuICAgICAgICAgICAgICAgIGlzb2xhdGVkTmFtZSA9ICRpMThuLm5fbWFya2V0X2NvbnRyYWN0X3N5bWJvbF9uZXh0d2Vla19hYmJyO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgbGV0IHNlY29uZFN5bWJvbE5hbWU7XG5cdFx0XHRsZXQgc3ltYm9sTmFtZUZ1bGw7XG4gICAgICAgICAgICBpZiAodHlwZSA9PSBEaXN0cmlidXRpb25UeXBlLnVzZHRNKSB7XG4gICAgICAgICAgICAgICAgY29uc3Qgc2Vjb25kU3ltYm9sID0gYXdhaXQgZ2V0Q29udHJhY3RTZWNvbmRTeW1ib2woaXRlbS5jb250cmFjdENvZGUpO1xuICAgICAgICAgICAgICAgIGlmIChzZWNvbmRTeW1ib2wgIT09ICcnKSB7XG4gICAgICAgICAgICAgICAgICAgIHNlY29uZFN5bWJvbE5hbWUgPSBgLyR7c2Vjb25kU3ltYm9sfWA7XG5cdFx0XHRcdFx0c3ltYm9sTmFtZUZ1bGwgPSBgJHtzeW1ib2xOYW1lfSR7c2Vjb25kU3ltYm9sfWA7XG4gICAgICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICAgICAgc2Vjb25kU3ltYm9sTmFtZSA9ICcvVVNEVCc7XG5cdFx0XHRcdFx0c3ltYm9sTmFtZUZ1bGwgPSBzeW1ib2xOYW1lICsgJ1VTRFQnO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgc2Vjb25kU3ltYm9sTmFtZSA9ICcvVVNEJztcblx0XHRcdFx0c3ltYm9sTmFtZUZ1bGwgPSBzeW1ib2xOYW1lICsgJ1VTRCc7XG4gICAgICAgICAgICB9XG5cdFx0XHRjb25zdCBvcGVuQWRsID0gaXRlbS5vcGVuQWRsICYmIGl0ZW0ub3BlbkFkbCA9PSAxID8gXCJ2aXNpYmxlXCIgOiBcImdvbmVcIjtcblx0XHRcdGxldCBhZGxSaXNrU3JjID0gXCJAZHJhd2FibGUvYWRsX3BlcmNlbnRfaWNvbl8xXCI7XG5cdFx0XHRpZiAoaXRlbS5hZGxSaXNrUGVyY2VudCkge1xuXHRcdFx0XHRhZGxSaXNrU3JjID0gYEBkcmF3YWJsZS9hZGxfcGVyY2VudF9pY29uXyR7aXRlbS5hZGxSaXNrUGVyY2VudH1gO1xuXHRcdFx0fVxuICAgICAgICAgIGNvbnN0IHByZWZpeCA9IHByb2ZpdFByZWZpeChpdGVtLnByb2ZpdCk7XG4gICAgICAgICAgY29uc3QgcmF3UHJvZml0ID0gcmVtb3ZlVHJhaWxpbmdaZXJvZXMoYXdhaXQgZm9ybWF0TnVtV2l0aFByZWNpc2lvbihpdGVtLnByb2ZpdCwgNCkpO1xuICAgICAgICAgIGNvbnN0IHByb2ZpdCA9IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGAke3ByZWZpeH0ke3Jhd1Byb2ZpdH1gO1xuICAgICAgICAgIGNvbnN0IHNwb3ROdW1iZXJFcXVpdmFsZW50ID0gaXNIaWRkZW4gPyBISURERU5fU1RSIDogYCR7cHJlZml4fSR7YXdhaXQgYWRkQ3VycmVudEN1cnJlbmN5U3ltYm9sKGF3YWl0IGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudChTeW1ib2xzLnVzZHQsIGl0ZW0ucHJvZml0KSl9YDtcbiAgICAgICAgICBjb25zdCBzcG90WWllbGQgPSBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBgJHtwcmVmaXh9JHtmaXhSYXRlKGl0ZW0ucHJvZml0UmF0ZSl9YDtcbiAgICAgICAgICAgIGNvbnN0IGlzUmlzayA9IFwiZ29uZVwiO1xuICAgICAgICAgICAgY29uc3Qgc3VmZml4ID0gdHlwZSA9PSBEaXN0cmlidXRpb25UeXBlLnVzZHRNID8gJ1VTRFQnIDogJ1VTRCc7XG4gICAgICAgICAgICBjb25zdCBjdXJyZW5jeVN1ZmZpeCA9IHR5cGUgPT0gRGlzdHJpYnV0aW9uVHlwZS51c2R0TSA/ICdVU0RUJyA6IHN5bWJvbE5hbWU7XG4gICAgICAgICAgICBjb25zdCBjb250cmFjdFRpdGxlMV8xID0gYCR7JGkxOG4ubl9vcHRpb25fbWFya2V0X2xpc3Rfc2V0dGluZ19wb3NpdGlvbl92b2x1bWV9KCR7Y3VycmVuY3lTdWZmaXh9KWA7XG4gICAgICAgICAgICBjb25zdCBjb250cmFjdFRpdGxlMl8xID0gaXNIaWRkZW4gPyBISURERU5fU1RSIDogYXdhaXQgZ2V0Q29udHJhY3ROdW1iZXIoaXRlbS5zeW1ib2wsIGl0ZW0uY29udHJhY3RDb2RlLCBpdGVtLnZvbHVtZSwgdHlwZSwgaXRlbS5sYXN0UHJpY2UpO1xuICAgICAgICAgICAgY29uc3QgY29udHJhY3RUaXRsZTNfMSA9IGAkeyRpMThuLm5fY29udGFyY3RfcG9zaXRpb25fY29zdF9vcGVuX2xhYmVsMn0oJHtzdWZmaXh9KWA7XG4gICAgICAgICAgICBjb25zdCBjb250cmFjdFRpdGxlNF8xID0gaXNIaWRkZW4gPyBISURERU5fU1RSIDogYXdhaXQgZ2V0UHJlQ3VycmVuY3lBbW91bnQoU3ltYm9scy51c2R0LCBpdGVtLmNvc3RPcGVuKTtcbiAgICAgICAgICAgIGNvbnN0IGNvbnRyYWN0VGl0bGUxXzIgPSBhd2FpdCBnZXRXb3JkRm9ybWF0KFwibl9jb250YXJjdF9wb3NpdGlvbl9vcmlnaW5hbF9tYXJnaW5cIiwgc3VmZml4KTtcbiAgICAgICAgICAgIGNvbnN0IGNvbnRyYWN0VGl0bGUyXzIgPSBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBhd2FpdCBnZXRQcmVDdXJyZW5jeUFtb3VudChTeW1ib2xzLnVzZHQsIGl0ZW0ucG9zaXRpb25NYXJnaW4pO1xuXG4gICAgICAgICAgICBjb25zdCBjb250cmFjdFRpdGxlM18yID0gYCR7JGkxOG4ubl9jb250cmFjdF9sYXN0X3ByaWNlfSgke3N1ZmZpeH0pYDtcbiAgICAgICAgICAgIGNvbnN0IGNvbnRyYWN0VGl0bGU0XzIgPSBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBgJHtpdGVtLmxhc3RQcmljZX1gO1xuXG4gICAgICAgICAgICBjb25zdCBjb250cmFjdFRpdGxlMV8zID0gJGkxOG4ubl9hc3NldF9tYXJnaW5fcmF0ZTtcbiAgICAgICAgICAgIGNvbnN0IGNvbnRyYWN0VGl0bGUyXzMgPSBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBmaXhSYXRlRml4ZWQoaXRlbS5yaXNrUmF0ZSwgNCk7XG5cbiAgICAgICAgICAgIGNvbnN0IGNvbnRyYWN0VGl0bGUzXzMgPSBgJHskaTE4bi5uX2JhbGFuY2VfY29udHJhY3RfcHJlZGljdGlvbl9vZl9zdHJvbmdfcGFyaXR5fSgke3N1ZmZpeH0pYDtcbiAgICAgICAgICAgIGNvbnN0IGNvbnRyYWN0VGl0bGU0XzMgPSBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBpdGVtLmxpcXVpZGF0aW9uUHJpY2UgPyBgJHtpdGVtLmxpcXVpZGF0aW9uUHJpY2V9YCA6ICctLSc7XG4gICAgICAgICAgICBjb25zdCBzcG90UmlzZUNvbG9yID0gaXNIaWRkZW4gPyBcIkBjb2xvci9rQ29sb3JTZWNvbmRhcnlUZXh0XCIgOiByaXNlQ29sb3JWMihzcG90WWllbGQsIGdyZWVuUmlzZSk7XG4gICAgICAgICAgICByZXR1cm4ge1xuICAgICAgICAgICAgICAgIGxvbmdPclNob3J0Q29sb3IsXG4gICAgICAgICAgICAgICAgbG9uZ09yU2hvcnRCYWNrR3JvdW5kQ29sb3IsXG4gICAgICAgICAgICAgICAgYnV5T3JTZWxsQmFja0dyb3VuZENvbG9yLFxuICAgICAgICAgICAgICAgIGxvbmdPclNob3J0LFxuICAgICAgICAgICAgICAgIGJ1eU9yU2VsbCxcbiAgICAgICAgICAgICAgICBpc29sYXRlZCxcbiAgICAgICAgICAgICAgICBpc29sYXRlZE51bWJlcixcbiAgICAgICAgICAgICAgICBpc29sYXRlZE5hbWUsXG4gICAgICAgICAgICAgICAgc3BvdE51bWJlckVxdWl2YWxlbnQsXG4gICAgICAgICAgICAgICAgc3BvdFlpZWxkLFxuICAgICAgICAgICAgICAgIGlzUmlzayxcbiAgICAgICAgICAgICAgICBjb250cmFjdFRpdGxlMV8xLFxuICAgICAgICAgICAgICAgIGNvbnRyYWN0VGl0bGUyXzEsXG4gICAgICAgICAgICAgICAgY29udHJhY3RUaXRsZTNfMSxcbiAgICAgICAgICAgICAgICBjb250cmFjdFRpdGxlNF8xLFxuICAgICAgICAgICAgICAgIGNvbnRyYWN0VGl0bGUxXzIsXG4gICAgICAgICAgICAgICAgY29udHJhY3RUaXRsZTJfMixcbiAgICAgICAgICAgICAgICBjb250cmFjdFRpdGxlM18yLFxuICAgICAgICAgICAgICAgIGNvbnRyYWN0VGl0bGU0XzIsXG4gICAgICAgICAgICAgICAgY29udHJhY3RUaXRsZTFfMyxcbiAgICAgICAgICAgICAgICBjb250cmFjdFRpdGxlMl8zLFxuICAgICAgICAgICAgICAgIGNvbnRyYWN0VGl0bGUzXzMsXG4gICAgICAgICAgICAgICAgY29udHJhY3RUaXRsZTRfMyxcbiAgICAgICAgICAgICAgICBzeW1ib2xOYW1lLFxuICAgICAgICAgICAgICAgIHNlY29uZFN5bWJvbE5hbWUsXG4gICAgICAgICAgICAgICAgc3ltYm9sTmFtZUZ1bGwsXG4gICAgICAgICAgICAgICAgc3BvdFJpc2VDb2xvcixcbiAgICAgICAgICAgICAgICBwcm9maXQsXG4gICAgICAgICAgICAgICAgb3BlbkFkbCxcbiAgICAgICAgICAgICAgICBhZGxSaXNrU3JjXG4gICAgICAgICAgICB9O1xuICAgICAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgdXBkYXRlQ29udHJhY3RPd25lZERhdGEgaXRlbSAke2V9YCk7XG4gICAgICAgIH1cbiAgICB9KSk7XG4gICAgc3dpdGNoICh0eXBlKSB7XG4gICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS51c2R0TTpcbiAgICAgICAgICAgICRkYXRhLnVzZHRNT3duQXNzZXRMaXN0ID0gSlNPTi5zdHJpbmdpZnkoYXNzZXRMaXN0KTtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuY29pblA6XG4gICAgICAgICAgICAkZGF0YS5jb2luUE93bkFzc2V0TGlzdCA9IEpTT04uc3RyaW5naWZ5KGFzc2V0TGlzdCk7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmNvaW5GdXR1cmVzOlxuICAgICAgICAgICAgJGRhdGEuY29pbk1Pd25Bc3NldExpc3QgPSBKU09OLnN0cmluZ2lmeShhc3NldExpc3QpO1xuICAgICAgICAgICAgYnJlYWs7XG4gICAgfVxufVxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHVwZGF0ZU90Y0RhdGEob2xkTGlzdCkge1xuICAgIGNvbnN0IGRhdGEgPSBbXTtcbiAgICBjb25zdCBzZWFyY2hLZXkgPSBjYWNoZURhdGEub3RjLnNlYXJjaEtleTtcbiAgICBjb25zdCBoaWRkZW5TbWFsbEFzc2V0ID0gY2FjaGVEYXRhLm90Yy5oaWRkZW5TbWFsbEFzc2V0O1xuICAgIGF3YWl0IFByb21pc2UuYWxsKG9sZExpc3QubWFwKGFzeW5jIChpdGVtKSA9PiB7XG4gICAgICAgIGlmIChhd2FpdCBpdGVtU2hvdWxkU2hvdyhpdGVtLmNvaW5OYW1lLCBpdGVtLmNvaW5OYW1lLCBpdGVtLnRvdGFsLCBoaWRkZW5TbWFsbEFzc2V0LCBzZWFyY2hLZXkpKSB7XG4gICAgICAgICAgICBkYXRhLnB1c2goaXRlbSk7XG4gICAgICAgIH1cbiAgICB9KSk7XG4gICAgY29uc3Qgc29ydERhdGEgPSBhd2FpdCBzb3J0TGlzdChkYXRhLCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRGb3JPdGMpO1xuICAgIGNhY2hlRGF0YS5vdGMubmV3TGlzdCA9IHNvcnREYXRhO1xuICAgIGNvbnN0IGxpc3QgPSBhd2FpdCBQcm9taXNlLmFsbChzb3J0RGF0YS5tYXAoYXN5bmMgaXRlbSA9PiB7XG4gICAgICAgIHJldHVybiB7XG4gICAgICAgICAgICBzeW1ib2xJY29uOiBhd2FpdCBnZXRJY29uVXJsKGl0ZW0uY29pbk5hbWUpLFxuICAgICAgICAgICAgc3ltYm9sTmFtZTogaXRlbS5jb2luTmFtZSxcbiAgICAgICAgICAgIGZhaXRGcmVlemU6IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGF3YWl0IGdldFByZUN1cnJlbmN5QW1vdW50KGl0ZW0uY29pbk5hbWUsIGl0ZW0uZnJvemVuKSxcbiAgICAgICAgICAgIGZhaXRBdmFpbGFibGU6IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGF3YWl0IGdldFByZUN1cnJlbmN5QW1vdW50KGl0ZW0uY29pbk5hbWUsIGl0ZW0udG90YWwpLFxuICAgICAgICAgICAgZmFpdFZhbHVlOiBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBhd2FpdCBhZGRDdXJyZW50Q3VycmVuY3lTeW1ib2woYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50KGl0ZW0uY29pbk5hbWUsIGl0ZW0udG90YWwpKVxuICAgICAgICB9O1xuICAgIH0pKTtcbiAgICAkZGF0YS5vdGNMaXN0ID0gSlNPTi5zdHJpbmdpZnkobGlzdCk7XG59XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gdXBkYXRlT3B0aW9uRGF0YShvbGRMaXN0KSB7XG4gICAgaWYgKG9sZExpc3QpIHtcbiAgICAgICAgY29uc3QgZGF0YSA9IFtdO1xuICAgICAgICBjb25zdCBzZWFyY2hLZXkgPSBjYWNoZURhdGEub3B0aW9uLnNlYXJjaEtleTtcbiAgICAgICAgY29uc3QgaGlkZGVuU21hbGxBc3NldCA9IGNhY2hlRGF0YS5vcHRpb24uaGlkZGVuU21hbGxBc3NldDtcbiAgICAgICAgYXdhaXQgUHJvbWlzZS5hbGwob2xkTGlzdC5tYXAoYXN5bmMgKGl0ZW0pID0+IHtcbiAgICAgICAgICAgIGlmIChhd2FpdCBpdGVtU2hvdWxkU2hvdyhpdGVtLmN1cnJlbmN5LCBpdGVtLmN1cnJlbmN5LCBpdGVtLmF2YWlsYWJsZU51bSwgaGlkZGVuU21hbGxBc3NldCwgc2VhcmNoS2V5KSkge1xuICAgICAgICAgICAgICAgIGRhdGEucHVzaChpdGVtKTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfSkpO1xuICAgICAgICBjb25zdCBuZXdEYXRhID0gYXdhaXQgc29ydExpc3QoZGF0YSwgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50Rm9yT3B0aW9uKTtcbiAgICAgICAgY2FjaGVEYXRhLm9wdGlvbi5uZXdMaXN0ID0gbmV3RGF0YTtcbiAgICAgICAgY29uc3QgbGlzdCA9IGF3YWl0IFByb21pc2UuYWxsKG5ld0RhdGEubWFwKGFzeW5jIGl0ZW0gPT4ge1xuICAgICAgICAgICAgLy8gY29uc3QgZnJlZXplID0gaXRlbS5wb3NpdGlvbiAtIGl0ZW0uYXZhaWxhYmxlTnVtO1xuICAgICAgICAgICAgcmV0dXJuIHtcbiAgICAgICAgICAgICAgICBzeW1ib2xJY29uOiBhd2FpdCBnZXRJY29uVXJsKGl0ZW0uY3VycmVuY3kpLFxuICAgICAgICAgICAgICAgIHN5bWJvbE5hbWU6IGl0ZW0uY3VycmVuY3kudG9VcHBlckNhc2UoKSxcbiAgICAgICAgICAgICAgICAvL+aMgeS7k1xuICAgICAgICAgICAgICAgIHNwb3ROdW1iZXJFcXVpdmFsZW50OiBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBhd2FpdCBnZXRQcmVDdXJyZW5jeUFtb3VudChpdGVtLmN1cnJlbmN5LCBpdGVtLnBvc2l0aW9uTnVtKSxcbiAgICAgICAgICAgICAgICAvL+WPr+eUqFxuICAgICAgICAgICAgICAgIHNwb3RZaWVsZDogaXNIaWRkZW4gPyBISURERU5fU1RSIDogYXdhaXQgZ2V0UHJlQ3VycmVuY3lBbW91bnQoaXRlbS5jdXJyZW5jeSwgaXRlbS5hdmFpbGFibGVOdW0pLFxuICAgICAgICAgICAgICAgIC8v5Y+v55So5Lyw5YC8XG4gICAgICAgICAgICAgICAgc3BvdFlpZWxkUmF0ZTogaXNIaWRkZW4gPyBISURERU5fU1RSIDogYXdhaXQgYWRkQ3VycmVudEN1cnJlbmN5U3ltYm9sKGF3YWl0IGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudChpdGVtLmN1cnJlbmN5LCBpdGVtLmF2YWlsYWJsZU51bSkpLFxuICAgICAgICAgICAgfTtcbiAgICAgICAgfSkpO1xuICAgICAgICBjb25zb2xlLmVycm9yKFRBRywgYGdldE9wdGlvbkRhdGFTdWNjZWVkLCBsaXN0PSR7bGlzdH1gKTtcbiAgICAgICAgJGRhdGEub3B0aW9uTGlzdCA9IEpTT04uc3RyaW5naWZ5KGxpc3QpO1xuICAgIH1cblxufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gdXBkYXRlRWFybkhpZ2hEYXRhKHR5cGUsIG9sZExpc3QpIHtcbiAgICBjb25zb2xlLmxvZyhgdXBkYXRlRWFybkhpZ2hEYXRhIG9sZExpc3QgJHt0eXBlfSAke0pTT04uc3RyaW5naWZ5KG9sZExpc3QpfWApO1xuICAgIHRyeSB7XG4gICAgICAgIGlmIChvbGRMaXN0ICYmIHR5cGVvZiBvbGRMaXN0ID09PSBcIm9iamVjdFwiICYmIG9sZExpc3QuY29uc3RydWN0b3IgPT09IEFycmF5ICYmIG9sZExpc3QubGVuZ3RoKSB7XG4gICAgICAgICAgICBjb25zdCBkYXRhID0gW107XG4gICAgICAgICAgICBsZXQgbmV3RGF0YSA9IFtdO1xuXG4gICAgICAgICAgICBjb25zdCBzZWFyY2hLZXkgPSBjYWNoZURhdGEuZWFybi5lYXJuSGlnaC5zZWFyY2hLZXk7XG4gICAgICAgICAgICBjb25zdCBoaWRkZW5TbWFsbEFzc2V0ID0gY2FjaGVEYXRhLmVhcm4uZWFybkhpZ2guaGlkZGVuU21hbGxBc3NldDtcbiAgICAgICAgICAgIGF3YWl0IFByb21pc2UuYWxsKG9sZExpc3QubWFwKGFzeW5jIChpdGVtKSA9PiB7XG4gICAgICAgICAgICAgICAgaWYgKGF3YWl0IGl0ZW1TaG91bGRTaG93KGl0ZW0uY3VycmVuY3ksIGl0ZW0uY3VycmVuY3ksIGl0ZW0ubWluaW5nQW1vdW50LCBoaWRkZW5TbWFsbEFzc2V0LCBzZWFyY2hLZXkpKSB7XG4gICAgICAgICAgICAgICAgICAgIGRhdGEucHVzaChpdGVtKTtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICB9KSk7XG4gICAgICAgICAgICBuZXdEYXRhID0gYXdhaXQgc29ydExpc3QoZGF0YSwgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50Rm9yRWFybik7XG4gICAgICAgICAgICBjYWNoZURhdGEuZWFybi5lYXJuSGlnaC5uZXdMaXN0ID0gbmV3RGF0YTtcbiAgICAgICAgICAgIGNvbnN0IGxpc3QgPSBhd2FpdCBQcm9taXNlLmFsbChuZXdEYXRhLm1hcChhc3luYyAoaXRlbSwgaW5kZXgpID0+IHtcbiAgICAgICAgICAgICAgICBjb25zdCB5ZXN0ZXJkYXlJbmNvbWVBbW91bnQgPSBhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnQoU3ltYm9scy51c2R0LCBpdGVtLnllc3RlcmRheUluY29tZUFtb3VudCk7XG4gICAgICAgICAgICAgICAgcmV0dXJuIHtcbiAgICAgICAgICAgICAgICAgICAgdHlwZTogXCIxXCIsXG4gICAgICAgICAgICAgICAgICAgIGluZGV4OiBpbmRleCxcbiAgICAgICAgICAgICAgICAgICAgdmlzaWJsZTogaW5kZXggPT0gbGFzdFBvc2l0aW9uID8gJGRhdGEuZWFybkhpZ2hMaXN0W2xhc3RQb3NpdGlvbl0udmlzaWJsZSA6IFwiZ29uZVwiLFxuICAgICAgICAgICAgICAgICAgICBzeW1ib2xJY29uOiBhd2FpdCBnZXRJY29uVXJsKGl0ZW0uY3VycmVuY3kpLFxuICAgICAgICAgICAgICAgICAgICBzeW1ib2xOYW1lOiBpdGVtLmN1cnJlbmN5LnRvVXBwZXJDYXNlKCksXG4gICAgICAgICAgICAgICAgICAgIHNwb3ROdW1iZXJFcXVpdmFsZW50OiBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBhd2FpdCBhZGRDdXJyZW50Q3VycmVuY3lTeW1ib2woYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50KFN5bWJvbHMudXNkdCwgaXRlbS5wb3NpdGlvbkFtb3VudCkpLFxuICAgICAgICAgICAgICAgICAgICBzcG90TnVtYmVyOiBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBhd2FpdCBnZXRQcmVDdXJyZW5jeUFtb3VudChpdGVtLmN1cnJlbmN5LCBpdGVtLnBvc2l0aW9uQmFsYW5jZSksXG4gICAgICAgICAgICAgICAgICAgIHNwb3RZZXN0ZXJkYXlZaWVsZDogaXNIaWRkZW4gPyBISURERU5fU1RSIDogYCR7eWVzdGVyZGF5SW5jb21lQW1vdW50LnN0YXJ0c1dpdGgoJy0nKSA/ICcnIDogJysnfSR7YXdhaXQgYWRkQ3VycmVudEN1cnJlbmN5U3ltYm9sKHllc3RlcmRheUluY29tZUFtb3VudCl9YCxcbiAgICAgICAgICAgICAgICAgICAgc3BvdFllc3RlcmRheU51bWJlcjogaXNIaWRkZW4gPyBISURERU5fU1RSIDogYCR7eWVzdGVyZGF5SW5jb21lQW1vdW50LnN0YXJ0c1dpdGgoJy0nKSA/ICcnIDogJysnfSR7YXdhaXQgZ2V0UHJlQ3VycmVuY3lBbW91bnQoaXRlbS5jdXJyZW5jeSwgaXRlbS55ZXN0ZXJkYXlJbmNvbWUpfWAsXG4gICAgICAgICAgICAgICAgICAgIHNwb3RFeFllYXJSYXRlOiBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBmaXhSYXRlKGl0ZW0udG90YWxZZWFyUmF0ZSksXG4gICAgICAgICAgICAgICAgICAgIHNwb3RFeERlYnRzOiBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBpdGVtLnRlcm1UcmFuc2xhdGUsXG4gICAgICAgICAgICAgICAgICAgIHNwb3RTdWJzY3JpcHRpb25OdW1iZXI6IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGF3YWl0IGdldFByZUN1cnJlbmN5QW1vdW50KGl0ZW0uY3VycmVuY3ksIGl0ZW0uc3Vic2NyaXB0aW9uQmFsYW5jZSksXG4gICAgICAgICAgICAgICAgICAgIGFtb3VudFJpc2VDb2xvcjogaXNIaWRkZW4gPyBhd2FpdCBnZXRDb2xvcigna0NvbG9yU2Vjb25kYXJ5VGV4dCcpIDogYXdhaXQgcmlzZUNvbG9yKHllc3RlcmRheUluY29tZUFtb3VudCksXG4gICAgICAgICAgICAgICAgfTtcbiAgICAgICAgICAgIH0pKTtcbiAgICAgICAgICAgIGNvbnNvbGUuZXJyb3IoVEFHLCBgZ2V0RWFybkhpZ2hEYXRhU3VjY2VlZCwgSlNPTi5zdHJpbmdpZnkobGlzdCk9JHtKU09OLnN0cmluZ2lmeShsaXN0KX1gKTtcbiAgICAgICAgICAgICRkYXRhLmVhcm5IaWdoTGlzdCA9IGxpc3Q7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAkZGF0YS5lYXJuSGlnaExpc3QgPSBbeyBcInR5cGVcIjogXCIyXCIgfV07XG4gICAgICAgIH1cbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUuZXJyb3IoYHVwZGF0ZUVhcm5IaWdoRGF0YSAke2V9YCk7XG4gICAgfVxufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gdXBkYXRlRWFybk5vZGVQbGVkZ2VEYXRhKHR5cGUsIG9sZExpc3QpIHtcbiAgICBjb25zb2xlLmxvZyhgdXBkYXRlRWFybk5vZGVQbGVkZ2Ugb2xkTGlzdCAke3R5cGV9ICR7SlNPTi5zdHJpbmdpZnkob2xkTGlzdCl9YCk7XG4gICAgdHJ5IHtcbiAgICAgICAgaWYgKG9sZExpc3QgJiYgdHlwZW9mIG9sZExpc3QgPT09IFwib2JqZWN0XCIgJiYgb2xkTGlzdC5jb25zdHJ1Y3RvciA9PT0gQXJyYXkgJiYgb2xkTGlzdC5sZW5ndGgpIHtcbiAgICAgICAgICAgIGNvbnN0IGRhdGEgPSBbXTtcbiAgICAgICAgICAgIGxldCBuZXdEYXRhID0gW107XG5cbiAgICAgICAgICAgIGNvbnN0IHNlYXJjaEtleSA9IGNhY2hlRGF0YS5lYXJuLmVhcm5Ob2RlUGxlZGdlLnNlYXJjaEtleTtcbiAgICAgICAgICAgIGNvbnN0IGhpZGRlblNtYWxsQXNzZXQgPSBjYWNoZURhdGEuZWFybi5lYXJuTm9kZVBsZWRnZS5oaWRkZW5TbWFsbEFzc2V0O1xuICAgICAgICAgICAgYXdhaXQgUHJvbWlzZS5hbGwob2xkTGlzdC5tYXAoYXN5bmMgKGl0ZW0pID0+IHtcbiAgICAgICAgICAgICAgICBpZiAoYXdhaXQgaXRlbVNob3VsZFNob3coaXRlbS5jdXJyZW5jeSwgaXRlbS5jdXJyZW5jeSwgaXRlbS5taW5pbmdBbW91bnQsIGhpZGRlblNtYWxsQXNzZXQsIHNlYXJjaEtleSkpIHtcbiAgICAgICAgICAgICAgICAgICAgZGF0YS5wdXNoKGl0ZW0pO1xuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH0pKTtcbiAgICAgICAgICAgIG5ld0RhdGEgPSBhd2FpdCBzb3J0TGlzdChkYXRhLCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRGb3JFYXJuKTtcbiAgICAgICAgICAgIGNhY2hlRGF0YS5lYXJuLmVhcm5Ob2RlUGxlZGdlLm5ld0xpc3QgPSBuZXdEYXRhO1xuICAgICAgICAgICAgY29uc3QgbGlzdCA9IGF3YWl0IFByb21pc2UuYWxsKG5ld0RhdGEubWFwKGFzeW5jIChpdGVtLCBpbmRleCkgPT4ge1xuICAgICAgICAgICAgICAgIGNvbnN0IHllc3RlcmRheUluY29tZUFtb3VudCA9IGF3YWl0IGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudChTeW1ib2xzLnVzZHQsIGl0ZW0ueWVzdGVyZGF5SW5jb21lQW1vdW50KTtcbiAgICAgICAgICAgICAgICBjb25zdCBlYXJuQW1vdW50ID0gYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50KFN5bWJvbHMudXNkdCwgaXRlbS50b3RhbEluY29tZUFtb3VudCk7XG4gICAgICAgICAgICAgICAgcmV0dXJuIHtcbiAgICAgICAgICAgICAgICAgICAgdHlwZTogXCIxXCIsXG4gICAgICAgICAgICAgICAgICAgIGluZGV4OiBpbmRleCxcbiAgICAgICAgICAgICAgICAgICAgdmlzaWJsZTogaW5kZXggPT0gbm9kZVBsZWRnZUxhc3RQb3NpdGlvbiA/ICRkYXRhLmVhcm5Ob2RlUGxlZGdlTGlzdFtub2RlUGxlZGdlTGFzdFBvc2l0aW9uXS52aXNpYmxlIDogXCJnb25lXCIsXG4gICAgICAgICAgICAgICAgICAgIHN5bWJvbEljb246IGF3YWl0IGdldEljb25VcmwoaXRlbS5jdXJyZW5jeSksXG4gICAgICAgICAgICAgICAgICAgIHN5bWJvbE5hbWU6IGl0ZW0uY3VycmVuY3kudG9VcHBlckNhc2UoKSxcbiAgICAgICAgICAgICAgICAgICAgc3BvdE51bWJlckVxdWl2YWxlbnQ6IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGF3YWl0IGFkZEN1cnJlbnRDdXJyZW5jeVN5bWJvbChhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnQoU3ltYm9scy51c2R0LCBpdGVtLnBvc2l0aW9uQW1vdW50KSksXG4gICAgICAgICAgICAgICAgICAgIHNwb3ROdW1iZXI6IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGF3YWl0IGdldFByZUN1cnJlbmN5QW1vdW50KGl0ZW0uY3VycmVuY3ksIGl0ZW0ucG9zaXRpb25CYWxhbmNlKSxcbiAgICAgICAgICAgICAgICAgICAgdG90YWxFYXJuQW5kUXVhbnRpdHk6IGlzSGlkZGVuID8gYCR7SElEREVOX1NUUn1cXG4ke0hJRERFTl9TVFJ9YCA6IGF3YWl0IGdldFRvdGFsRWFybkFuZFF1YW50aXR5KGl0ZW0uY3VycmVuY3ksIGVhcm5BbW91bnQsIGl0ZW0udG90YWxJbmNvbWVCYWxhbmNlKSxcbiAgICAgICAgICAgICAgICAgICAgc3BvdFllc3RlcmRheVlpZWxkOiBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBgJHt5ZXN0ZXJkYXlJbmNvbWVBbW91bnQuc3RhcnRzV2l0aCgnLScpID8gJycgOiAnKyd9JHthd2FpdCBhZGRDdXJyZW50Q3VycmVuY3lTeW1ib2woeWVzdGVyZGF5SW5jb21lQW1vdW50KX1gLFxuICAgICAgICAgICAgICAgICAgICBzcG90WWVzdGVyZGF5TnVtYmVyOiBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBgJHt5ZXN0ZXJkYXlJbmNvbWVBbW91bnQuc3RhcnRzV2l0aCgnLScpID8gJycgOiAnKyd9JHthd2FpdCBnZXRQcmVDdXJyZW5jeUFtb3VudChpdGVtLmN1cnJlbmN5LCBpdGVtLnllc3RlcmRheUluY29tZSl9YCxcbiAgICAgICAgICAgICAgICAgICAgc3BvdEV4WWVhclJhdGU6IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGZpeFJhdGUoaXRlbS50b3RhbFllYXJSYXRlKSxcbiAgICAgICAgICAgICAgICAgICAgc3BvdEV4RGVidHM6IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGl0ZW0udGVybVRyYW5zbGF0ZSxcbiAgICAgICAgICAgICAgICAgICAgc3BvdFN1YnNjcmlwdGlvbk51bWJlcjogaXNIaWRkZW4gPyBISURERU5fU1RSIDogYXdhaXQgZ2V0UHJlQ3VycmVuY3lBbW91bnQoaXRlbS5jdXJyZW5jeSwgaXRlbS5zdWJzY3JpcHRpb25CYWxhbmNlKSxcbiAgICAgICAgICAgICAgICAgICAgYW1vdW50UmlzZUNvbG9yOiBpc0hpZGRlbiA/IGF3YWl0IGdldENvbG9yKCdrQ29sb3JTZWNvbmRhcnlUZXh0JykgOiBhd2FpdCByaXNlQ29sb3IoeWVzdGVyZGF5SW5jb21lQW1vdW50KSxcbiAgICAgICAgICAgICAgICAgICAgZWFybkFuZFF1YW50aXR5Q29sb3I6IGlzSGlkZGVuID8gYXdhaXQgZ2V0Q29sb3IoJ2tDb2xvclNlY29uZGFyeVRleHQnKSA6IGF3YWl0IHJpc2VDb2xvcihlYXJuQW1vdW50KSxcbiAgICAgICAgICAgICAgICB9O1xuICAgICAgICAgICAgfSkpO1xuICAgICAgICAgICAgY29uc29sZS5lcnJvcihUQUcsIGBnZXRFYXJuTm9kZVBsZWRnZURhdGFTdWNjZWVkLCBKU09OLnN0cmluZ2lmeShsaXN0KT0ke0pTT04uc3RyaW5naWZ5KGxpc3QpfWApO1xuICAgICAgICAgICAgJGRhdGEuZWFybk5vZGVQbGVkZ2VMaXN0ID0gbGlzdDtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICRkYXRhLmVhcm5Ob2RlUGxlZGdlTGlzdCA9IFt7IFwidHlwZVwiOiBcIjJcIiB9XTtcbiAgICAgICAgfVxuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5lcnJvcihgdXBkYXRlRWFybk5vZGVQbGVkZ2VEYXRhICR7ZX1gKTtcbiAgICB9XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiB1cGRhdGVFYXJuU2hhcmtGaW5EYXRhKHR5cGUsIG9sZExpc3QpIHtcbiAgICBjb25zb2xlLmxvZyhgdXBkYXRlRWFyblNoYXJrRmluRGF0YSBvbGRMaXN0ICR7dHlwZX0gJHtKU09OLnN0cmluZ2lmeShvbGRMaXN0KX1gKTtcbiAgICB0cnkge1xuICAgICAgICBpZiAob2xkTGlzdCAmJiB0eXBlb2Ygb2xkTGlzdCA9PT0gXCJvYmplY3RcIiAmJiBvbGRMaXN0LmNvbnN0cnVjdG9yID09PSBBcnJheSAmJiBvbGRMaXN0Lmxlbmd0aCkge1xuICAgICAgICAgICAgY29uc3QgZGF0YSA9IFtdO1xuICAgICAgICAgICAgbGV0IG5ld0RhdGEgPSBbXTtcblxuICAgICAgICAgICAgY29uc3Qgc2VhcmNoS2V5ID0gY2FjaGVEYXRhLmVhcm4uZWFyblNoYXJrRmluLnNlYXJjaEtleTtcbiAgICAgICAgICAgIGNvbnN0IGhpZGRlblNtYWxsQXNzZXQgPSBjYWNoZURhdGEuZWFybi5lYXJuU2hhcmtGaW4uaGlkZGVuU21hbGxBc3NldDtcbiAgICAgICAgICAgIGF3YWl0IFByb21pc2UuYWxsKG9sZExpc3QubWFwKGFzeW5jIChpdGVtKSA9PiB7XG4gICAgICAgICAgICAgICAgaWYgKGF3YWl0IGl0ZW1TaG91bGRTaG93KGl0ZW0uY3VycmVuY3ksIGl0ZW0uY3VycmVuY3ksIGl0ZW0ubWluaW5nQW1vdW50LCBoaWRkZW5TbWFsbEFzc2V0LCBzZWFyY2hLZXkpKSB7XG4gICAgICAgICAgICAgICAgICAgIGRhdGEucHVzaChpdGVtKTtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICB9KSk7XG4gICAgICAgICAgICBuZXdEYXRhID0gYXdhaXQgc29ydExpc3QoZGF0YSwgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50Rm9yRWFybik7XG4gICAgICAgICAgICBjYWNoZURhdGEuZWFybi5lYXJuU2hhcmtGaW4ubmV3TGlzdCA9IG5ld0RhdGE7XG4gICAgICAgICAgICBjb25zdCBsaXN0ID0gYXdhaXQgUHJvbWlzZS5hbGwobmV3RGF0YS5tYXAoYXN5bmMgKGl0ZW0sIGluZGV4KSA9PiB7XG4gICAgICAgICAgICAgICAgcmV0dXJuIHtcbiAgICAgICAgICAgICAgICAgICAgdHlwZTogXCIxXCIsXG4gICAgICAgICAgICAgICAgICAgIGluZGV4OiBpbmRleCxcbiAgICAgICAgICAgICAgICAgICAgdmlzaWJsZTogaW5kZXggPT0gc2hhcmtGaW5MYXN0UG9zaXRpb24gPyBcInZpc2libGVcIiA6IFwiZ29uZVwiLFxuICAgICAgICAgICAgICAgICAgICBzeW1ib2xJY29uOiBhd2FpdCBnZXRJY29uVXJsKGl0ZW0uY3VycmVuY3kpLFxuICAgICAgICAgICAgICAgICAgICBzeW1ib2xOYW1lOiBpdGVtLmN1cnJlbmN5LnRvVXBwZXJDYXNlKCksXG4gICAgICAgICAgICAgICAgICAgIHByb2plY3ROYW1lOiBpdGVtLnByb2plY3ROYW1lLFxuICAgICAgICAgICAgICAgICAgICBzcG90TnVtYmVyRXF1aXZhbGVudDogaXNIaWRkZW4gPyBISURERU5fU1RSIDogYXdhaXQgYWRkQ3VycmVudEN1cnJlbmN5U3ltYm9sKGF3YWl0IGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudChTeW1ib2xzLnVzZHQsIGl0ZW0ucG9zaXRpb25BbW91bnQpKSxcbiAgICAgICAgICAgICAgICAgICAgc3BvdE51bWJlcjogaXNIaWRkZW4gPyBISURERU5fU1RSIDogYXdhaXQgZ2V0UHJlQ3VycmVuY3lBbW91bnQoaXRlbS5jdXJyZW5jeSwgaXRlbS5wb3NpdGlvbkJhbGFuY2UpLFxuICAgICAgICAgICAgICAgICAgICB0cmFuc2xhdGVFYXJuUmF0ZTogaXNIaWRkZW4gPyBISURERU5fU1RSIDogaXRlbS5wcm9kdWN0U3RhdHVzID09IDIgPyBpdGVtLnRvdGFsWWVhclJhdGVUcmFuc2xhdGUgOiBgJHtpdGVtLnRyYW5zbGF0ZU1pblllYXJSYXRlfS0ke2l0ZW0udHJhbnNsYXRlTWF4WWVhclJhdGV9YCxcbiAgICAgICAgICAgICAgICAgICAgaW5jb21lVGltZTogaXNIaWRkZW4gPyBISURERU5fU1RSIDogaXRlbS5pbmNvbWVUaW1lLFxuICAgICAgICAgICAgICAgICAgICB0ZXJtVHJhbnNsYXRlOiBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBpdGVtLnRlcm1UcmFuc2xhdGUsXG4gICAgICAgICAgICAgICAgICAgIHByb2R1Y3RUcmFuc2xhdGVTdGF0dXM6IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGl0ZW0ucHJvZHVjdFRyYW5zbGF0ZVN0YXR1cyxcbiAgICAgICAgICAgICAgICB9O1xuICAgICAgICAgICAgfSkpO1xuICAgICAgICAgICAgY29uc29sZS5lcnJvcihUQUcsIGBnZXRFYXJuU2hhcmtGaW5EYXRhU3VjY2VlZCwgSlNPTi5zdHJpbmdpZnkobGlzdCk9JHtKU09OLnN0cmluZ2lmeShsaXN0KX1gKTtcbiAgICAgICAgICAgICRkYXRhLmVhcm5TaGFya0Zpbkxpc3QgPSBsaXN0O1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgY29uc29sZS5sb2coYHVwZGF0ZUVhcm5TaGFya0ZpbkRhdGEgdHlwZSAyYCk7XG4gICAgICAgICAgICAkZGF0YS5lYXJuU2hhcmtGaW5MaXN0ID0gW3sgXCJ0eXBlXCI6IFwiMlwiIH1dO1xuICAgICAgICB9XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICBjb25zb2xlLmVycm9yKGB1cGRhdGVFYXJuU2hhcmtGaW5EYXRhICR7ZX1gKTtcbiAgICB9XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiB1cGRhdGVFYXJuRGF0YSh0eXBlLCBvbGRMaXN0KSB7XG4gICAgY29uc29sZS5sb2coYHVwZGF0ZUVhcm5EYXRhICR7dHlwZX0gJHtKU09OLnN0cmluZ2lmeShvbGRMaXN0KX1gKTtcbiAgICB0cnkge1xuICAgICAgICBpZiAob2xkTGlzdCkge1xuICAgICAgICAgICAgY29uc3QgZGF0YSA9IFtdO1xuICAgICAgICAgICAgbGV0IG5ld0RhdGEgPSBbXTtcbiAgICAgICAgICAgIGlmICh0eXBlID09IDApIHtcbiAgICAgICAgICAgICAgICBjb25zdCB5YmJTZWFyY2hLZXkgPSBjYWNoZURhdGEuZWFybi5lYXJuWWJiLnNlYXJjaEtleTtcbiAgICAgICAgICAgICAgICBjb25zdCB5YmJIaWRkZW5TbWFsbEFzc2V0ID0gY2FjaGVEYXRhLmVhcm4uZWFyblliYi5oaWRkZW5TbWFsbEFzc2V0O1xuICAgICAgICAgICAgICAgIGF3YWl0IFByb21pc2UuYWxsKG9sZExpc3QubWFwKGFzeW5jIChpdGVtKSA9PiB7XG4gICAgICAgICAgICAgICAgICAgIGlmIChhd2FpdCBpdGVtU2hvdWxkU2hvdyhpdGVtLmN1cnJlbmN5LCBpdGVtLmN1cnJlbmN5LCBpdGVtLm1pbmluZ0Ftb3VudCwgeWJiSGlkZGVuU21hbGxBc3NldCwgeWJiU2VhcmNoS2V5KSkge1xuICAgICAgICAgICAgICAgICAgICAgICAgZGF0YS5wdXNoKGl0ZW0pO1xuICAgICAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgfSkpO1xuICAgICAgICAgICAgICAgIG5ld0RhdGEgPSBhd2FpdCBzb3J0TGlzdChkYXRhLCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRGb3JFYXJuKTtcbiAgICAgICAgICAgICAgICBjYWNoZURhdGEuZWFybi5lYXJuWWJiLm5ld0xpc3QgPSBuZXdEYXRhO1xuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICBjb25zdCBzZWFyY2hLZXkgPSBjYWNoZURhdGEuZWFybi5lYXJuRml4ZWQuc2VhcmNoS2V5O1xuICAgICAgICAgICAgICAgIGNvbnN0IGhpZGRlblNtYWxsQXNzZXQgPSBjYWNoZURhdGEuZWFybi5lYXJuRml4ZWQuaGlkZGVuU21hbGxBc3NldDtcbiAgICAgICAgICAgICAgICBhd2FpdCBQcm9taXNlLmFsbChvbGRMaXN0Lm1hcChhc3luYyAoaXRlbSkgPT4ge1xuICAgICAgICAgICAgICAgICAgICBpZiAoYXdhaXQgaXRlbVNob3VsZFNob3coaXRlbS5jdXJyZW5jeSwgaXRlbS5jdXJyZW5jeSwgaXRlbS5taW5pbmdBbW91bnQsIGhpZGRlblNtYWxsQXNzZXQsIHNlYXJjaEtleSkpIHtcbiAgICAgICAgICAgICAgICAgICAgICAgIGRhdGEucHVzaChpdGVtKTtcbiAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIH0pKTtcbiAgICAgICAgICAgICAgICBuZXdEYXRhID0gYXdhaXQgc29ydExpc3QoZGF0YSwgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50Rm9yRWFybik7XG4gICAgICAgICAgICAgICAgY2FjaGVEYXRhLmVhcm4uZWFybkZpeGVkLm5ld0xpc3QgPSBuZXdEYXRhO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgY29uc3QgbGlzdCA9IGF3YWl0IFByb21pc2UuYWxsKG5ld0RhdGEubWFwKGFzeW5jIGl0ZW0gPT4ge1xuICAgICAgICAgICAgICAgIGNvbnN0IHNwb3RFeFlpZWxkID0gYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50KGl0ZW0uY3VycmVuY3ksIGl0ZW0udG90YWxJbmNvbWVBbW91bnQpO1xuICAgICAgICAgICAgICAgIGNvbnN0IHNwb3RFeFlpZWxkU3RyID0gYXdhaXQgYWRkQ3VycmVudEN1cnJlbmN5U3ltYm9sKHNwb3RFeFlpZWxkKTtcbiAgICAgICAgICAgICAgICBjb25zdCBlYXJuRXhOdW1iZXIgPSB0eXBlID09IFwiMFwiID8gYXdhaXQgZ2V0UHJlQ3VycmVuY3lBbW91bnQoaXRlbS5jdXJyZW5jeSwgaXRlbS5taW5pbmdBbW91bnQpIDogYXdhaXQgYWRkQ3VycmVudEN1cnJlbmN5U3ltYm9sKGF3YWl0IGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudChpdGVtLmN1cnJlbmN5LCBpdGVtLmNvbmZpcm1lZEZpeGVkVG90YWxJbnRlcmVzdCkpO1xuICAgICAgICAgICAgICAgIGNvbnN0IHliYkV4WWllbGQgPSBgJHtpdGVtLnRvdGFsSW5jb21lQW1vdW50ID49IDAgPyAnKycgOiAnLSd9JHtzcG90RXhZaWVsZFN0cn1gO1xuICAgICAgICAgICAgICAgIGNvbnN0IGZpeGVkRXhZaWVsZCA9IGAke2l0ZW0ucHJvSW5jb21lQW1vdW50ID49IDAgPyAnKycgOiAnLSd9JHthd2FpdCBhZGRDdXJyZW50Q3VycmVuY3lTeW1ib2woYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50KGl0ZW0uY3VycmVuY3ksIGl0ZW0ucHJvSW5jb21lQW1vdW50KSl9YDtcbiAgICAgICAgICAgICAgICBjb25zdCB5YmJFeFlpZWxkUmF0ZSA9IGAke2l0ZW0udG90YWxJbmNvbWVBbW91bnQgPj0gMCA/ICcrJyA6ICctJ30ke2F3YWl0IGdldFByZUN1cnJlbmN5QW1vdW50KGl0ZW0uY3VycmVuY3ksIGl0ZW0udG90YWxJbmNvbWVBbW91bnQpfWA7XG4gICAgICAgICAgICAgICAgY29uc3QgZml4ZWRFeFlpZWxkUmF0ZSA9IGAke2l0ZW0ucHJvSW5jb21lQW1vdW50ID49IDAgPyAnKycgOiAnLSd9JHthd2FpdCBnZXRQcmVDdXJyZW5jeUFtb3VudChpdGVtLmN1cnJlbmN5LCBpdGVtLnByb0luY29tZUFtb3VudCl9YDtcbiAgICAgICAgICAgICAgICBjb25zdCB5YmJTcG90WWllbGQgPSBhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnQoaXRlbS5jdXJyZW5jeSwgaXRlbS55ZXN0ZXJkYXlJbmNvbWUpO1xuICAgICAgICAgICAgICAgIGNvbnN0IHliYlNwb3RZaWVsZFJhdGUgPSBhd2FpdCBnZXRQcmVDdXJyZW5jeUFtb3VudChpdGVtLmN1cnJlbmN5LCBpdGVtLnllc3RlcmRheUluY29tZSk7XG4gICAgICAgICAgICAgICAgY29uc3QgZml4ZWRTcG90WWllbGQgPSBhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnQoaXRlbS5jdXJyZW5jeSwgaXRlbS5lc3RGaXhlZFRvZGF5SW50ZXJlc3QpO1xuICAgICAgICAgICAgICAgIGNvbnN0IGZpeGVkU3BvdFlpZWxkUmF0ZSA9IGF3YWl0IGdldFByZUN1cnJlbmN5QW1vdW50KGl0ZW0uY3VycmVuY3ksIGl0ZW0uZXN0Rml4ZWRUb2RheUludGVyZXN0KTtcbiAgICAgICAgICAgICAgICBjb25zdCB5YmJTcG90WWllbGRPcGVyYXRvciA9IGAke3Nwb3RFeFlpZWxkLnN0YXJ0c1dpdGgoJy0nKSA/ICcnIDogJysnfSR7YXdhaXQgYWRkQ3VycmVudEN1cnJlbmN5U3ltYm9sKGF3YWl0IGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudChpdGVtLmN1cnJlbmN5LCBpdGVtLnllc3RlcmRheUluY29tZSkpfWA7XG4gICAgICAgICAgICAgICAgY29uc3QgeWJiU3BvdFlpZWxkUmF0ZU9wZXJhdG9yID0gYCR7c3BvdEV4WWllbGQuc3RhcnRzV2l0aCgnLScpID8gJycgOiAnKyd9JHthd2FpdCBnZXRQcmVDdXJyZW5jeUFtb3VudChpdGVtLmN1cnJlbmN5LCBpdGVtLnllc3RlcmRheUluY29tZSl9YDtcbiAgICAgICAgICAgICAgICBjb25zdCBmaXhlZFNwb3RZaWVsZE9wZXJhdG9yID0gYCR7c3BvdEV4WWllbGQuc3RhcnRzV2l0aCgnLScpID8gJycgOiAnKyd9JHthd2FpdCBhZGRDdXJyZW50Q3VycmVuY3lTeW1ib2woYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50KGl0ZW0uY3VycmVuY3ksIGl0ZW0uZXN0Rml4ZWRUb2RheUludGVyZXN0KSl9YDtcbiAgICAgICAgICAgICAgICBjb25zdCBmaXhlZFNwb3RZaWVsZFJhdGVPcGVyYXRvciA9IGAke3Nwb3RFeFlpZWxkLnN0YXJ0c1dpdGgoJy0nKSA/ICcnIDogJysnfSR7YXdhaXQgZ2V0UHJlQ3VycmVuY3lBbW91bnQoaXRlbS5jdXJyZW5jeSwgaXRlbS5lc3RGaXhlZFRvZGF5SW50ZXJlc3QpfWA7XG4gICAgICAgICAgICAgICAgY29uc3QgeWJiU3BvdFlpZWxkUmF0ZUNvbG9yID0gYXdhaXQgcmlzZUNvbG9yKHliYlNwb3RZaWVsZCk7XG4gICAgICAgICAgICAgICAgY29uc3QgZml4ZWRTcG90WWllbGRSYXRlQ29sb3IgPSBhd2FpdCByaXNlQ29sb3IoZml4ZWRTcG90WWllbGQpO1xuICAgICAgICAgICAgICAgIGNvbnN0IHliYkV4UmlzZUNvbG9yID0gYXdhaXQgcmlzZUNvbG9yKHNwb3RFeFlpZWxkKTtcbiAgICAgICAgICAgICAgICBjb25zdCB5YmJGaXhlZEV4UmlzZUNvbG9yID0gYXdhaXQgcmlzZUNvbG9yKGF3YWl0IGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudChpdGVtLmN1cnJlbmN5LCBpdGVtLnByb0luY29tZUFtb3VudCkpO1xuICAgICAgICAgICAgICAgIGxldCBsYWJlbCA9IGF3YWl0IGdldFdvcmQoJ25fbWluaW5nX2Fzc2V0X2ZpeGVkJyk7XG4gICAgICAgICAgICAgICAgaWYgKGl0ZW0ub3JkZXJTaG93TGFiZWxUeXBlID09PSAxKSB7XG4gICAgICAgICAgICAgICAgICAgIGxhYmVsID0gYXdhaXQgZ2V0V29yZCgnbl9hc3NldF9lYXJuX25ld19jb2luJyk7XG4gICAgICAgICAgICAgICAgfSBlbHNlIGlmIChpdGVtLm9yZGVyU2hvd0xhYmVsVHlwZSA9PT0gMCkge1xuICAgICAgICAgICAgICAgICAgICBsYWJlbCA9IGF3YWl0IGdldFdvcmQoJ25fYXNzZXRfZWFybl9sYWJlbF9vcHRpbWl6YXRpb24nKTtcbiAgICAgICAgICAgICAgICB9IGVsc2UgaWYgKGl0ZW0ub3JkZXJTaG93TGFiZWxUeXBlID09PSAyKSB7XG4gICAgICAgICAgICAgICAgICAgIGxhYmVsID0gYXdhaXQgZ2V0V29yZCgnbl9taW5pbmdfZml4ZWQnKTtcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgY29uc3Qgc2hvd1ZJUCA9IChpdGVtLnRhZyAhPSBudWxsICYmIGl0ZW0udGFnID09IDgpID8gXCJ2aXNpYmxlXCIgOiBcImdvbmVcIjtcbiAgICAgICAgICAgICAgICBsZXQgdmlwSWNvbiA9IFwiQGRyYXdhYmxlL2VkZ2VfZW5naW5lX2Vhcm5fdmlwX2ljb25fb3RoZXJcIjtcbiAgICAgICAgICAgICAgICBpZiAoY29tbW9uRGF0YS5sYW5ndWFnZS50b0xvd2VyQ2FzZSgpID09IFwiemgtY25cIiB8fFxuICAgICAgICAgICAgICAgICAgICBjb21tb25EYXRhLmxhbmd1YWdlLnRvTG93ZXJDYXNlKCkgPT0gXCJ6aC1oa1wiKSB7XG4gICAgICAgICAgICAgICAgICAgIHZpcEljb24gPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9lYXJuX3ZpcF9pY29uXCI7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIHJldHVybiB7XG4gICAgICAgICAgICAgICAgICAgIHN5bWJvbEljb246IGF3YWl0IGdldEljb25VcmwoaXRlbS5jdXJyZW5jeSksXG4gICAgICAgICAgICAgICAgICAgIHN5bWJvbE5hbWU6IGl0ZW0uY3VycmVuY3kudG9VcHBlckNhc2UoKSxcbiAgICAgICAgICAgICAgICAgICAgaXNMb2FuOiBpdGVtLnByb2plY3RUeXBlID09IFwiMFwiID8gJ2dvbmUnIDogJ3Zpc2libGUnLFxuICAgICAgICAgICAgICAgICAgICBzcG90TnVtYmVyRXF1aXZhbGVudDogaXNIaWRkZW4gPyBISURERU5fU1RSIDogYXdhaXQgYWRkQ3VycmVudEN1cnJlbmN5U3ltYm9sKGF3YWl0IGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudChpdGVtLmN1cnJlbmN5LCBpdGVtLnRvdGFsQW1vdW50KSksXG4gICAgICAgICAgICAgICAgICAgIHNwb3ROdW1iZXI6IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGF3YWl0IGdldFByZUN1cnJlbmN5QW1vdW50KGl0ZW0uY3VycmVuY3ksIGl0ZW0udG90YWxBbW91bnQpLFxuICAgICAgICAgICAgICAgICAgICBzcG90WWllbGQ6IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IHR5cGUgPT0gXCIwXCIgPyB5YmJTcG90WWllbGRPcGVyYXRvciA6IGZpeGVkU3BvdFlpZWxkT3BlcmF0b3IsXG4gICAgICAgICAgICAgICAgICAgIHNwb3RZaWVsZFJhdGU6IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IHR5cGUgPT0gXCIwXCIgPyB5YmJTcG90WWllbGRSYXRlT3BlcmF0b3IgOiBmaXhlZFNwb3RZaWVsZFJhdGVPcGVyYXRvcixcbiAgICAgICAgICAgICAgICAgICAgc3BvdEV4QXZhaWxhYmxlOiBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBmaXhSYXRlKGl0ZW0ubWluaW5nWWVhclJhdGUpLFxuICAgICAgICAgICAgICAgICAgICBzcG90RXhEZWJ0czogdHlwZSA9PSAnMCcgPyBhd2FpdCBnZXRXb3JkKCduX2Fzc2V0X2Vhcm5fY3VycmVudCcpIDogYXdhaXQgZ2V0V29yZEZvcm1hdCgnbl9jMmNfbGVuZF9kYXlzJywgaXRlbS50ZXJtKSxcbiAgICAgICAgICAgICAgICAgICAgc3BvdEV4UHJpY2U6IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGVhcm5FeE51bWJlcixcbiAgICAgICAgICAgICAgICAgICAgc3BvdEV4Q29zdDogaXNIaWRkZW4gPyBISURERU5fU1RSIDogaXRlbS5jb25maXJtZWRGaXhlZFRvdGFsSW50ZXJlc3QsXG4gICAgICAgICAgICAgICAgICAgIHNwb3RFeFlpZWxkOiBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiB0eXBlID09IFwiMFwiID8geWJiRXhZaWVsZCA6IGZpeGVkRXhZaWVsZCxcbiAgICAgICAgICAgICAgICAgICAgc3BvdEV4WWllbGRSYXRlOiBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiB0eXBlID09IFwiMFwiID8geWJiRXhZaWVsZFJhdGUgOiBmaXhlZEV4WWllbGRSYXRlLFxuICAgICAgICAgICAgICAgICAgICBsb2FuTGFiZWw6IGxhYmVsLFxuICAgICAgICAgICAgICAgICAgICBzcG90UmlzZUNvbG9yOiBpc0hpZGRlbiA/IGF3YWl0IGdldENvbG9yKCdrQ29sb3JTZWNvbmRhcnlUZXh0JykgOiB0eXBlID09IFwiMFwiID8geWJiU3BvdFlpZWxkUmF0ZUNvbG9yIDogZml4ZWRTcG90WWllbGRSYXRlQ29sb3IsXG4gICAgICAgICAgICAgICAgICAgIHliYkV4UmlzZUNvbG9yOiBpc0hpZGRlbiA/IGF3YWl0IGdldENvbG9yKCdrQ29sb3JTZWNvbmRhcnlUZXh0JykgOiB0eXBlID09IFwiMFwiID8geWJiRXhSaXNlQ29sb3IgOiB5YmJGaXhlZEV4UmlzZUNvbG9yLFxuICAgICAgICAgICAgICAgICAgICBhbW91bnRSaXNlQ29sb3I6IGlzSGlkZGVuID8gYXdhaXQgZ2V0Q29sb3IoJ2tDb2xvclNlY29uZGFyeVRleHQnKSA6IHR5cGUgPT0gXCIwXCIgPyBhd2FpdCByaXNlQ29sb3IoaXRlbS55ZXN0ZXJkYXlJbmNvbWUpIDogYXdhaXQgcmlzZUNvbG9yKGl0ZW0uZXN0Rml4ZWRUb2RheUludGVyZXN0KSxcbiAgICAgICAgICAgICAgICAgICAgYW1vdW50RXhSaXNlQ29sb3I6IGlzSGlkZGVuID8gYXdhaXQgZ2V0Q29sb3IoJ2tDb2xvclNlY29uZGFyeVRleHQnKSA6IHR5cGUgPT0gXCIwXCIgPyBhd2FpdCByaXNlQ29sb3IoaXRlbS50b3RhbEluY29tZUFtb3VudCkgOiBhd2FpdCByaXNlQ29sb3IoaXRlbS5wcm9JbmNvbWVBbW91bnQpLFxuICAgICAgICAgICAgICAgICAgICBzaG93VklQLFxuICAgICAgICAgICAgICAgICAgICB2aXBJY29uXG5cbiAgICAgICAgICAgICAgICB9O1xuICAgICAgICAgICAgfSkpO1xuICAgICAgICAgICAgY29uc29sZS5lcnJvcihUQUcsIGBnZXRFYXJuRGF0YVN1Y2NlZWQsIGxpc3Q9JHtKU09OLnN0cmluZ2lmeShsaXN0KX1gKTtcbiAgICAgICAgICAgIGlmICh0eXBlID09IFwiMFwiKSB7XG4gICAgICAgICAgICAgICAgJGRhdGEuZWFyblliYkxpc3QgPSBKU09OLnN0cmluZ2lmeShsaXN0KTtcbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgJGRhdGEuZWFybkZpeGVkTGlzdCA9IEpTT04uc3RyaW5naWZ5KGxpc3QpO1xuICAgICAgICAgICAgfVxuICAgICAgICB9XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICBjb25zb2xlLmVycm9yKGB1cGRhdGVFYXJuRGF0YSAke2V9YCk7XG4gICAgfVxuXG59XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gdXBkYXRlTWFyZ2luQWxsRGF0YShvbGRMaXN0KSB7XG4gICAgaWYgKG9sZExpc3QpIHtcbiAgICAgICAgY29uc3QgZGF0YSA9IFtdO1xuICAgICAgICBjb25zdCBzZWFyY2hLZXkgPSBjYWNoZURhdGEubWFyZ2luLmFsbFJlcG8uc2VhcmNoS2V5O1xuICAgICAgICBjb25zdCBoaWRkZW5TbWFsbEFzc2V0ID0gY2FjaGVEYXRhLm1hcmdpbi5hbGxSZXBvLmhpZGRlblNtYWxsQXNzZXQ7XG4gICAgICAgIGF3YWl0IFByb21pc2UuYWxsKG9sZExpc3QubWFwKGFzeW5jIChpdGVtKSA9PiB7XG4gICAgICAgICAgICBpZiAoYXdhaXQgaXRlbVNob3VsZFNob3coaXRlbS5zeW1ib2xOYW1lLCBpdGVtLnN5bWJvbE5hbWUsIGl0ZW0uYXZhaWxhYmxlLCBoaWRkZW5TbWFsbEFzc2V0LCBzZWFyY2hLZXkpKSB7XG4gICAgICAgICAgICAgICAgZGF0YS5wdXNoKGl0ZW0pO1xuICAgICAgICAgICAgfVxuICAgICAgICB9KSk7XG4gICAgICAgIGNvbnN0IG5ld0RhdGEgPSBhd2FpdCBzb3J0TGlzdChkYXRhLCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRGb3JNYXJnaW5BbGwpO1xuICAgICAgICBjYWNoZURhdGEubWFyZ2luLmFsbFJlcG8ubmV3TGlzdCA9IG5ld0RhdGE7XG4gICAgICAgIGNvbnNvbGUubG9nKGB1cGRhdGVNYXJnaW5BbGxEYXRhYCk7XG4gICAgICAgIGNvbnN0IGxpc3QgPSBhd2FpdCBQcm9taXNlLmFsbChuZXdEYXRhLm1hcChhc3luYyBpdGVtID0+IHtcbiAgICAgICAgICAgIHJldHVybiB7XG4gICAgICAgICAgICAgICAgc3ltYm9sSWNvbjogaXRlbS5zeW1ib2xJY29uLFxuICAgICAgICAgICAgICAgIHN5bWJvbE5hbWU6IGl0ZW0uc3ltYm9sTmFtZSxcbiAgICAgICAgICAgICAgICBzcG90TnVtYmVyRXF1aXZhbGVudDogaXNIaWRkZW4gPyBISURERU5fU1RSIDogaXRlbS5hdmFpbGFibGUsXG4gICAgICAgICAgICAgICAgc3BvdFlpZWxkOiBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBhd2FpdCBhZGRDdXJyZW50Q3VycmVuY3lTeW1ib2woYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50KGl0ZW0uc3ltYm9sTmFtZSwgaXRlbS5lc3RpbWF0aW9uKSksXG4gICAgICAgICAgICAgICAgc3BvdFlpZWxkUmF0ZTogaXNIaWRkZW4gPyBISURERU5fU1RSIDogaXRlbS5mcmVlemUsXG4gICAgICAgICAgICAgICAgc3BvdE51bWJlcjogaXNIaWRkZW4gPyBISURERU5fU1RSIDogaXRlbS5ib3Jyb3dlZCxcbiAgICAgICAgICAgIH07XG4gICAgICAgIH0pKTtcbiAgICAgICAgJGRhdGEubG9uZ0xldmVsRGF0YUxpc3QgPSBKU09OLnN0cmluZ2lmeShsaXN0KTtcbiAgICB9XG59XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gdXBkYXRlTWFyZ2luUGFydERhdGEob2xkTGlzdCkge1xuICAgIGlmIChvbGRMaXN0KSB7XG4gICAgICAgIGNvbnN0IGRhdGEgPSBbXTtcbiAgICAgICAgY29uc3Qgc2VhcmNoS2V5ID0gY2FjaGVEYXRhLm1hcmdpbi5wYXJ0UmVwby5zZWFyY2hLZXk7XG4gICAgICAgIGNvbnN0IGhpZGRlblNtYWxsQXNzZXQgPSBjYWNoZURhdGEubWFyZ2luLnBhcnRSZXBvLmhpZGRlblNtYWxsQXNzZXQ7XG4gICAgICAgIGF3YWl0IFByb21pc2UuYWxsKG9sZExpc3QubWFwKGFzeW5jIChpdGVtKSA9PiB7XG4gICAgICAgICAgICBjb25zdCBiYXNlQXZhID0gYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50KGl0ZW0uYmFzZUN1cnJlbmN5LCBpdGVtLmJhc2VFc3RpbWF0aW9uKTtcbiAgICAgICAgICAgIGNvbnN0IHF1b3RlQXZhID0gYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50KGl0ZW0ucXVvdGVDdXJyZW5jeSwgaXRlbS5xdW90ZUVzdGltYXRpb24pO1xuICAgICAgICAgICAgY29uc3QgbWFyZ2luRXF1aXZhbGVudCA9IGdldEZ1bGxOdW0oTnVtYmVyLnBhcnNlRmxvYXQoYmFzZUF2YSkgKyBOdW1iZXIucGFyc2VGbG9hdChxdW90ZUF2YSkpO1xuICAgICAgICAgICAgaXRlbS5tYXJnaW5FcXVpdmFsZW50Rml4ZWQgPSBOdW1iZXIobWFyZ2luRXF1aXZhbGVudCkudG9GaXhlZCgyKTtcbiAgICAgICAgICAgIGlmIChhd2FpdCBpdGVtU2hvdWxkU2hvdyhpdGVtLmRpc3BsYXlOYW1lLCBpdGVtLnF1b3RlQ3VycmVuY3lEaXNwbGF5TmFtZSwgaXRlbS5tYXJnaW5FcXVpdmFsZW50Rml4ZWQsIGhpZGRlblNtYWxsQXNzZXQsIHNlYXJjaEtleSkpIHtcbiAgICAgICAgICAgICAgICBkYXRhLnB1c2goaXRlbSk7XG4gICAgICAgICAgICB9XG4gICAgICAgIH0pKTtcbiAgICAgICAgY29uc3QgbmV3RGF0YSA9IGF3YWl0IHNvcnRMaXN0KGRhdGEsIGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudEZvck1hcmdpblBhcnQpO1xuICAgICAgICBjYWNoZURhdGEubWFyZ2luLnBhcnRSZXBvLm5ld0xpc3QgPSBuZXdEYXRhO1xuICAgICAgICBjb25zdCBsaXN0ID0gYXdhaXQgUHJvbWlzZS5hbGwobmV3RGF0YS5tYXAoYXN5bmMgaXRlbSA9PiB7XG4gICAgICAgICAgICByZXR1cm4ge1xuICAgICAgICAgICAgICAgIHN5bWJvbEljb246IGl0ZW0uc3ltYm9sSWNvbixcbiAgICAgICAgICAgICAgICBzeW1ib2xOYW1lOiBpdGVtLmRpc3BsYXlOYW1lLFxuICAgICAgICAgICAgICAgIGJhc2VTeW1ib2xOYW1lOiBpdGVtLmJhc2VDdXJyZW5jeURpc3BsYXlOYW1lLFxuICAgICAgICAgICAgICAgIHF1b3RlU3ltYm9sTmFtZTogYC8ke2l0ZW0ucXVvdGVDdXJyZW5jeURpc3BsYXlOYW1lfWAsXG4gICAgICAgICAgICAgICAgcmlza1RleHQ6IGl0ZW0ucmlza1JhdGVTdGF0ZVRleHQsXG4gICAgICAgICAgICAgICAgcmlza1RleHRDb2xvcjogaXRlbS5yaXNrUmF0ZVN0YXRlQ29sb3IsXG4gICAgICAgICAgICAgICAgcmlza1RleHRCZzogaXRlbS5yaXNrUmF0ZVN0YXRlQmcsXG4gICAgICAgICAgICAgICAgbWFyZ2luUHJpY2U6IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGF3YWl0IGFkZEN1cnJlbnRDdXJyZW5jeVN5bWJvbChpdGVtLm1hcmdpbkVxdWl2YWxlbnRGaXhlZCksXG4gICAgICAgICAgICAgICAgYmFzZVN5bWJvbE5hbWU6IGl0ZW0uYmFzZUN1cnJlbmN5RGlzcGxheU5hbWUsXG4gICAgICAgICAgICAgICAgYmFzZUF2YWlsYWJsZTogaXNIaWRkZW4gPyBISURERU5fU1RSIDogaXRlbS5iYXNlQXZhaWxhYmxlLFxuICAgICAgICAgICAgICAgIGJhc2VCb3Jyb3dlZDogaXNIaWRkZW4gPyBISURERU5fU1RSIDogaXRlbS5iYXNlQm9ycm93ZWRBbmRGcmVlemUsXG4gICAgICAgICAgICAgICAgY2hhc2VTeW1ib2xOYW1lOiBpdGVtLnF1b3RlQ3VycmVuY3lEaXNwbGF5TmFtZSxcbiAgICAgICAgICAgICAgICBjaGFzZUF2YWlsYWJsZTogaXNIaWRkZW4gPyBISURERU5fU1RSIDogaXRlbS5xdW90ZUF2YWlsYWJsZSxcbiAgICAgICAgICAgICAgICBjaGFzZUJvcnJvd2VkOiBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBpdGVtLnF1b3RlQm9ycm93ZWRBbmRGcmVlemUsXG4gICAgICAgICAgICB9O1xuICAgICAgICB9KSk7XG4gICAgICAgICRkYXRhLnNob3J0TGV2ZWxEYXRhTGlzdCA9IEpTT04uc3RyaW5naWZ5KGxpc3QpO1xuICAgIH1cbn1cbmV4cG9ydCBmdW5jdGlvbiBhc3NldFRoaXJkVHlwZUV2ZW50KHR5cGUsIGlzQWxsKSB7XG4gICAgY29uc29sZS5sb2coYGFzc2V0VGhpcmRUeXBlRXZlbnQgJHtpc0FsbH1gKTtcbiAgICBzd2l0Y2ggKHR5cGUpIHtcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLnVzZHRNOlxuICAgICAgICAgICAgdXNkdE1BbGwgPSBpc0FsbDtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuY29pblA6XG4gICAgICAgICAgICBjb2luUEFsbCA9IGlzQWxsO1xuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS5jb2luRnV0dXJlczpcbiAgICAgICAgICAgIGNvaW5NQWxsID0gaXNBbGw7XG4gICAgICAgICAgICBicmVhaztcbiAgICB9XG4gICAgdXBkYXRlUGFnZUxpc3RCeVR5cGUoY3VycmVudERpc3RyaWJ1dGlvblR5cGUpO1xufVxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGFzc2V0VGFiRXZlbnQoYWNjb3VudCwgcmVmcmVzaCA9IHRydWUsIHVwZGF0ZVR5cGUgPSB0cnVlKSB7XG4gICAgaWYgKHVwZGF0ZVR5cGUpIHtcbiAgICAgICAgY3VycmVudERpc3RyaWJ1dGlvblR5cGUgPSBhY2NvdW50O1xuICAgICAgICB1cGRhdGVQYWdlTGlzdEhlYWRlckJ5VHlwZShhY2NvdW50KTtcbiAgICAgICAgdXBkYXRlUGFnZUxpc3RCeVR5cGUoYWNjb3VudCk7XG4gICAgfVxuICAgIGNvbnNvbGUubG9nKGBhc3NldFRhYkV2ZW50ICR7YWNjb3VudH0gJHtyZWZyZXNofSAke3VwZGF0ZVR5cGV9YCk7XG4gICAgaWYgKCFyZWZyZXNoKSB7XG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgc3dpdGNoIChhY2NvdW50KSB7XG4gICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS5zcG90OlxuICAgICAgICAgICAgY29uc29sZS5sb2coJ2dldFNwb3RBY2NvdW50SW5mbyAxJyk7XG4gICAgICAgICAgICBnZXRTcG90QWNjb3VudEluZm8oYWNjb3VudCk7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmJvdDpcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKCdnZXRTcG90QWNjb3VudEluZm8gYm90Jyk7XG4gICAgICAgICAgICBnZXRTcG90Qm90SW5mbyhhY2NvdW50KTtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuY29sbGF0ZXJhbDpcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKCdnZXRTcG90QWNjb3VudEluZm8gY29sbGF0ZXJhbCcpO1xuICAgICAgICAgICAgZ2V0U3BvdENvbGxhdGVyYWxJbmZvKGFjY291bnQpO1xuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS51c2R0TTpcbiAgICAgICAgICAgIGlzQ29udHJhY3RPcGVuQ29uZmlnID8gZ2V0Q29udHJhY3RVc2R0TVVuaXR5KCkgOiBnZXRDb250cmFjdFVzZHRNKCk7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmNvbnRyYWN0Q29weTpcbiAgICAgICAgICAgIGdldENvcHlUcmFkaW5nRGF0YSgpO1xuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS5jb2luUDpcbiAgICAgICAgICAgIGdldENvbnRyYWN0Q29pblBlcnBldHVhbCgpO1xuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS5jb2luRnV0dXJlczpcbiAgICAgICAgICAgIGdldENvbnRyYWN0Q29pbkZ1dHVyZXMoKTtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUub3RjOlxuICAgICAgICAgICAgZ2V0T1RDRGF0YSgpO1xuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS5vcHRpb246XG4gICAgICAgICAgICBnZXRPcHRpb25EYXRhKCcxMjM0Jyk7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmVhcm46XG4gICAgICAgICAgICBnZXRFYXJuRGF0YShcIjBcIik7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmVhcm5GaXhlZDpcbiAgICAgICAgICAgIGdldEVhcm5EYXRhKFwiMVwiKTtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuZWFybkhpZ2g6XG4gICAgICAgICAgICBnZXRFYXJuRGF0YShcIjNcIik7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmVhcm5Ob2RlUGxlZGdlOlxuICAgICAgICAgICAgZ2V0RWFybkRhdGEoXCI0XCIpO1xuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS5lYXJuU2hhcmtGaW46XG4gICAgICAgICAgICBnZXRFYXJuRGF0YShcIjVcIik7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmFsbFJlcG86XG4gICAgICAgICAgICBnZXRNYXJnaW5BbGwoKTtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUucGFydFJlcG86XG4gICAgICAgICAgICBnZXRNYXJnaW5QYXJ0KCk7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmNvbnRyYWN0R3JpZDpcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKCdnZXRDb250cmFjdEdyaWREYXRhJyk7XG4gICAgICAgICAgICBnZXRDb250cmFjdEdyaWREYXRhKCk7XG4gICAgICAgICAgICBicmVhaztcbiAgICB9XG59XG5cbnZhciBzb3J0VHlwZSA9IDA7XG52YXIgc29ydFNlcXVlbmNlID0gMDtcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBzb3J0RXZlbnQoYXJncykge1xuICAgIGNvbnN0IHBhcmFtcyA9IEpTT04ucGFyc2UoYXJncyk7XG4gICAgc29ydFNlcXVlbmNlID0gcGFyYW1zLnNvcnRTZXF1ZW5jZTtcbiAgICBzb3J0VHlwZSA9IHBhcmFtcy50eXBlO1xuICAgIHVwZGF0ZVNwb3RDdXJyZW5jaWVzRGF0YShjYWNoZURhdGEuc3BvdC5zcG90LmN1cnJlbmNpZXMsIDApO1xufVxudmFyIHNvcnRCb3RUeXBlID0gMDtcbnZhciBzb3J0Qm90U2VxdWVuY2UgPSAwO1xuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNvcnRCb3RFdmVudChhcmdzKSB7XG4gICAgY29uc3QgcGFyYW1zID0gSlNPTi5wYXJzZShhcmdzKTtcbiAgICBzb3J0Qm90U2VxdWVuY2UgPSBwYXJhbXMuc29ydFNlcXVlbmNlO1xuICAgIHNvcnRCb3RUeXBlID0gcGFyYW1zLnR5cGU7XG4gICAgdXBkYXRlQm90Q3VycmVuY2llc0RhdGEoY2FjaGVEYXRhLnNwb3QuYm90LmN1cnJlbmNpZXMpO1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc29ydFNwb3RMaXN0KGxpc3QpIHtcbiAgICBjb25zdCB6ZXJvQ3VycmVuY2llcyA9IFtdO1xuICAgIGNvbnN0IG5vdFplcm9DdXJyZW5jaWVzID0gW107XG4gICAgbGlzdC5maWx0ZXIoKGl0ZW0pID0+IHtcbiAgICAgICAgaWYgKGl0ZW0uYmFsYW5jZSA9PT0gMCkge1xuICAgICAgICAgICAgemVyb0N1cnJlbmNpZXMucHVzaChpdGVtKTtcbiAgICAgICAgfVxuICAgICAgICBlbHNlIHtcbiAgICAgICAgICAgIG5vdFplcm9DdXJyZW5jaWVzLnB1c2goaXRlbSk7XG4gICAgICAgIH1cbiAgICB9KTtcbiAgICBjb25zdCBub25lQ3VycmVuY2llcyA9IGF3YWl0IFByb21pc2UuYWxsKG5vdFplcm9DdXJyZW5jaWVzLm1hcChhc3luYyAoaXRlbSkgPT4ge1xuICAgICAgICB0cnkge1xuICAgICAgICAgICAgcmV0dXJuIHtcbiAgICAgICAgICAgICAgICBzb3J0S2V5OiBhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnQoaXRlbS5jdXJyZW5jeSwgaXRlbS5wb3NpdGlvbk51bSksXG4gICAgICAgICAgICAgICAgLi4uaXRlbVxuICAgICAgICAgICAgfTtcbiAgICAgICAgfSBjYXRjaCAoZSkge1xuICAgICAgICAgICAgY29uc29sZS5lcnJvcihgYm90IG5vdFplcm9DdXJyZW5jaWVzLm1hcCAke2V9YCk7XG4gICAgICAgICAgICByZXR1cm4ge307XG4gICAgICAgIH1cbiAgICB9KSk7XG4gICAgbm9uZUN1cnJlbmNpZXMuc29ydCgoYSwgYikgPT4ge1xuICAgICAgICBpZiAoc29ydFNlcXVlbmNlID09PSAxKSB7XG4gICAgICAgICAgICBpZiAoc29ydFR5cGUgPT09IDIpIHtcbiAgICAgICAgICAgICAgICByZXR1cm4gYS50b2RheVByb2ZpdCAtIGIudG9kYXlQcm9maXQ7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBlbHNlIGlmIChzb3J0VHlwZSA9PT0gMykge1xuICAgICAgICAgICAgICAgIHJldHVybiBhLnRvZGF5UHJvZml0UmF0ZSAtIGIudG9kYXlQcm9maXRSYXRlO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgZWxzZSBpZiAoc29ydFR5cGUgPT0gMSkge1xuICAgICAgICAgICAgICAgIHJldHVybiBhLnNvcnRLZXkgLSBiLnNvcnRLZXk7XG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgIHJldHVybiBhLnNvcnRLZXkgLSBiLnNvcnRLZXk7XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICBpZiAoc29ydFR5cGUgPT09IDIpIHtcbiAgICAgICAgICAgICAgICByZXR1cm4gYi50b2RheVByb2ZpdCAtIGEudG9kYXlQcm9maXQ7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBlbHNlIGlmIChzb3J0VHlwZSA9PT0gMykge1xuICAgICAgICAgICAgICAgIHJldHVybiBiLnRvZGF5UHJvZml0UmF0ZSAtIGEudG9kYXlQcm9maXRSYXRlO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgZWxzZSBpZiAoc29ydFR5cGUgPT0gMSkge1xuICAgICAgICAgICAgICAgIHJldHVybiBiLnNvcnRLZXkgLSBhLnNvcnRLZXk7XG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgIHJldHVybiBiLnNvcnRLZXkgLSBhLnNvcnRLZXk7XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICB9KTtcbiAgICBjb25zdCBuZXdMaXN0ID0gWy4uLm5vbmVDdXJyZW5jaWVzLCAuLi56ZXJvQ3VycmVuY2llc107XG4gICAgcmV0dXJuIG5ld0xpc3Q7XG59XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50Rm9yQ29sbGF0ZXJhbChpdGVtKSB7XG4gICAgcmV0dXJuIGl0ZW0udXNkdEFtb3VudDtcbn1cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRGb3JDb250cmFjdEFsbChpdGVtKSB7XG4gICAgcmV0dXJuIGF3YWl0IGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudChpdGVtLnN5bWJvbCwgaXRlbS5tYXJnaW5CYWxhbmNlKTtcbn1cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRGb3JDb250cmFjdEFsbFVzZHRNKGl0ZW0pIHtcbiAgICByZXR1cm4gaXRlbS5tYXJnaW5CYWxhbmNlO1xufVxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudEZvckNvbnRyYWN0T3duZWQoaXRlbSkge1xuICAgIHJldHVybiBhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnQoaXRlbS5zeW1ib2wsIGl0ZW0ucHJvZml0KTtcbn1cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRGb3JPcHRpb24oaXRlbSkge1xuICAgIHJldHVybiBhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnQoaXRlbS5jdXJyZW5jeSwgaXRlbS5hdmFpbGFibGVOdW0pO1xufVxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudEZvckVhcm4oaXRlbSkge1xuICAgIHJldHVybiBhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnQoaXRlbS5jdXJyZW5jeSwgaXRlbS5taW5pbmdBbW91bnQpO1xufVxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudEZvck1hcmdpbkFsbChpdGVtKSB7XG4gICAgcmV0dXJuIGF3YWl0IGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudChpdGVtLnN5bWJvbE5hbWUsIGl0ZW0uYXZhaWxhYmxlKTtcbn1cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRGb3JNYXJnaW5QYXJ0KGl0ZW0pIHtcbiAgICByZXR1cm4gYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50KGl0ZW0ucXVvdGVDdXJyZW5jeURpc3BsYXlOYW1lLCBpdGVtLm1hcmdpbkVxdWl2YWxlbnRGaXhlZCk7XG59XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50Rm9yT3RjKGl0ZW0pIHtcbiAgICByZXR1cm4gYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50KGl0ZW0uY29pbk5hbWUsIGl0ZW0udG90YWwpO1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50Rm9yQ29weVRyYWRpbmcoaXRlbSkge1xuICAgIHJldHVybiBhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnQoaXRlbS5zeW1ib2wsIGl0ZW0ud2l0aGRyYXdBdmFpbGFibGUpO1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc29ydExpc3QobGlzdCwgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50RnVuY3Rpb24pIHtcbiAgICBjb25zdCB6ZXJvQ3VycmVuY2llcyA9IFtdO1xuICAgIGNvbnN0IG5vdFplcm9DdXJyZW5jaWVzID0gW107XG4gICAgbGlzdC5maWx0ZXIoKGl0ZW0pID0+IHtcbiAgICAgICAgaWYgKGl0ZW0uYmFsYW5jZSA9PT0gMCkge1xuICAgICAgICAgICAgemVyb0N1cnJlbmNpZXMucHVzaChpdGVtKTtcbiAgICAgICAgfVxuICAgICAgICBlbHNlIHtcbiAgICAgICAgICAgIG5vdFplcm9DdXJyZW5jaWVzLnB1c2goaXRlbSk7XG4gICAgICAgIH1cbiAgICB9KTtcblxuICAgIGNvbnN0IG5vbmVDdXJyZW5jaWVzID0gYXdhaXQgUHJvbWlzZS5hbGwobm90WmVyb0N1cnJlbmNpZXMubWFwKGFzeW5jIChpdGVtKSA9PiB7XG4gICAgICAgIHRyeSB7XG4gICAgICAgICAgICByZXR1cm4ge1xuICAgICAgICAgICAgICAgIHNvcnRLZXk6IGF3YWl0IGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudEZ1bmN0aW9uKGl0ZW0pLFxuICAgICAgICAgICAgICAgIC4uLml0ZW1cbiAgICAgICAgICAgIH07XG4gICAgICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgICAgIGNvbnNvbGUuZXJyb3IoYGJvdCBub3RaZXJvQ3VycmVuY2llcy5tYXAgJHtlfWApO1xuICAgICAgICAgICAgcmV0dXJuIHt9O1xuICAgICAgICB9XG4gICAgfSkpO1xuICAgIG5vbmVDdXJyZW5jaWVzLnNvcnQoKGEsIGIpID0+IHtcbiAgICAgICAgcmV0dXJuIGIuc29ydEtleSAtIGEuc29ydEtleTtcbiAgICB9KTtcbiAgICBjb25zdCBuZXdMaXN0ID0gWy4uLm5vbmVDdXJyZW5jaWVzLCAuLi56ZXJvQ3VycmVuY2llc107XG4gICAgcmV0dXJuIG5ld0xpc3Q7XG59XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc29ydEJvdExpc3QobGlzdCkge1xuICAgIGNvbnN0IHplcm9DdXJyZW5jaWVzID0gW107XG4gICAgY29uc3Qgbm90WmVyb0N1cnJlbmNpZXMgPSBbXTtcbiAgICBsaXN0LmZpbHRlcigoaXRlbSkgPT4ge1xuICAgICAgICBpZiAoaXRlbS5iYWxhbmNlID09PSAwKSB7XG4gICAgICAgICAgICB6ZXJvQ3VycmVuY2llcy5wdXNoKGl0ZW0pO1xuICAgICAgICB9XG4gICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgbm90WmVyb0N1cnJlbmNpZXMucHVzaChpdGVtKTtcbiAgICAgICAgfVxuICAgIH0pO1xuXG4gICAgY29uc3Qgbm9uZUN1cnJlbmNpZXMgPSBhd2FpdCBQcm9taXNlLmFsbChub3RaZXJvQ3VycmVuY2llcy5tYXAoYXN5bmMgKGl0ZW0pID0+IHtcbiAgICAgICAgdHJ5IHtcblxuICAgICAgICAgICAgcmV0dXJuIHtcbiAgICAgICAgICAgICAgICBzb3J0UHJvZml0OiBhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnQoaXRlbS5xdW90ZUN1cnJlbmN5LCBpdGVtLnRvdGFsUHJvZml0KSxcbiAgICAgICAgICAgICAgICBzb3J0QXZhOiBhd2FpdCBnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnQoaXRlbS5xdW90ZUN1cnJlbmN5LCBpdGVtLmludmVzdEFtb3VudCksXG4gICAgICAgICAgICAgICAgLi4uaXRlbVxuICAgICAgICAgICAgfTtcbiAgICAgICAgfSBjYXRjaCAoZSkge1xuICAgICAgICAgICAgY29uc29sZS5lcnJvcihgYm90IG5vdFplcm9DdXJyZW5jaWVzLm1hcCAke2V9YCk7XG4gICAgICAgICAgICByZXR1cm4ge307XG4gICAgICAgIH1cbiAgICB9KSk7XG4gICAgLy8gbm9uZUN1cnJlbmNpZXMuc29ydCgoYSwgYikgPT4ge1xuICAgIC8vICAgICBpZiAoc29ydEJvdFNlcXVlbmNlID09PSAxKSB7XG4gICAgLy8gICAgICAgICBpZiAoc29ydEJvdFR5cGUgPT09IDIpIHtcbiAgICAvLyAgICAgICAgICAgICByZXR1cm4gYS5zb3J0UHJvZml0IC0gYi5zb3J0UHJvZml0O1xuICAgIC8vICAgICAgICAgfVxuICAgIC8vICAgICAgICAgZWxzZSBpZiAoc29ydEJvdFR5cGUgPT09IDMpIHtcbiAgICAvLyAgICAgICAgICAgICByZXR1cm4gYS50b3RhbFByb2ZpdFJhdGUgLSBiLnRvdGFsUHJvZml0UmF0ZTtcbiAgICAvLyAgICAgICAgIH0gZWxzZSB7XG4gICAgLy8gICAgICAgICAgICAgY29uc29sZS5sb2coYHNvcnRCb3RMaXN0IGRpdiBhICR7YS5zb3J0QXZhIC0gYi5zb3J0QXZhfWApO1xuICAgIC8vICAgICAgICAgICAgIHJldHVybiBhLnNvcnRBdmEgLSBiLnNvcnRBdmE7XG4gICAgLy8gICAgICAgICB9XG4gICAgLy8gICAgIH1cbiAgICAvLyAgICAgZWxzZSB7XG4gICAgLy8gICAgICAgICBpZiAoc29ydEJvdFR5cGUgPT09IDIpIHtcbiAgICAvLyAgICAgICAgICAgICByZXR1cm4gYi5zb3J0UHJvZml0IC0gYS5zb3J0UHJvZml0O1xuICAgIC8vICAgICAgICAgfVxuICAgIC8vICAgICAgICAgZWxzZSBpZiAoc29ydEJvdFR5cGUgPT09IDMpIHtcbiAgICAvLyAgICAgICAgICAgICByZXR1cm4gYi50b3RhbFByb2ZpdFJhdGUgLSBhLnRvdGFsUHJvZml0UmF0ZTtcbiAgICAvLyAgICAgICAgIH0gZWxzZSB7XG4gICAgLy8gICAgICAgICAgICAgY29uc29sZS5sb2coYHNvcnRCb3RMaXN0IGRpdiBiICR7Yi5zb3J0QXZhIC0gYS5zb3J0QXZhfWApO1xuICAgIC8vICAgICAgICAgICAgIHJldHVybiBiLnNvcnRBdmEgLSBhLnNvcnRBdmE7XG4gICAgLy8gICAgICAgICB9XG4gICAgLy8gICAgIH1cbiAgICAvLyB9KTtcbiAgICBjb25zdCBuZXdMaXN0ID0gWy4uLm5vbmVDdXJyZW5jaWVzLCAuLi56ZXJvQ3VycmVuY2llc107XG4gICAgcmV0dXJuIG5ld0xpc3Q7XG59XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gaGlkZGVuQWxsQXNzZXQoKSB7XG4gICAgdXBkYXRlUGFnZURhdGFCeVR5cGUoY3VycmVudERpc3RyaWJ1dGlvblR5cGUsIDApO1xuICAgICRkYXRhLm9wZW5WaXNpYmlsaXR5ID0gXCJnb25lXCI7XG4gICAgJGRhdGEuY2xvc2VWaXNpYmlsaXR5ID0gXCJ2aXNpYmxlXCI7XG4gICAgJGRhdGEudXNkdFZpcyA9IFwiZ29uZVwiO1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc2hvd0FsbEFzc2V0KCkge1xuICAgIHVwZGF0ZVBhZ2VEYXRhQnlUeXBlKGN1cnJlbnREaXN0cmlidXRpb25UeXBlLCAwKTtcbiAgICAkZGF0YS5vcGVuVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuICAgICRkYXRhLmNsb3NlVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xufVxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHVwZGF0ZVBhZ2VEYXRhQnlUeXBlKHR5cGUpIHtcbiAgICB1cGRhdGVUb3RhbEFzc2V0RGF0YShjYWNoZURhdGEuYmFsYW5jZSk7XG4gICAgY29uc29sZS5sb2coYHVwZGF0ZVBhZ2VEYXRhQnlUeXBlICR7dHlwZX1gKTtcbiAgICB1cGRhdGVQYWdlTGlzdEhlYWRlckJ5VHlwZSh0eXBlKTtcbiAgICB1cGRhdGVQYWdlTGlzdEJ5VHlwZSh0eXBlLCAwKTtcbiAgICBoaWRlRGVwb3NpdFdpdGhkcmF3KCk7XG59XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gdXBkYXRlUGFnZUxpc3RIZWFkZXJCeVR5cGUodHlwZSkge1xuICAgIHN3aXRjaCAodHlwZSkge1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuc3BvdDpcbiAgICAgICAgICAgIHVwZGF0ZVNwb3RCYXNlSW5mb0RhdGEoY2FjaGVEYXRhLnNwb3Quc3BvdC5iYXNlSW5mbyk7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmJvdDpcbiAgICAgICAgICAgIHVwZGF0ZUJvdEJhc2VJbmZvRGF0YShjYWNoZURhdGEuc3BvdC5ib3QuYmFzZUluZm8pO1xuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS5jb2xsYXRlcmFsOlxuICAgICAgICAgICAgdXBkYXRlU3BvdENvbGxhdGVyYWxCYXNlSW5mb0RhdGEoY2FjaGVEYXRhLnNwb3QuY29sbGF0ZXJhbC5iYXNlSW5mbyk7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmNvaW5QOlxuICAgICAgICAgICAgdXBkYXRlQ29pblBCYXNlSW5mb0RhdGEoY2FjaGVEYXRhLmNvbnRyYWN0LmNvaW5fcC5iYXNlSW5mbyk7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmNvaW5GdXR1cmVzOlxuICAgICAgICAgICAgdXBkYXRlQ29pbk1CYXNlSW5mb0RhdGEoY2FjaGVEYXRhLmNvbnRyYWN0LmNvaW5fZi5iYXNlSW5mbyk7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLnVzZHRNOlxuICAgICAgICAgICAgdXBkYXRlTGluZWFyU3dhcEJhc2VJbmZvRGF0YShjYWNoZURhdGEuY29udHJhY3QudXNkdF9tLmJhc2VJbmZvKTtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuY29udHJhY3RDb3B5OlxuICAgICAgICAgICAgdXBkYXRlQ29weVRyYWRpbmdCYXNlSW5mbyhjYWNoZURhdGEuY29udHJhY3QuY29weV90cmFkaW5nLmJhc2VJbmZvKTtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUub3RjOlxuICAgICAgICAgICAgdXBkYXRlT3RjQmFzZUluZm8oY2FjaGVEYXRhLm90Yy5iYXNlSW5mbyk7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmFsbFJlcG86XG4gICAgICAgICAgICB1cGRhdGVNYXJnaW5BbGxJbmZvKGNhY2hlRGF0YS5tYXJnaW4uYWxsUmVwby5iYXNlSW5mbyk7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLnBhcnRSZXBvOlxuICAgICAgICAgICAgdXBkYXRlTWFyZ2luUGFydEJhc2VJbmZvKGNhY2hlRGF0YS5tYXJnaW4ucGFydFJlcG8uYmFzZUluZm8pO1xuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS5vcHRpb246XG4gICAgICAgICAgICB1cGRhdGVPcHRpb25CYXNlSW5mbyhjYWNoZURhdGEub3B0aW9uLmJhc2VJbmZvKTtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuZWFybjpcbiAgICAgICAgICAgIHVwZGF0ZUVhcm5ZYmJCYXNlSW5mbyhjYWNoZURhdGEuZWFybi5lYXJuWWJiLmJhc2VJbmZvKTtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuZWFybkZpeGVkOlxuICAgICAgICAgICAgdXBkYXRlRWFybkZpeGVkQmFzZUluZm8oY2FjaGVEYXRhLmVhcm4uZWFybkZpeGVkLmJhc2VJbmZvKTtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuZWFybkhpZ2g6XG4gICAgICAgICAgICB1cGRhdGVFYXJuSGlnaEJhc2VJbmZvKGNhY2hlRGF0YS5lYXJuLmVhcm5IaWdoLmJhc2VJbmZvKTtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuZWFybk5vZGVQbGVkZ2U6XG4gICAgICAgICAgICB1cGRhdGVFYXJuTm9kZVBsZWRnZUJhc2VJbmZvKGNhY2hlRGF0YS5lYXJuLmVhcm5Ob2RlUGxlZGdlLmJhc2VJbmZvKTtcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmVhcm5TaGFya0ZpbjpcbiAgICAgICAgICAgIHVwZGF0ZUVhcm5TaGFya0ZpbkJhc2VJbmZvKGNhY2hlRGF0YS5lYXJuLmVhcm5TaGFya0Zpbi5iYXNlSW5mbyk7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmNvbnRyYWN0R3JpZDpcbiAgICAgICAgICAgIHVwZGF0ZUNvbnRyYWN0R3JpZEJhc2VJbmZvKGNhY2hlRGF0YS5jb250cmFjdEdyaWQuYmFzZUluZm8pO1xuICAgICAgICAgICAgYnJlYWs7XG4gICAgfVxufVxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHVwZGF0ZVBhZ2VMaXN0QnlUeXBlKHR5cGUsIGZvcmNlUmVmcmVzaEZsYWcgPSAxKSB7XG4gICAgY29uc29sZS5sb2coYHVwZGF0ZVBhZ2VMaXN0QnlUeXBlICR7dHlwZX1gKTtcbiAgICBzd2l0Y2ggKHR5cGUpIHtcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLnNwb3Q6XG4gICAgICAgICAgICB1cGRhdGVTcG90Q3VycmVuY2llc0RhdGEoY2FjaGVEYXRhLnNwb3Quc3BvdC5jdXJyZW5jaWVzLCBmb3JjZVJlZnJlc2hGbGFnKTtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuYm90OlxuICAgICAgICAgICAgdXBkYXRlQm90Q3VycmVuY2llc0RhdGEoY2FjaGVEYXRhLnNwb3QuYm90LmN1cnJlbmNpZXMpO1xuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS5jb2xsYXRlcmFsOlxuICAgICAgICAgICAgdXBkYXRlU3BvdENvbGxhdGVyYWxDdXJyZW5jeURhdGEoY2FjaGVEYXRhLnNwb3QuY29sbGF0ZXJhbC5sb2FuaW5nTGlzdCwgY2FjaGVEYXRhLnNwb3QuY29sbGF0ZXJhbC5wbGVkZ2VMaXN0KTtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuY29pblA6XG4gICAgICAgICAgICBpZiAoY29pblBBbGwpIHtcbiAgICAgICAgICAgICAgICB1cGRhdGVDb250cmFjdEFsbERhdGEodHlwZSwgY2FjaGVEYXRhLmNvbnRyYWN0LmNvaW5fcC5hbGwubGlzdCk7XG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgIHVwZGF0ZUNvbnRyYWN0T3duZWREYXRhKHR5cGUsIGNhY2hlRGF0YS5jb250cmFjdC5jb2luX3Aub3duZWQubGlzdCk7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmNvaW5GdXR1cmVzOlxuICAgICAgICAgICAgaWYgKGNvaW5NQWxsKSB7XG4gICAgICAgICAgICAgICAgdXBkYXRlQ29udHJhY3RBbGxEYXRhKHR5cGUsIGNhY2hlRGF0YS5jb250cmFjdC5jb2luX2YuYWxsLmxpc3QpO1xuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICB1cGRhdGVDb250cmFjdE93bmVkRGF0YSh0eXBlLCBjYWNoZURhdGEuY29udHJhY3QuY29pbl9mLm93bmVkLmxpc3QpO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS51c2R0TTpcbiAgICAgICAgICAgIGlmICh1c2R0TUFsbCkge1xuICAgICAgICAgICAgICAgIGlzQ29udHJhY3RPcGVuQ29uZmlnID8gdXBkYXRlQ29udHJhY3RVc2R0TVVuaXR5RGF0YShjYWNoZURhdGEuY29udHJhY3QudXNkdF9tX3VuaXR5LmFsbC5saXN0KSA6IHVwZGF0ZUNvbnRyYWN0QWxsRGF0YSh0eXBlLCBjYWNoZURhdGEuY29udHJhY3QudXNkdF9tLmFsbC5saXN0KTtcbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgdXBkYXRlQ29udHJhY3RPd25lZERhdGEodHlwZSwgaXNDb250cmFjdE9wZW5Db25maWcgPyBjYWNoZURhdGEuY29udHJhY3QudXNkdF9tX3VuaXR5Lm93bmVkLmxpc3QgOiBjYWNoZURhdGEuY29udHJhY3QudXNkdF9tLm93bmVkLmxpc3QpO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS5jb250cmFjdENvcHk6XG4gICAgICAgICAgICB1cGRhdGVDb3B5VHJhZGluZ0xpc3QoY2FjaGVEYXRhLmNvbnRyYWN0LmNvcHlfdHJhZGluZy5saXN0KTtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUub3RjOlxuICAgICAgICAgICAgdXBkYXRlT3RjRGF0YShjYWNoZURhdGEub3RjLmRhdGEpO1xuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS5hbGxSZXBvOlxuICAgICAgICAgICAgdXBkYXRlTWFyZ2luQWxsRGF0YShjYWNoZURhdGEubWFyZ2luLmFsbFJlcG8ubGlzdCk7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLnBhcnRSZXBvOlxuICAgICAgICAgICAgdXBkYXRlTWFyZ2luUGFydERhdGEoY2FjaGVEYXRhLm1hcmdpbi5wYXJ0UmVwby5saXN0KTtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUub3B0aW9uOlxuICAgICAgICAgICAgdXBkYXRlT3B0aW9uRGF0YShjYWNoZURhdGEub3B0aW9uLmxpc3QpO1xuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS5lYXJuOlxuICAgICAgICAgICAgdXBkYXRlRWFybkRhdGEoJzAnLCBjYWNoZURhdGEuZWFybi5lYXJuWWJiLmxpc3QpO1xuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS5lYXJuRml4ZWQ6XG4gICAgICAgICAgICB1cGRhdGVFYXJuRGF0YSgnMScsIGNhY2hlRGF0YS5lYXJuLmVhcm5GaXhlZC5saXN0KTtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuZWFybkhpZ2g6XG4gICAgICAgICAgICB1cGRhdGVFYXJuSGlnaERhdGEoJzMnLCBjYWNoZURhdGEuZWFybi5lYXJuSGlnaC5saXN0KTtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuZWFybk5vZGVQbGVkZ2U6XG4gICAgICAgICAgICB1cGRhdGVFYXJuTm9kZVBsZWRnZURhdGEoJzQnLCBjYWNoZURhdGEuZWFybi5lYXJuTm9kZVBsZWRnZS5saXN0KTtcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmVhcm5TaGFya0ZpbjpcbiAgICAgICAgICAgIHVwZGF0ZUVhcm5TaGFya0ZpbkRhdGEoJzUnLCBjYWNoZURhdGEuZWFybi5lYXJuU2hhcmtGaW4ubGlzdCk7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmNvbnRyYWN0R3JpZDpcbiAgICAgICAgICAgIHVwZGF0ZUNvbnRyYWN0R3JpZERhdGEoY2FjaGVEYXRhLmNvbnRyYWN0R3JpZC5saXN0KTtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgIH1cbn1cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRDdXJyZW5jeSgpIHtcbiAgICBjb25zdCBjdXJyZW5jeSA9IGF3YWl0ICRuYXRpdmVBUEkuY3VycmVuY3lDb21tb24oJ3tcInR5cGVcIjozfScpO1xuICAgIHJldHVybiBjdXJyZW5jeTtcbn1cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRUb3RhbEFzc2V0Q3VycmVuY3koKSB7XG4gICAgY29uc3QgY3VycmVuY3kgPSBhd2FpdCAkbmF0aXZlQVBJLmN1cnJlbmN5Q29tbW9uKCd7XCJ0eXBlXCI6NH0nKTtcbiAgICByZXR1cm4gY3VycmVuY3k7XG59XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZ2V0TGVnYWxDdXJyZW5jeVN5bWJvbCgpIHtcbiAgICBjb25zdCBjdXJyZW5jeVN5bWJvbCA9IGF3YWl0ICRuYXRpdmVBUEkuY3VycmVuY3lDb21tb24oJ3tcInR5cGVcIjo5fScpO1xuICAgIHJldHVybiBjdXJyZW5jeVN5bWJvbDtcbn1cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRJY29uVXJsKGN1cnJlbmN5KSB7XG5cbiAgICBjb25zdCBwYXJhbXMgPSB7XG4gICAgICAgIHR5cGU6IDYsXG4gICAgICAgIGN1cnJlbmN5XG4gICAgfTtcbiAgICBjb25zdCBpY29uVXJsID0gYXdhaXQgJG5hdGl2ZUFQSS5jdXJyZW5jeUNvbW1vbihKU09OLnN0cmluZ2lmeShwYXJhbXMpKTtcbiAgICByZXR1cm4gaWNvblVybDtcbn1cblxuZnVuY3Rpb24gaWNvblBhY2thZ2UoY3VycmVuY3kpIHtcbiAgICByZXR1cm4geyB0eXBlOiA2LCBjdXJyZW5jeTogY3VycmVuY3kgfTtcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGdldFdvcmQod29yZEtleSkge1xuICAgIGNvbnN0IHBhcmFtcyA9IHtcbiAgICAgICAgdHlwZTogNyxcbiAgICAgICAgd29yZEtleVxuICAgIH07XG4gICAgY29uc3Qgd29yZCA9IGF3YWl0ICRuYXRpdmVBUEkuY3VycmVuY3lDb21tb24oSlNPTi5zdHJpbmdpZnkocGFyYW1zKSk7XG4gICAgcmV0dXJuIHdvcmQ7XG59XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZm9ybWF0TnVtKG51bWJlcikge1xuICAgIGlmIChudW1iZXIgPT09ICctLScpIHtcbiAgICAgICAgcmV0dXJuIG51bWJlcjtcbiAgICB9XG4gICAgY29uc3QgcGFyYW1zID0ge1xuICAgICAgICB0eXBlOiA1MyxcbiAgICAgICAgbnVtYmVyXG4gICAgfTtcbiAgICBjb25zdCB3b3JkID0gYXdhaXQgJG5hdGl2ZUFQSS5jdXJyZW5jeUNvbW1vbihKU09OLnN0cmluZ2lmeShwYXJhbXMpKTtcbiAgICByZXR1cm4gd29yZDtcbn1cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBmb3JtYXROdW1XaXRoUHJlY2lzaW9uKGFtb3VudCwgcHJlY2lzaW9uKSB7XG4gICAgaWYgKGFtb3VudCA9PT0gXCItLVwiKSB7XG4gICAgICAgIHJldHVybiBhbW91bnQ7XG4gICAgfVxuICAgIGlmIChwcmVjaXNpb24gPT0gbnVsbCB8fCBwcmVjaXNpb24gPT0gdW5kZWZpbmVkKSB7XG4gICAgICAgIHJldHVybiBgJHthbW91bnR9YDtcbiAgICB9XG4gICAgY29uc3QgcGFyYW1zID0ge1xuICAgICAgICB0eXBlOiAxMTIsXG4gICAgICAgIGFtb3VudCxcbiAgICAgICAgcHJlY2lzaW9uLFxuICAgIH07XG4gICAgY29uc3Qgd29yZCA9IGF3YWl0ICRuYXRpdmVBUEkuY3VycmVuY3lDb21tb24oSlNPTi5zdHJpbmdpZnkocGFyYW1zKSk7XG4gICAgcmV0dXJuIHdvcmQ7XG59XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gcmlzZUNvbG9yKG51bSkge1xuICAgIGNvbnN0IGdyZWVuUmlzZSA9IGF3YWl0IHVwc0FuZERvd25zQ29sb3IoKTtcbiAgICB2YXIgcmF0ZSA9IE51bWJlci5wYXJzZUZsb2F0KG51bSk7XG4gICAgaWYgKGdyZWVuUmlzZSA9PSBcIjFcIikge1xuICAgICAgICBpZiAocmF0ZSA+IDApIHtcbiAgICAgICAgICAgIHJldHVybiAnQGNvbG9yL2tDb2xvclByaWNlR3JlZW4nO1xuICAgICAgICB9IGVsc2UgaWYgKHJhdGUgPCAwKSB7XG4gICAgICAgICAgICByZXR1cm4gJ0Bjb2xvci9rQ29sb3JQcmljZVJlZCc7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICByZXR1cm4gJ0Bjb2xvci9rQ29sb3JTZWNvbmRhcnlUZXh0JztcbiAgICAgICAgfVxuICAgIH0gZWxzZSB7XG4gICAgICAgIGlmIChyYXRlID4gMCkge1xuICAgICAgICAgICAgcmV0dXJuICdAY29sb3Iva0NvbG9yUHJpY2VSZWQnO1xuICAgICAgICB9IGVsc2UgaWYgKHJhdGUgPCAwKSB7XG4gICAgICAgICAgICByZXR1cm4gJ0Bjb2xvci9rQ29sb3JQcmljZUdyZWVuJztcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIHJldHVybiAnQGNvbG9yL2tDb2xvclNlY29uZGFyeVRleHQnO1xuICAgICAgICB9XG4gICAgfVxufVxuXG5leHBvcnQgZnVuY3Rpb24gcmlzZUNvbG9yVjIobnVtLCBncmVlblJpc2UpIHtcbiAgICB2YXIgcmF0ZSA9IE51bWJlci5wYXJzZUZsb2F0KG51bSk7XG4gICAgaWYgKGdyZWVuUmlzZSA9PSBcIjFcIikge1xuICAgICAgICBpZiAocmF0ZSA+IDApIHtcbiAgICAgICAgICAgIHJldHVybiAnQGNvbG9yL2tDb2xvclByaWNlR3JlZW4nO1xuICAgICAgICB9IGVsc2UgaWYgKHJhdGUgPCAwKSB7XG4gICAgICAgICAgICByZXR1cm4gJ0Bjb2xvci9rQ29sb3JQcmljZVJlZCc7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICByZXR1cm4gJ0Bjb2xvci9rQ29sb3JTZWNvbmRhcnlUZXh0JztcbiAgICAgICAgfVxuICAgIH0gZWxzZSB7XG4gICAgICAgIGlmIChyYXRlID4gMCkge1xuICAgICAgICAgICAgcmV0dXJuICdAY29sb3Iva0NvbG9yUHJpY2VSZWQnO1xuICAgICAgICB9IGVsc2UgaWYgKHJhdGUgPCAwKSB7XG4gICAgICAgICAgICByZXR1cm4gJ0Bjb2xvci9rQ29sb3JQcmljZUdyZWVuJztcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIHJldHVybiAnQGNvbG9yL2tDb2xvclNlY29uZGFyeVRleHQnO1xuICAgICAgICB9XG4gICAgfVxufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gdXBzQW5kRG93bnNDb2xvcigpIHtcbiAgICBjb25zdCBncmVlblJpc2UgPSBhd2FpdCAkbmF0aXZlQVBJLmN1cnJlbmN5Q29tbW9uKCd7XCJ0eXBlXCI6NTR9Jyk7XG4gICAgcmV0dXJuIGdyZWVuUmlzZTtcbn1cblxuXG5mdW5jdGlvbiB1cHNBbmREb3duc0NvbG9yUGFja2FnZSgpIHtcbiAgICByZXR1cm4geyB0eXBlOiA1NCB9O1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZ2V0V29yZEZvcm1hdCh3b3JkS2V5LCB2YWx1ZSkge1xuICAgIGNvbnN0IHBhcmFtcyA9IHtcbiAgICAgICAgdHlwZTogMjAsXG4gICAgICAgIHdvcmRLZXksXG4gICAgICAgIHZhbHVlXG4gICAgfTtcbiAgICBjb25zdCB3b3JkID0gYXdhaXQgJG5hdGl2ZUFQSS5jdXJyZW5jeUNvbW1vbihKU09OLnN0cmluZ2lmeShwYXJhbXMpKTtcbiAgICByZXR1cm4gd29yZDtcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGdldEJUQ0Ftb3VudChjdXJyZW5jeSwgYW1vdW50KSB7XG4gICAgY29uc3QgcGFyYW1zID0ge1xuICAgICAgICB0eXBlOiAyMixcbiAgICAgICAgY3VycmVuY3ksXG4gICAgICAgIGFtb3VudFxuICAgIH07XG4gICAgY29uc3Qgd29yZCA9IGF3YWl0ICRuYXRpdmVBUEkuY3VycmVuY3lDb21tb24oSlNPTi5zdHJpbmdpZnkocGFyYW1zKSk7XG4gICAgcmV0dXJuIHdvcmQ7XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRDb2xvcihjb2xvcktleSkge1xuICAgIGNvbnN0IHBhcmFtcyA9IHtcbiAgICAgICAgdHlwZTogOCxcbiAgICAgICAgY29sb3JLZXlcbiAgICB9O1xuICAgIGNvbnN0IHdvcmQgPSBhd2FpdCAkbmF0aXZlQVBJLmN1cnJlbmN5Q29tbW9uKEpTT04uc3RyaW5naWZ5KHBhcmFtcykpO1xuICAgIHJldHVybiB3b3JkO1xufVxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGlzU2hvd0Fzc2V0KCkge1xuICAgIGNvbnN0IGlzU2hvdyA9IGF3YWl0ICRuYXRpdmVBUEkuY3VycmVuY3lDb21tb24oJ3tcInR5cGVcIjoxMH0nKTtcbiAgICByZXR1cm4gaXNTaG93O1xufVxuZXhwb3J0IGZ1bmN0aW9uIGZpeE51bWJlcihudW0sIGZpeGVkKSB7XG4gICAgY29uc29sZS5sb2coYGZpeE51bWJlciAke3R5cGVvZiAobnVtKX1gKTtcbiAgICB0cnkge1xuICAgICAgICBpZiAobnVtKSB7XG4gICAgICAgICAgICByZXR1cm4gTnVtYmVyLnBhcnNlRmxvYXQobnVtKS50b0ZpeGVkKGZpeGVkKTtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIHJldHVybiBOdW1iZXIucGFyc2VGbG9hdCgwKS50b0ZpeGVkKGZpeGVkKTtcbiAgICAgICAgfVxuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgcmV0dXJuIE51bWJlci5wYXJzZUZsb2F0KDApLnRvRml4ZWQoZml4ZWQpO1xuICAgIH1cbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGdldENvbnRyYWN0TnVtYmVyKHN5bWJvbCwgY29udHJhY3RDb2RlLCBhbW91bnQsIGNvbnRyYWN0VHlwZSwgbGFzdFByaWNlKSB7XG4gICAgY29uc3QgcGFyYW1zID0ge1xuICAgICAgICB0eXBlOiAzMCxcbiAgICAgICAgc3ltYm9sLFxuICAgICAgICBjb250cmFjdENvZGUsXG4gICAgICAgIGFtb3VudCxcbiAgICAgICAgY29udHJhY3RUeXBlLFxuICAgICAgICBsYXN0UHJpY2VcbiAgICB9O1xuXG4gICAgY29uc3Qgd29yZCA9IGF3YWl0ICRuYXRpdmVBUEkuY3VycmVuY3lDb21tb24oSlNPTi5zdHJpbmdpZnkocGFyYW1zKSk7XG4gICAgY29uc29sZS5sb2coYGdldENvbnRyYWN0TnVtYmVyIC0tLT4gJHt3b3JkfSAgcGFyYW1zOmpzb249JHtKU09OLnN0cmluZ2lmeShwYXJhbXMpfWApO1xuICAgIHJldHVybiB3b3JkO1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50KHN5bWJvbCwgYW1vdW50KSB7XG4gICAgaWYgKCFhbW91bnQpIHtcbiAgICAgICAgYW1vdW50ID0gJzAnO1xuICAgIH1cbiAgICBjb25zdCBwYXJhbSA9IHtcbiAgICAgICAgdHlwZTogMSxcbiAgICAgICAgY3VycmVuY3k6IHN5bWJvbCxcbiAgICAgICAgYW1vdW50LFxuICAgIH07XG4gICAgY29uc3QgcGFyYW1TdHJpbmcgPSBKU09OLnN0cmluZ2lmeShwYXJhbSk7XG4gICAgcmV0dXJuIGF3YWl0ICRuYXRpdmVBUEkuY3VycmVuY3lDb21tb24ocGFyYW1TdHJpbmcpO1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gY29udmVydExlZ2FsVGVuZGVyKHN5bWJvbCwgYW1vdW50LCBjdXJyZW5jeVNjYWxlKSB7XG4gICAgaWYgKCFhbW91bnQpIHtcbiAgICAgICAgYW1vdW50ID0gJzAnO1xuICAgIH1cbiAgICBjb25zdCBwYXJhbSA9IHtcbiAgICAgICAgdHlwZTogMTExLFxuICAgICAgICBjdXJyZW5jeTogc3ltYm9sLFxuICAgICAgICBhbW91bnQsXG4gICAgICAgIGN1cnJlbmN5U2NhbGVcbiAgICB9O1xuICAgIGNvbnN0IHBhcmFtU3RyaW5nID0gSlNPTi5zdHJpbmdpZnkocGFyYW0pO1xuICAgIHJldHVybiBhd2FpdCAkbmF0aXZlQVBJLmN1cnJlbmN5Q29tbW9uKHBhcmFtU3RyaW5nKTtcbn1cblxuZnVuY3Rpb24gZXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50UGFja2FnZShzeW1ib2wsIGFtb3VudCkge1xuICAgIGlmICghYW1vdW50KSB7XG4gICAgICAgIGFtb3VudCA9ICcwJztcbiAgICB9XG4gICAgcmV0dXJuIHsgdHlwZTogMSwgY3VycmVuY3k6IHN5bWJvbCwgYW1vdW50OiBhbW91bnQgfTtcbn1cblxuZnVuY3Rpb24gY29udmVydExlZ2FsVGVuZGVyUGFja2FnZShzeW1ib2wsIGFtb3VudCwgY3VycmVuY3lTY2FsZSkge1xuICAgIGlmICghYW1vdW50KSB7XG4gICAgICAgIGFtb3VudCA9ICcwJztcbiAgICB9XG4gICAgcmV0dXJuIHsgdHlwZTogMTExLCBjdXJyZW5jeTogc3ltYm9sLCBhbW91bnQ6IGFtb3VudCwgY3VycmVuY3lTY2FsZTogY3VycmVuY3lTY2FsZSB9O1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZ2V0VXNkdEFtb3VudChzeW1ib2wsIGFtb3VudCkge1xuICAgIGlmICghYW1vdW50KSB7XG4gICAgICAgIGFtb3VudCA9ICcwJztcbiAgICB9XG4gICAgY29uc3QgcGFyYW0gPSB7XG4gICAgICAgIHR5cGU6IDgwLFxuICAgICAgICBjdXJyZW5jeTogc3ltYm9sLFxuICAgICAgICBhbW91bnQsXG4gICAgfTtcbiAgICBjb25zdCBwYXJhbVN0cmluZyA9IEpTT04uc3RyaW5naWZ5KHBhcmFtKTtcbiAgICByZXR1cm4gYXdhaXQgJG5hdGl2ZUFQSS5jdXJyZW5jeUNvbW1vbihwYXJhbVN0cmluZyk7XG59XG5cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGdldFRvdGFsRWFybkFuZFF1YW50aXR5KHN5bWJvbCwgdG90YWxJbmNvbWVBbW91bnQsIHRvdGFsSW5jb21lQmFsYW5jZSkge1xuICAgIGlmICghdG90YWxJbmNvbWVBbW91bnQpIHtcbiAgICAgICAgdG90YWxJbmNvbWVBbW91bnQgPSAnMCc7XG4gICAgfVxuICAgIGlmICghdG90YWxJbmNvbWVCYWxhbmNlKSB7XG4gICAgICAgIHRvdGFsSW5jb21lQmFsYW5jZSA9ICcwJztcbiAgICB9XG4gICAgY29uc3QgcGFyYW0gPSB7XG4gICAgICAgIHR5cGU6IDE5LFxuICAgICAgICBjdXJyZW5jeTogc3ltYm9sLFxuICAgICAgICBhbW91bnQ6IHRvdGFsSW5jb21lQW1vdW50LFxuICAgIH07XG4gICAgY29uc3QgcGFyYW1TdHJpbmcgPSBKU09OLnN0cmluZ2lmeShwYXJhbSk7XG5cbiAgICBjb25zdCBwYXJhbTIgPSB7XG4gICAgICAgIHR5cGU6IDE5LFxuICAgICAgICBjdXJyZW5jeTogc3ltYm9sLFxuICAgICAgICBhbW91bnQ6IHRvdGFsSW5jb21lQmFsYW5jZSxcbiAgICB9O1xuICAgIGNvbnN0IHBhcmFtU3RyaW5nMiA9IEpTT04uc3RyaW5naWZ5KHBhcmFtMik7XG5cblxuICAgIHZhciB0b3RhbEVhcm5BbmRRdWFudGl0eSA9IGArJHthd2FpdCBhZGRDdXJyZW50Q3VycmVuY3lTeW1ib2woYXdhaXQgJG5hdGl2ZUFQSS5jdXJyZW5jeUNvbW1vbihwYXJhbVN0cmluZykpfVxcbiske2F3YWl0ICRuYXRpdmVBUEkuY3VycmVuY3lDb21tb24ocGFyYW1TdHJpbmcyKX1gO1xuICAgIGNvbnNvbGUubG9nKGB0b3RhbEluY29tZUFtb3VudCAtLS0+ICR7dG90YWxJbmNvbWVBbW91bnR9IHRvdGFsSW5jb21lQmFsYW5jZSAtLS0+ICR7dG90YWxJbmNvbWVCYWxhbmNlfWApO1xuICAgIGNvbnNvbGUubG9nKGB0b3RhbEVhcm5BbmRRdWFudGl0eSAtLS0+ICR7dG90YWxFYXJuQW5kUXVhbnRpdHl9YCk7XG4gICAgcmV0dXJuIHRvdGFsRWFybkFuZFF1YW50aXR5O1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZ2V0UHJlQ3VycmVuY3lBbW91bnQoc3ltYm9sLCBhbW91bnQpIHtcbiAgICBpZiAoIWFtb3VudCkge1xuICAgICAgICBhbW91bnQgPSAnMCc7XG4gICAgfVxuICAgIGNvbnN0IHBhcmFtID0ge1xuICAgICAgICB0eXBlOiAxOSxcbiAgICAgICAgY3VycmVuY3k6IHN5bWJvbCxcbiAgICAgICAgYW1vdW50LFxuICAgIH07XG4gICAgY29uc3QgcGFyYW1TdHJpbmcgPSBKU09OLnN0cmluZ2lmeShwYXJhbSk7XG4gICAgcmV0dXJuIGF3YWl0ICRuYXRpdmVBUEkuY3VycmVuY3lDb21tb24ocGFyYW1TdHJpbmcpO1xufVxuXG5mdW5jdGlvbiBwcmVDdXJyZW5jeUFtb3VudFBhY2thZ2Uoc3ltYm9sLCBhbW91bnQpIHtcbiAgICBpZiAoIWFtb3VudCkge1xuICAgICAgICBhbW91bnQgPSAnMCc7XG4gICAgfVxuICAgIHJldHVybiB7IHR5cGU6IDE5LCBjdXJyZW5jeTogc3ltYm9sLCBhbW91bnQ6IGFtb3VudCB9O1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZ2V0Q29udHJhY3RTZWNvbmRTeW1ib2woY29udHJhY3RDb2RlKSB7XG4gICAgY29uc3QgcGFyYW0gPSB7XG4gICAgICAgIHR5cGU6IDIzLFxuICAgICAgICBjb250cmFjdENvZGUsXG4gICAgfTtcbiAgICBjb25zdCBwYXJhbVN0cmluZyA9IEpTT04uc3RyaW5naWZ5KHBhcmFtKTtcbiAgICByZXR1cm4gYXdhaXQgJG5hdGl2ZUFQSS5jdXJyZW5jeUNvbW1vbihwYXJhbVN0cmluZyk7XG59XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gYWRkQ3VycmVudEN1cnJlbmN5U3ltYm9sKHNvdXJjZSkge1xuICAgIGNvbnN0IHN5bWJvbCA9IGF3YWl0IGdldExlZ2FsQ3VycmVuY3lTeW1ib2woKTtcbiAgICByZXR1cm4gYWRkQ3VycmVuY3lTeW1ib2woc3ltYm9sLCBzb3VyY2UpO1xufVxuZXhwb3J0IGZ1bmN0aW9uIGFkZEN1cnJlbmN5U3ltYm9sKGN1cnJlbmN5U3ltYm9sLCBzb3VyY2UpIHtcbiAgICBpZiAoc291cmNlID09PSAnLS0nKSB7XG4gICAgICAgIHJldHVybiBzb3VyY2U7XG4gICAgfVxuICAgIGVsc2UgaWYgKHNvdXJjZSAmJiBzb3VyY2UgIT09IERFRkFVTFRfU1RSKSB7XG4gICAgICAgIGlmIChzb3VyY2Uuc3RhcnRzV2l0aCgnLScpKSB7XG4gICAgICAgICAgICBpZiAoY3VycmVuY3lTeW1ib2wgPT0gYOKCrmApIHtcbiAgICAgICAgICAgICAgICByZXR1cm4gYC0ke3NvdXJjZS5zdWJzdHJpbmcoMSl9IFVTRFRgO1xuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICByZXR1cm4gYC0ke2N1cnJlbmN5U3ltYm9sfSR7c291cmNlLnN1YnN0cmluZygxKX1gO1xuICAgICAgICAgICAgfVxuICAgICAgICB9XG4gICAgICAgIGlmIChjdXJyZW5jeVN5bWJvbCA9PSBg4oKuYCkge1xuICAgICAgICAgICAgcmV0dXJuIGAke3NvdXJjZX0gVVNEVGA7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICByZXR1cm4gYCR7Y3VycmVuY3lTeW1ib2x9JHtzb3VyY2V9YDtcbiAgICAgICAgfVxuICAgIH0gZWxzZSB7XG4gICAgICAgIGlmIChjdXJyZW5jeVN5bWJvbCA9PSBg4oKuYCkge1xuICAgICAgICAgICAgcmV0dXJuIGAke0RFRkFVTFRfU1RSfSBVU0RUYDtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIHJldHVybiBgJHtjdXJyZW5jeVN5bWJvbH0ke0RFRkFVTFRfU1RSfWA7XG4gICAgICAgIH1cbiAgICB9XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBhZGRDdXJyZW5jeVN5bWJvbFRvdGFsQXNzZXQoY3VycmVuY3lTeW1ib2wsIHNvdXJjZSkge1xuICAgIGlmIChzb3VyY2UgPT09ICctLScpIHtcbiAgICAgICAgcmV0dXJuIHNvdXJjZTtcbiAgICB9XG4gICAgZWxzZSBpZiAoc291cmNlICYmIHNvdXJjZSAhPT0gREVGQVVMVF9TVFIpIHtcbiAgICAgICAgaWYgKHNvdXJjZS5zdGFydHNXaXRoKCctJykpIHtcbiAgICAgICAgICAgIGlmIChjdXJyZW5jeVN5bWJvbCA9PSBg4oKuYCkge1xuICAgICAgICAgICAgICAgICRkYXRhLnVzZHRWaXMgPSBcInZpc2libGVcIlxuICAgICAgICAgICAgICAgIHJldHVybiBgLSR7c291cmNlLnN1YnN0cmluZygxKX1gO1xuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICAkZGF0YS51c2R0VmlzID0gXCJnb25lXCJcbiAgICAgICAgICAgICAgICByZXR1cm4gYC0ke2N1cnJlbmN5U3ltYm9sfSR7c291cmNlLnN1YnN0cmluZygxKX1gO1xuICAgICAgICAgICAgfVxuICAgICAgICB9XG4gICAgICAgIGlmIChjdXJyZW5jeVN5bWJvbCA9PSBg4oKuYCkge1xuICAgICAgICAgICAgJGRhdGEudXNkdFZpcyA9IFwidmlzaWJsZVwiXG4gICAgICAgICAgICByZXR1cm4gYCR7c291cmNlfWA7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAkZGF0YS51c2R0VmlzID0gXCJnb25lXCJcbiAgICAgICAgICAgIHJldHVybiBgJHtjdXJyZW5jeVN5bWJvbH0ke3NvdXJjZX1gO1xuICAgICAgICB9XG4gICAgfSBlbHNlIHtcbiAgICAgICAgaWYgKGN1cnJlbmN5U3ltYm9sID09IGDigq5gKSB7XG4gICAgICAgICAgICAkZGF0YS51c2R0VmlzID0gXCJ2aXNpYmxlXCJcbiAgICAgICAgICAgIHJldHVybiBgJHtERUZBVUxUX1NUUn1gO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgJGRhdGEudXNkdFZpcyA9IFwiZ29uZVwiXG4gICAgICAgICAgICByZXR1cm4gYCR7Y3VycmVuY3lTeW1ib2x9JHtERUZBVUxUX1NUUn1gO1xuICAgICAgICB9XG4gICAgfVxufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gaW5pdERhdGEoKSB7XG4gICAgY29uc3QgaXNTaG93ID0gYXdhaXQgaXNTaG93QXNzZXQoKTtcbiAgICBpc0hpZGRlbiA9ICFpc1Nob3c7XG4gICAgaWYgKCFpc0hpZGRlbikge1xuICAgICAgICAkZGF0YS5vcGVuVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuICAgICAgICAkZGF0YS5jbG9zZVZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICB9IGVsc2Uge1xuICAgICAgICAkZGF0YS5vcGVuVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgICAgICAkZGF0YS5jbG9zZVZpc2liaWxpdHkgPSBcInZpc2libGVcIjtcbiAgICAgICAgJGRhdGEudXNkdFZpcyA9IFwiZ29uZVwiXG4gICAgfVxuICAgIGdldFRvdGFsQXNzZXRDdXJyZW5jeSgpLnRoZW4oY3VycmVuY3kgPT4ge1xuICAgICAgICAkZGF0YS5jdXJyZW5jeSA9IGN1cnJlbmN5LnRvVXBwZXJDYXNlKCk7XG4gICAgfSk7XG4gICAgZ2V0RW50cnlTaG93KCk7XG4gICAgJGRhdGEubGlzdFRpdGxlTGVmdCA9IGF3YWl0IGdldFdvcmQoJ25fbWFya2V0X2NvbGxlY2F0aW9uX3RhYl9uYW1lJyk7XG4gICAgJGRhdGEubGlzdFRpdGxlQ2VudGVyID0gYXdhaXQgZ2V0V29yZCgnYXNzZXRfc3BvdF90YWJsZV90b3BfYmFsYW5jZV9uZXcnKTtcbiAgICAkZGF0YS5saXN0VGl0bGVSaWdodCA9IGF3YWl0IGdldFdvcmQoJ25fYXNzZXRfeWVzdG9kYXlfaW50ZXJlc3RfYW1vdW50Jyk7XG4gICAgJGRhdGEuc2hvd1NlbGVjdCA9IDA7XG5cbiAgICBhd2FpdCBzeW5jQ3VycmVuY3lVcGRhdGVDb25maWcoKTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGhpZGRlblNtYWxsQXNzZXQodHlwZSkge1xuICAgIGNvbnNvbGUubG9nKGBoaWRkZW5TbWFsbEFzc2V0ICR7dHlwZX1gKTtcbiAgICBzd2l0Y2ggKHR5cGUpIHtcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLnNwb3Q6XG4gICAgICAgICAgICBjYWNoZURhdGEuc3BvdC5zcG90LmhpZGRlblNtYWxsQXNzZXQgPSAhY2FjaGVEYXRhLnNwb3Quc3BvdC5oaWRkZW5TbWFsbEFzc2V0O1xuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS5ib3Q6XG4gICAgICAgICAgICBjYWNoZURhdGEuc3BvdC5ib3QuaGlkZGVuU21hbGxBc3NldCA9ICFjYWNoZURhdGEuc3BvdC5ib3QuaGlkZGVuU21hbGxBc3NldDtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuY29sbGF0ZXJhbDpcbiAgICAgICAgICAgIGNhY2hlRGF0YS5zcG90LmNvbGxhdGVyYWwuaGlkZGVuU21hbGxBc3NldCA9ICFjYWNoZURhdGEuc3BvdC5jb2xsYXRlcmFsLmhpZGRlblNtYWxsQXNzZXQ7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmNvaW5QOlxuICAgICAgICAgICAgaWYgKGNvaW5QQWxsKSB7XG4gICAgICAgICAgICAgICAgY2FjaGVEYXRhLmNvbnRyYWN0LmNvaW5fcC5hbGwuaGlkZGVuU21hbGxBc3NldCA9ICFjYWNoZURhdGEuY29udHJhY3QuY29pbl9wLmFsbC5oaWRkZW5TbWFsbEFzc2V0O1xuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICBjYWNoZURhdGEuY29udHJhY3QuY29pbl9wLm93bmVkLmhpZGRlblNtYWxsQXNzZXQgPSAhY2FjaGVEYXRhLmNvbnRyYWN0LmNvaW5fcC5vd25lZC5oaWRkZW5TbWFsbEFzc2V0O1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS5jb2luRnV0dXJlczpcbiAgICAgICAgICAgIGlmIChjb2luTUFsbCkge1xuICAgICAgICAgICAgICAgIGNhY2hlRGF0YS5jb250cmFjdC5jb2luX2YuYWxsLmhpZGRlblNtYWxsQXNzZXQgPSAhY2FjaGVEYXRhLmNvbnRyYWN0LmNvaW5fZi5hbGwuaGlkZGVuU21hbGxBc3NldDtcbiAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgY2FjaGVEYXRhLmNvbnRyYWN0LmNvaW5fZi5vd25lZC5oaWRkZW5TbWFsbEFzc2V0ID0gIWNhY2hlRGF0YS5jb250cmFjdC5jb2luX2Yub3duZWQuaGlkZGVuU21hbGxBc3NldDtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUudXNkdE06XG4gICAgICAgICAgICBpZiAodXNkdE1BbGwpIHtcbiAgICAgICAgICAgICAgICBjYWNoZURhdGEuY29udHJhY3QudXNkdF9tLmFsbC5oaWRkZW5TbWFsbEFzc2V0ID0gIWNhY2hlRGF0YS5jb250cmFjdC51c2R0X20uYWxsLmhpZGRlblNtYWxsQXNzZXQ7XG4gICAgICAgICAgICAgICAgY2FjaGVEYXRhLmNvbnRyYWN0LnVzZHRfbV91bml0eS5hbGwuaGlkZGVuU21hbGxBc3NldCA9ICFjYWNoZURhdGEuY29udHJhY3QudXNkdF9tX3VuaXR5LmFsbC5oaWRkZW5TbWFsbEFzc2V0O1xuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICBjYWNoZURhdGEuY29udHJhY3QudXNkdF9tLm93bmVkLmhpZGRlblNtYWxsQXNzZXQgPSAhY2FjaGVEYXRhLmNvbnRyYWN0LnVzZHRfbS5vd25lZC5oaWRkZW5TbWFsbEFzc2V0O1xuICAgICAgICAgICAgICAgIGNhY2hlRGF0YS5jb250cmFjdC51c2R0X21fdW5pdHkub3duZWQuaGlkZGVuU21hbGxBc3NldCA9ICFjYWNoZURhdGEuY29udHJhY3QudXNkdF9tX3VuaXR5Lm93bmVkLmhpZGRlblNtYWxsQXNzZXQ7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmNvbnRyYWN0Q29weTpcbiAgICAgICAgICAgIGNhY2hlRGF0YS5jb250cmFjdC5jb3B5X3RyYWRpbmcuaGlkZGVuU21hbGxBc3NldCA9ICFjYWNoZURhdGEuY29udHJhY3QuY29weV90cmFkaW5nLmhpZGRlblNtYWxsQXNzZXQ7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLm90YzpcbiAgICAgICAgICAgIGNhY2hlRGF0YS5vdGMuaGlkZGVuU21hbGxBc3NldCA9ICFjYWNoZURhdGEub3RjLmhpZGRlblNtYWxsQXNzZXQ7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmFsbFJlcG86XG4gICAgICAgICAgICBjYWNoZURhdGEubWFyZ2luLmFsbFJlcG8uaGlkZGVuU21hbGxBc3NldCA9ICFjYWNoZURhdGEubWFyZ2luLmFsbFJlcG8uaGlkZGVuU21hbGxBc3NldDtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUucGFydFJlcG86XG4gICAgICAgICAgICBjYWNoZURhdGEubWFyZ2luLnBhcnRSZXBvLmhpZGRlblNtYWxsQXNzZXQgPSAhY2FjaGVEYXRhLm1hcmdpbi5wYXJ0UmVwby5oaWRkZW5TbWFsbEFzc2V0O1xuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS5lYXJuOlxuICAgICAgICAgICAgY2FjaGVEYXRhLmVhcm4uZWFyblliYi5oaWRkZW5TbWFsbEFzc2V0ID0gIWNhY2hlRGF0YS5lYXJuLmVhcm5ZYmIuaGlkZGVuU21hbGxBc3NldDtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuZWFybkZpeGVkOlxuICAgICAgICAgICAgY2FjaGVEYXRhLmVhcm4uZWFybkZpeGVkLmhpZGRlblNtYWxsQXNzZXQgPSAhY2FjaGVEYXRhLmVhcm4uZWFybkZpeGVkLmhpZGRlblNtYWxsQXNzZXQ7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLm9wdGlvbjpcbiAgICAgICAgICAgIGNhY2hlRGF0YS5vcHRpb24uaGlkZGVuU21hbGxBc3NldCA9ICFjYWNoZURhdGEub3B0aW9uLmhpZGRlblNtYWxsQXNzZXQ7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmNvbnRyYWN0R3JpZDpcbiAgICAgICAgICAgIGNhY2hlRGF0YS5jb250cmFjdEdyaWQuaGlkZGVuU21hbGxBc3NldCA9ICFjYWNoZURhdGEuY29udHJhY3RHcmlkLmhpZGRlblNtYWxsQXNzZXQ7XG4gICAgICAgICAgICBicmVhaztcbiAgICB9XG4gICAgdXBkYXRlUGFnZUxpc3RCeVR5cGUodHlwZSwgMCk7XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBleGlzdE9uZUluY2x1ZGVUd28ob25lU3RyLCB0d29TdHIpIHtcbiAgICBpZiAob25lU3RyKSB7XG4gICAgICAgIGlmICh0d29TdHIpIHtcbiAgICAgICAgICAgIHJldHVybiBvbmVTdHIudG9VcHBlckNhc2UoKS5pbmNsdWRlcyh0d29TdHIudG9VcHBlckNhc2UoKSk7XG4gICAgICAgIH1cbiAgICAgICAgcmV0dXJuIHRydWU7XG4gICAgfVxuICAgIHJldHVybiBmYWxzZTtcbn1cbmV4cG9ydCBmdW5jdGlvbiBzZWFyY2hDb2luRXZlbnQodHlwZSwgaW5wdXQpIHtcbiAgICBjb25zb2xlLmxvZyhgc2VhcmNoQ29pbkV2ZW50ICR7dHlwZX0gJHtpbnB1dH1gKTtcbiAgICBzd2l0Y2ggKHR5cGUpIHtcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLnNwb3Q6XG4gICAgICAgICAgICBjYWNoZURhdGEuc3BvdC5zcG90LnNlYXJjaEtleSA9IGlucHV0O1xuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS5ib3Q6XG4gICAgICAgICAgICBjYWNoZURhdGEuc3BvdC5ib3Quc2VhcmNoS2V5ID0gaW5wdXQ7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmNvbGxhdGVyYWw6XG4gICAgICAgICAgICBjYWNoZURhdGEuc3BvdC5jb2xsYXRlcmFsLnNlYXJjaEtleSA9IGlucHV0O1xuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS5jb2luUDpcbiAgICAgICAgICAgIGlmIChjb2luUEFsbCkge1xuICAgICAgICAgICAgICAgIGNhY2hlRGF0YS5jb250cmFjdC5jb2luX3AuYWxsLnNlYXJjaEtleSA9IGlucHV0O1xuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICBjYWNoZURhdGEuY29udHJhY3QuY29pbl9wLm93bmVkLnNlYXJjaEtleSA9IGlucHV0O1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS5jb2luRnV0dXJlczpcbiAgICAgICAgICAgIGlmIChjb2luTUFsbCkge1xuICAgICAgICAgICAgICAgIGNhY2hlRGF0YS5jb250cmFjdC5jb2luX2YuYWxsLnNlYXJjaEtleSA9IGlucHV0O1xuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICBjYWNoZURhdGEuY29udHJhY3QuY29pbl9mLm93bmVkLnNlYXJjaEtleSA9IGlucHV0O1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgYnJlYWs7XG4gICAgICAgIGNhc2UgRGlzdHJpYnV0aW9uVHlwZS51c2R0TTpcbiAgICAgICAgICAgIGlmICh1c2R0TUFsbCkge1xuICAgICAgICAgICAgICAgIGNhY2hlRGF0YS5jb250cmFjdC51c2R0X20uYWxsLnNlYXJjaEtleSA9IGlucHV0O1xuICAgICAgICAgICAgICAgIGNhY2hlRGF0YS5jb250cmFjdC51c2R0X21fdW5pdHkuYWxsLnNlYXJjaEtleSA9IGlucHV0O1xuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICBjYWNoZURhdGEuY29udHJhY3QudXNkdF9tLm93bmVkLnNlYXJjaEtleSA9IGlucHV0O1xuICAgICAgICAgICAgICAgIGNhY2hlRGF0YS5jb250cmFjdC51c2R0X21fdW5pdHkub3duZWQuc2VhcmNoS2V5ID0gaW5wdXQ7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmNvbnRyYWN0Q29weTpcbiAgICAgICAgICAgIGNhY2hlRGF0YS5jb250cmFjdC5jb3B5X3RyYWRpbmcuc2VhcmNoS2V5ID0gaW5wdXQ7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLm90YzpcbiAgICAgICAgICAgIGNhY2hlRGF0YS5vdGMuc2VhcmNoS2V5ID0gaW5wdXQ7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmFsbFJlcG86XG4gICAgICAgICAgICBjYWNoZURhdGEubWFyZ2luLmFsbFJlcG8uc2VhcmNoS2V5ID0gaW5wdXQ7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLnBhcnRSZXBvOlxuICAgICAgICAgICAgY2FjaGVEYXRhLm1hcmdpbi5wYXJ0UmVwby5zZWFyY2hLZXkgPSBpbnB1dDtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuZWFybjpcbiAgICAgICAgICAgIGNhY2hlRGF0YS5lYXJuLmVhcm5ZYmIuc2VhcmNoS2V5ID0gaW5wdXQ7XG4gICAgICAgICAgICBicmVhaztcbiAgICAgICAgY2FzZSBEaXN0cmlidXRpb25UeXBlLmVhcm5GaXhlZDpcbiAgICAgICAgICAgIGNhY2hlRGF0YS5lYXJuLmVhcm5GaXhlZC5zZWFyY2hLZXkgPSBpbnB1dDtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUub3B0aW9uOlxuICAgICAgICAgICAgY2FjaGVEYXRhLm9wdGlvbi5zZWFyY2hLZXkgPSBpbnB1dDtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgICAgICBjYXNlIERpc3RyaWJ1dGlvblR5cGUuY29udHJhY3RHcmlkOlxuICAgICAgICAgICAgY2FjaGVEYXRhLmNvbnRyYWN0R3JpZC5zZWFyY2hLZXkgPSBpbnB1dDtcbiAgICAgICAgICAgIGJyZWFrO1xuICAgIH1cbiAgICB1cGRhdGVQYWdlTGlzdEJ5VHlwZSh0eXBlLCAwKTtcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGl0ZW1TaG91bGRTaG93KGN1cnJlbmN5LCBidGNDdXJyZW5jeSwgYW1vdW50LCBoaWRkZW5TbWFsbEFzc2V0LCBzZWFyY2hLZXkpIHtcbiAgICBjb25zb2xlLmxvZyhgaXRlbVNob3VsZFNob3cgJHtjdXJyZW5jeX0gJHtoaWRkZW5TbWFsbEFzc2V0fSAke3NlYXJjaEtleX1gKTtcbiAgICByZXR1cm4gZXhpc3RPbmVJbmNsdWRlVHdvKGN1cnJlbmN5LCBzZWFyY2hLZXkpXG4gICAgICAgICYmICghaGlkZGVuU21hbGxBc3NldCB8fCBhd2FpdCBnZXRCVENBbW91bnQoYnRjQ3VycmVuY3ksIGFtb3VudCkgPj0gMC4wMDAxKTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIHJlZnJlc2hEYXRhKCkge1xuICAgIGNvbnNvbGUubG9nKCdyZWZyZXNoRGF0YSEnKTtcbiAgICBnZXRFbnRyeVNob3coKTtcbiAgICBnZXRCYWxhbmNlQXNzZXQoKTtcbiAgICBnZXRSb2NrZXRBbW91bnQoKTtcbiAgICBhc3NldFRhYkV2ZW50KGN1cnJlbnREaXN0cmlidXRpb25UeXBlLCB0cnVlLCB0cnVlKTtcbiAgICBpbml0Q29uZmlnSW5mbygpO1xuICAgIGdldERlcG9zaXRXaXRoZHJhdygpO1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZ2V0RmFsbENvaW5UZXh0KCkge1xuICAgIHRyeSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGBnZXRGYWxsQ29pblRleHQgc3RhcnRgKTtcbiAgICAgICAgY29uc3QgcGFyYW1zID0gZ2VuUmVxdWVzdFBhcmFtcyhmYWxsQ29pblBhdGgpO1xuICAgICAgICBjb25zdCBmYWxsQ29pbkRhdGEgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QocGFyYW1zKTtcbiAgICAgICAgY29uc29sZS5sb2coYGdldEZhbGxDb2luVGV4dCAke2ZhbGxDb2luRGF0YX1gKTtcbiAgICAgICAgY29uc3QgcmVzcG9uc2UgPSBKU09OLnBhcnNlKGZhbGxDb2luRGF0YSk7XG4gICAgICAgIGNvbnN0IHsgY29kZSwgZGF0YSB9ID0gcmVzcG9uc2U7XG4gICAgICAgIGNvbnNvbGUubG9nKGBnZXRGYWxsQ29pblRleHQgJHtKU09OLnN0cmluZ2lmeShkYXRhKX1gKTtcbiAgICAgICAgaWYgKGNvZGUgIT09IDIwMCkge1xuICAgICAgICAgICAgY2FjaGVEYXRhLmZhbGxDb2luRGF0YSA9IHt9O1xuICAgICAgICAgICAgY29uc29sZS5lcnJvcihUQUcsIGBnZXRGYWxsQ29pblRleHQsIGNvZGU9JHtjb2RlfWApO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgY2FjaGVEYXRhLmZhbGxDb2luRGF0YSA9IGRhdGE7XG4gICAgICAgICAgICBpZiAoZGF0YS5sZWZ0VHJhbnNsYXRlQ29udGVudCAhPSBudWxsKSB7XG4gICAgICAgICAgICAgICAgJGRhdGEuZmFsbENvaW5WaXMgPSBcInZpc2libGVcIlxuICAgICAgICAgICAgICAgIGlmIChjb21tb25EYXRhLmNvbG9yTW9kZSA9PSBcIjFcIikge1xuICAgICAgICAgICAgICAgICAgICAkZGF0YS5mYWxsQ29pblRleHQgPSBgPHNwYW4gc3R5bGU9XCJjb2xvcjojRTZFNkU2OyBmb250LXNpemU6MTJweDtcIj4ke2RhdGEubGVmdFRyYW5zbGF0ZUNvbnRlbnR9IDwvc3Bhbj4gPHNwYW4gc3R5bGU9XCJjb2xvcjojMDE3M0U1OyBmb250LXNpemU6MTJweDtcIj4gJHtkYXRhLnJpZ2h0VHJhbnNsYXRlQ29udGVudH0gPC9zcGFuPiBgO1xuICAgICAgICAgICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAgICAgICAgICRkYXRhLmZhbGxDb2luVGV4dCA9IGA8c3BhbiBzdHlsZT1cImNvbG9yOiMwMDAwMDA7IGZvbnQtc2l6ZToxMnB4O1wiPiR7ZGF0YS5sZWZ0VHJhbnNsYXRlQ29udGVudH0gPC9zcGFuPiA8c3BhbiBzdHlsZT1cImNvbG9yOiMwMTczRTU7IGZvbnQtc2l6ZToxMnB4O1wiPiAke2RhdGEucmlnaHRUcmFuc2xhdGVDb250ZW50fSA8L3NwYW4+IGA7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICAkZGF0YS5mYWxsQ29pblZpcyA9IFwiZ29uZVwiXG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICB9XG4gICAgY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5lcnJvcihUQUcsIGBnZXRGYWxsQ29pblRleHQsICR7ZX1gKTtcbiAgICB9XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBqdW1wRmFsbENvaW5MaW5rKCkge1xuICAgIGlmIChjYWNoZURhdGEuZmFsbENvaW5EYXRhLmp1bXBVcmwgIT0gbnVsbCkge1xuICAgICAgICBjb25zdCB1cmxQYXRoID0gY2FjaGVEYXRhLmZhbGxDb2luRGF0YS5qdW1wVXJsO1xuICAgICAgICBpZiAodXJsUGF0aC5pbmRleE9mKFwiaG9saWdlaXRcIikgPT0gMCB8fCB1cmxQYXRoLmluZGV4T2YoXCJodHRwXCIpID09IDApIHtcbiAgICAgICAgICAgIG9wZW5Sb3V0ZXIodXJsUGF0aCk7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBvcGVuUm91dGVyKGAke2NvbW1vbkRhdGEud2ViVXJsfS8ke2NvbW1vbkRhdGEubGFuZ3VhZ2V9JHt1cmxQYXRofWApO1xuICAgICAgICB9XG4gICAgfVxufVxuXG5leHBvcnQgZnVuY3Rpb24gY2xvc2VGYWxsQ29pbigpIHtcbiAgICAkZGF0YS5mYWxsQ29pblZpcyA9IFwiZ29uZVwiXG59XG5cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGluaXRDb25maWdJbmZvKCkge1xuICAgIGlzQ29udHJhY3RPcGVuQ29uZmlnID0gYXdhaXQgJG5hdGl2ZUFQSS5jdXJyZW5jeUNvbW1vbigne1widHlwZVwiOjMxfScpO1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gb25BcHBlYXIoKSB7XG4gICAgY29uc3QgaXNTaG93ID0gYXdhaXQgaXNTaG93QXNzZXQoKTtcbiAgICBpc0hpZGRlbiA9ICFpc1Nob3c7XG4gICAgaWYgKGlzSGlkZGVuKSB7XG4gICAgICAgICRkYXRhLm9wZW5WaXNpYmlsaXR5ID0gXCJnb25lXCI7XG4gICAgICAgICRkYXRhLmNsb3NlVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuICAgICAgICAkZGF0YS51c2R0VmlzID0gXCJnb25lXCJcbiAgICB9IGVsc2Uge1xuICAgICAgICAkZGF0YS5vcGVuVmlzaWJpbGl0eSA9IFwidmlzaWJsZVwiO1xuICAgICAgICAkZGF0YS5jbG9zZVZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICB9XG4gICAgYXdhaXQgc3luY0N1cnJlbmN5VXBkYXRlQ29uZmlnKCk7XG4gICAgcmVmcmVzaERhdGEoKVxuICAgIGdldEZhbGxDb2luVGV4dCgpXG4gICAgJGRhdGEucGFnZUFwcGVhciA9ICd0cnVlJztcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIHNob3dQcm9maXRSZWQoKSB7XG4gICAgJGRhdGEucHJvZml0UmVkID0gJ3Zpc2libGUnO1xufVxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGdldE9UQ0RhdGEoKSB7XG4gICAgY29uc3QgcGFyYW1zID0gZ2VuUmVxdWVzdFBhcmFtcygndjEvY2FwaXRhbC9iYWxhbmNlJywgXCJcIiwgMCwgMSwgXCJcIik7XG4gICAgdHJ5IHtcbiAgICAgICAgY29uc3QgcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QocGFyYW1zKTtcbiAgICAgICAgY29uc3QgcmVzcG9uc2UgPSBKU09OLnBhcnNlKHJlc3BvbnNlU3RyaW5nKTtcbiAgICAgICAgY29uc3QgeyBjb2RlLCBkYXRhIH0gPSByZXNwb25zZTtcbiAgICAgICAgaWYgKGNvZGUgIT09IDIwMCkge1xuICAgICAgICAgICAgJGRhdGEub3RjTGlzdEVycm9yID0gZ2V0UmVzcG9uc2VQYXJhbXMoY29kZSwgZmFsc2UpO1xuICAgICAgICAgICAgY29uc29sZS5lcnJvcihUQUcsIGBnZXRPVENEYXRhLCBjb2RlPSR7Y29kZX1gKTtcbiAgICAgICAgfVxuICAgICAgICBlbHNlIHtcbiAgICAgICAgICAgIGNhY2hlRGF0YS5vdGMuZGF0YSA9IGRhdGEgPyBkYXRhIDogW107XG4gICAgICAgICAgICB1cGRhdGVPdGNEYXRhKGNhY2hlRGF0YS5vdGMuZGF0YSk7XG4gICAgICAgIH1cblxuICAgIH1cbiAgICBjYXRjaCAoZSkge1xuICAgICAgICAkZGF0YS5vdGNMaXN0RXJyb3IgPSBnZXRSZXNwb25zZVBhcmFtcygtMSwgZmFsc2UpO1xuICAgICAgICBjb25zb2xlLmVycm9yKFRBRywgYGdldE9UQ0RhdGEsICR7ZX1gKTtcbiAgICB9XG5cbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGdldE9wdGlvbkRhdGEoYWNjb3VudF9pZCkge1xuICAgIGNvbnN0IHBhcmFtcyA9IGdlblJlcXVlc3RQYXJhbXMoYHYxL29wZW4vcHJvZml0L29wdGlvbnMvZHVhbC9saXN0YCk7XG4gICAgdHJ5IHtcbiAgICAgICAgY29uc3QgcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QocGFyYW1zKTtcbiAgICAgICAgY29uc3QgcmVzcG9uc2UgPSBKU09OLnBhcnNlKHJlc3BvbnNlU3RyaW5nKTtcbiAgICAgICAgY29uc3QgeyBjb2RlLCBkYXRhIH0gPSByZXNwb25zZTtcbiAgICAgICAgaWYgKGNvZGUgIT09IDIwMCkge1xuICAgICAgICAgICAgJGRhdGEub3B0aW9uTGlzdEVycm9yID0gZ2V0UmVzcG9uc2VQYXJhbXMoY29kZSwgZmFsc2UpO1xuICAgICAgICAgICAgY29uc29sZS5lcnJvcihUQUcsIGBnZXRPcHRpb25EYXRhLCBjb2RlPSR7Y29kZX1gKTtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGNhY2hlRGF0YS5vcHRpb24ubGlzdCA9IGRhdGEgPyBkYXRhLmxpc3QgPyBkYXRhLmxpc3QgOiBbXSA6IFtdO1xuICAgICAgICAgICAgdXBkYXRlT3B0aW9uRGF0YShjYWNoZURhdGEub3B0aW9uLmxpc3QpO1xuICAgICAgICB9XG4gICAgfVxuICAgIGNhdGNoIChlKSB7XG4gICAgICAgICRkYXRhLm9wdGlvbkxpc3RFcnJvciA9IGdldFJlc3BvbnNlUGFyYW1zKC0xLCBmYWxzZSk7XG4gICAgICAgIGNvbnNvbGUuZXJyb3IoVEFHLCBgZ2V0T3B0aW9uRGF0YSwgJHtlfWApO1xuICAgIH1cblxufVxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGdldEVhcm5EYXRhKHByb2plY3RUeXBlKSB7XG4gICAgdmFyIHBhcmFtcyA9IGdlblJlcXVlc3RQYXJhbXMoYC92MS9zYXZpbmcvbWluaW5nL3VzZXIvYXNzZXRzL2xpc3Q/cHJvamVjdFR5cGU9JHtwcm9qZWN0VHlwZX1gKTtcbiAgICBpZiAocHJvamVjdFR5cGUgPT0gXCIzXCIgfHwgcHJvamVjdFR5cGUgPT0gXCI0XCIgfHwgcHJvamVjdFR5cGUgPT0gXCI1XCIpIHtcbiAgICAgICAgcGFyYW1zID0gZ2VuUmVxdWVzdFBhcmFtcyhgL3YxL29wZW4vcHJvZml0L2Fzc2V0cy9zYXZpbmcvbGlzdD9wcm9qZWN0VHlwZT0ke3Byb2plY3RUeXBlfWApO1xuICAgIH1cbiAgICBzaGFya0Zpbkxhc3RQb3NpdGlvbiA9IC0xO1xuICAgIGxhc3RQb3NpdGlvbiA9IC0xO1xuICAgIG5vZGVQbGVkZ2VMYXN0UG9zaXRpb24gPSAtMTtcbiAgICB0cnkge1xuICAgICAgICBjb25zdCByZXNwb25zZVN0cmluZyA9IGF3YWl0ICRuYXRpdmVBUEkucmVxdWVzdChwYXJhbXMpO1xuICAgICAgICBjb25zdCByZXNwb25zZSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcpO1xuICAgICAgICBjb25zdCB7IGNvZGUsIGRhdGEgfSA9IHJlc3BvbnNlO1xuICAgICAgICBpZiAoY29kZSAhPT0gMjAwKSB7XG4gICAgICAgICAgICBjb25zb2xlLmVycm9yKFRBRywgYGdldEVhcm5EYXRhLCBjb2RlPSR7Y29kZX1gKTtcbiAgICAgICAgICAgIGlmIChwcm9qZWN0VHlwZSA9PSAnMCcpIHtcbiAgICAgICAgICAgICAgICAkZGF0YS5lYXJuWWJiTGlzdEVycm9yID0gZ2V0UmVzcG9uc2VQYXJhbXMoY29kZSwgZmFsc2UpO1xuICAgICAgICAgICAgfSBlbHNlIGlmIChwcm9qZWN0VHlwZSA9PSBcIjNcIikge1xuICAgICAgICAgICAgICAgICRkYXRhLmVhcm5IaWdoTGlzdEVycm9yID0gZ2V0UmVzcG9uc2VQYXJhbXMoY29kZSwgZmFsc2UpO1xuICAgICAgICAgICAgICAgICRkYXRhLmVhcm5IaWdoTGlzdCA9IFt7IFwidHlwZVwiOiBcIjNcIiB9XTtcbiAgICAgICAgICAgIH0gZWxzZSBpZiAocHJvamVjdFR5cGUgPT0gXCI0XCIpIHtcbiAgICAgICAgICAgICAgICAkZGF0YS5lYXJuTm9kZVBsZWRnZUxpc3RFcnJvciA9IGdldFJlc3BvbnNlUGFyYW1zKGNvZGUsIGZhbHNlKTtcbiAgICAgICAgICAgICAgICAkZGF0YS5lYXJuTm9kZVBsZWRnZUxpc3QgPSBbeyBcInR5cGVcIjogXCIzXCIgfV07XG4gICAgICAgICAgICB9IGVsc2UgaWYgKHByb2plY3RUeXBlID09IFwiNVwiKSB7XG4gICAgICAgICAgICAgICAgJGRhdGEuZWFyblNoYXJrRmluTGlzdEVycm9yID0gZ2V0UmVzcG9uc2VQYXJhbXMoY29kZSwgZmFsc2UpO1xuICAgICAgICAgICAgICAgICRkYXRhLmVhcm5TaGFya0Zpbkxpc3QgPSBbeyBcInR5cGVcIjogXCIzXCIgfV07XG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgICRkYXRhLmVhcm5GaXhlZExpc3RFcnJvciA9IGdldFJlc3BvbnNlUGFyYW1zKGNvZGUsIGZhbHNlKTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGlmIChwcm9qZWN0VHlwZSA9PSBcIjBcIikge1xuICAgICAgICAgICAgICAgIGNhY2hlRGF0YS5lYXJuLmVhcm5ZYmIubGlzdCA9IGRhdGEgPyBkYXRhIDogW107XG4gICAgICAgICAgICAgICAgdXBkYXRlRWFybkRhdGEocHJvamVjdFR5cGUsIGNhY2hlRGF0YS5lYXJuLmVhcm5ZYmIubGlzdCk7XG4gICAgICAgICAgICB9IGVsc2UgaWYgKHByb2plY3RUeXBlID09IFwiM1wiKSB7XG4gICAgICAgICAgICAgICAgY2FjaGVEYXRhLmVhcm4uZWFybkhpZ2gubGlzdCA9IGRhdGEgPyBkYXRhIDogW107XG4gICAgICAgICAgICAgICAgdXBkYXRlRWFybkhpZ2hEYXRhKHByb2plY3RUeXBlLCBjYWNoZURhdGEuZWFybi5lYXJuSGlnaC5saXN0KTtcbiAgICAgICAgICAgIH0gZWxzZSBpZiAocHJvamVjdFR5cGUgPT0gXCI0XCIpIHtcbiAgICAgICAgICAgICAgICBjYWNoZURhdGEuZWFybi5lYXJuTm9kZVBsZWRnZS5saXN0ID0gZGF0YSA/IGRhdGEgOiBbXTtcbiAgICAgICAgICAgICAgICB1cGRhdGVFYXJuTm9kZVBsZWRnZURhdGEocHJvamVjdFR5cGUsIGNhY2hlRGF0YS5lYXJuLmVhcm5Ob2RlUGxlZGdlLmxpc3QpO1xuICAgICAgICAgICAgfSBlbHNlIGlmIChwcm9qZWN0VHlwZSA9PSBcIjVcIikge1xuICAgICAgICAgICAgICAgIGNhY2hlRGF0YS5lYXJuLmVhcm5TaGFya0Zpbi5saXN0ID0gZGF0YSA/IGRhdGEgOiBbXTtcbiAgICAgICAgICAgICAgICB1cGRhdGVFYXJuU2hhcmtGaW5EYXRhKHByb2plY3RUeXBlLCBjYWNoZURhdGEuZWFybi5lYXJuU2hhcmtGaW4ubGlzdCk7XG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgIGNhY2hlRGF0YS5lYXJuLmVhcm5GaXhlZC5saXN0ID0gZGF0YSA/IGRhdGEgOiBbXTtcbiAgICAgICAgICAgICAgICB1cGRhdGVFYXJuRGF0YShwcm9qZWN0VHlwZSwgY2FjaGVEYXRhLmVhcm4uZWFybkZpeGVkLmxpc3QpO1xuICAgICAgICAgICAgfVxuICAgICAgICB9XG4gICAgfVxuICAgIGNhdGNoIChlKSB7XG4gICAgICAgIGlmIChwcm9qZWN0VHlwZSA9PSAnMCcpIHtcbiAgICAgICAgICAgICRkYXRhLmVhcm5ZYmJMaXN0RXJyb3IgPSBnZXRSZXNwb25zZVBhcmFtcygtMSwgZmFsc2UpO1xuICAgICAgICB9IGVsc2UgaWYgKHByb2plY3RUeXBlID09IFwiM1wiKSB7XG4gICAgICAgICAgICAkZGF0YS5lYXJuSGlnaExpc3QgPSBbeyBcInR5cGVcIjogXCIzXCIgfV07XG4gICAgICAgICAgICAkZGF0YS5lYXJuSGlnaExpc3RFcnJvciA9IGdldFJlc3BvbnNlUGFyYW1zKC0xLCBmYWxzZSk7XG4gICAgICAgIH0gZWxzZSBpZiAocHJvamVjdFR5cGUgPT0gXCI0XCIpIHtcbiAgICAgICAgICAgICRkYXRhLmVhcm5Ob2RlUGxlZGdlTGlzdCA9IFt7IFwidHlwZVwiOiBcIjNcIiB9XTtcbiAgICAgICAgICAgICRkYXRhLmVhcm5Ob2RlUGxlZGdlTGlzdEVycm9yID0gZ2V0UmVzcG9uc2VQYXJhbXMoLTEsIGZhbHNlKTtcbiAgICAgICAgfSBlbHNlIGlmIChwcm9qZWN0VHlwZSA9PSBcIjVcIikge1xuICAgICAgICAgICAgJGRhdGEuZWFyblNoYXJrRmluTGlzdCA9IFt7IFwidHlwZVwiOiBcIjNcIiB9XTtcbiAgICAgICAgICAgICRkYXRhLmVhcm5TaGFya0Zpbkxpc3RFcnJvciA9IGdldFJlc3BvbnNlUGFyYW1zKC0xLCBmYWxzZSk7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICAkZGF0YS5lYXJuRml4ZWRMaXN0RXJyb3IgPSBnZXRSZXNwb25zZVBhcmFtcygtMSwgZmFsc2UpO1xuICAgICAgICB9XG4gICAgICAgIGNvbnNvbGUuZXJyb3IoVEFHLCBgZ2V0RWFybkRhdGEsICR7ZX1gKTtcbiAgICB9XG59XG5cbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRNYXJnaW5BbGwoKSB7XG4gICAgdHJ5IHtcbiAgICAgICAgY29uc29sZS5sb2coJ2dldE1hcmdpbkFsbCcpO1xuICAgICAgICBjb25zdCByZXNwb25zZVN0cmluZyA9IGF3YWl0ICRuYXRpdmVBUEkuY3VycmVuY3lDb21tb24oJ3tcInR5cGVcIjo1Mn0nKTtcbiAgICAgICAgY29uc3QgZGF0YSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcpO1xuICAgICAgICBjYWNoZURhdGEubWFyZ2luLmFsbFJlcG8ubGlzdCA9IGRhdGEgPyBkYXRhIDogW107XG4gICAgICAgIHVwZGF0ZU1hcmdpbkFsbERhdGEoY2FjaGVEYXRhLm1hcmdpbi5hbGxSZXBvLmxpc3QpO1xuICAgIH1cbiAgICBjYXRjaCAoZSkge1xuICAgICAgICAkZGF0YS5sb25nTGV2ZWxEYXRhTGlzdEVycm9yID0gZ2V0UmVzcG9uc2VQYXJhbXMoLTEsIGZhbHNlKTtcbiAgICAgICAgY29uc29sZS5lcnJvcihUQUcsIGBnZXRNYXJnaW5BbGwsICR7ZX1gKTtcbiAgICB9XG59XG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gZ2V0TWFyZ2luUGFydCgpIHtcbiAgICB0cnkge1xuICAgICAgICBjb25zdCByZXNwb25zZVN0cmluZyA9IGF3YWl0ICRuYXRpdmVBUEkuY3VycmVuY3lDb21tb24oJ3tcInR5cGVcIjo1MX0nKTtcbiAgICAgICAgY29uc3QgZGF0YSA9IEpTT04ucGFyc2UocmVzcG9uc2VTdHJpbmcpO1xuICAgICAgICBjYWNoZURhdGEubWFyZ2luLnBhcnRSZXBvLmxpc3QgPSBkYXRhID8gZGF0YSA6IFtdO1xuICAgICAgICB1cGRhdGVNYXJnaW5QYXJ0RGF0YShjYWNoZURhdGEubWFyZ2luLnBhcnRSZXBvLmxpc3QpO1xuICAgIH1cbiAgICBjYXRjaCAoZSkge1xuICAgICAgICAkZGF0YS5zaG9ydExldmVsRGF0YUxpc3RFcnJvciA9IGdldFJlc3BvbnNlUGFyYW1zKC0xLCBmYWxzZSk7XG4gICAgICAgIGNvbnNvbGUuZXJyb3IoVEFHLCBgZ2V0TWFyZ2luUGFydCwgJHtlfWApO1xuICAgIH1cbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGNsZWFyRGF0YSgpIHtcbiAgICBjb25zb2xlLmxvZygnY2xlYXIgZGF0YSEnKTtcbiAgICBjb25zdCBpc1Nob3cgPSBhd2FpdCBpc1Nob3dBc3NldCgpO1xuICAgIGlzSGlkZGVuID0gIWlzU2hvdztcbiAgICBpZiAoaXNIaWRkZW4pIHtcbiAgICAgICAgJGRhdGEub3BlblZpc2liaWxpdHkgPSBcImdvbmVcIjtcbiAgICAgICAgJGRhdGEuY2xvc2VWaXNpYmlsaXR5ID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICRkYXRhLnVzZHRWaXMgPSBcImdvbmVcIlxuICAgIH0gZWxzZSB7XG4gICAgICAgICRkYXRhLm9wZW5WaXNpYmlsaXR5ID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICRkYXRhLmNsb3NlVmlzaWJpbGl0eSA9IFwiZ29uZVwiO1xuICAgIH1cbiAgICAkZGF0YS5wcm9maXRBY2NvdW50QmFsYW5jZUxpc3QgPSBbXTtcbiAgICBjYWNoZURhdGEgPSBERUZBVUxUX0NBQ0hFO1xuICAgICRkYXRhLmFzc2V0VG90YWwgPSBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiAnLS0nO1xuICAgICRkYXRhLmFzc2V0VG9hZHlQcm9maXQgPSBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiAnLS0nO1xuICAgICRkYXRhLmFzc2V0VG9hZHlQcm9maXRSYXRlID0gaXNIaWRkZW4gPyAnJyA6ICcvLS0nO1xuICAgICRkYXRhLmFzc2V0VG90YWxQcm9maXQgPSBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiAnLS0nO1xuICAgICRkYXRhLnJvY2tldEFtb3VudCA9IGlzSGlkZGVuID8gSElEREVOX1NUUiA6ICctLSc7XG4gICAgJGRhdGEuc2hhcmVWaXNpYmlsaXR5ID0gJ2dvbmUnO1xuICAgICRkYXRhLnJlc3RyaWN0aW9uVmlzID0gXCJnb25lXCI7XG4gICAgJGRhdGEuZXhjaGFuZ2VVU0REVmlzID0gXCJnb25lXCI7XG4gICAgZXhjaGFuZ2VFbmFibGUgPSBmYWxzZTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGdldEZ1bGxOdW0obnVtKSB7XG4gICAgaWYgKGlzTmFOKG51bSkpIHtcbiAgICAgICAgcmV0dXJuIG51bVxuICAgIH1cbiAgICB2YXIgc3RyID0gJycgKyBudW07XG4gICAgaWYgKCEvZS9pLnRlc3Qoc3RyKSkge1xuICAgICAgICByZXR1cm4gbnVtO1xuICAgIH1cbiAgICB2YXIgZml4ZWQgPSAoJycgKyBudW0pLm1hdGNoKC9cXGQrJC8pWzBdO1xuICAgIHJldHVybiBuZXcgTnVtYmVyKG51bSkudG9GaXhlZChmaXhlZCk7XG59XG5cbnZhciBsYXN0UG9zaXRpb24gPSAtMTtcbmV4cG9ydCBmdW5jdGlvbiBvbkl0ZW1DbGljayhwb3NpdGlvbikge1xuICAgIHZhciBjdXJyZW50SXRlbSA9ICRkYXRhLmVhcm5IaWdoTGlzdFtwb3NpdGlvbl07XG4gICAgdmFyIHN0YXRlID0gXCJmb2xkXCI7XG4gICAgaWYgKGxhc3RQb3NpdGlvbiAhPSAtMSkge1xuICAgICAgICB2YXIgaXRlbSA9ICRkYXRhLmVhcm5IaWdoTGlzdFtsYXN0UG9zaXRpb25dO1xuICAgICAgICBpdGVtLnZpc2libGUgPSBcImdvbmVcIjtcbiAgICAgICAgJGRhdGEuZWFybkhpZ2hMaXN0W2xhc3RQb3NpdGlvbl0gPSBpdGVtO1xuICAgICAgICBpZiAobGFzdFBvc2l0aW9uID09IHBvc2l0aW9uKSB7XG4gICAgICAgICAgICBzdGF0ZSA9IFwidW5mb2xkXCI7XG4gICAgICAgIH1cbiAgICB9XG5cbiAgICBpZiAobGFzdFBvc2l0aW9uICE9IHBvc2l0aW9uKSB7XG4gICAgICAgIHZhciBpdGVtID0gJGRhdGEuZWFybkhpZ2hMaXN0W3Bvc2l0aW9uXTtcbiAgICAgICAgaXRlbS52aXNpYmxlID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICRkYXRhLmVhcm5IaWdoTGlzdFtwb3NpdGlvbl0gPSBpdGVtO1xuICAgICAgICBsYXN0UG9zaXRpb24gPSBwb3NpdGlvbjtcbiAgICB9IGVsc2Uge1xuICAgICAgICBsYXN0UG9zaXRpb24gPSAtMTtcbiAgICB9XG4gICAgYW5hbHl0aWNzKFwiYXBwX2Fzc2V0c19FYXJuX2N1cnJlbmN5X2NsaWNrXCIsIHtcbiAgICAgICAgXCJ0YWJOYW1lXCI6IFwibWF4RmxheGlibGVcIixcbiAgICAgICAgXCJjdXJyZW5jeVwiOiBjdXJyZW50SXRlbS5zeW1ib2xOYW1lLFxuICAgICAgICBcImNsaWNrXCI6IHN0YXRlXG4gICAgfSk7XG5cbiAgICBjb25zb2xlLmxvZyhcIm9uSXRlbUNsaWNrOiBcIiArIHBvc2l0aW9uICsgXCIgLCBsYXN0UG9zaXRpb246IFwiICsgbGFzdFBvc2l0aW9uICsgXCIgdmlzaWJsZTogXCIgKyAkZGF0YS5lYXJuSGlnaExpc3RbcG9zaXRpb25dLnZpc2libGUgKyBcIiAsIGl0ZW0uc3BvdE51bWJlckVxdWl2YWxlbnQ6XCIgKyAkZGF0YS5lYXJuSGlnaExpc3RbcG9zaXRpb25dLnNwb3ROdW1iZXJFcXVpdmFsZW50KTtcbn1cblxudmFyIG5vZGVQbGVkZ2VMYXN0UG9zaXRpb24gPSAtMTtcbmV4cG9ydCBmdW5jdGlvbiBvbk5vZGVQbGVkZ2VJdGVtQ2xpY2socG9zaXRpb24pIHtcbiAgICB2YXIgY3VycmVudEl0ZW0gPSAkZGF0YS5lYXJuTm9kZVBsZWRnZUxpc3RbcG9zaXRpb25dO1xuICAgIHZhciBzdGF0ZSA9IFwiZm9sZFwiO1xuICAgIGlmIChub2RlUGxlZGdlTGFzdFBvc2l0aW9uICE9IC0xKSB7XG4gICAgICAgIHZhciBpdGVtID0gJGRhdGEuZWFybk5vZGVQbGVkZ2VMaXN0W25vZGVQbGVkZ2VMYXN0UG9zaXRpb25dO1xuICAgICAgICBpdGVtLnZpc2libGUgPSBcImdvbmVcIjtcbiAgICAgICAgJGRhdGEuZWFybk5vZGVQbGVkZ2VMaXN0W25vZGVQbGVkZ2VMYXN0UG9zaXRpb25dID0gaXRlbTtcbiAgICAgICAgaWYgKG5vZGVQbGVkZ2VMYXN0UG9zaXRpb24gPT0gcG9zaXRpb24pIHtcbiAgICAgICAgICAgIHN0YXRlID0gXCJ1bmZvbGRcIjtcbiAgICAgICAgfVxuICAgIH1cbiAgICBpZiAobm9kZVBsZWRnZUxhc3RQb3NpdGlvbiAhPSBwb3NpdGlvbikge1xuICAgICAgICB2YXIgaXRlbSA9ICRkYXRhLmVhcm5Ob2RlUGxlZGdlTGlzdFtwb3NpdGlvbl07XG4gICAgICAgIGl0ZW0udmlzaWJsZSA9IFwidmlzaWJsZVwiO1xuICAgICAgICAkZGF0YS5lYXJuTm9kZVBsZWRnZUxpc3RbcG9zaXRpb25dID0gaXRlbTtcbiAgICAgICAgbm9kZVBsZWRnZUxhc3RQb3NpdGlvbiA9IHBvc2l0aW9uO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIG5vZGVQbGVkZ2VMYXN0UG9zaXRpb24gPSAtMTtcbiAgICB9XG4gICAgYW5hbHl0aWNzKFwiYXBwX2Fzc2V0c19FYXJuX2N1cnJlbmN5X2NsaWNrXCIsIHtcbiAgICAgICAgXCJ0YWJOYW1lXCI6IFwic3Rha2luZ1wiLFxuICAgICAgICBcImN1cnJlbmN5XCI6IGN1cnJlbnRJdGVtLnN5bWJvbE5hbWUsXG4gICAgICAgIFwiY2xpY2tcIjogc3RhdGVcbiAgICB9KTtcbn1cblxudmFyIHNoYXJrRmluTGFzdFBvc2l0aW9uID0gLTE7XG5leHBvcnQgZnVuY3Rpb24gb25TaGFya0Zpbkl0ZW1DbGljayhwb3NpdGlvbikge1xuICAgIGNvbnNvbGUubG9nKFwib2xkUG9zaXRpb246IFwiICsgc2hhcmtGaW5MYXN0UG9zaXRpb24pO1xuICAgIHZhciBjdXJyZW50SXRlbSA9ICRkYXRhLmVhcm5TaGFya0Zpbkxpc3RbcG9zaXRpb25dO1xuICAgIHZhciBzdGF0ZSA9IFwiZm9sZFwiO1xuICAgIGlmIChzaGFya0Zpbkxhc3RQb3NpdGlvbiAhPSAtMSkge1xuICAgICAgICBjb25zb2xlLmxvZyhcIuS5i+WJjeacieWxleekuiDlhYjpmpDol49cIiArIHNoYXJrRmluTGFzdFBvc2l0aW9uKTtcbiAgICAgICAgdmFyIGl0ZW0gPSAkZGF0YS5lYXJuU2hhcmtGaW5MaXN0W3NoYXJrRmluTGFzdFBvc2l0aW9uXTtcbiAgICAgICAgaXRlbS52aXNpYmxlID0gXCJnb25lXCI7XG4gICAgICAgICRkYXRhLmVhcm5TaGFya0Zpbkxpc3QgPSAkZGF0YS5lYXJuU2hhcmtGaW5MaXN0O1xuICAgICAgICBpZiAoc2hhcmtGaW5MYXN0UG9zaXRpb24gPT0gcG9zaXRpb24pIHtcbiAgICAgICAgICAgIHN0YXRlID0gXCJ1bmZvbGRcIjtcbiAgICAgICAgfVxuICAgIH1cbiAgICBpZiAoc2hhcmtGaW5MYXN0UG9zaXRpb24gIT0gcG9zaXRpb24pIHtcbiAgICAgICAgY29uc29sZS5sb2coXCLmnInmlrDnmoTlnZDmoIcg5bGV56S65paw55qEOiBcIiArIHBvc2l0aW9uKTtcbiAgICAgICAgdmFyIGl0ZW0gPSAkZGF0YS5lYXJuU2hhcmtGaW5MaXN0W3Bvc2l0aW9uXTtcbiAgICAgICAgaXRlbS52aXNpYmxlID0gXCJ2aXNpYmxlXCI7XG4gICAgICAgICRkYXRhLmVhcm5TaGFya0Zpbkxpc3QgPSAkZGF0YS5lYXJuU2hhcmtGaW5MaXN0O1xuICAgICAgICBzaGFya0Zpbkxhc3RQb3NpdGlvbiA9IHBvc2l0aW9uO1xuICAgICAgICBjb25zb2xlLmxvZyhcIuabtOaWsOiAgeWdkOaghzogXCIgKyBzaGFya0Zpbkxhc3RQb3NpdGlvbik7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgY29uc29sZS5sb2coXCLkuKTmrKHngrnlh7vkuIDoh7Qg5b2S5L2NOiBcIiArIHNoYXJrRmluTGFzdFBvc2l0aW9uICsgXCItLS0tLS0tLVwiICsgcG9zaXRpb24pO1xuICAgICAgICBzaGFya0Zpbkxhc3RQb3NpdGlvbiA9IC0xO1xuICAgIH1cbiAgICBhbmFseXRpY3MoXCJhcHBfYXNzZXRzX0Vhcm5fY3VycmVuY3lfY2xpY2tcIiwge1xuICAgICAgICBcInRhYk5hbWVcIjogXCJzaGFrZUZpblwiLFxuICAgICAgICBcImN1cnJlbmN5XCI6IGN1cnJlbnRJdGVtLnN5bWJvbE5hbWUsXG4gICAgICAgIFwiY2xpY2tcIjogc3RhdGVcbiAgICB9KTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIG9uUmVsb2FkRWFybkhpZ2hDbGljaygpIHtcbiAgICBnZXRFYXJuRGF0YShcIjNcIik7XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBvblJlbG9hZEVhcm5Ob2RlUGxlZGdlQ2xpY2soKSB7XG4gICAgZ2V0RWFybkRhdGEoXCI0XCIpO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gb25SZWxvYWRFYXJuU2hhcmtGaW5DbGljaygpIHtcbiAgICBnZXRFYXJuRGF0YShcIjVcIik7XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBnb1RvSGJFYXJuUGFnZSgpIHtcbiAgICBqdW1wKDM1KTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGdvVG9Ob2RlUGxlZGdlUGFnZSgpIHtcbiAgICBhbmFseXRpY3MoXCJhcHBfYXNzZXRzX0Vhcm5fU3Rha2VOb3dfY2xpY2tcIiwge30pO1xuICAgIGp1bXAoMTQwKTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGdvVG9TaGFya0ZpblBhZ2UoKSB7XG4gICAgYW5hbHl0aWNzKFwiYXBwX2Fzc2V0c19FYXJuX0Vhcm5Ob3dfY2xpY2tcIiwge1xuICAgICAgICBcInRhYk5hbWVcIjogXCJzaGFrZUZpblwiXG4gICAgfSk7XG4gICAgb3BlblJvdXRlcihcImhvbGlnZWl0Oi8vb3Blbi92MT9sb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vZWRnZWVuZ2luZS9jb250YWluZXI/c2NlbmU9ZWFybiZyb290TmFtZT1zdHJ1Y3R1cmVkJm5hdkNvbmZpZz1uYXRpdmUmdGFiPXNoYXJrZmluJmlzQ2xvc2U9dHJ1ZVwiKTtcbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGNsaWNrU3BvdEl0ZW0ocG9zaXRpb24pIHtcbiAgICB0cnkge1xuICAgICAgICBjb25zdCBzcG90RWxlbWVudCA9IGNhY2hlRGF0YS5zcG90LnNwb3Quc3BvdExpc3ROZXdbcG9zaXRpb25dO1xuICAgICAgICBjb25zb2xlLmxvZyhgY2xpY2tTcG90SXRlbSAgIGN1cnJlbmN5ICAtLS0tPiAgJHtKU09OLnN0cmluZ2lmeShzcG90RWxlbWVudCl9YCk7XG4gICAgICAgIGlmICghc3BvdEVsZW1lbnQpIHtcbiAgICAgICAgICAgIHJldHVybjtcbiAgICAgICAgfVxuICAgICAgICBjdXJyZW50U3BvdEV4cGFuZEN1cnJlbmN5ID0gc3BvdEVsZW1lbnQuY3VycmVuY3k7XG4gICAgICAgIGNvbnN0IHBhcmFtcyA9IGdlblJlcXVlc3RQYXJhbXMoaW5kZXhQaXJjZVBhdGgsIHsgY3VycmVuY3lDb2RlOiBzcG90RWxlbWVudC5jdXJyZW5jeSB9KTtcbiAgICAgICAgY29uc3QgcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QocGFyYW1zKTtcbiAgICAgICAgY29uc3QgcmVzcG9uc2UgPSBKU09OLnBhcnNlKHJlc3BvbnNlU3RyaW5nKTtcbiAgICAgICAgY29uc3QgeyBjb2RlLCBkYXRhIH0gPSByZXNwb25zZTtcbiAgICAgICAgaWYgKGNvZGUgIT09IDIwMCkge1xuICAgICAgICAgICAgLy8gc3BvdEVsZW1lbnQuc3BvdEV4UHJpY2UgPSBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBcIi0tXCI7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBjb25zdCBjdXJyZW5jeVN5bWJvbCA9IGF3YWl0IGdldExlZ2FsQ3VycmVuY3lTeW1ib2woKTtcbiAgICAgICAgICAgIGxldCByZXN1bHQgPSBhd2FpdCBjb252ZXJ0TGVnYWxUZW5kZXIoJ3VzZHQnLCBkYXRhLnVzZHRQcmljZSwgY2hlY2tGaWVsZChkYXRhLmN1cnJlbmN5U2NhbGUsIDIpKTtcbiAgICAgICAgICAgIGlmIChg4Li/YCA9PSBjdXJyZW5jeVN5bWJvbCAmJiBkYXRhICE9IDAgJiYgcmVzdWx0ID09IDApIHtcbiAgICAgICAgICAgICAgICByZXN1bHQgPSBgPDAuMDAwMDAwMDFgO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgc3BvdEVsZW1lbnQuc3BvdEV4UHJpY2UgPSBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBhZGRDdXJyZW5jeVN5bWJvbChjdXJyZW5jeVN5bWJvbCwgcmVzdWx0KTtcbiAgICAgICAgICAgICRkYXRhLnNwb3RJbmRleFByaWNlRGF0YSA9IEpTT04uc3RyaW5naWZ5KHsgcG9zaXRpb246IHBvc2l0aW9uLCBkYXRhOiBzcG90RWxlbWVudCB9KTtcbiAgICAgICAgICAgIGluZGV4UHJpY2VNYXBbYCR7Y3VycmVudFNwb3RFeHBhbmRDdXJyZW5jeX1gXSA9IHtcbiAgICAgICAgICAgICAgICB1c2R0UHJpY2U6IGAke2RhdGEudXNkdFByaWNlfWAsXG4gICAgICAgICAgICAgICAgY3VycmVuY3lTY2FsZTogYCR7ZGF0YS5jdXJyZW5jeVNjYWxlfWAsXG4gICAgICAgICAgICAgICAgY3VycmVudFNwb3RFeHBhbmRDdXJyZW5jeTogYCR7Y3VycmVudFNwb3RFeHBhbmRDdXJyZW5jeX1gXG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgaW5kZXhQcmljZU1hcCA6ICR7SlNPTi5zdHJpbmdpZnkoaW5kZXhQcmljZU1hcCl9YClcbiAgICAgICAgfVxuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5lcnJvcihgY2xpY2tTcG90SXRlbSBlcnJvciAke2V9YCk7XG4gICAgfVxufVxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGdldFNwb3RFeHBhbmRJbmRleFByaWNlKHNwb3RFbGVtZW50KSB7XG5cbn1cblxuZnVuY3Rpb24gaXNDaGluZXNlKCkge1xuXHRyZXR1cm4gY29tbW9uRGF0YS5sYW5ndWFnZS50b0xvd2VyQ2FzZSgpID09IFwiemgtY25cIiB8fCBjb21tb25EYXRhLmxhbmd1YWdlLnRvTG93ZXJDYXNlKCkgPT0gXCJ6aC1oa1wiO1xufVxuXG4vLyDlkIjnuqbnvZHmoLxcbmV4cG9ydCBhc3luYyBmdW5jdGlvbiBnZXRDb250cmFjdEdyaWREYXRhKCkge1xuICAgIGNvbnN0IHBhcmFtID0ge1xuICAgICAgICBsaW1pdDogXCIxMDBcIixcbiAgICAgICAgZnJvbTogXCIwXCIsXG4gICAgICAgIGRpcmVjdDogXCIxXCIsXG4gICAgfTtcbiAgICBjb25zdCBwYXJhbXMgPSBnZW5SZXF1ZXN0UGFyYW1zKGNvbnRyYWN0R3JpZEluZm9QYXRoLCBwYXJhbSk7XG4gICAgdHJ5IHtcbiAgICAgICAgY29uc3QgcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QocGFyYW1zKTtcbiAgICAgICAgY29uc3QgcmVzcG9uc2UgPSBKU09OLnBhcnNlKHJlc3BvbnNlU3RyaW5nKTtcbiAgICAgICAgY29uc3QgeyBjb2RlLCBkYXRhIH0gPSByZXNwb25zZTtcbiAgICAgICAgaWYgKGNvZGUgIT09IDIwMCkge1xuICAgICAgICAgICAgJGRhdGEuY29udHJhY3RHcmlkTGlzdEVycm9yID0gZ2V0UmVzcG9uc2VQYXJhbXMoY29kZSwgZmFsc2UpO1xuICAgICAgICAgICAgJGRhdGEuY29udHJhY3RHcmlkTGlzdCA9IFt7IFwidHlwZVwiOiBcIjNcIiB9XTtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKFRBRywgYGdldENvbnRyYWN0R3JpZERhdGEsIGNvZGU9JHtjb2RlfWApO1xuICAgICAgICB9XG4gICAgICAgIGVsc2Uge1xuICAgICAgICAgICAgY2FjaGVEYXRhLmNvbnRyYWN0R3JpZC5saXN0ID0gZGF0YSA/IGRhdGEuc3RyYXRlZ3lMaXN0IDogW107XG4gICAgICAgICAgICB1cGRhdGVDb250cmFjdEdyaWREYXRhKGNhY2hlRGF0YS5jb250cmFjdEdyaWQubGlzdCk7XG4gICAgICAgICAgICBjb25zb2xlLmxvZygndXBkYXRlQ29udHJhY3RHcmlkRGF0YScpO1xuICAgICAgICB9XG4gICAgfVxuICAgIGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUuZXJyb3IoVEFHLCBgZ2V0Q29udHJhY3RHcmlkRGF0YSwgJHtlfWApO1xuICAgICAgICAkZGF0YS5jb250cmFjdEdyaWRMaXN0ID0gW3sgXCJ0eXBlXCI6IFwiM1wiIH1dO1xuICAgICAgICAkZGF0YS5jb250cmFjdEdyaWRMaXN0RXJyb3IgPSBnZXRSZXNwb25zZVBhcmFtcygtMSwgZmFsc2UpO1xuICAgIH1cbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHVwZGF0ZUNvbnRyYWN0R3JpZERhdGEob3JpZ2lubGlzdCkge1xuICAgIGNvbnNvbGUubG9nKGB1cGRhdGVDb250cmFjdEdyaWREYXRhIG9yaWdpbmxpc3Q6ICR7SlNPTi5zdHJpbmdpZnkob3JpZ2lubGlzdCl9YCk7XG4gICAgaWYgKCFvcmlnaW5saXN0IHx8IG9yaWdpbmxpc3QubGVuZ3RoID09IDApIHtcbiAgICAgICAgY29uc29sZS5sb2coYHVwZGF0ZUNvbnRyYWN0R3JpZERhdGEgdHlwZSAyYCk7XG4gICAgICAgICRkYXRhLmNvbnRyYWN0R3JpZExpc3QgPSBbeyBcInR5cGVcIjogXCIyXCIgfV07XG4gICAgICAgIHJldHVybjtcbiAgICB9XG4gICAgdHJ5IHtcbiAgICAgICAgY29uc3QgY29udHJhY3RHcmlkRGF0YSA9IGF3YWl0IHNvcnRCb3RMaXN0KG9yaWdpbmxpc3QpO1xuICAgICAgICBjb25zdCBjdXJyZW5jeVN5bWJvbCA9IGF3YWl0IGdldExlZ2FsQ3VycmVuY3lTeW1ib2woKTtcbiAgICAgICAgY2FjaGVEYXRhLmNvbnRyYWN0R3JpZC5uZXdMaXN0ID0gY29udHJhY3RHcmlkRGF0YTtcbiAgICAgICAgdmFyIGxhc3RQb3NpdGlvbklkID0gLTE7XG4gICAgICAgIGlmIChjb250cmFjdEdyaWRMYXN0UG9zaXRpb24gIT0gLTEgJiYgJGRhdGEuY29udHJhY3RHcmlkTGlzdC5sZW5ndGggPiBjb250cmFjdEdyaWRMYXN0UG9zaXRpb24pIHtcbiAgICAgICAgICAgIGxhc3RQb3NpdGlvbklkID0gJGRhdGEuY29udHJhY3RHcmlkTGlzdFtjb250cmFjdEdyaWRMYXN0UG9zaXRpb25dLnN0cmF0ZWd5SWQ7XG4gICAgICAgIH1cbiAgICAgICAgY29udHJhY3RHcmlkTGFzdFBvc2l0aW9uID0gLTE7XG4gICAgICAgIGNvbnN0IGNvbnRyYWN0R3JpZExpc3QgPSBhd2FpdCBQcm9taXNlLmFsbChjb250cmFjdEdyaWREYXRhLm1hcChhc3luYyAoaXRlbSwgaW5kZXgpID0+IHtcbiAgICAgICAgICAgIGxldCBpc29sYXRlZE5hbWUgPSBcIlwiO1xuICAgICAgICAgICAgLy8gIDEt5rC457utIDIt5b2T5ZGoIDMt5qyh5ZGoIDQt5b2T5a2jIDUt5qyh5a2jXG4gICAgICAgICAgICBpZiAoMSA9PSBpdGVtLmluc3RydW1lbnRUeXBlKSB7XG4gICAgICAgICAgICAgICAgaXNvbGF0ZWROYW1lID0gJGkxOG4ubl9tYXJrZXRfY29udHJhY3Rfc3dhcF90cmFkZV9uYW1lX2FiYnI7XG4gICAgICAgICAgICB9IGVsc2UgaWYgKDIgPT0gaXRlbS5pbnN0cnVtZW50VHlwZSkge1xuICAgICAgICAgICAgICAgIGlzb2xhdGVkTmFtZSA9ICRpMThuLm5fbWFya2V0X2NvbnRyYWN0X3N5bWJvbF90aGlzd2Vla19hYmJyO1xuICAgICAgICAgICAgfSBlbHNlIGlmICgzID09IGl0ZW0uaW5zdHJ1bWVudFR5cGUpIHtcbiAgICAgICAgICAgICAgICBpc29sYXRlZE5hbWUgPSAkaTE4bi5uX21hcmtldF9jb250cmFjdF9zeW1ib2xfbmV4dHdlZWtfYWJicjtcbiAgICAgICAgICAgIH0gZWxzZSBpZiAoNCA9PSBpdGVtLmluc3RydW1lbnRUeXBlKSB7XG4gICAgICAgICAgICAgICAgaXNvbGF0ZWROYW1lID0gJGkxOG4ubl9tYXJrZXRfY29udHJhY3Rfc3ltYm9sX3F1YXJ0ZXJfYWJicjtcbiAgICAgICAgICAgIH0gZWxzZSBpZiAoNSA9PSBpdGVtLmluc3RydW1lbnRUeXBlKSB7XG4gICAgICAgICAgICAgICAgaXNvbGF0ZWROYW1lID0gJGkxOG4ubl9tYXJrZXRfY29udHJhY3Rfc3ltYm9sX25leHR3ZWVrX2FiYnI7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICBjb25zdCBpdGVtTmFtZSA9IGAke2l0ZW0uc3ltYm9sVHJhbnNsYXRlTmFtZX0ke2lzb2xhdGVkTmFtZX1gO1xuICAgICAgICAgICAgbGV0IHRyZW5kVHlwZSA9IFwiXCI7XG4gICAgICAgICAgICBsZXQgY29sb3JUeXBlID0gMDtcbiAgICAgICAgICAgIGlmIChpdGVtLnRyZW5kVHlwZSA9PSAxKSB7XG4gICAgICAgICAgICAgICAgdHJlbmRUeXBlID0gJGkxOG4ubl9jb250cmFjdF9ncmlkX2J1eTtcbiAgICAgICAgICAgICAgICBjb2xvclR5cGUgPSAxO1xuICAgICAgICAgICAgfSBlbHNlIGlmIChpdGVtLnRyZW5kVHlwZSA9PSAyKSB7XG4gICAgICAgICAgICAgICAgdHJlbmRUeXBlID0gJGkxOG4ubl9jb250cmFjdF9ncmlkX3NlbGw7XG4gICAgICAgICAgICAgICAgY29sb3JUeXBlID0gLTE7XG4gICAgICAgICAgICB9IGVsc2UgaWYgKGl0ZW0udHJlbmRUeXBlID09IDApIHtcbiAgICAgICAgICAgICAgICB0cmVuZFR5cGUgPSAkaTE4bi5uX2NvbnRyYWN0X2dyaWRfbmV1dHJhbDtcbiAgICAgICAgICAgICAgICBjb2xvclR5cGUgPSAwO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgY29uc3QgbG9uZ09yU2hvcnRDb2xvciA9IGF3YWl0IHJpc2VDb2xvcihjb2xvclR5cGUpO1xuICAgICAgICAgICAgY29uc3QgbGV2ZXIgPSBgJHtpdGVtLmxldmVyfVhgO1xuICAgICAgICAgICAgY29uc3QgY29zdCA9IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGF3YWl0IGdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudChTeW1ib2xzLnVzZHQsIGl0ZW0uaW52ZXN0QW1vdW50KTtcbiAgICAgICAgICAgIGNvbnN0IGVxdWFsVG9kYXlQcm9maXQgPSBpc0hpZGRlbiA/IEhJRERFTl9TVFIgOiBhd2FpdCBjb252ZXJ0TGVnYWxUZW5kZXIoU3ltYm9scy51c2R0LCBpdGVtLnRvdGFsUHJvZml0QW1vdW50LCAyKTtcbiAgICAgICAgICAgIGNvbnN0IG9yaWdpblNwb3RZaWVsZCA9IGFkZEN1cnJlbmN5U3ltYm9sKGN1cnJlbmN5U3ltYm9sLCBlcXVhbFRvZGF5UHJvZml0KTtcbiAgICAgICAgICAgIGNvbnN0IHNwb3RZaWVsZCA9IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGAke2l0ZW0udG90YWxQcm9maXRBbW91bnQgPj0gMCA/ICcrJyA6ICcnfSR7b3JpZ2luU3BvdFlpZWxkfWA7XG4gICAgICAgICAgICBjb25zdCBvcmlnaW5TcG90UmF0ZSA9IGZpeFJhdGUoaXRlbS50b3RhbFByb2ZpdFJhdGUpO1xuICAgICAgICAgICAgY29uc3Qgc3BvdFlpZWxkUmF0ZSA9IGlzSGlkZGVuID8gSElEREVOX1NUUiA6IGAke2l0ZW0udG90YWxQcm9maXRSYXRlID49IDAgPyAnKycgOiAnJ30ke29yaWdpblNwb3RSYXRlfWA7XG4gICAgICAgICAgICBjb25zdCBzcG90UmlzZUNvbG9yID0gaXNIaWRkZW4gPyAnQGNvbG9yL2tDb2xvclNlY29uZGFyeVRleHQnIDogYXdhaXQgcmlzZUNvbG9yKGl0ZW0udG90YWxQcm9maXRBbW91bnQpO1xuICAgICAgICAgICAgY29uc3QgdmlzaWJsZSA9IGl0ZW0uc3RyYXRlZ3lJZCA9PSBsYXN0UG9zaXRpb25JZCA/IFwidmlzaWJsZVwiIDogXCJnb25lXCI7XG4gICAgICAgICAgICBpZiAoaXRlbS5zdHJhdGVneUlkID09IGxhc3RQb3NpdGlvbklkKSB7XG4gICAgICAgICAgICAgICAgY29udHJhY3RHcmlkTGFzdFBvc2l0aW9uID0gaW5kZXg7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgICByZXR1cm4ge1xuICAgICAgICAgICAgICAgIHR5cGU6IFwiMVwiLFxuICAgICAgICAgICAgICAgIGluZGV4OiBpbmRleCxcbiAgICAgICAgICAgICAgICBzdHJhdGVneUlkOiBpdGVtLnN0cmF0ZWd5SWQsXG4gICAgICAgICAgICAgICAgdmlzaWJsZSxcbiAgICAgICAgICAgICAgICBpdGVtTmFtZSwgLy8g5Lqk5piT5a+55ZCN56ewICsg5ZCI57qm57G75Z6LXG4gICAgICAgICAgICAgICAgdHJlbmRUeXBlLCAvLyDotovlir8g5YGa5aSa5YGa56m6XG4gICAgICAgICAgICAgICAgbG9uZ09yU2hvcnRDb2xvciwgLy8g5aSa56m66aKc6ImyXG4gICAgICAgICAgICAgICAgbGV2ZXIsIC8vIDV4XG4gICAgICAgICAgICAgICAgY29zdCwvLyDmipXlhaVcbiAgICAgICAgICAgICAgICBzcG90WWllbGQsIC8vIOaAu+aUtuebilxuICAgICAgICAgICAgICAgIHNwb3RZaWVsZFJhdGUsIC8vIOaUtuebiueOh1xuICAgICAgICAgICAgICAgIHNwb3RSaXNlQ29sb3IgLy8g5pS255uK6aKc6ImyXG4gICAgICAgICAgICB9O1xuICAgICAgICB9KSk7XG4gICAgICAgIGNvbnNvbGUubG9nKFRBRywgYHVwZGF0ZUNvbnRyYWN0R3JpZERhdGEgU3VjY2VlZCwobGlzdCk9JHtKU09OLnN0cmluZ2lmeShjb250cmFjdEdyaWRMaXN0KX1gKTtcbiAgICAgICAgJGRhdGEuY29udHJhY3RHcmlkTGlzdCA9IGNvbnRyYWN0R3JpZExpc3Q7XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICBjb25zb2xlLmVycm9yKGB1cGRhdGVDb250cmFjdEdyaWREYXRhIEVycm9yLCAke2V9YCk7XG4gICAgfVxufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gdXBkYXRlQ29udHJhY3RHcmlkQmFzZUluZm8oZGF0YSkge1xuICAgIGNvbnNvbGUubG9nKGB1cGRhdGVDb250cmFjdEdyaWRCYXNlSW5mbyAke2lzSGlkZGVufWApO1xuXG4gICAgaWYgKGlzSGlkZGVuKSB7XG4gICAgICAgICRkYXRhLmNvbnRyYWN0R3JpZFRvdGFsQXNzZXQgPSBISURERU5fU1RSO1xuICAgICAgICAkZGF0YS5jb250cmFjdEdyaWRQbE51bWJlciA9IEhJRERFTl9TVFI7XG4gICAgICAgICRkYXRhLmNvbnRyYWN0R3JpZFBsTnVtYmVyQ29sb3IgPSAnQGNvbG9yL2tDb2xvclNlY29uZGFyeVRleHQnO1xuICAgICAgICByZXR1cm47XG4gICAgfVxuICAgIHRyeSB7XG4gICAgICAgIGNvbnN0IGxlZ2FsQ3VycmVuY3lTeW1ib2wgPSBhd2FpdCBnZXRMZWdhbEN1cnJlbmN5U3ltYm9sKCk7XG4gICAgICAgIGNvbnN0IGVxdWFsQW1vdW50ID0gYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50SGFuZGxlTnVsbChTeW1ib2xzLnVzZHQsIGRhdGEuYmFsYW5jZSk7XG4gICAgICAgICRkYXRhLmNvbnRyYWN0R3JpZFRvdGFsQXNzZXQgPSBhZGRDdXJyZW5jeVN5bWJvbFRvdGFsQXNzZXQobGVnYWxDdXJyZW5jeVN5bWJvbCwgYXdhaXQgZm9ybWF0TnVtKGVxdWFsQW1vdW50KSk7XG4gICAgICAgIGNvbnN0IHRvZGF5UHJvZml0ID0gYXdhaXQgZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50SGFuZGxlTnVsbChTeW1ib2xzLnVzZHQsIGRhdGEudG9kYXlQcm9maXQpO1xuICAgICAgICBjb25zdCB0b2RheVByb2ZpdFdpdGhTeW1ib2wgPSBhZGRDdXJyZW5jeVN5bWJvbChsZWdhbEN1cnJlbmN5U3ltYm9sLCB0b2RheVByb2ZpdCk7XG4gICAgICAgICRkYXRhLmNvbnRyYWN0R3JpZFBsTnVtYmVyID0gYCR7dG9kYXlQcm9maXRXaXRoU3ltYm9sfS8ke2ZpeFJhdGVIYW5kbGVOdWxsKGRhdGEudG9kYXlQcm9maXRSYXRlKX1gO1xuICAgICAgICAkZGF0YS5jb250cmFjdEdyaWRQbE51bWJlckNvbG9yID0gYXdhaXQgcmlzZUNvbG9yKGRhdGEudG9kYXlQcm9maXQpO1xuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgY29uc29sZS5lcnJvcihgdXBkYXRlQm90QmFzZUluZm9EYXRhICR7ZX1gKTtcbiAgICB9XG59XG5cbnZhciBjb250cmFjdEdyaWRMYXN0UG9zaXRpb24gPSAtMTtcbmV4cG9ydCBmdW5jdGlvbiBvbkNvbnRyYWN0R3JpZEl0ZW1DbGljayhwb3NpdGlvbikge1xuICAgIGNvbnNvbGUubG9nKFwiY29udHJhY3RHcmlkIG9sZFBvc2l0aW9uOiBcIiArIGNvbnRyYWN0R3JpZExhc3RQb3NpdGlvbik7XG4gICAgdmFyIHRlbXBMaXN0ID0gJGRhdGEuY29udHJhY3RHcmlkTGlzdC5yYXdBcnJheSgpO1xuICAgIGlmIChjb250cmFjdEdyaWRMYXN0UG9zaXRpb24gIT0gLTEpIHtcbiAgICAgICAgY29uc29sZS5sb2coXCLkuYvliY3mnInlsZXnpLog5YWI6ZqQ6JePXCIgKyBjb250cmFjdEdyaWRMYXN0UG9zaXRpb24pO1xuICAgICAgICBpZiAodGVtcExpc3QubGVuZ3RoID4gY29udHJhY3RHcmlkTGFzdFBvc2l0aW9uKSB7XG4gICAgICAgICAgICB0ZW1wTGlzdFtjb250cmFjdEdyaWRMYXN0UG9zaXRpb25dLnZpc2libGUgPSBcImdvbmVcIjtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGNvbnRyYWN0R3JpZExhc3RQb3NpdGlvbiA9IC0xO1xuICAgICAgICB9XG4gICAgfVxuICAgIGlmIChjb250cmFjdEdyaWRMYXN0UG9zaXRpb24gIT0gcG9zaXRpb24pIHtcbiAgICAgICAgY29uc29sZS5sb2coXCLmnInmlrDnmoTlnZDmoIcg5bGV56S65paw55qEOiBcIiArIHBvc2l0aW9uKTtcbiAgICAgICAgdGVtcExpc3RbcG9zaXRpb25dLnZpc2libGUgPSBcInZpc2libGVcIjtcbiAgICAgICAgY29udHJhY3RHcmlkTGFzdFBvc2l0aW9uID0gcG9zaXRpb247XG4gICAgICAgIGNvbnNvbGUubG9nKFwi5pu05paw6ICB5Z2Q5qCHOiBcIiArIGNvbnRyYWN0R3JpZExhc3RQb3NpdGlvbik7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgY29uc29sZS5sb2coXCLkuKTmrKHngrnlh7vkuIDoh7Qg5b2S5L2NOiBcIiArIGNvbnRyYWN0R3JpZExhc3RQb3NpdGlvbiArIFwiLS0tLS0tLS1cIiArIHBvc2l0aW9uKTtcbiAgICAgICAgY29udHJhY3RHcmlkTGFzdFBvc2l0aW9uID0gLTE7XG4gICAgfVxuICAgICRkYXRhLmNvbnRyYWN0R3JpZExpc3QgPSB0ZW1wTGlzdDtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGdvVG9Db250cmFjdEdyaWRQYWdlKCkge1xuICAgIC8vIOWIm+W7uuWQiOe6pue9keagvFxuICAgIG9wZW5Sb3V0ZXIoXCJob2xpZ2VpdDovL29wZW4vdjE/bG9naW49MSZ1cmw9aWh1b2JpZ2xvYmFsOi8vbS5oYmcuY29tL3RyYWRlL2NvbnRyYWN0R3JpZD9zb3VyY2U9YXBwX2JvdHNfYXNzZXRzcGFnZVwiKTtcbiAgICBhbmFseXRpY3MoXCJhcHBfd2FsbGV0X2JvdHNfZnV0dXJlc0dyaWRfY3JlYXRlX2NsaWNrXCIsIHt9KTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIG9uUmVsb2FkQ29udHJhY3RHcmlkQ2xpY2soKSB7XG4gICAgZ2V0Q29udHJhY3RHcmlkRGF0YSgpO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gc3RvcFBvcENsb3NlKCkge1xuICAgICRkYXRhLnN0b3BQb3BTaG93ID0gXCJmYWxzZVwiO1xufVxuXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gc3RvcENvbmZpcm1DbGljaygpIHtcbiAgICAkbmF0aXZlQVBJLnNob3dMb2FkaW5nKDEpO1xuICAgIHZhciBwYXJhbXMgPSB7IFwic3RyYXRlZ3lJZFwiOiBjbGlja2VkU3RyYXRlZ3lJZCB9O1xuICAgIHZhciBoZWFkZXIgPSB7IFwiQ29udGVudC1UeXBlXCI6IFwiYXBwbGljYXRpb24vanNvblwiIH07XG4gICAgY29uc3QgcmVxdWVzdFBhcmFtcyA9IGdlblJlcXVlc3RQYXJhbXMoY29udHJhY3RHcmlkU3RvcFBhdGgsIHBhcmFtcywgMSwgMCwgaGVhZGVyKTtcbiAgICB0cnkge1xuICAgICAgICBjb25zdCByZXNwb25zZVN0cmluZyA9IGF3YWl0ICRuYXRpdmVBUEkucmVxdWVzdChyZXF1ZXN0UGFyYW1zKTtcbiAgICAgICAgY29uc3QgcmVzcERhdGEgPSBKU09OLnBhcnNlKHJlc3BvbnNlU3RyaW5nKTtcbiAgICAgICAgdmFyIHsgY29kZSwgZGF0YSB9ID0gcmVzcERhdGE7XG4gICAgICAgICRuYXRpdmVBUEkuc2hvd0xvYWRpbmcoMCk7XG4gICAgICAgIGlmIChjb2RlID09IDIwMCAmJiBkYXRhID09IHRydWUpIHtcbiAgICAgICAgICAgICRkYXRhLnN0b3BQb3BTaG93ID0gXCJmYWxzZVwiO1xuICAgICAgICAgICAgJG5hdGl2ZUFQSS5oYlRvYXN0KCRpMThuLm5fYm90X2RldGFpbF90b2FzdF9zdG9wX3N1Y2Nlc3MpO1xuICAgICAgICAgICAgLy8g5bu26L+fMXPliLfmlrDmlbDmja5cbiAgICAgICAgICAgIHNldFRpbWVvdXQoKCkgPT4ge1xuICAgICAgICAgICAgICAgIGdldENvbnRyYWN0R3JpZERhdGEoKTtcbiAgICAgICAgICAgIH0sIDEwMDApO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgJG5hdGl2ZUFQSS5oYlRvYXN0KCRpMThuLm5fYm90X2RldGFpbF90b2FzdF9zdG9wX2ZhaWwpO1xuICAgICAgICB9XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgICAkbmF0aXZlQVBJLnNob3dMb2FkaW5nKDApO1xuICAgICAgICBjb25zb2xlLmVycm9yKFRBRywgYHN0b3BDb25maXJtQ2xpY2ssICR7ZX1gKTtcbiAgICB9XG59XG5cbi8vIOWFheaPkOS/oeaBr1xuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIGdldERlcG9zaXRXaXRoZHJhdygpIHtcbiAgICBjb25zdCBwYXJhbXMgPSBnZW5SZXF1ZXN0UGFyYW1zKGRlcG9zaXRXaXRoZHJhd1BhdGgpO1xuICAgIHRyeSB7XG4gICAgICAgIGNvbnN0IHJlc3BvbnNlU3RyaW5nID0gYXdhaXQgJG5hdGl2ZUFQSS5yZXF1ZXN0KHBhcmFtcyk7XG4gICAgICAgIGNvbnN0IHJlc3BvbnNlID0gSlNPTi5wYXJzZShyZXNwb25zZVN0cmluZyk7XG4gICAgICAgIGNvbnN0IHsgY29kZSwgZGF0YSB9ID0gcmVzcG9uc2U7XG4gICAgICAgIGlmIChjb2RlID09IDIwMCkge1xuICAgICAgICAgICAgY29uc29sZS5sb2coJ2RlcG9zaXQtd2l0aGRyYXcnKTtcbiAgICAgICAgICAgIHVwZGF0ZURlcG9zaXRXaXRoZHJhdyhkYXRhKTtcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKFRBRywgYGRlcG9zaXQtd2l0aGRyYXcsIGNvZGU9JHtjb2RlfWApO1xuICAgICAgICB9XG4gICAgfVxuICAgIGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUuZXJyb3IoVEFHLCBgZGVwb3NpdC13aXRoZHJhdywgJHtlfWApO1xuICAgIH1cbn1cblxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHVwZGF0ZURlcG9zaXRXaXRoZHJhdyhkYXRhbGlzdCkge1xuICAgIHRyeSB7XG4gICAgICAgIGNvbnN0IGR3SW5mb0xpc3QgPSBhd2FpdCBQcm9taXNlLmFsbChkYXRhbGlzdC5tYXAoYXN5bmMgKGl0ZW0sIGluZGV4KSA9PiB7XG4gICAgICAgICAgICBjb25zdCBjb250ZW50ID0gaXNIaWRkZW4gPyBISURERU5fU1RSIDogaXRlbS50cmFuc2xhdGVDb250ZW50RGF0YTtcbiAgICAgICAgICAgIHJldHVybiB7XG4gICAgICAgICAgICAgICAgY2VsbFR5cGU6IFwiMVwiLFxuICAgICAgICAgICAgICAgIGluZGljYXRvcldpZHRoOiBpbmRleCA9PSAwID8gXCIxNVwiIDogXCI0XCIsXG4gICAgICAgICAgICAgICAgY29udGVudCxcbiAgICAgICAgICAgICAgICB0cmFuc2xhdGVDb250ZW50RGF0YTogaXRlbS50cmFuc2xhdGVDb250ZW50RGF0YSxcbiAgICAgICAgICAgICAgICBpY29uVXJsOiBpdGVtLmljb25VcmwsXG4gICAgICAgICAgICAgICAgdHlwZTogYCR7aXRlbS50eXBlfWAsXG4gICAgICAgICAgICAgICAgaW5kZXhcbiAgICAgICAgICAgIH07XG4gICAgICAgIH0pKTtcbiAgICAgICAgJGRhdGEuZHdDdXJyZW50SW5kZXggPSAwO1xuICAgICAgICAkZGF0YS5kd0luZm9MaXN0ID0gZHdJbmZvTGlzdDtcbiAgICAgICAgJGRhdGEuZHdJbmZvU2hvdyA9ICRkYXRhLmR3SW5mb0xpc3QubGVuZ3RoID4gMCA/IFwidmlzaWJsZVwiIDogXCJnb25lXCI7XG4gICAgICAgICRkYXRhLnNob3dJbmRpY2F0b3IgPSAkZGF0YS5kd0luZm9MaXN0Lmxlbmd0aCA+IDEgPyBcInZpc2libGVcIiA6IFwiZ29uZVwiO1xuICAgICAgICBjb25zb2xlLmxvZyhUQUcsIGB1cGRhdGVEZXBvc2l0V2l0aGRyYXcgU3VjY2VlZCwobGlzdCk9JHtKU09OLnN0cmluZ2lmeShkd0luZm9MaXN0KX1gKTtcbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUuZXJyb3IoYHVwZGF0ZURlcG9zaXRXaXRoZHJhdyBFcnJvciwgJHtlfWApO1xuICAgIH1cbn1cblxuLy8g5YWF5o+Q5L+h5oGv552B55y86Zet55y8XG5leHBvcnQgZnVuY3Rpb24gaGlkZURlcG9zaXRXaXRoZHJhdygpIHtcbiAgICBpZiAoJGRhdGEuZHdJbmZvTGlzdCAmJiAkZGF0YS5kd0luZm9MaXN0Lmxlbmd0aCA+IDApIHtcbiAgICAgICAgZm9yIChsZXQgaW5kZXggPSAwOyBpbmRleCA8ICRkYXRhLmR3SW5mb0xpc3QubGVuZ3RoOyBpbmRleCsrKSB7XG4gICAgICAgICAgICBjb25zdCBlbGVtZW50ID0gJGRhdGEuZHdJbmZvTGlzdFtpbmRleF07XG4gICAgICAgICAgICBpZiAoaXNIaWRkZW4pIHtcbiAgICAgICAgICAgICAgICBlbGVtZW50LmNvbnRlbnQgPSBISURERU5fU1RSO1xuICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICBlbGVtZW50LmNvbnRlbnQgPSAkZGF0YS5kd0luZm9MaXN0W2luZGV4XS50cmFuc2xhdGVDb250ZW50RGF0YTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgIH1cbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGR3SW5kZXhDaGFuZ2Uoc2VsZWN0SW5kZXgpIHtcbiAgICAvLyDmjIfnpLrlmahcbiAgICBpZiAoJGRhdGEuZHdJbmZvTGlzdCAmJiAkZGF0YS5kd0luZm9MaXN0Lmxlbmd0aCA+IHNlbGVjdEluZGV4KSB7XG4gICAgICAgIGZvciAobGV0IGluZGV4ID0gMDsgaW5kZXggPCAkZGF0YS5kd0luZm9MaXN0Lmxlbmd0aDsgaW5kZXgrKykge1xuICAgICAgICAgICAgY29uc3QgZWxlbWVudCA9ICRkYXRhLmR3SW5mb0xpc3RbaW5kZXhdO1xuICAgICAgICAgICAgaWYgKHNlbGVjdEluZGV4ID09IGluZGV4KSB7XG4gICAgICAgICAgICAgICAgZWxlbWVudC5pbmRpY2F0b3JXaWR0aCA9ICcxNSc7XG4gICAgICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgICAgIGVsZW1lbnQuaW5kaWNhdG9yV2lkdGggPSAnNCc7XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICB9XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBkd0l0ZW1DbGlja2VkKHR5cGUpIHtcbiAgICAvLyDot7PovazlhYXmj5DpobXpnaIgMTog5YWF5biB77ybMu+8muaPkOW4gVxuICAgIG9wZW5Sb3V0ZXIoYGhvbGlnZWl0Oi8vb3Blbi92MT9sb2dpbj0xJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vYmFsYW5jZS9kV1JlY29yZD9wYWdlVHlwZT0ke3R5cGV9YCk7XG59XG5cbi8vIOenu+mZpOacq+WwvueahDDvvIw05L2N5bCP5pWwXG5leHBvcnQgZnVuY3Rpb24gcmVtb3ZlVHJhaWxpbmdaZXJvZXMobnVtKSB7XG4gIGxldCBmaXhlZCA9IG51bS50b1N0cmluZygpO1xuICByZXR1cm4gZml4ZWQucmVwbGFjZSgvXFwuPzArJC8sICcnKTsgLy8g56e76Zmk5bC+6YOo55qEMOWSjOWwj+aVsOeCuVxufVxuXG5leHBvcnQgZnVuY3Rpb24gZXhjaGFuZ2VVU0REQ2xpY2tlZCgpIHtcbiAgb3BlblJvdXRlcihgJHtleGNoYW5nZUp1bXBVcmx9P2Zyb209VVNEVCZ0bz1VU0REYCk7XG59XG5cbmluaXREYXRhKCk7XG4iLCJpbXBvcnQgKiBhcyBhc3NldCBmcm9tICcuL2Fzc2V0J1xuXG5PYmplY3QuYXNzaWduKGdsb2JhbFRoaXMsIGFzc2V0KTsiXSwibmFtZXMiOlsiaXNIaWRkZW4iLCJjdXJyZW50RGlzdHJpYnV0aW9uVHlwZSIsInVzZHRNQWxsIiwiY29pblBBbGwiLCJjb2luTUFsbCIsImlzQ29udHJhY3RPcGVuQ29uZmlnIiwiYXZhaWxhYmxlcyIsImNsaWNrYWJsZSIsImVuZFRpbWUiLCJhdXRvRWFybkd1aWRlU2hvdyIsInRvZGF5UHJvZml0U3RhdGUiLCJjbGlja2VkU3RyYXRlZ3lJZCIsImV4Y2hhbmdlRW5hYmxlIiwiZXhjaGFuZ2VKdW1wVXJsIiwiY29tbW9uRGF0YSIsIndlYlVybCIsImxhbmd1YWdlIiwiY3VycmVuY3lVcGRhdGVEYXRhIiwidXBEZXRhaWxDdXJyZW5jeSIsInVwZ3JhZGVDdXJyZW5jeSIsInVwZ3JhZGVKdW1wVXJsIiwidXBncmFkZURldGFpbFVybCIsInVwZ3JhZGVTdGF0ZSIsImFzeW5jIiwicmVhZCIsIm1vZHVsZSIsImtleSIsImRhdGEiLCIkbmF0aXZlQVBJIiwic3RvcmFnZSIsImFjdGlvbiIsIm5hbWUiLCJKU09OIiwicGFyc2UiLCJzeW5jQ3VycmVuY3lVcGRhdGVDb25maWciLCJ0bXBEYXRhIiwiJGRhdGEiLCJhc3NldF9zbWFsbF9jb2luX3RpdGxlIiwiZ2V0V29yZCIsInNlbmRDb21tb25Db25maWciLCJwYXJhbSIsImNvbnNvbGUiLCJsb2ciLCJjb2xvck1vZGUiLCJPUyIsInVwZ3JhZGVCZ0NvbG9yIiwidG9nZ2xlU2hvd0Fzc2V0IiwiaGlkZGVuQWxsQXNzZXQiLCJzaG93QWxsQXNzZXQiLCJjdXJyZW5jeUNvbW1vbiIsInJlc3RyaWN0aW9uUG9wIiwianVtcCIsInN0cmluZ2lmeSIsInR5cGUiLCJzaGFyZUFzc2V0Iiwic2hhcmUiLCJyYXRlIiwiY2FjaGVEYXRhIiwiYmFsYW5jZSIsInRvZGF5UHJvZml0UmF0ZSIsImluZGV4IiwiY2hpbGRUeXBlIiwicGFyYW1zIiwiYW5hbHlzaXNQYXJhbXMiLCJ0cmFjayIsInByb3BlcnRpZXMiLCJpdGVtMTU4Iiwic3BvdCIsIm5ld0xpc3QiLCJjdXJyZW5jeSIsInN0YWJsZSIsImNoZWNrRmllbGQiLCJpdGVtIiwidG9Mb3dlckNhc2UiLCJpdGVtMTEiLCJpdGVtMTIiLCJib3QiLCJpZCIsInN0cmF0ZWd5SWQiLCJzeW1ib2wiLCJjcmVhdGVQYXRoIiwiaXRlbTE0IiwidG90YWxQcm9maXRSYXRlIiwic3ltYm9sVGl0bGUiLCJzeW1ib2xUcmFuc2xhdGVOYW1lIiwicXVvdGVDdXJyZW5jeSIsIm1pblByaWNlIiwibWF4UHJpY2UiLCJ0cmFkZU51bSIsInJ1blRpbWUiLCJpdGVtMTYiLCJjb250cmFjdCIsInVzZHRfbSIsImFsbCIsInRyYWRlVHlwZSIsImNvaW5fcCIsImNvaW5fZiIsImNvbnRyYWN0Q29kZSIsIml0ZW00MiIsInVzZHRfbV91bml0eSIsIml0ZW00MyIsIml0ZW00NCIsInRlbXBJdGVtIiwibWFyZ2luTW9kZSIsImFzc2V0VHlwZSIsImF2YWlsYWJsZSIsIndpdGhkcmF3QXZhaWxhYmxlQW1vdW50IiwiZXF1aXR5IiwiZXF1aXR5TnVtQW1vdW50IiwibWFyZ2luQXZhaWxhYmxlQW1vdW50IiwiaXRlbTE3IiwiaXRlbTE4IiwicHJvZml0UmF0ZSIsImRpcmVjdGlvbiIsImxldmVyUmF0ZSIsIml0ZW0xMTciLCJvd25lZCIsIml0ZW0xMTgiLCJvcGVuUHJpY2UiLCJjb3N0T3BlbiIsImxhc3RQcmljZSIsIml0ZW0xOSIsIm90YyIsImNvaW5JRCIsImNvaW5JZCIsImNvaW5OYW1lIiwidG90YWwiLCJmcm96ZW4iLCJib3Jyb3ciLCJpdGVtMjAiLCJpdGVtMjIiLCJlYXJuIiwiZWFyblliYiIsInByb2plY3RJbmZvVXJsIiwidGFiTmFtZSIsImJ1dHRvbk5hbWUiLCJpdGVtMjQiLCJvcmRlcklkIiwicHJvamVjdFR5cGUiLCJpdGVtMjUiLCJtaW5pbmdZZWFyUmF0ZSIsIml0ZW0yNiIsIm9wdGlvbiIsImF2YWlsYWJsZU51bSIsInBvc2l0aW9uTnVtIiwiaXRlbTI5IiwiaXRlbTMyIiwibWFyZ2luIiwiYWxsUmVwbyIsImlzU3VwZXJNYXJnaW4iLCJpdGVtMzMiLCJpdGVtMzgiLCJpdGVtMTMyIiwicGFydFJlcG8iLCJpdGVtMTMzIiwiYmFzZUN1cnJlbmN5IiwiaXRlbTEzNCIsIml0ZW0xMDIiLCJlYXJuRml4ZWQiLCJpdGVtMTA0IiwiaXRlbTEwNSIsIml0ZW0xMDYiLCJlYXJuSGlnaCIsIml0ZW0xMDciLCJpdGVtMTA4IiwidG90YWxZZWFyUmF0ZSIsIml0ZW01MSIsImNvcHlfdHJhZGluZyIsIml0ZW01MiIsIml0ZW01NCIsImZpbmFuY2lhbEp1bXBVcmwiLCJ1cmwiLCJlYXJuSnVtcFVybCIsIml0ZW0xMzgiLCJlYXJuTm9kZVBsZWRnZSIsInN1YnNjcmlwdGlvblVybCIsIml0ZW0xMzkiLCJiYXNlSW5mbyIsImp1bXBVcmwiLCJpdGVtMTQxIiwiY29udHJhY3RKdW1wVXJsIiwib3BlblJvdXRlciIsIml0ZW0xNTUiLCJlYXJuU2hhcmtGaW4iLCJwcm9kdWN0U3RhdHVzIiwieWVhclJhdGUiLCJ0b3RhbFllYXJSYXRlVHJhbnNsYXRlIiwidHJhbnNsYXRlTWluWWVhclJhdGUiLCJ0cmFuc2xhdGVNYXhZZWFyUmF0ZSIsInByb2plY3ROYW1lIiwiaXRlbTE1NiIsIml0ZW0xNTciLCJpdGVtMjAzIiwidHJhZGluZ0JvdFVybCIsIml0ZW0yMDQiLCJjb250cmFjdEdyaWQiLCJzeW1ib2wyMDQiLCJ0b1VwcGVyQ2FzZSIsIml0ZW0yMDUiLCJpdGVtMjA2Iiwic3RvcFBvcFNob3ciLCJpdGVtMjA3IiwiaXRlbTIwOCIsImRldGFpbFVybCIsImUiLCJlcnJvciIsImxlbmd0aCIsImFuYWx5dGljcyIsInByb2ZpdFJlZCIsInVybFBhdGgiLCJpbmRleE9mIiwiZXZlbnQiLCJwcm9wZXJ0aWVzSnNvbiIsIm1hcCIsIm9wZW5Sb3V0ZSIsInNldFRpbWVvdXQiLCJjdXJyZW5jeUNoYW5nZSIsImdldFRvdGFsQXNzZXRDdXJyZW5jeSIsInRoZW4iLCJ1cGRhdGVQYWdlRGF0YUJ5VHlwZSIsIlRBRyIsIkhJRERFTl9TVFIiLCJERUZBVUxUX1NUUiIsIkRpc3RyaWJ1dGlvblR5cGUiLCJTeW1ib2xzIiwiREVGQVVMVF9DQUNIRSIsImNvbGxhdGVyYWwiLCJiYWxhbmNlQXNzZXRQYXRoIiwic2VsbExpc3RQYXRoIiwic3BvdEFjY291bnRJbmZvUGF0aCIsInNwb3RCb3RJbmZvUGF0aCIsInNwb3RDb2xsYXRlcmFsSW5mb1BhdGgiLCJjb250cmFjdENvaW5QZXJwZXR1YWxQYXRoIiwiY29udHJhY3RDb2luRnV0dXJlc1BhdGgiLCJjb250cmFjdFVzZHRNUGF0aCIsImNvbnRyYWN0Q29weVRyYWRpbmdQYXRoIiwiY29udHJhY3RVc2R0TVVuaXR5UGF0aCIsImJhbGFuY2VGaW5hbmNpYWxCYW5uZXJQYXRoIiwiYmFsYW5jZURlcG9zaXRSZWNvbW1lbmRQYXRoIiwiYmFsYW5jZVJvY2tldFBhdGgiLCJpbmRleFBpcmNlUGF0aCIsImZhbGxDb2luUGF0aCIsImNvbnRyYWN0R3JpZEluZm9QYXRoIiwiY29udHJhY3RHcmlkU3RvcFBhdGgiLCJkZXBvc2l0V2l0aGRyYXdQYXRoIiwiZ2VuUmVxdWVzdFBhcmFtcyIsInBhdGgiLCJtZXRob2QiLCJob3N0VHlwZSIsImhlYWRlciIsImdldEVycm9ySW5mbyIsImNvZGUiLCJzdWNjZWVkIiwibXNnTGlzdCIsInByb2ZpdFByZWZpeCIsInByb2ZpdCIsImxlZ2FsU3RyaW5nIiwic3RyIiwiZGVmYXVsdFN0ciIsImdldFJlc3BvbnNlUGFyYW1zIiwiZ2V0QmFsYW5jZUFzc2V0IiwidmVyc2lvbiIsInVuaW9uVHlwZSIsInJlc3BvbnNlU3RyaW5nIiwicmVxdWVzdCIsInJlc3BvbnNlIiwiZXJyb3JJbmZvIiwibWVzc2FnZUxpc3QiLCJ0b3RhbFRpcHNFcnJvciIsImlzTWFpbnRhaW4iLCJ0b3RhbEVycm9yIiwidXBkYXRlVG90YWxBc3NldERhdGEiLCJ1cGRhdGVBY2NvdW50TGlzdCIsIm9wZW5UZXh0VmlzaWJsZSIsImVhcm5TdGF0dXMiLCJzcG90Um9ib3RKdW1wVXJsIiwib3BlblRleHQiLCIkaTE4biIsIm5fYXNzZXRfY2FzaF90b195eWJfbm93Iiwib3BlblRleHRDb2xvciIsIm5fYXNzZXRfY2FzaF90b195eWJfcGFydCIsIm5fYXNzZXRfY2FzaF90b195eWJfYWxsIiwiZWFybkF1dG9Db25maWdUaXAiLCJjb250cmFjdEF1dG9FYXJuVmlzIiwiY29udHJhY3RFYXJuU3RhdHVzIiwidW5kZWZpbmVkIiwiY29udHJhY3RBdXRvRWFyblRleHQiLCJjb250cmFjdEF1dG9FYXJuQ29sb3IiLCJuX3NoYXJrX2Zpbl9hdXRvU3Vic2NyaWJlX29wZW4iLCJjb250cmFjdEVhcm5SYXRlIiwiY29udHJhY3RBdXRvRWFybiIsIm5fYXNzZXRfY29udHJhY3RfYXV0b19lYXJuIiwicmVwbGFjZSIsInN1YkFjY291bnRCYWxhbmNlTGlzdCIsImRpc3RyaWJ1dGlvblR5cGUiLCJ1cGRhdGVTcG90QmFzZUluZm9EYXRhIiwidXBkYXRlQm90QmFzZUluZm9EYXRhIiwidXBkYXRlU3BvdENvbGxhdGVyYWxCYXNlSW5mb0RhdGEiLCJ1c2R0TSIsInVwZGF0ZUxpbmVhclN3YXBCYXNlSW5mb0RhdGEiLCJjb2luUCIsInVwZGF0ZUNvaW5QQmFzZUluZm9EYXRhIiwiY29pbkZ1dHVyZXMiLCJ1cGRhdGVDb2luTUJhc2VJbmZvRGF0YSIsImNvbnRyYWN0Q29weSIsInVwZGF0ZUNvcHlUcmFkaW5nQmFzZUluZm8iLCJ1cGRhdGVPdGNCYXNlSW5mbyIsInVwZGF0ZU1hcmdpbkFsbEluZm8iLCJ1cGRhdGVNYXJnaW5QYXJ0QmFzZUluZm8iLCJ1cGRhdGVFYXJuWWJiQmFzZUluZm8iLCJ1cGRhdGVFYXJuRml4ZWRCYXNlSW5mbyIsInVwZGF0ZUVhcm5IaWdoQmFzZUluZm8iLCJ1cGRhdGVFYXJuTm9kZVBsZWRnZUJhc2VJbmZvIiwidXBkYXRlRWFyblNoYXJrRmluQmFzZUluZm8iLCJ1cGRhdGVPcHRpb25CYXNlSW5mbyIsInVwZGF0ZUNvbnRyYWN0R3JpZEJhc2VJbmZvIiwiZ2V0Um9ja2V0QW1vdW50IiwibWVzc2FnZSIsInJvY2tldEFtb3VudCIsImhiVG9hc3QiLCJyb2NrZXRJbmZvTGlzdCIsInRvU3RyaW5nIiwicm9ja2V0SW5mb1RhcEFjdGlvbiIsImVhcm5ZYmJSaXNrSWNvblNob3ciLCJlYXJuWWJiSGVhZGVyQm90dG9tVGV4dCIsImVhcm5ZYmJUb3RhbEFzc2V0IiwiZWFyblliYlRvZGF5UGxOdW1iZXIiLCJlYXJuWWJiVG9kYXlQbE51bWJlckNvbG9yIiwiZ2V0Q29sb3IiLCJnZXRDdXJyZW5jeSIsImxlZ2FsQ3VycmVuY3lTeW1ib2wiLCJnZXRMZWdhbEN1cnJlbmN5U3ltYm9sIiwiZXF1YWxBbW91bnQiLCJnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRIYW5kbGVOdWxsIiwidXNkdCIsImFkZEN1cnJlbmN5U3ltYm9sVG90YWxBc3NldCIsImZvcm1hdE51bSIsInRvZGF5UHJvZml0IiwicHJvZml0SW5jb21lIiwidG9kYXlQcm9maXRXaXRoU3ltYm9sIiwiYWRkQ3VycmVuY3lTeW1ib2wiLCJyaXNlQ29sb3IiLCJhc3NldE5ld0Vhcm5HdWlkZSIsImFzc2V0TmV3RWFybkd1aWRlSGlkZSIsImFzc2V0U3BvdEF1dG9FYXJuT3Blbkd1aWRlIiwic3BvdE9wZW5HdWlkZVNob3ciLCJzcG90T3Blbkd1aWRldmlzaWJpbGl0eSIsImd1aWRlU2hvd0RhdGUiLCJub3dEYXRlIiwiRGF0ZSIsIm5vdyIsImFzc2V0U3BvdE9wZW5HdWlkZUhpZGUiLCJhbW91bnQiLCJwYXJhbVN0cmluZyIsImZpeFJhdGVIYW5kbGVOdWxsIiwiZml4TnVtYmVyIiwiTnVtYmVyIiwicGFyc2VGbG9hdCIsImZpeFJhdGUiLCJmaXhSYXRlRml4ZWQiLCJmaXhlZCIsImVhcm5IZWFkZXJCb3R0b21UZXh0IiwiZWFyblJpc2tJY29uU2hvdyIsImVhcm5Ub3RhbEFzc2V0IiwiZWFyblRvZGF5UGxOdW1iZXIiLCJlYXJuVG9kYXlQbE51bWJlckNvbG9yIiwiZWFybkhpZ2hUb3RhbEFzc2V0IiwiZWFybkhpZ2hUb2RheVBsTnVtYmVyIiwiZWFybkhpZ2hUb2RheVBsTnVtYmVyQ29sb3IiLCJlYXJuTm9kZVBsZWRnZVRvdGFsQXNzZXQiLCJlYXJuTm9kZVBsZWRnZVRvZGF5UGxOdW1iZXIiLCJlYXJuTm9kZVBsZWRnZVRvZGF5UGxOdW1iZXJDb2xvciIsImVhcm5TaGFya0ZpblRvdGFsQXNzZXQiLCJlYXJuU2hhcmtGaW5Ub2RheVBsTnVtYmVyIiwiY3VycmVuY3lTeW1ib2wiLCJvcHRpb25zSGVhZGVyVGl0bGUiLCJvcHRpb25zVG90YWxBc3NldCIsInRvdGFsTGVnYWwiLCJnZXRFbnRyeVNob3ciLCJkZXNwb3NpdFNob3ciLCJpc0NsZWFyUmFuZ2UiLCJjbG91ZFdhbGxldFNob3ciLCJnZXRTcG90QWNjb3VudEluZm8iLCJleGNoYW5nZUxpc3RFcnJvciIsInNwb3RBY2NvdW50SW5mb0xpc3QiLCJjdXJyZW5jaWVzIiwiY3VycmVuY3lJbmZvTGlzdCIsInVwZGF0ZVNwb3RDdXJyZW5jaWVzRGF0YSIsImdldFNwb3RCb3RJbmZvIiwiZnJvbSIsImRpcmVjdCIsImxpbWl0IiwiYm90TGlzdEVycm9yIiwic3RyYXRlZ3lMaXN0IiwidXBkYXRlQm90Q3VycmVuY2llc0RhdGEiLCJnZXRTcG90Q29sbGF0ZXJhbEluZm8iLCJjb2xsYXRlcmFsRGF0YUVycm9yIiwibG9hbmluZ0xpc3QiLCJwbGVkZ2VMaXN0IiwidXBkYXRlU3BvdENvbGxhdGVyYWxDdXJyZW5jeURhdGEiLCJsb2FuZWQiLCJsb2FuaW5nVVNEVCIsInBsZWRnaW5nVVNEVCIsIm5ld1VybEVuYWJsZSIsImluZGV4SnVtcFVybCIsIm9yZGVySnVtcFVybCIsImhhbmRsZXJDb2xsYXRlcmFsVXJsIiwiZ29Ub0NvbGxhdGVyYWwiLCJnb1RvQ29sbGF0ZXJhbEhpc3RvcnkiLCJnZXRDb250cmFjdFVzZHRNIiwidXNkdE1BbGxBc3NldExpc3RFcnJvciIsInVzZHRNT3duQXNzZXRMaXN0RXJyb3IiLCJsaXN0IiwiYXNzZXRDdXJyZW5jeUxpc3QiLCJob2xkQ3VycmVuY3lMaXN0IiwidXBkYXRlQ29udHJhY3RBbGxEYXRhIiwidXBkYXRlQ29udHJhY3RPd25lZERhdGEiLCJnZXRDb3B5VHJhZGluZ0RhdGEiLCJhY2NvdW50VHlwZSIsImNvcHlUcmFkaW5nTGlzdEVycm9yIiwiYWNjb3VudFN5bWJvbExpc3QiLCJ1cGRhdGVDb3B5VHJhZGluZ0xpc3QiLCJvbGRMaXN0Iiwic2VhcmNoS2V5IiwiaGlkZGVuU21hbGxBc3NldCIsIlByb21pc2UiLCJpdGVtU2hvdWxkU2hvdyIsIndpdGhkcmF3QXZhaWxhYmxlIiwicHVzaCIsInNvcnREYXRhIiwic29ydExpc3QiLCJnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRGb3JDb3B5VHJhZGluZyIsInN5bWJvbEljb24iLCJnZXRJY29uVXJsIiwic3ltYm9sTmFtZSIsImdldFByZUN1cnJlbmN5QW1vdW50IiwiYWRkQ3VycmVudEN1cnJlbmN5U3ltYm9sIiwiZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50IiwiYWNjb3VudFRvdGFsRXF1aXR5IiwiY29weVRyYWRpbmdMaXN0IiwiZ2V0Q29udHJhY3RVc2R0TVVuaXR5IiwidXBkYXRlQ29udHJhY3RVc2R0TVVuaXR5RGF0YSIsImdldENvbnRyYWN0Q29pbkZ1dHVyZXMiLCJjb2luTUFsbEFzc2V0TGlzdEVycm9yIiwiY29pbk1Pd25Bc3NldExpc3RFcnJvciIsImdldENvbnRyYWN0Q29pblBlcnBldHVhbCIsImNvaW5QQWxsQXNzZXRMaXN0RXJyb3IiLCJjb2luUE93bkFzc2V0TGlzdEVycm9yIiwiZ2V0RGVwb3NpdEJhbm5lckluZm8iLCJhc3NldExldmVsMiIsImFzc2V0TGV2ZWwiLCJpc0FuYWx5c2lzIiwiaXNPcGVuQW5hbHlzaXMiLCJhbmFseXNpcyIsInNob3dSZWNvbW1lbmQiLCJzaGFyZVZpc2liaWxpdHkiLCJyZXN0cmljdGlvblZpcyIsImlzQWxsb3ciLCJleGNoYW5nZVVTRERWaXMiLCJiYW5uZXJEYXRhIiwiY291cG9uIiwiYXNzZXRSb2NrZXRGaW5pc2hlZCIsImJhbm5lckluZm9zIiwiYXNzZXRCYW5uZXJJbmZvRmluaXNoZWQiLCJiYW5uZXJJbmZvIiwibGVmdEluZm8iLCJ0aXRsZSIsInByb2plY3RUcmFuc2xhdGVOYW1lIiwiZGVzYyIsImFweVRyYW5zbGF0ZSIsInJpZ2h0SW5mbyIsInllYXJEaXNwbGF5UmF0ZSIsImJhbm5lckRhdGFOdWxsIiwiY29uY2F0IiwiYXNzZXRUb3RhbCIsImFzc2V0VG9hZHlQcm9maXQiLCJhc3NldFRvYWR5UHJvZml0UmF0ZSIsImFzc2V0VG90YWxQcm9maXQiLCJ0b3RhbEFzc2V0IiwidG9kYXlQbE51bWJlciIsInRvdGFsQmFsYW5jZURhdGEiLCJjdXJyZW5jeU51bSIsInRvdGFsQmFsYW5jZVVzZHQiLCJsZWdhbEN1cnJlbmN5VG90YWwiLCJhc3NldFRvYWR5UHJvZml0Q29sb3IiLCJ0b3RhbEFjY3VtdWxhdGVQcm9maXRVc2R0IiwibGFuZyIsInByb2ZpdEFjY291bnRCYWxhbmNlTGlzdCIsImFjY291bnRCYWxhbmNlTGlzdCIsImJvdFRvdGFsQXNzZXQiLCJib3RUb2RheVBsTnVtYmVyIiwiYm90VG9kYXlQbE51bWJlckNvbG9yIiwic3BvdFJpc2tMZXZlbCIsInRleHQiLCJyaXNrVGV4dCIsInJpc2tJY29uU2hvdyIsInJpc2tUZXh0Q29sb3IiLCJyaXNrQmFja2dyb3VuZCIsInNwb3RSaXNrUmF0ZSIsInJpc2tJY29uIiwidG9kYXlQbE51bWJlckNvbG9yIiwic3BvdEN1cnJlbmN5RGF0YSIsInNvcnRCb3RMaXN0IiwiY29zdCIsImludmVzdEFtb3VudCIsImVxdWFsVG9kYXlQcm9maXQiLCJjb252ZXJ0TGVnYWxUZW5kZXIiLCJ0b3RhbFByb2ZpdCIsIm9yaWdpblNwb3RZaWVsZCIsInNwb3RZaWVsZCIsIm9yaWdpblNwb3RSYXRlIiwic3BvdFlpZWxkUmF0ZSIsInNwb3RSaXNlQ29sb3IiLCJzcG90TG9hbiIsInJ1blR5cGVUcmFuc2xhdGVOYW1lIiwiYm90TGlzdCIsImN1cnJlbnRTcG90TGlzdCIsImN1cnJlbnRTcG90RXhwYW5kQ3VycmVuY3kiLCJpbmRleFByaWNlTWFwIiwiZm9yY2VSZWZyZXNoRmxhZyIsInN0YXJ0VGltZSIsImxhc3RTZWFyY2hLZXkiLCJpbmRleFByaWNlIiwiZWRnZUVuZ2luZURhdGFQYWNrYWdlIiwic3BvdExpc3QiLCJzb3J0VHlwZSIsInNvcnRTZXF1ZW5jZSIsIm9yaWdpbkNvbnZlcnRKc29uIiwicGFyYW1ldGVyIiwib3JpZ2luQ29udmVydExpc3QiLCJzcG90TGlzdE5ldyIsImRpc3BsYXlOYW1lIiwiaXNMb2FuIiwic3BvdE51bWJlckVxdWl2YWxlbnQiLCJzcG90TnVtYmVyIiwicG9zaXRpb25OdW1EaXNwbGF5TmFtZU5ldyIsInNwb3RFeEF2YWlsYWJsZSIsInNwb3RFeERlYnRzIiwic3BvdEV4UHJpY2UiLCJhdmdQb3NpdGlvbkNvc3QiLCJhdmdQb3NpdGlvbkNvc3RQYXJhbSIsInNwb3RFeFRvcENlbnRlclRpdGxlIiwibl9hc3NldF9wcmljZSIsIm5fYXNzZXRfcHJpY2VfY29zdF9wcmljZSIsImF2Z1Bvc2l0aW9uQ29zdFNob3ciLCJzcG90RXhDb3N0Iiwib3JpZ2luU3BvdEV4WWllbGQiLCJvcmlnaW5TcG90RXhZaWVsZFBhcmFtIiwic3BvdEV4WWllbGQiLCJvcmlnaW5TcG90RXhZaWVsZFJhdGUiLCJzcG90RXhZaWVsZFJhdGUiLCJyaXNlQ29sb3JWMiIsInNwb3RFeFJpc2VDb2xvciIsImlzVXBkYXRlZEN1cnJlbmN5IiwiaXNOZWVkVXBDdXJyZW5jeSIsInplcm9TdGF0ZSIsInNob3dTcG90TWFya2V0Iiwic2hvd1Nwb3RUcmFkZSIsInNob3dTcG90RWFybiIsInNob3dTcG90RGV0YWlsIiwic2hvd1Nwb3RTaGFyZSIsInNob3dTcG90VXBEZXRhaWwiLCJzaG93U3BvdFVwZGF0ZSIsImlzRmluYW5jaWFsIiwic2hvd1Nwb3RVcGRhdGVCdXR0b24iLCJzaG93U3BvdFJpc2UiLCJzcG90VHJhZGVTcmMiLCJzcG90VHJhZGVUaXRsZSIsIm5fbmV3X3VzZXJfZ3VpZGVfdHJhZGUiLCJuX2Fzc2V0X3Nwb3RfZXhjaGFuZ2VfVVNERCIsIm5fYXNzZXRfc3BvdF9leGNoYW5nZV9VU0RUIiwiZXhjaGFuZ2VMaXN0IiwiZmllbGQiLCJkZWZhdWx0VmFsdWUiLCJjb2xsYXRlcmFsVG90YWxBc3NldCIsImxlZ2FsQXNzZXQiLCJoZWFkZXJCb3R0b21TaG93Iiwib2xkTG9haW5nTGlzdCIsIm9sZFBsZWRnZUxpc3QiLCJyZXN1bHQiLCJzaG91bGRSZXR1cm4iLCJ1c2R0QW1vdW50IiwibmV3TG9hbmluZ0xpc3QiLCJnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRGb3JDb2xsYXRlcmFsIiwiY3VycmVuY3lJY29uIiwidmFsdWUiLCJsb2FuZWRMaXN0IiwibmV3UGxlZGdlTGlzdCIsImNvbGxhdGVyYWxMaXN0IiwiY29sbGF0ZXJhbERhdGEiLCJsaW5lYXJIZWFkZXJUb3RhbEFzc2V0IiwibGluZWFySGVhZGVySW5jb21lIiwibGluZWFySGVhZGVySW5jb21lQ29sb3IiLCJjb2luTUhlYWRlclRvdGFsQXNzZXQiLCJjb2luTUhlYWRlckluY29tZSIsImNvaW5NSGVhZGVySW5jb21lQ29sb3IiLCJjb2luUEhlYWRlclRvdGFsQXNzZXQiLCJjb2luUEhlYWRlckluY29tZSIsImNvaW5QSGVhZGVySW5jb21lQ29sb3IiLCJmaWF0SGVhZGVyVGl0bGUiLCJvdGNUb3RhbEFzc2V0IiwiY29weVRyYWRpbmdUb3RhbCIsImNvcHlUcmFkaW5nSGVhZGVySW5jb21lIiwiY29weVRyYWRpbmdIZWFkZXJJbmNvbWVDb2xvciIsIm1hcmdpbkFsbEhlYWRlclRpdGxlIiwibWFyZ2luQWxsVG90YWxBc3NldCIsIm1hcmdpbkFsbEFjY291bnRUeXBlIiwibWFyZ2luQWxsUmlza1JhdGUiLCJyaXNrUmF0ZSIsIm1hcmdpbkFsbFJhdGUiLCJoYW5kbGVyQXNzZXRSaXNrUmF0ZSIsIm1hcmdpbkFsbFJhdGVDb2xvciIsImdldFJpc2tTdGF0ZUNvbG9yIiwicmlza1N0YXRlIiwiTWF0aCIsImNlaWwiLCJtYXJnaW5QYXJ0SGVhZGVyVGl0bGUiLCJtYXJnaW5QYXJ0VG90YWxBc3NldCIsIm5ld0RhdGEiLCJtYXJnaW5Dcm9zcyIsInVzZHRMaXN0IiwidXNkdE1TZWFjaEtleSIsInVzZHRNSGlkZGVuU21hbGxBc3NldCIsInNlY29uZFN5bWJvbE5hbWUiLCJtYXJnaW5CYWxhbmNlIiwic29ydGVkIiwiZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50Rm9yQ29udHJhY3RBbGxVc2R0TSIsImFzc2V0TGlzdCIsImN1cnJlbmN5U2NhbGUiLCJlcXVpdHlBbW91bnQiLCJmb3JtYXROdW1XaXRoUHJlY2lzaW9uIiwiZXF1aXR5TnVtIiwibWFyZ2luQXZhaWxhYmxlIiwicHJvZml0VW5yZWFsQW1vdW50IiwicHJvZml0VW5yZWFsIiwic3RhcnRzV2l0aCIsInByb2ZpdFVucmVhbFJpc2VDb2xvciIsInZvdWNoZXJBdmFpbGFibGUiLCJ2b3VjaGVyVmlzIiwidm91Y2hlciIsInZvdWNoZXJBbW91bnQiLCJ1c2R0TUFsbEFzc2V0TGlzdCIsImNvaW5QU2VhcmNoS2V5IiwiY29pblBIaWRkZW5TbWFsbEFzc2V0IiwiZ2V0RXF1YWxMZWdhbEN1cnJlbmN5QW1vdW50Rm9yQ29udHJhY3RBbGwiLCJzZWNvbmRTeW1ib2wiLCJnZXRDb250cmFjdFNlY29uZFN5bWJvbCIsIm5ld1Jpc2tSYXRlIiwiYXZhaWxhYmxlQW1vdW50IiwiZXF1YWxMZWdhbEFtb3VudCIsImNvaW5QQWxsQXNzZXRMaXN0IiwiY29pbk1BbGxBc3NldExpc3QiLCJnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRGb3JDb250cmFjdE93bmVkIiwiZ3JlZW5SaXNlIiwidXBzQW5kRG93bnNDb2xvciIsImxvbmdPclNob3J0Q29sb3IiLCJsb25nT3JTaG9ydEJhY2tHcm91bmRDb2xvciIsImJ1eU9yU2VsbEJhY2tHcm91bmRDb2xvciIsImxvbmdPclNob3J0IiwiYnV5T3JTZWxsIiwiaXNDaGluZXNlIiwibl9hc3NldF9mdXR1cmVfYnV5Iiwibl9hc3NldF9mdXR1cmVfc2VsbCIsImlzb2xhdGVkIiwibl9jb250cmFjdF9zdXBlcl9tYXJnaW4iLCJuX2NvbnRyYWN0X3RyYWRlX21hcmdpbiIsImlzb2xhdGVkTnVtYmVyIiwiaXNvbGF0ZWROYW1lIiwiY29udHJhY3RUeXBlIiwibl9tYXJrZXRfY29udHJhY3Rfc3dhcF90cmFkZV9uYW1lX2FiYnIiLCJuX21hcmtldF9jb250cmFjdF9zeW1ib2xfdGhpc3dlZWtfYWJiciIsIm5fbWFya2V0X2NvbnRyYWN0X3N5bWJvbF9uZXh0d2Vla19hYmJyIiwibl9tYXJrZXRfY29udHJhY3Rfc3ltYm9sX3F1YXJ0ZXJfYWJiciIsInN5bWJvbE5hbWVGdWxsIiwib3BlbkFkbCIsImFkbFJpc2tTcmMiLCJhZGxSaXNrUGVyY2VudCIsInByZWZpeCIsInJhd1Byb2ZpdCIsInJlbW92ZVRyYWlsaW5nWmVyb2VzIiwiaXNSaXNrIiwic3VmZml4IiwiY3VycmVuY3lTdWZmaXgiLCJjb250cmFjdFRpdGxlMV8xIiwibl9vcHRpb25fbWFya2V0X2xpc3Rfc2V0dGluZ19wb3NpdGlvbl92b2x1bWUiLCJjb250cmFjdFRpdGxlMl8xIiwiZ2V0Q29udHJhY3ROdW1iZXIiLCJ2b2x1bWUiLCJjb250cmFjdFRpdGxlM18xIiwibl9jb250YXJjdF9wb3NpdGlvbl9jb3N0X29wZW5fbGFiZWwyIiwiY29udHJhY3RUaXRsZTRfMSIsImNvbnRyYWN0VGl0bGUxXzIiLCJnZXRXb3JkRm9ybWF0IiwiY29udHJhY3RUaXRsZTJfMiIsInBvc2l0aW9uTWFyZ2luIiwiY29udHJhY3RUaXRsZTNfMiIsIm5fY29udHJhY3RfbGFzdF9wcmljZSIsImNvbnRyYWN0VGl0bGU0XzIiLCJjb250cmFjdFRpdGxlMV8zIiwibl9hc3NldF9tYXJnaW5fcmF0ZSIsImNvbnRyYWN0VGl0bGUyXzMiLCJjb250cmFjdFRpdGxlM18zIiwibl9iYWxhbmNlX2NvbnRyYWN0X3ByZWRpY3Rpb25fb2Zfc3Ryb25nX3Bhcml0eSIsImNvbnRyYWN0VGl0bGU0XzMiLCJsaXF1aWRhdGlvblByaWNlIiwidXNkdE1Pd25Bc3NldExpc3QiLCJjb2luUE93bkFzc2V0TGlzdCIsImNvaW5NT3duQXNzZXRMaXN0IiwidXBkYXRlT3RjRGF0YSIsImdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudEZvck90YyIsImZhaXRGcmVlemUiLCJmYWl0QXZhaWxhYmxlIiwiZmFpdFZhbHVlIiwib3RjTGlzdCIsInVwZGF0ZU9wdGlvbkRhdGEiLCJnZXRFcXVhbExlZ2FsQ3VycmVuY3lBbW91bnRGb3JPcHRpb24iLCJvcHRpb25MaXN0IiwidXBkYXRlRWFybkhpZ2hEYXRhIiwiY29uc3RydWN0b3IiLCJBcnJheSIsIm1pbmluZ0Ftb3VudCIsImdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudEZvckVhcm4iLCJ5ZXN0ZXJkYXlJbmNvbWVBbW91bnQiLCJ2aXNpYmxlIiwibGFzdFBvc2l0aW9uIiwiZWFybkhpZ2hMaXN0IiwicG9zaXRpb25BbW91bnQiLCJwb3NpdGlvbkJhbGFuY2UiLCJzcG90WWVzdGVyZGF5WWllbGQiLCJzcG90WWVzdGVyZGF5TnVtYmVyIiwieWVzdGVyZGF5SW5jb21lIiwic3BvdEV4WWVhclJhdGUiLCJ0ZXJtVHJhbnNsYXRlIiwic3BvdFN1YnNjcmlwdGlvbk51bWJlciIsInN1YnNjcmlwdGlvbkJhbGFuY2UiLCJhbW91bnRSaXNlQ29sb3IiLCJ1cGRhdGVFYXJuTm9kZVBsZWRnZURhdGEiLCJlYXJuQW1vdW50IiwidG90YWxJbmNvbWVBbW91bnQiLCJub2RlUGxlZGdlTGFzdFBvc2l0aW9uIiwiZWFybk5vZGVQbGVkZ2VMaXN0IiwidG90YWxFYXJuQW5kUXVhbnRpdHkiLCJnZXRUb3RhbEVhcm5BbmRRdWFudGl0eSIsInRvdGFsSW5jb21lQmFsYW5jZSIsImVhcm5BbmRRdWFudGl0eUNvbG9yIiwidXBkYXRlRWFyblNoYXJrRmluRGF0YSIsInNoYXJrRmluTGFzdFBvc2l0aW9uIiwidHJhbnNsYXRlRWFyblJhdGUiLCJpbmNvbWVUaW1lIiwicHJvZHVjdFRyYW5zbGF0ZVN0YXR1cyIsImVhcm5TaGFya0Zpbkxpc3QiLCJ1cGRhdGVFYXJuRGF0YSIsInliYlNlYXJjaEtleSIsInliYkhpZGRlblNtYWxsQXNzZXQiLCJzcG90RXhZaWVsZFN0ciIsImVhcm5FeE51bWJlciIsImNvbmZpcm1lZEZpeGVkVG90YWxJbnRlcmVzdCIsInliYkV4WWllbGQiLCJmaXhlZEV4WWllbGQiLCJwcm9JbmNvbWVBbW91bnQiLCJ5YmJFeFlpZWxkUmF0ZSIsImZpeGVkRXhZaWVsZFJhdGUiLCJ5YmJTcG90WWllbGQiLCJ5YmJTcG90WWllbGRSYXRlIiwiZml4ZWRTcG90WWllbGQiLCJlc3RGaXhlZFRvZGF5SW50ZXJlc3QiLCJmaXhlZFNwb3RZaWVsZFJhdGUiLCJ5YmJTcG90WWllbGRPcGVyYXRvciIsInliYlNwb3RZaWVsZFJhdGVPcGVyYXRvciIsImZpeGVkU3BvdFlpZWxkT3BlcmF0b3IiLCJmaXhlZFNwb3RZaWVsZFJhdGVPcGVyYXRvciIsInliYlNwb3RZaWVsZFJhdGVDb2xvciIsImZpeGVkU3BvdFlpZWxkUmF0ZUNvbG9yIiwieWJiRXhSaXNlQ29sb3IiLCJ5YmJGaXhlZEV4UmlzZUNvbG9yIiwibGFiZWwiLCJvcmRlclNob3dMYWJlbFR5cGUiLCJzaG93VklQIiwidGFnIiwidmlwSWNvbiIsInRvdGFsQW1vdW50IiwidGVybSIsImxvYW5MYWJlbCIsImFtb3VudEV4UmlzZUNvbG9yIiwiZWFyblliYkxpc3QiLCJlYXJuRml4ZWRMaXN0IiwidXBkYXRlTWFyZ2luQWxsRGF0YSIsImdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudEZvck1hcmdpbkFsbCIsImVzdGltYXRpb24iLCJmcmVlemUiLCJib3Jyb3dlZCIsImxvbmdMZXZlbERhdGFMaXN0IiwidXBkYXRlTWFyZ2luUGFydERhdGEiLCJiYXNlQXZhIiwiYmFzZUVzdGltYXRpb24iLCJxdW90ZUF2YSIsInF1b3RlRXN0aW1hdGlvbiIsIm1hcmdpbkVxdWl2YWxlbnQiLCJnZXRGdWxsTnVtIiwibWFyZ2luRXF1aXZhbGVudEZpeGVkIiwidG9GaXhlZCIsInF1b3RlQ3VycmVuY3lEaXNwbGF5TmFtZSIsImdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudEZvck1hcmdpblBhcnQiLCJiYXNlU3ltYm9sTmFtZSIsImJhc2VDdXJyZW5jeURpc3BsYXlOYW1lIiwicXVvdGVTeW1ib2xOYW1lIiwicmlza1JhdGVTdGF0ZVRleHQiLCJyaXNrUmF0ZVN0YXRlQ29sb3IiLCJyaXNrVGV4dEJnIiwicmlza1JhdGVTdGF0ZUJnIiwibWFyZ2luUHJpY2UiLCJiYXNlQXZhaWxhYmxlIiwiYmFzZUJvcnJvd2VkIiwiYmFzZUJvcnJvd2VkQW5kRnJlZXplIiwiY2hhc2VTeW1ib2xOYW1lIiwiY2hhc2VBdmFpbGFibGUiLCJxdW90ZUF2YWlsYWJsZSIsImNoYXNlQm9ycm93ZWQiLCJxdW90ZUJvcnJvd2VkQW5kRnJlZXplIiwic2hvcnRMZXZlbERhdGFMaXN0IiwiYXNzZXRUaGlyZFR5cGVFdmVudCIsImlzQWxsIiwidXBkYXRlUGFnZUxpc3RCeVR5cGUiLCJhc3NldFRhYkV2ZW50IiwiYWNjb3VudCIsInJlZnJlc2giLCJ1cGRhdGVUeXBlIiwidXBkYXRlUGFnZUxpc3RIZWFkZXJCeVR5cGUiLCJnZXRPVENEYXRhIiwiZ2V0T3B0aW9uRGF0YSIsImdldEVhcm5EYXRhIiwiZ2V0TWFyZ2luQWxsIiwiZ2V0TWFyZ2luUGFydCIsImdldENvbnRyYWN0R3JpZERhdGEiLCJzb3J0RXZlbnQiLCJhcmdzIiwic29ydEJvdEV2ZW50Iiwic29ydFNwb3RMaXN0IiwiemVyb0N1cnJlbmNpZXMiLCJub3RaZXJvQ3VycmVuY2llcyIsImZpbHRlciIsIm5vbmVDdXJyZW5jaWVzIiwic29ydEtleSIsInNvcnQiLCJhIiwiYiIsImdldEVxdWFsTGVnYWxDdXJyZW5jeUFtb3VudEZ1bmN0aW9uIiwic29ydFByb2ZpdCIsInNvcnRBdmEiLCJvcGVuVmlzaWJpbGl0eSIsImNsb3NlVmlzaWJpbGl0eSIsInVzZHRWaXMiLCJoaWRlRGVwb3NpdFdpdGhkcmF3IiwidXBkYXRlQ29udHJhY3RHcmlkRGF0YSIsImljb25VcmwiLCJ3b3JkS2V5Iiwid29yZCIsIm51bWJlciIsInByZWNpc2lvbiIsIm51bSIsImdldEJUQ0Ftb3VudCIsImNvbG9yS2V5IiwiaXNTaG93QXNzZXQiLCJpc1Nob3ciLCJnZXRVc2R0QW1vdW50IiwicGFyYW0yIiwicGFyYW1TdHJpbmcyIiwic291cmNlIiwic3Vic3RyaW5nIiwiaW5pdERhdGEiLCJsaXN0VGl0bGVMZWZ0IiwibGlzdFRpdGxlQ2VudGVyIiwibGlzdFRpdGxlUmlnaHQiLCJzaG93U2VsZWN0IiwiZXhpc3RPbmVJbmNsdWRlVHdvIiwib25lU3RyIiwidHdvU3RyIiwiaW5jbHVkZXMiLCJzZWFyY2hDb2luRXZlbnQiLCJpbnB1dCIsImJ0Y0N1cnJlbmN5IiwicmVmcmVzaERhdGEiLCJpbml0Q29uZmlnSW5mbyIsImdldERlcG9zaXRXaXRoZHJhdyIsImdldEZhbGxDb2luVGV4dCIsImZhbGxDb2luRGF0YSIsImxlZnRUcmFuc2xhdGVDb250ZW50IiwiZmFsbENvaW5WaXMiLCJmYWxsQ29pblRleHQiLCJyaWdodFRyYW5zbGF0ZUNvbnRlbnQiLCJqdW1wRmFsbENvaW5MaW5rIiwiY2xvc2VGYWxsQ29pbiIsIm9uQXBwZWFyIiwicGFnZUFwcGVhciIsInNob3dQcm9maXRSZWQiLCJvdGNMaXN0RXJyb3IiLCJhY2NvdW50X2lkIiwib3B0aW9uTGlzdEVycm9yIiwiZWFyblliYkxpc3RFcnJvciIsImVhcm5IaWdoTGlzdEVycm9yIiwiZWFybk5vZGVQbGVkZ2VMaXN0RXJyb3IiLCJlYXJuU2hhcmtGaW5MaXN0RXJyb3IiLCJlYXJuRml4ZWRMaXN0RXJyb3IiLCJsb25nTGV2ZWxEYXRhTGlzdEVycm9yIiwic2hvcnRMZXZlbERhdGFMaXN0RXJyb3IiLCJjbGVhckRhdGEiLCJpc05hTiIsInRlc3QiLCJtYXRjaCIsIm9uSXRlbUNsaWNrIiwicG9zaXRpb24iLCJjdXJyZW50SXRlbSIsInN0YXRlIiwiY2xpY2siLCJvbk5vZGVQbGVkZ2VJdGVtQ2xpY2siLCJvblNoYXJrRmluSXRlbUNsaWNrIiwib25SZWxvYWRFYXJuSGlnaENsaWNrIiwib25SZWxvYWRFYXJuTm9kZVBsZWRnZUNsaWNrIiwib25SZWxvYWRFYXJuU2hhcmtGaW5DbGljayIsImdvVG9IYkVhcm5QYWdlIiwiZ29Ub05vZGVQbGVkZ2VQYWdlIiwiZ29Ub1NoYXJrRmluUGFnZSIsImNsaWNrU3BvdEl0ZW0iLCJzcG90RWxlbWVudCIsImN1cnJlbmN5Q29kZSIsInVzZHRQcmljZSIsInNwb3RJbmRleFByaWNlRGF0YSIsImdldFNwb3RFeHBhbmRJbmRleFByaWNlIiwiY29udHJhY3RHcmlkTGlzdEVycm9yIiwiY29udHJhY3RHcmlkTGlzdCIsIm9yaWdpbmxpc3QiLCJjb250cmFjdEdyaWREYXRhIiwibGFzdFBvc2l0aW9uSWQiLCJjb250cmFjdEdyaWRMYXN0UG9zaXRpb24iLCJpbnN0cnVtZW50VHlwZSIsIml0ZW1OYW1lIiwidHJlbmRUeXBlIiwiY29sb3JUeXBlIiwibl9jb250cmFjdF9ncmlkX2J1eSIsIm5fY29udHJhY3RfZ3JpZF9zZWxsIiwibl9jb250cmFjdF9ncmlkX25ldXRyYWwiLCJsZXZlciIsInRvdGFsUHJvZml0QW1vdW50IiwiY29udHJhY3RHcmlkVG90YWxBc3NldCIsImNvbnRyYWN0R3JpZFBsTnVtYmVyIiwiY29udHJhY3RHcmlkUGxOdW1iZXJDb2xvciIsIm9uQ29udHJhY3RHcmlkSXRlbUNsaWNrIiwidGVtcExpc3QiLCJyYXdBcnJheSIsImdvVG9Db250cmFjdEdyaWRQYWdlIiwib25SZWxvYWRDb250cmFjdEdyaWRDbGljayIsInN0b3BQb3BDbG9zZSIsInN0b3BDb25maXJtQ2xpY2siLCJzaG93TG9hZGluZyIsInJlcXVlc3RQYXJhbXMiLCJyZXNwRGF0YSIsIm5fYm90X2RldGFpbF90b2FzdF9zdG9wX3N1Y2Nlc3MiLCJuX2JvdF9kZXRhaWxfdG9hc3Rfc3RvcF9mYWlsIiwidXBkYXRlRGVwb3NpdFdpdGhkcmF3IiwiZGF0YWxpc3QiLCJkd0luZm9MaXN0IiwiY29udGVudCIsInRyYW5zbGF0ZUNvbnRlbnREYXRhIiwiY2VsbFR5cGUiLCJpbmRpY2F0b3JXaWR0aCIsImR3Q3VycmVudEluZGV4IiwiZHdJbmZvU2hvdyIsInNob3dJbmRpY2F0b3IiLCJlbGVtZW50IiwiZHdJbmRleENoYW5nZSIsInNlbGVjdEluZGV4IiwiZHdJdGVtQ2xpY2tlZCIsImV4Y2hhbmdlVVNERENsaWNrZWQiLCJPYmplY3QiLCJhc3NpZ24iLCJnbG9iYWxUaGlzIiwi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
