
const STR_DEFAULT = "--";
let mSymbol = '';
let mCurrentDirection = 0;
let mAccountId = "";
let mOrderPriceType = 1;
let mSingleOrderType = 1;
let mOrderType = "";
let mOrderPrice = "";
let mOrderSize = "";
let mDelegateType = 1;
let mOrderPriceRatio = "";
let mOrderPriceGap = "";
let mSingleOrderSize = "";
let mSingleOrderRatio = "";
let mInterval = "";
let mOrderSide = "";
var oldTime = "";
$data.directionName = STR_DEFAULT;
const ORDER_PATH = "v2/algo-orders";

function preventClick(msc) {
    if (oldTime === '') {
        oldTime = new Date().getTime();
        console.log(`shuhuan preventClick oldTime = ${oldTime}`);
        return true;
    } else {
        var newTime = new Date().getTime();
        console.log(`shuhuan preventClick newTime = ${newTime}`);
        if (newTime - oldTime > msc) {
            oldTime = new Date().getTime();
            console.log(`shuhuan preventClick -- oldTime = ${oldTime}`);
            return true;
        } else {
            console.log(`shuhuan preventClick false`);
            return false;
        }
    }
}

async function confirm() {
    if (preventClick(1000)) {
        console.log(`shuhuan confirm click`);
        makeOrder();
    }
}

async function makeOrder() {
    const param = {
        accountId: mAccountId,
        symbol: mSymbol,
        orderPrice: mOrderPrice,
        orderSide: mOrderSide,
        orderSize: mOrderSize,
        orderType: mOrderType,
        source: mSource,
        delegateType: mDelegateType,
        orderPriceType: mOrderPriceType,
        orderPriceRatio: mOrderPriceRatio,
        orderPriceGap: mOrderPriceGap,
        singleOrderType: mSingleOrderType,
        singleOrderSize: mSingleOrderSize,
        singleOrderRatio: mSingleOrderRatio,
        interval: mInterval
    };
    console.log(`shuhuan makeOrder >>> ${param}`);
    const params = genRequestParams(ORDER_PATH, param, 1, 4, { "Content-Type": "application/json" });
    console.log(`shuhuan makeOrder ${params}`);
    try {
        const responseString = await $nativeAPI.request(params);
        const response = JSON.parse(responseString);
        console.log(`shuhuan makeOrder responseString ${responseString}`);
        const { code, message } = response;
        if (code !== 200) {
            if (!isEmpty(message)) {
                showToast(message);
            }
            console.error(`makeOrder, code=${code}`);
        } else {
            close();
            showToast(mMsgOrderSuccess);
            console.log(`makeOrder success`);
        }
    } catch (e) {
        console.error(`makeOrder, ${e}`);
    }
}

function genRequestParams(path, params = "", method = 0, hostType = 0, header = "") {
    const param = {
        path,
        method,
        hostType,
        header,
        params
    };
    return JSON.stringify(param);
}

function isEmpty(obj) {
    console.log(`shuhuan isEmpty obj: ${obj}`);
    if (!obj || obj === '' || obj.trim().length === 0 || Number.parseFloat(obj) <= 0) {
        console.log(`shuhuan obj isEmpty`);
        return true;
    }
    console.log(`shuhuan obj ok!!!`);
    return false;
}


async function riseColor(num) {
    const redRise = await getIsRedRiseValue();
    if (num == 0) {
        if (redRise == "1") {
            return await getColor('kColorPriceGreen');
        } else {
            return await getColor('kColorPriceRed');
        }
    } else {
        if (redRise == "1") {
            return await getColor('kColorPriceRed');
        } else {
            return await getColor('kColorPriceGreen');
        }
    }
}

async function getColor(colorKey) {
    const params = {
        action: "getColor",
        colorKey
    };
    const color = await onEvent(params);
    console.log(`lylTrade 获取color颜色 ${color}`);
    return color;
}

function getIsRedRiseValue(callback) {
    const params = {
        action: "isRedRise"
    };
    const redRise = onEvent(params);
    return redRise;
}

function getWord(wordKey, values) {
    const params = {
        action: "getWord",
        wordKey,
        values
    };;
    const word = onEvent(params);
    return word;
}

function showToast(toastKey) {
    const params = {
        action: "showToast",
        toastKey
    };
    console.log(`gsh showToast params ${params}`);
    onEvent(params);
}

async function refreshData(args) {
    const params = JSON.parse(args);
    console.log(`lylTrade refreshData ` + args.toString());
    mSymbol = params.symbol;
    $data.symbolName = params.symbolName;
    mCurrentDirection = params.direction;
    mAccountId = params.accountId;
    mOrderPriceType = params.orderPriceType;
    mSingleOrderType = params.singleOrderType;
    mOrderType = params.orderType;
    mOrderPrice = params.orderPrice;
    mOrderSize = params.orderSize;
    mDelegateType = params.delegateType;
    mOrderPriceRatio = params.orderPriceRatio;
    mOrderPriceGap = params.orderPriceGap;
    mSingleOrderSize = params.singleOrderSize;
    mSingleOrderRatio = params.singleOrderRatio;
    mInterval = params.interval;
    mOrderSide = params.orderSide;
    mSource = params.source;
    $data.displayOrderTypeValue = params.displayOrderTypeValue;
    $data.displayOrderPriceValue = params.displayOrderPriceValue;
    $data.displayOrderPriceRangeValue = params.displayOrderPriceRangeValue;
    $data.displayOrderAmountValue = params.displayOrderAmountValue;
    $data.displayOrderOneAmountValue = params.displayOrderOneAmountValue;
    $data.displayOrderIntervalValue = params.displayOrderIntervalValue;

    if (mCurrentDirection === 0) {
        await getWord("n_contract_position_buy_label").then(text => {
            $data.directionName = text;
        });
        await riseColor(0).then(color => {
            $data.directionColor = color;
        });

    } else {
        await getWord("n_contract_position_sell_label").then(text => {
            $data.directionName = text;
        });
        await riseColor(1).then(color => {
            $data.directionColor = color;
        });
    }
}
function getDrawable(drawableKey) {
    onEvent({
        action: "getDrawable",
        drawableKey
    });
}
function onCheck(index) {
    console.log(`lylTrade onCheck ${index}`);
    if (index == 0) {
        $data.checkSelect = "gone";
        $data.checkUnSelect = "visible";
        saveOrderConfirmReminder(true);
    } else {
        $data.checkSelect = "visible";
        $data.checkUnSelect = "gone";
        saveOrderConfirmReminder(false);
    }
}
function saveOrderConfirmReminder(isCheck) {
    onEvent({
        action: "orderConfirmNotReminder",
        isCheck
    });
}
function close() {
    onEvent({
        action: "onCloseAlert",
    });
}

function onEvent(dict) {
    return $nativeAPI.trade(JSON.stringify(dict));
}

async function initData() {
    await getWord("n_exchange_timing_deal").then(text => {
        $data.orderTypeName = text;
    });
    await getWord("n_exchange_timing_order_success").then(text => {
        mMsgOrderSuccess = text;
    });
    $data.checkSelect = "gone";
    $data.checkUnSelect = "visible";
}

initData();
