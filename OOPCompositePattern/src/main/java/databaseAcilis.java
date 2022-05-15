import java.io.IOException;
import java.util.ArrayList;
public class databaseAcilis implements AcilisSekli {    // Database'den okuma islemi yapilmadigi icin bos dizi dondurdum 
    public ArrayList<Direktor> ac() throws IOException{            // Eger database'den okuma islemi yapilirsa sadece burdaki kodlar duzenlenerek 
        ArrayList<Direktor> calisanlar = new ArrayList();                // database'den okuma islemi gerceklesmis olacak.
        return calisanlar;
    }
}
