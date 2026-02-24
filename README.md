## Reflection
Terdapat beberapa perbaikan isu code yang saya lakukan setelah dideteksi SonarCloud. Pertama, adalah menambah assertions 
untuk test yang belum ada assertionnya. Selain itu, mengganti _floating tag_ pada workflow deploy_azure.yml dengan commit 
hash. Menurut saya implementasi workflow sekarang sudah memenuhi CI dan CD. Untuk bagian CI, setiap ada perubahan kode yang di-push 
atau di-merge ke, workflow sudah memakai Github Actions yang secara otomatis menjalankan rangkaian jobs seperti test suite 
dan sonar. Untuk bagian CD, saya sudah membuat workflow untuk melakukan deployment secara otomatis ke Azure Cloud. Selain itu, saya
juga sudah mengonfigurasi bahwa workflow deploy hanya berjalan jika CI pass semua.