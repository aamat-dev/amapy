package fr.aamat.persistance;

import fr.aamat.model.Ruche;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import java.util.List;

public class RucheDAO extends AbstractDAO<Ruche> {

    private Session session;

    public RucheDAO() {
        session = ManageDAO.getSessionFactory().openSession();
        session.beginTransaction();
    }

    @Override
    public void create(Ruche obj) {
        session.save(obj);
        session.getTransaction().commit();
    }

    @Override
    public boolean delete(Ruche obj) {
        return false;
    }

    @Override
    public boolean update(Ruche obj) {
        return false;
    }


    @Override
    public Ruche findById(int id) {
        return null;
    }

    @Override
    public ObservableList<Ruche> findAll() {
        ObservableList<Ruche> ruches = FXCollections.observableArrayList(session.createCriteria(Ruche.class).list());
        session.close();
        return ruches;
    }

}
