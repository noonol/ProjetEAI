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
public class Personnel extends Personne {

    @Override
    public String toString() {
        return "Personnel{" +super.toString()+ '}';
    } 
    
    public Personnel(int idPersonne, String nom, EnumTypePersonne type, float tarif, long tel) {
        super(idPersonne, nom, type, tarif, tel);
    }
    
}
