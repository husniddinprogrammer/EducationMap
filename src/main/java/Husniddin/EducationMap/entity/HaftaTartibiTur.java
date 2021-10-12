package Husniddin.EducationMap.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class HaftaTartibiTur {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nomi;
    private String status;
    private String kunlar;

    public HaftaTartibiTur() {
    }

    public HaftaTartibiTur(Long id, String nomi, String status, String kunlar) {
        this.id = id;
        this.nomi = nomi;
        this.status = status;
        this.kunlar = kunlar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomi() {
        return nomi;
    }

    public void setNomi(String nomi) {
        this.nomi = nomi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKunlar() {
        return kunlar;
    }

    public void setKunlar(String kunlar) {
        this.kunlar = kunlar;
    }
}
