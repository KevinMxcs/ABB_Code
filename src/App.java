public class App {
    public static void main(String[] args) throws Exception {
        Arbol abb = new Arbol();

		Nodo raizArbolABB = abb.getRaiz();
		abb.esVacio();
		
		//25, 8, 29, 38, 27
		abb.insertarValor(25);
		abb.insertarValor(8);
		abb.insertarValor(29);
		abb.insertarValor(38);
		abb.insertarValor(27);
		System.out.println("Recorrido en preorden:");
        abb.recorridoPreorden();
		System.out.println("\nRecorrido en inorden:");
        abb.recorridoInorden();
		System.out.println("\nRecorrido en postorden:");
        abb.recorridoPostorden();
		System.out.println("\nImprimiendo arbol en horizontal");
		abb.impArbol();
		System.out.println(abb.buscar(29));
		try{
			abb.eliminarUnNodo(29);
		}catch(Exception e){
		}
		abb.impArbol();
    }
}
