package com.example.model;

import com.example.entity.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//exception custom
class CustomException extends Exception{
    private static final long serialVerionUID=1L;
    public CustomException(String str){
        super();
        System.out.println(str);
        EmployeeSystem.operations();
    }
}


public class EmployeeSystem {

    public static Map<Integer, Employee>map=new HashMap<Integer, Employee>();
    public static void addEmployee(String name,int age,int id){
        Employee emp=new Employee(name,age,id);
        map.put(id,emp);
        operations();
    }


    public static void deleteEmployee(int EmpId)throws CustomException{
        if (map.containsKey(EmpId)){
            map.remove(EmpId);
            System.out.println("Successfully Deleted from tge List !!");
        }else {
            throw new CustomException("Not Found Exception");
        }
        operations();
    }


    public static void searchEmployee(int EmpId)throws CustomException{
        if (map.containsKey(EmpId)){
            //map.get(EmpId)
            System.out.println("Employee Details :-" +map.get(EmpId));
        }else {
            throw new CustomException("Not Found Exception!!");
        }
    }


    public static void employeeList(){
        System.out.println(map.toString());
    }





    public static void operations() {
        System.out.println("\n*****Employee management system *****");
        System.out.println("1.Add Employee");
        System.out.println("2.Delete Employee");
        System.out.println("3.Search Employee");
        System.out.println("4.Employee list");
        System.out.println("======================================");
        Scanner scanner1=new Scanner(System.in);
        int userInput=scanner1.nextInt();
        switch (userInput){
            case 1:
                //adds
                System.out.println("Enter Employee Details (name.age.Id):");
                Scanner scanner=new Scanner(System.in);
                String name=scanner.next();
                int age=scanner.nextInt();
                int id=scanner.nextInt();
                    if (!name.equals("")&& age !=0 && id !=0){
                        addEmployee(name,age,id);
                    }
            case 2:
                //delete
                System.out.println("Enter Employee Id");
                Scanner scanner2=new Scanner(System.in);
                int EmpId=scanner2.nextInt();
                try {
                    deleteEmployee(EmpId);
                } catch (CustomException e) {
                    e.printStackTrace();
                }
            case 3:
                //search
                System.out.println("Enter Employee Id");
                Scanner scanner3=new Scanner(System.in);
                EmpId = scanner3.nextInt();
                try {
                    searchEmployee(EmpId);
                }catch (CustomException ex){
                    ex.printStackTrace();
                }
            case 4:
                //list
                employeeList();
                operations();
            default:{
                System.out.println("Not found !");
            }
        }
    }

    public static void main(String[] args) {
        operations();
    }
}

