package Agecalc;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Age {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Ask for date of birth
        System.out.print("Enter your birth year (YYYY): ");
        int year = sc.nextInt();

        System.out.print("Enter your birth month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter your birth day (1-31): ");
        int day = sc.nextInt();

        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();

        // Step 2: Calculate age in years, months, days
        Period age = Period.between(birthDate, today);
        System.out.println("\nYou are " + age.getYears() + " years, " 
                           + age.getMonths() + " months, and " 
                           + age.getDays() + " days old.");

        // Step 3: Calculate total days, hours, minutes, seconds lived
        long totalDays = ChronoUnit.DAYS.between(birthDate, today);
        long totalHours = totalDays * 24;
        long totalMinutes = totalHours * 60;
        long totalSeconds = totalMinutes * 60;

        System.out.println("That's about " + totalDays + " days, or " 
                           + totalHours + " hours, or " 
                           + totalMinutes + " minutes, or " 
                           + totalSeconds + " seconds!");

        // Step 4: Days until next birthday
        LocalDate nextBirthday = birthDate.withYear(today.getYear());
        if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }
        long daysUntilNextBirthday = ChronoUnit.DAYS.between(today, nextBirthday);

        System.out.println("Days until your next birthday: " + daysUntilNextBirthday);

        sc.close();
    }
}