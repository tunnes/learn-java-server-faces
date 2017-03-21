/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ciro
 */
public class Cartao {
    private String numero;

    public Cartao(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return numero;
    }            
}
