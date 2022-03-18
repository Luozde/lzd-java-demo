# Stream基本操作

## 排序操作

- 升序

```java
studentList.stream()
        .sorted(Comparator.comparing(StudentInfo::getAge))
        .collect(Collectors.toList());
```

- 降序

```java
studentList.stream()
        .sorted(Comparator.comparing(StudentInfo::getAge).reversed())
        .collect(Collectors.toList());
```

## 根据字段对list进行分组

```java
// 根据scoreYear字段进行分组(单字段)
Map<String, List<Score>> map = scoreList.stream().collect(
        Collectors.groupingBy(
                score -> score.getScoreYear()
        ));

// 根据scoreYear和studentId字段进行分组(多字段拼接)
Map<String, List<Score>> map = scoreList.stream().collect(
        Collectors.groupingBy(
                score -> score.getScoreYear()+'-'+score.getStudentId()
        ));
```


> [Stream示例代码](../../others/src/main/java/collect/Stream.java)
