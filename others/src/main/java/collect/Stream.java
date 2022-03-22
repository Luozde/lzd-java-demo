package collect;

import com.alibaba.fastjson.JSON;
import com.luozd.demo.entity.Score;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        listGroupingByKey();
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
}


