package com.coderhouse;

import com.coderhouse.controlador.JavaDataBaseController;
import com.coderhouse.entidades.Cliente;
import org.springframework.boot.SpringApplication;

import java.sql.SQLException;

public class MainTest {
    public static void main(String[] args) throws SQLException {
        JavaDataBaseController controller = new JavaDataBaseController();

        controller.getConnection();

        Cliente cliente = new Cliente();

/*      //cargar 1 cliente
        cliente.setDni(28042402);
        cliente.setName("Francisco");
        cliente.setSurname("Gonzalez");
        cliente.setClientAddress("Buenos Aires 63, Ingeniero Maschwitz, Buenos Aires");
        cliente.setClientPhone(1154122848);
        cliente.setClientEmail("fmgarg@gmail.com");*/

/*      //cargar 100 clientes i++
        for (int i = 0; i < 100 ; i++){
            cliente.setDni(20000000 + i);
            cliente.setName("Pedro" + i);
            cliente.setSurname("Sanchez" + i);
            cliente.setClientAddress("Las Rosas 333" + i + ", Don Torcuato, Buenos Aires");
            cliente.setClientPhone(1121121111 + i);
            cliente.setClientEmail("pedro" + i + "@gmail.com");

            controller.insertarCliente(cliente);
        }*/

        System.out.println("Mensaje del medio");
        //controller.insertarCliente(cliente);
        //controller.modificarCliente(28042402, 1163615454, "Libertad 885, Garin", "nori.doc.021@gmail.com");
        //controller.eliminarCliente(28042402);
        //controller.mostrarClientes();
        controller.mostrarCliente(20000099);
        controller.closeConnection();

    }
}
