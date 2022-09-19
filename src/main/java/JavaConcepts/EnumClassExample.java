package JavaConcepts;

public class EnumClassExample {
    public enum day {Sun, Mon, Tue, Wed, Thur, Fri, Sat}

    public static void main(String args[]) {
        day[] days=day.values();
        for (day dayNow: days) {
            switch (dayNow){
                case Sun:
                    System.out.println("Sunday");
                    break;
                case Mon:
                    System.out.println("Monday");
                    break;
                case Tue:
                    System.out.println("Tuesday");
                    break;
                case Wed:
                    System.out.println("Wednesday");
                    break;
                case Thur:
                    System.out.println("Thursday");
                    break;
                case Fri:
                    System.out.println("Friday");
                    break;
                case Sat:
                    System.out.println("Saturday");
                    break;
                default:
                    System.out.println("Something else");
                    break;
            }
        }

    }
}
