package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        String model = "CarUser2";
        int series = 2;

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);


        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        user1.setUserCar(new Car("CarUser1", 1));
        userService.add(user1);

        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        user2.setUserCar(new Car("CarUser2", 2));
        userService.add(user2);

        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        user3.setUserCar(new Car("CarUser3", 3));
        userService.add(user3);

        User user4 = new User("User4", "Lastname4", "user4@mail.ru");
        user4.setUserCar(new Car("CarUser4", 4));
        userService.add(user4);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Model = " + user.getUserCar().getModel());
            System.out.println("Series = " + user.getUserCar().getSeries());
            System.out.println();
        }

        User one = userService.getUserByModelAndSeries(model, series);
        System.out.println(one);

        context.close();
    }
}
