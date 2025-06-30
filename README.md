# Demo Deneme App

## Proje Tanımı

Demo Deneme App, ürün (Product) yönetimi için geliştirilmiş, Spring Boot ve Java 21 ile yazılmış, çok katmanlı (hexagonal/clean architecture) bir örnek projedir. Proje, ürünleri listeleme ve sorgulama gibi temel işlevleri REST API üzerinden sunar. 

### Varlıklar
- **Product**: Ürünleri temsil eden ana domain nesnesidir. Alanları: `id`, `name`, `price`, `created`.



### Endpointler
- `GET /products?name=...` : Belirli bir isimle eşleşen veya tüm ürünleri listeler.
- `POST /products` : Yeni ürün ekler.
- `GET /` : Basit bir mesaj döner (sağlık kontrolü için).


#### Postman Örnekleri

Tüm ürünleri listele:
```
GET http://localhost:8013/products
```

İsme göre ürünleri listele:
```
GET http://localhost:8013/products?name=elma
```

Ürün ekle:
```
POST http://localhost:8013/products
Content-Type: application/json
{
  "name": "Karpuz",
  "price": 25.0
}
```

Örnek response:
```
{
  "id": 6,
  "name": "Karpuz",
  "price": 25.0
}
```

## Hexagonal (Clean) Architecture ve Modüller
Proje, hexagonal mimariyi uygular ve 4 ana modülden oluşur:

### 1. domain
- Sadece iş kurallarını ve domain nesnelerini (ör. `Product`) içerir.
- Hiçbir dış bağımlılığı yoktur.

### 2. application
- Use case'leri ve servisleri içerir (ör. ürün bulma işlemi).
- Domain katmanına bağımlıdır.
- Port ve interface tanımları burada yer alır.

### 3. adapter
- Dış dünya ile iletişimi sağlar (ör. REST API controller'ları, repository implementasyonları).
- Application ve domain katmanına bağımlıdır.

### 4. bootstrap
- Uygulamanın başlatılmasını ve konfigürasyonunu sağlar.
- Spring Boot ana uygulama sınıfı ve konfigürasyonlar burada bulunur.

#### Modüller Arası İlişki
- `bootstrap` → `adapter` → `application` → `domain`
- Bağımlılıklar tek yönlüdür ve üst katmanlar alt katmanlara doğrudan erişmez.

## Modüllerin Oluşturulması
Projeyi sıfırdan oluşturmak için aşağıdaki adımlar izlenmiştir:

1. **Ana Proje (Parent) ve domain modülü**
   - `mvn archetype:generate` ile ana proje oluşturuldu.
   - `domain` modülü eklendi: `mvn archetype:generate -DartifactId=domain ...`
   - Domain nesneleri (ör. `Product`) burada yazıldı.

2. **application modülü**
   - `mvn archetype:generate -DartifactId=application ...`
   - Use case interface ve servisleri burada tanımlandı.
   - `domain` modülüne bağımlı olarak eklendi.

3. **adapter modülü**
   - `mvn archetype:generate -DartifactId=adapter ...`
   - REST controller ve repository implementasyonları burada yazıldı.
   - `application` ve `domain` modüllerine bağımlı olarak eklendi.

4. **bootstrap modülü**
   - `mvn archetype:generate -DartifactId=bootstrap ...`
   - Spring Boot ana uygulama sınıfı ve konfigürasyonlar burada yazıldı.
   - `adapter` modülüne bağımlı olarak eklendi.

Her modülün kendi `pom.xml` dosyası vardır ve ana proje (`demo-deneme-app/pom.xml`) bu modülleri `<modules>` etiketiyle yönetir.


## Projeyi Çalıştırma

### Gereksinimler
- Java 21
- Maven 3.9+

### Konfigürasyon Dosyaları

- `bootstrap/src/main/resources/application.properties` : Varsayılan (in-memory) konfigürasyon. Uygulama bu dosya ile başlar ve veriler bellekte tutulur.
- `bootstrap/src/main/resources/application-postgresql.properties` : PostgreSQL ile çalışmak için gerekli ayarlar. Bu profil seçildiğinde uygulama verileri gerçek bir PostgreSQL veritabanında saklar.


### PostgreSQL ile Çalışmak

Öncelikle PostgreSQL veritabanını Docker ile başlatın:

```
docker run --name demo-db -e POSTGRES_DB=demo-db -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=Aa123456 -p 5432:5432 -d postgres:16
```

> Not: Port çakışması olursa `-p 5433:5432` gibi farklı bir port kullanabilirsiniz.

### Projeyi Derleme ve Çalıştırma

Tüm platformlar için (proje ana dizininde):
```
./mvnw clean install
./mvnw -pl bootstrap spring-boot:run -D"spring-boot.run.profiles"=postgresql
```

Windows için:
```
mvnw.cmd clean install
mvnw.cmd -pl bootstrap spring-boot:run -D"spring-boot.run.profiles"=postgresql
```

#### Profil Parametresi Açıklaması

- `-D"spring-boot.run.profiles"=postgresql` : Uygulamanın `application-postgresql.properties` dosyasını ve PostgreSQL repository'lerini kullanmasını sağlar. Profil belirtilmezse uygulama in-memory (bellek içi) repository ile çalışır.

### API'yi Test Etme
- `GET http://localhost:8013/products?name=...` ile ürün sorgulayabilirsiniz.
- `POST http://localhost:8013/products` ile ürün ekleyebilirsiniz.
- `GET http://localhost:8013/` ile "Hi Hello!" mesajı alabilirsiniz.

## Notlar
- Her modül bağımsız olarak geliştirilebilir ve test edilebilir.
- Hexagonal mimari sayesinde bağımlılıklar gevşek tutulmuştur.
- Proje, yeni varlıklar ve endpointler eklemek için kolayca genişletilebilir.
- Kodda iş kuralları domain/application katmanında, mapping işlemleri ise merkezi Mapper sınıflarında yönetilir.
