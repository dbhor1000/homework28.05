import java.util.ArrayList;

public interface CityDAO {

    // Добавление объекта
    void addNewCity(City city);
    // Получение объекта по id
    City readCityById(int id);
    // Получение всех объектов
    ArrayList<City> readAllCities();
    // Изменение объекта по id
    void editCity(City city);
    // Удаление объекта по id
    void deleteCity(City city);

}
