/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tunnes (Ayrton Felipe Souza Tunes)
 */

public class CPF {
    private String codigo;
    
    public CPF(String codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public String toString(){
        return this.codigo;
    }
    
}
