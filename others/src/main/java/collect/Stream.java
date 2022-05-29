package collect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.luozd.demo.entity.Score;
import com.luozd.demo.entity.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        listToMap();
    }

    /**
     * 根据一个字段对list进行分组
     */
    static void listGroupingByKey() {
        List<Score> scoreList = new ArrayList<>();
        scoreList.add(new Score("001", "2018", 100.0));
        scoreList.add(new Score("001", "2019", 59.5));
        scoreList.add(new Score("001", "2019", 99.0));
        scoreList.add(new Score("002", "2018", 199.6));

        //根据scoreYear字段进行分组
        Map<String, List<Score>> map = scoreList.stream().collect(
                Collectors.groupingBy(
                        score -> score.getScoreYear()
                ));
        System.out.println(JSON.toJSON(map));
    }

    // list 转 map
    // 如：
    // id=1, mainId= 1, name=a, sex=1
    // id=2, mainId= 1, name=b, sex=2
    // id=3, mainId= 1, name=c, sex=2
    // id=4, mainId= 2, name=d, sex=1
    // id=5, mainId= 2, name=e, sex=2
    // 输出结果：Map<mainId, Map<sex, obj>>, 如果存在重复则覆盖
    //
    static void listToMap() {
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

        System.out.println(JSONObject.toJSONString(mainIdMap));

    }
}


