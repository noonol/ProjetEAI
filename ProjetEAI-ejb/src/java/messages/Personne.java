/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd_eai;

import enumeration.EnumTypePersonne;

/**
 *
 * @author Rigal
 */
public class Personne {

    private int idPersonne;
    private String nom;
    private EnumTypePersonne type;
    private float tarif;
    private long tel;
    
//toString 
     @Override
    public String toString() {
        return "Personne{" + "idPersonne=" + idPersonne + ", nom=" + nom + ", type=" + type + ", tarif=" + tarif + ", tel=" + tel + '}';
    }   
//Constructeur
    public Personne(int idPersonne, String nom, EnumTypePersonne type, float tarif, long tel) {
        this.idPersonne = idPersonne;
        this.nom = nom;
        this.type = type;
        this.tarif = tarif;
        this.tel = tel;
    }  
//Getter et Setter
    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public EnumTypePersonne getType() {
        return type;
    }

    public void setType(EnumTypePersonne type) {
        this.type = type;
    }

    public float getTarif() {
        return tarif;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

}
