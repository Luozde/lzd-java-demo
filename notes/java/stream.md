# Stream基本操作

## stream排序操作

- 升序

```java
studentList.stream().sorted(Comparator.comparing(StudentInfo::getAge)).collect(Collectors.toList());
```

- 降序

```java
studentList.stream().sorted(Comparator.comparing(StudentInfo::getAge).reversed()).collect(Collectors.toList());
```
