package Data.kendaraan.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import Data.kendaraan.dto.DataKendaraanUpdateReq;
import Data.kendaraan.entity.DataKendaraan;
import Data.kendaraan.service.DataKendaraanService;


@RestController
@RequestMapping("/kendaraan")
@Configuration

public class DataKendaraanController {
    
    private final DataKendaraanService dataKendaraanService;

    public DataKendaraanController(DataKendaraanService dataKendaraanService) {
        this.dataKendaraanService = dataKendaraanService;
    }

    // Endpoint untuk menyimpan data kendaraan
    @PostMapping("/save")
    @CrossOrigin("*")
    public ResponseEntity<Object> save(@RequestBody DataKendaraan dataKendaraan) {
        // log request for debugging
        System.out.println("Menerima permintaan POST untuk menyimpan data: " + dataKendaraan.getNoRegistrasi());
    
        if (dataKendaraanService.existsByNoRegistrasi(dataKendaraan.getNoRegistrasi())) {
            return ResponseEntity.status(409).body("Data dengan No Registrasi ini sudah ada.");
        }
        return ResponseEntity.ok(dataKendaraanService.save(dataKendaraan));
    }
    // Endpoint untuk memeriksa apakah No Registrasi sudah ada
    @GetMapping("/exists/{noRegistrasi}")
    @CrossOrigin("*")
    public ResponseEntity<Boolean> checkExists(@PathVariable String noRegistrasi) {
        boolean exists = dataKendaraanService.existsByNoRegistrasi(noRegistrasi);
        return ResponseEntity.ok(exists);
    }

    // Endpoint untuk memeriksa apakah Nama Pemilik sudah ada
    @GetMapping("/existsByName/{namaPemilik}")
    @CrossOrigin("*")
    public ResponseEntity<Boolean> checkExistsByName(@PathVariable String namaPemilik) {
        boolean exists = dataKendaraanService.existsBynamaPemilik(namaPemilik);
        return ResponseEntity.ok(exists);
    }

    // Endpoint untuk mendapatkan semua data kendaraan
    @GetMapping("/all")
    @CrossOrigin("*")
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.ok(dataKendaraanService.findAll());
    }

    // Endpoint untuk memperbarui data kendaraan
    @PostMapping("/update")
    @CrossOrigin("*")
    public ResponseEntity<Object> update(@RequestBody DataKendaraanUpdateReq req) {
        return ResponseEntity.ok(dataKendaraanService.update(req));
    }

    // Endpoint untuk menemukan data kendaraan berdasarkan ID
    @GetMapping("/findById/{id}")
    @CrossOrigin("*")
    public ResponseEntity<Object> findById(@PathVariable String id) {
        return ResponseEntity.ok(dataKendaraanService.findById(id));
    }

    // Endpoint untuk menghapus data kendaraan berdasarkan ID
    @DeleteMapping("/delete/{id}")
    @CrossOrigin("*")
    public void delete(@PathVariable String id) {
        dataKendaraanService.delete(id);
    }


    public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedOrigins("*")
                .allowedHeaders("*");
    }
}
    
}
