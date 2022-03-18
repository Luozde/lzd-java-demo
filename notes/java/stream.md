# Stream基本操作

## 排序操作

- 升序

```java
studentList.stream().sorted(Comparator.comparing(StudentInfo::getAge)).collect(Collectors.toList());
```

- 降序

```java
studentList.stream().sorted(Comparator.comparing(StudentInfo::getAge).reversed()).collect(Collectors.toList());
```

## 根据字段对list进行分组

```java
List<Score> scoreList = new ArrayList<>();
scoreList.add(new Score("001", "2018", 100.0));
scoreList.add(new Score("001", "2019", 59.5));
scoreList.add(new Score("001", "2019", 99.0));
scoreList.add(new Score("002", "2018", 199.6));

// 根据scoreYear字段进行分组
Map<String, List<Score>> map = scoreList.stream().collect(
        Collectors.groupingBy(
                score -> score.getScoreYear()
        ));
System.out.println(JSON.toJSON(map));
```





> [Stream示例代码](./others/src/main/java/collect/Stream.java)
