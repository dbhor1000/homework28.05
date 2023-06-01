import java.sql.*;
public class Application {
    public static void main(String[] args) throws SQLException {

        //// Создаем переменные с данными для подключения к базе
        //final String user = "postgres";
        //final String password = "123456";
        //final String url = "jdbc:postgresql://localhost:5432/skypro";
        //
        //// Создаем соединение с базой с помощью Connection
        //// Формируем запрос к базе с помощью PreparedStatement
        //try (final Connection connection = DriverManager.getConnection(url, user, password);
        //     PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee FULL JOIN city ON employee.city_id = city.city_id WHERE id=(?)")) {
        //
        //
        //    // Подставляем значение вместо wildcard
        //    statement.setInt(1, 2);
        //
        //    // Делаем запрос к базе и результат кладем в ResultSet
        //    final ResultSet resultSet = statement.executeQuery();
        //
        //    // Методом next проверяем есть ли следующий элемент в resultSet
        //    // и одновременно переходим к нему, если таковой есть
        //    while (resultSet.next()) {
        //
        //        // С помощью методов getInt и getString получаем данные из resultSet
        //        String firstName = "Title: " + resultSet.getString("first_name");
        //        String lastName = "Title: " + resultSet.getString("last_name");
        //        String gender = "Author_id: " + resultSet.getString("gender");
        //        String city = "Author_id: " + resultSet.getString("city_name");
        //
        //
        //        // Выводим данные в консоль
        //        System.out.println(firstName);
        //        System.out.println(lastName);
        //        System.out.println(gender);
        //        System.out.println(city);
        //
        //    }
        //}

        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        //employeeDAO.addNewEmployee(new Employee(30, "Ivan", "Ivanov", "Male", 22, 3));
        //System.out.println(employeeDAO.readEmployeeById(5));
        //System.out.println(employeeDAO.readAllEmployees());
        //employeeDAO.editEmployee(new Employee(13, "Ivan", "Ivannikov", "Male", 33, 2));
        //employeeDAO.deleteEmployee(new Employee(24, "Ivan", "Ivanov", "Male", 22, 3));

        CityDAOImpl cityDAO = new CityDAOImpl();
        cityDAO.addNewCity(new City("Voronezh"));
        System.out.println(cityDAO.readCityById(3));
        System.out.println(cityDAO.readAllCities());
        cityDAO.editCity(new City(2, "London"));
        cityDAO.deleteCity(new City(9, "Voronezh"));

    }
}
