# 🎓 Scholarship Evaluation System (Java)

Bu proje, bir üniversitenin burs komitesinin farklı kriterlere dayalı başvuru değerlendirme süreçlerini otomatize eden bir Java uygulamasıdır. Sistem; akademik başarı, finansal ihtiyaç ve bilimsel araştırma dallarını kapsayan nesne yönelimli (OOP) bir mimari üzerine kurulmuştur.

---

### 🌟 Uygulanan OOP Kavramları

* 
**Kalıtım (Inheritance):** Farklı burs türleri için ortak bir uygulama iskeleti (Application Framework) oluşturulmuştur.


* 
**Çok Biçimlilik (Polymorphism):** Farklı değerlendirme kuralları tek bir çatı altında yönetilir.


* 
**Koleksiyonlar (Array Lists):** Başvuru verileri dinamik listelerde depolanır ve işlenir.


* 
**Dosya İşleme (CSV File I/O):** Veriler `ScholarshipApplications.csv` dosyasından okunur.



---

### 🎓 Burs Türleri ve Değerlendirme Kuralları

| Burs Türü | ID Ön Eki | Değerlendirme Odağı |
| --- | --- | --- |
| **Merit-based** | 11 | Akademik başarı ve tavsiye mektupları.

 |
| **Need-based** | 22 | Aile geliri ve bakmakla yükümlü olunan kişi sayısı.

 |
| **Research Grant** | 33 | Bilimsel yayınlar ve danışman onayları.

 |

#### **Genel Red Sebepleri (Öncelik Sırasıyla)**

1. Öğrenci Belgesi (ENR) eksikliği.


2. Geçerli Transkript (Y) bulunmaması.


3. Genel not ortalamasının (GPA) 2.50'den düşük olması.


4. Zorunlu belgelerin eksik olması.



---

### 📂 Proje Yapısı ve Dosyalar

* 
**Giriş Dosyası:** `ScholarshipApplications.csv` (Başvuru bilgilerini içeren ana dosya).


* **Zorunlu Belgeler:**
* 
`ENR`: Öğrenci Belgesi (Tüm adaylar için zorunlu).


* 
`REC`: Tavsiye Mektubu (Merit-based için duration artırır).


* 
`SAV`: Tasarruf Belgesi (Need-based için eşik değerlerini artırır).


* 
`RSV` / `GRP`: Araştırma Onayı ve Önerisi (Research Grant için gereklidir).





---

### 🚀 Çalıştırma ve Kullanım

1. 
**Derleme:** Standart `java.io` paketleri kullanıldığından harici kütüphane gerekmez.


2. 
**Dosya Yolu:** Veri dosyası için `Files/sample.csv` gibi göreceli yollar kullanılmalıdır.


3. 
**Karakter Seti:** Türkçe karakter desteği için proje kodlaması **UTF-8** olarak ayarlanmalıdır.


4. 
**Sıralama:** Çıktılar **Applicant ID**'ye göre sıralı olarak yazdırılır.



```bash
# Projeyi derlemek için
javac *.java

# Projeyi çalıştırmak için
java Main

```

---

### 📝 Örnek Çıktı

```text
Applicant ID: 1101, Name: Liam Smith, Scholarship: Merit, Status: Accepted, Type: Full, Duration: 2 years
Applicant ID: 1114, Name: Ava Johnson, Scholarship: Merit, Status: Accepted, Type: Half, Duration: 1 year
Applicant ID: 1120, Name: Oliver Brown, Scholarship: Merit, Status: Rejected, Reason: GPA below 3.0

```

---

> [!IMPORTANT]
> Bu proje **CENG211 Homework #2** kapsamında geliştirilmiştir. Teslim formatı `G05_CENG211_HW2` kuralına uygundur.
> 
> 

