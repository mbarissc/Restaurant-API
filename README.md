Restaurant Management API

Bu API, restoran yönetimi için temel CRUD işlemleri sağlayan bir RESTful API sunmaktadır. Restoranlar, masa rezervasyonları ve restoran masaları üzerinde işlem yapmayı mümkün kılar. Kullanıcılar restoranları ekleyebilir, silebilir, masa rezervasyonu yapabilir ve rezervasyonlarını iptal edebilirler.

Teknolojiler

Spring Boot: Java tabanlı framework, REST API'lerini geliştirmek için kullanılmıştır.
JPA: Veritabanı işlemleri için kullanılmıştır.
H2 Database: Veritabanı olarak H2 kullanılıyor. Başka veritabanlarına geçiş yapılabilir.
API Endpoints

1. Restaurant Controller
  POST /api/restaurants/addRestaurants
  Yeni bir restoran ekler.
GET /api/restaurants/getRestaurantById/{id}
Verilen id'ye sahip restoranı getirir.
GET /api/restaurants/getAllRestaurants
Tüm restoranları listeler.
DELETE /api/restaurants/deleteRestaurantById/{id}
Verilen id'ye sahip restoranı siler.
GET /api/restaurants/getRestaurantByName
Restoran adını vererek restoranı arar.
2. Restaurant Table Controller
POST /api/tables/addTables
Yeni bir restoran masası ekler.
GET /api/tables/getTableById/{id}
Verilen id'ye sahip restoran masasını getirir.
GET /api/tables/getAllTables
Tüm restoran masalarını listeler.
DELETE /api/tables/deleteTableById/{id}
Verilen id'ye sahip restoran masasını siler.
POST /api/tables/reserveRestaurantTable
Verilen id'ye sahip restoran masasını bir isimle rezerve eder.
DELETE /api/tables/deleteReservation
Verilen id ve name ile yapılan rezervasyonu iptal eder.
