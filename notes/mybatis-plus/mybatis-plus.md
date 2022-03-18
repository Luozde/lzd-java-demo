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
