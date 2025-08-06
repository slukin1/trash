async function goToBuy() {
    await $nativeAPI.guideBridge({
        action: "openPage",
        type: "native",
        page: "buy"
    });
}

async function goToDeposit() {
    await $nativeAPI.storage({
        action: "save",
        name: "guide",
        key: "didChoose",
        data: "1"
    });
    await $nativeAPI.guideBridge({
        action: "openPage",
        type: "native",
        page: "deposit"
    });
}

var colorMode;

async function requestData() {
    var info = await sendRequest("v1/app/guide/getTransferAmountInfo");
    if (colorMode == null) {
        const color = await $nativeAPI.guideBridge({
            action: "getColorMode"
        });
        colorMode = parseInt(color);
    }
    var titleColor = "#000000";
    if (colorMode == 1) {
        titleColor = "#E6E6E6";
    }
    if (info) {
        $data.info = info;
        var title = $data.info.title;
        title = title.replace(/{|}/g, (function(match) {
            return match === "{" ? "</span><span style='color:#FE8731; font-size:22px;'>" : `</span><span style='color:${titleColor}; font-size:22px;'>`;
        }));
        title = `<span style='color:${titleColor}; font-size:22px;'>${title}</span>`;
        $data.info.title = title;
    }
}

async function sendRequest(path, params = {}, method = 0, hostType = 0, header = {}) {
    console.log(`request ${path}`);
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
        console.log(`code=${code}`);
        console.log(`data=${JSON.stringify(data)}`);
        if (code == 200) {
            console.log(`request ${path} done`);
            return data;
        } else {
            console.log(`request failed, code=${code}`);
            return null;
        }
    } catch (e) {
        console.log(`request error, error=${e}`);
        return null;
    }
}

$event.requestData = requestData;

$event.goToBuy = goToBuy;

$event.goToDeposit = goToDeposit;

requestData();
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWFpbi5qcyIsInNvdXJjZXMiOlsiLi4vLi4vcmVwb3NpdG9yeS9zcmMvbWFpbi5qcyJdLCJzb3VyY2VzQ29udGVudCI6WyJcblxuYXN5bmMgZnVuY3Rpb24gZ29Ub0J1eSgpIHtcbiAgICAvLyBhd2FpdCAkbmF0aXZlQVBJLnN0b3JhZ2Uoe1xuICAgIC8vICAgICBhY3Rpb246IFwic2F2ZVwiLFxuICAgIC8vICAgICBuYW1lOlwiZ3VpZGVcIixcbiAgICAvLyAgICAga2V5OlwiZGlkQ2hvb3NlXCIsXG4gICAgLy8gICAgIGRhdGE6XCIxXCJcbiAgICAvLyB9KTtcblxuICAgIGF3YWl0ICRuYXRpdmVBUEkuZ3VpZGVCcmlkZ2Uoe1xuICAgICAgICBhY3Rpb246IFwib3BlblBhZ2VcIixcbiAgICAgICAgdHlwZTpcIm5hdGl2ZVwiLFxuICAgICAgICBwYWdlOlwiYnV5XCJcbiAgICB9KTtcbn1cblxuYXN5bmMgZnVuY3Rpb24gZ29Ub0RlcG9zaXQoKSB7XG4gICAgYXdhaXQgJG5hdGl2ZUFQSS5zdG9yYWdlKHtcbiAgICAgICAgYWN0aW9uOiBcInNhdmVcIixcbiAgICAgICAgbmFtZTpcImd1aWRlXCIsXG4gICAgICAgIGtleTpcImRpZENob29zZVwiLFxuICAgICAgICBkYXRhOlwiMVwiXG4gICAgfSk7XG4gICAgXG4gICAgYXdhaXQgJG5hdGl2ZUFQSS5ndWlkZUJyaWRnZSh7XG4gICAgICAgIGFjdGlvbjogXCJvcGVuUGFnZVwiLFxuICAgICAgICB0eXBlOlwibmF0aXZlXCIsXG4gICAgICAgIHBhZ2U6XCJkZXBvc2l0XCJcbiAgICB9KTtcbn1cblxudmFyIGNvbG9yTW9kZTtcblxuXG5hc3luYyBmdW5jdGlvbiByZXF1ZXN0RGF0YSgpIHtcbiAgICB2YXIgaW5mbyA9IGF3YWl0IHNlbmRSZXF1ZXN0KCd2MS9hcHAvZ3VpZGUvZ2V0VHJhbnNmZXJBbW91bnRJbmZvJyk7XG4gICAgaWYgKGNvbG9yTW9kZSA9PSBudWxsKSB7XG4gICAgICAgIGNvbnN0IGNvbG9yID0gYXdhaXQgJG5hdGl2ZUFQSS5ndWlkZUJyaWRnZSh7XG4gICAgICAgICAgICBhY3Rpb246IFwiZ2V0Q29sb3JNb2RlXCJcbiAgICAgICAgfSk7XG4gICAgICAgIGNvbG9yTW9kZSA9IHBhcnNlSW50KGNvbG9yKTtcbiAgICB9XG5cbiAgICB2YXIgdGl0bGVDb2xvciA9IFwiIzAwMDAwMFwiO1xuICAgIGlmIChjb2xvck1vZGUgPT0gMSkge1xuICAgICAgICB0aXRsZUNvbG9yID0gXCIjRTZFNkU2XCI7XG4gICAgfVxuICAgIFxuICAgIGlmIChpbmZvKSB7XG4gICAgICAgICRkYXRhLmluZm8gPSBpbmZvO1xuICAgICAgICB2YXIgdGl0bGUgPSAkZGF0YS5pbmZvLnRpdGxlO1xuICAgICAgICB0aXRsZSA9IHRpdGxlLnJlcGxhY2UoL3t8fS9nLCBmdW5jdGlvbihtYXRjaCkge1xuICAgICAgICAgICAgcmV0dXJuIG1hdGNoID09PSAneycgPyBcIjwvc3Bhbj48c3BhbiBzdHlsZT0nY29sb3I6I0ZFODczMTsgZm9udC1zaXplOjIycHg7Jz5cIiA6IGA8L3NwYW4+PHNwYW4gc3R5bGU9J2NvbG9yOiR7dGl0bGVDb2xvcn07IGZvbnQtc2l6ZToyMnB4Oyc+YDtcbiAgICAgICAgICB9KTtcbiAgICAgICAgdGl0bGUgPSBgPHNwYW4gc3R5bGU9J2NvbG9yOiR7dGl0bGVDb2xvcn07IGZvbnQtc2l6ZToyMnB4Oyc+JHt0aXRsZX08L3NwYW4+YFxuICAgICAgICAkZGF0YS5pbmZvLnRpdGxlID0gdGl0bGU7XG4gICAgfVxufVxuXG4vL+WPkemAgeivt+axglxuYXN5bmMgZnVuY3Rpb24gc2VuZFJlcXVlc3QocGF0aCwgcGFyYW1zID0ge30sIG1ldGhvZCA9IDAsIGhvc3RUeXBlID0gMCwgaGVhZGVyID0ge30pIHtcbiAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCAke3BhdGh9YCk7XG5cbiAgICBjb25zdCBwYXJhbSA9IHtcbiAgICAgICAgcGF0aCxcbiAgICAgICAgbWV0aG9kLFxuICAgICAgICBob3N0VHlwZSxcbiAgICAgICAgaGVhZGVyLFxuICAgICAgICBwYXJhbXNcbiAgICB9O1xuICAgIHRyeSB7XG4gICAgICAgIHZhciByZXNwb25zZVN0cmluZyA9IGF3YWl0ICRuYXRpdmVBUEkucmVxdWVzdChKU09OLnN0cmluZ2lmeShwYXJhbSkpO1xuICAgICAgICB2YXIgcmVzcG9uc2UgPSBKU09OLnBhcnNlKHJlc3BvbnNlU3RyaW5nKTtcbiAgICAgICAgdmFyIHsgY29kZSwgZGF0YSB9ID0gcmVzcG9uc2U7XG4gICAgICAgIGNvbnNvbGUubG9nKGBjb2RlPSR7Y29kZX1gKTtcbiAgICAgICAgY29uc29sZS5sb2coYGRhdGE9JHtKU09OLnN0cmluZ2lmeShkYXRhKX1gKTtcblxuICAgICAgICBpZiAoY29kZSA9PSAyMDApIHtcbiAgICAgICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0ICR7cGF0aH0gZG9uZWApO1xuICAgICAgICAgICAgcmV0dXJuIGRhdGE7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgICBjb25zb2xlLmxvZyhgcmVxdWVzdCBmYWlsZWQsIGNvZGU9JHtjb2RlfWApO1xuICAgICAgICAgICAgcmV0dXJuIG51bGw7XG4gICAgICAgIH1cbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIGNvbnNvbGUubG9nKGByZXF1ZXN0IGVycm9yLCBlcnJvcj0ke2V9YCk7XG4gICAgICAgIHJldHVybiBudWxsO1xuICAgIH1cbn1cblxuXG4kZXZlbnQucmVxdWVzdERhdGEgPSByZXF1ZXN0RGF0YTtcbiRldmVudC5nb1RvQnV5ID0gZ29Ub0J1eTtcbiRldmVudC5nb1RvRGVwb3NpdCA9IGdvVG9EZXBvc2l0O1xuXG5yZXF1ZXN0RGF0YSgpO1xuIl0sIm5hbWVzIjpbImFzeW5jIiwiZ29Ub0J1eSIsIiRuYXRpdmVBUEkiLCJndWlkZUJyaWRnZSIsImFjdGlvbiIsInR5cGUiLCJwYWdlIiwiZ29Ub0RlcG9zaXQiLCJzdG9yYWdlIiwibmFtZSIsImtleSIsImRhdGEiLCJjb2xvck1vZGUiLCJyZXF1ZXN0RGF0YSIsImluZm8iLCJzZW5kUmVxdWVzdCIsImNvbG9yIiwicGFyc2VJbnQiLCJ0aXRsZUNvbG9yIiwiJGRhdGEiLCJ0aXRsZSIsInJlcGxhY2UiLCJtYXRjaCIsInBhdGgiLCJwYXJhbXMiLCJtZXRob2QiLCJob3N0VHlwZSIsImhlYWRlciIsImNvbnNvbGUiLCJsb2ciLCJwYXJhbSIsInJlc3BvbnNlU3RyaW5nIiwicmVxdWVzdCIsIkpTT04iLCJzdHJpbmdpZnkiLCJyZXNwb25zZSIsInBhcnNlIiwiY29kZSIsImUiLCIkZXZlbnQiXSwibWFwcGluZ3MiOiJBQUVBQSxlQUFlQztVQVFMQyxXQUFXQyxZQUFZO1FBQ3pCQyxRQUFRO1FBQ1JDLE1BQUs7UUFDTEMsTUFBSzs7QUFFYjs7QUFFQU4sZUFBZU87VUFDTEwsV0FBV00sUUFBUTtRQUNyQkosUUFBUTtRQUNSSyxNQUFLO1FBQ0xDLEtBQUk7UUFDSkMsTUFBSzs7VUFHSFQsV0FBV0MsWUFBWTtRQUN6QkMsUUFBUTtRQUNSQyxNQUFLO1FBQ0xDLE1BQUs7O0FBRWI7O0FBRUEsSUFBSU07O0FBR0paLGVBQWVhO0lBQ1gsSUFBSUMsYUFBYUMsWUFBWTtJQUM3QixJQUFJSCxhQUFhLE1BQU07UUFDbkIsTUFBTUksY0FBY2QsV0FBV0MsWUFBWTtZQUN2Q0MsUUFBUTs7UUFFWlEsWUFBWUssU0FBU0Q7QUFDeEI7SUFFRCxJQUFJRSxhQUFhO0lBQ2pCLElBQUlOLGFBQWEsR0FBRztRQUNoQk0sYUFBYTtBQUNoQjtJQUVELElBQUlKLE1BQU07UUFDTkssTUFBTUwsT0FBT0E7UUFDYixJQUFJTSxRQUFRRCxNQUFNTCxLQUFLTTtRQUN2QkEsUUFBUUEsTUFBTUMsUUFBUSxTQUFRLFNBQVNDO1lBQ25DLE9BQU9BLFVBQVUsTUFBTSx5REFBeUQsNkJBQTZCSjtBQUN6SDtRQUNRRSxRQUFRLHNCQUFzQkYsZ0NBQWdDRTtRQUM5REQsTUFBTUwsS0FBS00sUUFBUUE7QUFDdEI7QUFDTDs7QUFHQXBCLGVBQWVlLFlBQVlRLE1BQU1DLFNBQVMsSUFBSUMsU0FBUyxHQUFHQyxXQUFXLEdBQUdDLFNBQVM7SUFDN0VDLFFBQVFDLElBQUksV0FBV047SUFFdkIsTUFBTU8sUUFBUTtRQUNWUDtRQUNBRTtRQUNBQztRQUNBQztRQUNBSDs7SUFFSjtRQUNJLElBQUlPLHVCQUF1QjdCLFdBQVc4QixRQUFRQyxLQUFLQyxVQUFVSjtRQUM3RCxJQUFJSyxXQUFXRixLQUFLRyxNQUFNTDtRQUMxQixLQUFJTSxNQUFFQSxNQUFJMUIsTUFBRUEsUUFBU3dCO1FBQ3JCUCxRQUFRQyxJQUFJLFFBQVFRO1FBQ3BCVCxRQUFRQyxJQUFJLFFBQVFJLEtBQUtDLFVBQVV2QjtRQUVuQyxJQUFJMEIsUUFBUSxLQUFLO1lBQ2JULFFBQVFDLElBQUksV0FBV047WUFDdkIsT0FBT1o7QUFDbkIsZUFBZTtZQUNIaUIsUUFBUUMsSUFBSSx3QkFBd0JRO1lBQ3BDLE9BQU87QUFDVjtBQUNKLE1BQUMsT0FBT0M7UUFDTFYsUUFBUUMsSUFBSSx3QkFBd0JTO1FBQ3BDLE9BQU87QUFDVjtBQUNMOztBQUdBQyxPQUFPMUIsY0FBY0E7O0FBQ3JCMEIsT0FBT3RDLFVBQVVBOztBQUNqQnNDLE9BQU9oQyxjQUFjQTs7QUFFckJNIn0=
