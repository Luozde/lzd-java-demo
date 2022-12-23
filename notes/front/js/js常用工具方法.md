
## 获取url参数值工具类
```js
/**
 * 获取url参数值工具类
 * @param paraName
 * @returns {string}
 */
function getParamFromUrl(paraName) {
    var url = document.location.toString();
    var arrObj = url.split("?");
    if (arrObj.length > 1) {
        var arrPara = arrObj[1].split("&");
        var arr;

        for (var i = 0; i < arrPara.length; i++) {
            arr = arrPara[i].split("=");

            if (arr != null && arr[0] == paraName) {
                return arr[1];
            }
        }
        return "";
    }
    else {
        return "";
    }
}
```


## 修改url参数工具类
```js
/**
 * 修改url参数工具类
 * @param url
 * @param name
 * @param value
 * @returns {*}
 */
function changeURLParam(url, name, value) {
    if (typeof value === 'string') {
        value = value.toString().replace(/(^\s*)|(\s*$)/, ""); // 移除首尾空格
    }
    let url2;
    if (!value) { // remove
        let reg = eval('/(([\?|&])' + name + '=[^&]*)(&)?/i');
        let res = url.match(reg);
        if (res) {
            if (res[2] && res[2] === '?') { // before has ?
                if (res[3]) { // after has &
                    url2 = url.replace(reg, '?');
                } else {
                    url2 = url.replace(reg, '');
                }
            } else {
                url2 = url.replace(reg, '$3');
            }
        }
    } else {
        let reg = eval('/([\?|&]' + name + '=)[^&]*/i');
        if (url.match(reg)) { // edit
            url2 = url.replace(reg, '$1' + value);
        } else { // add
            let reg = /([?](\w+=?)?)[^&]*/i;
            let res = url.match(reg);
            url2 = url;
            if (res) {
                if (res[0] !== '?') {
                    url2 += '&';
                }
            } else {
                url2 += '?';
            }
            url2 += name + '=' + value;
        }
    }
    return url2;
}
```
