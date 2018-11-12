/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.ArrayList;

/**
 *
 * @author drging
 */
public class Cmd {
    private int id,id_produit,qte;
    private String cin_client;
    private Client clients;
    private Produit produits;

    public Cmd() {
    }

    public Cmd(int id, int id_produit, int qte, String cin_client) {
        this.id = id;
        this.id_produit = id_produit;
        this.qte = qte;
        this.cin_client = cin_client;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public String getCin_client() {
        return cin_client;
    }

    public void setCin_client(String cin_client) {
        this.cin_client = cin_client;
    }

    public Client getClients() {
        return clients;
    }

    public void setClients(Client clients) {
        this.clients = clients;
    }

    public Produit getProduits() {
        return produits;
    }

    public void setProduits(Produit produits) {
        this.produits = produits;
    }

   
    
    
}
