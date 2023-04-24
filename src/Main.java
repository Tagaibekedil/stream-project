import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(new User(1, "login", 31, "log.@mail"),
                new User(2, "Esen2", 32, "Alikov.com"), new User(3, "login3", 33, "log.@com"),
                new User(4, "Asan4", 34, "Asan.@ru"),
                new User(5, "Alex5", 35, "Alk.@com"),
                new User(6, "Vad6", 36, "VAD.@mail"),
                new User(7, "BekLog7", 37, "bek.@com"),
                new User(8, "Jax8", 38, "jok.@ru"),
                new User(9, "ERLAN9", 39, "Erik@mail"),
                new User(10, "Maratalimbek", 40, "maratalimbek10@mail"));
        List<UserDto> userDto = users.stream()
                .map(UserDto::new)
                .toList();
        userDto
                .stream()
                .sorted(Comparator.comparingInt(UserDto::getAge))
                .forEach(System.out::println);
        userDto
                .stream()
                .filter(u -> u.getAge() % 2 == 1)
                .forEach(System.out::println);
        userDto
                .stream()
                .filter(u -> u.getLogin().length() < 5)
                .forEach(System.out::println);
        userDto
                .stream()
                .filter(u -> u.getEmail().contains("@com"))
                .forEach(System.out::println);
        userDto
                .forEach(u -> System.out.println(u.getEmail()));
        Integer sum = userDto
                .stream()
                .mapToInt(UserDto::getAge)
                .sum();
        System.out.println(sum);
//        Map<String, String> mapAfter = new HashMap<>();
//        for (User user : users) {
//            mapAfter.put(user.getLogin(), user.getEmail());
//        }
//        System.out.println(mapAfter);
        Map<String, String> map = userDto
                .stream()
                .collect(Collectors.toMap(UserDto::getLogin, UserDto::getEmail));
        System.out.println(map);


    }
}