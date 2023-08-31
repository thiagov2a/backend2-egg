package guia15ej01;

import guia15ej01.service.ProductoService;

/**
 *
 * @author Thiago
 */
public class Guia15Ej01Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProductoService productoService = new ProductoService();
        try {
            productoService.imprimirNombreProducto();
            productoService.imprimirNombrePrecioProducto();
            productoService.imprimirProductosEntre120Y202();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
    }

}
