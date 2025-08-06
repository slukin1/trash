const STR_DEFAULT = "--";
let mCurrentDirection = 0;
let mMarketType = 0;
let mLimitType = 0;
let mLoanType = 0;
let mRepayType = 0;
let loanVolume = '';
let repayVolume = '';
let mPlanMarketMode = 1;
var oldTime = "";
let mBaseCurrency = STR_DEFAULT;
let mQuoteCurrency = STR_DEFAULT;
let mAmountValue = '';
let mVolumeValue = '';

let mIceAmount = '';
$data.directionName = STR_DEFAULT;

async function refreshData(args) {
    const params = JSON.parse(args);
    $data.symbolName = params.symbolName;
    mBaseCurrency = params.baseCurrency.toUpperCase();
    mQuoteCurrency = params.quoteCurrency.toUpperCase();
    mCurrentDirection = params.tradeType;
    mPlanMarketMode = params.planMarketMode;
    mMarketType = params.marketType;
    mLimitType = params.orderLimitType;
    mLoanType = params.isLoan;
    mRepayType = params.isRepay;
    loanVolume = params.loanVolume;
    repayVolume = params.repayVolume;
    $data.marginName = params.marginName;
    $data.displayOrderPriceValue = `${params.price} ${mQuoteCurrency}`;
    $data.displayOrderAmountValue = `${params.amount} ${mBaseCurrency}`;
    $data.displayOrderTriggerPriceValue = `${params.stopPrice} ${mQuoteCurrency}`;
    $data.displayOrderVolumeValue = `${params.total} ${mQuoteCurrency}`;
    mAmountValue = params.amount;
    mVolumeValue = params.total;
    mIceAmount = params.iceAmount;
    if (isEmpty(mIceAmount)) {
        $data.isIceAmountShow = "gone";
    }else{
        $data.isIceAmountShow = "visible";
        $data.displayIceAmountValue = `${params.iceAmount} ${mBaseCurrency}`;
    }
    $data.isAmountShow = "visible";
    $data.isVolumeShow = "visible";
    $data.isRepayEstimateShow = "gone";
    $data.isTagShow = "gone";
    await getWord("n_spot_order_confirm").then(text => {
        $data.displayTitleName = text;
    });
    if (mLoanType === 1 || mRepayType === 1) {
        if (mLoanType === 1 && parseFloat(loanVolume) != 0) {
            $data.isLoanShow = "visible";
            $data.isTagShow = "visible";
            if (mCurrentDirection === 0) {
                $data.displayLoanVolumeValue = `${params.loanVolume} ${mQuoteCurrency}`;
            } else {
                $data.displayLoanVolumeValue = `${params.loanVolume} ${mBaseCurrency}`;
            }
            if (!isEmpty(params.interest)) {
                $data.displayOrderInterestValue = params.interest;
            }
        }
        else {
            $data.isLoanShow = "gone";
            $data.isTagShow = "gone";
        }
        if (mRepayType === 1 && parseFloat(repayVolume) != 0) {
            $data.isRepayShow = "visible";
            
            if (mCurrentDirection === 0) {
                $data.displayRepayVolumeValue = `${params.repayVolume} ${mBaseCurrency}`;
            } else {
                $data.displayRepayVolumeValue = `${params.repayVolume} ${mQuoteCurrency}`;
            }
            if (mMarketType === 1) {
                $data.isRepayEstimateShow = "gone";
                if (isEmpty(mAmountValue) || isNaN(mAmountValue)) {
                    $data.isAmountShow = "gone";
                }
                if (isEmpty(mVolumeValue) || isNaN(mVolumeValue)) {
                    $data.isVolumeShow = "gone";
                }
                if (mCurrentDirection === 0) {
                    await getWord("n_trade_market_buy_hint").then(text => {
                        $data.displayOrderPriceValue = text;
                    });
                } else {
                    await getWord("n_trade_market_sell_hint").then(text => {
                        $data.displayOrderPriceValue = text;
                    });
                }
            } else {
                $data.isRepayEstimateShow = "visible";
            }
        }
        else {
            $data.isRepayShow = "gone";
            $data.isRepayEstimateShow = "gone";
        }
    } else {
        $data.isRepayShow = "gone";
        $data.isLoanShow = "gone";
        $data.isRepayEstimateShow = "gone";
        $data.isTagShow = "gone";
    }

    if (mCurrentDirection === 0) {
        await getWord("n_contract_position_buy_label").then(text => {
            $data.directionName = text;
        });
        await riseColor(0).then(color => {
            $data.directionColor = color;
        });
        await getWord("n_trade_buy_price").then(text => {
            $data.displayOrderPriceTitle = text;
        });
        await getWord("n_trade_buy_amount").then(text => {
            $data.displayOrderAmountTitle = text;
        });
    } else {
        await getWord("n_contract_position_sell_label").then(text => {
            $data.directionName = text;
        });
        await riseColor(1).then(color => {
            $data.directionColor = color;
        });
        await getWord("n_trade_sell_price").then(text => {
            $data.displayOrderPriceTitle = text;
        });
        await getWord("n_trade_sell_amount").then(text => {
            $data.displayOrderAmountTitle= text;
        });
    }
    if (mMarketType === 0) {
        $data.isTriggerShow = "gone";
        if (mLimitType == 0) {
            await getWord("n_exchange_order_list_limit").then(text => {
                $data.displayOrderTypeValue = `${text}-GTC`;
            });
        } else if (mLimitType == 1) {
            await getWord("n_exchange_order_list_limit").then(text => {
                $data.displayOrderTypeValue = `${text}-IOC`;
            });
        } else if (mLimitType == 2) {
            await getWord("n_exchange_order_list_limit").then(text => {
                $data.displayOrderTypeValue = `${text}-FOK`;
            });
        } else {
            await getWord("n_contract_intro_limit").then(text => {
                $data.displayOrderTypeValue = text;
            });
        }
    } else if (mMarketType === 1) {
        $data.isTriggerShow = "gone";
        await getWord("n_contract_intro_market").then(text => {
            $data.displayOrderTypeValue = text;
        });

        if (isEmpty(mAmountValue) || isNaN(mAmountValue)) {
            $data.isAmountShow = "gone";
        }
        if (isEmpty(mVolumeValue) || isNaN(mVolumeValue)) {
            $data.isVolumeShow = "gone";
        }

        if (mCurrentDirection === 0) {
             await getWord("n_trade_market_buy_hint").then(text => {
                 $data.displayOrderPriceValue = text;
             });
        } else {
             await getWord("n_trade_market_sell_hint").then(text => {
                 $data.displayOrderPriceValue = text;
             });
        }
    } else if (mMarketType === 2) {
        $data.isTriggerShow = "visible";
        await getWord("n_contract_intro_tpsl").then(text => {
            $data.displayOrderTypeValue = text;
        });

    } else if (mMarketType === 3) {
        $data.isTriggerShow = "visible";
        await getWord("n_contract_intro_plan").then(text => {
            $data.displayOrderTypeValue = text;
        });
        if (mPlanMarketMode === 2) {
            if (mCurrentDirection === 0) {
                 $data.isAmountShow = "gone";
                 await getWord("n_trade_market_buy_hint").then(text => {
                     $data.displayOrderPriceValue = text;
                });
            } else {
                 $data.isVolumeShow = "gone";
                 await getWord("n_trade_market_sell_hint").then(text => {
                     $data.displayOrderPriceValue = text;
                });
            }
        }
    } else if (mMarketType === 7) {
        $data.isTriggerShow = "gone";
        await getWord("n_contract_trade_post_only").then(text => {
            $data.displayOrderTypeValue = text;
        });
    }
}

function isEmpty(obj) {
    if (!obj || obj === '' || obj.trim().length === 0 || Number.parseFloat(obj) <= 0) {
        return true;
    }
    return false;
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

function getIsRedRiseValue(callback) {
    const params = {
        action: "isRedRise"
    };
    const redRise = onEvent(params);
    return redRise;
}

async function getColor(colorKey) {
    const params = {
        action: "getColor",
        colorKey
    };
    const color = await onEvent(params);
    return color;
}

function onCheck(index) {
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

function confirm() {
    if (preventClick(1000)) {
        onEvent({
            action: "onConfirmAlert",
        });
    }
}

function preventClick(msc) {
    if (oldTime === '') {
        oldTime = new Date().getTime();
        return true;
    } else {
        var newTime = new Date().getTime();
        if (newTime - oldTime > msc) {
            oldTime = new Date().getTime();
            return true;
        } else {
            return false;
        }
    }
}

function onEvent(dict) {
    return $nativeAPI.trade(JSON.stringify(dict));
}

async function initData() {
    $data.checkSelect = "gone";
    $data.checkUnSelect = "visible";
    $data.isLoanShow = "gone";
    $data.isRepayShow = "gone";
    $data.isAmountShow = "visible";
    $data.isVolumeShow = "visible";
    $data.isTagShow = "gone";
    $data.isRepayEstimateShow = "gone";
    $data.isTagShow = "gone";
}

initData();
