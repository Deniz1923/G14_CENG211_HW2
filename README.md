🎓 Scholarship Evaluation System (Java)Üniversite burs başvurularını otomatik olarak değerlendiren, nesne yönelimli programlama (OOP) prensiplerine dayalı bir Java simülasyonudur1. Sistem; akademik başarı, finansal ihtiyaç ve bilimsel araştırma kriterlerine göre farklı burs türlerini değerlendirir2.🌟 Temel Özellikler🏗️ OOP Mimarisi: Kalıtım (Inheritance), Çok Biçimlilik (Polymorphism) ve Soyutlama kullanılarak esnek bir "Application" iskeleti üzerine kurulmuştur3333.📄 CSV Veri İşleme: Karmaşık haldeki ScholarshipApplications.csv dosyasındaki verileri Applicant ID üzerinden ilişkilendirerek işler4.⚖️ Dinamik Değerlendirme: Üç farklı burs türü için (Merit, Need, Research) özelleşmiş kurallar seti içerir5.📊 Akıllı Sıralama: Sonuçları Applicant ID'ye göre sıralı bir şekilde raporlar6.🎓 Burs Türleri ve KriterleriBurs TürüID Ön EkiOdak NoktasıAna KriterlerMerit-based11Akademik BaşarıGPA (3.20+ Tam, 3.00+ Yarım) 7777Need-based22Finansal İhtiyaçAylık Gelir & Bağımlı Sayısı 888888888Research Grant33Bilimsel KatkıYayın Etki Faktörü (Impact Factor) 9999[!NOTE]Tüm başvurular için GPA ≥ 2.50, geçerli bir Transcript (Y) ve Enrollment Certificate (ENR) zorunludur10.📂 Proje YapısıKod snippet'igraph TD
    A[ScholarshipApplications.csv] --> B{Application Manager}
    B --> C[Merit Application]
    B --> D[Need-based Application]
    B --> E[Research Grant]
    C & D & E --> F[Evaluation Engine]
    F --> G[Sorted Output Report]
🚀 Çalıştırma RehberiBağımlılıklar: Herhangi bir 3. taraf kütüphane gerektirmez, standart java.io paketlerini kullanır11.Dosya Yolu: CSV dosyasının Files/ScholarshipApplications.csv dizininde olduğundan emin olun (Relative Path)12.Encoding: Türkçe karakter desteği için proje kodlamasının UTF-8 olması önerilir13.Derleme:Bashjavac *.java
java Main
📝 Örnek Çıktı FormatıPlaintextApplicant ID: 1101, Name: Liam Smith, Scholarship: Merit, Status: Accepted, Type: Full, Duration: 2 years
Applicant ID: 1120, Name: Oliver Brown, Scholarship: Merit, Status: Rejected, Reason: GPA below 3.0
[!IMPORTANT]Bu proje CENG211 Programming Fundamentals dersi ödevi kapsamında geliştirilmiştir14.
