package Data.kendaraan.dto;

import lombok.Getter;

@Getter

public class DataKendaraanUpdateReq {
    
    private String noRegistrasi;

    private String namaPemilik;

    private String alamat;

    private String merkKendaraan ;

    private int  tahunPembuatan;

    private int kapasitasSilinder;

    private String warnaKendaraan;

    private String bahanBakar;

}