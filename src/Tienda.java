public class Tienda {
   public String nombre;
   public String direccion;
   private int numArticulos = 0;
   private int numVendedores = 0;

   public Articulo[] artTienda;
   public Vendedor[] vendTienda;

   public Tienda(String nombre, String direccion, int numArticulos, int numVendedores) {
      this.nombre = nombre;
      this.direccion = direccion;
      this.numArticulos = numArticulos;
      this.numVendedores = numVendedores;
      // Creo los arrays para que puedan albergar vendedores y artículos.
      this.artTienda = new Articulo[numArticulos];
      this.vendTienda = new Vendedor[numVendedores];
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getDireccion() {
      return direccion;
   }

   public void setDireccion(String direccion) {
      this.direccion = direccion;
   }

   public int getNumArticulos() {
      return numArticulos;
   }

   public void setNumArticulos(int numArticulos) {
      this.numArticulos = numArticulos;
   }

   public int getNumVendedores() {
      return numVendedores;
   }

   public void setNumVendedores(int numVendedores) {
      this.numVendedores = numVendedores;
   }

   public Articulo[] getArtTienda() {
      return artTienda;
   }

   public void setArtTienda(Articulo[] artTienda) {
      this.artTienda = artTienda;
   }

   public Vendedor[] getVendTienda() {
      return vendTienda;
   }

   public void setVendTienda(Vendedor[] vendTienda) {
      this.vendTienda = vendTienda;
   }

   // -- Métdos de negocio

   public boolean Contratar(Vendedor v1, int posicion) {

      int i = 0;
      // Algoritmo para ubicar al vendedor dentro del array
      i = posicion;
      // Suponemos que en la variable i está la posición

      this.vendTienda[i] = v1;

      return true;
   }

   public boolean addArticulo(Articulo v1, int posicion) {

      int i = 0;
      // Algoritmo para ubicar al vendedor dentro del array
      i = posicion;
      // Suponemos que en la variable i está la posición

      this.artTienda[i] = v1;

      return true;
   }

   /**
    * lista los artículos que dispone una tienda
    * Muestra el nombre del artículo y el número de unidades restantes
    * Si la posición que se recupera no tiene asignado un artículo mostrará el
    * mensaje 'vacío'
    */
   public void listarVendedores() {
      Vendedor v_aux; // Objeto vendedor para recorrer más fácilmente la lista

      for (int cont = 0; cont < this.getNumVendedores(); cont++) {
         v_aux = this.vendTienda[cont];
         if (v_aux != null) {

            System.out.println("[" + cont + "]" + v_aux.getApellidos() + ", " +
                  v_aux.getNombre());
         } else {
            System.out.println("[" + cont + "]" + "Vacío");
         } // endif
      } // endfor

   }

   /**
    * lista los artículos que dispone una tienda
    * Muestra el nombre del artículo y el número de unidades restantes
    * Si la posición que se recupera no tiene asignado un artículo mostrará el
    * mensaje 'vacío'
    */
   public void listarArticulos() {
      Articulo v_aux; // Objeto vendedor para recorrer más fácilmente la lista

      for (int cont = 0; cont < this.getNumArticulos(); cont++) {
         v_aux = this.artTienda[cont];
         if (v_aux != null) {

            System.out.println("[" + cont + "]" + v_aux.getNombre() + ", " +
                  v_aux.getStock());
         } else {
            System.out.println("[" + cont + "]" + "Vacío");
         } // endif
      } // endfor

   }
   public String toString(){
      String result = "";
      result += nombre + " - " + direccion + " - " + numArticulos + " - " + numVendedores;
      return result;
}

} // end class Tienda
