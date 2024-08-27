package Data.kendaraan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "kendaraan")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DataKendaraan {
    
    @Id
    private String noRegistrasi;

    private String namaPemilik;

    private String alamat;

    private String merkKendaraan ;

    private int tahunPembuatan;

    private int kapasitasSilinder;

    private String warnaKendaraan;

    private String bahanBakar;

    
    @Id
    private Long id;


    @NotNull
    public String getNoRegistrasi() {
        return noRegistrasi;
    }

    public void setNoRegistrasi(String noRegistrasi) {
        this.noRegistrasi = noRegistrasi;
    }
}


