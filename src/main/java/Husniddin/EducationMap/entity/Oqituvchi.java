package Husniddin.EducationMap.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Oqituvchi {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String ism;
    private String familiya;
    private String nomer;
    @ManyToOne
    private FanTuri fan1;
    @ManyToOne
    private FanTuri fan2;
    @ManyToOne
    private FanTuri fan3;
    private Integer tajriba;
    private Integer togilganyili;
    @ManyToOne
    private Fayl photo;
    @ManyToOne
    private OquvMarkaz oquvMarkaz;
    private String qisqaMalumot;
    private Long oquvchiSoni;
    private Long kursSoni;
    private Boolean status;
    public Oqituvchi() {
    }

    public Oqituvchi(Long id, String ism, String familiya, String nomer, FanTuri fan1, FanTuri fan2, FanTuri fan3, Integer tajriba, Integer togilganyili, Fayl photo, OquvMarkaz oquvMarkaz, String qisqaMalumot, Long oquvchiSoni, Long kursSoni, Boolean status) {
        this.id = id;
        this.ism = ism;
        this.familiya = familiya;
        this.nomer = nomer;
        this.fan1 = fan1;
        this.fan2 = fan2;
        this.fan3 = fan3;
        this.tajriba = tajriba;
        this.togilganyili = togilganyili;
        this.photo = photo;
        this.oquvMarkaz = oquvMarkaz;
        this.qisqaMalumot = qisqaMalumot;
        this.oquvchiSoni = oquvchiSoni;
        this.kursSoni = kursSoni;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsm() {
        return ism;
    }

    public void setIsm(String ism) {
        this.ism = ism;
    }

    public String getFamiliya() {
        return familiya;
    }

    public void setFamiliya(String familiya) {
        this.familiya = familiya;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public FanTuri getFan1() {
        return fan1;
    }

    public void setFan1(FanTuri fan1) {
        this.fan1 = fan1;
    }

    public FanTuri getFan2() {
        return fan2;
    }

    public void setFan2(FanTuri fan2) {
        this.fan2 = fan2;
    }

    public FanTuri getFan3() {
        return fan3;
    }

    public void setFan3(FanTuri fan3) {
        this.fan3 = fan3;
    }

    public Integer getTajriba() {
        return tajriba;
    }

    public void setTajriba(Integer tajriba) {
        this.tajriba = tajriba;
    }

    public Integer getTogilganyili() {
        return togilganyili;
    }

    public void setTogilganyili(Integer togilganyili) {
        this.togilganyili = togilganyili;
    }

    public Fayl getPhoto() {
        return photo;
    }

    public void setPhoto(Fayl photo) {
        this.photo = photo;
    }

    public OquvMarkaz getOquvMarkaz() {
        return oquvMarkaz;
    }

    public void setOquvMarkaz(OquvMarkaz oquvMarkaz) {
        this.oquvMarkaz = oquvMarkaz;
    }

    public String getQisqaMalumot() {
        return qisqaMalumot;
    }

    public void setQisqaMalumot(String qisqaMalumot) {
        this.qisqaMalumot = qisqaMalumot;
    }

    public Long getOquvchiSoni() {
        return oquvchiSoni;
    }

    public void setOquvchiSoni(Long oquvchiSoni) {
        this.oquvchiSoni = oquvchiSoni;
    }

    public Long getKursSoni() {
        return kursSoni;
    }

    public void setKursSoni(Long kursSoni) {
        this.kursSoni = kursSoni;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}



























