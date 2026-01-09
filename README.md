# 🎓 Scholarship Evaluation System (Java)

[cite_start]Bu proje, bir üniversitenin burs komitesinin karar süreçlerini otomatize eden bir Java uygulamasıdır. [cite: 3, 16] [cite_start]Nesne yönelimli programlama (OOP) prensipleri kullanılarak farklı burs türleri değerlendirilir. [cite: 3]

---

### 🌟 Temel Özellikler

* [cite_start]**🏗️ OOP Mimari:** Kalıtım (Inheritance), Çok Biçimlilik (Polymorphism) ve Array List yapıları üzerine inşa edilmiştir. [cite: 3, 5, 6, 8]
* [cite_start]**📄 CSV Veri Yönetimi:** `ScholarshipApplications.csv` dosyasındaki verileri Applicant ID üzerinden eşleştirerek işler. [cite: 20, 21, 22]
* [cite_start]**⚖️ Esnek Değerlendirme:** Farklı başvuru türleri için genel bir "Application" framework'ü sunar. [cite: 18, 19]
* [cite_start]**📊 Düzenli Raporlama:** Sonuçları Applicant ID'ye göre sıralı bir şekilde yazdırır. [cite: 73]

---

### 🎓 Burs Türleri ve Kriterleri



| Burs Türü | ID Ön Eki | Odak Noktası | Temel Kriterler |
| :--- | :---: | :--- | :--- |
| **Merit-based** | `11` | [cite_start]Akademik Başarı [cite: 12] | [cite_start]GPA 3.20+ (Full), 3.00+ (Half) [cite: 39, 40] |
| **Need-based** | `22` | [cite_start]Finansal İhtiyaç [cite: 13] | [cite_start]Aylık Gelir & Bağımlı Sayısı [cite: 46, 47, 50] |
| **Research Grant** | `33` | [cite_start]Bilimsel Katkı [cite: 14] | [cite_start]Yayın Etki Faktörü (Impact Factor) [cite: 55, 56] |

> [cite_start]**Genel Şartlar:** Tüm başvurular için GPA ≥ 2.50, Geçerli Transkript (Y) ve Kayıt Belgesi (ENR) zorunludur. [cite: 34, 35, 36]

---

### 🚀 Kullanım Rehberi

1.  [cite_start]**Bağımlılıklar:** Standart `java.io` paketlerini kullanır, harici kütüphane gerektirmez. [cite: 75]
2.  [cite_start]**Dosya Yolu:** CSV dosyası için `Files/sample.csv` gibi göreceli yollar kullanılmalıdır. [cite: 76]
3.  [cite_start]**Türkçe Karakter:** Proje kodlamasının **UTF8** olduğundan emin olun. [cite: 78]
4.  **Derleme ve Çalıştırma:**

```bash
javac *.java
java Main

📝 Örnek Çıktı Formatı
Plaintext

Applicant ID: 1101, Name: Liam Smith, Scholarship: Merit, Status: Accepted, Type: Full, Duration: 2 years [cite: 71]
Applicant ID: 1120, Name: Oliver Brown, Scholarship: Merit, Status: Rejected, Reason: GPA below 3.0 [cite: 73]
[!IMPORTANT] Bu uygulama CENG211 Programming Fundamentals ödevi kapsamında geliştirilmiştir.
