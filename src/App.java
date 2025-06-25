import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println();
        System.out.println("----------------------");

        Scanner input = new Scanner(System.in);

        while(true)
        {
            System.out.println();
            System.out.println("0 - Salir");
            System.out.println("1 - Convertir moneda");

            int option = Integer.parseInt(input.nextLine());

            switch ( option ) {
                case 1:

                    String apiKey;
                    String monedaLeft;
                    String monedaRight;
                    Double monedasLocales;
                    Double monedasExtrangeras;
                    Double rate;

                    System.out.println("Introducir API key");
                    apiKey = input.nextLine();

                    System.out.println("Introducir codigo de moneda local");
                    monedaLeft = input.nextLine().toUpperCase();
                    
                    System.out.println("Introducir codigo de moneda a comparar");
                    monedaRight = input.nextLine().toUpperCase();

                    // mispell checking
                    if ( monedaLeft.length() != 3 )
                    {
                        System.out.println("Codigo " + monedaLeft + " invalido");
                        break;
                    }
                    if ( monedaRight.length() != 3 )
                    {
                        System.out.println("Codigo " + monedaRight + " invalido");
                        break;
                    }

                    //  http request
                    System.out.println("Buscando...");
                    System.out.println();

                    ExchangeRate globalEx = ParseJson.askExchangeRate(apiKey, monedaLeft);

                    if ( ! globalEx.getResult() ) {
                        System.out.println("API key invalida...");
                        System.out.println();
                        break;
                    }

                    if ( !globalEx.monedaExiste(monedaRight) ) {
                        System.out.println("La moneda " + monedaRight + " no existe");
                        System.out.println();
                        break;
                    }

                    System.out.println("Introducir cantidad de monedas (local)");
                    monedasLocales = Double.parseDouble(input.nextLine());

                    // --------------------------------------------

                    rate = globalEx.getExchangerate(monedaRight);
                    monedasExtrangeras = monedasLocales * rate;

                    System.out.println();
                    System.out.println(monedasLocales + monedaLeft + " es igual a " + monedasExtrangeras + monedaRight );
                    System.out.println();

                    break;
            
                default:
                    break;
            }

            if (option == 0) {
                break;
            }
        }
        input.close();
    }
}
