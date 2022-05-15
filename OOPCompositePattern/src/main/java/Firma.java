
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Firma {
    public static void main(String[] args) throws IOException {
        
        /*
            Eger database acilisi da aktif olsaydi veya baska turde acilis sekilleri buraya hangi acılıs seklinin
            kullanilacagini belirleyen kodlar ekleyip ona gore karar verme mekanizmasi olusturulurdu. Su an icin elimizde
            sadece txt oldugu icin direkt txt acilisi yaptım.
        */
        txtAcilis text = new txtAcilis();                                               // txt nesnesi olusturdum
        ArrayList<Direktor> c1 = text.ac();                                             //txt'nin dondurdugu degeri c1 arraylistine atadim 
        int eleman_sayisi = c1.size();                                                  // arraylistin eleman sayisini aldim
        Direktor[] elemanlari = new Direktor[eleman_sayisi];                            // iterator'de kullanilacak diziyi olusturdum.
        for (int i = 0 ; i<eleman_sayisi;i++){                                          // sirayla butun elemanlari diziye atadim
            elemanlari[i] = c1.get(i);
        }
        FirmaIterator iterator = new FirmaIterator(elemanlari);                         // iterator nesnesi olusturdum
        while(iterator.hasNext()){                                                      // iterator null'ı gosterene kadar dönecek bir while döngüsü 
            Direktor direktorr = (Direktor) iterator.next();                            // downcasting
            if (direktorr.getEleman_sayisi()>0){                                        // eger direktorun eleman sayisi 0'dan buyukse
                Calisanlar[] cali = new Calisanlar[direktorr.getEleman_sayisi()];       // calisanlar tipinde bir dizi olusturyoruz.
                cali = direktorr.getCalisanlari();                                      //o direktorun calisanlarini bu diziye atiyoruz.
                for (int x = 0 ;x < direktorr.getEleman_sayisi();x++ ){                 // sirayla direktor'un elemanlarini geziyoruz.
                    if(cali[x].getAdSoyad().equals("Ahmet Egeli")){                     // eger ahmet egeli var ise 
                        int c = cali[x].MaliyetHesapla();                               // maliyetini hesapliyoruz
                        System.out.println("Ahmet Egeli'nin Maaliyeti: " +c);           // ve maliyetini yazdiriyoruz
                    }
                }
            }         
          
            if (direktorr.getAdSoyad().equals("Mustafa Turksever") | direktorr.getAdSoyad().equals("Oguz Demir") ){
                if (direktorr.getAdSoyad().equals("Mustafa Turksever")){            // eger direktor mustafa turksever ise
                    int a = direktorr.MaliyetHesapla();                             // maliyetini hesapla
                    System.out.println("Mustafa Turksever'in Maliyeti: " + a);      //yazdir
                    direktorr.resetYuk();                                           //maas yükünü 0'la diger hesaplamalar icin karismasin
                    direktorr.BilgiYazdir(0);                                       // bilgi yazdir
                }
                else{
                    int b = direktorr.MaliyetHesapla();                             // oguz demir ise 
                    System.out.println("Oguz Demir'in Maliyeti: " + b);             // maliyetini yazdir
                    direktorr.resetYuk();                                           // maas yukunu 0'la diger hesaplar icin karismasin
                    direktorr.BilgiYazdir(0);                                       // bilgi yazdir
                }
            }
        }
        
        
        
        
        
        
        
    }

}
