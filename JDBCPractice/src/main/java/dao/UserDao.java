package dao;

public interface UserDao {
    void select();
    void select(int id);
    void insert(int id,String name,String number);
    void delete(int id);
    void update(int id,String name,String number);
}
