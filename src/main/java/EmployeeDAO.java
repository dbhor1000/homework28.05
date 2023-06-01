import java.util.ArrayList;

public interface EmployeeDAO {

    // Добавление объекта
    void addNewEmployee(Employee employee);
    // Получение объекта по id
    Employee readEmployeeById(int id);
    // Получение всех объектов
    ArrayList<Employee> readAllEmployees();
    // Изменение объекта по id
    void editEmployee(Employee employee);
    // Удаление объекта по id
    void deleteEmployee(Employee employee);

}
