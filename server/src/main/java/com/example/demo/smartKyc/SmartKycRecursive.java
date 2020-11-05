package com.example.demo.smartKyc;

import java.util.List;

public class SmartKycRecursive
{
    private List<SmartKycDTO> smartKycDTOS;
    private List<SmartKycDTO> chain;
    private SmartKycDTO newSmartKycDTO;

    public SmartKycRecursive()
    {
    }

    public SmartKycRecursive(List<SmartKycDTO> smartKycDTOS, List<SmartKycDTO> chain, SmartKycDTO newSmartKycDTO)
    {
        this.smartKycDTOS = smartKycDTOS;
        this.chain = chain;
        this.newSmartKycDTO = newSmartKycDTO;
    }

    public List<SmartKycDTO> getSmartKycDTOS()
    {
        return smartKycDTOS;
    }

    public void setSmartKycDTOS(List<SmartKycDTO> smartKycDTOS)
    {
        this.smartKycDTOS = smartKycDTOS;
    }

    public List<SmartKycDTO> getChain()
    {
        return chain;
    }

    public void setChain(List<SmartKycDTO> chain)
    {
        this.chain = chain;
    }

    public SmartKycDTO getNewSmartKycDTO()
    {
        return newSmartKycDTO;
    }

    public void setNewSmartKycDTO(SmartKycDTO newSmartKycDTO)
    {
        this.newSmartKycDTO = newSmartKycDTO;
    }
}
