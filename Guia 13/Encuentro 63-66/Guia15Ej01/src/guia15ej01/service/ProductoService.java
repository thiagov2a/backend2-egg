package guia15ej01.service;

import guia15ej01.entity.Producto;
import guia15ej01.persistence.ProductoDAO;
import java.util.Collection;

/**
 *
 * @author Thiago
 */
public class ProductoService {

    private final ProductoDAO dao;

    public ProductoService() {
        this.dao = new ProductoDAO();
    }

    public Collection<Producto> listarNombreProducto() throws Exception {
        try {
            Collection<Producto> productos = dao.listarNombreProducto();
            return productos;
        } catch (Exception e) {
            throw new Exception("Error al listar los nombres de productos.", e);
        }
    }

    public void imprimirNombreProducto() throws Exception {
        try {
            Collection<Producto> productos = listarNombreProducto();
            if (productos.isEmpty()) {
                throw new Exception("No hay productos para imprimir");
            } else {
                System.out.println("Lista de productos:");
                System.out.format("+--------+---------------------------------+%n");
                System.out.format("| %-6s | %-31s |%n", "Código", "Nombre");
                System.out.format("+--------+---------------------------------+%n");
                for (Producto aux : productos) {
                    System.out.format("| %-6d | %-31s |%n", aux.getCodigo(), aux.getNombre());
                }
                System.out.format("+--------+---------------------------------+%n");
            }
        } catch (Exception e) {
            throw new Exception("Error al imprimir los nombres de producto.", e);
        }
    }

    public Collection<Producto> listarNombrePrecioProducto() throws Exception {
        try {
            Collection<Producto> productos = dao.listarNombrePrecioProducto();
            return productos;
        } catch (Exception e) {
            throw new Exception("Error al listar los nombres y precios de productos.", e);
        }
    }

    public void imprimirNombrePrecioProducto() throws Exception {
        try {
            Collection<Producto> productos = listarNombrePrecioProducto();
            if (productos.isEmpty()) {
                throw new Exception("No hay productos para imprimir");
            } else {
                System.out.println("Lista de productos:");
                System.out.format("+--------+---------------------------------+------------+%n");
                System.out.format("| %-6s | %-31s | %-10s |%n", "Código", "Nombre", "Precio");
                System.out.format("+--------+---------------------------------+------------+%n");
                for (Producto aux : productos) {
                    System.out.format("| %-6d | %-31s | $%-9.2f |%n", aux.getCodigo(), aux.getNombre(), aux.getPrecio());
                }
                System.out.format("+--------+---------------------------------+------------+%n");
            }
        } catch (Exception e) {
            throw new Exception("Error al imprimir los nombres y precios de productos.", e);
        }
    }

    public Collection<Producto> listarProductosEntre120Y202() throws Exception {
        try {
            Collection<Producto> productos = dao.listarProductosEntre120Y202();
            return productos;
        } catch (Exception e) {
            throw new Exception("Error al listar productos con precio entre 120 y 202.", e);
        }
    }

    public void imprimirProductosEntre120Y202() throws Exception {
        try {
            Collection<Producto> productos = listarProductosEntre120Y202();
            if (productos.isEmpty()) {
                throw new Exception("No hay productos para imprimir");
            } else {
                System.out.println("Lista de productos:");
                System.out.format("+--------+---------------------------------+------------+------------+%n");
                System.out.format("| %-6s | %-31s | %-10s | %-10s |%n", "Código", "Nombre", "Precio", "Fabricante");
                System.out.format("+--------+---------------------------------+------------+------------+%n");
                for (Producto aux : productos) {
                    System.out.format("| %-6d | %-31s | $%-9.2f | %-10d |%n", aux.getCodigo(), aux.getNombre(), aux.getPrecio(), aux.getCodigoFabricante());
                }
                System.out.format("+--------+---------------------------------+------------+------------+%n");
            }
        } catch (Exception e) {
            throw new Exception("Error al imprimir productos con precio entre 120 Y 202.", e);
        }
    }

}
