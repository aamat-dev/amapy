package fr.aamat.persistance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public abstract class AbstractDAO<T> {

    protected SessionFactory sessionFactory;

    /**
     * ressource de connexion
     */
    public AbstractDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    /**
     * Méthode de création en BDD
     *
     * @param obj objet de type entité paramétrable
     * @return boolean
     */
    public abstract boolean create(T obj);

    /**
     * Méthode pour effacer en BDD
     *
     * @param obj objet de type entité paramétrable
     * @return boolean
     */
    public abstract boolean delete(T obj);

    /**
     * Méthode de mise à jour en BDD
     *
     * @param obj objet de type entité paramétrable
     * @return boolean
     */
    public abstract boolean update(T obj);

    /**
     * Méthode de recherche d'un obj de type entité paramétrable à partir de son identifiant
     * lance un exception à destination de l'interface lorsqu'aucun résultat n'est trouvé
     *
     * @param id valeur de la clé primaire de type int
     * @return T objet de type entité paramétrable
     */
    public abstract T findById(int id);

}
