package Data.kendaraan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Data.kendaraan.dto.DataKendaraanUpdateReq;
import Data.kendaraan.entity.DataKendaraan;
import Data.kendaraan.repository.DataKendaraanRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class DataKendaraanServiceImpl implements DataKendaraanService {

    private final DataKendaraanRepository dataKendaraanRepository;

    public DataKendaraanServiceImpl(DataKendaraanRepository dataKendaraanRepository) {
        this.dataKendaraanRepository = dataKendaraanRepository;
    }

    // Menyimpan data kendaraan
    @Override
    public DataKendaraan save(DataKendaraan dataKendaraan) {
        return dataKendaraanRepository.save(dataKendaraan);
    }

    // Mendapatkan semua data kendaraan
    @Override
    public List<DataKendaraan> findAll() {
        return dataKendaraanRepository.findAll();
    }

    // Mendapatkan data kendaraan berdasarkan nomor registrasi
    @Override
    public DataKendaraan findById(String noRegistrasi) {
        Optional<DataKendaraan> kendaraanOpt = dataKendaraanRepository.findById(noRegistrasi);
        return kendaraanOpt.orElseThrow(() -> 
            new IllegalArgumentException("Data kendaraan dengan nomor registrasi " + noRegistrasi + " tidak ditemukan.")
        );
    }

    // Memperbarui data kendaraan
    @Override
    public DataKendaraan update(DataKendaraanUpdateReq dataKendaraanUpdateReq) {
        DataKendaraan dataKendaraan = findById(dataKendaraanUpdateReq.getNoRegistrasi());
        return update(dataKendaraan, dataKendaraanUpdateReq);
    }

    // Menghapus data kendaraan
    @Override
    public void delete(String noRegistrasi) {
        DataKendaraan dataKendaraan = findById(noRegistrasi);
        dataKendaraanRepository.delete(dataKendaraan);
    }

    // Memeriksa apakah nomor registrasi sudah ada
    @Override
    public boolean existsByNoRegistrasi(String noRegistrasi) {
        return dataKendaraanRepository.existsByNoRegistrasi(noRegistrasi);
    }

    // Memeriksa apakah nama pemilik sudah ada
    @Override
    public boolean existsBynamaPemilik(String namaPemilik) {
        return dataKendaraanRepository.existsByNamaPemilik(namaPemilik);
    }

    // Private method untuk memperbarui data kendaraan
    private DataKendaraan update(DataKendaraan dataKendaraan, DataKendaraanUpdateReq dataKendaraanUpdateReq) {
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
