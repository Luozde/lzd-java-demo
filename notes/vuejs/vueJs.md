# Vue基础

## 请求后台接口

```js
async connectTest() {
    //connectTest: 接口函数
    const res = await connectTest(this.formItem)
    const data = res.data
    data.forEach((item) => {
        if (item.result) {
          this.$notify.success(item.devProd + '-' + item.msg)
        } else {
          this.$notify.error(item.devProd + '-' + item.msg)
        }
    })
}
```
