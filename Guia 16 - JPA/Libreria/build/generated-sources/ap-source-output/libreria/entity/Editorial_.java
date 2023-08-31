package libreria.entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import libreria.entity.Libro;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-14T00:13:47", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Editorial.class)
public class Editorial_ { 

    public static volatile ListAttribute<Editorial, Libro> libros;
    public static volatile SingularAttribute<Editorial, Boolean> alta;
    public static volatile SingularAttribute<Editorial, Integer> id;
    public static volatile SingularAttribute<Editorial, String> nombre;

}