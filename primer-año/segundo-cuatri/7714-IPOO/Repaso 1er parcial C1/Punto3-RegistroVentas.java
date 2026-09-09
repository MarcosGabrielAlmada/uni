public class RegistroVentas {
    // Atributos de instancia
    private float[] reg;

    // Constructor
    public RegistroVentas(int cantDias) {
        reg = new float[cantDias];
    }

    // Comandos
    public void establecerVenta(int dia, float v) {
        if ((dia>=0) && (dia<reg.length))
            reg[dia] = v;
    }

    // Consultas
    public float obtenerVenta(int dia) {
        float v = 0;
        if ((dia>=0) && (dia<reg.length))
            v = reg[dia];
        return v;
    }

    public int longitud() {
        return reg.length;
    }

    public boolean alMenosNVentasSuperioresA(int n, float m) {
        int cont = 0;
        if (n <= reg.length)
            for (int i = 0; i<reg.length && cont<n; i++)
                if (reg[i] > m)
                    cont++;
        return cont>=n;
    }

    public int diaVentaMinima() {
        int menorDia = 0;
        float menorVenta = reg[0];
        for (int i = 1; i<reg.length && menorVenta>0; i++)
            if (reg[i] < menorVenta) {
                menorVenta = reg[i];
                menorDia = i;
            }
        return menorDia;
    }
}