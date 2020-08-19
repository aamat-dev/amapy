package fr.aamat.persistance;

import fr.aamat.model.Ruche;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RucheDAO extends AbstractDAO<Ruche> {
    private Session session = ManageDAO.getSessionFactory().openSession();
    private Transaction tx;

    public RucheDAO() {
    }

    public void create(Ruche obj) {
        this.tx = this.session.beginTransaction();
        this.session.save(obj);
        this.tx.commit();
    }

    public boolean delete(Ruche obj) {
        this.tx = this.session.beginTransaction();
        this.session.remove(obj);
        this.tx.commit();
        return true;
    }

    public boolean update(Ruche obj) {
        this.tx = this.session.beginTransaction();
        this.session.update(obj);
        this.tx.commit();
        return true;
    }

    public Ruche findById(int id) {
        return null;
    }

    public ObservableList<Ruche> findAll() {
        ObservableList<Ruche> ruches = FXCollections.observableArrayList(this.session.createCriteria(Ruche.class).list());
        return ruches;
    }

    public int nextID() {
        ObservableList<Ruche> ruches = FXCollections.observableArrayList(this.session.createCriteria(Ruche.class).list());
        Ruche ruche = (Ruche)ruches.get(ruches.size() - 1);
        return ruche.getId() + 1;
    }
}