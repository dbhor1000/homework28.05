import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {

    //---> No Hibernate --->
    //final String user = "postgres";
    //final String password = "123456";
    //final String url = "jdbc:postgresql://localhost:5432/skypro";
    //
    //@Override
    //public void addNewEmployee(Employee employee) {
    //
    //    // Формируем запрос к базе с помощью PreparedStatement
    //    try(final Connection connection = DriverManager.getConnection(url, user, password);
    //        PreparedStatement statement = connection.prepareStatement(
    //                "INSERT INTO employee (first_name, last_name, gender, age, city_id) VALUES ((?), (?), (?), (?), (?))")) {
    //
    //        // Подставляем значение вместо wildcard
    //        // первым параметром указываем порядковый номер wildcard
    //        // вторым параметром передаем значение
    //        statement.setString(1, employee.getFirstName());
    //        statement.setString(2, employee.getLastName());
    //        statement.setString(3, employee.getGender());
    //        statement.setInt(4, employee.getAge());
    //        statement.setInt(5, employee.getCityId());
    //
    //        // С помощью метода executeQuery отправляем запрос к базе
    //        statement.executeUpdate();
    //
    //    } catch (SQLException e) {
    //        e.printStackTrace();
    //    }
    //}
    //
    //@Override
    //public Employee readEmployeeById(int id) {
    //
    //    Employee employee = new Employee();
    //    // Формируем запрос к базе с помощью PreparedStatement
    //    try (final Connection connection = DriverManager.getConnection(url, user, password);
    //         PreparedStatement statement = connection.prepareStatement(
    //                 "SELECT * FROM employee WHERE id=(?)")) {
    //
    //        // Подставляем значение вместо wildcard
    //        statement.setInt(1, id);
    //
    //        // Делаем запрос к базе и результат кладем в ResultSet
    //        ResultSet resultSet = statement.executeQuery();
    //
    //        // Методом next проверяем есть ли следующий элемент в resultSet
    //        // и одновременно переходим к нему, если таковой есть
    //        while(resultSet.next()) {
    //
    //            // С помощью методов getInt и getString получаем данные из resultSet
    //            // и присваиваем их полим объекта
    //            employee.setId(Integer.parseInt(resultSet.getString("id")));
    //            employee.setFirstName(resultSet.getString("first_name"));
    //            employee.setLastName(resultSet.getString("last_name"));
    //            employee.setGender(resultSet.getString("gender"));
    //            employee.setAge(resultSet.getInt("age"));
    //            employee.setCityId(resultSet.getInt("city_id"));
    //        }
    //    } catch (SQLException e) {
    //        e.printStackTrace();
    //    }
    //    System.out.println(employee.toString());
    //    return employee;
    //}
    //
    //@Override
    //public ArrayList<Employee> readAllEmployees() {
    //
    //    // Создаем список, в который будем укладывать объекты
    //    ArrayList<Employee> employeeList = new ArrayList<>();
    //
    //    try(final Connection connection = DriverManager.getConnection(url, user, password);
    //        PreparedStatement statement = connection.prepareStatement(
    //                "SELECT * FROM employee")) {
    //
    //        ResultSet resultSet = statement.executeQuery();
    //        while (resultSet.next()) {
    //
    //            int id = Integer.parseInt(resultSet.getString("id"));
    //            String firstName = resultSet.getString("first_name");
    //            String lastName = resultSet.getString("last_name");
    //            String gender = resultSet.getString("gender");
    //            int age = resultSet.getInt("age");
    //            int cityId = resultSet.getInt("city_id");
    //
    //
    //            // Создаем объекты на основе полученных данных
    //            // и укладываем их в итоговый список
    //            employeeList.add(new Employee(id, firstName, lastName, gender, age, cityId));
    //        }
    //    } catch (SQLException e) {
    //        e.printStackTrace();
    //    }
    //
    //    System.out.println(employeeList.toString());
    //    return employeeList;
    //}
    //
    //@Override
    //public void editEmployeeById(int id, String first_name, String last_name, String gender, int age, int city_id) {
    //
    //    try(final Connection connection = DriverManager.getConnection(url, user, password);
    //        PreparedStatement statement = connection.prepareStatement(
    //                "UPDATE employee SET first_name=(?), last_name=(?), gender=(?), age=(?), city_id=(?) WHERE id=(?)")) {
    //
    //        statement.setString(1, first_name);
    //        statement.setString(2, last_name);
    //        statement.setString(3, gender);
    //        statement.setInt(4, age);
    //        statement.setInt(5, city_id);
    //        statement.setInt(6, id);
    //        statement.executeUpdate();
    //
    //    } catch (SQLException e) {
    //        e.printStackTrace();
    //    }
    //}
    //
    //@Override
    //public void deleteEmployeeById(int id) {
    //
    //    try(final Connection connection = DriverManager.getConnection(url, user, password);
    //        PreparedStatement statement = connection.prepareStatement(
    //                "DELETE FROM employee WHERE id=(?)")) {
    //
    //        statement.setInt(1, id);
    //        statement.executeUpdate();
    //
    //    } catch (SQLException e) {
    //        e.printStackTrace();
    //    }
    //}

    @Override
    public void addNewEmployee(Employee employee) {
        // В ресурсах блока try создаем объект сессии с помощью нашего конфиг-файла
        // И открываем сессию
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            // Создаем транзакцию и начинаем ее
            Transaction transaction = session.beginTransaction();
            // вызываем на объекте сессии метод save
            // данный метод внутри себя содержит необходимый запрос к базе
            // для создания новой строки
            session.save(employee);
            // Выполняем коммит, то есть сохраняем изменения,
            // которые совершили в рамках транзакции
            transaction.commit();
        }
    }

    @Override
    public Employee readEmployeeById(int id) {
        // С помощью конфиг-файла получаем сессию, открываем ее
        // и через метод get получаем объект
        // В параметре метода get нужно указать объект какого класса нам нужен
        // и его id
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            return session.get(Employee.class, id);
        }
    }

    @Override
    public ArrayList<Employee> readAllEmployees() {
        ArrayList<Employee> employees = (ArrayList<Employee>)  HibernateSessionFactoryUtil
                .getSessionFactory().openSession().createQuery("From Employee").list();
        return employees;

    }

    @Override
    public void editEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            // Для обновления данных нужно передать в конструктор
            // объект с актуальными данными
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            // Для удаления объекта из таблицы нужно передать его в метод delete
            session.delete(employee);
            transaction.commit();
        }
    }

}
