
import java.io.*;
import java.util.ArrayList;

public class txtAcilis implements AcilisSekli {
    // constructor metod yazmadim zaten otomatik olarak parametresiz olusturuluyor.
	private BufferedReader dosyaOku;
	public ArrayList<Direktor> ac() throws IOException{ 
            ArrayList<Direktor> direktorler = new ArrayList<Direktor>();
            File dosya = new File("Yeni Metin Belgesi.txt");
            dosyaOku = new BufferedReader(new FileReader(dosya));
            while (true) {
		if(!dosyaOku.ready()) {
                    break;
                }
                String str;
                str = dosyaOku.readLine();  // satir satir okuma yapacagiz
                String [] ayir = new String [3];
                ayir = str.split(",");   // txt'deki verileri , gordugumuzde ayirip ayir dizisine atiyoruz.
                if (ayir[0].equals("D")) {    // eger ayir[0] == "D" ise direktor nesnesi olusturuyoruz.
                    Direktor direktor = new Direktor(ayir[1],Integer.parseInt(ayir[2]));   // Olustururken isim ve maas'i giriyoruz                   
                    direktorler.add(direktor);   // direktorler listesine ekliyoruz
                        if (ayir[3].equals("Root")){      // eger kok ise bir islem yapmiyoruz.
                            continue;
                        }
                        else{                    // kok degil ise altina calisan ekleyecegiz.
                            for (int i = 0; i< direktorler.size() ; i++){   // for dongusu ile direktorlerin listesini geziyoruz.
                                String calisanIsmi = direktorler.get(i).getAdSoyad();  // sadece isme gore alt eleman eklendigi icin 
                                String[] sadece_isim = calisanIsmi.split(" ");         // ad'i ve soyadi ayiriyoruz.
                                if (ayir[3].equals(sadece_isim[0])){                         // eger direktor listesindeki ad ile calisanin bagli oldugu isim eslesirse
                                    direktorler.get(i).AltCalisanEkle(direktor);        // alt calisani olarak ekliyoruz.
                                    direktor.setUstEleman(direktorler.get(i));
                                }
                            }
                        } 
                                
                }
                else if (ayir[0].equals("M")){
                    Memur memur = new Memur(ayir[1],Integer.parseInt(ayir[2]));
                    for (int i = 0; i< direktorler.size() ; i++){   // for dongusu ile direktorlerin listesini geziyoruz.
                        String calisanIsmi = direktorler.get(i).getAdSoyad();  // sadece isme göre alt eleman eklendigi icin 
                        String [] sadece_isim = calisanIsmi.split(" ");         // ad'i ve soyadi ayiriyoruz.
                        if (ayir[3].equals(sadece_isim[0])){                         // eger direktor listesindeki ad ile calisanin bagli oldugu isim eslesirse
                            direktorler.get(i).AltCalisanEkle(memur);        // alt calisani olarak ekliyoruz.
                            memur.setUstEleman(direktorler.get(i));
                        }
                    }
                            
                }
            }
            return direktorler;
        }
        
	
}
