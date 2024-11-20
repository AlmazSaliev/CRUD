import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class Main {
    static Person[] customers = new Person[0];
    public static void main(String[] args) {
        Random random = new Random();
        int id = random.nextInt(1,100);//random.nextInt(1,100)
        Person person = new Person("Test1", "test1@gmail.com",LocalDate.of(2024,5,5),"996709159357", id);
        Person person2 = new Person("Test2", "test2@gmail.com",LocalDate.of(2024,5,5),"996709159357", random.nextInt(1,100));
        Person person3 = new Person("Test3", "test3@gmail.com",LocalDate.of(2024,5,5),"996709159357", random.nextInt(1,100));
        Person person4 = new Person("Test4", "test4@gmail.com",LocalDate.of(2024,5,5),"996709159357", random.nextInt(1,100));

        // C
        //addCustomer(person);
        //addCustomer(person2);
        //addCustomer(person3);
        //addCustomer(person4);
        //System.out.println("customers = " + Arrays.toString(customers));

        // R
        //getAllCustomer(customers);

        // R-one
        //getByIdCustomer(id);

        //U
        //updateCustomer(id, person2);

        //D
        //deleteCustomer(1);

    }
    public static void sendInfo(Person[] array, int i){
        System.out.println(" ");
        System.out.println("Все данные пользователя №" + (i+1));
        System.out.println("ID............." + array[i].getId());
        System.out.println("Name..........." + array[i].getFirstName());
        System.out.println("Birthday......." + array[i].getDateOfBirth());
        System.out.println("Phone number..." + array[i].getPhoneNumber());
        System.out.println("Email.........." + array[i].getEmail());
        System.out.println(" ");
    }
    public static void addCustomer(Person person){
        customers = Arrays.copyOf(customers, customers.length + 1);
        customers[customers.length - 1] = person;
    }
    public static void getAllCustomer(Person[] array){
        if(array.length == 0){
            System.out.println("Нет данных!");
        }else{
            System.out.println("Все пользователи = " + array.length);
            for (int i = 0; i < array.length; i++) {
                sendInfo(array,i);
            }
        }
    }
    public static void getByIdCustomer(int id){
        for (int i = 0; i < customers.length; i++) {
            if(customers[i].getId() == id) {
                sendInfo(customers, i);
            }else {
                System.out.println("Пользователь по ID "+id+" не найден!");
            }
        }
    }
    public static void updateCustomer(int id, Person person){
        for (int i = 0; i < customers.length; i++) {
            if(customers[i].getId() == id) {
                System.out.println("Пользователь по ID " + id + " был отредактирован!");
                customers[i] = person;
                sendInfo(customers, i);
            }else {
                System.out.println("Пользователь по ID "+id+" не найден! или введите корректный ID");
            }
        }
    }
    public static void deleteCustomer(int id){
        Person[] newList = new Person[0];
        for (int i = 0; i < customers.length; i++) {
            if(customers[i].getId() == id) {
                System.out.println("Пользователь по ID " + id + " был удален!");
            }else{
               newList = Arrays.copyOf(newList, newList.length+1);
               newList[newList.length -1] = customers[i];
            }
        }
        customers = newList;
        for (int i = 0; i < customers.length; i++) {
            sendInfo(customers, i);
        }
    }
}