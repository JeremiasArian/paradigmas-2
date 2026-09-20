
/*
@author Jeremias Arian Duarte
*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Heladeria {
    public static void main(String[] args){
        int cantidadVendida;
        PoteDeHelado poteDeHelado;
        Scanner lector = new Scanner(System.in);
        List<PoteDeHelado> potesVendidos = new ArrayList<>();
        
        System.out.println("Bienvenido. Ingrese los potes vendidos");
        System.out.println("Para salir de este programa escriba -1");

        while(true) {
            int opcionSeleccionada;
            System.out.println("Ingrese el sabor del pote vendido");
            imprimirMenu(0);
            poteDeHelado = new PoteDeHelado();
            try{
                opcionSeleccionada = Integer.parseInt(lector.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Entrada inválida. Intente otra vez.");
                continue;
            }

            if (opcionSeleccionada == 1) {
                poteDeHelado.setSabor(PoteDeHelado.Sabor.CHOCOLATE_AMARGO);
            } else if(opcionSeleccionada ==2){
                poteDeHelado.setSabor(PoteDeHelado.Sabor.VAINILLA);
            }else if(opcionSeleccionada ==3) {
                poteDeHelado.setSabor(PoteDeHelado.Sabor.FRUTILLA_A_LA_CREMA);
            }else if(opcionSeleccionada== -1){
                finalizar(potesVendidos);
                break;
            } else{
                System.out.println("Entrada inválida. Intente otra vez.");
                continue;
            }

            System.out.println("Ahora ingrese la cantidad de helado vendido");
            imprimirMenu(1);

            try{
                cantidadVendida = Integer.parseInt(lector.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Entrada inválida. Intente otra vez.");
                continue;
            }

            if (cantidadVendida == 1) {
                poteDeHelado.setCantidad(PoteDeHelado.Cantidad.UN_CUARTO);
            }else if(cantidadVendida== 2) {
                poteDeHelado.setCantidad(PoteDeHelado.Cantidad.MEDIO_KILO);
            } else if(cantidadVendida== 3) {
                poteDeHelado.setCantidad(PoteDeHelado.Cantidad.UN_KILO);
            }else if(cantidadVendida == -1) {
                finalizar(potesVendidos);
                break;
            } else {
                System.out.println("Entrada inválida. Intente otra vez.");
                continue;
            }

            System.out.println("Se vendió con éxito el helado de: " + poteDeHelado);
            potesVendidos.add(poteDeHelado);
        }
    }

    private static void imprimirMenu(int tipoDeMenu){
        if(tipoDeMenu == 0){
                System.out.println("(1) Chocolate Amargo");
                System.out.println("(2) Vainilla");
                System.out.println("(3) Frutilla a la crema");
        } else{
            System.out.println("(1) Un cuarto de kilo");
            System.out.println("(2) Medio kilo");
            System.out.println("(3) Un kilo");
        }
    }

    private static void finalizar(List<PoteDeHelado> ventas){
        imprimirRecaudacionTotal(ventas);
        imprimirSaborQueGeneroMasGanancias(ventas);
        imprimirSaborMasVendido(ventas);
        imprimirSaborMasYMenosVendidoEnKilos(ventas);
        imprimirRecipienteMasPedido(ventas);
        imprimirPorcentajeDeVentaDeCadaSabor(ventas);
        imprimirPorcentajeDeRecaudacionDeCadaSabor(ventas);
        imprimirElPoteQueMasDineroRecaudo(ventas);
        imprimirElPoteMasYMenosVendido(ventas);
        imprimirPorcentajeDeVentaDeCadaPote(ventas);
        imprimirPorcentajeDeRecaudacionDeCadaPote(ventas);
    }

    private static void imprimirRecaudacionTotal(List<PoteDeHelado> ventas){
        double acumulador = 0;

        if(ventas.size()>1){
            for(PoteDeHelado pote : ventas){
                double aux;

                if(pote.getSabor() == PoteDeHelado.Sabor.CHOCOLATE_AMARGO) aux = 9000;
                else if (pote.getSabor() == PoteDeHelado.Sabor.VAINILLA) aux = 7000;
                else aux = 8500;

                if(pote.getCantidad() == PoteDeHelado.Cantidad.MEDIO_KILO) aux = aux /2;
                else if(pote.getCantidad() == PoteDeHelado.Cantidad.UN_CUARTO) aux = aux /4;

                pote.setPrecio(aux);
                acumulador = acumulador + aux;
            }
        }

        System.out.println("La recaudación total del día de hoy fue de: "+acumulador+" pesos.");
    }

    private static void imprimirSaborQueGeneroMasGanancias(List<PoteDeHelado> ventas){
        double plataGanadaConChocolate = 0;
        double plataGanadaConVainilla = 0;
        double plataGanadaConFrutilla = 0;

        if(!ventas.isEmpty()){
            for(PoteDeHelado pote:ventas){
                if(pote.getSabor()== PoteDeHelado.Sabor.CHOCOLATE_AMARGO){
                    plataGanadaConChocolate += pote.getPrecio();
                } else if(pote.getSabor()== PoteDeHelado.Sabor.VAINILLA){
                    plataGanadaConVainilla += pote.getPrecio();
                } else plataGanadaConFrutilla += pote.getPrecio();
            }

            if(plataGanadaConChocolate > plataGanadaConFrutilla &&
                    plataGanadaConChocolate > plataGanadaConVainilla){
                System.out.println("El Sabor que genero más ganancias fue el de chocolate");
            } else if(plataGanadaConVainilla > plataGanadaConFrutilla &&
                    plataGanadaConVainilla > plataGanadaConChocolate){
                System.out.println("El Sabor que genero más ganancias fue el de vainilla");
            } else{
                System.out.println("El sabor que genero más ganancias fue el de frutilla");
            }
        }
    }

    private static void imprimirSaborMasVendido(List<PoteDeHelado> ventas){
        int ventasChocolate = 0;
        int ventasVainilla = 0;
        int ventasFrutilla = 0;

        if(!ventas.isEmpty()){
            for(PoteDeHelado pote: ventas){
                if(pote.getSabor()== PoteDeHelado.Sabor.CHOCOLATE_AMARGO){
                    ventasChocolate++;
                } else if (pote.getSabor()== PoteDeHelado.Sabor.VAINILLA){
                    ventasVainilla++;
                } else ventasFrutilla++;
            }
        }

        System.out.println("Sabor(es) mas vendido(s) de hoy:");
     if (ventasChocolate==ventasFrutilla && ventasChocolate==ventasVainilla){
        System.out.println("Los 3 sabores vendieron por igual: "+ventasChocolate+" venta(s) los 3.");
     } else if(ventasChocolate>ventasFrutilla && ventasChocolate>ventasVainilla) {
            System.out.println("Chocolate Amargo");
        } else if (ventasChocolate==ventasFrutilla){
            System.out.println("Chocolate Amargo y Frutilla");
        } else if (ventasChocolate==ventasVainilla){
            System.out.println("Chocolate Amargo y Vainilla");
        } else if (ventasVainilla>ventasChocolate && ventasVainilla>ventasFrutilla){
            System.out.println("Vainilla");
        } else if (ventasVainilla==ventasFrutilla){
            System.out.println("Vainilla y Frutilla");
        } else {
            System.out.println("frutilla");
        }
    }

    private static void imprimirSaborMasYMenosVendidoEnKilos(List<PoteDeHelado> potesVendidos){
        double kilosChocolate = 0;
        double kilosVainilla = 0;
        double kilosFrutilla = 0;

        if(!potesVendidos.isEmpty()){
            for(PoteDeHelado pote : potesVendidos){
                if(pote.getSabor()== PoteDeHelado.Sabor.CHOCOLATE_AMARGO){
                    if(pote.getCantidad()== PoteDeHelado.Cantidad.UN_CUARTO){
                        kilosChocolate += .25;
                    } else if (pote.getCantidad()== PoteDeHelado.Cantidad.MEDIO_KILO){
                        kilosChocolate += .5;
                    } else kilosChocolate +=1;
                } else if (pote.getSabor()== PoteDeHelado.Sabor.VAINILLA){
                    if(pote.getCantidad()== PoteDeHelado.Cantidad.UN_CUARTO){
                        kilosVainilla += .25;
                    } else if (pote.getCantidad()== PoteDeHelado.Cantidad.MEDIO_KILO){
                        kilosVainilla += .5;
                    } else kilosVainilla +=1;
                } else{
                    if(pote.getCantidad()== PoteDeHelado.Cantidad.UN_CUARTO){
                        kilosFrutilla += .25;
                    } else if (pote.getCantidad()== PoteDeHelado.Cantidad.MEDIO_KILO){
                        kilosFrutilla += .5;
                    } else kilosFrutilla +=1;
                }
            }

            System.out.println("Sabor(es) mas vendido(s) por kilo:");
            if(kilosChocolate>kilosFrutilla && kilosChocolate>kilosVainilla) {
                System.out.println("Chocolate Amargo: "+kilosChocolate+" kilos");
            } else if (kilosChocolate==kilosFrutilla && kilosChocolate==kilosVainilla){
                System.out.println("Los 3 sabores vendieron por igual: "+kilosChocolate+" kilos los 3.");
            } else if (kilosChocolate==kilosFrutilla){
                System.out.println("Chocolate Amargo y Frutilla: "+kilosChocolate+" kilos");
            } else if (kilosChocolate==kilosVainilla){
                System.out.println("Chocolate Amargo y Vainilla: "+kilosChocolate+" kilos");
            } else if (kilosVainilla>kilosChocolate && kilosVainilla>kilosFrutilla){
                System.out.println("Vainilla: "+kilosVainilla+" kilos");
            } else if (kilosVainilla==kilosFrutilla){
                System.out.println("Vainilla y Frutilla: "+kilosFrutilla+" kilos");
            } else {
                System.out.println("frutilla: "+kilosFrutilla+" kilos");
            }

            System.out.println("Sabor(es) menos vendido(s) por kilo:");
            if(kilosChocolate<kilosFrutilla && kilosChocolate<kilosVainilla) {
                System.out.println("Chocolate Amargo: "+kilosChocolate+" kilos");
            } else if (kilosChocolate==kilosFrutilla && kilosChocolate==kilosVainilla){
                System.out.println("Los 3 sabores vendieron por igual: "+kilosChocolate+" kilos los 3.");
            } else if (kilosChocolate==kilosFrutilla){
                System.out.println("Chocolate Amargo y Frutilla: "+kilosChocolate+" kilos ambos");
            } else if (kilosChocolate==kilosVainilla){
                System.out.println("Chocolate Amargo y Vainilla: "+kilosChocolate+" kilos ambos");
            } else if (kilosVainilla<kilosChocolate && kilosVainilla<kilosFrutilla){
                System.out.println("Vainilla: "+kilosVainilla+" kilos");
            } else if (kilosVainilla==kilosFrutilla){
                System.out.println("Vainilla y Frutilla: "+kilosFrutilla+" kilos ambos");
            } else {
                System.out.println("frutilla: "+kilosFrutilla+" kilos");
            }
        }
    }

    private static void imprimirRecipienteMasPedido(List<PoteDeHelado> ventas){
        int vasito = 0;
        int copa = 0;
        int balde = 0;

        if(!ventas.isEmpty()){
            for(PoteDeHelado pote:ventas){
                if(pote.getCantidad()== PoteDeHelado.Cantidad.UN_CUARTO) vasito+=1;
                else if (pote.getCantidad()== PoteDeHelado.Cantidad.MEDIO_KILO) copa+=1;
                else balde+=1;
            }

            System.out.println("Recipiente(s) mas pedido(s):");
            if(vasito==copa && vasito==balde){
                System.out.println("Se pidieron los 3 recipientes por igual");
            } else if(vasito>copa && vasito>balde) {
                System.out.println("El vasito fue el más pedido");
            } else if (vasito==copa){
                System.out.println("Tanto el vasito como la copa fueron los más pedidos");
            } else if (vasito==balde){
                System.out.println("Tanto el vasito como el balde fueron los más pedidos");
            } else if (copa>vasito && copa>balde){
                System.out.println("La copa fue el recipiente más pedido");
            } else if (copa==balde){
                System.out.println("Tanto la copa como el balde fueron los más pedidos");
            } else {
                System.out.println("El balde fue el recipiente más pedido");
            }
        }
    }

    private static void imprimirPorcentajeDeVentaDeCadaSabor(List<PoteDeHelado> ventas){
        int ventasChocolate = 0;
        int ventasVainilla = 0;
        int ventasFrutilla = 0;

        if(!ventas.isEmpty()){
            for (PoteDeHelado p : ventas){
                if(p.getSabor()== PoteDeHelado.Sabor.CHOCOLATE_AMARGO) ventasChocolate+=1;
                else if(p.getSabor()== PoteDeHelado.Sabor.VAINILLA) ventasVainilla+=1;
                else ventasFrutilla +=1;
            }

            System.out.println("Porcentajes de ventas de cada sabor:");

            if(ventasChocolate == 0 && ventasVainilla == 0) {
                System.out.println("Frutilla representa el 100% de las ventas");
            }else if(ventasVainilla == 0 && ventasFrutilla == 0){
                System.out.println("Chocolate representa el 100% de las ventas");
            }else if(ventasChocolate == 0 && ventasFrutilla == 0){
                System.out.println("Vainilla representa el 100% de las ventas");
            } else{
                // Source - https://stackoverflow.com/a/24278679
                // Posted by griffon vulture, modified by community. See post 'Timeline' for change history
                // Retrieved 2026-08-30, License - CC BY-SA 3.0

                double porcentajeChocolate = (double) Math.round((float) (ventasChocolate * 100) / (ventasFrutilla + ventasVainilla + ventasChocolate) * 100) /100;
                    System.out.println("Chocolate: "+ porcentajeChocolate+"%");

                    double porcentajeVainilla = (double) Math.round((float) (ventasVainilla * 100) / (ventasFrutilla + ventasChocolate + ventasVainilla) * 100) /100;
                    System.out.println("Vainilla: "+ porcentajeVainilla+"%");

                    double porcentajeFrutilla = (double) Math.round((float) (ventasFrutilla * 100) / (ventasVainilla + ventasChocolate + ventasFrutilla) * 100) /100;
                    System.out.println("Frutilla: "+ porcentajeFrutilla+"%");
            }
        }
    }

    private static void imprimirPorcentajeDeRecaudacionDeCadaSabor(List<PoteDeHelado> ventas){
        double ventasChocolate = 0;
        double ventasVainilla = 0;
        double ventasFrutilla = 0;

        if(!ventas.isEmpty()){
            for (PoteDeHelado p : ventas){
                if(p.getSabor()== PoteDeHelado.Sabor.CHOCOLATE_AMARGO) ventasChocolate+=p.getPrecio();
                else if(p.getSabor()== PoteDeHelado.Sabor.VAINILLA) ventasVainilla+=p.getPrecio();
                else ventasFrutilla +=p.getPrecio();
            }

            System.out.println("Porcentaje de recaudación de cada sabor:");

            if(ventasChocolate == 0 && ventasVainilla == 0) {
                System.out.println("Frutilla representa el 100% de las ganancias");
            }else if(ventasVainilla == 0 && ventasFrutilla == 0){
                System.out.println("Chocolate representa el 100% de las ganancias");
            }else if(ventasChocolate == 0 && ventasFrutilla == 0){
                System.out.println("Vainilla representa el 100% de las ganancias");
            } else{
                // Source - https://stackoverflow.com/a/24278679
                // Posted by griffon vulture, modified by community. See post 'Timeline' for change history
                // Retrieved 2026-08-30, License - CC BY-SA 3.0

                double porcentajeChocolate = (double) Math.round(ventasChocolate * 100 / (ventasFrutilla + ventasVainilla + ventasChocolate) * 100) /100;
                System.out.println("Chocolate: "+ porcentajeChocolate+"%");

                double porcentajeVainilla = (double) Math.round(ventasVainilla * 100 / (ventasFrutilla + ventasChocolate + ventasVainilla) * 100) /100;
                System.out.println("Vainilla: "+ porcentajeVainilla+"%");

                double porcentajeFrutilla = (double) Math.round(ventasFrutilla * 100 / (ventasVainilla + ventasChocolate + ventasFrutilla) * 100) /100;
                System.out.println("Frutilla: "+ porcentajeFrutilla+"%");
            }
        }
    }

    private static void imprimirElPoteQueMasDineroRecaudo(List<PoteDeHelado> ventas){
        double p1 = 0;
        double p2 = 0;
        double p3 = 0;
        double p4 = 0;
        double p5 = 0;
        double p6 = 0;
        double p7 = 0;
        double p8 = 0;
        double p9 = 0;

        if(!ventas.isEmpty()){
            for (PoteDeHelado pote:ventas) {
                if (pote.getSabor() == PoteDeHelado.Sabor.CHOCOLATE_AMARGO && pote.getCantidad() == PoteDeHelado.Cantidad.UN_CUARTO) {
                    p1 += pote.getPrecio();
                } else if (pote.getSabor() == PoteDeHelado.Sabor.CHOCOLATE_AMARGO && pote.getCantidad() == PoteDeHelado.Cantidad.MEDIO_KILO) {
                    p2+=pote.getPrecio();
                } else if (pote.getSabor() == PoteDeHelado.Sabor.CHOCOLATE_AMARGO && pote.getCantidad() == PoteDeHelado.Cantidad.UN_KILO) {
                    p3 +=pote.getPrecio();
                } else if (pote.getSabor() == PoteDeHelado.Sabor.VAINILLA && pote.getCantidad() == PoteDeHelado.Cantidad.UN_CUARTO) {
                    p4+=pote.getPrecio();
                } else if (pote.getSabor() == PoteDeHelado.Sabor.VAINILLA && pote.getCantidad() == PoteDeHelado.Cantidad.MEDIO_KILO) {
                    p5+=pote.getPrecio();
                } else if (pote.getSabor() == PoteDeHelado.Sabor.VAINILLA && pote.getCantidad() == PoteDeHelado.Cantidad.UN_KILO) {
                    p6+=pote.getPrecio();
                } else if (pote.getSabor() == PoteDeHelado.Sabor.FRUTILLA_A_LA_CREMA && pote.getCantidad() == PoteDeHelado.Cantidad.UN_CUARTO) {
                    p7+=pote.getPrecio();
                } else if (pote.getSabor() == PoteDeHelado.Sabor.FRUTILLA_A_LA_CREMA && pote.getCantidad() == PoteDeHelado.Cantidad.MEDIO_KILO) {
                    p8+=pote.getPrecio();
                } else p9 +=pote.getPrecio();
            }

            ArrayList<Double> listaDeRecaudacion = new ArrayList<>();
            listaDeRecaudacion.add(p1);
            listaDeRecaudacion.add(p2);
            listaDeRecaudacion.add(p3);
            listaDeRecaudacion.add(p4);
            listaDeRecaudacion.add(p5);
            listaDeRecaudacion.add(p6);
            listaDeRecaudacion.add(p7);
            listaDeRecaudacion.add(p8);
            listaDeRecaudacion.add(p9);

            double max = Collections.max(listaDeRecaudacion);
            int i = listaDeRecaudacion.indexOf(max);
            System.out.println("El pote que más plata recaudó fue el de:");
            switch(i){
                case 0:
                    System.out.println("Chocolate de un cuarto");
                    break;
                case 1:
                    System.out.println("Chocolate de medio kilo");
                    break;
                case 2:
                    System.out.println("Chocolate de un kilo");
                    break;
                case 3:
                    System.out.println("Vainilla de un cuarto");
                    break;
                case 4:
                    System.out.println("Vainilla de medio kilo");
                    break;
                case 5:
                    System.out.println("Vainilla de un kilo");
                    break;
                case 6:
                    System.out.println("Frutilla de un cuarto");
                    break;
                case 7:
                    System.out.println("Frutilla de medio kilo");
                    break;
                case 8:
                    System.out.println("Frutilla de un kilo");
                    break;
            }
        }
    }

    private static void imprimirElPoteMasYMenosVendido(List<PoteDeHelado> ventas){
        double p1 = 0;
        double p2 = 0;
        double p3 = 0;
        double p4 = 0;
        double p5 = 0;
        double p6 = 0;
        double p7 = 0;
        double p8 = 0;
        double p9 = 0;

        if(!ventas.isEmpty()){
            for (PoteDeHelado pote:ventas) {
                if (pote.getSabor() == PoteDeHelado.Sabor.CHOCOLATE_AMARGO && pote.getCantidad() == PoteDeHelado.Cantidad.UN_CUARTO) {
                    p1 +=1;
                } else if (pote.getSabor() == PoteDeHelado.Sabor.CHOCOLATE_AMARGO && pote.getCantidad() == PoteDeHelado.Cantidad.MEDIO_KILO) {
                    p2+=1;
                } else if (pote.getSabor() == PoteDeHelado.Sabor.CHOCOLATE_AMARGO && pote.getCantidad() == PoteDeHelado.Cantidad.UN_KILO) {
                    p3 +=1;
                } else if (pote.getSabor() == PoteDeHelado.Sabor.VAINILLA && pote.getCantidad() == PoteDeHelado.Cantidad.UN_CUARTO) {
                    p4+=1;
                } else if (pote.getSabor() == PoteDeHelado.Sabor.VAINILLA && pote.getCantidad() == PoteDeHelado.Cantidad.MEDIO_KILO) {
                    p5+=1;
                } else if (pote.getSabor() == PoteDeHelado.Sabor.VAINILLA && pote.getCantidad() == PoteDeHelado.Cantidad.UN_KILO) {
                    p6+=1;
                } else if (pote.getSabor() == PoteDeHelado.Sabor.FRUTILLA_A_LA_CREMA && pote.getCantidad() == PoteDeHelado.Cantidad.UN_CUARTO) {
                    p7+=1;
                } else if (pote.getSabor() == PoteDeHelado.Sabor.FRUTILLA_A_LA_CREMA && pote.getCantidad() == PoteDeHelado.Cantidad.MEDIO_KILO) {
                    p8+=1;
                } else p9 +=1;
            }

            ArrayList<Double> listaDeVentas = new ArrayList<>();
            listaDeVentas.add(p1);
            listaDeVentas.add(p2);
            listaDeVentas.add(p3);
            listaDeVentas.add(p4);
            listaDeVentas.add(p5);
            listaDeVentas.add(p6);
            listaDeVentas.add(p7);
            listaDeVentas.add(p8);
            listaDeVentas.add(p9);

            double max = Collections.max(listaDeVentas);
            int i = listaDeVentas.indexOf(max);
            System.out.println("El pote más vendido fue:");
            switch(i){
                case 0:
                    System.out.println("Chocolate de un cuarto ("+p1+")");
                    break;
                case 1:
                    System.out.println("Chocolate de medio kilo ("+p2+")");
                    break;
                case 2:
                    System.out.println("Chocolate de un kilo ("+p3+")");
                    break;
                case 3:
                    System.out.println("Vainilla de un cuarto ("+p4+")");
                    break;
                case 4:
                    System.out.println("Vainilla de medio kilo ("+p5+")");
                    break;
                case 5:
                    System.out.println("Vainilla de un kilo ("+p6+")");
                    break;
                case 6:
                    System.out.println("Frutilla de un cuarto ("+p7+")");
                    break;
                case 7:
                    System.out.println("Frutilla de medio kilo ("+p8+")");
                    break;
                case 8:
                    System.out.println("Frutilla de un kilo ("+p9+")");
                    break;
            }



            // Source - https://stackoverflow.com/a/10369744
            // Posted by MByD
            // Retrieved 2026-09-01, License - CC BY-SA 3.0
            double min = Double.MAX_VALUE;
            for (double d : listaDeVentas)
            {
                min = (d == 0) ? min : Math.min(min, d);
            }



            int i1 = listaDeVentas.indexOf(min);
            System.out.println("El pote menos vendido fue:");
            switch(i1){
                case 0:
                    System.out.println("Chocolate de un cuarto ("+p1+")");
                    break;
                case 1:
                    System.out.println("Chocolate de medio kilo ("+p2+")");
                    break;
                case 2:
                    System.out.println("Chocolate de un kilo ("+p3+")");
                    break;
                case 3:
                    System.out.println("Vainilla de un cuarto ("+p4+")");
                    break;
                case 4:
                    System.out.println("Vainilla de medio kilo ("+p5+")");
                    break;
                case 5:
                    System.out.println("Vainilla de un kilo ("+p6+")");
                    break;
                case 6:
                    System.out.println("Frutilla de un cuarto ("+p7+")");
                    break;
                case 7:
                    System.out.println("Frutilla de medio kilo ("+p8+")");
                    break;
                case 8:
                    System.out.println("Frutilla de un kilo ("+p9+")");
                    break;
            }
        }
    }

    private static void imprimirPorcentajeDeVentaDeCadaPote(List<PoteDeHelado> ventas){
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;
        int p5 = 0;
        int p6 = 0;
        int p7 = 0;
        int p8 = 0;
        int p9 = 0;

        if(!ventas.isEmpty()){
            for (PoteDeHelado pote:ventas) {
                if (pote.getSabor() == PoteDeHelado.Sabor.CHOCOLATE_AMARGO && pote.getCantidad() == PoteDeHelado.Cantidad.UN_CUARTO) {
                    p1 +=1;
                } else if (pote.getSabor() == PoteDeHelado.Sabor.CHOCOLATE_AMARGO && pote.getCantidad() == PoteDeHelado.Cantidad.MEDIO_KILO) {
                    p2+=1;
                } else if (pote.getSabor() == PoteDeHelado.Sabor.CHOCOLATE_AMARGO && pote.getCantidad() == PoteDeHelado.Cantidad.UN_KILO) {
                    p3 +=1;
                } else if (pote.getSabor() == PoteDeHelado.Sabor.VAINILLA && pote.getCantidad() == PoteDeHelado.Cantidad.UN_CUARTO) {
                    p4+=1;
                } else if (pote.getSabor() == PoteDeHelado.Sabor.VAINILLA && pote.getCantidad() == PoteDeHelado.Cantidad.MEDIO_KILO) {
                    p5+=1;
                } else if (pote.getSabor() == PoteDeHelado.Sabor.VAINILLA && pote.getCantidad() == PoteDeHelado.Cantidad.UN_KILO) {
                    p6+=1;
                } else if (pote.getSabor() == PoteDeHelado.Sabor.FRUTILLA_A_LA_CREMA && pote.getCantidad() == PoteDeHelado.Cantidad.UN_CUARTO) {
                    p7+=1;
                } else if (pote.getSabor() == PoteDeHelado.Sabor.FRUTILLA_A_LA_CREMA && pote.getCantidad() == PoteDeHelado.Cantidad.MEDIO_KILO) {
                    p8+=1;
                } else p9 +=1;
            }

            System.out.println("Porcentajes de ventas de cada sabor:");
                // Source - https://stackoverflow.com/a/24278679
                // Posted by griffon vulture, modified by community. See post 'Timeline' for change history
                // Retrieved 2026-08-30, License - CC BY-SA 3.0

                int suma = p1+p2+p3+p4+p5+p6+p7+p8+p9;
                double p11 = (double) Math.round((float) (p1 * 100) / (suma) * 100) /100;
                System.out.println("Chocolate de un cuarto: "+ p11+"%");

                double p22 = (double) Math.round((float) (p2 * 100) / (suma) * 100) /100;
                System.out.println("Chocolate de medio: "+ p22+"%");

                double p33 = (double) Math.round((float) (p3 * 100) / (suma) * 100) /100;
                System.out.println("Chocolate de un kilo: "+ p33+"%");

                double p44 = (double) Math.round((float) (p4 * 100) / (suma) * 100) /100;
                System.out.println("Vainilla de un cuarto: "+ p44+"%");

                double p55 = (double) Math.round((float) (p5 * 100) / (suma) * 100) /100;
                System.out.println("Vainilla de medio: "+ p55+"%");

                double p66 = (double) Math.round((float) (p6 * 100) / (suma) * 100) /100;
                System.out.println("Vainilla de un kilo: "+ p66+"%");

                double p77 = (double) Math.round((float) (p7 * 100) / (suma) * 100) /100;
                System.out.println("Frutilla de un cuarto: "+ p77+"%");

                double p88 = (double) Math.round((float) (p8 * 100) / (suma) * 100) /100;
                System.out.println("Frutilla de medio: "+ p88+"%");

                double p99 = (double) Math.round((float) (p9 * 100) / (suma) * 100) /100;
                System.out.println("Frutilla de un kilo: "+ p99+"%");
        }
    }

    private static void imprimirPorcentajeDeRecaudacionDeCadaPote(List<PoteDeHelado> ventas){
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;
        int p5 = 0;
        int p6 = 0;
        int p7 = 0;
        int p8 = 0;
        int p9 = 0;

        if(!ventas.isEmpty()){
            for (PoteDeHelado pote:ventas) {
                if (pote.getSabor() == PoteDeHelado.Sabor.CHOCOLATE_AMARGO && pote.getCantidad() == PoteDeHelado.Cantidad.UN_CUARTO) {
                    p1 += (int) pote.getPrecio();
                } else if (pote.getSabor() == PoteDeHelado.Sabor.CHOCOLATE_AMARGO && pote.getCantidad() == PoteDeHelado.Cantidad.MEDIO_KILO) {
                    p2+=(int) pote.getPrecio();
                } else if (pote.getSabor() == PoteDeHelado.Sabor.CHOCOLATE_AMARGO && pote.getCantidad() == PoteDeHelado.Cantidad.UN_KILO) {
                    p3 +=(int) pote.getPrecio();
                } else if (pote.getSabor() == PoteDeHelado.Sabor.VAINILLA && pote.getCantidad() == PoteDeHelado.Cantidad.UN_CUARTO) {
                    p4+=(int) pote.getPrecio();
                } else if (pote.getSabor() == PoteDeHelado.Sabor.VAINILLA && pote.getCantidad() == PoteDeHelado.Cantidad.MEDIO_KILO) {
                    p5+=(int) pote.getPrecio();
                } else if (pote.getSabor() == PoteDeHelado.Sabor.VAINILLA && pote.getCantidad() == PoteDeHelado.Cantidad.UN_KILO) {
                    p6+=(int) pote.getPrecio();
                } else if (pote.getSabor() == PoteDeHelado.Sabor.FRUTILLA_A_LA_CREMA && pote.getCantidad() == PoteDeHelado.Cantidad.UN_CUARTO) {
                    p7+=(int) pote.getPrecio();
                } else if (pote.getSabor() == PoteDeHelado.Sabor.FRUTILLA_A_LA_CREMA && pote.getCantidad() == PoteDeHelado.Cantidad.MEDIO_KILO) {
                    p8+=(int) pote.getPrecio();
                } else p9 +=(int) pote.getPrecio();
            }

            System.out.println("Porcentaje de recaudación de cada sabor:");
                // Source - https://stackoverflow.com/a/24278679
                // Posted by griffon vulture, modified by community. See post 'Timeline' for change history
                // Retrieved 2026-08-30, License - CC BY-SA 3.0

            double suma = p1+p2+p3+p4+p5+p6+p7+p8+p9;
            double p11 = (double) Math.round(p1 * 100 / (suma) * 100) /100;
            System.out.println("Chocolate de un cuarto: "+ p11+"%");

            double p22 = (double) Math.round(p2 * 100 / (suma) * 100) /100;
            System.out.println("Chocolate de medio: "+ p22+"%");

            double p33 = (double) Math.round(p3 * 100 / (suma) * 100) /100;
            System.out.println("Chocolate de un kilo: "+ p33+"%");

            double p44 = (double) Math.round(p4 * 100 / (suma) * 100) /100;
            System.out.println("Vainilla de un cuarto: "+ p44+"%");

            double p55 = (double) Math.round(p5 * 100 / (suma) * 100) /100;
            System.out.println("Vainilla de medio: "+ p55+"%");

            double p66 = (double) Math.round(p6 * 100 / (suma) * 100) /100;
            System.out.println("Vainilla de un kilo: "+ p66+"%");

            double p77 = (double) Math.round(p7 * 100 / (suma) * 100) /100;
            System.out.println("Frutilla de un cuarto: "+ p77+"%");

            double p88 = (double) Math.round(p8 * 100 / (suma) * 100) /100;
            System.out.println("Frutilla de medio: "+ p88+"%");

            double p99 = (double) Math.round(p9 * 100 / (suma) * 100) /100;
            System.out.println("Frutilla de un kilo: "+ p99+"%");
        }
    }

}
