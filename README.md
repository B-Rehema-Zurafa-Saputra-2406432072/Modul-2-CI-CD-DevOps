<details>
<summary>Reflection Modul 3</summary>

### SOLID yang diterapkan (Code yang diubah)

* Single Responsibility Principle (SRP): Memisahkan class CarController dari ProductController.java dan membuatnya file sendiri. Hal ini agar 1 file memiliki 1 pekerjaan.
* Open/Closed Principle (OCP): Memodifikasi metode update pada ProductRepository dan CarRepository. Sekarang update langsung meng-set objek di repo dengan objek baru.
* Liskov Substitution Principle (LSP): Menghilangkan "extends ProductController" di CarController.java. Hal ini karena keduanya tidak memiliki hubungan satu sama lain.
* Dependency Inversion Principle (DIP): Pada CarController, mengubah injeksi @Autowired dari ke concrete class menjadi inteface.

### SOLID Sudah Terterapkan
* Interface Segregation Principle (ISP): interface ProductService dan CarSerevice berisi metode-metode yang benar-benar dibutuhkan.

### Keuntungan menerapkan SOLID:
* Keuntungan SRP: Karena CarController dan ProductController sudah terpisah, untuk mengubah controller untuk suatu model akan mudah.
* Keuntungan OCP: Memudahkan jika menambah field baru pada model.
* Keuntungan DIP: Karena CarController bergantung interface, jika membuat unit test untuk CarController tidak perlu koneksi asli ke CarServiceImpl (bisa di mock).

### Kerugian tidak menerapkan SOLID:
* Kerugian mengabaikan LSP: Kalau CarController masih meng-extends ProductController, maka kita memaksa CarController untuk mewarisi metode-metode Produk.
* Kerugian mengabaikan DIP: Kalau CarController bergantung langsung pada CarServiceImpl, komponen tersebut terikat kuat, sehingga jika ingin membuat impl baru, CarController harus diubah
</details>

<details>
<summary>Reflection Modul 2</summary>
Terdapat beberapa perbaikan isu code yang saya lakukan setelah dideteksi SonarCloud. Pertama, adalah menambah assertions 
untuk test yang belum ada assertionnya. Selain itu, mengganti _floating tag_ pada workflow deploy_azure.yml dengan commit 
hash. Menurut saya implementasi workflow sekarang sudah memenuhi CI dan CD. Untuk bagian CI, setiap ada perubahan kode yang di-push 
atau di-merge ke, workflow sudah memakai Github Actions yang secara otomatis menjalankan rangkaian jobs seperti test suite 
dan sonar. Untuk bagian CD, saya sudah membuat workflow untuk melakukan deployment secara otomatis ke Azure Cloud. Selain itu, saya
juga sudah mengonfigurasi bahwa workflow deploy hanya berjalan jika CI pass semua.
</details>