package com.twic.dto;

public class VilleDTO {
    private String codeCommune;
    private String nomCommune;
    private String codePostal;
    private String libelleAcheminement;
    private String ligne;
    private CoordonneeDTO coordonnee;

    public String getCodeCommune() {
        return codeCommune;
    }

    public void setCodeCommune(String codeCommune) {
        this.codeCommune = codeCommune;
    }

    public String getNomCommune() {
        return nomCommune;
    }

    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getLibelleAcheminement() {
        return libelleAcheminement;
    }

    public void setLibelleAcheminement(String libelleAcheminement) {
        this.libelleAcheminement = libelleAcheminement;
    }

    public String getLigne() {
        return ligne;
    }

    public void setLigne(String ligne) {
        this.ligne = ligne;
    }

    public CoordonneeDTO getCoordonnee() {
        return coordonnee;
    }

    public void setCoordonnee(CoordonneeDTO coordonnee) {
        this.coordonnee = coordonnee;
    }

    public static class CoordonneeDTO {
        private Double latitude;
        private Double longitude;

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }
    }
}
