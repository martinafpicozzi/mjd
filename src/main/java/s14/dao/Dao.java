package s14.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> { // T = type del dao, esplicita le funzionalità crud che voglio utilizzare

    Optional<T> get(long id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(long id);
}