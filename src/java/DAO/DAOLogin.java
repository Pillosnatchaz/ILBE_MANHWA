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
import pojo.TblUser;
import pojo.TblAdmin;
import pojo.IlbeManhwaUtil;

public class DAOLogin {
    /**to get data Login_admin**/
    public List<TblAdmin> getByAdmin(String uName, String uPass){
        Transaction trans = null;
        TblAdmin ad = new TblAdmin();
        Session session = IlbeManhwaUtil.getSessionFactory().openSession();
        List<TblAdmin> admin = new ArrayList();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblAdmin where adminName=:uName AND adminPassword=:uPass");
            query.setString("uName", uName);
            query.setString("uPass", uPass);
            ad = (TblAdmin) query.uniqueResult();
            admin = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return admin;
    }
    
    /**to get data Login**/
    public List<TblUser> getBy(String uName, String uPass)
    {
       Transaction trans=null;
       TblUser us=new TblUser();
       List<TblUser> user=new ArrayList();
       Session session =IlbeManhwaUtil.getSessionFactory().openSession();
       try{
           trans=session.beginTransaction();
           Query query=session.createQuery("from TblUser where name=:uName AND password=:uPass");
           query.setString("uName",uName);
           query.setString("uPass",uPass);
           us=(TblUser) query.uniqueResult();
           user=query.list();
           trans.commit();
       }
       catch(Exception e){
           System.out.println(e);
       }
       return user;
    }
    /**For add data sign up**/
    public void add_user(TblUser user)
    {
        Transaction trans=null;
        Session session = IlbeManhwaUtil.getSessionFactory().openSession();
        try{
            trans=session.beginTransaction();
            session.save(user);
            trans.commit();
        }
        catch (Exception e){
            System.out.println(e);
        }      
    }
   }       

