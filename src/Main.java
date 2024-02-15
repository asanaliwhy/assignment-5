package Assignment_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AirplaneDataAccessObject airplaneDAO = new AirplaneDataAccessObject();

      
        Scanner scan = new Scanner(System.in);
        System.out.println("Input NAME, MODEL, AGE, STATUS by spaces:");
        String input1 = scan.nextLine();
      
        String[] dbArguments = input1.split(" ");

        airplaneDAO.addAirplane(dbArguments[0], dbArguments[1], Integer.parseInt(dbArguments[2]), dbArguments[3]);

      
        airplaneDAO.addAirplane("Boeing747", "Passenger", 5, "Available");
        airplaneDAO.addAirplane("AirbusA380", "Cargo", 3, "Adopted");
        airplaneDAO.addAirplane("Cessna172", "Private", 2, "Available");
        airplaneDAO.addAirplane("EmbraerE190", "Passenger", 1, "Available");

      
        List<Airplane> airplanesList = airplaneDAO.getAirplanes();
        System.out.println("All airplanes: " + airplanesList);

        
        airplaneDAO.updateAirplane(2, "Boeing747", "Passenger", 5, "Adopted");

       
        airplanesList = airplaneDAO.getAirplanes();
        System.out.println("Updated airplanes: " + airplanesList);

        System.out.println("AIRPLANE STATUS for 0 el: " + airplanesList.get(0).getStatus() + " NAME: " + airplanesList.get(0).getName());

        for (int i = 0; i < airplanesList.size(); i++) {
            if (Objects.equals(airplanesList.get(i).getStatus(), "Adopted")) {
                System.out.println(" Deleted airplane: " + airplanesList.get(i) + ". YES THIS AIRPLANE WAS ADOPTED!!! :) ");
                airplaneDAO.deleteAirplane(airplanesList.get(i).getId());
            }
        }

        
        airplanesList = airplaneDAO.getAirplanes();
        System.out.println("Final airplanes: " + airplanesList);


        airplaneDAO.closeConnection();
    }
}
