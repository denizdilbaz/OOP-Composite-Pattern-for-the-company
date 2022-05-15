
import java.lang.*;
import java.io.*; 
public class Memur implements Calisanlar{
	private String adSoyad;   // İsim bir kere girilecegi icin final yaptik.
	private int maas;				// maas artisi yapilabilecegi icin final yapmadik.
	private int sayac;
        private Calisanlar ustEleman;
	public Memur(String adSoyad,int maas) {		//Yapilandirici metot'u yazdik.
		this.adSoyad = adSoyad;
		this.maas = maas;
	}
        public int getSayac(){
            return sayac;
        }
        public void setSayac(int x){
           this.sayac = x;
        }
	public int getMaas() {						// degiskenlerimiz icin get ve set metotlarini olusturduk.
		return maas;
	}
        
	public int getEleman_sayisi(){
            return 0;
        }
	public void setMaas(int maas) throws NegativeMaas {   // maas'in 0'dan kucuk olamayacağini set metodunda kontrol ediyoruz.
		if (maas < 0) {									  // Olusturduğumuz negativemaas classini kullaniyoruz.
			throw new NegativeMaas();
		}
		else this.maas = maas;
	}

	public String getAdSoyad() {
            return adSoyad;
	}

	public int MaliyetHesapla() {			// Memur oldugu icin maliyeti kendi maasi olacaktir.
            return getMaas();
	}
	public void BilgiYazdir(int a){                 // direkt tostring calismakta
            ToString();
        }
        public void setUstEleman(Calisanlar b){         // Memurun üst eleman bilgisini güncelleyen metot
            this.ustEleman = b;
        }
        public Calisanlar getUstEleman(){          // Memurun ust elemanini donduren metot
            return ustEleman;
        }
        
	public String ToString() {				// To String metodunu override ettik memur'a ait bilgilere erismek icin.
            return ("(Memur)   "+"Adi ve Soyadi: " + getAdSoyad() + " Maas: " + getMaas()); 
	}
	
}	