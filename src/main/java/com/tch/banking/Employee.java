package com.tch.banking;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee {
    @CsvBindByPosition(position = 0)
    private String id;

    @CsvBindByPosition(position = 1)
    private String bankName;

    @CsvBindByPosition(position = 2)
    private String type;

    @CsvBindByPosition(position = 3)
    private String city;

    @CsvBindByPosition(position = 4)
    private String state;

    @CsvBindByPosition(position = 5)
    private String zipCode;
}
