import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    public static Staff staff = new Staff();
    static int hour = 8, rate = 50, yearsOfExp = 4,
            overtime = 3, overtimeRate = 60;

    public static void main(String[] args) throws IOException, NumberFormatException {
        Staff.StaffInitialize();
        Staff.StaffPrint();
        staff.SalaryToPay(hour, rate);
        staff.SalaryOvertime(overtime, overtimeRate);
        Salary.IsBonus(yearsOfExp);
    }

}

class Person {

    public static String name, lastname, street, city, zipCode;
    public static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void Initialize() throws IOException {
        System.out.print("Enter your name: ");
        name = BR.readLine();
        System.out.print("Enter your last name: ");
        lastname = BR.readLine();
        System.out.print("Enter your street: ");
        street = BR.readLine();
        System.out.print("Enter your city: ");
        city = BR.readLine();
        System.out.print("Enter your zipCode: ");
        zipCode = BR.readLine();
    }

    public static void Print() {
        System.out.println(String.format("Name: %s , Lastname: %s , " +
                "Street: %s , City: %s , Zipcode: %s", name, lastname, street, city, zipCode));
    }

}

interface Salary {
    void SalaryToPay(int hour, int rate);

    default void SalaryOvertime(int hour, int rate) {
        int total = rate * hour;
        System.out.println("Salary overtime: " + total);
    }

    static void IsBonus(int yearsOfExp) {
        String result = yearsOfExp > 5 ? "Bonus $550 per month" : "No bonus";
        System.out.println("Bonus: " + result);
    }
}

class Staff extends Person implements Salary {

    public static String education, position;
    public static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void StaffInitialize() throws IOException {
        Person.Initialize();
        System.out.print("Enter education: ");
        education = BR.readLine();
        System.out.print("Enter position: ");
        position = BR.readLine();
    }

    public static void StaffPrint() {
        Person.Print();
        System.out.println(String.format("Education: %s , Position: %s", education, position));
    }


    @Override
    public void SalaryToPay(int hour, int rate) {
        // TODO Auto-generated method stub
        int total = rate * hour;
        System.out.println("Salary to pay: " + total);
    }
}