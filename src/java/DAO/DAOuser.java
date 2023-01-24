/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.IlbeManhwaUtil;
import pojo.TblUser;

/**
 *
 * @author Desmita Aprilia
 */
public class DAOuser {
    /**Get Data**/
    public List<TblUser> retrveTblUser(){
        List stud = new ArrayList();
        TblUser stud1 = new TblUser();
        Transaction trans = null;
        Session session = IlbeManhwaUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblUser");
            stud = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return stud;
    }
    /**Search Data**/
    public List<TblUser> getbyID(String idU) {
        TblUser usr = new TblUser();
        List<TblUser> iUsr = new ArrayList();
        
        Transaction trans = null;
        Session session = IlbeManhwaUtil.getSessionFactory().openSession();
        
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblUser where user_id = :id");
            query.setString("id", idU);
            usr = (TblUser) query.uniqueResult();
            iUsr = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return iUsr;
    }
    /**Delete Data**/
    public void deleteUser(Integer idU){
        Transaction trans = null;
        Session session = IlbeManhwaUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            TblUser usr = (TblUser) session.load(TblUser.class, new Integer(idU));
            session.delete(usr);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**Edit Data**/
    public void editUser(TblUser usr){
        Transaction trans = null;
        Session session = IlbeManhwaUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(usr);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**Add Data**/
    public void add_User(TblUser usr){
        Transaction trans = null;
        Session session = IlbeManhwaUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(usr);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Object get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
