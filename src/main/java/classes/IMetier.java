package classes;

import java.io.IOException;
import java.util.List;

public interface IMetier<T,U> {
    public Produit add(T o);
    public List<T> getAll() throws IOException, ClassNotFoundException;
    public T findById(U id);
    public void delete(U id) throws IOException;
    public void saveAll() throws IOException;
}
