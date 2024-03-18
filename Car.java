/**
 * Car object class that makes, the cars given the data and allows them to be sorted
 *
 * CSC 1351 Programming Project No 1
 * Section 2
 *
 * @author Christopher Roman
 * @since 3/17/24
 */


public class Car implements Comparable<Car>{


    private String make;
    private int year;
    private int price;
    /**
     * Constructor for creating a Car object.
     *
     * @param make the make of the car
     * @param year the year of the car
     * @param price the price of the car
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author Christopher Roman
     * @since 3/17/24
     */
    public Car(String make, int year, int price){
        this.make=make;
        this.year=year;
        this.price=price;
    }
    /**
     * Method to get the make of the car.
     *
     * @return the make of the car
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author Christopher Roman
     * @since 3/17/24
     */

    public String getMake(){
        return make;
    }
    /**
     * Method to get the year of the car.
     *
     * @return the year of the car
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author Christopher Roman
     * @since 3/17/24
     */
    public int getYear(){
        return year;
    }
    /**
     * Method to get the price of the car.
     *
     * @return the price of the car
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author Christopher Roman
     * @since 3/17/24
     */
    public int getPrice(){
        return price;
    }
    /**
     * Method to compare two Car objects for sorting.
     *
     * @param other the other Car object to compare with
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author Christopher Roman
     * @since 3/17/24
     */

    public int compareTo(Car other){
        if(!make.equals(other.make))
            return make.compareTo(other.make);
        else if (year != other.year)
            return Integer.compare(year, other.year);
        else
            return Integer.compare(price, other.price);
    }
    /**
     * Method to generate a string representation of the Car object.
     *
     * @return a string representation of the Car object
     *
     * CSC 1351 Programming Project No 1
     * Section 2
     *
     * @author Christopher Roman
     * @since 3/17/24
     */
    @Override
    public String toString(){
        return "Make: " + make + ", Year : " + year + ", Price: " + price + ";";
    }



}

