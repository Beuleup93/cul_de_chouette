package uppa.m1bigdata.devweb.dao;

import uppa.m1bigdata.devweb.pojo.Joueur;

import java.util.List;

public interface  DAO<D> {

    public  D find(int id) throws DAOException;

    public  void create(D data) throws DAOException;

    public  void update(D data) throws DAOException;

    public  void delete(D data) throws DAOException;
    
    public  List<D> getAll() throws DAOException;

    
}
