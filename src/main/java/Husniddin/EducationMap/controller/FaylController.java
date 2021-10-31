package Husniddin.EducationMap.controller;

import Husniddin.EducationMap.entity.FanTuri;
import Husniddin.EducationMap.entity.Fayl;
import Husniddin.EducationMap.service.FanTuriService;
import Husniddin.EducationMap.service.FaylService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Optional;

@RestController
@RequestMapping("/api/fayl")
@CrossOrigin(origins = "*",maxAge = 3600)
public class FaylController {
    @Autowired
    private FaylService service;
    String url;
    @Value("${system.file-path}")
    private void setFaylUrl(String url) {
        this.url = url;
        new File(url + "/kurs_rasm/").mkdirs();
        new File(url + "/oqituvchi_rasm/").mkdirs();
        new File(url + "/oquv_markaz_rasm/").mkdirs();
        new File(url + "/reklama_rasm/").mkdirs();
        new File(url + "/boshqa/").mkdirs();
    }
    private String getUrl(Fayl f) {
        String papka = "";
        switch (f.getFaylTur()) {
            case KURS_RASM:
                papka = url + "/kurs_rasm/";
                break;
            case OQITUVCHI_RASM:
                papka = url + "/oqituvchi_rasm/";
                break;
            case OQUV_MARKAZ_RASM:
                papka = url + "/oquv_markaz_rasm/";
                break;
            case REKLAMA_RASM:
                papka = url + "/reklama_rasm/";
                break;
            default:
                papka = url + "/boshqa/";
        }
        return papka + +f.getId() + (f.getKengaytma() != null ? "." + f.getKengaytma() : "");
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> getAll() throws Exception{
        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }
    @PostMapping(value = "/")
    public ResponseEntity save(@RequestBody Fayl fayl) throws Exception{
        return  new ResponseEntity(service.add(fayl),HttpStatus.ACCEPTED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception{
        return new ResponseEntity(service.getById(id),HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody Fayl fayl) throws Exception {
        service.update(fayl);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/upload/kurs/{id}")
    public ResponseEntity upload(
            @PathVariable("id") Long faylId,
            @RequestParam("fayl") MultipartFile fayl) throws Exception {
        Fayl f = service.getById(faylId).get();
        if (f != null) {
            String manzil = getUrl(f);
            File fy = new File(manzil);
            fy.createNewFile();
            FileOutputStream fos = new FileOutputStream(fy);
            fos.write(fayl.getBytes());
            fos.flush();
            fos.close();
            f.setHajm((int) fayl.getSize());
            service.update(f);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
