package com.tch.banking;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Formatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        String fileName = "src/main/resources/ProgrammingAssignment.csv";

        List<Employee> employees = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(Employee.class)
                .build()
                .parse();
        List<Employee> filters = null;

        System.out.println("PLEASE SELECT FILTER \n \n");
        System.out.println(" Enter \n" +
                "  1 for ZIP CODE \n" +
                "  2 for STATE \n" +
                "  3 for CITY \n" +
                "  4 for TYPE \n" +
                "  5 for BANK NAME \n" +
                "  6 for  CITY & STATE \n \n");

        int choice = Integer.parseInt(input.nextLine());

        switch (choice) {
            case 1 :
                System.out.println("Enter ZIP CODE \n ");
                String zipCode = input.next();
                filters = employees.stream()
                        .filter(p -> p.getZipCode().equals(zipCode)).collect(Collectors.toList());
                break;

            case 2 :
                System.out.println("Enter STATE \n ");
                String state = input.next();
                filters = employees.stream()
                        .filter(p -> p.getState().equals(state)).collect(Collectors.toList());
                break;

            case 3 :
                System.out.println("Enter CITY \n ");
                String city = input.nextLine();
                filters = employees.stream()
                        .filter(p -> p.getCity().equals(city)).collect(Collectors.toList());
                break;

            case 4 :
                System.out.println("Enter TYPE \n ");
                String type = input.next();
                filters = employees.stream()
                        .filter(p -> p.getType().equals(type)).collect(Collectors.toList());
                break;

            case 5 :
                System.out.println("Enter BANK NAME \n ");
                String bankName = input.nextLine();
                filters = employees.stream()
                        .filter(p -> p.getBankName().equals(bankName)).collect(Collectors.toList());
                break;

            case 6 :
                System.out.println("Enter CITY \n ");
                String city1 = input.nextLine();

                System.out.println("Enter STATE \n ");
                String state1 = input.next();

                filters = employees.stream()
                        .filter(p -> p.getCity().equals(city1) && p.getState().equals(state1)).collect(Collectors.toList());
                break;

            default:
                System.out.println("Wrong input: " + choice);
        }


        if(filters != null){
            System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s\n","ID", "Bank Name", "Type", "City", "State", "Zip Code");
            for (Employee employee:filters) {

                System.out.printf("%-22s%-22s%-22s%-22s%-22s%-22s\n",employee.getId(),employee.getBankName(),employee.getType(),employee.getCity(),
                        employee.getState(), employee.getZipCode());


            }
        }

        else System.out.println(" Sorry, no data for provided filters ");
    }
}
