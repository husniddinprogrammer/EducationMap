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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomi;
    private String kunlar;
    private Integer status;

    public HaftaTartibiTur() {
    }

    public HaftaTartibiTur(Long id, String nomi, String kunlar, Integer status) {
        this.id = id;
        this.nomi = nomi;
        this.kunlar = kunlar;
        this.status = status;
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

    public String getKunlar() {
        return kunlar;
    }

    public void setKunlar(String kunlar) {
        this.kunlar = kunlar;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}