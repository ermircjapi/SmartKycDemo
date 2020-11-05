package com.example.demo.smartKyc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SmartKyc
{
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Integer leftValue;

    @Column
    private Integer rightValue;

    public SmartKyc() {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Integer getLeftValue()
    {
        return leftValue;
    }

    public void setLeftValue(Integer leftValue)
    {
        this.leftValue = leftValue;
    }

    public Integer getRightValue()
    {
        return rightValue;
    }

    public void setRightValue(Integer rightValue)
    {
        this.rightValue = rightValue;
    }
}