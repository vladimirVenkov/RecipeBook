package venkov.vladimir.recipebook.repositories;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
import java.util.function.Consumer;

import venkov.vladimir.recipebook.repositories.Base.Repository;

public class FirebaseRepository<T> implements Repository<T> {

    private final FirebaseFirestore mDb;
    private final Class<T> mKlass;
    private final String mCollectionName;

    public FirebaseRepository(Class<T> klass) {
        mDb = FirebaseFirestore.getInstance();
        mKlass = klass;
        mCollectionName = klass.getSimpleName().toLowerCase() + "s";
        //if T is Recipe - > the collection would be recipes
        //if T is Other -> collection would be others
    }
    @Override
    public void getAll(Consumer action) {//todo why is this giving an error if done like in the video?
        mDb.collection(mCollectionName)
                .get()
                .addOnCompleteListener(task -> {
                    List<T> items = task.getResult()
                            .toObjects(mKlass);
                    action.accept(items);
                });
    }


//    @Override
//    public void add(T item, Consumer<T> action) {
//
//    }

    @Override
    public void add(Object item, Consumer action) { //todo why is this giving an error if done like in the video?
        mDb.collection(mCollectionName)
                .add(item)
                .addOnCompleteListener(task -> {
                    action.accept(item);
                });
    }
}
