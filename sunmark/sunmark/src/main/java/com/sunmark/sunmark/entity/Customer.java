package com.sunmark.sunmark.entity;//package com.sunmark.sunmark.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer2")
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // if you want to update id auto
    @Column(name = "customer_id", length = 10, nullable = false)
    private int customerId;

    @Column(name = "radious_a", nullable = false)
    private int radiousA;

    @Column(name = "radious_b", nullable = false)
    private int radiousB;

    @Column(name = "radious_c", nullable = false)
    private int radiousC;

    @Column(name = "height_a", nullable = false)
    private int heightA;

    @Column(name = "height_b", nullable = false)
    private int heightB;

    @Column(name = "height_c", nullable = false)
    private int heightC;

    @Column(name = "loadvalue", nullable = false)
    private int loadvalie;

    @Column(name = "unloadvalue", nullable = false)
    private int unloadvalie;

    @Column(name = "inputDate")
    private int inputdate;

    public Customer() {
    }

    public Customer(int customerId, int radiousA, int radiousB, int radiousC, int heightA, int heightB, int heightC, int loadvalie, int unloadvalie, int inputdate) {
        this.customerId = customerId;
        this.radiousA = radiousA;
        this.radiousB = radiousB;
        this.radiousC = radiousC;
        this.heightA = heightA;
        this.heightB = heightB;
        this.heightC = heightC;
        this.loadvalie = loadvalie;
        this.unloadvalie = unloadvalie;
        this.inputdate = inputdate;
    }

    public Customer(int customerId, int radiousA, int radiousB, int radiousC, int heightA, int heightB, int heightC, int loadvalie, int unloadvalie, String inputdate) {
    }

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

    public int getInputdate() {
        return inputdate;
    }

    public void setInputdate(int inputdate) {
        this.inputdate = inputdate;
    }
}