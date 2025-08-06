
const STR_DEFAULT = "--";
const COLOR_TRANSPARENT = "#00000000";
const KEY_COLOR_EDIT_NORMAL = "KBaseColorContentBackground";
const KEY_COLOR_EDIT_SELECTOR = "KBaseColorMajorTheme100";
const KEY_COLOR_TAB_BG_NORMAL = "KBaseColorInputBackground";
const KEY_COLOR_TAB_TEXT_NORMAL = "KBaseColorSecondaryText";
const KEY_COLOR_TAB_TEXT_SELECT = "KBaseTextColor";
const KEY_COLOR_INPUT_INVALID_TIP = "KBaseInputInvalidTipColor";
const ORDER_PATH = "v2/algo-orders";
const DEFAULT_PRECISION_PERCENT = "2";
const DEFAULT_PRECISION_INT = "20";

$data.symbolName = "--/--";
$data.baseCurrency = STR_DEFAULT;
$data.quoteCurrency = STR_DEFAULT;
$data.lastPrice = STR_DEFAULT;
$data.tabBuy = STR_DEFAULT;
$data.tabSell = STR_DEFAULT;
$data.assetAvailableUnit = "USDT";
$data.assetAvailableValue = STR_DEFAULT;
$data.confirmBtnValue = STR_DEFAULT;
$data.edtPriceRangeTipVisible = "gone";
$data.edtSingleAmountTipVisible = "gone";
$data.edtIntervalRangeTipVisible = "gone";
$data.seekbarShow = true;
$data.totalAmount = "";
$data.popRangeShow = "false";
$data.popVolumeShow = "false";
$data.progress = "0";
$data.precisionPriceInt = DEFAULT_PRECISION_INT;
$data.precisionPriceFloat = DEFAULT_PRECISION_PERCENT;
$data.precisionPriceRangeInt = DEFAULT_PRECISION_INT;
$data.precisionPriceRangeFloat = DEFAULT_PRECISION_PERCENT;
$data.precisionTotalAmountInt = DEFAULT_PRECISION_INT;
$data.precisionTotalAmountFloat = DEFAULT_PRECISION_PERCENT;
$data.precisionSingleAmountInt = DEFAULT_PRECISION_INT;
$data.precisionSingleAmountFloat = DEFAULT_PRECISION_PERCENT;

let mCurrentDirection = 0;
let mCurrentRangeSelect = 0;
let mCurrentSingleVolumeSelect = 0;
let mTabNormalBgColor = COLOR_TRANSPARENT;
let mTabBuySelectBgColor = COLOR_TRANSPARENT;
let mTabSellSelectBgColor = COLOR_TRANSPARENT;
let mTabTextNormalColor = COLOR_TRANSPARENT;
let mTabTextSelectColor = COLOR_TRANSPARENT;
let mSymbol = '';
let mBaseCurrency = STR_DEFAULT;
let mQuoteCurrency = STR_DEFAULT;
let mLastPrice = 0;
let mEdtBoardNormalColor;
let mEdtBoardSelectColor;
let minTimeInterval = 0;
let maxTimeInterval = 0;
let minPriceIntervalRatio = 0.00;
let maxPriceIntervalRatio = 0.00;
let mAvailableBuyWithLastPrice = 0.00;
let mAvailableOfBuy = STR_DEFAULT;
let mAvailableOfSell = STR_DEFAULT;
let mInputInvalidTipColor;
let mCurrentRangeType = 1;
let mCurrentVolumeType = 1;
let mAccountId = 0;
let mSource = "";
let mMsgOrderSuccess = "";
let mLimitPrice = "0";
let mLimitRange = "0";
let mTotalAmount = "0";
let mSingleAmount = "0";
let mTimeInterval = "0";
let mLessThan = 0.00;
let mGreaterThan = 0.00;
let mAmountPrecision = 0;
let mPricePrecision = 0;
let mNeedOrderConfirm = false;

let mDisplayOrderTypeValue = "";
let mDisplayOrderPriceValue = "";
let mDisplayOrderPriceRangeValue = "";
let mDisplayOrderAmountValue = "";
let mDisplayOrderOneAmountValue = "";
let mDisplayOrderIntervalValue = "";

var oldTime = "";

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

function getErrorInfo(code, succeed, msgList) {
    const params = {
        code,
        succeed,
        msgList
    };
    return JSON.stringify(params);
}

function getResponseParams(code, succeed) {
    const params = {
        code,
        succeed
    };
    return JSON.stringify(params);
}

function requestFocus(index) {
    if (index == 1) {
        $data.edt1Focus = "true";
    } else if (index == 2) {
        $data.edt2Focus = "true";
    } else if (index == 3) {
        $data.edt3Focus = "true";
    } else if (index == 4) {
        $data.edt4Focus = "true";
    } else if (index == 5) {
        $data.edt5Focus = "true";
    }
}

function popDismiss() {
    console.log(`lylTrade popDismiss`);
    $data.popCoverVisible = "gone";
}
async function onClickRangeCount() {
    console.log(`lylTrade onClickRangeCount `);
    mCurrentRangeType = 1;
    $data.rangeTypeName = await getWord("n_exchange_timing_price_range");
    $data.popRangeShow = "false";
    $data.priceRangeUnit = mQuoteCurrency;
    $data.limitRange = '';
    $data.precisionPriceRangeFloat = mPricePrecision;
}

async function onClickRangeRatio() {
    console.log(`lylTrade onClickRangeRatio `);
    mCurrentRangeType = 2;
    $data.rangeTypeName = await getWord("n_exchange_timing_ratio");
    $data.popRangeShow = "false";
    $data.priceRangeUnit = "%";
    $data.limitRange = '';
    $data.precisionPriceRangeFloat = DEFAULT_PRECISION_PERCENT;
}

async function onClickVolumeCount() {
    console.log(`lylTrade onClickVolumeCount `);
    mCurrentVolumeType = 1;
    $data.volumeTypeName = await getWord("n_exchange_order_list_amount");
    $data.popVolumeShow = "false";
    $data.volumeRangeUnit = mBaseCurrency;
    $data.singleAmount = '';
    $data.precisionSingleAmountFloat = mAmountPrecision;
}

async function onClickVolumeRatio() {
    console.log(`lylTrade onClickVolumeRatio `);
    mCurrentVolumeType = 2;
    $data.volumeTypeName = await getWord("n_exchange_timing_ratio");
    $data.popVolumeShow = "false";
    $data.volumeRangeUnit = "%";
    $data.singleAmount = '';
    $data.precisionSingleAmountFloat = DEFAULT_PRECISION_PERCENT;
}
function clickPopRange() {
    console.log(`lylTrade clickPopRange ` + $data.popRangeShow);
    endEditing();
    $data.popRangeShow = "true";
    $data.popCoverVisible = "visible";
}
function clickPopVolume() {
    console.log(`lylTrade clickPopVolume ` + $data.popVolumeShow);
    endEditing();
    $data.popVolumeShow = "true";
    $data.popCoverVisible = "visible";
}

async function confirm() {
    if (!preventClick(1000)) {
        return;
    }
    console.log(`shuhuan confirm click`);
    let toastKey = '';
    let realWord = '';
    let verification = false;
    if (mCurrentDirection == 0 && Number.parseFloat(mAvailableOfBuy) <= 0) {
        toastKey = await getWord("n_trade_balance_no_enough");
        showToast(toastKey);
        return;
    }
    if (mCurrentDirection == 1 && Number.parseFloat(mAvailableOfSell) <= 0) {
        toastKey = await getWord("n_trade_balance_no_enough");
        showToast(toastKey);
        return;
    }

    if (isEmpty(mLimitPrice)) {
        realWord = await getWord("n_exchange_timing_taker_price_limit");
        toastKey = await getWord("n_exchange_timing_tips_prefix", [realWord]);
        showToast(toastKey);
        return;
    }
    if (isEmpty(mLimitRange)) {
        if (mCurrentRangeType == 1) {
            realWord = await getWord("n_exchange_timing_price_range");
            toastKey = await getWord("n_exchange_timing_tips_prefix", [realWord]);
        } else {
            realWord = await getWord("n_exchange_timing_ratio");
            toastKey = await getWord("n_exchange_timing_tips_prefix", [realWord]);
        }
        showToast(toastKey);
        return;
    }
    if (mCurrentRangeType == 2) {
        verification = checkFieldValidity(minPriceIntervalRatio, maxPriceIntervalRatio, Number.parseFloat(mLimitRange));
        if (!verification) {
            toastKey = $data.eatRangeTips;
            showToast(toastKey);
            return;
        }
    }

    if (isEmpty(mTotalAmount)) {
        realWord = await getWord("n_exchange_timing_order_total_amount");
        toastKey = await getWord("n_exchange_timing_tips_prefix", [realWord]);
        showToast(toastKey);
        return;
    }
    if (mGreaterThan > 0 && Number.parseFloat(mTotalAmount) < mGreaterThan) {
        let greaterThanStr = String(mGreaterThan) + mBaseCurrency;
        toastKey = await getWord("n_exchange_timing_total_amount_greater_then", [greaterThanStr]);
        showToast(toastKey);
        return;
    }

    if (isEmpty(mSingleAmount)) {
        realWord = await getWord("n_exchange_timing_one_order_amount");
        toastKey = await getWord("n_exchange_timing_tips_prefix", [realWord]);
        showToast(toastKey);
        return;
    }
    if (mCurrentVolumeType == 1) {
        if (isEmpty(mTotalAmount)) {
            verification = true;
        } else {
            verification = checkFieldValidity(0, Number.parseFloat(mTotalAmount), Number.parseFloat(mSingleAmount));
        }
        if (!verification) {
            toastKey = $data.singleAmountTips;
            showToast(toastKey);
            return;
        }
        if (mLessThan > 0 && mGreaterThan > 0) {
            verification = checkFieldValidity(mGreaterThan, mLessThan, Number.parseFloat(mSingleAmount));
            if (!verification) {
                let lessThanStr = String(mLessThan) + mBaseCurrency;
                let greaterThanStr = String(mGreaterThan) + mBaseCurrency;
                toastKey = await getWord("n_exchange_timing_one_order_amount_tips", [greaterThanStr, lessThanStr]);
                showToast(toastKey);
                return;
            }
        }
    } else if (mCurrentVolumeType == 2) {
        if (Number.parseFloat(mSingleAmount) > 100) {
            toastKey = $data.singleAmountTips;
            showToast(toastKey);
            return;
        }
        if (isEmpty(mTotalAmount)) {
            verification = true;
        } else {
            let ratioSingleAmount = (Number.parseFloat(mSingleAmount) / 100.00) * Number.parseFloat(mTotalAmount);
            verification = checkFieldValidity(0, Number.parseFloat(mTotalAmount), ratioSingleAmount);
        }

        if (!verification) {
            toastKey = $data.singleAmountTips;
            showToast(toastKey);
            return;
        }
    }

    if (isEmpty(mTimeInterval)) {
        realWord = await getWord("n_exchange_timing_interval");
        toastKey = await getWord("n_exchange_timing_tips_prefix", [realWord]);
        showToast(toastKey);
        return;
    }
    verification = checkFieldValidity(minTimeInterval, maxTimeInterval, Number.parseInt(mTimeInterval));
    if (!verification) {
        toastKey = $data.intervalRangeTips;
        showToast(toastKey);
        return;
    }
    if (mNeedOrderConfirm) {
        displayNameHandle();
    } else {
        makeOrder();
    }
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

function seekBarValueChange(progress) {
    console.log(`lylTrade seekBarValueChange progress: ${progress}`);
    let value = Number.parseFloat(progress);
    if (value <= 0) {
        mTotalAmount = '';
        $data.totalAmount = mTotalAmount;
        return;
    } else if (value > 100) {
        mSliderValue = 1.00;
    } else {
        mSliderValue = Number.parseFloat(value / 100.00).toFixed(2);
    }
    calculateAvailableAmount(mSliderValue);
    console.log(`shuhuan seekBarValueChange value: ${mSliderValue}`);
}

function calculateAvailableAmount(percentage) {
    if (mCurrentDirection == 0) {
        if (mAvailableBuyWithLastPrice <= 0) {
            mTotalAmount = '';
        } else {
            mTotalAmount = String(mSliderValue * mAvailableBuyWithLastPrice);
        }
    } else {
        if (Number.parseFloat(mAvailableOfSell) <= 0) {
            mTotalAmount = '';
        } else {
            mTotalAmount = String(mSliderValue * Number.parseFloat(mAvailableOfSell));
        }
    }
    if (isEmpty(mTotalAmount)) {
        $data.totalAmount = '';
    } else {
        $data.totalAmount = Number.parseFloat(mTotalAmount);
    }
    console.log(`shuhuan totalAmount:${$data.totalAmount}`);
}

function onTabSelect(index) {
    console.log(`lylTrade onTabSelect ${index}`);
    mCurrentDirection = index;
    updateAssetAvailable();
    if (index == 0) {
        $data.tabBuyBgColor = mTabBuySelectBgColor;
        $data.tabSellBgColor = mTabNormalBgColor;
        $data.confirmBgColor = mTabBuySelectBgColor;
        $data.tabBuyTextColor = mTabTextSelectColor;
        $data.tabSellTextColor = mTabTextNormalColor;
        $data.confirmBtnValue = $data.tabBuy;
        $data.assetAvailableUnit = mQuoteCurrency;
    } else {
        $data.tabSellBgColor = mTabSellSelectBgColor;
        $data.tabBuyBgColor = mTabNormalBgColor;
        $data.confirmBgColor = mTabSellSelectBgColor;
        $data.tabBuyTextColor = mTabTextNormalColor;
        $data.tabSellTextColor = mTabTextSelectColor;
        $data.confirmBtnValue = $data.tabSell;
        $data.assetAvailableUnit = mBaseCurrency;
    }
    resetData();
    reportData("app_trade_twap_side_click", {
        eventName: "side",
        eventValue: mCurrentDirection == 0 ? "buy" : "sell",
    });
}
function resetData() {
    $data.edtPriceRangeTipVisible = "gone";
    $data.edtSingleAmountTipVisible = "gone";
    $data.edtIntervalRangeTipVisible = "gone";
    $data.edt1BoardColor = mEdtBoardNormalColor;
    $data.edt2BoardColor = mEdtBoardNormalColor;
    $data.edt3BoardColor = mEdtBoardNormalColor;
    $data.edt4BoardColor = mEdtBoardNormalColor;
    $data.edt5BoardColor = mEdtBoardNormalColor;
    $data.popRangeShow = "false";
    $data.popVolumeShow = "false";
    $data.limitPrice = '';
    $data.limitRange = '';
    $data.totalAmount = '';
    $data.singleAmount = '';
    $data.timeInterval = '';
    $data.progress = "0";
    $data.precisionPriceInt = DEFAULT_PRECISION_INT;
    $data.precisionPriceFloat = mPricePrecision;
    $data.precisionPriceRangeInt = DEFAULT_PRECISION_INT;
    $data.precisionPriceRangeFloat = mPricePrecision;
    $data.precisionTotalAmountInt = DEFAULT_PRECISION_INT;
    $data.precisionTotalAmountFloat = mAmountPrecision;
    $data.precisionSingleAmountInt = DEFAULT_PRECISION_INT;
    $data.precisionSingleAmountFloat = mAmountPrecision;
    onClickRangeCount();
    onClickVolumeCount();
}

function onTextChange(key, text) {
    console.log(`lylTrade onTextChange ${text}`);
    switch (key) {
        case 1:
            mLimitPrice = text;
            break;
        case 2:
            mLimitRange = text;
            break;
        case 3:
            mTotalAmount = text;
            break;
        case 4:
            mSingleAmount = text;
            break;
        case 5:
            mTimeInterval = text;
            break;
    }
}

async function onFocusChange(key, isFocus) {
    console.log(`lylTrade onFocusChange ${key} ${isFocus}`);
    if (key == 1) {
        if (isFocus) {
            $data.edt1BoardColor = mEdtBoardSelectColor;
            if ($data.edtPriceRangeTipVisible == "gone") {
                $data.edt2BoardColor = mEdtBoardNormalColor;
            }
            $data.edt3BoardColor = mEdtBoardNormalColor;
            if ($data.edtSingleAmountTipVisible == "gone") {
                $data.edt4BoardColor = mEdtBoardNormalColor;
            }
            if ($data.edtIntervalRangeTipVisible == "gone") {
                $data.edt5BoardColor = mEdtBoardNormalColor;
            }
            console.log(`lylTrade edt1BoardColor ` + $data.edt1BoardColor);
        } else {
            $data.edt1BoardColor = mEdtBoardNormalColor;
            $data.edt1Focus = "false";
        }
    } else if (key == 2) {
        if (isFocus) {
            $data.edt1BoardColor = mEdtBoardNormalColor;
            if ($data.edtPriceRangeTipVisible == "gone") {
                $data.edt2BoardColor = mEdtBoardSelectColor;
            }
            $data.edt3BoardColor = mEdtBoardNormalColor;
            if ($data.edtSingleAmountTipVisible == "gone") {
                $data.edt4BoardColor = mEdtBoardNormalColor;
            }
            if ($data.edtIntervalRangeTipVisible == "gone") {
                $data.edt5BoardColor = mEdtBoardNormalColor;
            }
        } else {
            if ($data.edtPriceRangeTipVisible == "gone") {
                $data.edt2BoardColor = mEdtBoardNormalColor;
            }
            $data.edt2Focus = "false";

            verifyInputView(key);
        }
    } else if (key == 3) {
        if (isFocus) {
            $data.edt1BoardColor = mEdtBoardNormalColor;
            if ($data.edtPriceRangeTipVisible == "gone") {
                $data.edt2BoardColor = mEdtBoardNormalColor;
            }
            $data.edt3BoardColor = mEdtBoardSelectColor;
            if ($data.edtSingleAmountTipVisible == "gone") {
                $data.edt4BoardColor = mEdtBoardNormalColor;
            }
            if ($data.edtIntervalRangeTipVisible == "gone") {
                $data.edt5BoardColor = mEdtBoardNormalColor;
            }
        } else {
            $data.edt3BoardColor = mEdtBoardNormalColor;
            $data.edt3Focus = "false";

        }
    } else if (key == 4) {
        if (isFocus) {
            $data.edt1BoardColor = mEdtBoardNormalColor;
            if ($data.edtPriceRangeTipVisible == "gone") {
                $data.edt2BoardColor = mEdtBoardNormalColor;
            }
            $data.edt3BoardColor = mEdtBoardNormalColor;
            if ($data.edtSingleAmountTipVisible == "gone") {
                $data.edt4BoardColor = mEdtBoardSelectColor;
            }
            if ($data.edtIntervalRangeTipVisible == "gone") {
                $data.edt5BoardColor = mEdtBoardNormalColor;
            }
        } else {
            if ($data.edtSingleAmountTipVisible == "gone") {
                $data.edt4BoardColor = mEdtBoardNormalColor;
            }
            $data.edt4Focus = "false";
            verifyInputView(key);
        }
    } else if (key == 5) {
        if (isFocus) {
            $data.edt1BoardColor = mEdtBoardNormalColor;
            if ($data.edtPriceRangeTipVisible == "gone") {
                $data.edt2BoardColor = mEdtBoardNormalColor;
            }
            $data.edt3BoardColor = mEdtBoardNormalColor;
            if ($data.edtSingleAmountTipVisible == "gone") {
                $data.edt4BoardColor = mEdtBoardNormalColor;
            }
            if ($data.edtIntervalRangeTipVisible == "gone") {
                $data.edt5BoardColor = mEdtBoardSelectColor;
            }
        } else {
            if ($data.edtIntervalRangeTipVisible == "gone") {
                $data.edt5BoardColor = mEdtBoardNormalColor;
            }
            $data.edt5Focus = "false";
            verifyInputView(key);
        }
    }
}

async function verifyInputView(index) {
    console.log(`shuhuan verifyInputView ${index}`);
    var verification = true;
    switch (index) {
        case 1:
            break;
        case 2:
            if (mCurrentRangeType == 2) {
                verification = checkFieldValidity(minPriceIntervalRatio, maxPriceIntervalRatio, Number.parseFloat(mLimitRange));
            }
            if (!verification) {
                $data.edtPriceRangeTipVisible = "visible";
                $data.edt2BoardColor = mInputInvalidTipColor;
                return;
            }
            $data.edt2BoardColor = mEdtBoardNormalColor;
            $data.edtPriceRangeTipVisible = "gone";
            break;
        case 3:
            break;
        case 4:
            if (mCurrentVolumeType == 1) {
                if (isEmpty(mTotalAmount)) {
                    verification = true;
                } else {
                    verification = checkFieldValidity(0, Number.parseFloat(mTotalAmount), Number.parseFloat(mSingleAmount));

                }
            } else {
                if (isEmpty(mTotalAmount)) {
                    verification = true;
                } else {
                    let ratioNum = (Number.parseFloat(mSingleAmount) / 100.00) * Number.parseFloat(mTotalAmount);
                    verification = checkFieldValidity(0, Number.parseFloat(mTotalAmount), ratioNum);
                }
            }
            if (!verification) {
                $data.edtSingleAmountTipVisible = "visible";
                $data.edt4BoardColor = mInputInvalidTipColor;
                return;
            }
            $data.edt4BoardColor = mEdtBoardNormalColor;
            $data.edtSingleAmountTipVisible = "gone";
            break;
        case 5:
            verification = checkFieldValidity(minTimeInterval, maxTimeInterval, Number.parseInt(mTimeInterval));
            if (!verification) {
                $data.edtIntervalRangeTipVisible = "visible";
                $data.edt5BoardColor = mInputInvalidTipColor;
                return;
            }
            $data.edt5BoardColor = mEdtBoardNormalColor;
            $data.edtIntervalRangeTipVisible = "gone";
            break;
    }
}

function checkFieldValidity(minNum, maxNum, currentNum) {
    console.log(`shuhuan checkFieldValidity ${minNum} ${maxNum} ${currentNum}`);
    if (currentNum >= minNum && currentNum <= maxNum) {
        return true;
    }
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

async function initColor() {
    mTabBuySelectBgColor = await riseColor(0);
    mTabSellSelectBgColor = await riseColor(1);
    mTabNormalBgColor = await getColor(KEY_COLOR_TAB_BG_NORMAL);
    mTabTextNormalColor = await getColor(KEY_COLOR_TAB_TEXT_NORMAL);
    mTabTextSelectColor = await getColor(KEY_COLOR_TAB_TEXT_SELECT);
    $data.confirmTextColor = mTabTextSelectColor;
    $data.lastPriceColor = mTabBuySelectBgColor;
    mEdtBoardNormalColor = await getColor(KEY_COLOR_EDIT_NORMAL);
    mEdtBoardSelectColor = await getColor(KEY_COLOR_EDIT_SELECTOR);
    $data.edt1BoardColor = mEdtBoardNormalColor;
    $data.edt2BoardColor = mEdtBoardNormalColor;
    $data.edt3BoardColor = mEdtBoardNormalColor;
    $data.edt4BoardColor = mEdtBoardNormalColor;
    $data.edt5BoardColor = mEdtBoardNormalColor;
    mInputInvalidTipColor = await getColor(KEY_COLOR_INPUT_INVALID_TIP);
    $data.inputInvalidTipColor = mInputInvalidTipColor;
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
    mBaseCurrency = params.baseCurrency.toUpperCase();
    $data.baseCurrency = mBaseCurrency;
    mQuoteCurrency = params.quoteCurrency.toUpperCase();
    $data.quoteCurrency = mQuoteCurrency;
    $data.priceRangeUnit = mQuoteCurrency;
    $data.volumeRangeUnit = mBaseCurrency;
    $data.symbolName = params.symbolName;
    mRise = params.rise;
    mNeedOrderConfirm = params.needOrderConfirm;
    updateLastPriceColor(params.rise);
    mAvailableOfBuy = params.availableOfBuy;
    mAvailableOfSell = params.availableOfSell;
    updateAssetAvailable();
    minTimeInterval = Number.parseInt(params.minTimeInterval);
    maxTimeInterval = Number.parseInt(params.maxTimeInterval);
    minPriceIntervalRatio = Number.parseFloat(params.minPriceIntervalRatio) * 100;
    maxPriceIntervalRatio = Number.parseFloat(params.maxPriceIntervalRatio) * 100;
    mAccountId = Number.parseInt(params.accountId);
    mSource = params.source;
    mLessThan = Number.parseFloat(params.lessThan);
    mGreaterThan = Number.parseFloat(params.greaterThan);
    mAmountPrecision = Number.parseInt(params.tradeAmountPrecision);
    mPricePrecision = Number.parseInt(params.tradePricePrecision);
    $data.precisionPriceFloat = params.tradePricePrecision;
    $data.precisionPriceRangeFloat = params.tradePricePrecision;
    $data.precisionTotalAmountFloat = params.tradeAmountPrecision;
    $data.precisionSingleAmountFloat = params.tradeAmountPrecision;
    updateLastPrice(args);
    await getWord("n_exchange_timing_maker_eat_order_price_superior_handicap_range", [String(minPriceIntervalRatio), String(maxPriceIntervalRatio)]).then(text => {
        $data.eatRangeTips = text;
        console.log(`lylTrade eatRangeTips ${text} `);
    });
    await getWord("n_exchange_timing_order_time_interval_range", [String(minTimeInterval), String(maxTimeInterval)]).then(text => {
        $data.intervalRangeTips = text;
        console.log(`lylTrade intervalRangeTips ${text} `);
    });
}

async function updateLastPrice(args) {
    const params = JSON.parse(args);
    mLastPrice = Number.parseFloat(params.price);
    $data.lastPrice = params.price;
    updateLastPriceColor(params.rise);
    if (Number.parseFloat(mLastPrice) <= 0) {
        mAvailableBuyWithLastPrice = 0.00;
    } else {
        mAvailableBuyWithLastPrice = Number.parseFloat(mAvailableOfBuy) / Number.parseFloat(mLastPrice);
    }
}

function updateLastPriceColor(rise) {
    $data.lastPriceColor = rise ? mTabBuySelectBgColor : mTabSellSelectBgColor;
}

async function updateAssetAvailable(args) {
    console.log(`lylTrade updateAssetAvailable ` + args);
    const params = JSON.parse(args);
    mAvailableOfBuy = params.availableOfBuy;
    mAvailableOfSell = params.availableOfSell;
    updateAssetAvailable();
}

function updateAssetAvailable() {
    $data.assetAvailableValue = mCurrentDirection == 0 ? mAvailableOfBuy : mAvailableOfSell;
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
    initColor().then(() => {
        onTabSelect(0);
    });
    await getWord('n_exchange_buy_in').then(text => {
        $data.tabBuy = text;
        if (mCurrentDirection == 0) {
            $data.confirmBtnValue = text;
        }
    });
    await getWord('n_exchange_sell_out').then(text => {
        $data.tabSell = text;
        if (mCurrentDirection == 1) {
            $data.confirmBtnValue = text;
        }
    });;

    await getWord('n_exchange_timing_order_one_amount_must_less_total_amount').then(text => {
        $data.singleAmountTips = text;
        console.log(`lylTrade singleAmountTips ${text} `);
    });
    await getWord("n_exchange_timing_price_range").then(text => {
        $data.rangeTypeName = text;
    });
    await getWord("n_exchange_order_list_amount").then(text => {
        $data.volumeTypeName = text;
    });

    await getWord("n_exchange_timing_order_success").then(text => {
        mMsgOrderSuccess = text;
    });
}

initData();


async function makeOrder() {
    const param = {
        accountId: mAccountId,
        symbol: mSymbol,
        orderPrice: mLimitPrice,
        orderSide: mCurrentDirection == 0 ? "buy" : "sell",
        orderSize: mTotalAmount,
        orderType: "limit",
        source: mSource,
        delegateType: 2,
        orderPriceType: mCurrentRangeType,
        orderPriceRatio: mCurrentRangeType == 2 ? Number.parseFloat(Number.parseFloat(mLimitRange) / 100.00).toString() : "",
        orderPriceGap: mCurrentRangeType == 1 ? mLimitRange : "",
        singleOrderType: mCurrentVolumeType,
        singleOrderSize: mCurrentVolumeType == 1 ? mSingleAmount : "",
        singleOrderRatio: mCurrentVolumeType == 2 ? Number.parseFloat(Number.parseFloat(mSingleAmount) / 100.00).toString() : "",
        interval: Number.parseInt(mTimeInterval)
    };
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

function orderConfirm() {
    close();
    onEvent({
        action: "orderConfirmDialog",
        params: {
            accountId: mAccountId,
            symbol: mSymbol,
            orderPrice: mLimitPrice,
            orderSide: mCurrentDirection == 0 ? "buy" : "sell",
            orderSize: mTotalAmount,
            orderType: "limit",
            source: mSource,
            delegateType: 2,
            orderPriceType: mCurrentRangeType,
            orderPriceRatio: mCurrentRangeType == 2 ? Number.parseFloat(Number.parseFloat(mLimitRange) / 100.00).toString() : "",
            orderPriceGap: mCurrentRangeType == 1 ? mLimitRange : "",
            singleOrderType: mCurrentVolumeType,
            singleOrderSize: mCurrentVolumeType == 1 ? mSingleAmount : "",
            singleOrderRatio: mCurrentVolumeType == 2 ? Number.parseFloat(Number.parseFloat(mSingleAmount) / 100.00).toString() : "",
            interval: Number.parseInt(mTimeInterval),
            symbolName: $data.symbolName,
            direction: mCurrentDirection,
            needOrderConfirm: mNeedOrderConfirm,
            displayOrderTypeValue: mDisplayOrderTypeValue,
            displayOrderPriceValue: mDisplayOrderPriceValue,
            displayOrderPriceRangeValue: mDisplayOrderPriceRangeValue,
            displayOrderAmountValue: mDisplayOrderAmountValue,
            displayOrderOneAmountValue: mDisplayOrderOneAmountValue,
            displayOrderIntervalValue: mDisplayOrderIntervalValue
        }
    });
}

async function displayNameHandle() {
    mDisplayOrderTypeValue = await getWord("n_exchange_timing_deal");
    mDisplayOrderPriceValue = mLimitPrice + ' ' + mQuoteCurrency;
    if (mCurrentRangeType == 1) {
        mDisplayOrderPriceRangeValue = mLimitRange + ' ' + mQuoteCurrency;
    } else {
        mDisplayOrderPriceRangeValue = mLimitRange + ' %';
    }
    mDisplayOrderAmountValue = mTotalAmount + ' ' + mBaseCurrency;
    if (mCurrentVolumeType == 1) {
        mDisplayOrderOneAmountValue = mSingleAmount + ' ' + mBaseCurrency;
    } else {
        mDisplayOrderOneAmountValue = mSingleAmount + ' %';
    }
    mDisplayOrderIntervalValue = mTimeInterval + ' S';
    console.log(`displayNameHandle, ${mDisplayOrderTypeValue} ${mDisplayOrderPriceValue} ${mDisplayOrderPriceRangeValue} ${mDisplayOrderAmountValue} ${mDisplayOrderOneAmountValue} ${mDisplayOrderIntervalValue}`);
    orderConfirm();
}
function endEditing() {
    const params = {
        action: "endEditing",
    };
    onEvent(params);
}

function reportData(eventName, eventValue) {
    const params = {
        action: "report",
        eventName,
        eventValue
    };
    onEvent(params);
}

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
