package no.hvl.dat100;

public class SorterTabell {
	// Byter om a[i] og a[j]. Antar at både i og j er lovlege indeksar i tabellen.
	private static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// Utvalgssortering / Plukksortering (DAT100) (Selction sort)
	// Sorterer dei første n elmementa i tabellen. Kanskje litt uvanlig
	// Kunne også utelatt n og sortert heile tabellen.

	public static <T extends Comparable<? super T>> void utvalgssortering(T[] a, int n) {

	}

	// Sortering ved innsetting (Insertion sort)
	public static <T extends Comparable<? super T>> void sorteringVedInssetting(T[] a, int n) {
		sorteringVedInssetting(a, 0, n - 1);
	}

	// Sorterer ein del av tabellen, start ... slutt (begge grensene er med)
	public static <T extends Comparable<? super T>> void sorteringVedInssetting(T[] a, int start, int slutt) {
		
	} 

}
