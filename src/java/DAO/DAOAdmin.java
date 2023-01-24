/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.TblAdmin;
import pojo.IlbeManhwaUtil;


public class DAOAdmin {
    /**Get Data**/
    public List<TblAdmin> retrveAdmin(){
        List stud = new ArrayList();
        TblAdmin stud1 = new TblAdmin();
        Transaction trans = null;
        Session session = IlbeManhwaUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblAdmin");
            stud = query.list();
            stud.add(stud1.getAdmin_id());
            stud.add(stud1.getUsername());
            stud.add(stud1.getPassword());
            
            trans.commit();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return stud;
    }
    /**Get Data**/
    public List<TblAdmin> getbyId(String idU){
        TblAdmin adm = new TblAdmin();
        List<TblAdmin> iAdm = new ArrayList();
        
        Transaction trans = null;
        Session session = IlbeManhwaUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblAdmin where admin_id = :id");
            query.setString("id", idU);
            adm = (TblAdmin) query.uniqueResult();
            iAdm = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return iAdm;
    }
    
}


    
