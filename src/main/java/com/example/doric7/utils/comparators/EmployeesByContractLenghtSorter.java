package com.example.doric7.utils.comparators;


import com.example.doric7.models.Chef;
import com.example.doric7.models.Contract;
import com.example.doric7.models.Deliverer;
import com.example.doric7.models.Waiter;

import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class EmployeesByContractLenghtSorter implements Comparator<Object> {

    @Override
    public int compare(Object object1, Object object2) {
        if (object1 == null || object2 == null)
            throw new IllegalArgumentException("Cannot compare null objects");

        long days1 = extractContractDuration(object1);
        long days2 = extractContractDuration(object2);

        return Long.compare(days1, days2);
    }

    private long extractContractDuration(Object obj) {
        Contract contract = switch (obj) {
            case Chef chef -> chef.getContract();
            case Waiter waiter -> waiter.getContract();
            case Deliverer deliverer -> deliverer.getContract();
            case null, default -> {
                assert obj != null;
                throw new IllegalArgumentException("Unsupported object type: " + obj.getClass());
            }
        };

        if (contract == null || contract.getStartDate() == null || contract.getEndDate() == null) {
            throw new IllegalArgumentException("Invalid contract data");
        }

        return ChronoUnit.DAYS.between(contract.getStartDate(), contract.getEndDate());
    }

}
