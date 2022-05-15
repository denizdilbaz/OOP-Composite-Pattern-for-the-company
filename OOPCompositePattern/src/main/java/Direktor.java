public class Direktor implements Calisanlar {
	private String adSoyad;
	private int maas;	
	private Calisanlar[] calisanlari ;
        private Calisanlar ustEleman;
	private int eleman_sayisi = 0;
	private static int maasYuku = 0;   // static yapmayinca cevap farkli cikiyor.
        private int sayac = 0 ;
	
	public Direktor(String adSoyad,int maas) {
		this.adSoyad = adSoyad;
		this.maas = maas;
		calisanlari = new Calisanlar[1000];
	}
        @Override
	public int getSayac(){   // sayaci donduruyor
            return sayac;
        }
        public void setSayac(int x){        // sayaci guncelliyor.
            this.sayac = x;
        }
	public int getMaas() {      
		return maas;
	}
        public void resetYuk(){             // maas yukunu resetliyor.
            this.maasYuku = 0 ;
        }
        
	public void setMaas(int maas) throws NegativeMaas {
		if (maas < 0) {					// Olusturdugumuz negativemaas classini kullaniyoruz. Memurdaki gibi
			throw new NegativeMaas();
		}
		else this.maas = maas;
	}

	public Calisanlar[] getCalisanlari() {          // altinda calisanlarin get metodu.
		return calisanlari;
	}

	public void setCalisanlari(Calisanlar[] calisanlari) {      // altinda calisanlar icin set metodu
		this.calisanlari = calisanlari;
	}

	public  int getEleman_sayisi() {            // eleman sayisinin get metodu
		return eleman_sayisi;
	}

	public void setEleman_sayisi(int eleman_sayisi) {       // eleman sayisinin set metodu
		this.eleman_sayisi = eleman_sayisi;
	}

	public String getAdSoyad() {
		return adSoyad;
	}
	public void AltCalisanEkle(Calisanlar a) {		// direkt sona eleman ekliyoruz.
		calisanlari[eleman_sayisi++] = a;
	}
	
	public void AltCalisanCikart(Calisanlar b) {   // aranan elemani cikartiyoruz ve bütün cikarilan elemanin arkasinda elemanlari dizide 1 geriye atiyoruz.
		for(int i = 0 ; i< eleman_sayisi;i++) {
			if (calisanlari[i] == b) {
				while (i< eleman_sayisi) {
					calisanlari[i] = calisanlari[i+1];
					i++;
				}
				break;
			}
			
		}
		
	}
        public void setUstEleman(Calisanlar b){         // direktorler de birinin altinda calisabileceği icin memurdaki gibi 
            this.ustEleman = b;                         // ust eleman set metodu
        }
        public Calisanlar getUstEleman(){               // ust eleman get metodu
            return ustEleman;
        }
	
	public int MaliyetHesapla() {               
            maasYuku += getMaas();                          // oncelikle maas'i maasYukune ekliyoruz.
            for (int i = 0 ; i < getEleman_sayisi();i++){   // kaç elemani varsa altinda calisanlar dizisini geziyoruz.
                if (calisanlari[i].getEleman_sayisi() == 0){  // eger altinda calisan yoksa direkt maasi                  
                    maasYuku+= calisanlari[i].getMaas();
                }
                else {
                    calisanlari[i].MaliyetHesapla();   // altinda calisan varsa her bir calisan icin tekrar maliyetHesapla metodu cagirilir.
                }
            }    
              
            return maasYuku;         //En son maas yuku dondurulur.
	}
	
        public void BilgiYazdir(int sayaci){
            
            setSayac(sayaci);   // sayac degeri parametre degeri ile set edilir.
            for(int c = 0 ; c<getSayac();c++){ // sayac degeri kadar bosluk birakilir bu sayede cikti seklimizi belirliyoruz.
                System.out.print("\t");
            }            
            System.out.println(ToString());   // ve bilgiler yazilir.
            sayac++;   // sayac bir arttırılır.
            for (int i = 0 ; i< getEleman_sayisi();i++){        // eleman sayisi kadar bir for döngüsü
                if (calisanlari[i].getEleman_sayisi() == 0){        // eğer eleman sayısı 0 ise 
                    int a = calisanlari[i].getUstEleman().getSayac();       //ust elemaninin sayac degeri alinir.
                    
                    for (int c = 0 ; c < a+1;c++){     // ust elemaninin sayac degeri+1 tab kadar bosluk birakilir 
                        System.out.print("\t");
                    }
                    System.out.println(calisanlari[i].ToString());  // bilgileri yazdirilir.
                }
                else {
                    calisanlari[i].setSayac(this.getSayac() + 1);           // eger eleman sayisi 0 degilse sayac 1 arttirilir
                    calisanlari[i].BilgiYazdir(calisanlari[i].getSayac());   // tekrar bilgi yazdir metodu calistirilir.
                }                                                               
            }
            
        }
        
        
	public String ToString() {              // ToString metodu override edildi.
		return ("(Direktor)   " + "Adi ve Soyadi: " + getAdSoyad() + " Maas: " + getMaas());	
		
	}

}
