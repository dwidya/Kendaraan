package Data.kendaraan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class KendaraanREstApiApplication {

	public static void main(String[] args) {
        SpringApplication.run(KendaraanREstApiApplication.class, args);
    }


	private KendaraanREstApiApplication dataKendaraanRepository;

	
	public boolean existsByNoRegistrasi(String noRegistrasi) {
		return dataKendaraanRepository.existsByNoRegistrasi(noRegistrasi);
	}
	

}



