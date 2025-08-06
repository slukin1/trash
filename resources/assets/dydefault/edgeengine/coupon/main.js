function onConfirm() {
    onEvent({'action': 'onConfirm'});
}
function onClose() {
    onEvent({'action': 'onClose'});
}
function onSelected(couponId, isSelected) {
    isSelected = !isSelected;
    var dict = {};
    dict["action"] = "onSelected";
    dict["couponId"] = couponId;
    dict["isSelected"] = isSelected;
    onEvent(dict);
}
function onExpanded(couponId, isExpanded) {
    isExpanded = !isExpanded;
    var dict = {};
    dict["action"] = "onExpanded";
    dict["couponId"] = couponId;
    dict["isExpanded"] = isExpanded;
    onEvent(dict);
}
function onEvent(dict) {
    $nativeAPI.onEvent(JSON.stringify(dict));
}
