package com.example.doric7.restaurant.model;

import com.example.doric7.restaurant.enumeration.ContractType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Represents data about contract for each employee.
 */
public class Contract implements Serializable {
    private Integer id;
    private BigDecimal salary;
    private LocalDate startDate;
    private LocalDate endDate;
    private ContractType contractType;

    public Contract(Integer id, BigDecimal salary, LocalDate startDate, LocalDate endDate, ContractType contractType) {
        this.id = id;
        this.salary = salary;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contractType = contractType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public ContractType getConcractType() {
        return contractType;
    }

    public void setConcractType(ContractType contractType) {
        this.contractType = contractType;
    }
}
