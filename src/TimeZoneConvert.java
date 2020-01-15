import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class TimeZoneConvert {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String timeZone;
        boolean bool = true;
        int year, month, date, hrs, mins, ses;

        year = getYear(scanner);
        month = getMonth(scanner);
        date = getDate(scanner);
        hrs = getHour(scanner);
        mins = getMinute(scanner);
        ses = getSeconds(scanner);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DATE, date);
        calendar.set(Calendar.HOUR_OF_DAY, hrs);
        calendar.set(Calendar.MINUTE, mins);
        calendar.set(Calendar.SECOND, ses);

        Date da = calendar.getTime();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("zzzz / z / XXX | yyyy-MM-dd hh:mm:ss a");

        System.out.println(simpleDateFormat.format(da));

        timeZone = getTimeZone(scanner);

        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));

        System.out.println("\nConverted date.");
        System.out.println(simpleDateFormat.format(da));

    }

    private static String getTimeZone(Scanner scanner) {

        String[] validIDs = TimeZone.getAvailableIDs();
        String input;
        boolean bool = false;

        while (true) {

            System.out.println("\nPlease enter timezone to convert time.");
            input= scanner.nextLine();

            for (String str : validIDs) {
                if (str != null && str.equals(input)) {
                    bool = true;
                }
            }
            if (bool) {
                break;
            } else {
                System.out.println("Invalid timezone.\n");
            }
        }

        return input;

    }

    private static int getSeconds(Scanner scanner) {

        String input;

        while (true) {

            System.out.println("Please enter seconds.");

            if (isInt(input = scanner.nextLine())) {
                if (Integer.parseInt(input) <= 60 && Integer.parseInt(input) >= 0) {
                    break;
                } else {
                    System.out.println("Invalid seconds.\n");
                }
            } else {
                System.out.println("Invalid seconds.\n");
            }
        }

        return Integer.parseInt(input);

    }

    private static int getMinute(Scanner scanner) {

        String input;

        while (true) {

            System.out.println("Please enter minutes.");

            if (isInt(input = scanner.nextLine())) {
                if (Integer.parseInt(input) <= 60 && Integer.parseInt(input) >= 0) {
                    break;
                } else {
                    System.out.println("Invalid minutes.\n");
                }
            } else {
                System.out.println("Invalid minutes.\n");
            }
        }

        return Integer.parseInt(input);

    }

    private static int getHour(Scanner scanner) {

        String input;

        while (true) {

            System.out.println("Please enter hours (24hr format).");

            if (isInt(input = scanner.nextLine())) {
                if (Integer.parseInt(input) <= 23 && Integer.parseInt(input) >= 0) {
                    break;
                } else {
                    System.out.println("Invalid hours.\n");
                }
            } else {
                System.out.println("Invalid hours.\n");
            }
        }

        return Integer.parseInt(input);

    }

    private static int getDate(Scanner scanner) {

        String input;

        while (true) {

            System.out.println("Please enter date.");

            if (isInt(input = scanner.nextLine())) {
                if (Integer.parseInt(input) <= 31 && Integer.parseInt(input) >= 1) {
                    break;
                } else {
                    System.out.println("Invalid date.\n");
                }
            } else {
                System.out.println("Invalid date.\n");
            }
        }

        return Integer.parseInt(input);

    }

    private static int getMonth(Scanner scanner) {

        String input;

        while (true) {

            System.out.println("Please enter month.");

            if (isInt(input = scanner.nextLine())) {
                if (Integer.parseInt(input) <= 12 && Integer.parseInt(input) >= 1) {
                    break;
                } else {
                    System.out.println("Invalid month.\n");
                }
            } else {
                System.out.println("Invalid month.\n");
            }
        }

        return Integer.parseInt(input) - 1;

    }

    private static int getYear(Scanner scanner) {

        String input;

        while (true) {

            System.out.println("Please enter year.");

            if (isInt(input = scanner.nextLine())) {
                break;
            } else {
                System.out.println("Invalid year.\n");
            }
        }

        return Integer.parseInt(input);

    }

    private static boolean isInt(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
