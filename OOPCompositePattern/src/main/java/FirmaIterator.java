
import java.util.Iterator;
import java.lang.*;
import java.io.*; 

public class FirmaIterator implements Iterator {
	private Direktor[] calisanlarr;
	private int sira;
	
	public FirmaIterator(Direktor[] calisanlarr) {
            this.calisanlarr = calisanlarr;
	}
	
	public boolean hasNext() {
            if (sira < calisanlarr.length) {
		return true;
            }
            else return false;
	}
	
	public Object next() {
            if (!hasNext())
		return null;
            Direktor calisan = calisanlarr[sira];    
            sira++;
            return calisan;
            
        }	
}
