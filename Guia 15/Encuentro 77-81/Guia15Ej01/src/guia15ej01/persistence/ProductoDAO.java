package guia15ej01.persistence;

import guia15ej01.entity.Producto;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Thiago
 */
public final class ProductoDAO extends DAO {

    public Collection<Producto> listarNombreProducto() throws Exception {
        try {
            String sql = "SELECT codigo, nombre FROM producto";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList<>();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                productos.add(producto);
            }
            return productos;
        } catch (Exception e) {
            throw new Exception("Error al listar los nombres de productos.", e);
        } finally {
            desconectarBase();
        }
    }

    public Collection<Producto> listarNombrePrecioProducto() throws Exception {
        try {
            String sql = "SELECT codigo, nombre, precio FROM producto";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList<>();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                productos.add(producto);
            }
            return productos;
        } catch (Exception e) {
            throw new Exception("Error al listar los nombres y precios de productos.", e);
        } finally {
            desconectarBase();
        }
    }

    public Collection<Producto> listarProductosEntre120Y202() throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE precio BETWEEN 120 AND 202";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList<>();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            return productos;
        } catch (Exception e) {
            throw new Exception("Error al listar productos con precio entre 120 y 202.", e);
        } finally {
            desconectarBase();
        }
    }

}
