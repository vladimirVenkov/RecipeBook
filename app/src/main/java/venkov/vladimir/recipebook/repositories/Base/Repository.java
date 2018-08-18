package venkov.vladimir.recipebook.repositories.Base;

import java.util.List;
import java.util.function.Consumer;

public interface Repository<T> {

    void getAll(Consumer<List<T>> action);

    void add(T item, Consumer<T> action);

    void remove(T item, Consumer<T> action);
}
