package com.sunmark.sunmark.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerSaveRequestDTO {

    private int customerId;
    private int radiousA;
    private int radiousB;
    private int radiousC;
    private int heightA;
    private int heightB;
    private int heightC;
    private int loadvalie;
    private int unloadvalie;
    private String inputdate;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getRadiousA() {
        return radiousA;
    }

    public void setRadiousA(int radiousA) {
        this.radiousA = radiousA;
    }

    public int getRadiousB() {
        return radiousB;
    }

    public void setRadiousB(int radiousB) {
        this.radiousB = radiousB;
    }

    public int getRadiousC() {
        return radiousC;
    }

    public void setRadiousC(int radiousC) {
        this.radiousC = radiousC;
    }

    public int getHeightA() {
        return heightA;
    }

    public void setHeightA(int heightA) {
        this.heightA = heightA;
    }

    public int getHeightB() {
        return heightB;
    }

    public void setHeightB(int heightB) {
        this.heightB = heightB;
    }

    public int getHeightC() {
        return heightC;
    }

    public void setHeightC(int heightC) {
        this.heightC = heightC;
    }

    public int getLoadvalie() {
        return loadvalie;
    }

    public void setLoadvalie(int loadvalie) {
        this.loadvalie = loadvalie;
    }

    public int getUnloadvalie() {
        return unloadvalie;
    }

    public void setUnloadvalie(int unloadvalie) {
        this.unloadvalie = unloadvalie;
    }

    public String getInputdate() {
        return inputdate;
    }

    public void setInputdate(String inputdate) {
        this.inputdate = inputdate;
    }
}
