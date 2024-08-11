package Data.kendaraan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import Data.kendaraan.dto.DataKendaraanUpdateReq;
import Data.kendaraan.entity.DataKendaraan;
import jakarta.transaction.Transactional;

@Transactional
@Service
public interface DataKendaraanService {
    DataKendaraan save(DataKendaraan dataKendaraan);

    List<DataKendaraan> findAll();

    DataKendaraan findById(String noRegistrasi);

    DataKendaraan update(DataKendaraanUpdateReq req);

    void delete(String noRegistrasi);
}
