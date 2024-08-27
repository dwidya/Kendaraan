package Data.kendaraan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Data.kendaraan.entity.DataKendaraan;

// public interface DataKendaraanRepository extends JpaRepository<DataKendaraan, String> {
    
// }

public interface DataKendaraanRepository extends JpaRepository<DataKendaraan, String> {
    boolean existsByNoRegistrasi(String noRegistrasi);

    boolean existsByNamaPemilik(String namaPemilik);

}