/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import org.hibernate.collection.internal.PersistentSet;

/**
 *
 * @author Ouissal
 */
@Entity
@NamedQuery(name = "findAllS", query = "from Salle")
@NamedNativeQuery(name = "findAllMachines", query = "select * from salle", resultClass = Salle.class)
public class Salle implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    
    
    public Salle() {
    }

    public Salle(String code) {
        this.code = code;
    }

   

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Salle{" + "id=" + id + ", code=" + code + '}';
    }

   
    
}
