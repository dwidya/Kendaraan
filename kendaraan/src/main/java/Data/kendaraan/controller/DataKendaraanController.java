package Data.kendaraan.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Data.kendaraan.dto.DataKendaraanUpdateReq;
import Data.kendaraan.entity.DataKendaraan;
import Data.kendaraan.service.DataKendaraanService;

@RestController
@RequestMapping("/kendaraan")
public class DataKendaraanController {
    
    private DataKendaraanService dataKendaraanService;

    public DataKendaraanController(DataKendaraanService dataKendaraanService) {
        this.dataKendaraanService = dataKendaraanService;
    }

    @PostMapping("/save")
    @CrossOrigin("*")
    public ResponseEntity<Object> save(@RequestBody DataKendaraan dataKendaraan) {
        return ResponseEntity.ok(dataKendaraanService.save(dataKendaraan));
    }

    @GetMapping("/all")
    @CrossOrigin("*")
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.ok(dataKendaraanService.findAll());
    }

    @PostMapping("/update")
    @CrossOrigin("*")
    public ResponseEntity<Object> update(@RequestBody DataKendaraanUpdateReq req) {
        return ResponseEntity.ok(dataKendaraanService.update(req));
    }

    @GetMapping("/findById/{id}")
    @CrossOrigin("*")
    public ResponseEntity<Object> findById(@PathVariable String id) {
        return ResponseEntity.ok(dataKendaraanService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin("*")
    public void delete(@PathVariable String id) {
        dataKendaraanService.delete(id);
    }
}
