var commanData = {
    colorMode: 0,
    OS: "",
    language: ""
};

async function sendRequest(path, params = {}, method = 0, hostType = 1, header = {}) {
    console.log(`request ${path}`);
    const param = {
        path: path,
        method: method,
        hostType: hostType,
        header: header,
        params: params
    };
    try {
        var responseString = responseString = await $nativeAPI.request(JSON.stringify(param));
        var response = JSON.parse(responseString);
        var {code: code} = response;
        if (code == 200) {
            console.log(`request ${path} done`);
            return response;
        } else {
            console.log(`request failed, code=${code}`);
            return response;
        }
    } catch (e) {
        console.log(`request error, error=${e}`);
        return null;
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

function parseCommonConfig(param) {
    commanData.colorMode = parseInt(param.colorMode);
    commanData.OS = parseInt(param.OS);
    commanData.language = param.language;
}

function parseRequestParams(requestJson) {
    if (typeof requestJson === "string" || requestJson instanceof String) {
        return JSON.parse(requestJson);
    }
    return requestJson;
}

async function searchMerchantDatas(text) {
    const params = {
        userName: text
    };
    console.log(JSON.stringify(params));
    const response = await sendRequest("v1/user/merchant/search", params);
    if (response) {
        if (response.success) {
            const {success: success, message: message, data: data} = response;
            console.log("searchMerchantDatas data loaded successfully:", data);
            return {
                datas: data,
                text: text
            };
        } else if (response.message !== undefined) {
            console.error("searchMerchantDatas data loaded Failed:", response.message);
            return {};
        }
    } else {
        return null;
    }
}

const {moduleData: moduleData, moduleEvent: moduleEvent} = moduleDefine("merchantSearchPage", (function() {
    console.log("merchantSearchPage loading....");
}), defaultData);

function defaultData() {
    console.log("merchantSearchPage defaultData....");
    return {
        listVisible: "invisible",
        emptyVisible: "gone",
        loadingVisible: "gone",
        loadingStatus: "stop",
        datas: [],
        searchInput: "",
        borderColor: "#00000000",
        inputClearButtonVisible: "gone",
        onFocus: "true",
        timeId: -1,
        additionalViewCententY: commanData.OS == 0 ? "180" : "90"
    };
}

async function searchMerchant() {
    if (moduleData.timeId != -1) {
        clearInterval(moduleData.timeId);
        moduleData.timeId = -1;
    }
    moduleData.emptyVisible = "gone";
    moduleData.listVisible = "invisible";
    moduleData.loadingVisible = "visible";
    moduleData.loadingStatus = "play";
    var res = await searchMerchantDatas(moduleData.searchInput);
    var showEmpty = true;
    try {
        if (res) {
            var {datas: datas, text: text} = res;
            if (text != moduleData.searchInput) {
                console.log(`searchMerchant error  text != moduleData.searchInput ${text} ${moduleData.searchInput}`);
                return;
            }
            console.log(`searchMerchant success  ${text} ${moduleData.searchInput}`);
            let viewModelsPromise = datas.map((async (data, i) => {
                var item = await formatDatas(data);
                item.index = i;
                return item;
            }));
            var viewModels = await Promise.all(viewModelsPromise);
            moduleData.datas = viewModels;
            showEmpty = viewModels.length == 0;
        }
        console.log(`searchMerchant res == null  ${text} ${res == null}`);
    } catch (error) {
        console.log(`searchMerchant error  ===== ${error}`);
    }
    console.log(`searchMerchant showEmpty  ${showEmpty}`);
    moduleData.loadingVisible = "gone";
    moduleData.loadingStatus = "stop";
    if (showEmpty) {
        moduleData.emptyVisible = "visible";
        moduleData.listVisible = "invisible";
    } else {
        moduleData.emptyVisible = "gone";
        moduleData.listVisible = "visible";
    }
}

async function formatDatas(item) {
    item.type = "searchCell";
    item.onlineColor = item.isOnline ? "#00A171" : "@color/kColorFourLevelText";
    item.brandIconVisible = item.isBrandUser ? "visible" : "gone";
    return item;
}

moduleEvent.onClickItem = function(index) {
    var item = moduleData.datas[index];
    $nativeAPI.merchantSearch({
        action: "goToMerchantPage",
        uid: item.uid
    });
};

moduleEvent.onClearClick = function() {
    moduleData.searchInput = "";
    moduleData.inputClearButtonVisible = "gone";
    moduleData.listVisible = "invisible";
    moduleData.emptyVisible = "gone";
    moduleData.loadingVisible = "gone";
    moduleData.loadingStatus = "stop";
};

moduleEvent.textChange = function(text) {
    moduleData.searchInput = text;
    if (moduleData.searchInput != null && moduleData.searchInput != "") {
        moduleData.inputClearButtonVisible = "visible";
        if (moduleData.searchInput.trim().length > 1) {
            let hasChinese = isHasChinese(moduleData.searchInput);
            if (hasChinese || moduleData.searchInput.trim().length > 3) {
                if (moduleData.timeId != -1) {
                    clearInterval(moduleData.timeId);
                }
                moduleData.timeId = setInterval(searchMerchant, 1e3);
            }
        }
    } else {
        moduleData.inputClearButtonVisible = "gone";
    }
    moduleData.listVisible = "invisible";
    moduleData.emptyVisible = "gone";
    moduleData.loadingVisible = "gone";
    moduleData.loadingStatus = "stop";
};

function isHasChinese(str) {
    for (var i = 0; i < str.length; i++) {
        var charCode = str.charCodeAt(i);
        if (charCode >= 19968 && charCode <= 40959) {
            return true;
        }
    }
    return false;
}

moduleEvent.searchMerchantClick = function() {
    if (moduleData.searchInput != null && moduleData.searchInput != "") {
        searchMerchant();
    }
};

moduleEvent.focusChange = function(hasFocus) {
    if (hasFocus) {
        moduleData.borderColor = "@color/KBaseColorMajorTheme100";
    } else {
        moduleData.borderColor = "#00000000";
    }
};

moduleEvent.onBackClick = function() {
    $nativeAPI.merchantSearch({
        action: "onBackClick"
    });
};

$event.start = async function() {};

$event.sendCommonConfig = function(param) {
    var vaildParams = parseRequestParams(param);
    parseCommonConfig(vaildParams);
};
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWFpbi5qcyIsInNvdXJjZXMiOlsiLi4vLi4vcmVwb3NpdG9yeS9zcmMvY29tbW9uLmpzIiwiLi4vLi4vcmVwb3NpdG9yeS9zcmMvc2VhcmNoTWVyY2hhbnREYXRhU2VydmljZS5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL21lcmNoYW50U2VhcmNoUGFnZS5qcyIsIi4uLy4uL3JlcG9zaXRvcnkvc3JjL21haW4uanMiXSwic291cmNlc0NvbnRlbnQiOlsiXG5leHBvcnQgdmFyIGNvbW1hbkRhdGEgPSB7XG4gICAgY29sb3JNb2RlOiAwLCAvLyAw55m95aSp77yMMem7keWknFxuICAgIE9TOiBcIlwiLCAvLyBcIjBcIjogaW9zOyBcIjFcIjogYW5kcm9pZFxuICAgIGxhbmd1YWdlOiBcIlwiLFxufTtcbi8v5Y+R6YCB6K+35rGCXG4vL2hvc3RUeXBlPTHotbBPVENfVVJMICBtZXRob2Q6IDAgZ2V077ybIDEgcG9zdFxuZXhwb3J0IGFzeW5jIGZ1bmN0aW9uIHNlbmRSZXF1ZXN0KHBhdGgsIHBhcmFtcyA9IHt9LCBtZXRob2QgPSAwLCBob3N0VHlwZSA9IDEsIGhlYWRlciA9IHt9KSB7XG4gICAgY29uc29sZS5sb2coYHJlcXVlc3QgJHtwYXRofWApO1xuICAgIGNvbnN0IHBhcmFtID0ge1xuICAgICAgICBwYXRoLFxuICAgICAgICBtZXRob2QsXG4gICAgICAgIGhvc3RUeXBlLFxuICAgICAgICBoZWFkZXIsXG4gICAgICAgIHBhcmFtc1xuICAgIH07XG4gICAgdHJ5IHtcbiAgICAgICAgdmFyIHJlc3BvbnNlU3RyaW5nID0gcmVzcG9uc2VTdHJpbmcgPSBhd2FpdCAkbmF0aXZlQVBJLnJlcXVlc3QoSlNPTi5zdHJpbmdpZnkocGFyYW0pKTtcbiAgICAgICAgdmFyIHJlc3BvbnNlID0gSlNPTi5wYXJzZShyZXNwb25zZVN0cmluZyk7XG4gICAgICAgIHZhciB7IGNvZGUgfSA9IHJlc3BvbnNlO1xuICAgICAgICBpZiAoY29kZSA9PSAyMDApIHtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0ICR7cGF0aH0gZG9uZWApO1xuICAgICAgICAgICAgcmV0dXJuIHJlc3BvbnNlO1xuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgICAgY29uc29sZS5sb2coYHJlcXVlc3QgZmFpbGVkLCBjb2RlPSR7Y29kZX1gKTtcbiAgICAgICAgICAgIHJldHVybiByZXNwb25zZTtcbiAgICAgICAgfVxuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgLy8gbmV0d29yayBlcnJvclxuICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCBlcnJvciwgZXJyb3I9JHtlfWApO1xuICAgICAgICByZXR1cm4gbnVsbDtcbiAgICB9XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBtb2R1bGVEZWZpbmUobW9kdWxlTmFtZSwgc3RhcnRGdW5jdGlvbiwgZGVmYXVsdERhdGFGdW5jdGlvbikge1xuICAgICRkYXRhW21vZHVsZU5hbWVdID0gZGVmYXVsdERhdGFGdW5jdGlvbigpO1xuICAgICRldmVudFttb2R1bGVOYW1lXSA9IHsgc3RhcnQ6IHN0YXJ0RnVuY3Rpb24gfTtcbiAgICByZXR1cm4ge1xuICAgICAgICBtb2R1bGVFdmVudDogJGV2ZW50W21vZHVsZU5hbWVdLFxuICAgICAgICBtb2R1bGVEYXRhOiAkZGF0YVttb2R1bGVOYW1lXVxuICAgIH07XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBwYXJzZUNvbW1vbkNvbmZpZyhwYXJhbSkge1xuICAgIGNvbW1hbkRhdGEuY29sb3JNb2RlID0gcGFyc2VJbnQocGFyYW0uY29sb3JNb2RlKTtcbiAgICBjb21tYW5EYXRhLk9TID0gcGFyc2VJbnQocGFyYW0uT1MpO1xuICAgIGNvbW1hbkRhdGEubGFuZ3VhZ2UgPSBwYXJhbS5sYW5ndWFnZTtcbn1cblxuLyoqXG4gKiDop6PmnpDor7fmsYLlj4LmlbBcbiAqIEBwYXJhbSB7T2JqZWN0fHN0cmluZ30gcmVxdWVzdEpzb24gLSDor7fmsYLlj4LmlbDvvIjlr7nosaHmiJZKU09O5a2X56ym5Liy77yJXG4gKiBAcmV0dXJucyB7T2JqZWN0fSDop6PmnpDlkI7nmoTlj4LmlbDlr7nosaFcbiAqL1xuZXhwb3J0IGZ1bmN0aW9uIHBhcnNlUmVxdWVzdFBhcmFtcyhyZXF1ZXN0SnNvbikge1xuICAgIGlmICh0eXBlb2YgcmVxdWVzdEpzb24gPT09IFwic3RyaW5nXCIgfHwgcmVxdWVzdEpzb24gaW5zdGFuY2VvZiBTdHJpbmcpIHtcbiAgICAgICAgcmV0dXJuIEpTT04ucGFyc2UocmVxdWVzdEpzb24pO1xuICAgIH1cbiAgICByZXR1cm4gcmVxdWVzdEpzb247XG59XG4iLCJpbXBvcnQgKiBhcyBjb21tb24gZnJvbSBcIi4vY29tbW9uXCJcblxuYXN5bmMgZnVuY3Rpb24gc2VhcmNoTWVyY2hhbnREYXRhcyh0ZXh0KSB7XG4gICAgY29uc3QgcGFyYW1zID0geyBcInVzZXJOYW1lXCI6IHRleHQgfVxuICAgIGNvbnNvbGUubG9nKEpTT04uc3RyaW5naWZ5KHBhcmFtcykpXG4gICAgY29uc3QgcmVzcG9uc2UgPSBhd2FpdCBjb21tb24uc2VuZFJlcXVlc3QoXCJ2MS91c2VyL21lcmNoYW50L3NlYXJjaFwiLCBwYXJhbXMpXG4gICAgaWYgKHJlc3BvbnNlKSB7XG4gICAgICAgIGlmIChyZXNwb25zZS5zdWNjZXNzKSB7XG4gICAgICAgICAgICBjb25zdCB7IHN1Y2Nlc3MsIG1lc3NhZ2UsIGRhdGEgfSA9IHJlc3BvbnNlXG4gICAgICAgICAgICBjb25zb2xlLmxvZyhcInNlYXJjaE1lcmNoYW50RGF0YXMgZGF0YSBsb2FkZWQgc3VjY2Vzc2Z1bGx5OlwiLCBkYXRhKVxuICAgICAgICAgICAgcmV0dXJuIHtcbiAgICAgICAgICAgICAgICBkYXRhczogZGF0YSxcbiAgICAgICAgICAgICAgICB0ZXh0LFxuICAgICAgICAgICAgfVxuICAgICAgICB9IGVsc2UgaWYgKHJlc3BvbnNlLm1lc3NhZ2UgIT09IHVuZGVmaW5lZCkge1xuICAgICAgICAgICAgY29uc29sZS5lcnJvcihcInNlYXJjaE1lcmNoYW50RGF0YXMgZGF0YSBsb2FkZWQgRmFpbGVkOlwiLCByZXNwb25zZS5tZXNzYWdlKVxuICAgICAgICAgICAgcmV0dXJuIHt9XG4gICAgICAgIH1cbiAgICB9IGVsc2Uge1xuICAgICAgICAvLyDnvZHnu5zlpLHotKVcbiAgICAgICAgcmV0dXJuIG51bGxcbiAgICB9XG59XG5cbmV4cG9ydCB7XG4gICAgc2VhcmNoTWVyY2hhbnREYXRhcyxcbn0iLCJpbXBvcnQgKiAgYXMgY29tbW9uIGZyb20gJy4vY29tbW9uLmpzJztcbmltcG9ydCAqIGFzIGRhdGFTZXJ2aWNlIGZyb20gJy4vc2VhcmNoTWVyY2hhbnREYXRhU2VydmljZS5qcydcblxuY29uc3QgeyBtb2R1bGVEYXRhLCBtb2R1bGVFdmVudCB9ID0gY29tbW9uLm1vZHVsZURlZmluZShcbiAgICBcIm1lcmNoYW50U2VhcmNoUGFnZVwiLFxuICAgIGZ1bmN0aW9uICgpIHtcbiAgICAgICAgY29uc29sZS5sb2coXCJtZXJjaGFudFNlYXJjaFBhZ2UgbG9hZGluZy4uLi5cIilcbiAgICB9LFxuICAgIGRlZmF1bHREYXRhXG4pO1xuXG5mdW5jdGlvbiBkZWZhdWx0RGF0YSgpIHtcbiAgICBjb25zb2xlLmxvZyhcIm1lcmNoYW50U2VhcmNoUGFnZSBkZWZhdWx0RGF0YS4uLi5cIilcblxuICAgIHJldHVybiB7XG4gICAgICAgIGxpc3RWaXNpYmxlOiBcImludmlzaWJsZVwiLFxuICAgICAgICBlbXB0eVZpc2libGU6IFwiZ29uZVwiLFxuICAgICAgICBsb2FkaW5nVmlzaWJsZTogXCJnb25lXCIsXG4gICAgICAgIGxvYWRpbmdTdGF0dXM6IFwic3RvcFwiLFxuICAgICAgICBkYXRhczogW10sXG4gICAgICAgIHNlYXJjaElucHV0OiBcIlwiLFxuICAgICAgICBib3JkZXJDb2xvcjogXCIjMDAwMDAwMDBcIixcbiAgICAgICAgaW5wdXRDbGVhckJ1dHRvblZpc2libGU6IFwiZ29uZVwiLFxuICAgICAgICBvbkZvY3VzOiBcInRydWVcIixcbiAgICAgICAgdGltZUlkOiAtMSxcbiAgICAgICAgYWRkaXRpb25hbFZpZXdDZW50ZW50WTogY29tbW9uLmNvbW1hbkRhdGEuT1MgPT0gMCA/IFwiMTgwXCIgOiBcIjkwXCJcbiAgICB9XG59XG5cbmFzeW5jIGZ1bmN0aW9uIHNlYXJjaE1lcmNoYW50KCkge1xuICAgIGlmIChtb2R1bGVEYXRhLnRpbWVJZCAhPSAtMSkge1xuICAgICAgICBjbGVhckludGVydmFsKG1vZHVsZURhdGEudGltZUlkKVxuICAgICAgICBtb2R1bGVEYXRhLnRpbWVJZCA9IC0xO1xuICAgIH1cbiAgICBtb2R1bGVEYXRhLmVtcHR5VmlzaWJsZSA9IFwiZ29uZVwiXG4gICAgbW9kdWxlRGF0YS5saXN0VmlzaWJsZSA9IFwiaW52aXNpYmxlXCJcbiAgICBtb2R1bGVEYXRhLmxvYWRpbmdWaXNpYmxlID0gXCJ2aXNpYmxlXCJcbiAgICBtb2R1bGVEYXRhLmxvYWRpbmdTdGF0dXMgPSBcInBsYXlcIlxuICAgIHZhciByZXMgPSBhd2FpdCBkYXRhU2VydmljZS5zZWFyY2hNZXJjaGFudERhdGFzKG1vZHVsZURhdGEuc2VhcmNoSW5wdXQpXG4gICAgdmFyIHNob3dFbXB0eSA9IHRydWVcbiAgICB0cnkge1xuICAgICAgICBpZiAocmVzKSB7XG4gICAgICAgICAgICB2YXIgeyBkYXRhcywgdGV4dCB9ID0gcmVzO1xuICAgICAgICAgICAgaWYgKHRleHQgIT0gbW9kdWxlRGF0YS5zZWFyY2hJbnB1dCkge1xuICAgICAgICAgICAgICAgIGNvbnNvbGUubG9nKGBzZWFyY2hNZXJjaGFudCBlcnJvciAgdGV4dCAhPSBtb2R1bGVEYXRhLnNlYXJjaElucHV0ICR7dGV4dH0gJHttb2R1bGVEYXRhLnNlYXJjaElucHV0fWApXG4gICAgICAgICAgICAgICAgcmV0dXJuO1xuICAgICAgICAgICAgfVxuICAgICAgICAgICAgY29uc29sZS5sb2coYHNlYXJjaE1lcmNoYW50IHN1Y2Nlc3MgICR7dGV4dH0gJHttb2R1bGVEYXRhLnNlYXJjaElucHV0fWApXG5cbiAgICAgICAgICAgIGxldCB2aWV3TW9kZWxzUHJvbWlzZSA9IGRhdGFzLm1hcChhc3luYyAoZGF0YSwgaSkgPT4ge1xuICAgICAgICAgICAgICAgIHZhciBpdGVtID0gYXdhaXQgZm9ybWF0RGF0YXMoZGF0YSlcbiAgICAgICAgICAgICAgICBpdGVtLmluZGV4ID0gaVxuICAgICAgICAgICAgICAgIHJldHVybiBpdGVtXG4gICAgICAgICAgICB9KVxuICAgICAgICAgICAgdmFyIHZpZXdNb2RlbHMgPSBhd2FpdCBQcm9taXNlLmFsbCh2aWV3TW9kZWxzUHJvbWlzZSlcbiAgICAgICAgICAgIG1vZHVsZURhdGEuZGF0YXMgPSB2aWV3TW9kZWxzXG4gICAgICAgICAgICBzaG93RW1wdHkgPSB2aWV3TW9kZWxzLmxlbmd0aCA9PSAwXG4gICAgICAgIH1cbiAgICAgICAgY29uc29sZS5sb2coYHNlYXJjaE1lcmNoYW50IHJlcyA9PSBudWxsICAke3RleHR9ICR7cmVzID09IG51bGx9YClcbiAgICB9IGNhdGNoIChlcnJvcikge1xuICAgICAgICBjb25zb2xlLmxvZyhgc2VhcmNoTWVyY2hhbnQgZXJyb3IgID09PT09ICR7ZXJyb3J9YClcbiAgICB9XG4gICAgY29uc29sZS5sb2coYHNlYXJjaE1lcmNoYW50IHNob3dFbXB0eSAgJHtzaG93RW1wdHl9YClcbiAgICBtb2R1bGVEYXRhLmxvYWRpbmdWaXNpYmxlID0gXCJnb25lXCJcbiAgICBtb2R1bGVEYXRhLmxvYWRpbmdTdGF0dXMgPSBcInN0b3BcIlxuICAgIGlmIChzaG93RW1wdHkpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5lbXB0eVZpc2libGUgPSBcInZpc2libGVcIlxuICAgICAgICBtb2R1bGVEYXRhLmxpc3RWaXNpYmxlID0gXCJpbnZpc2libGVcIlxuICAgIH0gZWxzZSB7XG4gICAgICAgIG1vZHVsZURhdGEuZW1wdHlWaXNpYmxlID0gXCJnb25lXCJcbiAgICAgICAgbW9kdWxlRGF0YS5saXN0VmlzaWJsZSA9IFwidmlzaWJsZVwiXG4gICAgfVxufVxuXG5hc3luYyBmdW5jdGlvbiBmb3JtYXREYXRhcyhpdGVtKSB7XG4gICAgaXRlbS50eXBlID0gXCJzZWFyY2hDZWxsXCJcbiAgICBpdGVtLm9ubGluZUNvbG9yID0gaXRlbS5pc09ubGluZSA/IFwiIzAwQTE3MVwiIDogXCJAY29sb3Iva0NvbG9yRm91ckxldmVsVGV4dFwiXG4gICAgaXRlbS5icmFuZEljb25WaXNpYmxlID0gaXRlbS5pc0JyYW5kVXNlciA/IFwidmlzaWJsZVwiIDogXCJnb25lXCJcbiAgICByZXR1cm4gaXRlbVxufVxuXG5tb2R1bGVFdmVudC5vbkNsaWNrSXRlbSA9IGZ1bmN0aW9uIChpbmRleCkge1xuICAgIHZhciBpdGVtID0gbW9kdWxlRGF0YS5kYXRhc1tpbmRleF1cbiAgICAkbmF0aXZlQVBJLm1lcmNoYW50U2VhcmNoKHtcbiAgICAgICAgYWN0aW9uOiBcImdvVG9NZXJjaGFudFBhZ2VcIixcbiAgICAgICAgdWlkOiBpdGVtLnVpZFxuICAgIH0pXG59XG5cbm1vZHVsZUV2ZW50Lm9uQ2xlYXJDbGljayA9IGZ1bmN0aW9uICgpIHtcbiAgICBtb2R1bGVEYXRhLnNlYXJjaElucHV0ID0gXCJcIjtcbiAgICBtb2R1bGVEYXRhLmlucHV0Q2xlYXJCdXR0b25WaXNpYmxlID0gXCJnb25lXCJcbiAgICBtb2R1bGVEYXRhLmxpc3RWaXNpYmxlID0gXCJpbnZpc2libGVcIlxuICAgIG1vZHVsZURhdGEuZW1wdHlWaXNpYmxlID0gXCJnb25lXCJcbiAgICBtb2R1bGVEYXRhLmxvYWRpbmdWaXNpYmxlID0gXCJnb25lXCJcbiAgICBtb2R1bGVEYXRhLmxvYWRpbmdTdGF0dXMgPSBcInN0b3BcIlxufVxuXG5tb2R1bGVFdmVudC50ZXh0Q2hhbmdlID0gZnVuY3Rpb24gKHRleHQpIHtcbiAgICBtb2R1bGVEYXRhLnNlYXJjaElucHV0ID0gdGV4dFxuICAgIGlmIChtb2R1bGVEYXRhLnNlYXJjaElucHV0ICE9IG51bGwgJiYgbW9kdWxlRGF0YS5zZWFyY2hJbnB1dCAhPSBcIlwiKSB7XG4gICAgICAgIG1vZHVsZURhdGEuaW5wdXRDbGVhckJ1dHRvblZpc2libGUgPSBcInZpc2libGVcIlxuICAgICAgICBpZiAobW9kdWxlRGF0YS5zZWFyY2hJbnB1dC50cmltKCkubGVuZ3RoID4gMSkge1xuICAgICAgICAgICAgbGV0IGhhc0NoaW5lc2UgPSBpc0hhc0NoaW5lc2UobW9kdWxlRGF0YS5zZWFyY2hJbnB1dClcbiAgICAgICAgICAgIGlmIChoYXNDaGluZXNlIHx8IG1vZHVsZURhdGEuc2VhcmNoSW5wdXQudHJpbSgpLmxlbmd0aCA+IDMpIHtcbiAgICAgICAgICAgICAgICBpZiAobW9kdWxlRGF0YS50aW1lSWQgIT0gLTEpIHtcbiAgICAgICAgICAgICAgICAgICAgY2xlYXJJbnRlcnZhbChtb2R1bGVEYXRhLnRpbWVJZClcbiAgICAgICAgICAgICAgICB9XG4gICAgICAgICAgICAgICAgbW9kdWxlRGF0YS50aW1lSWQgPSBzZXRJbnRlcnZhbChzZWFyY2hNZXJjaGFudCwgMTAwMCk7XG4gICAgICAgICAgICB9XG4gICAgICAgIH1cbiAgICB9IGVsc2Uge1xuICAgICAgICBtb2R1bGVEYXRhLmlucHV0Q2xlYXJCdXR0b25WaXNpYmxlID0gXCJnb25lXCJcbiAgICB9XG4gICAgbW9kdWxlRGF0YS5saXN0VmlzaWJsZSA9IFwiaW52aXNpYmxlXCJcbiAgICBtb2R1bGVEYXRhLmVtcHR5VmlzaWJsZSA9IFwiZ29uZVwiXG4gICAgbW9kdWxlRGF0YS5sb2FkaW5nVmlzaWJsZSA9IFwiZ29uZVwiXG4gICAgbW9kdWxlRGF0YS5sb2FkaW5nU3RhdHVzID0gXCJzdG9wXCJcbn1cblxuZnVuY3Rpb24gaXNIYXNDaGluZXNlKHN0cikge1xuICAgIGZvciAodmFyIGkgPSAwOyBpIDwgc3RyLmxlbmd0aDsgaSsrKSB7XG4gICAgICAgIHZhciBjaGFyQ29kZSA9IHN0ci5jaGFyQ29kZUF0KGkpO1xuICAgICAgICBpZiAoKGNoYXJDb2RlID49IDB4NEUwMCAmJiBjaGFyQ29kZSA8PSAweDlGRkYpKSB7XG4gICAgICAgICAgICByZXR1cm4gdHJ1ZTtcbiAgICAgICAgfVxuICAgIH1cbiAgICByZXR1cm4gZmFsc2U7XG59XG5cbm1vZHVsZUV2ZW50LnNlYXJjaE1lcmNoYW50Q2xpY2sgPSBmdW5jdGlvbiAoKSB7XG4gICAgaWYgKG1vZHVsZURhdGEuc2VhcmNoSW5wdXQgIT0gbnVsbCAmJiBtb2R1bGVEYXRhLnNlYXJjaElucHV0ICE9IFwiXCIpIHtcbiAgICAgICAgc2VhcmNoTWVyY2hhbnQoKVxuICAgIH1cbn1cblxubW9kdWxlRXZlbnQuZm9jdXNDaGFuZ2UgPSBmdW5jdGlvbiAoaGFzRm9jdXMpIHtcbiAgICBpZiAoaGFzRm9jdXMpIHtcbiAgICAgICAgbW9kdWxlRGF0YS5ib3JkZXJDb2xvciA9IFwiQGNvbG9yL0tCYXNlQ29sb3JNYWpvclRoZW1lMTAwXCI7XG4gICAgfSBlbHNlIHtcbiAgICAgICAgbW9kdWxlRGF0YS5ib3JkZXJDb2xvciA9IFwiIzAwMDAwMDAwXCI7XG4gICAgfVxufVxubW9kdWxlRXZlbnQub25CYWNrQ2xpY2sgPSBmdW5jdGlvbiAoKSB7XG4gICAgJG5hdGl2ZUFQSS5tZXJjaGFudFNlYXJjaCh7XG4gICAgICAgIGFjdGlvbjogXCJvbkJhY2tDbGlja1wiXG4gICAgfSlcbn1cbiIsImltcG9ydCAqIGFzIGNvbW1vbiBmcm9tICcuL2NvbW1vbi5qcyc7XG5pbXBvcnQgKiBhcyBtZXJjaGFudFNlYXJjaFBhZ2UgZnJvbSAnLi9tZXJjaGFudFNlYXJjaFBhZ2UuanMnO1xuaW1wb3J0ICogYXMgc2VhcmNoTWVyY2hhbnREYXRhU2VydmljZSBmcm9tICcuL3NlYXJjaE1lcmNoYW50RGF0YVNlcnZpY2UuanMnO1xuXG4vLy8g56uv5byV5pOO5ZCv5Yqo5YWl5Y+jXG4kZXZlbnQuc3RhcnQgPSBhc3luYyBmdW5jdGlvbiAoKSB7XG5cbn1cblxuXG4kZXZlbnQuc2VuZENvbW1vbkNvbmZpZyA9IGZ1bmN0aW9uIChwYXJhbSkge1xuICAgIHZhciB2YWlsZFBhcmFtcyA9IGNvbW1vbi5wYXJzZVJlcXVlc3RQYXJhbXMocGFyYW0pXG4gICAgY29tbW9uLnBhcnNlQ29tbW9uQ29uZmlnKHZhaWxkUGFyYW1zKVxufSJdLCJuYW1lcyI6WyJjb21tYW5EYXRhIiwiY29sb3JNb2RlIiwiT1MiLCJsYW5ndWFnZSIsImFzeW5jIiwic2VuZFJlcXVlc3QiLCJwYXRoIiwicGFyYW1zIiwibWV0aG9kIiwiaG9zdFR5cGUiLCJoZWFkZXIiLCJjb25zb2xlIiwibG9nIiwicGFyYW0iLCJyZXNwb25zZVN0cmluZyIsIiRuYXRpdmVBUEkiLCJyZXF1ZXN0IiwiSlNPTiIsInN0cmluZ2lmeSIsInJlc3BvbnNlIiwicGFyc2UiLCJjb2RlIiwiZSIsIm1vZHVsZURlZmluZSIsIm1vZHVsZU5hbWUiLCJzdGFydEZ1bmN0aW9uIiwiZGVmYXVsdERhdGFGdW5jdGlvbiIsIiRkYXRhIiwiJGV2ZW50Iiwic3RhcnQiLCJtb2R1bGVFdmVudCIsIm1vZHVsZURhdGEiLCJwYXJzZUNvbW1vbkNvbmZpZyIsInBhcnNlSW50IiwicGFyc2VSZXF1ZXN0UGFyYW1zIiwicmVxdWVzdEpzb24iLCJTdHJpbmciLCJzZWFyY2hNZXJjaGFudERhdGFzIiwidGV4dCIsInVzZXJOYW1lIiwiY29tbW9uLnNlbmRSZXF1ZXN0Iiwic3VjY2VzcyIsIm1lc3NhZ2UiLCJkYXRhIiwiZGF0YXMiLCJ1bmRlZmluZWQiLCJlcnJvciIsImNvbW1vbi5tb2R1bGVEZWZpbmUiLCJkZWZhdWx0RGF0YSIsImxpc3RWaXNpYmxlIiwiZW1wdHlWaXNpYmxlIiwibG9hZGluZ1Zpc2libGUiLCJsb2FkaW5nU3RhdHVzIiwic2VhcmNoSW5wdXQiLCJib3JkZXJDb2xvciIsImlucHV0Q2xlYXJCdXR0b25WaXNpYmxlIiwib25Gb2N1cyIsInRpbWVJZCIsImFkZGl0aW9uYWxWaWV3Q2VudGVudFkiLCJjb21tb24uY29tbWFuRGF0YSIsInNlYXJjaE1lcmNoYW50IiwiY2xlYXJJbnRlcnZhbCIsInJlcyIsImRhdGFTZXJ2aWNlLnNlYXJjaE1lcmNoYW50RGF0YXMiLCJzaG93RW1wdHkiLCJ2aWV3TW9kZWxzUHJvbWlzZSIsIm1hcCIsImkiLCJpdGVtIiwiZm9ybWF0RGF0YXMiLCJpbmRleCIsInZpZXdNb2RlbHMiLCJQcm9taXNlIiwiYWxsIiwibGVuZ3RoIiwidHlwZSIsIm9ubGluZUNvbG9yIiwiaXNPbmxpbmUiLCJicmFuZEljb25WaXNpYmxlIiwiaXNCcmFuZFVzZXIiLCJvbkNsaWNrSXRlbSIsIm1lcmNoYW50U2VhcmNoIiwiYWN0aW9uIiwidWlkIiwib25DbGVhckNsaWNrIiwidGV4dENoYW5nZSIsInRyaW0iLCJoYXNDaGluZXNlIiwiaXNIYXNDaGluZXNlIiwic2V0SW50ZXJ2YWwiLCJzdHIiLCJjaGFyQ29kZSIsImNoYXJDb2RlQXQiLCJzZWFyY2hNZXJjaGFudENsaWNrIiwiZm9jdXNDaGFuZ2UiLCJoYXNGb2N1cyIsIm9uQmFja0NsaWNrIiwic2VuZENvbW1vbkNvbmZpZyIsInZhaWxkUGFyYW1zIiwiY29tbW9uLnBhcnNlUmVxdWVzdFBhcmFtcyIsImNvbW1vbi5wYXJzZUNvbW1vbkNvbmZpZyJdLCJtYXBwaW5ncyI6IkFBQ08sSUFBSUEsYUFBYTtJQUNwQkMsV0FBVztJQUNYQyxJQUFJO0lBQ0pDLFVBQVU7OztBQUlQQyxlQUFlQyxZQUFZQyxNQUFNQyxTQUFTLElBQUlDLFNBQVMsR0FBR0MsV0FBVyxHQUFHQyxTQUFTO0lBQ3BGQyxRQUFRQyxJQUFJLFdBQVdOO0lBQ3ZCLE1BQU1PLFFBQVE7UUFDVlA7UUFDQUU7UUFDQUM7UUFDQUM7UUFDQUg7O0lBRUo7UUFDSSxJQUFJTyxpQkFBaUJBLHVCQUF1QkMsV0FBV0MsUUFBUUMsS0FBS0MsVUFBVUw7UUFDOUUsSUFBSU0sV0FBV0YsS0FBS0csTUFBTU47UUFDMUIsS0FBSU8sTUFBRUEsUUFBU0Y7UUFDZixJQUFJRSxRQUFRLEtBQUs7WUFDYlYsUUFBUUMsSUFBSSxXQUFXTjtZQUN2QixPQUFPYTtBQUNuQixlQUFlO1lBQ0hSLFFBQVFDLElBQUksd0JBQXdCUztZQUNwQyxPQUFPRjtBQUNWO0FBQ0osTUFBQyxP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
