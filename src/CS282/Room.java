package CS282;

public class Room {
    public static void main(String[] args) {
        Shelter shelter = new Shelter("room256", 100);
        shelter.printInfo();
    }
}

class Shelter {
    String code = "room256";
    int numOfSeats;

    public Shelter(String classCode,int numOfSeats) {
        this.numOfSeats = numOfSeats;
        this.code = classCode;
    }

    public void printInfo() {
        System.out.println("Code: " + code + " Seats: " + numOfSeats);
    }

}
