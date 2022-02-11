package com.accenture.main_package;

import com.accenture.entity.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsersComponent {

    public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/db_sot_demo?user=demoAccount&password=password&serverTimezone=UTC";

    public List<User> printUserList() throws Exception {
        List<User> users = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(
                CONNECTION_STRING);

             PreparedStatement preparedStatement = connection
                     .prepareStatement("SELECT * FROM users");
             ResultSet resultSet = preparedStatement.executeQuery();) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("firstname");
                String email = resultSet.getString("email");
                int age = resultSet.getInt("age");
                LocalDate bday = resultSet.getDate("birthday").toLocalDate();

                users.add(new User(id, name, email, age, bday));
            }
        }
        return users;
    }


    public User addUser(User userAdded) throws Exception {

        try (Connection connection = DriverManager.getConnection(
                CONNECTION_STRING);
             PreparedStatement preparedStatement =
                     connection.prepareStatement(
                             "INSERT INTO users "
                                     + "(firstname, email, age, birthday) "
                                     + "VALUES (?, ?, ?, ?)",

                             Statement.RETURN_GENERATED_KEYS);) {

            preparedStatement.setString(1, userAdded.getFirstName());
            preparedStatement.setString(2, userAdded.getEmail());
            preparedStatement.setInt(3, userAdded.getAge());
            preparedStatement.setDate(4, Date.valueOf(userAdded.getBday()));

            preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys();) {

                int autogenkey = 0;

                if (resultSet.next()) {
                    autogenkey = resultSet.getInt(1);
                }
                return new User(autogenkey, userAdded.getFirstName(), userAdded.getEmail(), userAdded.getAge(), userAdded.getBday());

            }
        }
    }


}
