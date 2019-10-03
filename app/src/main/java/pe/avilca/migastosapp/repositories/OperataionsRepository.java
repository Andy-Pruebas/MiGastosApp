package pe.avilca.migastosapp.repositories;

import java.util.ArrayList;
import java.util.List;

import pe.avilca.migastosapp.models.Operation;

public class OperataionsRepository {
    private static List<Operation> operations;
    static {
        operations=new ArrayList<>();
    }
    public static List<Operation> getOperations(String saldo){
        List<Operation> tem=new ArrayList<>();
        for(int mo=0;mo<operations.size();mo++){
            if(operations.get(mo).getSaldo().equals(saldo)){
                tem.add(operations.get(mo));
            }
        }
        return tem;
    }
    public static void agrega(String fecha,String tipo,String monto,String saldo){
        operations.add(new Operation(fecha,tipo,monto,saldo));
    }
    public static double total(String saldo)
    {
        double total=0;
        double total_ingreso=0;
        double total_egreso=0;
        for(int mo = 0; mo< operations.size(); mo++){
            if(operations.get(mo).getSaldo().equals(saldo)){
                if (operations.get(mo).getTipo().equals("Ingresos")){
                    double numero1 = Double.parseDouble(operations.get(mo).getMonto());
                    total_ingreso = total_ingreso + numero1;
                }else{
                    double numero2 = Double.parseDouble(operations.get(mo).getMonto());
                    total_egreso = total_egreso + numero2;
                }
            }
        }
        total = total_ingreso - total_egreso;
        return total;
    }
    public static double total_final(){
        double sumatoria_egreso=0;
        double sumatoria_ingreso=0;
        double sumatoria=0;

        for(int mo = 0; mo <operations.size(); mo++){
            if(operations.get(mo).getTipo().equals("Ingresos")){
                double numero1 = Double.parseDouble(operations.get(mo).getMonto());
                sumatoria_ingreso = sumatoria_ingreso + numero1;
            }else{
                double numero2 = Double.parseDouble(operations.get(mo).getMonto());
                sumatoria_egreso = sumatoria_egreso + numero2;
            }
        }
        sumatoria = (sumatoria_ingreso/(sumatoria_egreso+sumatoria_ingreso))*100;
        return sumatoria;
    }
}
