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
class Test {
    void test() {
        // 根据scoreYear字段进行分组(单字段)
        Map<String, List<Score>> map = scoreList.stream().collect(
                Collectors.groupingBy(
                        score -> score.getScoreYear()
                ));

        // 根据scoreYear和studentId字段进行分组(多字段拼接)
        Map<String, List<Score>> map = scoreList.stream().collect(
                Collectors.groupingBy(
                        score -> score.getScoreYear() + '-' + score.getStudentId()
                ));
    }
}

```

```java
/**
 * list 转 map
 * 实现输出结果：list -> Map<mainId, Map<sex, obj>>, 如果存在重复则覆盖
 */
class Test {
    void test() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("1", "1", "a", "m"));
        students.add(new Student("2", "1", "b", "f"));
        students.add(new Student("3", "1", "c", "f"));
        students.add(new Student("4", "2", "d", "f"));
        students.add(new Student("5", "2", "e", "m"));

        Map<String, Map<String, Student>> mainIdMap = students.stream()
                .collect(Collectors.toMap(Student::getMainId, s -> {
                    Map<String, Student> sexMap = new HashMap<>(2);
                    sexMap.put(s.getSex(), s);
                    return sexMap;
                }, (v1, v2) -> {
                    v1.putAll(v2);
                    return v1;
                }));
    }
}
```
> 效果：
```json
{
    "1":{
        "m":{
            "id":"1",
            "mainId":"1",
            "name":"a",
            "sex":"m"
        },
        "f":{
            "id":"3",
            "mainId":"1",
            "name":"c",
            "sex":"f"
        }
    },
    "2":{
        "m":{
            "id":"5",
            "mainId":"2",
            "name":"e",
            "sex":"m"
        },
        "f":{
            "id":"4",
            "mainId":"2",
            "name":"d",
            "sex":"f"
        }
    }
}
```

## 格式化专用
```java
class Test {
    void test() {

    }
}
```

> [Stream示例代码](../../others/src/main/java/collect/Stream.java)
