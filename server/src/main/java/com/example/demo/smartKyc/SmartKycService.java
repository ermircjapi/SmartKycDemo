package com.example.demo.smartKyc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class SmartKycService
{
    private final SmartKycRepository repository;

    @Autowired
    public SmartKycService(SmartKycRepository repository)
    {
        this.repository = repository;
    }

    public Integer getChainWithHighestValue(WrapperSmartKycDTO dto)
    {
        SmartKycDTO firstValue = dto.getFirstValue();
        List<SmartKycDTO> smartKycDTOS = new ArrayList<>(dto.getSmartKycDTOS());
        smartKycDTOS.removeIf(smartKycDTO -> smartKycDTO.equals(firstValue)
            || smartKycDTO.getRightValue().intValue() == smartKycDTO.getLeftValue().intValue());

        Integer rightSideHighestValue = calculateRightSideHighestValue(new ArrayList<>(smartKycDTOS), firstValue);
        Integer leftSideHighestValue = calculateLeftSideHighestValue(new ArrayList<>(smartKycDTOS), firstValue);

        return rightSideHighestValue > leftSideHighestValue ? rightSideHighestValue : leftSideHighestValue;
    }

    private Integer calculateRightSideHighestValue(List<SmartKycDTO> smartKycDTOS, SmartKycDTO start)
    {
        List<Integer> highestValues = new ArrayList<>();
        List<SmartKycDTO> chainList = new ArrayList<>();
        chainList.add(start);
        return getHighestValue(smartKycDTOS, start, highestValues, chainList);
    }

    private Integer calculateLeftSideHighestValue(List<SmartKycDTO> smartKycDTOS, SmartKycDTO start)
    {
        List<Integer> highestValues = new ArrayList<>();
        List<SmartKycDTO> chainList = new ArrayList<>();
        chainList.add(start);
        switchLeftToRight(start);
        return getHighestValue(smartKycDTOS, start, highestValues, chainList);
    }

    private Integer getHighestValue(List<SmartKycDTO> smartKycDTOS, SmartKycDTO start, List<Integer> highestValues,
        List<SmartKycDTO> chainList)
    {
        addCalculatedValuesFromChains(new SmartKycRecursive(smartKycDTOS, chainList, start), highestValues);
        Collections.sort(highestValues);
        Collections.reverse(highestValues);
        return highestValues.get(0);
    }

    private void switchLeftToRight(SmartKycDTO firstValue)
    {
        Integer temp = firstValue.getRightValue();
        firstValue.setRightValue(firstValue.getLeftValue());
        firstValue.setLeftValue(temp);
    }

    private void addCalculatedValuesFromChains(SmartKycRecursive smartKycChain, List<Integer> highestValues)
    {
        List<SmartKycDTO> foundWithEqualValue = smartKycChain.getSmartKycDTOS().stream()
            .filter(smartKycDTO -> this.isOneOfValuesEqual(smartKycDTO, smartKycChain.getNewSmartKycDTO().getRightValue()))
            .collect(Collectors.toList());
        if (foundWithEqualValue.isEmpty())
        {
            Integer calculatedHighestSum = calculateChainSum(smartKycChain.getChain());
            System.out.println(Arrays.toString(new List[]{smartKycChain.getChain()}));
            highestValues.add(calculatedHighestSum);
        }

        List<SmartKycRecursive> recursiveObjects = new ArrayList<>();
        foundWithEqualValue.forEach(nextSmartKycDTO -> {
            List<SmartKycDTO> newSmartKycDTOS = new ArrayList<>(smartKycChain.getSmartKycDTOS());
            newSmartKycDTOS.remove(nextSmartKycDTO);
            SmartKycDTO newSmartKycDTO = createNewSmartKycDTO(smartKycChain.getNewSmartKycDTO(), nextSmartKycDTO);
            List<SmartKycDTO> newChain = new ArrayList<>(smartKycChain.getChain());
            newChain.add(nextSmartKycDTO);
            recursiveObjects.add(new SmartKycRecursive(newSmartKycDTOS, newChain, newSmartKycDTO));
        });
        recursiveObjects.forEach(recursiveObject -> addCalculatedValuesFromChains(recursiveObject, highestValues));
    }

    private boolean isOneOfValuesEqual(SmartKycDTO smartKycDTO, Integer value)
    {
        return smartKycDTO.getLeftValue().equals(value) || smartKycDTO.getRightValue().equals(value);
    }

    private SmartKycDTO createNewSmartKycDTO(SmartKycDTO firstValue, SmartKycDTO secondValue)
    {
        if (firstValue.getRightValue().equals(secondValue.getRightValue()))
        {
            return new SmartKycDTO(firstValue.getLeftValue(), secondValue.getLeftValue());
        }
        return new SmartKycDTO(firstValue.getLeftValue(), secondValue.getRightValue());
    }

    private Integer calculateChainSum(List<SmartKycDTO> smartKycDTOS)
    {
        return IntStream.range(0, smartKycDTOS.size() - 1)
            .mapToObj(index -> findCommonElement(smartKycDTOS.get(index), smartKycDTOS.get(index + 1)))
            .mapToInt(commonElement -> commonElement).sum();
    }

    private Integer findCommonElement(SmartKycDTO firstValue, SmartKycDTO secondValue)
    {
        if (firstValue.getRightValue().equals(secondValue.getRightValue()) ||
            firstValue.getRightValue().equals(secondValue.getLeftValue()))
        {
            return firstValue.getRightValue();
        }
        return firstValue.getLeftValue();
    }
}