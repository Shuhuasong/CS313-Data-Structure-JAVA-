import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.lang.Class;

public class PlantArrayListExample {

    // TODO: Call the method PrintArrayList to print myGarden
    public static void printArrayList(ArrayList<Plant> myGarden)
    {
        for(int i=0; i<myGarden.size(); i++)
        {

            myGarden.get(i).printInfo();
        }
    }

    // TODO: Define a PrintArrayList method that prints an ArrayList of plant (or flower) objects

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String input;
        // TODO: Declare an ArrayList called myGarden that can hold object of type plant
        ArrayList<Plant> myGarden = new ArrayList<Plant>();
        // TODO: Declare variables - plantName, plantCost, colorOfFlowers, isAnnual
        String plantName;
        String plantCost;
        boolean isAnnual;
        String colorOfFlowers;
        //String plantType;
        //plantType = scnr.nextLine();

        input = scnr.nextLine();

        while(!input.equals("-1"))
        {
            // TODO: Check if input is a plant or flower
            //       Store as a plant object or flower object
            //       Add to the ArrayList myGarden
            //creating object for StringTokenizer class
            StringTokenizer strToken = new StringTokenizer(input);
            while(strToken.hasMoreElements())
            {
                String plantType = strToken.nextToken();
                if(plantType.equals("plant"))
                {
                    Plant plant = new Plant();
                    plant.setPlantName(strToken.nextToken());
                    plant.setPlantCost(strToken.nextToken());
                    myGarden.add(plant);
                }
                if(plantType.equals("flower"))
                {
                    Flower  flower = new Flower();
                    flower.setPlantName(strToken.nextToken());
                    flower.setPlantCost(strToken.nextToken());
                    if(strToken.nextToken().equals("true"))
                        isAnnual = true;

                    else
                        isAnnual = false;
                    flower.setPlantType(isAnnual);
                    flower.setColorOfFlowers(strToken.nextToken());
                    myGarden.add(flower);
                }

            }
            input = scnr.nextLine();

        }
        printArrayList(myGarden);
    }

}
