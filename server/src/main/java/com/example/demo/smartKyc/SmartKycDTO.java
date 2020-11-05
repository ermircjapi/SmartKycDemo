package com.example.demo.smartKyc;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class SmartKycDTO
{
    private Integer leftValue;
    private Integer rightValue;

    public SmartKycDTO()
    {
    }

    public SmartKycDTO(Integer leftValue, Integer rightValue)
    {
        this.leftValue = leftValue;
        this.rightValue = rightValue;
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

    @Override
    public boolean equals(Object o)
    {

        if (o == this) return true;
        if (!(o instanceof SmartKycDTO))
        {
            return false;
        }

        SmartKycDTO smartKycDTO = (SmartKycDTO) o;

        return new EqualsBuilder()
            .append(leftValue, smartKycDTO.leftValue)
            .append(rightValue, smartKycDTO.rightValue)
            .isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17, 37)
            .append(leftValue)
            .append(rightValue)
            .toHashCode();
    }

    @Override
    public String toString()
    {
        return "Domino [" + this.leftValue + " : " + this.rightValue + "]";
    }
}