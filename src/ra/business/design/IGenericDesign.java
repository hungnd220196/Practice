package ra.business.design;

public interface IGenericDesign<T, E> {
    void displayAll();

    void addNew();

    void update();

    T findById(E id);

    T changeStatusById(E id);

}
