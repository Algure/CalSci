package com.example.ajirigunn.calsci.personal_classes;

/**
 * Created by AJIRI GUNN on 9/27/2017.
 */
public class myfunctions  {
    public String name;
    public String equation;
    public String result;
    public String[] variables;
    public int varcount;


    public myfunctions(String N){
        this.name=N;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String results) {
        this.result = results;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public String[] getVariables() {
        return variables;
    }

    public int getVarcount() {
        return varcount;
    }

    public void setVarcount(int varcount) {
        this.varcount = varcount;
    }

    public void setVariables(String[] variables) {
        this.variables = variables;
    }


}
