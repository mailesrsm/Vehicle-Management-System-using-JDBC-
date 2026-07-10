package com.jdbc;

import java.sql.*;
import java.util.Scanner;

public class vehicle_entity {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/vehicle_entity";
        String username = "root";
        String password = "12345";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Successful");
            int option;

            do {
                System.out.println("VEHICLE MANAGEMENT");
                System.out.println("1.Insert Vehicle");
                System.out.println("2.Get Vehicle By ID");
                System.out.println("3.Get Vehicle By Name");
                System.out.println("4.Update Vehicle");
                System.out.println("5.Delete Vehicle");
                System.out.println("6.Show All Vehicles");
                System.out.println("7.Exit");
                System.out.print("Enter Choice : ");
                option = scan.nextInt();
                scan.nextLine();

                switch (option) {
                case 1:
                    System.out.print("Enter ID : ");
                    int id = scan.nextInt();
                    System.out.print("Enter Year : ");
                    int year = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter Model : ");
                    String model = scan.nextLine();
                    System.out.print("Enter Company Name : ");
                    String name = scan.nextLine();
                    String insert = "INSERT INTO VEHICLE VALUES(?,?,?,?)";
                    PreparedStatement pst1 = con.prepareStatement(insert);
                    pst1.setInt(1, id);
                    pst1.setInt(2, year);
                    pst1.setString(3, model);
                    pst1.setString(4, name);
                    int rows = pst1.executeUpdate();
                    if (rows > 0)
                        System.out.println("Vehicle Inserted Successfully");
                    else
                        System.out.println("Insert Failed");
                    pst1.close();
                    break;
                case 2:
                    System.out.print("Enter Vehicle ID : ");
                    int id1 = scan.nextInt();
                    String getById = "SELECT * FROM VEHICLE WHERE ID=?";
                    PreparedStatement pst2 = con.prepareStatement(getById);
                    pst2.setInt(1, id1);
                    ResultSet rs1 = pst2.executeQuery();
                    if (rs1.next()) {
                        System.out.println(
                                rs1.getInt("ID") + " " +
                                rs1.getInt("YEAR") + " " +
                                rs1.getString("MODEL") + " " +
                                rs1.getString("NAME"));
                    } else {
                        System.out.println("Vehicle Not Found");
                    }
                    rs1.close();
                    pst2.close();
                    break;
                case 3:
                    System.out.print("Enter Company Name : ");
                    String company = scan.nextLine();
                    String getByName = "SELECT * FROM VEHICLE WHERE NAME=?";
                    PreparedStatement pst3 = con.prepareStatement(getByName);
                    pst3.setString(1, company);
                    ResultSet rs2 = pst3.executeQuery();
                    boolean found = false;
                    while (rs2.next()) {
                        found = true;
                        System.out.println(
                                rs2.getInt("ID") + " " +
                                rs2.getInt("YEAR") + " " +
                                rs2.getString("MODEL") + " " +
                                rs2.getString("NAME"));
                    }
                    if (!found) {
                        System.out.println("No Vehicles Found");
                    }
                    rs2.close();
                    pst3.close();
                    break;
                case 4:
                    System.out.print("Enter Vehicle ID : ");
                    int updateId = scan.nextInt();
                    System.out.print("Enter New Year : ");
                    int newYear = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter New Model : ");
                    String newModel = scan.nextLine();
                    System.out.print("Enter New Company Name : ");
                    String newName = scan.nextLine();
                    String update = "UPDATE VEHICLE SET YEAR=?, MODEL=?, NAME=? WHERE ID=?";
                    PreparedStatement pst4 = con.prepareStatement(update);
                    pst4.setInt(1, newYear);
                    pst4.setString(2, newModel);
                    pst4.setString(3, newName);
                    pst4.setInt(4, updateId);
                    int updateRows = pst4.executeUpdate();
                    if (updateRows > 0)
                        System.out.println("Vehicle Updated Successfully");
                    else
                        System.out.println("Vehicle Not Found");
                    pst4.close();
                    break;
                case 5:
                    System.out.print("Enter Vehicle ID : ");
                    int deleteId = scan.nextInt();
                    String delete = "DELETE FROM VEHICLE WHERE ID=?";
                    PreparedStatement pst5 = con.prepareStatement(delete);
                    pst5.setInt(1, deleteId);
                    int deleteRows = pst5.executeUpdate();
                    if (deleteRows > 0)
                        System.out.println("Vehicle Deleted Successfully");
                    else
                        System.out.println("Vehicle Not Found");
                    pst5.close();
                    break;
                case 6:
                    String show = "SELECT * FROM VEHICLE";
                    Statement st = con.createStatement();
                    ResultSet rs3 = st.executeQuery(show);
                    while (rs3.next()) {
                        System.out.println(
                                rs3.getInt("ID") + " " +
                                rs3.getInt("YEAR") + " " +
                                rs3.getString("MODEL") + " " +
                                rs3.getString("NAME"));
                    }
                    rs3.close();
                    st.close();
                    break;
                case 7:
                    System.out.println("Thank You");
                    break;
                default:
                    System.out.println("Invalid Choice");
                }
            } while (option != 7);
            con.close();
            scan.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}