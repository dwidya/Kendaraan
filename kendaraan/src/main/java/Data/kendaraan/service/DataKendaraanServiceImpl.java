package Data.kendaraan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import Data.kendaraan.dto.DataKendaraanUpdateReq;
import Data.kendaraan.entity.DataKendaraan;
import Data.kendaraan.repository.DataKendaraanRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class DataKendaraanServiceImpl implements DataKendaraanService {
    
    private DataKendaraanRepository dataKendaraanRepository;

    public DataKendaraanServiceImpl(DataKendaraanRepository dataKendaraanRepository) {
        this.dataKendaraanRepository = dataKendaraanRepository;
    }

    public DataKendaraan save(DataKendaraan dataKendaraan) {
        return dataKendaraanRepository.save(dataKendaraan);
    }

    public List<DataKendaraan> findAll() {
        return dataKendaraanRepository.findAll();
    }

    public DataKendaraan findById(String noRegistrasi) {
        return dataKendaraanRepository.findById(noRegistrasi).get();
    }

    public DataKendaraan update(DataKendaraanUpdateReq dataKendaraanUpdateReq) {
        DataKendaraan dataKendaraan = findById(dataKendaraanUpdateReq.getNoRegistrasi());
        return update(dataKendaraan, dataKendaraanUpdateReq);
    }

    public void delete(String noRegistrasi) {
        dataKendaraanRepository.deleteById(noRegistrasi);
    }
    
    private DataKendaraan update(DataKendaraan dataKendaraan, DataKendaraanUpdateReq dataKendaraanUpdateReq) {
        dataKendaraan.setNoRegistrasi(dataKendaraanUpdateReq.getNoRegistrasi());
        dataKendaraan.setNamaPemilik(dataKendaraanUpdateReq.getNamaPemilik());
        dataKendaraan.setAlamat(dataKendaraanUpdateReq.getAlamat());
        dataKendaraan.setMerkKendaraan(dataKendaraanUpdateReq.getMerkKendaraan());
        dataKendaraan.setTahunPembuatan(dataKendaraanUpdateReq.getTahunPembuatan());
        dataKendaraan.setKapasitasSilinder(dataKendaraanUpdateReq.getKapasitasSilinder());
        dataKendaraan.setWarnaKendaraan(dataKendaraanUpdateReq.getWarnaKendaraan());
        dataKendaraan.setBahanBakar(dataKendaraanUpdateReq.getBahanBakar());
        return dataKendaraan;
    }
}
