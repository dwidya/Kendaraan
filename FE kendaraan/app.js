new DataTable('#example');

// Fungsi untuk mengambil data dari API menggunakan GET request
async function fetchData() {
    try {
        const response = await fetch('http://localhost:8080/kendaraan/all');
        
        // Mengecek apakah permintaan berhasil
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        
        const data = await response.json();
        console.log(data);
        
        // Memanggil fungsi untuk menampilkan data ke dalam tabel
        displayData(data);
    } catch (error) {
        console.error('Error:', error);
    }
}

// Fungsi untuk menampilkan data ke dalam tabel
function displayData(data) {
    const tableBody = document.querySelector('#example tbody');
    let html = '';

    data.forEach((kendaraan, index) => {
        html += `
            <tr>
                <td>${index + 1}</td>
                <td>${kendaraan.noRegistrasi}</td>
                <td>${kendaraan.namaPemilik}</td>
                <td>${kendaraan.merkKendaraan}</td>
                <td>${kendaraan.tahunPembuatan}</td>
                <td>${kendaraan.kapasitas}</td>
                <td>${kendaraan.warna}</td>
                <td>${kendaraan.bahanBakar}</td>
                <td>
                    <div>
                        <a href="#" style="color: orange;">Detail</a>
                        <a href="#" style="color: blue;">Edit</a>
                        <a href="#" style="color: red;">Delete</a>
                    </div>
                </td>
            </tr>
        `;
    });

    tableBody.innerHTML = html;
}

// Memanggil fungsi untuk fetch data
fetchData();    

