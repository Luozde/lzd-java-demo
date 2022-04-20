# Mybatis-Plus

## 查询
### selectList
- 支持条件查询
- 支持字段筛查
- lambda语法
```java
LambdaQueryWrapper<DpDatasourceDetail> selectQuery = new QueryWrapper<DpDatasourceDetail>().lambda()
        .in(DpDatasourceDetail::getMainId, mainIds)
        .select(DpDatasourceDetail::getId);

List<DpDatasourceDetail> list = this.baseMapper.selectList(selectQuery)
```

### QueryWrapper

- 加括号嵌套查询

```java
QueryWrapper<RyxyMemberEntity> wrapper=new QueryWrapper<>();
wrapper.eq("phoneNumber",phone);
if(StringUtils.isEmpty(scenetype)){
    wrapper.and(e->e.isNull("scenetype").or().eq("scenetype",""));
}
wrapper.eq("delFlag","0");
```

效果：
```sql
WHERE( phoneNumber = 156****8888 AND (scenetype IS NULL OR scenetype = "") AND delFlag = 0)
```
