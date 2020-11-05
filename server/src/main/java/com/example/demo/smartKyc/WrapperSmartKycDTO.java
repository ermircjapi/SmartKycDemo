package com.example.demo.smartKyc;

import java.util.Set;

public class WrapperSmartKycDTO
{
    private Set<SmartKycDTO> smartKycDTOS;
    private SmartKycDTO firstValue;

    public Set<SmartKycDTO> getSmartKycDTOS()
    {
        return smartKycDTOS;
    }

    public void setSmartKycDTOS(Set<SmartKycDTO> smartKycDTOS)
    {
        this.smartKycDTOS = smartKycDTOS;
    }

    public SmartKycDTO getFirstValue()
    {
        return firstValue;
    }

    public void setFirstValue(SmartKycDTO firstValue)
    {
        this.firstValue = firstValue;
    }
}