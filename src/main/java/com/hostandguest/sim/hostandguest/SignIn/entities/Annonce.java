package com.hostandguest.sim.hostandguest.SignIn.entities;

import java.util.Date;


public class Annonce {
    private int id_annoce;
    private User id_host;
    private String type_location;
    private String type_logement;
    private int nbr_voyageurs;
    private String sejour_min;
    private String sejour_max;
    private String pays;
    private String rue;
    private String ville;
    private String codePostal;
    private String Photo;
    private String titre;
    private String description;
    private String produit;
    private String internet;
    private String television;
    private String chaufage;
    private String climatisation;
    private String prix;

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getSejour_min() {
        return sejour_min;
    }

    public void setSejour_min(String sejour_min) {
        this.sejour_min = sejour_min;
    }

    public String getSejour_max() {
        return sejour_max;
    }

    public void setSejour_max(String sejour_max) {
        this.sejour_max = sejour_max;
    }

    private String bureau;


    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public String getInternet() {
        return internet;
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }

    public String getTelevision() {
        return television;
    }

    public void setTelevision(String television) {
        this.television = television;
    }

    public String getChaufage() {
        return chaufage;
    }

    public void setChaufage(String chaufage) {
        this.chaufage = chaufage;
    }

    public String getClimatisation() {
        return climatisation;
    }

    public void setClimatisation(String climatisation) {
        this.climatisation = climatisation;
    }

    public String getBureau() {
        return bureau;
    }

    public void setBureau(String bureau) {
        this.bureau = bureau;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Annonce() {
    }

    public int getId_annoce() {
        return id_annoce;
    }

    public void setId_annoce(int id_annoce) {
        this.id_annoce = id_annoce;
    }

    public User getId_host() {
        return id_host;
    }

    public void setId_host(User id_host) {
        this.id_host = id_host;
    }

    public String getType_location() {
        return type_location;
    }

    public void setType_location(String type_location) {
        this.type_location = type_location;
    }

    public String getType_logement() {
        return type_logement;
    }

    public void setType_logement(String type_logement) {
        this.type_logement = type_logement;
    }

    public int getNbr_voyageurs() {
        return nbr_voyageurs;
    }

    public void setNbr_voyageurs(int nbr_voyageurs) {
        this.nbr_voyageurs = nbr_voyageurs;
    }



    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }
}
