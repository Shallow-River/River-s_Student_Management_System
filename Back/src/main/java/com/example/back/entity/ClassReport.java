package com.example.back.entity;

import lombok.Data;

@Data
public class ClassReport {
    private Integer classId;

    private String className;

    private Double mathScoreAvg;

    private Double javaScoreAvg;

    private Double engScoreAvg;

    private Double peScoreAvg;

    private Double sumScoreAvg;

    public ClassReport(){
        this.mathScoreAvg = 0.0;
        this.javaScoreAvg = 0.0;
        this.engScoreAvg = 0.0;
        this.peScoreAvg = 0.0;
        this.sumScoreAvg = 0.0;
    }
    public void add(Double math, Double java, Double eng, Double pe, Double sum){
        this.mathScoreAvg += math;
        this.javaScoreAvg += java;
        this.engScoreAvg += eng;
        this.peScoreAvg += pe;
        this.sumScoreAvg += sum;
    }

    public void getAvg(double num){
        this.mathScoreAvg /= num;
        this.javaScoreAvg /= num;
        this.engScoreAvg /= num;
        this.peScoreAvg /= num;
        this.sumScoreAvg /= num;
    }
}
