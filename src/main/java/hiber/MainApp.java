package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru",
              new Car("subaru", 123)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru",
              new Car("toyota", 34)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru",
              new Car("bmw", 345)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru",
              new Car("lada", 987)));
      userService.add(new User("User5", "LastName5", "user5@mail.ru",
              new Car("KIA", 435)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      System.out.println(userService.getUserByCar("bmw", 345));
      System.out.println(userService.getUserByCar("KIA", 435));
      System.out.println(userService.getUserByCar("sefse", 1314));

      context.close();
   }
}
