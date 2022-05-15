
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 05414015011
 */
public class TestClass {
    
    public TestClass() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    void testDirektor(){                                        // Direktör,Memur,txtAcilisi ve databaseAcilisi sınıflarının oluşturulup
        Direktor direktor = new Direktor("Deniz Dilbaz",20000);     // oluşturulmadığını test ettim.
        assertNotNull(direktor,"Direktör oluşturulamadı....");        
    }
    @Test    
    void testMemur(){
        Memur memur = new Memur("Karamoko Bamba",10000);
        assertNotNull(memur,"Memur oluşturulamadı....");
    }
    @Test
    void testtxtAcilis(){
        txtAcilis acilis = new txtAcilis();
        assertNotNull(acilis,"Txt Açılıp işlemler yapılamadı....");
    }
    @Test
    void testdatabaseAcilis(){
        databaseAcilis acilis = new databaseAcilis();
        assertNotNull(acilis,"Database Açılıp işlemler yapılamadı...");
    }
    @Test
    void testAltElemanEkleme(){                                      // alt eleman ekleme işleminin yapılıp yapılmadığını kontrol ettik.
        Direktor direktor = new Direktor("Deniz Dilbaz",20000);
        Memur memur = new Memur("Karamoko Bamba",10000);
        Direktor direktor1 = new Direktor("Cebrayil Karayel",8000); 
        direktor.AltCalisanEkle(memur);
        direktor.AltCalisanEkle(direktor1);
        Calisanlar dizi[] = new Calisanlar[2];
        dizi = direktor.getCalisanlari();
        assertEquals(dizi[0],memur,"ekleme başarısız");
        assertEquals(dizi[1],direktor1,"ekleme başarısız");    
    }
    @Test
    void testMaasHesapla(){                                       // MaliyetHesaplama işleminin doğru yapılıp yapılmadığını test ettim
        Direktor direktor = new Direktor("Deniz Dilbaz",20000);
        Calisanlar memur = new Memur("Karamoko Bamba",10000);
        Calisanlar direktor1 = new Direktor("Cebrayil Karayel",8000); 
        direktor.AltCalisanEkle(direktor1);
        direktor.AltCalisanEkle(memur);
        int sonuc = direktor.MaliyetHesapla();
        assertEquals(38000,sonuc,"Maliyet Hesaplanamadı....");   
        
    }
}
