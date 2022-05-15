import java.lang.*;
import java.io.*; 
public interface Calisanlar {			// Firma adinda interface olusturuyoruz
    String getAdSoyad();
    int getEleman_sayisi();
    int getMaas();
    int getSayac();
    void setSayac(int x);
    Calisanlar getUstEleman();
    void setUstEleman(Calisanlar c);
    int MaliyetHesapla();			// Implement ettigimiz siniflarda kullanacagimiz metotlari yaziyoruz.
    void BilgiYazdir(int a);
    String ToString();
}
