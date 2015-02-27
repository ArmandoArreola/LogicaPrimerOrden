
public class Tarea2 {
	public static void main(String[] args) {
		Humano abuelo=new Humano();
		abuelo.setNombre("Jose");
		Humano tio = new Humano();
		tio.setNombre("Juan");
		Humano papa = new Humano();
		papa.setNombre("Luis");
		Humano sis = new Humano();
		sis.setNombre("Maria");
		Humano yo = new Humano();
		yo.setNombre("Carlos");
		Humano mati = new Humano();
		mati.setNombre("Matias");
		
		abuelo.setHijo(tio);
		tio.setHermano(papa);
		papa.setHijo(sis);
		sis.setHermano(yo);
		sis.setHijo(mati);
		
		System.out.println(abuelo.nombre);
		abuelo.showInfo();
		System.out.println(tio.nombre);
		tio.showInfo();
		System.out.println(papa.nombre);
		papa.showInfo();
		System.out.println(sis.nombre);
		sis.showInfo();
		System.out.println(yo.nombre);
		yo.showInfo();
		System.out.println(mati.nombre);
		mati.showInfo();
	}
}
