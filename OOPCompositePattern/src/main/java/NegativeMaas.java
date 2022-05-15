public class NegativeMaas extends Exception {		// Exception'dan extend ediyoruz.
	public NegativeMaas() {							// Eger maas < 0 olursa hata mesaji yazdiricaz.
		super("Maas 0'dan kucuk olamaz");
	}
}
