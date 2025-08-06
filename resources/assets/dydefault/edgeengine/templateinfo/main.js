function moduleDefine(moduleName, defaultDataFunction, functions = {
    onCreate: onCreate$2,
    onDestroy: onDestroy$2,
    onResume: onResume$2,
    onPause: onPause$2,
    onStart: onStart$2,
    onStop: onStop$2
}) {
    console.log(`loadModule`, moduleName);
    $data[moduleName] = defaultDataFunction();
    $event[moduleName] = {
        onCreate: typeof functions.onCreate == "undefined" ? onCreate$2 : functions.onCreate,
        onDestroy: typeof functions.onDestroy == "undefined" ? onDestroy$2 : functions.onDestroy,
        onResume: typeof functions.onResume == "undefined" ? onResume$2 : functions.onResume,
        onPause: typeof functions.onPause == "undefined" ? onPause$2 : functions.onPause,
        onStart: typeof functions.onStart == "undefined" ? onStart$2 : functions.onStart,
        onStop: typeof functions.onStop == "undefined" ? onStop$2 : functions.onStop
    };
    return {
        moduleData: $data[moduleName],
        moduleEvent: $event[moduleName]
    };
}

function onCreate$2() {
    console.log("common onCreate");
}

function onDestroy$2() {}

function onResume$2() {}

function onPause$2() {}

function onStart$2() {}

function onStop$2() {}

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
        const value = JSON.parse(data);
        return value;
    }
    return null;
}

var localCode = "9274c3e7985bcd8a";

var flag = false;

function defaultData$1() {
    return {
        rmslist: []
    };
}

const {moduleData: moduleData$1, moduleEvent: moduleEvent$1} = moduleDefine("infolist", defaultData$1, {
    onCreate: onCreate$1,
    onDestroy: onDestroy$1,
    onResume: onResume$1,
    onPause: onPause$1,
    onStart: onStart$1,
    onStop: onStop$1
});

async function onCreate$1(eventParams) {
    moduleData$1.navConfig = getNavConfigString$1();
    if (eventParams && eventParams != null) {
        const params = JSON.parse(eventParams);
        const paramsCode = params.code ? params.code : "";
        if (localCode === paramsCode) {
            flag = true;
        } else {
            flag = false;
        }
    }
}

function onDestroy$1() {}

function onResume$1() {}

function onPause$1() {}

async function onStart$1() {
    if (flag === true) {
        await buildListData();
    } else {
        await showError();
    }
}

function onStop$1() {}

async function buildListData() {
    const tempRmsInfo = await $nativeAPI.rmsInfo();
    const rmsInfo = JSON.parse(tempRmsInfo);
    var currentIndex = -1;
    var dataList = [];
    if (rmsInfo) {
        if (rmsInfo.currentEdgeEngine) {
            var item = {};
            item.name = "端侧引擎代码";
            currentIndex = currentIndex + 1;
            handleItem(item, currentIndex);
            var array = [];
            for (var i = 0; i < rmsInfo.currentEdgeEngine.length; i++) {
                var childItem = rmsInfo.currentEdgeEngine[i];
                handleChildItem(childItem);
                array.push(childItem);
            }
            item.list = array;
            dataList.push(item);
        }
        if (rmsInfo.currentH5) {
            var item = {};
            item.name = "H5离线包";
            currentIndex = currentIndex + 1;
            handleItem(item, currentIndex);
            var array = [];
            for (var i = 0; i < rmsInfo.currentH5.length; i++) {
                var childItem = rmsInfo.currentH5[i];
                handleChildItem(childItem);
                array.push(childItem);
            }
            item.list = array;
            dataList.push(item);
        }
        if (rmsInfo.currentSkin) {
            var item = {};
            item.name = "App活动皮肤";
            currentIndex = currentIndex + 1;
            handleItem(item, currentIndex);
            var array = [];
            for (var i = 0; i < rmsInfo.currentSkin.length; i++) {
                var childItem = rmsInfo.currentSkin[i];
                handleChildItem(childItem);
                array.push(childItem);
            }
            item.list = array;
            dataList.push(item);
        }
        if (rmsInfo.currentAppResources) {
            var item = {};
            item.name = "颜色&多语言动态包";
            currentIndex = currentIndex + 1;
            handleItem(item, currentIndex);
            var array = [];
            for (var i = 0; i < rmsInfo.currentAppResources.length; i++) {
                var childItem = rmsInfo.currentAppResources[i];
                handleChildItem(childItem);
                array.push(childItem);
            }
            item.list = array;
            dataList.push(item);
        }
        moduleData$1.rmslist = dataList;
        moduleData$1.showData = "visible";
    } else {
        await showError();
        moduleData$1.showData = "gone";
    }
}

function handleItem(item, index) {
    item.index = index;
    if (index === 0) {
        item.expandStatusRes = "@drawable/edge_engine_strutured_arrow_up";
        item.childVis = "visible";
    } else {
        item.expandStatusRes = "@drawable/edge_engine_strutured_arrow_down";
        item.childVis = "gone";
    }
    item.type = "normal";
}

function handleChildItem(childItem) {
    childItem.itemType = "1";
    var isSupport = false;
    if (childItem.platform === 3 || childItem.platform === 1) {
        isSupport = true;
    }
    if (childItem.status === true && isSupport === true && childItem.isResourceExist === true) {
        childItem.statusDesc = "可用";
    } else {
        childItem.statusDesc = "不可用";
    }
}

function getNavConfigString$1() {
    let nav = {
        title: "RMS"
    };
    return nav;
}

async function showError() {
    $nativeAPI.hbToast("加载失败");
    moduleData$1.showData = "gone";
}

moduleEvent$1.itemClick = function(index) {
    console.log(`itemClick : ${index}    ${moduleData$1.rmslist[index].childs}`);
    var tempElement = moduleData$1.rmslist[index];
    if (tempElement.childVis === "gone") {
        tempElement.childVis = "visible";
        tempElement.expandStatusRes = "@drawable/edge_engine_strutured_arrow_up";
    } else {
        tempElement.childVis = "gone";
        tempElement.expandStatusRes = "@drawable/edge_engine_strutured_arrow_down";
    }
};

moduleEvent$1.productClick = function(parentIndex, childIndex) {
    moduleData$1.rmslist[parentIndex];
    moduleData$1.rmslist[parentIndex].list[childIndex];
};

const cacehModeName = "debugmode";

const cacehKey = "openTime";

var inputText = "";

function defaultData() {
    return {};
}

const {moduleData: moduleData, moduleEvent: moduleEvent} = moduleDefine("debugmode", defaultData, {
    onCreate: onCreate,
    onDestroy: onDestroy,
    onResume: onResume,
    onPause: onPause,
    onStart: onStart,
    onStop: onStop
});

async function onCreate(eventParams) {
    moduleData.navConfig = getNavConfigString();
    const strTimestamp = await read(cacehModeName, cacehKey);
    const numTimestamp = parseInt(strTimestamp);
    const currentTs = Date.now();
    if (checkTimestampDiff(currentTs, numTimestamp) == true) {
        moduleData.infoShow = "visible";
        moduleData.inputShow = "gone";
    } else {
        moduleData.infoShow = "gone";
        moduleData.inputShow = "visible";
    }
}

function onDestroy() {}

function onResume() {}

function onPause() {}

async function onStart() {}

function onStop() {}

function getNavConfigString() {
    let nav = {
        title: "离线化信息开关配置"
    };
    return nav;
}

moduleEvent.openInfo = async function() {
    const currentTs = Date.now();
    const numTimestamp = parseInt(inputText);
    if (checkTimestampDiff(numTimestamp, currentTs) == true) {
        await save(cacehModeName, cacehKey, numTimestamp);
        moduleData.infoShow = "visible";
        moduleData.inputShow = "gone";
    }
};

moduleEvent.updateInput = function(text) {
    inputText = text;
};

moduleEvent.onFocusChange = async function(hasFocus) {};

function checkTimestampDiff(ts, cacheTs) {
    const diffInMillis = Math.abs(ts - cacheTs);
    const diffInHours = diffInMillis / (1e3 * 60 * 60);
    return diffInHours <= 1 && diffInHours >= -1;
}

function sendCommonConfig(param) {}

$event.sendCommonConfig = sendCommonConfig;
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWFpbi5qcyIsInNvdXJjZXMiOlsiLi4vLi4vcmVwb3NpdG9yeS9zcmMvY29tbW9uLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvaW5mb2xpc3QuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9kZWJ1Z21vZGUuanMiLCIuLi8uLi9yZXBvc2l0b3J5L3NyYy9tYWluLmpzIl0sInNvdXJjZXNDb250ZW50IjpbIlxuXG5leHBvcnQgZnVuY3Rpb24gbW9kdWxlRGVmaW5lKG1vZHVsZU5hbWUsIGRlZmF1bHREYXRhRnVuY3Rpb24sIGZ1bmN0aW9ucyA9IHsgb25DcmVhdGUsIG9uRGVzdHJveSwgb25SZXN1bWUsIG9uUGF1c2UsIG9uU3RhcnQsIG9uU3RvcCB9KSB7XG4gICAgY29uc29sZS5sb2coYGxvYWRNb2R1bGVgLCBtb2R1bGVOYW1lKTtcbiAgICAkZGF0YVttb2R1bGVOYW1lXSA9IGRlZmF1bHREYXRhRnVuY3Rpb24oKTtcbiAgICAkZXZlbnRbbW9kdWxlTmFtZV0gPSB7XG4gICAgICAgIG9uQ3JlYXRlOiB0eXBlb2YgZnVuY3Rpb25zLm9uQ3JlYXRlID09ICd1bmRlZmluZWQnID8gb25DcmVhdGUgOiBmdW5jdGlvbnMub25DcmVhdGUsXG4gICAgICAgIG9uRGVzdHJveTogdHlwZW9mIGZ1bmN0aW9ucy5vbkRlc3Ryb3kgPT0gJ3VuZGVmaW5lZCcgPyBvbkRlc3Ryb3kgOiBmdW5jdGlvbnMub25EZXN0cm95LFxuICAgICAgICBvblJlc3VtZTogdHlwZW9mIGZ1bmN0aW9ucy5vblJlc3VtZSA9PSAndW5kZWZpbmVkJyA/IG9uUmVzdW1lIDogZnVuY3Rpb25zLm9uUmVzdW1lLFxuICAgICAgICBvblBhdXNlOiB0eXBlb2YgZnVuY3Rpb25zLm9uUGF1c2UgPT0gJ3VuZGVmaW5lZCcgPyBvblBhdXNlIDogZnVuY3Rpb25zLm9uUGF1c2UsXG4gICAgICAgIG9uU3RhcnQ6IHR5cGVvZiBmdW5jdGlvbnMub25TdGFydCA9PSAndW5kZWZpbmVkJyA/IG9uU3RhcnQgOiBmdW5jdGlvbnMub25TdGFydCxcbiAgICAgICAgb25TdG9wOiB0eXBlb2YgZnVuY3Rpb25zLm9uU3RvcCA9PSAndW5kZWZpbmVkJyA/IG9uU3RvcCA6IGZ1bmN0aW9ucy5vblN0b3AsXG4gICAgfTtcbiAgICByZXR1cm4ge1xuICAgICAgICBtb2R1bGVEYXRhOiAkZGF0YVttb2R1bGVOYW1lXSxcbiAgICAgICAgbW9kdWxlRXZlbnQ6ICRldmVudFttb2R1bGVOYW1lXVxuICAgIH07XG59XG5cbmZ1bmN0aW9uIG9uQ3JlYXRlKCkge1xuICAgIGNvbnNvbGUubG9nKCdjb21tb24gb25DcmVhdGUnKTtcbn1cblxuZnVuY3Rpb24gb25EZXN0cm95KCkge1xufVxuXG5mdW5jdGlvbiBvblJlc3VtZSgpIHtcbn1cblxuZnVuY3Rpb24gb25QYXVzZSgpIHtcbn1cblxuZnVuY3Rpb24gb25TdGFydCgpIHtcbn1cblxuZnVuY3Rpb24gb25TdG9wKCkge1xufVxuXG4vL+WuueWZqOi/lOWbnuiDveWKm1xuZXhwb3J0IGZ1bmN0aW9uIGNvbnRhaW5lckJhY2soKSB7XG4gICAgY29uc29sZS5sb2coXCJjb250YWluZXJCYWNrXCIpXG4gICAgJG5hdGl2ZUFQSS5jb250YWluZXJCYWNrKClcbn1cblxuLy90b2FzdFxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNob3dUb2FzdChtc2cpIHtcbiAgICBhd2FpdCAkbmF0aXZlQVBJLmhiVG9hc3QobXNnKTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGdldENvbW1vbkNvbmZpZyhwYXJhbSkge1xuXG59XG5cblxuXG4vL+S/neWtmOaVsOaNrlxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNhdmUobW9kdWxlLCBrZXksIGRhdGEpIHtcbiAgICBhd2FpdCAkbmF0aXZlQVBJLnN0b3JhZ2Uoe1xuICAgICAgICBhY3Rpb246IFwic2F2ZVwiLFxuICAgIG5hbWU6IG1vZHVsZSxcbiAgICAgICAga2V5OiBrZXksXG4gICAgICAgIGRhdGE6IEpTT04uc3RyaW5naWZ5KGRhdGEpXG4gICAgfSk7XG59XG5cbi8v6K+75Y+W5pWw5o2uXG5leHBvcnQgYXN5bmMgZnVuY3Rpb24gcmVhZChtb2R1bGUsIGtleSkge1xuICAgIGNvbnN0IGRhdGEgPSBhd2FpdCAkbmF0aXZlQVBJLnN0b3JhZ2Uoe1xuICAgICAgICBhY3Rpb246IFwicmVhZFwiLFxuICAgICAgICBuYW1lOiBtb2R1bGUsXG4gICAgICAgIGtleToga2V5XG4gICAgfSk7XG4gICAgaWYgKGRhdGEgJiYgZGF0YSAhPSBcIlwiKSB7XG4gICAgICAgIGNvbnN0IHZhbHVlID0gSlNPTi5wYXJzZShkYXRhKTtcbiAgICAgICAgcmV0dXJuIHZhbHVlXG4gICAgfVxuICAgIHJldHVybiBudWxsO1xufSIsImltcG9ydCAqIGFzIGNvbW1vbiBmcm9tIFwiLi9jb21tb25cIjtcblxuLy8gaG9saWdlaXQ6Ly9vcGVuL3YxP2xvZ2luPTAmdXJsPWlodW9iaWdsb2JhbDovL20uaGJnLmNvbS9lZGdlZW5naW5lL2NvbnRhaW5lcj9zY2VuZT10ZW1wbGF0ZWluZm8mcm9vdE5hbWU9aW5mb2xpc3QmbmF2Q29uZmlnPW5hdGl2ZSZjb2RlPTkyNzRjM2U3OTg1YmNkOGFcblxuLy90ZW1wbGF0ZWluZm86MzLkuLptZDXliqDlr4YxNuS9jeWwj+WGmVxudmFyIGxvY2FsQ29kZSA9IFwiOTI3NGMzZTc5ODViY2Q4YVwiO1xuXG52YXIgZmxhZyA9IGZhbHNlXG5cbmZ1bmN0aW9uIGRlZmF1bHREYXRhKCkge1xuICAgIHJldHVybiB7XG4gICAgICAgIHJtc2xpc3Q6IFtdXG4gICAgfVxufVxuXG5jb25zdCB7IG1vZHVsZURhdGEsIG1vZHVsZUV2ZW50IH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFwiaW5mb2xpc3RcIiwgZGVmYXVsdERhdGEsIHsgb25DcmVhdGUsIG9uRGVzdHJveSwgb25SZXN1bWUsIG9uUGF1c2UsIG9uU3RhcnQsIG9uU3RvcH0pO1xuXG5hc3luYyBmdW5jdGlvbiBvbkNyZWF0ZShldmVudFBhcmFtcykge1xuICAgIG1vZHVsZURhdGEubmF2Q29uZmlnID0gZ2V0TmF2Q29uZmlnU3RyaW5nKCk7XG5cbiAgICBpZiAoZXZlbnRQYXJhbXMgJiYgZXZlbnRQYXJhbXMgIT0gbnVsbCkge1xuICAgICAgICBjb25zdCBwYXJhbXMgPSBKU09OLnBhcnNlKGV2ZW50UGFyYW1zKTtcbiAgICAgICAgY29uc3QgcGFyYW1zQ29kZSA9IHBhcmFtcy5jb2RlID8gcGFyYW1zLmNvZGUgOiBcIlwiO1xuICAgICAgICBpZiAobG9jYWxDb2RlID09PSAgcGFyYW1zQ29kZSkge1xuICAgICAgICAgICAgZmxhZyA9IHRydWVcbiAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIGZsYWcgPSBmYWxzZVxuICAgICAgICB9XG4gICAgfVxuICB9XG4gIFxuZnVuY3Rpb24gb25EZXN0cm95KCkge1xuICBcbn1cbiAgXG5mdW5jdGlvbiBvblJlc3VtZSgpIHsgIFxufVxuXG4gIFxuZnVuY3Rpb24gb25QYXVzZSgpIHtcbn1cbiAgXG5hc3luYyBmdW5jdGlvbiBvblN0YXJ0KCkge1xuICAgIGlmIChmbGFnID09PSB0cnVlKSB7XG4gICAgICAgIGF3YWl0IGJ1aWxkTGlzdERhdGEoKTtcbiAgICB9IGVsc2Uge1xuICAgICAgICBhd2FpdCBzaG93RXJyb3IoKTtcbiAgICB9XG59XG4gIFxuZnVuY3Rpb24gb25TdG9wKCkge1xuICBcbn1cblxuYXN5bmMgZnVuY3Rpb24gYnVpbGRMaXN0RGF0YSgpIHtcbiAgICBjb25zdCB0ZW1wUm1zSW5mbyA9IGF3YWl0ICRuYXRpdmVBUEkucm1zSW5mbygpO1xuICAgIGNvbnN0IHJtc0luZm8gPSBKU09OLnBhcnNlKHRlbXBSbXNJbmZvKTtcblxuICAgIHZhciBjdXJyZW50SW5kZXggPSAtMTtcbiAgICB2YXIgZGF0YUxpc3QgPSBbXTtcbiAgICBpZiAocm1zSW5mbykge1xuICAgICAgICBpZiAocm1zSW5mby5jdXJyZW50RWRnZUVuZ2luZSkge1xuICAgICAgICAgICAgdmFyIGl0ZW0gPSB7fTtcbiAgICAgICAgICAgIGl0ZW0ubmFtZSA9ICfnq6/kvqflvJXmk47ku6PnoIEnO1xuICAgICAgICAgICAgY3VycmVudEluZGV4ID0gY3VycmVudEluZGV4ICsgMTtcbiAgICAgICAgICAgIGhhbmRsZUl0ZW0oaXRlbSwgY3VycmVudEluZGV4KVxuICAgICAgICAgICAgdmFyIGFycmF5ID0gW107XG4gICAgICAgICAgICBmb3IgKHZhciBpID0gMDsgaSA8IHJtc0luZm8uY3VycmVudEVkZ2VFbmdpbmUubGVuZ3RoOyBpKyspIHtcbiAgICAgICAgICAgICAgICB2YXIgY2hpbGRJdGVtID0gcm1zSW5mby5jdXJyZW50RWRnZUVuZ2luZVtpXTtcbiAgICAgICAgICAgICAgICBoYW5kbGVDaGlsZEl0ZW0oY2hpbGRJdGVtKTtcbiAgICAgICAgICAgICAgICBhcnJheS5wdXNoKGNoaWxkSXRlbSk7XG4gICAgICAgICAgICB9O1xuICAgICAgICAgICAgaXRlbS5saXN0ID0gYXJyYXk7XG4gICAgICAgICAgICBkYXRhTGlzdC5wdXNoKGl0ZW0pXG4gICAgICAgIH1cblxuICAgICAgICBpZiAocm1zSW5mby5jdXJyZW50SDUpIHtcbiAgICAgICAgICAgIHZhciBpdGVtID0ge307XG4gICAgICAgICAgICBpdGVtLm5hbWUgPSAnSDXnprvnur/ljIUnO1xuICAgICAgICAgICAgY3VycmVudEluZGV4ID0gY3VycmVudEluZGV4ICsgMTtcbiAgICAgICAgICAgIGhhbmRsZUl0ZW0oaXRlbSwgY3VycmVudEluZGV4KVxuICAgICAgICAgICAgdmFyIGFycmF5ID0gW107XG4gICAgICAgICAgICBmb3IgKHZhciBpID0gMDsgaSA8IHJtc0luZm8uY3VycmVudEg1Lmxlbmd0aDsgaSsrKSB7XG4gICAgICAgICAgICAgICAgdmFyIGNoaWxkSXRlbSA9IHJtc0luZm8uY3VycmVudEg1W2ldO1xuICAgICAgICAgICAgICAgIGhhbmRsZUNoaWxkSXRlbShjaGlsZEl0ZW0pO1xuICAgICAgICAgICAgICAgIGFycmF5LnB1c2goY2hpbGRJdGVtKTtcbiAgICAgICAgICAgIH07XG4gICAgICAgICAgICBpdGVtLmxpc3QgPSBhcnJheTtcbiAgICAgICAgICAgIGRhdGFMaXN0LnB1c2goaXRlbSlcbiAgICAgICAgfVxuXG4gICAgICAgIGlmIChybXNJbmZvLmN1cnJlbnRTa2luKSB7XG4gICAgICAgICAgICB2YXIgaXRlbSA9IHt9O1xuICAgICAgICAgICAgaXRlbS5uYW1lID0gJ0FwcOa0u+WKqOearuiCpCc7XG4gICAgICAgICAgICBjdXJyZW50SW5kZXggPSBjdXJyZW50SW5kZXggKyAxO1xuICAgICAgICAgICAgaGFuZGxlSXRlbShpdGVtLCBjdXJyZW50SW5kZXgpXG4gICAgICAgICAgICB2YXIgYXJyYXkgPSBbXTtcbiAgICAgICAgICAgIGZvciAodmFyIGkgPSAwOyBpIDwgcm1zSW5mby5jdXJyZW50U2tpbi5sZW5ndGg7IGkrKykge1xuICAgICAgICAgICAgICAgIHZhciBjaGlsZEl0ZW0gPSBybXNJbmZvLmN1cnJlbnRTa2luW2ldO1xuICAgICAgICAgICAgICAgIGhhbmRsZUNoaWxkSXRlbShjaGlsZEl0ZW0pO1xuICAgICAgICAgICAgICAgIGFycmF5LnB1c2goY2hpbGRJdGVtKTtcbiAgICAgICAgICAgIH07XG4gICAgICAgICAgICBpdGVtLmxpc3QgPSBhcnJheTtcbiAgICAgICAgICAgIGRhdGFMaXN0LnB1c2goaXRlbSlcbiAgICAgICAgfVxuXG4gICAgICAgIGlmIChybXNJbmZvLmN1cnJlbnRBcHBSZXNvdXJjZXMpIHtcbiAgICAgICAgICAgIHZhciBpdGVtID0ge307XG4gICAgICAgICAgICBpdGVtLm5hbWUgPSAn6aKc6ImyJuWkmuivreiogOWKqOaAgeWMhSc7XG4gICAgICAgICAgICBjdXJyZW50SW5kZXggPSBjdXJyZW50SW5kZXggKyAxO1xuICAgICAgICAgICAgaGFuZGxlSXRlbShpdGVtLCBjdXJyZW50SW5kZXgpXG4gICAgICAgICAgICB2YXIgYXJyYXkgPSBbXTtcbiAgICAgICAgICAgIGZvciAodmFyIGkgPSAwOyBpIDwgcm1zSW5mby5jdXJyZW50QXBwUmVzb3VyY2VzLmxlbmd0aDsgaSsrKSB7XG4gICAgICAgICAgICAgICAgdmFyIGNoaWxkSXRlbSA9IHJtc0luZm8uY3VycmVudEFwcFJlc291cmNlc1tpXTtcbiAgICAgICAgICAgICAgICBoYW5kbGVDaGlsZEl0ZW0oY2hpbGRJdGVtKTtcbiAgICAgICAgICAgICAgICBhcnJheS5wdXNoKGNoaWxkSXRlbSk7XG4gICAgICAgICAgICB9O1xuICAgICAgICAgICAgaXRlbS5saXN0ID0gYXJyYXk7XG4gICAgICAgICAgICBkYXRhTGlzdC5wdXNoKGl0ZW0pXG4gICAgICAgIH1cbiAgICAgICAgbW9kdWxlRGF0YS5ybXNsaXN0ID0gZGF0YUxpc3Q7XG4gICAgICAgIG1vZHVsZURhdGEuc2hvd0RhdGEgPSBcInZpc2libGVcIjtcbiAgICB9IGVsc2Uge1xuICAgICAgICBhd2FpdCBzaG93RXJyb3IoKTtcbiAgICAgICAgbW9kdWxlRGF0YS5zaG93RGF0YSA9IFwiZ29uZVwiO1xuICAgIH1cbn1cblxuZnVuY3Rpb24gaGFuZGxlSXRlbShpdGVtLCBpbmRleCkge1xuICAgIGl0ZW0uaW5kZXggPSBpbmRleDtcbiAgICBpZiAoaW5kZXggPT09IDApIHtcbiAgICAgICAgaXRlbS5leHBhbmRTdGF0dXNSZXMgPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zdHJ1dHVyZWRfYXJyb3dfdXBcIlxuICAgICAgICBpdGVtLmNoaWxkVmlzID0gJ3Zpc2libGUnO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIGl0ZW0uZXhwYW5kU3RhdHVzUmVzID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc3RydXR1cmVkX2Fycm93X2Rvd25cIlxuICAgICAgICBpdGVtLmNoaWxkVmlzID0gXCJnb25lXCJcbiAgICB9XG5cbiAgICBpdGVtLnR5cGUgPSBcIm5vcm1hbFwiO1xuXG59XG5cbmZ1bmN0aW9uIGhhbmRsZUNoaWxkSXRlbShjaGlsZEl0ZW0pIHtcbiAgICBjaGlsZEl0ZW0uaXRlbVR5cGUgPSBcIjFcIjtcbiAgICB2YXIgaXNTdXBwb3J0ID0gZmFsc2U7XG4gICAgaWYgKGNoaWxkSXRlbS5wbGF0Zm9ybSA9PT0gMyB8fCBjaGlsZEl0ZW0ucGxhdGZvcm0gPT09IDEpIHtcbiAgICAgICAgaXNTdXBwb3J0ID0gdHJ1ZTtcbiAgICB9XG4gICAgaWYgKGNoaWxkSXRlbS5zdGF0dXMgPT09IHRydWUgJiYgaXNTdXBwb3J0ID09PSB0cnVlICYmIGNoaWxkSXRlbS5pc1Jlc291cmNlRXhpc3QgPT09IHRydWUpIHtcbiAgICAgICAgY2hpbGRJdGVtLnN0YXR1c0Rlc2MgPSBcIuWPr+eUqFwiO1xuICAgIH0gZWxzZSB7XG4gICAgICAgIGNoaWxkSXRlbS5zdGF0dXNEZXNjID0gXCLkuI3lj6/nlKhcIjtcbiAgICB9XG59XG5cbmZ1bmN0aW9uIGdldE5hdkNvbmZpZ1N0cmluZygpIHtcbiAgICBsZXQgbmF2ID0ge1xuICAgICAgICAndGl0bGUnOiAnUk1TJ1xuICAgIH07XG4gICAgcmV0dXJuIG5hdjtcbn1cblxuYXN5bmMgZnVuY3Rpb24gc2hvd0Vycm9yKCkge1xuICAgICRuYXRpdmVBUEkuaGJUb2FzdChcIuWKoOi9veWksei0pVwiKTtcbiAgICBtb2R1bGVEYXRhLnNob3dEYXRhID0gXCJnb25lXCI7XG59XG5cblxubW9kdWxlRXZlbnQuaXRlbUNsaWNrID0gZnVuY3Rpb24gKGluZGV4KSB7XG5cbiAgICBjb25zb2xlLmxvZyhgaXRlbUNsaWNrIDogJHtpbmRleH0gICAgJHttb2R1bGVEYXRhLnJtc2xpc3RbaW5kZXhdLmNoaWxkc31gKTtcblxuICAgIHZhciB0ZW1wRWxlbWVudCA9IG1vZHVsZURhdGEucm1zbGlzdFtpbmRleF1cblxuICAgIGlmICh0ZW1wRWxlbWVudC5jaGlsZFZpcyA9PT0gXCJnb25lXCIpIHtcbiAgICAgICAgdGVtcEVsZW1lbnQuY2hpbGRWaXMgPSBcInZpc2libGVcIlxuICAgICAgICB0ZW1wRWxlbWVudC5leHBhbmRTdGF0dXNSZXMgPSBcIkBkcmF3YWJsZS9lZGdlX2VuZ2luZV9zdHJ1dHVyZWRfYXJyb3dfdXBcIlxuICAgIH0gZWxzZSB7XG4gICAgICAgIHRlbXBFbGVtZW50LmNoaWxkVmlzID0gXCJnb25lXCJcbiAgICAgICAgdGVtcEVsZW1lbnQuZXhwYW5kU3RhdHVzUmVzID0gXCJAZHJhd2FibGUvZWRnZV9lbmdpbmVfc3RydXR1cmVkX2Fycm93X2Rvd25cIlxuICAgIH1cbn1cblxubW9kdWxlRXZlbnQucHJvZHVjdENsaWNrID0gZnVuY3Rpb24gKHBhcmVudEluZGV4LCBjaGlsZEluZGV4KSB7XG5cbiAgICBsZXQgcGFyZW50RWxlbWVudCA9IG1vZHVsZURhdGEucm1zbGlzdFtwYXJlbnRJbmRleF07XG4gICAgbGV0IGNoaWxkRWxlbWVudCA9IG1vZHVsZURhdGEucm1zbGlzdFtwYXJlbnRJbmRleF0ubGlzdFtjaGlsZEluZGV4XTtcbn0iLCJpbXBvcnQgKiBhcyBjb21tb24gZnJvbSBcIi4vY29tbW9uXCI7XG5cbi8vIGhvbGlnZWl0Oi8vb3Blbi92MT9sb2dpbj0wJnVybD1paHVvYmlnbG9iYWw6Ly9tLmhiZy5jb20vZWRnZWVuZ2luZS9jb250YWluZXI/c2NlbmU9dGVtcGxhdGVpbmZvJnJvb3ROYW1lPWRlYnVnbW9kZSZuYXZDb25maWc9bmF0aXZlXG5cbmNvbnN0IGNhY2VoTW9kZU5hbWUgPSAnZGVidWdtb2RlJ1xuY29uc3QgY2FjZWhLZXkgPSAnb3BlblRpbWUnXG5cbnZhciBmbGFnID0gZmFsc2VcblxudmFyIGlucHV0VGV4dCA9ICcnXG5cbmZ1bmN0aW9uIGRlZmF1bHREYXRhKCkge1xuICAgIHJldHVybiB7XG4gICAgfVxufVxuXG5jb25zdCB7IG1vZHVsZURhdGEsIG1vZHVsZUV2ZW50IH0gPSBjb21tb24ubW9kdWxlRGVmaW5lKFwiZGVidWdtb2RlXCIsIGRlZmF1bHREYXRhLCB7IG9uQ3JlYXRlLCBvbkRlc3Ryb3ksIG9uUmVzdW1lLCBvblBhdXNlLCBvblN0YXJ0LCBvblN0b3B9KTtcblxuYXN5bmMgZnVuY3Rpb24gb25DcmVhdGUoZXZlbnRQYXJhbXMpIHtcbiAgICBtb2R1bGVEYXRhLm5hdkNvbmZpZyA9IGdldE5hdkNvbmZpZ1N0cmluZygpO1xuXG4gICAgY29uc3Qgc3RyVGltZXN0YW1wID0gYXdhaXQgY29tbW9uLnJlYWQoY2FjZWhNb2RlTmFtZSwgY2FjZWhLZXkpXG4gICAgY29uc3QgbnVtVGltZXN0YW1wID0gcGFyc2VJbnQoc3RyVGltZXN0YW1wKTtcblxuICAgIGNvbnN0IGN1cnJlbnRUcyA9IERhdGUubm93KCk7XG4gICAgaWYgKGNoZWNrVGltZXN0YW1wRGlmZihjdXJyZW50VHMsIG51bVRpbWVzdGFtcCkgPT0gdHJ1ZSkge1xuICAgICAgICAvL+W3suW8gOWQr1xuICAgICAgICBtb2R1bGVEYXRhLmluZm9TaG93ID0gJ3Zpc2libGUnXG4gICAgICAgIG1vZHVsZURhdGEuaW5wdXRTaG93ID0gJ2dvbmUnXG4gICAgfSBlbHNlIHtcbiAgICAgICAgLy/pnIDopoHlvIDlkK9cbiAgICAgICAgbW9kdWxlRGF0YS5pbmZvU2hvdyA9ICdnb25lJ1xuICAgICAgICBtb2R1bGVEYXRhLmlucHV0U2hvdyA9ICd2aXNpYmxlJ1xuICAgIH1cbn1cbiAgXG5mdW5jdGlvbiBvbkRlc3Ryb3koKSB7XG59XG4gIFxuZnVuY3Rpb24gb25SZXN1bWUoKSB7ICBcbn1cblxuICBcbmZ1bmN0aW9uIG9uUGF1c2UoKSB7XG59XG4gIFxuYXN5bmMgZnVuY3Rpb24gb25TdGFydCgpIHtcbn1cbiAgXG5mdW5jdGlvbiBvblN0b3AoKSB7XG4gIFxufVxuXG5mdW5jdGlvbiBnZXROYXZDb25maWdTdHJpbmcoKSB7XG4gICAgbGV0IG5hdiA9IHtcbiAgICAgICAgJ3RpdGxlJzogJ+emu+e6v+WMluS/oeaBr+W8gOWFs+mFjee9ridcbiAgICB9O1xuICAgIHJldHVybiBuYXY7XG59XG5cbm1vZHVsZUV2ZW50Lm9wZW5JbmZvID0gYXN5bmMgZnVuY3Rpb24gKCkge1xuICAgIGNvbnN0IGN1cnJlbnRUcyA9IERhdGUubm93KClcbiAgICBjb25zdCBudW1UaW1lc3RhbXAgPSBwYXJzZUludChpbnB1dFRleHQpXG4gICAgaWYgKGNoZWNrVGltZXN0YW1wRGlmZihudW1UaW1lc3RhbXAsIGN1cnJlbnRUcykgPT0gdHJ1ZSkge1xuICAgICAgIGF3YWl0IGNvbW1vbi5zYXZlKGNhY2VoTW9kZU5hbWUsIGNhY2VoS2V5LCBudW1UaW1lc3RhbXApXG4gICAgICAgbW9kdWxlRGF0YS5pbmZvU2hvdyA9ICd2aXNpYmxlJ1xuICAgICAgIG1vZHVsZURhdGEuaW5wdXRTaG93ID0gJ2dvbmUnXG4gICAgfVxufVxuXG5tb2R1bGVFdmVudC51cGRhdGVJbnB1dCA9IGZ1bmN0aW9uICh0ZXh0KSB7XG4gICAgaW5wdXRUZXh0ID0gdGV4dFxufVxuXG5tb2R1bGVFdmVudC5vbkZvY3VzQ2hhbmdlID0gYXN5bmMgZnVuY3Rpb24gKGhhc0ZvY3VzKSB7XG4gICAgaWYgKGhhc0ZvY3VzKSB7XG4gICAgICBcbiAgICB9XG59XG5cbmZ1bmN0aW9uIGNoZWNrVGltZXN0YW1wRGlmZih0cywgY2FjaGVUcykge1xuICAgIGNvbnN0IGRpZmZJbk1pbGxpcyA9IE1hdGguYWJzKHRzIC0gY2FjaGVUcylcbiAgICBjb25zdCBkaWZmSW5Ib3VycyA9IGRpZmZJbk1pbGxpcyAvICgxMDAwICogNjAgKiA2MClcbiAgICByZXR1cm4gKGRpZmZJbkhvdXJzIDw9IDEgJiYgZGlmZkluSG91cnMgPj0gLTEpXG59IiwiaW1wb3J0ICogYXMgY29tbW9uIGZyb20gXCIuL2NvbW1vblwiO1xuaW1wb3J0ICogYXMgaW5mb2xpc3QgZnJvbSBcIi4vaW5mb2xpc3RcIjtcbmltcG9ydCAqIGFzIGRlYnVnbW9kZSBmcm9tIFwiLi9kZWJ1Z21vZGVcIjtcblxuZnVuY3Rpb24gc2VuZENvbW1vbkNvbmZpZyhwYXJhbSkge1xuICAgIGNvbW1vbi5nZXRDb21tb25Db25maWcocGFyYW0pO1xuICB9XG4gIFxuICAkZXZlbnQuc2VuZENvbW1vbkNvbmZpZyA9IHNlbmRDb21tb25Db25maWc7XG4gICJdLCJuYW1lcyI6WyJtb2R1bGVEZWZpbmUiLCJtb2R1bGVOYW1lIiwiZGVmYXVsdERhdGFGdW5jdGlvbiIsImZ1bmN0aW9ucyIsIm9uQ3JlYXRlIiwib25EZXN0cm95Iiwib25SZXN1bWUiLCJvblBhdXNlIiwib25TdGFydCIsIm9uU3RvcCIsImNvbnNvbGUiLCJsb2ciLCIkZGF0YSIsIiRldmVudCIsIm1vZHVsZURhdGEiLCJtb2R1bGVFdmVudCIsImFzeW5jIiwic2F2ZSIsIm1vZHVsZSIsImtleSIsImRhdGEiLCIkbmF0aXZlQVBJIiwic3RvcmFnZSIsImFjdGlvbiIsIm5hbWUiLCJKU09OIiwic3RyaW5naWZ5IiwicmVhZCIsInZhbHVlIiwicGFyc2UiLCJsb2NhbENvZGUiLCJmbGFnIiwiZGVmYXVsdERhdGEiLCJybXNsaXN0IiwiY29tbW9uLm1vZHVsZURlZmluZSIsImV2ZW50UGFyYW1zIiwibmF2Q29uZmlnIiwiZ2V0TmF2Q29uZmlnU3RyaW5nIiwicGFyYW1zIiwicGFyYW1zQ29kZSIsImNvZGUiLCJidWlsZExpc3REYXRhIiwic2hvd0Vycm9yIiwidGVtcFJtc0luZm8iLCJybXNJbmZvIiwiY3VycmVudEluZGV4IiwiZGF0YUxpc3QiLCJjdXJyZW50RWRnZUVuZ2luZSIsIml0ZW0iLCJoYW5kbGVJdGVtIiwiYXJyYXkiLCJpIiwibGVuZ3RoIiwiY2hpbGRJdGVtIiwiaGFuZGxlQ2hpbGRJdGVtIiwicHVzaCIsImxpc3QiLCJjdXJyZW50SDUiLCJjdXJyZW50U2tpbiIsImN1cnJlbnRBcHBSZXNvdXJjZXMiLCJzaG93RGF0YSIsImluZGV4IiwiZXhwYW5kU3RhdHVzUmVzIiwiY2hpbGRWaXMiLCJ0eXBlIiwiaXRlbVR5cGUiLCJpc1N1cHBvcnQiLCJwbGF0Zm9ybSIsInN0YXR1cyIsImlzUmVzb3VyY2VFeGlzdCIsInN0YXR1c0Rlc2MiLCJuYXYiLCJ0aXRsZSIsImhiVG9hc3QiLCJpdGVtQ2xpY2siLCJjaGlsZHMiLCJ0ZW1wRWxlbWVudCIsInByb2R1Y3RDbGljayIsInBhcmVudEluZGV4IiwiY2hpbGRJbmRleCIsImNhY2VoTW9kZU5hbWUiLCJjYWNlaEtleSIsImlucHV0VGV4dCIsInN0clRpbWVzdGFtcCIsImNvbW1vbi5yZWFkIiwibnVtVGltZXN0YW1wIiwicGFyc2VJbnQiLCJjdXJyZW50VHMiLCJEYXRlIiwibm93IiwiY2hlY2tUaW1lc3RhbXBEaWZmIiwiaW5mb1Nob3ciLCJpbnB1dFNob3ciLCJvcGVuSW5mbyIsImNvbW1vbi5zYXZlIiwidXBkYXRlSW5wdXQiLCJ0ZXh0Iiwib25Gb2N1c0NoYW5nZSIsImhhc0ZvY3VzIiwidHMiLCJjYWNoZVRzIiwiZGlmZkluTWlsbGlzIiwiTWF0aCIsImFicyIsImRpZmZJbkhvdXJzIiwic2VuZENvbW1vbkNvbmZpZyIsInBhcmFtIl0sIm1hcHBpbmdzIjoiQUFFTyxTQUFTQSxhQUFhQyxZQUFZQyxxQkFBcUJDLFlBQVk7SUFBRUMsVUFBQUE7ZUFBVUM7SUFBU0MsVUFBRUE7SUFBVUMsU0FBQUE7YUFBU0M7SUFBT0MsUUFBRUE7O0lBQ3pIQyxRQUFRQyxJQUFJLGNBQWNWO0lBQzFCVyxNQUFNWCxjQUFjQztJQUNwQlcsT0FBT1osY0FBYztRQUNqQkcsaUJBQWlCRCxVQUFVQyxZQUFZLGNBQWNBLGFBQVdELFVBQVVDO1FBQzFFQyxrQkFBa0JGLFVBQVVFLGFBQWEsY0FBY0EsY0FBWUYsVUFBVUU7UUFDN0VDLGlCQUFpQkgsVUFBVUcsWUFBWSxjQUFjQSxhQUFXSCxVQUFVRztRQUMxRUMsZ0JBQWdCSixVQUFVSSxXQUFXLGNBQWNBLFlBQVVKLFVBQVVJO1FBQ3ZFQyxnQkFBZ0JMLFVBQVVLLFdBQVcsY0FBY0EsWUFBVUwsVUFBVUs7UUFDdkVDLGVBQWVOLFVBQVVNLFVBQVUsY0FBY0EsV0FBU04sVUFBVU07O0lBRXhFLE9BQU87UUFDSEssWUFBWUYsTUFBTVg7UUFDbEJjLGFBQWFGLE9BQU9aOztBQUU1Qjs7QUFFQSxTQUFTRztJQUNMTSxRQUFRQyxJQUFJO0FBQ2hCOztBQUVBLFNBQVNOLGVBQ1Q7O0FBRUEsU0FBU0MsY0FDVDs7QUFFQSxTQUFTQyxhQUNUOztBQUVBLFNBQVNDLGFBQ1Q7O0FBRUEsU0FBU0Ms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
