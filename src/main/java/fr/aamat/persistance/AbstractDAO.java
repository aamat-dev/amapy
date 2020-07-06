package fr.aamat.persistance;

import fr.aamat.model.Ruche;

import java.util.List;

public abstract class AbstractDAO<T> {

    /**
     * ressource de connexion
     */
    public AbstractDAO() {
    }


    /**
     * Méthode de création en BDD
     *
     * @param obj objet de type entité paramétrable
     */
    public abstract void create(T obj);

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


    /**
     * Méthode de recherche de tous les obj
     * lance un exception à destination de l'interface lorsqu'aucun résultat n'est trouvé
     *
     * @return T objet de type entité paramétrable
     */
    public abstract List<T> findAll();
}
