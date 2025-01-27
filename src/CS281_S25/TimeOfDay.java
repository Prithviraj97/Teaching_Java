package CS281_S25;

public class TimeOfDay {
    public static void main(String[] args) {
        int time = 15;
        String timeOfDay;
        if(time >=5 && time < 12){
            timeOfDay = "Morning";
        } else if(time >= 12 && time < 17){
            timeOfDay = "Afternoon";
        } else if(time >= 17 && time < 20){
            timeOfDay = "Evening";
        } else if(time >= 20 && time < 24){
            timeOfDay = "Night";
        } else if(time >= 0 && time < 5){
            timeOfDay = "Late Night";
        } else {
            timeOfDay = "Invalid Time";
        }
        System.out.println("Time of the day is: "+timeOfDay);
    }
}
