package ru.letdigit.mhparadox.entities;

import lombok.Data;

@Data
public class MHResult {
    private Integer numbersOfIterations;
    private Boolean changeOfChoice;
    private Integer positiveResults;

    public Integer getNegativeCount() {
        return numbersOfIterations - positiveResults;
    }

    public Double getPercent() {
        return (double) positiveResults / numbersOfIterations;
    }
}
