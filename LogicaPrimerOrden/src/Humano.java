import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;


public class Humano {
	private HashMap<Humano,String> Enlaces = new HashMap<Humano,String>();
	String nombre;
	public Humano(){
		
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public void setEnlace(String string, Humano humano) {
		this.Enlaces.put(humano, string);
	}

	public String getNombre(){
		return this.nombre;
	}
	public void setHijo(Humano hijo){
		this.Enlaces.put(hijo, "hijo");
		Stack<Humano> hermanos=this.getEnlace("hermano");
		Stack<Humano> padres=this.getEnlace("padre");
		Stack<Humano> hijos=this.getEnlace("hijo");
		
		
			hijo.Enlaces.put(this, "padre");
		if(hermanos.size()>0){
			for (Humano hermano : hermanos) {//se asignan los tios al hijo
				hermano.setSobrino(hijo);
			}
		}
		if(padres.size()>0){
			for (Humano padre : padres) {// se asignan los abuelos al hijo
				padre.setNieto(hijo);
			}
		}
		if(hijos.size()>0){
			for (Humano hermano : hijos) {//se asignan los hermanos al hijo
				if(!hermano.equals(hijo)){
					Stack<Humano> brothers=hijo.getEnlace("hermano");
					if(!brothers.contains(hermano)){
						hermano.setHermano(hijo);
					}
				}
			}
		}
	}
	public void setPadre(Humano padre){
		this.Enlaces.put(padre, "padre");
		padre.Enlaces.put(this, "hijo");
		Stack<Humano> hermanos=this.getEnlace("hermano");
		if(hermanos.size()>0){
			for (Humano hermano : hermanos) {//se asignan los hijos al padre
				hermano.setHijo(padre);
			}
		}
	}
	public void setHermano(Humano hermano){
		this.Enlaces.put(hermano, "hermano");
		hermano.Enlaces.put(this, "hermano");
		Stack<Humano> papas=this.getEnlace("padre");
		if(papas.size()>0){
			for (Humano padre : papas) {//se asignan los hermanos a los hermanos
				padre.setHijo(hermano);
			}
		}
		
	}
	public void setTio(Humano tio){
		this.Enlaces.put(tio, "tio");
		tio.Enlaces.put(this, "sobrino");
		Stack<Humano> papa=this.getEnlace("padre");
		if(papa.size()>0){
			for (Humano padre : papa) {//se asignan los hermanos a los hermanos
				padre.setHermano(tio);
			}
		}
	}
	public void setAbuelo(Humano abuelo){
		this.Enlaces.put(abuelo, "abuelo");
		abuelo.Enlaces.put(this, "nieto");
		Stack<Humano> tios=this.getEnlace("hijo");
		if(tios.size()>0){
			for (Humano tio : tios) {//se asignan los hermanos a los hermanos
				Stack<Humano>padres=this.getEnlace("padre");
				if(!padres.contains(tio)){
					this.setTio(tio);
				}
			}
		}
	}
	public void setSobrino(Humano sobrino){
		this.Enlaces.put(sobrino, "sobrino");
		sobrino.Enlaces.put(this, "tio");
	}
	public void setNieto(Humano nieto){
		this.Enlaces.put(nieto, "nieto");
		nieto.Enlaces.put(this, "abuelo");
	}
	
	public Stack<Humano> getEnlace(String string){
		Stack<Humano> enlaces= new Stack<Humano>();
		if(this.Enlaces.containsValue(string)){
			Set<Humano> keys=this.Enlaces.keySet();
			for (Humano humano : keys) {
				if(this.Enlaces.get(humano).equals(string)){
					enlaces.push(humano);
				}
			}
		}
		return enlaces;
	}
	public void showInfo(){
		Collection<Humano> familia=this.Enlaces.keySet();
		for (Humano humano : familia) {
			System.out.println(humano.nombre+" es mi "+this.Enlaces.get(humano));
		}
	}
}
