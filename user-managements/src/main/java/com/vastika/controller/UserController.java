package com.vastika.controller;


import com.vastika.enums.OperationTypeEnum;
import com.vastika.model.User;
import com.vastika.service.UserService;
import com.vastika.service.UserServiceImpl;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UserController {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        String decision = "";
        do {
            String choice = JOptionPane.showInputDialog("Which operation you want to perform: save|update|delete|get|list");

            switch (choice) {
                case "save":
                    User saveUser = getUser(OperationTypeEnum.SAVE.name());
                    int saved = userService.saveUser(saveUser);
                    if (saved >= 1) {
                        JOptionPane.showMessageDialog(null, "User info is saved success:");

                    } else {
                        JOptionPane.showMessageDialog(null, "Oops!!! Error in db:");
                    }
                    break;

                case "update":
                    User updateUser = getUser(OperationTypeEnum.UPDATE.name());
                    int updated = userService.updateUser(updateUser);
                    if (updated >= 1) {
                        JOptionPane.showMessageDialog(null, "User info is saved success:");

                    } else {
                        JOptionPane.showMessageDialog(null, "Oops!!! Error in db:");
                    }
                    break;

                case "Delete":
                    int deleteId = Integer.parseInt(JOptionPane.showInputDialog("Provide an Id number you want to delete: "));
                    int deleted = userService.deleteUser(deleteId);
                    if (deleted >= 1) {
                        JOptionPane.showMessageDialog(null, "User info is saved success:");

                    } else {
                        JOptionPane.showMessageDialog(null, "Oops!!! Error in db:");
                    }
                    break;

                case "get":
                    int getId = Integer.parseInt(JOptionPane.showInputDialog("Provide an Id: "));
                    User getUser = userService.getUserById(getId);
                    List<User> userGet = userService.getAllUser();
                    userGet.forEach(user -> {
                        System.out.println("User id is: " + user.getId());
                        System.out.println("User name is: " + user.getUsername());
                        System.out.println("User password is: " + user.getPassword());
                        System.out.println("User MobileNo is: " + user.getMobileNo());
                        System.out.println("User Date is: " + user.getDob());
                        System.out.println("User Salary is: " + user.getSalary());
                        System.out.println("User is enable?: " + user.isEnable());
                        System.out.println("===================================");
                    });
                    break;

                case "list":
                    List<User> userList = userService.getAllUser();
                    userList.forEach(user -> {
                        System.out.println("User id is: " + user.getId());
                        System.out.println("User name is: " + user.getUsername());
                        System.out.println("User password is: " + user.getPassword());
                        System.out.println("User MobileNo is: " + user.getMobileNo());
                        System.out.println("User Date is: " + user.getDob());
                        System.out.println("User Salary is: " + user.getSalary());
                        System.out.println("User is enable?: " + user.isEnable());

                    });
                    break;
            }
            decision = JOptionPane.showInputDialog("DO you want to continue: Yes or No");

        } while (decision.equalsIgnoreCase("yes"));

    }

    public static User getUser(String type) {
        User user = new User();
        if (type.equalsIgnoreCase("update")) {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Id: "));
            user.setId(id);
        }
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");
        Long mobileNo = Long.parseLong(JOptionPane.showInputDialog("Enter Mobile No:"));
        String dob = JOptionPane.showInputDialog("Enter Date in yyy-mm-dd format:");
        LocalDate ld = LocalDate.parse(dob, DateTimeFormatter.ofPattern("yyy-MM-dd"));
        double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter Salary:"));
        boolean enable = Boolean.parseBoolean(JOptionPane.showInputDialog("Enter true/false:"));

        user.setUsername(username);
        user.setPassword(password);
        user.setMobileNo(mobileNo);
        user.setDob(ld);
        user.setSalary(salary);
        user.setEnable(enable);
        return user;
    }
}
