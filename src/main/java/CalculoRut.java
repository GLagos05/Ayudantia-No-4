public class CalculoRut {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        String rut = "20.919.321-3";
        verificarRut(rut);
    }

    public static boolean verificarRut(String rut) {
        String rutSinDigito = tomarNumeros(rut);
        boolean validador = validarRut(rutSinDigito);
        if(validador){
            calculoDigitoVerificador(rutSinDigito);
        }
        return validador;
    }

    public static String tomarNumeros(String rut) {
        rut = rut.replace(".","");
        rut = rut.replace("-","");
        return rut.substring(0,rut.length()-1);
    }

    public static boolean validarRut(String rutSinDigito) {
        int numeroRut;
        boolean validador = true;
        try{
            numeroRut = Integer.parseInt(rutSinDigito);
        }catch (Exception e){
            System.out.println("Rut no válido");
            validador = false;
        }
        return validador;
    }

    public static String calculoDigitoVerificador(String rutSinDigito) {
        String palabraRutInvertida = invertirOrden(rutSinDigito);
        int[] arregloRut = generarArregloRut(palabraRutInvertida);
        multiplicarDigitos(arregloRut);
        int sumaRut = sumarMultiplicaciones(arregloRut);
        double dividirRut = dividirResultados(sumaRut);
        int multiplicacionEntera = tomarDecimales(dividirRut);
        int restaRut = restarResultados(sumaRut,multiplicacionEntera);
        String digitoVer = obtenerDigitoVerificador(restaRut);
        mostrarResultados(digitoVer);
        return digitoVer;
    }

    public static String invertirOrden(String cadenaRut) {
        StringBuilder stringBuilder = new StringBuilder(cadenaRut);
        return stringBuilder.reverse().toString();
    }

    public static int[] generarArregloRut(String palabraRutInvertida) {
        int[] arregloCaracteres = new int[palabraRutInvertida.length()];
        for (int i = 0; i < arregloCaracteres.length; i++) {
            arregloCaracteres[i] = Integer.parseInt(String.valueOf(palabraRutInvertida.charAt(i)));
        }
        return arregloCaracteres;
    }

    public static void multiplicarDigitos(int[] arregloCaracteres) {
        int[] cadena = {2,3,4,5,6,7};
        int contador = 0;
        for (int i = 0; i < arregloCaracteres.length; i++) {
            if(contador == cadena.length){
                contador = 0;
            }
            arregloCaracteres[i] *= cadena[contador];
            contador++;
        }
    }

    public static int sumarMultiplicaciones(int[] arregloCaracteres) {
        int sumaArregloRut = 0;
        for (int i = 0; i < arregloCaracteres.length; i++) {
            sumaArregloRut += arregloCaracteres[i];
        }
        return sumaArregloRut;
    }

    public static double dividirResultados(int sumaArregloRut) {
        return sumaArregloRut/11;
    }

    public static int tomarDecimales(double divisionSumas) {
        return ((int)divisionSumas)*11;
    }

    public static int restarResultados(int sumaMultiplicaciones, int multSinDecimales) {
        return Math.abs(sumaMultiplicaciones - multSinDecimales);
    }

    public static String obtenerDigitoVerificador(int restaNumeros) {
        String resultadoDigito = String.valueOf(11 - restaNumeros);
        if(resultadoDigito.equals("10")){
            resultadoDigito = "k";
        }else if(resultadoDigito.equals("11")){
            resultadoDigito = "0";
        }
        return resultadoDigito;
    }

    public static void mostrarResultados(String resultadoDigito) {
        System.out.println("El digito verificador es: "+resultadoDigito);
    }

}
