/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientmachine;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Lachgar
 */
public class ClientMachine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            final Hashtable<Object,Object> config=new Hashtable<Object,Object>();
            config.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
            config.put(Context.PROVIDER_URL, "rmi://localhost:1099");
            InitialContext context =new InitialContext(config);
            IDao<Machine> dao = null;
            try {
                dao = (IDao<Machine>) context.lookup("dao");
            } catch (NamingException ex) {
                Logger.getLogger(ClientMachine.class.getName()).log(Level.SEVERE, null, ex);
            }
            IDao<Salle> sdao = null;
            try {
                sdao = (IDao<Salle>) context.lookup("salle");
            } catch (NamingException ex) {
                Logger.getLogger(ClientMachine.class.getName()).log(Level.SEVERE, null, ex);
            }
            List<Machine> m=null;
            dao.create(new Machine("RT55", "TOSHIBA", 7000,null));
            sdao.create(new Salle("cc5"));
        } catch (RemoteException ex) {
            Logger.getLogger(ClientMachine.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ClientMachine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
