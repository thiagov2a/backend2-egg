package guia11ex02.enums;

public enum Columna {

    A(0), B(1), C(2), D(3), E(4), F(5);

    private final Integer codigo;

    private Columna(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

}
