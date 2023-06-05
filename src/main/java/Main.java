import web.Model.User;
import web.service.UserService;
import web.service.UserServiceImp;

public class Main {
    public static void main(String[] args) {
        User user = new User("Zahar", 22, "ttewwww@emai.ru");
        UserService userService = new UserServiceImp();
        userService.saveUser(user);
        System.out.println(userService.getAllUsers());
    }
}
