/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IDao;
import entities.Machine;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Lachgar
 */
public class MachineService extends UnicastRemoteObject implements IDao<Machine> {

    public MachineService() throws RemoteException {
        super();
    }

    @Override
    public boolean create(Machine o) throws RemoteException {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
        }finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public boolean update(Machine o) throws RemoteException {
         Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
        }finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Machine o) throws RemoteException {
         Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
        }finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public List<Machine> findAll() throws RemoteException {
        Session session = null;
        Transaction tx = null;
        List<Machine> machines = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            machines  = session.getNamedQuery("findAll").list();
            tx.commit();
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
        }finally {
            if(session != null)
                session.close();
        }
        return machines;
    }

    @Override
    public Machine findById(int id) throws RemoteException {
         Session session = null;
        Transaction tx = null;
        Machine machine = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            machine  = (Machine) session.get(Machine.class, id);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
        }finally {
            if(session != null)
                session.close();
        }
        return machine;
    }
    @Override
    public List<Machine> findAllMachinesBySalleId(int salleId) throws RemoteException {
    Session session = null;
    List<Machine> machines = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.getNamedQuery("findMachinesBySalleId");
        query.setParameter("salleId", salleId); // Bind the value of ":salleId" parameter
        machines = query.list();
    } catch (HibernateException ex) {
        // Handle the exception as needed
    } finally {
        if (session != null) {
            session.close();
        }
    }
    return machines;
}}