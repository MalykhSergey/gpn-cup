package com.example.gpn;

import java.util.Objects;

class Nums{
    String intA;
    String intB;
    public String getIntA() {
        return intA;
    }

    public void setIntA(String intA) {
        this.intA = intA;
    }

    public String getIntB() {
        return intB;
    }

    public void setIntB(String intB) {
        this.intB = intB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nums nums = (Nums) o;
        return intA.equals(nums.intA) && intB.equals(nums.intB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intA, intB);
    }
}
