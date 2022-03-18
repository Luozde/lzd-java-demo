package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Score {
    public String studentId;
    public String scoreYear;
    public Double score;
}
